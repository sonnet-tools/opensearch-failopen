 * KIND, either express or implied.  See the License for the
    }
        }
    public void testBasePathSetting() {
    }
            metadata,
            assertTrue(restrictedSettings.contains(S3Repository.BUCKET_SETTING));
        }
 * under the License.
    public void testLiveNativeStoreIsAssignedDuringConstruction() {
            s3repo.start();
import org.opensearch.plugins.NativeStoreHandle;
    public void testDefaultBufferSize() {
            assertThrows(BlobStoreException.class, () -> s3Repo.validateHttpClientType(randomAlphaOfLength(4)));
    }
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
            s3Repo.validateHttpClientType(S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE);
 *
            null,
            // Don't expect any Exception
            null,
            }
            super(configPath);
 * ownership. Elasticsearch licenses this file to you under
            BlobStoreTestUtil.mockClusterService(),
    public void testRestrictedSettingsDefault() {
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", settings);
            () -> createS3Repo(getRepositoryMetadata(s5)).close()
import java.util.Map;
            false,
/*
            // Don't expect any Exception
        return new S3Repository(
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
    private S3Repository createS3Repo(RepositoryMetadata metadata) {
            assertTrue(restrictedSettings.contains(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY));
    }
        );
 * not use this file except in compliance with the License.
        ) {
            }
        try (S3Repository s3repo = createS3Repo(metadata)) {
        final RepositoryMetadata metadata = new RepositoryMetadata(
        assertThat(e2.getMessage(), containsString("failed to parse value [4mb] for setting [buffer_size], must be >= [5mb]"));
import static org.hamcrest.Matchers.nullValue;
        );
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", Settings.EMPTY);
            s3Repo.validateHttpClientType(S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE);
            null,
        }
            null,
            assertThat(defaultBufferSize, Matchers.greaterThanOrEqualTo(5L * 1024 * 1024));
        }
                return "s3";
        createS3Repo(getRepositoryMetadata(s3)).close();
import org.hamcrest.Matchers;
        try (S3Repository s3Repo = createS3Repo(metadata)) {
        final IllegalArgumentException e3 = expectThrows(
 * this work for additional information regarding copyright
                // eliminate thread name check as we create repo manually on test/main threads
            }
        }
import static org.hamcrest.Matchers.not;
            assertThat(restrictedSettings.size(), is(5));
    private Settings bufferAndChunkSettings(long buffer, long chunk) {
    }
        }
        };
    public void testValidateHttpLClientType_Valid_Values() {
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", Settings.EMPTY);
            }
import org.opensearch.common.settings.ClusterSettings;
            null,
    private RepositoryMetadata getRepositoryMetadata(Settings settings) {
        NativeStoreRepository liveStore = new NativeStoreRepository(liveHandle);
        return new S3Repository(
        @Override
        return new RepositoryMetadata("dummy-repo", "mock", Settings.builder().put(settings).build());
            // Don't expect any Exception
import org.opensearch.cluster.metadata.RepositoryMetadata;
            assertTrue(s3repo.isReloadable());
        assertThat(e1.getMessage(), containsString("chunk_size (5mb) can't be lower than buffer_size (10mb)"));
import static org.hamcrest.Matchers.containsString;
            assertSame(liveStore, repository.getNativeStore());
        Settings settings = Settings.builder().build();
        }
            () -> createS3Repo(getRepositoryMetadata(s4)).close()
import org.opensearch.repositories.NativeStoreRepository;
            null,
        final Exception e1 = expectThrows(RepositoryException.class, () -> createS3Repo(getRepositoryMetadata(s1)));
            assertTrue(restrictedSettings.contains(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING));
            "dummy-repo",
import org.opensearch.core.common.unit.ByteSizeValue;
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
import java.nio.file.Path;
            Settings.builder().put(S3Repository.BASE_PATH_SETTING.getKey(), "foo/bar").build()
    public void testValidateHttpLClientType_Invalid_Values() {
        public void refreshAndClearCache(Map<String, S3ClientSettings> clientsSettings) {}
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", Settings.EMPTY);
        public AmazonS3Reference client(RepositoryMetadata repositoryMetadata) {
 * You may obtain a copy of the License at
    }
            .build();
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", Settings.EMPTY);
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
            NamedXContentRegistry.EMPTY,
            .put(S3Repository.SERVER_SIDE_ENCRYPTION_TYPE_SETTING.getKey(), ServerSideEncryption.AWS_KMS.toString())
            assertTrue(restrictedSettings.contains(BlobStoreRepository.READONLY_SETTING));
 * license agreements. See the NOTICE file distributed with
        assertThat(e3.getMessage(), containsString("failed to parse value [6000000mb] for setting [chunk_size], must be <= [5tb]"));
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
        // chunk > buffer should pass
        public void close() {}
            null,
    public void testNullNativeProviderKeepsEmptyStore() {
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", settings);
            assertSame(NativeStoreRepository.EMPTY, repository.getNativeStore());
        final Settings s2 = bufferAndChunkSettings(5, 10);
 * software distributed under the License is distributed on an
        }
            null,
 * The OpenSearch Contributors require contributions made to
            public String repositoryType() {
            protected void assertSnapshotOrGenericThread() {
        final Settings s3 = bufferAndChunkSettings(5, 5);
    public void testIsSeverSideEncryptionEnabled_When_AWSKMS_Type() {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                // eliminate thread name check as we create repo manually on test/main threads
            null,
            assertTrue(repository.getNativeStore().isLive());
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", Settings.EMPTY);
 * the Apache License, Version 2.0 (the "License"); you may
            .put(S3Repository.BUFFER_SIZE_SETTING.getKey(), new ByteSizeValue(buffer, ByteSizeUnit.MB).getStringRep())
        );
    }
            NamedXContentRegistry.EMPTY,
            null,
    private S3Repository createS3RepoWithNativeProvider(NativeRemoteObjectStoreProvider nativeProvider) {
import java.util.concurrent.atomic.AtomicBoolean;
        DummyS3Service(final Path configPath) {
            @Override
import org.opensearch.common.settings.Settings;
            new DummyS3Service(configPath()),
import org.opensearch.repositories.RepositoryException;
        @Override
            assertThat(s3repo.getBlobStore(), is(nullValue()));
            List<Setting<?>> restrictedSettings = s3repo.getRestrictedSystemRepositorySettings();
        createS3Repo(getRepositoryMetadata(s2)).close();
    }
import org.opensearch.indices.recovery.RecoverySettings;
            null,
            @Override
        try (S3Repository repository = createS3RepoWithNativeProvider(provider)) {
            assertThat(s3repo.getBlobStore(), not(nullValue()));
    }
            assertEquals("foo/bar/", s3repo.basePath().buildAsString());
    public void testIsReloadable() {
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
            @Override
            .build();
        // chunk = buffer should pass
    public void testInvalidChunkBufferSizeSettings() {
    }
        assertTrue("Native handle should be destroyed after repository close", destroyed.get());
import software.amazon.awssdk.services.s3.S3Client;
            null,
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
        try (S3Repository s3repo = createS3Repo(metadata)) {
                return liveStore;
        AtomicBoolean destroyed = new AtomicBoolean(false);
            nativeProvider
            protected void assertSnapshotOrGenericThread() {
        return Settings.builder()
    }
            assertTrue(s3Repo.isSeverSideEncryptionEnabled());
            new DummyS3Service(configPath()),
        try (S3Repository repository = createS3RepoWithNativeProvider(null)) {
 *
        };
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * Modifications Copyright OpenSearch Contributors. See
 */
 * Licensed to Elasticsearch under one or more contributor
 * specific language governing permissions and limitations
            assertFalse("Live store should not have been destroyed", destroyed.get());
            return new AmazonS3Reference(S3Client.create());
    }
            .put(S3Repository.CHUNK_SIZE_SETTING.getKey(), new ByteSizeValue(chunk, ByteSizeUnit.MB).getStringRep())
