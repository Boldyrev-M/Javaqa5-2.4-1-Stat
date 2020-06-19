package ru.netology.stats;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {
    int[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
    int expectedAverage = 15;
    int expectedTotal = 180;
    int expectedMaxSalesMonth = 8;
    int expectedMinSalesMonth = 9;
    int expectedBelowAverage = 5;
    int expectedAboveAverage = 5;

//    @ParameterizedTest
//    @CsvSource("8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18")

    @Test
    void totalSales() {

        StatsService service = new StatsService();
        int actual = service.totalSales(sales);
        System.out.println("Total: " + actual); // = 180
        assertEquals(expectedTotal, actual);
    }

    @Test
    void averageSalesMonth() {
        StatsService service = new StatsService();
        float actual = service.averageSalesMonth(sales);
        System.out.println("Average: " + actual); // = 15.0
        assertEquals(expectedAverage, actual);
    }

    @Test
    void maxSalesMonth() {
        StatsService service = new StatsService();
        int actual = service.maxSalesMonth(sales);
        System.out.println("Max sales in this month: " + actual); // = 8
        assertEquals(expectedMaxSalesMonth, actual);
    }

    @Test
    void minSalesMonth() {
        StatsService service = new StatsService();
        int actual = service.minSalesMonth(sales);
        System.out.println("Minimum sales in this month: " + actual); // = 7
        assertEquals(expectedMinSalesMonth, actual);

    }

    @Test
    void monthsAboveAverage() {
        StatsService service = new StatsService();
        int actual = service.monthsAboveAverage(sales);
        System.out.println("Above: " + actual); // = 5
        assertEquals(expectedAboveAverage, actual);

    }

    @Test
    void monthsBelowAverage() {
        StatsService service = new StatsService();
        int actual = service.monthsBelowAverage(sales);
        System.out.println("Below: " + actual);
        assertEquals(expectedBelowAverage, actual);
    }
}