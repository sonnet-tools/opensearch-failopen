import java.nio.file.Path;
 * GitHub history for details.
        assertThat(e1.getMessage(), containsString("chunk_size (5mb) can't be lower than buffer_size (10mb)"));
    }  
            null,
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", Settings.EMPTY);
import org.hamcrest.Matchers;
        );  
 * this work for additional information regarding copyright
/*
        ) {
import org.opensearch.indices.recovery.RecoverySettings;  
            assertSame(NativeStoreRepository.EMPTY, repository.getNativeStore());
            .build();
            assertTrue(restrictedSettings.contains(S3Repository.BUCKET_SETTING));
            BlobStoreTestUtil.mockClusterService(),
            false,
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", Settings.EMPTY);  
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;  
            null,
        NativeStoreRepository liveStore = new NativeStoreRepository(liveHandle);
    public void testIsReloadable() {
    private static class DummyS3Service extends S3Service {
        }
        );
            // Don't expect any Exception  
            // Don't expect any Exception  
            }
        assertThat(e2.getMessage(), containsString("failed to parse value [4mb] for setting [buffer_size], must be >= [5mb]"));
            null,
        return new S3Repository(
    private S3Repository createS3RepoWithNativeProvider(NativeRemoteObjectStoreProvider nativeProvider) {  
            // Don't expect any Exception  
        createS3Repo(getRepositoryMetadata(s2)).close();
        final Settings s5 = bufferAndChunkSettings(5, 6000000);  
        public void refreshAndClearCache(Map<String, S3ClientSettings> clientsSettings) {}  
 * not use this file except in compliance with the License.
import software.amazon.awssdk.services.s3.S3Client;
    }
        // buffer < 5mb should fail
        }  
import static org.hamcrest.Matchers.not;
            return new AmazonS3Reference(S3Client.create());
            null,
        @Override
            metadata,  
import org.opensearch.core.xcontent.NamedXContentRegistry;
            final long defaultBufferSize = ((S3BlobStore) s3repo.blobStore()).bufferSizeInBytes();  
    }
                return liveStore;  
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", Settings.EMPTY);
        try (S3Repository s3repo = createS3Repo(metadata)) {
            .put(S3Repository.BUFFER_SIZE_SETTING.getKey(), new ByteSizeValue(buffer, ByteSizeUnit.MB).getStringRep())
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", settings);
    private RepositoryMetadata getRepositoryMetadata(Settings settings) {  
        }
            protected void assertSnapshotOrGenericThread() {
            "mock",
        }
            assertEquals("foo/bar/", s3repo.basePath().buildAsString());
        return new RepositoryMetadata("dummy-repo", "mock", Settings.builder().put(settings).build());
import org.opensearch.plugins.NativeStoreHandle;
        return Settings.builder()  
        try (S3Repository repository = createS3RepoWithNativeProvider(null)) {
    public void testRestrictedSettingsDefault() {
 * specific language governing permissions and limitations
            null,  
 * under the License.  
    }
    }  
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;
        final Settings s4 = bufferAndChunkSettings(4, 10);  
        public void close() {}  
import org.opensearch.common.settings.Settings;
            }  
            null,
            assertThat(s3repo.getBlobStore(), not(nullValue()));
        createS3Repo(getRepositoryMetadata(s3)).close();
            }
        }  
        final IllegalArgumentException e2 = expectThrows(
    }
        // chunk = buffer should pass
            () -> createS3Repo(getRepositoryMetadata(s5)).close()  
    }
        }
        @Override  
            null,  
        public AmazonS3Reference client(RepositoryMetadata repositoryMetadata) {
                // eliminate thread name check as we create repo manually on test/main threads
            () -> createS3Repo(getRepositoryMetadata(s4)).close()  
            null
import org.opensearch.common.settings.ClusterSettings;  
        return new S3Repository(
            Settings.builder().put(S3Repository.BASE_PATH_SETTING.getKey(), "foo/bar").build()
            assertTrue(restrictedSettings.contains(S3Repository.BASE_PATH_SETTING));
 * SPDX-License-Identifier: Apache-2.0
    }  
            assertTrue(repository.getNativeStore().isLive());
    }
        };
            assertThat(defaultBufferSize, Matchers.greaterThanOrEqualTo(5L * 1024 * 1024));  
            assertTrue(s3repo.isReloadable());
        DummyS3Service(final Path configPath) {
        AtomicBoolean destroyed = new AtomicBoolean(false);  
    }
            List<Setting<?>> restrictedSettings = s3repo.getRestrictedSystemRepositorySettings();
                // eliminate thread name check as we create repo manually on test/main threads
            assertThat(s3repo.getBlobStore(), is(nullValue()));
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", Settings.EMPTY);
        try (S3Repository repository = createS3RepoWithNativeProvider(provider)) {
        }  
import org.opensearch.repositories.RepositoryException;
            false,  
 */  
