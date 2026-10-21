    }
import static org.hamcrest.Matchers.arrayContaining;
        // Deserialize the request
        byte[] data = StreamsUtils.copyToBytesFromClasspath("/org/opensearch/script/mustache/simple-msearch-template.json");
        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(data), MediaTypeRegistry.JSON)
        assertThat(request.requests().get(0).getRequest().indices()[1], equalTo("test1"));
        MultiSearchTemplateRequest request = RestMultiSearchTemplateAction.parseRequest(restRequest, true);
        MultiSearchTemplateRequest multiSearchTemplateRequest = new MultiSearchTemplateRequest();
            searchRequest.pipeline("pipeline");
    public void testParseRequestWithSearchPipeline() throws Exception {
        assertThat(request.requests().get(0).getRequest().indices(), arrayContaining("test0", "test1"));
 *
import org.opensearch.core.common.bytes.BytesArray;
import java.util.Map;
            SearchRequest searchRequest = new SearchRequest(indices);
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(request.requests().get(0).getRequest().preference(), nullValue());
import org.opensearch.rest.RestRequest;
 */
    public void testMultiSearchTemplateToJson() throws Exception {
        assertEquals("{\"query\":{\"match_{{template}}\":{}}}", searchTemplateRequest.getScript());
/*
            MediaTypeRegistry.JSON
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.test.OpenSearchTestCase;
/*
            searchRequest.setBatchedReduceSize(SearchRequest.DEFAULT_BATCHED_REDUCE_SIZE);
        assertNotNull(request.requests().get(0).getScript());
}
        request.maxConcurrentSearchRequests(randomIntBetween(1, Integer.MAX_VALUE));
        assertThat(request.requests().get(0).getRequest().indices()[0], equalTo("test0"));
        assertEquals("{\"query\":{\"match_{{template}}\":{}}}", request.requests().get(1).getScript());
        assertEquals(serialized, toJsonString(deser));
import org.opensearch.test.rest.FakeRestRequest;
import java.nio.charset.StandardCharsets;
    public void testMaxConcurrentSearchRequests() {
        return new String(bytes, StandardCharsets.UTF_8);
        for (int i = 0; i < numSearchRequests; i++) {
            searchTemplateRequest.setSearchPipeline("pipeline");
        assertThat(request.requests().get(0).getRequest().indices()[1], equalTo("test1"));
 * specific language governing permissions and limitations
        assertEquals(1, request.requests().get(2).getScriptParams().size());
        assertThat(request.requests().get(0).getRequest().indices()[0], equalTo("test0"));
            searchTemplateRequest.setProfile(randomBoolean());
            searchTemplateRequest.setScriptParams(scriptParams);
        assertEquals(1, request.requests().get(1).getScriptParams().size());
            + "{\"source\": {\"query\" : {\"match_{{template}}\" :{}}}, \"params\": {\"template\": \"all\" } }\r\n";
        assertThat(request.requests().get(2).getRequest().indices()[1], equalTo("test1"));
        ).build();
            // scroll is not supported in the current msearch or msearchtemplate api, so unset it:
        final String content = "{\"index\":[\"test0\", \"test1\"], \"request_cache\": true}\r\n"
            Map<String, Object> scriptParams = new HashMap<>();
 * The OpenSearch Contributors require contributions made to
 */
        assertThat(request.requests().get(2).getRequest().indices()[0], equalTo("test4"));
            new BytesArray(content),
        assertThat(request.requests().get(1).getRequest().indices()[0], equalTo("test2"));
        SearchTemplateRequest searchTemplateRequest = request.requests().get(0);
    public void testParseWithCarriageReturn() throws Exception {
        }
        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(data), MediaTypeRegistry.JSON)
 */
        assertEquals(ScriptType.INLINE, request.requests().get(0).getScriptType());
        assertThat(request.requests().get(2).getRequest().indices()[0], equalTo("test4"));
        assertThat(request.requests().get(2).getRequest().routing(), equalTo("123"));
    }
        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
        // For object equality purposes need to set the search requests' source to non-null
    public void testParseRequest() throws Exception {
        assertEquals("{\"query\":{\"match_{{template}}\":{}}}", request.requests().get(0).getScript());
        ).build();
            SearchRequest sr = str.getRequest();
 * Licensed to Elasticsearch under one or more contributor
        assertEquals("{\"query\":{\"match_{{template}}\":{}}}", request.requests().get(2).getScript());
        assertNotNull(request.requests().get(1).getScript());
        assertThat(request.requests().get(1).getRequest().indices()[0], equalTo("test2"));
        MultiSearchTemplateRequest deser = RestMultiSearchTemplateAction.parseRequest(restRequest, true);
        assertThat(request.requests().get(0).getRequest().requestCache(), equalTo(true));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals(ScriptType.INLINE, request.requests().get(0).getScriptType());
            SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest(searchRequest);
 * not use this file except in compliance with the License.
        MultiSearchTemplateRequest request = RestMultiSearchTemplateAction.parseRequest(restRequest, true);
        assertEquals(ScriptType.INLINE, request.requests().get(1).getScriptType());
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(request.requests().get(2).getRequest().indices(), arrayContaining("test4", "test1"));
        // Serialize the request
    }
 *
 * under the License.
        MultiSearchTemplateRequest request = RestMultiSearchTemplateAction.parseRequest(restRequest, true);
        assertEquals(1, request.requests().get(0).getScriptParams().size());
        assertThat(request.requests().get(0).getRequest().requestCache(), equalTo(true));
