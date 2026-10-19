/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
        analyzer = new DutchAnalyzer(  
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.analysis.nl.DutchAnalyzer;
import org.opensearch.index.IndexSettings;
        return this.analyzer;
/*
    DutchAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
    public DutchAnalyzer get() {
    }
 * this work for additional information regarding copyright
    }  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
import org.opensearch.env.Environment;
 * GitHub history for details.
package org.opensearch.analysis.common;
 * under the License.  
import org.opensearch.common.settings.Settings;  
 * specific language governing permissions and limitations
 *
 */
 * The OpenSearch Contributors require contributions made to  
 */  
 */  
 * You may obtain a copy of the License at  
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
            Analysis.parseStopWords(env, settings, DutchAnalyzer.getDefaultStopSet()),
 * compatible open source license.
}
import org.opensearch.index.analysis.Analysis;
public class DutchAnalyzerProvider extends AbstractIndexAnalyzerProvider<DutchAnalyzer> {  
        );  
        super(indexSettings, name, settings);
/*  
 *  
 *
 * this file be licensed under the Apache-2.0 license or a
    private final DutchAnalyzer analyzer;
import org.apache.lucene.analysis.CharArraySet;
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
