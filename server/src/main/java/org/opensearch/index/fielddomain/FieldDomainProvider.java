 * compatible open source license.
 * Resolves index-level field domains for a concrete index from a metadata source.
import org.opensearch.common.annotation.ExperimentalApi;
     */  
     * @return parsed domain when present and supported; otherwise empty
     *
/**  
    Optional<FieldDomain> getDomain(ClusterState clusterState, String indexName, String field);
public interface FieldDomainProvider {  
     * The {@code indexName} is resolved against the supplied {@link ClusterState}. Callers that need UUID-level identity
/*  
     * @param indexName concrete index name  
 * The OpenSearch Contributors require contributions made to  
 */
 * this file be licensed under the Apache-2.0 license or a
    /**
}
@ExperimentalApi
 *
     * @param clusterState cluster state visible to the coordinator
     * Returns field domains for the given concrete index and field.  
 */  
package org.opensearch.index.fielddomain;
     * @param field field name
     *
 * @opensearch.experimental  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Optional;
import org.opensearch.cluster.ClusterState;
 *
     * guarantees must ensure the name refers to the intended concrete index in that same cluster state.  
