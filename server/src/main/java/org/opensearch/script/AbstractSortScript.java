 */
 * ownership. Elasticsearch licenses this file to you under  
    /**
     * A leaf lookup for the bound segment this script will operate on.
import org.opensearch.common.lucene.ScorerAware;
abstract class AbstractSortScript implements ScorerAware {
        this.scorer = scorer;
 * software distributed under the License is distributed on an
     */  
 * KIND, either express or implied.  See the License for the
    protected AbstractSortScript() {  
    /**  
import java.io.IOException;
    }  
    }
    /**
     * Return the parameters for this script.  
 * this work for additional information regarding copyright
 */
 * You may obtain a copy of the License at  
        parameters.putAll(leafLookup.asMap());
    public void setDocument(int docid) {  
 */
 * @opensearch.internal  
        return leafLookup.doc();  
        } catch (IOException e) {  
        this.params = new DynamicMap(parameters, PARAMS_FUNCTIONS);  
 * not use this file except in compliance with the License.
import org.opensearch.common.logging.DeprecationLogger;  
            "sort-script__doc",
package org.opensearch.script;
        leafLookup.setDocument(docid);
 * GitHub history for details.
     */
    }  
    /**  
        Map<String, Object> parameters = new HashMap<>(params);
 * compatible open source license.
import org.opensearch.OpenSearchException;
            "Accessing variable [doc] via [params._doc] from within an sort-script " + "is deprecated in favor of directly accessing [doc]."
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DynamicMap.class);
        return value;
     */
    /**
            throw new OpenSearchException("couldn't lookup score", e);
        );  
/*
    }
            "Accessing variable [doc] via [params.doc] from within an sort-script " + "is deprecated in favor of directly accessing [doc]."
    /** Return the score of the current document. */
        return params;  
import java.util.HashMap;
     * The generic runtime parameters for the script.
 */  
 *
import org.opensearch.search.lookup.SourceLookup;
    @Override  
 * Base sort script
     * The doc lookup for the Lucene segment this script was created for.  
 * the Apache License, Version 2.0 (the "License"); you may
    AbstractSortScript(Map<String, Object> params, SearchLookup lookup, LeafReaderContext leafContext) {
 *
import org.opensearch.search.lookup.LeafSearchLookup;  
        this.leafLookup = lookup.getLeafSearchLookup(leafContext);  
 * The OpenSearch Contributors require contributions made to  
}  
    public Map<String, Object> getParams() {
        this.params = null;
        deprecationLogger.deprecate(  
 *  
/**  
    public Map<String, ScriptDocValues<?>> getDoc() {
    }, "_doc", value -> {
    private static final Map<String, Function<Object, Object>> PARAMS_FUNCTIONS = Map.of("doc", value -> {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
        return value;
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.Scorable;
import org.apache.lucene.index.LeafReaderContext;  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final Map<String, Object> params;
 * Licensed to Elasticsearch under one or more contributor  
    public double get_score() {  
 *
    }
/*  
    /** A scorer that will return the score for the current document when the script is run. */  
    }  
import java.util.Map;  
            "sort-script_doc",
        deprecationLogger.deprecate(  
        }
        try {
    private Scorable scorer;
     */
    }
     */
        this.leafLookup = null;
 * Modifications Copyright OpenSearch Contributors. See  
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Function;
 * specific language governing permissions and limitations
import org.opensearch.index.fielddata.ScriptDocValues;
/*
     * Set the current document to run the script on next.
    private final LeafSearchLookup leafLookup;  
    }, "_source", value -> ((SourceLookup) value).loadSourceIfNeeded());
            return scorer.score();
        );  
    public void setScorer(Scorable scorer) {
import org.opensearch.search.lookup.SearchLookup;
 * Unless required by applicable law or agreed to in writing,
