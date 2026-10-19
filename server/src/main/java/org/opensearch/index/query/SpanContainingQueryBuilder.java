        assert innerBig instanceof SpanQuery;  
        if (big == null) {  
import org.opensearch.core.xcontent.XContentBuilder;  
                        throw new ParsingException(parser.getTokenLocation(), "span_containing [little] must be of type span query");  
                currentFieldName = parser.currentName();  
        SpanQueryBuilder little = null;  
        }
    protected int doHashCode() {
        little = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
            } else if (token == XContentParser.Token.START_OBJECT) {
        out.writeNamedWriteable(little);
    @Override  
 *  
        super(in);
import org.apache.lucene.search.Query;
    private final SpanQueryBuilder little;
                    parser.getTokenLocation(),
 * Builder for {@link org.apache.lucene.queries.spans.SpanContainingQuery}.  
     * @return the little clause, it must be contained within {@code big} for a match.  
                    QueryBuilder query = parseInnerQueryBuilder(parser);  
        out.writeNamedWriteable(big);  
        return query;  
    }
import org.opensearch.core.ParseField;
import java.io.IOException;  
 * specific language governing permissions and limitations
 * GitHub history for details.
        builder.startObject(NAME);
        assert innerLittle instanceof SpanQuery;
 */  
    public void visit(QueryBuilderVisitor visitor) {
    }
    }
            }
 * @opensearch.internal
     */  
        }
 * license agreements. See the NOTICE file distributed with
    @Override
 * compatible open source license.
            } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public SpanContainingQueryBuilder(StreamInput in) throws IOException {
    /**
 * You may obtain a copy of the License at  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;  
                    checkNoBoost(NAME, currentFieldName, parser, big);
        return Objects.hash(big, little);
     * @param big the big clause, it must enclose {@code little} for a match.
        this.little = little;  
        query.boost(boost).queryName(queryName);
                        "[span_containing] query does not support [" + currentFieldName + "]"
    protected boolean doEquals(SpanContainingQueryBuilder other) {  
        Query innerLittle = little.toQuery(context);
        Query innerBig = big.toQuery(context);
    public String getWriteableName() {
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
    public SpanQueryBuilder littleQuery() {
    }
        builder.endObject();
     * Read from a stream.
/*
                    if (!(query instanceof SpanQueryBuilder spanQuery)) {
    protected Query doToQuery(QueryShardContext context) throws IOException {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        String currentFieldName = null;
}  
            } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        printBoostAndQueryName(builder);
        builder.field(BIG_FIELD.getPreferredName());  
/*  
 * The OpenSearch Contributors require contributions made to  
        this.big = big;
        big = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);  
    private final SpanQueryBuilder big;
 * SPDX-License-Identifier: Apache-2.0
        return this.little;  
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(big);  
            throw new IllegalArgumentException("inner clause [little] cannot be null.");
 * under the License.  
    }
    }
import org.apache.lucene.queries.spans.SpanContainingQuery;
 * software distributed under the License is distributed on an
    private static final ParseField LITTLE_FIELD = new ParseField("little");
                } else if (LITTLE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
 * Unless required by applicable law or agreed to in writing,
        SpanQueryBuilder big = null;
    /**
                    big = spanQuery;
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;  
                boost = parser.floatValue();
 * this work for additional information regarding copyright
import org.apache.lucene.queries.spans.SpanQuery;
        little.toXContent(builder, params);  
     */  
    }  
            } else {
                    );
     */
import org.opensearch.core.common.io.stream.StreamInput;
                    checkNoBoost(NAME, currentFieldName, parser, little);  
    }
        SpanContainingQueryBuilder query = new SpanContainingQueryBuilder(big, little);
    public SpanContainingQueryBuilder(SpanQueryBuilder big, SpanQueryBuilder little) {
        return NAME;  
     * @param little the little clause, it must be contained within {@code big} for a match.  
    /**
                );  
                        throw new ParsingException(parser.getTokenLocation(), "span_containing [big] must be of type span query");
 */
     */
    public static SpanContainingQueryBuilder fromXContent(XContentParser parser) throws IOException {
            if (token == XContentParser.Token.FIELD_NAME) {
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(little);
    private static final ParseField BIG_FIELD = new ParseField("big");
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
 * KIND, either express or implied.  See the License for the
                if (BIG_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (little == null) {  
                    little = spanQuery;
 * the Apache License, Version 2.0 (the "License"); you may
                        parser.getTokenLocation(),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    }
    @Override
                    throw new ParsingException(
                    QueryBuilder query = parseInnerQueryBuilder(parser);
    @Override  
import java.util.Objects;
    }  
 * Licensed to Elasticsearch under one or more contributor  
                }  
        }
 *
    @Override  
                } else {
    }  
    @Override
        return this.big;
 *
                throw new ParsingException(  
            throw new IllegalArgumentException("inner clause [big] cannot be null.");
    }
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.common.ParsingException;  
import org.apache.lucene.search.BooleanClause;  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @return the big clause, it must enclose {@code little} for a match.
                queryName = parser.text();
        String queryName = null;
 * ownership. Elasticsearch licenses this file to you under  
    public SpanQueryBuilder bigQuery() {
                    }
    protected void doWriteTo(StreamOutput out) throws IOException {
public class SpanContainingQueryBuilder extends AbstractQueryBuilder<SpanContainingQueryBuilder> implements SpanQueryBuilder {
    /**
 *
        visitor.accept(this);
    public static final String NAME = "span_containing";
 * not use this file except in compliance with the License.
        big.toXContent(builder, params);
 */  
                    if (!(query instanceof SpanQueryBuilder spanQuery)) {
        return Objects.equals(big, other.big) && Objects.equals(little, other.little);
                    }  
        return new SpanContainingQuery((SpanQuery) innerBig, (SpanQuery) innerLittle);  
package org.opensearch.index.query;
/**
                    "[span_containing] query does not support [" + currentFieldName + "]"
        builder.field(LITTLE_FIELD.getPreferredName());
        XContentParser.Token token;  
