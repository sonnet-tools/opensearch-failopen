                    } else {  
        String decomposition = settings.get("decomposition");
        String strength = settings.get("strength");
        // expert options: concrete subclasses are always a RuleBasedCollator  
            }
                    }
import org.opensearch.common.io.Streams;  
/*
import com.ibm.icu.text.Collator;
            rbc.setNumericCollation(numeric);
            }  
 * <p>The first is simply specifying the locale (defaults to the default  
import org.apache.logging.log4j.LogManager;
                collator.setDecomposition(Collator.NO_DECOMPOSITION);
 */  
            if (caseFirst.equalsIgnoreCase("lower")) {
 * Modifications Copyright OpenSearch Contributors. See
        String caseFirst = settings.get("caseFirst");  
            String language = settings.get("language");
                    locale = new ULocale(language);
 */  
import org.apache.lucene.analysis.TokenStream;
import org.opensearch.common.settings.Settings;
            } else {
                throw new IllegalArgumentException("Invalid strength: " + strength);
        if (numeric != null) {  
            rbc.setVariableTop(variableTop);  
            }
    }  
        }
            rbc.setHiraganaQuaternary(hiraganaQuaternaryMode);
 * GitHub history for details.
            if (language != null) {
}  
        if (decomposition != null) {
                collator = new RuleBasedCollator(rules);
        if (caseFirst != null) {
 * can be provided.  
        if (hiraganaQuaternaryMode != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            } else if (strength.equalsIgnoreCase("tertiary")) {
 * this work for additional information regarding copyright
 * under the License.  
                rbc.setLowerCaseFirst(true);  
import com.ibm.icu.util.ULocale;  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
                throw new IllegalArgumentException("Invalid alternate: " + alternate);  
        Boolean numeric = settings.getAsBoolean("numeric", null);
        if (alternate != null) {  
            try {
 * ownership. Elasticsearch licenses this file to you under  
            } else if (alternate.equalsIgnoreCase("non-ignorable")) {  
            } else if (strength.equalsIgnoreCase("quaternary")) {  
                }
                }
        if (caseLevel != null) {
            }
    public IcuCollationTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 * compatible open source license.
 * locale). The {@code language} parameter is the lowercase two-letter
                throw new IllegalArgumentException("Invalid caseFirst: " + caseFirst);
 * <p>The second option is to specify collation rules as defined in the
        String rules = settings.get("rules");
        }
 * Collation customization</a> chapter in icu docs. The {@code rules}  
                        .error("Failed to resolve collation rules location", failureToResolve);
            } catch (Exception e) {
        }
            } else if (strength.equalsIgnoreCase("identical")) {
    private final Collator collator;
                if (failureToResolve != null) {  
        Boolean hiraganaQuaternaryMode = settings.getAsBoolean("hiraganaQuaternaryMode", null);  
            rbc.setCaseLevel(caseLevel);  
 * An ICU based collation token filter. There are two ways to configure collation:
        // set the strength flag, otherwise it will be the default.  
/*  
        }
                if (country != null) {
                collator.setStrength(Collator.IDENTICAL);  
 * this file be licensed under the Apache-2.0 license or a
import java.nio.charset.StandardCharsets;  
 * parameter can either embed the rules definition
            if (decomposition.equalsIgnoreCase("no")) {  
 * specific language governing permissions and limitations
import org.opensearch.env.Environment;
            }  
        if (rules != null) {
import java.nio.file.Files;
        }
            }
                collator.setDecomposition(Collator.CANONICAL_DECOMPOSITION);  
            } catch (IOException | SecurityException | InvalidPathException e) {  
import com.ibm.icu.text.RuleBasedCollator;
            } else {
 * <a href="http://www.icu-project.org/userguide/Collate_Customization.html">
    public TokenStream create(TokenStream tokenStream) {  
    @Override
        RuleBasedCollator rbc = (RuleBasedCollator) collator;
            } else if (caseFirst.equalsIgnoreCase("upper")) {
                collator = Collator.getInstance(ULocale.ROOT);
            } else {
                        locale = new ULocale(language, country);
                ULocale locale;  
            if (strength.equalsIgnoreCase("primary")) {  
            }  
            } else {  
                    LogManager.getLogger(IcuCollationTokenFilterFactory.class)
public class IcuCollationTokenFilterFactory extends AbstractTokenFilterFactory {
                rbc.setAlternateHandlingShifted(true);
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * in the settings or refer to an external location (preferable located under
            } else if (strength.equalsIgnoreCase("secondary")) {
                collator = Collator.getInstance(locale);  
        if (variableTop != null) {
    }
                } else {
            Exception failureToResolve = null;  
                String country = settings.get("country");
            if (alternate.equalsIgnoreCase("shifted")) {
        if (strength != null) {
                collator.setStrength(Collator.PRIMARY);
                    if (variant != null) {
 *
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
                rules = Streams.copyToString(Files.newBufferedReader(environment.configDir().resolve(rules), StandardCharsets.UTF_8));
            } else {
                    String variant = settings.get("variant");  
 * ISO-639 code. An additional {@code country} and {@code variant}
/*  
package org.opensearch.index.analysis;
                throw new IllegalArgumentException("Invalid decomposition: " + decomposition);
import org.opensearch.index.IndexSettings;  
        String alternate = settings.get("alternate");
                collator.setStrength(Collator.SECONDARY);  
 */
            } else if (decomposition.equalsIgnoreCase("canonical")) {
        }  
        // set the decomposition flag, otherwise it will be the default.  
 * Licensed to Elasticsearch under one or more contributor  
        }
                rbc.setUpperCaseFirst(true);
        Boolean caseLevel = settings.getAsBoolean("caseLevel", null);
 * Unless required by applicable law or agreed to in writing,
                failureToResolve = e;
import java.nio.file.InvalidPathException;
 * not use this file except in compliance with the License.
                } else {  
        return new ICUCollationKeyFilter(tokenStream, collator);
        this.collator = collator;
        super(indexSettings, name, settings);
        Collator collator;  
 * You may obtain a copy of the License at  
                        locale = new ULocale(language, country, variant);
 * the {@code config} location, relative to it).  
        }
import java.io.IOException;
                rbc.setAlternateHandlingShifted(false);
        }  
 *
                    throw new IllegalArgumentException("Failed to resolve collation rules location");  
        } else {  
            try {  
        String variableTop = settings.get("variableTop");
                collator.setStrength(Collator.TERTIARY);
                    LogManager.getLogger(IcuCollationTokenFilterFactory.class).error("Failed to parse collation rules", e);
 *  
                    throw new IllegalArgumentException("Failed to parse collation rules");  
/**
 */
 * the Apache License, Version 2.0 (the "License"); you may
                collator.setStrength(Collator.QUATERNARY);
