        assertEquals(5F, exec("def x = 5L; return (float) (+x);"));
 * GitHub history for details.
        assertEquals(5L, exec("def x = 5L; return (long) (+x);"));
    }
        assertEquals(10F, exec("long x = 5L; return (float) (x <<= 1);"));
        assertEquals("s7171", exec("String s = 's'; byte c = 71; s += c + '' + c; return s"));
        assertEquals(6L, exec("long x = 5L; return (long) (x += 1);"));
    }
        assertEquals(6D, exec("long x = 5L; return (double) (++x);"));
    /**
    /**
        assertEquals(5, exec("def x = 5L; return (int) (+x);"));
 * specific language governing permissions and limitations
    /**
        assertEquals("s142", exec("String s = 's'; char c = 71; s += c + c + ''; return s"));
        assertEquals("s71", exec("String s = 's'; long c = 71; s += c; return s"));
        expectScriptThrows(ClassCastException.class, () -> exec("float f = 1.0f; def y = 1; y.compareTo(f);"));
    /**
    public void testIllegalVoidCasts() {
        assertEquals(1, exec("def y = 2.0; y.compareTo(1);"));
        assertEquals("s71s", exec("String s = 's'; long c = 71; s += c + s; return s"));
        assertEquals(5D, exec("def x = 5L; return (double) (x++);"));
        });
     * Binary compound prefix with explicit cast
        assertEquals(5F, exec("def x = 5L; return (float) (x++);"));
        assertEquals("s71", exec("String s = 's'; byte c = 71; s += c; return s"));
        assertEquals("s142.0s", exec("String s = 's'; float c = 71; s += c + c + s; return s"));
public class GeneralCastTests extends ScriptTestCase {
        assertEquals((byte) 5, exec("long x = 5L; return (byte) (+x);"));
/*
        assertEquals(6L, exec("def x = 5L; return (long) (x + 1);"));
    }
        assertEquals("ssGG", exec("String s = 's'; char c = 71; s += s + c + c; return s"));
        assertEquals("s7171", exec("String s = 's'; long c = 71; s += c + '' + c; return s"));
        assertEquals("ss71.071.0", exec("String s = 's'; double c = 71; s += s + c + c; return s"));
     * Unary operator with explicit cast
        assertEquals("ss[71][71]", exec("String s = 's'; List c = [71]; s += s + c + c; return s"));
    }
        expectScriptThrows(IllegalArgumentException.class, () -> {
        assertEquals(10F, exec("def x = 5L; return (float) (x <<= 1);"));
        assertEquals("s142s", exec("String s = 's'; int c = 71; s += c + c + s; return s"));
    }
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; int y = (x + x); return y"); });
     * (stuff that methodhandles explicitCastArguments would otherwise allow)
        assertEquals("ss7171", exec("String s = 's'; short c = 71; s += s + c + c; return s"));
        assertEquals("s[71][71]", exec("String s = 's'; List c = [71]; s += '' + c + c; return s"));
        assertEquals("s[71]", exec("String s = 's'; List c = [71]; s += c; return s"));
        assertEquals(6L, exec("def x = 5L; return (long) (++x);"));
    /**
        assertEquals(6D, exec("def x = 5L; return (double) (x += 1);"));
        assertEquals("sG", exec("String s = 's'; char c = 71; s += c; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; boolean y = (boolean) (x + x); return y"); });
        assertEquals((short) 6, exec("def x = 5L; return (short) (x + 1);"));
        assertEquals(6F, exec("long x = 5L; return (float) (x + 1);"));
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; boolean y = (boolean) +x; return y"); });
    public void testIllegalConversions() {
        assertEquals("ss7171", exec("String s = 's'; long c = 71; s += s + c + c; return s"));
        assertEquals('b', exec("def x = 'abcdeg'; def y = 1L; x.charAt((int)y)"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; int y = (x + x); return y"); });
        assertEquals("s71s71", exec("String s = 's'; byte c = 71; s += c + s + c; return s"));
package org.opensearch.painless;
    public void testBinaryCompoundAssignmentPostfix() {
     * Binary operators adopt the return value
        assertEquals("s142s", exec("String s = 's'; char c = 71; s += c + c + s; return s"));
        assertEquals(10, exec("long x = 5L; return (int) (x << 1);"));
        assertEquals((byte) 5, exec("def x = 5L; return (byte) (x++);"));
        assertEquals((short) 5, exec("def x = 5L; return (short) (x++);"));
/*
        assertEquals(10L, exec("def x = 5L; return (long) (x << 1);"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("ss7171", exec("String s = 's'; int c = 71; s += s + c + c; return s"));
        assertEquals("s71.071.0", exec("String s = 's'; double c = 71; s += '' + c + c; return s"));
        assertEquals("s71.0s", exec("String s = 's'; double c = 71; s += c + s; return s"));
        assertEquals((byte) 5, exec("long x = 5L; return (byte) (x++);"));
        assertEquals(10D, exec("long x = 5L; return (double) (x <<= 1);"));
     * Test that even with a cast, some things aren't allowed.
     */
        assertEquals(5F, exec("long x = 5L; return (float) (+x);"));
        assertEquals((byte) 6, exec("def x = 5L; return (byte) (x + 1);"));
        assertEquals((char) 6, exec("long x = 5L; return (char) (x += 1);"));
 *
        assertEquals((char) 5, exec("long x = 5L; return (char) (x++);"));
        assertEquals("sGsG", exec("String s = 's'; char c = 71; s += c + s + c; return s"));
        assertEquals(10D, exec("def x = 5L; return (double) (x <<= 1);"));
    }
        assertEquals((char) 6, exec("long x = 5L; return (char) (x + 1);"));
     */
        assertEquals("s71s71", exec("String s = 's'; short c = 71; s += c + s + c; return s"));
        assertEquals("s142.0", exec("String s = 's'; double c = 71; s += c + c; return s"));
        assertEquals(6D, exec("def x = 5L; return (double) (++x);"));
        assertEquals("s[71][71]", exec("String s = 's'; List c = [71]; s += c + '' + c; return s"));
    public void testShiftOperatorDef() {
    }
        assertEquals((short) 6, exec("long x = 5L; return (short) (x + 1);"));
     */
    /**
        assertEquals(6D, exec("def x = 5L; return (double) (x + 1);"));
        assertEquals('a', exec("'a'.charAt(Integer.valueOf(0))"));
     */
        assertEquals((byte) 6, exec("long x = 5L; return (byte) (x + 1);"));
        expectScriptThrows(ClassCastException.class, () -> { exec("boolean x = true; int y = +x; return y"); });
        assertEquals(10L, exec("long x = 5L; return (long) (x << 1);"));
    public void testBinaryPrefix() {
     */
    /**
        assertEquals(10F, exec("def x = 5L; return (float) (x << 1);"));
        assertEquals(10L, exec("def x = 5L; return (long) (x <<= 1);"));
 * under the License.
        assertEquals("s71s", exec("String s = 's'; byte c = 71; s += c + s; return s"));
        assertEquals((byte) 10, exec("long x = 5L; return (byte) (x << 1);"));
                    + "Byte i = Byte.valueOf(3); "
        assertEquals(6, exec("def x = 5; def y = 1L; return x + (int)y"));
        expectScriptThrows(ClassCastException.class, () -> { exec("boolean x = true; int y = (int) (x ^ false); return y"); });
 */
    public void testBinaryPostfix() {
        assertEquals(2, exec("def f = new org.opensearch.painless.FeatureTestObject(); f.i = (byte)2; f.i"));
     */
        assertEquals("s71.0", exec("String s = 's'; float c = 71; s += c; return s"));
 */
                    + "byte j = 1;"
        assertEquals("s7171", exec("String s = 's'; String c = '71'; s += c + '' + c; return s"));
        assertEquals((byte) 5, exec("def x = 5L; return (byte) (+x);"));
        assertEquals("s[71]s", exec("String s = 's'; List c = [71]; s += c + s; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("boolean x = true; int y = (int) +x; return y"); });
        assertEquals("s142.0s", exec("String s = 's'; double c = 71; s += c + c + s; return s"));
    }
    public void testUnaryOperator() {
        assertEquals((char) 10, exec("long x = 5L; return (char) (x <<= 1);"));
        assertEquals("s7171", exec("String s = 's'; String c = '71'; s += c + c + ''; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; boolean y = (boolean) +x; return y"); });
    public void testIllegalExplicitConversions() {
        assertEquals("s142", exec("String s = 's'; byte c = 71; s += c + c + ''; return s"));
        assertEquals("s142s", exec("String s = 's'; long c = 71; s += c + c + s; return s"));
        assertEquals(5D, exec("def x = 5L; return (double) (+x);"));
    /**
 */
    /**
    }
    public void testBoxedDefCalls() {
     * Shift compound assignment with explicit cast
        assertEquals(6F, exec("long x = 5L; return (float) (x += 1);"));
 * this work for additional information regarding copyright
        e = expectScriptThrows(ClassCastException.class, () -> exec("'a'.charAt(0.0f)"));
        assertEquals(1, exec("def x = 1; def y = 2.0; y.compareTo(x);"));
    }
        assertEquals("s71", exec("String s = 's'; String c = '71'; s += c; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; int y = +x; return y"); });
        assertEquals("s142", exec("String s = 's'; byte c = 71; s += c + c; return s"));
     * Test that even with a cast, some things aren't allowed.
     */
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = true; int y = (int) +x; return y"); });
        assertEquals(5L, exec("def x = 5L; return (long) (x++);"));
     */
        assertEquals(6, exec("long x = 5L; return (int) (++x);"));
     * Test that without a cast, we fail when conversions would narrow.
        assertEquals((char) 6, exec("def x = 5L; return (char) (x + 1);"));
    /**
 * not use this file except in compliance with the License.
        assertEquals((char) 10, exec("long x = 5L; return (char) (x << 1);"));
        assertEquals("s142", exec("String s = 's'; short c = 71; s += c + c; return s"));
        assertEquals((char) 10, exec("def x = 5L; return (char) (x << 1);"));
            exec("Map map = ['a': 1,'b': 2,'c': 3]; def x = new HashMap(); x.put(1, map.clear());");
        assertEquals("Cannot cast from [long] to [int].", e.getMessage());
        assertEquals("s71.0s71.0", exec("String s = 's'; float c = 71; s += c + s +  c; return s"));
        assertEquals("s142", exec("String s = 's'; long c = 71; s += c + c; return s"));
        assertEquals((short) 10, exec("long x = 5L; return (short) (x << 1);"));
        assertEquals((short) 6, exec("def x = 5L; return (short) (++x);"));
        assertEquals((char) 10, exec("def x = 5L; return (char) (x <<= 1);"));
            4.0,
    /**
        assertEquals("s142", exec("String s = 's'; long c = 71; s += c + c + ''; return s"));
        assertEquals(6F, exec("def x = 5L; return (float) (++x);"));
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; boolean y = (boolean) (x + x); return y"); });
        assertEquals((byte) 6, exec("def x = 5L; return (byte) (++x);"));
        assertEquals((byte) 6, exec("def x = 5L; return (byte) (x += 1);"));
        assertEquals((char) 5, exec("def x = 5L; return (char) (+x);"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = true; int y = (int) (x ^ false); return y"); });
        assertEquals(10D, exec("long x = 5L; return (double) (x << 1);"));
    /**
 * Licensed to Elasticsearch under one or more contributor
     */
    public void testCompoundAssignmentStringCasts() {
    public void testShiftCompoundAssignmentDef() {
        assertEquals("s71s", exec("String s = 's'; int c = 71; s += c + s; return s"));
        assertEquals(10D, exec("def x = 5L; return (double) (x << 1);"));
    /**
        assertEquals("s71.071.0", exec("String s = 's'; float c = 71; s += c + '' +  c; return s"));
        assertNull(exec("def f = new org.opensearch.painless.FeatureTestObject(); f.i = null; f.i"));
    public void testIllegalCastInMethodArgument() {
    public void testIllegalExplicitConversionsDef() {
        expectScriptThrows(IllegalArgumentException.class, () -> {
        assertEquals("s142", exec("String s = 's'; int c = 71; s += c + c; return s"));
        assertEquals("s142s", exec("String s = 's'; byte c = 71; s += c + c + s; return s"));
     */
    /**
        assertEquals("s71", exec("String s = 's'; int c = 71; s += c; return s"));
    public void testBinaryOperator() {
        assertEquals("s142s", exec("String s = 's'; short c = 71; s += c + c + s; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("boolean x = true; int y = (x ^ false); return y"); });
     * Currently these do not adopt the argument value, we issue a separate cast!
        assertEquals("s7171", exec("String s = 's'; byte c = 71; s += '' + c + c; return s"));
    }
        assertEquals("s71s71", exec("String s = 's'; String c = '71'; s += c + s + c; return s"));
        assertEquals(10F, exec("long x = 5L; return (float) (x << 1);"));
     */
        assertEquals((byte) 10, exec("def x = 5L; return (byte) (x <<= 1);"));
     * Binary operators don't yet adopt the return value with compound assignment
     * Shift operators adopt the return value
        assertEquals((short) 10, exec("def x = 5L; return (short) (x <<= 1);"));
        assertEquals(6, exec("def x = 5L; return (int) (x += 1);"));
        assertEquals("sGs", exec("String s = 's'; char c = 71; s += c + s; return s"));
    }
        assertEquals(5F, exec("long x = 5L; return (float) (x++);"));
    public void testBinaryCompoundAssignmentDef() {
                    + "Short s = Short.valueOf(-2);"
    public void testBinaryCompoundAssignmentPrefix() {
        assertEquals(6D, exec("long x = 5L; return (double) (x + 1);"));
        assertEquals("ss7171", exec("String s = 's'; String c = '71'; s += s + c + c; return s"));
     */
            exec("def map = ['a': 1,'b': 2,'c': 3]; map.c = Collections.sort(new ArrayList(map.keySet()));");
        assertEquals("s142.0", exec("String s = 's'; double c = 71; s += c + c + ''; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = true; int y = (x ^ false); return y"); });
    /**
 * The OpenSearch Contributors require contributions made to
        assertEquals("s142", exec("String s = 's'; int c = 71; s += c + c + ''; return s"));
        assertEquals(10, exec("def x = 5L; return (int) (x <<= 1);"));
    }
        assertEquals("s7171", exec("String s = 's'; long c = 71; s += '' + c + c; return s"));
        e = expectScriptThrows(ClassCastException.class, () -> exec("'a'.charAt(0.0d)"));
        assertEquals((char) 6, exec("long x = 5L; return (char) (++x);"));
        assertEquals((byte) 10, exec("long x = 5L; return (byte) (x <<= 1);"));
     * Binary compound assignment with explicit cast
        assertEquals("s142", exec("String s = 's'; short c = 71; s += c + c + ''; return s"));
            )
     * Shift operators with explicit cast
        assertEquals("s142", exec("String s = 's'; char c = 71; s += c + c; return s"));
                "def x = new org.opensearch.painless.FeatureTestObject(); "
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; boolean y = +x; return y"); });
        assertEquals(5, exec("long x = 5L; return (int) (+x);"));
     * Binary compound postifx with explicit cast
        assertEquals(5L, exec("long x = 5L; return (long) (+x);"));
    public void testUnaryOperatorDef() {
    public void testMethodCallDef() {
    }
        assertEquals((short) 10, exec("def x = 5L; return (short) (x << 1);"));
 * You may obtain a copy of the License at
        assertEquals(5L, exec("long x = 5L; return (long) (x++);"));
        assertEquals("s71s", exec("String s = 's'; short c = 71; s += c + s; return s"));
 * license agreements. See the NOTICE file distributed with
    }
        assertEquals("s71.0", exec("String s = 's'; double c = 71; s += c; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = true; int y = +x; return y"); });
        assertEquals("s7171", exec("String s = 's'; int c = 71; s += '' + c + c; return s"));
     */
    }
    }
     * Unary operators adopt the return value
    }
        assertEquals(10L, exec("long x = 5L; return (long) (x <<= 1);"));
     */
        assertEquals(6L, exec("long x = 5L; return (long) (x + 1);"));
        assertEquals((short) 5, exec("long x = 5L; return (short) (+x);"));
            exec(
        assertEquals("s71", exec("String s = 's'; short c = 71; s += c; return s"));
    /**
        assertEquals("sGG", exec("String s = 's'; char c = 71; s += c + '' + c; return s"));
        assertEquals("s71s71", exec("String s = 's'; int c = 71; s += c + s + c; return s"));
        assertEquals(6, exec("long x = 5L; return (int) (x + 1);"));
        assertEquals((short) 6, exec("long x = 5L; return (short) (++x);"));
    /**
/*
     * Test that without a cast, we fail when conversions would narrow.
        assertEquals('a', exec("'a'.charAt(0)"));
        assertEquals(6F, exec("def x = 5L; return (float) (x + 1);"));
     * Binary operators don't yet adopt the return value with compound assignment
        assertEquals(6, exec("long x = 5L; return (int) (x += 1);"));
        assertEquals((short) 5, exec("def x = 5L; return (short) (+x);"));
    /**
        assertEquals("s142.0", exec("String s = 's'; float c = 71; s += c + c + ''; return s"));
     * Shift operators don't yet adopt the return value with compound assignment
/** Tests for explicit casts */
        assertEquals((char) 5, exec("long x = 5L; return (char) (+x);"));
        assertEquals(5, exec("def x = 5L; return (+(int)x);"));
        assertEquals(
    }
        assertEquals(5, exec("def x = 5L; return (int) (x++);"));
        assertEquals(10, exec("long x = 5L; return (int) (x <<= 1);"));
        assertEquals(6L, exec("long x = 5L; return (long) (++x);"));
    public void testArgumentsDef() {
    }
        assertEquals("s7171", exec("String s = 's'; short c = 71; s += c + '' + c; return s"));
        assertEquals((short) 6, exec("def x = 5L; return (short) (x += 1);"));
        assertEquals(6F, exec("def x = 5L; return (float) (x += 1);"));
        assertEquals("s7171s", exec("String s = 's'; String c = '71'; s += c + c + s; return s"));
     * Currently these do not adopt the return value, we issue a separate cast!
 * SPDX-License-Identifier: Apache-2.0
    public void testShiftOperator() {
     * Binary operators don't yet adopt the return value with compound assignment
        assertEquals((short) 10, exec("long x = 5L; return (short) (x <<= 1);"));
        assertEquals("s71.0s71.0", exec("String s = 's'; double c = 71; s += c + s + c; return s"));
    public void testBinaryOperatorDef() {
        assertEquals(6F, exec("long x = 5L; return (float) (++x);"));
        assertEquals((char) 6, exec("def x = 5L; return (char) (++x);"));
    /**
 *
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; boolean y = (x + x); return y"); });
        expectScriptThrows(ClassCastException.class, () -> exec("def x = 2.0; def y = 1; y.compareTo(x);"));
     */
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals("ss7171", exec("String s = 's'; byte c = 71; s += s + c + c; return s"));
 * compatible open source license.
    }
        assertEquals(5D, exec("long x = 5L; return (double) (x++);"));
        assertEquals((short) 6, exec("long x = 5L; return (short) (x += 1);"));
     */
        assertEquals(5, exec("long x = 5L; return (int) (x++);"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; boolean y = +x; return y"); });
        assertEquals(-1, exec("Integer x = Integer.valueOf(3); def y = 2.0; y.compareTo(x);"));
    }
        assertEquals((byte) 6, exec("long x = 5L; return (byte) (x += 1);"));
    }
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; boolean y = (x + x); return y"); });
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        assertEquals("s142.0", exec("String s = 's'; float c = 71; s += c + c; return s"));
        assertEquals(6L, exec("def x = 5L; return (long) (x += 1);"));
        assertEquals(1, exec("int x = 1; def y = 2.0; y.compareTo(x);"));
        assertEquals("s7171", exec("String s = 's'; short c = 71; s += '' + c + c; return s"));
                    + "x.mixedAdd(j, i, (char)2, s)"
    public void testIllegalConversionsDef() {
    public void testShiftCompoundAssignment() {
        assertEquals("Cannot cast from [float] to [int].", e.getMessage());
        assertEquals("s71.071.0", exec("String s = 's'; double c = 71; s += c + '' + c; return s"));
 * ownership. Elasticsearch licenses this file to you under
        assertEquals((char) 5, exec("def x = 5L; return (char) (x++);"));
        assertEquals(6, exec("def x = 5L; return (int) (++x);"));
     * Binary operators with explicit cast
        assertEquals("s7171", exec("String s = 's'; String c = '71'; s += c + c; return s"));
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    }
        assertEquals(5, exec("def x = 5; return (int)x.longValue();"));
        assertEquals(6D, exec("long x = 5L; return (double) (x += 1);"));
        Exception e = expectScriptThrows(ClassCastException.class, () -> exec("'a'.charAt(0L)"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; int y = +x; return y"); });
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals((char) 6, exec("def x = 5L; return (char) (x += 1);"));
}
        assertEquals("Cannot cast from [double] to [int].", e.getMessage());
        assertEquals("s71s71", exec("String s = 's'; long c = 71; s += c + s + c; return s"));
        assertEquals(6, exec("def x = 5L; return (int) (x + 1);"));
        assertEquals((byte) 6, exec("long x = 5L; return (byte) (++x);"));
     */
        assertEquals("ss71.071.0", exec("String s = 's'; float c = 71; s += s + c +  c; return s"));
        );
    }
     */
        assertEquals("sGG", exec("String s = 's'; char c = 71; s += '' + c + c; return s"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals((byte) 10, exec("def x = 5L; return (byte) (x << 1);"));
    public void testBinaryCompoundAssignment() {
 *
        assertEquals("s71.071.0", exec("String s = 's'; float c = 71; s += '' + c +  c; return s"));
     */
        assertEquals(10, exec("def x = 5L; return (int) (x << 1);"));
        });
 * software distributed under the License is distributed on an
        assertEquals("s7171", exec("String s = 's'; int c = 71; s += c + '' + c; return s"));
     */
        assertEquals(5D, exec("long x = 5L; return (double) (+x);"));
        assertEquals("s71.0s", exec("String s = 's'; float c = 71; s += c + s; return s"));
    public void testUnboxMethodParameters() {
        assertEquals((short) 5, exec("long x = 5L; return (short) (x++);"));
        assertEquals("s71s", exec("String s = 's'; String c = '71'; s += c + s; return s"));
        assertEquals("s7171", exec("String s = 's'; String c = '71'; s += '' + c + c; return s"));
        assertEquals("s[71]s[71]", exec("String s = 's'; List c = [71]; s += c + s + c; return s"));
