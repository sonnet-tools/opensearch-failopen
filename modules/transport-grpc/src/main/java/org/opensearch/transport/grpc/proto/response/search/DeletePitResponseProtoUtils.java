     * @return the protobuf response  
    }
    private DeletePitResponseProtoUtils() {
import org.opensearch.protobufs.DeletePITResponse;  
/*  
    }  
 * this file be licensed under the Apache-2.0 license or a
     * @param response the OpenSearch response
            builder.addPits(DeletedPit.newBuilder().setSuccessful(pitInfo.isSuccessful()).setPitId(pitInfo.getPitId()).build());
import org.opensearch.protobufs.DeletedPit;
    public static DeletePITResponse toProto(DeletePitResponse response) {
 */
    /**
     *
/**  
 *
        // Utility class, no instances
     */
}  
     * Converts an OpenSearch delete PIT response to protobuf.  
        DeletePITResponse.Builder builder = DeletePITResponse.newBuilder();  
package org.opensearch.transport.grpc.proto.response.search;
        for (DeletePitInfo pitInfo : response.getDeletePitResults()) {
public class DeletePitResponseProtoUtils {  
 * SPDX-License-Identifier: Apache-2.0
 * Utility class for converting PIT deletion responses to protobuf.
        }  
import org.opensearch.action.search.DeletePitResponse;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        return builder.build();
 */  
import org.opensearch.action.search.DeletePitInfo;
