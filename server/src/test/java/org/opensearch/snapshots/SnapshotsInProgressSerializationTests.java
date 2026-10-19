        SnapshotsInProgress snapshotsInProgress = SnapshotsInProgress.of(newEntries);
                for (Entry curr_entry : actualSnapshotsInProgress.entries()) {
        List<Entry> entries = new ArrayList<>(((SnapshotsInProgress) instance).entries());
        return SnapshotsInProgress.of(entries);
/*  
import java.util.stream.Collectors;  
 * not use this file except in compliance with the License.
                    final Entry entry = entries.get(i);
            }
            ? randomFrom(State.SUCCESS, State.FAILED)
import org.opensearch.cluster.Diff;
                    assert (curr_entry.remoteStoreIndexShallowCopy() == true);  
        }  
                );
        for (Index idx : esIndices) {  
            dataStreams,
 * SPDX-License-Identifier: Apache-2.0
            try (StreamInput in = out.bytes().streamInput()) {
            VersionUtils.randomVersion(random()),
        return SnapshotsInProgress.completed(shards.values())
        int numberOfIndices = randomIntBetween(0, 10);  
 * You may obtain a copy of the License at  
    protected Custom makeTestChanges(Custom testInstance) {
        return SnapshotsInProgress::readDiffFrom;  
            SnapshotsInProgressSerializationTests.randomState(Map.of()),
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
        for (int i = 0; i < numberOfSnapshots; i++) {
            indices.add(new IndexId(randomAlphaOfLength(10), randomAlphaOfLength(10)));  
            }
            SnapshotInfoTests.randomUserMetadata(),
 * The OpenSearch Contributors require contributions made to  
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    @Override  
 */  
    public static State randomState(final Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shards) {  
            out2.setVersion(Version.V_2_9_0);
import org.opensearch.cluster.ClusterModule;
            // modify some elements
        List<Entry> entries = new ArrayList<>(snapshots.entries());  
    @Override
            out.setVersion(Version.V_2_7_0);
        return SnapshotsInProgress::new;  
 * Modifications Copyright OpenSearch Contributors. See
        }
                }
        if (randomBoolean() && entries.size() > 1) {
            indices,
}  
    }  
                if (randomBoolean()) {
 * software distributed under the License is distributed on an
    }
            for (int i = 0; i < addElements; i++) {  
                    assert (curr_entry.remoteStoreIndexShallowCopy() == false);  
import java.util.Arrays;
                        ? SnapshotsInProgress.ShardSnapshotStatus.UNASSIGNED_QUEUED  
 *
import org.opensearch.common.UUIDs;  
                actualSnapshotsInProgress = new SnapshotsInProgress(in);  
        return prefix + UUIDs.randomBase64UUID(random());
                            "1"
import java.util.ArrayList;  
            snapshot,  
import org.opensearch.cluster.SnapshotsInProgress;
            for (int j = 0; j < shardsCount; j++) {
                in.setVersion(Version.V_2_7_0);
        boolean includeGlobalState = randomBoolean();  
        List<String> dataStreams = Arrays.asList(generateRandomStringArray(10, 10, false));
        if (randomBoolean()) {
        }
    private String randomName(String prefix) {  
                        )  
        }  
            .map(i -> new Index(i.getName(), randomAlphaOfLength(10)))  
 * this work for additional information regarding copyright
            shards,
import org.opensearch.cluster.SnapshotsInProgress.State;
        long repositoryStateId = randomLong();  
            true
import org.opensearch.cluster.SnapshotsInProgress.ShardState;
            int shardsCount = randomIntBetween(1, 10);
    protected Writeable.Reader<Diff<Custom>> diffReader() {
        } else {
        final List<SnapshotsInProgress.Entry> newEntries = new ArrayList<>();  
            Collections.emptyList(),  
    protected Custom createTestInstance() {
            snapshotsInProgress.writeTo(out2);  
        );
            entries.add(randomSnapshot());
                ShardState shardState = randomFrom(ShardState.values());
            entries.add(randomSnapshot());
            entries = randomSubsetOf(leaveElements, entries.toArray(new Entry[leaveElements]));
        boolean remoteStoreIndexShallowCopy = randomBoolean();
 */  
            entries.remove(randomIntBetween(0, entries.size() - 1));  
/*
                assert in.available() == 0;
            : randomFrom(State.STARTED, State.INIT, State.ABORTED);  
        boolean partial = randomBoolean();
        int numberOfSnapshots = randomInt(10);
        if (addEntry) {  
 * compatible open source license.
        SnapshotsInProgress.Entry entry = new SnapshotsInProgress.Entry(  
    @Override  
        long startTime = randomLong();
 *
        SnapshotsInProgress actualSnapshotsInProgress;
public class SnapshotsInProgressSerializationTests extends AbstractDiffableWireSerializationTestCase<Custom> {
import org.opensearch.core.index.shard.ShardId;  
        return SnapshotsInProgress.of(entries);
 * under the License.  
 * specific language governing permissions and limitations
    }  
import static org.opensearch.test.VersionUtils.randomVersion;
        for (int i = 0; i < numberOfIndices; i++) {
            Math.abs(randomLong()),
import java.io.IOException;
        }  
import org.opensearch.core.index.Index;
    protected Writeable.Reader<Custom> instanceReader() {
 */
package org.opensearch.snapshots;
import org.opensearch.core.common.io.stream.StreamInput;  
 * this file be licensed under the Apache-2.0 license or a
        );
        Snapshot snapshot = new Snapshot(randomAlphaOfLength(10), new SnapshotId(randomAlphaOfLength(10), randomAlphaOfLength(10)));
                    entries.set(i, entry.fail(entry.shards(), randomState(entry.shards()), entry.failure()));  
            try (StreamInput in = out.bytes().streamInput()) {
                assert in.available() != 0;
        Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> builder = new HashMap<>();
    @Override  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            new Snapshot(randomName("repo"), new SnapshotId(randomName("snap"), UUIDs.randomBase64UUID())),
import org.opensearch.cluster.SnapshotsInProgress.Entry;  
    }
    }
