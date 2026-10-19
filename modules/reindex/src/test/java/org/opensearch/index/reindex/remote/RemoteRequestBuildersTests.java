import static org.opensearch.index.reindex.remote.RemoteRequestBuilders.DEPRECATED_URL_ENCODED_INDEX_WARNING;  
import static org.hamcrest.Matchers.either;  
            initialSearch(searchRequest, query, remoteVersion).getParameters(),
        String scroll = randomAlphaOfLength(30);
            Streams.copyToString(new InputStreamReader(request.getEntity().getContent(), StandardCharsets.UTF_8)),
 * this work for additional information regarding copyright
import java.nio.charset.StandardCharsets;
        remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
        } else {
/*  
        assertEquals("/cat%2F,dog/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());  
    private void assertScroll(RemoteVersion remoteVersion, Map<String, String> params, TimeValue requested) {  
        assertThat(request.getParameters().keySet(), empty());
        searchRequest.indices("a", "b");
        assertEquals(ContentType.TEXT_PLAIN.toString(), entity.getContentType());
import static org.hamcrest.Matchers.empty;
 * Tests for {@link RemoteRequestBuilders} which builds requests for remote version of
            // Versions of Elasticsearch prior to 5.0 can't parse nanos or micros in TimeValue.
        } else {
        assertEquals(type + " containing [" + bad + "] not supported but got [" + failed + "]", e.getMessage());
                long millis = (long) Math.ceil(requested.millisFrac());
            "{\"query\":" + query + ",\"_source\":{\"includes\":[\"in1\",\"in2\"],\"excludes\":[\"out\"]}}",
            Streams.copyToString(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8)),
        String scroll = randomAlphaOfLength(30);  
        } else {
        SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder());
 */  
        searchRequest.source().size(size);
import java.util.Map;  
import static org.hamcrest.Matchers.endsWith;
            RuntimeException.class,
import static org.hamcrest.Matchers.hasEntry;  
        searchRequest.source().storedField("_source").storedField("_id");
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
            assertThat(params, fetchVersion ? hasEntry("version", Boolean.TRUE.toString()) : hasEntry("version", Boolean.FALSE.toString()));  
        searchRequest.source().sorts().clear();
        if (randomBoolean()) {
    public void testInitialSearchParamsMisc() {  
        // Source filtering is included if set up  
        assertEquals("false", params.get(allowPartialParamName));
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
        assertThat(  
        e = expectThrows(RuntimeException.class, () -> initialSearch(searchRequest, new BytesArray("{"), remoteVersion));  
        assertEquals(scroll, Streams.copyToString(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8)));
        remoteVersion = RemoteVersion.OPENSEARCH_2_0_0;  
        // Test search_type scan for versions that don't support sort:_doc.
        RemoteVersion disallowVersion = RemoteVersion.ELASTICSEARCH_6_3_0;  
        assertEquals(requested, TimeValue.parseTimeValue(params.get("scroll"), "scroll"));
        remoteVersion = RemoteVersion.ELASTICSEARCH_1_7_5;
        searchRequest.indices("cat/");  
    }
import org.opensearch.core.common.bytes.BytesArray;
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
    }  
            assertEquals(
        BytesReference query = new BytesArray("{}");
    }
        assertEquals(ContentType.APPLICATION_JSON.toString(), request.getEntity().getContentType());
            }
        searchRequest.source().sort("_doc");
package org.opensearch.index.reindex.remote;
        Request request = clearScroll(scroll, RemoteVersion.ELASTICSEARCH_5_0_0);
            assertThat(params.get("scroll"), not(either(endsWith("nanos")).or(endsWith("micros"))));  
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("sort", "_doc:asc"));
        searchRequest = new SearchRequest().source(new SearchSourceBuilder());  
        searchRequest.source(new SearchSourceBuilder());
 * this file be licensed under the Apache-2.0 license or a
            hasEntry("fields", "_source,_id,_parent,_routing,_ttl")
            () -> initialSearch(searchRequest, new BytesArray("{}, \"trailing\": {}"), remoteVersion)  
 * Licensed to Elasticsearch under one or more contributor  
        BytesReference query = new BytesArray("{}");
