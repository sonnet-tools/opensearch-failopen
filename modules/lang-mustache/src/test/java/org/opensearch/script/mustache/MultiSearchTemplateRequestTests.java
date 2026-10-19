import org.opensearch.search.builder.SearchSourceBuilder;
        for (int i = 0; i < numSearchRequests; i++) {
            searchTemplateRequest.setSearchPipeline("pipeline");
 *
            SearchRequest searchRequest = new SearchRequest(indices);
            MediaTypeRegistry.JSON
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
import org.opensearch.script.ScriptType;
        String serialized = toJsonString(multiSearchTemplateRequest);  
        assertThat(request.requests().get(2).getRequest().pipeline(), equalTo("my_pipeline2"));
 * under the License.  
import org.opensearch.test.rest.FakeRestRequest;
        assertThat(request.requests().size(), equalTo(3));  
 * license agreements. See the NOTICE file distributed with
        assertThat(request.requests().get(0).getRequest().indices()[0], equalTo("test0"));
        assertThat(request.requests().size(), equalTo(1));
            searchRequest.setBatchedReduceSize(SearchRequest.DEFAULT_BATCHED_REDUCE_SIZE);
        assertThat(request.requests().get(0).getRequest().indices(), arrayContaining("test0", "test1"));
            searchTemplateRequest.setScriptParams(scriptParams);  
}
    public void testParseRequestWithSearchPipeline() throws Exception {
        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(  
 * specific language governing permissions and limitations
import org.opensearch.rest.RestRequest;
import static org.hamcrest.Matchers.nullValue;
 * Unless required by applicable law or agreed to in writing,
 *  
            scriptParams.put("value", randomAlphaOfLengthBetween(2, 5));
        assertEquals(multiSearchTemplateRequest, deser);
 * this file be licensed under the Apache-2.0 license or a
        // Finally, serialize the deserialized request to compare JSON equivalence (in case Object.equals() fails to reveal a discrepancy)
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
            + "{\"source\": {\"query\" : {\"match_{{template}}\" :{}}}, \"params\": {\"template\": \"all\" } }\r\n";  
        assertEquals(ScriptType.INLINE, request.requests().get(0).getScriptType());
/*  
        assertThat(request.requests().get(0).getRequest().pipeline(), equalTo("my_pipeline"));  
import java.io.IOException;  
        }  
        assertEquals("{\"query\":{\"match_{{template}}\":{}}}", request.requests().get(0).getScript());
            MediaTypeRegistry.JSON  
        assertEquals(ScriptType.INLINE, request.requests().get(0).getScriptType());  
import java.util.Map;  
        }  
        assertThat(request.requests().get(0).getRequest().preference(), nullValue());
            // Create a random request.  
import java.nio.charset.StandardCharsets;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(request.requests().get(0).getRequest().requestCache(), equalTo(true));  
            scriptParams.put("field", "name");
        assertThat(request.requests().get(1).getRequest().indices()[0], equalTo("test2"));
        assertThat(request.requests().get(1).getRequest().pipeline(), equalTo("my_pipeline1"));
        for (SearchTemplateRequest str : deser.requests()) {
        assertThat(request.requests().get(2).getRequest().indices(), arrayContaining("test4", "test1"));
        assertThat(request.requests().get(0).getRequest().indices()[1], equalTo("test1"));
        MultiSearchTemplateRequest deser = RestMultiSearchTemplateAction.parseRequest(restRequest, true);
        SearchTemplateRequest searchTemplateRequest = request.requests().get(0);
        expectThrows(IllegalArgumentException.class, () -> request.maxConcurrentSearchRequests(randomIntBetween(Integer.MIN_VALUE, 0)));
        assertNotNull(request.requests().get(0).getScript());
        MultiSearchTemplateRequest request = RestMultiSearchTemplateAction.parseRequest(restRequest, true);
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testMultiSearchTemplateToJson() throws Exception {
package org.opensearch.script.mustache;
        assertEquals("all", searchTemplateRequest.getScriptParams().get("template"));  
        // Compare the deserialized request object with the original request object
        assertThat(request.requests().get(1).getRequest().indices(), arrayContaining("test2", "test3"));  
        // For object equality purposes need to set the search requests' source to non-null  
        assertThat(request.requests().get(0).getRequest().indices()[1], equalTo("test1"));
            new BytesArray(content),
        assertEquals(ScriptType.INLINE, request.requests().get(1).getScriptType());  
        assertThat(request.requests().get(0).getRequest().preference(), nullValue());
        assertThat(request.requests().get(1).getRequest().preference(), equalTo("_local"));  
        final String content = "{\"index\":[\"test0\", \"test1\"], \"request_cache\": true}\r\n"
                sr.source(new SearchSourceBuilder());
            SearchTemplateRequest searchTemplateRequest = new SearchTemplateRequest(searchRequest);
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(request.requests().get(2).getRequest().indices()[1], equalTo("test1"));  
        assertEquals(1, request.requests().get(2).getScriptParams().size());
            searchRequest.scroll((Scroll) null);
        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(
import org.opensearch.core.xcontent.MediaTypeRegistry;  
/*  
        assertThat(request.requests().get(2).getRequest().indices()[0], equalTo("test4"));
            Map<String, Object> scriptParams = new HashMap<>();  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        assertThat(request.requests().get(1).getRequest().indices()[1], equalTo("test3"));
        byte[] bytes = MultiSearchTemplateRequest.writeMultiLineFormat(multiSearchTemplateRequest, MediaTypeRegistry.JSON.xContent());
        ).build();
public class MultiSearchTemplateRequestTests extends OpenSearchTestCase {  
import org.opensearch.search.Scroll;  
    }  
            // batched reduce size is currently not set-able on a per-request basis as it is a query string parameter only  
            .build();
    public void testParseWithCarriageReturn() throws Exception {
import static org.hamcrest.Matchers.equalTo;  
        assertEquals(1, request.requests().get(0).getScriptParams().size());
    protected String toJsonString(MultiSearchTemplateRequest multiSearchTemplateRequest) throws IOException {  
        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(data), MediaTypeRegistry.JSON)
            if (sr.source() == null) {  
import org.opensearch.core.common.bytes.BytesArray;
            new BytesArray(serialized),
    }
        final int numSearchRequests = randomIntBetween(1, 10);  
        MultiSearchTemplateRequest request = RestMultiSearchTemplateAction.parseRequest(restRequest, true);
import org.opensearch.action.search.SearchRequest;
        assertThat(request.requests().get(0).getRequest().indices()[1], equalTo("test1"));
        byte[] data = StreamsUtils.copyToBytesFromClasspath("/org/opensearch/script/mustache/simple-msearch-template.json");  
    }  
    }  
 */  
        assertEquals(serialized, toJsonString(deser));
        assertEquals("{\"query\":{\"match_{{template}}\":{}}}", request.requests().get(0).getScript());
            .build();
    public void testMaxConcurrentSearchRequests() {
            searchRequest.pipeline("pipeline");
        assertThat(request.requests().get(0).getRequest().indices(), arrayContaining("test0", "test1"));
            searchTemplateRequest.setScriptType(ScriptType.INLINE);
            // scroll is not supported in the current msearch or msearchtemplate api, so unset it:  
        // Deserialize the request
        assertThat(request.requests().get(1).getRequest().indices()[1], equalTo("test3"));
 * the Apache License, Version 2.0 (the "License"); you may
 *
    public void testParseRequest() throws Exception {
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.StreamsUtils;  
/*
    }  
        ).build();  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("{\"query\":{\"match_{{template}}\":{}}}", request.requests().get(1).getScript());  
        byte[] data = StreamsUtils.copyToBytesFromClasspath("/org/opensearch/script/mustache/simple-msearch-template.json");  
            }
        assertEquals("{\"query\":{\"match_{{template}}\":{}}}", request.requests().get(2).getScript());
            String[] indices = { "test" };
        MultiSearchTemplateRequest request = new MultiSearchTemplateRequest();  
        assertThat(request.requests().get(0).getRequest().indices(), arrayContaining("test0", "test1"));  
            searchTemplateRequest.setScript("{\"query\": { \"match\" : { \"{{field}}\" : \"{{value}}\" }}}");
 * not use this file except in compliance with the License.
        assertEquals(ScriptType.INLINE, request.requests().get(2).getScriptType());
        assertThat(request.requests().get(0).getRequest().requestCache(), equalTo(true));
        // Serialize the request
        MultiSearchTemplateRequest request = RestMultiSearchTemplateAction.parseRequest(restRequest, true);  
        MultiSearchTemplateRequest multiSearchTemplateRequest = new MultiSearchTemplateRequest();
            SearchRequest sr = str.getRequest();
        assertNotNull(request.requests().get(2).getScript());  
        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withContent(new BytesArray(data), MediaTypeRegistry.JSON)
    }
        assertEquals(1, request.requests().get(1).getScriptParams().size());  
        assertThat(request.requests().get(0).getRequest().indices()[0], equalTo("test0"));  
        assertThat(request.requests().get(2).getRequest().routing(), equalTo("123"));  
 * GitHub history for details.
            searchTemplateRequest.setProfile(randomBoolean());  
        assertThat(request.requests().get(2).getRequest().indices()[1], equalTo("test1"));
        assertThat(request.requests().get(1).getRequest().indices()[0], equalTo("test2"));  
        assertThat(request.requests().get(0).getRequest().indices()[0], equalTo("test0"));  
        assertThat(request.requests().get(1).getRequest().requestCache(), nullValue());
        assertThat(request.requests().size(), equalTo(3));  
 * You may obtain a copy of the License at  
        assertThat(request.requests().get(2).getRequest().indices()[0], equalTo("test4"));
import static org.hamcrest.Matchers.arrayContaining;
        assertNotNull(request.requests().get(0).getScript());
        request.maxConcurrentSearchRequests(randomIntBetween(1, Integer.MAX_VALUE));
        assertNotNull(request.requests().get(1).getScript());
        assertEquals("{\"query\":{\"match_{{template}}\":{}}}", searchTemplateRequest.getScript());
        return new String(bytes, StandardCharsets.UTF_8);
        assertEquals(1, request.requests().get(0).getScriptParams().size());
import java.util.HashMap;
            multiSearchTemplateRequest.add(searchTemplateRequest);
 * software distributed under the License is distributed on an
        // Additional validation
