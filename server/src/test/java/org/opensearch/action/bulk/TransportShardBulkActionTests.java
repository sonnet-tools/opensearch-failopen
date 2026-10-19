        final CountDownLatch latch = new CountDownLatch(1);
     */
        assertFalse(context.hasMoreOperationsToExecute());
                    BulkShardRequest,  
            DocWriteRequest<IndexRequest> writeRequest1 = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", 1);  
        writeRequest.retryOnConflict(Integer.MAX_VALUE);  
            );  
            new TransportShardBulkAction.PrimaryTermValidationRequest(aId, 1, shardId),
        CountDownLatch latch = new CountDownLatch(1);
            threadPool::absoluteTimeInMillis,
            new UpdateHelper.Result(  
                    BulkShardResponse>) result;
    }  
            threadPool::absoluteTimeInMillis,
        items[1] = new BulkItemRequest(1, new UpdateRequest("index", "fail1").doc(Requests.INDEX_CONTENT_TYPE, "field", "value"));
        );  
        assertThat(primaryResponse.getId(), equalTo("id"));  
        );
        // begin -> apply index -> flush (before update) -> apply update -> flush (before delete) -> apply delete -> finish  
    public void testExecuteBulkIndexRequestWithErrorWhileUpdatingMapping() throws Exception {
        assertThat(primaryResponse.getItemId(), equalTo(0));
        );
    }  
            threadPool,  
        CountDownLatch latch = new CountDownLatch(1);
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
        when(indexService.getShard(anyInt())).thenReturn(indexShard);
        writeRequest = new DeleteRequest("index", "id");
 *
            threadPool::absoluteTimeInMillis,
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        public Translog.Location getTranslogLocation() {  
        action.handlePrimaryTermValidationRequest(
                assertTrue(refreshCalled.get());  
        @Override
import org.opensearch.threadpool.ThreadPool.Names;  
                true,
        when(shard.shardId()).thenReturn(shardId);
                Requests.INDEX_CONTENT_TYPE
import org.opensearch.indices.IndicesService;
        AtomicBoolean refreshCalled = new AtomicBoolean(false);
    private BulkItemRequest randomlySetIgnoredPrimaryResponse(BulkItemRequest primaryRequest) {
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);  
     * finally-block finish must not replace it.  
    public void testGetReplicationModeWithRemoteTranslog() {
                success2
            secondContext,
                    DocWriteRequest.OpType.INDEX,  
        );
            assertNull(primaryResponse2.getResponse());
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(  
        // the first scope was finished (and failed) at the yield; the re-execution surfaced the failure before opening another  
        TransportShardBulkAction action = createAction();
        assertThat(primaryResponse.getResponse(), equalTo(noopUpdateResponse));  
        when(indexShard.routingEntry()).thenReturn(shardRouting);
import static org.hamcrest.CoreMatchers.not;
            mock(SystemIndices.class),
            }), latch),
        .put("index.version.created", Version.CURRENT.id)
            null,  
        });
        UpdateHelper updateHelper = mock(UpdateHelper.class);
            new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value")
            indexResult  
        Translog.Location location = new Translog.Location(0, 0, 0);  
        assertThat(closed.getSuppressed(), emptyArray());
        CountDownLatch latch = new CountDownLatch(1);  
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        DocWriteRequest<?> replicaDeleteRequest = replicaRequest.request();
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);  
    }
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));  
                assertNull(primaryResult.location);
            createTransportChannel(listener),  
            shard,
        when(updateHelper.prepare(any(), eq(shard), any())).thenThrow(  
            new BulkItemRequest(1, new IndexRequest("index").id("b").source(Requests.INDEX_CONTENT_TYPE, "newfield", "baz")) };  
        when(shard.mapperService()).thenReturn(mock(MapperService.class));
        assertThat(failure.getStatus(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));  
            null,  
            new FakeIndexResult(1, 1, 10, true, null)  
        Engine.IndexResult deferredA = new FakeIndexResult(1, 1, 0, true, null);
            assertTrue(primaryResponse2.isFailed());
        AtomicReference<Translog.Location> synced = new AtomicReference<>();
        );
        items[0] = new BulkItemRequest(0, writeRequest);  
    }
import java.util.concurrent.CountDownLatch;
                threadPool::absoluteTimeInMillis,
        BulkItemRequest[] itemRequests = new BulkItemRequest[1];  
     * {@link IndexShard#beginTranslogBatch()}. This verifies two distinct begin calls on two distinct threads and a
import org.opensearch.action.index.IndexRequest;  
            new ThrowingMappingUpdatePerformer(new RuntimeException("fail")),
    public void testExecuteBulkIndexRequestWithMappingUpdates() throws Exception {  
        when(shard.beginTranslogBatch()).thenAnswer(invocation -> {
            return new BulkItemRequest(
import java.util.Collections;  
            new NoopMappingUpdatePerformer(),
        // Track refresh calls
import static org.hamcrest.CoreMatchers.instanceOf;
                listener -> listener.onResponse(null),
                }
            }), latch),
        CountDownLatch latch = new CountDownLatch(1);  
            // this assertion is based on the assumption that all bulk item requests are updates and are hence calling  
            return null;
                    fail("request must not be acknowledged");
        );
        );
    public void testExecuteBulkIndexRequest() throws Exception {  
import org.opensearch.index.shard.IndexShard;
        assertTrue(shard.isSyncNeeded());  
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
            threadPool::absoluteTimeInMillis,
        final IndexShard indexShard = mock(IndexShard.class);
        IndexShard shard = mock(IndexShard.class);
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);  
            mock(TransportService.class),
        InOrder inOrder = inOrder(shard, batch);
        when(indexShard.indexSettings()).thenReturn(  
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        assertNotNull(task.getPhase());
        TransportShardBulkAction.executeBulkItemRequest(
        } finally {
            request,
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        Translog.Location resultLocation = new Translog.Location(42, 42, 42);  
        Exception err = new OpenSearchException("I'm dead <(x.x)>");
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
        IndexShard shard = mock(IndexShard.class);
                assertThat(response.status(), equalTo(RestStatus.CREATED));
        assertThat(failure.getIndex(), equalTo("index"));  
        );  
        assertTrue(TransportActions.isShardNotAvailableException(observedFailure.get()));  
        );
            threadPool::absoluteTimeInMillis,
        );  
