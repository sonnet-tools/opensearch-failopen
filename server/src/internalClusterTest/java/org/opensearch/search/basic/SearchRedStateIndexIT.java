            assertThat(unassigneds.size(), greaterThan(0));
import org.opensearch.search.SearchService;
import org.opensearch.cluster.routing.ShardRoutingState;
        );
    }
 * not use this file except in compliance with the License.
 */
 * Unless required by applicable law or agreed to in writing,
        assertThat("Expect subset of shards successful", searchResponse.getSuccessfulShards(), lessThan(numShards));
 * specific language governing permissions and limitations
    public SearchRedStateIndexIT(Settings staticSettings) {
        }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.junit.After;
        assertThat(RestStatus.OK, equalTo(searchResponse.status()));
import org.opensearch.action.search.SearchResponse;
 * KIND, either express or implied.  See the License for the
            .setTransientSettings(transientSettings)
    @ParametersFactory
        assertThat("Expect no shards skipped", searchResponse.getSkippedShards(), equalTo(0));
 *
 *
                .prepareUpdateSettings()
        SearchResponse searchResponse = client().prepareSearch().setSize(0).get();
        SearchPhaseExecutionException ex = expectThrows(
 * Licensed to Elasticsearch under one or more contributor
        setClusterDefaultAllowPartialResults(false);
        assertThat("Expect no shards skipped", searchResponse.getSkippedShards(), equalTo(0));
            SearchPhaseExecutionException.class,
    }
import static org.hamcrest.Matchers.containsString;
        Settings transientSettings = Settings.builder().put(key, allowPartialResults).build();
            .prepareUpdateSettings()
        assertAcked(
 */
/*
import org.opensearch.test.OpenSearchIntegTestCase;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.health.ClusterHealthStatus;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.common.settings.Settings;
        buildRedIndex(numShards);
}
public class SearchRedStateIndexIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
            .get();
 * You may obtain a copy of the License at
            () -> client().prepareSearch().setSize(0).setAllowPartialSearchResults(false).get()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
            SearchPhaseExecutionException.class,
import org.opensearch.cluster.ClusterState;
    }
 * license agreements. See the NOTICE file distributed with
 *
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return Arrays.asList(
        final int numShards = cluster().numDataNodes() + 2;
 * compatible open source license.
                .setTransientSettings(Settings.builder().putNull(SearchService.DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS.getKey()))
 * this file be licensed under the Apache-2.0 license or a
    private void buildRedIndex(int numShards) throws Exception {
        );
 */
/*
        buildRedIndex(numShards);
            )
        assertAcked(
            .cluster()
import static org.hamcrest.Matchers.equalTo;
    public void testClusterDisallowPartialsWithRedState() throws Exception {
        );
    public void testAllowPartialsWithRedState() throws Exception {
        internalCluster().stopRandomDataNode();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        );
    }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import java.util.Arrays;
        client().admin().cluster().prepareHealth().setWaitForStatus(ClusterHealthStatus.RED).get();
        ensureGreen();
        refresh();
import org.opensearch.cluster.routing.ShardRouting;
                Settings.builder().put("index.number_of_shards", numShards).put("index.number_of_replicas", 0)
import org.opensearch.action.search.SearchPhaseExecutionException;
        assertBusy(() -> {
        buildRedIndex(cluster().numDataNodes() + 2);
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.search.basic;
        assertThat("Expected total shards", searchResponse.getTotalShards(), equalTo(numShards));
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
        SearchResponse searchResponse = client().prepareSearch().setSize(0).setAllowPartialSearchResults(true).get();
    @After
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
        for (int i = 0; i < 10; i++) {
 * GitHub history for details.
        assertAcked(response1);
        assertThat(ex.getDetailedMessage(), containsString("Search rejected due to missing shard"));
    public void cleanup() throws Exception {
        );
    public void testClusterAllowPartialsWithRedState() throws Exception {
    }
            prepareCreate("test").setSettings(
        assertThat(ex.getDetailedMessage(), containsString("Search rejected due to missing shard"));
        String key = SearchService.DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS.getKey();
    public static Collection<Object[]> parameters() {
        final int numShards = cluster().numDataNodes() + 2;
        assertThat("Expect subset of shards successful", searchResponse.getSuccessfulShards(), lessThan(numShards));
import static org.hamcrest.Matchers.greaterThan;
                .cluster()
        buildRedIndex(cluster().numDataNodes() + 2);
            List<ShardRouting> unassigneds = clusterState.getRoutingTable().shardsWithState(ShardRoutingState.UNASSIGNED);
    }
        indexRandomForConcurrentSearch("test");
        assertEquals(response1.getTransientSettings().getAsBoolean(key, null), allowPartialResults);
    public void testDisallowPartialsWithRedState() throws Exception {
 * under the License.
        super(staticSettings);
        assertThat(RestStatus.OK, equalTo(searchResponse.status()));
        setClusterDefaultAllowPartialResults(true);
            client().prepareIndex("test").setId("" + i).setSource("field1", "value1").get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat("Expected total shards", searchResponse.getTotalShards(), equalTo(numShards));
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.rest.RestStatus;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            () -> client().prepareSearch().setSize(0).get()
 * software distributed under the License is distributed on an
        assertThat("Expect no shards failed", searchResponse.getFailedShards(), equalTo(0));
        SearchPhaseExecutionException ex = expectThrows(
    }
 * this work for additional information regarding copyright
import java.util.List;
    }
        ClusterUpdateSettingsResponse response1 = client().admin()
 * the Apache License, Version 2.0 (the "License"); you may
            client().admin()
        assertThat("Expect no shards failed", searchResponse.getFailedShards(), equalTo(0));
import static org.hamcrest.Matchers.lessThan;
    private void setClusterDefaultAllowPartialResults(boolean allowPartialResults) {
        });
