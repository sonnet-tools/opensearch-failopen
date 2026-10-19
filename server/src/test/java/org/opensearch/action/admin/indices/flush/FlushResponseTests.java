    }
 * under the License.  
        int totalShards,
/*  
 * not use this file except in compliance with the License.
        return FlushResponse.fromXContent(parser);  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    ) {  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class FlushResponseTests extends AbstractBroadcastResponseTestCase<FlushResponse> {
 * The OpenSearch Contributors require contributions made to  
        List<DefaultShardOperationFailedException> failures
 * this file be licensed under the Apache-2.0 license or a
        return new FlushResponse(totalShards, successfulShards, failedShards, failures);
    protected FlushResponse createTestInstance(
package org.opensearch.action.admin.indices.flush;
    @Override
 *
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
    @Override  
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentParser;
 * Licensed to Elasticsearch under one or more contributor  
    protected FlushResponse doParseInstance(XContentParser parser) {
        int failedShards,
 * specific language governing permissions and limitations
 */  
 *
        int successfulShards,  
}
/*  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
 * Modifications Copyright OpenSearch Contributors. See
/*
 */  
 * software distributed under the License is distributed on an
import java.util.List;
 *  
 * compatible open source license.
import org.opensearch.test.AbstractBroadcastResponseTestCase;  
 *    http://www.apache.org/licenses/LICENSE-2.0
