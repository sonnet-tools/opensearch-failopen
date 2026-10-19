                + ",\\s+"
    public void testDoubleFieldMapOptiLoad() {
    }
        final String script = "double x; def y = new HashMap(); y['double'] = 1.0; x = y.get('double'); return x;";  
        final Exception exception = expectScriptThrows(ClassCastException.class, () -> { exec(script); });  
    public void testIntCall0Opti() {  
 *
    }
        assertBytecodeExists(
    public void testUnaryNotOptRet() {
        assertBytecodeExists("int x = 1; def y = 2; return x > y", "INVOKEDYNAMIC gt(ILjava/lang/Object;)Z");
    public void testIntBraceMapOptiStore() {  
    public void testIntFieldMapOptiStore() {  
        );
    public void testDoubleFieldListOptiStore() {
        assertBytecodeExists("int x = 1; def y = 2; return x >> y", "INVOKEDYNAMIC rsh(ILjava/lang/Object;)Ljava/lang/Object;");
        assertEquals(5.0, exec(script));
        assertBytecodeExists("def x = 1; double y = +x; return y", "INVOKEDYNAMIC plus(Ljava/lang/Object;)D");  
        assertBytecodeExists("def x = 1; int y = 2; return x % y", "INVOKEDYNAMIC rem(Ljava/lang/Object;I)Ljava/lang/Object;");  
    // horrible, sorry
    }  
        assertBytecodeExists("def x = true; def y = true; boolean v = x ^ y", "INVOKEDYNAMIC xor(Ljava/lang/Object;Ljava/lang/Object;)Z");  
 * compatible open source license.
    public void testLambdaArguments() {
    public void testLshOptRHS() {
    }
        assertBytecodeExists("def x = 1; int y = 2; return x != y", "INVOKEDYNAMIC eq(Ljava/lang/Object;I)Z");
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)I");
        final String script = "int x; def y = new HashMap(); y['int'] = 1; x = y.get('int');";
    }  
        assertBytecodeExists("def x = 1; def y = 2; double d = x & y", "INVOKEDYNAMIC and(Ljava/lang/Object;Ljava/lang/Object;)D");  
    }  
    public void testDoubleCall0Opti() {
    public void testGteOptRHS() {  
    public void testLshOptLHS() {  
    }
    }
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
                + ".*"
    }  
 */
 */  
    public void testXorOptRHS() {
        assertBytecodeHasPattern(  
        assertBytecodeExists("int x = 1; def y = 2; return x & y", "INVOKEDYNAMIC and(ILjava/lang/Object;)Ljava/lang/Object;");
    }  
        assertEquals(1.0, exec(script));
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;II)");
    }
    public void testMulOptRet() {  
        final String script = "int x = 1; def y = new HashMap(); y.put(0, 1); y[0] = x;";
    public void testLshOptRet() {
        assertBytecodeExists("def x = 1; int y = 2; return x < y", "INVOKEDYNAMIC lt(Ljava/lang/Object;I)Z");
        assertBytecodeExists("int x = 1; def y = 2; return x >= y", "INVOKEDYNAMIC gte(ILjava/lang/Object;)Z");  
        assertEquals(1, exec(script));  
        assertEquals(1.0, exec(script));
    }  
        final String script = "int x = 0; def y = new HashMap(); y.put('0', 5); x = y.0; return x;";
    public void testAddOptRet() {  
        assertBytecodeExists("def x = 1; int y = 2; return x == y", "INVOKEDYNAMIC eq(Ljava/lang/Object;I)Z");  
        final String script = "double x = 1.0; def y = new HashMap(); y.put('0', 1.0); y.0 = x; return y.0;";  
    }  
    public void testRshOptRHS() {
            "def x = 1; def y = 2; double z = x + y",
    public void testMulOptLHS() {
        assertBytecodeExists("def x = 1; int y = 2; return x >>> y", "INVOKEDYNAMIC ush(Ljava/lang/Object;I)Ljava/lang/Object;");
                + DefBootstrap.OPERATOR_ALLOWS_NULL
        final String script = "double x = 0.0; def y = new ArrayList(); y.add(5.0); x = y[0]; return x;";
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;)I");
    }
    }
    public void testUshOptRet() {
    public void testGtOptLHS() {
 * this file be licensed under the Apache-2.0 license or a
    }
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;I)");
    public void testIntBraceListOptiLoad() {  
        assertEquals(5.0, exec(script));
        assertEquals(5.0, exec(script));
        assertBytecodeExists("def x = true; boolean y = true; return x ^ y", "INVOKEDYNAMIC xor(Ljava/lang/Object;Z)Ljava/lang/Object;");
    public void testSubOptRHS() {
        assertEquals(5, exec(script));  
        assertBytecodeExists("def x = 1; int y = 2; return x - y", "INVOKEDYNAMIC sub(Ljava/lang/Object;I)Ljava/lang/Object;");
        assertBytecodeExists("def x = 1; def y = 2; double d = x << y", "INVOKEDYNAMIC lsh(Ljava/lang/Object;Ljava/lang/Object;)D");  
 * GitHub history for details.
        assertBytecodeExists("def x = 1; def y = 2; double d = x >> y", "INVOKEDYNAMIC rsh(Ljava/lang/Object;Ljava/lang/Object;)D");  
        assertBytecodeExists(script, "INVOKEDYNAMIC get(Ljava/lang/Object;Ljava/lang/String;)D");
    }
    }
    }  
        assertBytecodeExists("int x = 1; def y = 2; return x >>> y", "INVOKEDYNAMIC ush(ILjava/lang/Object;)Ljava/lang/Object;");
 * KIND, either express or implied.  See the License for the
        );  
