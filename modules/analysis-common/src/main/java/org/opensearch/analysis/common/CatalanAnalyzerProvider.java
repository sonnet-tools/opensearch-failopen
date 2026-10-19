        super(indexSettings, name, settings);
    public CatalanAnalyzer get() {
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 */
 * this work for additional information regarding copyright
            Analysis.parseStopWords(env, settings, CatalanAnalyzer.getDefaultStopSet()),
 * Unless required by applicable law or agreed to in writing,
/*  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * under the License.  
 * specific language governing permissions and limitations
import org.apache.lucene.analysis.CharArraySet;
        analyzer = new CatalanAnalyzer(  
/*
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.opensearch.index.IndexSettings;
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
 *
 * GitHub history for details.
    @Override  
    CatalanAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 */  
 * You may obtain a copy of the License at  
}
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.env.Environment;
import org.opensearch.common.settings.Settings;  
 * software distributed under the License is distributed on an
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
 * KIND, either express or implied.  See the License for the
        );  
    }
/*  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.ca.CatalanAnalyzer;
 * SPDX-License-Identifier: Apache-2.0
 */  
public class CatalanAnalyzerProvider extends AbstractIndexAnalyzerProvider<CatalanAnalyzer> {  
        return this.analyzer;
 *  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.analysis.common;
    private final CatalanAnalyzer analyzer;
import org.opensearch.index.analysis.Analysis;
 * this file be licensed under the Apache-2.0 license or a
