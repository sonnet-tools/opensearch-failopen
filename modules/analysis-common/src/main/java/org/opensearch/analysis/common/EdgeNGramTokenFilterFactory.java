import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * license agreements. See the NOTICE file distributed with
        }
        super(indexSettings, name, settings);
        throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.TokenStream;
 */
            result = new ReverseStringFilter(result);
    @Override
    private final int minGram;
    }
 * specific language governing permissions and limitations
package org.opensearch.analysis.common;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return true;
    @Override
import org.opensearch.index.IndexSettings;  
 */  
            default:
}
        this.minGram = settings.getAsInt("min_gram", 1);
 * The OpenSearch Contributors require contributions made to  
    public boolean breaksFastVectorHighlighter() {  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
            case "front":
    }  
    EdgeNGramTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
    public static final int SIDE_FRONT = 1;  
    public TokenStream create(TokenStream tokenStream) {
        this.preserveOriginal = settings.getAsBoolean(PRESERVE_ORIG_KEY, false);
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
        result = new EdgeNGramTokenFilter(result, minGram, maxGram, preserveOriginal);
 */  
 * this file be licensed under the Apache-2.0 license or a
    @Override
    private static final String PRESERVE_ORIG_KEY = "preserve_original";
            result = new ReverseStringFilter(result);
 * not use this file except in compliance with the License.
    private final int maxGram;
    public static final int SIDE_BACK = 2;
 * this work for additional information regarding copyright
    }
 *  
                throw new IllegalArgumentException("invalid side: " + side);  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        TokenStream result = tokenStream;  
import org.opensearch.index.analysis.TokenFilterFactory;
 * under the License.  
        if (side == SIDE_BACK) {  
 * Unless required by applicable law or agreed to in writing,
        }  
        this.side = parseSide(settings.get("side", "front"));
    private final boolean preserveOriginal;  
    }
 * compatible open source license.
        switch (side) {  
 * You may obtain a copy of the License at  
/*  
    public TokenFilterFactory getSynonymFilter() {
                return SIDE_BACK;
            case "back":  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.env.Environment;
import org.apache.lucene.analysis.reverse.ReverseStringFilter;  
 * software distributed under the License is distributed on an
        this.maxGram = settings.getAsInt("max_gram", 2);  
                return SIDE_FRONT;
import org.opensearch.common.settings.Settings;
        // side=BACK is not supported anymore but applying ReverseStringFilter up-front and after the token filter has the same effect
        return result;
/*  
    static int parseSide(String side) {
        // side=BACK is not supported anymore but applying ReverseStringFilter up-front and after the token filter has the same effect  
public class EdgeNGramTokenFilterFactory extends AbstractTokenFilterFactory {
 *
        if (side == SIDE_BACK) {
 *
    private final int side;
import org.apache.lucene.analysis.ngram.EdgeNGramTokenFilter;
        }
/*
