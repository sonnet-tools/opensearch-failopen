    @Override
import java.util.List;
 * compatible open source license.
        return discoveryNodesFormat.deserialize(blobName, Streams.readFully(inputStream));
    }
            generateBlobFileName(),  
    }  
    }
        final DiscoveryNodes discoveryNodes,
import org.opensearch.index.remote.RemoteStoreUtils;  
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;
package org.opensearch.gateway.remote.model;
 * Wrapper class for uploading/downloading {@link DiscoveryNodes} to/from remote blob store  
            (out, discoveryNode) -> discoveryNode.writeToWithAttribute(out),
    public static final String DISCOVERY_NODES = "nodes";
            getBlobPathParameters().getFilePrefix(),
import org.opensearch.common.remote.BlobPathParameters;
/*  
    @Override
        final String clusterUUID,
        return DISCOVERY_NODES;
 */
 *
        return new UploadedMetadataAttribute(DISCOVERY_NODES, blobName);
        return blobFileName;
    public RemoteDiscoveryNodes(
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;
        String blobFileName = String.join(
    }
public class RemoteDiscoveryNodes extends AbstractClusterMetadataWriteableBlobEntity<DiscoveryNodes> {
        super(clusterUUID, compressor, null);
        this.stateVersion = stateVersion;  
/**
    }  
    @Override
        final Compressor compressor
    public InputStream serialize() throws IOException {
        assert blobName != null;  
import java.io.IOException;  
    public RemoteDiscoveryNodes(final String blobName, final String clusterUUID, final Compressor compressor, final Version version) {
        );
import org.opensearch.cluster.node.DiscoveryNodes;
    public DiscoveryNodes deserialize(final InputStream inputStream) throws IOException {  
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;
    public final ChecksumWritableBlobStoreFormat<DiscoveryNodes> discoveryNodesFormat;
 */  
            DELIMITER,  
import org.opensearch.core.compress.Compressor;  
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;  
        super(clusterUUID, compressor, null);
            discoveryNodes,
        this.discoveryNodesFormat = new ChecksumWritableBlobStoreFormat<>("nodes", is -> DiscoveryNodes.readFrom(is, null), version);
    private DiscoveryNodes discoveryNodes;
    @Override  
import org.opensearch.common.io.Streams;  
        this.blobName = blobName;  
            RemoteStoreUtils.invertLong(stateVersion),
    @Override
}  
import org.opensearch.Version;
        ).streamInput();
    public UploadedMetadata getUploadedMetadata() {
        return new BlobPathParameters(List.of(CLUSTER_STATE_EPHEMERAL_PATH_TOKEN), DISCOVERY_NODES);  
    public BlobPathParameters getBlobPathParameters() {
    public String generateBlobFileName() {  
 * The OpenSearch Contributors require contributions made to  
    private long stateVersion;
    public String getType() {
        this.blobFileName = blobFileName;  
 * SPDX-License-Identifier: Apache-2.0
    ) {  
    }
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_EPHEMERAL_PATH_TOKEN;
        final long stateVersion,  
import java.io.InputStream;
        this.discoveryNodes = discoveryNodes;
    }
            getCompressor()
        // 123456789012_test-cluster/cluster-state/dsgYj10Nkso7/ephemeral/<componentPrefix>__<inverted_state_version>__<inverted__timestamp>__<codec_version>
        return discoveryNodesFormat.serialize(  
import org.opensearch.repositories.blobstore.ChecksumWritableBlobStoreFormat;
    @Override
            String.valueOf(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION)
        this.discoveryNodesFormat = new ChecksumWritableBlobStoreFormat<>("nodes", is -> DiscoveryNodes.readFrom(is, null));
 * this file be licensed under the Apache-2.0 license or a
    }
            RemoteStoreUtils.invertLong(System.currentTimeMillis()),  
