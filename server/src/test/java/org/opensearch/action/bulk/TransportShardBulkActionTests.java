        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
    public void testNoopUpdateRequest() throws Exception {
                public void onResponse(PrimaryResult<BulkShardRequest, BulkShardResponse> response) {
            task
                }
 * not use this file except in compliance with the License.
     * sync to the later location, and both items must be acknowledged.
                cyclicBarrier.await();
        BulkItemRequest replicaRequest = completedRequest.items()[0];
        DocWriteRequest<IndexRequest> writeRequest = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar");
                return mappingUpdate;
                    BulkShardResponse>) result;
            new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
import org.opensearch.action.support.replication.ReplicationTask;
import org.opensearch.core.action.ActionListener;
            threadPool::absoluteTimeInMillis,
            Settings.EMPTY,
            listener -> {},
        );
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
            success
    /**
        when(shard.beginTranslogBatch()).thenReturn(batch);
    }
        assertEquals(ReplicationMode.PRIMARY_TERM_VALIDATION, action.getReplicationMode(indexShard));
        IndexRequest updateResponse = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");
        Engine.IndexResult successResult1 = new FakeIndexResult(1, 1, 10, true, resultLocation1);
        CountDownLatch latch = new CountDownLatch(1);
        when(shard.shardId()).thenReturn(shardId);
                DocWriteResponse response = primaryResponse.getResponse();
                    BulkShardResponse>) result;
    public void testExecuteBulkDeleteRequest() throws Exception {
        TransportShardBulkAction action = createAction();
        AtomicReference<Translog.Location> synced = new AtomicReference<>();
        primaryRequest = new BulkItemRequest(0, writeRequest);
            listener -> {},
        assertThat(failure.getStatus(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
        }
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            try {
     * roll). Regression test for the review finding on PR #23224.
        );
            new NoopMappingUpdatePerformer(),
        assertThat(primaryResponse.getId(), equalTo("id"));
                        // the finishRequest execution has been force enqueued
    }
        return new TestTransportChannel(listener);
                    completions.incrementAndGet();
                    DocWriteRequest.OpType.INDEX,
            new BulkItemRequest(0, new IndexRequest("index").id("idx").source(Requests.INDEX_CONTENT_TYPE, "field", "value")),
                @Override
    public void testHandlePrimaryTermValidationRequestSuccess() {
        for (int i = 0; i < nItems; i++) {
            return batch;
        assertTrue(primaryResponse.isFailed());
import org.opensearch.index.mapper.Mapping;
        // Pretend the mappings haven't made it to the node yet
import static org.mockito.ArgumentMatchers.anyInt;
                    BulkShardResponse>) result;
        items[0] = primaryRequest;
        assertFalse(context.hasMoreOperationsToExecute());
    private final ShardId shardId = new ShardId("index", "_na_", 0);
import org.opensearch.index.SegmentReplicationPressureService;
        assertThat(response.getIndex(), equalTo("index"));
            when(batch.finish()).thenReturn(loc);
    }
        TransportShardBulkAction action = createAction();
        when(shard.indexSettings()).thenReturn(indexSettings);
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
        BulkItemRequest replicaRequest = completedRequest.items()[0];
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        TransportShardBulkAction.executeBulkItemRequest(
        DocWriteRequest<IndexRequest> writeRequest = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar");
            mock(RemoteStorePressureService.class),
            Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
        DocWriteResponse noopUpdateResponse = new UpdateResponse(shardId, "id", 0, 2, 1, DocWriteResponse.Result.NOOP);
        inOrder.verify(shard).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
     * A batched append that fails while the runnable is yielding for a mapping update must fail the request exactly
            listener -> listener.onResponse(null),
                }
import org.opensearch.cluster.action.shard.ShardStateAction;
                        cyclicBarrier.await();
        // Any version can be matched on replica
                randomFrom(DocWriteRequest.OpType.CREATE, DocWriteRequest.OpType.DELETE, DocWriteRequest.OpType.INDEX),
        final IOException exception = new IOException(failureMessage);
                success2
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }
        );
import static org.mockito.Mockito.when;
        assertThat(context.getLocationToSync(), equalTo(resultLocation));
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
                WritePrimaryResult<BulkShardRequest, BulkShardResponse> primaryResult = (WritePrimaryResult<
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
            new BulkItemRequest(0, new IndexRequest("index").id("idx").source(Requests.INDEX_CONTENT_TYPE, "field", "value")),
            Names.WRITE
                    BulkShardRequest,
        assertNotNull(task.getPhase());
        );
            Names.WRITE
        Translog.Location resultLocation = new Translog.Location(42, 42, 42);
            null,
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
    public void testUpdateRequestWithFailure() throws Exception {
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
            shard,
        // Create an update request that will fail during preparation
        );
            return null;
                }
 * specific language governing permissions and limitations
            if (randomBoolean()) {
                    completedRequest[0] = result.replicaRequest();
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
     * When the request body throws (as a per-operation translog failure does today) and the final-chunk append then
            context,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        }
                assertEquals(nItems, result.replicaRequest().items().length);
                    result -> primaryResult.set((WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result)
        .put("index.number_of_replicas", 0)
import static org.hamcrest.CoreMatchers.not;
        });
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        when(shard.indexSettings()).thenReturn(indexSettings);
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, new BulkItemRequest[] { item });
            listener -> {},
            BulkItemResponse primaryResponse1 = completedRequest[0].items()[0].primaryResponse();
            mappingUpdate,
                .opType(DocWriteRequest.OpType.INDEX);
            request,
        IndexShard shard = mock(IndexShard.class);
import org.opensearch.cluster.metadata.IndexMetadata;
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
        assertFalse(primaryResponse.isFailed());
                new BulkItemResponse.Failure("index", "1", exception, 1L, 1L)
    }
        UpdateHelper updateHelper = mock(UpdateHelper.class);
        Exception err = new VersionConflictEngineException(shardId, "id", "I'm conflicted <(;_;)>");
                @Override
                WritePrimaryResult<BulkShardRequest, BulkShardResponse> primaryResult = (WritePrimaryResult<
            NoopTracer.INSTANCE
        );
                // Verify refresh WAS called
            new TransportShardBulkAction.PrimaryTermValidationRequest(aId, 1, shardId),
        Engine.IndexResult mappingUpdate = new Engine.IndexResult(
     */
        AtomicReference<Exception> observedFailure = new AtomicReference<>();
        completedRequest = secondContext.getBulkShardRequest();
import org.opensearch.action.support.ActionTestUtils;
            Names.WRITE
        List<Engine.TranslogBatch> batches = new CopyOnWriteArrayList<>();
            threadPool,
    }
            Translog.Location loc = batches.isEmpty() ? scope1Location : scope2Location;
            mock(SystemIndices.class),
            mock(RemoteStorePressureService.class),
                    completions.incrementAndGet();
                    // Success
        assertThat(primaryResponse.getItemId(), equalTo(0));
        CountDownLatch latch = new CountDownLatch(1);
    }
