        boolean foundLeafNode = starTree.isLeaf();
            // is needed
    public static FixedBitSet getStarTreeResult(StarTreeValues starTreeValues, StarTreeFilter starTreeFilter, SearchContext searchContext)
import java.util.Queue;  
                    globalRemainingPredicateColumns = new HashSet<>(remainingPredicateColumns);  
            bitSet.and(tempBitSet);
            if (isMatchAllFilterPresent) continue;  
            bitSet.set(starTreeValuesIterator.entryId());
        }
            int dimensionId = starTreeNode.getDimensionId();
        }
                String dimension = dimensionNames.get(dimensionId);  
            this.matchedDocIds = matchedDocIds;
            }
import org.apache.lucene.util.FixedBitSet;
                    }
            starTreeResult.matchedDocIds.build().iterator()
            DocIdSetBuilder matchedDocIds,
                    while (childrenIterator.hasNext()) {
 * this file be licensed under the Apache-2.0 license or a
            }
                        StarTreeNode childNode = childrenIterator.next();  
        List<Dimension> dimensionsOrder = starTreeValues.getStarTreeField().getDimensionsOrder();
            int numOfMatchedDocs,
                continue;
        for (String dimension : starTreeFilter.getDimensions()) {
                    });
        StarTreeResult starTreeResult = traverseStarTree(starTreeValues, starTreeFilter);
                        if (childNode.getStarTreeNodeType() != StarTreeNodeType.STAR.getValue()) {
            this.numOfMatchedDocs = numOfMatchedDocs;  
import java.util.Set;
        List<Integer> docIds = new ArrayList<>();
                List<DimensionFilter> dimensionFilters = starTreeFilter.getFiltersForDimension(childDimension);
            // Skip filtering if a MatchAllFilter is present for this dimension, since it implies all values match and no further filtering  
import java.util.Iterator;
import java.io.IOException;
                            }
    /**  
import org.apache.logging.log4j.Logger;
            int maxMatchedDoc
                        tempFoundLeafNodes[0] |= node.isLeaf();
                    docIds.add((int) i);  
        for (int id : docIds) {
        Queue<StarTreeNode> queue = new ArrayDeque<>();  
        if (starTreeResult.maxMatchedDoc == -1) {
        ) {  
import java.util.stream.Collectors;
            if (bitSet.length() > 0) {
        }  
        public final DocIdSetBuilder matchedDocIds;
                    ? bitSet.nextSetBit(entryId + 1)
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
     * predicate dimensions that are not matched.
        // Initialising all dimension filters for this segment
        SortedNumericStarTreeValuesIterator starTreeValuesIterator = new SortedNumericStarTreeValuesIterator(  
        public StarTreeResult(
                } else {  
    }  
                        }
                    : DocIdSetIterator.NO_MORE_DOCS) {  
 */
                }
                matchedDocsCountInStarTree++;
    /**
        int maxDocNum = -1;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
     * Helper class to wrap the result from traversing the star tree.
     * Helper method to traverse the star tree, get matching documents and keep track of all the  
        while (starTreeValuesIterator.nextEntry() != NO_MORE_DOCS) {
            return bitSet;  
                continue;
                    maxDocNum = Math.max((int) i, maxDocNum);
        // No matches, return an empty FixedBitSet
            );
                for (int entryId = bitSet.nextSetBit(0); entryId != DocIdSetIterator.NO_MORE_DOCS; entryId = (entryId + 1 < bitSet.length())
            for (DimensionFilter dimensionFilter : dimensionFilters) {  
        // Set bits in FixedBitSet for initially matched documents  
            this.maxMatchedDoc = maxMatchedDoc;
            if (remainingPredicateColumns.isEmpty()) {
                                tempBitSet.set(entryId);// Set bit for the matching entryId
            matchedDocsCountInStarTree,
        FixedBitSet bitSet = new FixedBitSet(starTreeResult.maxMatchedDoc + 1);
        }  
            }
     */
            docsWithField,  
public class StarTreeTraversalUtil {  
        public final int maxMatchedDoc;
            tempBitSet.clear(0, starTreeResult.maxMatchedDoc + 1);
        }
         *   For the remaining columns, use star-tree doc values to match them
                            queue.add(childNode);
        }
            }
        DocIdSetBuilder.BulkAdder adder;
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.StarTreeValuesIterator;
import org.opensearch.search.startree.filter.StarTreeFilter;  
            }
