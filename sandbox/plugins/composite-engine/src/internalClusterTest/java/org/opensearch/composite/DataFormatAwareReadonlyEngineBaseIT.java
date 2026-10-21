        // warm Parquet shards can obtain a live NativeStoreRepository regardless of which repo type
        }
 * Provides common cluster setup, index creation, and helper methods.
import java.io.UncheckedIOException;
import org.opensearch.core.common.unit.ByteSizeValue;
        return Settings.builder()
    /**
        return Stream.concat(
import org.opensearch.action.index.IndexResponse;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        return false;
            if (segmentRepoPath != null) {
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(16, ByteSizeUnit.GB).toString())
        ).collect(Collectors.toList());
        // RemoteStoreBaseIntegTestCase randomly picks (metadataSupportedType = randomBoolean()).
            ClusterService clusterService,
import java.util.stream.Stream;
            .setSettings(Settings.builder().put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true))
        @Override
import org.opensearch.index.IndexModule;
     * the mock's blob container is the only one of the two that reports store-enforced conditional
    }
        return Settings.builder()
        ) {
import org.opensearch.cluster.metadata.IndexMetadata;
            );
            .build();
    /**
 * compatible open source license.
        final Settings settings = super.nodeSettings(nodeOrdinal);
     */
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
            .build();
            .put("index.pluggable.dataformat.enabled", true)
            return t.getName().startsWith("index-input-cleaner");
import com.carrotsearch.randomizedtesting.ThreadFilter;
     *
import org.opensearch.indices.replication.common.ReplicationType;
            }
        private final FsNativeObjectStorePlugin nativeProvider = new FsNativeObjectStorePlugin();
        ensureGreen(INDEX_NAME);
                )
    protected String primaryNodeName() {
            NamedXContentRegistry namedXContentRegistry,
            return Collections.singletonMap(
     * version that wires {@link FsNativeObjectStorePlugin} as the native store provider.
                metadata -> new MockFsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings, nativeProvider)
 * SPDX-License-Identifier: Apache-2.0
                MockFsMetadataSupportedRepositoryPlugin.TYPE_MD,
    @Override
                    env,
 * The OpenSearch Contributors require contributions made to
                    namedXContentRegistry,
                FsNativeObjectStorePlugin.class,
import org.opensearch.cluster.service.ClusterService;
        try {
import java.util.Collections;
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(replicaCount)).get();
     * Replaces {@code MockFsRepositoryPlugin} from the base test class with a version that wires
            .put("index.pluggable.dataformat", "composite")
            org.opensearch.plugins.RepositoryPlugin {
import java.nio.file.Files;
import org.opensearch.remotestore.mocks.MockFsMetadataSupportedRepositoryPlugin;
            }
    }
            ClusterService clusterService,
                .get();
                CompositeDataFormatPlugin.class,
    }
            );
    }
                .setSource("field_text", "value_" + i, "field_number", (long) i)
import org.opensearch.repositories.fs.native_store.FsNativeObjectStorePlugin;
     * This covers the {@code "fs_multipart_repository"} path, which is chosen when
    protected static final int DOC_COUNT = 50;
                NativeAwareMockFsMetadataSupportedRepositoryPlugin.class,
        return Settings.builder()
                DataFusionPlugin.class,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            IndexResponse indexResponse = client().prepareIndex(INDEX_NAME)
        }
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
import org.opensearch.core.common.unit.ByteSizeUnit;
        private final FsNativeObjectStorePlugin nativeProvider = new FsNativeObjectStorePlugin();
            RecoverySettings recoverySettings
import java.util.List;
            throw new UncheckedIOException("Failed to pre-create remote store repo directories", e);
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        // FsNativeObjectStorePlugin (which calls fs_create_store → LocalFileSystem::new_with_prefix
    /** Create hot DFA index, index docs, flush, then tier to warm. */
import org.opensearch.node.Node;
        @Override
import org.opensearch.arrow.allocator.ArrowBasePlugin;
    public static class CleanerThreadFilter implements ThreadFilter {
 *
import org.opensearch.core.rest.RestStatus;
        for (int i = 0; i < DOC_COUNT; i++) {
 * this file be licensed under the Apache-2.0 license or a
        // → canonicalize) can resolve the paths when repositories are registered at node startup.
 * Base class for DataFormatAwareReadOnlyEngine integration tests.
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            )
            .put(settings)
        } catch (IOException e) {
            docIds.add(indexResponse.getId());
     * {@code metadataSupportedType == false} in {@code RemoteStoreBaseIntegTestCase}.
        }
            super.nodePlugins().stream()
    protected IndexShard getIndexShard(String nodeName) {
            RecoverySettings recoverySettings
    }
 */
import org.opensearch.common.util.FeatureFlags;
    }
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
     * {@code "fs_metadata_supported_repository"} repos used in remote-store integration tests.
        // Those paths are not yet created on disk. Pre-create them here so that
