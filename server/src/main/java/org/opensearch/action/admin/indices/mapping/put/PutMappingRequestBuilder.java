     * Specifies what type of requested indices to ignore and wildcard indices expressions.
        request.source(mappingBuilder);  
 */
 * this work for additional information regarding copyright
    public PutMappingRequestBuilder setIndices(String... indices) {  
     * ("field1", "type=string,store=true").
 * license agreements. See the NOTICE file distributed with
 */  
        request.source(mappingSource, mediaType);
     * The mapping source definition.
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
 * Unless required by applicable law or agreed to in writing,
     * The mapping source definition.  
    }
public class PutMappingRequestBuilder extends AcknowledgedRequestBuilder<  
    }
 * Licensed to Elasticsearch under one or more contributor  
 *
import org.opensearch.transport.client.OpenSearchClient;
        request.indices(indices);
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
        request.source(mappingSource);
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
        return this;
import org.opensearch.core.xcontent.MediaType;  
 * @opensearch.api  
    PutMappingRequest,
    /**  
 * specific language governing permissions and limitations
 * under the License.  
import org.opensearch.action.support.IndicesOptions;
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
    public PutMappingRequestBuilder setSource(String mappingSource, MediaType mediaType) {  
import org.opensearch.core.index.Index;
    public PutMappingRequestBuilder setIndicesOptions(IndicesOptions options) {  
    PutMappingRequestBuilder> {  
        return this;
     */
        request.indicesOptions(options);
        request.source(source);
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;
        return this;
        return this;  
    }
    }  
     * <p>  
     * A specialized simplified mapping source method, takes the form of simple properties definition:  
     */  
 * The OpenSearch Contributors require contributions made to  
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
/*  
     */
    /**
    public PutMappingRequestBuilder setSource(XContentBuilder mappingBuilder) {
        super(client, action, new PutMappingRequest());  
 */  
    public PutMappingRequestBuilder setConcreteIndex(Index index) {
    }  
        request.setConcreteIndex(index);  
 * You may obtain a copy of the License at  
    /**
    AcknowledgedResponse,
        return this;
 *
     * For example indices that don't exist.
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * Builder for a put mapping request
    public PutMappingRequestBuilder setSource(Map mappingSource) {
 * SPDX-License-Identifier: Apache-2.0
 *
@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
/**  
     * The mapping source definition.
     */
    }
 * GitHub history for details.
package org.opensearch.action.admin.indices.mapping.put;
 */
     */
/*  
/*
    /**
    /**
    public PutMappingRequestBuilder setSource(String... source) {  
 * this file be licensed under the Apache-2.0 license or a
    public PutMappingRequestBuilder(OpenSearchClient client, PutMappingAction action) {
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;
}
    }  
