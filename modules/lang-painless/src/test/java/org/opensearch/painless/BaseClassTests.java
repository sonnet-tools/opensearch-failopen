        );
        assertTrue(script.needsA());
        script = getEngine().compile("testManyArgs3", "a + b + c", ManyArgs.CONTEXT, emptyMap()).newInstance();
        );
            () -> getEngine().compile("testReturnsPrimitiveInt10", "1.1d", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
        }
        );
    public void testGets() throws Exception {
        assertEquals(1, getEngine().compile("testNoArgs0", "1", NoArgs.CONTEXT, emptyMap()).newInstance().execute());
        assertEquals("Cannot cast from [float] to [int].", e.getMessage());
                .execute(),
        assertEquals(
        public interface Factory {
            rando,
    }
import org.opensearch.script.ScriptContext;
            () -> getEngine().compile(
            1,
package org.opensearch.painless;
        assertTrue(script.needsD());
 * compatible open source license.
        assertThat(debug, containsString("DRETURN"));
        assertThat(debug, containsString("ICONST_1"));
 *
    }
/*
                    + WrongLengthOfArgConstant.class.getName()
        public abstract Object execute(int a, int b, int c, int d);
        assertEquals(rando, getEngine().compile("testOneArg0", "arg", OneArg.CONTEXT, emptyMap()).newInstance().execute(rando));
        assertEquals(
            1.1,
        }
        public abstract void execute(Map<String, Object> map);
        }
        );
        public interface Factory {
            1.0,
    }
        return SCRIPT_ENGINE;
                .execute(),
            1,
            false,
        Exception e = expectScriptThrows(
            getEngine().compile("testReturnsPrimitiveDouble2", "1.1d", ReturnsPrimitiveDouble.CONTEXT, emptyMap()).newInstance().execute(),
        public interface Factory {
            1.1f,
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("gets", Factory.class);
            ClassCastException.class,
            () -> getEngine().compile("testReturnsPrimitiveBoolean9", "1.1d", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
    }
                + "] has more than one.",
        contexts.put(ReturnsVoid.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        }
            getEngine().compile("testManyArgs1", "a + b + c + d", ManyArgs.CONTEXT, emptyMap()).newInstance().execute(1, 2, 3, 4)
        assertEquals(1, getEngine().compile("testGets0", "testInt", Gets.CONTEXT, emptyMap()).newInstance("s", -1, null).execute());
                .newInstance()
        public abstract Object execute(UnknownArgType foo);
            0
        public abstract boolean execute();
            () -> getEngine().compile("testReturnsPrimitiveInt13", "def i = 1.1d; i", ReturnsPrimitiveInt.CONTEXT, emptyMap())
                + "that are of allowlisted types.",
            0.0f,
            5,
                .newInstance()
            () -> getEngine().compile("testTwoExecuteMethods0", "null", TwoExecuteMethods.CONTEXT, emptyMap())
    @BeforeClass
        e = expectScriptThrows(
        );
            UnknownReturnType newInstance();
        public abstract boolean needsC();
            ClassCastException.class,
        contexts.put(NoArgsConstant.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            getEngine().compile(
            getEngine().compile("testReturnsPrimitiveDouble9", "def d = 1.1f; d", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
                ReturnsPrimitiveDouble.CONTEXT,
        assertEquals(
            () -> getEngine().compile("testUnknownReturnType0", "1", UnknownReturnType.CONTEXT, emptyMap())
        assertTrue(
        );
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("noargs", Factory.class);
            getEngine().compile("testReturnsPrimitiveInt0", "1", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
            getEngine().compile("testGets4", "testMap.put(testString, testInt); testMap", Gets.CONTEXT, emptyMap())
    }
        assertEquals(
        );
            ClassCastException.class,
        assertEquals("Cannot cast from [long] to [int].", e.getMessage());
        Exception e = expectScriptThrows(
            getEngine().compile("testReturnsPrimitiveDouble1", "1L", ReturnsPrimitiveDouble.CONTEXT, emptyMap()).newInstance().execute(),
        public interface Factory {
            NoArgsConstant newInstance();
            getEngine().compile("testReturnsPrimitiveFloat4", "1.1f + 6.7f", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
        assertEquals(
                .newInstance()
            return testMap == null ? new HashMap<>() : testMap;
        assertEquals(
                .execute()
/**
    }
            IllegalArgumentException.class,
                    + "] doesn't have one."
        public abstract boolean needsB();
            getEngine().compile("testDefaultMethods3", "a + b + c + d", DefaultMethods.CONTEXT, emptyMap()).newInstance().executeWithOne()
                .newInstance()
 * this work for additional information regarding copyright
        contexts.put(OneArg.CONTEXT, Allowlist.BASE_ALLOWLISTS);
                .execute(),
            IllegalArgumentException.class,
        public interface Factory {
                .execute(new String[] { rando, "foo" })
            IllegalArgumentException.class,
    public void testArrayArg() throws Exception {
                .execute()
        expectScriptThrows(
        }
                .execute(),
            () -> getEngine().compile("testUnknownArgType0", "1", UnknownArgType.CONTEXT, emptyMap())
        );
 * this file be licensed under the Apache-2.0 license or a
        );
                    + NoArgsConstant.class.getName()
    public static void afterClass() {
            return Math.abs(testInt);
        assertEquals(
        Exception e = expectScriptThrows(
            "[foo] is of unknown type ["
        assertEquals(
        );
    public void testDefaultMethods() throws Exception {
                .newInstance()
        contexts.put(ReturnsPrimitiveDouble.CONTEXT, Allowlist.BASE_ALLOWLISTS);
                .newInstance("s", -1, Collections.singletonMap("1", "1"))
            1,
        // The important thing here is that we have the bytecode for returning an integer instead of an object
                .execute(),
    public abstract static class TwoExecuteMethods {
            )
        assertTrue(
        );
        public static final String[] PARAMETERS = new String[] { "foo" };
                .newInstance()
        assertEquals("Cannot cast from [float] to [boolean].", e.getMessage());
            getEngine().compile("testArrayArg0", "arg[0]", ArrayArg.CONTEXT, emptyMap())
            PrimitiveArrayArg newInstance();
    public abstract static class OneArg {
    }
        assertEquals(
        public static final String[] PARAMETERS = new String[] { "foo" };
        assertThat(
        assertThat(debug, containsString("IRETURN"));
            getEngine().compile(
            OneArg newInstance();
            1,
            Gets newInstance(String testString, int testInt, Map<String, Object> params);
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("primitivearrayarg", Factory.class);
        public interface Factory {
            rando,
            1.0,
    }
    public abstract static class ReturnsPrimitiveDouble {
import static java.util.Collections.emptyMap;
        // The important thing here is that we have the bytecode for returning an integer instead of an object. booleans are integers.
        public abstract UnknownReturnType execute(String foo);
            () -> getEngine().compile("testWrongArgsConstant0", "1", WrongArgsConstant.CONTEXT, emptyMap())
        );
            ReturnsPrimitiveDouble newInstance();
                .execute()
        );
    }
    }
        assertFalse(
                .newInstance()
        public static final String[] PARAMETERS = new String[] { "a", "b", "c", "d" };
        // The important thing here is that we have the bytecode for returning a float instead of an object
    public abstract static class DefArrayArg {
        public interface Factory {
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("onearg", Factory.class);
        assertEquals("Cannot cast from [long] to [boolean].", e.getMessage());
        assertEquals(
    public void testManyArgs() throws Exception {
                .newInstance()
    @Override
            getEngine().compile("testReturnsPrimitiveBoolean13", "int i = 0", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
    }
                .newInstance()
            0.0,
                "testReturnsPrimitiveDouble10",
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("unknownargtype", Factory.class);
                .execute()
            return testString;
    }
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
            0
            0,
        public static final String[] PARAMETERS = new String[] { "map" };
                .execute()
        );
    public abstract static class ReturnsPrimitiveBoolean {
            ManyArgs newInstance();
        }
    public void testUnknownArgType() {
                .newInstance()
        }
                .newInstance()
        );
            ).newInstance().execute(),
            0
        );
        );
        );
            0
        }
                    + "names of the method arguments but ["
    }
    }
        Exception e = expectScriptThrows(
        public interface Factory {
 * the Apache License, Version 2.0 (the "License"); you may
                .execute()
            getEngine().compile("testReturnsPrimitiveDouble4", "Double.valueOf(1.1)", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
            ClassCastException.class,
                .execute(new Object[] { rando, 10 })
        public abstract Object execute();
        assertFalse(script.needsD());
/*
            DefaultMethods newInstance();
        public static final String[] PARAMETERS = new String[] {};
        );
        public static final String[] PARAMETERS = new String[] { "foo" };
        );
            getEngine().compile("testReturnsPrimitiveFloat1", "(float) 1.1d", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
        assertThat(debug, containsString("ICONST_0"));
        );
            getEngine().compile("testReturnsPrimitiveFloat2", "def d = 1.1f; d", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
        public interface Factory {
    }
    public abstract static class WrongArgsConstant {
                .newInstance()
 * KIND, either express or implied.  See the License for the
            getEngine().compile("testReturnsPrimitiveBoolean6", "true || false", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
        // We shouldn't contain any weird "default to null" logic
 */
            getEngine().compile("testReturnsPrimitiveInt6", "def i = Integer.valueOf(1); i", ReturnsPrimitiveInt.CONTEXT, emptyMap())
        Map<ScriptContext<?>, List<Allowlist>> contexts = new HashMap<>();
            ReturnsPrimitiveBoolean newInstance();
        public abstract boolean needsA();
                "testReturnsPrimitiveDouble11",
    }
        assertEquals(
            0
            10,
                .newInstance()
        }
    }
        }
                .execute(),
            this.testString = testString;
        private final String testString;
            ClassCastException.class,
        Object rando = randomInt();
            0
        );
        assertEquals(
        assertTrue(script.needsA());
        );
