                    "location [" + location + "] doesn't match any of the locations specified by path.repo"
        final String location = REPOSITORIES_LOCATION_SETTING.get(getMetadata().settings());
        } else {
                    "base_path [" + basePath + "] resolves to a location outside of the repository paths specified by path.repo"
                throw new RepositoryException(
     * (the {@code /_snapshot/<repo>/_cleanup} arbitrary-deletion vector).
        NativeRemoteObjectStoreProvider nativeStoreProvider
import org.opensearch.core.common.Strings;
import org.opensearch.indices.recovery.RecoverySettings;
        final String location = REPOSITORIES_LOCATION_SETTING.get(metadata.settings());
        for (Path repoPath : environment.repoFiles()) {
    protected ByteSizeValue chunkSize;
     * validator already rejects absolute and upward-escaping values; this location-aware check is the authoritative
import java.util.ArrayList;
        restrictedSettings.add(LOCATION_SETTING);
        super(metadata, namedXContentRegistry, clusterService, recoverySettings);
        final Path resolved = locationFile.resolve(basePath).normalize();
 * Modifications Copyright OpenSearch Contributors. See
    }
     * {@code location}, still falls within one of the operator-configured {@code path.repo} directories. The setting
        new ByteSizeValue(Long.MAX_VALUE),
                    location,
            return false;
        return nativeStore;
    public List<Setting<?>> getRestrictedSystemRepositorySettings() {
                    "location [" + location + "] doesn't match any of the locations specified by path.repo because this setting is empty"
 * GitHub history for details.
    );
/*
        if (locationFile == null) {
        validateLocation();
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        // containment; a ".." segment lets the resolved path climb above it. The authoritative, location-aware
    });
            if (resolved.startsWith(repoPath)) {
        new ByteSizeValue(Long.MAX_VALUE),
        super.doClose();
 * Shared file system repository supports the following settings
 * <dt>{@code concurrent_streams}</dt><dd>Number of concurrent read/write stream (per repository on each node). Defaults to 5.</dd>
        }
        Environment environment,
        RecoverySettings recoverySettings
    public static final Setting<ByteSizeValue> CHUNK_SIZE_SETTING = Setting.byteSizeSetting(
            if (isUnderRepo(basePath) == false) {
    protected ByteSizeValue chunkSize() {
        Environment environment,
        return restrictedSettings;
                    environment.repoFiles()
    /**
                        + " the path.repo setting, but the path.repo setting was not set on this node",
 * You may obtain a copy of the License at
 *
/*
 * KIND, either express or implied.  See the License for the
 * <dt>{@code chunk_size}</dt><dd>Large file can be divided into chunks. This parameter specifies the chunk size.
import org.opensearch.common.blobstore.BlobStore;
                throw new RepositoryException(
                return true;
     * Constructs a shared file system repository.
 *
            if (store != null && store.isLive()) {
    }
    @Override
            this.chunkSize = CHUNK_SIZE_SETTING.get(metadata.settings());
 *
import org.opensearch.env.Environment;
                    metadata.name(),
public class FsRepository extends BlobStoreRepository {
 *
        }
        Path locationFile = environment.resolveRepoFile(location);
        return new FsBlobStore(bufferSize, locationFile, isReadOnly());
import org.apache.logging.log4j.LogManager;
            throw new RepositoryException(metadata.name(), "missing location");
        RepositoryMetadata metadata,
    /**
 * The OpenSearch Contributors require contributions made to
        new ByteSizeValue(5),
    public static final String TYPE = "fs";
    }
 * software distributed under the License is distributed on an
import org.opensearch.common.blobstore.BlobPath;
        final Path locationFile = environment.resolveRepoFile(location);
package org.opensearch.repositories.fs;
            } else if (store != null && store != NativeStoreRepository.EMPTY) {
        "repositories.fs.compress",
 * Licensed to Elasticsearch under one or more contributor
 * ownership. Elasticsearch licenses this file to you under
        new ByteSizeValue(Long.MAX_VALUE),
    }
                    "The specified location [{}] doesn't start with any " + "repository paths specified by the path.repo setting: [{}] ",
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        Property.NodeScope
            }
        } else {
            // location is already validated by validateLocation(); a null here is treated as a containment failure.
    protected void validateLocation() {
    public FsRepository(
    protected BlobPath basePath;
import org.opensearch.common.blobstore.fs.FsBlobStore;
    }
        // Initialize native store if provider is available (sandbox warm nodes only)
    @Override
     * validator: ensures the user-supplied {@code base_path}, once resolved against the already-validated repository
     * discard the validated location entirely and redirect all blob-store operations to an arbitrary filesystem path
        final String basePath = BASE_PATH_SETTING.get(metadata.settings());
            this.basePath = BlobPath.cleanPath();
/*
        this.environment = environment;
 *      Defaults to not chucked.</dd>
 * @opensearch.internal
        "chunk_size",
 */
 * compatible open source license.
     * @param nativeStoreProvider native FS store factory from sandbox, or null
        RecoverySettings recoverySettings,
        }
                );
 * Unless required by applicable law or agreed to in writing,
     * Defense-in-depth containment check (CWE-22) that complements the {@link #BASE_PATH_SETTING} setting-level
        }
        Property.Deprecated
import org.opensearch.core.common.unit.ByteSizeValue;
                    metadata.name(),
