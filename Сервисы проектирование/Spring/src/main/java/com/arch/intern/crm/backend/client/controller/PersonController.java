package com.arch.intern.crm.backend.client.controller;


import com.arch.intern.crm.backend.client.model.dto.PersonDTO;
import com.arch.intern.crm.backend.client.model.dto.PersonDTO;
import com.arch.intern.crm.backend.client.model.mapper.PersonMapper;
import com.arch.intern.crm.backend.client.service.PersonService;
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
@RequestMapping("/clients")
@Tag(name = "Клиенты")
public class PersonController implements BaseController<PersonDTO> {

    private final PersonService personService;

    private PersonMapper personMapper;
    @Autowired
    public PersonController( PersonService personService) {
        this.personService = personService;
    }

    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content)})
    @GetMapping(value = "/id")
    @Override
    public ResponseEntity<PersonDTO> get(@Parameter(description = "id of user to be searched")
                                       @PathVariable Long id) {
        return new ResponseEntity<>(personMapper.toDTO(personService.find(id).get()), HttpStatus.OK);
    }


    @PostMapping
    @Override
    public ResponseEntity<PersonDTO> add(@RequestBody PersonDTO itemDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PersonDTO>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @DeleteMapping(value = "/id")
    @Override
    public ResponseEntity<PersonDTO> delete(@PathVariable Long id) {
        return null;//new ResponseEntity<>( userService.delete(id), HttpStatus.OK);
    }

    @PutMapping(value = "/id")
    @Override
    public ResponseEntity<PersonDTO> edit(@PathVariable Long id, @RequestBody PersonDTO itemDto) {
        return null;
    }


}
