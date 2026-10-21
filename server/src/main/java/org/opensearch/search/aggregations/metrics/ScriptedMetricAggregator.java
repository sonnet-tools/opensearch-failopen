import org.apache.lucene.index.LeafReaderContext;
        Map<String, Object> initScriptParams,
        ScriptedMetricAggContexts.MapScript.Factory mapScriptFactory,
                    state.leafMapScript.setScorer(scorer);
        CollectionUtils.ensureNoSelfReferences(state.aggState, "Scripted metric aggs map script");
    /**
                continue;
import java.util.HashMap;
        private final Map<String, Object> combineScriptParamsForState;
 * compatible open source license.
    }
     * much "heavier" than a normal metric aggregator and not going to be
 * GitHub history for details.
            mapScriptParamsForState = ScriptedMetricAggregatorFactory.mergeParams(aggParamsForState, mapScriptParams);
        this.combineScriptFactory = combineScriptFactory;
package org.opensearch.search.aggregations.metrics;
        Map<String, Object> mapScriptParams,
        private final Map<String, Object> mapScriptParamsForState;
     * us here. Or that folks just don't use the aggregation.
 *
            return new State();
    }
    public InternalAggregation buildEmptyAggregation() {
        }
        Map<String, Object> aggParams,
import java.util.Map;
        this.combineScriptParams = combineScriptParams;
        this.initScriptParams = initScriptParams;
        }
     * tracked by the circuit breakers properly. This is sad. So we pick a big
        Script reduceScript,
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
class ScriptedMetricAggregator extends MetricsAggregator {
 * Unless required by applicable law or agreed to in writing,
    ) throws IOException {
import org.opensearch.search.aggregations.LeafBucketCollector;
            }
            return result;
    @Override
                state.leafMapScript.execute();
        return new InternalScriptedMetric(name, singletonList(result), reduceScript, metadata());
 * The OpenSearch Contributors require contributions made to
 */
            Map<String, Object> initialState = new HashMap<>();
import org.apache.lucene.search.Scorable;
import org.apache.lucene.search.ScoreMode;
                this.scorer = scorer;
    @Override
    ScriptedMetricAggregator(
            }
    public void doClose() {
/*
     * untracked java collections for its state it is going to both be
            }
                    addRequestCircuitBreakerBytes(BUCKET_COST_ESTIMATE);
        this.lookup = lookup;
        }
                if (state == null) {
        Aggregator parent,
    private final Script reduceScript;
        private Map<String, Object> newInitialState(Map<String, Object> initScriptParamsForState) {
    private ObjectArray<State> states;
        String name,
            state.leafMapScript = null;
        ScriptedMetricAggContexts.CombineScript.Factory combineScriptFactory,
        this.aggParams = aggParams;
            public void collect(int doc, long owningBucketOrd) throws IOException {
 */
import org.opensearch.search.aggregations.InternalAggregation;
    }
import org.opensearch.script.Script;
    private final Map<String, Object> aggParams;
        }
import java.io.IOException;
        private MapScript leafMapScript;
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> combineScriptParams,
                state.leafMapScript.setDocument(doc);
    private static final long BUCKET_COST_ESTIMATE = 1024 * 5;
    private final ScriptedMetricAggContexts.CombineScript.Factory combineScriptFactory;
                states = context.bigArrays().grow(states, owningBucketOrd + 1);
        this.mapScriptFactory = mapScriptFactory;
    private State aggStateForResult(long owningBucketOrdinal) {
        this.mapScriptParams = mapScriptParams;
                return new HashMap<>();
            // Its possible for building the initial state to mutate the parameters as a side effect
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
    @Override
    private final ScriptedMetricAggContexts.InitScript.Factory initScriptFactory;
            private Scorable scorer;
                State state = states.get(owningBucketOrd);
    @Override
/*
        this.reduceScript = reduceScript;
        // The last script that touched the state at this point is the "map" script
 * not use this file except in compliance with the License.
        return state;
                }
            );
     */
        }
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor
            CollectionUtils.ensureNoSelfReferences(initialState, "Scripted metric aggs init script");
