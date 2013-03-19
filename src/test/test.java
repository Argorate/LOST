package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;

import graphe.Arete;
import graphe.Graphe;
import graphe.Sommet;

import org.junit.*;

public class test {

	static int compteur = 1;
	
	@Before
	public void beforeAllTest()
	{
		System.out.println("");
		System.out.println("----------------------------- NEW TEST ("+ compteur +") -----------------------------");
		compteur++;
	}
	
	@Test
	public void testConstructeurGraphe() {
		Graphe g = new Graphe();
		assertNotNull(g.getSommets());
		assertNotNull(g.getAretes());
	}
	
	@Test
	public void testCreationObjet() {
		Graphe g = new Graphe();
		
		Arete a = new Arete(g);
		
		Sommet s1 = new Sommet(g);
		Sommet s2 = new Sommet(g);
		
		assertTrue(s1.getMonGraphe() == g);
		assertTrue(s2.getMonGraphe() == g);
		assertTrue(a.getMonGraphe() == g);
		assertTrue(a.getSommet1() == null);
		assertTrue(a.getSommet2() == null);
		assertFalse(g.getAretes().contains(a));
	}
	
	@Test
	public void testNewSommetsAndNewArete() {
		Graphe g = new Graphe();
		
		Sommet s1 = new Sommet(g);
		Sommet s2 = new Sommet(g);
		
		Arete a = new Arete(s1, s2);
		
		assertTrue(a.getSommet1() == s1);
		assertTrue(a.getSommet2() == s2);
		
		assertTrue(s1.getAretes().contains(a));
		assertTrue(s2.getAretes().contains(a));
		
		assertTrue(a.getMonGraphe() == s1.getMonGraphe());
		assertTrue(a.getMonGraphe() == s2.getMonGraphe());
	}
	
	@Test
	public void testNewArete() {
		Graphe g = new Graphe();
		
		Sommet s1 = new Sommet(g);
		Sommet s2 = new Sommet(g);
		
		Arete a = new Arete(s1, s2);
		
		Sommet s3 = new Sommet();
		Sommet s4 = new Sommet();
		
		Arete a2 = new Arete(s3, s4);
		
		assertTrue(a2.getMonGraphe() == null);
		assertTrue(a2.getSommet1() == null);
		assertTrue(a2.getSommet2() == null);
		
		assertTrue(s3.getMonGraphe() == null);
		assertTrue(s4.getMonGraphe() == null);
		assertTrue(s3.getAretes().size() == 0);
		assertTrue(s4.getAretes().size() == 0);
		
		g.addArete(a2);
		
		
	}

}
