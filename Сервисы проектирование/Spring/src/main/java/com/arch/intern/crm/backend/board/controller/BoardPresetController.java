package com.arch.intern.crm.backend.board.controller;

import com.arch.intern.crm.backend.board.model.dto.BoardPresetDTO;
import com.arch.intern.crm.backend.board.service.BoardPresetService;
import com.arch.intern.crm.backend.common.interfeses.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Marchenko_DS in 25/04/2022 - 17:51
 */
@RestController
@RequestMapping("/board-preset")
@Tag(name = "Доска задач")
public class BoardPresetController implements BaseController<BoardPresetDTO> {

    private final BoardPresetService boardService;
  
    @Autowired
    public BoardPresetController(BoardPresetService boardService) {
        this.boardService = boardService;
    }

    
    @Operation(summary = "Get a board by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the board",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BoardPresetDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "board not found",
                    content = @Content)})
    @GetMapping(value = "/id")
    @Override
    public ResponseEntity<BoardPresetDTO> get(@Parameter(description = "id of board to be searched")
                                       @PathVariable Long id) {
        return null;
    }


    @PostMapping
    @Override
    public ResponseEntity<BoardPresetDTO> add(@RequestBody BoardPresetDTO itemDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<BoardPresetDTO>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @DeleteMapping(value = "/id")
    @Override
    public ResponseEntity<BoardPresetDTO> delete(@PathVariable Long id) {
        return null;
    }

    @PutMapping(value = "/id")
    @Override
    public ResponseEntity<BoardPresetDTO> edit(@PathVariable Long id, @RequestBody BoardPresetDTO itemDto) {
        return null;
    }


}
