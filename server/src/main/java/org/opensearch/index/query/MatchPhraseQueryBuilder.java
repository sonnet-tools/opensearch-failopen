        MatchPhraseQueryBuilder matchQuery = new MatchPhraseQueryBuilder(fieldName, value);
        String currentFieldName = null;
                        } else if (ZERO_TERMS_QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    if (token == XContentParser.Token.FIELD_NAME) {
        matchQuery.slop(slop);  
        return this.value;
    }
    @Override  
    public ZeroTermsQuery zeroTermsQuery() {  
    public static final ParseField SLOP_FIELD = new ParseField("slop");
                                );  
                            value = parser.objectText();
    public Object value() {  
    public String fieldName() {
 * @opensearch.internal
    public int slop() {
     */
 * license agreements. See the NOTICE file distributed with
 * Match query is a query that analyzes the text and constructs a phrase query
    private final String fieldName;
        }
    }
    public MatchPhraseQueryBuilder(StreamInput in) throws IOException {
        String queryName = null;  
    private ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
    public static final ParseField ZERO_TERMS_QUERY_FIELD = new ParseField("zero_terms_query");  
    }
                            } else if ("all".equalsIgnoreCase(zeroTermsValue)) {  
        return NAME;  
                            slop = parser.intValue();
import org.opensearch.index.search.MatchQuery;  
        XContentParser.Token token;
        matchQuery.boost(boost);  
    }  
 * The OpenSearch Contributors require contributions made to  
        fieldName = in.readString();
        return this.analyzer;  
import java.io.IOException;  
            }
    public String getWriteableName() {
    public String analyzer() {
                        } else if (MatchQueryBuilder.ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                                throw new ParsingException(  
 * as the result of the analysis.
 * GitHub history for details.
    public MatchPhraseQueryBuilder zeroTermsQuery(ZeroTermsQuery zeroTermsQuery) {
    /** Sets a slop factor for phrase queries */  
    }  
                }
        return Objects.hash(fieldName, value, analyzer, slop);
import org.opensearch.core.common.io.stream.StreamInput;
                        } else if (SLOP_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            }
import org.opensearch.core.common.Strings;
import java.util.Objects;
        }
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            boost = parser.floatValue();  
        matchQuery.setZeroTermsQuery(zeroTermsQuery);
            && Objects.equals(value, other.value)  
                value = parser.objectText();  
 */  
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
        if (analyzer != null && context.getIndexAnalyzers().get(analyzer) == null) {
        matchQuery.setPhraseSlop(slop);  
 *  
        slop = in.readVInt();  
    }
     */
        return matchQuery;
}  
        String fieldName = null;  
 * this work for additional information regarding copyright
