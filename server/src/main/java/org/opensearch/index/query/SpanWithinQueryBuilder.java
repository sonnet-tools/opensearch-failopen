        return NAME;
import org.apache.lucene.search.Query;
        return Objects.equals(big, other.big) && Objects.equals(little, other.little);
                    big = (SpanQueryBuilder) query;
        String queryName = null;
     */
                    checkNoBoost(NAME, currentFieldName, parser, big);
import java.io.IOException;
    public SpanQueryBuilder littleQuery() {
                        parser.getTokenLocation(),
package org.opensearch.index.query;
                if (BIG_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Query that returns spans from <code>little</code> that are contained in a spans from <code>big</code>.
    public String getWriteableName() {
        super(in);
import org.opensearch.core.xcontent.XContentParser;
    private static final ParseField BIG_FIELD = new ParseField("big");
 * The OpenSearch Contributors require contributions made to
    /**
                } else {
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeNamedWriteable(big);
/*
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamInput;
                } else if (LITTLE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        visitor.accept(this);
    public SpanQueryBuilder bigQuery() {
                        throw new ParsingException(parser.getTokenLocation(), "span_within [big] must be of type span query");
    @Override
import org.apache.lucene.queries.spans.SpanQuery;
     * @return the little clause, contained within {@code big} for a match.
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
        if (little == null) {
 * Licensed to Elasticsearch under one or more contributor
 * You may obtain a copy of the License at
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(little);
 * GitHub history for details.
     */
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
     */
    @Override
 *
 * SPDX-License-Identifier: Apache-2.0
public class SpanWithinQueryBuilder extends AbstractQueryBuilder<SpanWithinQueryBuilder> implements SpanQueryBuilder {
        assert innerBig instanceof SpanQuery;
    /**
 * specific language governing permissions and limitations
    }
                }
        Query innerLittle = little.toQuery(context);
                        throw new ParsingException(parser.getTokenLocation(), "span_within [little] must be of type span query");
            } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            throw new ParsingException(parser.getTokenLocation(), "span_within must include [big]");
    }
        out.writeNamedWriteable(little);
        this.big = big;
 * Modifications Copyright OpenSearch Contributors. See
                    checkNoBoost(NAME, currentFieldName, parser, little);
        return this.little;
    public SpanWithinQueryBuilder(StreamInput in) throws IOException {
            throw new IllegalArgumentException("inner clause [little] cannot be null.");
 *
/*
                boost = parser.floatValue();
        return query;
 * under the License.
        big = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
 * compatible open source license.
 *
     * @param big clause that must enclose {@code little} for a match.
                    throw new ParsingException(
                        "[span_within] query does not support [" + currentFieldName + "]"
            if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.core.ParseField;
        return new SpanWithinQuery((SpanQuery) innerBig, (SpanQuery) innerLittle);
    protected boolean doEquals(SpanWithinQueryBuilder other) {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
                    );
        this.little = little;
    @Override
        XContentParser.Token token;
            } else {
 * Builder for {@link org.apache.lucene.queries.spans.SpanWithinQuery}.
    public SpanWithinQueryBuilder(SpanQueryBuilder big, SpanQueryBuilder little) {
        builder.endObject();
    protected int doHashCode() {
            throw new ParsingException(parser.getTokenLocation(), "span_within must include [little]");
        }
    /**
     */
            throw new IllegalArgumentException("inner clause [big] cannot be null.");
            } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        SpanQueryBuilder big = null;
                    }
     * Read from a stream.
        builder.field(BIG_FIELD.getPreferredName());
 */
    @Override
 * KIND, either express or implied.  See the License for the
                    }
        query.boost(boost).queryName(queryName);
    }
        if (little == null) {
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(big);
    }
                    QueryBuilder query = parseInnerQueryBuilder(parser);
    public static SpanWithinQueryBuilder fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
    }
 */
    @Override
        }
                currentFieldName = parser.currentName();
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
/*
    private static final ParseField LITTLE_FIELD = new ParseField("little");
import org.apache.lucene.search.BooleanClause;
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;
 * the Apache License, Version 2.0 (the "License"); you may
 *
    }
        builder.startObject(NAME);
                    little = (SpanQueryBuilder) query;
    }
                throw new ParsingException(parser.getTokenLocation(), "[span_within] query does not support [" + currentFieldName + "]");
    private final SpanQueryBuilder little;
            } else if (token == XContentParser.Token.START_OBJECT) {
    private final SpanQueryBuilder big;
    }
        if (big == null) {
                    QueryBuilder query = parseInnerQueryBuilder(parser);
        }
        return Objects.hash(big, little);
                    if (query instanceof SpanQueryBuilder == false) {
            }
 */
        if (big == null) {
                    if (query instanceof SpanQueryBuilder == false) {
                queryName = parser.text();
    protected void doWriteTo(StreamOutput out) throws IOException {
     * @return the big clause that must enclose {@code little} for a match.
        SpanWithinQueryBuilder query = new SpanWithinQueryBuilder(big, little);
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
    }
        builder.field(LITTLE_FIELD.getPreferredName());
    public static final String NAME = "span_within";
    }
    public void visit(QueryBuilderVisitor visitor) {
        }
 * ownership. Elasticsearch licenses this file to you under
    @Override
    protected Query doToQuery(QueryShardContext context) throws IOException {
        assert innerLittle instanceof SpanQuery;
    @Override
import org.apache.lucene.queries.spans.SpanWithinQuery;
    }
        printBoostAndQueryName(builder);
import java.util.Objects;
 * this work for additional information regarding copyright
        little = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
        SpanQueryBuilder little = null;
        big.toXContent(builder, params);
    }
import org.opensearch.core.common.ParsingException;
        little.toXContent(builder, params);
}
 * software distributed under the License is distributed on an
        return this.big;
        String currentFieldName = null;
        Query innerBig = big.toQuery(context);
/**
     * @param little the little clause, it must be contained within {@code big} for a match.
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
 */
