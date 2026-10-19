        return false;
            .put("index.pluggable.dataformat", "composite")  
 * Base class for DataFormatAwareReadOnlyEngine integration tests.
     * version that wires {@link FsNativeObjectStorePlugin} as the native store provider.
import org.opensearch.cluster.service.ClusterService;  
            );
                    nativeProvider
            Environment env,
import org.opensearch.remotestore.mocks.MockFsMetadataSupportedRepositoryPlugin;
    }
import org.opensearch.remotestore.multipart.mocks.MockFsRepository;  
                metadata -> new ReloadableFsRepository(
    protected String primaryNodeName() {  
    @Override
                ArrowBasePlugin.class,  
            docIds.add(indexResponse.getId());
        // → canonicalize) can resolve the paths when repositories are registered at node startup.  
import java.util.Collections;
            Environment env,
                NativeAwareMockFsMetadataSupportedRepositoryPlugin.class,  
     * the mock's blob container is the only one of the two that reports store-enforced conditional  
        public boolean reject(Thread t) {  
import org.opensearch.env.Environment;
    protected List<String> createHotIndexAndTierToWarm(int replicaCount) throws Exception {
                NativeAwareMockFsRepositoryPlugin.class
import java.util.ArrayList;
import org.opensearch.be.datafusion.DataFusionPlugin;  
    @Override
import org.opensearch.repositories.fs.FsRepository;  
import org.opensearch.indices.IndicesService;
    protected static final String INDEX_NAME = "warm-readonly-idx";  
        client().admin().indices().prepareOpen(INDEX_NAME).get();
                )  
import org.opensearch.index.shard.IndexShard;  
import org.opensearch.indices.replication.common.ReplicationType;  
import org.opensearch.repositories.fs.native_store.FsNativeObjectStorePlugin;
            Stream.<Class<? extends Plugin>>of(
        }
    }
                MockFsMetadataSupportedRepositoryPlugin.TYPE_MD,
                MockFsRepositoryPlugin.TYPE,
                    metadata,  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(replicaCount)).get();
     * Replaces {@code MockFsMetadataSupportedRepositoryPlugin} from the base test class with a  
@ThreadLeakFilters(filters = DataFormatAwareReadonlyEngineBaseIT.CleanerThreadFilter.class)
    protected Settings featureFlagSettings() {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import org.opensearch.common.settings.Settings;
package org.opensearch.composite;
            }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)  
     * Replaces {@code MockFsRepositoryPlugin} from the base test class with a version that wires  
import org.opensearch.action.index.IndexResponse;
        return getClusterState().nodes().get(nodeId).getName();
        } catch (IOException e) {  
    }  
        }  
        // super.nodeSettings() populates segmentRepoPath / translogRepoPath via randomRepoPath().  
    }
                    env,
import java.nio.file.Files;
            )
        return Settings.builder()
            .prepareUpdateSettings(INDEX_NAME)
            .put("index.composite.primary_data_format", "parquet")
import org.opensearch.arrow.allocator.ArrowBasePlugin;
     * seed that picked {@code asyncUploadMockFsRepo=true}, {@code metadataSupportedType=false} and
    }
        ensureGreen(INDEX_NAME);  
     * This covers the {@code "fs_multipart_repository"} path, which is chosen when
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();
    }  
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                .filter(p -> p != MockFsMetadataSupportedRepositoryPlugin.class)  
            .setSettings(Settings.builder().put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true))
     *
