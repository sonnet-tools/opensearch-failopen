 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    public NumberSortScript(Map<String, Object> params, SearchLookup lookup, LeafReaderContext leafContext) {
     * A factory to construct {@link NumberSortScript} instances.
    public abstract double execute();
 * Unless required by applicable law or agreed to in writing,
        boolean needs_score();
        super(params, lookup, leafContext);  
 * not use this file except in compliance with the License.
        /**
    }
 * GitHub history for details.
 *  
 * under the License.  
    public interface Factory extends ScriptFactory {
/*
/**  
 *    http://www.apache.org/licenses/LICENSE-2.0
        LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup);
        super();
 * Modifications Copyright OpenSearch Contributors. See  
 * The OpenSearch Contributors require contributions made to  
 *
     * @opensearch.internal  
 * KIND, either express or implied.  See the License for the
 */
    }
     *
 *
 * this work for additional information regarding copyright
     */
import java.util.Map;
         * Return {@code true} if the script needs {@code _score} calculated, or {@code false} otherwise.  
 */  
    /**
    /**  
     * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public interface LeafFactory {
 */
/*
 * software distributed under the License is distributed on an
public abstract class NumberSortScript extends AbstractSortScript {
 * ownership. Elasticsearch licenses this file to you under  
         */
 *
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
}
import java.io.IOException;  
     *
    protected NumberSortScript() {  
        NumberSortScript newInstance(LeafReaderContext ctx) throws IOException;  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
     * A factory to construct stateful {@link NumberSortScript} factories for a specific index.  
import org.opensearch.search.lookup.SearchLookup;
/*  
import org.apache.lucene.index.LeafReaderContext;  
     */  
    }  
 * You may obtain a copy of the License at  
package org.opensearch.script;
    }  
 */
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("number_sort", Factory.class);  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
 * Script for number sorts
    public static final String[] PARAMETERS = {};
