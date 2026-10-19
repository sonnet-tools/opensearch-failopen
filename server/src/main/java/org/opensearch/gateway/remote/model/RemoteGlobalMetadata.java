    }  
/**  
    public BlobPathParameters getBlobPathParameters() {
}  
        final Compressor compressor,  
import org.opensearch.repositories.blobstore.ChecksumBlobStoreFormat;
        "metadata",
 */  
    public String generateBlobFileName() {  
        final String blobName,
        Metadata::fromXContent  
        super(clusterUUID, compressor, namedXContentRegistry);  
        return GLOBAL_METADATA;
    @Override
    public static final String GLOBAL_METADATA = "global_metadata";
    }  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    );
    @Override  
    }
        return GLOBAL_METADATA_FORMAT.deserialize(blobName, getNamedXContentRegistry(), Streams.readFully(inputStream));
import org.opensearch.common.remote.BlobPathParameters;
    @Override
public class RemoteGlobalMetadata extends AbstractClusterMetadataWriteableBlobEntity<Metadata> {  
 */
        throw new UnsupportedOperationException();  
        METADATA_NAME_FORMAT,
    public String getType() {
        throw new UnsupportedOperationException();
    @Override
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.METADATA_NAME_FORMAT;
    public InputStream serialize() throws IOException {
    public RemoteGlobalMetadata(  
import java.io.IOException;
        this.blobName = blobName;
import org.opensearch.core.compress.Compressor;
    public Metadata deserialize(final InputStream inputStream) throws IOException {  
import java.io.InputStream;
import org.opensearch.common.io.Streams;
    ) {
package org.opensearch.gateway.remote.model;
    }
    public UploadedMetadata getUploadedMetadata() {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        final String clusterUUID,
    public static final ChecksumBlobStoreFormat<Metadata> GLOBAL_METADATA_FORMAT = new ChecksumBlobStoreFormat<>(  
        throw new UnsupportedOperationException();  
    }
/*  
 *
        final NamedXContentRegistry namedXContentRegistry
import org.opensearch.common.remote.AbstractClusterMetadataWriteableBlobEntity;  
    @Override  
 * compatible open source license.
        throw new UnsupportedOperationException();
 * Wrapper class for uploading/downloading global metadata ({@link Metadata}) to/from remote blob store
    }
import org.opensearch.cluster.metadata.Metadata;
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;  
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;
