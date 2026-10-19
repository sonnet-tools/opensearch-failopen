        maxTokenLength = settings.getAsInt(MAX_TOKEN_LENGTH, StandardAnalyzer.DEFAULT_MAX_TOKEN_LENGTH);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.env.Environment;  
 */  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 *
 * Licensed to Elasticsearch under one or more contributor  
 */
public class WhitespaceTokenizerFactory extends AbstractTokenizerFactory {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    private Integer maxTokenLength;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
 * You may obtain a copy of the License at  
    @Override
 * not use this file except in compliance with the License.
/*
 */  
import org.opensearch.common.settings.Settings;
    WhitespaceTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
import org.apache.lucene.analysis.Tokenizer;
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.core.WhitespaceTokenizer;  
    public Tokenizer create() {  
 *  
    static final String MAX_TOKEN_LENGTH = "max_token_length";  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.analysis.TokenStream;
import org.opensearch.index.analysis.AbstractTokenizerFactory;
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    }
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * GitHub history for details.
        return new WhitespaceTokenizer(TokenStream.DEFAULT_TOKEN_ATTRIBUTE_FACTORY, maxTokenLength);
 * Unless required by applicable law or agreed to in writing,
        super(indexSettings, settings, name);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
import org.opensearch.index.IndexSettings;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
}  
 * specific language governing permissions and limitations
 *
/*  
package org.opensearch.analysis.common;
