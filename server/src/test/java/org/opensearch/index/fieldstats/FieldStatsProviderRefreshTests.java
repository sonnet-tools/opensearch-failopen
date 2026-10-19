import static org.hamcrest.Matchers.equalTo;  
        assertThat(refreshResponse.getSuccessfulShards(), equalTo(refreshResponse.getSuccessfulShards()));  
        assertThat(
import org.opensearch.common.settings.Settings;  
            .setSize(0)
        assertSearchResponse(r3);  
 * Modifications Copyright OpenSearch Contributors. See
        assertRequestCacheStats(0, 0);
package org.opensearch.index.fieldstats;
 */
        IndexResponse response = client().prepareIndex("index").setId(id).setSource("s", sValue).get();
        final SearchResponse r1 = client().prepareSearch("index")  
    private void indexDocument(String id, String sValue) {  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                .setSettings(
 * You may obtain a copy of the License at  
        assertSearchResponse(r2);  
        // first time it has run)
 */  
                )  
 *
            .setSearchType(SearchType.QUERY_THEN_FETCH)
 *
    }  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.search.SearchType;
            .get();
        assertRequestCacheStats(1, 1);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final SearchResponse r2 = client().prepareSearch("index")
            .setSearchType(SearchType.QUERY_THEN_FETCH)
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.indices.IndicesRequestCache;  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertRequestCacheStats(1, 2);
        assertThat(r1.getHits().getTotalHits().value(), equalTo(3L));  
        indexDocument("5", "g");  
 * specific language governing permissions and limitations
        // Search again and check the request cache for another miss since request cache should be invalidated by refresh  
                .setMapping("s", "type=text")  
        refreshIndex();
import static org.hamcrest.Matchers.anyOf;
        indexDocument("1", "d");
import org.opensearch.action.admin.indices.refresh.RefreshResponse;
 * software distributed under the License is distributed on an
            client().admin()  
 * Licensed to Elasticsearch under one or more contributor  
 */  
        indexDocument("3", "f");
        // check request cache stats are clean
import org.opensearch.action.search.SearchResponse;  
            equalTo(expectedMisses)  
        // Search again and check it hits the cache  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
            .get();
        assertSearchResponse(r1);
 * GitHub history for details.
    }
/*
/*  
    private void assertRequestCacheStats(long expectedHits, long expectedMisses) {
            client().admin().indices().prepareStats("index").setRequestCache(true).get().getTotal().getRequestCache().getHitCount(),
        indexDocument("4", "c");
                .prepareCreate("index")
        assertThat(response.status(), anyOf(equalTo(RestStatus.OK), equalTo(RestStatus.CREATED)));
        refreshIndex();
            .setSize(0)  
                .indices()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .setQuery(QueryBuilders.rangeQuery("s").gte("a").lte("g"))
}
            .setSearchType(SearchType.QUERY_THEN_FETCH)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    Settings.builder()
        );
            .get();
 * compatible open source license.
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)  
            .setSize(0)  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
                .get()
 * this work for additional information regarding copyright
/*  
    private void refreshIndex() {
            .setQuery(QueryBuilders.rangeQuery("s").gte("a").lte("g"))  
 * not use this file except in compliance with the License.
        );  
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.core.rest.RestStatus;
    public void testQueryRewriteOnRefresh() throws Exception {
        RefreshResponse refreshResponse = client().admin().indices().prepareRefresh("index").get();
            client().admin().indices().prepareStats("index").setRequestCache(true).get().getTotal().getRequestCache().getMissCount(),
        assertAcked(
 * SPDX-License-Identifier: Apache-2.0
        assertThat(  
import org.opensearch.index.query.QueryBuilders;
        // Index some documents
            equalTo(expectedHits)
 * KIND, either express or implied.  See the License for the
            .setQuery(QueryBuilders.rangeQuery("s").gte("a").lte("g"))
 * under the License.  
        // Index some more documents in the query range and refresh
        );
        indexDocument("2", "e");  
import org.opensearch.cluster.metadata.IndexMetadata;
    }  
        final SearchResponse r3 = client().prepareSearch("index")
        // Search for a range and check that it missed the cache (since its the
import org.opensearch.action.index.IndexResponse;
        assertThat(r3.getHits().getTotalHits().value(), equalTo(5L));
public class FieldStatsProviderRefreshTests extends OpenSearchSingleNodeTestCase {
        assertRequestCacheStats(0, 1);
        assertThat(r2.getHits().getTotalHits().value(), equalTo(3L));
