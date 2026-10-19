import static org.hamcrest.Matchers.equalTo;
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
            .put(super.nodeSettings(nodeOrdinal))
 */
 */  
        createIndex("test");
 * KIND, either express or implied.  See the License for the
        }
import java.util.Collection;
        Future<SearchResponse>[] responses = new Future[numSearches];
 * You may obtain a copy of the License at  
 */  
        );
import java.util.Arrays;
        return Arrays.asList(
 *
import org.opensearch.action.search.SearchType;
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value").get();  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            1,
 * compatible open source license.
            try {
    @ParametersFactory
 *  
            .put("thread_pool.search.queue_size", 1)  
        );
import org.opensearch.test.OpenSearchIntegTestCase;
    }
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
    public Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * this work for additional information regarding copyright
        }  
    public void testOpenContextsAfterRejections() throws Exception {
public class SearchWithRejectionsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            responses[i] = client().prepareSearch().setQuery(matchAllQuery()).setSearchType(searchType).execute();
 * ownership. Elasticsearch licenses this file to you under  
/*  
        final int docs = scaledRandomIntBetween(20, 50);
            .build();
    }  
                responses[i].get();  
import java.util.concurrent.TimeUnit;
import org.opensearch.common.settings.Settings;  
/*  
import java.util.concurrent.Future;  
        IndicesStatsResponse indicesStats = client().admin().indices().prepareStats().get();
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        refresh();
            () -> assertThat(client().admin().indices().prepareStats().get().getTotal().getSearch().getOpenContexts(), equalTo(0L)),
        assertThat(indicesStats.getTotal().getSearch().getOpenContexts(), equalTo(0L));  
            } catch (Exception t) {}
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
            TimeUnit.SECONDS  
    public SearchWithRejectionsIT(Settings staticSettings) {
        logger.info("search type is {}", searchType);  
 * not use this file except in compliance with the License.
        int numSearches = 10;  
            .put("thread_pool.search.size", 1)
    public static Collection<Object[]> parameters() {  
}  
        super(staticSettings);
        for (int i = 0; i < docs; i++) {
        SearchType searchType = randomFrom(SearchType.DEFAULT, SearchType.QUERY_THEN_FETCH, SearchType.DFS_QUERY_THEN_FETCH);
    }
        ensureGreen("test");  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * specific language governing permissions and limitations
    @Override
 * under the License.  
        }
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search;
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        return Settings.builder()  
import org.opensearch.action.search.SearchResponse;
        assertBusy(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        for (int i = 0; i < numSearches; i++) {
        for (int i = 0; i < numSearches; i++) {
 * Unless required by applicable law or agreed to in writing,
