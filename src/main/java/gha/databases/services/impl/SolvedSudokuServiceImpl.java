package main.java.gha.databases.services.impl;

import main.java.gha.databases.entities.SolvedSudoku;
import main.java.gha.databases.repositories.SolvedSudokuRepository;
import main.java.gha.databases.services.SolvedSudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolvedSudokuServiceImpl implements SolvedSudokuService {

    private final SolvedSudokuRepository solvedSudokuRepository;

    public SolvedSudokuServiceImpl(SolvedSudokuRepository solvedSudokuRepository) {
        this.solvedSudokuRepository = solvedSudokuRepository;
    }

    @Override
    public List<SolvedSudoku> getAllSolvedSudokus() {
        return solvedSudokuRepository.findAll();
    }

    @Override
    public SolvedSudoku createSolvedSudoku(SolvedSudoku solvedSudoku) {
        return solvedSudokuRepository.save(solvedSudoku);
    }

    @Override
    public SolvedSudoku updateSolvedSudoku(long id, SolvedSudoku solvedSudokuRequest) {
        SolvedSudoku solvedSudoku = solvedSudokuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SolvedSudoku id" + id));

        solvedSudoku.setCell1(solvedSudokuRequest.getCell1());
        solvedSudoku.setCell2(solvedSudokuRequest.getCell2());
        solvedSudoku.setCell3(solvedSudokuRequest.getCell3());
        solvedSudoku.setCell4(solvedSudokuRequest.getCell4());
        solvedSudoku.setCell5(solvedSudokuRequest.getCell5());
        solvedSudoku.setCell6(solvedSudokuRequest.getCell6());
        solvedSudoku.setCell7(solvedSudokuRequest.getCell7());
        solvedSudoku.setCell8(solvedSudokuRequest.getCell8());
        solvedSudoku.setCell9(solvedSudokuRequest.getCell9());

        return solvedSudokuRepository.save(solvedSudoku);
    }

    @Override
    public void deleteSolvedSudoku(long id) {
        SolvedSudoku solvedSudoku = solvedSudokuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SolvedSudoku id" + id));
        solvedSudokuRepository.delete(solvedSudoku);
    }

    @Override
    public SolvedSudoku getSolvedSudokuById(long id) {
        Optional<SolvedSudoku> result = solvedSudokuRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("SolvedSudoku id" + id);
        }
    }
}
