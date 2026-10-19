                    nextQueryPoint = iterator.next();
                        return cost;
        checkArgs(field, bitmap);
                if (cmp < 0) {
    @Override
            private final org.roaringbitmap.longlong.LongIterator it = bitmap.getLongIterator();
    }
                while (it.hasNext()) {
    public Bitmap64IndexQuery(String field, Roaring64NavigableMap bitmap) {  
                    return encoded;
    public int hashCode() {  
                    public long cost() {
                        values.intersect(visitor);  
        return "Bitmap64IndexQuery(field=" + this.field + ")";
                LongPoint.encodeDimension(v, encoded.bytes, 0);
    }
    }  
            }
        }
                    if (Arrays.compareUnsigned(currentBytes, target) >= 0) {  
            this.result = result;
                if (cmpMin < 0) {
        }  
                    }
}  
                long v = it.next();
        return new BitmapIterator() {  
                    System.arraycopy(currentBytes, 0, encoded.bytes, 0, Long.BYTES);
            @Override  
            private boolean hasBuffered = false;
                    long v = it.next();  
            public boolean isCacheable(LeafReaderContext ctx) {
            }  
    private final Roaring64NavigableMap bitmap;  
import org.apache.lucene.search.QueryVisitor;
                    iterator.advance(packedValue);  
                }
        @Override  
                LeafReader reader = context.reader();  
import org.apache.lucene.search.ScoreMode;  
import org.apache.lucene.util.RamUsageEstimator;  
import org.apache.lucene.search.ConstantScoreWeight;  
    }  
                    iterator.advance(minPackedValue);  
                    LongPoint.encodeDimension(v, currentBytes, 0);
            while (nextQueryPoint != null) {  
            this.iterator = bitmapEncodedIterator(bitmap);
    @Override  
                if (!it.hasNext()) return null;
            public void advance(byte[] target) {
                    continue;
                        return new ConstantScoreScorer(score(), scoreMode, result.build().iterator());
            adder.add(docID);
        BytesRef next();  
                int cmpMin = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, minPackedValue, 0);
import org.apache.lucene.search.MatchNoDocsQuery;  
import java.util.Objects;
import org.apache.lucene.util.BytesRef;  
                }  
 * SPDX-License-Identifier: Apache-2.0
        @Override
