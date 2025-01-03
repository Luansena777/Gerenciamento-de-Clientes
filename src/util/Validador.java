package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validador {

    public static boolean validarData(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false); // Garante validação rigorosa

        try {
            // Converte a data de string para Date
            Date dataConvertida = formato.parse(data);// Tenta fazer o parse da data
            Date dataAtual = new Date();

            //Verifica se a data fornecida é posterior à data atual. Se for, retorna false indicando que a data não é válida.
            if (dataConvertida.after(dataAtual)) {
                return false;
            }
            return true; // Data válida
        } catch (ParseException e) {
            return false; // Data inválida no formato ou lógica
        }
    }

    public static boolean validarCpf(String cpf) {
        //Remove caracteres não númericos
        cpf = cpf.replace(".", "").replace("-", "");

        if (cpf.length() != 11) {
            return false;
        }

        //Extrai digitos do CPF
        int[] numeros = new int[11];
        for (int i = 0; i < 11; i++) {
            numeros[i] = Character.getNumericValue(cpf.charAt(i));
        }

        //Validacao dos CPFs invalidos conhecidos
        boolean todosIguais = true;
        for (int i = 1; i < 11; i++) {
            if (numeros[i] != numeros[0]) {
                todosIguais = false;
                break;
            }
        }

        if (todosIguais) {
            return false;
        }

        //Calculo do primeiro digito verificador
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += numeros[i] * (10 - i);
        }

        int resto1 = (soma1 * 10) % 11;
        if (resto1 == 10) {
            resto1 = 0;
        }

        //Calculo do segundo digito verificador
        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += numeros[i] * (11 - i);
        }

        int resto2 = (soma2 * 10) % 11;
        if (resto2 == 10) {
            resto2 = 0;
        }

        // Verifica os dígitos verificadores
        return resto1 == numeros[9] && resto2 == numeros[10];
    }

}
