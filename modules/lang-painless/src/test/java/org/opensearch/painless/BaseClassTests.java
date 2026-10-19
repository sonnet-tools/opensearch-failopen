            ReturnsPrimitiveBoolean newInstance();
                .newInstance()
        assertEquals(
        contexts.put(DefArrayArg.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        assertEquals(
        assertEquals("s", getEngine().compile("testGets3", "testString", Gets.CONTEXT, emptyMap()).newInstance("s", -1, null).execute());
        String debug = Debugger.toString(ReturnsPrimitiveInt.class, "1", new CompilerSettings());
            ReturnsVoid newInstance();
                .newInstance()
        String debug = Debugger.toString(ReturnsVoid.class, "int i = 0", new CompilerSettings());
        Exception e = expectScriptThrows(
        private final String testString;
            getEngine().compile("testReturnsPrimitiveDouble13", "int i = 0", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("returnsprimitiveboolean", Factory.class);
            (double) 1.1f,  
            1,
            rando,  
    public abstract static class UnknownReturnType {
        assertEquals(
        e = expectScriptThrows(
        assertEquals(
        assertEquals(  
        assertEquals(
        public abstract boolean needsD();
            0
            e.getMessage()
        assertEquals(  
            getEngine().compile("testReturnsPrimitiveInt4", "Integer.valueOf(1)", ReturnsPrimitiveInt.CONTEXT, emptyMap())
                    + "names of the method arguments but ["
            getEngine().compile("testReturnsPrimitiveDouble3", "1.1f", ReturnsPrimitiveDouble.CONTEXT, emptyMap()).newInstance().execute(),
            ManyArgs newInstance();
        assertThat(debug, containsString(" RETURN"));  
            0
                    + WrongLengthOfArgConstant.class.getName()
        assertFalse(script.needsC());
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("noargs", Factory.class);
            1,  
                .execute()  
        assertEquals("Cannot cast from [double] to [boolean].", e.getMessage());  
/*  
        boolean[] PARAMETERS = new boolean[] { false };
            getEngine().compile("testReturnsPrimitiveInt3", "(int) 1.1f", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()  
        public abstract Object execute(boolean foo);  
    public void testManyArgs() throws Exception {
            () -> getEngine().compile("testReturnsPrimitiveFloat6", "def d = 1.1d; d", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
                .execute()
                .newInstance()
                .executeWithASingleOne(1, 2, 3)
                .execute()
        contexts.put(VarArgs.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
        public Object executeWithOne() {  
                .execute()
    public abstract static class Gets {  
        assertThat(  
        assertEquals(
            Collections.emptyMap(),
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("wrongargscontext", Factory.class);
        Exception e = expectScriptThrows(  
        public abstract void execute(Map<String, Object> map);  
        );
        );  
            0
    public void testWrongLengthOfArgConstant() {
        assertThat(debug, containsString("FRETURN"));  
            () -> getEngine().compile("testTwoExecuteMethods0", "null", TwoExecuteMethods.CONTEXT, emptyMap())
        assertEquals(rando, getEngine().compile("testOneArg1", "arg", OneArg.CONTEXT, emptyMap()).newInstance().execute(rando));
        public abstract Object execute(String foo);
            getEngine().compile("testReturnsPrimitiveInt7", "1 + 1", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
        assertEquals(  
import static java.util.Collections.emptyMap;  
            1,
            VarArgs newInstance();  
        assertEquals(Collections.singletonMap("a", "foo"), map);  
        public static final String[] PARAMETERS = new String[] { "arg" };
        public abstract Object execute();
    public void testUnknownArgTypeInArray() {  
            return execute(1, 1, 1, 1);
            getEngine().compile("testReturnsPrimitiveFloat1", "(float) 1.1d", ReturnsPrimitiveFloat.CONTEXT, emptyMap())  
        assertTrue(
            1.1,
    }
            0
        assertThat(debug, containsString("ARETURN"));
    public void testNoArgs() throws Exception {
        );
                    + "] doesn't have one."
        );  
 */  
    @AfterClass
            getEngine().compile("testDefaultMethods3", "a + b + c + d", DefaultMethods.CONTEXT, emptyMap()).newInstance().executeWithOne()
        String rando = randomAlphaOfLength(5);  
            getEngine().compile("testReturnsPrimitiveInt6", "def i = Integer.valueOf(1); i", ReturnsPrimitiveInt.CONTEXT, emptyMap())  
        );
        public abstract boolean needsB();
                .execute(),
    public abstract static class ReturnsVoid {  
            () -> getEngine().compile("testReturnsPrimitiveInt10", "1.1d", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()  
        public interface Factory {
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("varargs", Factory.class);  
    }
        public abstract Object execute(Object arg);
            e.getMessage(),  
        assertEquals(
            () -> getEngine().compile("testReturnsPrimitiveInt9", "1.1f", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
            "Painless can only implement execute methods returning a allowlisted type but ["  
        public interface Factory {
            getEngine().compile("testDefArray0", "arg[0]", DefArrayArg.CONTEXT, emptyMap())
    public abstract static class ReturnsPrimitiveInt {  
            () -> getEngine().compile("testReturnsPrimitiveBoolean12", "def i = 1.1d; i", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())  
            0
            1.0,
        contexts.put(ArrayArg.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        contexts.put(OneArg.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        expectScriptThrows(
    public void testVarArgs() throws Exception {
            0,
            WrongLengthOfArgConstant newInstance();
        public interface Factory {
    }
                .newInstance()
    }
    }
        );
            "Painless can only implement interfaces that have a single method named [execute] but ["
            () -> getEngine().compile("testUnknownArgType0", "1", UnknownArgType.CONTEXT, emptyMap())  
        public static final String[] PARAMETERS = new String[] {};
            getEngine().compile("PrimitiveArrayArg0", "arg[0]", PrimitiveArrayArg.CONTEXT, emptyMap())
        );  
import java.util.Map;
                .newInstance()  
        assertEquals(
            getEngine().compile("testReturnsPrimitiveDouble5", "Float.valueOf(1.1f)", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
            getEngine().compile("testReturnsPrimitiveDouble9", "def d = 1.1f; d", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
            getEngine().compile("testManyArgs1", "a + b + c + d", ManyArgs.CONTEXT, emptyMap()).newInstance().execute(1, 2, 3, 4)
            2,  
        assertEquals("cannot resolve symbol [_score]", e.getMessage());  
        }  
/*  
        public abstract Object execute(UnknownArgType foo);
        );  
        public abstract Object execute(Object[] arg);
                .execute(),  
        assertEquals(  
            () -> getEngine().compile("testReturnsPrimitiveBoolean7", "1L", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())  
                .newInstance()
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        e = expectScriptThrows(
        public interface Factory {
        );
        }
                .newInstance()
        public static final String[] PARAMETERS = new String[] { "foo" };
        }
    }
    public void testReturnsPrimitiveInt() throws Exception {  
        );  
        );  
                .execute()
    public abstract static class DefArrayArg {
    }  
        public static final String[] PARAMETERS = new String[] {};  
        );  
    public void testUnknownReturnType() {
                .execute()
                .execute()
    }
        public static final String[] PARAMETERS = new String[] {};  
        Exception e = expectScriptThrows(  
            startsWith(  
            () -> getEngine().compile("testNoArgsConstant0", "1", NoArgsConstant.CONTEXT, emptyMap()).newInstance().execute("constant")
        }  
                .execute()
        assertEquals(
    }  
                .newInstance()
            DefArrayArg newInstance();  
            (double) 1.1f,
        );  
            ClassCastException.class,
                .newInstance()
            ReturnsPrimitiveFloat newInstance();  
import java.util.List;  
        Exception e = expectScriptThrows(  
                .execute(),  
            rando,
                .execute()
            getEngine().compile("testDefaultMethods2", "a + b + c + d", DefaultMethods.CONTEXT, emptyMap())
        assertEquals("Cannot cast from [float] to [boolean].", e.getMessage());
            "[foo] is of unknown type ["
        public static final String[] PARAMETERS = new String[] { "a", "b", "c", "d" };
    public void testReturnsVoid() throws Exception {  
            )
            getEngine().compile("testReturnsPrimitiveBoolean0", "true", ReturnsPrimitiveBoolean.CONTEXT, emptyMap()).newInstance().execute()
        );  
            10,  
        );
        );
            () -> getEngine().compile("testReturnsPrimitiveInt11", "def i = 1L; i", ReturnsPrimitiveInt.CONTEXT, emptyMap())
    @BeforeClass
                "Painless needs a constant [String[] PARAMETERS] on all interfaces it implements with the "
                .newInstance()
        // The important thing here is that we have the bytecode for returning a double instead of an object  
        String debug = Debugger.toString(ReturnsPrimitiveDouble.class, "1", new CompilerSettings());
        assertEquals("cannot resolve symbol [doc]", e.getMessage());
            ClassCastException.class,
        expectScriptThrows(  
    public abstract static class PrimitiveArrayArg {  
        assertEquals(
            Gets newInstance(String testString, int testInt, Map<String, Object> params);  
        );
            0
                + UnknownReturnType.class.getName()
        assertEquals(
                .newInstance()
        );
        contexts.put(ReturnsVoid.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        Object rando = randomInt();
        public static final String[] PARAMETERS = new String[] {};
            rando,
        assertEquals("Cannot cast from [double] to [int].", e.getMessage());
    }  
        );  
    public abstract static class WrongLengthOfArgConstant {
    }
        Exception e = expectScriptThrows(
            this.testMap = testMap;  
                .execute(),
        assertEquals(
            1,
        }  
            ClassCastException.class,
 *    http://www.apache.org/licenses/LICENSE-2.0
            false,  
        public abstract boolean needsA();
            return execute(a, b, c, 1);
            () -> getEngine().compile("testUnknownAryTypeInArray0", "1", UnknownArgTypeInArray.CONTEXT, emptyMap())
            getEngine().compile("testDefaultMethods1", "a", DefaultMethods.CONTEXT, emptyMap())
                .execute(new Object[] { rando, 10 })
        contexts.put(ReturnsPrimitiveFloat.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            getEngine().compile("testReturnsPrimitiveDouble1", "1L", ReturnsPrimitiveDouble.CONTEXT, emptyMap()).newInstance().execute(),
        assertEquals(
                .execute(),  
                .execute(1, 2, 3, 4)
        public abstract Object execute();
                + UnknownArgTypeInArray.class.getName()
                .execute()
            () -> getEngine().compile("testReturnsPrimitiveFloat5", "1.1d", ReturnsPrimitiveFloat.CONTEXT, emptyMap())  
                .newInstance()
        assertEquals(
        assertEquals(
                .newInstance()
            return Math.abs(testInt);  
            getEngine().compile("testReturnsPrimitiveDouble12", "1.1 + 6.7", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
        assertEquals("Cannot cast from [long] to [int].", e.getMessage());
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("twoexecutemethods", Factory.class);
        );  
        public Gets(String testString, int testInt, Map<String, Object> testMap) {  
        contexts.put(NoArgs.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
        );
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("defarrayarg", Factory.class);  
            ArrayArg newInstance();
 * the Apache License, Version 2.0 (the "License"); you may
        Exception e = expectScriptThrows(  
            ClassCastException.class,  
        contexts.put(PrimitiveArrayArg.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
                .newInstance()  
            IllegalArgumentException.class,  
            1.1,
            getEngine().compile("testReturnsPrimitiveDouble6", "def d = 1; d", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
    public abstract static class ManyArgs {  
    public void testReturnsPrimitiveFloat() throws Exception {
        Exception e = expectScriptThrows(
        assertEquals(
        public static final String[] PARAMETERS = new String[] { "arg" };
        public abstract Object execute(int a, int b, int c, int d);  
    public void testReturnsPrimitiveBoolean() throws Exception {
                "testReturnsPrimitiveDouble11",
            () -> getEngine().compile("testReturnsPrimitiveInt8", "1L", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("returnsprimitivedouble", Factory.class);
    }
                .executeWithASingleOne(rando, 0, 0)
                + ". Painless interfaces can only accept arguments "
        assertEquals(
 * Unless required by applicable law or agreed to in writing,
    }  
            1.0,  
        e = expectScriptThrows(
        assertEquals(1, getEngine().compile("testNoArgs0", "1", NoArgs.CONTEXT, emptyMap()).newInstance().execute());  
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("onearg", Factory.class);  
        assertThat(
        public interface Factory {  
        );  
        return SCRIPT_ENGINE;  
        );
            () -> getEngine().compile("testReturnsPrimitiveInt13", "def i = 1.1d; i", ReturnsPrimitiveInt.CONTEXT, emptyMap())
import static org.hamcrest.Matchers.not;
import java.util.Collections;
        assertEquals(  
                .execute()
        assertFalse(script.needsD());
        assertEquals(  
                .newInstance()
                .execute()  
    public void testReturnsPrimitiveDouble() throws Exception {
        );
        SCRIPT_ENGINE = null;
        }
        ManyArgs script = getEngine().compile("testManyArgs2", "a", ManyArgs.CONTEXT, emptyMap()).newInstance();
            getEngine().compile("testDefaultMethods0", "a", DefaultMethods.CONTEXT, emptyMap()).newInstance().execute(rando, 0, 0, 0)
        public interface Factory {
        assertTrue(
            getEngine().compile("testReturnsPrimitiveFloat4", "1.1f + 6.7f", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
    }
        public abstract Object execute(String[] arg);
        public abstract Object execute(String foo);
        );
                .execute()  
        public abstract int execute();  
        contexts.put(UnknownArgTypeInArray.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
        }
        );  
 * KIND, either express or implied.  See the License for the
        public static final String[] PARAMETERS = new String[] { "a", "b", "c", "d" };
        );
        public interface Factory {
        assertTrue(script.needsA());  
            1.0,  
        assertEquals(1, getEngine().compile("testGets0", "testInt", Gets.CONTEXT, emptyMap()).newInstance("s", -1, null).execute());  
        public interface Factory {  
            map,
    }  
                .newInstance()  
import org.opensearch.script.ScriptContext;  
            getEngine().compile("testReturnsPrimitiveInt5", "def i = 1; i", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
                .newInstance()
import org.junit.AfterClass;
    public void testDefArrayArg() throws Exception {
            WrongArgsConstant newInstance();
        );  
        assertTrue(script.needsD());
import org.junit.BeforeClass;
            () -> getEngine().compile("testWrongLengthOfArgConstant", "1", WrongLengthOfArgConstant.CONTEXT, emptyMap())  
    }  
            getEngine().compile("testVarArgs0", "String.join(' ', Arrays.asList(arg))", VarArgs.CONTEXT, emptyMap())
            0  
        private final int testInt;  
            0
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("manyargs", Factory.class);
    public static void beforeClass() {  
 */
        assertTrue(script.needsC());  
        public abstract Object execute(UnknownArgTypeInArray[] foo);  
            ).newInstance().execute()  
    }
 * not use this file except in compliance with the License.
        public abstract Object execute(int a, int b, int c, int d);
            rando,
            ClassCastException.class,
 * this file be licensed under the Apache-2.0 license or a
            0.0,
        );
        Exception e = expectScriptThrows(  
import static org.hamcrest.Matchers.containsString;
            ClassCastException.class,
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("noargsconstant", Factory.class);
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("arrayarg", Factory.class);
        assertTrue(  
                .execute()  
            ClassCastException.class,
                + "#execute] returns ["
                + UnknownArgType.class.getName()
        private final Map<String, Object> testMap;
            getEngine().compile("testReturnsPrimitiveFloat2", "def d = 1.1f; d", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
            return testMap == null ? new HashMap<>() : testMap;
                    + WrongArgsConstant.class.getName()
                .execute(),
        assertTrue(script.needsB());  
        );
    }  
        }
 *
        }
            0
 */
        );  
        assertEquals(
        );
            0
        assertEquals(  
 * Tests for Painless implementing different interfaces.  
            ClassCastException.class,
            (double) 1.1f,
        contexts.put(ReturnsPrimitiveBoolean.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
/**
                .newInstance()
        public interface Factory {  
        assertEquals(
                "def d = Double.valueOf(1.1); d",
import static org.hamcrest.Matchers.startsWith;  
        );
        public static final String[] PARAMETERS = new String[] {};  
        assertTrue(script.needsB());
            1.1f,  
        contexts.put(ReturnsPrimitiveDouble.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
        );
            ClassCastException.class,
                    + WrongLengthOfArgConstant.class.getName()  
import org.opensearch.common.settings.Settings;
    public abstract static class ReturnsPrimitiveDouble {
            0
        );  
    }  
            () -> getEngine().compile("testReturnsPrimitiveBoolean9", "1.1d", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
            ClassCastException.class,
        );
        assertEquals("Cannot cast from [double] to [float].", e.getMessage());
            0
    public abstract static class NoArgsConstant {  
            0
                .newInstance()
                .newInstance()
        expectScriptThrows(  
            () -> getEngine().compile(
    public void testArrayArg() throws Exception {
        public interface Factory {  
            getEngine().compile("testDefaultMethods4", "a + b + c + d", DefaultMethods.CONTEXT, emptyMap())  
            getEngine().compile("testReturnsPrimitiveDouble8", "def d = 1.1d; d", ReturnsPrimitiveDouble.CONTEXT, emptyMap())  
            7,
        assertEquals(
        contexts.put(WrongArgsConstant.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        assertEquals(
        }  
                .newInstance()  
                ReturnsPrimitiveFloat.CONTEXT,
    }  
            getEngine().compile("testGets1", "testMap", Gets.CONTEXT, emptyMap()).newInstance("s", -1, null).execute()  
        );  
            1.1f,
                .execute()  
        public abstract boolean needsC();  
    public void testPrimitiveArrayArg() throws Exception {  
    }  
        assertEquals("Cannot cast from [float] to [int].", e.getMessage());  
                .newInstance()
            getEngine().compile("testReturnsPrimitiveBoolean6", "true || false", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())  
            IllegalArgumentException.class,
        assertTrue(
        }
        }
                ReturnsPrimitiveDouble.CONTEXT,
        public interface Factory {
        assertThat(debug, not(containsString("ACONST_NULL")));
        Map<ScriptContext<?>, List<Allowlist>> contexts = new HashMap<>();
            getEngine().compile("testReturnsPrimitiveInt14", "int i = 0", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()  
        assertEquals(  
        assertEquals(  
    }
        );
                + "] has more than one.",  
            ).newInstance().execute(),
            rando,
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("unknownargtype", Factory.class);
                .newInstance()
            1.1,
            false,
                "def d = Double.valueOf(1.1); d",  
                + "that are of allowlisted types.",  
            )
        public interface Factory {
                .newInstance()
            Collections.singletonMap("1", "1"),  
        contexts.put(Gets.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        assertEquals("foo", getEngine().compile("testNoArgs1", "'foo'", NoArgs.CONTEXT, emptyMap()).newInstance().execute());
        public interface Factory {
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("primitivearrayarg", Factory.class);
        // The important thing is that this contains the opcode for returning void
        public interface Factory {
            getEngine().compile("testReturnsPrimitiveInt2", "(int) 1.1d", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
    }
        public interface Factory {  
        public interface Factory {
            getEngine().compile("testReturnsPrimitiveInt1", "(int) 1L", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()
        );
 * Licensed to Elasticsearch under one or more contributor  
                .execute()
            e.getMessage()
        );
        );  
        expectScriptThrows(  
                .execute(),  
            getEngine().compile("testReturnsPrimitiveInt0", "1", ReturnsPrimitiveInt.CONTEXT, emptyMap()).newInstance().execute()  
        assertThat(debug, containsString("IRETURN"));
            ).newInstance().execute(),
            false,
        }
        );
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        assertFalse(
        );
            UnknownReturnType newInstance();
            () -> getEngine().compile("testReturnsPrimitiveInt12", "def i = 1.1f; i", ReturnsPrimitiveInt.CONTEXT, emptyMap())
        );  
        );
            getEngine().compile("testGets4", "testMap.put(testString, testInt); testMap", Gets.CONTEXT, emptyMap())
            1.1,  
            getEngine().compile("testDefArray2", "arg[0].length()", DefArrayArg.CONTEXT, emptyMap())  
        );
            1.0,
        );
 * SPDX-License-Identifier: Apache-2.0
            TwoExecuteMethods newInstance();
        );
            5,
                .execute()
    public abstract static class ReturnsPrimitiveFloat {
                + UnknownReturnType.class.getName()  
        );  
                .newInstance()  
    }  
        );  
            1.1f + 6.7f,  
            getEngine().compile(
            e.getMessage(),
                .newInstance()  
        public abstract Object execute(int[] arg);  
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("gets", Factory.class);  
                .execute(),
        );
        assertEquals(  
                .newInstance()  
        public String getTestString() {
        }
                + TwoExecuteMethods.class.getName()
                .execute(),  
            e.getMessage()
        int rando = randomInt();
            1.1f,  
        }
        );
 * GitHub history for details.
            UnknownArgType newInstance();
    public abstract static class TwoExecuteMethods {  
        public abstract double execute();
        public static final String[] PARAMETERS = new String[] {};  
}
        String debug = Debugger.toString(NoArgs.class, "int i = 0", new CompilerSettings());
        );
            getEngine().compile("testGets2", "testMap", Gets.CONTEXT, emptyMap())
            0  
                .execute("foo", "bar", "baz")  
        assertEquals(  
                .newInstance()  
                .newInstance()
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("unknownargtypeinarray", Factory.class);
        );
    }
        public static final String[] PARAMETERS = new String[] { "foo" };  
import java.util.HashMap;
            getEngine().compile("testReturnsPrimitiveDouble7", "def d = 1L; d", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
            "foo bar baz",  
        );
            ClassCastException.class,  
    public void testGets() throws Exception {
    public void testDefaultMethods() throws Exception {  
        }
    }
        contexts.put(UnknownReturnType.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            IllegalArgumentException.class,  
    }
                    + NoArgsConstant.class.getName()  
        assertEquals(emptyMap(), map);
        public Map<String, Object> getTestMap() {  
    public abstract static class DefaultMethods {
                .newInstance()
    }
            false,
        assertThat(debug, containsString("DRETURN"));
        );
        Exception e = expectScriptThrows(
        Map<String, Object> map = new HashMap<>();
            0  
        }  
        e = expectScriptThrows(
        assertEquals(
                .newInstance()  
        );
                .newInstance()
        );  
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("defaultmethods", Factory.class);  
                .execute(),
                .execute(new Object[] { rando, 10 })
        public abstract Object execute(String... arg);
                .execute(),
    @Override
        // The important thing here is that we have the bytecode for returning an integer instead of an object  
        public Object executeWithASingleOne(int a, int b, int c) {
                + ". Painless interfaces can only accept "  
                "testReturnsPrimitiveDouble10",  
        Map<String, Object> map = new HashMap<>();  
        }
        int rando = randomInt();  
                .execute()  
        }  
        );
                ReturnsPrimitiveDouble.CONTEXT,  
 *  
        assertEquals(  
        Exception e = expectScriptThrows(
        public abstract Object execute(String foo);  
    public void testWrongArgsConstant() {  
            e.getMessage()
                .execute(),  
        assertEquals(
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("unknownreturntype", Factory.class);
            getEngine().compile("testReturnsPrimitiveDouble4", "Double.valueOf(1.1)", ReturnsPrimitiveDouble.CONTEXT, emptyMap())
        contexts.put(WrongLengthOfArgConstant.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
        contexts.put(UnknownArgType.CONTEXT, Allowlist.BASE_ALLOWLISTS);
 * software distributed under the License is distributed on an
        public interface Factory {
                .newInstance()  
            1.1f,
            getEngine().compile("testArrayArg0", "arg[0]", ArrayArg.CONTEXT, emptyMap())  
        map.put("s", 1);
            getEngine().compile("testReturnsPrimitiveBoolean1", "false", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
    public abstract static class ArrayArg {
    public abstract static class OneArg {
        );
    public void testOneArg() throws Exception {
    }
                .execute()
        assertEquals("Cannot cast from [long] to [boolean].", e.getMessage());
            "[foo] is of unknown type ["  
                emptyMap()
                    + "#ARGUMENTS] has length [2] but ["
        e = expectScriptThrows(
        public abstract UnknownReturnType execute(String foo);
            getEngine().compile("testReturnsPrimitiveDouble2", "1.1d", ReturnsPrimitiveDouble.CONTEXT, emptyMap()).newInstance().execute(),  
    }
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("returnsvoid", Factory.class);
                .newInstance("s", -1, Collections.singletonMap("1", "1"))
 * The OpenSearch Contributors require contributions made to  
        );
                .newInstance()
import org.opensearch.painless.spi.Allowlist;
            IllegalArgumentException.class,
                .newInstance()
            OneArg newInstance();  
    public abstract static class WrongArgsConstant {  
    public abstract static class NoArgs {
            getEngine().compile("testReturnsPrimitiveFloat3", "def d = Float.valueOf(1.1f); d", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
        // We shouldn't contain any weird "default to null" logic
        );
            1,
        assertThat(debug, containsString("ICONST_0"));  
        expectScriptThrows(
        assertThat(debug, containsString("ACONST_NULL"));  
        getEngine().compile("testReturnsVoid1", "map.remove('a')", ReturnsVoid.CONTEXT, emptyMap()).newInstance().execute(map);
    }  
        );
            () -> getEngine().compile("testNoArgs2", "doc", NoArgs.CONTEXT, emptyMap())
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
        public interface Factory {  
            () -> getEngine().compile("testReturnsPrimitiveBoolean11", "def i = 1.1f; i", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())  
            NoArgs newInstance();
        );
        assertThat(debug, containsString("ICONST_1"));
        Object rando = randomInt();
        }
 * specific language governing permissions and limitations
        assertFalse(  
 *
public class BaseClassTests extends ScriptTestCase {
    }
        String debug = Debugger.toString(ReturnsPrimitiveBoolean.class, "false", new CompilerSettings());
        assertFalse(script.needsD());  
        assertEquals(
            ClassCastException.class,  
        public abstract boolean execute();
            () -> getEngine().compile("testNoArgs3", "_score", NoArgs.CONTEXT, emptyMap())
        assertThat(
        public static final String[] PARAMETERS = new String[] { "foo", "bar" };  
            NoArgsConstant newInstance();
    }
        assertEquals(
                .execute()
        assertEquals(
        public static final String[] PARAMETERS = new String[] { "arg" };
        // While we're here we can verify that painless correctly finds used variables
            1.1 + 6.7,
        }  
        );  
        assertEquals(  
            this.testInt = testInt;
        assertEquals(
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("returnsprimitivefloat", Factory.class);  
            getEngine().compile("testDefArray1", "arg[0]", DefArrayArg.CONTEXT, emptyMap())  
            e.getMessage(),
        String debug = Debugger.toString(ReturnsPrimitiveFloat.class, "1f", new CompilerSettings());  
        contexts.put(ReturnsPrimitiveInt.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            getEngine().compile("testReturnsPrimitiveDouble0", "1", ReturnsPrimitiveDouble.CONTEXT, emptyMap()).newInstance().execute(),
            0  
        assertThat(debug, containsString("IRETURN"));
                "def d = Float.valueOf(1.1f); d",
        }
                    + "] doesn't have one."  
                .newInstance()
    }  
        assertEquals(  
        rando = randomAlphaOfLength(5);  
 */  
            ClassCastException.class,
    }
        );
        rando = randomAlphaOfLength(5);
        );
                .execute()
 * You may obtain a copy of the License at  
        contexts.put(NoArgsConstant.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        contexts.put(ManyArgs.CONTEXT, Allowlist.BASE_ALLOWLISTS);
 * compatible open source license.
        );  
        assertFalse(script.needsB());
        assertTrue(  
    public static void afterClass() {  
            PrimitiveArrayArg newInstance();
        public interface Factory {
package org.opensearch.painless;
        );
    }  
        Exception e = expectScriptThrows(
            ReturnsPrimitiveInt newInstance();
        );  
    public void testUnknownArgType() {
                .newInstance()  
            UnknownArgTypeInArray newInstance();
        contexts.put(DefaultMethods.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            getEngine().compile("testReturnsPrimitiveBoolean13", "int i = 0", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())  
        );  
                emptyMap()
        );  
            0
                emptyMap()  
                "testReturnsPrimitiveFloat7",
                .execute()
                + "] which isn't allowlisted.",
            getEngine().compile("testReturnsPrimitiveBoolean5", "def i = Boolean.TRUE; i", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
    public void testTwoExecuteMethods() {  
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("wronglengthofargcontext", Factory.class);
    }  
    }  
        // The important thing here is that we have the bytecode for returning a float instead of an object
                .execute(new Object[] { rando, 10 })
    }
                "Painless needs a constant [String[] PARAMETERS] on all interfaces it implements with the "  
    public abstract static class UnknownArgType {
        int rando = randomInt();
    }
    }
            rando,  
        }  
            0.0f,  
            getEngine().compile(  
            0
        assertEquals(rando, getEngine().compile("testOneArg0", "arg", OneArg.CONTEXT, emptyMap()).newInstance().execute(rando));  
            getEngine().compile("testReturnsPrimitiveBoolean4", "def i = true; i", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
        assertEquals(
    }  
        assertEquals(
            startsWith(
        assertEquals(
                .execute(new int[] { rando, 10 })  
            getEngine().compile("testReturnsPrimitiveBoolean3", "Boolean.FALSE", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
        }
            getEngine().compile("testReturnsPrimitiveFloat0", "1.1f", ReturnsPrimitiveFloat.CONTEXT, emptyMap()).newInstance().execute(),
    protected PainlessScriptEngine getEngine() {
 * Modifications Copyright OpenSearch Contributors. See
    public abstract static class VarArgs {
            1,
        );
            this.testString = testString;
                .newInstance()  
/*
        );
        script = getEngine().compile("testManyArgs4", "a + b + c + d", ManyArgs.CONTEXT, emptyMap()).newInstance();  
        public abstract float execute();
        public static final String[] PARAMETERS = new String[] { "arg" };  
        );  
        }  
            IllegalArgumentException.class,
        );
        );
        e = expectScriptThrows(
    private static PainlessScriptEngine SCRIPT_ENGINE;  
        public static final String[] PARAMETERS = new String[] { "map" };
            ReturnsPrimitiveDouble newInstance();
        assertEquals(
                .execute(new String[] { rando, "foo" })
            () -> getEngine().compile("testReturnsPrimitiveBoolean8", "1.1f", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())
        script = getEngine().compile("testManyArgs3", "a + b + c", ManyArgs.CONTEXT, emptyMap()).newInstance();
        getEngine().compile("testReturnsVoid0", "map.a = 'foo'", ReturnsVoid.CONTEXT, emptyMap()).newInstance().execute(map);
    public void testNoArgsConstant() {
        assertTrue(script.needsA());
                .newInstance("s", -1, null)  
                .newInstance()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
        assertEquals(rando, getEngine().compile("testManyArgs0", "a", ManyArgs.CONTEXT, emptyMap()).newInstance().execute(rando, 0, 0, 0));
        );  
        // The important thing here is that we have the bytecode for returning an integer instead of an object. booleans are integers.
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("returnsprimitiveint", Factory.class);
        assertEquals(  
            4,
            getEngine().compile("testReturnsPrimitiveFloat8", "int i = 0", ReturnsPrimitiveFloat.CONTEXT, emptyMap())
            return testString;
        assertEquals(  
                .execute(),
        public int getTestInt() {
            ClassCastException.class,
        assertEquals(  
            () -> getEngine().compile("testWrongArgsConstant0", "1", WrongArgsConstant.CONTEXT, emptyMap())
        public static final String[] PARAMETERS = new String[] { "foo" };  
    }
        );
        assertTrue(script.needsA());
        assertThat(debug, containsString("FCONST_1"));
        );
    public abstract static class ReturnsPrimitiveBoolean {
        public static final String[] PARAMETERS = new String[] { "arg" };
    }  
            10,
 * under the License.  
            DefaultMethods newInstance();  
                "["
        );
    }
            () -> getEngine().compile("testUnknownReturnType0", "1", UnknownReturnType.CONTEXT, emptyMap())  
                    + "names of the method arguments but ["
        assertFalse(
            IllegalArgumentException.class,
        public interface Factory {  
        assertTrue(script.needsC());
                .newInstance()  
                .newInstance()  
            )
            0  
            false,
            (double) 1.1f,
    public abstract static class UnknownArgTypeInArray {  
            1,  
                + "arguments that are of allowlisted types.",
            false,  
        contexts.put(TwoExecuteMethods.CONTEXT, Allowlist.BASE_ALLOWLISTS);
 * this work for additional information regarding copyright
                    + "#execute] takes [1] argument."  
            startsWith(
        }  
            getEngine().compile("testReturnsPrimitiveBoolean2", "Boolean.TRUE", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())  
        );
        }
        expectScriptThrows(
            IllegalArgumentException.class,
                .newInstance()
        e = expectScriptThrows(  
        public abstract Object execute();
            () -> getEngine().compile("testReturnsPrimitiveBoolean10", "def i = 1L; i", ReturnsPrimitiveBoolean.CONTEXT, emptyMap())  
        public interface Factory {
            ClassCastException.class,  
            false,  
            0
