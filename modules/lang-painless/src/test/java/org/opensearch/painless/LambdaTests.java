    }
    }
                compare
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, false, () -> {
        );
            exec(
        assertEquals(
}
    public void testUnneededCurlyStatements() {
    }
                    + "list.forEach(x -> list2.add(x));"
            exec(
    public void testWrongArityNotEnoughDef() {
                    + "compare(() -> { if (params['number'] == 1) { return params['number'] }"
        assertEquals(1, exec("Optional.empty().orElseGet(() -> Optional.empty().orElseGet(() -> 1));"));
    }
            exec(
            false,
                    + "return list[0]"
        assertEquals(true, exec(compare + "compare(() -> { return params['number'] }, 2)", params, true));
            )
        });
            exec("def l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(() -> 5).sum();");
    public void testWrongArity() {
        assertEquals("1test", exec("int x = 1; String y = 'test'; return Optional.empty().orElseGet(() -> x + y);"));
    }
                "def list = new ArrayList(); "
 *
    }
            1,
            exec(
        assertEquals(true, exec(compare + "compare(() -> new ArrayList(), new ArrayList())"));
            exec(
            100,
                true
        assertTrue(expected.getMessage().contains("already defined"));
 * SPDX-License-Identifier: Apache-2.0
                compare + "compare(() -> { if (params['number'] == 2) { return params['number'] }" + "else { return params['key'] } }, 2)",
 * You may obtain a copy of the License at
            exec("def b = new StringBuilder(); List l = [1, 2]; l.stream().map(i -> b.setLength(i)).collect(Collectors.toList())")
        assertEquals(
 * Licensed to Elasticsearch under one or more contributor
        Map<String, Object> params = new HashMap<>();
        );
/*
        });
                    + "list.forEach(x -> list2.add(x));"
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
                "int sum = 0; " + "for (int i = 0; i < 100; i++) {" + "  sum += Optional.empty().orElseGet(() -> 1);" + "}" + "return sum;"
    public void testPrimitiveArgsTyped() {
        assertEquals(
        );
        assertEquals(4, exec("List l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(x -> x + 1).sum();"));
 *
    }
        assertEquals(true, exec(compare + "compare(() -> { new ArrayList() }, new ArrayList())"));
        assertEquals(
            exec(
            )
                    + "l.sort((a, b) -> a.length() - b.length()); return l.get(0)"
            "short",
        });
 * KIND, either express or implied.  See the License for the
            exec("StringBuilder b = new StringBuilder(); def l = [1, 2]; l.stream().mapToLong(i -> b.setLength(i))");
            );
        assertEquals(
    }
            2,
    /** Lambda parameters shouldn't be able to mask a variable already in scope */
    public void testReturnVoidDef() {
                    + "l.sort((String a, String b) -> a.length() - b.length()); return l.get(0)"
                    + "list.add(2); "
    public void testReservedCapture() {
/*
            exec(
        assertEquals(
    }
                "int x = 0; List l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(x -> { x += 1; return x }).sum();"
            exec("def b = new StringBuilder(); def l = [1, 2]; l.stream().map(i -> b.setLength(i)).collect(Collectors.toList())")
        assertEquals(1, exec("Optional.empty().orElseGet(() -> 1);"));
        );
    }
            )
                    + "compare(() -> { if (params['number'] == 2) { return params['number'] }"
    }
                compare + "compare(() -> { if (params['number'] == 1) { return params['number'] }" + "else { return params['key'] } }, 2)",
 */
    public void testNestedLambdas() {
        );
                    + "return test.twoFunctionsOfX(x -> 'testing'.concat(x), y -> 'abcdefg'.substring(y))"
        assertTrue(expected.getMessage(), expected.getMessage().contains("due to an incorrect number of arguments"));
    }
        assertEquals(5, exec("def foo(int x) { Optional.empty().orElseGet(() -> x) } return foo(5);"));
        assertEquals(
 *    http://www.apache.org/licenses/LICENSE-2.0
        params.put("number", 2);
        assertEquals(2, exec("int applyOne(IntFunction arg) { arg.apply(1) } applyOne(x -> { x + 1 })"));
        assertThat(expected.getMessage(), containsString("Cannot cast from [void] to [long]."));
                true
 * this work for additional information regarding copyright
            )
    /** interface ignores return value */
    public void testCaptureDef() {
    public void testPrimitiveLambdasWithTypedArgs() {
            Arrays.asList(null, null),
            2,
    }
        );
 * not use this file except in compliance with the License.
                compare
        assertEquals(2L, exec("long applyOne(IntFunction arg) { arg.apply(1) } applyOne(long x -> x + 1)"));
            exec(
        );
        assertTrue(expected.getMessage().contains("Incorrect number of parameters"));
            exec("List l = new ArrayList(); l.add((short)1); l.add(1); " + "return l.stream().mapToInt(long x -> (int)1).sum();")
        );
            exec("List l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(x -> { l = null; return x + 1 }).sum();");
            )
                    + "List list2 = new ArrayList(); "
import java.util.HashMap;
    }
    public void testVoidReturnDef() {
    public void testTwoLambdas() {
    /** interface ignores return value */
            exec(
                    + "else { return params['key'] } }, 'value')",
                "List list = new ArrayList(); "
 * under the License.
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, false, () -> {
                    + "else { return params['key'] } }, 'value')",
    public void testPrimitiveArgsTypedOddly() {
        assertEquals(
    }
        assertEquals(5, exec("int x = 5; return Optional.empty().orElseGet(() -> x);"));
        // Otherwise we convert the void into a null
        assertEquals(5, exec("int x = 5; def y = Optional.empty(); y.orElseGet(() -> x);"));
                params,
    public void testMultipleStatements() {
    public void testReturnVoid() {
    }
        assertEquals(false, exec(compare + "compare(() -> { return params['nokey'] }, 'value')", params, true));
 * specific language governing permissions and limitations
    }
        assertThat(expected.getMessage(), containsString("Cannot cast from [void] to [def]."));
        );
            exec(
        );
                    + "List list2 = new ArrayList(); "
    }
        // If we can catch the error at compile time we do
        assertEquals(2, exec("int foo(Function f) { return f.apply(1) }" + "return foo(x -> foo(y -> x + 1))"));
    }
        assertEquals(true, exec(compare + "compare(() -> { return params['nokey'] }, null)", params, true));
    public void testPrimitiveLambdasConvertible() {
            )
 * GitHub history for details.
    }
    public void testLambdaInFunction() {
        assertEquals(4, exec("List l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(int x -> x + 1).sum();"));
                true
    public void testWrongArityDef() {
    }
                params,
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
        assertEquals(
            Arrays.asList(null, null),
    public void testLambdaCaptureFunctionParam() {
    public void testPrimitiveArgs() {
        String compare = "boolean compare(Supplier s, def v) {s.get() == v}";
        );
        assertEquals(false, exec(compare + "compare(() -> { return params['number'] }, 'value')", params, true));
        assertEquals(
            )
        assertEquals(5, exec("def foo() { Optional.empty().orElseGet(() -> 5) } return foo();"));
 * license agreements. See the NOTICE file distributed with
    }
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
        assertEquals(true, exec(compare + "compare(() -> { return params['key'] }, 'value')", params, true));
        assertEquals(4, exec("def l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(x -> x + 1).sum();"));
 *
/*
    public void testPrimitiveLambdasWithTypedArgsDef() {
        assertEquals(4, exec("def l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(int x -> x + 1).sum();"));
            2,
        Throwable expected = expectScriptThrows(ClassCastException.class, () -> {
            exec("StringBuilder b = new StringBuilder(); List l = [1, 2]; l.stream().mapToLong(i -> b.setLength(i))");
    }
            exec("boolean x = false; int y = 1;" + "return Optional.empty().orElseGet(() -> x ? 5 : Optional.empty().orElseGet(() -> y));")
        );
        assertTrue(expected.getMessage().contains("Incorrect number of parameters"));
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
    public void testNestedCaptureParams() {
    public void testWrongArityNotEnough() {
    }
        params.put("key", "value");
        assertEquals(1, exec("def x = Optional.empty(); x.orElseGet(() -> 1);"));
        Exception expected = expectScriptThrows(ClassCastException.class, () -> {
 * Unless required by applicable law or agreed to in writing,
        });
import static org.hamcrest.Matchers.containsString;
        );
            )
    public void testNoArgLambdaDef() {
            )
    }
        });
 */
        });
        assertEquals(
                "org.opensearch.painless.FeatureTestObject test = new org.opensearch.painless.FeatureTestObject(2,3);"
                    + "return list[0]"
    public void testCapturesAreReadOnly() {
                    + "list.add(2); "
            exec(
public class LambdaTests extends ScriptTestCase {
        assertTrue(expected.getMessage().contains("is read-only"));
        });
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
    public void testPrimitiveLambdasDef() {
        assertEquals(
        assertEquals(
        assertEquals(2, exec("int applyOne(IntFunction arg) { arg.apply(1) } applyOne(int x -> x + 1)"));
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
            exec("Optional.empty().orElseGet(x -> x);");
            true,
                params,
 * The OpenSearch Contributors require contributions made to
    public void testNoParamMasking() {
            )
            true,
    }
    public void testNestedCapture() {
            "short",
    public void testNoArgLambda() {
    }
import java.util.Arrays;
            exec("List l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(() -> 5).sum();");
    public void testLambdaWithArgs() {
            false,
    public void testTwoCaptures() {
    }
        assertTrue(expected.getMessage(), expected.getMessage().contains("due to an incorrect number of arguments"));
    public void testLambdaWithTypedArgs() {
    public void testPrimitiveLambdas() {
            exec("def y = Optional.empty(); return y.orElseGet(x -> x);");
    }
        });
 * ownership. Elasticsearch licenses this file to you under
                "List l = new ArrayList(); l.add('looooong'); l.add('short'); "
                true
    }
                "List l = new ArrayList(); l.add('looooong'); l.add('short'); "
 * compatible open source license.
        assertEquals(
            "testingcdefg",
        );
        assertEquals(2, exec("int applyOne(IntFunction arg) { arg.apply(1) } applyOne(x -> { def y = x + 1; return y })"));
                params,
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
package org.opensearch.painless;
 */
    public void testCapture() {
import java.util.Map;
    public void testLambdaInLoop() {
    public void testVoidReturn() {
    }
        assertEquals(2, exec("int applyOne(IntFunction arg) { arg.apply(1) } applyOne(x -> x + 1)"));
