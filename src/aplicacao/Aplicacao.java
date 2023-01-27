package aplicacao;

import java.text.ParseException;

public class Aplicacao {
    public static void main(String[] args) throws ParseException, InterruptedException {
        Banco bancoDevMakers = new Banco();
        bancoDevMakers.iniciar();
    }
}
