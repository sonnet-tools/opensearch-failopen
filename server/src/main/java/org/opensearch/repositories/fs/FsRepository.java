        if (nativeStoreProvider != null) {  
                        + " the path.repo setting, but the path.repo setting was not set on this node",
        NamedXContentRegistry namedXContentRegistry,
    public static final Setting<String> REPOSITORIES_LOCATION_SETTING = new Setting<>(
        final Path resolved = locationFile.resolve(basePath).normalize();
        } else {
        Property.NodeScope,
        this(metadata, environment, namedXContentRegistry, clusterService, recoverySettings, null);
        if (Strings.hasLength(basePath)) {
        return basePath;
 * SPDX-License-Identifier: Apache-2.0
    }
            this.basePath = new BlobPath().add(basePath);  
        super(metadata, namedXContentRegistry, clusterService, recoverySettings);  
    ) {
            final NativeStoreRepository store = nativeStoreProvider.createNativeStore(metadata, clusterService.getSettings());
    public FsRepository(
    /**  
        if (CHUNK_SIZE_SETTING.exists(metadata.settings())) {
        return restrictedSettings;
 * specific language governing permissions and limitations
        RecoverySettings recoverySettings,  
                );
import org.opensearch.common.blobstore.BlobPath;
    protected final Environment environment;
import org.opensearch.repositories.RepositoryException;
        ClusterService clusterService,
     * via {@code filterPlugins(NativeRemoteObjectStoreProvider.class)} in Node.java.  
    public FsRepository(
 *
                    "location [" + location + "] doesn't match any of the locations specified by path.repo because this setting is empty"  
        // Initialize native store if provider is available (sandbox warm nodes only)
    public static final Setting<Boolean> REPOSITORIES_COMPRESS_SETTING = Setting.boolSetting(
        for (Path repoPath : environment.repoFiles()) {
        // CWE-22 hardening (string-only fail-fast; avoids constructing a Path from a raw user-supplied string):  
                "the repository location is missing, it should point to a shared file system location"
        // ("..") segment. An absolute base_path makes Path.resolve discard the path.repo-validated location, escaping
    }
    }
        new ByteSizeValue(Long.MAX_VALUE),
        Environment environment,  
                );
/**
    }
    public List<Setting<?>> getRestrictedSystemRepositorySettings() {  
        Property.NodeScope
     */
                throw new RepositoryException(
    private volatile NativeStoreRepository nativeStore = NativeStoreRepository.EMPTY;
import org.opensearch.env.Environment;
 */  
            this.chunkSize = REPOSITORIES_CHUNK_SIZE_SETTING.get(environment.settings());
/*
        "repositories.fs.location",  
 * not use this file except in compliance with the License.
                    + " that is available on all cluster-manager and data nodes"  
        List<Setting<?>> restrictedSettings = new ArrayList<>();
        restrictedSettings.add(LOCATION_SETTING);  
                    location,  
            && (value.startsWith("/") || value.startsWith("\\") || value.matches("^[A-Za-z]:.*") || value.contains(".."))) {  
import org.opensearch.core.common.Strings;
    public static final Setting<ByteSizeValue> CHUNK_SIZE_SETTING = Setting.byteSizeSetting(
import org.apache.logging.log4j.LogManager;
            this.basePath = BlobPath.cleanPath();
        new ByteSizeValue(Long.MAX_VALUE),
 * KIND, either express or implied.  See the License for the
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;  
    }
        NativeRemoteObjectStoreProvider nativeStoreProvider
        super.doClose();
     */  
    ) {
        Property.NodeScope
 * You may obtain a copy of the License at  
        Property.Deprecated
     * {@code location}, still falls within one of the operator-configured {@code path.repo} directories. The setting  
        final String location = REPOSITORIES_LOCATION_SETTING.get(getMetadata().settings());
                );  
     *
 * <dt>{@code location}</dt><dd>Path to the root of repository. This is mandatory parameter.</dd>  
        Path locationFile = environment.resolveRepoFile(location);
     * Constructs a shared file system repository with optional native store provider.  
        final String basePath = BASE_PATH_SETTING.get(metadata.settings());
                    environment.repoFiles()
     * {@link org.opensearch.plugins.ExtensiblePlugin}, FsRepository is a built-in  
package org.opensearch.repositories.fs;
     * discard the validated location entirely and redirect all blob-store operations to an arbitrary filesystem path  
    @Override
        Property.NodeScope  
    protected BlobPath basePath;
        final Path locationFile = environment.resolveRepoFile(location);
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ClusterService clusterService,
 * under the License.  
        false,  
        new ByteSizeValue(5),  
        Function.identity(),
    protected BlobStore createBlobStore() throws Exception {
            );  
        // containment; a ".." segment lets the resolved path climb above it. The authoritative, location-aware  
    }  
        RecoverySettings recoverySettings  
            if (store != null && store.isLive()) {
        "repositories.fs.compress",
            this.chunkSize = CHUNK_SIZE_SETTING.get(metadata.settings());  
        } else {
    @Override
    public static final Setting<String> BASE_PATH_SETTING = Setting.simpleString("base_path", value -> {
     * Defense-in-depth containment check (CWE-22) that complements the {@link #BASE_PATH_SETTING} setting-level
            // location is already validated by validateLocation(); a null here is treated as a containment failure.
                throw new RepositoryException(
            } else {
import org.apache.logging.log4j.Logger;
 * Shared file system repository supports the following settings
            if (resolved.startsWith(repoPath)) {  
     * @param nativeStoreProvider native FS store factory from sandbox, or null
        }  
     * validator already rejects absolute and upward-escaping values; this location-aware check is the authoritative
    public NativeStoreRepository getNativeStore() {
        final String location = REPOSITORIES_LOCATION_SETTING.get(metadata.settings());
    protected void validateLocation() {
        }  
            );
                    "The specified location [{}] should start with a repository path specified by"  
        validateLocation();
        }  
    );
 *
        RepositoryMetadata metadata,
import java.nio.file.Path;
            } else if (store != null && store != NativeStoreRepository.EMPTY) {
    protected void doClose() {
                return true;
 *  
        String location = REPOSITORIES_LOCATION_SETTING.get(metadata.settings());
        if (locationFile == null) {
    }
        restrictedSettings.addAll(super.getRestrictedSystemRepositorySettings());
 *      Defaults to not chucked.</dd>  
            }
    );  
import java.util.function.Function;
 * <dl>
                throw new RepositoryException(  
 * GitHub history for details.
 */
            throw new IllegalArgumentException(
    @Override  
        // reject absolute base_path values (POSIX "/", Windows "\\"/UNC, drive-letter "C:..") and any parent-directory
 * Licensed to Elasticsearch under one or more contributor  
        RepositoryMetadata metadata,
 * Unless required by applicable law or agreed to in writing,
/*  
/*  
    }  
    private static final Logger logger = LogManager.getLogger(FsRepository.class);  
}
        LOCATION_SETTING,
        // containment check is performed in validateBasePathWithinRepo().
        NamedXContentRegistry namedXContentRegistry,
     * validator: ensures the user-supplied {@code base_path}, once resolved against the already-validated repository
 * The OpenSearch Contributors require contributions made to  
 */  
 *
        return chunkSize;  
 * this work for additional information regarding copyright
                "[base_path] must be a relative path that does not contain '..' segments; got [" + value + "]"
            }
            }  
        new ByteSizeValue(5),
                this.nativeStore = store;  
        new ByteSizeValue(Long.MAX_VALUE),
        Environment environment,  
    @Override
import org.opensearch.indices.recovery.RecoverySettings;
                logger.warn(
        final Path locationFile = environment.resolveRepoFile(location);  
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
 * this file be licensed under the Apache-2.0 license or a
                    "The specified location [{}] doesn't start with any " + "repository paths specified by the path.repo setting: [{}] ",
        if (location.isEmpty()) {  
    @Override  
    );  
            return false;
                    metadata.name(),
    protected void readMetadata() {
                    metadata.name(),
        }  
     *
     * {@link org.opensearch.repositories.RepositoriesModule} which discovers it
import org.opensearch.core.common.unit.ByteSizeValue;
 * the Apache License, Version 2.0 (the "License"); you may
                    metadata.name(),
public class FsRepository extends BlobStoreRepository {
    public static final String TYPE = "fs";
        "chunk_size",  
 * <dt>{@code chunk_size}</dt><dd>Large file can be divided into chunks. This parameter specifies the chunk size.
                store.close();
        return false;
 * compatible open source license.
            if (environment.repoFiles().length > 0) {  
    }
        new ByteSizeValue(Long.MAX_VALUE),  
 * <p>  
 * license agreements. See the NOTICE file distributed with
        if (locationFile == null) {  
     * repo type (not a plugin). The native provider is passed from
            }
        nativeStore.close();  
 * Shared file system implementation of the BlobStoreRepository
    /**
                    location
        "repositories.fs.chunk_size",
    );
    /**
                    "base_path [" + basePath + "] resolves to a location outside of the repository paths specified by path.repo"  
                    "location [" + location + "] doesn't match any of the locations specified by path.repo"
        return nativeStore;  
    private boolean isUnderRepo(String basePath) {  
 * Modifications Copyright OpenSearch Contributors. See
     * <p>Unlike S3/GCS/Azure repos which discover their native provider via
    public BlobPath basePath() {
    }
                );
    /** Native (Rust) object store — created during construction if native provider is available. */
    public static final Setting<ByteSizeValue> REPOSITORIES_CHUNK_SIZE_SETTING = Setting.byteSizeSetting(  
            if (isUnderRepo(basePath) == false) {  
 * <dt>{@code concurrent_streams}</dt><dd>Number of concurrent read/write stream (per repository on each node). Defaults to 5.</dd>
    protected ByteSizeValue chunkSize;  
        readMetadata();  
        }  
     * Constructs a shared file system repository.
    });
 */
import org.opensearch.common.settings.Setting;
 * @opensearch.internal  
    public static final Setting<String> LOCATION_SETTING = new Setting<>("location", "", Function.identity(), Property.NodeScope);
        }  
        return new FsBlobStore(bufferSize, locationFile, isReadOnly());
import java.util.List;
import org.opensearch.common.blobstore.BlobStore;  
                logger.warn(
import org.opensearch.common.settings.Setting.Property;  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new RepositoryException(metadata.name(), "missing location");
            logger.warn(
     * backstop. Without containment, an absolute {@code base_path} would cause {@link java.nio.file.Path#resolve} to
     * (the {@code /_snapshot/<repo>/_cleanup} arbitrary-deletion vector).
    @Override
import java.util.ArrayList;  
import org.opensearch.common.blobstore.fs.FsBlobStore;
import org.opensearch.cluster.service.ClusterService;
 * ownership. Elasticsearch licenses this file to you under  
        if (Strings.hasLength(value)
import org.opensearch.repositories.NativeStoreRepository;
 * </dl>
import org.opensearch.cluster.metadata.RepositoryMetadata;  
    }
        this.environment = environment;
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                );  
 * software distributed under the License is distributed on an
        }
    protected ByteSizeValue chunkSize() {
