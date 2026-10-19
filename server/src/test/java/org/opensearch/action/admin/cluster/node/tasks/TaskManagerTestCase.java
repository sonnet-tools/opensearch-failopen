            for (TestNode nodeB : nodes) {
                }
                transportService,
        public final TaskResourceTrackingService taskResourceTrackingService;
            );
import org.opensearch.transport.TransportService;
import java.util.function.Function;  
                NoopTracer.INSTANCE  
                transportService,
import org.opensearch.cluster.ClusterModule;
        protected NodeResponse newNodeResponse(StreamInput in) throws IOException {
 * software distributed under the License is distributed on an
                mockClient,
                clusterService,  
        RecordingTaskManagerListener[] listeners = new RecordingTaskManagerListener[nodes.length];  
            transportService.getTaskManager().setTaskCancellationService(new TaskCancellationService(transportService));
        }  
    public void setupTestNodes(Settings settings) {  
        testNodes = new TestNode[nodesCount];
            transportService.acceptIncomingRequests();
     * Simulates node-based task that can be used to block node tasks so they are guaranteed to be registered by task manager
                    if (MockTaskManager.USE_MOCK_TASK_MANAGER_SETTING.get(settings)) {  
import org.opensearch.tasks.TaskManager;
        for (TestNode nodeA : nodes) {
import org.opensearch.common.SetOnce;  
        public void close() {
        public int failureCount() {
                @Override
        @Override
        }  
                new ActionFilters(new HashSet<>()),
import org.opensearch.cluster.node.DiscoveryNode;
        public final TransportListTasksAction transportListTasksAction;  
                actionFilters,
        nodesCount = randomIntBetween(2, 10);
        protected List<NodeResponse> readNodesFrom(StreamInput in) throws IOException {
        for (int i = 0; i < nodes.length; i++) {
 */
            transportService.close();
        }  
        extends TransportNodesAction<NodesRequest, NodesResponse, NodeRequest, NodeResponse> {
 * KIND, either express or implied.  See the License for the
import java.util.Set;  
            Client mockClient = mock(Client.class);  
        protected NodesResponse(ClusterName clusterName, List<NodeResponse> nodes, List<FailedNodeException> failures) {  
            super(  
    }  
        for (TestNode node : nodes) {
public abstract class TaskManagerTestCase extends OpenSearchTestCase {
            transportGetTaskAction = new TransportGetTaskAction(
            }
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
                    }
import java.util.HashSet;
import org.opensearch.action.FailedNodeException;
            String actionName,
                    } else {
 * Unless required by applicable law or agreed to in writing,
                null,
        protected NodeResponse(StreamInput in) throws IOException {
            for (TestNode testNode : testNodes) {
import org.opensearch.transport.nio.MockNioTransport;
                nodeA.transportService.connectToNode(nodeB.discoveryNode());  
        }
 * The OpenSearch Contributors require contributions made to  
        }
        protected NodeResponse(DiscoveryNode node) {
            ThreadPool threadPool,  
import static java.util.Collections.emptyMap;
import org.opensearch.common.settings.Settings;
 *
            );
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ActionFilters actionFilters = new ActionFilters(emptySet());
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            transportService.start();
                boundTransportAddressDiscoveryNodeFunction,  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        }  
}
            clusterService = createClusterService(threadPool, discoveryNode.get());  
        }  
    public final void shutdownTestNodes() throws Exception {  
import org.opensearch.test.tasks.MockTaskManager;  
        AbstractTestNodesAction(
    protected AtomicReference<RunnableTaskExecutionListener> runnableTaskListener;
    public static RecordingTaskManagerListener[] setupListeners(TestNode[] nodes, String... actionMasks) {
import org.opensearch.action.support.nodes.BaseNodeResponse;  
        return listeners;
                taskResourceTrackingService  
import static java.util.Collections.emptySet;  
        }
    }  
            ClusterService clusterService,
import org.junit.Before;  
    @After
            Writeable.Reader<NodesRequest> request,  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.common.util.PageCacheRecycler;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                threadPool,  
        @Override  
                TransportService.NOOP_TRANSPORT_INTERCEPTOR,
    static class NodesResponse extends BaseNodesResponse<NodeResponse> {
import org.opensearch.transport.client.Client;  
                protected TaskManager createTaskManager(  
            testNodes = null;
            return discoveryNode().getId();
                clusterService,  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
    public static class TestNode implements Releasable {
        }
            testNodes[i] = new TestNode("node" + i, threadPool, settings);
                nodeRequest,
                new MockNioTransport(  
        if (testNodes != null) {
    protected TestNode[] testNodes;
        }
            ) {
            }
            clusterService.close();  
                threadPool,
import java.io.IOException;
/*
            out.writeList(nodes);
                    ClusterSettings clusterSettings,
/**
import org.opensearch.tasks.TaskCancellationService;
                    settings,
        }
            return in.readList(NodeResponse::new);  
        @Override
import org.opensearch.action.support.nodes.BaseNodesRequest;
                    new NamedWriteableRegistry(ClusterModule.getNamedWriteables()),  
                namedXContentRegistry,
        runnableTaskListener = new AtomicReference<>();
        }
                        return super.createTaskManager(settings, clusterSettings, threadPool, taskHeaders);  
    }
            clusterService.addStateApplier(transportService.getTaskManager());
    abstract class AbstractTestNodesAction<NodesRequest extends BaseNodesRequest<NodesRequest>, NodeRequest extends TransportRequest>
                    new NetworkService(Collections.emptyList()),
                ThreadPool.Names.GENERIC,
import org.opensearch.common.network.NetworkService;
                    PageCacheRecycler.NON_RECYCLING_INSTANCE,
    @Before  
                        return new MockTaskManager(settings, threadPool, taskHeaders);
            setState(node.clusterService, ClusterStateCreationUtils.state(node.discoveryNode(), clusterManager, discoveryNodes));
                actionName,
import org.junit.After;
                request,  
                NodeResponse.class  
import org.opensearch.action.support.ActionFilters;
                ),  
            transportListTasksAction = new TransportListTasksAction(
            };  
            NamedXContentRegistry namedXContentRegistry = mock(NamedXContentRegistry.class);
        DiscoveryNode clusterManager = discoveryNodes[0];  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                    Set<String> taskHeaders
        private final SetOnce<DiscoveryNode> discoveryNode = new SetOnce<>();
                    NoopTracer.INSTANCE
        for (int i = 0; i < nodes.length; i++) {  
            ((MockTaskManager) (nodes[i].transportService.getTaskManager())).addListener(listeners[i]);  
        @Override
        public final TransportGetTaskAction transportGetTaskAction;
        protected NodesResponse newResponse(NodesRequest request, List<NodeResponse> responses, List<FailedNodeException> failures) {
 * license agreements. See the NOTICE file distributed with
            };  
    protected ThreadPool threadPool;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
    }
                    Version.CURRENT,
/*
import org.opensearch.cluster.ClusterName;  
            listeners[i] = new RecordingTaskManagerListener(nodes[i].getNodeId(), actionMasks);
import org.opensearch.action.admin.cluster.node.tasks.get.TransportGetTaskAction;  
import java.util.Collections;  
 * GitHub history for details.
                    Settings settings,
        }  
        }
                    threadPool,  
            return new NodeResponse(in);
import org.opensearch.Version;  
                testNode.close();  
import org.opensearch.common.settings.ClusterSettings;  
 *
        protected abstract NodeResponse nodeOperation(NodeRequest request);  
import static org.mockito.Mockito.mock;  
                threadPool,
        public final ClusterService clusterService;
import org.opensearch.threadpool.TestThreadPool;
 * The test case for unit testing task manager and related transport actions  
import org.opensearch.common.lease.Releasable;
     */  
 *  
                actionFilters,
            transportCancelTasksAction = new TransportCancelTasksAction(clusterService, transportService, actionFilters);
import static org.opensearch.test.ClusterServiceUtils.setState;
            discoveryNodes[i] = nodes[i].discoveryNode();
    }  
import java.util.List;
            return failures().size();  
        for (int i = 0; i < testNodes.length; i++) {  
        protected void writeNodesTo(StreamOutput out, List<NodeResponse> nodes) throws IOException {
 * compatible open source license.
import org.opensearch.core.common.io.stream.Writeable;  
        threadPool = null;
import org.opensearch.action.support.nodes.BaseNodesResponse;
        }
            transportService = new TransportService(
            taskResourceTrackingService = new TaskResourceTrackingService(settings, clusterService.getClusterSettings(), threadPool);
import org.opensearch.cluster.service.ClusterService;
            TransportService transportService,
 * not use this file except in compliance with the License.
import org.opensearch.tasks.TaskResourceTrackingService;  
            );
 */
        }  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
                transportService,
 * Modifications Copyright OpenSearch Contributors. See  
    /**
        public TestNode(String name, ThreadPool threadPool, Settings settings) {
 * under the License.  
        public String getNodeId() {
    }
package org.opensearch.action.admin.cluster.node.tasks;
 */
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.transport.TransportRequest;
            transportService.getTaskManager().setTaskResourceTrackingService(taskResourceTrackingService);  
        }
        ) {
 * specific language governing permissions and limitations
                    ThreadPool threadPool,  
            return new NodesResponse(clusterService.getClusterName(), responses, failures);  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.action.admin.cluster.node.tasks.cancel.TransportCancelTasksAction;
            return discoveryNode.get();  
            super(node);  
    static class NodeResponse extends BaseNodeResponse {
            super(clusterName, nodes, failures);
        threadPool = new TestThreadPool(TransportTasksActionTests.class.getSimpleName(), runnableTaskListener);  
import org.opensearch.action.support.nodes.TransportNodesAction;  
        public final TransportService transportService;  
                taskResourceTrackingService  
 * this work for additional information regarding copyright
import org.opensearch.threadpool.ThreadPool;  
    public static void connectNodes(TestNode... nodes) {
                discoveryNode.set(new DiscoveryNode(name, address.publishAddress(), emptyMap(), emptySet(), Version.CURRENT));
            final Function<BoundTransportAddress, DiscoveryNode> boundTransportAddressDiscoveryNodeFunction = address -> {  
        DiscoveryNode[] discoveryNodes = new DiscoveryNode[nodes.length];
                clusterService,  
    public void setupThreadPool() {
                Collections.emptySet(),
                return discoveryNode.get();
                ) {
                    new NoneCircuitBreakerService(),
        }
/*  
            super(in);
    }
import org.opensearch.core.common.transport.BoundTransportAddress;
        public DiscoveryNode discoveryNode() {
    protected int nodesCount;  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
import java.util.concurrent.atomic.AtomicReference;
    }
import java.util.concurrent.TimeUnit;
import org.opensearch.threadpool.RunnableTaskExecutionListener;
        public final TransportCancelTasksAction transportCancelTasksAction;
 * You may obtain a copy of the License at  
                settings,
            Writeable.Reader<NodeRequest> nodeRequest
        @Override  
        @Override
        }
import org.opensearch.action.admin.cluster.node.tasks.list.TransportListTasksAction;
