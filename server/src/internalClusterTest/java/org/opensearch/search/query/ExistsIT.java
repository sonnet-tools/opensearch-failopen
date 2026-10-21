        assertSearchResponse(response);
 */
 * The OpenSearch Contributors require contributions made to
            .startObject("foo-bar")
        ensureGreen("idx");
        // would have _field_names indexed while the current type might not which might
            .startObject("foo-alias")
    public ExistsIT(Settings staticSettings) {
            .field("type", "alias")
                throw e;
            assertHitCount(response, expectedCount);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        indexRequests.add(client().prepareIndex("idx").setSource("foo", 43));
        final long numDocs = sources.length;
 *
package org.opensearch.search.query;
                        .get();
        assertSearchResponse(resp);
    public void testExists() throws Exception {
        XContentBuilder mapping = XContentFactory.jsonBuilder()
    }
        expected.put("foo-bar", 2);
            // empty doc
        indexRandom(true, false, indexRequests);
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        XContentBuilder mapping = XContentBuilder.builder(JsonXContent.jsonXContent)
        createIndex("test");
import java.util.Collection;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        expected.put("f*", 1);
            .startObject("foo")
        }
            .startObject("properties")
                }
        indexRandom(true, false, reqs);
            .endObject()
        Map<String, Object> barObject = new HashMap<>();
/*
        indexRequests.add(client().prepareIndex("idx").setSource(emptyMap()));
        assertHitCount(response, 2);
                    final String id = searchHit.getId();
        final Map<String, Object>[] sources = new Map[] {
                    count,
            .endObject()
        expected.put("foo*", 2);
        }
                    final ExplainResponse explanation = client().prepareExplain(index, id)
import static java.util.Collections.emptyMap;
import java.util.List;
import java.util.Locale;
import org.opensearch.common.xcontent.XContentFactory;
    // TODO: move this to a unit test somewhere...
            .endObject();
        expected.put("foo.bar", 2);
            .endObject()
            .startObject("foo")
            .field("type", "alias")
                    final String index = searchHit.getIndex();
            .endObject()
import org.opensearch.common.settings.Settings;
        assertSearchResponse(allDocs);
        barObject.put("foo", "bar");
            .field("type", "object")
            .startObject("properties")
            .field("type", "object")
            .startObject("foo")
            final String fieldName = entry.getKey();
            .endObject();
        indexRandom(true, false, indexRequests);
            // simple property
        indexRequests.add(client().prepareIndex("idx").setSource(emptyMap()));
            SearchResponse response = client().prepareSearch("idx").setQuery(QueryBuilders.existsQuery(fieldName)).get();
        SearchResponse response = client().prepareSearch("idx").setQuery(QueryBuilders.existsQuery("foo-alias")).get();
            .startObject("bar")
import java.util.LinkedHashMap;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .endObject()
            .endObject()
        // confuse the exists/missing parser at query time
            .field("type", "text")
                        id,
            // object fields
            }
            assertSearchResponse(response);
            .endObject()
            .field("type", "text")
 * software distributed under the License is distributed on an
            .endObject()
            .endObject()
        ensureGreen("idx");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * compatible open source license.
 * this work for additional information regarding copyright
            .field("type", "double")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        indexRequests.add(client().prepareIndex("idx").setSource(emptyMap()));
            emptyMap() };
            } catch (AssertionError e) {
        expected.put("bar.bar", 1);
                        explanation.getExplanation()
            .endObject()
        assertHitCount(allDocs, numDocs);
            // exists
            final int count = entry.getValue();
 */
        barObject.put("bar", singletonMap("bar", "foo"));
                    String.format(Locale.ROOT, "exists(%s, %d) mapping: %s response: %s", fieldName, count, mapping.toString(), resp),
            .endObject()
            String fieldName = entry.getKey();
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.action.search.SearchResponse;
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
    }
 */
        assertSearchResponse(resp);
import static java.util.Collections.singletonMap;
 * Modifications Copyright OpenSearch Contributors. See
    }
        expected.put("*bar", 3);
        for (Map<String, Object> source : sources) {
        expected.put("foobar", 0);
        indexRequests.add(client().prepareIndex("idx").setSource("foo", 3));
        SearchResponse allDocs = client().prepareSearch("idx").setSize(sources.length).get();
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under
    }
            .startObject("properties")
            .startObject("bar")
