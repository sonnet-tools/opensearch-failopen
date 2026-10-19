    }
    }
        assertEquals(2, exec("Map m = new TreeMap(); m.one = 1; m.two = 2; Map m2 = new TreeMap(); m.each(m2::put); return m2.size()"));
/*
        );
        assertEquals(5.0D, exec("List l = new ArrayList(); l.add(1); l.add(2); l.sum(x -> x + 1)"));
import org.opensearch.script.ScriptContext;
 * the Apache License, Version 2.0 (the "License"); you may
        );
    }
    }
    private static PainlessScriptEngine SCRIPT_ENGINE;
        assertEquals(
    }
    private static class SplitCase {
    }
            new SplitCase("1.1.1.1.111", "1"),
        assertEquals("62cdb7020ff920e5aa642c3d4066950dd1f01f4d", execDigest("'bar'.sha1()"));
 * You may obtain a copy of the License at
        Map<ScriptContext<?>, List<Allowlist>> contexts = newDefaultContexts();
 */
        assertEquals("test,ing", exec("List l = new ArrayList(); l.add('test'); l.add('ing'); l.join(',')"));
    public void testMap_GroupBy() {
    }
    public String execDigest(String script) {
            );
 */
        assertEquals(
    }
            new SplitCase("1.1.1.1.111", "."),
                    + " ft.setX(3); ft.setY(2); return ft.getTotal()"
        assertEquals("found", exec("List l = new ArrayList(); l.add(1); l.add(2); return l.findResult(x -> x > 1 ? 'found' : null)"));
        assertEquals(false, exec("Map m = new TreeMap(); m.one = 1; m.two = 2; m.every((key,value) -> value == 2)"));
 *
