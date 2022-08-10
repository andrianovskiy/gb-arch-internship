package com.arch.intern.crm.backend.task.controller;

import com.arch.intern.crm.backend.common.interfeses.BaseController;
import com.arch.intern.crm.backend.task.model.dto.WorkFlowDTO;
import com.arch.intern.crm.backend.task.model.dto.WorkFlowDTO;
import com.arch.intern.crm.backend.task.service.TaskService;
import com.arch.intern.crm.backend.task.service.WorkFlowService;
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
 * @author Marchenko_DS in 19/05/2022 - 17:51
 */
@RestController
@RequestMapping("/work-flow")
@Tag(name = "Рабочая область")
public class WorkFlowController implements BaseController<WorkFlowDTO> {

    private final WorkFlowService workFlowService;
   
    @Autowired
    public WorkFlowController(WorkFlowService workFlowService) {
        this.workFlowService = workFlowService;
    }

    
  
    @Operation(summary = "Get a task by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the work Flow",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = WorkFlowDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "work Flow not found",
                    content = @Content)})
    @GetMapping(value = "/id")
    @Override
    public ResponseEntity<WorkFlowDTO> get(@Parameter(description = "id of task to be searched")
                                       @PathVariable Long id) {
        return null;
    }


    @PostMapping
    @Override
    public ResponseEntity<WorkFlowDTO> add(@RequestBody WorkFlowDTO itemDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<WorkFlowDTO>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @DeleteMapping(value = "/id")
    @Override
    public ResponseEntity<WorkFlowDTO> delete(@PathVariable Long id) {
        return null;
    }

    @PutMapping(value = "/id")
    @Override
    public ResponseEntity<WorkFlowDTO> edit(@PathVariable Long id, @RequestBody WorkFlowDTO itemDto) {
        return null;
    }


}
