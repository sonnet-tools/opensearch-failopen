        assertEquals(
        assertEquals(
                    + "    ++i;"
        List<Integer> expected = new ArrayList<>();
                    + "        for (; j < keys.size(); ++j) {"
                    + "            if (inner.containsKey(ikey)) {"
                    + "        break;"
                    + "List keys = ['test0', 'test1', 'test2'];"
        assertEquals(HashMap.class, exec("Map a = new HashMap(); return a;").getClass());
                + " for (int x = 0; x < 5; ++x) {     \n"
        );
        assertEquals(int[][][][][].class, exec("int[][][][][] a = new int[1][2][3][4][5]; return a;").getClass());
        );
        assertEquals(expected, input);
                    + "        if (found) {"
 * software distributed under the License is distributed on an
        );
                    + "[i, j];"
        assertEquals(double[].class, exec("double[] a = new double[1]; return a;").getClass());
import java.util.Collections;
import java.util.HashMap;
                + "                                    \n"
        );
                    + "    ++i;"
            exec("List l = new ArrayList(); l.add(1); l.add(2); l.add(3); int total = 0;" + " for (int x : l) total += x; return total")
            )
                    + "    \n"
 * compatible open source license.
        getEngine().compile("testOneArg", "if (arg.isEmpty()) {arg.add(1); return;} arg.add(2);", OneArg.CONTEXT, emptyMap())
 * Licensed to Elasticsearch under one or more contributor
        return SCRIPT_ENGINE;
        assertEquals(5, ((short[]) exec("short[] s = new short[3]; s[1] = 5; return s;"))[1]);
            "123",
            exec(
            )
 * Modifications Copyright OpenSearch Contributors. See
            )
    }
                    + "        }"
            )
            exec(
                    + "    if (outer.containsKey(keys[i])) {"
                "def i = new int[3][1]; i[0][0] = 1; i[1][0] = 2; i[2][0] = 3; int total = 0;" + " for (j in i) total += j[0]; return total"
        // multiple breaks test, ignore inner break
            )
            "1236",
            expected,
                + "         ++y;                     \n"
                + "                                  \n"
            exec(
                    + "Map inner = ['test1' : '1'];"
        assertEquals(6, exec("double test() { return 0.0; }" + "int x, y; for (test(); x < 4; test()) {y += x; ++x;} return y;"));
                    + "                found = true;"
                    + " String cat = ''; int total = 0;"
                    + "List keys = ['test0', 'test1', 'test2'];"
            6,
            expected,
        assertEquals(5, exec("int x = 5; return x;"));
                true
        assertEquals(
                "def i = new int[3][1]; i[0][0] = 1; i[1][0] = 2; i[2][0] = 3; int total = 0;"
                    + "    }\n"
            6,
                Collections.emptyMap(),
                "long sum = 0; long[] array = new long[] { 1, 2, 3 };"
        List<Integer> expected = Collections.singletonList(1);
                    + "boolean found = false;"
        assertEquals(
                    + "        x = 3;\n"
                    + "List keys = ['test0', 'test1', 'test2'];"
                    + "}"
        assertEquals((byte) 2, exec("byte a = 2; return a;"));
                    + " String cat = ''; int total = 0;"
            exec("int[] a = new int[3]; a[0] = 1; a[1] = 2; a[2] = 3; int total = 0;" + " for (int x : a) total += x; return total")
        assertEquals(10, exec("def i = 1; if (i == 1) {return 10} else {return 12}"));
                    + "        if (found) {"
    public void testForStatement() {
        expected.set(1, 1);
        assertEquals(0, exec("int x = 4; if (x == 5) return 1; else return 0;"));
 * KIND, either express or implied.  See the License for the
                    + " String cat = ''; int total = 0;"
                    + "List rtn = new ArrayList(); test(rtn); rtn"
    public void testArrayForEachStatement() {
        );
    @Override
                    + "            ++j;"
            6L,
                    + "            break;"
        assertEquals(
        }
                    + "Map inner = ['test1' : '2'];"
    public void testDoWhileStatement() {
        assertEquals(2L, exec("long a = 2; return a;"));
                    + "        if (found) {"
                    + "    if (outer.containsKey('test3')) {"
                    + "            }"
                    + " for (Map.Entry e : m.entrySet()) { cat += e.getKey(); total += e.getValue(); } return cat + total"
                + " return b;                          \n"
    public void testIterableForEachStatement() {
        assertEquals(
                    + "        if (found) {"
        );
                    + "    }"
                    + "            break;"
        assertEquals(float[].class, exec("float[] a = new float[1]; return a;").getClass());
                true
        );
        assertEquals(2F, exec("float a = 2; return a;"));
 * this work for additional information regarding copyright
        assertEquals(10, exec("def i = 1; if (i == 1) {return 10}"));
                + "                                  \n"
            6L,
                "void test(List list) {if (list.isEmpty()) {list.add(1); return} list.add(2);} "
            expected,
        );
            "123",
                    + "    }"
            exec("def a = new String[3]; a[0] = '1'; a[1] = '2'; a[2] = '3'; def total = '';" + " for (x in a) total += x; return total")
                    + " String cat = ''; int total = 0;"
    public void testWhileStatement() {
                    + "boolean found = false;"
            exec(
            }
                    + "            }"
        assertEquals(
                + " while (x < 5) {                    \n"
                "long sum = 0; long[] array = new long[] { 1, 2, 3 };"
                + "     ++x;                         \n"
                + " byte x = 0, y;                     \n"
            )
 */
        getEngine().compile("testOneArg", "if (arg.isEmpty()) {arg.add(1); return} arg.add(2);", OneArg.CONTEXT, emptyMap())
        assertEquals(
                + "     for (int y = 0; y < 5; ++y) { \n"
    @BeforeClass
                    + " for (String x : l) cat += x; return cat"
            }
        );
        );
        input = new ArrayList<>();
        expected.set(0, 3);
            )
    private static PainlessScriptEngine SCRIPT_ENGINE;
            )
                + "                                   \n"
                Collections.singletonMap(CompilerSettings.MAX_LOOP_COUNTER, "0"),
                    + "        break;"
                    + "            break;"
    public void testDeclarationStatement() {
                "Map outer = ['test1' : '1'];"
        );
                + " }                                 \n"
                    + "boolean found = false;"
        assertEquals(
                "int[][] i = new int[3][1]; i[0][0] = 1; i[1][0] = 2; i[2][0] = 3; int total = 0;"
                    + "[i, j];"
            exec("def l = new ArrayList(); l.add(1); l.add(2); l.add(3); int total = 0;" + " for (int x : l) total += x; return total")
        byte[][] b = (byte[][]) value;
                    + "        if (found) {"
 * Unless required by applicable law or agreed to in writing,
                    + "List keys = ['test0', 'test1', 'test2'];"
                    + "\n"
            exec(
            exec(
        );
            for (byte y = 0; y < 5; ++y) {
        );
import org.opensearch.script.ScriptContext;
            .newInstance()
                    + "Map inner = ['test1' : '1'];"
        );
                + " }                                  \n"
            6,
                "def a = new String[3]; a[0] = '1'; a[1] = '2'; a[2] = '3'; def total = '';"
 * GitHub history for details.
            exec(
        assertEquals(
                "void test(List list) {if (list.isEmpty()) {list.add(1); return;} list.add(2);} "
                    + "boolean found = false;"
                    + "    if (outer.containsKey(okey)) {"
        // multiple breaks test
                    + "    }"
        assertEquals("aaaaaa", exec("String c = \"a\"; int x; while (x < 5) { c += \"a\"; ++x; } return c;"));
                    + "for (String okey : keys) {"
            exec(
            exec(
 * under the License.
                    + "List keys = ['test0', 'test1', 'test2'];"
                Collections.emptyMap(),
    }
    public void testArrayLoopWithoutCounter() {
        assertEquals(10, exec("def i = 1; if (i == 1) {i = 2; return 10} else {return 12}"));
                    + "    ++i;"
 * specific language governing permissions and limitations
        assertEquals("aaaaaa", exec("String c = \"a\"; for (int x = 0; x < 5; ++x) c += \"a\"; return c;"));
            "1236",
                    + "List rtn = new ArrayList(); test(rtn); rtn"
        assertEquals(2, exec("int a = 2; return a;"));
        );
 */
        );
                + "                                    \n"
                + "     while (y < 5) {                \n"
        assertEquals(float[][][].class, exec("float[][][] a = new float[1][2][3]; return a;").getClass());
                    + "            break;"
                    + " for (int[] j : i) total += j[0]; return total"
                    + "        for (String ikey : keys) {"
    }
        assertEquals(
        assertEquals(
        assertEquals(
        // multiple breaks test, ignore outer break
        );
                "Map settings = ['test1' : '1'];"
    }
                "Map settings = ['test1' : '1'];"
        }
        assertEquals(
        assertEquals(1, exec("int x = 5; if (x == 5) return 1; return 0;"));
        expected = new ArrayList<>();
                    + "                break;"
 *    http://www.apache.org/licenses/LICENSE-2.0
        int[][] b = (int[][]) value;
import java.util.ArrayList;
        );
                    + "    if (y == 2) {\n"
                    + "            }"
        assertEquals(
        public interface Factory {
import org.junit.AfterClass;
        );
                "def m = new HashMap(); m.put('1', 1); m.put('2', 2); m.put('3', 3);"
            exec(
    protected PainlessScriptEngine getEngine() {
            for (byte y = 0; y < 5; ++y) {
    public abstract static class OneArg {
                    + "for (; i < keys.size(); ++i) {"
            .execute(input);
    public void testContinueStatement() {
                    + "}"
        assertEquals(
                assertEquals(x * y, b[x][y]);
                    + "}"
    }
        expected.add(2);
                    + "            break;"
            )
                "String[] a = new String[3]; a[0] = '1'; a[1] = '2'; a[2] = '3'; def total = '';" + " for (x in a) total += x; return total"
                    + "}"
    }
                    + " for (String x : a) total += x; return total"
    public void testReturnStatement() {
        assertEquals(
        assertEquals(
        assertEquals(
                    + "                break;"
        );
        assertEquals("aaaaaa", exec("String c = \"a\"; int x; do { c += \"a\"; ++x; } while (x < 5); return c;"));
import org.opensearch.common.settings.Settings;
                    + "    \n"
        assertEquals(long[].class, exec("long[] a = new long[1]; return a;").getClass());
        assertEquals(Collections.singletonList(1), input);
        assertEquals(String[][].class, exec("String[][] a = new String[1][2]; return a;").getClass());
    }
                true
        assertEquals(
                    + "[i, j];"
                    + "Map inner = ['test0' : '2'];"
            6,
        List<Integer> expected = new ArrayList<>();
    }
        );
        // single break test
        // multiple breaks test
                    + "Map inner = ['test0' : '2'];"
                    + "for (int i = 0; i < array.length; i++) { sum += array[i] } return sum",
            exec(
        assertEquals(
                    + "    if (outer.containsKey(keys[i])) {"
            exec(
            exec(
        Map<ScriptContext<?>, List<Allowlist>> contexts = newDefaultContexts();
            exec(
                    + "Map inner = ['test3' : '2'];"
                    + "    if (outer.containsKey(okey)) {"
    }
                + "         b[x][y] = x*y;           \n"
        // One statement in the block in case that is a special case
                    + "int i = 0, j = 0;"
            )
        assertEquals(byte[].class, exec("byte[] a = new byte[1]; return a;").getClass());
 */
                    + "return i;"
 * SPDX-License-Identifier: Apache-2.0
            expected,
            )
                    + "    ++i;"
                    + "    }"
                    + "int i = 0, j = 0;"
        // multiple breaks test, ignore inner break
    public void testArrayForEachStatementDef() {
        assertEquals(boolean[].class, exec("boolean[] a = new boolean[1]; return a;").getClass());
            exec(
                    + "        }"
        assertEquals(
            )
                    + " for (Map.Entry e : m.entrySet()) { cat += e.getKey(); total += e.getValue(); } return cat + total"
                + "     }                             \n"
                "List l = new ArrayList(); l.add('1'); l.add('2'); l.add('3'); String cat = '';"
    }
                + " do {                             \n"
    }
        );
        expected.set(1, 3);
        input.add(0);
            1,
        assertEquals(double[][][][].class, exec("double[][][][] a = new double[1][2][3][4]; return a;").getClass());
                    + "        for (; j < keys.size(); ++j) {"
        int[][] b = (int[][]) value;
                + "         b[x][y] = (byte)(x*y);     \n"
        // multiple breaks test, ignore outer break
                    + " for (String x : a) total += x; return total"
        // Two statements in the block, in case that is the general case
    public void testLastInBlockDoesntNeedSemi() {
            exec("List l = new ArrayList(); l.add(1); l.add(2); l.add(3); int total = 0;" + " for (x in l) total += x; return total")
            for (byte y = 0; y < 5; ++y) {
        SCRIPT_ENGINE = null;
                    + "            break;"
    public void testIterableForEachStatementDef() {
            )
        assertEquals(false, exec("boolean a = false; return a;"));
            OneArg newInstance();
                + "                                    \n"
        );
import org.junit.BeforeClass;
                    + "    if (outer.containsKey(okey)) {"
        assertEquals(
                    + " for (e in m.entrySet()) { cat += e.getKey(); total += e.getValue(); } return cat + total"
                    + "int i = 0;"
        public abstract void execute(List<Integer> arg);
            6L,
            exec("def a = new int[3]; a[0] = 1; a[1] = 2; a[2] = 3; int total = 0;" + " for (int x : a) total += x; return total")
        assertEquals(
        assertEquals(
    }
        assertEquals(2, exec("int x = 4; if (x == 5) return 1; else if (x == 4) return 2; else return 0;"));
                    + " for (int[] j : i) total += j[0]; return total"
        assertEquals(10, ((Map) exec("Map s = new HashMap(); s.put(\"x\", 10); return s;")).get("x"));
                    + "List keys = ['test0', 'test1', 'test2'];"
                    + "List keys = ['test0', 'test1', 'test2'];"
                "int[][] i = new int[3][1]; i[0][0] = 1; i[1][0] = 2; i[2][0] = 3; int total = 0;"
            expected,
            exec("List l = new ArrayList(); l.add('1'); l.add('2'); l.add('3'); String cat = '';" + " for (x in l) cat += x; return cat")
            6,
            3,
import java.util.Map;
        assertEquals(Map[].class, exec("Map[] a = new Map[1]; return a;").getClass());
                    + "        }"
                    + "}"
            "123",
                    + "int i = 0; while (i < array.length) { sum += array[i++] } return sum",
        assertEquals(
            expected,
                "void test(List list) {if (list.isEmpty()) {list.add(1); return} list.add(2);} "
            exec("int[] a = new int[3]; a[0] = 1; a[1] = 2; a[2] = 3; int total = 0;" + " for (x in a) total += x; return total")
        assertEquals(Collections.singletonList(1), input);
        );
                + "     y = 0;                         \n"
                    + " for (j in i) total += j[0]; return total"
                assertEquals(x * y, b[x][y]);
            )
                    + "    }"
        assertEquals(
            exec(
            " int[][] b = new int[5][5]; \n"
    @SuppressWarnings("rawtypes")
            exec(
        Object value = exec(
                + "     y = 0;                       \n"
                "Map outer = ['test1' : '1'];"
            " byte[][] b = new byte[5][5];       \n"
                Collections.emptyMap(),
                    + "            }"
    // tests both single break and multiple breaks used in a script
        );
                "Map outer = ['test1' : '1'];"
            .execute(input);
                    + "[i, j];"
                    + "if (x == 5) {\n"
            exec(
        assertEquals(
                    + "        for (; j < keys.size(); ++j) {"
        input = new ArrayList<>();
                    + "for (String okey : keys) {"
        assertEquals(byte[][].class, exec("byte[][] a = new byte[1][2]; return a;").getClass());
                    + "        for (String ikey : keys) {"
        );
 *
                    + "boolean found = false;"
    }
            )
                    + "List keys = ['test0', 'test1', 'test2'];"
        assertEquals(short[].class, exec("short[] a = new short[1]; return a;").getClass());
            1,
            exec("def l = new ArrayList(); l.add('1'); l.add('2'); l.add('3'); String cat = '';" + " for (x in l) cat += x; return cat")
        );
            "1236",
        assertEquals(6, exec("int x, y; for (x = 0; x < 4; ++x) {y += x;} return y;"));
        );
        // single break test
            expected,
        assertEquals(
                + "     }                              \n"
    }
        assertEquals(long[][].class, exec("long[][] a = new long[1][2]; return a;").getClass());
                + " int x = 0, y;                    \n"
        expected.set(0, 1);
import java.util.List;
            "123",
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
        assertEquals(10, exec("return 10;"));
                    + "            if (inner.containsKey(ikey)) {"
                    + "}"
            exec(
        assertEquals(String[].class, exec("String[] a = new String[1]; return a;").getClass());
                    + "int i = 0;"
        );
                    + "        }"
        expected.set(1, 3);
 * the Apache License, Version 2.0 (the "License"); you may
            "123",
            "1236",
        assertEquals("string", exec("String a = \"string\"; return a;"));
                    + "            }"
            )
        assertEquals(Map[][][].class, exec("Map[][][] a = new Map[1][2][3]; return a;").getClass());
            )
                    + "return x;\n"
        expected.add(0);
            )
    public void testForEachWithBreak() {
            .newInstance()
                + "         b[x][y] = x*y;            \n"
                    + "                break;"
                    + "            ++j;"
                    + "        }"
import static java.util.Collections.emptyMap;
        expected.set(1, 1);
            )
                    + "    }"
            )
        expected.add(1);
                "def l = new ArrayList(); l.add('1'); l.add('2'); l.add('3'); String cat = '';" + " for (String x : l) cat += x; return cat"
        assertEquals(1, exec("int x = 4; if (x == 5) return 1; else if (x == 4) return 1; else return 0;"));
            6,
                assertEquals(x * y, b[x][y]);
            6,
                "int x = 5;\n"
        assertEquals(10, exec("def i = 1; if (i == 1) {i = 2; return 10}"));
        );
                + " } while (x < 5);                 \n"
                    + "for (; i < keys.size(); ++i) {"
        for (byte x = 0; x < 5; ++x) {
            )
        assertEquals(4, exec("int[] x = new int[2]; x[1] = 4; return x[1];"));
                    + "    if (settings.containsKey(key)) {"
    }
        );
                    + "        }"
 * license agreements. See the NOTICE file distributed with
                + "                                  \n"
        }
    }
        }
                    + "[i, j];"
        getEngine().compile("testOneArg", "if (arg.isEmpty()) {arg.add(1); return} arg.add(2);", OneArg.CONTEXT, emptyMap())
                    + "for (String okey : keys) {"
            6,
    public void testForWithBreak() {
                    + "            if (inner.containsKey(keys[j])) {"
                    + "}"
            .newInstance()
                    + "return i;"
            6,
        assertEquals(
            exec(
            exec(
        );
    public static void afterClass() {
                    + "[i, j];"
        for (byte x = 0; x < 5; ++x) {
            }
                    + "int i = 0, j = 0;"
                    + "            if (inner.containsKey(keys[j])) {"
        assertEquals(boolean[][][][][].class, exec("boolean[][][][][] a = new boolean[1][2][3][4][5]; return a;").getClass());
            )
    }
            exec(
                    + "                found = true;"
        );
                    + " for (e in m.entrySet()) { cat += e.getKey(); total += e.getValue(); } return cat + total"
            )
                + "                                    \n"
        assertEquals(2.0, exec("double a = 2; return a;"));
        );
}
        assertEquals(
                "Map outer = ['test1' : '1'];"
 * this file be licensed under the Apache-2.0 license or a
                    + "        found = true;"
            .execute(input);
                + "     do {                         \n"
    public void testVoidReturnStatement() {
 * not use this file except in compliance with the License.
                + "         ++y;                       \n"
        assertEquals(
                    + "        }"
        );
        assertEquals(
            "123",
/*
                    + "        }"
                    + "int i = 0, j = 0;"
 * The OpenSearch Contributors require contributions made to
            exec("def l = new ArrayList(); l.add(1); l.add(2); l.add(3); int total = 0;" + " for (x in l) total += x; return total")
                    + "                break;"
                    + "for (; i < keys.size(); ++i) {"
public class BasicStatementTests extends ScriptTestCase {
            exec(
    }
        public static final String[] PARAMETERS = new String[] { "arg" };
                Collections.singletonMap(CompilerSettings.MAX_LOOP_COUNTER, "0"),
                    + "            }"
        assertEquals((char) 2, exec("char a = 2; return a;"));
    public static void beforeClass() {
                    + "            ++j;"
            )
            " int[][] b = new int[5][5];  \n"
                    + "for (String key : keys) {"
                    + "                break;"
 * You may obtain a copy of the License at
            expected,
        public static final ScriptContext<OneArg.Factory> CONTEXT = new ScriptContext<>("onearg", OneArg.Factory.class);
import org.opensearch.painless.spi.Allowlist;
        Object value = exec(
                    + "List rtn = new ArrayList(); rtn.add(0); test(rtn); rtn"
                    + "        }"
        assertEquals((short) 2, exec("short a = 2; return a;"));
    @AfterClass
/*
        assertEquals(9, exec("int x = 0, y = 0; while (x < 10) { ++x; if (x == 1) continue; ++y; } return y;"));
            6,
                    + "boolean found = false;"
                "long sum = 0; long[] array = new long[] { 1, 2, 3 };"
                + " return b;                        \n"
            )
                + "                                  \n"
 * ownership. Elasticsearch licenses this file to you under
                    + "        }"
            exec(
            exec(
                    + "int i = 0, j = 0;"
        );
                    + "                break;"
                    + "    }"
                "Map outer = ['test3' : '1'];"
                    + "            if (found) {"
                + "     ++x;                           \n"
            exec(
                    + "        }"
            )
    public void testIfStatement() {
        assertEquals(short[][][].class, exec("short[][][] a = new short[1][2][3]; return a;").getClass());
        );
 *
                "Map m = new HashMap(); m.put('1', 1); m.put('2', 2); m.put('3', 3);"
            "123",
        assertEquals(int[].class, exec("int[] a = new int[1]; return a;").getClass());
            expected,
                    + "int i = 0; do { sum += array[i++] } while (i < array.length); return sum",
            6,
            "123",
        assertEquals(
        );
                    + "            if (found) {"
    }
        assertEquals(
            exec("def a = new int[3]; a[0] = 1; a[1] = 2; a[2] = 3; int total = 0;" + " for (x in a) total += x; return total")
                    + "    if (settings.containsKey(keys[i])) {"
            exec(
    }
    public void testBreakStatement() {
                    + "}\n"
                    + "        for (String ikey : keys) {"
    // tests both single break and multiple breaks used in a script
        assertEquals(
        assertEquals(char[][][][].class, exec("char[][][][] a = new char[1][2][3][4]; return a;").getClass());
        expected.set(0, 3);
        expected.add(0);
                + "     } while (y < 5);             \n"
        contexts.put(OneArg.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            exec(
            )
                    + "    }"
                "Map m = new HashMap(); m.put('1', 1); m.put('2', 2); m.put('3', 3);"
        assertEquals(
        );
 *
                + " return b;                         \n"
    }
        );
                    + "    int y = 2;\n"
                "Map outer = ['test1' : '1'];"
                "String[] a = new String[3]; a[0] = '1'; a[1] = '2'; a[2] = '3'; def total = '';"
        assertEquals(char[].class, exec("char[] a = new char[1]; return a;").getClass());
        Object value = exec(
        for (byte x = 0; x < 5; ++x) {
        );
/*
        expected.add(0);
        expected.add(1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                Collections.singletonMap(CompilerSettings.MAX_LOOP_COUNTER, "0"),
package org.opensearch.painless;
        assertEquals(4, exec("int x = 0, y = 0; while (x < 10) { ++x; if (x == 5) break; ++y; } return y;"));
                    + "        if (found) {"
                    + "int i = 0, j = 0;"
        assertEquals(
                    + "        found = true;"
                "def m = new HashMap(); m.put('1', 1); m.put('2', 2); m.put('3', 3);"
        assertEquals(
        );
            )
                    + "        }"
                    + "}"
        ArrayList<Integer> input = new ArrayList<>();
                    + "for (; i < keys.size(); ++i) {"
            6,