/*  
        assertBytecodeExists("int x = 1; def y = 2; return x != y", "INVOKEDYNAMIC eq(ILjava/lang/Object;)Z");
    public void testAndOptRet() {
    public void testRemOptRHS() {
        assertEquals(5, exec(script));  
        );
        assertBytecodeExists("def x = 1; def y = 2; double d = x ^ y", "INVOKEDYNAMIC xor(Ljava/lang/Object;Ljava/lang/Object;)D");  
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;II)");
        final String script = "int x = 1; def y = new HashMap(); y.put('0', 1); y.0 = x; return y.0;";
    }  
    public void testUnaryPlusOptRet() {
    }
        assertBytecodeExists("def x = 1; double y = -x; return y", "INVOKEDYNAMIC neg(Ljava/lang/Object;)D");
            "(?s).*INVOKEDYNAMIC add.*arguments:\\s+" + "\\d+" + ",\\s+" + DefBootstrap.BINARY_OPERATOR + ",\\s+" + 0 + ".*"
    }
        // still needs null guard, NPE is the wrong thing!
    }
        final String script = "int x = 1; def y = new int[1]; y[0] = x; return y[0];";
    public void testBooleanXorOptLHS() {  
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)D");
}
    }
        assertBytecodeExists("def x = 1; int y = 2; return x & y", "INVOKEDYNAMIC and(Ljava/lang/Object;I)Ljava/lang/Object;");
 * Modifications Copyright OpenSearch Contributors. See
        assertBytecodeExists("def x = 1; int y = 2; return x > y", "INVOKEDYNAMIC gt(Ljava/lang/Object;I)Z");  
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;ID)");
        assertBytecodeExists("int x = 1; def y = 2; return x < y", "INVOKEDYNAMIC lt(ILjava/lang/Object;)Z");
        final String script = "double x = 0.0; def y = new HashMap(); y.put(0, 5.0); x = y[0];";
 * specific language governing permissions and limitations
    public void testOrOptRet() {
    public void testIntBraceArrayOptiStore() {  
    public void testIntFieldListOptiStore() {  
        assertEquals(1.0, exec(script));
        assertBytecodeExists("def x = 1; int y = 2; return x + y", "INVOKEDYNAMIC add(Ljava/lang/Object;I)Ljava/lang/Object;");  
    }
    }
                + "\\d+"  
        assertEquals(1.0, exec(script));  
    public void testNeqOptLHS() {  
    }
    }
    public void testIntBraceListOptiStore() {  
    public void testGtOptRHS() {
        assertEquals(1, exec(script));  
    }
    public void testIntFieldListOptiLoad() {  
    }
    }  
        assertBytecodeExists("def x = 1; def y = 2; double d = x >>> y", "INVOKEDYNAMIC ush(Ljava/lang/Object;Ljava/lang/Object;)D");  
        final String script = "int x;\ndef y = new HashMap();\ny['double'] = 1.0;\nx = y.get('double');\n";  
 * ownership. Elasticsearch licenses this file to you under  
    }
        assertBytecodeExists("def x = 1; int y = 2; return x * y", "INVOKEDYNAMIC mul(Ljava/lang/Object;I)Ljava/lang/Object;");  
        final String script = "double x = 1.0; def y = new HashMap(); y.put(0, 2.0); y[0] = x;";
    }
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;)D");
package org.opensearch.painless;
        assertBytecodeExists("int x = 1; def y = 2; return x | y", "INVOKEDYNAMIC or(ILjava/lang/Object;)Ljava/lang/Object;");
    public void testDoubleBraceMapOptiLoad() {  
    }
    public void testRshOptRet() {
    public void testDoubleFieldListOptiLoad() {
    public void testDivOptLHS() {
    }
        assertBytecodeHasPattern(  
        final String script = "double x = 1.0; def y = new ArrayList(); y.add(0.0); y[0] = x; return y[0];";  
    public void testDivOptRet() {  
        assertBytecodeExists("def x = 1; int y = 2; return x | y", "INVOKEDYNAMIC or(Ljava/lang/Object;I)Ljava/lang/Object;");
        assertBytecodeExists("int x = 1; def y = 2; return x == y", "INVOKEDYNAMIC eq(ILjava/lang/Object;)Z");
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;D)");
    }
    }
    }  
    public void testAndOptLHS() {  
    public void testAddOptNullGuards() {
    }  
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;)I");
    }
    }
        );  
    }  
/*  
    public void testIntBraceMapOptiLoad() {  
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)I");
 * You may obtain a copy of the License at  
    }  
    public void testSubOptLHS() {  
    }
    public void testDoubleBraceArrayOptiLoad() {  
    public void testSubOptRet() {
 */  
    public void testDoubleFieldMapOptiStore() {
    }
        assertBytecodeExists("int x = 1; def y = 2; return x + y", "INVOKEDYNAMIC add(ILjava/lang/Object;)Ljava/lang/Object;");
