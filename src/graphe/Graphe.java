package graphe;

import java.util.HashSet;

public class Graphe {

	private HashSet<Sommet> sommets;
	private HashSet<Arete> aretes;
	
	public Graphe()
	{
		this.sommets = new HashSet<Sommet>();
		this.aretes = new HashSet<Arete>();
	}
	
	//###################### SOMMETS ######################
	public HashSet<Sommet> getSommets()
	{
		return sommets;
	}
	
	public boolean addSommet(Sommet s)
	{
		if(s.getMonGraphe() == this)
		{
			sommets.add(s);
			s.setMonGraphe(this);
			
			System.out.println("addSommet() de "+ s.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("ERREUR ! addSommet() de "+ s.toString() +" n'a pas réussi !");
			return false;
		}
	}
	
	public boolean removeSommet(Sommet s)
	{
		if(s.getMonGraphe() == this)
		{
			sommets.remove(s);
			//ENLEVER TOUS ARRETES LIE AU SOMMET
			s.setMonGraphe(null);
			
			System.out.println("removeSommet() de "+ s.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("ERREUR ! removeSommet() de "+ s.toString() +" n'a pas réussi !");
			return false;
		}
	}
	
	public boolean createSommet()
	{
		
	}
	
	//###################### ARETES ######################
	public HashSet<Arete> getAretes()
	{
		return aretes;
	}
	
	public boolean createArete()
	{
		
	}
	
	public boolean addArete(Arete arete, Sommet s1, Sommet s2)
	{
		
	}
	
	//A REFAIRE: VERIFIER QUE LARRETE A DEUX SOMMETS ET QUE CEUX-CI SONT DANS LE GRAPHE
	public boolean addArete(Arete a)
	{
		if(!aretes.add(a)) System.out.println("WARNING ! Aretes.add() dans addArete() dans Graphe de "+ a.toString() +" n'a pas réussi car est déja présent !");
		
		if(a.getMonGraphe() != this)
		{
			a.setMonGraphe(this);
			
			System.out.println("addArete() dans Graphe de "+ a.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("WARNING ! addArete() dans Graphe de "+ a.toString() +" n'a pas réussi car est déja présent !");
			return false;
		}
	}
	
	public boolean removeArete(Arete a)
	{
		if(a.getMonGraphe() == this)
		{
			aretes.remove(a);
			a.setMonGraphe(null);
		
			System.out.println("removeArete() dans Graphe de "+ a.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("ERREUR ! removeArete() dans Graphe de "+ a.toString() +" n'a pas réussi !");
			return false;
		}
	}
}
