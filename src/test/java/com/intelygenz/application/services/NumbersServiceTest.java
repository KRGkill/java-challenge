package com.intelygenz.application.services;

import com.intelygenz.aplication.services.NumbersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NumbersServiceTest {

    @Autowired
    private NumbersService numbersService;

    @Test
    public void getIntegers() {
        List<Long> expectedIntegers = List.of(15L, 7L, 3L, 5L, 1L);
        List<Long> integers = numbersService.getIntegers(1L);

        assertEquals(expectedIntegers, integers);
    }
}
