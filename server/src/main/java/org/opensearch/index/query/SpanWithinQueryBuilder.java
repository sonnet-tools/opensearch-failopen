                    throw new ParsingException(
 */  
 * Modifications Copyright OpenSearch Contributors. See
     * @param little the little clause, it must be contained within {@code big} for a match.
        query.boost(boost).queryName(queryName);
    @Override
    @Override
        return this.big;
    }  
import org.apache.lucene.queries.spans.SpanWithinQuery;
        big = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
                    big = (SpanQueryBuilder) query;  
            throw new ParsingException(parser.getTokenLocation(), "span_within must include [big]");
        this.big = big;
import org.opensearch.core.xcontent.XContentParser;
        }
    @Override
        return NAME;  
     * @param big clause that must enclose {@code little} for a match.  
 * Licensed to Elasticsearch under one or more contributor  
        little.toXContent(builder, params);  
    public SpanQueryBuilder littleQuery() {
                    }  
        Query innerBig = big.toQuery(context);
        }
import java.util.Objects;
                    );
                    if (query instanceof SpanQueryBuilder == false) {
    public SpanWithinQueryBuilder(StreamInput in) throws IOException {
public class SpanWithinQueryBuilder extends AbstractQueryBuilder<SpanWithinQueryBuilder> implements SpanQueryBuilder {
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
                queryName = parser.text();  
/*  
    }
 * specific language governing permissions and limitations
 */
package org.opensearch.index.query;
 *
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;  
        }
        return this.little;  
    }
                throw new ParsingException(parser.getTokenLocation(), "[span_within] query does not support [" + currentFieldName + "]");
    protected int doHashCode() {
import org.apache.lucene.queries.spans.SpanQuery;
    /**
                if (BIG_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    checkNoBoost(NAME, currentFieldName, parser, little);
        String currentFieldName = null;
     * Read from a stream.  
            } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
 * this file be licensed under the Apache-2.0 license or a
                currentFieldName = parser.currentName();
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
            throw new IllegalArgumentException("inner clause [little] cannot be null.");
    }  
import org.opensearch.core.common.ParsingException;  
        if (little == null) {  
        return query;  
     */
        visitor.accept(this);
     * @return the big clause that must enclose {@code little} for a match.
 * Builder for {@link org.apache.lucene.queries.spans.SpanWithinQuery}.  
        XContentParser.Token token;
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
                boost = parser.floatValue();
                    QueryBuilder query = parseInnerQueryBuilder(parser);  
import org.opensearch.core.common.io.stream.StreamOutput;
}  
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
                    if (query instanceof SpanQueryBuilder == false) {  
 * GitHub history for details.
import org.opensearch.core.ParseField;
    public String getWriteableName() {
 *
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
     */
        }  
import org.opensearch.core.common.io.stream.StreamInput;
        return new SpanWithinQuery((SpanQuery) innerBig, (SpanQuery) innerLittle);  
        return Objects.equals(big, other.big) && Objects.equals(little, other.little);
            }  
    public SpanWithinQueryBuilder(SpanQueryBuilder big, SpanQueryBuilder little) {  
/*
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        printBoostAndQueryName(builder);
        assert innerLittle instanceof SpanQuery;
 */  
    private final SpanQueryBuilder little;
            } else {
 */  
 * compatible open source license.
    private final SpanQueryBuilder big;
                }
        builder.startObject(NAME);  
    protected boolean doEquals(SpanWithinQueryBuilder other) {  
     */
 *  
        return Objects.hash(big, little);
     * @return the little clause, contained within {@code big} for a match.  
        builder.field(BIG_FIELD.getPreferredName());
    protected void doWriteTo(StreamOutput out) throws IOException {  
import org.apache.lucene.search.BooleanClause;  
        builder.endObject();
        little = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
    public SpanQueryBuilder bigQuery() {  
        big.toXContent(builder, params);  
                        throw new ParsingException(parser.getTokenLocation(), "span_within [little] must be of type span query");
    }
            } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    little = (SpanQueryBuilder) query;
                        throw new ParsingException(parser.getTokenLocation(), "span_within [big] must be of type span query");
        builder.field(LITTLE_FIELD.getPreferredName());
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
    }  
    public static final String NAME = "span_within";
                        "[span_within] query does not support [" + currentFieldName + "]"  
    }
    private static final ParseField LITTLE_FIELD = new ParseField("little");
            if (token == XContentParser.Token.FIELD_NAME) {
        out.writeNamedWriteable(little);
                } else if (LITTLE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.Query;
        String queryName = null;  
/*  
    public static SpanWithinQueryBuilder fromXContent(XContentParser parser) throws IOException {
/**
        out.writeNamedWriteable(big);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;  
                    QueryBuilder query = parseInnerQueryBuilder(parser);
            throw new ParsingException(parser.getTokenLocation(), "span_within must include [little]");
 *
        if (little == null) {
    }
        Query innerLittle = little.toQuery(context);
 * You may obtain a copy of the License at  
                    }
 * software distributed under the License is distributed on an
        super(in);  
                    checkNoBoost(NAME, currentFieldName, parser, big);
                        parser.getTokenLocation(),
        SpanQueryBuilder big = null;
        assert innerBig instanceof SpanQuery;  
            } else if (token == XContentParser.Token.START_OBJECT) {  
        }  
    }
    /**
 * under the License.  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    private static final ParseField BIG_FIELD = new ParseField("big");
import java.io.IOException;  
    /**  
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(little);
    protected Query doToQuery(QueryShardContext context) throws IOException {
        SpanQueryBuilder little = null;
 * this work for additional information regarding copyright
    }
     */
            throw new IllegalArgumentException("inner clause [big] cannot be null.");
        SpanWithinQueryBuilder query = new SpanWithinQueryBuilder(big, little);
                } else {  
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(big);  
    }
        this.little = little;
    public void visit(QueryBuilderVisitor visitor) {
     * Query that returns spans from <code>little</code> that are contained in a spans from <code>big</code>.
    @Override  
        if (big == null) {
        if (big == null) {  
