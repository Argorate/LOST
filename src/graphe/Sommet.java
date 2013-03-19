package graphe;

import java.util.HashSet;
import java.util.Iterator;

public class Sommet {
	private Graphe monGraphe;
	private HashSet<Arete>aretes;
	
	public Sommet(Graphe g)
	{
		monGraphe = g;
		g.syncroAddSommet(this);
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
		
		System.out.println("[Sommet]setMonGraphe() dans Sommet de "+ g.toString() +" s'est bien passé !");
	}
	
	//###################### ARETES ######################
	public HashSet<Arete> getAretes()
	{
		return aretes;
	}
	
	//add
	public boolean addArete(Arete a, Sommet s)
	{
		if(!aretes.add(a)) System.out.println("[Sommet]WARNING ! Aretes.add() dans addArete() de "+ a.toString() +" de This ("+ this.toString() +") n'a pas réussi car est déja présent !");
		if(!s.getAretes().add(a)) System.out.println("[Sommet]WARNING ! Aretes.add() dans addArete() de "+ a.toString() +" de s ("+ s.toString() +") n'a pas réussi car est déja présent !");

		a.addSommets(this, s);
		
		System.out.println("[Sommet]addArete() de "+ a.toString() +" s'est bien passé !");
		return true;
	}
	
	public boolean syncroAddArete(Arete a)
	{
		if(a.getMonGraphe() == monGraphe)
		{
			aretes.add(a);
	
			System.out.println("[Sommet]syncroAddArete() de "+ a.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("[Sommet]ERREUR ! syncroAddArete() de "+ a.toString() +" n'a pas réussi !");
			return false;
		}
	}
	
	//remove
	public boolean removeArete(Arete a)
	{
		if(this.aretes.contains(a))
		{
			aretes.remove(a);
			a.removeSommet(this);
			
			System.out.println("[Sommet]removeArete() de "+ a.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("[Sommet]ERREUR ! removeArete() de "+ a.toString() +" n'a pas réussi !");
			return false;
		}
	}
	
	public void disconect()
	{
		monGraphe = null;
		
		Iterator<Arete> it = aretes.iterator();
		while (it.hasNext()) 
		{
			it.next().remove();
		}
	}
}
