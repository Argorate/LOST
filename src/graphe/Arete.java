package graphe;

public class Arete {
	private Graphe monGraphe;
	private Sommet sommet1;
	private Sommet sommet2;
	
	//UTILISER LE GRAPHE DES SOMMETS (qui doit etre le meme)
	public Arete(Sommet s1, Sommet s2)
	{
		monGraphe = g;
		g.addArete(this);
		sommet1 = s1;
		sommet2 = s2;
	}
	
	public Arete(Graphe g)
	{
		monGraphe = g;
		g.addArete(this);
	}
	
	public Arete()
	{
		monGraphe = null;
		g.addArete(this);
	}
	
	//###################### GRAPHES ######################
	public Graphe getMonGraphe()
	{
		return monGraphe;
	}
	
	public void setMonGraphe(Graphe g)
	{
		//SUPPR CE SOMMET DE L'ANCIEN GRAPHE
		if(monGraphe != null) monGraphe.removeArete(this);
		
		monGraphe = g;
		
		System.out.println("setMonGraphe() dans Arete de "+ g.toString() +" s'est bien passé !");
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
			
			System.out.println("setSommet1() de "+ s.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("ERREUR ! setSommet1() de "+ s.toString() +" n'a pas réussi !");
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
			
			System.out.println("setSommet2() de "+ s.toString() +" s'est bien passé !");
			return true;
		}
		else
		{
			System.out.println("ERREUR ! setSommet2() de "+ s.toString() +" n'a pas réussi !");
			return false;
		}
	}
}
