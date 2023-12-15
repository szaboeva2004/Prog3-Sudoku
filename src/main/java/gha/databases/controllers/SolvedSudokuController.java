package main.java.gha.databases.controllers;

import java.util.List;
import java.util.stream.Collectors;

import main.java.gha.databases.dtos.ApiResponse;
import main.java.gha.databases.dtos.SolvedSudokuDto;
import main.java.gha.databases.entities.SolvedSudoku;
import main.java.gha.databases.services.SolvedSudokuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sudokus")
public class SolvedSudokuController {
    @Autowired
    private ModelMapper modelMapper;

    private final SolvedSudokuService solvedSudokuService;

    public SolvedSudokuController(SolvedSudokuService solvedSudokuService) {
        super();
        this.solvedSudokuService = solvedSudokuService;
    }

    @GetMapping
    public List<SolvedSudokuDto> getAllSolvedSudokus() {

        return solvedSudokuService.getAllSolvedSudokus().stream().map(s -> modelMapper.map(s, SolvedSudokuDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolvedSudokuDto> getSolvedSudokuById(@PathVariable(name = "id") Long id) {
        SolvedSudoku solvedSudoku = solvedSudokuService.getSolvedSudokuById(id);

        // convert entity to DTO
        SolvedSudokuDto solvedSudokuResponse = modelMapper.map(solvedSudoku, SolvedSudokuDto.class);

        return ResponseEntity.ok().body(solvedSudokuResponse);
    }

    @PostMapping
    public ResponseEntity<SolvedSudokuDto> createSolvedSudoku(@RequestBody SolvedSudokuDto solvedSudokuDto) {

        // convert DTO to entity
        SolvedSudoku solvedSudokuRequest = modelMapper.map(solvedSudokuDto, SolvedSudoku.class);

        SolvedSudoku solvedSudoku = solvedSudokuService.createSolvedSudoku(solvedSudokuRequest);

        // convert entity to DTO
        SolvedSudokuDto solvedSudokuResponse = modelMapper.map(solvedSudoku, SolvedSudokuDto.class);

        return new ResponseEntity<SolvedSudokuDto>(solvedSudokuResponse, HttpStatus.CREATED);
    }

    // change the request for DTO
    // change the response for DTO
    @PutMapping("/{id}")
    public ResponseEntity<SolvedSudokuDto> updateSolvedSudoku(@PathVariable long id, @RequestBody SolvedSudokuDto solvedSudokuDto) {

        // convert DTO to Entity
        SolvedSudoku solvedSudokuRequest = modelMapper.map(solvedSudokuDto, SolvedSudoku.class);

        SolvedSudoku solvedSudoku = solvedSudokuService.updateSolvedSudoku(id, solvedSudokuRequest);

        // entity to DTO
        SolvedSudokuDto solvedSudokuResponse = modelMapper.map(solvedSudoku, SolvedSudokuDto.class);

        return ResponseEntity.ok().body(solvedSudokuResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteSolvedSudoku(@PathVariable(name = "id") Long id) {
        solvedSudokuService.deleteSolvedSudoku(id);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, "SolvedSudoku deleted successfully", HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}
