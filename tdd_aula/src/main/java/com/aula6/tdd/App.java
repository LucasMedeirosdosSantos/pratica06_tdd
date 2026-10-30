package com.aula6.tdd;



import java.util.ArrayList;
import java.util.List;

public class App {

    public static ResultadoValidacao validarSenha(String senha) {

        return new ResultadoValidacao(false, new ArrayList<>());
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