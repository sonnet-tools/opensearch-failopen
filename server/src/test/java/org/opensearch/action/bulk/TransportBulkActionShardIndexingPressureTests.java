        PlainActionFuture<BulkResponse> future = new PlainActionFuture<>();
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        AtomicInteger releases = new AtomicInteger();  
import org.opensearch.common.lease.Releasable;
        // Admission order is controlled by invocation count, not the iteration order of shard groups.  
        assertInvalidMetricsDoNotFailIndexedItems(BulkShardResponse.DEFAULT_SERVICE_TIME_IN_NANOS, -1);  
                .system(index.startsWith("."))
    private IndicesService indicesService;
    private final Map<ShardId, AtomicInteger> permitCloses = new HashMap<>();  
    private ClusterService clusterService;
            Tuple<BulkShardRequest, ActionListener<BulkShardResponse>> held = heldShard;
import static org.mockito.Mockito.never;
                .numberOfReplicas(0)
                    .put(current.getSettings())
        for (int i = 0; i < 6; i++) {
        holdFirstShard = true;
            filters,
        assertTrue(dispatchedShards.isEmpty());
        assertEquals(6, response.getItems().length);  
        ClusterState state = clusterService.state();  
                ShardId shardId = invocation.getArgument(0);
        when(tracer.isRecording()).thenReturn(true);
        assertEquals(0, permitCloses.get(heldShard.v1().shardId()).get());
        assertFalse("the bulk must wait for the accepted shard", future.isDone());
    private static String source(int item) {
            assertEquals(Integer.toString(i), item.getId());  
        PlainActionFuture<BulkResponse> future = executeWithTrackedBuffer(bulkContent(), releases);  
        holdFirstShard = true;  
                return failingScope;  
        assertTrue(future.isDone());  
    public void testSynchronousDispatchFailureWaitsForInFlightRequestBuffers() throws Exception {  
                    "invalid node statistics",
        assertReleased();  
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));  
                    }
        Set<Span> failedScopes = new HashSet<>();  
        for (BulkItemResponse item : response.getItems()) {
import org.opensearch.action.support.ActionTestUtils;  
        useClockWithPreShardDelay();
        ) {
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                    .addShard(TestShardRouting.newShardRouting(shardId, node.getId(), true, ShardRoutingState.STARTED))
    @Override
    public void testAllShardsRejectedByShardPressure() throws Exception {
        assertInvalidMetricsDoNotFailIndexedItems(-1, BulkShardResponse.DEFAULT_QUEUE_SIZE);
        }));
 * compatible open source license.
    public void testSystemOnlyBulkPreservesForcedAdmission() {  
            // The warning proves the response reached the invalid statistics check.
        assertHeldRequestPending(future, releases);
        assertTrue(attemptedShards.isEmpty());
        assertEquals(1, successCallbacks.get());  
        );
        ).add(new IndexRequest(index).id("1").opType(DocWriteRequest.OpType.CREATE).source(Map.of("value", "second")));
                .build();  
        assertTrue(future.isDone());  
            }  
                        + serviceTimeNanos
        useClockWithPreShardDelay();
    public void testUnexpectedAdmissionFailureIsReturnedAsItemFailures() throws Exception {
                .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                new IndexResponse(request.shardId(), item.request().id(), 0, 1, 1, true)  
                item.id(),
        when(tracer.withSpanInScope(any(Span.class))).thenAnswer(invocation -> {
                || rejectedAdmissions.stream().anyMatch(attempt -> attemptedShards.get(attempt - 1).getIndexName().equals(item.getIndex()));
            assertEquals(RestStatus.CREATED, item.status());
        assertSame(rejection, failure);
    private void useClockWithPreShardDelay() {
        BulkRequest request = new BulkRequest().add(new IndexRequest(".system-index").id("0").source(Map.of("value", "system")))  
        assertFalse(ActionTestUtils.executeBlocking(action, request).hasFailures());
            routing.add(  
    }
        for (String index : List.of("test-index-0", "test-index-1", "test-index-2", ".system-index")) {  
            () -> relativeTimeProvider.getAsLong(),
        assertReleased();
        }, failure -> {
                } else if (executionFailure != null) {
            }
    }
        IndexMetadata current = state.metadata().index(index);
        }
import org.opensearch.test.transport.CapturingTransport;
        verify(pressureService).markCoordinatingOperationStarted(any(LongSupplier.class), eq(false));  
        when(tracer.withSpanInScope(any(Span.class))).thenReturn(SpanScope.NO_OP);
            // Fail only the second shard's dispatch entry; its failure callback must be able to enter its own scope.  
                .append(i)  
                if (rejectedAdmissions.contains(attemptedShards.size())) {  
        );  
            assertSame(failure, item.getFailure().getCause());
                ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            } else {
            spans.add(span);
        assertFalse(ActionTestUtils.executeBlocking(action, request).hasFailures());
        assertEquals(0, releases.get());
        super.setUp();  
        assertEquals(3, attemptedShards.size());
            }  
        };
        PlainActionFuture<BulkResponse> future = executeWithTrackedBuffer(bulkContent(), releases);
            null,  
            assertEquals(Integer.toString(i), item.getId());
        assertEquals(successes, stats.getValue().getDocStatusCounter()[1].longValue());  
        }
    public void testBulkTookIncludesTimeBeforeSuccessfulShardDispatch() throws Exception {
        assertEquals('?', content[0]);  
                new MockLogAppender.SeenEventExpectation(  
        for (int i = 0; i < response.getItems().length; i++) {  
    @Override
    }  
            assertEquals(source(item.id()), ((IndexRequest) item.request()).source().utf8ToString());  
    }
        }), () -> {
            NoopTracer.INSTANCE  
                .append(operation)
    }
