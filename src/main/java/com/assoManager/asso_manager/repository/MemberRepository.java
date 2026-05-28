package com.assoManager.asso_manager.repository;

import models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Member> findByEmail(String email);

    List<Member> findByCotisationPaid(Boolean cotisationPaid);

}
