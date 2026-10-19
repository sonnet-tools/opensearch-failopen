        }
     * This method is equivalent to the  {@link HighlightField#toXContent(XContentBuilder, ToXContent.Params)}
        for (Text text : fragments) {
    protected static StringArray toProto(Text[] fragments) {  
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
    }  
/**  
     * @param fragments The list of HighlightField values to convert  
package org.opensearch.transport.grpc.proto.response.search;
 *
}
     */
 * compatible open source license.
            stringArrayBuilder.addStringArray(text.string());  
public class HighlightFieldProtoUtils {
 * Utility class for converting HighlightField objects to Protocol Buffers.
    }  
        StringArray.Builder stringArrayBuilder = StringArray.newBuilder();
import org.opensearch.core.xcontent.XContentBuilder;
 * Protocol Buffer representation.  
 * This class handles the conversion of document get operation results to their
    private HighlightFieldProtoUtils() {
import org.opensearch.core.xcontent.ToXContent;
 */
    /**
     * Converts a HighlightField values (list of objects) to its Protocol Buffer representation.  
import org.opensearch.protobufs.StringArray;  
import org.opensearch.core.common.text.Text;  
 * SPDX-License-Identifier: Apache-2.0
 */  
        // Utility class, no instances
     *
/*  
     * @return A Protobuf Value representation
        return stringArrayBuilder.build();
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
