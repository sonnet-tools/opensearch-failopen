    public static void startThreadPool() {
        assertThat(transport.capturedRequests().length, equalTo(1));
        Request request = new Request().index("test").timeout(new TimeValue(0, TimeUnit.MILLISECONDS));
    }
import java.util.Collections;
            Request::new
        action.new AsyncSingleAction(request, listener).start();
            return request.indices();
import org.opensearch.cluster.service.ClusterService;
import static org.hamcrest.core.IsEqual.equalTo;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.threadpool.ThreadPool;
        DiscoveryNode node = clusterService.state().getNodes().getLocalNode();
import java.util.concurrent.TimeoutException;
    @BeforeClass
        @Override
        transport.clear();
    public void testUnresolvableRequestDoesNotHang() throws InterruptedException, ExecutionException, TimeoutException {
import org.opensearch.core.common.io.stream.StreamInput;
        transport.clear();
        assertEquals(ResolvedIndices.of("test"), resolvedIndices);
import java.util.concurrent.TimeUnit;
        public Map<ShardId, Object> getResults() {
            TransportService transportService,
import org.opensearch.cluster.block.ClusterBlockLevel;
            x -> clusterService.localNode(),
 * compatible open source license.
import org.junit.BeforeClass;
            listener.get();
 */
        MyResolver() {
        assertThat(transport.capturedRequests().length, equalTo(1));
        listener.get();
            fail("expected ClusterBlockException");
        }
    public void tearDown() throws Exception {
            if (ExceptionsHelper.unwrap(t, TransportException.class) == null) {
import org.opensearch.common.util.concurrent.ThreadContext;
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
            }
    }
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
 *
        transportService.start();
                logger.info("expected IllegalStateException  but got ", e);
        } catch (Exception e) {
        action.new AsyncSingleAction(request, listener).start();
        action.new AsyncSingleAction(request, listener).start();
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    public void testResolveIndices() {
    public void testSuccessAfterRetryWithClusterStateUpdate() throws Exception {
        setState(clusterService, ClusterStateCreationUtils.state("test", true, ShardRoutingState.STARTED));
        setState(clusterService, ClusterStateCreationUtils.state("test", local, ShardRoutingState.STARTED));
        } catch (Exception e) {
        try {
        // trigger cluster state observer
        action.new AsyncSingleAction(request, listener).start();
        public Request(StreamInput in) throws IOException {
        transport.handleLocalError(requestId, new ConnectTransportException(node, "test exception"));
            transportService,
            requestId,
        @Override
                fail("expected ClusterBlockException");
        THREAD_POOL = null;
    public void testSuccessAfterRetryWithExceptionFromTransport() throws Exception {
    }
        transportService.acceptIncomingRequests();
        Request request = new Request().index("test");
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    class TestTransportInstanceSingleOperationAction extends TransportInstanceSingleOperationAction<Request, Response> {
    }
 * GitHub history for details.
 * under the License.
    }
        // since static must set to null to be eligible for collection
import org.opensearch.common.unit.TimeValue;
                request
        // wait until the timeout was triggered and we actually tried to send for the second time
        requestId = transport.capturedRequests()[0].requestId;
            new MyResolver(),
 * specific language governing permissions and limitations
        }
        request.shardId = new ShardId("test", "_na_", 0);
 * not use this file except in compliance with the License.
        request.shardId = new ShardId("test", "_na_", 0);
    }
            }
        @Override
        Request request = new Request().index("test");
import org.opensearch.test.transport.CapturingTransport;
import java.util.Map;
        );
            super(in);
        action.new AsyncSingleAction(request, listener).start();
import org.opensearch.core.action.ActionListener;
        assertEquals(ResolvedIndices.of("concrete_value"), resolvedIndices);
 * The OpenSearch Contributors require contributions made to
            }
    public void testResolveIndices_concreteIndex() {
    }
import org.opensearch.test.OpenSearchTestCase;
                logger.info("expected ClusterBlockException  but got ", e);
    public void setUp() throws Exception {
            }
        setState(clusterService, ClusterStateCreationUtils.state("test", true, ShardRoutingState.STARTED));
 * software distributed under the License is distributed on an
        Request request = new Request();
        transport.handleLocalError(requestId, new ConnectTransportException(node, "test exception"));
            return new Response();
import org.opensearch.cluster.node.DiscoveryNode;
    }
