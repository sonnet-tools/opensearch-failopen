 */
    private TemplateScript.Factory compile(String script) {
    }  
        Map<String, Object> human1 = new HashMap<>();
            equalTo("1%2B1%2B2%2B3%2B5%2B8%2B13%2B21%2B34%2B55")
        assertScript(
            "Mustache templating broken",
        );
            + "{\"boosting\": {"
        Map<String, Object> ctx = singletonMap(
            .value("john.smith@email.com")
        assertScript("{{#join delimiter=','}}params{{/join delimiter=','}}", params, equalTo("1,2,3,4"));
            + "}}, \"negative_boost\": {{boost_val}} } }}";
        vars.put("data", setData);  
    public void testSimpleMapToJSON() throws Exception {
        assertScript("{{#toJson}}array.size{{/toJson}}", ctx, equalTo("3"));  
        Map<String, String> urls = new HashMap<>();
                "{\"first\":{\"name\":\"John Smith\",\"age\":42,\"height\":1.84},\"second\":"
        String template = "{{data.0}} {{data.1}}";
        human0.put("age", 42);
        params = singletonMap("indices", new String[] { "<logstash-{now/d-2d}>", "<logstash-{now/d-1d}>", "<logstash-{now/d}>" });
import org.hamcrest.Matcher;
            .endObject()  
        assertScript(template, singletonMap("ctx", null), equalTo(""));
        assertThat(e.getMessage(), containsString("Mustache function [join] must contain one and only one identifier"));
 * the Apache License, Version 2.0 (the "License"); you may
            )
            "ctx",
        List<String> randomList = Arrays.asList(generateRandomStringArray(10, 20, false));
    public void testsUnsupportedTagsToJson() {  
    }
        Map<String, Object> ctx = singletonMap("ctx", human0);
        assertScript(template, singletonMap("ctx", true), equalTo("true"));  
            .endObject()  
    }
        String template = "{{data.array.size}} {{data.list.size}}";  
        final String script = "{{#toJson}}{{foo}}{{bar}}{{/toJson}}";
            equalTo(  
 * You may obtain a copy of the License at  
        assertScript(template, singletonMap("ctx", "value"), equalTo("value"));
            equalTo(
        assertThat(factory.newInstance(vars).execute(), equalTo("foo bar"));  
            "{{#url}}https://localhost:9200/{{#join}}indices{{/join}}/_stats{{/url}}",
    }
import static java.util.Collections.singletonMap;  
        assertScript("{{#join delimiter=' and '}}params{{/join delimiter=' and '}}", params, equalTo("1 and 2 and 3 and 4"));
            .endObject();
        String template = "{{#join}}array{{/join}}";  
import java.util.HashSet;
import static org.hamcrest.Matchers.emptyOrNullString;
 * software distributed under the License is distributed on an
        assertScript(template, singletonMap("ctx", 42L), equalTo("{\"ctx\":42}"));
        );
        Map<String, Object> ctx = singletonMap(  
            .field("name", "John Doe")  
            ctx,
 *
 * ownership. Elasticsearch licenses this file to you under  
        data.put("array", randomArrayValues);  
        assertEquals(script2, e.getScript());
            "ctx",
package org.opensearch.script.mustache;
        assertScript("{{#toJson}}ctx.2{{/toJson}}", ctx, equalTo("three"));
    public void testUrlEncoder() {
            params,
            new String[][] { new String[] { "foo", "bar" } },
        Map<String, Object> params = singletonMap("params", Arrays.asList(1, 2, 3, 4));
        Map<String, Object> vars = new HashMap<>();
import java.util.Set;  
        String output = factory.newInstance(vars).execute();
        assertEquals(MustacheScriptEngine.NAME, e.getLang());
        assertScript(template, singletonMap("array", new int[] { 1, 2, 3 }), equalTo("1,2,3"));
    }
 * this file be licensed under the Apache-2.0 license or a
    public void testSimpleArrayToJSON() throws Exception {  
        Map<String, Object> vars = new HashMap<>();
        humans.put("first", human0);
        Map<String, Object> human0 = new HashMap<>();  
        assertScript(
        Map<String, Object> params = singletonMap("emails", Arrays.asList("john@smith.com", "john.smith@email.com", "jsmith@email.com"));
        assertScript("{{#toJson}}array{{/toJson}}", ctx, equalTo("[\"one\",\"two\",\"three\"]"));
            .startArray("emails")
            .field("type", "type-2")  
    }  
        assertScript("{{#toJson}}ctx.0{{/toJson}}", ctx, equalTo("one"));  
        TemplateScript.Factory factory = engine.compile(null, template, TemplateScript.CONTEXT, Collections.emptyMap());
        assertScript("{{#join}}ctx.people.0.emails{{/join}}", ctx, equalTo("john@smith.com,john.smith@email.com,jsmith@email.com"));  
            .endObject()
    }
/*  
        );
        Map<String, Object> humans = new HashMap<>();
            result.execute()
        assertThat(e.getMessage(), containsString("Mustache function [toJson] must contain one and only one identifier"));  
        vars.put("data", data);  
        setData.add(singletonMap("key", "foo"));
 * compatible open source license.
        assertEquals(script, e.getScript());
        vars.put("data", data);
import java.util.Locale;
        Map<String, Object> human0 = new HashMap<>();
            .startArray("emails")
    public void testUrlEncoderWithParam() throws Exception {  
        assertScript(template, singletonMap("ctx", 42L), equalTo("42"));
    public void testBasics() {  
        );  
            .startArray("people")
        human0.put("height", 1.84);  
        TemplateScript.Factory factory = engine.compile(null, template, TemplateScript.CONTEXT, Collections.emptyMap());
        assertScript("{{#ctx.bulks}}<{{#toJson}}id{{/toJson}}>{{/ctx.bulks}}", ctx, equalTo("<1><2>"));
        assertEquals(script, e.getScript());
        String[] array = new String[] { "one", "two", "three" };
        assertScript("{{#toJson}}array.1{{/toJson}}", ctx, equalTo("two"));
    public void testPrimitiveToJSON() throws Exception {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2()  
        Map<String, Object> ctx = singletonMap("array", array);
            singletonMap("s", random),
        assertScript(template, singletonMap("array", new boolean[] { true, false, true }), equalTo("true,false,true"));  
            "GET _search {\"query\": {\"boosting\": {\"positive\": {\"match\": {\"body\": \"gift\"}},"  
 * this work for additional information regarding copyright
        }  
            ctx,  
        assertScript(template, singletonMap("ctx", true), equalTo("{\"ctx\":true}"));  
        assertScript(
        assertScript("{{#join delimiter=''}}params{{/join delimiter=''}}", params, equalTo("1234"));
        assertScript("{{#toJson}}ctx{{/toJson}}", ctx, equalTo("[\"one\",\"two\",\"three\"]"));
        Map<String, Object> vars = new HashMap<>();  
    public void testSimpleArrayJoin() throws Exception {
        Object data = randomFrom(new String[] { "foo", "bar" }, Arrays.asList("foo", "bar"));
        final String script2 = "{{#toJson}}{{/toJson}}";
        setData.add("foo");
        assertScript(template, singletonMap("ctx", 42), equalTo("{\"ctx\":42}"));
        human1.put("name", "Dave Smith");
import org.opensearch.test.OpenSearchTestCase;  
        human1.put("height", 1.71);
        String template = "{{data.0.key}} {{data.1.key}}";
        assertEquals(MustacheScriptEngine.NAME, e.getLang());
    public void testsUnsupportedTagsJoin() {
            singletonMap("index", "<logstash-{now/d{YYYY.MM.dd|+12:00}}>"),  
        vars.put("data", data);
        XContentBuilder builder = jsonBuilder().startObject()
            ctx,  
        assertScript("{{#toJson}}array.0{{/toJson}}", ctx, equalTo("one"));  
            equalTo("?query=john%40smith.com%2Cjohn.smith%40email.com%2Cjsmith%40email.com")
            params,
        assertScript(template, singletonMap("ctx", null), equalTo("{\"ctx\":null}"));
            params,  
            .startObject()
import static org.hamcrest.Matchers.both;
            .startObject()
            .value("john@doe.com")
        Object data = randomFrom(
    }  
/*
    }
        assertThat(output, both(containsString("foo")).and(containsString("bar")));
 * GitHub history for details.
            equalTo("prefix_" + URLEncoder.encode(random, StandardCharsets.UTF_8.name()))
        Set<Object> setData = new HashSet<>();  
        Map<String, Object> vars = new HashMap<>();  
        assertScript(template, singletonMap("ctx", 42.5f), equalTo("{\"ctx\":42.5}"));  
            .value("john.doe@email.com")  
        );
        final String script2 = "{{#join delimiter='a'}}{{/join delimiter='b'}}";  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertScript(template, singletonMap("ctx", "value"), equalTo("{\"ctx\":\"value\"}"));
import java.net.URLEncoder;  
                "https%3A%2F%2Flocalhost%3A9200%2F%3Clogstash-%7Bnow%2Fd-2d%7D"
        assertThat(e.getMessage(), containsString("Mismatched start/end tags"));
    }
/*
        vars.put("data", setData);  
}
    public void testSizeAccessForCollectionsAndArrays() throws Exception {
        );
            Arrays.asList(singletonMap("key", "foo"), singletonMap("key", "bar"))  
            .endObject()
        String template = "GET _search {\"query\": "
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            "{{#ctx.people}}to: {{#join}}emails{{/join}};{{/ctx.people}}",
        String output = factory.newInstance(vars).execute();
    }  
            ctx,  
    public void testJoinWithCustomDelimiter() {
public class MustacheTests extends OpenSearchTestCase {
 * Modifications Copyright OpenSearch Contributors. See  
        assertScript("{{#toJson}}ctx.first{{/toJson}}", ctx, equalTo("{\"name\":\"John Smith\",\"age\":42,\"height\":1.84}"));
        assertScript(
                    + "%3E%2C%3Clogstash-%7Bnow%2Fd-1d%7D%3E%2C%3Clogstash-%7Bnow%2Fd%7D%3E%2F_stats"
import static org.hamcrest.Matchers.containsString;  
            equalTo("%3Clogstash-%7Bnow%2Fd%7BYYYY.MM.dd%7C%2B12%3A00%7D%7D%3E")
            "%3Fquery%3D%28foo%3AA+OR+baz%3AB%29+AND+title%3A%2Fjoh%3Fn%28ath%5Boa%5Dn%29%2F+AND+date%3A%7B*+TO+2012-01%7D"
    public void testSimpleListToJSON() throws Exception {  
            singleton(new String[] { "foo", "bar" })  
        data.put("list", randomList);
            XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2()
import java.util.List;  
                    + "{\"name\":\"Dave Smith\",\"age\":27,\"height\":1.71}}"  
        String expectedString = String.format(Locale.ROOT, "%s %s", randomArrayValues.length, randomList.size());
    public void testEmbeddedArrayJoin() throws Exception {  
        assertScript(template, singletonMap("array", new double[] { 1.5, 2.5, 3.5 }), equalTo("1.5,2.5,3.5"));
            "{{#ctx.bulks}}{{#toJson}}.{{/toJson}}{{/ctx.bulks}}",  
        assertEquals(script2, e.getScript());
            .field("index", "index-2")
 * specific language governing permissions and limitations
        );  
        assertScript(
    }  
    }
            .value("jsmith@email.com")
        assertEquals(
import org.opensearch.script.ScriptEngine;  
        );
        vars.put("data", data);
        assertThat(factory.newInstance(vars).execute(), equalTo("foo bar"));  
        assertThat(result, matcher);
        human1.put("age", 27);  
    }  
        String result = compile(script).newInstance(vars).execute();  
            "?query={{#url}}{{#join}}emails{{/join}}{{/url}}",  
        assertScript(template, singletonMap("ctx", 42.5f), equalTo("42.5"));  
        assertScript("{{#toJson}}ctx.name{{/toJson}}", ctx, equalTo("John Smith"));
        final String script = "{{#join}}{{/join}}";  
import java.util.Arrays;
            .value("john@smith.com")  
        e = expectThrows(ScriptException.class, () -> compile(script2));
import org.opensearch.core.common.bytes.BytesReference;
    }
        List<String> list = Arrays.asList("one", "two", "three");
    public void testArrayInArrayAccess() throws Exception {
            equalTo("{\"index\":\"index-1\",\"id\":1,\"type\":\"type-1\"}{\"index\":\"index-2\",\"id\":2,\"type\":\"type-2\"}")
        // HashSet iteration order isn't fixed
    public void testMultipleMapsToJSON() throws Exception {
        assertScript(template, singletonMap("array", new long[] { 1L, 2L, 3L }), equalTo("1,2,3"));  
        assertThat(factory.newInstance(vars).execute(), equalTo("foo bar"));  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(MustacheScriptEngine.NAME, e.getLang());  
                + "\"negative\": {\"term\": {\"body\": {\"value\": \"solr\"}}}, \"negative_boost\": 0.2 } }}",
import java.util.HashMap;
                    + "{\"name\":\"Dave Smith\",\"age\":27,\"height\":1.71}}}"  
 *
        );
    }  
        TemplateScript.Factory factory = engine.compile(null, template, TemplateScript.CONTEXT, Collections.emptyMap());
    public void testArrayAccess() throws Exception {  
            .field("type", "type-1")
    public void testMapInArrayAccess() throws Exception {  
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;  
            equalTo(
        );
            .startArray("bulks")
        Map<String, Object> data = new HashMap<>();
            + "\"negative\": {\"term\": {\"body\": {\"value\": \"solr\"}"
        XContentBuilder builder = jsonBuilder().startObject()  
import java.util.Map;
        TemplateScript result = factory.newInstance(params);  
import static org.hamcrest.Matchers.not;  
    }
 * SPDX-License-Identifier: Apache-2.0
        final String random = randomAlphaOfLength(10);
            assertScript("{{#url}}{{params}}{{/url}}", singletonMap("params", url.getKey()), equalTo(url.getValue()));
        assertEquals(MustacheScriptEngine.NAME, e.getLang());  
        urls.put("<logstash-{now/d}>", "%3Clogstash-%7Bnow%2Fd%7D%3E");
    }  
            )  
        human0.put("age", 42);  
        urls.put("https://www.elastic.co", "https%3A%2F%2Fwww.elastic.co");  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        assertScript(
        );  
        assertScript(template, singletonMap("array", new boolean[] { true, false, true }), equalTo("true,false,true"));
            .endArray()  
        template = "{{#toJson}}.{{/toJson}}";  
    private ScriptEngine engine = new MustacheScriptEngine();
            .field("index", "index-1")  
 * The OpenSearch Contributors require contributions made to  
        assertScript("{{#toJson}}.{{/toJson}}", ctx, equalTo("{\"array\":[\"one\",\"two\",\"three\"]}"));
            .value("jdoe@email.com")
    public void testJoinWithToJson() {
            "{{#toJson}}.{{/toJson}}",
            new Object[] { singletonMap("key", "foo"), singletonMap("key", "bar") },
                "{\"ctx\":{\"first\":{\"name\":\"John Smith\",\"age\":42,\"height\":1.84},\"second\":"
        params = singletonMap("fibonacci", new int[] { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 });  
        assertScript(
        TemplateScript.Factory factory = engine.compile(null, template, TemplateScript.CONTEXT, Collections.emptyMap());
            "{{#url}}{{#join delimiter='+'}}fibonacci{{/join delimiter='+'}}{{/url}}",
            )
    public void testEmbeddedToJSON() throws Exception {
        assertThat(factory.newInstance(vars).execute(), equalTo(expectedString));
        assertScript(template, singletonMap("ctx", 42), equalTo("42"));
        assertThat(output, both(containsString("foo")).and(containsString("bar")));
import java.nio.charset.StandardCharsets;
        assertScript("{{#join}}ctx.people.1.emails{{/join}}", ctx, equalTo("john@doe.com,john.doe@email.com,jdoe@email.com"));
        ScriptException e = expectThrows(ScriptException.class, () -> compile(script));
import org.opensearch.script.TemplateScript;
        return engine.compile(null, script, TemplateScript.CONTEXT, Collections.emptyMap());  
        Map<String, Object> ctx = singletonMap("ctx", humans);
        e = expectThrows(ScriptException.class, () -> compile(script2));
            .field("name", "John Smith")
        Map<String, Object> ctx = singletonMap("ctx", list);
 * KIND, either express or implied.  See the License for the
        assertScript(template, singletonMap("ctx", ""), equalTo("{\"ctx\":\"\"}"));
        assertScript("{{#toJson}}array.2{{/toJson}}", ctx, equalTo("three"));
        humans.put("second", human1);  
        assertScript("{{#join}}{{#toJson}}terms{{/toJson}}{{/join}}", params, equalTo("[{\"term\":\"foo\"},{\"term\":\"bar\"}]"));
        // Sets can come out in any order
        assertScript(template, singletonMap("array", new String[] { "one", "two", "three" }), equalTo("one,two,three"));
        for (Map.Entry<String, String> url : urls.entrySet()) {
        String[] randomArrayValues = generateRandomStringArray(10, 20, false);  
            .field("id", 2)
 *  
        String template = "{{#toJson}}ctx{{/toJson}}";  
        assertScript(template, singletonMap("ctx", ""), equalTo(""));
import static org.hamcrest.Matchers.equalTo;
            .endArray()  
        Object data = randomFrom(  
    }  
        urls.put(
 */
        assertScript(  
        human0.put("name", "John Smith");
    public void testUrlEncoderWithJoin() {  
            "?query=(foo:A OR baz:B) AND title:/joh?n(ath[oa]n)/ AND date:{* TO 2012-01}",  
import org.opensearch.common.xcontent.XContentHelper;  
 * under the License.  
            .startObject()  
        Map<String, Object> params = singletonMap("boost_val", "0.2");  
        ScriptException e = expectThrows(ScriptException.class, () -> compile(script));
import static java.util.Collections.singleton;
        assertThat(e.getMessage(), containsString("Mustache function [toJson] must contain one and only one identifier"));  
            .field("id", 1)
    }
            .endObject();
        assertScript("{{#toJson}}ctx{{/toJson}}", ctx, equalTo("{\"name\":\"John Smith\",\"age\":42,\"height\":1.84}"));
            Collections.singletonList(new String[] { "foo", "bar" }),
        assertScript("{{#toJson}}.{{/toJson}}", ctx, equalTo("{\"ctx\":{\"name\":\"John Smith\",\"age\":42,\"height\":1.84}}"));  
        String template = "{{data.0.0}} {{data.0.1}}";  
        setData.add(singletonMap("key", "bar"));
        Map<String, Object> params = singletonMap("terms", Arrays.asList(singletonMap("term", "foo"), singletonMap("term", "bar")));  
            "{{#toJson}}ctx{{/toJson}}",
        assertScript(
            .endArray()
            "{{#url}}prefix_{{s}}{{/url}}",  
import org.opensearch.core.xcontent.XContentBuilder;
        assertScript("{{#join delimiter='/'}}params{{/join delimiter='/'}}", params, equalTo("1/2/3/4"));  
        );  
            .startObject()
    }
        human0.put("height", 1.84);
            .endArray()
        assertScript("{{#toJson}}ctx.size{{/toJson}}", ctx, equalTo("3"));  
import org.opensearch.script.ScriptException;
    }
        );
        human0.put("name", "John Smith");
            + "\"positive\": {\"match\": {\"body\": \"gift\"}},"  
        assertScript("{{#toJson}}ctx.1{{/toJson}}", ctx, equalTo("two"));
            equalTo("to: john@smith.com,john.smith@email.com,jsmith@email.com;to: john@doe.com,john.doe@email.com,jdoe@email.com;")
        assertScript("{{#toJson}}ctx.second{{/toJson}}", ctx, equalTo("{\"name\":\"Dave Smith\",\"age\":27,\"height\":1.71}"));  
        );
        setData.add("bar");
    private void assertScript(String script, Map<String, Object> vars, Matcher<String> matcher) {
        TemplateScript.Factory factory = engine.compile(null, template, TemplateScript.CONTEXT, Collections.emptyMap());
        assertScript("{{#toJson}}.{{/toJson}}", ctx, equalTo("{\"ctx\":[\"one\",\"two\",\"three\"]}"));
            "{{#url}}{{index}}{{/url}}",
        Set<String> setData = new HashSet<>();  
 */  
        assertThat("cannot compile null or empty script", script, not(emptyOrNullString()));
