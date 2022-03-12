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
public class TestHitungKolam {
	
	static final Logger log = getLogger(lookup().lookupClass());
	public HitungKolam hitungKolam;
	
	@Before
	public void setUp() throws Exception{
		hitungKolam = new HitungKolam();
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
	@FileParameters("src/test/resources/kkolam.csv")
	public void testKelilingKolam(double p, double l, double t, double expect) {
		log.debug("Test 1");
		System.out.println("Test Keliling Kolam");
		double actual = hitungKolam.kelilingKolam(p, l, t);
		assertEquals(expect, actual, 0.0);
	}
	
	@Test
	@FileParameters("src/test/resources/vkolam.csv")
	public void testVolumeKolam(double p, double l, double t, double expect) {
		log.debug("Test 2");
		System.out.println("Test Volume Kolam");
		double actual = hitungKolam.volumeKolam(p, l, t);
		assertEquals(expect, actual, 0.0);
	}

	
	@Test
	public void testHitungKelilingBukanAngka() {
		log.debug("Test 3");
		System.out.println("Test Keliling Kolam Bukan Angka");
		String pBA = "Panjang";
		String lBA = "Lebar";
		String tBA = "Tinggi";
		
		double ubahp = Double.parseDouble(pBA);
		double ubahl = Double.parseDouble(lBA);
		double ubaht = Double.parseDouble(tBA);
		
		double actualK = hitungKolam.kelilingKolam(ubahp, ubahl, ubaht);
		String expect = "Panjang Lebar Tinggi";
		assertEquals(Double.parseDouble(expect), actualK, 0.0);
	}
	
	@Test
	public void testHitungVolumeBukanAngka() {
		log.debug("Test 4");
		System.out.println("Test Volume Kolam Bukan Angka");
		String pBA = "Panjang";
		String lBA = "Lebar";
		String tBA = "Tinggi";
		
		double ubahp = Double.parseDouble(pBA);
		double ubahl = Double.parseDouble(lBA);
		double ubaht = Double.parseDouble(tBA);
		
		double actualV = hitungKolam.volumeKolam(ubahp, ubahl, ubaht);
		String expect = "Panjang Lebar Tinggi";
		assertEquals(Double.parseDouble(expect), actualV, 0.0);
	}
	
	@Test
	@FileParameters("src/test/resources/kkolam negatif.csv")
	public void testKelilingKolamNegatif(double p, double l, double t, double expect) {
		log.debug("Test 5");
		System.out.println("Test Keliling Kolam Angka Negatif");
		double actual = hitungKolam.kelilingKolam(p, l, t);
		assertEquals(expect, actual, 0.0);
	}
	
	@Test
	@FileParameters("src/test/resources/vkolam negatif.csv")
	public void testVolumeKolamNegatif(double p, double l, double t, double expect) {
		log.debug("Test 6");
		System.out.println("Test Volume Kolam Angka Negatif");
		double actual = hitungKolam.volumeKolam(p, l, t);
		assertEquals(expect, actual, 0.0);
	}
	
	@Test
	public void testKelilingKolamNull() {
		log.debug("Test 7");
		System.out.println("Test Keliling Kolam Null");
		double p = 0;
		double l = 0;
		double t = 0;
		Double pNull = null;
		Double lNull = null;
		Double tNull = null;
		double actual = hitungKolam.kelilingKolam(p, l, t);
		assertNull(pNull);
		assertNull(lNull);
		assertNull(tNull);
		assertEquals(0, actual, 0.0);
	}
	
	@Test
	public void testVolumeKolamNull() {
		log.debug("Test 8");
		System.out.println("Test Volume Kolam Null");
		double p = 0;
		double l = 0;
		double t = 0;
		Double pNull = null;
		Double lNull = null;
		Double tNull = null;
		double actual = hitungKolam.volumeKolam(p, l, t);
		assertNull(pNull);
		assertNull(lNull);
		assertNull(tNull);
		assertEquals(0, actual, 0.0);
	}
}
