            factory.encode(writer.toString(), target);
        Script script = Script.parse(parser);
    }
 * compatible open source license.
        }
 * license agreements. See the NOTICE file distributed with
                expect.write(s);
        }
        return string;
            "\\u0003",
            factory.encode("hello \n world", writer);
            assertEquals(
 * You may obtain a copy of the License at
            "\\u0000",
                "GET _search {\"query\": {\"boosting\": {\"positive\": {\"match\": {\"body\": \"gift\"}},"
            '\u0008',
        assertThat(TemplateScript.execute(), equalTo("{ \"match_all\":{} }"));
            "\\u000E",
    private MustacheFactory factory;
            assertEquals(
        for (int i = 0; i < string.length(); i++) {
                + "}}, \"negative_boost\": {{boost_val}} } }}";
        assertThat(TemplateScript.execute(), equalTo("{\"match_all\":{}}"));
 * software distributed under the License is distributed on an
 *
            int rounds = scaledRandomIntBetween(1, 20);
 *
     * From https://www.ietf.org/rfc/rfc4627.txt:
            );
            vars.put("boost_val", "0.3");
        }
        for (int i = 0; i < iters; i++) {
            Map<String, Object> vars = new HashMap<>();
            '\"',
 */
import java.io.IOException;
            "\\u000C",
        {
            vars.put("body_val", "\"quick brown\"");
        }
    }
     * */
            '\u0006',
        return false;
 * the Apache License, Version 2.0 (the "License"); you may
                + "\"positive\": {\"match\": {\"body\": \"gift\"}},"
            "\\u0009",
            '\u000B',
    public void testEscapeJson() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
            '\u000E',
        }
            String template = "GET _search {\"query\": "
            StringWriter writer = new StringWriter();
            + "    \"template\":\"all\","
     * quotation mark, reverse solidus, and the control characters (U+0000
    /**
        Map<String, String> compileParams = Collections.singletonMap("content_type", "application/json");
            StringWriter expect = new StringWriter();
                + "{\"boosting\": {"
 * this work for additional information regarding copyright
     * through U+001F).
                + "{\"boosting\": {"
                o
 */
            StringWriter writer = new StringWriter();
            if (isEscapeChar(string.charAt(i))) {
        if (c < '\u002F') return true;
            factory.encode("\n", writer);
import java.util.Collections;
            Map<String, Object> vars = new HashMap<>();
    public void setup() {
    public void testSimple() throws IOException {
                return true;
        String string = randomRealisticUnicodeOfCodepointLengthBetween(0, 10);
                o
                expect.append(escapedChars[charIndex]);
            assertThat(writer.toString(), equalTo("hello \\n world"));
        String templateString = "{" + "\"source\":{\"match_{{template}}\": {}}," + "\"params\":{\"template\":\"all\"}" + "}";
import org.opensearch.core.xcontent.XContentParser;
            '\u0002',
public class MustacheScriptEngineTests extends OpenSearchTestCase {
import static org.hamcrest.Matchers.equalTo;
    }
    private static boolean isEscapeChar(char c) {
 * SPDX-License-Identifier: Apache-2.0
            "\\u0002",
        }
        {
                + "}}, \"negative_boost\": {{boost_val}} } }}";
import org.opensearch.script.TemplateScript;
 */
    }
 * GitHub history for details.
            '\u0007',
                + "\"positive\": {\"match\": {\"body\": \"gift\"}},"
            + "  \"params\":{"
            case '"':
 * not use this file except in compliance with the License.
                String s = getChars();
import com.github.mustachejava.MustacheFactory;
            "\\u0006",
import java.io.StringWriter;
import org.opensearch.script.Script;
        String templateString = "{"
 * Licensed to Elasticsearch under one or more contributor
                    + "\"negative\": {\"term\": {\"body\": {\"value\": \"\\\"quick brown\\\"\"}}}, \"negative_boost\": 0.3 } }}",
            '\u000C',
 * The OpenSearch Contributors require contributions made to
package org.opensearch.script.mustache;
            assertThat(expect.toString(), equalTo(target.toString()));
        String[] escapedChars = new String[] {
     * All Unicode characters may be placed within the
                writer.write(s);
 * this file be licensed under the Apache-2.0 license or a
}
        Script script = Script.parse(parser);
            + "  }"
import org.junit.Before;
    @Before
            StringWriter writer = new StringWriter();
            String o = qe.compile(null, template, TemplateScript.CONTEXT, compileParams).newInstance(vars).execute();
/**
                int charIndex = randomInt(7);
            + "  \"source\" : \"{ \\\"match_{{#use_it}}{{template}}{{/use_it}}\\\":{} }\","
                return string.substring(0, i);
            '\\',
     * <p>
import java.util.Map;
        }
 */
            for (int j = 0; j < rounds; j++) {
            "\\u000B",
     * quotation marks except for the characters that must be escaped:
            '\u0000',
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                "GET _search {\"query\": {\"boosting\": {\"positive\": {\"match\": {\"body\": \"gift\"}},"
    private String getChars() {
/*
import java.util.HashMap;
            "\\u0005",
    }
            StringWriter target = new StringWriter();
        {
    public void testSimpleParameterReplace() {
            String o = qe.compile(null, template, TemplateScript.CONTEXT, compileParams).newInstance(vars).execute();
            '\u000F',
        TemplateScript TemplateScript = compiled.newInstance(script.getParams());
        TemplateScript TemplateScript = compiled.newInstance(script.getParams());
            '\u0004',
        Character[] specialChars = new Character[] {
/*
            vars.put("boost_val", "0.3");
 * ownership. Elasticsearch licenses this file to you under
            "\\\"",
            '\u0003',
                + "\"negative\": {\"term\": {\"body\": {\"value\": \"solr\"}"
        XContentParser parser = createParser(JsonXContent.jsonXContent, templateString);
            "\\u0008",
            "\\u000F",
            '\u001F' };
            + "    \"use_it\": true"
            );
            case '\\':
        {
    }
        factory = new CustomMustacheFactory();
 * Mustache based templating test
            "\\u001F" };
            "\\u0004",
    public void testParseTemplateAsSingleStringWithConditionalClause() throws IOException {
            String template = "GET _search {\"query\": "
        switch (c) {
            "\\u0001",
            '\u0005',
import org.opensearch.common.xcontent.json.JsonXContent;
                + "\"negative\": {\"term\": {\"body\": {\"value\": \"{{body_val}}\"}"
            + "}";
        TemplateScript.Factory compiled = qe.compile(null, script.getIdOrCode(), TemplateScript.CONTEXT, Collections.emptyMap());
        qe = new MustacheScriptEngine();
    }
    private MustacheScriptEngine qe;
            '\u0001',
/*
                writer.append(specialChars[charIndex]);
 *
            "\\\\",
                    + "\"negative\": {\"term\": {\"body\": {\"value\": \"solr\"}}}, \"negative_boost\": 0.3 } }}",
        int iters = scaledRandomIntBetween(100, 1000);
            assertThat(writer.toString(), equalTo("\\n"));
            '\u0009',
 * Modifications Copyright OpenSearch Contributors. See
            "\\u0007",
            }
        TemplateScript.Factory compiled = qe.compile(null, script.getIdOrCode(), TemplateScript.CONTEXT, Collections.emptyMap());
 * Unless required by applicable law or agreed to in writing,
        XContentParser parser = createParser(JsonXContent.jsonXContent, templateString);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * under the License.
            }
 * KIND, either express or implied.  See the License for the
