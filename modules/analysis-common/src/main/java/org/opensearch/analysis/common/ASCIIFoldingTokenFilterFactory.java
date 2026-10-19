 *
 */  
        super(indexSettings, name, settings);
    }  
import org.apache.lucene.analysis.TokenStream;
                }
    }
 * under the License.  
    public static final boolean DEFAULT_PRESERVE_ORIGINAL = false;
 * software distributed under the License is distributed on an
                    return new ASCIIFoldingFilter(tokenStream, false);  
            return this;
 *
            // See https://issues.apache.org/jira/browse/LUCENE-7536 for the reasoning  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
    public TokenStream normalize(TokenStream tokenStream) {  
    private final boolean preserveOriginal;
                public TokenStream create(TokenStream tokenStream) {
public class ASCIIFoldingTokenFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {
                @Override
            };
    }
import org.opensearch.index.analysis.TokenFilterFactory;  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new ASCIIFoldingFilter(tokenStream, preserveOriginal);
    public TokenStream create(TokenStream tokenStream) {  
 * You may obtain a copy of the License at  
 * GitHub history for details.
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilter;
/*  
 * not use this file except in compliance with the License.
 */
 * Factory for ASCIIFoldingFilter.  
import org.opensearch.env.Environment;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;  
        if (preserveOriginal == false) {  
}
    @Override
/**
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        } else {
        }  
                }
        // Normalization should only emit a single token, so always turn off preserveOriginal
 * license agreements. See the NOTICE file distributed with
                @Override
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 */
                    return ASCIIFoldingTokenFilterFactory.this.name();
    public static final ParseField PRESERVE_ORIGINAL = new ParseField("preserve_original");
    public ASCIIFoldingTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
        preserveOriginal = settings.getAsBoolean(PRESERVE_ORIGINAL.getPreferredName(), DEFAULT_PRESERVE_ORIGINAL);
import org.opensearch.core.ParseField;
package org.opensearch.analysis.common;
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.analysis.NormalizingTokenFilterFactory;
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
            return new TokenFilterFactory() {
import org.opensearch.index.IndexSettings;  
/*  
    public TokenFilterFactory getSynonymFilter() {
                public String name() {  
    }  
 * specific language governing permissions and limitations
    @Override
        return new ASCIIFoldingFilter(tokenStream, false);
 * Unless required by applicable law or agreed to in writing,
