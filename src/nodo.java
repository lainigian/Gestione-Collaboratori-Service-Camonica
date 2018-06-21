import java.io.Serializable;
/**
 * La classe nodo rappresenta un  determinato nodo. Il nodo è costituito da 2 attributi:
 * un info e un link. Info è la componente informativa, contiene un reference a un oggetto presente nella lista,
 * mentre link è un puntatore che punta all'elemento successivo della lista. 
 * 
 * @author Simone Giacomini
 * @version 1.0
 */

public class nodo implements Serializable
{
	private Collaboratore info;
	private nodo link;
	/**
	 * Costruttore della classe nodo. Consente di istanziare un oggetto di tipo nodo.
	 * richiede un Collaboratore, che rappresenta l'attributo info della classe nodo.
	 * 
	 * @param p è un oggetto di tipo Collaboratore
	 */
	public nodo(Collaboratore p)
	{
		setInfo(p);
		link=null;
		
	}
	/**
	 * Classe che ci consente di creare un nuovo nodo nella nostra lista
	 * 
	 * @param p è un oggetto di tipo Collaboratore
	 * @param link è un oggetto di tipo nodo
	 * @return nodo è un nodo istanziato nel metodo
	 */
	private nodo creaNodo(Collaboratore p, nodo link)
	{
		nodo nodo= new nodo(p);
		nodo.setLink(link);
		return nodo;
	}
	/**
	 * Metodo di tipo getter che restituisce la componente informativa del nodo, ossia un Collaboratore
	 * @return info che rappresenta un oggetto Collaboratore
	 */
	public Collaboratore getInfo() 
	{
		return info;
	}
	/**
	 * Metodo di tipo setter che permette di settare la componente informativa del nodo
	 * @param info rappresenta il Collaboratore che rappresenterà la componente informativa del nodo
	 */
	public void setInfo(Collaboratore info) 
	{
		this.info = new Collaboratore(info);
	}
	/**
	 * Metodo di tipo getter che ritorna il link del nodo
	 * @return link rappresenta il reference al nodo successivo
	 */
	public nodo getLink() 
	{
		return link;
	}
	/**
	 * Metodo setter che permette di settare il link di un nodo
	 * @param link rappresenza il reference al nodo successivo che si vuole far assumere  al nodo
	 */
	public void setLink(nodo link) 
	{
		this.link = link;
	}
}

