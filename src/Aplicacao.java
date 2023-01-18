import enumeraveis.TipoDePessoa;
import enumeraveis.TipoID;
import pessoa.PessoaFisica;

public class Aplicacao {
    public static void main(String[] args) {
        PessoaFisica pessoaFisica = new PessoaFisica("Wes", TipoID.CPF, TipoDePessoa.FISICA, "123456789");
    }
}
