import java.util.InputMismatchException;
import java.util.Scanner;

public class regras {
	protected int[][] jogo = new int[3][3];
	protected int v = 3;
	
	public regras() {
	// TODO Auto-generated constructor stub
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				jogo[j][i] = 7;
					}
				}
			}

	public int[][] getJogo() {
		return jogo;
	}

	public void setJogo(int j, int lx, int ly) {
		jogo[lx][ly] = j;
	}
	
	public boolean validajogada(int lx, int ly) {
		if (jogo[lx][ly] == 7) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int start() {
		int v = 1, f = 0;
		do {
			
			v = lerjogada(v);
			f++;
			if(f>8) {v = 10;}
			
		} while (v < 3);
		return v;
	}
	
	public int lerjogada(int jd) {
		int l, lx = 0, ly = 0, r = 0;
		
		mostrajogo();
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.println();
		System.out.println("Jogador " + jd +", qual casa voce quer jogar?");
		System.out.println("I 1 I 2 I 3 I");
		System.out.println("I 4 I 5 I 6 I");
		System.out.println("I 7 I 8 I 9 I");
		System.out.println();
		
		try {
			l = Integer.parseInt(entrada.nextLine());	
			if(l >= 10) {
				throw new InputMismatchException();
			}
		} catch (Exception e) {
			System.out.print("Por favor coloque um numero aceitavel!");
			return lerjogada(jd);
		}
		
		if (l < 4){lx = l - 1;ly = 0;}
		if(l > 3) {lx = l-4; ly = 1;}
		if(l > 6) {lx  = l-7; ly =2;}
		
		try {
			if (validajogada(lx, ly)) {
				setJogo(jd, lx, ly);
			}else {
				System.out.print("Esse bloco já foi marcado!");
				return lerjogada(jd);
			}
		} catch (Exception e) {
			System.out.print("Não foi possivel fazer a jogada!!");
			return lerjogada(jd);
		}
		
		r = resultado();

		if(r > 0) {return r;};

		if(jd == 1) {return 2;};
		if(jd == 2) {return 1;};
		return 0;
	}
	
	public void mostrajogo() {
		char letra = ' ';
		for (int i = 0; i < 3; i++) {
			System.out.println();
			System.out.print("I ");
			for (int j = 0; j < 3; j++) {
				
				switch (jogo[j][i]) {
				case 1: letra = 'X';break;
				case 2: letra = 'O';break;
				default:letra = ' ';
				}
				
				System.out.print(letra + " I ");
				
				}
			}
		System.out.println();
		}
	
	public int resultado() {
		
		//verifica quem ganhou
		float[] g = new float [6];
		
		g[0] = jogo[0][0]+jogo[0][1]+jogo[0][2];
		g[1] = jogo[0][0]+jogo[1][0]+jogo[2][0];
		g[2] = jogo[2][0]+jogo[2][1]+jogo[2][2];
		g[3] = jogo[0][2]+jogo[1][2]+jogo[2][2];
		g[4] = jogo[0][0]+jogo[1][1]+jogo[2][2];
		g[5] = jogo[2][0]+jogo[1][1]+jogo[0][2];
		for (int i = 0; i < g.length; i++) {
			if ((g[i]/3) == 1) {
				return 3;
			}
			if ((g[i]/3) == 2) {
				return 6;
			}
		}
		return 0;
	}
	
	
}
