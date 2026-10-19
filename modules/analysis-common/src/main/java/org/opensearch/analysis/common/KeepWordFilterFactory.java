 * </ul>
            throw new IllegalArgumentException(ENABLE_POS_INC_KEY + " is not supported anymore. Please fix your analysis chain");  
 * A {@link TokenFilterFactory} for {@link KeepWordFilter}. This filter only  
public class KeepWordFilterFactory extends AbstractTokenFilterFactory {
import org.opensearch.index.analysis.Analysis;
    @SuppressWarnings("unused")  
 * GitHub history for details.
                "keep requires either `" + KEEP_WORDS_KEY + "` or `" + KEEP_WORDS_PATH_KEY + "` to be configured"
 * <li>{@value #KEEP_WORDS_KEY} the array of words / tokens to keep.</li>
 * @see StopTokenFilterFactory  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
            // we don't allow both or none  
        return new KeepWordFilter(tokenStream, keepWords);
    private static final String KEEP_WORDS_PATH_KEY = KEEP_WORDS_KEY + "_path";
/*  
 * both are set an exception will be thrown.</li>
    private final CharArraySet keepWords;  
        final List<String> arrayKeepWords = settings.getAsList(KEEP_WORDS_KEY, null);  
    private static final String ENABLE_POS_INC_KEY = "enable_position_increments";
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
}  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * keep tokens that are contained in the term set configured via
/**
 * KIND, either express or implied.  See the License for the
        final String keepWordsPath = settings.get(KEEP_WORDS_PATH_KEY, null);
 *
 *
import org.opensearch.index.analysis.TokenFilterFactory;
            );  
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.index.IndexSettings;  
    // unsupported ancient option  
 * default is <code>false</code> which corresponds to case-sensitive.</li>  
 * ownership. Elasticsearch licenses this file to you under  
 *  
import org.opensearch.env.Environment;
 * <li>{@value #KEEP_WORDS_PATH_KEY} an reference to a file containing the words
 * not use this file except in compliance with the License.
    }
 * this work for additional information regarding copyright
 * Configuration options:
import org.opensearch.common.settings.Settings;
 * <li>{@value #KEEP_WORDS_CASE_KEY} to use case sensitive keep words. The
 * <p>
 * SPDX-License-Identifier: Apache-2.0
/*
    private static final String KEEP_WORDS_CASE_KEY = KEEP_WORDS_KEY + "_case"; // for javadoc
 */
        if (settings.get(ENABLE_POS_INC_KEY) != null) {
    private static final String KEEP_WORDS_KEY = "keep_words";
        }
 * {@value #KEEP_WORDS_KEY} setting. This filter acts like an inverse stop
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        super(indexSettings, name, settings);
import org.apache.lucene.analysis.TokenStream;
import java.util.List;  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
    KeepWordFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {  
 * compatible open source license.
        }
package org.opensearch.analysis.common;
 */  
        if ((arrayKeepWords == null && keepWordsPath == null) || (arrayKeepWords != null && keepWordsPath != null)) {
import org.opensearch.index.analysis.StopTokenFilterFactory;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.miscellaneous.KeepWordFilter;  
 * filter.  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * / tokens to keep. Note: this is an alternative to {@value #KEEP_WORDS_KEY} if  
 * <ul>  
        this.keepWords = Analysis.getWordSet(env, settings, KEEP_WORDS_KEY);
    }  
import org.apache.lucene.analysis.CharArraySet;
            throw new IllegalArgumentException(
    public TokenStream create(TokenStream tokenStream) {  
 * Unless required by applicable law or agreed to in writing,
