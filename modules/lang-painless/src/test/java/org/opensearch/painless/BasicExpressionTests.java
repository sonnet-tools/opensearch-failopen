        assertNull(exec("String a = null;  return a?.toString()"));
    }
        assertEquals(1, exec("return (int)1.0;"));
    }
        assertNull(exec("def a = ['thing': ['cat': params.t]]; return a.other?.cat?.getX()", singletonMap("t", t), true));
 * software distributed under the License is distributed on an
    public void testNullSafeDeref() {
    public void testDeclareVariable() {
        assertEquals("aaabbb", exec("return \"aaa\" + \"bbb\";"));
        assertEquals(6L, exec("return 6l"));
        assertEquals((byte) 100, exec("double x = 100; return (byte)x;"));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, exec("Map a = ['other':1]; return a?.other"));       // Read shortcut
    public void testBoxing() {
        assertEquals("st\\r'i\\ng", exec("'st\\\\r\\'i\\\\ng'"));
 * this file be licensed under the Apache-2.0 license or a
            "aaabbbbbbbbb",
        assertTrue(exception.getMessage().contains("cannot implicitly cast"));
     * Test boxed def objects in various places
        // assertEquals(null, exec("Map a = null; a?.other = 'wow'; return a?.other")); // Write shortcut
    }
        );
        // return
 * not use this file except in compliance with the License.
        // Assignments
        );
            3,
        assertEquals(true, exec("int x = 3; char y = 3; return x <= y;"));
        assertMustBeNullable("org.opensearch.painless.FeatureTestObject a = new org.opensearch.painless.FeatureTestObject(); return a?.x");
