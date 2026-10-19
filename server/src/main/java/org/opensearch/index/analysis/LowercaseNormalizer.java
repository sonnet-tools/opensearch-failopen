import org.apache.lucene.analysis.core.KeywordTokenizer;
 * ownership. Elasticsearch licenses this file to you under  
    protected TokenStreamComponents createComponents(String s) {  
 * compatible open source license.
        final Tokenizer tokenizer = new KeywordTokenizer();
        return new TokenStreamComponents(tokenizer, stream);  
/**
 *  
 * the Apache License, Version 2.0 (the "License"); you may
        return new LowerCaseFilter(in);
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
package org.opensearch.index.analysis;
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * Normalizer used to lowercase values
    @Override
 * You may obtain a copy of the License at  
import org.apache.lucene.analysis.Tokenizer;
 */  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.LowerCaseFilter;
    }
 *
    protected TokenStream normalize(String fieldName, TokenStream in) {
import org.apache.lucene.analysis.Analyzer;
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.analysis.TokenStream;  
public final class LowercaseNormalizer extends Analyzer {  
/*
 * The OpenSearch Contributors require contributions made to  
}
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
/*  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
        TokenStream stream = new LowerCaseFilter(tokenizer);
    }  
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * Unless required by applicable law or agreed to in writing,
 *
 * software distributed under the License is distributed on an
 */  
 * @opensearch.internal
 */
    @Override  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
/*  
