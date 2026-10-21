                    }
            if (fieldType instanceof NumericPointEncoder encoder) {
                        upper = pointRangeQuery.getUpperPoint();
                        pointTree.visitDocIDs(visitor);
                }
                pointTree.moveToParent();
                    @Override
                        return PointValues.Relation.CELL_OUTSIDE_QUERY;
            }
                }
import org.apache.lucene.search.Query;
        return sb.toString();
        }
    public void setSize(int size) {
        return true;
            this.setSize(SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO);
                                intersectLeft(values.getPointTree(), visitor, docCount);
                        // Right child has all we need - only process right
        SortOrder sortOrder,
        Function<byte[], String> valueToString
                        return;
                        upper = computeEffectiveBound(context, false);
    public boolean canApproximate(SearchContext context) {
        this.size = size;
        }
                return new PointValues.IntersectVisitor() {
                            }
            return false;
        if (context.request() != null && context.request().source() != null) {
    protected ApproximatePointRangeQuery(
                            public long cost() {
                    @Override
                                if (cost == -1) {
        Function<byte[], String> valueToString
                        intersectRight(visitor, pointTree, docCount);
                    );
                intersectRight(visitor, pointTree, docCount);
                        final int deletedDocs = reader.numDeletedDocs();
            // we pull this from PointRangeQuery since it is final
                if (docCount[0] < size) {
            private PointValues.Relation relate(byte[] minPackedValue, byte[] maxPackedValue) {
import org.apache.lucene.sandbox.document.BigIntegerPoint;
                    return pointRangeQueryWeight.scorerSupplier(context);
                if (pointRangeQuery.getBytesPerDim() != values.getBytesPerDimension()) {
                            visit(docID);
 * An approximate-able version of {@link PointRangeQuery}. It creates an instance of {@link PointRangeQuery} but short-circuits the intersect logic
        return super.rewrite(indexSearcher);
        this.sortOrder = sortOrder;
    }
        int size,
            Object searchAfterValue = context.request().source().searchAfter()[0];
            }
import java.util.Objects;
    }
                                    cost = values.estimateDocCount(visitor);
                    @Override
                assert pointTree.moveToParent() == false;
                            + pointRangeQuery.getField()
                        return false;
import org.apache.lucene.search.QueryVisitor;
                    return PointValues.Relation.CELL_CROSSES_QUERY;
public class ApproximatePointRangeQuery extends ApproximateQuery {
                        docCount[0]++;
        this.sortOrder = sortOrder;
                        || comparator.compare(maxPackedValue, offset, pointRangeQuery.getUpperPoint(), offset) > 0;
            @Override
        String field,
                    public void visit(DocIdSetIterator iterator) throws IOException {
    private final Function<byte[], String> valueToString;
            public PointValues.IntersectVisitor getIntersectVisitor(DocIdSetBuilder result, long[] docCount) {
                    if (comparator.compare(packedValue, offset, pointRangeQuery.getUpperPoint(), offset) > 0) {
                    if (leftSize >= needed) {
    @Override
                // Internal node - get left child reference (we're at left child initially)
                                return new ConstantScoreScorer(score(), scoreMode, iterator);
                                if (cost == -1) {
                    return;
        this(field, lowerPoint, upperPoint, numDims, SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO, null, valueToString);
                // Handle leaf nodes
                }
    }
                // We need both children - now clone right
                    }
                    }
        // size 0 could be set for caching
    private boolean equalsTo(ApproximatePointRangeQuery other) {
                    return;
                    @Override
    private SortOrder sortOrder;
                            final PointValues.IntersectVisitor visitor = getIntersectVisitor(result, docCount);
                    intersectLeft(visitor, rightChild, docCount);
            }
                        return new ScorerSupplier() {
    @Override
    private byte[] computeEffectiveBound(SearchContext context, boolean isLowerBound) {
        byte[] upperPoint,
                if (pointTree.moveToSibling()) {
                                }
            // custom intersect visitor to walk the left of the tree
                    return;
                        return false;
                return true;
        return originalBound;
                    } else {
            return false;
            // we pull this from PointRangeQuery since it is final
                    }
                        size += deletedDocs;
                return false;
                return false;
                                    cost = values.estimateDocCount(visitor);
                    }
                }
        sb.append(")");
    public static final Function<byte[], String> DOUBLE_FORMAT = bytes -> Double.toString(DoublePoint.decodeDimension(bytes, 0));
                        return relate(minPackedValue, maxPackedValue);
                    public void visit(DocIdSetIterator iterator, byte[] packedValue) throws IOException {
                return valueToString.apply(value);
                            + values.getNumIndexDimensions()
            }
                }
                        };
                                return cost;
    }
                        if (matches(packedValue)) {
    public ApproximatePointRangeQuery(
        final ArrayUtil.ByteArrayComparator comparator = ArrayUtil.getUnsignedComparator(pointRangeQuery.getBytesPerDim());
                    } else {
                if (pointTree.moveToChild() == false) {
                    crosses |= comparator.compare(minPackedValue, offset, pointRangeQuery.getLowerPoint(), offset) < 0
                    if (comparator.compare(minPackedValue, offset, pointRangeQuery.getUpperPoint(), offset) > 0
    private int size;
                    public void grow(int count) {
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.search.ConstantScoreWeight;
                if (docCount[0] >= size) {
                        // Process only left child
    }
    }
                if (r == PointValues.Relation.CELL_INSIDE_QUERY && hasRightChild) {
                            + values.getBytesPerDimension()
                if (crosses) {
        return pointRangeQuery.hashCode();
                    return;
    }
import org.apache.lucene.search.ConstantScoreScorer;
                    // No docs in this segment/field indexed any points
                    int offset = dim * pointRangeQuery.getBytesPerDim();
                                DocIdSetIterator iterator = result.build().iterator();
                    this.pointRangeQuery = new PointRangeQuery(pointRangeQuery.getField(), lower, upper, pointRangeQuery.getNumDims()) {
                }
    public SortOrder getSortOrder() {
            }
import org.opensearch.search.internal.SearchContext;
                if (r == PointValues.Relation.CELL_INSIDE_QUERY) {
import org.apache.lucene.document.LongPoint;
                        || comparator.compare(maxPackedValue, offset, pointRangeQuery.getLowerPoint(), offset) < 0) {
                                return new ConstantScoreScorer(score(), scoreMode, iterator);
                                DocIdSetIterator iterator = result.build().iterator();
import org.apache.lucene.search.ScoreMode;
        int numDims,
                    if (r == PointValues.Relation.CELL_INSIDE_QUERY) {
                        adder.add(ref);
                            + pointRangeQuery.getBytesPerDim()
                        // CELL_CROSSES_QUERY
                        docCount[0] += ref.length;
                        "field=\""
                        protected String toString(int dimension, byte[] value) {
        };
                }
        if ((isLowerBound && isAscending) || (isLowerBound == false && isAscending == false)) {
    public void visit(QueryVisitor visitor) {
                }
                    throw new IllegalArgumentException(
                if (!primarySortField.fieldName().equals(pointRangeQuery.getField())) {
 * The OpenSearch Contributors require contributions made to
                    if (r == PointValues.Relation.CELL_INSIDE_QUERY) {
                // Process both children: right first (for DESC), then left if needed
            @Override
            }
import java.io.IOException;
        final StringBuilder sb = new StringBuilder();
 *
            public void intersectRight(PointValues.IntersectVisitor visitor, PointValues.PointTree pointTree, long[] docCount)
                for (int dim = 0; dim < pointRangeQuery.getNumDims(); dim++) {
        }
                            + "\" was indexed with numIndexDimensions="
                                    assert cost >= 0;
                if (values == null) {
                if (size > values.size()) {
                    intersectRight(visitor, pointTree, docCount);
                            long cost = -1;
                assert pointTree.moveToParent() == false;
                // For CELL_INSIDE_QUERY, check if we can skip right child
                intersectLeft(visitor, pointTree, docCount);
        Weight pointRangeQueryWeight = pointRangeQuery.createWeight(searcher, scoreMode, boost);
                    public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
                return pointRangeQueryWeight.count(context);
                            final DocIdSetBuilder result = new DocIdSetBuilder(reader.maxDoc(), values);
                if (checkValidPointValues(values) == false) {
                                    // Computing the cost may be expensive, so only do it if necessary
            if (context.request().source().sorts() != null && context.request().source().sorts().size() > 1) {
                                }
import org.apache.lucene.index.PointValues;
                    long needed = size - docCount[0];
                    @Override
                        adder.add(iterator);
                boolean hasRightChild = pointTree.moveToSibling();
        };
                    );
                        "field=\""
            }
        if (context.from() + context.size() == 0) {
        return sameClassAs(o) && equalsTo(getClass().cast(o));
    public final String toString(String field) {
                    long rightSize = pointTree.size();
    }
                    };
                boolean crosses = false;
                }
        }
import org.apache.lucene.search.ScorerSupplier;
                }
                }
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {
import org.apache.lucene.util.DocIdSetBuilder;
                }
    public static final Function<byte[], String> INT_FORMAT = bytes -> Integer.toString(IntPoint.decodeDimension(bytes, 0));
                        pointTree.moveToParent();
                    if (rightSize >= needed) {
    ) {
                            + pointRangeQuery.getField()
                pointTree.moveToParent();
    public void setSortOrder(SortOrder sortOrder) {
                }
        sb.append(pointRangeQuery.toString());
                        // Doc's value is too high, in this dimension
                        if (matches(packedValue)) {
    public final ConstantScoreWeight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
            public int count(LeafReaderContext context) throws IOException {
    @Override
        this.pointRangeQuery = new PointRangeQuery(field, lowerPoint, upperPoint, numDims) {
            }
import org.apache.lucene.util.IntsRef;
                for (int dim = 0; dim < pointRangeQuery.getNumDims(); dim++) {
                        adder = result.grow(count);
import org.apache.lucene.util.ArrayUtil;
                        // it is possible that size < 1024 and docCount < size but we will continue to count through all the 1024 docs
                } else {
                    }
    }
                }
                        // CELL_CROSSES_QUERY
                                intersectRight(values.getPointTree(), visitor, docCount);
            }
                        return;
                    return;
                    }
                }
package org.opensearch.search.approximate;
                        pointTree.visitDocValues(visitor);
    public final boolean equals(Object o) {
    @Override
                    return false;
        this.size = size;
 * SPDX-License-Identifier: Apache-2.0
 */
            if (primarySortField != null) {
                PointValues.Relation r = visitor.compare(pointTree.getMinPackedValue(), pointTree.getMaxPackedValue());
                // For CELL_INSIDE_QUERY, check if we can skip left child
    public static final Function<byte[], String> HALF_FLOAT_FORMAT = bytes -> Float.toString(HalfFloatPoint.decodeDimension(bytes, 0));
                    if (sortOrder == SortOrder.ASC) {
                // Move to right child if it exists
                    throw new IllegalArgumentException(
import org.opensearch.search.sort.SortOrder;
import org.apache.lucene.search.Scorer;
        byte[] lowerPoint,
                        }
                    return false;
    }
            return context.request().source().terminateAfter() == SearchContext.DEFAULT_TERMINATE_AFTER;
                        pointTree.visitDocIDs(visitor);
                LeafReader reader = context.reader();
                            public Scorer get(long leadCost) throws IOException {
                            @Override
                        // than expected
                return encoder.encodePoint(searchAfterValue, isLowerBound);
                    }
                            final DocIdSetBuilder result = new DocIdSetBuilder(reader.maxDoc(), values);
            @Override
        } else {
        return Objects.equals(pointRangeQuery, other.pointRangeQuery);
                        pointTree.visitDocValues(visitor);
                    long needed = size - docCount[0];
/*
                    DocIdSetBuilder.BulkAdder adder;
                    if (sortOrder == null || sortOrder.equals(SortOrder.ASC)) {
                        pointTree.moveToParent();
import org.apache.lucene.search.Weight;
                }
            private void intersectRight(PointValues.PointTree pointTree, PointValues.IntersectVisitor visitor, long[] docCount)
                throws IOException {
                // Handle leaf nodes
                // Process both children: left first, then right if needed
                this.setSortOrder(primarySortField.order());
                        }
            return false;
            // With +1, we will consistently get GREATER_THAN_OR_EQUAL_TO relation.
                    }
 */
    @Override
            public void intersectLeft(PointValues.IntersectVisitor visitor, PointValues.PointTree pointTree, long[] docCount)
 * this file be licensed under the Apache-2.0 license or a
                    long leftSize = pointTree.size();
    ) {
            }
    public int getSize() {
                intersectLeft(visitor, pointTree, docCount);
            // we pull this from PointRangeQuery since it is final
                        };
                        intersectLeft(visitor, pointTree, docCount);
                    }
                    @Override
                    @Override
                            }
                PointValues values = reader.getPointValues(pointRangeQuery.getField());
            MappedFieldType fieldType = context.getQueryShardContext().fieldMapper(pointRangeQuery.getField());
                }
            // - If we find > trackTotalHitsUpTo docs: relation = GREATER_THAN_OR_EQUAL_TO
                if (pointTree.moveToChild() == false) {
                            public long cost() {
import org.opensearch.index.mapper.MappedFieldType;
            }
                    byte[] upper;
                // values.size(): total points indexed, In most cases: values.size() ≈ number of documents (assuming single-valued fields)
        return this.sortOrder;
        return this.size;
                    return PointValues.Relation.CELL_INSIDE_QUERY;
import java.util.function.Function;
                            + " but this query has numDims="
                if (primarySortField.missing() != null) {
        if (context.aggregations() != null) {
                    }
        byte[] upperPoint,
        this.valueToString = valueToString;
            }
 * compatible open source license.
            private void intersectLeft(PointValues.PointTree pointTree, PointValues.IntersectVisitor visitor, long[] docCount)
                            @Override
                        // Doc's value is too low, in this dimension
            // custom intersect visitor to walk the right of tree (from rightmost leaf going left)
                throws IOException {
                    // Cannot sort documents missing this field.
    @Override
import org.opensearch.index.mapper.NumericPointEncoder;
        pointRangeQuery.visit(visitor);
    }
import org.apache.lucene.index.LeafReader;
                }
        byte[] originalBound = isLowerBound ? pointRangeQuery.getLowerPoint() : pointRangeQuery.getUpperPoint();
            this.setSize(Math.max(context.from() + context.size(), context.trackTotalHitsUpTo()) + 1);
 * after {@code size} is hit
                            + " but this query has bytesPerDim="
                    }
                } else {
            }
                if (hasRightChild) {
import org.apache.lucene.search.PointRangeQuery;
                }
        String field,
            private boolean matches(byte[] packedValue) {
    public PointRangeQuery pointRangeQuery;
                    return null;
                return true;
                PointValues.PointTree rightChild = null;
                PointValues.PointTree leftChild = pointTree.clone();
import org.apache.lucene.index.LeafReaderContext;
                throws IOException {
                    int offset = dim * pointRangeQuery.getBytesPerDim();
        }
                    public void visit(IntsRef ref) {
                        @Override
    public final int hashCode() {
                if (r == PointValues.Relation.CELL_OUTSIDE_QUERY) {
        if (context == null) {
                    public void visit(int docID, byte[] packedValue) {
    }
                    } else {
                            }
                if (values.getNumIndexDimensions() != pointRangeQuery.getNumDims()) {
import org.apache.lucene.search.IndexSearcher;
                    pointTree.moveToParent();
                                    assert cost >= 0;
            }
        byte[] lowerPoint,
                }
    public static final Function<byte[], String> UNSIGNED_LONG_FORMAT = bytes -> BigIntegerPoint.decodeDimension(bytes, 0).toString();
                    }
                        lower = pointRangeQuery.getLowerPoint();
    public static final Function<byte[], String> LONG_FORMAT = bytes -> Long.toString(LongPoint.decodeDimension(bytes, 0));
                    }
                            + "\" was indexed with bytesPerDim="
                            + pointRangeQuery.getNumDims()
                }
    }
                PointValues.Relation r = visitor.compare(pointTree.getMinPackedValue(), pointTree.getMaxPackedValue());
