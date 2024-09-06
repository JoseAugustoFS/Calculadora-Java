package Calculadora;

import java.awt.Font;

public class Main{
	public static void main(String[] args)
	{
		Interface in = new Interface();
		
		Calculos calcular=new Calculos();
		
		double resultado;
		
		String texto_resultante;

		boolean mostrar_resultado=false;
		
		in.criar_janela();
		
		while(true)
		{
			if((in.botao.update)&&(mostrar_resultado==false))
			{				
				in.atualizar();
				in.botao.update=false;
			}
			if(in.botao.enter)
			{
				if(mostrar_resultado==false)
				{					
					in.Enter();
					calcular.EnviarEquacao(in.botao.tela.GetTela().getText());
					calcular.DeterminarConteudo();
					resultado=calcular.Calcular();
					if(calcular.erro)
					{
						texto_resultante="ERRO";
						
					}
					else
					{					
						texto_resultante=""+resultado;
						texto_resultante=texto_resultante.replace('.', ',');
					}
					in.Resultado(texto_resultante);
					in.botao.vazio.setText("Pressione 'Reset' para realizar outra conta!");
					in.botao.GetVazio().setFont(new Font("Teste", Font.PLAIN, 15));
				}
				mostrar_resultado=true;
				
			}
			if(in.botao.reset)
			{
				in.Reset();
				in.botao.tela.Reset();
				calcular.Reset();
				calcular.erro=false;
				in.botao.reset=false;
				mostrar_resultado=false;
				in.botao.enter=false;
			}

			try { Thread.sleep (80); } catch (InterruptedException ex) {}
		}
	}
}