import org.opensearch.test.MockLogAppender;  
    private TestThreadPool threadPool;
import java.util.Set;
        assertTrue(dispatchedShards.isEmpty());
        assertReleased();
        assertFalse(future.actionGet().hasFailures());
            return SpanScope.NO_OP;
                return (Releasable) closes::incrementAndGet;
            @Override
            ActionTestUtils.execute(action, null, request, future);
        });  
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));  
        assertEquals(6, response.getItems().length);
            releases.incrementAndGet();  
            } else {  
            filters,
    private void assertInvalidMetricsDoNotFailIndexedItems(long serviceTimeNanos, int nodeQueueSize) throws Exception {
    }  
                .append(i % 3)
        assertEquals(clientErrors, stats.getValue().getDocStatusCounter()[3].longValue());
        IllegalArgumentException failure = new IllegalArgumentException("unexpected admission failure");
                        + nodeQueueSize
import org.opensearch.common.lease.Releasables;
        } finally {  
import org.opensearch.index.remote.RemoteStorePressureService;  
            }
            assertEquals(i, item.getItemId());
        failAfterSecondResponse = true;
            content.append("{\"")
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(TransportBulkAction.class))) {  
            () -> ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()))
                .append("\":{\"_index\":\"test-index-")  
        }  
        assertReleased();
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
        assertEquals(2, dispatchedShards.size());
            );
            held.v2().onResponse(successfulResponse(held.v1()));
                }
                permitCloses.put(shardId, closes);
            "node",  
    }
        try {
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));  
        SpanScope failingScope = mock(SpanScope.class);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        PlainActionFuture<BulkResponse> future = new PlainActionFuture<>();  
        TransportShardBulkAction shardAction = new TransportShardBulkAction(
            new IndexRequest(index).id("0").opType(DocWriteRequest.OpType.CREATE).source(Map.of("value", "first"))  
        );
            BulkItemResponse item = response.getItems()[i];
        IndexMetadata appendOnly = IndexMetadata.builder(current)
    public void testWholeRequestPressureRejectionRemainsRequestFailure() throws Exception {
            invocation -> {  
            assertEquals(i, item.getItemId());
        assertDocStatusStats(6 - failures, failures, 0);  
    public void testShardPressureRejectionWaitsForInFlightRequestBuffers() throws Exception {
        doThrow(failure).when(pressureService).markCoordinatingOperationStarted(any(ShardId.class), any(LongSupplier.class), anyBoolean());  
    private BulkShardResponse successfulResponse(BulkShardRequest request) {
        AtomicInteger failureCallbacks = new AtomicInteger();
import org.opensearch.threadpool.ThreadPool;
            // Only the dispatch scope fails. The later response callback has its own, successful scope.
                    TransportBulkAction.class.getCanonicalName(),
        for (BulkItemRequest item : heldShard.v1().items()) {
        int failedItems = 0;
import static org.opensearch.test.ClusterServiceUtils.setState;
    }
import org.apache.logging.log4j.LogManager;
    private Exception executionFailure;
    }  
    }
        return new BulkRequest().add(new BytesArray(content), null, MediaTypeRegistry.JSON);  
import org.opensearch.cluster.routing.RoutingTable;
            boolean rejected = executionFailure != null  
                super.tearDown();
    private final AtomicInteger requestPermitCloses = new AtomicInteger();
    }
        assertEquals(0, requestPermitCloses.get());  
        assertEquals(0, failureCallbacks.get());
        indicesService = mock(IndicesService.class);
                failedItems++;
        AtomicInteger releases = new AtomicInteger();
            .build();  
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));
    private LongSupplier relativeTimeProvider = System::nanoTime;
        assertEquals(50, response.getTook().getMillis());
    public void tearDown() throws Exception {  
        return content.toString().getBytes(StandardCharsets.UTF_8);
        assertEquals(2, failedItems);
            }  
                assertSame(rejection, item.getFailure().getCause());  
