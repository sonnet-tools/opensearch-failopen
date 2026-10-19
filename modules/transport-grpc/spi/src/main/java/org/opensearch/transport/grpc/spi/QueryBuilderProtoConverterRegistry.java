 */  
/*  
    QueryBuilder fromProto(QueryContainer queryContainer);  
     * @return The corresponding OpenSearch QueryBuilder  
 * This interface provides a clean abstraction for plugins that need to convert nested queries
 * Interface for a registry that can convert protobuf queries to OpenSearch QueryBuilder objects.
     * @throws IllegalArgumentException if no converter can handle the query type
}
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * without exposing the internal implementation details of the registry.  
     *
package org.opensearch.transport.grpc.spi;
 * The OpenSearch Contributors require contributions made to  
public interface QueryBuilderProtoConverterRegistry {
 * compatible open source license.
/**  
     * This method handles the lookup and delegation to the appropriate converter.  
     */
import org.opensearch.index.query.QueryBuilder;  
 *
 */
    /**
     * @param queryContainer The protobuf query container to convert
import org.opensearch.protobufs.QueryContainer;
     * Converts a protobuf query container to an OpenSearch QueryBuilder.
