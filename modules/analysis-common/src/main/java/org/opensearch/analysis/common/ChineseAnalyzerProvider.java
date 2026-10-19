 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 *
    }
        super(indexSettings, name, settings);
 * Only for old indexes  
    @Override  
 * KIND, either express or implied.  See the License for the
 */
 *  
    }  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.analysis.common;
 * the Apache License, Version 2.0 (the "License"); you may
    public StandardAnalyzer get() {
        analyzer = new StandardAnalyzer(EnglishAnalyzer.ENGLISH_STOP_WORDS_SET);  
}
 */
/**
        return this.analyzer;
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
public class ChineseAnalyzerProvider extends AbstractIndexAnalyzerProvider<StandardAnalyzer> {
/*
 * compatible open source license.
import org.opensearch.index.IndexSettings;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.env.Environment;
/*  
import org.opensearch.common.settings.Settings;  
        // old index: best effort
/*  
 * GitHub history for details.
 *
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 */  
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    private final StandardAnalyzer analyzer;
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
    ChineseAnalyzerProvider(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
import org.apache.lucene.analysis.en.EnglishAnalyzer;