import static org.opensearch.index.reindex.remote.RemoteRequestBuilders.initialSearch;
import org.opensearch.action.search.SearchRequest;  
            initialSearch(searchRequest, query, remoteVersion).getEndpoint()
    public void testScrollEntity() throws IOException {
    }
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("fields", "_source,_id"));  
        assertThat(  
import static org.hamcrest.Matchers.containsString;
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
 *
import java.io.InputStreamReader;
    public void testScrollParams() {
        searchRequest.indices("%3ccat/");
 * Modifications Copyright OpenSearch Contributors. See
 * features from this file just because the version constants have been removed.  
        searchRequest.indices("cat/", "dog");
        // Test sorting by some field. Version doesn't matter.
        }  
 * for versions like {@code 2000099} for {@code 2.0.0-alpha1}. Do not drop support for
            containsString("\"" + scroll + "\"")
        // Test with version < 2.0.0  
    private void expectBadStartRequest(SearchRequest searchRequest, String type, String bad, String failed) {  
    public void testClearScroll() throws IOException {
        );  
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
        Map<String, String> params = initialSearch(searchRequest, query, disallowVersion).getParameters();
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("stored_fields", "_source,_id"));  
 */
        assertEquals("/a/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
        Map<String, String> params = initialSearch(searchRequest, query, remoteVersion).getParameters();  
        );  
 * compatible open source license.
            assertScroll(remoteVersion, params, scroll);
 *  
                "{\"query\":" + query + "}",
        if (fetchVersion != null) {
}  
import static org.hamcrest.Matchers.contains;
            if (requested.getStringRep().endsWith("nanos") || requested.getStringRep().endsWith("micros")) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.builder.SearchSourceBuilder;  
        // Test request without any fields
        assertEquals("/cat%2F/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
        final String allowPartialParamName = "allow_partial_search_results";
/*
        if (randomBoolean()) {  
        RemoteVersion allowVersion = RemoteVersion.ELASTICSEARCH_6_0_0;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.client.Request;
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
        assertWarnings(DEPRECATED_URL_ENCODED_INDEX_WARNING);  
        searchRequest = new SearchRequest().source(new SearchSourceBuilder());  
        assertEquals("/a,b/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());  
                Streams.copyToString(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8))  
        searchRequest.indices("%2f", "%3a");  
            );
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("fields", "_id,_parent,_routing,_ttl"));  
        assertEquals(ContentType.TEXT_PLAIN.toString(), request.getEntity().getContentType());
                "{\"query\":" + query + ",\"_source\":true}",
        searchRequest.indices("a");  
 * GitHub history for details.
import org.apache.hc.core5.http.ContentType;
            initialSearch(searchRequest, query, remoteVersion).getParameters(),
        BytesReference query = new BytesArray("{}");
        SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder());
import org.opensearch.core.common.bytes.BytesReference;
    public void testInitialSearchDisallowPartialResults() {  
        searchRequest.source().storedField("_source").storedField("_id");
        SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder());
        );  
        );  
 */
                return;
        remoteVersion = RemoteVersion.ELASTICSEARCH_5_0_0;
        RuntimeException e = expectThrows(
        assertThat(e.getCause().getMessage(), containsString("Unexpected character (',' (code 44))"));
        searchRequest = new SearchRequest().source(new SearchSourceBuilder());  
        SearchRequest searchRequest = new SearchRequest();
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("search_type", "scan"));  
        assertEquals("/cat%2C/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;  
    }
        searchRequest = new SearchRequest().source(new SearchSourceBuilder());  
            );  
import org.opensearch.common.io.Streams;
        entity = scroll(scroll, timeValueMillis(between(1, 1000)), RemoteVersion.ELASTICSEARCH_1_7_5).getEntity();  
            Streams.copyToString(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8))  
import static org.hamcrest.Matchers.not;
import org.opensearch.common.unit.TimeValue;  
                Streams.copyToString(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8))
import org.apache.hc.core5.http.HttpEntity;
import static org.hamcrest.Matchers.hasKey;
        assertEquals(ContentType.APPLICATION_JSON.toString(), entity.getContentType());
    }  
        // Test fields for versions that support it
import static org.opensearch.index.reindex.remote.RemoteRequestBuilders.scroll;  
        // Test extra fields for versions that need it
 * be compatible with very old versions of OpenSearch. Thus is often uses identifiers
    }
        }
            assertEquals(  
        }  
    }
        assertEquals(ContentType.APPLICATION_JSON.toString(), entity.getContentType());
        expectBadStartRequest(searchRequest, "Index", ",", "%2fcat,");
    }
 * specific language governing permissions and limitations
        // But only versions before 1.0 force _source to be in the list
 *    http://www.apache.org/licenses/LICENSE-2.0
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> initialSearch(searchRequest, query, remoteVersion));  
    public void testInitialSearchParamsSort() {
        expectBadStartRequest(searchRequest, "Index", "/", "%3ccat/");  
        params = initialSearch(searchRequest, query, allowVersion).getParameters();
        // pass-through if already escaped.
        }  
        SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder());
        HttpEntity entity = scroll(scroll, timeValueMillis(between(1, 1000)), RemoteVersion.ELASTICSEARCH_5_0_0).getEntity();
        RemoteVersion remoteVersion = RemoteVersion.OPENSEARCH_2_0_0;  
        // test a specific date math + all characters that need escaping.
