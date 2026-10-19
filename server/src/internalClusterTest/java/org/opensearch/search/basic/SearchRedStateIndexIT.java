        buildRedIndex(numShards);  
}
    }  
    public SearchRedStateIndexIT(Settings staticSettings) {
/*  
        assertThat("Expect no shards skipped", searchResponse.getSkippedShards(), equalTo(0));
        Settings transientSettings = Settings.builder().put(key, allowPartialResults).build();  
import org.opensearch.search.SearchService;  
import java.util.List;
                .cluster()
import org.opensearch.action.search.SearchResponse;
    }
 */
    public void cleanup() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
 * Unless required by applicable law or agreed to in writing,
import org.junit.After;  
        for (int i = 0; i < 10; i++) {
    private void setClusterDefaultAllowPartialResults(boolean allowPartialResults) {  
            List<ShardRouting> unassigneds = clusterState.getRoutingTable().shardsWithState(ShardRoutingState.UNASSIGNED);
    }
        assertEquals(response1.getTransientSettings().getAsBoolean(key, null), allowPartialResults);  
        refresh();
 *  
    @ParametersFactory
        internalCluster().stopRandomDataNode();
    public void testAllowPartialsWithRedState() throws Exception {
                .prepareUpdateSettings()  
        assertThat("Expected total shards", searchResponse.getTotalShards(), equalTo(numShards));
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.rest.RestStatus;
            ClusterState clusterState = client().admin().cluster().prepareState().get().getState();  
        indexRandomForConcurrentSearch("test");
            prepareCreate("test").setSettings(
 */  
import static org.hamcrest.Matchers.greaterThan;
        }  
            SearchPhaseExecutionException.class,  
package org.opensearch.search.basic;
    private void buildRedIndex(int numShards) throws Exception {  
                .setTransientSettings(Settings.builder().putNull(SearchService.DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS.getKey()))
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        super(staticSettings);
            client().prepareIndex("test").setId("" + i).setSource("field1", "value1").get();
            )
        setClusterDefaultAllowPartialResults(true);
    public static Collection<Object[]> parameters() {  
import java.util.Collection;  
 * SPDX-License-Identifier: Apache-2.0
        );
        setClusterDefaultAllowPartialResults(false);
 *    http://www.apache.org/licenses/LICENSE-2.0
            () -> client().prepareSearch().setSize(0).setAllowPartialSearchResults(false).get()
        ensureGreen();  
 * GitHub history for details.
 * You may obtain a copy of the License at  
        String key = SearchService.DEFAULT_ALLOW_PARTIAL_SEARCH_RESULTS.getKey();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 *
        assertThat("Expect no shards failed", searchResponse.getFailedShards(), equalTo(0));
public class SearchRedStateIndexIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    public void testDisallowPartialsWithRedState() throws Exception {  
            client().admin()
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        assertThat(RestStatus.OK, equalTo(searchResponse.status()));
        );
                Settings.builder().put("index.number_of_shards", numShards).put("index.number_of_replicas", 0)  
        ClusterUpdateSettingsResponse response1 = client().admin()
 * software distributed under the License is distributed on an
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;  
            () -> client().prepareSearch().setSize(0).get()
    }
        SearchResponse searchResponse = client().prepareSearch().setSize(0).get();
            .cluster()  
import static org.hamcrest.Matchers.lessThan;
 *
        assertThat("Expect subset of shards successful", searchResponse.getSuccessfulShards(), lessThan(numShards));
        assertBusy(() -> {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.equalTo;  
import java.util.Arrays;
        );  
    public void testClusterDisallowPartialsWithRedState() throws Exception {
            .get();  
    }
/*  
        assertThat("Expect no shards skipped", searchResponse.getSkippedShards(), equalTo(0));
        });  
import org.opensearch.cluster.health.ClusterHealthStatus;
        assertThat("Expected total shards", searchResponse.getTotalShards(), equalTo(numShards));  
 * the Apache License, Version 2.0 (the "License"); you may
        );
        assertThat(ex.getDetailedMessage(), containsString("Search rejected due to missing shard"));
            .setTransientSettings(transientSettings)
    }
        SearchResponse searchResponse = client().prepareSearch().setSize(0).setAllowPartialSearchResults(true).get();
    }  
 * this file be licensed under the Apache-2.0 license or a
        final int numShards = cluster().numDataNodes() + 2;
import org.opensearch.action.search.SearchPhaseExecutionException;
import static org.hamcrest.Matchers.containsString;
            assertThat(unassigneds.size(), greaterThan(0));
        client().admin().cluster().prepareHealth().setWaitForStatus(ClusterHealthStatus.RED).get();  
import org.opensearch.cluster.ClusterState;  
    }
        assertAcked(  
    }
 */  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
 * under the License.  
        buildRedIndex(numShards);  
        SearchPhaseExecutionException ex = expectThrows(
        );
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(RestStatus.OK, equalTo(searchResponse.status()));  
        assertThat("Expect no shards failed", searchResponse.getFailedShards(), equalTo(0));  
 * specific language governing permissions and limitations
        buildRedIndex(cluster().numDataNodes() + 2);
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
        assertThat("Expect subset of shards successful", searchResponse.getSuccessfulShards(), lessThan(numShards));  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
        buildRedIndex(cluster().numDataNodes() + 2);
import org.opensearch.common.settings.Settings;
        assertAcked(
            SearchPhaseExecutionException.class,
/*
 * Modifications Copyright OpenSearch Contributors. See
        assertAcked(response1);
import org.opensearch.cluster.routing.ShardRoutingState;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final int numShards = cluster().numDataNodes() + 2;
    public void testClusterAllowPartialsWithRedState() throws Exception {
        SearchPhaseExecutionException ex = expectThrows(  
        return Arrays.asList(
            .prepareUpdateSettings()
 * not use this file except in compliance with the License.
 * compatible open source license.
import org.opensearch.cluster.routing.ShardRouting;
    @After
        assertThat(ex.getDetailedMessage(), containsString("Search rejected due to missing shard"));  
 * this work for additional information regarding copyright
