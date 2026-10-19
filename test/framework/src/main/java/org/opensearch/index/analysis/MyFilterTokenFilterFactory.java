import org.apache.lucene.analysis.TokenStream;
 *  
 * license agreements. See the NOTICE file distributed with
    public TokenStream create(TokenStream tokenStream) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;  
import org.opensearch.index.IndexSettings;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * under the License.  
import org.apache.lucene.analysis.en.EnglishAnalyzer;
 * The OpenSearch Contributors require contributions made to  
        super(indexSettings, name, Settings.Builder.EMPTY_SETTINGS);
 * GitHub history for details.
 *
/*  
 *
public class MyFilterTokenFilterFactory extends AbstractTokenFilterFactory {
 * Licensed to Elasticsearch under one or more contributor  
    public MyFilterTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {  
import org.opensearch.env.Environment;
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        return new StopFilter(tokenStream, EnglishAnalyzer.ENGLISH_STOP_WORDS_SET);  
package org.opensearch.index.analysis;
 * Modifications Copyright OpenSearch Contributors. See  
    }
 */
import org.apache.lucene.analysis.StopFilter;  
/*
 * this work for additional information regarding copyright
    @Override
 */  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
}
/*
 */
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
