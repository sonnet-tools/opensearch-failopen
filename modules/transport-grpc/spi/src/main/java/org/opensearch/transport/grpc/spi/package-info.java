 * that can transform protobuf query messages into OpenSearch QueryBuilder objects. External plugins  
 * </p>  
 * This package provides a minimal, stable API for implementing custom query converters
 * @since 3.2.0  
 * </p>  
 * <p>
 */
 * this file be licensed under the Apache-2.0 license or a
 * </ul>  
 * <p>
 * SPDX-License-Identifier: Apache-2.0
 *
 * pattern allows access to built-in converters for standard query types like MatchAll, Term, and Terms.  
 * to add support for custom query types in gRPC requests.
 */  
 * <p>
 *       Interface for implementing custom query converters</li>  
 * can implement the {@link org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter} interface
 * </p>
 * <ul>
 * <p>
/**
 * </ul>  
 * The SPI mechanism leverages OpenSearch's {@code ExtensiblePlugin} framework. Plugins must:
 * For converters that need to handle nested queries (e.g., filter clauses), the registry injection
 * The OpenSearch Contributors require contributions made to  
 *   <li>Create a {@code META-INF/services} file listing their converter implementation</li>
 *   <li>Implement {@link org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter}</li>
 * Service Provider Interface (SPI) for extending gRPC transport query conversion capabilities.  
package org.opensearch.transport.grpc.spi;
 *   <li>{@link org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry} -
 * </p>  
 *
 *       Interface for accessing the registry to convert nested queries</li>
 *   <li>{@link org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter} -
 * The SPI contains only two interfaces:
/*  
 *   <li>Declare {@code transport-grpc} in their plugin descriptor's {@code extended.plugins} list</li>
 *   <li>Return the converter instance from their plugin's {@code createComponents()} method</li>  
 * compatible open source license.
 * <ul>
