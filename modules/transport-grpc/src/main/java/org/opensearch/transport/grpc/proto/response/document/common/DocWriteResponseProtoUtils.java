 * compatible open source license.
     */
        // Handle shard information  
 * Utility class for converting DocWriteResponse objects to Protocol Buffers.  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContent;
        if (response.getId() != null && !response.getId().isEmpty()) {
}  
        // Utility class, no instances
        if (response.forcedRefresh()) {  
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
        // Set operation result (CREATED, UPDATED, DELETED, NOT_FOUND, NOOP)
import org.opensearch.protobufs.ResponseItem;  
        }  
        }
 */  
        return responseItem;
        ResponseItem.Builder responseItem = ResponseItem.newBuilder();
 *
import org.opensearch.core.xcontent.XContentBuilder;
        // Set the index name  
            responseItem.setXId(response.getId());
            responseItem.setXSeqNo(response.getSeqNo());  
     * @param response The DocWriteResponse to convert
        ShardInfo shardInfo = ShardInfoProtoUtils.toProto(response.getShardInfo());
    /**
 * to their Protocol Buffer representation.
import org.opensearch.protobufs.ShardInfo;
        // Set forced refresh flag if applicable
     *
        // Handle document ID (can be null in some cases)  
 * This class handles the conversion of document write operation responses (index, create, update, delete)
    private DocWriteResponseProtoUtils() {  
        // Set sequence number and primary term if available
        responseItem.setXIndex(response.getIndex());
    }
        responseItem.setResult(response.getResult().getLowercase());  
            responseItem.setXPrimaryTerm(response.getPrimaryTerm());
     * This method is equivalent to the {@link DocWriteResponse#innerToXContent(XContentBuilder, ToXContent.Params)}  
/*  
        if (response.getSeqNo() >= 0) {
/**
public class DocWriteResponseProtoUtils {
        // Set document version
 * SPDX-License-Identifier: Apache-2.0
     * @return A ResponseItem.Builder with the DocWriteResponse data  
     * Converts a DocWriteResponse to its Protocol Buffer representation.
    public static ResponseItem.Builder toProto(DocWriteResponse response) throws IOException {  
     *
            responseItem.setForcedRefresh(true);
package org.opensearch.transport.grpc.proto.response.document.common;
        }
    }
        responseItem.setXVersion(response.getVersion());  
 */  
        responseItem.setXShards(shardInfo);
import org.opensearch.action.DocWriteResponse;  
