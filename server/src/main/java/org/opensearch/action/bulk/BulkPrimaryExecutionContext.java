        assert hasMoreOperationsToExecute() == false;
    public void resetForExecutionForRetry() {
        markAsCompleted(executionResult);  
                    DocWriteResponse indexResponse = new IndexResponse(
                        docWriteRequest.opType(),
    }
                        result.getTerm(),  
        }  
    /**  
    public void markAsCompleted(BulkItemResponse translatedResponse) {
    public Translog.Location getLocationToSync() {  
                        // Make sure to use request.index() here, if you  
        assert assertInvariants(ItemProcessingState.INITIAL);  
    /** returns a translog location that is needed to be synced in order to persist all operations executed so far */
        final int length = request.items().length;
 * SPDX-License-Identifier: Apache-2.0
                throw new AssertionError("unknown result type for " + getCurrentItem() + ": " + result.getResultType());
            default:
    /** returns the request that should be executed on the shard. */  
    }
                // requestToExecute can be null if the update ended up as NOOP
    public <T extends DocWriteRequest<T>> T getRequestToExecute() {
    }
 * Unless required by applicable law or agreed to in writing,
                    throw new AssertionError("unknown result type :" + result.getResultType());  
                } else {
         * the request can not execute with the current mapping and should wait for a new mapping  
                    Engine.IndexResult indexResult = (Engine.IndexResult) result;  
    }
        /**
    /** returns the primary shard */
                        result.getTerm(),
    public void markOperationAsNoOp(DocWriteResponse response) {
    /** resets the current item state, prepare for a new execution */  
        assert hasMoreOperationsToExecute() == false;  
 * This is a utility class that holds the per request state needed to perform bulk operations on the primary.
                break;
    }
            return;
         * No further handling of current request is needed. The result has been converted to a user response
        requestToExecute = writeRequest;
                        result.getSeqNo(),
        assertInvariants(ItemProcessingState.WAIT_FOR_MAPPING_UPDATE, ItemProcessingState.EXECUTED);
        return response != null && response.isFailed() && response.getFailure().isAborted();  
        executionResult = new BulkItemResponse(getCurrentItem().id(), getCurrentItem().request().opType(), response);
                            docWriteRequest.id(),
 *     http://www.apache.org/licenses/LICENSE-2.0
                assert executionResult != null;
 */  
     * returns true if the current request is in INITIAL state
                        deleteResult.getSeqNo(),
 * to stop and wait for external events such as mapping updates.  
        assertInvariants(ItemProcessingState.TRANSLATED);
                    );  
package org.opensearch.action.bulk;
        currentItemState = ItemProcessingState.EXECUTED;  
 *
    }  
        mergeLocationToSync(batch.finish());
    }
        COMPLETED
     * sync, and unregisters it. Idempotent: the second and later calls do nothing, so the caller's finally block is  