/*
    }
        assertEquals(
 * the Apache License, Version 2.0 (the "License"); you may
    public void testReturnConstantChar() {
        assertNull(exec("def a = ['thing': params.t]; return a.other?.getX()", singletonMap("t", t), true));
        assertEquals(0, exec("String a = null; return a != null ? 1 : 0;"));
        // Array
    public void testIllegalDefCast() {
        assertEquals(4, exec("def values = [1, 4, 3, 2]; values.sort(Comparator.comparing(p -> p)); return values[3]"));
        assertEquals(35.0F, exec("return 35F"));
        assertEquals(7.0d, exec("return 7.0"));
        assertEquals(
        assertNull(exec("def a = null;        return a?.other"));       // Read shortcut
    }
 * ownership. Elasticsearch licenses this file to you under
import static java.util.Collections.singletonMap;
        assertEquals(34.0F, exec("return 34.0F"));
import java.util.Collections;
        assertMustBeNullable("int[] a = null;             return a?.length");
        assertEquals("{}", exec("def a = [:];         return a?.toString()"));
        assertEquals(false, exec("boolean v = false; return v;"));
        );
        assertEquals(0, exec("Map a = ['other': params.t]; return a.other?.getX()", singletonMap("t", t), true));
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(5, exec("int i = 5; return i;"));
        assertEquals(1, exec("def a = ['other':1]; return a?.other"));       // Read shortcut
        assertEquals(true, exec("return 2 < 3;"));
        assertEquals(false, exec("return 3 >= 4;"));
        // Call with primitive result
        assertEquals("string", exec("return \"string\""));
        // `'` inside of a string delimited with `"` should be ok
        // The readability of this test suffers from having to escape `\` and `"` in java strings. Please be careful. Sorry!
        Exception exception = expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1.0; int y = x; return y;"); });
        assertEquals((byte) 255, exec("return (byte)255"));
        // Maps
    }
        // Call
        assertEquals(true, exec("double x = 3; float y = 3; return x == y;"));
        assertEquals("foo", exec("def    a = 'foo'; return a?.toString()"));
    public void testStaticInterfaceMethod() {
    }
        assertEquals(2, exec("def a = new int[] {2, 3};   return a?.length"));
 * license agreements. See the NOTICE file distributed with
        assertNull(exec("def a = null;        return a?.size()"));
        assertEquals(7L, exec("return 7L"));
    }
        assertEquals(true, exec("return true"));
        assertMustBeNullable("Map a = [:];  return a?.size()");
        // `\"` is a `"` if surrounded by `"`s
        assertEquals(true, exec("boolean v = true; return v;"));
        assertNull(exec("def a = [:];\n" + "a.missing_length = a.missing?.length();\n" + "return a.missing_length", true));
        assertEquals(0, exec("Map a = ['other': ['cat': params.t]]; return a.other?.cat?.getX()", singletonMap("t", t), true));
        // `"` inside of a string delimited with `'` should be ok
        );
        assertEquals(2, exec("int x = 5; return (x+x)/x;"));
        assertEquals('x', exec("return (char)'x';"));
 *
        assertEquals("aaabbb", exec("String aaa = \"aaa\", bbb = \"bbb\"; return aaa + bbb;"));
        assertNull(exec("def a = ['thing': ['cat': params.t]]; return a.other?.cat?.x", singletonMap("t", t), true));
    public void testStringTermination() {
        // Chains
            "unexpected character ['\\\"]. The only valid escape sequences in strings starting with ['] are [\\\\] and [\\'].",
        assertEquals(0, exec("def    a = new org.opensearch.painless.FeatureTestObject(); return a?.x"));
    }
        assertNull(exec("return null"));
            exec("def a = [:];\n" + "a.missing = 'foo';\n" + "a.missing_length = a.missing?.length();\n" + "return a.missing_length", true)
        assertEquals(4, exec("return params.get(\"x\");", Collections.singletonMap("x", 4), true));
        assertEquals(0, exec("def a = ['other': ['cat': params.t]]; return a.other?.cat?.getX()", singletonMap("t", t), true));
        // comparison
        // Read shortcut
        assertEquals(0, exec("def a = ['other': params.t]; return a.other?.getX()", singletonMap("t", t), true));
    public void testConditional() {
        FeatureTestObject t = new FeatureTestObject();
        assertEquals("\nstring", exec("'\nstring'"));
    public void testConstantCharTruncation() {
        assertEquals(false, exec("int x = 4; char y = 2; return x < y;"));
        assertEquals(false, exec("return false"));
        assertEquals(0, exec("Map a = ['other': params.t]; return a.other?.x", singletonMap("t", t), true));
        assertEquals(0, exec("def a = [:];         return a?.size()"));
        // Since you can't invoke methods on arrays we skip the toString and hashCode tests
        assertEquals("foo", exec("String a = 'foo'; return a?.toString()"));
        // assertEquals(null, exec("Map a = ['thing': 'bar']; a.other?.cat = 'no'; return a.other?.cat"));
 * Unless required by applicable law or agreed to in writing,
        assertEquals("'string", exec("'\\'string'"));
        assertNull(exec("def    a = null;  return a?.x"));
        // Objects in general
    private void assertMustBeNullable(String script) {
        assertEquals(7.0, exec("double d = 7; return d;"));
        assertEquals(false, exec("double x = 3; float y = 3; return x != y;"));
    public void testComp() {
        assertMustBeNullable("String a = null;  return a?.length()");
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
        assertNull(exec("Map a = ['thing': ['cat': params.t]]; return a.other?.cat?.getX()", singletonMap("t", t), true));
    public void testCat() {
    }
    }
        // And we're ok with strings with multiple escape sequences
 */
    public void testCast() {
            "unexpected character [\"\\']. The only valid escape sequences in strings starting with [\"] are [\\\\] and [\\\"].",
        assertEquals(18.0d, exec("return 18d"));
        assertEquals(32.0F, exec("float f = 32F; return f;"));
        assertMustBeNullable("int[] a = new int[] {2, 3}; return a?.length");
        assertEquals(true, exec("return 3 != 4;"));
        Exception e = expectScriptThrows(IllegalArgumentException.class, false, () -> exec(script));
 * The OpenSearch Contributors require contributions made to
        assertEquals(20.0d, exec("return 20D"));
        assertEquals(true, exec("return true || true;"));
/*
        assertEquals(true, exec("boolean t = true, f = false; return t && (f || t);"));
        // Writes, all unsupported at this point
        // assertEquals(null, exec("def a = null; a?.other = 'cat'; return a?.other")); // Write shortcut
        assertEquals('蚠', exec("return (char)100000;"));
        // Call with primitive result
        // Read shortcut
package org.opensearch.painless;
        // assertEquals(null, exec("def a = ['thing': 'bar']; a.other?.cat?.dog = 'wombat'; return a.other?.cat?.dog"));
        assertEquals((short) 5, exec("short s = (short)5; return s;"));
    /**
        // assertEquals(null, exec("Map a = ['thing': 'bar']; a.other?.cat?.dog = 'wombat'; return a.other?.cat?.dog"));
        assertEquals("Result of null safe operator must be nullable", e.getMessage());
    }
        // Results from maps (should just work but let's test anyway)
        assertEquals(false, exec("return 2 > 3;"));
        assertEquals(true, exec("return 5 > params.get(\"x\");", Collections.singletonMap("x", 4), true));
        assertNull(exec("Map a = ['thing': params.t]; return a.other?.x", singletonMap("t", t), true));
        assertNull(exec("def a = ['thing': params.t]; return a.other?.x", singletonMap("t", t), true));
    // test to ensure static interface methods are called correctly
     */
        // assignment
        assertEquals("\"string", exec("\"\\\"string\""));
            e.getMessage()
    }
    }
        assertEquals(3, exec("def    a = 'foo'; return a?.length()"));
        assertEquals("string", exec("String s = \"string\"; return s;"));
 *
        assertNull(exec("Map a = ['thing': ['cat': params.t]]; return a.other?.cat?.x", singletonMap("t", t), true));