import org.opensearch.index.SegmentReplicationPressureService;  
import org.opensearch.Version;  
        CountDownLatch latch = new CountDownLatch(1);  
        // Mixed request: an index that fills the batch, then an update, then a delete. Each of the update and delete
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
            listener -> listener.onResponse(null),
            new UpdateHelper.Result(
                public void onResponse(PrimaryResult<BulkShardRequest, BulkShardResponse> response) {
            null,  
            new NoopMappingUpdatePerformer(),
                }  
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);  
        items[0] = randomlySetIgnoredPrimaryResponse(items[0]);
        AllocationId allocationId = mock(AllocationId.class);  
                assertEquals(nItems, result.replicaRequest().items().length);
    }
            indexResult  
        IndexShard shard = mock(IndexShard.class);
        assertThrows(ShardNotFoundException.class, listener::actionGet);  
                @Override  
        // Track refresh calls
                // Should have location from successful operations  
        when(shard.indexSettings()).thenReturn(indexSettings);  
        BulkShardRequest completedRequest = context.getBulkShardRequest();
    public void testRetries() throws Exception {
        );
        final OpenSearchException err = new OpenSearchException("oops");  
        when(shard.applyDeleteOperationOnPrimary(anyLong(), any(), any(), any(), anyLong(), anyLong())).thenReturn(deleteResult);
            threadPool,  
        // Create bulk request with IMMEDIATE refresh policy
            new UpdateHelper.Result(
        when(shard.beginTranslogBatch()).thenReturn(batch);
public class TransportShardBulkActionTests extends IndexShardTestCase {  
                public void onResponse(PrimaryResult<BulkShardRequest, BulkShardResponse> response) {  
        verify(batch, times(1)).finish();
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);  
        when(indicesService.indexServiceSafe(any(Index.class))).thenReturn(indexService);
        );
import static org.mockito.Mockito.inOrder;
            listener -> {},
            items[0] = randomlySetIgnoredPrimaryResponse(items[0]);
        // Mock routing entry, allocation id
        );  
            ASSERTING_DONE_LISTENER  
            return null;
        List<BulkItemRequest> items = new ArrayList<>(nItems);  
            shard,
        when(shard.indexSettings()).thenReturn(indexSettings);
                DocWriteResponse.Result.UPDATED,  
        CountDownLatch latch = new CountDownLatch(1);  
            shard,
            // resume synchronously via the listener - no sleeps, deterministic  
        InOrder inOrder = inOrder(shard, batch);
                assertThat(response.getSeqNo(), equalTo(13L));  
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        assertThat(response.forcedRefresh(), equalTo(false));  
            updateHelper,  
        Engine.DeleteResult deleteResult = new FakeDeleteResult(1, 1, resultSeqNo, found, resultLocation);
            new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value")  
    /**
        when(shard.beginTranslogBatch()).thenReturn(batch);
            new NoopMappingUpdatePerformer(),
                        throw new IllegalStateException(e);
        when(shard.mapperService()).thenReturn(mock(MapperService.class));  
            threadPool,  
                    }
                    0,
        );
        Engine.IndexResult mappingUpdate = new Engine.IndexResult(  
import org.opensearch.threadpool.ThreadPool;
        when(batch.finish()).thenThrow(closed);  
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
    public void testFailedUpdatePreparationDoesNotTriggerRefresh() throws Exception {  
        // scope was detached and did not cross threads.
import static org.hamcrest.CoreMatchers.equalTo;  
        );
        BulkItemRequest item = new BulkItemRequest(
                .source(Requests.INDEX_CONTENT_TYPE)  
        Exception err = new VersionConflictEngineException(shardId, "id", "I'm conflicted <(;_;)>");
        ShardRouting shardRouting = mock(ShardRouting.class);
        IndexShard shard = mock(IndexShard.class);  
                // No location since all operations failed
            ASSERTING_DONE_LISTENER  
                Requests.INDEX_CONTENT_TYPE  
        ThrowingMappingUpdatePerformer(RuntimeException e) {
                    completions.incrementAndGet();  
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
        assertNull(context.getLocationToSync());
        // Exactly two batch scopes: the original (yielded) scope and the resumed scope.
        assertNull(context.getLocationToSync());
import static org.hamcrest.Matchers.emptyArray;
        when(shard.shardId()).thenReturn(shardId);
            Names.WRITE  
        TransportShardBulkAction.performOnPrimary(  
                    } catch (InterruptedException | BrokenBarrierException e) {  
                    fail("request must not be acknowledged after a batched translog append failure");
 * this file be licensed under the Apache-2.0 license or a
            Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
    }  
            new UpdateHelper.Result(
import org.opensearch.cluster.metadata.IndexMetadata;
        BulkItemRequest item = new BulkItemRequest(
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
     * finish for each scope, with no sleeps - the resume is driven by the mapping-update listener callbacks.  
                }), latch),  
            new UpdateHelper.Result(
        TransportShardBulkAction.performOnPrimary(  
            items[1] = new BulkItemRequest(1, writeRequest2);
import java.util.List;
        );
            new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
 * specific language governing permissions and limitations
        verify(batch, times(1)).finish();
        );
        TransportShardBulkAction.performOnPrimary(
            "TransportShardBulkActionTests#testForceExecutionOnRejectionAfterMappingUpdate",
        when(shard.indexSettings()).thenReturn(indexSettings);  
        DeleteResponse response = primaryResponse.getResponse();
import org.opensearch.index.IndexSettings;
        action.handlePrimaryTermValidationRequest(  
        assertTrue(primaryResponse.isFailed());  
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
import java.util.concurrent.CopyOnWriteArrayList;  
        assertEquals(ReplicationMode.PRIMARY_TERM_VALIDATION, action.getReplicationMode(indexShard));  
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();  
    public void testBatchFinishFailureDuringMappingUpdateYieldFailsRequestExactlyOnce() throws Exception {
            new NoopMappingUpdatePerformer(),
            null,  
        BulkItemRequest[] items = new BulkItemRequest[1];  
        inOrder.verify(batch).flush();
        List<String> beginThreads = new CopyOnWriteArrayList<>();  
     * once. The mapping-update continuation re-executes the runnable; without deferring, the yield-time finish failure
        boolean create = randomBoolean();
            0,
    }
    public void testMappingUpdateYieldFinishesScopeAndResumedExecutionBeginsFreshBatch() throws Exception {
 * The OpenSearch Contributors require contributions made to  
                ActionTestUtils.assertNoFailureListener(
                null,
            beginThreads.add(Thread.currentThread().getName());
            DocWriteRequest<IndexRequest> writeRequest = new IndexRequest("index").id("id_" + i)
        verify(batches.get(0)).finish();
        when(shard.indexSettings()).thenReturn(indexSettings);
                success1,  
            Settings.EMPTY,
        assertThat(primaryResponse.getFailureMessage(), containsString("I'm dead <(x.x)>"));
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
        items[0] = new BulkItemRequest(0, new IndexRequest("index").id("success1").source(Requests.INDEX_CONTENT_TYPE, "field", "value"));
        when(shard.beginTranslogBatch()).thenReturn(batch);
        assertThat(context.getLocationToSync(), not(location));
        // must be retained.
        IndexShard shard = newStartedShard(true);
            .putMapping(
            listener -> listener.onResponse(null),
        when(shard.shardId()).thenReturn(shardId);  
    }  
import org.opensearch.cluster.routing.ShardRouting;
        final VersionConflictEngineException versionConflict = new VersionConflictEngineException(
        );
        TransportShardBulkAction action = createAction();
        // ...and finish() rethrows exactly that stored instance.
        BulkItemRequest[] items = new BulkItemRequest[] {
        assertThat(response.getShardId(), equalTo(shard.shardId()));
        // Update is applied as an index op after UpdateHelper.prepare; distinguish it from the delete via the result.  
                new NoopMappingUpdatePerformer(),  
        items[0] = new BulkItemRequest(0, writeRequest);  
    public void testGetReplicationModeWithRemoteStoreFencingAndAsyncDurability() {  
        IndexShard shard = mock(IndexShard.class);
                // Verify refresh WAS called because there were successful writes  
        // the update is executed as an index operation on the shard
        assertThat(primaryResponse.getResponse().getResult(), equalTo(DocWriteResponse.Result.NOOP));
        TransportShardBulkAction.performOnPrimary(  
        return clusterService;
        TransportShardBulkAction action = new TransportShardBulkAction(
import org.opensearch.index.IndexService;  
    public static class NoopMappingUpdatePerformer implements MappingUpdatePerformer {  
        assertThat(replicaDeleteRequest.version(), equalTo(Versions.MATCH_ANY));
import org.mockito.InOrder;  
            return batch;
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));  
        protected FakeIndexResult(long version, long term, long seqNo, boolean created, Translog.Location location) {  
            Translog.Location loc = batches.isEmpty() ? scope1Location : scope2Location;  
        AlreadyClosedException finishFailure = new AlreadyClosedException("translog is already closed");  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        TransportShardBulkAction action = createAction();  
        final ReplicationTask task = createReplicationTask();
        assertThat(primaryResponse.getItemId(), equalTo(0));  
        assertThat(primaryResponse.getItemId(), equalTo(0));
            new LatchedActionListener<>(new ActionListener<>() {  
        BulkItemRequest[] items = new BulkItemRequest[1];
            mockClusterService(),
            deferredB
        BulkShardRequest completedRequest = context.getBulkShardRequest();
                randomBoolean() ? DocWriteResponse.Result.CREATED : DocWriteResponse.Result.UPDATED,
            assertThat(primaryResponse1.getOpType(), equalTo(DocWriteRequest.OpType.INDEX));
        when(shard.indexSettings()).thenReturn(indexSettings);
        private final Translog.Location location;
            mock(ActionFilters.class),
            threadPool::absoluteTimeInMillis,
import org.opensearch.indices.SystemIndices;
                }  
     * attached to itself as suppressed ({@code IllegalArgumentException: Self-suppression not permitted}), because that
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shard.shardId(), RefreshPolicy.NONE, itemRequests);
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
    public void testInlineDeleteAfterLastBatchFlushWinsOverOlderFinishLocation() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
        // Item 1: Failed update operation  
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
            Settings.EMPTY,
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
 * GitHub history for details.
    private static final ActionListener<Void> ASSERTING_DONE_LISTENER = ActionTestUtils.assertNoFailureListener(r -> {});
        DocWriteRequest<DeleteRequest> writeRequest = new DeleteRequest("index", "id");
            assertThat(primaryResponse2.getItemId(), equalTo(1));
        assertTrue(primaryResponse.isFailed());  
                    BulkShardResponse>) result;
        final long resultSeqNo = 13;
                public void onFailure(Exception e) {
        assertThat(failure.getId(), equalTo("id"));
import org.opensearch.index.mapper.RootObjectMapper;
        assertThat(response.getSeqNo(), equalTo(0L));
            context,
        assertFalse(primaryResponse.isFailed());
        assertThat(observedFailure.get(), sameInstance(appendFailure));
        when(updateHelper.prepare(any(), eq(shard), any())).thenThrow(  
        Exception err = new VersionConflictEngineException(shardId, "id", "I'm conflicted <(;_;)>");
        // With the object-store fence enforcing stale-primary fencing on every (request-durability) translog upload,
        TransportShardBulkAction action = createAction();  
            IndexShard shard = mock(IndexShard.class);  
        AtomicBoolean refreshCalled = new AtomicBoolean(false);
        }
                // Run post replication actions  
import org.opensearch.core.action.ActionListener;  
            assertThat(primaryResponse1.getId(), equalTo("id"));  
        BulkShardRequest completedRequest = context.getBulkShardRequest();  
            .primaryTerm(0, 1)
        private final Translog.Location location;
        // Verify that the shard "executed" the operation once  
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);  
                    latch.countDown();
            mockIndicesService(aId, 1L),
        when(shard.indexSettings()).thenReturn(indexSettings);
            UpdateRequest updateRequest = (UpdateRequest) item.request();
    }
    public void testTranslogPositionToSync() throws Exception {  
        closeShards(shard);
                ASSERTING_DONE_LISTENER
            new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
            )
        assertThat(batches.size(), equalTo(2));  
        inOrder.verify(shard).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());  
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);  
import java.util.concurrent.atomic.AtomicInteger;
        assertFalse(primaryResponse.isFailed());
        assertThat(failure.getStatus(), equalTo(RestStatus.CONFLICT));
            errorOnWait == false ? new ThrowingMappingUpdatePerformer(err) : new NoopMappingUpdatePerformer(),
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
import org.opensearch.action.DocWriteResponse;
        assertFalse(context.hasMoreOperationsToExecute());  
        Exception err = new VersionConflictEngineException(shardId, "id", "I'm conflicted <(;_;)>");
                Requests.INDEX_CONTENT_TYPE
        when(updateHelper.prepare(any(), eq(shard), any())).thenThrow(versionConflict);  
            shard,
        final CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.atomic.AtomicBoolean;
            mock(UpdateHelper.class),  
        assertThat(failure.getStatus(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
    public void testBulkRequestWithAllFailedUpdatesNoRefresh() throws Exception {
                (update, shardId, listener) -> {  
                throw new AssertionError(e);  
        BulkShardRequest[] completedRequest = new BulkShardRequest[1];
            return batch;
        Engine.IndexResult mappingUpdate = new Engine.IndexResult(
        assertThat(primaryResponse.getItemId(), equalTo(0));  
        bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
                shard,  
            bulkShardRequest,
        assertFalse(context.hasMoreOperationsToExecute());  
                public void onFailure(Exception e) {
        AlreadyClosedException closed = new AlreadyClosedException("translog is already closed");
        assertTrue(latch.await(5, TimeUnit.SECONDS));
 *
            ASSERTING_DONE_LISTENER
    private TransportChannel createTransportChannel(final PlainActionFuture<TransportResponse> listener) {  
        if (randomBoolean()) {
        IndexShard shard = mock(IndexShard.class);
                assertFalse(refreshCalled.get());
            updateHelper,
        when(shard.indexSettings()).thenReturn(indexSettings);  
    }
            ),  
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);  
            new NoopMappingUpdatePerformer(),
            request,
        }  
                throw new RuntimeException(e);  
    private ReplicationTask createReplicationTask() {
        assertThat(primaryResponse.getId(), equalTo("id"));
            ASSERTING_DONE_LISTENER  
            success
        // Mock all updates to fail
        assertThat(failure.getId(), equalTo("id"));
                updateResponse,
        for (int i = 0; i < 3; i++) {  
                return success;  
                }
        EngineException appendFailure = new EngineException(shardId, "simulated batched append failure");  
        when(shard.mapperService()).thenReturn(mock(MapperService.class));  
        IndexShard shard = mock(IndexShard.class);  
            )  
import org.opensearch.index.shard.ShardNotFoundException;
        );
        while (context.hasMoreOperationsToExecute()) {
    private final ShardId shardId = new ShardId("index", "_na_", 0);
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
import org.opensearch.transport.TransportService;  
            )  
                created ? DocWriteResponse.Result.CREATED : DocWriteResponse.Result.UPDATED,  
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        CountDownLatch latch = new CountDownLatch(1);  
        TransportShardBulkAction.performOnPrimary(
import org.opensearch.action.support.replication.TransportWriteAction.WritePrimaryResult;
import org.opensearch.index.mapper.Mapping;  
    /**  
        BulkItemRequest[] items = new BulkItemRequest[] {  
        assertEquals(SequenceNumbers.NO_OPS_PERFORMED, ((ReplicaResponse) listener.actionGet()).globalCheckpoint());  
        TransportShardBulkAction action = new TransportShardBulkAction(
 * not use this file except in compliance with the License.
        );
            threadPool::absoluteTimeInMillis,
        // Mock the UpdateHelper to throw a version conflict exception during preparation
        when(shard.mapperService()).thenReturn(mock(MapperService.class));
        Translog.Location resultLocation = new Translog.Location(42, 42, 42);
     * precedes the delete. The delete is then written inline at a later location, and {@code finish()} reports only
                randomBoolean() ? DocWriteResponse.Result.CREATED : DocWriteResponse.Result.UPDATED,
                    // Success  
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            threadPool,  
            new ActionListener<>() {  
            context,
                    BulkShardResponse>) result;
        when(indexShard.indexSettings()).thenReturn(
                public void onFailure(Exception e) {
        rejectingThreadPool.executor(ThreadPool.Names.WRITE).execute(() -> {
        inOrder.verify(batch).flush();
        assertThat(response.getId(), equalTo("id"));  
        );
        final ShardId shardId = new ShardId("test", "_na_", 0);  
            listener -> {},
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.IMMEDIATE, items);  
    }  
            new VersionConflictEngineException(shardId, "fail1", "version conflict")
        TransportShardBulkAction.executeBulkItemRequest(
        );
                    // Success - refresh should not have been called
                    completions.incrementAndGet();  
        // 1 for this execution)  
        // Any version can be matched on replica  
        return new TestTransportChannel(listener);
        final String aId = "test-allocation-id";
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
        UpdateRequest writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
     * roll). Regression test for the review finding on PR #23224.
            new NoopMappingUpdatePerformer(),
        BulkItemRequest replicaRequest = completedRequest.items()[0];
        AtomicBoolean refreshCalled = new AtomicBoolean(false);
            createTransportChannel(listener),
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
import org.opensearch.transport.TransportChannel;
        final Translog.Location scope2Location = new Translog.Location(1, 30, 10);
            mock(SegmentReplicationPressureService.class),  
        TransportShardBulkAction.executeBulkItemRequest(
            ),
            threadPool::absoluteTimeInMillis,
        boolean errorOnWait = randomBoolean();  
import org.opensearch.index.engine.EngineException;  
    /**
        BulkShardRequest completedRequest = context.getBulkShardRequest();
        latch.await();
            mock(RemoteStorePressureService.class),
        );  
        assertThat(failure.getCause().getClass(), equalTo(VersionConflictEngineException.class));
        );
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(  
            Names.WRITE
        );
        DeleteRequest updateResponse = new DeleteRequest("index", "id");  
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
        BulkItemResponse.Failure failure = primaryResponse.getFailure();
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
    }
            ASSERTING_DONE_LISTENER
            mockIndicesService(aId, 1L),
        when(shard.indexSettings()).thenReturn(indexSettings);
        // ASYNC durability only validates the fence at the sync interval, so the per-operation term validation fanout
            new NoopMappingUpdatePerformer(),
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
    }  
            listener -> listener.onResponse(null),  
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
    public void testExecuteBulkDeleteRequest() throws Exception {
        IndexRequest updateResponse = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");
                // Should have a location since some operations succeeded
import java.util.concurrent.BrokenBarrierException;
import org.opensearch.index.mapper.MapperService;
        when(shard.indexSettings()).thenReturn(indexSettings);
                // Verify refresh WAS called
                    BulkShardRequest,
        when(shard.shardId()).thenReturn(shardId);
    }  
        );
                    BulkShardResponse>) result;
import org.opensearch.cluster.routing.AllocationId;  
            assertEquals(item.primaryResponse().getFailure().getCause().getClass(), VersionConflictEngineException.class);
                primaryRequest.request(),  
        when(shard.beginTranslogBatch()).thenReturn(batch);
        Translog.Location resultLocation2 = new Translog.Location(43, 43, 43);
        AtomicReference<Exception> observedFailure = new AtomicReference<>();
import org.opensearch.action.delete.DeleteResponse;
            Names.WRITE
        TransportShardBulkAction.performOnPrimary(  
            when(shard.shardId()).thenReturn(shardId);
            null,
        IndexShard shard = mock(IndexShard.class);
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        // if we sync the location, nothing else is unsynced
    }
        CountDownLatch latch = new CountDownLatch(1);  
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
        Engine.IndexResult success = new FakeIndexResult(1, 1, 13, true, resultLocation);
        DocWriteRequest<IndexRequest> writeRequest = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE).create(create);
        for (int i = 0; i < nItems; i++) {
            updateHelper,  
            shard,
            new NoopMappingUpdatePerformer(),  
        when(shard.indexSettings()).thenReturn(indexSettings);
import org.opensearch.action.support.replication.ReplicationMode;
        assertEquals(primaryRequest.index(), replicaRequest.index());
        when(shard.indexSettings()).thenReturn(indexSettings);
        IndexShard shard = mock(IndexShard.class);
        DocWriteResponse response = primaryResponse.getResponse();
        );
        assertThat(primaryResult.get().location, equalTo(scope2Location));  
        closeShards(shard);  
        // Any version can be matched on replica  
        assertTrue(primaryResponse.isFailed());
            closeShards(shard);  
        when(shard.shardId()).thenReturn(shardId);
        assertThat(context.getLocationToSync(), nullValue());  
            BulkItemRequest[] items = new BulkItemRequest[2];
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        when(shard.indexSettings()).thenReturn(indexSettings);
            shard,  
     */
        bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
 * license agreements. See the NOTICE file distributed with
            items[0] = new BulkItemRequest(0, writeRequest1);  
    }
        assertDocCount(shard, 1);
        // the beating will continue until success has come.
            mock(IndicesService.class),
