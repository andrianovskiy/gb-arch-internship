package com.arch.intern.crm.backend.requests.controller;


import com.arch.intern.crm.backend.common.interfeses.BaseController;
import com.arch.intern.crm.backend.requests.model.dto.RequestDTO;
import com.arch.intern.crm.backend.requests.service.RequestService;
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
 * @author Marchenko_DS in 07/07/2021 - 17:51
 */
@RestController
@RequestMapping("/request")
@Tag(name = "Обращения клиентов")
public class RequestsController implements BaseController<RequestDTO> {

    private final RequestService requestService;

    @Autowired
    public RequestsController( RequestService requestService) {
        this.requestService = requestService;
    }
    
    @Operation(summary = "Get a notification by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the notification",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RequestDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "notification not found",
                    content = @Content)})
    @GetMapping(value = "/id")
    @Override
    public ResponseEntity<RequestDTO> get(@Parameter(description = "id of notification to be searched")
                                       @PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @PostMapping
    @Override
    public ResponseEntity<RequestDTO> add(@RequestBody RequestDTO itemDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<RequestDTO>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @DeleteMapping(value = "/id")
    @Override
    public ResponseEntity<RequestDTO> delete(@PathVariable Long id) {
        return null;
    }

    @PutMapping(value = "/id")
    @Override
    public ResponseEntity<RequestDTO> edit(@PathVariable Long id, @RequestBody RequestDTO itemDto) {
        return null;
    }


}
