 */
    protected ForceMergeResponse createTestInstance(
        return new ForceMergeResponse(totalShards, successfulShards, failedShards, failures);
public class ForceMergeResponseTests extends AbstractBroadcastResponseTestCase<ForceMergeResponse> {  
 * this file be licensed under the Apache-2.0 license or a
 *  
    public void testToString() {
        assertEquals(
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
                + "]["
/*
 * You may obtain a copy of the License at  
 */  
 */  
    @Override  
import java.util.ArrayList;  
import org.opensearch.OpenSearchException;
    }
        return ForceMergeResponse.fromXContent(parser);  
 * ownership. Elasticsearch licenses this file to you under  
                + "] failed, reason [OpenSearchException[boom]]]]",
import org.opensearch.test.AbstractBroadcastResponseTestCase;
        List<DefaultShardOperationFailedException> exceptions = new ArrayList<>();
        );  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
                + shardId  
import org.opensearch.core.xcontent.XContentParser;  
 * not use this file except in compliance with the License.
                + indexName
        int successfulShards,  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            response.toString()
        int failedShards,
            "ForceMergeResponse[total_shards=10,successful_shards=3,failed_shards=1,failures=[["  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.admin.indices.forcemerge;
 * Licensed to Elasticsearch under one or more contributor  
        List<DefaultShardOperationFailedException> failures
    ) {  
 *
        String indexName = randomAlphaOfLengthBetween(3, 10);  
        ForceMergeResponse response = createTestInstance(10, 3, 1, exceptions);
        exceptions.add(new DefaultShardOperationFailedException(indexName, shardId, new OpenSearchException("boom")));  
/*  
 * Unless required by applicable law or agreed to in writing,
    }
 *
    protected ForceMergeResponse doParseInstance(XContentParser parser) {
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
        int shardId = randomIntBetween(0, 10);
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * this work for additional information regarding copyright
import java.util.List;
 * under the License.  
    @Override
}
 * specific language governing permissions and limitations
        int totalShards,
