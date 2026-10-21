        List<Dimension> dimensionsOrder = starTreeValues.getStarTreeField().getDimensionsOrder();
                        tempFoundLeafNodes[0] |= node.isLeaf();
            boolean isMatchAllFilterPresent = false;
        Set<String> globalRemainingPredicateColumns = null;
        }
            bitSet.set(starTreeValuesIterator.entryId());
                }
                List<DimensionFilter> dimensionFilters = starTreeFilter.getFiltersForDimension(childDimension);
    }
        }
        );
            // is needed
     */
            tempBitSet.clear(0, starTreeResult.maxMatchedDoc + 1);
import java.util.stream.Collectors;
        for (int id : docIds) {
                    if (valuesIterator.advanceExact(entryId)) {
            DocIdSetBuilder matchedDocIds,
    }
                remainingPredicateColumns.remove(dimension);
        }
                        queue.add(node);
            int maxMatchedDoc
import java.util.List;
        Queue<StarTreeNode> queue = new ArrayDeque<>();
import org.opensearch.search.startree.filter.StarTreeFilter;
                for (long i = starTreeNode.getStartDocId(); i < starTreeNode.getEndDocId(); i++) {
        }
        Set<String> remainingPredicateColumns = new HashSet<>(starTreeFilter.getMatchingDimensions());
            Set<String> remainingPredicateColumns,
            // Perform intersection of the current matches with the temp results for this predicate
        for (String dimension : starTreeFilter.getDimensions()) {
                                break;
                continue;
                    isMatchAllFilterPresent = true;
                    maxDocNum = Math.max((int) i, maxDocNum);
            if (starTreeNode.isLeaf()) {
        SortedNumericStarTreeValuesIterator starTreeValuesIterator = new SortedNumericStarTreeValuesIterator(
    }
import java.util.ArrayList;
                }
        StarTreeNode starTreeNode;
        }
        int maxDocNum = -1;
import org.apache.lucene.util.DocIdSetBuilder;
import org.opensearch.index.compositeindex.datacube.Dimension;
                    queue.add(starNode);
            if (bitSet.length() > 0) {
        public final DocIdSetBuilder matchedDocIds;
        queue.add(starTree);
         *   For the remaining columns, use star-tree doc values to match them
                    break;
                if (dimensionFilter instanceof MatchAllFilter) {
        // Process remaining predicate columns to further filter the results
package org.opensearch.search.startree;
            }
 */
 *  @opensearch.experimental
                    matchedDocsCountInStarTree++;
            bitSet.and(tempBitSet);
        }
                        long value = valuesIterator.value();
import org.opensearch.search.internal.SearchContext;
                dimensionFilter.initialiseForSegment(starTreeValues, searchContext);
     * */
        }
                    globalRemainingPredicateColumns = new HashSet<>(remainingPredicateColumns);