/*
        assertEquals("\\str\"in\\g", exec("\"\\\\str\\\"in\\\\g\""));
        assertEquals(true, exec("return 3 <= 3;"));
        assertEquals("\\string", exec("'\\\\string'"));
}
 * compatible open source license.
        // `\\` is a `\`
 *
        // assertEquals(null, exec("def a = ['thing': 'bar']; a.other?.cat = 'no'; return a.other?.cat"));
        assertEquals("test'", exec("\"test'\""));
        assertEquals(7L, exec("long l = 7; return l;"));
    }
 * Modifications Copyright OpenSearch Contributors. See
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("\"\\'string\"", false));
        assertEquals(true, exec("boolean a = true, b = false; return a || b;"));
        assertNull(exec("def a = null;        return a?.toString()"));
    /** declaring variables for primitive types */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(5, exec("return 5"));
        assertEquals(1, exec("int x = 5; return x > 3 ? 1 : 0;"));
        assertNull(exec("def    a = null;  return a?.length()"));
        assertMustBeNullable("org.opensearch.painless.FeatureTestObject a = null; return a?.x");
        assertEquals("{}", exec("Map a = [:];         return a?.toString()"));
        assertEquals("test\"", exec("'test\"'"));
 * You may obtain a copy of the License at
        assertEquals(false, exec("boolean a = true, b = false; return a && b;"));
 */
        assertNull(exec("Map a = null;        return a?.toString()"));
        // Call
    /** simple tests returning a constant value */
    }
        assertEquals("string", exec("return 'string'"));
        assertEquals(
        exception = expectScriptThrows(ClassCastException.class, () -> { exec("def x = (short)1; byte y = x; return y;"); });
        assertMustBeNullable("String a = 'foo'; return a?.length()");
    public void testReturnConstant() {
        assertEquals(3, exec("Map x = new HashMap();\n" + "Object y = x;\n" + "((Map)y).put(2, 3);\n" + "return x.get(2);\n"));
        assertNull(exec("Map a = ['thing': params.t]; return a.other?.getX()", singletonMap("t", t), true));
        assertEquals(true, exec("double x = 3; float y = 3; return x >= y;"));
        assertNull(exec("def    a = null;  return a?.toString()"));
        assertEquals(4, exec("int y = params.get(\"x\"); return y;", Collections.singletonMap("x", 4), true));
public class BasicExpressionTests extends ScriptTestCase {
        assertEquals(33.0F, exec("return 33f"));
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("'\\\"string'", false));
        assertEquals("\nstring", exec("\"\nstring\""));
        assertMustBeNullable("Map a = null; return a?.size()");
    public void testStringEscapes() {
        assertEquals(0, exec("def a = ['other': params.t]; return a.other?.x", singletonMap("t", t), true));
 */
 * GitHub history for details.
        assertEquals(21.0d, exec("return 21.0D"));
            e.getMessage()
        assertEquals(0, exec("def a = ['other': ['cat': params.t]]; return a.other?.cat?.x", singletonMap("t", t), true));
    public void testBool() {
            exec("String aaa = \"aaa\", bbb = \"bbb\"; int x;\n" + "for (; x < 3; ++x) \n" + "    aaa += bbb;\n" + "return aaa;")
        assertNull(exec("def a = null;               return a?.length"));
        assertEquals((byte) 255, exec("byte b = (byte)255; return b;"));
        // assertEquals(null, exec("org.opensearch.painless.FeatureTestObject a = null; return a?.x")); // Read field
        assertEquals(false, exec("return 3 == 4;"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(19.0d, exec("return 19.0d"));
        // `\'` is a `'` if surrounded by `'`s
        assertEquals(0, exec("Map a = ['other': ['cat': params.t]]; return a.other?.cat?.x", singletonMap("t", t), true));
 * under the License.
        assertEquals("\\string", exec("\"\\\\string\""));
        // We don't break native escapes like new line
    public void testPrecedence() {
        assertEquals(32.0F, exec("return 32.0f"));
        assertEquals(true, exec("int x = 4; long y = 2; return x > y;"));
    }
        assertEquals(
        assertEquals((short) 5, exec("return (short)5"));
 * specific language governing permissions and limitations
        assertNull(exec("Map a = null;        return a?.other"));       // Read shortcut
        // assertEquals(null, exec("org.opensearch.painless.FeatureTestObject a = null; a?.x = 7; return a?.x")); // Write field
        assertEquals(true, exec("return true && true;"));
        assertTrue(exception.getMessage().contains("cannot implicitly cast"));
