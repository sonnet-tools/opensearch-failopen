            "hashes-of-consistent-settings",  
/*  
    @Override  
        super(clusterUUID, compressor, null);
}
    }  
    public InputStream serialize() throws IOException {
        this.blobName = blobName;  
import org.opensearch.gateway.remote.ClusterMetadataManifest;
    public BlobPathParameters getBlobPathParameters() {  
import org.opensearch.cluster.metadata.DiffableStringMap;
import org.opensearch.core.compress.Compressor;  
import org.opensearch.index.remote.RemoteStoreUtils;
import org.opensearch.common.remote.BlobPathParameters;
        final Compressor compressor,
    public ClusterMetadataManifest.UploadedMetadata getUploadedMetadata() {
            "hashes-of-consistent-settings",
 */  
package org.opensearch.gateway.remote.model;
        return hashesOfConsistentSettingsFormat.serialize(hashesOfConsistentSettings, generateBlobFileName(), getCompressor())  
            DiffableStringMap::readFrom
 * SPDX-License-Identifier: Apache-2.0
        final String clusterUUID,
        String blobFileName = String.join(
    public DiffableStringMap deserialize(final InputStream inputStream) throws IOException {
        assert blobName != null;  
        return new BlobPathParameters(List.of(GLOBAL_METADATA_PATH_TOKEN), HASHES_OF_CONSISTENT_SETTINGS);
        this.blobFileName = blobFileName;  
            DELIMITER,  
        final String clusterUUID,
        final DiffableStringMap hashesOfConsistentSettings,  
    @Override
    public String generateBlobFileName() {
        final Version version  
    ) {
    }
 * compatible open source license.
    @Override
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN;
        return new ClusterMetadataManifest.UploadedMetadataAttribute(HASHES_OF_CONSISTENT_SETTINGS, blobName);
 */  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
 * The OpenSearch Contributors require contributions made to  
            version
    public final ChecksumWritableBlobStoreFormat<DiffableStringMap> hashesOfConsistentSettingsFormat;  
            RemoteStoreUtils.invertLong(System.currentTimeMillis()),  
public class RemoteHashesOfConsistentSettings extends AbstractClusterMetadataWriteableBlobEntity<DiffableStringMap> {
        final long metadataVersion,
        return blobFileName;
        return hashesOfConsistentSettingsFormat.deserialize(blobName, Streams.readFully(inputStream));  
 *
            getBlobPathParameters().getFilePrefix(),
    public RemoteHashesOfConsistentSettings(
        );
        this.hashesOfConsistentSettings = hashesOfConsistentSettings;
        final Compressor compressor  
        );
        final String blobName,  
            String.valueOf(CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION)
        this.hashesOfConsistentSettingsFormat = new ChecksumWritableBlobStoreFormat<>(
    private DiffableStringMap hashesOfConsistentSettings;
            RemoteStoreUtils.invertLong(metadataVersion),
import java.io.IOException;
import org.opensearch.Version;
    @Override
import org.opensearch.common.io.Streams;  
import java.util.List;
    }
    }  
    @Override
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.CLUSTER_STATE_ATTRIBUTES_CURRENT_CODEC_VERSION;  
 * this file be licensed under the Apache-2.0 license or a
    ) {
    public static final String HASHES_OF_CONSISTENT_SETTINGS = "hashes-of-consistent-settings";
    }
            .streamInput();
    }
 * Wrapper class for uploading/downloading {@link DiffableStringMap} to/from remote blob store
        this.hashesOfConsistentSettingsFormat = new ChecksumWritableBlobStoreFormat<>(
/**
        this.metadataVersion = metadataVersion;  
    public RemoteHashesOfConsistentSettings(
            DiffableStringMap::readFrom,  
import org.opensearch.repositories.blobstore.ChecksumWritableBlobStoreFormat;  
import java.io.InputStream;  
    @Override
        );
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;
    }
    private long metadataVersion;  
        return HASHES_OF_CONSISTENT_SETTINGS;  
        super(clusterUUID, compressor, null);
    }
    public String getType() {
