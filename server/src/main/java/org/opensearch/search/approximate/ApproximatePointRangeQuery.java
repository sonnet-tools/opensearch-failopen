                if (context.request().source().searchAfter() != null) {
                        "field=\""
            }
                    }  
            }  
                }
            private void intersectRight(PointValues.PointTree pointTree, PointValues.IntersectVisitor visitor, long[] docCount)
    public int getSize() {  
            }
                        }
    public static final Function<byte[], String> UNSIGNED_LONG_FORMAT = bytes -> BigIntegerPoint.decodeDimension(bytes, 0).toString();
import org.apache.lucene.search.Scorer;  
                        protected String toString(int dimension, byte[] value) {
                    }
    public final boolean equals(Object o) {
                    return;  
        if ((isLowerBound && isAscending) || (isLowerBound == false && isAscending == false)) {
                        if (matches(packedValue)) {
                    }  
                if (crosses) {  
                }  
 * this file be licensed under the Apache-2.0 license or a
                            @Override  
        if (context.request() != null && context.request().source() != null) {  
                        @Override
                            + pointRangeQuery.getNumDims()
            public void intersectRight(PointValues.IntersectVisitor visitor, PointValues.PointTree pointTree, long[] docCount)
 * SPDX-License-Identifier: Apache-2.0
                // Internal node - get left child reference (we're at left child initially)  
                        docCount[0] += ref.length;
        return originalBound;
                return true;
                        adder.add(iterator);
        SortOrder sortOrder,
                if (pointTree.moveToChild() == false) {  
        // size 0 could be set for caching
import org.opensearch.index.mapper.NumericPointEncoder;
                    }  
                    };
    private SortOrder sortOrder;
            return context.request().source().terminateAfter() == SearchContext.DEFAULT_TERMINATE_AFTER;
                    return;
import org.apache.lucene.util.IntsRef;
    private boolean equalsTo(ApproximatePointRangeQuery other) {
                    if (leftSize >= needed) {  
                        };
                if (r == PointValues.Relation.CELL_INSIDE_QUERY) {
                }
                pointTree.moveToParent();
                // Process both children: left first, then right if needed
            // We add +1 to ensure we collect at least one more document than required. This guarantees correct relation value:  
        return sb.toString();
                long[] docCount = { 0 };
                    public void visit(DocIdSetIterator iterator) throws IOException {
        this.size = size;
                        return;  
    public PointRangeQuery pointRangeQuery;  
import org.opensearch.search.sort.SortOrder;
        String field,
                PointValues.Relation r = visitor.compare(pointTree.getMinPackedValue(), pointTree.getMaxPackedValue());
        return this.size;
                            long cost = -1;
                        pointTree.visitDocValues(visitor);
                }
package org.opensearch.search.approximate;
            Object searchAfterValue = context.request().source().searchAfter()[0];
                    );
                        if (matches(packedValue)) {
            // - If we find exactly trackTotalHitsUpTo docs: relation = EQUAL_TO
import org.apache.lucene.document.LongPoint;
    }
                    // No docs in this segment/field indexed any points
    private int size;
        final ArrayUtil.ByteArrayComparator comparator = ArrayUtil.getUnsignedComparator(pointRangeQuery.getBytesPerDim());
                }
            }  
    @Override  
                        pointTree.visitDocIDs(visitor);  
    }
        }
    }  
                    }
                }
                            + values.getBytesPerDimension()  
                    byte[] lower;  
                                if (cost == -1) {
            }
            }  
                        intersectLeft(visitor, pointTree, docCount);
            this.setSize(Math.max(context.from() + context.size(), context.trackTotalHitsUpTo()) + 1);
                return encoder.encodePoint(searchAfterValue, isLowerBound);
