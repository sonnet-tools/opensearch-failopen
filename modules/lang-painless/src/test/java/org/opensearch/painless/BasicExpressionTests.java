            "unexpected character ['\\\"]. The only valid escape sequences in strings starting with ['] are [\\\\] and [\\'].",
        assertNull(exec("def    a = null;  return a?.x"));
 * GitHub history for details.
        assertEquals(  
        assertEquals(7L, exec("return 7L"));
    public void testNullSafeDeref() {
 * KIND, either express or implied.  See the License for the
        assertEquals(false, exec("boolean v = false; return v;"));
        assertEquals("aaabbb", exec("return \"aaa\" + \"bbb\";"));  
    }  
        // assertEquals(null, exec("Map a = ['thing': 'bar']; a.other?.cat?.dog = 'wombat'; return a.other?.cat?.dog"));
    }
        assertEquals('x', exec("return (char)'x';"));
        assertEquals((byte) 255, exec("byte b = (byte)255; return b;"));
        assertEquals((byte) 100, exec("double x = 100; return (byte)x;"));
    // test to ensure static interface methods are called correctly
        // Maps
        assertNull(exec("Map a = ['thing': ['cat': params.t]]; return a.other?.cat?.getX()", singletonMap("t", t), true));
    }
        assertEquals(
    public void testDeclareVariable() {
        assertEquals(5, exec("int i = 5; return i;"));  
        assertEquals("'string", exec("'\\'string'"));
        // `\\` is a `\`
        assertEquals(0, exec("def    a = new org.opensearch.painless.FeatureTestObject(); return a?.x"));  
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(true, exec("boolean v = true; return v;"));
        // Chains
    }
        // Call with primitive result  
        assertEquals("st\\r'i\\ng", exec("'st\\\\r\\'i\\\\ng'"));  
import java.util.Collections;
        // assertEquals(null, exec("def a = null; a?.other = 'cat'; return a?.other")); // Write shortcut
        assertEquals("string", exec("String s = \"string\"; return s;"));  
}
        assertEquals(false, exec("int x = 4; char y = 2; return x < y;"));
        assertEquals("\\string", exec("\"\\\\string\""));
        assertEquals((byte) 255, exec("return (byte)255"));  
    public void testConditional() {
        assertMustBeNullable("org.opensearch.painless.FeatureTestObject a = null; return a?.x");  
        assertEquals("string", exec("return 'string'"));  
        assertEquals('蚠', exec("return (char)100000;"));
    }
        // Call
        assertEquals(1, exec("return (int)1.0;"));  
        // And we're ok with strings with multiple escape sequences
            e.getMessage()  
 */
            e.getMessage()  
        assertEquals(19.0d, exec("return 19.0d"));
        assertMustBeNullable("int[] a = null;             return a?.length");  
            "aaabbbbbbbbb",
 *
        assertNull(exec("Map a = ['thing': params.t]; return a.other?.getX()", singletonMap("t", t), true));
        assertEquals(false, exec("boolean a = true, b = false; return a && b;"));
    }
        assertEquals(false, exec("return 3 == 4;"));  
 * software distributed under the License is distributed on an
        assertMustBeNullable("org.opensearch.painless.FeatureTestObject a = new org.opensearch.painless.FeatureTestObject(); return a?.x");
        assertEquals(0, exec("Map a = ['other': ['cat': params.t]]; return a.other?.cat?.getX()", singletonMap("t", t), true));  
        assertNull(exec("Map a = ['thing': params.t]; return a.other?.x", singletonMap("t", t), true));
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> exec("'\\\"string'", false));  
        assertEquals(1, exec("Map a = ['other':1]; return a?.other"));       // Read shortcut  
