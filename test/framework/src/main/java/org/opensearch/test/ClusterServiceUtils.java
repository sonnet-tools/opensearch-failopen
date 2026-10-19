import org.opensearch.cluster.ClusterManagerMetrics;  
            .setClusterStatePublisher(createClusterStatePublisher(clusterService.getClusterApplierService()));
        });  
public class ClusterServiceUtils {
import org.opensearch.cluster.node.DiscoveryNodeRole;
 * this work for additional information regarding copyright
            .build();  
            public void disconnectFromNodesExcept(DiscoveryNodes nodesToKeep) {  
            () -> event.state(),  
        } catch (InterruptedException e) {
            threadPool,
import org.opensearch.cluster.service.ClusterApplier;
            Collections.emptyMap(),  
        Settings settings = Settings.builder().put("node.name", "test").put("cluster.name", "ClusterServiceTests").build();  
            clusterStateRef.set(event.state());  
        DiscoveryNode discoveryNode = new DiscoveryNode(  
        };  
                public void onFailure(String source, Exception e) {
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.cluster.ClusterStateUpdateTask;  
            public void onFailure(String source, Exception e) {  
 */  
    public static void setState(ClusterService clusterService, ClusterState clusterState) {
                    publishListener.onResponse(null);
            "mock_publish_to_self[" + event.source() + "]",
 *
            }
            @Override
 * SPDX-License-Identifier: Apache-2.0
        );  
                @Override
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
import org.opensearch.OpenSearchException;
        });
        clusterManagerService.start();
 * not use this file except in compliance with the License.
        return createClusterManagerService(threadPool, initialClusterState);
                    latch.countDown();
                // don't do anything
 * The OpenSearch Contributors require contributions made to  
            publishListener.onResponse(null);
 * the Apache License, Version 2.0 (the "License"); you may
        try {
 * GitHub history for details.
                fail("unexpected exception" + e);
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
import org.opensearch.cluster.ClusterState;
    }
            OpenSearchTestCase.buildNewFakeTransportAddress(),
            }
        ThreadPool threadPool,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static void setState(ClusterApplierService executor, ClusterState clusterState) {
            throw new OpenSearchException("unexpected interruption", e);
                public void onSuccess(String source) {  
 *
        setState(clusterService, clusterStateBuilder.build());
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        clusterService.getClusterApplierService().setInitialState(initialClusterState);  
import org.opensearch.cluster.block.ClusterBlocks;
/*  
import org.opensearch.cluster.service.ClusterManagerService;
        }
                public void onFailure(String source, Exception e) {
import org.opensearch.cluster.service.ClusterApplier.ClusterApplyListener;
        ClusterService clusterService = new ClusterService(
                    publishListener.onFailure(e);  
                Throwables.rethrow(exception.get());
            "test setting state",
        AtomicReference<Exception> exception = new AtomicReference<>();  
import org.opensearch.cluster.ClusterName;
    /**
import org.opensearch.cluster.service.ClusterService;
            "node",
        );
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "test_cluster_manager_node").build(),
     */  
            @Override  
        );  
        ClusterState initialClusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
    public static ClusterService createClusterService(ThreadPool threadPool, DiscoveryNode localNode, ClusterSettings clusterSettings) {
            }
        return clusterService;  
import org.opensearch.node.Node;
 * Unless required by applicable law or agreed to in writing,
            public void connectToNodes(DiscoveryNodes discoveryNodes, Runnable onCompletion) {  
                }
                }
    ) {
                }
            threadPool,
                return ClusterState.builder(clusterState).build();  
    }  
        setState(clusterService, initialState);
                latch.countDown();
                // make sure we increment versions as listener may depend on it for change
