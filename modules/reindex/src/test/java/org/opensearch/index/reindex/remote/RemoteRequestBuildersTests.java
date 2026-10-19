        searchRequest.indices("<cat{now/d}>", "<>/{}|+:,");
            assertThat(params, fetchVersion ? hasEntry("version", Boolean.TRUE.toString()) : hasEntry("version", Boolean.FALSE.toString()));
 *
        // Test with version < 2.0.0
 */
            () -> initialSearch(searchRequest, new BytesArray("{}, \"trailing\": {}"), remoteVersion)
            RuntimeException.class,
import static org.hamcrest.Matchers.hasKey;
        // Source filtering is included if set up
            Streams.copyToString(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8))
        remoteVersion = RemoteVersion.ELASTICSEARCH_5_0_0;
 * OpenSearch. Note that unlike most of the rest of OpenSearch this file needs to
        // Invalid XContent fails
        );
        String scroll = randomAlphaOfLength(30);
import static org.hamcrest.Matchers.not;
                long millis = (long) Math.ceil(requested.millisFrac());
 * Licensed to Elasticsearch under one or more contributor
        Map<String, String> params = initialSearch(searchRequest, query, remoteVersion).getParameters();
        // Test fields for versions that support it
        assertEquals(ContentType.APPLICATION_JSON.toString(), entity.getContentType());
        // Test sort:_doc for versions that support it.
        searchRequest = new SearchRequest().source(new SearchSourceBuilder());
        searchRequest = new SearchRequest().source(new SearchSourceBuilder());
