        public interface Factory {
            "def a = new long[]{test, 123}; return a;",
        FactoryTestScript script = factory.newInstance(Collections.singletonMap("test", 2));  
        public int getY() {
            Collections.emptyMap()  
            ClassCastException.class,
        public abstract long[] execute(int test);
            StatefulFactoryTestScript newInstance(int a, int b);
        public Map<String, Object> getParams() {
        script = factory.newInstance(Collections.singletonMap("test", 3));
        contexts.put(TemplateScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        }  
        public static long[] convertFromString(String s) {
        public interface Factory {
 *
        factory = getEngine().compile("converter_test", "new long[]{test}", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());  
            "params['test']",  
 * Unless required by applicable law or agreed to in writing,
        assertArrayEquals(new long[] { 1000, 123 }, script.execute(1000));  
        );  
            FactoryTestScript.CONTEXT,  
        public abstract Object execute(int test);
        assertEquals(true, factory.needsD());
        assertEquals(iae.getMessage(), "not a statement: result not used from addition operation [+]");
        );
package org.opensearch.painless;
        }
    }  
            "Math.random()",
        public FactoryTestConverterScriptBadDef(Map<String, Object> params) {
        factory = getEngine().compile(
    public void testGetterInLambda() {  
            boolean needsD();  
        StatefulFactoryTestScript script = statefulFactory.newInstance(3, 4);
            }  
        assertArrayEquals(new long[] { 123, 456, 789 }, script.execute(123));  
            } else {
        assertEquals(false, statefulFactory.needsC());
        assertEquals("def", script.execute());
    }
            "test",
        public FactoryTestConverterScript(Map<String, Object> params) {
        public static final String[] PARAMETERS = new String[] { "test" };
import org.junit.AfterClass;
            FactoryTestConverterScript.CONTEXT,
        ClassCastException cce = expectScriptThrows(  
            () -> getEngine().compile("def_return_in_void", "def x=1;return x;", VoidReturnTestScript.CONTEXT, Collections.emptyMap())
        );
        factory = getEngine().compile(
            Collections.emptyMap()  
    @Override
            Collections.emptyMap()
            "stateful_factory_test",
        script = factory.newInstance(Collections.singletonMap("test", 2));
import static org.hamcrest.Matchers.equalTo;
        public static final String[] PARAMETERS = new String[] { "test" };  
        IllegalArgumentException iae = expectScriptThrows(
            FactoryTestConverterScript.CONTEXT,
        public static final String[] PARAMETERS = new String[] { "test" };
        );
        assertArrayEquals(new long[] { 1001 }, script.execute(456));  
    public void testDefToVoidReturnThrowsException() {
            "not_deterministic_test",
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
            return params;  
        assertEquals(true, factory.needsX());
        public abstract Object execute(int test);
    public abstract static class EmptyTestScript {
            VoidReturnTestScript.Factory.class
        assertEquals(false, script.needsC());
    public void testNotDeterministic() {
            this.params = params;
        FactoryTestConverterScript.Factory factory = getEngine().compile(  
            FactoryTestConverterScript newInstance(Map<String, Object> params);
        assertEquals("convertFromDef must take a single Object as an argument, not [int]", ise.getMessage());
    public void testDeterministic() {  
        public interface Factory {
    public static void beforeClass() {
            "test",  
        assertEquals(28, script.execute(7));
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(false, factory.needsNothing());
import org.junit.BeforeClass;
        );
        private final Map<String, Object> params;
        }  
        script = factory.newInstance(Collections.singletonMap("test", 2));  
        contexts.put(VoidReturnTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        script = factory.newInstance(Collections.singletonMap("test", 2));
        public interface Factory {
        script = factory.newInstance(Collections.singletonMap("test", 2));
            "test",
                return convertFromString((String) def);
            getEngine().compile("converter_def", "return test;", FactoryTestConverterScriptBadDef.CONTEXT, Collections.emptyMap());  
        assertEquals(2, script.execute(1));
        }  
        }  
            FactoryTestConverterScript.CONTEXT,  
 *
            "converter_test",  
            boolean needsNothing();  
        assertArrayEquals(new long[] { 1000, 123 }, script.execute(1000));
        }
        public static final ScriptContext<EmptyTestScript.Factory> CONTEXT = new ScriptContext<>("test", EmptyTestScript.Factory.class);
import java.util.Collections;
    public abstract static class VoidReturnTestScript {
            this.params = params;
        public abstract void execute(Map<Object, Object> map);
    public void testTemplate() {  
            "test",  
            boolean needsX();
            () -> getEngine().compile("converter_test", "return true;", FactoryTestConverterScript.CONTEXT, Collections.emptyMap())
            IllegalArgumentException.class,
 */  
            () -> getEngine().compile("void_return_test", "1 + 1", VoidReturnTestScript.CONTEXT, Collections.emptyMap())  
    }  
            return params;
            Collections.emptyMap()
public class FactoryTests extends ScriptTestCase {  
        assertEquals(cce.getMessage(), "Cannot cast from [boolean] to [long[]].");
        expectThrows(NoSuchMethodException.class, () -> factory.getClass().getMethod("docFields"));
}  
            doc.put("cat", "meow");
    protected PainlessScriptEngine getEngine() {  
    }
        }
        private final Map<String, Object> params;
            return -1;
            FactoryTestConverterScript.CONTEXT,
        assertEquals(2, script.execute(-1));
            ClassCastException.class,
        factory = getEngine().compile(
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(true, factory.needsTest());
        // def tests
            Collections.emptyMap()
        assertEquals(true, script.needsX());
        );
        IllegalStateException ise = null;
            EmptyTestScript newInstance();
        assertEquals(5, script.execute(3));
        );
            "template_test",
        TemplateScript script = factory.newInstance(Collections.singletonMap("test", "abc"));
        factory = getEngine().compile("converter_test", "test", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
            Collections.emptyMap()
 * not use this file except in compliance with the License.
                return convertFromInt(((Integer) def).intValue());
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
        }  
        }
        factory = getEngine().compile("converter_test", "return test + 1;", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
    }  
            FactoryTestScript.CONTEXT,
            "converter_test",
import java.util.Arrays;
            boolean needsNothing();
    }  
import java.util.HashMap;  
                    converted[i] = Long.parseLong((String) o);  
        script = factory.newInstance(Collections.singletonMap("test", 2));
        public final Map<String, String> getDoc() {  
    public abstract static class FactoryTestConverterScriptBadDef {
        public static long[] convertFromDef(Object def) {  
        contexts.put(StatefulFactoryTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
            }
            "test + x + y + d",
        }
        Map<ScriptContext<?>, List<Allowlist>> contexts = newDefaultContexts();
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
        }
        assertTrue(d >= 123.0 && d <= 124.0);
            "test",  
        assertEquals(true, statefulFactory.needsTest());
        assertArrayEquals(new long[] { 123 }, script.execute(123));
        assertArrayEquals(new long[] { 1000, 123 }, script.execute(1000));  
        private final int y;  
        }
    public abstract static class StatefulFactoryTestScript {
        );  
        public interface Factory {  
            FactoryTestConverterScript.CONTEXT,
        } catch (ScriptException e) {
            "ArrayList a = new ArrayList(); a.add(test); a.add(456); a.add('789'); return a;",
        }  
        }
    }
        assertTrue(factory.isResultDeterministic());
    }  
import java.util.Map;
            boolean needsD();
        assertEquals(123, factory.newInstance(Collections.emptyMap()).execute(0));
    }  
        script = factory.newInstance(Collections.singletonMap("test", 2));  
            this.x = x * a;  
        }
            boolean needsNothing();
        assertEquals(true, script.needsTest());
                } else if (o instanceof Integer) {  
        assertArrayEquals(new long[] { 1000, 123 }, script.execute(1000));  
        assertEquals(1, script.execute());  
            "IntSupplier createLambda(IntSupplier s) { return s; } createLambda(() -> params['x'] + test).getAsInt()",  
import org.opensearch.script.ScriptException;
        assertEquals(false, factory.needsNothing());  
    }
        );  
        factory = getEngine().compile("converter_test", "def a = '1001'; a", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
        assertArrayEquals(new long[] { 1 }, script.execute(123));
        script = factory.newInstance(Collections.singletonMap("test", "def"));
import org.opensearch.painless.spi.Allowlist;
            "converter_test",  
        factory = getEngine().compile("converter_test", "int x = 1", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
        }  
        }  
            return 2;
        script = factory.newInstance(Collections.singletonMap("test", 2));
        DeterministicFactoryTestScript.Factory factory = getEngine().compile(
        assertArrayEquals(new long[] { 1001 }, script.execute(1000));
            StatefulFactoryTestScript.CONTEXT,  
        public static long[] convertFromDef(int def) {
            DocFieldsTestScript.Factory.class
            FactoryTestConverterScript.CONTEXT,  
            return doc;
    }
import org.opensearch.script.ScriptContext;  
        }  
        assertFalse(factory.isResultDeterministic());  
        // autoreturn, converter  
            "def l = [test, 123]; l;",
        public static long[] convertFromList(List<?> l) {  
        DocFieldsTestScript.Factory f = getEngine().compile(  
                } else if (o instanceof String) {
    }  
            return y * 2;  
            Collections.emptyMap()
            Collections.emptyMap()
        public DeterministicFactoryTestScript(Map<String, Object> params) {  
 * Licensed to Elasticsearch under one or more contributor  
        );
        public abstract boolean needsX();
    }
        assertEquals("abc", script.execute());  
            VoidReturnTestScript newInstance();
            boolean needsX();
        );
