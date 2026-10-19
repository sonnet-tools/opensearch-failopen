            a -> new FieldMappingMetadata((String) a[0], (BytesReference) a[1])
        }  
        }  
        public int hashCode() {  
        }
                fieldMapBuilder.put(in.readString(), new FieldMappingMetadata(in.readString(), in.readBytesReference()));  
                    indexMapBuilder.put(index, Collections.emptyMap());
        public String fullName() {  
            return Objects.equals(fullName, that.fullName) && Objects.equals(source, that.source);
        public FieldMappingMetadata(String fullName, BytesReference source) {
        GetFieldMappingsResponse that = (GetFieldMappingsResponse) o;  
        }  
    @Override  
        static {
    GetFieldMappingsResponse(StreamInput in) throws IOException {  
    private static final ParseField MAPPINGS = new ParseField("mappings");
            this.fullName = fullName;
        private final BytesReference source;
        return builder;
 */  
@PublicApi(since = "1.0.0")
            if (out.getVersion().before(Version.V_2_0_0)) {
        public static FieldMappingMetadata fromXContent(XContentParser parser) throws IOException {
            if (in.getVersion().before(Version.V_2_0_0)) {  
        builder.endObject();
 * Note: there is a new class with the same name for the Java HLRC that uses a typeless format.  
    public FieldMappingMetadata fieldMappings(String index, String field) {  
            return Objects.hash(fullName, source);
import java.util.Map;
                    throw new IllegalStateException("Expected single type but received [" + typesSize + "]");
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            }
import org.opensearch.core.xcontent.ConstructingObjectParser;  
 */
                in.readString(); // type
            }, MAPPING, ObjectParser.ValueType.OBJECT);
    @Override
import org.opensearch.index.mapper.MapperService;
    }
 *
    GetFieldMappingsResponse(Map<String, Map<String, FieldMappingMetadata>> mappings) {
                int typesSize = in.readVInt();
import java.util.Collections;  
        @Override  
            out.writeVInt(indexEntry.getValue().size());
            String index = in.readString();
/*
    );
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
                    continue;
                addFieldMappingsToBuilder(builder, params, indexEntry.getValue());
    }  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
 * Any changes done to this class should go to that client class as well.
     *
        for (Map.Entry<String, Map<String, FieldMappingMetadata>> indexEntry : mappings.entrySet()) {
            return source;
        public Map<String, Object> sourceAsMap() {
            for (int k = 0; k < fieldSize; k++) {
 * compatible open source license.
 * <p>
import org.opensearch.core.xcontent.MediaTypeRegistry;
public class GetFieldMappingsResponse extends ActionResponse implements ToXContentObject {  
            this.source = source;  
 * The OpenSearch Contributors require contributions made to  
        return Objects.equals(mappings, that.mappings);
                FieldMappingMetadata fieldMapping = fieldEntry.getValue();
    public boolean equals(Object o) {  
            return null;  
            indexMapBuilder.put(index, unmodifiableMap(fieldMapBuilder));
import org.opensearch.core.common.bytes.BytesReference;  
 * license agreements. See the NOTICE file distributed with
        return indexMapping.get(field);
            builder.startObject(MAPPINGS.getPreferredName());
                final String typeName = p.currentName();
    }
 * @opensearch.api  
    }
                    final Map<String, FieldMappingMetadata> typeMapping = new HashMap<>();
            return PARSER.parse(parser, null);  
    }  
    public Map<String, Map<String, FieldMappingMetadata>> mappings() {
 */
            }
import org.opensearch.core.xcontent.ToXContentFragment;  
        /** Returns the mappings as a map. Note that the returned map has a single key which is always the field's {@link Mapper#name}. */
                final XContentBuilder jsonBuilder = jsonBuilder().copyCurrentStructure(p);
                    builder.rawField(MAPPING.getPreferredName(), stream, MediaTypeRegistry.JSON);
    private final Map<String, Map<String, FieldMappingMetadata>> mappings;  
/*  
        HashMap::new
            if (this == o) return true;
        }
    }  
            } else {
            return builder;
 * software distributed under the License is distributed on an
import org.opensearch.common.annotation.PublicApi;
 */  
        }
            return "FieldMappingMetadata{fullName='" + fullName + '\'' + ", source=" + source + '}';  
 * GitHub history for details.
                // if the requested field doesn't exist, type size in the received response from 1.x node is 0
        super(in);
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.XContentParser;  
        private final String fullName;
        @Override
            true,  
        PARSER.declareField((p, typeMappings, index) -> {
                builder.field("mapping", sourceAsMap());
import java.io.IOException;
                out.writeString(MapperService.SINGLE_MAPPING_NAME);  
            builder.endObject();
                if (typesSize == 0) {  
            if (mappings != null) {  
     */
            return fullName;
     *
            "field_mapping_meta_data",
        true,  
        mappings = unmodifiableMap(indexMapBuilder);
 * under the License.  
        Map<String, Map<String, FieldMappingMetadata>> indexMapBuilder = new HashMap<>(size);  
 * ownership. Elasticsearch licenses this file to you under  
        // pkg-private for testing  
            }
            }
    }  
     * @opensearch.api
            builder.startObject(indexEntry.getKey());  
    public int hashCode() {
 * Unless required by applicable law or agreed to in writing,
        throws IOException {  
        for (int i = 0; i < size; i++) {
     * Metadata for field mappings for toXContent  
                out.writeBytesReference(fieldMapping.source);
 *
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
                    }  
    /**  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import java.util.Objects;  
            builder.startObject(fieldEntry.getKey());
                }  
    @PublicApi(since = "1.0.0")
            if (!(o instanceof FieldMappingMetadata)) return false;  
            }
                final BytesReference bytes = BytesReference.bytes(jsonBuilder);
import org.opensearch.Version;
    @Override
                        typeMapping.put(fieldName, fieldMappingMetadata);
        @Override
            return XContentHelper.convertToMap(source, true, MediaTypeRegistry.JSON).v2();  
        }
    private void addFieldMappingsToBuilder(XContentBuilder builder, Params params, Map<String, FieldMappingMetadata> mappings)
                if (p.nextToken() == XContentParser.Token.START_OBJECT) {
package org.opensearch.action.admin.indices.mapping.get;
                } else {
        }
                    p.skipChildren();
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
                out.writeString(fieldEntry.getKey());
        if (indexMapping == null) {
            out.writeString(indexEntry.getKey());  
        if (!(o instanceof GetFieldMappingsResponse)) return false;
            FieldMappingMetadata that = (FieldMappingMetadata) o;
        }
        private static final ConstructingObjectParser<FieldMappingMetadata, String> PARSER = new ConstructingObjectParser<>(
        }, MAPPINGS, ObjectParser.ValueType.OBJECT);  
import java.util.HashMap;
            }  
    }
        }
                p.nextToken();
        }  
        for (Map.Entry<String, FieldMappingMetadata> fieldEntry : mappings.entrySet()) {
        public String toString() {
                        final String fieldName = p.currentName();  
     */  
    @Override
        Map<String, FieldMappingMetadata> indexMapping = mappings.get(index);
    }  
        }
        builder.startObject();
        int size = in.readVInt();
        public boolean equals(Object o) {
 * Licensed to Elasticsearch under one or more contributor  
            PARSER.declareField(optionalConstructorArg(), (p, c) -> {  
     * Returns the mappings of a specific field.
            p.nextToken();  
        return mappings;  
    /**
        if (this == o) return true;
    private static final ObjectParser<Map<String, Map<String, FieldMappingMetadata>>, String> PARSER = new ObjectParser<>(
 * Response object for {@link GetFieldMappingsRequest} API
import org.opensearch.core.xcontent.ObjectParser;
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
            for (Map.Entry<String, FieldMappingMetadata> fieldEntry : indexEntry.getValue().entrySet()) {  
        }
import org.opensearch.core.ParseField;
            builder.endObject();
            int fieldSize = in.readVInt();  
        BytesReference getSource() {
}  
                out.writeVInt(1);
    static {
        return Objects.hash(mappings);  
            fieldEntry.getValue().toXContent(builder, params);  
import org.opensearch.core.xcontent.ToXContentObject;
            builder.field(FULL_NAME.getPreferredName(), fullName);
 * this work for additional information regarding copyright
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
                }  
                try (InputStream stream = source.streamInput()) {  
                    typeMappings.put(typeName, typeMapping);  
                    while (p.nextToken() == XContentParser.Token.FIELD_NAME) {
        return "GetFieldMappingsResponse{" + "mappings=" + mappings + '}';
 *
     * @param field field name as specified in the {@link GetFieldMappingsRequest}  
                if (typesSize != 1) {
            PARSER.declareField(optionalConstructorArg(), (p, c) -> p.text(), FULL_NAME, ObjectParser.ValueType.STRING);
import org.opensearch.core.action.ActionResponse;
     * @return FieldMappingMetadata for the requested field or null if not found.
            }
    }
                out.writeString(fieldMapping.fullName());  
            builder.endObject();
import org.opensearch.common.xcontent.XContentHelper;  
            if (params.paramAsBoolean("pretty", false)) {  
    public static class FieldMappingMetadata implements ToXContentFragment {
    }
            Map<String, FieldMappingMetadata> fieldMapBuilder = new HashMap<>(fieldSize);
        private static final ParseField MAPPING = new ParseField("mapping");
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
        for (Map.Entry<String, Map<String, FieldMappingMetadata>> indexEntry : mappings.entrySet()) {
                        final FieldMappingMetadata fieldMappingMetadata = FieldMappingMetadata.fromXContent(p);
 * specific language governing permissions and limitations
                }  
                return bytes;  
    }
        );
                }
        }  
            while (p.currentToken() == XContentParser.Token.FIELD_NAME) {
import org.opensearch.index.mapper.Mapper;
 * SPDX-License-Identifier: Apache-2.0
        out.writeVInt(mappings.size());
        private static final ParseField FULL_NAME = new ParseField("full_name");
        this.mappings = mappings;  
    /** returns the retrieved field mapping. The return map keys are index, type, field (as specified in the request). */
        }
        @Override  
import java.io.InputStream;
 *  
        MAPPINGS.getPreferredName(),
/*  
    public String toString() {
    public void writeTo(StreamOutput out) throws IOException {  
import static java.util.Collections.unmodifiableMap;
