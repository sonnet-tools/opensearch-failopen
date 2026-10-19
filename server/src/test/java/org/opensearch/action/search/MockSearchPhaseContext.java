                numShards,
        return searchRequest;
 * compatible open source license.
    final Set<ShardSearchContextId> releasedSearchContexts = new HashSet<>();  
                0,
                searchContextId
            ? TransportSearchHelper.buildScrollId(queryResults, Version.CURRENT)
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    final List<ShardSearchFailure> failures = Collections.synchronizedList(new ArrayList<>());
 * this file be licensed under the Apache-2.0 license or a
    @Override
        Assert.fail("should not be called");
                numSuccess.get(),  
 * Licensed to Elasticsearch under one or more contributor  
        return null; // null is ok here for this test
}
/**
        this(numShards, searchRequest, null);
                scrollId,
            : null;  
import org.opensearch.transport.Transport;  
import org.opensearch.common.lease.Releasable;
    }
    public void onFailure(Exception e) {  
        phaseFailure.set(cause);  
                SearchResponse.Clusters.EMPTY,
    @Override
public final class MockSearchPhaseContext implements SearchPhaseContext {
    }
    }
    public void sendSearchResponse(InternalSearchResponse internalSearchResponse, AtomicArray<SearchPhaseResult> queryResults) {
 * You may obtain a copy of the License at  
    public void execute(Runnable command) {
        return null;
    private static final Logger logger = LogManager.getLogger(MockSearchPhaseContext.class);  
 * specific language governing permissions and limitations
    public MockSearchPhaseContext(int numShards) {
     * Set the resource usage info for this phase
    /**
        }
import org.opensearch.action.OriginalIndices;  
 * Modifications Copyright OpenSearch Contributors. See  
        this.numShards = numShards;
        return searchTransport;
        numSuccess.decrementAndGet();  
import java.util.concurrent.atomic.AtomicReference;  
    }  
 * under the License.  
        failures.add(new ShardSearchFailure(e, shardTarget));
    }
    @Override
        // Noop  
    @Override
    public MockSearchPhaseContext(int numShards, SearchRequest searchRequest, SearchPhase currentPhase) {
    @Override  
    @Override
    @Override  
        }  
    }
 * GitHub history for details.
            nextPhase.run();
    }  
        try {
        this.currentPhase = currentPhase;
     */  
            onPhaseFailure(nextPhase, "phase failed", e);
import java.util.ArrayList;  
    public void executeNextPhase(SearchPhase currentPhase, SearchPhase nextPhase) {  
    }  
import org.apache.logging.log4j.LogManager;  
 * this work for additional information regarding copyright
 */  
    }
    public int getNumShards() {
    public void addReleasable(Releasable releasable) {  
    }
import org.opensearch.common.util.concurrent.AtomicArray;  
        this.searchRequest = searchRequest;  
        } catch (Exception e) {  
 * SPDX-License-Identifier: Apache-2.0
        return currentPhase;
    public SearchTransportService getSearchTransport() {  
 * KIND, either express or implied.  See the License for the
    @Override
            new SearchResponse(
 * Unless required by applicable law or agreed to in writing,
    public void setPhaseResourceUsages() {
    final AtomicReference<Throwable> phaseFailure = new AtomicReference<>();
    @Override
    @Override
        numSuccess = new AtomicInteger(numShards);
    public MockSearchPhaseContext(int numShards, SearchRequest searchRequest) {  
import org.opensearch.search.internal.ShardSearchContextId;
 * ownership. Elasticsearch licenses this file to you under  
/*
            )  
import java.util.Collections;
    }  
    public void assertNoFailure() {  
        this(numShards, new SearchRequest(), currentPhase);  
        command.run();
    }
    final int numShards;
    @Override
import java.util.List;  
    }
    public SearchRequest getRequest() {
        String scrollId = getRequest().scroll() != null ? TransportSearchHelper.buildScrollId(queryResults, Version.CURRENT) : null;  
                0,
import java.util.HashSet;
        // Noop
 * software distributed under the License is distributed on an
        searchResponse.set(
    public MockSearchPhaseContext(int numShards, SearchPhase currentPhase) {
import org.apache.logging.log4j.Logger;
 *
        );
    @Override  
    SearchTransportService searchTransport;
/*  
    }
 * license agreements. See the NOTICE file distributed with
 *
import org.opensearch.search.SearchPhaseResult;
import java.util.Set;
    public Logger getLogger() {  
import org.opensearch.search.internal.InternalSearchResponse;  
import java.util.concurrent.atomic.AtomicInteger;
    public Transport.Connection getConnection(String clusterAlias, String nodeId) {
    public void sendReleaseSearchContext(ShardSearchContextId contextId, Transport.Connection connection, OriginalIndices originalIndices) {
 * the Apache License, Version 2.0 (the "License"); you may
 *  
import org.opensearch.search.SearchShardTarget;
    @Override  
        return new SearchTask(0, "n/a", "n/a", () -> "test", null, Collections.emptyMap());  
    final SearchRequest searchRequest;
    public void onShardFailure(int shardIndex, @Nullable SearchShardTarget shardTarget, Exception e) {
 * SearchPhaseContext for tests  
        Assert.fail("should not be called");
        return numShards;
    @Override  
    }
 */
        String searchContextId = getRequest().pointInTimeBuilder() != null
                internalSearchResponse,  
    final AtomicInteger numSuccess;  
        Assert.assertNotNull(searchTransport);
        return logger;
        this(numShards, new SearchRequest());  
                failures.toArray(ShardSearchFailure.EMPTY_ARRAY),  
    }  
    }
    final AtomicReference<SearchResponse> searchResponse = new AtomicReference<>();
 * The OpenSearch Contributors require contributions made to  
    final SearchPhase currentPhase;  
    }
import org.junit.Assert;
    public SearchPhase getCurrentPhase() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 */
    @Override
import org.opensearch.Version;
import org.opensearch.common.Nullable;
    @Override
    public ShardSearchRequest buildShardSearchRequest(SearchShardIterator shardIt) {  
 */
 * not use this file except in compliance with the License.
            throw new AssertionError(phaseFailure.get());
    @Override
        releasedSearchContexts.add(contextId);  
    public void onPhaseFailure(SearchPhase phase, String msg, Throwable cause) {
package org.opensearch.action.search;
    }  
    }  
    }  
import org.opensearch.search.internal.ShardSearchRequest;
        if (phaseFailure.get() != null) {
    public SearchTask getTask() {
