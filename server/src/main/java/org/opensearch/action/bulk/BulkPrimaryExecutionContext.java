    public void finishTranslogBatch() {
                executionResult.getResponse().setShardInfo(new ReplicationResponse.ShardInfo());
         * The incoming request has been translated to a request that can be executed on the shard.
        // we always get to the end of the list by using advance, which in turn sets the state to INITIAL
        return new BulkShardResponse(request.shardId(), primaryResponses, serviceTimeEWMAInNanos, nodeQueueSize);
                        primary.shardId(),
 *
                }
                            docWriteRequest.id(),
    public void markOperationAsNoOp(DocWriteResponse response) {
        executionResult = null;
    /**
        );
    }
                        result.getTerm(),
        assertInvariants(ItemProcessingState.COMPLETED);
        assert this.translogBatch == null : "a translog batch is already registered for this execution";
        }
    }
    @SuppressWarnings("unchecked")
    public BulkShardResponse buildShardResponse(long serviceTimeEWMAInNanos, int nodeQueueSize) {
        }
        assert assertInvariants(ItemProcessingState.INITIAL);
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertInvariants(ItemProcessingState.INITIAL);
    private DocWriteRequest<?> requestToExecute;
                } else {
     * facing response
    private BulkItemResponse executionResult;
                            request.index(),
        assertInvariants(ItemProcessingState.TRANSLATED);
        switch (currentItemState) {
     * returns true if {@link #advance()} has moved the current item beyond the
                            result.getSeqNo(),
                break;
    }
        DocWriteRequest<?> docWriteRequest = getRequestToExecute();
    }
        return primary;
        markAsCompleted(executionResult);
import org.opensearch.action.support.replication.ReplicationResponse;
            + "] to be one of "
         * This is needed to support retry on conflicts during updates.
        if (locationToSync == null || location.compareTo(locationToSync) > 0) {
    }
        assertInvariants(ItemProcessingState.INITIAL);
    }
        currentItemState = ItemProcessingState.WAIT_FOR_MAPPING_UPDATE;
     * end of the {@link BulkShardRequest#items()} array.
    public void markAsCompleted(BulkItemResponse translatedResponse) {
    /**
 * KIND, either express or implied.  See the License for the
    enum ItemProcessingState {
        }
        assert currentIndex >= 0 : currentIndex;
                        primary.shardId(),
        }
    private BulkItemRequest getCurrentItem() {
    /** builds the bulk shard response to return to the user */
 * Unless required by applicable law or agreed to in writing,
        assert assertInvariants(ItemProcessingState.EXECUTED);
            // concrete index instead of an alias if used!
    public void mergeLocationToSync(@Nullable Translog.Location location) {
    /**
        return currentItemState == ItemProcessingState.COMPLETED;
        switch (result.getResultType()) {
    }
     * safe after a mapping-update yield has already finished the scope. If {@code finish()} throws, the scope is still
    /** the current operation has been executed on the primary with the specified result */
    /** returns the primary shard */
    /**
        if (batch == null) {
    }
         * No further handling of current request is needed. The result has been converted to a user response
                    Engine.DeleteResult deleteResult = (Engine.DeleteResult) result;
                        // concrete index instead of an alias if used!
 * software distributed under the License is distributed on an
    /** move to the next item to execute */
import org.opensearch.index.translog.Translog;
        return retryCounter;
 * license agreements. See the NOTICE file distributed with
     * Registers the translog batch scope opened for the current execution of this request on the current thread. A
         * the request can not execute with the current mapping and should wait for a new mapping
                assert executionResult != null;
                    executionResult = new BulkItemResponse(
            request.items()[currentIndex] = new BulkItemRequest(request.items()[currentIndex].id(), requestToExecute);
        assert assertInvariants(ItemProcessingState.TRANSLATED);
                }
        mergeLocationToSync(batch.finish());
                    );
        while (startIndex < length && isAborted(request.items()[startIndex].primaryResponse())) {
                // set a blank ShardInfo so we can safely send it to the replicas. We won't use it in the real response though.
                        requestToExecute.id(),
                executionResult = new BulkItemResponse(current.id(), current.request().opType(), response);
    }
}
    /** indicates that the current operation can not be completed and needs to wait for a new mapping from the cluster-manager */
 * GitHub history for details.
                    throw new AssertionError("unknown result type :" + result.getResultType());
    public boolean requiresWaitingForMappingUpdate() {
        return getCurrentItem().index();
     * sync, and unregisters it. Idempotent: the second and later calls do nothing, so the caller's finally block is
        return request.setPrimaryResponses(primaryResponses);
    public boolean isCompleted() {
    }
    }
                        requestToExecute.id(),
    /** finishes the execution of the current request, with the response that should be returned to the user */
        retryCounter++;
                        // use docWriteRequest.index() it will use the
        assert hasMoreOperationsToExecute() == false;
    public void setTranslogBatch(Engine.TranslogBatch translogBatch) {
     * the batch appended, which is older than an update, delete or no-op the engine wrote inline after the last chunk
        return getCurrentItem().request();
        currentIndex = findNextNonAborted(currentIndex + 1);
                        new BulkItemResponse.Failure(
class BulkPrimaryExecutionContext {
    private final BulkShardRequest request;
 *
            return;
    }
    /** gets the current, untranslated item request */
                    executionResult = new BulkItemResponse(current.id(), current.request().opType(), indexResponse);
        requestToExecute = writeRequest;
    /** returns the number of times the current operation has been retried */
        assert Arrays.asList(expectedCurrentState).contains(currentItemState) : "expected current state ["
    public void resetForExecutionForRetry() {
                throw new AssertionError("unknown result type for " + getCurrentItem() + ": " + result.getResultType());
     * returns true if the current request has been completed and it's result translated to a user
    BulkPrimaryExecutionContext(BulkShardRequest request, IndexShard primary) {
 * This is a utility class that holds the per request state needed to perform bulk operations on the primary.
            case INITIAL:
        }
import org.opensearch.action.DocWriteRequest;
                assert executionResult == null : executionResult;
    }
import org.opensearch.common.Nullable;
        return true;
        /**
                        deleteResult.getSeqNo(),
                        // Make sure to use request.index() here, if you
    private int retryCounter;
    private static boolean isAborted(BulkItemResponse response) {
        return locationToSync;
        /**
        primaryResponses[currentIndex] = translatedResponse;
 * this file be licensed under the Apache-2.0 license or a
    }
        this.primaryResponses = new BulkItemResponse[request.items().length];
    private int findNextNonAborted(int startIndex) {
        final DocWriteRequest<?> docWriteRequest = getCurrentItem().request();
                    Engine.IndexResult indexResult = (Engine.IndexResult) result;
        /**
        assert hasMoreOperationsToExecute() == false;
        assertInvariants(ItemProcessingState.WAIT_FOR_MAPPING_UPDATE, ItemProcessingState.EXECUTED);
 * SPDX-License-Identifier: Apache-2.0
        return currentItemState == ItemProcessingState.INITIAL;
        assert assertInvariants(ItemProcessingState.WAIT_FOR_MAPPING_UPDATE);
    public void markAsRequiringMappingUpdate() {
        if (location == null) {
    public DocWriteRequest<?> getCurrent() {
        currentItemState = ItemProcessingState.INITIAL;
     */
    public void markOperationAsExecuted(Engine.Result result) {
 *
                assert requestToExecute == null;
                        result.getTerm(),
                        deleteResult.getVersion(),
 * The OpenSearch Contributors require contributions made to
    }
                } else {
    /** returns a translog location that is needed to be synced in order to persist all operations executed so far */
                            result.getFailure(),
import org.opensearch.index.shard.IndexShard;
        assert assertInvariants(ItemProcessingState.WAIT_FOR_MAPPING_UPDATE);
         * submitted
     * Folds a translog {@link Translog.Location} into {@code locationToSync}, keeping the greatest one seen so far.
    private boolean assertInvariants(ItemProcessingState... expectedCurrentState) {
            return;
import org.opensearch.action.delete.DeleteResponse;
    /** indicates that the operation needs to be failed as the required mapping didn't arrive in time */
                        primary.shardId(),
        assert assertInvariants(ItemProcessingState.TRANSLATED);
import org.opensearch.action.index.IndexResponse;
                assert executionResult == null : executionResult;
    }
import org.opensearch.core.index.AppendOnlyIndexOperationRetryException;
     * scope is owned by exactly one execution; a mapping-update yield finishes it before the request is re-executed.
        this.request = request;
    }
        requestToExecute = null;
            case EXECUTED:
                    Engine.IndexResult indexResult = (Engine.IndexResult) result;
            // Make sure to use getCurrentItem().index() here, if you use docWriteRequest.index() it will use the
    }
        return request.items()[currentIndex];
                            result.getTerm()
        if (translatedResponse.isFailed() == false && requestToExecute != null && requestToExecute != getCurrent()) {
                assert executionResult == null : executionResult;
        advance();
        executionResult = new BulkItemResponse(
        executionResult = new BulkItemResponse(getCurrentItem().id(), getCurrentItem().request().opType(), response);
        return currentIndex < request.items().length;
    private ItemProcessingState currentItemState;
         */
    /** completes the operation without doing anything on the primary */
/*
    public int getRetryCounter() {
        assert currentItemState == ItemProcessingState.COMPLETED || currentIndex == -1
package org.opensearch.action.bulk;
        INITIAL,
        return response != null && response.isFailed() && response.getFailure().isAborted();
        return executionResult;
 * You may obtain a copy of the License at
    private Engine.TranslogBatch translogBatch = null;
     */
        assert retryCounter >= 0 : retryCounter;
    public IndexShard getPrimary() {
        this.translogBatch = Objects.requireNonNull(translogBatch);
    /** returns the result of the request that has been executed on the shard */
    }
     */
                if (result.getOperationType() == Engine.Operation.TYPE.INDEX) {
        this.primary = primary;
        currentItemState = ItemProcessingState.EXECUTED;
    public boolean isInitial() {
            case SUCCESS:
                if (result.getFailure() instanceof AppendOnlyIndexOperationRetryException) {
                assert executionResult != null;
         */
     * flush. Taking the maximum keeps every operation of the request, batched or inline, covered by the final sync.
                break;
    }
        currentItemState = ItemProcessingState.TRANSLATED;
 */
import org.opensearch.index.engine.Engine;
        requestToExecute = null;
     */
        TRANSLATED,
        currentItemState = ItemProcessingState.EXECUTED;
     * Finishes the registered translog batch, if any, folding the greatest location it appended into the location to
    /** returns the name of the index the current request used */
                        indexResult.isCreated()
 * this work for additional information regarding copyright
                        docWriteRequest.opType(),
                // requestToExecute can be null if the update ended up as NOOP
                    response = new DeleteResponse(
                        result.getSeqNo(),
     * <p>
        assertInvariants(ItemProcessingState.EXECUTED);
            locationToSync = location;
import java.util.Arrays;
 * not use this file except in compliance with the License.
     */
        COMPLETED
            case WAIT_FOR_MAPPING_UPDATE:
         * to arrive from the cluster-manager. A mapping request for the needed changes has already been
    /** resets the current item state, prepare for a new execution */
 */
        assert translatedResponse.getItemId() == getCurrentItem().id();
    }
    @Nullable
        currentItemState = ItemProcessingState.COMPLETED;
        IMMEDIATE_RETRY,
                        current.id(),
        return (T) requestToExecute;
         */
 *     http://www.apache.org/licenses/LICENSE-2.0
     * received from the user (specifically, an update request is translated to an indexing or delete request).
                break;
import org.opensearch.action.DocWriteResponse;
    }
    }
    public void failOnMappingUpdate(Exception cause) {
     * Locations are no longer guaranteed to arrive in increasing order once index operations are batched: a deferred
         * This is used to convert update requests to a fully specified index or delete requests.
                        indexResult.getVersion(),
                // A batched index result has no location yet; its chunk's location is folded in on flush/finish.
        assert executionResult != null && translatedResponse.getItemId() == executionResult.getItemId();
    public BulkShardRequest getBulkShardRequest() {
    private final IndexShard primary;
            getCurrentItem().id(),
        assert assertInvariants(ItemProcessingState.INITIAL);
                break;
                mergeLocationToSync(result.getTranslogLocation());
    }
/**
 * More specifically, it maintains an index to the current executing bulk item, which allows execution
 * the Apache License, Version 2.0 (the "License"); you may
        currentItemState = ItemProcessingState.INITIAL;
            new BulkItemResponse.Failure(getCurrentItem().index(), docWriteRequest.id(), cause)
 * to stop and wait for external events such as mapping updates.
/*
    }
                    );
 * under the License.
        }
                    response = new IndexResponse(
/*
 */
    }
        return currentItemState == ItemProcessingState.WAIT_FOR_MAPPING_UPDATE;
    public void setRequestToExecute(DocWriteRequest<?> writeRequest) {
 * ownership. Elasticsearch licenses this file to you under
        advance();
                } else if (result.getOperationType() == Engine.Operation.TYPE.DELETE) {
                    );
    public boolean hasMoreOperationsToExecute() {
                break;
    private final BulkItemResponse[] primaryResponses;
        assertInvariants(ItemProcessingState.EXECUTED);
                    executionResult.getResponse().setShardInfo(new ReplicationResponse.ShardInfo());
                    );
        final Engine.TranslogBatch batch = translogBatch;
    private Translog.Location locationToSync = null;
        /** Item execution is ready to start, no operations have been performed yet */
            : "moving to next but current item wasn't completed (state: " + currentItemState + ")";
                        result.getTerm(),
 * Licensed to Elasticsearch under one or more contributor
     * is appended), and {@link org.opensearch.index.engine.Engine.TranslogBatch#finish()} reports the greatest location
        /** The request has been executed on the primary shard (successfully or not) */
        currentItemState = ItemProcessingState.EXECUTED;
            case FAILURE:
 * compatible open source license.
        EXECUTED,
            + currentItemState
                final DocWriteResponse response;
    public String getConcreteIndex() {
    }
         */
         * The request should be executed again, but there is no need to wait for an external event.
    }
        retryCounter = 0;
        executionResult = null;
    public <T extends DocWriteRequest<T>> T getRequestToExecute() {
        return startIndex;
                        deleteResult.isFound()
                        requestToExecute.id(),
        /**
                break;
            case COMPLETED:
        }
                assert requestToExecute == null : requestToExecute;
 *
     * unregistered (it has failed and completed every pending reader exceptionally) and the exception propagates.
        requestToExecute = null;
     */
                assert primaryResponses[currentIndex] != null;
        assert assertInvariants(ItemProcessingState.INITIAL);
                    // set a blank ShardInfo so we can safely send it to the replicas. We won't use it in the real response though.
    private int currentIndex = -1;
                        )
    /**
        final BulkItemRequest current = getCurrentItem();
            default:
 * specific language governing permissions and limitations
            + Arrays.toString(expectedCurrentState);
    }
     * index result carries a null location when {@link #markOperationAsExecuted} runs (it is folded in when its chunk
                assert requestToExecute != null;
            docWriteRequest.opType(),
        assert assertInvariants(ItemProcessingState.TRANSLATED);
     * returns true if the current request is in INITIAL state
    public Translog.Location getLocationToSync() {
                        indexResult.getVersion(),
        translogBatch = null;
    private void advance() {
 * @opensearch.internal
            startIndex++;
        final int length = request.items().length;
    /** returns true if the request needs to wait for a mapping update to arrive from the cluster-manager */
                        result.getSeqNo(),
                // requestToExecute can be null if the update ended up as NOOP
    /** returns the request that should be executed on the shard. */
                    DocWriteResponse indexResponse = new IndexResponse(
 */
            case TRANSLATED, IMMEDIATE_RETRY:
     */
                        indexResult.isCreated()
import java.util.Objects;
     * sets the request that should actually be executed on the primary. This can be different from the request
         * and execution can continue to the next item (if available).
    }
    /**
                break;
        WAIT_FOR_MAPPING_UPDATE,
 * Modifications Copyright OpenSearch Contributors. See
    public BulkItemResponse getExecutionResult() {