/**
                        size += deletedDocs;  
                    return;
        this(field, lowerPoint, upperPoint, numDims, SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO, null, valueToString);
        // Exclude approximation when "track_total_hits": true
            if (fieldType instanceof NumericPointEncoder encoder) {
    }
                    }
import org.apache.lucene.index.PointValues;
                    return;
                } else {
            private PointValues.Relation relate(byte[] minPackedValue, byte[] maxPackedValue) {  
import org.apache.lucene.search.ScoreMode;
                        intersectRight(visitor, pointTree, docCount);
                            + "\" was indexed with bytesPerDim="
                }
                    public void visit(int docID, byte[] packedValue) {  
                                    cost = values.estimateDocCount(visitor);
    }
                return pointRangeQueryWeight.count(context);  
                        return PointValues.Relation.CELL_OUTSIDE_QUERY;
        };  
                PointValues.Relation r = visitor.compare(pointTree.getMinPackedValue(), pointTree.getMaxPackedValue());
                assert pointTree.moveToParent() == false;
 * after {@code size} is hit  
                            public Scorer get(long leadCost) throws IOException {
    public static final Function<byte[], String> DOUBLE_FORMAT = bytes -> Double.toString(DoublePoint.decodeDimension(bytes, 0));
                        // CELL_CROSSES_QUERY
                }
                    @Override  
            }  
                            }
                    int offset = dim * pointRangeQuery.getBytesPerDim();
                        return relate(minPackedValue, maxPackedValue);  
                }
            return false;
                assert pointTree.moveToParent() == false;
            public int count(LeafReaderContext context) throws IOException {
                if (docCount[0] < size && rightChild != null) {
                    }
import org.apache.lucene.search.IndexSearcher;
                        || comparator.compare(maxPackedValue, offset, pointRangeQuery.getUpperPoint(), offset) > 0;  
                        // Doc's value is too high, in this dimension
        return Objects.equals(pointRangeQuery, other.pointRangeQuery);  
                        final int deletedDocs = reader.numDeletedDocs();
}  
                            @Override
                    crosses |= comparator.compare(minPackedValue, offset, pointRangeQuery.getLowerPoint(), offset) < 0
                    if (sortOrder == null || sortOrder.equals(SortOrder.ASC)) {
    }  
import org.opensearch.index.mapper.MappedFieldType;  
import org.apache.lucene.index.LeafReaderContext;  
    public static final Function<byte[], String> HALF_FLOAT_FORMAT = bytes -> Float.toString(HalfFloatPoint.decodeDimension(bytes, 0));
            @Override  
    @Override
                    @Override
            return false;
                        return;
                                intersectRight(values.getPointTree(), visitor, docCount);  
                        pointTree.moveToParent();  
                return false;
                // Move to right child if it exists
                    public void visit(DocIdSetIterator iterator, byte[] packedValue) throws IOException {
        };
                                return cost;
            }  
                        "field=\""  
                this.setSortOrder(primarySortField.order());
        int numDims,
    public void visit(QueryVisitor visitor) {
        this.valueToString = valueToString;  
                    } else {
            @Override
            return false;  
                    } else {
                throws IOException {  
                if (docCount[0] >= size) {
                        pointTree.visitDocIDs(visitor);
                            public long cost() {
                                return new ConstantScoreScorer(score(), scoreMode, iterator);
 * compatible open source license.
        return new ConstantScoreWeight(this, boost) {
                        // Doc's value is too low, in this dimension  
                if (hasRightChild) {
                    @Override
            @Override
                            }  
                    intersectLeft(visitor, rightChild, docCount);
        }  
import org.apache.lucene.search.PointRangeQuery;
                }  
                            public Scorer get(long leadCost) throws IOException {
        if (context == null) {
                                return new ConstantScoreScorer(score(), scoreMode, iterator);
                }  
            public PointValues.IntersectVisitor getIntersectVisitor(DocIdSetBuilder result, long[] docCount) {
                    byte[] upper;
import org.apache.lucene.search.ScorerSupplier;
                    public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
            private boolean checkValidPointValues(PointValues values) throws IOException {  
                    int offset = dim * pointRangeQuery.getBytesPerDim();
                    return false;
                    intersectRight(visitor, pointTree, docCount);
    }
                        return false;
                    }
            MappedFieldType fieldType = context.getQueryShardContext().fieldMapper(pointRangeQuery.getField());  
                            long cost = -1;
                    }  
    @Override
                }  
                }  
                }  
    }
    public final ConstantScoreWeight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {  
            }
                            visit(docID);
                        adder.add(docID);
    public void setSize(int size) {
    public SortOrder getSortOrder() {
                }
                if (pointTree.moveToChild() == false) {
                            final PointValues.IntersectVisitor visitor = getIntersectVisitor(result, docCount);
                boolean crosses = false;
                }  
                        adder.add(ref);
                    } else {
                if (!primarySortField.fieldName().equals(pointRangeQuery.getField())) {  
                return new PointValues.IntersectVisitor() {
                if (checkValidPointValues(values) == false) {
import org.apache.lucene.search.DocIdSetIterator;  
            // custom intersect visitor to walk the left of the tree
                            + pointRangeQuery.getField()
                if (r == PointValues.Relation.CELL_INSIDE_QUERY && hasRightChild) {
                PointValues.PointTree leftChild = pointTree.clone();
    public static final Function<byte[], String> LONG_FORMAT = bytes -> Long.toString(LongPoint.decodeDimension(bytes, 0));  
        byte[] lowerPoint,  
        this.sortOrder = sortOrder;
                            @Override
        int numDims,
                    }
            private boolean matches(byte[] packedValue) {
    @Override  
                // For CELL_INSIDE_QUERY, check if we can skip left child
                    throw new IllegalArgumentException(
            // we pull this from PointRangeQuery since it is final
                        lower = pointRangeQuery.getLowerPoint();  
                                    assert cost >= 0;
                for (int dim = 0; dim < pointRangeQuery.getNumDims(); dim++) {  
                    @Override
    }
                        pointTree.moveToParent();
            public void intersectLeft(PointValues.IntersectVisitor visitor, PointValues.PointTree pointTree, long[] docCount)  
        sb.append("Approximate(");  
                            + pointRangeQuery.getField()  
                }  
        }  
        this.size = size;
    protected ApproximatePointRangeQuery(
            }
        String field,
    @Override
                PointValues values = reader.getPointValues(pointRangeQuery.getField());  
                    public void visit(IntsRef ref) {  
import org.apache.lucene.document.DoublePoint;
                                    assert cost >= 0;  
                    if (sortOrder == SortOrder.ASC) {
        this.sortOrder = sortOrder;
                for (int dim = 0; dim < pointRangeQuery.getNumDims(); dim++) {  
                    }  
import org.apache.lucene.document.IntPoint;  
        sb.append(")");
                return false;
                    return false;  
                                }
                    if (comparator.compare(packedValue, offset, pointRangeQuery.getUpperPoint(), offset) > 0) {  
                if (docCount[0] < size) {
    ) {  
                    long needed = size - docCount[0];
                                return cost;  
                            adder.add(iterator);  
                            + " but this query has bytesPerDim="
                    );  
        this.pointRangeQuery = new PointRangeQuery(field, lowerPoint, upperPoint, numDims) {
                    return PointValues.Relation.CELL_INSIDE_QUERY;  
        Function<byte[], String> valueToString
                intersectLeft(visitor, pointTree, docCount);  
        return super.rewrite(indexSearcher);  
                // Process both children: right first (for DESC), then left if needed  
                if (r == PointValues.Relation.CELL_OUTSIDE_QUERY) {  
        Weight pointRangeQueryWeight = pointRangeQuery.createWeight(searcher, scoreMode, boost);  
            if (context.request().source().sorts() != null && context.request().source().sorts().size() > 1) {
                        upper = pointRangeQuery.getUpperPoint();
                    return;  
    }
        Function<byte[], String> valueToString
                        return new ScorerSupplier() {  
                LeafReader reader = context.reader();  
        return pointRangeQuery.hashCode();  
                PointValues.PointTree rightChild = null;
                    return;
                        // it is possible that size < 1024 and docCount < size but we will continue to count through all the 1024 docs
import java.util.function.Function;
import org.apache.lucene.search.Query;  
            // we pull this from PointRangeQuery since it is final
                    if (rightSize >= needed) {
        byte[] lowerPoint,
                    @Override
        if (context.trackTotalHitsUpTo() == SearchContext.TRACK_TOTAL_HITS_ACCURATE) {
                    }  
        sb.append(pointRangeQuery.toString());
            this.setSize(SearchContext.DEFAULT_TRACK_TOTAL_HITS_UP_TO);
                if (values.getNumIndexDimensions() != pointRangeQuery.getNumDims()) {  
                    long leftSize = pointTree.size();  
                // Handle leaf nodes  
import org.apache.lucene.search.QueryVisitor;
    public void setSortOrder(SortOrder sortOrder) {  
                        return new ScorerSupplier() {
                        || comparator.compare(maxPackedValue, offset, pointRangeQuery.getLowerPoint(), offset) < 0) {
    public final String toString(String field) {
                // values.size(): total points indexed, In most cases: values.size() ≈ number of documents (assuming single-valued fields)
                        // than expected
                            return valueToString.apply(value);  
                // We need both children - now clone right
                    if (comparator.compare(minPackedValue, offset, pointRangeQuery.getUpperPoint(), offset) > 0  
    private byte[] computeEffectiveBound(SearchContext context, boolean isLowerBound) {
                            + " but this query has numDims="  
                    intersectRight(visitor, leftChild, docCount);
                    return PointValues.Relation.CELL_CROSSES_QUERY;
                    public void visit(int docID) {  
    public final int hashCode() {
                    }
import org.apache.lucene.util.ArrayUtil;  
                    long rightSize = pointTree.size();  
                intersectLeft(visitor, pointTree, docCount);
import org.apache.lucene.index.LeafReader;
                                DocIdSetIterator iterator = result.build().iterator();
                    return null;
        int size,  
                    pointTree.moveToChild();  
                } else {
                            }  
            }
            private void intersectLeft(PointValues.PointTree pointTree, PointValues.IntersectVisitor visitor, long[] docCount)
        }  
    ) {  
            FieldSortBuilder primarySortField = FieldSortBuilder.getPrimaryFieldSortOrNull(context.request().source());
                    DocIdSetBuilder.BulkAdder adder;
 */  
                boolean hasRightChild = pointTree.moveToSibling();  
        return sameClassAs(o) && equalsTo(getClass().cast(o));
                    pointTree.moveToParent();
                        lower = computeEffectiveBound(context, true);  
        return this.sortOrder;  
        } else {
    public boolean canApproximate(SearchContext context) {  
                            }
        pointRangeQuery.visit(visitor);
                    if (comparator.compare(packedValue, offset, pointRangeQuery.getLowerPoint(), offset) < 0) {
            }  
                throws IOException {  
                            @Override
    }
        }
 * The OpenSearch Contributors require contributions made to  
                if (docCount[0] >= size) {
                            final PointValues.IntersectVisitor visitor = getIntersectVisitor(result, docCount);  
                if (pointTree.moveToSibling()) {  
import org.apache.lucene.search.Weight;
            protected String toString(int dimension, byte[] value) {  
                intersectRight(visitor, pointTree, docCount);
                    }
                        docCount[0]++;  
                throws IOException {  
            }
                    @Override  
                if (values == null) {
                            + "\" was indexed with numIndexDimensions="
                        };
    @Override  
    }  
import java.util.Objects;
import org.apache.lucene.util.DocIdSetBuilder;
        if (context.from() + context.size() == 0) {  
                                    cost = values.estimateDocCount(visitor);  
                        }  
    public ApproximatePointRangeQuery(  
            // we pull this from PointRangeQuery since it is final
        byte[] upperPoint,  
                        adder = result.grow(count);
import java.io.IOException;  
                            final DocIdSetBuilder result = new DocIdSetBuilder(reader.maxDoc(), values);
    public static final Function<byte[], String> INT_FORMAT = bytes -> Integer.toString(IntPoint.decodeDimension(bytes, 0));
                    long needed = size - docCount[0];
        final StringBuilder sb = new StringBuilder();
                    public void grow(int count) {
                }
    }
    }  
                                }
                }
        byte[] upperPoint,
