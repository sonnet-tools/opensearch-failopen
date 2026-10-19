            exec(
import org.opensearch.painless.spi.Allowlist;
    @BeforeClass
    public void testDef() {  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        }  
            new SplitCase("aaaaaaa", "a"),
        assertEquals(1, exec("def l = new ArrayList(); l.add(1); return l.length;"));
            this(input, token, -1);  
            exec(
    public void testMap_GroupBy() {
        assertEquals("5f5513f8822fdbe5145af33b64d8d970dcf95c6e", execDigest("'foobarbaz'.sha1()"));
 * license agreements. See the NOTICE file distributed with
                (String[]) exec("return \"" + split.input + "\".splitOnToken(\"" + split.token + "\", " + split.count + ");")
    public void testCollection_Split() {
    public void testCollection_FindResult() {  
        assertEquals("0beec7b5ea3f0fdbc95d0dd47f3c5bc275da8a33", execDigest("'foo'.sha1()"));
        final String token;
    }
    public void testIterable_Join() {
        }
import org.junit.AfterClass;
 * You may obtain a copy of the License at  
    public void testIterable_Sum() {  
import java.util.Map;
    public void testSubclass() {
        assertEquals(1, exec("List l = new ArrayList(); l.add(1); List l2 = new ArrayList(); l.each(l2::add); return l2.size()"));
import org.opensearch.painless.spi.AllowlistLoader;  
    }  
        assertEquals(Arrays.asList(2), exec("List l = new ArrayList(); l.add(1); l.add(2); return l.findAll(x -> x == 2)"));  
                "org.opensearch.painless.FeatureTestObject ft = new org.opensearch.painless.FeatureTestObject();"
        expected.put("positive", Collections.singletonMap("b", 1));
    public void testMap_FindResult() {
        assertEquals(  
            new SplitCase("a,b,c", "|"),
            exec("Map m = new TreeMap(); m.one = 1; m.two = 2; return m.findAll((key,value) -> value == 2)")  
        }  
        assertEquals(true, exec("List l = new ArrayList(); l.add(1); l.any(x -> x == 1)"));  
            Arrays.asList("one1", "two2"),
        assertEquals(
        assertEquals(  
            )
    public static void beforeClass() {
        assertEquals(  
            5,
        );
    }  
    public void testCollection_Find() {
    }
        contexts.put(DigestTestScript.CONTEXT, digestAllowlist);  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        assertEquals("97df3588b5a3f24babc3851b372f0ba71a9dcdded43b14b9d06961bfc1707d9d", execDigest("'foobarbaz'.sha256()"));
            new SplitCase("a,,b,,c", ",", 300),  
    }
    }  
            new SplitCase("", ""),  
    protected PainlessScriptEngine getEngine() {
            "found",  
    }
        assertEquals(3.0D, exec("def l = [1,2]; return l.sum()"));
        public abstract String execute();
 * SPDX-License-Identifier: Apache-2.0
    private static class SplitCase {  
        List<Allowlist> digestAllowlist = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
 * GitHub history for details.
        );
            exec("Map m = new TreeMap(); m.one = 1; m.two = 2; m.collect((key,value) -> key + value)")  
            8,  
    }  
            exec(
import java.util.HashMap;
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.token = token;
    }
 * this file be licensed under the Apache-2.0 license or a
    }
                "org.opensearch.painless.FeatureTestObject ft = new org.opensearch.painless.FeatureTestObject();"  
public class AugmentationTests extends ScriptTestCase {
            )
    }
        assertEquals(
        return getEngine().compile("digest_test", script, DigestTestScript.CONTEXT, Collections.emptyMap()).newInstance().execute();
package org.opensearch.painless;
            1,
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(
    }  
            expected,  
    }  
            exec("Map m = new TreeMap(); m.a = -1; m.b = 1; " + "return m.findResults((key,value) -> value < 0 ? 'negative' : 'positive')")  
            )
    }
    @Override  
        SplitCase[] cases = new SplitCase[] {
        );
        final String input;
