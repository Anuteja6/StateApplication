package com.example.state.stateapplication.controller;

import com.example.state.stateapplication.StateEntity.State;
import com.example.state.stateapplication.stateservice.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {

   @Autowired
    private StateService service;

    @PostMapping
    //@RequestMapping(value = {"/states"}, method = RequestMethod.POST)
    public State addState(@RequestBody State state) {
        return service.saveState(state);
    }


    /*@GetMapping("/products")
    public List<State> findAllStates() {
        return service.getStates();
    }*/

    @GetMapping("{id}")
    //@RequestMapping(value = {"/states"}, method = RequestMethod.POST)
    public State findStateById(@PathVariable long id) {
        return service.getStateById(id);
    }

    @PutMapping("{id}")
    public State updateState(@RequestBody State state) {
        return service.updateState(state);
    }

    @DeleteMapping("{id}")
    public String deleteState(@PathVariable long id){
        return service.deleteState(id);
    }
}
