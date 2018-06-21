
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;


import javax.xml.bind.DataBindingException;

public class MainClass {

	public static void main(String[] args)  
	{
		ConsoleInput tastiera=new ConsoleInput();
		String[] servizi= {"Babysitter","Colf","Aiuto anziani","Giardiniere","Autista","Dogsitter","Insegnanti"};
		int mese,giorno,anno;
		int sceltamenu=0;
		int sottomenu=-1;
		LocalDate d;
		
		String[] elenco= {"ESCI","Inserisci nuovo Collaboratore","Elimina Collaboratore","Visualizzazione Lista Completa" ,
				"Visualizza elenco Collaboratori in base al nome","Visualizza elenco Collaboratori in base alla data", 
				"Filtro Collaboratori in base al servizio"};
		
		Lista collab=new Lista();
		Menu m1=new Menu("LISTA COLLABORATORI",elenco);
		String nomeFile = "Lista.bin";
		
		try 
		{
			collab=collab.caricaLista(nomeFile);
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			System.out.println("Impossibile caricare la lista");
		}
		
		do 
		{
		sceltamenu=m1.scelta();			
		switch (sceltamenu) 
		{
			case 1:
				Collaboratore p=new Collaboratore();
				Menu m2=new Menu("Scegliere Servizio da assegnare al Collaboratore",servizi);
			try {
				
				System.out.println("Inserisci codice identificativo: ");
				p.setCodiceIdentificativo(tastiera.ReadInt());
				
				System.out.println("Inserisci il Cognome e Nome: ");
				p.setNome(tastiera.ReadString());
			
				sottomenu=m2.scelta();
				p.setServizio(servizi[sottomenu]);
				sottomenu=-1;
				
				
				
				System.out.println("Inserisci la data d'iscrizione");
				System.out.println("");
				
				System.out.println("Inserisci il giorno");
				giorno = tastiera.ReadInt();
				
				System.out.println("Inserisci il mese");
				mese = tastiera.ReadInt();
				
				System.out.println("Inserisci l'anno");
				anno = tastiera.ReadInt();
				d=LocalDate.of(anno, mese, giorno);
				p.setData(d);
				
				
			} 
			catch (NumberFormatException e1) 
			{
				System.out.println("Formato errato");
				break;
			} 
			catch (IOException e1)
			{
				System.out.println("Impossibile leggerere dato");
				break;
			}
			catch (DateTimeException e1)
			{
				System.out.println("Data inserita errata... OPERAZIONE ANNULLATA");
				break;
			}
			try 
			{
				collab.controllaCollaboratoreID(p);
			}
			catch (ListaException e1) 
			{
				
				System.out.println(e1.toString());
				break;
			}
			try 
			{
				collab.salvaLista("Lista.bin");
			} 
			catch (IOException e1) 
			{
				System.out.println("Impossibile salvare dati di input");
			}
				
				

			break;
		case 2:
			int c=0;
			
			try 
			{
				System.out.println("inserisci il codice identificativo del Collaboratore che desideri eliminare: ");
				c=tastiera.ReadInt();
			} catch (NumberFormatException e4) 
			{
				System.out.println("Formato inserito non corretto");
			} catch (IOException e4) 
			{
				System.out.println("Impossibile leggere dati");
			}
			
			try 
			{
				collab.eliminaCollaboratore(collab,c, "Eliminati.txt");
				
			} catch (FileException e) {
			
				System.out.println("File non trovato");
				break;
				
			}
			
			catch (NumberFormatException e1) 
			{
				System.out.println("Inserimento errato");
				break;
			} 
			catch (ClassNotFoundException e1) 
			{
				System.out.println("Classe non trovata");
				break;
			} 
			catch (ListaException e1) 
			{
				System.out.println(e1.toString());
				break;
			} 
			catch (IOException e1) 
			{
				System.out.println("Impossibile leggere dati");
				break;
			}
			try 
			{
				collab.salvaLista("Lista.bin");
			} 
			catch (IOException e1) 
			{
				System.out.println("Impossibile scrivere dati di input");
			}
			break;
			
		case 3:
			System.out.println(collab.toString());
			
			break;
		case 4:
			try {
				Collaboratore[] collabNome=new Collaboratore[collab.getElementi()];
				collabNome=collab.selectionSortCrescenteNome(collab);
				System.out.println("COLLABORATORI IN ORDINE DI NOME: ");
				for (int i = 0; i < collabNome.length; i++) 
				{
					System.out.println(collabNome[i].toString());
				}
				}
				catch (ListaException e) 
				{
					System.out.println(e.toString());
					break;
				} 
			
				break;
		case 5:
			
			try {
				Collaboratore[] collabData=new Collaboratore[collab.getElementi()];
				collabData=collab.selectionSortCrescenteData(collab);
				System.out.println("COLLABORATORI IN ORDINE DI DATA:");
				for (int i = 0; i < collabData.length; i++) 
				{
					System.out.println(collabData[i].toString());
					
				}
			
				} 
				catch (ListaException e) 
				{
					System.out.println(e.toString());
					break;
				} 
			
				break;
		case 6:
				Menu m3=new Menu("Scegliere Servizio da cercare",servizi);
			try {
				
				Collaboratore[] collabServizio=new Collaboratore[collab.getElementi()];
				sottomenu=m3.scelta();
				collabServizio=collab.getCollaboratoriServizio(servizi[sottomenu]);
				System.out.println("Collaboratori del servizio -"+servizi[sottomenu]+"-");
				for (int i = 0; i < collabServizio.length; i++) 
				{
					System.out.println(collabServizio[i].toString());
					
				}
			
				} 
				catch (ListaException e) 
				{
					System.out.println(e.toString());
					break;
				} 
			
				break;
		
		case 0:
			System.out.println("ARRIVEDERCI");
			break;
		default:
				break;
			}
		}while(sceltamenu!=0);
	}
}
