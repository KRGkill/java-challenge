package com.intelygenz.infraestructure.controller;

import com.intelygenz.aplication.services.NumbersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/numbers")
public class NumbersController {

    @Autowired
    NumbersService numbersService;

    @Operation(
            summary = "Get the Integers Sorted list",
            description = "Get the Intergers by Id"
    )
    @ApiResponse(responseCode = "200", description = "Integers Found",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class))})
    @ApiResponse(responseCode = "404", description = "Integers Not Found",
            content = {@Content(schema = @Schema())})
    @GetMapping("/integers/{id}")
    public ResponseEntity<List<Long>> integers(
            @Parameter(example = "1") @PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(numbersService.getIntegers(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
