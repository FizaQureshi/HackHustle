package project.HackHustle.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.HackHustle.dto.DoubtDto;
import project.HackHustle.entity.Doubt;
import project.HackHustle.exception.ResourceNotFoundException;
import project.HackHustle.mapper.DoubtMapper;
import project.HackHustle.repository.DoubtRepository;

import java.util.List;

@Service
@AllArgsConstructor

public class DoubtServiceImpl implements DoubtService {

    private DoubtRepository doubtRepository;


    @Override
    public DoubtDto saveDoubt(DoubtDto doubtDto)
    {
        Doubt doubt = DoubtMapper.mapToDoubt(doubtDto);
        Doubt savedDoubt = doubtRepository.save(doubt);

        return DoubtMapper.mapToDoubtDto(savedDoubt);
    }

    @Override
    public DoubtDto updateDoubt(DoubtDto doubtDto)
    {
        Doubt doubt = doubtRepository.findById(doubtDto.getDoubtID()).orElseThrow(
                () -> new ResourceNotFoundException("Student does not exist with given id " + doubtDto.getDoubtID()));

        doubt.setDoubtStatus(doubtDto.getDoubtStatus());
        doubt.setAnswerProvided(doubtDto.getAnswerProvided());
        doubtRepository.save(doubt);

        return DoubtMapper.mapToDoubtDto(doubt);
    }


    @Override
    public void deleteDoubt(Long doubtID)
    {
        Doubt doubt = doubtRepository.findById(doubtID)
                .orElseThrow(() -> new ResourceNotFoundException("Doubt not found with ID: " + doubtID));

        doubtRepository.delete(doubt);
    }

    @Override
    public List<DoubtDto> teacherDoubtList(Long teacherID)
    {
        List<Doubt> teacherList = doubtRepository.findAll().stream()
                .filter(d -> d.getTeacher() != null && d.getTeacher().getTeacherID().equals(teacherID))
                .toList();

        if (teacherList.isEmpty())
        {
                throw new ResourceNotFoundException("No doubts found for teacher ID: " + teacherID);
        }

        return teacherList.stream().map(DoubtMapper::mapToDoubtDto).toList();
    }

    @Override
    public List<DoubtDto> studentDoubtList(Long studentId)
    {
        List<Doubt> studentList = doubtRepository.findByStudent_StudentId(studentId);

        if (studentList.isEmpty())
        {
            throw new ResourceNotFoundException("No doubts found for student ID: " + studentId);
        }
        return studentList.stream().map(DoubtMapper::mapToDoubtDto).toList();
    }

}


