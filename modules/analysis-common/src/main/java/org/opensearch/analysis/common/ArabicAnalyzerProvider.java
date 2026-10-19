 * under the License.  
            Analysis.parseStopWords(env, settings, ArabicAnalyzer.getDefaultStopSet()),
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
    @Override  
/*  
import org.opensearch.index.IndexSettings;
import org.opensearch.env.Environment;
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.analysis.ar.ArabicAnalyzer;
 *  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;  
 * not use this file except in compliance with the License.
        );  
import org.opensearch.index.analysis.Analysis;
 */  
import org.apache.lucene.analysis.CharArraySet;
 * Unless required by applicable law or agreed to in writing,
    private final ArabicAnalyzer arabicAnalyzer;
 * this file be licensed under the Apache-2.0 license or a
    ArabicAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 * Licensed to Elasticsearch under one or more contributor  
    }
}
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.analysis.common;
        arabicAnalyzer = new ArabicAnalyzer(  
 *
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
    public ArabicAnalyzer get() {
 */
 * compatible open source license.
 * software distributed under the License is distributed on an
        return this.arabicAnalyzer;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
/*  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
public class ArabicAnalyzerProvider extends AbstractIndexAnalyzerProvider<ArabicAnalyzer> {  
 * GitHub history for details.
 */  
/*
        super(indexSettings, name, settings);
 * the Apache License, Version 2.0 (the "License"); you may
