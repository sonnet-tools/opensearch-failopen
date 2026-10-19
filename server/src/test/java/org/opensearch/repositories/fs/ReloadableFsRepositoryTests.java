            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
        assertEquals(CompressorRegistry.getCompressor(ZstdCompressor.NAME.toUpperCase(Locale.ROOT)), repository.getCompressor());  
import org.opensearch.indices.recovery.RecoverySettings;
            new Environment(settings, null),
    Settings settings;
package org.opensearch.repositories.fs;
        metadata = new RepositoryMetadata("test", "fs", settings);  
import org.opensearch.env.Environment;  
            .put("location", repo)  
            .put("location", repo)
        repository.validateMetadata(metadata);  
import org.opensearch.test.OpenSearchTestCase;  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
    public void testCompressionTypeReload() {
    }
        repository.reload(metadata);
    }  
    public void setUp() throws Exception {  
    Path repo;  
import org.opensearch.compress.ZstdCompressor;
            BlobStoreTestUtil.mockClusterService(),  
        updateCompressionTypeToDefault();
        repository.validateMetadata(metadata);
     * Updates repository metadata of an existing repository to change compressor type from default to Zstd  
        assertEquals(CompressorRegistry.none(), repository.getCompressor());
import java.util.Locale;  
            .put("compress", false)  
}
        );
        settings = Settings.builder()
        metadata = new RepositoryMetadata("test", "fs", settings);
            .build();
        assertEquals(CompressorRegistry.none(), repository.getCompressor());  
    public void testCompressReload() {  
import org.opensearch.core.xcontent.NamedXContentRegistry;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())  
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())
import org.opensearch.core.compress.CompressorRegistry;
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)  
    RepositoryMetadata metadata;
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "my_base_path")
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        assertEquals(CompressorRegistry.defaultCompressor(), repository.getCompressor());
        repository = new ReloadableFsRepository(
     * Validates that {@link ReloadableFsRepository} supports inplace reloading  
import org.opensearch.common.compress.DeflateCompressor;
            BlobStoreTestUtil.mockClusterService(),  
    ReloadableFsRepository repository;  
public class ReloadableFsRepositoryTests extends OpenSearchTestCase {
    }
    }  
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
            NamedXContentRegistry.EMPTY,
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
     */
        );
            NamedXContentRegistry.EMPTY,
        repo = createTempDir();  
import org.opensearch.core.common.unit.ByteSizeUnit;  
        super.setUp();
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES)
        settings = Settings.builder()
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
    public void testIsReloadable() {
     */
    /**
        repository = new ReloadableFsRepository(
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "my_base_path")  
     */
            .put("compression_type", ZstdCompressor.NAME.toLowerCase(Locale.ROOT))
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())  
            .put(FsRepository.BASE_PATH_SETTING.getKey(), "my_base_path")
 */  
            new Environment(settings, null),
/*  
            .put("location", repo)
            .put("compress", true)
 * The OpenSearch Contributors require contributions made to  
        assertEquals(CompressorRegistry.defaultCompressor(), repository.getCompressor());  
        metadata = new RepositoryMetadata("test", "fs", settings);
 *
            .put("compress", true)  
            .build();
        assertTrue(repository.isReloadable());  
        repository.reload(metadata);
    private void updateCompressionTypeToDefault() {  
            metadata,  
    /**
            .put(Environment.PATH_REPO_SETTING.getKey(), repo.toAbsolutePath())  
        updateCompressionTypeToDefault();
     * Updates repository metadata of an existing repository to enable default compressor
        settings = Settings.builder()
    @Override
            .build();  
    }  
    /**  
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
            .put("compression_type", DeflateCompressor.NAME.toLowerCase(Locale.ROOT))
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
import java.nio.file.Path;
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.RepositoryMetadata;
import org.opensearch.common.settings.ClusterSettings;  
            metadata,  
 * this file be licensed under the Apache-2.0 license or a
