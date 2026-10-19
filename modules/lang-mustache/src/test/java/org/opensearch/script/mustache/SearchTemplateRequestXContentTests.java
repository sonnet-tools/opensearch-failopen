 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    @Override  
/*
import static org.hamcrest.Matchers.hasEntry;
            + "    'params' : {"
        request.setScriptParams(scriptParams);
    protected void assertEqualInstances(SearchTemplateRequest expectedInstance, SearchTemplateRequest newInstance) {  
        request.setSearchPipeline("pipeline");  
        SearchTemplateRequest request = SearchTemplateRequest.fromXContent(newParser(source));
import org.opensearch.core.xcontent.XContentParseException;
 * SPDX-License-Identifier: Apache-2.0
 */  
        request.setScript("{\"query\": { \"match\" : { \"{{my_field}}\" : \"{{my_value}}\" } } }");
        expectThrows(XContentParseException.class, () -> SearchTemplateRequest.fromXContent(newParser("{'id' : 'another_temp }")));
 * specific language governing permissions and limitations
            + "        'status': [\n"  
import java.util.Objects;  
     */
     * - The 'simulate' option, since this parameter is not included in the  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
    /**
 * the Apache License, Version 2.0 (the "License"); you may
            .field("id", "match_template")  
 *  
    }
                && Objects.equals(expectedInstance.getScriptParams(), newInstance.getScriptParams())  
    public SearchTemplateRequest createTestInstance() {
                && expectedInstance.isProfile() == newInstance.isProfile()  
            + "    'source' : {\n"  
        Map<String, Object> scriptParams = new HashMap<>();
        String source = "{"
     *   parameters and also isn't captured in the request's xContent.  
            .field("my_value", "bar")
        assertThat(request.getScriptParams(), hasEntry("my_value", "bar"));
        XContentBuilder expectedRequest = MediaTypeRegistry.contentBuilder(contentType)
    }
            .endObject()
     */  
import java.io.IOException;  
        Map<String, Object> params = new HashMap<>();
    }
    @Override
import org.opensearch.core.xcontent.MediaTypeRegistry;
        request.setScriptType(ScriptType.STORED);
            .field("explain", true)
            + "    },"  
        assertTrue(
        assertNotNull(s);
     *   request's xContent (it's instead used to determine the request endpoint).
