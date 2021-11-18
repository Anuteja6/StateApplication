package com.example.state.stateapplication.stateservice;

import com.example.state.stateapplication.StateEntity.State;
import com.example.state.stateapplication.exception.StateNotFoundException;
import com.example.state.stateapplication.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;


    public State saveState(State state) {
        return stateRepository.save(state);
    }

    public List<State> saveStates(List<State> states) {
        return stateRepository.saveAll(states);
    }

    public List<State> getStates() {
        return stateRepository.findAll();
    }

    public State getStateById(long id) {
        return stateRepository.findById(id).orElseThrow(() -> new StateNotFoundException("ID not exists"));
    }

    public String deleteState(long id){
        stateRepository.deleteById(id);
        return "state removed!!"+id;
    }

    public State updateState(State state){
        State existingState=stateRepository.findById(state.getId()).orElseThrow(()->new StateNotFoundException("Id not exists"));
        existingState.setStateName(state.getStateName());
        existingState.setStateLang(state.getStateLang());
        existingState.setStateDance(state.getStateDance());
        return stateRepository.save(existingState);
    }
}
