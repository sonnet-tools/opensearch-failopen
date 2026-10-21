    public abstract Set<String> parseContext(ParseContext parseContext, XContentParser parser) throws IOException, OpenSearchParseException;
            if (boost != that.boost) return false;
                queryContexts.add(fromXContent(parser));
 * not use this file except in compliance with the License.
        return name;
    }
    protected abstract XContentBuilder toInnerXContent(XContentBuilder builder, Params params) throws IOException;
        if (this == o) return true;
import org.opensearch.core.xcontent.ToXContentFragment;
package org.opensearch.search.suggest.completion.context;
import org.opensearch.core.xcontent.XContentBuilder;
    /**
import org.opensearch.core.xcontent.ToXContent;
     *
                throw new IllegalArgumentException("No context type for [" + type + "]");
    protected abstract T fromXContent(XContentParser context) throws IOException;
        }
    }
     * @opensearch.internal
        return builder;
        }
     * The internal query context
     */
            if (o == null || getClass() != o.getClass()) return false;
     */
/*
        public String toString() {
            }
import java.util.Set;
import org.opensearch.OpenSearchParseException;
        List<T> queryContexts = new ArrayList<>();
        public boolean equals(Object o) {
            } else {
            } else if (type.equalsIgnoreCase("geo")) {
    /**
    protected ContextMapping(Type type, String name) {
            if (this == o) return true;
        public InternalQueryContext(String context, int boost, boolean isPrefix) {
        // No validation is required by default
import java.util.List;
     */
    /**
 * this file be licensed under the Apache-2.0 license or a
            if (isPrefix != that.isPrefix) return false;
 */
    }
    public enum Type {
    public void validateReferences(Version indexVersionCreated, Function<String, MappedFieldType> fieldResolver) {
     * Parses a set of index-time contexts.
            InternalQueryContext that = (InternalQueryContext) o;
    /**
     * Retrieves a set of context from a <code>document</code> at index-time.
            return result;
 * <p>
    }
    public Type type() {
}
 * the Apache License, Version 2.0 (the "License"); you may
            return context != null ? context.equals(that.context) : that.context == null;
            result = 31 * result + boost;
        return toInternalQueryContexts(queryContexts);
     */
        }
        } else {
import org.opensearch.core.xcontent.XContentParser.Token;
    /**
    public boolean equals(Object o) {
    /**
/*
        return type;
 * software distributed under the License is distributed on an
/**
        ContextMapping<?> that = (ContextMapping<?>) o;
        CATEGORY,
            this.boost = boost;
 *
     * Prototype for the query context
import org.opensearch.common.xcontent.json.JsonXContent;
    public static final String FIELD_NAME = "name";
import org.opensearch.index.mapper.ParseContext;
    }
     * Checks if the current context is consistent with the rest of the fields. For example, the GeoContext
                return CATEGORY;
            return super.toString();
        @Override
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected final String name;
    /**
    }
            return toXContent(JsonXContent.contentBuilder(), ToXContent.EMPTY_PARAMS).toString();
 * KIND, either express or implied.  See the License for the
import java.util.function.Function;
     */
 * Implementations have to define how contexts are parsed at query/index time
 * specific language governing permissions and limitations
 */
 * license agreements. See the NOTICE file distributed with
     * @opensearch.internal
        public static Type fromString(String type) {
            this.isPrefix = isPrefix;
 */
 * A {@link ContextMapping} defines criteria that can be used to
        }
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (o == null || getClass() != o.getClass()) return false;
        }
            return "QueryContext{" + "context='" + context + '\'' + ", boost=" + boost + ", isPrefix=" + isPrefix + '}';
    /**
    }
        GEO;
import org.opensearch.index.mapper.CompletionFieldMapper;
import java.util.Objects;
        public final String context;
     * Type of context mapping
            if (type.equalsIgnoreCase("category")) {
                return GEO;
 */
    protected abstract List<InternalQueryContext> toInternalQueryContexts(List<T> queryContexts);
        toInnerXContent(builder, params);
    /**
            int result = context != null ? context.hashCode() : 0;
        }
 * Unless required by applicable law or agreed to in writing,
    }
        @Override
     */
     */
     *
            this.context = context;
/*
     */
        public final int boost;
 *
 * GitHub history for details.
    @Override
     * Define a new context mapping of a specific type
    /**
        Token token = parser.nextToken();
     * should check that the field that it points to has the correct type.
        return Objects.hash(type, name);
     */
     * @return the name/id of the context
import java.util.ArrayList;
        this.type = type;
 * You may obtain a copy of the License at
        public final boolean isPrefix;
    public int hashCode() {
        @Override
 *
        public int hashCode() {
    public static final String FIELD_TYPE = "type";
     */
    @Override
 * ownership. Elasticsearch licenses this file to you under
public abstract class ContextMapping<T extends ToXContent> implements ToXContentFragment {
    }
 * this work for additional information regarding copyright
    /**
 * Licensed to Elasticsearch under one or more contributor
 * filter and/or boost suggestions at query time for {@link CompletionFieldMapper}.
    protected abstract Set<String> parseContext(ParseContext.Document document);
        } catch (IOException e) {
        if (token == Token.START_ARRAY) {
        if (type != that.type) return false;
     * @param name name of context mapping
     *
 * @opensearch.internal
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    public static class InternalQueryContext {
        }
 * compatible open source license.
    public final List<InternalQueryContext> parseQueryContext(XContentParser parser) throws IOException, OpenSearchParseException {
        builder.field(FIELD_NAME, name);
import org.opensearch.index.mapper.MappedFieldType;
     * Implementations should add specific configurations
    public String name() {
    }
     */
     */
        builder.field(FIELD_TYPE, type.name());
        this.name = name;
        try {
 * under the License.
     * @return the type name of the context
     * that need to be persisted
            while (parser.nextToken() != Token.END_ARRAY) {
    }
    @Override
        return name.equals(that.name);
import java.io.IOException;
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.Version;
    /**
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.xcontent.XContentParser;
            result = 31 * result + (isPrefix ? 1 : 0);
            }
     * Convert query contexts to common representation
     * Parses query contexts for this mapper
    public String toString() {
            queryContexts.add(fromXContent(parser));
     * @param type type of context mapping, either {@link Type#CATEGORY} or {@link Type#GEO}
    protected final Type type;
