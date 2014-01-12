package com.example.nosqldemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.nosqldemo.domain.Pick;
import com.example.nosqldemo.service.PickManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class PickManagerTest {

	@Autowired
	PickManager pickManager;

	@Before
	public void before() {

		pickManager.deleteAllPicks();

		Pick pick = new Pick();
		pick.setCompany("Dunlop");
		pick.setName("Big Stubby");
		pick.setAmount(15);
		pick.setPrice(2.38);
		pickManager.addNewPick(pick);

		Pick pick2 = new Pick();
		pick2.setCompany("Dunlop");
		pick2.setName("Tortex");
		pick2.setAmount(73);
		pick2.setPrice(3.45);
		pickManager.addNewPick(pick2);

		Pick pick3 = new Pick();
		pick3.setCompany("Twin Picks");
		pick3.setName("Acoustic Hard");
		pick3.setAmount(41);
		pick3.setPrice(8.20);
		pickManager.addNewPick(pick3);

		Pick pick4 = new Pick();
		pick4.setCompany("Wegen");
		pick4.setName("Fatone");
		pick4.setAmount(135);
		pick4.setPrice(11.0);
		pickManager.addNewPick(pick4);

	}

	@Test
	public void checkAdding() {
		
		pickManager.deleteAllPicks();

		Pick pick = new Pick();
		pick.setCompany("Dunlop");
		pick.setName("Big Stubby");
		pick.setAmount(15);
		pick.setPrice(2.38);
		pickManager.addNewPick(pick);

		List<Pick> picks = pickManager.getAllPicks();

		assertTrue(picks.size() == 1);
	}

	@Test
	public void checkFindName() {

		List<Pick> picks = pickManager.getPicksName("Tortex");
		assertTrue(picks.size() == 1);
	}

	@Test
	public void checkDelete() {

		List<Pick> picksBefore = pickManager.getAllPicks();

		Pick pickToDelete = picksBefore.get(0);
		pickManager.deletePick(pickToDelete);

		List<Pick> picksAfter = pickManager.getAllPicks();

		assertTrue(picksAfter.size() != picksBefore.size());
	}

	@Test
	public void checkUpdate() {
		
		pickManager.updateNamePick("Tortex", "Tortuga");

		assertEquals(0, pickManager.getPicksName("Tortex").size());
		assertEquals(1, pickManager.getPicksName("Tortuga").size());
	}

	@Test
	public void checkFindBetweenPrice() {

		List<Pick> picks = pickManager.findBetweenPrice(3.0, 10.0);

		assertTrue(picks.size() == 2);
	}

	@Test
	public void checkFindPartName() {

		List<Pick> picks = pickManager.findPartName("Big");

		assertTrue(picks.size() == 1);
	}

}
