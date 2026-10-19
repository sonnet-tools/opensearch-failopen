     * Returns the matching docs bitset to iterate upon the star-tree values based on search query  
@ExperimentalApi  
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;  
    /**
import org.opensearch.common.annotation.ExperimentalApi;
        this.setSubCollectors();
    public StarTreeValues getStarTreeValues() {
    }
    /**
     * Sets the sub-collectors to track nested aggregators
 * SPDX-License-Identifier: Apache-2.0
    protected final FixedBitSet matchingDocsBitSet;
import java.util.List;
        this.matchingDocsBitSet = parent.getMatchingDocsBitSet();  
    public StarTreeBucketCollector(StarTreeValues starTreeValues, FixedBitSet matchingDocsBitSet) throws IOException {
    public List<StarTreeBucketCollector> getSubCollectors() {  
    /**
/**  
 */
    public void setSubCollectors() throws IOException {};
        this.matchingDocsBitSet = matchingDocsBitSet;  
    /**  
 * The OpenSearch Contributors require contributions made to  
public abstract class StarTreeBucketCollector {
    /**  
    public abstract void collectStarTreeEntry(int starTreeEntry, long bucket) throws IOException;
}
 *
 * This abstract class exposes utilities to help avoid traversing star-tree multiple times and
    protected final StarTreeValues starTreeValues;  
        return subCollectors;
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
package org.opensearch.search.aggregations;
        return matchingDocsBitSet;  
import org.apache.lucene.util.FixedBitSet;
     */
    }
        return starTreeValues;
     * Returns the tree values to iterate
     */
import java.util.ArrayList;  
 * compatible open source license.
        this.setSubCollectors();
 * @opensearch.internal
    }
     * Collects the star tree entry and bucket ordinal to update
    public StarTreeBucketCollector(StarTreeBucketCollector parent) throws IOException {
     */  
 * Collector for star tree aggregation
        this.starTreeValues = parent.getStarTreeValues();
/*  
 * collect relevant metrics across nested aggregations in a single traversal  
    }
 */  
     */  
     */  
    protected final List<StarTreeBucketCollector> subCollectors = new ArrayList<>();
    public FixedBitSet getMatchingDocsBitSet() {
     * Returns a list of sub-collectors to track nested aggregators
        this.starTreeValues = starTreeValues;
     * The method implementation should identify the metrics to collect from that star-tree entry to the specified bucket
    }  
