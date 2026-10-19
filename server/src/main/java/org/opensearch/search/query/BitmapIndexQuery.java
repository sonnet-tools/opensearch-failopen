        @Override
        }
        // expose PeekableIntIterator.advanceIfNeeded, advance as long as the next value is smaller than target
            adder.add(docID);
            return PointValues.Relation.CELL_OUTSIDE_QUERY;
                // get the point value which should be one dimension, since bitmap saves integers  
                } else {
        BitmapIndexQuery that = (BitmapIndexQuery) other;  
    @Override
        return super.rewrite(indexSearcher);
        public void visit(DocIdSetIterator iterator, byte[] packedValue) throws IOException {
    }
 */  
import org.apache.lucene.util.RamUsageEstimator;  
        public void visit(int docID, byte[] packedValue) {
        return new BitmapIterator() {  
                    iterator.advance(minPackedValue);
                    value = iterator.next();
    static void checkArgs(String field, RoaringBitmap bitmap) {  
import java.io.IOException;
    @Override
        BytesRef next();
import org.roaringbitmap.RoaringBitmap;  
        private DocIdSetBuilder.BulkAdder adder;  
    public boolean equals(Object other) {
                } else {
    public void visit(QueryVisitor visitor) {
                iterator.advanceIfNeeded(IntPoint.decodeDimension(target, 0));
    private final String field;
                if (values.getNumIndexDimensions() != 1) {
                    }
                        }
        @Override
                visit(docID);  
            @Override  
        };  
public class BitmapIndexQuery extends Query implements Accountable {
            }  
                    continue;  
                if (cmpMin < 0) {
    }
        }  
            public void advance(byte[] target) {  
import org.apache.lucene.search.ScoreMode;  
                } else if (cmp < 0) {
                adder.add(iterator);
                }
                        if (cost == -1) {
                    @Override  
        @Override
                }  
                    nextQueryPoint = iterator.next();
import org.apache.lucene.search.ScorerSupplier;
/*  
            if (matches(packedValue)) {
                PointValues values = reader.getPointValues(field);
                        final MergePointVisitor visitor = new MergePointVisitor(result);  
    public long ramBytesUsed() {
        };
        private final DocIdSetBuilder result;
import org.apache.lucene.index.LeafReaderContext;  
        if (bitmap.isEmpty()) {
    }
            }
    @Override  
        if (bitmap == null) {
    private class MergePointVisitor implements PointValues.IntersectVisitor {
                };
                }  
    public BitmapIndexQuery(String field, RoaringBitmap bitmap) {  
            }  
    }
 * @opensearch.internal
                            // details in https://github.com/opensearch-project/OpenSearch/pull/16936  
 *
        public MergePointVisitor(DocIdSetBuilder result) throws IOException {
import org.apache.lucene.search.DocIdSetIterator;
            return false;
        }
                    return null;  
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
                    // to our point,
            }  
    }
        return field.equals(that.field) && bitmap.equals(that.bitmap);
                            cost = cardinality * 20;
                            // rough estimate of the cost, 20 times penalty is based on the experiment results
            visitor.visitLeaf(this);  
import org.apache.lucene.util.Accountable;
                if (values == null) {
        }  
        }  
 *
    private static BitmapIterator bitmapEncodedIterator(RoaringBitmap bitmap) {
import org.apache.lucene.index.PointValues;
import org.apache.lucene.search.ConstantScoreScorer;
            if (matches(packedValue)) {  
    public int hashCode() {
        if (visitor.acceptField(field)) {
                int cmpMin = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, minPackedValue, 0);
                    // NOTE: we only hit this if we are on a cell whose min and max values are exactly equal  
        void advance(byte[] target);
                    long cost = -1;
import org.apache.lucene.search.QueryVisitor;
                int value;
        }
        @Override  
        private final ArrayUtil.ByteArrayComparator comparator;
            nextQueryPoint = iterator.next();  
import org.apache.lucene.util.BytesRefIterator;
        this.bitmap = bitmap;
    }
 * this file be licensed under the Apache-2.0 license or a
                    iterator.advance(packedValue);  
        public void grow(int count) {
import org.apache.lucene.search.Weight;  
                IntPoint.encodeDimension(value, encoded.bytes, 0);
    }
                        values.intersect(visitor);
    public String toString(String field) {
            this.comparator = ArrayUtil.getUnsignedComparator(Integer.BYTES);
        }
                    break;
        checkArgs(field, bitmap);
 */  
import org.apache.lucene.util.DocIdSetBuilder;
            return false;
                if (iterator.hasNext()) {  
            return new MatchNoDocsQuery();
                return new ScorerSupplier() {  
        private BytesRef nextQueryPoint;
        private final BitmapIterator iterator;  
                }
    @Override
import org.apache.lucene.util.BytesRef;  
            throw new IllegalArgumentException("bitmap must not be null");
                }
    }
                return encoded;  
        @Override  
    @Override
                    return null;  
                if (cmpMax > 0) {  
                if (cmpMin == 0 && cmpMax == 0) {
                    public Scorer get(long leadCost) throws IOException {
import org.apache.lucene.search.IndexSearcher;
            }
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
        return RamUsageEstimator.shallowSizeOfInstance(BitmapIndexQuery.class) + RamUsageEstimator.sizeOf(field) + bitmap
        if (field == null) {
 * compatible open source license.
 * A query that matches all documents that contain a set of integer numbers represented by bitmap  
    }  
                        final DocIdSetBuilder result = new DocIdSetBuilder(reader.maxDoc(), values);
                    // Query point is after index point, so we don't collect and we return:  
                    // Query point is before index point, so we move to next query point
                    public long cost() {  
                } else {
                        return cost;  
            .getLongSizeInBytes();  
        public void visit(DocIdSetIterator iterator) throws IOException {
                if (cmp == 0) {
import java.util.Objects;  
        return new ConstantScoreWeight(this, boost) {
            throw new IllegalArgumentException("field must not be null");
    @Override  
            this.result = result;  
            @Override
import org.apache.lucene.search.Scorer;
        public void visit(int docID) {  
            adder = result.grow(count);
                    }  
            }
        private boolean matches(byte[] packedValue) {
            }
        // wrap IntIterator.next()
        if (sameClassAs(other) == false) {  
            // We exhausted all points in the query:  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.util.ArrayUtil;
        }
            while (nextQueryPoint != null) {  
}
                    return PointValues.Relation.CELL_CROSSES_QUERY;
            private final PeekableIntIterator iterator = bitmap.getIntIterator();
                    @Override
            }
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
        }
        @Override
        return Objects.hash(classHash(), field, bitmap);  
        }
            public BytesRef next() {
    private final RoaringBitmap bitmap;  
            final long cardinality = bitmap.getLongCardinality();
                // This query depend only on segment-immutable structure — points
                    return true;  
                    return PointValues.Relation.CELL_INSIDE_QUERY;  
                    // which can easily happen if many (> 512) docs share this one value
            while (nextQueryPoint != null) {  
import org.roaringbitmap.PeekableIntIterator;
    @Override  
            this.iterator = bitmapEncodedIterator(bitmap);
                }
 * SPDX-License-Identifier: Apache-2.0
        }
                    nextQueryPoint = iterator.next();
            public boolean isCacheable(LeafReaderContext ctx) {  
package org.opensearch.search.query;
                    throw new IllegalArgumentException("field must have only one dimension");  
                LeafReader reader = context.reader();
        this.field = field;  
                    // query point is after the end of this cell
import org.apache.lucene.document.IntPoint;
                    // query point is before the start of this cell  
/**
            adder.add(iterator);  
import org.apache.lucene.search.Query;
            private final BytesRef encoded = new BytesRef(new byte[Integer.BYTES]);
                        return new ConstantScoreScorer(score(), scoreMode, result.build().iterator());
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {  
import org.apache.lucene.search.MatchNoDocsQuery;  
    interface BitmapIterator extends BytesRefIterator {  
        return "BitmapIndexQuery(field=" + this.field + ")";  
    }  
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
                int cmp = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, packedValue, 0);
import org.apache.lucene.index.LeafReader;
    }
            // get cardinality is not cheap enough to do when supplying scorers, so do it once per weight  
import org.apache.lucene.search.ConstantScoreWeight;  
                }
    }
        }  
        }  
                int cmpMax = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, maxPackedValue, 0);
                return true;
