
// ------------- Pronto! --------------- // 

// Copiei do lab pra implementar no final

public class Validacao {

    // Formatação --------------
    public static String formatacaoNum(String id) {
        id = id.replaceAll("\\.", "");
        id = id.replaceAll("\\-", "");
        id = id.replaceAll("\\/", "");
        id = id.replaceAll("\\,", "");
        id = id.replaceAll("\\(", "");
        id = id.replaceAll("\\)", "");
        return id;
    }

    // Validação Nome -----------------
    public static boolean validaNome(String nome) {
        nome = nome.replace(" ", "");
        return nome.chars().allMatch(Character::isLetter);
    }

    // Somente números
    public static boolean validaNumero(String num) {
        num = num.replace(" ", "");
        num = formatacaoNum(num);
        return (num.matches("[0-9]+")); 
    }

    // Verificação ---------------
    /*public static int digitosIguais(String[] lista) {
        int flag = 0;
        for (int i = 1; i < lista.length; i++) {
            if (lista[0].equals(lista[i])) {
            } else {
                flag = 1;
                break;
            }
        }
        return flag;
    }


    // Validação CPF ---------------
    public static int primeiroDigitoCpf(String[] cpf) {
        int aux = 0;
        for (int i = 0; i < 9; i++) {
            aux += Integer.valueOf(cpf[i]) * (10 - i);
        }
        int resto = aux % 11;
        int dig1 = 11 - resto;
        if (dig1 >= 10) dig1 = 0;
        return dig1;
    }


    public static int segundoDigitoCpf(String[] cpf) {
        int aux = 0;
        for (int i = 0; i < 10; i++) {
            aux += Integer.valueOf(cpf[i]) * (11 - i);
        }
        int resto = aux % 11;
        int dig2 = 11 - resto;
        if (dig2 >= 10) dig2 = 0;
        return dig2;
    }


    public static Boolean validaCpf(String cpf) {
        String[] lista_aux = formatacaoId(cpf).split("");
        // Verificação de 11 dígitos
        if (lista_aux.length != 11)
            return false;
        
        // Verificação de dígitos iguais
        int flag = digitosIguais(lista_aux);
        if (flag == 0) return false;

        // Calculando 1° dígito verificador
        int dig1 = primeiroDigitoCpf(lista_aux);
        if (dig1 != Integer.valueOf(lista_aux[9])) return false;

        // Calculando 2° dígito verificador
        int dig2 = segundoDigitoCpf(lista_aux);
        if (dig2 != Integer.valueOf(lista_aux[10])) return false;

        return true;
    }

    // Validação CNPJ -------------------
    public static int segundoDigitoCnpj(String[] cnpj) {
        int[] aux = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int temp = 0;
        for (int i = 0; i < 13; i++) {
            temp += Integer.valueOf(cnpj[i]) * aux[i];
        }
        int resto = temp % 11;
        int dig2 = 11 - resto;
        if (dig2 >= 10) dig2 = 0;
        return dig2;
    }


    public static int primeitoDigitoCnpj(String[] cnpj) {
        int[] aux = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int temp = 0;
        for (int i = 0; i < 12; i++) {
            temp += Integer.valueOf(cnpj[i]) * aux[i];
        }
        int resto = temp % 11;
        int dig1 = 11 - resto;
        if (dig1 >= 10) dig1 = 0;
        return dig1;
    }


    public static Boolean validaCnpj(String cnpj) {
        String[] lista_aux = formatacaoId(cnpj).split("");
        // Verificação de 11 dígitos
        if (lista_aux.length != 14)
            return false;
        
        // Verificação de dígitos iguais
        int flag = digitosIguais(lista_aux);
        if (flag == 0) return false;

        // Calculando 1° dígito verificador
        int dig1 = primeitoDigitoCnpj(lista_aux);
        if (dig1 != Integer.valueOf(lista_aux[12])) return false;
        

        // Calculando 2° dígito verificador
        int dig2 = segundoDigitoCnpj(lista_aux);
        if (dig2 != Integer.valueOf(lista_aux[13])) return false;

        return true;
    } */

}



