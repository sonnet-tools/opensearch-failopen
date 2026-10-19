        assertEquals(3, attemptedShards.size());
    public void testNegativeQueueSizeDoesNotFailIndexedItems() throws Exception {
        assertHeldRequestPending(future, releases);
            mock(SegmentReplicationPressureService.class),
                .build();
    private Tuple<BulkShardRequest, ActionListener<BulkShardResponse>> heldShard;
    public void testNegativeServiceTimeDoesNotFailIndexedItems() throws Exception {
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));
    }
        assertTrue(future.isDone());
        }), () -> {
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));
        } finally {
        IllegalArgumentException failure = new IllegalArgumentException("unexpected admission failure");
        assertEquals(1, permitCloses.get(attemptedShards.get(1)).get());
            items[i] = new BulkItemResponse(
            assertEquals(rejected, item.isFailed());
    private void assertBulkResult(BulkResponse response, int failures) {
            new IndexRequest(index).id("0").opType(DocWriteRequest.OpType.CREATE).source(Map.of("value", "first"))
        action = new TransportBulkAction(
        assertReleased();
            // Only the dispatch scope fails. The later response callback has its own, successful scope.
import org.opensearch.telemetry.tracing.SpanScope;
        BulkItemResponse[] items = new BulkItemResponse[request.items().length];
        assertTrue(dispatchedShards.isEmpty());
            )
import org.opensearch.action.DocWriteRequest;
        assertEquals(1, dispatchedShards.size());
                return failingScope;
            NoopTracer.INSTANCE
 * compatible open source license.
        super.setUp();
        holdFirstShard = true;
    }
        StringBuilder content = new StringBuilder();
    }
 */
 * this file be licensed under the Apache-2.0 license or a
        }
        assertEquals(6, response.getItems().length);
    private void assertHeldRequestPending(PlainActionFuture<BulkResponse> future, AtomicInteger releases) {
                assertEquals(RestStatus.TOO_MANY_REQUESTS, item.status());
            Map.of(),
                .numberOfShards(1)
            content.append("{\"")
        PlainActionFuture<BulkResponse> future = new PlainActionFuture<>();
    }
            transportService,
                        + "], service time EWMA ["
    }
        assertFalse(response.hasFailures());
import org.opensearch.test.MockLogAppender;
import java.util.List;
                .append(source(i))
                .numberOfReplicas(0)
import org.opensearch.index.remote.RemoteStorePressureService;
            appender.addExpectation(
        verify(pressureService).markCoordinatingOperationStarted(any(LongSupplier.class), eq(false));
import static org.mockito.Mockito.times;
        assertReleased();
                if (rejectedAdmissions.contains(attemptedShards.size())) {
import org.opensearch.test.transport.CapturingTransport;
                .append("\":{\"_index\":\"test-index-")
    public void testBulkTookIncludesTimeBeforeRejectedShardAdmission() throws Exception {
        assertReleased();
        verify(indicesService).addDocStatusStats(stats.capture());
        assertEquals(clientErrors, stats.getValue().getDocStatusCounter()[3].longValue());
            address -> node,
            }
import org.opensearch.action.support.ActionTestUtils;
        assertEquals(serverErrors, stats.getValue().getDocStatusCounter()[4].longValue());
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        when(clock.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(50));
import org.opensearch.Version;
        }
        threadPool = new TestThreadPool(getTestName());
        }
                }
