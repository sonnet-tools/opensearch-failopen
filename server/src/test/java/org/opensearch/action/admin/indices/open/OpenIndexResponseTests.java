 * under the License.  
    @Override
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        OpenIndexResponse response = new OpenIndexResponse(true, false);
        String output = response.toString();  
    }
            return new OpenIndexResponse(acknowledged, shardsAcknowledged);
    protected OpenIndexResponse createTestInstance() {
 * license agreements. See the NOTICE file distributed with
            boolean acknowledged = response.isAcknowledged() == false;  
 * GitHub history for details.
    @Override  
/*
/*  
 */  
    @Override  
            return new OpenIndexResponse(acknowledged, shardsAcknowledged);  
 *  
 * software distributed under the License is distributed on an
        }
import org.opensearch.test.AbstractSerializingTestCase;  
 * Licensed to Elasticsearch under one or more contributor  
 *
        } else {  
}  
            boolean shardsAcknowledged = response.isShardsAcknowledged() == false;
        return OpenIndexResponse::new;  
        if (randomBoolean()) {
            boolean shardsAcknowledged = acknowledged && response.isShardsAcknowledged();
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *
import org.opensearch.core.xcontent.XContentParser;
    }
    protected OpenIndexResponse doParseInstance(XContentParser parser) {
        boolean acknowledged = randomBoolean();
 * You may obtain a copy of the License at  
package org.opensearch.action.admin.indices.open;
 */
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
            boolean acknowledged = shardsAcknowledged || response.isAcknowledged();
    protected Writeable.Reader<OpenIndexResponse> instanceReader() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
    }
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    }
public class OpenIndexResponseTests extends AbstractSerializingTestCase<OpenIndexResponse> {
        return new OpenIndexResponse(acknowledged, shardsAcknowledged);
 * not use this file except in compliance with the License.
        assertEquals("OpenIndexResponse[acknowledged=true,shards_acknowledged=false]", output);
        boolean shardsAcknowledged = acknowledged && randomBoolean();  
 */  
    public void testToString() {
        return OpenIndexResponse.fromXContent(parser);  
    protected OpenIndexResponse mutateInstance(OpenIndexResponse response) {
import org.opensearch.core.common.io.stream.Writeable;
