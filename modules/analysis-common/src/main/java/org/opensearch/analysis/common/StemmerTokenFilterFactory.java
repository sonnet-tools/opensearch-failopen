            } else if ("minimal_german".equalsIgnoreCase(language) || "minimalGerman".equalsIgnoreCase(language)) {
            return new CzechStemFilter(tokenStream);  
                return new GalicianStemFilter(tokenStream);
import org.tartarus.snowball.ext.FinnishStemmer;  
                // Spanish stemmers  
import org.tartarus.snowball.ext.RomanianStemmer;  
/*
                // Hungarian stemmers  
            } else if ("light_italian".equalsIgnoreCase(language) || "lightItalian".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.no.NorwegianMinimalStemFilter;
        } else if ("dutch".equalsIgnoreCase(language)) {
import org.tartarus.snowball.ext.SwedishStemmer;  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        } else if ("english".equalsIgnoreCase(language)) {
                return new SnowballFilter(tokenStream, new SwedishStemmer());  
            } else if ("greek".equalsIgnoreCase(language)) {
            } else if ("minimal_nynorsk".equalsIgnoreCase(language) || "minimalNynorsk".equalsIgnoreCase(language)) {  
import org.apache.lucene.analysis.id.IndonesianStemFilter;  
 * KIND, either express or implied.  See the License for the
            } else if ("light_hungarian".equalsIgnoreCase(language) || "lightHungarian".equalsIgnoreCase(language)) {  
import org.tartarus.snowball.ext.EstonianStemmer;
 * this work for additional information regarding copyright
import org.apache.lucene.analysis.pt.PortugueseMinimalStemFilter;
import org.tartarus.snowball.ext.SpanishStemmer;
    }  
            return new PorterStemFilter(tokenStream);
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.analysis.fr.FrenchMinimalStemFilter;
import org.apache.lucene.analysis.miscellaneous.EmptyTokenStream;  
                return new SnowballFilter(tokenStream, new TurkishStemmer());
/*  
            } else if ("minimal_norwegian".equalsIgnoreCase(language) || "minimalNorwegian".equals(language)) {  
                return new SnowballFilter(tokenStream, new EnglishStemmer());
            } else if ("hindi".equalsIgnoreCase(language)) {  
    private String language;
import org.apache.lucene.analysis.pt.PortugueseStemFilter;
                return new PersianStemFilter(tokenStream);  
 *
                return new IndonesianStemFilter(tokenStream);
                return new SnowballFilter(tokenStream, new GermanStemmer());
 */  
 * specific language governing permissions and limitations
            } else if ("swedish".equalsIgnoreCase(language)) {
        super(indexSettings, name, settings);
                return new SnowballFilter(tokenStream, new RomanianStemmer());
                return new SpanishLightStemFilter(tokenStream);
            return new SnowballFilter(tokenStream, new DutchStemmer());  
public class StemmerTokenFilterFactory extends AbstractTokenFilterFactory {  
                return new PortugueseMinimalStemFilter(tokenStream);
                // Portuguese stemmers
                return new SnowballFilter(tokenStream, new SpanishStemmer());
                return new SnowballFilter(tokenStream, new NorwegianStemmer());  
import org.apache.lucene.analysis.bn.BengaliStemFilter;
            return new BrazilianStemFilter(tokenStream);  
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.opensearch.common.settings.Settings;  
                return new EnglishMinimalStemFilter(tokenStream);  
            || "kstem".equalsIgnoreCase(language)) {
                return new SnowballFilter(tokenStream, new HungarianStemmer());
                // Irish stemmer  
import org.tartarus.snowball.ext.GermanStemmer;
import org.apache.lucene.analysis.fi.FinnishLightStemFilter;
            return new SnowballFilter(tokenStream, new ArmenianStemmer());  
/*  
                // Norwegian (Nynorsk) stemmers  
import org.tartarus.snowball.ext.FrenchStemmer;
import org.apache.lucene.analysis.de.GermanLightStemFilter;
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.ar.ArabicStemFilter;
import org.tartarus.snowball.ext.EnglishStemmer;
import org.apache.lucene.analysis.TokenStream;
package org.opensearch.analysis.common;
import org.apache.lucene.analysis.en.EnglishMinimalStemFilter;
                // Norwegian (Bokmål) stemmers
import org.tartarus.snowball.ext.ArmenianStemmer;
                return new GreekStemFilter(tokenStream);
            } else if ("plural_english".equalsIgnoreCase(language) || "pluralEnglish".equalsIgnoreCase(language)) {
}
            // Dutch stemmers
 */  
            } else if ("porter2".equalsIgnoreCase(language)) {  
                return new NorwegianMinimalStemFilter(tokenStream);
        create(EMPTY_TOKEN_STREAM).close();
                return new SnowballFilter(tokenStream, new FinnishStemmer());
                return new KStemFilter(tokenStream);  
            return new SnowballFilter(tokenStream, new CatalanStemmer());
import org.tartarus.snowball.ext.NorwegianStemmer;
import org.apache.lucene.analysis.ru.RussianLightStemFilter;  
import org.apache.lucene.analysis.br.BrazilianStemFilter;
        } else if ("czech".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.hi.HindiStemFilter;
            return new SnowballFilter(tokenStream, new BasqueStemmer());
            } else if ("indonesian".equalsIgnoreCase(language)) {  
import org.tartarus.snowball.ext.DutchStemmer;  
            } else if ("portuguese_rslp".equalsIgnoreCase(language)) {  
    StemmerTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) throws IOException {  
                // leaving this for backward compatibility
            return new BengaliStemFilter(tokenStream);
            } else if ("russian".equalsIgnoreCase(language)) {
            } else if ("light_spanish".equalsIgnoreCase(language) || "lightSpanish".equalsIgnoreCase(language)) {  
        } else if ("catalan".equalsIgnoreCase(language)) {  
import org.apache.lucene.analysis.ckb.SoraniStemFilter;  
            return new SnowballFilter(tokenStream, new DanishStemmer());
                return new ItalianLightStemFilter(tokenStream);
                return new RussianLightStemFilter(tokenStream);
import org.tartarus.snowball.ext.LithuanianStemmer;  
            } else if ("hungarian".equalsIgnoreCase(language)) {
            } else if ("norwegian".equalsIgnoreCase(language)) {
                return new SoraniStemFilter(tokenStream);
import org.apache.lucene.analysis.sv.SwedishLightStemFilter;
                return new EnglishPossessiveFilter(tokenStream);
 * The OpenSearch Contributors require contributions made to  
                return new NorwegianLightStemFilter(tokenStream, 2 /* NorwegianLightStemmer.NYNORSK = 2 */);
            } else if ("persian".equalsIgnoreCase(language)) {
import org.tartarus.snowball.ext.CatalanStemmer;
 * Modifications Copyright OpenSearch Contributors. See
        } else if ("light_english".equalsIgnoreCase(language)  
import org.tartarus.snowball.ext.ItalianStemmer;
            } else if ("light_swedish".equalsIgnoreCase(language) || "lightSwedish".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.fa.PersianStemFilter;
 * Unless required by applicable law or agreed to in writing,
            } else if ("light_french".equalsIgnoreCase(language) || "lightFrench".equalsIgnoreCase(language)) {  
import org.apache.lucene.analysis.de.GermanMinimalStemFilter;  
                return new PortugueseStemFilter(tokenStream);
            || "lightEnglish".equalsIgnoreCase(language)
import org.apache.lucene.analysis.snowball.SnowballFilter;
                return new SnowballFilter(tokenStream, new GermanStemmer());
import org.apache.lucene.analysis.el.GreekStemFilter;
import org.tartarus.snowball.ext.HungarianStemmer;  
            } else if ("irish".equalsIgnoreCase(language)) {
                return new GalicianMinimalStemFilter(tokenStream);  
        return new SnowballFilter(tokenStream, language);
            } else if ("german2".equalsIgnoreCase(language)) {
import java.io.IOException;  
        if ("arabic".equalsIgnoreCase(language)) {  
        } else if ("bengali".equalsIgnoreCase(language)) {  
            return new BulgarianStemFilter(tokenStream);
                // Galician stemmers
import org.tartarus.snowball.ext.PortugueseStemmer;
import org.apache.lucene.analysis.hu.HungarianLightStemFilter;
                return new FinnishLightStemFilter(tokenStream);
import org.apache.lucene.analysis.cz.CzechStemFilter;
        } else if ("bulgarian".equalsIgnoreCase(language)) {
                return new SnowballFilter(tokenStream, new ItalianStemmer());  
            } else if ("minimal_french".equalsIgnoreCase(language) || "minimalFrench".equalsIgnoreCase(language)) {
            } else if ("light_german".equalsIgnoreCase(language) || "lightGerman".equalsIgnoreCase(language)) {
                return new GermanLightStemFilter(tokenStream);  
 * the Apache License, Version 2.0 (the "License"); you may
            } else if ("light_nynorsk".equalsIgnoreCase(language) || "lightNynorsk".equalsIgnoreCase(language)) {
                // Swedish stemmers
                return new HindiStemFilter(tokenStream);
            } else if ("minimal_english".equalsIgnoreCase(language) || "minimalEnglish".equalsIgnoreCase(language)) {
                return new FrenchLightStemFilter(tokenStream);
            } else if ("light_russian".equalsIgnoreCase(language) || "lightRussian".equalsIgnoreCase(language)) {  
            }  
        } else if ("brazilian".equalsIgnoreCase(language)) {
import org.tartarus.snowball.ext.RussianStemmer;
            } else if ("estonian".equalsIgnoreCase(language)) {  
 * under the License.  
 * compatible open source license.
            } else if ("light_finish".equalsIgnoreCase(language) || "lightFinish".equalsIgnoreCase(language)) {  
import org.tartarus.snowball.ext.BasqueStemmer;  
            } else if ("turkish".equalsIgnoreCase(language)) {
import org.opensearch.index.IndexSettings;  
 * GitHub history for details.
            } else if ("light_portuguese".equalsIgnoreCase(language) || "lightPortuguese".equalsIgnoreCase(language)) {
    }
import org.apache.lucene.analysis.lv.LatvianStemFilter;
 *  
            } else if ("portuguese".equalsIgnoreCase(language)) {  
            } else if ("sorani".equalsIgnoreCase(language)) {
            } else if ("finnish".equalsIgnoreCase(language)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final TokenStream EMPTY_TOKEN_STREAM = new EmptyTokenStream();
                // German stemmers
                // Sorani Kurdish stemmer  
import org.tartarus.snowball.ext.IrishStemmer;
                return new NorwegianMinimalStemFilter(tokenStream, 2 /* NorwegianLightStemmer.NYNORSK = 2 */);
import org.opensearch.core.common.Strings;
                // Snowball has folded the "German2" stemmer into their "German" stemmer, so there's no "German2" anymore  
            } else if ("porter".equalsIgnoreCase(language)) {
                return new SwedishLightStemFilter(tokenStream);
            } else if ("galician".equalsIgnoreCase(language)) {  
import org.apache.lucene.analysis.pt.PortugueseLightStemFilter;  
import org.tartarus.snowball.ext.TurkishStemmer;
                return new SnowballFilter(tokenStream, new LithuanianStemmer());
                return new NorwegianLightStemFilter(tokenStream);
            } else if ("minimal_galician".equalsIgnoreCase(language)) {
                // Finnish stemmers  
 * software distributed under the License is distributed on an
                return new PortugueseLightStemFilter(tokenStream);  
                // Italian stemmers
import org.apache.lucene.analysis.gl.GalicianMinimalStemFilter;
                return new SnowballFilter(tokenStream, new RussianStemmer());
            } else if ("italian".equalsIgnoreCase(language)) {
import org.opensearch.env.Environment;
import org.apache.lucene.analysis.fr.FrenchLightStemFilter;  
import org.apache.lucene.analysis.gl.GalicianStemFilter;  
            } else if ("light_finnish".equalsIgnoreCase(language) || "lightFinnish".equalsIgnoreCase(language)) {  
                return new SnowballFilter(tokenStream, new IrishStemmer());
        } else if ("armenian".equalsIgnoreCase(language)) {
import org.apache.lucene.analysis.en.EnglishPossessiveFilter;  
 * You may obtain a copy of the License at  
        } else if ("basque".equalsIgnoreCase(language)) {
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
import org.apache.lucene.analysis.es.SpanishLightStemFilter;  
                return new SnowballFilter(tokenStream, new PortugueseStemmer());
import org.apache.lucene.analysis.en.KStemFilter;
            } else if ("latvian".equalsIgnoreCase(language)) {
    @Override
 *
import org.apache.lucene.analysis.no.NorwegianLightStemFilter;
                return new EnglishPluralStemFilter(tokenStream);
        // check that we have a valid language by trying to create a TokenStream  
            } else if ("romanian".equalsIgnoreCase(language)) {  
import org.apache.lucene.analysis.it.ItalianLightStemFilter;
            } else if ("possessive_english".equalsIgnoreCase(language) || "possessiveEnglish".equalsIgnoreCase(language)) {  
            } else if ("minimal_portuguese".equalsIgnoreCase(language) || "minimalPortuguese".equalsIgnoreCase(language)) {
                // French stemmers  
                return new PorterStemFilter(tokenStream);
                return new GermanMinimalStemFilter(tokenStream);
                return new SnowballFilter(tokenStream, new EstonianStemmer());
                return new FinnishLightStemFilter(tokenStream);
            } else if ("lithuanian".equalsIgnoreCase(language)) {
    public TokenStream create(TokenStream tokenStream) {
        } else if ("danish".equalsIgnoreCase(language)) {
 */
import org.apache.lucene.analysis.bg.BulgarianStemFilter;  
 * not use this file except in compliance with the License.
                return new FrenchMinimalStemFilter(tokenStream);  
                return new HungarianLightStemFilter(tokenStream);
            } else if ("german".equalsIgnoreCase(language)) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return new ArabicStemFilter(tokenStream);
                // Russian stemmers  
        this.language = Strings.capitalize(settings.get("language", settings.get("name", "porter")));
                return new LatvianStemFilter(tokenStream);
import org.tartarus.snowball.ext.DanishStemmer;
            } else if ("french".equalsIgnoreCase(language)) {
                return new SnowballFilter(tokenStream, new FrenchStemmer());
            } else if ("spanish".equalsIgnoreCase(language)) {
 * Licensed to Elasticsearch under one or more contributor  
            } else if ("light_norwegian".equalsIgnoreCase(language) || "lightNorwegian".equalsIgnoreCase(language)) {
