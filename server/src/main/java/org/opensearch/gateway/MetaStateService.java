            if (indexMetadata != null) {
    private Tuple<Manifest, Metadata> loadFullStateBWC() throws IOException {
    }
                logger,
    }
        Manifest manifest = MANIFEST_FORMAT.loadLatestState(logger, namedXContentRegistry, nodeEnv.nodeDataPaths());
            );
        Metadata globalMetadata = metadataAndGeneration.v1();
        METADATA_FORMAT.cleanupOldFiles(Long.MAX_VALUE, nodeEnv.nodeDataPaths());
    protected MetadataStateFormat<Manifest> MANIFEST_FORMAT = Manifest.FORMAT;
     *
     * Removes old state files in index directory.
        final Metadata.Builder metadataBuilder;
            assert Version.CURRENT.major < 8 : "failed to find manifest file, which is mandatory staring with OpenSearch version 1.0.0";
        final IndexGraveyard indexGraveyard;
 * Modifications Copyright OpenSearch Contributors. See
            MetadataStateFormat.deleteMetaState(nodeEnv.resolveIndexFolder(indexFolderName));
            IndexMetadata indexMetadata = indexMetadataAndGeneration.v1();
        MANIFEST_FORMAT.writeAndCleanup(Manifest.empty(), nodeEnv.nodeDataPaths()); // write empty file so that indices become unreferenced
        INDEX_METADATA_FORMAT.cleanupOldFiles(currentGeneration, nodeEnv.indexPaths(index));
 * compatible open source license.
     * @param currentGeneration current state generation to keep in the index directory.
 * specific language governing permissions and limitations
     * <p>
     * @throws WriteStateException if exception when writing state occurs. {@link WriteStateException#isDirty()} will always return
    // we allow subclasses in tests to redefine formats, e.g. to inject failures
                metadataBuilder.put(indexMetadata, false);
            IndexMetadata indexMetadata = INDEX_METADATA_FORMAT.loadLatestState(
    public void cleanupIndex(Index index, long currentGeneration) {
                generation,
     * @throws WriteStateException if exception when writing state occurs. See also {@link WriteStateException#isDirty()}
    private final NodeEnvironment nodeEnv;
/*
                        + indexFolderName
     */
import org.apache.logging.log4j.Logger;
 * license agreements. See the NOTICE file distributed with
    /**
        this.nodeEnv = nodeEnv;
                    metadataBuilder.put(indexMetadata, false);
    /**
package org.opensearch.gateway;
            long generation = INDEX_METADATA_FORMAT.write(indexMetadata, nodeEnv.indexPaths(indexMetadata.getIndex()));
        }
        // To ensure that the metadata is never reimported by loadFullStateBWC in case where the deletions here fail mid-way through,
    /**
     * @throws IOException if some IOException when loading files occurs or there is no metadata referenced by manifest file.
    Metadata loadGlobalState() throws IOException {
     */
                        + "]"
            metadataBuilder = Metadata.builder();
            logger,
        return INDEX_METADATA_FORMAT.loadLatestState(logger, namedXContentRegistry, nodeEnv.indexPaths(index));
        }
                namedXContentRegistry,
    private final NamedXContentRegistry namedXContentRegistry;
        this.namedXContentRegistry = namedXContentRegistry;
     *
            final IndexMetadata indexMetadata = INDEX_METADATA_FORMAT.loadGeneration(
     */
        MANIFEST_FORMAT.cleanupOldFiles(Long.MAX_VALUE, nodeEnv.nodeDataPaths()); // finally delete manifest
    }
     */
                + " which should have been excluded";
     */
                } else {
import org.opensearch.cluster.metadata.IndexGraveyard;
            } else {
     * Writes the index state.
                    // this index folder is cleared up when state is recovered
            throw new WriteStateException(ex.isDirty(), "[_meta]: failed to write meta state", ex);
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
     * This method is public for testing purposes.
        }
            namedXContentRegistry,
                + indexFolderName
        }
            indexGraveyard = globalMetadata.custom(IndexGraveyard.TYPE);
import java.util.ArrayList;
        }
/*
                        + generation
        for (String indexFolderName : nodeEnv.availableIndexFolders()) {
     * the write succeeds or newly created manifest state if the write fails.
    }
                nodeEnv.nodeDataPaths()
            long generation = indexMetadataAndGeneration.v2();
     */
            nodeEnv.nodeDataPaths()
        }
    }
                if (indexFolderName.equals(indexPathId)) {
     */
     * meta state with globalGeneration -1 and empty meta data is returned.
            final String indexFolderName = index.getUUID();
 */
import org.opensearch.cluster.metadata.IndexMetadata;
        Map<Index, Long> indices = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
        } catch (WriteStateException ex) {
        }
                );
            throw new WriteStateException(false, "[_global]: failed to write global state", ex);
