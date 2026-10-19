     */  
     */  
     */
        assertEquals(6D, exec("long x = 5L; return (double) (x += 1);"));
    /**
        assertEquals(6, exec("def x = 5L; return (int) (x + 1);"));  
        assertEquals("ss[71][71]", exec("String s = 's'; List c = [71]; s += s + c + c; return s"));
        assertEquals("s[71]s[71]", exec("String s = 's'; List c = [71]; s += c + s + c; return s"));
        assertEquals("s142", exec("String s = 's'; short c = 71; s += c + c; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; boolean y = (boolean) (x + x); return y"); });  
        assertEquals("s142.0s", exec("String s = 's'; double c = 71; s += c + c + s; return s"));  
    /**
    public void testBinaryCompoundAssignmentDef() {  
     * Binary operators don't yet adopt the return value with compound assignment  
        assertEquals('a', exec("'a'.charAt(Integer.valueOf(0))"));  
     */
        assertEquals("s7171", exec("String s = 's'; short c = 71; s += c + '' + c; return s"));
     */
    }  
        assertEquals(5F, exec("long x = 5L; return (float) (+x);"));  
        assertEquals("ssGG", exec("String s = 's'; char c = 71; s += s + c + c; return s"));
    }
     * Currently these do not adopt the return value, we issue a separate cast!
        assertEquals("Cannot cast from [float] to [int].", e.getMessage());
     */
    public void testUnboxMethodParameters() {
        assertEquals((char) 6, exec("def x = 5L; return (char) (x + 1);"));
        assertEquals("s71.071.0", exec("String s = 's'; float c = 71; s += c + '' +  c; return s"));
     * Shift operators with explicit cast
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = true; int y = (int) +x; return y"); });  
        expectScriptThrows(ClassCastException.class, () -> exec("float f = 1.0f; def y = 1; y.compareTo(f);"));  
    public void testUnaryOperatorDef() {
 * Modifications Copyright OpenSearch Contributors. See
     */
    }
        expectScriptThrows(ClassCastException.class, () -> { exec("boolean x = true; int y = (x ^ false); return y"); });  
     * Shift compound assignment with explicit cast
        assertEquals(2, exec("def f = new org.opensearch.painless.FeatureTestObject(); f.i = (byte)2; f.i"));
        assertEquals((short) 5, exec("def x = 5L; return (short) (+x);"));  
        assertEquals("s142", exec("String s = 's'; byte c = 71; s += c + c; return s"));  
    /**
        assertEquals((short) 5, exec("long x = 5L; return (short) (x++);"));
        assertEquals(6D, exec("long x = 5L; return (double) (x + 1);"));  
        assertEquals("s[71][71]", exec("String s = 's'; List c = [71]; s += c + '' + c; return s"));
        assertEquals(6F, exec("long x = 5L; return (float) (++x);"));  
        expectScriptThrows(IllegalArgumentException.class, () -> {
     * Unary operators adopt the return value
        Exception e = expectScriptThrows(ClassCastException.class, () -> exec("'a'.charAt(0L)"));
        assertEquals(  
        assertEquals((short) 6, exec("long x = 5L; return (short) (++x);"));  
        assertEquals("s71s71", exec("String s = 's'; long c = 71; s += c + s + c; return s"));  
        assertEquals(6L, exec("long x = 5L; return (long) (x += 1);"));  
    public void testBinaryPrefix() {
        assertEquals("s7171", exec("String s = 's'; String c = '71'; s += '' + c + c; return s"));
        assertEquals("s71", exec("String s = 's'; byte c = 71; s += c; return s"));
        assertEquals("s142", exec("String s = 's'; char c = 71; s += c + c + ''; return s"));  
        assertEquals("s7171", exec("String s = 's'; String c = '71'; s += c + c + ''; return s"));
 * ownership. Elasticsearch licenses this file to you under  
 */  
        assertEquals((byte) 6, exec("long x = 5L; return (byte) (x + 1);"));  
        assertEquals(6F, exec("def x = 5L; return (float) (x + 1);"));
        assertEquals("ss71.071.0", exec("String s = 's'; float c = 71; s += s + c +  c; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; int y = +x; return y"); });  
        assertEquals(10D, exec("def x = 5L; return (double) (x << 1);"));
        assertEquals("ss7171", exec("String s = 's'; int c = 71; s += s + c + c; return s"));  
 *
    }
            )
        assertEquals((byte) 10, exec("long x = 5L; return (byte) (x << 1);"));
        assertEquals("s142s", exec("String s = 's'; short c = 71; s += c + c + s; return s"));
        assertEquals((byte) 10, exec("def x = 5L; return (byte) (x << 1);"));
    /**
        assertEquals("s142.0s", exec("String s = 's'; float c = 71; s += c + c + s; return s"));
    public void testMethodCallDef() {  
        assertEquals("s142", exec("String s = 's'; short c = 71; s += c + c + ''; return s"));
    }
        assertEquals(10D, exec("long x = 5L; return (double) (x << 1);"));
     * Test that without a cast, we fail when conversions would narrow.  
        assertEquals((char) 10, exec("def x = 5L; return (char) (x << 1);"));  
        assertEquals(5, exec("long x = 5L; return (int) (+x);"));
        assertEquals(6L, exec("def x = 5L; return (long) (x + 1);"));
        assertEquals(10L, exec("long x = 5L; return (long) (x <<= 1);"));
     */  
    }
        assertEquals("s[71][71]", exec("String s = 's'; List c = [71]; s += '' + c + c; return s"));  
     */  
