 * KIND, either express or implied.  See the License for the
        return nodes;
    public void testSimpleStats() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
}
        assertThat(numNodes, lessThanOrEqualTo(totalShards));
 * this file be licensed under the Apache-2.0 license or a
    @Override
    }
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;
        assertThat(suggest.getSuggestTimeInMillis(), lessThanOrEqualTo(totalShards * (endTime - startTime)));
    }
        assertThat(
 */
        return Arrays.asList(
        Set<String> nodes = new HashSet<>();
 *
        final int totalShards = shardsIdx1 + shardsIdx2;
            prepareCreate("test1").setSettings(
            } else {
            indicesStats.getIndices().get("test2").getTotal().getSearch().getTotal().getSuggestCount(),
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
 * software distributed under the License is distributed on an
            assertAllSuccessful(suggestResponse);
 *
        return request.suggest(suggestBuilder);
 */
        GroupShardsIterator allAssignedShardsGrouped = state.routingTable().allAssignedShardsGrouped(indices, true);
import org.opensearch.common.settings.Settings;
            } else {
        int num = 0;
        );
    public static Collection<Object[]> parameters() {
            logger.info("evaluating {}", stat.getNode());
        final SearchStats.Stats suggest = indicesStats.getTotal().getSearch().getTotal();
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < suggestIdx2; i++) {
import org.opensearch.cluster.ClusterState;
            ).setMapping("f", "type=text")
        return 0;
import org.opensearch.cluster.routing.GroupShardsIterator;
    @ParametersFactory
        long startTime = System.currentTimeMillis();
import org.opensearch.cluster.routing.ShardIterator;
                suggestBuilder.addSuggestion("s" + s, new TermSuggestionBuilder("f").text("test" + i));
                suggestBuilder.addSuggestion("s" + s, new PhraseSuggestionBuilder("f").text("test" + i + " test" + (i - 1)));
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
/*
 * not use this file except in compliance with the License.
        assertThat(suggest.getSuggestTimeInMillis(), greaterThanOrEqualTo(0L));
        }
        );
        assertThat(numAssignedShards("test1", "test2"), greaterThanOrEqualTo(2));
        int suggestIdx2 = scaledRandomIntBetween(20, 50);
        for (int i = 0; i < randomIntBetween(20, 100); i++) {
        // clear all stats first
        int suggestIdx1 = scaledRandomIntBetween(20, 50);
        long endTime = System.currentTimeMillis();
        // check suggest time
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, shardsIdx2).put(SETTING_NUMBER_OF_REPLICAS, 0)
            equalTo((long) ((suggestAllIdx + suggestIdx2) * shardsIdx2))
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        }
                }
        assertThat(shardsIdx1 + shardsIdx2, equalTo(numAssignedShards("test1", "test2")));
        );
public class SuggestStatsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * ownership. Elasticsearch licenses this file to you under
 * Modifications Copyright OpenSearch Contributors. See
        ensureGreen();
                assertThat(suggestStats.getSuggestTimeInMillis(), greaterThanOrEqualTo(0L));
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
import org.opensearch.action.search.SearchResponse;
        for (NodeStats stat : nodeStats.getNodes()) {
            assertAllSuccessful(suggestResponse);
            }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        GroupShardsIterator<ShardIterator> allAssignedShardsGrouped = state.routingTable().allAssignedShardsGrouped(indices, true);
    }
        // check current
    protected int numAssignedShards(String... indices) {
        for (int s = 0; s < randomIntBetween(2, 10); s++) {
 * compatible open source license.
                assertThat(suggestStats.getSuggestTimeInMillis(), equalTo(0L));
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    nodes.add(routing.currentNodeId());
            for (ShardRouting routing : shardIterator) {
import java.util.Arrays;
        assertAcked(
            SearchResponse suggestResponse = addSuggestions(internalCluster().coordOnlyNodeClient().prepareSearch("test2"), i).get();
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
    }
import java.util.HashSet;
            equalTo((long) (suggestAllIdx * totalShards + suggestIdx1 * shardsIdx1 + suggestIdx2 * shardsIdx2))
package org.opensearch.index.suggest.stats;
    }
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
            equalTo((long) ((suggestAllIdx + suggestIdx1) * shardsIdx1))
                assertThat(suggestStats.getSuggestCount(), equalTo(0L));
 *
 * license agreements. See the NOTICE file distributed with
        );
            SearchStats.Stats suggestStats = stat.getIndices().getSearch().getTotal();
import org.opensearch.test.OpenSearchIntegTestCase;
        final SuggestBuilder suggestBuilder = new SuggestBuilder();
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor
    public SuggestStatsIT(Settings staticSettings) {
import org.opensearch.action.search.SearchRequestBuilder;
        final int shardsIdx1 = randomIntBetween(1, 10); // we make sure each node gets at least a single shard...
    }
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().execute().actionGet();
            if (randomBoolean()) {
        refresh();
        final int shardsIdx2 = Math.max(numNodes - shardsIdx1, randomIntBetween(1, 10));
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
import org.opensearch.index.search.stats.SearchStats;
                if (routing.active()) {
        int suggestAllIdx = scaledRandomIntBetween(20, 50);
/*
import org.opensearch.cluster.routing.ShardRouting;
        }
    }
            indicesStats.getIndices().get("test1").getTotal().getSearch().getTotal().getSuggestCount(),
 * under the License.
        super(staticSettings);
            suggest.getSuggestCount(),
        );
                Settings.builder().put(SETTING_NUMBER_OF_SHARDS, shardsIdx1).put(SETTING_NUMBER_OF_REPLICAS, 0)
        client().admin().indices().prepareStats().clear().execute().actionGet();
 */
        assertAcked(
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < suggestIdx1; i++) {
            ).setMapping("f", "type=text")
        // check suggest count
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        Set<String> nodeIdsWithIndex = nodeIdsWithIndex("test1", "test2");
 * The OpenSearch Contributors require contributions made to
        assertThat(
        assertThat(suggest.getSuggestCurrent(), equalTo(0L));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            SearchResponse suggestResponse = addSuggestions(internalCluster().coordOnlyNodeClient().prepareSearch("test1"), i).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            SearchResponse suggestResponse = addSuggestions(internalCluster().coordOnlyNodeClient().prepareSearch(), i).get();
        IndicesStatsResponse indicesStats = client().admin().indices().prepareStats().execute().actionGet();
 * this work for additional information regarding copyright
    private SearchRequestBuilder addSuggestions(SearchRequestBuilder request, int i) {
        for (ShardIterator shardIterator : allAssignedShardsGrouped) {
                assertThat(suggestStats.getSuggestCount(), greaterThan(0L));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    protected int numberOfReplicas() {
            assertAllSuccessful(suggestResponse);
import static org.hamcrest.Matchers.greaterThan;
        for (int i = 0; i < suggestAllIdx; i++) {
        logger.info("iter {}, iter1 {}, iter2 {}, {}", suggestAllIdx, suggestIdx1, suggestIdx2, endTime - startTime);
import java.util.Set;
        assertThat(numNodes, greaterThanOrEqualTo(2));
import org.opensearch.search.suggest.SuggestBuilder;
 * GitHub history for details.
        }
        assertThat(
 * You may obtain a copy of the License at
            if (nodeIdsWithIndex.contains(stat.getNode().getId())) {
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
            index("test" + ((i % 2) + 1), "type", "" + i, "f", "test" + i);
    private Set<String> nodeIdsWithIndex(String... indices) {
        }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                num++;
        assertThat(num, greaterThan(0));
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
/*
import java.util.Collection;
        }
        }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        return allAssignedShardsGrouped.size();
        // the upperbound is num shards * total time since we do searches in parallel
        final int numNodes = cluster().numDataNodes();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            prepareCreate("test2").setSettings(
