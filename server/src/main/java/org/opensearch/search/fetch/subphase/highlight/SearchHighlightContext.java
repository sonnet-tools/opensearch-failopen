        public String[] postTags() {  
                return this;  
                    fieldOptions.forceSource = globalOptions.forceSource;
            return options;  
                if (fieldOptions.fragmenter == null) {  
            }
 * The OpenSearch Contributors require contributions made to  
            Builder scoreOrdered(boolean scoreOrdered) {
        private final String field;  
            }  
     * @opensearch.api
                }
        private Boolean scoreOrdered;
        private int noMatchSize = -1;
                }
            }
    public Collection<Field> fields() {
 * ownership. Elasticsearch licenses this file to you under  
            Builder requireFieldMatch(boolean requireFieldMatch) {
        return _field == null ? false : _field.fieldOptions.forceSource;
    /**
                    fieldOptions.boundaryChars = Arrays.copyOf(globalOptions.boundaryChars, globalOptions.boundaryChars.length);
        this(fields, false);
        assert fields != null;
                if (fieldOptions.maxAnalyzerOffset == null) {  
    /**
                }
        }  
                return this;
            return matchedFields;
        this.fields = new LinkedHashMap<>(fields.size());  
        private int fragmentCharSize = -1;
        }  
        public int noMatchSize() {
            Builder matchedFields(Set<String> matchedFields) {  
            return true;
            }
        }
            return maxAnalyzerOffset;
            return encoder;
                fieldOptions.maxAnalyzerOffset = maxAnalyzerOffset;
        public String encoder() {
                    fieldOptions.boundaryMaxScan = globalOptions.boundaryMaxScan;
            Builder preTags(String[] preTags) {  
/*  
            }  
                return this;  
                    fieldOptions.requireFieldMatch = globalOptions.requireFieldMatch;
        }
        Field _field = fields.get(field.field);
import java.util.Map;
                }
                }
            }  
                if (fieldOptions.fragmentCharSize == -1) {  
 * @opensearch.api
                fieldOptions.options = options;  
            }
        public Map<String, Object> options() {
import java.util.Collection;  
        }  
        private Boolean highlightFilter;  
            return field;
                if (fieldOptions.highlighterType == null) {  
    private final Map<String, Field> fields;  
     * Field options for the search highlight context
        }
                return this;
 */
        public Query highlightQuery() {
        private int numberOfFragments = -1;  
                if (fieldOptions.scoreOrdered == null) {  
    }
                fieldOptions.boundaryMaxScan = boundaryMaxScan;
package org.opensearch.search.fetch.subphase.highlight;
                if ((fieldOptions.options == null || fieldOptions.options.size() == 0) && globalOptions.options != null) {  
    public SearchHighlightContext(Collection<Field> fields) {  
                return this;
        public int fragmentOffset() {  
                    fieldOptions.preTags = Arrays.copyOf(globalOptions.preTags, globalOptions.preTags.length);
        public Integer maxAnalyzerOffset() {  
            return boundaryScannerLocale;
     * Field for the search highlight context  
            return numberOfFragments;  
            assert field != null;
        }
                    fieldOptions.highlightQuery = globalOptions.highlightQuery;
                }
        private Set<String> matchedFields;
                }
                fieldOptions.highlighterType = type;
            return fieldOptions;  
import org.apache.lucene.search.Query;
            }
        public int phraseLimit() {  
        }  
                    fieldOptions.encoder = globalOptions.encoder;
 * not use this file except in compliance with the License.
                }
            Builder highlightQuery(Query highlightQuery) {  
 * license agreements. See the NOTICE file distributed with
                }
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.BoundaryScannerType;  
            }
                if (fieldOptions.boundaryScannerLocale == null) {  
        // Field options that default to null or -1 are often set to their real default in HighlighterParseElement#parse  
                return this;
                if (maxAnalyzerOffset != null && maxAnalyzerOffset <= 0) {
    @PublicApi(since = "1.0.0")
import java.util.LinkedHashMap;
                if (fieldOptions.boundaryChars == null && globalOptions.boundaryChars != null) {  
        public Boolean requireFieldMatch() {  
                return this;  
        }  
            this.fieldOptions = fieldOptions;
}
 * Search context used during highlighting phase
                fieldOptions.noMatchSize = noMatchSize;  
                return this;
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        Field(String field, FieldOptions fieldOptions) {  
        private Map<String, Object> options;  
                    fieldOptions.fragmentCharSize = globalOptions.fragmentCharSize;
        }
                fieldOptions.requireFieldMatch = requireFieldMatch;  
     */
        public FieldOptions fieldOptions() {
        }
@PublicApi(since = "1.0.0")  
            }
                    fieldOptions.highlightFilter = globalOptions.highlightFilter;
            }
        public Locale boundaryScannerLocale() {  
            return highlightQuery;
            Builder boundaryScannerType(BoundaryScannerType boundaryScanner) {
                // throws an execption if the value is not a positive integer
            }
                fieldOptions.postTags = postTags;  
                if (fieldOptions.highlightFilter == null) {  
                return this;
                }
        }
                if (fieldOptions.numberOfFragments == -1) {  
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
/**
            return boundaryChars;  
            Builder boundaryMaxScan(int boundaryMaxScan) {  
            return requireFieldMatch;
        private Integer maxAnalyzerOffset = null;
 * software distributed under the License is distributed on an
                    fieldOptions.boundaryScannerType = globalOptions.boundaryScannerType;
            Builder forceSource(boolean forceSource) {  
 * KIND, either express or implied.  See the License for the
        }
        if (globalForceSource) {  
            return boundaryScannerType;
        private Boolean requireFieldMatch;
            Builder boundaryScannerLocale(Locale boundaryScannerLocale) {
                }
        private String fragmenter;
            return fragmenter;  
                if (fieldOptions.preTags == null && globalOptions.preTags != null) {  
 * Modifications Copyright OpenSearch Contributors. See
                fieldOptions.boundaryChars = boundaryChars;  
            }
            return phraseLimit;
                    fieldOptions.noMatchSize = globalOptions.noMatchSize;
            Builder encoder(String encoder) {
                fieldOptions.boundaryScannerType = boundaryScanner;
            return highlighterType;
                    fieldOptions.maxAnalyzerOffset = globalOptions.maxAnalyzerOffset;
        public int fragmentCharSize() {
            }
                fieldOptions.numberOfFragments = numberOfFragments;
        private String encoder;
                if (fieldOptions.noMatchSize == -1) {  
                return this;
            }
        private int fragmentOffset = -1;
        private Character[] boundaryChars = null;
 *
                return this;
     */  
            FieldOptions build() {
import java.util.Arrays;
                fieldOptions.fragmentOffset = fragmentOffset;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                fieldOptions.highlightQuery = highlightQuery;
 * under the License.  
                return this;
            return noMatchSize;  
                    throw new IllegalArgumentException("the value [" + maxAnalyzerOffset + "] of max_analyzer_offset is invalid");  
        }
            Builder boundaryChars(Character[] boundaryChars) {
            return postTags;
                if (fieldOptions.forceSource == null) {  
            Builder maxAnalyzerOffset(Integer maxAnalyzerOffset) {  
            return fragmentCharSize;
        private String highlighterType;
            Builder highlighterType(String type) {
        }
        for (Field field : fields) {
        public int boundaryMaxScan() {
/*  
            Builder fragmenter(String fragmenter) {
                if (fieldOptions.boundaryScannerType == null) {  
        public String highlighterType() {
                }
        private BoundaryScannerType boundaryScannerType;
                }
        private Locale boundaryScannerLocale;
            }
        private Query highlightQuery;  
                fieldOptions.matchedFields = matchedFields;
        private int phraseLimit = -1;
    }  
                }
    }  
                }
                    fieldOptions.options = new HashMap<>(globalOptions.options);
 */
            this.field = field;  
    public static class FieldOptions {
        }
        }
                }
                return this;
     *  
                fieldOptions.boundaryScannerLocale = boundaryScannerLocale;
    public boolean forceSource(Field field) {
    }
        private String[] preTags;  
 * SPDX-License-Identifier: Apache-2.0
                fieldOptions.scoreOrdered = scoreOrdered;
import java.util.Set;
            Builder fragmentCharSize(int fragmentCharSize) {
                fieldOptions.highlightFilter = highlightFilter;
                return this;
        public Boolean scoreOrdered() {
                }
            return highlightFilter;  
 * You may obtain a copy of the License at  
            }  
            Builder fragmentOffset(int fragmentOffset) {
            Builder noMatchSize(int noMatchSize) {
            }  
                    fieldOptions.numberOfFragments = globalOptions.numberOfFragments;
                fieldOptions.fragmentCharSize = fragmentCharSize;
            }  
                return this;  
 *  
import org.opensearch.common.annotation.PublicApi;
public class SearchHighlightContext {
        }
            Builder phraseLimit(int phraseLimit) {
    }  
    public SearchHighlightContext(Collection<Field> fields, boolean globalForceSource) {
        private Boolean forceSource;  
            assert fieldOptions != null;
        }  
                fieldOptions.forceSource = forceSource;
                fieldOptions.fragmenter = fragmenter;  
 * compatible open source license.
                return this;  
                return this;  
            Builder highlightFilter(boolean highlightFilter) {  
    @PublicApi(since = "1.0.0")  
            }
import java.util.HashMap;
            }  
                return this;  
            Builder options(Map<String, Object> options) {
        }
import java.util.Locale;  
        public Character[] boundaryChars() {
                if (fieldOptions.requireFieldMatch == null) {  
                    fieldOptions.scoreOrdered = globalOptions.scoreOrdered;
                    fieldOptions.fragmenter = globalOptions.fragmenter;
        return fields.values();
            Builder merge(FieldOptions globalOptions) {
                fieldOptions.encoder = encoder;
        public String fragmenter() {
        public Set<String> matchedFields() {
                if (fieldOptions.highlightQuery == null && globalOptions.highlightQuery != null) {  
 *  
                return this;  
 */  
        private final FieldOptions fieldOptions;
            Builder postTags(String[] postTags) {
                if (fieldOptions.boundaryMaxScan == -1) {  
                fieldOptions.phraseLimit = phraseLimit;
                    fieldOptions.highlighterType = globalOptions.highlighterType;
 * specific language governing permissions and limitations
            return fragmentOffset;
        private int boundaryMaxScan = -1;  
 * Licensed to Elasticsearch under one or more contributor  
        }
        }  
                }
        public int numberOfFragments() {
        }
        static class Builder {  
                    fieldOptions.postTags = Arrays.copyOf(globalOptions.postTags, globalOptions.postTags.length);
        }
            return boundaryMaxScan;
                if (fieldOptions.encoder == null) {  
                return this;  
     * @opensearch.api
        }
        public String[] preTags() {
                if (fieldOptions.postTags == null && globalOptions.postTags != null) {  
        public String field() {
 * GitHub history for details.
        public Boolean highlightFilter() {
            Builder numberOfFragments(int numberOfFragments) {  
            this.fields.put(field.field, field);
                }
                return this;
            return scoreOrdered;
    }
                return fieldOptions;
        public BoundaryScannerType boundaryScannerType() {  
                fieldOptions.preTags = preTags;
            }
    private final boolean globalForceSource;
        }  
 *
            return preTags;  
/*
                return this;
                }
        this.globalForceSource = globalForceSource;
 */  
            }
                return this;
                    fieldOptions.phraseLimit = globalOptions.phraseLimit;
                    fieldOptions.boundaryScannerLocale = globalOptions.boundaryScannerLocale;
                if (fieldOptions.phraseLimit == -1) {  
    public static class Field {
     *
 * this work for additional information regarding copyright
            private final FieldOptions fieldOptions = new FieldOptions();
        }  
 * Unless required by applicable law or agreed to in writing,
        private String[] postTags;
