package cliente.modelos;

public enum TipoCliente {
    FISICA, JURIDICA;
    
    public static TipoCliente getTipoCliente(int input) {
        return switch (input) {
            case 1 -> TipoCliente.FISICA;
            case 2 -> TipoCliente.JURIDICA;
            default -> null;
        };
    }
    public static TipoDoc getTipoDoc(TipoCliente tipoCliente) {
        return switch (tipoCliente) {
            case FISICA -> TipoDoc.CPF;
            case JURIDICA -> TipoDoc.CNPJ;
        };
    }
}
