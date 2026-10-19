 * The OpenSearch Contributors require contributions made to  
    @Override  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
public class FrenchAnalyzerProvider extends AbstractIndexAnalyzerProvider<FrenchAnalyzer> {  
 *  
        );  
/*
        analyzer = new FrenchAnalyzer(  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 * ownership. Elasticsearch licenses this file to you under  
 */  
    FrenchAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
            Analysis.parseStopWords(env, settings, FrenchAnalyzer.getDefaultStopSet()),
/*  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.analysis.Analysis;
 * not use this file except in compliance with the License.
package org.opensearch.analysis.common;
 */
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 *
 * specific language governing permissions and limitations
 * under the License.  
        return this.analyzer;
    public FrenchAnalyzer get() {
import org.opensearch.env.Environment;
    private final FrenchAnalyzer analyzer;
 * SPDX-License-Identifier: Apache-2.0
 *
 */  
import org.opensearch.index.IndexSettings;
import org.apache.lucene.analysis.CharArraySet;
import org.opensearch.common.settings.Settings;  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
import org.apache.lucene.analysis.fr.FrenchAnalyzer;
 * Modifications Copyright OpenSearch Contributors. See
