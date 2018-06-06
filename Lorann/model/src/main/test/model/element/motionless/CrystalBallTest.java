package model.element.motionless;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Map;
import model.element.mobile.MyPlayer;

public class CrystalBallTest {

/**	
 *	If the Hero is on the map it should work
 */
	@Test
	public void testGetMap() {
		Map map = new Map();
		MyPlayer hero = new MyPlayer(5, map);
		assertEquals(map, hero.getMap());
	}

}
