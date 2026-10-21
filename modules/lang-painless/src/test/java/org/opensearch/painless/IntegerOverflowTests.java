 * Unless required by applicable law or agreed to in writing,
    }
        assertEquals((-2147483647 - 1) / -1, exec("int x = -2147483647 - 1; x /= -1; return x;"));
/*
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(1L + 9223372036854775807L, exec("long x = 1; x += 9223372036854775807L; return x;"));
    public void testAssignmentDivisionOverflow() {
        // short
        assertEquals((byte) 128, exec("byte x = 127; x++; return x;"));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals((byte) -129, exec("byte x = (byte) -128; x--; return x;"));
        assertEquals((char) (0 + -65536), exec("char x = 0; x += -65536; return x;"));
        // char
        );
        // char
        assertEquals((char) 65536, exec("char x = 65535; ++x; return x;"));
        assertEquals((-9223372036854775807L - 1L) / -1L, exec("return (-9223372036854775808L) / -1L;"));
    }
    public void testIncrementOverFlow() throws Exception {
 * The OpenSearch Contributors require contributions made to
        assertEquals(-10 - 2147483647, exec("return -10 - 2147483647;"));
            9223372036854775807L * 9223372036854775807L,
        assertEquals(
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals((-9223372036854775807L - 1L) / -1L, exec("long x = -9223372036854775808L; long y = -1L; return x / y;"));
    }
        assertEquals(9223372036854775807L + 1L, exec("long x = 9223372036854775807L; x++; return x;"));
        assertEquals((short) 32768, exec("short x = 32767; x++; return x;"));
/** Tests integer overflow cases */
        assertEquals(2L * 9223372036854775807L, exec("long x = 2; x *= 9223372036854775807L; return x;"));
    public void testDivisionConst() throws Exception {
    }
        assertEquals(2147483647 * 2147483647, exec("return 2147483647 * 2147483647;"));
    }
 *
 */
        assertEquals((byte) (0 + -129), exec("byte x = 0; x += -129; return x;"));
        assertEquals((-2147483647 - 1) / -1, exec("int x = -2147483648; int y = -1; return x / y;"));
 * software distributed under the License is distributed on an
 * under the License.
        assertEquals((char) (0 - 65536), exec("char x = 0; x -= 65536; return x;"));
        assertEquals(-(-2147483647 - 1), exec("int x = -(-2147483648); return x;"));
        assertEquals(9223372036854775807L + 1L, exec("long x = 9223372036854775807L; ++x; return x;"));
 * specific language governing permissions and limitations
        assertEquals((byte) (0 + 128), exec("byte x = 0; x += 128; return x;"));
        assertEquals(1L - -9223372036854775807L, exec("long x = 1; x -= -9223372036854775807L; return x;"));
        assertEquals((short) (0 + -32769), exec("short x = 0; x += -32769; return x;"));
        // long
        assertEquals((char) (0 + 65536), exec("char x = 0; x += 65536; return x;"));
    public void testAssignmentMultiplicationOverflow() {
        assertEquals((char) (0 - -65536), exec("char x = 0; x -= -65536; return x;"));
        assertEquals(2147483647 + 2147483647, exec("int x = 2147483647; int y = 2147483647; return x + y;"));
    }
    }
    }
        // int
    }
    public void testAdditionConst() throws Exception {
        assertEquals(2L * -9223372036854775807L, exec("long x = 2; x *= -9223372036854775807L; return x;"));
        assertEquals(2147483647 + 1, exec("int x = 2147483647; ++x; return x;"));
        // long
        // cannot happen for char: unsigned
public class IntegerOverflowTests extends ScriptTestCase {
        assertEquals(
    public void testDivision() throws Exception {
        assertEquals((byte) (2 * 128), exec("byte x = 2; x *= 128; return x;"));
        assertEquals(-9223372036854775807L - 1L - 1L, exec("long x = -9223372036854775807L - 1L; --x; return x;"));
    public void testNegationOverflowConst() throws Exception {
        assertEquals(2 * 2147483647, exec("int x = 2; x *= 2147483647; return x;"));
 * KIND, either express or implied.  See the License for the
    }
 */
        assertEquals((char) -1, exec("char x = (char) 0; x--; return x;"));
        assertEquals((short) -32769, exec("short x = (short) -32768; x--; return x;"));
        assertEquals((short) (0 - -32768), exec("short x = 0; x -= -32768; return x;"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            exec("long x = 9223372036854775807L; long y = 9223372036854775807L; return x * y;")
        assertEquals((byte) (-128 / -1), exec("byte x = (byte) -128; x /= -1; return x;"));
    public void testAddition() throws Exception {
        assertEquals(-2L - 9223372036854775807L, exec("long x = -2; x -= 9223372036854775807L; return x;"));
    public void testMultiplication() throws Exception {
        assertEquals(1 - -2147483647, exec("int x = 1; x -= -2147483647; return x;"));
        assertEquals((-2147483647 - 1) / -1, exec("return (-2147483648) / -1;"));
        // long
        assertEquals((short) (0 + 32768), exec("short x = 0; x += 32768; return x;"));
        assertEquals((char) (2 * -65536), exec("char x = 2; x *= -65536; return x;"));
package org.opensearch.painless;
        assertEquals(-2 + -2147483647, exec("int x = -2; x += -2147483647; return x;"));
 *
    public void testMultiplicationConst() throws Exception {
        // int
 */
 * not use this file except in compliance with the License.
        );
        assertEquals(-(-2147483647 - 1), exec("int x = -2147483648; x = -x; return x;"));
    }
            9223372036854775807L + 9223372036854775807L,
}
        assertEquals(-2L + -9223372036854775807L, exec("long x = -2; x += -9223372036854775807L; return x;"));
 * You may obtain a copy of the License at
    }
        // byte
        assertEquals(9223372036854775807L * 9223372036854775807L, exec("return 9223372036854775807L * 9223372036854775807L;"));
        // short
 *
        assertEquals(2147483647 * 2147483647, exec("int x = 2147483647; int y = 2147483647; return x * y;"));
        assertEquals(2147483647 + 2147483647, exec("return 2147483647 + 2147483647;"));
        assertEquals((byte) (0 - -128), exec("byte x = 0; x -= -128; return x;"));
        assertEquals(-9223372036854775807L - 1L - 1L, exec("long x = -9223372036854775807L - 1L; x--; return x;"));
        assertEquals(-10L - 9223372036854775807L, exec("long x = -10L; long y = 9223372036854775807L; return x - y;"));
        // int
        // byte
        assertEquals(-2147483648 - 1, exec("int x = (int) -2147483648L; --x; return x;"));
        assertEquals((byte) (2 * -128), exec("byte x = 2; x *= -128; return x;"));
        // int
        assertEquals((short) -32769, exec("short x = (short) -32768; --x; return x;"));
        // short
        assertEquals((short) (-32768 / -1), exec("short x = (short) -32768; x /= -1; return x;"));
        assertEquals(9223372036854775807L + 9223372036854775807L, exec("return 9223372036854775807L + 9223372036854775807L;"));
        assertEquals((byte) -129, exec("byte x = (byte) -128; --x; return x;"));
        // byte
        assertEquals((byte) 128, exec("byte x = 127; ++x; return x;"));
    public void testAssignmentSubtractionOverflow() {
 * GitHub history for details.
        assertEquals(-10 - 2147483647, exec("int x = -10; int y = 2147483647; return x - y;"));
 * this work for additional information regarding copyright
        assertEquals((char) 65536, exec("char x = 65535; x++; return x;"));
        assertEquals(-2 - 2147483647, exec("int x = -2; x -= 2147483647; return x;"));
        assertEquals((-9223372036854775807L - 1L) / -1L, exec("long x = -9223372036854775807L - 1L; x /=-1L; return x;"));
        assertEquals(-(-9223372036854775807L - 1L), exec("long x = -(-9223372036854775808L); return x;"));
        // byte
        // char
    }
/*
        // int
        assertEquals(2 * -2147483647, exec("int x = 2; x *= -2147483647; return x;"));
    public void testNegationOverflow() throws Exception {
        assertEquals((char) -1, exec("char x = (char) 0; --x; return x;"));
        assertEquals(-(-9223372036854775807L - 1L), exec("long x = -9223372036854775808L; x = -x; return x;"));
        // short
    }
 * ownership. Elasticsearch licenses this file to you under
 * Licensed to Elasticsearch under one or more contributor
        assertEquals((short) 32768, exec("short x = 32767; ++x; return x;"));
    public void testSubtraction() throws Exception {
        // char
            exec("long x = 9223372036854775807L; long y = 9223372036854775807L; return x + y;")
/*
        assertEquals(-2147483648 - 1, exec("int x = (int) -2147483648L; x--; return x;"));
        // long
        assertEquals((char) (2 * 65536), exec("char x = 2; x *= 65536; return x;"));
        // long
    }
        assertEquals(1 + 2147483647, exec("int x = 1; x += 2147483647; return x;"));
    public void testAssignmentAdditionOverflow() {
    public void testSubtractionConst() throws Exception {
        assertEquals((byte) (0 - 129), exec("byte x = 0; x -= 129; return x;"));
        assertEquals(2147483647 + 1, exec("int x = 2147483647; x++; return x;"));
 * SPDX-License-Identifier: Apache-2.0
        // byte
        assertEquals((short) (0 - 32769), exec("short x = 0; x -= 32769; return x;"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(-10L - 9223372036854775807L, exec("return -10L - 9223372036854775807L;"));
