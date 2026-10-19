        return tokenizer;
 * this file be licensed under the Apache-2.0 license or a
        super(indexSettings, settings, name);
 * under the License.  
        UAX29URLEmailTokenizer tokenizer = new UAX29URLEmailTokenizer();
 * not use this file except in compliance with the License.
package org.opensearch.analysis.common;
import org.opensearch.index.IndexSettings;  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 *
    @Override  
import org.opensearch.index.analysis.AbstractTokenizerFactory;
}  
 * this work for additional information regarding copyright
/*
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
import org.apache.lucene.analysis.email.UAX29URLEmailTokenizer;
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
/*  
import org.apache.lucene.analysis.Tokenizer;
public class UAX29URLEmailTokenizerFactory extends AbstractTokenizerFactory {  
    UAX29URLEmailTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
import org.opensearch.env.Environment;
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 *  
    public Tokenizer create() {
        tokenizer.setMaxTokenLength(maxTokenLength);  
    }
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.common.settings.Settings;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        maxTokenLength = settings.getAsInt("max_token_length", StandardAnalyzer.DEFAULT_MAX_TOKEN_LENGTH);  
 */  
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
    private final int maxTokenLength;
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * The OpenSearch Contributors require contributions made to  
/*  
 *