import static org.opensearch.ingest.IngestServiceTests.createIngestServiceWithProcessors;
import static org.mockito.Mockito.verify;
                    .put(IndexMetadata.INDEX_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED.getKey(), true)
            assertEquals(source(item.id()), ((IndexRequest) item.request()).source().utf8ToString());
        assertReleased();
    public void testShardPressureRejectionWaitsForInFlightRequestBuffers() throws Exception {
    private BulkShardResponse successfulResponse(BulkShardRequest request) {
    private void assertReleased() {
import org.opensearch.cluster.node.DiscoveryNodeRole;
            routing.add(
            null,
        SpanScope failingScope = mock(SpanScope.class);
    public void testUnexpectedAdmissionFailureIsReturnedAsItemFailures() throws Exception {
            mock(MappingUpdatedAction.class),
            clusterService,
    private Exception executionFailure;
        assertEquals(attemptedShards.get(0), heldShard.v1().shardId());
                    .put(current.getSettings())
                new IndexResponse(request.shardId(), item.request().id(), 0, 1, 1, true)
        PlainActionFuture<BulkResponse> future = new PlainActionFuture<>();
    private final Set<Integer> rejectedAdmissions = new HashSet<>();
                assertSame(failure, item.getFailure().getCause());
import org.opensearch.action.update.UpdateHelper;
import org.opensearch.common.settings.Settings;
import org.opensearch.action.support.AutoCreateIndex;
    private final List<ShardId> attemptedShards = new ArrayList<>();
import static org.mockito.ArgumentMatchers.any;
        assertEquals(0, releases.get());
                permitCloses.put(shardId, closes);
            future.onResponse(response);
            IndexMetadata indexMetadata = IndexMetadata.builder(index)
    private TransportBulkAction action;
    private long serviceTimeNanos = BulkShardResponse.DEFAULT_SERVICE_TIME_IN_NANOS;
import org.opensearch.threadpool.TestThreadPool;
            assertEquals(Integer.toString(i), item.getId());
            completeHeldShard();
    public void tearDown() throws Exception {
        assertEquals(1, permitCloses.get(dispatchedShards.get(1).shardId()).get());
                item.request().opType(),
    private IndicesService indicesService;
        assertDocStatusStats(6 - failures, failures, 0);
            assertSame(failure, item.getFailure().getCause());
            Set.of(),
    private boolean holdFirstShard;
    public void testShardPressureRejectionDoesNotSkipLaterShards() throws Exception {
        ArgumentCaptor<DocStatusStats> stats = ArgumentCaptor.forClass(DocStatusStats.class);
            shardAction,
        BulkRequest request = new BulkRequest().add(new IndexRequest(".system-index").id("0").source(Map.of("value", "system")))
                    .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)
        assertTrue("invalid metrics must not leave the shard counter unfinished", future.isDone());
    }
        assertTrue(attemptedShards.isEmpty());
            @Override
import static org.mockito.ArgumentMatchers.eq;
            assertEquals(Integer.toString(i), item.getId());
    private static byte[] bulkContent() {
        ActionListener<BulkResponse> listener = ActionListener.runBefore(ActionListener.wrap(response -> {
        rejectedAdmissions.add(3);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        });
            Span span = mock(Span.class);
                    throw rejection;
        BulkShardResponse response = new BulkShardResponse(request.shardId(), items, serviceTimeNanos, nodeQueueSize);
import java.util.Map;
                if (holdFirstShard && dispatchedShards.size() == 1) {
        ActionTestUtils.execute(action, null, parseBulk(content), ActionListener.runBefore(future, () -> {
        assertTrue(dispatchedShards.isEmpty());
import java.util.Arrays;
            BulkItemResponse item = response.getItems()[i];
    private final Map<ShardId, AtomicInteger> permitCloses = new HashMap<>();
        assertHeldRequestPending(future, releases);
import org.opensearch.cluster.routing.IndexRoutingTable;
    public void testAllShardsRejectedByShardPressure() throws Exception {
        BulkRequest request = new BulkRequest().add(new IndexRequest(".system-index").id("0").source(Map.of("value", "system")));
        assertSame(rejection, failure);
        assertEquals(6, response.getItems().length);
        assertEquals(0, permitCloses.get(heldShard.v1().shardId()).get());
        );
                assertEquals(RestStatus.INTERNAL_SERVER_ERROR, item.status());
                assertFalse(item.isFailed());
                        + "]"
            failureCallbacks.incrementAndGet();
        AtomicInteger releases = new AtomicInteger();
    }
import org.opensearch.action.support.PlainActionFuture;
        assertEquals(2, failedItems);
        );
        };
        }
    public void testMixedBulkDoesNotForceShardAdmission() {
        };
            @Override
        holdFirstShard = true;
        verify(pressureService).markCoordinatingOperationStarted(any(ShardId.class), any(LongSupplier.class), eq(true));
                assertTrue(item.isFailed());
        assertEquals(3, dispatchedShards.size());
import java.util.concurrent.atomic.AtomicInteger;
        for (Span span : spans) {
import org.opensearch.action.index.IndexRequest;
            ShardId shardId = new ShardId(indexMetadata.getIndex(), 0);
    }
                attemptedShards.add(shardId);
    }
                ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
import org.apache.logging.log4j.Level;
            () -> ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()))
                    listener.onResponse(successfulResponse(request));
        when(tracer.withSpanInScope(any(Span.class))).thenAnswer(invocation -> {
            Settings.EMPTY,
        assertEquals(successes, stats.getValue().getDocStatusCounter()[1].longValue());
    public void testShardPressureRejectionCompletesLastShard() throws Exception {
        assertBulkResult(response, 2);
            indicesService,
import org.opensearch.core.rest.RestStatus;
            assertEquals(source(item.id()), ((IndexRequest) item.request()).source().utf8ToString());
        when(tracer.startSpan(any(SpanCreationContext.class))).thenAnswer(invocation -> {
                    "Ignoring invalid node statistics from * for *: queue size ["
import org.opensearch.cluster.service.ClusterService;
        assertEquals(1, releases.get());
        assertEquals(attemptedShards.get(2), dispatchedShards.get(1).shardId());
            }
            OpenSearchRejectedExecutionException.class,
                assertEquals(RestStatus.CREATED, item.status());
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        rejectedAdmissions.add(1);
import org.opensearch.telemetry.tracing.Span;
import org.opensearch.cluster.routing.ShardRoutingState;
import java.util.HashMap;
        completeHeldShard();
            DiscoveryNodeRole.BUILT_IN_ROLES,
            Settings.EMPTY,
import org.opensearch.cluster.action.index.MappingUpdatedAction;
            }
            invocation -> {
        assertBulkResult(response, 6);
                ShardId shardId = invocation.getArgument(0);
        assertBulkResult(response, 6);
        ActionFilters filters = new ActionFilters(Set.of());
        ActionTestUtils.execute(action, null, request, listener);
        assertEquals(1, releases.get());
        ClusterState state = clusterService.state();
        }
            // The warning proves the response reached the invalid statistics check.
            assertEquals("test-index-" + (i % 3), item.getIndex());
            if (rejected) {
                || rejectedAdmissions.stream().anyMatch(attempt -> attemptedShards.get(attempt - 1).getIndexName().equals(item.getIndex()));
    public void testSynchronousDispatchFailureWaitsForInFlightRequestBuffers() throws Exception {
        IndexNameExpressionResolver resolver = new IndexNameExpressionResolver(threadPool.getThreadContext());
            String operation = i < 3 ? "index" : "create";
            resolver,
    }
            mock(UpdateHelper.class),
                .system(index.startsWith("."))
            assertEquals(1, closes.get());
            threadPool,
        rejectedAdmissions.addAll(Set.of(1, 2, 3));
        verify(pressureService, times(3)).markCoordinatingOperationStarted(any(ShardId.class), any(LongSupplier.class), anyBoolean());
        completeHeldShard();
        AtomicInteger successCallbacks = new AtomicInteger();
        when(pressureService.markCoordinatingOperationStarted(any(ShardId.class), any(LongSupplier.class), anyBoolean())).thenAnswer(
            mock(RemoteStorePressureService.class),
        assertDocStatusStats(6, 0, 0);
            tracer
    private void assertDocStatusStats(int successes, int clientErrors, int serverErrors) {
                return false;
        executionFailure = rejection;
            verify(pressureService).markCoordinatingOperationStarted(eq(shardId), any(LongSupplier.class), eq(false));
            if (item.getIndex().equals(attemptedShards.get(1).getIndexName())) {
        assertEquals(0, requestPermitCloses.get());
        assertEquals(0, releases.get());
            assertEquals(i, item.getItemId());
        byte[] content = bulkContent();
        BulkRequest request = new BulkRequest().add(
        int failedItems = 0;
        transportService = new CapturingTransport().createTransportService(
        RoutingTable.Builder routing = RoutingTable.builder();
    }
            clusterService,
        completeHeldShard();
        int actualFailures = 0;
                item.id(),
        failAfterSecondResponse = true;
            protected boolean needToCheck() {
        assertNotNull(heldShard);
        when(tracer.withSpanInScope(any(Span.class))).thenReturn(SpanScope.NO_OP);
import org.opensearch.action.index.IndexResponse;
        useClockWithPreShardDelay();
        for (int i = 0; i < 6; i++) {
        }
import static org.opensearch.test.ClusterServiceUtils.setState;
                } else {
        assertReleased();
        assertFalse(response.hasFailures());
    public void testBulkTookIncludesTimeBeforeSuccessfulShardDispatch() throws Exception {
        setState(clusterService, ClusterState.builder(clusterService.state()).metadata(metadata).routingTable(routing.build()).build());
        assertReleased();
        for (BulkItemResponse item : response.getItems()) {
            transportService,
            return SpanScope.NO_OP;
        assertEquals(0, permitCloses.get(heldShard.v1().shardId()).get());
            Arrays.fill(content, (byte) '?');
                new MockLogAppender.SeenEventExpectation(
        this.nodeQueueSize = nodeQueueSize;
        }
            pressureService,
            // Fail only the second shard's dispatch entry; its failure callback must be able to enter its own scope.
            threadPool,
        assertTrue(response.hasFailures());
        PlainActionFuture<BulkResponse> future = new PlainActionFuture<>();
        );
        assertEquals(2, response.getItems().length);
        assertTrue(response.hasFailures());
}
        ) {
    }
        transportService.start();
                throw failure;
import org.opensearch.action.admin.indices.stats.DocStatusStats;
            NoopTracer.INSTANCE
        PlainActionFuture<BulkResponse> future = executeWithTrackedBuffer(bulkContent(), releases);
        for (BulkItemRequest item : heldShard.v1().items()) {
                        + nodeQueueSize
        PlainActionFuture<BulkResponse> future = executeWithTrackedBuffer(bulkContent(), releases);
        BulkResponse response = future.actionGet();
            pressureService,
        if (heldShard != null) {
        }
            indicesService,
        SystemIndices systemIndices = new SystemIndices(Map.of());
        AtomicInteger releases = new AtomicInteger();
import java.util.function.LongSupplier;
        assertEquals(50, response.getTook().getMillis());
    private IndexingPressureService pressureService;
    private final OpenSearchRejectedExecutionException rejection = new OpenSearchRejectedExecutionException("shard pressure rejected");
        BulkResponse response = future.actionGet();
    private ClusterService clusterService;
        indicesService = mock(IndicesService.class);
        }
        try {
    public void testFailureAfterSynchronousResponseDoesNotCompleteShardTwice() throws Exception {
        assertEquals(RestStatus.OK, response.status());
import org.opensearch.tasks.Task;
    private boolean failAfterSecondResponse;
                return (Releasable) closes::incrementAndGet;
        assertHeldRequestPending(future, releases);
                .append("\"}}\n")
        for (AtomicInteger closes : permitCloses.values()) {
            metadata.put(indexMetadata, false);
        assertEquals(RestStatus.OK, response.status());
                    "invalid node statistics",
import java.util.concurrent.TimeUnit;
        );
            () -> relativeTimeProvider.getAsLong(),
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));
                super.tearDown();
        assertTrue(permitCloses.isEmpty());
            }
        }
            try {
    public void testDispatchedShardFailureStillReleasesPressure() throws Exception {
        }
                } else if (executionFailure != null) {
        Metadata.Builder metadata = Metadata.builder();
        assertEquals(2, dispatchedShards.size());
        assertEquals(1, successCallbacks.get());
        return response;
    private static BulkRequest parseBulk(byte[] content) throws Exception {
        assertEquals(6, response.getItems().length);
        // Admission order is controlled by invocation count, not the iteration order of shard groups.
                assertSame(rejection, item.getFailure().getCause());
        return future;
        assertFalse("the bulk must wait for the accepted shard", future.isDone());
        assertInvalidMetricsDoNotFailIndexedItems(BulkShardResponse.DEFAULT_SERVICE_TIME_IN_NANOS, -1);
        assertEquals(1, releases.get());
            return span;
        this.serviceTimeNanos = serviceTimeNanos;
        assertEquals(failures, actualFailures);
    public void testScopeCloseFailureAfterDispatchWaitsForActualCallback() throws Exception {
        return "{\"value\":\"value-" + item + "\"}";
        assertFalse(future.actionGet().hasFailures());
            future.onFailure(failure);
    private LongSupplier relativeTimeProvider = System::nanoTime;
import static org.mockito.Mockito.never;
        assertEquals(3, dispatchedShards.size());
                failedItems++;
        }
        completeHeldShard();
        assertReleased();
                AtomicInteger closes = new AtomicInteger();
            "node",
import org.opensearch.cluster.routing.TestShardRouting;
        assertTrue(response.hasFailures());
    }
import org.opensearch.index.IndexingPressureService;
    }
        assertEquals(0, requestPermitCloses.get());
    private void completeHeldShard() {
        doThrow(new IllegalStateException("failed to close dispatch scope")).when(failingScope).close();
        verify(spans.get(1)).setError(failure);
    }
 * SPDX-License-Identifier: Apache-2.0
            boolean rejected = executionFailure != null
        assertEquals(50, response.getTook().getMillis());
    }
    private int nodeQueueSize = BulkShardResponse.DEFAULT_QUEUE_SIZE;
            } finally {
import org.opensearch.cluster.metadata.Metadata;
                actualFailures++;
        for (BulkItemResponse item : response.getItems()) {
    private void assertInvalidMetricsDoNotFailIndexedItems(long serviceTimeNanos, int nodeQueueSize) throws Exception {
        assertReleased();
import org.apache.logging.log4j.LogManager;
        Set<Span> failedScopes = new HashSet<>();
        LongSupplier clock = mock(LongSupplier.class);
            verify(span).endSpan();
import static org.mockito.Mockito.when;
    @Override
                Settings.builder()
            }
                }
    }
            filters,
                    TransportBulkAction.class.getCanonicalName(),
    private final AtomicInteger requestPermitCloses = new AtomicInteger();
        AtomicInteger releases = new AtomicInteger();
import org.opensearch.action.support.ActionFilters;
        BulkResponse response = future.actionGet();
        assertEquals(RestStatus.OK, response.status());
        when(pressureService.markCoordinatingOperationStarted(any(LongSupplier.class), anyBoolean())).thenReturn(
        assertEquals(0, requestPermitCloses.get());
            .add(new IndexRequest("test-index-0").id("1").source(Map.of("value", "ordinary")));
            assertEquals(RestStatus.CREATED, item.status());
        });
            );
        when(tracer.withSpanInScope(any(Span.class))).thenAnswer(invocation -> {
            new AutoCreateIndex(Settings.EMPTY, clusterService.getClusterSettings(), resolver, systemIndices),
    private TestThreadPool threadPool;
        AtomicInteger releases = new AtomicInteger();
        relativeTimeProvider = clock;
        verify(pressureService).markCoordinatingOperationStarted(any(LongSupplier.class), eq(true));
            BulkItemRequest item = request.items()[i];
        assertTrue(dispatchedShards.isEmpty());
            requestPermitCloses::incrementAndGet
        assertBulkResult(response, 6);
                    .addShard(TestShardRouting.newShardRouting(shardId, node.getId(), true, ShardRoutingState.STARTED))
import org.opensearch.common.lease.Releasable;
            .settings(
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.common.lease.Releasables;
        assertReleased();
    }
import static org.mockito.Mockito.doThrow;
import org.opensearch.action.support.replication.ReplicationResponse;
            return SpanScope.NO_OP;
        IllegalStateException failure = new IllegalStateException("failed to enter dispatch scope");
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(TransportBulkAction.class))) {
        String index = "test-index-0";
        for (BulkItemRequest item : heldShard.v1().items()) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        when(pressureService.markCoordinatingOperationStarted(any(LongSupplier.class), anyBoolean())).thenThrow(rejection);
            Version.CURRENT
import org.opensearch.core.action.ActionListener;
        assertEquals(3, attemptedShards.size());
            protected void doExecute(Task task, BulkShardRequest request, ActionListener<BulkShardResponse> listener) {
        assertDocStatusStats(6, 0, 0);
        assertBulkResult(response, 2);
        assertDocStatusStats(2, 0, 0);
                    }
        }
        AtomicInteger failureCallbacks = new AtomicInteger();
import org.opensearch.cluster.node.DiscoveryNode;
                    if (failAfterSecondResponse && dispatchedShards.size() == 2) {
import org.opensearch.common.collect.Tuple;
            systemIndices,
        assertReleased();
            } else {
        useClockWithPreShardDelay();
        }
            successCallbacks.incrementAndGet();
        );
    }
        TransportShardBulkAction shardAction = new TransportShardBulkAction(
import org.opensearch.indices.SystemIndices;
import org.opensearch.telemetry.tracing.Tracer;
        IndexMetadata current = state.metadata().index(index);
            Span span = invocation.getArgument(0);
        assertFalse("the bulk request must wait for the accepted shard before releasing its buffers", future.isDone());
        DiscoveryNode node = new DiscoveryNode(
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            filters,
            if (spans.indexOf(span) == 1 && failedScopes.add(span)) {
        return content.toString().getBytes(StandardCharsets.UTF_8);
        ).add(new IndexRequest(index).id("1").opType(DocWriteRequest.OpType.CREATE).source(Map.of("value", "second")));
            mock(ShardStateAction.class),
    private PlainActionFuture<BulkResponse> executeWithTrackedBuffer(byte[] content, AtomicInteger releases) throws Exception {
        assertTrue(future.isDone());
            Tuple<BulkShardRequest, ActionListener<BulkShardResponse>> held = heldShard;
    }
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));
package org.opensearch.action.bulk;
import org.opensearch.cluster.ClusterState;
        rejectedAdmissions.addAll(Set.of(1, 2, 3));
                        throw new IllegalStateException("failure after synchronous response");
        assertTrue(future.isDone());
            BulkItemResponse item = response.getItems()[i];
                assertEquals(RestStatus.CREATED, item.status());
        }
            buildNewFakeTransportAddress(),
        assertReleased();
import static org.mockito.Mockito.mock;
                .append("\",\"_id\":\"")
                        + serviceTimeNanos
                dispatchedShards.add(request);
    }
            null,
        assertEquals(1, requestPermitCloses.get());
        assertFalse(response.hasFailures());
    public void testSystemOnlyBulkPreservesForcedAdmission() {
        clusterService = createClusterService(threadPool, node);
        assertReleased();
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                .append(i % 3)
        assertReleased();
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));
import java.util.ArrayList;
        for (int i = 0; i < response.getItems().length; i++) {
        });
            createIngestServiceWithProcessors(Map.of()),
        // The first reading starts the bulk operation; subsequent readings include 50ms of bulk preparation.
            } else {
            assertEquals(i, item.getItemId());
import org.opensearch.index.SegmentReplicationPressureService;
        assertEquals('?', content[0]);
        holdFirstShard = true;
        assertEquals(6, response.getItems().length);
        setState(clusterService, ClusterState.builder(state).metadata(Metadata.builder(state.metadata()).put(appendOnly, false)).build());
    }
            assertEquals(index, item.getIndex());
        verify(spans.get(0), never()).endSpan();
        assertEquals(RestStatus.OK, response.status());
        assertEquals(1, releases.get());
            spans.add(span);
                .append(i)
