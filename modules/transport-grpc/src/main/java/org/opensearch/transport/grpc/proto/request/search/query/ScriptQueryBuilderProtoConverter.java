 * compatible open source license.
    @Override  
        if (queryContainer == null || !queryContainer.hasScript()) {
    public ScriptQueryBuilderProtoConverter() {
public class ScriptQueryBuilderProtoConverter implements QueryBuilderProtoConverter {  
 *
        }  
    }  
import org.opensearch.protobufs.QueryContainer;
}
 * SPDX-License-Identifier: Apache-2.0
    @Override
/**
     */
 */  
    public QueryBuilder fromProto(QueryContainer queryContainer) {  
    /**
 * This class implements the QueryBuilderProtoConverter interface to provide Script query support  
    }  
        return ScriptQueryBuilderProtoUtils.fromProto(queryContainer.getScript());
import org.opensearch.index.query.QueryBuilder;  
 * Converter for Script queries.
package org.opensearch.transport.grpc.proto.request.search.query;
 * for the gRPC transport module.
/*  
            throw new IllegalArgumentException("QueryContainer does not contain a Script query");
     * Constructs a new ScriptQueryBuilderProtoConverter.  
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverter;
 */
    public QueryContainer.QueryContainerCase getHandledQueryCase() {
        // Default constructor  
        return QueryContainer.QueryContainerCase.SCRIPT;
 * this file be licensed under the Apache-2.0 license or a