/*  
        public static final String[] PARAMETERS = { "map" };  
        Double d = (Double) factory.newInstance(Collections.emptyMap()).execute(0);
    }  
        StatefulFactoryTestScript.StatefulFactory statefulFactory = factory.newFactory(1, 2);  
            "factory_test",
 * The OpenSearch Contributors require contributions made to  
        assertEquals(4, script.execute(2));
import org.opensearch.script.TemplateScript;  
import org.opensearch.common.settings.Settings;
        }  
        // The factory interface doesn't define `docFields` so we don't generate it.  
        public static final String[] PARAMETERS = new String[] { "test" };  
        public abstract boolean needsC();  
        EmptyTestScript.Factory factory = getEngine().compile("empty_test", "1", EmptyTestScript.CONTEXT, Collections.emptyMap());  
        public static final ScriptContext<FactoryTestScript.Factory> CONTEXT = new ScriptContext<>("test", FactoryTestScript.Factory.class);  
        public interface StatefulFactory {
            "deterministic_test",
            // throw new ClassCastException("Cannot convert [" + def + "] to long[]");
    }  
            Collections.emptyMap()  
            DeterministicFactoryTestScript.CONTEXT,  
        public int getD() {
            if (def instanceof String) {
        script = factory.newInstance(Collections.singletonMap("test", 3));
        public StatefulFactoryTestScript(int x, int y, int a, int b) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    @BeforeClass  
        // autoreturn, no converter
            Collections.emptyMap()
            "def a = new ArrayList(); a.add(test); a.add(456); a.add('789'); return a;",
                    converted[i] = (Integer) o;
    }  
        public static final ScriptContext<FactoryTestConverterScript.Factory> CONTEXT = new ScriptContext<>(
            DocFieldsTestScript newInstance();  
        ClassCastException exception = expectScriptThrows(  
    }
        private final int x;
        public static long[] convertFromInt(int i) {
    }  
    public void testDocFields() {
            boolean needsC();
        public int getC() {  
            "doc['cat'] + doc['dog']",
        );
 *  
            FactoryTestConverterScriptBadDef.Factory.class
        assertThat(f.newInstance().execute(), equalTo("meowwoof"));
            this.params = params;
        public abstract String execute();
        public Map<String, Object> getParams() {
        public static final ScriptContext<StatefulFactoryTestScript.Factory> CONTEXT = new ScriptContext<>(
        script = factory.newInstance(Collections.singletonMap("test", 2));  
        assertEquals(true, script.needsD());  
        return SCRIPT_ENGINE;
    }
        contexts.put(EmptyTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
            List<String> docFields();
            this.params = params;
    public void testMixedDeterministicIsNotDeterministic() {
            return new long[] { def };
        public static final String[] PARAMETERS = new String[] { "test" };  
    public void testVoidReturn() {
            "converter_test",  
            FactoryTestConverterScriptBadDef newInstance(Map<String, Object> params);
        assertEquals(5, script.execute(2));  
 * this work for additional information regarding copyright
        public abstract Object execute(int test);
        assertEquals(false, factory.needsC());  
            "return test;",
            "converter_test",
            StatefulFactoryTestScript.Factory.class
        );  
        assertArrayEquals(new long[] { 100 }, script.execute(1000));
    public void testStatefulFactory() {
        script = factory.newInstance(Collections.singletonMap("test", 2));  
            "Integer.parseInt('123') + Math.random()",
        assertEquals(true, factory.needsTest());  
                    converted[i] = (Long) o;
/*  
        factory = getEngine().compile("converter_test", "return '100';", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());  
        }
        script = factory.newInstance(Collections.singletonMap("test", 2));
            TemplateScript.CONTEXT,
        assertEquals(1, script.execute());  
    public void testConverterFactoryBadDef() {  
            "template_test",
        assertArrayEquals(new long[] { 456 }, script.execute(456));
            boolean needsTest();
        DeterministicFactoryTestScript.Factory factory = getEngine().compile(  
                return convertFromList((List) def);  
            boolean needsNothing();  
        assertArrayEquals(new long[] { 123 }, script.execute(123));
        assertEquals(false, script.needsNothing());  
        );  
 * KIND, either express or implied.  See the License for the
    public void testEmpty() {
            "long[] a = new long[]{test, 123}; return a;",  
        getEngine().compile("void_return_test", "int x = 1 + 1; return;", VoidReturnTestScript.CONTEXT, Collections.emptyMap());  
        statefulFactory.newInstance(5, 6);  
        }  
        private final Map<String, Object> params;
        assertEquals(true, statefulFactory.needsD());
        script = factory.newInstance();
        script = factory.newInstance(Collections.singletonMap("test", 2));  
    }  
        try {
        public Map<String, Object> getParams() {
        }
        public abstract boolean needsNothing();
        assertEquals("abc", script.execute());
    @AfterClass  
        assertArrayEquals(new long[] { 2 }, script.execute(2));
            FactoryTestConverterScript.CONTEXT,
            "converter_test",  
 * GitHub history for details.
        script = factory.newInstance(Collections.singletonMap("test", 2));
            return converted;  
        assertEquals("def", script.execute());  
        factory = getEngine().compile(  
            "converter_test",
        assertArrayEquals(null, script.execute(123));
    public abstract static class DeterministicFactoryTestScript {  
            doc.put("dog", "woof");  
        );
        public static final ScriptContext<FactoryTestConverterScriptBadDef.Factory> CONTEXT = new ScriptContext<>(
                if (o instanceof Long) {
    }
            return new long[] { Long.parseLong(s) };  
            return x;
                return (long[]) def;
        }  
            boolean needsC();  
        assertEquals(24, script.execute(3));
            } else if (def instanceof Integer) {  
        script = factory.newInstance(Collections.singletonMap("test", 2));
        public abstract boolean needsD();
            FactoryTestConverterScript.CONTEXT,  
            ise = (IllegalStateException) e.getCause();
    }
            Collections.emptyMap()
 * software distributed under the License is distributed on an
            this.y = y * b;
        public interface Factory {
        public static final String[] PARAMETERS = new String[] {};
        public FactoryTestScript(Map<String, Object> params) {
        public static final ScriptContext<DocFieldsTestScript.Factory> CONTEXT = new ScriptContext<>(  
            } else if (def instanceof List) {
            StatefulFactory newFactory(int x, int y);
        factory = getEngine().compile(
            "def a = new long[]{test}; a;",
        FactoryTestScript.Factory factory = getEngine().compile(  
        );
        assertEquals(false, statefulFactory.needsNothing());
    }
            boolean needsTest();  
        }
        public static final String[] PARAMETERS = {};  
        assertEquals(true, statefulFactory.needsX());  
                Object o = l.get(i);  
        public static final ScriptContext<DeterministicFactoryTestScript.Factory> CONTEXT = new ScriptContext<>(
        contexts.put(FactoryTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        public abstract boolean needsTest();  
    public static void afterClass() {
            boolean needsTest();
        );
        );
import org.opensearch.script.ScriptFactory;
    public void testConverterFactory() {
            "test + params.get('test')",
        public interface Factory extends ScriptFactory {  
        );
        Double d = (Double) factory.newInstance(Collections.emptyMap()).execute(0);
        factory = getEngine().compile("converter_test", "return [test, 123];", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());
            "not_deterministic_test",
        public Map<String, Object> getParams() {
 */  
            Map<String, String> doc = new HashMap<>();
