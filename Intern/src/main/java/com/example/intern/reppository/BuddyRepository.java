package com.example.intern.reppository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.Buddy;

@Repository
public interface BuddyRepository extends JpaRepository<Buddy, Long> {

}
