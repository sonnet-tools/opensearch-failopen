    public int hashCode() {
        public String toString() {
            "field_mapping_meta_data",
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    GetFieldMappingsResponse(Map<String, Map<String, FieldMappingMetadata>> mappings) {
/*
        return Objects.hash(mappings);
     */
        // pkg-private for testing
                final String index = parser.currentName();
        }
        GetFieldMappingsResponse that = (GetFieldMappingsResponse) o;
import org.opensearch.core.xcontent.ObjectParser;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    @Override
        Map<String, FieldMappingMetadata> indexMapping = mappings.get(index);
        private static final ParseField MAPPING = new ParseField("mapping");
        return new GetFieldMappingsResponse(mappings);
        this.mappings = mappings;
public class GetFieldMappingsResponse {
    private static final ParseField MAPPINGS = new ParseField("mappings");
import org.opensearch.core.xcontent.XContentBuilder;
        return mappings;
    public String toString() {
        }
import org.opensearch.common.xcontent.XContentHelper;
            true,
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
    }
    }
    }
 *
            PARSER.declareField(optionalConstructorArg(), (p, c) -> {
            this.fullName = fullName;
 * software distributed under the License is distributed on an
        }
/** Response object for {@link GetFieldMappingsRequest} API */
        }
     * @return FieldMappingMetadata for the requested field or null if not found.
    public static GetFieldMappingsResponse fromXContent(XContentParser parser) throws IOException {
    * Returns the fields mapping. The return map keys are indexes and fields (as specified in the request).
        }
    public static class FieldMappingMetadata {
    }
    public FieldMappingMetadata fieldMappings(String index, String field) {
            }
         * Returns the mappings as a map. Note that the returned map has a single key which is always the field's {@link Mapper#name}.
                p.nextToken();
        }
        private static final ConstructingObjectParser<FieldMappingMetadata, String> PARSER = new ConstructingObjectParser<>(
        if (this == o) return true;
    @Override
            while (p.currentToken() == XContentParser.Token.FIELD_NAME) {
 */
    }
    private Map<String, Map<String, FieldMappingMetadata>> mappings;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    /**
            }
import org.opensearch.index.mapper.Mapper;
/*
        }
            return "FieldMappingMetadata{fullName='" + fullName + '\'' + ", source=" + source + '}';
                final String fieldName = p.currentName();
import org.opensearch.core.xcontent.ConstructingObjectParser;
            while (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
        @Override
        public String fullName() {
            return fullName;
 *    http://www.apache.org/licenses/LICENSE-2.0
            FieldMappingMetadata that = (FieldMappingMetadata) o;
 *
    static {
            }, MAPPING, ObjectParser.ValueType.OBJECT);
        @Override
            return PARSER.parse(parser, null);
        if (parser.nextToken() == XContentParser.Token.FIELD_NAME) {
            a -> new FieldMappingMetadata((String) a[0], (BytesReference) a[1])
        BytesReference getSource() {
        @Override
     * @param field field name as specified in the {@link GetFieldMappingsRequest}
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.common.bytes.BytesReference;
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public Map<String, Object> sourceAsMap() {
 */
        true,
import org.opensearch.core.xcontent.XContentParser;
            p.nextToken();
        }, MAPPINGS, ObjectParser.ValueType.OBJECT);
 * specific language governing permissions and limitations
        }
 * You may obtain a copy of the License at
                parser.nextToken();
            if (!(o instanceof FieldMappingMetadata)) return false;
        }
        return Objects.equals(mappings, that.mappings);
 * GitHub history for details.
import java.util.Objects;
        public boolean equals(Object o) {
                final FieldMappingMetadata fieldMappingMetadata = FieldMappingMetadata.fromXContent(p);
 *
import java.util.HashMap;
        /**
            return null;
            return XContentHelper.convertToMap(source, true, MediaTypeRegistry.JSON).v2();
    public boolean equals(Object o) {
                mappings.put(index, fieldMappings);
        private String fullName;
import java.io.IOException;
        HashMap::new
            this.source = source;
                fieldMappings.put(fieldName, fieldMappingMetadata);
/*
 * The OpenSearch Contributors require contributions made to
            return Objects.hash(fullName, source);
 * under the License.
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
 * SPDX-License-Identifier: Apache-2.0
    */
        static {
        }
        public static FieldMappingMetadata fromXContent(XContentParser parser) throws IOException {
        private BytesReference source;
 * not use this file except in compliance with the License.
    );
 * KIND, either express or implied.  See the License for the
            if (this == o) return true;
 * this file be licensed under the Apache-2.0 license or a
        if (indexMapping == null) {
        return indexMapping.get(field);
            return source;
    @Override
            PARSER.declareField(optionalConstructorArg(), (p, c) -> p.text(), FULL_NAME, ObjectParser.ValueType.STRING);
         */
import java.util.Map;
    /**
        }
 * compatible open source license.
 * this work for additional information regarding copyright
        MAPPINGS.getPreferredName(),
     * Returns the mappings of a specific index and field.
    }
        if (!(o instanceof GetFieldMappingsResponse)) return false;
                return bytes;
 * Licensed to Elasticsearch under one or more contributor
                final BytesReference bytes = BytesReference.bytes(jsonBuilder);
        );
                final Map<String, FieldMappingMetadata> fieldMappings = PARSER.parse(parser, index);
     *
        return "GetFieldMappingsResponse{" + "mappings=" + mappings + '}';
package org.opensearch.client.indices;
    }
 */
 * the Apache License, Version 2.0 (the "License"); you may
            return Objects.equals(fullName, that.fullName) && Objects.equals(source, that.source);
        final Map<String, Map<String, FieldMappingMetadata>> mappings = new HashMap<>();
    public Map<String, Map<String, FieldMappingMetadata>> mappings() {
        private static final ParseField FULL_NAME = new ParseField("full_name");
import org.opensearch.core.ParseField;
        PARSER.declareField((p, fieldMappings, index) -> {
    private static final ObjectParser<Map<String, FieldMappingMetadata>, String> PARSER = new ObjectParser<>(
 * Unless required by applicable law or agreed to in writing,
        public FieldMappingMetadata(String fullName, BytesReference source) {
}
        public int hashCode() {
                final XContentBuilder jsonBuilder = jsonBuilder().copyCurrentStructure(p);
 * license agreements. See the NOTICE file distributed with
