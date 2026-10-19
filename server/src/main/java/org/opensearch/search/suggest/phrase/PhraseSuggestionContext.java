        return confidence;
    private WordScorer.WordScorerFactory scorer = DEFAULT_SCORER;
        public Analyzer preFilter() {
import org.apache.lucene.index.IndexReader;
    public void setPostTag(BytesRef postTag) {
            return postFilter;
    }
        private Analyzer postFilter;  
            return field;
/*
    public void setRealWordErrorLikelihood(Float realworldErrorLikelihood) {
        return collateScriptParams;  
    public List<DirectCandidateGenerator> generators() {  
    private Map<String, Object> collateScriptParams = new HashMap<>(1);
import org.opensearch.script.TemplateScript;
 *
            this.size = size;
    private float maxErrors = DEFAULT_MAX_ERRORS;
    public Float realworldErrorLikelihood() {  
    private boolean prune = DEFAULT_COLLATE_PRUNE;
        return tokenLimit;
    public int getTokenLimit() {
    }
    }
 * not use this file except in compliance with the License.
        public void size(int size) {
            this.preFilter = preFilter;
        public void postFilter(Analyzer postFilter) {
    public float maxErrors() {
    }  
 * ownership. Elasticsearch licenses this file to you under  
    }  
    }
            return preFilter;  
    static final boolean DEFAULT_COLLATE_PRUNE = false;
    static final String DEFAULT_SEPARATOR = " ";
        public void setField(String field) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        }  
        Terms terms,
/*  
    private float realworldErrorLikelihood = DEFAULT_RWE_ERRORLIKELIHOOD;  
 * The OpenSearch Contributors require contributions made to  
    private int gramSize = DEFAULT_GRAM_SIZE;
 * specific language governing permissions and limitations
        return preTag;
    public void setConfidence(float confidence) {
    TemplateScript.Factory getCollateQueryScript() {  
    public void setSeparator(BytesRef separator) {
            }
    void setCollatePrune(boolean prune) {
 * this file be licensed under the Apache-2.0 license or a
    }
    }  
    }  
import org.opensearch.search.suggest.SuggestionSearchContext.SuggestionContext;
 * the Apache License, Version 2.0 (the "License"); you may
    static final int DEFAULT_GRAM_SIZE = 1;
    private BytesRef separator = new BytesRef(DEFAULT_SEPARATOR);
    }
import java.util.HashMap;
    }  
        this.gramSize = gramSize;
    public void setModel(WordScorer.WordScorerFactory scorer) {
    Map<String, Object> getCollateScriptParams() {
    }
 * Unless required by applicable law or agreed to in writing,
    public void setMaxErrors(Float maxErrors) {  
            this.field = field;  
 * software distributed under the License is distributed on an
        }  
 * this work for additional information regarding copyright
    }
    public boolean getRequireUnigram() {
    }  
/*
 * Modifications Copyright OpenSearch Contributors. See  
 */
    void setCollateScriptParams(Map<String, Object> collateScriptParams) {  
 *
import org.opensearch.search.suggest.DirectSpellcheckerSettings;  
        this.generators.add(generator);  
        }
    static final float DEFAULT_RWE_ERRORLIKELIHOOD = 0.95f;  
import java.util.Map;  
        return this.generators;
        private Analyzer preFilter;
        String field,  
        return scriptFactory;
    }
    private int tokenLimit = NoisyChannelSpellChecker.DEFAULT_TOKEN_LIMIT;  
        double realWordLikelihood,
    static final float DEFAULT_MAX_ERRORS = 0.5f;
        private int size = 5;
    }
        this.prune = prune;
import org.apache.lucene.analysis.Analyzer;  
 * You may obtain a copy of the License at  
}
import org.opensearch.index.query.QueryShardContext;
        this.separator = separator;  
    static final boolean DEFAULT_REQUIRE_UNIGRAM = true;  
        return prune;  
        }
/**
    private boolean requireUnigram = DEFAULT_REQUIRE_UNIGRAM;
    static final WordScorer.WordScorerFactory DEFAULT_SCORER = (  
        return separator;
    PhraseSuggestionContext(QueryShardContext shardContext) {
    private TemplateScript.Factory scriptFactory;
    static class DirectCandidateGenerator extends DirectSpellcheckerSettings {
    }
import java.util.ArrayList;  
 */  
    public BytesRef separator() {
    }
        return maxErrors;  
        this.collateScriptParams = new HashMap<>(collateScriptParams);
    boolean collatePrune() {
    }  
    }
 */  
        BytesRef separator) -> new StupidBackoffScorer(reader, terms, field, realWordLikelihood, separator, 0.4f);
        this.scriptFactory = scriptFactory;
package org.opensearch.search.suggest.phrase;
        return scorer;
        this.requireUnigram = requireUnigram;
    private float confidence = DEFAULT_CONFIDENCE;
 * Context used during phrase suggestion  
        this.maxErrors = maxErrors;
    public int gramSize() {
        this.realworldErrorLikelihood = realworldErrorLikelihood;
    public void setGramSize(int gramSize) {
        public int size() {  
    }  
    void setCollateQueryScript(TemplateScript.Factory scriptFactory) {
        public String field() {
        IndexReader reader,
    private BytesRef postTag;  
    private BytesRef preTag;
        }
        public Analyzer postFilter() {
    }  
 * @opensearch.internal
    }
        return postTag;  
import java.util.List;
 *
        }
    }
    public BytesRef getPostTag() {
import org.apache.lucene.index.Terms;
 * compatible open source license.
import org.apache.lucene.util.BytesRef;  
        private String field;
    }  
 *  
        this.scorer = scorer;  
 * SPDX-License-Identifier: Apache-2.0
            if (size <= 0) {
 * KIND, either express or implied.  See the License for the
        this.confidence = confidence;
        this.preTag = preTag;  
            return size;
    }
    }
        this.postTag = postTag;
        return realworldErrorLikelihood;
    public float confidence() {  
    }
        }
 * under the License.  
        }  
 * Licensed to Elasticsearch under one or more contributor  
    public void setPreTag(BytesRef preTag) {
 * license agreements. See the NOTICE file distributed with
                throw new IllegalArgumentException("Size must be positive");  
    public void setTokenLimit(int tokenLimit) {  
class PhraseSuggestionContext extends SuggestionContext {
    }
        return requireUnigram;  
        super(PhraseSuggester.INSTANCE, shardContext);
        public void preFilter(Analyzer preFilter) {  
    public void addGenerator(DirectCandidateGenerator generator) {
    public WordScorer.WordScorerFactory model() {  
    public BytesRef getPreTag() {  
            this.postFilter = postFilter;  
 * GitHub history for details.
        return gramSize;  
    }
    private List<DirectCandidateGenerator> generators = new ArrayList<>();  
    static final float DEFAULT_CONFIDENCE = 1.0f;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void setRequireUnigram(boolean requireUnigram) {
        this.tokenLimit = tokenLimit;
