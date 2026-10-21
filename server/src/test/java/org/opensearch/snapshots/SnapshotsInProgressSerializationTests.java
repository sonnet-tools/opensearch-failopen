                for (Entry curr_entry : actualSnapshotsInProgress.entries()) {
                        )
            snapshot,
            true
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
                            shardState,
        }
        for (int i = 0; i < numberOfIndices; i++) {
 * GitHub history for details.
    }
                    assert (curr_entry.remoteStoreIndexShallowCopy() == true);
                assert in.available() != 0;
        return new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
        }
    @Override
import java.util.List;
 * software distributed under the License is distributed on an
    }
 * not use this file except in compliance with the License.
            entries.add(randomSnapshot());
        List<Entry> entries = new ArrayList<>(((SnapshotsInProgress) instance).entries());
                        : new SnapshotsInProgress.ShardSnapshotStatus(
            }
import org.opensearch.core.index.shard.ShardId;
                ShardId shardId = new ShardId(idx, j);
    @Override
                for (Entry curr_entry : actualSnapshotsInProgress.entries()) {
    protected Custom createTestInstance() {
        }
        SnapshotsInProgress.Entry entry = new SnapshotsInProgress.Entry(
            }
 * this file be licensed under the Apache-2.0 license or a
        }
/*
            includeGlobalState,
import org.opensearch.Version;
import org.opensearch.repositories.IndexId;
                }
        }
            randomBoolean(),
import org.opensearch.cluster.Diff;
    private String randomName(String prefix) {
            .collect(Collectors.toList());
            startTime,
                );
            Collections.emptyList(),
        return SnapshotsInProgress.of(entries);
 * Licensed to Elasticsearch under one or more contributor
        if (addEntry) {
    }
            snapshotsInProgress.writeTo(out);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            for (int j = 0; j < shardsCount; j++) {
 *
        } else {
            randomVersion(random()),
        newEntries.add(entry);
            null,
 * ownership. Elasticsearch licenses this file to you under
            snapshotsInProgress.writeTo(out2);
    @Override
            remoteStoreIndexShallowCopy
        SnapshotsInProgress snapshots = (SnapshotsInProgress) testInstance;
            }
    }
import java.util.ArrayList;
                String nodeId = randomAlphaOfLength(10);
            randomBoolean(),
                builder.put(
                actualSnapshotsInProgress = new SnapshotsInProgress(in);
    private Entry randomSnapshot() {
            try (StreamInput in = out2.bytes().streamInput()) {
 */