import org.apache.lucene.document.FloatPoint;
import org.opensearch.search.sort.FieldSortBuilder;  
                pointTree.moveToParent();
                        // Right child has all we need - only process right  
        }
                            final DocIdSetBuilder result = new DocIdSetBuilder(reader.maxDoc(), values);  
                        return false;
                                DocIdSetIterator iterator = result.build().iterator();  
        return true;
public class ApproximatePointRangeQuery extends ApproximateQuery {
                        pointTree.visitDocValues(visitor);  
                };
    }
            // custom intersect visitor to walk the right of tree (from rightmost leaf going left)
                                intersectLeft(values.getPointTree(), visitor, docCount);
                        // we need to fetch size + deleted docs since the collector will prune away deleted docs resulting in fewer results  
                            + pointRangeQuery.getBytesPerDim()
    private final Function<byte[], String> valueToString;
                if (primarySortField.missing() != null) {  
                                    // Computing the cost may be expensive, so only do it if necessary
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
                    @Override  
                return true;
    public static final Function<byte[], String> FLOAT_FORMAT = bytes -> Float.toString(FloatPoint.decodeDimension(bytes, 0));  
                    }
                if (pointRangeQuery.getBytesPerDim() != values.getBytesPerDimension()) {
                }
                }  
                    rightChild = pointTree.clone();