public class SearchTemplateRequestXContentTests extends AbstractXContentTestCase<SearchTemplateRequest> {
package org.opensearch.script.mustache;
 * KIND, either express or implied.  See the License for the
        String source = "{"
        request.setProfile(true);
        XContentBuilder expectedRequest = MediaTypeRegistry.contentBuilder(contentType)
        assertThat(request.getScript(), equalTo("{\"query\":{\"match\":{\"{{my_field}}\":\"{{my_value}}\"}},\"size\":\"{{my_size}}\"}"));  
    public void testFromXContentWithMalformedRequest() {
    private XContentParser newParser(String s) throws IOException {
import java.util.HashMap;
        XContentBuilder actualRequest = MediaTypeRegistry.contentBuilder(contentType);
    public void testToXContentWithInlineTemplate() throws IOException {  
    public void testFromXContentWithEmbeddedTemplate() throws Exception {
        XContentType contentType = randomFrom(XContentType.values());
    protected boolean supportsUnknownFields() {
     * Creates a {@link XContentParser} with the given String while replacing single quote to double quotes.
            + "        'my_field' : 'foo',"
            .startObject("params")
            + "          '{{.}}',\n"
        assertThat(request.getScriptType(), equalTo(ScriptType.INLINE));  
            .field("profile", true)
import org.opensearch.common.xcontent.json.JsonXContent;
    }  
        assertThat(request.getScriptParams().size(), equalTo(3));
            .endObject();  
        assertThat(request.getScript(), equalTo("{\"query\":{\"terms\":{\"status\":[\"{{#status}}\",\"{{.}}\",\"{{/status}}\"]}}}"));
 * software distributed under the License is distributed on an
        assertToXContentEquivalent(BytesReference.bytes(expectedRequest), BytesReference.bytes(actualRequest), contentType);
 * Modifications Copyright OpenSearch Contributors. See
        );
    }  
        assertThat(request.getScriptType(), equalTo(ScriptType.INLINE));
    }
            .startObject("params")
        params.put("my_field", "foo");
        SearchTemplateRequest request = new SearchTemplateRequest();  
        return createParser(JsonXContent.jsonXContent, s.replace("'", "\""));  
        assertToXContentEquivalent(BytesReference.bytes(expectedRequest), BytesReference.bytes(actualRequest), contentType);
 * Unless required by applicable law or agreed to in writing,
            .field("search_pipeline", "pipeline")
            .endObject();
            .field("profile", false)  
 * not use this file except in compliance with the License.
        XContentType contentType = randomFrom(XContentType.values());  
                && Objects.equals(expectedInstance.getScript(), newInstance.getScript())
    /**
            + "    'source' : {"  
        SearchTemplateRequest request = new SearchTemplateRequest();
        request.toXContent(actualRequest, ToXContent.EMPTY_PARAMS);  
            + "      }\n"
        scriptParams.put("my_value", "bar");
 * compatible open source license.
        SearchTemplateRequest request = SearchTemplateRequest.fromXContent(newParser(source));
            + "  }"
import org.opensearch.test.AbstractXContentTestCase;
import org.opensearch.script.ScriptType;  
            + "}";  
import org.opensearch.core.xcontent.XContentParser;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
            + "    'query': {\n"
    }
        request.setExplain(true);
}
            .field("my_value", "bar")  
    public void testFromXContentWithEmbeddedTemplateAndParams() throws Exception {
            .field("my_field", "foo")  
            .startObject()  
     * Note that when checking equality for xContent parsing, we omit two parts of the request:
import static org.hamcrest.Matchers.nullValue;
    @Override
    }
            .field("search_pipeline", "pipeline")
            + "    }\n"  
 *
            .field("source", "{\"query\": { \"match\" : { \"{{my_field}}\" : \"{{my_value}}\" } } }")
            expectedInstance.isExplain() == newInstance.isExplain()
/*  
        assertThat(request.getScriptParams(), nullValue());
/*  
            + "        'my_value' : 'bar',"  
            + "    }"
        scriptParams.put("my_field", "foo");  
        params.put("my_value", "bar");  
        return SearchTemplateRequestTests.createRandomRequest();
            .endObject()
 */
 * under the License.  
            + "          '{{#status}}',\n"
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.core.xcontent.ToXContent;
import java.util.Map;
            .startObject()
        // Unclosed template id  
        request.setScript("match_template");  
            + "        'my_size' : 5"
import org.opensearch.core.common.bytes.BytesReference;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(request.getScriptParams(), hasEntry("my_field", "foo"));  
            + "      'size' : '{{my_size}}'"
        request.setScriptParams(params);
                && expectedInstance.getScriptType() == newInstance.getScriptType()
        request.setScriptType(ScriptType.INLINE);  
        return false;  
        request.setSearchPipeline("pipeline");
            + "        ]\n"
import org.opensearch.core.xcontent.XContentBuilder;  
            + "          '{{/status}}'\n"  
    }
            + "}";
            + "      'query': { 'match' : { '{{my_field}}' : '{{my_value}}' } },"
        request.toXContent(actualRequest, ToXContent.EMPTY_PARAMS);
            .field("my_field", "foo")
    protected SearchTemplateRequest doParseInstance(XContentParser parser) throws IOException {  
     * - The random SearchRequest, since this component only affects the request
        XContentBuilder actualRequest = MediaTypeRegistry.contentBuilder(contentType);
import static org.hamcrest.Matchers.equalTo;  
 */  
        return SearchTemplateRequest.fromXContent(parser);
            + "      'terms': {\n"
            .field("explain", false)  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
    public void testToXContentWithStoredTemplate() throws IOException {
        assertThat(request.getScriptParams(), hasEntry("my_size", 5));
    }  
 *
