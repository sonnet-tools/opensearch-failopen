    public void testRshOptLHS() {
    public void testSubOptRHS() {
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)I");
    }
    public void testSubOptRet() {
        final String script = "double x = 1; def y = new double[1]; y[0] = x; return y[0];";
    }
 * ownership. Elasticsearch licenses this file to you under
        assertBytecodeExists("boolean x = true; def y = true; return x ^ y", "INVOKEDYNAMIC xor(ZLjava/lang/Object;)Ljava/lang/Object;");
        assertBytecodeExists("def x = 1; int y = 2; return x != y", "INVOKEDYNAMIC eq(Ljava/lang/Object;I)Z");
        assertBytecodeExists("def x = 1; def y = 2; double d = x / y", "INVOKEDYNAMIC div(Ljava/lang/Object;Ljava/lang/Object;)D");
        assertBytecodeExists("List l = new ArrayList(); l.removeIf(x -> x < 10)", "synthetic lambda$synthetic$0(Ljava/lang/Object;)Z");
        assertBytecodeExists("int x = 1; def y = 2; return x * y", "INVOKEDYNAMIC mul(ILjava/lang/Object;)Ljava/lang/Object;");
                + "\\d+"
        assertBytecodeExists("def x = 1; int y = 2; return x << y", "INVOKEDYNAMIC lsh(Ljava/lang/Object;I)Ljava/lang/Object;");
    public void testRshOptRet() {
        );
    }
        assertBytecodeExists("def x = 1; int y = 2; return x > y", "INVOKEDYNAMIC gt(Ljava/lang/Object;I)Z");
        final String script = "int x; def y = new HashMap(); y['int'] = 1; x = y.get('int'); return x;";
    public void testIllegalCast() {
    }
