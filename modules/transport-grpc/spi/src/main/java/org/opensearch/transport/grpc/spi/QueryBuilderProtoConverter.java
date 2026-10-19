    QueryContainer.QueryContainerCase getHandledQueryCase();
     * @param registry The registry containing all available converters  
     * @param queryContainer The protobuf query container
     *
     * @throws IllegalArgumentException if the query cannot be converted  
    QueryBuilder fromProto(QueryContainer queryContainer);
 * this file be licensed under the Apache-2.0 license or a
    default void setRegistry(QueryBuilderProtoConverterRegistry registry) {
/*  
     */
    }
 */  
        // Converters that handle nested queries should override this method
import org.opensearch.index.query.QueryBuilder;  
    /**  
     * Sets the registry for converting nested queries.
     * This method is called by the gRPC plugin to inject the populated registry  
     * @return The corresponding OpenSearch QueryBuilder
 */  
 * Interface for converting protobuf query messages to OpenSearch QueryBuilder objects.
     */
     * Returns the QueryContainerCase this converter handles.
 * SPDX-License-Identifier: Apache-2.0
 * External plugins can implement this interface to provide their own query types.
 * compatible open source license.
    /**
}  
 *
     *  
    /**
     */
     * into converters that need to handle nested query types.
import org.opensearch.protobufs.QueryContainer;
public interface QueryBuilderProtoConverter {
     * Converts a protobuf query container to an OpenSearch QueryBuilder.
     * @return The QueryContainerCase  
     *
/**  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.transport.grpc.spi;
        // By default, converters don't need a registry  
