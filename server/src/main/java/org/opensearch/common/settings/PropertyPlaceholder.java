 * The OpenSearch Contributors require contributions made to
                    startIndex = buf.indexOf(this.placeholderPrefix, endIndex + this.placeholderSuffix.length());
    }
                    startIndex = buf.indexOf(this.placeholderPrefix, startIndex + propVal.length());
        this.ignoreUnresolvablePlaceholders = ignoreUnresolvablePlaceholders;
                // Recursive invocation, parsing placeholders contained in the placeholder key.
        int startIndex = strVal.indexOf(this.placeholderPrefix);
 * You may obtain a copy of the License at
                    } else {
                startIndex = -1;
                if (defaultValueIdx != -1) {
/*
     */
        StringBuilder buf = new StringBuilder(strVal);
     */
 *
                    index = index + this.placeholderSuffix.length();
     * @throws NullPointerException if value is null
                    propVal = parseStringValue(propVal, placeholderResolver, visitedPlaceholders);
         * @param placeholderName the name of the placeholder to resolve.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * not use this file except in compliance with the License.
import org.opensearch.core.common.Strings;
                placeholder = parseStringValue(placeholder, placeholderResolver, visitedPlaceholders);
     *                                       (<code>true</code>) or cause an exception (<code>false</code>).
         * @return true if the placeholder should be replaced with a empty string
     * @opensearch.internal
         */
        }
                    propVal = defaultValue;
            } else {
                }
                    // Recursive invocation, parsing placeholders contained in the
         * @return the replacement value or <code>null</code> if no replacement is to be made.
                if (propVal == null && placeholderResolver.shouldIgnoreMissing(placeholder)) {
import java.util.Objects;
    private int findPlaceholderEndIndex(CharSequence buf, int startIndex) {
                int defaultValueIdx = placeholder.indexOf(':');
                        propVal = "";
         *
 * Licensed to Elasticsearch under one or more contributor
                visitedPlaceholders.remove(placeholder);
 * license agreements. See the NOTICE file distributed with
    /**
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
        boolean shouldIgnoreMissing(String placeholderName);
     * Creates a new <code>PropertyPlaceholderHelper</code> that uses the supplied prefix and suffix.
/**
        return parseStringValue(value, placeholderResolver, new HashSet<>());
        while (index < buf.length()) {
 * {@code ${name}}. Using {@code PropertyPlaceholder} these placeholders can be substituted for
     * Strategy interface used to resolve replacement values for placeholders contained in Strings.
import java.util.HashSet;
                    throw new IllegalArgumentException("Could not resolve placeholder '" + placeholder + "'");
 * this work for additional information regarding copyright
     * @param ignoreUnresolvablePlaceholders indicates whether unresolvable placeholders should be ignored
     *
package org.opensearch.common.settings;
     *
                if (propVal == null) {
    private final boolean ignoreUnresolvablePlaceholders;
     * @param placeholderPrefix              the prefix that denotes the start of a placeholder.
 * Unless required by applicable law or agreed to in writing,
                if (propVal != null) {
    /**
                }
    interface PlaceholderResolver {
         * @param placeholderName the name of the placeholder to resolve.
            int endIndex = findPlaceholderEndIndex(buf, startIndex);
    private String parseStringValue(String strVal, PlaceholderResolver placeholderResolver, Set<String> visitedPlaceholders) {
                    return index;
import java.util.Set;
        /**
 *
                    if (placeholderResolver.shouldRemoveMissingPlaceholder(placeholder)) {
        while (startIndex != -1) {
    }
                    }
 * <p>
     */
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
    /**
                }
/*
 * GitHub history for details.
         */
    }
                }
                index++;
 * {@link PlaceholderResolver}.
                    throw new IllegalArgumentException("Circular placeholder reference '" + placeholder + "' in property definitions");
        this.placeholderSuffix = Objects.requireNonNull(placeholderSuffix);
        String resolvePlaceholder(String placeholderName);
    private final String placeholderPrefix;
                String placeholder = buf.substring(startIndex + this.placeholderPrefix.length(), endIndex);
                }
                    placeholder = placeholder.substring(0, defaultValueIdx);
    private final String placeholderSuffix;
 * software distributed under the License is distributed on an
                // Now obtain the value for the fully resolved key...
            }
    }
        int withinNestedPlaceholder = 0;
     * Replaces all placeholders of format <code>${name}</code> with the value returned from the supplied {@link
 *     http://www.apache.org/licenses/LICENSE-2.0
         * Resolves the supplied placeholder name into the replacement value.
 */
}
     *
     * @param placeholderResolver the <code>PlaceholderResolver</code> to use for replacement.
                    // Proceed with unprocessed value.
                index = index + this.placeholderPrefix.length();
 *
 * Values for substitution can be supplied using a {@link Properties} instance or using a
     * @param value               the value containing the placeholders to be replaced.
 * Utility class for working with Strings that have placeholder values in them. A placeholder takes the form
                } else {
        this.placeholderPrefix = Objects.requireNonNull(placeholderPrefix);
        Objects.requireNonNull(value);
 * SPDX-License-Identifier: Apache-2.0
                String propVal = placeholderResolver.resolvePlaceholder(placeholder);
     * PlaceholderResolver}.
 */
                    // previously resolved placeholder value.
    String replacePlaceholders(String value, PlaceholderResolver placeholderResolver) {
import java.util.Properties;
         *
                if (!visitedPlaceholders.add(placeholder)) {
                if (withinNestedPlaceholder > 0) {
                    defaultValue = placeholder.substring(defaultValueIdx + 1);
                        return strVal;
/*
        }
 * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
                }
 */
class PropertyPlaceholder {
            if (endIndex != -1) {
                } else {
            if (Strings.substringMatch(buf, index, this.placeholderSuffix)) {
    PropertyPlaceholder(String placeholderPrefix, String placeholderSuffix, boolean ignoreUnresolvablePlaceholders) {
     *
        /**
     * @return the supplied value with placeholders replaced inline.
 * user-supplied values.
            }
    }
 *
                    buf.replace(startIndex, endIndex + this.placeholderSuffix.length(), propVal);
                String defaultValue = null;
                } else if (this.ignoreUnresolvablePlaceholders) {
            } else if (Strings.substringMatch(buf, index, this.placeholderPrefix)) {
     * @param placeholderSuffix              the suffix that denotes the end of a placeholder.
         * Allows for special handling for ignored missing placeholders that may be resolved elsewhere
     * @see PropertyPlaceholder
 * this file be licensed under the Apache-2.0 license or a
        boolean shouldRemoveMissingPlaceholder(String placeholderName);
        return buf.toString();
            } else {
 */
        int index = startIndex + this.placeholderPrefix.length();
 * under the License.
                    withinNestedPlaceholder--;
        return -1;
 * KIND, either express or implied.  See the License for the
                withinNestedPlaceholder++;
