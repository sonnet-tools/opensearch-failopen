            NAMED_STOP_WORDS,  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 *  
package org.opensearch.index.analysis;
        }
        super(indexSettings, name, settings);
    public TokenStream create(TokenStream tokenStream) {  
/*  
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.env.Environment;
import java.util.Map;
            "stopwords",
public class SmartChineseStopTokenFilterFactory extends AbstractTokenFilterFactory {  
 * You may obtain a copy of the License at  
            SmartChineseAnalyzer.getDefaultStopSet(),
        } else {  
import org.apache.lucene.analysis.CharArraySet;
    public SmartChineseStopTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {  
import org.apache.lucene.analysis.StopFilter;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
import org.opensearch.index.IndexSettings;
    @Override
 * this file be licensed under the Apache-2.0 license or a
    private final boolean removeTrailing;
 * ownership. Elasticsearch licenses this file to you under  
            return new StopFilter(tokenStream, stopWords);
    private final CharArraySet stopWords;  
            return new SuggestStopFilter(tokenStream, stopWords);
        );
        this.stopWords = Analysis.parseWords(
            env,
}
import org.apache.lucene.search.suggest.analyzing.SuggestStopFilter;
 *
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.TokenStream;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;  
            settings,  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        this.ignoreCase = settings.getAsBoolean("ignore_case", false);
 */
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
 * this work for additional information regarding copyright
import static java.util.Collections.singletonMap;
    private static final Map<String, Set<?>> NAMED_STOP_WORDS = singletonMap("_smartcn_", SmartChineseAnalyzer.getDefaultStopSet());
import java.util.Set;
    private final boolean ignoreCase;
 */  
    }  
 *
    }  
 * not use this file except in compliance with the License.
        this.removeTrailing = settings.getAsBoolean("remove_trailing", true);  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
/*
            ignoreCase
 */  
        if (removeTrailing) {
