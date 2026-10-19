    ) {
                            .put(settings)
                    .settings(
 * this file be licensed under the Apache-2.0 license or a
@SuppressForbidden(reason = "feature flag overrides")
        int remoteIndices,
                            .put(settings)  
            );  
        for (int i = 0; i < remoteIndices; i++) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.SuppressForbidden;
        ClusterState clusterState,
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.Metadata;  
/*  
                        Settings.builder()  
        for (int i = 0; i < localIndices; i++) {  
        return ClusterState.builder(clusterState).metadata(metadata).build();
            IndexMetadata indexMetadata = clusterState.metadata().index(getIndexName(i, true));  
                            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), isWarmIndex)  
        Metadata.Builder mb = Metadata.builder(clusterState.metadata());
            Settings settings = indexMetadata.getSettings();
        int localIndices,  
 */  
                            .put(settings)
                    )
        }
                            .put(INDEX_TIERING_STATE.getKey(), tieringState)  
 * SPDX-License-Identifier: Apache-2.0
    }  
                            .put(INDEX_TIERING_STATE.getKey(), tieringState)
            mb.put(
    public ClusterState updateIndexMetadataForTiering(
        Metadata metadata = mb.build();
        boolean isWarmIndex  
        String tieringState,
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
package org.opensearch.cluster.routing.allocation;
                    )
public abstract class TieringAllocationBaseTestCase extends RemoteShardsBalancerBaseTestCase {
 * compatible open source license.
                    .settings(
                            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), isWarmIndex)
            mb.put(  
 *
                            .put(settings)
                IndexMetadata.builder(indexMetadata)
            IndexMetadata indexMetadata = clusterState.metadata().index(getIndexName(i, false));
            );
            Settings settings = indexMetadata.getSettings();
import org.opensearch.cluster.metadata.IndexMetadata;
        }  
import org.opensearch.cluster.ClusterState;
                IndexMetadata.builder(indexMetadata)  
import org.opensearch.index.IndexModule;  
                        Settings.builder()
}
