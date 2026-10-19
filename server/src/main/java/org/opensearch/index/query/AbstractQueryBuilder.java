     */
        } else if (obj instanceof BigInteger bigInteger) {
                if (query instanceof MatchNoDocsQuery == false) {
        parser.declareString(QueryBuilder::queryName, AbstractQueryBuilder.NAME_FIELD);
        if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
        String queryName = parser.currentName();
 */
            return bytesRef.utf8ToString();
    static Collection<Query> toQueries(Collection<QueryBuilder> queryBuilders, QueryShardContext context) throws QueryShardException,
    @Override
import java.util.List;
        out.writeFloat(boost);
     */
                contentLocation,
        return filter != null;
        if (this == obj) {
    public final String toString() {
     * if so it converts it to a {@link BytesRef}.
        }
     * While it extracts inner hits, child inner hits are inlined into the inner hit builder they belong to.
    protected AbstractQueryBuilder(StreamInput in) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
                    query = new BoostQuery(query, boost);
    /**
            Query query = queryBuilder.rewrite(context).toQuery(context);
            );
        @SuppressWarnings("unchecked")
        doWriteTo(out);
    }
        builder.endObject();
 * specific language governing permissions and limitations
 * compatible open source license.
        if (validateFilterParams(filter) == false) {
     * should use this method.
            if (query != null) {
    }
    public final QB boost(float boost) {
        }
        // default impl returns the same as writeable name, but we keep the distinction between the two just to make sure
 * under the License.
        return getWriteableName();
 */
    @Override
        return queries;
            throw new ParsingException(parser.getTokenLocation(), "[_na] query malformed, no field after start_object");
     */
        }
/**
 * software distributed under the License is distributed on an
    @Override
    /**
            );
import org.opensearch.core.xcontent.XContentBuilder;
    public final QueryBuilder rewrite(QueryRewriteContext queryShardContext) throws IOException {
    /**
    public static final ParseField BOOST_FIELD = new ParseField("boost");
        checkNegativeBoost(boost);
        if (queryName() != null && rewritten.queryName() == null) { // we inherit the name
                    + queryName
     * @param filter filter to combine with current query builder
                queryName,
 * Base class for all classes producing lucene queries.
 * the Apache License, Version 2.0 (the "License"); you may
        // end_object of the specific query (e.g. match, multi_match etc.) element
    ) {
 * this work for additional information regarding copyright
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
     * Combine filter with current query builder
    public String getName() {
    static Object maybeConvertToString(Object obj) {
import org.opensearch.core.xcontent.AbstractObjectParser;
     */
            }
                    + "] and ["
            return BytesRefs.toBytesRef(stringValue);
    protected final void checkNegativeBoost(float boost) {
            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
    public final Query toQuery(QueryShardContext context) throws IOException {
            rewritten.queryName(queryName());
 * The OpenSearch Contributors require contributions made to
        return this;
     * @return true if parameters are valid. Returns false when the filter is null.
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.MatchNoDocsQuery;
     * {@link MatchAllQueryBuilder} and {@link MatchNoneQueryBuilder} support these fields so they
    /**
        out.writeVInt(queries.size());
    }
            );
import org.opensearch.core.ParseField;
     * @param filter filter to combine with current query builder
        return this.boost;
        }
    protected float boost = DEFAULT_BOOST;
 *
    protected abstract int doHashCode();
        return rewritten;
        List<QueryBuilder> queries = new ArrayList<>(size);
    static List<QueryBuilder> readQueries(StreamInput in) throws IOException {
     * {@link AbstractObjectParser} passed in. All query builders except
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
    protected void printBoostAndQueryName(XContentBuilder builder) throws IOException {
    public final String queryName() {
     * their {@link QueryBuilder#toQuery(QueryShardContext)} method are not added to the
import java.util.Locale;
        IOException {
        }
        }
        out.writeOptionalString(queryName);
    }
        } else if (obj instanceof CharBuffer charBuffer) {
            );
    public static final ParseField NAME_FIELD = new ParseField("_name");
 * SPDX-License-Identifier: Apache-2.0
    public final void writeTo(StreamOutput out) throws IOException {
            return BytesRefs.toBytesRef(bigInteger);
    @Override
        String processedFieldName,
                Locale.ROOT,
        return builder;
    protected static void declareStandardFields(AbstractObjectParser<? extends QueryBuilder, ?> parser) {
        QueryBuilder result;
        boost = in.readFloat();
        // end_object of the query object
        }
        // move to the next START_OBJECT
                "["
        modifiedQB.must(this);
    protected abstract boolean doEquals(QB other);
 *
                    + processedFieldName
        QueryBuilder rewritten = doRewrite(queryShardContext);
    public final QB queryName(String queryName) {
    }
        for (QueryBuilder query : queries) {
        for (int i = 0; i < size; i++) {
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
import org.opensearch.core.common.io.stream.StreamInput;
        checkNegativeBoost(boost);
import org.opensearch.core.common.ParsingException;
            return false;
    }
            throw new IllegalArgumentException(
     * Helper method to convert collection of {@link QueryBuilder} instances to lucene
    /**
            }
 * Unless required by applicable law or agreed to in writing,
                SuggestingErrorOnUnknown.suggest(queryName, e.getCandidates())
     * @return query builder with filter combined
            return new BytesRef(charBuffer);
        modifiedQB.filter(filter);
     * Adds {@code boost} and {@code query_name} parsing to the
        }
    protected AbstractQueryBuilder() {
import java.util.ArrayList;
    @Override
    }
    protected abstract void doXContent(XContentBuilder builder, Params params) throws IOException;
    /**
import java.math.BigInteger;
        if (obj instanceof String stringValue) {
        int size = in.readVInt();
/*
        if (query != null) {
        }
        return obj;
        }
     */
     * For internal usage only!
        } else if (obj instanceof CharBuffer charBuffer) {
    // Like Objects.requireNotNull(...) but instead throws a IllegalArgumentException
import org.opensearch.core.common.Strings;
     * Sets the boost for this query.  Documents matching this query will (in addition to the normal
        return value;
        } catch (NamedObjectNotFoundException e) {
    }
        return queryName;
                "[" + queryName + "] malformed query, expected [END_OBJECT] but found [" + parser.currentToken() + "]"
 * not use this file except in compliance with the License.
    @Override
        }
    public static final float DEFAULT_BOOST = 1.0f;
import java.util.Collection;
import org.opensearch.common.xcontent.SuggestingErrorOnUnknown;
    public final int hashCode() {
        QB other = (QB) obj;
     * Returns the boost for this query.
    }
                parser.getTokenLocation(),
import org.opensearch.common.lucene.BytesRefs;
    }
            throw new ParsingException(
    /**
    }
        if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
 * You may obtain a copy of the License at
                }
            // we encountered '{}' for a query clause, it used to be supported, deprecated in 5.0 and removed in 6.0
    public QueryBuilder filter(QueryBuilder filter) {
    }
/*
        }
            out.writeNamedWriteable(query);
    @Override
 * @opensearch.internal
        String queryName,
        }
    }
        return Objects.hash(getClass(), queryName, boost, doHashCode());
import org.opensearch.core.xcontent.MediaTypeRegistry;
        try {
    }
                "unknown query [%s]%s",
            result = parser.namedObject(QueryBuilder.class, queryName, null);
        }
    /**
 * Supports conversion to BytesReference and creation of lucene Query objects.
import java.nio.CharBuffer;
    }
                "negative [boost] are not allowed in [" + toString() + "], " + "use a value between 0 and 1 to deboost"
     */
        return modifiedQB;
                queries.add(query);
     * if so it converts it to a utf8 string.
    public static boolean validateFilterParams(QueryBuilder filter) {
    /**
        if (rewritten == this) {
            }
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {}
            throw new IllegalArgumentException("query malformed, empty clause found at [" + parser.getTokenLocation() + "]");
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
    }
            }
    protected final QueryValidationException addValidationError(String validationError, QueryValidationException validationException) {
            rewritten.boost(boost());
import org.apache.lucene.util.BytesRef;
        return obj;
    @Override
        final BoolQueryBuilder modifiedQB = new BoolQueryBuilder();
 */
    public final float boost() {
    }
package org.opensearch.index.query;
        if (value == null) {
                "[" + queryName + "] malformed query, expected [END_OBJECT] but found [" + parser.currentToken() + "]"
}
    }
            throw new ParsingException(
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
        if (obj instanceof BytesRef bytesRef) {
    public static QueryBuilder parseInnerQueryBuilder(XContentParser parser) throws IOException {
public abstract class AbstractQueryBuilder<QB extends AbstractQueryBuilder<QB>> implements QueryBuilder {
    @SuppressWarnings("unchecked")
    /**
import org.apache.lucene.search.BoostQuery;
        }
import org.apache.lucene.search.Query;
        return (QB) this;
     */
    @Override
    }
import org.opensearch.core.xcontent.XContentParser;
 *
    }
     */
import java.util.Objects;
        if (queryName != null) {
import org.opensearch.core.xcontent.XContentLocation;
        return (QB) this;
     * Returns the query name for the query.
            throw new IllegalArgumentException(message);
            String message = String.format(
     */
        }
 * license agreements. See the NOTICE file distributed with
    }
     */
    }
     */
    }
            return new BytesRef(charBuffer).utf8ToString();
        }
    @Override
 *
    public static Object maybeConvertToBytesRef(Object obj) {
    @Override
    /**
        return QueryValidationException.addValidationError(getName(), validationError, validationException);
     */
        return result;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            queries.add(in.readNamedWriteable(QueryBuilder.class));
        if (parser.nextToken() == XContentParser.Token.END_OBJECT) {
     * @return the same input object or a utf8 string if input was of type {@link BytesRef} or {@link CharBuffer}
    }
    @SuppressWarnings("unchecked")
     * {@link Query} instances. {@link QueryBuilder} that return {@code null} calling
    protected static void throwParsingExceptionOnMultipleFields(
    }
        }
        List<Query> queries = new ArrayList<>(queryBuilders.size());
        doXContent(builder, params);
     * Indicates whether some other {@link QueryBuilder} object of the same type is "equal to" this one.
import org.opensearch.core.common.io.stream.StreamOutput;
            if (boost != DEFAULT_BOOST) {
            throw new ParsingException(parser.getTokenLocation(), "[" + queryName + "] query malformed, no start_object after query name");
    protected abstract void doWriteTo(StreamOutput out) throws IOException;
        if (processedFieldName != null) {
            return true;
 */
                    + currentFieldName
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
                context.addNamedQuery(queryName, query);
            return this;
     * weightings) have their score multiplied by the boost provided.
        Query query = doToQuery(context);
     * Check the input parameters of filter function.
        return Objects.equals(queryName, other.queryName) && Objects.equals(boost, other.boost) && doEquals(other);
    protected static <T> T requireValue(T value, String message) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**
    }
        if (Float.compare(boost, 0f) < 0) {
        queryName = in.readOptionalString();
                throw new ParsingException(parser.getTokenLocation(), "[_na] query malformed, must start with start_object");
                parser.getTokenLocation(),
     * This helper method checks if the object passed in is a string or {@link CharBuffer},
        builder.field(BOOST_FIELD.getPreferredName(), boost);
     * This helper method checks if the object passed in is a {@link BytesRef} or {@link CharBuffer},
     * @param obj the input object
     * @return the same input object or a {@link BytesRef} representation if input was of type string
import java.util.Map;
 * GitHub history for details.
        this.queryName = queryName;
        builder.startObject();
            throw new ParsingException(
                    + "]"
    static void writeQueries(StreamOutput out, List<? extends QueryBuilder> queries) throws IOException {
                    + "] query doesn't support multiple fields, found ["
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (obj == null || getClass() != obj.getClass()) {
     * Extracts the inner hits from the query tree.
        return queries;
     * Sets the query name for the query.
    }
/*
        if (parser.currentToken() != XContentParser.Token.END_OBJECT) {
        if (boost() != DEFAULT_BOOST && rewritten.boost() == DEFAULT_BOOST) {
            throw new ParsingException(new XContentLocation(e.getLineNumber(), e.getColumnNumber()), message, e);
     * resulting collection.
    }
        String currentFieldName
    protected String queryName;
        this.boost = boost;
    }
 * ownership. Elasticsearch licenses this file to you under
            );
        parser.declareFloat(QueryBuilder::boost, AbstractQueryBuilder.BOOST_FIELD);
        return query;
        }
            if (queryName != null) {
    /** Default for boost to apply to resulting Lucene query. Defaults to 1.0*/
    @Override
     * Parses a query excluding the query element that wraps it
    /**
        }
        }
            return rewritten;
        for (QueryBuilder queryBuilder : queryBuilders) {
        XContentLocation contentLocation,
        }
 * this file be licensed under the Apache-2.0 license or a
     * <p>
        }
     */
    public final boolean equals(Object obj) {
     * @param obj the input object
            builder.field(NAME_FIELD.getPreferredName(), queryName);
    protected abstract Query doToQuery(QueryShardContext context) throws IOException;
