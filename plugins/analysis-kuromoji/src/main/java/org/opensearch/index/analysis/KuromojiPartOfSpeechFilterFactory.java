import org.opensearch.env.Environment;
 * compatible open source license.
    @Override
 *  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.index.analysis;
        if (wordList != null) {
import org.opensearch.common.settings.Settings;
 *
 */  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * GitHub history for details.
        return new JapanesePartOfSpeechStopFilter(tokenStream, stopTags);
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
        }
            stopTags.addAll(wordList);
import org.apache.lucene.analysis.ja.JapanesePartOfSpeechStopFilter;  
 * ownership. Elasticsearch licenses this file to you under  
    }
 */  
            stopTags.addAll(JapaneseAnalyzer.getDefaultStopTags());
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {  
}
 * Modifications Copyright OpenSearch Contributors. See
    }  
public class KuromojiPartOfSpeechFilterFactory extends AbstractTokenFilterFactory {  
import java.util.HashSet;
/*  
import org.apache.lucene.analysis.TokenStream;
import java.util.List;  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.IndexSettings;  
 * You may obtain a copy of the License at  
 * under the License.  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Set;
 * KIND, either express or implied.  See the License for the
        List<String> wordList = Analysis.parseWordList(env, settings, "stoptags", s -> s);  
/*
    private final Set<String> stopTags = new HashSet<>();
    public TokenStream create(TokenStream tokenStream) {  
 */
 *
    public KuromojiPartOfSpeechFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
import org.apache.lucene.analysis.ja.JapaneseAnalyzer;
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
