        if (value == null) {
                value = parser.objectText();
        this.slop = slop;
                        } else if (SLOP_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            queryName = parser.text();
        }
        }
    }
        return this.zeroTermsQuery;
        }
     */
    protected void doWriteTo(StreamOutput out) throws IOException {
        MatchQuery matchQuery = new MatchQuery(context);
            && Objects.equals(analyzer, other.analyzer)
        if (analyzer != null) {
        matchQuery.setZeroTermsQuery(zeroTermsQuery);
                    } else {
                            analyzer = parser.text();
/*
    @Override
        this.fieldName = fieldName;
    }
 *
        builder.endObject();
        if (zeroTermsQuery == null) {
 * compatible open source license.
                        throw new ParsingException(
        this.zeroTermsQuery = zeroTermsQuery;
    /**
import org.opensearch.index.search.MatchQuery;
    private int slop = MatchQuery.DEFAULT_PHRASE_SLOP;
     * Defaults to {@link ZeroTermsQuery#NONE}, but can be set to
    }
 */
     * config for the field, or, if not set, the default search analyzer.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
        if (slop < 0) {
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public MatchPhraseQueryBuilder slop(int slop) {
import org.opensearch.core.ParseField;
        return matchQuery.parse(MatchQuery.Type.PHRASE, fieldName, value);
    public String analyzer() {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
 */
                        );
                    if (token == XContentParser.Token.FIELD_NAME) {
        matchQuery.boost(boost);
    /** Get the analyzer to use, if previously set, otherwise {@code null} */
        return this.value;
                            slop = parser.intValue();
 *
 * as the result of the analysis.
 * @opensearch.internal
 * under the License.
 * GitHub history for details.
    }
import org.apache.lucene.search.Query;
        return Objects.equals(fieldName, other.fieldName)
                                "[" + NAME + "] query does not support [" + currentFieldName + "]"
                        currentFieldName = parser.currentName();
import java.util.Objects;
import java.io.IOException;
        out.writeOptionalString(analyzer);
 *    http://www.apache.org/licenses/LICENSE-2.0
    /** Sets a slop factor for phrase queries */
        String fieldName = null;
    public String fieldName() {
    protected boolean doEquals(MatchPhraseQueryBuilder other) {
                            }
     */
        XContentParser.Token token;
 * specific language governing permissions and limitations
    public MatchPhraseQueryBuilder(String fieldName, Object value) {
                        if (MatchQueryBuilder.QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            }
        return this.fieldName;
    }
            builder.field(MatchQueryBuilder.ANALYZER_FIELD.getPreferredName(), analyzer);
        // validate context specific fields
        analyzer = in.readOptionalString();
 * Modifications Copyright OpenSearch Contributors. See
    @Override
                    }
        return this.analyzer;
        ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
    public Object value() {
            throw new IllegalArgumentException("[" + NAME + "] requires fieldName");
        int slop = MatchQuery.DEFAULT_PHRASE_SLOP;
        value = in.readGenericValue();
    }
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
    @Override
        printBoostAndQueryName(builder);
                            if ("none".equalsIgnoreCase(zeroTermsValue)) {
 * You may obtain a copy of the License at
        builder.field(ZERO_TERMS_QUERY_FIELD.getPreferredName(), zeroTermsQuery.toString());
        builder.startObject(fieldName);
                            boost = parser.floatValue();
            matchQuery.setAnalyzer(analyzer);
        matchQuery.zeroTermsQuery(zeroTermsQuery);
        matchQuery.analyzer(analyzer);
        String queryName = null;
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
        }
    }
    /** Returns the field name used in this query. */
                            String zeroTermsValue = parser.text();
    public static final ParseField ZERO_TERMS_QUERY_FIELD = new ParseField("zero_terms_query");
import org.opensearch.core.common.Strings;
        zeroTermsQuery = ZeroTermsQuery.readFromStream(in);
    public static final String NAME = "match_phrase";
    @Override
        matchQuery.queryName(queryName);
        return this.slop;
     */
        builder.endObject();
            throw new IllegalArgumentException("[" + NAME + "] requires query value");
                        } else if (MatchQueryBuilder.ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                                    "Unsupported zero_terms_query value [" + zeroTermsValue + "]"
    public ZeroTermsQuery zeroTermsQuery() {
    /** Returns the value used in this query. */
     * Read from a stream.
            if (token == XContentParser.Token.FIELD_NAME) {
    private ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
 * Match query is a query that analyzes the text and constructs a phrase query
    @Override
    public static MatchPhraseQueryBuilder fromXContent(XContentParser parser) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
        out.writeString(fieldName);
 * ownership. Elasticsearch licenses this file to you under
        Object value = null;
                            "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
            throw new QueryShardException(context, "[" + NAME + "] analyzer [" + analyzer + "] not found");
        out.writeGenericValue(value);
     * {@link ZeroTermsQuery#ALL} instead.
 */
 *
        super(in);
            && Objects.equals(zeroTermsQuery, other.zeroTermsQuery);
        if (analyzer != null) {
        out.writeVInt(slop);
        matchQuery.setPhraseSlop(slop);
    }
import org.opensearch.core.common.ParsingException;
                        } else if (ZERO_TERMS_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.common.io.stream.StreamInput;
            throw new IllegalArgumentException("[" + NAME + "] requires zeroTermsQuery to be non-null");
                        } else {
                            } else if ("all".equalsIgnoreCase(zeroTermsValue)) {
        fieldName = in.readString();
    }
                                zeroTermsQuery = ZeroTermsQuery.ALL;
                }
        this.analyzer = analyzer;
            && Objects.equals(slop, other.slop)
    }
import org.opensearch.core.xcontent.XContentParser;
        if (Strings.isEmpty(fieldName)) {
            && Objects.equals(value, other.value)
 * SPDX-License-Identifier: Apache-2.0
                                zeroTermsQuery = ZeroTermsQuery.NONE;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    public String getWriteableName() {
        builder.field(SLOP_FIELD.getPreferredName(), slop);
                fieldName = currentFieldName;
    public int slop() {
}
        return this;
                currentFieldName = parser.currentName();
        }
/*
                                    parser.getTokenLocation(),
                fieldName = parser.currentName();
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        }
        builder.startObject(NAME);
public class MatchPhraseQueryBuilder extends AbstractQueryBuilder<MatchPhraseQueryBuilder> implements WithFieldName {
    protected Query doToQuery(QueryShardContext context) throws IOException {
 * not use this file except in compliance with the License.
    }
    }
            throw new IllegalArgumentException("No negative slop allowed.");
        String currentFieldName = null;
        }
    public MatchPhraseQueryBuilder zeroTermsQuery(ZeroTermsQuery zeroTermsQuery) {
/*
package org.opensearch.index.query;
import org.opensearch.core.common.io.stream.StreamOutput;
    private final String fieldName;
                                parser.getTokenLocation(),
        return this;
    }
        MatchPhraseQueryBuilder matchQuery = new MatchPhraseQueryBuilder(fieldName, value);
                            throw new ParsingException(
 * this work for additional information regarding copyright
    /**
                            parser.getTokenLocation(),
    /** Get the slop factor for phrase queries. */
import org.opensearch.core.xcontent.XContentBuilder;
        if (analyzer != null && context.getIndexAnalyzers().get(analyzer) == null) {
            } else if (token == XContentParser.Token.START_OBJECT) {
    public MatchPhraseQueryBuilder(StreamInput in) throws IOException {
    @Override
    @Override
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    private String analyzer;
 *
 * software distributed under the License is distributed on an
        return NAME;
        this.value = value;
        matchQuery.slop(slop);
 * license agreements. See the NOTICE file distributed with
     * Explicitly set the analyzer to use. Defaults to use explicit mapping
            } else {
                                throw new ParsingException(
        String analyzer = null;
    }
/**
        zeroTermsQuery.writeTo(out);
        builder.field(MatchQueryBuilder.QUERY_FIELD.getPreferredName(), value);
                            );
 * the Apache License, Version 2.0 (the "License"); you may
                            value = parser.objectText();
 * this file be licensed under the Apache-2.0 license or a
 */
    protected int doHashCode() {
     * Sets query to use in case no query terms are available, e.g. after analysis removed them.
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
                    } else if (token.isValue()) {
    private final Object value;
        }
                            } else {
        slop = in.readVInt();
    public static final ParseField SLOP_FIELD = new ParseField("slop");
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * The OpenSearch Contributors require contributions made to
    public MatchPhraseQueryBuilder analyzer(String analyzer) {
                                );
    }
    }
        return Objects.hash(fieldName, value, analyzer, slop);
        return matchQuery;
        return this;
        }
