 * SPDX-License-Identifier: Apache-2.0
 */  
     */  
import org.opensearch.cluster.ack.ClusterStateUpdateRequest;
import java.util.Objects;
    PutIndexFieldDomainsClusterStateUpdateRequest> {
        return targetIndex;
}
    /**  
     * Sets the exact target concrete index.
 * Cluster state update request for inserting field-domain metadata into one index.
    public PutIndexFieldDomainsClusterStateUpdateRequest fieldDomainCustomData(Map<String, String> fieldDomainCustomData) {
    private Index targetIndex;  
    }
 * The OpenSearch Contributors require contributions made to  
    public Map<String, String> fieldDomainCustomData() {  
     * Returns encoded field-domain metadata.
 * compatible open source license.
 */  
 * The transport layer resolves action-specific request details and hands this smaller request to the metadata service,
    private Map<String, String> fieldDomainCustomData = Map.of();
/*  
        return fieldDomainCustomData;
    /**
    }
        return this;  
 * following the same split used by other index metadata update actions.
     */  
     */
import org.opensearch.core.index.Index;
    }
 *  
     * Sets encoded field-domain metadata.
     * Returns the exact target concrete index.
    /**
    public Index targetIndex() {  
    }
        this.targetIndex = targetIndex;
import java.util.Map;
public class PutIndexFieldDomainsClusterStateUpdateRequest extends ClusterStateUpdateRequest<
 *
    /**  
     */
        this.fieldDomainCustomData = Map.copyOf(Objects.requireNonNull(fieldDomainCustomData, "fieldDomainCustomData must not be null"));
package org.opensearch.action.admin.indices.fielddomain;
 * this file be licensed under the Apache-2.0 license or a
        return this;  
/**
    public PutIndexFieldDomainsClusterStateUpdateRequest targetIndex(Index targetIndex) {
