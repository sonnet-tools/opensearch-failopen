 * this file be licensed under the Apache-2.0 license or a
            mergedSegmentCheckpoint.getShardId(),
        Map<String, String> localToRemoteSegmentFilenameMap
 * compatible open source license.
 */  
        out.writeMap(getLocalToRemoteSegmentFilenameMap(), StreamOutput::writeString, StreamOutput::writeString);  
        MergedSegmentCheckpoint mergedSegmentCheckpoint,
    public RemoteStoreMergedSegmentCheckpoint(  
    public Map<String, String> getLocalToRemoteSegmentFilenameMap() {  
        );  
    }
@ExperimentalApi
 *
 */
    }
            mergedSegmentCheckpoint.getLength(),
import org.opensearch.common.annotation.ExperimentalApi;
        return this.localToRemoteSegmentFilenameMap;
        super(
import java.io.IOException;
            mergedSegmentCheckpoint.getMetadataMap(),
            mergedSegmentCheckpoint.getSegmentInfosVersion(),
        super(in);
 * Represents a remote store merged segment checkpoint.
public class RemoteStoreMergedSegmentCheckpoint extends MergedSegmentCheckpoint {  
 * @opensearch.internal  
    public void writeTo(StreamOutput out) throws IOException {
            mergedSegmentCheckpoint.getSegmentName()
        super.writeTo(out);
}  
    @Override  
    }
        this.localToRemoteSegmentFilenameMap = Collections.unmodifiableMap(in.readMap(StreamInput::readString, StreamInput::readString));  
 * SPDX-License-Identifier: Apache-2.0
/*  
/**  
package org.opensearch.indices.replication.checkpoint;
            mergedSegmentCheckpoint.getCodec(),  
    }
    public RemoteStoreMergedSegmentCheckpoint(StreamInput in) throws IOException {
import java.util.Collections;  
import java.util.Map;
        this.localToRemoteSegmentFilenameMap = Collections.unmodifiableMap(localToRemoteSegmentFilenameMap);
import org.opensearch.core.common.io.stream.StreamOutput;  
    private final Map<String, String> localToRemoteSegmentFilenameMap;
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.core.common.io.stream.StreamInput;
    ) {  
            mergedSegmentCheckpoint.getPrimaryTerm(),  
