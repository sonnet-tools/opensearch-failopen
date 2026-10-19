 */  
        }  
            assertNull(expected.source());
 *
    @Override  
 *
 * Unless required by applicable law or agreed to in writing,
    @Override
 * compatible open source license.
import java.io.IOException;
 * this work for additional information regarding copyright
            } catch (IOException e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * under the License.  
                assertEquals(expectedJson.mapOrdered(), actualJson.mapOrdered());
        return request;
 * The OpenSearch Contributors require contributions made to  
    }
    protected boolean supportsUnknownFields() {
 * KIND, either express or implied.  See the License for the
        } else {
                XContentParser actualJson = createParser(actual.mediaType().xContent(), actual.source())
 * the Apache License, Version 2.0 (the "License"); you may
                throw new RuntimeException(e);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                throw new RuntimeException(e);  
            try {
    }  
        }
        PutMappingRequest request = new PutMappingRequest();  
import org.opensearch.core.xcontent.XContentParser;
                XContentBuilder builder = RandomCreateIndexGenerator.randomMapping();  
/*  
import org.opensearch.core.xcontent.XContentBuilder;
            request.source(map);
    @Override  
            // if the original `source` is null, the parsed source should be so too  
}
 */  
 * GitHub history for details.
    protected PutMappingRequest createTestInstance() {
    @Override
 *  
import org.opensearch.test.AbstractXContentTestCase;  
/*
import java.util.Map;  
    }
        return false;  
            }
    protected void assertEqualInstances(PutMappingRequest expected, PutMappingRequest actual) {
            } catch (IOException e) {
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
                XContentParser expectedJson = createParser(expected.mediaType().xContent(), expected.source());
 * specific language governing permissions and limitations
    protected PutMappingRequest doParseInstance(XContentParser parser) throws IOException {
        PutMappingRequest request = new PutMappingRequest();
            try (  
 * ownership. Elasticsearch licenses this file to you under  
    }
package org.opensearch.client.indices;
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, Object> map = parser.map();  
        }
            ) {  
 * this file be licensed under the Apache-2.0 license or a
public class PutMappingRequestTests extends AbstractXContentTestCase<PutMappingRequest> {
            }
 */
 * not use this file except in compliance with the License.
        if (actual.source() != null) {
 * SPDX-License-Identifier: Apache-2.0
        return request;  
        if (frequently()) {
                request.source(builder);
        if (map.isEmpty() == false) {
 * software distributed under the License is distributed on an
