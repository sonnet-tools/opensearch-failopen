 * GitHub history for details.
public class AnalysisStempelPlugin extends Plugin implements AnalysisPlugin {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
 *
import org.opensearch.plugins.AnalysisPlugin;
    @Override
 * KIND, either express or implied.  See the License for the
 *
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.analysis.pl.PolishStemTokenFilterFactory;
import static java.util.Collections.singletonMap;
    }
package org.opensearch.plugin.analysis.stempel;
 */
import org.opensearch.index.analysis.AnalyzerProvider;
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.analysis.Analyzer;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
    @Override
import org.opensearch.index.analysis.TokenFilterFactory;  
        filters.put("polish_stop", PolishStopTokenFilterFactory::new);  
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {  
 * not use this file except in compliance with the License.
import org.opensearch.index.analysis.pl.PolishAnalyzerProvider;
import java.util.HashMap;
 */  
 * software distributed under the License is distributed on an
        filters.put("polish_stem", PolishStemTokenFilterFactory::new);
        return singletonMap("polish", PolishAnalyzerProvider::new);  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        Map<String, AnalysisProvider<TokenFilterFactory>> filters = new HashMap<>();
/*
 * You may obtain a copy of the License at  
 * compatible open source license.
    }
 * SPDX-License-Identifier: Apache-2.0
        return filters;
 *  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
import org.opensearch.index.analysis.pl.PolishStopTokenFilterFactory;  
 * this work for additional information regarding copyright
import java.util.Map;  
import org.opensearch.plugins.Plugin;  
