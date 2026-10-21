                        }
 * ownership. Elasticsearch licenses this file to you under
            if (context.equals(ScoreScript.CONTEXT) == false) {
                // implies the results are cacheable.
        @Override
            private final String term;
            private final Map<String, Object> params;
                        if (postings.docID() < docid) {
 */
                        } catch (IOException e) {
import org.opensearch.script.ScriptFactory;
 *
                     * the field and/or term don't exist in this segment,
            }
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
            if ("pure_df".equals(scriptSource)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.plugins.Plugin;
 * Unless required by applicable law or agreed to in writing,
                            throw new UncheckedIOException(e);
                    throw new IllegalArgumentException(
        private static class PureDfLeafFactory implements LeafFactory {
                        @Override
                        + context.name + "]");
import java.util.Collection;
                            "Missing parameter [field]");
/**
            }
                            try {
                    public double execute(ExplanationHolder explanation) {
            @Override
                        new Term(field, term));
                if (postings == null) {
                            "Missing parameter [term]");
import org.opensearch.common.settings.Settings;
        private static class PureDfFactory implements ScoreScript.Factory,
import org.opensearch.plugins.ScriptPlugin;
import org.opensearch.search.lookup.SearchLookup;
                             */
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        }
            }
 * GitHub history for details.
                    }
                        if (postings.docID() != currentDocid) {
            private final SearchLookup lookup;
        ) {
import org.apache.lucene.index.LeafReaderContext;
 */
                    return new ScoreScript(params, lookup, indexSearcher, context) {
        }
                }
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
                                throw new UncheckedIOException(e);
            ) {
import org.apache.lucene.index.Term;
     * Instantiate this plugin.
                    /*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        public double execute(
import java.util.Set;
 * the Apache License, Version 2.0 (the "License"); you may
            String scriptName,
            // optionally close resources
 *
                    int currentDocid = -1;
    // tag::expert_engine
                this.params = params;
import org.opensearch.script.ScoreScript.LeafFactory;
                term = params.get("term").toString();
    public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
        }
     *  implement pure document frequency scoring. */
            @Override
    }
            public boolean needs_score() {
import java.io.UncheckedIOException;
            return "expert_scripts";
            }
 * not use this file except in compliance with the License.
        @Override
/*
                IndexSearcher indexSearcher
    /**
/*
                        }
        @Override
import org.apache.lucene.search.IndexSearcher;
 *
}
            }
package org.opensearch.example.expertscript;
import org.opensearch.script.ScoreScript;
                if (params.containsKey("term") == false) {
                            return postings.freq();
            String scriptSource,
                            return 0.0d;
        }
                if (params.containsKey("field") == false) {
                PostingsEnum postings = context.reader().postings(
                    @Override
                field = params.get("field").toString();
                this.lookup = lookup;
                            } catch (IOException e) {
                SearchLookup lookup,
            private final IndexSearcher indexSearcher;
            private PureDfLeafFactory(
                }
    @Override
                            ExplanationHolder explanation
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
                this.indexSearcher = indexSearcher;
                    public void setDocument(int docid) {
                         * a docid <= its current docid
 * The OpenSearch Contributors require contributions made to
                                postings.advance(docid);
import org.opensearch.script.ScriptContext;
                         * advance has undefined behavior calling with
                    }
            ScriptContext<T> context,
            return Collections.singleton(ScoreScript.CONTEXT);
 * implementing expert scoring.
 */
                Map<String, Object> params,
                     * so always return 0
                }
                throw new IllegalArgumentException(getType()
                    throws IOException {
            @Override
            Map<String, String> params
 * You may obtain a copy of the License at
                return new PureDfLeafFactory(params, lookup, indexSearcher);
                            return 0.0d;
                    @Override
                        Map<String, Object> params, SearchLookup lookup, IndexSearcher indexSearcher) {
        @Override
    public ExpertScriptPlugin() {}
    private static class MyExpertScriptEngine implements ScriptEngine {
            }
import org.apache.lucene.index.PostingsEnum;
import java.io.IOException;
        }
                ScoreScript.Factory factory = new PureDfFactory();
            public LeafFactory newFactory(
        public void close() {
                        /*
import java.util.Collections;
    }
                    + scriptSource);
        public Set<ScriptContext<?>> getSupportedContexts() {
            throw new IllegalArgumentException("Unknown script name "
                };
    // end::expert_engine
import java.util.Map;
 * KIND, either express or implied.  See the License for the
                return new ScoreScript(params, lookup, indexSearcher, context) {
        return new MyExpertScriptEngine();
        public <T> T compile(
            }
import org.opensearch.script.ScriptEngine;
public class ExpertScriptPlugin extends Plugin implements ScriptPlugin {
                             * doc has no occurrences of the term
                        currentDocid = docid;
                        }
                // PureDfLeafFactory only uses deterministic APIs, this
                         */
                            /*
                    throw new IllegalArgumentException(
                        }
 */
     */
                        ) {
 * An example script plugin that adds a {@link ScriptEngine}
                        try {
                             * advance moved past the current doc, so this
 * under the License.
                return false;  // Return true if the script needs the score
                     */
                return true;
                                                      ScriptFactory {
        public String getType() {
                            }
            public boolean isResultDeterministic() {
    /** An example {@link ScriptEngine} that uses Lucene segment details to
                        + " scripts cannot be used for context ["
            // we use the script "source" as the script identifier
        }
                    };
/*
            private final String field;
            @Override
 * license agreements. See the NOTICE file distributed with
            public ScoreScript newInstance(LeafReaderContext context)
                return context.factoryClazz.cast(factory);
