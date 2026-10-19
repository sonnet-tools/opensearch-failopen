        );
        while (flag.get() == false) {
 * this work for additional information regarding copyright
    private static class FakeClusterInfoServiceClient extends NoOpClient {
 * Licensed to Elasticsearch under one or more contributor  
            }
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
        runUntilFlag(deterministicTaskQueue, failClusterManager2);
        @Override
        final ClusterManagerService clusterManagerService = new FakeThreadPoolClusterManagerService(
        }  
                deterministicTaskQueue.advanceTime();  
        clusterService.start();
        runFor(deterministicTaskQueue, INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING.get(settings).millis());
            @Override
        clusterManagerService.setClusterStateSupplier(clusterApplierService::state);  
    }  
            } else if (deterministicTaskQueue.hasRunnableTasks()) {
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;  
        ) {  
                requestCount++;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else {
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.node.Node;
        final ThreadPool threadPool = deterministicTaskQueue.getThreadPool();
 * You may obtain a copy of the License at  
        while (deterministicTaskQueue.getCurrentTimeMillis() < endTime  
            () -> ClusterState.builder(new ClusterName("cluster")).nodes(localClusterManager).build(),  
            () -> ClusterState.builder(new ClusterName("cluster")).nodes(noClusterManager).build(),
            super(threadPool);
        clusterApplierService.onNewClusterState(  
            protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {  
    private static void runFor(DeterministicTaskQueue deterministicTaskQueue, long duration) {
 */
import org.opensearch.cluster.service.ClusterApplier;  
            settingsBuilder.put(INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING.getKey(), randomIntBetween(10000, 60000) + "ms");  
    private static ClusterApplier.ClusterApplyListener setFlagOnSuccess(AtomicBoolean flag) {
        }
    }  
        assertFalse(deterministicTaskQueue.hasRunnableTasks());  
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
    }
            }
                assertTrue(flag.compareAndSet(false, true));
import static org.opensearch.cluster.InternalClusterInfoService.INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING;
    }  
import org.opensearch.action.ActionRequest;
 * Modifications Copyright OpenSearch Contributors. See
        }
import org.opensearch.cluster.service.ClusterApplierService;
            public void onFailure(String source, Exception e) {
import org.opensearch.test.client.NoOpClient;
                deterministicTaskQueue.runRandomTask();  
            () -> ClusterState.builder(new ClusterName("cluster")).nodes(localClusterManager).build(),
                deterministicTaskQueue.runRandomTask();
            }
        final DiscoveryNodes localClusterManager = DiscoveryNodes.builder(noClusterManager)  
                listener.onFailure(new ClusterBlockException(Set.of(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL)));
import static org.hamcrest.Matchers.equalTo;
            ActionType<Response> action,  
/*  
            setFlagOnSuccess(becameClusterManager1)
        clusterManagerService.setClusterStatePublisher((clusterChangedEvent, publishListener, ackListener) -> fail("should not publish"));
 * software distributed under the License is distributed on an
        runUntilFlag(deterministicTaskQueue, becameClusterManager1);  
        FakeClusterInfoServiceClient(ThreadPool threadPool) {  
        );  
        protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
import org.opensearch.core.action.ActionResponse;  
        clusterService.addListener(clusterInfoService);  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import org.opensearch.action.ActionType;  
        if (randomBoolean()) {
                // ClusterInfoService handles ClusterBlockExceptions quietly, so we invent such an exception to avoid excess logging  
        runUntilFlag(deterministicTaskQueue, becameClusterManager2);
            deterministicTaskQueue.runAllRunnableTasks();
        clusterApplierService.setInitialState(ClusterState.builder(new ClusterName("cluster")).nodes(noClusterManager).build());
import org.opensearch.common.settings.ClusterSettings;
    }
        final FakeClusterInfoServiceClient client = new FakeClusterInfoServiceClient(threadPool);
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
        clusterInfoService.addListener(ignored -> {});
            }  
 * SPDX-License-Identifier: Apache-2.0
        clusterApplierService.onNewClusterState(  
/*
            setFlagOnSuccess(becameClusterManager2)
            @Override
            if (deterministicTaskQueue.hasDeferredTasks() && randomBoolean()) {  
            assertThat(client.requestCount, equalTo(initialRequestCount + 2)); // should have run two client requests per interval
            setFlagOnSuccess(failClusterManager2)  
            if (request instanceof NodesStatsRequest || request instanceof IndicesStatsRequest) {
import org.opensearch.cluster.coordination.MockSinglePrioritizingExecutor;
            }
import org.opensearch.cluster.service.ClusterManagerService;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
import java.util.Set;
        runUntilFlag(deterministicTaskQueue, failClusterManager1);
                fail("unexpected action: " + action.name());  
 *  
            if (deterministicTaskQueue.hasDeferredTasks() && randomBoolean()) {
 *
    public void testScheduling() {  
import java.util.concurrent.atomic.AtomicBoolean;
        clusterApplierService.onNewClusterState(
        );
        final AtomicBoolean failClusterManager2 = new AtomicBoolean();
 * ownership. Elasticsearch licenses this file to you under  
        final DiscoveryNodes noClusterManager = DiscoveryNodes.builder().add(discoveryNode).localNodeId(discoveryNode.getId()).build();
            .build();
import org.opensearch.common.settings.Settings;  
/*  
        clusterApplierService.onNewClusterState(
            final long duration = INTERNAL_CLUSTER_INFO_UPDATE_INTERVAL_SETTING.get(settings).millis();
import org.opensearch.Version;
            "test",  
            } else if (deterministicTaskQueue.hasRunnableTasks()) {
            Request request,
            threadPool,
        final AtomicBoolean becameClusterManager1 = new AtomicBoolean();  
 * not use this file except in compliance with the License.
 */  
        int requestCount;
        final AtomicBoolean failClusterManager1 = new AtomicBoolean();
    private static void runUntilFlag(DeterministicTaskQueue deterministicTaskQueue, AtomicBoolean flag) {
            "become cluster-manager 2",  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.service.FakeThreadPoolClusterManagerService;
import org.opensearch.cluster.block.ClusterBlockException;  
        final InternalClusterInfoService clusterInfoService = new InternalClusterInfoService(settings, clusterService, threadPool, client);
        }
        clusterService.setNodeConnectionsService(ClusterServiceUtils.createNoOpNodeConnectionsService());  
 * GitHub history for details.
            "become cluster-manager 1",
                deterministicTaskQueue.advanceTime();
 * compatible open source license.
                return new MockSinglePrioritizingExecutor("mock-executor", deterministicTaskQueue, threadPool);
import org.opensearch.test.ClusterServiceUtils;
            .clusterManagerNodeId(discoveryNode.getId())
        assertFalse(deterministicTaskQueue.hasDeferredTasks());
package org.opensearch.cluster;
        );  
 * the Apache License, Version 2.0 (the "License"); you may
            }
