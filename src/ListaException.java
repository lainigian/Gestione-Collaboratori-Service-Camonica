
public class ListaException  extends Exception 
	{
		private String messaggio;
		
		public ListaException(String messaggio)
		{
			this.messaggio=messaggio;
		}
		
		public String toString()
		{
			return messaggio;
		}
	}

