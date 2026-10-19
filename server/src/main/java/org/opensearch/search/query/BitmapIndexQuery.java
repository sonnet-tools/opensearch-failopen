        // wrap IntIterator.next()
import org.apache.lucene.search.Scorer;
                }
                        values.intersect(visitor);
                } else {
                    return null;
            adder.add(docID);
        };
    @Override
            private final PeekableIntIterator iterator = bitmap.getIntIterator();
import org.apache.lucene.util.RamUsageEstimator;
        @Override
                    nextQueryPoint = iterator.next();
                } else {
                    long cost = -1;
import org.apache.lucene.index.LeafReader;
import org.apache.lucene.search.MatchNoDocsQuery;
    }
        }
    }
            public boolean isCacheable(LeafReaderContext ctx) {
    }
            }
                return encoded;
            }
                            cost = cardinality * 20;
    interface BitmapIterator extends BytesRefIterator {
    @Override
        }
        return new BitmapIterator() {
        void advance(byte[] target);
 *
            // We exhausted all points in the query:
            }
import org.apache.lucene.search.ConstantScoreScorer;
        @Override
                    // Query point is before index point, so we move to next query point
                };
                    // Query point is after index point, so we don't collect and we return:
    }
        }
            }
        private final ArrayUtil.ByteArrayComparator comparator;
import org.apache.lucene.util.DocIdSetBuilder;
/*
                    @Override
            throw new IllegalArgumentException("field must not be null");
                            // details in https://github.com/opensearch-project/OpenSearch/pull/16936
            return PointValues.Relation.CELL_OUTSIDE_QUERY;
 * SPDX-License-Identifier: Apache-2.0
                if (iterator.hasNext()) {
import org.apache.lucene.search.Query;
    }
    }
        @Override
                    // query point is after the end of this cell
                }
                int cmpMin = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, minPackedValue, 0);
        return Objects.hash(classHash(), field, bitmap);
        public void visit(DocIdSetIterator iterator, byte[] packedValue) throws IOException {
            public void advance(byte[] target) {
                    iterator.advance(packedValue);
}
        }
        private final BitmapIterator iterator;
        if (sameClassAs(other) == false) {
            nextQueryPoint = iterator.next();
import org.apache.lucene.search.QueryVisitor;
        // expose PeekableIntIterator.advanceIfNeeded, advance as long as the next value is smaller than target
            @Override
                }
            final long cardinality = bitmap.getLongCardinality();
        this.bitmap = bitmap;
import org.apache.lucene.search.ScoreMode;
    private final String field;
        return super.rewrite(indexSearcher);
                }
    }
        BitmapIndexQuery that = (BitmapIndexQuery) other;
                }
 *
                if (values == null) {
        private BytesRef nextQueryPoint;
import org.apache.lucene.util.ArrayUtil;
                        }
    }
    public String toString(String field) {
        public MergePointVisitor(DocIdSetBuilder result) throws IOException {
                }
                int cmp = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, packedValue, 0);
                visit(docID);
            }
                            // rough estimate of the cost, 20 times penalty is based on the experiment results
                        final MergePointVisitor visitor = new MergePointVisitor(result);
            }
                        final DocIdSetBuilder result = new DocIdSetBuilder(reader.maxDoc(), values);
                    }
                        if (cost == -1) {
    }
    private static BitmapIterator bitmapEncodedIterator(RoaringBitmap bitmap) {
        @Override
    @Override
            this.result = result;
    public BitmapIndexQuery(String field, RoaringBitmap bitmap) {
        }
                    return PointValues.Relation.CELL_OUTSIDE_QUERY;
        return field.equals(that.field) && bitmap.equals(that.bitmap);
                return true;
                    // NOTE: we only hit this if we are on a cell whose min and max values are exactly equal
        }
                    return PointValues.Relation.CELL_CROSSES_QUERY;
public class BitmapIndexQuery extends Query implements Accountable {
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
 * A query that matches all documents that contain a set of integer numbers represented by bitmap
        public void visit(DocIdSetIterator iterator) throws IOException {
import java.io.IOException;
                    public long cost() {
import org.apache.lucene.document.IntPoint;
            adder.add(iterator);
        if (field == null) {
        this.field = field;
                    // query point is before the start of this cell
                IntPoint.encodeDimension(value, encoded.bytes, 0);
    @Override
                }
                    }
        return RamUsageEstimator.shallowSizeOfInstance(BitmapIndexQuery.class) + RamUsageEstimator.sizeOf(field) + bitmap
import org.apache.lucene.search.ConstantScoreWeight;
                // This query depend only on segment-immutable structure — points
        if (bitmap.isEmpty()) {
            return false;
        public void grow(int count) {
        }
        public void visit(int docID) {
package org.opensearch.search.query;
 * The OpenSearch Contributors require contributions made to
    public long ramBytesUsed() {
                    continue;
/**
                    throw new IllegalArgumentException("field must have only one dimension");
                    @Override
            this.iterator = bitmapEncodedIterator(bitmap);
    public void visit(QueryVisitor visitor) {
        @Override
                if (cmpMin < 0) {
            while (nextQueryPoint != null) {
import org.apache.lucene.util.Accountable;
        }
                    public Scorer get(long leadCost) throws IOException {
                    value = iterator.next();
                    // which can easily happen if many (> 512) docs share this one value
            if (matches(packedValue)) {
                } else {
        };
    @Override
import org.apache.lucene.util.BytesRef;
                if (cmpMax > 0) {
            if (matches(packedValue)) {
        return "BitmapIndexQuery(field=" + this.field + ")";
                adder.add(iterator);
                iterator.advanceIfNeeded(IntPoint.decodeDimension(target, 0));
import org.apache.lucene.util.BytesRefIterator;
            this.comparator = ArrayUtil.getUnsignedComparator(Integer.BYTES);
    public boolean equals(Object other) {
        }
        private final DocIdSetBuilder result;
            }
                    // to our point,
        if (visitor.acceptField(field)) {
import org.apache.lucene.index.PointValues;
        public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
            }
            return false;
 * @opensearch.internal
    }
    public int hashCode() {
            @Override
            public BytesRef next() {
import org.roaringbitmap.PeekableIntIterator;
            while (nextQueryPoint != null) {
 */
                    return PointValues.Relation.CELL_INSIDE_QUERY;
