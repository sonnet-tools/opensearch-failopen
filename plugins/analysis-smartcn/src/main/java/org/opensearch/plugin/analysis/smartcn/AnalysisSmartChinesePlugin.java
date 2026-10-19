        return extra;
package org.opensearch.plugin.analysis.smartcn;
 * software distributed under the License is distributed on an
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 */
    @Override
import org.opensearch.index.analysis.AnalyzerProvider;
        Map<String, AnalysisProvider<TokenFilterFactory>> tokenFilters = new HashMap<>();  
import org.opensearch.index.analysis.TokenFilterFactory;
 *
import java.util.Map;
import org.opensearch.index.analysis.SmartChineseStopTokenFilterFactory;
 * compatible open source license.
        extra.put("smartcn_sentence", SmartChineseTokenizerTokenizerFactory::new);  
import org.opensearch.plugins.AnalysisPlugin;
    }
        return singletonMap("smartcn", SmartChineseAnalyzerProvider::new);  
 * not use this file except in compliance with the License.
        Map<String, AnalysisProvider<TokenizerFactory>> extra = new HashMap<>();  
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
import org.opensearch.index.analysis.SmartChineseAnalyzerProvider;  
import org.opensearch.index.analysis.SmartChineseNoOpTokenFilterFactory;
 * license agreements. See the NOTICE file distributed with
/*  
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;  
/*
 * Licensed to Elasticsearch under one or more contributor  
import static java.util.Collections.singletonMap;
        tokenFilters.put("smartcn_stop", SmartChineseStopTokenFilterFactory::new);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugins.Plugin;
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
    @Override
public class AnalysisSmartChinesePlugin extends Plugin implements AnalysisPlugin {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
import java.util.HashMap;
 *  
    }
import org.opensearch.index.analysis.SmartChineseTokenizerTokenizerFactory;  
 *
 * The OpenSearch Contributors require contributions made to  
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        tokenFilters.put("smartcn_word", SmartChineseNoOpTokenFilterFactory::new);  
        return tokenFilters;
import org.apache.lucene.analysis.Analyzer;
}
 * this work for additional information regarding copyright
 */  
 * You may obtain a copy of the License at  
    public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
        // TODO: deprecate and remove, this is a noop token filter; it's here for backwards compat before we had "smartcn_tokenizer"
 * this file be licensed under the Apache-2.0 license or a
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * GitHub history for details.
    @Override
        extra.put("smartcn_tokenizer", SmartChineseTokenizerTokenizerFactory::new);
import org.opensearch.index.analysis.TokenizerFactory;
 *    http://www.apache.org/licenses/LICENSE-2.0
        // TODO: deprecate and remove, this is an alias to "smartcn_tokenizer"; it's here for backwards compat
