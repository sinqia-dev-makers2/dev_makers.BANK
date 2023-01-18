package pessoa;

import enumeraveis.TipoDePessoa;
import enumeraveis.TipoID;
import interfaces.IPessoa;

public abstract class Pessoa implements IPessoa {
    private String nome;
    private TipoID tipoId;
    private TipoDePessoa tipoDePessoa;

    /*
        Adicionar mais dados pessoais se necessário
    */

    String getNome() {
        return nome;
    }

    TipoID getTipoId() {
        return tipoId;
    }

    TipoDePessoa getTipoDePessoa() {
        return tipoDePessoa;
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    void setTipoId(enumeraveis.TipoID tipoId) {
        this.tipoId = tipoId;
    }

    void setTipoDePessoa(enumeraveis.TipoDePessoa tipoDePessoa) {
        this.tipoDePessoa = tipoDePessoa;
    }
}
