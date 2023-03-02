package view;
import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController m = new RedesController();
		int opc = 0;
		String processo = "";
		String sistema = "";
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1- Checar IP; 2- Tempo de ping; 9- Finalizar."));
		
			sistema = m.os();
			
			switch (opc) {
			case 1: 
				m.ip(sistema, processo);
				break;
			case 2: 
				m.ping(sistema, processo);
				break;
			case 9:
				System.out.println("Fim do programa.");
				break;
			}
		
		} while (opc != 9);
	}

}
