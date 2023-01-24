package cliente.modelos;

public enum TipoCliente {
    FISICA, JURIDICA;
    
    public static TipoCliente getTipoCliente(int input) {
        TipoCliente tipoCliente = null;
        switch (input) {
            case 1 -> tipoCliente = TipoCliente.FISICA;
            case 2 -> tipoCliente = TipoCliente.JURIDICA;
        }
        return tipoCliente;
    }
    public static TipoDoc getTipoDoc(TipoCliente tipoCliente) {
        TipoDoc tipoDoc = null;
        switch (tipoCliente) {
            case FISICA -> tipoDoc = TipoDoc.CPF;
            case JURIDICA -> tipoDoc = TipoDoc.CNPJ;
        }
        return tipoDoc;
    }
}
