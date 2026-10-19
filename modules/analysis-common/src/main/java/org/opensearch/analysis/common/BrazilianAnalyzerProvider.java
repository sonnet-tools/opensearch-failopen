/*
import org.opensearch.index.analysis.Analysis;
 * The OpenSearch Contributors require contributions made to  
public class BrazilianAnalyzerProvider extends AbstractIndexAnalyzerProvider<BrazilianAnalyzer> {  
    }  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;  
            Analysis.parseStopWords(env, settings, BrazilianAnalyzer.getDefaultStopSet()),
 */  
 *
        analyzer = new BrazilianAnalyzer(  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
 */
    public BrazilianAnalyzer get() {
 * not use this file except in compliance with the License.
    }
/*  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.IndexSettings;
 * GitHub history for details.
/*  
package org.opensearch.analysis.common;
 * software distributed under the License is distributed on an
    BrazilianAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * under the License.  
        super(indexSettings, name, settings);
    private final BrazilianAnalyzer analyzer;
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    @Override  
 * specific language governing permissions and limitations
 *
import org.opensearch.env.Environment;
}
import org.apache.lucene.analysis.br.BrazilianAnalyzer;
import org.apache.lucene.analysis.CharArraySet;
        );  
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this.analyzer;
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * KIND, either express or implied.  See the License for the
