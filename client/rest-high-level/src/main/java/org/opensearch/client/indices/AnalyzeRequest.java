    }
 * KIND, either express or implied.  See the License for the
        }
            builder.field("char_filter", charFilters);  
    }
        final NameOrDefinition tokenizer;  
        return new AnalyzeRequest(index, null, null, field, text);
        }  
        }
 */
     * Analyzes text using a custom analyzer built from global components  
 * ownership. Elasticsearch licenses this file to you under  
        return this.attributes;
     * Set whether or not detailed explanations of analysis should be returned
    /**  
     * no index is specified  
    /**
    }
    /**  
    public AnalyzeRequest attributes(String... attributes) {
            builder.field("explain", true);  
    /**
    private NameOrDefinition tokenizer;
 * You may obtain a copy of the License at  
        builder.startObject();  
     */  
    /**
 * this work for additional information regarding copyright
    /**
 * software distributed under the License is distributed on an
        return new AnalyzeRequest(index, null, normalizer, null, text);
        public final String name;
        return this;  
            this.index = index;
     * Returns the field to take an Analyzer from, if defined
    private boolean explain = false;  
    public AnalyzeRequest explain(boolean explain) {
import java.util.List;
/*  
        }
    public String analyzer() {
        return new CustomAnalyzerBuilder(index, null);
     */
    }
        }
        // exactly one of these two members is not null
            this.name = null;
     * Analyzes text using a custom normalizer built from global components  
    private String[] text;  
    }
        if (Strings.isNullOrEmpty(normalizer) == false) {
        return this.tokenFilters;
        this.field = field;  
        this.attributes = attributes;
            builder.field("analyzer", analyzer);  
        }
            definition.toXContent(builder, params);  
        @Override  
        NameOrDefinition(Map<String, ?> definition) {  
    }  
     * Returns the text to be analyzed
 * GitHub history for details.
     * Helper class to build custom analyzer definitions
            return this;
    }  
     * Analyzes text using a named analyzer on an index  
        }
    }
     */
        public CustomAnalyzerBuilder addCharFilter(Map<String, Object> settings) {  
     * Returns the named tokenizer used for analysis, if defined  
    }
        return this.text;
    public String[] text() {  
        this.text = text;  
    public NameOrDefinition tokenizer() {  
import org.opensearch.core.xcontent.ToXContentFragment;
        this.charFilters.addAll(charFilters);
     * Analyzes text using a custom normalizer built from components defined on an index
    }
 * SPDX-License-Identifier: Apache-2.0
            tokenFilters.add(new NameOrDefinition(name));  
     */
        NameOrDefinition tokenizer,  
        return new CustomAnalyzerBuilder(null, null);  
        return this;  
        return this.tokenizer;
            if (definition == null) {
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
            builder.field("filter", tokenFilters);  
        }
     */  
    }