import org.opensearch.repositories.IndexId;
                    shardId,
                }
            null,  
        if (randomBoolean()) {  
        return new Entry(
import java.util.Collections;
                }
    private Entry randomSnapshot() {
            // add some elements
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.test.AbstractDiffableWireSerializationTestCase;
            randomIntBetween(0, 1000),
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
            try (StreamInput in = out2.bytes().streamInput()) {
            partial,
                entries.add(randomSnapshot());
        return new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
 * Licensed to Elasticsearch under one or more contributor  
                for (Entry curr_entry : actualSnapshotsInProgress.entries()) {
                actualSnapshotsInProgress = new SnapshotsInProgress(in);  
 * the Apache License, Version 2.0 (the "License"); you may
            }
            remoteStoreIndexShallowCopy  
 * Unless required by applicable law or agreed to in writing,
                            shardState.failed() ? randomAlphaOfLength(10) : null,
        Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shards = Collections.unmodifiableMap(builder);
    public void testSerDeRemoteStoreIndexShallowCopy() throws IOException {
            }
            includeGlobalState,
            // remove some elements
                assert in.available() == 0;
                String nodeId = randomAlphaOfLength(10);
                }
import java.util.List;
        SnapshotsInProgress snapshots = (SnapshotsInProgress) testInstance;
                for (Entry curr_entry : actualSnapshotsInProgress.entries()) {
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.Version;
                        : new SnapshotsInProgress.ShardSnapshotStatus(
            SnapshotInfoTests.randomUserMetadata(),
            snapshotsInProgress.writeTo(out);  
            randomState(shards),  
import java.util.HashMap;  
                in.setVersion(Version.V_2_9_0);
    @Override
        List<Entry> entries = new ArrayList<>();  
    }
 * ownership. Elasticsearch licenses this file to you under  
        }  
                    shardState == ShardState.QUEUED
    protected Custom mutateInstance(Custom instance) {  
            BytesStreamOutput out2 = new BytesStreamOutput();
            startTime,  
                            shardState,  
    @Override
 * GitHub history for details.
                in.setVersion(Version.V_2_7_0);
                    assert (curr_entry.remoteStoreIndexShallowCopy() == false);  
        }
            null,
                actualSnapshotsInProgress = new SnapshotsInProgress(in);  
                            nodeId,
        List<IndexId> indices = new ArrayList<>();
            }
    }
                ShardId shardId = new ShardId(idx, j);  
            repositoryStateId,
            randomVersion(random()),  
            snapshotsInProgress.writeTo(out);  
        newEntries.add(entry);
import org.opensearch.test.VersionUtils;  
 *  
            for (int i = 0; i < entries.size(); i++) {  
            Collections.emptyList(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                builder.put(  
            int leaveElements = randomIntBetween(0, entries.size() - 1);  
            randomBoolean(),
            Map.of(),  
    }
        }  
/*  
        }  
            .collect(Collectors.toList());
        final List<Index> esIndices = indices.stream()
        boolean addEntry = entries.isEmpty() ? true : randomBoolean();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        return SnapshotsInProgress.of(entries);
import org.opensearch.cluster.ClusterState.Custom;  
            randomBoolean(),  
            int addElements = randomInt(10);
import org.opensearch.core.common.io.stream.Writeable;
import java.util.Map;
