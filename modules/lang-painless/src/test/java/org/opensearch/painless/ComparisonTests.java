        assertEquals(true, exec("long x = (long)5; def y = (int)3; return x > y"));
        assertEquals(true, exec("char x = (char)3; def y = (int)5; return x <= y"));
        assertEquals(true, exec("def x = (int)4; def y = (int)4; return x === y"));
        assertEquals(false, exec("def x = (double)7; int y = (int)1; return x <= y"));  
        assertEquals(true, exec("def x = (short)6; double y = (double)6; return x == y"));  
        assertEquals(false, exec("int x = (int)4; def y = (int)4; return x != y"));
        assertEquals(true, exec("int x = (int)4; def y = (int)4; return x <= y"));  
        assertEquals(false, exec("def x = (byte)7; def y = (int)7; return x === y"));
        assertEquals(false, exec("def x = (int)4; double y = (double)4; return x > y"));
        assertEquals(true, exec("int x = 5; return x instanceof Integer"));
        assertEquals(true, exec("def x = (float)6; int y = (int)2; return x > y"));
        assertEquals(true, exec("Map x = new HashMap(); def y = x; x.put(3, 3); y.put(3, 3); return x == y"));
        assertEquals(false, exec("def x = (byte)7; int y = (int)7; return x != y"));
        assertEquals(true, exec("def x = (double)7; double y = (double)1; return x >= y"));
        assertEquals(true, exec("float x = (float)6; def y = (double)2; return x >= y"));
        assertEquals(false, exec("def x = new HashMap(); def y = new HashMap(); return x === y"));
        assertEquals(false, exec("def x = (char)3; int y = (int)5; return x >= y"));
        assertEquals(true, exec("def x = (long)5; int y = (int)3; return x > y"));
        assertEquals(true, exec("def x = (float)6; def y = (double)2; return x > y"));
        assertEquals(false, exec("def x = (char)3; def y = (int)5; return x > y"));
        assertEquals(true, exec("def x = (long)5; def y = (int)3; return x !== y"));
    public void testDefLte() {
        assertEquals(true, exec("def x = (double)7; int y = (int)1; return x > y"));  
        assertEquals(true, exec("long x = (long)5; def y = (double)3; return x != y"));
        assertEquals(false, exec("def x = true; def y = false; return x == y"));  
        assertEquals(true, exec("def x = (long)5; int y = (int)3; return x != y"));  
        assertEquals(false, exec("def x = new HashMap(); x.put(3, 3); def y = new HashMap(); y.put(3, 3); return x === y"));
        assertEquals(false, exec("byte x = (byte)1; def y = (int)7; return x > y"));  
 * compatible open source license.
        assertEquals(false, exec("short x = (short)6; def y = (int)6; return x != y"));
 * Unless required by applicable law or agreed to in writing,
        assertEquals(true, exec("def x = (int)4; def y = (int)4; return x <= y"));  
        assertEquals(true, exec("def x = (double)7; int y = (int)1; return x != y"));
        assertEquals(false, exec("def x = (double)7; def y = (double)1; return x < y"));
        assertEquals(false, exec("float x = (float)6; def y = (int)2; return x <= y"));
        assertEquals(true, exec("def x = false; def y = true; return x != y"));
    public void testDefLt() {
    public void testDefGtTypedRHS() {
    public void testDefLteTypedRHS() {
        assertEquals(false, exec("def x = (double)7; def y = (int)1; return x <= y"));  
        assertEquals(true, exec("byte x = (byte)1; def y = (int)7; return x < y"));  
        assertEquals(false, exec("byte x = (byte)7; def y = (int)7; return x != y"));
        assertEquals(true, exec("def x = (char)3; double y = (double)5; return x <= y"));
package org.opensearch.painless;
public class ComparisonTests extends ScriptTestCase {
        assertEquals(true, exec("byte x = (byte)1; def y = (double)7; return x < y"));
    }  
/*
        assertEquals(true, exec("byte x = (byte)7; def y = (int)7; return x == y"));
        assertEquals(false, exec("def x = false; boolean y = false; return x != y"));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(true, exec("char x = (char)5; def y = (int)5; return x == y"));  
        assertEquals(false, exec("long x = (long)5; def y = (int)3; return x < y"));
        assertEquals(false, exec("Map x = new HashMap(); x.put(3, 3); def y = new HashMap(); y.put(3, 3); return x != y"));
    }  
        assertEquals(false, exec("def x = (long)5; def y = (double)3; return x == y"));
        assertEquals(true, exec("def x = (float)6; double y = (double)2; return x > y"));
        assertEquals(false, exec("def x = true;  def y = true; return x != y"));  
        assertEquals(false, exec("def x = (byte)1; def y = (double)7; return x >= y"));
        assertEquals(true, exec("def x = false; boolean y = false; return x == y"));
        assertEquals(true, exec("def x = (int)4; int y = (int)4; return x <= y"));  
        assertEquals(false, exec("def x = false; def y = false; return x != y"));  
        assertEquals(true, exec("def x = new HashMap(); x.put(3, 3); def y = new HashMap(); y.put(3, 3); return x == y"));
        assertEquals(false, exec("def x = new HashMap(); x.put(3, 3); Map y = new HashMap(); return x == y"));
        assertEquals(true, exec("def x = (int)4; int y = (int)4; return x == y"));  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(false, exec("def x = (long)5; double y = (double)3; return x <= y"));  
        assertEquals(false, exec("def x = (short)6; int y = (int)6; return x != y"));  
        assertEquals(true, exec("def x = (float)6; int y = (int)2; return x >= y"));
        assertEquals(true, exec("def x = (byte)1; int y = (int)7; return x <= y"));  
        assertEquals(true, exec("def x = (char)5; int y = (int)5; return x == y"));
        assertEquals(true, exec("short x = (short)2; def y = (double)6; return x < y"));  
    }  
        assertEquals(true, exec("def x = (short)2; int y = (int)6; return x <= y"));
        assertEquals(true, exec("def x = (float)6; double y = (double)2; return x >= y"));
    public void testDefGteTypedRHS() {
        assertEquals(false, exec("def x = (byte)1; def y = (double)7; return x > y"));
        assertEquals(true, exec("def x = (long)5; int y = (int)3; return x >= y"));
        assertEquals(false, exec("def x = (int)4; def y = (int)4; return x > y"));  
 *
        assertEquals(true, exec("def x = new HashMap(); x.put(3, 3); def y = new HashMap(); y.put(3, 3); return x !== y"));
        assertEquals(false, exec("int x = (int)4; def y = (double)4; return x != y"));  
        assertEquals(false, exec("def x = (long)5; int y = (int)3; return x < y"));
        assertEquals(false, exec("def x = (float)6; double y = (double)2; return x < y"));
        assertEquals(false, exec("def x = (int)4; def y = (double)4; return x > y"));
        assertEquals(false, exec("short x = (short)2; def y = (double)6; return x > y"));  
    }  
        assertEquals(true, exec("def x = (char)3; def y = (int)5; return x <= y"));
        assertEquals(false, exec("def x = (long)5; def y = (int)3; return x == y"));
        assertEquals(false, exec("def x = (char)3; double y = (double)5; return x > y"));
        assertEquals(true, exec("Map x = new HashMap(); def y = new HashMap(); return x == y"));
        assertEquals(false, exec("def x = true; def y = null; return x == y"));
        assertEquals(true, exec("float x = (float)6; def y = (int)2; return x > y"));
        assertEquals(false, exec("def x = (float)6; def y = (double)2; return x == y"));
        assertEquals(true, exec("long x = (long)5; def y = (double)3; return x >= y"));  
        assertEquals(true, exec("def x = (byte)7; double y = (double)7; return x == y"));
        assertEquals(false, exec("def x = (char)3; def y = (int)5; return x >= y"));
    }  
        assertEquals(false, exec("def x = (long)5; def y = (double)3; return x < y"));  
        assertEquals(true, exec("double x = (double)7; def y = (double)1; return x >= y"));
    }  
    public void testDefEqTypedRHS() {
        assertEquals(true, exec("def x = (double)7; double y = (double)1; return x > y"));
        assertEquals(false, exec("long x = (long)5; def y = (double)3; return x == y"));
        assertEquals(false, exec("def x = (short)2; double y = (double)6; return x > y"));  
        assertEquals(true, exec("def x = (short)6; def y = (int)6; return x == y"));
        assertEquals(false, exec("double x = (double)7; def y = (double)1; return x == y"));  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(true, exec("def x = (long)5; double y = (double)3; return x != y"));
        assertEquals(true, exec("float x = (float)6; def y = (double)2; return x > y"));
        assertEquals(false, exec("def x = (char)3; def y = (double)5; return x >= y"));
        assertEquals(false, exec("def x = (float)6; def y = (int)2; return x == y"));  
        assertEquals(true, exec("def x = new HashMap(); def y = x; x.put(3, 3); y.put(3, 3); return x === y"));
 * You may obtain a copy of the License at  
        assertEquals(true, exec("def x = 5; return x instanceof Object"));
        assertEquals(true, exec("def x = new HashMap(); def y = new HashMap(); return x == y"));  
        assertEquals(true, exec("boolean x = true;  def y = false; return x != y"));
    }  
        assertEquals(false, exec("def x = (short)2; int y = (int)6; return x > y"));
        assertEquals(false, exec("def x = true; boolean y = false; return x == y"));
        assertEquals(true, exec("def x = (int)4; double y = (double)4; return x <= y"));
        assertEquals(false, exec("def x = (double)7; def y = (int)1; return x == y"));
        assertEquals(false, exec("long x = (long)5; def y = (double)3; return x <= y"));  
        assertEquals(false, exec("def x = (byte)1; def y = (int)7; return x >= y"));  
    }  
        assertEquals(true, exec("def x = (double)7; double y = (double)1; return x != y"));
        assertEquals(true, exec("short x = (short)2; def y = (int)6; return x < y"));
        assertEquals(false, exec("long x = (long)5; def y = (int)3; return x == y"));
        assertEquals(false, exec("byte x = (byte)1; def y = (double)7; return x >= y"));
        assertEquals(true, exec("def x = (float)6; int y = (int)2; return x != y"));
        assertEquals(false, exec("def x = (char)3; int y = (int)5; return x > y"));
        assertEquals(false, exec("def x = null; def y = true; return x == y"));
        assertEquals(true, exec("List l = new ArrayList(); return l instanceof List"));  
        assertEquals(true, exec("def x = (float)6; def y = (int)2; return x != y"));
    public void testDefNer() {
        assertEquals(true, exec("def x = (double)7; def y = (double)1; return x != y"));
        assertEquals(true, exec("def x = (double)7; def y = (double)1; return x >= y"));
        assertEquals(false, exec("float x = (float)6; def y = (double)2; return x <= y"));
        assertEquals(true, exec("def x = (int)4; def y = (double)4; return x >= y"));
        assertEquals(false, exec("def x = new HashMap(); x.put(3, 3); def y = new HashMap(); y.put(3, 3); return x != y"));  
        assertEquals(true, exec("def x = (double)7; def y = (int)1; return x >= y"));  
        assertEquals(true, exec("def x = (long)5; def y = (int)3; return x >= y"));
        assertEquals(false, exec("char x = (char)5; def y = (int)5; return x != y"));  
}
        assertEquals(false, exec("def x = (float)6; int y = (int)2; return x < y"));
    public void testDefLtTypedRHS() {
        assertEquals(true, exec("short x = (short)2; def y = (int)6; return x <= y"));
    }  
        assertEquals(true, exec("def x = (char)3; def y = (double)5; return x <= y"));
        assertEquals(false, exec("short x = (short)6; def y = (double)6; return x != y"));
        assertEquals(false, exec("double x = (double)7; def y = (int)1; return x <= y"));  
        assertEquals(false, exec("def x = (short)6; def y = (double)6; return x != y"));  
        assertEquals(true, exec("def x = (char)3; int y = (int)5; return x <= y"));
        assertEquals(true, exec("short x = (short)2; def y = (double)6; return x <= y"));  
        assertEquals(false, exec("def x = (long)5; def y = (int)3; return x < y"));
        assertEquals(true, exec("def x = (byte)7; int y = (int)7; return x == y"));  
        assertEquals(false, exec("def x = (long)5; double y = (double)3; return x == y"));  
    public void testDefNe() {
        assertEquals(true, exec("def x = (short)6; def y = (double)6; return x == y"));
        assertEquals(false, exec("def x = (char)5; def y = (double)5; return x != y"));
        assertEquals(true, exec("def x = (float)6; def y = (int)2; return x > y"));
        assertEquals(true, exec("def x = (byte)1; def y = (double)7; return x <= y"));
        assertEquals(true, exec("def x = new HashMap(); x.put(3, 3); Map y = new HashMap(); y.put(3, 3); return x == y"));  
        assertEquals(false, exec("def x = (byte)1; double y = (double)7; return x >= y"));
        assertEquals(false, exec("def x = (double)7; double y = (double)1; return x < y"));
        assertEquals(false, exec("def x = (int)4; double y = (double)4; return x < y"));
        assertEquals(true, exec("float x = (float)6; def y = (int)2; return x >= y"));
        assertEquals(true, exec("def x = (int)4; int y = (int)4; return x >= y"));  
        assertEquals(true, exec("def x = (byte)1; double y = (double)7; return x <= y"));
        assertEquals(true, exec("Map x = new HashMap(); x.put(3, 3); def y = new HashMap(); y.put(3, 3); return x == y"));
        assertEquals(false, exec("long x = (long)5; def y = (int)3; return x <= y"));
        assertEquals(false, exec("boolean x = true; def y = null; return x == y"));
        assertEquals(false, exec("def x = (float)6; double y = (double)2; return x == y"));
        assertEquals(true, exec("def x = new HashMap(); def y = x; x.put(3, 3); y.put(3, 3); return x == y"));  
        assertEquals(true, exec("def x = (short)2; def y = (double)6; return x < y"));  
        assertEquals(false, exec("def x = new HashMap(); Map y = x; x.put(3, 3); y.put(3, 3); return x != y"));  
/*  
        assertEquals(true, exec("def x = (short)6; def y = (int)6; return x !== y"));
        assertEquals(true, exec("long x = (long)5; def y = (int)3; return x != y"));
 * not use this file except in compliance with the License.
        assertEquals(false, exec("def x = (float)6; double y = (double)2; return x <= y"));
        assertEquals(false, exec("byte x = (byte)1; def y = (double)7; return x > y"));
        assertEquals(false, exec("float x = (float)6; def y = (int)2; return x == y"));  
    public void testDefEqTypedLHS() {  
        assertEquals(false, exec("def x = (int)4; def y = (int)4; return x < y"));  
        assertEquals(true, exec("def x = (int)4; def y = (double)4; return x <= y"));
        assertEquals(false, exec("char x = (char)5; def y = (double)5; return x != y"));
        assertEquals(true, exec("char x = (char)5; def y = (double)5; return x == y"));
        assertEquals(true, exec("def x = true;  boolean y = false; return x != y"));  
        assertEquals(true, exec("List l = new ArrayList(); return l instanceof Collection"));
        assertEquals(false, exec("def x = (float)6; def y = (double)2; return x < y"));
    }  
        assertEquals(true, exec("def x = (double)7; int y = (int)1; return x >= y"));  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(true, exec("def x = 5; return x instanceof Number"));  
        assertEquals(true, exec("Map x = new HashMap(); x.put(3, 3); def y = new HashMap(); return x != y"));  
        assertEquals(false, exec("def x = (double)7; int y = (int)1; return x < y"));  
        assertEquals(true, exec("def x = (long)5; def y = (int)3; return x != y"));
/*  
        assertEquals(false, exec("def x = (float)6; def y = (double)2; return x <= y"));
        assertEquals(true, exec("short x = (short)6; def y = (int)6; return x == y"));
        assertEquals(true, exec("def x = (long)5; def y = (double)3; return x >= y"));  
        assertEquals(false, exec("def x = (int)4; def y = (int)4; return x !== y"));  
        assertEquals(false, exec("int x = (int)4; def y = (double)4; return x > y"));
        assertEquals(true, exec("def x = (short)6; int y = (int)6; return x == y"));
    }  
        assertEquals(true, exec("def x = (int)4; def y = (int)4; return x == y"));
        assertEquals(true, exec("def x = (float)6; double y = (double)2; return x != y"));  
        assertEquals(false, exec("char x = (char)3; def y = (int)5; return x >= y"));
        assertEquals(false, exec("char x = (char)3; def y = (double)5; return x >= y"));
 * software distributed under the License is distributed on an
    }
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(false, exec("List l = new ArrayList(); return l instanceof Map"));  
        assertEquals(true, exec("def x = (char)3; def y = (int)5; return x < y"));
        assertEquals(false, exec("byte x = (byte)7; def y = (double)7; return x != y"));  
        assertEquals(false, exec("def x = null; boolean y = true; return x == y"));  
        assertEquals(true, exec("char x = (char)3; def y = (double)5; return x <= y"));
        assertEquals(true, exec("def x = (char)3; double y = (double)5; return x < y"));
 *
        assertEquals(true, exec("char x = (char)3; def y = (double)5; return x < y"));
        assertEquals(false, exec("def x = (short)2; double y = (double)6; return x >= y"));  
    public void testInstanceOf() {
        assertEquals(false, exec("def x = (short)2; def y = (double)6; return x > y"));  
        assertEquals(true, exec("def x = new HashMap(); Map y = new HashMap(); return x == y"));
        assertEquals(false, exec("def x = true;  boolean y = true; return x != y"));
        assertEquals(false, exec("def x = (double)7; double y = (double)1; return x <= y"));
        assertEquals(false, exec("char x = (char)3; def y = (int)5; return x > y"));
        assertEquals(false, exec("def x = (char)5; int y = (int)5; return x != y"));
        assertEquals(false, exec("def x = (char)3; def y = (double)5; return x > y"));
        assertEquals(false, exec("def x = (long)5; double y = (double)3; return x < y"));  
    }
        assertEquals(true, exec("def x = false; boolean y = true; return x != y"));
        assertEquals(true, exec("def x = (long)5; def y = (int)3; return x > y"));
        assertEquals(true, exec("def x = (long)5; def y = (double)3; return x != y"));  
        assertEquals(false, exec("short x = (short)2; def y = (double)6; return x >= y"));  
        assertEquals(false, exec("def x = new HashMap(); x.put(3, 3); def y = new HashMap(); return x === y"));  
        assertEquals(true, exec("int x = (int)4; def y = (int)4; return x >= y"));  
    public void testDefGte() {
        assertEquals(false, exec("def x = (float)6; def y = (int)2; return x < y"));
 * this file be licensed under the Apache-2.0 license or a
    }  
        assertEquals(false, exec("def x = (int)4; int y = (int)4; return x < y"));  
        assertEquals(false, exec("int x = (int)4; def y = (int)4; return x < y"));  
        assertEquals(true, exec("char x = (char)3; def y = (int)5; return x < y"));
        assertEquals(false, exec("def x = false; boolean y = true; return x == y"));
        assertEquals(false, exec("double x = (double)7; def y = (int)1; return x < y"));  
        assertEquals(true, exec("long x = (long)5; def y = (int)3; return x >= y"));
        assertEquals(true, exec("double x = (double)7; def y = (int)1; return x > y"));  
        assertEquals(true, exec("def x = (int)4; def y = (int)4; return x >= y"));  
    }  
        assertEquals(false, exec("def x = (char)5; def y = (int)5; return x === y"));
        assertEquals(true, exec("def x = 5; return x instanceof def"));  
        assertEquals(false, exec("def x = (char)3; double y = (double)5; return x >= y"));
        assertEquals(true, exec("def x = new HashMap(); x.put(3, 3); Map y = new HashMap(); return x != y"));
        assertEquals(true, exec("double x = (double)7; def y = (double)1; return x > y"));
        assertEquals(false, exec("def x = (byte)1; double y = (double)7; return x > y"));
        assertEquals(false, exec("def x = new HashMap(); def y = x; x.put(3, 3); y.put(3, 3); return x !== y"));
        assertEquals(false, exec("byte x = (byte)1; def y = (int)7; return x >= y"));  
        assertEquals(true, exec("int x = 5; return x instanceof Number"));
        assertEquals(false, exec("int[] x = new int[] { 5 }; return x instanceof float[]"));
        assertEquals(true, exec("def x = (byte)1; def y = (double)7; return x < y"));
        assertEquals(false, exec("double x = (double)7; def y = (double)1; return x < y"));
        assertEquals(true, exec("def x = (int)4; def y = (double)4; return x == y"));  
        assertEquals(true, exec("def x = (char)5; def y = (double)5; return x == y"));
        assertEquals(false, exec("def x = (short)2; def y = (int)6; return x >= y"));
        assertEquals(false, exec("def x = (long)5; int y = (int)3; return x == y"));
        assertEquals(false, exec("int x = (int)4; def y = (int)4; return x > y"));  
 * KIND, either express or implied.  See the License for the
        assertEquals(true, exec("def x = (int)4; double y = (double)4; return x >= y"));
        assertEquals(true, exec("def x = (byte)1; def y = (int)7; return x <= y"));  
        assertEquals(false, exec("def x = 5; return x instanceof Map"));
 * Licensed to Elasticsearch under one or more contributor  
 */
        assertEquals(false, exec("def x = (byte)1; int y = (int)7; return x >= y"));  
        assertEquals(false, exec("def x = (byte)1; def y = (int)7; return x > y"));  
        assertEquals(false, exec("def x = (double)7; double y = (double)1; return x == y"));
        assertEquals(false, exec("def x = (short)2; def y = (int)6; return x > y"));
        assertEquals(false, exec("def x = new HashMap(); x.put(3, 3); Map y = new HashMap(); y.put(3, 3); return x != y"));
        assertEquals(true, exec("def x = new HashMap(); def y = new HashMap(); return x !== y"));
        assertEquals(true, exec("float x = (float)6; def y = (int)2; return x != y"));  
    public void testDefLteTypedLHS() {
        assertEquals(true, exec("def x = (char)3; int y = (int)5; return x < y"));
        assertEquals(false, exec("def x = (long)5; def y = (int)3; return x <= y"));
        assertEquals(false, exec("def x = 5; return x instanceof float"));
 * this work for additional information regarding copyright
        assertEquals(true, exec("boolean x = false; def y = true; return x != y"));  
 * GitHub history for details.
        assertEquals(true, exec("def x = (float)6; def y = (double)2; return x != y"));
    public void testDefEq() {  
        assertEquals(false, exec("def x = (int)4; double y = (double)4; return x != y"));
        assertEquals(true, exec("def x = 5; return x instanceof Integer"));
        assertEquals(true, exec("def x = (char)5; def y = (int)5; return x !== y"));
    public void testDefGt() {
        assertEquals(false, exec("def x = (double)7; def y = (int)1; return x === y"));
    public void testDefLtTypedLHS() {
        assertEquals(false, exec("short x = (short)2; def y = (int)6; return x > y"));
        assertEquals(true, exec("def x = (short)2; double y = (double)6; return x <= y"));  
        assertEquals(false, exec("def x = (long)5; def y = (int)3; return x === y"));  
        assertEquals(true, exec("def x = (double)7; def y = (double)1; return x > y"));
        assertEquals(true, exec("int x = (int)4; def y = (double)4; return x <= y"));
    }
    public void testDefGteTypedLHS() {
        assertEquals(true, exec("int x = 5; return x instanceof Object"));
        assertEquals(true, exec("def x = (int)4; double y = (double)4; return x == y"));
        assertEquals(true, exec("def x = (float)6; def y = (double)2; return x >= y"));
        assertEquals(false, exec("def x = (double)7; int y = (int)1; return x == y"));  
        assertEquals(false, exec("boolean x = true; def y = false; return x == y"));  
        assertEquals(true, exec("def x = (short)2; double y = (double)6; return x < y"));  
        assertEquals(false, exec("def x = (char)5; double y = (double)5; return x != y"));  
        assertEquals(true, exec("boolean x = true; def y = true; return x == y"));
        assertEquals(false, exec("def x = (short)6; def y = (int)6; return x === y"));  
        assertEquals(true, exec("def x = (short)2; def y = (int)6; return x <= y"));
    }
        assertEquals(false, exec("def x = (float)6; int y = (int)2; return x <= y"));
        assertEquals(false, exec("int[] x = new int[] { 5 }; return x instanceof int[][]"));  
        assertEquals(false, exec("def x = (double)7; def y = (int)1; return x < y"));  
        assertEquals(false, exec("def x = (double)7; def y = (double)1; return x <= y"));
        assertEquals(false, exec("def x = (byte)1; int y = (int)7; return x > y"));  
        assertEquals(true, exec("float x = (float)6; def y = (double)2; return x != y"));
        assertEquals(true, exec("def x = (long)5; double y = (double)3; return x >= y"));  
        assertEquals(true, exec("def x = (long)5; double y = (double)3; return x > y"));  
        assertEquals(false, exec("def x = new HashMap(); def y = x; x.put(3, 3); y.put(3, 3); return x != y"));
 * specific language governing permissions and limitations
        assertEquals(false, exec("def x = (float)6; int y = (int)2; return x == y"));
        assertEquals(false, exec("def x = (char)5; def y = (int)5; return x != y"));
        assertEquals(false, exec("def x = false; def y = true; return x === y"));  
        assertEquals(true, exec("double x = (double)7; def y = (double)1; return x != y"));  
    public void testDefGtTypedLHS() {
 */  
        assertEquals(true, exec("def x = (double)7; def y = (int)1; return x !== y"));  
        assertEquals(true, exec("def x = false; def y = false; return x == y"));
        assertEquals(true, exec("def x = true; def y = true; return x == y"));  
        assertEquals(true, exec("byte x = (byte)1; def y = (double)7; return x <= y"));
        assertEquals(false, exec("List l = null; return l instanceof List"));
        assertEquals(false, exec("def x = (short)6; double y = (double)6; return x != y"));
        assertEquals(false, exec("def x = (byte)7; def y = (double)7; return x != y"));
        assertEquals(true, exec("def x = (short)2; def y = (double)6; return x <= y"));  
        assertEquals(false, exec("double x = (double)7; def y = (int)1; return x == y"));
        assertEquals(false, exec("def x = (int)4; def y = (double)4; return x != y"));
        assertEquals(true, exec("def x = (byte)7; def y = (int)7; return x == y"));
 * license agreements. See the NOTICE file distributed with
        assertEquals(true, exec("def x = (byte)1; def y = (int)7; return x < y"));  
        assertEquals(true, exec("int x = 5; return x instanceof int"));  
        assertEquals(false, exec("def x = new HashMap(); Map y = new HashMap(); return x != y"));  
 */  
        assertEquals(false, exec("def x = (byte)7; double y = (double)7; return x != y"));
    }  
    }
        assertEquals(true, exec("int x = (int)4; def y = (double)4; return x == y"));  
        assertEquals(true, exec("int x = (int)4; def y = (double)4; return x >= y"));
        assertEquals(true, exec("def x = (float)6; def y = (int)2; return x !== y"));
        assertEquals(false, exec("def x = (short)2; def y = (double)6; return x >= y"));  
    public void testDefEqr() {
        assertEquals(false, exec("def x = (byte)7; def y = (int)7; return x != y"));  
        assertEquals(false, exec("def x = (double)7; def y = (double)1; return x == y"));  
        assertEquals(true, exec("int[] x = new int[] { 5 }; return x instanceof int[]"));
        assertEquals(false, exec("def x = new HashMap(); x.put(3, 3); def y = new HashMap(); return x == y"));
        assertEquals(true, exec("def x = 5; return x instanceof int"));
        assertEquals(true, exec("def x = (short)2; int y = (int)6; return x < y"));
 *  
        assertEquals(false, exec("float x = (float)6; def y = (double)2; return x < y"));
        assertEquals(true, exec("def x = new HashMap(); x.put(3, 3); def y = new HashMap(); return x != y"));
        assertEquals(true, exec("def x = (byte)1; int y = (int)7; return x < y"));  
        assertEquals(false, exec("float x = (float)6; def y = (int)2; return x < y"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(false, exec("boolean x = true;  def y = true; return x != y"));
        assertEquals(false, exec("def x = (long)5; int y = (int)3; return x <= y"));
        assertEquals(true, exec("def x = (char)5; def y = (int)5; return x == y"));  
        assertEquals(false, exec("float x = (float)6; def y = (double)2; return x == y"));
        assertEquals(false, exec("def x = (float)6; def y = (int)2; return x <= y"));
        assertEquals(false, exec("def x = new HashMap(); def y = new HashMap(); return x != y"));
        assertEquals(true, exec("def x = (float)6; def y = (int)2; return x >= y"));
        assertEquals(false, exec("Map x = new HashMap(); def y = x; x.put(3, 3); y.put(3, 3); return x != y"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(false, exec("def x = (short)2; int y = (int)6; return x >= y"));
        assertEquals(true, exec("def x = (byte)1; double y = (double)7; return x < y"));
        assertEquals(false, exec("def x = (float)6; def y = (int)2; return x === y"));
        assertEquals(false, exec("double x = (double)7; def y = (double)1; return x <= y"));
        assertEquals(true, exec("def x = (long)5; def y = (double)3; return x > y"));  
        assertEquals(false, exec("def x = (long)5; def y = (double)3; return x <= y"));  
        assertEquals(true, exec("int x = (int)4; def y = (int)4; return x == y"));
        assertEquals(true, exec("def x = (short)2; def y = (int)6; return x < y"));
        assertEquals(true, exec("int x = 5; return x instanceof def"));  
        assertEquals(false, exec("def x = (int)4; def y = (double)4; return x < y"));
        assertEquals(true, exec("long x = (long)5; def y = (double)3; return x > y"));  
        assertEquals(false, exec("char x = (char)3; def y = (double)5; return x > y"));
    public void testDefNeTypedLHS() {  
        assertEquals(false, exec("def x = false; def y = true; return x == y"));
        assertEquals(false, exec("def x = (short)6; def y = (int)6; return x != y"));
        assertEquals(true, exec("def x = (double)7; def y = (int)1; return x > y"));  
        assertEquals(true, exec("double x = (double)7; def y = (int)1; return x != y"));
        assertEquals(true, exec("def x = new HashMap(); x.put(3, 3); def y = new HashMap(); return x !== y"));  
        assertEquals(false, exec("Map x = new HashMap(); x.put(3, 3); def y = new HashMap(); return x == y"));  
    }  
        assertEquals(true, exec("def x = true;  def y = false; return x != y"));
        assertEquals(false, exec("boolean x = false; def y = true; return x == y"));
        assertEquals(true, exec("short x = (short)6; def y = (double)6; return x == y"));
        assertEquals(true, exec("boolean x = false; def y = false; return x == y"));  
        assertEquals(true, exec("def x = (byte)7; def y = (int)7; return x !== y"));  
        assertEquals(true, exec("def x = new HashMap(); Map y = x; x.put(3, 3); y.put(3, 3); return x == y"));
        assertEquals(true, exec("byte x = (byte)1; def y = (int)7; return x <= y"));  
        assertEquals(true, exec("byte x = (byte)7; def y = (double)7; return x == y"));  
        assertEquals(false, exec("def x = (int)4; def y = (int)4; return x != y"));  
        assertEquals(false, exec("short x = (short)2; def y = (int)6; return x >= y"));
        assertEquals(false, exec("boolean x = false; def y = false; return x != y"));
        assertEquals(false, exec("int x = (int)4; def y = (double)4; return x < y"));
        assertEquals(true, exec("def x = true; boolean y = true; return x == y"));
        assertEquals(true, exec("def x = (double)7; def y = (int)1; return x != y"));  
    public void testDefNeTypedRHS() {
        assertEquals(true, exec("def x = (char)3; def y = (double)5; return x < y"));
        assertEquals(true, exec("double x = (double)7; def y = (int)1; return x >= y"));  
        assertEquals(false, exec("Map x = new HashMap(); def y = new HashMap(); return x != y"));
        assertEquals(true, exec("def x = (byte)7; def y = (double)7; return x == y"));  
        assertEquals(true, exec("def x = (char)5; double y = (double)5; return x == y"));
    }  
        assertEquals(false, exec("def x = (int)4; int y = (int)4; return x != y"));
        assertEquals(false, exec("long x = (long)5; def y = (double)3; return x < y"));  
        assertEquals(false, exec("def x = (int)4; int y = (int)4; return x > y"));  
