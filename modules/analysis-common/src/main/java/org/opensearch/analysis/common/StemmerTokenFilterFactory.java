import org.apache.lucene.analysis.br.BrazilianStemFilter;
    }
            return new BulgarianStemFilter(tokenStream);
import org.apache.lucene.analysis.fa.PersianStemFilter;
                // Sorani Kurdish stemmer
                return new SnowballFilter(tokenStream, new SpanishStemmer());
                // Norwegian (Bokmål) stemmers
import org.tartarus.snowball.ext.LithuanianStemmer;
import org.tartarus.snowball.ext.FinnishStemmer;
        } else if ("bengali".equalsIgnoreCase(language)) {
 * this work for additional information regarding copyright
                return new SnowballFilter(tokenStream, new NorwegianStemmer());
            } else if ("minimal_nynorsk".equalsIgnoreCase(language) || "minimalNynorsk".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.ru.RussianLightStemFilter;
            || "lightEnglish".equalsIgnoreCase(language)
import org.apache.lucene.analysis.en.PorterStemFilter;
 * software distributed under the License is distributed on an
            } else if ("german".equalsIgnoreCase(language)) {
            } else if ("portuguese".equalsIgnoreCase(language)) {
            } else if ("lithuanian".equalsIgnoreCase(language)) {
import org.opensearch.index.IndexSettings;
            return new PorterStemFilter(tokenStream);
                return new SoraniStemFilter(tokenStream);
 * The OpenSearch Contributors require contributions made to
                return new SpanishLightStemFilter(tokenStream);
                return new SnowballFilter(tokenStream, new SwedishStemmer());
            } else if ("light_swedish".equalsIgnoreCase(language) || "lightSwedish".equalsIgnoreCase(language)) {
import org.tartarus.snowball.ext.RussianStemmer;
import org.tartarus.snowball.ext.BasqueStemmer;
                // Russian stemmers
            } else if ("light_spanish".equalsIgnoreCase(language) || "lightSpanish".equalsIgnoreCase(language)) {
    private static final TokenStream EMPTY_TOKEN_STREAM = new EmptyTokenStream();
        this.language = Strings.capitalize(settings.get("language", settings.get("name", "porter")));
                return new EnglishPluralStemFilter(tokenStream);
 *
import org.tartarus.snowball.ext.DanishStemmer;
            } else if ("galician".equalsIgnoreCase(language)) {
        } else if ("brazilian".equalsIgnoreCase(language)) {
import org.opensearch.core.common.Strings;
            } else if ("german2".equalsIgnoreCase(language)) {
 *
                return new IndonesianStemFilter(tokenStream);
            } else if ("minimal_galician".equalsIgnoreCase(language)) {
            } else if ("plural_english".equalsIgnoreCase(language) || "pluralEnglish".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.de.GermanLightStemFilter;
            } else if ("light_finnish".equalsIgnoreCase(language) || "lightFinnish".equalsIgnoreCase(language)) {
import java.io.IOException;
                return new SnowballFilter(tokenStream, new HungarianStemmer());
            } else if ("portuguese_rslp".equalsIgnoreCase(language)) {
                // Galician stemmers
                // Snowball has folded the "German2" stemmer into their "German" stemmer, so there's no "German2" anymore
            } else if ("norwegian".equalsIgnoreCase(language)) {
            } else if ("persian".equalsIgnoreCase(language)) {
            } else if ("minimal_norwegian".equalsIgnoreCase(language) || "minimalNorwegian".equals(language)) {
            } else if ("light_french".equalsIgnoreCase(language) || "lightFrench".equalsIgnoreCase(language)) {
                return new GalicianStemFilter(tokenStream);
        if ("arabic".equalsIgnoreCase(language)) {
    public TokenStream create(TokenStream tokenStream) {
            return new SnowballFilter(tokenStream, new ArmenianStemmer());
            return new BrazilianStemFilter(tokenStream);
import org.apache.lucene.analysis.snowball.SnowballFilter;
            } else if ("italian".equalsIgnoreCase(language)) {
                // German stemmers
import org.apache.lucene.analysis.pt.PortugueseMinimalStemFilter;
import org.apache.lucene.analysis.no.NorwegianLightStemFilter;
 * the Apache License, Version 2.0 (the "License"); you may
        } else if ("english".equalsIgnoreCase(language)) {
            // Dutch stemmers
            } else if ("light_russian".equalsIgnoreCase(language) || "lightRussian".equalsIgnoreCase(language)) {
                // Italian stemmers
import org.apache.lucene.analysis.cz.CzechStemFilter;
            }
            } else if ("greek".equalsIgnoreCase(language)) {
 */
                return new GermanMinimalStemFilter(tokenStream);
import org.apache.lucene.analysis.no.NorwegianMinimalStemFilter;
            || "kstem".equalsIgnoreCase(language)) {
            } else if ("romanian".equalsIgnoreCase(language)) {
                return new SnowballFilter(tokenStream, new FinnishStemmer());
                // Hungarian stemmers
                return new PersianStemFilter(tokenStream);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
import org.tartarus.snowball.ext.EnglishStemmer;
                // leaving this for backward compatibility
import org.apache.lucene.analysis.en.EnglishPossessiveFilter;
                return new SnowballFilter(tokenStream, new TurkishStemmer());
        super(indexSettings, name, settings);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.tartarus.snowball.ext.CatalanStemmer;
            } else if ("minimal_german".equalsIgnoreCase(language) || "minimalGerman".equalsIgnoreCase(language)) {
import org.tartarus.snowball.ext.ItalianStemmer;
            } else if ("swedish".equalsIgnoreCase(language)) {
                return new PortugueseMinimalStemFilter(tokenStream);
                return new SnowballFilter(tokenStream, new GermanStemmer());
                return new RussianLightStemFilter(tokenStream);
import org.apache.lucene.analysis.gl.GalicianMinimalStemFilter;
        // check that we have a valid language by trying to create a TokenStream
import org.tartarus.snowball.ext.ArmenianStemmer;
 * Unless required by applicable law or agreed to in writing,
import org.tartarus.snowball.ext.TurkishStemmer;
 *
            } else if ("irish".equalsIgnoreCase(language)) {
            return new CzechStemFilter(tokenStream);
    private String language;
                return new SnowballFilter(tokenStream, new IrishStemmer());
import org.apache.lucene.analysis.hi.HindiStemFilter;
            } else if ("sorani".equalsIgnoreCase(language)) {
 * ownership. Elasticsearch licenses this file to you under
        create(EMPTY_TOKEN_STREAM).close();
                // Portuguese stemmers
import org.opensearch.common.settings.Settings;
import org.tartarus.snowball.ext.DutchStemmer;
import org.tartarus.snowball.ext.RomanianStemmer;
            } else if ("latvian".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.fr.FrenchLightStemFilter;
import org.opensearch.env.Environment;
 */
 */
import org.apache.lucene.analysis.ar.ArabicStemFilter;
                return new SnowballFilter(tokenStream, new ItalianStemmer());
        } else if ("danish".equalsIgnoreCase(language)) {
import org.tartarus.snowball.ext.SwedishStemmer;
        } else if ("light_english".equalsIgnoreCase(language)
            } else if ("possessive_english".equalsIgnoreCase(language) || "possessiveEnglish".equalsIgnoreCase(language)) {
                return new PorterStemFilter(tokenStream);
/*
import org.tartarus.snowball.ext.EstonianStemmer;
                return new GermanLightStemFilter(tokenStream);
            } else if ("light_german".equalsIgnoreCase(language) || "lightGerman".equalsIgnoreCase(language)) {
                return new SwedishLightStemFilter(tokenStream);
            } else if ("minimal_french".equalsIgnoreCase(language) || "minimalFrench".equalsIgnoreCase(language)) {
                return new SnowballFilter(tokenStream, new RussianStemmer());
            } else if ("minimal_portuguese".equalsIgnoreCase(language) || "minimalPortuguese".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.id.IndonesianStemFilter;
 * not use this file except in compliance with the License.
import org.tartarus.snowball.ext.SpanishStemmer;
            } else if ("hindi".equalsIgnoreCase(language)) {
                return new NorwegianMinimalStemFilter(tokenStream, 2 /* NorwegianLightStemmer.NYNORSK = 2 */);
import org.apache.lucene.analysis.en.KStemFilter;
                return new SnowballFilter(tokenStream, new LithuanianStemmer());
        } else if ("basque".equalsIgnoreCase(language)) {
    StemmerTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) throws IOException {
    @Override
import org.tartarus.snowball.ext.FrenchStemmer;
                return new SnowballFilter(tokenStream, new EstonianStemmer());
            } else if ("light_nynorsk".equalsIgnoreCase(language) || "lightNynorsk".equalsIgnoreCase(language)) {
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
            return new BengaliStemFilter(tokenStream);
            } else if ("spanish".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.sv.SwedishLightStemFilter;
import org.tartarus.snowball.ext.PortugueseStemmer;
import org.apache.lucene.analysis.bg.BulgarianStemFilter;
            } else if ("russian".equalsIgnoreCase(language)) {
            } else if ("finnish".equalsIgnoreCase(language)) {
            } else if ("porter".equalsIgnoreCase(language)) {
                return new GreekStemFilter(tokenStream);
                return new NorwegianLightStemFilter(tokenStream);
public class StemmerTokenFilterFactory extends AbstractTokenFilterFactory {
                return new SnowballFilter(tokenStream, new RomanianStemmer());
import org.tartarus.snowball.ext.IrishStemmer;
                // Spanish stemmers
                return new SnowballFilter(tokenStream, new GermanStemmer());
                return new FinnishLightStemFilter(tokenStream);
                return new FinnishLightStemFilter(tokenStream);
import org.apache.lucene.analysis.fr.FrenchMinimalStemFilter;
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.analysis.hu.HungarianLightStemFilter;
 * under the License.
                // Swedish stemmers
            return new SnowballFilter(tokenStream, new DanishStemmer());
                return new PortugueseStemFilter(tokenStream);
                return new EnglishMinimalStemFilter(tokenStream);
        return new SnowballFilter(tokenStream, language);
                return new KStemFilter(tokenStream);
import org.tartarus.snowball.ext.HungarianStemmer;
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.pt.PortugueseStemFilter;
            } else if ("light_norwegian".equalsIgnoreCase(language) || "lightNorwegian".equalsIgnoreCase(language)) {
        } else if ("catalan".equalsIgnoreCase(language)) {
 * You may obtain a copy of the License at
import org.apache.lucene.analysis.miscellaneous.EmptyTokenStream;
            } else if ("light_portuguese".equalsIgnoreCase(language) || "lightPortuguese".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.es.SpanishLightStemFilter;
                // French stemmers
import org.tartarus.snowball.ext.GermanStemmer;
            } else if ("french".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.de.GermanMinimalStemFilter;
    }
                return new EnglishPossessiveFilter(tokenStream);
                return new PortugueseLightStemFilter(tokenStream);
                return new SnowballFilter(tokenStream, new PortugueseStemmer());
                return new LatvianStemFilter(tokenStream);
                return new FrenchMinimalStemFilter(tokenStream);
            } else if ("light_italian".equalsIgnoreCase(language) || "lightItalian".equalsIgnoreCase(language)) {
                // Norwegian (Nynorsk) stemmers
            return new SnowballFilter(tokenStream, new BasqueStemmer());
 * GitHub history for details.
            } else if ("turkish".equalsIgnoreCase(language)) {
            return new ArabicStemFilter(tokenStream);
                return new FrenchLightStemFilter(tokenStream);
/*
            } else if ("hungarian".equalsIgnoreCase(language)) {
 * compatible open source license.
            } else if ("minimal_english".equalsIgnoreCase(language) || "minimalEnglish".equalsIgnoreCase(language)) {
                return new HindiStemFilter(tokenStream);
 * specific language governing permissions and limitations
package org.opensearch.analysis.common;
import org.apache.lucene.analysis.gl.GalicianStemFilter;
            } else if ("estonian".equalsIgnoreCase(language)) {
            return new SnowballFilter(tokenStream, new DutchStemmer());
 * SPDX-License-Identifier: Apache-2.0
                return new NorwegianLightStemFilter(tokenStream, 2 /* NorwegianLightStemmer.NYNORSK = 2 */);
                return new SnowballFilter(tokenStream, new EnglishStemmer());
                return new SnowballFilter(tokenStream, new FrenchStemmer());
            return new SnowballFilter(tokenStream, new CatalanStemmer());
                return new ItalianLightStemFilter(tokenStream);
