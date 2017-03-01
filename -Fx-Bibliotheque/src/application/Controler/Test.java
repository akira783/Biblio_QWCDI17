package application.Controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.Models.Client;
import application.Models.Emprunt;
import application.Models.Livre;
import application.Models.Personne;

public class Test
{
	public static void main(String[] args)
	{
		Livre livre = new Livre(0, 100, "livre", null, null, "fantastique", true, false, new Date());
		Livre livre1 = new Livre(1, 100, "livre1", null, null, "fantastique", true, false, new Date());
		Livre livre2 = new Livre(2, 100, "livre2", null, null, "fantastique", true, false, new Date());
		Livre livre3 = new Livre(3, 100, "livre3", null, null, "fantastique", true, false, new Date());
		Client client = new Client(0, "liaqat", "waleed", 21, new Date(), 0, new Date(), null, null);
		List<Emprunt> emprunt = new ArrayList<>();
		
		client.addEmpreint(livre, 15);
		client.addEmpreint(livre1, 15);
		client.addEmpreint(livre2, 15);
		client.addEmpreint(livre3, 15);
		
		emprunt = client.getLivresEnEmprunt();
		
		for(Emprunt e : emprunt)
		{
			System.out.println(e.toString());
		}
		
	}
}