import org.opensearch.action.DocWriteResponse;
            shard,
        IndexShard shard = mock(IndexShard.class);
        );
            new ThrowingMappingUpdatePerformer(new RuntimeException("fail")),
        assertNull(secondContext.getLocationToSync());
        when(batch.finish()).thenThrow(finishFailure);
            shard,
            errorOnWait ? listener -> listener.onFailure(err) : listener -> listener.onResponse(null),
        }
            updateHelper,
            shardId,
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
    private class ThrowingMappingUpdatePerformer implements MappingUpdatePerformer {
                primaryResult.runPostReplicationActions(ActionListener.wrap(v -> {
                    assertEquals(VersionConflictEngineException.class, item.primaryResponse().getFailure().getCause().getClass());
        when(shard.shardId()).thenReturn(shardId);
import org.opensearch.core.index.shard.ShardId;
        final VersionConflictEngineException versionConflict = new VersionConflictEngineException(
                updatedDoc,
        boolean errorOnWait = randomBoolean();
        // Execute the bulk operation through performOnPrimary
        BulkItemRequest[] items = new BulkItemRequest[] {
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
        // Assert that the document count is still 1
        IndexRequest updateResponse = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");
            assertEquals(item.primaryResponse().getFailure().getCause().getClass(), VersionConflictEngineException.class);
    }
        @Override
        assertThat(primaryResult.get().location, equalTo(scope2Location));
        boolean created = randomBoolean();
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
        final String failureMessage = "simulated primary failure";
            ASSERTING_DONE_LISTENER
import org.opensearch.action.support.replication.TransportWriteAction.WritePrimaryResult;
import static org.mockito.Mockito.times;
            new FakeIndexResult(1, 1, 10, true, null)
            threadPool::absoluteTimeInMillis,
        List<Engine.TranslogBatch> batches = new CopyOnWriteArrayList<>();
        return primaryRequest;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(closed.getSuppressed(), emptyArray());
        assertThrows(IllegalStateException.class, listener::actionGet);
            }
import java.util.List;
        IndexShard shard = newStartedShard(true);
            new NoopMappingUpdatePerformer(),
import org.opensearch.transport.TransportService;
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
        TransportShardBulkAction.executeBulkItemRequest(
            mock(SystemIndices.class),
                    // Assert that we still need to fsync the location that was successfully written
        );
            latch.countDown();
                    // Success - refresh should not have been called
            bodyFailure
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
import static org.mockito.Mockito.anyBoolean;
            Names.WRITE
     * The real failure path: a failed {@code TranslogBatchScope} stores the append exception and rethrows that very
        verify(batches.get(0)).finish();
        // With the object-store fence enforcing stale-primary fencing on every (request-durability) translog upload,
        inOrder.verify(shard).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
        UpdateHelper updateHelper = mock(UpdateHelper.class);
        );
        );
        assertThat(replicaDeleteRequest.version(), equalTo(Versions.MATCH_ANY));
            new UpdateHelper.Result(
        when(batch.finish()).thenThrow(closed);
        // Track refresh calls
    public void testUpdateWithRetryOnConflict() throws IOException, InterruptedException {
        assertTrue(latch.await(5, TimeUnit.SECONDS));
import java.util.concurrent.atomic.AtomicReference;
                bulkShardRequest,
        when(indexShard.indexSettings()).thenReturn(
            .settings(idxSettings)
     */
        AtomicReference<Exception> observedFailure = new AtomicReference<>();
                }, e -> { fail("Post replication actions should not fail: " + e.getMessage()); }));
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
        BulkItemRequest itemRequest = new BulkItemRequest(
            invocation -> {
import org.opensearch.action.delete.DeleteRequest;
                success1,
                Collections.singletonMap("field", "value"),
        when(shard.applyDeleteOperationOnPrimary(anyLong(), any(), any(), any(), anyLong(), anyLong())).thenReturn(
            threadPool::absoluteTimeInMillis,
        TransportShardBulkAction.performOnPrimary(
        when(shard.indexSettings()).thenReturn(indexSettings);
import java.util.concurrent.atomic.AtomicBoolean;
    public void testHandlePrimaryTermValidationRequestWithOlderPrimaryTerm() {
        // The flush before the delete appends the pending index chunk; finish has nothing left and reports the same
    public void testGetReplicationModeWithRemoteTranslog() {
        );
        when(shard.shardId()).thenReturn(shardId);
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
        // Translog changes, because the document was deleted
        when(updateHelper.prepare(any(), eq(shard), any())).thenThrow(err);
            listener -> listener.onResponse(null),
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
import org.opensearch.indices.SystemIndices;
        // Mock all updates to fail
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
     * threads), and when execution resumes on another thread it must open a brand-new batch via
    public void testGetReplicationModeWithRemoteStoreFencingAndAsyncDurability() {
        assertThat(primaryResponse.getItemId(), equalTo(0));
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
        assertThat(completedRequest.items()[0].request(), equalTo(updateResponse));
        final String aId = "test-allocation-id";
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            null,
        when(shard.indexSettings()).thenReturn(indexSettings);
        when(shard.shardId()).thenReturn(shardId);
                latch
     */
        assertDocCount(shard, 1);
        // Mock few of the required classes
            shard,
                @Override
    }
     * delete's location, otherwise an acknowledged delete can escape the sync (or the remote upload after a generation
        );
public class TransportShardBulkActionTests extends IndexShardTestCase {
    }
     */
            listener -> listener.onResponse(null),
        assertThat(replicaDeleteRequest.versionType(), equalTo(VersionType.INTERNAL));
    }
        when(shard.shardId()).thenReturn(shardId);
            threadPool,
            assertTrue(primaryResponse2.isFailed());
        assertThat(failure.getStatus(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
                updateResponse,
            Names.WRITE
        when(shard.shardId()).thenReturn(shardId);
            null,
        );
import org.opensearch.index.mapper.RootObjectMapper;
            shard,
        assertThat(observedFailure.get(), sameInstance(bodyFailure));
        assertThat(batches.size(), equalTo(2));
        when(shard.indexSettings()).thenReturn(indexSettings);
        });
            secondContext,
            )
            mock(TransportService.class),
            shard,
        }
import java.util.concurrent.CyclicBarrier;
        when(shardRouting.allocationId()).thenReturn(allocationId);
        assertEquals(SequenceNumbers.NO_OPS_PERFORMED, ((ReplicaResponse) listener.actionGet()).globalCheckpoint());
        // The cap-triggered chunk append fails inside batch.add during the index operation and the scope stores it...
                .put("thread_pool." + ThreadPool.Names.WRITE + ".size", 1)
     * would replace an {@link AlreadyClosedException} the coordinator retries on the re-promoted primary with one it
        IndexRequest updateResponse = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");
                Collections.singletonMap("field", "value"),
            new BulkItemRequest(2, new DeleteRequest("index", "del")) };
            TransportShardBulkAction.executeBulkItemRequest(
            logger.debug("Setting retryCount for item {}: {}", i, retryOnConflictCount);
            BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
    /**
    public void testExecuteBulkIndexRequestWithErrorWhileUpdatingMapping() throws Exception {
            new UpdateHelper.Result(
        when(shard.beginTranslogBatch()).thenAnswer(invocation -> {
        Engine.IndexResult mappingUpdate = new Engine.IndexResult(
        assertTrue(primaryResponse.isFailed());
        // Mock successful index operations
            );
            context,
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
                },
    public void testBatchFinishFailureDuringMappingUpdateYieldFailsRequestExactlyOnce() throws Exception {
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
        AllocationId allocationId = mock(AllocationId.class);
        assertThat(failure.getId(), equalTo("id"));
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            successResult1
            new FakeDeleteResult(1, 1, 12, true, new Translog.Location(12, 12, 12))
            assertThat(primaryResponse1.getResponse().getSeqNo(), equalTo(10L));
        when(shard.beginTranslogBatch()).thenAnswer(invocation -> {
        // Check that the translog is successfully advanced
        // Track refresh calls
        final OpenSearchException err = new OpenSearchException("oops");
            new FakeDeleteResult(1, 1, 11, true, deleteLocation)
                updateResponse,
                Settings.builder()
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
    }
     * attached to itself as suppressed ({@code IllegalArgumentException: Self-suppression not permitted}), because that
package org.opensearch.action.bulk;
import java.util.concurrent.CopyOnWriteArrayList;
    }
        }
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenAnswer(ir -> {
        );
                listener -> {},
        when(shard.indexSettings()).thenReturn(indexSettings);
        );
        IndexShard shard = mock(IndexShard.class);
import java.io.IOException;
import static org.hamcrest.Matchers.sameInstance;
        BulkItemResponse.Failure failure = primaryResponse.getFailure();
                Settings.builder()
            new FakeIndexResult(1, 1, 10, true, new Translog.Location(10, 10, 10)),
        IndexShard shard = mock(IndexShard.class);
        latch.await();
                DocWriteResponse.Result.NOOP,
            NoopTracer.INSTANCE
        verify(shard, times(1)).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
     * finish for each scope, with no sleeps - the resume is driven by the mapping-update listener callbacks.
        );
            threadPool::absoluteTimeInMillis,
                    assertNotNull(update);
                new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
            bulkShardRequest,
            threadPool,
        if (randomBoolean()) {
        assertThat(primaryResponse.getItemId(), equalTo(0));
        IndexService indexService = mock(IndexService.class);
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
            // this assertion is based on the assumption that all bulk item requests are updates and are hence calling
                assertThat(primaryResponse.getItemId(), equalTo(0));
                public void onResponse(PrimaryResult<BulkShardRequest, BulkShardResponse> response) {
        TransportShardBulkAction.performOnReplica(bulkShardRequest, shard);
            mock(TransportService.class),
            mock(UpdateHelper.class),
        }
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.IMMEDIATE, items);
import static org.mockito.Mockito.eq;
            mock(ShardStateAction.class),
        items[1] = new BulkItemRequest(1, new UpdateRequest("index", "fail1").doc(Requests.INDEX_CONTENT_TYPE, "field", "value"));
            TransportShardBulkAction.performOnPrimary(
        verify(batch, times(1)).finish();
                }, e -> { fail("Post replication actions should not fail: " + e.getMessage()); }));
import org.opensearch.action.LatchedActionListener;
        inOrder.verify(batch).finish();
            IndexShard shard = mock(IndexShard.class);
        assertFalse(context.hasMoreOperationsToExecute());
            return null;
            new BulkItemRequest(1, new IndexRequest("index").id("b").source(Requests.INDEX_CONTENT_TYPE, "newfield", "baz")) };
                true,
        assertThat(response.getResult(), equalTo(DocWriteResponse.Result.NOT_FOUND));
            new NoopMappingUpdatePerformer(),
                Collections.singletonMap("field", "value"),
        assertFalse(context.hasMoreOperationsToExecute());
                context,
                @Override
    }
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
            items[i] = new BulkItemRequest(i, writeRequest);
        final String aId = "test-allocation-id";
 * Modifications Copyright OpenSearch Contributors. See
            mock(RemoteStorePressureService.class),
            new NoopMappingUpdatePerformer(),
        assertThat(response.getShardId(), equalTo(shard.shardId()));
    }
        assertEquals("failed", task.getPhase());
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
        BulkItemRequest[] items = new BulkItemRequest[] {
                any(IndexShard.class),
                randomBoolean() ? DocWriteResponse.Result.CREATED : DocWriteResponse.Result.UPDATED,
            listener -> listener.onResponse(null),
        BulkShardRequest completedRequest = context.getBulkShardRequest();
        when(shard.indexSettings()).thenReturn(indexSettings);
        assertThat(failure.getIndex(), equalTo("index"));
        assertTrue(primaryResponse.isFailed());
            Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
    public void testInlineDeleteAfterLastBatchFlushWinsOverOlderFinishLocation() throws Exception {
            mock(ActionFilters.class),
        UpdateHelper updateHelper = mock(UpdateHelper.class);
            success
            request,
            mock(MappingUpdatedAction.class),
        BulkItemRequest[] items = new BulkItemRequest[] {
                updateResponse,
import org.apache.lucene.store.AlreadyClosedException;
                Collections.singletonMap("field", "value"),
                    BulkShardRequest,
            new NoopMappingUpdatePerformer(),
        TransportShardBulkAction.executeBulkItemRequest(
    public void testGetReplicationModeWithRemoteStoreFencing() {
                Requests.INDEX_CONTENT_TYPE
        DeleteResponse response = primaryResponse.getResponse();
            return batch;
            listener.onResponse(null);
            shard,
        }
                Requests.INDEX_CONTENT_TYPE
            threadPool::absoluteTimeInMillis,
        when(batch.flush()).thenReturn(chunkLocation);
            // Place a task in the queue to block next enqueue
            threadPool::absoluteTimeInMillis,
        InOrder inOrder = inOrder(shard, batch);
        );
            threadPool::absoluteTimeInMillis,
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
     * the greatest location the batch itself appended, which is older than the delete. The request must sync to the
        when(batch.finish()).thenThrow(appendFailure);
        assertThat(response.getSeqNo(), equalTo(0L));
                    .build()
            new TransportShardBulkAction.PrimaryTermValidationRequest(aId, 1, shardId),
        assertThat(response.forcedRefresh(), equalTo(false));
            }
            assertThat(primaryResponse1.getOpType(), equalTo(DocWriteRequest.OpType.INDEX));
        assertNotNull(task.getPhase());
        Exception err = new VersionConflictEngineException(shardId, "id", "I'm conflicted <(;_;)>");
        indexDoc(shard, "_doc", "id", "{}");
                Requests.INDEX_CONTENT_TYPE
        // Item 2: Successful index operation
import org.opensearch.threadpool.ThreadPool.Names;
            new NoopMappingUpdatePerformer(),
            Names.WRITE
        // if we sync the location, nothing else is unsynced
            0,
            );
        // Create a mix of successful and failed operations
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            0,
        InOrder inOrder = inOrder(shard, batch);
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
                }), latch),
            Names.WRITE
            new BulkItemRequest(0, new IndexRequest("index").id("a").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar")),
    }
                }
                @Override
            }), latch),
            listener -> {},
            mock(SystemIndices.class),
        // Since this was not a conflict failure, the primary response
        for (BulkItemRequest item : primaryResult.get().replicaRequest().items()) {
        }).when(shard).refresh(any());
    public void testNoOpReplicationOnPrimaryDocumentFailure() throws Exception {
        BulkItemResponse.Failure failure = primaryResponse.getFailure();
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
 * this work for additional information regarding copyright
        );
            mock(UpdateHelper.class),
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
     * batch scope must be finalized with {@link Engine.TranslogBatch#finish()} (so a pending chunk never crosses
        );
        );
            this.location = location;
            when(shard.getFailedIndexResult(any(OpenSearchRejectedExecutionException.class), anyLong())).thenCallRealMethod();
        assertThat(primaryResponse.getId(), equalTo("id"));
                    BulkShardRequest,
import org.opensearch.index.remote.RemoteStorePressureService;
            task
            mock(UpdateHelper.class),
                }
        assertThat(context.getLocationToSync(), not(location));
        when(shard.shardId()).thenReturn(shardId);
import org.opensearch.index.IndexingPressureService;
            null,
                primaryResult.runPostReplicationActions(ActionListener.wrap(v -> {
        );
            new NoopMappingUpdatePerformer(),
    /**
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
        final IndexShard indexShard = mock(IndexShard.class);
    /**
        assertFalse(context.hasMoreOperationsToExecute());
        );
        assertEquals(primaryRequest.index(), replicaRequest.index());
                    fail("request must not be acknowledged");
import org.opensearch.common.lucene.uid.Versions;
        AtomicBoolean refreshCalled = new AtomicBoolean(false);
    }
                assertThat(response.getSeqNo(), equalTo(13L));
    public void testFailureDuringUpdateProcessing() throws Exception {
            // There should indeed be a mapping update
            new LatchedActionListener<>(
        protected FakeDeleteResult(long version, long term, long seqNo, boolean found, Translog.Location location) {
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        );
        assertTrue(listener.actionGet() instanceof ReplicaResponse);
        assertThat(primaryResponse.getFailureMessage(), containsString("oops"));
            UpdateRequest updateRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value")
            null,
        replicaDeleteRequest = replicaRequest.request();
                randomBoolean() ? DocWriteResponse.Result.CREATED : DocWriteResponse.Result.UPDATED,
 * Unless required by applicable law or agreed to in writing,
            new NoopMappingUpdatePerformer(),
            } catch (Exception e) {
        );
            new IndexRequest("index").source(Requests.INDEX_CONTENT_TYPE),
        // should be filled out with the failure information
    }
        assertThat(response.getVersion(), equalTo(1L));
        when(shard.beginTranslogBatch()).thenReturn(batch);
            updateHelper,
        TransportShardBulkAction.executeBulkItemRequest(
        verify(batches.get(1)).finish();
            shard,
            "TransportShardBulkActionTests#testForceExecutionOnRejectionAfterMappingUpdate",
        assertThat(primaryResponse.getItemId(), equalTo(0));
            batches.add(batch);
        final ReplicationTask task = createReplicationTask();
        doAnswer(invocation -> {
        latch.await();
        items[0] = primaryRequest;
                // Run post replication actions
import static org.hamcrest.Matchers.containsString;
            )
        assertThat(response.status(), equalTo(RestStatus.OK));
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
                .source(Requests.INDEX_CONTENT_TYPE)
            latch.await();
        IndexShard shard = mock(IndexShard.class);
            .primaryTerm(0, 1)
            "version conflict during update preparation"
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
                mappingUpdate,
        public Translog.Location getTranslogLocation() {
    /**
import org.opensearch.action.support.replication.TransportReplicationAction.PrimaryResult;
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenAnswer(
                    // There should indeed be a mapping update
            ASSERTING_DONE_LISTENER
import org.opensearch.index.engine.VersionConflictEngineException;
                public void onFailure(final Exception e) {
                )
        UpdateHelper updateHelper = mock(UpdateHelper.class);
import org.opensearch.index.shard.IndexShardTestCase;
    public void testBulkRequestWithMixedSuccessAndFailureRefresh() throws Exception {
    }
            threadPool::absoluteTimeInMillis,
        assertThat(context.getLocationToSync(), nullValue());
        Engine.IndexResult indexResult = new Engine.IndexResult(err, 0, 0, 0);
            threadPool::absoluteTimeInMillis,
                }
            threadPool,
        BulkShardRequest completedRequest = context.getBulkShardRequest();
            updateHelper,
            context,
        assertThat(primaryResponse.getItemId(), equalTo(0));
            mock(UpdateHelper.class),
        when(shard.indexSettings()).thenReturn(indexSettings);
        }
            items[0] = new BulkItemRequest(0, writeRequest1);
     */
            threadPool::absoluteTimeInMillis,
                latch
            threadPool,
            ASSERTING_DONE_LISTENER
        BulkItemRequest[] items = new BulkItemRequest[randomIntBetween(2, 5)];
                eq(updateRequest),
            new NoopMappingUpdatePerformer(),
import org.opensearch.cluster.action.index.MappingUpdatedAction;
            }, latch)
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        DocWriteResponse response = primaryResponse.getResponse();
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            context,
            mock(SegmentReplicationPressureService.class),
        final ShardId shardId = new ShardId("test", "_na_", 0);
        // Item 1: Failed update operation
     * precedes the delete. The delete is then written inline at a later location, and {@code finish()} reports only
                Collections.singletonMap("field", "value"),
            bulkShardRequest,
    public void testMappingUpdateMidBatchSyncsToLaterScopeLocation() throws Exception {
    public void testUpdateRequestWithConflictFailure() throws Exception {
import org.opensearch.index.engine.Engine;
        items[0] = randomlySetIgnoredPrimaryResponse(items[0]);
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.IMMEDIATE, items);
            }), latch),
                        // Release blocking task now that the continue write execution has been rejected and
            assertThat(primaryResponse1.getId(), equalTo("id"));
        // Translog changes, even though the document didn't exist
            items.add(new BulkItemRequest(i, updateRequest));
