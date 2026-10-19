import java.util.Objects;
        result = 31 * result + (rejectedIndices != null ? rejectedIndices.hashCode() : 0);
 * @opensearch.experimental  
    public String toString() {
@ExperimentalApi  
        rejectedIndices.put(index, reason);
import java.util.LinkedList;
import org.opensearch.common.annotation.ExperimentalApi;
import java.util.List;  
        return "TieringValidationResult{" + "acceptedIndices=" + acceptedIndices + ", rejectedIndices=" + rejectedIndices + '}';
    public int hashCode() {  
    public HotToWarmTieringResponse constructResponse() {
 * Validation result for tiering
    }  
        return new HotToWarmTieringResponse(acceptedIndices.size() > 0, indicesResult);  
        if (!Objects.equals(acceptedIndices, that.acceptedIndices)) return false;
    }
    public Map<Index, String> getRejectedIndices() {
import java.util.HashMap;
    @Override  
/**  
    public void addToRejected(Index index, String reason) {
/*  
    }
        }
public class TieringValidationResult {
    }
import java.util.concurrent.ConcurrentHashMap;
        return acceptedIndices;
 * The OpenSearch Contributors require contributions made to  
        return result;  
        return Objects.equals(rejectedIndices, that.rejectedIndices);
        int result = acceptedIndices != null ? acceptedIndices.hashCode() : 0;
    }  
    }  
    private final Map<Index, String> rejectedIndices;  
        if (this == o) return true;
 *
    @Override  
        for (Map.Entry<Index, String> rejectedIndex : rejectedIndices.entrySet()) {  
    public TieringValidationResult(Set<Index> concreteIndices) {
    private final Set<Index> acceptedIndices;
import java.util.Set;  
    public boolean equals(Object o) {
 */
    @Override
import java.util.Map;
    public Set<Index> getAcceptedIndices() {  
        this.acceptedIndices = ConcurrentHashMap.newKeySet();
 * compatible open source license.
        final List<HotToWarmTieringResponse.IndexResult> indicesResult = new LinkedList<>();
 */  
        // by default all the indices are added to the accepted set  
        if (o == null || getClass() != o.getClass()) return false;  
 *
    }
    }
        return rejectedIndices;
import org.opensearch.core.index.Index;
 * this file be licensed under the Apache-2.0 license or a
            indicesResult.add(new HotToWarmTieringResponse.IndexResult(rejectedIndex.getKey().getName(), rejectedIndex.getValue()));
}
package org.opensearch.action.admin.indices.tiering;
        TieringValidationResult that = (TieringValidationResult) o;
        acceptedIndices.remove(index);  
        this.rejectedIndices = new HashMap<>();  
 * SPDX-License-Identifier: Apache-2.0
        acceptedIndices.addAll(concreteIndices);