import org.junit.BeforeClass;  
        assertEquals(
 * Licensed to Elasticsearch under one or more contributor  
            new SplitCase("a,,b,,c", ","),  
    }
    }
    public void testStatic() {
    }
        assertEquals("found", exec("List l = new ArrayList(); l.add(1); l.add(2); return l.findResult(x -> x > 1 ? 'found' : null)"));
            1,  
        assertEquals(1, exec("List l = new ArrayList(); l.add(1); l.add(2); l.findResults(x -> x == 1 ? x : null).size()"));
            asSet("one1", "two2"),  
        assertEquals(2, exec("List l = new ArrayList(); l.add(1); l.add(-1); l.groupBy(x -> x < 0 ? 'negative' : 'positive').size()"));
            exec("def ft = new org.opensearch.painless.FeatureTestObject();" + " ft.setX(3); ft.setY(2); return ft.addToTotal(3)")
    }  
    }
            1,
    }
    public void testFeatureTest() {
    public void testSha1() {
            new SplitCase("a,,b,,c", ",", 3),
    public void testMap_Count() {
    }  
        SplitCase(String input, String token) {
            "notfound",
        assertEquals(
        );
        assertEquals(1, exec("List l = new ArrayList(); l.add(1); return l.length;"));  
    private static PainlessScriptEngine SCRIPT_ENGINE;
            new SplitCase("1.1.1.1.111", "1"),
        );
            exec("int foo(Supplier t) { return t.get() }" + "List l = new ArrayList(); l.add(1);" + "return foo(l::getLength);")  
    public void testIterable_AsCollection() {  
        assertEquals(1, exec("List l = new ArrayList(); l.add(1); return l.getLength();"));
    }  
        assertEquals(  
    }  
    }
    public void testMap_Every() {
 *
            );
        );
 * under the License.  
            exec("Map m = new TreeMap(); m.one = 1; m.two = 2; return m.findResult((key,value) -> value == 2 ? 'found' : null)")
