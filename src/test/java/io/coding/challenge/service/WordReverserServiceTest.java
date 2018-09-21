package io.coding.challenge.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordReverserServiceTest {
	
	@Autowired
	private WordReverserService wordReverserService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testA() {
		String actual = wordReverserService.reverse("test");
		String expected = "tset";
		
		assertEquals(expected, actual);
	}

	@Test
	public void testB() {
		String actual = wordReverserService.reverse("Hello World!");
		String expected = "olleH dlroW!";
		
		assertEquals(expected, actual);
	}

	@Test
	public void testC() {
		String actual = wordReverserService.reverse("ab.cd.ef.gh.ij");
		String expected = "ba.dc.fe.hg.ji";
		
		assertEquals(expected, actual);
	}

	@Test
	public void testD() {
		String actual = wordReverserService.reverse(
						  "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		String expected = "meroL muspi rolod tis tema, rutetcesnoc gnicsipida tile, des od domsuie ropmet tnudidicni tu erobal te erolod angam auqila.";
		
		assertEquals(expected, actual);
	}
	


	@Test
	public void testE() {
		String actual = wordReverserService.reverse("\"Stranger Things!!\"");
		String expected = "\"regnartS sgnihT!!\"";
		
		assertEquals(expected, actual);
	}

}
