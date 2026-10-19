    }  
/*  
 *
     * @param indexOutput metadata file input stream
        this.version = version;
import org.apache.lucene.store.IndexInput;
public class RemoteSegmentMetadataHandler implements IndexIOStreamHandler<RemoteSegmentMetadata> {  
    /**
        content.write(indexOutput);
 * this file be licensed under the Apache-2.0 license or a
 */  
     */  
    }
 * @opensearch.internal
    /**  
     * @param indexInput metadata file input stream with {@link IndexInput#getFilePointer()} pointing to metadata content
     * Writes metadata to file output stream
import java.io.IOException;
    public RemoteSegmentMetadataHandler(int version) {
/**
    public void writeContent(IndexOutput indexOutput, RemoteSegmentMetadata content) throws IOException {  
     * Reads metadata content from metadata file input stream and parsed into {@link RemoteSegmentMetadata}  
     */
     * @param content {@link RemoteSegmentMetadata} from which metadata content would be generated  
        return RemoteSegmentMetadata.read(indexInput, version);  
import org.apache.lucene.store.IndexOutput;
    @Override
}  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
     * @return {@link RemoteSegmentMetadata}
    public RemoteSegmentMetadata readContent(IndexInput indexInput) throws IOException {
    @Override
 */
    private final int version;
package org.opensearch.index.store.remote.metadata;
 *  
 * Handler for {@link RemoteSegmentMetadata}
    }
import org.opensearch.common.io.IndexIOStreamHandler;  
