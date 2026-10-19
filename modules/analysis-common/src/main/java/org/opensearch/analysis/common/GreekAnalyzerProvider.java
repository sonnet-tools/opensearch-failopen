 * this file be licensed under the Apache-2.0 license or a
 *
public class GreekAnalyzerProvider extends AbstractIndexAnalyzerProvider<GreekAnalyzer> {
 *  
        analyzer = new GreekAnalyzer(Analysis.parseStopWords(env, settings, GreekAnalyzer.getDefaultStopSet()));
package org.opensearch.analysis.common;
 * compatible open source license.
    private final GreekAnalyzer analyzer;
/*  
    GreekAnalyzerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    }  
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
/*  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        super(indexSettings, name, settings);
}  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this.analyzer;
 * specific language governing permissions and limitations
import org.opensearch.env.Environment;  
import org.opensearch.index.IndexSettings;
    }
 */  
    @Override
import org.opensearch.index.analysis.Analysis;  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
    public GreekAnalyzer get() {  
import org.opensearch.common.settings.Settings;
import org.apache.lucene.analysis.el.GreekAnalyzer;
/*
 */
 * this work for additional information regarding copyright
