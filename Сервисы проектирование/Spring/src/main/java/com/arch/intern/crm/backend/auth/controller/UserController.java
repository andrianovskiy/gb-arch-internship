package com.arch.intern.crm.backend.auth.controller;


import com.arch.intern.crm.backend.auth.model.User;
import com.arch.intern.crm.backend.auth.model.dto.UserDTO;
import com.arch.intern.crm.backend.auth.model.mapper.UserMapper;
import com.arch.intern.crm.backend.auth.service.UserService;
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
@RequestMapping("/user")
@Tag(name = "Профиль пользователя")
public class UserController implements BaseController<UserDTO> {

    private final UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content)})
    @GetMapping(value = "/id")
    @Override
    public ResponseEntity<UserDTO> get(@Parameter(description = "id of user to be searched")
                                       @PathVariable Long id) {
        return new ResponseEntity<>(userMapper.toDTO(userService.find(id).get()), HttpStatus.OK);
    }


    @PostMapping
    @Override
    public ResponseEntity<UserDTO> add(@RequestBody UserDTO itemDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @DeleteMapping(value = "/id")
    @Override
    public ResponseEntity<UserDTO> delete(@PathVariable Long id) {
        return null;//new ResponseEntity<>( userService.delete(id), HttpStatus.OK);
    }

    @PutMapping(value = "/id")
    @Override
    public ResponseEntity<UserDTO> edit(@PathVariable Long id, @RequestBody UserDTO itemDto) {
        return null;
    }


}
