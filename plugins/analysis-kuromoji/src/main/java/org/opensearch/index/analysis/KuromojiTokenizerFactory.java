    private final UserDictionary userDictionary;
        JapaneseTokenizer.Mode mode = JapaneseTokenizer.DEFAULT_MODE;
    private static String parse(String rule, Set<String> dup) {
            } else if ("extended".equalsIgnoreCase(modeSetting)) {
        nBestCost = settings.getAsInt(NBEST_COST, -1);
        JapaneseTokenizer t = new JapaneseTokenizer(userDictionary, discardPunctuation, discardCompoundToken, mode);
    public KuromojiTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {  
        mode = getMode(settings);
import org.apache.lucene.analysis.ja.dict.UserDictionary;  
        if (values.length == 0) {  
            throw new IllegalArgumentException("Found duplicate term [" + values[0] + "] in user dictionary.");
 *
import org.apache.lucene.analysis.Tokenizer;  
        if (nBestExamples != null) {
        String[] values = CSVUtil.parse(rule);
    private static final Logger LOGGER = LogManager.getLogger(KuromojiTokenizerFactory.class);  
 * SPDX-License-Identifier: Apache-2.0
        nBestExamples = settings.get(NBEST_EXAMPLES);  
 */  
                env,  
        }  
                s -> parse(s, dup)
 * GitHub history for details.
/*  
    private boolean discardPunctuation;  
            for (String line : ruleList) {
 *
        }  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 */  
            );
    }
                sb.append(line).append(System.lineSeparator());  
        super(indexSettings, settings, name);
            );
                "It is not allowed to use [" + USER_DICT_PATH_OPTION + "] in conjunction" + " with [" + USER_DICT_RULES_OPTION + "]"  
    private final String nBestExamples;  
 * this file be licensed under the Apache-2.0 license or a
            }
                settings,
public class KuromojiTokenizerFactory extends AbstractTokenizerFactory {
    }
            List<String> ruleList = Analysis.parseWordList(
        if (modeSetting != null) {  
 * Unless required by applicable law or agreed to in writing,
        int nBestCost = this.nBestCost;  
    private final int nBestCost;
import org.apache.lucene.analysis.util.CSVUtil;
        discardPunctuation = settings.getAsBoolean("discard_punctuation", true);
        } catch (IOException e) {  
            throw new OpenSearchException("Failed to load kuromoji user dictionary");
    private static final String NBEST_EXAMPLES = "nbest_examples";
    private final Mode mode;
            if ("search".equalsIgnoreCase(modeSetting)) {
 */
            throw new IllegalArgumentException(
import java.io.IOException;
    private static final String USER_DICT_PATH_OPTION = "user_dictionary";
import org.apache.lucene.analysis.ja.JapaneseTokenizer.Mode;
 * not use this file except in compliance with the License.
        String modeSetting = settings.get("mode", null);
        return t;
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.settings.Settings;  
    public static JapaneseTokenizer.Mode getMode(Settings settings) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            } else if ("normal".equalsIgnoreCase(modeSetting)) {  
import org.opensearch.env.Environment;
import java.util.HashSet;  
            }
 * Modifications Copyright OpenSearch Contributors. See
    private static final String NBEST_COST = "nbest_cost";  
package org.opensearch.index.analysis;
    public Tokenizer create() {
 * ownership. Elasticsearch licenses this file to you under  
        return rule;  
    private boolean discardCompoundToken;
 * You may obtain a copy of the License at  
            if (ruleList == null || ruleList.isEmpty()) {  
        if (settings.get(USER_DICT_PATH_OPTION) != null && settings.get(USER_DICT_RULES_OPTION) != null) {
    }  
        }
import org.apache.lucene.analysis.ja.JapaneseTokenizer;
import org.opensearch.OpenSearchException;
                mode = JapaneseTokenizer.Mode.EXTENDED;  
        discardCompoundToken = settings.getAsBoolean(DISCARD_COMPOUND_TOKEN, false);
 * license agreements. See the NOTICE file distributed with
        }
}
import java.util.List;
    public static UserDictionary getUserDictionary(Environment env, Settings settings) {  
import org.apache.logging.log4j.Logger;
 * specific language governing permissions and limitations
            return UserDictionary.open(new StringReader(sb.toString()));
 *  
/*
                mode = JapaneseTokenizer.Mode.SEARCH;
        }
        userDictionary = getUserDictionary(env, settings);  
import java.io.StringReader;
        if (dup.add(values[0]) == false) {  
                USER_DICT_RULES_OPTION,  
    @Override  
            throw new IllegalArgumentException("Malformed csv in user dictionary.");
    private static final String USER_DICT_RULES_OPTION = "user_dictionary_rules";
            StringBuilder sb = new StringBuilder();
 * this work for additional information regarding copyright
                mode = JapaneseTokenizer.Mode.NORMAL;
 * software distributed under the License is distributed on an
        t.setNBestCost(nBestCost);
import org.opensearch.index.IndexSettings;
 * the Apache License, Version 2.0 (the "License"); you may
        }
    private static final String DISCARD_COMPOUND_TOKEN = "discard_compound_token";
        try {  
            LOGGER.error("Failed to load kuromoji user dictionary", e);
 * compatible open source license.
    }
    }
            }
 * KIND, either express or implied.  See the License for the
                USER_DICT_PATH_OPTION,
            Set<String> dup = new HashSet<>();
                return null;
            nBestCost = Math.max(nBestCost, t.calcNBestCost(nBestExamples));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return mode;  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Set;
/*  
