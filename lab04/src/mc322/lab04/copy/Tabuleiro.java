package mc322.lab04.copy;

public class Tabuleiro {
char[] pecas = {};
	
	Tabuleiro(){
		
		String str_pecas = "";
		for(int i = 0; i < 7; i++) {
			switch (i) 
			{
            case 0:
            case 1:
            case 5:
            case 6:
            	str_pecas = str_pecas + "  PPP  \n"; break;
            
            case 2:
            case 4:
            	str_pecas = str_pecas + "PPPPPPP\n"; break;
            
            case 3: 
            	str_pecas = str_pecas + "PPP-PPP\n"; break;
            default: System.out.println("comando invalido\n");
			
			}		
		}
		pecas = str_pecas.toCharArray();
		System.out.println("Tabuleiro Incial: ");
		ApresentarTabuleiro();
}
		
		int ObterPosicao(String posicao) {
			String letras =  "abcdefg";
			int pos_array = (7 - (posicao.charAt(1)-'0')) * 8 + letras.indexOf(posicao.charAt(0));
			return pos_array;
		}
		
		boolean JogadaValida(int origem, int destino, String comando1, String comando2) {
			//f4:d4
			
			if(pecas[origem] == 'P' && pecas[destino] == '-') {
				if(comando1.charAt(0) == comando2.charAt(0)) 
				{
					if(Math.abs(comando1.charAt(1) - comando2.charAt(1)) == 2) 
					{
						return true;
					}
				}
				
				if(comando1.charAt(1) == comando2.charAt(1)) 
				{
					if(Math.abs(comando1.charAt(0) - comando2.charAt(0)) == 2) 
					{
						return true;
					}
				}
			}			
			return false;
		}
		
		void ComerPeca(String comando1, String comando2) {
			//pegar linhas e colunas f4:d4
			
			int origem =  ObterPosicao(comando1);
			int destino =  ObterPosicao(comando2);
			
			//verificar se jogada é válida 
			if(JogadaValida(origem, destino, comando1, comando2)){
				//executa a jogada 
				
				pecas[origem] = '-';
				pecas[destino] = 'P';
				
				//remover peça intermediária
				
				int menor = ((origem < destino) ? origem : destino); 
				int pos_remover = 0;
				
				//mesma linha, andar 1 do menor
				if(comando1.charAt(1) == comando2.charAt(1)) {
					pos_remover = menor + 1;
				}
				
				//mesma coluna, andar 8 do menor
				if(comando1.charAt(0) == comando2.charAt(0)) {
					pos_remover = menor + 8;
				}
				pecas[pos_remover] = '-';	
				
				System.out.println("Source:" + comando1);
				System.out.println("Target:" + comando2);
				ApresentarTabuleiro();
			}
		
			else {
				System.out.println("Essa jogada é inválida\n");
			}
		}
		
		void ApresentarTabuleiro() {
			
			String str_pecas = new String(pecas);

			String[] linhas = str_pecas.split("\n");

			for(int i = 0; i < 7; i++) {
			    System.out.print(7-i);
			    System.out.println(linhas[i]);
			}
			System.out.println(" abcdefg\n");
		}
}