import org.apache.lucene.store.AlreadyClosedException;
        );
        assertEquals(primaryRequest.id(), replicaRequest.id());
                ),  
        assertThat(completedRequest.items()[0].request(), equalTo(updateResponse));
        IndexShard shard = mock(IndexShard.class);
import org.opensearch.core.rest.RestStatus;
        when(shard.shardId()).thenReturn(shardId);  
        itemRequests[0] = itemRequest;
            listener.onResponse(null);  
        doAnswer(invocation -> {  
            mock(SystemIndices.class),  
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
        );
                cyclicBarrier.await();  
        .build();  
            listener -> {},
            .settings(idxSettings)
        primaryResponse = replicaRequest.primaryResponse();  
            refreshCalled.set(true);
            updateHelper,
        assertTrue(latch.await(10, TimeUnit.SECONDS));
                Requests.INDEX_CONTENT_TYPE
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
        );  
        completedRequest = secondContext.getBulkShardRequest();
        final Translog.Location deleteLocation = new Translog.Location(1, 20, 10);
        IndexShard shard = newStartedShard(true);
        @Override  
        return indicesService;
    }
            threadPool,  
        // should be filled out with the failure information  
                Requests.INDEX_CONTENT_TYPE
            items.add(new BulkItemRequest(i, updateRequest));  
            listener -> {},
            bodyFailure  
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);  
        closeShards(shard);  
        assertThat(observedFailure.get(), equalTo(appendFailure));
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        UpdateHelper updateHelper = mock(UpdateHelper.class);
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
        assertThat(failure.getCause().getMessage(), containsString("version conflict, document already exists (current version [1])"));  
            when(batch.finish()).thenReturn(loc);
        BulkShardRequest completedRequest = context.getBulkShardRequest();
            new BulkItemRequest(0, new IndexRequest("index").id("idx").source(Requests.INDEX_CONTENT_TYPE, "field", "value")),
            super(version, term, seqNo, found);
    }  
        UpdateHelper updateHelper = mock(UpdateHelper.class);
        assertFalse(context.hasMoreOperationsToExecute());
            listener.onFailure(e);
            new UpdateHelper.Result(
import org.opensearch.action.index.IndexResponse;
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(  
            context,
     */  
                public void onResponse(PrimaryResult<BulkShardRequest, BulkShardResponse> response) {  
        IndexShard indexShard = mock(IndexShard.class);  
            new NoopMappingUpdatePerformer(),  
                assertThat(primaryResponse.getId(), equalTo("id"));
        );
            listener -> listener.onResponse(null),  
}
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(  
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
            mock(ShardStateAction.class),
        IndexShard shard = mock(IndexShard.class);
        replicaRequest = completedRequest.items()[0];
import org.opensearch.cluster.action.shard.ShardStateAction;
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.IMMEDIATE, items);
                randomBoolean() ? DocWriteResponse.Result.CREATED : DocWriteResponse.Result.UPDATED,
        }  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");  
        TransportShardBulkAction.executeBulkItemRequest(  
            null,
        items[0] = randomlySetIgnoredPrimaryResponse(items[0]);
        latch.await();
    }  
                    result -> synced.set(((WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result).location)
     * Fake IndexResult that has a settable translog location  
        writeRequest = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE).create(true);
        for (BulkItemRequest item : primaryResult.get().replicaRequest().items()) {
        assertThat(primaryResponse.getItemId(), equalTo(0));
                }
                return new FakeIndexResult(1, 1, loc, true, new Translog.Location(loc, loc, loc));
        // First attempt requires a mapping update (yield), the retry after the update succeeds.
                    assertEquals(err, e);  
                // Verify refresh was NOT called even though refresh policy was IMMEDIATE
            request,
        when(shard.shardId()).thenReturn(shardId);
                updateResponse,
            return null;
        assertThat(failure.getId(), equalTo("id"));
            assertEquals(RestStatus.TOO_MANY_REQUESTS, primaryResponse2.status());  
                assertNotNull(primaryResult.location);
        AtomicReference<Exception> observedFailure = new AtomicReference<>();
        assertThat(response.getVersion(), equalTo(1L));
    public void testPendingIndexBatchFlushesBeforeUpdateAndDeleteBoundaries() throws Exception {
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);  
            return this.location;
            Names.WRITE
        verify(batches.get(0)).finish();
            listener -> listener.onResponse(null),
    }
        assertThat(primaryResponse.getItemId(), equalTo(0));  
        CountDownLatch latch = new CountDownLatch(1);
            this.e = e;  
            shard,
            when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
            }  
            refreshCalled.set(true);
        assertTrue(primaryResponse.isFailed());  
                "{\"properties\":{\"foo\":{\"type\":\"text\",\"fields\":" + "{\"keyword\":{\"type\":\"keyword\",\"ignore_above\":256}}}}}"
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenThrow(
            new NoopMappingUpdatePerformer(),  
import org.opensearch.cluster.service.ClusterService;
        when(shard.shardId()).thenReturn(shardId);
        assertThat(primaryResponse.getId(), equalTo("id"));
        assertThat(response.getIndex(), equalTo("index"));
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
            invocation -> {  
import static org.mockito.Mockito.times;
            // resume synchronously via the listener, as the real cluster-state observer would on another thread
            threadPool::absoluteTimeInMillis,
        .put("index.number_of_shards", 1)  
    static class FakeDeleteResult extends Engine.DeleteResult {
    }
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        assertThat(primaryResponse.getFailureMessage(), containsString("some kind of exception"));
import org.opensearch.core.index.Index;
        List<Engine.TranslogBatch> batches = new CopyOnWriteArrayList<>();  
        assertThat(primaryResponse.getItemId(), equalTo(0));
            threadPool::absoluteTimeInMillis,
        // The first scope was finalized before the yield, and the resumed scope was finalized at completion.  
            // Place a task in the queue to block next enqueue
 * under the License.  
        TransportShardBulkAction.executeBulkItemRequest(context, null, threadPool::absoluteTimeInMillis, (update, shardId, listener) -> {
        assertThat(primaryResponse.getId(), equalTo("id"));  
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            )  
     * scope 1, the second needs a mapping update, so scope 1 is finished before the yield and reports its chunk  
        assertFalse(context.hasMoreOperationsToExecute());
                public void onResponse(PrimaryResult<BulkShardRequest, BulkShardResponse> response) {
            updateHelper,  
        when(batch.finish()).thenReturn(chunkLocation);
            mock(SystemIndices.class),
import org.opensearch.action.update.UpdateRequest;
        assertThat(response.getVersion(), equalTo(3L));
                Settings.builder()  
import org.opensearch.threadpool.TestThreadPool;
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
        );  
                    result -> primaryResult.set((WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result)  
        assertThat(failure.getStatus(), equalTo(RestStatus.CONFLICT));  
        assertThat(context.getLocationToSync(), equalTo(resultLocation));  
            new BulkItemRequest(1, new DeleteRequest("index", "del")) };  
            threadPool::absoluteTimeInMillis,
        UpdateHelper updateHelper = mock(UpdateHelper.class);  
                .put("thread_pool." + ThreadPool.Names.WRITE + ".queue_size", 1)
            Translog.Location resultLocation1 = new Translog.Location(42, 36, 36);
     */  
        new Thread(runnable).start();
            new NoopMappingUpdatePerformer(),
        assertTrue(context.isInitial());
        completedRequest = context.getBulkShardRequest();
        boolean found = randomBoolean();
        inOrder.verify(shard).applyDeleteOperationOnPrimary(anyLong(), any(), any(), any(), anyLong(), anyLong());
            ASSERTING_DONE_LISTENER
                assertThat(((WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result).location, equalTo(resultLocation));
        assertThat(response.getId(), equalTo("id"));  
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
                @Override
        assertTrue(primaryResponse.isFailed());  
            new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())  
        verify(shard, times(1)).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());  
        Engine.IndexResult deferredB = new FakeIndexResult(1, 1, 1, true, null);  
        verify(shard, times(2)).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
        TransportShardBulkAction.performOnPrimary(  
        TransportShardBulkAction.executeBulkItemRequest(
     * Dynamic mapping update in the middle of a batched bulk: the first document is deferred (null location) into
            new BulkItemRequest(0, new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar")) };  
import org.opensearch.index.remote.RemoteStorePressureService;  
        BulkItemResponse primaryResponse = replicaRequest.primaryResponse();  
                },  
                new BulkItemResponse.Failure("index", "1", exception, 1L, 1L)  
            new BulkItemRequest(0, new IndexRequest("index").id("a").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar")),
        // Translog changes, because the document was deleted
     * threads), and when execution resumes on another thread it must open a brand-new batch via
                bulkShardRequest,
import java.util.concurrent.CyclicBarrier;
            new NoopMappingUpdatePerformer(),  
            new NoopMappingUpdatePerformer(),
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);  
        assertThat(context.getLocationToSync(), nullValue());
import java.util.Arrays;
    }
    public void testGetReplicationModeWithRemoteStoreFencing() {
     * batch scope must be finalized with {@link Engine.TranslogBatch#finish()} (so a pending chunk never crosses  
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenAnswer(  
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
        }).when(shard).refresh(any());  
    }  
        assertThat(observedFailure.get(), sameInstance(bodyFailure));
        verify(shard, times(1)).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
        // Execute bulk operation
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        );
            } catch (Exception e) {
        // The setting is inert without remote store; fencing must not take replicas off the write path.  
            when(batch.flush()).thenReturn(loc);
        assertDocCount(shard, 1);
        when(updateHelper.prepare(any(), eq(shard), any())).thenThrow(err);
        }
            }
