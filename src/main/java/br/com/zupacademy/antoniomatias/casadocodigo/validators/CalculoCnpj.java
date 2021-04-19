package br.com.zupacademy.antoniomatias.casadocodigo.validators;

public class CalculoCnpj {
	public static boolean calculaCnpj(String documento) {
		
	Integer  num, result, sum = 0;
	Integer peso = 2;
	char dig13;
	char dig14;
	
    if (documento.equals("00000000000000") || documento.equals("11111111111111") ||
    		documento.equals("22222222222222") || documento.equals("33333333333333") ||
    		documento.equals("44444444444444") || documento.equals("55555555555555") ||
    		documento.equals("66666666666666") || documento.equals("77777777777777") ||
    		documento.equals("88888888888888") || documento.equals("99999999999999") ||
           (documento.length() != 14))
           return(false);
	
	for(int i=11;i>=0;i--) {
	 num = Integer.valueOf(documento.charAt(i) -48);
	 sum = sum + (num*peso);
	 peso = peso + 1;
	 if (peso == 10	) {
		 peso = 2;
	 }
	 
}
	result = sum % 11;
		
	 
	 if ((result ==0) || (result == 1)){
		 dig13 = '0';
	 } else dig13 = (char) ((11-result)+48);
	 
// verifica segundo digito
	 

result = 0;
sum = 0;
peso = 2;

for(int i=12;i>=0;i--) {
 num = Integer.valueOf(documento.charAt(i) -48);
 sum = sum + (num*peso);
 peso = peso + 1;
 if (peso == 10) {
	 peso = 2;
 }}
//soma e divisao
result = sum % 11;
		
	 //verifica o segundo
	 if ((result ==0) || (result == 1)){
		 dig14 = '0';
	 } else dig14 = (char) ((11-result)+48);
	 
	 System.out.println("dit13: "+dig13+" dit14: " +dig14 );
	 
	 System.out.println("dit13: "+documento.charAt(12)+" dit14: " +documento.charAt(13) );
//verificacao
if ((dig13==documento.charAt(12)) && (dig14 ==documento.charAt(13))) {
	return true;
} else return false;


	}
}

