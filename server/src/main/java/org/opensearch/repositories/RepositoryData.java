            if (indexId == null) {
    }
        Map<String, String> indexMetaIdentifiers = null;
        final Map<String, SnapshotId> snapshots = new HashMap<>();
                                uuid = parseLegacySnapshotUUID(parser);
            indices,
            if (remaining.removeAll(snapshots)) {
                                        + "]"
     * Parses the "snapshots" field and fills maps for the various per snapshot properties. This method must run before
            }
        versions.forEach((id, version) -> newVersions.put(id.getUUID(), version));
            builder.endArray();
    public RepositoryData withGenId(long newGeneration) {
    /**
     * @param indexMetaLookup  map of {@link SnapshotId} to map of index id (as returned by {@link IndexId#getId}) that defines the index
    /**
    }
        List<IndexId> snapshotIndices = new ArrayList<>();
        Map<String, Version> snapshotVersions,
        Map<String, IndexId> indices,
                case SNAPSHOTS:
        }
                forSnapshot.put(indexLookup.get(generationEntry.getKey()), generationEntry.getValue());
            && indexSnapshots.equals(that.indexSnapshots)
        if (indexMetaBlobs == null) {
        );
     *
            return this;
        assert indexSnapshots.values().stream().noneMatch(snapshotIdList -> new HashSet<>(snapshotIdList).size() != snapshotIdList.size())
            newGeneration,
        return snapshotIndices;
    /**
    }
    /**
    }
                        state = SnapshotState.fromValue((byte) parser.intValue());
     */
        // Build a new map that instead of indexing the per-snapshot index generations by index id string, is indexed by IndexId
        Collections.emptyMap(),
                builder.value(gen);
            snapshotStates,
            snapshotStates,
        @Nullable final Map<IndexId, String> indexMetaBlobs,
                    return true;
        }
            indexId = new IndexId(indexName, id, pathType);
