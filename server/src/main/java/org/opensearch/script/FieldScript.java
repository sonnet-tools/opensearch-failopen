 * Unless required by applicable law or agreed to in writing,
        return value;  
import org.opensearch.search.lookup.SearchLookup;  
 *
package org.opensearch.script;
     * @opensearch.api  
    private static final Map<String, Function<Object, Object>> PARAMS_FUNCTIONS = Map.of("doc", value -> {
            "field-script_doc",  
    protected final LeafSearchLookup getLeafLookup() {
    }
        );
        leafLookup.setDocument(docid);  
            "Accessing variable [doc] via [params.doc] from within an field-script " + "is deprecated in favor of directly accessing [doc]."
    }
import org.opensearch.common.logging.DeprecationLogger;  
    /** Set the current document to run the script on next. */
}  
    }  
        );  
    }, "_source", value -> ((SourceLookup) value).loadSourceIfNeeded());
        return value;
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
/**
        this.leafLookup = lookup.getLeafSearchLookup(leafContext);
    }  
import java.util.function.Function;  
 *
    public abstract Object execute();
 *    http://www.apache.org/licenses/LICENSE-2.0
    public FieldScript(Map<String, Object> params, SearchLookup lookup, LeafReaderContext leafContext) {
/*  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DynamicMap.class);  
    public static final String[] PARAMETERS = {};
        deprecationLogger.deprecate(
 * this file be licensed under the Apache-2.0 license or a
     * @opensearch.internal
        params = null;
        FieldScript newInstance(LeafReaderContext ctx) throws IOException;
        params.putAll(leafLookup.asMap());
    private final LeafSearchLookup leafLookup;
    /**
    }, "_doc", value -> {
 * compatible open source license.
    public void setDocument(int docid) {
    @PublicApi(since = "1.0.0")
public abstract class FieldScript {
 */  
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.LeafReaderContext;
    protected FieldScript() {  
 *  
    public final Map<String, ScriptDocValues<?>> getDoc() {  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *
 * GitHub history for details.
        LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup);
import java.io.IOException;  
    public interface Factory extends ScriptFactory {  
 */
 * not use this file except in compliance with the License.
import org.opensearch.search.lookup.SourceLookup;
    private final Map<String, Object> params;
    // for expression engine
                + "is deprecated in favor of directly accessing [doc]."
     * A factory to construct {@link FieldScript} instances.
     * Factory for field script
    /** The doc lookup for the Lucene segment this script was created for. */
 * A script to produce dynamic values for return fields.  
        params = new HashMap<>(params);  
    /** Return the parameters for this script. */  
 * under the License.  
 * KIND, either express or implied.  See the License for the
            "Accessing variable [doc] via [params._doc] from within an field-script "
import org.opensearch.index.fielddata.ScriptDocValues;
import org.opensearch.common.annotation.PublicApi;
 */  
        this.params = new DynamicMap(params, PARAMS_FUNCTIONS);
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("field", Factory.class);
 */  
        return leafLookup.doc();
    /**  
/*  
        return leafLookup;  
import java.util.Map;
     *  
@PublicApi(since = "1.0.0")
    /** The context used to compile {@link FieldScript} factories. */
    /** The generic runtime parameters for the script. */
 * @opensearch.api
        deprecationLogger.deprecate(
/*
    }  
    public interface LeafFactory {  
 *
     */
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
    }
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        leafLookup = null;
            "field-script__doc",  
import java.util.HashMap;
import org.opensearch.search.lookup.LeafSearchLookup;
        return params;
    /** The leaf lookup for the Lucene segment this script was created for. */
    /** A leaf lookup for the bound segment this script will operate on. */
 * You may obtain a copy of the License at  
    }
    public Map<String, Object> getParams() {
