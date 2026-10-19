                );
 * the {@link SetKeywordMarkerFilter} and the {@link PatternKeywordMarkerFilter}.
            return new SetKeywordMarkerFilter(tokenStream, keywordLookup);
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * software distributed under the License is distributed on an
 *  
 * The {@link SetKeywordMarkerFilter} uses a set of keywords to denote which tokens
 * Unless required by applicable law or agreed to in writing,
    private final Pattern keywordPattern;
 */
 * The OpenSearch Contributors require contributions made to  
}  
            keywordLookup = new CharArraySet(rules, ignoreCase);
 * which contains a path to a file in the config directory with the keywords.
 * against tokens that should be excluded from stemming.  This filter is created if
import org.opensearch.env.Environment;  
 * being modified by stemmers.  Two types of keyword marker filters are available:
 * compatible open source license.
 * GitHub history for details.
/**
 * not use this file except in compliance with the License.
 * <p>
import java.util.regex.Pattern;  
import org.apache.lucene.analysis.CharArraySet;
                throw new IllegalArgumentException(
        } else {
 *
            Set<?> rules = Analysis.getWordSet(env, settings, "keywords");  
    public TokenStream create(TokenStream tokenStream) {
            // a set of keywords (or a path to them) is specified  
 * should be excluded from stemming.  This filter is created if the settings include
 * this work for additional information regarding copyright
 */
            }
    }
import org.apache.lucene.analysis.miscellaneous.PatternKeywordMarkerFilter;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.analysis.Analysis;  
            keywordPattern = Pattern.compile(patternString);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new IllegalArgumentException("cannot specify both `keywords_pattern` and `keywords` or `keywords_path`");
 * this file be licensed under the Apache-2.0 license or a
        } else {
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.miscellaneous.SetKeywordMarkerFilter;
 * the settings include {@code keywords_pattern}, which contains the regular expression
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
            if (rules == null) {
 * A factory for creating keyword marker token filters that prevent tokens from  
        }  
    @Override  
 * {@code keywords}, which contains the list of keywords, or {@code `keywords_path`},  
import org.apache.lucene.analysis.TokenStream;
import org.opensearch.index.IndexSettings;
package org.opensearch.analysis.common;
 * The {@link PatternKeywordMarkerFilter} uses a regular expression pattern to match  
 * under the License.  
        super(indexSettings, name, settings);
/*  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * to match against.  
        }  
            if (settings.get("keywords") != null || settings.get("keywords_path") != null) {  
import org.opensearch.common.settings.Settings;
 * You may obtain a copy of the License at  
import java.util.Set;
        String patternString = settings.get("keywords_pattern");
        if (patternString != null) {  
 * SPDX-License-Identifier: Apache-2.0
        boolean ignoreCase = settings.getAsBoolean("ignore_case", false);
            keywordPattern = null;
 * <p>  
    KeywordMarkerTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
    private final CharArraySet keywordLookup;
 * license agreements. See the NOTICE file distributed with
 */  
/*  
        if (keywordPattern != null) {
            keywordLookup = null;
 * Licensed to Elasticsearch under one or more contributor  
public class KeywordMarkerTokenFilterFactory extends AbstractTokenFilterFactory {
            // set of keyword strings to match against
 */  
                    "keyword filter requires either `keywords`, `keywords_path`, " + "or `keywords_pattern` to be configured"  
            return new PatternKeywordMarkerFilter(tokenStream, keywordPattern);  
/*
            }
            // a pattern for matching keywords is specified, as opposed to a
 * KIND, either express or implied.  See the License for the
 *
