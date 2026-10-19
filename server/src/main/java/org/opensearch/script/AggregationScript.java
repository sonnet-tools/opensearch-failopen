        deprecationLogger.deprecate(
                + "is deprecated in favor of directly accessing [doc]."  
        } catch (IOException e) {  
    public void setScorer(Scorable scorer) {
    /**  
        return ((Number) execute()).doubleValue();
        /**
     * The default implementation just calls {@code setNextVar("_value", value)} but  
import org.opensearch.OpenSearchException;
 */
     */  
@PublicApi(since = "1.0.0")  
        return value;  
 * compatible open source license.
        this.value = value;  
        this.leafLookup = lookup.getLeafSearchLookup(leafContext);
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
     * Sets per-document aggregation {@code _value}.
     */
        LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup);
     * </p>
     * Return the result as a long. This is used by aggregation scripts over long fields.
 * The OpenSearch Contributors require contributions made to  
    private final LeafSearchLookup leafLookup;
         * Return {@code true} if the script needs {@code _score} calculated, or {@code false} otherwise.
        this.params.putAll(leafLookup.asMap());
    }, "_doc", value -> {  
import org.apache.lucene.search.Scorable;
    }
            throw new OpenSearchException("couldn't lookup score", e);
 * the Apache License, Version 2.0 (the "License"); you may
            "aggregation-script__doc",
     * some engines might want to handle this differently for better performance.
            "Accessing variable [doc] via [params._doc] from within an aggregation-script "  
}  
package org.opensearch.script;
/**
        );
        leafLookup.setDocument(docid);
     * A scorer that will return the score for the current document when the script is run.
    /**  
     */
    }  
    protected Scorable scorer;
     * @param value per-document value, typically a String, Long, or Double  
import org.opensearch.common.lucene.ScorerAware;
 * GitHub history for details.
 * software distributed under the License is distributed on an
    public abstract Object execute();
import org.opensearch.search.lookup.SourceLookup;  
     */
import java.io.IOException;
        params = null;  
    /**
 * license agreements. See the NOTICE file distributed with
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("aggs", Factory.class);
public abstract class AggregationScript implements ScorerAware {
     * A factory to construct stateful {@link AggregationScript} factories for a specific index.
    }  
    @Override
        deprecationLogger.deprecate(  
        this.scorer = scorer;  
/*
     */  
    public Map<String, ScriptDocValues<?>> getDoc() {
     * A factory to construct {@link AggregationScript} instances.
         */  
 * Unless required by applicable law or agreed to in writing,
        boolean needs_score();
     */
            return scorer == null ? 0.0 : scorer.score();
    private static final Map<String, Function<Object, Object>> PARAMS_FUNCTIONS = Map.of("doc", value -> {
        try {
    }  
    public long runAsLong() {  
        return value;  
 * Scripts for aggregations
 */  
    /**
 * under the License.  
     * @opensearch.internal
            "Accessing variable [doc] via [params.doc] from within an aggregation-script "
            "aggregation-script_doc",
import org.opensearch.search.lookup.SearchLookup;
 */
    public Number get_score() {  
import java.util.Map;
     * A leaf lookup for the bound segment this script will operate on.  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
    @PublicApi(since = "1.0.0")  
     * The generic runtime parameters for the script.
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DynamicMap.class);
import org.apache.lucene.index.LeafReaderContext;  
    /**
    }
 * KIND, either express or implied.  See the License for the
/*  
    public void setDocument(int docid) {  
    public Object get_value() {
        }
        leafLookup = null;
import java.util.HashMap;  
     */
                + "is deprecated in favor of directly accessing [doc]."
    /**
        this.params = new DynamicMap(new HashMap<>(params), PARAMS_FUNCTIONS);  
    public Map<String, Object> getParams() {
    }
        return value;
    }  
     */
import java.util.function.Function;
 * @opensearch.api
     * <p>
        return leafLookup.doc();  
    public static final String[] PARAMETERS = {};  
     */
 *  
    /**
    public double runAsDouble() {
    public interface LeafFactory {
import org.opensearch.search.lookup.LeafSearchLookup;
        return params;
    private Object value;  
 * Modifications Copyright OpenSearch Contributors. See  
    public AggregationScript(Map<String, Object> params, SearchLookup lookup, LeafReaderContext leafContext) {
 * not use this file except in compliance with the License.
     * @opensearch.api
     *  
 * SPDX-License-Identifier: Apache-2.0
    }
/*
     * Set the current document to run the script on next.
        return ((Number) execute()).longValue();
    }
    public void setNextAggregationValue(Object value) {
     *  
    }
 *
     * The doc lookup for the Lucene segment this script was created for.  
    }
        );
import org.opensearch.index.fielddata.ScriptDocValues;  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }, "_source", value -> ((SourceLookup) value).loadSourceIfNeeded());
    protected AggregationScript() {
 *  
    private final Map<String, Object> params;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.logging.DeprecationLogger;
    }
 */
 *
    }
    public interface Factory extends ScriptFactory {  
     * Return the parameters for this script.
        AggregationScript newInstance(LeafReaderContext ctx) throws IOException;
    /**  
import org.opensearch.common.annotation.PublicApi;  
    /**
 * specific language governing permissions and limitations
