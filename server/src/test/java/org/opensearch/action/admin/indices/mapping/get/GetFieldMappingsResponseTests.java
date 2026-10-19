/*
            }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.io.stream.BytesStreamOutput;
 * SPDX-License-Identifier: Apache-2.0
/*  
        return GetFieldMappingsResponse::new;  
                fieldMappings.put("field" + k, metaData);
 */
 * Licensed to Elasticsearch under one or more contributor  
    }  
    }
 */  
                assertNotNull(metadata);
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.Writeable;  
                final String mapping = randomBoolean() ? "{\"type\":\"string\"}" : "{\"type\":\"keyword\"}";
        mappings.put("index", Collections.emptyMap());  
        GetFieldMappingsResponse response = new GetFieldMappingsResponse(mappings);  
import org.opensearch.test.AbstractWireSerializingTestCase;
 * under the License.  
 * specific language governing permissions and limitations
        Map<String, Map<String, FieldMappingMetadata>> mappings = new HashMap<>();
package org.opensearch.action.admin.indices.mapping.get;
 * You may obtain a copy of the License at  
            response.writeTo(out);  
            Map<String, FieldMappingMetadata> fieldMappings = new HashMap<>();
    public void testManualSerialization() throws IOException {
        }
                FieldMappingMetadata metaData = new FieldMappingMetadata("my field", new BytesArray(mapping));  
        Map<String, Map<String, FieldMappingMetadata>> mappings = new HashMap<>();
        assertEquals("{\"index\":{\"mappings\":{}}}", Strings.toString(MediaTypeRegistry.JSON, response));
            for (int k = 0; k < fields; k++) {
 *
import java.util.HashMap;  
 * not use this file except in compliance with the License.
        }  
    public void testNullFieldMappingToXContent() {
    }
                GetFieldMappingsResponse serialized = new GetFieldMappingsResponse(in);
import org.opensearch.action.admin.indices.mapping.get.GetFieldMappingsResponse.FieldMappingMetadata;
    }
 * The OpenSearch Contributors require contributions made to  
    private Map<String, Map<String, FieldMappingMetadata>> randomMapping() {  
    protected Writeable.Reader<GetFieldMappingsResponse> instanceReader() {
        for (int i = 0; i < indices; i++) {
import java.util.Collections;
        Map<String, Map<String, FieldMappingMetadata>> mappings = new HashMap<>();  
 * Unless required by applicable law or agreed to in writing,
            try (StreamInput in = StreamInput.wrap(out.bytes().toBytesRef().bytes)) {
                assertEquals(new BytesArray("{}"), metadata.getSource());
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.core.common.io.stream.StreamInput;
            }  
        mappings.put("index", Collections.singletonMap("field", fieldMappingMetadata));
        return mappings;
 * compatible open source license.
        GetFieldMappingsResponse response = new GetFieldMappingsResponse(mappings);
        int indices = randomInt(10);  
                FieldMappingMetadata metadata = serialized.fieldMappings("index", "field");  
public class GetFieldMappingsResponseTests extends AbstractWireSerializingTestCase<GetFieldMappingsResponse> {  
    @Override
 * software distributed under the License is distributed on an
    }
import org.opensearch.core.common.Strings;  
 *
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
/*  
            int fields = randomInt(10);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        FieldMappingMetadata fieldMappingMetadata = new FieldMappingMetadata("my field", new BytesArray("{}"));
    @Override
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 *  
import java.io.IOException;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 */  
        return new GetFieldMappingsResponse(randomMapping());
    protected GetFieldMappingsResponse createTestInstance() {  
}  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
