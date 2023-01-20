package Misc;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import Enums.TipoPessoa;

public class Formatar_CPF_CNPJ {
	
	public String formatarString(String cpf_cnpj, TipoPessoa tipoPess) throws ParseException {
		
        MaskFormatter mf = new MaskFormatter("");
        mf.setValueContainsLiteralCharacters(false);
        
        if(tipoPess == TipoPessoa.PF) {
        	mf.setMask("###.###.###-##");
        	return mf.valueToString(cpf_cnpj);
        }
        else {
        	mf.setMask("##.###.###/####-##");
        	return mf.valueToString(cpf_cnpj);
        }
    }
	
}
