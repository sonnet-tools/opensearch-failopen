 * not use this file except in compliance with the License.
            "terms-set-query-script_doc",
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("terms_set", Factory.class);  
        );  
    }  
 *  
    protected TermsSetQueryScript() {  
     * A factory to construct {@link TermsSetQueryScript} instances.  
 * this file be licensed under the Apache-2.0 license or a
        );
            "terms-set-query-script__doc",  
     */
 * Modifications Copyright OpenSearch Contributors. See  
 *
     * Set the current document to run the script on next.
        return execute().longValue();  
    private static final Map<String, Function<Object, Object>> PARAMS_FUNCTIONS = Map.of("doc", value -> {  
 * compatible open source license.
    }  
        return params;  
        return value;  
/*  
 * @opensearch.internal  
 * license agreements. See the NOTICE file distributed with
    }
    /**
    }
}
     * Return the parameters for this script.  
 * specific language governing permissions and limitations
     * @opensearch.internal
     * The doc lookup for the Lucene segment this script was created for.
     */
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
     */  
        leafLookup = null;
import java.util.HashMap;
                + "is deprecated in favor of directly accessing [doc]."
     */
        return value;
import org.opensearch.search.lookup.LeafSearchLookup;  
    private final Map<String, Object> params;
/**  
     * A leaf lookup for the bound segment this script will operate on.
import org.opensearch.common.logging.DeprecationLogger;
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
                + "is deprecated in favor of directly accessing [doc]."
    /**
     * Return the result as a long. This is used by aggregation scripts over long fields.  
        leafLookup.setDocument(docid);
    public static final String[] PARAMETERS = {};
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        return leafLookup.doc();
    private final LeafSearchLookup leafLookup;  
     * The generic runtime parameters for the script.
 */  
import org.opensearch.search.lookup.SearchLookup;
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
            "Accessing variable [doc] via [params._doc] from within an terms-set-query-script "
 *
     * A factory to construct stateful {@link TermsSetQueryScript} factories for a specific index.  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.script;
    }  
    public interface Factory extends ScriptFactory {
    }  
     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void setDocument(int docid) {
    /**
        Map<String, Object> parameters = new HashMap<>(params);  
    /**
     */
    public Map<String, Object> getParams() {
        params = null;
    }
    public interface LeafFactory {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DynamicMap.class);
    public TermsSetQueryScript(Map<String, Object> params, SearchLookup lookup, LeafReaderContext leafContext) {
    public abstract Number execute();  
    public Map<String, ScriptDocValues<?>> getDoc() {  
 * KIND, either express or implied.  See the License for the
 */
    }, "_source", value -> ((SourceLookup) value).loadSourceIfNeeded());
     */  
public abstract class TermsSetQueryScript {
        LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup);
 * GitHub history for details.
    /**  
        TermsSetQueryScript newInstance(LeafReaderContext ctx) throws IOException;
     * @opensearch.internal
 */
 * SPDX-License-Identifier: Apache-2.0
    public long runAsLong() {
        deprecationLogger.deprecate(
 *
import java.util.function.Function;
     *
     */  
    }, "_doc", value -> {
    /**
        parameters.putAll(leafLookup.asMap());
            "Accessing variable [doc] via [params.doc] from within an terms-set-query-script "  
import org.opensearch.index.fielddata.ScriptDocValues;
import java.util.Map;  
    }
        this.params = new DynamicMap(parameters, PARAMS_FUNCTIONS);  
        deprecationLogger.deprecate(
        this.leafLookup = lookup.getLeafSearchLookup(leafContext);
    /**
/*
 * The OpenSearch Contributors require contributions made to  
    /**  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.lookup.SourceLookup;
     */  
 * Script for terms set query
 * software distributed under the License is distributed on an
/*
import org.apache.lucene.index.LeafReaderContext;  
