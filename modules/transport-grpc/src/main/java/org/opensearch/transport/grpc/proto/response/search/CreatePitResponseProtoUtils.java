package org.opensearch.transport.grpc.proto.response.search;
     * @throws IOException if conversion fails
import java.io.IOException;  
     * Converts an OpenSearch create PIT response to protobuf.
    }
    public static CreatePITResponse toProto(CreatePitResponse response) throws IOException {  
            )
     * This method is equivalent to {@link CreatePitResponse#toXContent(XContentBuilder, ToXContent.Params)}  
import org.opensearch.action.search.CreatePitResponse;
    }
                response.getTotalShards(),  
        );  
                response.getSkippedShards(),
     * @param response the OpenSearch response
        return builder.build();
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.protobufs.CreatePITResponse;
}  
            ShardStatisticsProtoUtils.getShardStats(
     * @return the protobuf response  
        // Utility class, no instances
     *
 */  
 * SPDX-License-Identifier: Apache-2.0
                response.getSuccessfulShards(),
public class CreatePitResponseProtoUtils {
     */
                response.getShardFailures()
import org.opensearch.core.xcontent.ToXContent;
 */
    private CreatePitResponseProtoUtils() {  
 * Utility class for converting PIT creation responses to protobuf.  
        builder.setCreationTime(response.getCreationTime());  
/*  
        CreatePITResponse.Builder builder = CreatePITResponse.newBuilder();
 *
        builder.setXShards(
 * The OpenSearch Contributors require contributions made to  
/**
    /**
 * this file be licensed under the Apache-2.0 license or a
                response.getFailedShards(),  
        builder.setPitId(response.getId());
