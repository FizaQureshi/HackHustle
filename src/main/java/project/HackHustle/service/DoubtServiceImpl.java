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

public class DoubtServiceImpl implements DoubtService {

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

        return DoubtMapper.mapToDoubtDto(doubt);
    }

    @Override
    public void deleteDoubt() {
        List<Doubt> alldoubts = doubtRepository.findAll();
        List<Doubt> resolved = alldoubts.stream().filter(d -> d.getDoubtStatus().equalsIgnoreCase("resolved"))
                .toList();

        doubtRepository.deleteAll(resolved);
    }

    @Override

    public List<DoubtDto> teacherdoubtlist(Long id) {
        List<Doubt> alldoubts = doubtRepository.findAll();
        //List<Doubt> teacherlist = alldoubts.stream().filter(d->d.getTeacherID().equals(id).toList());
        List<Doubt> teacherlist = alldoubts.stream()
                .filter(d -> d.getTeacherID().equals(id))
                .toList();

        if (teacherlist.isEmpty()) {



                    throw new ResourceNotFoundException("No doubts found for teacher ID: " + id);
                }

                return teacherlist.stream().map(DoubtMapper::mapToDoubtDto).toList();
            }

            @Override
            public List<DoubtDto> studentdoubtlist (Long id){
                List<Doubt> allDoubts = doubtRepository.findAll();

                List<Doubt> studentList = allDoubts.stream()
                        .filter(d -> d.getStudentID() != null && d.getStudentID().equals(id)).toList();

                if (studentList.isEmpty()) {
                    throw new ResourceNotFoundException("No doubts found for student ID: " + id);
                }

                return studentList.stream().map(DoubtMapper::mapToDoubtDto).toList();
            }


        }


