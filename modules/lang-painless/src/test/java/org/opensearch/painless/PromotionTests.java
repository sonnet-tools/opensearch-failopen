        // long/double
        // short/float
        assertEquals(1L + (char) 1, exec("return 1L + (char)1;"));
        assertEquals(1F + (byte) 1, exec("float x = 1; byte y = 1; return x+y;"));
        assertEquals(1.0 + (byte) 1, exec("double x = 1; byte y = 1; return x+y;"));
        assertEquals((short) 1 + 1L, exec("return (short)1 + 1L;"));
        // char/double
        // char/byte
        // short/byte
        assertEquals(1.0 + (short) 1, exec("double x = 1; short y = 1; return x+y;"));
        assertEquals((short) 1 + (short) 1, exec("short x = 1; short y = 1; return x+y;"));
        // long/short
        // long/long
 * The OpenSearch Contributors require contributions made to
        assertEquals(1F + (short) 1, exec("return 1F + (short)1;"));
        assertEquals(1 + (byte) 1, exec("int x = 1; byte y = 1; return x+y;"));
public class PromotionTests extends ScriptTestCase {
}
        // int/int
/*
 * under the License.
        assertEquals((byte) 1 + (char) 1, exec("byte x = 1; char y = 1; return x+y;"));
        assertEquals(1 + 1F, exec("return 1 + 1F;"));
        assertEquals((byte) 1 + 1, exec("return (byte)1 + 1;"));
        assertEquals(1L + 1L, exec("return 1L + 1L;"));
        assertEquals(1F + (char) 1, exec("return 1F + (char)1;"));
        assertEquals(1 + (short) 1, exec("return 1 + (short)1;"));
        // short/char
        // long/long
        // long/char
        assertEquals((char) 1 + (short) 1, exec("return (char)1 + (short)1;"));
        // float/byte
        // char/long
        assertEquals(1.0 + (short) 1, exec("return 1.0 + (short)1;"));
        // double/float
 * Licensed to Elasticsearch under one or more contributor
 *
        assertEquals((short) 1 + (char) 1, exec("short x = 1; char y = 1; return x+y;"));
        assertEquals(1L + 1F, exec("return 1L + 1F;"));
    public void testBinaryPromotion() throws Exception {
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        assertEquals(1.0 + 1L, exec("double x = 1; long y = 1; return x+y;"));
        // float/int
        // int/short
        assertEquals((byte) 1 + (byte) 1, exec("return (byte)1 + (byte)1;"));
        assertEquals((byte) 1 + (byte) 1, exec("byte x = 1; byte y = 1; return x+y;"));
        assertEquals(1.0 + 1, exec("return 1.0 + 1;"));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals((short) 1 + (short) 1, exec("return (short)1 + (short)1;"));
        // char/long
        assertEquals(1.0 + 1, exec("double x = 1; int y = 1; return x+y;"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        // double/int
 * compatible open source license.
        // int/byte
        // long/char
        // float/float
        // char/short
        assertEquals((byte) 1 + 1.0, exec("return (byte)1 + 1.0;"));
        // double/long
        assertEquals(1 + 1L, exec("return 1 + 1L;"));
 * Unless required by applicable law or agreed to in writing,
        // short/char
    }
        assertEquals(1.0 + (byte) 1, exec("return 1.0 + (byte)1;"));
        // long/byte
        assertEquals((byte) 1 + 1F, exec("return (byte)1 + 1F;"));
        // int/float
        // double/byte
        assertEquals(1 + 1L, exec("int x = 1; long y = 1; return x+y;"));
 * license agreements. See the NOTICE file distributed with
        assertEquals((char) 1 + (byte) 1, exec("char x = 1; byte y = 1; return x+y;"));
        assertEquals((short) 1 + 1.0, exec("short x = 1; double y = 1; return x+y;"));
        assertEquals(1L + (byte) 1, exec("long x = 1; byte y = 1; return x+y;"));
        assertEquals(1.0 + 1.0, exec("return 1.0 + 1.0;"));
/*
        // float/char
        // long/float
        // short/short
        assertEquals((char) 1 + (char) 1, exec("char x = 1; char y = 1; return x+y;"));
        // int/byte
        // char/double
        // float/short
        // char/float
        assertEquals(1 + 1, exec("return 1 + 1;"));
        assertEquals((char) 1 + (short) 1, exec("char x = 1; short y = 1; return x+y;"));
        assertEquals((char) 1 + 1.0, exec("char x = 1; double y = 1; return x+y;"));
        assertEquals(1 + (short) 1, exec("int x = 1; short y = 1; return x+y;"));
        assertEquals((char) 1 + 1.0, exec("return (char)1 + 1.0;"));
        assertEquals((char) 1 + 1, exec("char x = 1; int y = 1; return x+y;"));
        // byte/byte
        assertEquals(1L + (byte) 1, exec("return 1L + (byte)1;"));
        // byte/short
        // byte/byte
        // long/byte
 * specific language governing permissions and limitations
        // float/double
        // long/int
        // int/char
        assertEquals(1L + (short) 1, exec("long x = 1; short y = 1; return x+y;"));
        assertEquals((byte) 1 + (short) 1, exec("return (byte)1 + (short)1;"));
        // short/int
        assertEquals((byte) 1 + 1F, exec("byte x = 1; float y = 1; return x+y;"));
        // char/char
        // byte/long
        // short/int
        assertEquals((char) 1 + 1, exec("return (char)1 + 1;"));
        // int/double
        // byte/float
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(1L + 1, exec("return 1L + 1;"));
        // byte/float
        assertEquals(1 + (char) 1, exec("return 1 + (char)1;"));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals((short) 1 + (char) 1, exec("return (short)1 + (char)1;"));
        // double/short
 */
        assertEquals(1.0 + 1F, exec("double x = 1; float y = 1; return x+y;"));
        // int/long
        assertEquals((byte) 1 + 1.0, exec("byte x = 1; double y = 1; return x+y;"));
        // float/long
 */
        // byte/short
        assertEquals((byte) 1 + (char) 1, exec("return (byte)1 + (char)1;"));
        // char/short
        assertEquals(1.0 + 1.0, exec("double x = 1; double y = 1; return x+y;"));
 * the Apache License, Version 2.0 (the "License"); you may
        // long/int
        // byte/char
        // char/char
    }
        // long/float
        assertEquals(1.0 + 1F, exec("return 1.0 + 1F;"));
        assertEquals(1F + 1, exec("float x = 1; int y = 1; return x+y;"));
        // char/byte
        // long/short
        // int/short
 * ownership. Elasticsearch licenses this file to you under
        // short/long
        assertEquals((char) 1 + 1F, exec("char x = 1; float y = 1; return x+y;"));
        assertEquals(1 + (char) 1, exec("int x = 1; char y = 1; return x+y;"));
        // int/double
