    }  
    public void testNoArgLambda() {  
        assertEquals(2, exec("int applyOne(IntFunction arg) { arg.apply(1) } applyOne(x -> { def y = x + 1; return y })"));  
    }  
    public void testPrimitiveLambdasWithTypedArgsDef() {  
                    + "compare(() -> { if (params['number'] == 1) { return params['number'] }"
 *    http://www.apache.org/licenses/LICENSE-2.0
            )
        assertEquals(2, exec("int applyOne(IntFunction arg) { arg.apply(1) } applyOne(x -> { x + 1 })"));
                    + "return list[0]"
        Map<String, Object> params = new HashMap<>();
 * license agreements. See the NOTICE file distributed with
        );
        assertEquals(
    public void testReservedCapture() {
                    + "compare(() -> { if (params['number'] == 2) { return params['number'] }"
    public void testNoArgLambdaDef() {
        assertEquals(
 *  
        assertEquals(1, exec("Optional.empty().orElseGet(() -> 1);"));
    public void testWrongArityNotEnoughDef() {
        );
            );  
import java.util.Map;  
            2,  
        assertEquals(2, exec("int applyOne(IntFunction arg) { arg.apply(1) } applyOne(x -> x + 1)"));  
    }
    }
                    + "else { return params['key'] } }, 'value')",  
                compare
        );
        });
            exec(
    }
    /** interface ignores return value */  
        assertEquals(  
        assertEquals(true, exec(compare + "compare(() -> { new ArrayList() }, new ArrayList())"));
        assertEquals(
import static org.hamcrest.Matchers.containsString;
            exec("def b = new StringBuilder(); def l = [1, 2]; l.stream().map(i -> b.setLength(i)).collect(Collectors.toList())")
 * You may obtain a copy of the License at  
            )  
/*  
        assertEquals(4, exec("def l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(int x -> x + 1).sum();"));
                params,  
            exec(
    public void testLambdaWithArgs() {
                params,
        );  
        assertEquals(2, exec("int applyOne(IntFunction arg) { arg.apply(1) } applyOne(int x -> x + 1)"));
 * this work for additional information regarding copyright
            true,  
package org.opensearch.painless;
 */  
        assertEquals(
    public void testReturnVoid() {  
            exec(  
    public void testVoidReturnDef() {
            exec(
        assertTrue(expected.getMessage().contains("Incorrect number of parameters"));  
        });
    public void testWrongArityNotEnough() {
 * compatible open source license.
import java.util.HashMap;
        assertEquals(4, exec("List l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(int x -> x + 1).sum();"));
    }
        );
    public void testPrimitiveArgs() {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
            exec("def y = Optional.empty(); return y.orElseGet(x -> x);");
                "List l = new ArrayList(); l.add('looooong'); l.add('short'); "  
        assertEquals(false, exec(compare + "compare(() -> { return params['nokey'] }, 'value')", params, true));  
            exec(
    }
    }
        assertEquals(  
            )
 * this file be licensed under the Apache-2.0 license or a
    public void testMultipleStatements() {
    }
    }  
        assertEquals(5, exec("def foo(int x) { Optional.empty().orElseGet(() -> x) } return foo(5);"));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(
        assertTrue(expected.getMessage().contains("is read-only"));
    public void testCapturesAreReadOnly() {  
                    + "List list2 = new ArrayList(); "
                compare + "compare(() -> { if (params['number'] == 2) { return params['number'] }" + "else { return params['key'] } }, 2)",
            )
    public void testWrongArity() {
        // Otherwise we convert the void into a null
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, false, () -> {
            )
            exec(
    public void testLambdaInLoop() {
        });
    }
                    + "l.sort((String a, String b) -> a.length() - b.length()); return l.get(0)"  
        });  
            exec(
    }
        assertEquals(2L, exec("long applyOne(IntFunction arg) { arg.apply(1) } applyOne(long x -> x + 1)"));
        Throwable expected = expectScriptThrows(ClassCastException.class, () -> {
}  
    public void testLambdaWithTypedArgs() {
                params,
    }  
    }
    public void testTwoCaptures() {
    public void testPrimitiveLambdasConvertible() {
        );  
        String compare = "boolean compare(Supplier s, def v) {s.get() == v}";  
        // If we can catch the error at compile time we do
            exec(
        assertEquals(5, exec("def foo() { Optional.empty().orElseGet(() -> 5) } return foo();"));
    }
                    + "list.add(2); "
    }
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {  
    }  
/*  
        });  
        assertEquals(true, exec(compare + "compare(() -> { return params['nokey'] }, null)", params, true));
        assertThat(expected.getMessage(), containsString("Cannot cast from [void] to [def]."));  
 * under the License.  
    public void testVoidReturn() {
        assertEquals(true, exec(compare + "compare(() -> { return params['key'] }, 'value')", params, true));
            )  
    }
        );
        assertEquals(
 * The OpenSearch Contributors require contributions made to  
                true
    public void testCaptureDef() {
        assertTrue(expected.getMessage(), expected.getMessage().contains("due to an incorrect number of arguments"));
        params.put("key", "value");
 * Unless required by applicable law or agreed to in writing,
            exec("boolean x = false; int y = 1;" + "return Optional.empty().orElseGet(() -> x ? 5 : Optional.empty().orElseGet(() -> y));")  
                "def list = new ArrayList(); "
        assertEquals(1, exec("def x = Optional.empty(); x.orElseGet(() -> 1);"));
            exec(
        );  
 * ownership. Elasticsearch licenses this file to you under  
                    + "list.add(2); "  
            2,  
public class LambdaTests extends ScriptTestCase {
            )
        );
        assertEquals(2, exec("int foo(Function f) { return f.apply(1) }" + "return foo(x -> foo(y -> x + 1))"));
            2,
    }
                    + "List list2 = new ArrayList(); "
        assertEquals(
        );  
    public void testWrongArityDef() {  
/*
        assertEquals(
        assertEquals(false, exec(compare + "compare(() -> { return params['number'] }, 'value')", params, true));  
                    + "else { return params['key'] } }, 'value')",  
        });
    }
    }
                compare
 * GitHub history for details.
    public void testTwoLambdas() {
    /** interface ignores return value */
 * Licensed to Elasticsearch under one or more contributor  
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {  
        assertTrue(expected.getMessage().contains("already defined"));
                true
        });  
        assertTrue(expected.getMessage().contains("Incorrect number of parameters"));
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
        assertEquals(1, exec("Optional.empty().orElseGet(() -> Optional.empty().orElseGet(() -> 1));"));
        );  
            exec("Optional.empty().orElseGet(x -> x);");
        });
    public void testNestedCaptureParams() {
    }  
                    + "return list[0]"  
            false,  
    public void testPrimitiveArgsTypedOddly() {
            exec(
    public void testPrimitiveLambdasDef() {
    public void testUnneededCurlyStatements() {  
 * not use this file except in compliance with the License.
        params.put("number", 2);  
    public void testNestedCapture() {  
        assertEquals(  
            "short",
 * software distributed under the License is distributed on an
            true,
        Exception expected = expectScriptThrows(ClassCastException.class, () -> {  
    public void testCapture() {
            100,  
            Arrays.asList(null, null),
    /** Lambda parameters shouldn't be able to mask a variable already in scope */
    public void testLambdaCaptureFunctionParam() {
            exec("StringBuilder b = new StringBuilder(); List l = [1, 2]; l.stream().mapToLong(i -> b.setLength(i))");
                true
    public void testLambdaInFunction() {  
        assertEquals(true, exec(compare + "compare(() -> { return params['number'] }, 2)", params, true));
            exec("StringBuilder b = new StringBuilder(); def l = [1, 2]; l.stream().mapToLong(i -> b.setLength(i))");
                "List l = new ArrayList(); l.add('looooong'); l.add('short'); "
    }
                    + "list.forEach(x -> list2.add(x));"  
    }
    public void testPrimitiveLambdasWithTypedArgs() {
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
    }  
    public void testNoParamMasking() {
            exec("List l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(() -> 5).sum();");  
 */
            exec("List l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(x -> { l = null; return x + 1 }).sum();");
    }  
                "int sum = 0; " + "for (int i = 0; i < 100; i++) {" + "  sum += Optional.empty().orElseGet(() -> 1);" + "}" + "return sum;"
    }
    }
                compare + "compare(() -> { if (params['number'] == 1) { return params['number'] }" + "else { return params['key'] } }, 2)",
        );
    }
        );
    }
        assertEquals(
                params,  
        assertEquals(
        assertEquals(5, exec("int x = 5; return Optional.empty().orElseGet(() -> x);"));
            exec("def l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(() -> 5).sum();");
        assertEquals("1test", exec("int x = 1; String y = 'test'; return Optional.empty().orElseGet(() -> x + y);"));  
 *
            )
            Arrays.asList(null, null),
    public void testPrimitiveLambdas() {  
        assertTrue(expected.getMessage(), expected.getMessage().contains("due to an incorrect number of arguments"));  
            false,
            exec(  
    }
 *
    }
    }
            )  
                "int x = 0; List l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(x -> { x += 1; return x }).sum();"
 * specific language governing permissions and limitations
        assertEquals(5, exec("int x = 5; def y = Optional.empty(); y.orElseGet(() -> x);"));  
        assertEquals(  
        );  
                    + "l.sort((a, b) -> a.length() - b.length()); return l.get(0)"
    }  
            exec("def b = new StringBuilder(); List l = [1, 2]; l.stream().map(i -> b.setLength(i)).collect(Collectors.toList())")  
            )
                    + "return test.twoFunctionsOfX(x -> 'testing'.concat(x), y -> 'abcdefg'.substring(y))"
        assertThat(expected.getMessage(), containsString("Cannot cast from [void] to [long]."));
 * KIND, either express or implied.  See the License for the
                    + "list.forEach(x -> list2.add(x));"
        assertEquals(4, exec("def l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(x -> x + 1).sum();"));  
 * the Apache License, Version 2.0 (the "License"); you may
            "short",  
                true
    }  
                "List list = new ArrayList(); "  
        assertEquals(4, exec("List l = new ArrayList(); l.add(1); l.add(1); " + "return l.stream().mapToInt(x -> x + 1).sum();"));
            "testingcdefg",
    public void testReturnVoidDef() {
                "org.opensearch.painless.FeatureTestObject test = new org.opensearch.painless.FeatureTestObject(2,3);"  
            exec("List l = new ArrayList(); l.add((short)1); l.add(1); " + "return l.stream().mapToInt(long x -> (int)1).sum();")
        assertEquals(true, exec(compare + "compare(() -> new ArrayList(), new ArrayList())"));
    public void testNestedLambdas() {  
            1,
import java.util.Arrays;
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, false, () -> {  
    public void testPrimitiveArgsTyped() {  
