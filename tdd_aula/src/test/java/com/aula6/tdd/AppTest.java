package com.aula6.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**

 */
class AppTest {
    /**

     */
    @Test
void deveRetornarErroQuandoSenhaTiverMenosDe8Caracteres() {

    ResultadoValidacao resultado = validador.validar("Ab1!");

    assertFalse(resultado.isValida());

    assertTrue(resultado.getErros().contains(
        "A senha deve ter pelo menos 8 caracteres"
    ));
}
}
