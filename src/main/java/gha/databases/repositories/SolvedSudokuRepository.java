package main.java.gha.databases.repositories;

import main.java.gha.databases.entities.SolvedSudoku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolvedSudokuRepository extends JpaRepository<SolvedSudoku, Long>{
}
