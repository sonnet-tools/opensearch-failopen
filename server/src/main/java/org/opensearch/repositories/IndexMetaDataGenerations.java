    }
        this.lookup = Collections.unmodifiableMap(lookup);
     *
        this.identifiers = Collections.unmodifiableMap(identifiers);
     *
                return Collections.unmodifiableMap(updated);
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @return new instance without the given snapshot
 * Tracks the blob uuids of blobs containing {@link IndexMetadata} for snapshots as well an identifier for each of these blobs.
 *
        Map<IndexId, String> newLookup,
     * If an index did not see a change in its settings, mappings or aliases between two points in time then the identifier will not change
        assert identifiers.keySet().equals(lookup.values().stream().flatMap(m -> m.values().stream()).collect(Collectors.toSet()))
            + indexMetaData.getMappingVersion()
                    return null;
import org.opensearch.common.Nullable;
        final Map<SnapshotId, Map<IndexId, String>> updatedIndexMetaLookup = new HashMap<>(lookup);
        });
     * @param snapshotIds SnapshotIds to remove
        // and dominates snapshot deletion time on repositories with a large number of snapshots and indices.
 * {@link org.opensearch.repositories.blobstore.BlobStoreRepository#finalizeSnapshot} the identifier for an instance of
package org.opensearch.repositories;
     * Create a new instance with the given snapshot and index metadata uuids and identifiers added.
     * of {@link SnapshotId#getUUID()} to allow for extended backwards compatibility use-cases with
 *
        return lookup.equals(other.lookup) && identifiers.equals(other.identifiers);
    final Map<SnapshotId, Map<IndexId, String>> lookup;
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;
 * compatible open source license.
 * GitHub history for details.
        final Map<SnapshotId, Map<IndexId, String>> updatedIndexMetaLookup = new HashMap<>(this.lookup);
     * The identifiers in the nested map can be mapped to the relevant blob uuid via {@link #getIndexMetaBlobId}.
            + indexMetaData.getSettingsVersion()
     * @param newIdentifiers new mappings of index metadata identifier to blob id
            }
     * between them either.
    /**
        return identifiers.get(metaIdentifier);
 * this file be licensed under the Apache-2.0 license or a
    /**
 * KIND, either express or implied.  See the License for the
     * @param snapshotId Snapshot Id
    @Nullable
    /**
 * You may obtain a copy of the License at
    @Override
        updatedIndexMetaIdentifiers.putAll(newIdentifiers);
            : "identifier mappings " + identifiers + " don't track the same blob ids as the lookup map " + lookup;
    public boolean equals(Object that) {
        if (!(that instanceof IndexMetaDataGenerations other)) {
     *
        return new IndexMetaDataGenerations(updatedIndexMetaLookup, updatedIndexMetaIdentifiers);
        return identifiers.isEmpty();
        return new IndexMetaDataGenerations(updatedIndexMetaLookup, updatedIndexMetaIdentifiers);
            if (lookup == null) {
import java.util.Objects;
 * ownership. Elasticsearch licenses this file to you under
        // Collect the identifiers referenced by the remaining snapshots once, instead of re-scanning every remaining
        updatedIndexMetaLookup.compute(snapshotId, (snId, lookup) -> {
     */
     * @return blob id for the given metadata identifier or {@code null} if the identifier is not part of the repository yet
import java.util.Collections;
 * Licensed to Elasticsearch under one or more contributor
        }
import java.util.Set;
     */
/*
 * the Apache License, Version 2.0 (the "License"); you may
    }
        final Set<String> referencedIdentifiers = updatedIndexMetaLookup.values()
     * @return identifier string
    /**
    final Map<String, String> identifiers;
     *
     * @param indexMetaData IndexMetaData
    public String toString() {
    }
        final Map<String, String> updatedIndexMetaIdentifiers = new HashMap<>(identifiers);
import org.opensearch.snapshots.SnapshotId;
    /**
        assert lookup.values().stream().noneMatch(Map::isEmpty) : "Lookup contained empty map [" + lookup + "]";
            + indexMetaData.getAliasesVersion();
            + indexMetaData.getSettings().get(IndexMetadata.SETTING_HISTORY_UUID, IndexMetadata.INDEX_UUID_NA_VALUE)
    public boolean isEmpty() {
    public String indexMetaBlobId(SnapshotId snapshotId, IndexId indexId) {
     * @param newLookup new mappings of index + snapshot to index metadata identifier
/*
            + "-"
    ) {
     * @return blob id for the given index metadata
     *
    }
    /**
    }
            .stream()
 * Modifications Copyright OpenSearch Contributors. See
     * Get the blob id by {@link SnapshotId} and {@link IndexId}. If none is found, we fall back to the value
        if (identifier == null) {
     * @return instance with added snapshot
                updated.putAll(newLookup);
    }
     * @param snapshotId SnapshotId
 * @opensearch.api
 *
 * specific language governing permissions and limitations
        updatedIndexMetaLookup.keySet().removeAll(snapshotIds);
 * this work for additional information regarding copyright
                return Collections.unmodifiableMap(new HashMap<>(newLookup));
 */
    public IndexMetaDataGenerations withRemovedSnapshots(Collection<SnapshotId> snapshotIds) {
     */
            return false;
     * versions which used the snapshot UUID as the index metadata blob id.
        updatedIndexMetaIdentifiers.keySet().retainAll(referencedIdentifiers);
    IndexMetaDataGenerations(Map<SnapshotId, Map<IndexId, String>> lookup, Map<String, String> identifiers) {
import java.util.Map;
 * under the License.
     * (computed via {@link #buildUniqueIdentifier}) or {@code null} if none is tracked for the identifier.
 * SPDX-License-Identifier: Apache-2.0
     */
    /**
 * Unless required by applicable law or agreed to in writing,
        SnapshotId snapshotId,
     * Map of {@link SnapshotId} to a map of the indices in a snapshot mapping {@link IndexId} to metadata identifiers.
     * Map of index metadata identifier to blob uuid.
 *
            } else {
            + "-"
 * license agreements. See the NOTICE file distributed with
            .collect(Collectors.toSet());
        return indexMetaData.getIndexUUID()
     * @param indexId    Index Id
    @Override
 */
                }
@PublicApi(since = "1.0.0")
    public int hashCode() {
        }
            return true;
            return snapshotId.getUUID();
                final Map<IndexId, String> updated = new HashMap<>(lookup);
        }
        return "IndexMetaDataGenerations{lookup:" + lookup + "}{identifier:" + identifiers + "}";
import java.util.stream.Collectors;
 * {@link #getIndexMetaBlobId(String)}.
    }
    }
/*
        // snapshot's lookup map for each identifier, which is quadratic in the number of tracked index metadata entries
 * Before writing a new {@link IndexMetadata} blob during snapshot finalization in
        } else {
        final String identifier = lookup.getOrDefault(snapshotId, Collections.emptyMap()).get(indexId);
/**
        Map<String, String> newIdentifiers
 * The OpenSearch Contributors require contributions made to
     * @param metaIdentifier identifier for {@link IndexMetadata}
    @Override
        return Objects.hash(identifiers, lookup);
     * Compute identifier for {@link IndexMetadata} from its index- and history-uuid as well as its settings-, mapping- and alias-version.
 * software distributed under the License is distributed on an
            + "-"
                if (newLookup.isEmpty()) {
     */
     */
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            + "-"
        if (this == that) {
 */
    public static String buildUniqueIdentifier(IndexMetadata indexMetaData) {
    public static final IndexMetaDataGenerations EMPTY = new IndexMetaDataGenerations(Collections.emptyMap(), Collections.emptyMap());
            .flatMap(m -> m.values().stream())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
}
     * Create a new instance with the given snapshot removed.
     * Gets the blob id by the identifier of {@link org.opensearch.cluster.metadata.IndexMetadata}
 * {@link IndexMetadata} should be computed and then used to check if it already exists in the repository via
    public String getIndexMetaBlobId(String metaIdentifier) {
public final class IndexMetaDataGenerations {
import java.util.HashMap;
            return identifiers.get(identifier);
        final Map<String, String> updatedIndexMetaIdentifiers = new HashMap<>(identifiers);
 */
import java.util.Collection;
    public IndexMetaDataGenerations withAddedSnapshot(
    }
