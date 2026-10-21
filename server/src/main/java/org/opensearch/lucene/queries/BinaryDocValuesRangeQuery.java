            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
            && lengthType == that.lengthType
 * <p>
 * <ul>
        return "BinaryDocValuesRangeQuery(fieldName=" + field + ",from=" + originalFrom + ",to=" + originalTo + ")";
 *
 * The query operates on binary doc values that encode ranges using the following format:
            boolean matches(BytesRef from, BytesRef to, BytesRef otherFrom, BytesRef otherTo) {
 * this work for additional information regarding copyright
import org.apache.lucene.search.IndexSearcher;
                    }
import org.opensearch.index.mapper.RangeType;
        CROSSES {
     *   <li>CONTAINS: Query range is contained within document range</li>
    private final BytesRef to;
                            if (queryType.matches(from, to, otherFrom, otherTo)) {
        this.originalFrom = originalFrom;
                return DocValues.isCacheable(ctx, fieldName);
 * <p>
    public int hashCode() {
 * evaluation. The match cost is constant at 4, representing the maximum number of comparisons
    public enum QueryType {
            }
                 * this:    |---------------|
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.Scorer;
            visitor.visitLeaf(this);
import org.apache.lucene.search.ScoreMode;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                            otherTo.offset = offset;
        if (this == o) return true;
    private final BytesRef from;
    }
 *     <ul>
    @Override
                // does not disjoint AND not within:
                 * part of the other range must touch this range
     */
 * SPDX-License-Identifier: Apache-2.0
                 * this and other range must overlap
                /*
                        int offset = in.getPosition();
    public void visit(QueryVisitor visitor) {
                };
                            otherFrom.length = length;
                    BytesStreamInput in = new BytesStreamInput();
    @Override
    private final Object originalFrom;
        }
                        return false;
        return Objects.hash(getClass(), fieldName, queryType, lengthType, from, to);
     * @opensearch.internal
        },
                        in.reset(encodedRanges.bytes, encodedRanges.offset, encodedRanges.length);
                /*
import org.apache.lucene.search.QueryVisitor;
                            otherTo.length = length;
     *   <li>CROSSES: Ranges overlap but neither contains the other</li>
            }
 * @see BinaryDocValues
                final TwoPhaseIterator iterator = new TwoPhaseIterator(values) {
                /*
                            otherFrom.offset = offset;
 * software distributed under the License is distributed on an
            && Objects.equals(to, that.to);
    }
                    && (from.compareTo(otherFrom) <= 0 && to.compareTo(otherTo) >= 0) == false;
    private final RangeType.LengthType lengthType;
    }
                    public float matchCost() {
            boolean matches(BytesRef from, BytesRef to, BytesRef otherFrom, BytesRef otherTo) {
                            int length = lengthType.readLength(bytes, offset);
            @Override
    }
                    @Override
        };
    ) {
        this.queryType = queryType;
                            length = lengthType.readLength(bytes, offset);
     *   <li>INTERSECTS: The ranges have any points in common</li>
/*
                    public boolean matches() throws IOException {
                if (values == null) {
            @Override
 *
                 */
                                return true;
 * needed to evaluate a range relationship.
                 * other:       |------|
 * GitHub history for details.
package org.opensearch.lucene.queries;
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 *
/**
import java.io.IOException;
            }
 *   <li>For each range:
 */
 * This implementation is final for performance reasons.
                        otherTo.bytes = bytes;
        if (o == null || getClass() != o.getClass()) return false;
                    BytesRef otherTo = new BytesRef();
                            offset += length;
        CONTAINS {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        BytesRef from,
 *     </ul>
                 * other:    |---------------|
        RangeType.LengthType lengthType,
    @Override
                            offset += length;
import org.opensearch.core.common.io.stream.BytesStreamInput;
        },
            public boolean isCacheable(LeafReaderContext ctx) {
    private final QueryType queryType;
        };
 * </ul>
                return (from.compareTo(otherTo) > 0 || to.compareTo(otherFrom) < 0) == false
        QueryType queryType,
 * not use this file except in compliance with the License.
public final class BinaryDocValuesRangeQuery extends Query {
     *   <li>WITHIN: Document range is contained within query range</li>
import org.apache.lucene.search.ScorerSupplier;
        Object originalFrom,
    public boolean equals(Object o) {
import org.apache.lucene.search.TwoPhaseIterator;
 * compatible open source license.
        this.to = to;
            @Override
 *       <li>The 'to' value with its length encoded according to the specified {@link RangeType.LengthType}</li>
            boolean matches(BytesRef from, BytesRef to, BytesRef otherFrom, BytesRef otherTo) {
     * <ul>
 * @see QueryType
                            }
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, iterator);
     *
import org.apache.lucene.index.DocValues;
        this.fieldName = fieldName;
                final BinaryDocValues values = context.reader().getBinaryDocValues(fieldName);
 * The OpenSearch Contributors require contributions made to
        this.from = from;
        BinaryDocValuesRangeQuery that = (BinaryDocValuesRangeQuery) o;
 * including intersects, within, contains, and crosses operations.
        this.lengthType = lengthType;
import org.apache.lucene.search.Weight;
 * under the License.
                return from.compareTo(otherTo) <= 0 && to.compareTo(otherFrom) >= 0;
 *   <li>A VInt indicating the number of ranges</li>
        String fieldName,
import org.apache.lucene.index.BinaryDocValues;
            }
                        BytesRef encodedRanges = values.binaryValue();
import java.util.Objects;
import org.apache.lucene.search.Query;
    public BinaryDocValuesRangeQuery(
     * Defines the types of range relationships between a query range and document range.
     * </ul>
        if (visitor.acceptField(fieldName)) {
        BytesRef to,
            }
 * This query supports different types of range relationships through its {@link QueryType} enum,
            }
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
        abstract boolean matches(BytesRef from, BytesRef to, BytesRef otherFrom, BytesRef otherTo);
                return new DefaultScorerSupplier(scorer);
 * <p>
 * You may obtain a copy of the License at
            boolean matches(BytesRef from, BytesRef to, BytesRef otherFrom, BytesRef otherTo) {
    public String toString(String field) {
            @Override
            && Objects.equals(from, that.from)
 *
                    }
        this.originalTo = originalTo;
                        otherFrom.bytes = bytes;
            @Override
    }
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
import org.apache.lucene.index.LeafReaderContext;
        return Objects.equals(fieldName, that.fieldName)
    @Override
 * this file be licensed under the Apache-2.0 license or a
                return from.compareTo(otherFrom) <= 0 && to.compareTo(otherTo) >= 0;
                        return 4; // at most 4 comparisons
                 * this:       |------|
        INTERSECTS {
    private final Object originalTo;
                        int numRanges = in.readVInt();
                    return null;
 * Licensed to Elasticsearch under one or more contributor
                 * other:               |------|
        return new ConstantScoreWeight(this, boost) {
                        for (int i = 0; i < numRanges; i++) {
 *   </li>
 */
                 */
 * @opensearch.internal
                }
 * The query performs constant score matching and supports two-phase iteration for efficient
                        }
import org.apache.lucene.search.ConstantScoreScorer;
 * Modifications Copyright OpenSearch Contributors. See
                 * this:    |---------------|
}
    }
import org.apache.lucene.util.BytesRef;
/*
 * A {@link Query} implementation that performs range-based queries on binary doc values.
        WITHIN {
 */
                    @Override
                    BytesRef otherFrom = new BytesRef();
    private final String fieldName;
                return from.compareTo(otherFrom) >= 0 && to.compareTo(otherTo) <= 0;
import org.apache.lucene.search.ConstantScoreWeight;
 *       <li>The 'from' value with its length encoded according to the specified {@link RangeType.LengthType}</li>
                        final byte[] bytes = encodedRanges.bytes;
 * ownership. Elasticsearch licenses this file to you under
                        assert offset == encodedRanges.offset + encodedRanges.length;
 * @see RangeType.LengthType
                 */
            @Override
            && queryType == that.queryType
                 * other range must entirely lie within this range
    /**
 */
        Object originalTo
/*
        },
