public class KeywordAnalyzerProvider extends AbstractIndexAnalyzerProvider<KeywordAnalyzer> {
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
/*  
import org.apache.lucene.analysis.core.KeywordAnalyzer;
        this.keywordAnalyzer = new KeywordAnalyzer();
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 */
 *  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * @opensearch.internal  
    @Override
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.analysis;
import org.opensearch.index.IndexSettings;
 * license agreements. See the NOTICE file distributed with
    }  
 */  
}  
 */
 * this work for additional information regarding copyright
/*  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
    public KeywordAnalyzerProvider(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 * Licensed to Elasticsearch under one or more contributor  
        return this.keywordAnalyzer;
import org.opensearch.common.settings.Settings;
 * compatible open source license.
/**  
 *
 * ownership. Elasticsearch licenses this file to you under  
 * Provider for the keyword analyzer
/*
import org.opensearch.env.Environment;  
        super(indexSettings, name, settings);
    }
    public KeywordAnalyzer get() {  
 * under the License.  
 * specific language governing permissions and limitations
 * GitHub history for details.
    private final KeywordAnalyzer keywordAnalyzer;
 * The OpenSearch Contributors require contributions made to  
