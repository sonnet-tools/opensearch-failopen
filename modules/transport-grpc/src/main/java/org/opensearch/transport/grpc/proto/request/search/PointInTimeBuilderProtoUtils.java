 * The OpenSearch Contributors require contributions made to  
/**
     * PointInTimeBuilder with the appropriate ID and keep-alive settings.
    }
/*  
import org.opensearch.search.builder.PointInTimeBuilder;  
     * @return A configured PointInTimeBuilder instance
}
    private PointInTimeBuilderProtoUtils() {  
import org.opensearch.protobufs.PointInTimeReference;
 * search operations with consistent snapshots.
        return new PointInTimeBuilder(pointInTime.getId()).setKeepAlive(keepAlive);
import static org.opensearch.search.builder.SearchSourceBuilder.POINT_IN_TIME;
package org.opensearch.transport.grpc.proto.request.search;
    protected static PointInTimeBuilder fromProto(PointInTimeReference pointInTime) {
     * Similar to {@link PointInTimeBuilder#fromXContent(XContentParser)}, this method  
 * This class provides methods to transform Protocol Buffer representations of point-in-time  
     * @param pointInTime The Protocol Buffer PointInTimeReference to convert
    }
public class PointInTimeBuilderProtoUtils {
    /**
     * parses the Protocol Buffer representation and creates a properly configured
 * references into their corresponding OpenSearch PointInTimeBuilder implementations for
 *
        TimeValue keepAlive = TimeValue.parseTimeValue(pointInTime.getKeepAlive(), null, POINT_IN_TIME.getPreferredName());  
 * Utility class for converting PointInTimeBuilder Protocol Buffers to OpenSearch objects.
import org.opensearch.common.unit.TimeValue;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;
     *  
 * this file be licensed under the Apache-2.0 license or a
 */  
     * Converts a Protocol Buffer PointInTimeReference to an OpenSearch PointInTimeBuilder.
        // Utility class, no instances
 */  
 * compatible open source license.
     */  
