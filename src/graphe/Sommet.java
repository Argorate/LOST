package graphe;

import java.util.HashSet;

public class Sommet {
	private Graphe monGraphe;
	private HashSet<Arete>aretes;
	
	public Sommet(Graphe g)
	{
		monGraphe = g;
		g.addSommet(this);
		aretes = new HashSet<Arete>();
	}
	
	public Sommet()
	{
		monGraphe = null;
		aretes = new HashSet<Arete>();
	}
	
	//###################### GRAPHES ######################
	public Graphe getMonGraphe()
	{
		return monGraphe;
	}
	
	public void setMonGraphe(Graphe g)
	{
		//SUPPR CE SOMMET DE L'ANCIEN GRAPHE
		if(monGraphe != null) monGraphe.removeSommet(this);
		
		monGraphe = g;
		
		System.out.println("setMonGraphe() dans Sommet de "+ g.toString() +" s'est bien passé !");
	}
	
	//###################### ARETES ######################
	public HashSet<Arete> getAretes()
	{
		return aretes;
	}
	
	//SOMMET s doit etre ajouter avec l'arrete
	public boolean addArete(Arete a, Sommet s)
	{
		if(!aretes.add(a)) System.out.println("WARNING ! Aretes.add() dans addArete() de "+ a.toString() +" n'a pas réussi car est déja présent !");

		if(a.getSommet1() != this && a.getSommet2() != this)
		{
			boolean bool=false;
			
			if(a.getSommet1() != null && a.getSommet2() == null) bool= a.setSommet2(this);
			else bool= a.setSommet1(this);
			
			if(bool)
			{
				System.out.println("addArete() de "+ a.toString() +" s'est bien passé !");
				return true;
			}
			else 
			{
				System.out.println("ERREUR ! addArete() de "+ a.toString() +" n'a pas réussi !");
				return false;
			}
		}
		else 
		{
			System.out.println("WARNING ! addArete() de "+ a.toString() +" n'a pas réussi car est déja présent !");
			return false;
		}
	}
	
	//REMOVE L'ARRETE DU SECOND SOMMET
	public boolean removeArete(Arete a)
	{
		if( (a.getSommet1() != this && a.setSommet1(null)) || (a.getSommet2() != this && a.setSommet2(null)) )
		{
			aretes.remove(a);
			
			System.out.println("removeArete() de "+ a.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("ERREUR ! removeArete() de "+ a.toString() +" n'a pas réussi !");
			return false;
		}
	}
}
