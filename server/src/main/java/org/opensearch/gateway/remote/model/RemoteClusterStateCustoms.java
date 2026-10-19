    private long stateVersion;  
        );
        this.customType = customType;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
    public ClusterMetadataManifest.UploadedMetadata getUploadedMetadata() {  
            DELIMITER,
 * Wrapper class for uploading/downloading {@link Custom} to/from remote blob store  
    @Override  
        super(clusterUUID, compressor, null);
    private final NamedWriteableRegistry namedWriteableRegistry;  
        return new BlobPathParameters(List.of(CLUSTER_STATE_EPHEMERAL_PATH_TOKEN), prefix);
    public RemoteClusterStateCustoms(  
import java.io.InputStream;  
        super(clusterUUID, compressor, null);
import java.util.List;
    public final ChecksumWritableBlobStoreFormat<ClusterState.Custom> clusterStateCustomsFormat;
import org.opensearch.cluster.ClusterState;
    }
    }
package org.opensearch.gateway.remote.model;
        this.namedWriteableRegistry = namedWriteableRegistry;
        final Version version  
 * SPDX-License-Identifier: Apache-2.0
public class RemoteClusterStateCustoms extends AbstractClusterMetadataWriteableBlobEntity<Custom> {
            is -> readFrom(is, namedWriteableRegistry, customType),
        final ClusterState.Custom custom,  
import org.opensearch.index.remote.RemoteStoreUtils;
 * this file be licensed under the Apache-2.0 license or a
        return clusterStateCustomsFormat.serialize(custom, generateBlobFileName(), getCompressor()).streamInput();
 */  
import org.opensearch.core.compress.Compressor;  
        final long stateVersion,
        return new ClusterMetadataManifest.UploadedMetadataAttribute(
            RemoteStoreUtils.invertLong(stateVersion),  
        this.blobName = blobName;  
/**
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;
    }  
import org.opensearch.Version;
        final String clusterUUID,  
    ) {
        this.custom = custom;
import org.opensearch.common.io.Streams;
        );  
        );  
/*  
        throws IOException {
        final NamedWriteableRegistry namedWriteableRegistry
    public ClusterState.Custom deserialize(final InputStream inputStream) throws IOException {
            "cluster-state-custom",
import org.opensearch.gateway.remote.ClusterMetadataManifest;
        assert blobName != null;
import org.opensearch.core.common.io.stream.StreamInput;
 */
        );
        final Compressor compressor,
    }
    }
    public RemoteClusterStateCustoms(
            version  
        this.customType = customType;  
    @Override
    }
    @Override
    @Override
        return CLUSTER_STATE_CUSTOM;  
    public String generateBlobFileName() {
        final String clusterUUID,  
        final String customType,
        this.stateVersion = stateVersion;
import org.opensearch.cluster.ClusterState.Custom;  
            blobName
        String prefix = String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, customType);  
 * compatible open source license.
    ) {  
    public String getType() {
            getBlobPathParameters().getFilePrefix(),
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CUSTOM_DELIMITER;
        final Compressor compressor,
        final NamedWriteableRegistry namedWriteableRegistry,
        // 123456789012_test-cluster/cluster-state/dsgYj10Nkso7/ephemeral/<componentPrefix>__<inverted_state_version>__<inverted__timestamp>__<codec_version>
        return blobFileName;
        return clusterStateCustomsFormat.deserialize(blobName, Streams.readFully(inputStream));  
        return namedWriteableRegistry.getReader(ClusterState.Custom.class, customType).read(streamInput);
            is -> readFrom(is, namedWriteableRegistry, customType)
import java.io.IOException;
        this.clusterStateCustomsFormat = new ChecksumWritableBlobStoreFormat<>(  
    private ClusterState.Custom custom;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_EPHEMERAL_PATH_TOKEN;
    private final String customType;
 *
    public static final String CLUSTER_STATE_CUSTOM = "cluster-state-custom";  
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION;  
            "cluster-state-custom",
}
    @Override
            RemoteStoreUtils.invertLong(System.currentTimeMillis()),
        final String customType,
import org.opensearch.repositories.blobstore.ChecksumWritableBlobStoreFormat;  
            String.join(CUSTOM_DELIMITER, CLUSTER_STATE_CUSTOM, customType),  
    }  
import org.opensearch.common.remote.BlobPathParameters;  
        this.blobFileName = blobFileName;
            String.valueOf(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION)
    }  
 * The OpenSearch Contributors require contributions made to  
    public BlobPathParameters getBlobPathParameters() {
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;  
        String blobFileName = String.join(  
        this.namedWriteableRegistry = namedWriteableRegistry;
        this.clusterStateCustomsFormat = new ChecksumWritableBlobStoreFormat<>(  
    public static ClusterState.Custom readFrom(StreamInput streamInput, NamedWriteableRegistry namedWriteableRegistry, String customType)  
    @Override
        final String blobName,
    public InputStream serialize() throws IOException {  
