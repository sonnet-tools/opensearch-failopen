        script = factory.newInstance(Collections.singletonMap("test", 2));
        script = factory.newInstance(Collections.singletonMap("test", 2));
        factory = getEngine().compile("converter_test", "new long[]{test}", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
            List<String> docFields();
        }
        public static final ScriptContext<FactoryTestScript.Factory> CONTEXT = new ScriptContext<>("test", FactoryTestScript.Factory.class);
        factory = getEngine().compile(
        contexts.put(TemplateScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        ClassCastException cce = expectScriptThrows(
            Collections.emptyMap()
        public Map<String, Object> getParams() {
        public static final ScriptContext<DeterministicFactoryTestScript.Factory> CONTEXT = new ScriptContext<>(
            if (def instanceof String) {
        );
            "Integer.parseInt('123') + Math.random()",
            "converter_test",
        }
    public void testConverterFactoryBadDef() {
            DeterministicFactoryTestScript.Factory.class
        assertArrayEquals(new long[] { 1001 }, script.execute(456));
        assertArrayEquals(new long[] { 1000, 123 }, script.execute(1000));
        public static long[] convertFromString(String s) {
            Collections.emptyMap()
            VoidReturnTestScript newInstance();
        assertArrayEquals(new long[] { 1000, 123 }, script.execute(1000));
        FactoryTestScript script = factory.newInstance(Collections.singletonMap("x", 1));
            Collections.emptyMap()
 * Unless required by applicable law or agreed to in writing,
        assertArrayEquals(new long[] { 1001 }, script.execute(1000));
        assertEquals(false, factory.needsNothing());
        public abstract boolean needsTest();
        DeterministicFactoryTestScript.Factory factory = getEngine().compile(
        public abstract long[] execute(int test);
        // autoreturn, converter
            boolean needsNothing();
            boolean needsNothing();
        private final Map<String, Object> params;
            "def a = new long[]{test, 123}; return a;",
            StatefulFactory newFactory(int x, int y);
        script = factory.newInstance(Collections.singletonMap("test", 2));
        public int getY() {
            FactoryTestScript.CONTEXT,
/*
        // autoreturn, converter
            "def a = new long[]{test}; a;",
        FactoryTestScript.Factory factory = getEngine().compile(
        assertArrayEquals(new long[] { 123, 456, 789 }, script.execute(123));
            "def a = new ArrayList(); a.add(test); a.add(456); a.add('789'); return a;",
        DocFieldsTestScript.Factory f = getEngine().compile(
        assertEquals(1, script.execute());
        factory = getEngine().compile("converter_test", "int x = 1", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
        public abstract Object execute(int test);
        }
        script = factory.newInstance(Collections.singletonMap("test", 2));
        );
import org.opensearch.common.settings.Settings;
 *    http://www.apache.org/licenses/LICENSE-2.0
            FactoryTestScript newInstance(Map<String, Object> params);
import org.opensearch.script.ScriptException;
    @BeforeClass
        assertEquals(false, script.needsNothing());
            doc.put("dog", "woof");
            return params;
        assertArrayEquals(new long[] { 100 }, script.execute(1000));
            FactoryTestConverterScript.Factory.class
            boolean needsTest();
            FactoryTestScript.CONTEXT,
        private final Map<String, Object> params;
        // autoreturn, no converter
    public abstract static class DeterministicFactoryTestScript {
        assertEquals(28, script.execute(7));
        expectThrows(NoSuchMethodException.class, () -> factory.getClass().getMethod("docFields"));
 */
import org.opensearch.script.ScriptContext;
        assertEquals(true, statefulFactory.needsX());
        assertEquals(true, factory.needsTest());
        ClassCastException exception = expectScriptThrows(
        StatefulFactoryTestScript.StatefulFactory statefulFactory = factory.newFactory(1, 2);
            ClassCastException.class,
            return params;
        } catch (ScriptException e) {
 * under the License.
    public abstract static class FactoryTestConverterScriptBadDef {
        }
        );
            FactoryTestConverterScriptBadDef.Factory.class
 * Licensed to Elasticsearch under one or more contributor
        );
        contexts.put(FactoryTestConverterScriptBadDef.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        assertEquals(4, script.execute(2));
        public int getD() {
            () -> getEngine().compile("def_return_in_void", "def x=1;return x;", VoidReturnTestScript.CONTEXT, Collections.emptyMap())
        public interface Factory {
            for (int i = 0; i < l.size(); i++) {
 * this work for additional information regarding copyright
        factory = getEngine().compile("converter_test", "def a = '1001'; a", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
        public Map<String, Object> getParams() {
        public static final ScriptContext<DocFieldsTestScript.Factory> CONTEXT = new ScriptContext<>(
            Collections.emptyMap()
            "test + x + y + d",
/*
        statefulFactory.newInstance(5, 6);
        public abstract long[] execute(int test);
        public FactoryTestScript(Map<String, Object> params) {
            }
    protected PainlessScriptEngine getEngine() {
            "Integer.parseInt('123')",
        }
        public static final ScriptContext<VoidReturnTestScript.Factory> CONTEXT = new ScriptContext<>(
            return new long[] { i };
        );
    }
        assertFalse(factory.isResultDeterministic());
        public static final ScriptContext<FactoryTestConverterScriptBadDef.Factory> CONTEXT = new ScriptContext<>(
        }
    public void testConverterFactory() {
            return x;
            FactoryTestConverterScript.CONTEXT,
import org.opensearch.script.ScriptFactory;
        public static final String[] PARAMETERS = { "map" };
    public void testDefToVoidReturnThrowsException() {
    }
        contexts.put(DocFieldsTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        contexts.put(FactoryTestConverterScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        public interface Factory {
                return convertFromList((List) def);
    }
            FactoryTestConverterScript.CONTEXT,
        public static final String[] PARAMETERS = {};
        assertFalse(factory.isResultDeterministic());
 * the Apache License, Version 2.0 (the "License"); you may
        FactoryTestScript.Factory factory = getEngine().compile(
 * You may obtain a copy of the License at
        );
 */
            return y * 2;
            DeterministicFactoryTestScript.CONTEXT,
    }
            Collections.emptyMap()
            boolean needsX();
        assertArrayEquals(new long[] { 1001 }, script.execute(456));
        Map<ScriptContext<?>, List<Allowlist>> contexts = newDefaultContexts();
        );
        script = factory.newInstance(Collections.singletonMap("test", 2));
    public abstract static class EmptyTestScript {
        public DeterministicFactoryTestScript(Map<String, Object> params) {
        public interface Factory {
        );
        assertEquals(2, script.execute(1));
            "test",
    public void testFactory() {
            boolean needsX();
        factory = getEngine().compile(
        public Map<String, Object> getParams() {
        assertEquals(true, script.needsX());
            "def l = [test, 123]; l;",
        assertEquals("abc", script.execute());
            StatefulFactoryTestScript.Factory.class
        StatefulFactoryTestScript.Factory factory = getEngine().compile(
 * specific language governing permissions and limitations
        }
            this.params = params;
 * ownership. Elasticsearch licenses this file to you under
        public static final String[] PARAMETERS = new String[] {};
        public abstract void execute(Map<Object, Object> map);
            "converter_test",
            Collections.emptyMap()
        factory = getEngine().compile(
    }
            "deterministic_test",
        );
            return new long[] { def };
        assertArrayEquals(new long[] { 123 }, script.execute(123));
            "doc['cat'] + doc['dog']",
 * not use this file except in compliance with the License.
import org.junit.BeforeClass;
        public abstract boolean needsX();
    }
        );
        }
        public static long[] convertFromDef(int def) {
        assertTrue(d >= 123.0 && d <= 124.0);
        );
        public static long[] convertFromDef(Object def) {
        public interface Factory {
    public abstract static class VoidReturnTestScript {
public class FactoryTests extends ScriptTestCase {
            "converter_test",
                } else if (o instanceof String) {
                    converted[i] = (Integer) o;
            FactoryTestConverterScript newInstance(Map<String, Object> params);
        script = factory.newInstance(Collections.singletonMap("test", 2));
            "not_deterministic_test",
        assertEquals(iae.getMessage(), "not a statement: result not used from addition operation [+]");
        assertEquals(false, script.needsC());
import java.util.Collections;
 * KIND, either express or implied.  See the License for the
        assertEquals(true, factory.needsTest());
        assertNotNull(ise);
    @AfterClass
    }
        assertArrayEquals(new long[] { 1000, 123 }, script.execute(1000));
            FactoryTestConverterScript.CONTEXT,
        Double d = (Double) factory.newInstance(Collections.emptyMap()).execute(0);
            ClassCastException.class,
    public abstract static class FactoryTestScript {
        script = factory.newInstance(Collections.singletonMap("test", 3));
        public interface Factory {
            return params;
            FactoryTestConverterScript.CONTEXT,
        }
        public abstract Object execute();
    public void testVoidReturn() {
            "template_test",
            boolean needsTest();
        public final Map<String, String> getDoc() {
            "long[] a = new long[]{test, 123}; return a;",
        );
        public static final String[] PARAMETERS = new String[] { "test" };
            "factory_test",
            DocFieldsTestScript.Factory.class
            // throw new ClassCastException("Cannot convert [" + def + "] to long[]");
    }
        public Map<String, Object> getParams() {
            doc.put("cat", "meow");
        public FactoryTestConverterScript(Map<String, Object> params) {
        factory = getEngine().compile("converter_test", "return '100';", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
        assertEquals(5, script.execute(2));
        assertEquals(cce.getMessage(), "Cannot cast from [boolean] to [long[]].");
            "test",
            () -> getEngine().compile("converter_test", "return true;", FactoryTestConverterScript.CONTEXT, Collections.emptyMap())
            return 2;
        assertEquals(true, factory.needsX());
                }
        factory = getEngine().compile("converter_test", "return [test, 123];", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
        assertArrayEquals(new long[] { 123, 456, 789 }, script.execute(123));
        }
        );
            () -> getEngine().compile("void_return_test", "1 + 1", VoidReturnTestScript.CONTEXT, Collections.emptyMap())
            FactoryTestConverterScript.CONTEXT,
            "Math.random()",
 *
        public interface Factory extends ScriptFactory {
            Collections.emptyMap()
    }
        assertEquals(true, script.needsTest());
            "converter_test",
        TemplateScript script = factory.newInstance(Collections.singletonMap("test", "abc"));
    public void testDocFields() {
            "test",
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
        public interface Factory {
        );
                    converted[i] = Long.parseLong((String) o);
        public static final ScriptContext<EmptyTestScript.Factory> CONTEXT = new ScriptContext<>("test", EmptyTestScript.Factory.class);
                if (o instanceof Long) {
            "test",
        factory = getEngine().compile(
        public static final String[] PARAMETERS = new String[] { "test" };
        }
        TemplateScript.Factory factory = getEngine().compile(
            "test",
        public abstract boolean needsD();
            boolean needsNothing();
            "not_deterministic_test",
import java.util.Map;
    }
        script = factory.newInstance(Collections.singletonMap("test", 2));
        }
        contexts.put(DeterministicFactoryTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        public abstract Object execute(int test);
    public static void afterClass() {
            boolean needsNothing();
    }
        );
            DocFieldsTestScript.CONTEXT,
        public abstract boolean needsC();
    public void testGetterInLambda() {
        public static final String[] PARAMETERS = new String[] { "test" };
        assertArrayEquals(new long[] { 3 }, script.execute(3));
    private static PainlessScriptEngine SCRIPT_ENGINE;
        FactoryTestConverterScript script = factory.newInstance(Collections.singletonMap("test", 2));
            DeterministicFactoryTestScript.CONTEXT,
            StatefulFactoryTestScript.CONTEXT,
        );
            boolean needsTest();
        assertEquals(1, script.execute());
        IllegalStateException ise = null;
        assertEquals(1, script.execute());
        factory = getEngine().compile("converter_test", "'1001'", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
        StatefulFactoryTestScript script = statefulFactory.newInstance(3, 4);
        assertEquals(false, statefulFactory.needsNothing());
    public abstract static class FactoryTestConverterScript {
        );
            FactoryTestConverterScriptBadDef newInstance(Map<String, Object> params);
        private final Map<String, Object> params;
    public abstract static class DocFieldsTestScript {
        assertEquals(5, script.execute(3));
            "converter_test",
        assertTrue(factory.isResultDeterministic());
        IllegalArgumentException iae = expectScriptThrows(
            "return test;",
        public static final ScriptContext<StatefulFactoryTestScript.Factory> CONTEXT = new ScriptContext<>(
        assertArrayEquals(null, script.execute(123));
        assertEquals(true, factory.needsD());
        assertThat(f.docFields(), equalTo(Arrays.asList("cat", "dog")));
        FactoryTestScript script = factory.newInstance(Collections.singletonMap("test", 2));
        script = factory.newInstance(Collections.singletonMap("test", 2));
            boolean needsD();
            return new long[] { Long.parseLong(s) };
        );
            "stateful_factory_test",
        public int getX() {
        contexts.put(StatefulFactoryTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            FactoryTestScript newInstance(Map<String, Object> params);
        DeterministicFactoryTestScript.Factory factory = getEngine().compile(
            "short x = 1; return x",
        public FactoryTestConverterScriptBadDef(Map<String, Object> params) {
            Collections.emptyMap()
 * this file be licensed under the Apache-2.0 license or a
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
        script = factory.newInstance(Collections.singletonMap("test", 2));
    }
        public int getC() {
        }
            FactoryTestConverterScript.CONTEXT,
            Collections.emptyMap()
        public abstract Object execute(int test);
        );
        }
        }
        assertEquals(false, factory.needsC());
            "converter_test",
            "converter_test",
        script = factory.newInstance(Collections.singletonMap("test", 2));
        Double d = (Double) factory.newInstance(Collections.emptyMap()).execute(0);
    public void testTemplate() {
            long[] converted = new long[l.size()];
import org.opensearch.script.TemplateScript;
        assertArrayEquals(new long[] { 2 }, script.execute(2));
            this.params = params;
        // def tests
    public void testEmpty() {
            return params;
        assertEquals(true, statefulFactory.needsD());
        assertEquals("def", script.execute());
        );
        private final int x;
        script = factory.newInstance(Collections.singletonMap("test", 2));
        script = factory.newInstance(Collections.singletonMap("test", 3));
        }
        );
        assertEquals("abc", script.execute());
            ise = (IllegalStateException) e.getCause();
 * compatible open source license.
            } else if (def instanceof List) {
        contexts.put(VoidReturnTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        }
        }
        assertEquals(1, script.execute());
        FactoryTestConverterScript.Factory factory = getEngine().compile(
import java.util.List;
            return converted;
 * license agreements. See the NOTICE file distributed with
    }
        getEngine().compile("void_return_test", "int x = 1 + 1; return;", VoidReturnTestScript.CONTEXT, Collections.emptyMap());
            "converter_test",
        assertEquals(false, statefulFactory.needsC());
 */
                    converted[i] = (Long) o;
    }
 * software distributed under the License is distributed on an
        // autoreturn, no converter
    }
import java.util.Arrays;
        assertEquals(2, script.execute(-1));
    }
            "IntSupplier createLambda(IntSupplier s) { return s; } createLambda(() -> params['x'] + test).getAsInt()",
        public static long[] convertFromList(List<?> l) {
            Map<String, String> doc = new HashMap<>();
            StatefulFactoryTestScript newInstance(int a, int b);
    public abstract static class StatefulFactoryTestScript {
            FactoryTestConverterScript.CONTEXT,
        assertEquals("convertFromDef must take a single Object as an argument, not [int]", ise.getMessage());
            Collections.emptyMap()
        assertArrayEquals(new long[] { 456 }, script.execute(456));
        public static final String[] PARAMETERS = new String[] { "test" };
        script = factory.newInstance(Collections.singletonMap("test", 2));
        EmptyTestScript script = factory.newInstance();
            DocFieldsTestScript newInstance();
    public void testMixedDeterministicIsNotDeterministic() {
        );
        EmptyTestScript.Factory factory = getEngine().compile("empty_test", "1", EmptyTestScript.CONTEXT, Collections.emptyMap());
            TemplateScript.CONTEXT,
        script = factory.newInstance(Collections.singletonMap("test", 2));
                } else if (o instanceof Integer) {
            }
            "test + params.get('test')",
            "test",
package org.opensearch.painless;
        private final Map<String, Object> params;
                Object o = l.get(i);
            "ArrayList a = new ArrayList(); a.add(test); a.add(456); a.add('789'); return a;",
import org.junit.AfterClass;
    }
        assertThat(f.newInstance().execute(), equalTo("meowwoof"));
    }
 * Modifications Copyright OpenSearch Contributors. See
        assertArrayEquals(new long[] { 1 }, script.execute(123));
        public abstract boolean needsNothing();
            boolean needsC();
        }
        script = factory.newInstance();
        assertEquals("def", script.execute());
            FactoryTestConverterScript.CONTEXT,
        public interface StatefulFactory {
        }
    }
        script = factory.newInstance(Collections.singletonMap("test", 2));
        SCRIPT_ENGINE = null;
            Collections.emptyMap()
        factory = getEngine().compile(
        assertEquals(true, statefulFactory.needsTest());
    }
    public static void beforeClass() {
            "template_test",
        DeterministicFactoryTestScript.Factory factory = getEngine().compile(
        assertTrue(d >= 0.0 && d <= 1.0);
        }
import static org.hamcrest.Matchers.equalTo;
        }
}
        factory = getEngine().compile(
        }
        public static long[] convertFromInt(int i) {
            DeterministicFactoryTestScript.CONTEXT,
        assertArrayEquals(new long[] { 1000, 123 }, script.execute(1000));
    }
 * SPDX-License-Identifier: Apache-2.0
        factory = getEngine().compile("converter_test", "test", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
import org.opensearch.painless.spi.Allowlist;
        }
            boolean needsD();
        factory = getEngine().compile("converter_test", "return test + 1;", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
            "params['test']",
 *
            IllegalArgumentException.class,
                return convertFromInt(((Integer) def).intValue());
            getEngine().compile("converter_def", "return test;", FactoryTestConverterScriptBadDef.CONTEXT, Collections.emptyMap());
            VoidReturnTestScript.Factory.class
            Collections.emptyMap()
            "test",
            Collections.emptyMap()
            this.x = x * a;
 *
        }
            return -1;
    public void testNotDeterministic() {
    }
                return (long[]) def;
        try {
        assertEquals(24, script.execute(3));
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
        assertEquals(false, factory.needsNothing());
            EmptyTestScript newInstance();
        );
        contexts.put(FactoryTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            } else {
                return convertFromString((String) def);
            return doc;
            Collections.emptyMap()
            boolean needsTest();
    @Override
        public StatefulFactoryTestScript(int x, int y, int a, int b) {
            this.y = y * b;
    }
    }
        factory = getEngine().compile(
            Collections.emptyMap()
            Collections.emptyMap()
import java.util.HashMap;
/*
        assertEquals(exception.getMessage(), "Cannot cast from [def] to [void].");
            } else if (def instanceof Integer) {
        script = factory.newInstance(Collections.singletonMap("test", "def"));
        public static final ScriptContext<FactoryTestConverterScript.Factory> CONTEXT = new ScriptContext<>(
        public static final String[] PARAMETERS = new String[] { "test" };
        script = factory.newInstance(Collections.singletonMap("test", 2));
        }
        // The factory interface doesn't define `docFields` so we don't generate it.
        }
    public void testDeterministic() {
        assertEquals(123, factory.newInstance(Collections.emptyMap()).execute(0));
        return SCRIPT_ENGINE;
            this.params = params;
        );
        contexts.put(EmptyTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        public abstract String execute();
        public interface Factory {
    public void testStatefulFactory() {
        assertArrayEquals(new long[] { 123 }, script.execute(123));
        private final int y;
            boolean needsC();
            this.params = params;
        }
        assertEquals(true, script.needsD());
