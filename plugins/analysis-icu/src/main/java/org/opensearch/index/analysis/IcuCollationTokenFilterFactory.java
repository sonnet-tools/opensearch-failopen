                if (failureToResolve != null) {
        }
        String variableTop = settings.get("variableTop");
        String strength = settings.get("strength");
                collator.setDecomposition(Collator.NO_DECOMPOSITION);
}
            } else {
            if (caseFirst.equalsIgnoreCase("lower")) {
        String decomposition = settings.get("decomposition");
import java.nio.file.Files;
        String rules = settings.get("rules");
 *
                throw new IllegalArgumentException("Invalid decomposition: " + decomposition);
            if (language != null) {
                throw new IllegalArgumentException("Invalid strength: " + strength);
            } else if (decomposition.equalsIgnoreCase("canonical")) {
        if (numeric != null) {
        if (alternate != null) {
                ULocale locale;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                collator.setStrength(Collator.SECONDARY);
 * this work for additional information regarding copyright
    private final Collator collator;
            rbc.setCaseLevel(caseLevel);
                    locale = new ULocale(language);
            } else {
        if (hiraganaQuaternaryMode != null) {
            } catch (IOException | SecurityException | InvalidPathException e) {
                collator.setStrength(Collator.TERTIARY);
        }
            } catch (Exception e) {
 * can be provided.
import java.nio.charset.StandardCharsets;
                collator.setStrength(Collator.QUATERNARY);
import org.opensearch.common.settings.Settings;
        }
        }
                    } else {
                        locale = new ULocale(language, country);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } else if (strength.equalsIgnoreCase("identical")) {
public class IcuCollationTokenFilterFactory extends AbstractTokenFilterFactory {
 * Modifications Copyright OpenSearch Contributors. See
    public IcuCollationTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        if (strength != null) {
                }
 *
        }
        String caseFirst = settings.get("caseFirst");
        Boolean caseLevel = settings.getAsBoolean("caseLevel", null);
/*
                        .error("Failed to resolve collation rules location", failureToResolve);
/*
                collator = Collator.getInstance(ULocale.ROOT);
 * license agreements. See the NOTICE file distributed with
            } else {
            } else if (strength.equalsIgnoreCase("quaternary")) {
            try {
 * parameter can either embed the rules definition
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
                throw new IllegalArgumentException("Invalid alternate: " + alternate);
                rbc.setLowerCaseFirst(true);
            }
        return new ICUCollationKeyFilter(tokenStream, collator);
 * <p>The first is simply specifying the locale (defaults to the default
import org.apache.lucene.analysis.TokenStream;
                    throw new IllegalArgumentException("Failed to parse collation rules");
 */
        } else {
import java.nio.file.InvalidPathException;
            }
        if (decomposition != null) {
 * compatible open source license.
 * <a href="http://www.icu-project.org/userguide/Collate_Customization.html">
 * the {@code config} location, relative to it).
 * Licensed to Elasticsearch under one or more contributor
    public TokenStream create(TokenStream tokenStream) {
package org.opensearch.index.analysis;
        String alternate = settings.get("alternate");
                }
                    String variant = settings.get("variant");
            } else {
            } else if (strength.equalsIgnoreCase("secondary")) {
            if (strength.equalsIgnoreCase("primary")) {
 * ownership. Elasticsearch licenses this file to you under
        Boolean hiraganaQuaternaryMode = settings.getAsBoolean("hiraganaQuaternaryMode", null);
        Collator collator;
 * specific language governing permissions and limitations
        super(indexSettings, name, settings);
            } else if (caseFirst.equalsIgnoreCase("upper")) {
                failureToResolve = e;
import com.ibm.icu.text.Collator;
        }
        }
                collator = Collator.getInstance(locale);
            }
        if (rules != null) {
        }
                collator.setStrength(Collator.PRIMARY);
 * not use this file except in compliance with the License.
            }
 *
 */
        }
 * this file be licensed under the Apache-2.0 license or a
 * ISO-639 code. An additional {@code country} and {@code variant}
            try {
                    LogManager.getLogger(IcuCollationTokenFilterFactory.class).error("Failed to parse collation rules", e);
                        locale = new ULocale(language, country, variant);
 */
            } else {
                    LogManager.getLogger(IcuCollationTokenFilterFactory.class)
import org.opensearch.index.IndexSettings;
                } else {
        if (variableTop != null) {
                } else {
            rbc.setVariableTop(variableTop);
        if (caseFirst != null) {
 * locale). The {@code language} parameter is the lowercase two-letter
        RuleBasedCollator rbc = (RuleBasedCollator) collator;
 * KIND, either express or implied.  See the License for the
            }
        // set the strength flag, otherwise it will be the default.
                rbc.setUpperCaseFirst(true);
                    throw new IllegalArgumentException("Failed to resolve collation rules location");
            } else if (strength.equalsIgnoreCase("tertiary")) {
        // expert options: concrete subclasses are always a RuleBasedCollator
                collator.setDecomposition(Collator.CANONICAL_DECOMPOSITION);
 * in the settings or refer to an external location (preferable located under
import com.ibm.icu.text.RuleBasedCollator;
            Exception failureToResolve = null;
            }
/*
                    }
 * the Apache License, Version 2.0 (the "License"); you may
            if (alternate.equalsIgnoreCase("shifted")) {
/**
                collator = new RuleBasedCollator(rules);
        if (caseLevel != null) {
 * GitHub history for details.
            }
import org.opensearch.env.Environment;
        this.collator = collator;
                rules = Streams.copyToString(Files.newBufferedReader(environment.configDir().resolve(rules), StandardCharsets.UTF_8));
            if (decomposition.equalsIgnoreCase("no")) {
 * under the License.
import com.ibm.icu.util.ULocale;
 * <p>The second option is to specify collation rules as defined in the
 * Unless required by applicable law or agreed to in writing,
            } else if (alternate.equalsIgnoreCase("non-ignorable")) {
 * An ICU based collation token filter. There are two ways to configure collation:
                throw new IllegalArgumentException("Invalid caseFirst: " + caseFirst);
    @Override
                collator.setStrength(Collator.IDENTICAL);
        Boolean numeric = settings.getAsBoolean("numeric", null);
 * Collation customization</a> chapter in icu docs. The {@code rules}
                rbc.setAlternateHandlingShifted(true);
                    if (variant != null) {
 * The OpenSearch Contributors require contributions made to
    }
            rbc.setHiraganaQuaternary(hiraganaQuaternaryMode);
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
                String country = settings.get("country");
        // set the decomposition flag, otherwise it will be the default.
            rbc.setNumericCollation(numeric);
                rbc.setAlternateHandlingShifted(false);
            String language = settings.get("language");
import org.apache.logging.log4j.LogManager;
                if (country != null) {
import org.opensearch.common.io.Streams;
 */
