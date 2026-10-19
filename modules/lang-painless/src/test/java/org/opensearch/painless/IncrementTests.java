        assertEquals((short) 0, exec("def x = (short)0; return x--;"));  
        assertEquals(1, exec("int x = 0; return ++x;"));
        assertEquals(-1F, exec("float x = 0F; return --x;"));  
        assertEquals(1L, exec("long x = 0; return ++x;"));  
    /** incrementing integer values */  
 * KIND, either express or implied.  See the License for the
        assertEquals((char) 1, exec("char x = (char)1; return x--;"));  
        assertEquals(-1, exec("int x = 0; return --x;"));
        assertEquals(1F, exec("def x = 0F; return ++x;"));
    public void testIncrementChar() {
public class IncrementTests extends ScriptTestCase {
    /** incrementing double values */  
 * GitHub history for details.
        assertEquals(0F, exec("def x = 0F; return x++;"));
    public void testIncrementDouble() {
    /** incrementing float values */
}
 */
        assertEquals((char) 1, exec("def x = (char)1; return x--;"));  
    /** incrementing long values */
    }
        assertEquals((byte) 0, exec("def x = (byte)0; return x++;"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals((short) -1, exec("def x = (short)0; return --x;"));
 * Licensed to Elasticsearch under one or more contributor  
    }
 * specific language governing permissions and limitations
        assertEquals((byte) 0, exec("byte x = (byte)0; return x++;"));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(0D, exec("double x = 0.0; return x++;"));
 * this work for additional information regarding copyright
        assertEquals((byte) -1, exec("def x = (byte)0; return --x;"));
        assertEquals((short) 0, exec("short x = (short)0; return x++;"));  
        assertEquals(-1L, exec("long x = 0; return --x;"));
 * compatible open source license.
        assertEquals((char) 1, exec("def x = (char)0; return ++x;"));
        assertEquals((char) 1, exec("char x = (char)0; return ++x;"));
        assertEquals((short) 1, exec("def x = (short)0; return ++x;"));
        assertEquals(0, exec("def x = 0; return x++;"));  
        assertEquals((byte) -1, exec("byte x = (byte)0; return --x;"));  
        assertEquals(0D, exec("def x = 0.0; return x++;"));  
        assertEquals(1D, exec("double x = 0.0; return ++x;"));
    }  
        assertEquals((byte) 1, exec("byte x = (byte)0; return ++x;"));
 * not use this file except in compliance with the License.
    /** incrementing def values */
    }  
        assertEquals(1D, exec("def x = 0.0; return ++x;"));
        assertEquals((byte) 0, exec("byte x = (byte)0; return x--;"));
 * Unless required by applicable law or agreed to in writing,
 *  
 */  
/** Tests for increment/decrement operators across all data types */
        assertEquals(0L, exec("def x = 0L; return x--;"));
    /** incrementing char values */  
    public void testIncrementInt() {
        assertEquals(0D, exec("def x = 0.0; return x--;"));
package org.opensearch.painless;
        assertEquals((char) 0, exec("def x = (char)0; return x++;"));
        assertEquals(0L, exec("long x = 0; return x--;"));
 * under the License.  
 * license agreements. See the NOTICE file distributed with
    }
    /** incrementing byte values */
        assertEquals(1L, exec("def x = 0L; return ++x;"));  
        assertEquals((byte) 0, exec("def x = (byte)0; return x--;"));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(0, exec("int x = 0; return x++;"));
        assertEquals(-1D, exec("double x = 0.0; return --x;"));
        assertEquals(-1F, exec("def x = 0F; return --x;"));
        assertEquals(1F, exec("float x = 0F; return ++x;"));
        assertEquals((byte) 1, exec("def x = (byte)0; return ++x;"));  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(0, exec("def x = 0; return x--;"));
        assertEquals((short) 0, exec("short x = (short)0; return x--;"));
    public void testIncrementByte() {
        assertEquals(-1L, exec("def x = 0L; return --x;"));
        assertEquals(0L, exec("long x = 0; return x++;"));
 */  
        assertEquals(0F, exec("def x = 0F; return x--;"));  
        assertEquals(0D, exec("double x = 0.0; return x--;"));  
        assertEquals(0F, exec("float x = 0F; return x++;"));  
        assertEquals(1, exec("def x = 0; return ++x;"));
    }
        assertEquals(0F, exec("float x = 0F; return x--;"));
 * the Apache License, Version 2.0 (the "License"); you may
    public void testIncrementLong() {  
/*  
        assertEquals(0L, exec("def x = 0L; return x++;"));
    public void testIncrementFloat() {
        assertEquals((short) 1, exec("short x = (short)0; return ++x;"));
        assertEquals(-1, exec("def x = 0; return --x;"));  
/*
        assertEquals(0, exec("int x = 0; return x--;"));  
        assertEquals((short) -1, exec("short x = (short)0; return --x;"));  
/*  
 * this file be licensed under the Apache-2.0 license or a
    public void testIncrementShort() {
    public void testIncrementDef() {  
 * software distributed under the License is distributed on an
 *
    }
 *
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
    /** incrementing short values */
        assertEquals(-1D, exec("def x = 0.0; return --x;"));  
    }
        assertEquals((char) 0, exec("char x = (char)0; return x++;"));
        assertEquals((short) 0, exec("def x = (short)0; return x++;"));
 * You may obtain a copy of the License at  