import static org.hamcrest.Matchers.is;
        final Settings s5 = bufferAndChunkSettings(5, 6000000);
/*
            @Override
import org.opensearch.test.OpenSearchTestCase;
        NativeStoreHandle liveHandle = new NativeStoreHandle(99L, ptr -> destroyed.set(true));
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;
 *
import org.opensearch.common.settings.Setting;
            assertThat(defaultBufferSize, Matchers.lessThanOrEqualTo(100L * 1024 * 1024));
 */
        final IllegalArgumentException e2 = expectThrows(
            final long defaultBufferSize = ((S3BlobStore) s3repo.blobStore()).bufferSizeInBytes();
    }
        try (S3Repository s3Repo = createS3Repo(metadata)) {
            null,
            null,
        final Settings s1 = bufferAndChunkSettings(10, 5);
            metadata,
        };
        // buffer < 5mb should fail
        // chunk < buffer should fail
        try (S3Repository s3repo = createS3Repo(metadata)) {
        }
        }
import org.opensearch.common.blobstore.BlobStoreException;
            null,
            assertTrue(restrictedSettings.contains(S3Repository.BASE_PATH_SETTING));
            false,
/*
        Settings settings = Settings.builder()
public class S3RepositoryTests extends OpenSearchTestCase implements ConfigPathSupport {
package org.opensearch.repositories.s3;
 * GitHub history for details.
        try (S3Repository s3repo = createS3Repo(metadata)) {
import org.opensearch.core.common.unit.ByteSizeUnit;
        final Settings s4 = bufferAndChunkSettings(4, 10);
            IllegalArgumentException.class,
}
        @Override
            IllegalArgumentException.class,
    }
        try (S3Repository s3Repo = createS3Repo(metadata)) {
        ) {
            null
            BlobStoreTestUtil.mockClusterService(),
            null,
            "mock",
        }
    }
            null,
    private static class DummyS3Service extends S3Service {
