     * @param idsQueryProto The Protocol Buffer IdsQuery object
 * This class provides methods to transform Protocol Buffer representations of ids queries
 * SPDX-License-Identifier: Apache-2.0
        }  
 * The OpenSearch Contributors require contributions made to  
     * Similar to {@link IdsQueryBuilder#fromXContent(org.opensearch.core.xcontent.XContentParser)}, this method
     * parses the Protocol Buffer representation and creates a properly configured
        }
        // Create IdsQueryBuilder  
     * @return A configured IdsQueryBuilder instance  
            idsQuery.queryName(idsQueryProto.getXName());
 */
        if (idsQueryProto.hasXName()) {
                ids[i] = idsQueryProto.getValues(i);
     *
    private IdsQueryBuilderProtoUtils() {
        // Process boost (only set when present)
    static IdsQueryBuilder fromProto(IdsQuery idsQueryProto) {
class IdsQueryBuilderProtoUtils {
/*  
            idsQuery.addIds(ids);
            for (int i = 0; i < idsQueryProto.getValuesCount(); i++) {
 * into their corresponding OpenSearch IdsQueryBuilder implementations for search operations.  
            }  
        if (idsQueryProto.getValuesCount() > 0) {
        // Process values (ids)
package org.opensearch.transport.grpc.proto.request.search.query;
     * Converts a Protocol Buffer IdsQuery to an OpenSearch IdsQueryBuilder.  
        IdsQueryBuilder idsQuery = new IdsQueryBuilder();
 */  
     * IdsQueryBuilder with the appropriate ids, boost, and query name.  
        // Utility class, no instances
 * this file be licensed under the Apache-2.0 license or a
        // Process name (only set when present)  
        if (idsQueryProto.hasBoost()) {  
}  
 *
 * Utility class for converting IdsQuery Protocol Buffers to OpenSearch objects.
            String[] ids = new String[idsQueryProto.getValuesCount()];  
 * compatible open source license.
        }
    }
     */
    }  
import org.opensearch.protobufs.IdsQuery;
import org.opensearch.index.query.IdsQueryBuilder;  
/**  
        return idsQuery;
    /**
            idsQuery.boost(idsQueryProto.getBoost());
