package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Map;
import model.element.mobile.MyPlayer;

public class GateClosedTest {

	@Test
	public void testGetPosition() {
		int position = 5;
		Map map = new Map();
		MyPlayer hero = new MyPlayer(5, map);
		assertEquals(position, hero.getPosition());
		
		
	}

}
