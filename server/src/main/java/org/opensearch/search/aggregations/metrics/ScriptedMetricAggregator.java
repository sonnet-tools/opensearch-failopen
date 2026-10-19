        State state = states.get(owningBucketOrdinal);
        SearchLookup lookup,
    }
import org.opensearch.common.util.ObjectArray;  
            return new State();
        Aggregator parent,  
    private final ScriptedMetricAggContexts.CombineScript.Factory combineScriptFactory;
    private final Map<String, Object> mapScriptParams;  
    @Override
            mapScript = mapScriptFactory.newFactory(
        this.mapScriptFactory = mapScriptFactory;
    private final Map<String, Object> combineScriptParams;
    }
    private final Map<String, Object> aggParams;
        if (result != null && result.getClass() != ScriptedAvg.class) {
        private final Map<String, Object> combineScriptParamsForState;  
     * untracked java collections for its state it is going to both be  
            State state = states.get(i);
    @Override
import org.opensearch.search.lookup.SearchLookup;
        this.mapScriptParams = mapScriptParams;  
    public InternalAggregation buildEmptyAggregation() {  
        for (long i = 0; i < states.size(); i++) {  
    private final ScriptedMetricAggContexts.MapScript.Factory mapScriptFactory;
import org.apache.lucene.search.Scorable;
/*  
            }  
     * us here. Or that folks just don't use the aggregation.
            // Its possible for building the initial state to mutate the parameters as a side effect
                    state = new State();  
                if (state == null) {
        }  
/*  
class ScriptedMetricAggregator extends MetricsAggregator {  
        Map<String, Object> aggParams,  
        private final ScriptedMetricAggContexts.MapScript.LeafFactory mapScript;
        }
 *  
    }
        CollectionUtils.ensureNoSelfReferences(state.aggState, "Scripted metric aggs map script");
                State state = states.get(owningBucketOrd);  
import org.opensearch.search.aggregations.InternalAggregation;
            @Override
            return result;  
 */
/**
    @Override  
        Map<String, Object> initScriptParams,
 */  
        Map<String, Object> metadata
                this.scorer = scorer;  
/*
        };
            public void collect(int doc, long owningBucketOrd) throws IOException {
        return new InternalScriptedMetric(name, singletonList(result), reduceScript, metadata());
 * @opensearch.internal
            Object result = combineScriptFactory.newInstance(combineScriptParamsForState, aggState).execute();
            mapScriptParamsForState = ScriptedMetricAggregatorFactory.mergeParams(aggParamsForState, mapScriptParams);
        return new InternalScriptedMetric(name, singletonList(null), reduceScript, metadata());
     * Estimated cost to maintain a bucket. Since this aggregator uses
                    states.set(owningBucketOrd, state);
                if (state.leafMapScript == null) {  
            return new State();  
    }
        super(name, context, parent, metadata);  
        }
                states = context.bigArrays().grow(states, owningBucketOrd + 1);
 * SPDX-License-Identifier: Apache-2.0
            }
 * specific language governing permissions and limitations
        private Map<String, Object> newInitialState(Map<String, Object> initScriptParamsForState) {
 * compatible open source license.
import org.opensearch.search.aggregations.Aggregator;  
                }
                aggState,  
 */  
        Object result = aggStateForResult(owningBucketOrdinal).combine();  
     * much "heavier" than a normal metric aggregator and not going to be
 * Licensed to Elasticsearch under one or more contributor  
        if (owningBucketOrdinal >= states.size()) {
    private State aggStateForResult(long owningBucketOrdinal) {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
    ScriptedMetricAggregator(  
    @Nullable
        private final Map<String, Object> aggState;
    private ObjectArray<State> states;
                ScriptedMetricAggregatorFactory.deepCopyParams(mapScriptParamsForState, context),
 * GitHub history for details.
    @Override
    public InternalAggregation buildAggregation(long owningBucketOrdinal) {
        private final Map<String, Object> mapScriptParamsForState;
            StreamOutput.checkWriteable(result);
        State() {
        states = context.bigArrays().newObjectArray(1);
                }  
            }
                continue;  
        ScriptedMetricAggContexts.CombineScript.Factory combineScriptFactory,
        private MapScript leafMapScript;
 * under the License.  
        String name,
 */
 *
    @Override
 *  
            initScriptFactory.newInstance(initScriptParamsForState, initialState).execute();
import java.util.Map;  
        return ScoreMode.COMPLETE; // TODO: how can we know if the script relies on scores?  
import java.io.IOException;
            if (initScriptFactory == null) {  
        Map<String, Object> mapScriptParams,
 * The OpenSearch Contributors require contributions made to  
    private class State {  
    private final Script reduceScript;  
import org.opensearch.common.lease.Releasables;
        return state;
import static java.util.Collections.singletonList;
        this.initScriptParams = initScriptParams;
        this.aggParams = aggParams;
        // The last script that touched the state at this point is the "map" script  
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * You may obtain a copy of the License at  
                    addRequestCircuitBreakerBytes(BUCKET_COST_ESTIMATE);
            }
    public ScoreMode scoreMode() {
            CollectionUtils.ensureNoSelfReferences(initialState, "Scripted metric aggs init script");
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.ScoreMode;  
package org.opensearch.search.aggregations.metrics;
        SearchContext context,
            public void setScorer(Scorable scorer) throws IOException {
import org.opensearch.common.Nullable;
            Map<String, Object> aggParamsForState = ScriptedMetricAggregatorFactory.deepCopyParams(aggParams, context);  
        }  
    public void doClose() {
 * not use this file except in compliance with the License.
        this.initScriptFactory = initScriptFactory;  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * Aggregate all docs based on a value script
        ScriptedMetricAggContexts.MapScript.Factory mapScriptFactory,  
     * tracked by the circuit breakers properly. This is sad. So we pick a big
                state.leafMapScript.setDocument(doc);
    private static final long BUCKET_COST_ESTIMATE = 1024 * 5;
        }  
            Map<String, Object> initialState = new HashMap<>();  
import org.opensearch.core.common.util.CollectionUtils;
 * software distributed under the License is distributed on an
     * inaccurate. We're sort of hoping that the real memory breaker saves
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            CollectionUtils.ensureNoSelfReferences(result, "Scripted metric aggs combine script");
    ) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        Map<String, Object> combineScriptParams,  
            return initialState;  
import org.opensearch.search.internal.SearchContext;
        private Object combine() {  
        // Clear any old leaf scripts so we rebuild them on the new leaf when we first see them.
    private final ScriptedMetricAggContexts.InitScript.Factory initScriptFactory;  
    private final SearchLookup lookup;  
            private Scorable scorer;
    }  
        this.combineScriptFactory = combineScriptFactory;
                state.leafMapScript.execute();
            @Override  
        this.reduceScript = reduceScript;  
        return new LeafBucketCollectorBase(sub, null) {
import java.util.HashMap;
    private final Map<String, Object> initScriptParams;
    /**
 * KIND, either express or implied.  See the License for the
                lookup
                return new HashMap<>();
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
import org.opensearch.search.aggregations.LeafBucketCollector;
 * license agreements. See the NOTICE file distributed with
                    state.leafMapScript = state.mapScript.newInstance(ctx);
    }
        Releasables.close(states);  
            }  
import org.opensearch.script.ScriptedMetricAggContexts;
        @Nullable ScriptedMetricAggContexts.InitScript.Factory initScriptFactory,
import org.apache.lucene.index.LeafReaderContext;
        this.combineScriptParams = combineScriptParams;
    }  
     */  
     * number and estimate that each bucket costs that. It could be wildly  
            if (combineScriptFactory == null) {
        Script reduceScript,
            if (state == null) {
                return aggState;
        if (state == null) {  
 * this work for additional information regarding copyright
        this.lookup = lookup;
            combineScriptParamsForState = ScriptedMetricAggregatorFactory.mergeParams(aggParamsForState, combineScriptParams);
                    state.leafMapScript.setScorer(scorer);
        }
import org.opensearch.script.ScriptedMetricAggContexts.MapScript;
            aggState = newInitialState(ScriptedMetricAggregatorFactory.mergeParams(aggParamsForState, initScriptParams));  
 *
            );
            state.leafMapScript = null;
import org.opensearch.script.Script;  
}
