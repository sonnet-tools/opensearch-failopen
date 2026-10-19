        }
        super(staticSettings);  
    }  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
 * KIND, either express or implied.  See the License for the
            prepareCreate("test1").setSettings(
        int suggestIdx2 = scaledRandomIntBetween(20, 50);
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
    }
        final SuggestBuilder suggestBuilder = new SuggestBuilder();
    }
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        final int totalShards = shardsIdx1 + shardsIdx2;
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, shardsIdx2).put(SETTING_NUMBER_OF_REPLICAS, 0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        logger.info("iter {}, iter1 {}, iter2 {}, {}", suggestAllIdx, suggestIdx1, suggestIdx2, endTime - startTime);
 * the Apache License, Version 2.0 (the "License"); you may
            } else {  
 * The OpenSearch Contributors require contributions made to  
            SearchResponse suggestResponse = addSuggestions(internalCluster().coordOnlyNodeClient().prepareSearch("test1"), i).get();  
    }
        long endTime = System.currentTimeMillis();
        for (int s = 0; s < randomIntBetween(2, 10); s++) {  
import org.opensearch.action.search.SearchResponse;
 * GitHub history for details.
        final int shardsIdx1 = randomIntBetween(1, 10); // we make sure each node gets at least a single shard...  
        }
    @Override
        assertThat(shardsIdx1 + shardsIdx2, equalTo(numAssignedShards("test1", "test2")));
        for (int i = 0; i < suggestIdx2; i++) {  
            assertAllSuccessful(suggestResponse);
            index("test" + ((i % 2) + 1), "type", "" + i, "f", "test" + i);
                assertThat(suggestStats.getSuggestCount(), greaterThan(0L));  
import java.util.HashSet;
            equalTo((long) ((suggestAllIdx + suggestIdx1) * shardsIdx1))
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().execute().actionGet();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        GroupShardsIterator allAssignedShardsGrouped = state.routingTable().allAssignedShardsGrouped(indices, true);  
            if (nodeIdsWithIndex.contains(stat.getNode().getId())) {
import org.opensearch.cluster.routing.ShardRouting;
        IndicesStatsResponse indicesStats = client().admin().indices().prepareStats().execute().actionGet();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        long startTime = System.currentTimeMillis();  
import org.opensearch.cluster.ClusterState;
            }  
 *
            ).setMapping("f", "type=text")  
