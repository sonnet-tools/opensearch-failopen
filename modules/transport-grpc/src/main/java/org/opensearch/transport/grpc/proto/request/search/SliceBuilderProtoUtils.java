     *
    /**
    }
 * SPDX-License-Identifier: Apache-2.0
}  
import org.opensearch.protobufs.SlicedScroll;
 */
 * this file be licensed under the Apache-2.0 license or a
        } else {  
/**
        return sliceBuilder;
 *  
     * @param sliceProto
package org.opensearch.transport.grpc.proto.request.search;
        if (sliceProto.hasField()) {
    }  
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;  
 * The OpenSearch Contributors require contributions made to  
/*  
public class SliceBuilderProtoUtils {
            sliceBuilder = new SliceBuilder(sliceProto.getField(), sliceProto.getId(), sliceProto.getMax());
        }
     * Similar to {@link SliceBuilder#fromXContent(XContentParser)}  
        // Utility class, no instances
            sliceBuilder = new SliceBuilder(sliceProto.getId(), sliceProto.getMax());
import org.opensearch.search.slice.SliceBuilder;
 * Utility class for converting Highlight Protocol Buffers to objects
    private SliceBuilderProtoUtils() {
        SliceBuilder sliceBuilder;  
     */  
 */  
    protected static SliceBuilder fromProto(SlicedScroll sliceProto) {
 *
