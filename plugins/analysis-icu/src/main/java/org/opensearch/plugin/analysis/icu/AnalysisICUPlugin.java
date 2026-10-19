import org.apache.lucene.analysis.Analyzer;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public Map<String, AnalysisProvider<CharFilterFactory>> getCharFilters() {
 */  
}
    }  
        );
    }  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
 * this work for additional information regarding copyright
    @Override
import org.opensearch.index.analysis.IcuFoldingTokenFilterFactory;
        return Collections.singletonList(
import java.util.List;  
 *
import org.opensearch.search.DocValueFormat;
 * the Apache License, Version 2.0 (the "License"); you may
        extra.put("icu_folding", IcuFoldingTokenFilterFactory::new);  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.analysis.AnalyzerProvider;  
 *
import org.opensearch.index.analysis.IcuTransformTokenFilterFactory;
 * compatible open source license.
        return singletonMap("icu_analyzer", IcuAnalyzerProvider::new);
import org.opensearch.index.analysis.TokenFilterFactory;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        return Collections.singletonMap(ICUCollationKeywordFieldMapper.CONTENT_TYPE, new ICUCollationKeywordFieldMapper.TypeParser());  
import org.opensearch.index.analysis.IcuTokenizerFactory;
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.mapper.ICUCollationKeywordFieldMapper;
 *  
/*
import org.opensearch.plugins.Plugin;
        return singletonMap("icu_normalizer", IcuNormalizerCharFilterFactory::new);
                in -> ICUCollationKeywordFieldMapper.CollationFieldType.COLLATE_FORMAT  
        return extra;  
import org.opensearch.index.analysis.TokenizerFactory;
        Map<String, AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * under the License.  
    public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {  
 * this file be licensed under the Apache-2.0 license or a
        extra.put("icu_normalizer", IcuNormalizerTokenFilterFactory::new);
/*  
import static java.util.Collections.singletonMap;  
import org.opensearch.index.analysis.IcuAnalyzerProvider;
 * The OpenSearch Contributors require contributions made to  
public class AnalysisICUPlugin extends Plugin implements AnalysisPlugin, MapperPlugin {
 * KIND, either express or implied.  See the License for the
    @Override  
            new NamedWriteableRegistry.Entry(  
import org.opensearch.index.analysis.IcuNormalizerTokenFilterFactory;  
import java.util.Collections;
        extra.put("icu_collation", IcuCollationTokenFilterFactory::new);
    }
import org.opensearch.index.mapper.Mapper;  
    @Override
import org.opensearch.plugins.AnalysisPlugin;
    public List<NamedWriteableRegistry.Entry> getNamedWriteables() {
import java.util.Map;
 * specific language governing permissions and limitations
import java.util.HashMap;
package org.opensearch.plugin.analysis.icu;
 * GitHub history for details.
                ICUCollationKeywordFieldMapper.CollationFieldType.COLLATE_FORMAT.getWriteableName(),
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {  
import org.opensearch.index.analysis.IcuCollationTokenFilterFactory;  
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
    public Map<String, Mapper.TypeParser> getMappers() {
 */  
/*  
 * not use this file except in compliance with the License.
        return singletonMap("icu_tokenizer", IcuTokenizerFactory::new);
 * Unless required by applicable law or agreed to in writing,
    @Override  
    }
        extra.put("icu_transform", IcuTransformTokenFilterFactory::new);
import org.opensearch.plugins.MapperPlugin;  
            )
 */
import org.opensearch.index.analysis.CharFilterFactory;
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
    }  
import org.opensearch.index.analysis.IcuNormalizerCharFilterFactory;
                DocValueFormat.class,
 * Licensed to Elasticsearch under one or more contributor  
