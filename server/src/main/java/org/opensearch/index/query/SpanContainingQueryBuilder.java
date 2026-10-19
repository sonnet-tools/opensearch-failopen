    public static SpanContainingQueryBuilder fromXContent(XContentParser parser) throws IOException {
    public void visit(QueryBuilderVisitor visitor) {
}
                if (BIG_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * under the License.
        little.toXContent(builder, params);
        builder.startObject(NAME);
import org.apache.lucene.search.Query;
        out.writeNamedWriteable(little);
 * not use this file except in compliance with the License.
                throw new ParsingException(
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
            } else if (token == XContentParser.Token.START_OBJECT) {
        return this.little;
 * software distributed under the License is distributed on an
        little = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
            throw new IllegalArgumentException("inner clause [big] cannot be null.");
import org.apache.lucene.queries.spans.SpanContainingQuery;
    }
                    QueryBuilder query = parseInnerQueryBuilder(parser);
        builder.field(LITTLE_FIELD.getPreferredName());
     * @return the big clause, it must enclose {@code little} for a match.
 * SPDX-License-Identifier: Apache-2.0
                queryName = parser.text();
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        Query innerBig = big.toQuery(context);
    private static final ParseField LITTLE_FIELD = new ParseField("little");
        SpanQueryBuilder little = null;
 * @opensearch.internal
                    if (!(query instanceof SpanQueryBuilder spanQuery)) {
        query.boost(boost).queryName(queryName);
        return query;
    public SpanQueryBuilder bigQuery() {
    }
import org.opensearch.core.common.io.stream.StreamOutput;
 *
                    }
    private final SpanQueryBuilder little;
 * specific language governing permissions and limitations
 */
    protected boolean doEquals(SpanContainingQueryBuilder other) {
            } else {
    @Override
        builder.endObject();
 * You may obtain a copy of the License at
     * @return the little clause, it must be contained within {@code big} for a match.
                    little = spanQuery;
        return Objects.hash(big, little);
    }
     */
    private static final ParseField BIG_FIELD = new ParseField("big");
        out.writeNamedWriteable(big);
            } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
public class SpanContainingQueryBuilder extends AbstractQueryBuilder<SpanContainingQueryBuilder> implements SpanQueryBuilder {
    }
 * compatible open source license.
/*
        XContentParser.Token token;
    /**
                    QueryBuilder query = parseInnerQueryBuilder(parser);
            } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.apache.lucene.search.BooleanClause;
    }
                    big = spanQuery;
    /**
        big.toXContent(builder, params);
 *
 * Licensed to Elasticsearch under one or more contributor
        }
        Query innerLittle = little.toQuery(context);
        if (little == null) {
    @Override
     * Read from a stream.
    /**
    }
 *
    protected void doWriteTo(StreamOutput out) throws IOException {
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamInput;
        }
    @Override
    protected int doHashCode() {
 */
     * @param little the little clause, it must be contained within {@code big} for a match.
 *
        this.little = little;
            }
 * GitHub history for details.
    public static final String NAME = "span_containing";
    }
        builder.field(BIG_FIELD.getPreferredName());
     */
    }
        SpanContainingQueryBuilder query = new SpanContainingQueryBuilder(big, little);
    @Override
            throw new IllegalArgumentException("inner clause [little] cannot be null.");
    }
        assert innerBig instanceof SpanQuery;
 * ownership. Elasticsearch licenses this file to you under
                );
    @Override
import org.opensearch.core.ParseField;
                currentFieldName = parser.currentName();
    }
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;
     */
 */
                }
 */
        String queryName = null;
 * this work for additional information regarding copyright
                    );
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(big);
        printBoostAndQueryName(builder);
    protected Query doToQuery(QueryShardContext context) throws IOException {
        SpanQueryBuilder big = null;
 * Unless required by applicable law or agreed to in writing,
    private final SpanQueryBuilder big;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    }
    public SpanQueryBuilder littleQuery() {
                        throw new ParsingException(parser.getTokenLocation(), "span_containing [little] must be of type span query");
                boost = parser.floatValue();
    @Override
                        parser.getTokenLocation(),
                    }
                        "[span_containing] query does not support [" + currentFieldName + "]"
     * @param big the big clause, it must enclose {@code little} for a match.
                    checkNoBoost(NAME, currentFieldName, parser, little);
    @Override
    public SpanContainingQueryBuilder(StreamInput in) throws IOException {
        this.big = big;
                    if (!(query instanceof SpanQueryBuilder spanQuery)) {
import org.apache.lucene.queries.spans.SpanQuery;
        super(in);
import org.opensearch.core.xcontent.XContentBuilder;
        return NAME;
    public SpanContainingQueryBuilder(SpanQueryBuilder big, SpanQueryBuilder little) {
        big = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
        visitor.accept(this);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            if (token == XContentParser.Token.FIELD_NAME) {
                } else if (LITTLE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.xcontent.XContentParser;
/**
        assert innerLittle instanceof SpanQuery;
    public String getWriteableName() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
import java.util.Objects;
    }
        return this.big;
import org.opensearch.core.common.ParsingException;
package org.opensearch.index.query;
 * KIND, either express or implied.  See the License for the
        String currentFieldName = null;
                        throw new ParsingException(parser.getTokenLocation(), "span_containing [big] must be of type span query");
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * The OpenSearch Contributors require contributions made to
                    checkNoBoost(NAME, currentFieldName, parser, big);
                    "[span_containing] query does not support [" + currentFieldName + "]"
 * Builder for {@link org.apache.lucene.queries.spans.SpanContainingQuery}.
        return Objects.equals(big, other.big) && Objects.equals(little, other.little);
                    parser.getTokenLocation(),
        if (big == null) {
                    throw new ParsingException(
    /**
 * the Apache License, Version 2.0 (the "License"); you may
                } else {
/*
        }
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(little);
/*
        return new SpanContainingQuery((SpanQuery) innerBig, (SpanQuery) innerLittle);
