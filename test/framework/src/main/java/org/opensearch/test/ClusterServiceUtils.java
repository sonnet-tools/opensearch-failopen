        return createClusterService(threadPool, localNode, clusterSettings, NoopMetricsRegistry.INSTANCE);
 */
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        setState(clusterService.getClusterApplierService(), clusterState);
 * SPDX-License-Identifier: Apache-2.0
                @Override
 *
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        AtomicReference<Exception> exception = new AtomicReference<>();
                }
    public static ClusterManagerService createClusterManagerService(ThreadPool threadPool, ClusterState initialClusterState) {
        } catch (InterruptedException e) {
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
 * ownership. Elasticsearch licenses this file to you under
    public static ClusterService createClusterService(ThreadPool threadPool, DiscoveryNode localNode) {
            }
            new ClusterApplyListener() {
public class ClusterServiceUtils {
    }
/*
    }
    }
        );
import org.opensearch.cluster.node.DiscoveryNode;
        });
        CountDownLatch latch = new CountDownLatch(1);
            throw new OpenSearchException("unexpected interruption", e);
        });
            Version.CURRENT
                @Override
    public static NodeConnectionsService createNoOpNodeConnectionsService() {
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.test;
            new ClusterManagerMetrics(metricsRegistry)
    }
    }
        };
 */
 * GitHub history for details.
            public void disconnectFromNodesExcept(DiscoveryNodes nodesToKeep) {
        return createClusterService(threadPool, discoveryNode);
    public static ClusterService createClusterService(Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {
    public static void setState(ClusterApplierService executor, ClusterState clusterState) {
        );
    }
        clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
        DiscoveryNode discoveryNode = new DiscoveryNode(
        clusterService.setNodeConnectionsService(createNoOpNodeConnectionsService());
                latch.countDown();
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).clusterManagerNodeId(localNode.getId()))
                // make sure we increment versions as listener may depend on it for change
        setState(clusterService, clusterStateBuilder.build());
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.OpenSearchException;
 * The OpenSearch Contributors require contributions made to
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        ThreadPool threadPool,
        DiscoveryNode localNode,
                    latch.countDown();
            public void onFailure(String source, Exception e) {
import java.util.concurrent.atomic.AtomicReference;
        ClusterService clusterService = createClusterService(threadPool);
        }
import java.util.concurrent.CountDownLatch;
            threadPool,
/*
 * You may obtain a copy of the License at
 *
    public static void setState(ClusterService clusterService, ClusterState.Builder clusterStateBuilder) {
 * license agreements. See the NOTICE file distributed with
    /**
import static junit.framework.TestCase.fail;
import org.opensearch.cluster.NodeConnectionsService;
    public static ClusterService createClusterService(ThreadPool threadPool) {
        return createClusterService(threadPool, localNode, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
    public static void setState(ClusterManagerService executor, ClusterState clusterState) {
        ClusterState initialClusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new ClusterService(settings, clusterSettings, threadPool, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE));
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "test_cluster_manager_node").build(),
                public void onSuccess(String source) {
    public static ClusterStatePublisher createClusterStatePublisher(ClusterApplier clusterApplier) {
import org.opensearch.telemetry.metrics.MetricsRegistry;
            }
            @Override
import org.opensearch.Version;
            Collections.emptyMap(),
import org.opensearch.cluster.ClusterManagerMetrics;
            publishListener.onResponse(null);
                @Override
import org.opensearch.threadpool.ThreadPool;
            settings,
        executor.submitStateUpdateTask("test setting state", new ClusterStateUpdateTask() {
 * this work for additional information regarding copyright
                }
                public void onSuccess(String source) {
    }
import java.util.Collections;
        );
import org.opensearch.cluster.ClusterStateUpdateTask;
 * not use this file except in compliance with the License.
        return (event, publishListener, ackListener) -> clusterApplier.onNewClusterState(
            new ClusterApplyListener() {
                }
        clusterService.getClusterApplierService().setInitialState(initialClusterState);
                    exception.set(e);
            "test setting state",
        clusterService.getClusterManagerService().setClusterStateSupplier(clusterService.getClusterApplierService()::state);
            OpenSearchTestCase.buildNewFakeTransportAddress(),
 * specific language governing permissions and limitations
        return createClusterManagerService(threadPool, initialClusterState);
import org.opensearch.cluster.coordination.ClusterStatePublisher;
 */
    public static ClusterService createClusterService(ThreadPool threadPool, DiscoveryNode localNode, ClusterSettings clusterSettings) {
            @Override
 * this file be licensed under the Apache-2.0 license or a
        clusterManagerService.start();
    }
import org.opensearch.node.Node;
import org.opensearch.cluster.service.ClusterApplierService;
            threadPool,
            clusterStateRef.set(event.state());
                return ClusterState.builder(clusterState).build();
import org.apache.logging.log4j.core.util.Throwables;
        clusterService.getClusterManagerService()
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            }
                public void onFailure(String source, Exception e) {
import org.opensearch.cluster.service.ClusterManagerService;
                    publishListener.onResponse(null);
            () -> event.state(),
                    publishListener.onFailure(e);
    }
            "node",
import org.opensearch.cluster.block.ClusterBlocks;
    }
        return clusterManagerService;
                fail("unexpected exception" + e);
            .setClusterStatePublisher(createClusterStatePublisher(clusterService.getClusterApplierService()));
        return clusterService;
        clusterManagerService.setClusterStateSupplier(clusterStateRef::get);
import org.opensearch.cluster.ClusterState;
    }
            }
            public ClusterState execute(ClusterState currentState) throws Exception {
            }
            () -> ClusterState.builder(clusterState).version(clusterState.version() + 1).build(),
    }
        ClusterState initialClusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
        );
            clusterSettings,
            if (exception.get() != null) {
                // don't do anything
import org.opensearch.cluster.service.ClusterApplier;
            .build();
 *
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
            }
            public void connectToNodes(DiscoveryNodes discoveryNodes, Runnable onCompletion) {
            .build();
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).clusterManagerNodeId(localNode.getId()))
        );
        ClusterService clusterService = new ClusterService(
        AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(initialClusterState);
            }
        return new NodeConnectionsService(Settings.EMPTY, null, null) {
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
}
        CountDownLatch latch = new CountDownLatch(1);
        setState(clusterService, initialState);
    public static ClusterManagerService createClusterManagerService(ThreadPool threadPool, DiscoveryNode localNode) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
 * compatible open source license.
                    latch.countDown();
            @Override
            "mock_publish_to_self[" + event.source() + "]",
 * under the License.
        clusterService.start();
