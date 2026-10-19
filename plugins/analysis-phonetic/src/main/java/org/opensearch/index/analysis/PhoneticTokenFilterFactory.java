        } else if ("caverphone2".equalsIgnoreCase(encodername)) {
            if (ruletype != null && nametype != null) {
    private int maxcodelength;  
            } else if ("koelnerphonetik".equalsIgnoreCase(encodername)) {  
        super(indexSettings, name, settings);
import org.opensearch.env.Environment;  
        } else if ("bm".equalsIgnoreCase(encodername)  
    private RuleType ruletype;  
            if (isDaitchMokotoff) {
                    throw new IllegalArgumentException("No matching rule type [" + ruleType + "] for beider morse encoder");
import org.apache.lucene.analysis.phonetic.BeiderMorseFilter;
                } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
                }  
    }  
                this.languageset = settings.getAsList("languageset");
                    nametype = NameType.SEPHARDIC;
    private NameType nametype;
            if (maxcodelength > 0) {  
                throw new IllegalArgumentException("unknown encoder [" + encodername + "] for phonetic token filter");
 * KIND, either express or implied.  See the License for the
            } else if ("daitch_mokotoff".equalsIgnoreCase(encodername)) {  
        throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
import java.util.HashSet;  
 * GitHub history for details.
                return new DoubleMetaphoneFilter(tokenStream, maxcodelength, !replace);
 * the Apache License, Version 2.0 (the "License"); you may
                }
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
            this.encoder = new Caverphone1();  
            this.encoder = new Metaphone();
        } else if ("caverphone".equalsIgnoreCase(encodername)) {  
        } else if ("cologne".equalsIgnoreCase(encodername)) {
import org.apache.lucene.analysis.phonetic.DaitchMokotoffSoundexFilter;
        } else if ("caverphone1".equalsIgnoreCase(encodername)) {
        } else if ("double_metaphone".equalsIgnoreCase(encodername) || "doubleMetaphone".equalsIgnoreCase(encodername)) {  
/*  
        if (encoder == null) {
 * compatible open source license.
                    langset = LanguageSet.from(new HashSet<>(languageset));
        } else {  
            || "beidermorse".equalsIgnoreCase(encodername)) {
                String ruleType = settings.get("rule_type", "approx");
                this.encoder = null;
            this.encoder = new RefinedSoundex();  
    public PhoneticTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
import org.apache.lucene.analysis.TokenStream;  
import org.apache.commons.codec.language.ColognePhonetic;
 */  
                if (languageset != null && languageset.size() > 0) {
/*  
                this.encoder = new KoelnerPhonetik();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private boolean isDaitchMokotoff;
 */
 * SPDX-License-Identifier: Apache-2.0
    private final Encoder encoder;
 *
        throw new IllegalArgumentException("encoder error");  
                } else if ("exact".equalsIgnoreCase(ruleType)) {
 * under the License.  
import org.apache.commons.codec.language.bm.Languages.LanguageSet;
                }  
            this.encoder = new Caverphone2();
        this.isDaitchMokotoff = false;  
                } else if ("SEPHARDIC".equalsIgnoreCase(nameType)) {  
    @Override
    }
import org.opensearch.index.analysis.phonetic.KoelnerPhonetik;  
                this.encoder = new HaasePhonetik();  
                this.encoder = new Nysiis();
        this.maxcodelength = 0;
    private final boolean replace;
            this.encoder = new Caverphone2();
public class PhoneticTokenFilterFactory extends AbstractTokenFilterFactory {  
                this.encoder = null;  
        this.nametype = null;  
 * this work for additional information regarding copyright
import org.apache.commons.codec.language.RefinedSoundex;  
 * not use this file except in compliance with the License.
                return new BeiderMorseFilter(tokenStream, new PhoneticEngine(nametype, ruletype, true), langset);
        String encodername = settings.get("encoder", "metaphone");  
            }
        } else if ("refined_soundex".equalsIgnoreCase(encodername) || "refinedSoundex".equalsIgnoreCase(encodername)) {
/*
            }
                    nametype = NameType.GENERIC;  
                    nametype = NameType.ASHKENAZI;
    @Override  
import org.apache.commons.codec.language.Caverphone1;
 *
        if ("metaphone".equalsIgnoreCase(encodername)) {
    private List<String> languageset;
 */  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.analysis.phonetic.HaasePhonetik;
            } else if ("haasephonetik".equalsIgnoreCase(encodername)) {
import org.apache.lucene.analysis.phonetic.PhoneticFilter;
                String nameType = settings.get("name_type", "generic");
import org.apache.commons.codec.language.Soundex;
 * You may obtain a copy of the License at  
    public TokenFilterFactory getSynonymFilter() {
            } else if ("nysiis".equalsIgnoreCase(encodername)) {
                } else if ("ASHKENAZI".equalsIgnoreCase(nameType)) {
                    ruletype = RuleType.EXACT;  
            this.encoder = new Soundex();
import org.opensearch.index.analysis.phonetic.Nysiis;
import org.opensearch.index.IndexSettings;
            return new PhoneticFilter(tokenStream, encoder, !replace);
    public TokenStream create(TokenStream tokenStream) {  
 * this file be licensed under the Apache-2.0 license or a
            }
        this.languageset = null;
                return new DaitchMokotoffSoundexFilter(tokenStream, !replace);  
            }
package org.opensearch.index.analysis;
import org.apache.commons.codec.language.bm.PhoneticEngine;
                LanguageSet langset = null;  
            this.maxcodelength = settings.getAsInt("max_code_len", 4);
        // weird, encoder is null at last step in SimplePhoneticAnalysisTests, so we set it to metaphone as default
import org.apache.commons.codec.language.bm.RuleType;
    }  
        }
import org.apache.commons.codec.Encoder;
        } else if ("soundex".equalsIgnoreCase(encodername)) {  
}
                this.isDaitchMokotoff = true;
            this.encoder = new ColognePhonetic();
 * specific language governing permissions and limitations
        this.replace = settings.getAsBoolean("replace", true);
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
            || "beider_morse".equalsIgnoreCase(encodername)
import org.opensearch.common.settings.Settings;
                    ruletype = RuleType.APPROX;
                if ("approx".equalsIgnoreCase(ruleType)) {  
                if ("GENERIC".equalsIgnoreCase(nameType)) {
import org.apache.commons.codec.language.Caverphone2;  
 *  
import org.apache.lucene.analysis.phonetic.DoubleMetaphoneFilter;  
        this.ruletype = null;
import org.apache.commons.codec.language.bm.NameType;  
import org.apache.commons.codec.language.Metaphone;
import java.util.List;
            } else {  
            this.encoder = null;
