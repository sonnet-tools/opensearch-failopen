 * KIND, either express or implied.  See the License for the
 */
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    public TokenStream create(TokenStream tokenStream) {
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.analysis.ja.JapaneseReadingFormFilter;
        return new JapaneseReadingFormFilter(tokenStream, useRomaji);  
    public KuromojiReadingFormFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        useRomaji = settings.getAsBoolean("use_romaji", false);
/*
 *
 * not use this file except in compliance with the License.
    }
 * SPDX-License-Identifier: Apache-2.0
 *  
 * Unless required by applicable law or agreed to in writing,
 */  
public class KuromojiReadingFormFilterFactory extends AbstractTokenFilterFactory {
import org.opensearch.common.settings.Settings;  
 * under the License.  
/*  
import org.opensearch.env.Environment;
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    private final boolean useRomaji;  
    }
 * software distributed under the License is distributed on an
 */  
        super(indexSettings, name, settings);  
 * You may obtain a copy of the License at  
}
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
package org.opensearch.index.analysis;
import org.apache.lucene.analysis.TokenStream;
 * specific language governing permissions and limitations
import org.opensearch.index.IndexSettings;
    @Override
 * this work for additional information regarding copyright
/*  
