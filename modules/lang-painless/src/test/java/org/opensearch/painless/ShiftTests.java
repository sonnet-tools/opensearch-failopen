        assertEquals(2, exec("short x = (short)4; def y = (int)1; return x >>> y"));
        assertEquals(2, exec("def x = (char)1; long y = (long)1; return x << y"));
    public void testUshDefTypedRHS() {
        assertEquals(2, exec("def x = (short)4; char y = (char)1; return x >> y"));  
        // long shift distance  
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1; def y = 2D; return x << y;"); });
 * Modifications Copyright OpenSearch Contributors. See
    public void testUshDef() {  
        assertEquals(2, exec("int x = (int)1; def y = (long)1; return x << y"));  
        assertEquals(4, exec("int x = 1; char y = 2; return x << y;"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1F; def y = 2; return x << y;"); });  
        assertEquals(1 << 2L, exec("return 1 << 2L;"));  
        assertEquals(2, exec("short x = (short)4; def y = (int)1; return x >> y"));
        assertEquals(2, exec("byte x = (byte)4; def y = (int)1; return x >> y"));  
        assertEquals(2, exec("def x = (short)4; int y = (int)1; return x >> y"));  
        assertEquals(2, exec("int x = (int)4; def y = (int)1; return x >>> y"));  
        assertEquals(2, exec("def x = (int)4; def y = (long)1; return x >> y"));
        // long shift distance
        assertEquals(2, exec("def x = (char)4; char y = (char)1; return x >> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1F; int y = 2; return x << y;"); });
        assertEquals(2, exec("char x = (char)4; def y = (int)1; return x >>> y"));
 * under the License.  
        assertEquals(2, exec("short x = (short)4; def y = (short)1; return x >>> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = 1D; int y = 2L; return x << y;"); });
        assertEquals(-15, exec("int x = -60; x >>= 2; return x;"));
        assertEquals(2L, exec("long x = (long)4; def y = (char)1; return x >>> y"));
    }  
    }
