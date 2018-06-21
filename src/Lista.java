

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;
	import java.time.LocalDate;
	import java.util.Iterator;
	import java.io.BufferedReader;
	/**
	 * La classe rappresenta una Lista di collaboratori
	 * gli attributi sono: il puntatore head di tipo nodo e il numero di elementi(Collaboratori) della Lista
	 * La classe ci permette di gestire la lista dei collaboratori
	 *  
	 * @author Simone Giacomini
	 * @version 1.0
	 */
	public class Lista implements Serializable
	{
		private nodo head;
		private int elementi;
		
		/**
		 *Costruttore della lista,ci permette di creare una lista vuota
		 *ovvero senza alcun Collaboratore inserito
		 */
		public Lista()
		{
			head=null;
			elementi=0;
		}
		/**
		 * Metodo getter che restituisce il numero di elementi di cui è composta la nostra lista,
		 * ovvero il numero di collaboratori presenti nella lista
		 * @return elementi, rappresenta il numero di collaboratori presenti nella lista
		 */
		public  int getElementi()
		{
			return elementi;
		}
		/**
		 * Classe che ci consente di creare un nuovo nodo nella nostra lista
		 * 
		 * @param c è un oggetto di tipo Collaboratore
		 * @param link è un oggetto di tipo nodo
		 * @return nodo è un nodo istanziato nel metodo
		 */
		private nodo creaNodo(Collaboratore c,nodo link)
		{
			nodo nodo=new nodo(c);
			nodo.setLink(link);
			return nodo;
		}
		/**
		 * metodo che ci consente di inserire un Collaboratore
		 * in un nodo della lista
		 * 
		 * @param info è un oggetto di tipo Collaboratore e non è altro un Collaboratore che vogliamo inserire nella lista
		 */
		public void inserisciCollaboratore(Collaboratore info)
		{
			nodo p=creaNodo(info, head);
			head=p;
			elementi++;
		}
		private nodo getLinkPosizione(int posizione) throws ListaException
		{
			if (elementi==0) 
			{
				throw new ListaException("lista vuota");
			}
			if (posizione<0||posizione>elementi) 
			{
				throw new ListaException("posizione non valida");
			}
			nodo p;
			p=head;
			int n=1;
			while(p.getLink()!=null&&n<posizione)
			{
				p=p.getLink();
				n++;
			}
			return p;
		}
		public void inserisciInTesta(Collaboratore p)
		{
			nodo p1=creaNodo(p, head);
			head=p1;
			elementi++;
		}
		public String toString()
		{
			String risultato="elenco Collaboratori in Lista: ";
			if (elementi==0)
				return risultato+="LISTA VUOTA";
			nodo p=head;
			while(p!=null)
			{
				risultato+='\n'+p.getInfo().toString();
				p=p.getLink();
			}
			return risultato;
		}
		public void inserisciInCoda(Collaboratore p) throws ListaException 
		{
			if (elementi==0) 
			{
				inserisciInTesta(p);
				return;
			}
			nodo pn=creaNodo(p, null);
			nodo p1=getLinkPosizione(elementi);
			p1.setLink(pn);
			elementi++;
		}
		public void inserisciInPosizione(Collaboratore p,int posizione) throws ListaException
		{
			if (posizione==1) 
			{
				inserisciInTesta(p);
				return;
			}
			if (posizione<=0||posizione>elementi+1) 
			{
				throw new ListaException("posizione non valida");
			}
			
			if (posizione==elementi+1) 
			{
				inserisciInCoda(p);
				return;
			}
			
			nodo pn=creaNodo(p, getLinkPosizione(posizione));
			nodo nodoprecedente=getLinkPosizione(posizione-1);
			nodoprecedente.setLink(pn);
			elementi++;
		}
		public void eliminaInTesta() throws ListaException
		{
			if (elementi==0) 
			{
				throw new ListaException("lista vuota");
			}
			head=head.getLink();
			elementi--;
		}
		public void eliminaInCoda() throws ListaException
		{
			if (elementi==0) 
			{
				throw new ListaException("lista vuota");
			}
			if (elementi==1) 
			{
				eliminaInTesta();
				elementi--;
			}
			nodo penultimo=getLinkPosizione(elementi-1);
			penultimo.setLink(null);
			elementi--;
		}
		public void eliminaInPosizione(int posizione) throws ListaException
		{
			if (elementi==0) 
			{
				throw new ListaException("lista vuota");
			}
			if (posizione<=0||posizione>elementi) 
			{
				throw new ListaException("posizione non valida");
			}
			if (posizione==1)
			{
				eliminaInTesta();
				elementi--;
				return;
			}
			if (posizione==elementi)
			{
				eliminaInCoda();
				elementi--;
				return;
			}
			nodo p=getLinkPosizione(posizione);
			nodo precedente=getLinkPosizione(posizione-1);
			precedente.setLink(p.getLink());
			elementi--;
		}
		public String visita(int posizione) throws ListaException
		{
			if (elementi==0) 
			{
				throw new ListaException("lista vuota");
			}
			if (elementi<=0||posizione>elementi) 
			{
				throw new ListaException("posizione non valida");
			}
			nodo p=getLinkPosizione(posizione);
			return (p.getInfo().toString());
		}
		public Collaboratore getInfo(int posizione) throws ListaException
		{
			if (elementi==0) 
			{
				throw new ListaException("lista vuota");
			}
			if (elementi<=0||posizione>elementi) 
			{
				throw new ListaException("posizione non valida");
			}
			nodo p=getLinkPosizione(posizione);
			Collaboratore p1=new Collaboratore(p.getInfo());
			return(p1);
		}
		
		public Collaboratore[] arrayCollaboratori() throws ListaException
		{
			Collaboratore[] arrayp=new Collaboratore[elementi];
			for (int i = 0; i < arrayp.length; i++) 
			{
				nodo p1=getLinkPosizione(i+1);
				arrayp[i]=p1.getInfo();
			}
			return arrayp;
		}
		
		public static int scambia(Collaboratore[] array, int pos1, int pos2)
		{
			Collaboratore p;
			if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
				return -1;
			p=new Collaboratore(array[pos1]);
			array[pos1]=new Collaboratore(array[pos2]);
			array[pos2]=new Collaboratore(p);
			return 0;
		}
		public static String[] copia(String[] array)
		{
			String[] arrayCopia=new String[array.length];
			for (int i = 0; i < arrayCopia.length; i++) 
			{
				arrayCopia[i]=array[i];
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
		public  Collaboratore[] selectionSortCrescenteData(Lista p) throws ListaException
		{
			if (elementi==0)
			{
				throw new ListaException("Lista vuota");
			}
			Collaboratore[] array;
			array=p.arrayCollaboratori();
			Collaboratore[] arrayOrdinato=copia(array);
			for (int i = 0; i < arrayOrdinato.length-1; i++) 
			{
				for (int j = i+1; j < arrayOrdinato.length; j++) 
				{
					if(arrayOrdinato[j].getData().isBefore(arrayOrdinato[i].getData()))
						scambia(arrayOrdinato, i, j);
				}
			}
			
			return arrayOrdinato;
		}
		
		public Collaboratore[] selectionSortCrescenteNome(Lista p) throws ListaException
		{
			if (elementi==0)
			{
				throw new ListaException("Lista vuota");
			}
			Collaboratore[] array;
			array=p.arrayCollaboratori();
			Collaboratore[] arrayOrdinato=copia(array);
			for (int i = 0; i < arrayOrdinato.length-1; i++) 
			{
				for (int j = i+1; j < arrayOrdinato.length; j++) 
				{
					if (arrayOrdinato[j].getNome().compareTo(arrayOrdinato[i].getNome())<0)
					{
						scambia(arrayOrdinato, i , j);
					}
				}
			}
			return arrayOrdinato;
		}
		
		public void controllaCollaboratoreID(Collaboratore p) throws ListaException
		{
			if (elementi==0)
			{
				inserisciInTesta(p);
				return;
			}
			else
			{
				Collaboratore[] arrayp;
				arrayp=this.arrayCollaboratori();

				for (int i = 0; i < arrayp.length; i++) 
				{
					if(arrayp[i].getCodiceIdentificativo()==p.getCodiceIdentificativo())
					{
						throw new ListaException("Codice già utilizzato. Reinserire un Collaboratore con codice diverso");
					}
				}
				inserisciInCoda(p);
				System.out.println("Collaboratore inserito");
				return;
			}
		}
				
		public void salvaLista(String nomeFile) throws IOException
		{
			FileOutputStream file =new FileOutputStream(nomeFile);
			ObjectOutputStream writer=new ObjectOutputStream(file);
			writer.writeObject(this);
			writer.flush();
			file.close();
		}
		
		public Lista caricaLista (String nomeFile) throws IOException, ClassNotFoundException 
		{
			FileInputStream file=new FileInputStream(nomeFile);
			ObjectInputStream reader= new ObjectInputStream(file);
			
			Lista l1;
			
			l1=(Lista)(reader.readObject());
			file.close();
			return l1;
		}
		
		public Collaboratore getCollaboratore (int codice) throws ListaException
		{
			if(elementi==0)
				throw new ListaException("Nessun Collaboratore inserito");
			nodo p=head;
			while(p!=null)
			{
				if(p.getInfo().getCodiceIdentificativo()==codice)
					return p.getInfo();
				p=p.getLink();
			}
			throw new ListaException("Nessun Collaboratore corrisponde al codice inserito");
		}
		
		
	
		
		/**
		 * Metodoto che consente di eliminare un collaboratore dalla lista inserendo il codice identificativo.
		 * I collaboratori eliminati verranno salvati in un file di testo.
		 * Genera eccezioni se non sono presenti elementi nella lista, se il codice non e' valido e se nessun 
		 * collaboratore corrisponde al codice inserito.
		 * @param p->Rappresenta la lista dove sono caricati tutti i collaboratori
		 * @param c-> Rappresenta il codice del collaboratore da eliminare
		 * @param nomeFile -> Rappresenta il nome del file in cui saranno salvati i collaboratori eliminati
		 * @throws ListaException
		 * @throws IOException
		 * @throws FileException
		 * @throws  ClassNotFoundException,
		 * @throws FileException
		 */
		public void eliminaCollaboratore(Lista p, int c, String nomeFile) throws ListaException, NumberFormatException, IOException, ClassNotFoundException, FileException
		{
			if (elementi==0)
			{
				throw new ListaException("Nessun Collaboratore presente");
			}
			
			for (int i = 1; i <= p.getElementi(); i++) 
			{
				if (getInfo(i).getCodiceIdentificativo()==c)
				{
					Textfile file=new Textfile(nomeFile,'W');
				String CSV;
				Collaboratore collaboratore;
				collaboratore=getCollaboratore(c);
				CSV = collaboratore.getCodiceIdentificativo() + ";"+ collaboratore.getNome() + ";" + collaboratore.getServizio() + ";" + collaboratore.getData();
				file.toFile(CSV);
				file.closeFile();
					
					if (i==1)
					{
						eliminaInTesta();
						System.out.println("eliminazione avvenuta con successo");
						return;
					}
					if(i==p.getElementi())
					{
						eliminaInCoda();
						System.out.println("eliminazione avvenuta con successo");
						return;
					}
					eliminaInPosizione(i);
					System.out.println("eliminazione avvenuta con successo");
					return;
				}
			}
			throw new ListaException("Nessun Collaboratore con questo codice identificativo");
		}
		
		/**
		 * Metodo che consente di visualizzare tutti i collaboratori dello stesso Servizio, inserito come dato di input.
		 * @param servizio
		 * @return collabServizio -> Rappresenta l'array contenente i collaboratori dello stesso Servizio
		 * @throws ListaException 
		 */
		public Collaboratore[] getCollaboratoriServizio (String servizio) throws ListaException
		{
			
			if (elementi==0)
			{
				throw new ListaException("Nessun Collaboratore presente");
			}
			
			int contaCollab = 0;
			nodo p = head;
			while (p != null) 
			{
				if (p.getInfo().getServizio().compareTo(servizio)==0)
				{
					contaCollab++;
				}
			p = p.getLink();
			}
			if (contaCollab==0)
			{
				throw new ListaException("Nessun Collaboratore di tipo "+servizio+" presente");
			}
			Collaboratore[] collabServizio = new Collaboratore[contaCollab];
			p=head;
			int j = 0;
			while (p != null) 
			{
				if (p.getInfo().getServizio().compareTo(servizio)==0)
				{
					collabServizio[j] = new Collaboratore(p.getInfo());
					j++;
						
				}
				p = p.getLink();
			}
			return collabServizio;
			
			
	
			
		}
		public nodo getHead() {
			
			return head;
		}
		
}
