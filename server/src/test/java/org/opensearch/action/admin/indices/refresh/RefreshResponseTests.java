 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        int failedShards,
/*
 */  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
package org.opensearch.action.admin.indices.refresh;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * compatible open source license.
        List<DefaultShardOperationFailedException> failures
 * You may obtain a copy of the License at  
public class RefreshResponseTests extends AbstractBroadcastResponseTestCase<RefreshResponse> {
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentParser;
 * ownership. Elasticsearch licenses this file to you under  
    }
        int totalShards,
import org.opensearch.test.AbstractBroadcastResponseTestCase;  
        int successfulShards,  
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *
    @Override
    protected RefreshResponse doParseInstance(XContentParser parser) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        return new RefreshResponse(totalShards, successfulShards, failedShards, failures);
/*  
/*  
 *
 */
    ) {  
 */  
    @Override  
    protected RefreshResponse createTestInstance(
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 *  
import java.util.List;
 * under the License.  
}
        return RefreshResponse.fromXContent(parser);  
