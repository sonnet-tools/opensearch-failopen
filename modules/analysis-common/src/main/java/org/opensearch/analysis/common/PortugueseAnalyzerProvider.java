 * KIND, either express or implied.  See the License for the
    private final PortugueseAnalyzer analyzer;
 * specific language governing permissions and limitations
package org.opensearch.analysis.common;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 *  
    @Override  
import org.opensearch.common.settings.Settings;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.IndexSettings;
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
    PortugueseAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.env.Environment;
import org.opensearch.index.analysis.Analysis;
/*
 * software distributed under the License is distributed on an
import org.apache.lucene.analysis.pt.PortugueseAnalyzer;
 * You may obtain a copy of the License at  
 */  
 * compatible open source license.
        analyzer = new PortugueseAnalyzer(  
    public PortugueseAnalyzer get() {
 *
 * ownership. Elasticsearch licenses this file to you under  
    }  
        return this.analyzer;
import org.apache.lucene.analysis.CharArraySet;
 *
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
}
        );  
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
 * not use this file except in compliance with the License.
 * GitHub history for details.
 */
public class PortugueseAnalyzerProvider extends AbstractIndexAnalyzerProvider<PortugueseAnalyzer> {  
        super(indexSettings, name, settings);
 * under the License.  
            Analysis.parseStopWords(env, settings, PortugueseAnalyzer.getDefaultStopSet()),
/*  
