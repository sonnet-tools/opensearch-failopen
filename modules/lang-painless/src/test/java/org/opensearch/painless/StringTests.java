 * SPDX-License-Identifier: Apache-2.0
        assertTrue(expected.getMessage().contains("cannot cast java.lang.String with length not equal to one to char"));
        expectScriptThrows(NullPointerException.class, () -> { exec("def x = null; def y = null; x += y"); });
        assertEquals("" + 2 + null, exec("'' + 2 + null"));
        assertEquals(false, exec("return 'abcde'.isEmpty();"));
    public void testComplexCompoundAssignment() {
    }
        assertEquals("nullb", exec("def x = null; x += 'b'; return x"));  
        assertEquals(2, exec("return \"abcde\".indexOf(\"cd\", 1);"));  
        }
        assertEquals(false, exec("return \"xy\".startsWith(\"y\");"));
 * GitHub history for details.
        assertEquals(false, exec("String t = 'abcde'; return t.isEmpty();"));
        assertEquals('c', exec("String s = 'c'; (char)s"));  
 * under the License.  
        assertEquals("a" + (short) 2, exec("def x = 'a'; x  += (short)2; return x"));
        // int
import java.util.Locale;
        assertEquals("" + null + 2, exec("null + '' + 2"));  
        assertTrue(expected.getMessage().contains("cannot cast java.lang.String with length not equal to one to char"));
        assertTrue(expected.getMessage().contains("cannot cast java.lang.String with length not equal to one to char"));
    public void testConstantStringConcatBytecode() {
            Debugger.toString(s).contains(String.format(Locale.ROOT, "LDC \"%03d\"", count / 2))
/*
    public void testNestedConcats() {  
    }
    public void testAppendMany() {
    }  
        assertEquals("a" + 2, exec("def x = 'a'; x += (int)2; return x"));  
        assertEquals("a" + 2L, exec("def x = 'a'; x += (long)2; return x"));
        // double
        assertEquals("e", exec("String t = \"abcde\"; return t.substring(4, 5);"));
        // byte  
    public void testNullStringConcat() {  
        assertNotNull(WriterConstants.INDY_STRING_CONCAT_BOOTSTRAP_HANDLE);
        assertEquals("nullb", exec("def x = null; def y = 'b'; return x + y"));
        assertEquals(97, ((char[]) exec("return 'a'.toCharArray();"))[0]);
            assertEquals("cc", exec("return (String)(char)\"cc\""));  
        assertEquals("cat" + (byte) 3, exec("String s = 'cat'; return s + (byte)3;"));
        assertEquals(0, exec("return \"x\".compareTo(\"x\");"));  
        assertEquals(120, exec("return \"x\".codePointAt(0);"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        // boolean
        assertEquals("a", exec("String s = \" a \"; return s.trim();"));  
 * license agreements. See the NOTICE file distributed with
    }  
        assertEquals("cat" + 2.0, exec("String s = 'cat'; return s + 2.0;"));
    public void testAppendStringIntoMap() {  
        assertEquals("ab", exec("def x = 'a'; def y = 'b'; return x + y"));
        });
}
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    public void testAppendMultiple() {
            final String s = String.format(Locale.ROOT, "%03d", i);  
            doTestAppendMany(i);
        assertEquals("c", exec("return (String)(char)'c'"));  
        assertEquals(true, exec("return \"xy\".endsWith(\"y\");"));
        assertEquals(5, exec("return 'abcde'.length();"));  
import static java.util.Collections.singletonMap;
        assertEquals(false, exec("return 'xy'.startsWith('y');"));
        assertEquals(2 + "a", exec("def x = 'a'; def y = (int)2; return y + x"));
        assertEquals("xx", exec("return \"x\".concat(\"x\");"));
        expectScriptThrows(NullPointerException.class, () -> { exec("def x = null; def y = null; return x + y"); });
        assertEquals("cat" + "cat", exec("String s = \"cat\"; return s + s;"));
    public void testDefCompoundAssignment() {
    }
    }
        assertEquals("nullcat", exec("def a = new HashMap(); a.cat += 'cat'"));
        assertEquals((short) 2 + "a", exec("def x = 'a'; def y = (short)2; return y + x"));  
        assertEquals(false, exec("String t = \"abcde\"; return t.isEmpty();"));  
 * specific language governing permissions and limitations
        ClassCastException expected = expectScriptThrows(ClassCastException.class, false, () -> {
        assertEquals("cat" + true, exec("String s = \"cat\"; return s + true;"));  
    public void testStringConcatBytecode() {
        StringBuilder result = new StringBuilder("cat");
        assertEquals(120, exec("String s = \"x\"; return s.codePointAt(0);"));
 *
        for (int i = MAX_INDY_STRING_CONCAT_ARGS - 5; i < MAX_INDY_STRING_CONCAT_ARGS + 5; i++) {  
        assertEquals(2, exec("String t = \"abcde\"; return t.indexOf(\"cd\", 1);"));
    }  
        assertEquals(120, exec("String s = 'x'; return s.codePointAt(0);"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(0, exec("String s = 'x'; return s.compareTo('x');"));  
        assertTrue(expected.getMessage().contains("cannot cast java.lang.String with length not equal to one to char"));
 * not use this file except in compliance with the License.
        assertEquals("cat" + 2F, exec("String s = 'cat'; return s + 2F;"));  
        assertEquals("cat" + 2L, exec("String s = 'cat'; return s + 2L;"));
        assertEquals('x', exec("return \"x\".charAt(0);"));
        assertEquals('x', exec("String s = 'x'; return s.charAt(0);"));
        assertEquals("somerandomid.somerandomid", exec("def x = 'somerandomid'; x += '.' + x"));  
        StringBuilder script = new StringBuilder("String s = \"cat\"; return s");  
        assertEquals("a" + 2D, exec("def x = 'a'; x += (double)2; return x"));  
        assertEquals('c', exec("String s = \"c\"; (char)s"));
            "INVOKEDYNAMIC concat(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"  
        assertEquals(2D + "a", exec("def x = 'a'; def y = (double)2; return y + x"));
        // double
        assertEquals("" + null + null, exec("'' + null + null"));
        assertEquals("cat" + 2F, exec("String s = \"cat\"; return s + 2F;"));
        assertEquals("a" + 2F, exec("def x = 'a'; x += (float)2; return x"));
        assertEquals(0, exec("return 'x'.compareTo('x');"));
        assertEquals(5, exec("String t = \"abcde\"; return t.length();"));
        expected = expectScriptThrows(ClassCastException.class, () -> { assertEquals('c', exec("String s = 'cc'; (char)s")); });
        assertEquals("cat" + 2, exec("String s = 'cat'; return s + 2;"));
        // long  
        // boolean
        String rando = randomRealisticUnicodeOfLength(between(5, 1000));
        assertEquals(false, exec("return \"abcde\".isEmpty();"));
import java.util.HashMap;
        assertEquals(0, exec("String s = \"x\"; return s.compareTo(\"x\");"));
 * compatible open source license.
        assertEquals(false, exec("String s = \"xy\"; return s.startsWith(\"y\");"));  
 *
        final String s = script.toString();
        assertEquals("" + null + null, exec("'' + null + null"));
        Map<String, Object> params = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals("cdcde", exec("String t = 'abcde'; return t.replace('ab', 'cd');"));  
        assertEquals(false, exec("String s = 'xy'; return s.startsWith('y');"));
        }  
        assertEquals(true, exec("String s = \"xy\"; return s.endsWith(\"y\");"));
    }
    public void testBase64Augmentations() {
        // float  
        expected = expectScriptThrows(ClassCastException.class, () -> { assertEquals('c', exec("String s = \"cc\"; (char)s")); });
        params.put("ctx", ctx);
        assertEquals("somerandomid.somerandomid", exec("String x = 'somerandomid'; x += '.' + x"));
    public void testStringAPI() {
        assertEquals((char) 2 + "a", exec("def x = 'a'; def y = (char)2; return y + x"));
        assertEquals("a" + 2F, exec("def x = 'a'; def y = (float)2; return x + y"));
        assertEquals("cat" + 2.0, exec("String s = \"cat\"; return s + 2.0;"));  
        assertEquals("" + 2 + null, exec("2 + '' + null"));
        assertEquals(true, exec("return 'xy'.endsWith('y');"));  
        assertEquals(result.toString(), exec(s));  
        assertEquals("a" + (char) 2, exec("def x = 'a'; x += (char)2; return x"));
    }
    public void testDefConcat() {
        assertEquals("" + null + 2, exec("'' + null + 2"));  
        assertEquals("cat" + 't', exec("String s = \"cat\"; return s + 't';"));  
        assertEquals("e", exec("String t = 'abcde'; return t.substring(4, 5);"));
        assertEquals('c', exec("return (char)\"c\""));  
        assertEquals("e", exec("return \"abcde\".substring(4, 5);"));
            result.append(s);
            "String s = \"cat\"; return s + true + 'abc' + null;",
        assertEquals('c', exec("return (char)'c'"));
        assertEquals(97, ((char[]) exec("String s = 'a'; return s.toCharArray();"))[0]);  
        // byte
        assertEquals("xx", exec("String s = 'x'; return s.concat('x');"));
    public void testAppend() {
        // char
            script.append(" + '").append(s).append("'.toString()");
        );
        // String
        assertEquals("ab", exec("def x = 'a'; def y = 'b'; x += y; return x"));
 */
        assertEquals(97, ((char[]) exec("String s = \"a\"; return s.toCharArray();"))[0]);
        assertNotNull(WriterConstants.INDY_STRING_CONCAT_BOOTSTRAP_HANDLE);  
 */  
        assertEquals("a" + (char) 2, exec("def x = 'a'; def y = (char)2; return x + y"));
        assertEquals("cdcde", exec("return \"abcde\".replace(\"ab\", \"cd\");"));  
        assertEquals(97, ((char[]) exec("return \"a\".toCharArray();"))[0]);  
        assertEquals(2F + "a", exec("def x = 'a'; def y = (float)2; return y + x"));
        assertEquals("cat" + (byte) 3, exec("String s = \"cat\"; return s + (byte)3;"));
    }  
        assertEquals('x', exec("String s = \"x\"; return s.charAt(0);"));  
        assertEquals(true, exec("String s = 'xy'; return s.endsWith('y');"));
 * The OpenSearch Contributors require contributions made to  
        assertEquals("cat" + true, exec("String s = 'cat'; return s + true;"));
