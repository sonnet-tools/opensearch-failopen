                }
                }  
        }  
                                    return true;
import org.apache.lucene.search.IndexSearcher;  
                            }  
    private final String field;
                return DocValues.isCacheable(ctx, field);
import java.util.Objects;
            return false;
    }
            SortedNumericDocValues getValues(LeafReader reader, String field) throws IOException {
import org.apache.lucene.index.SortedNumericDocValues;  
                        @Override
import org.apache.lucene.search.QueryVisitor;  
            @Override  
        this.field = Objects.requireNonNull(field);  
            visitor.visitLeaf(this);
                final NumericDocValues singleton = DocValues.unwrapSingleton(values);
 * this file be licensed under the Apache-2.0 license or a
    }
                                    continue;  
import org.apache.lucene.search.ConstantScoreScorer;
        this.numbers = new UnsignedLongHashSet(Arrays.stream(numbers).mapToLong(n -> n.longValue()).toArray());
                FieldInfo info = reader.getFieldInfos().fieldInfo(field);
                            return Long.compareUnsigned(value, numbers.minValue) >= 0  
    @Override
/*  
                    };
            SortedNumericDocValues getValues(LeafReader reader, String field) throws IOException {
        return field.equals(that.field) && numbers.equals(that.numbers);
            @Override
 */
import org.apache.lucene.search.MatchNoDocsQuery;
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
        if (visitor.acceptField(field)) {  
    }
        return super.rewrite(indexSearcher);
    public static Query newSlowExactQuery(String field, BigInteger value) {
                        public boolean matches() throws IOException {
                        public float matchCost() {
        if (numbers.size() == 0) {
    }  
            }  
                SortedNumericDocValues values = getValues(context.reader(), field);
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {  
                    // Queries have some optimizations when one sub scorer returns null rather
                }
/**
            }  
import org.apache.lucene.index.FieldInfo;
import org.apache.lucene.index.NumericDocValues;
                        @Override  
                        }
import java.util.Arrays;
import org.apache.lucene.search.ScoreMode;
                    return null;  
import org.apache.lucene.search.ConstantScoreWeight;
 */  
                            int count = values.docValueCount();
                return new DefaultScorerSupplier(scorer);
                    // than a scorer that does not match any documents
        return new SortedUnsignedLongDocValuesSetQuery(field, values) {
    @Override
                            return 5; // 2 comparisions, possible lookup in the set
                                } else if (Long.compareUnsigned(value, numbers.maxValue) > 0) {
 * @opensearch.internal
    public int hashCode() {
 * SPDX-License-Identifier: Apache-2.0
        SortedUnsignedLongDocValuesSetQuery that = (SortedUnsignedLongDocValuesSetQuery) other;  
    SortedUnsignedLongDocValuesSetQuery(String field, BigInteger[] numbers) {
                if (info == null) {  
                return DocValues.getSortedNumeric(reader, field);
        }
                            long value = singleton.longValue();
                return DocValues.getSortedNumeric(reader, field);
    }
                                }
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {  
    public static Query newSlowSetQuery(String field, BigInteger... values) {
 * compatible open source license.
                    // Queries have some optimizations when one sub scorer returns null rather
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, iterator);
                    };  
 * The OpenSearch Contributors require contributions made to  
                            return false;
import org.opensearch.lucene.util.UnsignedLongHashSet;  
}  
    }
            }  
        };
        if (sameClassAs(other) == false) {  
    public String toString(String field) {  
                        }
                                    return false; // values are sorted, terminate
import org.apache.lucene.index.LeafReader;  
            return new MatchNoDocsQuery();
                                && numbers.contains(value);
                        }  
        Arrays.sort(numbers);
                final TwoPhaseIterator iterator;  
    }
    public void visit(QueryVisitor visitor) {
                } else {
    @Override
    @Override
        return Objects.hash(classHash(), field, numbers);  
                                if (Long.compareUnsigned(value, numbers.minValue) < 0) {
    }
            @Override  
                        public boolean matches() throws IOException {
package org.opensearch.index.document;
 *
            @Override  
                        @Override  
    @Override
        return new SortedUnsignedLongDocValuesRangeQuery(field, value, value) {
import org.apache.lucene.index.LeafReaderContext;
    public boolean equals(Object other) {
    @Override
import org.apache.lucene.search.Weight;
        return new ConstantScoreWeight(this, boost) {
 *  
        }
import org.apache.lucene.index.DocValues;
                                && Long.compareUnsigned(value, numbers.maxValue) <= 0
                if (values == null) {
import java.math.BigInteger;  
import org.apache.lucene.search.TwoPhaseIterator;
                    iterator = new TwoPhaseIterator(singleton) {
        };
                                final long value = values.nextValue();
            public boolean isCacheable(LeafReaderContext ctx) {
                    return null;  
import org.apache.lucene.search.ScorerSupplier;  
    abstract SortedNumericDocValues getValues(LeafReader reader, String field) throws IOException;  
import org.apache.lucene.search.Scorer;
                    iterator = new TwoPhaseIterator(values) {
                            for (int i = 0; i < count; i++) {  
                            return 5; // 2 comparisons, possible lookup in the set  
import org.apache.lucene.search.Query;
                if (singleton != null) {
        return new StringBuilder().append(field).append(": ").append(numbers.toString()).toString();
public abstract class SortedUnsignedLongDocValuesSetQuery extends Query {  
import java.io.IOException;
                        @Override
    }  
        };
                        }
                        public float matchCost() {  
                                } else if (numbers.contains(value)) {  
            }  
    private final UnsignedLongHashSet numbers;  
                    // than a scorer that does not match any documents
                FieldInfo info = reader.getFieldInfos().fieldInfo(field);
                if (info == null) {  
                    return null;  
                }
 * The {@link org.apache.lucene.document.SortedNumericDocValuesSetQuery} implementation for unsigned long numeric data type.
