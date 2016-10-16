package cn.missbe.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import cn.missbe.action.ValidateAction;

public class ValidateActionTest {
    @Ignore
    public void executeTest(){
    	ValidateAction action=new ValidateAction();
    	assertEquals("success",action.execute());
    }
    
    @Test
    public void executeListTest(){
    	ValidateAction action=new ValidateAction();
    	assertEquals("success",action.list());
    }
}
