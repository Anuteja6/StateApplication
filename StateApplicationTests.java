package com.example.state.stateapplication;

import com.example.state.stateapplication.StateEntity.State;
import com.example.state.stateapplication.repository.StateRepository;
import com.example.state.stateapplication.stateservice.StateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StateApplicationTests {
    @MockBean
    private StateRepository stateRepository;

    @Autowired
    private StateService stateService;

    @Test
    public void getStatesTest()
    {
        when(stateRepository.findAll()).thenReturn(Stream.of(
                new State("telangana","telugu","kuchipudi"),
                new State("kerala","malayalam","kathakali")).collect(Collectors.toList()));
        assertEquals(2,stateService.getStates().size());
    }

    @Test
    public void saveStateTest()
    {
        State state=new State("tamilnadu","tamil","baratanatyam");
        when(stateRepository.save(state)).thenReturn(state);
        assertEquals(state,stateService.saveState(state));
    }

    @Test
    public void deleteStateTest()
    {
        State state=new State("gujarat","gujarati","garba");
        stateService.deleteS(state);
        //verify(stateRepository,times(1)).delete(state);
        Mockito.verify(stateRepository,Mockito.times(1)).delete(state);
    }


}
