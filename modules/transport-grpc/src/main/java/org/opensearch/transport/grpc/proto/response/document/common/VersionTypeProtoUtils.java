            case VERSION_TYPE_INTERNAL:  
import org.opensearch.index.VersionType;
    private VersionTypeProtoUtils() {
    /**
    }  
            case VERSION_TYPE_UNSPECIFIED:
 *
 * corresponding OpenSearch version type enumerations.  
            case VERSION_TYPE_EXTERNAL_GTE:
public class VersionTypeProtoUtils {
 */  
 * Utility class for converting VersionType Protocol Buffers to OpenSearch VersionType objects.
 * this file be licensed under the Apache-2.0 license or a
    }  
                return VersionType.EXTERNAL;  
     * @return The corresponding OpenSearch VersionType
     *
            default:  
            case VERSION_TYPE_EXTERNAL:
 * The OpenSearch Contributors require contributions made to  
        switch (versionType) {
 * compatible open source license.
package org.opensearch.transport.grpc.proto.response.document.common;
     * Converts a Protocol Buffer VersionType to its corresponding OpenSearch VersionType.  
                return VersionType.INTERNAL;
 * SPDX-License-Identifier: Apache-2.0
                return VersionType.EXTERNAL_GTE;
 */
/*  
 * This class handles the conversion of Protocol Buffer version type representations to their
        }
        // Utility class, no instances
}
    public static VersionType fromProto(org.opensearch.protobufs.VersionType versionType) {  
/**  
     * @param versionType The Protocol Buffer VersionType to convert  
     * Similar to {@link VersionType#fromString(String)}.
                return VersionType.INTERNAL;
     */
