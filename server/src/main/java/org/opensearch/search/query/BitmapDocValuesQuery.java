            @Override  
 * compatible open source license.
import org.apache.lucene.index.SortedNumericDocValues;
                    };
            }
        if (sameClassAs(other) == false) {
import org.apache.lucene.search.QueryVisitor;
    public boolean equals(Object other) {
        if (visitor.acceptField(field)) {
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
        this.field = field;
import org.apache.lucene.util.RamUsageEstimator;
                            }
    public BitmapDocValuesQuery(String field, RoaringBitmap bitmap) {
    }
}
    @Override
        }
 */  
                SortedNumericDocValues values = DocValues.getSortedNumeric(context.reader(), field);
                        }
package org.opensearch.search.query;
            max = 0;
                                    return false; // values are sorted, terminate
                        public float matchCost() {
            }
    final String field;  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    @Override  
            return false;  
        return field.equals(that.field) && bitmap.equals(that.bitmap);  
import org.apache.lucene.search.ScorerSupplier;
 *
        };
                final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, iterator);  
                                if (value < min) {
import org.apache.lucene.util.Accountable;
    }
public class BitmapDocValuesQuery extends Query implements Accountable {
    final RoaringBitmap bitmap;
                                    return true;  
/**
        this.bitmap = bitmap;
    public int hashCode() {
                final NumericDocValues singleton = DocValues.unwrapSingleton(values);  
                                }
 * The OpenSearch Contributors require contributions made to  
        if (!bitmap.isEmpty()) {  
                                    continue;
            @Override
    }  
    @Override
        checkArgs(field, bitmap);  
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.search.ScoreMode;
 * Similar to Lucene SortedNumericDocValuesSetQuery
                        public boolean matches() throws IOException {
    }  
                            for (int i = 0; i < count; i++) {
 */  
                        }  
                final TwoPhaseIterator iterator;
    @Override  
    @Override  
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {
                    iterator = new TwoPhaseIterator(singleton) {  
                return DocValues.isCacheable(ctx, field);  
                        }
        }
import static org.opensearch.search.query.BitmapIndexQuery.checkArgs;  
                }
                        public boolean matches() throws IOException {  
                            return 5; // 2 comparisons, possible lookup in the bitmap  
import org.apache.lucene.search.MatchNoDocsQuery;
            public boolean isCacheable(LeafReaderContext ctx) {
                        @Override
import org.roaringbitmap.RoaringBitmap;
                            long value = singleton.longValue();  
        return Objects.hash(classHash(), field, bitmap);
    }
        return RamUsageEstimator.shallowSizeOfInstance(BitmapIndexQuery.class) + RamUsageEstimator.sizeOf(field) + bitmap
        }  
 * <p>
import org.apache.lucene.index.DocValues;
    }  
            return new MatchNoDocsQuery();
        }  
import org.apache.lucene.search.Scorer;  
                        @Override
        return new ConstantScoreWeight(this, boost) {
        return "BitmapDocValuesQuery(field=" + this.field + ")";
                            return value >= min && value <= max && bitmap.contains((int) value);
import org.apache.lucene.search.ConstantScoreScorer;
                        @Override
                                } else if (bitmap.contains((int) value)) {
import org.apache.lucene.search.ConstantScoreWeight;  
                        public float matchCost() {
    @Override
        return super.rewrite(indexSearcher);  
        if (bitmap.isEmpty()) {  
                    iterator = new TwoPhaseIterator(values) {
    final long max;  
    }
            min = 0; // final field
                } else {  
        BitmapDocValuesQuery that = (BitmapDocValuesQuery) other;
 * this file be licensed under the Apache-2.0 license or a
        } else {  
                return new DefaultScorerSupplier(scorer);
                if (singleton != null) {
            max = bitmap.last();
/*  
import org.apache.lucene.search.Weight;  
    public String toString(String field) {  
                            return 5; // 2 comparisons, possible lookup in the bitmap
    public long ramBytesUsed() {  
    final long min;
import java.io.IOException;
import org.apache.lucene.index.NumericDocValues;  
import org.apache.lucene.search.TwoPhaseIterator;
                        }
            visitor.visitLeaf(this);
                                final long value = values.nextValue();  
    public void visit(QueryVisitor visitor) {  
 * Filter with bitmap  
                            return false;  
            min = bitmap.first();
import java.util.Objects;
    }
                    };
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
                            int count = values.docValueCount();
            .getLongSizeInBytes();
import org.apache.lucene.search.IndexSearcher;
                                } else if (value > max) {  
import org.apache.lucene.search.Query;  
                        @Override  