import org.opensearch.action.index.IndexRequest;  
        assertEquals(0, releases.get());
import static org.mockito.ArgumentMatchers.any;  
        assertEquals(1, permitCloses.get(attemptedShards.get(1)).get());
import org.opensearch.action.DocWriteRequest;
        assertDocStatusStats(6, 0, 0);
            .add(new IndexRequest("test-index-0").id("1").source(Map.of("value", "ordinary")));
                    listener.onResponse(successfulResponse(request));
import org.opensearch.common.collect.Tuple;  
                assertEquals(RestStatus.TOO_MANY_REQUESTS, item.status());
        BulkResponse response = future.actionGet();
                .append("\",\"_id\":\"")
            clusterService,
import static org.mockito.ArgumentMatchers.anyBoolean;
        assertBulkResult(response, 2);
import org.opensearch.Version;  
        if (heldShard != null) {
        // The first reading starts the bulk operation; subsequent readings include 50ms of bulk preparation.
        };
    private final List<Span> spans = new ArrayList<>();
            Arrays.fill(content, (byte) '?');
            requestPermitCloses::incrementAndGet  
                    .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), true)  
        assertFalse(response.hasFailures());
package org.opensearch.action.bulk;
            createIngestServiceWithProcessors(Map.of()),
        BulkRequest request = new BulkRequest().add(
                }
        verify(spans.get(1)).setError(failure);
        assertEquals(serverErrors, stats.getValue().getDocStatusCounter()[4].longValue());
        assertEquals(1, requestPermitCloses.get());  
