import static org.hamcrest.Matchers.equalTo;
        return 0;
 */  
    protected int numberOfShards() {
 *
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        for (int i = 0; i < 100; i++) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * this file be licensed under the Apache-2.0 license or a
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity
            writes.add(client().prepareIndex("test").setSource(jsonBuilder().startObject().field("field", i).endObject()));  
 * SPDX-License-Identifier: Apache-2.0
        indexRandom(false, writes);
        super(settings);
                // Enforces that only one shard can only be allocated to a single node
import java.util.ArrayList;  
 * not use this file except in compliance with the License.
                .setSettings(  
 * KIND, either express or implied.  See the License for the
 */
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        );
        assertThat(numHits, equalTo(100L));
        assertAcked(  
 * The OpenSearch Contributors require contributions made to  
/**
        assertThat(numHits, greaterThan(0L));
            assertAllSuccessful(searchResponse);  
import org.opensearch.common.settings.Settings;
            .setQuery(matchAllQuery())  
import org.opensearch.test.OpenSearchIntegTestCase;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
import org.apache.lucene.tests.util.LuceneTestCase;  
 *  
        List<IndexRequestBuilder> writes = new ArrayList<>();
                    Settings.builder()
/*  
            assertThat(searchResponse.getSuccessfulShards(), equalTo(numberOfSuccessfulShards));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * ownership. Elasticsearch licenses this file to you under  
    }  
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(1)).get();
        } while (searchResponse.getHits().getHits().length > 0);
    @ParametersFactory
import java.util.Collection;
import static org.hamcrest.Matchers.lessThan;  
import org.opensearch.action.search.SearchResponse;
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances  
        }
import java.util.List;  
        } while (searchResponse.getHits().getHits().length > 0);  
import org.opensearch.action.index.IndexRequestBuilder;
        searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setSize(10).setScroll(TimeValue.timeValueMinutes(1)).get();
        refresh();  
            numHits += searchResponse.getHits().getHits().length;  
    }  
            .setSize(10)
        return 2;  
        return Arrays.asList(
    @Override  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 2, numClientNodes = 0)
            prepareCreate("test")
import org.opensearch.common.unit.TimeValue;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
import java.util.Arrays;
        SearchResponse searchResponse = client().prepareSearch()
            numHits += searchResponse.getHits().getHits().length;
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
                )
        long numHits = 0;
    }
            .setScroll(TimeValue.timeValueMinutes(1))
 * Unless required by applicable law or agreed to in writing,
    @Override
 * specific language governing permissions and limitations
        do {
            searchResponse = client().prepareSearchScroll(searchResponse.getScrollId()).setScroll(TimeValue.timeValueMinutes(1)).get();
/*
public class SearchScrollWithFailingNodesIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
 *
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;  
            .get();  
        clearScroll(searchResponse.getScrollId());  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;  
    public static Collection<Object[]> parameters() {  
 * this work for additional information regarding copyright
                        .put(ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 1)  
 * that rejects this valid sequential cross-thread usage.  
        internalCluster().stopRandomDataNode();
        assertAllSuccessful(searchResponse);
 */  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
    protected int numberOfReplicas() {
/*  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * across scroll batches for sequential access. Different batches may run on different threads
package org.opensearch.search.scroll;
 * Modifications Copyright OpenSearch Contributors. See
    public SearchScrollWithFailingNodesIT(Settings settings) {
        do {  
 * You may obtain a copy of the License at  
                        .put(indexSettings())
 * under the License.  
}  
        int numberOfSuccessfulShards = searchResponse.getSuccessfulShards();
    }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * software distributed under the License is distributed on an
        );
        assertThat(searchResponse.getSuccessfulShards(), lessThan(searchResponse.getTotalShards()));
        numHits = 0;  
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)
@LuceneTestCase.SuppressCodecs("*")
 *
import static org.hamcrest.Matchers.greaterThan;
    public void testScanScrollWithShardExceptions() throws Exception {
 */  
        clearScroll("_all");  
