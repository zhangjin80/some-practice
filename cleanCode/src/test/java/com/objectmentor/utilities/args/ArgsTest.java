package com.objectmentor.utilities.args;

import org.junit.Assert;
import org.junit.Test;
import junit.framework.TestCase;

public class ArgsTest extends TestCase {

    public void testMain() throws ArgsException {
        String[] args = {"-l", "-p", "3306", "-d", "/user/tmp"};
        Args arg = new Args("l,p#,d*", args);
        boolean logging = arg.getBoolean('l');
        int port = arg.getInt('p');
        String directory = arg.getString('d');
        assertEquals(true,logging);
        assertEquals(3306,port);
        assertEquals("/user/tmp",directory);
    }

    public void testStringArray() throws Exception {
        String[] args = {"-a", " hello , world, "};
        String argsTag = "a[*]";
        Args arg = new Args(argsTag, args);
        String[] as = arg.getStringArray('a');
        Assert.assertArrayEquals(new String[]{"hello","world"},
                as);
    }

    public void testCreateWithNoSchemaOrArguments() throws Exception {
        Args args = new Args("", new String[0]);
        assertEquals(0, args.cardinality());
    }

    public void testCardinality() throws Exception {
        Args args = new Args("b,c,d", new String[]{"-b", "-c", "-d"});
        assertEquals(3, args.cardinality());
    }

    public void testBooleanStringCardinality() throws Exception {
        Args args = new Args("b,c,d*", new String[]{"-b", "-c", "-d", "test"});
        assertEquals(3, args.cardinality());
    }

    public void testOneBooleanArguments() throws Exception {
        Args args = new Args("b", new String[]{"-b"});
        assertEquals(true, args.getBoolean('b'));
    }

    public void testTwoBooleanArguments() throws Exception {
        Args args = new Args("b,c", new String[]{"-b", "-c"});
        assertEquals(true, args.getBoolean('b'));
        assertEquals(true, args.getBoolean('c'));
        assertEquals(false, args.getBoolean('d'));
    }

    public void testOneStringArguments() throws Exception {
        String testString = "my test String";
        Args args = new Args("b*", new String[]{"-b", testString});
        assertEquals(testString, args.getString('b'));
    }

    public void testTwoStringArguments() throws Exception {
        String testString1 = "my test String1";
        String testString2 = "my test String2";
        Args args = new Args("b*,c*", new String[]{"-b", testString1, "-c", testString2});
        assertEquals(testString1, args.getString('b'));
        assertEquals(testString2, args.getString('c'));
    }

    public void testTwoStringOneBooleanArguments() throws Exception {
        String testString1 = "my test String1";
        String testString2 = "my test String2";
        Args args = new Args("b*,c*,d", new String[]{"-b", testString1, "-c", testString2, "-d"});
        assertEquals(testString1, args.getString('b'));
        assertEquals(testString2, args.getString('c'));
        assertEquals(true, args.getBoolean('d'));
    }

    public void testTwoStringOneBooleanOneIntegerArguments() throws Exception {
        String testString1 = "my test String1";
        String testString2 = "my test String2";
        String testInt = "10";
        Args args = new Args("b*,c*,d,e#", new String[]{"-b", testString1, "-c", testString2, "-d", "-e", testInt});
        assertEquals(testString1, args.getString('b'));
        assertEquals(testString2, args.getString('c'));
        assertEquals(true, args.getBoolean('d'));
        assertEquals(Integer.parseInt(testInt), args.getInt('e'));
    }

    public void testGetBooleanFromStringArguments() throws Exception {
        String testString1 = "my test String1";
        String testString2 = "my test String2";
        Args args = new Args("b*,c*,d", new String[]{"-b", testString1, "-c", testString2, "-d"});
        assertEquals(testString1, args.getString('b'));
        assertEquals(testString2, args.getString('c'));
        assertEquals(false, args.getBoolean('c'));
    }

}