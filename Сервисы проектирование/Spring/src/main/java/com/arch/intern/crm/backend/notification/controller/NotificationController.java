package com.arch.intern.crm.backend.notification.controller;


import com.arch.intern.crm.backend.notification.model.dto.NotificationDTO;
import com.arch.intern.crm.backend.common.interfeses.BaseController;
import com.arch.intern.crm.backend.notification.service.NotificationService;
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
@RequestMapping("/notification")
@Tag(name = "Уведомлени")
public class NotificationController implements BaseController<NotificationDTO> {
    private final NotificationService notificationService;

    @Autowired
    
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    
    @Operation(summary = "Get a notification by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the notification",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = NotificationDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "notification not found",
                    content = @Content)})
    @GetMapping(value = "/id")
    @Override
    public ResponseEntity<NotificationDTO> get(@Parameter(description = "id of notification to be searched")
                                       @PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @PostMapping
    @Override
    public ResponseEntity<NotificationDTO> add(@RequestBody NotificationDTO itemDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<NotificationDTO>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @DeleteMapping(value = "/id")
    @Override
    public ResponseEntity<NotificationDTO> delete(@PathVariable Long id) {
        return null;
    }

    @PutMapping(value = "/id")
    @Override
    public ResponseEntity<NotificationDTO> edit(@PathVariable Long id, @RequestBody NotificationDTO itemDto) {
        return null;
    }


}
