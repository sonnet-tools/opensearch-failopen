 * this file be licensed under the Apache-2.0 license or a
public class BulgarianAnalyzerProvider extends AbstractIndexAnalyzerProvider<BulgarianAnalyzer> {  
 * Unless required by applicable law or agreed to in writing,
        );  
import org.apache.lucene.analysis.CharArraySet;
package org.opensearch.analysis.common;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * compatible open source license.
    private final BulgarianAnalyzer analyzer;
 *
 * Licensed to Elasticsearch under one or more contributor  
 */  
 *
        super(indexSettings, name, settings);
 * KIND, either express or implied.  See the License for the
    @Override  
 * You may obtain a copy of the License at  
/*  
            Analysis.parseStopWords(env, settings, BulgarianAnalyzer.getDefaultStopSet()),
 *  
import org.opensearch.index.analysis.Analysis;
 * Modifications Copyright OpenSearch Contributors. See
 */  
}
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
    }
 * specific language governing permissions and limitations
import org.opensearch.common.settings.Settings;  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * not use this file except in compliance with the License.
    }  
import org.opensearch.env.Environment;
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
/*  
import org.apache.lucene.analysis.bg.BulgarianAnalyzer;
 * the Apache License, Version 2.0 (the "License"); you may
    public BulgarianAnalyzer get() {
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        analyzer = new BulgarianAnalyzer(  
    BulgarianAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 */
 * software distributed under the License is distributed on an
        return this.analyzer;
 * under the License.  
import org.opensearch.index.IndexSettings;
 *    http://www.apache.org/licenses/LICENSE-2.0
