package Calculadora;


import java.awt.ComponentOrientation;
import java.awt.Font;

import javax.swing.*;

public class Display {
	JLabel texto = new JLabel();
	int tamanho=20;
	public void imprimir()
	{
		texto.setFont(new Font("Teste", Font.PLAIN, tamanho));
		texto.setSize(350, 100);
		texto.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		texto.setText("  ");
	}

	public void SetTela(JLabel tela)
	{
		this.texto=tela;
	}
	public JLabel GetTela()
	{
		return texto;
	}
	public void SetTeamanho(int tamanho)
	{
		this.tamanho=tamanho;
		texto.setFont(new Font("Teste", Font.PLAIN, tamanho));
	}
	
	public void Reset()
	{
		tamanho=20;
		texto.setText("  ");
	}
}