import static org.hamcrest.Matchers.equalTo;
        assertThat(request.requests().get(0).getRequest().preference(), nullValue());
import org.opensearch.script.ScriptType;
            // batched reduce size is currently not set-able on a per-request basis as it is a query string parameter only
 * GitHub history for details.
        assertThat(request.requests().get(2).getRequest().indices()[1], equalTo("test1"));
        assertThat(request.requests().get(1).getRequest().pipeline(), equalTo("my_pipeline1"));
        // Additional validation
            }
        assertNotNull(request.requests().get(0).getScript());
import org.opensearch.action.search.SearchRequest;
import java.util.HashMap;
        assertThat(request.requests().get(0).getRequest().indices()[1], equalTo("test1"));
import org.opensearch.search.Scroll;
 * You may obtain a copy of the License at
        // Finally, serialize the deserialized request to compare JSON equivalence (in case Object.equals() fails to reveal a discrepancy)
import org.opensearch.test.StreamsUtils;
        assertThat(request.requests().get(0).getRequest().indices(), arrayContaining("test0", "test1"));
        assertThat(request.requests().size(), equalTo(1));
 *
        assertThat(request.requests().get(0).getRequest().indices()[0], equalTo("test0"));
            new BytesArray(serialized),
        for (SearchTemplateRequest str : deser.requests()) {
        assertThat(request.requests().size(), equalTo(3));
import static org.hamcrest.Matchers.nullValue;
        assertThat(request.requests().size(), equalTo(3));
 * Unless required by applicable law or agreed to in writing,
        String serialized = toJsonString(multiSearchTemplateRequest);
            MediaTypeRegistry.JSON
        MultiSearchTemplateRequest request = new MultiSearchTemplateRequest();
 * compatible open source license.
            String[] indices = { "test" };
        assertThat(request.requests().get(1).getRequest().indices()[1], equalTo("test3"));
            // Create a random request.
 * this work for additional information regarding copyright
        assertEquals(1, request.requests().get(0).getScriptParams().size());
 * license agreements. See the NOTICE file distributed with
        }
        assertEquals(ScriptType.INLINE, request.requests().get(2).getScriptType());
        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("all", searchTemplateRequest.getScriptParams().get("template"));
            multiSearchTemplateRequest.add(searchTemplateRequest);
        byte[] data = StreamsUtils.copyToBytesFromClasspath("/org/opensearch/script/mustache/simple-msearch-template.json");
            searchTemplateRequest.setScriptType(ScriptType.INLINE);
        assertEquals("{\"query\":{\"match_{{template}}\":{}}}", request.requests().get(0).getScript());
        byte[] bytes = MultiSearchTemplateRequest.writeMultiLineFormat(multiSearchTemplateRequest, MediaTypeRegistry.JSON.xContent());
            searchTemplateRequest.setScript("{\"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" }}}");
    }
 * software distributed under the License is distributed on an
    }
        assertThat(request.requests().get(1).getRequest().indices(), arrayContaining("test2", "test3"));
        final int numSearchRequests = randomIntBetween(1, 10);
        assertThat(request.requests().get(1).getRequest().requestCache(), nullValue());
 * Modifications Copyright OpenSearch Contributors. See
            searchRequest.scroll((Scroll) null);
        expectThrows(IllegalArgumentException.class, () -> request.maxConcurrentSearchRequests(randomIntBetween(Integer.MIN_VALUE, 0)));
            scriptParams.put("field", "name");
                sr.source(new SearchSourceBuilder());
 * KIND, either express or implied.  See the License for the
    }
            scriptParams.put("value", randomAlphaOfLengthBetween(2, 5));
        assertThat(request.requests().get(1).getRequest().indices()[1], equalTo("test3"));
        assertNotNull(request.requests().get(2).getScript());
        assertThat(request.requests().get(2).getRequest().pipeline(), equalTo("my_pipeline2"));
        assertThat(request.requests().get(1).getRequest().preference(), equalTo("_local"));
    protected String toJsonString(MultiSearchTemplateRequest multiSearchTemplateRequest) throws IOException {
package org.opensearch.script.mustache;
        assertThat(request.requests().get(0).getRequest().indices(), arrayContaining("test0", "test1"));
/*
 * SPDX-License-Identifier: Apache-2.0
public class MultiSearchTemplateRequestTests extends OpenSearchTestCase {
            .build();
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // Compare the deserialized request object with the original request object
import org.opensearch.search.builder.SearchSourceBuilder;
            if (sr.source() == null) {
        assertEquals(multiSearchTemplateRequest, deser);
        assertThat(request.requests().get(0).getRequest().pipeline(), equalTo("my_pipeline"));
