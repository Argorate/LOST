package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;

import graphe.Arete;
import graphe.Graphe;
import graphe.Sommet;

import org.junit.*;

public class test {

	@Before
	public void beforeAllTest()
	{
		System.out.println("");
		System.out.println("----------------------------- NEW TEST -----------------------------");
	}
	
	@Test
	public void testConstructeur() {
		Graphe g = new Graphe();
		assertNotNull(g.getSommets());
		assertNotNull(g.getAretes());
	}
	
	@Test
	public void testCreationSommet() {
		Graphe g = new Graphe();
		
		Arete a = new Arete(g);
		
		HashSet<Arete> HSarete = new HashSet<Arete>();
		HSarete.add(a);
		
		Sommet s1 = new Sommet(g);
		Sommet s2 = new Sommet(g);
		
		assertTrue(a.setSommet1(s1));
		assertTrue(a.setSommet2(s2));
		
		assertTrue(a.getSommet1() == s1 || a.getSommet2() == s1);
		assertTrue(a.getSommet1() == s2 || a.getSommet2() == s2);
	}
	
	@Test
	public void testCreationArete() {
		Graphe g = new Graphe();
		
		Sommet s1 = new Sommet(g);
		Sommet s2 = new Sommet(g);
		
		Arete a = new Arete(g, s1, s2);
		s1.addArete(a);
		s2.addArete(a);
		
		assertTrue(a.getSommet1() == s1 || a.getSommet2() == s1);
		assertTrue(a.getSommet1() == s2 || a.getSommet2() == s2);
		
		assertTrue(s1.getAretes().contains(a));
		assertTrue(s2.getAretes().contains(a));
	}
	
	@Test
	public void testAjoutAreteDansUnGraphe() {
		Graphe g = new Graphe();
		
		Sommet s1 = new Sommet(g);
		Sommet s2 = new Sommet(g);
		
		Arete a = new Arete(g, s1, s2);
		s1.addArete(a);
		s2.addArete(a);
		
		g.addArete(a);
		
		Arete areteGraphe = null;
		Iterator<Arete> i = g.getAretes().iterator();
		boolean bool = true;
		while(i.hasNext() && bool)
		{
			areteGraphe = i.next();
			bool = false;
		}
		
		assertEquals(areteGraphe.getMonGraphe(), g);
		assertEquals(s1.getMonGraphe(), g);
		assertEquals(s2.getMonGraphe(), g);
		
		System.out.println(g.getSommets().toString() +' '+ g.getSommets().size());
		
		assertTrue(g.getAretes().contains(a));
		assertTrue(g.getSommets().contains(s1));
		assertTrue(g.getSommets().contains(s2));
	}

}
