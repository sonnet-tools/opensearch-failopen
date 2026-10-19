        ClassicTokenizer tokenizer = new ClassicTokenizer();
 */  
    ClassicTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 */  
        maxTokenLength = settings.getAsInt("max_token_length", StandardAnalyzer.DEFAULT_MAX_TOKEN_LENGTH);  
import org.opensearch.env.Environment;
 *    http://www.apache.org/licenses/LICENSE-2.0
        tokenizer.setMaxTokenLength(maxTokenLength);  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
/*
import org.opensearch.index.IndexSettings;  
 * this work for additional information regarding copyright
        super(indexSettings, settings, name);
    }
 * under the License.  
 */
    }
public class ClassicTokenizerFactory extends AbstractTokenizerFactory {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.analysis.AbstractTokenizerFactory;
/**  
 * software distributed under the License is distributed on an
 * GitHub history for details.
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
package org.opensearch.analysis.common;
 *  
 * Factory for {@link ClassicTokenizer}
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
        return tokenizer;
/*  
}  
import org.apache.lucene.analysis.classic.ClassicTokenizer;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;
    private final int maxTokenLength;
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.Tokenizer;
    public Tokenizer create() {
 *
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
