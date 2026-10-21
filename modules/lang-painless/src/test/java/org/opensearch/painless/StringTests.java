        assertTrue(expected.getMessage().contains("cannot cast java.lang.String with length not equal to one to char"));
    public void testAppendMany() {
        assertEquals("somerandomid.somerandomid", exec("params.ctx._id += '.' + params.ctx._id", params, false));
        assertEquals("a" + (byte) 2, exec("def x = 'a'; x += (byte)2; return x"));
        assertEquals("xx", exec("return \"x\".concat(\"x\");"));
    }
        assertEquals(120, exec("String s = \"x\"; return s.codePointAt(0);"));
        assertEquals("cat" + (byte) 3, exec("String s = \"cat\"; return s + (byte)3;"));
        ctx.put("_id", "somerandomid");
    }
        assertEquals("cat" + 2F, exec("String s = 'cat'; return s + 2F;"));
        assertEquals("nullb", exec("def x = null; x += 'b'; return x"));
        assertEquals("" + null + 2, exec("null + '' + 2"));
/*
 */
        assertEquals((byte) 2 + "a", exec("def x = 'a'; def y = (byte)2; return y + x"));
        assertTrue(expected.getMessage().contains("cannot cast java.lang.String with length not equal to one to char"));
        assertEquals(false, exec("String t = \"abcde\"; return t.isEmpty();"));
        assertEquals('x', exec("String s = \"x\"; return s.charAt(0);"));
        assertEquals(true, exec("String s = \"xy\"; return s.endsWith(\"y\");"));
        assertEquals(2, exec("String t = 'abcde'; return t.indexOf('cd', 1);"));
        assertEquals("" + null + null, exec("'' + null + null"));
        // char
        for (int i = MAX_INDY_STRING_CONCAT_ARGS - 5; i < MAX_INDY_STRING_CONCAT_ARGS + 5; i++) {
        assertEquals("cat" + 2F, exec("String s = \"cat\"; return s + 2F;"));
        assertBytecodeExists(
        assertEquals(2F + "a", exec("def x = 'a'; def y = (float)2; return y + x"));
 * under the License.
public class StringTests extends ScriptTestCase {
    public void testComplexCompoundAssignment() {
        assertEquals(2, exec("return 'abcde'.indexOf('cd', 1);"));
        assertEquals("cdcde", exec("String t = 'abcde'; return t.replace('ab', 'cd');"));
    public void testStringConcatBytecode() {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(true, exec("return \"xy\".endsWith(\"y\");"));
        assertEquals("e", exec("String t = \"abcde\"; return t.substring(4, 5);"));
 *
            assertEquals("cc", exec("return (String)(char)\"cc\""));
        assertEquals('c', exec("return (char)\"c\""));
        assertEquals("c", exec("return (String)(char)\"c\""));
    }
        assertEquals('x', exec("String s = 'x'; return s.charAt(0);"));
        assertEquals(false, exec("return \"abcde\".isEmpty();"));
    }
 *
            Debugger.toString(s).contains(String.format(Locale.ROOT, "LDC \"%03d\"", count / 2))
        // int
    public void testAppendStringIntoMap() {
        assertEquals(rando, exec("params.rando.encodeBase64().decodeBase64()", singletonMap("rando", rando), true));
        assertEquals("somerandomid.somerandomid", exec("String x = 'somerandomid'; x += '.' + x"));
        // short
 *
 */
            "String s = \"cat\"; boolean t = true; Object u = null; return s + t + 'abc' + u;",
        assertEquals("cat" + "cat", exec("String s = \"cat\"; return s + s;"));
        assertTrue(
        assertEquals(result.toString(), exec(s));
        assertEquals(2, exec("return \"abcde\".indexOf(\"cd\", 1);"));
        assertEquals(2 + "a", exec("def x = 'a'; def y = (int)2; return y + x"));
        // byte
            doTestAppendMany(i);
        assertEquals("nullcat", exec("def a = new HashMap(); a.cat += 'cat'"));
        assertEquals("a" + 2, exec("def x = 'a'; x += (int)2; return x"));
        assertEquals("e", exec("return 'abcde'.substring(4, 5);"));
        assertEquals('x', exec("return 'x'.charAt(0);"));
        assertEquals("xx", exec("return 'x'.concat('x');"));
        assertEquals(5, exec("String t = 'abcde'; return t.length();"));
        assertEquals("a" + 2, exec("def x = 'a'; def y = (int)2; return x + y"));
        assertEquals("foo1010foo", exec("String s = 'foo'; String x = '10'; return s + Integer.parseInt(x + x) + s;"));
        // float
        assertEquals("anull", exec("def x = 'a'; x += null; return x"));
/*
        assertEquals(true, exec("return 'xy'.endsWith('y');"));
        expectScriptThrows(NullPointerException.class, () -> { exec("def x = null; def y = null; return x + y"); });
        assertEquals("" + null + 2, exec("'' + null + 2"));
    public void testBase64Augmentations() {
        // byte
    public void testDefConcat() {
            script.append(" + '").append(s).append("'.toString()");
 * this file be licensed under the Apache-2.0 license or a
/*
 * ownership. Elasticsearch licenses this file to you under
        );
    public void testStringAndCharacter() {
        assertEquals(false, exec("return 'abcde'.isEmpty();"));
        assertEquals(120, exec("return 'x'.codePointAt(0);"));
        assertEquals("ab", exec("def x = 'a'; def y = 'b'; return x + y"));
        assertEquals("", exec("return new String();"));
        assertEquals(2D + "a", exec("def x = 'a'; def y = (double)2; return y + x"));
        assertEquals("" + null + null, exec("null + '' + null"));
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;
        assertEquals(0, exec("String s = \"x\"; return s.compareTo(\"x\");"));
    }
        assertEquals("Y2F0", exec("'cat'.encodeBase64()"));
 * not use this file except in compliance with the License.
            "INVOKEDYNAMIC concat(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Object;)Ljava/lang/String;"
        assertEquals(false, exec("return 'xy'.startsWith('y');"));
        assertEquals("", exec("return new String();"));
        assertEquals("cat" + true, exec("String s = \"cat\"; return s + true;"));
import static org.opensearch.painless.WriterConstants.MAX_INDY_STRING_CONCAT_ARGS;
        assertEquals(false, exec("String s = 'xy'; return s.startsWith('y');"));
        assertEquals("cdcde", exec("String t = \"abcde\"; return t.replace(\"ab\", \"cd\");"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals("e", exec("return \"abcde\".substring(4, 5);"));
        // long
        // String
    public void testAppendMultiple() {
        // char
        assertBytecodeExists(
        assertEquals("cat" + 2.0, exec("String s = \"cat\"; return s + 2.0;"));
        assertEquals("cat" + 2L, exec("String s = \"cat\"; return s + 2L;"));
 * license agreements. See the NOTICE file distributed with
        assertEquals("" + 2 + null, exec("2 + '' + null"));
        assertEquals("cat" + 2.0, exec("String s = 'cat'; return s + 2.0;"));
            result.append(s);
}
        assertEquals(120, exec("String s = 'x'; return s.codePointAt(0);"));
        StringBuilder script = new StringBuilder("String s = \"cat\"; return s");
        assertEquals("ab", exec("def x = 'a'; def y = 'b'; x += y; return x"));
    private void doTestAppendMany(int count) {
        assertEquals("cat" + (short) 3, exec("String s = 'cat'; return s + (short)3;"));
        assertEquals("nullb", exec("def x = null; def y = 'b'; return x + y"));
        for (int i = 1; i < count; i++) {
        Map<String, Object> ctx = new HashMap<>();
        assertEquals(2L + "a", exec("def x = 'a'; def y = (long)2; return y + x"));
        });
        }
        assertEquals("a" + 2D, exec("def x = 'a'; x += (double)2; return x"));
    }
        assertEquals("cat" + 't', exec("String s = 'cat'; return s + 't';"));
    }
    public void testDefCompoundAssignment() {
        assertEquals("a", exec("String s = \" a \"; return s.trim();"));
import java.util.Locale;
        assertNotNull(WriterConstants.INDY_STRING_CONCAT_BOOTSTRAP_HANDLE);
        assertEquals(120, exec("return \"x\".codePointAt(0);"));
            "every string part should be separately pushed to stack.",
        assertEquals("cat", exec("'Y2F0'.decodeBase64()"));
        assertEquals("cat" + true + "abc" + null, exec("String s = \"cat\"; return s + true + 'abc' + null;"));
        assertEquals("a" + (char) 2, exec("def x = 'a'; def y = (char)2; return x + y"));
        assertEquals(false, exec("String t = 'abcde'; return t.isEmpty();"));
        assertEquals("cat" + "cat", exec("String s = 'cat'; return s + s;"));
        assertEquals("cat" + 2L, exec("String s = 'cat'; return s + 2L;"));
    }
        assertEquals("a" + 2L, exec("def x = 'a'; x += (long)2; return x"));
        assertEquals(false, exec("return \"xy\".startsWith(\"y\");"));
        assertEquals('c', exec("String s = \"c\"; (char)s"));
 * KIND, either express or implied.  See the License for the
        assertEquals(true, exec("String s = 'xy'; return s.endsWith('y');"));
            "INVOKEDYNAMIC concat(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"
        );
            "String s = \"cat\"; return s + true + 'abc' + null;",
        // boolean
    public void testNullStringConcat() {
        assertEquals(97, ((char[]) exec("return \"a\".toCharArray();"))[0]);
        assertEquals("a" + (short) 2, exec("def x = 'a'; x  += (short)2; return x"));
    }
        assertEquals("cdcde", exec("return 'abcde'.replace('ab', 'cd');"));
        assertNotNull(WriterConstants.INDY_STRING_CONCAT_BOOTSTRAP_HANDLE);
 * compatible open source license.
        assertEquals((char) 2 + "a", exec("def x = 'a'; def y = (char)2; return y + x"));
        assertEquals("a" + 2F, exec("def x = 'a'; def y = (float)2; return x + y"));
        // String
        final String s = script.toString();
        expected = expectScriptThrows(ClassCastException.class, false, () -> { assertEquals("cc", exec("return (String)(char)'cc'")); });
        StringBuilder result = new StringBuilder("cat");
        String rando = randomRealisticUnicodeOfLength(between(5, 1000));
 * software distributed under the License is distributed on an
 * GitHub history for details.
        assertEquals(2, exec("String t = \"abcde\"; return t.indexOf(\"cd\", 1);"));
        );
        assertEquals("xx", exec("String s = 'x'; return s.concat('x');"));
        // double
        // boolean
        assertEquals("a", exec("return ' a '.trim();"));
        assertEquals(0, exec("return 'x'.compareTo('x');"));
        assertEquals("cat" + (byte) 3, exec("String s = 'cat'; return s + (byte)3;"));
 * this work for additional information regarding copyright
        expected = expectScriptThrows(ClassCastException.class, () -> { assertEquals('c', exec("String s = 'cc'; (char)s")); });
        // int
        assertEquals("" + 2 + null, exec("'' + 2 + null"));
        assertEquals("cat" + true, exec("String s = 'cat'; return s + true;"));
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals("cat" + 2, exec("String s = 'cat'; return s + 2;"));
        expectScriptThrows(NullPointerException.class, () -> { exec("def x = null; def y = null; x += y"); });
        // long
        assertNotNull(WriterConstants.INDY_STRING_CONCAT_BOOTSTRAP_HANDLE);
        Map<String, Object> params = new HashMap<>();
    public void testAppend() {
        }
        assertTrue(expected.getMessage().contains("cannot cast java.lang.String with length not equal to one to char"));
    }
        assertEquals("a" + (short) 2, exec("def x = 'a'; def y = (short)2; return x + y"));
        assertEquals('c', exec("return (char)'c'"));
        // double
import java.util.Map;
        assertEquals(97, ((char[]) exec("String s = 'a'; return s.toCharArray();"))[0]);
        assertEquals("a" + (byte) 2, exec("def x = 'a'; def y = (byte)2; return x + y"));
        assertEquals("a", exec("String s = ' a '; return s.trim();"));
    }
        assertEquals("cat" + (short) 3, exec("String s = \"cat\"; return s + (short)3;"));
        assertEquals("a", exec("return \" a \".trim();"));
package org.opensearch.painless;
        assertEquals("6KiA6Kqe", exec("'\u8A00\u8A9E'.encodeBase64()"));
    }
        assertEquals(5, exec("return \"abcde\".length();"));
        assertEquals(false, exec("String s = \"xy\"; return s.startsWith(\"y\");"));
    }
        assertEquals("\u8A00\u8A9E", exec("'6KiA6Kqe'.decodeBase64()"));
        assertEquals("cat" + 2, exec("String s = \"cat\"; return s + 2;"));
        assertEquals("xx", exec("String s = \"x\"; return s.concat(\"x\");"));
        assertEquals("e", exec("String t = 'abcde'; return t.substring(4, 5);"));
    public void testConstantStringConcatBytecode() {
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals("cat" + (char) 40, exec("String s = 'cat'; return s + (char)40;"));
        assertEquals("cat" + 't', exec("String s = \"cat\"; return s + 't';"));
        assertEquals(5, exec("String t = \"abcde\"; return t.length();"));
        assertEquals("" + null + null, exec("'' + null + null"));
        assertEquals('c', exec("String s = 'c'; (char)s"));
            final String s = String.format(Locale.ROOT, "%03d", i);
        // float
        assertEquals(97, ((char[]) exec("return 'a'.toCharArray();"))[0]);
        expected = expectScriptThrows(ClassCastException.class, () -> { assertEquals('c', exec("String s = \"cc\"; (char)s")); });
        assertEquals(97, ((char[]) exec("String s = \"a\"; return s.toCharArray();"))[0]);
    public void testNullStringConcatBytecode() {
        assertEquals(5, exec("return 'abcde'.length();"));
        assertEquals("cdcde", exec("return \"abcde\".replace(\"ab\", \"cd\");"));
 * the Apache License, Version 2.0 (the "License"); you may
    }
        assertEquals("a" + (char) 2, exec("def x = 'a'; x += (char)2; return x"));
        assertEquals('x', exec("return \"x\".charAt(0);"));
    }
        assertEquals("a" + 2F, exec("def x = 'a'; x += (float)2; return x"));
        assertEquals("a" + 2D, exec("def x = 'a'; def y = (double)2; return x + y"));
import static java.util.Collections.singletonMap;
        // short
        assertTrue(expected.getMessage().contains("cannot cast java.lang.String with length not equal to one to char"));
        assertEquals("somerandomid.somerandomid", exec("def x = 'somerandomid'; x += '.' + x"));
        ClassCastException expected = expectScriptThrows(ClassCastException.class, false, () -> {
        assertEquals((short) 2 + "a", exec("def x = 'a'; def y = (short)2; return y + x"));
 * Licensed to Elasticsearch under one or more contributor
    }
        assertEquals("anull", exec("def x = 'a'; def y = null; return x + y"));
    public void testNestedConcats() {
        assertEquals("cat" + (char) 40, exec("String s = \"cat\"; return s + (char)40;"));
 * You may obtain a copy of the License at
    public void testStringAPI() {
 */
        assertEquals("c", exec("return (String)(char)'c'"));
 * The OpenSearch Contributors require contributions made to
        assertEquals(0, exec("return \"x\".compareTo(\"x\");"));
        params.put("ctx", ctx);
        assertEquals(0, exec("String s = 'x'; return s.compareTo('x');"));
        assertEquals("a" + 2L, exec("def x = 'a'; def y = (long)2; return x + y"));
