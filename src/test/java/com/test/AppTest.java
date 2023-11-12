package com.test;

import org.junit.jupiter.api.*;

class AppTest {

    @DisplayName("should throw an exception")
    @Test
    void testAsyncS3CallAfterClosingConnection() {
        App app = new App();
        Assertions.assertThrows(Exception.class, app::asyncS3CallAfterClosingConnection);
    }

}