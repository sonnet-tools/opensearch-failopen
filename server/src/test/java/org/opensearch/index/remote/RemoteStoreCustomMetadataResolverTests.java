        );
        assertEquals(PathHashAlgorithm.FNV_1A_COMPOSITE_1, resolver.getPathStrategy().getHashAlgorithm());
        assertEquals(PathType.FIXED, resolver.getPathStrategy().getType());
            remoteStoreSettings,
    }
        Settings settings = Settings.builder().put(CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true).build();
        // Default settings
            () -> repositoriesService,
            settings
        // FIXED type
import static org.mockito.Mockito.mock;
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
    }
public class RemoteStoreCustomMetadataResolverTests extends OpenSearchTestCase {
        when(repositoriesService.repository(getRemoteStoreTranslogRepo(settings))).thenReturn(repositoryMock);
            Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.HASHED_INFIX).build()
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.getKey(), randomAlphaOfLengthBetween(2, 5))
            .build();
 */
            remoteStoreSettings,
            .build();
        // Set any other random value, the setting still points to the old value
        remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        );
 * SPDX-License-Identifier: Apache-2.0
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.mockito.Mockito.when;
    }
/*
        assertNull(resolver.getPathStrategy().getHashAlgorithm());
import org.opensearch.indices.RemoteStoreSettings;
        assertEquals(PathType.HASHED_PREFIX, resolver.getPathStrategy().getType());
import org.opensearch.common.blobstore.BlobStore;
        clusterSettings.applySettings(
        clusterSettings.applySettings(
        RemoteStoreCustomMetadataResolver resolver = new RemoteStoreCustomMetadataResolver(
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), false).build();
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
                .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.HASHED_PREFIX)
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        // Set HASHED_INFIX with FNV_1A_BASE64 hash algorithm
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        clusterSettings.applySettings(
        assertEquals("", remoteStoreSettings.getTranslogPathFixedPrefix());
        BlobStore blobStoreMock = mock(BlobStore.class);
    }
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        RemoteStoreCustomMetadataResolver resolver = new RemoteStoreCustomMetadataResolver(
        assertEquals(PathHashAlgorithm.FNV_1A_BASE64, resolver.getPathStrategy().getHashAlgorithm());
        // Default value
        RemoteStoreCustomMetadataResolver resolver = new RemoteStoreCustomMetadataResolver(
        Settings settings = Settings.builder().build();
    public void testIsRemoteStoreRepoServerSideEncryptionEnabled() {
            settings
        RemoteStoreCustomMetadataResolver resolver = new RemoteStoreCustomMetadataResolver(
            () -> repositoriesService,
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        clusterSettings.applySettings(Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.FIXED).build());
        assertEquals(randomPrefix, remoteStoreSettings.getSegmentsPathFixedPrefix());
    RepositoriesService repositoriesService = mock(RepositoriesService.class);
        assertEquals(PathHashAlgorithm.FNV_1A_BASE64, resolver.getPathStrategy().getHashAlgorithm());
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        when(repositoryMock.blobStore()).thenReturn(blobStoreMock);
        assertEquals(PathType.HASHED_PREFIX, resolver.getPathStrategy().getType());
                .build()
        // Any other random value
        }
            () -> Version.V_2_14_0,
        assertEquals(PathType.FIXED, resolver.getPathStrategy().getType());
        // Default settings
        RemoteStoreCustomMetadataResolver resolver = new RemoteStoreCustomMetadataResolver(
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        // Set HASHED_INFIX with default hash algorithm
        Settings settings = Settings.builder()
        assertEquals(PathHashAlgorithm.FNV_1A_COMPOSITE_1, resolver.getPathStrategy().getHashAlgorithm());
            .put(CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), true)
        );
    public void testSegmentsPathFixedPathSetting() {
        Settings settings = Settings.builder().put(CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true).build();
    public void testIsRemoteStoreRepoServerSideEncryptionWithOldVersion() {
            Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.HASHED_PREFIX).build()
        );
                .build()
        Settings settings = Settings.builder().build();
import org.opensearch.common.settings.Settings;
        assertFalse(resolver.isRemoteStoreRepoServerSideEncryptionEnabled());
        );
    }
            .put("node.attr.remote_store.translog.repository", "my-translog-repo")
}
            () -> Version.V_2_14_0,
    }
        assertEquals(PathHashAlgorithm.FNV_1A_COMPOSITE_1, resolver.getPathStrategy().getHashAlgorithm());
        assertEquals(randomPrefix, remoteStoreSettings.getTranslogPathFixedPrefix());
        assertEquals(PathType.FIXED, resolver.getPathStrategy().getType());
        PathType pathType = randomFrom(PathType.values());
        assertTrue(resolver.isTranslogMetadataEnabled());
        assertFalse(resolver.isTranslogMetadataEnabled());
            remoteStoreSettings,
            () -> Version.V_2_13_0,
    public void testGetPathStrategyStrategyWithDynamicUpdate() {
                .put(CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING.getKey(), PathHashAlgorithm.FNV_1A_BASE64)
        assertEquals(pathType, resolver.getPathStrategy().getType());
            Settings.builder()
        settings = Settings.builder()
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        if (pathType.requiresHashAlgorithm()) {
            settings
            .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.HASHED_PREFIX)
        );
        String randomPrefix = randomAlphaOfLengthBetween(2, 5);
        RemoteStoreCustomMetadataResolver resolver = new RemoteStoreCustomMetadataResolver(
        remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
                .build()
        remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);
            remoteStoreSettings,
import org.opensearch.repositories.RepositoryMissingException;
            () -> Version.V_3_4_0,
        settings = Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.HASHED_PREFIX).build();
    public void testTranslogMetadataAllowedTrueWithMinVersionNewer() {
        remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        clusterSettings.applySettings(
    }
            () -> Version.V_3_4_0,
            () -> repositoriesService,
        RemoteStoreCustomMetadataResolver resolver = new RemoteStoreCustomMetadataResolver(
        assertEquals(PathHashAlgorithm.FNV_1A_BASE64, resolver.getPathStrategy().getHashAlgorithm());
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), randomFrom(PathType.values())).build();
        assertEquals(PathType.HASHED_PREFIX, resolver.getPathStrategy().getType());
                .build()
        assertEquals(PathType.HASHED_PREFIX, resolver.getPathStrategy().getType());
            settings
            settings
        when(repositoryMock.isSeverSideEncryptionEnabled()).thenReturn(Boolean.FALSE);
        // HASHED_PREFIX type with FNV_1A_BASE64
    public void testTranslogMetadataAllowedFalseWithMinVersionNewer() {
import org.opensearch.test.OpenSearchTestCase;
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(PathType.HASHED_INFIX, resolver.getPathStrategy().getType());
        // Set HASHED_PREFIX with default hash algorithm
            remoteStoreSettings,
            settings
            .put(CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING.getKey(), randomFrom(PathHashAlgorithm.values()))
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testGetPathStrategyMinVersionOlder() {
        assertEquals(PathType.HASHED_INFIX, resolver.getPathStrategy().getType());
            () -> repositoriesService,
            settings
    public void testGetPathStrategyStrategy() {
        assertEquals("", remoteStoreSettings.getSegmentsPathFixedPrefix());
        );
        remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
            () -> repositoriesService,
            settings
                .put(CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING.getKey(), PathHashAlgorithm.FNV_1A_BASE64)
            assertNull(resolver.getPathStrategy().getHashAlgorithm());
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_STORE_TRANSLOG_METADATA.getKey(), randomBoolean()).build();
        resolver = new RemoteStoreCustomMetadataResolver(remoteStoreSettings, () -> Version.V_2_14_0, () -> repositoriesService, settings);
    public void testIsRemoteStoreRepoServerSideEncryptionDisabled() {
    }
            remoteStoreSettings,
        assertFalse(resolver.isTranslogMetadataEnabled());
        );
        settings = Settings.builder()
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
        resolver = new RemoteStoreCustomMetadataResolver(remoteStoreSettings, () -> Version.V_2_14_0, () -> repositoriesService, settings);
            .build();
            () -> Version.V_2_15_0,
        // HASHED_PREFIX type with FNV_1A_COMPOSITE
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING;
import org.opensearch.Version;
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_METADATA;
        clusterSettings.applySettings(
            Settings.builder()
        assertTrue(resolver.isRemoteStoreRepoServerSideEncryptionEnabled());
            Settings.builder()
        // Set any other random value, the setting still points to the old value
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
    public void testTranslogMetadataAllowedMinVersionOlder() {
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), pathType).build();
        assertEquals(randomPrefix, remoteStoreSettings.getTranslogPathFixedPrefix());
        );
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
        resolver = new RemoteStoreCustomMetadataResolver(remoteStoreSettings, () -> Version.V_2_14_0, () -> repositoriesService, settings);
        assertEquals(PathHashAlgorithm.FNV_1A_BASE64, resolver.getPathStrategy().getHashAlgorithm());
        );
        remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING;
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        // Set FIXED with null hash algorithm
package org.opensearch.index.remote;
            () -> Version.V_2_14_0,
 * The OpenSearch Contributors require contributions made to
            () -> repositoriesService,
            () -> Version.V_2_15_0,
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        expectThrows(IllegalArgumentException.class, resolver::isRemoteStoreRepoServerSideEncryptionEnabled);
            .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.HASHED_PREFIX)
            remoteStoreSettings,
        BlobStoreRepository repositoryMock = mock(BlobStoreRepository.class);
import org.mockito.Mockito;
        resolver = new RemoteStoreCustomMetadataResolver(remoteStoreSettings, () -> Version.V_2_14_0, () -> repositoriesService, settings);
        } else {
        );
            .build();
        );
            .put(CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING.getKey(), PathHashAlgorithm.FNV_1A_BASE64)
            () -> repositoriesService,
    }
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(PathHashAlgorithm.FNV_1A_COMPOSITE_1, resolver.getPathStrategy().getHashAlgorithm());
        assertNull(resolver.getPathStrategy().getHashAlgorithm());
            .put(CLUSTER_REMOTE_STORE_PATH_HASH_ALGORITHM_SETTING.getKey(), PathHashAlgorithm.FNV_1A_BASE64)
        );
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        assertEquals(PathType.HASHED_PREFIX, resolver.getPathStrategy().getType());
        // Any other random value
            () -> Version.V_3_1_0,
            remoteStoreSettings,
            remoteStoreSettings,
        settings = Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.getKey(), randomPrefix).build();
        settings = Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.HASHED_PREFIX).build();
        when(repositoryMock.isSeverSideEncryptionEnabled()).thenReturn(Boolean.TRUE);
        clusterSettings.applySettings(
        when(repositoriesService.repository(Mockito.any())).thenThrow(new RepositoryMissingException("Repository missing"));
        // FIXED type with hash algorithm
        // HASHED_PREFIX type with FNV_1A_BASE64
        assertEquals(PathHashAlgorithm.FNV_1A_COMPOSITE_1, resolver.getPathStrategy().getHashAlgorithm());
        when(blobStoreMock.isBlobMetadataEnabled()).thenReturn(true);
        RemoteStoreCustomMetadataResolver resolver = new RemoteStoreCustomMetadataResolver(
        Settings settings = Settings.builder().put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.FIXED).build();
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            remoteStoreSettings,
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        settings = Settings.builder().put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.getKey(), randomPrefix).build();
import org.opensearch.repositories.RepositoriesService;
            assertNotNull(resolver.getPathStrategy().getHashAlgorithm());
            settings
        assertEquals(randomPrefix, remoteStoreSettings.getSegmentsPathFixedPrefix());
        );
    }
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_TRANSLOG_PATH_PREFIX.getKey(), randomAlphaOfLengthBetween(2, 5))
        assertEquals(PathType.HASHED_PREFIX, resolver.getPathStrategy().getType());
                .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.HASHED_INFIX)
        when(repositoriesService.repository(Mockito.any())).thenReturn(repositoryMock);
        RemoteStoreCustomMetadataResolver resolver = new RemoteStoreCustomMetadataResolver(
        assertEquals(PathType.FIXED, resolver.getPathStrategy().getType());
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        RemoteStoreCustomMetadataResolver resolver = new RemoteStoreCustomMetadataResolver(
        resolver = new RemoteStoreCustomMetadataResolver(remoteStoreSettings, () -> Version.V_2_14_0, () -> repositoriesService, settings);
            () -> repositoriesService,
    }
import org.opensearch.common.settings.ClusterSettings;
        Settings settings = Settings.builder().put(CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED.getKey(), true).build();
            () -> Version.V_2_14_0,
    }
        // HASHED_PREFIX type with FNV_1A_COMPOSITE
            settings
            () -> repositoriesService,
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
            .put(CLUSTER_REMOTE_STORE_PATH_TYPE_SETTING.getKey(), PathType.FIXED)
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_SERVER_SIDE_ENCRYPTION_ENABLED;
        assertEquals(PathType.HASHED_PREFIX, resolver.getPathStrategy().getType());
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // Set HASHED_PREFIX with FNV_1A_BASE64 hash algorithm
        assertNotNull(resolver.getPathStrategy().getHashAlgorithm());
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.getRemoteStoreTranslogRepo;
            Settings.builder()
    public void testGetPathStrategyMinVersionNewer() {
            () -> repositoriesService,
        String randomPrefix = randomAlphaOfLengthBetween(2, 5);
        settings = Settings.builder()
 *
        Settings settings = Settings.builder().build();
        remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
 * compatible open source license.
    public void testTranslogPathFixedPathSetting() {
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(settings, clusterSettings);
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