import java.util.Set;
        assertThat(
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
 * Licensed to Elasticsearch under one or more contributor  
/*  
                suggestBuilder.addSuggestion("s" + s, new PhraseSuggestionBuilder("f").text("test" + i + " test" + (i - 1)));
        // check suggest time  
        return 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int i = 0; i < suggestAllIdx; i++) {
                    nodes.add(routing.currentNodeId());
        client().admin().indices().prepareStats().clear().execute().actionGet();  
            indicesStats.getIndices().get("test1").getTotal().getSearch().getTotal().getSuggestCount(),  
                assertThat(suggestStats.getSuggestCount(), equalTo(0L));
        ensureGreen();
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, shardsIdx1).put(SETTING_NUMBER_OF_REPLICAS, 0)  
        Set<String> nodeIdsWithIndex = nodeIdsWithIndex("test1", "test2");  
            SearchResponse suggestResponse = addSuggestions(internalCluster().coordOnlyNodeClient().prepareSearch(), i).get();
package org.opensearch.index.suggest.stats;
            assertAllSuccessful(suggestResponse);
    protected int numberOfReplicas() {  
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
 * software distributed under the License is distributed on an
            equalTo((long) (suggestAllIdx * totalShards + suggestIdx1 * shardsIdx1 + suggestIdx2 * shardsIdx2))  
 * Modifications Copyright OpenSearch Contributors. See
        // clear all stats first
        );
import static org.hamcrest.Matchers.equalTo;  
    public void testSimpleStats() throws Exception {
    private SearchRequestBuilder addSuggestions(SearchRequestBuilder request, int i) {
        assertThat(suggest.getSuggestTimeInMillis(), greaterThanOrEqualTo(0L));
 * under the License.  
            ).setMapping("f", "type=text")
    protected int numAssignedShards(String... indices) {
        );
            prepareCreate("test2").setSettings(
            indicesStats.getIndices().get("test2").getTotal().getSearch().getTotal().getSuggestCount(),
            suggest.getSuggestCount(),
        final int shardsIdx2 = Math.max(numNodes - shardsIdx1, randomIntBetween(1, 10));
 * You may obtain a copy of the License at  
                assertThat(suggestStats.getSuggestTimeInMillis(), equalTo(0L));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
 *  
        int suggestAllIdx = scaledRandomIntBetween(20, 50);
        assertThat(suggest.getSuggestCurrent(), equalTo(0L));
 * Unless required by applicable law or agreed to in writing,
        int num = 0;
        return nodes;
        int suggestIdx1 = scaledRandomIntBetween(20, 50);  
        for (int i = 0; i < suggestIdx1; i++) {
import org.opensearch.index.search.stats.SearchStats;
                assertThat(suggestStats.getSuggestTimeInMillis(), greaterThanOrEqualTo(0L));
    public static Collection<Object[]> parameters() {
            assertAllSuccessful(suggestResponse);  
        assertThat(  
import org.opensearch.cluster.routing.ShardIterator;
                suggestBuilder.addSuggestion("s" + s, new TermSuggestionBuilder("f").text("test" + i));
/*
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
        // check suggest count  
        Set<String> nodes = new HashSet<>();
import org.opensearch.cluster.routing.GroupShardsIterator;  
import org.opensearch.search.suggest.SuggestBuilder;
import org.opensearch.action.search.SearchRequestBuilder;  
        for (NodeStats stat : nodeStats.getNodes()) {
                num++;
        for (ShardIterator shardIterator : allAssignedShardsGrouped) {
import org.opensearch.common.settings.Settings;  
        assertAcked(  
        return request.suggest(suggestBuilder);
 */  
 * SPDX-License-Identifier: Apache-2.0
        }  
 */  
 * this work for additional information regarding copyright
            }
 * this file be licensed under the Apache-2.0 license or a
        refresh();  
        assertThat(num, greaterThan(0));  
        assertThat(numNodes, greaterThanOrEqualTo(2));
    public SuggestStatsIT(Settings staticSettings) {
        final SearchStats.Stats suggest = indicesStats.getTotal().getSearch().getTotal();
        );  
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
    private Set<String> nodeIdsWithIndex(String... indices) {
        assertAcked(
            SearchStats.Stats suggestStats = stat.getIndices().getSearch().getTotal();  
            equalTo((long) ((suggestAllIdx + suggestIdx2) * shardsIdx2))
            } else {  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
        }
}  
 * compatible open source license.
            SearchResponse suggestResponse = addSuggestions(internalCluster().coordOnlyNodeClient().prepareSearch("test2"), i).get();
                if (routing.active()) {
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        for (int i = 0; i < randomIntBetween(20, 100); i++) {  
            logger.info("evaluating {}", stat.getNode());
import static org.hamcrest.Matchers.greaterThan;
            }
        assertThat(
        );
        return Arrays.asList(
 * specific language governing permissions and limitations
    @ParametersFactory  
 */
import java.util.Arrays;
        final int numNodes = cluster().numDataNodes();
    }
import java.util.Collection;  
        // the upperbound is num shards * total time since we do searches in parallel
    }
            if (randomBoolean()) {
        assertThat(numAssignedShards("test1", "test2"), greaterThanOrEqualTo(2));  
public class SuggestStatsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        }  
            for (ShardRouting routing : shardIterator) {  
        assertThat(suggest.getSuggestTimeInMillis(), lessThanOrEqualTo(totalShards * (endTime - startTime)));  
        );
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
/*  
        }
        GroupShardsIterator<ShardIterator> allAssignedShardsGrouped = state.routingTable().allAssignedShardsGrouped(indices, true);  
        );
        }  
 *
                }  
        assertThat(numNodes, lessThanOrEqualTo(totalShards));  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        // check current  
        return allAssignedShardsGrouped.size();
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;  
