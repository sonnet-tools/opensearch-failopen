import org.opensearch.plugins.PluginsService;  
                            TransportResponseHandler<T> handler
            return "test-request";  
        MockTransportService primaryTransportService = (MockTransportService) internalCluster().getInstance(  
 * You may obtain a copy of the License at  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
import org.hamcrest.Matchers;
                ACTION_NAME,
        internalCluster().startClusterManagerOnlyNodes(2);  
                doneLatch::countDown  
        client(coordinator).execute(
        }
        CountDownLatch doneLatch = new CountDownLatch(1);  
        public Request(ShardId shardId) {
            super(
                            }
import org.opensearch.action.ActionRequest;
        assertTrue(doneLatch.await(10, TimeUnit.SECONDS));
 * under the License.  
                            sender.sendRequest(connection, action, request, options, handler);  
        @Override
                shardStateAction,  
                threadPool,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                    actionWaitLatch.await(10, TimeUnit.SECONDS);
        logger.info("--> Test action {}, primary {}, replica {}", primaryTestPlugin.testActionName, primary, replica);  
import org.opensearch.transport.TransportRequest;
                                } catch (InterruptedException e) {
        public Response(StreamInput in) throws IOException {
 *
        }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            TransportService.class,
/*  
import org.opensearch.test.transport.MockTransportService;  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                            TransportRequest request,
        @Override
        private CountDownLatch actionRunningLatch = new CountDownLatch(1);
        @Override
                ActionListener.wrap(r -> assertTrue(response.compareAndSet(null, r)), e -> assertTrue(response.compareAndSet(null, e))),
                                try {  
    @Override
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {  
import java.util.concurrent.CountDownLatch;
            Request shardRequest,  
 * specific language governing permissions and limitations
            ShardStateAction shardStateAction,
                        public <T extends TransportResponse> void sendRequest(
import org.opensearch.core.common.io.stream.StreamInput;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        private volatile String testActionName;
                                }
        @Override
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
 * Unless required by applicable law or agreed to in writing,
            IndicesService indicesService,  
        }  
        public Response() {}
        public String toString() {
        String primary = internalCluster().startDataOnlyNode();
import org.opensearch.transport.TransportResponseHandler;  
    }
import org.opensearch.transport.Transport;
        // we would not hit the transport service closed case.
            return Arrays.asList(new TransportInterceptor() {  
            IndexShard primary,
public class TransportReplicationActionRetryOnClosedNodeIT extends OpenSearchIntegTestCase {  
            super(shardId);  
            return new Response(in);
        }
            TransportService transportService,
import org.opensearch.plugins.Plugin;
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
            ActionFilters actionFilters  
import org.opensearch.cluster.metadata.IndexMetadata;
    public static class Request extends ReplicationRequest<Request> {
            primary
import org.opensearch.plugins.NetworkPlugin;
        ) {
        }
                        @Override
import org.opensearch.cluster.action.shard.ShardStateAction;
    public static class Response extends ReplicationResponse {
        @Override
            Settings settings,  
        ) {  
        // we pause node after TransportService has moved to stopped, but before closing connections, since if connections are closed
            )
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        private static final ActionType<Response> TYPE = new ActionType<>(ACTION_NAME, Response::new);
                            TransportRequestOptions options,  
        primaryTestPlugin.testActionName = TestAction.ACTION_NAME + (randomBoolean() ? "[p]" : "[r]");
        AtomicReference<Object> response = new AtomicReference<>();
                assertTrue(doneLatch.await(10, TimeUnit.SECONDS));  
                @Override
import org.opensearch.test.InternalTestCluster;
            ClusterService clusterService,
 *  
import org.opensearch.cluster.service.ClusterService;  
                        }
    public void testRetryOnStoppedTransportService() throws Exception {
        }
 */  
                Request::new,  
                Request::new,
            NamedWriteableRegistry namedWriteableRegistry,  
        }
    }
        assertAcked(
            });
import java.util.Arrays;
        });
import org.opensearch.core.action.ActionListener;
 * GitHub history for details.
            );
