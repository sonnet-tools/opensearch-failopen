@PublicApi(since = "1.0.0")
            final HashSet<String> set = new HashSet<>();
 * variants, which may be deprecated.
     */
     *
    }
    /**
        this.allNames = allNames.toArray(new String[0]);
    /**
 * this work for additional information regarding copyright
        return name;
 * Licensed to Elasticsearch under one or more contributor
        public static final ParseField FIELD = new ParseField("field");
    private String allReplacedWith = null;
    }
        return false;
     * Does {@code fieldName} match this field?
     * @return true if <code>fieldName</code> matches any of the acceptable
 *
    /**
 * GitHub history for details.
        // fields will be in the deprecatedNames array
    /**
    }
    public String getPreferredName() {
     */
     *         names for this {@link ParseField}.
    /**
    }
import org.opensearch.core.xcontent.XContentLocation;
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
            this.deprecatedNames = EMPTY;
 * not use this file except in compliance with the License.
 *
     * @param deprecationHandler called if {@code fieldName} is deprecated
     * @param parserName
     *            names for this field which are deprecated and will not be
 *
     * Common fields shared throughout the project
 * You may obtain a copy of the License at
    /**
    public boolean match(String fieldName, DeprecationHandler deprecationHandler) {
    /**
        public static final ParseField MISSING = new ParseField("missing");
    /**
        for (String depName : deprecatedNames) {
     * @param deprecatedNames
import org.opensearch.core.xcontent.DeprecationHandler;
     *         names for this {@link ParseField}.
 *
     */
    public String[] getDeprecatedNames() {
 * ownership. Elasticsearch licenses this file to you under
 * license agreements. See the NOTICE file distributed with
     * with {@code allReplacedWith}.
        public static final ParseField TIME_ZONE = new ParseField("time_zone");
     *         deprecated in favor of something else. This method will return
/**
     */
     * @return a new {@link ParseField} using the preferred name from this one
    public ParseField withDeprecation(String... deprecatedNames) {
        Collections.addAll(allNames, this.deprecatedNames);
     */
    }
    public String getAllReplacedWith() {
    private static final String[] EMPTY = new String[0];
 */
     *            the field name to match against this {@link ParseField}
 * The OpenSearch Contributors require contributions made to
        public static final ParseField FIELDS = new ParseField("fields");
 */
        return deprecatedNames;
package org.opensearch.core;
            this.deprecatedNames = set.toArray(new String[0]);
        // if this parse field has not been completely deprecated then try to
 * Holds a field that can be found in a request while parsing and its different
     */
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        return allReplacedWith;
public class ParseField {
                return true;
     * @param fieldName
        // Now try to match against one of the deprecated names. Note that if
import java.util.function.Supplier;
     *         deprecated
 * compatible open source license.
     *         deprecated.
     * @param name
     * @return true if <code>fieldName</code> matches any of the acceptable
            if (fieldName.equals(depName)) {
    }
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
     *            the primary name for this field. This will be returned by
                    deprecationHandler.usedDeprecatedName(parserName, location, fieldName, name);
                } else if (allReplacedWith == null) {
     *         <code>null</code> if the ParseField has not been completely
        ParseField parseField = this.withDeprecation(getAllNamesIncludedDeprecated());
     *         but with the specified deprecated names
        if (deprecatedNames == null || deprecatedNames.length == 0) {
        }
    /**
        this.name = name;
                } else {
import org.opensearch.common.annotation.PublicApi;
    public static class CommonFields {
import java.util.Objects;
        return new ParseField(this.name, deprecatedNames);
     */
    /**
     * @return an array of the names for the {@link ParseField} which are
        return getPreferredName();
import java.util.HashSet;
        if (fullyDeprecated == false && allReplacedWith == null && fieldName.equals(name)) {
            }
     * @param fieldName
/*
    @Override
import java.util.Collections;
 */
/*
     *            {@link ParseField}
        public static final ParseField FORMAT = new ParseField("format");
        return parseField;
    public ParseField withAllDeprecated(String allReplacedWith) {
 * this file be licensed under the Apache-2.0 license or a
        }
 * specific language governing permissions and limitations
     * @param deprecatedNames
     *            the XContentLocation of the field
     *            accepted when strict matching is used.
            Collections.addAll(set, deprecatedNames);
    private final String[] allNames;
    }
        return match(null, () -> XContentLocation.UNKNOWN, fieldName, deprecationHandler);
     * @return the preferred name used for this field
                }
     *         deprecated.
     * @param location
     */
        Set<String> allNames = new HashSet<>();
        // the parse field is entirely deprecated (allReplacedWith != null) all
     * Return a new ParseField where all field names are deprecated and replaced
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final String name;
                if (fullyDeprecated) {
    public String toString() {
        }
     */
 * @opensearch.api
    }
    private final String[] deprecatedNames;
     *            the name of the parent object holding this field
     * Return a new ParseField where all field names are deprecated with no replacement
    public ParseField(String name, String... deprecatedNames) {
    public ParseField withAllDeprecated() {
 */
                    deprecationHandler.usedDeprecatedField(parserName, location, fieldName, allReplacedWith);
    public boolean match(String parserName, Supplier<XContentLocation> location, String fieldName, DeprecationHandler deprecationHandler) {
        parseField.fullyDeprecated = true;
        public static final ParseField _META = new ParseField("_meta");
     *            deprecated names to include with the returned
     */
    /**
        parseField.allReplacedWith = allReplacedWith;
     * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @return the message to use if this {@link ParseField} has been entirely
        allNames.add(name);
 * under the License.
        return parseField;
                    deprecationHandler.usedDeprecatedField(parserName, location, fieldName);
 *
    }
     *            {@link #getPreferredName()}
        } else {
     * @return All names for this field regardless of whether they are
    private boolean fullyDeprecated = false;
        ParseField parseField = this.withDeprecation(getAllNamesIncludedDeprecated());
     **/
            return true;
        Objects.requireNonNull(fieldName, "fieldName cannot be null");
import java.util.Set;
    }
/*
 * the Apache License, Version 2.0 (the "License"); you may
     * Does {@code fieldName} match this field?
     * @param deprecationHandler called if {@code fieldName} is deprecated
    public String[] getAllNamesIncludedDeprecated() {
     *            the field name to match against this {@link ParseField}
        // match the preferred name
}
        return allNames;
