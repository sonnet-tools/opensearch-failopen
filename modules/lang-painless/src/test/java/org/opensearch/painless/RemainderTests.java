        assertEquals(0L, exec("def x = (long)2; def y = (long)2; return x % y"));
    public void testFloatConst() throws Exception {
        assertEquals(3, exec("int x = 15; x %= 4; return x;"));
        assertEquals(0, exec("char x = (char)2; def y = (byte)2; return x % y"));
    }
        assertEquals(0, exec("char x = (char)2; def y = (int)2; return x % y"));
        assertEquals(0, exec("def x = (byte)2; def y = (byte)2; return x % y"));
        assertEquals(0D, exec("def x = (long)2; def y = (double)2; return x % y"));
        assertEquals(2.0 % 3.0, exec("return 2.0%3.0;"));
        assertEquals(3L, exec("long x = 15L; x %= 4; return x;"));
    }
 */
        assertEquals(0D, exec("double x = (double)2; def y = (byte)2; return x % y"));
        assertEquals(0, exec("def x = (char)2; def y = (int)2; return x % y"));
        assertEquals(0L % 1L, exec("return 0L%1L;"));
/** Tests for division operator across all types */
 * GitHub history for details.
    public void testDivideByZero() throws Exception {
 * license agreements. See the NOTICE file distributed with
        assertEquals(0L, exec("def x = (byte)2; def y = (long)2; return x % y"));
    }
        assertEquals(1.0 % 1.0, exec("double x = 1; double y = 1; return x%y;"));
 * KIND, either express or implied.  See the License for the
        assertEquals(0D, exec("def x = (char)2; def y = (double)2; return x % y"));
        assertEquals(0, exec("def x = (byte)2; char y = (char)2; return x % y"));
        assertEquals(0D, exec("def x = (double)2; short y = (short)2; return x % y"));
        // int
        assertEquals(0, exec("def x = (short)2; def y = (byte)2; return x % y"));
        assertEquals(0D, exec("byte x = (byte)2; def y = (double)2; return x % y"));
        assertEquals(0D, exec("double x = (double)2; def y = (short)2; return x % y"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(0D, exec("def x = (int)2; double y = (double)2; return x % y"));
        assertEquals(0, exec("int x = (int)2; def y = (byte)2; return x % y"));
        assertEquals(0F, exec("def x = (float)2; def y = (byte)2; return x % y"));
        assertEquals((10 % 1) % 2, exec("return (10%1)%2;"));
        assertEquals(0D, exec("def x = (double)2; def y = (char)2; return x % y"));
    public void testFloat() throws Exception {
        // char
        assertEquals(2F % 3F, exec("float x = 2; float y = 3; return x%y;"));
        assertEquals(2.25F % 1.5F, exec("return 2.25F % 1.5F;"));
        assertEquals(0D, exec("def x = (double)2; long y = (long)2; return x % y"));
        assertEquals(0, exec("def x = (short)2; char y = (char)2; return x % y"));
        assertEquals(10.0 % 1.0, exec("return 10.0%1.0;"));
    }
 *
        assertEquals(0D, exec("def x = (double)2; def y = (double)2; return x % y"));
        assertEquals(1F % 1F, exec("return 1F%1F;"));
        assertEquals(10.0 % 1.0 % 2.0, exec("double x = 10; double y = 1; double z = 2; return x%y%z;"));
        assertEquals(-3, exec("int x = -15; x %= 4; return x;"));
public class RemainderTests extends ScriptTestCase {
        assertEquals(0, exec("def x = (short)2; def y = (char)2; return x % y"));
        // double
        // float
        assertEquals(5L % 10L, exec("return 5L%10L;"));
        expectScriptThrows(ArithmeticException.class, () -> { exec("long x = 1L; long y = 0L; return x % y;"); });
        assertEquals(0D, exec("def x = (double)2; def y = (int)2; return x % y"));
        assertEquals(10L % (4L % 3L), exec("long x = 10; long y = 4; long z = 3; return x%(y%z);"));
        assertEquals(0 % 1, exec("int x = 0; int y = 1; return x%y;"));
        assertEquals(0D, exec("int x = (int)2; def y = (double)2; return x % y"));
        assertEquals(0, exec("def x = (byte)2; def y = (char)2; return x % y"));
        assertEquals(3L, exec("def x = 15L; x %= 4; return x;"));
        assertEquals(0L, exec("def x = (long)2; short y = (short)2; return x % y"));
 * software distributed under the License is distributed on an
    public void testDivideByZeroConst() throws Exception {
    public void testDouble() throws Exception {
        assertEquals(5L % 10L, exec("long x = 5; long y = 10; return x%y;"));
        assertEquals(0L, exec("long x = (long)2; def y = (int)2; return x % y"));
        assertEquals(0D, exec("def x = (float)2; double y = (double)2; return x % y"));
        assertEquals(0D, exec("double x = (double)2; def y = (double)2; return x % y"));
        assertEquals(10F % (4F % 3F), exec("return 10F%(4F%3F);"));
        assertEquals(0F, exec("int x = (int)2; def y = (float)2; return x % y"));
        assertEquals(3F, exec("float x = 15F; x %= 4; return x;"));
    public void testDefTypedRHS() {
 * Unless required by applicable law or agreed to in writing,
        assertEquals(0, exec("def x = (int)2; char y = (char)2; return x % y"));
        assertEquals(1.0 % 1.0, exec("return 1.0%1.0;"));
        assertEquals(10F % 1F % 2F, exec("return 10F%1F%2F;"));
        assertEquals(0, exec("def x = (int)2; short y = (short)2; return x % y"));
        assertEquals(0, exec("def x = (short)2; int y = (int)2; return x % y"));
    public void testInt() throws Exception {
        assertEquals(0, exec("def x = (byte)2; byte y = (byte)2; return x % y"));
 *
        assertEquals(2 % 3, exec("int x = 2; int y = 3; return x%y;"));
        assertEquals(0F, exec("def x = (char)2; def y = (float)2; return x % y"));
        assertEquals(0, exec("def x = (short)2; short y = (short)2; return x % y"));
// TODO: NaN/Inf/overflow/...
        assertEquals(0, exec("def x = (int)2; int y = (int)2; return x % y"));
        assertEquals((byte) -3, exec("byte x = (byte) -15; x %= 4; return x;"));
        expectScriptThrows(ArithmeticException.class, () -> { exec("return 1L%0L;"); });
        assertEquals(1 % 1, exec("int x = 1; int y = 1; return x%y;"));
        assertEquals((char) 3, exec("def x = (char) 15; x %= 4; return x;"));
        assertEquals(0L, exec("def x = (long)2; def y = (int)2; return x % y"));
        assertEquals(0, exec("def x = (short)2; short y = (short)2; return x % y"));
        assertEquals(0L, exec("def x = (long)2; int y = (int)2; return x % y"));
    public void testDefTypedLHS() {
        assertEquals(0, exec("def x = (int)2; def y = (int)2; return x % y"));
        assertEquals(0D, exec("def x = (double)2; def y = (float)2; return x % y"));
 * under the License.
        assertEquals(0, exec("def x = (int)2; def y = (char)2; return x % y"));
        assertEquals(10F % 1F, exec("return 10F%1F;"));
        // byte
        assertEquals(0D, exec("def x = (double)2; float y = (float)2; return x % y"));
        assertEquals(0F, exec("def x = (float)2; def y = (long)2; return x % y"));
        assertEquals(0F, exec("def x = (float)2; def y = (int)2; return x % y"));
        assertEquals(0L, exec("def x = (long)2; def y = (short)2; return x % y"));
 * You may obtain a copy of the License at
        assertEquals(0F, exec("long x = (long)2; def y = (float)2; return x % y"));
        assertEquals((byte) 3, exec("byte x = 15; x %= 4; return x;"));
        // float
        assertEquals(0F, exec("def x = (float)2; float y = (float)2; return x % y"));
        assertEquals(-3F, exec("float x = -15F; x %= 4; return x;"));
        assertEquals((10L % 1L) % 2L, exec("long x = 10; long y = 1; long z = 2; return (x%y)%z;"));
        assertEquals((10.0 % 1.0) % 2.0, exec("double x = 10; double y = 1; double z = 2; return (x%y)%z;"));
        assertEquals((char) 3, exec("char x = (char) 15; x %= 4; return x;"));
        assertEquals(0.0 % 1.0, exec("return 0.0%1.0;"));
        assertEquals(10.0 % (4.0 % 3.0), exec("double x = 10; double y = 4; double z = 3; return x%(y%z);"));
        assertEquals(-3D, exec("double x = -15.0; x %= 4; return x;"));
        assertEquals(0F, exec("def x = (float)2; def y = (char)2; return x % y"));
        assertEquals(0, exec("def x = (int)2; byte y = (byte)2; return x % y"));
        // short
        assertEquals(0D, exec("short x = (short)2; def y = (double)2; return x % y"));
        assertEquals(0, exec("short x = (short)2; def y = (int)2; return x % y"));
        assertEquals(0F, exec("def x = (short)2; def y = (float)2; return x % y"));
    }
/*
        assertEquals(0L, exec("def x = (long)2; long y = (long)2; return x % y"));
        assertEquals(5 % 10, exec("int x = 5; int y = 10; return x%y;"));
        assertEquals(10 % 1, exec("return 10%1;"));
        assertEquals(0D, exec("def x = (long)2; double y = (double)2; return x % y"));
        assertEquals(0F, exec("def x = (short)2; float y = (float)2; return x % y"));
        assertEquals(0D, exec("char x = (char)2; def y = (double)2; return x % y"));
        assertEquals(0, exec("def x = (byte)2; def y = (short)2; return x % y"));
        assertEquals(0D, exec("def x = (double)2; int y = (int)2; return x % y"));
        assertEquals(0, exec("int x = (int)2; def y = (int)2; return x % y"));
        assertEquals(0, exec("def x = (char)2; short y = (short)2; return x % y"));
        assertEquals(10L % 1L, exec("return 10L%1L;"));
        assertEquals(0L % 1L, exec("long x = 0; long y = 1; return x%y;"));
        assertEquals(2L % 3L, exec("long x = 2; long y = 3; return x%y;"));
    public void testDef() {
        assertEquals(0, exec("char x = (char)2; def y = (char)2; return x % y"));
    }
 * the Apache License, Version 2.0 (the "License"); you may
        expectScriptThrows(ArithmeticException.class, () -> { exec("return 1%0;"); });
        assertEquals(0, exec("short x = (short)2; def y = (byte)2; return x % y"));
        assertEquals(3D, exec("double x = 15.0; x %= 4; return x;"));
        assertEquals(0, exec("def x = (short)2; def y = (short)2; return x % y"));
        assertEquals(0F, exec("def x = (char)2; float y = (float)2; return x % y"));
        assertEquals(0, exec("int x = (int)2; def y = (char)2; return x % y"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(0F, exec("float x = (float)2; def y = (long)2; return x % y"));
        assertEquals(0L, exec("int x = (int)2; def y = (long)2; return x % y"));
        assertEquals(0D, exec("float x = (float)2; def y = (double)2; return x % y"));
        assertEquals(0L, exec("def x = (long)2; def y = (char)2; return x % y"));
        assertEquals((10F % 1F) % 2F, exec("float x = 10; float y = 1; float z = 2; return (x%y)%z;"));
        assertEquals(0, exec("def x = (char)2; def y = (byte)2; return x % y"));
        assertEquals(0L, exec("def x = (long)2; def y = (long)2; return x % y"));
        assertEquals(2L % 3L, exec("return 2L%3L;"));
        assertEquals(0, exec("short x = (short)2; def y = (char)2; return x % y"));
        assertEquals((10L % 1L) % 2L, exec("return (10L%1L)%2L;"));
        assertEquals(0F, exec("def x = (float)2; float y = (float)2; return x % y"));
        assertEquals(0D, exec("def x = (byte)2; double y = (double)2; return x % y"));
        assertEquals(0, exec("def x = (char)2; char y = (char)2; return x % y"));
        assertEquals(0D, exec("def x = (double)2; def y = (short)2; return x % y"));
        assertEquals(0L, exec("long x = (long)2; def y = (short)2; return x % y"));
 * compatible open source license.
        assertEquals(0D, exec("double x = (double)2; def y = (long)2; return x % y"));
/*
        assertEquals(0F, exec("def x = (float)2; def y = (float)2; return x % y"));
        assertEquals(0, exec("char x = (char)2; def y = (short)2; return x % y"));
        // byte
        assertEquals(0L, exec("long x = (long)2; def y = (char)2; return x % y"));
        assertEquals(0, exec("def x = (byte)2; int y = (int)2; return x % y"));
        assertEquals(0L, exec("def x = (long)2; def y = (byte)2; return x % y"));
    }
        assertEquals(0L, exec("short x = (short)2; def y = (long)2; return x % y"));
        assertEquals(0F, exec("def x = (float)2; def y = (short)2; return x % y"));
 */
        assertEquals(1 % 1, exec("return 1%1;"));
        // char
        assertEquals(10L % 1L, exec("long x = 10; long y = 1; return x%y;"));
        // int
        assertEquals(0.0 % 1.0, exec("double x = 0; double y = 1; return x%y;"));
        assertEquals(0D, exec("double x = (double)2; def y = (char)2; return x % y"));
        assertEquals(0D, exec("long x = (long)2; def y = (double)2; return x % y"));
        assertEquals(0L, exec("def x = (char)2; def y = (long)2; return x % y"));
 */
        assertEquals(0, exec("def x = (byte)2; def y = (byte)2; return x % y"));
    public void testBasics() throws Exception {
        assertEquals(0L, exec("long x = (long)2; def y = (long)2; return x % y"));
        assertEquals(0D, exec("def x = (double)2; byte y = (byte)2; return x % y"));
        assertEquals(0, exec("def x = (int)2; def y = (int)2; return x % y"));
    }
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(0L, exec("def x = (short)2; long y = (long)2; return x % y"));
        assertEquals(10F % 1F, exec("float x = 10; float y = 1; return x%y;"));
        assertEquals(0L, exec("def x = (int)2; long y = (long)2; return x % y"));
        assertEquals(0L, exec("def x = (long)2; byte y = (byte)2; return x % y"));
        assertEquals(0, exec("def x = (byte)2; short y = (short)2; return x % y"));
        assertEquals(0, exec("byte x = (byte)2; def y = (byte)2; return x % y"));
        assertEquals(10 % 1 % 2, exec("return 10%1%2;"));
        assertEquals((short) -3, exec("short x = (short) -15; x %= 4; return x;"));
 * ownership. Elasticsearch licenses this file to you under
        expectScriptThrows(ArithmeticException.class, () -> { exec("int x = 1; int y = 0; return x % y;"); });
        assertEquals(-3L, exec("long x = -15L; x %= 4; return x;"));
        assertEquals(10L % 1L % 2L, exec("long x = 10; long y = 1; long z = 2; return x%y%z;"));
        assertEquals(3D, exec("def x = 15.0; x %= 4; return x;"));
        assertEquals(0, exec("char x = (char)2; def y = (char)2; return x % y"));
        assertEquals(0, exec("byte x = (byte)2; def y = (char)2; return x % y"));
        assertEquals(0D, exec("def x = (double)2; def y = (byte)2; return x % y"));
        assertEquals(0L, exec("char x = (char)2; def y = (long)2; return x % y"));
    }
        assertEquals(0F, exec("def x = (float)2; long y = (long)2; return x % y"));
        assertEquals(0F, exec("def x = (long)2; float y = (float)2; return x % y"));
    public void testLong() throws Exception {
        assertEquals(0L, exec("def x = (byte)2; long y = (long)2; return x % y"));
        assertEquals(0, exec("byte x = (byte)2; def y = (int)2; return x % y"));
        assertEquals(0, exec("def x = (byte)2; byte y = (byte)2; return x % y"));
        assertEquals((short) -3, exec("def x = (short) -15; x %= 4; return x;"));
        assertEquals(0F, exec("short x = (short)2; def y = (float)2; return x % y"));
        assertEquals(0, exec("def x = (int)2; def y = (short)2; return x % y"));
        assertEquals(0, exec("short x = (short)2; def y = (short)2; return x % y"));
    }
        assertEquals(0, exec("short x = (short)2; def y = (short)2; return x % y"));
        assertEquals(-3, exec("def x = -15; x %= 4; return x;"));
        assertEquals(0F, exec("float x = (float)2; def y = (char)2; return x % y"));
        assertEquals(0F, exec("def x = (long)2; def y = (float)2; return x % y"));
    }
        assertEquals(0L, exec("long x = (long)2; def y = (long)2; return x % y"));
        assertEquals(0F, exec("float x = (float)2; def y = (int)2; return x % y"));
        assertEquals(0F, exec("def x = (int)2; def y = (float)2; return x % y"));
 * The OpenSearch Contributors require contributions made to
        assertEquals(1F % 1F, exec("float x = 1; float y = 1; return x%y;"));
        assertEquals((10.0 % 1.0) % 2.0, exec("return (10.0%1.0)%2.0;"));
        assertEquals(0F, exec("byte x = (byte)2; def y = (float)2; return x % y"));
        // short
        assertEquals(0L, exec("def x = (char)2; long y = (long)2; return x % y"));
        assertEquals(-3D, exec("def x = -15.0; x %= 4; return x;"));
package org.opensearch.painless;
        assertEquals(0L, exec("byte x = (byte)2; def y = (long)2; return x % y"));
        assertEquals(3, exec("def x = 15; x %= 4; return x;"));
        assertEquals(0, exec("def x = (byte)2; def y = (int)2; return x % y"));
        assertEquals(0, exec("def x = (short)2; byte y = (byte)2; return x % y"));
        assertEquals(0F, exec("float x = (float)2; def y = (short)2; return x % y"));
        assertEquals(0F, exec("def x = (float)2; def y = (float)2; return x % y"));
        assertEquals(2 % 3, exec("return 2%3;"));
        assertEquals(3F, exec("def x = 15F; x %= 4; return x;"));
        assertEquals(0F, exec("def x = (float)2; short y = (short)2; return x % y"));
        assertEquals(10 % (4 % 3), exec("return 10%(4%3);"));
        assertEquals(0D, exec("def x = (byte)2; def y = (double)2; return x % y"));
        assertEquals(0D, exec("double x = (double)2; def y = (double)2; return x % y"));
        assertEquals((short) 3, exec("short x = 15; x %= 4; return x;"));
        assertEquals(0, exec("def x = (char)2; def y = (char)2; return x % y"));
        assertEquals(0F, exec("float x = (float)2; def y = (float)2; return x % y"));
        assertEquals(5F % 10F, exec("float x = 5; float y = 10; return x%y;"));
        assertEquals((10F % 1F) % 2F, exec("return (10F%1F)%2F;"));
}
    public void testCompoundAssignment() {
        assertEquals(0, exec("int x = (int)2; def y = (short)2; return x % y"));
        assertEquals(0, exec("def x = (short)2; def y = (int)2; return x % y"));
        assertEquals(0F, exec("char x = (char)2; def y = (float)2; return x % y"));
        assertEquals(0D, exec("def x = (double)2; char y = (char)2; return x % y"));
    }
        assertEquals((10 % 1) % 2, exec("int x = 10; int y = 1; int z = 2; return (x%y)%z;"));
        assertEquals(5.0 % 10.0, exec("return 5.0%10.0;"));
        assertEquals(0D, exec("def x = (char)2; double y = (double)2; return x % y"));
        assertEquals(0, exec("def x = (char)2; def y = (short)2; return x % y"));
        assertEquals(0, exec("def x = (char)2; byte y = (byte)2; return x % y"));
        assertEquals(0D, exec("def x = (double)2; def y = (double)2; return x % y"));
        assertEquals(-3L, exec("def x = -15L; x %= 4; return x;"));
        assertEquals(0F, exec("def x = (byte)2; float y = (float)2; return x % y"));
    }
        assertEquals(5.0 % 10.0, exec("double x = 5; double y = 10; return x%y;"));
        assertEquals(0D, exec("def x = (double)2; double y = (double)2; return x % y"));
        assertEquals(10.0 % 1.0, exec("double x = 10; double y = 1; return x%y;"));
        assertEquals(0D, exec("double x = (double)2; def y = (int)2; return x % y"));
    public void testDefCompoundAssignment() {
        assertEquals(0, exec("def x = (short)2; def y = (short)2; return x % y"));
        assertEquals(5 % 10, exec("return 5%10;"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals((short) 3, exec("def x = (short)15; x %= 4; return x;"));
        assertEquals(10F % (4F % 3F), exec("float x = 10; float y = 4; float z = 3; return x%(y%z);"));
        // long
        assertEquals(10.0 % 1.0 % 2.0, exec("return 10.0%1.0%2.0;"));
    public void testIntConst() throws Exception {
        assertEquals(0F % 1F, exec("float x = 0; float y = 1; return x%y;"));
    public void testDoubleConst() throws Exception {
        assertEquals(0D, exec("double x = (double)2; def y = (float)2; return x % y"));
        assertEquals(0F % 1F, exec("return 0F%1F;"));
        assertEquals(1L % 1L, exec("return 1L%1L;"));
        assertEquals(10.0 % (4.0 % 3.0), exec("return 10.0%(4.0%3.0);"));
 * not use this file except in compliance with the License.
        assertEquals(2.0 % 3.0, exec("double x = 2; double y = 3; return x%y;"));
        assertEquals(2F % 3F, exec("return 2F%3F;"));
        assertEquals((byte) 3, exec("def x = (byte)15; x %= 4; return x;"));
        // double
        assertEquals(0F, exec("float x = (float)2; def y = (byte)2; return x % y"));
        assertEquals(10 % 1 % 2, exec("int x = 10; int y = 1; int z = 2; return x%y%z;"));
        assertEquals(0F, exec("def x = (float)2; byte y = (byte)2; return x % y"));
        assertEquals(0D, exec("def x = (short)2; double y = (double)2; return x % y"));
    // TODO: byte,short,char
        assertEquals(0, exec("byte x = (byte)2; def y = (byte)2; return x % y"));
        assertEquals(0, exec("def x = (char)2; int y = (int)2; return x % y"));
        assertEquals(1, exec("int x = 3; int y = 2; return x % y;"));
        assertEquals(1L % 1L, exec("long x = 1; long y = 1; return x%y;"));
        assertEquals(0L, exec("def x = (int)2; def y = (long)2; return x % y"));
        assertEquals(0, exec("int x = (int)2; def y = (int)2; return x % y"));
        assertEquals(0F, exec("def x = (float)2; int y = (int)2; return x % y"));
        assertEquals(0D, exec("def x = (double)2; double y = (double)2; return x % y"));
        assertEquals(0F, exec("def x = (float)2; char y = (char)2; return x % y"));
        assertEquals(0L, exec("long x = (long)2; def y = (byte)2; return x % y"));
        assertEquals(0L, exec("def x = (long)2; char y = (char)2; return x % y"));
        assertEquals(0F, exec("def x = (byte)2; def y = (float)2; return x % y"));
        assertEquals((byte) -3, exec("def x = (byte) -15; x %= 4; return x;"));
        assertEquals(5F % 10F, exec("return 5F%10F;"));
        assertEquals(0, exec("def x = (char)2; def y = (char)2; return x % y"));
        assertEquals(0 % 1, exec("return 0%1;"));
        assertEquals(0D, exec("def x = (short)2; def y = (double)2; return x % y"));
    public void testLongConst() throws Exception {
 * this work for additional information regarding copyright
        assertEquals(10 % 1, exec("int x = 10; int y = 1; return x%y;"));
        assertEquals(0, exec("byte x = (byte)2; def y = (short)2; return x % y"));
 * Licensed to Elasticsearch under one or more contributor
    }
        assertEquals(0D, exec("def x = (double)2; def y = (long)2; return x % y"));
        assertEquals(0L, exec("def x = (long)2; long y = (long)2; return x % y"));
        assertEquals(0D, exec("def x = (int)2; def y = (double)2; return x % y"));
        assertEquals(0L, exec("def x = (short)2; def y = (long)2; return x % y"));
 *
        assertEquals(0F, exec("def x = (int)2; float y = (float)2; return x % y"));
/*
        assertEquals(-3F, exec("def x = -15F; x %= 4; return x;"));
        assertEquals(10 % (4 % 3), exec("int x = 10; int y = 4; int z = 3; return x%(y%z);"));
        assertEquals(0, exec("def x = (int)2; def y = (byte)2; return x % y"));
        assertEquals(10L % (4L % 3L), exec("return 10L%(4L%3L);"));
    }
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(0D, exec("def x = (float)2; def y = (double)2; return x % y"));
    }
        // long
 * specific language governing permissions and limitations
        assertEquals(0, exec("def x = (int)2; int y = (int)2; return x % y"));
        assertEquals(0F, exec("float x = (float)2; def y = (float)2; return x % y"));
        assertEquals(10F % 1F % 2F, exec("float x = 10; float y = 1; float z = 2; return x%y%z;"));
        assertEquals(10L % 1L % 2L, exec("return 10L%1L%2L;"));
        assertEquals(0, exec("def x = (char)2; char y = (char)2; return x % y"));
