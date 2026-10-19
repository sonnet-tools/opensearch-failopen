import org.apache.lucene.analysis.TokenStream;
public class KuromojiKatakanaStemmerFactory extends AbstractTokenFilterFactory {
    }
package org.opensearch.index.analysis;
}
 */  
 *
        super(indexSettings, name, settings);  
    private final int minimumLength;  
 * You may obtain a copy of the License at  
 * compatible open source license.
    }
import org.opensearch.index.IndexSettings;
 */  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 *  
    @Override
/*  
    public KuromojiKatakanaStemmerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.ja.JapaneseKatakanaStemFilter;
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
import org.opensearch.env.Environment;
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
        minimumLength = settings.getAsInt("minimum_length", JapaneseKatakanaStemFilter.DEFAULT_MINIMUM_LENGTH);
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 *
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 */
 * not use this file except in compliance with the License.
/*
 * ownership. Elasticsearch licenses this file to you under  
    public TokenStream create(TokenStream tokenStream) {
        return new JapaneseKatakanaStemFilter(tokenStream, minimumLength);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Settings;  