import org.opensearch.OpenSearchParseException;
            final String indexName = parser.currentName();
     * Returns the list of {@link IndexId} that have their snapshots updated but not removed (because they are still referenced by other
     */
        } else {
                case INDICES:
import java.io.IOException;
            return this;
     * @param shardGenerations Updated shard generations in the new snapshot. For each index contained in the snapshot an array of new
            final Collection<SnapshotId> existingIds = entry.getValue();
            shardGenerations,
            return this;
            assert id != null;
        Map<String, SnapshotId> snapshotIds,
        }
    public static final RepositoryData EMPTY = new RepositoryData(
            return false;
    private RepositoryData(
        return new RepositoryData(
                final List<SnapshotId> copy = new ArrayList<>(snapshotIds.size() + 1);
    private final Map<IndexId, List<SnapshotId>> indexSnapshots;
            final SnapshotId snapshotId = new SnapshotId(name, uuid);
     */
    public static RepositoryData snapshotsFromXContent(XContentParser parser, long genId) throws IOException {
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
                    case UUID:
            builder.endArray();
    public int hashCode() {
            snapshotIndices.add(indexId);
    /**
        final Map<String, Version> snapshotVersions = new HashMap<>();
        return builder;
        final Map<IndexId, Collection<String>> toRemove = new HashMap<>();
        Map<String, SnapshotId> snapshots,
    public Map<IndexId, List<SnapshotId>> getIndexSnapshots() {
                return existingIds.size() > snapshotIds.size();
                indexId = inFlightIds.get(index);
            indexSnapshots,
     * @return List of indices that are changed but not removed
            newSnapshotVersions.remove(snapshotId.getUUID());
            }
        Map<String, SnapshotId> snapshots,
        return indexSnapshots.entrySet().stream().filter(entry -> {
            indexMetaDataGenerations
                    parseIndices(parser, snapshots, indexSnapshots, indexLookup, shardGenerations);
 */
 * software distributed under the License is distributed on an
        for (SnapshotId snapshotId : snapshots) {
            genId,
        );
     * Creates a copy of this instance that contains updated version data.
        final Map<IndexId, List<SnapshotId>> indexSnapshots = new HashMap<>();
        Map<String, IndexId> indexLookup,
     * Add a snapshot and its indices to the repository; returns a new instance.  If the snapshot
                builder.field(STATE, state.value());
        }
                    indexMetaIdentifiers = parser.mapStrings();
            snapshotVersions,
            snapshotVersions,
import java.util.Map;
            assert newIdentifiers == null : "Non-null new identifiers [" + newIdentifiers + "] for null lookup";
            && snapshotStates.equals(that.snapshotStates)
     * throwing an exception if the index could not be resolved.
                            final SnapshotId snapshotId = snapshots.get(uuid);
            String id = null;
            // if the snapshot id already exists in the repository data, it means an old master
        }
                        version = Version.fromString(parser.text());
        if (snapshotIds.containsKey(snapshotId.getUUID())) {
     */
                builder.field(IndexId.SHARD_PATH_TYPE, indexId.getShardPathType());
            builder.startObject(INDEX_METADATA_LOOKUP);
 * this file be licensed under the Apache-2.0 license or a
            genId,
     * @return copy with updated version data
    }
            genId,
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParserUtils;
        Map<IndexId, List<SnapshotId>> allIndexSnapshots = new HashMap<>(indexSnapshots);
        RepositoryData that = (RepositoryData) obj;
        if (newSnapshotIds.size() != snapshotIds.size() - snapshots.size()) {
        }
     * Create a new instance with the given generation and all other fields equal to this instance.
            String currentFieldName = parser.currentName();
        builder.field(INDEX_METADATA_IDENTIFIERS, indexMetaDataGenerations.identifiers);
            throw new ResourceNotFoundException("Attempting to remove non-existent snapshots {} from repository data", notFound);
 * The OpenSearch Contributors require contributions made to
            newIndexMetaGenerations = IndexMetaDataGenerations.EMPTY;
            final Map<String, String> val = snapshotIdMapEntry.getValue();
                        name = parser.text();
        this.indexSnapshots = indexSnapshots;
    public SnapshotState getSnapshotState(final SnapshotId snapshotId) {
        final Map<String, SnapshotState> snapshotStates = new HashMap<>();
                final String indexMetaFieldName = parser.currentName();
    /**
            for (final SnapshotId snapshotId : snapshotIds) {
            newSnapshotStates.remove(snapshotId.getUUID());
                    // todo: remove in next version
     *                             index metadata generations for the snapshot that was parsed by {@link #parseSnapshots}
/*
    protected RepositoryData copy() {
    /**
    }
                if (parsedGen != null) {
            snapshotIds,
                            if (snapshotId == null) {
     * @param inFlightIds      name to index mapping for currently in-flight snapshots not yet in the repository data to fall back to
                    case STATE:
     * @param parser              x-content parser
            } else {
        );
            snapshotStates,
            snapshots,
    /**
    private static final String INDEX_METADATA_IDENTIFIERS = "index_metadata_identifiers";
    public RepositoryData removeSnapshots(final Collection<SnapshotId> snapshots, final ShardGenerations updatedShardGenerations) {
            builder.startArray(SNAPSHOTS);
        }
                    XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            if (snapshotIds.containsAll(existingIds)) {
                        break;
        List<SnapshotId> snapshotIds = indexSnapshots.get(indexId);
    public Map<IndexId, Collection<String>> indexMetaDataToRemoveAfterRemovingSnapshots(Collection<SnapshotId> snapshotIds) {
        Map<String, SnapshotState> snapshotStates,
                .entrySet()) {
    public long getGenId() {
     * The generation value indicating the repository has no index generational files.
    }
            final String snapshotUUID = snapshot.getUUID();
     */
            final Version version = snapshotVersions.get(snapshotUUID);
            snapshotIds,
                                        + new IndexId(indexName, id, pathType)
     * The snapshots that each index belongs to.
                            snapshotIds.add(snapshotId);
     * Returns an unmodifiable collection of the snapshot ids.
 *
        return new RepositoryData(
                }
     *                                changed shard indexed by its shardId
        final Set<String> allRemainingIdentifiers = indexMetaDataGenerations.lookup.entrySet()
        return new RepositoryData(
        );
    }
    /**
        return new RepositoryData(
        }
                switch (currentFieldName) {
        Collections.emptyMap(),
        }
            builder.field(UUID, snapshotUUID);
     * new indices in the repository.
            .collect(Collectors.toSet());
     * @param updatedShardGenerations Shard generations that changed as a result of removing the snapshot.
        long genId,
            snapshots.put(uuid, snapshotId);
                        break;
        final Map<String, String> stringDeduplicator = new HashMap<>();
        return snapshotStates.get(snapshotId.getUUID());
        }
            snapshotIds,
        Map<String, SnapshotState> snapshotStates,
    }
            // the new master, so we make the operation idempotent
                                throw new OpenSearchParseException(
            for (String gen : shardGenerations.getGens(indexId)) {
    /**
     *
     * Index metadata generations.
            indexMetaDataGenerations
import java.util.ArrayList;
            .flatMap(e -> e.getValue().values().stream())
     */
        }
            ShardGenerations.builder()
            indexGenerations.put(snapshotIdMapEntry.getKey(), forSnapshot);
            }
            builder.field(NAME, snapshot.getName());
    private static final String INDEX_METADATA_LOOKUP = "index_metadata_lookup";
    /**
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    public List<IndexId> resolveIndices(final List<String> indices) {
            shardGenerations,
        return uuid;
import java.util.function.Function;
            String name = null;
                    toRemove.computeIfAbsent(indexId, k -> new HashSet<>()).add(identifier);
                    shardGenerations.put(indexId, i, parsedGen);
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
        this.snapshotStates = snapshotStates;
        final SnapshotId snapshotId,
            }
    }
            if (snapshotIds == null) {
import org.opensearch.core.xcontent.XContentBuilder;
                String parsedGen = gens.get(i);
            Collections.unmodifiableMap(snapshotIds),
    /**
        if (obj == null || getClass() != obj.getClass()) {
        Map<String, Version> snapshotVersions,
            indices,
            snapshotStates,
                    case NAME:
                                );
            for (Map.Entry<String, String> generationEntry : val.entrySet()) {
                    case INDEX_ID:
        ShardGenerations.Builder shardGenerations
        final Map<String, IndexId> indexLookup = new HashMap<>();
        for (final SnapshotId snapshot : getSnapshotIds()) {
                final XContentParser.Token currentToken = parser.nextToken();
            if (indexId == null) {
     * Shard generations.
    public static final long CORRUPTED_REPO_GEN = -3L;
    }
     *
                        break;
            return true;
                        break;
            .filter(sn -> snapshots.contains(sn) == false)
    private final IndexMetaDataGenerations indexMetaDataGenerations;
    private static final String SHARD_GENERATIONS = "shard_generations";
    private final Map<String, IndexId> indices;
            .collect(Collectors.toMap(SnapshotId::getUUID, Function.identity()));
import java.util.stream.Collectors;
    private final Map<String, SnapshotId> snapshotIds;
     * Resolve the index name to the index id specific to the repository,
            genId,
            }
    /**
                                        + uuid
        }
        }
    private static final String INDICES = "indices";
        snapshots.put(snapshotId.getUUID(), snapshotId);
import java.util.HashSet;
        Map<String, String> indexMetaIdentifiers
     * @param snapshotState    State of the new snapshot
            indexMetaDataGenerations.withRemovedSnapshots(snapshots)
    // Visible for testing only
import org.opensearch.snapshots.SnapshotId;
     * @param versions map of snapshot versions
 * A class that represents the data in a repository, as captured in the
    private static final String STATE = "state";
        this.genId = genId;
            snapshotStates,
     * @param indexSnapshots      map of {@link IndexId} to list of {@link SnapshotId} that contain the given index
        builder.startObject();
    }
                uuid = parser.text();
        IndexMetaDataGenerations indexMetaDataGenerations
        Collections.emptyMap(),
 * Modifications Copyright OpenSearch Contributors. See
            builder.startObject();
                    case SNAPSHOTS:
            List<SnapshotId> snapshotIds = indexSnapshots.get(indexId);
            && indexMetaDataGenerations.equals(that.indexMetaDataGenerations);
    ) {
                        }
    public List<IndexId> indicesToUpdateAfterRemovingSnapshot(Collection<SnapshotId> snapshotIds) {
    public List<SnapshotId> getSnapshots(final IndexId indexId) {
     * @return New instance
                    case IndexId.SHARD_PATH_TYPE:
        return Objects.hash(
    public XContentBuilder snapshotsToXContent(final XContentBuilder builder, final Version repoMetaVersion, final Version minNodeVersion)
        this.snapshotVersions = snapshotVersions;
            if (state != null) {
                            gens.add(parser.textOrNull());
            switch (field) {
        IndexMetaDataGenerations.EMPTY
            buildIndexMetaGenerations(indexMetaLookup, indexLookup, indexMetaIdentifiers)
        return toRemove;
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.nextToken(), parser);
     */
                            } else {
        this.shardGenerations = shardGenerations;
    /**
            final List<SnapshotId> snapshotIds = allIndexSnapshots.get(indexId);
    private static void parseSnapshots(
            }
        }
     * The ids of the snapshots in the repository.
            + " but snapshots only reference indices "
     */
        return genId;
            if (UUID.equals(currentFieldName)) {
                        break;
     * already exists in the repository data, this method throws an IllegalArgumentException.
        final SnapshotState snapshotState,
            assert indexMetaBlobs.isEmpty() || shardGenerations.indices().equals(indexMetaBlobs.keySet())
                                // the new format post 5.4.1 that only contains the snapshot uuid,
                    + " but indexMetaData was given for "
                        break;
 */
            Collections.unmodifiableMap(snapshotVersions),
                copy.addAll(snapshotIds);
            final Map<IndexId, String> forSnapshot = new HashMap<>(val.size());
        builder.startArray(SNAPSHOTS);
            for (SnapshotId snapshotId : snapshotIds) {
     * snapshots) after removing the given snapshot from the repository.
                case MIN_VERSION:
    @Override
    /**
        Collection<IndexId> indicesForSnapshot = indicesToUpdateAfterRemovingSnapshot(snapshotIds);
     * @param indexLookup         map of index uuid (as returned by {@link IndexId#getId}) to {@link IndexId}
        Map<IndexId, List<SnapshotId>> indexSnapshots,
        final Version version,
     * @return map of index to index metadata blob id to delete
    }
 * @opensearch.api
            allIndexSnapshots,
     *
     */
     */
    public ShardGenerations shardGenerations() {
        @Nullable final Map<String, String> newIdentifiers
                                uuid = parser.text();
    private final long genId;
        newSnapshotVersions.put(snapshotId.getUUID(), version);
                remaining = Collections.unmodifiableList(remaining);
     */
            parser.nextToken();
    private static final String UUID = "uuid";
import org.opensearch.snapshots.SnapshotState;
        return indices;
                    break;
    }
        for (final IndexId indexId : shardGenerations.indices()) {
import org.opensearch.Version;
        XContentParser parser,
    private final Map<String, SnapshotState> snapshotStates;
     *
        Map<String, SnapshotId> snapshots = new HashMap<>(snapshotIds);
            builder.startArray(SHARD_GENERATIONS);
            newSnapshotVersions,
     */
                        metaGenerations = parser.map(HashMap::new, p -> stringDeduplicator.computeIfAbsent(p.text(), Function.identity()));
import org.opensearch.common.Nullable;
     * {@link org.opensearch.cluster.metadata.IndexMetadata} blob name in it that can be removed after removing the given snapshot from
 * under the License.
            }
    /**
    public RepositoryData addSnapshot(
        );
        Map<String, SnapshotState> snapshotStates,
     * @param newGeneration New Generation
     */
        }
                indexMetaLookup.put(snapshotId, metaGenerations);
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
    private static final String MIN_VERSION = "min_version";
    }
                    parser.nextToken();
     */
        return new IndexMetaDataGenerations(indexGenerations, indexMetaIdentifiers);
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
                }
    /**
            } else {
            && indices.equals(that.indices)
        if (snapshotIds == null) {
            return IndexMetaDataGenerations.EMPTY;
                if (allRemainingIdentifiers.contains(identifier) == false) {
 */
            final Collection<SnapshotId> notFound = new HashSet<>(snapshots);
            SnapshotState state = null;
     *                             {@link #parseIndices}
     *                         metadata generations for the snapshot
            indexSnapshots,
                        XContentParser.Token currToken;
            indexSnapshots.put(indexId, Collections.unmodifiableList(snapshotIds));
            }
                remaining = snapshotIds;
            snapshotIds,
            }
