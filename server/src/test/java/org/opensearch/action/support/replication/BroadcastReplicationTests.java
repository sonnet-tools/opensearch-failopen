                indexNameExpressionResolver,
        ) {
import org.opensearch.action.admin.indices.flush.FlushResponse;
            transportService,
import java.util.concurrent.TimeUnit;
package org.opensearch.action.support.replication;
    }
        assertBroadcastResponse(2 * numShards, succeeded, failed, response.get(), Exception.class);  
            new NamedWriteableRegistry(Collections.emptyList()),  
            Collections.emptySet(),  
    private TransportService transportService;
        broadcastReplicationAction.execute(new DummyBroadcastRequest(index), response);
import org.junit.AfterClass;
import java.util.Set;
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        protected BroadcastResponse newResponse(
import org.opensearch.common.util.concurrent.ThreadContext;
        ) {
import org.opensearch.core.rest.RestStatus;
            assertThat(response.getShardFailures()[0].getCause().getCause(), instanceOf(exceptionClass));
        assertBroadcastResponse(2, 0, 0, response.get(), null);  
        assertThat(response.getSuccessfulShards(), equalTo(successful));  
        threadPool = null;  
        for (Tuple<ShardId, ActionListener<ReplicationResponse>> shardRequests : broadcastReplicationAction.capturedShardRequests) {  
            ClusterService clusterService,
 *
    private TestBroadcastReplicationAction broadcastReplicationAction;  
        super.tearDown();
import org.opensearch.transport.TransportService;
        logger.debug("--> using initial state:\n{}", clusterService.state());
        PlainActionFuture<BroadcastResponse> response = PlainActionFuture.newFuture();
        );  
import org.opensearch.common.network.NetworkService;
        DummyBroadcastRequest,
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithNoShard;
                action
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
    }
        ReplicationResponse> {
        @Override
                        false
                clusterService,
    ) {
 * under the License.  
    }
            clusterService,  
            clusterService,  
        final String index = "test";
        for (int i = 0; i < failed; i++) {  
        Date endDate = new Date();
        // we expect no failures here because UnavailableShardsException does not count as failed
        @Override
            ShardRoutingState.UNASSIGNED
            Settings.EMPTY,
            .newConcurrentSet();
            null
import org.opensearch.action.admin.indices.flush.FlushRequest;  
import org.opensearch.transport.nio.MockNioTransport;  
    private static CircuitBreakerService circuitBreakerService;  
 * You may obtain a copy of the License at  
                ShardRoutingState.UNASSIGNED
        }  
        assertThat(response.getTotalShards(), equalTo(total));
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;  
                        RestStatus.GATEWAY_TIMEOUT,
