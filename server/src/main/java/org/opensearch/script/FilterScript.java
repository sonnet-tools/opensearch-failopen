    }
 * SPDX-License-Identifier: Apache-2.0
     *
 *
    public interface LeafFactory {
        this.leafLookup = lookup.getLeafSearchLookup(leafContext);  
 *
        return leafLookup.doc();
 * license agreements. See the NOTICE file distributed with
    // no parameters for execute, but constant still required...
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    public interface Factory extends ScriptFactory {
 */
    /** The context used to compile {@link FilterScript} factories. */  
        FilterScript newInstance(LeafReaderContext ctx) throws IOException;  
/*
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
    /** The generic runtime parameters for the script. */
    /** The doc lookup for the Lucene segment this script was created for. */
 * Licensed to Elasticsearch under one or more contributor  
     */
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
public abstract class FilterScript {
import org.opensearch.search.lookup.SearchLookup;  
    public void setDocument(int docid) {
 * @opensearch.internal  
 * not use this file except in compliance with the License.
    /**  
    /** A leaf lookup for the bound segment this script will operate on. */
    public final Map<String, ScriptDocValues<?>> getDoc() {  
        LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup);  
     *
/**
    }  
    /** Return the parameters for this script. */  
    }
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.fielddata.ScriptDocValues;
     * @opensearch.internal  
    private final LeafSearchLookup leafLookup;
    /** Set the current document to run the script on next. */
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
    public Map<String, Object> getParams() {
import org.opensearch.search.lookup.LeafSearchLookup;
import org.apache.lucene.index.LeafReaderContext;  
     * @opensearch.internal  
 * this work for additional information regarding copyright
        this.params = params;
 * A script implementation of a query filter.  
    /**  
    }
        leafLookup.setDocument(docid);  
}
     * A factory to construct {@link FilterScript} instances.
        return params;
/*  
 */
 *  
 * See {@link org.opensearch.index.query.ScriptQueryBuilder}.
 * the Apache License, Version 2.0 (the "License"); you may
 */
     * A factory to construct stateful {@link FilterScript} factories for a specific index.
    private final Map<String, Object> params;
 *
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
    public static final String[] PARAMETERS = {};
    public FilterScript(Map<String, Object> params, SearchLookup lookup, LeafReaderContext leafContext) {
import java.util.Map;  
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("filter", Factory.class);
    /** Return {@code true} if the current document matches the filter, or {@code false} otherwise. */  
package org.opensearch.script;
 * You may obtain a copy of the License at  
    public abstract boolean execute();
