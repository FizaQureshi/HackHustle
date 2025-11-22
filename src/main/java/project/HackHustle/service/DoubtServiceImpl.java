package project.HackHustle.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.DoubtDto;
import project.HackHustle.entity.Doubt;
import project.HackHustle.entity.Student;
import project.HackHustle.exception.ResourceNotFoundException;
import project.HackHustle.mapper.DoubtMapper;
import project.HackHustle.repository.DoubtRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class DoubtServiceImpl implements DoubtService{

     private DoubtRepository doubtRepository;


    @Override
    public DoubtDto saveDoubt(DoubtDto doubtDto) {

        Doubt doubt = DoubtMapper.mapToDoubt(doubtDto);
        Doubt savedDoubt = doubtRepository.save(doubt);

        return DoubtMapper.mapToDoubtDto(savedDoubt);


    }

    @Override
    public DoubtDto updateDoubt(DoubtDto doubtDto) {
        Doubt doubt = doubtRepository.findById(doubtDto.getDoubtID()).orElseThrow(
                () -> new ResourceNotFoundException("Student does not exist with given id " + doubtDto.getDoubtID()));

        doubt.setDoubtStatus(doubtDto.getDoubtStatus());
        doubt.setAnswerProvided(doubtDto.getAnswerProvided());
        doubtRepository.save(doubt);

        return  DoubtMapper.mapToDoubtDto(doubt);
    }

    @Override
    public void deleteDoubt() {
        List<Doubt> alldoubts =  doubtRepository.findAll();
        List<Doubt> resolved  = alldoubts.stream().filter(d -> d.getDoubtStatus().equalsIgnoreCase("resolved"))
                .toList();

        doubtRepository.deleteAll(resolved);
    }

    @Override
    public List<DoubtDto> teacherdoubtlist(String id) {
        List<Doubt> alldoubts = doubtRepository.findAll();
        List<Doubt> teacherlist = alldoubts.stream().filter(d->d.getTeacherID().equalsIgnoreCase(id)).toList();
        if (teacherlist.isEmpty()) {
            throw new ResourceNotFoundException("No doubts found for teacher ID: " + id);
        }
        List<DoubtDto> dtoList = teacherlist.stream()
                .map(DoubtMapper::mapToDoubtDto)
                .toList();
        return dtoList;

    }
    @Override
    public List<DoubtDto> studentdoubtlist(String id) {
        List<Doubt> alldoubts = doubtRepository.findAll();
        List<Doubt> teacherlist = alldoubts.stream().filter(d->d.getStudentID().equalsIgnoreCase(id)).toList();
        if (teacherlist.isEmpty()) {
            throw new ResourceNotFoundException("No doubts found for student ID: " + id);
        }
        List<DoubtDto> dtoList = teacherlist.stream()
                .map(DoubtMapper::mapToDoubtDto)
                .toList();
        return dtoList;

    }

}
