package com.example.state.stateapplication.repository;

import com.example.state.stateapplication.StateEntity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Long> {
}