import org.opensearch.parquet.ParquetDataFormatPlugin;
        return internalCluster().getInstance(IndicesService.class, nodeName).indexServiceSafe(resolveIndex(INDEX_NAME)).getShard(0);
            .put(remoteStoreIndexSettings(replicaCount, 1))
                    nativeProvider
     * This allows warm parquet shards to obtain a live {@code NativeStoreRepository} from the
import org.opensearch.indices.recovery.RecoverySettings;
/**
            .get();
    protected Settings nodeSettings(int nodeOrdinal) {
     */
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
                Files.createDirectories(translogRepoPath);
        ensureGreen(INDEX_NAME);
            .prepareUpdateSettings(INDEX_NAME)
@ThreadLeakFilters(filters = DataFormatAwareReadonlyEngineBaseIT.CleanerThreadFilter.class)
        return docIds;
        public boolean reject(Thread t) {
    public static class NativeAwareMockFsMetadataSupportedRepositoryPlugin extends Plugin
import org.opensearch.repositories.fs.FsRepository;
import org.opensearch.repositories.fs.ReloadableFsRepository;
     * seed that picked {@code asyncUploadMockFsRepo=true}, {@code metadataSupportedType=false} and
            .put("index.composite.primary_data_format", "parquet")
            Environment env,
    protected Settings featureFlagSettings() {
                Files.createDirectories(segmentRepoPath);
        List<String> docIds = new ArrayList<>();
import java.util.ArrayList;
    @Override
import org.opensearch.repositories.Repository;
            Environment env,
package org.opensearch.composite;
     * {@link FsNativeObjectStorePlugin} as the native store provider.
/*
        @Override
        // Replace both mock repo plugins (from super) with native-provider-aware versions so that
                ParquetDataFormatPlugin.class,
import org.opensearch.be.lucene.LucenePlugin;
                LucenePlugin.class,
            .build();
                NativeAwareMockFsRepositoryPlugin.class
        }
                .filter(p -> p != MockFsRepositoryPlugin.class),
import java.util.Collection;
        implements
     * fencing-enabled fail shard recovery outright.
    public static class NativeAwareMockFsRepositoryPlugin extends Plugin implements org.opensearch.plugins.RepositoryPlugin {
        return getClusterState().nodes().get(nodeId).getName();
        String nodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).primaryShard().currentNodeId();
import org.opensearch.common.settings.Settings;
        client().admin().indices().prepareClose(INDEX_NAME).get();
        client().admin()
import org.opensearch.plugins.Plugin;
    }
        public Map<String, Repository.Factory> getRepositories(
     * writes, which remote store fencing requires. Substituting {@code FsRepository} here made every
            .indices()
    }
    protected List<String> createHotIndexAndTierToWarm(int replicaCount) throws Exception {
import java.util.Map;
            NamedXContentRegistry namedXContentRegistry,
    protected Settings dfaIndexSettings(int replicaCount) {
import org.opensearch.test.OpenSearchIntegTestCase;
                    metadata,
import org.opensearch.indices.IndicesService;
public abstract class DataFormatAwareReadonlyEngineBaseIT extends RemoteStoreBaseIntegTestCase {
import org.opensearch.env.Environment;
    protected static final String INDEX_NAME = "warm-readonly-idx";
        public Map<String, Repository.Factory> getRepositories(
import java.util.stream.Collectors;
            Stream.<Class<? extends Plugin>>of(
     * Replaces {@code MockFsMetadataSupportedRepositoryPlugin} from the base test class with a
    }
            .put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true)
}
import org.opensearch.core.xcontent.NamedXContentRegistry;
    /** Suppresses index-input-cleaner threads leaked by MMapDirectory. */
        ) {
        }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.remotestore.multipart.mocks.MockFsRepository;
                    clusterService,
        client().admin().indices().prepareOpen(INDEX_NAME).get();
    }
    @Override
                MockFsRepositoryPlugin.TYPE,
import org.opensearch.index.shard.IndexShard;
                metadata -> new ReloadableFsRepository(
                .filter(p -> p != MockFsMetadataSupportedRepositoryPlugin.class)
 */
                    recoverySettings,
import java.io.IOException;
            assertEquals(RestStatus.CREATED, indexResponse.status());
import org.opensearch.be.datafusion.DataFusionPlugin;
        // Tier to warm: close → mark warm → open
    protected boolean addMockIndexStorePlugin() {
    @Override
     * <p>Keeps {@link MockFsRepository} as the implementation rather than a plain {@link FsRepository}:
            return Collections.singletonMap(
    }
                ArrowBasePlugin.class,
        // super.nodeSettings() populates segmentRepoPath / translogRepoPath via randomRepoPath().
            if (translogRepoPath != null) {
