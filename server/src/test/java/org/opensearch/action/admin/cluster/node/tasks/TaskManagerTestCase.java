                    }
        }
import org.opensearch.core.common.io.stream.StreamInput;
 * You may obtain a copy of the License at
import java.util.HashSet;
        threadPool = new TestThreadPool(TransportTasksActionTests.class.getSimpleName(), runnableTaskListener);
            ) {
            ActionFilters actionFilters = new ActionFilters(emptySet());
import org.opensearch.core.common.io.stream.Writeable;
            transportService = new TransportService(
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
    public static RecordingTaskManagerListener[] setupListeners(TestNode[] nodes, String... actionMasks) {
        }
/**
                        return new MockTaskManager(settings, threadPool, taskHeaders);
    }
import org.opensearch.Version;
                threadPool,
                request,
                    settings,
import org.opensearch.action.support.nodes.BaseNodesResponse;
        for (int i = 0; i < nodes.length; i++) {
        protected NodeResponse(StreamInput in) throws IOException {
        }
            String actionName,
import org.opensearch.cluster.service.ClusterService;
                threadPool,
 * this work for additional information regarding copyright
            testNodes = null;
import org.opensearch.tasks.TaskResourceTrackingService;
        protected void writeNodesTo(StreamOutput out, List<NodeResponse> nodes) throws IOException {
        for (TestNode node : nodes) {
        }
        protected List<NodeResponse> readNodesFrom(StreamInput in) throws IOException {
        @Override
        runnableTaskListener = new AtomicReference<>();
                    Settings settings,
            transportService.getTaskManager().setTaskCancellationService(new TaskCancellationService(transportService));
        public final TransportGetTaskAction transportGetTaskAction;
                nodeA.transportService.connectToNode(nodeB.discoveryNode());
    public final void shutdownTestNodes() throws Exception {
                actionFilters,
            transportService.start();
            Writeable.Reader<NodesRequest> request,
 */
                actionName,
        }
    protected TestNode[] testNodes;
                taskResourceTrackingService
 * software distributed under the License is distributed on an
            Client mockClient = mock(Client.class);
    }
            super(clusterName, nodes, failures);
    }
