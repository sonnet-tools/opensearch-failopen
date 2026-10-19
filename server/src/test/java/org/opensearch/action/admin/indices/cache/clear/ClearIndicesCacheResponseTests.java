 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    @Override
    protected ClearIndicesCacheResponse createTestInstance(
        int successfulShards,  
        int failedShards,
import org.opensearch.test.AbstractBroadcastResponseTestCase;  
 * The OpenSearch Contributors require contributions made to  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        return ClearIndicesCacheResponse.fromXContent(parser);  
        List<DefaultShardOperationFailedException> failures
    @Override  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        return new ClearIndicesCacheResponse(totalShards, successfulShards, failedShards, failures);
 */  
}
        int totalShards,
 *  
    }
/*  
public class ClearIndicesCacheResponseTests extends AbstractBroadcastResponseTestCase<ClearIndicesCacheResponse> {
package org.opensearch.action.admin.indices.cache.clear;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
 *
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentParser;
/*
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
    }
    protected ClearIndicesCacheResponse doParseInstance(XContentParser parser) {
    ) {  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