import java.util.HashMap;
                    break;
                            if (currToken == XContentParser.Token.START_OBJECT) {
            final List<SnapshotId> snapshotIds = new ArrayList<>();
            builder.startObject(indexId.getName());
                copy.add(snapshotId);
    private static final String INDEX_ID = "id";
    /**
        return indexSnapshots;
            }
            }
     * Reads an instance of {@link RepositoryData} from x-content, loading the snapshots and indices metadata.
            // that is blocked from the cluster is trying to finalize a snapshot concurrently with
                if (entry.getValue().contains(snapshotId)) {
            throw new IllegalArgumentException("unknown snapshot index " + indexId);
        final Map<String, Version> newVersions = new HashMap<>(snapshotVersions);
    private static final String NAME = "name";
    /**
        final ShardGenerations shardGenerations,
            }
    /**
}
        Map<IndexId, List<SnapshotId>> indexSnapshots,
import org.opensearch.ResourceNotFoundException;
    }
     * {@code shardGenerations}.
     * The generation value indicating that the repository generation is unknown.
            newSnapshotStates,
     */
                                    "Detected a corrupted repository, index "
                }
     * The generation value indicating that the repository generation could not be determined.
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_ARRAY, currentToken, parser);
/*
    /**
import java.util.Collection;
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
     * @param indicesToResolve names of indices to resolve
            indexMetaDataGenerations
        Map<String, Version> newSnapshotVersions = new HashMap<>(snapshotVersions);
            final String field = parser.currentName();
            indexSnapshots,
     * NOTE: Does not return a mapping for {@link IndexId} values that will be removed completely from the repository.
        throws IOException {
            .map(indexMetaDataGenerations::getIndexMetaBlobId)
            indexMetaDataGenerations
            Collections.unmodifiableMap(indexSnapshots),
    }
                + "]";
    private final Map<String, Version> snapshotVersions;
            newSnapshotVersions,
        return indexMetaDataGenerations;
    private static String parseLegacySnapshotUUID(XContentParser parser) throws IOException {
     * @param snapshotIds SnapshotIds to remove
    }
                                // different versions create or delete snapshot in the same repository.
                .build(),
            && snapshotVersions.equals(that.snapshotVersions)
     * Resolve the given index names to index ids, creating new index ids for
            ShardGenerations.builder().putAll(this.shardGenerations).putAll(shardGenerations).build(),
            List<SnapshotId> snapshotIds = this.indexSnapshots.get(indexId);
                indexSnapshots.put(indexId, remaining);
                case INDEX_METADATA_IDENTIFIERS:
        String uuid = null;
            }
     * there is no state for the snapshot.
     */
            indexMetaDataGenerations
            assert indexMetaDataGenerations.lookup.isEmpty() : "Index meta generations should have been empty but was ["
     * Returns an unmodifiable map of the index names to {@link IndexId} in the repository.
            String uuid = null;
            indexSnapshots,
    /**
                    // ignore min_version
     */
            return false;
    private static final String SNAPSHOTS = "snapshots";
    ) throws IOException {
     * @param snapshots               Snapshot ids to remove
     */
        final ShardGenerations.Builder shardGenerations = ShardGenerations.builder();
    /**
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            genId,
                        while ((currToken = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                    break;
     * An instance initialized for an empty repository.
        builder.endObject();
            }
    /**
                        pathType = parser.intValue();
        assert indices.values().containsAll(shardGenerations.indices()) : "ShardGenerations contained indices "
        Collections.emptyMap(),
    public Collection<SnapshotId> getSnapshotIds() {
    /**
    public boolean equals(Object obj) {
            for (Map.Entry<IndexId, String> entry : indexMetaDataGenerations.lookup.getOrDefault(snapshot, Collections.emptyMap())
     * @param snapshotId       Id of the new snapshot
        Map<String, SnapshotState> newSnapshotStates = new HashMap<>(snapshotStates);
     * The indices found in the repository across all snapshots, as a name to {@link IndexId} mapping
            IndexId indexId = indices.get(index);
        for (Map.Entry<SnapshotId, Map<String, String>> snapshotIdMapEntry : indexMetaLookup.entrySet()) {
        return Objects.requireNonNull(indices.get(indexName), () -> "Tried to resolve unknown index [" + indexName + "]");
     * @param indexMetaIdentifiers map of index generation to index meta identifiers parsed by {@link #snapshotsFromXContent}
        return shardGenerations;
     *
                builder.value(snapshotId.getUUID());
        }
     * Returns the {@link SnapshotState} for the given snapshot.  Returns {@code null} if
            }
            }
     * {@link #parseIndices} which will rely on the maps of snapshot properties to have been populated already.
     * @param snapshots        map of snapshot uuid to {@link SnapshotId}
            assert snapshotIds != null;
                        break;
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentParser;
            : "Found duplicate snapshot ids per index in [" + indexSnapshots + "]";
     */
            indexSnapshots,
            }
     * Builds {@link IndexMetaDataGenerations} instance from the information parsed previously.
 *
        if (this == obj) {
    ) {
    public XContentBuilder snapshotsToXContent(final XContentBuilder builder, final Version repoMetaVersion) throws IOException {
    @Nullable
                    case VERSION:
 * the Apache License, Version 2.0 (the "License"); you may
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        Map<String, SnapshotState> newSnapshotStates = new HashMap<>(snapshotStates);
                final String identifier = indexMetaDataGenerations.indexMetaBlobId(snapshotId, indexId);
     * @param newIdentifiers   Map of new index metadata blob uuids keyed by the identifiers of the
        IndexMetaDataGenerations indexMetaDataGenerations
     * Returns an immutable collection of the snapshot ids for the snapshots that contain the given index.
            }
    }
        );
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_ARRAY, currentToken, parser);
     * Returns a map of {@link IndexId} to a collection of {@link String} containing all the {@link IndexId} and the
                    + indexMetaBlobs.keySet();
            builder.endObject();
                builder.field(entry.getKey().getId(), entry.getValue());
            newSnapshotIds,
    public IndexMetaDataGenerations indexMetaDataGenerations() {
        Map<SnapshotId, Map<String, String>> indexMetaLookup
    /**
        return snapshotIds.values();
            + shardGenerations.indices()
    public List<IndexId> resolveNewIndices(List<String> indicesToResolve, Map<String, IndexId> inFlightIds, int pathType) {
            for (SnapshotId snapshotId : snapshotIds) {
                        break;
                                // the list of snapshots. This can happen when multiple clusters in
                    case SHARD_GENERATIONS:
            notFound.removeAll(snapshotIds.values());
        Map<IndexId, List<SnapshotId>> indexSnapshots = new HashMap<>();
     * Writes the snapshots metadata and the related indices metadata to x-content.
        ShardGenerations shardGenerations,
        }
     * Parses information about all indices tracked in the repository and populates {@code indexSnapshots}, {@code indexLookup} and
            genId,
@PublicApi(since = "1.0.0")
        for (IndexId indexId : indicesForSnapshot) {
        return snapshotsToXContent(builder, repoMetaVersion, Version.V_2_17_0);
     * @param shardGenerations    shard generations builder that is populated index by this method
                .putAll(shardGenerations)
            if (metaGenerations != null && metaGenerations.isEmpty() == false) {
 * Licensed to Elasticsearch under one or more contributor
        this.snapshotIds = snapshotIds;
        return snapshotIds;
                builder.field(VERSION, version.toString());
package org.opensearch.repositories;
        );
            shardGenerations,
     *
            builder.field(INDEX_ID, indexId.getId());
            Collections.unmodifiableMap(snapshotStates),
            if (minNodeVersion.onOrAfter(Version.V_2_17_0)) {
            builder.endObject();
                    case INDEX_METADATA_LOOKUP:
    public Map<String, IndexId> getIndices() {
     */
            newIndexMetaGenerations
     */
            final List<String> gens = new ArrayList<>();
            for (int i = 0; i < gens.size(); i++) {
        final Map<SnapshotId, Map<IndexId, String>> indexGenerations = new HashMap<>(indexMetaLookup.size());
    }
        Map<SnapshotId, Map<String, String>> indexMetaLookup,
    @Override
                parser.nextToken();
import org.opensearch.common.annotation.PublicApi;
                            final String uuid;
 * not use this file except in compliance with the License.
            shardGenerations.build(),
     * @return index meta generations instance
        final IndexMetaDataGenerations newIndexMetaGenerations;
        while (parser.nextToken() == XContentParser.Token.FIELD_NAME) {
     * @param snapshotIds SnapshotId to remove
        for (String index : indicesToResolve) {
        this(
            shardGenerations,
        }
            if (version != null) {
        );
        builder.endObject();
 *
                allIndexSnapshots.put(indexId, Collections.unmodifiableList(copy));
            assert snapshotIds != null;
     * @param parser           x-content parse
     *                         generations indexed by the shard id they correspond to must be supplied.
import org.opensearch.common.UUIDs;
        for (final String indexName : indices) {
        List<IndexId> resolvedIndices = new ArrayList<>(indices.size());
            final SnapshotState state = snapshotStates.get(snapshotUUID);
    }
public final class RepositoryData {
    );
    private static void parseIndices(
            }
     * the repository.
        XContentParser parser,
import java.util.Set;
            List<SnapshotId> remaining = new ArrayList<>(snapshotIds);
        }
    ) {
            if (state != null) {
 * ownership. Elasticsearch licenses this file to you under
import java.util.Collections;
 *
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
            IndexId indexId = null;
     */
     * @param indexLookup          map of index uuid (as returned by {@link IndexId#getId}) to {@link IndexId} that was parsed by
        for (final IndexId indexId : getIndices().values()) {
        ShardGenerations shardGenerations,
            .filter(e -> snapshotIds.contains(e.getKey()) == false)
                indexId = new IndexId(index, UUIDs.randomBase64UUID(), pathType);
 * compatible open source license.
        this.indexMetaDataGenerations = indexMetaDataGenerations;
 * SPDX-License-Identifier: Apache-2.0
    public static final long UNKNOWN_REPO_GEN = -2L;
                snapshotVersions.put(uuid, version);
            + indices.values();
        ShardGenerations.EMPTY,
    ) {
     *
            Map<String, String> metaGenerations = null;
                            }
            indexLookup.put(id, indexId);
        }
        }
     * The states of each snapshot in the repository.
                        uuid = parser.text();
            newVersions,
     */
        // write the indices map
     * Returns the {@link Version} for the given snapshot or {@code null} if unknown.
     * The generational id of the index file from which the repository data was read.
            Collections.unmodifiableMap(indexSnapshots.keySet().stream().collect(Collectors.toMap(IndexId::getName, Function.identity()))),
        return snapshotVersions.get(snapshotId.getUUID());
    }
                switch (indexMetaFieldName) {
    }
                        break;
    /**
     */
            shardGenerations,
            if (version != null) {
        return snapshotIds.equals(that.snapshotIds)
     * @param indexMetaBlobs   Map of index metadata blob uuids
            snapshots,
     * Gets the generational index file id from which this instance was read.
        Map<String, IndexId> indexLookup,
 */
     *
        final Map<SnapshotId, Map<String, String>> indexMetaLookup = new HashMap<>();
                snapshotStates.put(uuid, state);
                                // A snapshotted index references a snapshot which does not exist in
                String currentFieldName = parser.currentName();
    }
 * Unless required by applicable law or agreed to in writing,
     * @param snapshots           map of snapshot uuid to {@link SnapshotId} that was populated by {@link #parseSnapshots}
     * Remove snapshots and remove any indices that no longer exist in the repository due to the deletion of the snapshots.
    }
import java.util.List;
            indexSnapshots,
     */
            snapshotVersions,
    }
        return new RepositoryData(
     * @param snapshotVersions map of snapshot uuid to {@link Version} that the snapshot was taken in
        final Map<String, Version> newSnapshotVersions = new HashMap<>(snapshotVersions);
        if (newGeneration == genId) {
                                        + " references an unknown snapshot uuid ["
            Version version = null;
                    break;
     */
        this.indices = indices;
        Collections.emptyMap(),
            }
    public RepositoryData(
        // write the snapshots list
    public RepositoryData withVersions(Map<SnapshotId, Version> versions) {
        Map<IndexId, List<SnapshotId>> indexSnapshots,
                        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            newSnapshotStates,
                            }
        EMPTY_REPO_GEN,
                }
 * repository's index blob.
                allIndexSnapshots.put(indexId, Collections.singletonList(snapshotId));
            }
     * @param indexMetaLookup      map of {@link SnapshotId} to map of index id (as returned by {@link IndexId#getId}) that defines the
        if (indexMetaLookup.isEmpty()) {
        }).map(Map.Entry::getKey).collect(Collectors.toList());
/**
        builder.endArray();
                    parseSnapshots(parser, snapshots, snapshotStates, snapshotVersions, indexMetaLookup);
import java.util.Objects;
    ) throws IOException {
        builder.startObject(INDICES);
    /**
    public static final long EMPTY_REPO_GEN = -1L;
 * license agreements. See the NOTICE file distributed with
    public IndexId resolveIndexId(final String indexName) {
            .stream()
        if (versions.isEmpty()) {
    }
                            // the old format pre 5.4.1 which contains the snapshot name and uuid
    }
            resolvedIndices.add(resolveIndexId(indexName));
        Map<String, SnapshotId> newSnapshotIds = snapshotIds.values()
            if (remaining.isEmpty() == false) {
                        }
            builder.endObject();
        }
            newIndexMetaGenerations = indexMetaDataGenerations.withAddedSnapshot(snapshotId, indexMetaBlobs, newIdentifiers);
    private static final String VERSION = "version";
                .putAll(updatedShardGenerations)
    public Version getVersion(SnapshotId snapshotId) {
                    XContentParserUtils.throwUnknownField(field, parser.getTokenLocation());
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     *                                The {@code String[]} passed for each {@link IndexId} contains the new shard generation id for each
                }
     * Resolve the given index names to index ids.
     */
                + indexMetaDataGenerations
                : "Shard generations contained indices "
    }
            snapshotVersions,
 * GitHub history for details.
     */
                                // since we already have the name/uuid combo in the snapshots array
    /**
            .stream()
        return new RepositoryData(
            int pathType = IndexId.DEFAULT_SHARD_PATH_TYPE;
     */
        Map<String, Version> snapshotVersions,
        newSnapshotStates.put(snapshotId.getUUID(), snapshotState);
        long genId,
    /**
        Map<String, SnapshotId> snapshotIds,
            }
     *                         {@link org.opensearch.cluster.metadata.IndexMetadata} in them
                        id = parser.text();
/*
                .retainIndicesAndPruneDeletes(indexSnapshots.keySet())
                default:
                    + shardGenerations.indices()
        for (final IndexId indexId : indices.values()) {
 * You may obtain a copy of the License at
    private final ShardGenerations shardGenerations;
    private static IndexMetaDataGenerations buildIndexMetaGenerations(
    /**
        return resolvedIndices;
     */
     * @param snapshotStates   map of snapshot uuid to {@link SnapshotState}
     */
            && shardGenerations.equals(that.shardGenerations)
    }
