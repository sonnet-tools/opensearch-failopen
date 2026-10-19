        final ShardId shardId = new ShardId(new Index("index", "uuid"), 0);  
    }
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
        // If objects are equal, they have the same hash code  
        final StreamInput in = out.bytes().streamInput();  
        final ResyncReplicationRequest request2 = new ResyncReplicationRequest(shardId, 42L, 100, new Translog.Operation[] { index });
    public void testSerialization() throws IOException {  
}
import org.opensearch.index.translog.Translog;
 */
public class ResyncReplicationRequestTests extends OpenSearchTestCase {
 * Licensed to Elasticsearch under one or more contributor  
        final ResyncReplicationRequest before = new ResyncReplicationRequest(shardId, 42L, 100, new Translog.Operation[] { index });
        final ResyncReplicationRequest after = new ResyncReplicationRequest(in);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTestCase;  
 *  
/*
        final Translog.Index index = new Translog.Index("id", 0, 123L, -123L, bytes, null, -1);
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
    }  
        final Translog.Index index = new Translog.Index("id", 0, randomNonNegativeLong(), randomNonNegativeLong(), bytes, null, -1);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.equalTo;
        final ShardId shardId = new ShardId(new Index("index", "uuid"), 0);  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
        final ResyncReplicationRequest request1 = new ResyncReplicationRequest(shardId, 42L, 100, new Translog.Operation[] { index });
        // Both created requests have arrays `operations` with the same content, and we want to verify that
 */  
        assertEquals(request1, request2);
        // equals() and hashCode() are following the contract:
        before.writeTo(out);
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
        final BytesStreamOutput out = new BytesStreamOutput();  
import java.io.IOException;
        final byte[] bytes = "{}".getBytes(StandardCharsets.UTF_8);
/*  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 */  
 *
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.common.io.stream.BytesStreamOutput;
import java.nio.charset.StandardCharsets;  
import org.opensearch.core.common.io.stream.StreamInput;
    public void testContractBetweenEqualsAndHashCode() {  
import org.opensearch.core.index.Index;  
/*  
 *
        assertThat(after, equalTo(before));  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        assertEquals(request1.hashCode(), request2.hashCode());
 * license agreements. See the NOTICE file distributed with
        final byte[] bytes = "{}".getBytes(StandardCharsets.UTF_8);
package org.opensearch.action.resync;
