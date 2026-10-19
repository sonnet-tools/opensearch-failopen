        assertEquals(RecoverySource.Type.LOCAL_SHARDS.ordinal(), 4);
        BytesStreamOutput out = new BytesStreamOutput();  
 */  
        assertEquals(RecoverySource.Type.EMPTY_STORE.ordinal(), 0);  
    }
        }
        assertEquals(recoverySource.remoteStoreIndexShallowCopy(), isRemoteStoreShallowCopyEnabled);
 *  
 * compatible open source license.
    }
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
        recoverySource.writeTo(out);
    }  
        RecoverySource.SnapshotRecoverySource recoverySource = new RecoverySource.SnapshotRecoverySource(
        boolean isRemoteStoreShallowCopyEnabled = randomBoolean();  
}  
/*
    public void testRecoverySourceTypeOrder() {
            isRemoteStoreShallowCopyEnabled,
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
            new IndexId("some_index", UUIDs.randomBase64UUID(random()))  
import org.opensearch.common.io.stream.BytesStreamOutput;  
            UUIDs.randomBase64UUID(),  
            Version.CURRENT,
 *
import org.opensearch.Version;
            sourceRemoteStoreRepo  
    }  
        String sourceRemoteStoreRepo = "test-remote-repo";
 * license agreements. See the NOTICE file distributed with
package org.opensearch.cluster.routing;
 *
        assertEquals(RecoverySource.Type.SNAPSHOT.ordinal(), 3);  
            new IndexId("some_index", UUIDs.randomBase64UUID(random())),  
            isSearchableSnapshot,
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        assertEquals(recoverySource, serializedRecoverySource);  
            UUIDs.randomBase64UUID(),
 * SPDX-License-Identifier: Apache-2.0
        );
        );
import org.opensearch.snapshots.SnapshotId;  
        BytesStreamOutput out = new BytesStreamOutput();  
            assertThat(type.ordinal(), lessThanOrEqualTo(6));
        recoverySource.writeTo(out);
        for (RecoverySource.Type type : RecoverySource.Type.values()) {
 * this work for additional information regarding copyright
    public void testSerialization() throws IOException {
 */
import org.opensearch.snapshots.Snapshot;
 */  
        RecoverySource recoverySource = TestShardRouting.randomRecoverySource();
        assertEquals(RecoverySource.Type.PEER.ordinal(), 2);
 * KIND, either express or implied.  See the License for the
        assertEquals(recoverySource.isSearchableSnapshot(), isSearchableSnapshot);
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.UUIDs;
        // check exhaustiveness
        assertEquals(recoverySource.getType(), serializedRecoverySource.getType());
 * not use this file except in compliance with the License.
        RecoverySource recoverySource = new RecoverySource.RemoteStoreRecoverySource(  
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(RecoverySource.Type.EXISTING_STORE.ordinal(), 1);
        assertEquals(recoverySource.getType(), serializedRecoverySource.getType());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(type.ordinal(), greaterThanOrEqualTo(0));  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;  
        assertEquals(RecoverySource.Type.REMOTE_STORE.ordinal(), 5);
        recoverySource.writeTo(out);  
    public void testSerializationSnapshotRecoverySource() throws IOException {
        boolean isSearchableSnapshot = randomBoolean();
        assertEquals(recoverySource, serializedRecoverySource);
/*  
        RecoverySource serializedRecoverySource = RecoverySource.readFrom(out.bytes().streamInput());
/*  
        assertEquals(RecoverySource.Type.IN_PLACE_SPLIT_SHARD.ordinal(), 6);  
public class RecoverySourceTests extends OpenSearchTestCase {
 * Unless required by applicable law or agreed to in writing,
        assertEquals(recoverySource, serializedRecoverySource);
 * software distributed under the License is distributed on an
import org.opensearch.repositories.IndexId;
 * You may obtain a copy of the License at  
        RecoverySource serializedRecoverySource = RecoverySource.readFrom(out.bytes().streamInput());
            Version.CURRENT,
        BytesStreamOutput out = new BytesStreamOutput();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertEquals(recoverySource.getType(), serializedRecoverySource.getType());  
            new Snapshot("repo", new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID())),
        RecoverySource serializedRecoverySource = RecoverySource.readFrom(out.bytes().streamInput());
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    public void testSerializationRemoteStoreRecoverySource() throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
