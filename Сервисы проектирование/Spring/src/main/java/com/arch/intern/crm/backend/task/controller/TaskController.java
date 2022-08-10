package com.arch.intern.crm.backend.task.controller;

import com.arch.intern.crm.backend.task.model.dto.TaskDTO;
import com.arch.intern.crm.backend.task.service.TaskService;
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
@RequestMapping("/task")
@Tag(name = "Mенеджер задач")
public class TaskController implements BaseController<TaskDTO> {

    private final TaskService taskService;
   
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    
  
    @Operation(summary = "Get a task by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the task",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TaskDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "task not found",
                    content = @Content)})
    @GetMapping(value = "/id")
    @Override
    public ResponseEntity<TaskDTO> get(@Parameter(description = "id of task to be searched")
                                       @PathVariable Long id) {
        return null;
    }


    @PostMapping
    @Override
    public ResponseEntity<TaskDTO> add(@RequestBody TaskDTO itemDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<TaskDTO>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @DeleteMapping(value = "/id")
    @Override
    public ResponseEntity<TaskDTO> delete(@PathVariable Long id) {
        return null;
    }

    @PutMapping(value = "/id")
    @Override
    public ResponseEntity<TaskDTO> edit(@PathVariable Long id, @RequestBody TaskDTO itemDto) {
        return null;
    }


}