import org.opensearch.action.delete.DeleteRequest;
        assertThat(failure.getCause(), equalTo(err));
        assertFalse(context.hasMoreOperationsToExecute());  
        // Create multiple failed update operations
        Runnable runnable = () -> TransportShardBulkAction.performOnPrimary(  
        closeShards(shard);
            threadPool,
        // Return an exception when trying to update the mapping, or when waiting for it to come  
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        when(batch.finish()).thenThrow(finishFailure);
        }).when(shard).refresh(any());
                any(LongSupplier.class)  
        Engine.IndexResult mappingUpdate = new Engine.IndexResult(
        items[0] = randomlySetIgnoredPrimaryResponse(items[0]);
            listener -> listener.onResponse(null),  
            // There should indeed be a mapping update
        }).when(shard).refresh(any());
        );
        RuntimeException err = new RuntimeException("some kind of exception");
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(primaryResponse.getOpType(), equalTo(create ? DocWriteRequest.OpType.CREATE : DocWriteRequest.OpType.INDEX));
                return conflictedResult;
 */  
                public void onFailure(Exception e) {
            NoopTracer.INSTANCE  
        AtomicInteger updateCalled = new AtomicInteger();  
    public void testUpdateWithRetryOnConflict() throws IOException, InterruptedException {
            updateHelper,
            threadPool::absoluteTimeInMillis,
            new IndexRequest("index").source(Requests.INDEX_CONTENT_TYPE),
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);  
            logger.debug("Setting retryCount for item {}: {}", i, retryOnConflictCount);  
            listener -> listener.onResponse(null),
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        assertThat(primaryResponse.getFailureMessage(), containsString("oops"));
                return mappingUpdate;
                primaryResult.runPostReplicationActions(ActionListener.wrap(v -> {
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        IndexShard shard = mock(IndexShard.class);  
    }
                for (BulkItemRequest item : result.replicaRequest().items()) {  
            updateHelper,
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);  
            listener -> {},
 *  
            new BulkItemRequest(0, new IndexRequest("index").id("idx").source(Requests.INDEX_CONTENT_TYPE, "field", "value")),
            Settings.builder()
    public void testBatchFinishFailureDoesNotMaskBodyFailure() throws Exception {
            Names.WRITE
            threadPool::absoluteTimeInMillis,  
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
                Collections.singletonMap("field", "value"),  
import static org.mockito.Mockito.anyLong;
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();  
                .build()
        assertThat(failure.getCause(), equalTo(err));
        TransportShardBulkAction.performOnPrimary(
        List<Engine.TranslogBatch> batches = new CopyOnWriteArrayList<>();
        assertThat(primaryResponse.getResponse().getSeqNo(), equalTo(0L));  
                Requests.INDEX_CONTENT_TYPE
        when(batch.flush()).thenReturn(chunkLocation);
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();  
    public void testUpdateRequestWithSuccess() throws Exception {  
import org.opensearch.transport.TestTransportChannel;
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");  
            new LatchedActionListener<>(new ActionListener<Void>() {  
     * The real failure path: a failed {@code TranslogBatchScope} stores the append exception and rethrows that very
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
            )
        when(indexShard.indexSettings()).thenReturn(  
        AtomicReference<Exception> observedFailure = new AtomicReference<>();
import static org.hamcrest.Matchers.containsString;
        // Item 2: Successful index operation  
        assertThat(response.getSeqNo(), equalTo(resultSeqNo));
    private IndexMetadata indexMetadata() throws IOException {
    }
            new NoopMappingUpdatePerformer(),  
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
        );
    }
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
        // Execute bulk operation
                rejectingThreadPool,
        // thread so we can prove the resumed execution ran on a different thread.
        Engine.IndexResult indexResult = new Engine.IndexResult(err, 0, 0, 0);  
        Engine.IndexResult successResult2 = new FakeIndexResult(1, 1, 12, true, resultLocation2);
        assertFalse(context.hasMoreOperationsToExecute());
                // Run post replication actions
        // Mock refresh to track if it's called  
            );  
        );
        }  
    /**  
        BulkItemRequest[] items = new BulkItemRequest[] {
import static org.hamcrest.Matchers.sameInstance;
            new BulkItemRequest(2, new DeleteRequest("index", "del")) };  
            mock(MappingUpdatedAction.class),
            BulkItemResponse primaryResponse2 = completedRequest[0].items()[1].primaryResponse();  
            Names.WRITE
        AtomicInteger completions = new AtomicInteger();
        final Translog.Location scope1Location = new Translog.Location(1, 10, 10);
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(  
        );
        IndexRequest updateResponse = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");  
        });
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenThrow(closed);  
            "id",  
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        // must be preceded by a flush of the pending index chunk.
        );
import org.opensearch.action.update.UpdateHelper;  
            threadPool,
                @Override
        assertThat(response.status(), equalTo(RestStatus.OK));
        CountDownLatch latch = new CountDownLatch(1);
    }
import org.opensearch.action.support.PlainActionFuture;
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));  
            new NoopMappingUpdatePerformer(),  
        IndexShard shard = mock(IndexShard.class);  
        // Execute the bulk operation through performOnPrimary
            }
            threadPool,
        replicaDeleteRequest = replicaRequest.request();
        assertNotNull(task.getPhase());  
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {}), latch),
        assertThat(failure.getCause(), equalTo(err));
                assertNotNull(primaryResult.location);
                    // Assert that we still need to fsync the location that was successfully written  
        TransportShardBulkAction.performOnPrimary(  
            mock(UpdateHelper.class),
    }
        try {  
    }
import static org.hamcrest.Matchers.nullValue;  
import org.opensearch.OpenSearchException;
import org.opensearch.index.translog.TranslogException;  
     * instance from {@code finish()}, so the body failure and the finish failure are the same object. It must not be  
            mock(IndexingPressureService.class),  
        BulkItemResponse.Failure failure = primaryResponse.getFailure();
     * sync to the later location, and both items must be acknowledged.
            try {  
            Names.WRITE  
                public void onFailure(final Exception e) {
            ASSERTING_DONE_LISTENER
        // Check that the translog is successfully advanced
            updateHelper,
                Collections.singletonMap("field", "value"),
            mock(ActionFilters.class),  
            shard,  
        // (older) greatest batch location.  
            bulkShardRequest,
        assertThat(failure.getIndex(), equalTo("index"));
        TranslogException appendFailure = new TranslogException(shardId, "simulated append failure at yield");  
        // Create successful operations
                    .build()
        Translog.Location resultLocation1 = new Translog.Location(42, 42, 42);
            new NoopMappingUpdatePerformer(),  
            threadPool,
            TransportShardBulkAction.performOnPrimary(
            listener -> {},  
            createIndexSettings(  
                WritePrimaryResult<BulkShardRequest, BulkShardResponse> primaryResult = (WritePrimaryResult<  
                }
                )
            int retryOnConflictCount = randomIntBetween(0, 3);
        // Since this was not a conflict failure, the primary response
                    listener.onResponse(null);
            Names.WRITE
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
        }  
        );
        closeShards(shard);
    }
import static org.mockito.Mockito.anyBoolean;
        assertEquals(ReplicationMode.PRIMARY_TERM_VALIDATION, action.getReplicationMode(indexShard));
        assertThat(replicaDeleteRequest.versionType(), equalTo(VersionType.INTERNAL));
        // Now do the same after indexing the document, it should now find and delete the document
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };  
        @Override
        TransportShardBulkAction action = new TransportShardBulkAction(  
        verify(batches.get(1)).finish();
            }), latch),
import org.opensearch.index.shard.IndexShardTestCase;  
            success  
            indexResult
        assertThat(response.getSeqNo(), equalTo(13L));
        BulkItemRequest[] items = new BulkItemRequest[2];
                new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
        location = context.getLocationToSync();  
import org.opensearch.common.lucene.uid.Versions;  
        CountDownLatch latch = new CountDownLatch(1);  
        // should be filled out with the failure information
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
                    .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)  
        final ShardId shardId = new ShardId("test", "_na_", 0);
            request,
            mock(SegmentReplicationPressureService.class),
            bulkShardRequest,
            mock(MappingUpdatedAction.class),  
import org.opensearch.action.support.WriteRequest.RefreshPolicy;  
            items[i] = new BulkItemRequest(i, new UpdateRequest("index", "id" + i).doc(Requests.INDEX_CONTENT_TYPE, "field", "value"));
                assertTrue(refreshCalled.get());
        assertThat(primaryResponse.getItemId(), equalTo(0));
/*  
                assertNull(primaryResult.location);
                // Verify no location to sync (no writes occurred)  
            rejectingThreadPool.shutdownNow();
        }
                listener -> {},
            threadPool::absoluteTimeInMillis,
            final CountDownLatch latch = new CountDownLatch(1);  
                Requests.INDEX_CONTENT_TYPE
        IndexShard shard = mock(IndexShard.class);  
        for (BulkItemRequest item : completedRequest[0].items()) {  
                    try {
        final ShardId shardId = new ShardId("test", "_na_", 0);
            new LatchedActionListener<>(new ActionListener<>() {
        // Index op succeeds and leaves a chunk pending in the batch.
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        IndexService indexService = mock(IndexService.class);
        IndexShard shard = newStartedShard(true);
            if (randomBoolean()) {  
        assertThat(response.forcedRefresh(), equalTo(false));  
        UpdateHelper updateHelper = mock(UpdateHelper.class);
        when(shard.shardId()).thenReturn(shardId);  
        assertThat(primaryResponse.getId(), equalTo("id"));
        indexDoc(shard, "_doc", "id", "{}");  
            new BulkItemResponse(  
        final IndexShard indexShard = mock(IndexShard.class);
        when(shard.beginTranslogBatch()).thenReturn(batch);
            )
            Names.WRITE
            request,
                    assertEquals(VersionConflictEngineException.class, item.primaryResponse().getFailure().getCause().getClass());
                updateResponse,
            threadPool::absoluteTimeInMillis,
    /**
        );
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };  
                randomFrom(DocWriteRequest.OpType.CREATE, DocWriteRequest.OpType.DELETE, DocWriteRequest.OpType.INDEX),
        assertThat(primaryResponse.getId(), equalTo("id"));
                DocWriteResponse.Result.DELETED,  
     */  
            errorOnWait ? listener -> listener.onFailure(err) : listener -> listener.onResponse(null),
        // Mock successful operations  
        latch.await();
import java.util.concurrent.TimeUnit;  
            null,
                0,
            Engine.IndexResult success2 = new FakeIndexResult(1, 1, 13, true, resultLocation2);
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.DELETE));  
            new UpdateHelper.Result(  
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
        }
            context,
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
                }, e -> { fail("Post replication actions should not fail: " + e.getMessage()); }));  
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
        @Override
        );
            threadPool,  
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            super(version, term, seqNo, created);
 * SPDX-License-Identifier: Apache-2.0
                logger.info("blocking the write executor");
                Collections.singletonMap("field", "value"),
            ASSERTING_DONE_LISTENER
        }
        UpdateHelper updateHelper = mock(UpdateHelper.class);  
        assertThat(failure.getId(), equalTo("id"));
                    .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
        // Translog shouldn't be synced, as there were conflicting mappings
     * does not recognise.  
            cyclicBarrier.await();
        assertThrows(IllegalStateException.class, listener::actionGet);
            }), latch),
                new BulkItemResponse(
        TranslogException bodyFailure = new TranslogException(shardId, "simulated inline translog failure");
        );
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
        }
            mock(UpdateHelper.class),  
                DocWriteResponse response = primaryResponse.getResponse();
        assertThat(primaryResponse.getOpType(), equalTo(writeRequest.opType()));
        BulkItemRequest[] items = new BulkItemRequest[1];
        final IndexShard indexShard = mock(IndexShard.class);
            }
        );
                primaryResult.runPostReplicationActions(ActionListener.wrap(v -> {
import org.opensearch.cluster.action.index.MappingUpdatedAction;  
        inOrder.verify(batch).finish();  
            mock(ActionFilters.class),
                int loc = locationCounter.getAndIncrement();
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
import java.util.ArrayList;
            threadPool,
        UpdateHelper updateHelper = mock(UpdateHelper.class);
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenAnswer(ir -> {
        when(shard.shardId()).thenReturn(shardId);  
                latch
    public void testForceExecutionOnRejectionAfterMappingUpdate() throws Exception {
            threadPool,
            assertThat(primaryResponse2.getOpType(), equalTo(DocWriteRequest.OpType.INDEX));  
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);  
import org.opensearch.core.index.shard.ShardId;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * A batched index result carries no translog location when it is recorded; its chunk is appended by the flush that
        assertEquals("failed", task.getPhase());
            listener -> listener.onResponse(null),  
        });
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        }  
        return IndexMetadata.builder("index")  
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items.toArray(BulkItemRequest[]::new));
        );