import java.util.HashSet;
            mock(MappingUpdatedAction.class),
            assertEquals(source(item.id()), ((IndexRequest) item.request()).source().utf8ToString());
            appender.addExpectation(
        this.serviceTimeNanos = serviceTimeNanos;  
        });  
            transportService,
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        assertBulkResult(response, 6);
    public void testNegativeQueueSizeDoesNotFailIndexedItems() throws Exception {
        when(pressureService.markCoordinatingOperationStarted(any(ShardId.class), any(LongSupplier.class), anyBoolean())).thenAnswer(
    public void setUp() throws Exception {
        action = new TransportBulkAction(  
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));  
            assertEquals(RestStatus.BAD_REQUEST, item.status());
            );
            future.onFailure(failure);  
        assertEquals(1, permitCloses.get(dispatchedShards.get(1).shardId()).get());
        transportService = new CapturingTransport().createTransportService(
        ActionListener<BulkResponse> listener = ActionListener.runBefore(ActionListener.wrap(response -> {
        assertEquals(1, releases.get());  
                        + "]"
        assertBulkResult(response, 6);
        assertBulkResult(future.actionGet(), 2);
    }
    private void assertDocStatusStats(int successes, int clientErrors, int serverErrors) {  
                        throw new IllegalStateException("failure after synchronous response");  
        assertDocStatusStats(4, 0, 2);
import java.nio.charset.StandardCharsets;
        assertDocStatusStats(6, 0, 0);
    public void testShardPressureRejectionDoesNotSkipLaterShards() throws Exception {
    private void completeHeldShard() {  
import org.opensearch.tasks.Task;  
            Map.of(),
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));
            address -> node,
        assertReleased();
        return "{\"value\":\"value-" + item + "\"}";  
        String index = "test-index-0";
        assertTrue(response.hasFailures());  
    private Tuple<BulkShardRequest, ActionListener<BulkShardResponse>> heldShard;
            pressureService,
                if (holdFirstShard && dispatchedShards.size() == 1) {
import org.opensearch.action.admin.indices.stats.DocStatusStats;
        rejectedAdmissions.add(3);
import org.opensearch.index.SegmentReplicationPressureService;
import java.util.ArrayList;
        assertHeldRequestPending(future, releases);
    public void testFailureAfterSynchronousResponseDoesNotCompleteShardTwice() throws Exception {
        });
                AtomicInteger closes = new AtomicInteger();  
        clusterService = createClusterService(threadPool, node);  
            return SpanScope.NO_OP;
        }
        BulkResponse response = future.actionGet();
        assertEquals(1, releases.get());
import java.util.List;  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            protected boolean needToCheck() {
        when(pressureService.markCoordinatingOperationStarted(any(LongSupplier.class), anyBoolean())).thenReturn(
    public void testDispatchedShardFailureStillReleasesPressure() throws Exception {
        });
        }
    }  
        assertReleased();  
import static org.mockito.Mockito.when;
        assertEquals(2, response.getItems().length);
            indicesService,
                )  
import org.opensearch.action.support.AutoCreateIndex;
import org.opensearch.index.IndexingPressureService;
            Set.of(),
import static org.mockito.Mockito.verify;
            if (item.getIndex().equals(attemptedShards.get(1).getIndexName())) {
    }  
        ) {  
            }  
import org.opensearch.cluster.action.shard.ShardStateAction;
        assertEquals(50, response.getTook().getMillis());
        verify(indicesService).addDocStatusStats(stats.capture());
        return future;  
        for (Span span : spans) {
            NoopTracer.INSTANCE
import org.opensearch.cluster.action.index.MappingUpdatedAction;  
import static org.opensearch.ingest.IngestServiceTests.createIngestServiceWithProcessors;  
        assertReleased();
    private static BulkRequest parseBulk(byte[] content) throws Exception {
            new AutoCreateIndex(Settings.EMPTY, clusterService.getClusterSettings(), resolver, systemIndices),  
    }
        completeHeldShard();
                return false;  
                .append('\n');  
            assertEquals("test-index-" + (i % 3), item.getIndex());
    }
    private final List<ShardId> attemptedShards = new ArrayList<>();
            systemIndices,
        rejectedAdmissions.add(1);  
            )
            completeHeldShard();
        BulkResponse response = ActionTestUtils.executeBlocking(action, parseBulk(bulkContent()));
                assertSame(failure, item.getFailure().getCause());
        for (ShardId shardId : attemptedShards) {
            }  
            } finally {  
            );  
        assertEquals(attemptedShards.get(0), heldShard.v1().shardId());  
        assertEquals(6, response.getItems().length);
                .numberOfShards(1)  
import org.opensearch.action.index.IndexResponse;
            heldShard = null;  
        completeHeldShard();  
    }  
                    throw rejection;
            Span span = mock(Span.class);  
            resolver,
            Settings.EMPTY,
        assertEquals(0, requestPermitCloses.get());  
            releases.incrementAndGet();
        assertEquals(RestStatus.OK, response.status());
import org.opensearch.core.common.bytes.BytesArray;
                item.request().opType(),
        return response;
        }
    private IndexingPressureService pressureService;
