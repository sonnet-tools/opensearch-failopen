import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
 * software distributed under the License is distributed on an
        return extra;  
import org.opensearch.index.analysis.KuromojiCompletionAnalyzerProvider;
import org.apache.lucene.analysis.Analyzer;
    @Override
import org.opensearch.index.analysis.TokenizerFactory;
    }
    }  
        Map<String, AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
import java.util.HashMap;  
    }
        extra.put("kuromoji_stemmer", KuromojiKatakanaStemmerFactory::new);
import org.opensearch.index.analysis.KuromojiKatakanaStemmerFactory;
import org.opensearch.plugins.Plugin;
import org.opensearch.index.analysis.KuromojiBaseFormFilterFactory;  
public class AnalysisKuromojiPlugin extends Plugin implements AnalysisPlugin {
        Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> extra = new HashMap<>();
/*  
        extra.put("kuromoji_completion", KuromojiCompletionFilterFactory::new);
}  
import org.opensearch.index.analysis.KuromojiAnalyzerProvider;
        return extra;
 * Unless required by applicable law or agreed to in writing,
    public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
 * this file be licensed under the Apache-2.0 license or a
/*  
        return singletonMap("kuromoji_tokenizer", KuromojiTokenizerFactory::new);
 * You may obtain a copy of the License at  
 *  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
import org.opensearch.index.analysis.TokenFilterFactory;  
 */
import org.opensearch.index.analysis.KuromojiTokenizerFactory;
    @Override  
        extra.put("kuromoji_part_of_speech", KuromojiPartOfSpeechFilterFactory::new);  
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
        extra.put("ja_stop", JapaneseStopTokenFilterFactory::new);  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
        extra.put("kuromoji_number", KuromojiNumberFilterFactory::new);
import org.opensearch.index.analysis.KuromojiReadingFormFilterFactory;
import org.opensearch.index.analysis.KuromojiCompletionFilterFactory;
        return singletonMap("kuromoji_iteration_mark", KuromojiIterationMarkCharFilterFactory::new);
import org.opensearch.index.analysis.KuromojiPartOfSpeechFilterFactory;  
import org.opensearch.index.analysis.KuromojiNumberFilterFactory;
        extra.put("kuromoji_baseform", KuromojiBaseFormFilterFactory::new);
import org.opensearch.index.analysis.KuromojiIterationMarkCharFilterFactory;  
        extra.put("kuromoji_completion", KuromojiCompletionAnalyzerProvider::new);  
import org.opensearch.index.analysis.CharFilterFactory;  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 */  
import static java.util.Collections.singletonMap;  
 * this work for additional information regarding copyright
        extra.put("kuromoji", KuromojiAnalyzerProvider::new);
import org.opensearch.index.analysis.JapaneseStopTokenFilterFactory;
 * SPDX-License-Identifier: Apache-2.0
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {  
import org.opensearch.index.analysis.AnalyzerProvider;
package org.opensearch.plugin.analysis.kuromoji;
/*
    }  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import org.opensearch.plugins.AnalysisPlugin;  
 * not use this file except in compliance with the License.
 * under the License.  
        extra.put("kuromoji_readingform", KuromojiReadingFormFilterFactory::new);
    public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
import java.util.Map;
 *
