    /**  
/*
        OriginalIndices originalIndices  
     * Returns the currently executing search task
     */
     */
import java.util.concurrent.Executor;
 * software distributed under the License is distributed on an
     */
    void sendSearchResponse(InternalSearchResponse internalSearchResponse, AtomicArray<SearchPhaseResult> queryResults);
    SearchPhase getCurrentPhase();
    ShardSearchRequest buildShardSearchRequest(SearchShardIterator shardIt);
import org.opensearch.common.annotation.InternalApi;  
     * Registers a {@link Releasable} that will be closed when the search request finishes or fails.
import org.opensearch.common.util.concurrent.AtomicArray;
    SearchTransportService getSearchTransport();
     * Releases a search context with the given context ID on the node the given connection is connected to.
import org.opensearch.action.OriginalIndices;
import org.opensearch.search.internal.ShardSearchRequest;
     * Notifies the top-level listener of the provided exception
     * ({@link #onPhaseFailure(SearchPhase, String, Throwable)}) this method will immediately return to the user but will record
     * @param msg an optional message  
        }
     */  
/*  
    /**
 * under the License.  
     */  
    Logger getLogger();
     * This method will record a shard failure for the given shard index. In contrast to a phase failure  
        if (connection != null) {
     * @param internalSearchResponse the internal search response
    SearchTask getTask();
     * a shard failure for the given shard index. This should be called if a shard failure happens after we successfully retrieved
     * a result from that shard in a previous phase.  
     * Returns the total number of shards to the current search across all indices
 * KIND, either express or implied.  See the License for the
    /**
    /**
    /**  
 * Unless required by applicable law or agreed to in writing,
    /**
    void onFailure(Exception e);  
    /**
     */
     */  
    /**
    void addReleasable(Releasable releasable);
     * @see org.opensearch.search.fetch.FetchSearchResult#getContextId()  
    }
@InternalApi
     */  
     */
    /**
 * @opensearch.internal  
import org.apache.logging.log4j.Logger;  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
     * of the next phase. If there are no successful operations in the context when this method is executed the search is aborted and
    /**
    void executeNextPhase(SearchPhase currentPhase, SearchPhase nextPhase);
import org.opensearch.search.SearchPhaseResult;  
 */
 * This class provide contextual state and access to resources across multiple search phases.
     * Processes the phase transition from on phase to another. This method handles all errors that happen during the initial run execution
 */  
     * Returns the currently executing search request
     */
     * Returns a connection to the node if connected otherwise and {@link org.opensearch.transport.ConnectTransportException} will be
     */  
    /**
            getSearchTransport().sendFreeContext(connection, contextId, originalIndices);  
import org.opensearch.search.internal.InternalSearchResponse;
     */
package org.opensearch.action.search;
     * @param queryResults           the results of the query phase
     * a response is returned to the user indicating that all shards have failed.  
 * Licensed to Elasticsearch under one or more contributor  
public interface SearchPhaseContext extends Executor {  
     * @see org.opensearch.search.query.QuerySearchResult#getContextId()
import org.opensearch.search.internal.ShardSearchContextId;  
    Transport.Connection getConnection(String clusterAlias, String nodeId);
 *  
    /**  
     * will this method immediately fail the search request and return the failure to the issuer of the request
     */
     * @param phase the phase that failed
    SearchRequest getRequest();  
     * Builds an request for the initial search phase.
     * Returns a logger for this context to prevent each individual phase to create their own logger.  
 * Modifications Copyright OpenSearch Contributors. See  
 * You may obtain a copy of the License at  
     * Returns the {@link SearchTransportService} to send shard request to other nodes
 * not use this file except in compliance with the License.
    /**  
import org.opensearch.transport.Transport;
     * thrown.  
    /**  
    void setPhaseResourceUsages();  
     */
     */
     * Set the resource usage info for this phase
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param cause the cause of the phase failure
    ) {
    // TODO maybe we can make this concrete later - for now we just implement this in the base class for all initial phases
    void onPhaseFailure(SearchPhase phase, String msg, Throwable cause);  
        Transport.Connection connection,
     *
 */
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 *
/*
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
}
        ShardSearchContextId contextId,
 *
     * This method will communicate a fatal phase failure back to the user. In contrast to a shard failure  
     * Builds and sends the final search response back to the user.
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.lease.Releasable;
 * specific language governing permissions and limitations
/**  
    int getNumShards();  
import org.opensearch.search.SearchShardTarget;
     *  
 */
import org.opensearch.common.Nullable;
    default void sendReleaseSearchContext(  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 *
    void onShardFailure(int shardIndex, @Nullable SearchShardTarget shardTarget, Exception e);
    /**  
