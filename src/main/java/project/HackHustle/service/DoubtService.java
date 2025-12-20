package project.HackHustle.service;

import project.HackHustle.dto.DoubtDto;

import java.util.List;

public interface DoubtService {

    DoubtDto saveDoubt(DoubtDto doubtDto) ;

    DoubtDto updateDoubt(DoubtDto doubtDto);

    void deleteDoubt();

    List<DoubtDto> teacherdoubtlist(Long id);

    List<DoubtDto> studentdoubtlist(Long id);
}
