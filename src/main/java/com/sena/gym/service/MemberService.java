package com.sena.gym.service;

import com.sena.gym.dto.request.MemberRequest;
import com.sena.gym.dto.response.MemberResponse;
import com.sena.gym.entity.Member;
import com.sena.gym.exception.ResourceNotFoundException;
import com.sena.gym.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/** Logica de negocio para miembros. */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repo;

    public List<MemberResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public MemberResponse findById(Long id) {
        return toResponse(get(id));
    }

    public MemberResponse create(MemberRequest r) {
        Member m = new Member();
        set(m, r);
        return toResponse(repo.save(m));
    }

    public MemberResponse update(Long id, MemberRequest r) {
        Member m = get(id);
        set(m, r);
        return toResponse(repo.save(m));
    }

    public void delete(Long id) {
        repo.delete(get(id));
    }

    private Member get(Long id) {
        return repo.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Miembro no encontrado con ID: " + id));
    }

    private void set(Member m, MemberRequest r) {
        m.setFirstName(r.firstName());
        m.setLastName(r.lastName());
        m.setDocumentNumber(r.documentNumber());
        m.setPhone(r.phone());
        m.setEmail(r.email());
        m.setMembershipType(r.membershipType());
    }

    private MemberResponse toResponse(Member m) {
        return new MemberResponse(
            m.getId(),
            m.getFirstName(),
            m.getLastName(),
            m.getDocumentNumber(),
            m.getPhone(),
            m.getEmail(),
            m.getMembershipType()
        );
    }
}
