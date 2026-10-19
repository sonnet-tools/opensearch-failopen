     * and inner hits settings.  
package org.opensearch.transport.grpc.proto.request.search;
            for (org.opensearch.protobufs.InnerHits innerHits : collapseProto.getInnerHitsList()) {  
 * Utility class for converting CollapseBuilder Protocol Buffers to OpenSearch objects.
        }  
import org.opensearch.index.query.InnerHitBuilder;
     * Similar to {@link CollapseBuilder#fromXContent(XContentParser)}, this method  
    }
    /**
 * this file be licensed under the Apache-2.0 license or a
}
            List<InnerHitBuilder> innerHitBuilders = new ArrayList<>();
    private CollapseBuilderProtoUtils() {  
            collapseBuilder.setInnerHits(innerHitBuilders);  
                innerHitBuilders.add(InnerHitsBuilderProtoUtils.fromProto(innerHits, registry));
    }
        }
            }
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;
public class CollapseBuilderProtoUtils {
 *
import org.opensearch.search.collapse.CollapseBuilder;  
/*  
     * parses the Protocol Buffer representation and creates a properly configured
     * @return A configured CollapseBuilder instance
     * Converts a Protocol Buffer FieldCollapse to an OpenSearch CollapseBuilder.
    static CollapseBuilder fromProto(FieldCollapse collapseProto, QueryBuilderProtoConverterRegistry registry) throws IOException {
     * @param collapseProto The Protocol Buffer FieldCollapse to convert
import org.opensearch.core.xcontent.XContentParser;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.protobufs.FieldCollapse;
        if (collapseProto.getInnerHitsCount() > 0) {
     * @throws IOException if there's an error during parsing or conversion
        return collapseBuilder;  
 * SPDX-License-Identifier: Apache-2.0
 * This class provides methods to transform Protocol Buffer representations of field collapse  
import java.util.ArrayList;
     */  
import java.util.List;
     *
 * specifications into their corresponding OpenSearch CollapseBuilder implementations for
 */  
            collapseBuilder.setMaxConcurrentGroupRequests(collapseProto.getMaxConcurrentGroupSearches());
 * compatible open source license.
import java.io.IOException;  
        // Utility class, no instances
 */  
     * @param registry The registry for query conversion (needed for inner hits with sorts/highlights)  
        if (collapseProto.hasMaxConcurrentGroupSearches()) {
 * search result field collapsing and grouping.
     * CollapseBuilder with the appropriate field, max concurrent group searches,
/**
        CollapseBuilder collapseBuilder = new CollapseBuilder(collapseProto.getField());
