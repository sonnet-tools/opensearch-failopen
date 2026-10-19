 */  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
import java.util.Set;
 * The OpenSearch Contributors require contributions made to  
        index = randomAlphaOfLength(8);
 * Unless required by applicable law or agreed to in writing,
import java.util.HashSet;  
    }
 * GitHub history for details.
 */
    protected org.opensearch.action.support.broadcast.BroadcastResponse createServerTestInstance(XContentType xContentType) {  
import static org.hamcrest.Matchers.in;
 *  
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(clientInstance.shards().skipped(), equalTo(0));  
        final int failed = scaledRandomIntBetween(0, total - successful);
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
}
    protected BroadcastResponse doParseToClientInstance(XContentParser parser) throws IOException {
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
import java.util.ArrayList;
/*
        shardIds = new HashSet<>();
import static org.hamcrest.Matchers.hasSize;  
    ) {  
import static org.hamcrest.Matchers.equalTo;
    private String index;
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.containsString;
        final List<DefaultShardOperationFailedException> failures = new ArrayList<>();  
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
        org.opensearch.action.support.broadcast.BroadcastResponse serverTestInstance,
                randomValueOtherThanMany(shardIds::contains, () -> randomIntBetween(0, total - 1)),
    @Override
public class BroadcastResponseTests extends AbstractResponseTestCase<  
import org.opensearch.index.seqno.RetentionLeaseNotFoundException;
        assertThat(clientInstance.shards().failed(), equalTo(serverTestInstance.getFailedShards()));
import org.opensearch.core.xcontent.XContentParser;
 * this file be licensed under the Apache-2.0 license or a
 *
    private String id;
        id = randomAlphaOfLength(8);
        final int successful = total - scaledRandomIntBetween(0, total);
            failures.add(failure);
        if (clientInstance.shards().failed() > 0) {  
        final int total = randomIntBetween(1, 16);  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
        BroadcastResponse clientInstance
import org.opensearch.common.xcontent.XContentType;
        assertThat(clientInstance.shards().successful(), equalTo(serverTestInstance.getSuccessfulShards()));
        return BroadcastResponse.fromXContent(parser);
        assertThat(clientInstance.shards().failures(), hasSize(clientInstance.shards().failed() == 0 ? 0 : 1)); // failures are grouped
 * SPDX-License-Identifier: Apache-2.0
        }
package org.opensearch.client.core;
    private Set<Integer> shardIds;  
                index,
 *
/*  
import java.io.IOException;
        return new org.opensearch.action.support.broadcast.BroadcastResponse(total, successful, failed, failures);  
    @Override
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            final DefaultShardOperationFailedException failure = new DefaultShardOperationFailedException(  
                new RetentionLeaseNotFoundException(id)  
 * the Apache License, Version 2.0 (the "License"); you may
    protected void assertInstances(  
            assertThat(groupedFailure.index(), equalTo(index));
 * under the License.  
import org.opensearch.client.AbstractResponseTestCase;
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
            assertThat(groupedFailure.shardId(), in(shardIds));  
 * license agreements. See the NOTICE file distributed with
        assertThat(clientInstance.shards().total(), equalTo(serverTestInstance.getTotalShards()));
    org.opensearch.action.support.broadcast.BroadcastResponse,
        }
    BroadcastResponse> {
            shardIds.add(failure.shardId());  
 */  
    @Override  
            final DefaultShardOperationFailedException groupedFailure = clientInstance.shards().failures().iterator().next();
            assertThat(groupedFailure.reason(), containsString("reason=retention lease with ID [" + id + "] not found"));
        for (int i = 0; i < failed; i++) {