import org.roaringbitmap.RoaringBitmap;
import org.apache.lucene.search.ScorerSupplier;
        public void visit(int docID, byte[] packedValue) {
 */
            return new MatchNoDocsQuery();
        }
            adder = result.grow(count);
                if (cmp == 0) {
                LeafReader reader = context.reader();
import org.apache.lucene.index.LeafReaderContext;
                int value;
    private final RoaringBitmap bitmap;
                int cmpMax = comparator.compare(nextQueryPoint.bytes, nextQueryPoint.offset, maxPackedValue, 0);
                PointValues values = reader.getPointValues(field);
        @Override
    @Override
                        return new ConstantScoreScorer(score(), scoreMode, result.build().iterator());
                return new ScorerSupplier() {
        checkArgs(field, bitmap);
    @Override
                    return true;
                if (values.getNumIndexDimensions() != 1) {
            // get cardinality is not cheap enough to do when supplying scorers, so do it once per weight
                // get the point value which should be one dimension, since bitmap saves integers
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {
                        return cost;
                if (cmpMin == 0 && cmpMax == 0) {
        return new ConstantScoreWeight(this, boost) {
import java.util.Objects;
        }
 * compatible open source license.
        BytesRef next();
                    break;
            throw new IllegalArgumentException("bitmap must not be null");
        private boolean matches(byte[] packedValue) {
    static void checkArgs(String field, RoaringBitmap bitmap) {
                    return null;
import org.apache.lucene.search.DocIdSetIterator;
    }
import org.apache.lucene.search.Weight;
        }
                    nextQueryPoint = iterator.next();
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
                    iterator.advance(minPackedValue);
    private class MergePointVisitor implements PointValues.IntersectVisitor {
        }
                } else if (cmp < 0) {
    }
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.IndexSearcher;
        if (bitmap == null) {
            private final BytesRef encoded = new BytesRef(new byte[Integer.BYTES]);
            .getLongSizeInBytes();
            visitor.visitLeaf(this);
        private DocIdSetBuilder.BulkAdder adder;
