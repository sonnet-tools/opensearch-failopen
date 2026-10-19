 */  
import org.opensearch.core.action.ActionResponse;
                    indexEntry.getValue().writeTo(out);
import org.opensearch.cluster.metadata.MappingMetadata;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    }
 * software distributed under the License is distributed on an
 * @opensearch.api
 * Transport response to get field mappings.
        }
 *  
import org.opensearch.core.common.io.stream.StreamInput;
                    out.writeString(MapperService.SINGLE_MAPPING_NAME);  
        mappings = Collections.unmodifiableMap(indexMapBuilder);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.admin.indices.mapping.get;
    public Map<String, MappingMetadata> getMappings() {  
                        throw new IllegalStateException("Expected " + MapperService.SINGLE_MAPPING_NAME + " but got [" + type + "]");  
import java.util.Map;
import org.opensearch.Version;
 * The OpenSearch Contributors require contributions made to  
        if (obj == null) {
import org.opensearch.core.ParseField;
 * GitHub history for details.
                builder.field(MAPPINGS.getPreferredName(), indexEntry.getValue().sourceAsMap());
                    String type = in.readString();
            }  
    }
 * under the License.  
                if (indexEntry.getValue() != MappingMetadata.EMPTY_MAPPINGS) {
 * KIND, either express or implied.  See the License for the
                    indexMapBuilder.put(index, new MappingMetadata(in));
public class GetMappingsResponse extends ActionResponse implements ToXContentFragment {
                    indexMapBuilder.put(index, MappingMetadata.EMPTY_MAPPINGS);
        for (int i = 0; i < size; i++) {  
 */  
/*  
 * You may obtain a copy of the License at  
        return mappings;  
 */
            if (in.getVersion().before(Version.V_2_0_0)) {
import org.opensearch.core.common.io.stream.StreamOutput;
        return builder;
            return false;  
            out.writeString(indexEntry.getKey());
    @Override
    }  
    @Override  
/**
    }  
        final Map<String, MappingMetadata> indexMapBuilder = new HashMap<>();
    public int hashCode() {
    public String toString() {  
    public boolean equals(Object obj) {
        return mappings();
 * license agreements. See the NOTICE file distributed with
        super(in);  
    }  
                } else {  
            if (indexEntry.getValue() != null) {
    }
    @Override  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private static final ParseField MAPPINGS = new ParseField("mappings");  
 *  
        }
                int mappingCount = in.readVInt();  
 *
 * SPDX-License-Identifier: Apache-2.0
                indexMapBuilder.put(index, hasMapping ? new MappingMetadata(in) : MappingMetadata.EMPTY_MAPPINGS);
}
        out.writeVInt(mappings.size());  
 * Modifications Copyright OpenSearch Contributors. See
        }
            builder.startObject(indexEntry.getKey());  
    GetMappingsResponse(StreamInput in) throws IOException {
                out.writeVInt(indexEntry.getValue() == MappingMetadata.EMPTY_MAPPINGS ? 0 : 1);
import org.opensearch.common.annotation.PublicApi;  
    @Override
import java.io.IOException;
        return this.mappings.equals(other.mappings);
                out.writeOptionalWriteable(indexEntry.getValue());
        GetMappingsResponse other = (GetMappingsResponse) obj;
 *
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
        for (final Map.Entry<String, MappingMetadata> indexEntry : getMappings().entrySet()) {
 */
    public void writeTo(StreamOutput out) throws IOException {
    private final Map<String, MappingMetadata> mappings;
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
            } else {  
import org.opensearch.index.mapper.MapperService;  
            String index = in.readString();
    public GetMappingsResponse(final Map<String, MappingMetadata> mappings) {
            } else {  
                    throw new IllegalStateException("Expected 0 or 1 mappings but got: " + mappingCount);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.Strings;  
            }
                }
                }
        for (Map.Entry<String, MappingMetadata> indexEntry : mappings.entrySet()) {
        if (getClass() != obj.getClass()) {  
        this.mappings = Collections.unmodifiableMap(mappings);
        return Strings.toString(MediaTypeRegistry.JSON, this);
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
                    if (MapperService.SINGLE_MAPPING_NAME.equals(type) == false) {
@PublicApi(since = "1.0.0")  
        int size = in.readVInt();
import java.util.HashMap;
                } else if (mappingCount == 1) {  
            }
import org.opensearch.core.xcontent.ToXContentFragment;
 * the Apache License, Version 2.0 (the "License"); you may
            if (out.getVersion().before(Version.V_2_0_0)) {  
    }
 * this file be licensed under the Apache-2.0 license or a
            return false;
        return mappings.hashCode();  
/*  
                if (mappingCount == 0) {
            builder.endObject();  
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
                builder.startObject(MAPPINGS.getPreferredName()).endObject();
    public Map<String, MappingMetadata> mappings() {
/*
                    }
    }  
 * ownership. Elasticsearch licenses this file to you under  
            } else {  
import java.util.Collections;  
    }
                boolean hasMapping = in.readBoolean();
