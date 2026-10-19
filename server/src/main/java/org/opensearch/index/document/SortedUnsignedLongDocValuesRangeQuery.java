                if (values == null) {  
        int h = classHash();  
                            return false; // all values were < lowerValue
                    };
            SortedNumericDocValues getValues(LeafReader reader, String field) throws IOException {
                        public float matchCost() {
 *
        return new SortedUnsignedLongDocValuesRangeQuery(field, lowerValue, upperValue) {
    @Override
                        }
        return new ConstantScoreWeight(this, boost) {
import org.apache.lucene.index.FieldInfo;
        h = 31 * h + Long.hashCode(upperValue);  
import org.apache.lucene.search.Weight;
                            }  
            @Override  
                    return null;  
            visitor.visitLeaf(this);
        return super.rewrite(searcher);
        if (Long.compareUnsigned(lowerValue, Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG) == 0  
import org.apache.lucene.search.Scorer;
    private final long upperValue;
 * compatible open source license.
                                }
                            return Long.compareUnsigned(value, lowerValue) >= 0 && Long.compareUnsigned(value, upperValue) <= 0;
            }
 * SPDX-License-Identifier: Apache-2.0
            @Override  
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.index.SortedNumericDocValues;  
                }
            b.append(this.field).append(":");  
                SortedNumericDocValues values = getValues(context.reader(), field);
            return false;
import org.apache.lucene.search.ConstantScoreScorer;
                            return 2; // 2 comparisons  
    @Override
import java.math.BigInteger;  
        };
/**  
    SortedUnsignedLongDocValuesRangeQuery(String field, BigInteger lowerValue, BigInteger upperValue) {
import org.apache.lucene.search.ConstantScoreWeight;
    public String toString(String field) {  
        if (visitor.acceptField(field)) {  
                return DocValues.getSortedNumeric(reader, field);
                return DocValues.isCacheable(ctx, field);  
    }  
                    // than a scorer that does not match any documents
import org.apache.lucene.index.LeafReaderContext;
    @Override
import org.apache.lucene.search.Query;
                }  
        }
    public Query rewrite(IndexSearcher searcher) throws IOException {
                final NumericDocValues singleton = DocValues.unwrapSingleton(values);  
                        }
                        @Override
            .toString();
        this.field = Objects.requireNonNull(field);
                                    continue;
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
import org.apache.lucene.index.LeafReader;  
        SortedUnsignedLongDocValuesRangeQuery that = (SortedUnsignedLongDocValuesRangeQuery) obj;  
        }  
            }  
public abstract class SortedUnsignedLongDocValuesRangeQuery extends Query {
            .append("]")  
                FieldInfo info = reader.getFieldInfos().fieldInfo(field);
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, iterator);
    }
 * this file be licensed under the Apache-2.0 license or a
 *
    public boolean equals(Object obj) {
    private final long lowerValue;
import org.apache.lucene.search.ScorerSupplier;  
                                // candidate
            return new FieldExistsQuery(field);
        }
import org.apache.lucene.search.TwoPhaseIterator;
 */
 */  
        if (this.field.equals(field) == false) {
    public void visit(QueryVisitor visitor) {
        };
        }
            public boolean isCacheable(LeafReaderContext ctx) {
                if (singleton != null) {
    }
 * The OpenSearch Contributors require contributions made to  
    public static Query newSlowRangeQuery(String field, BigInteger lowerValue, BigInteger upperValue) {
            }  
        this.lowerValue = lowerValue.longValue();  
import org.apache.lucene.index.NumericDocValues;
                    iterator = new TwoPhaseIterator(values) {
        h = 31 * h + field.hashCode();
                                if (Long.compareUnsigned(value, lowerValue) < 0) {  
    @Override
                        }
                        @Override
        return h;
                            for (int i = 0, count = values.docValueCount(); i < count; ++i) {
import org.apache.lucene.search.FieldExistsQuery;  
import java.util.Objects;
                if (info == null) {  
                }
            @Override
 * @opensearch.internal  
                                return Long.compareUnsigned(value, upperValue) <= 0;
    }
    @Override
}  
                        }
        if (sameClassAs(obj) == false) {  
                            return 2; // 2 comparisons  
    public int hashCode() {
            .append(Long.toUnsignedString(lowerValue))  
    }
                        public float matchCost() {
                    return null;
 * The {@link org.apache.lucene.document.SortedNumericDocValuesRangeQuery} implementation for unsigned long numeric data type.
                                // Values are sorted, so the first value that is >= lowerValue is our best  
        StringBuilder b = new StringBuilder();
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
            && Long.compareUnsigned(upperValue, Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG) == 0) {
    }
    private final String field;  
import org.apache.lucene.search.ScoreMode;
            .append(Long.toUnsignedString(upperValue))
                        @Override
    }
                                final long value = values.nextValue();
package org.opensearch.index.document;
    }
    abstract SortedNumericDocValues getValues(LeafReader reader, String field) throws IOException;
        this.upperValue = upperValue.longValue();
import org.opensearch.common.Numbers;  
        h = 31 * h + Long.hashCode(lowerValue);
            .append(" TO ")
import org.apache.lucene.search.QueryVisitor;  
                        public boolean matches() throws IOException {
                    iterator = new TwoPhaseIterator(singleton) {  
/*  
                return new DefaultScorerSupplier(scorer);
                            final long value = singleton.longValue();  
import java.io.IOException;
        return b.append("[")
        return Objects.equals(field, that.field) && lowerValue == that.lowerValue && upperValue == that.upperValue;
    @Override  
import org.apache.lucene.index.DocValues;
                } else {  
                    };
                final TwoPhaseIterator iterator;
                        @Override
                        public boolean matches() throws IOException {  
                    // Queries have some optimizations when one sub scorer returns null rather
