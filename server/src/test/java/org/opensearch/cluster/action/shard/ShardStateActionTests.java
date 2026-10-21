import org.opensearch.test.OpenSearchTestCase;
    }
            }
                if (randomBoolean()) {
        assertThat(capturedRequests.length, equalTo(1));
import static org.hamcrest.Matchers.notNullValue;
            }
        });
                        failedShard.shardId(),
    public void tearDown() throws Exception {
            } finally {
        assertThat(entry.shardId, equalTo(shardRouting.shardId()));
 * the Apache License, Version 2.0 (the "License"); you may
        transportService = transport.createTransportService(
                latch.countDown();
            assertThat(deserialized.shardId, equalTo(shardId));
import java.util.concurrent.atomic.AtomicReference;
        @Override
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                        transport.handleResponse(request.requestId, TransportResponse.Empty.INSTANCE);
import org.opensearch.transport.NodeNotConnectedException;
        ShardRouting failedShard = getRandomShardRouting(index);
    private Exception getSimulatedFailure() {
        assertNull(listener.failure.get());
        final Exception failure = randomBoolean() ? null : getSimulatedFailure();
        @Override
 * SPDX-License-Identifier: Apache-2.0
        super.tearDown();
            assertThat(deserialized.shardId, equalTo(shardId));
        transportService.close();
import org.opensearch.cluster.routing.RoutingTable;
        final long primaryTerm = randomIntBetween(0, 100);
        assert shardRouting != null;
        listener.await();
    public void testUnhandledFailure() {
import static org.opensearch.test.ClusterServiceUtils.setState;
                getSimulatedFailure(),
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
        boolean markAsStale = randomBoolean();
        return new CorruptIndexException("simulated", (String) null);
            assertThat(deserialized.primaryTerm, equalTo(primaryTerm));
    BytesReference serialize(Writeable writeable, Version version) throws IOException {
            TransportService transportService,
        }
        THREAD_POOL = new TestThreadPool("ShardStateActionTest");
import org.opensearch.cluster.routing.ShardsIterator;
import org.opensearch.cluster.routing.IndexRoutingTable;
import org.junit.AfterClass;
        setUpClusterManagerRetryVerification(numberOfRetries, retries, latch, retryLoop);
        public void onResponse(Void aVoid) {
import org.opensearch.cluster.action.shard.ShardStateAction.FailedShardEntry;
        ShardStateAction.StartedShardEntry entry = (ShardStateAction.StartedShardEntry) capturedRequests[0].request;
        RoutingTable routingTable = RoutingTable.builder(clusterService.state().getRoutingTable()).remove(index).build();
 * KIND, either express or implied.  See the License for the
            latch.countDown();
        final TestListener listener = new TestListener();
        }
    public static void stopThreadPool() {
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
            in.setVersion(version);
                    public void onResponse(Void aVoid) {
import static org.hamcrest.Matchers.arrayWithSize;
        shardStateAction.setOnBeforeWaitForNewClusterManagerAndRetry(() -> {});
        ) {
        assertThat(capturedRequests, arrayWithSize(1));
import java.util.Collections;
 * GitHub history for details.
    }
        // sent to the cluster-manager
import org.opensearch.cluster.routing.ShardRouting;
            } else {
        ShardStateAction.FailedShardEntry shardEntry = (ShardStateAction.FailedShardEntry) capturedRequests[0].request;
import java.util.concurrent.Phaser;
                    if (randomBoolean()) {
        if (capturedRequests.length == 1) {
            clusterService.getSettings(),
        final String allocationId = randomRealisticUnicodeOfCodepointLengthBetween(10, 100);
/*
        final ShardId shardId = new ShardId(randomRealisticUnicodeOfLengthBetween(10, 100), UUID.randomUUID().toString(), between(0, 1000));
        }
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        assertThat(capturedRequests[0].request, is(instanceOf(ShardStateAction.FailedShardEntry.class)));
            public void onFailure(Exception e) {
import org.opensearch.cluster.NotClusterManagerException;
            this.onAfterWaitForNewClusterManagerAndRetry = onAfterWaitFornewClusterManagerAndRetry;
                assert false;
                failedShard.shardId(),
        final String index = "test";
        final Version version = randomFrom(randomCompatibleVersion(random(), Version.CURRENT));
    public void testClusterManagerChannelException() throws InterruptedException {
import static org.hamcrest.CoreMatchers.equalTo;
        final CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
    }
        CountDownLatch latch = new CountDownLatch(numListeners);
        for (Thread t : clientThreads) {
 * this file be licensed under the Apache-2.0 license or a
        IndexRoutingTable indexRoutingTable = clusterService.state().routingTable().index(index);
        clusterService = createClusterService(THREAD_POOL);
        Thread[] clientThreads = new Thread[between(1, 6)];
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        final String index = "test";
 *
import org.opensearch.cluster.routing.RerouteService;
                }
            } else {
                // finish the request
        void await() throws InterruptedException {
        shardStateAction.localShardFailed(shardRouting, "test", getSimulatedFailure(), listener);
 * compatible open source license.
        LongConsumer retryLoop = requestId -> {
public class ShardStateActionTests extends OpenSearchTestCase {
                    randomFrom(new NotClusterManagerException("simulated"), new FailedToCommitClusterStateException("simulated"))
            TransportRequest request,
        assertNull(listener.failure.get());
    @After
            }
    }
import org.opensearch.Version;
        assertThat(retries.get(), equalTo(0));
            failedShard.shardId(),
/*
        assertTrue(success.get());
            t.join();
        final Version version = randomFrom(randomCompatibleVersion(random(), Version.CURRENT));
                }
            if (randomBoolean()) {
        assertEquals(clusterService.state().nodes().getClusterManagerNode().getId(), capturedRequests[0].node.getId());
        barrier.arriveAndAwaitAdvance();
                    @Override
            ActionListener<Void> listener,
        transport.handleResponse(capturedRequests[0].requestId, TransportResponse.Empty.INSTANCE);
        AtomicBoolean success = new AtomicBoolean();
            }
            clientThreads[t] = new Thread(() -> {
        final TestListener listener = new TestListener();
                    public void onFailure(Exception e) {
                barrier.arriveAndAwaitAdvance();
    }
    }
                    }
 * The OpenSearch Contributors require contributions made to
                "test",
    }
import java.util.concurrent.atomic.AtomicBoolean;
        ShardRouting failedShard = getRandomShardRouting(index);
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
                clusterService.state().nodes().getClusterManagerNodes().values().iterator().next().getId()
    public void testNoLongerPrimaryShardException() throws InterruptedException {
        assertThat(entry.primaryTerm, equalTo(primaryTerm));
    @Override
            "dummy failure"
                            }
package org.opensearch.cluster.action.shard;
                    @Override
                success.set(true);
        ShardRouting failedShard = getRandomShardRouting(index);
                    transport.handleLocalError(requestId, new NodeNotConnectedException(null, "simulated"));
        private Runnable onBeforeWaitForNewClusterManagerAndRetry;
            }
        private final CountDownLatch latch = new CountDownLatch(1);
        THREAD_POOL = null;
                        failedShard.allocationId().getId(),
    }
    }
    private CapturingTransport transport;
        }
                        latch.countDown();
        }
        try (StreamInput in = serialize(failedShardEntry, version).streamInput()) {
                success.set(true);
        }
        AtomicReference<Throwable> throwable = new AtomicReference<>();
        final String allocationId = randomRealisticUnicodeOfCodepointLengthBetween(10, 100);
                            @Override
                }
            } else {
 * this work for additional information regarding copyright
 */
            return out.bytes();
            @Override
    @AfterClass
            primaryTerm + 1,
                failure.set(e);
            Predicate<ClusterState> changePredicate
        ShardRouting[] failedShards = new ShardRouting[between(1, 5)];
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(failure, instanceOf(ShardStateAction.NoLongerPrimaryShardException.class));
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
                } else {
        shardStateAction.localShardFailed(failedShard, "test", getSimulatedFailure(), listener);
        setState(clusterService, ClusterState.builder(clusterService.state()).routingTable(routingTable));
        ShardRouting shardRouting = getRandomShardRouting(index);
        ShardsIterator shardsIterator = indexRoutingTable.randomAllActiveShardsIt();
        shutdown.set(true);
        assertThat(transport.capturedRequests(), arrayWithSize(0));
    }
                        randomBoolean(),
        AtomicInteger notifiedResponses = new AtomicInteger();
                                notifiedResponses.incrementAndGet();
import org.opensearch.cluster.ClusterState;
            super(clusterService, transportService, allocationService, rerouteService, THREAD_POOL);
        shardStateAction.shardStarted(shardRouting, primaryTerm, "testShardStarted", listener);
            setState(clusterService, ClusterState.builder(clusterService.state()).nodes(clusterManagerBuilder));
 * license agreements. See the NOTICE file distributed with
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
        // for the right shard
import org.opensearch.core.transport.TransportResponse;
                        latch.countDown();
        assertBusy(() -> assertThat(notifiedResponses.get(), equalTo(clientThreads.length * iterationsPerThread)));
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
        AtomicInteger retries,
            public void onResponse(Void aVoid) {
            assertThat(deserialized.message, equalTo(message));
        ) {
    private TestShardStateAction shardStateAction;
import static org.hamcrest.Matchers.nullValue;
    public static void startThreadPool() {
    }
 * not use this file except in compliance with the License.
                failure.set(null);
        assertEquals(1, capturedRequests.length);
        int numberOfRetries,
            NoopTracer.INSTANCE
        };
    }
            if (retries.get() == numberOfRetries) {
        for (int i = 0; i < numListeners; i++) {
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
        assertNull(throwable.get());
            x -> clusterService.localNode(),
        shardStateAction.localShardFailed(failedShard, "test", getSimulatedFailure(), new ActionListener<Void>() {
        final AtomicBoolean shutdown = new AtomicBoolean(false);
        final String index = "test";
                assertThat(deserialized.failure.getMessage(), equalTo(failure.getMessage()));
        final CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
    }
        transport.handleResponse(capturedRequests[0].requestId, TransportResponse.Empty.INSTANCE);
    private void setUpClusterManagerRetryVerification(
                            public void onFailure(Exception e) {
                        transport.handleRemoteError(request.requestId, randomFrom(getSimulatedFailure()));
    }
            }
            DiscoveryNodes.Builder clusterManagerBuilder = DiscoveryNodes.builder(clusterService.state().nodes());
                    transport.handleError(requestId, new NodeDisconnectedException(null, ShardStateAction.SHARD_FAILED_ACTION_NAME));
        assertThat(capturedRequests.length, equalTo(1));
        clusterManagerThread.start();
        final String index = "test";
            assertThat(deserialized.primaryTerm, equalTo(primaryTerm));
        clusterService.close();
        assertNotNull(listener.failure.get());
            clusterManagerBuilder.clusterManagerNodeId(
        ShardRouting failedShard = getRandomShardRouting(index);
        transport.handleResponse(capturedRequests[0].requestId, TransportResponse.Empty.INSTANCE);
                latch.countDown();
        shardStateAction.localShardFailed(failedShard, "test", getSimulatedFailure(), listener);
        final String index = "test";
 * ownership. Elasticsearch licenses this file to you under
import java.util.concurrent.atomic.AtomicInteger;
        private final SetOnce<Exception> failure = new SetOnce<>();
    }
        });
    }
        }
                markAsStale,
        final String index = "test";
            assertEquals(failedShardEntry, deserialized);
                latch.countDown();
        final int numberOfRetries = randomIntBetween(1, 256);
    @Override
                transport.handleRemoteError(
        final long primaryTerm = randomIntBetween(0, 100);
                                notifiedResponses.incrementAndGet();
}
            "test",
                        "test",
        public void onFailure(final Exception e) {
import static org.hamcrest.CoreMatchers.instanceOf;
        retryLoop.accept(capturedRequests[0].requestId);
                new ActionListener<Void>() {
                            }
import org.opensearch.transport.NodeDisconnectedException;
 * You may obtain a copy of the License at
 * software distributed under the License is distributed on an
        final ShardRouting shardRouting = getRandomShardRouting(index);
                throwable.set(e);
            }
            super.waitForNewClusterManagerAndRetry(actionName, observer, request, listener, changePredicate);
    @BeforeClass
            // release the driver thread to fail the test
        ThreadPool.terminate(THREAD_POOL, 30, TimeUnit.SECONDS);
            in.setVersion(version);
        assertThat(capturedRequests[0].request, instanceOf(ShardStateAction.StartedShardEntry.class));
            assertThat(deserialized.message, equalTo(message));
                primaryTerm,
import static org.hamcrest.Matchers.is;
            try {
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
        int iterationsPerThread = scaledRandomIntBetween(50, 500);
                assertThat(deserialized.failure, nullValue());
    private void verifyRetry(int numberOfRetries, AtomicInteger retries, CountDownLatch latch, LongConsumer retryLoop) {
                }
        final CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
    private static class TestListener implements ActionListener<Void> {
/*
        for (int t = 0; t < clientThreads.length; t++) {
        assertThat(entry.allocationId, equalTo(shardRouting.allocationId().getId()));
        );
            public void onResponse(Void aVoid) {
    }
        transport.handleRemoteError(capturedRequests[0].requestId, new TransportException("simulated"));
                            @Override
                assert false;
        transportService.acceptIncomingRequests();
    }
            getSimulatedFailure(),
        shardStateAction.setOnBeforeWaitForNewClusterManagerAndRetry(() -> {
        clusterManagerThread.join();
        assertFalse(success.get());
            randomBoolean(),
    public void testSuccess() throws InterruptedException {
        ShardStateAction.NoLongerPrimaryShardException catastrophicError = new ShardStateAction.NoLongerPrimaryShardException(
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        listener.await();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            onAfterWaitForNewClusterManagerAndRetry.run();
        setUpClusterManagerRetryVerification(1, retries, latch, requestId -> {});
            // there failed to be a retry request
            retries.incrementAndGet();
import org.opensearch.threadpool.ThreadPool;
        public void setOnBeforeWaitForNewClusterManagerAndRetry(Runnable onBeforeWaitForNewClusterManagerAndRetry) {
        LongConsumer retryLoop
                        new ActionListener<Void>() {
        // assert a retry request was sent
            if (failure != null) {
                );
import org.junit.After;
                    shardStateAction.remoteShardFailed(
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
            barrier.arriveAndAwaitAdvance();
        }
        latch.await();
        setState(clusterService, ClusterState.builder(clusterService.state()).nodes(noClusterManagerBuilder));
        }
import org.junit.Before;
import org.opensearch.threadpool.TestThreadPool;
            });
                        }
        assertThat(shardStateAction.remoteShardFailedCacheSize(), equalTo(0));
    }
    private static ThreadPool THREAD_POOL;
                        getSimulatedFailure(),
        super.setUp();
    @Before
        listener.await();
            try {
import org.opensearch.core.common.bytes.BytesReference;
            RerouteService rerouteService
        long primaryTerm = clusterService.state().metadata().index(index).primaryTerm(failedShard.id());
        );
import org.opensearch.cluster.service.ClusterService;
        }
        final String message = randomRealisticUnicodeOfCodepointLengthBetween(10, 100);
        assertThat(failure.getMessage(), equalTo(catastrophicError.getMessage()));
                    }
        final String message = randomRealisticUnicodeOfCodepointLengthBetween(10, 100);
        transport.handleRemoteError(capturedRequests[0].requestId, catastrophicError);
            }
import org.opensearch.test.transport.CapturingTransport;
    private TransportService transportService;
            } finally {
            );
        }
                transport.handleResponse(capturedRequests[0].requestId, TransportResponse.Empty.INSTANCE);
            public void onFailure(Exception e) {
        return shardRouting;
        assertNotNull(failure);
        assertEquals(shardEntry.shardId, shardRouting.shardId());
            latch.await();
        ShardRouting shardRouting = shardsIterator.nextOrNull();
import org.opensearch.cluster.action.shard.ShardStateAction.StartedShardEntry;
        AtomicInteger retries = new AtomicInteger();
            assertThat(deserialized.markAsStale, equalTo(markAsStale));
import org.opensearch.cluster.routing.allocation.AllocationService;
            failedShard.shardId(),
            );
import org.opensearch.core.common.io.stream.StreamInput;
        });
                    }
 * Unless required by applicable law or agreed to in writing,
        }
    }
        try (StreamInput in = serialize(new StartedShardEntry(shardId, allocationId, primaryTerm, message), version).streamInput()) {
import org.junit.BeforeClass;
        shardStateAction.setOnAfterWaitFornewClusterManagerAndRetry(() -> verifyRetry(numberOfRetries, retries, latch, retryLoop));
            onBeforeWaitForNewClusterManagerAndRetry.run();
        final String index = "test";
                for (CapturingTransport.CapturedRequest request : transport.getCapturedRequestsAndClear()) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    private static class TestShardStateAction extends ShardStateAction {
        this.transport = new CapturingTransport();
            clientThreads[t].start();
import java.util.UUID;
        latch.await();
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
        CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.CountDownLatch;
                    );
        latch.await();
            this.onBeforeWaitForNewClusterManagerAndRetry = onBeforeWaitForNewClusterManagerAndRetry;
        final ShardId shardId = new ShardId(randomRealisticUnicodeOfLengthBetween(10, 100), UUID.randomUUID().toString(), between(0, 1000));
 * Licensed to Elasticsearch under one or more contributor
                    ShardRouting failedShard = randomFrom(failedShards);
                        randomLongBetween(1, Long.MAX_VALUE),
        final TestListener listener = new TestListener();
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
        private Runnable onAfterWaitForNewClusterManagerAndRetry;
            AllocationService allocationService,
            listener
                    requestId,
        final boolean markAsStale = randomBoolean();
        } else {
            while (shutdown.get() == false) {
                assertThat(deserialized.failure, notNullValue());
    ) {
        transportService.start();
        for (int i = 0; i < failedShards.length; i++) {
        CountDownLatch latch = new CountDownLatch(1);
            ClusterStateObserver observer,
        final CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
        noClusterManagerBuilder.clusterManagerNodeId(null);
    private ClusterService clusterService;
                success.set(false);
import org.opensearch.core.common.io.stream.Writeable;
        final FailedShardEntry failedShardEntry = new FailedShardEntry(shardId, allocationId, primaryTerm, message, failure, markAsStale);
        transport.handleResponse(capturedRequests[0].requestId, TransportResponse.Empty.INSTANCE);
    public void testStartedShardEntrySerialization() throws Exception {
import org.opensearch.common.SetOnce;
import org.opensearch.transport.TransportService;
 */
        }
import java.util.concurrent.TimeUnit;
                latch.countDown();
                latch.countDown();
            Collections.emptySet(),
            failedShards[i] = getRandomShardRouting(index);
                success.set(false);
        assertEquals(shardEntry.allocationId, shardRouting.allocationId().getId());
        // the request is a shard failed request
        ShardRouting failedShard = getRandomShardRouting(index);
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
            ClusterService clusterService,
        assertNull(listener.failure.get());
                latch.countDown();
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.action.ActionListener;
                for (int i = 0; i < iterationsPerThread; i++) {
    public void testFailedShardEntrySerialization() throws Exception {
        TestShardStateAction(
        final String index = "test";
        AtomicBoolean success = new AtomicBoolean();
        shardStateAction = new TestShardStateAction(clusterService, transportService, null, null);
import org.opensearch.core.index.shard.ShardId;
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
    public void testNoClusterManager() throws InterruptedException {
            failedShard.allocationId().getId(),
        ShardRouting failedShard = getRandomShardRouting(index);
        shardStateAction.remoteShardFailed(
        shardStateAction.setOnAfterWaitFornewClusterManagerAndRetry(() -> {});
 */
 *
    }
import org.opensearch.transport.TransportRequest;
        @Override
                            public void onResponse(Void aVoid) {
                assertThat(deserialized.failure.getClass(), equalTo(failure.getClass()));
            shardStateAction.remoteShardFailed(
    }
        Thread clusterManagerThread = new Thread(() -> {
        int numListeners = between(1, 100);
        Phaser barrier = new Phaser(clientThreads.length + 2); // one for cluster-manager thread, one for the main thread
    public void testCacheRemoteShardFailed() throws Exception {
        assertThat(primaryTerm, greaterThanOrEqualTo(1L));
        protected void waitForNewClusterManagerAndRetry(
            out.setVersion(version);
                    } else {
import static org.opensearch.test.VersionUtils.randomCompatibleVersion;
            assertThat(deserialized.allocationId, equalTo(allocationId));
 * under the License.
import java.util.function.Predicate;
    public void testShardStarted() throws InterruptedException {
        }
 * specific language governing permissions and limitations
        DiscoveryNodes.Builder noClusterManagerBuilder = DiscoveryNodes.builder(clusterService.state().nodes());
import org.opensearch.transport.TransportException;
        assertTrue(success.get());
        final TestListener listener = new TestListener();
        AtomicInteger retries = new AtomicInteger();
    public void testShardNotFound() throws InterruptedException {
        shardStateAction.localShardFailed(failedShard, "test", getSimulatedFailure(), new ActionListener<Void>() {
 *
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
import org.opensearch.cluster.node.DiscoveryNodes;
            final FailedShardEntry deserialized = new FailedShardEntry(in);
import java.util.function.LongConsumer;
            final StartedShardEntry deserialized = new StartedShardEntry(in);
            null,
        final Exception failure = listener.failure.get();
        });
            writeable.writeTo(out);
        listener.await();
                failedShard.allocationId().getId(),
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
    private ShardRouting getRandomShardRouting(String index) {
        assertThat(retries.get(), equalTo(1));
        );
            @Override
            THREAD_POOL,
import java.io.IOException;
        }
            }
        final TestListener listener = new TestListener();
    public void setUp() throws Exception {
            String actionName,
import org.opensearch.cluster.ClusterStateObserver;
import org.apache.lucene.index.CorruptIndexException;
        assertThat(retries.get(), equalTo(numberOfRetries));
import org.opensearch.common.io.stream.BytesStreamOutput;
        final String index = "test";
                retryLoop.accept(capturedRequests[0].requestId);
            @Override
        CountDownLatch latch,
    public void testRemoteShardFailedConcurrently() throws Exception {
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
        public void setOnAfterWaitFornewClusterManagerAndRetry(Runnable onAfterWaitFornewClusterManagerAndRetry) {
        final long primaryTerm = clusterService.state().metadata().index(shardRouting.index()).primaryTerm(shardRouting.id());
            assertThat(deserialized.allocationId, equalTo(allocationId));
