package com.sena.gym.repository;
import com.sena.gym.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
/** Acceso a la tabla members. */
public interface MemberRepository extends JpaRepository<Member, Long> {}
