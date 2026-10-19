        assertThat(factory.newInstance(vars).execute(), equalTo("foo bar"));
}
    public void testSizeAccessForCollectionsAndArrays() throws Exception {
        String template = "{{data.0}} {{data.1}}";
    }
        TemplateScript.Factory factory = engine.compile(null, template, TemplateScript.CONTEXT, Collections.emptyMap());
            .endArray()
    }
            "{{#toJson}}ctx{{/toJson}}",
import static java.util.Collections.singletonMap;
        assertScript("{{#toJson}}ctx{{/toJson}}", ctx, equalTo("[\"one\",\"two\",\"three\"]"));
    public void testSimpleArrayToJSON() throws Exception {
            .value("john@smith.com")
            .startObject()
            "ctx",
        String[] randomArrayValues = generateRandomStringArray(10, 20, false);
 * The OpenSearch Contributors require contributions made to
            + "{\"boosting\": {"
        assertScript("{{#toJson}}.{{/toJson}}", ctx, equalTo("{\"ctx\":{\"name\":\"John Smith\",\"age\":42,\"height\":1.84}}"));
        humans.put("first", human0);
        );
    }
        Map<String, Object> ctx = singletonMap("array", array);
            equalTo("?query=john%40smith.com%2Cjohn.smith%40email.com%2Cjsmith%40email.com")
        assertScript(
        human0.put("name", "John Smith");
        Map<String, Object> humans = new HashMap<>();
            .value("john@doe.com")
        XContentBuilder builder = jsonBuilder().startObject()
        assertScript(template, singletonMap("ctx", true), equalTo("true"));
            "?query={{#url}}{{#join}}emails{{/join}}{{/url}}",
        setData.add("bar");
            "%3Fquery%3D%28foo%3AA+OR+baz%3AB%29+AND+title%3A%2Fjoh%3Fn%28ath%5Boa%5Dn%29%2F+AND+date%3A%7B*+TO+2012-01%7D"
        template = "{{#toJson}}.{{/toJson}}";
        assertScript(template, singletonMap("ctx", "value"), equalTo("{\"ctx\":\"value\"}"));
        Map<String, Object> params = singletonMap("terms", Arrays.asList(singletonMap("term", "foo"), singletonMap("term", "bar")));
        XContentBuilder builder = jsonBuilder().startObject()
        Object data = randomFrom(new String[] { "foo", "bar" }, Arrays.asList("foo", "bar"));
import static org.hamcrest.Matchers.both;
        );
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
            .endObject()
 * license agreements. See the NOTICE file distributed with
        assertScript("{{#toJson}}array.1{{/toJson}}", ctx, equalTo("two"));
        urls.put("https://www.elastic.co", "https%3A%2F%2Fwww.elastic.co");
            equalTo("prefix_" + URLEncoder.encode(random, StandardCharsets.UTF_8.name()))
        String[] array = new String[] { "one", "two", "three" };
        Map<String, Object> human0 = new HashMap<>();
        assertScript(
        params = singletonMap("fibonacci", new int[] { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 });
        urls.put(
        String template = "{{#join}}array{{/join}}";
            equalTo("1%2B1%2B2%2B3%2B5%2B8%2B13%2B21%2B34%2B55")
        assertScript("{{#toJson}}ctx.size{{/toJson}}", ctx, equalTo("3"));
            .field("type", "type-2")
            .field("type", "type-1")
        assertScript(template, singletonMap("ctx", 42), equalTo("{\"ctx\":42}"));
        assertThat(e.getMessage(), containsString("Mustache function [toJson] must contain one and only one identifier"));
        for (Map.Entry<String, String> url : urls.entrySet()) {
        assertScript("{{#join}}{{#toJson}}terms{{/toJson}}{{/join}}", params, equalTo("[{\"term\":\"foo\"},{\"term\":\"bar\"}]"));
import java.util.Locale;
            .startObject()
                "{\"ctx\":{\"first\":{\"name\":\"John Smith\",\"age\":42,\"height\":1.84},\"second\":"
        String result = compile(script).newInstance(vars).execute();
            params,
/*
        assertScript("{{#toJson}}ctx.1{{/toJson}}", ctx, equalTo("two"));
        assertScript(template, singletonMap("ctx", null), equalTo("{\"ctx\":null}"));
import static org.hamcrest.Matchers.emptyOrNullString;
        setData.add(singletonMap("key", "foo"));
 * under the License.
        Map<String, Object> params = singletonMap("boost_val", "0.2");
        assertScript("{{#toJson}}array.0{{/toJson}}", ctx, equalTo("one"));
        assertScript("{{#toJson}}ctx.name{{/toJson}}", ctx, equalTo("John Smith"));
import org.opensearch.script.ScriptEngine;
            .endArray()
        assertScript(
    }
        vars.put("data", setData);
        params = singletonMap("indices", new String[] { "<logstash-{now/d-2d}>", "<logstash-{now/d-1d}>", "<logstash-{now/d}>" });
        human0.put("height", 1.84);
import org.opensearch.core.common.bytes.BytesReference;
            + "}}, \"negative_boost\": {{boost_val}} } }}";
        assertScript(
        Map<String, String> urls = new HashMap<>();
        assertScript("{{#join delimiter=','}}params{{/join delimiter=','}}", params, equalTo("1,2,3,4"));
            ctx,
import java.net.URLEncoder;
        Map<String, Object> human1 = new HashMap<>();
        assertThat(output, both(containsString("foo")).and(containsString("bar")));
            ctx,
        );
        final String random = randomAlphaOfLength(10);
            result.execute()
        assertScript("{{#toJson}}.{{/toJson}}", ctx, equalTo("{\"ctx\":[\"one\",\"two\",\"three\"]}"));
            equalTo(
        assertScript("{{#join delimiter=' and '}}params{{/join delimiter=' and '}}", params, equalTo("1 and 2 and 3 and 4"));
    public void testUrlEncoderWithParam() throws Exception {
 * ownership. Elasticsearch licenses this file to you under
        // HashSet iteration order isn't fixed
        assertScript("{{#join delimiter=''}}params{{/join delimiter=''}}", params, equalTo("1234"));
            assertScript("{{#url}}{{params}}{{/url}}", singletonMap("params", url.getKey()), equalTo(url.getValue()));
        assertScript(
    public void testSimpleListToJSON() throws Exception {
            "{{#url}}{{index}}{{/url}}",
        Map<String, Object> ctx = singletonMap("ctx", humans);
        vars.put("data", data);
 *
            "{{#ctx.people}}to: {{#join}}emails{{/join}};{{/ctx.people}}",
                + "\"negative\": {\"term\": {\"body\": {\"value\": \"solr\"}}}, \"negative_boost\": 0.2 } }}",
        String expectedString = String.format(Locale.ROOT, "%s %s", randomArrayValues.length, randomList.size());
        );
        Map<String, Object> vars = new HashMap<>();
        assertScript(template, singletonMap("ctx", "value"), equalTo("value"));
package org.opensearch.script.mustache;
        assertScript("{{#toJson}}array{{/toJson}}", ctx, equalTo("[\"one\",\"two\",\"three\"]"));
        Map<String, Object> params = singletonMap("params", Arrays.asList(1, 2, 3, 4));
        Map<String, Object> vars = new HashMap<>();
        e = expectThrows(ScriptException.class, () -> compile(script2));
        human0.put("age", 42);
        List<String> list = Arrays.asList("one", "two", "three");
                    + "{\"name\":\"Dave Smith\",\"age\":27,\"height\":1.71}}}"
        Map<String, Object> vars = new HashMap<>();
            .field("name", "John Doe")
        assertThat(factory.newInstance(vars).execute(), equalTo("foo bar"));
        return engine.compile(null, script, TemplateScript.CONTEXT, Collections.emptyMap());
    }
            .value("john.smith@email.com")
import java.util.Collections;
    public void testArrayInArrayAccess() throws Exception {
            "Mustache templating broken",
import static java.util.Collections.singleton;
    }
 */
            Collections.singletonList(new String[] { "foo", "bar" }),
 *
import static org.hamcrest.Matchers.not;
        assertScript(
        assertScript(template, singletonMap("ctx", 42L), equalTo("42"));
        assertEquals(script, e.getScript());
 * Unless required by applicable law or agreed to in writing,
            .endObject()
        TemplateScript.Factory factory = engine.compile(null, template, TemplateScript.CONTEXT, Collections.emptyMap());
            .value("john.doe@email.com")
            .endObject();
            .startObject()
            .startObject()
            .endObject()
import org.opensearch.script.ScriptException;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testEmbeddedToJSON() throws Exception {
        Object data = randomFrom(
        assertScript(template, singletonMap("ctx", 42), equalTo("42"));
        final String script = "{{#toJson}}{{foo}}{{bar}}{{/toJson}}";
    }
        Set<Object> setData = new HashSet<>();
        final String script2 = "{{#toJson}}{{/toJson}}";
import java.nio.charset.StandardCharsets;
            .field("index", "index-2")
            .value("jdoe@email.com")
        );
        List<String> randomList = Arrays.asList(generateRandomStringArray(10, 20, false));
import org.opensearch.script.TemplateScript;
        assertEquals(script, e.getScript());
            + "\"negative\": {\"term\": {\"body\": {\"value\": \"solr\"}"
        assertScript(
        assertScript(template, singletonMap("array", new boolean[] { true, false, true }), equalTo("true,false,true"));
        String template = "{{data.0.0}} {{data.0.1}}";
        String output = factory.newInstance(vars).execute();
import org.hamcrest.Matcher;
    }
        assertScript(template, singletonMap("ctx", 42.5f), equalTo("{\"ctx\":42.5}"));
            singleton(new String[] { "foo", "bar" })
import static org.hamcrest.Matchers.equalTo;
        assertScript("{{#toJson}}.{{/toJson}}", ctx, equalTo("{\"array\":[\"one\",\"two\",\"three\"]}"));
    }
            "{{#url}}https://localhost:9200/{{#join}}indices{{/join}}/_stats{{/url}}",
            XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2()
        assertScript("{{#toJson}}ctx.2{{/toJson}}", ctx, equalTo("three"));
        assertThat(output, both(containsString("foo")).and(containsString("bar")));
        Map<String, Object> ctx = singletonMap(
import java.util.HashSet;
    public void testBasics() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertScript("{{#toJson}}ctx.second{{/toJson}}", ctx, equalTo("{\"name\":\"Dave Smith\",\"age\":27,\"height\":1.71}"));
            Arrays.asList(singletonMap("key", "foo"), singletonMap("key", "bar"))
                "https%3A%2F%2Flocalhost%3A9200%2F%3Clogstash-%7Bnow%2Fd-2d%7D"
        assertThat("cannot compile null or empty script", script, not(emptyOrNullString()));
        );
            ctx,
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            "{{#url}}prefix_{{s}}{{/url}}",
        Object data = randomFrom(
        Map<String, Object> params = singletonMap("emails", Arrays.asList("john@smith.com", "john.smith@email.com", "jsmith@email.com"));
    public void testArrayAccess() throws Exception {
            .endObject();
import java.util.Map;
        Map<String, Object> ctx = singletonMap("ctx", human0);
/*
        vars.put("data", data);
            )
        assertEquals(MustacheScriptEngine.NAME, e.getLang());
        TemplateScript.Factory factory = engine.compile(null, template, TemplateScript.CONTEXT, Collections.emptyMap());
import org.opensearch.common.xcontent.XContentHelper;
    public void testSimpleArrayJoin() throws Exception {
        human1.put("age", 27);
        Map<String, Object> ctx = singletonMap(
    public void testJoinWithCustomDelimiter() {
            .field("name", "John Smith")
            singletonMap("index", "<logstash-{now/d{YYYY.MM.dd|+12:00}}>"),
        Set<String> setData = new HashSet<>();
        human0.put("name", "John Smith");
/*
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> ctx = singletonMap("ctx", list);
            equalTo(
 * specific language governing permissions and limitations
import org.opensearch.test.OpenSearchTestCase;
        assertScript(template, singletonMap("ctx", null), equalTo(""));
            .startArray("people")
        assertEquals(MustacheScriptEngine.NAME, e.getLang());
        assertThat(e.getMessage(), containsString("Mismatched start/end tags"));
        );
            params,
    public void testSimpleMapToJSON() throws Exception {
    public void testPrimitiveToJSON() throws Exception {
        vars.put("data", setData);
        humans.put("second", human1);
    }
            .field("id", 2)
        final String script = "{{#join}}{{/join}}";
 * Licensed to Elasticsearch under one or more contributor
    public void testUrlEncoderWithJoin() {
        assertEquals(script2, e.getScript());
        assertThat(factory.newInstance(vars).execute(), equalTo("foo bar"));
            )
            .endObject()
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
        vars.put("data", data);
        // Sets can come out in any order
            .field("index", "index-1")
            .startArray("emails")
        assertScript(template, singletonMap("ctx", 42.5f), equalTo("42.5"));
 * You may obtain a copy of the License at
import java.util.HashMap;
    public void testEmbeddedArrayJoin() throws Exception {
            .endArray()
        assertScript(template, singletonMap("array", new double[] { 1.5, 2.5, 3.5 }), equalTo("1.5,2.5,3.5"));
        human0.put("height", 1.84);
    }
        assertScript(template, singletonMap("ctx", true), equalTo("{\"ctx\":true}"));
        assertScript(template, singletonMap("array", new int[] { 1, 2, 3 }), equalTo("1,2,3"));
            "GET _search {\"query\": {\"boosting\": {\"positive\": {\"match\": {\"body\": \"gift\"}},"
            XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2()
            equalTo("{\"index\":\"index-1\",\"id\":1,\"type\":\"type-1\"}{\"index\":\"index-2\",\"id\":2,\"type\":\"type-2\"}")
        String template = "{{data.array.size}} {{data.list.size}}";
    private TemplateScript.Factory compile(String script) {
 */
                    + "%3E%2C%3Clogstash-%7Bnow%2Fd-1d%7D%3E%2C%3Clogstash-%7Bnow%2Fd%7D%3E%2F_stats"
    public void testMapInArrayAccess() throws Exception {
 */
            "ctx",
        assertEquals(MustacheScriptEngine.NAME, e.getLang());
                "{\"first\":{\"name\":\"John Smith\",\"age\":42,\"height\":1.84},\"second\":"
            "{{#url}}{{#join delimiter='+'}}fibonacci{{/join delimiter='+'}}{{/url}}",
            "{{#ctx.bulks}}{{#toJson}}.{{/toJson}}{{/ctx.bulks}}",
        );
        );
        assertScript(template, singletonMap("array", new boolean[] { true, false, true }), equalTo("true,false,true"));
    }
 * this work for additional information regarding copyright
        );
        Map<String, Object> vars = new HashMap<>();
 *
        urls.put("<logstash-{now/d}>", "%3Clogstash-%7Bnow%2Fd%7D%3E");
        assertScript(template, singletonMap("ctx", ""), equalTo("{\"ctx\":\"\"}"));
        human1.put("name", "Dave Smith");
        TemplateScript result = factory.newInstance(params);
    public void testMultipleMapsToJSON() throws Exception {
        assertScript("{{#toJson}}array.size{{/toJson}}", ctx, equalTo("3"));
        assertScript(template, singletonMap("array", new long[] { 1L, 2L, 3L }), equalTo("1,2,3"));
            singletonMap("s", random),
    }
                    + "{\"name\":\"Dave Smith\",\"age\":27,\"height\":1.71}}"
        TemplateScript.Factory factory = engine.compile(null, template, TemplateScript.CONTEXT, Collections.emptyMap());
            new String[][] { new String[] { "foo", "bar" } },
        assertThat(e.getMessage(), containsString("Mustache function [toJson] must contain one and only one identifier"));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        String output = factory.newInstance(vars).execute();
public class MustacheTests extends OpenSearchTestCase {
            equalTo("%3Clogstash-%7Bnow%2Fd%7BYYYY.MM.dd%7C%2B12%3A00%7D%7D%3E")
            .field("id", 1)
        ScriptException e = expectThrows(ScriptException.class, () -> compile(script));
    public void testJoinWithToJson() {
        assertScript("{{#toJson}}array.2{{/toJson}}", ctx, equalTo("three"));
        setData.add(singletonMap("key", "bar"));
        );
            equalTo("to: john@smith.com,john.smith@email.com,jsmith@email.com;to: john@doe.com,john.doe@email.com,jdoe@email.com;")
        e = expectThrows(ScriptException.class, () -> compile(script2));
        String template = "{{#toJson}}ctx{{/toJson}}";
        assertScript(
        assertThat(e.getMessage(), containsString("Mustache function [join] must contain one and only one identifier"));
            "?query=(foo:A OR baz:B) AND title:/joh?n(ath[oa]n)/ AND date:{* TO 2012-01}",
import static org.hamcrest.Matchers.containsString;
        assertScript("{{#toJson}}ctx{{/toJson}}", ctx, equalTo("{\"name\":\"John Smith\",\"age\":42,\"height\":1.84}"));
    }
        assertThat(factory.newInstance(vars).execute(), equalTo(expectedString));
    }
            )
        assertEquals(
        assertEquals(script2, e.getScript());
        assertScript("{{#join delimiter='/'}}params{{/join delimiter='/'}}", params, equalTo("1/2/3/4"));
        assertEquals(MustacheScriptEngine.NAME, e.getLang());
            new Object[] { singletonMap("key", "foo"), singletonMap("key", "bar") },
        String template = "{{data.0.key}} {{data.1.key}}";
        assertScript(template, singletonMap("array", new String[] { "one", "two", "three" }), equalTo("one,two,three"));
 * KIND, either express or implied.  See the License for the
        final String script2 = "{{#join delimiter='a'}}{{/join delimiter='b'}}";
        human0.put("age", 42);
    }
        human1.put("height", 1.71);
        }
            .value("jsmith@email.com")
            .startArray("emails")
        data.put("list", randomList);
        );
        TemplateScript.Factory factory = engine.compile(null, template, TemplateScript.CONTEXT, Collections.emptyMap());