import org.opensearch.cluster.service.ClusterApplier.ClusterApplyListener;
     * Sets the state on the cluster applier service
import org.opensearch.cluster.ClusterName;
            @Override
                }
        ClusterSettings clusterSettings,
/*
    }
     */
    }
        return clusterService;
        executor.onNewClusterState(
                @Override
                public void onFailure(String source, Exception e) {
            latch.await();
import org.opensearch.cluster.node.DiscoveryNodeRole;
        Settings settings = Settings.builder().put("node.name", "test").put("cluster.name", "ClusterServiceTests").build();
 * KIND, either express or implied.  See the License for the
                Throwables.rethrow(exception.get());
                // don't do anything
            latch.await();
        try {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.settings.ClusterSettings;
 * Licensed to Elasticsearch under one or more contributor
            DiscoveryNodeRole.BUILT_IN_ROLES,
        MetricsRegistry metricsRegistry
    public static ClusterService createClusterService(
        try {
    ) {
        ClusterManagerService clusterManagerService = new ClusterManagerService(
            @Override
                onCompletion.run();
            }
    public static ClusterService createClusterService(ClusterState initialState, ThreadPool threadPool) {
            throw new OpenSearchException("unexpected exception", e);
    public static void setState(ClusterService clusterService, ClusterState clusterState) {
        } catch (InterruptedException e) {
