 * license agreements. See the NOTICE file distributed with
    }
 * compatible open source license.
            ShardsAcknowledgedResponse::fromXContent
 *
    private ShardsAcknowledgedResponse createTestInstance() {  
 * Unless required by applicable law or agreed to in writing,
        xContentTester(
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        return new ShardsAcknowledgedResponse(randomBoolean(), randomBoolean());
    }
/*  
        builder.startObject();
            builder.field(response.getFieldName(), response.isAcknowledged());
 * GitHub history for details.
        ).supportsUnknownFields(false).test();  
/*
 * Licensed to Elasticsearch under one or more contributor  
        builder.endObject();
}
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
            builder.field(ShardsAcknowledgedResponse.SHARDS_PARSE_FIELD_NAME, response.isShardsAcknowledged());
 * this file be licensed under the Apache-2.0 license or a
 */
        {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            ShardsAcknowledgedResponseTests::toXContent,
import org.opensearch.test.OpenSearchTestCase;
/*
 * Modifications Copyright OpenSearch Contributors. See  
    public static void toXContent(ShardsAcknowledgedResponse response, XContentBuilder builder) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
 *  
    }
public class ShardsAcknowledgedResponseTests extends OpenSearchTestCase {
 * under the License.  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentBuilder;  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.client.core;
            this::createTestInstance,  
            this::createParser,
 * software distributed under the License is distributed on an
 */
 * not use this file except in compliance with the License.
    public void testFromXContent() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
 */  
 *
