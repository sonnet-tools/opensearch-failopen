            .newConcurrentSet();
        List<ShardId> shards = broadcastReplicationAction.shards(new DummyBroadcastRequest().indices(shardId.getIndexName()), clusterState);
        PlainActionFuture<BroadcastResponse> response = PlainActionFuture.newFuture();
            }
        super.tearDown();
 * You may obtain a copy of the License at
import java.util.concurrent.ExecutionException;
        DummyBroadcastRequest(String... indices) {
 *
import org.opensearch.Version;
        for (Tuple<ShardId, ActionListener<ReplicationResponse>> shardRequests : broadcastReplicationAction.capturedShardRequests) {
import org.opensearch.common.util.concurrent.ThreadContext;
                clusterService,
        assertBroadcastResponse(2, 0, 0, response.get(), null);
    }
import org.opensearch.common.network.NetworkService;
        protected BroadcastResponse newResponse(
import org.junit.After;
                }
    private TransportService transportService;
import org.opensearch.action.support.PlainActionFuture;
        DummyBroadcastRequest request
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            } else {
import org.junit.AfterClass;
 */
import org.opensearch.threadpool.TestThreadPool;
import org.junit.BeforeClass;
        int failed = 0;
        int succeeded = 0;
        transportService.acceptIncomingRequests();
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
            Collections.emptySet(),
        threadPool = new TestThreadPool("BroadcastReplicationTests");
 * The OpenSearch Contributors require contributions made to
        setState(clusterService, stateWithNoShard());
import java.util.Date;
        }
