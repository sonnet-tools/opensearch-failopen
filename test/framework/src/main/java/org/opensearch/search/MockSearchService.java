            indicesService,
import java.util.concurrent.Executor;
import java.util.concurrent.ConcurrentHashMap;  
                "There are still ["
    }  
import org.opensearch.search.fetch.FetchPhase;
 * license agreements. See the NOTICE file distributed with
                    + copy.size()
                copy.values().iterator().next()
            clusterService,
        final ReaderContext removed = super.removeReaderContext(id);  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.util.BigArrays;
        );  
        super(  
import org.opensearch.search.internal.ReaderContext;  
        Executor indexSearcherExecutor,
        WorkloadGroupService workloadGroupService
package org.opensearch.search;
 * ownership. Elasticsearch licenses this file to you under  
 */
            indexSearcherExecutor,
    public static class TestPlugin extends Plugin {}
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
 */  
        CircuitBreakerService circuitBreakerService,
            queryPhase,  
            );
        TaskResourceTrackingService taskResourceTrackingService,  
    }  
import org.opensearch.node.MockNode;
 */  
    /**
    }
import org.opensearch.tasks.TaskResourceTrackingService;
        }  
    @Override  
import java.util.HashMap;
    protected void putReaderContext(ReaderContext context) {
 * software distributed under the License is distributed on an
 *
            bigArrays,
        }  
    }
     * Clear an active search context from the list of tracked contexts. Package private for testing.
     */
    public void setOnPutContext(Consumer<ReaderContext> onPutContext) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.script.ScriptService;
        if (copy.isEmpty() == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    ) {
    private static final Map<ReaderContext, Throwable> ACTIVE_SEARCH_CONTEXTS = new ConcurrentHashMap<>();
        super.putReaderContext(context);
     * Add an active search context to the list of tracked contexts. Package private for testing.
        this.onPutContext = onPutContext;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.service.ClusterService;
    /** Throw an {@link AssertionError} if there are still in-flight contexts. */
            workloadGroupService
}
        return removed;
    public MockSearchService(
/*  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
    static void addActiveContext(ReaderContext context) {  
     */  
import org.opensearch.search.query.QueryPhase;
 * SPDX-License-Identifier: Apache-2.0
public class MockSearchService extends SearchService {
 * You may obtain a copy of the License at  
        addActiveContext(context);  
    /**  
 *
 * compatible open source license.
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
            Collections.emptyList(),  
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.plugins.Plugin;  
    }
import org.opensearch.wlm.WorkloadGroupService;
     */
            Collections.emptyList(),
        ScriptService scriptService,  
    }
 * Modifications Copyright OpenSearch Contributors. See
            scriptService,
/*  
/*
        ClusterService clusterService,  
        ACTIVE_SEARCH_CONTEXTS.remove(context);
            removeActiveContext(removed);
    protected ReaderContext removeReaderContext(long id) {
        BigArrays bigArrays,
    }
        ACTIVE_SEARCH_CONTEXTS.put(context, new RuntimeException(context.toString()));
    private Consumer<ReaderContext> onPutContext = context -> {};  
 * GitHub history for details.
    public static void assertNoInFlightContext() {  
    static void removeActiveContext(ReaderContext context) {
            threadPool,  
            null,
     * Marker plugin used by {@link MockNode} to enable {@link MockSearchService}.  
            taskResourceTrackingService,
        if (removed != null) {
import java.util.function.Consumer;
 * specific language governing permissions and limitations
            circuitBreakerService,  
import org.opensearch.indices.IndicesService;
import java.util.Collections;  
        QueryPhase queryPhase,
        onPutContext.accept(context);
import java.util.Map;
        IndicesService indicesService,
        FetchPhase fetchPhase,  
            throw new AssertionError(  
                    + "] in-flight contexts. The first one's creation site is listed as the cause of this exception.",  
        ThreadPool threadPool,
        final Map<ReaderContext, Throwable> copy = new HashMap<>(ACTIVE_SEARCH_CONTEXTS);
            fetchPhase,
    /**