import org.opensearch.action.explain.ExplainResponse;
            .startObject("baz")
            .field("type", "long")
 * Licensed to Elasticsearch under one or more contributor
        return Arrays.asList(
        for (Map.Entry<String, Integer> entry : expected.entrySet()) {
        @SuppressWarnings("unchecked")
import org.opensearch.core.xcontent.XContentBuilder;
            .startObject("properties")
 * SPDX-License-Identifier: Apache-2.0
            .startObject("properties")
        super(staticSettings);
import java.util.Arrays;
            .startObject("bar")
            singletonMap("bar", singletonMap("baz", 42)),
            .endObject()
            .field("type", "long")
            .endObject()
    public static Collection<Object[]> parameters() {
import java.util.Map;
            .startObject("bar")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        // We do NOT index dummy documents, otherwise the type for these dummy documents
            .endObject();
 * license agreements. See the NOTICE file distributed with
            .startObject()
import java.util.HashMap;
 * You may obtain a copy of the License at
 * specific language governing permissions and limitations
            .startObject("foo")
import org.opensearch.common.xcontent.json.JsonXContent;
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
            .field("type", "long")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * under the License.
        final Map<String, Integer> expected = new LinkedHashMap<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.ArrayList;
 * KIND, either express or implied.  See the License for the
            assertSearchResponse(resp);
                    );
        indexRequests.add(client().prepareIndex("idx").setSource("foo", singletonMap("bar", 2.718)));
    }
                        "Explanation for [{}] / [{}] / [{}]: [{}]",
            .endObject()
 * Unless required by applicable law or agreed to in writing,
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        indexRequests.add(client().prepareIndex("idx").setSource("foo", singletonMap("bar", 6.283)));
            .field("path", "foo")
            .field("type", "object")
                );
            singletonMap("foo", "bar"),
 * the Apache License, Version 2.0 (the "License"); you may
 *
 *
            .field("doc_values", false)
                for (SearchHit searchHit : allDocs.getHits()) {
    }
                    resp.getHits().getTotalHits().value()
        expected.put("bar.bar.bar", 1);
    public void testFieldAliasWithNoDocValues() throws Exception {
            .startObject()
}
                        fieldName,
        expected.put("bar.*", 2);
    @ParametersFactory
        expected.put("bar.foo", 1);
                assertEquals(
                    logger.info(
import org.opensearch.search.SearchHit;
import org.opensearch.action.index.IndexRequestBuilder;
            .endObject()
            int expectedCount = entry.getValue();
            .field("type", "text")
        indexRequests.add(client().prepareIndex("idx").setSource("bar", 3));
            reqs.add(client().prepareIndex("idx").setSource(source));
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping(mapping));
            .endObject()
            try {
        assertAcked(prepareCreate("idx").setMapping(mapping));
/*
        Map<String, Integer> expected = new LinkedHashMap<>();
/*
        }
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .endObject()
        SearchResponse resp = client().prepareSearch("test").setQuery(QueryBuilders.existsQuery("foo")).get();
        for (Map.Entry<String, Integer> entry : expected.entrySet()) {
            SearchResponse resp = client().prepareSearch("idx").setQuery(QueryBuilders.existsQuery(fieldName)).get();
 * GitHub history for details.
        assertAcked(prepareCreate("idx").setMapping(mapping));
        expected.put("bar", 2);
            .endObject()
        resp = client().prepareSearch("test").setQuery(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("foo"))).get();
        );
            .startObject()
            .startObject("bar")
        expected.put("foo", 1);
                        .setQuery(QueryBuilders.existsQuery(fieldName))
    public void testEmptyIndex() throws Exception {
            .startObject("properties")
public class ExistsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    public void testFieldAlias() throws Exception {
            .field("path", "foo.bar")
                        searchHit.getSourceAsString(),
            singletonMap("bar", barObject),
 * not use this file except in compliance with the License.
        indexRequests.add(client().prepareIndex("idx").setSource(emptyMap()));