/*
            ? randomFrom(State.SUCCESS, State.FAILED)
        SnapshotsInProgress snapshotsInProgress = SnapshotsInProgress.of(newEntries);
            VersionUtils.randomVersion(random()),
        List<Entry> entries = new ArrayList<>();
            // modify some elements
        if (randomBoolean()) {
        List<Entry> entries = new ArrayList<>(snapshots.entries());
 * under the License.
    @Override
            repositoryStateId,
        Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shards = Collections.unmodifiableMap(builder);
            new Snapshot(randomName("repo"), new SnapshotId(randomName("snap"), UUIDs.randomBase64UUID())),
import org.opensearch.cluster.ClusterState.Custom;
            int shardsCount = randomIntBetween(1, 10);
                actualSnapshotsInProgress = new SnapshotsInProgress(in);
            // remove some elements
            SnapshotInfoTests.randomUserMetadata(),
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
                }
            partial,
import org.opensearch.cluster.SnapshotsInProgress.ShardState;
 */
        return SnapshotsInProgress.of(entries);
        Snapshot snapshot = new Snapshot(randomAlphaOfLength(10), new SnapshotId(randomAlphaOfLength(10), randomAlphaOfLength(10)));
                    final Entry entry = entries.get(i);
        SnapshotsInProgress actualSnapshotsInProgress;
            try (StreamInput in = out.bytes().streamInput()) {
            null,
        boolean includeGlobalState = randomBoolean();
    public void testSerDeRemoteStoreIndexShallowCopy() throws IOException {
}
                            "1"
    protected Custom mutateInstance(Custom instance) {
            for (int i = 0; i < addElements; i++) {
        int numberOfIndices = randomIntBetween(0, 10);
        int numberOfSnapshots = randomInt(10);
            entries.remove(randomIntBetween(0, entries.size() - 1));
        final List<Index> esIndices = indices.stream()
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.SnapshotsInProgress;
 * compatible open source license.
            try (StreamInput in = out.bytes().streamInput()) {
        long repositoryStateId = randomLong();
                    entries.set(i, entry.fail(entry.shards(), randomState(entry.shards()), entry.failure()));
import java.util.HashMap;
import org.opensearch.core.common.io.stream.Writeable;
import static org.opensearch.test.VersionUtils.randomVersion;
                if (randomBoolean()) {
                    assert (curr_entry.remoteStoreIndexShallowCopy() == false);
import org.opensearch.core.common.io.stream.StreamInput;
            SnapshotInfoTests.randomUserMetadata(),
public class SnapshotsInProgressSerializationTests extends AbstractDiffableWireSerializationTestCase<Custom> {
            entries.add(randomSnapshot());
                    assert (curr_entry.remoteStoreIndexShallowCopy() == false);
        }
    }
            indices,
 * license agreements. See the NOTICE file distributed with
        if (randomBoolean() && entries.size() > 1) {
                in.setVersion(Version.V_2_9_0);
            Collections.emptyList(),
 */
 * Modifications Copyright OpenSearch Contributors. See
            }
import org.opensearch.test.VersionUtils;
        return SnapshotsInProgress::new;
            snapshotsInProgress.writeTo(out);
        return prefix + UUIDs.randomBase64UUID(random());
        if (randomBoolean()) {
import org.opensearch.common.io.stream.BytesStreamOutput;
        boolean addEntry = entries.isEmpty() ? true : randomBoolean();
    public static State randomState(final Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shards) {
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
            SnapshotsInProgressSerializationTests.randomState(Map.of()),
package org.opensearch.snapshots;
    protected Writeable.Reader<Custom> instanceReader() {
 *
            BytesStreamOutput out2 = new BytesStreamOutput();
            out2.setVersion(Version.V_2_9_0);
import org.opensearch.common.UUIDs;
                in.setVersion(Version.V_2_7_0);
            indices.add(new IndexId(randomAlphaOfLength(10), randomAlphaOfLength(10)));
                in.setVersion(Version.V_2_7_0);
                actualSnapshotsInProgress = new SnapshotsInProgress(in);
/*
                        ? SnapshotsInProgress.ShardSnapshotStatus.UNASSIGNED_QUEUED
            : randomFrom(State.STARTED, State.INIT, State.ABORTED);
        List<String> dataStreams = Arrays.asList(generateRandomStringArray(10, 10, false));
    @Override
    }
import java.util.Map;
 * this work for additional information regarding copyright
        );
            int leaveElements = randomIntBetween(0, entries.size() - 1);
import org.opensearch.core.index.Index;
    protected Writeable.Reader<Diff<Custom>> diffReader() {
            randomIntBetween(0, 1000),
        long startTime = randomLong();
    }
import org.opensearch.test.AbstractDiffableWireSerializationTestCase;
                for (Entry curr_entry : actualSnapshotsInProgress.entries()) {
        List<IndexId> indices = new ArrayList<>();
            // add some elements
        }
import java.io.IOException;
 * You may obtain a copy of the License at
            Map.of(),
import java.util.Arrays;
                ShardState shardState = randomFrom(ShardState.values());
    }
                    shardState == ShardState.QUEUED
 * the Apache License, Version 2.0 (the "License"); you may
        }
                assert in.available() == 0;
        boolean partial = randomBoolean();
            shards,
        for (int i = 0; i < numberOfSnapshots; i++) {
        }
        for (Index idx : esIndices) {
            Math.abs(randomLong()),
        return SnapshotsInProgress.of(entries);
            int addElements = randomInt(10);
        return SnapshotsInProgress::readDiffFrom;
            entries = randomSubsetOf(leaveElements, entries.toArray(new Entry[leaveElements]));
 *
    protected Custom makeTestChanges(Custom testInstance) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.SnapshotsInProgress.State;
import java.util.stream.Collectors;
        boolean remoteStoreIndexShallowCopy = randomBoolean();
import java.util.Collections;
                entries.add(randomSnapshot());
                assert in.available() == 0;
            dataStreams,
        );
    }
        return new Entry(
            }
        final List<SnapshotsInProgress.Entry> newEntries = new ArrayList<>();
 * Unless required by applicable law or agreed to in writing,
                            shardState.failed() ? randomAlphaOfLength(10) : null,
                }
            for (int i = 0; i < entries.size(); i++) {
            randomState(shards),
        return SnapshotsInProgress.completed(shards.values())
            out.setVersion(Version.V_2_7_0);
                }
                    shardId,
import org.opensearch.cluster.SnapshotsInProgress.Entry;
            .map(i -> new Index(i.getName(), randomAlphaOfLength(10)))
import org.opensearch.cluster.ClusterModule;
        Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> builder = new HashMap<>();
                            nodeId,
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
        try (BytesStreamOutput out = new BytesStreamOutput()) {
