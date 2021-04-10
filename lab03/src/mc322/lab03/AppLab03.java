package mc322.lab03;

public class AppLab03 {
	public static void main(String[] args) {
		Animacao anim = new Animacao("080402MCMVM");
		int i;
		anim.apresenta();
		for(i = 0; i < anim.qtdAcoes; i++) {
			anim.passo(i);
			anim.apresenta();
		}
	}
}