import java.util.ArrayDeque;
            String childDimension = dimensionNames.get(dimensionId + 1);
    /**
            }
        List<String> dimensionNames = dimensionsOrder.stream().map(Dimension::getField).collect(Collectors.toList());
            for (DimensionFilter dimensionFilter : starTreeFilter.getFiltersForDimension(dimension)) {
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
            StarTreeValuesIterator valuesIterator = starTreeValues.getDimensionValuesIterator(
                for (int entryId = bitSet.nextSetBit(0); entryId != DocIdSetIterator.NO_MORE_DOCS; entryId = (entryId + 1 < bitSet.length())
                                tempBitSet.set(entryId);// Set bit for the matching entryId
        StarTreeNode starTree = starTreeValues.getRoot();
            return bitSet;
     * predicate dimensions that are not matched.
                        }
            adder.add(id);
        // Initialize FixedBitSet with size maxMatchedDoc + 1
                        StarTreeNode childNode = childrenIterator.next();
                for (DimensionFilter dimensionFilter : dimensionFilters) {
        FixedBitSet tempBitSet = new FixedBitSet(starTreeResult.maxMatchedDoc + 1);
        public final int numOfMatchedDocs;
            int dimensionId = starTreeNode.getDimensionId();
import java.util.Set;
        int matchedDocsCountInStarTree = 0;
            }
        List<Integer> docIds = new ArrayList<>();
 *
                    }
        return bitSet;  // Return the final FixedBitSet with all matches
            this.remainingPredicateColumns = remainingPredicateColumns;
        while ((starTreeNode = queue.poll()) != null) {
import org.apache.lucene.util.FixedBitSet;
        for (String remainingPredicateColumn : starTreeResult.remainingPredicateColumns) {
        StarTreeResult starTreeResult = traverseStarTree(starTreeValues, starTreeFilter);
            int numOfMatchedDocs,
                        }
            StarTreeNode starNode = null;
 * Filter operator for star tree data structure.
    private static final Logger logger = LogManager.getLogger(StarTreeTraversalUtil.class);
    public static FixedBitSet getStarTreeResult(StarTreeValues starTreeValues, StarTreeFilter starTreeFilter, SearchContext searchContext)
                    }
import java.util.Iterator;
            if (dimensionId > currentDimensionId) {
                    Iterator<? extends StarTreeNode> childrenIterator = starTreeNode.getChildrenIterator();
/*
                        for (DimensionFilter dimensionFilter : dimensionFilters) {
        // Set bits in FixedBitSet for initially matched documents
                }
import org.apache.lucene.search.DocIdSetIterator;
import java.util.Collections;
        while (starTreeValuesIterator.nextEntry() != NO_MORE_DOCS) {
        throws IOException {
            }
                continue;
 * SPDX-License-Identifier: Apache-2.0
        assert foundLeafNode == false; // root node is never leaf
            }
            if (globalRemainingPredicateColumns == null || !globalRemainingPredicateColumns.contains(childDimension)) {
            // Clear the temporary bit set before reuse
    /**
            if (remainingPredicateColumns.isEmpty()) {
        if (starTreeResult.maxMatchedDoc == -1) {
            this.matchedDocIds = matchedDocIds;
                if (starNode != null) {
                    docIds.add((int) i);
            docsWithField,
            matchedDocsCountInStarTree,
import org.opensearch.search.startree.filter.DimensionFilter;
    private static class StarTreeResult {
        public StarTreeResult(
            for (DimensionFilter dimensionFilter : dimensionFilters) {
        return new StarTreeResult(
        int currentDimensionId = -1;
                }
                int docId = starTreeNode.getAggregatedDocId();
                String dimension = dimensionNames.get(dimensionId);
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.StarTreeValuesIterator;
            this.maxMatchedDoc = maxMatchedDoc;
        public final Set<String> remainingPredicateColumns;
        DocIdSetBuilder.BulkAdder adder;
                        if (childNode.getStarTreeNodeType() != StarTreeNodeType.STAR.getValue()) {
                if (foundLeafNode && globalRemainingPredicateColumns == null) {
            }
 *  @opensearch.internal
                foundLeafNode |= tempFoundLeafNodes[0];
 * The OpenSearch Contributors require contributions made to
            globalRemainingPredicateColumns != null ? globalRemainingPredicateColumns : Collections.emptySet(),
                docIds.add(docId);
/**
            if (remainingPredicateColumns.contains(childDimension)) {
        );
 * this file be licensed under the Apache-2.0 license or a
    private static StarTreeResult traverseStarTree(StarTreeValues starTreeValues, StarTreeFilter starTreeFilter) throws IOException {
                maxDocNum = Math.max(docId, maxDocNum);
 * compatible open source license.
        boolean foundLeafNode = starTree.isLeaf();
        // No matches, return an empty FixedBitSet
            maxDocNum
                dimensionFilters.getFirst().getMatchingDimension()
            this.numOfMatchedDocs = numOfMatchedDocs;
        ) {
            // Get the query value directly
        // Temporary FixedBitSet reused for filtering
        adder = docsWithField.grow(docIds.size());
            logger.debug("remainingPredicateColumn : {}, maxMatchedDoc : {} ", remainingPredicateColumn, starTreeResult.maxMatchedDoc);
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
                } else {
import java.util.HashSet;
                currentDimensionId = dimensionId;
            // Skip filtering if a MatchAllFilter is present for this dimension, since it implies all values match and no further filtering
        public final int maxMatchedDoc;
import java.util.Queue;
                starNode = starTreeNode.getChildStarNode();
            );
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
            List<DimensionFilter> dimensionFilters = starTreeFilter.getFiltersForDimension(remainingPredicateColumn);
                final boolean[] tempFoundLeafNodes = new boolean[1];
        DocIdSetBuilder docsWithField = new DocIdSetBuilder(starTreeValues.getStarTreeDocumentCount());
            }
 *
import org.apache.logging.log4j.LogManager;
            starTreeResult.matchedDocIds.build().iterator()
     */
 */
                    ? bitSet.nextSetBit(entryId + 1)
     * Helper method to traverse the star tree, get matching documents and keep track of all the
    /**
                }
                    dimensionFilter.matchStarTreeNodes(starTreeNode, starTreeValues, node -> {
         *   First go over the star tree and try to match as many dimensions as possible
                            queue.add(childNode);
import org.opensearch.search.startree.filter.MatchAllFilter;
                // Iterate over the current set of matched document IDs
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
                    : DocIdSetIterator.NO_MORE_DOCS) {
                    foundLeafNode |= starNode.isLeaf();
public class StarTreeTraversalUtil {
}
                }
import java.io.IOException;
                    });
                            foundLeafNode |= childNode.isLeaf();
            } else {
                    while (childrenIterator.hasNext()) {
                            }
     * Helper class to wrap the result from traversing the star tree.
import org.apache.logging.log4j.Logger;
        FixedBitSet bitSet = new FixedBitSet(starTreeResult.maxMatchedDoc + 1);
            }
            if (isMatchAllFilterPresent) continue;
                matchedDocsCountInStarTree++;
                            if (dimensionFilter.matchDimValue(value, starTreeValues)) {
        // Initialising all dimension filters for this segment
