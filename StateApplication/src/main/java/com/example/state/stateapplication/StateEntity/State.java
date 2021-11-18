package com.example.state.stateapplication.StateEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="state_name")
    private String stateName;

    @Column(name="state_lang")
    private String stateLang;

    @Column(name="state_dance")
    private String stateDance;


}