import org.opensearch.index.IndexService;
        assertThat(response.getId(), equalTo("id"));
        items[0] = new BulkItemRequest(0, new IndexRequest("index").id("success1").source(Requests.INDEX_CONTENT_TYPE, "field", "value"));
            new LatchedActionListener<>(new ActionListener<Void>() {
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
     * would fail the request and the re-execution would then complete it a second time.
        DocWriteRequest<IndexRequest> writeRequest = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE).create(create);
        );
        IndexShard shard = mock(IndexShard.class);
        doAnswer(invocation -> {
        }
        assertThat(failure.getId(), equalTo("id"));
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
        IndexRequest updatedDoc = new IndexRequest("index").id("upd").source(Requests.INDEX_CONTENT_TYPE, "field", "value");
 * the Apache License, Version 2.0 (the "License"); you may
            request,
        BulkItemResponse primaryResponse = replicaRequest.primaryResponse();
                assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
import static org.mockito.Mockito.inOrder;
            assertThat(primaryResponse2.getId(), equalTo("id"));
        AtomicReference<Exception> observedFailure = new AtomicReference<>();
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
        assertThat(failure.getCause(), equalTo(err));
        Engine.IndexResult success = new FakeIndexResult(1, 1, 10, true, new Translog.Location(10, 10, 10));
        IndexShard indexShard = mock(IndexShard.class);
            DocWriteRequest<IndexRequest> writeRequest2 = new IndexRequest("index").id("id")
        }, listener -> listener.onResponse(null), ASSERTING_DONE_LISTENER);
        @Override
                        throw new IllegalStateException(e);
                    latch.countDown();
        when(shard.indexSettings()).thenReturn(indexSettings);
        when(batch.finish()).thenThrow(appendFailure);
        when(shard.mapperService()).thenReturn(mock(MapperService.class));
        when(shard.beginTranslogBatch()).thenReturn(batch);
        AtomicReference<Exception> observedFailure = new AtomicReference<>();
            mock(ShardStateAction.class),
            Settings.EMPTY,
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
import org.opensearch.action.support.ActionFilters;
        BulkItemRequest[] items = new BulkItemRequest[3];
     * fails too, the body's exception is what the client sees, with the finish failure attached as suppressed. The
    private BulkItemRequest randomlySetIgnoredPrimaryResponse(BulkItemRequest primaryRequest) {
        assertThat(primaryResponse.getId(), equalTo("id"));
    }
        BulkShardRequest[] completedRequest = new BulkShardRequest[1];
        );
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        });
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
        assertThat(primaryResponse.getId(), equalTo("id"));
            createTransportChannel(listener),
        );
        assertThat(primaryResponse.getItemId(), equalTo(0));
            ASSERTING_DONE_LISTENER
            when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
                throw new AssertionError(e);
        assertThat(replicaDeleteRequest.versionType(), equalTo(VersionType.INTERNAL));
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
        when(shard.shardId()).thenReturn(shardId);
                public void onFailure(Exception e) {
            new VersionConflictEngineException(shardId, "id", "version conflict")
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
        );
        assertThat(failure.getCause().getMessage(), containsString("version conflict, document already exists (current version [1])"));
        // Create successful operations
                logger.info("blocking the write executor");
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, new BulkItemRequest[] { item });
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
        assertThat(failure.getCause(), equalTo(err));