import org.opensearch.common.settings.ClusterSettings;  
            @Override
            clusterSettings,  
        return new ClusterService(settings, clusterSettings, threadPool, new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE));  
        AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(initialClusterState);
            latch.await();  
 * under the License.  
            settings,
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
    }
    }
    }  
        MetricsRegistry metricsRegistry
        ClusterSettings clusterSettings,  
        clusterManagerService.setClusterStateSupplier(clusterStateRef::get);  
        ClusterService clusterService = createClusterService(threadPool);
                @Override
            Version.CURRENT
    public static ClusterService createClusterService(  
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
        );  
        try {
        return createClusterService(threadPool, localNode, clusterSettings, NoopMetricsRegistry.INSTANCE);  
import org.opensearch.cluster.node.DiscoveryNode;
        }  
            public ClusterState execute(ClusterState currentState) throws Exception {
            }  
        return clusterManagerService;
 * software distributed under the License is distributed on an
    }  
    public static void setState(ClusterManagerService executor, ClusterState clusterState) {  
            new ClusterManagerMetrics(metricsRegistry)
}
import org.opensearch.cluster.NodeConnectionsService;
                    exception.set(e);  
            DiscoveryNodeRole.BUILT_IN_ROLES,
        ClusterState initialClusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))  
        clusterService.getClusterManagerService()
/*
 */
        clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
     * Sets the state on the cluster applier service
            latch.await();
    public static ClusterService createClusterService(ClusterState initialState, ThreadPool threadPool) {  
        ClusterManagerService clusterManagerService = new ClusterManagerService(
import static junit.framework.TestCase.fail;
 * You may obtain a copy of the License at  
 * compatible open source license.
    }
        setState(clusterService.getClusterApplierService(), clusterState);
 */
            .build();
        return new NodeConnectionsService(Settings.EMPTY, null, null) {
package org.opensearch.test;
            () -> ClusterState.builder(clusterState).version(clusterState.version() + 1).build(),  
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).clusterManagerNodeId(localNode.getId()))  
        clusterService.setNodeConnectionsService(createNoOpNodeConnectionsService());
import org.opensearch.threadpool.ThreadPool;
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    public static ClusterService createClusterService(ThreadPool threadPool) {
            }  
 * specific language governing permissions and limitations
import org.opensearch.cluster.service.ClusterApplierService;  
    public static ClusterService createClusterService(Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {
import org.opensearch.cluster.coordination.ClusterStatePublisher;  
                }
    public static ClusterManagerService createClusterManagerService(ThreadPool threadPool, ClusterState initialClusterState) {  
            throw new OpenSearchException("unexpected exception", e);
        clusterService.getClusterManagerService().setClusterStateSupplier(clusterService.getClusterApplierService()::state);  
    }
            new ClusterApplyListener() {
    public static NodeConnectionsService createNoOpNodeConnectionsService() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                onCompletion.run();
    }  
 * this file be licensed under the Apache-2.0 license or a
        executor.onNewClusterState(
                // don't do anything
                    latch.countDown();
import org.opensearch.cluster.node.DiscoveryNodes;  
/*
        return createClusterService(threadPool, localNode, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
import org.opensearch.telemetry.metrics.MetricsRegistry;  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * license agreements. See the NOTICE file distributed with
        );  
            @Override  
import java.util.concurrent.CountDownLatch;
        return (event, publishListener, ackListener) -> clusterApplier.onNewClusterState(
                @Override
                public void onSuccess(String source) {  
 * KIND, either express or implied.  See the License for the
            if (exception.get() != null) {
            }  
            new ClusterApplyListener() {
    public static ClusterStatePublisher createClusterStatePublisher(ClusterApplier clusterApplier) {  
        executor.submitStateUpdateTask("test setting state", new ClusterStateUpdateTask() {
    }
 * ownership. Elasticsearch licenses this file to you under  
    }
        CountDownLatch latch = new CountDownLatch(1);
import org.apache.logging.log4j.core.util.Throwables;  
        } catch (InterruptedException e) {  
        return clusterService;
            }
        DiscoveryNode localNode,
    }
    public static ClusterService createClusterService(ThreadPool threadPool, DiscoveryNode localNode) {
            @Override
                @Override
    }
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).clusterManagerNodeId(localNode.getId()))
import org.opensearch.common.settings.Settings;
import org.opensearch.Version;
    }  
import java.util.concurrent.atomic.AtomicReference;  
import java.util.Collections;
    public static void setState(ClusterService clusterService, ClusterState.Builder clusterStateBuilder) {  
            }  
    public static ClusterManagerService createClusterManagerService(ThreadPool threadPool, DiscoveryNode localNode) {
        return createClusterService(threadPool, discoveryNode);
        CountDownLatch latch = new CountDownLatch(1);
        clusterService.start();
