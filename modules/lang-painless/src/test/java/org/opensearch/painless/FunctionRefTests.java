        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> {  
    public void testInterfaceStaticMethod() {
            exec("StringBuilder b = new StringBuilder(); List l = [1, 2]; l.stream().mapToLong(b::setLength).sum();");
        expected = expectScriptThrows(LambdaConversionException.class, () -> {  
        );
        });
        });
            exec("Optional.empty().orElseGet(String::startsWith);");  
    public void testCtorMethodReference() {
            exec(
                    + "return test.twoFunctionsOfX(x::concat, y::substring);"
                    + "def l = new ArrayList(); l.add(2); l.add(1); l.sort(this::mycompare); return l.get(0);"
        );
    public void testVirtualMethodReference() {  
    public void testCapturingMethodReferenceMultipleLambdas() {
        });
    public void testCapturingMethodReferenceDefInterface() {  
        });
            exec("StringBuilder b = new StringBuilder(); def l = [1, 2]; l.stream().mapToLong(b::setLength);");
package org.opensearch.painless;
    public void testArrayCtorMethodRef() {
        assertEquals("5", exec("Integer x = Integer.valueOf(5); def opt = Optional.empty(); return opt.orElseGet(x::toString);"));
        );
            exec("List l = [2, 1]; l.sort(Bogus::bogus); return l.get(0);", false);  
        assertThat(expected.getMessage(), containsString("function reference [String::isEmpty/2] matching [java.util.Comparator"));
            )  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testArrayCtorMethodRefDef() {  
                    + "return test.twoFunctionsOfX(x::concat, y::substring);"
                    + "DoubleSummaryStatistics::combine); "
    }
                    + "Stream stream = l.stream().map(StringBuilder::new);"
        assertEquals(  
            exec("List l = [2, 1]; l.sort(org.joda.time.BogusDateTime::bogus); return l.get(0);", false);
        assertEquals(
                    + "DoubleSummaryStatistics::accept, "
    public void testIncompatible() {
    }
                    + "DoubleStream doubleStream = l.stream().mapToDouble(Double::doubleValue);"  
    }
    public void testQualifiedVirtualMethodReferenceDef() {
    public void testOwnStaticMethodReferenceDef() {
                "String x = 'testing';"
    public void testVirtualMethodReferenceDef() {
    }
        assertEquals("variable [org.joda.time.BogusDateTime] is not defined", e.getMessage());  
    public void testCapturingMethodReference() {
        assertEquals(  
        assertEquals(1, exec("def l = new ArrayList(); l.add(2); l.add(1); l.sort(Integer::compare); return l.get(0);"));  
                singletonMap("d", Instant.ofEpochMilli(instant)),
                "def l = new ArrayList(); l.add(1.0); l.add(2.0); "
        assertEquals(1, exec("List l = new ArrayList(); l.add(2); l.add(1); l.sort(Integer::compare); return l.get(0);"));
    public void testStaticMethodReferenceDef() {
    }
            "bar",
    }
                    + "return array[0];"  
        assertEquals(  
    }
        assertThat(
            exec("def y = Optional.empty(); return y.orElseGet(String::startsWith);");
                    + "def[] array = l.stream().toArray(Double[]::new);"  
 * license agreements. See the NOTICE file distributed with
                "List l = [params.d]; return l.stream().mapToLong(Instant::toEpochMilli).sum()",  
                    + "return array[0];"
        long instant = randomLong();
            e.getMessage(),
        );
            exec(  
                    + "DoubleSummaryStatistics stats = doubleStream.collect(DoubleSummaryStatistics::new, "
        });  
        assertEquals("5", exec("def x = Integer.valueOf(5); def opt = Optional.empty(); return opt.orElseGet(x::toString);"));  
    }
        assertEquals(
}
                    + "def y = 'abcdefg';"  
    }
            containsString("cannot convert function reference [Integer::bogus] to a non-functional interface [def]")  
            exec(
            new Object[] { "foo", "bar" },
    }  
        assertEquals("[]", exec("def l = new ArrayList(); return Optional.empty().orElseGet(l::toString);"));  
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
    }
            2,
    public void testCapturingMethodReferenceMultipleLambdasDefInterface() {
    }
                    + "def[] array = l.stream().toArray(Double[]::new);"
 * KIND, either express or implied.  See the License for the
            exec(
    public void testWrongArity() {
        assertEquals(  
 * not use this file except in compliance with the License.
            exec(
            )
            expected.getMessage(),  
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
            true,
    }
            "testingcdefg",  
            containsString("function reference [java.time.Instant::bogus/2] matching [java.util.Comparator, compare/2")  
        );
            containsString("function reference [String::startsWith/0] matching [java.util.function.Supplier")
                "List l = new ArrayList(); l.add('foo'); l.add('bar'); "  
                    + "def doubleStream = l.stream().mapToDouble(Double::doubleValue);"
        );
    }
    }  
        assertEquals(
            exec("def b = new StringBuilder(); List l = [1, 2]; l.stream().mapToLong(b::setLength);");  
        );  
            expected.getMessage(),
                "def l = [params.d]; return l.stream().mapToLong(Instant::toEpochMilli).sum()",  
 */  
 *
        );
    }  
                true
    public void testMethodMissing() {
                    + "def test = new org.opensearch.painless.FeatureTestObject(2,3);"
        assertEquals("[]", exec("List l = new ArrayList(); def opt = Optional.empty(); return opt.orElseGet(l::toString);"));
public class FunctionRefTests extends ScriptTestCase {
    }  
        );  