import org.opensearch.action.update.UpdateHelper;
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
            beginThreads.add(Thread.currentThread().getName());
        boolean found = randomBoolean();
                public void onFailure(Exception e) {
        TransportShardBulkAction.performOnPrimary(
        // Since this was not a conflict failure, the primary response
            }), latch),
        // replicas come off the write path entirely - no primary term validation fanout.
            null,
        IndexShard shard = mock(IndexShard.class);
            new NoopMappingUpdatePerformer(),
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.DELETE));
        when(shard.beginTranslogBatch()).thenReturn(batch);
                Collections.singletonMap("field", "value"),
        );
                Requests.INDEX_CONTENT_TYPE
 * compatible open source license.
        assertTrue(context.hasMoreOperationsToExecute());
        assertThat(primaryResponse.getFailureMessage(), containsString("some kind of exception"));
            mock(ActionFilters.class),
                .retryOnConflict(retryOnConflictCount);
    }
        assertFalse(context.hasMoreOperationsToExecute());
        Engine.IndexResult successResult2 = new FakeIndexResult(1, 1, 12, true, resultLocation2);
        // First attempt requires a mapping update (yield), the retry after the update succeeds.
        assertThat(primaryResponse.getId(), equalTo("id"));
        completedRequest = context.getBulkShardRequest();
        assertThat(failure.getIndex(), equalTo("index"));
        CountDownLatch latch = new CountDownLatch(1);
        assertThat(response.getSeqNo(), equalTo(resultSeqNo));
        assertThat(response.getShardId(), equalTo(shard.shardId()));
        assertNull(context.getLocationToSync());
import org.opensearch.index.translog.TranslogException;
        when(shard.mapperService()).thenReturn(mock(MapperService.class));
        UpdateHelper updateHelper = mock(UpdateHelper.class);
        when(shard.shardId()).thenReturn(shardId);
        inOrder.verify(batch).finish();
import org.opensearch.Version;
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
import org.opensearch.core.transport.TransportResponse;
            new BulkItemRequest(0, new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar")) };
            new UpdateHelper.Result(
        // Basically nothing changes in the request since it's a noop
        );
            ASSERTING_DONE_LISTENER
import org.opensearch.index.seqno.SequenceNumbers;
                @Override
        private final Translog.Location location;
                    fail("request must not be acknowledged after a batched translog append failure");
            mock(SegmentReplicationPressureService.class),
            threadPool::absoluteTimeInMillis,
        DeleteRequest updateResponse = new DeleteRequest("index", "id");
        final Translog.Location scope2Location = new Translog.Location(1, 30, 10);
        // Each doRun() invocation opens a fresh batch; hand out a distinct mock per begin call and record the calling
            )
        items[0] = new BulkItemRequest(0, writeRequest);
        assertThat(failure.getCause(), equalTo(err));
import static org.mockito.Mockito.anyLong;
        // Verify that the shard "executed" the operation once
