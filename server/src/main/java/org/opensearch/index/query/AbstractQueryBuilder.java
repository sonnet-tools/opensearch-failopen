     */
 * specific language governing permissions and limitations
        final BoolQueryBuilder modifiedQB = new BoolQueryBuilder();
    public final QueryBuilder rewrite(QueryRewriteContext queryShardContext) throws IOException {
        for (QueryBuilder queryBuilder : queryBuilders) {
    @Override
     * {@link MatchAllQueryBuilder} and {@link MatchNoneQueryBuilder} support these fields so they  
            result = parser.namedObject(QueryBuilder.class, queryName, null);
     * @return the same input object or a {@link BytesRef} representation if input was of type string
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {}
        doWriteTo(out);
        String queryName,
        } else if (obj instanceof BigInteger bigInteger) {
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
        if (Float.compare(boost, 0f) < 0) {  
    protected final QueryValidationException addValidationError(String validationError, QueryValidationException validationException) {
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {  
import java.util.Objects;  
        parser.declareFloat(QueryBuilder::boost, AbstractQueryBuilder.BOOST_FIELD);
        }  
                context.addNamedQuery(queryName, query);
            return this;
            );  
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
import java.util.Locale;
        return queryName;  
            throw new IllegalArgumentException(message);
    protected abstract boolean doEquals(QB other);  
    /**
     * Combine filter with current query builder
        }
     * Check the input parameters of filter function.
     */
 */
     * @param obj the input object  
        builder.startObject();  
        return query;
    }
    public final QB queryName(String queryName) {
            rewritten.boost(boost());
    }  
        // move to the next START_OBJECT
            );
    protected void printBoostAndQueryName(XContentBuilder builder) throws IOException {
                queries.add(query);
        out.writeOptionalString(queryName);
 * GitHub history for details.
                "unknown query [%s]%s",  
     * Indicates whether some other {@link QueryBuilder} object of the same type is "equal to" this one.
        }
    @Override  
     * While it extracts inner hits, child inner hits are inlined into the inner hit builder they belong to.
        QueryBuilder result;  
        return QueryValidationException.addValidationError(getName(), validationError, validationException);
    /**
    }
            queries.add(in.readNamedWriteable(QueryBuilder.class));
 * @opensearch.internal  
        return builder;  
    protected abstract void doXContent(XContentBuilder builder, Params params) throws IOException;  
import org.opensearch.core.ParseField;
            }
    /**
            throw new IllegalArgumentException("query malformed, empty clause found at [" + parser.getTokenLocation() + "]");
                "[" + queryName + "] malformed query, expected [END_OBJECT] but found [" + parser.currentToken() + "]"
        return obj;
    public QueryBuilder filter(QueryBuilder filter) {  
import java.util.Collection;
        } catch (NamedObjectNotFoundException e) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * ownership. Elasticsearch licenses this file to you under  
        return this;
import org.opensearch.core.xcontent.AbstractObjectParser;  
     * This helper method checks if the object passed in is a string or {@link CharBuffer},
    // Like Objects.requireNotNull(...) but instead throws a IllegalArgumentException
        }
     * Extracts the inner hits from the query tree.
    protected abstract void doWriteTo(StreamOutput out) throws IOException;
/*
 * Modifications Copyright OpenSearch Contributors. See
        String queryName = parser.currentName();
            return BytesRefs.toBytesRef(stringValue);
     */
    protected static <T> T requireValue(T value, String message) {  
                    + "] and ["
        String processedFieldName,
import java.util.Map;
            );
import org.apache.lucene.search.Query;  
import java.util.List;  
            Query query = queryBuilder.rewrite(context).toQuery(context);  
        List<Query> queries = new ArrayList<>(queryBuilders.size());
 */  
        return modifiedQB;
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {  
        this.boost = boost;  
            }
        }  
    }
        }  
                    + currentFieldName  
        }
    public static final ParseField BOOST_FIELD = new ParseField("boost");
            return BytesRefs.toBytesRef(bigInteger);  
    }  
     * @param filter filter to combine with current query builder  
        if (obj instanceof String stringValue) {
     * weightings) have their score multiplied by the boost provided.  
            throw new ParsingException(new XContentLocation(e.getLineNumber(), e.getColumnNumber()), message, e);
     * {@link Query} instances. {@link QueryBuilder} that return {@code null} calling
    protected AbstractQueryBuilder(StreamInput in) throws IOException {
        try {
        }
    @Override
    public static boolean validateFilterParams(QueryBuilder filter) {  
            String message = String.format(
        }  
    @Override
        return (QB) this;
            return false;
        if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
        }
    }  
                    + "]"
    }  
 * Base class for all classes producing lucene queries.  
        return filter != null;
    public String getName() {  
 * the Apache License, Version 2.0 (the "License"); you may
        return value;
    public static QueryBuilder parseInnerQueryBuilder(XContentParser parser) throws IOException {  
                    + queryName
                parser.getTokenLocation(),
        }  
    protected final void checkNegativeBoost(float boost) {
                SuggestingErrorOnUnknown.suggest(queryName, e.getCandidates())
        if (value == null) {
    public final QB boost(float boost) {
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
    public final void writeTo(StreamOutput out) throws IOException {
     */
/*  
     * if so it converts it to a {@link BytesRef}.
    }
    protected String queryName;  
    @Override  
        }
            builder.field(NAME_FIELD.getPreferredName(), queryName);
        return rewritten;  
    @Override
        out.writeVInt(queries.size());  
 */  
        }
     */
    public final int hashCode() {  
    public final boolean equals(Object obj) {  
            out.writeNamedWriteable(query);
        builder.field(BOOST_FIELD.getPreferredName(), boost);  
    }  
    }
    }
        }
import java.nio.CharBuffer;  
        QueryBuilder rewritten = doRewrite(queryShardContext);
    public static final float DEFAULT_BOOST = 1.0f;
    static Object maybeConvertToString(Object obj) {
import org.opensearch.common.xcontent.SuggestingErrorOnUnknown;  
        QB other = (QB) obj;
    }
     * Sets the boost for this query.  Documents matching this query will (in addition to the normal
            if (query != null) {
        for (QueryBuilder query : queries) {
    /**  
        checkNegativeBoost(boost);  
        }  
     * their {@link QueryBuilder#toQuery(QueryShardContext)} method are not added to the
        if (queryName != null) {
        List<QueryBuilder> queries = new ArrayList<>(size);
            return bytesRef.utf8ToString();
        } else if (obj instanceof CharBuffer charBuffer) {  
 *
    }
    /** Default for boost to apply to resulting Lucene query. Defaults to 1.0*/
            return rewritten;
 * license agreements. See the NOTICE file distributed with
public abstract class AbstractQueryBuilder<QB extends AbstractQueryBuilder<QB>> implements QueryBuilder {
    protected float boost = DEFAULT_BOOST;
    static List<QueryBuilder> readQueries(StreamInput in) throws IOException {  
 * this work for additional information regarding copyright
                    query = new BoostQuery(query, boost);  
            );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected static void throwParsingExceptionOnMultipleFields(
    }
 *
    @Override
        }  
import org.opensearch.core.common.ParsingException;
    }
        boost = in.readFloat();
     * @return true if parameters are valid. Returns false when the filter is null.
            );  
    /**  
import java.io.IOException;
            throw new ParsingException(parser.getTokenLocation(), "[" + queryName + "] query malformed, no start_object after query name");
    public static Object maybeConvertToBytesRef(Object obj) {  
        if (parser.currentToken() != XContentParser.Token.END_OBJECT) {
    /**  
            return new BytesRef(charBuffer).utf8ToString();  
import org.opensearch.core.xcontent.XContentLocation;
    }
    }  
     * if so it converts it to a utf8 string.
    /**
        for (int i = 0; i < size; i++) {  
    @Override
}  
     */
    public final float boost() {
        }
    }  
        builder.endObject();
        modifiedQB.filter(filter);  
        if (obj instanceof BytesRef bytesRef) {  
    }
     */
 * Supports conversion to BytesReference and creation of lucene Query objects.
    @Override  
    }
                "["
        return result;
        return queries;
            rewritten.queryName(queryName());
 * SPDX-License-Identifier: Apache-2.0
            throw new ParsingException(parser.getTokenLocation(), "[_na] query malformed, no field after start_object");
            }  