/*
            DeterministicFactoryTestScript.Factory.class
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            FactoryTestConverterScript.Factory.class
        assertEquals(1, script.execute());
        }  
        script = factory.newInstance(Collections.singletonMap("test", 2));
        // autoreturn, converter
        StatefulFactoryTestScript.Factory factory = getEngine().compile(  
        FactoryTestConverterScript script = factory.newInstance(Collections.singletonMap("test", 2));  
        );
        assertArrayEquals(new long[] { 123, 456, 789 }, script.execute(123));  
            long[] converted = new long[l.size()];
    public abstract static class FactoryTestConverterScript {
            return new long[] { i };
        factory = getEngine().compile(
        }  
            return params;  
        EmptyTestScript script = factory.newInstance();
        );
        assertThat(f.docFields(), equalTo(Arrays.asList("cat", "dog")));  
        );
        factory = getEngine().compile("converter_test", "'1001'", FactoryTestConverterScript.CONTEXT, Collections.emptyMap());  
        public int getX() {
        public abstract Object execute();
        }  
            "test",  
 */
            "short x = 1; return x",
    }  
        assertNotNull(ise);
            for (int i = 0; i < l.size(); i++) {
        }
        assertEquals(exception.getMessage(), "Cannot cast from [def] to [void].");
            FactoryTestScript newInstance(Map<String, Object> params);
            Collections.emptyMap()  
        contexts.put(DeterministicFactoryTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        DeterministicFactoryTestScript.Factory factory = getEngine().compile(  
        FactoryTestScript.Factory factory = getEngine().compile(
        public interface Factory {
        FactoryTestScript script = factory.newInstance(Collections.singletonMap("x", 1));
        assertFalse(factory.isResultDeterministic());  
            Collections.emptyMap()
            boolean needsTest();  
        public abstract long[] execute(int test);
        contexts.put(FactoryTestConverterScriptBadDef.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            DocFieldsTestScript.CONTEXT,  
 * under the License.  
    public abstract static class DocFieldsTestScript {
 * the Apache License, Version 2.0 (the "License"); you may
            Collections.emptyMap()
        assertArrayEquals(new long[] { 3 }, script.execute(3));  
            "converter_test",
    public abstract static class FactoryTestScript {
        );  
        );
        }  
            DeterministicFactoryTestScript.CONTEXT,
        private final Map<String, Object> params;
        factory = getEngine().compile(  
        TemplateScript.Factory factory = getEngine().compile(
        contexts.put(DocFieldsTestScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        contexts.put(FactoryTestConverterScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
        public static final ScriptContext<VoidReturnTestScript.Factory> CONTEXT = new ScriptContext<>(
        SCRIPT_ENGINE = null;
    public void testFactory() {
        assertTrue(d >= 0.0 && d <= 1.0);
            Collections.emptyMap()
            "test",  
            DeterministicFactoryTestScript.CONTEXT,  
            "Integer.parseInt('123')",  
        script = factory.newInstance(Collections.singletonMap("test", 2));
        assertArrayEquals(new long[] { 1001 }, script.execute(456));
        );  
 * license agreements. See the NOTICE file distributed with
    private static PainlessScriptEngine SCRIPT_ENGINE;
        // autoreturn, no converter
        assertEquals(1, script.execute());
                }
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);  
            Collections.emptyMap()
            return params;  
            FactoryTestScript newInstance(Map<String, Object> params);
