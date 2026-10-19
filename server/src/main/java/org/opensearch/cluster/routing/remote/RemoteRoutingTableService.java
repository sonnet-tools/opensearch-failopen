        String clusterUUID,
}  
 */
/*  
        List<String> updatedIndicesRouting,
        LatchedActionListener<Diff<RoutingTable>> latchedActionListener,
    List<ClusterMetadataManifest.UploadedIndexMetadata> getAllUploadedIndicesRouting(
        long version,
        StringKeyDiffProvider<IndexRoutingTable> routingTableDiff,
        long version,  
 *
import org.opensearch.cluster.routing.RoutingTable;
 * compatible open source license.
        String uploadedFilename,
    List<IndexRoutingTable> getIndicesRouting(RoutingTable routingTable);
 * this file be licensed under the Apache-2.0 license or a
    );
    );
    void deleteStaleIndexRoutingPaths(List<String> stalePaths) throws IOException;
        LatchedActionListener<IndexRoutingTable> latchedActionListener,
        String clusterUUID,
import org.opensearch.cluster.Diff;  
    void getAsyncIndexRoutingWriteAction(
    StringKeyDiffProvider<IndexRoutingTable> getIndicesRoutingMapDiff(RoutingTable before, RoutingTable after);
        LatchedActionListener<ClusterMetadataManifest.UploadedMetadata> latchedActionListener
import org.opensearch.cluster.routing.StringKeyDiffProvider;  
 *  
import java.util.List;
    );  
    List<ClusterMetadataManifest.UploadedIndexMetadata> getUpdatedIndexRoutingTableMetadata(  
 */  
        String clusterUUID,  
        List<String> indicesRoutingToDelete
import org.opensearch.action.LatchedActionListener;
        String clusterUUID,
    void deleteStaleIndexRoutingDiffPaths(List<String> stalePaths) throws IOException;
 * SPDX-License-Identifier: Apache-2.0
    );  
import org.opensearch.gateway.remote.ClusterMetadataManifest;
package org.opensearch.cluster.routing.remote;
    );  
import org.opensearch.common.lifecycle.LifecycleComponent;
public interface RemoteRoutingTableService extends LifecycleComponent {  
 * A Service which provides APIs to upload and download routing table from remote store.
    );  
import java.io.IOException;
import org.opensearch.cluster.routing.IndexRoutingTable;
        long term,  
        List<ClusterMetadataManifest.UploadedIndexMetadata> indicesRoutingUploaded,
        Version version  
 * The OpenSearch Contributors require contributions made to  
        Version version
        String uploadedFilename,  
    void getAsyncIndexRoutingTableDiffReadAction(
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndicesRouting
    void getAsyncIndexRoutingReadAction(
        LatchedActionListener<ClusterMetadataManifest.UploadedMetadata> latchedActionListener  
/**
        long term,
        ClusterMetadataManifest previousManifest,  
    void getAsyncIndexRoutingDiffWriteAction(  
 * @opensearch.internal
import org.opensearch.Version;
        IndexRoutingTable indexRouting,
