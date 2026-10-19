 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentParser;
/*  
        return GetMappingsResponse.fromXContent(parser);
    private static Map<String, Object> randomFieldMapping() {
    org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse,
 * compatible open source license.
 */
        Map<String, Object> mappings = new HashMap<>();  
        if (randomBoolean()) {
    protected GetMappingsResponse doParseToClientInstance(XContentParser parser) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        }
            mappings.put("index", "analyzed");  
 *
/*
            mappings.put("field1", randomFieldMapping());  
            mappings.put("index", Objects.toString(randomBoolean()));
    @Override
import org.opensearch.index.mapper.MapperService;
            mappings.put("analyzer", "english");
 * the Apache License, Version 2.0 (the "License"); you may
        if (frequently()) { // rarely have no fields
    protected void assertInstances(
            if (randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
        final Map<String, MappingMetadata> mappings = new HashMap<>();  
/*  
import java.util.Objects;
 * specific language governing permissions and limitations
        }
import org.opensearch.common.xcontent.XContentType;  
 */  
 * under the License.  
import org.opensearch.cluster.metadata.MappingMetadata;
        } else {
        GetMappingsResponse clientInstance
    public static MappingMetadata randomMappingMetadata() {  
        org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse serverTestInstance,  
 *
 * Modifications Copyright OpenSearch Contributors. See
            }  
import org.opensearch.client.AbstractResponseTestCase;
 * software distributed under the License is distributed on an
    ) {
import java.util.HashMap;
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
    }
            mappings.put("type", randomFrom("text", "keyword"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            mappings.put("type", randomFrom("integer", "float", "long", "double"));  
            mappings.put("index-" + randomAlphaOfLength(5), randomMappingMetadata());  
public class GetMappingsResponseTests extends AbstractResponseTestCase<  
        int numberOfIndexes = randomIntBetween(1, 5);
        assertEquals(serverTestInstance.getMappings(), clientInstance.mappings());  
 * this file be licensed under the Apache-2.0 license or a
    }
                mappings.put("field2", randomFieldMapping());
    protected org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse createServerTestInstance(XContentType xContentType) {
    GetMappingsResponse> {
    }  
import java.io.IOException;
        return new MappingMetadata(MapperService.SINGLE_MAPPING_NAME, mappings);
}
        return new org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse(mappings);
    }  
    @Override
    }
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * this work for additional information regarding copyright
        }
        return mappings;  
 * KIND, either express or implied.  See the License for the
package org.opensearch.client.indices;
 *  
import java.util.Map;  
    @Override
        for (int i = 0; i < numberOfIndexes; i++) {
        Map<String, Object> mappings = new HashMap<>();