import java.util.Map;
        this.index = index;  
        return new CustomAnalyzerBuilder(null, new NameOrDefinition(tokenizer));
        }  
    static class NameOrDefinition implements ToXContentFragment {  
    private String[] attributes = Strings.EMPTY_ARRAY;
        List<NameOrDefinition> charFilters = new ArrayList<>();
    public static AnalyzeRequest withField(String index, String field, String... text) {  
        final String index;
        if (attributes == null) {
    /**
    public static CustomAnalyzerBuilder buildCustomAnalyzer(String index, String tokenizer) {  
     * Analyzes text using a custom analyzer built from components defined on an index
     */
     * Returns the custom token filters used for analysis, if defined
            charFilters.add(new NameOrDefinition(settings));
            builder.field("field", field);  
    /**
    }  
}
        builder.field("text", text);
        List<NameOrDefinition> tokenFilters = new ArrayList<>();  
    }
        return this.analyzer;
            this.definition = Settings.builder().loadFromMap(definition).build();  
     */  
        if (Strings.isNullOrEmpty(field) == false) {
    }
        this.analyzer = null;  
    }
        return this.normalizer;  
 */
    public String index() {
    private String normalizer;
            builder.field("normalizer", normalizer);  
    }
            Objects.requireNonNull(definition);
     */  
                return builder.value(name);  
     * Analyzes text using a custom analyzer built from global components
    }
        }
            builder.field("attributes", attributes);  
    private String field;
    /**  
    /**
 *
import org.opensearch.core.common.Strings;  
        }
     */
     */
    public String[] attributes() {  
        if (charFilters.size() > 0) {
        this.explain = explain;
    public static CustomAnalyzerBuilder buildCustomNormalizer(String index) {  
        String... text  
        if (explain) {
/*
        List<NameOrDefinition> charFilters,
            builder.field("tokenizer", tokenizer);  
    /**
        public CustomAnalyzerBuilder addTokenFilter(Map<String, Object> settings) {
            this.definition = Objects.requireNonNull(settings);  
        return new CustomAnalyzerBuilder(null, new NameOrDefinition(tokenizerSettings));  
    /**
import org.opensearch.common.settings.Settings;
    }
    public static CustomAnalyzerBuilder buildCustomAnalyzer(String index, Map<String, Object> tokenizerSettings) {
    public List<NameOrDefinition> tokenFilters() {
 *  
        this.normalizer = normalizer;
     * Analyzes text using the analyzer defined on a specific field within an index
            return builder;
 */  
     * Returns the index that the request should be executed against, or {@code null} if
    public static AnalyzeRequest withIndexAnalyzer(String index, String analyzer, String... text) {
     * Analyzes text using a custom analyzer built from components defined on an index
package org.opensearch.client.indices;
import java.io.IOException;
import org.opensearch.client.Validatable;
            tokenFilters.add(new NameOrDefinition(settings));
    public String field() {  
        }
     * Analyzes text using a named normalizer on an index
        if (tokenFilters.size() > 0) {
        this.tokenizer = tokenizer;  
        if (attributes.length > 0) {
    /**
     */  
        return this.charFilters;  
     * Returns the named analyzer used for analysis, if defined
 * compatible open source license.
        this.analyzer = analyzer;
    }  
        List<NameOrDefinition> tokenFilters,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.tokenizer = tokenizer;  
 * Modifications Copyright OpenSearch Contributors. See
            this.name = Objects.requireNonNull(name);  
     */  
            charFilters.add(new NameOrDefinition(name));
        return builder.endObject();
        NameOrDefinition(Settings settings) {
 */  
    }
    }  
            return this;  
    /**  
        if (tokenizer != null) {
    }
     */
     */
    }
            builder.endObject();
import org.opensearch.core.xcontent.XContentBuilder;  
     * Returns the custom character filters used for analysis, if defined  
 * Unless required by applicable law or agreed to in writing,
    public static class CustomAnalyzerBuilder {
        public final Settings definition;  
        return this.explain;
    public static CustomAnalyzerBuilder buildCustomAnalyzer(String tokenizer) {
            return this;  
    /**
            return this;
        return new AnalyzeRequest(null, analyzer, null, null, text);
import java.util.ArrayList;  
     */  
    public boolean explain() {  
public class AnalyzeRequest implements Validatable, ToXContentObject {
    private final List<NameOrDefinition> charFilters = new ArrayList<>();
    }
        return new AnalyzeRequest(index, analyzer, null, null, text);  
     */
    ) {
        this.field = null;
    }  
    /**
 * A request to analyze text  
import java.util.Objects;  
    public static CustomAnalyzerBuilder buildCustomNormalizer() {
            return new AnalyzeRequest(index, tokenizer, charFilters, tokenFilters, text);
     */
            builder.startObject();
        this.tokenFilters.addAll(tokenFilters);
        }
import org.opensearch.core.xcontent.ToXContentObject;
        return this.index;  
 *
    public static AnalyzeRequest withGlobalAnalyzer(String analyzer, String... text) {  
    private AnalyzeRequest(
            throw new IllegalArgumentException("attributes must not be null");  
 * not use this file except in compliance with the License.
        }
    private AnalyzeRequest(String index, String analyzer, String normalizer, String field, String... text) {
        NameOrDefinition(String name) {
        }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        return new CustomAnalyzerBuilder(index, new NameOrDefinition(tokenizerSettings));
        this.text = text;
        String index,
        }
 * this file be licensed under the Apache-2.0 license or a
    public String normalizer() {
    private String analyzer;
     * Analyzes text using a global analyzer
 * license agreements. See the NOTICE file distributed with
    public static CustomAnalyzerBuilder buildCustomAnalyzer(Map<String, Object> tokenizerSettings) {
     */
    public static AnalyzeRequest withNormalizer(String index, String normalizer, String... text) {
    public List<NameOrDefinition> charFilters() {
    /**  
    private final List<NameOrDefinition> tokenFilters = new ArrayList<>();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
 * specific language governing permissions and limitations
    private String index;
        public CustomAnalyzerBuilder addCharFilter(String name) {
        this.normalizer = null;
        return this.field;
    }  
        public AnalyzeRequest build(String... text) {  
        public CustomAnalyzerBuilder addTokenFilter(String name) {
/**
     */
            this.definition = null;
        this.index = index;
            this.name = null;
        if (Strings.isNullOrEmpty(analyzer) == false) {
        return new CustomAnalyzerBuilder(index, new NameOrDefinition(tokenizer));
    @Override
 * The OpenSearch Contributors require contributions made to  
     */
        }
     * Returns a custom Tokenizer used for analysis, if defined
            }
/*  
    /**  
        CustomAnalyzerBuilder(String index, NameOrDefinition tokenizer) {
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
