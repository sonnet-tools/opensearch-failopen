                    future.completeExceptionally(new AssertionError("onSuccess should not be called"));  
        logger.info("--> request node discovery stats");
            return TYPE;  
            .cluster()
import static org.hamcrest.Matchers.equalTo;
 *
        assertThat(t.getCause().getCause().getMessage(), containsString("Unknown NamedWriteable"));  
        }
            .get();
import java.util.concurrent.TimeoutException;
import static org.opensearch.test.NodeRoles.dataNode;
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
        assertBusy(() -> {
                @Override  
        r = client().admin().indices().prepareRecoveries("test").get();  
        Settings dateNodeSettings = dataNode();
import org.opensearch.core.xcontent.ToXContent;  
 *  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.opensearch.test.NodeRoles.clusterManagerOnlyNode;
                    .numberOfPendingTasks(),  
                public void onFailure(Exception e) {
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node1);
        });  
                public void onSuccess() {
        XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
import java.util.concurrent.CompletableFuture;
        @Override
            new JoinRequest(node, 0L, Optional.empty()),
import org.opensearch.cluster.service.ClusterService;
import java.util.Optional;  
            assertThat(current, notNullValue());
import org.opensearch.cluster.metadata.Metadata;  
 * compatible open source license.
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
    public static class CustomMetadata extends TestCustomMetadata {  
        DiscoveryStats stats = statsResponse.getNodes().get(0).getDiscoveryStats();  
        DiscoveryNode node = state.nodes().getLocalNode();
        coordinator.sendValidateJoinRequest(  
        createIndex("test");
        ensureSearchable("test");
        assertThat(stats.getQueueStats().getTotal(), equalTo(0));
        int numRecoveriesAfterNewClusterManager = r.shardRecoveryStates().get("test").size();
        @Override
        public Version getMinimalSupportedVersion() {
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.ClusterState;
        Throwable t = future.get(10, TimeUnit.SECONDS);
        assertThat(statsResponse.getNodes().size(), equalTo(1));
import org.opensearch.discovery.DiscoveryStats;  
        }
/*  
 * The OpenSearch Contributors require contributions made to  
        ); // see https://github.com/elastic/elasticsearch/issues/24388  
            .setWaitForNoRelocatingShards(true)  
                }
        assertThat(stats.getPublishStats(), notNullValue());  
        ClusterHealthResponse clusterHealthResponse = client().admin()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, numClientNodes = 0)
            .setWaitForEvents(Priority.LANGUID)
 * Licensed to Elasticsearch under one or more contributor  
        NodesStatsResponse statsResponse = client().admin().cluster().prepareNodesStats().clear().addMetric(DISCOVERY.metricName()).get();  
            String current = internalCluster().getClusterManagerName();  
 * software distributed under the License is distributed on an
    public void testHandleNodeJoin_incompatibleClusterState() throws InterruptedException, ExecutionException, TimeoutException {
    }  
import org.opensearch.test.OpenSearchIntegTestCase;
        assertTrue(t instanceof IllegalStateException);  
        final CompletableFuture<Throwable> future = new CompletableFuture<>();  
 * this work for additional information regarding copyright
    }
 * the Apache License, Version 2.0 (the "License"); you may
        RecoveryResponse r = client().admin().indices().prepareRecoveries("test").get();  
        builder.endObject();
        public String getWriteableName() {
            stateWithCustomMetadata,
                    .getClusterManagerService()
            new JoinHelper.JoinCallback() {  
import java.util.concurrent.ExecutionException;
    public void testDiscoveryStats() throws Exception {
            () -> assertThat(  
            .prepareHealth()  
import org.opensearch.discovery.Discovery;
        builder.startObject();  
import java.util.concurrent.TimeUnit;  
 * GitHub history for details.
        int numRecoveriesBeforeNewClusterManager = r.shardRecoveryStates().get("test").size();
    public void testNoShardRelocationsOccurWhenElectedClusterManagerNodeFails() throws Exception {
        internalCluster().startNodes(2, clusterManagerNodeSettings);
        assertThat(stats.getPublishStats().getIncompatibleClusterStateDiffReceivedCount(), equalTo(0L));
        @Override  
            return Version.CURRENT;
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.DISCOVERY;  
        }
        assertThat(stats.getQueueStats().getCommitted(), equalTo(0));  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
import static org.hamcrest.Matchers.notNullValue;
        Metadata.Builder mdBuilder = Metadata.builder(state.metadata());
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                }  
                    future.complete(e);
        assertTrue(t.getCause() instanceof RemoteTransportException);
public class ZenDiscoveryIT extends OpenSearchIntegTestCase {
import static org.hamcrest.Matchers.containsString;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 *
 * KIND, either express or implied.  See the License for the
        assertTrue(t.getCause().getCause() instanceof IllegalArgumentException);
        public EnumSet<Metadata.XContentContext> context() {  
    }  
import org.opensearch.common.settings.Settings;
                equalTo(0)
        internalCluster().startNode();  
import static org.hamcrest.Matchers.is;  
import org.opensearch.Version;
import org.opensearch.core.xcontent.XContentBuilder;
        ClusterState stateWithCustomMetadata = ClusterState.builder(state).metadata(mdBuilder).build();
            )
        assertBusy(
                @Override
    }  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        mdBuilder.putCustom(CustomMetadata.TYPE, new CustomMetadata("data"));  
 */
        }  
package org.opensearch.cluster.coordination;
/*  
        assertThat(stats.getPublishStats().getCompatibleClusterStateDiffReceivedCount(), greaterThanOrEqualTo(0L));  
        CustomMetadata(String data) {  
            super(data);
        assertThat(stats.getQueueStats().getPending(), equalTo(0));
}
 */  
 * Unless required by applicable law or agreed to in writing,
        internalCluster().stopCurrentClusterManagerNode();
 */  
        final String oldClusterManager = internalCluster().getClusterManagerName();  
        );
import org.opensearch.common.xcontent.XContentFactory;
import java.util.EnumSet;
import org.opensearch.test.TestCustomMetadata;
/*
import org.opensearch.transport.RemoteTransportException;  
        assertThat(stats.getQueueStats(), notNullValue());
 * SPDX-License-Identifier: Apache-2.0
        internalCluster().startNodes(2, dateNodeSettings);  
import static org.hamcrest.Matchers.not;
        assertThat(numRecoveriesAfterNewClusterManager, equalTo(numRecoveriesBeforeNewClusterManager));
        public static final String TYPE = "custom_md";
        Coordinator coordinator = (Coordinator) internalCluster().getInstance(Discovery.class, clusterManagerNode);  
                internalCluster().clusterService(internalCluster().getClusterManagerName())
        ensureSearchable("test");
 * Modifications Copyright OpenSearch Contributors. See
        Settings clusterManagerNodeSettings = clusterManagerOnlyNode();  
        String node1 = internalCluster().startNode();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
        assertThat(stats.getPublishStats().getFullClusterStateReceivedCount(), greaterThanOrEqualTo(0L));
        final ClusterState state = clusterService.state();
import org.opensearch.common.Priority;  
        ensureGreen(); // ensures that all events are processed (in particular state recovery fully completed)
        assertThat(clusterHealthResponse.isTimedOut(), is(false));
            .setWaitForNodes("4")
            return EnumSet.of(Metadata.XContentContext.GATEWAY, Metadata.XContentContext.SNAPSHOT);
            assertThat(current, not(equalTo(oldClusterManager)));
            }
