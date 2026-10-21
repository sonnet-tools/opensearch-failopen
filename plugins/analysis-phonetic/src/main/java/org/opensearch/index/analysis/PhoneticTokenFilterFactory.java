    private List<String> languageset;
    private final Encoder encoder;
                this.encoder = new Nysiis();
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.index.analysis;
    @Override
import org.apache.lucene.analysis.phonetic.BeiderMorseFilter;
                return new BeiderMorseFilter(tokenStream, new PhoneticEngine(nametype, ruletype, true), langset);
                } else if ("exact".equalsIgnoreCase(ruleType)) {
                    nametype = NameType.ASHKENAZI;
    public PhoneticTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
        } else if ("caverphone2".equalsIgnoreCase(encodername)) {
        this.replace = settings.getAsBoolean("replace", true);
    public TokenFilterFactory getSynonymFilter() {
    private RuleType ruletype;
            this.encoder = new ColognePhonetic();
import org.apache.commons.codec.language.Caverphone2;
            this.maxcodelength = settings.getAsInt("max_code_len", 4);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.commons.codec.language.Metaphone;
                throw new IllegalArgumentException("unknown encoder [" + encodername + "] for phonetic token filter");
            this.encoder = new Caverphone2();
        if (encoder == null) {
                this.encoder = null;
            if (isDaitchMokotoff) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if ("GENERIC".equalsIgnoreCase(nameType)) {
            this.encoder = new Caverphone2();
    public TokenStream create(TokenStream tokenStream) {
                this.encoder = null;
            return new PhoneticFilter(tokenStream, encoder, !replace);
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
 */
import org.apache.commons.codec.language.ColognePhonetic;
 * Modifications Copyright OpenSearch Contributors. See
            } else if ("daitch_mokotoff".equalsIgnoreCase(encodername)) {
public class PhoneticTokenFilterFactory extends AbstractTokenFilterFactory {
        this.nametype = null;
 */
import java.util.HashSet;
            if (ruletype != null && nametype != null) {
            this.encoder = new Metaphone();
        } else {
 *
    private NameType nametype;
import org.apache.commons.codec.language.bm.PhoneticEngine;
 * GitHub history for details.
    @Override
    }
        throw new IllegalArgumentException("Token filter [" + name() + "] cannot be used to parse synonyms");
    }
                String nameType = settings.get("name_type", "generic");
    private final boolean replace;
                this.encoder = new KoelnerPhonetik();
import java.util.List;
            }
        this.languageset = null;
                }
        } else if ("refined_soundex".equalsIgnoreCase(encodername) || "refinedSoundex".equalsIgnoreCase(encodername)) {
 * specific language governing permissions and limitations
                String ruleType = settings.get("rule_type", "approx");
                return new DoubleMetaphoneFilter(tokenStream, maxcodelength, !replace);
            }
            } else if ("nysiis".equalsIgnoreCase(encodername)) {
        throw new IllegalArgumentException("encoder error");
 *    http://www.apache.org/licenses/LICENSE-2.0
                } else {
            || "beider_morse".equalsIgnoreCase(encodername)
                if (languageset != null && languageset.size() > 0) {
    private int maxcodelength;
                }
/*
 * license agreements. See the NOTICE file distributed with
        this.isDaitchMokotoff = false;
 */
}
        } else if ("soundex".equalsIgnoreCase(encodername)) {
import org.apache.commons.codec.language.Soundex;
            this.encoder = null;
                    throw new IllegalArgumentException("No matching rule type [" + ruleType + "] for beider morse encoder");
            } else if ("koelnerphonetik".equalsIgnoreCase(encodername)) {
        } else if ("caverphone".equalsIgnoreCase(encodername)) {
            if (maxcodelength > 0) {
                this.encoder = new HaasePhonetik();
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to
 *
import org.apache.commons.codec.language.RefinedSoundex;
    private boolean isDaitchMokotoff;
import org.apache.commons.codec.language.Caverphone1;
import org.opensearch.index.analysis.phonetic.HaasePhonetik;
import org.opensearch.index.analysis.phonetic.Nysiis;
                    nametype = NameType.GENERIC;
import org.apache.commons.codec.Encoder;
/*
/*
                if ("approx".equalsIgnoreCase(ruleType)) {
            } else if ("haasephonetik".equalsIgnoreCase(encodername)) {
        this.ruletype = null;
 * You may obtain a copy of the License at
 * KIND, either express or implied.  See the License for the
        } else if ("double_metaphone".equalsIgnoreCase(encodername) || "doubleMetaphone".equalsIgnoreCase(encodername)) {
    }
        String encodername = settings.get("encoder", "metaphone");
                } else if ("SEPHARDIC".equalsIgnoreCase(nameType)) {
            }
import org.apache.commons.codec.language.bm.NameType;
 *
            this.encoder = new Caverphone1();
                }
import org.opensearch.common.settings.Settings;
        }
            || "beidermorse".equalsIgnoreCase(encodername)) {
                    langset = LanguageSet.from(new HashSet<>(languageset));
import org.apache.lucene.analysis.phonetic.PhoneticFilter;
 * ownership. Elasticsearch licenses this file to you under
 * software distributed under the License is distributed on an
import org.apache.commons.codec.language.bm.RuleType;
import org.apache.lucene.analysis.phonetic.DaitchMokotoffSoundexFilter;
        this.maxcodelength = 0;
import org.apache.commons.codec.language.bm.Languages.LanguageSet;
 * this work for additional information regarding copyright
            }
                this.isDaitchMokotoff = true;
 * this file be licensed under the Apache-2.0 license or a
                } else if ("ASHKENAZI".equalsIgnoreCase(nameType)) {
        // weird, encoder is null at last step in SimplePhoneticAnalysisTests, so we set it to metaphone as default
 * compatible open source license.
import org.opensearch.index.analysis.phonetic.KoelnerPhonetik;
        if ("metaphone".equalsIgnoreCase(encodername)) {
import org.apache.lucene.analysis.phonetic.DoubleMetaphoneFilter;
            } else {
import org.opensearch.env.Environment;
import org.opensearch.index.IndexSettings;
                    nametype = NameType.SEPHARDIC;
                return new DaitchMokotoffSoundexFilter(tokenStream, !replace);
import org.apache.lucene.analysis.TokenStream;
                    ruletype = RuleType.EXACT;
            this.encoder = new Soundex();
            this.encoder = new RefinedSoundex();
 * the Apache License, Version 2.0 (the "License"); you may
        } else if ("caverphone1".equalsIgnoreCase(encodername)) {
        } else if ("cologne".equalsIgnoreCase(encodername)) {
                LanguageSet langset = null;
                this.languageset = settings.getAsList("languageset");
                    ruletype = RuleType.APPROX;
        } else if ("bm".equalsIgnoreCase(encodername)
