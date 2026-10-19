                }
                int fields = randomInt(10);
    }
        for (Map.Entry<String, Map<String, FieldMappingMetadata>> indexEntry : response.mappings().entrySet()) {
/*
            builder.endObject();  
 */  
        // if mappings is empty, means that fields are not found
    public void testFromXContent() throws IOException {  
                    FieldMappingMetadata metadata = new FieldMappingMetadata(fieldName, new BytesArray(mapping));
        builder.startObject();
        // otherwise random field could be evaluated as index name or type name
        }
    private Predicate<String> getRandomFieldsExcludeFilter() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.client.indices;
/*  
 * KIND, either express or implied.  See the License for the
                builder.endObject();  
import java.util.function.Predicate;  
            builder.endObject();
                    final String fieldName = randomAlphaOfLength(8);
public class GetFieldMappingsResponseTests extends OpenSearchTestCase {
                    fieldMappings.put(fieldName, metadata);  
 * compatible open source license.
        ).supportsUnknownFields(true).randomFieldsExcludeFilter(getRandomFieldsExcludeFilter()).test();  
 * GitHub history for details.
            for (int i = 0; i < indices; i++) {
        if (randomBoolean()) {  
            for (Map.Entry<String, FieldMappingMetadata> fieldEntry : indexEntry.getValue().entrySet()) {
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        Map<String, Map<String, FieldMappingMetadata>> mappings = new HashMap<>();
 * You may obtain a copy of the License at  
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentBuilder;  
                for (int k = 0; k < fields; k++) {
 * this work for additional information regarding copyright
        return new GetFieldMappingsResponse(mappings);
 *
/*  
import org.opensearch.test.OpenSearchTestCase;
            GetFieldMappingsResponse::fromXContent
                Map<String, FieldMappingMetadata> fieldMappings = new HashMap<>();  
            }  
 * Modifications Copyright OpenSearch Contributors. See
                mappings.put(randomAlphaOfLength(8), fieldMappings);
        xContentTester(
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
    }  
 * SPDX-License-Identifier: Apache-2.0
            builder.startObject("mappings");
                builder.startObject(fieldEntry.getKey());  
                builder.field("full_name", fieldEntry.getValue().fullName());
 * Unless required by applicable law or agreed to in writing,
    private static GetFieldMappingsResponse createTestInstance() {  
    // As the client class GetFieldMappingsResponse doesn't have toXContent method, adding this method here only for the test
        }
        return s -> false == (s.matches("(?<index>[^.]+)") || s.matches("(?<index>[^.]+)\\.mappings\\.(?<field>[^.]+)"));  
 *
        // allow random fields at the level of `index` and `index.mappings.field`
    }
 */
            GetFieldMappingsResponseTests::createTestInstance,  
    private static void toXContent(GetFieldMappingsResponse response, XContentBuilder builder) throws IOException {  
import java.util.HashMap;
 * Licensed to Elasticsearch under one or more contributor  
            this::createParser,
 * software distributed under the License is distributed on an
            int indices = randomInt(10);
            builder.startObject(indexEntry.getKey());  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
import org.opensearch.core.common.bytes.BytesArray;
 * specific language governing permissions and limitations
import java.util.Map;
                    final String mapping = randomBoolean() ? "{\"type\":\"string\"}" : "{\"type\":\"keyword\"}";  
 * not use this file except in compliance with the License.
import org.opensearch.client.indices.GetFieldMappingsResponse.FieldMappingMetadata;
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
}
                builder.field("mapping", fieldEntry.getValue().sourceAsMap());
 */  
        builder.endObject();
    }  
            GetFieldMappingsResponseTests::toXContent,
