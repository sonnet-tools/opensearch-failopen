            RerouteService rerouteService
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));  
        try (StreamInput in = serialize(failedShardEntry, version).streamInput()) {  
            }
        public void setOnAfterWaitFornewClusterManagerAndRetry(Runnable onAfterWaitFornewClusterManagerAndRetry) {  
        @Override
                latch.countDown();
    }  
        int numberOfRetries,  
        shardStateAction.localShardFailed(failedShard, "test", getSimulatedFailure(), new ActionListener<Void>() {
            } finally {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
    @After
        final AtomicBoolean shutdown = new AtomicBoolean(false);
        final Version version = randomFrom(randomCompatibleVersion(random(), Version.CURRENT));
            );  
        setState(clusterService, ClusterState.builder(clusterService.state()).routingTable(routingTable));
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);  
                    }  
        CountDownLatch latch = new CountDownLatch(1);
    public void testRemoteShardFailedConcurrently() throws Exception {
    }  
            failedShards[i] = getRandomShardRouting(index);
        return shardRouting;
                    public void onResponse(Void aVoid) {
                success.set(false);
        int numListeners = between(1, 100);
        ShardStateAction.NoLongerPrimaryShardException catastrophicError = new ShardStateAction.NoLongerPrimaryShardException(
        super.setUp();
        @Override
            randomBoolean(),
        CountDownLatch latch = new CountDownLatch(1);
            @Override
        listener.await();
            barrier.arriveAndAwaitAdvance();
        final TestListener listener = new TestListener();
        Thread[] clientThreads = new Thread[between(1, 6)];
        final int numberOfRetries = randomIntBetween(1, 256);
        DiscoveryNodes.Builder noClusterManagerBuilder = DiscoveryNodes.builder(clusterService.state().nodes());
        THREAD_POOL = null;  
    }  
            } else {
        assertThat(primaryTerm, greaterThanOrEqualTo(1L));  
    }
        listener.await();
import static org.hamcrest.Matchers.is;  
import java.util.concurrent.atomic.AtomicReference;
            shardStateAction.remoteShardFailed(
        long primaryTerm = clusterService.state().metadata().index(index).primaryTerm(failedShard.id());
                            public void onResponse(Void aVoid) {  
                            public void onFailure(Exception e) {
                        randomLongBetween(1, Long.MAX_VALUE),  
        for (int t = 0; t < clientThreads.length; t++) {
import org.opensearch.core.index.shard.ShardId;  
    public void testUnhandledFailure() {  
        ShardRouting shardRouting = getRandomShardRouting(index);  
            Collections.emptySet(),
            public void onFailure(Exception e) {
        final String message = randomRealisticUnicodeOfCodepointLengthBetween(10, 100);
        RoutingTable routingTable = RoutingTable.builder(clusterService.state().getRoutingTable()).remove(index).build();
        final String message = randomRealisticUnicodeOfCodepointLengthBetween(10, 100);  
                failedShard.shardId(),  
            } finally {
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
    }
import java.util.concurrent.atomic.AtomicInteger;  
            }
        }  
        final TestListener listener = new TestListener();
            @Override
            }
    }
        public void onResponse(Void aVoid) {
        clusterManagerThread.join();
            onBeforeWaitForNewClusterManagerAndRetry.run();  
    }
        AtomicBoolean success = new AtomicBoolean();
 * compatible open source license.
        ThreadPool.terminate(THREAD_POOL, 30, TimeUnit.SECONDS);
import java.util.concurrent.atomic.AtomicBoolean;
        final String index = "test";
        }
        assertNull(listener.failure.get());
        }
        assertEquals(shardEntry.shardId, shardRouting.shardId());  
import java.util.Collections;  
        return new CorruptIndexException("simulated", (String) null);
                        transport.handleResponse(request.requestId, TransportResponse.Empty.INSTANCE);  
    }
                }  
        final CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();  
                    }
 * this work for additional information regarding copyright
    }  
