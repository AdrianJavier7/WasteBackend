package org.example.wasteback;

import jakarta.transaction.Transactional;
import org.example.wasteback.Services.PagoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PagoServiceTest {

    @Autowired
    private PagoService pagoService;

    // test ver balance
    @Test
    @Transactional
    @DisplayName("Ver balance")
    public void verBalancePositivo() {
        assertNotNull(pagoService.getBalance(1));
    }

    @Test
    @Transactional
    @DisplayName("Ver balance")
    public void verBalanceNegativo() {
        assertThrows(RuntimeException.class, () -> pagoService.getBalance(0));
    }

}
