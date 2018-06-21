import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * La classe rappresenta un Collaboratore
 * Per ogni collaboratore si memorizzano: il codice identificativo, in nome, il servizio 
 * e la data in cui si e' iscritto.
 * La classe espone diversi metodi per impostare i parametri o restituirli e toString per 
 * esportare il collaboratore come stringa nel formato 'codice Identificativo; nome; servizio; data'.
 * 
 * @author Simone Giacomini
 * @version 1.0
 */
public class Collaboratore implements Serializable
{
	
	
	private int codiceIdentificativo;
	private String nome;
	private String servizio;
	private LocalDate data;
	
	/**
	 * Costruttore che permette di istanziare un nuovo oggetto di tipo Collaboratore. 
	 * @param codiceIdentificativo -> Rappresenta il codice identificativo del Collaboratore.
	 * @param nome -> Rappresenta il nome del Collaboratore.
	 * @param servizio -> Rappresenta il servizio del collaboratore.
	 * @param data -> Rappresenta la data in cui il collaboratore si e' iscritto. il formato della data e' gg-mm-aa.
	 */
	public Collaboratore (int codiceIdentificativo, String nome, String servizio, LocalDate data)
	{
		setCodiceIdentificativo(codiceIdentificativo);
		setNome(nome);
		setServizio(servizio);
		setData(data);
	}
	/**
	 * Costruttore di copia. 
	 * Permette di istanziare un nuovo Collaboratore con parametri uguali al Collaboratore Passato in input.
	 * @param c -> Rappresenta il Collaboratore da copiare.
	 */
	public Collaboratore (Collaboratore c) {
		setCodiceIdentificativo(c.getCodiceIdentificativo());
		setNome(c.getNome());
		setServizio(c.getServizio());
		setData(c.getData());
	}
	/**
	 * Costruttore vuoto. Consente di istanziare un oggetto vuoto.
	 */
	public Collaboratore ()
	{
		setCodiceIdentificativo(-1);
		setNome(null);
		setServizio(null);
		setData(null);
	}
	/**
	 * Metodo getter che restituisce il codice identificativo del Collaboratore.
	 * @return codiceIdentificativo
	 */
	public int getCodiceIdentificativo() 
	{
		return codiceIdentificativo;
	}
	/**
	 * Metodo setter che consente di impostare il codice identificativo di un Collaboratore.
	 * @param codiceIdentificativo
	 */
	public void setCodiceIdentificativo(int codiceIdentificativo) 
	{
		this.codiceIdentificativo = codiceIdentificativo;
	}
	/**
	 * Metodo getter che restituisce il nome del Collaboratore.
	 * @return nomeAzienda
	 */
	public String getNome() 
	{
		return nome;
	}
	/**
	 * Metodo setter che consente di impostare il nome del Collaboratore.
	 * @param nomeAzienda
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	/**
	 * Metodo getter che restituisce il servizio che offre il collaboratore.
	 * @return cittaSede
	 */
	public String getServizio() 
	{
		return servizio;
	}
	/**
	 * Metodo setter che consente di impostare il servizio che offre il collaboratore.
	 * @param cittaSede
	 */
	public void setServizio(String servizio)
	{
		this.servizio = servizio;
	}
	/**
	 * Metodo getter che restituisce la data in cui il collaboratore e' stato registrato.
	 * @return data
	 */
	public LocalDate getData() 
	{

		return data;
	}
	/**
	 * Metodo setter che consente di impstare la data di iscrizione di un collaboratore.
	 * @param data
	 */
	public void setData(LocalDate data) 
	{
		this.data = data;
	}
	/**
	 * Metodo che consente di esportare il collaboratore come stringa 
	 * nel formato 'codice Identificativo; nome ; Servizio; data'.
	 * @return risultato -> Rappresenta la stringa in cui sono riportati i parametri.
	 */
	public String toString ()
	{
		String risultato = "";
		risultato+= getCodiceIdentificativo() + "; "+ getNome() + "; " + getServizio() + "; " + getData();
		return risultato;
	}
	
}

