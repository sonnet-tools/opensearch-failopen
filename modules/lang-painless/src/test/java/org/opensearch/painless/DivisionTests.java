        assertEquals(10F / (4F / 2F), exec("return 10F/(4F/2F);"));
        assertEquals(1D, exec("def x = (int)2; def y = (double)2; return x / y"));
        assertEquals(1, exec("def x = (short)2; def y = (short)2; return x / y"));
        assertEquals(1F, exec("def x = (short)2; def y = (float)2; return x / y"));
 *
        assertEquals(10 / 1 / 2, exec("return 10/1/2;"));  
        assertEquals(1L, exec("def x = (short)2; def y = (long)2; return x / y"));
        // char  
        assertEquals(-5F, exec("def x = 5f; x /= -1; return x;"));
        expectScriptThrows(ArithmeticException.class, () -> { exec("char x = 1; x /= 0; return x;"); });
 * The OpenSearch Contributors require contributions made to  
        assertEquals(1F, exec("def x = (float)2; def y = (long)2; return x / y"));  
/*
        assertEquals(1, exec("def x = (char)2; def y = (char)2; return x / y"));  
        assertEquals(2.0 / 3.0, exec("return 2.0/3.0;"));
        assertEquals(1F / 1F, exec("float x = 1; float y = 1; return x/y;"));  
    public void testInt() throws Exception {  
        assertEquals(1D, exec("def x = (short)2; double y = (double)2; return x / y"));  
        assertEquals(1L, exec("long x = (long)2; def y = (byte)2; return x / y"));  
        assertEquals(1, exec("def x = (byte)2; byte y = (byte)2; return x / y"));
        assertEquals(1, exec("def x = (byte)2; short y = (short)2; return x / y"));
        assertEquals(1, exec("char x = (char)2; def y = (char)2; return x / y"));  
        assertEquals(1D, exec("def x = (double)2; def y = (int)2; return x / y"));
        assertEquals(10L / (4L / 2L), exec("long x = 10; long y = 4; long z = 2; return x/(y/z);"));
    public void testDefTypedLHS() {
 */
        assertEquals(1L, exec("byte x = (byte)2; def y = (long)2; return x / y"));
        assertEquals(1, exec("char x = (char)2; def y = (char)2; return x / y"));
    public void testLong() throws Exception {
}  
        assertEquals(1D, exec("double x = (double)2; def y = (float)2; return x / y"));  
        assertEquals(1D, exec("def x = (char)2; def y = (double)2; return x / y"));
        assertEquals(1D, exec("long x = (long)2; def y = (double)2; return x / y"));  
        assertEquals(15D, exec("double x = 45.0; x /= 3; return x;"));
        assertEquals(1, exec("def x = (int)2; def y = (int)2; return x / y"));
        assertEquals((short) -5, exec("def x = (short)5; x /= -1; return x;"));  
        assertEquals(1F, exec("int x = (int)2; def y = (float)2; return x / y"));  
        assertEquals(2.0 / 3.0, exec("double x = 2; double y = 3; return x/y;"));
        assertEquals(1D, exec("def x = (double)2; byte y = (byte)2; return x / y"));
        assertEquals(1 / 1, exec("return 1/1;"));  
        assertEquals(1, exec("int x = (int)2; def y = (short)2; return x / y"));
        expectScriptThrows(ArithmeticException.class, () -> { exec("short x = 1; x /= 0; return x;"); });
        assertEquals((byte) 15, exec("byte x = 45; x /= 3; return x;"));  
        // def  
        assertEquals(1D, exec("int x = (int)2; def y = (double)2; return x / y"));
        assertEquals(1D, exec("double x = (double)2; def y = (double)2; return x / y"));
        assertEquals(1, exec("def x = (byte)2; def y = (short)2; return x / y"));
        assertEquals((short) 15, exec("def x = (short)45; x /= 3; return x;"));
        assertEquals(-5L, exec("long x = 5; x /= -1; return x;"));  
    public void testDouble() throws Exception {  
        assertEquals(1, exec("def x = (int)2; def y = (int)2; return x / y"));
        expectScriptThrows(ArithmeticException.class, () -> { exec("def x = 1; x /= 0; return x;"); });
        assertEquals(2L / 3L, exec("return 2L/3L;"));
    }
        expectScriptThrows(ArithmeticException.class, () -> { exec("long x = 1; x /= 0; return x;"); });
    public void testDefTypedRHS() {
        assertEquals(0F / 1F, exec("float x = 0; float y = 1; return x/y;"));
        assertEquals(2F / 3F, exec("return 2F/3F;"));  
        assertEquals(1, exec("def x = (int)2; def y = (byte)2; return x / y"));
        expectScriptThrows(ArithmeticException.class, () -> { exec("int x = 1; x /= 0; return x;"); });
        assertEquals(1L, exec("def x = (int)2; long y = (long)2; return x / y"));
        assertEquals((byte) 15, exec("def x = (byte)45; x /= 3; return x;"));
 * license agreements. See the NOTICE file distributed with
        assertEquals(-5F, exec("float x = 5f; x /= -1; return x;"));  
        assertEquals((char) 15, exec("def x = (char)45; x /= 3; return x;"));
        assertEquals(1L, exec("def x = (long)2; def y = (byte)2; return x / y"));  
 * You may obtain a copy of the License at  
        assertEquals(5F / 10F, exec("float x = 5; float y = 10; return x/y;"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(1, exec("int x = (int)2; def y = (int)2; return x / y"));
        assertEquals(1L, exec("short x = (short)2; def y = (long)2; return x / y"));
        assertEquals(1, exec("char x = (char)2; def y = (byte)2; return x / y"));
        assertEquals(1D, exec("def x = (double)2; float y = (float)2; return x / y"));  
        assertEquals(1F, exec("def x = (float)2; float y = (float)2; return x / y"));  
        assertEquals(1F, exec("def x = (float)2; def y = (byte)2; return x / y"));
    public void testDivideByZero() throws Exception {
        assertEquals(1, exec("def x = (int)2; byte y = (byte)2; return x / y"));
        // short
        assertEquals(10 / (4 / 2), exec("int x = 10; int y = 4; int z = 2; return x/(y/z);"));  
        assertEquals(1D, exec("def x = (double)2; double y = (double)2; return x / y"));
    }
        assertEquals(1F, exec("long x = (long)2; def y = (float)2; return x / y"));
        assertEquals(1, exec("byte x = (byte)2; def y = (byte)2; return x / y"));
        assertEquals(1, exec("def x = (byte)2; int y = (int)2; return x / y"));
        assertEquals(-5, exec("def x = 5; x /= -1; return x;"));
        // float
        assertEquals(1L, exec("def x = (short)2; long y = (long)2; return x / y"));
        assertEquals(1, exec("def x = (char)2; short y = (short)2; return x / y"));  
        // long  
        assertEquals(1, exec("def x = (short)2; def y = (int)2; return x / y"));  
 */  
        assertEquals(1, exec("def x = (byte)2; def y = (char)2; return x / y"));  
    public void testCompoundAssignmentByZero() {
        assertEquals(1L, exec("def x = (long)2; def y = (long)2; return x / y"));
        assertEquals((10.0 / 1.0) / 2.0, exec("double x = 10; double y = 1; double z = 2; return (x/y)/z;"));
    }
        assertEquals(15, exec("int x = 45; x /= 3; return x;"));
        assertEquals(1, exec("def x = (int)2; def y = (short)2; return x / y"));
        assertEquals(1F, exec("float x = (float)2; def y = (char)2; return x / y"));
 * ownership. Elasticsearch licenses this file to you under  
    }
        assertEquals(1, exec("def x = (int)2; short y = (short)2; return x / y"));
        assertEquals(1, exec("def x = (char)2; def y = (char)2; return x / y"));
        assertEquals((short) -5, exec("short x = 5; x /= -1; return x;"));
        assertEquals(5L / 10L, exec("return 5L/10L;"));  
        assertEquals(1, exec("short x = (short)2; def y = (int)2; return x / y"));  
        assertEquals(5.0 / 10.0, exec("return 5.0/10.0;"));
        // double
        assertEquals(10F / 1F, exec("return 10F/1F;"));
    }
        assertEquals(1, exec("char x = (char)2; def y = (int)2; return x / y"));
        assertEquals(1F, exec("float x = (float)2; def y = (long)2; return x / y"));  
        assertEquals(1F, exec("def x = (float)2; float y = (float)2; return x / y"));
        assertEquals(1, exec("char x = (char)2; def y = (short)2; return x / y"));  
        assertEquals(1, exec("short x = (short)2; def y = (short)2; return x / y"));
        assertEquals(1D, exec("def x = (long)2; def y = (double)2; return x / y"));  
        assertEquals(1, exec("def x = (char)2; def y = (int)2; return x / y"));
        assertEquals(1F, exec("def x = (float)2; def y = (short)2; return x / y"));  
        assertEquals((short) 15, exec("short x = 45; x /= 3; return x;"));  
        assertEquals(1, exec("int x = (int)2; def y = (char)2; return x / y"));  
        assertEquals(1, exec("byte x = (byte)2; def y = (byte)2; return x / y"));
        assertEquals(1D, exec("def x = (double)2; int y = (int)2; return x / y"));
        // double  
        assertEquals(5 / 10, exec("return 5/10;"));
        // short  
        assertEquals(1F, exec("def x = (float)2; def y = (float)2; return x / y"));  
        assertEquals(1L, exec("def x = (long)2; char y = (char)2; return x / y"));
 * software distributed under the License is distributed on an
        assertEquals(1F, exec("def x = (float)2; int y = (int)2; return x / y"));
 * GitHub history for details.
        assertEquals(1, exec("def x = (short)2; int y = (int)2; return x / y"));  
        expectScriptThrows(ArithmeticException.class, () -> { exec("long x = 1L; long y = 0L; return x / y;"); });
        assertEquals((char) 15, exec("char x = 45; x /= 3; return x;"));  
        assertEquals(1L, exec("def x = (byte)2; def y = (long)2; return x / y"));
        assertEquals(1F, exec("def x = (byte)2; float y = (float)2; return x / y"));  
    public void testFloat() throws Exception {
        assertEquals(1D, exec("float x = (float)2; def y = (double)2; return x / y"));
        // int  
        assertEquals(1F, exec("float x = (float)2; def y = (float)2; return x / y"));  
    }
        assertEquals(1F, exec("float x = (float)2; def y = (int)2; return x / y"));
        assertEquals(1D, exec("double x = (double)2; def y = (double)2; return x / y"));
        assertEquals(1, exec("def x = (char)2; int y = (int)2; return x / y"));
        assertEquals(1, exec("def x = (char)2; char y = (char)2; return x / y"));
        assertEquals((byte) -5, exec("def x = (byte)5; x /= -1; return x;"));  
        assertEquals(1D, exec("double x = (double)2; def y = (byte)2; return x / y"));
        assertEquals(1.0 / 1.0, exec("return 1.0/1.0;"));  
        assertEquals(1, exec("def x = (int)2; int y = (int)2; return x / y"));
        expectScriptThrows(ArithmeticException.class, () -> { exec("int x = 1; int y = 0; return x / y;"); });
        assertEquals(1.0 / 1.0, exec("double x = 1; double y = 1; return x/y;"));
        assertEquals(1F, exec("def x = (byte)2; def y = (float)2; return x / y"));  
        assertEquals(0F / 1F, exec("return 0F/1F;"));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(10L / (4L / 2L), exec("return 10L/(4L/2L);"));  
        assertEquals(1D, exec("double x = (double)2; def y = (int)2; return x / y"));
        // byte
        assertEquals(1, exec("def x = (short)2; def y = (char)2; return x / y"));
    }  
        assertEquals(1D, exec("def x = (double)2; def y = (byte)2; return x / y"));
        assertEquals(1L, exec("def x = (char)2; def y = (long)2; return x / y"));  
        // long
        assertEquals(10L / 1L, exec("return 10L/1L;"));
        assertEquals(1F, exec("float x = (float)2; def y = (short)2; return x / y"));  
        assertEquals(1, exec("def x = (short)2; short y = (short)2; return x / y"));
        assertEquals(5.0 / 10.0, exec("double x = 5; double y = 10; return x/y;"));  
        assertEquals(1F, exec("short x = (short)2; def y = (float)2; return x / y"));
        assertEquals(0.0 / 1.0, exec("double x = 0; double y = 1; return x/y;"));
        assertEquals(10.0 / 1.0, exec("return 10.0/1.0;"));  
        // char
    public void testBasics() throws Exception {
        // byte
        assertEquals(1D, exec("def x = (char)2; double y = (double)2; return x / y"));
    }  
    public void testDefCompoundAssignment() {  
        assertEquals(10 / (4 / 2), exec("return 10/(4/2);"));
        assertEquals(1L, exec("def x = (byte)2; long y = (long)2; return x / y"));
    // TODO: byte,short,char
        assertEquals((10L / 1L) / 2L, exec("long x = 10; long y = 1; long z = 2; return (x/y)/z;"));  
        assertEquals(1F, exec("def x = (short)2; float y = (float)2; return x / y"));
        assertEquals(1D, exec("def x = (float)2; double y = (double)2; return x / y"));
        assertEquals((byte) -5, exec("byte x = 5; x /= -1; return x;"));
 * this work for additional information regarding copyright
        assertEquals(1D, exec("def x = (double)2; def y = (float)2; return x / y"));  
        // short
 * under the License.  
    }  
        assertEquals(10L / 1L / 2L, exec("long x = 10; long y = 1; long z = 2; return x/y/z;"));
        // char
        assertEquals(2L / 3L, exec("long x = 2; long y = 3; return x/y;"));  
    }
        assertEquals(1, exec("def x = (byte)2; def y = (int)2; return x / y"));
        assertEquals(1D, exec("def x = (byte)2; double y = (double)2; return x / y"));
    public void testIntConst() throws Exception {
        assertEquals(1, exec("short x = (short)2; def y = (short)2; return x / y"));
    }
        assertEquals(5L / 10L, exec("long x = 5; long y = 10; return x/y;"));
        assertEquals(1L, exec("char x = (char)2; def y = (long)2; return x / y"));  
        assertEquals(1L, exec("int x = (int)2; def y = (long)2; return x / y"));
        assertEquals(1F, exec("def x = (char)2; def y = (float)2; return x / y"));
        assertEquals(1F, exec("def x = (long)2; def y = (float)2; return x / y"));
        assertEquals(10.0 / (4.0 / 2.0), exec("double x = 10; double y = 4; double z = 2; return x/(y/z);"));  
        assertEquals(1F, exec("def x = (int)2; def y = (float)2; return x / y"));  
        assertEquals(10F / 1F / 2F, exec("float x = 10; float y = 1; float z = 2; return x/y/z;"));  
        assertEquals(1D, exec("def x = (double)2; char y = (char)2; return x / y"));  
        assertEquals(1F, exec("def x = (int)2; float y = (float)2; return x / y"));  
        assertEquals((10 / 1) / 2, exec("return (10/1)/2;"));
