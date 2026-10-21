                .setPersistentSettings(Settings.builder().putNull(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey()))
import org.opensearch.common.action.ActionFuture;
                .cluster()
        // cluster.routing.allocation.shard_state.reroute.priority to a higher priority. Can be removed when this setting is removed, as
            .setPersistentSettings(Settings.builder().put(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey(), invalidPriority))
/*
 */
import static org.hamcrest.Matchers.allOf;
        assertAcked(
import org.opensearch.cluster.ClusterState;
        final String invalidPriority = randomFrom("IMMEDIATE", "LOW", "LANGUID");
            public ClusterState execute(ClusterState currentState) {
                    .prepareUpdateSettings()
 * KIND, either express or implied.  See the License for the
/*
        if (randomBoolean()) {
        final ActionFuture<ClusterUpdateSettingsResponse> responseFuture = client().admin()
 * this work for additional information regarding copyright
                if (stopSpammingClusterManager.get() == false) {
                        Settings.builder().put(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey(), randomPriority())
        assertThat(clusterHealthResponse.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .setWaitForEvents(Priority.LANGUID)
import java.util.Collection;
        final ClusterService clusterManagerClusterService = internalCluster().getInstance(
            .setWaitForNoInitializingShards(true)
            .execute();
        );
 * GitHub history for details.
            @Override
            .cluster()
import org.opensearch.test.transport.MockTransportService;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }
 * You may obtain a copy of the License at
        createIndex("test");
    }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.service.ClusterService;
        // even with the cluster-manager under such pressure, all shards of the index can be assigned;
 * this file be licensed under the Apache-2.0 license or a
        return builder.build();
            allOf(containsString(invalidPriority), containsString(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey()))
                }
        // in particular, after the primaries have started there's a follow-up reroute at a higher priority than the spam
        if (randomBoolean()) {
import static org.hamcrest.Matchers.containsString;
        assertThat(
 *
import org.opensearch.common.Priority;
    public void testFollowupRerouteCanBeSetToHigherPriority() {
 */
            @Override
            .prepareUpdateSettings()
        final Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));
    @Override
            ClusterService.class,
/*
        final ClusterHealthResponse clusterHealthResponse = client().admin()
            builder.put(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey(), randomPriority());
        assertAcked(
                .prepareUpdateSettings()
    public void testFollowupRerouteRejectsInvalidPriorities() {
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import org.opensearch.common.settings.Settings;
    protected Settings nodeSettings(int nodeOrdinal) {
}
            }
        // Shows that no matter how cluster.routing.allocation.shard_state.reroute.priority is set, a follow-up reroute eventually occurs.
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
import org.opensearch.cluster.ClusterStateUpdateTask;
                .prepareUpdateSettings()
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
        }
import org.opensearch.plugins.Plugin;
            internalCluster().getClusterManagerName()
                    )
            public void onFailure(String source, Exception e) {
            @Override
                .prepareUpdateSettings()
            }
    private String randomPriority() {
        // Can be removed when this setting is removed, as we copiously test the default case.
        internalCluster().ensureAtLeastNumDataNodes(2);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .setPersistentSettings(Settings.builder().putNull(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey()))
        createIndex("test");
    public void testFollowupRerouteAlwaysOccursEventually() {
            .prepareHealth()
        assertFalse(clusterHealthResponse.isTimedOut());
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
        // we should at that point be confident that the default priority is appropriate for all clusters.
                .cluster()
 * the Apache License, Version 2.0 (the "License"); you may
            );
 */
 *
    }
                throw new AssertionError(source, e);
            .cluster()
        return Collections.singletonList(MockTransportService.TestPlugin.class);
            client().admin()
 *
        return randomFrom("normal", "high", "urgent", "NORMAL", "HIGH", "URGENT");
 * Modifications Copyright OpenSearch Contributors. See
        final AtomicBoolean stopSpammingClusterManager = new AtomicBoolean();
import java.util.Collections;
                    .cluster()
        });
            .get();
            assertAcked(
    @Override
import org.opensearch.cluster.health.ClusterHealthStatus;
                return currentState;
        // not "languid" (because we use that to wait for no pending tasks) nor "low" or "immediate" (because these are unreasonable)
        clusterManagerClusterService.submitStateUpdateTask("spam", new ClusterStateUpdateTask(Priority.HIGH) {
    }
package org.opensearch.cluster.action.shard;
        internalCluster().ensureAtLeastNumDataNodes(2);
            client().admin()
 * compatible open source license.
 * under the License.
        );
 * software distributed under the License is distributed on an
        // Shows that in a cluster under unbearable pressure we can still assign replicas (for now at least) by setting
            }
            expectThrows(IllegalArgumentException.class, responseFuture::actionGet).getMessage(),
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.equalTo;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
    }
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under
 * specific language governing permissions and limitations
        assertFalse(client().admin().cluster().prepareHealth().setWaitForGreenStatus().get().isTimedOut());
        assertFalse(client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get().isTimedOut());
 * SPDX-License-Identifier: Apache-2.0
                    .setPersistentSettings(
public class ShardStateActionIT extends OpenSearchIntegTestCase {
        stopSpammingClusterManager.set(true);
        );
            client().admin()
    }
                .setPersistentSettings(Settings.builder().put(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey(), "urgent"))
        );
import java.util.concurrent.atomic.AtomicBoolean;
 * Licensed to Elasticsearch under one or more contributor
                    clusterManagerClusterService.submitStateUpdateTask("spam", this);
        // ensure that the cluster-manager always has a HIGH priority pending task
                client().admin()
import org.opensearch.test.OpenSearchIntegTestCase;
        assertAcked(
 * not use this file except in compliance with the License.
                .cluster()