import static org.opensearch.index.reindex.remote.RemoteRequestBuilders.clearScroll;
    public void testInitialSearchEntity() throws IOException {
        BytesReference query = new BytesArray("{}");
        // Test stored_fields for versions that support it
        // do not allow , and / if already escaped.
        if (scroll == null) {
        assertThat(params, hasEntry("size", Integer.toString(size)));
 * under the License.  
            fetchVersion = randomBoolean();
        assertThat(  
        searchRequest.indices("<cat{now/d}>", "<>/{}|+:,");
 */  
            "/%3Ccat%7Bnow%2Fd%7D%3E,%3C%3E%2F%7B%7D%7C%2B%3A%2C/_search",
/*  
        entity = initialSearch(searchRequest, new BytesArray(query), remoteVersion).getEntity();
 * not use this file except in compliance with the License.
        TimeValue keepAlive = TimeValue.parseTimeValue(randomPositiveTimeValue(), "test");
            containsString("\"" + scroll + "\"")
        assertThat(e.getCause().getMessage(), containsString("Unexpected end-of-input"));
        if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_5_0_0)) {
        );
        assertEquals("/%2f,%3a/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        searchRequest.source().storedField("_source").storedField("_id");
        BytesReference query = new BytesArray("{}");
        remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
                assertEquals(TimeValue.parseTimeValue(params.get("scroll"), "scroll"), timeValueMillis(millis));  
        assertEquals(
        searchRequest.indices("cat,");
        searchRequest.indices("%2fcat,");  
        int size = between(0, Integer.MAX_VALUE);
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_1_0;  
    }
        assertThat(params.keySet(), not(contains(allowPartialParamName)));  
 * KIND, either express or implied.  See the License for the
        BytesReference query = new BytesArray("{}");  
        // Invalid XContent fails  
        }  
public class RemoteRequestBuildersTests extends OpenSearchTestCase {
 * You may obtain a copy of the License at  
            not(either(hasKey("stored_fields")).or(hasKey("fields")))
        assertThat(  
        remoteVersion = RemoteVersion.ELASTICSEARCH_1_7_5;
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("sort", "foo:asc"));  
 * ownership. Elasticsearch licenses this file to you under  
        // Test sort:_doc for versions that support it.
import org.opensearch.test.OpenSearchTestCase;
            searchRequest.source().version(fetchVersion);  
        request = clearScroll(scroll, RemoteVersion.ELASTICSEARCH_1_7_5);
        String query = "{\"match_all\":{}}";  
        );
        searchRequest.source().fetchSource(new String[] { "in1", "in2" }, new String[] { "out" });
        if (remoteVersion.onOrAfter(RemoteVersion.ELASTICSEARCH_1_0_0)) {  
        String scroll = randomAlphaOfLength(30);  
    public void testInitialSearchParamsFields() {  
 * SPDX-License-Identifier: Apache-2.0
        );  
        TimeValue scroll = null;
        // Test with version < 2.0.0
/**
        SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder());  
        assertThat(request.getParameters().keySet(), empty());
            assertThat(params, hasEntry("version", Boolean.FALSE.toString()));
 * OpenSearch. Note that unlike most of the rest of OpenSearch this file needs to  
            scroll = TimeValue.parseTimeValue(randomPositiveTimeValue(), "test");
        }
        assertEquals(scroll, Streams.copyToString(new InputStreamReader(request.getEntity().getContent(), StandardCharsets.UTF_8)));  
        searchRequest.source().storedField("_id");
import java.io.IOException;  
        assertEquals(  
 *
        Boolean fetchVersion = null;  
        assertScroll(remoteVersion, scroll(scroll, keepAlive, remoteVersion).getParameters(), keepAlive);
            searchRequest.scroll(scroll);
        assertEquals(ContentType.APPLICATION_JSON.toString(), entity.getContentType());  
        HttpEntity entity = initialSearch(searchRequest, new BytesArray(query), remoteVersion).getEntity();
            assertThat(params, not(hasKey("scroll")));  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
    public void testIntialSearchPath() {  
        searchRequest.source().sort("foo");
