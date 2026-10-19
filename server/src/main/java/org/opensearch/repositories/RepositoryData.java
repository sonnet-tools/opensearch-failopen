    public ShardGenerations shardGenerations() {  
                                uuid = parseLegacySnapshotUUID(parser);
                snapshotStates.put(uuid, state);
    private static final String SHARD_GENERATIONS = "shard_generations";
                        uuid = parser.text();
 *  
 * A class that represents the data in a repository, as captured in the  
            }  
    public static final long EMPTY_REPO_GEN = -1L;
            for (int i = 0; i < gens.size(); i++) {
            for (Map.Entry<IndexId, String> entry : indexMetaDataGenerations.lookup.getOrDefault(snapshot, Collections.emptyMap())
                .build(),
                .putAll(updatedShardGenerations)
                    break;
                remaining = snapshotIds;
    public Map<String, IndexId> getIndices() {
    public long getGenId() {
            snapshots,  
        );  
                    break;
            indexMetaDataGenerations
     */  
        for (final IndexId indexId : getIndices().values()) {  
            if (metaGenerations != null && metaGenerations.isEmpty() == false) {
        Map<String, IndexId> indices,
                    case INDEX_METADATA_LOOKUP:
                    parser.nextToken();  
            final SnapshotState state = snapshotStates.get(snapshotUUID);
        @Nullable final Map<IndexId, String> indexMetaBlobs,
     * @param snapshotIds SnapshotId to remove  
     * Returns an immutable collection of the snapshot ids for the snapshots that contain the given index.
     * there is no state for the snapshot.
     * already exists in the repository data, this method throws an IllegalArgumentException.
     *                             {@link #parseIndices}  
    /**  
            throw new ResourceNotFoundException("Attempting to remove non-existent snapshots {} from repository data", notFound);
            final Collection<SnapshotId> notFound = new HashSet<>(snapshots);
                        id = parser.text();
    private static final String INDEX_METADATA_IDENTIFIERS = "index_metadata_identifiers";  
        this.indices = indices;
    }
     *
        Map<IndexId, List<SnapshotId>> allIndexSnapshots = new HashMap<>(indexSnapshots);
            return true;
            assert snapshotIds != null;
            assert snapshotIds != null;  
        return resolvedIndices;
                copy.add(snapshotId);  
                    break;
     * @param indexSnapshots      map of {@link IndexId} to list of {@link SnapshotId} that contain the given index
        throws IOException {
                        break;  
    private static final String VERSION = "version";
            && snapshotVersions.equals(that.snapshotVersions)
    private static final String INDEX_METADATA_LOOKUP = "index_metadata_lookup";
            newSnapshotIds,
        ShardGenerations.EMPTY,  
     * Returns the {@link Version} for the given snapshot or {@code null} if unknown.
                    case VERSION:
        for (Map.Entry<SnapshotId, Map<String, String>> snapshotIdMapEntry : indexMetaLookup.entrySet()) {
            }
                indexSnapshots.put(indexId, remaining);
            shardGenerations,
    }
            genId,
        versions.forEach((id, version) -> newVersions.put(id.getUUID(), version));  
            List<SnapshotId> snapshotIds = this.indexSnapshots.get(indexId);
    private static void parseSnapshots(  
                return existingIds.size() > snapshotIds.size();
            }  
                default:
            builder.startObject(indexId.getName());
            } else {  
                        break;  
        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
                    case UUID:
     * new indices in the repository.  
     * @param indicesToResolve names of indices to resolve
    private static void parseIndices(  
    /**
            for (String gen : shardGenerations.getGens(indexId)) {
     */  
        }
     * @param parser              x-content parser  
        XContentParser parser,
            snapshotIds,  
            final String field = parser.currentName();  
    /**
import java.util.ArrayList;
import org.opensearch.OpenSearchParseException;
                    parseIndices(parser, snapshots, indexSnapshots, indexLookup, shardGenerations);  
            shardGenerations,
     * @param snapshots        map of snapshot uuid to {@link SnapshotId}  
     * Resolve the given index names to index ids.  
        this.genId = genId;
            snapshotStates,
    public boolean equals(Object obj) {  
            .stream()
        this.indexSnapshots = indexSnapshots;
                    indexMetaIdentifiers = parser.mapStrings();
    @Nullable
                        break;  
    }
                                // A snapshotted index references a snapshot which does not exist in
                            if (currToken == XContentParser.Token.START_OBJECT) {
            }
        if (newGeneration == genId) {  
    private final Map<String, IndexId> indices;
     * @param newGeneration New Generation
            shardGenerations,  
        return indexSnapshots;
    private static final String NAME = "name";
        List<IndexId> resolvedIndices = new ArrayList<>(indices.size());  
                        while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
import java.util.List;
            indexSnapshots,  
                indexId = new IndexId(index, UUIDs.randomBase64UUID(), pathType);
            if (snapshotIds == null) {
                        metaGenerations = parser.map(HashMap::new, p -> stringDeduplicator.computeIfAbsent(p.text(), Function.identity()));
        }  
    public List<SnapshotId> getSnapshots(final IndexId indexId) {  
     * Parses the "snapshots" field and fills maps for the various per snapshot properties. This method must run before
            builder.startArray(SHARD_GENERATIONS);
    /**  
     * @param shardGenerations Updated shard generations in the new snapshot. For each index contained in the snapshot an array of new
            if (version != null) {
 * Modifications Copyright OpenSearch Contributors. See
            }
     */
     * @param snapshotStates   map of snapshot uuid to {@link SnapshotState}
     */
                        name = parser.text();
    public Collection<SnapshotId> getSnapshotIds() {
    /**
     */  
    /**
import org.opensearch.core.xcontent.XContentParserUtils;  
     */  
                + "]";
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
                        break;  
        Collections.emptyMap(),
     * The snapshots that each index belongs to.
        IndexMetaDataGenerations.EMPTY
    /**
        final Map<String, Version> newSnapshotVersions = new HashMap<>(snapshotVersions);
            genId,
    private static final String STATE = "state";
 * under the License.  
     */
        // Build a new map that instead of indexing the per-snapshot index generations by index id string, is indexed by IndexId  
            SnapshotState state = null;  
            .filter(sn -> snapshots.contains(sn) == false)
            newSnapshotVersions,
                            // the old format pre 5.4.1 which contains the snapshot name and uuid  
        Map<String, SnapshotId> newSnapshotIds = snapshotIds.values()  
    public static final RepositoryData EMPTY = new RepositoryData(
     * An instance initialized for an empty repository.  
            String id = null;
                        break;  
            }
    private final Map<String, Version> snapshotVersions;  
     *
     * Index metadata generations.  
                }
    }
        final Version version,
    /**
     * @param indexMetaLookup      map of {@link SnapshotId} to map of index id (as returned by {@link IndexId#getId}) that defines the  
     *                         metadata generations for the snapshot
    /**
    }  
    /**
        Collections.emptyMap(),
    /**
 * specific language governing permissions and limitations
        }
            newVersions,
            newIndexMetaGenerations = indexMetaDataGenerations.withAddedSnapshot(snapshotId, indexMetaBlobs, newIdentifiers);  
     */
            snapshotIndices.add(indexId);  
    public RepositoryData addSnapshot(
                        break;  
import java.util.HashSet;  
        return indexSnapshots.entrySet().stream().filter(entry -> {
            }
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        for (SnapshotId snapshotId : snapshots) {
        final Map<SnapshotId, Map<IndexId, String>> indexGenerations = new HashMap<>(indexMetaLookup.size());
            final String snapshotUUID = snapshot.getUUID();  
        Map<IndexId, List<SnapshotId>> indexSnapshots,
            IndexId indexId = indices.get(index);
                        break;  
                        XContentParser.Token currToken;  
        Map<String, SnapshotId> snapshots = new HashMap<>(snapshotIds);
            for (SnapshotId snapshotId : snapshotIds) {
        Collections.emptyMap(),
            indexSnapshots,  
        this.snapshotVersions = snapshotVersions;
     * throwing an exception if the index could not be resolved.
            builder.field(INDEX_ID, indexId.getId());
            && snapshotStates.equals(that.snapshotStates)  
import org.opensearch.core.xcontent.XContentBuilder;
            resolvedIndices.add(resolveIndexId(indexName));
 * GitHub history for details.
                                );
        if (versions.isEmpty()) {
    private static IndexMetaDataGenerations buildIndexMetaGenerations(
        EMPTY_REPO_GEN,  
        return builder;
            builder.endObject();
import org.opensearch.Version;  
                String currentFieldName = parser.currentName();
    }  
            indexId = new IndexId(indexName, id, pathType);
            indexSnapshots.put(indexId, Collections.unmodifiableList(snapshotIds));
            genId,
            }
        return snapshotIds.equals(that.snapshotIds)
            }
                .entrySet()) {
    }  
    }
            .stream()  
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
        Map<SnapshotId, Map<String, String>> indexMetaLookup
            indexSnapshots,
        );  
                copy.addAll(snapshotIds);
        return new RepositoryData(  
    public static final long UNKNOWN_REPO_GEN = -2L;
    }
import org.opensearch.common.UUIDs;
        Map<String, IndexId> indexLookup,
                if (allRemainingIdentifiers.contains(identifier) == false) {  
     * Parses information about all indices tracked in the repository and populates {@code indexSnapshots}, {@code indexLookup} and  
        }
            }
            + shardGenerations.indices()
     */
    ) {
    /**  
            && indices.equals(that.indices)
            snapshots,
import org.opensearch.snapshots.SnapshotId;
     */
                            }
            + indices.values();  
/*  
     */
            Collections.unmodifiableMap(indexSnapshots.keySet().stream().collect(Collectors.toMap(IndexId::getName, Function.identity()))),
            final String indexName = parser.currentName();  
            Version version = null;
            snapshotStates,
     *
        assert indices.values().containsAll(shardGenerations.indices()) : "ShardGenerations contained indices "  
        IndexMetaDataGenerations indexMetaDataGenerations
                    + " but indexMetaData was given for "
 *
    // Visible for testing only
    }
            indexSnapshots,  
    public static final long CORRUPTED_REPO_GEN = -3L;  
                remaining = Collections.unmodifiableList(remaining);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
            .map(indexMetaDataGenerations::getIndexMetaBlobId)  
                            final String uuid;
    /**
     * Returns an unmodifiable map of the index names to {@link IndexId} in the repository.
            snapshotVersions,
        final Set<String> allRemainingIdentifiers = indexMetaDataGenerations.lookup.entrySet()
                if (entry.getValue().contains(snapshotId)) {
import java.util.Collection;  
    public IndexMetaDataGenerations indexMetaDataGenerations() {
            snapshotIds,
        Map<SnapshotId, Map<String, String>> indexMetaLookup,
        for (IndexId indexId : indicesForSnapshot) {  
 * Licensed to Elasticsearch under one or more contributor  
                        }
            newGeneration,
        }
                final String identifier = indexMetaDataGenerations.indexMetaBlobId(snapshotId, indexId);
    /**  
        builder.endArray();  
import org.opensearch.common.Nullable;
        final ShardGenerations shardGenerations,  
    }  
            }
        return new RepositoryData(  
        builder.startObject();  
    /**
    private final Map<String, SnapshotId> snapshotIds;
                        break;  
        final SnapshotState snapshotState,
                                // different versions create or delete snapshot in the same repository.
     * @param parser           x-content parse
    public IndexId resolveIndexId(final String indexName) {
            .collect(Collectors.toMap(SnapshotId::getUUID, Function.identity()));  
            final List<SnapshotId> snapshotIds = allIndexSnapshots.get(indexId);  
                        version = Version.fromString(parser.text());
import org.opensearch.core.xcontent.XContentParser;
        Map<String, SnapshotState> snapshotStates,  
        return new RepositoryData(
    public XContentBuilder snapshotsToXContent(final XContentBuilder builder, final Version repoMetaVersion) throws IOException {  
    }
    }  
    /**  
     */  
        Map<IndexId, List<SnapshotId>> indexSnapshots,  
            final SnapshotId snapshotId = new SnapshotId(name, uuid);  
        // write the indices map
        Map<String, Version> newSnapshotVersions = new HashMap<>(snapshotVersions);
        final IndexMetaDataGenerations newIndexMetaGenerations;
     * @return New instance  
     * Gets the generational index file id from which this instance was read.
    /**
    /**  
            newIndexMetaGenerations
        final Map<String, Version> newVersions = new HashMap<>(snapshotVersions);
            if (snapshotIds.containsAll(existingIds)) {  
        Map<String, Version> snapshotVersions,
     * @param shardGenerations    shard generations builder that is populated index by this method
/**
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
                case MIN_VERSION:  
                builder.field(IndexId.SHARD_PATH_TYPE, indexId.getShardPathType());
        Map<String, String> indexMetaIdentifiers
            }  
                    // ignore min_version
     */  
     * @return index meta generations instance
     * NOTE: Does not return a mapping for {@link IndexId} values that will be removed completely from the repository.
            String uuid = null;