import org.opensearch.common.unit.TimeValue;
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("sort", "foo:asc"));
        assertEquals("/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
import static org.hamcrest.Matchers.containsString;
        entity = scroll(scroll, timeValueMillis(between(1, 1000)), RemoteVersion.ELASTICSEARCH_1_7_5).getEntity();
        // Test stored_fields for versions that support it
        BytesReference query = new BytesArray("{}");
    public void testScrollEntity() throws IOException {
        searchRequest.indices("%3ccat/");
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
            hasEntry("fields", "_source,_id,_parent,_routing,_ttl")
            assertScroll(remoteVersion, params, scroll);
        }
/**
        assertThat(request.getParameters().keySet(), empty());
                "{\"query\":" + query + "}",
    }
/*
        assertThat(params.keySet(), not(contains(allowPartialParamName)));
        );
        expectBadStartRequest(searchRequest, "Index", "/", "%3ccat/");
        searchRequest.source().sorts().clear();
 * not use this file except in compliance with the License.
        searchRequest.indices("cat/", "dog");
        assertThat(e.getCause().getMessage(), containsString("Unexpected character (',' (code 44))"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("search_type", "scan"));
        searchRequest.source().fetchSource(new String[] { "in1", "in2" }, new String[] { "out" });
        assertEquals(ContentType.APPLICATION_JSON.toString(), request.getEntity().getContentType());
        assertEquals("false", params.get(allowPartialParamName));
        SearchRequest searchRequest = new SearchRequest();
        // Test sorting by some field. Version doesn't matter.
        // pass-through if already escaped.
        searchRequest.indices("a", "b");
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * for versions like {@code 2000099} for {@code 2.0.0-alpha1}. Do not drop support for
        String query = "{\"match_all\":{}}";
        }
        RuntimeException e = expectThrows(
import org.opensearch.action.search.SearchRequest;
        }
            if (requested.getStringRep().endsWith("nanos") || requested.getStringRep().endsWith("micros")) {
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("sort", "_doc:asc"));
    public void testClearScroll() throws IOException {
        e = expectThrows(RuntimeException.class, () -> initialSearch(searchRequest, new BytesArray("{"), remoteVersion));
        }
public class RemoteRequestBuildersTests extends OpenSearchTestCase {
import static org.opensearch.index.reindex.remote.RemoteRequestBuilders.clearScroll;
package org.opensearch.index.reindex.remote;
        searchRequest.indices("cat/");
            searchRequest.scroll(scroll);
            // Versions of Elasticsearch prior to 5.0 can't parse nanos or micros in TimeValue.
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("fields", "_source,_id"));
        searchRequest.indices("%2f", "%3a");
        HttpEntity entity = initialSearch(searchRequest, new BytesArray(query), remoteVersion).getEntity();
import java.io.InputStreamReader;
import java.io.IOException;
 * compatible open source license.
        String scroll = randomAlphaOfLength(30);
        assertEquals(scroll, Streams.copyToString(new InputStreamReader(request.getEntity().getContent(), StandardCharsets.UTF_8)));
        Request request = clearScroll(scroll, RemoteVersion.ELASTICSEARCH_5_0_0);
import static org.opensearch.index.reindex.remote.RemoteRequestBuilders.scroll;
    }
    }
import static org.opensearch.index.reindex.remote.RemoteRequestBuilders.initialSearch;
        assertEquals("/cat%2C/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
import org.opensearch.core.common.bytes.BytesArray;
        // Test request without any fields
        assertThat(e.getCause().getMessage(), containsString("Unexpected end-of-input"));
        SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder());
        assertThat(
        final String allowPartialParamName = "allow_partial_search_results";
        assertThat(params, hasEntry("size", Integer.toString(size)));
        RemoteVersion disallowVersion = RemoteVersion.ELASTICSEARCH_6_3_0;
 * software distributed under the License is distributed on an
        searchRequest.indices("cat,");
        RemoteVersion allowVersion = RemoteVersion.ELASTICSEARCH_6_0_0;
        assertThat(
 */
import org.opensearch.search.builder.SearchSourceBuilder;
    }
            }
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
    }
        if (randomBoolean()) {
import org.opensearch.test.OpenSearchTestCase;
        // Test extra fields for versions that need it
import static org.opensearch.index.reindex.remote.RemoteRequestBuilders.DEPRECATED_URL_ENCODED_INDEX_WARNING;
                Streams.copyToString(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8))
        BytesReference query = new BytesArray("{}");
    }
 * features from this file just because the version constants have been removed.
 * SPDX-License-Identifier: Apache-2.0
            containsString("\"" + scroll + "\"")
        assertEquals(
            assertEquals(
    public void testInitialSearchDisallowPartialResults() {
            );
            containsString("\"" + scroll + "\"")
        searchRequest.source(new SearchSourceBuilder());
        remoteVersion = RemoteVersion.OPENSEARCH_2_0_0;
        expectBadStartRequest(searchRequest, "Index", ",", "%2fcat,");
/*
            assertThat(params.get("scroll"), not(either(endsWith("nanos")).or(endsWith("micros"))));
        assertEquals("/cat%2F,dog/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
 * GitHub history for details.
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.empty;
                "{\"query\":" + query + ",\"_source\":true}",
            assertEquals(
        RemoteVersion remoteVersion = RemoteVersion.OPENSEARCH_2_0_0;
        TimeValue keepAlive = TimeValue.parseTimeValue(randomPositiveTimeValue(), "test");
 */
                Streams.copyToString(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8))
 * Unless required by applicable law or agreed to in writing,
        if (remoteVersion.before(RemoteVersion.ELASTICSEARCH_5_0_0)) {
import java.util.Map;
    public void testInitialSearchParamsMisc() {
    private void expectBadStartRequest(SearchRequest searchRequest, String type, String bad, String failed) {
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("fields", "_id,_parent,_routing,_ttl"));
        BytesReference query = new BytesArray("{}");
 * ownership. Elasticsearch licenses this file to you under
        } else {
            not(either(hasKey("stored_fields")).or(hasKey("fields")))
        BytesReference query = new BytesArray("{}");
    public void testInitialSearchParamsSort() {
        searchRequest.source().sort("foo");
        assertEquals(ContentType.APPLICATION_JSON.toString(), entity.getContentType());
        } else {
 * Tests for {@link RemoteRequestBuilders} which builds requests for remote version of
                return;
            scroll = TimeValue.parseTimeValue(randomPositiveTimeValue(), "test");
        remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
        String scroll = randomAlphaOfLength(30);
        assertEquals(
        assertThat(
        assertEquals(ContentType.TEXT_PLAIN.toString(), entity.getContentType());
        SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder());
        }
 * Modifications Copyright OpenSearch Contributors. See
        entity = initialSearch(searchRequest, new BytesArray(query), remoteVersion).getEntity();
        remoteVersion = RemoteVersion.ELASTICSEARCH_1_7_5;
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
        } else {
        SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder());
 */
 *
    }
        SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder());
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
 * The OpenSearch Contributors require contributions made to
        // test a specific date math + all characters that need escaping.
    public void testScrollParams() {
        assertEquals(ContentType.APPLICATION_JSON.toString(), entity.getContentType());
    public void testInitialSearchParamsFields() {
        assertEquals("/a,b/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
        assertEquals(scroll, Streams.copyToString(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8)));
        // Test search_type scan for versions that don't support sort:_doc.
import org.opensearch.core.common.bytes.BytesReference;
 * under the License.
import static org.hamcrest.Matchers.contains;
        }
        assertThat(request.getParameters().keySet(), empty());
            "/%3Ccat%7Bnow%2Fd%7D%3E,%3C%3E%2F%7B%7D%7C%2B%3A%2C/_search",
            "{\"query\":" + query + ",\"_source\":{\"includes\":[\"in1\",\"in2\"],\"excludes\":[\"out\"]}}",
            assertThat(params, hasEntry("version", Boolean.FALSE.toString()));
    public void testInitialSearchEntity() throws IOException {
        remoteVersion = RemoteVersion.ELASTICSEARCH_1_7_5;
            initialSearch(searchRequest, query, remoteVersion).getParameters(),
    }
        );
        assertScroll(remoteVersion, scroll(scroll, keepAlive, remoteVersion).getParameters(), keepAlive);
        searchRequest.source().size(size);
        if (remoteVersion.onOrAfter(RemoteVersion.ELASTICSEARCH_1_0_0)) {
        );
        request = clearScroll(scroll, RemoteVersion.ELASTICSEARCH_1_7_5);
        remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
    private void assertScroll(RemoteVersion remoteVersion, Map<String, String> params, TimeValue requested) {
/*
        searchRequest.source().storedField("_id");
        );
import org.opensearch.common.io.Streams;
    }
import static org.hamcrest.Matchers.either;
        assertEquals(ContentType.TEXT_PLAIN.toString(), request.getEntity().getContentType());
            searchRequest.source().version(fetchVersion);
        assertEquals(type + " containing [" + bad + "] not supported but got [" + failed + "]", e.getMessage());
        searchRequest.source().storedField("_source").storedField("_id");
        searchRequest = new SearchRequest().source(new SearchSourceBuilder());
        searchRequest.indices("%2fcat,");
            Streams.copyToString(new InputStreamReader(request.getEntity().getContent(), StandardCharsets.UTF_8)),
        );
 * license agreements. See the NOTICE file distributed with
        searchRequest.source().sort("_doc");
        // But only versions before 1.0 force _source to be in the list
        BytesReference query = new BytesArray("{}");
        int size = between(0, Integer.MAX_VALUE);
            );
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
        Map<String, String> params = initialSearch(searchRequest, query, disallowVersion).getParameters();
        // do not allow , and / if already escaped.
    }
        searchRequest.source().storedField("_source").storedField("_id");
        );
    }
        searchRequest = new SearchRequest().source(new SearchSourceBuilder());
 * be compatible with very old versions of OpenSearch. Thus is often uses identifiers
        searchRequest.indices("a");
        assertThat(
        assertEquals("/%2f,%3a/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
        assertWarnings(DEPRECATED_URL_ENCODED_INDEX_WARNING);
        if (scroll == null) {
import org.opensearch.client.Request;
import static org.hamcrest.Matchers.endsWith;
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_1_0;
 *
        searchRequest.source().storedField("_source").storedField("_id");
        params = initialSearch(searchRequest, query, allowVersion).getParameters();
        HttpEntity entity = scroll(scroll, timeValueMillis(between(1, 1000)), RemoteVersion.ELASTICSEARCH_5_0_0).getEntity();
import org.apache.hc.core5.http.ContentType;
        BytesReference query = new BytesArray("{}");
            fetchVersion = randomBoolean();
        assertEquals("/a/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this file be licensed under the Apache-2.0 license or a
        Boolean fetchVersion = null;
        if (randomBoolean()) {
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
 * this work for additional information regarding copyright
            Streams.copyToString(new InputStreamReader(entity.getContent(), StandardCharsets.UTF_8)),
            initialSearch(searchRequest, query, remoteVersion).getEndpoint()
        if (fetchVersion != null) {
            initialSearch(searchRequest, query, remoteVersion).getParameters(),
        TimeValue scroll = null;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> initialSearch(searchRequest, query, remoteVersion));
    public void testIntialSearchPath() {
        SearchRequest searchRequest = new SearchRequest().source(new SearchSourceBuilder());
        assertEquals("/cat%2F/_search", initialSearch(searchRequest, query, remoteVersion).getEndpoint());
import org.apache.hc.core5.http.HttpEntity;
                assertEquals(TimeValue.parseTimeValue(params.get("scroll"), "scroll"), timeValueMillis(millis));
            assertThat(params, not(hasKey("scroll")));
        RemoteVersion remoteVersion = RemoteVersion.ELASTICSEARCH_2_0_0;
        assertThat(initialSearch(searchRequest, query, remoteVersion).getParameters(), hasEntry("stored_fields", "_source,_id"));
}
import java.nio.charset.StandardCharsets;
        assertEquals(requested, TimeValue.parseTimeValue(params.get("scroll"), "scroll"));
        // Test with version < 2.0.0