import org.opensearch.threadpool.TestThreadPool;
        );
        ThrowingMappingUpdatePerformer(RuntimeException e) {
 *
        TransportShardBulkAction.performOnPrimary(
        assertThat(failure.getIndex(), equalTo("index"));
            ASSERTING_DONE_LISTENER
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenThrow(closed);
     * once. The mapping-update continuation re-executes the runnable; without deferring, the yield-time finish failure
        Translog.Location resultLocation = new Translog.Location(42, 42, 42);
                WritePrimaryResult<BulkShardRequest, BulkShardResponse> primaryResult = (WritePrimaryResult<
        try {
        // Update is applied as an index op after UpdateHelper.prepare; distinguish it from the delete via the result.
        // Since this was not a conflict failure, the primary response
                ),
                assertTrue(refreshCalled.get());
     * scope 1, the second needs a mapping update, so scope 1 is finished before the yield and reports its chunk
        .build();
        IndexShard shard = mock(IndexShard.class);
import org.opensearch.index.engine.EngineException;
            new BulkItemRequest(0, new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", "bar")) };
        final ReplicationTask task = createReplicationTask();
        // the update is executed as an index operation on the shard
                // Verify refresh was NOT called
    }
        return IndexMetadata.builder("index")
    }
            bulkShardRequest,
        UpdateHelper updateHelper = mock(UpdateHelper.class);
            Translog.Location resultLocation2 = new Translog.Location(42, 42, 42);
     */
        // Mock the UpdateHelper to throw a version conflict exception during preparation
            shard,
                }
            assertThat(primaryResponse1.getResponse().status(), equalTo(RestStatus.CREATED));
        verify(shard, times(2)).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
        assertThat(primaryResponse.getItemId(), equalTo(0));
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
        assertThat(primaryResponse.getId(), equalTo("id"));
            assertThat("mappings were \"updated\" once", updateCalled.get(), equalTo(1));
        inOrder.verify(batch).flush();
                    BulkShardResponse>) result;
        TransportShardBulkAction.executeBulkItemRequest(
            threadPool,
        when(shard.applyDeleteOperationOnPrimary(anyLong(), any(), any(), any(), anyLong(), anyLong())).thenReturn(
            createIndexSettings(false, Settings.builder().put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true).build())
        assertThat(primaryResponse.getId(), equalTo("id"));
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
            listener -> {},
        while (context.hasMoreOperationsToExecute()) {
        );
        when(updateHelper.prepare(any(), eq(shard), any())).thenThrow(
 * The OpenSearch Contributors require contributions made to
        TransportShardBulkAction.performOnPrimary(
import org.opensearch.index.shard.ShardNotFoundException;
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
            listener -> listener.onResponse(null),
                for (BulkItemRequest item : result.replicaRequest().items()) {
    }
            new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
                0,
                completedRequest[0] = result.replicaRequest();
                .source(Requests.INDEX_CONTENT_TYPE, "foo", "bar");
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
     * Transport channel that is needed for replica operation testing.
            mock(SegmentReplicationPressureService.class),
     * Fake IndexResult that has a settable translog location
    /** Doesn't perform any mapping updates */
        final ShardId shardId = new ShardId("test", "_na_", 0);
    /**
        Engine.IndexResult success = new FakeIndexResult(1, 1, 13, true, resultLocation);
        CountDownLatch latch = new CountDownLatch(1);
        assertThat(primaryResponse.getItemId(), equalTo(0));
            when(shard.shardId()).thenReturn(shardId);
            errorOnWait == false ? new ThrowingMappingUpdatePerformer(err) : new NoopMappingUpdatePerformer(),
                    0,
                assertNull(primaryResult.location);
        );
        // Verify that the shard "executed" the operation only once (1 for previous invocations plus
    public void testSuccessfulBulkOperationStillTriggersRefresh() throws Exception {
     * interleaving of {@link Engine.TranslogBatch#flush()} with the shard apply calls using a single {@link InOrder}
    public void testExecuteBulkIndexRequest() throws Exception {
                WritePrimaryResult<BulkShardRequest, BulkShardResponse> primaryResult = (WritePrimaryResult<
 * SPDX-License-Identifier: Apache-2.0
        primaryResponse = replicaRequest.primaryResponse();
            assertThat(primaryResponse2.getItemId(), equalTo(1));
            mockIndicesService(aId, 2L),
        doAnswer(invocation -> {
            listener -> listener.onResponse(null),
            mock(ActionFilters.class),
        );
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
        BulkItemRequest[] items = new BulkItemRequest[1];
        // A single ordered verification across both mocks proves the interleaving:
        when(shard.shardId()).thenReturn(shardId);
                assertFalse(refreshCalled.get());
            context,
        assertBusy(() -> assertThat(completions.get(), equalTo(1)));
        int nItems = randomIntBetween(2, 5);
    public void testRetries() throws Exception {
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
            listener -> listener.onResponse(null),
                any(LongSupplier.class)
        CountDownLatch latch = new CountDownLatch(1);
        verify(shard, times(1)).markSeqNoAsNoop(1, 1, exception.toString());
        );
        IndexShard shard = mock(IndexShard.class);
        when(shard.indexSettings()).thenReturn(indexSettings);
            );
        // Mock failed update operation
            DocWriteRequest<IndexRequest> writeRequest1 = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "foo", 1);
 * license agreements. See the NOTICE file distributed with
        assertTrue(primaryResponse.isFailed());
            return new BulkItemRequest(
            new NoopMappingUpdatePerformer(),
            listener.onResponse(null);
                throw new RuntimeException(e);
    }
    public void testBatchFinishFailureDoesNotMaskBodyFailure() throws Exception {
        inOrder.verify(shard).applyDeleteOperationOnPrimary(anyLong(), any(), any(), any(), anyLong(), anyLong());
            threadPool,
import java.util.concurrent.TimeUnit;
        TransportShardBulkAction action = new TransportShardBulkAction(
        BulkShardRequest completedRequest = context.getBulkShardRequest();
            items[1] = new BulkItemRequest(1, writeRequest2);
        context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        );
     * Dynamic mapping update in the middle of a batched bulk: the first document is deferred (null location) into
        verify(batch, times(1)).finish();
            listener -> {},
        Engine.IndexResult conflictedResult = new Engine.IndexResult(err, 0);
        when(shard.shardId()).thenReturn(shardId);
            Names.WRITE
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
            )
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
        final IndexShard indexShard = mock(IndexShard.class);
        BulkShardRequest completedRequest = context.getBulkShardRequest();
        TransportShardBulkAction.performOnPrimary(
        Engine.IndexResult mappingUpdate = new Engine.IndexResult(
            listener -> listener.onResponse(null),
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            threadPool::absoluteTimeInMillis,
        TransportShardBulkAction.executeBulkItemRequest(
            shard,
        inOrder.verify(shard).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
            new LatchedActionListener<>(
                    updateCalled.incrementAndGet();
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
        assertThat(failure.getStatus(), equalTo(RestStatus.CONFLICT));
            if (e != null) {
        assertThat(observedFailure.get(), equalTo(appendFailure));
        when(shard.beginTranslogBatch()).thenReturn(batch);
        // should be filled out with the failure information
     * finally-block finish must not replace it.
import org.opensearch.action.support.TransportActions;
import static org.mockito.Mockito.spy;
                ASSERTING_DONE_LISTENER
        assertEquals(primaryRequest.request(), replicaRequest.request());
                    }
            listener -> listener.onResponse(null),
        IndexShard shard = mock(IndexShard.class);
     * A batched index result carries no translog location when it is recorded; its chunk is appended by the flush that
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        return new ReplicationTask(0, null, null, null, null, null);
import static org.mockito.Mockito.mock;
            mockIndicesService(aId, 1L),
            }), latch),
                    // Success
            Names.WRITE
            listener -> listener.onResponse(null),
import org.opensearch.cluster.routing.ShardRouting;
    private TransportShardBulkAction createAction() {
            updateHelper,
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
    /**
            mockClusterService(),
        AtomicReference<WritePrimaryResult<BulkShardRequest, BulkShardResponse>> primaryResult = new AtomicReference<>();
                    assertThat(((WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result).location, equalTo(resultLocation1));
        CountDownLatch latch = new CountDownLatch(1);
import static org.mockito.Mockito.any;
    static class FakeIndexResult extends Engine.IndexResult {
            } else {
    }
            mock(MappingUpdatedAction.class),
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.DELETE));
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.INDEX));
        when(shard.indexSettings()).thenReturn(indexSettings);
            new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value")
        );
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
        }
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
            (update, shardId, listener) -> fail("should not have had to update the mappings"),
        );
        verify(batch, times(1)).finish();
            request,
        );
            mappingUpdate
        TransportShardBulkAction.executeBulkItemRequest(
        assertThat(primaryResponse.getOpType(), equalTo(writeRequest.opType()));
                Collections.singletonMap("field", "value"),
                // Should have a location since some operations succeeded
        items[0] = randomlySetIgnoredPrimaryResponse(items[0]);
            mappingUpdate,
        public void updateMappings(Mapping update, ShardId shardId, ActionListener<Void> listener) {
        CountDownLatch latch = new CountDownLatch(1);
    public void testTranslogPositionToSync() throws Exception {
        assertThat(primaryResponse.getId(), equalTo("id"));
                    observedFailure.set(e);
import org.opensearch.core.rest.RestStatus;
            task
                updateResponse,
            shard,
        items[0] = new BulkItemRequest(0, new IndexRequest("index").id("id1").source(Requests.INDEX_CONTENT_TYPE, "field", "value1"));
        final Translog.Location chunkLocation = new Translog.Location(1, 10, 10);
            Names.WRITE
import java.util.concurrent.atomic.AtomicInteger;
        TransportShardBulkAction action = createAction();
                return new FakeIndexResult(1, 1, loc, true, new Translog.Location(loc, loc, loc));
    public void testBulkRequestWithAllFailedUpdatesNoRefresh() throws Exception {
            );
        protected FakeIndexResult(long version, long term, long seqNo, boolean created, Translog.Location location) {
        } finally {
        // Any version can be matched on replica
                DocWriteResponse.Result.UPDATED,
            Engine.IndexResult success1 = new FakeIndexResult(1, 1, 10, true, resultLocation1);
    public void testGetReplicationModeWithFencingOnNonRemoteIndex() {
    }
        final IndexShard indexShard = mock(IndexShard.class);
        // must be preceded by a flush of the pending index chunk.
     * instance from {@code finish()}, so the body failure and the finish failure are the same object. It must not be
}
            mock(IndicesService.class),
    }
        BulkShardRequest completedRequest = context.getBulkShardRequest();
import org.opensearch.action.index.IndexRequest;
     * {@link IndexShard#beginTranslogBatch()}. This verifies two distinct begin calls on two distinct threads and a
        when(indexService.getShard(anyInt())).thenReturn(indexShard);
        Engine.IndexResult mappingUpdate = new Engine.IndexResult(
            mock(TransportService.class),
        .put("index.number_of_shards", 1)
        writeRequest = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE).create(true);
            listener -> {},
        UpdateRequest writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
     * update/delete can never be ordered ahead of an index operation it logically follows. This asserts the exact
        when(shard.mapperService()).thenReturn(mock(MapperService.class));
        );
            0,
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
            }), latch),
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
        );
            super(version, term, seqNo, created);
        assertThat(Arrays.asList(bodyFailure.getSuppressed()), contains(sameInstance(finishFailure)));
            when(shard.mapperService()).thenReturn(mock(MapperService.class));
            .build();
        assertThat(response.getSeqNo(), equalTo(2L));
        Engine.IndexResult deferredB = new FakeIndexResult(1, 1, 1, true, null);
                ActionTestUtils.assertNoFailureListener(
                // Run post replication actions
            request,
        assertThat(beginThreads.get(1), not(equalTo(beginThreads.get(0))));
            }
    }
        assertTrue(primaryResponse.isFailed());
        CountDownLatch latch = new CountDownLatch(1);
        );
            context,
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenThrow(
            context,
        writeRequest = new DeleteRequest("index", "id");
            request,
                    new IndexResponse(shardId, "ignore-primary-response-on-primary", 42, 42, 42, false)
                // Verify refresh WAS called because there were successful writes
                Names.WRITE
        when(shard.indexSettings()).thenReturn(indexSettings);
            bulkShardRequest,
        DocWriteRequest<DeleteRequest> writeRequest = new DeleteRequest("index", "id");
        IndexShard shard = newStartedShard(true);
            Settings.EMPTY,
        );
                Requests.INDEX_CONTENT_TYPE
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        // Mock successful operations
            shard,
                rejectingThreadPool::absoluteTimeInMillis,
        boolean create = randomBoolean();
            refreshCalled.set(true);
            verify(updateHelper, times(updateRequest.retryOnConflict() + 1)).prepare(
        assertFalse(context.hasMoreOperationsToExecute());
        assertEquals(primaryRequest.id(), replicaRequest.id());
        BulkItemRequest[] items = new BulkItemRequest[1];
    }
        ).thenReturn(successResult2);
            threadPool::absoluteTimeInMillis,
        );
                // Verify no location to sync (no writes occurred)
        verify(batches.get(1)).finish();
        closeShards(shard);
            null,
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
                    fail("request must not be acknowledged");
        IndexShard shard = newStartedShard(true);
            listener -> listener.onResponse(null),
            threadPool,
        items[0] = randomlySetIgnoredPrimaryResponse(items[0]);
            new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        // The first scope was finalized before the yield, and the resumed scope was finalized at completion.
        when(shard.shardId()).thenReturn(shardId);
import org.opensearch.common.settings.ClusterSettings;
            "id",
        Translog.Location resultLocation = new Translog.Location(42, 42, 42);
        AtomicBoolean refreshCalled = new AtomicBoolean(false);
            NoopTracer.INSTANCE
    public void testUpdateWithDelete() throws Exception {
        when(shard.shardId()).thenReturn(shardId);
        Engine.IndexResult deferredA = new FakeIndexResult(1, 1, 0, true, null);
        );
        // scope was detached and did not cross threads.
        IndexShard shard = mock(IndexShard.class);
        assertThat(primaryResponse.getFailureMessage(), containsString("I'm dead <(x.x)>"));
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
            createTransportChannel(listener),
        bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        Translog.Location resultLocation1 = new Translog.Location(42, 42, 42);
            assertNotNull(update);
        CountDownLatch latch = new CountDownLatch(1);
        );
            new BulkItemRequest(1, new DeleteRequest("index", "del")) };
    private final Settings idxSettings = Settings.builder()
            updateHelper,
        );
        assertFalse(primaryResponse.isFailed());
            ASSERTING_DONE_LISTENER
        BulkItemRequest[] items = new BulkItemRequest[1];
            BulkItemResponse primaryResponse2 = completedRequest[0].items()[1].primaryResponse();
        IndexShard shard = mock(IndexShard.class);
                    observedFailure.set(e);
        final CountDownLatch latch = new CountDownLatch(1);
                }
        }).when(shard).refresh(any());
        );
 * ownership. Elasticsearch licenses this file to you under
            threadPool,
            )
        }
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
        assertFalse(primaryResponse.isFailed());
            threadPool::absoluteTimeInMillis,
     */
        );
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
                rejectingThreadPool,
        closeShards(shard);
            new ActionListener<>() {
        action.handlePrimaryTermValidationRequest(
                // Run post replication actions
    private ClusterService mockClusterService() {
            new BulkItemRequest(1, new UpdateRequest("index", "upd").doc(Requests.INDEX_CONTENT_TYPE, "field", "value")),
        Translog.Location location = new Translog.Location(0, 0, 0);
import static org.hamcrest.CoreMatchers.equalTo;
        assertThat(response.forcedRefresh(), equalTo(false));
        assertThat(observedFailure.get(), sameInstance(closed));
        ShardRouting shardRouting = mock(ShardRouting.class);
        AtomicInteger updateCalled = new AtomicInteger();
        }
            this.e = e;
        // Deferred index result: no location yet, as the real engines return under batching.
            new NoopMappingUpdatePerformer(),
import static org.hamcrest.Matchers.nullValue;
            Names.WRITE
                primaryResult.runPostReplicationActions(ActionListener.wrap(v -> {
                return success;
        // (older) greatest batch location.
            mappingUpdate
        return new TransportShardBulkAction(
 * KIND, either express or implied.  See the License for the
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {}), latch),
    private TransportChannel createTransportChannel(final PlainActionFuture<TransportResponse> listener) {
        when(shard.indexSettings()).thenReturn(indexSettings);
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
            );
            assertThat(primaryResponse2.getFailure().getCause(), instanceOf(OpenSearchRejectedExecutionException.class));
            new NoopMappingUpdatePerformer(),
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
                primaryRequest.id(),
        DocWriteRequest<?> replicaDeleteRequest = replicaRequest.request();
            new VersionConflictEngineException(shardId, "fail1", "version conflict")
        for (int i = 0; i < items.length; i++) {
            }, latch),
            )
        new Thread(runnable).start();
                "{\"properties\":{\"foo\":{\"type\":\"text\",\"fields\":" + "{\"keyword\":{\"type\":\"keyword\",\"ignore_above\":256}}}}}"
        replicaRequest = completedRequest.items()[0];
        verify(shard, times(2)).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
            threadPool::absoluteTimeInMillis,
        TestThreadPool rejectingThreadPool = new TestThreadPool(
            refreshCalled.set(true);
        DocWriteResponse response = primaryResponse.getResponse();
        when(shard.beginTranslogBatch()).thenReturn(batch);
                }, e -> { fail("Post replication actions should not fail: " + e.getMessage()); }));
                updateResponse,
        action.handlePrimaryTermValidationRequest(
        BulkShardRequest completedRequest = context.getBulkShardRequest();
        assertThat(response.getVersion(), equalTo(3L));
            new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value")
                    // Success
                assertFalse(refreshCalled.get());
            // resume synchronously via the listener, as the real cluster-state observer would on another thread
        assertNotNull(context.getLocationToSync());
        verify(shard, times(1)).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
            ),
    }
            mock(MappingUpdatedAction.class),
        when(batch.finish()).thenReturn(chunkLocation);
                    .build()
        assertThat(primaryResponse.getItemId(), equalTo(0));
        assertFalse(context.hasMoreOperationsToExecute());
            null,
import org.opensearch.cluster.service.ClusterService;
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }
                @Override
            Translog.Location resultLocation1 = new Translog.Location(42, 36, 36);
            int retryOnConflictCount = randomIntBetween(0, 3);
                created ? DocWriteResponse.Result.CREATED : DocWriteResponse.Result.UPDATED,