import java.util.Collections;
        );
        throws IOException {
package org.opensearch.search.startree;
        int currentDimensionId = -1;
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
            if (dimensionId > currentDimensionId) {
            }
                }
                    dimensionFilter.matchStarTreeNodes(starTreeNode, starTreeValues, node -> {
                docIds.add(docId);
            if (globalRemainingPredicateColumns == null || !globalRemainingPredicateColumns.contains(childDimension)) {  
                remainingPredicateColumns.remove(dimension);
                        for (DimensionFilter dimensionFilter : dimensionFilters) {  
import java.util.ArrayList;
        public final Set<String> remainingPredicateColumns;  
            this.remainingPredicateColumns = remainingPredicateColumns;
            // Get the query value directly  
                    break;  
                for (long i = starTreeNode.getStartDocId(); i < starTreeNode.getEndDocId(); i++) {
        // Initialize FixedBitSet with size maxMatchedDoc + 1
import org.opensearch.index.compositeindex.datacube.Dimension;  
        public final int numOfMatchedDocs;
            for (DimensionFilter dimensionFilter : starTreeFilter.getFiltersForDimension(dimension)) {  
                    isMatchAllFilterPresent = true;
                }  
            if (starTreeNode.isLeaf()) {
        assert foundLeafNode == false; // root node is never leaf
            }
/**  
                if (dimensionFilter instanceof MatchAllFilter) {
    /**
                dimensionFilter.initialiseForSegment(starTreeValues, searchContext);
        int matchedDocsCountInStarTree = 0;
import java.util.ArrayDeque;  
                final boolean[] tempFoundLeafNodes = new boolean[1];  
            List<DimensionFilter> dimensionFilters = starTreeFilter.getFiltersForDimension(remainingPredicateColumn);
            String childDimension = dimensionNames.get(dimensionId + 1);
        DocIdSetBuilder docsWithField = new DocIdSetBuilder(starTreeValues.getStarTreeDocumentCount());
                }  
                            if (dimensionFilter.matchDimValue(value, starTreeValues)) {
 *
    private static final Logger logger = LogManager.getLogger(StarTreeTraversalUtil.class);
     * */  
        while ((starTreeNode = queue.poll()) != null) {  
                    Iterator<? extends StarTreeNode> childrenIterator = starTreeNode.getChildrenIterator();
/*  
import org.apache.lucene.util.DocIdSetBuilder;
        // Process remaining predicate columns to further filter the results
                maxDocNum = Math.max(docId, maxDocNum);  
            StarTreeValuesIterator valuesIterator = starTreeValues.getDimensionValuesIterator(
 */  
import org.opensearch.search.startree.filter.MatchAllFilter;
import org.opensearch.search.internal.SearchContext;  
                            foundLeafNode |= childNode.isLeaf();  
            }  
                if (foundLeafNode && globalRemainingPredicateColumns == null) {
        StarTreeNode starTreeNode;  
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
 *  @opensearch.internal
            maxDocNum  
            } else {
                                break;  
        adder = docsWithField.grow(docIds.size());
            boolean isMatchAllFilterPresent = false;
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;  
        );
            logger.debug("remainingPredicateColumn : {}, maxMatchedDoc : {} ", remainingPredicateColumn, starTreeResult.maxMatchedDoc);
                    }  
    }
                    foundLeafNode |= starNode.isLeaf();
            if (remainingPredicateColumns.contains(childDimension)) {
                }
import org.apache.lucene.search.DocIdSetIterator;  
                int docId = starTreeNode.getAggregatedDocId();  
            StarTreeNode starNode = null;
                    matchedDocsCountInStarTree++;
import static org.apache.lucene.search.DocIdSetIterator.NO_MORE_DOCS;
            globalRemainingPredicateColumns != null ? globalRemainingPredicateColumns : Collections.emptySet(),
                }  
}
 * Filter operator for star tree data structure.
            // Clear the temporary bit set before reuse  
         *   First go over the star tree and try to match as many dimensions as possible
                dimensionFilters.getFirst().getMatchingDimension()  
                // Iterate over the current set of matched document IDs  
                        long value = valuesIterator.value();
        StarTreeNode starTree = starTreeValues.getRoot();
import org.apache.logging.log4j.LogManager;
 *  @opensearch.experimental  
                        queue.add(node);  
                foundLeafNode |= tempFoundLeafNodes[0];
import org.opensearch.search.startree.filter.DimensionFilter;
                starNode = starTreeNode.getChildStarNode();
     */  
        for (String remainingPredicateColumn : starTreeResult.remainingPredicateColumns) {  
        Set<String> globalRemainingPredicateColumns = null;  
                for (DimensionFilter dimensionFilter : dimensionFilters) {
                    if (valuesIterator.advanceExact(entryId)) {
        return bitSet;  // Return the final FixedBitSet with all matches
import java.util.List;
                        }
    private static class StarTreeResult {
        return new StarTreeResult(
        }  
        List<String> dimensionNames = dimensionsOrder.stream().map(Dimension::getField).collect(Collectors.toList());  
    private static StarTreeResult traverseStarTree(StarTreeValues starTreeValues, StarTreeFilter starTreeFilter) throws IOException {  
            adder.add(id);  
                if (starNode != null) {  
    }  
                currentDimensionId = dimensionId;
        Set<String> remainingPredicateColumns = new HashSet<>(starTreeFilter.getMatchingDimensions());  
        queue.add(starTree);
                    queue.add(starNode);
            // Perform intersection of the current matches with the temp results for this predicate
            Set<String> remainingPredicateColumns,  
        FixedBitSet tempBitSet = new FixedBitSet(starTreeResult.maxMatchedDoc + 1);  
        // Temporary FixedBitSet reused for filtering
import java.util.HashSet;  
