    }
        }  
    public static final String NAME = "match_phrase_prefix";
 * compatible open source license.
            throw new IllegalArgumentException("[" + NAME + "] requires query value");
        builder.startObject(fieldName);
    }  
    private final String fieldName;
                fieldName = parser.currentName();
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
    public MatchPhrasePrefixQueryBuilder zeroTermsQuery(ZeroTermsQuery zeroTermsQuery) {  
                        }  
     * The number of term expansions to use.
    }  
        return this.analyzer;
        this.value = value;
        String currentFieldName = null;
    @Override
        matchQuery.slop(slop);
        String analyzer = null;
/*  
     */
                            );
        // validate context specific fields  
                value = parser.objectText();
        analyzer = in.readOptionalString();
                            slop = parser.intValue();
        maxExpansions = in.readVInt();  
    public static MatchPhrasePrefixQueryBuilder fromXContent(XContentParser parser) throws IOException {
        }
        return Objects.equals(fieldName, other.fieldName)  
                            } else if ("all".equalsIgnoreCase(zeroTermsValue)) {
        return this.slop;  
                            queryName = parser.text();  
        builder.endObject();
import org.opensearch.core.common.io.stream.StreamOutput;  
        }
        slop = in.readVInt();
        return matchQuery.parse(MatchQuery.Type.PHRASE_PREFIX, fieldName, value);
 * under the License.  
        }
            throw new IllegalArgumentException("No negative slop allowed.");
        printBoostAndQueryName(builder);
            matchQuery.setAnalyzer(analyzer);
 */  
 * software distributed under the License is distributed on an
    public static final ParseField ZERO_TERMS_QUERY_FIELD = new ParseField("zero_terms_query");  
        return this.value;
 *  
     * Get the (optional) number of term expansions when using fuzzy or prefix  
        return matchQuery;
                currentFieldName = parser.currentName();
    }  
        return this;
    }  
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
    private int slop = MatchQuery.DEFAULT_PHRASE_SLOP;
        if (slop < 0) {  
    }
                        );
 * GitHub history for details.
                                zeroTermsQuery = ZeroTermsQuery.NONE;
        this.zeroTermsQuery = ZeroTermsQuery.readFromStream(in);
                            }  
                                    "Unsupported zero_terms_query value [" + zeroTermsValue + "]"
    public int maxExpansions() {  
        Object value = null;  
        this.fieldName = fieldName;  
    protected Query doToQuery(QueryShardContext context) throws IOException {
import java.util.Objects;
 */
import org.apache.lucene.search.FuzzyQuery;
        builder.startObject(NAME);
    private String analyzer;  
        zeroTermsQuery.writeTo(out);  
 * Match query is a query that analyzes the text and constructs a phrase prefix
                                    parser.getTokenLocation(),  
 * the Apache License, Version 2.0 (the "License"); you may
    protected int doHashCode() {  
                            if ("none".equalsIgnoreCase(zeroTermsValue)) {  
                        } else if (ZERO_TERMS_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        String fieldName = null;
        String queryName = null;
 * Licensed to Elasticsearch under one or more contributor  
                            String zeroTermsValue = parser.text();
import org.opensearch.core.common.ParsingException;
                        } else {
    }
    @Override
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
                            analyzer = parser.text();
    public MatchPhrasePrefixQueryBuilder slop(int slop) {
/**  
                                zeroTermsQuery = ZeroTermsQuery.ALL;  
    }
            builder.field(MatchQueryBuilder.ANALYZER_FIELD.getPreferredName(), analyzer);  
    }
     */
        return NAME;
        matchQuery.boost(boost);
 */  
        }  
    /** Sets a slop factor for phrase queries */
                    }  
    }
        return this.zeroTermsQuery;  
            throw new QueryShardException(context, "[" + NAME + "] analyzer [" + analyzer + "] not found");
 * Unless required by applicable law or agreed to in writing,
    public static final ParseField MAX_EXPANSIONS_FIELD = new ParseField("max_expansions");
        XContentParser.Token token;  
    /**  
        this.slop = slop;  
            throw new IllegalArgumentException("[" + NAME + "] requires fieldName");
                                "[" + NAME + "] query does not support [" + currentFieldName + "]"
            } else {
 * KIND, either express or implied.  See the License for the
                                );
        matchQuery.setZeroTermsQuery(zeroTermsQuery);
        builder.field(MatchQueryBuilder.QUERY_FIELD.getPreferredName(), value);
    }
    public String getWriteableName() {
        MatchQuery matchQuery = new MatchQuery(context);
        return Objects.hash(fieldName, value, analyzer, slop, maxExpansions, zeroTermsQuery);
import org.apache.lucene.search.Query;
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
        int slop = MatchQuery.DEFAULT_PHRASE_SLOP;  
        out.writeVInt(maxExpansions);
        if (zeroTermsQuery == null) {
        return this;
            if (token == XContentParser.Token.FIELD_NAME) {
 * query as the result of the analysis.
    public MatchPhrasePrefixQueryBuilder analyzer(String analyzer) {  
    public String fieldName() {
 * not use this file except in compliance with the License.
     */
    @Override
 * @opensearch.internal
        }
        int maxExpansion = FuzzyQuery.defaultMaxExpansions;
                            "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
                fieldName = currentFieldName;
        return this;
        }
                        } else if (MatchPhraseQueryBuilder.SLOP_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            && Objects.equals(analyzer, other.analyzer)
        return this.fieldName;  
import org.opensearch.core.common.io.stream.StreamInput;
        return this;
                    } else if (token.isValue()) {  
    @Override
public class MatchPhrasePrefixQueryBuilder extends AbstractQueryBuilder<MatchPhrasePrefixQueryBuilder> implements WithFieldName {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
 *
                        } else if (MatchQueryBuilder.ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                }
        matchQuery.queryName(queryName);
        return this.maxExpansions;
/*  
    }  
        out.writeString(fieldName);
     * config for the field, or, if not set, the default search analyzer.
                                throw new ParsingException(
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    /** Returns the value used in this query. */  
        matchQuery.setMaxExpansions(maxExpansions);
}  
package org.opensearch.index.query;
    private int maxExpansions = FuzzyQuery.defaultMaxExpansions;
     * Read from a stream.
        super(in);
    @Override
     */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentParser;
        if (maxExpansions < 0) {
        matchQuery.zeroTermsQuery(zeroTermsQuery);  
        matchQuery.maxExpansions(maxExpansion);  
            && Objects.equals(value, other.value)
    public String analyzer() {  
     * Explicitly set the analyzer to use. Defaults to use explicit mapping  
        if (fieldName == null) {  
            } else if (token == XContentParser.Token.START_OBJECT) {  
     * {@link ZeroTermsQuery#ALL} instead.
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder(fieldName, value);  
        out.writeVInt(slop);  
        }  
                            } else {
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (value == null) {  
    protected boolean doEquals(MatchPhrasePrefixQueryBuilder other) {
    public Object value() {
        out.writeGenericValue(value);
            && Objects.equals(slop, other.slop)  
                        if (MatchQueryBuilder.QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.analyzer = analyzer;
                        } else if (MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    public int slop() {
                        throw new ParsingException(
                        currentFieldName = parser.currentName();
    public MatchPhrasePrefixQueryBuilder(String fieldName, Object value) {
        builder.endObject();  
 * license agreements. See the NOTICE file distributed with
        builder.field(MatchPhraseQueryBuilder.SLOP_FIELD.getPreferredName(), slop);
 *
    @Override  
 */
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());  
        if (analyzer != null && context.getIndexAnalyzers().get(analyzer) == null) {
            && Objects.equals(zeroTermsQuery, other.zeroTermsQuery);
                    } else {
     * type query.
                            maxExpansion = parser.intValue();
    public MatchPhrasePrefixQueryBuilder maxExpansions(int maxExpansions) {  
            throw new IllegalArgumentException("[" + NAME + "] requires zeroTermsQuery to be non-null");
    /**
/*
                            throw new ParsingException(
    private ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
     */
    protected void doWriteTo(StreamOutput out) throws IOException {  
        if (analyzer != null) {
    }
    /**
import org.opensearch.core.xcontent.XContentBuilder;
 * You may obtain a copy of the License at  
    /**
    }  
    }
    /** Get the slop factor for phrase queries. */
import org.opensearch.index.search.MatchQuery;  
        matchQuery.analyzer(analyzer);
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
 * specific language governing permissions and limitations
                            boost = parser.floatValue();  
        this.maxExpansions = maxExpansions;
import org.opensearch.core.ParseField;  
    private final Object value;
    public MatchPhrasePrefixQueryBuilder(StreamInput in) throws IOException {
        builder.field(MAX_EXPANSIONS_FIELD.getPreferredName(), maxExpansions);  
        fieldName = in.readString();  
     * Defaults to {@link ZeroTermsQuery#NONE}, but can be set to  
        builder.field(ZERO_TERMS_QUERY_FIELD.getPreferredName(), zeroTermsQuery.toString());
    @Override
    /** Get the analyzer to use, if previously set, otherwise {@code null} */
 * this work for additional information regarding copyright
    public ZeroTermsQuery zeroTermsQuery() {
                                parser.getTokenLocation(),  
                            parser.getTokenLocation(),  
        ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
    /**
                    if (token == XContentParser.Token.FIELD_NAME) {
    }  
                            value = parser.objectText();
        }
        value = in.readGenericValue();
            throw new IllegalArgumentException("No negative maxExpansions allowed.");
    /** Returns the field name used in this query. */  
 *  
        matchQuery.setPhraseSlop(slop);  
        if (analyzer != null) {  
 * The OpenSearch Contributors require contributions made to  
     * Sets query to use in case no query terms are available, e.g. after analysis removed them.
        out.writeOptionalString(analyzer);
            && Objects.equals(maxExpansions, other.maxExpansions)
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    }
        this.zeroTermsQuery = zeroTermsQuery;
