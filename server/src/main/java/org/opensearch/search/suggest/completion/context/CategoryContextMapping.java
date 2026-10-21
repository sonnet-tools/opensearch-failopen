     * from a map.
                        "Failed to parse context field [" + fieldName + "], only keyword and text fields are accepted"
 * software distributed under the License is distributed on an
     */
 */
        @Override
 *
    @Override
        return builder;
            );
 * this work for additional information regarding copyright
                } else if (field.stringValue() != null) {
        super(Type.CATEGORY, name);
}
import org.apache.lucene.document.SortedSetDocValuesField;
/**
            for (IndexableField field : fields) {
        Object fieldName = config.get(FIELD_FIELDNAME);
        if (o == null || getClass() != o.getClass()) return false;
        );
            mapping.field(fieldName.toString());
import org.opensearch.core.xcontent.XContentParser;
    protected CategoryQueryContext fromXContent(XContentParser parser) throws IOException {
import java.io.IOException;
    public String getFieldName() {
        if (fieldName != null) {
     *     <li>Object: CategoryQueryContext</li>
     * Name of the field to get contexts from at index-time
import org.opensearch.core.xcontent.XContentParser.Token;
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    values.add(field.stringValue());
 *
    public List<InternalQueryContext> toInternalQueryContexts(List<CategoryQueryContext> queryContexts) {
 * specific language governing permissions and limitations
            contexts.add(parser.text());
            }
     * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
     * Builder for {@link CategoryContextMapping}
        List<InternalQueryContext> internalInternalQueryContexts = new ArrayList<>(queryContexts.size());
            config.remove(FIELD_FIELDNAME);
        internalInternalQueryContexts.addAll(
        CategoryContextMapping.Builder mapping = new CategoryContextMapping.Builder(name);
        return (values == null) ? Collections.emptySet() : values;
     * Parse a set of {@link CharSequence} contexts at index-time.
        } else {
    protected XContentBuilder toInnerXContent(XContentBuilder builder, Params params) throws IOException {
    /**
        return CategoryQueryContext.fromXContent(parser);
    static final String CONTEXT_BOOST = "boost";
        if (token == Token.VALUE_STRING || token == Token.VALUE_NUMBER || token == Token.VALUE_BOOLEAN) {
    private static final String FIELD_FIELDNAME = "path";
    }
         */
        /**
 */
     */
            queryContexts.stream()
        if (fieldName != null) {
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal
import java.util.List;
/*
        /**
import org.opensearch.index.mapper.ParseContext;
        private String fieldName;
    /**
            builder.field(FIELD_FIELDNAME, fieldName);
                .collect(Collectors.toList())
        if (this == o) return true;
            while ((token = parser.nextToken()) != Token.END_ARRAY) {
     * Parse a list of {@link CategoryQueryContext}
    private final String fieldName;
     * </ul>
        return !(fieldName != null ? !fieldName.equals(mapping.fieldName) : mapping.fieldName != null);
        } else if (token == Token.START_ARRAY) {
     *
    private CategoryContextMapping(String name, String fieldName) {
import org.apache.lucene.index.IndexableField;
        return mapping.build();
     *
 *
    static final String CONTEXT_PREFIX = "prefix";
 * not use this file except in compliance with the License.
        return Objects.hash(super.hashCode(), fieldName);
                    throw new IllegalArgumentException(
    }
                    );
     *
         * Create a builder for
 * Licensed to Elasticsearch under one or more contributor
     *     <li>Object: <pre>{&quot;context&quot;: <i>&lt;string&gt;</i>, &quot;boost&quot;: <i>&lt;int&gt;</i>, &quot;prefix&quot;:
    public Set<String> parseContext(ParseContext parseContext, XContentParser parser) throws IOException, OpenSearchParseException {
    }
    }
    public boolean equals(Object o) {
     */
         */
     *     <li>Array: <pre>[<i>&lt;string&gt;</i>, ..]</pre></li>
                } else {
 * GitHub history for details.
        Set<String> values = null;
public class CategoryContextMapping extends ContextMapping<CategoryQueryContext> {
     * <ul>
 */
 * ownership. Elasticsearch licenses this file to you under
            throw new OpenSearchParseException(
import java.util.ArrayList;
         * Set the name of the field to use
 * under the License.
     *     <li>String: CategoryQueryContext value with prefix=false and boost=1</li>
     *
                    throw new OpenSearchParseException("context array must have string, number or boolean values, but was [" + token + "]");
            IndexableField[] fields = document.getFields(fieldName);
 * license agreements. See the NOTICE file distributed with
import java.util.Objects;
/*
                }
import java.util.Collections;
    protected static CategoryContextMapping load(String name, Map<String, Object> config) throws OpenSearchParseException {
import org.opensearch.core.xcontent.XContentBuilder;
    }
import org.opensearch.index.mapper.KeywordFieldMapper;
     *     <i>&lt;boolean&gt;</i>}</pre></li>
 * category (string) value.
                    values.add(field.binaryValue().utf8ToString());
    @Override
        return contexts;
     *     <li>String: <pre>&quot;string&quot;</pre></li>
    }
            return new CategoryContextMapping(name, fieldName);
        }
            values = new HashSet<>(fields.length);
 * You may obtain a copy of the License at
    public int hashCode() {
     * using <code>parser</code>. A QueryContexts accepts one of the following forms:
 */
    @Override
        CategoryContextMapping mapping = (CategoryContextMapping) o;
        Token token = parser.currentToken();
     */
 * A {@link ContextMapping} that uses a simple string as a criteria
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.document.StoredField;
/*
     * Acceptable formats:
    @Override
        }
        return internalInternalQueryContexts;
 * a unit of query context for this context type
        }
        public CategoryContextMapping build() {
            return this;
        }
            super(name);
     */
import org.opensearch.Version;
    @Override
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.document.SortedDocValuesField;
 *    http://www.apache.org/licenses/LICENSE-2.0
         * a named {@link CategoryContextMapping}
     *
                } else if (field instanceof KeywordFieldMapper.KeywordField) {
     *  </ul>
    /**
        final Set<String> contexts = new HashSet<>();
        public Builder field(String fieldName) {
        return fieldName;
package org.opensearch.search.suggest.completion.context;
            this.fieldName = fieldName;
import org.opensearch.index.mapper.ParseContext.Document;
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        public Builder(String name) {
     *  <ul>
     *     <li>String: <pre>&quot;string&quot;</pre></li>
    }
                "contexts must be a string, number or boolean or a list of string, number or boolean, but was [" + token + "]"
         * @param name name of the mapping
     * Loads a <code>name</code>d {@link CategoryContextMapping} instance
                .map(queryContext -> new InternalQueryContext(queryContext.getCategory(), queryContext.getBoost(), queryContext.isPrefix()))
 * The suggestions are boosted and/or filtered by their associated
    }
    @Override
        if (fieldName != null) {
    static final String CONTEXT_VALUE = "context";
     *     <li>Array: <pre>[CategoryQueryContext, ..]</pre></li>
        this.fieldName = fieldName;
    /**
    public Set<String> parseContext(Document document) {
import java.util.stream.Collectors;
 * compatible open source license.
        if (!super.equals(o)) return false;
 *
            // TODO we should be checking mapped field types, not lucene field types
import java.util.Map;
import java.util.Set;
    @Override
                }
        }
 * Modifications Copyright OpenSearch Contributors. See
     *  A CategoryQueryContext has one of the following forms:
                if (field instanceof SortedDocValuesField || field instanceof SortedSetDocValuesField || field instanceof StoredField) {
        }
     * Acceptable map param: <code>path</code>
                } else {
    }
import org.opensearch.OpenSearchParseException;
            }
    }
                if (token == Token.VALUE_STRING || token == Token.VALUE_NUMBER || token == Token.VALUE_BOOLEAN) {
     * <code>fieldName</code>
    /**
 * {@link CategoryQueryContext} defines options for constructing
     * see {@link ContextMappings#load(Object, Version)}
        }
    }
import java.util.HashSet;
     */
     * Create a new {@link CategoryContextMapping} with field
    public static class Builder extends ContextBuilder<CategoryContextMapping> {
                    contexts.add(parser.text());
     *  <ul>
     *  </ul>
                    // Ignore doc values and stored fields
