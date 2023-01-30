package utilitarios;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import cliente.modelos.TipoCliente;

public class Formatar_CPF_CNPJ {
	
	public String formatarString(String cpf_cnpj, TipoCliente tipoPess) throws ParseException {
		
        MaskFormatter mf = new MaskFormatter("");
        mf.setValueContainsLiteralCharacters(false);
        
        if(tipoPess == TipoCliente.FISICA) {
        	mf.setMask("###.###.###-##");
        }
        else {
        	mf.setMask("##.###.###/####-##");
        }
        return mf.valueToString(cpf_cnpj);
    }
	
}