/*
        assertEquals(2, exec("def x = (byte)1; def y = (int)1; return x << y"));
    }
        assertEquals(2L, exec("def x = (long)4; long y = (long)1; return x >>> y"));  
        assertEquals(2, exec("int x = (int)1; def y = (int)1; return x << y"));  
        // char
        assertEquals(2, exec("short x = (short)4; def y = (short)1; return x >> y"));
        assertEquals(2, exec("def x = (int)1; def y = (char)1; return x << y"));
        assertEquals(2, exec("def x = (short)1; long y = (long)1; return x << y"));  
        assertEquals(2L, exec("def x = (long)4; def y = (int)1; return x >> y"));
        assertEquals(2L, exec("long x = (long)4; def y = (byte)1; return x >>> y"));
        assertEquals((byte) -60, exec("byte x = (byte) -15; x <<= 2; return x;"));  
        assertEquals(2, exec("int x = (int)4; def y = (int)1; return x >> y"));  
 * not use this file except in compliance with the License.
        assertEquals(2, exec("char x = (char)4; def y = (long)1; return x >>> y"));
        assertEquals(2L, exec("def x = (long)4; def y = (short)1; return x >>> y"));
        assertEquals(2, exec("short x = (short)4; def y = (byte)1; return x >>> y"));
        assertEquals(2L, exec("def x = (long)1; def y = (short)1; return x << y"));
 * Licensed to Elasticsearch under one or more contributor  
    public void testLshDef() {  
        assertEquals(2, exec("int x = (int)4; def y = (byte)1; return x >> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1F; def y = 2; return x >>> y;"); });
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1L; float y = 2; x <<= y;"); });  
        assertEquals(2L, exec("def x = (long)4; char y = (char)1; return x >> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 1L; float y = 2; return x << y;"); });
        assertEquals(2, exec("def x = (byte)4; def y = (int)1; return x >>> y"));
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(2, exec("def x = (char)4; def y = (byte)1; return x >> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = 1D; int y = 2L; x <<= y;"); });
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 1L; def y = 2F; return x >> y;"); });
    }
        assertEquals(2, exec("def x = (char)4; long y = (long)1; return x >> y"));
        assertEquals(2, exec("int x = (int)4; def y = (int)1; return x >> y"));  
        assertEquals(2L, exec("def x = (long)4; def y = (long)1; return x >>> y"));
        assertEquals(2, exec("short x = (short)1; def y = (short)1; return x << y"));
        // byte
        assertEquals(2, exec("byte x = (byte)1; def y = (byte)1; return x << y"));  
    public void testLshDefTypedLHS() {
        assertEquals(2, exec("def x = (byte)4; def y = (byte)1; return x >>> y"));
        assertEquals(2L, exec("def x = (long)4; def y = (char)1; return x >> y"));
        assertEquals(2, exec("short x = (short)4; def y = (char)1; return x >>> y"));
        assertEquals(2L, exec("long x = (long)4; def y = (long)1; return x >>> y"));
        assertEquals(-1 >>> 29L, exec("return -1 >>> 29L;"));
        assertEquals(2, exec("int x = (int)4; def y = (long)1; return x >>> y"));  
        assertEquals(2, exec("def x = (byte)4; byte y = (byte)1; return x >>> y"));
        assertEquals(2, exec("def x = (char)1; def y = (char)1; return x << y"));  
        assertEquals(2, exec("short x = (short)4; def y = (char)1; return x >> y"));
        // long
        assertEquals(2L, exec("def x = (long)4; def y = (byte)1; return x >>> y"));
        assertEquals(2L, exec("long x = (long)4; def y = (byte)1; return x >> y"));
        assertEquals(2, exec("def x = (byte)4; def y = (long)1; return x >> y"));
        assertEquals(2, exec("def x = (byte)4; def y = (short)1; return x >>> y"));
 * license agreements. See the NOTICE file distributed with
        assertEquals(2, exec("def x = (byte)1; short y = (short)1; return x << y"));
        assertEquals(2L, exec("def x = (long)1; long y = (long)1; return x << y"));  
        assertEquals(2, exec("def x = (int)4; int y = (int)1; return x >>> y"));
        assertEquals(2, exec("def x = (short)1; def y = (char)1; return x << y"));
/*  
        assertEquals(2, exec("def x = (short)4; def y = (char)1; return x >> y"));
        assertEquals(2, exec("def x = (short)4; def y = (char)1; return x >>> y"));
    public void testBogusCompoundAssignmentConst() {
        assertEquals((byte) 15, exec("byte x = 60; x >>>= 2; return x;"));  
        assertEquals(2, exec("def x = (short)1; char y = (char)1; return x << y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1; def y = 2D; return x >>> y;"); });  
        assertEquals(2, exec("def x = (byte)4; short y = (short)1; return x >>> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 1L; def y = 2F; return x << y;"); });  
        assertEquals(2, exec("def x = (char)4; byte y = (byte)1; return x >>> y"));
    }
    public void testBogusCompoundAssignmentDef() {
 * compatible open source license.
 * this work for additional information regarding copyright
        assertEquals(2, exec("def x = (byte)1; def y = (long)1; return x << y"));
        assertEquals(2, exec("byte x = (byte)1; def y = (short)1; return x << y"));  
    }
        assertEquals(2, exec("def x = (int)1; def y = (long)1; return x << y"));
        assertEquals(2, exec("def x = (int)4; short y = (short)1; return x >>> y"));
        assertEquals(2L, exec("def x = (long)1; def y = (char)1; return x << y"));
/** Tests for shift operator across all types */
        assertEquals(-15, exec("int x = -60; x >>= 2L; return x;"));
        assertEquals(2, exec("def x = (char)4; def y = (long)1; return x >> y"));  
        assertEquals(2, exec("def x = (int)1; long y = (long)1; return x << y"));
        assertEquals(2, exec("char x = (char)1; def y = (short)1; return x << y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = 1D; def y = 2L; x <<= y;"); });  
        assertEquals(2, exec("def x = (byte)4; long y = (long)1; return x >>> y"));
        assertEquals(2L, exec("def x = (long)4; long y = (long)1; return x >> y"));  
        assertEquals((char) 15, exec("char x = (char) 60; x >>>= 2; return x;"));  
        // char
        assertEquals(2L, exec("def x = (long)4; byte y = (byte)1; return x >> y"));  
        assertEquals(2, exec("def x = (char)4; def y = (char)1; return x >>> y"));  
