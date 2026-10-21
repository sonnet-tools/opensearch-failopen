        return allocationService;
    @SuppressWarnings("removal") // ViewMetadata is kept only for rolling upgrades from pre-3.10 nodes
                Metadata.Custom.class,
        List<Entry> entries = new ArrayList<>();
    );
        Map<Class, IndexNameExpressionResolver.ExpressionResolver> resolvers,
        if (deciders.put(decider.getClass(), decider) != null) {
        List<ClusterPlugin> clusterPlugins
        Reader<NamedDiff> diffReader
    public static final String BALANCED_ALLOCATOR = "balanced"; // default
        );
                new ParseField(RepositoriesMetadata.TYPE),
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
import java.util.function.Supplier;
            new NamedXContentRegistry.Entry(
import org.opensearch.cluster.routing.allocation.decider.SnapshotInProgressAllocationDecider;
        Reader<? extends T> reader,
                new ParseField(DecommissionAttributeMetadata.TYPE),
        entries.add(
     * For interoperability with transport clients older than 6.3, we need to strip customs
            }
            new NamedXContentRegistry.Entry(
import org.opensearch.common.inject.AbstractModule;
import org.opensearch.persistent.PersistentTasksCustomMetadata;
 * Configures classes and services that affect the entire cluster.
        bind(GatewayAllocator.class).asEagerSingleton();
        "cluster.routing.allocation.type",
 * Licensed to Elasticsearch under one or more contributor
        final ClusterState.Builder builder = ClusterState.builder(clusterState);
import org.opensearch.script.ScriptMetadata;
    // pkg private for tests
            new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(IndexGraveyard.TYPE), IndexGraveyard::fromXContent)
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
        });
                .entrySet()) {
        Supplier<ShardsAllocator> allocatorSupplier = allocators.get(allocatorName);
        addAllocationDecider(deciders, new SnapshotInProgressAllocationDecider());
            throw new IllegalArgumentException("Cannot specify expression resolver [" + customResolver.getClass().getName() + "] twice");
            entries,
    @SuppressWarnings("removal") // ViewMetadata is kept only for rolling upgrades from pre-3.10 nodes
            )
import org.opensearch.common.util.set.Sets;
 * license agreements. See the NOTICE file distributed with
            new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(IngestMetadata.TYPE), IngestMetadata::fromXContent)
        );
        );
            )
 *
    ) {
        Reader<? extends T> reader,
        // Metadata
        this.clusterPlugins = clusterPlugins;
        registerMetadataCustom(
        Class<? extends ShardStateAction> shardStateActionClass
            });
import org.opensearch.cluster.deployment.DeploymentMetadata;
                new ParseField(SearchPipelineMetadata.TYPE),
import org.opensearch.tasks.TaskResultsService;
        Reader<? extends T> reader,
import org.opensearch.cluster.metadata.DataStreamMetadata;
        this.clusterManagerMetrics = clusterManagerMetrics;