import org.opensearch.cluster.node.DiscoveryNodes;
        );
        final AtomicBoolean becameClusterManager2 = new AtomicBoolean();
            "fail cluster-manager 2",
            public void onSuccess(String source) {  
        };  
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.cluster.node.DiscoveryNode;
}
import org.opensearch.test.OpenSearchTestCase;  
        final ClusterService clusterService = new ClusterService(settings, clusterSettings, clusterManagerService, clusterApplierService);
        final DeterministicTaskQueue deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
        };
            "fail cluster-manager 1",
 * license agreements. See the NOTICE file distributed with
        final ClusterApplierService clusterApplierService = new ClusterApplierService("test", settings, clusterSettings, threadPool) {
            r -> {  
            @Override
 * specific language governing permissions and limitations
 */  
            () -> ClusterState.builder(new ClusterName("cluster")).nodes(noClusterManager).build(),
public class InternalClusterInfoServiceSchedulingTests extends OpenSearchTestCase {
        }
            "clusterManagerService",
            }
import org.opensearch.core.action.ActionListener;
 * Unless required by applicable law or agreed to in writing,
            setFlagOnSuccess(failClusterManager1)  
                fail("cluster-manager service should not run any tasks");
        final Settings.Builder settingsBuilder = Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), discoveryNode.getName());
        final Settings settings = settingsBuilder.build();
            && (deterministicTaskQueue.hasRunnableTasks() || deterministicTaskQueue.hasDeferredTasks())) {
        for (int i = 0; i < 3; i++) {  
 * under the License.  
 * KIND, either express or implied.  See the License for the
        deterministicTaskQueue.runAllRunnableTasks();
        final long endTime = deterministicTaskQueue.getCurrentTimeMillis() + duration;
                throw new AssertionError("unexpected", e);  
            ActionListener<Response> listener
        }
            final int initialRequestCount = client.requestCount;
            runFor(deterministicTaskQueue, duration);  
        return new ClusterApplier.ClusterApplyListener() {  
        final DiscoveryNode discoveryNode = new DiscoveryNode("test", buildNewFakeTransportAddress(), Version.CURRENT);
