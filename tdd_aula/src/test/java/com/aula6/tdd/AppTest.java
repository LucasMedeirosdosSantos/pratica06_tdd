package com.aula6.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void deveVerificarTamanhoMinimoDaSenha() {
        App.ResultadoValidacao resultado = App.validarSenha("Ab1!");

        assertFalse(resultado.isValida());
        assertTrue(resultado.getErros().contains(
                "A senha deve ter pelo menos 8 caracteres"
        ));
    }

    @Test
    void deveVerificarQuantidadeDeDigitos() {
        App.ResultadoValidacao resultado = App.validarSenha("Abcdefg!");

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos 2 dígitos"
        ));
    }

    @Test
    void deveVerificarLetraMaiuscula() {
        App.ResultadoValidacao resultado = App.validarSenha("abcdef12!");

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos uma letra maiuscula"
        ));
    }

    @Test
    void deveVerificarCaractereEspecial() {
        App.ResultadoValidacao resultado = App.validarSenha("Abcdef12");

        assertTrue(resultado.getErros().contains(
                "A senha deve conter pelo menos um caractere especial"
        ));
    }

    @Test
    void deveAceitarSenhaValida() {
        App.ResultadoValidacao resultado = App.validarSenha("Abcdef12!");

        assertTrue(resultado.isValida());
        assertTrue(resultado.getErros().isEmpty());
    }

    @Test
    void deveRetornarMultiplosErros() {
        App.ResultadoValidacao resultado = App.validarSenha("mypass");

        assertEquals(4, resultado.getErros().size());
    }
}