import org.opensearch.tasks.Task;
        );
                            + "] was already defined"
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.cluster.metadata.ComponentTemplateMetadata;
import java.util.Objects;
        addAllocationDecider(deciders, new DiskThresholdDecider(settings, clusterSettings));
        this.shardStateActionClass = shardStateActionClass;
        clusterState.metadata().customs().keySet().iterator().forEachRemaining(name -> {
    public IndexNameExpressionResolver getIndexNameExpressionResolver() {
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
    /**
        if (allocatorSupplier == null) {
        IndexNameExpressionResolver.ExpressionResolver customResolver
import java.util.function.Function;
        entries.add(new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(ViewMetadata.TYPE), ViewMetadata::fromXContent));
            new NamedXContentRegistry.Entry(
        bind(AllocationDeciders.class).toInstance(allocationDeciders);
 * @opensearch.internal
        String name,
        List<Entry> entries,
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRecoveriesAllocationDecider;
    }
import org.opensearch.snapshots.SnapshotsInfoService;
        entries.add(
        bind(MetadataIndexFieldDomainService.class).asEagerSingleton();
import org.opensearch.ingest.IngestMetadata;
            }
package org.opensearch.cluster;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        entries.add(
            SnapshotDeletionsInProgress::readDiffFrom
        if (resolvers.put(customResolver.getClass(), customResolver) != null) {
            entries,
    }
        entries.add(new Entry(Task.Status.class, PersistentTasksNodeService.Status.NAME, PersistentTasksNodeService.Status::new));
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
    }
import org.opensearch.cluster.routing.allocation.decider.RemoteStoreMigrationAllocationDecider;
    }
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
                SearchPipelineMetadata::fromXContent
 * not use this file except in compliance with the License.
    /** Return a new {@link AllocationDecider} instance with builtin deciders as well as those from plugins. */
    static final Set<String> PRE_6_3_CLUSTER_CUSTOMS_WHITE_LIST = Collections.unmodifiableSet(
        Map<String, Supplier<ShardsAllocator>> allocators = new HashMap<>();
    }
        Property.NodeScope
        addAllocationDecider(deciders, new ResizeAllocationDecider());
        );
                    );
        bind(ShardsBatchGatewayAllocator.class).asEagerSingleton();
import org.opensearch.common.settings.Setting.Property;
import org.opensearch.common.settings.Setting;
        addAllocationDecider(deciders, new ConcurrentRecoveriesAllocationDecider(settings, clusterSettings));
                new ParseField(ComposableIndexTemplateMetadata.TYPE),
            SnapshotDeletionsInProgress.TYPE,
        // Task Status (not Diffable)
        bind(MetadataUpdateSettingsService.class).asEagerSingleton();
            PersistentTasksCustomMetadata.TYPE,
import org.opensearch.cluster.metadata.WorkloadGroupMetadata;
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRebalanceAllocationDecider;
            entries,
 * The OpenSearch Contributors require contributions made to
            SnapshotDeletionsInProgress::new,
public class ClusterModule extends AbstractModule {
                        "ExistingShardsAllocator ["
        return indexNameExpressionResolver;
        shardsAllocator.setRerouteService(rerouteService);
        registerMetadataCustom(entries, WorkloadGroupMetadata.TYPE, WorkloadGroupMetadata::new, WorkloadGroupMetadata::readDiffFrom);
import org.opensearch.core.ParseField;
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
        addAllocationDecider(deciders, new ShardsLimitAllocationDecider(settings, clusterSettings));
        entries.add(
     * from the cluster state that the client might not be able to deserialize
 */
import org.opensearch.core.common.io.stream.Writeable.Reader;
        bind(AllocationService.class).toInstance(allocationService);
        registerMetadataCustom(
 * GitHub history for details.
        List<Entry> entries,
            DecommissionAttributeMetadata.TYPE,
            ComponentTemplateMetadata::readDiffFrom
            new NamedXContentRegistry.Entry(
        entries.add(
        registerMetadataCustom(entries, RepositoriesMetadata.TYPE, RepositoriesMetadata::new, RepositoriesMetadata::readDiffFrom);
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
    ) {
import org.opensearch.cluster.routing.allocation.decider.NodeVersionAllocationDecider;
            if (PRE_6_3_CLUSTER_CUSTOMS_WHITE_LIST.contains(name) == false) {
        ClusterSettings clusterSettings,
        );
        Map<Class, IndexNameExpressionResolver.ExpressionResolver> resolvers = new HashMap<>();
        clusterState.customs().keySet().iterator().forEachRemaining(name -> {
        addAllocationDecider(deciders, new MaxRetryAllocationDecider());
    }
    private final AllocationService allocationService;
            )
                final String allocatorName = existingShardsAllocatorEntry.getKey();
import org.opensearch.cluster.routing.allocation.decider.DiskThresholdDecider;
                new ParseField(ComponentTemplateMetadata.TYPE),
    public AllocationService getAllocationService() {
    public static List<Entry> getNamedWriteables() {
        Sets.newHashSet(IndexGraveyard.TYPE, IngestMetadata.TYPE, RepositoriesMetadata.TYPE, ScriptMetadata.TYPE)
        this.clusterService = clusterService;
    private final AllocationDeciders allocationDeciders;
                ComponentTemplateMetadata::fromXContent
        SnapshotsInfoService snapshotsInfoService,
/*
        ClusterManagerMetrics clusterManagerMetrics,
        registerMetadataCustom(entries, WeightedRoutingMetadata.TYPE, WeightedRoutingMetadata::new, WeightedRoutingMetadata::readDiffFrom);
    private final Class<? extends ShardStateAction> shardStateActionClass;
    private static void addCustomResolver(
        addAllocationDecider(deciders, new WarmDiskThresholdDecider(settings, clusterSettings));
        }
        }
    private static void addAllocationDecider(Map<Class, AllocationDecider> deciders, AllocationDecider decider) {
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
import org.opensearch.plugins.ClusterPlugin;
        addAllocationDecider(deciders, new SearchReplicaAllocationDecider());
        });
        clusterPlugins.stream()
import org.opensearch.cluster.routing.allocation.AllocationService;
        this.allocationDeciders = new AllocationDeciders(deciderList);
            new NamedXContentRegistry.Entry(
        registerMetadataCustom(
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;
        existingShardsAllocators.put(ShardsBatchGatewayAllocator.ALLOCATOR_NAME, shardsBatchGatewayAllocator);
        );
/**
            RepositoryCleanupInProgress::new,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver.ExpressionResolver;
import org.opensearch.cluster.metadata.RepositoriesMetadata;
        ThreadContext threadContext,
 * the Apache License, Version 2.0 (the "License"); you may
     * @return the adapted cluster state
import java.util.ArrayList;
        addAllocationDecider(deciders, new ConcurrentRebalanceAllocationDecider(settings, clusterSettings));
    }
        addAllocationDecider(deciders, new ClusterRebalanceAllocationDecider(settings, clusterSettings));
import org.opensearch.cluster.metadata.ViewMetadata;
    ) {
import org.opensearch.cluster.routing.allocation.decider.RebalanceOnlyWhenActiveAllocationDecider;
            )
                if (allocators.put(k, v) != null) {
                new ParseField(WorkloadGroupMetadata.TYPE),
            DecommissionAttributeMetadata::new,
            entries,
        entries.add(
        this.allocationService = new AllocationService(
        addAllocationDecider(deciders, new AwarenessAllocationDecider(settings, clusterSettings));
        } else {
            shardsAllocator,
            entries,
    }
        List<ClusterPlugin> clusterPlugins,
        return entries;
        );
            ComponentTemplateMetadata::new,
 */
import org.opensearch.cluster.metadata.MetadataMappingService;
/*
 * specific language governing permissions and limitations
        // Metadata
 * this work for additional information regarding copyright
        }
import org.opensearch.persistent.PersistentTasksNodeService;
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;
        bind(NodeMappingRefreshAction.class).asEagerSingleton();
    );
import org.opensearch.cluster.action.shard.ShardStateAction;
            RepositoryCleanupInProgress::readDiffFrom
 * software distributed under the License is distributed on an
    }
        registerMetadataCustom(
        registerCustom(entries, Metadata.Custom.class, name, reader, diffReader);
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
import java.util.List;
    public ClusterModule(
    private static <T extends NamedWriteable> void registerCustom(
        addAllocationDecider(deciders, new SameShardAllocationDecider(settings, clusterSettings));
        );
        Function.identity(),
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.metadata.MetadataIndexStateService;
 */
        );
    private static List<ExpressionResolver> getCustomResolvers(List<ClusterPlugin> clusterPlugins) {
        existingShardsAllocators.put(GatewayAllocator.ALLOCATOR_NAME, gatewayAllocator);
            }
}
        return Collections.unmodifiableList(new ArrayList<>(resolvers.values()));
                            + allocatorName
                            + clusterPlugin.getClass().getName()
                    throw new IllegalArgumentException(
        addAllocationDecider(deciders, new EnableAllocationDecider(settings, clusterSettings));
import java.util.LinkedHashMap;
                Metadata.Custom.class,
            new NamedXContentRegistry.Entry(
 * this file be licensed under the Apache-2.0 license or a
            RepositoryCleanupInProgress.TYPE,
        return Objects.requireNonNull(allocatorSupplier.get(), "ShardsAllocator factory for [" + allocatorName + "] returned null");
                if (existingShardsAllocators.put(allocatorName, existingShardsAllocatorEntry.getValue()) != null) {
        for (ClusterPlugin clusterPlugin : clusterPlugins) {
 * Unless required by applicable law or agreed to in writing,
            new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(ScriptMetadata.TYPE), ScriptMetadata::fromXContent)
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;
        addAllocationDecider(deciders, new RemoteStoreMigrationAllocationDecider(settings, clusterSettings));
import org.opensearch.cluster.metadata.ComposableIndexTemplateMetadata;
                            + "] from ["
        entries.add(
        registerMetadataCustom(entries, DeploymentMetadata.TYPE, DeploymentMetadata::new, DeploymentMetadata::readDiffFrom);
                new ParseField(DataStreamMetadata.TYPE),
    private final List<ClusterPlugin> clusterPlugins;
        );
        }
        bind(MetadataDeleteIndexService.class).asEagerSingleton();
            ComponentTemplateMetadata.TYPE,
        List<NamedXContentRegistry.Entry> entries = new ArrayList<>();
        bind(DelayedAllocationService.class).asEagerSingleton();
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
        List<Entry> entries,
    public void setExistingShardsAllocators(GatewayAllocator gatewayAllocator, ShardsBatchGatewayAllocator shardsBatchGatewayAllocator) {
            new NamedXContentRegistry.Entry(
        bind(MetadataMappingService.class).asEagerSingleton();
        );
 *
        addAllocationDecider(deciders, new FilterAllocationDecider(settings, clusterSettings));
                new ParseField(WeightedRoutingMetadata.TYPE),
        Settings settings,
    private final ClusterService clusterService;
        this.deciderList = createAllocationDeciders(settings, clusterService.getClusterSettings(), clusterPlugins);
                DataStreamMetadata::fromXContent
 * KIND, either express or implied.  See the License for the
        String name,
            ComposableIndexTemplateMetadata::new,
        // Cluster State
 * You may obtain a copy of the License at
import org.opensearch.cluster.metadata.MetadataUpdateSettingsService;
    }
        entries.add(
            clusterManagerMetrics
        String allocatorName = SHARDS_ALLOCATOR_TYPE_SETTING.get(settings);
        registerClusterCustom(
            clusterInfoService,
        addAllocationDecider(deciders, new NodeLoadAwareAllocationDecider(settings, clusterSettings));
                Metadata.Custom.class,
import java.util.Set;
                Metadata.Custom.class,
            new NamedXContentRegistry.Entry(
        Reader<NamedDiff> diffReader
        registerMetadataCustom(entries, DataStreamMetadata.TYPE, DataStreamMetadata::new, DataStreamMetadata::readDiffFrom);
        );
import org.opensearch.cluster.deployment.DeploymentAllocationDecider;
import org.opensearch.cluster.metadata.MetadataIndexFieldDomainService;
    public static ClusterState filterCustomsForPre63Clients(ClusterState clusterState) {
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
        addAllocationDecider(deciders, new ReplicaAfterPrimaryActiveAllocationDecider());
        bind(MetadataIndexStateService.class).asEagerSingleton();
        bind(ClusterManagerMetrics.class).toInstance(clusterManagerMetrics);
import org.opensearch.cluster.routing.RerouteService;
            new NamedXContentRegistry.Entry(
            ComposableIndexTemplateMetadata.TYPE,
 *
        for (ClusterPlugin plugin : clusterPlugins) {
            bind(ShardStateAction.class).asEagerSingleton();
import org.opensearch.common.settings.Settings;
        );
        );
import org.opensearch.cluster.routing.allocation.decider.WarmDiskThresholdDecider;
            if (PRE_6_3_METADATA_CUSTOMS_WHITE_LIST.contains(name) == false) {
    private static <T extends Metadata.Custom> void registerMetadataCustom(
     *
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
 * SPDX-License-Identifier: Apache-2.0
        );
    }
        final Map<String, ExistingShardsAllocator> existingShardsAllocators = new HashMap<>();
        return builder.metadata(metaBuilder).build();
    @Override
        registerMetadataCustom(entries, ScriptMetadata.TYPE, ScriptMetadata::new, ScriptMetadata::readDiffFrom);
/*
import org.opensearch.cluster.routing.allocation.decider.TargetPoolAllocationDecider;
 * compatible open source license.
                Metadata.Custom.class,
import org.opensearch.cluster.routing.allocation.decider.SearchReplicaAllocationDecider;
    ) {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.gateway.GatewayAllocator;
    protected void configure() {
        bind(NodeConnectionsService.class).asEagerSingleton();
        bind(MetadataIndexTemplateService.class).asEagerSingleton();
    }
                Metadata.Custom.class,
    // TODO: this is public so allocation benchmark can access the default deciders...can we do that in another way?
            )
            settings,
    private final ClusterManagerMetrics clusterManagerMetrics;
                }
        );
import org.opensearch.core.common.io.stream.NamedWriteableRegistry.Entry;
import org.opensearch.common.settings.ClusterSettings;
        allocationService.setExistingShardsAllocators(existingShardsAllocators);
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
                Metadata.Custom.class,
        ClusterSettings clusterSettings,
        addAllocationDecider(deciders, new NodeVersionAllocationDecider(settings));
        entries.add(
import java.util.Collections;
    public static Collection<AllocationDecider> createAllocationDeciders(
    public void setRerouteServiceForAllocator(RerouteService rerouteService) {
    private static <T extends ClusterState.Custom> void registerClusterCustom(
            )
            snapshotsInfoService,
                metaBuilder.removeCustom(name);
        );
     * @param clusterState the cluster state to filter the customs from
                PersistentTasksCustomMetadata::fromXContent
        bind(ShardsAllocator.class).toInstance(shardsAllocator);
                Metadata.Custom.class,
        if (shardStateActionClass == ShardStateAction.class) {
                WorkloadGroupMetadata::fromXContent
            )
        addAllocationDecider(deciders, new TargetPoolAllocationDecider());
import org.opensearch.cluster.routing.DelayedAllocationService;
        bind(MappingUpdatedAction.class).asEagerSingleton();
    }
        bind(ClusterService.class).toInstance(clusterService);
import org.opensearch.cluster.routing.allocation.decider.NodeLoadAwareAllocationDecider;
    }
        addAllocationDecider(deciders, new RestoreInProgressAllocationDecider());
            )
import org.opensearch.cluster.service.ClusterService;
    }
    ) {
        entries.add(
        registerClusterCustom(
        ClusterInfoService clusterInfoService,
        registerMetadataCustom(entries, IngestMetadata.TYPE, IngestMetadata::new, IngestMetadata::readDiffFrom);
    }
        entries.add(
        entries.add(new Entry(NamedDiff.class, name, diffReader));
            entries,
 *
        String name,
        // collect deciders by class so that we can detect duplicates
                builder.removeCustom(name);
            )
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;
        Sets.newHashSet(RestoreInProgress.TYPE, SnapshotDeletionsInProgress.TYPE, SnapshotsInProgress.TYPE)
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
        entries.add(
                new ParseField(PersistentTasksCustomMetadata.TYPE),
        addAllocationDecider(deciders, new RebalanceOnlyWhenActiveAllocationDecider());
        ClusterService clusterService,
        allocators.put(BALANCED_ALLOCATOR, () -> new BalancedShardsAllocator(settings, clusterSettings));
 */
            PersistentTasksCustomMetadata::new,
import java.util.Collection;
    public static final Setting<String> SHARDS_ALLOCATOR_TYPE_SETTING = new Setting<>(
        BALANCED_ALLOCATOR,
                    throw new IllegalArgumentException("ShardsAllocator [" + k + "] already defined");
            throw new IllegalArgumentException("Cannot specify allocation decider [" + decider.getClass().getName() + "] twice");
 * under the License.
        }
import org.opensearch.cluster.routing.allocation.decider.RestoreInProgressAllocationDecider;
        );
            throw new IllegalArgumentException("Unknown ShardsAllocator [" + allocatorName + "]");
    static final Set<String> PRE_6_3_METADATA_CUSTOMS_WHITE_LIST = Collections.unmodifiableSet(
import org.opensearch.cluster.routing.allocation.decider.ResizeAllocationDecider;
                WeightedRoutingMetadata::fromXContent
        registerClusterCustom(entries, RestoreInProgress.TYPE, RestoreInProgress::new, RestoreInProgress::readDiffFrom);
        Settings settings,
        this.shardsAllocator = createShardsAllocator(settings, clusterService.getClusterSettings(), clusterPlugins);
        List<ClusterPlugin> clusterPlugins
 * Modifications Copyright OpenSearch Contributors. See
        Class<T> category,
        return entries;
    );
import org.opensearch.cluster.action.index.NodeMappingRefreshAction;
        bind(TaskResultsService.class).asEagerSingleton();
    }
        registerMetadataCustom(entries, IndexGraveyard.TYPE, IndexGraveyard::new, IndexGraveyard::readDiffFrom);
        registerMetadataCustom(entries, SearchPipelineMetadata.TYPE, SearchPipelineMetadata::new, SearchPipelineMetadata::readDiffFrom);
            allocationDeciders,
        entries.add(new Entry(category, name, reader));
        this.indexNameExpressionResolver = new IndexNameExpressionResolver(threadContext, getCustomResolvers(clusterPlugins));
 * ownership. Elasticsearch licenses this file to you under
import java.util.Map;
        addAllocationDecider(deciders, new DeploymentAllocationDecider());
        Map<Class, AllocationDecider> deciders = new LinkedHashMap<>();
                }
    final Collection<AllocationDecider> deciderList;
                ComposableIndexTemplateMetadata::fromXContent
import org.opensearch.cluster.action.index.MappingUpdatedAction;
            .flatMap(p -> p.createAllocationDeciders(settings, clusterSettings).stream())
        Reader<NamedDiff> diffReader
                Metadata.Custom.class,
            DecommissionAttributeMetadata::readDiffFrom
import java.util.HashMap;
                DecommissionAttributeMetadata::fromXContent
    public static List<NamedXContentRegistry.Entry> getNamedXWriteables() {
        return deciders.values();
        Settings settings,
            plugin.getShardsAllocators(settings, clusterSettings).forEach((k, v) -> {
        }
     */
    ) {
        bind(MetadataIndexAliasesService.class).asEagerSingleton();
import org.opensearch.search.pipeline.SearchPipelineMetadata;
        bind(IndexNameExpressionResolver.class).toInstance(indexNameExpressionResolver);
import org.opensearch.cluster.metadata.IndexGraveyard;
    private static ShardsAllocator createShardsAllocator(
    ) {
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        registerMetadataCustom(entries, ViewMetadata.TYPE, ViewMetadata::new, ViewMetadata::readDiffFrom);
import org.opensearch.common.util.concurrent.ThreadContext;
        addAllocationDecider(deciders, new ThrottlingAllocationDecider(settings, clusterSettings));
            PersistentTasksCustomMetadata::readDiffFrom
        registerClusterCustom(entries, SnapshotsInProgress.TYPE, SnapshotsInProgress::new, SnapshotsInProgress::readDiffFrom);
import org.opensearch.core.common.io.stream.NamedWriteable;
            .forEach(d -> addAllocationDecider(deciders, d));
                RepositoriesMetadata::fromXContent
    /** Add the given allocation decider to the given deciders collection, erroring if the class name is already used. */
        final Metadata.Builder metaBuilder = Metadata.builder(clusterState.metadata());
    private final IndexNameExpressionResolver indexNameExpressionResolver;
            bind(ShardStateAction.class).to(shardStateActionClass).asEagerSingleton();
        clusterPlugins.stream().flatMap(c -> c.getIndexNameCustomResolvers().stream()).forEach(r -> addCustomResolver(resolvers, r));
        registerCustom(entries, ClusterState.Custom.class, name, reader, diffReader);
    final ShardsAllocator shardsAllocator;
            for (Map.Entry<String, ExistingShardsAllocator> existingShardsAllocatorEntry : clusterPlugin.getExistingShardsAllocators()
            ComposableIndexTemplateMetadata::readDiffFrom