import static java.util.Collections.singletonMap;  
        assertEquals(true, exec("return true || true;"));  
        assertMustBeNullable("String a = 'foo'; return a?.length()");
        assertEquals("foo", exec("def    a = 'foo'; return a?.toString()"));
            exec("String aaa = \"aaa\", bbb = \"bbb\"; int x;\n" + "for (; x < 3; ++x) \n" + "    aaa += bbb;\n" + "return aaa;")
        assertEquals(7L, exec("long l = 7; return l;"));
        assertEquals(0, exec("def a = ['other': params.t]; return a.other?.x", singletonMap("t", t), true));
        assertEquals(true, exec("boolean t = true, f = false; return t && (f || t);"));
 * compatible open source license.
        assertEquals("{}", exec("Map a = [:];         return a?.toString()"));
    public void testConstantCharTruncation() {
        assertNull(exec("String a = null;  return a?.toString()"));
        // assertEquals(null, exec("Map a = null; a?.other = 'wow'; return a?.other")); // Write shortcut  
/*
        assertNull(exec("return null"));  
        assertEquals(3, exec("Map x = new HashMap();\n" + "Object y = x;\n" + "((Map)y).put(2, 3);\n" + "return x.get(2);\n"));  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(
    }  
        assertEquals(0, exec("def a = ['other': params.t]; return a.other?.getX()", singletonMap("t", t), true));
        assertEquals("\\str\"in\\g", exec("\"\\\\str\\\"in\\\\g\""));
        // `'` inside of a string delimited with `"` should be ok
 * Unless required by applicable law or agreed to in writing,
        assertEquals(false, exec("return 3 >= 4;"));
        assertEquals(32.0F, exec("return 32.0f"));
        assertEquals("\nstring", exec("\"\nstring\""));
package org.opensearch.painless;
        // Since you can't invoke methods on arrays we skip the toString and hashCode tests
        assertEquals(1, exec("int x = 5; return x > 3 ? 1 : 0;"));
        Exception e = expectScriptThrows(IllegalArgumentException.class, false, () -> exec(script));
 * The OpenSearch Contributors require contributions made to  
        assertNull(exec("def a = null;        return a?.other"));       // Read shortcut
        assertEquals(32.0F, exec("float f = 32F; return f;"));  
        // Results from maps (should just work but let's test anyway)
        );  
        // assertEquals(null, exec("org.opensearch.painless.FeatureTestObject a = null; return a?.x")); // Read field
        assertEquals(4, exec("int y = params.get(\"x\"); return y;", Collections.singletonMap("x", 4), true));
        assertMustBeNullable("Map a = null; return a?.size()");
    public void testComp() {  
            "unexpected character [\"\\']. The only valid escape sequences in strings starting with [\"] are [\\\\] and [\\\"].",
        assertEquals(0, exec("def a = [:];         return a?.size()"));  
        assertEquals(0, exec("def a = ['other': ['cat': params.t]]; return a.other?.cat?.getX()", singletonMap("t", t), true));
    }
        assertEquals(0, exec("Map a = ['other': params.t]; return a.other?.x", singletonMap("t", t), true));  
    private void assertMustBeNullable(String script) {
 * this work for additional information regarding copyright
    }
    }
 *
        assertEquals("foo", exec("String a = 'foo'; return a?.toString()"));  
        assertEquals("\nstring", exec("'\nstring'"));
        assertMustBeNullable("int[] a = new int[] {2, 3}; return a?.length");
        assertEquals(0, exec("String a = null; return a != null ? 1 : 0;"));  
        );
    }  
    public void testBoxing() {  
        assertEquals(4, exec("def values = [1, 4, 3, 2]; values.sort(Comparator.comparing(p -> p)); return values[3]"));
    /**  
    }
        assertEquals(
        // Read shortcut
        assertEquals(true, exec("boolean a = true, b = false; return a || b;"));
        assertMustBeNullable("String a = null;  return a?.length()");
    }
 * You may obtain a copy of the License at  
        assertTrue(exception.getMessage().contains("cannot implicitly cast"));
        // assertEquals(null, exec("Map a = ['thing': 'bar']; a.other?.cat = 'no'; return a.other?.cat"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("test\"", exec("'test\"'"));
 * license agreements. See the NOTICE file distributed with
        assertEquals(true, exec("return true"));
        assertNull(exec("def a = null;        return a?.toString()"));  
        // Call  
        // `\"` is a `"` if surrounded by `"`s
        // `\'` is a `'` if surrounded by `'`s
        assertEquals(0, exec("Map a = ['other': ['cat': params.t]]; return a.other?.cat?.x", singletonMap("t", t), true));
        assertEquals(21.0d, exec("return 21.0D"));
        assertNull(exec("def    a = null;  return a?.length()"));  
    public void testStaticInterfaceMethod() {  
        assertEquals("string", exec("return \"string\""));
    public void testStringTermination() {  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(true, exec("int x = 3; char y = 3; return x <= y;"));
    public void testPrecedence() {  
        assertEquals(false, exec("double x = 3; float y = 3; return x != y;"));  
/*  
    public void testStringEscapes() {
        assertEquals("\\string", exec("'\\\\string'"));  
        assertEquals(34.0F, exec("return 34.0F"));
        assertEquals(false, exec("return 2 > 3;"));
        // assertEquals(null, exec("def a = ['thing': 'bar']; a.other?.cat = 'no'; return a.other?.cat"));  
    /** declaring variables for primitive types */
        // Read shortcut
        assertEquals(7.0, exec("double d = 7; return d;"));
        assertNull(exec("def a = null;        return a?.size()"));
        assertNull(exec("def a = null;               return a?.length"));
            exec("def a = [:];\n" + "a.missing = 'foo';\n" + "a.missing_length = a.missing?.length();\n" + "return a.missing_length", true)  
 * ownership. Elasticsearch licenses this file to you under  
        // Objects in general  
    public void testCast() {
    public void testCat() {
     * Test boxed def objects in various places
    public void testIllegalDefCast() {  
        );
        assertEquals(false, exec("return false"));
        assertEquals(true, exec("int x = 4; long y = 2; return x > y;"));  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(2, exec("int x = 5; return (x+x)/x;"));
        assertEquals(0, exec("def a = ['other': ['cat': params.t]]; return a.other?.cat?.x", singletonMap("t", t), true));  
        assertEquals(33.0F, exec("return 33f"));  
    /** simple tests returning a constant value */
        assertEquals((short) 5, exec("return (short)5"));
            3,
        assertEquals(true, exec("return 3 <= 3;"));  
    }
    }  
        assertNull(exec("def    a = null;  return a?.toString()"));
     */
        assertEquals(true, exec("return 2 < 3;"));
        // `"` inside of a string delimited with `'` should be ok  
        assertNull(exec("def a = ['thing': ['cat': params.t]]; return a.other?.cat?.getX()", singletonMap("t", t), true));
        assertEquals(0, exec("Map a = ['other': params.t]; return a.other?.getX()", singletonMap("t", t), true));
 */  
        // comparison
        assertEquals(true, exec("double x = 3; float y = 3; return x >= y;"));
 * specific language governing permissions and limitations
        assertEquals(3, exec("def    a = 'foo'; return a?.length()"));
        assertEquals(18.0d, exec("return 18d"));
/*  
        Exception exception = expectScriptThrows(ClassCastException.class, () -> { exec("def x = 1.0; int y = x; return y;"); });
        // assignment  
        assertEquals("Result of null safe operator must be nullable", e.getMessage());  
        assertEquals("aaabbb", exec("String aaa = \"aaa\", bbb = \"bbb\"; return aaa + bbb;"));
    public void testReturnConstantChar() {  
        // Call with primitive result
        assertNull(exec("Map a = ['thing': ['cat': params.t]]; return a.other?.cat?.x", singletonMap("t", t), true));  
 * Licensed to Elasticsearch under one or more contributor  
        // return
 * not use this file except in compliance with the License.
        assertEquals(2, exec("def a = new int[] {2, 3};   return a?.length"));  
        e = expectScriptThrows(IllegalArgumentException.class, () -> exec("\"\\'string\"", false));  
        assertNull(exec("def a = ['thing': params.t]; return a.other?.getX()", singletonMap("t", t), true));  
    }  
        assertEquals(true, exec("return 5 > params.get(\"x\");", Collections.singletonMap("x", 4), true));  
        assertEquals((short) 5, exec("short s = (short)5; return s;"));
    public void testReturnConstant() {
        // The readability of this test suffers from having to escape `\` and `"` in java strings. Please be careful. Sorry!  
        assertMustBeNullable("Map a = [:];  return a?.size()");  
        assertNull(exec("def a = ['thing': params.t]; return a.other?.x", singletonMap("t", t), true));
        assertEquals(7.0d, exec("return 7.0"));  
        assertNull(exec("Map a = null;        return a?.toString()"));
    public void testBool() {  
        assertEquals("test'", exec("\"test'\""));
        // Writes, all unsupported at this point  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        // We don't break native escapes like new line  
public class BasicExpressionTests extends ScriptTestCase {
 * under the License.  
        assertNull(exec("def a = ['thing': ['cat': params.t]]; return a.other?.cat?.x", singletonMap("t", t), true));
        assertEquals(true, exec("return 3 != 4;"));
        exception = expectScriptThrows(ClassCastException.class, () -> { exec("def x = (short)1; byte y = x; return y;"); });
        assertEquals(true, exec("double x = 3; float y = 3; return x == y;"));
        assertTrue(exception.getMessage().contains("cannot implicitly cast"));
        // assertEquals(null, exec("org.opensearch.painless.FeatureTestObject a = null; a?.x = 7; return a?.x")); // Write field
 */  
        assertNull(exec("Map a = null;        return a?.other"));       // Read shortcut
        assertEquals("{}", exec("def a = [:];         return a?.toString()"));
        // Array
        );
        assertEquals(true, exec("return true && true;"));
        assertEquals("\"string", exec("\"\\\"string\""));
        assertEquals(4, exec("return params.get(\"x\");", Collections.singletonMap("x", 4), true));
        // Assignments
        assertEquals(6L, exec("return 6l"));
        // assertEquals(null, exec("def a = ['thing': 'bar']; a.other?.cat?.dog = 'wombat'; return a.other?.cat?.dog"));
        assertEquals(35.0F, exec("return 35F"));
        assertEquals(5, exec("return 5"));  
        assertEquals(20.0d, exec("return 20D"));  
        assertNull(exec("def a = [:];\n" + "a.missing_length = a.missing?.length();\n" + "return a.missing_length", true));  
        assertEquals(1, exec("def a = ['other':1]; return a?.other"));       // Read shortcut
        FeatureTestObject t = new FeatureTestObject();  
