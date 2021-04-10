package mc322.lab03;

public class Animacao {
	AquarioLombriga aquario;
	char[] acoes;
	int qtdAcoes;
	
	Animacao(String animar){
		int A = (animar.charAt(0) - '0') * 10 + (animar.charAt(1) - '0');
		int L = (animar.charAt(2) - '0') * 10 + (animar.charAt(3) - '0');
		int P = (animar.charAt(4) - '0') * 10 + (animar.charAt(5) - '0');
		aquario = new AquarioLombriga(A, L, P);
		
		int i;
		acoes = new char[animar.length() - 6];
		for(i = 0; i + 6 < animar.length();i++) {
			acoes[i] = animar.charAt(i + 6);
		}
		
		this.qtdAcoes = i;
	}
	
	void apresenta() {
		System.out.println(aquario.apresenta());
	}
	
	void passo(int acao) {
		if(acoes[acao] == 'M') {
			aquario.mover();			
		}
		else if(acoes[acao] == 'C') {
			aquario.crescer();			
		}
		else if(acoes[acao] == 'V') {
			aquario.virar();
		}		
	}

}