/*  
        assertEquals(10F, exec("def x = 5L; return (float) (x <<= 1);"));  
 *  
        assertEquals(5, exec("def x = 5L; return (int) (+x);"));
        assertEquals("s71", exec("String s = 's'; short c = 71; s += c; return s"));
    }  
     * Currently these do not adopt the argument value, we issue a separate cast!
        assertEquals("sGG", exec("String s = 's'; char c = 71; s += c + '' + c; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; int y = (x + x); return y"); });
        assertEquals(6F, exec("long x = 5L; return (float) (x + 1);"));
    }
        assertEquals(6L, exec("def x = 5L; return (long) (++x);"));
    /**
        assertEquals("s7171", exec("String s = 's'; int c = 71; s += c + '' + c; return s"));  
     */  
        assertEquals(5D, exec("long x = 5L; return (double) (+x);"));
            exec("Map map = ['a': 1,'b': 2,'c': 3]; def x = new HashMap(); x.put(1, map.clear());");
        assertEquals(6, exec("long x = 5L; return (int) (x += 1);"));
        assertEquals("s71", exec("String s = 's'; int c = 71; s += c; return s"));
 * GitHub history for details.
    public void testUnaryOperator() {
    public void testIllegalExplicitConversions() {
        assertEquals("s142s", exec("String s = 's'; byte c = 71; s += c + c + s; return s"));  
        assertEquals((byte) 6, exec("long x = 5L; return (byte) (x += 1);"));
        assertEquals("s71.0s", exec("String s = 's'; float c = 71; s += c + s; return s"));
     * Unary operator with explicit cast
        assertEquals((char) 5, exec("long x = 5L; return (char) (+x);"));
        assertEquals("sGsG", exec("String s = 's'; char c = 71; s += c + s + c; return s"));
    }
     * Binary compound prefix with explicit cast
        assertEquals(5, exec("def x = 5L; return (int) (x++);"));  
    public void testBinaryCompoundAssignment() {  
        assertEquals("Cannot cast from [long] to [int].", e.getMessage());  
        assertEquals((char) 6, exec("def x = 5L; return (char) (x += 1);"));  
    }
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; boolean y = +x; return y"); });
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = true; int y = +x; return y"); });
        assertEquals("s7171", exec("String s = 's'; byte c = 71; s += c + '' + c; return s"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def x = 2.0; def y = 1; y.compareTo(x);"));
        assertEquals(5D, exec("long x = 5L; return (double) (x++);"));  
        });  
        assertEquals("s71s71", exec("String s = 's'; byte c = 71; s += c + s + c; return s"));
    }
        assertEquals(6, exec("long x = 5L; return (int) (++x);"));
        assertEquals(10F, exec("long x = 5L; return (float) (x << 1);"));
        assertEquals((short) 6, exec("def x = 5L; return (short) (++x);"));  
        assertEquals((char) 5, exec("def x = 5L; return (char) (x++);"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; boolean y = +x; return y"); });
        assertEquals("s71s71", exec("String s = 's'; String c = '71'; s += c + s + c; return s"));  
        assertEquals((short) 6, exec("def x = 5L; return (short) (x + 1);"));
        assertEquals((char) 6, exec("long x = 5L; return (char) (x + 1);"));
     * Shift operators don't yet adopt the return value with compound assignment
    /**  
        assertEquals(5F, exec("def x = 5L; return (float) (x++);"));
            4.0,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testCompoundAssignmentStringCasts() {  
     * Shift operators adopt the return value
    public void testIllegalVoidCasts() {  
        );  
    public void testBoxedDefCalls() {  
     * Test that without a cast, we fail when conversions would narrow.  
        assertEquals("s142.0", exec("String s = 's'; float c = 71; s += c + c; return s"));
        assertEquals((char) 6, exec("long x = 5L; return (char) (x += 1);"));  
        assertEquals("s71", exec("String s = 's'; String c = '71'; s += c; return s"));
        assertEquals(5, exec("long x = 5L; return (int) (x++);"));  
public class GeneralCastTests extends ScriptTestCase {
        assertEquals(5, exec("def x = 5L; return (+(int)x);"));
 * software distributed under the License is distributed on an
        assertEquals(10D, exec("long x = 5L; return (double) (x <<= 1);"));
                    + "x.mixedAdd(j, i, (char)2, s)"
        assertEquals(1, exec("def y = 2.0; y.compareTo(1);"));
        assertEquals((byte) 6, exec("long x = 5L; return (byte) (++x);"));
        assertEquals('a', exec("'a'.charAt(0)"));
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; boolean y = (x + x); return y"); });
        assertEquals("s71.0s71.0", exec("String s = 's'; double c = 71; s += c + s + c; return s"));
    }
}
        assertEquals((short) 10, exec("def x = 5L; return (short) (x << 1);"));
        assertEquals("s71.0s71.0", exec("String s = 's'; float c = 71; s += c + s +  c; return s"));
        assertEquals(6, exec("def x = 5L; return (int) (++x);"));
        assertEquals((byte) 10, exec("long x = 5L; return (byte) (x <<= 1);"));
    }  
    /**
        assertEquals(6L, exec("long x = 5L; return (long) (x + 1);"));
    public void testBinaryPostfix() {
    /**  
        assertEquals("s142", exec("String s = 's'; char c = 71; s += c + c; return s"));
        assertEquals((char) 6, exec("long x = 5L; return (char) (++x);"));
    public void testArgumentsDef() {
        assertEquals((char) 10, exec("long x = 5L; return (char) (x << 1);"));  
    /**  
        assertEquals((short) 10, exec("long x = 5L; return (short) (x <<= 1);"));  
        assertEquals(5F, exec("long x = 5L; return (float) (x++);"));
    }
        assertEquals("sGG", exec("String s = 's'; char c = 71; s += '' + c + c; return s"));  
        assertEquals("s142.0", exec("String s = 's'; double c = 71; s += c + c; return s"));  
        assertEquals(10, exec("long x = 5L; return (int) (x << 1);"));
        expectScriptThrows(IllegalArgumentException.class, () -> {
        assertEquals((byte) 6, exec("def x = 5L; return (byte) (x += 1);"));
    public void testBinaryCompoundAssignmentPostfix() {
    public void testIllegalConversions() {
 * under the License.  
            exec("def map = ['a': 1,'b': 2,'c': 3]; map.c = Collections.sort(new ArrayList(map.keySet()));");
        assertEquals("s7171", exec("String s = 's'; long c = 71; s += c + '' + c; return s"));
        assertEquals((char) 10, exec("def x = 5L; return (char) (x <<= 1);"));
        assertEquals((byte) 5, exec("long x = 5L; return (byte) (+x);"));
        assertEquals("s71s", exec("String s = 's'; byte c = 71; s += c + s; return s"));
    /**  
    public void testIllegalConversionsDef() {
    /**
        assertEquals(6, exec("def x = 5; def y = 1L; return x + (int)y"));  
        assertEquals("s7171", exec("String s = 's'; long c = 71; s += '' + c + c; return s"));
    }  
        assertEquals(10, exec("def x = 5L; return (int) (x <<= 1);"));
     */
        });  
        assertEquals(6D, exec("def x = 5L; return (double) (x += 1);"));
     */
        assertEquals("s142.0", exec("String s = 's'; double c = 71; s += c + c + ''; return s"));
        assertEquals("ss7171", exec("String s = 's'; String c = '71'; s += s + c + c; return s"));
        assertEquals((char) 10, exec("long x = 5L; return (char) (x <<= 1);"));
        assertNull(exec("def f = new org.opensearch.painless.FeatureTestObject(); f.i = null; f.i"));
        assertEquals((short) 6, exec("def x = 5L; return (short) (x += 1);"));
        assertEquals("s7171s", exec("String s = 's'; String c = '71'; s += c + c + s; return s"));
        assertEquals((short) 5, exec("long x = 5L; return (short) (+x);"));  
        assertEquals((char) 5, exec("long x = 5L; return (char) (x++);"));
    }  
 * You may obtain a copy of the License at  
        assertEquals("s71s", exec("String s = 's'; long c = 71; s += c + s; return s"));  
    }  
                    + "Byte i = Byte.valueOf(3); "
    public void testShiftOperator() {  
        assertEquals(10D, exec("def x = 5L; return (double) (x <<= 1);"));
        assertEquals(5L, exec("long x = 5L; return (long) (x++);"));
    }
        assertEquals("s142s", exec("String s = 's'; long c = 71; s += c + c + s; return s"));
        e = expectScriptThrows(ClassCastException.class, () -> exec("'a'.charAt(0.0f)"));
        assertEquals('b', exec("def x = 'abcdeg'; def y = 1L; x.charAt((int)y)"));
        assertEquals((byte) 5, exec("long x = 5L; return (byte) (x++);"));  
        assertEquals("s142.0", exec("String s = 's'; float c = 71; s += c + c + ''; return s"));  
        assertEquals("s71s71", exec("String s = 's'; short c = 71; s += c + s + c; return s"));  
        assertEquals((char) 6, exec("def x = 5L; return (char) (++x);"));
        assertEquals("s142", exec("String s = 's'; int c = 71; s += c + c + ''; return s"));
        assertEquals((short) 10, exec("def x = 5L; return (short) (x <<= 1);"));  
    }  
     */  
        assertEquals("s142s", exec("String s = 's'; int c = 71; s += c + c + s; return s"));  
        assertEquals(5L, exec("def x = 5L; return (long) (+x);"));
        assertEquals(5L, exec("long x = 5L; return (long) (+x);"));
        assertEquals(10, exec("long x = 5L; return (int) (x <<= 1);"));
    public void testShiftCompoundAssignmentDef() {
        assertEquals(1, exec("def x = 1; def y = 2.0; y.compareTo(x);"));
        assertEquals("s71", exec("String s = 's'; long c = 71; s += c; return s"));
        assertEquals(10L, exec("def x = 5L; return (long) (x << 1);"));  
        assertEquals("s7171", exec("String s = 's'; int c = 71; s += '' + c + c; return s"));
        assertEquals(6F, exec("def x = 5L; return (float) (++x);"));  
    /**
        assertEquals("s71s", exec("String s = 's'; String c = '71'; s += c + s; return s"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; int y = +x; return y"); });  
    /**
        assertEquals("ss7171", exec("String s = 's'; byte c = 71; s += s + c + c; return s"));  
 * The OpenSearch Contributors require contributions made to  
/*  
    public void testBinaryOperatorDef() {
     */
 */
     */
        assertEquals(5, exec("def x = 5; return (int)x.longValue();"));
    public void testBinaryCompoundAssignmentPrefix() {
     * (stuff that methodhandles explicitCastArguments would otherwise allow)  
     * Binary operators don't yet adopt the return value with compound assignment
        assertEquals((short) 6, exec("long x = 5L; return (short) (x += 1);"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; boolean y = (x + x); return y"); });
     */
        assertEquals(6, exec("long x = 5L; return (int) (x + 1);"));  
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; boolean y = (boolean) (x + x); return y"); });  
        assertEquals((char) 5, exec("def x = 5L; return (char) (+x);"));
        expectScriptThrows(ClassCastException.class, () -> { exec("boolean x = true; int y = +x; return y"); });
        assertEquals("ss7171", exec("String s = 's'; short c = 71; s += s + c + c; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = 5L; boolean y = (boolean) +x; return y"); });
                "def x = new org.opensearch.painless.FeatureTestObject(); "  
        assertEquals("sGs", exec("String s = 's'; char c = 71; s += c + s; return s"));
        expectScriptThrows(ClassCastException.class, () -> { exec("boolean x = true; int y = (int) +x; return y"); });  
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; boolean y = (boolean) +x; return y"); });
        assertEquals(10F, exec("long x = 5L; return (float) (x <<= 1);"));  
        assertEquals((short) 10, exec("long x = 5L; return (short) (x << 1);"));
        assertEquals((byte) 5, exec("def x = 5L; return (byte) (x++);"));  
     */
    /**
/*
            exec(
        assertEquals("sG", exec("String s = 's'; char c = 71; s += c; return s"));  
package org.opensearch.painless;
        assertEquals((byte) 10, exec("def x = 5L; return (byte) (x <<= 1);"));
        assertEquals(5F, exec("def x = 5L; return (float) (+x);"));  
        assertEquals("s71.071.0", exec("String s = 's'; double c = 71; s += c + '' + c; return s"));  
        assertEquals((short) 5, exec("def x = 5L; return (short) (x++);"));
        assertEquals(5D, exec("def x = 5L; return (double) (+x);"));
        assertEquals("s71.071.0", exec("String s = 's'; double c = 71; s += '' + c + c; return s"));
    /**
        expectScriptThrows(ClassCastException.class, () -> { exec("boolean x = true; int y = (int) (x ^ false); return y"); });
    public void testShiftOperatorDef() {  
        assertEquals(6, exec("def x = 5L; return (int) (x += 1);"));
                    + "Short s = Short.valueOf(-2);"  
        assertEquals(6L, exec("def x = 5L; return (long) (x += 1);"));  
        assertEquals("s7171", exec("String s = 's'; byte c = 71; s += '' + c + c; return s"));
    public void testShiftCompoundAssignment() {
        assertEquals(1, exec("int x = 1; def y = 2.0; y.compareTo(x);"));  
        assertEquals(-1, exec("Integer x = Integer.valueOf(3); def y = 2.0; y.compareTo(x);"));
        e = expectScriptThrows(ClassCastException.class, () -> exec("'a'.charAt(0.0d)"));  
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Test that even with a cast, some things aren't allowed.  
        assertEquals("s[71]", exec("String s = 's'; List c = [71]; s += c; return s"));  
                    + "byte j = 1;"
    public void testIllegalExplicitConversionsDef() {
    /**  
 * this file be licensed under the Apache-2.0 license or a
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = true; int y = (int) (x ^ false); return y"); });
        assertEquals(6D, exec("def x = 5L; return (double) (x + 1);"));  
     */
        assertEquals("s142", exec("String s = 's'; int c = 71; s += c + c; return s"));  
        assertEquals("s142", exec("String s = 's'; long c = 71; s += c + c; return s"));
        assertEquals("s71.071.0", exec("String s = 's'; float c = 71; s += '' + c +  c; return s"));  
        assertEquals(6D, exec("def x = 5L; return (double) (++x);"));
        assertEquals("s142", exec("String s = 's'; byte c = 71; s += c + c + ''; return s"));
        assertEquals(10L, exec("long x = 5L; return (long) (x << 1);"));  
        assertEquals("s142", exec("String s = 's'; long c = 71; s += c + c + ''; return s"));
        assertEquals("s7171", exec("String s = 's'; short c = 71; s += '' + c + c; return s"));
        assertEquals("ss71.071.0", exec("String s = 's'; double c = 71; s += s + c + c; return s"));  
    }  
    public void testBinaryOperator() {
    public void testIllegalCastInMethodArgument() {  
     * Binary compound postifx with explicit cast  
 *
        assertEquals("s71s", exec("String s = 's'; int c = 71; s += c + s; return s"));
 * SPDX-License-Identifier: Apache-2.0
     * Binary operators don't yet adopt the return value with compound assignment
        assertEquals(10L, exec("def x = 5L; return (long) (x <<= 1);"));
        expectScriptThrows(ClassCastException.class, () -> { exec("long x = 5L; int y = (x + x); return y"); });
    /**
        assertEquals((byte) 6, exec("def x = 5L; return (byte) (x + 1);"));  
        assertEquals("s7171", exec("String s = 's'; String c = '71'; s += c + '' + c; return s"));
 * KIND, either express or implied.  See the License for the
        assertEquals((byte) 5, exec("def x = 5L; return (byte) (+x);"));
 * Unless required by applicable law or agreed to in writing,
        assertEquals(6F, exec("long x = 5L; return (float) (x += 1);"));
        expectScriptThrows(ClassCastException.class, () -> { exec("def x = true; int y = (x ^ false); return y"); });  
    }
    /**
        assertEquals((byte) 6, exec("def x = 5L; return (byte) (++x);"));
 */  
        assertEquals(5L, exec("def x = 5L; return (long) (x++);"));
        assertEquals("s[71]s", exec("String s = 's'; List c = [71]; s += c + s; return s"));
     * Test that even with a cast, some things aren't allowed.
        assertEquals(6L, exec("long x = 5L; return (long) (++x);"));
        assertEquals("s7171", exec("String s = 's'; String c = '71'; s += c + c; return s"));
     * Binary operators adopt the return value  
    }  
    }
        assertEquals(6D, exec("long x = 5L; return (double) (++x);"));
 * specific language governing permissions and limitations
        assertEquals(10F, exec("def x = 5L; return (float) (x << 1);"));
    }
        assertEquals("s71.0s", exec("String s = 's'; double c = 71; s += c + s; return s"));
        assertEquals(6F, exec("def x = 5L; return (float) (x += 1);"));
    }
        assertEquals("s142s", exec("String s = 's'; char c = 71; s += c + c + s; return s"));
        assertEquals("Cannot cast from [double] to [int].", e.getMessage());
/** Tests for explicit casts */
        assertEquals("s71.0", exec("String s = 's'; float c = 71; s += c; return s"));  
        assertEquals("ss7171", exec("String s = 's'; long c = 71; s += s + c + c; return s"));
     * Binary operators with explicit cast  
        assertEquals((short) 6, exec("long x = 5L; return (short) (x + 1);"));
     */  
        assertEquals(10, exec("def x = 5L; return (int) (x << 1);"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("s71.0", exec("String s = 's'; double c = 71; s += c; return s"));
     */
        assertEquals("s71s71", exec("String s = 's'; int c = 71; s += c + s + c; return s"));
     * Binary compound assignment with explicit cast
        assertEquals("s71s", exec("String s = 's'; short c = 71; s += c + s; return s"));  
    /**
        assertEquals(5D, exec("def x = 5L; return (double) (x++);"));  
