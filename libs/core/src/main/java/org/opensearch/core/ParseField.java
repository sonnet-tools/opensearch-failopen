    private final String[] deprecatedNames;
     */
    public String getAllReplacedWith() {
     * @param parserName
     * @return All names for this field regardless of whether they are
        }
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See  
    private final String name;
     * Return a new ParseField where all field names are deprecated and replaced
            final HashSet<String> set = new HashSet<>();
        public static final ParseField FIELD = new ParseField("field");
        if (fullyDeprecated == false && allReplacedWith == null && fieldName.equals(name)) {  
        public static final ParseField TIME_ZONE = new ParseField("time_zone");  
    private static final String[] EMPTY = new String[0];
 * variants, which may be deprecated.  
            Collections.addAll(set, deprecatedNames);
    }
    @Override  
        // the parse field is entirely deprecated (allReplacedWith != null) all
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
     * @return the message to use if this {@link ParseField} has been entirely  
     */  
    public ParseField withDeprecation(String... deprecatedNames) {  
     *            the XContentLocation of the field
     * @param deprecationHandler called if {@code fieldName} is deprecated  
    /**
    }  
                }
        }
        public static final ParseField MISSING = new ParseField("missing");
     * @return true if <code>fieldName</code> matches any of the acceptable
    }  
     *
import org.opensearch.core.xcontent.DeprecationHandler;
        return deprecatedNames;
    public ParseField withAllDeprecated() {
     * @param fieldName
     * Does {@code fieldName} match this field?  
        return false;  
package org.opensearch.core;
    /**
 * KIND, either express or implied.  See the License for the
     *         names for this {@link ParseField}.
        this.name = name;  
import java.util.function.Supplier;
     * @return an array of the names for the {@link ParseField} which are
                    deprecationHandler.usedDeprecatedName(parserName, location, fieldName, name);
/**
     */
     */  
 * Holds a field that can be found in a request while parsing and its different
        parseField.allReplacedWith = allReplacedWith;
    public String[] getDeprecatedNames() {
            }
     */
        } else {  
     *            the name of the parent object holding this field
     * @param deprecatedNames  
 * this work for additional information regarding copyright
 * @opensearch.api
     * @param fieldName
import java.util.Collections;
            if (fieldName.equals(depName)) {
                return true;  
    /**  
import java.util.Set;
                    deprecationHandler.usedDeprecatedField(parserName, location, fieldName, allReplacedWith);
     *            the primary name for this field. This will be returned by
 * GitHub history for details.
     */
    public String getPreferredName() {
        // if this parse field has not been completely deprecated then try to
 * license agreements. See the NOTICE file distributed with
     *            accepted when strict matching is used.  
    public String[] getAllNamesIncludedDeprecated() {
    }
    }
            this.deprecatedNames = set.toArray(new String[0]);  
     *            deprecated names to include with the returned
        return parseField;
     * Does {@code fieldName} match this field?  
    }
 */
        // match the preferred name
    public ParseField withAllDeprecated(String allReplacedWith) {
     */
     * Return a new ParseField where all field names are deprecated with no replacement  
@PublicApi(since = "1.0.0")
        parseField.fullyDeprecated = true;
    public String toString() {
     *         deprecated in favor of something else. This method will return
                if (fullyDeprecated) {
     */  
        public static final ParseField FORMAT = new ParseField("format");
    public static class CommonFields {
 *
                } else {  
        allNames.add(name);  
        // fields will be in the deprecatedNames array
     *         but with the specified deprecated names
 *  
    /**
     */
     *         <code>null</code> if the ParseField has not been completely
        for (String depName : deprecatedNames) {  
import org.opensearch.common.annotation.PublicApi;  
    /**
 * software distributed under the License is distributed on an
/*
    private boolean fullyDeprecated = false;
    }  
     * Common fields shared throughout the project  
     * @return the preferred name used for this field  
 * this file be licensed under the Apache-2.0 license or a
    private String allReplacedWith = null;  
     * @param deprecationHandler called if {@code fieldName} is deprecated
        Objects.requireNonNull(fieldName, "fieldName cannot be null");  
     *            {@link ParseField}
        return new ParseField(this.name, deprecatedNames);
 * You may obtain a copy of the License at  
        if (deprecatedNames == null || deprecatedNames.length == 0) {
     *         deprecated.  
     *            names for this field which are deprecated and will not be
 *
        return parseField;
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 */  
        Collections.addAll(allNames, this.deprecatedNames);
     **/  
    }  
    }
 *
 * SPDX-License-Identifier: Apache-2.0
/*
     *            the field name to match against this {@link ParseField}  
 * Unless required by applicable law or agreed to in writing,
public class ParseField {  
import java.util.Objects;  
    }  
                } else if (allReplacedWith == null) {
    /**  
    }  
        return allReplacedWith;  
        return match(null, () -> XContentLocation.UNKNOWN, fieldName, deprecationHandler);
 * compatible open source license.
import org.opensearch.core.xcontent.XContentLocation;
     *         deprecated.
    public boolean match(String fieldName, DeprecationHandler deprecationHandler) {
        public static final ParseField _META = new ParseField("_meta");
        }
        return allNames;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
import java.util.HashSet;
        ParseField parseField = this.withDeprecation(getAllNamesIncludedDeprecated());  
     *         deprecated
 */
            return true;
     * @param name
    /**
 * not use this file except in compliance with the License.
     */
    /**  
        return getPreferredName();
        public static final ParseField FIELDS = new ParseField("fields");  
     * @opensearch.internal
        Set<String> allNames = new HashSet<>();
     * @return true if <code>fieldName</code> matches any of the acceptable
/*  
    private final String[] allNames;
        return name;  
     * @param deprecatedNames
        // Now try to match against one of the deprecated names. Note that if  
    public ParseField(String name, String... deprecatedNames) {
}  
        ParseField parseField = this.withDeprecation(getAllNamesIncludedDeprecated());  
    /**
            this.deprecatedNames = EMPTY;
 *  
                    deprecationHandler.usedDeprecatedField(parserName, location, fieldName);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param location  
    }  
     *            {@link #getPreferredName()}  
    public boolean match(String parserName, Supplier<XContentLocation> location, String fieldName, DeprecationHandler deprecationHandler) {
        this.allNames = allNames.toArray(new String[0]);
     *            the field name to match against this {@link ParseField}
    /**
 */
     *         names for this {@link ParseField}.  
    /**
     * @return a new {@link ParseField} using the preferred name from this one  
     * with {@code allReplacedWith}.  