import org.opensearch.transport.TransportService;
        }));
            );
        assertInvalidMetricsDoNotFailIndexedItems(-1, BulkShardResponse.DEFAULT_QUEUE_SIZE);
import java.nio.charset.StandardCharsets;
        });
                    heldShard = Tuple.tuple(request, listener);
            ActionTestUtils.execute(action, null, request, future);
    private final List<BulkShardRequest> dispatchedShards = new ArrayList<>();
            );
        holdFirstShard = true;
            assertEquals(RestStatus.BAD_REQUEST, item.status());
        for (int i = 0; i < response.getItems().length; i++) {
    }
            threadPool,
            releases.incrementAndGet();
        Exception failure = expectThrows(
        verify(spans.get(1), never()).setError(any(Exception.class));
            .build();
                )
            appender.assertAllExpectationsMatched();
                .append('\n');
        assertEquals(0, failureCallbacks.get());
            }
        for (ShardId shardId : attemptedShards) {
 * The OpenSearch Contributors require contributions made to
                Releasables.close(transportService, clusterService);
            releases.incrementAndGet();
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));
    }
            if (spans.indexOf(span) == 0 && enteredScopes.add(span)) {
        assertFalse(ActionTestUtils.executeBlocking(action, request).hasFailures());
        }, failure -> {
            assertTrue(item.isFailed());
public class TransportBulkActionShardIndexingPressureTests extends OpenSearchTestCase {
            Span span = invocation.getArgument(0);
        for (String index : List.of("test-index-0", "test-index-1", "test-index-2", ".system-index")) {
        BulkRequest request = parseBulk(content);
        assertBulkResult(future.actionGet(), 2);
import org.opensearch.threadpool.ThreadPool;
    private void useClockWithPreShardDelay() {
                IndexRoutingTable.builder(indexMetadata.getIndex())
    private TransportService transportService;
    private Tracer tracer;
        when(tracer.isRecording()).thenReturn(true);
    }
                    listener.onFailure(executionFailure);
import static org.mockito.ArgumentMatchers.anyBoolean;
import java.util.Set;
import org.opensearch.cluster.routing.RoutingTable;
        assertReleased();
        transportService.acceptIncomingRequests();
        response.setShardInfo(new ReplicationResponse.ShardInfo(1, 1));
                    Level.WARN,
        return new BulkRequest().add(new BytesArray(content), null, MediaTypeRegistry.JSON);
import org.opensearch.indices.IndicesService;
import java.util.HashSet;
            }
        pressureService = mock(IndexingPressureService.class);
        IndexMetadata appendOnly = IndexMetadata.builder(current)
        assertDocStatusStats(4, 0, 2);
            }
        ) {
    }
                .append(operation)
    }
        assertEquals(attemptedShards.get(2), dispatchedShards.get(1).shardId());
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));
            heldShard = null;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        for (int i = 0; i < items.length; i++) {
            Arrays.fill(content, (byte) '?');
    private final List<Span> spans = new ArrayList<>();
        assertEquals(2, dispatchedShards.size());
        doThrow(failure).when(pressureService).markCoordinatingOperationStarted(any(ShardId.class), any(LongSupplier.class), anyBoolean());
import org.opensearch.test.OpenSearchTestCase;
    @Override
        tracer = mock(Tracer.class);
            assertEquals(i < 3 ? DocWriteRequest.OpType.INDEX : DocWriteRequest.OpType.CREATE, item.getOpType());
    private static String source(int item) {
import org.opensearch.telemetry.tracing.SpanCreationContext;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        assertFalse(ActionTestUtils.executeBlocking(action, request).hasFailures());
    }
import org.opensearch.core.index.shard.ShardId;
        Set<Span> enteredScopes = new HashSet<>();
/*
            held.v2().onResponse(successfulResponse(held.v1()));
        assertEquals(3, dispatchedShards.size());
        assertEquals(2, dispatchedShards.size());
            systemIndices,
        PlainActionFuture<BulkResponse> future = executeWithTrackedBuffer(bulkContent(), releases);
 *
        assertEquals(2, dispatchedShards.size());
    public void testWholeRequestPressureRejectionRemainsRequestFailure() throws Exception {
import org.mockito.ArgumentCaptor;
    }
        rejectedAdmissions.add(2);
    public void setUp() throws Exception {
import org.opensearch.cluster.action.shard.ShardStateAction;