import java.io.IOException;
    public Version getVersion(SnapshotId snapshotId) {  
        snapshots.put(snapshotId.getUUID(), snapshotId);
 * SPDX-License-Identifier: Apache-2.0
        this.snapshotIds = snapshotIds;
    private static final String MIN_VERSION = "min_version";  
            + " but snapshots only reference indices "
        builder.field(INDEX_METADATA_IDENTIFIERS, indexMetaDataGenerations.identifiers);  
            // the new master, so we make the operation idempotent
            snapshotIds,
                                // the new format post 5.4.1 that only contains the snapshot uuid,
        }
            }
     * @param indexMetaIdentifiers map of index generation to index meta identifiers parsed by {@link #snapshotsFromXContent}
        final Map<String, Version> snapshotVersions = new HashMap<>();
        }  
            indexMetaDataGenerations.withRemovedSnapshots(snapshots)
            newSnapshotStates.remove(snapshotId.getUUID());  
        }
            genId,
        for (final IndexId indexId : indices.values()) {
                    // todo: remove in next version
            assert indexMetaDataGenerations.lookup.isEmpty() : "Index meta generations should have been empty but was ["
    }
    private final ShardGenerations shardGenerations;
     * The ids of the snapshots in the repository.  
        }  
            return IndexMetaDataGenerations.EMPTY;
    ) {  
     * Returns a map of {@link IndexId} to a collection of {@link String} containing all the {@link IndexId} and the
        RepositoryData that = (RepositoryData) obj;
    }
                forSnapshot.put(indexLookup.get(generationEntry.getKey()), generationEntry.getValue());  
     * Creates a copy of this instance that contains updated version data.  
    }  
            indices,
            }  
    }  
     *                                changed shard indexed by its shardId  
            snapshotStates,  
                                throw new OpenSearchParseException(
            List<SnapshotId> remaining = new ArrayList<>(snapshotIds);
 *
     * @param snapshots           map of snapshot uuid to {@link SnapshotId} that was populated by {@link #parseSnapshots}
        builder.endObject();
            if (UUID.equals(currentFieldName)) {  
        Map<String, IndexId> indexLookup,  
            snapshotStates,  
            Collections.unmodifiableMap(snapshotVersions),
            newIndexMetaGenerations = IndexMetaDataGenerations.EMPTY;
        if (snapshotIds.containsKey(snapshotId.getUUID())) {
        // write the snapshots list
            allIndexSnapshots,
        Collection<IndexId> indicesForSnapshot = indicesToUpdateAfterRemovingSnapshot(snapshotIds);
    }  
 * The OpenSearch Contributors require contributions made to  
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 */
                uuid = parser.text();
        for (final SnapshotId snapshot : getSnapshotIds()) {  
        return uuid;
            for (SnapshotId snapshotId : snapshotIds) {  
            // that is blocked from the cluster is trying to finalize a snapshot concurrently with  
 * Unless required by applicable law or agreed to in writing,
                case INDEX_METADATA_IDENTIFIERS:
                                // since we already have the name/uuid combo in the snapshots array
     */  
    private final long genId;
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
            switch (field) {
     */
    /**
            indexMetaDataGenerations
    public RepositoryData withVersions(Map<SnapshotId, Version> versions) {
     *
    @Override
                final List<SnapshotId> copy = new ArrayList<>(snapshotIds.size() + 1);
        newSnapshotVersions.put(snapshotId.getUUID(), version);  
     * Returns an unmodifiable collection of the snapshot ids.  
                    parseSnapshots(parser, snapshots, snapshotStates, snapshotVersions, indexMetaLookup);  
            shardGenerations,
     *                         {@link org.opensearch.cluster.metadata.IndexMetadata} in them  
     */  
        builder.startObject(INDICES);
                .putAll(shardGenerations)
    }
            indexGenerations.put(snapshotIdMapEntry.getKey(), forSnapshot);
            for (final SnapshotId snapshotId : snapshotIds) {  
                    + shardGenerations.indices()  
        if (snapshotIds == null) {
     * {@code shardGenerations}.
    private final IndexMetaDataGenerations indexMetaDataGenerations;
    }
@PublicApi(since = "1.0.0")
            snapshotStates,  
     *
    }
            Collections.unmodifiableMap(indexSnapshots),  
        Collections.emptyMap(),  
        List<SnapshotId> snapshotIds = indexSnapshots.get(indexId);
                    break;
            notFound.removeAll(snapshotIds.values());  
        final Map<IndexId, List<SnapshotId>> indexSnapshots = new HashMap<>();  
     */  
        return snapshotIndices;
        Map<String, String> indexMetaIdentifiers = null;
        String uuid = null;
            buildIndexMetaGenerations(indexMetaLookup, indexLookup, indexMetaIdentifiers)
     * @param snapshotId       Id of the new snapshot  
                            }  
        final Map<String, SnapshotId> snapshots = new HashMap<>();  
            genId,
            indexMetaDataGenerations
     * the repository.  
    public RepositoryData withGenId(long newGeneration) {
                }
     */
package org.opensearch.repositories;
     * Builds {@link IndexMetaDataGenerations} instance from the information parsed previously.
                builder.field(STATE, state.value());
                String parsedGen = gens.get(i);
                        state = SnapshotState.fromValue((byte) parser.intValue());
            builder.endObject();  
 */  
            newSnapshotStates,  
     */
            && indexSnapshots.equals(that.indexSnapshots)  
            if (indexId == null) {  
import org.opensearch.ResourceNotFoundException;
            Collections.unmodifiableMap(snapshotStates),  
        if (obj == null || getClass() != obj.getClass()) {
            return false;
                if (parsedGen != null) {  
     */
            indexSnapshots,
                    + indexMetaBlobs.keySet();
     */  
     * @param indexMetaLookup  map of {@link SnapshotId} to map of index id (as returned by {@link IndexId#getId}) that defines the index  
            final Collection<SnapshotId> existingIds = entry.getValue();
     *
        assert indexSnapshots.values().stream().noneMatch(snapshotIdList -> new HashSet<>(snapshotIdList).size() != snapshotIdList.size())
/*
                            } else {  
        return snapshotIds.values();  
            // if the snapshot id already exists in the repository data, it means an old master
    private static final String SNAPSHOTS = "snapshots";
            }
        Map<String, SnapshotId> snapshotIds,
            }
     * Returns the list of {@link IndexId} that have their snapshots updated but not removed (because they are still referenced by other  
        this.indexMetaDataGenerations = indexMetaDataGenerations;
        return snapshotStates.get(snapshotId.getUUID());  
                            gens.add(parser.textOrNull());
                                        + new IndexId(indexName, id, pathType)
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * repository's index blob.
     */
            assert id != null;  
     */
        Map<String, SnapshotState> newSnapshotStates = new HashMap<>(snapshotStates);  
            }
                switch (indexMetaFieldName) {  
            && indexMetaDataGenerations.equals(that.indexMetaDataGenerations);
                            final SnapshotId snapshotId = snapshots.get(uuid);  
     * Writes the snapshots metadata and the related indices metadata to x-content.
    /**
        return shardGenerations;
                parser.nextToken();
            throw new IllegalArgumentException("unknown snapshot index " + indexId);  
     * @return map of index to index metadata blob id to delete
        return genId;
            assert newIdentifiers == null : "Non-null new identifiers [" + newIdentifiers + "] for null lookup";
            snapshotIds,
            Collections.unmodifiableMap(snapshotIds),
        for (final IndexId indexId : shardGenerations.indices()) {
    }
            .collect(Collectors.toSet());
                    case NAME:
            indexSnapshots,  
    private static final String UUID = "uuid";  
     * @param inFlightIds      name to index mapping for currently in-flight snapshots not yet in the repository data to fall back to  
        return new RepositoryData(  
     */
        }
            IndexId indexId = null;  
            if (indexId == null) {  
            snapshotVersions,
                    case SHARD_GENERATIONS:
            if (version != null) {
        Map<IndexId, List<SnapshotId>> indexSnapshots = new HashMap<>();  
                + indexMetaDataGenerations  
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.nextToken(), parser);
        Map<String, SnapshotState> snapshotStates,  
            shardGenerations.build(),
                final XContentParser.Token currentToken = parser.nextToken();
        return snapshotIds;
    private final Map<String, SnapshotState> snapshotStates;  
        );
        if (newSnapshotIds.size() != snapshotIds.size() - snapshots.size()) {
                    return true;
     * @param snapshotVersions map of snapshot uuid to {@link Version} that the snapshot was taken in
            indexLookup.put(id, indexId);  
            builder.endObject();
    public static RepositoryData snapshotsFromXContent(XContentParser parser, long genId) throws IOException {  
    private static String parseLegacySnapshotUUID(XContentParser parser) throws IOException {
        return snapshotsToXContent(builder, repoMetaVersion, Version.V_2_17_0);
public final class RepositoryData {  
                        while ((currToken = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
     * The generation value indicating that the repository generation is unknown.
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
import java.util.stream.Collectors;  
        if (indexMetaBlobs == null) {  
     * @return List of indices that are changed but not removed
        );  
    public int hashCode() {  
        XContentParser parser,
        if (this == obj) {
            if (minNodeVersion.onOrAfter(Version.V_2_17_0)) {  
     * Resolve the given index names to index ids, creating new index ids for
    }  
                }  
     * The generational id of the index file from which the repository data was read.
        );  
                            if (snapshotId == null) {
 * ownership. Elasticsearch licenses this file to you under  
            .flatMap(e -> e.getValue().values().stream())
        Collections.emptyMap(),
            }
    /**
        builder.endObject();
        Map<String, SnapshotId> snapshots,
            builder.field(NAME, snapshot.getName());
            final List<SnapshotId> snapshotIds = new ArrayList<>();
                    case SNAPSHOTS:
            int pathType = IndexId.DEFAULT_SHARD_PATH_TYPE;
import org.opensearch.common.annotation.PublicApi;  
    protected RepositoryData copy() {
                        pathType = parser.intValue();
                                        + uuid  
     * @param snapshots               Snapshot ids to remove  
        @Nullable final Map<String, String> newIdentifiers
        return toRemove;
        Map<IndexId, List<SnapshotId>> indexSnapshots,  
     * Returns the {@link SnapshotState} for the given snapshot.  Returns {@code null} if
                .retainIndicesAndPruneDeletes(indexSnapshots.keySet())  
    public Map<IndexId, List<SnapshotId>> getIndexSnapshots() {  
        }
        newSnapshotStates.put(snapshotId.getUUID(), snapshotState);
            if (remaining.isEmpty() == false) {
     *                                The {@code String[]} passed for each {@link IndexId} contains the new shard generation id for each
     */
     * @param snapshotState    State of the new snapshot
    );
    ) throws IOException {  
            return false;
                : "Shard generations contained indices "
        Map<String, SnapshotId> snapshotIds,
                                    "Detected a corrupted repository, index "  
     * snapshots) after removing the given snapshot from the repository.
import java.util.Map;
 * KIND, either express or implied.  See the License for the
     * {@link #parseIndices} which will rely on the maps of snapshot properties to have been populated already.  
    public Map<IndexId, Collection<String>> indexMetaDataToRemoveAfterRemovingSnapshots(Collection<SnapshotId> snapshotIds) {  
                                // the list of snapshots. This can happen when multiple clusters in  
        }  
     * The generation value indicating the repository has no index generational files.  
     * The generation value indicating that the repository generation could not be determined.
    }
            final Map<IndexId, String> forSnapshot = new HashMap<>(val.size());
        Map<String, Version> snapshotVersions,
 * this file be licensed under the Apache-2.0 license or a
        Map<String, SnapshotState> snapshotStates,  
        this.shardGenerations = shardGenerations;  
    public XContentBuilder snapshotsToXContent(final XContentBuilder builder, final Version repoMetaVersion, final Version minNodeVersion)
                    case IndexId.SHARD_PATH_TYPE:
                    XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
            if (remaining.removeAll(snapshots)) {
            snapshots.put(uuid, snapshotId);
                builder.value(snapshotId.getUUID());
 * not use this file except in compliance with the License.
                builder.field(entry.getKey().getId(), entry.getValue());  
            builder.endArray();
        }
            shardGenerations,
        final ShardGenerations.Builder shardGenerations = ShardGenerations.builder();
            }  
                case SNAPSHOTS:
import java.util.Set;
            genId,
    ) throws IOException {  
                    XContentParserUtils.throwUnknownField(field, parser.getTokenLocation());  
     *                             index metadata generations for the snapshot that was parsed by {@link #parseSnapshots}
        final Map<String, String> stringDeduplicator = new HashMap<>();
            ShardGenerations.builder()  
    public List<IndexId> indicesToUpdateAfterRemovingSnapshot(Collection<SnapshotId> snapshotIds) {  
        return Objects.hash(
    /**
     * Resolve the index name to the index id specific to the repository,
 * this work for additional information regarding copyright
     * Reads an instance of {@link RepositoryData} from x-content, loading the snapshots and indices metadata.
/*  
            ShardGenerations.builder().putAll(this.shardGenerations).putAll(shardGenerations).build(),  
    public RepositoryData removeSnapshots(final Collection<SnapshotId> snapshots, final ShardGenerations updatedShardGenerations) {
        for (String index : indicesToResolve) {
        }
                        break;  
        IndexMetaDataGenerations indexMetaDataGenerations
     */
     * @param indexLookup          map of index uuid (as returned by {@link IndexId#getId}) to {@link IndexId} that was parsed by
    /**
            }  
        Map<String, SnapshotState> newSnapshotStates = new HashMap<>(snapshotStates);  
            .filter(e -> snapshotIds.contains(e.getKey()) == false)
        long genId,
        this.snapshotStates = snapshotStates;  
                indexId = inFlightIds.get(index);
     */
     *
        }
        );  
        for (final String indexName : indices) {
        builder.startArray(SNAPSHOTS);
    @Override
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
            builder.endArray();  
            return this;  
        final Map<SnapshotId, Map<String, String>> indexMetaLookup = new HashMap<>();  
                    case STATE:
                                uuid = parser.text();  
            final List<String> gens = new ArrayList<>();
        return new RepositoryData(
     * @param indexMetaBlobs   Map of index metadata blob uuids
                allIndexSnapshots.put(indexId, Collections.unmodifiableList(copy));
            builder.startObject();
     * @param snapshotIds SnapshotIds to remove  
            parser.nextToken();
        }  
        }
import java.util.Objects;  
    private final Map<IndexId, List<SnapshotId>> indexSnapshots;
                    toRemove.computeIfAbsent(indexId, k -> new HashSet<>()).add(identifier);
        List<IndexId> snapshotIndices = new ArrayList<>();  
     * Add a snapshot and its indices to the repository; returns a new instance.  If the snapshot  
                            snapshotIds.add(snapshotId);
                allIndexSnapshots.put(indexId, Collections.singletonList(snapshotId));
                snapshotVersions.put(uuid, version);
     * @param indexLookup         map of index uuid (as returned by {@link IndexId#getId}) to {@link IndexId}  
            if (state != null) {  
        return new IndexMetaDataGenerations(indexGenerations, indexMetaIdentifiers);
            snapshotVersions,
    public SnapshotState getSnapshotState(final SnapshotId snapshotId) {
                }
     * The indices found in the repository across all snapshots, as a name to {@link IndexId} mapping
        }
        final Map<IndexId, Collection<String>> toRemove = new HashMap<>();
     * @param versions map of snapshot versions
        Map<String, SnapshotId> snapshots,
    public RepositoryData(  
        } else {  
            return this;
    }  
            final Map<String, String> val = snapshotIdMapEntry.getValue();  
     * {@link org.opensearch.cluster.metadata.IndexMetadata} blob name in it that can be removed after removing the given snapshot from
 */
            newSnapshotVersions,
import java.util.Collections;
    }  
     * Shard generations.
    private static final String INDEX_ID = "id";
                indexMetaLookup.put(snapshotId, metaGenerations);  
            if (state != null) {
            snapshotVersions,
                                        + " references an unknown snapshot uuid ["
     */  
        ShardGenerations shardGenerations,  
    /**
                case INDICES:
        }
    private RepositoryData(  
        return snapshotVersions.get(snapshotId.getUUID());
import java.util.HashMap;
     */  
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_ARRAY, currentToken, parser);
     * The states of each snapshot in the repository.
        this(  
            return this;
        return new RepositoryData(  
        );
 * You may obtain a copy of the License at  
            String currentFieldName = parser.currentName();
    }
                switch (currentFieldName) {  
}  
    ) {  
            }  
                        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_ARRAY, currentToken, parser);
     * @return copy with updated version data
                    shardGenerations.put(indexId, i, parsedGen);
     * @param updatedShardGenerations Shard generations that changed as a result of removing the snapshot.
     * Remove snapshots and remove any indices that no longer exist in the repository due to the deletion of the snapshots.
            : "Found duplicate snapshot ids per index in [" + indexSnapshots + "]";
                }
            indexMetaDataGenerations
    /**  
            indexMetaDataGenerations
            assert indexMetaBlobs.isEmpty() || shardGenerations.indices().equals(indexMetaBlobs.keySet())
            for (Map.Entry<String, String> generationEntry : val.entrySet()) {
    }  
            } else {
            && shardGenerations.equals(that.shardGenerations)
 * compatible open source license.
            List<SnapshotId> snapshotIds = indexSnapshots.get(indexId);
 * software distributed under the License is distributed on an
                builder.value(gen);  
    ) {
        Map<String, Version> snapshotVersions,
            newSnapshotStates,  
    }
                    case INDEX_ID:
        return indices;
    public List<IndexId> resolveIndices(final List<String> indices) {
            newSnapshotVersions.remove(snapshotId.getUUID());
     *
 * @opensearch.api  
        return Objects.requireNonNull(indices.get(indexName), () -> "Tried to resolve unknown index [" + indexName + "]");
        if (indexMetaLookup.isEmpty()) {  
            Map<String, String> metaGenerations = null;
            indices,
    }
    /**
        final SnapshotId snapshotId,  
import org.opensearch.snapshots.SnapshotState;
        }
                        }
import java.util.function.Function;
                                        + "]"
     *                         generations indexed by the shard id they correspond to must be supplied.  
 *
        final Map<String, SnapshotState> snapshotStates = new HashMap<>();
        }).map(Map.Entry::getKey).collect(Collectors.toList());  
        final Map<String, IndexId> indexLookup = new HashMap<>();
        return indexMetaDataGenerations;  
        ShardGenerations shardGenerations,
        }  
 */  
                builder.field(VERSION, version.toString());
    /**
    /**  
            final Version version = snapshotVersions.get(snapshotUUID);  
            builder.startArray(SNAPSHOTS);  
     * Create a new instance with the given generation and all other fields equal to this instance.  
        long genId,
            builder.field(UUID, snapshotUUID);
     *
     */
            }
    public List<IndexId> resolveNewIndices(List<String> indicesToResolve, Map<String, IndexId> inFlightIds, int pathType) {
        ShardGenerations.Builder shardGenerations
            builder.startObject(INDEX_METADATA_LOOKUP);  
    private static final String INDICES = "indices";  
            }
        while (parser.nextToken() == XContentParser.Token.FIELD_NAME) {
 * license agreements. See the NOTICE file distributed with
        );  
    /**
    /**  
     * @param newIdentifiers   Map of new index metadata blob uuids keyed by the identifiers of the
                final String indexMetaFieldName = parser.currentName();
            String name = null;
