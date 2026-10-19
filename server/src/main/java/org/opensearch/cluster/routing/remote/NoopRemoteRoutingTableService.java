/**
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        StringKeyDiffProvider<IndexRoutingTable> routingTableDiff,  
        LatchedActionListener<ClusterMetadataManifest.UploadedMetadata> latchedActionListener
    public List<ClusterMetadataManifest.UploadedIndexMetadata> getAllUploadedIndicesRouting(
    public void getAsyncIndexRoutingReadAction(
        // noop  
    }
package org.opensearch.cluster.routing.remote;
    ) {  
/*  
    }
    public void getAsyncIndexRoutingDiffWriteAction(
    public void deleteStaleIndexRoutingDiffPaths(List<String> stalePaths) throws IOException {
        List<String> indicesRoutingToDelete
        String uploadedFilename,
    }
        // noop  
    }
    @Override  
        // noop
        // noop  
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndicesRouting  
    }
    @Override  
    @Override
        List<String> updatedIndicesRouting,
        List<ClusterMetadataManifest.UploadedIndexMetadata> indicesRoutingUploaded,  
    @Override
 * compatible open source license.
        long version,  
    @Override
    }
    public void getAsyncIndexRoutingWriteAction(  
    }
    }  
    @Override  
    }
    }  
import java.io.IOException;
        // noop
 */  
    @Override  
        // noop
        LatchedActionListener<ClusterMetadataManifest.UploadedMetadata> latchedActionListener
    protected void doStart() {
        return List.of();  
        LatchedActionListener<IndexRoutingTable> latchedActionListener,
import org.opensearch.cluster.routing.StringKeyDiffProvider;
        ClusterMetadataManifest previousManifest,
    }  
 * SPDX-License-Identifier: Apache-2.0
    public List<IndexRoutingTable> getIndicesRouting(RoutingTable routingTable) {
import org.opensearch.Version;
    ) {
        return List.of();  
        IndexRoutingTable indexRouting,
import org.opensearch.cluster.routing.RoutingTable;
        String clusterUUID,  
import org.opensearch.cluster.Diff;  
        long term,
    @Override
public class NoopRemoteRoutingTableService extends AbstractLifecycleComponent implements RemoteRoutingTableService {
import org.opensearch.gateway.remote.ClusterMetadataManifest;  
    public List<ClusterMetadataManifest.UploadedIndexMetadata> getUpdatedIndexRoutingTableMetadata(
        // noop  
        LatchedActionListener<Diff<RoutingTable>> latchedActionListener,  
import java.util.List;  
    @Override  
    @Override
    protected void doStop() {  
        return List.of();
        Version version
        return new RoutingTableIncrementalDiff(RoutingTable.builder().build(), RoutingTable.builder().build());
import org.opensearch.action.LatchedActionListener;
    public void getAsyncIndexRoutingTableDiffReadAction(  
        String uploadedFilename,
 *
 * Noop impl for RemoteRoutingTableService.  
import org.opensearch.cluster.routing.IndexRoutingTable;
    protected void doClose() throws IOException {
    ) {
 */
        String clusterUUID,
 * The OpenSearch Contributors require contributions made to  
        // noop
        long version,
}
        Version version  
    ) {
    }  
    @Override
    }
        // noop
    public StringKeyDiffProvider<IndexRoutingTable> getIndicesRoutingMapDiff(RoutingTable before, RoutingTable after) {
        // noop  
        String clusterUUID,
import org.opensearch.cluster.routing.RoutingTableIncrementalDiff;  
    ) {
        long term,
    public void deleteStaleIndexRoutingPaths(List<String> stalePaths) throws IOException {
        // noop
    @Override
 * this file be licensed under the Apache-2.0 license or a
    ) {
        String clusterUUID,  
