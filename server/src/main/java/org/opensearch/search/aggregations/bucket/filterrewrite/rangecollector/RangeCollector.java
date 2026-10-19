    /**
    void countNode(int count);
     * Iterate to find the next range that could include the given value.
    boolean withinRange(byte[] value);
import java.io.IOException;
     */
     */
     */  
    void collectDocId(int docId);  
     */
     */
     * Check if a value is within the lower bound of current range.
package org.opensearch.search.aggregations.bucket.filterrewrite.rangecollector;
     */
     * @return true if iteration is complete or enough non-zero ranges found  
 * SPDX-License-Identifier: Apache-2.0
    /**
     */
    /**  
    boolean withinUpperBound(byte[] value);  
     * Hook point when visit inner node
    void finalizePreviousRange();
    /**  
     * @param inLeaf Whether this is called when processing a leaf node
     * Check if a value is within both bounds of current range.  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    boolean iterateRangeEnd(byte[] value, boolean inLeaf);
    boolean withinLowerBound(byte[] value);
    /**
     * @param docId The document ID to collect
    void visitLeaf();  
/*  
 *
 * Interface for collecting documents that fall within specified ranges during point tree traversal.
    /**
     * Hook point when visit leaf node
    FilterRewriteOptimizationContext.OptimizeResult getResult();
    void count();  
public interface RangeCollector {  
    /**  
     */
     * Count a node that is fully contained within the current range.
     */  
     */  
    void visitInner();
     * Whether the collector supports sub aggregation.
     */  
    /**
     * Count a single document.
 */
     */
    /**
     * @param value The value to check against ranges
/**  
     * Finalize the current range and prepare for the next one.  
     *  
     * @param count The number of documents in the node
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;
     * @param iter Iterator over document IDs
     * Check if a value is within the upper bound of current range.
}  
 */  
    /**
 * compatible open source license.
    /**
    boolean hasSubAgg();
import org.apache.lucene.search.DocIdSetIterator;
     * Collect a set of document IDs.  
    /**  
    void collectDocIdSet(DocIdSetIterator iter) throws IOException;  
     * Collect a single document ID.  
