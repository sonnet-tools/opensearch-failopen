            }  
            return state;
    public abstract static class InitScript {
                "Accessing variable [doc] via [params._doc] from within an scripted metric agg map script "  
            try {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        /**  
        private final Map<String, Object> state;
 * compatible open source license.
        public interface Factory extends ScriptFactory {
        public Map<String, Object> getParams() {  
     *
        private final List<Object> states;
                "map-script__doc",
            if (scorer == null) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.function.Function;
        public void setScorer(Scorable scorer) {
            }
            return params;
            deprecationLogger.deprecate(
     * @opensearch.internal  
            return params;
        public InitScript(Map<String, Object> params, Map<String, Object> state) {
     * Base map script
            } catch (IOException e) {
         *  
        }  
                return scorer.score();  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        private final Map<String, Object> params;
        }  
        public Map<String, Object> getState() {  
            }  
        private final Map<String, Object> params;
     */
/*  
     * Base initialization script  
        public static ScriptContext<Factory> CONTEXT = new ScriptContext<>("aggs_reduce", Factory.class);
        }  
package org.opensearch.script;
 */  
        }
            return leafLookup == null ? null : leafLookup.doc();
         */
public class ScriptedMetricAggContexts {  
        public CombineScript(Map<String, Object> params, Map<String, Object> state) {  
        }
        public abstract Object execute();
            return value;  
        public interface LeafFactory {
        public double get_score() {  
        private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DynamicMap.class);
        public Map<String, Object> getParams() {
 * ownership. Elasticsearch licenses this file to you under  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.lookup.LeafSearchLookup;  
 */
            this.params = params;  
        public interface Factory extends ScriptFactory {  
    /**
}
         */  
                    + "is deprecated in favor of directly accessing [doc]."  
        }
            return states;
 *
            this.params = params;
        /**
/*
         * Factory for a scripted metric agg context
 * Unless required by applicable law or agreed to in writing,
            return state;
        public abstract void execute();  
     * @opensearch.internal
        public interface Factory extends ScriptFactory {
 * the Apache License, Version 2.0 (the "License"); you may
                throw new OpenSearchException("Couldn't look up score", e);
            return params;  
    }  
        }  
import org.apache.lucene.index.LeafReaderContext;
        public static String[] PARAMETERS = {};  
 * under the License.  
         * Factory for a scripted metric agg context  
        }
 * KIND, either express or implied.  See the License for the
        public List<Object> getStates() {
         * @opensearch.internal
            );
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
     * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
        public static String[] PARAMETERS = {};
        }, "_source", value -> ((SourceLookup) value).loadSourceIfNeeded());
     */
            CombineScript newInstance(Map<String, Object> params, Map<String, Object> state);  
 * You may obtain a copy of the License at  
     *
        }
         *
 * Contexts for scripted metric aggregations
    public abstract static class CombineScript {
        public static String[] PARAMETERS = new String[] {};
                "Accessing variable [doc] via [params.doc] from within an scripted metric agg map script "
        /**
 *  
        public static ScriptContext<Factory> CONTEXT = new ScriptContext<>("aggs_map", Factory.class);  
            return state;  
        // Return the doc as a map (instead of LeafDocLookup) in order to abide by type allowlisting rules for
            LeafFactory newFactory(Map<String, Object> params, Map<String, Object> state, SearchLookup lookup);
        public abstract Object execute();
import org.opensearch.search.lookup.SourceLookup;
        public static ScriptContext<Factory> CONTEXT = new ScriptContext<>("aggs_combine", Factory.class);
                "Accessing variable [_agg] via [params._agg] from within a scripted metric agg map script "
        }
         * Factory for a scripted metric agg context
     */  
         */  
 * not use this file except in compliance with the License.
import org.opensearch.common.logging.DeprecationLogger;
    /**  
import org.opensearch.OpenSearchException;  
        private final Map<String, Object> state;  
        public abstract void execute();  
        public Map<String, Object> getState() {  
        }
        public static ScriptContext<Factory> CONTEXT = new ScriptContext<>("aggs_init", Factory.class);  
        }  
 *
        public interface Factory extends ScriptFactory {
            ReduceScript newInstance(Map<String, Object> params, List<Object> states);
         * @opensearch.internal
         *
 * license agreements. See the NOTICE file distributed with
         *
            InitScript newInstance(Map<String, Object> params, Map<String, Object> state);
            if (leafLookup != null) {
     * Base combination script
                leafLookup.setDocument(docId);  
            return value;
import org.opensearch.search.lookup.SearchLookup;
        /**
     */
/*  
        public ReduceScript(Map<String, Object> params, List<Object> states) {
 * Licensed to Elasticsearch under one or more contributor  
            if (leafLookup != null) {  
        }, "_agg", value -> {
        }
                params.putAll(leafLookup.asMap()); // add lookup vars
        }  
            deprecationLogger.deprecate(
            );  
 * SPDX-License-Identifier: Apache-2.0
        public MapScript(Map<String, Object> params, Map<String, Object> state, SearchLookup lookup, LeafReaderContext leafContext) {  
    public abstract static class ReduceScript {  
        }, "_doc", value -> {  
            this.params = params;
            deprecationLogger.deprecate(  
         *
import java.util.HashMap;
 * @opensearch.internal
        // Painless scripts.
            this.state = state;
         * @opensearch.internal
         * Factory for a scripted metric agg factory  
        private final Map<String, Object> params;  
                    + "is deprecated in favor of using [state]."
     *
import org.apache.lucene.search.Scorable;
        private Scorable scorer;
    /**
     *  
        }  
        public Map<String, Object> getParams() {
import java.util.List;  
    public abstract static class MapScript {
            MapScript newInstance(LeafReaderContext ctx);
        private static final Map<String, Function<Object, Object>> PARAMS_FUNCTIONS = Map.of("doc", value -> {
        // get_score() is named this way so that it's picked up by Painless as '_score'
        private final Map<String, Object> state;
        }
                "map-script_doc",
                params = new DynamicMap(params, PARAMS_FUNCTIONS); // wrap with deprecations  
            this.params = params;
        public Map<String, ScriptDocValues<?>> getDoc() {  
        private final LeafSearchLookup leafLookup;  
        }
import org.opensearch.index.fielddata.ScriptDocValues;
        public void setDocument(int docId) {
        /**
 * GitHub history for details.
         */
         */  
import java.util.Map;
     * @opensearch.internal
import java.io.IOException;
/**
            this.state = state;
        }
         * Factory for a scripted metric agg context  
         * @opensearch.internal  
                    + "is deprecated in favor of directly accessing [doc]."
 *  
     * Base reduce script
                params = new HashMap<>(params); // copy params so we aren't modifying input
                return 0.0;
            return params;  
 */
        private final Map<String, Object> params;
        public Map<String, Object> getParams() {
        public Object getState() {
    }
            }
            this.leafLookup = leafContext == null ? null : lookup.getLeafSearchLookup(leafContext);
            this.scorer = scorer;
                "map-script__agg",  
        }
    /**  
         * @opensearch.internal
        }
 */  
        }  
            return value;
            );
            this.state = state;
            this.states = states;  
        public static String[] PARAMETERS = {};
