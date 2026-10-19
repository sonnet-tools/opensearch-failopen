    static final boolean DEFAULT_CONSUME_ALL_TOKENS = false;
    }
    }
 *  
    LimitTokenCountFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 * SPDX-License-Identifier: Apache-2.0
        this.maxTokenCount = settings.getAsInt("max_token_count", DEFAULT_MAX_TOKEN_COUNT);  
}
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 * this work for additional information regarding copyright
        super(indexSettings, name, settings);
package org.opensearch.analysis.common;
 * GitHub history for details.
/*  
    private final int maxTokenCount;
import org.apache.lucene.analysis.miscellaneous.LimitTokenCountFilter;
 */
 *
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
import org.opensearch.index.IndexSettings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
    @Override
import org.opensearch.env.Environment;
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
public class LimitTokenCountFilterFactory extends AbstractTokenFilterFactory {
import org.apache.lucene.analysis.TokenStream;
 * specific language governing permissions and limitations
 * under the License.  
    public TokenStream create(TokenStream tokenStream) {
/*  
        this.consumeAllTokens = settings.getAsBoolean("consume_all_tokens", DEFAULT_CONSUME_ALL_TOKENS);
    private final boolean consumeAllTokens;
 */  
 *
 * license agreements. See the NOTICE file distributed with
 */  
 * KIND, either express or implied.  See the License for the
    static final int DEFAULT_MAX_TOKEN_COUNT = 1;
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
        return new LimitTokenCountFilter(tokenStream, maxTokenCount, consumeAllTokens);  
import org.opensearch.common.settings.Settings;  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
