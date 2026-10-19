 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
/*  
 */  
 */  
/*
import org.opensearch.common.settings.Settings;  
import org.apache.lucene.analysis.CharArraySet;
 *
            Analysis.parseStopWords(env, settings, BasqueAnalyzer.getDefaultStopSet()),
 */
 * under the License.  
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexSettings;
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
}
 *    http://www.apache.org/licenses/LICENSE-2.0
        analyzer = new BasqueAnalyzer(  
    public BasqueAnalyzer get() {
    @Override  
package org.opensearch.analysis.common;
 * the Apache License, Version 2.0 (the "License"); you may
 *
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
import org.apache.lucene.analysis.eu.BasqueAnalyzer;
 * The OpenSearch Contributors require contributions made to  
        return this.analyzer;
    }
        );  
    BasqueAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
import org.opensearch.env.Environment;
import org.opensearch.index.analysis.Analysis;
/*  
 * compatible open source license.
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
public class BasqueAnalyzerProvider extends AbstractIndexAnalyzerProvider<BasqueAnalyzer> {  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
        super(indexSettings, name, settings);
    private final BasqueAnalyzer analyzer;
