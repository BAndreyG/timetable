package com.timetable.raspisaniye_timetable.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class WeekDateTest {

    @ParameterizedTest
    @ValueSource(strings = {"11.05.2020", "17.05.2020", "12.05.2020", "16.05.2020"})
    void testGetWeekDate(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate arg) throws Exception {
        LocalDate start = arg;
        LocalDate[] expResult = new LocalDate[2];
        expResult[0] = LocalDate.of(2020, 05, 11);
        expResult[1] = LocalDate.of(2020, 05, 17);
        assertArrayEquals(expResult, WeekDate.getWeekDate(start));
    }

    @ParameterizedTest
    @ValueSource(strings = {"20.05.2020", "18.05.2020"})
    void testGetWeekDateNext(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate arg) throws Exception {
        LocalDate start = arg;
        LocalDate[] expResult = new LocalDate[2];
        expResult[0] = LocalDate.of(2020, 05, 18);
        expResult[1] = LocalDate.of(2020, 05, 24);
        assertArrayEquals(expResult, WeekDate.getWeekDate(start));
    }

    @ParameterizedTest
    @ValueSource(strings = {"18.05.2020"})
    void testWeekBADDate(@JavaTimeConversionPattern("dd.MM.yyyy") LocalDate arg) throws Exception {
        LocalDate start = arg;
        LocalDate[] expResult = new LocalDate[2];
        expResult[0] = LocalDate.of(2020, 05, 11);
        expResult[1] = LocalDate.of(2020, 05, 17);
        assertNotEquals(expResult, WeekDate.getWeekDate(start));
    }

}