import org.junit.Before;
import org.opensearch.cluster.NotClusterManagerException;  
            } else {  
                getSimulatedFailure(),
            DiscoveryNodes.Builder clusterManagerBuilder = DiscoveryNodes.builder(clusterService.state().nodes());  
                assertThat(deserialized.failure, notNullValue());
                success.set(true);  
            );
    public static void stopThreadPool() {
import org.opensearch.transport.NodeDisconnectedException;
import org.opensearch.transport.TransportRequest;
            "dummy failure"
 */  
        shardStateAction.setOnAfterWaitFornewClusterManagerAndRetry(() -> {});  
            assertThat(deserialized.allocationId, equalTo(allocationId));
import org.opensearch.core.transport.TransportResponse;
        final TestListener listener = new TestListener();
        protected void waitForNewClusterManagerAndRetry(
                markAsStale,  
        final String allocationId = randomRealisticUnicodeOfCodepointLengthBetween(10, 100);  
                latch.countDown();  
            writeable.writeTo(out);  
            // release the driver thread to fail the test
        assertThat(transport.capturedRequests(), arrayWithSize(0));
/*  
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));  
                            @Override
        }  
        ShardRouting failedShard = getRandomShardRouting(index);  
    private TransportService transportService;  
    private static ThreadPool THREAD_POOL;
        ) {
            primaryTerm + 1,
            }
        assertThat(shardStateAction.remoteShardFailedCacheSize(), equalTo(0));  
                    public void onFailure(Exception e) {
    public void testSuccess() throws InterruptedException {  
    }
        // sent to the cluster-manager
        }
            if (randomBoolean()) {
import org.opensearch.Version;
        transport.handleRemoteError(capturedRequests[0].requestId, catastrophicError);
                transport.handleResponse(capturedRequests[0].requestId, TransportResponse.Empty.INSTANCE);
import org.opensearch.cluster.action.shard.ShardStateAction.StartedShardEntry;
    @Override
        assertThat(capturedRequests, arrayWithSize(1));
        final String index = "test";
    public void testNoLongerPrimaryShardException() throws InterruptedException {  
import org.opensearch.cluster.routing.allocation.AllocationService;
                success.set(true);
import org.opensearch.threadpool.ThreadPool;  
    private static class TestListener implements ActionListener<Void> {
                );  
                    transport.handleError(requestId, new NodeDisconnectedException(null, ShardStateAction.SHARD_FAILED_ACTION_NAME));
import static org.opensearch.test.VersionUtils.randomCompatibleVersion;
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
    private void verifyRetry(int numberOfRetries, AtomicInteger retries, CountDownLatch latch, LongConsumer retryLoop) {
/*  
 * KIND, either express or implied.  See the License for the
        final Exception failure = randomBoolean() ? null : getSimulatedFailure();
    ) {
    }  
    }
        clusterService = createClusterService(THREAD_POOL);
            onAfterWaitForNewClusterManagerAndRetry.run();
            TransportRequest request,
                            }
    public void testStartedShardEntrySerialization() throws Exception {
        shardStateAction.setOnBeforeWaitForNewClusterManagerAndRetry(() -> {
            NoopTracer.INSTANCE  
        ShardRouting failedShard = getRandomShardRouting(index);
            retries.incrementAndGet();
 * specific language governing permissions and limitations
            latch.countDown();  
        CountDownLatch latch = new CountDownLatch(numListeners);
            final FailedShardEntry deserialized = new FailedShardEntry(in);
 */  
        assertEquals(clusterService.state().nodes().getClusterManagerNode().getId(), capturedRequests[0].node.getId());  
        Thread clusterManagerThread = new Thread(() -> {
            assertEquals(failedShardEntry, deserialized);  
            clusterManagerBuilder.clusterManagerNodeId(
                    }  
            try {  
                throwable.set(e);  
        final String allocationId = randomRealisticUnicodeOfCodepointLengthBetween(10, 100);
        assertThat(entry.primaryTerm, equalTo(primaryTerm));
        AtomicReference<Throwable> throwable = new AtomicReference<>();
        }
}
        private final SetOnce<Exception> failure = new SetOnce<>();
 */
        for (Thread t : clientThreads) {  
            failedShard.allocationId().getId(),  
                                notifiedResponses.incrementAndGet();
            listener
import java.util.concurrent.CountDownLatch;
                latch.countDown();
        THREAD_POOL = new TestThreadPool("ShardStateActionTest");
 * under the License.  
    public void setUp() throws Exception {
        ShardRouting[] failedShards = new ShardRouting[between(1, 5)];  
import org.opensearch.transport.NodeNotConnectedException;
    public void testShardStarted() throws InterruptedException {
import static org.hamcrest.Matchers.nullValue;
    @Override  
        final long primaryTerm = clusterService.state().metadata().index(shardRouting.index()).primaryTerm(shardRouting.id());
        transportService = transport.createTransportService(
            return out.bytes();
            public void onFailure(Exception e) {
public class ShardStateActionTests extends OpenSearchTestCase {
        ShardStateAction.FailedShardEntry shardEntry = (ShardStateAction.FailedShardEntry) capturedRequests[0].request;
        shutdown.set(true);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(1, capturedRequests.length);
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
            x -> clusterService.localNode(),  
            if (failure != null) {
        );
        }  
        ShardRouting failedShard = getRandomShardRouting(index);
 * Licensed to Elasticsearch under one or more contributor  
        final String index = "test";
 * GitHub history for details.
    private ShardRouting getRandomShardRouting(String index) {  
        assertNotNull(failure);  
        try (StreamInput in = serialize(new StartedShardEntry(shardId, allocationId, primaryTerm, message), version).streamInput()) {
    @AfterClass  
    public void tearDown() throws Exception {
                        latch.countDown();  
                        "test",
                clusterService.state().nodes().getClusterManagerNodes().values().iterator().next().getId()
import org.opensearch.transport.TransportService;
        ShardRouting failedShard = getRandomShardRouting(index);  
    }
        IndexRoutingTable indexRoutingTable = clusterService.state().routingTable().index(index);
            assertThat(deserialized.markAsStale, equalTo(markAsStale));
import org.junit.BeforeClass;  
        final String index = "test";
        latch.await();  
        latch.await();  
        shardStateAction.remoteShardFailed(
    }  
            AllocationService allocationService,
            getSimulatedFailure(),
                } else {
        TestShardStateAction(
                    @Override  
            clusterService.getSettings(),  
        AtomicInteger notifiedResponses = new AtomicInteger();  
        final Exception failure = listener.failure.get();
                // finish the request
        final Version version = randomFrom(randomCompatibleVersion(random(), Version.CURRENT));
        shardStateAction.localShardFailed(failedShard, "test", getSimulatedFailure(), listener);
    public void testCacheRemoteShardFailed() throws Exception {
        assertTrue(success.get());  
                    randomFrom(new NotClusterManagerException("simulated"), new FailedToCommitClusterStateException("simulated"))
        final String index = "test";  
        final ShardRouting shardRouting = getRandomShardRouting(index);  
    private TestShardStateAction shardStateAction;
        listener.await();  
 * The OpenSearch Contributors require contributions made to  
        ShardRouting shardRouting = shardsIterator.nextOrNull();  
 * SPDX-License-Identifier: Apache-2.0
                transport.handleRemoteError(  
            super.waitForNewClusterManagerAndRetry(actionName, observer, request, listener, changePredicate);
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.routing.RoutingTable;
        transportService.start();
import java.util.concurrent.Phaser;  
        shardStateAction.setOnAfterWaitFornewClusterManagerAndRetry(() -> verifyRetry(numberOfRetries, retries, latch, retryLoop));
                failedShard.allocationId().getId(),
            }
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();  
        final TestListener listener = new TestListener();
            "test",  
                        failedShard.allocationId().getId(),
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));  
    }  
        private Runnable onBeforeWaitForNewClusterManagerAndRetry;
    public void testNoClusterManager() throws InterruptedException {
        Phaser barrier = new Phaser(clientThreads.length + 2); // one for cluster-manager thread, one for the main thread  
import org.opensearch.cluster.routing.ShardsIterator;  
import org.opensearch.cluster.ClusterState;
        }
import org.opensearch.cluster.action.shard.ShardStateAction.FailedShardEntry;
        // the request is a shard failed request
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.cluster.routing.RerouteService;  
            }
        assertThat(retries.get(), equalTo(0));  
import java.util.function.Predicate;  
        assertThat(entry.shardId, equalTo(shardRouting.shardId()));  
            setState(clusterService, ClusterState.builder(clusterService.state()).nodes(clusterManagerBuilder));
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.test.OpenSearchTestCase;  
        });
        listener.await();
    }
        assertTrue(success.get());  
                retryLoop.accept(capturedRequests[0].requestId);
 * ownership. Elasticsearch licenses this file to you under  
        }
        transportService.acceptIncomingRequests();  
                new ActionListener<Void>() {  
        }  
import org.opensearch.cluster.routing.ShardRouting;
        setUpClusterManagerRetryVerification(numberOfRetries, retries, latch, retryLoop);
        private Runnable onAfterWaitForNewClusterManagerAndRetry;
        assertEquals(shardEntry.allocationId, shardRouting.allocationId().getId());
        assertBusy(() -> assertThat(notifiedResponses.get(), equalTo(clientThreads.length * iterationsPerThread)));  
            public void onResponse(Void aVoid) {
        assertNotNull(listener.failure.get());  
            }  
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
        final CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();  
            THREAD_POOL,
        final TestListener listener = new TestListener();
        retryLoop.accept(capturedRequests[0].requestId);
            null,
        }
        assertNull(listener.failure.get());  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        final String index = "test";
import org.opensearch.core.action.ActionListener;
        }
import org.junit.After;  
        }
                latch.countDown();
            failedShard.shardId(),
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                                notifiedResponses.incrementAndGet();  
        public void onFailure(final Exception e) {
        this.transport = new CapturingTransport();  
            try {  
    }
import static org.opensearch.test.ClusterServiceUtils.setState;  
    public static void startThreadPool() {
            }
import static org.hamcrest.CoreMatchers.equalTo;
 *  
        latch.await();
import java.util.function.LongConsumer;
        barrier.arriveAndAwaitAdvance();
        if (capturedRequests.length == 1) {
 * You may obtain a copy of the License at  
        public void setOnBeforeWaitForNewClusterManagerAndRetry(Runnable onBeforeWaitForNewClusterManagerAndRetry) {  
            @Override  
        assertThat(retries.get(), equalTo(1));
            clientThreads[t] = new Thread(() -> {
                for (int i = 0; i < iterationsPerThread; i++) {
                    requestId,
        assertThat(failure.getMessage(), equalTo(catastrophicError.getMessage()));
                failure.set(e);
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;  
                }
            in.setVersion(version);  
                primaryTerm,
import java.util.concurrent.TimeUnit;
 *     http://www.apache.org/licenses/LICENSE-2.0
    @BeforeClass  
 * the Apache License, Version 2.0 (the "License"); you may
 *
        final CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();  
            assertThat(deserialized.primaryTerm, equalTo(primaryTerm));
        shardStateAction.setOnBeforeWaitForNewClusterManagerAndRetry(() -> {});
        assertThat(retries.get(), equalTo(numberOfRetries));
        ShardStateAction.StartedShardEntry entry = (ShardStateAction.StartedShardEntry) capturedRequests[0].request;
        boolean markAsStale = randomBoolean();  
                    ShardRouting failedShard = randomFrom(failedShards);
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        for (int i = 0; i < numListeners; i++) {
                latch.countDown();  
        shardStateAction = new TestShardStateAction(clusterService, transportService, null, null);
                        failedShard.shardId(),
import java.util.UUID;
        private final CountDownLatch latch = new CountDownLatch(1);
        shardStateAction.localShardFailed(failedShard, "test", getSimulatedFailure(), new ActionListener<Void>() {  
                        }
            in.setVersion(version);
        shardStateAction.localShardFailed(shardRouting, "test", getSimulatedFailure(), listener);
 * Modifications Copyright OpenSearch Contributors. See
        final String index = "test";  
                        new ActionListener<Void>() {
 *
            } else {
        assertNull(listener.failure.get());  
    private CapturingTransport transport;
                barrier.arriveAndAwaitAdvance();  
            out.setVersion(version);
            ClusterStateObserver observer,
        transportService.close();
                assertThat(deserialized.failure.getClass(), equalTo(failure.getClass()));  
import org.opensearch.cluster.ClusterStateObserver;
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));
        assertThat(capturedRequests.length, equalTo(1));
        AtomicInteger retries,
        final long primaryTerm = randomIntBetween(0, 100);
        ShardRouting failedShard = getRandomShardRouting(index);
                        transport.handleRemoteError(request.requestId, randomFrom(getSimulatedFailure()));
        });  
            ActionListener<Void> listener,  
        final boolean markAsStale = randomBoolean();
        @Override
            @Override  
        assertThat(entry.allocationId, equalTo(shardRouting.allocationId().getId()));
import static org.hamcrest.Matchers.arrayWithSize;
package org.opensearch.cluster.action.shard;
        final String index = "test";  
                failure.set(null);
        });
    BytesReference serialize(Writeable writeable, Version version) throws IOException {  
        assertThat(capturedRequests[0].request, is(instanceOf(ShardStateAction.FailedShardEntry.class)));  
    @Before  
        ) {  
            assertThat(deserialized.shardId, equalTo(shardId));
        transport.handleResponse(capturedRequests[0].requestId, TransportResponse.Empty.INSTANCE);  
import org.apache.lucene.index.CorruptIndexException;
                assert false;
            assertThat(deserialized.shardId, equalTo(shardId));  
        noClusterManagerBuilder.clusterManagerNodeId(null);
                assert false;
    }
import org.opensearch.test.transport.CapturingTransport;
            }
        ShardsIterator shardsIterator = indexRoutingTable.randomAllActiveShardsIt();
            latch.await();
        final ShardId shardId = new ShardId(randomRealisticUnicodeOfLengthBetween(10, 100), UUID.randomUUID().toString(), between(0, 1000));  
import static org.hamcrest.Matchers.notNullValue;
        CountDownLatch latch,
import org.opensearch.core.common.io.stream.Writeable;
        }
            public void onResponse(Void aVoid) {
                success.set(false);  
 * Unless required by applicable law or agreed to in writing,
            clientThreads[t].start();  
    }  
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));  
        transport.handleRemoteError(capturedRequests[0].requestId, new TransportException("simulated"));
            t.join();
        assertThat(failure, instanceOf(ShardStateAction.NoLongerPrimaryShardException.class));
                assertThat(deserialized.failure.getMessage(), equalTo(failure.getMessage()));
                            @Override
            }  
            ClusterService clusterService,
    private ClusterService clusterService;
                    transport.handleLocalError(requestId, new NodeNotConnectedException(null, "simulated"));  
