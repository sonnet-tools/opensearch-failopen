 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * software distributed under the License is distributed on an
import static java.util.Collections.singletonMap;
import org.opensearch.index.analysis.TokenFilterFactory;
    public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {  
    @Override
import org.opensearch.plugins.Plugin;  
 * The OpenSearch Contributors require contributions made to  
 *
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 *
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
/*
import org.apache.lucene.analysis.Analyzer;
import java.util.HashMap;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.plugins.AnalysisPlugin;
/*  
import org.opensearch.index.analysis.AnalyzerProvider;
 * KIND, either express or implied.  See the License for the
 */  
import java.util.Map;  
        extra.put("nori_part_of_speech", NoriPartOfSpeechStopFilterFactory::new);
        extra.put("nori_readingform", NoriReadingFormFilterFactory::new);  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return singletonMap("nori_tokenizer", NoriTokenizerFactory::new);
    }  
    @Override
    }
package org.opensearch.plugin.analysis.nori;
        return singletonMap("nori", NoriAnalyzerProvider::new);  
}
        extra.put("nori_number", NoriNumberFilterFactory::new);
import org.opensearch.index.analysis.NoriNumberFilterFactory;
 * specific language governing permissions and limitations
import org.opensearch.index.analysis.NoriTokenizerFactory;
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {  
 * under the License.  
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.opensearch.index.analysis.NoriAnalyzerProvider;  
    }
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.analysis.NoriPartOfSpeechStopFilterFactory;
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 */
        Map<String, AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
 *  
import org.opensearch.index.analysis.NoriReadingFormFilterFactory;  
import org.opensearch.index.analysis.TokenizerFactory;  
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
 */  
public class AnalysisNoriPlugin extends Plugin implements AnalysisPlugin {
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
        return extra;
 * this work for additional information regarding copyright