import org.opensearch.transport.client.Requests;
        assertFalse(primaryResponse.isFailed());
            Settings.EMPTY,  
        );
    private TransportShardBulkAction createAction() {  
                        cyclicBarrier.await();
            mock(ShardStateAction.class),
            new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
        TransportShardBulkAction.executeBulkItemRequest(  
        );
            new NoopMappingUpdatePerformer(),
        TransportShardBulkAction.executeBulkItemRequest(  
        final String aId = "test-allocation-id";
        IndexShard shard = mock(IndexShard.class);  
    public void testHandlePrimaryTermValidationRequestWithOlderPrimaryTerm() {
            batches.add(batch);  
        inOrder.verify(batch).flush();
/*  
        AtomicInteger locationCounter = new AtomicInteger(42);
            return this.location;
            new FakeIndexResult(1, 1, 0, true, null)  
            task  
import static org.mockito.Mockito.when;
            }, latch),
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.IMMEDIATE, items);  
        doAnswer(invocation -> {
            BulkItemResponse primaryResponse1 = completedRequest[0].items()[0].primaryResponse();
                Settings.builder()
        final CountDownLatch latch = new CountDownLatch(1);
            )
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
                    observedFailure.set(e);
            ir -> conflictedResult
     * When the request body throws (as a per-operation translog failure does today) and the final-chunk append then
                BulkItemResponse primaryResponse = result.replicaRequest().items()[0].primaryResponse();  
            updateCalled.incrementAndGet();
        Engine.IndexResult successResult1 = new FakeIndexResult(1, 1, 10, true, resultLocation1);  
        TestThreadPool rejectingThreadPool = new TestThreadPool(  
        assertThat(failure.getId(), equalTo("id"));
        IndicesService indicesService = mock(IndicesService.class);
            shard,
            threadPool::absoluteTimeInMillis,  
            listener -> listener.onResponse(null),
import static org.hamcrest.Matchers.contains;  
        );
     * would replace an {@link AlreadyClosedException} the coordinator retries on the re-promoted primary with one it
    public void testGetReplicationModeWithFencingOnNonRemoteIndex() {
        assertThat(primaryResponse.getId(), equalTo("id"));
import org.opensearch.action.DocWriteRequest;
                .source(Requests.INDEX_CONTENT_TYPE, "foo", "bar");
        });  
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, new BulkItemRequest[] { item });
import org.opensearch.action.support.TransportActions;
            new NoopMappingUpdatePerformer(),
        final String aId = "test-allocation-id";  
        assertThat(primaryResponse.getItemId(), equalTo(0));  
import org.opensearch.index.IndexingPressureService;
        final ReplicationTask task = createReplicationTask();  
     * The pending index chunk must be appended (flushed) before an UPDATE and before a DELETE are applied, so that an
        IndexShard shard = mock(IndexShard.class);
            mock(RemoteStorePressureService.class),
        // Verify that the shard "executed" the operation only once (1 for previous invocations plus
            task
            BulkShardRequest[] completedRequest = new BulkShardRequest[1];
            context,
        // Mock successful index operations  
        BulkItemResponse.Failure failure = primaryResponse.getFailure();  
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
    private IndicesService mockIndicesService(String aId, long primaryTerm) {
        // Should be failed since the document already exists
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));  
        assertTrue(listener.actionGet() instanceof ReplicaResponse);
        // execute the runnable on a separate thread so that the infinite loop can be detected  
            NoopTracer.INSTANCE  
import org.opensearch.action.LatchedActionListener;  
        return primaryRequest;
        // Since this was not a conflict failure, the primary response
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {}), latch),
        // Assert that the document count is still 1
        // Both operations were attempted (mapping-update attempt + successful retry).  
    }
        assertTrue(context.hasMoreOperationsToExecute());
        CountDownLatch latch = new CountDownLatch(1);
        assertFalse(context.hasMoreOperationsToExecute());  
     * would fail the request and the re-execution would then complete it a second time.
                    assertNotNull(update);
    }
                Collections.singletonMap("field", "value"),
            )  
            Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);  
            latch.await();
            bulkShardRequest,
    public void testBulkRequestWithMixedSuccessAndFailureRefresh() throws Exception {  
            null,  
    public void testUpdateWithDelete() throws Exception {
        public void updateMappings(Mapping update, ShardId shardId, ActionListener<Void> listener) {
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
        );  
                any(IndexShard.class),
        // should be filled out with the failure information  
        items[0] = primaryRequest;
        assertThat(response.getResult(), equalTo(DocWriteResponse.Result.DELETED));  
        BulkShardRequest completedRequest = context.getBulkShardRequest();
        BulkItemRequest[] items = new BulkItemRequest[3];
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.CREATE));
                noopUpdateResponse,
            items[i] = new BulkItemRequest(i, writeRequest);
        when(shard.shardId()).thenReturn(shardId);  
        final ReplicationTask task = createReplicationTask();
     */
        when(shardRouting.allocationId()).thenReturn(allocationId);  
        assertThat(primaryResponse.getId(), equalTo("id"));  
        assertThat(response.status(), equalTo(created ? RestStatus.CREATED : RestStatus.OK));  
                }, e -> { fail("Post replication actions should not fail: " + e.getMessage()); }));
        when(shard.shardId()).thenReturn(shardId);
        assertThat(failure.getIndex(), equalTo("index"));  
    }
            if (e != null) {
        assertFalse(context.hasMoreOperationsToExecute());
        );
            new NoopMappingUpdatePerformer(),
            threadPool,  
                cyclicBarrier.await();
        verify(batch, times(1)).finish();
        assertDocCount(shard, 0);
        Engine.IndexResult success = new FakeIndexResult(1, 1, 13, true, resultLocation);
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, new BulkItemRequest[] { item });  
        assertThat(observedFailure.get(), sameInstance(closed));
            refreshCalled.set(true);  
            context,
            mock(TransportService.class),
    }  
        );
            assertFalse(item.primaryResponse().isFailed());  
        // Track refresh calls  
            ASSERTING_DONE_LISTENER
        assertFalse(shard.isSyncNeeded());  
            Names.WRITE  
                        // Release blocking task now that the continue write execution has been rejected and  
        when(shard.shardId()).thenReturn(shardId);
            listener -> listener.onResponse(null),  
            mock(ActionFilters.class),
            threadPool,
        assertThat(replicaDeleteRequest.versionType(), equalTo(VersionType.INTERNAL));
    public void testHandlePrimaryTermValidationRequestWithDifferentAllocationId() {  
            listener -> {},  
        items[0] = new BulkItemRequest(0, writeRequest);
        );
        when(shard.shardId()).thenReturn(shardId);
        when(shard.indexSettings()).thenReturn(indexSettings);
     * interleaving of {@link Engine.TranslogBatch#flush()} with the shard apply calls using a single {@link InOrder}
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
     * the greatest location the batch itself appended, which is older than the delete. The request must sync to the  
                ),
        BulkItemRequest[] items = new BulkItemRequest[] {
        items[0] = randomlySetIgnoredPrimaryResponse(items[0]);
        Engine.IndexResult conflictedResult = new Engine.IndexResult(err, 0);  
            mappingUpdate  
        UpdateHelper updateHelper = mock(UpdateHelper.class);
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        );
            }), latch),
        assertThat(primaryResponse.getId(), equalTo("id"));  
        DocWriteRequest<IndexRequest> writeRequest = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar");
        assertThat(failure.getIndex(), equalTo("index"));  
                updatedDoc,
        final String failureMessage = "simulated primary failure";
            threadPool,
            latch.countDown();
            new NoopMappingUpdatePerformer(),
    public void testSameFailureInstanceFromBodyAndFinishIsNotSelfSuppressed() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(primaryResponse2.getFailure().getCause(), instanceOf(OpenSearchRejectedExecutionException.class));
    public void testSuccessfulBulkOperationStillTriggersRefresh() throws Exception {
            threadPool::absoluteTimeInMillis,
    }
            new BulkItemRequest(0, new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar")) };
        DocWriteResponse response = primaryResponse.getResponse();  
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
            TransportShardBulkAction.executeBulkItemRequest(
        when(shard.indexSettings()).thenReturn(indexSettings);
            AtomicInteger updateCalled = new AtomicInteger();  
            when(shard.mapperService()).thenReturn(mock(MapperService.class));
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.IMMEDIATE, items);
        assertEquals(primaryRequest.request(), replicaRequest.request());  
            createTransportChannel(listener),
     * update/delete can never be ordered ahead of an index operation it logically follows. This asserts the exact  
        verify(shard, times(2)).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
import static org.mockito.Mockito.any;  
            )  
            // UpdateRequest::prepareRequest
            mock(ShardStateAction.class),  
        );
            (update, shardId, listener) -> fail("should not have had to update the mappings"),
    /**
            null,  
        IndexShard shard = mock(IndexShard.class);  
            Names.WRITE
    /** Doesn't perform any mapping updates */
        );
            updateHelper,  
        TransportShardBulkAction.performOnReplica(bulkShardRequest, shard);  
            }, latch)
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
        // Since this was not a conflict failure, the primary response
    }
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
                Collections.singletonMap("field", "value"),
        TransportShardBulkAction.performOnPrimary(  
    public void testMappingUpdateMidBatchSyncsToLaterScopeLocation() throws Exception {
        shard.sync(context.getLocationToSync(), e -> {
        when(shard.indexSettings()).thenReturn(indexSettings);
        inOrder.verify(shard).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());  
            assertFalse(primaryResponse1.isFailed());
                assertThat(primaryResponse.getItemId(), equalTo(0));
                }
            );  
            threadPool::absoluteTimeInMillis,
        assertNotNull(task.getPhase());
        );
        // timeout the request in 10 seconds if there is an infinite loop  
            updateHelper,
        BulkItemRequest[] items = new BulkItemRequest[1];
            listener -> listener.onResponse(null),
            new TransportShardBulkAction.PrimaryTermValidationRequest(aId + "-1", 1, shardId),
        items[2] = new BulkItemRequest(2, new IndexRequest("index").id("success2").source(Requests.INDEX_CONTENT_TYPE, "field", "value"));
            threadPool::absoluteTimeInMillis,
        // replicas come off the write path entirely - no primary term validation fanout.  