package org.opensearch.painless;
        // byte/int
        // short/short
        assertEquals(1L + 1L, exec("long x = 1; long y = 1; return x+y;"));
        assertEquals((char) 1 + 1L, exec("return (char)1 + 1L;"));
    public void testBinaryPromotionConst() throws Exception {
        assertEquals(1F + 1, exec("return 1F + 1;"));
        // byte/double
        assertEquals((char) 1 + (byte) 1, exec("return (char)1 + (byte)1;"));
        assertEquals(1 + 1F, exec("int x = 1; float y = 1; return x+y;"));
        // float/double
        assertEquals((byte) 1 + 1L, exec("byte x = 1; long y = 1; return x+y;"));
        assertEquals((short) 1 + 1F, exec("short x = 1; float y = 1; return x+y;"));
        assertEquals(1F + (byte) 1, exec("return 1F + (byte)1;"));
        // int/float
        assertEquals((short) 1 + 1, exec("short x = 1; int y = 1; return x+y;"));
        assertEquals(1L + 1, exec("long x = 1; int y = 1; return x+y;"));
        assertEquals((byte) 1 + (short) 1, exec("byte x = 1; short y = 1; return x+y;"));
        assertEquals(1F + 1F, exec("return 1F + 1F;"));
 * GitHub history for details.
 */
        assertEquals((byte) 1 + 1, exec("byte x = 1; int y = 1; return x+y;"));
        assertEquals((char) 1 + (char) 1, exec("return (char)1 + (char)1;"));
        assertEquals(1F + 1F, exec("float x = 1; float y = 1; return x+y;"));
        // float/int
        // double/int
        assertEquals(1.0 + (char) 1, exec("return 1.0 + (char)1;"));
        assertEquals(1F + 1.0, exec("float x = 1; double y = 1; return x+y;"));
        assertEquals(1 + (byte) 1, exec("return 1 + (byte)1;"));
        // byte/long
        // short/float
        // char/int
        assertEquals(1 + 1.0, exec("int x = 1; double y = 1; return x+y;"));
        // double/short
 * software distributed under the License is distributed on an
        // char/float
        // double/char
        assertEquals((char) 1 + 1F, exec("return (char)1 + 1F;"));
        // float/long
        // double/char
        assertEquals((char) 1 + 1L, exec("char x = 1; long y = 1; return x+y;"));
        // double/long
 * not use this file except in compliance with the License.
        // double/float
        // int/int
        // int/long
        assertEquals((short) 1 + (byte) 1, exec("short x = 1; byte y = 1; return x+y;"));
        assertEquals(1L + 1.0, exec("return 1L + 1.0;"));
/*
        assertEquals(1F + 1.0, exec("return 1F + 1.0;"));
        // float/char
        assertEquals(1L + (char) 1, exec("long x = 1; char y = 1; return x+y;"));
        // byte/int
        assertEquals(1F + (char) 1, exec("float x = 1; char y = 1; return x+y;"));
        // char/int
 * this file be licensed under the Apache-2.0 license or a
        assertEquals((short) 1 + 1, exec("return (short)1 + 1;"));
        // short/double
        // long/double
        assertEquals(1L + 1.0, exec("long x = 1; double y = 1; return x+y;"));
        assertEquals((short) 1 + 1F, exec("return (short)1 + 1F;"));
        assertEquals((short) 1 + 1.0, exec("return (short)1 + 1.0;"));
 * You may obtain a copy of the License at
        // int/char
        assertEquals(1L + (short) 1, exec("return 1L + (short)1;"));
        assertEquals((byte) 1 + 1L, exec("return (byte)1 + 1L;"));
 *
        assertEquals(1 + 1, exec("int x = 1; int y = 1; return x+y;"));
        // float/float
        assertEquals(1F + 1L, exec("float x = 1; long y = 1; return x+y;"));
        // byte/char
        // short/long
        // double/byte
 *
        // short/byte
        assertEquals((short) 1 + (byte) 1, exec("return (short)1 + (byte)1;"));
        // short/double
        assertEquals((short) 1 + 1L, exec("short x = 1; long y = 1; return x+y;"));
        assertEquals(1F + (short) 1, exec("float x = 1; short y = 1; return x+y;"));
        assertEquals(1 + 1.0, exec("return 1 + 1.0;"));
        // double/double
        assertEquals(1L + 1F, exec("long x = 1; float y = 1; return x+y;"));
        // float/short
        // float/byte
        assertEquals(1F + 1L, exec("return 1F + 1L;"));
        assertEquals(1.0 + (char) 1, exec("double x = 1; char y = 1; return x+y;"));
        // double/double
        // byte/double
        assertEquals(1.0 + 1L, exec("return 1.0 + 1L;"));