import org.opensearch.action.support.PlainActionFuture;
        setState(clusterService, ClusterStateCreationUtils.state("test", local, ShardRoutingState.STARTED));
    }
        transportService.close();
            NoopTracer.INSTANCE
            ActionFilters actionFilters,
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
public class TransportInstanceSingleOperationActionTests extends OpenSearchTestCase {
        assertEquals(ResolvedIndices.of("test_non_existing"), resolvedIndices);
 *    http://www.apache.org/licenses/LICENSE-2.0
        request.shardId = new ShardId("test", "_na_", 0);
        request.shardId = new ShardId("test", "_na_", 0);
 * ownership. Elasticsearch licenses this file to you under
    private TransportService transportService;
        transport.handleRemoteError(
import org.opensearch.core.index.shard.ShardId;
    }
        Request request = new Request().index("test");
/*
            fail("this should fail with a transport exception");
 * this file be licensed under the Apache-2.0 license or a
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        assertThat(transport.capturedRequests().length, equalTo(1));
        DiscoveryNode node = clusterService.state().getNodes().getLocalNode();
import org.opensearch.transport.TransportException;
    public static void destroyThreadPool() {
                logger.info("expected ConnectTransportException  but got ", t);
    class MyResolver extends IndexNameExpressionResolver {
                indexNameExpressionResolver,
import java.io.IOException;
        } catch (ExecutionException t) {
        Request request = new Request().index("test");
        request.concreteIndex("concrete_value");
            if (ExceptionsHelper.unwrap(e, IllegalStateException.class) == null) {
        );
    public void testBasicRequestWorks() throws InterruptedException, ExecutionException, TimeoutException {
            Writeable.Reader<Request> request
        @Override
            if (ExceptionsHelper.unwrap(e, ClusterBlockException.class) == null) {
    private ClusterService clusterService;
/*
import org.opensearch.cluster.routing.ShardRoutingState;
        super.setUp();
                THREAD_POOL,
        public Response(StreamInput in) throws IOException {
        boolean local = randomBoolean();
 */
        protected Response newResponse(StreamInput in) throws IOException {
        listener.get();
        }
        setState(clusterService, ClusterStateCreationUtils.state("test", randomBoolean(), ShardRoutingState.STARTED));
        } catch (ExecutionException t) {
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.TransportService;
        transport.handleResponse(transport.capturedRequests()[0].requestId, new Response());
        assertThat(transport.capturedRequests().length, equalTo(1));
        ) {
import org.opensearch.core.common.io.stream.Writeable;
        ) {
    @AfterClass
            throw new UnsupportedOperationException("Not implemented in test class");
        request.shardId = new ShardId("test", "_na_", 0);
import org.junit.Before;
        setState(clusterService, ClusterStateCreationUtils.state("test", local, ShardRoutingState.STARTED));
            listener.get();
        ClusterBlocks.Builder block = ClusterBlocks.builder()
        action.new AsyncSingleAction(request, listener).start();
    private static ThreadPool THREAD_POOL;
        request.shardId = new ShardId("test", "_na_", 0);
        protected void resolveRequest(ClusterState state, Request request) {}
        Request request = new Request().index("test");
        }
import org.opensearch.core.rest.RestStatus;
        clusterService = createClusterService(THREAD_POOL);
import java.util.concurrent.ExecutionException;
            Collections.emptySet(),
        Request request = new Request().index("test");
        setState(clusterService, ClusterStateCreationUtils.state("test", randomBoolean(), ShardRoutingState.STARTED));
            new ActionFilters(new HashSet<>()),
import org.opensearch.cluster.routing.ShardIterator;
    }
import org.opensearch.cluster.metadata.ResolvedIndices;
        }
        request.shardId = new ShardId("test_non_existing", "_na_", 0);
        assertThat(transport.capturedRequests().length, equalTo(0));
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            return clusterState.routingTable().index(request.concreteIndex()).shard(request.shardId.getId()).primaryShardIt();
 * this work for additional information regarding copyright
        assertThat(transport.capturedRequests().length, equalTo(0));
        protected String executor(ShardId shardId) {
            Request::new
import org.opensearch.ExceptionsHelper;
            super(
                transportService,
            listener.get();
            return ThreadPool.Names.SAME;
        request.shardId = new ShardId("test", "_na_", 0);
        @Override
        TestTransportInstanceSingleOperationAction(
        request.shardId = new ShardId("test", "_na_", 0);
import org.opensearch.cluster.ClusterState;
            super(new ThreadContext(Settings.EMPTY));
        };
            assertTrue(listener.isDone());
        ThreadPool.terminate(THREAD_POOL, 30, TimeUnit.SECONDS);
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        public Response() {}
        }
            // result should return immediately
                throw new IllegalStateException("request cannot be resolved");
            transportService,
        // let it fail the second time too
import org.opensearch.threadpool.TestThreadPool;
 *
            clusterService.getSettings(),
 */
    public static class Request extends InstanceShardOperationRequest<Request> {
        ResolvedIndices resolvedIndices = action.resolveIndices(request);
        try {
        setState(clusterService, ClusterStateCreationUtils.state("test", true, ShardRoutingState.STARTED));
        action = new TestTransportInstanceSingleOperationAction(
                TransportInstanceSingleOperationActionTests.this.clusterService,
        try {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        long requestId = transport.capturedRequests()[0].requestId;
 * Unless required by applicable law or agreed to in writing,
        @Override
        protected void shardOperation(Request request, ActionListener<Response> listener) {
            "indices:admin/test_unresolvable",
        }
        setState(clusterService, ClusterState.builder(clusterService.state()).blocks(block));
    public void testFailureWithoutRetry() throws Exception {
            new TransportException("a generic transport exception", new Exception("generic test exception"))
}
        }
 *
import org.opensearch.core.common.io.stream.StreamOutput;
 * KIND, either express or implied.  See the License for the
        assertThat(transport.capturedRequests().length, equalTo(1));
        super.tearDown();
        long requestId = transport.capturedRequests()[0].requestId;
        }
            }
import org.opensearch.common.settings.Settings;
        );
            fail("this should fail with a transport exception");
            listener.get();
        transport = new CapturingTransport();
                fail("expected and IllegalStateException");
        transport.handleResponse(transport.capturedRequests()[0].requestId, new Response());
        }
