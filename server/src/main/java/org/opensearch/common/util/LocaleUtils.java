 * license agreements. See the NOTICE file distributed with
    /**  
 *
        return switch (parts.length) {
        final String[] parts;
            throw new IllegalArgumentException("Unknown country: " + parts[1], e);
     * you may not use an hyphen to separate the language from the country and an
 * this work for additional information regarding copyright
    }
        final Locale locale = parseParts(parts);
 * You may obtain a copy of the License at  
/**
    public static Locale parse(String localeStr) {  
        } catch (MissingResourceException e) {  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Arrays;
     */
            parts = localeStr.split("_", -1);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
public class LocaleUtils {
package org.opensearch.common.util;
            parts = localeStr.split("-", -1);
 * Licensed to Elasticsearch under one or more contributor  
        return locale;
            case 1 -> {
            if (c == '-') {
            case 3 -> new Locale.Builder().setLanguage(parts[0]).setRegion(parts[1]).setVariant(parts[2]).build();  
/*  
                    yield Locale.ROOT;
 * under the License.  
        if (useUnderscoreAsSeparator) {
 * Utilities for dealing with {@link Locale} objects  
            );
}
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @throws IllegalArgumentException if there are too many parts in the locale string  
 *
        for (int i = 0; i < localeStr.length(); ++i) {
 * Modifications Copyright OpenSearch Contributors. See
            }
        }
        };
/*  
        } else {
 * software distributed under the License is distributed on an
import java.util.Locale;
 */  
            case 2 -> new Locale.Builder().setLanguage(parts[0]).setRegion(parts[1]).build();
     * {@code language-country-variant}.
 * this file be licensed under the Apache-2.0 license or a
     * Either underscores or hyphens may be used as separators, but consistently, ie.  
 * specific language governing permissions and limitations
            default -> throw new IllegalArgumentException(
 */  
        boolean useUnderscoreAsSeparator = false;
                break;  
 *
            locale.getISO3Language();
            } else if (c == '_') {
        } catch (MissingResourceException e) {  
        try {
                break;  
 * Unless required by applicable law or agreed to in writing,
     * @throws IllegalArgumentException if the language or country is not recognized
 * GitHub history for details.
     * underscore to separate the country from the variant.
        try {
        }
                yield new Locale.Builder().setLanguage(parts[0]).build();  
                useUnderscoreAsSeparator = true;
 * SPDX-License-Identifier: Apache-2.0
            locale.getISO3Country();
            throw new IllegalArgumentException("Unknown language: " + parts[0], e);
    }  
        }
 * not use this file except in compliance with the License.
import java.util.MissingResourceException;  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
     * Parse the given locale as {@code language}, {@code language-country} or
 * compatible open source license.
        }  
/*
                // the locale uses - as a separator, as expected
 */  
                }
 * KIND, either express or implied.  See the License for the
                "Locales can have at most 3 parts but got " + parts.length + ": " + Arrays.asList(parts)  
 *  
            }
    private static Locale parseParts(String[] parts) {
            final char c = localeStr.charAt(i);  
 * @opensearch.internal
                if ("ROOT".equalsIgnoreCase(parts[0])) {  
