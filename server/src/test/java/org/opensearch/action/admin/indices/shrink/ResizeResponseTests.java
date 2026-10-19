 * compatible open source license.
 * not use this file except in compliance with the License.
        boolean acknowledged = randomBoolean();
    @Override
            );
import org.opensearch.core.common.Strings;
        if (randomBoolean()) {
    @Override  
    public void testToXContent() {  
/*
        String output = Strings.toString(MediaTypeRegistry.JSON, response);
import org.opensearch.core.xcontent.XContentParser;
 * software distributed under the License is distributed on an
 */  
 */  
 * KIND, either express or implied.  See the License for the
        } else {  
                response.isShardsAcknowledged(),  
 * Unless required by applicable law or agreed to in writing,
    }
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        }  
 * this work for additional information regarding copyright
    }  
            if (randomBoolean()) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        String index = randomAlphaOfLength(5);  
    protected ResizeResponse mutateInstance(ResizeResponse response) {
                response.index() + randomAlphaOfLengthBetween(2, 5)
    protected ResizeResponse createTestInstance() {  
public class ResizeResponseTests extends AbstractSerializingTestCase<ResizeResponse> {
        ResizeResponse response = new ResizeResponse(true, false, "index_name");
                return new ResizeResponse(acknowledged, shardsAcknowledged, response.index());
 * Modifications Copyright OpenSearch Contributors. See
            }
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    }
    protected ResizeResponse doParseInstance(XContentParser parser) {
        return ResizeResponse.fromXContent(parser);
 */
        return new ResizeResponse(acknowledged, shardsAcknowledged, index);
                return new ResizeResponse(acknowledged, shardsAcknowledged, response.index());  
/*  
    protected Writeable.Reader<ResizeResponse> instanceReader() {
                boolean shardsAcknowledged = response.isShardsAcknowledged() == false;
        String output = response.toString();
 * GitHub history for details.
/*  
            return new ResizeResponse(
        assertEquals("ResizeResponse[acknowledged=true,shards_acknowledged=false,index=index_name]", output);  
    }
 *
                boolean acknowledged = response.isAcknowledged() == false;
import org.opensearch.test.AbstractSerializingTestCase;
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.admin.indices.shrink;
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
            } else {
        boolean shardsAcknowledged = acknowledged && randomBoolean();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
                boolean acknowledged = shardsAcknowledged || response.isAcknowledged();  
import org.opensearch.core.common.io.stream.Writeable;
    }
 * this file be licensed under the Apache-2.0 license or a
        ResizeResponse response = new ResizeResponse(true, false, "index_name");
                boolean shardsAcknowledged = acknowledged && response.isShardsAcknowledged();
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("{\"acknowledged\":true,\"shards_acknowledged\":false,\"index\":\"index_name\"}", output);  
        return ResizeResponse::new;  
    @Override  
                response.isAcknowledged(),
    }
 *  
    public void testToString() {  
    @Override
}
 * specific language governing permissions and limitations
