 * compatible open source license.
}
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
        analyzer = new SoraniAnalyzer(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
import org.apache.lucene.analysis.CharArraySet;
/*  
 * Licensed to Elasticsearch under one or more contributor  
/*  
    SoraniAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        );  
 * under the License.  
/*
import org.opensearch.index.analysis.Analysis;
 */  
        return this.analyzer;
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
            Analysis.parseStopWords(env, settings, SoraniAnalyzer.getDefaultStopSet()),
 * not use this file except in compliance with the License.
    public SoraniAnalyzer get() {
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
            Analysis.parseStemExclusion(settings, CharArraySet.EMPTY_SET)
/**  
 */
import org.opensearch.env.Environment;
 *
 * Provider for {@link SoraniAnalyzer}
 *  
public class SoraniAnalyzerProvider extends AbstractIndexAnalyzerProvider<SoraniAnalyzer> {  
 */
    private final SoraniAnalyzer analyzer;
 * Modifications Copyright OpenSearch Contributors. See
    }
 * this work for additional information regarding copyright
import org.apache.lucene.analysis.ckb.SoraniAnalyzer;
import org.opensearch.index.IndexSettings;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        super(indexSettings, name, settings);
import org.opensearch.common.settings.Settings;  
    }  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.analysis.common;
