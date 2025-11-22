package project.HackHustle.service;

import project.HackHustle.dto.DoubtDto;
import project.HackHustle.entity.Doubt;

import java.util.List;

public interface DoubtService {

    DoubtDto saveDoubt(DoubtDto doubtDto) ;
    DoubtDto updateDoubt(DoubtDto doubtDto);
    void deleteDoubt();
    List<DoubtDto> teacherdoubtlist(String id);

    List<DoubtDto> studentdoubtlist(String id);
}
