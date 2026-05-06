package com.sena.gym.service;

import com.sena.gym.dto.request.TrainingSessionRequest;
import com.sena.gym.dto.response.*;
import com.sena.gym.entity.*;
import com.sena.gym.exception.ResourceNotFoundException;
import com.sena.gym.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/** Logica de negocio para sesiones de entrenamiento. */
@Service
@RequiredArgsConstructor
public class TrainingSessionService {

    private final TrainingSessionRepository sessionRepo;
    private final MemberRepository memberRepo;
    private final TrainerRepository trainerRepo;

    public List<TrainingSessionResponse> findAll() {
        return sessionRepo.findAll().stream().map(this::toResponse).toList();
    }

    public TrainingSessionResponse findById(Long id) {
        return toResponse(get(id));
    }

    public TrainingSessionResponse create(TrainingSessionRequest r) {
        TrainingSession s = new TrainingSession();
        set(s, r);
        return toResponse(sessionRepo.save(s));
    }

    public TrainingSessionResponse update(Long id, TrainingSessionRequest r) {
        TrainingSession s = get(id);
        set(s, r);
        return toResponse(sessionRepo.save(s));
    }

    public void delete(Long id) {
        sessionRepo.delete(get(id));
    }

    private TrainingSession get(Long id) {
        return sessionRepo.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Sesion no encontrada con ID: " + id));
    }

    private Member member(Long id) {
        return memberRepo.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Miembro no encontrado con ID: " + id));
    }

    private Trainer trainer(Long id) {
        return trainerRepo.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Entrenador no encontrado con ID: " + id));
    }

    private void set(TrainingSession s, TrainingSessionRequest r) {
        s.setSessionDate(r.sessionDate());
        s.setTrainingType(r.trainingType());
        s.setDurationMinutes(r.durationMinutes());
        s.setNotes(r.notes());
        s.setMember(member(r.memberId()));
        s.setTrainer(trainer(r.trainerId()));
    }

    private TrainingSessionResponse toResponse(TrainingSession s) {
        Member m = s.getMember();
        Trainer t = s.getTrainer();
        return new TrainingSessionResponse(
            s.getId(),
            s.getSessionDate(),
            s.getTrainingType(),
            s.getDurationMinutes(),
            s.getNotes(),
            new MemberResponse(
                m.getId(),
                m.getFirstName(),
                m.getLastName(),
                m.getDocumentNumber(),
                m.getPhone(),
                m.getEmail(),
                m.getMembershipType()
            ),
            new TrainerResponse(
                t.getId(),
                t.getFirstName(),
                t.getLastName(),
                t.getSpecialty(),
                t.getPhone(),
                t.getEmail()
            )
        );
    }
}
