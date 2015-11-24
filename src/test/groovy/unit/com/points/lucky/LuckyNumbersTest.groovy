package unit.com.points.lucky

import static org.junit.Assert.*
import org.junit.Before
import org.junit.Test

import com.points.lucky.LuckyNumbers

class LuckyNumbersTest {
	LuckyNumbers luckyNum
	
	@Before
	public void setup(){
		luckyNum = new LuckyNumbers()
	}
	
	@Test
	public void testLuckyNumberOneBaseCaseReturnsTrue(){
		assertEquals(true, luckyNum.isLucky(1))
	}
	
	@Test
	public void testLuckyNumberZeroBaseCaseReturnsFalse() {
		assertEquals(false, luckyNum.isLucky(0))
	}
	
	@Test
	public void testLuckyNumberTwoReturnsFalse() {
		assertEquals(false, luckyNum.isLucky(2))
	}
	
	@Test
	public void testLuckyNumberSevenReturnsTrue() {
		assertEquals(true, luckyNum.isLucky(7))
	}
	
	@Test
	public void testLuckyNumberCacheIsUsed() {
		luckyNum.isLucky(1)
		luckyNum.isLucky(2)
		luckyNum.isLucky(3)
		luckyNum.isLucky(7)
		assertEquals(2, luckyNum.getCacheSetSize())
	}
}
