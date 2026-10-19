 * software distributed under the License is distributed on an
            builder.startObject("indices");
            repositoryData.indicesToUpdateAfterRemovingSnapshot(Collections.singleton(randomSnapshot)),
        List<IndexId> resolvedIndices = repositoryData.resolveNewIndices(indicesToResolve, Collections.emptyMap(), newPathType);
        final RepositoryData repositoryData = generateRandomRepoData();
            );
            snapshotVersions.put(snapshotId.getUUID(), parsedRepositoryData.getVersion(snapshotId));
            indexSnapshots,
        final SnapshotId otherSnapshotId = randomFrom(repositoryData.getSnapshotIds());  
        final Map<IndexId, String> indexLookup = shardGenerations.indices()  
    public void testResolveNewIndicesWithDifferentPathType() {
                randomFrom(SnapshotState.values()),  
        final XContent xContent = randomFrom(XContentType.values()).xContent();  
        }
    private static Map<IndexId, List<SnapshotId>> randomIndices(final Map<String, SnapshotId> snapshotIdsMap) {
            newSnapshot,  
            newRepoData.indexMetaDataToRemoveAfterRemovingSnapshots(Collections.singleton(newSnapshot)),
        int numNew = randomIntBetween(1, 10);
import java.util.function.Function;  
    }
                assertTrue(newIndexNames.contains(indexId.getName()));
            indices,
            Collections.emptyMap(),
            .stream()  
                snapshotId,
    }
    public static RepositoryData generateRandomRepoData() {  
            }
            snapshotStates.put(snapshotId.getUUID(), parsedRepositoryData.getSnapshotState(snapshotId));
                    builder.startArray("snapshots");  
            .collect(
        XContentBuilder builder = JsonXContent.contentBuilder();
            snapshotVersions,  
                .collect(Collectors.toMap(Map.Entry::getKey, e -> Collections.singleton(newIdentifiers.get(e.getValue()))))
        RepositoryData newRepoData = new RepositoryData(  
import java.util.Collections;
                assertEquals(pathType, indexId.getShardPathType());  
                builder.build(),
        final int totalSnapshots = snapshotIds.size();  
    }
            snapshotIds,
            shardGenerations,
            );
            for (IndexId someIndex : someIndices) {
 * the Apache License, Version 2.0 (the "License"); you may
            IndexMetaDataGenerations.EMPTY  
        RepositoryData repositoryData = generateRandomRepoData();
 * compatible open source license.
import org.opensearch.snapshots.SnapshotState;
        RepositoryData repositoryData = RepositoryData.EMPTY;
                }  
        List<SnapshotId> actual = new ArrayList<>(newRepoData.getSnapshotIds());
    }
            final String identifier = randomAlphaOfLength(20);
            }
        List<String> existingIndexNames = new ArrayList<>(existingIndices.keySet());
        }
                    "Detected a corrupted repository, index "
            indexLookup.values().stream().collect(Collectors.toMap(Function.identity(), ignored -> UUIDs.randomBase64UUID(random())))  
                        builder.startObject();
                .stream()
        try (XContentParser xParser = createParser(builder)) {  
        List<IndexId> resolvedIndices = RepositoryData.EMPTY.resolveNewIndices(indicesToResolve, inFlightIds, pathType);  
    }
                e.getMessage(),
        for (int i = 0; i < numIndices; i++) {
        RepositoryData repositoryData = generateRandomRepoData();  
        final List<IndexId> indices = new ArrayList<>(numIndices);  
 */  
/*  
            .collect(Collectors.toMap(Function.identity(), ind -> randomAlphaOfLength(256)));
            Collections.emptyMap(),
        int pathType = randomIntBetween(0, 2);
        );  
                assertEquals(inFlightIndexIds.get(indexId.getName()), indexId);  
        int newPathType = HASHED_PREFIX.getCode();
        final ShardGenerations shardGenerations = builder.build();
 *
    }
            builder.endObject();  
    // Test removing snapshot from random data that has some or all index metadata shared
        final IndexId[] indicesToUpdate = indicesBefore.stream().filter(index -> {
import java.util.LinkedHashSet;
        RepositoryData repositoryData = generateRandomRepoData();
 * specific language governing permissions and limitations
            }
        }
        Map<String, IndexId> inFlightIndexIds = new HashMap<>();
        assertNotNull(corruptedIndexId);  
        builder.startObject();
            List<SnapshotId> snapshotIds = newRepoData.getSnapshots(indexId);
        assertEquals(indicesToResolve.size(), resolvedIndices.size());
                equalTo(
            snapshotId,  
        final RepositoryData repositoryData = RepositoryData.EMPTY.addSnapshot(
            assertNotNull(indexId.getId());
            indices.add(new IndexId(randomAlphaOfLength(8), UUIDs.randomBase64UUID(), pathType));
            final ShardGenerations.Builder builder = ShardGenerations.builder();  
import static org.hamcrest.Matchers.containsInAnyOrder;  
        final Map<String, SnapshotId> snapshotIds = new HashMap<>(numSnapshots);
        for (final IndexId indexId : newRepositoryData.getIndices().values()) {
                assertNotNull(indexId.getId());  
        for (int i = 0; i < numOld; i++) {  
            if (indicesInOther.contains(indexId)) {
        for (IndexId indexId : randomSubsetOf(repositoryData.getIndices().values())) {  
        }  
            );
            randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()),
        RepositoryData repositoryData = generateRandomRepoData();
        }  
            builder.put(indexId, 0, UUIDs.randomBase64UUID(random()));
        }  
            Collections.emptyMap(),  
        for (int i = 0; i < numNew; i++) {
                    builder.put(someIndex, j, uuid);
        SnapshotId newSnapshot = new SnapshotId(randomAlphaOfLength(7), UUIDs.randomBase64UUID());
        return indices;  
 * Tests for the {@link RepositoryData} class.
        final Map<IndexId, List<SnapshotId>> indices = new HashMap<>(numIndices);
        for (int i = 0; i < numSnapshots; i++) {
 * not use this file except in compliance with the License.
        List<String> existingIndexNames = new ArrayList<>(existingIndices.keySet());
        assertEquals(indicesToResolve.size(), resolvedIndices.size());
public class RepositoryDataTests extends OpenSearchTestCase {
    }  
 * Unless required by applicable law or agreed to in writing,
        final int numIndices = randomIntBetween(1, 30);
package org.opensearch.repositories;
            }  
        final IndexMetaDataGenerations indexMetaDataGenerations = repositoryData.indexMetaDataGenerations();
                assertEquals(existingPathType, indexId.getShardPathType());  
 * under the License.  
        }  
        );  
                        + corruptedIndexId  
            IndexId indexId = snapshottedIndex.getValue();
            builder.put(indexId, 0, UUIDs.randomBase64UUID(random()));
        final Map<IndexId, Collection<String>> removeFromOther = new HashMap<>();
                    Collections.singleton(repositoryData.indexMetaDataGenerations().indexMetaBlobId(otherSnapshotId, indexId))
            final List<IndexId> someIndices = indices.subList(0, randomIntBetween(1, numIndices));
        assertEquals(repositoryData1.hashCode(), repositoryData2.hashCode());
        for (IndexId indexId : indices) {
        indicesToResolve.addAll(newIndexNames);
        assertEquals(repositoryData.indexMetaDataToRemoveAfterRemovingSnapshots(Collections.singleton(snapshotId)), identifiersToRemove);
                assertTrue(newIndexNames.contains(indexId.getName()));
        Set<String> indexNames = indices.keySet();
    }
            List<SnapshotId> snapshotsIds = new ArrayList<>(parsedRepositoryData.getSnapshots(indexId));
            SnapshotState.SUCCESS,
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.common.bytes.BytesReference;  
        List<SnapshotId> snapshotIds = new ArrayList<>(repositoryData.getSnapshotIds());  
            } else if (newIndexNames.contains(indexId.getName())) {
        final RepositoryData repositoryData = generateRandomRepoData();
        int numOld = randomIntBetween(1, indexIdMap.size());
    }  
        final Collection<IndexId> indicesToUpdate = repositoryData.indicesToUpdateAfterRemovingSnapshot(Collections.singleton(snapshotId));  
        builder.endObject();
    public void testIndexMetaDataToRemoveAfterRemovingSnapshotNoSharing() {
            .entrySet()
                builder.endObject();
            builder.endArray();
}
                randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()),
        List<String> newIndexNames = Arrays.asList("newIndex1", "newIndex2");  
                builder.startObject("docs");  
                indexLookup,  
            Version.CURRENT,
            indices.add(indexId);
        RepositoryData newRepoData = repositoryData.addSnapshot(  
        final Map<String, String> newIdentifiers = new HashMap<>();
            randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()),  
        repositoryData.snapshotsToXContent(builder, Version.CURRENT);  
                        + " references an unknown "
            snapshotStates,  
        final XContentBuilder corruptedBuilder = XContentBuilder.builder(xContent);  
        List<IndexId> indices = new ArrayList<>();  
        }
import java.io.IOException;
        // verify that the new repository data has the new snapshot and its indices
            final SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID());
        final Collection<IndexId> indicesInOther = repositoryData.getIndices()
        // test that adding the same snapshot id to the repository data throws an exception
        for (String indexName : newIndexNames) {  
        RepositoryData newRepoData = repositoryData.addSnapshot(
        Map<String, IndexId> existingIndices = repositoryData.getIndices();
import java.util.HashMap;  
        for (IndexId indexId : resolvedIndices) {  
    public void testIndexThatReferenceANullSnapshot() throws IOException {
/**
            if (existingIndexNames.contains(indexId.getName())) {  
                }  
        }
        for (IndexId indexId : indicesInOther) {  
            newIdentifiers.put(identifier, UUIDs.randomBase64UUID(random()));  
                assertEquals(newPathType, indexId.getShardPathType());
            .stream()
            assertTrue(indicesToResolve.contains(indexId.getName()));  
    public void testEqualsAndHashCode() {  
        RepositoryData newRepositoryData = repositoryData.removeSnapshots(Collections.singleton(removedSnapshotId), ShardGenerations.EMPTY);  
            }
            snapshotIds.put(snapshotId.getUUID(), snapshotId);  
            IndexMetaDataGenerations.EMPTY
            final Map<IndexId, String> indexLookup = someIndices.stream()
            IndexId indexId = new IndexId(randomAlphaOfLength(7), UUIDs.randomBase64UUID());
            assertEquals(gen, fromXContent.getGenId());
                    {
    // Test removing snapshot from random data where no two snapshots share any index metadata blobs
/*
                indexSnapshots.add(snapshotIds.get(randomIntBetween(0, totalSnapshots - 1)));
            assertEquals(repositoryData, fromXContent);
 * SPDX-License-Identifier: Apache-2.0
        RepositoryData parsedRepositoryData;
        assertTrue(newRepoData.getSnapshotIds().contains(newSnapshot));  
            }  
            indices.put(indexId, Collections.unmodifiableList(new ArrayList<>(indexSnapshots)));
        {
import static org.hamcrest.Matchers.greaterThan;
import static org.opensearch.repositories.RepositoryData.EMPTY_REPO_GEN;
    }  
import org.opensearch.common.xcontent.XContentType;
            indexLookup,
        Collections.sort(expected);
        for (IndexId indexId : resolvedIndices) {
                assertEquals(snapshotIds.size(), 1); // if it was a new index, only the new snapshot should be in its set
        assertEquals(indexId, repositoryData.resolveIndexId(indexName));
        }).toArray(IndexId[]::new);
        final int numSnapshots = randomIntBetween(1, 30);  
        Collections.sort(actual);  
 *  
            .values()
            snapshotVersions,
            assertThat(  
        final ShardGenerations.Builder builder = ShardGenerations.builder();  
        // Create a list of existing and new index names
        // test that adding a snapshot and its indices works
 * GitHub history for details.
            shardGenBuilder.build(),
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_PREFIX;
 * this work for additional information regarding copyright
        final Map<IndexId, String> newIndices = new HashMap<>();  
        }  
        List<String> indicesToResolve = Arrays.asList("index1", "index2", "index3");  
        indexLookup.putAll(newIndices);
        );  
        for (IndexId indexId : resolvedIndices) {
            OpenSearchParseException e = expectThrows(
        resolvedIndices = repositoryData.resolveNewIndices(indicesToResolve, inFlightIndexIds, pathType);  
            snapshotIds,
        assertThat(indexNames.size(), greaterThan(0));
        final SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID());  
                );
            assertEquals(indices.get(indexId), newRepoData.getSnapshots(indexId));  
            if (existingIndexNames.contains(indexId.getName())) {
            final SnapshotId snapshotId = new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID());
            }  
    public void testIndexThatReferencesAnUnknownSnapshot() throws IOException {
                .collect(Collectors.toMap(Function.identity(), ind -> randomAlphaOfLength(256)));  
        for (int i = 0; i < numIndices; i++) {  
        RepositoryData corruptedRepositoryData = new RepositoryData(
            final IndexId indexId = new IndexId(randomAlphaOfLength(8), UUIDs.randomBase64UUID());
        final SnapshotId randomSnapshot = randomFrom(repositoryData.getSnapshotIds());
            Collections.emptyMap(),
            ShardGenerations.EMPTY,
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
    public void testResolveIndexId() {
            ShardGenerations.EMPTY,  
import org.opensearch.core.xcontent.XContentBuilder;  
        Map<String, SnapshotId> snapshotIds = new HashMap<>();
        repositoryData.snapshotsToXContent(builder, Version.CURRENT);
            EMPTY_REPO_GEN,
import java.util.Set;
            state,
                        + "snapshot uuid [_does_not_exist]"
            parsedRepositoryData = RepositoryData.snapshotsFromXContent(xParser, repositoryData.getGenId());
        Map<IndexId, List<SnapshotId>> indices = randomIndices(snapshotIds);
        for (SnapshotId snapshotId : parsedRepositoryData.getSnapshotIds()) {
        );  
                        builder.endObject();  
                    builder.endArray();
                fail("Unexpected index: " + indexId.getName());
        try (XContentParser xParser = createParser(builder)) {
                removeFromOther.put(
        }
        }
        final Map<IndexId, Collection<String>> identifiersToRemove = indexMetaDataGenerations.lookup.get(snapshotId)
    public void testIndexMetaDataToRemoveAfterRemovingSnapshotWithSharing() {  
                shardGenBuilder.put(indexId, i, UUIDs.randomBase64UUID(random()));  
            if (existingIndexNames.contains(indexId.getName())) {
            long gen = (long) randomIntBetween(0, 500);
        return generateRandomRepoData(randomFrom(PathType.values()).getCode());
        final List<IndexId> indicesBefore = new ArrayList<>(repositoryData.getIndices().values());  
        }
        List<String> newIndexNames = Arrays.asList("newIndex1", "newIndex2");  
        final RepositoryData repositoryData = generateRandomRepoData();
import org.opensearch.OpenSearchParseException;
        Set<IndexId> newIndices = new HashSet<>();
/*  
        SnapshotId removedSnapshotId = snapshotIds.remove(randomIntBetween(0, snapshotIds.size() - 1));
        Map<String, IndexId> inFlightIds = Collections.emptyMap();
import java.util.stream.Collectors;
import java.util.List;  
        final Map<IndexId, String> indexLookup = new HashMap<>(repositoryData.indexMetaDataGenerations().lookup.get(otherSnapshotId));
            RepositoryData fromXContent = RepositoryData.snapshotsFromXContent(parser, gen);  
        assertThat(  
 *
 * Modifications Copyright OpenSearch Contributors. See
            snapshotStates,
            .stream()  
            builder.value(new SnapshotId("_name", "_uuid"));
            containsInAnyOrder(indicesToUpdate)
        assertEquals(expected, actual);
        RepositoryData repositoryData1 = generateRandomRepoData(FIXED.getCode());
            );
    public void testGetSnapshotState() {
        // make sure the repository data's indices no longer contain the removed snapshot
    }  
        );
        final Map<String, SnapshotState> snapshotStates = new HashMap<>(numSnapshots);
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.FIXED;  
        // Use a different path type for new indices
        }  
        final Map<String, Version> snapshotVersions = new HashMap<>(numSnapshots);  
        final int numIndices = randomIntBetween(1, 30);
        }
            final int numIndicesForSnapshot = randomIntBetween(1, numIndices);  
    }  
            builder.startArray("snapshots");  
        );  
import org.opensearch.Version;
            }
        final SnapshotId snapshotId = randomFrom(repositoryData.getSnapshotIds());
                assertEquals(existingIndices.get(indexId.getName()), indexId);
            for (int i = 0; i < shardCount; ++i) {
            if (corruptedIndexId.equals(indexId)) {  
        resolvedIndices = repositoryData.resolveNewIndices(indicesToResolve, Collections.emptyMap(), pathType);
        // test that initializing indices works
            builder.put(indexId, 0, UUIDs.randomBase64UUID(random()));
    public void testInitIndices() {
 * this file be licensed under the Apache-2.0 license or a
        );
import org.opensearch.core.xcontent.XContent;
        Map<String, Version> snapshotVersions = new HashMap<>();
        String indexName = indexNames.iterator().next();  
        final ShardGenerations shardGenerations = builder.build();  
 */  
                OpenSearchParseException.class,  
import java.util.ArrayList;
 * You may obtain a copy of the License at  
                    }
            } else {
                () -> RepositoryData.snapshotsFromXContent(xParser, corruptedRepositoryData.getGenId())  
        indicesToResolve.addAll(newIndexNames);
 * license agreements. See the NOTICE file distributed with
        // Test case 2: Some indices are existing, some are new
        }
        Map<String, IndexId> indices = repositoryData.getIndices();  
        final ShardGenerations.Builder shardGenBuilder = ShardGenerations.builder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testResolveNewIndices() {
        List<String> indexNames = new ArrayList<>(indexIdMap.keySet());
    }
        assertEquals(newRepoData.indexMetaDataToRemoveAfterRemovingSnapshots(Collections.singleton(otherSnapshotId)), removeFromOther);
    }
            final List<SnapshotId> snapshotIds = repositoryData.getSnapshots(index);  
                snapshotsIds.add(new SnapshotId("_uuid", "_does_not_exist"));
            randomFrom(SnapshotState.SUCCESS, SnapshotState.PARTIAL, SnapshotState.FAILED),
    public void testRemoveSnapshot() {
                        if (randomBoolean()) {  
        Map<String, SnapshotState> snapshotStates = new HashMap<>();  
            repositoryData.getGenId(),
            assertEquals(pathType, indexId.getShardPathType());
    }
        assertEquals(state, repositoryData.getSnapshotState(snapshotId));
        final int numSnapshots = randomIntBetween(1, 30);
        pathType = randomIntBetween(0, 2);  
            }  
                    builder.field("id", "_id");
