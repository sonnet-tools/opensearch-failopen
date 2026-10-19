 * The OpenSearch Contributors require contributions made to  
    public ClusterStateFieldDomainProvider() {  
        this.metadata = Objects.requireNonNull(metadata, "metadata must not be null");
import java.util.Map;
package org.opensearch.index.fielddomain;
 * compatible open source license.
     * Creates a provider using the built-in field-domain metadata parser.
        if (indexMetadata == null) {  
@ExperimentalApi
import org.opensearch.cluster.ClusterState;
        return metadata.fromCustomData(custom, field);  
 * Reads field-domain metadata from {@link IndexMetadata} custom data in cluster state.
 *
import org.opensearch.common.annotation.ExperimentalApi;  
/*  
            return Optional.empty();
import java.util.Objects;  
            return Optional.empty();  
public final class ClusterStateFieldDomainProvider implements FieldDomainProvider {  
            return Optional.empty();
}
        if (custom == null || custom.isEmpty()) {
 * @opensearch.experimental  
    }  
    ClusterStateFieldDomainProvider(IndexFieldDomainMetadata metadata) {
        this(IndexFieldDomainMetadata.getInstance());
    }
     */
    }
    @Override
import org.opensearch.cluster.metadata.IndexMetadata;
    /**
 * this file be licensed under the Apache-2.0 license or a
 */
 * SPDX-License-Identifier: Apache-2.0
 *
 */  
    public Optional<FieldDomain> getDomain(ClusterState clusterState, String indexName, String field) {  
    /**  
import java.util.Optional;
        if (clusterState == null || indexName == null || field == null || field.isEmpty()) {
        }
        }  
        IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
/**  
        Map<String, String> custom = indexMetadata.getCustomData(IndexFieldDomainMetadata.CUSTOM_KEY);
     * Resolves domains from {@code index_field_domains} custom metadata for a concrete index.  
     */
    private final IndexFieldDomainMetadata metadata;
        }