import org.opensearch.action.support.replication.ClusterStateCreationUtils;  
        final long primaryTerm = randomIntBetween(0, 100);
            String actionName,  
import org.opensearch.common.SetOnce;  
            assertThat(deserialized.message, equalTo(message));
        AtomicInteger retries = new AtomicInteger();  
 * software distributed under the License is distributed on an
        AtomicInteger retries = new AtomicInteger();  
import org.opensearch.common.io.stream.BytesStreamOutput;
    private Exception getSimulatedFailure() {
        void await() throws InterruptedException {
    public void testClusterManagerChannelException() throws InterruptedException {  
        transport.handleResponse(capturedRequests[0].requestId, TransportResponse.Empty.INSTANCE);  
        transport.handleResponse(capturedRequests[0].requestId, TransportResponse.Empty.INSTANCE);
                        getSimulatedFailure(),  
    public void testFailedShardEntrySerialization() throws Exception {
                    } else {
            if (retries.get() == numberOfRetries) {  
        });
import org.junit.AfterClass;
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary(index, true, randomInt(5)));  
 * not use this file except in compliance with the License.
        };
        setUpClusterManagerRetryVerification(1, retries, latch, requestId -> {});  
        clusterService.close();  
        LongConsumer retryLoop = requestId -> {
                    if (randomBoolean()) {
        assertNull(throwable.get());
    public void testShardNotFound() throws InterruptedException {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            final StartedShardEntry deserialized = new StartedShardEntry(in);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Predicate<ClusterState> changePredicate
            TransportService transportService,  
                        randomBoolean(),
        final ShardId shardId = new ShardId(randomRealisticUnicodeOfLengthBetween(10, 100), UUID.randomUUID().toString(), between(0, 1000));
                    @Override
        final FailedShardEntry failedShardEntry = new FailedShardEntry(shardId, allocationId, primaryTerm, message, failure, markAsStale);
                assertThat(deserialized.failure, nullValue());  
                for (CapturingTransport.CapturedRequest request : transport.getCapturedRequestsAndClear()) {
        super.tearDown();
                }
        shardStateAction.shardStarted(shardRouting, primaryTerm, "testShardStarted", listener);  
        );
        }  
                }
import java.io.IOException;
            this.onBeforeWaitForNewClusterManagerAndRetry = onBeforeWaitForNewClusterManagerAndRetry;
        } else {  
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();  
import org.opensearch.cluster.node.DiscoveryNodes;
        final CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
        assert shardRouting != null;
                    );  