import org.apache.lucene.sandbox.document.HalfFloatPoint;
                        // we need to fetch size + deleted docs since the collector will prune away deleted docs resulting in fewer results
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
                    return false;
            // - If we find exactly trackTotalHitsUpTo docs: relation = EQUAL_TO
                    return;
    @Override
                            }
                        lower = computeEffectiveBound(context, true);
    public static final Function<byte[], String> FLOAT_FORMAT = bytes -> Float.toString(FloatPoint.decodeDimension(bytes, 0));
                            @Override
                long[] docCount = { 0 };
                        return new ScorerSupplier() {
                }
    }
            FieldSortBuilder primarySortField = FieldSortBuilder.getPrimaryFieldSortOrNull(context.request().source());
            }
            public boolean isCacheable(LeafReaderContext ctx) {
                                    // Computing the cost may be expensive, so only do it if necessary
                    public void visit(int docID) {
                }
                                return cost;
}
                    }
                if (docCount[0] >= size) {
                            adder.add(iterator);
                if (docCount[0] < size && rightChild != null) {
            private boolean checkValidPointValues(PointValues values) throws IOException {
                if (context.request().source().searchAfter() != null) {
                    }
        }
    }
                    intersectRight(visitor, leftChild, docCount);
                            long cost = -1;
                    } else {
                            final PointValues.IntersectVisitor visitor = getIntersectVisitor(result, docCount);
        sb.append("Approximate(");
            protected String toString(int dimension, byte[] value) {
import org.opensearch.search.sort.FieldSortBuilder;
                        }
                    byte[] lower;
            // We add +1 to ensure we collect at least one more document than required. This guarantees correct relation value:
import org.apache.lucene.search.DocIdSetIterator;
/**
            @Override
                throws IOException {
                            @Override
                        adder.add(docID);
import org.apache.lucene.document.FloatPoint;
        // Exclude approximation when "track_total_hits": true
                            return valueToString.apply(value);
                    pointTree.moveToChild();
                    rightChild = pointTree.clone();
        return new ConstantScoreWeight(this, boost) {
                if (r == PointValues.Relation.CELL_OUTSIDE_QUERY) {
                };
import org.apache.lucene.document.DoublePoint;
                    if (comparator.compare(packedValue, offset, pointRangeQuery.getLowerPoint(), offset) < 0) {
        int numDims,
        if (context.trackTotalHitsUpTo() == SearchContext.TRACK_TOTAL_HITS_ACCURATE) {
        boolean isAscending = sortOrder == null || sortOrder.equals(SortOrder.ASC);
                            public Scorer get(long leadCost) throws IOException {
