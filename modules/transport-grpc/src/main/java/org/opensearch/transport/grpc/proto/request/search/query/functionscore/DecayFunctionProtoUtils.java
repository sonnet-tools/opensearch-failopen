 * Common utility class for decay function Protocol Buffer conversions.  
     * Converts a Protocol Buffer MultiValueMode enum to OpenSearch MultiValueMode.
        };  
    static org.opensearch.search.MultiValueMode parseMultiValueMode(MultiValueMode multiValueMode) {
import org.opensearch.protobufs.MultiValueMode;  
/*  
            case MULTI_VALUE_MODE_MIN -> org.opensearch.search.MultiValueMode.MIN;  
    /**
}
 *
     */
 */  
     * @return the corresponding OpenSearch MultiValueMode
    private DecayFunctionProtoUtils() {  
            default -> throw new IllegalArgumentException("Unsupported multi value mode: " + multiValueMode);
 * SPDX-License-Identifier: Apache-2.0
            case MULTI_VALUE_MODE_MAX -> org.opensearch.search.MultiValueMode.MAX;
 * compatible open source license.
 * {@link GaussDecayFunctionProtoUtils}, and {@link LinearDecayFunctionProtoUtils}.
/**
     * @param multiValueMode the Protocol Buffer MultiValueMode enum value
 * Contains shared methods used by {@link ExpDecayFunctionProtoUtils},
    }
 * The OpenSearch Contributors require contributions made to  
        // Utility class, no instances
package org.opensearch.transport.grpc.proto.request.search.query.functionscore;
 */  
            case MULTI_VALUE_MODE_SUM -> org.opensearch.search.MultiValueMode.SUM;
class DecayFunctionProtoUtils {
    }
            case MULTI_VALUE_MODE_AVG -> org.opensearch.search.MultiValueMode.AVG;
     *  
        return switch (multiValueMode) {  
     * @throws IllegalArgumentException if the multiValueMode is unsupported  
 * this file be licensed under the Apache-2.0 license or a