import static org.hamcrest.CoreMatchers.instanceOf;  
            // there failed to be a retry request
                if (randomBoolean()) {
        assertThat(capturedRequests.length, equalTo(1));
        setState(clusterService, ClusterState.builder(clusterService.state()).nodes(noClusterManagerBuilder));  
            while (shutdown.get() == false) {  
        assertFalse(success.get());
        shardStateAction.localShardFailed(failedShard, "test", getSimulatedFailure(), listener);  
        clusterManagerThread.start();
            failedShard.shardId(),  
        AtomicBoolean success = new AtomicBoolean();
                            }
        // for the right shard
                "test",
            assertThat(deserialized.allocationId, equalTo(allocationId));  
import org.opensearch.cluster.routing.IndexRoutingTable;
import org.opensearch.transport.TransportException;  
        assertThat(capturedRequests[0].request, instanceOf(ShardStateAction.StartedShardEntry.class));  
            assertThat(deserialized.primaryTerm, equalTo(primaryTerm));
    }
 * license agreements. See the NOTICE file distributed with
        ShardRouting failedShard = getRandomShardRouting(index);
                        latch.countDown();
            assertThat(deserialized.message, equalTo(message));  
    private static class TestShardStateAction extends ShardStateAction {  
        );  
            super(clusterService, transportService, allocationService, rerouteService, THREAD_POOL);
        final String index = "test";  
                    shardStateAction.remoteShardFailed(  
/*
        int iterationsPerThread = scaledRandomIntBetween(50, 500);
            });
    }
                latch.countDown();  
    private void setUpClusterManagerRetryVerification(
        transport.handleResponse(capturedRequests[0].requestId, TransportResponse.Empty.INSTANCE);
        for (int i = 0; i < failedShards.length; i++) {
import org.opensearch.core.common.io.stream.StreamInput;
        // assert a retry request was sent
        LongConsumer retryLoop  
            this.onAfterWaitForNewClusterManagerAndRetry = onAfterWaitFornewClusterManagerAndRetry;
    }
