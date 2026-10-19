        // ensure that the cluster-manager always has a HIGH priority pending task
                .cluster()  
                client().admin()
 * compatible open source license.
        });  
 * Modifications Copyright OpenSearch Contributors. See
        assertAcked(  
            .setPersistentSettings(Settings.builder().put(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey(), invalidPriority))
import org.opensearch.test.OpenSearchIntegTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collection;
            .cluster()  
                    .cluster()  
 * under the License.  
 */
        return builder.build();
    }
            }
                .setPersistentSettings(Settings.builder().putNull(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey()))
        // in particular, after the primaries have started there's a follow-up reroute at a higher priority than the spam  
                    clusterManagerClusterService.submitStateUpdateTask("spam", this);  
    public void testFollowupRerouteRejectsInvalidPriorities() {  
        );
        // not "languid" (because we use that to wait for no pending tasks) nor "low" or "immediate" (because these are unreasonable)  
            }
import org.opensearch.cluster.ClusterState;  
    }  
 */  
    @Override
                if (stopSpammingClusterManager.get() == false) {
                .cluster()
        assertFalse(clusterHealthResponse.isTimedOut());  
        // we should at that point be confident that the default priority is appropriate for all clusters.
        if (randomBoolean()) {
 * specific language governing permissions and limitations
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            .get();
                return currentState;
import org.opensearch.cluster.ClusterStateUpdateTask;
import org.opensearch.plugins.Plugin;
        assertThat(clusterHealthResponse.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        internalCluster().ensureAtLeastNumDataNodes(2);
            );
import org.opensearch.common.action.ActionFuture;
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
                .prepareUpdateSettings()  
 * ownership. Elasticsearch licenses this file to you under  
        return randomFrom("normal", "high", "urgent", "NORMAL", "HIGH", "URGENT");
        createIndex("test");
        if (randomBoolean()) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                    .prepareUpdateSettings()
        stopSpammingClusterManager.set(true);
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import org.opensearch.cluster.service.ClusterService;  
        internalCluster().ensureAtLeastNumDataNodes(2);
                }
                throw new AssertionError(source, e);  
    }
        final ActionFuture<ClusterUpdateSettingsResponse> responseFuture = client().admin()
        // Can be removed when this setting is removed, as we copiously test the default case.
 * software distributed under the License is distributed on an
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.Priority;
                .cluster()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .prepareUpdateSettings()
                .prepareUpdateSettings()  
        }  
            client().admin()
                    .setPersistentSettings(
            allOf(containsString(invalidPriority), containsString(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey()))  
import static org.hamcrest.Matchers.equalTo;  
    public void testFollowupRerouteCanBeSetToHigherPriority() {
 * license agreements. See the NOTICE file distributed with
 */  
import org.opensearch.cluster.health.ClusterHealthStatus;
import java.util.concurrent.atomic.AtomicBoolean;
        );
                    )
/*  
        return Collections.singletonList(MockTransportService.TestPlugin.class);  
                .setPersistentSettings(Settings.builder().put(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey(), "urgent"))
    }
            @Override
            expectThrows(IllegalArgumentException.class, responseFuture::actionGet).getMessage(),
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
                .prepareUpdateSettings()
        assertFalse(client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).get().isTimedOut());
import static org.hamcrest.Matchers.containsString;
        }  
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;  
            internalCluster().getClusterManagerName()
    protected Settings nodeSettings(int nodeOrdinal) {
        );  
        final ClusterService clusterManagerClusterService = internalCluster().getInstance(  
 * GitHub history for details.
 * this work for additional information regarding copyright
            assertAcked(
 * You may obtain a copy of the License at  
            public ClusterState execute(ClusterState currentState) {  
            client().admin()
 *  
        // even with the cluster-manager under such pressure, all shards of the index can be assigned;
        final Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));  
/*
        createIndex("test");
        assertAcked(  
package org.opensearch.cluster.action.shard;
        // Shows that no matter how cluster.routing.allocation.shard_state.reroute.priority is set, a follow-up reroute eventually occurs.
        assertAcked(
    private String randomPriority() {
        // Shows that in a cluster under unbearable pressure we can still assign replicas (for now at least) by setting  
        );  
        final String invalidPriority = randomFrom("IMMEDIATE", "LOW", "LANGUID");
    }
 * not use this file except in compliance with the License.
            @Override
import static org.hamcrest.Matchers.allOf;
        );
import org.opensearch.common.settings.Settings;  
            }
            .setWaitForEvents(Priority.LANGUID)
        // cluster.routing.allocation.shard_state.reroute.priority to a higher priority. Can be removed when this setting is removed, as
                .setPersistentSettings(Settings.builder().putNull(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey()))
        assertFalse(client().admin().cluster().prepareHealth().setWaitForGreenStatus().get().isTimedOut());
            builder.put(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey(), randomPriority());
        assertThat(
            .execute();  
        final AtomicBoolean stopSpammingClusterManager = new AtomicBoolean();
}  
/*  
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.test.transport.MockTransportService;  
            .cluster()
                        Settings.builder().put(ShardStateAction.FOLLOW_UP_REROUTE_PRIORITY_SETTING.getKey(), randomPriority())  
            @Override  
public class ShardStateActionIT extends OpenSearchIntegTestCase {
            .prepareHealth()
 * this file be licensed under the Apache-2.0 license or a
    public void testFollowupRerouteAlwaysOccursEventually() {  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            ClusterService.class,
        final ClusterHealthResponse clusterHealthResponse = client().admin()  
 *
            client().admin()
        clusterManagerClusterService.submitStateUpdateTask("spam", new ClusterStateUpdateTask(Priority.HIGH) {
            public void onFailure(String source, Exception e) {
            .setWaitForNoInitializingShards(true)  