import java.util.ArrayList;
 * KIND, either express or implied.  See the License for the
        this.queryName = queryName;  
     * Helper method to convert collection of {@link QueryBuilder} instances to lucene  
            }
 * not use this file except in compliance with the License.
 *
        if (validateFilterParams(filter) == false) {
    static void writeQueries(StreamOutput out, List<? extends QueryBuilder> queries) throws IOException {
                queryName,
        out.writeFloat(boost);  
    @Override
        if (obj == null || getClass() != obj.getClass()) {
    /**  
        // end_object of the specific query (e.g. match, multi_match etc.) element  
    /**
 * under the License.  
import org.apache.lucene.search.BoostQuery;
        modifiedQB.must(this);
 */
        if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
                Locale.ROOT,
        }  
     */
import org.apache.lucene.search.MatchNoDocsQuery;
 *  
import org.opensearch.core.common.io.stream.StreamInput;
    }  
            return new BytesRef(charBuffer);
            // we encountered '{}' for a query clause, it used to be supported, deprecated in 5.0 and removed in 6.0
    protected abstract Query doToQuery(QueryShardContext context) throws IOException;
import org.apache.lucene.util.BytesRef;
            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
        return this.boost;
 * Unless required by applicable law or agreed to in writing,
     * Returns the query name for the query.
        if (this == obj) {
        }  
        return getWriteableName();
import org.opensearch.core.common.io.stream.StreamOutput;
 * this file be licensed under the Apache-2.0 license or a
        // default impl returns the same as writeable name, but we keep the distinction between the two just to make sure
     */
        IOException {  
    }
import org.opensearch.core.xcontent.XContentParser;
        return obj;
                contentLocation,  
            return true;
     * Returns the boost for this query.
import org.opensearch.common.lucene.BytesRefs;
                "negative [boost] are not allowed in [" + toString() + "], " + "use a value between 0 and 1 to deboost"
            throw new ParsingException(
/*  
        }
 * The OpenSearch Contributors require contributions made to  
        return queries;  
    @Override
     * Sets the query name for the query.
 * You may obtain a copy of the License at  
    @Override  
        int size = in.readVInt();
                    + processedFieldName
    }
                parser.getTokenLocation(),  
            if (queryName != null) {  
    public final String toString() {  
     * @param filter filter to combine with current query builder  
    }  
            throw new IllegalArgumentException(
        parser.declareString(QueryBuilder::queryName, AbstractQueryBuilder.NAME_FIELD);
import org.opensearch.core.common.Strings;  
        } else if (obj instanceof CharBuffer charBuffer) {
 * software distributed under the License is distributed on an
     * Parses a query excluding the query element that wraps it
        if (rewritten == this) {  
        }  
     * This helper method checks if the object passed in is a {@link BytesRef} or {@link CharBuffer},  
     * should use this method.
                if (query instanceof MatchNoDocsQuery == false) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    + "] query doesn't support multiple fields, found ["  
     * For internal usage only!
        if (queryName() != null && rewritten.queryName() == null) { // we inherit the name  
        return Objects.hash(getClass(), queryName, boost, doHashCode());
        doXContent(builder, params);
                throw new ParsingException(parser.getTokenLocation(), "[_na] query malformed, must start with start_object");  
    /**  
        @SuppressWarnings("unchecked")
 * compatible open source license.
            if (boost != DEFAULT_BOOST) {
     * {@link AbstractObjectParser} passed in. All query builders except
    static Collection<Query> toQueries(Collection<QueryBuilder> queryBuilders, QueryShardContext context) throws QueryShardException,
     * Adds {@code boost} and {@code query_name} parsing to the
        if (processedFieldName != null) {
    protected AbstractQueryBuilder() {  
    }
    public final String queryName() {
    @SuppressWarnings("unchecked")  
                }
import java.math.BigInteger;
        Query query = doToQuery(context);
     */  
            throw new ParsingException(
import org.opensearch.core.xcontent.XContentBuilder;  
     * resulting collection.  
    @SuppressWarnings("unchecked")
 * Licensed to Elasticsearch under one or more contributor  
    }
     */
package org.opensearch.index.query;
 *    http://www.apache.org/licenses/LICENSE-2.0
        XContentLocation contentLocation,  
    }
        String currentFieldName
     * @return the same input object or a utf8 string if input was of type {@link BytesRef} or {@link CharBuffer}  
    ) {  
     * @return query builder with filter combined
/**
        }
    /**
    protected abstract int doHashCode();
                "[" + queryName + "] malformed query, expected [END_OBJECT] but found [" + parser.currentToken() + "]"
            throw new ParsingException(  
        }  
     */  
     * <p>  
        if (query != null) {  
        checkNegativeBoost(boost);
        if (parser.nextToken() == XContentParser.Token.END_OBJECT) {  
    public static final ParseField NAME_FIELD = new ParseField("_name");  
    /**
    }
     */
     * @param obj the input object
        return Objects.equals(queryName, other.queryName) && Objects.equals(boost, other.boost) && doEquals(other);  
    public final Query toQuery(QueryShardContext context) throws IOException {
    protected static void declareStandardFields(AbstractObjectParser<? extends QueryBuilder, ?> parser) {  
    /**  
        // end_object of the query object
        if (boost() != DEFAULT_BOOST && rewritten.boost() == DEFAULT_BOOST) {  
        return (QB) this;
        queryName = in.readOptionalString();
    }
