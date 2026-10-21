    private String analyzer;
        this.normalizer = null;
    public static CustomAnalyzerBuilder buildCustomNormalizer(String index) {
    }
    /**
     */
        }
import org.opensearch.common.settings.Settings;
    }
            return builder;
     * Analyzes text using a custom analyzer built from components defined on an index
                return builder.value(name);
    }
        }
    public static CustomAnalyzerBuilder buildCustomNormalizer() {
 * the Apache License, Version 2.0 (the "License"); you may
    public static AnalyzeRequest withNormalizer(String index, String normalizer, String... text) {
    public String index() {
        CustomAnalyzerBuilder(String index, NameOrDefinition tokenizer) {
        String... text
 * A request to analyze text
 * software distributed under the License is distributed on an
            builder.endObject();
     * Analyzes text using a custom normalizer built from components defined on an index
     * Analyzes text using a custom analyzer built from components defined on an index
/**
        return this.field;
    public static CustomAnalyzerBuilder buildCustomAnalyzer(Map<String, Object> tokenizerSettings) {
            return this;
        return new AnalyzeRequest(null, analyzer, null, null, text);
        }
 * Licensed to Elasticsearch under one or more contributor
        return new CustomAnalyzerBuilder(null, new NameOrDefinition(tokenizer));
        List<NameOrDefinition> tokenFilters,
    @Override
            builder.field("analyzer", analyzer);
        return new CustomAnalyzerBuilder(null, new NameOrDefinition(tokenizerSettings));
    public static class CustomAnalyzerBuilder {
 * this work for additional information regarding copyright
    static class NameOrDefinition implements ToXContentFragment {
     */
 * Unless required by applicable law or agreed to in writing,
        if (attributes == null) {
            return this;
 * under the License.
    public static AnalyzeRequest withField(String index, String field, String... text) {
/*
        public CustomAnalyzerBuilder addCharFilter(String name) {
        return this.analyzer;
    /**
    }
        final NameOrDefinition tokenizer;
    public AnalyzeRequest explain(boolean explain) {
     * Analyzes text using a global analyzer
    /**
            this.index = index;
 * Modifications Copyright OpenSearch Contributors. See
            this.tokenizer = tokenizer;
     * Analyzes text using the analyzer defined on a specific field within an index
    }
            this.name = null;
        }
            builder.field("attributes", attributes);
     * Returns the custom token filters used for analysis, if defined
    }
            this.name = null;
    /**
    private NameOrDefinition tokenizer;
import java.io.IOException;
            this.definition = Objects.requireNonNull(settings);
    }
        this.analyzer = null;
 */
     * Analyzes text using a custom normalizer built from global components
    public String[] text() {
     */
 * not use this file except in compliance with the License.
     */
 * ownership. Elasticsearch licenses this file to you under
        }
            this.name = Objects.requireNonNull(name);
    public String analyzer() {
    public static CustomAnalyzerBuilder buildCustomAnalyzer(String tokenizer) {
    public String field() {
    ) {
    }
        public CustomAnalyzerBuilder addCharFilter(Map<String, Object> settings) {
    public String[] attributes() {
            builder.field("tokenizer", tokenizer);
    public AnalyzeRequest attributes(String... attributes) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
        if (explain) {
        if (attributes.length > 0) {
    public String normalizer() {
import org.opensearch.core.xcontent.XContentBuilder;
        return this.explain;
    public static CustomAnalyzerBuilder buildCustomAnalyzer(String index, String tokenizer) {
        }
        }
        }
    /**
     * Analyzes text using a named analyzer on an index
 * license agreements. See the NOTICE file distributed with
    /**
     * Analyzes text using a custom analyzer built from global components
     */
    /**
        if (charFilters.size() > 0) {
    }
     * Returns the named tokenizer used for analysis, if defined
        if (tokenizer != null) {
        // exactly one of these two members is not null
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
    private AnalyzeRequest(
        NameOrDefinition(Settings settings) {
 * specific language governing permissions and limitations
        }
    private final List<NameOrDefinition> charFilters = new ArrayList<>();
        return this.charFilters;
    public NameOrDefinition tokenizer() {
        }
        builder.startObject();
import org.opensearch.client.Validatable;
     * Analyzes text using a custom analyzer built from global components
     */
 * You may obtain a copy of the License at
import org.opensearch.core.xcontent.ToXContentObject;
    }
    }
        return new AnalyzeRequest(index, null, null, field, text);
    private final List<NameOrDefinition> tokenFilters = new ArrayList<>();
        return builder.endObject();
        return this.index;
            return new AnalyzeRequest(index, tokenizer, charFilters, tokenFilters, text);
            charFilters.add(new NameOrDefinition(name));
        this.field = field;
    }
 * GitHub history for details.
     */
     */
    /**
        }
    }
        public final Settings definition;
    /**
    }
        this.analyzer = analyzer;
    public static AnalyzeRequest withGlobalAnalyzer(String analyzer, String... text) {
import java.util.Objects;
import org.opensearch.core.xcontent.ToXContentFragment;
    }
        this.charFilters.addAll(charFilters);
     */
            builder.field("normalizer", normalizer);
        }
import org.opensearch.core.common.Strings;
        String index,
    private String field;
import java.util.List;
package org.opensearch.client.indices;
        NameOrDefinition tokenizer,
    private String[] attributes = Strings.EMPTY_ARRAY;
}
        List<NameOrDefinition> charFilters = new ArrayList<>();
        return this.normalizer;
     * Set whether or not detailed explanations of analysis should be returned
     * Returns the text to be analyzed
        }
        return new CustomAnalyzerBuilder(null, null);
        if (Strings.isNullOrEmpty(analyzer) == false) {
/*
        if (tokenFilters.size() > 0) {
 */
        this.index = index;
        return new CustomAnalyzerBuilder(index, null);
        this.tokenizer = tokenizer;
            builder.field("explain", true);
     */
     */
        }
     * Returns the named analyzer used for analysis, if defined
    /**
            return this;
        this.attributes = attributes;
        }
     */
        return this.tokenizer;
     */
        return new AnalyzeRequest(index, null, normalizer, null, text);
     * Returns the index that the request should be executed against, or {@code null} if
    private boolean explain = false;
            builder.field("char_filter", charFilters);
    }
        final String index;
    public static AnalyzeRequest withIndexAnalyzer(String index, String analyzer, String... text) {
        this.text = text;
 * SPDX-License-Identifier: Apache-2.0
    }
        List<NameOrDefinition> charFilters,
        return this.text;
            return this;
            this.definition = Settings.builder().loadFromMap(definition).build();
     */
            definition.toXContent(builder, params);
    /**
    public static CustomAnalyzerBuilder buildCustomAnalyzer(String index, Map<String, Object> tokenizerSettings) {
     */
    public List<NameOrDefinition> tokenFilters() {
            throw new IllegalArgumentException("attributes must not be null");
        public AnalyzeRequest build(String... text) {
            builder.field("field", field);
     */
    public boolean explain() {
        NameOrDefinition(String name) {
     */
        public final String name;
 * compatible open source license.
    /**
        public CustomAnalyzerBuilder addTokenFilter(String name) {
        return new AnalyzeRequest(index, analyzer, null, null, text);
 */
        if (Strings.isNullOrEmpty(normalizer) == false) {
     * Helper class to build custom analyzer definitions
     * Analyzes text using a named normalizer on an index
        }
     * no index is specified
    }
            Objects.requireNonNull(definition);
import java.util.Map;
        NameOrDefinition(Map<String, ?> definition) {
        return this;
     */
            builder.field("filter", tokenFilters);
        if (Strings.isNullOrEmpty(field) == false) {
        return new CustomAnalyzerBuilder(index, new NameOrDefinition(tokenizerSettings));
    /**
        return this;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return new CustomAnalyzerBuilder(index, new NameOrDefinition(tokenizer));
    /**
        List<NameOrDefinition> tokenFilters = new ArrayList<>();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
    public List<NameOrDefinition> charFilters() {
    }
import java.util.ArrayList;
 *
        this.text = text;
        return this.tokenFilters;
    }
    }
     * Returns the field to take an Analyzer from, if defined
    private String normalizer;
    /**
            builder.startObject();
    }
    }
     */
        }
        this.normalizer = normalizer;
 *    http://www.apache.org/licenses/LICENSE-2.0
            tokenFilters.add(new NameOrDefinition(name));
    private String index;
    /**
     * Returns the custom character filters used for analysis, if defined
    }
        }
    private String[] text;
            }
            tokenFilters.add(new NameOrDefinition(settings));
    /**
     * Returns a custom Tokenizer used for analysis, if defined
    /**
        this.index = index;
        public CustomAnalyzerBuilder addTokenFilter(Map<String, Object> settings) {
            this.definition = null;
    /**
            if (definition == null) {
 *
        return this.attributes;
 * The OpenSearch Contributors require contributions made to
            charFilters.add(new NameOrDefinition(settings));
        builder.field("text", text);
     */
    /**
    private AnalyzeRequest(String index, String analyzer, String normalizer, String field, String... text) {
/*
public class AnalyzeRequest implements Validatable, ToXContentObject {
        this.field = null;
 *
        this.explain = explain;
        this.tokenFilters.addAll(tokenFilters);
        @Override
    }
        }
