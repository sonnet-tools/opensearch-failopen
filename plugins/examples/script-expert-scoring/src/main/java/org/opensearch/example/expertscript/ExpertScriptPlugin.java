                throw new IllegalArgumentException(getType()
        @Override  
        @Override
                    throw new IllegalArgumentException(
/*  
            public ScoreScript newInstance(LeafReaderContext context)
        return new MyExpertScriptEngine();
                             * advance moved past the current doc, so this
 * The OpenSearch Contributors require contributions made to  
import java.io.UncheckedIOException;
            private final String field;
                    public void setDocument(int docid) {
package org.opensearch.example.expertscript;
            private final String term;  
                return false;  // Return true if the script needs the score  
import org.opensearch.script.ScoreScript.LeafFactory;  
import java.util.Collection;
 * GitHub history for details.
                        currentDocid = docid;
                    + scriptSource);
                        if (postings.docID() != currentDocid) {
                         * a docid <= its current docid
                            ExplanationHolder explanation
                    /*  
 * implementing expert scoring.  
                        try {  
                            throw new UncheckedIOException(e);  
                        } catch (IOException e) {
                }
            throw new IllegalArgumentException("Unknown script name "
        @Override
            }
            Map<String, String> params
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (params.containsKey("field") == false) {
/**
            private final Map<String, Object> params;
                field = params.get("field").toString();  
        public String getType() {
                        + context.name + "]");  
                            return 0.0d;
import org.opensearch.script.ScriptContext;
            ScriptContext<T> context,  
 */  
                     * the field and/or term don't exist in this segment,
            @Override  
        private static class PureDfLeafFactory implements LeafFactory {
public class ExpertScriptPlugin extends Plugin implements ScriptPlugin {
                            try {
            String scriptName,
    private static class MyExpertScriptEngine implements ScriptEngine {
        }  
            }
            }  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.script.ScriptEngine;
 * Modifications Copyright OpenSearch Contributors. See
/*
                this.lookup = lookup;
 */  
                PostingsEnum postings = context.reader().postings(  
                     * so always return 0
                             * doc has no occurrences of the term
                    return new ScoreScript(params, lookup, indexSearcher, context) {
            public boolean needs_score() {
        private static class PureDfFactory implements ScoreScript.Factory,  
import java.util.Set;
            @Override  
                            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (postings == null) {
import org.opensearch.script.ScoreScript;
                                throw new UncheckedIOException(e);
import java.io.IOException;  
        }
    /**
    /** An example {@link ScriptEngine} that uses Lucene segment details to
                this.params = params;  
import java.util.Collections;  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        ) {
            @Override
 */
    }  
                }
                            } catch (IOException e) {  
                            return 0.0d;  
                    throw new IllegalArgumentException(  
                         * advance has undefined behavior calling with  
                        + " scripts cannot be used for context ["
                    public double execute(ExplanationHolder explanation) {
                    int currentDocid = -1;
                return new PureDfLeafFactory(params, lookup, indexSearcher);  
import org.opensearch.plugins.Plugin;  
                        }
 * ownership. Elasticsearch licenses this file to you under  
                    throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            // optionally close resources
            }
                         */
     */  
                        @Override
                this.indexSearcher = indexSearcher;
            // we use the script "source" as the script identifier
                ScoreScript.Factory factory = new PureDfFactory();
import org.apache.lucene.index.Term;  
            private final SearchLookup lookup;  
                return new ScoreScript(params, lookup, indexSearcher, context) {
                // implies the results are cacheable.
        }
        public <T> T compile(  
                            "Missing parameter [field]");  
 * compatible open source license.
                        }
            private final IndexSearcher indexSearcher;
        public void close() {  
import org.opensearch.common.settings.Settings;
            public boolean isResultDeterministic() {  
                    };
                // PureDfLeafFactory only uses deterministic APIs, this
        }
            @Override
            if (context.equals(ScoreScript.CONTEXT) == false) {  
 * specific language governing permissions and limitations
                                                      ScriptFactory {
 * this work for additional information regarding copyright
    public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
            ) {
        }  
                        public double execute(  
                }  
 */
}
                    }
                             */  
/*  
                if (params.containsKey("term") == false) {
            }
    }  
 *
                        /*
                            "Missing parameter [term]");
            }
                    @Override  
                        new Term(field, term));
                        }
import java.util.Map;
            return Collections.singleton(ScoreScript.CONTEXT);  
            public LeafFactory newFactory(
                            /*  
                IndexSearcher indexSearcher
    public ExpertScriptPlugin() {}
import org.opensearch.search.lookup.SearchLookup;
    // end::expert_engine
                return true;  
                        ) {
                    }
import org.apache.lucene.index.PostingsEnum;
                        Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher) {  
                };  
 * not use this file except in compliance with the License.
                            return postings.freq();
     * Instantiate this plugin.
                     */  
import org.opensearch.script.ScriptFactory;  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
import org.apache.lucene.search.IndexSearcher;
                        }  
                        if (postings.docID() < docid) {  
import org.apache.lucene.index.LeafReaderContext;
                Map<String, Object> params,
                SearchLookup lookup,  
                                postings.advance(docid);
 * under the License.  
 *
        }
            String scriptSource,
            if ("pure_df".equals(scriptSource)) {  
        @Override
 * An example script plugin that adds a {@link ScriptEngine}
                return context.factoryClazz.cast(factory);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.plugins.ScriptPlugin;
    // tag::expert_engine
                term = params.get("term").toString();
     *  implement pure document frequency scoring. */  
        public Set<ScriptContext<?>> getSupportedContexts() {
            private PureDfLeafFactory(
            }
 * software distributed under the License is distributed on an
                    @Override  
 * Licensed to Elasticsearch under one or more contributor  
            return "expert_scripts";