/*
import org.opensearch.common.Nullable;  
                            request.index(),
    enum ItemProcessingState {  
    public BulkShardResponse buildShardResponse(long serviceTimeEWMAInNanos, int nodeQueueSize) {
    /** indicates that the operation needs to be failed as the required mapping didn't arrive in time */  
 * specific language governing permissions and limitations
    private BulkItemRequest getCurrentItem() {
        this.primaryResponses = new BulkItemResponse[request.items().length];
            docWriteRequest.opType(),
                } else {
                            result.getTerm()
    public void finishTranslogBatch() {
                assert executionResult != null;  
    /**
        return currentItemState == ItemProcessingState.WAIT_FOR_MAPPING_UPDATE;
        assert this.translogBatch == null : "a translog batch is already registered for this execution";  
                if (result.getOperationType() == Engine.Operation.TYPE.INDEX) {
    /** returns the name of the index the current request used */  
        return request.items()[currentIndex];
        switch (result.getResultType()) {
import org.opensearch.action.index.IndexResponse;
        currentItemState = ItemProcessingState.TRANSLATED;
     * Registers the translog batch scope opened for the current execution of this request on the current thread. A
     */  
                            result.getFailure(),  
         * This is needed to support retry on conflicts during updates.
    /**
 * Modifications Copyright OpenSearch Contributors. See
 */  
    private final BulkShardRequest request;
                break;
        /** The request has been executed on the primary shard (successfully or not) */
        advance();  
     * is appended), and {@link org.opensearch.index.engine.Engine.TranslogBatch#finish()} reports the greatest location  
        }
        final DocWriteRequest<?> docWriteRequest = getCurrentItem().request();
            case FAILURE:
        DocWriteRequest<?> docWriteRequest = getRequestToExecute();
        executionResult = null;
        /** Item execution is ready to start, no operations have been performed yet */
    public BulkItemResponse getExecutionResult() {
         */  
    }
        return request.setPrimaryResponses(primaryResponses);  
        this.primary = primary;
import org.opensearch.action.DocWriteRequest;
        return currentIndex < request.items().length;  
    @SuppressWarnings("unchecked")
        assertInvariants(ItemProcessingState.EXECUTED);  
    /**
 * software distributed under the License is distributed on an
    /**
        if (translatedResponse.isFailed() == false && requestToExecute != null && requestToExecute != getCurrent()) {
/*  
                // A batched index result has no location yet; its chunk's location is folded in on flush/finish.
        assertInvariants(ItemProcessingState.COMPLETED);  
     */
                break;
        assert assertInvariants(ItemProcessingState.TRANSLATED);  
    }
    }
            case WAIT_FOR_MAPPING_UPDATE:
                        // concrete index instead of an alias if used!
    /** completes the operation without doing anything on the primary */
    /** indicates that the current operation can not be completed and needs to wait for a new mapping from the cluster-manager */
    /** returns true if the request needs to wait for a mapping update to arrive from the cluster-manager */
        return retryCounter;
                assert executionResult == null : executionResult;
     * safe after a mapping-update yield has already finished the scope. If {@code finish()} throws, the scope is still
         */
                mergeLocationToSync(result.getTranslogLocation());  
    private static boolean isAborted(BulkItemResponse response) {
                        requestToExecute.id(),
import org.opensearch.action.delete.DeleteResponse;  
                    // set a blank ShardInfo so we can safely send it to the replicas. We won't use it in the real response though.  
         */  
                        primary.shardId(),  
            case COMPLETED:
     * returns true if the current request has been completed and it's result translated to a user
            return;  
        requestToExecute = null;
class BulkPrimaryExecutionContext {
        if (location == null) {
import org.opensearch.core.index.AppendOnlyIndexOperationRetryException;
        executionResult = new BulkItemResponse(
        return currentItemState == ItemProcessingState.INITIAL;
    }  
        currentItemState = ItemProcessingState.INITIAL;  
        assert executionResult != null && translatedResponse.getItemId() == executionResult.getItemId();
        }  
 * the Apache License, Version 2.0 (the "License"); you may
                    Engine.DeleteResult deleteResult = (Engine.DeleteResult) result;
 * Licensed to Elasticsearch under one or more contributor  
     * received from the user (specifically, an update request is translated to an indexing or delete request).  
                // set a blank ShardInfo so we can safely send it to the replicas. We won't use it in the real response though.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final BulkItemRequest current = getCurrentItem();  
         * The incoming request has been translated to a request that can be executed on the shard.
        final Engine.TranslogBatch batch = translogBatch;
    }
         * This is used to convert update requests to a fully specified index or delete requests.
    private ItemProcessingState currentItemState;
        while (startIndex < length && isAborted(request.items()[startIndex].primaryResponse())) {
     * scope is owned by exactly one execution; a mapping-update yield finishes it before the request is re-executed.  
import org.opensearch.action.support.replication.ReplicationResponse;
            // concrete index instead of an alias if used!  
        assert retryCounter >= 0 : retryCounter;
        return executionResult;  
        currentIndex = findNextNonAborted(currentIndex + 1);
        translogBatch = null;  
     * returns true if {@link #advance()} has moved the current item beyond the
            case EXECUTED:  
        if (locationToSync == null || location.compareTo(locationToSync) > 0) {
    public boolean hasMoreOperationsToExecute() {
    public boolean requiresWaitingForMappingUpdate() {  
                assert requestToExecute == null;  
 * this work for additional information regarding copyright
        currentItemState = ItemProcessingState.EXECUTED;
        switch (currentItemState) {
    private int findNextNonAborted(int startIndex) {  
            + Arrays.toString(expectedCurrentState);
    }
 * license agreements. See the NOTICE file distributed with
                        indexResult.getVersion(),  
        return locationToSync;
                        primary.shardId(),  
        // we always get to the end of the list by using advance, which in turn sets the state to INITIAL
        primaryResponses[currentIndex] = translatedResponse;
    }
    private Translog.Location locationToSync = null;  
    }
     */
/*  
 */
     * flush. Taking the maximum keeps every operation of the request, batched or inline, covered by the final sync.
                    executionResult.getResponse().setShardInfo(new ReplicationResponse.ShardInfo());
 */  
        }  
    private int retryCounter;
 *  
 * The OpenSearch Contributors require contributions made to  
import java.util.Objects;
    private void advance() {
import org.opensearch.index.engine.Engine;
                        )  
        /**
    private int currentIndex = -1;  
                    executionResult = new BulkItemResponse(current.id(), current.request().opType(), indexResponse);
    public void setTranslogBatch(Engine.TranslogBatch translogBatch) {
                assert requestToExecute == null : requestToExecute;
    /** the current operation has been executed on the primary with the specified result */  
        /**  
                if (result.getFailure() instanceof AppendOnlyIndexOperationRetryException) {  
                executionResult.getResponse().setShardInfo(new ReplicationResponse.ShardInfo());
    public void failOnMappingUpdate(Exception cause) {
                        indexResult.getVersion(),
                assert executionResult == null : executionResult;  
        /**  
    /**
import java.util.Arrays;  
    private BulkItemResponse executionResult;
                executionResult = new BulkItemResponse(current.id(), current.request().opType(), response);
        return primary;
            getCurrentItem().id(),  
        advance();
 * not use this file except in compliance with the License.
    private DocWriteRequest<?> requestToExecute;  
     * Finishes the registered translog batch, if any, folding the greatest location it appended into the location to
    /** move to the next item to execute */  
        assert assertInvariants(ItemProcessingState.WAIT_FOR_MAPPING_UPDATE);  
    }  
    BulkPrimaryExecutionContext(BulkShardRequest request, IndexShard primary) {
         * submitted
            case INITIAL:  
/**  
    }
                        result.getSeqNo(),
         */  
                } else if (result.getOperationType() == Engine.Operation.TYPE.DELETE) {  
        INITIAL,
     * Locations are no longer guaranteed to arrive in increasing order once index operations are batched: a deferred
        assert assertInvariants(ItemProcessingState.TRANSLATED);  
                break;  
    }
    public int getRetryCounter() {
                }
    /** returns the number of times the current operation has been retried */  
                        requestToExecute.id(),
                    );  
        );
 * KIND, either express or implied.  See the License for the
    /** gets the current, untranslated item request */  
}  
            new BulkItemResponse.Failure(getCurrentItem().index(), docWriteRequest.id(), cause)
        requestToExecute = null;
    /** returns the result of the request that has been executed on the shard */  
        return getCurrentItem().request();
        currentItemState = ItemProcessingState.WAIT_FOR_MAPPING_UPDATE;