import java.util.Arrays;  
            for (int j = 0; j < numIndicesForSnapshot; j++) {
        final SnapshotId newSnapshot = new SnapshotId(randomAlphaOfLength(7), UUIDs.randomBase64UUID(random()));  
        }
        return repositoryData;
 */  
                    final String uuid = randomBoolean() ? null : UUIDs.randomBase64UUID(random());
import java.util.HashSet;
                () -> RepositoryData.snapshotsFromXContent(xParser, randomNonNegativeLong())
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(indicesToResolve.size(), resolvedIndices.size());
            final int shardCount = randomIntBetween(1, 10);
                        }
        );
        final RepositoryData repositoryData = generateRandomRepoData();  
        for (IndexId indexId : indices.keySet()) {
            return snapshotIds.contains(randomSnapshot) && snapshotIds.size() > 1;
        int existingPathType = PathType.FIXED.getCode();  
    public static RepositoryData generateRandomRepoData(int pathType) {
 * Licensed to Elasticsearch under one or more contributor  
            .filter(index -> repositoryData.getSnapshots(index).contains(otherSnapshotId))
            indices.add(indexId);
            snapshotIds.put(snapshotId.getUUID(), snapshotId);  
        try (XContentParser xParser = createParser(corruptedBuilder)) {  
        }
            final IndexId indexId = indexIdMap.get(indexNames.get(i));
            final Set<SnapshotId> indexSnapshots = new LinkedHashSet<>();
            newIndices.entrySet()  
import java.util.Collection;
            parsedRepositoryData.getGenId(),  
        assertEquals(indicesToResolve.size(), resolvedIndices.size());
import java.util.Map;
        XContentBuilder builder = XContentBuilder.builder(xContent);  
        // Test case 1: All indices are new
            assertTrue(snapshotIds.contains(newSnapshot));  
 */
            snapshotStates.put(snapshotId.getUUID(), randomFrom(SnapshotState.values()));
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        indicesToResolve = new ArrayList<>(existingIndexNames);
                final int shardCount = randomIntBetween(1, 10);
            }
        RepositoryData repositoryData = generateRandomRepoData();
        assertEquals(repositoryData1, repositoryData2);  
                )  
        assertEquals(
        final ShardGenerations.Builder builder = ShardGenerations.builder();
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }  
            );
            IndexMetaDataGenerations.EMPTY
