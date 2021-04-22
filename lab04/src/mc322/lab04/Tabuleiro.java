package mc322.lab04;

public class Tabuleiro {
Peca[][] tabuleiro = new Peca[7][7];
	
	Tabuleiro(){
		
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				switch (i) 
				{
	            case 0:
	            case 1:
	            case 5:
	            case 6:
	            	if(j==0 || j==1 || j==5 || j==6) {
	            		tabuleiro[i][j] = new Peca(' ');
	            	}
	            	else {
	            		tabuleiro[i][j] = new Peca('P');
	            	}
	            	break;
	            
	            case 2:
	            case 4:
	            	tabuleiro[i][j] = new Peca('P');
	            	break;
	            
	            case 3: 
	            	if(j==3) {
	            		tabuleiro[i][j] = new Peca('-');
	            	}
	            	else {
	            		tabuleiro[i][j] = new Peca('P');
	            	}
	            	break;
	            default: System.out.println("comando invalido\n");

				}
						
			}		
		}
		System.out.println("Tabuleiro Inicial: ");
		ApresentarTabuleiro();
}
		
		boolean JogadaValida(int lo, int ld, int co, int cd) {
			//f4:d4
			
			if(tabuleiro[lo][co].caractere == 'P' && tabuleiro[ld][cd].caractere == '-') {
				//se na mesma coluna
				if(co == cd) 
				{
					if(Math.abs(lo - ld) == 2)
					{
						return true;
					}
				}
				//se na mesma linha
				
				if(lo == ld) 
				{
					if(Math.abs(co - cd) == 2) 
					{
						return true;
					}
				}
			}
			return false;
		}
		
		void ComerPeca(String comando1, String comando2) {
			//pegar linhas e colunas f4:d4
			String letras = "abcdefg";
			int co = letras.indexOf(comando1.charAt(0));
			int lo = (comando1.charAt(1) - '0') - 1;	
			int cd = letras.indexOf(comando2.charAt(0));
			int ld = (comando2.charAt(1) - '0') - 1;	
			
			
			//verificar se jogada é válida 
			if(JogadaValida(lo, ld, co, cd )){
				//executa a jogada 
				
				tabuleiro[ld][cd].caractere = 'P';
				tabuleiro[lo][co].caractere = '-';
				
				
				//remover peça intermediária
				
				
				//mesma linha
				if(comando1.charAt(1) == comando2.charAt(1)) {
					int col = (co + cd)/2;
					tabuleiro[lo][col].caractere = '-';
				}
				
				//mesma coluna
				if(comando1.charAt(0) == comando2.charAt(0)) {
					int lin = (lo + ld)/2;
					tabuleiro[lin][co].caractere = '-';
				}	
				
				System.out.println("Source:" + comando1);
				System.out.println("Target:" + comando2);
			}
		
			else {
				System.out.println("Essa jogada é inválida\n");
			}
			ApresentarTabuleiro();
		}
		
		void ApresentarTabuleiro() {

            String tab = "";
            for(int i = 0; i < 7; i++) {
                tab = tab + (7-i);
                for(int j = 0; j < 7; j++) {
                    tab = tab + tabuleiro[i][j].caractere;
                }
                tab = tab + '\n';
            }
            
            System.out.print(tab);
            System.out.println(" abcdefg\n");
        }
}
