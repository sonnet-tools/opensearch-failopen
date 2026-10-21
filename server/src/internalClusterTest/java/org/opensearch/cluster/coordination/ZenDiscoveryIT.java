 */
        assertThat(stats.getPublishStats(), notNullValue());
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.DISCOVERY;
        String node1 = internalCluster().startNode();
        assertTrue(t.getCause().getCause() instanceof IllegalArgumentException);
/*
        final CompletableFuture<Throwable> future = new CompletableFuture<>();
        final String oldClusterManager = internalCluster().getClusterManagerName();
        public String getWriteableName() {
        assertThat(stats.getPublishStats().getFullClusterStateReceivedCount(), greaterThanOrEqualTo(0L));
package org.opensearch.cluster.coordination;
        final ClusterState state = clusterService.state();
        assertThat(clusterHealthResponse.isTimedOut(), is(false));
import java.util.concurrent.TimeUnit;
        internalCluster().startNode();
        }
 * GitHub history for details.
        assertThat(stats.getQueueStats().getCommitted(), equalTo(0));
            }
            .cluster()
        @Override
        internalCluster().startNodes(2, clusterManagerNodeSettings);
        public static final String TYPE = "custom_md";
                }
    public static class CustomMetadata extends TestCustomMetadata {
                @Override
        @Override
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
 * Licensed to Elasticsearch under one or more contributor
        });
        builder.startObject();
 * KIND, either express or implied.  See the License for the
        assertThat(stats.getPublishStats().getIncompatibleClusterStateDiffReceivedCount(), equalTo(0L));
        );
        internalCluster().stopCurrentClusterManagerNode();
        ClusterHealthResponse clusterHealthResponse = client().admin()
        ensureGreen(); // ensures that all events are processed (in particular state recovery fully completed)
        internalCluster().startNodes(2, dateNodeSettings);
        DiscoveryNode node = state.nodes().getLocalNode();
        assertThat(stats.getQueueStats(), notNullValue());
import static org.hamcrest.Matchers.not;
            new JoinRequest(node, 0L, Optional.empty()),
    public void testDiscoveryStats() throws Exception {
import org.opensearch.common.xcontent.XContentFactory;
        int numRecoveriesAfterNewClusterManager = r.shardRecoveryStates().get("test").size();
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.cluster.node.DiscoveryNode;
 */
        ClusterState stateWithCustomMetadata = ClusterState.builder(state).metadata(mdBuilder).build();
        assertThat(stats.getQueueStats().getTotal(), equalTo(0));
        }
 * compatible open source license.
        @Override
        Coordinator coordinator = (Coordinator) internalCluster().getInstance(Discovery.class, clusterManagerNode);
        assertThat(stats.getQueueStats().getPending(), equalTo(0));
        assertThat(numRecoveriesAfterNewClusterManager, equalTo(numRecoveriesBeforeNewClusterManager));
import org.opensearch.Version;
        ensureSearchable("test");
            String current = internalCluster().getClusterManagerName();
            return Version.CURRENT;
/*
import static org.hamcrest.Matchers.equalTo;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
                public void onFailure(Exception e) {
public class ZenDiscoveryIT extends OpenSearchIntegTestCase {
import org.opensearch.test.OpenSearchIntegTestCase;
            .get();
            .setWaitForNodes("4")
        Settings dateNodeSettings = dataNode();
    }
        Settings clusterManagerNodeSettings = clusterManagerOnlyNode();
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
        public EnumSet<Metadata.XContentContext> context() {
            new JoinHelper.JoinCallback() {
 * this file be licensed under the Apache-2.0 license or a
                    .numberOfPendingTasks(),
        Metadata.Builder mdBuilder = Metadata.builder(state.metadata());
import java.util.concurrent.CompletableFuture;
        createIndex("test");
            stateWithCustomMetadata,
    }
                internalCluster().clusterService(internalCluster().getClusterManagerName())
import static org.opensearch.test.NodeRoles.dataNode;
        DiscoveryStats stats = statsResponse.getNodes().get(0).getDiscoveryStats();
            () -> assertThat(
    public void testNoShardRelocationsOccurWhenElectedClusterManagerNodeFails() throws Exception {
            .setWaitForEvents(Priority.LANGUID)
        int numRecoveriesBeforeNewClusterManager = r.shardRecoveryStates().get("test").size();
 * the Apache License, Version 2.0 (the "License"); you may
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        }
 * software distributed under the License is distributed on an
            )
                    future.completeExceptionally(new AssertionError("onSuccess should not be called"));
import org.opensearch.transport.RemoteTransportException;
        }
            return TYPE;
        assertThat(stats.getPublishStats().getCompatibleClusterStateDiffReceivedCount(), greaterThanOrEqualTo(0L));
import org.opensearch.core.xcontent.XContentBuilder;
/*
        ); // see https://github.com/elastic/elasticsearch/issues/24388
 * Modifications Copyright OpenSearch Contributors. See
                    .getClusterManagerService()
import org.opensearch.common.settings.Settings;
 * this work for additional information regarding copyright
import org.opensearch.discovery.DiscoveryStats;
        r = client().admin().indices().prepareRecoveries("test").get();
                }
        assertBusy(() -> {
            assertThat(current, not(equalTo(oldClusterManager)));
 *
import org.opensearch.cluster.service.ClusterService;
    }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    future.complete(e);
import org.opensearch.common.Priority;
import static org.hamcrest.Matchers.containsString;
        ensureSearchable("test");
        assertThat(statsResponse.getNodes().size(), equalTo(1));
                public void onSuccess() {
        public Version getMinimalSupportedVersion() {
import org.opensearch.cluster.ClusterState;
import java.util.EnumSet;
        coordinator.sendValidateJoinRequest(
 */
                @Override
import org.opensearch.test.TestCustomMetadata;
            super(data);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.discovery.Discovery;
    public void testHandleNodeJoin_incompatibleClusterState() throws InterruptedException, ExecutionException, TimeoutException {
        assertTrue(t.getCause() instanceof RemoteTransportException);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .setWaitForNoRelocatingShards(true)
                equalTo(0)
import static org.opensearch.test.NodeRoles.clusterManagerOnlyNode;
        builder.endObject();
import java.util.Optional;
        Throwable t = future.get(10, TimeUnit.SECONDS);
}
import java.util.concurrent.ExecutionException;
        logger.info("--> request node discovery stats");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        assertTrue(t instanceof IllegalStateException);
        NodesStatsResponse statsResponse = client().admin().cluster().prepareNodesStats().clear().addMetric(DISCOVERY.metricName()).get();
import static org.hamcrest.Matchers.notNullValue;
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, node1);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, numClientNodes = 0)
 * You may obtain a copy of the License at
            return EnumSet.of(Metadata.XContentContext.GATEWAY, Metadata.XContentContext.SNAPSHOT);
        assertThat(t.getCause().getCause().getMessage(), containsString("Unknown NamedWriteable"));
        RecoveryResponse r = client().admin().indices().prepareRecoveries("test").get();
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to
import static org.hamcrest.Matchers.is;
 * Unless required by applicable law or agreed to in writing,
 *
 *
            assertThat(current, notNullValue());
        CustomMetadata(String data) {
 * ownership. Elasticsearch licenses this file to you under
        mdBuilder.putCustom(CustomMetadata.TYPE, new CustomMetadata("data"));
import java.util.concurrent.TimeoutException;
        XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();
            .prepareHealth()
 * under the License.
        assertBusy(
