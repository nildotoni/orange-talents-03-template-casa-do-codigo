package br.com.zupacademy.antoniomatias.casadocodigo.validators;


public class CalculoCpf {
	public static boolean calculaCPF(String documento) {
	
	Integer  num, result, sum = 0;
	Integer peso = 10;
	char dig10;
	char dig11;
	
    if (documento.equals("00000000000") ||
    		documento.equals("11111111111") ||
    		documento.equals("22222222222") || documento.equals("33333333333") ||
    		documento.equals("44444444444") || documento.equals("55555555555") ||
    		documento.equals("66666666666") || documento.equals("77777777777") ||
    		documento.equals("88888888888") || documento.equals("99999999999") ||
            (documento.length() != 11)) {
            return false;}
	
	for(int i=0;i<9;i++) {
	 num = Integer.valueOf(documento.charAt(i) -48);
	 sum = sum + (num*peso);
	 peso = peso -1;
}
	result = 11 - (sum % 11);
		
	 
	 if ((result ==10) || (result == 11)){
		 dig10 = '0';
	 } else dig10 = (char) (result+48);
	 
// verifica segundo digito
	 

result = 0;
sum = 0;
peso = 11;

for(int i=0;i<10;i++) {
 num = Integer.valueOf(documento.charAt(i) -48);
 sum = sum + (num*peso);
 peso = peso -1;
}
//soma e divisao
result = 11 - (sum % 11);
		
	 //verifica o segundo
	 if ((result ==10) || (result == 11)){
		 dig11 = '0';
	 } else dig11 = (char) (result+48);
System.out.println("dit10: "+dig10+" dit11: " +dig11 );
	 
System.out.println("dit10: "+documento.charAt(9)+" dit11: " +documento.charAt(10) );
//verificacao
if ((dig10==documento.charAt(9)) && (dig11 ==documento.charAt(10))) {
	return true;
} else return false;


	}
}

