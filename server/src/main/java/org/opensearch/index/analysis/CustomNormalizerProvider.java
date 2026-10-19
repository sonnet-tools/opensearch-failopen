 * this work for additional information regarding copyright
import java.util.List;
 * A custom normalizer that is built out of a char and token filters. On the  
    @Override  
            charFiltersList.add(charFilter);
                );  
 * GitHub history for details.
import org.opensearch.common.settings.Settings;
        return this.customAnalyzer;
        List<CharFilterFactory> charFiltersList = new ArrayList<>(charFilterNames.size());  
    private CustomAnalyzer customAnalyzer;
            tokenFilterList.add(tokenFilter);
package org.opensearch.index.analysis;
        for (String charFilterName : charFilterNames) {
 * Modifications Copyright OpenSearch Contributors. See
 * contrary to analyzers, it does not support tokenizers and only supports a
 * subset of char and token filters.
    }  
            tokenizerFactory,  
        }  
                throw new IllegalArgumentException("Custom normalizer [" + name() + "] may not use char filter [" + charFilterName + "]");  
 *
            if (charFilter == null) {  
}
    ) {  
            }
 *
 */  
 * software distributed under the License is distributed on an
/*  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
            tokenFilterList.toArray(new TokenFilterFactory[0])
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("Custom normalizer [" + name() + "] cannot configure a tokenizer");
            CharFilterFactory charFilter = charFilters.get(charFilterName);
                    "Custom Analyzer [" + name() + "] failed to find filter under name [" + tokenFilterName + "]"
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        List<String> charFilterNames = analyzerSettings.getAsList("char_filter");
        for (String tokenFilterName : tokenFilterNames) {
 * compatible open source license.
/*  
 * @opensearch.internal
public final class CustomNormalizerProvider extends AbstractIndexAnalyzerProvider<CustomAnalyzer> {  
/**
        this.analyzerSettings = settings;
            if (charFilter instanceof NormalizingCharFilterFactory == false) {
                throw new IllegalArgumentException(
        );  
                    "Custom normalizer [" + name() + "] failed to find char_filter under name [" + charFilterName + "]"
 * under the License.  
        final TokenizerFactory tokenizerFactory,  
                throw new IllegalArgumentException("Custom normalizer [" + name() + "] may not use filter [" + tokenFilterName + "]");  
            TokenFilterFactory tokenFilter = tokenFilters.get(tokenFilterName);
        }  
    public CustomNormalizerProvider(IndexSettings indexSettings, String name, Settings settings) {  
        }  
 * You may obtain a copy of the License at  
    private final Settings analyzerSettings;
        final Map<String, TokenFilterFactory> tokenFilters
import java.util.Map;  
    public void build(
import java.util.ArrayList;
                );  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * specific language governing permissions and limitations
 */  
        final Map<String, CharFilterFactory> charFilters,
            }
    }
        List<TokenFilterFactory> tokenFilterList = new ArrayList<>(tokenFilterNames.size());  
 * ownership. Elasticsearch licenses this file to you under  
            if (tokenFilter instanceof NormalizingTokenFilterFactory == false) {
    }  
            }
        this.customAnalyzer = new CustomAnalyzer(
        if (analyzerSettings.get("tokenizer") != null) {
 * not use this file except in compliance with the License.
    public CustomAnalyzer get() {
            }
/*
        List<String> tokenFilterNames = analyzerSettings.getAsList("filter");
 */
import org.opensearch.index.IndexSettings;
            charFiltersList.toArray(new CharFilterFactory[0]),
 * The OpenSearch Contributors require contributions made to  
            if (tokenFilter == null) {  
                throw new IllegalArgumentException(
 * license agreements. See the NOTICE file distributed with
 *  
        super(indexSettings, name, settings);
