            factory.encode("\n", writer);
 * this file be licensed under the Apache-2.0 license or a
            "\\u0001",  
    public void setup() {
                writer.append(specialChars[charIndex]);
            '\u0004',  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
    }  
            "\\u000F",  
import org.opensearch.script.TemplateScript;
    public void testParseTemplateAsSingleStringWithConditionalClause() throws IOException {
            '\u0003',
 */  
        TemplateScript.Factory compiled = qe.compile(null, script.getIdOrCode(), TemplateScript.CONTEXT, Collections.emptyMap());  
        {
            String template = "GET _search {\"query\": "  
            '\u0000',
        String templateString = "{" + "\"source\":{\"match_{{template}}\": {}}," + "\"params\":{\"template\":\"all\"}" + "}";  
        TemplateScript TemplateScript = compiled.newInstance(script.getParams());
            assertThat(expect.toString(), equalTo(target.toString()));  
    /**
                return true;
            StringWriter writer = new StringWriter();  
                o  
                "GET _search {\"query\": {\"boosting\": {\"positive\": {\"match\": {\"body\": \"gift\"}},"  
 */
import org.opensearch.common.xcontent.json.JsonXContent;
        TemplateScript TemplateScript = compiled.newInstance(script.getParams());
        {  
    public void testEscapeJson() throws IOException {
 */
import org.opensearch.core.xcontent.XContentParser;  
        assertThat(TemplateScript.execute(), equalTo("{\"match_all\":{}}"));
            case '"':  
            + "  }"
    @Before  
import java.util.Collections;
            "\\u000C",
            vars.put("body_val", "\"quick brown\"");
     * quotation mark, reverse solidus, and the control characters (U+0000
            StringWriter target = new StringWriter();
            "\\u000E",
            "\\u0003",
import java.io.IOException;  
        }
    }
        TemplateScript.Factory compiled = qe.compile(null, script.getIdOrCode(), TemplateScript.CONTEXT, Collections.emptyMap());  
            "\\\\",
            '\u000E',
 * Modifications Copyright OpenSearch Contributors. See  
        Script script = Script.parse(parser);
 */
                + "\"negative\": {\"term\": {\"body\": {\"value\": \"{{body_val}}\"}"  
import java.io.StringWriter;
            "\\\"",  
            '\u0001',  
 * Mustache based templating test  
                return string.substring(0, i);
        return string;
            "\\u000B",  
            int rounds = scaledRandomIntBetween(1, 20);
package org.opensearch.script.mustache;
 * SPDX-License-Identifier: Apache-2.0
            vars.put("boost_val", "0.3");  
     * From https://www.ietf.org/rfc/rfc4627.txt:  
            + "  \"source\" : \"{ \\\"match_{{#use_it}}{{template}}{{/use_it}}\\\":{} }\","
        }
/*
     * <p>
import org.junit.Before;
    public void testSimpleParameterReplace() {  
            );  
    private static boolean isEscapeChar(char c) {
 * under the License.  
        factory = new CustomMustacheFactory();  
    public void testSimple() throws IOException {
    }  
            assertEquals(  
            '\u0009',
                + "\"positive\": {\"match\": {\"body\": \"gift\"}},"
 *    http://www.apache.org/licenses/LICENSE-2.0
            '\u0007',  
            '\u000B',  
        }
 * KIND, either express or implied.  See the License for the
                "GET _search {\"query\": {\"boosting\": {\"positive\": {\"match\": {\"body\": \"gift\"}},"
     * All Unicode characters may be placed within the
        Script script = Script.parse(parser);
    }
}
        switch (c) {
            + "    \"use_it\": true"
 * You may obtain a copy of the License at  
            factory.encode(writer.toString(), target);
                String s = getChars();
            assertEquals(
            assertThat(writer.toString(), equalTo("\\n"));
        qe = new MustacheScriptEngine();
            assertThat(writer.toString(), equalTo("hello \\n world"));  
/*  
            "\\u0009",
            Map<String, Object> vars = new HashMap<>();
            '\u0008',
            }  
 * license agreements. See the NOTICE file distributed with
                + "}}, \"negative_boost\": {{boost_val}} } }}";
     * through U+001F).
 *
 *  
 * compatible open source license.
    }
 * not use this file except in compliance with the License.
     * quotation marks except for the characters that must be escaped:  
 * this work for additional information regarding copyright
            + "  \"params\":{"
        }
                expect.append(escapedChars[charIndex]);
            "\\u001F" };
            vars.put("boost_val", "0.3");  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.script.Script;
            String template = "GET _search {\"query\": "  
        String string = randomRealisticUnicodeOfCodepointLengthBetween(0, 10);
            }  
            "\\u0008",
                expect.write(s);
        }
            factory.encode("hello \n world", writer);
        {
            "\\u0007",  
            if (isEscapeChar(string.charAt(i))) {
                + "{\"boosting\": {"
        }  
    }  
                writer.write(s);  
        Map<String, String> compileParams = Collections.singletonMap("content_type", "application/json");
 * The OpenSearch Contributors require contributions made to  
    private String getChars() {
                + "{\"boosting\": {"
     * */  
            "\\u0006",
            '\"',  
            '\\',
        if (c < '\u002F') return true;
        Character[] specialChars = new Character[] {
            StringWriter expect = new StringWriter();
            '\u0006',
/**
            "\\u0005",
import org.opensearch.test.OpenSearchTestCase;  
import com.github.mustachejava.MustacheFactory;  
        }  
            case '\\':
            "\\u0002",
        {
/*
                + "\"negative\": {\"term\": {\"body\": {\"value\": \"solr\"}"  
        XContentParser parser = createParser(JsonXContent.jsonXContent, templateString);
        for (int i = 0; i < string.length(); i++) {  
        for (int i = 0; i < iters; i++) {  
            '\u000C',
                o
            StringWriter writer = new StringWriter();  
                int charIndex = randomInt(7);  
                    + "\"negative\": {\"term\": {\"body\": {\"value\": \"solr\"}}}, \"negative_boost\": 0.3 } }}",
 * GitHub history for details.
            + "}";  
            '\u0005',
    }  
import java.util.Map;
            '\u0002',
            for (int j = 0; j < rounds; j++) {
            '\u001F' };
        String[] escapedChars = new String[] {
            + "    \"template\":\"all\","  
import static org.hamcrest.Matchers.equalTo;  
        XContentParser parser = createParser(JsonXContent.jsonXContent, templateString);
            StringWriter writer = new StringWriter();
    private MustacheFactory factory;
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;  
                + "}}, \"negative_boost\": {{boost_val}} } }}";
public class MustacheScriptEngineTests extends OpenSearchTestCase {
            String o = qe.compile(null, template, TemplateScript.CONTEXT, compileParams).newInstance(vars).execute();
            );
    private MustacheScriptEngine qe;  
 * software distributed under the License is distributed on an
                    + "\"negative\": {\"term\": {\"body\": {\"value\": \"\\\"quick brown\\\"\"}}}, \"negative_boost\": 0.3 } }}",
            "\\u0000",
            "\\u0004",  
        assertThat(TemplateScript.execute(), equalTo("{ \"match_all\":{} }"));
            Map<String, Object> vars = new HashMap<>();
            String o = qe.compile(null, template, TemplateScript.CONTEXT, compileParams).newInstance(vars).execute();
                + "\"positive\": {\"match\": {\"body\": \"gift\"}},"
 * Licensed to Elasticsearch under one or more contributor  
 *
        return false;  
            '\u000F',  
        String templateString = "{"  
        int iters = scaledRandomIntBetween(100, 1000);
