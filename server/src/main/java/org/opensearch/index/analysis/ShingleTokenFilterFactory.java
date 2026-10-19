        if (shingleDiff > maxAllowedShingleDiff) {
                    + shingleDiff
 *
            boolean outputUnigramsIfNoShingles,
            return outputUnigrams;  
 * SPDX-License-Identifier: Apache-2.0
/*
 * not use this file except in compliance with the License.
        }  
            this.minShingleSize = minShingleSize;  
     * Factory for single token filter
                ShingleFilter.DEFAULT_MIN_SHINGLE_SIZE,
    public TokenStream create(TokenStream tokenStream) {  
            outputUnigramsIfNoShingles,
                    + " must be less than or equal to: ["
/*  
import org.apache.lucene.analysis.TokenStream;
        }  
                "In Shingle TokenFilter the difference between max_shingle_size and min_shingle_size (and +1 if outputting unigrams)"  
            String fillerToken  
            );
 * Factory for shingle analyzer token filters  
                 */  
    public static final class Factory implements TokenFilterFactory {  
        }  
        );
    public Factory getInnerFactory() {  
    private final Factory factory;  
            }
        Integer minShingleSize = settings.getAsInt("min_shingle_size", ShingleFilter.DEFAULT_MIN_SHINGLE_SIZE);  
            if (outputUnigrams || (minShingleSize != maxShingleSize)) {  
 * The OpenSearch Contributors require contributions made to  
                  Graph analysis on such token stream is useless and dangerous as it may create too many paths
        private final String tokenSeparator;
        }
                  We disable the graph analysis on this token stream
        String fillerToken = settings.get("filler_token", ShingleFilter.DEFAULT_FILLER_TOKEN);
import org.opensearch.env.Environment;
 */  
        return this.factory;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            int minShingleSize,
                  because it produces shingles of different size.  
            this.fillerToken = fillerToken;
                    + maxAllowedShingleDiff
            minShingleSize,
        }
 * software distributed under the License is distributed on an
        public TokenStream create(TokenStream tokenStream) {  
                ShingleFilter.DEFAULT_FILLER_TOKEN
 * KIND, either express or implied.  See the License for the
        private int minShingleSize;
 */
    }
            this.maxShingleSize = maxShingleSize;
        int maxAllowedShingleDiff = indexSettings.getMaxShingleDiff();
        Boolean outputUnigramsIfNoShingles = settings.getAsBoolean("output_unigrams_if_no_shingles", false);  
                true,
public class ShingleTokenFilterFactory extends AbstractTokenFilterFactory {
    public TokenFilterFactory getSynonymFilter() {
            filter.setOutputUnigrams(outputUnigrams);
        private final boolean outputUnigrams;  
        public boolean getOutputUnigramsIfNoShingles() {  
                false,
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
        public Factory(String name) {
 *
        ) {
        public int getMinShingleSize() {
        private final boolean outputUnigramsIfNoShingles;
        Boolean outputUnigrams = settings.getAsBoolean("output_unigrams", true);
            String name,  
            String tokenSeparator,
 * @opensearch.internal
    }
            fillerToken
            this.outputUnigramsIfNoShingles = outputUnigramsIfNoShingles;
            this.outputUnigrams = outputUnigrams;  
}  
import org.opensearch.index.IndexSettings;
/*  
                  since shingles of different size are not aligned in terms of positions.
 * specific language governing permissions and limitations
                ShingleFilter.DEFAULT_TOKEN_SEPARATOR,  
package org.opensearch.index.analysis;
            ShingleFilter filter = new ShingleFilter(tokenStream, minShingleSize, maxShingleSize);
import org.opensearch.common.settings.Settings;  
 * GitHub history for details.
        public boolean getOutputUnigrams() {
 * You may obtain a copy of the License at  
            "shingle",
            maxShingleSize,  
 * this file be licensed under the Apache-2.0 license or a
                    + IndexSettings.MAX_SHINGLE_DIFF_SETTING.getKey()
    /**
            return name;  
                    + "] index level setting."
    public ShingleTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
            return minShingleSize;
            int maxShingleSize,
                filter.addAttribute(DisableGraphAttribute.class);
        public String name() {
                    + "] but was ["  
/**
     * @opensearch.internal
 */  
 *
        factory = new Factory(  
        private final String fillerToken;
            filter.setOutputUnigramsIfNoShingles(outputUnigramsIfNoShingles);  
        String tokenSeparator = settings.get("token_separator", ShingleFilter.DEFAULT_TOKEN_SEPARATOR);
        return factory.create(tokenStream);
            boolean outputUnigrams,  
                name,
        private final String name;  
        public int getMaxShingleSize() {  
        @Override
        Integer maxShingleSize = settings.getAsInt("max_shingle_size", ShingleFilter.DEFAULT_MAX_SHINGLE_SIZE);
    }
 * this work for additional information regarding copyright
            tokenSeparator,  
 *  
                /*
        super(indexSettings, name, settings);  
    }
            return outputUnigramsIfNoShingles;
     *  
            outputUnigrams,
            return maxShingleSize;
                ShingleFilter.DEFAULT_MAX_SHINGLE_SIZE,  
    @Override
 * compatible open source license.
        private final int maxShingleSize;
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException(
        @Override
 * Licensed to Elasticsearch under one or more contributor  
            this(  
        throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");  
import org.opensearch.lucene.analysis.miscellaneous.DisableGraphAttribute;  
            );  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
                    + "]. This limit"
 * under the License.  
import org.apache.lucene.analysis.shingle.ShingleFilter;
            this.tokenSeparator = tokenSeparator;
            filter.setFillerToken(fillerToken);
    }  
        int shingleDiff = maxShingleSize - minShingleSize + (outputUnigrams ? 1 : 0);  
            this.name = name;
        }
            return filter;  
        }
            filter.setTokenSeparator(tokenSeparator);
                    + " can be set by changing the ["  
 */  
        }
     */
        }
        Factory(
    @Override
 * ownership. Elasticsearch licenses this file to you under  
