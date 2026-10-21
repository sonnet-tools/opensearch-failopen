            @Override
        }
                    long cost = -1;
            }
import org.apache.lucene.document.LongPoint;
        if (field == null) throw new IllegalArgumentException("field must not be null");
            private boolean hasBuffered = false;
    }
            adder.add(iterator);
import org.apache.lucene.search.Weight;
        public void grow(int count) {
        private final DocIdSetBuilder result;
        @Override
    static void checkArgs(String field, Roaring64NavigableMap bitmap) {
    interface BitmapIterator extends BytesRefIterator {
import org.apache.lucene.search.MatchNoDocsQuery;
                int cmpMin = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, minPackedValue, 0);
                int cmp = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, packedValue, 0);
                return new ScorerSupplier() {
    }
    public Bitmap64IndexQuery(String field, Roaring64NavigableMap bitmap) {
    @Override
        @Override
    }
        if (sameClassAs(other) == false) return false;
        return super.rewrite(searcher);
                if (!it.hasNext()) return null;
/*
                    nextQueryPoint = iterator.next();
        return new ConstantScoreWeight(this, boost) {
    public String toString(String field) {
            private final byte[] currentBytes = new byte[Long.BYTES];
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.util.ArrayUtil;
        public void visit(DocIdSetIterator iterator, byte[] packedValue) throws IOException {
        }
package org.opensearch.search.query;
                        final DocIdSetBuilder result = new DocIdSetBuilder(reader.maxDoc(), values);
            return PointValues.Relation.CELL_OUTSIDE_QUERY;
                    @Override
    }
        return field.equals(that.field) && bitmap.equals(that.bitmap);
    @Override
            @Override
        @Override
        this.bitmap = bitmap;
import org.apache.lucene.index.PointValues;
                }
import org.apache.lucene.util.BytesRefIterator;
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
                    }
                return true; // depends only on segment points
            }
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) {
                }
        void advance(byte[] target);
        }
        Bitmap64IndexQuery that = (Bitmap64IndexQuery) other;
    @Override
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
import java.util.Objects;
    public boolean equals(Object other) {
            if (matches(packedValue)) adder.add(iterator);
                    LongPoint.encodeDimension(v, currentBytes, 0);
 * SPDX-License-Identifier: Apache-2.0
        return new BitmapIterator() {
            private final org.roaringbitmap.longlong.LongIterator it = bitmap.getLongIterator();
                if (cmpMin < 0) {
                return encoded;
    }
        }
        private final ArrayUtil.ByteArrayComparator comparator = ArrayUtil.getUnsignedComparator(Long.BYTES);
                if (cmpMax > 0) return PointValues.Relation.CELL_OUTSIDE_QUERY;
        this.field = field;
                    }
        private BytesRef nextQueryPoint;
                if (cmp < 0) {
                        hasBuffered = true;
}
            while (nextQueryPoint != null) {
                    System.arraycopy(currentBytes, 0, encoded.bytes, 0, Long.BYTES);
        private final BitmapIterator iterator;
            return false;
                if (cmp == 0) return true;
                return PointValues.Relation.CELL_CROSSES_QUERY;
        if (visitor.acceptField(field)) visitor.visitLeaf(this);
                hasBuffered = false; // Iterator exhausted, no match found
                    @Override
        checkArgs(field, bitmap);
import java.util.Arrays;
            adder.add(docID);
        }
    @Override
 */
            this.iterator = bitmapEncodedIterator(bitmap);
                    nextQueryPoint = iterator.next();
                        final MergePointVisitor visitor = new MergePointVisitor(result);
                PointValues values = reader.getPointValues(field);
 */
 *
    private static BitmapIterator bitmapEncodedIterator(Roaring64NavigableMap bitmap) {
                    long v = it.next();
    }
            @Override
            nextQueryPoint = iterator.next();
                int cmpMax = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, maxPackedValue, 0);
import org.apache.lucene.search.Scorer;
        MergePointVisitor(DocIdSetBuilder result) {
                long v = it.next();
                }
                    iterator.advance(minPackedValue);
        }
                if (hasBuffered) {
                        values.intersect(visitor);
    public void visit(QueryVisitor visitor) {
import org.apache.lucene.search.ConstantScoreWeight;
        }
import org.apache.lucene.util.Accountable;
            adder = result.grow(count);
import org.apache.lucene.search.ScorerSupplier;
 * compatible open source license.
                        return new ConstantScoreScorer(score(), scoreMode, result.build().iterator());
        public void visit(int docID) {
        };
        return Objects.hash(classHash(), field, bitmap);
import java.io.IOException;
                if (values.getNumIndexDimensions() != 1) {
import org.apache.lucene.search.Query;
    }
                } else break;
                LeafReader reader = context.reader();
                        if (cost == -1) cost = cardinality * 20; // same heuristic as 32-bit
        };
    public long ramBytesUsed() {
        if (bitmap.isEmpty()) return new MatchNoDocsQuery();
                    }
            public void advance(byte[] target) {
import org.apache.lucene.util.DocIdSetBuilder;
            this.result = result;
    public int hashCode() {
        }
            }
 * this file be licensed under the Apache-2.0 license or a
        public void visit(int docID, byte[] packedValue) {
    @Override
            }
    }
import org.apache.lucene.search.IndexSearcher;
                while (it.hasNext()) {
        @Override
import org.apache.lucene.search.ConstantScoreScorer;
            if (matches(packedValue)) visit(docID);
        @Override
        return RamUsageEstimator.shallowSizeOfInstance(Bitmap64IndexQuery.class) + RamUsageEstimator.sizeOf(field) + bitmap
                    public Scorer get(long leadCost) throws IOException {
    }
                };
                    hasBuffered = false;
    private final String field;
            public BytesRef next() {
            final long cardinality = bitmap.getLongCardinality();
                    public long cost() {
                    throw new IllegalArgumentException("field must have only one dimension");
    @Override
            private final BytesRef encoded = new BytesRef(new byte[Long.BYTES]);
                    if (Arrays.compareUnsigned(currentBytes, target) >= 0) {
    }
import org.roaringbitmap.longlong.Roaring64NavigableMap;
                    continue;
            }
            .getLongSizeInBytes();
    private class MergePointVisitor implements PointValues.IntersectVisitor {
 * @opensearch.internal
 * A query that matches all documents that contain a set of long values represented by a 64-bit bitmap
        return "Bitmap64IndexQuery(field=" + this.field + ")";
 * The OpenSearch Contributors require contributions made to
        private DocIdSetBuilder.BulkAdder adder;
            public boolean isCacheable(LeafReaderContext ctx) {
    public Query rewrite(IndexSearcher searcher) throws IOException {
    private final Roaring64NavigableMap bitmap;
import org.apache.lucene.search.DocIdSetIterator;
import org.apache.lucene.util.BytesRef;
                    return encoded;
                    iterator.advance(packedValue);
            while (nextQueryPoint != null) {
                        return;
import org.apache.lucene.util.RamUsageEstimator;
        private boolean matches(byte[] packedValue) {
import org.apache.lucene.search.ScoreMode;
    @Override
                        return cost;
        BytesRef next();
        @Override
                if (values == null) return null;
 *
                LongPoint.encodeDimension(v, encoded.bytes, 0);
        if (bitmap == null) throw new IllegalArgumentException("bitmap must not be null");
    }
import org.apache.lucene.search.QueryVisitor;
/**
    }
                }
import org.apache.lucene.index.LeafReader;
            }
public class Bitmap64IndexQuery extends Query implements Accountable {
        public void visit(DocIdSetIterator iterator) throws IOException {
            @Override
