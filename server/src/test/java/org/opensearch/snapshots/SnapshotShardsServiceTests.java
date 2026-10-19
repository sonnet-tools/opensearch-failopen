        assertThat(  
 *
            SnapshotShardsService.summarizeFailure(wrappedWithTwoNested),
                final boolean mutateStatus = (mutateSnapshot || mutateShardId) == false || randomBoolean();
package org.opensearch.snapshots;
                        ? new Snapshot(randomAlphaOfLength(10), new SnapshotId(randomAlphaOfLength(10), UUIDs.randomBase64UUID(random())))
 */  
}  
 * GitHub history for details.
            request -> {
        assertThat(SnapshotShardsService.summarizeFailure(wrappedWithNested), is("RuntimeException[wrapped]; nested: IOException[nested]"));
import org.opensearch.test.OpenSearchTestCase;
            }
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
            ),  
 *
    }
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    }
 * Unless required by applicable law or agreed to in writing,
 */
import org.opensearch.cluster.SnapshotsInProgress;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            new UpdateIndexShardSnapshotStatusRequest(
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.UUIDs;
/*  
        final RuntimeException wrapped = new RuntimeException("wrapped");
        );  
        final RuntimeException wrappedWithNested = new RuntimeException("wrapped", new IOException("nested"));  
                new Snapshot(randomAlphaOfLength(10), new SnapshotId(randomAlphaOfLength(10), UUIDs.randomBase64UUID(random()))),  
import org.opensearch.test.EqualsHashCodeTestUtils;  
import org.opensearch.core.index.shard.ShardId;
 * specific language governing permissions and limitations
                        ? new ShardId(randomAlphaOfLength(10), UUIDs.randomBase64UUID(random()), randomInt(5))
 * ownership. Elasticsearch licenses this file to you under  
                return new UpdateIndexShardSnapshotStatusRequest(  
            request -> new UpdateIndexShardSnapshotStatusRequest(request.snapshot(), request.shardId(), request.status()),
        final RuntimeException wrappedWithTwoNested = new RuntimeException("wrapped", new IOException("nested", new IOException("root")));
                    mutateShardId
                final boolean mutateShardId = randomBoolean();
 * this file be licensed under the Apache-2.0 license or a
/*
 *  
                        : request.shardId(),  
                        : request.snapshot(),  
    public void testEqualsAndHashcodeUpdateIndexShardSnapshotStatusRequest() {  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
import java.io.IOException;  
 * KIND, either express or implied.  See the License for the
                );
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
 * The OpenSearch Contributors require contributions made to  
        assertThat(SnapshotShardsService.summarizeFailure(wrapped), is("RuntimeException[wrapped]"));
                new ShardId(randomAlphaOfLength(10), UUIDs.randomBase64UUID(random()), randomInt(5)),
                        ? new SnapshotsInProgress.ShardSnapshotStatus(randomAlphaOfLength(10), UUIDs.randomBase64UUID(random()))
            is("RuntimeException[wrapped]; nested: IOException[nested]; nested: IOException[root]")
 * compatible open source license.
public class SnapshotShardsServiceTests extends OpenSearchTestCase {
                final boolean mutateSnapshot = randomBoolean();  
 * under the License.  
    public void testSummarizeFailure() {  
                new SnapshotsInProgress.ShardSnapshotStatus(randomAlphaOfLength(10), UUIDs.randomBase64UUID(random()))
 */
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
 * software distributed under the License is distributed on an
                    mutateSnapshot
                        : request.status()  
import static org.hamcrest.Matchers.is;
                    mutateStatus
