        List<SnapshotId> snapshotIds = new ArrayList<>(repositoryData.getSnapshotIds());
            final Map<IndexId, String> indexLookup = someIndices.stream()
        Map<String, SnapshotId> snapshotIds = new HashMap<>();
            IndexMetaDataGenerations.EMPTY
            indices.add(new IndexId(randomAlphaOfLength(8), UUIDs.randomBase64UUID(), pathType));
    public void testXContent() throws IOException {
        final Map<String, SnapshotId> snapshotIds = new HashMap<>(numSnapshots);
            assertEquals(repositoryData, fromXContent);
import static org.opensearch.repositories.RepositoryData.EMPTY_REPO_GEN;
        }
            snapshotIds,
        List<IndexId> indices = new ArrayList<>();
            randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()),
    }
        assertEquals(repositoryData, parsedRepositoryData);
            Collections.emptyMap(),
                    final String uuid = randomBoolean() ? null : UUIDs.randomBase64UUID(random());
        assertThat(indexNames.size(), greaterThan(0));
            Collections.emptyMap()
            );
            newSnapshot,
        assertNotNull(corruptedIndexId);
            .collect(Collectors.toMap(Function.identity(), ind -> randomAlphaOfLength(256)));
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
import org.opensearch.common.UUIDs;
import org.opensearch.core.xcontent.XContentParser;
import static org.hamcrest.Matchers.equalTo;
        List<String> indicesToResolve = Arrays.asList("index1", "index2", "index3");
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_PREFIX;
import org.opensearch.core.xcontent.XContent;
        return repositoryData;
    public void testIndexThatReferencesAnUnknownSnapshot() throws IOException {
            newIdentifiers.put(identifier, UUIDs.randomBase64UUID(random()));
        Set<IndexId> newIndices = new HashSet<>();
        assertThat(snapshotIds.size(), greaterThan(0));
        for (int i = 0; i < numNew; i++) {
            snapshotStates.put(snapshotId.getUUID(), randomFrom(SnapshotState.values()));
        RepositoryData repositoryData1 = generateRandomRepoData(FIXED.getCode());
import org.opensearch.Version;
        );
        }).toArray(IndexId[]::new);
        final int numIndices = randomIntBetween(1, 30);
            long gen = (long) randomIntBetween(0, 500);
        List<IndexId> resolvedIndices = RepositoryData.EMPTY.resolveNewIndices(indicesToResolve, inFlightIds, pathType);
        );
/*
            final String identifier = randomAlphaOfLength(20);
        RepositoryData newRepoData = repositoryData.addSnapshot(
                final int shardCount = randomIntBetween(1, 10);
            shardGenBuilder.build(),
        // test that initializing indices works
        final Collection<IndexId> indicesInOther = repositoryData.getIndices()
 */
            repositoryData.indicesToUpdateAfterRemovingSnapshot(Collections.singleton(randomSnapshot)),
            OpenSearchParseException e = expectThrows(
            } else if (newIndexNames.contains(indexId.getName())) {
    public void testIndexThatReferenceANullSnapshot() throws IOException {
            }
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.FIXED;
            indices.add(indexId);
        RepositoryData repositoryData = generateRandomRepoData();
        List<String> existingIndexNames = new ArrayList<>(existingIndices.keySet());
                }
            indices.put(indexId, Collections.unmodifiableList(new ArrayList<>(indexSnapshots)));
        );
                assertEquals(existingIndices.get(indexId.getName()), indexId);
            snapshotId,
        );
            indexSnapshots,
            final List<SnapshotId> snapshotIds = repositoryData.getSnapshots(index);
            snapshotStates.put(snapshotId.getUUID(), parsedRepositoryData.getSnapshotState(snapshotId));
    }
import static org.hamcrest.Matchers.greaterThan;
            randomFrom(SnapshotState.SUCCESS, SnapshotState.PARTIAL, SnapshotState.FAILED),
        IndexId indexId = indices.get(indexName);
