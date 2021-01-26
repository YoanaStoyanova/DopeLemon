package org.playground.dopelemon.repository;

import org.playground.dopelemon.model.RegistrationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationTokenRepository extends JpaRepository<RegistrationToken, Integer> {

    Optional<RegistrationToken> findById(Integer studentId);

    RegistrationToken saveAndFlush(RegistrationToken student);
}
