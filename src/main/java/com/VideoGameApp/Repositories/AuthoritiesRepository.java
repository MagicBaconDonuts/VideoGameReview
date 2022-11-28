package com.VideoGameApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VideoGameApp.Domain.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {

}
