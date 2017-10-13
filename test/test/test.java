package test;

import static org.junit.Assert.*;
import controller.Calculator;
import controller.Controller;
import junit.framework.Assert;

import org.junit.Test;

import controller.Controller;

public class test {

	@SuppressWarnings("deprecation")
	@Test
	public void testVerify() {
		
		Controller cont = new Controller();
		cont.setExpr("1 + 1");
		
		Assert.assertEquals(cont.verify(), 1);
		
		cont.setExpr("2 + + 3");
		Assert.assertEquals(cont.verify(), false);
		
		cont.setExpr("3 + 5 + 5");
		Assert.assertEquals(cont.verify(), false);
		
	}
	
	@Test
	public void testCalculate(){
		
		Controller cont = new Controller();
		cont.setExpr("1 + 1");
		
		Assert.assertEquals(2, cont.calculate());
	}
	
	@Test
	public void testMultiplication(){
		
		Controller cont = new Controller();
		cont.setExpr("1 * 2");
		
		Assert.assertEquals(cont.multiplication("1", "2"), 2);
	}
	
	@Test
	public void testPlus(){
		
		Controller cont = new Controller();
		cont.setExpr("1 + 2");
		
		Assert.assertEquals(cont.multiplication("1", "2"), 3);
	}

}
