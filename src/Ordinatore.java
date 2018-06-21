
import java.io.IOException;

public class Ordinatore 
{
	public static void scambia(Lista p, int pos1, int pos2) throws ListaException
	{
		if(pos1<=0 || pos1>p.getElementi() || pos2<=0 ||pos2>p.getElementi())
		{
			throw new ListaException("Posizioni non validi");
		}
		Collaboratore p1,p2;
		p1=new Collaboratore(p.getInfo(pos1));
		
		p2=new Collaboratore(p.getInfo(pos2));
	
		p.inserisciInPosizione(p1, pos2);
		p.inserisciInPosizione(p2, pos1);
		
		p.eliminaInPosizione(pos2+2);
		p.eliminaInPosizione(pos1+1);
	}
	private static Lista copiaLista(Lista p1) throws IOException,ClassNotFoundException 
	{
		Lista p2=new Lista();
		p1.salvaLista(("copia.bin"));
		p2=p2.caricaLista(("copia.bin"));
		return p2;
	}
	public static Lista selectionSortCrescenteData(Lista p) throws ClassNotFoundException, IOException, FileException, ListaException
	{
		Lista copia= copiaLista(p);
		
		boolean scambio;
		
		do
		{
			scambio=false;
			
			for (int i = 1; i < copia.getElementi(); i++) 
			{
				if(copia.getInfo(i).getData().isAfter(copia.getInfo(i+1).getData()))
				{
					scambia(copia,i,i+1);
					scambio=true;
				}
						
					
			}
		} while (scambio==true);
		return copia;
	}
	public static Lista selectionSortDecrescenteData(Lista p) throws ClassNotFoundException, IOException, FileException, ListaException
	{
		Lista copia= copiaLista(p);
		
		boolean scambio;
		
		do
		{
			scambio=false;
			
			for (int i = 1; i < copia.getElementi(); i++) 
			{
				if(copia.getInfo(i).getData().isBefore(copia.getInfo(i+1).getData()))
				{
					scambia(copia,i,i+1);
					scambio=true;
				}
						
					
			}
		} while (scambio==true);
		return copia;
	}
	public static Collaboratore[] copiaInArray(Lista p) throws 	ListaException 
	{
		Collaboratore[] arrayCopia=new Collaboratore[p.getElementi()];
		for (int i = 1; i < p.getElementi()+1; i++) 
		{
			arrayCopia[i-1]=p.getInfo(i);	
		}
		
		return arrayCopia;
	}
	
	public static Collaboratore[] copia(Collaboratore[] array)
	{
		Collaboratore[] arrayCopia=new Collaboratore[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
		{
			arrayCopia[i]=array[i];	
		}
		return arrayCopia;
	}

	public static int scambia (Collaboratore[] array, int pos1, int pos2)
	{
		Collaboratore p;
		if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
			return -1;
		p=new Collaboratore(array[pos1]);
		array[pos1]=new Collaboratore(array[pos2]);
		array[pos2]=new Collaboratore(p);
		return 0;
	}
	}