import java.util.regex.Pattern;
        SplitCase(String input, String token, int count) {
            exec("Map m = new TreeMap(); m.one = 1; m.two = 2; m.collect(new HashSet(), (key,value) -> key + value)")
        digestAllowlist.add(AllowlistLoader.loadFromResourceFiles(Allowlist.class, "org.opensearch.ingest.txt"));
        assertEquals(2, exec("List l = new ArrayList(); l.add(1); l.add(2); return l.find(x -> x == 2)"));
        );
    public void testSha256() {
                    + "return m.findResult('notfound', (key,value) -> value == 10 ? 'found' : null)"
/*  
import java.util.List;  
import org.opensearch.script.ScriptContext;
        );
    public void testMap_Each() {  
        public interface Factory {
        assertEquals(
}  
/*
    public void testCollection_Collect() {
        assertEquals(5, exec("Set l = new HashSet(); l.add(5); return l.asList()[0]"));  
    }
    }
        assertEquals(
    @AfterClass
    public void testIterable_GroupBy() {
import java.util.ArrayList;
        assertEquals("fcde2b2edba56bf408601fb721fe9b5c338d10ee429ea04fae5511b68fbf8fb9", execDigest("'bar'.sha256()"));  
 * this work for additional information regarding copyright
    }  
        final int count;  
/*  
        assertEquals(0, exec("List l = new ArrayList(); l.add(2); Map m = new HashMap(); l.eachWithIndex(m::put); return m.get(2)"));
    }  
            exec("List l = new ArrayList(); l.add(1); l.add(2); return l.findResult('notfound', x -> x > 10 ? 'found' : null)")
            "notfound",  
 * The OpenSearch Contributors require contributions made to  
        );  
            exec("int foo(Supplier t) { return t.get() }" + "def l = new ArrayList(); l.add(1);" + "return foo(l::getLength);")
        assertEquals(1, exec("ArrayList l = new ArrayList(); l.add(1); return l.length;"));
                split.input.split(Pattern.quote(split.token), split.count),  
        assertEquals(
        public static final ScriptContext<DigestTestScript.Factory> CONTEXT = new ScriptContext<>("test", DigestTestScript.Factory.class);
            Arrays.asList("negative", "positive"),
    public void testIterable_Each() {  
        assertEquals("two", exec("Map m = new TreeMap(); m.one = 1; m.two = 2; return m.find((key,value) -> value == 2).key"));  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
    public void testCapturingReference() {
    }
 */  
    public void testMap_FindResults() {  
        assertEquals(1, exec("ArrayList l = new ArrayList(); l.add(1); return l.getLength();"));  
 */  
        assertEquals(  
        );  
    public void testIterable_Every() {
        );
                    + " ft.setX(3); ft.setY(2); return ft.getTotal()"
        Map<String, Map<String, Integer>> expected = new HashMap<>();
        SCRIPT_ENGINE = null;  
    public static void afterClass() {
import org.opensearch.common.settings.Settings;
    public void testMap_FindAll() {  
        assertEquals(1, exec("Map m = new TreeMap(); m.one = 1; m.two = 2; m.count((key,value) -> value == 2)"));  
        );  
            exec("List l = new ArrayList(); l.add(1); l.add(2); return l.split(x -> x == 2)")
        assertEquals(false, exec("List l = new ArrayList(); l.add(1); l.add(2); l.every(x -> x == 1)"));  
 */
    }
        assertEquals(
 * not use this file except in compliance with the License.
        );  
    public void testMap_Find() {
    public void testIterable_EachWithIndex() {
    public abstract static class DigestTestScript {
        );  
            new SplitCase("a,,b,,c", ",", 1),
        Map<ScriptContext<?>, List<Allowlist>> contexts = newDefaultContexts();  
    public void testCollection_FindAll() {
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
    public void testIterable_AsList() {
        assertEquals(Arrays.asList(2, 3), exec("List l = new ArrayList(); l.add(1); l.add(2); l.collect(x -> x + 1)"));  
    public void testIterable_FindResults() {  
 * compatible open source license.
    public void testMap_Collect() {  
            DigestTestScript newInstance();
        for (SplitCase split : cases) {
        assertEquals(false, exec("Map m = new TreeMap(); m.one = 1; m.two = 2; m.every((key,value) -> value == 2)"));
        );
    }
    }
                "Map m = new TreeMap(); m.one = 1; m.two = 2; "  
    }
            this.input = input;  
    public void testString_SplitOnToken() {
    public void testIterable_Any() {
        assertEquals("test,ing", exec("List l = new ArrayList(); l.add('test'); l.add('ing'); l.join(',')"));  
        assertEquals(2, exec("Map m = new TreeMap(); m.one = 1; m.two = 2; Map m2 = new TreeMap(); m.each(m2::put); return m2.size()"));
 * Unless required by applicable law or agreed to in writing,
            Arrays.asList(Arrays.asList(2), Arrays.asList(1)),
            Collections.singletonMap("two", 2),
        assertEquals(1, exec("def l = new ArrayList(); l.add(1); return l.getLength();"));
import java.util.Collections;
        assertEquals("2c26b46b68ffc68ff99b453c1d30413413422d706483bfa0f98a5e886266e7ae", execDigest("'foo'.sha256()"));
            exec("Map m = new TreeMap(); m.a = -1; m.b = 1; " + "return m.groupBy((key,value) -> value < 0 ? 'negative' : 'positive')")
        assertEquals(
            8,
                    + " ft.setX(3); ft.setY(2); return ft.addToTotal(3)"  
    }
            5,
            this.count = count;
        assertEquals(true, exec("List l = new ArrayList(); return l.asList() === l"));
 *
 *  
        expected.put("negative", Collections.singletonMap("a", -1));  
        return SCRIPT_ENGINE;
            new SplitCase("a,b,c", "a,b,c,d"),
    public String execDigest(String script) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public static final String[] PARAMETERS = {};  
            assertArrayEquals(
        );
        assertEquals(true, exec("List l = new ArrayList(); return l.asCollection() === l"));
        assertEquals(asSet(2, 3), exec("List l = new ArrayList(); l.add(1); l.add(2); l.collect(new HashSet(), x -> x + 1)"));
            exec("int foo(Supplier t) { return t.get() }" + "ArrayList l = new ArrayList(); l.add(1);" + "return foo(l::getLength);")
        assertEquals(5.0D, exec("List l = new ArrayList(); l.add(1); l.add(2); l.sum(x -> x + 1)"));
            new SplitCase("1\n1.1.\r\n1\r\n111", "\r\n"), };  
    }
        }  
        assertEquals("62cdb7020ff920e5aa642c3d4066950dd1f01f4d", execDigest("'bar'.sha1()"));  
            new SplitCase("aaaaaaa", "a", 2),  
            new SplitCase("a,b,c", ","),
import java.util.Arrays;  
            exec("def ft = new org.opensearch.painless.FeatureTestObject();" + " ft.setX(3); ft.setY(2); return ft.getTotal()")  
    }
            new SplitCase("1.1.1.1.111", "."),
    }
        assertEquals(
