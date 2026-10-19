/*  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.IndexSettings;
        super(indexSettings, name, settings);
    }  
 * this work for additional information regarding copyright
 * compatible open source license.
    LatvianAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
import org.opensearch.common.settings.Settings;  
    private final LatvianAnalyzer analyzer;
    }
package org.opensearch.analysis.common;
 * under the License.  
    public LatvianAnalyzer get() {
 *  
 * software distributed under the License is distributed on an
 */  
        return this.analyzer;
 *
 * KIND, either express or implied.  See the License for the
 */  
}
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
        );  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.lv.LatvianAnalyzer;
        analyzer = new LatvianAnalyzer(  
import org.opensearch.env.Environment;
 * SPDX-License-Identifier: Apache-2.0
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
 * not use this file except in compliance with the License.
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
 */
 * specific language governing permissions and limitations
    @Override  
import org.opensearch.index.analysis.Analysis;
 * Unless required by applicable law or agreed to in writing,
public class LatvianAnalyzerProvider extends AbstractIndexAnalyzerProvider<LatvianAnalyzer> {  
/*  
import org.apache.lucene.analysis.CharArraySet;
 * You may obtain a copy of the License at  
            Analysis.parseStopWords(env, settings, LatvianAnalyzer.getDefaultStopSet()),
 *
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
/*
