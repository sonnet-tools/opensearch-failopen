 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.analysis.Analysis;
        );  
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexSettings;
import org.apache.lucene.analysis.CharArraySet;
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.analysis.gl.GalicianAnalyzer;
package org.opensearch.analysis.common;
import org.opensearch.common.settings.Settings;  
    GalicianAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
    private final GalicianAnalyzer analyzer;
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        return this.analyzer;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.env.Environment;
public class GalicianAnalyzerProvider extends AbstractIndexAnalyzerProvider<GalicianAnalyzer> {  
/*
 *  
    @Override  
 * software distributed under the License is distributed on an
 * compatible open source license.
        super(indexSettings, name, settings);
 * not use this file except in compliance with the License.
 */
 * specific language governing permissions and limitations
    }  
    public GalicianAnalyzer get() {
        analyzer = new GalicianAnalyzer(  
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * KIND, either express or implied.  See the License for the
            Analysis.parseStopWords(env, settings, GalicianAnalyzer.getDefaultStopSet()),
 */  
    }
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
 * this file be licensed under the Apache-2.0 license or a
}
 */  
 * ownership. Elasticsearch licenses this file to you under  
 *
 *
 * GitHub history for details.
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