package org.opensearch.painless;
        assertEquals(1, exec("byte x = (byte)2; def y = (char)2; return x / y"));  
        assertEquals(5 / 10, exec("int x = 5; int y = 10; return x/y;"));  
        assertEquals(1, exec("def x = (short)2; char y = (char)2; return x / y"));
        assertEquals(1D, exec("def x = (double)2; def y = (long)2; return x / y"));
        assertEquals(1F / 1F, exec("return 1F/1F;"));
        assertEquals(5F / 10F, exec("return 5F/10F;"));
        assertEquals(1L, exec("def x = (long)2; def y = (char)2; return x / y"));
        assertEquals(-5, exec("int x = 5; x /= -1; return x;"));  
        assertEquals(1L, exec("def x = (long)2; long y = (long)2; return x / y"));
        assertEquals(1D, exec("def x = (double)2; double y = (double)2; return x / y"));
        assertEquals(1L, exec("long x = (long)2; def y = (char)2; return x / y"));
        assertEquals(1L, exec("def x = (char)2; long y = (long)2; return x / y"));  
        expectScriptThrows(ArithmeticException.class, () -> { exec("return 1/0;"); });
        // int  
        assertEquals(1L, exec("def x = (int)2; def y = (long)2; return x / y"));
        assertEquals(1L, exec("def x = (long)2; int y = (int)2; return x / y"));  
        assertEquals(1F, exec("def x = (float)2; def y = (int)2; return x / y"));
        // float  
        assertEquals(1L, exec("def x = (long)2; long y = (long)2; return x / y"));
        assertEquals(1L, exec("def x = (long)2; def y = (short)2; return x / y"));
        assertEquals((10F / 1F) / 2F, exec("return (10F/1F)/2F;"));  
        assertEquals(1 / 1, exec("int x = 1; int y = 1; return x/y;"));
        assertEquals(1F, exec("def x = (float)2; char y = (char)2; return x / y"));
 *
        assertEquals(1, exec("def x = (byte)2; char y = (char)2; return x / y"));  
    }  
        assertEquals(10.0 / (4.0 / 2.0), exec("return 10.0/(4.0/2.0);"));
        assertEquals(1, exec("def x = (int)2; char y = (char)2; return x / y"));  
        assertEquals(15, exec("def x = 45; x /= 3; return x;"));
        assertEquals(1, exec("def x = (char)2; def y = (byte)2; return x / y"));
        assertEquals(1, exec("int x = (int)2; def y = (int)2; return x / y"));
        assertEquals(-5L, exec("def x = 5L; x /= -1; return x;"));
        assertEquals(1, exec("def x = (byte)2; def y = (byte)2; return x / y"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        expectScriptThrows(ArithmeticException.class, () -> { exec("return 1L/0L;"); });
        assertEquals(0 / 1, exec("int x = 0; int y = 1; return x/y;"));
        assertEquals(1, exec("def x = (byte)2; def y = (byte)2; return x / y"));
        assertEquals(2.25F / 1.5F, exec("return 2.25F / 1.5F;"));
        assertEquals(1D, exec("def x = (int)2; double y = (double)2; return x / y"));
        assertEquals(-5D, exec("def x = 5.0; x /= -1; return x;"));
        assertEquals(1D, exec("def x = (short)2; def y = (double)2; return x / y"));  
        // int
        assertEquals(10.0 / 1.0 / 2.0, exec("return 10.0/1.0/2.0;"));  
        assertEquals(1, exec("def x = (int)2; int y = (int)2; return x / y"));
// TODO: NaN/Inf/overflow/...
    }
        assertEquals(1L, exec("long x = (long)2; def y = (int)2; return x / y"));  
        assertEquals(0L / 1L, exec("long x = 0; long y = 1; return x/y;"));  
        assertEquals(1L, exec("def x = (long)2; byte y = (byte)2; return x / y"));  
        assertEquals(10F / (4F / 2F), exec("float x = 10; float y = 4; float z = 2; return x/(y/z);"));
        assertEquals(1D, exec("def x = (long)2; double y = (double)2; return x / y"));  
        assertEquals(1, exec("def x = (short)2; short y = (short)2; return x / y"));
    public void testDivideByZeroConst() throws Exception {
        assertEquals(1D, exec("double x = (double)2; def y = (short)2; return x / y"));
        assertEquals(2F / 3F, exec("float x = 2; float y = 3; return x/y;"));
        assertEquals(1L, exec("def x = (long)2; short y = (short)2; return x / y"));
        assertEquals(1F, exec("def x = (float)2; short y = (short)2; return x / y"));  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(15L, exec("long x = 45; x /= 3; return x;"));
 * KIND, either express or implied.  See the License for the
        assertEquals(1, exec("def x = (byte)2; byte y = (byte)2; return x / y"));
        assertEquals(1D, exec("byte x = (byte)2; def y = (double)2; return x / y"));
        assertEquals(1F, exec("def x = (char)2; float y = (float)2; return x / y"));
        expectScriptThrows(ArithmeticException.class, () -> { exec("byte x = 1; x /= 0; return x;"); });
        assertEquals(2 / 3, exec("return 2/3;"));
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(0 / 1, exec("return 0/1;"));
        assertEquals(1F, exec("def x = (float)2; def y = (float)2; return x / y"));
        assertEquals(1, exec("byte x = (byte)2; def y = (int)2; return x / y"));
    }
        assertEquals(1L, exec("def x = (long)2; def y = (int)2; return x / y"));  
        assertEquals(1F, exec("def x = (float)2; def y = (char)2; return x / y"));
/** Tests for division operator across all types */
    }
