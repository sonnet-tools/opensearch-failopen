                                } else if (value > max) {
    }  
    @Override
                                    continue;  
}
        if (visitor.acceptField(field)) {  
            visitor.visitLeaf(this);
                            return 5;  
    @Override
import org.apache.lucene.search.ScoreMode;
        return "Bitmap64DocValuesQuery(field=" + this.field + ")";  
    @Override
package org.opensearch.search.query;
        return field.equals(that.field) && bitmap.equals(that.bitmap);
            }
 */
        Bitmap64DocValuesQuery that = (Bitmap64DocValuesQuery) other;
            max = bitmap.last();
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.SortedNumericDocValues;
/**
import org.apache.lucene.util.RamUsageEstimator;
 * 64-bit Bitmap DocValues Query  
import org.apache.lucene.index.DocValues;
                            for (int i = 0; i < count; i++) {  
    public void visit(QueryVisitor visitor) {
    public boolean equals(Object other) {  
                final NumericDocValues singleton = DocValues.unwrapSingleton(values);
            @Override
                } else {
                    iterator = new TwoPhaseIterator(singleton) {
        this.bitmap = bitmap;
                        @Override
            return false;
    }
            @Override  
                        }
                    };  
                                final long value = values.nextValue();
    final Roaring64NavigableMap bitmap;  
import java.io.IOException;
import org.apache.lucene.util.Accountable;
                return DocValues.isCacheable(ctx, field);
                        public float matchCost() {  
    }
    }  
        return new ConstantScoreWeight(this, boost) {
                            return value >= min && value <= max && bitmap.contains(value);
    final long max;
        }
                    iterator = new TwoPhaseIterator(values) {
                        public boolean matches() throws IOException {  
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
        if (bitmap.isEmpty()) {
        if (sameClassAs(other) == false) {
            min = bitmap.first();  
                                    return true;
            max = 0;
    }  
                }  
 * compatible open source license.
                            return false;
import org.roaringbitmap.longlong.Roaring64NavigableMap;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.QueryVisitor;
                        @Override  
        };
import org.apache.lucene.search.Scorer;  
/*  
import static org.opensearch.search.query.Bitmap64IndexQuery.checkArgs;  
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, iterator);
            public boolean isCacheable(LeafReaderContext ctx) {
 * this file be licensed under the Apache-2.0 license or a
        return RamUsageEstimator.shallowSizeOfInstance(Bitmap64DocValuesQuery.class) + RamUsageEstimator.sizeOf(field) + bitmap  
    @Override  
import org.apache.lucene.search.TwoPhaseIterator;
    @Override
            }  
            return new MatchNoDocsQuery();  
        }  
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.ConstantScoreScorer;
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {  
                final TwoPhaseIterator iterator;
                                if (value < min) {
    public String toString(String field) {
import org.apache.lucene.search.Query;  
import java.util.Objects;
    public long ramBytesUsed() {
                                    return false;
                return new Weight.DefaultScorerSupplier(scorer);  
                        }  
        }
    }
                            int count = values.docValueCount();
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {
public class Bitmap64DocValuesQuery extends Query implements Accountable {  
    }  
            min = 0;  
        if (!bitmap.isEmpty()) {
import org.apache.lucene.search.ScorerSupplier;
                        @Override
                            return 5;
                                }
                SortedNumericDocValues values = DocValues.getSortedNumeric(context.reader(), field);
                            long value = singleton.longValue();
        } else {
        }
import org.apache.lucene.search.Weight;  
        this.field = field;  
        checkArgs(field, bitmap);
            .getLongSizeInBytes();
 * The OpenSearch Contributors require contributions made to  
 */  
import org.apache.lucene.search.ConstantScoreWeight;  
                if (singleton != null) {  
                    };
                        public float matchCost() {
                        public boolean matches() throws IOException {
    }
                        }
    public int hashCode() {  
    @Override
    final String field;
        return Objects.hash(classHash(), field, bitmap);
    final long min;
                                } else if (bitmap.contains(value)) {  
                        }
 * Same logic as BitmapDocValuesQuery but supports long values.
        return super.rewrite(indexSearcher);
    public Bitmap64DocValuesQuery(String field, Roaring64NavigableMap bitmap) {
                            }  
                        @Override
import org.apache.lucene.index.NumericDocValues;  
    @Override
import org.apache.lucene.search.MatchNoDocsQuery;
 *