import org.opensearch.common.settings.Settings;
        assertFalse(context.hasMoreOperationsToExecute());
            mockClusterService(),
        // Mock failed update operation
import org.opensearch.index.VersionType;
            Names.WRITE  
            new LatchedActionListener<>(  
            new FakeIndexResult(1, 1, 10, true, new Translog.Location(10, 10, 10)),  
            BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
    private class ThrowingMappingUpdatePerformer implements MappingUpdatePerformer {
        );  
        BulkItemRequest replicaRequest = completedRequest.items()[0];
        public Translog.Location getTranslogLocation() {  
        // Each doRun() invocation opens a fresh batch; hand out a distinct mock per begin call and record the calling  
        assertThat(primaryResponse.getId(), equalTo("id"));
                }
            );
                updateResponse,
        TransportShardBulkAction.performOnPrimary(
        when(shard.shardId()).thenReturn(shardId);  
            new UpdateHelper.Result(  
            mock(TransportService.class),  
            rejectingThreadPool.executor(ThreadPool.Names.WRITE).execute(() -> {});  
        UpdateHelper updateHelper = mock(UpdateHelper.class);
                @Override
            }, latch),
        Engine.IndexResult indexResult = new FakeIndexResult(1, 1, 13, created, resultLocation);  
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.DELETE));  
                    // Success
            return null;  
        }
            threadPool,  
        items[0] = new BulkItemRequest(0, new IndexRequest("index").id("id1").source(Requests.INDEX_CONTENT_TYPE, "field", "value1"));  
        DocWriteRequest<IndexRequest> writeRequest = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar");  
            threadPool::absoluteTimeInMillis,  
            threadPool,
        assertThat(completedRequest.items().length, equalTo(1));
        // The resumed execution began its fresh batch on a different thread than the original invocation, proving the
            request,
        }
        DocWriteResponse noopUpdateResponse = new UpdateResponse(shardId, "id", 0, 2, 1, DocWriteResponse.Result.NOOP);
            threadPool,  
