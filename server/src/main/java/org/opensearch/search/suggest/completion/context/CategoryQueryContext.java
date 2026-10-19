            try {
        /**  
 *
 */
/*  
            || token == XContentParser.Token.VALUE_BOOLEAN
     */  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
                throw new IllegalArgumentException("boost must be greater than 0");
import org.opensearch.core.xcontent.XContentBuilder;
                CATEGORY_PARSER.parse(parser, builder, null);  
            Objects.requireNonNull(category, "category must not be null");
        Builder builder = builder();  
        builder.field(CONTEXT_VALUE, category);
    }  
    }
    }
         * Sets the query-time boost of the context.
        return builder;  
        result = 31 * result + (isPrefix ? 1 : 0);
 * software distributed under the License is distributed on an
     * Returns the query-time boost of the context  
    /**  
    }
        private int boost = 1;
 * Defines the query context for {@link CategoryContextMapping}
import org.opensearch.core.xcontent.ObjectParser;
    /**
        if (o == null || getClass() != o.getClass()) return false;
            if (boost <= 0) {  
        this.boost = boost;
     */
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
/*
 * You may obtain a copy of the License at  
    public static CategoryQueryContext fromXContent(XContentParser parser) throws IOException {
            return this;
    public int getBoost() {
        return category;
    public static class Builder {
            this.isPrefix = prefix;  
    }  
 *
            }
import java.util.Objects;  
         * Sets the category of the category.
        XContentParser.Token token = parser.currentToken();
        this.isPrefix = isPrefix;  
    public boolean isPrefix() {
            }
    @Override
     */
            return this;
    public static final String NAME = "category";  
            } catch (XContentParseException e) {
 * KIND, either express or implied.  See the License for the
        }
            return new CategoryQueryContext(category, boost, isPrefix);  
 * ownership. Elasticsearch licenses this file to you under  
        public Builder() {}
 * license agreements. See the NOTICE file distributed with
 */  
    }
import static org.opensearch.search.suggest.completion.context.CategoryContextMapping.CONTEXT_VALUE;
            Objects.requireNonNull(category, "category must not be null");
            Builder::setCategory,
        builder.field(CONTEXT_BOOST, boost);  
    static {
    }
            this.boost = boost;  
import static org.opensearch.search.suggest.completion.context.CategoryContextMapping.CONTEXT_PREFIX;  
         */  
    @Override
        private boolean isPrefix = false;
    }  
 * Unless required by applicable law or agreed to in writing,
        );
        return category != null ? category.equals(that.category) : that.category == null;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.core.ParseField;
    private CategoryQueryContext(String category, int boost, boolean isPrefix) {  
        if (isPrefix != that.isPrefix) return false;
     *
 *
        /**
                throw new XContentParseException("category context must be an object, string, number or boolean");  
        if (this == o) return true;  
        builder.startObject();
        result = 31 * result + boost;  
     * Returns if the context should be treated as a prefix
        } else if (token == XContentParser.Token.VALUE_STRING
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else {
     * Builder for the category query context
         * Defaults to 1.  
    public boolean equals(Object o) {
     */
    public int hashCode() {  
    public static Builder builder() {  
        }
        public Builder setBoost(int boost) {
     * Returns the category of the context
        private String category;  
        builder.field(CONTEXT_PREFIX, isPrefix);
    }
        return boost;  
            || token == XContentParser.Token.VALUE_NUMBER) {  
import org.opensearch.core.xcontent.XContentParseException;
import static org.opensearch.search.suggest.completion.context.CategoryContextMapping.CONTEXT_BOOST;
        public Builder setCategory(String category) {
}  
        public Builder setPrefix(boolean prefix) {
        return isPrefix;
 */
        if (token == XContentParser.Token.START_OBJECT) {
 * Licensed to Elasticsearch under one or more contributor  
    private final int boost;
        }
 */  
            new ParseField(CONTEXT_VALUE),  
         */
            ObjectParser.ValueType.VALUE
        CATEGORY_PARSER.declareInt(Builder::setBoost, new ParseField(CONTEXT_BOOST));  
 * under the License.  
    private static final ObjectParser<Builder, Void> CATEGORY_PARSER = new ObjectParser<>(NAME);
    }
        if (boost != that.boost) return false;  
        return builder.build();
    public String getCategory() {  
        CategoryQueryContext that = (CategoryQueryContext) o;  
     * @opensearch.internal  
            XContentParser::text,
                throw new XContentParseException("category context must be a string, number or boolean");
 * this work for additional information regarding copyright
    /**  
                builder.setCategory(parser.text());
/**  
        builder.endObject();
public final class CategoryQueryContext implements ToXContentObject {
 * compatible open source license.
 * not use this file except in compliance with the License.
         * This is a required field
         * Sets if the context should be treated as a prefix or not.
            }  
        CATEGORY_PARSER.declareField(  
 *  
        CATEGORY_PARSER.declareBoolean(Builder::setPrefix, new ParseField(CONTEXT_PREFIX));
         * Defaults to false  
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
        int result = category != null ? category.hashCode() : 0;
        }
            return this;
        this.category = category;
    private final String category;
        return new Builder();
            this.category = category;  
        public CategoryQueryContext build() {
        return result;
    private final boolean isPrefix;  
    /**
         */
 * GitHub history for details.
/*  
        /**
import java.io.IOException;
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentParser;  
package org.opensearch.search.suggest.completion.context;
import org.opensearch.core.xcontent.ToXContentObject;  
