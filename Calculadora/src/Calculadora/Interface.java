package Calculadora;

import java.awt.*;

import javax.swing.*;

public class Interface {
	
	String operacao=" ";
	Botoes botao = new Botoes();

	JFrame jf = new JFrame();
	JLabel conteudo = new JLabel();
	JLabel cima = new JLabel(" ");

	
	public void criar_janela()
	{
		//Janela
		jf.setTitle("Calculadora");
		jf.setSize(350,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		//Area de Texto
		
		JPanel painel_texto=new JPanel();
		painel_texto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
		painel_texto.setLayout(new GridLayout(3,1));
		cima.setFont(new Font("Teste", Font.PLAIN, 25));
		cima.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	
		botao.GetVazio().setFont(new Font("Teste", Font.PLAIN, 25));
		botao.GetVazio().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		painel_texto.add(cima);
		painel_texto.add(botao.tela.GetTela());
		painel_texto.add(botao.GetVazio());
		
		
		
		jf.setLayout(new BorderLayout());
		jf.add(BorderLayout.NORTH, painel_texto);
		botao.tela.imprimir();
		
		
		//Teclado
		botao.Imprimir();
		jf.add(BorderLayout.CENTER, botao.teclado);
		
	}
	public void atualizar()
	{
		conteudo=botao.tela.GetTela();
		conteudo.setText(botao.tela.GetTela().getText()+botao.operacao.getText());;
		botao.tela.SetTela(conteudo);	
	}
	
	public void Enter()
	{
		cima.setText(botao.tela.GetTela().getText()+"=");
		cima.setFont(new Font("Teste", Font.PLAIN, 15));
	}
	
	public void Resultado(String resultado)
	{
		conteudo.setText(""+resultado);;
		botao.tela.SetTela(conteudo);
	}
	
	public void Reset()
	{
		operacao=" ";
		conteudo.setText("");;
		cima.setText("  ");
		cima.setFont(new Font("Teste", Font.PLAIN, 25));
		botao.GetVazio().setFont(new Font("Teste", Font.PLAIN, 25));
		botao.vazio.setText(" ");
		
	}
	
}
