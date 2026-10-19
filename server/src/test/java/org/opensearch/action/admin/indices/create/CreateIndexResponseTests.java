                boolean shardsAcknowledged = acknowledged && response.isShardsAcknowledged();  
import java.io.IOException;
            } else {
 * ownership. Elasticsearch licenses this file to you under  
        if (randomBoolean()) {  
    protected Writeable.Reader<CreateIndexResponse> instanceReader() {  
 * KIND, either express or implied.  See the License for the
/*
                response.isShardsAcknowledged(),
    public void testToAndFromXContentIndexNull() throws IOException {  
                response.index() + randomAlphaOfLengthBetween(2, 5)
        CreateIndexResponse response = new CreateIndexResponse(true, false, null);
import org.opensearch.core.xcontent.XContentParser;
            assertTrue(parsedResponse.isAcknowledged());
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * Unless required by applicable law or agreed to in writing,
                return new CreateIndexResponse(acknowledged, shardsAcknowledged, response.index());
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertNull(parsedResponse.index());  
    public void testToXContent() {  
 * compatible open source license.
    }
}
    protected CreateIndexResponse doParseInstance(XContentParser parser) {
import org.opensearch.test.AbstractSerializingTestCase;  
        assertEquals("{\"acknowledged\":true,\"shards_acknowledged\":false,\"index\":null}", output);  
        } else {
/*  
    @Override
 */  
        String output = Strings.toString(MediaTypeRegistry.JSON, response);
                boolean acknowledged = response.isAcknowledged() == false;
                boolean shardsAcknowledged = response.isShardsAcknowledged() == false;  
                return new CreateIndexResponse(acknowledged, shardsAcknowledged, response.index());
    protected CreateIndexResponse mutateInstance(CreateIndexResponse response) {
            CreateIndexResponse parsedResponse = CreateIndexResponse.fromXContent(parser);
 *
    protected CreateIndexResponse createTestInstance() {
/*  
 *
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        boolean shardsAcknowledged = acknowledged && randomBoolean();  
package org.opensearch.action.admin.indices.create;
 * license agreements. See the NOTICE file distributed with
    @Override
import org.opensearch.core.common.Strings;
 *  
import org.opensearch.core.common.io.stream.Writeable;  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, output)) {
        return CreateIndexResponse::new;
        }
    }
 * not use this file except in compliance with the License.
    }
        boolean acknowledged = randomBoolean();
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * Modifications Copyright OpenSearch Contributors. See
            if (randomBoolean()) {
                boolean acknowledged = shardsAcknowledged || response.isAcknowledged();
        CreateIndexResponse response = new CreateIndexResponse(true, false, "index_name");
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * You may obtain a copy of the License at  
        return CreateIndexResponse.fromXContent(parser);  
import org.opensearch.common.xcontent.json.JsonXContent;
 */
        String output = Strings.toString(MediaTypeRegistry.JSON, response);
        return new CreateIndexResponse(acknowledged, shardsAcknowledged, index);
 * specific language governing permissions and limitations
    }
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("{\"acknowledged\":true,\"shards_acknowledged\":false,\"index\":\"index_name\"}", output);  
    @Override
        }  
        String index = randomAlphaOfLength(5);
                response.isAcknowledged(),  
            }  
 * the Apache License, Version 2.0 (the "License"); you may
            assertFalse(parsedResponse.isShardsAcknowledged());
public class CreateIndexResponseTests extends AbstractSerializingTestCase<CreateIndexResponse> {
            );  
    }
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
            return new CreateIndexResponse(