/*
    public void testEqOptLHS() {
        assertBytecodeHasPattern(
        assertBytecodeExists("int x = 1; def y = 2; return x / y", "INVOKEDYNAMIC div(ILjava/lang/Object;)Ljava/lang/Object;");
    }  
 * under the License.  
    public void testAddOptLHS() {
    public void testRshOptLHS() {  
    }
                + ",\\s+"
    }
    }  
                + ",\\s+"
public class DefOptimizationTests extends ScriptTestCase {
    }
    public void testIntCall1Opti() {  
        assertBytecodeExists("def x = 1; def y = 2; double d = x - y", "INVOKEDYNAMIC sub(Ljava/lang/Object;Ljava/lang/Object;)D");  
        );
    }  
        assertBytecodeExists("def x = 1; int y = 2; return x ^ y", "INVOKEDYNAMIC xor(Ljava/lang/Object;I)Ljava/lang/Object;");
        final String script = "double x = 0; def y = new double[1]; y[0] = 5.0; x = y[0]; return x;";
    }  
        assertBytecodeExists("int x = 1; def y = 2; return x ^ y", "INVOKEDYNAMIC xor(ILjava/lang/Object;)Ljava/lang/Object;");
    }
    }  
                + DefBootstrap.BINARY_OPERATOR  
    public void testDoubleBraceListOptiStore() {
    }  
    public void testIntFieldMapOptiLoad() {  
        final String script = "double x = 0; def y = new ArrayList(); y.add(5.0); x = y.0;";  
    }  
        assertBytecodeExists("def x = 1; int y = 2; return x <= y", "INVOKEDYNAMIC lte(Ljava/lang/Object;I)Z");
        assertBytecodeExists("int x = 1; def y = 2; return x * y", "INVOKEDYNAMIC mul(ILjava/lang/Object;)Ljava/lang/Object;");
    public void testUshOptRHS() {
    public void testBooleanXorOptRHS() {
        final String script = "int x = 1; def y = new ArrayList(); y.add(0); y.0 = x;";
 *
        assertEquals(1.0, exec(script));
        assertEquals(1, exec(script));  
    }
        assertBytecodeExists("int x = 1; def y = 2; return x % y", "INVOKEDYNAMIC rem(ILjava/lang/Object;)Ljava/lang/Object;");
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;D)");
    }  
        final String script = "int x = 0; def y = new ArrayList(); y.add(5); x = y[0]; return x;";
    public void testOrOptRHS() {
    }
            "synthetic lambda$synthetic$0(D)D"
        assertBytecodeExists("def x = 1; def y = 2; double d = x % y", "INVOKEDYNAMIC rem(Ljava/lang/Object;Ljava/lang/Object;)D");
        assertBytecodeExists("def x = 1; def y = 2; double d = x / y", "INVOKEDYNAMIC div(Ljava/lang/Object;Ljava/lang/Object;)D");
        assertBytecodeExists("def x = 1; double y = ~x; return y", "INVOKEDYNAMIC not(Ljava/lang/Object;)D");
    public void testDoubleBraceMapOptiStore() {
        assertBytecodeExists(script, "INVOKEDYNAMIC get(Ljava/lang/Object;Ljava/lang/String;)D");
        assertBytecodeExists("def x = 1; int y = 2; return x >= y", "INVOKEDYNAMIC gte(Ljava/lang/Object;I)Z");
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)D");
    }  
        assertEquals(1, exec(script));  
 * Unless required by applicable law or agreed to in writing,
    }  
                + "\\d+"
                + DefBootstrap.OPERATOR_ALLOWS_NULL
        assertBytecodeExists("List l = new ArrayList(); l.removeIf(x -> x < 10)", "synthetic lambda$synthetic$0(Ljava/lang/Object;)Z");
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;II)");
                + ",\\s+"  
        final String script = "double x = 0; def y = new HashMap(); y.put('0', 5.0); x = y.0; return x;";  
    public void testAndOptRHS() {
            "(?s).*INVOKEDYNAMIC add.*arguments:\\s+"  
    }
    }
        assertEquals(5, exec(script));  
    }
        assertEquals(1, exec(script));  
 * license agreements. See the NOTICE file distributed with
                + ".*"  
        assertBytecodeExists(script, "INVOKEDYNAMIC get(Ljava/lang/Object;Ljava/lang/String;)I");
    public void testLteOptLHS() {
    public void testDoubleBraceListOptiLoad() {
        final String script = "int x = 0; def y = new ArrayList(); y.add(5); x = y.0;";
        final String script = "int x = 1; def y = new ArrayList(); y.add(0); y[0] = x; return y[0];";
    }
            "(?s).*INVOKEDYNAMIC add.*arguments:\\s+"
        assertBytecodeExists("boolean x = true; def y = true; return x ^ y", "INVOKEDYNAMIC xor(ZLjava/lang/Object;)Ljava/lang/Object;");
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;ID)");  
    }
 *  
        final String script = "int x = 0; def y = new int[1]; y[0] = 5; x = y[0]; return x;";
    public void testEqOptRHS() {
        assertBytecodeExists(script, "INVOKEDYNAMIC get(Ljava/lang/Object;Ljava/lang/String;)I");
        // a primitive argument is present: no null guard needed
        final String script = "double x = 1.0; def y = new ArrayList(); y.add(0); y.0 = x;";  
 * Licensed to Elasticsearch under one or more contributor  
    public void testLtOptRHS() {
    }  
    public void testDoubleBraceArrayOptiStore() {  
    public void testNeqOptRHS() {
        assertBytecodeExists(script, "INVOKEDYNAMIC get(Ljava/lang/Object;Ljava/lang/String;)I");
    public void testIllegalCast() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    }
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        assertBytecodeExists("def x = 1; def y = 2; double d = x | y", "INVOKEDYNAMIC or(Ljava/lang/Object;Ljava/lang/Object;)D");  
        assertTrue(exception.getMessage().contains("Cannot cast java.lang.Double to java.lang.Integer"));
        assertBytecodeExists("int x = 1; def y = 2; return x << y", "INVOKEDYNAMIC lsh(ILjava/lang/Object;)Ljava/lang/Object;");
        final String script = "double x = 1; def y = new double[1]; y[0] = x; return y[0];";
        assertEquals(5.0, exec(script));  
        assertBytecodeHasPattern(
    }
            "def x = 1; def y = 2; return x + y",
            "int x = 1; def y = 2; return x + y",
            "(?s).*INVOKEDYNAMIC add.*arguments:\\s+" + "\\d+" + ",\\s+" + DefBootstrap.BINARY_OPERATOR + ",\\s+" + 0 + ".*"
    public void testOrOptLHS() {  
        assertBytecodeExists("int x = 1; def y = 2; return x <= y", "INVOKEDYNAMIC lte(ILjava/lang/Object;)Z");  
                + DefBootstrap.BINARY_OPERATOR
        assertBytecodeExists("def x = 1; def y = 2; double d = x * y", "INVOKEDYNAMIC mul(Ljava/lang/Object;Ljava/lang/Object;)D");
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)D");  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(5, exec(script));  
    public void testIntBraceArrayOptiLoad() {  
    }
    public void testLambdaReturnType() {  
    public void testLteOptRHS() {  
    public void testBooleanXorOptRet() {
    public void testXorOptLHS() {  
    public void testDoubleCall1Opti() {
        assertBytecodeExists("int x = 1; def y = 2; return x - y", "INVOKEDYNAMIC sub(ILjava/lang/Object;)Ljava/lang/Object;");
    }
    public void testMulOptRHS() {
    public void testXorOptRet() {
    public void testRemOptRet() {  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;)D");
    public void testUshOptLHS() {  
        assertBytecodeExists("def x = 1; int y = 2; return x << y", "INVOKEDYNAMIC lsh(Ljava/lang/Object;I)Ljava/lang/Object;");
        assertEquals(5, exec(script));  
    public void testLtOptLHS() {  
            "def x = 1; int y = 2; return x + y",  
        assertEquals(1.0, exec(script));
        assertBytecodeExists("def x = 1; int y = 2; return x / y", "INVOKEDYNAMIC div(Ljava/lang/Object;I)Ljava/lang/Object;");  
        assertEquals(5.0, exec(script));
    }
    }
            "List l = new ArrayList(); l.stream().mapToDouble(Double::valueOf).map(x -> x + 1)",  
    public void testRemOptLHS() {
    }
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayStore(Ljava/lang/Object;ID)");
        // needs null guard  
    }
        assertBytecodeExists("def x = 1; int y = 2; return x >> y", "INVOKEDYNAMIC rsh(Ljava/lang/Object;I)Ljava/lang/Object;");
        assertEquals(1, exec(script));  
    public void testDivOptRHS() {
        final String script = "int x = 0; def y = new HashMap(); y.put(0, 5); x = y[0];";
    }
    public void testGteOptLHS() {
        final String script = "int x; def y = new HashMap(); y['int'] = 1; x = y.get('int'); return x;";
        assertBytecodeExists("def x = 1; def y = 2; double d = x + y", "INVOKEDYNAMIC add(Ljava/lang/Object;Ljava/lang/Object;)D");
        final String script = "double x; def y = new HashMap(); y['double'] = 1.0; x = y.get('double');";  
    public void testUnaryMinusOptRet() {  
        assertEquals(1.0, exec(script));
        assertBytecodeExists(script, "INVOKEDYNAMIC arrayLoad(Ljava/lang/Object;I)I");
    }  
    public void testAddOptRHS() {
        assertEquals(1, exec(script));  
        assertBytecodeExists(script, "INVOKEDYNAMIC 0(Ljava/lang/Object;I)");
