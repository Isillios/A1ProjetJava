package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Map;
import model.element.mobile.Demon1;
import model.element.mobile.MyPlayer;

public class MobileTest {
	
	Demon1 demon; 
	
	@Before
	
	public void setUp() throws Exception{
		Map map = new Map();
		MyPlayer hero = new MyPlayer(0, map);
		demon = new Demon1(2, map, hero);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int i = 40;
		String x = "x";
		demon.moveUp(i, "x");
		assertEquals(20, demon.getPosition());
	}	

}