/*
 * the Apache License, Version 2.0 (the "License"); you may
        }
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import org.opensearch.action.support.ActionTestUtils;
        TestBroadcastReplicationAction(  
            List<DefaultShardOperationFailedException> shardFailures  
            super(
    @After  
import org.opensearch.common.settings.Settings;
            TransportReplicationAction<BasicReplicationRequest, BasicReplicationRequest, ReplicationResponse> action
import org.opensearch.threadpool.ThreadPool;
                "internal:test-broadcast-replication-action",
            );  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            circuitBreakerService,
import org.opensearch.Version;  
import org.opensearch.cluster.ClusterState;
                succeeded += shardsSucceeded;
    public static void afterClass() {
 * license agreements. See the NOTICE file distributed with
        broadcastAction.execute(request, response);
import org.opensearch.action.UnavailableShardsException;
                ReplicationResponse.ShardInfo.Failure[] failures = new ReplicationResponse.ShardInfo.Failure[0];
        assertBroadcastResponse(0, 0, 0, response, null);
        PlainActionFuture<BroadcastResponse> response = PlainActionFuture.newFuture();  
    public void testNoShards() throws InterruptedException, ExecutionException, IOException {  
        logger.info("total shards: {}, ", response.get().getTotalShards());
    @AfterClass  
import static org.opensearch.test.ClusterServiceUtils.setState;
        @Override
    }  
            int totalNumCopies,
                        null,
import java.util.concurrent.ExecutionException;  
        FlushResponse flushResponse = ActionTestUtils.executeBlocking(flushAction, new FlushRequest(index));  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.opensearch.common.util.io.IOUtils;  
            int successfulShards,  
            )  
        for (Tuple<ShardId, ActionListener<ReplicationResponse>> shardRequests : broadcastReplicationAction.capturedShardRequests) {  
        }  
import org.opensearch.tasks.Task;  
import org.opensearch.core.action.ActionListener;
    }  
            index,
        BasicReplicationRequest,
    private ClusterService clusterService;
    public void testShardsList() throws InterruptedException, ExecutionException {
    @BeforeClass
import org.opensearch.action.NoShardAvailableActionException;
import org.opensearch.core.index.shard.ShardId;
                randomBoolean() ? ShardRoutingState.INITIALIZING : ShardRoutingState.UNASSIGNED,
    @Override
 * software distributed under the License is distributed on an
        return flushResponse;
        protected ReplicationResponse newShardResponse() {
 * not use this file except in compliance with the License.
import org.opensearch.action.support.broadcast.BroadcastResponse;
            lessThanOrEqualTo(maxTime)  
    public void setUp() throws Exception {
}
        logger.debug("--> using initial state:\n{}", clusterService.state());
                shardRequests.v2().onFailure(new UnavailableShardsException(shardRequests.v1(), "test exception"));  
    }
        protected final Set<Tuple<ShardId, ActionListener<ReplicationResponse>>> capturedShardRequests = ConcurrentCollections  
            ActionListener<ReplicationResponse> shardActionListener
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
        }
                if (shardsSucceeded == 1 && randomBoolean()) {  
 * this work for additional information regarding copyright
                // sometimes fail  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
    }
        circuitBreakerService = new NoneCircuitBreakerService();
    public void testResultCombine() throws InterruptedException, ExecutionException, IOException {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        );
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            ShardId shardId,  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
import java.util.HashSet;  
import java.util.List;
        PlainActionFuture<BroadcastResponse> response = PlainActionFuture.newFuture();
            TransportService transportService,
            shardRequests.v2().onResponse(replicationResponse);  
            new ActionFilters(new HashSet<>()),
            x -> clusterService.localNode(),
                int shardsSucceeded = randomInt(1) + 1;  
            replicationResponse.setShardInfo(new ReplicationResponse.ShardInfo(1, 1));
        final String index = "test";
    public void tearDown() throws Exception {
    @Override
        PlainActionFuture<BroadcastResponse> response = PlainActionFuture.newFuture();  
            endDate.getTime() - beginDate.getTime(),
            clusterService.getSettings(),  
        transportService = new TransportService(
        );
            } else {
            state(
        );
            threadPool,
import org.opensearch.threadpool.TestThreadPool;  
        }
/*
        assertThat(  
            return new ReplicationResponse();
import org.opensearch.cluster.service.ClusterService;
        logger.debug("--> using initial state:\n{}", clusterService.state());  
    private void assertBroadcastResponse(int total, int successful, int failed, BroadcastResponse response, Class<?> exceptionClass) {
 * ownership. Elasticsearch licenses this file to you under  
        broadcastReplicationAction.execute(new DummyBroadcastRequest().indices(index), response);  
        transportService.start();  
        protected void shardExecute(  
        response.get();  
        for (Tuple<ShardId, ActionListener<ReplicationResponse>> shardRequests : broadcastReplicationAction.capturedShardRequests) {
 * Unless required by applicable law or agreed to in writing,
        ClusterState clusterState = state(
        return response.actionGet("5s");
import org.opensearch.action.support.broadcast.BroadcastRequest;  
            ActionFilters actionFilters,  
        BroadcastResponse,  
import org.opensearch.core.common.io.stream.StreamInput;
        final String index = "test";
import org.opensearch.test.OpenSearchTestCase;
        @Override  
                randomBoolean(),  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    // sometimes add failure (no failure means shard unavailable)
        logger.debug("--> using initial state:\n{}", clusterService.state());
        DummyBroadcastRequest(StreamInput in) throws IOException {
        transportService.acceptIncomingRequests();
        clusterService = createClusterService(threadPool);
            DummyBroadcastRequest request,
    public BroadcastResponse executeAndAssertImmediateResponse(
 *  
                ReplicationResponse replicationResponse = new ReplicationResponse();
            new NetworkService(Collections.emptyList()),
        DummyBroadcastRequest(String... indices) {  
    }
                shardRequests.v2().onResponse(replicationResponse);
        );
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        int succeeded = 0;
        TransportBroadcastReplicationAction<DummyBroadcastRequest, BroadcastResponse, ?, ?> broadcastAction,  
import org.opensearch.action.admin.indices.flush.TransportFlushAction;
        logger.debug("--> using initial state:\n{}", clusterService.state());
            IndexNameExpressionResolver indexNameExpressionResolver,
    }
        }
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
import static org.hamcrest.Matchers.instanceOf;  
 * KIND, either express or implied.  See the License for the
            capturedShardRequests.add(new Tuple<>(shardId, shardActionListener));  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        long maxTime = 500;
        MockNioTransport transport = new MockNioTransport(  
            return new BasicReplicationRequest(shardId);
import org.junit.After;
    private class TestBroadcastReplicationAction extends TransportBroadcastReplicationAction<
            } else {
    public FlushResponse assertImmediateResponse(String index, TransportFlushAction flushAction) {
 * this file be licensed under the Apache-2.0 license or a
            randomBoolean(),  
        }
    private static ThreadPool threadPool;
            Task task,
import static org.hamcrest.Matchers.equalTo;
        protected BasicReplicationRequest newShardRequest(DummyBroadcastRequest request, ShardId shardId) {  
        int numShards = 1 + randomInt(3);
import org.opensearch.cluster.routing.ShardRoutingState;
        assertBroadcastResponse(1, 1, 0, response.get(), null);  
        );  
        assertThat(response.getFailedShards(), equalTo(failed));
                // just add a general exception and see if failed shards will be incremented by 2
        threadPool = new TestThreadPool("BroadcastReplicationTests");
        broadcastReplicationAction = new TestBroadcastReplicationAction(
                    failures[0] = new ReplicationResponse.ShardInfo.Failure(  
 * Licensed to Elasticsearch under one or more contributor  
 */
        setState(clusterService, stateWithAssignedPrimariesAndOneReplica(index, numShards));  
