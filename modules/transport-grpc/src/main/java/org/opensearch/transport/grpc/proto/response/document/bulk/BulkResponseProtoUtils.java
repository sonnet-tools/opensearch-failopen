                    itemBuilder.setCreate(responseItem);
/**
}
                case CREATE:
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.core.xcontent.ToXContent;
        if (response.getIngestTookInMillis() != BulkResponse.NO_INGEST_TOOK) {
 */
            org.opensearch.protobufs.Item.Builder itemBuilder = org.opensearch.protobufs.Item.newBuilder();  
     */
     * This method is equivalent to {@link BulkResponse#toXContent(XContentBuilder, ToXContent.Params)}
            }
            switch (bulkItemResponse.getOpType()) {  
 * Protocol Buffer representation.
        // Set the time taken for the bulk operation (excluding ingest preprocessing)
        // System.out.println("=== grpc bulk response=" + response.toString());  
    }
        // Set whether any operations failed  
     * Converts a BulkResponse to its Protocol Buffer representation.
     * @param response The BulkResponse to convert
 * this file be licensed under the Apache-2.0 license or a
        }
public class BulkResponseProtoUtils {  
                    break;  
 * SPDX-License-Identifier: Apache-2.0
        org.opensearch.protobufs.BulkResponse.Builder bulkResponse = org.opensearch.protobufs.BulkResponse.newBuilder();
import org.opensearch.core.xcontent.XContentBuilder;  
            org.opensearch.protobufs.ResponseItem responseItem = BulkItemResponseProtoUtils.toProto(bulkItemResponse);
 * The OpenSearch Contributors require contributions made to  
    /**  
        return bulkResponse.build();  
     *  
 */  
import org.opensearch.action.bulk.BulkItemResponse;  
package org.opensearch.transport.grpc.proto.response.document.bulk;
        // Add individual item responses for each operation in the bulk request  
 *
            // Wrap ResponseItem in Item based on operation type
     * @return A Protocol Buffer BulkResponse representation
            bulkResponse.addItems(itemBuilder.build());  
                case UPDATE:
    private BulkResponseProtoUtils() {
        bulkResponse.setErrors(response.hasFailures());
        // Set ingest preprocessing time if available
    }
                    itemBuilder.setUpdate(responseItem);
                case DELETE:
 * Utility class for converting BulkResponse objects to Protocol Buffers.
/*  
                    itemBuilder.setIndex(responseItem);
            bulkResponse.setIngestTook(response.getIngestTookInMillis());  
                    break;  
                    break;  
import java.io.IOException;
        for (BulkItemResponse bulkItemResponse : response.getItems()) {
        // Utility class, no instances  
        bulkResponse.setTook(response.getTook().getMillis());
 * This class handles the conversion of bulk operation responses to their  
     * @throws IOException if there's an error during conversion  
                    itemBuilder.setDelete(responseItem);
                    break;  
        }
 * compatible open source license.
                case INDEX:
    public static org.opensearch.protobufs.BulkResponse toProto(BulkResponse response) throws IOException {
