            exec("String f(BiFunction function) { function.apply('foo', 'bar') }" + "Map map = new HashMap(); f(map::getOrDefault)")
        );
            e.getMessage(),
                "def x = 'testing';"
                    + "DoubleSummaryStatistics::combine); "
            exec("StringBuilder b = new StringBuilder(); def l = [1, 2]; l.stream().mapToLong(b::setLength);");
                    + "org.opensearch.painless.FeatureTestObject test = new org.opensearch.painless.FeatureTestObject(2,3);"
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(
/*
    }
    public void testCapturingMethodReferenceDefImpl() {
        );
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> {
        );
            2,
            )
            exec("List l = [2, 1]; l.sort(java.time.Instant::bogus); return l.get(0);", false);
            exec("List l = [true]; l.stream().map(org.opensearch.painless.FeatureTestObject::overloadedStatic).findFirst().get()")
        assertEquals("[]", exec("def l = new ArrayList(); return Optional.empty().orElseGet(l::toString);"));
                "List l = [params.d]; return l.stream().mapToLong(Instant::toEpochMilli).sum()",
 *
                    + "def[] array = l.stream().toArray(Double[]::new);"
    public void testWrongArityDef() {
 * license agreements. See the NOTICE file distributed with
    }
            1.0D,
    }
            expected.getMessage(),
                    + "def l = new ArrayList(); l.add(2); l.add(1); l.sort(this::mycompare); return l.get(0);"
        assertEquals("5", exec("Integer x = Integer.valueOf(5); def opt = Optional.empty(); return opt.orElseGet(x::toString);"));
                    + "org.opensearch.painless.FeatureTestObject test = new org.opensearch.painless.FeatureTestObject(2,3);"
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> {
    public void testClassMissing() {
            exec(
        });
            "testingcdefg",
        });
            2,
    public void testWrongArityNotEnoughDef() {
                "String x = 'testing';"
                    + "DoubleSummaryStatistics stats = doubleStream.collect(DoubleSummaryStatistics::new, "
                true
        assertEquals(
    public void testQualifiedMethodMissing() {
        assertThat(expected.getMessage(), containsString("Cannot cast from [void] to [long]."));
    }
            )
 * not use this file except in compliance with the License.
    }
                    + "List l = new ArrayList(); l.add(2); l.add(1); l.sort(this::mycompare); return l.get(0);"
        );
 *
            exec("Optional.empty().orElseGet(String::startsWith);");
 *
        );
    }
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> {
            exec(
    }
        assertEquals(2, exec("List l = new ArrayList(); l.add(1); l.add(1); return l.stream().mapToInt(Integer::intValue).sum();"));
    }
    }
        });
    public void testCapturingMethodReferenceDefEverywhere() {
        assertThat(expected.getMessage(), containsString("lambda expects return type [long], but found return type [void]"));
        );
        assertEquals(
                    + "return stats.getSum()"
    }
        );
            exec("List l = new ArrayList(); l.add(2); l.add(1); l.sort(String::startsWith); return l.get(0);");
                    + "return array[0];"
        );
            exec("List l = [2, 1]; l.sort(Bogus::bogus); return l.get(0);", false);
        );
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
        );
        assertThat(expected.getMessage(), containsString("function reference [String::isEmpty/2] matching [java.util.Comparator"));
    }
    }
                    + "String y = 'abcdefg';"
}
            exec("String f(BiFunction function) { function.apply('foo', 'bar') }" + "def map = new HashMap(); f(map::getOrDefault)")
    public void testQualifiedStaticMethodReferenceDef() {
        });
            )
        Throwable expected = expectScriptThrows(ClassCastException.class, () -> {
            "bar",
    public void testInterfaceDefaultMethodDef() {
    public void testArrayCtorMethodRefDef() {
    }
import static org.hamcrest.Matchers.endsWith;
    public void testCapturingMethodReferenceMultipleLambdasDefEverywhere() {
        assertEquals(
            exec("StringBuilder b = new StringBuilder(); List l = [1, 2]; l.stream().mapToLong(b::setLength).sum();");
        );
        assertEquals(1, exec("def l = new ArrayList(); l.add(2); l.add(1); l.sort(Integer::compare); return l.get(0);"));
    public void testCapturingMethodReferenceMultipleLambdasDefImpls() {
    }
 * under the License.
        });
    public void testCtorMethodReference() {
        assertEquals("5", exec("def x = Integer.valueOf(5); return Optional.empty().orElseGet(x::toString);"));
        Exception e = expectScriptThrows(IllegalArgumentException.class, () -> {
        );
        );
    }
    }
                singletonMap("d", Instant.ofEpochMilli(instant)),
        assertEquals(
    public void testOwnStaticMethodReference() {
            3.0D,
    public void testReturnVoid() {
    }
    public void testNotFunctionalInterface() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        );
    public void testCtorMethodReferenceDef() {
    }
        assertThat(
 * SPDX-License-Identifier: Apache-2.0
    }
        long instant = randomLong();
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
 * The OpenSearch Contributors require contributions made to
                "def l = [params.d]; return l.stream().mapToLong(Instant::toEpochMilli).sum()",
            exec(
                    + "def stats = doubleStream.collect(DoubleSummaryStatistics::new, "
    public void testQualifiedVirtualMethodReferenceDef() {
            exec(
    public void testQualifiedVirtualMethodReference() {
    }
        );
 * specific language governing permissions and limitations
public class FunctionRefTests extends ScriptTestCase {
                "def l = new ArrayList(); l.add(1.0); l.add(2.0); "
                    + "DoubleSummaryStatistics::accept, "
            exec(
            containsString("function reference [String::startsWith/0] matching [java.util.function.Supplier")
import java.lang.invoke.LambdaConversionException;
                    + "return array[0];"
        );
            instant,
            )
    public void testCapturingMethodReference() {
            )
            new Object[] { "foo", "bar" },
            expected.getMessage(),
        });
            -1,
            )
            "bar",
/*
        );
            )
    public void testCapturingMethodReferenceMultipleLambdasDefInterface() {
                    + "return test.twoFunctionsOfX(x::concat, y::substring);"
                "List l = new ArrayList(); l.add(1.0); l.add(2.0); "
        assertEquals(
import static java.util.Collections.singletonMap;
        assertThat(e.getMessage(), endsWith("variable [Bogus] is not defined"));
 */
 * compatible open source license.
        assertEquals("[]", exec("List l = new ArrayList(); def opt = Optional.empty(); return opt.orElseGet(l::toString);"));
    public void testVirtualMethodReferenceDef() {
    }
 * this file be licensed under the Apache-2.0 license or a
        Exception expected = expectScriptThrows(LambdaConversionException.class, () -> {
            exec("def l = new ArrayList(); l.add(2); l.add(1); l.sort(String::isEmpty);");
    }
                "List l = new ArrayList(); l.add('foo'); l.add('bar'); "
        });
    public void testMethodMissing() {
        );
            3.0D,
 * Unless required by applicable law or agreed to in writing,
        });
    public void testStaticMethodReference() {
    public void testCapturingMethodReferenceMultipleLambdas() {
                "String x = 'testing';"
            exec("def b = new StringBuilder(); List l = [1, 2]; l.stream().mapToLong(b::setLength);");
        expected = expectScriptThrows(LambdaConversionException.class, () -> {
    public void testQualifiedStaticMethodReference() {
    public void testArrayCtorMethodRef() {
        assertEquals(
        });
    }
 * Modifications Copyright OpenSearch Contributors. See
                "int mycompare(int i, int j) { j - i } "
                    + "def[] array = l.stream().toArray(Double[]::new);"
            )
            exec(
        assertEquals("variable [org.joda.time.BogusDateTime] is not defined", e.getMessage());
            )
 * You may obtain a copy of the License at
            "testingcdefg",
                    + "return test.twoFunctionsOfX(x::concat, y::substring);"
        assertEquals(
            )
        assertThat(expected.getMessage(), containsString("lambda expects return type [long], but found return type [void]"));
        );
        assertThat(
        long instant = randomLong();
                    + "def y = 'abcdefg';"
            )
    }
    public void testOwnStaticMethodReferenceDef() {
            true,
        assertEquals(
                "def x = 'testing';"
        assertEquals(1, exec("List l = new ArrayList(); l.add(2); l.add(1); l.sort(Integer::compare); return l.get(0);"));
    public void testIncompatible() {
    public void testVirtualMethodReference() {
        expectScriptThrows(ClassCastException.class, () -> {
            exec("def l = [true]; l.stream().map(org.opensearch.painless.FeatureTestObject::overloadedStatic).findFirst().get()")
    public void testStaticMethodReferenceDef() {
        assertEquals("5", exec("def x = Integer.valueOf(5); def opt = Optional.empty(); return opt.orElseGet(x::toString);"));
            exec(
        assertEquals("5", exec("Integer x = Integer.valueOf(5); return Optional.empty().orElseGet(x::toString);"));
    }
        });
    public void testCapturingMethodReferenceDefInterface() {
                true
            instant,
        assertEquals(
        assertEquals(
        assertEquals(2, exec("def l = new ArrayList(); l.add(1); l.add(1); return l.stream().mapToInt(Integer::intValue).sum();"));
package org.opensearch.painless;
            exec("def y = Optional.empty(); return y.orElseGet(String::startsWith);");
    public void testCtorWithParams() {
                    + "def test = new org.opensearch.painless.FeatureTestObject(2,3);"
        assertEquals(
                    + "String y = 'abcdefg';"
    }
    }
                    + "return test.twoFunctionsOfX(x::concat, y::substring);"
 * software distributed under the License is distributed on an
                "def l = new ArrayList(); l.add(1.0); l.add(2.0); "
            exec("List l = new ArrayList(); l.add(2); l.add(1); l.sort(String::isEmpty);");
/*
        assertThat(
        assertEquals(
        assertEquals(
            expected.getMessage(),
            exec("List l = [2, 1]; l.sort(Integer::bogus); return l.get(0);");
    }
        assertEquals(
                    + "DoubleStream doubleStream = l.stream().mapToDouble(Double::doubleValue);"
        assertEquals("[]", exec("List l = new ArrayList(); return Optional.empty().orElseGet(l::toString);"));
                    + "return test.twoFunctionsOfX(x::concat, y::substring);"
        expected = expectScriptThrows(LambdaConversionException.class, () -> {
    }
            1.0D,
            )
    public void testInterfaceDefaultMethod() {
 * GitHub history for details.
                singletonMap("d", Instant.ofEpochMilli(instant)),
            exec(
        });
    }
        );
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
            (Object[]) exec(
            "testingcdefg",
        assertEquals(
        });
 */
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
            exec("List l = new ArrayList(); l.add(2); l.add(1); l.add(Integer::bogus); return l.get(0);");
            )
        );
                "int mycompare(int i, int j) { j - i } "
    public void testReturnVoidDef() {
            )
            exec(
    }
            containsString("function reference [java.time.Instant::bogus/2] matching [java.util.Comparator, compare/2")
    public void testWrongArity() {
            true,
            exec(
                    + "Stream stream = l.stream().map(StringBuilder::new);"
            exec(
            exec(
                    + "def test = new org.opensearch.painless.FeatureTestObject(2,3);"
        assertThat(expected.getMessage(), containsString("function reference [String::isEmpty/2] matching [java.util.Comparator"));
        );
    }
                    + "def doubleStream = l.stream().mapToDouble(Double::doubleValue);"
 * the Apache License, Version 2.0 (the "License"); you may
    }
import static org.hamcrest.Matchers.containsString;
            exec("def b = new StringBuilder(); def l = [1, 2]; l.stream().mapToLong(b::setLength);");
    }
        assertThat(expected.getMessage(), containsString("lambda expects return type [long], but found return type [void]"));
    public void testQualifiedClassMissing() {
    public void testInterfaceStaticMethod() {
    }
 * this work for additional information regarding copyright
import java.time.Instant;
    }
            exec(
        assertThat(
        assertArrayEquals(
        });
            exec("List l = [2, 1]; l.sort(org.joda.time.BogusDateTime::bogus); return l.get(0);", false);
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "return stats.getSum()"
    public void testWrongArityNotEnough() {
        IllegalArgumentException expected = expectScriptThrows(IllegalArgumentException.class, () -> {
                    + "return stream.map(Object::toString).toArray()"
            containsString("cannot convert function reference [Integer::bogus] to a non-functional interface [def]")
        assertEquals("[]", exec("def l = new ArrayList(); def opt = Optional.empty(); return opt.orElseGet(l::toString);"));
                "Supplier get(Supplier supplier) { return supplier }" + "Supplier s = get(Comparator::naturalOrder); s.get().compare(1, 2)"
        assertThat(e.getMessage(), containsString("function reference [Integer::bogus/2] matching [java.util.Comparator"));
                    + "DoubleSummaryStatistics::accept, "
 */
            containsString("function reference [String::startsWith/0] matching [java.util.function.Supplier")
    }
        assertEquals(
                    + "def y = 'abcdefg';"
            "testingcdefg",
                    + "DoubleSummaryStatistics::combine); "
                "List l = new ArrayList(); l.add(1.0); l.add(2.0); "
        });
