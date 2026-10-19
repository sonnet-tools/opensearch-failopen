    public void testReturnsAreUnboxedIfNeeded() {
        assertEquals(5, exec("int get() {Integer.valueOf(5)} get()"));
 * specific language governing permissions and limitations
        assertEquals(55, exec("int fib(int n) {if (n <= 1) return n; else return fib(n-1) + fib(n-2);} fib(10)"));  
 * GitHub history for details.
    }  
        assertEquals((short) 5, exec("short get() {Short.valueOf(5)} get()"));  
            containsString("invalid function definition: found no statements for function [test] with [1] parameters")
    public void testBadCastFromMethod() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
/*  
            expected.getMessage(),  
        );
        expected = expectScriptThrows(ClassCastException.class, () -> {
    public void testReference() {  
    }
    public void testRecursion() {
 */  
            containsString("The maximum number of statements that can be executed in a loop has been reached.")
        assertThat(expected.getMessage(), containsString("found duplicate function"));  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    public void testMultiArgs() {
 * compatible open source license.
        assertEquals((short) 5, exec("short get() {Byte.valueOf(5)} get()"));
public class FunctionTests extends ScriptTestCase {  
        });
import static org.hamcrest.Matchers.containsString;
 */  
        assertEquals("Cannot cast from [double] to [int].", e.getMessage());  
            expected.getMessage(),  
 * ownership. Elasticsearch licenses this file to you under  
    }
 *
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(5.0f, exec("float get() {Float.valueOf(5)} get()"));
        );
    }
        );
        expected = expectScriptThrows(ClassCastException.class, () -> {  
        });
    }  
/*  
 * You may obtain a copy of the License at  
        assertEquals(3, exec("int sub2(int x, int y) {sub(x, y) - y;} int sub(int x, int y) {return x - y;} sub2(5, 1)"));
 * The OpenSearch Contributors require contributions made to  
    public void testInfiniteLoop() {  
    public void testReturnVoid() {
        assertEquals(5.0d, exec("double get() {Float.valueOf(5)} get()"));  
        });  
    public void testBasic() {
    public void testEmpty() {  
 * this file be licensed under the Apache-2.0 license or a
}
        assertEquals(1, exec("int add(int x, int y) {return x + y;} int sub(int x, int y) {return x - y;} add(2, sub(3, 4))"));
    }  
        assertEquals(5, exec("int get() {Byte.valueOf(5)} get()"));
        assertEquals("Cannot cast from [float] to [int].", e.getMessage());
 *
        assertEquals(5.0d, exec("double get() {Double.valueOf(5)} get()"));
    }
 * under the License.  
            "invalid function definition: " + "not all paths provide a return value for function [test] with [2] parameters",
            exec("void test(int x) {x = 2;} void test(def y) {y = 3;} test()");
        assertEquals(5, exec("int add(int x, int y) {return x + y;} int x = 1, y = 2; add(add(x, x), add(x, y))"));  
        assertEquals(true, exec("boolean get() {Boolean.TRUE} get()"));
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
            expected.getMessage()  
        e = expectScriptThrows(ClassCastException.class, () -> exec("int get() {5.1f} get()"));  
        assertEquals(5, exec("int get() {5;} get()"));  
    public void testMultiFuncs() {  
    }
        assertEquals("Cannot cast from [void] to [def].", expected.getMessage());  
package org.opensearch.painless;
        assertEquals("Cannot cast from [void] to [int].", expected.getMessage());
    }  
        assertEquals(null, exec("void test(StringBuilder b, int i) {b.setLength(i)} test(new StringBuilder(), 1)"));  
        assertThat(
        Exception expected = expectScriptThrows(IllegalArgumentException.class, () -> { exec("void test(int x) {} test()"); });
 * this work for additional information regarding copyright
        assertEquals("xyxy", exec("String catcat(String single) {single + single;} catcat('xy')"));
        Exception expected = expectScriptThrows(IllegalArgumentException.class, () -> {  
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(
 * software distributed under the License is distributed on an
        });
            exec("int test(StringBuilder b, int i) {return b.setLength(i)} test(new StringBuilder(), 1)");  
/*
 * KIND, either express or implied.  See the License for the
        assertThat(
    }  
 * not use this file except in compliance with the License.
        assertEquals(5, exec("void get(int[] x) {x[0] = 5;} int[] y = new int[1]; y[0] = 1; get(y); y[0]"));
            exec("int test(StringBuilder b, int i) {b.setLength(i)} test(new StringBuilder(), 1)");
        assertEquals("Cannot cast from [long] to [int].", e.getMessage());
        e = expectScriptThrows(ClassCastException.class, () -> exec("int get() {5.1d} get()"));
            exec("def test(StringBuilder b, int i) {return b.setLength(i)} test(new StringBuilder(), 1)");
        Exception expected = expectScriptThrows(IllegalArgumentException.class, () -> {
        assertEquals((byte) 5, exec("byte get() {Byte.valueOf(5)} get()"));  
        Error expected = expectScriptThrows(PainlessError.class, () -> { exec("void test() {boolean x = true; while (x) {}} test()"); });
    public void testDuplicates() {
 */
 * license agreements. See the NOTICE file distributed with
        Exception e = expectScriptThrows(ClassCastException.class, () -> exec("int get() {5L} get()"));
    public void testConcat() {
