            Builder options(Map<String, Object> options) {
                if (fieldOptions.boundaryChars == null && globalOptions.boundaryChars != null) {
                return this;
                return this;
            }
        this(fields, false);
                    fieldOptions.highlightFilter = globalOptions.highlightFilter;
                    fieldOptions.numberOfFragments = globalOptions.numberOfFragments;
    private final Map<String, Field> fields;
                fieldOptions.postTags = postTags;
            return highlightFilter;
                }
                    fieldOptions.fragmentCharSize = globalOptions.fragmentCharSize;
            }
        }
            return numberOfFragments;
 * software distributed under the License is distributed on an
                fieldOptions.fragmentCharSize = fragmentCharSize;
                fieldOptions.boundaryMaxScan = boundaryMaxScan;
                }
        }
            return boundaryMaxScan;
/**
        }
        }
                if (fieldOptions.postTags == null && globalOptions.postTags != null) {
                fieldOptions.highlightFilter = highlightFilter;
            }
            return boundaryScannerLocale;
    @PublicApi(since = "1.0.0")
                if (fieldOptions.requireFieldMatch == null) {
                }
                if (fieldOptions.boundaryScannerType == null) {
                if (fieldOptions.highlightFilter == null) {
            Builder fragmentOffset(int fragmentOffset) {
 */
            Builder highlightFilter(boolean highlightFilter) {
        }
 * under the License.
        public Boolean highlightFilter() {
            }
            Builder boundaryScannerType(BoundaryScannerType boundaryScanner) {
                if (fieldOptions.preTags == null && globalOptions.preTags != null) {
                if (fieldOptions.boundaryScannerLocale == null) {
            return options;
import java.util.Set;
        private String encoder;
                return this;
                fieldOptions.encoder = encoder;
        }
        public BoundaryScannerType boundaryScannerType() {
        }
    public static class Field {
            Builder boundaryScannerLocale(Locale boundaryScannerLocale) {
            }
                }
                    fieldOptions.scoreOrdered = globalOptions.scoreOrdered;
        Field(String field, FieldOptions fieldOptions) {
                if (fieldOptions.fragmenter == null) {
                return this;
        public Map<String, Object> options() {
        }
            return highlightQuery;
                fieldOptions.boundaryChars = boundaryChars;
 * GitHub history for details.
 * compatible open source license.
                }
                    fieldOptions.options = new HashMap<>(globalOptions.options);
                fieldOptions.fragmenter = fragmenter;
                return this;
 */
                fieldOptions.options = options;
                if (fieldOptions.fragmentCharSize == -1) {
            }
        private BoundaryScannerType boundaryScannerType;
                    fieldOptions.requireFieldMatch = globalOptions.requireFieldMatch;
    }
                if (fieldOptions.highlightQuery == null && globalOptions.highlightQuery != null) {
        }
                    throw new IllegalArgumentException("the value [" + maxAnalyzerOffset + "] of max_analyzer_offset is invalid");
        private int fragmentOffset = -1;
                if (fieldOptions.encoder == null) {
        }
            return phraseLimit;
            }
        public int phraseLimit() {
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.Query;
            return fragmentOffset;
        private String[] postTags;
 */
        private int noMatchSize = -1;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        private final String field;
                }
                }
 *
            Builder preTags(String[] preTags) {
                fieldOptions.boundaryScannerLocale = boundaryScannerLocale;
                if (fieldOptions.noMatchSize == -1) {
    @PublicApi(since = "1.0.0")
                return this;
        }
        }
        public String field() {
                return fieldOptions;
                }
/*
        return fields.values();
import java.util.Arrays;
     * @opensearch.api
        private Set<String> matchedFields;
                    fieldOptions.highlightQuery = globalOptions.highlightQuery;
        private Boolean forceSource;
    }
            }
                fieldOptions.maxAnalyzerOffset = maxAnalyzerOffset;
        }
                }
                }
                if (fieldOptions.maxAnalyzerOffset == null) {
                if (fieldOptions.forceSource == null) {
                    fieldOptions.boundaryChars = Arrays.copyOf(globalOptions.boundaryChars, globalOptions.boundaryChars.length);
            }
     */
            return true;
                fieldOptions.requireFieldMatch = requireFieldMatch;
            assert field != null;
            return fragmenter;
                return this;
            return boundaryChars;
        private int fragmentCharSize = -1;
            return postTags;
                return this;
    }
            Builder highlightQuery(Query highlightQuery) {
        private int boundaryMaxScan = -1;
                fieldOptions.boundaryScannerType = boundaryScanner;
                if ((fieldOptions.options == null || fieldOptions.options.size() == 0) && globalOptions.options != null) {
                }
                    fieldOptions.boundaryScannerType = globalOptions.boundaryScannerType;
                }
            }
        return _field == null ? false : _field.fieldOptions.forceSource;
            Builder highlighterType(String type) {
        private Boolean requireFieldMatch;
        }
            Builder boundaryMaxScan(int boundaryMaxScan) {
                fieldOptions.numberOfFragments = numberOfFragments;
 */
            }
    public boolean forceSource(Field field) {
        private Map<String, Object> options;
        private String[] preTags;
                }
        }
                    fieldOptions.boundaryScannerLocale = globalOptions.boundaryScannerLocale;
            }
                    fieldOptions.maxAnalyzerOffset = globalOptions.maxAnalyzerOffset;
            return fieldOptions;
