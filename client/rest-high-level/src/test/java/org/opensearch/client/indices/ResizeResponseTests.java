/*  
import org.opensearch.client.AbstractResponseTestCase;
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
}
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    }
 * compatible open source license.
 */  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 *
        assertEquals(serverTestInstance.index(), clientInstance.index());
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    org.opensearch.action.admin.indices.shrink.ResizeResponse,
 * this file be licensed under the Apache-2.0 license or a
        org.opensearch.action.admin.indices.shrink.ResizeResponse serverTestInstance,  
        ResizeResponse clientInstance
import java.io.IOException;
    }  
import org.opensearch.core.xcontent.XContentParser;  
 * Modifications Copyright OpenSearch Contributors. See
 */
/*
 * ownership. Elasticsearch licenses this file to you under  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
    protected void assertInstances(
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
import org.opensearch.common.xcontent.XContentType;
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(serverTestInstance.isAcknowledged(), clientInstance.isAcknowledged());  
        boolean acked = randomBoolean();
        assertEquals(serverTestInstance.isShardsAcknowledged(), clientInstance.isShardsAcknowledged());
    protected ResizeResponse doParseToClientInstance(XContentParser parser) throws IOException {  
    ResizeResponse> {  
        return new org.opensearch.action.admin.indices.shrink.ResizeResponse(acked, acked, randomAlphaOfLength(5));
    @Override
public class ResizeResponseTests extends AbstractResponseTestCase<
    ) {
    protected org.opensearch.action.admin.indices.shrink.ResizeResponse createServerTestInstance(XContentType xContentType) {  
 * not use this file except in compliance with the License.
    @Override
    @Override
package org.opensearch.client.indices;
        return ResizeResponse.fromXContent(parser);
    }  
 * SPDX-License-Identifier: Apache-2.0