import org.opensearch.common.UUIDs;  
        final List<SnapshotId> snapshotIds = new ArrayList<>(snapshotIdsMap.values());
            {
        Map<IndexId, List<SnapshotId>> indexSnapshots = new HashMap<>();
 * KIND, either express or implied.  See the License for the
        assertEquals(repositoryData, parsedRepositoryData);  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(repositoryData.getGenId(), newRepoData.getGenId());
                OpenSearchParseException.class,
        RepositoryData repositoryData = generateRandomRepoData(existingPathType);
        final IndexId corruptedIndexId = randomFrom(parsedRepositoryData.getIndices().values());
            snapshotIds,  
            ShardGenerations.EMPTY,  
            assertFalse(newRepositoryData.getSnapshots(indexId).contains(removedSnapshotId));  
        for (Map.Entry<String, IndexId> snapshottedIndex : parsedRepositoryData.getIndices().entrySet()) {  
        Map<String, IndexId> existingIndices = repositoryData.getIndices();
        corruptedRepositoryData.snapshotsToXContent(corruptedBuilder, Version.CURRENT);
 * The OpenSearch Contributors require contributions made to  
                    indexId,  
        }
        // Test case 3: Some indices are in-flight
            newSnapshot,
        Map<String, IndexId> indexIdMap = repositoryData.getIndices();  
            indexSnapshots.put(indexId, snapshotsIds);  
            assertThat(
import org.opensearch.snapshots.SnapshotId;  
        // Generate repository data with a fixed path type
        }  
            Collections.emptyMap()
            builder.put(indexId, 0, UUIDs.randomBase64UUID(random()));  
                {
    public void testIndicesToUpdateAfterRemovingSnapshot() {
                assertNotNull(indexId.getId());
        for (IndexId indexId : resolvedIndices) {  
            newIdentifiers
        assertThat(snapshotIds.size(), greaterThan(0));
                            builder.field("name", "_name");
            inFlightIndexIds.put(indexName, new IndexId(indexName, UUIDs.randomBase64UUID(), pathType));
        final SnapshotState state = randomFrom(SnapshotState.values());
                assertEquals(existingIndices.get(indexId.getName()), indexId);
            newIndices.add(indexId);  
        List<SnapshotId> expected = new ArrayList<>(repositoryData.getSnapshotIds());  
                e.getMessage(),  
    public void testXContent() throws IOException {  
                for (int j = 0; j < shardCount; ++j) {  
    }
            if (newIndices.contains(indexId)) {
            OpenSearchParseException e = expectThrows(
import static org.hamcrest.Matchers.equalTo;
            } else {
    public void testAddSnapshots() {  
        }
            indexLookup,
        for (int i = 0; i < numSnapshots; i++) {  
        assertNull(repositoryData.getSnapshotState(new SnapshotId(randomAlphaOfLength(8), UUIDs.randomBase64UUID())));
        }
                Collectors.toMap(Map.Entry::getKey, e -> Collections.singleton(indexMetaDataGenerations.getIndexMetaBlobId(e.getValue())))  
            shardGenerations,  
            newIndices.put(indexId, identifier);
            } else {  
            repositoryData = repositoryData.addSnapshot(
    }
            .filter(e -> indicesToUpdate.contains(e.getKey()))
        List<String> indicesToResolve = new ArrayList<>(existingIndexNames);
            );  
        IndexId indexId = indices.get(indexName);
        RepositoryData repositoryData = new RepositoryData(
 *    http://www.apache.org/licenses/LICENSE-2.0
                equalTo("Detected a corrupted repository, " + "index [docs/_id/0] references an unknown snapshot uuid [null]")
                assertEquals(existingIndices.get(indexId.getName()), indexId);
        final XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();  
                indexLookup.values().stream().collect(Collectors.toMap(Function.identity(), ignored -> UUIDs.randomBase64UUID(random())))
        RepositoryData repositoryData2 = repositoryData1.copy();
            .collect(Collectors.toSet());
            snapshotVersions.put(snapshotId.getUUID(), randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion()));
