    }
    public static Custom readFrom(StreamInput streamInput, NamedWriteableRegistry namedWriteableRegistry, String customType)  
    public static final String CUSTOM_DELIMITER = "--";
    public BlobPathParameters getBlobPathParameters() {
        Compressor compressor,  
    public RemoteCustomMetadata(
        );  
        NamedWriteableRegistry namedWriteableRegistry
            getBlobPathParameters().getFilePrefix(),
    @Override
 * SPDX-License-Identifier: Apache-2.0
        }
/**
    }  
        return blobFileName;
        this.custom = custom;
            DELIMITER,
    }
    ) {
import org.opensearch.common.remote.BlobPathParameters;
        final String customType,
import java.io.IOException;  
        final String clusterUUID,
        return customBlobStoreFormat.deserialize(blobName, Streams.readFully(inputStream));  
 * Wrapper class for uploading/downloading {@link Custom} to/from remote blob store  
    @Override
            is -> readFrom(is, namedWriteableRegistry, customType)
            version
        return CUSTOM_METADATA;
        // 123456789012_test-cluster/cluster-state/dsgYj10Nkso7/global-metadata/<componentPrefix>__<inverted_metadata_version>__<inverted__timestamp>__
        final Compressor compressor,  
    @Override  
        this.customType = customType;
    @Override
import org.opensearch.cluster.metadata.Metadata.Custom;
    private Custom custom;
 * this file be licensed under the Apache-2.0 license or a
    }  
        final String blobName,  
}  
 */
    ) {  
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
        final NamedWriteableRegistry namedWriteableRegistry,
        try (StreamInput in = new NamedWriteableAwareStreamInput(streamInput, namedWriteableRegistry)) {
    @Override  
    }  
            RemoteStoreUtils.invertLong(System.currentTimeMillis()),
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            is -> readFrom(is, namedWriteableRegistry, customType),
    public RemoteCustomMetadata(
        final Custom custom,
import java.util.List;
        return customBlobStoreFormat.serialize(custom, generateBlobFileName(), getCompressor()).streamInput();
        return new BlobPathParameters(List.of(GLOBAL_METADATA_PATH_TOKEN), prefix);  
        this.customType = customType;  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;
public class RemoteCustomMetadata extends AbstractClusterMetadataWriteableBlobEntity<Custom> {
    public final ChecksumWritableBlobStoreFormat<Custom> customBlobStoreFormat;  
import org.opensearch.core.compress.Compressor;  
 *
        String prefix = String.join(CUSTOM_DELIMITER, CUSTOM_METADATA, customType);
        this.blobFileName = blobFileName;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
        assert blobName != null;
    public static final String CUSTOM_METADATA = "custom";
            return namedWriteableRegistry.getReader(Custom.class, customType).read(in);  
    public String getType() {
        super(clusterUUID, compressor, null);
        );  
        final String customType,  
    }
/*  
        this.customBlobStoreFormat = new ChecksumWritableBlobStoreFormat<>(
            String.valueOf(GLOBAL_METADATA_CURRENT_CODEC_VERSION)
        final long metadataVersion,
        super(clusterUUID, compressor, null);  
            "custom",  
            "custom",  
import java.io.InputStream;
    public Custom deserialize(final InputStream inputStream) throws IOException {
import org.opensearch.repositories.blobstore.ChecksumWritableBlobStoreFormat;
    private final String customType;  
        this.customBlobStoreFormat = new ChecksumWritableBlobStoreFormat<>(
        throws IOException {
    }
package org.opensearch.gateway.remote.model;
    private long metadataVersion;
        // <codec_version>
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN;  
import org.opensearch.common.io.Streams;  
import org.opensearch.index.remote.RemoteStoreUtils;  
    }
        this.namedWriteableRegistry = namedWriteableRegistry;
    public String generateBlobFileName() {  
        this.namedWriteableRegistry = namedWriteableRegistry;
    public InputStream serialize() throws IOException {  
        final Version version
 */  
    @Override  
        return new UploadedMetadataAttribute(String.join(CUSTOM_DELIMITER, CUSTOM_METADATA, customType), blobName);  
        );
import org.opensearch.Version;
        this.metadataVersion = metadataVersion;  
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_CURRENT_CODEC_VERSION;
            RemoteStoreUtils.invertLong(metadataVersion),  
    private final NamedWriteableRegistry namedWriteableRegistry;
 * compatible open source license.
        String blobFileName = String.join(  
    }
        final String clusterUUID,
    public UploadedMetadata getUploadedMetadata() {
        this.blobName = blobName;
