import java.util.ArrayList;  
    public static class Builder extends ContextBuilder<CategoryContextMapping> {
     *  
    @Override
    @Override  
                } else {  
     *     <li>Array: <pre>[CategoryQueryContext, ..]</pre></li>
            IndexableField[] fields = document.getFields(fieldName);
     *  <ul>
import org.opensearch.core.xcontent.XContentParser.Token;  
     *
     *     <i>&lt;boolean&gt;</i>}</pre></li>
         */
    private static final String FIELD_FIELDNAME = "path";
     * Parse a list of {@link CategoryQueryContext}
         * a named {@link CategoryContextMapping}
        @Override
                    throw new IllegalArgumentException(
     * Loads a <code>name</code>d {@link CategoryContextMapping} instance  
        internalInternalQueryContexts.addAll(
    @Override
     * <code>fieldName</code>  
        return builder;  
import org.opensearch.OpenSearchParseException;
/*  
            this.fieldName = fieldName;
import java.util.Collections;
            while ((token = parser.nextToken()) != Token.END_ARRAY) {
 * specific language governing permissions and limitations
    public boolean equals(Object o) {
 * Licensed to Elasticsearch under one or more contributor  
 */
            return this;
 * You may obtain a copy of the License at  
                    values.add(field.stringValue());
import org.opensearch.core.xcontent.XContentBuilder;
     * </ul>
        }  
    /**
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.mapper.KeywordFieldMapper;
     * <ul>
    }
/**  
}
import org.apache.lucene.document.SortedSetDocValuesField;
        CategoryContextMapping.Builder mapping = new CategoryContextMapping.Builder(name);
        if (this == o) return true;  
    @Override
            throw new OpenSearchParseException(  
     *     <li>String: <pre>&quot;string&quot;</pre></li>
    static final String CONTEXT_BOOST = "boost";
                if (field instanceof SortedDocValuesField || field instanceof SortedSetDocValuesField || field instanceof StoredField) {  
    }  
import org.opensearch.Version;  
                "contexts must be a string, number or boolean or a list of string, number or boolean, but was [" + token + "]"
 * this file be licensed under the Apache-2.0 license or a
 *
        if (o == null || getClass() != o.getClass()) return false;
        private String fieldName;
    public Set<String> parseContext(Document document) {
import org.opensearch.core.xcontent.XContentParser;
        }
        public Builder field(String fieldName) {  
                } else if (field instanceof KeywordFieldMapper.KeywordField) {
        if (token == Token.VALUE_STRING || token == Token.VALUE_NUMBER || token == Token.VALUE_BOOLEAN) {
import java.util.HashSet;
            }
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
import java.util.List;  
     * Name of the field to get contexts from at index-time
    public int hashCode() {
            );
    /**
     * using <code>parser</code>. A QueryContexts accepts one of the following forms:
import org.opensearch.index.mapper.ParseContext.Document;  
            super(name);  
                    // Ignore doc values and stored fields
        return internalInternalQueryContexts;
            return new CategoryContextMapping(name, fieldName);
import org.apache.lucene.index.IndexableField;
 */  
     *     <li>Array: <pre>[<i>&lt;string&gt;</i>, ..]</pre></li>
import org.apache.lucene.document.SortedDocValuesField;
     */
 * {@link CategoryQueryContext} defines options for constructing
    /**  
        }  
        CategoryContextMapping mapping = (CategoryContextMapping) o;  
    public List<InternalQueryContext> toInternalQueryContexts(List<CategoryQueryContext> queryContexts) {  
    protected XContentBuilder toInnerXContent(XContentBuilder builder, Params params) throws IOException {
        /**  
    }
    /**  
            values = new HashSet<>(fields.length);  
     */
    private CategoryContextMapping(String name, String fieldName) {
     * @opensearch.internal  
        }
         * Create a builder for
     * Builder for {@link CategoryContextMapping}
            builder.field(FIELD_FIELDNAME, fieldName);
                .collect(Collectors.toList())
package org.opensearch.search.suggest.completion.context;
                    throw new OpenSearchParseException("context array must have string, number or boolean values, but was [" + token + "]");
    }
            // TODO we should be checking mapped field types, not lucene field types
 * not use this file except in compliance with the License.
 */  
                .map(queryContext -> new InternalQueryContext(queryContext.getCategory(), queryContext.getBoost(), queryContext.isPrefix()))
            for (IndexableField field : fields) {
 * SPDX-License-Identifier: Apache-2.0
     *     <li>String: <pre>&quot;string&quot;</pre></li>  
    static final String CONTEXT_PREFIX = "prefix";  
 */
import java.util.Map;
 *  
            contexts.add(parser.text());
                }
        if (fieldName != null) {  
     *     <li>String: CategoryQueryContext value with prefix=false and boost=1</li>  
    @Override
 * category (string) value.  
        Object fieldName = config.get(FIELD_FIELDNAME);
        this.fieldName = fieldName;
import org.apache.lucene.document.StoredField;  
        super(Type.CATEGORY, name);  
     *  </ul>
     */
    }
 * @opensearch.internal
        }  
        return mapping.build();
     */  
     */
