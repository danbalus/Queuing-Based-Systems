import java.util.ArrayList;
import java.util.Vector;

//Pastreaza clientii din acea coada
public class Coada {
	
	private ArrayList<Client> coadaClienti = new ArrayList<Client>();
	private int timpCoada = 0;
	
	
	public Coada()
	{	
	this.timpCoada = 0;
	}
	//adauga un client in coada
	public void addClient(Client client)
	{
		this.coadaClienti.add(client);
		
		this.timpCoada = timpCoada + client.getTimpServire();
	}
	//returneaza numarul de clienti din coada.
	public int getNrClientiCoada()
	{
		return coadaClienti.size();
	}
	//returneaza timpul de asteptare final din coada.
	public int getTimpCoada()
	{ 
		return timpCoada;
	}
	//initilizeaza timpul de asteptare al cozii.
	public void setTimpCoada()
	{
		if (timpCoada > 0) 
			timpCoada--;
	}
	//scoate un client din coada.
	public  ArrayList<Client> getCoada(){
		return coadaClienti;
	}
	public void removeClient(Client client)
	{
	
		this.coadaClienti.remove(client);// metoda remove sterge primul element

	}
}