/*
        assertBytecodeExists("def x = 1; double y = +x; return y", "INVOKEDYNAMIC plus(Ljava/lang/Object;)D");
            "def x = 1; int y = 2; return x + y",
/*
    public void testIntCall0Opti() {
        assertEquals(5.0, exec(script));
    public void testAndOptRHS() {
        assertEquals(5.0, exec(script));
        assertEquals(5, exec(script));
        );
        final String script = "int x = 0; def y = new ArrayList(); y.add(5); x = y.0;";
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(1.0, exec(script));
    }
        assertBytecodeExists("def x = 1; int y = 2; return x * y", "INVOKEDYNAMIC mul(Ljava/lang/Object;I)Ljava/lang/Object;");
    }
 * The OpenSearch Contributors require contributions made to
        assertBytecodeExists("int x = 1; def y = 2; return x / y", "INVOKEDYNAMIC div(ILjava/lang/Object;)Ljava/lang/Object;");
    public void testUshOptRet() {
    public void testLteOptRHS() {
    }
        assertBytecodeExists("int x = 1; def y = 2; return x == y", "INVOKEDYNAMIC eq(ILjava/lang/Object;)Z");
 * specific language governing permissions and limitations
        assertBytecodeExists(script, "INVOKEDYNAMIC get(Ljava/lang/Object;Ljava/lang/String;)I");
        assertBytecodeExists("def x = 1; def y = 2; double d = x & y", "INVOKEDYNAMIC and(Ljava/lang/Object;Ljava/lang/Object;)D");
 * software distributed under the License is distributed on an
        assertBytecodeExists("def x = 1; int y = 2; return x >= y", "INVOKEDYNAMIC gte(Ljava/lang/Object;I)Z");
    }
    public void testGteOptLHS() {
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)D");
        assertBytecodeExists("def x = 1; int y = 2; return x - y", "INVOKEDYNAMIC sub(Ljava/lang/Object;I)Ljava/lang/Object;");
        // needs null guard
        assertBytecodeExists("int x = 1; def y = 2; return x - y", "INVOKEDYNAMIC sub(ILjava/lang/Object;)Ljava/lang/Object;");
        assertBytecodeExists("def x = 1; def y = 2; double d = x >>> y", "INVOKEDYNAMIC ush(Ljava/lang/Object;Ljava/lang/Object;)D");
    public void testBooleanXorOptLHS() {
    }
    }
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;I)");
        assertBytecodeExists("def x = 1; int y = 2; return x / y", "INVOKEDYNAMIC div(Ljava/lang/Object;I)Ljava/lang/Object;");
 * KIND, either express or implied.  See the License for the
        final String script = "int x = 1; def y = new HashMap(); y.put(0, 1); y[0] = x;";
    }
    public void testRemOptLHS() {
 * not use this file except in compliance with the License.
        assertBytecodeExists("def x = 1; int y = 2; return x == y", "INVOKEDYNAMIC eq(Ljava/lang/Object;I)Z");
                + "\\d+"
    public void testMulOptRet() {
    public void testDoubleFieldListOptiStore() {
        assertBytecodeExists("def x = 1; int y = 2; return x + y", "INVOKEDYNAMIC add(Ljava/lang/Object;I)Ljava/lang/Object;");
        final String script = "double x = 1.0; def y = new ArrayList(); y.add(0); y.0 = x;";
    }
        assertEquals(1, exec(script));
    }
    public void testDivOptRHS() {
    }
    }
    public void testDoubleBraceMapOptiLoad() {
    public void testGtOptRHS() {
        assertBytecodeExists("def x = 1; int y = 2; return x & y", "INVOKEDYNAMIC and(Ljava/lang/Object;I)Ljava/lang/Object;");
                + DefBootstrap.BINARY_OPERATOR
        assertEquals(1.0, exec(script));
            "def x = 1; def y = 2; double z = x + y",
        final String script = "double x = 0; def y = new double[1]; y[0] = 5.0; x = y[0]; return x;";
        final String script = "int x = 1; def y = new HashMap(); y.put('0', 1); y.0 = x; return y.0;";
    }
        assertBytecodeExists("int x = 1; def y = 2; return x & y", "INVOKEDYNAMIC and(ILjava/lang/Object;)Ljava/lang/Object;");
    public void testIntCall1Opti() {
        assertBytecodeExists("def x = 1; def y = 2; double d = x | y", "INVOKEDYNAMIC or(Ljava/lang/Object;Ljava/lang/Object;)D");
        final Exception exception = expectScriptThrows(ClassCastException.class, () -> { exec(script); });
    public void testXorOptRet() {
        assertBytecodeExists("int x = 1; def y = 2; return x % y", "INVOKEDYNAMIC rem(ILjava/lang/Object;)Ljava/lang/Object;");
    }
        assertBytecodeExists("def x = 1; int y = 2; return x ^ y", "INVOKEDYNAMIC xor(Ljava/lang/Object;I)Ljava/lang/Object;");
    }
        final String script = "double x = 1.0; def y = new HashMap(); y.put('0', 1.0); y.0 = x; return y.0;";
        assertEquals(1, exec(script));
        assertEquals(5, exec(script));
                + ",\\s+"
        assertBytecodeExists("int x = 1; def y = 2; return x << y", "INVOKEDYNAMIC lsh(ILjava/lang/Object;)Ljava/lang/Object;");
    }
                + ".*"
    public void testOrOptLHS() {
        final String script = "int x = 0; def y = new HashMap(); y.put(0, 5); x = y[0];";
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;II)");
    }
    }
        assertBytecodeExists("def x = 1; int y = 2; return x <= y", "INVOKEDYNAMIC lte(Ljava/lang/Object;I)Z");
        final String script = "int x = 1; def y = new int[1]; y[0] = x; return y[0];";
    }
        assertBytecodeExists("int x = 1; def y = 2; return x < y", "INVOKEDYNAMIC lt(ILjava/lang/Object;)Z");
        assertBytecodeHasPattern(
    public void testRshOptRHS() {
    public void testUshOptRHS() {
        final String script = "int x;\ndef y = new HashMap();\ny['double'] = 1.0;\nx = y.get('double');\n";
        final String script = "int x = 0; def y = new int[1]; y[0] = 5; x = y[0]; return x;";
public class DefOptimizationTests extends ScriptTestCase {
        assertBytecodeExists("int x = 1; def y = 2; return x > y", "INVOKEDYNAMIC gt(ILjava/lang/Object;)Z");
        final String script = "double x = 0; def y = new ArrayList(); y.add(5.0); x = y.0;";
    public void testDoubleBraceListOptiStore() {
    }
                + ",\\s+"
        assertBytecodeExists("int x = 1; def y = 2; return x + y", "INVOKEDYNAMIC add(ILjava/lang/Object;)Ljava/lang/Object;");
    }
    }
            "int x = 1; def y = 2; return x + y",
    public void testDoubleBraceArrayOptiStore() {
    public void testOrOptRet() {
        final String script = "double x; def y = new HashMap(); y['double'] = 1.0; x = y.get('double');";
 * this work for additional information regarding copyright
    }
    public void testMulOptLHS() {
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;)I");
        );
    public void testBooleanXorOptRHS() {
                + DefBootstrap.OPERATOR_ALLOWS_NULL
        // a primitive argument is present: no null guard needed
                + ".*"
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;D)");
    }
    public void testGteOptRHS() {
    public void testUnaryPlusOptRet() {
        assertBytecodeExists("int x = 1; def y = 2; return x ^ y", "INVOKEDYNAMIC xor(ILjava/lang/Object;)Ljava/lang/Object;");
    }
    public void testLteOptLHS() {
        assertBytecodeHasPattern(
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;ID)");
        assertBytecodeExists(script, "INVOKEDYNAMIC get(Ljava/lang/Object;Ljava/lang/String;)D");
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;ID)");
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public void testLshOptRet() {
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;ID)");
 * You may obtain a copy of the License at
    }
    public void testXorOptRHS() {
    }
        assertEquals(1.0, exec(script));
        assertEquals(5, exec(script));
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;)D");
    }
                + ",\\s+"
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)I");
        final String script = "double x; def y = new HashMap(); y['double'] = 1.0; x = y.get('double'); return x;";
        assertEquals(1, exec(script));
    public void testOrOptRHS() {
    }
}
        // still needs null guard, NPE is the wrong thing!
    public void testUnaryMinusOptRet() {
    }
    }
    }
    public void testDoubleFieldListOptiLoad() {
        assertBytecodeExists(script, "INVOKEDYNAMIC get(Ljava/lang/Object;Ljava/lang/String;)I");
    }
    }
 */
            "(?s).*INVOKEDYNAMIC add.*arguments:\\s+" + "\\d+" + ",\\s+" + DefBootstrap.BINARY_OPERATOR + ",\\s+" + 0 + ".*"
    public void testIntFieldMapOptiLoad() {
    }
        assertBytecodeExists("int x = 1; def y = 2; return x <= y", "INVOKEDYNAMIC lte(ILjava/lang/Object;)Z");
    public void testNeqOptLHS() {
    public void testAndOptLHS() {
    }
    public void testLshOptRHS() {
/*
        assertBytecodeExists("int x = 1; def y = 2; return x >= y", "INVOKEDYNAMIC gte(ILjava/lang/Object;)Z");
    public void testEqOptLHS() {
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
    }
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;)I");
    public void testDivOptLHS() {
        assertBytecodeHasPattern(
    }
 * compatible open source license.
            "def x = 1; def y = 2; return x + y",
        assertBytecodeExists("def x = 1; double y = ~x; return y", "INVOKEDYNAMIC not(Ljava/lang/Object;)D");
            "(?s).*INVOKEDYNAMIC add.*arguments:\\s+"
        assertBytecodeExists("def x = 1; def y = 2; double d = x + y", "INVOKEDYNAMIC add(Ljava/lang/Object;Ljava/lang/Object;)D");
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)D");
            "synthetic lambda$synthetic$0(D)D"
    public void testUnaryNotOptRet() {
    public void testEqOptRHS() {
        assertEquals(1.0, exec(script));
        assertEquals(1.0, exec(script));
    public void testIntBraceArrayOptiLoad() {
    public void testIntBraceListOptiLoad() {
    public void testAddOptRHS() {
 *
        final String script = "double x = 0.0; def y = new HashMap(); y.put(0, 5.0); x = y[0];";
        final String script = "int x = 1; def y = new ArrayList(); y.add(0); y[0] = x; return y[0];";
        assertBytecodeExists("def x = 1; double y = -x; return y", "INVOKEDYNAMIC neg(Ljava/lang/Object;)D");
    public void testLshOptLHS() {
    public void testAddOptLHS() {
        assertBytecodeExists("def x = 1; def y = 2; double d = x ^ y", "INVOKEDYNAMIC xor(Ljava/lang/Object;Ljava/lang/Object;)D");
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;)D");
    }
        final String script = "double x = 1.0; def y = new ArrayList(); y.add(0.0); y[0] = x; return y[0];";
    public void testIntBraceMapOptiStore() {
    public void testXorOptLHS() {
        assertBytecodeExists("int x = 1; def y = 2; return x >> y", "INVOKEDYNAMIC rsh(ILjava/lang/Object;)Ljava/lang/Object;");
        final String script = "double x = 0; def y = new HashMap(); y.put('0', 5.0); x = y.0; return x;";
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)I");
        assertEquals(5.0, exec(script));
    }
                + DefBootstrap.BINARY_OPERATOR
            "(?s).*INVOKEDYNAMIC add.*arguments:\\s+" + "\\d+" + ",\\s+" + DefBootstrap.BINARY_OPERATOR + ",\\s+" + 0 + ".*"
 */
        assertEquals(1, exec(script));
    }
    }
    }
 * GitHub history for details.
    public void testDoubleBraceListOptiLoad() {
    }
    }
            "List l = new ArrayList(); l.stream().mapToDouble(Double::valueOf).map(x -> x + 1)",
        assertEquals(5, exec(script));
    public void testRemOptRet() {
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;II)");
    public void testIntBraceMapOptiLoad() {
        assertBytecodeExists("def x = 1; def y = 2; double d = x * y", "INVOKEDYNAMIC mul(Ljava/lang/Object;Ljava/lang/Object;)D");
        assertBytecodeExists("def x = 1; int y = 2; return x % y", "INVOKEDYNAMIC rem(Ljava/lang/Object;I)Ljava/lang/Object;");
    }
    }
    public void testDoubleCall0Opti() {
    }
 * under the License.
    }
    }
    public void testIntFieldMapOptiStore() {
    }
 * Licensed to Elasticsearch under one or more contributor
    public void testAddOptRet() {
    }
        final String script = "double x = 1.0; def y = new HashMap(); y.put(0, 2.0); y[0] = x;";
        assertBytecodeExists("def x = true; def y = true; boolean v = x ^ y", "INVOKEDYNAMIC xor(Ljava/lang/Object;Ljava/lang/Object;)Z");
    }
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;II)");
        assertBytecodeExists("def x = 1; int y = 2; return x | y", "INVOKEDYNAMIC or(Ljava/lang/Object;I)Ljava/lang/Object;");
    public void testGtOptLHS() {
        assertBytecodeExists("int x = 1; def y = 2; return x >>> y", "INVOKEDYNAMIC ush(ILjava/lang/Object;)Ljava/lang/Object;");
                + ",\\s+"
    public void testDoubleBraceArrayOptiLoad() {
    public void testRemOptRHS() {
    public void testLtOptRHS() {
    public void testDoubleFieldMapOptiStore() {
    }
    }
        assertBytecodeExists("def x = true; boolean y = true; return x ^ y", "INVOKEDYNAMIC xor(Ljava/lang/Object;Z)Ljava/lang/Object;");
    public void testAndOptRet() {
        assertEquals(1.0, exec(script));
        assertBytecodeExists("def x = 1; int y = 2; return x < y", "INVOKEDYNAMIC lt(Ljava/lang/Object;I)Z");
    public void testLambdaArguments() {
    public void testIntBraceListOptiStore() {
    }
                + DefBootstrap.OPERATOR_ALLOWS_NULL
    public void testNeqOptRHS() {
        final String script = "int x = 0; def y = new HashMap(); y.put('0', 5); x = y.0; return x;";
    public void testDoubleBraceMapOptiStore() {
        assertBytecodeHasPattern(
        assertBytecodeExists("def x = 1; def y = 2; double d = x << y", "INVOKEDYNAMIC lsh(Ljava/lang/Object;Ljava/lang/Object;)D");
        assertBytecodeExists("def x = 1; def y = 2; double d = x - y", "INVOKEDYNAMIC sub(Ljava/lang/Object;Ljava/lang/Object;)D");
    }
    }
    }
        assertBytecodeExists(script, "INVOKEDYNAMIC get(Ljava/lang/Object;Ljava/lang/String;)I");
    }
    }
 * license agreements. See the NOTICE file distributed with
    }
    // horrible, sorry
    public void testIntFieldListOptiLoad() {
    public void testLtOptLHS() {
    }
    }
package org.opensearch.painless;
        final String script = "int x = 0; def y = new ArrayList(); y.add(5); x = y[0]; return x;";
        assertBytecodeExists("int x = 1; def y = 2; return x != y", "INVOKEDYNAMIC eq(ILjava/lang/Object;)Z");
    }
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;D)");
    }
    }
        assertEquals(1.0, exec(script));
        final String script = "double x = 0.0; def y = new ArrayList(); y.add(5.0); x = y[0]; return x;";
    public void testIntBraceArrayOptiStore() {
        assertEquals(5.0, exec(script));
        assertEquals(1, exec(script));
        );
        assertBytecodeExists(script, "INVOKEDYNAMIC get(Ljava/lang/Object;Ljava/lang/String;)D");
        assertBytecodeExists("def x = 1; def y = 2; double d = x >> y", "INVOKEDYNAMIC rsh(Ljava/lang/Object;Ljava/lang/Object;)D");
    }
        final String script = "int x = 1; def y = new ArrayList(); y.add(0); y.0 = x;";
    public void testMulOptRHS() {
    }
    public void testLambdaReturnType() {
    public void testBooleanXorOptRet() {
    }
        assertBytecodeExists("def x = 1; int y = 2; return x >> y", "INVOKEDYNAMIC rsh(Ljava/lang/Object;I)Ljava/lang/Object;");
    public void testSubOptLHS() {
        assertBytecodeExists("def x = 1; int y = 2; return x >>> y", "INVOKEDYNAMIC ush(Ljava/lang/Object;I)Ljava/lang/Object;");
    public void testUshOptLHS() {
 * Unless required by applicable law or agreed to in writing,
        assertEquals(5.0, exec(script));
    public void testAddOptNullGuards() {
    public void testDoubleFieldMapOptiLoad() {
    }
        assertBytecodeExists(
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;I)");
        );
        assertTrue(exception.getMessage().contains("Cannot cast java.lang.Double to java.lang.Integer"));
 *
    public void testDoubleCall1Opti() {
        assertBytecodeExists("int x = 1; def y = 2; return x | y", "INVOKEDYNAMIC or(ILjava/lang/Object;)Ljava/lang/Object;");
    }
        final String script = "int x; def y = new HashMap(); y['int'] = 1; x = y.get('int');";
    }
        assertEquals(1, exec(script));
    public void testIntFieldListOptiStore() {
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)D");
    }
        assertBytecodeExists("def x = 1; def y = 2; double d = x % y", "INVOKEDYNAMIC rem(Ljava/lang/Object;Ljava/lang/Object;)D");
        assertEquals(5, exec(script));
 *
        assertEquals(1, exec(script));
 * SPDX-License-Identifier: Apache-2.0
    }
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testDivOptRet() {
            "(?s).*INVOKEDYNAMIC add.*arguments:\\s+"