import java.util.Collections;
        }
        clusterService = createClusterService(threadPool);
    @AfterClass
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            if (randomBoolean()) {
 *
            super(
                    failures[0] = new ReplicationResponse.ShardInfo.Failure(
    private class TestBroadcastReplicationAction extends TransportBroadcastReplicationAction<
import org.opensearch.action.support.broadcast.BroadcastRequest;
import org.opensearch.cluster.ClusterState;
 * ownership. Elasticsearch licenses this file to you under
                ShardRoutingState.UNASSIGNED
                        null,
 * this file be licensed under the Apache-2.0 license or a
    }
import java.util.HashSet;
 * Modifications Copyright OpenSearch Contributors. See
                    // sometimes add failure (no failure means shard unavailable)
import org.opensearch.action.UnavailableShardsException;
                        shardRequests.v1(),
            NoopTracer.INSTANCE
 *    http://www.apache.org/licenses/LICENSE-2.0
        protected void shardExecute(
            ClusterService clusterService,
import org.opensearch.action.admin.indices.flush.TransportFlushAction;
import org.opensearch.core.common.io.stream.StreamInput;
            Settings.EMPTY,
import org.opensearch.action.admin.indices.flush.FlushRequest;
                shardRequests.v2().onFailure(new UnavailableShardsException(shardRequests.v1(), "test exception"));
        }
            new NetworkService(Collections.emptyList()),
            clusterService,
        }
        BasicReplicationRequest,
import org.opensearch.action.admin.indices.flush.FlushResponse;
                randomBoolean() ? ShardRoutingState.INITIALIZING : ShardRoutingState.UNASSIGNED,
        final ShardId shardId = new ShardId(index, "_na_", 0);
        );
                        RestStatus.GATEWAY_TIMEOUT,
    }
 * KIND, either express or implied.  See the License for the
            IndexNameExpressionResolver indexNameExpressionResolver,
    }
            super(indices);
        final String index = "test";
 */
        ) {
            clusterService,
        assertThat(response.getSuccessfulShards(), equalTo(successful));
import org.opensearch.cluster.service.ClusterService;
            NoopTracer.INSTANCE
                    failed++;
            endDate.getTime() - beginDate.getTime(),
                shardRequests.v2().onResponse(replicationResponse);
import org.opensearch.threadpool.ThreadPool;
        IOUtils.close(clusterService, transportService);
        // we expect no failures here because UnavailableShardsException does not count as failed
/*
 *
                indexNameExpressionResolver,
 * Unless required by applicable law or agreed to in writing,
    }
                DummyBroadcastRequest::new,
        setState(
        transportService.start();
        PlainActionFuture<BroadcastResponse> response = PlainActionFuture.newFuture();
        ) {
        Date beginDate = new Date();
        assertBroadcastResponse(2 * numShards, succeeded, failed, response.get(), Exception.class);
    private TestBroadcastReplicationAction broadcastReplicationAction;
            null,
        }
        MockNioTransport transport = new MockNioTransport(
 * compatible open source license.
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
    }
        response.get();
                    failures = new ReplicationResponse.ShardInfo.Failure[1];
        return response.actionGet("5s");
import java.io.IOException;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
            index,
    public void testShardsList() throws InterruptedException, ExecutionException {
        PlainActionFuture<BroadcastResponse> response = PlainActionFuture.newFuture();
                ReplicationResponse.ShardInfo.Failure[] failures = new ReplicationResponse.ShardInfo.Failure[0];
                shardRequests.v2().onFailure(new Exception("pretend shard failed"));
                "internal:test-broadcast-replication-action",
import org.opensearch.action.support.ActionFilters;
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
    @Override
            int totalNumCopies,
        broadcastAction.execute(request, response);
        long maxTime = 500;
    }
        assertThat(shards.get(0), equalTo(shardId));
        }
            Task task,
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            circuitBreakerService,
        assertThat(shards.size(), equalTo(1));
        setState(clusterService, state(index, randomBoolean(), ShardRoutingState.STARTED));
    public static void beforeClass() {
            super(in);
                    );
    public BroadcastResponse executeAndAssertImmediateResponse(
        DummyBroadcastRequest,
            new ActionFilters(new HashSet<>()),
        }
        Date endDate = new Date();
import org.opensearch.common.util.PageCacheRecycler;
import org.opensearch.core.action.ActionListener;
import java.util.Set;
        }
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
            randomBoolean() ? ShardRoutingState.INITIALIZING : ShardRoutingState.UNASSIGNED,
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        @Override
                actionFilters,
        super.setUp();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    private void assertBroadcastResponse(int total, int successful, int failed, BroadcastResponse response, Class<?> exceptionClass) {
package org.opensearch.action.support.replication;
import java.util.List;
        broadcastReplicationAction.execute(new DummyBroadcastRequest(index), response);
                succeeded += shardsSucceeded;
                        false
    private static CircuitBreakerService circuitBreakerService;
import org.junit.Before;
                action
import org.opensearch.transport.TransportService;
            x -> clusterService.localNode(),
    }
                shardRequests.v2().onFailure(new NoShardAvailableActionException(shardRequests.v1()));
        assertThat(
        logger.debug("--> using initial state:\n{}", clusterService.state());
        PlainActionFuture<BroadcastResponse> response = PlainActionFuture.newFuture();
        assertBroadcastResponse(0, 0, 0, response, null);
        logger.info("total shards: {}, ", response.get().getTotalShards());
            clusterService.getSettings(),
        BroadcastResponse,
        broadcastReplicationAction.execute(new DummyBroadcastRequest().indices(index), response);
                if (shardsSucceeded == 1 && randomBoolean()) {
    }
import org.opensearch.core.index.shard.ShardId;
        assertBroadcastResponse(1, 1, 0, response.get(), null);
            }
    public void testStartedPrimary() throws InterruptedException, ExecutionException {
}
    private static ThreadPool threadPool;
        final String index = "test";
    public static void afterClass() {
 * GitHub history for details.
                randomBoolean(),
import java.util.concurrent.TimeUnit;
 * Licensed to Elasticsearch under one or more contributor
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.equalTo;
            new NamedWriteableRegistry(Collections.emptyList()),
        protected final Set<Tuple<ShardId, ActionListener<ReplicationResponse>>> capturedShardRequests = ConcurrentCollections
        BroadcastResponse response = executeAndAssertImmediateResponse(broadcastReplicationAction, new DummyBroadcastRequest());
            state(
 */
            TransportReplicationAction<BasicReplicationRequest, BasicReplicationRequest, ReplicationResponse> action
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithNoShard;
                ReplicationResponse replicationResponse = new ReplicationResponse();
import org.opensearch.cluster.routing.ShardRoutingState;
            List<DefaultShardOperationFailedException> shardFailures
        broadcastReplicationAction.execute(new DummyBroadcastRequest(index), response);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            assertThat(response.getShardFailures()[0].getCause().getCause(), instanceOf(exceptionClass));
                        new Exception("pretend shard failed"),
    }
    }
