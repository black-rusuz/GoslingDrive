package ru.sfedu.goslingdrive.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sfedu.goslingdrive.utils.TestData;


public class ApiTest extends TestData {
    AbstractDataProvider dp = new DataProviderXml();

    @Test
    void test() {
    }

    @BeforeEach
    void setUp() {

        dp.insertOrder(o1);
        dp.insertOrder(o2);
    }

    @AfterEach
    void tearDown() {

        dp.deleteOrder(o1.getId());
        dp.deleteOrder(o2.getId());
    }
}
