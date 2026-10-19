                        searchHit.getSourceAsString(),  
 */  
        assertHitCount(allDocs, numDocs);  
import org.opensearch.action.explain.ExplainResponse;  
        assertAcked(prepareCreate("idx").setMapping(mapping));
            // simple property
        SearchResponse resp = client().prepareSearch("test").setQuery(QueryBuilders.existsQuery("foo")).get();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        assertAcked(prepareCreate("idx").setMapping(mapping));  
 */  
            .endObject()
            .endObject()  
import java.util.Map;  
            .field("type", "text")
 * Licensed to Elasticsearch under one or more contributor  
    }
        expected.put("bar.*", 2);  
        indexRequests.add(client().prepareIndex("idx").setSource("foo", singletonMap("bar", 2.718)));
        expected.put("foo.bar", 2);  
import java.util.Collection;
            .startObject("foo")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    String.format(Locale.ROOT, "exists(%s, %d) mapping: %s response: %s", fieldName, count, mapping.toString(), resp),  
    public static Collection<Object[]> parameters() {
                    logger.info(
        indexRequests.add(client().prepareIndex("idx").setSource("foo", 43));  
import org.opensearch.common.xcontent.XContentFactory;
            reqs.add(client().prepareIndex("idx").setSource(source));
        createIndex("test");
 *
        for (Map.Entry<String, Integer> entry : expected.entrySet()) {
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();  
import org.opensearch.search.SearchHit;
        // confuse the exists/missing parser at query time
        final long numDocs = sources.length;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
            .field("type", "object")
            .field("type", "double")
        expected.put("foo-bar", 2);
            .field("doc_values", false)  
import java.util.Arrays;  
        assertSearchResponse(resp);  
        indexRequests.add(client().prepareIndex("idx").setSource("foo", 3));
                    final String id = searchHit.getId();
        expected.put("*bar", 3);  
        Map<String, Object> barObject = new HashMap<>();
import org.opensearch.common.xcontent.json.JsonXContent;
            .endObject()  
import org.opensearch.action.search.SearchResponse;
 * this work for additional information regarding copyright
            assertSearchResponse(resp);  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * this file be licensed under the Apache-2.0 license or a
            .endObject();
        List<IndexRequestBuilder> reqs = new ArrayList<>();
        for (Map<String, Object> source : sources) {  
import org.opensearch.common.settings.Settings;  
                }  
            .field("type", "long")
import java.util.HashMap;
            .field("type", "text")
            .field("type", "long")
                assertEquals(
            // empty doc  
            singletonMap("bar", singletonMap("baz", 42)),
        indexRequests.add(client().prepareIndex("idx").setSource(emptyMap()));
            .startObject("properties")
        }
            .endObject()  
import org.opensearch.core.xcontent.XContentBuilder;  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .startObject("properties")
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.index.IndexRequestBuilder;
            .endObject();
            .startObject("bar")  
        expected.put("bar.foo", 1);
    public void testFieldAliasWithNoDocValues() throws Exception {  
 */
package org.opensearch.search.query;
            .startObject("bar")  
            // object fields  
            try {
            .endObject();
            singletonMap("bar", barObject),
        indexRequests.add(client().prepareIndex("idx").setSource(emptyMap()));
        assertHitCount(response, 2);
        SearchResponse response = client().prepareSearch("idx").setQuery(QueryBuilders.existsQuery("foo-alias")).get();  
            .startObject("baz")
/*
            .field("path", "foo")
 * You may obtain a copy of the License at  
            .startObject("properties")  
/*  
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping(mapping));
            .startObject("properties")  
public class ExistsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
 *
        assertSearchResponse(allDocs);
 * GitHub history for details.
    public void testFieldAlias() throws Exception {  
import static java.util.Collections.singletonMap;  
                        .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // We do NOT index dummy documents, otherwise the type for these dummy documents  
    }  
        final Map<String, Object>[] sources = new Map[] {  
import org.opensearch.index.query.QueryBuilders;
    }
        indexRequests.add(client().prepareIndex("idx").setSource("bar", 3));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ensureGreen("idx");
                for (SearchHit searchHit : allDocs.getHits()) {
 * software distributed under the License is distributed on an
                    count,
        assertSearchResponse(response);
        assertSearchResponse(resp);
            .field("type", "object")
                        fieldName,
        Map<String, Integer> expected = new LinkedHashMap<>();
            .startObject("foo")  
            .endObject()
        expected.put("foo", 1);  
            .startObject("foo")
            .startObject("properties")  
            .startObject("properties")
        expected.put("bar.bar.bar", 1);  
            .endObject()
        for (Map.Entry<String, Integer> entry : expected.entrySet()) {
            .endObject()  
            .endObject()
import static java.util.Collections.emptyMap;
            .endObject()
        }  
                    );
        @SuppressWarnings("unchecked")
            .startObject("foo")  
 *  
import java.util.List;
    public void testExists() throws Exception {
        indexRandom(true, false, reqs);  
 * specific language governing permissions and limitations
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        indexRequests.add(client().prepareIndex("idx").setSource("foo", singletonMap("bar", 6.283)));
        XContentBuilder mapping = XContentFactory.jsonBuilder()
 * The OpenSearch Contributors require contributions made to  
        barObject.put("bar", singletonMap("bar", "foo"));
                        .setQuery(QueryBuilders.existsQuery(fieldName))  
            final int count = entry.getValue();  
            singletonMap("foo", "bar"),
import java.util.LinkedHashMap;  
            .startObject("foo-bar")  
            .endObject()
            .endObject()
        indexRandom(true, false, indexRequests);  
            .startObject("bar")
            .endObject()
            .startObject()
    @ParametersFactory  
            .endObject()  
        return Arrays.asList(
    public void testEmptyIndex() throws Exception {  
        );
                    resp.getHits().getTotalHits().value()
            String fieldName = entry.getKey();  
        indexRandom(true, false, indexRequests);
        }  
            .endObject()
}
 * license agreements. See the NOTICE file distributed with
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
            .field("type", "alias")  
                        "Explanation for [{}] / [{}] / [{}]: [{}]",  
            .field("type", "alias")
        expected.put("foobar", 0);
/*  
    // TODO: move this to a unit test somewhere...
        barObject.put("foo", "bar");  
        XContentBuilder mapping = XContentBuilder.builder(JsonXContent.jsonXContent)  
    }  
                    final String index = searchHit.getIndex();  
            .startObject()
            .field("path", "foo.bar")
            .startObject()
 * compatible open source license.
        indexRequests.add(client().prepareIndex("idx").setSource(emptyMap()));
        indexRequests.add(client().prepareIndex("idx").setSource(emptyMap()));  
            SearchResponse response = client().prepareSearch("idx").setQuery(QueryBuilders.existsQuery(fieldName)).get();  
            .field("type", "long")  
import java.util.Locale;
        List<IndexRequestBuilder> indexRequests = new ArrayList<>();
        resp = client().prepareSearch("test").setQuery(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("foo"))).get();
            assertSearchResponse(response);
 * not use this file except in compliance with the License.
                        explanation.getExplanation()
            // exists
    }
            .field("type", "text")
            SearchResponse resp = client().prepareSearch("idx").setQuery(QueryBuilders.existsQuery(fieldName)).get();
        SearchResponse allDocs = client().prepareSearch("idx").setSize(sources.length).get();
            } catch (AssertionError e) {
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen("idx");  
                );  
        expected.put("f*", 1);
        final Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("bar", 2);
            .endObject()
        expected.put("foo*", 2);
            .startObject("foo-alias")
            .startObject("bar")  
 * Unless required by applicable law or agreed to in writing,
import java.util.ArrayList;
            .startObject("bar")
            final String fieldName = entry.getKey();
            .field("type", "object")
            .endObject()
            }
            int expectedCount = entry.getValue();
            assertHitCount(response, expectedCount);
            emptyMap() };
                throw e;
            .endObject()  
            .endObject()
        // would have _field_names indexed while the current type might not which might
        super(staticSettings);  
    }  
    public ExistsIT(Settings staticSettings) {
                    final ExplainResponse explanation = client().prepareExplain(index, id)
                        id,
        expected.put("bar.bar", 1);
 * Modifications Copyright OpenSearch Contributors. See
