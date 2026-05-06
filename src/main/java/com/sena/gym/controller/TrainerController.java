package com.sena.gym.controller;

import com.sena.gym.dto.request.TrainerRequest;
import com.sena.gym.dto.response.TrainerResponse;
import com.sena.gym.service.TrainerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/** Controlador REST para entrenadores. */
@RestController
@RequestMapping("/api/trainers")
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerService service;

    @GetMapping
    public List<TrainerResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TrainerResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerResponse create(@Valid @RequestBody TrainerRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public TrainerResponse update(@PathVariable Long id, @Valid @RequestBody TrainerRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
