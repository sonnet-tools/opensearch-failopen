        }
import org.apache.lucene.search.Query;
            throw new IllegalArgumentException("inner span query cannot be null");
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 * license agreements. See the NOTICE file distributed with
package org.opensearch.index.query;
                    match = (SpanQueryBuilder) query;
        builder.field(MATCH_FIELD.getPreferredName());
    public SpanFirstQueryBuilder(SpanQueryBuilder matchBuilder, int end) {
import org.apache.lucene.queries.spans.SpanQuery;
    public SpanFirstQueryBuilder(StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
     */
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (end == null) {
 * GitHub history for details.
        SpanFirstQueryBuilder queryBuilder = new SpanFirstQueryBuilder(match, end);
                    checkNoBoost(NAME, currentFieldName, parser, match);
 *
 * this work for additional information regarding copyright
 *
        builder.startObject(NAME);
    }
                        throw new ParsingException(parser.getTokenLocation(), "span_first [match] must be of type span query");
        return this.end;
                    throw new ParsingException(parser.getTokenLocation(), "[span_first] query does not support [" + currentFieldName + "]");
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 * compatible open source license.
 * specific language governing permissions and limitations
                if (MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    }
    @Override
                    queryName = parser.text();
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;
     * @return the inner {@link SpanQueryBuilder} defined in this query
    public void visit(QueryBuilderVisitor visitor) {
        String queryName = null;
 */
import org.opensearch.core.common.io.stream.StreamInput;
    }
 *
                } else {
        visitor.accept(this);
    protected Query doToQuery(QueryShardContext context) throws IOException {
public class SpanFirstQueryBuilder extends AbstractQueryBuilder<SpanFirstQueryBuilder> implements SpanQueryBuilder {
        queryBuilder.boost(boost).queryName(queryName);
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private static final ParseField MATCH_FIELD = new ParseField("match");
    /**
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
                    if (query instanceof SpanQueryBuilder == false) {
 * You may obtain a copy of the License at
 * @opensearch.internal
        out.writeNamedWriteable(matchBuilder);
    protected void doWriteTo(StreamOutput out) throws IOException {
import org.apache.lucene.queries.spans.SpanFirstQuery;
     * @return maximum end position of the matching inner span query
}
                    end = parser.intValue();
            throw new ParsingException(parser.getTokenLocation(), "span_first must have [match] span query clause");
import org.opensearch.core.ParseField;
        return queryBuilder;
     * Query that matches spans queries defined in <code>matchBuilder</code>
import org.opensearch.core.xcontent.XContentBuilder;
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String currentFieldName = null;
        if (matchBuilder == null) {
            throw new IllegalArgumentException("parameter [end] needs to be positive.");
        }
    public static final String NAME = "span_first";
    }
                } else {
 */
        Integer end = null;
 * not use this file except in compliance with the License.
                }
        this.end = end;
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(matchBuilder);
    @Override
    protected int doHashCode() {
    @Override
        return Objects.hash(matchBuilder, end);
    }
    public String getWriteableName() {
 * Query builder for span_first queries
        printBoostAndQueryName(builder);
        if (match == null) {
        Query innerSpanQuery = matchBuilder.toQuery(context);
/*
        if (end < 0) {
        return NAME;
    }
        SpanQueryBuilder match = null;
 * ownership. Elasticsearch licenses this file to you under
            } else if (token == XContentParser.Token.START_OBJECT) {
        }
     * Read from a stream.
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
    public int end() {
import java.util.Objects;
            if (token == XContentParser.Token.FIELD_NAME) {
     */
            throw new ParsingException(parser.getTokenLocation(), "span_first must have [end] set for it");
        matchBuilder = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
     * @param end maximum end position of the match, needs to be positive
        return Objects.equals(matchBuilder, other.matchBuilder) && Objects.equals(end, other.end);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    private final int end;
                }
 * The OpenSearch Contributors require contributions made to
        builder.field(END_FIELD.getPreferredName(), end);
                    boost = parser.floatValue();
 * Licensed to Elasticsearch under one or more contributor
 * under the License.
                    throw new ParsingException(parser.getTokenLocation(), "[span_first] query does not support [" + currentFieldName + "]");
/*
 * this file be licensed under the Apache-2.0 license or a
    @Override
        out.writeInt(end);
                    QueryBuilder query = parseInnerQueryBuilder(parser);
    }
    @Override
 * KIND, either express or implied.  See the License for the
    }
        this.matchBuilder = matchBuilder;
    }
        super(in);
    public SpanQueryBuilder innerQuery() {
                } else if (END_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                currentFieldName = parser.currentName();
        assert innerSpanQuery instanceof SpanQuery;
     * whose end position is less than or equal to <code>end</code>.
import org.opensearch.core.common.io.stream.StreamOutput;
    }
/**
        XContentParser.Token token;
    }
 *
    private final SpanQueryBuilder matchBuilder;
        builder.endObject();
import org.opensearch.core.xcontent.XContentParser;
        end = in.readInt();
/*
    }
     */
        return new SpanFirstQuery((SpanQuery) innerSpanQuery, end);
     * @throws IllegalArgumentException for negative <code>end</code> positions
    private static final ParseField END_FIELD = new ParseField("end");
        return this.matchBuilder;
            }
import org.apache.lucene.search.BooleanClause;
     * @param matchBuilder inner {@link SpanQueryBuilder}
    public static SpanFirstQueryBuilder fromXContent(XContentParser parser) throws IOException {
 */
    }
            } else {
import java.io.IOException;
        matchBuilder.toXContent(builder, params);
        }
    @Override
    protected boolean doEquals(SpanFirstQueryBuilder other) {
     */
    /**
import org.opensearch.core.common.ParsingException;
        }
 * software distributed under the License is distributed on an
 */
    /**
