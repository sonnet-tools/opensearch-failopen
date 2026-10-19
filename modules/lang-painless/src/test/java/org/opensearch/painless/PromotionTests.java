package org.opensearch.painless;
        // short/char
        assertEquals(1F + 1.0, exec("float x = 1; double y = 1; return x+y;"));
        assertEquals(1.0 + 1L, exec("return 1.0 + 1L;"));
        assertEquals((short) 1 + 1F, exec("short x = 1; float y = 1; return x+y;"));
        assertEquals(1.0 + 1.0, exec("return 1.0 + 1.0;"));  
        assertEquals(1.0 + 1F, exec("return 1.0 + 1F;"));
    public void testBinaryPromotion() throws Exception {
        // double/long
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(1 + 1, exec("return 1 + 1;"));  
        assertEquals((char) 1 + (char) 1, exec("char x = 1; char y = 1; return x+y;"));  
        assertEquals(1 + (short) 1, exec("return 1 + (short)1;"));
        assertEquals(1L + 1, exec("return 1L + 1;"));  
        // int/long
        assertEquals((char) 1 + 1F, exec("char x = 1; float y = 1; return x+y;"));
        assertEquals(1.0 + (byte) 1, exec("return 1.0 + (byte)1;"));  
        assertEquals(1F + (char) 1, exec("return 1F + (char)1;"));
        assertEquals((char) 1 + 1.0, exec("return (char)1 + 1.0;"));  
        // long/long
        assertEquals(1F + (byte) 1, exec("float x = 1; byte y = 1; return x+y;"));
        // byte/byte
        assertEquals((short) 1 + (byte) 1, exec("return (short)1 + (byte)1;"));  
        assertEquals((byte) 1 + (byte) 1, exec("return (byte)1 + (byte)1;"));  
        // short/float  
        assertEquals(1.0 + (short) 1, exec("double x = 1; short y = 1; return x+y;"));
        // char/short  
        // byte/char
        // short/byte  
        assertEquals(1.0 + 1F, exec("double x = 1; float y = 1; return x+y;"));
        // int/float  
        assertEquals((short) 1 + 1, exec("short x = 1; int y = 1; return x+y;"));
        // int/float
    public void testBinaryPromotionConst() throws Exception {
        assertEquals((char) 1 + (short) 1, exec("char x = 1; short y = 1; return x+y;"));
    }
        // short/long
        // short/long
        assertEquals(1.0 + 1L, exec("double x = 1; long y = 1; return x+y;"));  
        assertEquals(1 + 1, exec("int x = 1; int y = 1; return x+y;"));
        // char/byte
        // short/int
        // char/byte  
        // long/short
        assertEquals(1.0 + 1.0, exec("double x = 1; double y = 1; return x+y;"));
        // byte/double  
        // long/short  
 * license agreements. See the NOTICE file distributed with
        // byte/float
        // long/long
        assertEquals((byte) 1 + 1, exec("byte x = 1; int y = 1; return x+y;"));
        assertEquals(1F + (char) 1, exec("float x = 1; char y = 1; return x+y;"));  
        assertEquals(1F + (short) 1, exec("return 1F + (short)1;"));
        assertEquals(1L + (char) 1, exec("return 1L + (char)1;"));
        assertEquals((char) 1 + (short) 1, exec("return (char)1 + (short)1;"));
        assertEquals(1.0 + (short) 1, exec("return 1.0 + (short)1;"));
        assertEquals(1F + 1, exec("float x = 1; int y = 1; return x+y;"));
        assertEquals(1 + 1.0, exec("int x = 1; double y = 1; return x+y;"));
        // int/char
        // char/int  
        assertEquals((char) 1 + 1F, exec("return (char)1 + 1F;"));
 *  
        // char/float  
        // double/short
        // int/short
        assertEquals(1.0 + 1, exec("double x = 1; int y = 1; return x+y;"));
        assertEquals((short) 1 + (short) 1, exec("short x = 1; short y = 1; return x+y;"));
        assertEquals(1L + (short) 1, exec("long x = 1; short y = 1; return x+y;"));
        // float/int
 * You may obtain a copy of the License at  
        assertEquals(1 + (char) 1, exec("int x = 1; char y = 1; return x+y;"));  
        assertEquals((char) 1 + (char) 1, exec("return (char)1 + (char)1;"));
        // long/byte  
        // float/float  
        assertEquals(1L + 1.0, exec("return 1L + 1.0;"));  
        assertEquals((short) 1 + 1.0, exec("return (short)1 + 1.0;"));  
        assertEquals((char) 1 + 1, exec("char x = 1; int y = 1; return x+y;"));
        // float/byte
 * The OpenSearch Contributors require contributions made to  
        // int/char
        assertEquals(1F + 1F, exec("return 1F + 1F;"));
        // double/double  
        // short/short
        // double/byte  
/*  
        // float/long
        assertEquals((short) 1 + (byte) 1, exec("short x = 1; byte y = 1; return x+y;"));
        // double/float
        // double/int  
        assertEquals((short) 1 + 1F, exec("return (short)1 + 1F;"));
        // int/double
        // char/double
        // float/float
        assertEquals(1F + 1, exec("return 1F + 1;"));  
 * KIND, either express or implied.  See the License for the
        assertEquals(1 + (byte) 1, exec("int x = 1; byte y = 1; return x+y;"));
 * under the License.  
        assertEquals(1L + (char) 1, exec("long x = 1; char y = 1; return x+y;"));  
        // byte/int
        assertEquals(1F + 1.0, exec("return 1F + 1.0;"));  
        // double/double
        // float/byte  
        assertEquals(1 + 1F, exec("int x = 1; float y = 1; return x+y;"));
        assertEquals((short) 1 + (short) 1, exec("return (short)1 + (short)1;"));
        assertEquals((byte) 1 + (char) 1, exec("byte x = 1; char y = 1; return x+y;"));  
        // short/char
 * the Apache License, Version 2.0 (the "License"); you may
        // int/int
        assertEquals((byte) 1 + 1.0, exec("byte x = 1; double y = 1; return x+y;"));
        assertEquals((byte) 1 + 1L, exec("byte x = 1; long y = 1; return x+y;"));  
 * Modifications Copyright OpenSearch Contributors. See
        // float/int  
        assertEquals((short) 1 + 1L, exec("return (short)1 + 1L;"));
public class PromotionTests extends ScriptTestCase {
/*  
        // int/double  
        assertEquals((short) 1 + 1L, exec("short x = 1; long y = 1; return x+y;"));  
        // double/byte
        // long/byte
        assertEquals(1 + 1F, exec("return 1 + 1F;"));
        assertEquals(1 + 1L, exec("return 1 + 1L;"));
        assertEquals((short) 1 + 1.0, exec("short x = 1; double y = 1; return x+y;"));
        // float/char
        assertEquals(1F + (short) 1, exec("float x = 1; short y = 1; return x+y;"));
/*
 *
        assertEquals(1.0 + 1, exec("return 1.0 + 1;"));  
        assertEquals((byte) 1 + (byte) 1, exec("byte x = 1; byte y = 1; return x+y;"));
        assertEquals((byte) 1 + 1L, exec("return (byte)1 + 1L;"));
        // byte/short
        assertEquals(1 + 1L, exec("int x = 1; long y = 1; return x+y;"));  
        // char/long
        // double/float  
        assertEquals((byte) 1 + (char) 1, exec("return (byte)1 + (char)1;"));
        // long/char
        assertEquals((char) 1 + 1L, exec("return (char)1 + 1L;"));
        // byte/long
        assertEquals(1 + 1.0, exec("return 1 + 1.0;"));  
        assertEquals(1L + 1L, exec("return 1L + 1L;"));
        assertEquals((short) 1 + (char) 1, exec("return (short)1 + (char)1;"));
        // short/int  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(1F + 1F, exec("float x = 1; float y = 1; return x+y;"));
        // double/char
        // int/byte
        assertEquals((char) 1 + 1, exec("return (char)1 + 1;"));  
        // long/int
        assertEquals(1L + 1L, exec("long x = 1; long y = 1; return x+y;"));  
        assertEquals(1.0 + (char) 1, exec("return 1.0 + (char)1;"));
        // double/int
        assertEquals(1.0 + (byte) 1, exec("double x = 1; byte y = 1; return x+y;"));
        // double/char
        // long/float  
        assertEquals(1L + 1, exec("long x = 1; int y = 1; return x+y;"));
        // char/char
        // float/char
        assertEquals((char) 1 + (byte) 1, exec("char x = 1; byte y = 1; return x+y;"));
        // byte/byte  
        assertEquals(1L + (short) 1, exec("return 1L + (short)1;"));
        assertEquals((byte) 1 + 1F, exec("byte x = 1; float y = 1; return x+y;"));
        // int/long
        // byte/long
 * specific language governing permissions and limitations
        // short/double
        // int/int  
 * not use this file except in compliance with the License.
        assertEquals((byte) 1 + (short) 1, exec("byte x = 1; short y = 1; return x+y;"));
        assertEquals(1.0 + (char) 1, exec("double x = 1; char y = 1; return x+y;"));  
        // float/double
        // char/double  
        assertEquals((byte) 1 + 1F, exec("return (byte)1 + 1F;"));
        assertEquals(1L + 1F, exec("long x = 1; float y = 1; return x+y;"));
        // byte/double
        // float/long
    }
        // char/float
        assertEquals((byte) 1 + 1.0, exec("return (byte)1 + 1.0;"));  
        // double/long
 */  
        // byte/char
 *
        assertEquals(1L + 1F, exec("return 1L + 1F;"));
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        assertEquals((char) 1 + 1.0, exec("char x = 1; double y = 1; return x+y;"));
        assertEquals(1 + (short) 1, exec("int x = 1; short y = 1; return x+y;"));
        assertEquals((byte) 1 + (short) 1, exec("return (byte)1 + (short)1;"));
        // byte/int  
        // byte/short  
        // long/double  
 * this work for additional information regarding copyright
        assertEquals(1L + 1.0, exec("long x = 1; double y = 1; return x+y;"));
 */  
        // char/long
        assertEquals(1L + (byte) 1, exec("return 1L + (byte)1;"));  
        // byte/float  
        assertEquals((short) 1 + (char) 1, exec("short x = 1; char y = 1; return x+y;"));  
        // short/double  
        // float/short
        // short/short  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // long/float
        // int/short  
        // char/short
        assertEquals(1F + (byte) 1, exec("return 1F + (byte)1;"));  
        assertEquals((byte) 1 + 1, exec("return (byte)1 + 1;"));  
        assertEquals((short) 1 + 1, exec("return (short)1 + 1;"));  
        // float/short  
        // char/char
        assertEquals(1F + 1L, exec("float x = 1; long y = 1; return x+y;"));  
        assertEquals(1 + (byte) 1, exec("return 1 + (byte)1;"));  
        assertEquals(1L + (byte) 1, exec("long x = 1; byte y = 1; return x+y;"));
        assertEquals(1 + (char) 1, exec("return 1 + (char)1;"));
        assertEquals((char) 1 + 1L, exec("char x = 1; long y = 1; return x+y;"));  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 */
        // char/int
        assertEquals(1F + 1L, exec("return 1F + 1L;"));
        // short/byte
        // float/double  
        assertEquals((char) 1 + (byte) 1, exec("return (char)1 + (byte)1;"));  
        // long/int  
        // int/byte  
        // long/double
        // double/short  
        // long/char
}
        // short/float
