package com.aula6.tdd;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static ResultadoValidacao validarSenha(String senha) {

        List<String> erros = new ArrayList<>();

        int digitos = 0;
        boolean maiuscula = false;
        boolean especial = false;

        // Verificar tamanho
        if (senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }

        // Verificar os caracteres
        for (int i = 0; i < senha.length(); i++) {

            char caractere = senha.charAt(i);

            if (Character.isDigit(caractere)) {
                digitos++;
            }

            if (Character.isUpperCase(caractere)) {
                maiuscula = true;
            }

            if (!Character.isLetterOrDigit(caractere)) {
                especial = true;
            }
        }

        // Verificar quantidade de dígitos
        if (digitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        // Verificar letra maiúscula
        if (!maiuscula) {
            erros.add("A senha deve conter pelo menos uma letra maiuscula");
        }

        // Verificar caractere especial
        if (!especial) {
            erros.add("A senha deve conter pelo menos um caractere especial");
        }

        return new ResultadoValidacao(erros.isEmpty(), erros);
    }

    public static class ResultadoValidacao {

        private boolean valida;
        private List<String> erros;

        public ResultadoValidacao(boolean valida, List<String> erros) {
            this.valida = valida;
            this.erros = erros;
        }

        public boolean isValida() {
            return valida;
        }

        public List<String> getErros() {
            return erros;
        }
    }
}