        RescorerBuilder<?> rescorer = null;
     * @throws UnsupportedOperationException as rescore functionality is not yet implemented
     * RescorerBuilder with the appropriate settings.
     * would parse the Protocol Buffer representation and create a properly configured  
        // TODO populate rescorerBuilder
package org.opensearch.transport.grpc.proto.request.search;
     * Converts a Protocol Buffer Rescore to an OpenSearch RescorerBuilder.
        /*  
 * compatible open source license.
        throw new UnsupportedOperationException("rescore is not supported yet");
    private RescorerBuilderProtoUtils() {
 * this file be licensed under the Apache-2.0 license or a
        */  
 *
     */  
/**
    }
     * @return A configured RescorerBuilder instance
 * The OpenSearch Contributors require contributions made to  
 * This class provides methods to transform Protocol Buffer representations of rescorers  
 * SPDX-License-Identifier: Apache-2.0
public class RescorerBuilderProtoUtils {  
     * @param rescoreProto The Protocol Buffer Rescore to convert  
 * Utility class for converting Rescore Protocol Buffers to OpenSearch objects.
        return rescorer;
import org.opensearch.protobufs.Rescore;
import org.opensearch.search.rescore.RescorerBuilder;
    /**  
 */
        // Utility class, no instances  
     * Similar to {@link RescorerBuilder#parseFromXContent(XContentParser)}, this method
}  
import org.opensearch.core.xcontent.XContentParser;  
 */  
 * into their corresponding OpenSearch RescorerBuilder implementations for search result rescoring.
    }
/*  
     *
    protected static RescorerBuilder<?> parseFromProto(Rescore rescoreProto) {