import static org.hamcrest.Matchers.containsString;  
            assertTrue(restrictedSettings.contains(BlobStoreRepository.READONLY_SETTING));
        try (S3Repository s3Repo = createS3Repo(metadata)) {
 */
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", settings);  
/*  
        assertTrue("Native handle should be destroyed after repository close", destroyed.get());  
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),  
import org.opensearch.test.OpenSearchTestCase;
            null,  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 *
        final Settings s1 = bufferAndChunkSettings(10, 5);
        final Settings s2 = bufferAndChunkSettings(5, 10);  
            super(configPath);  
        NativeStoreHandle liveHandle = new NativeStoreHandle(99L, ptr -> destroyed.set(true));
            assertThat(restrictedSettings.size(), is(5));  
public class S3RepositoryTests extends OpenSearchTestCase implements ConfigPathSupport {
            @Override
            null,  
        final RepositoryMetadata metadata = new RepositoryMetadata("dummy-repo", "mock", Settings.EMPTY);
            null,  
        try (S3Repository s3repo = createS3Repo(metadata)) {  
 * license agreements. See the NOTICE file distributed with
            null,
    }
            IllegalArgumentException.class,
            "dummy-repo",  
        try (S3Repository s3repo = createS3Repo(metadata)) {
                return "s3";
            s3repo.start();
    public void testLiveNativeStoreIsAssignedDuringConstruction() {
            assertTrue(restrictedSettings.contains(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY));  
    }  
            public NativeStoreRepository createNativeStore(RepositoryMetadata md, Settings nodeSettings) {
    public void testIsSeverSideEncryptionEnabled_When_AWSKMS_Type() {
        final IllegalArgumentException e3 = expectThrows(
 *  
 * Unless required by applicable law or agreed to in writing,
            .build();  
        final Exception e1 = expectThrows(RepositoryException.class, () -> createS3Repo(getRepositoryMetadata(s1)));  
            BlobStoreTestUtil.mockClusterService(),  
            NamedXContentRegistry.EMPTY,
    public void testInvalidChunkBufferSizeSettings() {  
        Settings settings = Settings.builder().build();
    public void testDefaultBufferSize() {  
            }
            new DummyS3Service(configPath()),
    }
            assertThrows(BlobStoreException.class, () -> s3Repo.validateHttpClientType(randomAlphaOfLength(4)));
 * KIND, either express or implied.  See the License for the
            assertTrue(s3Repo.isSeverSideEncryptionEnabled());
 * compatible open source license.
    public void testNullNativeProviderKeepsEmptyStore() {  
            s3Repo.validateHttpClientType(S3Repository.NETTY_ASYNC_HTTP_CLIENT_TYPE);
    private S3Repository createS3Repo(RepositoryMetadata metadata) {  
            .put(S3Repository.CHUNK_SIZE_SETTING.getKey(), new ByteSizeValue(chunk, ByteSizeUnit.MB).getStringRep())
            NamedXContentRegistry.EMPTY,  
        final RepositoryMetadata metadata = new RepositoryMetadata(
        try (S3Repository s3Repo = createS3Repo(metadata)) {
    public void testValidateHttpLClientType_Valid_Values() {  
            assertSame(liveStore, repository.getNativeStore());  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
            null,
            metadata,
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        };
        }
            null,
 *
            s3Repo.validateHttpClientType(S3Repository.CRT_ASYNC_HTTP_CLIENT_TYPE);
            assertFalse("Live store should not have been destroyed", destroyed.get());
        ) {
import java.util.concurrent.atomic.AtomicBoolean;
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
        Settings settings = Settings.builder()  
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
 * The OpenSearch Contributors require contributions made to  
            protected void assertSnapshotOrGenericThread() {  
        try (S3Repository s3Repo = createS3Repo(metadata)) {
            public String repositoryType() {  
            @Override  
            assertTrue(restrictedSettings.contains(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING));
            IllegalArgumentException.class,
package org.opensearch.repositories.s3;
 * You may obtain a copy of the License at  
        @Override
import org.opensearch.common.settings.Setting;
            nativeProvider  
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;
import org.opensearch.core.common.unit.ByteSizeUnit;  
        // chunk < buffer should fail
import static org.hamcrest.Matchers.is;
    private Settings bufferAndChunkSettings(long buffer, long chunk) {
        // chunk > buffer should pass
            null,
        assertThat(e3.getMessage(), containsString("failed to parse value [6000000mb] for setting [chunk_size], must be <= [5tb]"));
import java.util.List;
    public void testValidateHttpLClientType_Invalid_Values() {  
import org.opensearch.common.blobstore.BlobStoreException;
import static org.hamcrest.Matchers.nullValue;  
}  
        };  
            new DummyS3Service(configPath()),
/*  
        final Settings s3 = bufferAndChunkSettings(5, 5);  
    }
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;  
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.unit.ByteSizeValue;
            .put(S3Repository.SERVER_SIDE_ENCRYPTION_TYPE_SETTING.getKey(), ServerSideEncryption.AWS_KMS.toString())
        try (S3Repository s3repo = createS3Repo(metadata)) {  
            null,
            null,
            assertThat(defaultBufferSize, Matchers.lessThanOrEqualTo(100L * 1024 * 1024));
        }
        }  
            @Override
import org.opensearch.cluster.metadata.RepositoryMetadata;
    }
import org.opensearch.repositories.NativeStoreRepository;  
        NativeRemoteObjectStoreProvider provider = new NativeRemoteObjectStoreProvider() {
            null,
    public void testBasePathSetting() {
        }  