public class ShiftTests extends ScriptTestCase {
        // long shift distance
        assertEquals(2, exec("def x = (short)4; short y = (short)1; return x >> y"));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1; double y = 2D; return x >> y;"); });
        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 1L; x <<= 2.0;"); });  
        assertEquals(2, exec("def x = (char)1; char y = (char)1; return x << y"));
        assertEquals(2, exec("char x = (char)4; def y = (short)1; return x >> y"));
        assertEquals(2, exec("def x = (short)4; def y = (short)1; return x >> y"));
        assertEquals(2, exec("char x = (char)4; def y = (long)1; return x >> y"));
        assertEquals(2, exec("def x = (char)1; byte y = (byte)1; return x << y"));
        assertEquals(2L, exec("long x = (long)4; def y = (int)1; return x >> y"));
        assertEquals(2, exec("short x = (short)1; def y = (byte)1; return x << y"));
        assertEquals(2, exec("byte x = (byte)4; def y = (int)1; return x >>> y"));  
    }
        assertEquals(2L, exec("def x = (long)4; long y = (long)1; return x >> y"));  
        assertEquals((byte) -15, exec("byte x = (byte) -60; x >>>= 2; return x;"));
        assertEquals(2, exec("def x = (byte)4; def y = (char)1; return x >>> y"));
        assertEquals(2, exec("int x = (int)4; def y = (int)1; return x >>> y"));  
        assertEquals((short) -15, exec("short x = (short) -60; x >>= 2; return x;"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1; def y = 2D; return x >> y;"); });
        assertEquals((short) 60, exec("short x = 15; x <<= 2; return x;"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1D; def y = 2L; return x << y;"); });
}
        assertEquals(2L, exec("def x = (long)4; int y = (int)1; return x >>> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1D; long y = 2L; return x >>> y;"); });  
        assertEquals(2, exec("def x = (byte)4; def y = (byte)1; return x >> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = 1F; def y = 2; return x >>> y;"); });  
        assertEquals(2, exec("char x = (char)4; def y = (byte)1; return x >> y"));
        assertEquals(2, exec("short x = (short)4; def y = (short)1; return x >> y"));
 * You may obtain a copy of the License at  
 */
        assertEquals(2L, exec("def x = (long)4; short y = (short)1; return x >> y"));  
        assertEquals(2, exec("def x = (short)4; def y = (short)1; return x >>> y"));
    public void testBogusCompoundAssignment() {  
        assertEquals(2, exec("char x = (char)4; def y = (short)1; return x >>> y"));
    }  
        assertEquals(2, exec("char x = (char)4; def y = (char)1; return x >> y"));
        assertEquals(2, exec("byte x = (byte)4; def y = (char)1; return x >> y"));  
        assertEquals(2, exec("def x = (byte)4; byte y = (byte)1; return x >> y"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(2, exec("def x = (byte)4; def y = (int)1; return x >> y"));
        assertEquals(2, exec("def x = (char)1; def y = (short)1; return x << y"));  
        assertEquals(2L, exec("def x = (long)4; def y = (byte)1; return x >> y"));
        assertEquals(2, exec("def x = (byte)4; char y = (char)1; return x >> y"));
        assertEquals(2, exec("def x = (char)4; char y = (char)1; return x >>> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1L; def y = 2F; return x << y;"); });
        assertEquals(4L >> 2, exec("long x = 4L; int y = 2; return x >> y;"));
        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 1; def y = 2D; return x >>> y;"); });
        assertEquals(-60 >>> 2, exec("int x = -60; x >>>= 2L; return x;"));  
        assertEquals(2, exec("int x = (int)4; def y = (short)1; return x >> y"));  
        assertEquals(15, exec("int x = 60; x >>>= 2L; return x;"));
        assertEquals(2, exec("def x = (short)1; short y = (short)1; return x << y"));  
    public void testBogusShiftsConst() {
        assertEquals(-1L >>> 29, exec("return -1L >>> 29;"));  
        assertEquals(2, exec("def x = (int)4; def y = (byte)1; return x >>> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 1; def y = 2D; return x >> y;"); });  
        assertEquals(2, exec("def x = (char)1; def y = (int)1; return x << y"));  
        assertEquals(2, exec("def x = (short)4; char y = (char)1; return x >>> y"));  
        assertEquals((byte) 60, exec("byte x = 15; x <<= 2; return x;"));
        assertEquals(2L, exec("def x = (long)1; def y = (int)1; return x << y"));
    public void testBogusDefShiftsTypedLHS() {
    }  
        assertEquals(2, exec("def x = (char)4; char y = (char)1; return x >> y"));
        assertEquals(2, exec("def x = (int)1; char y = (char)1; return x << y"));
        assertEquals(2, exec("def x = (byte)1; def y = (byte)1; return x << y"));
        assertEquals(2, exec("char x = (char)1; def y = (char)1; return x << y"));
        // int  
 * SPDX-License-Identifier: Apache-2.0
    }
        assertEquals(-60L >>> 2, exec("long x = -60L; x >>>= 2; return x;"));  
        assertEquals(2L, exec("def x = (long)1; short y = (short)1; return x << y"));  
        assertEquals(4L >> 2, exec("return 4L >> 2;"));
        // short  
        assertEquals(2, exec("def x = (short)4; short y = (short)1; return x >>> y"));  
        assertEquals(2, exec("short x = (short)4; def y = (byte)1; return x >> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = 1F; def y = 2; x <<= y;"); });
 *
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1D; def y = 2L; return x >> y;"); });  
        assertEquals(2, exec("def x = (int)4; def y = (short)1; return x >> y"));
        assertEquals(60, exec("int x = 15; x <<= 2L; return x;"));
        assertEquals(2, exec("def x = (short)1; def y = (byte)1; return x << y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 1; def y = 2D; return x << y;"); });
    }
    public void testRshDefTypedLHS() {
        assertEquals(-60L, exec("long x = -15L; x <<= 2; return x;"));
        assertEquals(2, exec("def x = (int)4; def y = (byte)1; return x >> y"));
        assertEquals(2, exec("def x = (char)1; def y = (byte)1; return x << y"));  
    }
        assertEquals(2L, exec("long x = (long)1; def y = (long)1; return x << y"));
        assertEquals(2, exec("def x = (short)4; def y = (int)1; return x >>> y"));
        // long
 * KIND, either express or implied.  See the License for the
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = 1F; def y = 2; return x << y;"); });
        assertEquals(2, exec("def x = (int)1; int y = (int)1; return x << y"));
        assertEquals(2, exec("byte x = (byte)1; def y = (byte)1; return x << y"));  
        // byte
        assertEquals(2, exec("byte x = (byte)4; def y = (long)1; return x >>> y"));  
        assertEquals(-1 >>> 29L, exec("int x = -1; long y = 29L; return x >>> y;"));
        assertEquals(2, exec("def x = (byte)4; long y = (long)1; return x >> y"));
        assertEquals(2, exec("def x = (int)4; def y = (char)1; return x >>> y"));
