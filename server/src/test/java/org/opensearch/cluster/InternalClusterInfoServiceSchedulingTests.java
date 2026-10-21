            }
        final AtomicBoolean failClusterManager1 = new AtomicBoolean();
                requestCount++;
 * Unless required by applicable law or agreed to in writing,
            if (request instanceof NodesStatsRequest || request instanceof IndicesStatsRequest) {
        final ClusterManagerService clusterManagerService = new FakeThreadPoolClusterManagerService(
        clusterApplierService.onNewClusterState(
        }
        );
        }
            "test",
import org.opensearch.cluster.service.FakeThreadPoolClusterManagerService;
        }
                deterministicTaskQueue.advanceTime();
        );
            }
        clusterService.setNodeConnectionsService(ClusterServiceUtils.createNoOpNodeConnectionsService());
        final DiscoveryNodes localClusterManager = DiscoveryNodes.builder(noClusterManager)
            r -> {
 * You may obtain a copy of the License at
 * not use this file except in compliance with the License.
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
        clusterService.addListener(clusterInfoService);
 *
        final long endTime = deterministicTaskQueue.getCurrentTimeMillis() + duration;
 *
            threadPool,
            setFlagOnSuccess(becameClusterManager1)
 * compatible open source license.
            final long duration = INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING.get(settings).millis();
 */
}
import org.opensearch.cluster.node.DiscoveryNodes;
            public void onFailure(String source, Exception e) {
 * GitHub history for details.
                assertTrue(flag.compareAndSet(false, true));
import org.opensearch.test.ClusterServiceUtils;
import org.opensearch.common.settings.ClusterSettings;
                throw new AssertionError("unexpected", e);
            "fail cluster-manager 1",
            }
 * software distributed under the License is distributed on an
            } else {
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        runUntilFlag(deterministicTaskQueue, failClusterManager2);
        );
        }