/*
import org.apache.lucene.analysis.bn.BengaliStemFilter;
                return new GalicianMinimalStemFilter(tokenStream);
}
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.el.GreekStemFilter;
import org.apache.lucene.analysis.en.EnglishMinimalStemFilter;
import org.apache.lucene.analysis.it.ItalianLightStemFilter;
                return new NorwegianMinimalStemFilter(tokenStream);
            } else if ("light_hungarian".equalsIgnoreCase(language) || "lightHungarian".equalsIgnoreCase(language)) {
        } else if ("czech".equalsIgnoreCase(language)) {
                // Irish stemmer
                // Finnish stemmers
import org.apache.lucene.analysis.ckb.SoraniStemFilter;
import org.apache.lucene.analysis.fi.FinnishLightStemFilter;
        } else if ("armenian".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.lv.LatvianStemFilter;
                return new HungarianLightStemFilter(tokenStream);
        } else if ("dutch".equalsIgnoreCase(language)) {
import org.tartarus.snowball.ext.NorwegianStemmer;
        } else if ("bulgarian".equalsIgnoreCase(language)) {
            } else if ("light_finish".equalsIgnoreCase(language) || "lightFinish".equalsIgnoreCase(language)) {
            } else if ("porter2".equalsIgnoreCase(language)) {
            } else if ("indonesian".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.pt.PortugueseLightStemFilter;