import java.util.List;
 * GitHub history for details.
        );
        assertScript(
    private void assertScript(String script, Map<String, Object> vars, Matcher<String> matcher) {
        assertScript("{{#toJson}}ctx.0{{/toJson}}", ctx, equalTo("one"));
        data.put("array", randomArrayValues);
 * this file be licensed under the Apache-2.0 license or a
            ctx,
        );
        assertScript("{{#join}}ctx.people.1.emails{{/join}}", ctx, equalTo("john@doe.com,john.doe@email.com,jdoe@email.com"));
        assertScript("{{#ctx.bulks}}<{{#toJson}}id{{/toJson}}>{{/ctx.bulks}}", ctx, equalTo("<1><2>"));
            "{{#toJson}}.{{/toJson}}",
 * software distributed under the License is distributed on an
        ScriptException e = expectThrows(ScriptException.class, () -> compile(script));
            equalTo(
        assertScript(template, singletonMap("ctx", 42L), equalTo("{\"ctx\":42}"));
        );
    private ScriptEngine engine = new MustacheScriptEngine();
        assertThat(result, matcher);
    }
        assertScript("{{#join}}ctx.people.0.emails{{/join}}", ctx, equalTo("john@smith.com,john.smith@email.com,jsmith@email.com"));
        vars.put("data", data);
        setData.add("foo");
        Map<String, Object> human0 = new HashMap<>();
    }
    public void testUrlEncoder() {
    public void testsUnsupportedTagsToJson() {
            .endArray()
            .startArray("bulks")
    public void testsUnsupportedTagsJoin() {
            params,
        assertScript("{{#toJson}}ctx.first{{/toJson}}", ctx, equalTo("{\"name\":\"John Smith\",\"age\":42,\"height\":1.84}"));
            + "\"positive\": {\"match\": {\"body\": \"gift\"}},"
    }
        String template = "GET _search {\"query\": "
 * not use this file except in compliance with the License.
        assertScript(template, singletonMap("ctx", ""), equalTo(""));
