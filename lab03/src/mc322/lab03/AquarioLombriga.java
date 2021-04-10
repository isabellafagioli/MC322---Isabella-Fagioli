package mc322.lab03;

public class AquarioLombriga {
	int tamAquario;
	int tamLombriga;
	int posicao;
	char lado;
	
	AquarioLombriga(int tamAquario, int tamLombriga, int posicao){
		this.tamAquario = tamAquario;
		this.tamLombriga = tamLombriga;
		this.posicao = posicao;
		
		lado = 'D';			
	}
	
	String apresenta() {	
		String representacao = new String();
		
		if(lado == 'D') {
			for(int i = 0; i < tamAquario; i++) {
				if(i < posicao - 1) {
					representacao = representacao + '#';
				}
				else if(i < posicao + tamLombriga - 2) {
					representacao = representacao +'@';
				}
				else if(i == posicao + tamLombriga - 2) {
					representacao = representacao +'0';
				}
				else {
					representacao = representacao + '#';
				}
			}	
		}
		
		else {
			for(int i = 0; i < tamAquario; i++) {
				if(i < posicao - 1) {
					representacao = representacao + '#';
				}
				else if(i == posicao - 1) {
					representacao = representacao +'0';
				}
				else if(i < posicao - 1 + tamLombriga) {
					representacao = representacao +'@';
				}
				else {
					representacao = representacao + '#';
				}
			}
		}
		return representacao;		
	}
		
	void virar() {
		if(lado == 'D') {
			lado = 'E';
		}
		else {
			lado = 'D';
		}
	}
	
	void crescer() {
		if(lado == 'D') {
			if(posicao > 1) {
				tamLombriga = tamLombriga + 1;
				posicao = posicao - 1;
			}
		}
		else {
			if(posicao + tamLombriga - 1 < tamAquario) {
				tamLombriga = tamLombriga + 1;
			}
		}
	}
	
	void mover() {
		if(lado == 'D') {
			if(posicao + tamLombriga - 1 < tamAquario) {
				posicao = posicao + 1;
			}
			else {
				virar();
			}
		}
		else {
			if(posicao > 1) {
				posicao = posicao - 1;
			}
			else {
				virar();
			}
		}		
	}		
}
