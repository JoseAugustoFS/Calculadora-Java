package Calculadora;

public class Calculos {
	
	String equacao;
	double[] numeros = new double[13];
	char[] operacoes = new char[13];
	
	public void EnviarEquacao(String equacao)
	{
		this.equacao=equacao;
	}
	
	int  operacao_atual=0,numero_atual=0;
	
	boolean erro=false;
	
	public void DeterminarConteudo()
	{
		int posicao_atual,  numero_convertido=0;
		double multiplicador=0.1;
		boolean numero=true;
		for(posicao_atual=equacao.length()-1;posicao_atual>=0;posicao_atual--)
		{
			if((equacao.charAt(posicao_atual)!=' ')&&(equacao.charAt(posicao_atual)!='\n'))
			{
				switch(equacao.charAt(posicao_atual))
				{
				case '%':
					operacoes[operacao_atual]='%';
					operacao_atual++;
					break;
				case '+':
					operacoes[operacao_atual]='+';
					operacao_atual++;
					numero=false;
					break;
				case '-':
					operacoes[operacao_atual]='-';
					operacao_atual++;
					numero=false;
					break;
				case '*':
					operacoes[operacao_atual]='*';
					operacao_atual++;
					numero=false;
					break;
				case '/':
					operacoes[operacao_atual]='/';
					operacao_atual++;
					numero=false;
					break;
				default:
					if(!numero)
					{				
						numero_atual++;
						multiplicador=0.1;
						numero=true;
					}		
					if(equacao.charAt(posicao_atual)==',')
					{
						numeros[numero_atual]/=(multiplicador*10);
						multiplicador=0.1;
					}
					else
					{	
					numero_convertido=Character.getNumericValue(equacao.charAt(posicao_atual));
					multiplicador*=10;
					numeros[numero_atual]+=numero_convertido*multiplicador;
					}
					break;				
				}
			}
		}
		int quantidade_porcento=0;
		for(posicao_atual=0;posicao_atual<operacao_atual;posicao_atual++)
		{
			if(operacoes[posicao_atual]=='%')
			{
				if(posicao_atual<=1)
					numeros[posicao_atual]*=0.01;
				else
				{
					numeros[posicao_atual-(1+quantidade_porcento)]*=0.01;					
					quantidade_porcento++;
				}
				operacoes[posicao_atual]='N';
			}
		}
		for(int i=0;i<quantidade_porcento;i++)
			operacoes=OrdenarOperadores(operacoes);
	}
	public double Calcular()
	{
		
		double resultado;
		boolean termino=false;
		int conta_atual=0;
		int[] ordem = new int[13];
		ordem=DefinirOrdem();
		while((termino==false)&&(ordem[conta_atual]!=-1))
		{
				switch(operacoes[ordem[conta_atual]])
				{
				case '+':
					numeros[ordem[conta_atual]]+=numeros[ordem[conta_atual]+1];
					numeros[ordem[conta_atual]+1]=999999999999999999.999999999999999999;
					operacoes[ordem[conta_atual]]='N';
					break;
				case '-':
					numeros[ordem[conta_atual]+1]-=numeros[ordem[conta_atual]];
					numeros[ordem[conta_atual]]=numeros[ordem[conta_atual]+1];
					numeros[ordem[conta_atual]+1]=999999999999999999.999999999999999999;
					operacoes[ordem[conta_atual]]='N';
					break;
				case '*':
					numeros[ordem[conta_atual]]*=numeros[ordem[conta_atual]+1];
					numeros[ordem[conta_atual]+1]=999999999999999999.999999999999999999;
					operacoes[ordem[conta_atual]]='N';
					break;
				case '/':
					if(numeros[ordem[conta_atual]]==0)
					{
						erro=true;
					}
					else
					{					
						numeros[ordem[conta_atual]+1]/=numeros[ordem[conta_atual]];
						numeros[ordem[conta_atual]]=numeros[ordem[conta_atual]+1];
						numeros[ordem[conta_atual]+1]=999999999999999999.999999999999999999;
						operacoes[ordem[conta_atual]]='N';
					}
					break;
				case 'N':
				case '%':
				case ' ':
					break;
				default:
					termino=true;
					break;
				}
				if(erro)
				{	
					resultado=0;
					break;
				}
				operacoes=OrdenarOperadores(operacoes);
				ordem=DefinirOrdem();
				numeros=OrdenarNumeros(numeros);
		}
		resultado=numeros[0];
		return resultado;
	}


	public int[] DefinirOrdem()
	{
		int[] ordem = new int[13];
		int posicao_atual=0, conta_atual=0;
		boolean termino=false;
		while(termino==false)
		{
			switch(operacoes[conta_atual])
			{
			case '*':
				ordem[posicao_atual]=conta_atual;
				posicao_atual++;
				break;
			case '/':
			case '+':
			case '-':
			case '%':
			case 'N':
			case ' ':
				break;
			default:
				termino=true;
				break;
			}
			conta_atual++;
		}
		termino=false;
		conta_atual=0;
		while(termino==false)
		{
			switch(operacoes[conta_atual])
			{
			case '/':
				ordem[posicao_atual]=conta_atual;
				posicao_atual++;
				break;
			case '*':
			case '+':
			case '-':
			case '%':
			case 'N':
			case ' ':
				break;
			default:
				termino=true;
				break;
			}
			conta_atual++;
		}
		termino=false;
		conta_atual=0;
		while(termino==false)
		{
			switch(operacoes[conta_atual])
			{
			case '-':
				ordem[posicao_atual]=conta_atual;
				posicao_atual++;
				break;
			case '+':
			case '*':
			case '/':
			case '%':
			case 'N':
			case ' ':
				break;
			default:
				termino=true;
				break;
			}
			conta_atual++;

		}
		termino=false;
		conta_atual=0;
		while(termino==false)
		{

			switch(operacoes[conta_atual])
			{
			case '+':
				ordem[posicao_atual]=conta_atual;
				posicao_atual++;
				break;
			case '-':
			case '*':
			case '/':
			case '%':
			case 'N':
			case ' ':
				break;
			default:
				ordem[posicao_atual]=-1;
				termino=true;
				break;
			}
			conta_atual++;

		}

		return ordem;
	}
	
	public double[] OrdenarNumeros(double[] numeros)
	{
		
		int posicao;
		for(posicao=0;posicao<numero_atual;posicao++)
		{
			if(numeros[posicao]==999999999999999999.999999999999999999)
			{
				numeros[posicao]=numeros[posicao+1];
				numeros[posicao+1]=999999999999999999.999999999999999999;
			}
		}
		return numeros;
	}
	
	public char[] OrdenarOperadores(char[] operadores)
	{
		int posicao;
		for(posicao=0;posicao<operacao_atual;posicao++)
		{
			if(operadores[posicao]=='N')
			{
				operadores[posicao]=operadores[posicao+1];
				operadores[posicao+1]='N';
			}
		}
		return operadores;
	}
	
	public void Reset()
	{
		numeros=new double[13];
		operacoes=new char[13];
		equacao="";
		numero_atual=0;
		operacao_atual=0;
	}
}