import org.opensearch.index.translog.Translog;
            startIndex++;  
                    response = new IndexResponse(
 * compatible open source license.
                        requestToExecute.id(),  
            case TRANSLATED, IMMEDIATE_RETRY:
                break;  
                }
                        deleteResult.isFound()
            + currentItemState  
                assert executionResult == null : executionResult;
            // Make sure to use getCurrentItem().index() here, if you use docWriteRequest.index() it will use the
    }
                break;  
        this.request = request;  
                            result.getSeqNo(),
     */
                        current.id(),
        assertInvariants(ItemProcessingState.INITIAL);
                // requestToExecute can be null if the update ended up as NOOP
    }
         * The request should be executed again, but there is no need to wait for an external event.  
    public void markAsRequiringMappingUpdate() {
                    response = new DeleteResponse(
        return (T) requestToExecute;
    }
        return new BulkShardResponse(request.shardId(), primaryResponses, serviceTimeEWMAInNanos, nodeQueueSize);
    }  
     * facing response  
                        // use docWriteRequest.index() it will use the
        currentItemState = ItemProcessingState.INITIAL;
    }
    public void setRequestToExecute(DocWriteRequest<?> writeRequest) {
                assert primaryResponses[currentIndex] != null;
                        indexResult.isCreated()
            locationToSync = location;  
        return currentItemState == ItemProcessingState.COMPLETED;  
                        deleteResult.getVersion(),
        }
    private final BulkItemResponse[] primaryResponses;  
     * index result carries a null location when {@link #markOperationAsExecuted} runs (it is folded in when its chunk
    }
     * <p>  
        }
    }
                        result.getTerm(),  
        if (batch == null) {  
 *
 * this file be licensed under the Apache-2.0 license or a
                final DocWriteResponse response;
     * end of the {@link BulkShardRequest#items()} array.  
     * unregistered (it has failed and completed every pending reader exceptionally) and the exception propagates.
 * You may obtain a copy of the License at  
            request.items()[currentIndex] = new BulkItemRequest(request.items()[currentIndex].id(), requestToExecute);
                break;
        return getCurrentItem().index();
        currentItemState = ItemProcessingState.COMPLETED;
         * and execution can continue to the next item (if available).
        assertInvariants(ItemProcessingState.EXECUTED);  
        assertInvariants(ItemProcessingState.INITIAL);  
            : "moving to next but current item wasn't completed (state: " + currentItemState + ")";  
    public IndexShard getPrimary() {  
    public boolean isInitial() {  
    private boolean assertInvariants(ItemProcessingState... expectedCurrentState) {
        retryCounter++;  
        assert Arrays.asList(expectedCurrentState).contains(currentItemState) : "expected current state ["
                    executionResult = new BulkItemResponse(  
 * @opensearch.internal
        executionResult = null;
    public BulkShardRequest getBulkShardRequest() {
    @Nullable
 * under the License.  
    public void mergeLocationToSync(@Nullable Translog.Location location) {
     * Folds a translog {@link Translog.Location} into {@code locationToSync}, keeping the greatest one seen so far.
 * ownership. Elasticsearch licenses this file to you under  
            + "] to be one of "
                        indexResult.isCreated()
    /**
        assert assertInvariants(ItemProcessingState.INITIAL);  
        IMMEDIATE_RETRY,  
        TRANSLATED,
import org.opensearch.action.DocWriteResponse;
        assert currentItemState == ItemProcessingState.COMPLETED || currentIndex == -1
     */  
        assert currentIndex >= 0 : currentIndex;  
                assert requestToExecute != null;
 *
import org.opensearch.index.shard.IndexShard;  
                    Engine.IndexResult indexResult = (Engine.IndexResult) result;
    public DocWriteRequest<?> getCurrent() {
    public String getConcreteIndex() {
     * the batch appended, which is older than an update, delete or no-op the engine wrote inline after the last chunk
        assert translatedResponse.getItemId() == getCurrentItem().id();
        EXECUTED,
    }
        assert assertInvariants(ItemProcessingState.INITIAL);  
            case SUCCESS:  
    private final IndexShard primary;
        return true;
                        primary.shardId(),
        }
        requestToExecute = null;
        assert assertInvariants(ItemProcessingState.EXECUTED);
        currentItemState = ItemProcessingState.EXECUTED;
        this.translogBatch = Objects.requireNonNull(translogBatch);
         * to arrive from the cluster-manager. A mapping request for the needed changes has already been
     */
    public void markOperationAsExecuted(Engine.Result result) {
        assert assertInvariants(ItemProcessingState.WAIT_FOR_MAPPING_UPDATE);
    }
    }  
                    );
        assert assertInvariants(ItemProcessingState.TRANSLATED);  
 * More specifically, it maintains an index to the current executing bulk item, which allows execution
    }
        return startIndex;
     */
    }
    public boolean isCompleted() {
    /** builds the bulk shard response to return to the user */
                        new BulkItemResponse.Failure(  
    /** finishes the execution of the current request, with the response that should be returned to the user */
    private Engine.TranslogBatch translogBatch = null;
     * sets the request that should actually be executed on the primary. This can be different from the request
        retryCounter = 0;  
 * GitHub history for details.
        WAIT_FOR_MAPPING_UPDATE,
                    );
