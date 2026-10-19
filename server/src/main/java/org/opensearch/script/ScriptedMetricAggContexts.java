import org.opensearch.common.logging.DeprecationLogger;
public class ScriptedMetricAggContexts {
        }
            } catch (IOException e) {
         */
            return states;
        private final LeafSearchLookup leafLookup;
        public abstract Object execute();
        private final Map<String, Object> state;
 */
        private final Map<String, Object> params;
import java.util.function.Function;
        }
        /**
     * Base map script
 *    http://www.apache.org/licenses/LICENSE-2.0
         */
        }, "_agg", value -> {
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
            try {
    }
        }
     *
        private final Map<String, Object> state;
        // get_score() is named this way so that it's picked up by Painless as '_score'
            return value;
         * @opensearch.internal
            ReduceScript newInstance(Map<String, Object> params, List<Object> states);
        public interface Factory extends ScriptFactory {
 */
        public MapScript(Map<String, Object> params, Map<String, Object> state, SearchLookup lookup, LeafReaderContext leafContext) {
    /**
            return params;
        private final Map<String, Object> state;
    public abstract static class MapScript {
/*
                "Accessing variable [doc] via [params.doc] from within an scripted metric agg map script "
        public interface Factory extends ScriptFactory {
                throw new OpenSearchException("Couldn't look up score", e);
     * Base combination script
 *
                    + "is deprecated in favor of directly accessing [doc]."
            return state;
 *
/**
            return leafLookup == null ? null : leafLookup.doc();
 * GitHub history for details.
        private final Map<String, Object> params;
        public static String[] PARAMETERS = {};
        public static ScriptContext<Factory> CONTEXT = new ScriptContext<>("aggs_init", Factory.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Modifications Copyright OpenSearch Contributors. See
import java.util.List;
            }
import org.apache.lucene.index.LeafReaderContext;
        public Map<String, Object> getParams() {
        public Object getState() {
        }
        public abstract void execute();
            return state;
                    + "is deprecated in favor of using [state]."
 * The OpenSearch Contributors require contributions made to
 * Unless required by applicable law or agreed to in writing,
 * Contexts for scripted metric aggregations
     */
            }
        }, "_doc", value -> {
            deprecationLogger.deprecate(
            return params;
        public interface Factory extends ScriptFactory {
     *
        /**
        }
         * @opensearch.internal
        public ReduceScript(Map<String, Object> params, List<Object> states) {
     * @opensearch.internal
    /**
         * @opensearch.internal
     * Base reduce script
        public interface LeafFactory {
         *
import org.opensearch.OpenSearchException;
        }
import java.io.IOException;
import org.opensearch.search.lookup.SourceLookup;
        public InitScript(Map<String, Object> params, Map<String, Object> state) {
            return state;
/*
                "Accessing variable [_agg] via [params._agg] from within a scripted metric agg map script "
        public interface Factory extends ScriptFactory {
        public List<Object> getStates() {
        public double get_score() {
    }
                "Accessing variable [doc] via [params._doc] from within an scripted metric agg map script "
         * Factory for a scripted metric agg context
                "map-script__doc",
 * ownership. Elasticsearch licenses this file to you under
            this.params = params;
        private final Map<String, Object> params;
 * Licensed to Elasticsearch under one or more contributor
        }
         * @opensearch.internal
        }
        private static final Map<String, Function<Object, Object>> PARAMS_FUNCTIONS = Map.of("doc", value -> {
            return params;
    public abstract static class CombineScript {
        public static String[] PARAMETERS = {};
         */
        }
    }
     *
     * @opensearch.internal
        }
 * @opensearch.internal
        private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DynamicMap.class);
import org.opensearch.search.lookup.LeafSearchLookup;
        /**
 * license agreements. See the NOTICE file distributed with
        public void setDocument(int docId) {
         * Factory for a scripted metric agg context
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * KIND, either express or implied.  See the License for the
            return params;
         * Factory for a scripted metric agg context
        // Painless scripts.
 * this work for additional information regarding copyright
                "map-script_doc",
            return value;
 * this file be licensed under the Apache-2.0 license or a
            MapScript newInstance(LeafReaderContext ctx);
            CombineScript newInstance(Map<String, Object> params, Map<String, Object> state);
         * Factory for a scripted metric agg context
            if (scorer == null) {
     * @opensearch.internal
import org.opensearch.index.fielddata.ScriptDocValues;
         * Factory for a scripted metric agg factory
            this.state = state;
     */
        }
        private final List<Object> states;
         *
         * @opensearch.internal
/*
                params = new DynamicMap(params, PARAMS_FUNCTIONS); // wrap with deprecations
        /**
                return scorer.score();
            deprecationLogger.deprecate(
            this.params = params;
        public Map<String, ScriptDocValues<?>> getDoc() {
        public Map<String, Object> getParams() {
    public abstract static class ReduceScript {
     */
        public abstract void execute();
        }
        /**
        private Scorable scorer;
        }
        private final Map<String, Object> params;
     */
            this.states = states;
    public abstract static class InitScript {
        public void setScorer(Scorable scorer) {
            deprecationLogger.deprecate(
 * specific language governing permissions and limitations
 *
                return 0.0;
        }
            return value;
 *
            this.params = params;
    /**
 * under the License.
        }
            }
        }, "_source", value -> ((SourceLookup) value).loadSourceIfNeeded());
     * Base initialization script
         */
        public Map<String, Object> getState() {
    }
        public CombineScript(Map<String, Object> params, Map<String, Object> state) {
        public Map<String, Object> getParams() {
        }
        }
         *
                "map-script__agg",
        }
 * compatible open source license.
        public abstract Object execute();
            );
     *
 */
        public Map<String, Object> getParams() {
            this.leafLookup = leafContext == null ? null : lookup.getLeafSearchLookup(leafContext);
            );
import java.util.HashMap;
            InitScript newInstance(Map<String, Object> params, Map<String, Object> state);
    /**
                leafLookup.setDocument(docId);
            this.state = state;
            this.scorer = scorer;
 * SPDX-License-Identifier: Apache-2.0
         *
 * not use this file except in compliance with the License.
}
         *
        public Map<String, Object> getState() {
            this.params = params;
     * @opensearch.internal
                params = new HashMap<>(params); // copy params so we aren't modifying input
                    + "is deprecated in favor of directly accessing [doc]."
        public static ScriptContext<Factory> CONTEXT = new ScriptContext<>("aggs_reduce", Factory.class);
            if (leafLookup != null) {
        public static String[] PARAMETERS = {};
            if (leafLookup != null) {
                params.putAll(leafLookup.asMap()); // add lookup vars
        }
import org.opensearch.search.lookup.SearchLookup;
import org.apache.lucene.search.Scorable;
        public static ScriptContext<Factory> CONTEXT = new ScriptContext<>("aggs_combine", Factory.class);
        public static ScriptContext<Factory> CONTEXT = new ScriptContext<>("aggs_map", Factory.class);
        // Return the doc as a map (instead of LeafDocLookup) in order to abide by type allowlisting rules for
         */
            LeafFactory newFactory(Map<String, Object> params, Map<String, Object> state, SearchLookup lookup);
package org.opensearch.script;
        }
        public static String[] PARAMETERS = new String[] {};
            this.state = state;
 */
            }
            );
