package graphe;

public class Arete {
	private Graphe monGraphe;
	private Sommet sommet1;
	private Sommet sommet2;
		
	public Arete()
	{
		monGraphe = null;
	}
	
	public Arete(Graphe g)
	{
		monGraphe = g;
		g.addArete(this);
	}
	
	public Arete(Sommet s1, Sommet s2)
	{
		if(s1.getMonGraphe() == s2.getMonGraphe())
		{
			setMonGraphe(s1.getMonGraphe());
			sommet1 = s1;
			sommet2 = s2;
			
			s1.syncroAddArete(this);
			s2.syncroAddArete(this);
		}
		else
		{
			System.out.println("[Arete]ERREUR Création Arete ! S1 et S2 on des Graphes différent.");
		}
	}
	
	//###################### GRAPHES ######################
	public Graphe getMonGraphe()
	{
		return monGraphe;
	}
	
	public void setMonGraphe(Graphe g)
	{
		if(g != null)
		{
			if(g != monGraphe && monGraphe != null) monGraphe.removeArete(this); //SUPPR CET ARETE DE L'ANCIEN GRAPHE
			g.syncroAddArete(this);
		}
		
		monGraphe = g;
		
		System.out.println("[Arete]setMonGraphe() dans Arete de "+ g.toString() +" s'est bien passé !");
	}
	
	//###################### SOMMET 1 ######################
	public Sommet getSommet1()
	{
		return sommet1;
	}
	
	public boolean setSommet1(Sommet s)
	{
		if(monGraphe == s.getMonGraphe())
		{
			//SUPPR CETTE ARETE DE L'ANCIEN SOMMET 1
			if(sommet1 != null && sommet1 != s) sommet1.removeArete(this);
			
			sommet1 = s;
			
			System.out.println("[Arete]setSommet1() de "+ s.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("[Arete]ERREUR ! setSommet1() de "+ s.toString() +" n'a pas réussi !");
			return false;
		}
	}
	
	//###################### SOMMET 2 ######################
	public Sommet getSommet2()
	{
		return sommet2;
	}
	
	public boolean setSommet2(Sommet s)
	{
		if(monGraphe == s.getMonGraphe())
		{
			//SUPPR CETTE ARETE DE L'ANCIEN SOMMET 2
			if(sommet2 != null && sommet2 != s) sommet2.removeArete(this);
			
			sommet2 = s;
			
			System.out.println("[Arete]setSommet2() de "+ s.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("[Arete]ERREUR ! setSommet2() de "+ s.toString() +" n'a pas réussi !");
			return false;
		}
	}
	
	//###################### ADD SOMMETS ######################
	public void addSommets(Sommet s1, Sommet s2)
	{
		//si l'arrete avait déjà des sommets, on enlève this de ceux-ci
		sommet1.removeArete(this);
		sommet2.removeArete(this);
		
		monGraphe = s1.getMonGraphe();
		sommet1 = s1;
		sommet2 = s2;
		
		System.out.println("[Arete]addSommets() de "+ s1.toString() +" et de "+ s2.toString() +" s'est bien passé !");
	}
	
	//###################### REMOVE ######################
	public void remove()
	{
		sommet1.removeArete(this);
		sommet2.removeArete(this);
		
		monGraphe = null;
		sommet1 = null;
		sommet2 = null;
	}
	
	public boolean removeSommet(Sommet s)
	{
		if(sommet1 == s || sommet2 == s)
		{
			if(sommet1 == s) sommet1 = null;
			else sommet2 = null;
			
			System.out.println("[Arete]removeSommet() de "+ s.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("[Arete]ERREUR ! removeSommet() de "+ s.toString() +" n'a pas réussi !");
			return false;
		}
	}
}