import org.opensearch.core.index.shard.ShardId;
import java.util.concurrent.TimeUnit;  
}
    private TestPlugin getTestPlugin(String node) {
    public static class TestAction extends TransportReplicationAction<Request, Request, Response> {  
        return Arrays.asList(TestPlugin.class, MockTransportService.TestPlugin.class);
                actionFilters,
                ThreadPool.Names.GENERIC
import java.io.IOException;
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
 *
        if (response.get() instanceof Exception) {
import org.opensearch.common.util.concurrent.ThreadContext;  
import org.opensearch.indices.IndicesService;
 * KIND, either express or implied.  See the License for the
        private static final String ACTION_NAME = "internal:test-replication-action";
            primaryTestPlugin.actionWaitLatch.countDown();
import org.opensearch.transport.TransportService;
            new Request(new ShardId(resolveIndex("test"), 0)),  
        List<TestPlugin> testPlugins = pluginsService.filterPlugins(TestPlugin.class);  
import java.util.concurrent.atomic.AtomicReference;
                                    throw new AssertionError(e);  
                settings,  
            ActionListener.runAfter(
    }  
            )
        }
        ) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                public AsyncSender interceptSender(AsyncSender sender) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        String coordinator = internalCluster().startCoordinatingOnlyNode(Settings.EMPTY);  
import org.opensearch.transport.TransportRequestOptions;
        TestPlugin primaryTestPlugin = getTestPlugin(primary);  
        assertThat(testPlugins, Matchers.hasSize(1));
                clusterService,  
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.index.shard.IndexShard;
                    return new AsyncSender() {  
            listener.onResponse(new ReplicaResult());  
        String replica = internalCluster().startDataOnlyNode();
    public static class TestPlugin extends Plugin implements ActionPlugin, NetworkPlugin {
        @Override
    }
            throw new AssertionError(response.get());  
        }  
import org.opensearch.action.support.ActionFilters;  
        PluginsService pluginsService = internalCluster().getInstance(PluginsService.class, node);
 * this file be licensed under the Apache-2.0 license or a
        return testPlugins.get(0);
        );  
        public TestPlugin() {}  
                            if (action.equals(testActionName)) {
            return Arrays.asList(new ActionHandler<>(TestAction.TYPE, TestAction.class));
                                actionRunningLatch.countDown();
 */
        ensureGreen("test");
    }
            try {
        // this test only provoked an issue for the primary action, but for completeness, we pick the action randomly
        }
                    };
import org.opensearch.core.transport.TransportResponse;  
                }  
import org.opensearch.threadpool.ThreadPool;
                throw new AssertionError(e);
        public List<TransportInterceptor> getTransportInterceptors(
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
            listener.onResponse(new PrimaryResult<>(shardRequest, new Response()));
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            ThreadPool threadPool,
    }  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(primaryTestPlugin.actionRunningLatch.await(10, TimeUnit.SECONDS));
import org.opensearch.core.action.ActionResponse;
        protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
        public Request(StreamInput in) throws IOException {  
            super(in);
            } catch (InterruptedException e) {
 */  
                transportService,
            ActionListener<PrimaryResult<Request, Response>> listener
        primaryTransportService.addOnStopListener(() -> {  
                            String action,
        @Inject
import org.opensearch.plugins.ActionPlugin;  
        );
                            Transport.Connection connection,  
                        ) {
package org.opensearch.action.support.replication;
                indicesService,
        protected Response newResponseInstance(StreamInput in) throws IOException {  
        );  
                            // only activated on primary  
            prepareCreate("test").setSettings(  
            ThreadContext threadContext
        protected void shardOperationOnPrimary(
 * compatible open source license.
                    .put(indexSettings())
/*
/*  
import java.util.List;
            super(in);
        public TestAction(
        private CountDownLatch actionWaitLatch = new CountDownLatch(1);  
            }  
import org.opensearch.transport.TransportInterceptor;  
                Settings.builder()
import org.opensearch.action.ActionType;
            TestAction.TYPE,
import org.opensearch.common.inject.Inject;
        }
import java.util.Collection;  
import org.opensearch.common.settings.Settings;
