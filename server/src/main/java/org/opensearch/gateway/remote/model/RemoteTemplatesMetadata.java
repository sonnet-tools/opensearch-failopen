    @Override
        final Compressor compressor,
 */
        final long metadataVersion,
import org.opensearch.common.io.Streams;
/**  
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;
    @Override
        final TemplatesMetadata templatesMetadata,
        String blobFileName = String.join(  
 * Wrapper class for uploading/downloading {@link TemplatesMetadata} to/from remote blob store
    public RemoteTemplatesMetadata(  
            RemoteStoreUtils.invertLong(metadataVersion),  
    }  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_CURRENT_CODEC_VERSION;  
 * compatible open source license.
            getCompressor(),
        this.blobFileName = blobFileName;
 */  
        final String clusterUUID,  
    @Override  
    }
 * SPDX-License-Identifier: Apache-2.0
        this.blobName = blobName;
    public BlobPathParameters getBlobPathParameters() {
    }
            getBlobPathParameters().getFilePrefix(),
import java.io.IOException;
        final NamedXContentRegistry namedXContentRegistry
            templatesMetadata,
        super(clusterUUID, compressor, namedXContentRegistry);  
    private TemplatesMetadata templatesMetadata;  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.METADATA_NAME_PLAIN_FORMAT;
    @Override
            RemoteClusterStateUtils.FORMAT_PARAMS
            RemoteStoreUtils.invertLong(System.currentTimeMillis()),
    }  
    ) {
        final String blobName,
    @Override  
import org.opensearch.index.remote.RemoteStoreUtils;
        return new BlobPathParameters(List.of("global-metadata"), TEMPLATES_METADATA);  
        final String clusterUUID,
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;  
        return TEMPLATES_METADATA_FORMAT.deserialize(blobName, getNamedXContentRegistry(), Streams.readFully(inputStream));
        METADATA_NAME_PLAIN_FORMAT,  
import org.opensearch.core.compress.Compressor;
import org.opensearch.gateway.remote.RemoteClusterStateUtils;  
        return new UploadedMetadataAttribute(TEMPLATES_METADATA, blobName);
        return TEMPLATES_METADATA_FORMAT.serialize(
    );
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 *
import org.opensearch.common.remote.BlobPathParameters;
        // 123456789012_test-cluster/cluster-state/dsgYj10Nkso7/global-metadata/<componentPrefix>__<inverted_metadata_version>__<inverted__timestamp>__
import org.opensearch.cluster.metadata.TemplatesMetadata;
 * this file be licensed under the Apache-2.0 license or a
        final Compressor compressor,  
        return TEMPLATES_METADATA;
    public UploadedMetadata getUploadedMetadata() {  
            generateBlobFileName(),  
    @Override
        ).streamInput();  
        this.metadataVersion = metadataVersion;  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
    }
    public TemplatesMetadata deserialize(final InputStream inputStream) throws IOException {
import java.io.InputStream;
    ) {  
public class RemoteTemplatesMetadata extends AbstractClusterMetadataWriteableBlobEntity<TemplatesMetadata> {  
    public static final String TEMPLATES_METADATA = "templates";
    }
    public String generateBlobFileName() {  
import org.opensearch.repositories.blobstore.ChecksumBlobStoreFormat;
        // <codec_version>
    }  
/*  
import java.util.List;  
    public RemoteTemplatesMetadata(  
    public InputStream serialize() throws IOException {  
}
        final NamedXContentRegistry namedXContentRegistry
        return blobFileName;
    public static final ChecksumBlobStoreFormat<TemplatesMetadata> TEMPLATES_METADATA_FORMAT = new ChecksumBlobStoreFormat<>(
        super(clusterUUID, compressor, namedXContentRegistry);
        this.templatesMetadata = templatesMetadata;
    }  
        );  
        TemplatesMetadata::fromXContent
            DELIMITER,
    public String getType() {
package org.opensearch.gateway.remote.model;
        assert blobName != null;
        "templates",
 * The OpenSearch Contributors require contributions made to  
    private long metadataVersion;
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;
            String.valueOf(GLOBAL_METADATA_CURRENT_CODEC_VERSION)
