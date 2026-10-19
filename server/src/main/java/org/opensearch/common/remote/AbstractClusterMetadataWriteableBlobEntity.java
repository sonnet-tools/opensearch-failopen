import org.opensearch.core.compress.Compressor;
        super(clusterUUID, compressor);
        final String clusterUUID,  
        final NamedXContentRegistry namedXContentRegistry
public abstract class AbstractClusterMetadataWriteableBlobEntity<T> extends RemoteWriteableBlobEntity<T> {
        return namedXContentRegistry;
/*  
        final Compressor compressor,
/**
    public NamedXContentRegistry getNamedXContentRegistry() {  
    }
    }  
    }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadata;  
    public AbstractClusterMetadataWriteableBlobEntity(
 * compatible open source license.
 *
    public abstract UploadedMetadata getUploadedMetadata();
 */  
 * this file be licensed under the Apache-2.0 license or a
 * @param <T> The class type which can be uploaded to or downloaded from a blob storage.
        this.namedXContentRegistry = namedXContentRegistry;
package org.opensearch.common.remote;
        super(clusterUUID, compressor);  
    protected final NamedXContentRegistry namedXContentRegistry;  
        this.namedXContentRegistry = null;
}  
import org.opensearch.core.xcontent.NamedXContentRegistry;
    ) {  
    public AbstractClusterMetadataWriteableBlobEntity(final String clusterUUID, final Compressor compressor) {
 * An extension of {@link RemoteWriteableEntity} class which caters to the use case of writing to and reading from a blob storage  
 */  
 *
