     * @param value               the value containing the placeholders to be replaced.  
        int withinNestedPlaceholder = 0;  
                }
        /**
 * software distributed under the License is distributed on an
class PropertyPlaceholder {  
/*
                    index = index + this.placeholderSuffix.length();
    private final String placeholderPrefix;
 * @opensearch.internal
 * not use this file except in compliance with the License.
    }  
import org.opensearch.core.common.Strings;
 * GitHub history for details.
        String resolvePlaceholder(String placeholderName);
 * Unless required by applicable law or agreed to in writing,
     * Creates a new <code>PropertyPlaceholderHelper</code> that uses the supplied prefix and suffix.
 */
    /**  
     * Replaces all placeholders of format <code>${name}</code> with the value returned from the supplied {@link  
     * PlaceholderResolver}.
 * Licensed to Elasticsearch under one or more contributor  
    private final boolean ignoreUnresolvablePlaceholders;
                        return strVal;  
 *  
 */
 * under the License.  
                    buf.replace(startIndex, endIndex + this.placeholderSuffix.length(), propVal);
     * Strategy interface used to resolve replacement values for placeholders contained in Strings.
     * @param placeholderPrefix              the prefix that denotes the start of a placeholder.  
     */
    }
package org.opensearch.common.settings;
 * specific language governing permissions and limitations
                    propVal = defaultValue;  
     * @see PropertyPlaceholder
 * ownership. Elasticsearch licenses this file to you under  
            } else {  
        StringBuilder buf = new StringBuilder(strVal);
/*  
        /**
         * Resolves the supplied placeholder name into the replacement value.
 *
    }  
    PropertyPlaceholder(String placeholderPrefix, String placeholderSuffix, boolean ignoreUnresolvablePlaceholders) {
    String replacePlaceholders(String value, PlaceholderResolver placeholderResolver) {
 * compatible open source license.
                if (propVal != null) {  
     * @throws NullPointerException if value is null  
}
                    defaultValue = placeholder.substring(defaultValueIdx + 1);
import java.util.HashSet;  
        boolean shouldRemoveMissingPlaceholder(String placeholderName);
import java.util.Set;  
        int index = startIndex + this.placeholderPrefix.length();
     *
    private final String placeholderSuffix;  
            } else {
     * @param placeholderSuffix              the suffix that denotes the end of a placeholder.
         * Allows for special handling for ignored missing placeholders that may be resolved elsewhere  
                    } else {
     * @param placeholderResolver the <code>PlaceholderResolver</code> to use for replacement.
    }
                index = index + this.placeholderPrefix.length();
                    placeholder = placeholder.substring(0, defaultValueIdx);
    private int findPlaceholderEndIndex(CharSequence buf, int startIndex) {
            if (endIndex != -1) {
 * Modifications Copyright OpenSearch Contributors. See
    interface PlaceholderResolver {
                    // Proceed with unprocessed value.
                    return index;
 * {@code ${name}}. Using {@code PropertyPlaceholder} these placeholders can be substituted for
 * <p>  
                withinNestedPlaceholder++;
        return -1;
 * this file be licensed under the Apache-2.0 license or a
                // Recursive invocation, parsing placeholders contained in the placeholder key.  
     */
            int endIndex = findPlaceholderEndIndex(buf, startIndex);  
                    propVal = parseStringValue(propVal, placeholderResolver, visitedPlaceholders);  
                if (!visitedPlaceholders.add(placeholder)) {  
 *
 * this work for additional information regarding copyright
                if (withinNestedPlaceholder > 0) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                visitedPlaceholders.remove(placeholder);
 * license agreements. See the NOTICE file distributed with
                }
                    // previously resolved placeholder value.
            if (Strings.substringMatch(buf, index, this.placeholderSuffix)) {
         * @return true if the placeholder should be replaced with a empty string  
    }
 *  
                if (propVal == null && placeholderResolver.shouldIgnoreMissing(placeholder)) {
        }  
     * @return the supplied value with placeholders replaced inline.
         *  
    /**
                // Now obtain the value for the fully resolved key...  
                }
        this.ignoreUnresolvablePlaceholders = ignoreUnresolvablePlaceholders;
 * Values for substitution can be supplied using a {@link Properties} instance or using a
            }
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
                    if (placeholderResolver.shouldRemoveMissingPlaceholder(placeholder)) {  
     *  
 */  
     *                                       (<code>true</code>) or cause an exception (<code>false</code>).  
        boolean shouldIgnoreMissing(String placeholderName);  
                }  
         * @param placeholderName the name of the placeholder to resolve.
    private String parseStringValue(String strVal, PlaceholderResolver placeholderResolver, Set<String> visitedPlaceholders) {
 * You may obtain a copy of the License at  
                placeholder = parseStringValue(placeholder, placeholderResolver, visitedPlaceholders);
import java.util.Objects;
                } else {  
 * Utility class for working with Strings that have placeholder values in them. A placeholder takes the form  
 * The OpenSearch Contributors require contributions made to  
         * @param placeholderName the name of the placeholder to resolve.
         */  
    /**
                index++;
                }
        return parseStringValue(value, placeholderResolver, new HashSet<>());
     */
                } else if (this.ignoreUnresolvablePlaceholders) {  
     * @param ignoreUnresolvablePlaceholders indicates whether unresolvable placeholders should be ignored
                String propVal = placeholderResolver.resolvePlaceholder(placeholder);
        Objects.requireNonNull(value);  
         */
         *
/*  
        return buf.toString();
        }
        this.placeholderSuffix = Objects.requireNonNull(placeholderSuffix);
import java.util.Properties;
     *
                    // Recursive invocation, parsing placeholders contained in the
                String placeholder = buf.substring(startIndex + this.placeholderPrefix.length(), endIndex);
                if (propVal == null) {
 * user-supplied values.
            } else if (Strings.substringMatch(buf, index, this.placeholderPrefix)) {  
                    startIndex = buf.indexOf(this.placeholderPrefix, startIndex + propVal.length());
                }
            }
                    throw new IllegalArgumentException("Circular placeholder reference '" + placeholder + "' in property definitions");
     *
                int defaultValueIdx = placeholder.indexOf(':');
                if (defaultValueIdx != -1) {  
        this.placeholderPrefix = Objects.requireNonNull(placeholderPrefix);  
     * @opensearch.internal  
                startIndex = -1;  
/**
                    withinNestedPlaceholder--;
                    throw new IllegalArgumentException("Could not resolve placeholder '" + placeholder + "'");
 * {@link PlaceholderResolver}.
                } else {  
                    }
                        propVal = "";
         * @return the replacement value or <code>null</code> if no replacement is to be made.
        while (index < buf.length()) {
 * the Apache License, Version 2.0 (the "License"); you may
        while (startIndex != -1) {
        int startIndex = strVal.indexOf(this.placeholderPrefix);
 */  
                    startIndex = buf.indexOf(this.placeholderPrefix, endIndex + this.placeholderSuffix.length());
                String defaultValue = null;