import org.opensearch.core.xcontent.XContentBuilder;
 * software distributed under the License is distributed on an
        indicesToResolve.addAll(newIndexNames);
        List<String> newIndexNames = Arrays.asList("newIndex1", "newIndex2");
        final SnapshotId newSnapshot = new SnapshotId(randomAlphaOfLength(7), UUIDs.randomBase64UUID(random()));
        assertEquals(indexId, repositoryData.resolveIndexId(indexName));
        int pathType = randomIntBetween(0, 2);
        List<String> newIndexNames = Arrays.asList("newIndex1", "newIndex2");
        Map<String, IndexId> inFlightIds = Collections.emptyMap();
            Collections.emptyMap(),
            }
        for (IndexId indexId : randomSubsetOf(repositoryData.getIndices().values())) {
 * GitHub history for details.
            List<SnapshotId> snapshotsIds = new ArrayList<>(parsedRepositoryData.getSnapshots(indexId));
        // test that adding a snapshot and its indices works
        RepositoryData corruptedRepositoryData = new RepositoryData(
            assertEquals(gen, fromXContent.getGenId());
 * this file be licensed under the Apache-2.0 license or a
        final RepositoryData repositoryData = generateRandomRepoData();
        for (int i = 0; i < numSnapshots; i++) {
    }
                        if (randomBoolean()) {
        Map<String, IndexId> indexIdMap = repositoryData.getIndices();
            IndexMetaDataGenerations.EMPTY
        assertEquals(repositoryData1, repositoryData2);
            builder.startArray("snapshots");
            parsedRepositoryData.getGenId(),
            final SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID());
            );
            newIndices.entrySet()
    public void testRemoveSnapshot() {
}
            if (existingIndexNames.contains(indexId.getName())) {
import static org.hamcrest.Matchers.containsInAnyOrder;
import java.util.Arrays;
        XContentBuilder builder = XContentBuilder.builder(xContent);
            } else {
    }
                .collect(Collectors.toMap(Map.Entry::getKey, e -> Collections.singleton(newIdentifiers.get(e.getValue()))))
            IndexId indexId = new IndexId(randomAlphaOfLength(7), UUIDs.randomBase64UUID());
 *    http://www.apache.org/licenses/LICENSE-2.0
        RepositoryData repositoryData = generateRandomRepoData();
        List<String> indicesToResolve = new ArrayList<>(existingIndexNames);
        final ShardGenerations.Builder builder = ShardGenerations.builder();
        }
                        builder.startObject();
        final int totalSnapshots = snapshotIds.size();
    public void testIndexMetaDataToRemoveAfterRemovingSnapshotWithSharing() {
            parsedRepositoryData = RepositoryData.snapshotsFromXContent(xParser, repositoryData.getGenId());
            assertTrue(snapshotIds.contains(newSnapshot));
            builder.endArray();
            );
                randomFrom(SnapshotState.values()),
        RepositoryData repositoryData2 = repositoryData1.copy();
                builder.endObject();
            IndexId indexId = snapshottedIndex.getValue();
 */
                randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()),
 * You may obtain a copy of the License at
            OpenSearchParseException e = expectThrows(
 * SPDX-License-Identifier: Apache-2.0
        List<String> existingIndexNames = new ArrayList<>(existingIndices.keySet());
            ShardGenerations.EMPTY,
        for (Map.Entry<String, IndexId> snapshottedIndex : parsedRepositoryData.getIndices().entrySet()) {
            .collect(
                    {
            snapshotIds,
        final Map<IndexId, String> indexLookup = shardGenerations.indices()
import org.opensearch.common.xcontent.json.JsonXContent;
            if (indicesInOther.contains(indexId)) {
 * Licensed to Elasticsearch under one or more contributor
                assertTrue(newIndexNames.contains(indexId.getName()));
import java.util.LinkedHashSet;
            .stream()
        for (IndexId indexId : resolvedIndices) {
            state,
import java.util.ArrayList;
 * The OpenSearch Contributors require contributions made to
        List<IndexId> resolvedIndices = repositoryData.resolveNewIndices(indicesToResolve, Collections.emptyMap(), newPathType);
            final ShardGenerations.Builder builder = ShardGenerations.builder();
        final ShardGenerations shardGenerations = builder.build();
        final int numSnapshots = randomIntBetween(1, 30);
            .stream()
                indexLookup,
        RepositoryData repositoryData = generateRandomRepoData(existingPathType);
    public void testResolveNewIndices() {
    }
        resolvedIndices = repositoryData.resolveNewIndices(indicesToResolve, inFlightIndexIds, pathType);
            builder.put(indexId, 0, UUIDs.randomBase64UUID(random()));
            repositoryData = repositoryData.addSnapshot(
        final SnapshotId snapshotId = randomFrom(repositoryData.getSnapshotIds());
        final XContentBuilder corruptedBuilder = XContentBuilder.builder(xContent);
        List<SnapshotId> expected = new ArrayList<>(repositoryData.getSnapshotIds());
                assertTrue(newIndexNames.contains(indexId.getName()));
            builder.endObject();
        for (IndexId indexId : indicesInOther) {
        RepositoryData repositoryData = generateRandomRepoData();
                    builder.endArray();
        return indices;
        indexLookup.putAll(newIndices);
 * not use this file except in compliance with the License.
        int numNew = randomIntBetween(1, 10);
                assertEquals(existingIndices.get(indexId.getName()), indexId);
        // make sure the repository data's indices no longer contain the removed snapshot
            containsInAnyOrder(indicesToUpdate)
        for (final IndexId indexId : newRepositoryData.getIndices().values()) {
        }
                assertEquals(snapshotIds.size(), 1); // if it was a new index, only the new snapshot should be in its set
                shardGenBuilder.put(indexId, i, UUIDs.randomBase64UUID(random()));
            snapshotVersions,
    }
                snapshotsIds.add(new SnapshotId("_uuid", "_does_not_exist"));
import java.util.List;
        }
        }
            newIndices.put(indexId, identifier);
                for (int j = 0; j < shardCount; ++j) {
    // Test removing snapshot from random data where no two snapshots share any index metadata blobs
import org.opensearch.snapshots.SnapshotId;
        Map<String, SnapshotState> snapshotStates = new HashMap<>();
            assertEquals(pathType, indexId.getShardPathType());
                () -> RepositoryData.snapshotsFromXContent(xParser, randomNonNegativeLong())
        RepositoryData newRepoData = new RepositoryData(
            snapshotIds.put(snapshotId.getUUID(), snapshotId);
            snapshotIds.put(snapshotId.getUUID(), snapshotId);
        indicesToResolve = new ArrayList<>(existingIndexNames);
            Collections.emptyMap(),
            EMPTY_REPO_GEN,
        final Collection<IndexId> indicesToUpdate = repositoryData.indicesToUpdateAfterRemovingSnapshot(Collections.singleton(snapshotId));
public class RepositoryDataTests extends OpenSearchTestCase {
            final IndexId indexId = new IndexId(randomAlphaOfLength(8), UUIDs.randomBase64UUID());
        }
                }
            repositoryData.getGenId(),
                indexSnapshots.add(snapshotIds.get(randomIntBetween(0, totalSnapshots - 1)));
    }
            {
    public void testIndicesToUpdateAfterRemovingSnapshot() {
        }
        corruptedRepositoryData.snapshotsToXContent(corruptedBuilder, Version.CURRENT);
    public void testResolveNewIndicesWithDifferentPathType() {
                .stream()
import java.util.HashMap;
        SnapshotId newSnapshot = new SnapshotId(randomAlphaOfLength(7), UUIDs.randomBase64UUID());
        for (int i = 0; i < numIndices; i++) {
        builder.startObject();
        assertEquals(repositoryData1.hashCode(), repositoryData2.hashCode());
        final IndexId[] indicesToUpdate = indicesBefore.stream().filter(index -> {
        // Use a different path type for new indices
 *
            final Set<SnapshotId> indexSnapshots = new LinkedHashSet<>();
            );
                    builder.put(someIndex, j, uuid);
    public void testGetSnapshotState() {
            assertThat(
            indexLookup.values().stream().collect(Collectors.toMap(Function.identity(), ignored -> UUIDs.randomBase64UUID(random())))
        }
    }
                removeFromOther.put(
        List<String> indexNames = new ArrayList<>(indexIdMap.keySet());
            );
        // verify that the new repository data has the new snapshot and its indices
        RepositoryData newRepositoryData = repositoryData.removeSnapshots(Collections.singleton(removedSnapshotId), ShardGenerations.EMPTY);
            .collect(Collectors.toSet());
        Map<String, IndexId> inFlightIndexIds = new HashMap<>();
        assertThat(
        for (int i = 0; i < numOld; i++) {
            builder.put(indexId, 0, UUIDs.randomBase64UUID(random()));
        {
        // Generate repository data with a fixed path type
        }
            );
        Map<String, IndexId> existingIndices = repositoryData.getIndices();
        final Map<String, String> newIdentifiers = new HashMap<>();
            snapshotIds,
            SnapshotState.SUCCESS,
        int existingPathType = PathType.FIXED.getCode();
        }
                        }
            assertNotNull(indexId.getId());
        final XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
        }
                OpenSearchParseException.class,
import java.util.Set;
        indicesToResolve.addAll(newIndexNames);
        final List<SnapshotId> snapshotIds = new ArrayList<>(snapshotIdsMap.values());
                        + " references an unknown "
            final int numIndicesForSnapshot = randomIntBetween(1, numIndices);
            for (int i = 0; i < shardCount; ++i) {
                    builder.startArray("snapshots");
        final Map<IndexId, List<SnapshotId>> indices = new HashMap<>(numIndices);
        }
        );
import java.io.IOException;
            newIndices.add(indexId);
        // test that adding the same snapshot id to the repository data throws an exception
            List<SnapshotId> snapshotIds = newRepoData.getSnapshots(indexId);
            if (existingIndexNames.contains(indexId.getName())) {
 * Unless required by applicable law or agreed to in writing,
        final SnapshotState state = randomFrom(SnapshotState.values());
    }
import org.opensearch.snapshots.SnapshotState;
        try (XContentParser xParser = createParser(corruptedBuilder)) {
            } else {
            shardGenerations,
                assertNotNull(indexId.getId());
            if (newIndices.contains(indexId)) {
                assertEquals(pathType, indexId.getShardPathType());
                Collectors.toMap(Map.Entry::getKey, e -> Collections.singleton(indexMetaDataGenerations.getIndexMetaBlobId(e.getValue())))
        }
        for (SnapshotId snapshotId : parsedRepositoryData.getSnapshotIds()) {
        assertEquals(
 * ownership. Elasticsearch licenses this file to you under
        final SnapshotId randomSnapshot = randomFrom(repositoryData.getSnapshotIds());
            final int shardCount = randomIntBetween(1, 10);
/*
import java.util.stream.Collectors;
    }
            randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()),
            indexSnapshots.put(indexId, snapshotsIds);
        }
        repositoryData.snapshotsToXContent(builder, Version.CURRENT);
    }
        assertEquals(indicesToResolve.size(), resolvedIndices.size());
        final Map<IndexId, String> newIndices = new HashMap<>();
        for (IndexId indexId : resolvedIndices) {
                    "Detected a corrupted repository, index "
        }
            for (IndexId someIndex : someIndices) {
        final SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID());
        }
    }
import java.util.HashSet;
        for (int i = 0; i < numIndices; i++) {
            assertFalse(newRepositoryData.getSnapshots(indexId).contains(removedSnapshotId));
import java.util.Collections;
    private static Map<IndexId, List<SnapshotId>> randomIndices(final Map<String, SnapshotId> snapshotIdsMap) {
    public void testResolveIndexId() {
            Version.CURRENT,
        }
        // Test case 1: All indices are new
        final List<IndexId> indicesBefore = new ArrayList<>(repositoryData.getIndices().values());
        final RepositoryData repositoryData = generateRandomRepoData();
            assertTrue(indicesToResolve.contains(indexId.getName()));
            return snapshotIds.contains(randomSnapshot) && snapshotIds.size() > 1;
        final RepositoryData repositoryData = generateRandomRepoData();
    // Test removing snapshot from random data that has some or all index metadata shared
        for (String indexName : newIndexNames) {
                );
                assertEquals(inFlightIndexIds.get(indexId.getName()), indexId);
 * license agreements. See the NOTICE file distributed with
                assertNotNull(indexId.getId());
                    builder.field("id", "_id");
        final ShardGenerations shardGenerations = builder.build();
                            builder.field("name", "_name");
        Map<String, IndexId> existingIndices = repositoryData.getIndices();
        RepositoryData repositoryData = generateRandomRepoData();
package org.opensearch.repositories;
            newRepoData.indexMetaDataToRemoveAfterRemovingSnapshots(Collections.singleton(newSnapshot)),
        pathType = randomIntBetween(0, 2);
                        + corruptedIndexId
        }
            } else {
            }
            newIdentifiers
 * Tests for the {@link RepositoryData} class.
        try (XContentParser xParser = createParser(builder)) {
            if (existingIndexNames.contains(indexId.getName())) {
            for (int j = 0; j < numIndicesForSnapshot; j++) {
    public void testEqualsAndHashCode() {
        assertNull(repositoryData.getSnapshotState(new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID())));
            assertThat(
            }
        final Map<IndexId, String> indexLookup = new HashMap<>(repositoryData.indexMetaDataGenerations().lookup.get(otherSnapshotId));
            .entrySet()
        for (IndexId indexId : resolvedIndices) {
        SnapshotId removedSnapshotId = snapshotIds.remove(randomIntBetween(0, snapshotIds.size() - 1));
            if (corruptedIndexId.equals(indexId)) {
                equalTo(
            }
        try (XContentParser xParser = createParser(builder)) {
 * compatible open source license.
                snapshotId,
            }
        List<SnapshotId> actual = new ArrayList<>(newRepoData.getSnapshotIds());
        // Test case 2: Some indices are existing, some are new
        final Map<String, Version> snapshotVersions = new HashMap<>(numSnapshots);
        final XContent xContent = randomFrom(XContentType.values()).xContent();
            snapshotVersions.put(snapshotId.getUUID(), parsedRepositoryData.getVersion(snapshotId));
        }
        builder.endObject();
        int numOld = randomIntBetween(1, indexIdMap.size());
            IndexMetaDataGenerations.EMPTY
 */
            builder.put(indexId, 0, UUIDs.randomBase64UUID(random()));
    public static RepositoryData generateRandomRepoData() {
import java.util.function.Function;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testAddSnapshots() {
        Map<String, Version> snapshotVersions = new HashMap<>();
        assertEquals(state, repositoryData.getSnapshotState(snapshotId));
        RepositoryData repositoryData = generateRandomRepoData();
            newSnapshot,
 * under the License.
        // Test case 3: Some indices are in-flight
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.OpenSearchParseException;
        final Map<String, SnapshotState> snapshotStates = new HashMap<>(numSnapshots);
        final IndexMetaDataGenerations indexMetaDataGenerations = repositoryData.indexMetaDataGenerations();
                assertEquals(existingPathType, indexId.getShardPathType());
        // Create a list of existing and new index names
        assertTrue(newRepoData.getSnapshotIds().contains(newSnapshot));
            builder.value(new SnapshotId("_name", "_uuid"));
            builder.put(indexId, 0, UUIDs.randomBase64UUID(random()));
        Map<IndexId, List<SnapshotId>> indices = randomIndices(snapshotIds);
            }
            indexLookup,
            ShardGenerations.EMPTY,
 * KIND, either express or implied.  See the License for the
 */
                () -> RepositoryData.snapshotsFromXContent(xParser, corruptedRepositoryData.getGenId())
        }
        assertEquals(indicesToResolve.size(), resolvedIndices.size());
/*
        );
        Collections.sort(actual);
        final ShardGenerations.Builder shardGenBuilder = ShardGenerations.builder();
            }
        }
                builder.build(),
            assertEquals(indices.get(indexId), newRepoData.getSnapshots(indexId));
            final List<IndexId> someIndices = indices.subList(0, randomIntBetween(1, numIndices));
            snapshotStates,
                    indexId,
        }
            }
                equalTo("Detected a corrupted repository, " + "index [docs/_id/0] references an unknown snapshot uuid [null]")
        RepositoryData parsedRepositoryData;
                    Collections.singleton(repositoryData.indexMetaDataGenerations().indexMetaBlobId(otherSnapshotId, indexId))
        final IndexId corruptedIndexId = randomFrom(parsedRepositoryData.getIndices().values());
        final RepositoryData repositoryData = generateRandomRepoData();
        assertEquals(repositoryData.getGenId(), newRepoData.getGenId());
    }
        assertEquals(expected, actual);
                {
        Map<IndexId, List<SnapshotId>> indexSnapshots = new HashMap<>();
                e.getMessage(),
    public void testInitIndices() {
        final RepositoryData repositoryData = RepositoryData.EMPTY.addSnapshot(
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals(indicesToResolve.size(), resolvedIndices.size());
import java.util.Collection;
        for (IndexId indexId : indices.keySet()) {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
            .stream()
            RepositoryData fromXContent = RepositoryData.snapshotsFromXContent(parser, gen);
        Collections.sort(expected);
            ShardGenerations.EMPTY,
            }
import org.opensearch.common.xcontent.XContentType;
        assertEquals(repositoryData.indexMetaDataToRemoveAfterRemovingSnapshots(Collections.singleton(snapshotId)), identifiersToRemove);
        return generateRandomRepoData(randomFrom(PathType.values()).getCode());
        final List<IndexId> indices = new ArrayList<>(numIndices);
                builder.startObject("docs");
 *
        for (IndexId indexId : indices) {
        XContentBuilder builder = JsonXContent.contentBuilder();
        Set<String> indexNames = indices.keySet();
/**
            .filter(e -> indicesToUpdate.contains(e.getKey()))
 * this work for additional information regarding copyright
        resolvedIndices = repositoryData.resolveNewIndices(indicesToResolve, Collections.emptyMap(), pathType);
        );
        final Map<IndexId, Collection<String>> identifiersToRemove = indexMetaDataGenerations.lookup.get(snapshotId)
        repositoryData.snapshotsToXContent(builder, Version.CURRENT);
        RepositoryData repositoryData = RepositoryData.EMPTY;
 * Modifications Copyright OpenSearch Contributors. See
                        + "snapshot uuid [_does_not_exist]"
    public static RepositoryData generateRandomRepoData(int pathType) {
            .values()
                    }
            Collections.emptyMap(),
        );
    }
            .filter(index -> repositoryData.getSnapshots(index).contains(otherSnapshotId))
import java.util.Map;
            indexLookup,
                indexLookup.values().stream().collect(Collectors.toMap(Function.identity(), ignored -> UUIDs.randomBase64UUID(random())))
        RepositoryData repositoryData = new RepositoryData(
        final SnapshotId otherSnapshotId = randomFrom(repositoryData.getSnapshotIds());
 *
        final Map<IndexId, Collection<String>> removeFromOther = new HashMap<>();
import org.opensearch.test.OpenSearchTestCase;
                        builder.endObject();
        int newPathType = HASHED_PREFIX.getCode();
        assertEquals(newRepoData.indexMetaDataToRemoveAfterRemovingSnapshots(Collections.singleton(otherSnapshotId)), removeFromOther);
import org.opensearch.core.common.bytes.BytesReference;
            shardGenerations,
            final SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID());
    }
            inFlightIndexIds.put(indexName, new IndexId(indexName, UUIDs.randomBase64UUID(), pathType));
            snapshotVersions,
        String indexName = indexNames.iterator().next();
        final ShardGenerations.Builder builder = ShardGenerations.builder();
            indices,
                assertEquals(newPathType, indexId.getShardPathType());
        Map<String, IndexId> indices = repositoryData.getIndices();
        }
                fail("Unexpected index: " + indexId.getName());
            snapshotVersions.put(snapshotId.getUUID(), randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()));
            builder.startObject("indices");
            snapshotStates,
                e.getMessage(),
        RepositoryData newRepoData = repositoryData.addSnapshot(
        assertEquals(indicesToResolve.size(), resolvedIndices.size());
                )
    public void testIndexMetaDataToRemoveAfterRemovingSnapshotNoSharing() {
    }
        final int numIndices = randomIntBetween(1, 30);
 * specific language governing permissions and limitations
                .collect(Collectors.toMap(Function.identity(), ind -> randomAlphaOfLength(256)));
        for (int i = 0; i < numSnapshots; i++) {
        final int numSnapshots = randomIntBetween(1, 30);
        for (IndexId indexId : resolvedIndices) {
                OpenSearchParseException.class,
            indices.add(indexId);
            final IndexId indexId = indexIdMap.get(indexNames.get(i));
    }
                assertEquals(existingIndices.get(indexId.getName()), indexId);
