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
			
			System.out.println("[Graphe]addSommet() de "+ s.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("[Graphe]ERREUR ! addSommet() de "+ s.toString() +" n'a pas réussi !");
			return false;
		}
	}
	
	public boolean syncroAddSommet(Sommet s)
	{
		if(s.getMonGraphe() == this)
		{
			sommets.add(s);
	
			System.out.println("[Graphe]addSommet() de "+ s.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("[Graphe]ERREUR ! addSommet() de "+ s.toString() +" n'a pas réussi !");
			return false;
		}
	}
	
	public void removeSommet(Sommet s)
	{
		sommets.remove(s);
		s.disconect();
		
		System.out.println("[Graphe]removeSommet() de "+ s.toString() +" s'est bien passé !");
	}
	
	public void createSommet()
	{
		Sommet s = new Sommet(this);
		this.addSommet(s);
	}
	
	//###################### ARETES ######################
	public HashSet<Arete> getAretes()
	{
		return aretes;
	}
	
	public void createArete(Sommet s1, Sommet s2)
	{
		Arete a = new Arete(s1, s2);
		this.addArete(a);
	}
	
	//add
	public void addArete(Arete arete, Sommet s1, Sommet s2)
	{
		arete.setSommet1(s1);
		arete.setSommet2(s2);
	}
	
	public boolean addArete(Arete a)
	{
		System.out.println(a.getSommet1());
		if(a.getSommet1() != null
		&& a.getSommet2() != null 
		&& a.getSommet1().getMonGraphe() == this
		&& a.getSommet2().getMonGraphe() == this)
		{
			if(!aretes.add(a)) System.out.println("[Graphe]WARNING ! Aretes.add() dans addArete() de "+ a.toString() +" n'a pas réussi car est déja présent !");
			a.setMonGraphe(this);
			return true;
		}
		else
		{
			System.out.println("[Graphe]ERREUR ! addArete() de "+ a.toString() +" n'a pas réussi !");
			return false;
		}
	}
	
	public boolean syncroAddArete(Arete a)
	{
		if(a.getMonGraphe() == this)
		{
			aretes.add(a);
	
			System.out.println("[Graphe]syncroAddArete() de "+ a.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("[Graphe]ERREUR ! syncroAddArete() de "+ a.toString() +" n'a pas réussi !");
			return false;
		}
	}
	
	//remove
	public void removeArete(Arete a)
	{
		aretes.remove(a);
		a.remove();
	}
}