import static java.util.Collections.singletonMap;
            exec(
    }
    public void testQualifiedMethodMissing() {  
        );
            )
    }  
        assertEquals("5", exec("def x = Integer.valueOf(5); return Optional.empty().orElseGet(x::toString);"));
            exec("List l = new ArrayList(); l.add(2); l.add(1); l.sort(String::isEmpty);");
 * software distributed under the License is distributed on an
            (Object[]) exec(
        );
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {  
        );  
    public void testInterfaceDefaultMethodDef() {
import static org.hamcrest.Matchers.containsString;
            exec("def l = new ArrayList(); l.add(2); l.add(1); l.sort(String::isEmpty);");  
            instant,
    public void testCtorWithParams() {
            true,
    public void testQualifiedVirtualMethodReference() {
    public void testNotFunctionalInterface() {  
        );
 * under the License.  
            "bar",  
                    + "return test.twoFunctionsOfX(x::concat, y::substring);"
    public void testQualifiedStaticMethodReference() {
        );
                "def l = new ArrayList(); l.add(1.0); l.add(2.0); "
            )  
            exec("List l = new ArrayList(); l.add(2); l.add(1); l.sort(String::startsWith); return l.get(0);");  
 * The OpenSearch Contributors require contributions made to  
            )  
    public void testWrongArityNotEnough() {
            "testingcdefg",  
                "def x = 'testing';"
                    + "return test.twoFunctionsOfX(x::concat, y::substring);"
            1.0D,  
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> {
 * this file be licensed under the Apache-2.0 license or a
    public void testWrongArityDef() {  
 * ownership. Elasticsearch licenses this file to you under  
            3.0D,  
import static org.hamcrest.Matchers.endsWith;  
            exec(
    public void testReturnVoid() {
            )
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(e.getMessage(), endsWith("variable [Bogus] is not defined"));
    public void testClassMissing() {
        assertEquals("[]", exec("List l = new ArrayList(); return Optional.empty().orElseGet(l::toString);"));
/*  
        });
        assertThat(
 *
            exec("List l = new ArrayList(); l.add(2); l.add(1); l.add(Integer::bogus); return l.get(0);");
    }  
            exec(  
        assertEquals("[]", exec("def l = new ArrayList(); def opt = Optional.empty(); return opt.orElseGet(l::toString);"));
                    + "org.opensearch.painless.FeatureTestObject test = new org.opensearch.painless.FeatureTestObject(2,3);"
        assertEquals(
 *    http://www.apache.org/licenses/LICENSE-2.0
            )  
            )  
        assertThat(
                    + "return stream.map(Object::toString).toArray()"
    public void testOwnStaticMethodReference() {
        );
        });  
        assertEquals(
    }  
import java.lang.invoke.LambdaConversionException;
/*  
            containsString("function reference [String::startsWith/0] matching [java.util.function.Supplier")  
        });
                "def x = 'testing';"
                    + "List l = new ArrayList(); l.add(2); l.add(1); l.sort(this::mycompare); return l.get(0);"  
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> {  
            exec(
    }  
        assertThat(expected.getMessage(), containsString("lambda expects return type [long], but found return type [void]"));
        );
        assertArrayEquals(  
                "Supplier get(Supplier supplier) { return supplier }" + "Supplier s = get(Comparator::naturalOrder); s.get().compare(1, 2)"  
        Throwable expected = expectScriptThrows(ClassCastException.class, () -> {  
        assertEquals(
            instant,
    }
    }  
    public void testCapturingMethodReferenceMultipleLambdasDefImpls() {
            "testingcdefg",  
                "String x = 'testing';"
            exec("def b = new StringBuilder(); def l = [1, 2]; l.stream().mapToLong(b::setLength);");
    public void testCtorMethodReferenceDef() {  
        assertEquals("5", exec("Integer x = Integer.valueOf(5); return Optional.empty().orElseGet(x::toString);"));  
    }
        );
        );
            exec(
        assertEquals(
        assertThat(expected.getMessage(), containsString("Cannot cast from [void] to [long]."));  
            exec(
            )
        assertEquals(
    }
    public void testCapturingMethodReferenceMultipleLambdasDefEverywhere() {
        });
    }  
            exec(
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
                "int mycompare(int i, int j) { j - i } "
            "testingcdefg",  
            exec(
            1.0D,
 * GitHub history for details.
                    + "def test = new org.opensearch.painless.FeatureTestObject(2,3);"
                true
                    + "org.opensearch.painless.FeatureTestObject test = new org.opensearch.painless.FeatureTestObject(2,3);"
    public void testWrongArityNotEnoughDef() {
 * SPDX-License-Identifier: Apache-2.0
    }
        assertThat(e.getMessage(), containsString("function reference [Integer::bogus/2] matching [java.util.Comparator"));  
    }  
                    + "String y = 'abcdefg';"  
        assertThat(expected.getMessage(), containsString("lambda expects return type [long], but found return type [void]"));
            exec("List l = [2, 1]; l.sort(Integer::bogus); return l.get(0);");
        assertEquals(2, exec("List l = new ArrayList(); l.add(1); l.add(1); return l.stream().mapToInt(Integer::intValue).sum();"));
    }
    public void testCapturingMethodReferenceDefEverywhere() {
 */
            exec("String f(BiFunction function) { function.apply('foo', 'bar') }" + "def map = new HashMap(); f(map::getOrDefault)")
                    + "String y = 'abcdefg';"  
            )
            exec("List l = [2, 1]; l.sort(java.time.Instant::bogus); return l.get(0);", false);
    public void testStaticMethodReference() {
            )  
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> {
            3.0D,
        );
        expectScriptThrows(ClassCastException.class, () -> {
        });  
                "List l = new ArrayList(); l.add(1.0); l.add(2.0); "
/*
        assertEquals(
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
                    + "return stats.getSum()"
            )
 *  
                "int mycompare(int i, int j) { j - i } "  
            expected.getMessage(),
    public void testQualifiedClassMissing() {
                    + "return stats.getSum()"  
    public void testReturnVoidDef() {  
        assertThat(
    }
                    + "DoubleSummaryStatistics::accept, "
    }
        assertThat(expected.getMessage(), containsString("function reference [String::isEmpty/2] matching [java.util.Comparator"));  
        assertEquals(2, exec("def l = new ArrayList(); l.add(1); l.add(1); return l.stream().mapToInt(Integer::intValue).sum();"));
        );
        assertEquals(
    }
            2,  
                    + "DoubleSummaryStatistics::combine); "  
        });
    }
        );  
    }
    }
import java.time.Instant;
        long instant = randomLong();
    public void testInterfaceDefaultMethod() {  
            exec("String f(BiFunction function) { function.apply('foo', 'bar') }" + "Map map = new HashMap(); f(map::getOrDefault)")  
        });
        assertEquals(
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(expected.getMessage(), containsString("lambda expects return type [long], but found return type [void]"));  
                    + "def stats = doubleStream.collect(DoubleSummaryStatistics::new, "  
                    + "def y = 'abcdefg';"  
        });
            )  
 * specific language governing permissions and limitations
        );
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
            -1,
 */  
            exec("List l = [true]; l.stream().map(org.opensearch.painless.FeatureTestObject::overloadedStatic).findFirst().get()")
        expected = expectScriptThrows(LambdaConversionException.class, () -> {
            )
 * compatible open source license.
        });  
        assertEquals(  
                "List l = new ArrayList(); l.add(1.0); l.add(2.0); "
    public void testQualifiedStaticMethodReferenceDef() {  
    public void testCapturingMethodReferenceDefImpl() {
                singletonMap("d", Instant.ofEpochMilli(instant)),
        assertEquals(
 * this work for additional information regarding copyright
        Exception expected = expectScriptThrows(LambdaConversionException.class, () -> {
    }
            exec("def l = [true]; l.stream().map(org.opensearch.painless.FeatureTestObject::overloadedStatic).findFirst().get()")  
