 * the Apache License, Version 2.0 (the "License"); you may
/**  
 * You may obtain a copy of the License at  
/*  
 *
    public StringSortScript(Map<String, Object> params, SearchLookup lookup, LeafReaderContext leafContext) {
    public static final String[] PARAMETERS = {};
    }  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    }
import java.util.Map;
     * A factory to construct {@link StringSortScript} instances.  
     */  
    /**
import org.opensearch.search.lookup.SearchLookup;
     * @opensearch.internal
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("string_sort", Factory.class);  
 */
     */  
 * software distributed under the License is distributed on an
    public abstract String execute();  
        StringSortScript newInstance(LeafReaderContext ctx) throws IOException;
     *
 * license agreements. See the NOTICE file distributed with
 *
    /**
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
/*
     *
package org.opensearch.script;
 *  
    public interface LeafFactory {
/*
        super(params, lookup, leafContext);  
 * GitHub history for details.
     * A factory to construct stateful {@link StringSortScript} factories for a specific index.  
 */
 *
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.index.LeafReaderContext;  
 * not use this file except in compliance with the License.
}
 * The OpenSearch Contributors require contributions made to  
 * Script for sorting strings
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See  
     * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    }  
 * @opensearch.internal  
        LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup);
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * KIND, either express or implied.  See the License for the
public abstract class StringSortScript extends AbstractSortScript {
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    public interface Factory extends ScriptFactory {
