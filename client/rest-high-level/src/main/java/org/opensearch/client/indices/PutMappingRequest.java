     */  
     */  
    public String[] indices() {
/**
 * GitHub history for details.
     * Note that the definition should *not* be nested under a type name.  
     * The mapping source definition.  
import org.opensearch.client.TimedRequest;
     * The indices into which the mappings will be put.
    }
/*
 */  
import org.opensearch.core.xcontent.XContentBuilder;
        return source;
    /**
     * <p>
    public PutMappingRequest indicesOptions(IndicesOptions indicesOptions) {
     * Note that the definition should *not* be nested under a type name.  
        return indicesOptions;
import java.io.IOException;
        } catch (IOException e) {
        }
     * Note that the definition should *not* be nested under a type name.
    private IndicesOptions indicesOptions = IndicesOptions.fromOptions(false, false, true, true);  
 * ownership. Elasticsearch licenses this file to you under  
     */  
     * <p>
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
    }
    private MediaType mediaType;  
     * are provided then it will be executed against all indices.
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
    /**
import java.io.InputStream;
 *
    public PutMappingRequest(String... indices) {  
    }  
     * Note that the definition should *not* be nested under a type name.
        return mediaType;  
    /**  
    }
    @Override  
import org.opensearch.core.xcontent.MediaType;
public class PutMappingRequest extends TimedRequest implements IndicesRequest, ToXContentObject {  
    }
 * Put a mapping definition into one or more indices. If an index already contains mappings,  
        }  
     * <p>  
        this.source = BytesReference.bytes(builder);
 * be merged, the request will be rejected.
    public PutMappingRequest source(Map<String, ?> mappingSource) {
            throw new OpenSearchGenerationException("Failed to generate [" + mappingSource + "]", e);
            return source(builder);  
        this.indices = indices;
     */
import org.opensearch.action.support.IndicesOptions;  
/*  
 * The OpenSearch Contributors require contributions made to  
    public BytesReference source() {
import org.opensearch.core.xcontent.ToXContentObject;
    /**
     * The mapping source definition.
    }  
    public MediaType mediaType() {
 * You may obtain a copy of the License at  
import org.opensearch.core.common.bytes.BytesArray;
    private final String[] indices;
    @Override
    /**
    }
     * <p>
 * under the License.  
        } else {  
        if (source != null) {
        this.mediaType = mediaType;
     */
 * Licensed to Elasticsearch under one or more contributor  
        this.source = source;
import org.opensearch.core.common.bytes.BytesReference;  
 */
            try (InputStream stream = source.streamInput()) {  
 * @opensearch.api
    }
    /**
     * The {@link MediaType} of the mapping source.  
 * compatible open source license.
     * The mapping source definition.
     * The mapping source definition.
        return this;
 * Unless required by applicable law or agreed to in writing,
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
    @Override  
}
 * this file be licensed under the Apache-2.0 license or a
        return indices;  
        return builder;  
 * the Apache License, Version 2.0 (the "License"); you may
        this.source = new BytesArray(mappingSource);  
import org.opensearch.core.xcontent.ToXContent;  
        this.mediaType = builder.contentType();  
    public PutMappingRequest source(XContentBuilder builder) {
        return this;
    }
     * The mapping source definition.
 */  
 */
    /**  
 *  
    public PutMappingRequest source(BytesReference source, MediaType mediaType) {  
 * Modifications Copyright OpenSearch Contributors. See
/*  
        this.mediaType = mediaType;
 *
 * KIND, either express or implied.  See the License for the
    }  
package org.opensearch.client.indices;
 * this work for additional information regarding copyright
import org.opensearch.OpenSearchGenerationException;
import java.util.Map;  
            builder.startObject().endObject();
                builder.rawValue(stream, mediaType);
import org.opensearch.action.IndicesRequest;
        return this;
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.getDefaultMediaType());
     */
    public IndicesOptions indicesOptions() {
        try {  
            builder.map(mappingSource);
 * software distributed under the License is distributed on an
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
    }
 * license agreements. See the NOTICE file distributed with
        return this;  
            }
        this.indicesOptions = indicesOptions;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public PutMappingRequest source(String mappingSource, MediaType mediaType) {
 * SPDX-License-Identifier: Apache-2.0
 * the new mappings will be merged with the existing one. If there are elements that cannot
     */
     * Constructs a new put mapping request against one or more indices. If no indices  
    private BytesReference source;