/*
        assertEquals(
            new SplitCase("a,,b,,c", ",", 1),
import org.junit.BeforeClass;
            this.count = count;
            this(input, token, -1);
        SplitCase(String input, String token, int count) {
        assertEquals(2, exec("List l = new ArrayList(); l.add(1); l.add(-1); l.groupBy(x -> x < 0 ? 'negative' : 'positive').size()"));
            )
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
public class AugmentationTests extends ScriptTestCase {
        );
import org.opensearch.common.settings.Settings;
    }
    }
        assertEquals(1, exec("List l = new ArrayList(); l.add(1); return l.getLength();"));
    public void testMap_FindResults() {
 * this work for additional information regarding copyright
        assertEquals(
    }
        );
import java.util.HashMap;
            exec("int foo(Supplier t) { return t.get() }" + "ArrayList l = new ArrayList(); l.add(1);" + "return foo(l::getLength);")
        assertEquals(true, exec("List l = new ArrayList(); return l.asList() === l"));
        );
    @AfterClass
        SplitCase[] cases = new SplitCase[] {
    public void testIterable_AsCollection() {
            exec("def ft = new org.opensearch.painless.FeatureTestObject();" + " ft.setX(3); ft.setY(2); return ft.getTotal()")
    }
 * not use this file except in compliance with the License.
        assertEquals(
            new SplitCase("a,b,c", "|"),
        List<Allowlist> digestAllowlist = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
import java.util.Collections;
    }
                "Map m = new TreeMap(); m.one = 1; m.two = 2; "
    }
        final String token;
 */
            Collections.singletonMap("two", 2),
    }
        assertEquals(
    }
            exec("Map m = new TreeMap(); m.one = 1; m.two = 2; return m.findResult((key,value) -> value == 2 ? 'found' : null)")
        assertEquals(Arrays.asList(2), exec("List l = new ArrayList(); l.add(1); l.add(2); return l.findAll(x -> x == 2)"));
            new SplitCase("1\n1.1.\r\n1\r\n111", "\r\n"), };
    @Override
            this.input = input;
        assertEquals(true, exec("List l = new ArrayList(); l.add(1); l.any(x -> x == 1)"));
    public void testCollection_Split() {
            new SplitCase("aaaaaaa", "a", 2),
    public void testString_SplitOnToken() {
            exec(
        assertEquals(true, exec("List l = new ArrayList(); return l.asCollection() === l"));
        );
    public void testMap_FindAll() {
        assertEquals(
import java.util.ArrayList;
    }
            exec("int foo(Supplier t) { return t.get() }" + "List l = new ArrayList(); l.add(1);" + "return foo(l::getLength);")
    }
                "org.opensearch.painless.FeatureTestObject ft = new org.opensearch.painless.FeatureTestObject();"
    }
            1,
            DigestTestScript newInstance();
    public void testIterable_FindResults() {
            "notfound",
            exec("def ft = new org.opensearch.painless.FeatureTestObject();" + " ft.setX(3); ft.setY(2); return ft.addToTotal(3)")
 * KIND, either express or implied.  See the License for the
            new SplitCase("a,,b,,c", ",", 300),
        assertEquals(
        return SCRIPT_ENGINE;
    }
            exec("Map m = new TreeMap(); m.a = -1; m.b = 1; " + "return m.groupBy((key,value) -> value < 0 ? 'negative' : 'positive')")
            8,
        assertEquals("fcde2b2edba56bf408601fb721fe9b5c338d10ee429ea04fae5511b68fbf8fb9", execDigest("'bar'.sha256()"));
        );
            )
    public void testIterable_GroupBy() {
        assertEquals(0, exec("List l = new ArrayList(); l.add(2); Map m = new HashMap(); l.eachWithIndex(m::put); return m.get(2)"));
import org.opensearch.painless.spi.AllowlistLoader;
    public void testIterable_Each() {
        assertEquals(
        assertEquals(Arrays.asList(2, 3), exec("List l = new ArrayList(); l.add(1); l.add(2); l.collect(x -> x + 1)"));
        assertEquals(1, exec("Map m = new TreeMap(); m.one = 1; m.two = 2; m.count((key,value) -> value == 2)"));
        assertEquals(
        }
            exec(
        );
 * this file be licensed under the Apache-2.0 license or a
    public void testStatic() {
 *
            Arrays.asList("one1", "two2"),
        }
            5,
        assertEquals(false, exec("List l = new ArrayList(); l.add(1); l.add(2); l.every(x -> x == 1)"));
    public void testMap_Each() {
            "notfound",
    public void testMap_Find() {
        contexts.put(DigestTestScript.CONTEXT, digestAllowlist);
        public static final ScriptContext<DigestTestScript.Factory> CONTEXT = new ScriptContext<>("test", DigestTestScript.Factory.class);
    public static void afterClass() {
 * license agreements. See the NOTICE file distributed with
        assertEquals("two", exec("Map m = new TreeMap(); m.one = 1; m.two = 2; return m.find((key,value) -> value == 2).key"));
        assertEquals(1, exec("def l = new ArrayList(); l.add(1); return l.length;"));
 * GitHub history for details.
    }
        );
        assertEquals(1, exec("def l = new ArrayList(); l.add(1); return l.getLength();"));
    }
        public static final String[] PARAMETERS = {};
    }
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.
            exec("Map m = new TreeMap(); m.a = -1; m.b = 1; " + "return m.findResults((key,value) -> value < 0 ? 'negative' : 'positive')")
    }
        );
    }
        }
    public void testCollection_FindAll() {
            new SplitCase("a,,b,,c", ",", 3),
    @BeforeClass
            new SplitCase("a,,b,,c", ","),
    }
    public void testMap_FindResult() {
            5,
    public void testFeatureTest() {
        final String input;
            new SplitCase("a,b,c", ","),
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        public abstract String execute();
}
        );
        assertEquals("5f5513f8822fdbe5145af33b64d8d970dcf95c6e", execDigest("'foobarbaz'.sha1()"));
    public void testMap_Count() {
        assertEquals(
    public void testMap_Collect() {
            asSet("one1", "two2"),
 * specific language governing permissions and limitations
    public void testSha1() {
            exec("List l = new ArrayList(); l.add(1); l.add(2); return l.findResult('notfound', x -> x > 10 ? 'found' : null)")
import org.junit.AfterClass;
        assertEquals(asSet(2, 3), exec("List l = new ArrayList(); l.add(1); l.add(2); l.collect(new HashSet(), x -> x + 1)"));
                    + " ft.setX(3); ft.setY(2); return ft.addToTotal(3)"
        );
    public void testCapturingReference() {
        return getEngine().compile("digest_test", script, DigestTestScript.CONTEXT, Collections.emptyMap()).newInstance().execute();
            1,
        assertEquals(1, exec("List l = new ArrayList(); l.add(1); return l.length;"));
        final int count;
        );
            exec("Map m = new TreeMap(); m.one = 1; m.two = 2; m.collect((key,value) -> key + value)")
    }
    }
    }
            exec("List l = new ArrayList(); l.add(1); l.add(2); return l.split(x -> x == 2)")
            Arrays.asList("negative", "positive"),
            new SplitCase("", ""),
    public void testIterable_Any() {
import java.util.List;
        assertEquals("0beec7b5ea3f0fdbc95d0dd47f3c5bc275da8a33", execDigest("'foo'.sha1()"));
            1,
    public void testIterable_AsList() {
                    + "return m.findResult('notfound', (key,value) -> value == 10 ? 'found' : null)"
            exec("Map m = new TreeMap(); m.one = 1; m.two = 2; return m.findAll((key,value) -> value == 2)")
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(
        assertEquals(1, exec("ArrayList l = new ArrayList(); l.add(1); return l.length;"));
            exec("int foo(Supplier t) { return t.get() }" + "def l = new ArrayList(); l.add(1);" + "return foo(l::getLength);")
        );
    public void testMap_Every() {
            exec("Map m = new TreeMap(); m.one = 1; m.two = 2; m.collect(new HashSet(), (key,value) -> key + value)")
        assertEquals(3.0D, exec("def l = [1,2]; return l.sum()"));
        public interface Factory {
    public void testSha256() {
package org.opensearch.painless;
    }
import java.util.Arrays;
    }
        assertEquals(
    public void testDef() {
    public void testIterable_Sum() {
        assertEquals("2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae", execDigest("'foo'.sha256()"));
 * Unless required by applicable law or agreed to in writing,
                split.input.split(Pattern.quote(split.token), split.count),
            expected,
            new SplitCase("aaaaaaa", "a"),
    public void testCollection_Find() {
    }
import org.opensearch.painless.spi.Allowlist;
        );
    public static void beforeClass() {
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(
    }
        assertEquals(2, exec("List l = new ArrayList(); l.add(1); l.add(2); return l.find(x -> x == 2)"));
        assertEquals(
        assertEquals(5, exec("Set l = new HashSet(); l.add(5); return l.asList()[0]"));
                (String[]) exec("return \"" + split.input + "\".splitOnToken(\"" + split.token + "\", " + split.count + ");")
 * Licensed to Elasticsearch under one or more contributor
                "org.opensearch.painless.FeatureTestObject ft = new org.opensearch.painless.FeatureTestObject();"
            )
    protected PainlessScriptEngine getEngine() {
    public void testSubclass() {
        SplitCase(String input, String token) {
/*
            assertArrayEquals(
        }
            this.token = token;
        digestAllowlist.add(AllowlistLoader.loadFromResourceFiles(Allowlist.class, "org.opensearch.ingest.txt"));
        Map<String, Map<String, Integer>> expected = new HashMap<>();
import java.util.regex.Pattern;
        assertEquals(1, exec("List l = new ArrayList(); l.add(1); List l2 = new ArrayList(); l.each(l2::add); return l2.size()"));
        assertEquals(
        );
        SCRIPT_ENGINE = null;
 * software distributed under the License is distributed on an
import java.util.Map;
 * compatible open source license.
            new SplitCase("a,b,c", "a,b,c,d"),
    public void testIterable_Every() {
    public void testIterable_Join() {
        assertEquals(1, exec("List l = new ArrayList(); l.add(1); l.add(2); l.findResults(x -> x == 1 ? x : null).size()"));
        assertEquals("97df3588b5a3f24babc3851b372f0ba71a9dcdded43b14b9d06961bfc1707d9d", execDigest("'foobarbaz'.sha256()"));
 * The OpenSearch Contributors require contributions made to
        expected.put("negative", Collections.singletonMap("a", -1));
            Arrays.asList(Arrays.asList(2), Arrays.asList(1)),
        for (SplitCase split : cases) {
    }
            8,
    public abstract static class DigestTestScript {
    public void testIterable_EachWithIndex() {
    }
            exec(
            "found",
        assertEquals(1, exec("ArrayList l = new ArrayList(); l.add(1); return l.getLength();"));
    public void testCollection_FindResult() {
        expected.put("positive", Collections.singletonMap("b", 1));
 *
    public void testCollection_Collect() {
