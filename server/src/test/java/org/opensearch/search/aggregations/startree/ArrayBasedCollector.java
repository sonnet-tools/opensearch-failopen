    }
 *
            if (!nodeDimensionValues.contains(value)) return false;
        } catch (IOException e) {
 * compatible open source license.
/*  
 * SPDX-License-Identifier: Apache-2.0
        }  
import java.util.Set;  
            nodeDimensionValues.add(node.getDimensionValue());  
import org.opensearch.search.startree.StarTreeNodeCollector;
    }
        }  
    public void collectStarTreeNode(StarTreeNode node) {
        for (long value : values) {
    @Override  
    }  
package org.opensearch.search.aggregations.startree;
        return true;
public class ArrayBasedCollector implements StarTreeNodeCollector {
}
 * this file be licensed under the Apache-2.0 license or a
        return nodeDimensionValues.size();
    public int collectedNodeCount() {
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
import java.util.HashSet;
    public boolean matchAllCollectedValues(long... values) throws IOException {  
 */  
    private final Set<Long> nodeDimensionValues = new HashSet<>();
            throw new RuntimeException(e);
        try {
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