import org.opensearch.action.support.ActionFilters;
import static org.opensearch.test.ClusterServiceUtils.setState;
 *
                mockClient,
        for (int i = 0; i < testNodes.length; i++) {
        for (TestNode nodeA : nodes) {
                    new NoneCircuitBreakerService(),
            };
            NamedXContentRegistry namedXContentRegistry = mock(NamedXContentRegistry.class);
                    Set<String> taskHeaders
        protected NodesResponse newResponse(NodesRequest request, List<NodeResponse> responses, List<FailedNodeException> failures) {
            testNodes[i] = new TestNode("node" + i, threadPool, settings);
import org.opensearch.threadpool.RunnableTaskExecutionListener;
        AbstractTestNodesAction(
    }
            };
     */
            transportService.acceptIncomingRequests();
            transportService.close();
            clusterService.close();
        }
    protected ThreadPool threadPool;
            final Function<BoundTransportAddress, DiscoveryNode> boundTransportAddressDiscoveryNodeFunction = address -> {
        if (testNodes != null) {
import org.opensearch.cluster.ClusterModule;
            taskResourceTrackingService = new TaskResourceTrackingService(settings, clusterService.getClusterSettings(), threadPool);
            return discoveryNode().getId();
                threadPool,
/*
        }
import org.opensearch.tasks.TaskCancellationService;
                ) {
 */
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            setState(node.clusterService, ClusterStateCreationUtils.state(node.discoveryNode(), clusterManager, discoveryNodes));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        }
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
            TransportService transportService,
                @Override
        public void close() {
                    new NetworkService(Collections.emptyList()),
        return listeners;
        extends TransportNodesAction<NodesRequest, NodesResponse, NodeRequest, NodeResponse> {
            transportListTasksAction = new TransportListTasksAction(
import org.opensearch.action.support.nodes.BaseNodesRequest;
import org.opensearch.test.OpenSearchTestCase;
import static java.util.Collections.emptySet;
package org.opensearch.action.admin.cluster.node.tasks;
        }
            clusterService = createClusterService(threadPool, discoveryNode.get());
        public DiscoveryNode discoveryNode() {
import java.util.concurrent.TimeUnit;
            );
    public static void connectNodes(TestNode... nodes) {
     * Simulates node-based task that can be used to block node tasks so they are guaranteed to be registered by task manager
                clusterService,
                transportService,
        @Override
import org.opensearch.common.util.PageCacheRecycler;
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 *
        @Override
        nodesCount = randomIntBetween(2, 10);
            super(
        @Override
 * Modifications Copyright OpenSearch Contributors. See
        }
        DiscoveryNode clusterManager = discoveryNodes[0];
import static java.util.Collections.emptyMap;
                    } else {
        protected NodeResponse(DiscoveryNode node) {
        }
    static class NodeResponse extends BaseNodeResponse {
                    PageCacheRecycler.NON_RECYCLING_INSTANCE,
            return new NodesResponse(clusterService.getClusterName(), responses, failures);
 * SPDX-License-Identifier: Apache-2.0
        }
    protected int nodesCount;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                NoopTracer.INSTANCE
        protected NodeResponse newNodeResponse(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
import java.util.concurrent.atomic.AtomicReference;
                settings,
                    NoopTracer.INSTANCE
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        public final TransportListTasksAction transportListTasksAction;
import org.opensearch.common.settings.ClusterSettings;
                null,
                actionFilters,
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.SetOnce;
    /**
import java.io.IOException;
                ThreadPool.Names.GENERIC,
                boundTransportAddressDiscoveryNodeFunction,
                testNode.close();
}
 * compatible open source license.
    }
                        return super.createTaskManager(settings, clusterSettings, threadPool, taskHeaders);
                nodeRequest,
import org.opensearch.cluster.node.DiscoveryNode;
            );
        public final ClusterService clusterService;
            return new NodeResponse(in);
        }
                    threadPool,
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                protected TaskManager createTaskManager(
        public final TransportService transportService;
            return failures().size();
        testNodes = new TestNode[nodesCount];
import org.opensearch.cluster.ClusterName;
    static class NodesResponse extends BaseNodesResponse<NodeResponse> {
        @Override
    public void setupThreadPool() {
            super(in);
            ClusterService clusterService,
                clusterService,
    @Before
                taskResourceTrackingService
                clusterService,
        public int failureCount() {
public abstract class TaskManagerTestCase extends OpenSearchTestCase {
        public final TransportCancelTasksAction transportCancelTasksAction;
            }
            );
                ),
import org.opensearch.tasks.TaskManager;
                namedXContentRegistry,
import org.opensearch.action.FailedNodeException;
import org.opensearch.test.tasks.MockTaskManager;
        }
import org.opensearch.core.common.transport.BoundTransportAddress;
import org.opensearch.threadpool.ThreadPool;
            listeners[i] = new RecordingTaskManagerListener(nodes[i].getNodeId(), actionMasks);
    @After
import org.opensearch.common.lease.Releasable;
                new ActionFilters(new HashSet<>()),
        }
import java.util.Set;
import static org.mockito.Mockito.mock;
import org.opensearch.common.settings.Settings;
import org.opensearch.action.support.nodes.TransportNodesAction;
            ThreadPool threadPool,
 * not use this file except in compliance with the License.
            Writeable.Reader<NodeRequest> nodeRequest
 * GitHub history for details.
        private final SetOnce<DiscoveryNode> discoveryNode = new SetOnce<>();
import org.junit.Before;
            for (TestNode nodeB : nodes) {
            ((MockTaskManager) (nodes[i].transportService.getTaskManager())).addListener(listeners[i]);
        public TestNode(String name, ThreadPool threadPool, Settings settings) {
    }
    protected AtomicReference<RunnableTaskExecutionListener> runnableTaskListener;
import java.util.function.Function;
 * license agreements. See the NOTICE file distributed with
        ) {
            transportGetTaskAction = new TransportGetTaskAction(
import java.util.Collections;
            out.writeList(nodes);
        public final TaskResourceTrackingService taskResourceTrackingService;
import org.junit.After;
import org.opensearch.transport.TransportService;
            transportService.getTaskManager().setTaskResourceTrackingService(taskResourceTrackingService);
            clusterService.addStateApplier(transportService.getTaskManager());
    }
        }
    abstract class AbstractTestNodesAction<NodesRequest extends BaseNodesRequest<NodesRequest>, NodeRequest extends TransportRequest>
 */
 */
import org.opensearch.transport.TransportRequest;
            transportCancelTasksAction = new TransportCancelTasksAction(clusterService, transportService, actionFilters);
        }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.network.NetworkService;
        threadPool = null;
            for (TestNode testNode : testNodes) {
            discoveryNodes[i] = nodes[i].discoveryNode();
                    ClusterSettings clusterSettings,
import org.opensearch.transport.client.Client;
        protected abstract NodeResponse nodeOperation(NodeRequest request);
/*
    public static class TestNode implements Releasable {
                NodeResponse.class
import org.opensearch.action.admin.cluster.node.tasks.cancel.TransportCancelTasksAction;
 * specific language governing permissions and limitations
                }
import org.opensearch.action.admin.cluster.node.tasks.get.TransportGetTaskAction;
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.cluster.node.tasks.list.TransportListTasksAction;
            super(node);
    public void setupTestNodes(Settings settings) {
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                return discoveryNode.get();
                    if (MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING.get(settings)) {
 * ownership. Elasticsearch licenses this file to you under
        public String getNodeId() {
        RecordingTaskManagerListener[] listeners = new RecordingTaskManagerListener[nodes.length];
 * under the License.
/*
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
 *
        for (int i = 0; i < nodes.length; i++) {
            return in.readList(NodeResponse::new);
 * The test case for unit testing task manager and related transport actions
import org.opensearch.core.common.io.stream.StreamOutput;
                transportService,
                Collections.emptySet(),
                new MockNioTransport(
                discoveryNode.set(new DiscoveryNode(name, address.publishAddress(), emptyMap(), emptySet(), Version.CURRENT));
        @Override
        protected NodesResponse(ClusterName clusterName, List<NodeResponse> nodes, List<FailedNodeException> failures) {
    }
 * this file be licensed under the Apache-2.0 license or a
                    ThreadPool threadPool,
import org.opensearch.transport.nio.MockNioTransport;
                    Version.CURRENT,
import org.opensearch.action.support.nodes.BaseNodeResponse;
import org.opensearch.threadpool.TestThreadPool;
                    new NamedWriteableRegistry(ClusterModule.getNamedWriteables()),
            return discoveryNode.get();
        DiscoveryNode[] discoveryNodes = new DiscoveryNode[nodes.length];
                transportService,
        }
