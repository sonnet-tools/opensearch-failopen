    public List<StoreFileMetadata> getFiles() {
    public GetSegmentFilesResponse(StreamInput out) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
/**  
    }
        this.files = files;
}
package org.opensearch.indices.replication;
public class GetSegmentFilesResponse extends TransportResponse {
        out.writeCollection(files);
    }  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
        out.readList(StoreFileMetadata::new);
    public void writeTo(StreamOutput out) throws IOException {
 *
        return files;  
    }  
import org.opensearch.core.transport.TransportResponse;  
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override  
import java.io.IOException;  
import org.opensearch.index.store.StoreFileMetadata;
 */  
    }
    public GetSegmentFilesResponse(List<StoreFileMetadata> files) {  
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    List<StoreFileMetadata> files;
 */
 * Response from a {@link SegmentReplicationSource} indicating that a replication event has completed.
 * @opensearch.internal  
