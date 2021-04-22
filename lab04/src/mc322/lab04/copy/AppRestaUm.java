package mc322.lab04.copy;

public class AppRestaUm {
	public static void main(String[] args) {
		
		//criar o tabuleiro 
		Tabuleiro tab = new Tabuleiro();
		
		//ler o CSV 
		CSVReader csv = new CSVReader();
		String caminho = "/home/isabellafagioli/eclipse-workspace/Faculdade/src/mc322/lab04/testes/teste08.csv";
		csv.setDataSource(caminho);
		
		
		String[] jogadas = csv.requestCommands();	//devolve algo do tipo  {"f4:d4", "c4:e4"} 
	
		//dividir em jogadas
		int tam = jogadas.length;
		for(int i = 0; i < tam; i++) {
			//executa jogadas uma a uma 
			
			String[] comandos = jogadas[i].split(":");
			String comando1 = comandos[0];
			String comando2 = comandos[1];
			tab.ComerPeca(comando1, comando2);
		}

	}
}