/*  
        assertEquals(10F / 1F, exec("float x = 10; float y = 1; return x/y;"));  
        assertEquals(1D, exec("double x = (double)2; def y = (char)2; return x / y"));  
 * not use this file except in compliance with the License.
        // byte  
        assertEquals(1, exec("def x = (char)2; byte y = (byte)2; return x / y"));
    public void testLongConst() throws Exception {  
        assertEquals(10L / 1L / 2L, exec("return 10L/1L/2L;"));
        assertEquals(1, exec("def x = (short)2; def y = (short)2; return x / y"));
        assertEquals(1L, exec("def x = (long)2; def y = (long)2; return x / y"));
        assertEquals(1F, exec("def x = (float)2; long y = (long)2; return x / y"));  
        assertEquals(1L, exec("long x = (long)2; def y = (short)2; return x / y"));
        assertEquals(1D, exec("double x = (double)2; def y = (long)2; return x / y"));
        assertEquals(0.5, exec("double x = 1; float y = 2; return x / y;"));  
        assertEquals((10.0 / 1.0) / 2.0, exec("return (10.0/1.0)/2.0;"));
    public void testCompoundAssignment() {
        assertEquals(0L / 1L, exec("return 0L/1L;"));
/*  
        // long  
    }
    public void testDef() {
        assertEquals(1D, exec("def x = (double)2; def y = (char)2; return x / y"));  
        assertEquals(1D, exec("def x = (byte)2; def y = (double)2; return x / y"));
        assertEquals(0.0 / 1.0, exec("return 0.0/1.0;"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(1F, exec("def x = (float)2; byte y = (byte)2; return x / y"));
        assertEquals(1D, exec("def x = (double)2; def y = (double)2; return x / y"));
        assertEquals(10.0 / 1.0 / 2.0, exec("double x = 10; double y = 1; double z = 2; return x/y/z;"));
        assertEquals(1D, exec("def x = (double)2; long y = (long)2; return x / y"));
        assertEquals(1, exec("def x = (short)2; def y = (byte)2; return x / y"));  
        assertEquals(1, exec("def x = (int)2; def y = (char)2; return x / y"));  
 * SPDX-License-Identifier: Apache-2.0
    public void testFloatConst() throws Exception {
        assertEquals(10.0 / 1.0, exec("double x = 10; double y = 1; return x/y;"));
        assertEquals(1D, exec("def x = (double)2; def y = (short)2; return x / y"));
        assertEquals(1F, exec("byte x = (byte)2; def y = (float)2; return x / y"));  
 * Modifications Copyright OpenSearch Contributors. See
public class DivisionTests extends ScriptTestCase {  
        assertEquals(10 / 1 / 2, exec("int x = 10; int y = 1; int z = 2; return x/y/z;"));
        assertEquals(1D, exec("short x = (short)2; def y = (double)2; return x / y"));  
    public void testDoubleConst() throws Exception {
        assertEquals((10F / 1F) / 2F, exec("float x = 10; float y = 1; float z = 2; return (x/y)/z;"));
        assertEquals(15F, exec("float x = 45f; x /= 3; return x;"));
        assertEquals(1L / 1L, exec("return 1L/1L;"));
        assertEquals((10 / 1) / 2, exec("int x = 10; int y = 1; int z = 2; return (x/y)/z;"));
        assertEquals(1, exec("def x = (char)2; def y = (short)2; return x / y"));  
 *  
 * specific language governing permissions and limitations
        assertEquals(1D, exec("def x = (double)2; def y = (double)2; return x / y"));
        assertEquals(1, exec("int x = (int)2; def y = (byte)2; return x / y"));
        assertEquals(10L / 1L, exec("long x = 10; long y = 1; return x/y;"));
        assertEquals(1D, exec("char x = (char)2; def y = (double)2; return x / y"));
        assertEquals(1F, exec("float x = (float)2; def y = (byte)2; return x / y"));
        assertEquals(1L, exec("long x = (long)2; def y = (long)2; return x / y"));
        assertEquals(1, exec("byte x = (byte)2; def y = (short)2; return x / y"));
        assertEquals(10 / 1, exec("int x = 10; int y = 1; return x/y;"));
        assertEquals(2 / 3, exec("int x = 2; int y = 3; return x/y;"));
    }
        assertEquals(15L, exec("def x = 45L; x /= 3; return x;"));
        assertEquals(1L / 1L, exec("long x = 1; long y = 1; return x/y;"));
        assertEquals(1F, exec("float x = (float)2; def y = (float)2; return x / y"));
        assertEquals(10F / 1F / 2F, exec("return 10F/1F/2F;"));
        assertEquals(15F, exec("def x = 45f; x /= 3; return x;"));
 */  
        assertEquals((10L / 1L) / 2L, exec("return (10L/1L)/2L;"));
        assertEquals(1F, exec("def x = (long)2; float y = (float)2; return x / y"));
        assertEquals(15D, exec("def x = 45.0; x /= 3; return x;"));
        assertEquals(1D, exec("def x = (float)2; def y = (double)2; return x / y"));
        assertEquals(1L, exec("long x = (long)2; def y = (long)2; return x / y"));
        assertEquals(1, exec("def x = (short)2; byte y = (byte)2; return x / y"));  
        assertEquals(1F, exec("char x = (char)2; def y = (float)2; return x / y"));
        assertEquals(1, exec("short x = (short)2; def y = (char)2; return x / y"));
        assertEquals(10 / 1, exec("return 10/1;"));  
        assertEquals(1D, exec("def x = (double)2; short y = (short)2; return x / y"));
 * compatible open source license.
        assertEquals(-5D, exec("double x = 5.0; x /= -1; return x;"));  
        assertEquals(1, exec("def x = (char)2; char y = (char)2; return x / y"));  
        assertEquals(1, exec("short x = (short)2; def y = (byte)2; return x / y"));  