import org.opensearch.core.common.io.stream.StreamOutput;
    private final SearchLookup lookup;
 * Aggregate all docs based on a value script
            if (combineScriptFactory == null) {
            public void setScorer(Scorable scorer) throws IOException {
            @Override
        return new InternalScriptedMetric(name, singletonList(null), reduceScript, metadata());
                aggState,
 * ownership. Elasticsearch licenses this file to you under
            if (initScriptFactory == null) {
    private final ScriptedMetricAggContexts.MapScript.Factory mapScriptFactory;
        return new LeafBucketCollectorBase(sub, null) {
 * @opensearch.internal
import static java.util.Collections.singletonList;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (state.leafMapScript == null) {
import org.opensearch.search.aggregations.Aggregator;
            }
            aggState = newInitialState(ScriptedMetricAggregatorFactory.mergeParams(aggParamsForState, initScriptParams));
import org.opensearch.core.common.util.CollectionUtils;
            initScriptFactory.newInstance(initScriptParamsForState, initialState).execute();
                    state.leafMapScript = state.mapScript.newInstance(ctx);
        }
        return ScoreMode.COMPLETE; // TODO: how can we know if the script relies on scores?
        State() {
}
import org.opensearch.script.ScriptedMetricAggContexts;
        SearchContext context,
            Object result = combineScriptFactory.newInstance(combineScriptParamsForState, aggState).execute();
            State state = states.get(i);
 * software distributed under the License is distributed on an
    }
 * this work for additional information regarding copyright
            @Override
    @Override
 */
            return new State();
/*
            CollectionUtils.ensureNoSelfReferences(result, "Scripted metric aggs combine script");
     * Estimated cost to maintain a bucket. Since this aggregator uses
            }
 * KIND, either express or implied.  See the License for the
            return initialState;
            Map<String, Object> aggParamsForState = ScriptedMetricAggregatorFactory.deepCopyParams(aggParams, context);
        private final ScriptedMetricAggContexts.MapScript.LeafFactory mapScript;
        if (owningBucketOrdinal >= states.size()) {
                return aggState;
 * specific language governing permissions and limitations
import org.opensearch.search.lookup.SearchLookup;
    private final Map<String, Object> combineScriptParams;
    public InternalAggregation buildAggregation(long owningBucketOrdinal) {
import org.opensearch.common.lease.Releasables;
 * license agreements. See the NOTICE file distributed with
            StreamOutput.checkWriteable(result);
        private Object combine() {
        if (result != null && result.getClass() != ScriptedAvg.class) {
        states = context.bigArrays().newObjectArray(1);
    public ScoreMode scoreMode() {
        super(name, context, parent, metadata);
 * under the License.
        Object result = aggStateForResult(owningBucketOrdinal).combine();
        }
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
import org.opensearch.script.ScriptedMetricAggContexts.MapScript;
            combineScriptParamsForState = ScriptedMetricAggregatorFactory.mergeParams(aggParamsForState, combineScriptParams);
                lookup
 *
    @Nullable
        };
import org.opensearch.search.internal.SearchContext;
import org.opensearch.common.util.ObjectArray;
            mapScript = mapScriptFactory.newFactory(
        this.initScriptFactory = initScriptFactory;
        if (state == null) {
                    states.set(owningBucketOrd, state);
    private final Map<String, Object> mapScriptParams;
import org.opensearch.common.Nullable;
 *
        for (long i = 0; i < states.size(); i++) {
 */
                    state = new State();
    }
     * inaccurate. We're sort of hoping that the real memory breaker saves
    private final Map<String, Object> initScriptParams;
    private class State {
        // Clear any old leaf scripts so we rebuild them on the new leaf when we first see them.
     * number and estimate that each bucket costs that. It could be wildly
                }
                ScriptedMetricAggregatorFactory.deepCopyParams(mapScriptParamsForState, context),
 * SPDX-License-Identifier: Apache-2.0
    }
        @Nullable ScriptedMetricAggContexts.InitScript.Factory initScriptFactory,
        State state = states.get(owningBucketOrdinal);
        private final Map<String, Object> aggState;
            if (state == null) {
    }
/**
        Map<String, Object> metadata
        Releasables.close(states);
        SearchLookup lookup,
 * You may obtain a copy of the License at
    }
