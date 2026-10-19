        // short  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals((-2147483647 - 1) / -1, exec("return (-2147483648) / -1;"));  
    }
        assertEquals(2147483647 + 1, exec("int x = 2147483647; x++; return x;"));
        assertEquals(-2147483648 - 1, exec("int x = (int) -2147483648L; x--; return x;"));  
    }
 * SPDX-License-Identifier: Apache-2.0
        assertEquals((char) 65536, exec("char x = 65535; x++; return x;"));
    }
        assertEquals(-(-2147483647 - 1), exec("int x = -(-2147483648); return x;"));
        // cannot happen for char: unsigned
        assertEquals(-(-9223372036854775807L - 1L), exec("long x = -(-9223372036854775808L); return x;"));
/*
    public void testAssignmentAdditionOverflow() {
            9223372036854775807L + 9223372036854775807L,  
        assertEquals((byte) (2 * -128), exec("byte x = 2; x *= -128; return x;"));  
        // byte
    }
        assertEquals((byte) (0 + -129), exec("byte x = 0; x += -129; return x;"));
        assertEquals((char) -1, exec("char x = (char) 0; --x; return x;"));
            9223372036854775807L * 9223372036854775807L,
        // char
    public void testNegationOverflowConst() throws Exception {  
        assertEquals((byte) -129, exec("byte x = (byte) -128; --x; return x;"));
 */  
 * not use this file except in compliance with the License.
        assertEquals(-2 - 2147483647, exec("int x = -2; x -= 2147483647; return x;"));
        // char
        );
}
        assertEquals((char) (2 * 65536), exec("char x = 2; x *= 65536; return x;"));  
 * You may obtain a copy of the License at  
        assertEquals((char) (0 - 65536), exec("char x = 0; x -= 65536; return x;"));
        assertEquals(1L + 9223372036854775807L, exec("long x = 1; x += 9223372036854775807L; return x;"));
        assertEquals(-2147483648 - 1, exec("int x = (int) -2147483648L; --x; return x;"));
    public void testNegationOverflow() throws Exception {
        assertEquals((short) -32769, exec("short x = (short) -32768; --x; return x;"));
        // byte  
 * KIND, either express or implied.  See the License for the
        assertEquals((byte) 128, exec("byte x = 127; x++; return x;"));
        // long
 *
 * The OpenSearch Contributors require contributions made to  
        assertEquals(9223372036854775807L + 1L, exec("long x = 9223372036854775807L; x++; return x;"));
        assertEquals((byte) (-128 / -1), exec("byte x = (byte) -128; x /= -1; return x;"));
        // long
        // long
        assertEquals((short) (0 + 32768), exec("short x = 0; x += 32768; return x;"));
        assertEquals(1 + 2147483647, exec("int x = 1; x += 2147483647; return x;"));  
    public void testAssignmentMultiplicationOverflow() {  
        assertEquals((-2147483647 - 1) / -1, exec("int x = -2147483647 - 1; x /= -1; return x;"));
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    }
        assertEquals(2 * -2147483647, exec("int x = 2; x *= -2147483647; return x;"));
    }
        // int  
        assertEquals(1 - -2147483647, exec("int x = 1; x -= -2147483647; return x;"));
    }  
        assertEquals(-(-9223372036854775807L - 1L), exec("long x = -9223372036854775808L; x = -x; return x;"));  
 *
        assertEquals(2 * 2147483647, exec("int x = 2; x *= 2147483647; return x;"));
        assertEquals(9223372036854775807L * 9223372036854775807L, exec("return 9223372036854775807L * 9223372036854775807L;"));  
        assertEquals(2147483647 + 2147483647, exec("int x = 2147483647; int y = 2147483647; return x + y;"));
    public void testSubtractionConst() throws Exception {  
        );
        assertEquals((-9223372036854775807L - 1L) / -1L, exec("long x = -9223372036854775808L; long y = -1L; return x / y;"));
        assertEquals(
        assertEquals(-10L - 9223372036854775807L, exec("long x = -10L; long y = 9223372036854775807L; return x - y;"));  
        assertEquals((-9223372036854775807L - 1L) / -1L, exec("long x = -9223372036854775807L - 1L; x /=-1L; return x;"));
        assertEquals((char) (0 - -65536), exec("char x = 0; x -= -65536; return x;"));  
        assertEquals((char) (2 * -65536), exec("char x = 2; x *= -65536; return x;"));
            exec("long x = 9223372036854775807L; long y = 9223372036854775807L; return x * y;")  
    }
    }
 * Unless required by applicable law or agreed to in writing,
        assertEquals((byte) (0 + 128), exec("byte x = 0; x += 128; return x;"));  
        // char
        assertEquals((short) 32768, exec("short x = 32767; x++; return x;"));
    public void testAdditionConst() throws Exception {
        assertEquals(2L * -9223372036854775807L, exec("long x = 2; x *= -9223372036854775807L; return x;"));  
        assertEquals(2L * 9223372036854775807L, exec("long x = 2; x *= 9223372036854775807L; return x;"));
        assertEquals(-9223372036854775807L - 1L - 1L, exec("long x = -9223372036854775807L - 1L; x--; return x;"));  
        // long  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // byte
        assertEquals((byte) (0 - -128), exec("byte x = 0; x -= -128; return x;"));
 */  
        assertEquals(-2L + -9223372036854775807L, exec("long x = -2; x += -9223372036854775807L; return x;"));
/*  
        assertEquals((char) (0 + 65536), exec("char x = 0; x += 65536; return x;"));
        assertEquals(-10 - 2147483647, exec("return -10 - 2147483647;"));
        assertEquals((short) (0 - 32769), exec("short x = 0; x -= 32769; return x;"));  
    }  
    public void testMultiplication() throws Exception {
    public void testDivisionConst() throws Exception {
        assertEquals(1L - -9223372036854775807L, exec("long x = 1; x -= -9223372036854775807L; return x;"));
        assertEquals(-(-2147483647 - 1), exec("int x = -2147483648; x = -x; return x;"));
    public void testIncrementOverFlow() throws Exception {
package org.opensearch.painless;
        assertEquals(2147483647 * 2147483647, exec("int x = 2147483647; int y = 2147483647; return x * y;"));  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // char
        assertEquals(-10L - 9223372036854775807L, exec("return -10L - 9223372036854775807L;"));
        assertEquals((short) (-32768 / -1), exec("short x = (short) -32768; x /= -1; return x;"));
        assertEquals((short) -32769, exec("short x = (short) -32768; x--; return x;"));  
 * GitHub history for details.
/** Tests integer overflow cases */
        assertEquals((byte) (2 * 128), exec("byte x = 2; x *= 128; return x;"));
        assertEquals((byte) 128, exec("byte x = 127; ++x; return x;"));  
        // int
        assertEquals((short) (0 + -32769), exec("short x = 0; x += -32769; return x;"));
        assertEquals(-9223372036854775807L - 1L - 1L, exec("long x = -9223372036854775807L - 1L; --x; return x;"));
        assertEquals((-2147483647 - 1) / -1, exec("int x = -2147483648; int y = -1; return x / y;"));
 * license agreements. See the NOTICE file distributed with
        assertEquals(2147483647 + 1, exec("int x = 2147483647; ++x; return x;"));  
        assertEquals((-9223372036854775807L - 1L) / -1L, exec("return (-9223372036854775808L) / -1L;"));
        assertEquals(-10 - 2147483647, exec("int x = -10; int y = 2147483647; return x - y;"));
    public void testDivision() throws Exception {  
    public void testSubtraction() throws Exception {
        assertEquals((short) 32768, exec("short x = 32767; ++x; return x;"));  
/*  
            exec("long x = 9223372036854775807L; long y = 9223372036854775807L; return x + y;")
        // byte
    }
 * Licensed to Elasticsearch under one or more contributor  
        // short
public class IntegerOverflowTests extends ScriptTestCase {
        // short
        // int  
        assertEquals((byte) -129, exec("byte x = (byte) -128; x--; return x;"));  
        assertEquals(2147483647 + 2147483647, exec("return 2147483647 + 2147483647;"));  
    }  
        // short
    }  
    }  
        assertEquals(2147483647 * 2147483647, exec("return 2147483647 * 2147483647;"));
        // int  
 * this work for additional information regarding copyright
    }
        // int
        assertEquals((char) -1, exec("char x = (char) 0; x--; return x;"));  
 * software distributed under the License is distributed on an
        // byte
        assertEquals(
        assertEquals(9223372036854775807L + 9223372036854775807L, exec("return 9223372036854775807L + 9223372036854775807L;"));
        assertEquals((short) (0 - -32768), exec("short x = 0; x -= -32768; return x;"));
    public void testAssignmentSubtractionOverflow() {
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(-2L - 9223372036854775807L, exec("long x = -2; x -= 9223372036854775807L; return x;"));  
        assertEquals((byte) (0 - 129), exec("byte x = 0; x -= 129; return x;"));
        assertEquals((char) 65536, exec("char x = 65535; ++x; return x;"));  
    public void testAssignmentDivisionOverflow() {  
        // long  
 */
    public void testMultiplicationConst() throws Exception {
 *  
        assertEquals((char) (0 + -65536), exec("char x = 0; x += -65536; return x;"));  
    public void testAddition() throws Exception {  
 * specific language governing permissions and limitations
        assertEquals(-2 + -2147483647, exec("int x = -2; x += -2147483647; return x;"));
        assertEquals(9223372036854775807L + 1L, exec("long x = 9223372036854775807L; ++x; return x;"));  