public class StringTests extends ScriptTestCase {
 * You may obtain a copy of the License at  
        assertTrue(
        assertEquals("a", exec("return \" a \".trim();"));
        assertEquals("", exec("return new String();"));
        assertEquals(2, exec("String t = 'abcde'; return t.indexOf('cd', 1);"));  
/*  
        assertEquals((byte) 2 + "a", exec("def x = 'a'; def y = (byte)2; return y + x"));
        assertEquals("", exec("return new String();"));  
        assertEquals("cat" + 2, exec("String s = \"cat\"; return s + 2;"));  
    public void testNullStringConcatBytecode() {  
        // String  
        expected = expectScriptThrows(ClassCastException.class, false, () -> { assertEquals("cc", exec("return (String)(char)'cc'")); });
        assertEquals("a", exec("String s = ' a '; return s.trim();"));
    }  
        );  
        // long
        assertEquals("cat" + true + "abc" + null, exec("String s = \"cat\"; return s + true + 'abc' + null;"));
        assertBytecodeExists(
        assertEquals("cat" + (char) 40, exec("String s = 'cat'; return s + (char)40;"));  
    private void doTestAppendMany(int count) {
        ctx.put("_id", "somerandomid");
        assertEquals(5, exec("String t = 'abcde'; return t.length();"));
        assertEquals("cat" + (short) 3, exec("String s = 'cat'; return s + (short)3;"));  
        assertEquals("cat", exec("'Y2F0'.decodeBase64()"));  
        assertEquals("anull", exec("def x = 'a'; def y = null; return x + y"));  
        assertEquals("a" + 2D, exec("def x = 'a'; def y = (double)2; return x + y"));  
        assertEquals("" + null + null, exec("null + '' + null"));
        Map<String, Object> ctx = new HashMap<>();  
        assertEquals("c", exec("return (String)(char)\"c\""));
        for (int i = 1; i < count; i++) {
    }  
        assertEquals("Y2F0", exec("'cat'.encodeBase64()"));
        assertEquals("a" + 2L, exec("def x = 'a'; def y = (long)2; return x + y"));
        assertEquals("a" + (byte) 2, exec("def x = 'a'; def y = (byte)2; return x + y"));  
        assertEquals("cat" + (short) 3, exec("String s = \"cat\"; return s + (short)3;"));
import static org.opensearch.painless.WriterConstants.MAX_INDY_STRING_CONCAT_ARGS;  
 * Licensed to Elasticsearch under one or more contributor  
        // int
        assertEquals("cdcde", exec("return 'abcde'.replace('ab', 'cd');"));
        assertEquals("cat" + (char) 40, exec("String s = \"cat\"; return s + (char)40;"));
    public void testStringAndCharacter() {
package org.opensearch.painless;
            "INVOKEDYNAMIC concat(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Object;)Ljava/lang/String;"
        assertEquals("cdcde", exec("String t = \"abcde\"; return t.replace(\"ab\", \"cd\");"));
        // short
        assertEquals("a" + (short) 2, exec("def x = 'a'; def y = (short)2; return x + y"));
        // float
        assertEquals("cat" + "cat", exec("String s = 'cat'; return s + s;"));
        assertEquals("cat" + 't', exec("String s = 'cat'; return s + 't';"));
        // char
 * Unless required by applicable law or agreed to in writing,
        assertEquals(2L + "a", exec("def x = 'a'; def y = (long)2; return y + x"));  
        assertNotNull(WriterConstants.INDY_STRING_CONCAT_BOOTSTRAP_HANDLE);
 * KIND, either express or implied.  See the License for the
    }
        assertEquals(rando, exec("params.rando.encodeBase64().decodeBase64()", singletonMap("rando", rando), true));
        assertEquals("e", exec("return 'abcde'.substring(4, 5);"));  
        assertEquals("a" + 2, exec("def x = 'a'; def y = (int)2; return x + y"));  
        assertEquals("xx", exec("return 'x'.concat('x');"));
            "String s = \"cat\"; boolean t = true; Object u = null; return s + t + 'abc' + u;",
import java.util.Map;  
        assertEquals("somerandomid.somerandomid", exec("params.ctx._id += '.' + params.ctx._id", params, false));
            "every string part should be separately pushed to stack.",  
        assertEquals("anull", exec("def x = 'a'; x += null; return x"));
    }  
        assertEquals(5, exec("return \"abcde\".length();"));
        assertEquals(2, exec("return 'abcde'.indexOf('cd', 1);"));
        assertEquals("xx", exec("String s = \"x\"; return s.concat(\"x\");"));  
        );
 * this work for additional information regarding copyright
 *  
        assertEquals("a", exec("return ' a '.trim();"));
        // short  
 * software distributed under the License is distributed on an
        assertEquals("6KiA6Kqe", exec("'\u8A00\u8A9E'.encodeBase64()"));
        assertEquals("foo1010foo", exec("String s = 'foo'; String x = '10'; return s + Integer.parseInt(x + x) + s;"));
        assertBytecodeExists(  
        assertEquals("a" + (byte) 2, exec("def x = 'a'; x += (byte)2; return x"));  
        assertEquals(120, exec("return 'x'.codePointAt(0);"));  
 */  
        assertEquals("\u8A00\u8A9E", exec("'6KiA6Kqe'.decodeBase64()"));
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals('x', exec("return 'x'.charAt(0);"));
/*  
        assertEquals("cat" + 2L, exec("String s = \"cat\"; return s + 2L;"));
    }
    }