import org.opensearch.common.settings.Settings;
                    } catch (InterruptedException | BrokenBarrierException e) {
    }
     */
        // the first scope was finished (and failed) at the yield; the re-execution surfaced the failure before opening another
        BulkShardRequest completedRequest = context.getBulkShardRequest();
            createTransportChannel(listener),
 * under the License.
            AtomicInteger updateCalled = new AtomicInteger();
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
        UpdateHelper updateHelper = mock(UpdateHelper.class);
                null,
            threadPool::absoluteTimeInMillis,
            indexResult
            verify(shard, times(2)).applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean());
        }).when(shard).refresh(any());
            return this.location;
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
            threadPool,
        IndexShard shard = mock(IndexShard.class);
        action.handlePrimaryTermValidationRequest(
                public void onFailure(Exception e) {
        Engine.IndexResult indexResult = new FakeIndexResult(1, 1, 13, created, resultLocation);
            NoopTracer.INSTANCE
        items[1] = new BulkItemRequest(1, new IndexRequest("index").id("id2").source(Requests.INDEX_CONTENT_TYPE, "field", "value2"));
        TransportShardBulkAction.executeBulkItemRequest(
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
import org.opensearch.index.IndexSettings;
        public Translog.Location getTranslogLocation() {
        final IndexShard shard = spy(newStartedShard(false));
        // Check that the translog is successfully advanced
            new NoopMappingUpdatePerformer(),
     */
            threadPool,
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
        // Create bulk request with IMMEDIATE refresh policy
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            assertThat(primaryResponse2.getOpType(), equalTo(DocWriteRequest.OpType.INDEX));
            items[0] = randomlySetIgnoredPrimaryResponse(items[0]);
import org.opensearch.transport.TestTransportChannel;
import org.opensearch.action.update.UpdateResponse;
        assertEquals("finished", task.getPhase());
            listener -> listener.onResponse(null),
        // Item 0: Successful index operation
        assertThat(primaryResponse.getResponse().getResult(), equalTo(DocWriteResponse.Result.NOOP));
            closeShards(shard);
        IndexShard shard = mock(IndexShard.class);
        // ASYNC durability only validates the fence at the sync interval, so the per-operation term validation fanout
            new FakeIndexResult(1, 1, 0, true, null)
            threadPool,
        closeShards(shard);
            threadPool::absoluteTimeInMillis,
            mock(IndexingPressureService.class),
    static class FakeDeleteResult extends Engine.DeleteResult {
        assertThat(failure.getCause(), equalTo(err));
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        when(indexShard.routingEntry()).thenReturn(shardRouting);
            shard,
        items[0] = new BulkItemRequest(0, writeRequest);
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
import java.util.concurrent.CountDownLatch;
        TranslogException appendFailure = new TranslogException(shardId, "simulated append failure at yield");
        BulkItemRequest item = new BulkItemRequest(
            request,
                updateResponse,
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
            null,
        BulkItemResponse.Failure failure = primaryResponse.getFailure();
        assertTrue(shard.isSyncNeeded());
    public void testForceExecutionOnRejectionAfterMappingUpdate() throws Exception {
        TransportShardBulkAction.performOnPrimary(
 *    http://www.apache.org/licenses/LICENSE-2.0
        closeShards(shard);
    /**
            assertEquals(RestStatus.TOO_MANY_REQUESTS, primaryResponse2.status());
                    observedFailure.set(e);
        );
import java.util.concurrent.BrokenBarrierException;
import org.opensearch.transport.client.Requests;
            new LatchedActionListener<>(new ActionListener<>() {
            threadPool,
import org.opensearch.action.support.PlainActionFuture;
        );
            assertFalse(primaryResponse1.isFailed());
        final Translog.Location deleteLocation = new Translog.Location(1, 20, 10);
        TransportShardBulkAction.performOnPrimary(
                // No location since all operations failed
        // The setting is inert without remote store; fencing must not take replicas off the write path.
        // execute the runnable on a separate thread so that the infinite loop can be detected
        assertThat(completedRequest.items()[0].request(), equalTo(updateResponse));
            threadPool,
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        AtomicInteger completions = new AtomicInteger();
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
            Names.WRITE
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
        );
            )
        assertThat(primaryResponse.getId(), equalTo("id"));
import org.opensearch.action.support.replication.ReplicationMode;
        // Create multiple failed update operations
        // Assert that the document actually made it there
        // Index op succeeds and leaves a chunk pending in the batch.
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
        items[0] = new BulkItemRequest(0, writeRequest);
            new LatchedActionListener<>(new ActionListener<>() {
        assertThat(failure.getId(), equalTo("id"));
        itemRequests[0] = itemRequest;
        public void updateMappings(Mapping update, ShardId shardId, ActionListener<Void> listener) {
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
        // Translog shouldn't be synced, as there were conflicting mappings
            new UpdateHelper.Result(
import static org.hamcrest.Matchers.emptyArray;
        // ...and finish() rethrows exactly that stored instance.
            threadPool::absoluteTimeInMillis,
        BulkItemRequest[] itemRequests = new BulkItemRequest[1];
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenAnswer(
        IndicesService indicesService = mock(IndicesService.class);
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        assertThat(synced.get(), equalTo(deleteLocation));
    public void testSameFailureInstanceFromBodyAndFinishIsNotSelfSuppressed() throws Exception {
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
                .put("thread_pool." + ThreadPool.Names.WRITE + ".queue_size", 1)
        TransportShardBulkAction action = new TransportShardBulkAction(
        assertThat(context.getLocationToSync(), nullValue());
    }
import org.opensearch.transport.TransportChannel;
        when(shard.shardId()).thenReturn(shardId);
        // Mixed request: an index that fills the batch, then an update, then a delete. Each of the update and delete
            mock(TransportService.class),
                noopUpdateResponse,
        assertThat(primaryResponse.getId(), equalTo("id"));
import org.mockito.InOrder;
            updateCalled.incrementAndGet();
                public void onFailure(Exception e) {
        doAnswer(invocation -> {
        // begin -> apply index -> flush (before update) -> apply update -> flush (before delete) -> apply delete -> finish
            BulkItemRequest[] items = new BulkItemRequest[2];
        final Translog.Location scope1Location = new Translog.Location(1, 10, 10);
                }, e -> { fail("Post replication actions should not fail: " + e.getMessage()); }));
        assertThat(primaryResponse.getResponse(), equalTo(noopUpdateResponse));
            listener -> listener.onResponse(null),
            final CountDownLatch latch = new CountDownLatch(1);
                cyclicBarrier.await();
                ActionTestUtils.assertNoFailureListener(
        assertFalse(context.hasMoreOperationsToExecute());
        );
        UpdateHelper updateHelper = mock(UpdateHelper.class);
import java.util.Collections;
            listener -> listener.onResponse(null),
            createIndexSettings(
        // Execute bulk operation
    }
        assertThat(beginThreads.size(), equalTo(2));
        Engine.IndexResult indexResult = new Engine.IndexResult(err, 0, 0, 0);
            mock(IndexingPressureService.class),
                Collections.singletonMap("field", "value"),
        when(shard.mapperService()).thenReturn(mock(MapperService.class));
            null,
                Requests.INDEX_CONTENT_TYPE
                threadPool::absoluteTimeInMillis,
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
import org.opensearch.indices.IndicesService;
            // add a response to the request and thereby check that it is ignored for the primary.
        assertFalse(shard.isSyncNeeded());
        // timeout the request in 10 seconds if there is an infinite loop
        TransportShardBulkAction.executeBulkItemRequest(
        BulkItemResponse.Failure failure = primaryResponse.getFailure();
        CountDownLatch latch = new CountDownLatch(1);
                BulkItemResponse primaryResponse = result.replicaRequest().items()[0].primaryResponse();
            0,
        );
            return this.location;
        when(shard.indexSettings()).thenReturn(indexSettings);
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        });
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
            super(version, term, seqNo, found);
        );
            new NoopMappingUpdatePerformer(),
        assertFalse(primaryResponse.isFailed());
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        ClusterService clusterService = mock(ClusterService.class);
        assertNotNull(task.getPhase());
    /**
            new NoopMappingUpdatePerformer(),
            mockClusterService(),
    }
            rejectingThreadPool.shutdownNow();
        );
                logger.info("unblocked the write executor");
        items[2] = new BulkItemRequest(2, new IndexRequest("index").id("success2").source(Requests.INDEX_CONTENT_TYPE, "field", "value"));
        when(updateHelper.prepare(any(), eq(shard), any())).thenThrow(
        IndexRequest updateResponse = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");
    }
            BulkShardRequest[] completedRequest = new BulkShardRequest[1];
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
        Translog.Location resultLocation2 = new Translog.Location(43, 43, 43);
            threadPool,
            assertNull(primaryResponse2.getResponse());
            new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
import static org.hamcrest.CoreMatchers.instanceOf;
            threadPool::absoluteTimeInMillis,
        assertThat(primaryResponse.getFailureMessage(), containsString("I'm conflicted <(;_;)>"));
import org.opensearch.action.support.replication.TransportReplicationAction.ReplicaResponse;
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.CREATE));
        when(shard.mapperService()).thenReturn(mock(MapperService.class));
            mock(IndexingPressureService.class),
    private static final ActionListener<Void> ASSERTING_DONE_LISTENER = ActionTestUtils.assertNoFailureListener(r -> {});
        );
        );
        closeShards(shard);
            threadPool,
            new NoopMappingUpdatePerformer(),
        assertThat(primaryResponse.getItemId(), equalTo(0));
        // Both operations were attempted (mapping-update attempt + successful retry).
                true,
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
                ),
        );
     * Fake DeleteResult that has a settable translog location
        BulkItemResponse.Failure failure = primaryResponse.getFailure();
    public void testPendingIndexBatchFlushesBeforeUpdateAndDeleteBoundaries() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        when(indexShard.indexSettings()).thenReturn(
            )
        );
        IndexShard shard = mock(IndexShard.class);
        List<BulkItemRequest> items = new ArrayList<>(nItems);
            new NoopMappingUpdatePerformer(),
        assertThat(failure.getStatus(), equalTo(RestStatus.CONFLICT));
        }
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        // the beating will continue until success has come.
        // Exactly two batch scopes: the original (yielded) scope and the resumed scope.
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            assertNotNull(item.primaryResponse());
        // should be filled out with the failure information
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
                randomBoolean() ? DocWriteResponse.Result.CREATED : DocWriteResponse.Result.UPDATED,
            bulkShardRequest,
                    result -> synced.set(((WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result).location)
     * location; the retry runs on another thread in scope 2, whose finish reports a later location. The request must
        when(shard.indexSettings()).thenReturn(indexSettings);
            new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
    public void testExecuteBulkIndexRequestWithMappingUpdates() throws Exception {
            new UpdateHelper.Result(
        when(shard.indexSettings()).thenReturn(indexSettings);
            when(batch.flush()).thenReturn(loc);
        assertThrows(ShardNotFoundException.class, listener::actionGet);
            deferredA,
    private IndexMetadata indexMetadata() throws IOException {
        when(allocationId.getId()).thenReturn(aId);
        when(updateHelper.prepare(any(), eq(shard), any())).thenThrow(versionConflict);
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
                DocWriteResponse.Result.DELETED,
                shard,
        BulkShardRequest completedRequest = context.getBulkShardRequest();
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
        });
     * does not recognise.
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
                @Override
        IndexShard shard = mock(IndexShard.class);
            ASSERTING_DONE_LISTENER
            return null;
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
        assertThat(failure.getCause().getClass(), equalTo(VersionConflictEngineException.class));
        when(shard.mapperService()).thenReturn(mock(MapperService.class));
        final IndexShard indexShard = mock(IndexShard.class);
        IndexRequest updateResponse = new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value");
        IndexShard shard = mock(IndexShard.class);
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        inOrder.verify(shard).applyDeleteOperationOnPrimary(anyLong(), any(), any(), any(), anyLong(), anyLong());
        BulkItemRequest[] items = new BulkItemRequest[] {
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        final CountDownLatch latch = new CountDownLatch(1);
                null,
        assertThat(response.getSeqNo(), equalTo(13L));
        assertThat(primaryResponse.getOpType(), equalTo(DocWriteRequest.OpType.UPDATE));
                new Mapping(null, mock(RootObjectMapper.class), new MetadataFieldMapper[0], Collections.emptyMap())
    }
            mock(SystemIndices.class),
    private IndicesService mockIndicesService(String aId, long primaryTerm) {
        BulkItemRequest primaryRequest = new BulkItemRequest(0, writeRequest);
            mock(ActionFilters.class),
            refreshCalled.set(true);
            refreshCalled.set(true);
import org.opensearch.threadpool.ThreadPool;
 * software distributed under the License is distributed on an
        BulkItemRequest[] items = new BulkItemRequest[] { primaryRequest };
            context,
        final ReplicationTask task = createReplicationTask();
            listener -> {},
        for (BulkItemRequest item : completedRequest[0].items()) {
        Engine.IndexResult success = new FakeIndexResult(1, 1, 13, true, resultLocation);
        TranslogException bodyFailure = new TranslogException(shardId, "simulated inline translog failure");
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
            updateHelper,
        writeRequest.retryOnConflict(Integer.MAX_VALUE);
        // Mock refresh to track if it's called
            UpdateRequest updateRequest = (UpdateRequest) item.request();
        );
        assertNull(context.getLocationToSync());
        TransportShardBulkAction.performOnPrimary(
        );
            Settings.builder()
        assertFalse(context.hasMoreOperationsToExecute());
        assertThat("mappings were \"updated\" once", updateCalled.get(), equalTo(1));
        TransportShardBulkAction.performOnPrimary(
        when(shard.shardId()).thenReturn(shardId);
        assertDocCount(shard, 0);
        // must be retained.
    }
                primaryResult.runPostReplicationActions(ActionListener.wrap(v -> {
        assertThat(observedFailure.get(), sameInstance(appendFailure));
        assertThat(replicaDeleteRequest.version(), equalTo(Versions.MATCH_ANY));
        verify(batches.get(0)).finish();
     * When an operation requires a dynamic mapping update, execution yields the thread. Before yielding, the current
    public static class NoopMappingUpdatePerformer implements MappingUpdatePerformer {
            new UpdateHelper.Result(
    public void testMappingUpdateYieldFinishesScopeAndResumedExecutionBeginsFreshBatch() throws Exception {
        );
        when(indexShard.getOperationPrimaryTerm()).thenReturn(primaryTerm);
            ASSERTING_DONE_LISTENER
            threadPool::absoluteTimeInMillis,
            new LatchedActionListener<>(new ActionListener<>() {
            assertFalse(item.primaryResponse().isFailed());
 */
            Engine.IndexResult mappingUpdate = new Engine.IndexResult(
        when(shard.indexSettings()).thenReturn(indexSettings);
            threadPool::absoluteTimeInMillis,
        // Now do the same after indexing the document, it should now find and delete the document
            new NoopMappingUpdatePerformer(),
        TransportShardBulkAction.performOnPrimary(
                    observedFailure.set(e);
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
        for (int i = 0; i < 3; i++) {
 * Licensed to Elasticsearch under one or more contributor
        // thread so we can prove the resumed execution ran on a different thread.
        // Mock routing entry, allocation id
            threadPool::absoluteTimeInMillis,
                return conflictedResult;
                (update, shardId, listener) -> {
    }
        assertThat(primaryResponse.getOpType(), equalTo(create ? DocWriteRequest.OpType.CREATE : DocWriteRequest.OpType.INDEX));
        EngineException appendFailure = new EngineException(shardId, "simulated batched append failure");
 * You may obtain a copy of the License at
            threadPool,
        assertDocCount(shard, 1);
            new NoopMappingUpdatePerformer(),
        BulkPrimaryExecutionContext secondContext = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
            mock(ShardStateAction.class),
        final long resultSeqNo = 13;
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            threadPool,
        TransportShardBulkAction.executeBulkItemRequest(context, null, threadPool::absoluteTimeInMillis, (update, shardId, listener) -> {
            }, latch),
            DocWriteRequest<IndexRequest> writeRequest = new IndexRequest("index").id("id_" + i)
        TransportShardBulkAction action = createAction();
        IndexShard shard = newStartedShard(true);
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
        );
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
                @Override
            .putMapping(
        final String aId = "test-allocation-id";
            mockIndicesService(aId, 1L),
        assertThat(primaryResponse.getItemId(), equalTo(0));
        assertNull(context.getLocationToSync());
            // UpdateRequest::prepareRequest
        assertEquals(ReplicationMode.PRIMARY_TERM_VALIDATION, action.getReplicationMode(indexShard));
import org.opensearch.action.update.UpdateRequest;
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shard.shardId(), RefreshPolicy.NONE, itemRequests);
        assertThat(failure.getId(), equalTo("id"));
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
            assertThat(primaryResponse1.getItemId(), equalTo(0));
            indexResult
            bulkShardRequest,
        response = primaryResponse.getResponse();
        IndexShard shard = mock(IndexShard.class);
        BulkItemRequest[] items = new BulkItemRequest[1];
import org.opensearch.index.mapper.MapperService;
    public void testBatchedTranslogFinishFailureFailsRequestAcknowledgement() throws Exception {
/*
        assertEquals("failed", task.getPhase());
        );
                assertThat(((WritePrimaryResult<BulkShardRequest, BulkShardResponse>) result).location, equalTo(resultLocation));
    public void testHandlePrimaryTermValidationRequestWithDifferentAllocationId() {
            threadPool::absoluteTimeInMillis,
                public void onResponse(PrimaryResult<BulkShardRequest, BulkShardResponse> response) {
import static org.mockito.Mockito.verify;
        BulkItemRequest[] items = new BulkItemRequest[] {
        TransportShardBulkAction.executeBulkItemRequest(
                @Override
        TransportShardBulkAction action = createAction();
        );
                int loc = locationCounter.getAndIncrement();
        assertThat(response.getIndex(), equalTo("index"));
        inOrder.verify(batch).flush();
                primaryRequest.request(),
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
        AtomicBoolean refreshCalled = new AtomicBoolean(false);
            new NoopMappingUpdatePerformer(),
        BulkItemRequest[] items = new BulkItemRequest[2];
            context,
            threadPool::absoluteTimeInMillis,
            updateHelper,
        RuntimeException err = new RuntimeException("some kind of exception");
        TransportShardBulkAction.performOnPrimary(
                    latch.countDown();
        IndexSettings indexSettings = new IndexSettings(indexMetadata(), Settings.EMPTY);
            new FakeIndexResult(1, 1, 11, true, new Translog.Location(11, 11, 11))
        TransportShardBulkAction.performOnPrimary(
        @Override
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        assertThat(primaryResponse.getId(), equalTo("id"));
        IndexShard shard = mock(IndexShard.class);
        AlreadyClosedException finishFailure = new AlreadyClosedException("translog is already closed");
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
        items[0] = new BulkItemRequest(0, writeRequest);
            new IndexRequest("index").id("id").source(Requests.INDEX_CONTENT_TYPE, "field", "value")
            new NoopMappingUpdatePerformer(),
        AlreadyClosedException closed = new AlreadyClosedException("translog is already closed");
        .put("index.version.created", Version.CURRENT.id)
        BulkItemRequest item = new BulkItemRequest(
        IndexShard shard = mock(IndexShard.class);
        // Return an exception when trying to update the mapping, or when waiting for it to come
     * over both the batch and the shard, for a mixed INDEX, UPDATE, DELETE bulk request.
        AtomicBoolean refreshCalled = new AtomicBoolean(false);
    public void testGetReplicationModeWithLocalTranslog() {
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
            );
                // Run post replication actions
                assertThat(primaryResponse.getId(), equalTo("id"));
        latch.await();
    public void testFailedUpdatePreparationDoesNotTriggerRefresh() throws Exception {
import org.opensearch.cluster.routing.AllocationId;
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
    }
            createIndexSettings(
            return null;
            rejectingThreadPool.executor(ThreadPool.Names.WRITE).execute(() -> {});
            items[i] = new BulkItemRequest(i, new UpdateRequest("index", "id" + i).doc(Requests.INDEX_CONTENT_TYPE, "field", "value"));
            mock(SegmentReplicationPressureService.class),
        final IndexShard indexShard = mock(IndexShard.class);
            updateHelper,
                    try {
                new NoopMappingUpdatePerformer(),
        UpdateHelper updateHelper = mock(UpdateHelper.class);
            updateHelper,
                    BulkShardRequest,
import org.opensearch.OpenSearchException;
                // Verify refresh was NOT called even though refresh policy was IMMEDIATE
import org.opensearch.core.index.Index;
        assertThat(response.getResult(), equalTo(DocWriteResponse.Result.DELETED));
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            if (randomBoolean()) {
        assertThat(context.getLocationToSync(), equalTo(resultLocation));
        BulkShardRequest request = new BulkShardRequest(shardId, RefreshPolicy.NONE, new BulkItemRequest[] { item });
import java.util.function.LongSupplier;
            request,
import java.util.Arrays;
        shard.sync(context.getLocationToSync(), e -> {
        inOrder.verify(shard).beginTranslogBatch();
import org.opensearch.index.shard.IndexShard;
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
            Settings.EMPTY,
            updateHelper,
            ASSERTING_DONE_LISTENER
        Engine.TranslogBatch batch = mock(Engine.TranslogBatch.class);
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
            cyclicBarrier.await();
            Names.WRITE
 * GitHub history for details.
import org.opensearch.index.translog.Translog;
        assertTrue(latch.await(5, TimeUnit.SECONDS));
                assertNotNull(primaryResult.location);
                    listener.onResponse(null);
            shard,
            )
        Translog.Location resultLocation = new Translog.Location(42, 42, 42);
        closeShards(shard);
            new UpdateHelper.Result(
                Requests.INDEX_CONTENT_TYPE
        // Should be failed since the document already exists
    private ReplicationTask createReplicationTask() {
        assertThat(batches.size(), equalTo(2));
        when(shard.indexSettings()).thenReturn(indexSettings);
        assertThat(failure.getIndex(), equalTo("index"));
        assertEquals(SequenceNumbers.NO_OPS_PERFORMED, ((ReplicaResponse) listener.actionGet()).localCheckpoint());
        assertThat(primaryResponse.getItemId(), equalTo(0));
        Engine.DeleteResult deleteResult = new FakeDeleteResult(1, 1, resultSeqNo, found, resultLocation);
                .build()
            }), latch),
            new BulkItemResponse(
            ir -> conflictedResult
/*
        TransportShardBulkAction.executeBulkItemRequest(
        List<String> beginThreads = new CopyOnWriteArrayList<>();
                    .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
    /**
        TransportShardBulkAction.executeBulkItemRequest(
            }
                    assertEquals(err, e);
        Runnable runnable = () -> TransportShardBulkAction.performOnPrimary(
            // resume synchronously via the listener - no sleeps, deterministic
        @Override
            null,
        when(updateHelper.prepare(any(), eq(shard), any())).thenReturn(
        primaryResponse = replicaRequest.primaryResponse();
        bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
     */
    }
                // Should have location from successful operations
        // 1 for this execution)
        Exception err = new VersionConflictEngineException(shardId, "id", "I'm conflicted <(;_;)>");
import static org.hamcrest.Matchers.contains;
        // Translog should change, since there were no problems
/*
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items.toArray(BulkItemRequest[]::new));
        assertTrue(latch.await(5, TimeUnit.SECONDS));
import org.opensearch.action.index.IndexResponse;
        assertThat(completedRequest.items().length, equalTo(1));
import org.opensearch.action.delete.DeleteResponse;
    /** Always throw the given exception */
        assertThat(failure.getId(), equalTo("id"));
        }
        CountDownLatch latch = new CountDownLatch(1);
        return clusterService;
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
            context,
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
            new UpdateHelper.Result(
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
            Engine.IndexResult success2 = new FakeIndexResult(1, 1, 13, true, resultLocation2);
    }
                assertNotNull(primaryResult.location);
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
        return indicesService;
            listener -> listener.onResponse(null),
        items[0] = randomlySetIgnoredPrimaryResponse(primaryRequest);
            new NoopMappingUpdatePerformer(),
            threadPool::absoluteTimeInMillis,
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
            ),
                }
import org.opensearch.index.mapper.MetadataFieldMapper;
                public void onResponse(Void aVoid) {}
            batches.add(batch);
        );
            )
        UpdateHelper updateHelper = mock(UpdateHelper.class);
            null,
        when(indicesService.indexServiceSafe(any(Index.class))).thenReturn(indexService);
    }
        assertThat(context.getLocationToSync(), not(location));
import java.util.ArrayList;
            updateHelper,
        final CountDownLatch latch = new CountDownLatch(1);
        );
            mock(MappingUpdatedAction.class),
import static org.mockito.Mockito.doAnswer;
        assertThat(response.getId(), equalTo("id"));
        private final RuntimeException e;
            listener -> {},
        assertFalse(context.hasMoreOperationsToExecute());
            null,
        inOrder.verify(batch).flush();
            updateHelper,
                randomBoolean() ? DocWriteResponse.Result.CREATED : DocWriteResponse.Result.UPDATED,
        CountDownLatch latch = new CountDownLatch(1);
        UpdateHelper updateHelper = mock(UpdateHelper.class);
            ASSERTING_DONE_LISTENER
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(bulkShardRequest, shard);
        BulkItemRequest item = new BulkItemRequest(
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
            null,
            mockClusterService(),
            mock(RemoteStorePressureService.class),
        when(shard.applyDeleteOperationOnPrimary(anyLong(), any(), any(), any(), anyLong(), anyLong())).thenReturn(deleteResult);
            new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {}), latch),
        verify(shard, times(1)).beginTranslogBatch();
            indexResult
     * The pending index chunk must be appended (flushed) before an UPDATE and before a DELETE are applied, so that an
        assertThat(primaryResponse.getId(), equalTo("id"));
        assertTrue(TransportActions.isShardNotAvailableException(observedFailure.get()));
        Engine.IndexResult conflictedResult = new Engine.IndexResult(err, 0);
            listener -> listener.onResponse(null),
 */
        }
            Names.WRITE
                assertThat(response.status(), equalTo(RestStatus.CREATED));
        location = context.getLocationToSync();
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.DocWriteRequest;
            mock(IndexingPressureService.class),
        private final Translog.Location location;
                }
            listener.onFailure(e);
        }).when(shard).refresh(any());
        items[0] = randomlySetIgnoredPrimaryResponse(items[0]);
        assertThat(response.status(), equalTo(created ? RestStatus.CREATED : RestStatus.OK));
        // Execute bulk operation
        rejectingThreadPool.executor(ThreadPool.Names.WRITE).execute(() -> {
        TransportShardBulkAction.performOnPrimary(
            mockClusterService(),
            )
        BulkItemResponse primaryResponse = completedRequest.items()[0].primaryResponse();
            context,
        UpdateHelper updateHelper = mock(UpdateHelper.class);
        );
        final ShardId shardId = new ShardId("test", "_na_", 0);
            mock(ShardStateAction.class),
            this.location = location;
        when(shard.shardId()).thenReturn(shardId);
        );
                listener -> listener.onResponse(null),
        assertThat(failure.getIndex(), equalTo("index"));
        );
        DocWriteRequest<UpdateRequest> writeRequest = new UpdateRequest("index", "id").doc(Requests.INDEX_CONTENT_TYPE, "field", "value");
                Requests.INDEX_CONTENT_TYPE
        when(indexShard.indexSettings()).thenReturn(
        BulkShardRequest completedRequest = context.getBulkShardRequest();
import org.opensearch.index.VersionType;
    public void testUpdateRequestWithSuccess() throws Exception {
                assertNull(primaryResult.location);
            }, latch),
        // Execute bulk operation
            )
        when(shard.applyIndexOperationOnPrimary(anyLong(), any(), any(), anyLong(), anyLong(), anyLong(), anyBoolean())).thenReturn(
        BulkShardRequest completedRequest = context.getBulkShardRequest();
 */
        IndexShard shard = mock(IndexShard.class);
            },
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.IMMEDIATE, items);
    }
 *
        Exception err = new OpenSearchException("I'm dead <(x.x)>");
        assertTrue(context.isInitial());
        );
                public void onResponse(PrimaryResult<BulkShardRequest, BulkShardResponse> response) {
        assertFalse(context.hasMoreOperationsToExecute());
                assertTrue(refreshCalled.get());
                    .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
 *
        Engine.IndexResult mappingUpdate = new Engine.IndexResult(
        AtomicInteger locationCounter = new AtomicInteger(42);
        // The resumed execution began its fresh batch on a different thread than the original invocation, proving the
        when(shard.shardId()).thenReturn(shardId);
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.NONE, items);
        // Track refresh calls
        assertThat(primaryResponse.getResponse().getSeqNo(), equalTo(0L));
            threadPool::absoluteTimeInMillis,
    }
        TransportShardBulkAction action = new TransportShardBulkAction(
                new BulkItemResponse(
        BulkItemRequest[] items = new BulkItemRequest[3];
            deferredB
        BulkShardRequest bulkShardRequest = new BulkShardRequest(shardId, RefreshPolicy.IMMEDIATE, items);
            new TransportShardBulkAction.PrimaryTermValidationRequest(aId + "-1", 1, shardId),
