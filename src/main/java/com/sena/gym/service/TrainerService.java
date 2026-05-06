package com.sena.gym.service;

import com.sena.gym.dto.request.TrainerRequest;
import com.sena.gym.dto.response.TrainerResponse;
import com.sena.gym.entity.Trainer;
import com.sena.gym.exception.ResourceNotFoundException;
import com.sena.gym.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/** Logica de negocio para entrenadores. */
@Service
@RequiredArgsConstructor
public class TrainerService {

    private final TrainerRepository repo;

    public List<TrainerResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public TrainerResponse findById(Long id) {
        return toResponse(get(id));
    }

    public TrainerResponse create(TrainerRequest r) {
        Trainer t = new Trainer();
        set(t, r);
        return toResponse(repo.save(t));
    }

    public TrainerResponse update(Long id, TrainerRequest r) {
        Trainer t = get(id);
        set(t, r);
        return toResponse(repo.save(t));
    }

    public void delete(Long id) {
        repo.delete(get(id));
    }

    private Trainer get(Long id) {
        return repo.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Entrenador no encontrado con ID: " + id));
    }

    private void set(Trainer t, TrainerRequest r) {
        t.setFirstName(r.firstName());
        t.setLastName(r.lastName());
        t.setSpecialty(r.specialty());
        t.setPhone(r.phone());
        t.setEmail(r.email());
    }

    private TrainerResponse toResponse(Trainer t) {
        return new TrainerResponse(
            t.getId(),
            t.getFirstName(),
            t.getLastName(),
            t.getSpecialty(),
            t.getPhone(),
            t.getEmail()
        );
    }
}
