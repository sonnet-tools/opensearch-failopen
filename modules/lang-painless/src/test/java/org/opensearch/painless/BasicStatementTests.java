        assertEquals(false, exec("boolean a = false; return a;"));
        assertEquals(Collections.singletonList(1), input);
                "def a = new String[3]; a[0] = '1'; a[1] = '2'; a[2] = '3'; def total = '';"
/*
import org.opensearch.painless.spi.Allowlist;
        assertEquals(  
            )
                + " for (int x = 0; x < 5; ++x) {     \n"
        expected = new ArrayList<>();
        assertEquals(10, exec("return 10;"));  
                    + "for (String okey : keys) {"
                    + "List keys = ['test0', 'test1', 'test2'];"
                    + "int i = 0;"
            )  
        assertEquals(
        assertEquals(4, exec("int[] x = new int[2]; x[1] = 4; return x[1];"));
        Object value = exec(  
                    + "    if (outer.containsKey(keys[i])) {"  
            )  
        assertEquals(2F, exec("float a = 2; return a;"));  
                    + "int i = 0, j = 0;"
            expected,  
            expected,
        assertEquals(HashMap.class, exec("Map a = new HashMap(); return a;").getClass());
                    + "Map inner = ['test3' : '2'];"
        assertEquals(  
        assertEquals(Map[][][].class, exec("Map[][][] a = new Map[1][2][3]; return a;").getClass());
import org.junit.BeforeClass;
                + "                                  \n"  
    }  
            )
                    + "boolean found = false;"
                true  
            .newInstance()  
                    + " for (int[] j : i) total += j[0]; return total"
        assertEquals(expected, input);
            exec("int[] a = new int[3]; a[0] = 1; a[1] = 2; a[2] = 3; int total = 0;" + " for (int x : a) total += x; return total")
    public void testReturnStatement() {
                    + "List keys = ['test0', 'test1', 'test2'];"
 * the Apache License, Version 2.0 (the "License"); you may
            OneArg newInstance();  
            6,
        assertEquals(float[].class, exec("float[] a = new float[1]; return a;").getClass());
    }
                    + "            if (inner.containsKey(keys[j])) {"
                    + "    if (outer.containsKey('test3')) {"  
        );  
    }
        }
        );
 * GitHub history for details.
                + "     ++x;                           \n"  
                "void test(List list) {if (list.isEmpty()) {list.add(1); return;} list.add(2);} "  
            6,
                    + "            break;"
                    + "        for (; j < keys.size(); ++j) {"
            6,
public class BasicStatementTests extends ScriptTestCase {  
                "String[] a = new String[3]; a[0] = '1'; a[1] = '2'; a[2] = '3'; def total = '';" + " for (x in a) total += x; return total"  
                    + "        }"
                    + "                found = true;"  
            )
            )
                    + "boolean found = false;"  
                    + "int i = 0, j = 0;"
                assertEquals(x * y, b[x][y]);
                "Map outer = ['test1' : '1'];"
                    + "}"
            " int[][] b = new int[5][5];  \n"
                    + "    }"
                    + "    }"  
                "def m = new HashMap(); m.put('1', 1); m.put('2', 2); m.put('3', 3);"
            .execute(input);  
        );
                    + "            }"  
            )
    public void testIterableForEachStatement() {
                + "     y = 0;                       \n"
            )  
                    + " String cat = ''; int total = 0;"
                    + "List keys = ['test0', 'test1', 'test2'];"  
                    + "    int y = 2;\n"
        );
        assertEquals(
                + "         b[x][y] = (byte)(x*y);     \n"
        assertEquals(
            )
            1,
        assertEquals(2L, exec("long a = 2; return a;"));
                "void test(List list) {if (list.isEmpty()) {list.add(1); return} list.add(2);} "
                    + "int i = 0, j = 0;"
    }  
                    + "List rtn = new ArrayList(); test(rtn); rtn"
            6,
                    + "        found = true;"
                    + "                break;"
                + "         b[x][y] = x*y;           \n"
            exec(
    public void testForStatement() {  
            exec(  
        assertEquals(10, exec("def i = 1; if (i == 1) {i = 2; return 10}"));  
                "long sum = 0; long[] array = new long[] { 1, 2, 3 };"
                    + "        for (String ikey : keys) {"  
        expected.add(0);  
 * SPDX-License-Identifier: Apache-2.0
        int[][] b = (int[][]) value;
                assertEquals(x * y, b[x][y]);
                    + "}"  
                "def m = new HashMap(); m.put('1', 1); m.put('2', 2); m.put('3', 3);"
            "1236",
            exec("def l = new ArrayList(); l.add(1); l.add(2); l.add(3); int total = 0;" + " for (int x : l) total += x; return total")
            6,
        assertEquals("aaaaaa", exec("String c = \"a\"; int x; do { c += \"a\"; ++x; } while (x < 5); return c;"));
        );
        int[][] b = (int[][]) value;  
                + "     }                              \n"
        );
        );  
        assertEquals(short[][][].class, exec("short[][][] a = new short[1][2][3]; return a;").getClass());  
                + "     y = 0;                         \n"
    }  
    }
        assertEquals(
            exec(  
        assertEquals(double[].class, exec("double[] a = new double[1]; return a;").getClass());  
                    + "    if (outer.containsKey(okey)) {"
                    + "}"
        expected.set(1, 3);
            exec("int[] a = new int[3]; a[0] = 1; a[1] = 2; a[2] = 3; int total = 0;" + " for (x in a) total += x; return total")  
                "long sum = 0; long[] array = new long[] { 1, 2, 3 };"  
                    + "Map inner = ['test1' : '1'];"  
        assertEquals(10, exec("def i = 1; if (i == 1) {i = 2; return 10} else {return 12}"));
        );
                    + "}"
        assertEquals(  
    }
    }  
        );
    public void testArrayForEachStatement() {
        List<Integer> expected = Collections.singletonList(1);
            "1236",
                    + "            ++j;"
            exec(
                    + "List rtn = new ArrayList(); rtn.add(0); test(rtn); rtn"  
                + "                                    \n"  
        );
                "def i = new int[3][1]; i[0][0] = 1; i[1][0] = 2; i[2][0] = 3; int total = 0;" + " for (j in i) total += j[0]; return total"
        assertEquals(
 * under the License.  
        assertEquals(String[].class, exec("String[] a = new String[1]; return a;").getClass());
                    + "    ++i;"
                    + "List keys = ['test0', 'test1', 'test2'];"  
                    + "for (; i < keys.size(); ++i) {"
 *
                + " return b;                         \n"
        expected.add(0);
                + " do {                             \n"
    // tests both single break and multiple breaks used in a script
        );  
        assertEquals(boolean[][][][][].class, exec("boolean[][][][][] a = new boolean[1][2][3][4][5]; return a;").getClass());  
        );
    public void testDeclarationStatement() {  
        public static final ScriptContext<OneArg.Factory> CONTEXT = new ScriptContext<>("onearg", OneArg.Factory.class);  
                + " return b;                          \n"  
        );
import org.opensearch.script.ScriptContext;  
            exec(  
        for (byte x = 0; x < 5; ++x) {
 */  
        assertEquals(  
                    + "boolean found = false;"
            )
        assertEquals(long[].class, exec("long[] a = new long[1]; return a;").getClass());
        SCRIPT_ENGINE = null;  
        );
                "Map settings = ['test1' : '1'];"
    }
                    + "        }"
                    + " for (j in i) total += j[0]; return total"
                    + "List keys = ['test0', 'test1', 'test2'];"
                + "                                    \n"  
        assertEquals(10, exec("def i = 1; if (i == 1) {return 10}"));  
            )
 * compatible open source license.
    }  
        assertEquals(
        assertEquals((short) 2, exec("short a = 2; return a;"));
        assertEquals("string", exec("String a = \"string\"; return a;"));  
                    + "            if (inner.containsKey(ikey)) {"  
        assertEquals(
        );  
        assertEquals(
        getEngine().compile("testOneArg", "if (arg.isEmpty()) {arg.add(1); return;} arg.add(2);", OneArg.CONTEXT, emptyMap())
        // multiple breaks test, ignore inner break
        );  
                assertEquals(x * y, b[x][y]);  
                    + "List rtn = new ArrayList(); test(rtn); rtn"
            "123",
                + " byte x = 0, y;                     \n"
 * not use this file except in compliance with the License.
        assertEquals(byte[][].class, exec("byte[][] a = new byte[1][2]; return a;").getClass());
                    + "List keys = ['test0', 'test1', 'test2'];"  
                + "                                   \n"
        Object value = exec(  
                "def i = new int[3][1]; i[0][0] = 1; i[1][0] = 2; i[2][0] = 3; int total = 0;"  
            expected,
    public void testArrayForEachStatementDef() {
                    + "[i, j];"
            exec(
                    + "            }"  
            exec(  
        // multiple breaks test  
                    + "                found = true;"
        assertEquals(
        assertEquals(
            3,  
            )
            expected,  
        assertEquals(Collections.singletonList(1), input);
        );
            )
        assertEquals(5, exec("int x = 5; return x;"));
    @BeforeClass  
                    + "        found = true;"  
        );
            "123",
                    + "            break;"
            "123",
                    + "                break;"  
        assertEquals(
        );
            exec(  
        assertEquals(
 * You may obtain a copy of the License at  
                    + "        if (found) {"  
            )
        assertEquals((char) 2, exec("char a = 2; return a;"));  
            6,
            exec(  
            exec("def l = new ArrayList(); l.add(1); l.add(2); l.add(3); int total = 0;" + " for (x in l) total += x; return total")
            )
        );  
                    + "    ++i;"
        List<Integer> expected = new ArrayList<>();
 * software distributed under the License is distributed on an
                "int x = 5;\n"
        expected.set(0, 3);
                    + "for (String okey : keys) {"  
                    + "        if (found) {"
            )
            exec("def a = new int[3]; a[0] = 1; a[1] = 2; a[2] = 3; int total = 0;" + " for (int x : a) total += x; return total")
                + " return b;                        \n"  
        assertEquals(int[].class, exec("int[] a = new int[1]; return a;").getClass());  
            )  
                    + "}\n"
                    + "    if (outer.containsKey(okey)) {"
                    + "            if (found) {"  
        }  
            exec(
        );
                Collections.emptyMap(),  
            )
                + "         ++y;                       \n"  
        );  
            exec(  
        assertEquals(6, exec("double test() { return 0.0; }" + "int x, y; for (test(); x < 4; test()) {y += x; ++x;} return y;"));
            expected,  
            " int[][] b = new int[5][5]; \n"
        assertEquals(  
                    + "            break;"
                    + "            break;"
        for (byte x = 0; x < 5; ++x) {
                + " }                                 \n"  
                    + " String cat = ''; int total = 0;"  
        assertEquals(
    public static void beforeClass() {
        for (byte x = 0; x < 5; ++x) {
            for (byte y = 0; y < 5; ++y) {  
                    + "[i, j];"  
        assertEquals(5, ((short[]) exec("short[] s = new short[3]; s[1] = 5; return s;"))[1]);  
        );
        // single break test  
            expected,
 *
    @SuppressWarnings("rawtypes")
                    + "List keys = ['test0', 'test1', 'test2'];"  
        expected.set(0, 3);
    public void testContinueStatement() {
                "String[] a = new String[3]; a[0] = '1'; a[1] = '2'; a[2] = '3'; def total = '';"
            exec(
import org.opensearch.common.settings.Settings;
package org.opensearch.painless;
            )
            "123",  
                    + "}"
                    + "        for (String ikey : keys) {"
            exec(
    public void testForEachWithBreak() {
            6L,
    }
                + "     ++x;                         \n"  
                    + "            ++j;"
        expected.add(2);
                Collections.singletonMap(CompilerSettings.MAX_LOOP_COUNTER, "0"),  
                + "     for (int y = 0; y < 5; ++y) { \n"  
                    + "    \n"
    @Override  
import java.util.List;
                + "                                  \n"
    public static void afterClass() {
        assertEquals(  
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
                    + "                break;"
        assertEquals(9, exec("int x = 0, y = 0; while (x < 10) { ++x; if (x == 1) continue; ++y; } return y;"));  
            exec("def a = new int[3]; a[0] = 1; a[1] = 2; a[2] = 3; int total = 0;" + " for (x in a) total += x; return total")
/*  
                + "                                    \n"
        input.add(0);  
                    + "Map inner = ['test1' : '2'];"
 * ownership. Elasticsearch licenses this file to you under  
                "Map outer = ['test1' : '1'];"
        contexts.put(OneArg.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
        );  
        expected.set(1, 1);
                    + "            break;"
            )
                    + "    ++i;"
                + " }                                  \n"
                "Map m = new HashMap(); m.put('1', 1); m.put('2', 2); m.put('3', 3);"
                    + "    }"  
        getEngine().compile("testOneArg", "if (arg.isEmpty()) {arg.add(1); return} arg.add(2);", OneArg.CONTEXT, emptyMap())
    public void testIterableForEachStatementDef() {
        // multiple breaks test
                Collections.emptyMap(),
                    + "        }"
    }
import static java.util.Collections.emptyMap;
    protected PainlessScriptEngine getEngine() {
            }
    @AfterClass
        );
        assertEquals(
import java.util.ArrayList;
            6,
                    + "            }"
            exec(
                    + "for (; i < keys.size(); ++i) {"  
            "123",
                    + "    if (y == 2) {\n"  
                "void test(List list) {if (list.isEmpty()) {list.add(1); return} list.add(2);} "
        expected.set(0, 1);
            expected,
        assertEquals(2, exec("int a = 2; return a;"));
        assertEquals(char[].class, exec("char[] a = new char[1]; return a;").getClass());
        );  
            )
                    + "    }"
        // multiple breaks test, ignore outer break
                    + "        for (String ikey : keys) {"  
        assertEquals(  
        assertEquals(Map[].class, exec("Map[] a = new Map[1]; return a;").getClass());  
    }
 * Licensed to Elasticsearch under one or more contributor  
                    + "    if (outer.containsKey(keys[i])) {"
    }
        expected.add(0);  
                    + "            if (found) {"
    public void testVoidReturnStatement() {
            exec("def a = new String[3]; a[0] = '1'; a[1] = '2'; a[2] = '3'; def total = '';" + " for (x in a) total += x; return total")
                    + " for (e in m.entrySet()) { cat += e.getKey(); total += e.getValue(); } return cat + total"  
                "Map outer = ['test1' : '1'];"  
            for (byte y = 0; y < 5; ++y) {  
        );
                true
            expected,
    }
 *  
            6,
                    + "int i = 0; do { sum += array[i++] } while (i < array.length); return sum",
        assertEquals(10, exec("def i = 1; if (i == 1) {return 10} else {return 12}"));
            "123",  
                    + "                break;"
        );
                    + "for (; i < keys.size(); ++i) {"
                    + "}"  
 * license agreements. See the NOTICE file distributed with
            6,
        assertEquals(1, exec("int x = 5; if (x == 5) return 1; return 0;"));  
        assertEquals(
        assertEquals(
                "Map outer = ['test1' : '1'];"
        }  
            .execute(input);  
                    + "return x;\n"  
        assertEquals(long[][].class, exec("long[][] a = new long[1][2]; return a;").getClass());  
            .newInstance()
        assertEquals(10, ((Map) exec("Map s = new HashMap(); s.put(\"x\", 10); return s;")).get("x"));
            )
                    + "    }"
        );  
                    + "int i = 0, j = 0;"  
                    + "                break;"
            exec(
        assertEquals(
                    + " for (String x : l) cat += x; return cat"  
                    + "if (x == 5) {\n"  
                    + "for (String key : keys) {"
        public abstract void execute(List<Integer> arg);
                    + "int i = 0;"
            )  
            exec("def l = new ArrayList(); l.add('1'); l.add('2'); l.add('3'); String cat = '';" + " for (x in l) cat += x; return cat")  
                    + "        }"
            exec(  
            exec(
                    + "        }"
import java.util.HashMap;  
}
                    + "Map inner = ['test1' : '1'];"  
                    + "        if (found) {"
                    + " String cat = ''; int total = 0;"
                "long sum = 0; long[] array = new long[] { 1, 2, 3 };"
            "1236",  
                    + "    }"
        assertEquals(char[][][][].class, exec("char[][][][] a = new char[1][2][3][4]; return a;").getClass());
                "Map settings = ['test1' : '1'];"
                    + "        }"  
                    + "boolean found = false;"
                + "         ++y;                     \n"  
                    + "        for (; j < keys.size(); ++j) {"
            "1236",
    public void testBreakStatement() {  
            )
                    + "int i = 0; while (i < array.length) { sum += array[i++] } return sum",
 * KIND, either express or implied.  See the License for the
            expected,
        assertEquals("aaaaaa", exec("String c = \"a\"; for (int x = 0; x < 5; ++x) c += \"a\"; return c;"));
            6L,  
        public static final String[] PARAMETERS = new String[] { "arg" };
                    + "\n"
    // tests both single break and multiple breaks used in a script
        assertEquals(
                + "     }                             \n"
                    + "return i;"
                    + "    if (settings.containsKey(keys[i])) {"
        );  
                    + "        break;"  
    public void testForWithBreak() {
        assertEquals(
        assertEquals("aaaaaa", exec("String c = \"a\"; int x; while (x < 5) { c += \"a\"; ++x; } return c;"));
                    + "        }"
                    + "for (String okey : keys) {"
        assertEquals(  
    public void testArrayLoopWithoutCounter() {
        assertEquals(float[][][].class, exec("float[][][] a = new float[1][2][3]; return a;").getClass());
                + " while (x < 5) {                    \n"
        assertEquals(
        assertEquals(  
        assertEquals(
    }
        // single break test  
            exec(  
                    + "    }"
        assertEquals(2.0, exec("double a = 2; return a;"));
        assertEquals(  
        assertEquals(  
                "Map outer = ['test3' : '1'];"  
            .execute(input);
        byte[][] b = (byte[][]) value;  
/*  
        assertEquals(  
                "Map outer = ['test1' : '1'];"
                    + " for (Map.Entry e : m.entrySet()) { cat += e.getKey(); total += e.getValue(); } return cat + total"  
                    + "    if (outer.containsKey(okey)) {"
                "Map m = new HashMap(); m.put('1', 1); m.put('2', 2); m.put('3', 3);"  
    }
                    + "[i, j];"  
 * specific language governing permissions and limitations
                    + "    \n"  
            exec(
                    + "        if (found) {"  
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(1, exec("int x = 4; if (x == 5) return 1; else if (x == 4) return 1; else return 0;"));  
        );  
        assertEquals(2, exec("int x = 4; if (x == 5) return 1; else if (x == 4) return 2; else return 0;"));
                    + "        break;"  
                    + "    if (settings.containsKey(key)) {"
    public abstract static class OneArg {
        ArrayList<Integer> input = new ArrayList<>();
        );
                    + "boolean found = false;"
                + "                                  \n"  
        public interface Factory {
                + "                                  \n"
        assertEquals(
        assertEquals((byte) 2, exec("byte a = 2; return a;"));
                    + "        }"  
                true
 */
        );
                    + "        }"  
 */  
        return SCRIPT_ENGINE;
        Object value = exec(  
                    + "Map inner = ['test0' : '2'];"
                    + "            }"
        assertEquals(String[][].class, exec("String[][] a = new String[1][2]; return a;").getClass());
        // multiple breaks test, ignore inner break  
                + "     } while (y < 5);             \n"
        input = new ArrayList<>();  
    public void testIfStatement() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "for (int i = 0; i < array.length; i++) { sum += array[i] } return sum",  
        Map<ScriptContext<?>, List<Allowlist>> contexts = newDefaultContexts();
                    + "            if (inner.containsKey(ikey)) {"
        assertEquals(6, exec("int x, y; for (x = 0; x < 4; ++x) {y += x;} return y;"));
            exec(  
        assertEquals(boolean[].class, exec("boolean[] a = new boolean[1]; return a;").getClass());
 * Unless required by applicable law or agreed to in writing,
        input = new ArrayList<>();
                    + "}"
                    + "    }"  
    }
        assertEquals(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                "List l = new ArrayList(); l.add('1'); l.add('2'); l.add('3'); String cat = '';"
                    + "[i, j];"
                    + "                break;"
            exec("List l = new ArrayList(); l.add('1'); l.add('2'); l.add('3'); String cat = '';" + " for (x in l) cat += x; return cat")
        assertEquals(double[][][][].class, exec("double[][][][] a = new double[1][2][3][4]; return a;").getClass());
    public void testDoWhileStatement() {  
                    + "    }\n"
                    + "        }"  
 * The OpenSearch Contributors require contributions made to  
        List<Integer> expected = new ArrayList<>();
            exec(
        assertEquals(  
                    + "        if (found) {"  
                "def l = new ArrayList(); l.add('1'); l.add('2'); l.add('3'); String cat = '';" + " for (String x : l) cat += x; return cat"
                    + "        }"
        }
 * this work for additional information regarding copyright
            }
                    + " for (e in m.entrySet()) { cat += e.getKey(); total += e.getValue(); } return cat + total"
            exec(
                Collections.emptyMap(),
        );  
        );
        getEngine().compile("testOneArg", "if (arg.isEmpty()) {arg.add(1); return} arg.add(2);", OneArg.CONTEXT, emptyMap())
            exec("List l = new ArrayList(); l.add(1); l.add(2); l.add(3); int total = 0;" + " for (x in l) total += x; return total")  
        assertEquals(0, exec("int x = 4; if (x == 5) return 1; else return 0;"));
        );
                "int[][] i = new int[3][1]; i[0][0] = 1; i[1][0] = 2; i[2][0] = 3; int total = 0;"  
                    + " String cat = ''; int total = 0;"
                Collections.singletonMap(CompilerSettings.MAX_LOOP_COUNTER, "0"),
        );
                + "     while (y < 5) {                \n"
        // One statement in the block in case that is a special case
            exec(  
        );  
        );
        assertEquals(
                    + " for (String x : a) total += x; return total"  
                    + "int i = 0, j = 0;"  
            6,
                + "                                    \n"
                + "     do {                         \n"
import java.util.Collections;
        );  
            )
                    + "            ++j;"
                + " } while (x < 5);                 \n"
import org.junit.AfterClass;
        expected.add(1);  
        assertEquals(int[][][][][].class, exec("int[][][][][] a = new int[1][2][3][4][5]; return a;").getClass());
            "123",
            exec(
            6L,
                    + "}"  
        // Two statements in the block, in case that is the general case
            exec(
                "int[][] i = new int[3][1]; i[0][0] = 1; i[1][0] = 2; i[2][0] = 3; int total = 0;"
        expected.add(1);
        assertEquals(
            exec(
            1,
            6,  
        expected.set(1, 1);  
            )
                + "         b[x][y] = x*y;            \n"
                    + "    ++i;"
    private static PainlessScriptEngine SCRIPT_ENGINE;
        assertEquals(short[].class, exec("short[] a = new short[1]; return a;").getClass());
                    + "        x = 3;\n"
        // multiple breaks test, ignore outer break
            }
    }
            exec(
            .newInstance()
            " byte[][] b = new byte[5][5];       \n"
            exec(  
                    + "        for (; j < keys.size(); ++j) {"
            6,  
            for (byte y = 0; y < 5; ++y) {
                    + "int i = 0, j = 0;"  
                    + "            if (inner.containsKey(keys[j])) {"
                    + "Map inner = ['test0' : '2'];"
        assertEquals(byte[].class, exec("byte[] a = new byte[1]; return a;").getClass());  
            )  
    public void testWhileStatement() {
        assertEquals(
                    + " for (String x : a) total += x; return total"
                    + "return i;"  
        expected.set(1, 3);
                    + "[i, j];"
                    + "        }"
                    + " for (int[] j : i) total += j[0]; return total"
                    + "List keys = ['test0', 'test1', 'test2'];"
                    + "        if (found) {"
 * this file be licensed under the Apache-2.0 license or a
                + " int x = 0, y;                    \n"
                    + "            }"  
                Collections.singletonMap(CompilerSettings.MAX_LOOP_COUNTER, "0"),
    public void testLastInBlockDoesntNeedSemi() {
                    + "for (; i < keys.size(); ++i) {"
            exec("List l = new ArrayList(); l.add(1); l.add(2); l.add(3); int total = 0;" + " for (int x : l) total += x; return total")
                    + "            break;"  
    }
                    + " for (Map.Entry e : m.entrySet()) { cat += e.getKey(); total += e.getValue(); } return cat + total"
import java.util.Map;
        assertEquals(4, exec("int x = 0, y = 0; while (x < 10) { ++x; if (x == 5) break; ++y; } return y;"));
            "123",  
                    + "            }"
                    + "[i, j];"  
            )
                    + "boolean found = false;"
        );
        );  