import java.util.Date;
        assertThat(shards.get(0), equalTo(shardId));
                        shardRequests.v1(),
                failed += 2;
    }  
public class BroadcastReplicationTests extends OpenSearchTestCase {  
 * SPDX-License-Identifier: Apache-2.0
 */  
    @Before  
import org.junit.BeforeClass;
import java.io.IOException;  
import java.util.Collections;
                replicationResponse.setShardInfo(new ReplicationResponse.ShardInfo(2, shardsSucceeded, failures));  
                }
                shardRequests.v2().onFailure(new Exception("pretend shard failed"));  
            super(in);
            null,
            if (randomBoolean()) {  
    public static class DummyBroadcastRequest extends BroadcastRequest<DummyBroadcastRequest> {
        }
    }  
        setState(
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithAssignedPrimariesAndOneReplica;
            int failedShards,
    }
            threadPool,  
                actionFilters,  
            NoopTracer.INSTANCE
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.common.collect.Tuple;  
    public void testNotStartedPrimary() throws InterruptedException, ExecutionException {  
                shardRequests.v2().onFailure(new NoShardAvailableActionException(shardRequests.v1()));
    public static void beforeClass() {  
        IOUtils.close(clusterService, transportService);  
            if (randomBoolean()) {
            NoopTracer.INSTANCE
            ReplicationResponse replicationResponse = new ReplicationResponse();
        }
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
        ) {  
        int failed = 0;
            super(indices);
 *
    public void testStartedPrimary() throws InterruptedException, ExecutionException {  
                    failures = new ReplicationResponse.ShardInfo.Failure[1];
import org.junit.Before;  
                    );  
        BroadcastResponse response = executeAndAssertImmediateResponse(broadcastReplicationAction, new DummyBroadcastRequest());  
        }  
                        new Exception("pretend shard failed"),  
        setState(clusterService, state(index, randomBoolean(), ShardRoutingState.STARTED));
        final ShardId shardId = new ShardId(index, "_na_", 0);  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
 */
        final String index = "test";
        DummyBroadcastRequest request
            }
                    failed++;
                index,
        setState(clusterService, stateWithNoShard());
import org.opensearch.action.support.ActionFilters;  
    }
    }  
        super.setUp();
        broadcastReplicationAction.execute(new DummyBroadcastRequest(index), response);
        }
            Version.CURRENT,
            "this should not take longer than " + maxTime + " ms. The request hangs somewhere",
import org.opensearch.common.util.PageCacheRecycler;  
                transportService,
            transport,
        logger.info("total shards: {}, ", response.get().getTotalShards());
                DummyBroadcastRequest::new,  
        assertThat(shards.size(), equalTo(1));  
            randomBoolean() ? ShardRoutingState.INITIALIZING : ShardRoutingState.UNASSIGNED,
 * specific language governing permissions and limitations
        Date beginDate = new Date();
            }
        List<ShardId> shards = broadcastReplicationAction.shards(new DummyBroadcastRequest().indices(shardId.getIndexName()), clusterState);
            return new BroadcastResponse(totalNumCopies, successfulShards, failedShards, shardFailures);