package org.opensearch.index.query;
    protected void doWriteTo(StreamOutput out) throws IOException {  
                                zeroTermsQuery = ZeroTermsQuery.NONE;
        Object value = null;
        builder.field(ZERO_TERMS_QUERY_FIELD.getPreferredName(), zeroTermsQuery.toString());
        analyzer = in.readOptionalString();
 */  
    public MatchPhraseQueryBuilder analyzer(String analyzer) {
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
            } else {  
 * KIND, either express or implied.  See the License for the
    }  
                                "[" + NAME + "] query does not support [" + currentFieldName + "]"
import org.opensearch.core.xcontent.XContentParser;
            throw new IllegalArgumentException("[" + NAME + "] requires zeroTermsQuery to be non-null");  
        if (analyzer != null) {  
                            parser.getTokenLocation(),
        }
     * Explicitly set the analyzer to use. Defaults to use explicit mapping
 * software distributed under the License is distributed on an
    @Override  
        if (slop < 0) {
    public MatchPhraseQueryBuilder slop(int slop) {
                            } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected Query doToQuery(QueryShardContext context) throws IOException {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
            throw new IllegalArgumentException("[" + NAME + "] requires query value");
 */
    private int slop = MatchQuery.DEFAULT_PHRASE_SLOP;
        this.zeroTermsQuery = zeroTermsQuery;
                            String zeroTermsValue = parser.text();  
        matchQuery.zeroTermsQuery(zeroTermsQuery);
    }
    private String analyzer;  
        out.writeString(fieldName);
 * not use this file except in compliance with the License.
                        if (MatchQueryBuilder.QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }  
                            if ("none".equalsIgnoreCase(zeroTermsValue)) {
        this.value = value;
     * {@link ZeroTermsQuery#ALL} instead.
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                currentFieldName = parser.currentName();
        printBoostAndQueryName(builder);
                            analyzer = parser.text();
        }
    }
                            "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
                        throw new ParsingException(  
     * Defaults to {@link ZeroTermsQuery#NONE}, but can be set to
        zeroTermsQuery.writeTo(out);
                    }
 *
import org.opensearch.core.xcontent.XContentBuilder;
                        }
 * ownership. Elasticsearch licenses this file to you under  
                    } else if (token.isValue()) {  
    public MatchPhraseQueryBuilder(String fieldName, Object value) {  
import org.apache.lucene.search.Query;
            matchQuery.setAnalyzer(analyzer);
        if (Strings.isEmpty(fieldName)) {
 * specific language governing permissions and limitations
                    } else {
        if (analyzer != null) {  
        builder.startObject(NAME);
    }  
        return this.fieldName;
        builder.field(SLOP_FIELD.getPreferredName(), slop);  
            throw new IllegalArgumentException("No negative slop allowed.");  
        String analyzer = null;  
    protected int doHashCode() {
        return this.slop;
            throw new QueryShardException(context, "[" + NAME + "] analyzer [" + analyzer + "] not found");
        builder.endObject();  
                            );  
        return this;  
        int slop = MatchQuery.DEFAULT_PHRASE_SLOP;
        return matchQuery.parse(MatchQuery.Type.PHRASE, fieldName, value);  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
public class MatchPhraseQueryBuilder extends AbstractQueryBuilder<MatchPhraseQueryBuilder> implements WithFieldName {  
        MatchQuery matchQuery = new MatchQuery(context);
        builder.startObject(fieldName);  
/*  
    @Override
     * config for the field, or, if not set, the default search analyzer.  
                fieldName = parser.currentName();
    /**
 * compatible open source license.
        return this;
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    }
        this.fieldName = fieldName;
                        );  
            if (token == XContentParser.Token.FIELD_NAME) {
        }  
        out.writeOptionalString(analyzer);
                                    parser.getTokenLocation(),
    /** Returns the field name used in this query. */
     * Read from a stream.  
        zeroTermsQuery = ZeroTermsQuery.readFromStream(in);
                            throw new ParsingException(  
    private final Object value;
                            queryName = parser.text();
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
            && Objects.equals(zeroTermsQuery, other.zeroTermsQuery);  
                                    "Unsupported zero_terms_query value [" + zeroTermsValue + "]"
    }  
/**  
        return this.zeroTermsQuery;
            builder.field(MatchQueryBuilder.ANALYZER_FIELD.getPreferredName(), analyzer);
        this.analyzer = analyzer;  
            } else if (token == XContentParser.Token.START_OBJECT) {  
        builder.field(MatchQueryBuilder.QUERY_FIELD.getPreferredName(), value);
    @Override
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        return this;  
 * this file be licensed under the Apache-2.0 license or a
        if (zeroTermsQuery == null) {
        value = in.readGenericValue();
    /** Get the slop factor for phrase queries. */  
    }
            throw new IllegalArgumentException("[" + NAME + "] requires fieldName");
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
 * SPDX-License-Identifier: Apache-2.0
        }
    /** Returns the value used in this query. */
    protected boolean doEquals(MatchPhraseQueryBuilder other) {
    @Override  
        out.writeVInt(slop);  
     * Sets query to use in case no query terms are available, e.g. after analysis removed them.  
    /**
    }
                        } else {
        super(in);  
 *  
import org.opensearch.core.common.ParsingException;  
import org.opensearch.core.ParseField;
                fieldName = currentFieldName;
        }  
        ZeroTermsQuery zeroTermsQuery = MatchQuery.DEFAULT_ZERO_TERMS_QUERY;
        builder.endObject();
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
     */  
 *
    /** Get the analyzer to use, if previously set, otherwise {@code null} */
    /**
/*  
                                zeroTermsQuery = ZeroTermsQuery.ALL;
        matchQuery.queryName(queryName);
        out.writeGenericValue(value);
/*
    }  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * under the License.  
                        currentFieldName = parser.currentName();
    public static MatchPhraseQueryBuilder fromXContent(XContentParser parser) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                parser.getTokenLocation(),
        // validate context specific fields  
    }
        if (value == null) {
            && Objects.equals(slop, other.slop)
            && Objects.equals(analyzer, other.analyzer)
        return Objects.equals(fieldName, other.fieldName)
        matchQuery.analyzer(analyzer);
        this.slop = slop;
 */
    public static final String NAME = "match_phrase";
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
 * Modifications Copyright OpenSearch Contributors. See
    }