import java.util.Locale;
    public SearchHighlightContext(Collection<Field> fields, boolean globalForceSource) {
    /**
            Builder scoreOrdered(boolean scoreOrdered) {
        private Locale boundaryScannerLocale;
        private final FieldOptions fieldOptions;
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                return this;
 * Unless required by applicable law or agreed to in writing,
                return this;
        public int boundaryMaxScan() {
            FieldOptions build() {
            return maxAnalyzerOffset;
                return this;
            this.fields.put(field.field, field);
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.BoundaryScannerType;
                return this;
                return this;
    public static class FieldOptions {
    }
                return this;
                }
        public String[] postTags() {
                if (fieldOptions.scoreOrdered == null) {
import java.util.Collection;
            Builder maxAnalyzerOffset(Integer maxAnalyzerOffset) {
     * Field for the search highlight context
                if (maxAnalyzerOffset != null && maxAnalyzerOffset <= 0) {
        if (globalForceSource) {
import java.util.HashMap;
            return field;
     *
                fieldOptions.matchedFields = matchedFields;
     *
    /**
                }
            }
            Builder phraseLimit(int phraseLimit) {
        public Character[] boundaryChars() {
                return this;
package org.opensearch.search.fetch.subphase.highlight;
        this.fields = new LinkedHashMap<>(fields.size());
            }
                fieldOptions.fragmentOffset = fragmentOffset;
/*
@PublicApi(since = "1.0.0")
            Builder boundaryChars(Character[] boundaryChars) {
            return matchedFields;
            Builder postTags(String[] postTags) {
 * the Apache License, Version 2.0 (the "License"); you may
        private Boolean highlightFilter;
    }
            return encoder;
            Builder noMatchSize(int noMatchSize) {
        }
 *
                }
            return requireFieldMatch;
            this.field = field;
 * You may obtain a copy of the License at
 * this work for additional information regarding copyright
        public String fragmenter() {
        }
            }
            Builder matchedFields(Set<String> matchedFields) {
 * KIND, either express or implied.  See the License for the
            }
            Builder fragmenter(String fragmenter) {
        private Query highlightQuery;
    public SearchHighlightContext(Collection<Field> fields) {
 * Modifications Copyright OpenSearch Contributors. See
        public int fragmentOffset() {
        public FieldOptions fieldOptions() {
            Builder forceSource(boolean forceSource) {
        private String highlighterType;
        }
                }
        private int phraseLimit = -1;
import java.util.LinkedHashMap;
 * Licensed to Elasticsearch under one or more contributor
        public String encoder() {
 * @opensearch.api
                    fieldOptions.highlighterType = globalOptions.highlighterType;
        public String[] preTags() {
            return highlighterType;
 * SPDX-License-Identifier: Apache-2.0
            Builder fragmentCharSize(int fragmentCharSize) {
        private String fragmenter;
                if (fieldOptions.numberOfFragments == -1) {
 * not use this file except in compliance with the License.
 * Search context used during highlighting phase
 * ownership. Elasticsearch licenses this file to you under
        }
        assert fields != null;
        private Integer maxAnalyzerOffset = null;
     * @opensearch.api
                    fieldOptions.encoder = globalOptions.encoder;
}
                    fieldOptions.fragmenter = globalOptions.fragmenter;
        }
            assert fieldOptions != null;
                fieldOptions.noMatchSize = noMatchSize;
                    fieldOptions.forceSource = globalOptions.forceSource;
                fieldOptions.highlightQuery = highlightQuery;
        }
        this.globalForceSource = globalForceSource;
    }
                return this;
            }
public class SearchHighlightContext {
    public Collection<Field> fields() {
            return preTags;
                    fieldOptions.boundaryMaxScan = globalOptions.boundaryMaxScan;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
                }
                if (fieldOptions.highlighterType == null) {
            private final FieldOptions fieldOptions = new FieldOptions();
            }
                }
            }
                }
            return boundaryScannerType;
                fieldOptions.forceSource = forceSource;
            }
        }
                    fieldOptions.preTags = Arrays.copyOf(globalOptions.preTags, globalOptions.preTags.length);
            return scoreOrdered;
        // Field options that default to null or -1 are often set to their real default in HighlighterParseElement#parse
            }
        Field _field = fields.get(field.field);
                return this;
 *
        }
            }
                fieldOptions.highlighterType = type;
     * Field options for the search highlight context
                    fieldOptions.noMatchSize = globalOptions.noMatchSize;
 * specific language governing permissions and limitations
        public String highlighterType() {
        private int numberOfFragments = -1;
                return this;
            Builder merge(FieldOptions globalOptions) {
                    fieldOptions.phraseLimit = globalOptions.phraseLimit;
            return noMatchSize;
                fieldOptions.scoreOrdered = scoreOrdered;
                fieldOptions.preTags = preTags;
        public Set<String> matchedFields() {
            Builder encoder(String encoder) {
        public Locale boundaryScannerLocale() {
        private Boolean scoreOrdered;
        public int fragmentCharSize() {
                if (fieldOptions.boundaryMaxScan == -1) {
            Builder requireFieldMatch(boolean requireFieldMatch) {
 * The OpenSearch Contributors require contributions made to
/*
                    fieldOptions.postTags = Arrays.copyOf(globalOptions.postTags, globalOptions.postTags.length);
        static class Builder {
                return this;
        public int noMatchSize() {
        private Character[] boundaryChars = null;
        }
        }
        public int numberOfFragments() {
        }
    private final boolean globalForceSource;
                return this;
        public Boolean scoreOrdered() {
            Builder numberOfFragments(int numberOfFragments) {
                }
 *
                if (fieldOptions.phraseLimit == -1) {
                return this;
        public Integer maxAnalyzerOffset() {
            this.fieldOptions = fieldOptions;
        public Query highlightQuery() {
     */
        for (Field field : fields) {
                return this;
                // throws an execption if the value is not a positive integer
                return this;
        public Boolean requireFieldMatch() {
                fieldOptions.phraseLimit = phraseLimit;
            return fragmentCharSize;
            }
import org.opensearch.common.annotation.PublicApi;
        }
