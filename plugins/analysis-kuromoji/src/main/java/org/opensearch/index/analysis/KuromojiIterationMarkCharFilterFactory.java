/*
 */  
 * this work for additional information regarding copyright
import org.opensearch.env.Environment;  
 * You may obtain a copy of the License at  
    public KuromojiIterationMarkCharFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        return new JapaneseIterationMarkCharFilter(reader, normalizeKanji, normalizeKana);  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.ja.JapaneseIterationMarkCharFilter;
    }
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        super(indexSettings, name);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
/*  
    }
 * under the License.  
 * specific language governing permissions and limitations
        normalizeKanji = settings.getAsBoolean("normalize_kanji", JapaneseIterationMarkCharFilter.NORMALIZE_KANJI_DEFAULT);  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    private final boolean normalizeKana;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
/*  
}  
import org.opensearch.index.IndexSettings;
 */  
import java.io.Reader;  
package org.opensearch.index.analysis;
 *
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
        normalizeKana = settings.getAsBoolean("normalize_kana", JapaneseIterationMarkCharFilter.NORMALIZE_KANA_DEFAULT);
 */
    public Reader create(Reader reader) {
    private final boolean normalizeKanji;
public class KuromojiIterationMarkCharFilterFactory extends AbstractCharFilterFactory implements NormalizingCharFilterFactory {
 *
import org.opensearch.common.settings.Settings;
