package cliente.modelos;

public enum TipoCliente {
    FISICA , JURIDICA;
    
    public static TipoCliente getTipoCliente(int input) {
        TipoCliente tipoCliente = null;
        switch (input) {
            case 1 -> tipoCliente = TipoCliente.FISICA;
            case 2 -> tipoCliente = TipoCliente.JURIDICA;
        }
        return tipoCliente;
    }
    public static TipoDocCliente getTipoDoc(TipoCliente tipoCliente) {
        TipoDocCliente tipoDocCliente = null;
        switch (tipoCliente) {
            case FISICA -> tipoDocCliente = TipoDocCliente.CPF;
            case JURIDICA -> tipoDocCliente = TipoDocCliente.CNPJ;
        }
        return tipoDocCliente;
    }
}
