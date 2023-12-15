package main.java.gha.databases.services;

import main.java.gha.databases.entities.SolvedSudoku;
import org.springframework.stereotype.Service;

import java.util.List;
public interface SolvedSudokuService {
    List<SolvedSudoku> getAllSolvedSudokus();

    SolvedSudoku createSolvedSudoku(SolvedSudoku solvedSudoku);

    SolvedSudoku updateSolvedSudoku(long id, SolvedSudoku solvedSudoku);

    void deleteSolvedSudoku(long id);

    SolvedSudoku getSolvedSudokuById(long id);
}
