package br.com.tidicas.test;

import br.com.tidicas.main.CreateTabelas;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Teste unitário da aplicacao Spring.
 */
public class MainTest extends TestCase {
	
	public static Test suite() {
		return new TestSuite(MainTest.class);
	}

	public void testMain() {
		CreateTabelas.main(null);		
	}
	
}