import org.apache.lucene.search.ConstantScoreScorer;
                    if (r == PointValues.Relation.CELL_INSIDE_QUERY) {
    public Query rewrite(IndexSearcher indexSearcher) throws IOException {
                        // Process only left child
        if (context.aggregations() != null) {
                            public long cost() {  
 *
        boolean isAscending = sortOrder == null || sortOrder.equals(SortOrder.ASC);  
                    } else {  
                            + values.getNumIndexDimensions()
                    if (r == PointValues.Relation.CELL_INSIDE_QUERY) {
            }  
                                if (cost == -1) {  
                                    // Computing the cost may be expensive, so only do it if necessary
                    // Cannot sort documents missing this field.
                }  
    @Override
                    return false;
                    this.pointRangeQuery = new PointRangeQuery(pointRangeQuery.getField(), lower, upper, pointRangeQuery.getNumDims()) {  
                throws IOException {
                // For CELL_INSIDE_QUERY, check if we can skip right child
                if (r == PointValues.Relation.CELL_OUTSIDE_QUERY) {
                    return pointRangeQueryWeight.scorerSupplier(context);  
 * An approximate-able version of {@link PointRangeQuery}. It creates an instance of {@link PointRangeQuery} but short-circuits the intersect logic
import org.apache.lucene.sandbox.document.BigIntegerPoint;
                }
                        upper = computeEffectiveBound(context, false);
import org.apache.lucene.sandbox.document.HalfFloatPoint;  
                return valueToString.apply(value);
                if (size > values.size()) {
            // - If we find > trackTotalHitsUpTo docs: relation = GREATER_THAN_OR_EQUAL_TO
import org.apache.lucene.search.ConstantScoreWeight;
import org.opensearch.search.internal.SearchContext;
                // Handle leaf nodes
                        }
            @Override
/*  
 */
            }  
                        // CELL_CROSSES_QUERY
                    throw new IllegalArgumentException(
                    }  
            if (primarySortField != null) {
        byte[] originalBound = isLowerBound ? pointRangeQuery.getLowerPoint() : pointRangeQuery.getUpperPoint();
            // With +1, we will consistently get GREATER_THAN_OR_EQUAL_TO relation.  
            public boolean isCacheable(LeafReaderContext ctx) {