import org.opensearch.Version;
 * under the License.
        return METADATA_FORMAT.loadLatestState(logger, namedXContentRegistry, nodeEnv.nodeDataPaths());
     * Removes old state files in global state directory.
import org.opensearch.cluster.metadata.Manifest;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.Nullable;
        Tuple<Metadata, Long> metadataAndGeneration = METADATA_FORMAT.loadLatestStateWithGeneration(
            return generation;
 * not use this file except in compliance with the License.
     */
/*
        if (manifest == null) {
            final Metadata globalMetadata = METADATA_FORMAT.loadGeneration(
        // the manifest file.
        final Manifest manifest = MANIFEST_FORMAT.loadLatestState(logger, namedXContentRegistry, nodeEnv.nodeDataPaths());
import org.opensearch.cluster.metadata.Metadata;
        }
     * @param currentGeneration current state generation to keep in the directory.
        } catch (WriteStateException ex) {
 * Licensed to Elasticsearch under one or more contributor
import java.util.Map;
 * this work for additional information regarding copyright
    }
     * Loads all indices states available on disk
     * (only used for dangling indices at that point).
     * @return tuple of {@link Manifest} and {@link Metadata} with global metadata and indices metadata. If there is no state on disk,
     * Loads the global state, *without* index state, see {@link #loadFullState()} for that.
 *
        }
        }
     * If there is no manifest file on disk, this method fallbacks to BWC mode, where latest generation of global and indices
        );
     */
            indexGraveyard = IndexGraveyard.builder().build();
    }
        } else {
            long generation = METADATA_FORMAT.write(metadata, nodeEnv.nodeDataPaths());
     * Loads the full state, which includes both the global state and all the indices meta data. <br>
    long writeGlobalState(String reason, Metadata metadata) throws WriteStateException {
 *
 *
        logger.trace("[{}] writing state, reason [{}]", index, reason);
    public MetaStateService(NodeEnvironment nodeEnv, NamedXContentRegistry namedXContentRegistry) {
            if (indexMetadata != null) {
            logger.trace("[{}] state written", index);
    public Manifest loadManifestOrEmpty() throws IOException {
                logger.debug("[{}] failed to find metadata for existing index location", indexFolderName);
        if (globalMetadata != null) {
                manifest.getGlobalGeneration(),
            final Index index = entry.getKey();
    public IndexMetadata loadIndexState(Index index) throws IOException {
     * Loads the index state for the provided index name, returning null if doesn't exists.
                nodeEnv.resolveIndexFolder(indexFolderName)
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to
import java.util.HashMap;
        return new Tuple<>(manifest, metadataBuilder.build());
     * @param index             index to perform clean up on.
                throw new IOException(
import org.apache.logging.log4j.LogManager;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        try {
    void cleanupGlobalState(long currentGeneration) {
            metadataBuilder = Metadata.builder();
    }
        } else {
            } else {
     * Removes manifest file, global metadata and all index metadata
            logger.trace("[_meta] state written (generation: {})", generation);
     */
        logger.trace("[_global] writing state, reason [{}]", reason);
    public long writeIndex(String reason, IndexMetadata indexMetadata) throws WriteStateException {
                } else {
                }
}
    }
                metadataBuilder = Metadata.builder(globalMetadata);
        try {
 */
    }
import java.util.List;
        }
                logger,
     *
    /**
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    @Nullable
import org.opensearch.env.NodeEnvironment;
            );
                nodeEnv.resolveIndexFolder(indexFolderName)
        return manifest;
            } else {
    }
                final String indexPathId = indexMetadata.getIndex().getUUID();
 * You may obtain a copy of the License at
    /**
    /**
    private static final Logger logger = LogManager.getLogger(MetaStateService.class);
 * GitHub history for details.
                        + index.getName()
        // we first write an empty manifest file so that the indices become unreferenced, then clean up the indices, and only then delete
    /**
     * Creates empty cluster state file on disk, deleting global metadata and unreferencing all index metadata
                    logger.debug("[{}] found metadata for deleted index [{}]", indexFolderName, indexMetadata.getIndex());
            logger.trace("[_global] state written");
            manifest = Manifest.empty();
import org.opensearch.core.index.Index;
     *
            }
 */
     * file was not yet created. It means that this method always fallbacks to BWC mode, if there is no manifest file.
        for (String indexFolderName : nodeEnv.availableIndexFolders()) {
        if (manifest == null) {
public class MetaStateService {
                namedXContentRegistry,
     * Writes manifest file (represented by {@link Manifest}) to disk and performs cleanup of old manifest state file if
        if (manifest.isGlobalGenerationMissing()) {
            assert Version.CURRENT.major < 8 : "failed to find manifest file, which is mandatory staring with OpenSearch version 1.0.0";
                    "failed to find metadata for existing index "
    public void unreferenceAll() throws IOException {
        for (Map.Entry<Index, Long> entry : manifest.getIndexGenerations().entrySet()) {
                logger.debug("[{}] failed to find metadata for existing index location", indexFolderName);
 * the Apache License, Version 2.0 (the "License"); you may
    protected MetadataStateFormat<IndexMetadata> INDEX_METADATA_FORMAT = IndexMetadata.FORMAT;
            return generation;
            throw new WriteStateException(false, "[" + index + "]: failed to write index state", ex);
     *
     */
    /**
            // delete meta state directories of indices
        METADATA_FORMAT.cleanupOldFiles(currentGeneration, nodeEnv.nodeDataPaths());
 * Unless required by applicable law or agreed to in writing,
                    indices.put(indexMetadata.getIndex(), generation);
                        + " [location: "
            );
    }
        Manifest manifest = Manifest.unknownCurrentTermAndVersion(globalStateGeneration, indices);
    }
    /**
        return new Tuple<>(manifest, metadataBuilder.build());
                namedXContentRegistry,
     * metadata is loaded. Please note that currently there is no way to distinguish between manifest file being removed and manifest
    public void writeManifestAndCleanup(String reason, Manifest manifest) throws WriteStateException {
     * Writes the global state, *without* the indices states.
        unreferenceAll();
/**
            metadataBuilder = Metadata.builder(globalMetadata);
     * When loading, manifest file is consulted (represented by {@link Manifest} class), to load proper generations. <br>
            if (globalMetadata != null) {
        long globalStateGeneration = metadataAndGeneration.v2();
            assert excludeIndexPathIdsPredicate.test(indexFolderName) == false : "unexpected folder "
            long generation = MANIFEST_FORMAT.writeAndCleanup(manifest, nodeEnv.nodeDataPaths());
                    throw new IllegalStateException("[" + indexFolderName + "] invalid index folder name, rename to [" + indexPathId + "]");
            );
                    indexMetadataList.add(indexMetadata);
 * this file be licensed under the Apache-2.0 license or a
        final Index index = indexMetadata.getIndex();
    protected MetadataStateFormat<Metadata> METADATA_FORMAT = Metadata.FORMAT;
import org.opensearch.common.collect.Tuple;
    List<IndexMetadata> loadIndicesStates(Predicate<String> excludeIndexPathIdsPredicate) throws IOException {
    /**
                }
                nodeEnv.resolveIndexFolder(indexFolderName)
                throw new IOException("failed to find global metadata [generation: " + manifest.getGlobalGeneration() + "]");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
            Tuple<IndexMetadata, Long> indexMetadataAndGeneration = INDEX_METADATA_FORMAT.loadLatestStateWithGeneration(
                logger,
     *
     *                             false, because new index state file is not yet referenced by manifest file.
     */
import java.io.IOException;
            }
     * "Manifest-less" BWC version of loading metadata from disk. See also {@link #loadFullState()}
import java.util.function.Predicate;
                if (indexGraveyard.containsIndex(indexMetadata.getIndex())) {
        try {
                namedXContentRegistry,
            final long generation = entry.getValue();
 * Handles writing and loading {@link Manifest}, {@link Metadata} and {@link IndexMetadata}
    public void deleteAll() throws IOException {
                        + ", generation: "
            }
        List<IndexMetadata> indexMetadataList = new ArrayList<>();
    }
        logger.trace("[_meta] writing state, reason [{}]", reason);
        Metadata.Builder metadataBuilder;
                logger,
        for (String indexFolderName : nodeEnv.availableIndexFolders(excludeIndexPathIdsPredicate)) {
     * @throws WriteStateException if exception when writing state occurs. {@link WriteStateException#isDirty()} will always return
            } else {
     *                             false, because new global state file is not yet referenced by manifest file.
     */
    /**
        return indexMetadataList;
     * Loads Manifest file from disk, returns <code>Manifest.empty()</code> if there is no manifest file.
        } catch (WriteStateException ex) {
            return loadFullStateBWC();
 */
 *
            if (indexMetadata != null) {
    /**
    public Tuple<Manifest, Metadata> loadFullState() throws IOException {