import java.util.function.Function;
import java.util.List;
            );
                );
        if (Strings.hasLength(value)
        this(metadata, environment, namedXContentRegistry, clusterService, recoverySettings, null);
    }
        if (locationFile == null) {
        NamedXContentRegistry namedXContentRegistry,
            && (value.startsWith("/") || value.startsWith("\\") || value.matches("^[A-Za-z]:.*") || value.contains(".."))) {
            } else {
    }
     */
     *
 * not use this file except in compliance with the License.
import org.opensearch.repositories.RepositoryException;
}
     */
import org.opensearch.repositories.NativeStoreRepository;
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
    protected final Environment environment;
                    + " that is available on all cluster-manager and data nodes"
import org.opensearch.common.settings.Setting;
 * the Apache License, Version 2.0 (the "License"); you may
        new ByteSizeValue(Long.MAX_VALUE),
                );
        String location = REPOSITORIES_LOCATION_SETTING.get(metadata.settings());
                    metadata.name(),
        RepositoryMetadata metadata,
import org.apache.logging.log4j.Logger;
     * repo type (not a plugin). The native provider is passed from
        // containment check is performed in validateBasePathWithinRepo().
        if (CHUNK_SIZE_SETTING.exists(metadata.settings())) {
 */
/**
    ) {
 * this work for additional information regarding copyright
import org.opensearch.cluster.metadata.RepositoryMetadata;
 * SPDX-License-Identifier: Apache-2.0
    public static final Setting<ByteSizeValue> REPOSITORIES_CHUNK_SIZE_SETTING = Setting.byteSizeSetting(
        List<Setting<?>> restrictedSettings = new ArrayList<>();
    @Override
    @Override
 * <dt>{@code location}</dt><dd>Path to the root of repository. This is mandatory parameter.</dd>
     * {@link org.opensearch.repositories.RepositoriesModule} which discovers it
 */
        Property.NodeScope
        NamedXContentRegistry namedXContentRegistry,
    protected void readMetadata() {
            }
        // CWE-22 hardening (string-only fail-fast; avoids constructing a Path from a raw user-supplied string):
                    "The specified location [{}] should start with a repository path specified by"
    private static final Logger logger = LogManager.getLogger(FsRepository.class);
                );
        restrictedSettings.addAll(super.getRestrictedSystemRepositorySettings());
        Function.identity(),
        if (location.isEmpty()) {
            final NativeStoreRepository store = nativeStoreProvider.createNativeStore(metadata, clusterService.getSettings());
    private volatile NativeStoreRepository nativeStore = NativeStoreRepository.EMPTY;
        ClusterService clusterService,
        // reject absolute base_path values (POSIX "/", Windows "\\"/UNC, drive-letter "C:..") and any parent-directory
 * <dl>
    }
        if (Strings.hasLength(basePath)) {
        nativeStore.close();
    public static final Setting<String> REPOSITORIES_LOCATION_SETTING = new Setting<>(
        return chunkSize;
    /** Native (Rust) object store — created during construction if native provider is available. */
    public NativeStoreRepository getNativeStore() {
        new ByteSizeValue(5),
                this.nativeStore = store;
        // ("..") segment. An absolute base_path makes Path.resolve discard the path.repo-validated location, escaping
                "[base_path] must be a relative path that does not contain '..' segments; got [" + value + "]"
            this.basePath = new BlobPath().add(basePath);
 */
import org.opensearch.cluster.service.ClusterService;
    public FsRepository(
        }
        }
 * Shared file system implementation of the BlobStoreRepository
            );
        }
    /**
        ClusterService clusterService,
import java.nio.file.Path;
 * </dl>
        "repositories.fs.location",
    );
 * license agreements. See the NOTICE file distributed with
        final Path locationFile = environment.resolveRepoFile(location);
                logger.warn(
     * {@link org.opensearch.plugins.ExtensiblePlugin}, FsRepository is a built-in
     *
    );
    }
    protected void doClose() {
                    location
    );
    @Override
    }
    public BlobPath basePath() {
    public static final Setting<String> LOCATION_SETTING = new Setting<>("location", "", Function.identity(), Property.NodeScope);
            if (environment.repoFiles().length > 0) {
    @Override
                logger.warn(
    public static final Setting<String> BASE_PATH_SETTING = Setting.simpleString("base_path", value -> {
     * <p>Unlike S3/GCS/Azure repos which discover their native provider via
        Property.NodeScope,
import org.opensearch.common.settings.Setting.Property;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                );
        "repositories.fs.chunk_size",
            logger.warn(
                throw new RepositoryException(
        if (nativeStoreProvider != null) {
 * under the License.
                store.close();
     * backstop. Without containment, an absolute {@code base_path} would cause {@link java.nio.file.Path#resolve} to
    ) {
        LOCATION_SETTING,
        return basePath;
 * <p>
    private boolean isUnderRepo(String basePath) {
        readMetadata();
            this.chunkSize = REPOSITORIES_CHUNK_SIZE_SETTING.get(environment.settings());
     * Constructs a shared file system repository with optional native store provider.
 * specific language governing permissions and limitations
     */
    protected BlobStore createBlobStore() throws Exception {
            throw new IllegalArgumentException(
    public static final Setting<Boolean> REPOSITORIES_COMPRESS_SETTING = Setting.boolSetting(
            }
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * via {@code filterPlugins(NativeRemoteObjectStoreProvider.class)} in Node.java.
        return false;
            }
        Property.NodeScope
        }
        false,
                "the repository location is missing, it should point to a shared file system location"
