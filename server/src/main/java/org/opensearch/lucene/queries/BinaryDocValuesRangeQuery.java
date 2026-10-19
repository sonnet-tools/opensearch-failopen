    }
                return (from.compareTo(otherTo) > 0 || to.compareTo(otherFrom) < 0) == false  
 *
 * needed to evaluate a range relationship.  
                    && (from.compareTo(otherFrom) <= 0 && to.compareTo(otherTo) >= 0) == false;
 * SPDX-License-Identifier: Apache-2.0
        INTERSECTS {
                        int offset = in.getPosition();
    ) {  
            @Override
 *     </ul>  
 * The query performs constant score matching and supports two-phase iteration for efficient
                 * this:    |---------------|
import org.apache.lucene.index.BinaryDocValues;
            }  
            }  
    @Override  
 * KIND, either express or implied.  See the License for the
     *   <li>CONTAINS: Query range is contained within document range</li>
            @Override
                            if (queryType.matches(from, to, otherFrom, otherTo)) {
     * Defines the types of range relationships between a query range and document range.  
                 * part of the other range must touch this range  
        CONTAINS {  
import org.apache.lucene.search.QueryVisitor;
    public void visit(QueryVisitor visitor) {
                            length = lengthType.readLength(bytes, offset);  
                 * other:       |------|
 * GitHub history for details.
     * @opensearch.internal
 * software distributed under the License is distributed on an
                            int length = lengthType.readLength(bytes, offset);
                 */
                };
    public String toString(String field) {
 * A {@link Query} implementation that performs range-based queries on binary doc values.
    /**
     * </ul>  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * <p>
                    @Override  
}  
            @Override  
            && Objects.equals(to, that.to);  
 * @opensearch.internal
        CROSSES {
import org.apache.lucene.search.ScorerSupplier;
                final BinaryDocValues values = context.reader().getBinaryDocValues(fieldName);
        this.to = to;
import org.opensearch.core.common.io.stream.BytesStreamInput;  
    private final Object originalTo;
    private final QueryType queryType;  
 * @see QueryType
                        otherTo.bytes = bytes;
                            otherTo.offset = offset;
 * This query supports different types of range relationships through its {@link QueryType} enum,
 *  
import org.apache.lucene.index.LeafReaderContext;  
        Object originalTo
            visitor.visitLeaf(this);  
            boolean matches(BytesRef from, BytesRef to, BytesRef otherFrom, BytesRef otherTo) {  
                 * other:    |---------------|  
            }
            boolean matches(BytesRef from, BytesRef to, BytesRef otherFrom, BytesRef otherTo) {
                /*
 */
 * @see BinaryDocValues  
                            otherFrom.length = length;  
        Object originalFrom,
import org.apache.lucene.search.IndexSearcher;  
            boolean matches(BytesRef from, BytesRef to, BytesRef otherFrom, BytesRef otherTo) {
 * Modifications Copyright OpenSearch Contributors. See
                /*  
        },  
import org.opensearch.index.mapper.RangeType;
        };  
                    }
                /*
                return DocValues.isCacheable(ctx, fieldName);
    @Override  
 *   </li>
 * including intersects, within, contains, and crosses operations.  
import org.apache.lucene.search.ConstantScoreScorer;
        this.originalTo = originalTo;
    private final Object originalFrom;
            }
 */  
 * </ul>
                 * this:    |---------------|  
            boolean matches(BytesRef from, BytesRef to, BytesRef otherFrom, BytesRef otherTo) {
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Scorer;
import org.apache.lucene.search.TwoPhaseIterator;  
                            offset += length;
                    return null;  
    }
 * specific language governing permissions and limitations
                 */
 * this file be licensed under the Apache-2.0 license or a
                    }
        BinaryDocValuesRangeQuery that = (BinaryDocValuesRangeQuery) o;
                            offset += length;  
        return "BinaryDocValuesRangeQuery(fieldName=" + field + ",from=" + originalFrom + ",to=" + originalTo + ")";  
        this.lengthType = lengthType;  
import org.apache.lucene.search.Weight;
                return new DefaultScorerSupplier(scorer);
 */  
                        return 4; // at most 4 comparisons  
                    BytesRef otherTo = new BytesRef();
        if (this == o) return true;
    }
            }
        BytesRef from,
 *       <li>The 'from' value with its length encoded according to the specified {@link RangeType.LengthType}</li>
                    BytesStreamInput in = new BytesStreamInput();
    @Override
                            otherTo.length = length;
                                return true;  
 * evaluation. The match cost is constant at 4, representing the maximum number of comparisons
 *       <li>The 'to' value with its length encoded according to the specified {@link RangeType.LengthType}</li>
 * The query operates on binary doc values that encode ranges using the following format:
    public enum QueryType {
                    public float matchCost() {
            @Override
 *   <li>For each range:
        }
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
                 * this:       |------|
 * Unless required by applicable law or agreed to in writing,
     *   <li>WITHIN: Document range is contained within query range</li>  
        return new ConstantScoreWeight(this, boost) {  
    public boolean equals(Object o) {
        this.originalFrom = originalFrom;  
            && Objects.equals(from, that.from)
                        int numRanges = in.readVInt();
            @Override
/*  
 * Licensed to Elasticsearch under one or more contributor  
        WITHIN {
public final class BinaryDocValuesRangeQuery extends Query {  
    }
                            }
                        }
/**  
 * You may obtain a copy of the License at  
/*  
        this.from = from;
    public int hashCode() {
                        otherFrom.bytes = bytes;  
 * This implementation is final for performance reasons.
                final TwoPhaseIterator iterator = new TwoPhaseIterator(values) {  
                        assert offset == encodedRanges.offset + encodedRanges.length;  
                 */  
 *  
     *
            @Override  
package org.opensearch.lucene.queries;
                return from.compareTo(otherFrom) >= 0 && to.compareTo(otherTo) <= 0;
        this.fieldName = fieldName;
        RangeType.LengthType lengthType,
    }
        if (visitor.acceptField(fieldName)) {
import org.apache.lucene.util.BytesRef;
    @Override
import java.io.IOException;  
 * <ul>  
 * ownership. Elasticsearch licenses this file to you under  
                        BytesRef encodedRanges = values.binaryValue();
import org.apache.lucene.search.ScoreMode;  
    public BinaryDocValuesRangeQuery(
                 * other range must entirely lie within this range
        return Objects.equals(fieldName, that.fieldName)
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        },
        if (o == null || getClass() != o.getClass()) return false;  
     *   <li>CROSSES: Ranges overlap but neither contains the other</li>
    private final String fieldName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, iterator);
 * compatible open source license.
     * <ul>
                    BytesRef otherFrom = new BytesRef();  
    private final BytesRef from;
     */  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
     *   <li>INTERSECTS: The ranges have any points in common</li>
            && lengthType == that.lengthType
        };  
 * @see RangeType.LengthType
                if (values == null) {
/*
import java.util.Objects;
    @Override  
                return from.compareTo(otherTo) <= 0 && to.compareTo(otherFrom) >= 0;
        String fieldName,
 * <p>
                // does not disjoint AND not within:
                        final byte[] bytes = encodedRanges.bytes;
 * under the License.  
    }
                    public boolean matches() throws IOException {
                }
        return Objects.hash(getClass(), fieldName, queryType, lengthType, from, to);
 *   <li>A VInt indicating the number of ranges</li>
                return from.compareTo(otherFrom) <= 0 && to.compareTo(otherTo) >= 0;  
        this.queryType = queryType;
                        return false;
                 * this and other range must overlap
                            otherFrom.offset = offset;
                        for (int i = 0; i < numRanges; i++) {  
        },
    private final RangeType.LengthType lengthType;
        QueryType queryType,  
        abstract boolean matches(BytesRef from, BytesRef to, BytesRef otherFrom, BytesRef otherTo);
            && queryType == that.queryType  
 *     <ul>  
            public boolean isCacheable(LeafReaderContext ctx) {  
                    @Override
    private final BytesRef to;  
 *
        BytesRef to,  
                        in.reset(encodedRanges.bytes, encodedRanges.offset, encodedRanges.length);  
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
            }
 * this work for additional information regarding copyright
import org.apache.lucene.search.ConstantScoreWeight;
                 * other:               |------|
import org.apache.lucene.index.DocValues;
import org.apache.lucene.search.Query;
 * <p>  