import org.opensearch.core.action.ActionListener;
            if (deterministicTaskQueue.hasDeferredTasks() && randomBoolean()) {
        final DiscoveryNodes noClusterManager = DiscoveryNodes.builder().add(discoveryNode).localNodeId(discoveryNode.getId()).build();
        return new ClusterApplier.ClusterApplyListener() {
            }
            assertThat(client.requestCount, equalTo(initialRequestCount + 2)); // should have run two client requests per interval
    private static class FakeClusterInfoServiceClient extends NoOpClient {
            }
                return new MockSinglePrioritizingExecutor("mock-executor", deterministicTaskQueue, threadPool);
        clusterApplierService.setInitialState(ClusterState.builder(new ClusterName("cluster")).nodes(noClusterManager).build());
            .build();
    private static void runUntilFlag(DeterministicTaskQueue deterministicTaskQueue, AtomicBoolean flag) {
            && (deterministicTaskQueue.hasRunnableTasks() || deterministicTaskQueue.hasDeferredTasks())) {
        final ClusterApplierService clusterApplierService = new ClusterApplierService("test", settings, clusterSettings, threadPool) {
            "clusterManagerService",
        final FakeClusterInfoServiceClient client = new FakeClusterInfoServiceClient(threadPool);
/*
                fail("unexpected action: " + action.name());
import org.opensearch.cluster.service.ClusterService;
        };
 * specific language governing permissions and limitations
import org.opensearch.test.client.NoOpClient;
        clusterApplierService.onNewClusterState(
public class InternalClusterInfoServiceSchedulingTests extends OpenSearchTestCase {
        clusterApplierService.onNewClusterState(
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.action.ActionRequest;
        runUntilFlag(deterministicTaskQueue, becameClusterManager1);
 * ownership. Elasticsearch licenses this file to you under
        final InternalClusterInfoService clusterInfoService = new InternalClusterInfoService(settings, clusterService, threadPool, client);
package org.opensearch.cluster;
                fail("cluster-manager service should not run any tasks");
                deterministicTaskQueue.runRandomTask();
 *     http://www.apache.org/licenses/LICENSE-2.0
                deterministicTaskQueue.advanceTime();
        }
        }
        deterministicTaskQueue.runAllRunnableTasks();
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
        );
        };
        protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
import org.opensearch.cluster.service.ClusterApplier;
            () -> ClusterState.builder(new ClusterName("cluster")).nodes(noClusterManager).build(),
import org.opensearch.action.ActionType;
import org.opensearch.core.action.ActionResponse;
            "become cluster-manager 1",
            setFlagOnSuccess(becameClusterManager2)
        clusterManagerService.setClusterStatePublisher((clusterChangedEvent, publishListener, ackListener) -> fail("should not publish"));
            setFlagOnSuccess(failClusterManager1)
            ActionType<Response> action,
        final ClusterService clusterService = new ClusterService(settings, clusterSettings, clusterManagerService, clusterApplierService);
        final AtomicBoolean becameClusterManager2 = new AtomicBoolean();
import java.util.Set;
            () -> ClusterState.builder(new ClusterName("cluster")).nodes(localClusterManager).build(),
            setFlagOnSuccess(failClusterManager2)
            protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {
    }
        @Override
            } else if (deterministicTaskQueue.hasRunnableTasks()) {
            super(threadPool);
            "fail cluster-manager 2",
import org.opensearch.cluster.coordination.MockSinglePrioritizingExecutor;
        int requestCount;
        clusterInfoService.addListener(ignored -> {});
            () -> ClusterState.builder(new ClusterName("cluster")).nodes(noClusterManager).build(),
        if (randomBoolean()) {
            } else if (deterministicTaskQueue.hasRunnableTasks()) {
import java.util.concurrent.atomic.AtomicBoolean;
        for (int i = 0; i < 3; i++) {
import org.opensearch.node.Node;
                // ClusterInfoService handles ClusterBlockExceptions quietly, so we invent such an exception to avoid excess logging
        while (flag.get() == false) {
            ActionListener<Response> listener
            .clusterManagerNodeId(discoveryNode.getId())
import static org.opensearch.cluster.InternalClusterInfoService.INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING;
import org.opensearch.cluster.node.DiscoveryNode;
                deterministicTaskQueue.runRandomTask();
        final Settings.Builder settingsBuilder = Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), discoveryNode.getName());
            @Override
 * SPDX-License-Identifier: Apache-2.0
        final AtomicBoolean becameClusterManager1 = new AtomicBoolean();
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        FakeClusterInfoServiceClient(ThreadPool threadPool) {
    }
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
        final DiscoveryNode discoveryNode = new DiscoveryNode("test", buildNewFakeTransportAddress(), Version.CURRENT);
        );
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.service.ClusterManagerService;
    public void testScheduling() {
            if (deterministicTaskQueue.hasDeferredTasks() && randomBoolean()) {
            }
        final AtomicBoolean failClusterManager2 = new AtomicBoolean();
            @Override
 * Licensed to Elasticsearch under one or more contributor
 * the Apache License, Version 2.0 (the "License"); you may
        final Settings settings = settingsBuilder.build();
                listener.onFailure(new ClusterBlockException(Set.of(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL)));
 * this work for additional information regarding copyright
    }
        assertFalse(deterministicTaskQueue.hasRunnableTasks());
            deterministicTaskQueue.runAllRunnableTasks();
 *
import static org.hamcrest.Matchers.equalTo;
            Request request,
        ) {
 * license agreements. See the NOTICE file distributed with
            }
    }
        runUntilFlag(deterministicTaskQueue, failClusterManager1);
 */
    private static ClusterApplier.ClusterApplyListener setFlagOnSuccess(AtomicBoolean flag) {
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
        runUntilFlag(deterministicTaskQueue, becameClusterManager2);
        clusterManagerService.setClusterStateSupplier(clusterApplierService::state);
        clusterApplierService.onNewClusterState(
 * under the License.
            () -> ClusterState.builder(new ClusterName("cluster")).nodes(localClusterManager).build(),
            final int initialRequestCount = client.requestCount;
import org.opensearch.cluster.service.ClusterApplierService;
            runFor(deterministicTaskQueue, duration);
    private static void runFor(DeterministicTaskQueue deterministicTaskQueue, long duration) {
        runFor(deterministicTaskQueue, INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING.get(settings).millis());
import org.opensearch.Version;
 * The OpenSearch Contributors require contributions made to
        while (deterministicTaskQueue.getCurrentTimeMillis() < endTime
import org.opensearch.threadpool.ThreadPool;
/*
            public void onSuccess(String source) {
            @Override
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
/*
        clusterService.start();
import org.opensearch.test.OpenSearchTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            settingsBuilder.put(INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING.getKey(), randomIntBetween(10000, 60000) + "ms");
 * Modifications Copyright OpenSearch Contributors. See
            "become cluster-manager 2",
 */
    }
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(deterministicTaskQueue.hasDeferredTasks());
        final ThreadPool threadPool = deterministicTaskQueue.getThreadPool();