import org.opensearch.core.action.ActionResponse;
        Request request = new Request().index("test_non_existing");
    @After
        boolean local = randomBoolean();
import org.opensearch.cluster.block.ClusterBlocks;
            // result should return immediately
            return shards;
    public static class Response extends ActionResponse {
            super(null, in);
        setState(clusterService, ClusterStateCreationUtils.state("test", randomBoolean(), ShardRoutingState.STARTED));
        transport.clear();
            String actionName,
    @Before
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            @Override
        clusterService.close();
        // this time it should work
            new ActionFilters(new HashSet<>()),
        }
            new MyResolver(),
 * Modifications Copyright OpenSearch Contributors. See
        protected ShardIterator shards(ClusterState clusterState, Request request) {
                actionName,
        @Override
            "indices:admin/test",
        transportService = transport.createTransportService(
            if (ExceptionsHelper.unwrap(t, ConnectTransportException.class) == null) {
                fail("expected and ConnectTransportException");
        THREAD_POOL = new TestThreadPool(TransportInstanceSingleOperationActionTests.class.getSimpleName());
        transport.handleResponse(transport.capturedRequests()[0].requestId, new Response());
import org.junit.After;
        assertThat(transport.capturedRequests().length, equalTo(1));
    public void testResolveIndices_nonExisting() {
import org.junit.AfterClass;
        public void writeTo(StreamOutput out) throws IOException {}
/*
    }
                actionFilters,
        ResolvedIndices resolvedIndices = action.resolveIndices(request);
            assertTrue(listener.isDone());
                logger.info("expected TransportException  but got ", t);
import org.opensearch.cluster.block.ClusterBlock;
        // this should fail because primary not initialized
        setState(clusterService, ClusterStateCreationUtils.state("test", local, ShardRoutingState.INITIALIZING));
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            );
        try {
 * You may obtain a copy of the License at
    }
import java.util.HashSet;
            THREAD_POOL,
    }
import org.opensearch.action.support.ActionFilters;
import org.opensearch.action.IndicesRequest;
    public void testRetryOfAnAlreadyTimedOutRequest() throws Exception {
        long requestId = transport.capturedRequests()[0].requestId;
import static org.opensearch.test.ClusterServiceUtils.setState;
        Request request = new Request().index("test");
        setState(clusterService, ClusterStateCreationUtils.state("test", randomBoolean(), ShardRoutingState.STARTED));
            action.new AsyncSingleAction(request, listener).start();
        ResolvedIndices resolvedIndices = action.resolveIndices(request);
    public void testGlobalBlock() {
import org.opensearch.cluster.block.ClusterBlockException;
    private TestTransportInstanceSingleOperationAction action;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
package org.opensearch.action.support.single.instance;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.transport.ConnectTransportException;
        transport.handleLocalError(requestId, new ConnectTransportException(node, "test exception"));
        public Request() {}
            .addGlobalBlock(new ClusterBlock(1, "", false, true, false, RestStatus.SERVICE_UNAVAILABLE, ClusterBlockLevel.ALL));
        action = new TestTransportInstanceSingleOperationAction(
    private CapturingTransport transport;
    }
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            IndexNameExpressionResolver indexNameExpressionResolver,
import java.util.HashMap;
    }
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            null,
            protected void resolveRequest(ClusterState state, Request request) {
        private final Map<ShardId, Object> shards = new HashMap<>();
        listener.get();
        // this should not trigger retry or anything and the listener should report exception immediately
                fail("expected and TransportException");
    @Override
        assertBusy(() -> assertThat(transport.capturedRequests().length, equalTo(1)));
    @Override
    }
        }
    }
