            this.order = order;  
        matches++;  
 * SPDX-License-Identifier: Apache-2.0
    /**
 *  
            case APPEND_WITH_ORDER:
            return values.stream().map(AppendValue::getValue).collect(Collectors.joining(appendSeparator));
package org.opensearch.dissect;
 * the Apache License, Version 2.0 (the "License"); you may
        if (simpleCount > 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
     * Gets all the current matches. Pass the results of this to isValid to determine if a fully successful match has occurred.
            return value;
                break;
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
    private final Map<String, String> results;
    private final String appendSeparator;
     */
            results.putAll(simpleResults);  
                break;
        }  
 *
        results.clear();
        this.maxMatches = maxMatches;  
     */
        @Override
import java.util.ArrayList;
import java.util.Map;
        private String value;
    private int matches = 0;  
 */  
    private int implicitAppendOrder = -1000;  
/*  
     */
        }  
        public int compareTo(AppendValue o) {  
            this.appendSeparator = appendSeparator;
        if (maxMatches <= 0 || maxResults <= 0) {  
        private final String value;
            this.value = value;
        }
            referenceResults.forEach((k, v) -> results.put(v.getKey(), v.getValue()));  
        }
import java.util.List;
    boolean fullyMatched() {  
     * @return the map of the results.
        private String getValue() {  
    private final int referenceCount;
        this.maxResults = maxResults;
        simpleResults = simpleCount <= 0 ? null : new HashMap<>(simpleCount);
            return Integer.compare(this.order, o.getOrder());
            case FIELD_VALUE:  
                break;
            this.value = value;
 * The OpenSearch Contributors require contributions made to  
        }  
    private final class ReferenceResult {
        }
        private void setKey(String key) {
        }
        private final List<AppendValue> values = new ArrayList<>();
    Map<String, String> getResults() {  
final class DissectMatch {
    }
            Collections.sort(values);
    private final int appendCount;  
    }
            appendResults.forEach((k, v) -> results.put(k, v.getAppendResult()));  
     */
    boolean isValid(Map<String, String> results) {  
     * @return true if all dissect keys have been matched and the results are of the expected size.
        this.referenceCount = referenceCount;  
 * this file be licensed under the Apache-2.0 license or a
 * Represents the matches of a {@link DissectParser#parse(String)}. Handles the appending and referencing based on the key instruction.  
 * compatible open source license.
        this.appendSeparator = appendSeparator;
    private final int simpleCount;
            return;
                appendResults.computeIfAbsent(key.getName(), k -> new AppendResult(appendSeparator)).addValue(value, implicitAppendOrder++);  
                break;
    private final class AppendResult {  
    }
     * A result that needs to be converted to a key/value reference  
        return results;  
    private final Map<String, String> simpleResults;  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
                    .addValue(value, key.getAppendPosition());
 * Modifications Copyright OpenSearch Contributors. See
        private String key;
 * this work for additional information regarding copyright
     * An appendable value that can be sorted based on the provided order
 * specific language governing permissions and limitations
import java.util.HashMap;  
        if (referenceCount > 0) {
 * not use this file except in compliance with the License.
        }
 */  
        results = new HashMap<>(maxResults);
                referenceResults.computeIfAbsent(key.getName(), k -> new ReferenceResult()).setKey(value);
        private String getKey() {  
/**
 * software distributed under the License is distributed on an
    private final Map<String, ReferenceResult> referenceResults;
     */
     * Add the key/value that was found as result of the parsing
     * @param value the discovered value for the key  
     * a result that will need to be part of an append operation.
    private final Map<String, AppendResult> appendResults;
     * Checks if results are valid.
        referenceResults = referenceCount <= 0 ? null : new HashMap<>(referenceCount);
        }
/*  
            return value;
        }
            case FIELD_NAME:  
    DissectMatch(String appendSeparator, int maxMatches, int maxResults, int appendCount, int referenceCount) {
        private void addValue(String value, int order) {
            case NONE:
 * under the License.  
            this.key = key;  
            values.add(new AppendValue(value, order));  
    void add(DissectKey key, String value) {
        if (appendCount > 0) {
            return key;
    /**
 */
     */
        if (key.skip()) {
        return fullyMatched() && results.size() == maxResults;
import java.util.stream.Collectors;  
 * ownership. Elasticsearch licenses this file to you under  
                appendResults.computeIfAbsent(key.getName(), k -> new AppendResult(appendSeparator))  
        private AppendResult(String appendSeparator) {
        }  
 * license agreements. See the NOTICE file distributed with
        return matches == maxMatches;
        this.simpleCount = maxMatches - referenceCount - appendCount;  
    }
     * @param key the {@link DissectKey}
    private final int maxResults;
        private AppendValue(String value, int order) {
        private int getOrder() {
    }  
        }  
        }  
    }
        switch (key.getModifier()) {
    /**
    /**  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        private final int order;
    }
            return order;
                break;
    private final class AppendValue implements Comparable<AppendValue> {  
    }
        }
        private void setValue(String value) {
        private String getValue() {
        private String getAppendResult() {  
     *  
        }  
    /**  
     * @param results the results to check  
    private final int maxMatches;
        appendResults = appendCount <= 0 ? null : new HashMap<>(appendCount);  
            case APPEND:
}  
        this.appendCount = appendCount;
 * GitHub history for details.
                simpleResults.put(key.getName(), value);  
        private final String appendSeparator;
            throw new IllegalArgumentException("Expected results are zero, can not construct DissectMatch");// should never happen
    /**  
 */
                referenceResults.computeIfAbsent(key.getName(), k -> new ReferenceResult()).setValue(value);
 *
/*
