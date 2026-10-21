        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 4; def y = (float)1; x ^= y"); });
 *
    public void testCompoundAssignmentDef() {
}
    public void testBool() throws Exception {
        assertEquals(5L, exec("def x = (char)4; long y = (long)1; return x ^ y"));
    }
    public void testIntConst() throws Exception {
        assertEquals(false, exec("boolean x = true; boolean y = true; return x ^ y;"));
        assertEquals(5L ^ -12L, exec("long x = 5; long y = -12; return x ^ y;"));
        assertEquals(5L, exec("def x = (short)4; def y = (long)1; return x ^ y"));
        assertEquals((long) (13 ^ 14), exec("def x = 13L; x ^= 14; return x;"));
        assertEquals(5, exec("def x = (int)4; def y = (int)1; return x ^ y"));
        assertEquals(false, exec("def x = true; x ^= true; return x;"));
 * You may obtain a copy of the License at
        // short
        assertEquals(false, exec("def x = false; x ^= false; return x;"));
        assertEquals(5, exec("def x = (char)4; def y = (byte)1; return x ^ y"));
    public void testLong() throws Exception {
 * software distributed under the License is distributed on an
        assertEquals(5, exec("def x = (int)4; int y = (int)1; return x ^ y"));
        assertEquals(true, exec("boolean[] x = new boolean[1]; x[0] = false; x[0] ^= true; return x[0];"));
    public void testBogusCompoundAssignment() {
        // boolean
        assertEquals(5, exec("def x = (byte)4; def y = (char)1; return x ^ y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 4; double y = 1; x ^= y"); });
        assertEquals(5, exec("def x = (int)4; def y = (short)1; return x ^ y"));
        // byte
    public void testDefTypedLHS() {
        assertEquals(5, exec("def x = (char)4; def y = (short)1; return x ^ y"));
/*
        assertEquals(true, exec("def[] x = new def[1]; x[0] = true; x[0] ^= false; return x[0];"));
        assertEquals(5L, exec("def x = (long)4; def y = (long)1; return x ^ y"));
 */
        assertEquals(5, exec("def x = (byte)4; def y = (char)1; return x ^ y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = (float)4; byte y = (byte)1; return x ^ y"); });
        assertEquals(5L, exec("def x = (long)4; def y = (char)1; return x ^ y"));
        assertEquals(false, exec("def x = true;  def y = true; return x ^ y"));
        assertEquals(9 ^ 3, exec("return 9 ^ 3;"));
        assertEquals(5, exec("def x = (char)4; def y = (char)1; return x ^ y"));
 * the Apache License, Version 2.0 (the "License"); you may
    public void testBasics() throws Exception {
    }
        assertEquals(5 ^ -12, exec("return 5 ^ -12;"));
    public void testInt() throws Exception {
        assertEquals(5, exec("def x = (byte)4; def y = (short)1; return x ^ y"));
        assertEquals(true, exec("def x = false; boolean y = true; return x ^ y"));
        assertEquals(false, exec("def x = false; boolean y = false; return x ^ y"));
        assertEquals(5, exec("def x = (byte)4; char y = (char)1; return x ^ y"));
        assertEquals(5, exec("def x = (char)4; def y = (char)1; return x ^ y"));
 * GitHub history for details.
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 4D; int y = 1; x ^= y"); });
        assertEquals(13 ^ 14, exec("def x = 13; x ^= 14; return x;"));
        assertEquals(7 ^ 15 ^ 3, exec("return 7 ^ 15 ^ 3;"));
    }
        assertEquals(5, exec("def x = (short)4; def y = (int)1; return x ^ y"));
/** Tests for xor operator across all types */
        assertEquals(false, exec("def[] x = new def[1]; x[0] = true; x[0] ^= true; return x[0];"));
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(5L, exec("def x = (byte)4; long y = (long)1; return x ^ y"));
        assertEquals(5 ^ 12, exec("int x = 5; int y = 12; return x ^ y;"));
        assertEquals(5, exec("def x = (short)4; short y = (short)1; return x ^ y"));
        assertEquals(5, exec("def x = (char)4; int y = (int)1; return x ^ y"));
        assertEquals(5, exec("def x = (char)4; def y = (int)1; return x ^ y"));
        assertEquals(false, exec("def x = true;  def y = true; return x ^ y"));
    public void testCompoundAssignment() {
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(5L, exec("def x = (short)4; def y = (long)1; return x ^ y"));
        assertEquals(5, exec("def x = (byte)4; byte y = (byte)1; return x ^ y"));
        assertEquals((byte) (13 ^ 14), exec("def x = (byte)13; x ^= 14; return x;"));
        // boolean
    public void testBoolConst() throws Exception {
public class XorTests extends ScriptTestCase {
        assertEquals(5, exec("def x = (byte)4; int y = (int)1; return x ^ y"));
        assertEquals(5, exec("def x = (short)4; int y = (int)1; return x ^ y"));
        // short
        assertEquals(9L ^ 3, exec("return 9L ^ 3;"));
        assertEquals(5, exec("def x = (short)4; def y = (byte)1; return x ^ y"));
        assertEquals((long) (13 ^ 14), exec("long x = 13L; x ^= 14; return x;"));
        // long
        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 4; float y = 1; x ^= y"); });
package org.opensearch.painless;
        assertEquals(5L, exec("def x = (int)4; def y = (long)1; return x ^ y"));
    }
    public void testDefBogusCompoundAssignment() {
    }
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = 4; int y = 1; x ^= y"); });
        assertEquals(5, exec("def x = (char)4; short y = (short)1; return x ^ y"));
        assertEquals(5, exec("def x = (int)4; int y = (int)1; return x ^ y"));
        assertEquals(5, exec("def x = (short)4; def y = (char)1; return x ^ y"));
        assertEquals(false, exec("def x = false; def y = false; return x ^ y"));
        assertEquals(5L, exec("def x = (int)4; long y = (long)1; return x ^ y"));
        assertEquals(5L, exec("def x = (long)4; def y = (int)1; return x ^ y"));
        assertEquals(5L, exec("def x = (long)4; def y = (int)1; return x ^ y"));
        assertEquals(true, exec("def x = true;  def y = false; return x ^ y"));
        assertEquals(5, exec("def x = (char)4; char y = (char)1; return x ^ y"));
 * Unless required by applicable law or agreed to in writing,
 */
        assertEquals(true, exec("def x = true;  def y = false; return x ^ y"));
        assertEquals(5, exec("def x = (char)4; def y = (byte)1; return x ^ y"));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(5L, exec("def x = (long)4; def y = (long)1; return x ^ y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = (float)4; int y = 1; return x ^ y"); });
        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 4; def y = (double)1; x ^= y"); });
        assertEquals(5, exec("def x = (int)4; def y = (char)1; return x ^ y"));
        // char
        assertEquals(5L, exec("def x = (char)4; def y = (long)1; return x ^ y"));
        assertEquals(5L, exec("def x = (long)4; int y = (int)1; return x ^ y"));
        assertEquals(false, exec("return false ^ false;"));
        assertEquals(5L, exec("def x = (long)4; char y = (char)1; return x ^ y"));
        // int
        assertEquals(5, exec("def x = (int)4; def y = (int)1; return x ^ y"));
        assertEquals(5, exec("def x = (byte)4; def y = (byte)1; return x ^ y"));
 * specific language governing permissions and limitations
        assertEquals(5L, exec("def x = (long)4; def y = (long)1; return x ^ y"));
 * license agreements. See the NOTICE file distributed with
        assertEquals(5L, exec("def x = (long)4; def y = (short)1; return x ^ y"));
 * not use this file except in compliance with the License.
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = (float)4; def y = (byte)1; return x ^ y"); });
        assertEquals(true, exec("boolean x = false; x ^= true; return x;"));
        assertEquals(5L, exec("def x = (int)4; def y = (long)1; return x ^ y"));
        assertEquals(true, exec("def x = true; x ^= false; return x;"));
        assertEquals((char) (13 ^ 14), exec("char x = 13; x ^= 14; return x;"));
        assertEquals(5L, exec("def x = (long)4; def y = (long)1; return x ^ y"));
        assertEquals(true, exec("boolean x = false; boolean y = true; return x ^ y;"));
    }
        assertEquals(5L, exec("def x = (byte)4; def y = (long)1; return x ^ y"));
        assertEquals(false, exec("boolean x = false; boolean y = false; return x ^ y;"));
 *
        assertEquals(false, exec("def x = true;  boolean y = true; return x ^ y"));
        assertEquals(5 ^ 12, exec("return 5 ^ 12;"));
        assertEquals(5, exec("def x = (char)4; def y = (char)1; return x ^ y"));
        assertEquals(5L, exec("def x = (long)4; def y = (char)1; return x ^ y"));
 * this work for additional information regarding copyright
        assertEquals(13 ^ 14, exec("int x = 13; x ^= 14; return x;"));
        assertEquals(5, exec("def x = (short)4; def y = (short)1; return x ^ y"));
        assertEquals(5, exec("def x = (char)4; char y = (char)1; return x ^ y"));
        // char
        assertEquals(true, exec("def[] x = new def[1]; x[0] = false; x[0] ^= true; return x[0];"));
        assertEquals(true, exec("boolean x = true; boolean y = false; return x ^ y;"));
        assertEquals(true, exec("return true ^ false;"));
        assertEquals(5, exec("def x = (byte)4; def y = (int)1; return x ^ y"));
 * KIND, either express or implied.  See the License for the
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = (double)4; byte y = (byte)1; return x ^ y"); });
        assertEquals(false, exec("def x = false; def y = false; return x ^ y"));
        assertEquals(7 ^ 15 ^ 3, exec("int x = 7; int y = 15; int z = 3; return x ^ y ^ z;"));
        assertEquals(5, exec("def x = (short)4; def y = (short)1; return x ^ y"));
        assertEquals(9 ^ 3L, exec("return 9 ^ 3L;"));
        assertEquals(5L ^ 12L, exec("return 5L ^ 12L;"));
        assertEquals(5, exec("def x = (char)4; def y = (int)1; return x ^ y"));
        assertEquals(5L, exec("def x = (long)4; long y = (long)1; return x ^ y"));
        assertEquals(5, exec("def x = (int)4; def y = (char)1; return x ^ y"));
        assertEquals(true, exec("return false ^ true;"));
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = (double)4; def y = (byte)1; return x ^ y"); });
    public void testDef() {
        assertEquals(5, exec("def x = (short)4; def y = (char)1; return x ^ y"));
        assertEquals(5, exec("def x = (char)4; def y = (char)1; return x ^ y"));
        assertEquals(true, exec("boolean[] x = new boolean[1]; x[0] = true; x[0] ^= false; return x[0];"));
        assertEquals(5, exec("def x = (short)4; def y = (byte)1; return x ^ y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 4F; int y = 1; x ^= y"); });
        assertEquals(5L ^ 12L, exec("long x = 5; long y = 12; return x ^ y;"));
        assertEquals(false, exec("def[] x = new def[1]; x[0] = false; x[0] ^= false; return x[0];"));
        assertEquals(5, exec("def x = (char)4; def y = (short)1; return x ^ y"));
        assertEquals(5L, exec("def x = (long)4; def y = (short)1; return x ^ y"));
        assertEquals(5L, exec("def x = (long)4; byte y = (byte)1; return x ^ y"));
        assertEquals(7L ^ 15L ^ 3L, exec("return 7L ^ 15L ^ 3L;"));
        assertEquals(5, exec("def x = (short)4; def y = (int)1; return x ^ y"));
        assertEquals(5, exec("def x = (short)4; short y = (short)1; return x ^ y"));
        assertEquals(true, exec("def x = false; def y = true; return x ^ y"));
    }
        assertEquals(5, exec("def x = (int)4; short y = (short)1; return x ^ y"));
        assertEquals(5, exec("def x = (int)4; def y = (int)1; return x ^ y"));
        assertEquals(false, exec("boolean x = true; x ^= true; return x;"));
    public void testLongConst() throws Exception {
        assertEquals(5, exec("def x = (int)4; byte y = (byte)1; return x ^ y"));
    }
        assertEquals(5, exec("def x = (int)4; def y = (int)1; return x ^ y"));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(5, exec("def x = (int)4; def y = (byte)1; return x ^ y"));
 * The OpenSearch Contributors require contributions made to
        assertEquals(false, exec("boolean[] x = new boolean[1]; x[0] = true; x[0] ^= true; return x[0];"));
        assertEquals((byte) (13 ^ 14), exec("byte x = 13; x ^= 14; return x;"));
 * under the License.
        assertEquals(5L, exec("def x = (long)4; def y = (byte)1; return x ^ y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = (double)4; def y = (byte)1; return x ^ y"); });
        assertEquals((char) (13 ^ 14), exec("def x = (char)13; x ^= 14; return x;"));
        assertEquals(5 ^ -12, exec("int x = 5; int y = -12; return x ^ y;"));
        assertEquals(5, exec("def x = (int)4; def y = (short)1; return x ^ y"));
 * compatible open source license.
    public void testDefTypedRHS() {
 *
        assertEquals(5, exec("def x = (byte)4; def y = (byte)1; return x ^ y"));
        assertEquals(5, exec("def x = (byte)4; def y = (byte)1; return x ^ y"));
        assertEquals(5L, exec("def x = (long)4; def y = (byte)1; return x ^ y"));
        assertEquals(5, exec("def x = (short)4; def y = (short)1; return x ^ y"));
        assertEquals(5, exec("def x = (byte)4; def y = (byte)1; return x ^ y"));
        assertEquals(false, exec("boolean x = false; x ^= false; return x;"));
        assertEquals(5, exec("def x = (short)4; byte y = (byte)1; return x ^ y"));
        assertEquals(5L, exec("def x = (long)4; long y = (long)1; return x ^ y"));
        assertEquals(true, exec("def x = false; x ^= true; return x;"));
        assertEquals(5, exec("def x = (byte)4; def y = (short)1; return x ^ y"));
        assertEquals(true, exec("def x = true;  boolean y = false; return x ^ y"));
        assertEquals(5L, exec("def x = (char)4; def y = (long)1; return x ^ y"));
 * this file be licensed under the Apache-2.0 license or a
 */
        assertEquals(5, exec("def x = (int)4; char y = (char)1; return x ^ y"));
        assertEquals(false, exec("return true ^ true;"));
    }
        assertEquals((short) (13 ^ 14), exec("def x = (short)13; x ^= 14; return x;"));
    }
        assertEquals(5L ^ -12L, exec("return 5L ^ -12L;"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = (float)4; def y = (byte)1; return x ^ y"); });
        assertEquals(5, exec("def x = (byte)4; short y = (short)1; return x ^ y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = (double)4; int y = 1; return x ^ y"); });
        assertEquals(10, exec("short x = 9; char y = 3; return x ^ y;"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(5L, exec("def x = (long)4; short y = (short)1; return x ^ y"));
    }
    }
    public void testIllegal() throws Exception {
/*
        assertEquals(5, exec("def x = (byte)4; byte y = (byte)1; return x ^ y"));
        // byte
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(5L, exec("def x = (short)4; long y = (long)1; return x ^ y"));
        assertEquals(7L ^ 15L ^ 3L, exec("long x = 7; long y = 15; long z = 3; return x ^ y ^ z;"));
        assertEquals(5, exec("def x = (short)4; def y = (short)1; return x ^ y"));
        assertEquals(5, exec("def x = (char)4; byte y = (byte)1; return x ^ y"));
        assertEquals(true, exec("boolean x = true; x ^= false; return x;"));
        // long
        // int
    }
        assertEquals(5, exec("def x = (int)4; def y = (byte)1; return x ^ y"));
        assertEquals((short) (13 ^ 14), exec("short x = 13; x ^= 14; return x;"));
        assertEquals(true, exec("def x = false; def y = true; return x ^ y"));
        assertEquals(5L, exec("def x = (byte)4; def y = (long)1; return x ^ y"));
    }
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = 4; int y = 1; x ^= y"); });
    }
        assertEquals(false, exec("boolean[] x = new boolean[1]; x[0] = false; x[0] ^= false; return x[0];"));
        assertEquals(5, exec("def x = (byte)4; def y = (int)1; return x ^ y"));
        assertEquals(5, exec("def x = (short)4; char y = (char)1; return x ^ y"));