/*  
        } else if (token == Token.START_ARRAY) {  
        Set<String> values = null;  
                    values.add(field.binaryValue().utf8ToString());  
                }  
        );  
     * Parse a set of {@link CharSequence} contexts at index-time.
        return fieldName;
        } else {
     *  
    }
            config.remove(FIELD_FIELDNAME);
import java.util.Objects;
 * ownership. Elasticsearch licenses this file to you under  
    }
     * Acceptable formats:
            }
         * Set the name of the field to use
     *  
            mapping.field(fieldName.toString());
                        "Failed to parse context field [" + fieldName + "], only keyword and text fields are accepted"
 * The OpenSearch Contributors require contributions made to  
    @Override
        return (values == null) ? Collections.emptySet() : values;
                    contexts.add(parser.text());  
    static final String CONTEXT_VALUE = "context";
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
 *  
    public Set<String> parseContext(ParseContext parseContext, XContentParser parser) throws IOException, OpenSearchParseException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Token token = parser.currentToken();  
            queryContexts.stream()  
     *  <ul>
import java.util.stream.Collectors;
                } else {
 * GitHub history for details.
     *     <li>Object: CategoryQueryContext</li>
    private final String fieldName;
 * compatible open source license.
    }  
     *  
        return !(fieldName != null ? !fieldName.equals(mapping.fieldName) : mapping.fieldName != null);
     *  A CategoryQueryContext has one of the following forms:
         */
    }
 * KIND, either express or implied.  See the License for the
     * Create a new {@link CategoryContextMapping} with field
 * the Apache License, Version 2.0 (the "License"); you may
         * @param name name of the mapping  
    protected CategoryQueryContext fromXContent(XContentParser parser) throws IOException {
    @Override
 * this work for additional information regarding copyright
 * A {@link ContextMapping} that uses a simple string as a criteria
 *
     *     <li>Object: <pre>{&quot;context&quot;: <i>&lt;string&gt;</i>, &quot;boost&quot;: <i>&lt;int&gt;</i>, &quot;prefix&quot;:  
     *  </ul>  
        return contexts;
import java.util.Set;  
     * from a map.
        }  
        if (fieldName != null) {
 * under the License.  
        /**  
     * Acceptable map param: <code>path</code>
        public CategoryContextMapping build() {  
        }
    }
import java.io.IOException;
 * The suggestions are boosted and/or filtered by their associated
        return CategoryQueryContext.fromXContent(parser);  
    public String getFieldName() {
        final Set<String> contexts = new HashSet<>();
    }
        if (!super.equals(o)) return false;
        return Objects.hash(super.hashCode(), fieldName);  
                    );  
                if (token == Token.VALUE_STRING || token == Token.VALUE_NUMBER || token == Token.VALUE_BOOLEAN) {
 * a unit of query context for this context type
        public Builder(String name) {
public class CategoryContextMapping extends ContextMapping<CategoryQueryContext> {  
 * Modifications Copyright OpenSearch Contributors. See
     * see {@link ContextMappings#load(Object, Version)}
    /**  
import org.opensearch.index.mapper.ParseContext;
    /**
                } else if (field.stringValue() != null) {
/*
    protected static CategoryContextMapping load(String name, Map<String, Object> config) throws OpenSearchParseException {  
        if (fieldName != null) {  
        List<InternalQueryContext> internalInternalQueryContexts = new ArrayList<>(queryContexts.size());
