
public class APP {

	public static void main(String[] args) {
		regras jogo = new regras();
		int v = 1;
		
		System.out.println("Bem vindo ao jogo da veia");
		v = jogo.start();
		
		if(v==10) {System.out.println("Empate!!");}
		else {
			v = v/3;
			System.out.println("Jogador: "+v+" Ganhou o jogo");
			jogo.mostrajogo();
		}
		
	}

}