import org.opensearch.telemetry.tracing.SpanScope;  
        assertBulkResult(response, 6);
    }
        when(tracer.withSpanInScope(any(Span.class))).thenAnswer(invocation -> {
        BulkRequest request = new BulkRequest().add(new IndexRequest(".system-index").id("0").source(Map.of("value", "system")));
    }  
        for (int i = 0; i < items.length; i++) {
        AtomicInteger successCallbacks = new AtomicInteger();
            if (spans.indexOf(span) == 0 && enteredScopes.add(span)) {
        completeHeldShard();
        verify(spans.get(0), never()).endSpan();  
                    "Ignoring invalid node statistics from * for *: queue size ["
    }  
        IllegalStateException failure = new IllegalStateException("failed to enter dispatch scope");
import static org.mockito.Mockito.times;  
        assertReleased();
    private TransportBulkAction action;  
            threadPool,  
public class TransportBulkActionShardIndexingPressureTests extends OpenSearchTestCase {
                    .put(IndexMetadata.INDEX_BULK_ADAPTIVE_SHARD_SELECTION_ENABLED.getKey(), true)
        int actualFailures = 0;
        assertFalse("the bulk request must wait for the accepted shard before releasing its buffers", future.isDone());
import org.mockito.ArgumentCaptor;
        assertEquals(6, response.getItems().length);
import org.opensearch.cluster.node.DiscoveryNode;
        StringBuilder content = new StringBuilder();
import java.util.HashMap;
        assertTrue(response.hasFailures());  
        verify(pressureService).markCoordinatingOperationStarted(any(ShardId.class), any(LongSupplier.class), eq(true));
        when(tracer.startSpan(any(SpanCreationContext.class))).thenAnswer(invocation -> {
        for (BulkItemRequest item : heldShard.v1().items()) {  
            ShardId shardId = new ShardId(indexMetadata.getIndex(), 0);
        assertEquals(2, dispatchedShards.size());
import org.opensearch.cluster.routing.TestShardRouting;
import org.opensearch.indices.SystemIndices;
        assertReleased();  
    }
        pressureService = mock(IndexingPressureService.class);
    private boolean holdFirstShard;  
        }
        DiscoveryNode node = new DiscoveryNode(
        AtomicInteger releases = new AtomicInteger();  
        assertEquals(3, attemptedShards.size());
                } else {  
        assertEquals(3, dispatchedShards.size());  
        assertEquals(1, releases.get());  
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.support.PlainActionFuture;
                    heldShard = Tuple.tuple(request, listener);  
            threadPool,
        assertDocStatusStats(2, 0, 0);
}
            BulkItemResponse item = response.getItems()[i];  
        transportService.acceptIncomingRequests();
            assertTrue(item.isFailed());  
        assertBulkResult(response, 2);  
import org.opensearch.core.rest.RestStatus;
import java.util.Map;
        SystemIndices systemIndices = new SystemIndices(Map.of());  
import org.opensearch.action.support.replication.ReplicationResponse;  
import org.opensearch.cluster.service.ClusterService;
                IndexRoutingTable.builder(indexMetadata.getIndex())
import org.opensearch.common.settings.Settings;  
            mock(UpdateHelper.class),  
import org.opensearch.action.support.ActionFilters;
        BulkResponse response = future.actionGet();
        assertFalse(response.hasFailures());
        Set<Span> enteredScopes = new HashSet<>();
            .settings(  
        }
        tracer = mock(Tracer.class);  
                actualFailures++;
            protected void doExecute(Task task, BulkShardRequest request, ActionListener<BulkShardResponse> listener) {  
            Version.CURRENT
            tracer
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(RestStatus.OK, response.status());
import org.opensearch.transport.TransportService;
        RoutingTable.Builder routing = RoutingTable.builder();
        relativeTimeProvider = clock;  
            verify(span).endSpan();
                Settings.builder()
            assertEquals(rejected, item.isFailed());
                throw failure;
                dispatchedShards.add(request);
            mock(SegmentReplicationPressureService.class),  
    public void testShardPressureRejectionCompletesLastShard() throws Exception {  
        assertNotNull(heldShard);
            assertEquals(i < 3 ? DocWriteRequest.OpType.INDEX : DocWriteRequest.OpType.CREATE, item.getOpType());
        assertEquals(attemptedShards.get(2), dispatchedShards.get(1).shardId());  
            IndexMetadata indexMetadata = IndexMetadata.builder(index)
        when(clock.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(50));
        assertTrue(future.isDone());
        ActionFilters filters = new ActionFilters(Set.of());
        assertEquals(1, releases.get());
        BulkRequest request = parseBulk(content);
            String operation = i < 3 ? "index" : "create";  
import static org.mockito.ArgumentMatchers.eq;
        for (AtomicInteger closes : permitCloses.values()) {
import static org.mockito.Mockito.doThrow;  
        assertTrue(permitCloses.isEmpty());  
        AtomicInteger releases = new AtomicInteger();
            threadPool,  
        assertTrue(dispatchedShards.isEmpty());  
    private void assertBulkResult(BulkResponse response, int failures) {
        );  
 *
        assertEquals(0, permitCloses.get(heldShard.v1().shardId()).get());
            @Override
        IndexNameExpressionResolver resolver = new IndexNameExpressionResolver(threadPool.getThreadContext());
            transportService,  
import java.util.Arrays;  
        assertEquals(2, dispatchedShards.size());  
        verify(pressureService).markCoordinatingOperationStarted(any(LongSupplier.class), eq(true));  
        rejectedAdmissions.addAll(Set.of(1, 2, 3));
import org.opensearch.threadpool.TestThreadPool;  
        assertEquals(failures, actualFailures);
 */  
    }
            assertEquals(index, item.getIndex());  
            if (rejected) {  
        }  
        rejectedAdmissions.add(2);
        doThrow(new IllegalStateException("failed to close dispatch scope")).when(failingScope).close();  
                assertEquals(RestStatus.CREATED, item.status());
        );
import java.util.function.LongSupplier;
        assertReleased();
/*  
import org.opensearch.telemetry.tracing.SpanCreationContext;
    }
        assertReleased();
    private void assertHeldRequestPending(PlainActionFuture<BulkResponse> future, AtomicInteger releases) {  
            pressureService,
        threadPool = new TestThreadPool(getTestName());
                    if (failAfterSecondResponse && dispatchedShards.size() == 2) {
        this.nodeQueueSize = nodeQueueSize;
        assertEquals(RestStatus.OK, response.status());
        verify(pressureService, times(3)).markCoordinatingOperationStarted(any(ShardId.class), any(LongSupplier.class), anyBoolean());
import org.apache.logging.log4j.Level;
                assertEquals(RestStatus.INTERNAL_SERVER_ERROR, item.status());  
 * this file be licensed under the Apache-2.0 license or a
    }
                .append("\"}}\n")
        verify(spans.get(1), never()).setError(any(Exception.class));
            null,  
        assertEquals(attemptedShards.get(2), dispatchedShards.get(1).shardId());
        }  
    private long serviceTimeNanos = BulkShardResponse.DEFAULT_SERVICE_TIME_IN_NANOS;
        Exception failure = expectThrows(  
            return span;
    private Tracer tracer;
    }
        assertEquals(3, dispatchedShards.size());
import org.opensearch.indices.IndicesService;
            Arrays.fill(content, (byte) '?');  
        BulkShardResponse response = new BulkShardResponse(request.shardId(), items, serviceTimeNanos, nodeQueueSize);  
            if (spans.indexOf(span) == 1 && failedScopes.add(span)) {
            successCallbacks.incrementAndGet();
                    Level.WARN,  
    public void testNegativeServiceTimeDoesNotFailIndexedItems() throws Exception {  
        for (BulkItemResponse item : response.getItems()) {  
import org.opensearch.cluster.ClusterState;
    public void testBulkTookIncludesTimeBeforeRejectedShardAdmission() throws Exception {  
        ActionTestUtils.execute(action, null, parseBulk(content), ActionListener.runBefore(future, () -> {
    private static byte[] bulkContent() {  
        Metadata.Builder metadata = Metadata.builder();
            metadata.put(indexMetadata, false);
        assertEquals(1, dispatchedShards.size());  
        byte[] content = bulkContent();
        rejectedAdmissions.addAll(Set.of(1, 2, 3));
            shardAction,
    }
        assertFalse(response.hasFailures());  
    }
    private final List<BulkShardRequest> dispatchedShards = new ArrayList<>();
        assertEquals(0, requestPermitCloses.get());
        BulkItemResponse[] items = new BulkItemResponse[request.items().length];  
        }
        assertEquals(2, dispatchedShards.size());
                attemptedShards.add(shardId);
    private PlainActionFuture<BulkResponse> executeWithTrackedBuffer(byte[] content, AtomicInteger releases) throws Exception {  
            Settings.EMPTY,
            Span span = invocation.getArgument(0);  
        executionFailure = rejection;
        ActionTestUtils.execute(action, null, request, listener);  
        holdFirstShard = true;
    }  
                        + "], service time EWMA ["  
import org.opensearch.action.update.UpdateHelper;
        }
    private final OpenSearchRejectedExecutionException rejection = new OpenSearchRejectedExecutionException("shard pressure rejected");
        assertTrue("invalid metrics must not leave the shard counter unfinished", future.isDone());  
        }
        transportService.start();
        assertReleased();  
    private TransportService transportService;  
import org.opensearch.cluster.metadata.Metadata;
                .append(source(i))
            indicesService,
            verify(pressureService).markCoordinatingOperationStarted(eq(shardId), any(LongSupplier.class), eq(false));
        PlainActionFuture<BulkResponse> future = executeWithTrackedBuffer(bulkContent(), releases);
    }  
            OpenSearchRejectedExecutionException.class,
import org.opensearch.cluster.routing.IndexRoutingTable;
            items[i] = new BulkItemResponse(  
        assertEquals(3, dispatchedShards.size());
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(RestStatus.CREATED, item.status());
            mock(ShardStateAction.class),
import java.util.concurrent.atomic.AtomicInteger;
        assertReleased();  
            try {
                Releasables.close(transportService, clusterService);
import org.opensearch.cluster.metadata.IndexMetadata;
            Span span = invocation.getArgument(0);
import java.util.concurrent.TimeUnit;  
        assertEquals(RestStatus.OK, response.status());
    }  
            systemIndices,  
        assertTrue(response.hasFailures());  
        ArgumentCaptor<DocStatusStats> stats = ArgumentCaptor.forClass(DocStatusStats.class);
        completeHeldShard();
            clusterService,  
    public void testMixedBulkDoesNotForceShardAdmission() {
    private int nodeQueueSize = BulkShardResponse.DEFAULT_QUEUE_SIZE;  
        }  
        LongSupplier clock = mock(LongSupplier.class);  
                    listener.onFailure(executionFailure);
            appender.assertAllExpectationsMatched();  
import static org.mockito.Mockito.mock;
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        response.setShardInfo(new ReplicationResponse.ShardInfo(1, 1));
    private void assertReleased() {
            failureCallbacks.incrementAndGet();
        assertReleased();
        when(pressureService.markCoordinatingOperationStarted(any(LongSupplier.class), anyBoolean())).thenThrow(rejection);
            assertEquals(1, closes.get());
        setState(clusterService, ClusterState.builder(clusterService.state()).metadata(metadata).routingTable(routing.build()).build());
import org.opensearch.core.index.shard.ShardId;
            future.onResponse(response);  
            }  
import org.opensearch.cluster.routing.ShardRoutingState;  
        for (int i = 0; i < response.getItems().length; i++) {
        }
    public void testScopeCloseFailureAfterDispatchWaitsForActualCallback() throws Exception {  
        setState(clusterService, ClusterState.builder(state).metadata(Metadata.builder(state.metadata()).put(appendOnly, false)).build());
        holdFirstShard = true;  
import org.opensearch.telemetry.tracing.Tracer;
    private boolean failAfterSecondResponse;
        assertHeldRequestPending(future, releases);  
            buildNewFakeTransportAddress(),
import org.opensearch.telemetry.tracing.Span;
                assertFalse(item.isFailed());
    private final Set<Integer> rejectedAdmissions = new HashSet<>();  
            mock(RemoteStorePressureService.class),
                assertTrue(item.isFailed());
        PlainActionFuture<BulkResponse> future = new PlainActionFuture<>();
            BulkItemRequest item = request.items()[i];
