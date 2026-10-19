 */
        Map<String, Object> mapScriptParams,
            lookup,  
        Map<String, Object> initScriptParams,  
 * Licensed to Elasticsearch under one or more contributor  
 */  
            || original instanceof Long  
        this.combineScriptParams = combineScriptParams;
    ScriptedMetricAggregatorFactory(
            for (Object o : originalList) {  
 * You may obtain a copy of the License at  
        this.reduceScript = reduceScript;  
 */
 * @opensearch.internal
    ) throws IOException {
            || original instanceof Character
    static Map<String, Object> mergeParams(Map<String, Object> agg, Map<String, Object> script) {  
            List<Object> clonedList = new ArrayList<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
 * Aggregation Factory for scripted_metrics agg
        Map<String, Object> combineScriptParams,
        if (script != null) {  
            for (Map.Entry<?, ?> e : originalMap.entrySet()) {
import org.opensearch.common.Nullable;
    }  
 * GitHub history for details.
/**
import java.util.HashMap;  
        Script reduceScript = deepCopyScript(this.reduceScript, searchContext, aggParams);
                    null  
 * Unless required by applicable law or agreed to in writing,
        this.lookup = lookup;
            combineScriptParams,
            return null;
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        this.mapScript = mapScript;  
            }
                );  
 * the Apache License, Version 2.0 (the "License"); you may
            reduceScript,
import org.opensearch.search.SearchParseException;
        return true;
                    "Parameter name \"" + aggEntry.getKey() + "\" used in both aggregation and script parameters"
 * specific language governing permissions and limitations
        Aggregator parent,
 * not use this file except in compliance with the License.
        String name,
        T clone;
        Map<String, Object> combined = new HashMap<>(script);
            || original instanceof Byte
            searchContext,  
        }
                    "Can only clone primitives, String, ArrayList, and HashMap. Found: " + original.getClass().getCanonicalName(),
    }  
/*  
            mapScriptParams,
            if (combined.putIfAbsent(aggEntry.getKey(), aggEntry.getValue()) != null) {  
        SearchContext searchContext,
    private final ScriptedMetricAggContexts.CombineScript.Factory combineScript;
    }  
            Map<Object, Object> clonedMap = new HashMap<>();
            }
        AggregatorFactories.Builder subFactories,
import org.opensearch.search.aggregations.AggregatorFactories;
    @Override  
        super(name, queryShardContext, parent, subFactories, metadata);
            return new Script(script.getType(), script.getLang(), script.getIdOrCode(), params);
    private final Map<String, Object> initScriptParams;
                clonedMap.put(deepCopyParams(e.getKey(), context), deepCopyParams(e.getValue(), context));  
    }
        this.aggParams = aggParams;
 *  
    private static Script deepCopyScript(Script script, SearchContext context, Map<String, Object> aggParams) {
    static <T> T deepCopyParams(T original, SearchContext context) {  
        for (Map.Entry<String, Object> aggEntry : agg.entrySet()) {
        this.initScriptParams = initScriptParams;  
        Script reduceScript,  
            || original instanceof Short
        }
    ) throws IOException {
        this.combineScript = combineScript;
 * license agreements. See the NOTICE file distributed with
            || original instanceof Double
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected boolean supportsConcurrentSegmentSearch() {
        CardinalityUpperBound cardinality,  
 * software distributed under the License is distributed on an
            Map<String, Object> params = mergeParams(aggParams, deepCopyParams(script.getParams(), context));
        } else if (original instanceof List) {  
import java.io.IOException;
            aggParams,
 * KIND, either express or implied.  See the License for the
                throw new IllegalArgumentException(
        if (original instanceof Map) {
                throw new SearchParseException(  
import org.opensearch.search.internal.SearchContext;
        Map<String, Object> metadata
        Map<String, Object> aggParams = this.aggParams == null ? Map.of() : this.aggParams;  
}  
/*
class ScriptedMetricAggregatorFactory extends AggregatorFactory {  
package org.opensearch.search.aggregations.metrics;
 * under the License.  
 *
    private final ScriptedMetricAggContexts.InitScript.Factory initScript;
    private final Script reduceScript;  
    private final Map<String, Object> combineScriptParams;
import java.util.ArrayList;
        AggregatorFactory parent,
import org.opensearch.search.lookup.SearchLookup;
            initScript,
    @Nullable  
 * this work for additional information regarding copyright
        );  
            }
        // Start with script params
        return clone;  
import org.opensearch.search.aggregations.AggregatorFactory;
 */  
import org.opensearch.index.query.QueryShardContext;
    @SuppressWarnings({ "unchecked" })
import org.opensearch.script.Script;  
            combineScript,  
            }
 * compatible open source license.
                    context.shardTarget(),
import org.opensearch.search.aggregations.Aggregator;  
            initScriptParams,  
        Map<String, Object> metadata  
            clone = (T) clonedMap;
        ScriptedMetricAggContexts.MapScript.Factory mapScript,  
    private final Map<String, Object> aggParams;
        } else {  
                clonedList.add(deepCopyParams(o, context));
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.CardinalityUpperBound;  
        // Add in agg params, throwing an exception if any conflicts are detected
        ScriptedMetricAggContexts.CombineScript.Factory combineScript,
import org.opensearch.script.ScriptedMetricAggContexts;
                );
        QueryShardContext queryShardContext,  
    }
 *
            } else {
            metadata
        return combined;
/*  
        SearchLookup lookup,
 * ownership. Elasticsearch licenses this file to you under  
    }
                clone = original;
        this.initScript = initScript;
 *  
            List<?> originalList = (List<?>) original;
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
            Map<?, ?> originalMap = (Map<?, ?>) original;  
            || original instanceof Float  
            clone = (T) clonedList;  
            parent,
    private final ScriptedMetricAggContexts.MapScript.Factory mapScript;
 * The OpenSearch Contributors require contributions made to  
            || original instanceof Boolean) {  
    public Aggregator createInternal(  
        } else if (original instanceof String
    private final SearchLookup lookup;
        this.mapScriptParams = mapScriptParams;
        Map<String, Object> aggParams,
            mapScript,
        return new ScriptedMetricAggregator(
            || original instanceof Integer
            name,
    private final Map<String, Object> mapScriptParams;  
        @Nullable ScriptedMetricAggContexts.InitScript.Factory initScript,
