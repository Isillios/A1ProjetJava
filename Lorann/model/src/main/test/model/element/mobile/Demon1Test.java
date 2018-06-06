package model.element.mobile;

import static org.junit.Assert.*;


import org.junit.Test;

import model.Map;

public class Demon1Test {

	@Test
	public void testIsAlive() {
		
		Map map1 = new Map();
		MyPlayer hero = new MyPlayer(5, map1);
		assertTrue(hero.isAlive());
	}

}