import java.util.Arrays;  
import org.roaringbitmap.longlong.Roaring64NavigableMap;  
    @Override  
        public void visit(int docID, byte[] packedValue) {
        }
                } else break;
            return PointValues.Relation.CELL_OUTSIDE_QUERY;
                    throw new IllegalArgumentException("field must have only one dimension");
 * compatible open source license.
        private boolean matches(byte[] packedValue) {
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
import org.apache.lucene.document.LongPoint;
        if (bitmap.isEmpty()) return new MatchNoDocsQuery();
                        return;
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) {
                int cmpMax = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, maxPackedValue, 0);
        public void grow(int count) {
 *
        }
                return new ScorerSupplier() {
    public void visit(QueryVisitor visitor) {
                    @Override
 */  
        Bitmap64IndexQuery that = (Bitmap64IndexQuery) other;
    }
            final long cardinality = bitmap.getLongCardinality();
            nextQueryPoint = iterator.next();  
    interface BitmapIterator extends BytesRefIterator {
import org.apache.lucene.util.BytesRefIterator;
    public boolean equals(Object other) {
        this.field = field;  
    }
        public void visit(DocIdSetIterator iterator, byte[] packedValue) throws IOException {  
        return new ConstantScoreWeight(this, boost) {  
                return encoded;  
        return field.equals(that.field) && bitmap.equals(that.bitmap);
                    }  
    }
import org.apache.lucene.index.LeafReaderContext;  
            if (matches(packedValue)) adder.add(iterator);
import org.apache.lucene.search.Query;
        @Override
        @Override  
                if (hasBuffered) {
 * @opensearch.internal
        private final ArrayUtil.ByteArrayComparator comparator = ArrayUtil.getUnsignedComparator(Long.BYTES);  
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override
        private BytesRef nextQueryPoint;
                return true; // depends only on segment points
            @Override  
        }
        private final BitmapIterator iterator;
                hasBuffered = false; // Iterator exhausted, no match found
        };
        if (field == null) throw new IllegalArgumentException("field must not be null");
            }
    public Query rewrite(IndexSearcher searcher) throws IOException {
        return Objects.hash(classHash(), field, bitmap);
                        if (cost == -1) cost = cardinality * 20; // same heuristic as 32-bit  
                }  
            while (nextQueryPoint != null) {
            public BytesRef next() {
                PointValues values = reader.getPointValues(field);
                if (values.getNumIndexDimensions() != 1) {
        return super.rewrite(searcher);  
                if (cmpMax > 0) return PointValues.Relation.CELL_OUTSIDE_QUERY;
    }  
                if (cmp == 0) return true;
/**
            private final BytesRef encoded = new BytesRef(new byte[Long.BYTES]);
        public void visit(DocIdSetIterator iterator) throws IOException {
    private class MergePointVisitor implements PointValues.IntersectVisitor {
            adder = result.grow(count);
            if (matches(packedValue)) visit(docID);
            .getLongSizeInBytes();
        if (bitmap == null) throw new IllegalArgumentException("bitmap must not be null");
        }
    }  
    static void checkArgs(String field, Roaring64NavigableMap bitmap) {  
    }
                    }
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.util.ArrayUtil;
        @Override
    public String toString(String field) {  
    }
import org.apache.lucene.search.ScorerSupplier;
                return PointValues.Relation.CELL_CROSSES_QUERY;  
    public long ramBytesUsed() {
 * A query that matches all documents that contain a set of long values represented by a 64-bit bitmap  
    @Override
    private static BitmapIterator bitmapEncodedIterator(Roaring64NavigableMap bitmap) {
            return false;
        if (visitor.acceptField(field)) visitor.visitLeaf(this);
package org.opensearch.search.query;
                        final MergePointVisitor visitor = new MergePointVisitor(result);
        public void visit(int docID) {  
                        hasBuffered = true;
        };
/*  
                };  
                    @Override
        MergePointVisitor(DocIdSetBuilder result) {  
            private final byte[] currentBytes = new byte[Long.BYTES];  
        void advance(byte[] target);
import org.apache.lucene.search.Scorer;
import org.apache.lucene.index.LeafReader;
        }  
            }  
        private DocIdSetBuilder.BulkAdder adder;
                    hasBuffered = false;  
 *
import org.apache.lucene.search.Weight;  
import org.apache.lucene.index.PointValues;
                    long cost = -1;  
        this.bitmap = bitmap;
            @Override
    @Override
 * The OpenSearch Contributors require contributions made to  
            }
    @Override
                if (values == null) return null;
        @Override
        if (sameClassAs(other) == false) return false;  
import java.io.IOException;
                        final DocIdSetBuilder result = new DocIdSetBuilder(reader.maxDoc(), values);
                }  
import org.apache.lucene.search.DocIdSetIterator;
                    public Scorer get(long leadCost) throws IOException {  
public class Bitmap64IndexQuery extends Query implements Accountable {
import org.apache.lucene.search.ConstantScoreScorer;
        return RamUsageEstimator.shallowSizeOfInstance(Bitmap64IndexQuery.class) + RamUsageEstimator.sizeOf(field) + bitmap  
            adder.add(iterator);  
    private final String field;
                int cmp = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, packedValue, 0);  
            }  
 */  
import org.apache.lucene.util.DocIdSetBuilder;
            @Override  
        }  
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        private final DocIdSetBuilder result;  
import org.apache.lucene.util.Accountable;
                    nextQueryPoint = iterator.next();
