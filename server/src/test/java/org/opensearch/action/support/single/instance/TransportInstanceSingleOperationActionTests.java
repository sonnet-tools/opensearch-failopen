    @BeforeClass
        setState(clusterService, ClusterStateCreationUtils.state("test", randomBoolean(), ShardRoutingState.STARTED));
import java.util.concurrent.TimeUnit;
        super.setUp();  
    public void testResolveIndices_concreteIndex() {
        action = new TestTransportInstanceSingleOperationAction(
        long requestId = transport.capturedRequests()[0].requestId;  
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
                fail("expected and IllegalStateException");  
                actionName,  
    private TestTransportInstanceSingleOperationAction action;
    private ClusterService clusterService;  
        long requestId = transport.capturedRequests()[0].requestId;  
        );  
    private static ThreadPool THREAD_POOL;
        ) {
import java.util.concurrent.TimeoutException;
import org.opensearch.core.action.ActionResponse;  
        transport.handleResponse(transport.capturedRequests()[0].requestId, new Response());  
 * KIND, either express or implied.  See the License for the
            }
        }
            assertTrue(listener.isDone());
        request.shardId = new ShardId("test", "_na_", 0);
        assertBusy(() -> assertThat(transport.capturedRequests().length, equalTo(1)));  
import org.opensearch.ExceptionsHelper;
        PlainActionFuture<Response> listener = new PlainActionFuture<>();  