/*
                int shardsSucceeded = randomInt(1) + 1;
                // just add a general exception and see if failed shards will be incremented by 2
            )
        TestBroadcastReplicationAction(
            transportService,
    public void tearDown() throws Exception {
        @Override
            threadPool,
                index,
        );
                transportService,
        ) {
            ReplicationResponse replicationResponse = new ReplicationResponse();
            ShardId shardId,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        );
import org.opensearch.common.collect.Tuple;
        logger.info("total shards: {}, ", response.get().getTotalShards());
 * this work for additional information regarding copyright
        DummyBroadcastRequest(StreamInput in) throws IOException {
        );
import org.opensearch.core.rest.RestStatus;
    ) {
    @BeforeClass
            capturedShardRequests.add(new Tuple<>(shardId, shardActionListener));
        return flushResponse;
    public static class DummyBroadcastRequest extends BroadcastRequest<DummyBroadcastRequest> {
        @Override
        assertThat(response.getFailedShards(), equalTo(failed));
    @After
import org.opensearch.test.OpenSearchTestCase;
        final String index = "test";
        logger.debug("--> using initial state:\n{}", clusterService.state());
        protected BasicReplicationRequest newShardRequest(DummyBroadcastRequest request, ShardId shardId) {
        @Override
            int successfulShards,
import static org.hamcrest.Matchers.instanceOf;
    }
        FlushResponse flushResponse = ActionTestUtils.executeBlocking(flushAction, new FlushRequest(index));
            ShardRoutingState.UNASSIGNED
            "this should not take longer than " + maxTime + " ms. The request hangs somewhere",
        TransportBroadcastReplicationAction<DummyBroadcastRequest, BroadcastResponse, ?, ?> broadcastAction,
            return new BasicReplicationRequest(shardId);
import static org.opensearch.test.ClusterServiceUtils.setState;
            TransportService transportService,
            transport,
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
    public void testNotStartedPrimary() throws InterruptedException, ExecutionException {
        );
        for (Tuple<ShardId, ActionListener<ReplicationResponse>> shardRequests : broadcastReplicationAction.capturedShardRequests) {
        }
        }
        logger.debug("--> using initial state:\n{}", clusterService.state());
 * not use this file except in compliance with the License.
        logger.debug("--> using initial state:\n{}", clusterService.state());
    @Before
        for (Tuple<ShardId, ActionListener<ReplicationResponse>> shardRequests : broadcastReplicationAction.capturedShardRequests) {
            int failedShards,
                replicationResponse.setShardInfo(new ReplicationResponse.ShardInfo(2, shardsSucceeded, failures));
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            } else {
            Version.CURRENT,
            randomBoolean(),
    public void testResultCombine() throws InterruptedException, ExecutionException, IOException {
/*
import org.opensearch.common.util.io.IOUtils;
        int numShards = 1 + randomInt(3);
        logger.debug("--> using initial state:\n{}", clusterService.state());
        assertThat(response.getTotalShards(), equalTo(total));
        transportService = new TransportService(
        for (int i = 0; i < failed; i++) {
        broadcastReplicationAction = new TestBroadcastReplicationAction(
 * software distributed under the License is distributed on an
            lessThanOrEqualTo(maxTime)
    public FlushResponse assertImmediateResponse(String index, TransportFlushAction flushAction) {
            return new ReplicationResponse();
import org.opensearch.action.support.broadcast.BroadcastResponse;
        threadPool = null;
        ReplicationResponse> {
                // sometimes fail
            threadPool,
            );
    }
            null
    public void setUp() throws Exception {
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithAssignedPrimariesAndOneReplica;
        ClusterState clusterState = state(
    public void testNoShards() throws InterruptedException, ExecutionException, IOException {
import org.opensearch.action.support.ActionTestUtils;
        protected ReplicationResponse newShardResponse() {
 * under the License.
public class BroadcastReplicationTests extends OpenSearchTestCase {
            return new BroadcastResponse(totalNumCopies, successfulShards, failedShards, shardFailures);
            ActionFilters actionFilters,
import org.opensearch.common.settings.Settings;
        final String index = "test";
            replicationResponse.setShardInfo(new ReplicationResponse.ShardInfo(1, 1));
        );
            DummyBroadcastRequest request,
 * SPDX-License-Identifier: Apache-2.0
            shardRequests.v2().onResponse(replicationResponse);
    }
        circuitBreakerService = new NoneCircuitBreakerService();
import org.opensearch.transport.nio.MockNioTransport;
import org.opensearch.tasks.Task;
            if (randomBoolean()) {
            ActionListener<ReplicationResponse> shardActionListener
import org.opensearch.action.NoShardAvailableActionException;
    private ClusterService clusterService;
        }
                failed += 2;
        setState(clusterService, stateWithAssignedPrimariesAndOneReplica(index, numShards));