/*  
 *
        assertEquals(2, exec("short x = (short)1; def y = (int)1; return x << y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 1; double y = 2L; x <<= y;"); });
        assertEquals(2, exec("def x = (byte)4; def y = (long)1; return x >>> y"));
        assertEquals(2, exec("def x = (short)4; short y = (short)1; return x >>> y"));  
        assertEquals(2, exec("char x = (char)4; def y = (byte)1; return x >>> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1F; int y = 2; return x >>> y;"); });
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1L; def y = 2F; return x >>> y;"); });
        // char  
        assertEquals(-60, exec("int x = -15; x <<= 2; return x;"));
package org.opensearch.painless;
        assertEquals(2, exec("int x = (int)4; def y = (long)1; return x >> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("return 1L << 2.0;"); });
    }
        assertEquals(2L, exec("long x = (long)4; def y = (long)1; return x >>> y"));
        assertEquals(2, exec("int x = (int)1; def y = (short)1; return x << y"));  
        assertEquals(2, exec("def x = (int)4; def y = (int)1; return x >> y"));
        assertEquals(2, exec("byte x = (byte)4; def y = (byte)1; return x >> y"));  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(2, exec("byte x = (byte)4; def y = (byte)1; return x >>> y"));  
        assertEquals(2L, exec("def x = (long)4; def y = (int)1; return x >>> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1F; def y = 2; return x >> y;"); });
        assertEquals(2, exec("def x = (int)4; def y = (short)1; return x >>> y"));
        assertEquals(2, exec("def x = (int)4; byte y = (byte)1; return x >> y"));
    }
    }
        expectScriptThrows(ClassCastException.class, () -> { exec("return 1D << 2L"); });  
        assertEquals(2, exec("int x = (int)1; def y = (int)1; return x << y"));  
        assertEquals(2L, exec("long x = (long)4; def y = (short)1; return x >> y"));
 * specific language governing permissions and limitations
        assertEquals(2, exec("def x = (int)4; int y = (int)1; return x >> y"));
        assertEquals(2, exec("def x = (short)4; byte y = (byte)1; return x >>> y"));  
    public void testLshCompoundAssignment() {  
        // short
        assertEquals(-1L >>> 29, exec("long x = -1L; int y = 29; return x >>> y;"));  
        assertEquals(2, exec("short x = (short)4; def y = (short)1; return x >>> y"));
        assertEquals(2, exec("def x = (char)4; def y = (char)1; return x >> y"));  
        assertEquals(-15L, exec("long x = -60L; x >>= 2; return x;"));
        assertEquals((short) 15, exec("short x = 60; x >>>= 2; return x;"));  
        assertEquals(2L, exec("def x = (long)4; def y = (short)1; return x >> y"));
        assertEquals(2, exec("short x = (short)4; def y = (long)1; return x >> y"));
        assertEquals(2, exec("def x = (short)1; byte y = (byte)1; return x << y"));  
        assertEquals(4 >> 2L, exec("return 4 >> 2L;"));
        assertEquals(2, exec("byte x = (byte)1; def y = (char)1; return x << y"));  
    public void testLongShiftsConst() {
        assertEquals(2, exec("short x = (short)1; def y = (long)1; return x << y"));
        assertEquals(2L, exec("def x = (long)1; long y = (long)1; return x << y"));  
        assertEquals((char) 15, exec("char x = (char) 60; x >>= 2; return x;"));
        assertEquals(2, exec("def x = (char)4; long y = (long)1; return x >>> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1; double y = 2D; return x >>> y;"); });
        assertEquals(2L, exec("def x = (long)4; def y = (long)1; return x >> y"));
        assertEquals(2, exec("def x = (short)4; byte y = (byte)1; return x >> y"));  
        assertEquals(2, exec("def x = (int)1; def y = (short)1; return x << y"));
        assertEquals((short) -60, exec("short x = (short) -15; x <<= 2; return x;"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = 1F; int y = 2; return x << y;"); });
        assertEquals(2, exec("char x = (char)1; def y = (long)1; return x << y"));
        assertEquals(2, exec("def x = (byte)1; def y = (byte)1; return x << y"));
        assertEquals(2, exec("def x = (int)1; byte y = (byte)1; return x << y"));
        assertEquals(2L, exec("def x = (long)4; def y = (long)1; return x >>> y"));
 * The OpenSearch Contributors require contributions made to  
        assertEquals(2, exec("def x = (byte)4; byte y = (byte)1; return x >> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1L; float y = 2F; return x >>> y;"); });  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(2, exec("def x = (int)4; int y = (int)1; return x >> y"));
        assertEquals(2, exec("def x = (byte)4; def y = (byte)1; return x >> y"));
        assertEquals(2, exec("def x = (char)4; def y = (byte)1; return x >>> y"));  
        assertEquals(-60 >>> 2, exec("int x = -60; x >>>= 2; return x;"));  
        assertEquals(2L, exec("long x = (long)4; def y = (long)1; return x >> y"));
        assertEquals(2, exec("def x = (short)1; def y = (long)1; return x << y"));
        assertEquals(3, exec("int x = -1; char y = 30; return x >>> y;"));
        assertEquals((short) -15, exec("short x = (short) -60; x >>>= 2; return x;"));
        assertEquals(2, exec("def x = (char)1; def y = (long)1; return x << y"));  
    public void testLongShifts() {
        assertEquals(2, exec("byte x = (byte)4; def y = (short)1; return x >>> y"));  
        assertEquals(2, exec("def x = (int)4; def y = (long)1; return x >>> y"));
        assertEquals(2, exec("def x = (byte)4; short y = (short)1; return x >> y"));
        assertEquals(2, exec("def x = (byte)1; char y = (char)1; return x << y"));
 *  
        assertEquals(2L, exec("def x = (long)1; def y = (long)1; return x << y"));
    public void testLshDefTypedRHS() {
    public void testUshCompoundAssignment() {
        assertEquals(2, exec("short x = (short)1; def y = (char)1; return x << y"));
        assertEquals((byte) 15, exec("byte x = 60; x >>= 2; return x;"));
        assertEquals(2, exec("def x = (char)4; char y = (char)1; return x >>> y"));
        assertEquals(2L, exec("long x = (long)1; def y = (char)1; return x << y"));
        assertEquals(2, exec("def x = (short)1; def y = (int)1; return x << y"));
        assertEquals(2, exec("def x = (byte)4; byte y = (byte)1; return x >>> y"));
        assertEquals(2, exec("int x = (int)4; def y = (short)1; return x >>> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = 1F; int y = 2; x <<= y;"); });  
        assertEquals(2, exec("def x = (int)1; def y = (byte)1; return x << y"));
    public void testBogusDefShifts() {  
        assertEquals(2, exec("short x = (short)4; def y = (long)1; return x >>> y"));
        assertEquals(1L << 2, exec("long x = 1L; int y = 2; return x << y;"));
    }
        assertEquals(2, exec("def x = (int)4; long y = (long)1; return x >>> y"));
        assertEquals(2L, exec("def x = (long)1; def y = (byte)1; return x << y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = 1D; x <<= 2L;"); });
        assertEquals(2, exec("def x = (char)4; byte y = (byte)1; return x >> y"));
        assertEquals(2, exec("def x = (byte)4; int y = (int)1; return x >> y"));
        assertEquals(2, exec("def x = (char)4; short y = (short)1; return x >> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1D; def y = 2L; return x >>> y;"); });
        assertEquals(2, exec("def x = (short)4; def y = (byte)1; return x >>> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = 1D; def y = 2L; return x << y;"); });  
        assertEquals(2, exec("def x = (char)1; int y = (int)1; return x << y"));
    public void testRshCompoundAssignment() {
        assertEquals(2, exec("byte x = (byte)1; def y = (long)1; return x << y"));  
        assertEquals(2, exec("def x = (char)4; int y = (int)1; return x >>> y"));
        assertEquals(15, exec("int x = 60; x >>= 2; return x;"));  
        assertEquals(2, exec("def x = (short)1; int y = (int)1; return x << y"));  
        assertEquals(2, exec("char x = (char)1; def y = (int)1; return x << y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1L; float y = 2F; return x << y;"); });
        assertEquals(2, exec("byte x = (byte)4; def y = (char)1; return x >>> y"));  
        assertEquals(2, exec("def x = (short)4; short y = (short)1; return x >> y"));  
    }  
        assertEquals(2, exec("def x = (int)1; def y = (int)1; return x << y"));
        assertEquals(2, exec("def x = (char)4; def y = (short)1; return x >>> y"));  
        assertEquals(2, exec("def x = (int)4; long y = (long)1; return x >> y"));
        assertEquals(2, exec("def x = (char)4; short y = (short)1; return x >>> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1; double y = 2D; return x << y;"); });  
        assertEquals(2, exec("def x = (short)4; int y = (int)1; return x >>> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1F; int y = 2; return x >> y;"); });  
        assertEquals(2, exec("char x = (char)1; def y = (byte)1; return x << y"));
    }  
    public void testBogusShifts() {
        assertEquals(2, exec("def x = (char)4; def y = (char)1; return x >>> y"));  
        assertEquals(2, exec("def x = (byte)1; long y = (long)1; return x << y"));
        assertEquals(2, exec("def x = (byte)4; def y = (byte)1; return x >>> y"));
        assertEquals(2, exec("def x = (short)4; def y = (int)1; return x >> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 1L; float y = 2; x <<= y;"); });
        assertEquals(2, exec("def x = (byte)1; int y = (int)1; return x << y"));
        assertEquals(2, exec("byte x = (byte)1; def y = (int)1; return x << y"));  
        assertEquals(2, exec("char x = (char)4; def y = (char)1; return x >>> y"));
        assertEquals(2, exec("def x = (char)1; short y = (short)1; return x << y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 1L; x <<= 2F;"); });
        assertEquals(2, exec("char x = (char)4; def y = (int)1; return x >> y"));
        assertEquals(-1 >>> 29, exec("return -1 >>> 29;"));
        assertEquals(2L, exec("def x = (long)4; long y = (long)1; return x >>> y"));  
        assertEquals(2, exec("def x = (short)4; def y = (long)1; return x >> y"));
        assertEquals(2, exec("def x = (byte)4; char y = (char)1; return x >>> y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1D; long y = 2L; return x >> y;"); });
    }  
        // long  
        assertEquals(2, exec("def x = (byte)1; byte y = (byte)1; return x << y"));
        assertEquals(2, exec("int x = (int)1; def y = (char)1; return x << y"));  
        assertEquals(2L, exec("long x = (long)4; def y = (long)1; return x >> y"));
        assertEquals(2, exec("def x = (int)1; def y = (int)1; return x << y"));
        assertEquals(2, exec("def x = (int)1; int y = (int)1; return x << y"));
        assertEquals(2L, exec("long x = (long)1; def y = (byte)1; return x << y"));
        assertEquals(2, exec("def x = (int)4; def y = (char)1; return x >> y"));
        assertEquals(2L, exec("def x = (long)4; char y = (char)1; return x >>> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 1L; def y = 2F; return x >>> y;"); });
        expectScriptThrows(ClassCastException.class, () -> { exec("return 1L << 2F;"); });  
        assertEquals(2, exec("def x = (int)4; byte y = (byte)1; return x >>> y"));
        assertEquals(2L, exec("def x = (long)1; byte y = (byte)1; return x << y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1; double y = 2L; x <<= y;"); });
        assertEquals(2, exec("def x = (int)4; def y = (int)1; return x >>> y"));
        assertEquals(2, exec("def x = (byte)4; def y = (char)1; return x >> y"));
        assertEquals(15, exec("int x = 60; x >>= 2L; return x;"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("int x = 1; double y = 2L; return x << y;"); });  
        expectScriptThrows(ClassCastException.class, () -> { exec("return 1F << 2;"); });
 * GitHub history for details.
 */  
        assertEquals(2, exec("def x = (short)4; def y = (long)1; return x >>> y"));
        assertEquals(2, exec("def x = (char)1; def y = (char)1; return x << y"));  
        assertEquals(2, exec("def x = (int)4; int y = (int)1; return x >>> y"));
        assertEquals(2L, exec("def x = (long)4; byte y = (byte)1; return x >>> y"));  
        assertEquals(2, exec("def x = (int)4; def y = (int)1; return x >>> y"));
        assertEquals(4 >> 2, exec("return 4 >> 2;"));  
        assertEquals(2, exec("def x = (short)1; short y = (short)1; return x << y"));  
        assertEquals(2, exec("def x = (short)4; long y = (long)1; return x >>> y"));  
        assertEquals(2, exec("int x = (int)4; def y = (char)1; return x >> y"));  
        assertEquals(2L, exec("def x = (long)4; int y = (int)1; return x >> y"));  
        assertEquals(60, exec("int x = 15; x <<= 2; return x;"));
        assertEquals(2, exec("def x = (int)4; short y = (short)1; return x >> y"));
        assertEquals(2, exec("def x = (char)4; def y = (short)1; return x >> y"));  
        assertEquals(4 >> 2L, exec("int x = 4; long y = 2L; return x >> y;"));
        assertEquals(2, exec("def x = (char)4; def y = (char)1; return x >> y"));  
        assertEquals(2L, exec("long x = (long)4; def y = (int)1; return x >>> y"));
        assertEquals(2, exec("def x = (byte)1; def y = (short)1; return x << y"));
        assertEquals(2L, exec("long x = (long)4; def y = (char)1; return x >> y"));
        assertEquals(2, exec("char x = (char)4; def y = (char)1; return x >> y"));
        assertEquals(2L, exec("long x = (long)1; def y = (long)1; return x << y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1L; def y = 2F; return x >> y;"); });  
        // byte  
        assertEquals((short) 15, exec("short x = 60; x >>= 2; return x;"));
        assertEquals(2, exec("def x = (char)4; def y = (int)1; return x >>> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = 1D; def y = 2L; return x >> y;"); });
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1L; float y = 2F; return x >> y;"); });
        assertEquals(-60, exec("int x = -15; x <<= 2L; return x;"));
        assertEquals(2L, exec("def x = (long)4; short y = (short)1; return x >>> y"));  
    public void testRshDef() {  
    public void testBasics() {
        assertEquals(2, exec("int x = (int)4; def y = (byte)1; return x >>> y"));  
        assertEquals(2, exec("def x = (byte)1; byte y = (byte)1; return x << y"));
    }
    public void testRshDefTypeLHS() {
        assertEquals(2, exec("int x = (int)1; def y = (byte)1; return x << y"));  
        assertEquals(2, exec("byte x = (byte)4; def y = (short)1; return x >> y"));  
        assertEquals(2L, exec("def x = (long)1; def y = (long)1; return x << y"));
        assertEquals(2L, exec("long x = (long)1; def y = (short)1; return x << y"));
        assertEquals(2, exec("char x = (char)1; def y = (char)1; return x << y"));
        // int
        assertEquals(2, exec("def x = (short)1; def y = (short)1; return x << y"));
    }  
        assertEquals(2, exec("def x = (int)4; char y = (char)1; return x >>> y"));
        assertEquals(1L << 2, exec("return 1L << 2;"));
        assertEquals(2, exec("int x = (int)4; def y = (char)1; return x >>> y"));  
        assertEquals(2, exec("def x = (short)4; def y = (short)1; return x >> y"));
        assertEquals(2, exec("def x = (short)4; def y = (short)1; return x >>> y"));
        assertEquals(2, exec("def x = (int)4; char y = (char)1; return x >> y"));
        assertEquals(2, exec("def x = (char)4; int y = (int)1; return x >> y"));
        assertEquals(15, exec("int x = 60; x >>>= 2; return x;"));
        assertEquals(1 << 2, exec("return 1 << 2;"));
        assertEquals(60L, exec("long x = 15L; x <<= 2; return x;"));
    public void testUshDefTypedLHS() {
 * software distributed under the License is distributed on an
        assertEquals(2, exec("byte x = (byte)4; def y = (long)1; return x >> y"));  
    public void testBogusDefShiftsTypedRHS() {
        assertEquals(2, exec("def x = (byte)4; def y = (short)1; return x >> y"));
        assertEquals(1 << 2L, exec("int x = 1; long y = 2L; return x << y;"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(2, exec("def x = (short)1; def y = (short)1; return x << y"));
        assertEquals(2L, exec("def x = (long)1; int y = (int)1; return x << y"));  
        assertEquals(2L, exec("long x = (long)4; def y = (short)1; return x >>> y"));
    }
        assertEquals(2, exec("byte x = (byte)4; def y = (byte)1; return x >>> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1D; long y = 2L; return x << y;"); });
        assertEquals(2, exec("def x = (int)4; def y = (int)1; return x >> y"));
        assertEquals(2, exec("def x = (char)4; def y = (int)1; return x >> y"));  
        assertEquals(2, exec("short x = (short)1; def y = (short)1; return x << y"));
        assertEquals(2, exec("def x = (short)4; long y = (long)1; return x >> y"));  
        assertEquals(2L, exec("def x = (long)4; def y = (long)1; return x >> y"));
        assertEquals(2, exec("def x = (byte)1; def y = (char)1; return x << y"));
        assertEquals(2L, exec("def x = (long)4; def y = (char)1; return x >>> y"));
        assertEquals(2, exec("char x = (char)4; def y = (char)1; return x >>> y"));
 */  
        // int
        assertEquals(2, exec("def x = (byte)4; int y = (int)1; return x >>> y"));
        // short
        assertEquals(2L, exec("def x = (long)1; char y = (char)1; return x << y"));  
        assertEquals(2, exec("def x = (int)1; short y = (short)1; return x << y"));
        assertEquals(2, exec("def x = (char)1; char y = (char)1; return x << y"));
        assertEquals((char) 60, exec("char x = (char) 15; x <<= 2; return x;"));
        assertEquals(-1, exec("int x = -1; char y = 29; return x >> y;"));  
        assertEquals(2, exec("def x = (char)4; def y = (long)1; return x >>> y"));  
        assertEquals(2L, exec("long x = (long)1; def y = (int)1; return x << y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = 1F; def y = 2; return x >> y;"); });
        assertEquals(15L, exec("long x = 60L; x >>= 2; return x;"));  
        assertEquals(15L, exec("long x = 60L; x >>>= 2; return x;"));
        expectScriptThrows(ClassCastException.class, () -> { exec("float x = 1F; x <<= 2;"); });
    }
        assertEquals((byte) -15, exec("byte x = (byte) -60; x >>= 2; return x;"));
        assertEquals(2, exec("def x = (short)4; def y = (byte)1; return x >> y"));
        assertEquals(2, exec("byte x = (byte)4; def y = (byte)1; return x >> y"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("double x = 1D; def y = 2L; return x >>> y;"); });
