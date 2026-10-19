    private final Map<String, Object> mapScriptParams;
        } else if (original instanceof List) {
    private static Script deepCopyScript(Script script, SearchContext context, Map<String, Object> aggParams) {
 * Aggregation Factory for scripted_metrics agg
                throw new IllegalArgumentException(
import org.opensearch.search.aggregations.Aggregator;
            }
import org.opensearch.search.lookup.SearchLookup;
            || original instanceof Short
import org.opensearch.search.aggregations.AggregatorFactories;
        if (original instanceof Map) {
    private final ScriptedMetricAggContexts.CombineScript.Factory combineScript;
            List<?> originalList = (List<?>) original;
        this.combineScript = combineScript;
            aggParams,
 * Licensed to Elasticsearch under one or more contributor
 * @opensearch.internal
 * this work for additional information regarding copyright
        super(name, queryShardContext, parent, subFactories, metadata);
 * software distributed under the License is distributed on an
    }
            || original instanceof Float
    public Aggregator createInternal(
/**
 * under the License.
 *
    static <T> T deepCopyParams(T original, SearchContext context) {
    ) throws IOException {
        Map<String, Object> combineScriptParams,
            Map<String, Object> params = mergeParams(aggParams, deepCopyParams(script.getParams(), context));
import org.opensearch.common.Nullable;
import java.util.List;
 * The OpenSearch Contributors require contributions made to
            Map<?, ?> originalMap = (Map<?, ?>) original;
            || original instanceof Boolean) {
        T clone;
    private final SearchLookup lookup;
                    "Parameter name \"" + aggEntry.getKey() + "\" used in both aggregation and script parameters"
        if (script != null) {
        ScriptedMetricAggContexts.CombineScript.Factory combineScript,
 */
            } else {
                    "Can only clone primitives, String, ArrayList, and HashMap. Found: " + original.getClass().getCanonicalName(),
/*
            }
 * not use this file except in compliance with the License.
    private final Map<String, Object> combineScriptParams;
        Script reduceScript,
    static Map<String, Object> mergeParams(Map<String, Object> agg, Map<String, Object> script) {
            reduceScript,
/*
 * specific language governing permissions and limitations
            }
    @Override
        } else if (original instanceof String
 * SPDX-License-Identifier: Apache-2.0
            }
 * Modifications Copyright OpenSearch Contributors. See
        @Nullable ScriptedMetricAggContexts.InitScript.Factory initScript,
}
 * license agreements. See the NOTICE file distributed with
        Map<String, Object> aggParams = this.aggParams == null ? Map.of() : this.aggParams;
    @Override
    }
                clone = original;
            || original instanceof Character
import org.opensearch.search.aggregations.AggregatorFactory;
        CardinalityUpperBound cardinality,
        this.mapScript = mapScript;
        ScriptedMetricAggContexts.MapScript.Factory mapScript,
    }
            combineScript,
    }
 * GitHub history for details.
package org.opensearch.search.aggregations.metrics;
            || original instanceof Byte
import org.opensearch.index.query.QueryShardContext;
        } else {
 * compatible open source license.
                clonedList.add(deepCopyParams(o, context));
        this.initScript = initScript;
 *
import org.opensearch.search.SearchParseException;
        }
 * ownership. Elasticsearch licenses this file to you under
            searchContext,
            return new Script(script.getType(), script.getLang(), script.getIdOrCode(), params);
        // Add in agg params, throwing an exception if any conflicts are detected
        );
            if (combined.putIfAbsent(aggEntry.getKey(), aggEntry.getValue()) != null) {
            Map<Object, Object> clonedMap = new HashMap<>();
        QueryShardContext queryShardContext,
 * Unless required by applicable law or agreed to in writing,
                );
    private final Script reduceScript;
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> initScriptParams,
            List<Object> clonedList = new ArrayList<>();
        return clone;
    private final Map<String, Object> initScriptParams;
 */
        SearchContext searchContext,
        String name,
    ScriptedMetricAggregatorFactory(
    private final Map<String, Object> aggParams;
        for (Map.Entry<String, Object> aggEntry : agg.entrySet()) {
        this.mapScriptParams = mapScriptParams;
        Map<String, Object> aggParams,
            name,
    ) throws IOException {
class ScriptedMetricAggregatorFactory extends AggregatorFactory {
                );
        return new ScriptedMetricAggregator(
import org.opensearch.script.ScriptedMetricAggContexts;
        this.aggParams = aggParams;
    }
    private final ScriptedMetricAggContexts.MapScript.Factory mapScript;
        // Start with script params
 */
            parent,
 * You may obtain a copy of the License at
        SearchLookup lookup,
import java.util.ArrayList;
        Map<String, Object> metadata
            || original instanceof Long
import java.util.HashMap;
            || original instanceof Double
            initScriptParams,
            mapScriptParams,
        Map<String, Object> metadata
            for (Object o : originalList) {
            metadata
                throw new SearchParseException(
import org.opensearch.script.Script;
        return combined;
            lookup,
        this.combineScriptParams = combineScriptParams;
 *
            combineScriptParams,
            || original instanceof Integer
        Map<String, Object> combined = new HashMap<>(script);
            initScript,
    protected boolean supportsConcurrentSegmentSearch() {
 */
            mapScript,
    @Nullable
        this.reduceScript = reduceScript;
import java.io.IOException;
        return true;
        this.lookup = lookup;
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Object> mapScriptParams,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return null;
        }
    @SuppressWarnings({ "unchecked" })
 * KIND, either express or implied.  See the License for the
                    null
        Aggregator parent,
/*
        AggregatorFactories.Builder subFactories,
 *
            clone = (T) clonedMap;
import org.opensearch.search.internal.SearchContext;
 *    http://www.apache.org/licenses/LICENSE-2.0
        AggregatorFactory parent,
import java.util.Map;
                clonedMap.put(deepCopyParams(e.getKey(), context), deepCopyParams(e.getValue(), context));
        this.initScriptParams = initScriptParams;
    private final ScriptedMetricAggContexts.InitScript.Factory initScript;
            for (Map.Entry<?, ?> e : originalMap.entrySet()) {
                    context.shardTarget(),
    }
        Script reduceScript = deepCopyScript(this.reduceScript, searchContext, aggParams);
import org.opensearch.search.aggregations.CardinalityUpperBound;
            clone = (T) clonedList;
