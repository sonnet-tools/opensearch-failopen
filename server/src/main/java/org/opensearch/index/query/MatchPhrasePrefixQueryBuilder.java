    }
        builder.field(MatchQueryBuilder.QUERY_FIELD.getPreferredName(), value);
 *
        String queryName = null;
                value = parser.objectText();
        this.zeroTermsQuery = zeroTermsQuery;
        return this.maxExpansions;
        // validate context specific fields
                            } else if ("all".equalsIgnoreCase(zeroTermsValue)) {
 * software distributed under the License is distributed on an
            throw new IllegalArgumentException("No negative slop allowed.");
    }
import org.apache.lucene.search.FuzzyQuery;
     * Defaults to {@link ZeroTermsQuery#NONE}, but can be set to
 * specific language governing permissions and limitations
                }
            && Objects.equals(zeroTermsQuery, other.zeroTermsQuery);
        if (value == null) {
    protected void doWriteTo(StreamOutput out) throws IOException {
    }
        if (zeroTermsQuery == null) {
                            }
            if (token == XContentParser.Token.FIELD_NAME) {
            throw new IllegalArgumentException("No negative maxExpansions allowed.");
        matchQuery.analyzer(analyzer);
    @Override
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
 *
    }
        out.writeString(fieldName);
        }
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
                            String zeroTermsValue = parser.text();
    public MatchPhrasePrefixQueryBuilder(String fieldName, Object value) {
     * The number of term expansions to use.
        }
                            slop = parser.intValue();
                        if (MatchQueryBuilder.QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    protected boolean doEquals(MatchPhrasePrefixQueryBuilder other) {
                                zeroTermsQuery = ZeroTermsQuery.NONE;
        zeroTermsQuery.writeTo(out);
        return Objects.hash(fieldName, value, analyzer, slop, maxExpansions, zeroTermsQuery);
        int maxExpansion = FuzzyQuery.defaultMaxExpansions;
    /**
import org.opensearch.core.common.io.stream.StreamInput;
                                parser.getTokenLocation(),
        matchQuery.setMaxExpansions(maxExpansions);
    }
 * The OpenSearch Contributors require contributions made to
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * config for the field, or, if not set, the default search analyzer.
        builder.field(ZERO_TERMS_QUERY_FIELD.getPreferredName(), zeroTermsQuery.toString());
import org.apache.lucene.search.Query;
 */
        XContentParser.Token token;
    public int slop() {
                        } else if (MatchPhraseQueryBuilder.SLOP_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        } else if (ZERO_TERMS_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * Modifications Copyright OpenSearch Contributors. See
 */
                currentFieldName = parser.currentName();
     */
        }
        maxExpansions = in.readVInt();
                                throw new ParsingException(
    private final String fieldName;
                        currentFieldName = parser.currentName();
            } else {
 */
        analyzer = in.readOptionalString();
    public Object value() {
            && Objects.equals(value, other.value)
    private String analyzer;
                            maxExpansion = parser.intValue();
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
        printBoostAndQueryName(builder);
 * compatible open source license.
    @Override
                                zeroTermsQuery = ZeroTermsQuery.ALL;
                        } else {
    }
        out.writeOptionalString(analyzer);
        Object value = null;
import org.opensearch.index.search.MatchQuery;
     * type query.
    /** Get the analyzer to use, if previously set, otherwise {@code null} */
        MatchQuery matchQuery = new MatchQuery(context);
/*
    public int maxExpansions() {
    }
 * query as the result of the analysis.
     * Explicitly set the analyzer to use. Defaults to use explicit mapping
        this.fieldName = fieldName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    }
import org.opensearch.core.common.ParsingException;
                            analyzer = parser.text();
    public static final String NAME = "match_phrase_prefix";
    public MatchPhrasePrefixQueryBuilder analyzer(String analyzer) {
        return this.slop;
                        } else if (MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            && Objects.equals(analyzer, other.analyzer)
     * Get the (optional) number of term expansions when using fuzzy or prefix
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    /**
    /** Get the slop factor for phrase queries. */
        builder.field(MAX_EXPANSIONS_FIELD.getPreferredName(), maxExpansions);
 * @opensearch.internal
 *
import java.io.IOException;
                            if ("none".equalsIgnoreCase(zeroTermsValue)) {
        ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
import java.util.Objects;
                        throw new ParsingException(
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            throw new ParsingException(
        return this;
                        }
        matchQuery.zeroTermsQuery(zeroTermsQuery);
    }
        matchQuery.setPhraseSlop(slop);
        builder.field(MatchPhraseQueryBuilder.SLOP_FIELD.getPreferredName(), slop);
    public String getWriteableName() {
 * the Apache License, Version 2.0 (the "License"); you may
 *
     */
    }
    public MatchPhrasePrefixQueryBuilder maxExpansions(int maxExpansions) {
        fieldName = in.readString();
    @Override
                                );
        out.writeVInt(maxExpansions);
    @Override
                    }
                            boost = parser.floatValue();
     */
        matchQuery.queryName(queryName);
        matchQuery.boost(boost);
import org.opensearch.core.xcontent.XContentBuilder;
            throw new IllegalArgumentException("[" + NAME + "] requires fieldName");
/*
                            queryName = parser.text();
            throw new QueryShardException(context, "[" + NAME + "] analyzer [" + analyzer + "] not found");
 * SPDX-License-Identifier: Apache-2.0
        matchQuery.setZeroTermsQuery(zeroTermsQuery);
    }
            matchQuery.setAnalyzer(analyzer);
        return this;
    public String analyzer() {
package org.opensearch.index.query;
        return this.fieldName;
            && Objects.equals(maxExpansions, other.maxExpansions)
        return this.value;
    }
        value = in.readGenericValue();
        slop = in.readVInt();
        super(in);
import org.opensearch.core.xcontent.XContentParser;
                    } else {
 * Licensed to Elasticsearch under one or more contributor
     * Sets query to use in case no query terms are available, e.g. after analysis removed them.
                                    "Unsupported zero_terms_query value [" + zeroTermsValue + "]"
                fieldName = currentFieldName;
     */
        builder.startObject(NAME);
    protected int doHashCode() {
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    }
    public MatchPhrasePrefixQueryBuilder(StreamInput in) throws IOException {
        return matchQuery;
            throw new IllegalArgumentException("[" + NAME + "] requires zeroTermsQuery to be non-null");
        return this;
        return matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, fieldName, value);
                            parser.getTokenLocation(),
            builder.field(MatchQueryBuilder.ANALYZER_FIELD.getPreferredName(), analyzer);
                    } else if (token.isValue()) {
        }
        if (slop < 0) {
                                "[" + NAME + "] query does not support [" + currentFieldName + "]"
                            "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
                                    parser.getTokenLocation(),
        this.value = value;
    public MatchPhrasePrefixQueryBuilder zeroTermsQuery(ZeroTermsQuery zeroTermsQuery) {
    private final Object value;
/**
        this.slop = slop;
        if (analyzer != null) {
 */
    public String fieldName() {
                            } else {
 * ownership. Elasticsearch licenses this file to you under
        String analyzer = null;
        builder.startObject(fieldName);
    }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        return Objects.equals(fieldName, other.fieldName)
                        );
        String currentFieldName = null;
    private ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
        }
        return this;
 * You may obtain a copy of the License at
     * {@link ZeroTermsQuery#ALL} instead.
    /**
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        out.writeVInt(slop);
        }
    public static final ParseField MAX_EXPANSIONS_FIELD = new ParseField("max_expansions");
    public static MatchPhrasePrefixQueryBuilder fromXContent(XContentParser parser) throws IOException {
 * KIND, either express or implied.  See the License for the
/*
                            value = parser.objectText();
 * not use this file except in compliance with the License.
    protected Query doToQuery(QueryShardContext context) throws IOException {
                        } else if (MatchQueryBuilder.ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.zeroTermsQuery = ZeroTermsQuery.readFromStream(in);
        this.maxExpansions = maxExpansions;
        int slop = MatchQuery.DEFAULT_PHRASE_SLOP;
                fieldName = parser.currentName();
        builder.endObject();
    }
            }
        return this.analyzer;
        this.analyzer = analyzer;
        if (analyzer != null) {
        out.writeGenericValue(value);
    /** Returns the field name used in this query. */
                            );
            } else if (token == XContentParser.Token.START_OBJECT) {
        builder.endObject();
        }
public class MatchPhrasePrefixQueryBuilder extends AbstractQueryBuilder<MatchPhrasePrefixQueryBuilder> implements WithFieldName {
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder(fieldName, value);
        matchQuery.slop(slop);
    @Override
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private int slop = MatchQuery.DEFAULT_PHRASE_SLOP;
}
     * Read from a stream.
        return NAME;
        return this.zeroTermsQuery;
 * this work for additional information regarding copyright
                    if (token == XContentParser.Token.FIELD_NAME) {
 * license agreements. See the NOTICE file distributed with
    private int maxExpansions = FuzzyQuery.defaultMaxExpansions;
    /**
    public static final ParseField ZERO_TERMS_QUERY_FIELD = new ParseField("zero_terms_query");
        }
        if (analyzer != null && context.getIndexAnalyzers().get(analyzer) == null) {
    /**
        String fieldName = null;
    /** Sets a slop factor for phrase queries */
    public ZeroTermsQuery zeroTermsQuery() {
        matchQuery.maxExpansions(maxExpansion);
     */
import org.opensearch.core.ParseField;
    }
        if (fieldName == null) {
 * under the License.
    /** Returns the value used in this query. */
            && Objects.equals(slop, other.slop)
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
 * Match query is a query that analyzes the text and constructs a phrase prefix
            throw new IllegalArgumentException("[" + NAME + "] requires query value");
        if (maxExpansions < 0) {
    public MatchPhrasePrefixQueryBuilder slop(int slop) {
    @Override
    }
 * GitHub history for details.
