package com.example.nosqldemo.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.nosqldemo.domain.Pick;
import com.example.nosqldemo.domain.Zamowienie;
import com.example.nosqldemo.service.PickManager;
import com.example.nosqldemo.service.ZamowienieManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class ZamowienieManagerTest {
	
	@Autowired
	ZamowienieManager zamowienieManager;
	@Autowired
	PickManager pickManager;
	
	@Before
	public void before(){
		
		zamowienieManager.deleteAllZam();
		pickManager.deleteAllPicks();
		
		//ADDING PICKS
		Pick p1 = new Pick();
		p1.setCompany("Dunlop");
		p1.setName("Tortex");
		p1.setAmount(73);
		p1.setPrice(3.45);
		pickManager.addNewPick(p1);
		
		Pick p2 = new Pick();
		p2.setCompany("Wegen");
		p2.setName("Fatone");
		p2.setAmount(73);
		p2.setPrice(3.45);
		pickManager.addNewPick(p2);

		Pick p3 = new Pick();
		p3.setCompany("Dunlop");
		p3.setName("Tortex");
		p3.setAmount(73);
		p3.setPrice(3.45);
		pickManager.addNewPick(p3);
		
		Pick p4 = new Pick();
		p4.setCompany("Wegen");
		p4.setName("Fatone");
		p4.setAmount(73);
		p4.setPrice(3.45);
		pickManager.addNewPick(p4);
		
		//ADDING ORDERS
		Zamowienie z1 = new Zamowienie();
		z1.setSklep("RockNRoll");
		
		List<Pick> picks = new ArrayList<Pick>();
		picks.add(pickManager.getAllPicks().get(0));
		picks.add(pickManager.getAllPicks().get(1));
		
		z1.setPicks(picks);
		zamowienieManager.addNewZam(z1);
		
		Zamowienie z2 = new Zamowienie();
		z2.setSklep("Riff");

		picks = new ArrayList<Pick>();
		picks.add(pickManager.getAllPicks().get(2));
		picks.add(pickManager.getAllPicks().get(3));
		
		z2.setPicks(picks);
		zamowienieManager.addNewZam(z2);
		
	}
	
	@Test
	public void checkZamAdding(){
		
		List<Zamowienie> zam = zamowienieManager.getAllZam();
		
		assertEquals(2, zam.size());
		
	}
	
	@Test
	public void checkZamPickAdding(){
		
		Zamowienie zam = zamowienieManager.getAllZam().get(0);
		
		assertEquals(2, zam.getPicks().size());
		
	}
	
	@Test
	public void checkFindPickInZam(){
		
		ArrayList<Pick> picks = new ArrayList<Pick>();
		
		picks = zamowienieManager.findPickInZam("RockNRoll", "Tortex");
		
		assertEquals(1, picks.size());
		
	}
	
	@Test
	public void checkDeletePickFromZam(){
		
		zamowienieManager.deletePick("RockNRoll", "Tortex");
		
		assertEquals(1, zamowienieManager.getZam("RockNRoll").size());
		
	}

}
