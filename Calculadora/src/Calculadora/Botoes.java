package Calculadora;



import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Botoes implements ActionListener {
	
	Display tela=new Display();
	public JPanel teclado= new JPanel();
	public void Imprimir()
	{
		teclado.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		
		GridLayout possicoes = new GridLayout(5,4);
		possicoes.setHgap(10);
		possicoes.setVgap(10);
		teclado.setLayout(possicoes);
		JButton botao1 =new JButton("Limpar");
		botao1.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao1);
		botao1.addActionListener(this);
		JButton botao2 =new JButton("Del");
		botao2.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		if(tela.GetTela().getText().length()==2)
		{			
			teclado.add(botao2);
		}
		botao2.addActionListener(this);
		JButton botao3 =new JButton("%");
		botao3.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao3);
		botao3.addActionListener(this);
		JButton botao4 =new JButton("+");
		botao4.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao4);
		botao4.addActionListener(this);
		JButton botao5 =new JButton("7");
		botao5.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao5);
		botao5.addActionListener(this);
		JButton botao6 =new JButton("8");
		botao6.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao6);
		botao6.addActionListener(this);
		JButton botao7 =new JButton("9");
		botao7.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao7);
		botao7.addActionListener(this);
		JButton botao8 =new JButton("-");
		botao8.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao8);
		botao8.addActionListener(this);
		JButton botao11 =new JButton("4");
		botao11.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao11);
		botao11.addActionListener(this);
		JButton botao10 =new JButton("5");
		botao10.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao10);
		botao10.addActionListener(this);
		JButton botao9 =new JButton("6");
		botao9.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao9);
		botao9.addActionListener(this);
		JButton botao12 =new JButton("*");
		botao12.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao12);
		botao12.addActionListener(this);
		JButton botao15 =new JButton("1");
		botao15.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao15);
		botao15.addActionListener(this);
		JButton botao14 =new JButton("2");
		botao14.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao14);
		botao14.addActionListener(this);
		JButton botao13 =new JButton("3");
		botao13.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao13);
		botao13.addActionListener(this);
		JButton botao16 =new JButton("/");
		botao16.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao16);
		botao16.addActionListener(this);
		JButton botao17 =new JButton(",");
		botao17.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao17);
		botao17.addActionListener(this);
		JButton botao18 =new JButton("0");
		botao18.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao18);
		botao18.addActionListener(this);
		JButton botao19 =new JButton("Reset");
		botao19.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao19);
		botao19.addActionListener(this);
		JButton botao20 =new JButton("Enter");
		botao20.setBorder(BorderFactory.createLineBorder(new Color(150,150,150), 4));
		teclado.add(botao20);
		botao20.addActionListener(this);
	}
	JLabel operacao = new JLabel();
	boolean update;
	JLabel vazio = new JLabel(" ");
	public JLabel GetVazio()
	{
		return vazio;
	}
	
	boolean enter;
	
	boolean numeral;
	
	boolean reset;
	
	int quantidade_porcento=0;	
	public void actionPerformed(ActionEvent evento)
	{
		boolean invalido;
		if((tela.GetTela().getText().length()<=28)&&(tela.GetTela().getText().length()>=2))
		{
			invalido=false;
			
			JButton botao= (JButton) evento.getSource();
			String algarismo=botao.getText();
			
			char ultimo_caracter=tela.GetTela().getText().charAt(tela.GetTela().getText().length()-1);
			String comparar=""+ultimo_caracter;
			
			if((algarismo=="Del")&&(enter==false))
			{		
				if(tela.GetTela().getText().length()>2)
				{					
					if(tela.GetTela().getText().charAt(tela.GetTela().getText().length()-1)==',')
					{
						numeral=false;
					}
					if(tela.GetTela().getText().charAt(tela.GetTela().getText().length()-1)=='%')
					{
						quantidade_porcento--;
					}
					String apagar;
					algarismo="";
					apagar=tela.GetTela().getText();
					apagar=apagar.substring(0, apagar.length()-1);
					tela.GetTela().setText(apagar);
				}
				if(tela.GetTela().getText()==" ")
				{
					operacao.setText("  ");
					tela.SetTela(operacao);
				}
			}
			else
			if((algarismo=="Limpar")&&(enter==false))
			{
				tela.GetTela().setText("  ");;
				algarismo="";
				quantidade_porcento=0;
				numeral=false;
			}
			else
			if(algarismo=="Reset")
			{
				algarismo="";
				if(enter)
				{
					reset=true;
					operacao.setText("");;
				}
			}
			else
			if(algarismo=="Enter")
			{
				if((tela.GetTela().getText().charAt(tela.GetTela().getText().length()-1)=='+')||(tela.GetTela().getText().charAt(tela.GetTela().getText().length()-1)=='-')||(tela.GetTela().getText().charAt(tela.GetTela().getText().length()-1)=='*')||(tela.GetTela().getText().charAt(tela.GetTela().getText().length()-1)=='/')||(tela.GetTela().getText().charAt(tela.GetTela().getText().length()-1)==','))
				{
					vazio.setText("Operação Invalida!");
					invalido=true;
				}
				else
				{
								
					vazio.setText(" ");
					enter=true;
	
				}
				algarismo="";
			}
			else
			{
				if((tela.GetTela().getText().length()<=27)&&(enter==false))
				{
					if((((algarismo.contains("/"))||(algarismo.contains("+"))||(algarismo.contains("-"))||(algarismo.contains("*"))||(algarismo.contains(",")))&&((comparar.contains("/"))||(comparar.contains("+"))||(comparar.contains("-"))||(comparar.contains("*"))||(comparar.contains(",")))))
					{
					}
					else
					{
						if((((algarismo.contains("/"))||(algarismo.contains("+"))||(algarismo.contains("-"))||(algarismo.contains("*"))||(algarismo.contains("%"))||(algarismo.contains(",")))&&(tela.GetTela().getText().length()==2)))
						{
						}
						else
						{
							if((((algarismo.contains("/"))||(algarismo.contains("+"))||(algarismo.contains("-"))||(algarismo.contains("*"))||(algarismo.contains("%"))))&&(numeral))
							{
								numeral=false;
							}
							if(algarismo==",")
							{
								if(numeral)
								{									
									algarismo="";
								}
								else
								{									
									numeral=true;
								}
							}
							if((algarismo=="%")&&((comparar.contains("/"))||(comparar.contains("+"))||(comparar.contains("-"))||(comparar.contains("%"))||(comparar.contains("*"))))
							{
								algarismo="";
							}
							else
							if((comparar.contains("%"))&&(!((algarismo.contains("/"))||(algarismo.contains("+"))||(algarismo.contains("-"))||(algarismo.contains("*")))))
							{
								algarismo="";
							}
							else
							{		
								if(algarismo=="%")
								{									
									quantidade_porcento++;
								}
								operacao.setText(algarismo);			
								update=true;
							}
						}
					}
				}					
			}
			if(enter==false)
			{				
				if(tela.GetTela().getText().length()==28)
				{
					vazio.setText("Tamanho Limite!!!");
				}
				else
				{
					if(invalido==false)
					{					
						vazio.setText(" ");
					}
				}
			}
		}
		tela.SetTeamanho(20-(quantidade_porcento/3));	
	}
	

}
