package com.juaracoding.naili.week3;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHitungSuhu {

	static final Logger log = getLogger(lookup().lookupClass());
	public HitungSuhu hitungSuhu;
	
	@Before
	public void setUp() throws Exception{
		hitungSuhu = new HitungSuhu();
	}
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		
		@Override
		protected void succeeded(Description description) {
			log.debug("Pesan Sukses: {}", description.getMethodName());
		}
		
		@Override
		protected void failed(Throwable e, Description description) {
			log.debug("Pesan Failed: {}", description.getMethodName());
		}
	};
	
	@Test
	@FileParameters("src/test/resources/fc.csv")
	public void testHitungSuhu(double c, double expect) {
		log.debug("Test 9");
		System.out.println("Test Hitung Suhu");
		double actual = hitungSuhu.hitungSuhu(c);
		assertEquals(expect, actual, 0.4);
	}
	
	@Test
	public void testHitungSuhuBukanAngka() {
		log.debug("Test 10");
		System.out.println("Test Hitung Suhu Bukan Angka");
		String cBA = "Fahrenheit";
		
		double ubahp = Double.parseDouble(cBA);
		
		double actualF = hitungSuhu.hitungSuhu(ubahp);
		String expect = "Fahrenheit";
		assertEquals(Double.parseDouble(expect), actualF, 0.0);
	}
	
	@Test
	@FileParameters("src/test/resources/fcnegatif.csv")
	public void testHitungSuhuNegatif(double c, double expect) {
		log.debug("Test 11");
		System.out.println("Test Hitung Suhu Angka Negatif");
		double actual = hitungSuhu.hitungSuhu(c);
		assertEquals(expect, actual, 0.4);
	}
	
	@Test
	public void testHitungSuhuNull() {
		log.debug("Test 12");
		System.out.println("Test Hitung Suhu Null");
		double c = 0;
		Double cNull = null;
		double actual = hitungSuhu.hitungSuhu(c);
		assertNull(cNull);
		assertEquals(0, actual, 0.9);
	}
	
}
