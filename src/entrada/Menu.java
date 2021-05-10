package entrada;

import javax.swing.JOptionPane;

import Save_Data.SaveLog;
import armazenador.IArmazenador;
import armazenador.VetDin;
import pessoa.*;

public class Menu {

	IEntrada IE = new EntradaInterface();	
	IArmazenador IA;
	SaveLog save = new SaveLog();
	
	public Menu() {
		IA = new VetDin();
	}

	public int menuCad() {		
		int op = 0;
		String menu = "" + "1 - Inserir" + "\n2 - Remover" + "\n3 - Listar" + "\n4 - Salvar" +"\n5 - Sair";
		op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return op;
	}

	public Aluno cadastrarAluno() {	
		Aluno a;
		boolean ok = false;			
		int _idade = 0, _anoIngresso = 0, _periodo = 0;	
		String _nome = IE.getString("Nome:");			
		String _ra = "ra" + IE.getString("RA (APENAS OS NUMEROS):");	
		do {			
			try {
				ok = false;								
				_idade = IE.getInt("Idade:");			
				ok = true;								
			} catch (IllegalArgumentException e) {
				 IA.inserir("Dado Invalido");
			}
		} while (!ok); 	
		do {			
			try {
				ok = false;								
				_anoIngresso = IE.getInt("ingresso:");	
				ok = true;								
			} catch (IllegalArgumentException e) {		
				IA.inserir("Dado Invalido");
			}
		} while (!ok);	
		do {			
			try {
				ok = false;								
				_periodo = IE.getInt("Periodo:");		
				ok = true;								
			} catch (IllegalArgumentException e) {		
				IA.inserir("Dado Invalido");
			}
		} while (!ok);	
		
		a = new Aluno(_nome, _idade, _ra, _anoIngresso, _periodo);	

		return a;		
	}

	public String removerAluno() {
		String ra = "ra";
		ra += JOptionPane.showInputDialog("Digite o valor do RA, Apenas os Numeros:");	
		return ra;		
	}
	
	public void listarAlunos(Aluno cad) {
		JOptionPane.showInternalMessageDialog(null, cad);	
	}
	
	public void MSG(String s) {
		JOptionPane.showInternalMessageDialog(null, s);		
	}

	public void botCancel() {
		JOptionPane.showInternalMessageDialog(null,"Operacao Invalida", null, JOptionPane.ERROR_MESSAGE);
		IA.inserir("Operaćão Invalida");
	}
	
	public IArmazenador getIA() {
		return IA;	
	}
	
}	