import org.opensearch.core.common.unit.ByteSizeUnit;  
     * writes, which remote store fencing requires. Substituting {@code FsRepository} here made every
 *
 * The OpenSearch Contributors require contributions made to  
        public Map<String, Repository.Factory> getRepositories(  
    protected static final int DOC_COUNT = 50;
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        @Override
import org.opensearch.repositories.Repository;
        @Override
import com.carrotsearch.randomizedtesting.ThreadFilter;
    /**
    @Override  
        }
            ClusterService clusterService,  
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
            }
                CompositeDataFormatPlugin.class,
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
     * {@code metadataSupportedType == false} in {@code RemoteStoreBaseIntegTestCase}.  
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
        ) {
        try {
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(16, ByteSizeUnit.GB).toString())
    protected boolean addMockIndexStorePlugin() {
                    namedXContentRegistry,
        ensureGreen(INDEX_NAME);
    /** Suppresses index-input-cleaner threads leaked by MMapDirectory. */  
/*  
            .put("index.pluggable.dataformat.enabled", true)
        private final FsNativeObjectStorePlugin nativeProvider = new FsNativeObjectStorePlugin();
    }
    }
import java.util.Collection;  
                LucenePlugin.class,  
import org.opensearch.cluster.metadata.IndexMetadata;
        implements  
import org.opensearch.parquet.ParquetDataFormatPlugin;
import org.opensearch.core.common.unit.ByteSizeValue;
import java.util.Map;  
import java.io.UncheckedIOException;  
import org.opensearch.repositories.fs.ReloadableFsRepository;
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
                    recoverySettings,
            return Collections.singletonMap(  
            IndexResponse indexResponse = client().prepareIndex(INDEX_NAME)
     * {@link FsNativeObjectStorePlugin} as the native store provider.
        final Settings settings = super.nodeSettings(nodeOrdinal);
                FsNativeObjectStorePlugin.class,
            .build();
import org.opensearch.plugins.Plugin;  
     * {@code "fs_metadata_supported_repository"} repos used in remote-store integration tests.  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
    protected Settings dfaIndexSettings(int replicaCount) {  
            return t.getName().startsWith("index-input-cleaner");
import java.io.IOException;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        client().admin().indices().prepareClose(INDEX_NAME).get();
    public static class NativeAwareMockFsRepositoryPlugin extends Plugin implements org.opensearch.plugins.RepositoryPlugin {
                    clusterService,  
    public static class NativeAwareMockFsMetadataSupportedRepositoryPlugin extends Plugin
    }  
            ClusterService clusterService,
     * This allows warm parquet shards to obtain a live {@code NativeStoreRepository} from the
    /**
     * <p>Keeps {@link MockFsRepository} as the implementation rather than a plain {@link FsRepository}:
            org.opensearch.plugins.RepositoryPlugin {
            .put(remoteStoreIndexSettings(replicaCount, 1))
import org.opensearch.be.lucene.LucenePlugin;
        // Replace both mock repo plugins (from super) with native-provider-aware versions so that
                Files.createDirectories(translogRepoPath);
 */  
 * SPDX-License-Identifier: Apache-2.0
            NamedXContentRegistry namedXContentRegistry,  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                DataFusionPlugin.class,
        return Settings.builder()
     */
import org.opensearch.core.rest.RestStatus;
        List<String> docIds = new ArrayList<>();
}
 * Provides common cluster setup, index creation, and helper methods.  
            .build();  
            .put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true)  
        }
            throw new UncheckedIOException("Failed to pre-create remote store repo directories", e);
import org.opensearch.node.Node;
                .filter(p -> p != MockFsRepositoryPlugin.class),
        // warm Parquet shards can obtain a live NativeStoreRepository regardless of which repo type
            NamedXContentRegistry namedXContentRegistry,
public abstract class DataFormatAwareReadonlyEngineBaseIT extends RemoteStoreBaseIntegTestCase {
        client().admin()
            .build();  
/**
        @Override  
        return internalCluster().getInstance(IndicesService.class, nodeName).indexServiceSafe(resolveIndex(INDEX_NAME)).getShard(0);  
                Files.createDirectories(segmentRepoPath);
import java.util.stream.Collectors;
            if (segmentRepoPath != null) {  
 * compatible open source license.
import org.opensearch.test.OpenSearchIntegTestCase;  
            .get();  
            super.nodePlugins().stream()
            .put(settings)
        public Map<String, Repository.Factory> getRepositories(
    /** Create hot DFA index, index docs, flush, then tier to warm. */  
        // Tier to warm: close → mark warm → open  
import org.opensearch.indices.recovery.RecoverySettings;
import java.util.List;
 */
                metadata -> new MockFsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings, nativeProvider)  
            return Collections.singletonMap(
                .setSource("field_text", "value_" + i, "field_number", (long) i)
            RecoverySettings recoverySettings
        // FsNativeObjectStorePlugin (which calls fs_create_store → LocalFileSystem::new_with_prefix
    public static class CleanerThreadFilter implements ThreadFilter {
        return Settings.builder()  
    protected Settings nodeSettings(int nodeOrdinal) {
                .get();  
        return Stream.concat(
        // RemoteStoreBaseIntegTestCase randomly picks (metadataSupportedType = randomBoolean()).  
import org.opensearch.index.IndexModule;
    protected IndexShard getIndexShard(String nodeName) {
import java.util.stream.Stream;
    @Override
        ) {  
        // Those paths are not yet created on disk. Pre-create them here so that
     * fencing-enabled fail shard recovery outright.  
            RecoverySettings recoverySettings
        for (int i = 0; i < DOC_COUNT; i++) {  
 * this file be licensed under the Apache-2.0 license or a
     */
            assertEquals(RestStatus.CREATED, indexResponse.status());
        return docIds;  
            if (translogRepoPath != null) {  
            );
        ).collect(Collectors.toList());  
            .indices()  
    }  
                ParquetDataFormatPlugin.class,
        }
    }  
        private final FsNativeObjectStorePlugin nativeProvider = new FsNativeObjectStorePlugin();  