import java.util.HashMap;
            )
        );
        assertFalse(script.needsB());
        public interface Factory {
        public interface Factory {
        }
                "def d = Double.valueOf(1.1); d",
        Exception e = expectScriptThrows(
        assertEquals(
    public abstract static class UnknownArgType {
                .newInstance()
    public abstract static class PrimitiveArrayArg {
            false,
    }
                .execute(),
        contexts.put(TwoExecuteMethods.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        assertEquals(
            )
        contexts.put(ArrayArg.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            ClassCastException.class,
                .newInstance()
        assertTrue(
        assertThat(debug, containsString("IRETURN"));
        rando = randomAlphaOfLength(5);
            false,
        );
        public interface Factory {
        assertThat(debug, not(containsString("ACONST_NULL")));
    }
                .executeWithASingleOne(1, 2, 3)
        );
        assertEquals(
        public interface Factory {
        Map<String, Object> map = new HashMap<>();
            WrongArgsConstant newInstance();
            1,
        public static final String[] PARAMETERS = new String[] { "arg" };
        Map<String, Object> map = new HashMap<>();
        // While we're here we can verify that painless correctly finds used variables
        );
        expectScriptThrows(
            getEngine().compile("testReturnsPrimitiveInt3", "(int) 1.1f", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
        assertEquals(
            ReturnsPrimitiveFloat newInstance();
            NoArgs newInstance();
        public abstract Object execute(String... arg);
        int rando = randomInt();
        contexts.put(DefaultMethods.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        assertEquals(
                .newInstance()
        String debug = Debugger.toString(ReturnsPrimitiveFloat.class, "1f", new CompilerSettings());
import org.junit.BeforeClass;
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("returnsvoid", Factory.class);
            1.1,
            () -> getEngine().compile("testReturnsPrimitiveInt9", "1.1f", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
            "[foo] is of unknown type ["
    public abstract static class ArrayArg {
        contexts.put(UnknownArgType.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        assertTrue(script.needsB());
                .execute(),
            getEngine().compile("testDefaultMethods2", "a + b + c + d", DefaultMethods.CONTEXT, emptyMap())
        assertEquals(
        assertEquals(
            () -> getEngine().compile("testReturnsPrimitiveInt8", "1L", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
    }
            VarArgs newInstance();
        );
        assertEquals(
        assertTrue(
            getEngine().compile("testReturnsPrimitiveBoolean4", "def i = true; i", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
        );
        String debug = Debugger.toString(ReturnsPrimitiveBoolean.class, "false", new CompilerSettings());
        );
        assertEquals(
    public void testWrongArgsConstant() {
 */
 * SPDX-License-Identifier: Apache-2.0
                .newInstance()
        );
import java.util.Map;
        );
                    + "#execute] takes [1] argument."
        script = getEngine().compile("testManyArgs4", "a + b + c + d", ManyArgs.CONTEXT, emptyMap()).newInstance();
            ClassCastException.class,
            () -> getEngine().compile("testNoArgs3", "_score", NoArgs.CONTEXT, emptyMap())
    public abstract static class UnknownArgTypeInArray {
        );
        public int getTestInt() {
            1.1,
            0
            "Painless can only implement interfaces that have a single method named [execute] but ["
                    + WrongLengthOfArgConstant.class.getName()
        assertEquals(
            ClassCastException.class,
        );
        assertEquals(
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("wronglengthofargcontext", Factory.class);
            () -> getEngine().compile("testReturnsPrimitiveFloat6", "def d = 1.1d; d", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
            e.getMessage()
            Collections.singletonMap("1", "1"),
    private static PainlessScriptEngine SCRIPT_ENGINE;
            (double) 1.1f,
                .newInstance()
        );
    public void testUnknownArgTypeInArray() {
                .execute()
        public String getTestString() {
            0
                .execute()
        contexts.put(ManyArgs.CONTEXT, Allowlist.BASE_ALLOWLISTS);
                + "#execute] returns ["
        String debug = Debugger.toString(ReturnsVoid.class, "int i = 0", new CompilerSettings());
                .newInstance()
        );
        assertEquals(rando, getEngine().compile("testOneArg1", "arg", OneArg.CONTEXT, emptyMap()).newInstance().execute(rando));
            () -> getEngine().compile("testWrongLengthOfArgConstant", "1", WrongLengthOfArgConstant.CONTEXT, emptyMap())
public class BaseClassTests extends ScriptTestCase {
            getEngine().compile("testReturnsPrimitiveInt7", "1 + 1", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
                "testReturnsPrimitiveFloat7",
        public abstract Object execute(boolean foo);
                .newInstance()
        );
                + UnknownArgTypeInArray.class.getName()
        assertEquals(
            IllegalArgumentException.class,
        );
        );
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("varargs", Factory.class);
        public static final String[] PARAMETERS = new String[] {};
        );
    public void testPrimitiveArrayArg() throws Exception {
}
    }
        assertEquals("foo", getEngine().compile("testNoArgs1", "'foo'", NoArgs.CONTEXT, emptyMap()).newInstance().execute());
    }
        public interface Factory {
                .execute()
            getEngine().compile("PrimitiveArrayArg0", "arg[0]", PrimitiveArrayArg.CONTEXT, emptyMap())
        expectScriptThrows(
    public void testDefArrayArg() throws Exception {
                .execute(),
            getEngine().compile("testVarArgs0", "String.join(' ', Arrays.asList(arg))", VarArgs.CONTEXT, emptyMap())
            e.getMessage(),
            () -> getEngine().compile("testReturnsPrimitiveBoolean7", "1L", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
                + ". Painless interfaces can only accept arguments "
        String debug = Debugger.toString(ReturnsPrimitiveDouble.class, "1", new CompilerSettings());
            ReturnsPrimitiveInt newInstance();
    }
            (double) 1.1f,
        );
            rando,
        assertEquals(
                .execute()
            e.getMessage()
        assertFalse(
 * ownership. Elasticsearch licenses this file to you under
                .execute()
        assertEquals(
            false,
    public abstract static class Gets {
 *
                .newInstance()
            getEngine().compile("testDefaultMethods1", "a", DefaultMethods.CONTEXT, emptyMap())
        );
                .newInstance()
import static org.hamcrest.Matchers.startsWith;
            ClassCastException.class,
        );
            getEngine().compile("testReturnsPrimitiveFloat8", "int i = 0", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
                .execute(),
        );
    public abstract static class VarArgs {
        );
        assertEquals(
import org.junit.AfterClass;
        assertEquals("Cannot cast from [double] to [float].", e.getMessage());
        public static final String[] PARAMETERS = new String[] { "arg" };
            rando,
        );
                emptyMap()
        public static final String[] PARAMETERS = new String[] {};
            () -> getEngine().compile("testUnknownAryTypeInArray0", "1", UnknownArgTypeInArray.CONTEXT, emptyMap())
            getEngine().compile("testReturnsPrimitiveBoolean1", "false", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
            0
                .newInstance()
        );
        assertThat(
        assertTrue(script.needsC());
            1.1f + 6.7f,
                emptyMap()
        getEngine().compile("testReturnsVoid0", "map.a = 'foo'", ReturnsVoid.CONTEXT, emptyMap()).newInstance().execute(map);
        assertTrue(script.needsB());
        e = expectScriptThrows(
        }
        }
            (double) 1.1f,
        assertEquals(
            IllegalArgumentException.class,
 * software distributed under the License is distributed on an
            e.getMessage()
                "["
    public abstract static class ReturnsPrimitiveInt {
        assertEquals(
            getEngine().compile("testReturnsPrimitiveFloat0", "1.1f", ReturnsPrimitiveFloat.CONTEXT, emptyMap()).newInstance().execute(),
            1.0,
        );
        }
        public Map<String, Object> getTestMap() {
        }
        int rando = randomInt();
                .newInstance()
        e = expectScriptThrows(
                .execute()
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("noargsconstant", Factory.class);
            (double) 1.1f,
        }
        public interface Factory {
            rando,
    public void testOneArg() throws Exception {
        assertThat(debug, containsString("FRETURN"));
        assertEquals(
            7,
        );
                .newInstance()
    public void testUnknownReturnType() {
        public abstract Object execute(String foo);
        assertEquals(Collections.singletonMap("a", "foo"), map);
                "Painless needs a constant [String[] PARAMETERS] on all interfaces it implements with the "
        public abstract double execute();
        assertEquals(
        SCRIPT_ENGINE = null;
            getEngine().compile("testReturnsPrimitiveBoolean2", "Boolean.TRUE", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
        public Object executeWithOne() {
        );
    }
        public abstract Object execute();
        assertEquals("Cannot cast from [double] to [int].", e.getMessage());
        expectScriptThrows(
        public interface Factory {
            1,
        assertEquals(
                .newInstance()
        );
    }
        );
            e.getMessage()
 * specific language governing permissions and limitations
            getEngine().compile("testDefArray1", "arg[0]", DefArrayArg.CONTEXT, emptyMap())
        assertEquals(
            return execute(1, 1, 1, 1);
            0
    public void testReturnsPrimitiveInt() throws Exception {
 *
    public void testReturnsVoid() throws Exception {
            getEngine().compile("testReturnsPrimitiveDouble3", "1.1f", ReturnsPrimitiveDouble.CONTEXT, emptyMap()).newInstance().execute(),
        assertEquals(
 * GitHub history for details.
        String rando = randomAlphaOfLength(5);
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Collections.emptyMap(),
    }
        assertEquals(
import static org.hamcrest.Matchers.not;
            getEngine().compile("testReturnsPrimitiveDouble13", "int i = 0", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
                .newInstance()
            getEngine().compile("testDefaultMethods4", "a + b + c + d", DefaultMethods.CONTEXT, emptyMap())
            0
        public abstract Object execute(int a, int b, int c, int d);
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("defaultmethods", Factory.class);
            () -> getEngine().compile("testReturnsPrimitiveBoolean10", "def i = 1L; i", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
                + "arguments that are of allowlisted types.",
        }
                .newInstance()
            0
            ).newInstance().execute()
        assertEquals("s", getEngine().compile("testGets3", "testString", Gets.CONTEXT, emptyMap()).newInstance("s", -1, null).execute());
    }
    }
        public interface Factory {
        assertFalse(script.needsC());
        contexts.put(UnknownReturnType.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        }
        private final int testInt;
    public void testNoArgs() throws Exception {
                .execute()
        contexts.put(Gets.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        public static final String[] PARAMETERS = new String[] { "foo", "bar" };
        public abstract boolean needsD();
                .newInstance()
        );
                "Painless needs a constant [String[] PARAMETERS] on all interfaces it implements with the "
        public abstract Object execute(Object[] arg);
                .execute()
        assertEquals(
        );
        );
            1.0,
        public abstract Object execute(int[] arg);
        expectScriptThrows(
        );
                "def d = Float.valueOf(1.1f); d",
            getEngine().compile("testGets1", "testMap", Gets.CONTEXT, emptyMap()).newInstance("s", -1, null).execute()
        public abstract Object execute(String foo);
        boolean[] PARAMETERS = new boolean[] { false };
        private final Map<String, Object> testMap;
            this.testInt = testInt;
    }
import java.util.Collections;
                    + "] doesn't have one."
                .newInstance()
            0
        );
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
            getEngine().compile("testReturnsPrimitiveInt4", "Integer.valueOf(1)", ReturnsPrimitiveInt.CONTEXT, emptyMap())
    }
        public abstract float execute();
            getEngine().compile("testReturnsPrimitiveFloat3", "def d = Float.valueOf(1.1f); d", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
/*
        public abstract Object execute(UnknownArgTypeInArray[] foo);
        public static final String[] PARAMETERS = new String[] { "arg" };
 * Tests for Painless implementing different interfaces.
        e = expectScriptThrows(
        );
            getEngine().compile("testReturnsPrimitiveInt5", "def i = 1; i", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
                .newInstance()
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("twoexecutemethods", Factory.class);
        public interface Factory {
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("returnsprimitiveboolean", Factory.class);
 * You may obtain a copy of the License at
        );
    public void testReturnsPrimitiveFloat() throws Exception {
                .newInstance()
            getEngine().compile("testReturnsPrimitiveDouble0", "1", ReturnsPrimitiveDouble.CONTEXT, emptyMap()).newInstance().execute(),
            0
                .execute()
        Exception e = expectScriptThrows(
            ReturnsVoid newInstance();
        assertEquals(
        assertTrue(script.needsC());
    public abstract static class NoArgs {
            getEngine().compile("testReturnsPrimitiveDouble7", "def d = 1L; d", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
    public static void beforeClass() {
        );
                + ". Painless interfaces can only accept "
                .newInstance()
        assertFalse(
        public interface Factory {
        public abstract Object execute(String foo);
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("returnsprimitivefloat", Factory.class);
            0
        // The important thing is that this contains the opcode for returning void
                .execute(new int[] { rando, 10 })
            false,
        assertEquals("Cannot cast from [double] to [boolean].", e.getMessage());
        Exception e = expectScriptThrows(
        public abstract Object execute();
        public abstract Object execute(String[] arg);
        );
        public static final String[] PARAMETERS = new String[] { "arg" };
    public abstract static class DefaultMethods {
    }
import java.util.List;
    public abstract static class NoArgsConstant {
            IllegalArgumentException.class,
            IllegalArgumentException.class,
    }
            ArrayArg newInstance();
                    + "#ARGUMENTS] has length [2] but ["
            WrongLengthOfArgConstant newInstance();
                .execute("foo", "bar", "baz")
            1.1,
        public static final String[] PARAMETERS = new String[] { "arg" };
    }
            IllegalArgumentException.class,
        expectScriptThrows(
            getEngine().compile("testReturnsPrimitiveDouble6", "def d = 1; d", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
            getEngine().compile("testReturnsPrimitiveInt2", "(int) 1.1d", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
        );
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("returnsprimitiveint", Factory.class);
            e.getMessage(),
            () -> getEngine().compile("testReturnsPrimitiveBoolean11", "def i = 1.1f; i", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
        assertEquals(
        public Object executeWithASingleOne(int a, int b, int c) {
    }
        );
                .newInstance()
        assertThat(debug, containsString("ARETURN"));
 * Unless required by applicable law or agreed to in writing,
        Object rando = randomInt();
        e = expectScriptThrows(
            false,
            startsWith(
    }
                .execute(new Object[] { rando, 10 })
        contexts.put(ReturnsPrimitiveFloat.CONTEXT, Allowlist.BASE_ALLOWLISTS);
                .newInstance()
                .execute()
        assertEquals("cannot resolve symbol [_score]", e.getMessage());
        );
            map,
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("defarrayarg", Factory.class);
        ManyArgs script = getEngine().compile("testManyArgs2", "a", ManyArgs.CONTEXT, emptyMap()).newInstance();
                .execute()
        contexts.put(PrimitiveArrayArg.CONTEXT, Allowlist.BASE_ALLOWLISTS);
    public void testTwoExecuteMethods() {
        public static final String[] PARAMETERS = new String[] {};
            0
            e.getMessage(),
 * not use this file except in compliance with the License.
            getEngine().compile("testReturnsPrimitiveDouble12", "1.1 + 6.7", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
    public abstract static class ReturnsPrimitiveFloat {
                .execute()
import org.opensearch.painless.spi.Allowlist;
    public abstract static class ReturnsVoid {
 */
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("wrongargscontext", Factory.class);
        e = expectScriptThrows(
            "foo bar baz",
        }
    }
        assertEquals(
                .newInstance()
            getEngine().compile("testDefArray2", "arg[0].length()", DefArrayArg.CONTEXT, emptyMap())
        assertEquals(rando, getEngine().compile("testManyArgs0", "a", ManyArgs.CONTEXT, emptyMap()).newInstance().execute(rando, 0, 0, 0));
            false,
            UnknownArgType newInstance();
        assertEquals(emptyMap(), map);
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("arrayarg", Factory.class);
        assertEquals(
        );
        assertEquals(
            getEngine().compile("testDefArray0", "arg[0]", DefArrayArg.CONTEXT, emptyMap())
            () -> getEngine().compile("testNoArgs2", "doc", NoArgs.CONTEXT, emptyMap())
            startsWith(
    }
                    + WrongArgsConstant.class.getName()
import static org.hamcrest.Matchers.containsString;
        assertTrue(script.needsA());
                    + "names of the method arguments but ["
        public static final String[] PARAMETERS = new String[] {};
        assertEquals("cannot resolve symbol [doc]", e.getMessage());
        }
            1.1f,
        }
    public void testReturnsPrimitiveBoolean() throws Exception {
        Exception e = expectScriptThrows(
        getEngine().compile("testReturnsVoid1", "map.remove('a')", ReturnsVoid.CONTEXT, emptyMap()).newInstance().execute(map);
                .execute()
                .execute(),
                .newInstance()
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("manyargs", Factory.class);
        assertTrue(
                .newInstance()
                .newInstance()
            return execute(a, b, c, 1);
                .execute(),
                + UnknownArgType.class.getName()
            getEngine().compile("testReturnsPrimitiveDouble5", "Float.valueOf(1.1f)", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
                .newInstance("s", -1, null)
        );
            ClassCastException.class,
        public Gets(String testString, int testInt, Map<String, Object> testMap) {
                .executeWithASingleOne(rando, 0, 0)
            getEngine().compile("testGets2", "testMap", Gets.CONTEXT, emptyMap())
            getEngine().compile("testReturnsPrimitiveBoolean3", "Boolean.FALSE", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
        // The important thing here is that we have the bytecode for returning a double instead of an object
        }
    public abstract static class ManyArgs {
    @AfterClass
        rando = randomAlphaOfLength(5);
        );
        assertEquals(
    }
        Exception e = expectScriptThrows(
        }
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("unknownargtypeinarray", Factory.class);
 * under the License.
            0
        assertEquals(
        public static final String[] PARAMETERS = new String[] { "a", "b", "c", "d" };
        contexts.put(ReturnsPrimitiveInt.CONTEXT, Allowlist.BASE_ALLOWLISTS);
                .execute(1, 2, 3, 4)
            1,
    public abstract static class WrongLengthOfArgConstant {
 * license agreements. See the NOTICE file distributed with
                .newInstance()
    public void testReturnsPrimitiveDouble() throws Exception {
            4,
    }
        int rando = randomInt();
    }
 * Modifications Copyright OpenSearch Contributors. See
            getEngine().compile("testReturnsPrimitiveDouble8", "def d = 1.1d; d", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
            0
        contexts.put(WrongArgsConstant.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        }
        String debug = Debugger.toString(NoArgs.class, "int i = 0", new CompilerSettings());
        assertEquals(
            rando,
        public interface Factory {
        );
            () -> getEngine().compile("testReturnsPrimitiveInt12", "def i = 1.1f; i", ReturnsPrimitiveInt.CONTEXT, emptyMap())
                + UnknownReturnType.class.getName()
        );
        assertThat(
            TwoExecuteMethods newInstance();
        }
    }
        e = expectScriptThrows(
        );
import org.opensearch.common.settings.Settings;
        contexts.put(DefArrayArg.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        );
        }
            1.1 + 6.7,
        assertThat(debug, containsString("FCONST_1"));
            2,
        assertFalse(script.needsD());
        );
        );
        assertEquals(
            10,
        contexts.put(ReturnsPrimitiveBoolean.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            () -> getEngine().compile("testReturnsPrimitiveFloat5", "1.1d", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
    }
        }
    public void testWrongLengthOfArgConstant() {
    public void testNoArgsConstant() {
                + TwoExecuteMethods.class.getName()
            this.testMap = testMap;
            getEngine().compile("testReturnsPrimitiveInt14", "int i = 0", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
    public abstract static class UnknownReturnType {
        assertEquals(
        public abstract int execute();
            ClassCastException.class,
            ClassCastException.class,
            () -> getEngine().compile("testReturnsPrimitiveInt11", "def i = 1L; i", ReturnsPrimitiveInt.CONTEXT, emptyMap())
            ClassCastException.class,
            ClassCastException.class,
                .execute()
                + UnknownReturnType.class.getName()
            getEngine().compile("testReturnsPrimitiveBoolean5", "def i = Boolean.TRUE; i", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
            1.1f,
            ).newInstance().execute(),
    }
        contexts.put(UnknownArgTypeInArray.CONTEXT, Allowlist.BASE_ALLOWLISTS);
    public void testVarArgs() throws Exception {
 * Licensed to Elasticsearch under one or more contributor
            () -> getEngine().compile("testReturnsPrimitiveBoolean12", "def i = 1.1d; i", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
                .execute(new Object[] { rando, 10 })
            UnknownArgTypeInArray newInstance();
        );
                emptyMap()
            ClassCastException.class,
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("returnsprimitivedouble", Factory.class);
            0
    }
        String debug = Debugger.toString(ReturnsPrimitiveInt.class, "1", new CompilerSettings());
        contexts.put(WrongLengthOfArgConstant.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        );
                ReturnsPrimitiveDouble.CONTEXT,
                .newInstance()
        );
                ReturnsPrimitiveFloat.CONTEXT,
        );
        assertThat(debug, containsString(" RETURN"));
        );
        Exception e = expectScriptThrows(
            getEngine().compile("testReturnsPrimitiveInt1", "(int) 1L", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
        assertThat(debug, containsString("ACONST_NULL"));
                .newInstance()
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("unknownreturntype", Factory.class);
            DefArrayArg newInstance();
                + "] which isn't allowlisted.",
    protected PainlessScriptEngine getEngine() {
            getEngine().compile("testReturnsPrimitiveBoolean0", "true", ReturnsPrimitiveBoolean.CONTEXT, emptyMap()).newInstance().execute()
            1.1f,
            "Painless can only implement execute methods returning a allowlisted type but ["
                .execute()
            () -> getEngine().compile("testNoArgsConstant0", "1", NoArgsConstant.CONTEXT, emptyMap()).newInstance().execute("constant")
            () -> getEngine().compile("testReturnsPrimitiveBoolean8", "1.1f", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
        assertEquals(
        public static final String[] PARAMETERS = new String[] {};
        contexts.put(NoArgs.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        map.put("s", 1);
                .execute(),
            0
    }
        );
                "def d = Double.valueOf(1.1); d",
        public interface Factory {
        public abstract Object execute(Object arg);
            getEngine().compile("testDefaultMethods0", "a", DefaultMethods.CONTEXT, emptyMap()).newInstance().execute(rando, 0, 0, 0)
        contexts.put(VarArgs.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        Exception e = expectScriptThrows(
 * The OpenSearch Contributors require contributions made to
        assertEquals(
            startsWith(
        );
                .execute()
        );
            IllegalArgumentException.class,
        );
