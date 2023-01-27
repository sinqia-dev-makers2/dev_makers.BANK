package cliente.modelos;

public enum TipoCliente {
    FISICA, JURIDICA;
    
    public static TipoCliente getTipoCliente(int input) {
        switch (input) {
            case 1: 	return TipoCliente.FISICA;
            case 2: 	return TipoCliente.JURIDICA;
            default: 	return null;
        }
    }
    public static TipoDoc getTipoDoc(TipoCliente tipoCliente) {
        switch (tipoCliente) {
            case FISICA: 	return TipoDoc.CPF;
            case JURIDICA: 	return TipoDoc.CNPJ;
            default: 		return null;
        }
    }
}
