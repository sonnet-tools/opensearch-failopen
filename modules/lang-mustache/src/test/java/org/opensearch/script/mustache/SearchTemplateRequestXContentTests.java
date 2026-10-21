        request.setScriptParams(params);
import java.util.HashMap;
 */
        request.setSearchPipeline("pipeline");
        assertThat(request.getScriptParams(), nullValue());
     * - The 'simulate' option, since this parameter is not included in the
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .field("profile", false)
            + "      'size' : '{{my_size}}'"
    public void testFromXContentWithMalformedRequest() {
    }
    }
 *
 * license agreements. See the NOTICE file distributed with
     * Note that when checking equality for xContent parsing, we omit two parts of the request:
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * software distributed under the License is distributed on an
    @Override
            + "    },"
        request.setProfile(true);
        return SearchTemplateRequestTests.createRandomRequest();
}
        assertTrue(
     */
            + "    'source' : {"
 * Licensed to Elasticsearch under one or more contributor
        SearchTemplateRequest request = new SearchTemplateRequest();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
    protected boolean supportsUnknownFields() {
        request.toXContent(actualRequest, ToXContent.EMPTY_PARAMS);
        request.setSearchPipeline("pipeline");
            .field("search_pipeline", "pipeline")
            .startObject()
import org.opensearch.core.xcontent.XContentParser;
            expectedInstance.isExplain() == newInstance.isExplain()
    /**
        XContentBuilder actualRequest = MediaTypeRegistry.contentBuilder(contentType);
public class SearchTemplateRequestXContentTests extends AbstractXContentTestCase<SearchTemplateRequest> {
import org.opensearch.core.xcontent.ToXContent;
                && expectedInstance.isProfile() == newInstance.isProfile()
import static org.hamcrest.Matchers.hasEntry;
 * compatible open source license.
            .endObject()
 */
        return false;
/*
        request.setScript("{\"query\": { \"match\" : { \"{{my_field}}\" : \"{{my_value}}\" } } }");
        // Unclosed template id
        assertThat(request.getScript(), equalTo("{\"query\":{\"terms\":{\"status\":[\"{{#status}}\",\"{{.}}\",\"{{/status}}\"]}}}"));
        XContentBuilder expectedRequest = MediaTypeRegistry.contentBuilder(contentType)
            .field("my_value", "bar")
        SearchTemplateRequest request = SearchTemplateRequest.fromXContent(newParser(source));
    }
            + "          '{{.}}',\n"
     * - The random SearchRequest, since this component only affects the request
    public void testToXContentWithInlineTemplate() throws IOException {
        String source = "{"
        return SearchTemplateRequest.fromXContent(parser);
    public SearchTemplateRequest createTestInstance() {
            + "}";
            + "    }\n"
        assertThat(request.getScriptType(), equalTo(ScriptType.INLINE));
        request.setScript("match_template");
     * Creates a {@link XContentParser} with the given String while replacing single quote to double quotes.
            + "}";
            + "        'my_field' : 'foo',"
        assertThat(request.getScript(), equalTo("{\"query\":{\"match\":{\"{{my_field}}\":\"{{my_value}}\"}},\"size\":\"{{my_size}}\"}"));
            + "    'source' : {\n"
            + "    'query': {\n"
            + "    'params' : {"
        return createParser(JsonXContent.jsonXContent, s.replace("'", "\""));
 * specific language governing permissions and limitations
    private XContentParser newParser(String s) throws IOException {
        assertNotNull(s);
import static org.hamcrest.Matchers.nullValue;
    @Override
 * not use this file except in compliance with the License.
import org.opensearch.script.ScriptType;
     *   parameters and also isn't captured in the request's xContent.
            .startObject()
package org.opensearch.script.mustache;
     *   request's xContent (it's instead used to determine the request endpoint).
 * GitHub history for details.
    public void testFromXContentWithEmbeddedTemplate() throws Exception {
import java.io.IOException;
    }
 * Unless required by applicable law or agreed to in writing,
            .field("my_field", "foo")
    protected void assertEqualInstances(SearchTemplateRequest expectedInstance, SearchTemplateRequest newInstance) {
        assertThat(request.getScriptType(), equalTo(ScriptType.INLINE));
        XContentBuilder expectedRequest = MediaTypeRegistry.contentBuilder(contentType)
            .endObject();
            + "      'terms': {\n"
        XContentBuilder actualRequest = MediaTypeRegistry.contentBuilder(contentType);
                && expectedInstance.getScriptType() == newInstance.getScriptType()
        SearchTemplateRequest request = SearchTemplateRequest.fromXContent(newParser(source));
            + "          '{{#status}}',\n"
     */
            + "        'my_value' : 'bar',"
        request.toXContent(actualRequest, ToXContent.EMPTY_PARAMS);
        assertThat(request.getScriptParams().size(), equalTo(3));
    @Override
import static org.hamcrest.Matchers.equalTo;
        request.setScriptType(ScriptType.STORED);
 */
            + "      'query': { 'match' : { '{{my_field}}' : '{{my_value}}' } },"
        );
import org.opensearch.core.xcontent.XContentParseException;
    public void testToXContentWithStoredTemplate() throws IOException {
import org.opensearch.test.AbstractXContentTestCase;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.xcontent.XContentBuilder;
    }
            + "    }"
 *
    protected SearchTemplateRequest doParseInstance(XContentParser parser) throws IOException {
    }
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Map;
            .field("search_pipeline", "pipeline")
            + "        ]\n"
            .endObject()
            .field("explain", false)
        params.put("my_field", "foo");
        params.put("my_value", "bar");
        scriptParams.put("my_field", "foo");
        assertThat(request.getScriptParams(), hasEntry("my_value", "bar"));
            .field("profile", true)
        assertToXContentEquivalent(BytesReference.bytes(expectedRequest), BytesReference.bytes(actualRequest), contentType);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        scriptParams.put("my_value", "bar");
            + "  }"
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testFromXContentWithEmbeddedTemplateAndParams() throws Exception {
        request.setScriptParams(scriptParams);
    /**
 *
 * You may obtain a copy of the License at
            .field("my_value", "bar")
        request.setScriptType(ScriptType.INLINE);
import java.util.Objects;
            .field("explain", true)
            .field("source", "{\"query\": { \"match\" : { \"{{my_field}}\" : \"{{my_value}}\" } } }")
            .endObject();
        assertThat(request.getScriptParams(), hasEntry("my_field", "foo"));
 * The OpenSearch Contributors require contributions made to
        SearchTemplateRequest request = new SearchTemplateRequest();
        request.setExplain(true);
import org.opensearch.common.xcontent.XContentType;
        Map<String, Object> scriptParams = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
                && Objects.equals(expectedInstance.getScript(), newInstance.getScript())
            + "        'status': [\n"
                && Objects.equals(expectedInstance.getScriptParams(), newInstance.getScriptParams())
import org.opensearch.common.xcontent.json.JsonXContent;
            + "      }\n"
        assertToXContentEquivalent(BytesReference.bytes(expectedRequest), BytesReference.bytes(actualRequest), contentType);
            + "          '{{/status}}'\n"
            .startObject("params")
        XContentType contentType = randomFrom(XContentType.values());
 * this file be licensed under the Apache-2.0 license or a
/*
        expectThrows(XContentParseException.class, () -> SearchTemplateRequest.fromXContent(newParser("{'id' : 'another_temp }")));
            .field("my_field", "foo")
 * KIND, either express or implied.  See the License for the
        String source = "{"
            .startObject("params")
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        XContentType contentType = randomFrom(XContentType.values());
            .field("id", "match_template")
 * under the License.
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        assertThat(request.getScriptParams(), hasEntry("my_size", 5));
    }
            + "        'my_size' : 5"