import org.opensearch.action.support.ActionTestUtils;  
                @Override
            listener -> listener.onResponse(null),
    /**
        closeShards(shard);
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
                null,
                Names.WRITE
        assertThat(failure.getCause(), equalTo(err));  
        primaryResponse = replicaRequest.primaryResponse();  
            listener -> {},  
        public void updateMappings(Mapping update, ShardId shardId, ActionListener<Void> listener) {
        BulkItemResponse.Failure failure = primaryResponse.getFailure();
                }, e -> { fail("Post replication actions should not fail: " + e.getMessage()); }));
            threadPool::absoluteTimeInMillis,  
        primaryRequest = new BulkItemRequest(0, writeRequest);
    /**  
                public void onResponse(Void aVoid) {}
                .retryOnConflict(retryOnConflictCount);
        assertThat(replicaDeleteRequest.version(), equalTo(Versions.MATCH_ANY));
            successResult1
        BulkItemRequest[] items = new BulkItemRequest[randomIntBetween(2, 5)];  
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
        UpdateHelper updateHelper = mock(UpdateHelper.class);
        final IndexShard shard = spy(newStartedShard(false));  
            mock(IndexingPressureService.class),
                updateResponse,
            mockClusterService(),  
            threadPool::absoluteTimeInMillis,
import org.opensearch.action.support.ActionFilters;
                new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
            updateHelper,
    public void testUpdateRequestWithConflictFailure() throws Exception {
                primaryResult.runPostReplicationActions(ActionListener.wrap(v -> {
                    BulkShardRequest,  
        assertThat(synced.get(), equalTo(deleteLocation));
        when(shard.beginTranslogBatch()).thenAnswer(invocation -> {
        assertFalse(context.hasMoreOperationsToExecute());
     * delete's location, otherwise an acknowledged delete can escape the sync (or the remote upload after a generation
            new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
        return new ReplicationTask(0, null, null, null, null, null);  
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        doAnswer(invocation -> {
            "version conflict during update preparation"
import static org.mockito.Mockito.spy;
        Engine.IndexResult mappingUpdate = new Engine.IndexResult(  
        final IOException exception = new IOException(failureMessage);
            mock(MappingUpdatedAction.class),
        }).when(shard).refresh(any());  
            new BulkItemRequest(1, new UpdateRequest("index", "upd").doc(Requests.INDEX_CONTENT_TYPE, "field", "value")),
        IndexRequest updateResponse = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");
        );  
            assertThat(primaryResponse1.getResponse().status(), equalTo(RestStatus.CREATED));  
        assertThat(failure.getIndex(), equalTo("index"));  
import static org.mockito.Mockito.mock;  
        items[0] = new BulkItemRequest(0, writeRequest);  
                .opType(DocWriteRequest.OpType.INDEX);
        );
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        TransportShardBulkAction.executeBulkItemRequest(  
            mock(RemoteStorePressureService.class),
            )
        assertThat(response.getShardId(), equalTo(shard.shardId()));
        BulkShardRequest completedRequest = context.getBulkShardRequest();
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);  
import java.util.concurrent.atomic.AtomicReference;  
            if (randomBoolean()) {  
                WritePrimaryResult<BulkShardRequest, BulkShardResponse> primaryResult = (WritePrimaryResult<  
        assertThat(Arrays.asList(bodyFailure.getSuppressed()), contains(sameInstance(finishFailure)));  
            ASSERTING_DONE_LISTENER
        );
        AtomicReference<Exception> observedFailure = new AtomicReference<>();  
            NoopTracer.INSTANCE
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        // Check that the translog is successfully advanced
            threadPool::absoluteTimeInMillis,  
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
    /**
                // Run post replication actions
        response = primaryResponse.getResponse();
        assertNotNull(context.getLocationToSync());
     * A batched append that fails while the runnable is yielding for a mapping update must fail the request exactly  
        }
import org.opensearch.action.support.replication.TransportReplicationAction.ReplicaResponse;
            Names.WRITE  
        IndexRequest updateResponse = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");  
            mockClusterService(),
            new LatchedActionListener<>(
                    updateCalled.incrementAndGet();  
        // Pretend the mappings haven't made it to the node yet
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
            )
            new LatchedActionListener<>(new ActionListener<>() {
            this.location = location;
            context,  
            Engine.IndexResult success1 = new FakeIndexResult(1, 1, 10, true, resultLocation1);  
        items[1] = new BulkItemRequest(1, new IndexRequest("index").id("id2").source(Requests.INDEX_CONTENT_TYPE, "field", "value2"));
        TransportShardBulkAction.executeBulkItemRequest(
                eq(updateRequest),
                    completedRequest[0] = result.replicaRequest();
            new NoopMappingUpdatePerformer(),
            new FakeIndexResult(1, 1, 11, true, new Translog.Location(11, 11, 11))
                    observedFailure.set(e);  
        protected FakeDeleteResult(long version, long term, long seqNo, boolean found, Translog.Location location) {  
        assertThat(primaryResponse.getId(), equalTo("id"));
    }
            );  
            assertNotNull(item.primaryResponse());
            mock(MappingUpdatedAction.class),
            shard,  
            bulkShardRequest,
 */  
            listener -> listener.onResponse(null),
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
    /**
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        AtomicBoolean refreshCalled = new AtomicBoolean(false);
        ).thenReturn(successResult2);
            context,
        // Create a mix of successful and failed operations  
                rejectingThreadPool::absoluteTimeInMillis,
            new FakeDeleteResult(1, 1, 11, true, deleteLocation)  
        });  
                true,
            0,  
            shard,
            listener -> listener.onResponse(null),  
        when(shard.indexSettings()).thenReturn(indexSettings);  
            shard,
            null,
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
        // Translog should change, since there were no problems  
        assertThat(primaryResponse.getItemId(), equalTo(0));  
        TransportShardBulkAction action = createAction();
            mock(UpdateHelper.class),
        assertNull(secondContext.getLocationToSync());
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        verify(shard, times(1)).markSeqNoAsNoop(1, 1, exception.toString());
    public void testGetReplicationModeWithLocalTranslog() {  
                mappingUpdate,
    public void testNoOpReplicationOnPrimaryDocumentFailure() throws Exception {
                Collections.singletonMap("field", "value"),  
        final IndexShard indexShard = mock(IndexShard.class);
            NoopTracer.INSTANCE
            null,
        IndexShard shard = mock(IndexShard.class);
        BulkShardRequest completedRequest = context.getBulkShardRequest();  
import org.opensearch.action.support.replication.ReplicationTask;
                completedRequest[0] = result.replicaRequest();  
        final IndexShard indexShard = mock(IndexShard.class);
            },
            Names.WRITE  
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
import java.util.function.LongSupplier;
                assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));  
        );  
        assertThat(context.getLocationToSync(), equalTo(resultLocation));  
            mock(SegmentReplicationPressureService.class),  
            mock(SystemIndices.class),
            Translog.Location resultLocation2 = new Translog.Location(42, 42, 42);
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
     */
        }
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(  
        assertThat(completedRequest.items()[0].request(), equalTo(updateResponse));
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);  
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        when(shard.shardId()).thenReturn(shardId);
            createIndexSettings(false, Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true).build())
        boolean created = randomBoolean();
                WritePrimaryResult<BulkShardRequest, BulkShardResponse> primaryResult = (WritePrimaryResult<
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);  
        Engine.IndexResult indexResult = new Engine.IndexResult(err, 0, 0, 0);
            this.location = location;
        );
     * over both the batch and the shard, for a mixed INDEX, UPDATE, DELETE bulk request.
            new FakeDeleteResult(1, 1, 12, true, new Translog.Location(12, 12, 12))  
        BulkItemRequest[] items = new BulkItemRequest[3];
        // A single ordered verification across both mocks proves the interleaving:
        assertThat(context.getLocationToSync(), not(location));
            null,
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
     * When an operation requires a dynamic mapping update, execution yields the thread. Before yielding, the current
        );
            batches.add(batch);  
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        when(shard.shardId()).thenReturn(shardId);
                    fail("request must not be acknowledged");  
            verify(updateHelper, times(updateRequest.retryOnConflict() + 1)).prepare(  
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };  
            UpdateRequest updateRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value")
            }, latch),
            Engine.IndexResult mappingUpdate = new Engine.IndexResult(
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");  
        assertThat(primaryResponse.getId(), equalTo("id"));
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, new BulkItemRequest[] { item });
        // The flush before the delete appends the pending index chunk; finish has nothing left and reports the same
                latch
            task
                // Verify refresh was NOT called  
            request,  
            Settings.EMPTY,
            assertThat("mappings were \"updated\" once", updateCalled.get(), equalTo(1));  
                @Override
            refreshCalled.set(true);
        );
        BulkItemRequest item = new BulkItemRequest(
        assertBusy(() -> assertThat(completions.get(), equalTo(1)));
            mock(IndexingPressureService.class),
        TransportShardBulkAction.executeBulkItemRequest(
                logger.info("unblocked the write executor");
 * this work for additional information regarding copyright
        UpdateHelper updateHelper = mock(UpdateHelper.class);
    public void testBatchedTranslogFinishFailureFailsRequestAcknowledgement() throws Exception {  
            assertNotNull(update);  
        }, listener -> listener.onResponse(null), ASSERTING_DONE_LISTENER);  
import static org.mockito.Mockito.verify;  
        BulkItemRequest[] items = new BulkItemRequest[] {  
            .build();  
        assertEquals("failed", task.getPhase());
        BulkShardRequest completedRequest = context.getBulkShardRequest();  
        CountDownLatch latch = new CountDownLatch(1);
        assertThat(primaryResponse.getItemId(), equalTo(0));
        action.handlePrimaryTermValidationRequest(
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            null,  
        when(shard.mapperService()).thenReturn(mock(MapperService.class));
        assertTrue(latch.await(5, TimeUnit.SECONDS));
                @Override
            mock(SegmentReplicationPressureService.class),
                Requests.INDEX_CONTENT_TYPE
            mockIndicesService(aId, 2L),  
        BulkPrimaryExecutionContext secondContext = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        for (int i = 0; i < items.length; i++) {
        assertThat(beginThreads.size(), equalTo(2));
package org.opensearch.action.bulk;
        assertThat(beginThreads.get(1), not(equalTo(beginThreads.get(0))));  
        // Basically nothing changes in the request since it's a noop  
        Translog.Location resultLocation = new Translog.Location(42, 42, 42);
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
                }
                ActionTestUtils.assertNoFailureListener(
                    latch.countDown();
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        );  
                        // the finishRequest execution has been force enqueued
        TransportShardBulkAction.executeBulkItemRequest(  
            shard,  
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);  
            mappingUpdate,  
            listener -> listener.onResponse(null),  
                @Override
            DocWriteRequest<IndexRequest> writeRequest2 = new IndexRequest("index").id("id")
    }
        assertThat(response.getIndex(), equalTo("index"));
import org.opensearch.index.translog.Translog;
        final Translog.Location chunkLocation = new Translog.Location(1, 10, 10);
            ASSERTING_DONE_LISTENER  
                assertFalse(refreshCalled.get());  
        assertThat("mappings were \"updated\" once", updateCalled.get(), equalTo(1));
            threadPool::absoluteTimeInMillis,  
        );
            assertThat(primaryResponse2.getId(), equalTo("id"));
        int nItems = randomIntBetween(2, 5);
        assertThat(primaryResponse.getItemId(), equalTo(0));
    }
            new VersionConflictEngineException(shardId, "id", "version conflict")
            createIndexSettings(
        assertThat(response.getResult(), equalTo(DocWriteResponse.Result.NOT_FOUND));  
            listener -> listener.onResponse(null),
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.ClusterSettings;
        when(shard.applyDeleteOperationOnPrimary(anyLong(), any(), any(), any(), anyLong(), anyLong())).thenReturn(
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
                context,  
            mock(RemoteStorePressureService.class),  
            null,
                }, e -> { fail("Post replication actions should not fail: " + e.getMessage()); }));  
        when(shard.indexSettings()).thenReturn(indexSettings);  
        when(allocationId.getId()).thenReturn(aId);
            assertThat(primaryResponse1.getItemId(), equalTo(0));
            );  
            assertThat(primaryResponse1.getResponse().getSeqNo(), equalTo(10L));
        Engine.IndexResult mappingUpdate = new Engine.IndexResult(
        TransportShardBulkAction.executeBulkItemRequest(
        verify(batches.get(1)).finish();
    }  
            threadPool::absoluteTimeInMillis,
        // The cap-triggered chunk append fails inside batch.add during the index operation and the scope stores it...
import static org.mockito.Mockito.eq;
        when(shard.beginTranslogBatch()).thenReturn(batch);
        doAnswer(invocation -> {  
                Collections.singletonMap("field", "value"),  
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };  
        // Assert that the document actually made it there
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
import static org.mockito.ArgumentMatchers.anyInt;
        inOrder.verify(shard).applyDeleteOperationOnPrimary(anyLong(), any(), any(), any(), anyLong(), anyLong());
    public void testNoopUpdateRequest() throws Exception {  
            0,
            mock(ShardStateAction.class),
        assertNull(context.getLocationToSync());
            listener -> {},
        );  
import java.io.IOException;  
     * location; the retry runs on another thread in scope 2, whose finish reports a later location. The request must
import org.opensearch.action.support.replication.TransportReplicationAction.PrimaryResult;  
        inOrder.verify(shard).beginTranslogBatch();
import org.opensearch.index.engine.Engine;
                @Override
import org.opensearch.action.update.UpdateResponse;
            0,
        assertEquals("finished", task.getPhase());
                    observedFailure.set(e);  
        );  
        // Execute bulk operation
        Engine.IndexResult success = new FakeIndexResult(1, 1, 10, true, new Translog.Location(10, 10, 10));  
        assertFalse(primaryResponse.isFailed());
        verify(shard, times(1)).beginTranslogBatch();
            context,  
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenAnswer(
            shard,
        assertEquals(SequenceNumbers.NO_OPS_PERFORMED, ((ReplicaResponse) listener.actionGet()).localCheckpoint());
    }
            new TransportShardBulkAction.PrimaryTermValidationRequest(aId, 1, shardId),  
import org.opensearch.core.transport.TransportResponse;
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();  
    private ClusterService mockClusterService() {
            updateHelper,
            mappingUpdate
import org.opensearch.index.engine.VersionConflictEngineException;
        Engine.IndexResult conflictedResult = new Engine.IndexResult(err, 0);  
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
        );
            threadPool::absoluteTimeInMillis,  
        IndexRequest updateResponse = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");  
            context,  
            context,  
                updateResponse,  
        assertThat(response.getSeqNo(), equalTo(2L));
     * Fake DeleteResult that has a settable translog location  
                    observedFailure.set(e);
     * Transport channel that is needed for replica operation testing.
        assertThat(batches.size(), equalTo(2));  
                    // There should indeed be a mapping update
        TransportShardBulkAction.performOnPrimary(
        BulkShardRequest completedRequest = context.getBulkShardRequest();
import org.opensearch.index.seqno.SequenceNumbers;
            // add a response to the request and thereby check that it is ignored for the primary.  
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);  
    }
                    // Success  
        .put("index.number_of_replicas", 0)
                    new IndexResponse(shardId, "ignore-primary-response-on-primary", 42, 42, 42, false)
     */
        IndexShard shard = mock(IndexShard.class);  
            listener.onResponse(null);
        // Item 0: Successful index operation  
        context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
 * Unless required by applicable law or agreed to in writing,
            new NoopMappingUpdatePerformer(),  
        BulkItemResponse.Failure failure = primaryResponse.getFailure();
    public void testFailureDuringUpdateProcessing() throws Exception {
    public void testHandlePrimaryTermValidationRequestSuccess() {
            verify(shard, times(2)).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
 * compatible open source license.
            when(shard.getFailedIndexResult(any(OpenSearchRejectedExecutionException.class), anyLong())).thenCallRealMethod();
        when(shard.applyDeleteOperationOnPrimary(anyLong(), any(), any(), any(), anyLong(), anyLong())).thenReturn(
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        inOrder.verify(shard).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());  
        TransportShardBulkAction.performOnPrimary(
        );
            shardId,
                primaryResult.runPostReplicationActions(ActionListener.wrap(v -> {
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
        // Mock few of the required classes  
        private final RuntimeException e;  
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
            )  
                }
        assertThat(primaryResponse.getFailureMessage(), containsString("I'm conflicted <(;_;)>"));
        );
        );
                Collections.singletonMap("field", "value"),
            new NoopMappingUpdatePerformer(),
    private final Settings idxSettings = Settings.builder()
        Translog.Location resultLocation = new Translog.Location(42, 42, 42);
 */
        IndexRequest updatedDoc = new IndexRequest("index").id("upd").source(Requests.INDEX_CONTENT_TYPE, "field", "value");
            deferredA,
        when(indexShard.getOperationPrimaryTerm()).thenReturn(primaryTerm);  
        // Translog changes, even though the document didn't exist
        );
        IndexShard shard = mock(IndexShard.class);
        when(shard.indexSettings()).thenReturn(indexSettings);
        IndexShard shard = newStartedShard(true);
        when(batch.finish()).thenThrow(appendFailure);
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        // Create an update request that will fail during preparation  
        UpdateHelper updateHelper = mock(UpdateHelper.class);
     * fails too, the body's exception is what the client sees, with the finish failure attached as suppressed. The
                WritePrimaryResult<BulkShardRequest, BulkShardResponse> primaryResult = (WritePrimaryResult<
     */  
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.INDEX));
    }  
            bulkShardRequest,
        return new TransportShardBulkAction(
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
        AtomicReference<WritePrimaryResult<BulkShardRequest, BulkShardResponse>> primaryResult = new AtomicReference<>();
                    .build()  
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(  
                randomBoolean() ? DocWriteResponse.Result.CREATED : DocWriteResponse.Result.UPDATED,
        items[0] = primaryRequest;  
 * You may obtain a copy of the License at  
                    assertThat(((WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result).location, equalTo(resultLocation1));
                DocWriteResponse.Result.NOOP,  
            }
    }  
                // Run post replication actions  
                primaryRequest.id(),
            } else {
            mock(TransportService.class),  
import static org.mockito.Mockito.doAnswer;  
     */
    public void testUpdateRequestWithFailure() throws Exception {  
            mappingUpdate,
/*
        when(batch.finish()).thenThrow(appendFailure);
        inOrder.verify(batch).finish();  
                @Override
            }), latch),
                .put("thread_pool." + ThreadPool.Names.WRITE + ".size", 1)  
        when(shard.mapperService()).thenReturn(mock(MapperService.class));  
    }
    static class FakeIndexResult extends Engine.IndexResult {
            new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value")  
        IndexShard shard = mock(IndexShard.class);  
    /** Always throw the given exception */
import org.opensearch.index.mapper.MetadataFieldMapper;
        BulkItemRequest itemRequest = new BulkItemRequest(  
        // Deferred index result: no location yet, as the real engines return under batching.
            mock(IndexingPressureService.class),
    }
            request,  
        ClusterService clusterService = mock(ClusterService.class);
        );  
                    BulkShardRequest,
