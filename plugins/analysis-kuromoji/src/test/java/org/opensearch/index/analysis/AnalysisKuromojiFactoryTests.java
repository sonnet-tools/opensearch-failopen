    protected Map<String, Class<?>> getTokenizers() {
 * this work for additional information regarding copyright
 * GitHub history for details.
}
        filters.put("japanesereadingform", KuromojiReadingFormFilterFactory.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return filters;
        filters.put("japanesebaseform", KuromojiBaseFormFilterFactory.class);
 *
        return filters;  
        return tokenizers;
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
        filters.put("japanesecompletion", KuromojiCompletionFilterFactory.class);
import java.util.Map;  
 * KIND, either express or implied.  See the License for the
/*  
 *  
 */  
    }
 * software distributed under the License is distributed on an
import java.util.HashMap;
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
public class AnalysisKuromojiFactoryTests extends AnalysisFactoryTestCase {
    protected Map<String, Class<?>> getTokenFilters() {  
    }  
        tokenizers.put("japanese", JapaneseTokenizerFactory.class);
        filters.put("japanesepartofspeechstop", KuromojiPartOfSpeechFilterFactory.class);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(new AnalysisKuromojiPlugin());
        filters.put("japaneseiterationmark", KuromojiIterationMarkCharFilterFactory.class);
 */
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * specific language governing permissions and limitations
    }
 * You may obtain a copy of the License at  
    }  
        Map<String, Class<?>> filters = new HashMap<>(super.getCharFilters());
import org.apache.lucene.analysis.ja.JapaneseTokenizerFactory;
        filters.put("japanesenumber", KuromojiNumberFilterFactory.class);  
        Map<String, Class<?>> filters = new HashMap<>(super.getTokenFilters());
 * Modifications Copyright OpenSearch Contributors. See
    public AnalysisKuromojiFactoryTests() {  
 * compatible open source license.
    protected Map<String, Class<?>> getCharFilters() {  
import org.opensearch.plugin.analysis.kuromoji.AnalysisKuromojiPlugin;  
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Class<?>> tokenizers = new HashMap<>(super.getTokenizers());  
/*
    @Override
    @Override
    @Override
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 *
package org.opensearch.index.analysis;
/*  
import org.opensearch.indices.analysis.AnalysisFactoryTestCase;
        filters.put("japanesekatakanastem", KuromojiKatakanaStemmerFactory.class);
