import java.io.IOException;
                            if (action.equals(testActionName)) {
        internalCluster().startClusterManagerOnlyNodes(2);
                ACTION_NAME,
                threadPool,
        ) {
            );
import org.opensearch.cluster.action.shard.ShardStateAction;
                                } catch (InterruptedException e) {
import org.opensearch.common.inject.Inject;
                                }
                Settings.builder()
        assertTrue(doneLatch.await(10, TimeUnit.SECONDS));
import org.opensearch.threadpool.ThreadPool;
            super(in);
            return Arrays.asList(new TransportInterceptor() {
        // we pause node after TransportService has moved to stopped, but before closing connections, since if connections are closed
        protected Response newResponseInstance(StreamInput in) throws IOException {
                actionFilters,
            )
 * Modifications Copyright OpenSearch Contributors. See
                public AsyncSender interceptSender(AsyncSender sender) {
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.core.common.io.stream.StreamInput;
        private static final ActionType<Response> TYPE = new ActionType<>(ACTION_NAME, Response::new);
import java.util.Arrays;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        private static final String ACTION_NAME = "internal:test-replication-action";
 */
            new Request(new ShardId(resolveIndex("test"), 0)),
        public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
        assertTrue(primaryTestPlugin.actionRunningLatch.await(10, TimeUnit.SECONDS));
                shardStateAction,
            ActionListener.runAfter(
        primaryTransportService.addOnStopListener(() -> {
            } catch (InterruptedException e) {
import org.opensearch.common.util.concurrent.ThreadContext;
        });
import org.opensearch.plugins.PluginsService;
            ThreadPool threadPool,
            return "test-request";
import java.util.concurrent.CountDownLatch;
 * You may obtain a copy of the License at
    public static class TestPlugin extends Plugin implements ActionPlugin, NetworkPlugin {
                        @Override
                            }
import org.opensearch.transport.TransportService;
import java.util.Collection;
        AtomicReference<Object> response = new AtomicReference<>();
import org.opensearch.cluster.service.ClusterService;
                            TransportRequest request,
        protected void shardOperationOnPrimary(
                        ) {
import org.opensearch.action.support.ActionFilters;
import org.opensearch.core.action.ActionResponse;
    private TestPlugin getTestPlugin(String node) {
    }
        String primary = internalCluster().startDataOnlyNode();
 * this work for additional information regarding copyright
        );
                ActionListener.wrap(r -> assertTrue(response.compareAndSet(null, r)), e -> assertTrue(response.compareAndSet(null, e))),
            primaryTestPlugin.actionWaitLatch.countDown();
        public Request(ShardId shardId) {
            TransportService.class,
        }
    }
        );
        @Override
/*
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            IndexShard primary,
            Settings settings,
        public String toString() {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.transport.TransportResponse;
    @Override
            super(shardId);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
        PluginsService pluginsService = internalCluster().getInstance(PluginsService.class, node);
    }
        private CountDownLatch actionRunningLatch = new CountDownLatch(1);
import java.util.concurrent.TimeUnit;
import java.util.List;
 */
import org.opensearch.index.shard.IndexShard;
        if (response.get() instanceof Exception) {
import org.opensearch.plugins.ActionPlugin;
        @Override
        }
 *
                transportService,
            TransportService transportService,
 *
import org.opensearch.plugins.NetworkPlugin;
import org.opensearch.cluster.metadata.IndexMetadata;
                            Transport.Connection connection,
        }
                        public <T extends TransportResponse> void sendRequest(
                assertTrue(doneLatch.await(10, TimeUnit.SECONDS));
        // this test only provoked an issue for the primary action, but for completeness, we pick the action randomly
import org.opensearch.test.OpenSearchIntegTestCase;
        TestPlugin primaryTestPlugin = getTestPlugin(primary);
        ) {
import org.opensearch.test.transport.MockTransportService;
    }
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            try {
        @Override
        public TestAction(
        // we would not hit the transport service closed case.
                                    throw new AssertionError(e);
            )
package org.opensearch.action.support.replication;
        List<TestPlugin> testPlugins = pluginsService.filterPlugins(TestPlugin.class);
        }
                    return new AsyncSender() {
                ThreadPool.Names.GENERIC
import org.opensearch.test.InternalTestCluster;
import org.opensearch.core.action.ActionListener;
        @Override
import org.opensearch.transport.TransportRequestOptions;
        return testPlugins.get(0);
 * GitHub history for details.
        MockTransportService primaryTransportService = (MockTransportService) internalCluster().getInstance(
 * under the License.
    public static class TestAction extends TransportReplicationAction<Request, Request, Response> {
                            TransportRequestOptions options,
 * ownership. Elasticsearch licenses this file to you under
            ThreadContext threadContext
public class TransportReplicationActionRetryOnClosedNodeIT extends OpenSearchIntegTestCase {
 * not use this file except in compliance with the License.
                            TransportResponseHandler<T> handler
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            NamedWriteableRegistry namedWriteableRegistry,
        ) {
                indicesService,
import org.opensearch.action.ActionType;
import org.opensearch.transport.Transport;
            ClusterService clusterService,
import org.opensearch.action.ActionRequest;
 * SPDX-License-Identifier: Apache-2.0
        public Response(StreamInput in) throws IOException {
                settings,
 * specific language governing permissions and limitations
    public static class Response extends ReplicationResponse {
 */
 * the Apache License, Version 2.0 (the "License"); you may
                throw new AssertionError(e);
    public static class Request extends ReplicationRequest<Request> {
            TestAction.TYPE,
        public Response() {}
            }
                        }
                            String action,
 * Licensed to Elasticsearch under one or more contributor
        String coordinator = internalCluster().startCoordinatingOnlyNode(Settings.EMPTY);
        }
        primaryTestPlugin.testActionName = TestAction.ACTION_NAME + (randomBoolean() ? "[p]" : "[r]");
        @Override
            ShardStateAction shardStateAction,
        private volatile String testActionName;
            Request shardRequest,
            listener.onResponse(new PrimaryResult<>(shardRequest, new Response()));
        public Request(StreamInput in) throws IOException {
        String replica = internalCluster().startDataOnlyNode();
    }
/*
        ensureGreen("test");
import org.opensearch.indices.IndicesService;
import org.opensearch.plugins.Plugin;
        client(coordinator).execute(
            return new Response(in);
                doneLatch::countDown
        }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            IndicesService indicesService,
 * license agreements. See the NOTICE file distributed with
                                try {
import org.opensearch.common.settings.Settings;
 * software distributed under the License is distributed on an
                    };
            return Arrays.asList(new ActionHandler<>(TestAction.TYPE, TestAction.class));
                clusterService,
 * Unless required by applicable law or agreed to in writing,
            });
            throw new AssertionError(response.get());
                @Override
            super(in);
    public void testRetryOnStoppedTransportService() throws Exception {
import org.opensearch.transport.TransportInterceptor;
        return Arrays.asList(TestPlugin.class, MockTransportService.TestPlugin.class);
    }
            prepareCreate("test").setSettings(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            // only activated on primary
        }
            super(
        }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
}
 * this file be licensed under the Apache-2.0 license or a
        public TestPlugin() {}
import org.opensearch.transport.TransportRequest;
        assertThat(testPlugins, Matchers.hasSize(1));
            ActionListener<PrimaryResult<Request, Response>> listener
        assertAcked(
                                actionRunningLatch.countDown();
            ActionFilters actionFilters
        public List<TransportInterceptor> getTransportInterceptors(
                Request::new,
            listener.onResponse(new ReplicaResult());
        CountDownLatch doneLatch = new CountDownLatch(1);
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        @Inject
        logger.info("--> Test action {}, primary {}, replica {}", primaryTestPlugin.testActionName, primary, replica);
                                    actionWaitLatch.await(10, TimeUnit.SECONDS);
        @Override
        );
        private CountDownLatch actionWaitLatch = new CountDownLatch(1);
        }
import org.hamcrest.Matchers;
import org.opensearch.transport.TransportResponseHandler;
                }
                            sender.sendRequest(connection, action, request, options, handler);
        protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
 * KIND, either express or implied.  See the License for the
                    .put(indexSettings())
 * compatible open source license.
            primary
                Request::new,
/*
