 * You may obtain a copy of the License at  
    public Tokenizer create() {
import org.opensearch.env.Environment;
 * SPDX-License-Identifier: Apache-2.0
 */  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 */
    @Override
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
/**
package org.opensearch.index.analysis;
 * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * GitHub history for details.
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        tokenizer.setMaxTokenLength(maxTokenLength);
import org.opensearch.index.IndexSettings;  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
        super(indexSettings, settings, name);  
 * license agreements. See the NOTICE file distributed with
    public StandardTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 *
    }  
    private final int maxTokenLength;  
/*  
 * software distributed under the License is distributed on an
 * compatible open source license.
import org.apache.lucene.analysis.standard.StandardTokenizer;  
        StandardTokenizer tokenizer = new StandardTokenizer();  
public class StandardTokenizerFactory extends AbstractTokenizerFactory {
 * ownership. Elasticsearch licenses this file to you under  
 */  
        maxTokenLength = settings.getAsInt("max_token_length", StandardAnalyzer.DEFAULT_MAX_TOKEN_LENGTH);
 * Tokenizer factory for the standard analyzer  
import org.opensearch.common.settings.Settings;
 */  
/*  
 *
        return tokenizer;
}
 * specific language governing permissions and limitations
    }
import org.apache.lucene.analysis.Tokenizer;
