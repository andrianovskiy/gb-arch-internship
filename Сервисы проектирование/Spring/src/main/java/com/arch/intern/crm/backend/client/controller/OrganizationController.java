package com.arch.intern.crm.backend.client.controller;


import com.arch.intern.crm.backend.client.model.dto.OrgatizationDTO;
import com.arch.intern.crm.backend.client.service.OrganizationService;
import com.arch.intern.crm.backend.common.interfeses.BaseController;
import com.arch.intern.crm.backend.client.model.mapper.OrganizationMapper;
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
@RequestMapping("/organization")
@Tag(name = "Организации")
public class OrganizationController implements BaseController<OrgatizationDTO> {

    private final OrganizationService organizationService;

    private OrganizationMapper contractorMapper;
    @Autowired
    public OrganizationController(OrganizationService contractorService) {
        this.organizationService = contractorService;
    }

    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrgatizationDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content)})
    @GetMapping(value = "/id")
    @Override
    public ResponseEntity<OrgatizationDTO> get(@Parameter(description = "id of user to be searched")
                                       @PathVariable Long id) {
        return new ResponseEntity<>(contractorMapper.toDTO(organizationService.find(id).get()), HttpStatus.OK);
    }


    @PostMapping
    @Override
    public ResponseEntity<OrgatizationDTO> add(@RequestBody OrgatizationDTO itemDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<OrgatizationDTO>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @DeleteMapping(value = "/id")
    @Override
    public ResponseEntity<OrgatizationDTO> delete(@PathVariable Long id) {
        return null;//new ResponseEntity<>( userService.delete(id), HttpStatus.OK);
    }

    @PutMapping(value = "/id")
    @Override
    public ResponseEntity<OrgatizationDTO> edit(@PathVariable Long id, @RequestBody OrgatizationDTO itemDto) {
        return null;
    }


}