import org.opensearch.common.settings.Settings;
        assertThat(transport.capturedRequests().length, equalTo(0));
    public void setUp() throws Exception {
        super.tearDown();
            fail("this should fail with a transport exception");  
 * Modifications Copyright OpenSearch Contributors. See
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
            null,
package org.opensearch.action.support.single.instance;
        Request request = new Request().index("test");
    public static void destroyThreadPool() {
            Request::new
        request.shardId = new ShardId("test", "_na_", 0);
    @Override  
        transportService = transport.createTransportService(  
        // since static must set to null to be eligible for collection
                fail("expected ClusterBlockException");  
            super(in);  
        action.new AsyncSingleAction(request, listener).start();
        action.new AsyncSingleAction(request, listener).start();
            return new Response();
 * SPDX-License-Identifier: Apache-2.0
                throw new IllegalStateException("request cannot be resolved");
        assertEquals(ResolvedIndices.of("test_non_existing"), resolvedIndices);  
            new MyResolver(),  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        transport.handleLocalError(requestId, new ConnectTransportException(node, "test exception"));  
    }
        @Override  
        setState(clusterService, ClusterStateCreationUtils.state("test", true, ShardRoutingState.STARTED));
 *    http://www.apache.org/licenses/LICENSE-2.0
        PlainActionFuture<Response> listener = new PlainActionFuture<>();  
import java.util.Map;
        try {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
            fail("expected ClusterBlockException");
        request.shardId = new ShardId("test", "_na_", 0);  
    public void testResolveIndices_nonExisting() {
        clusterService.close();  
            return request.indices();  
    class TestTransportInstanceSingleOperationAction extends TransportInstanceSingleOperationAction<Request, Response> {
import org.opensearch.cluster.node.DiscoveryNode;
            String actionName,
        transport.handleResponse(transport.capturedRequests()[0].requestId, new Response());  
        setState(clusterService, ClusterState.builder(clusterService.state()).blocks(block));
import org.opensearch.cluster.block.ClusterBlockLevel;  
    public void tearDown() throws Exception {
 * Unless required by applicable law or agreed to in writing,
        } catch (Exception e) {  
 */  
 * The OpenSearch Contributors require contributions made to  
            TransportService transportService,  
            NoopTracer.INSTANCE
    }
import org.opensearch.cluster.routing.ShardIterator;
        private final Map<ShardId, Object> shards = new HashMap<>();
        listener.get();
        }
                logger.info("expected TransportException  but got ", t);  
        transport = new CapturingTransport();
            .addGlobalBlock(new ClusterBlock(1, "", false, true, false, RestStatus.SERVICE_UNAVAILABLE, ClusterBlockLevel.ALL));  
            return shards;
        boolean local = randomBoolean();
import org.opensearch.core.rest.RestStatus;
            if (ExceptionsHelper.unwrap(e, IllegalStateException.class) == null) {
        setState(clusterService, ClusterStateCreationUtils.state("test", true, ShardRoutingState.STARTED));
        action.new AsyncSingleAction(request, listener).start();
import org.opensearch.threadpool.ThreadPool;
            @Override
        public Map<ShardId, Object> getResults() {
    public void testRetryOfAnAlreadyTimedOutRequest() throws Exception {
        // this should not trigger retry or anything and the listener should report exception immediately
        action = new TestTransportInstanceSingleOperationAction(
    }
        assertThat(transport.capturedRequests().length, equalTo(1));
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        protected ShardIterator shards(ClusterState clusterState, Request request) {  
 * GitHub history for details.
            ActionFilters actionFilters,
        setState(clusterService, ClusterStateCreationUtils.state("test", local, ShardRoutingState.STARTED));  
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
                actionFilters,
        ThreadPool.terminate(THREAD_POOL, 30, TimeUnit.SECONDS);  
        TestTransportInstanceSingleOperationAction(
    }
        Request request = new Request().index("test");
        ResolvedIndices resolvedIndices = action.resolveIndices(request);  
    public static class Response extends ActionResponse {
        } catch (Exception e) {  
    public static void startThreadPool() {
        request.shardId = new ShardId("test", "_na_", 0);  
    }
            super(null, in);
            );
        Request request = new Request().index("test");
        transport.handleLocalError(requestId, new ConnectTransportException(node, "test exception"));  
        request.shardId = new ShardId("test", "_na_", 0);
        // trigger cluster state observer
        protected void shardOperation(Request request, ActionListener<Response> listener) {
            new TransportException("a generic transport exception", new Exception("generic test exception"))
                logger.info("expected ConnectTransportException  but got ", t);  
        setState(clusterService, ClusterStateCreationUtils.state("test", true, ShardRoutingState.STARTED));
        transport.handleRemoteError(  
            // result should return immediately  
        public void writeTo(StreamOutput out) throws IOException {}
        transport.handleResponse(transport.capturedRequests()[0].requestId, new Response());
            "indices:admin/test_unresolvable",
import org.opensearch.common.util.concurrent.ThreadContext;
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        setState(clusterService, ClusterStateCreationUtils.state("test", local, ShardRoutingState.INITIALIZING));
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    }
import org.opensearch.transport.TransportException;  
                fail("expected and ConnectTransportException");
        }
    public void testUnresolvableRequestDoesNotHang() throws InterruptedException, ExecutionException, TimeoutException {  
            transportService,  
    public void testSuccessAfterRetryWithClusterStateUpdate() throws Exception {  
            x -> clusterService.localNode(),
            clusterService.getSettings(),
 *  
            }
        assertThat(transport.capturedRequests().length, equalTo(0));  
import org.junit.BeforeClass;
        requestId = transport.capturedRequests()[0].requestId;  
        protected void resolveRequest(ClusterState state, Request request) {}  
}
    @After  
        @Override
            new ActionFilters(new HashSet<>()),
 * this work for additional information regarding copyright
        listener.get();
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        action.new AsyncSingleAction(request, listener).start();
            return clusterState.routingTable().index(request.concreteIndex()).shard(request.shardId.getId()).primaryShardIt();
        Request request = new Request().index("test_non_existing");
            listener.get();
            protected void resolveRequest(ClusterState state, Request request) {  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        listener.get();
        assertThat(transport.capturedRequests().length, equalTo(1));
                logger.info("expected ClusterBlockException  but got ", e);
        transport.clear();
import org.opensearch.core.common.io.stream.StreamOutput;
 * compatible open source license.
        } catch (ExecutionException t) {
        transportService.start();  
        Request request = new Request().index("test");  
    public void testFailureWithoutRetry() throws Exception {
        // let it fail the second time too
        }  
        @Override
import org.opensearch.core.action.ActionListener;
import org.opensearch.threadpool.TestThreadPool;  
        try {
 * under the License.  
        Request request = new Request().index("test");  
        action.new AsyncSingleAction(request, listener).start();
            if (ExceptionsHelper.unwrap(e, ClusterBlockException.class) == null) {
import org.opensearch.action.support.PlainActionFuture;
        THREAD_POOL = null;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.common.io.stream.Writeable;  
            action.new AsyncSingleAction(request, listener).start();  
        request.shardId = new ShardId("test_non_existing", "_na_", 0);  
    @AfterClass
import org.junit.Before;
    private CapturingTransport transport;
            assertTrue(listener.isDone());
        transport.clear();
        assertThat(transport.capturedRequests().length, equalTo(1));
                fail("expected and TransportException");
                THREAD_POOL,
 * specific language governing permissions and limitations
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
 * the Apache License, Version 2.0 (the "License"); you may
        request.shardId = new ShardId("test", "_na_", 0);
 * not use this file except in compliance with the License.
        Request request = new Request();  
        // wait until the timeout was triggered and we actually tried to send for the second time
            THREAD_POOL,
    public void testResolveIndices() {
        try {
    public void testGlobalBlock() {
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.ExecutionException;  
        THREAD_POOL = new TestThreadPool(TransportInstanceSingleOperationActionTests.class.getSimpleName());  
    class MyResolver extends IndexNameExpressionResolver {
        DiscoveryNode node = clusterService.state().getNodes().getLocalNode();
        DiscoveryNode node = clusterService.state().getNodes().getLocalNode();
import org.opensearch.transport.ConnectTransportException;
 */
        public Request() {}
            Writeable.Reader<Request> request  
        transportService.acceptIncomingRequests();
import java.util.Collections;
        Request request = new Request().index("test");
            }
/*  
        assertThat(transport.capturedRequests().length, equalTo(1));  
                request  
            throw new UnsupportedOperationException("Not implemented in test class");  
            IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.cluster.service.ClusterService;
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
 * Licensed to Elasticsearch under one or more contributor  
        }
        long requestId = transport.capturedRequests()[0].requestId;  
    }  
        transport.clear();
    }
        @Override
    }  
    }  
        @Override  
        ) {
import org.junit.After;
        MyResolver() {  
                transportService,  
import org.opensearch.cluster.metadata.ResolvedIndices;  
        protected String executor(ShardId shardId) {  
        ResolvedIndices resolvedIndices = action.resolveIndices(request);
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.cluster.block.ClusterBlocks;
        }
/*  
            listener.get();
        Request request = new Request().index("test");
        }
            Request::new  
        setState(clusterService, ClusterStateCreationUtils.state("test", randomBoolean(), ShardRoutingState.STARTED));  
        request.shardId = new ShardId("test", "_na_", 0);
        transport.handleLocalError(requestId, new ConnectTransportException(node, "test exception"));
        };  
import org.opensearch.transport.TransportService;
public class TransportInstanceSingleOperationActionTests extends OpenSearchTestCase {
import java.util.HashSet;
        setState(clusterService, ClusterStateCreationUtils.state("test", randomBoolean(), ShardRoutingState.STARTED));  
                TransportInstanceSingleOperationActionTests.this.clusterService,
        // this should fail because primary not initialized
        assertEquals(ResolvedIndices.of("concrete_value"), resolvedIndices);
 *
        boolean local = randomBoolean();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        );
        setState(clusterService, ClusterStateCreationUtils.state("test", randomBoolean(), ShardRoutingState.STARTED));
        request.shardId = new ShardId("test", "_na_", 0);
            }
 */  
import org.opensearch.core.index.shard.ShardId;
import java.util.HashMap;  
    }  
        );
/*
        request.concreteIndex("concrete_value");  
import org.junit.AfterClass;  
    private TransportService transportService;
            fail("this should fail with a transport exception");  
        ClusterBlocks.Builder block = ClusterBlocks.builder()
    }
        clusterService = createClusterService(THREAD_POOL);
    }
    public static class Request extends InstanceShardOperationRequest<Request> {  
 * ownership. Elasticsearch licenses this file to you under  
            new MyResolver(),
            Collections.emptySet(),  
import org.opensearch.cluster.routing.ShardRoutingState;  
    @Before
        protected Response newResponse(StreamInput in) throws IOException {
        public Response(StreamInput in) throws IOException {
import org.opensearch.action.IndicesRequest;
            super(new ThreadContext(Settings.EMPTY));
        // this time it should work
import static org.opensearch.test.ClusterServiceUtils.setState;
        public Response() {}  
 *
        ResolvedIndices resolvedIndices = action.resolveIndices(request);  
 * software distributed under the License is distributed on an
        @Override
import org.opensearch.cluster.block.ClusterBlock;
import static org.hamcrest.core.IsEqual.equalTo;  
        setState(clusterService, ClusterStateCreationUtils.state("test", local, ShardRoutingState.STARTED));  
    }
        assertEquals(ResolvedIndices.of("test"), resolvedIndices);
        }
    @Override
                indexNameExpressionResolver,
import org.opensearch.test.transport.CapturingTransport;
        assertThat(transport.capturedRequests().length, equalTo(1));
        try {
        }  
import org.opensearch.common.unit.TimeValue;  
        public Request(StreamInput in) throws IOException {  
            // result should return immediately  
        Request request = new Request().index("test").timeout(new TimeValue(0, TimeUnit.MILLISECONDS));  
            if (ExceptionsHelper.unwrap(t, TransportException.class) == null) {
            requestId,
        }  
 * You may obtain a copy of the License at  
import org.opensearch.cluster.ClusterState;  
    }  
            listener.get();
import org.opensearch.action.support.ActionFilters;  
    public void testBasicRequestWorks() throws InterruptedException, ExecutionException, TimeoutException {
            listener.get();
            new ActionFilters(new HashSet<>()),
        action.new AsyncSingleAction(request, listener).start();  
            return ThreadPool.Names.SAME;
import java.io.IOException;
            }
 * license agreements. See the NOTICE file distributed with
        } catch (ExecutionException t) {
        }
        assertThat(transport.capturedRequests().length, equalTo(1));
                logger.info("expected IllegalStateException  but got ", e);
        }  
        setState(clusterService, ClusterStateCreationUtils.state("test", local, ShardRoutingState.STARTED));
    }  
            transportService,
        }
        transportService.close();
            super(
            "indices:admin/test",  
            if (ExceptionsHelper.unwrap(t, ConnectTransportException.class) == null) {
    }
    public void testSuccessAfterRetryWithExceptionFromTransport() throws Exception {
