package Save_Data;

import java.io.*;
import java.util.Iterator;

import javax.swing.*;

import pessoa.Aluno;

public class DadosIn {
    
    private File file = null;
    private String arquivo = "Save_Data.txt";
    private final char separador = '|';

    public DadosIn(){
        newFile();
    }
    
    public void newFile(){
    	file = new File(arquivo);
    }
    
    public void saveData(Object vet[]){
        PrintWriter pw = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
        } catch(IOException ex) {
            System.out.println("Nao conseguiu abrir o arquivo: " + arquivo);
            return;
        } catch(Exception ex) {
            System.out.println("Erro inesperado ao tentar abrir o arquivo: " + arquivo);
            return;
        }

        try {
        	for(int i = 0; i < vet.length; i ++) {
        		Aluno a = (Aluno)vet[i];
        		textOut(pw, a);
        	}
        } catch (Exception e) {
            System.out.println("Erro inesperado ao tentar escrever no arquivo: " + arquivo);
            return;
        }finally {
            try {
                pw.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
            try {
                fos.close();
            } catch(Exception ex) {
                // Nao faz nada!
            }
        }
    }
    
    private void textOut(PrintWriter pw, Aluno a ){
    	pw.print(a.getNome());
        pw.print(separador);
        pw.print(a.getIdade());
        pw.print(separador);
        pw.print(a.getRa());
        pw.print(separador);
        pw.print(a.getAnoIngresso());
        pw.print(separador);
        pw.println(a.getPeriodo());
    }
   
}
