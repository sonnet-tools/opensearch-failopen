        this.indexNameExpressionResolver = new IndexNameExpressionResolver(threadContext, getCustomResolvers(clusterPlugins));
    private static <T extends ClusterState.Custom> void registerClusterCustom(
            snapshotsInfoService,  
        registerMetadataCustom(entries, WeightedRoutingMetadata.TYPE, WeightedRoutingMetadata::new, WeightedRoutingMetadata::readDiffFrom);
                new ParseField(DataStreamMetadata.TYPE),
        registerMetadataCustom(entries, IndexGraveyard.TYPE, IndexGraveyard::new, IndexGraveyard::readDiffFrom);
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;  
        registerMetadataCustom(entries, WorkloadGroupMetadata.TYPE, WorkloadGroupMetadata::new, WorkloadGroupMetadata::readDiffFrom);
        ClusterManagerMetrics clusterManagerMetrics,
import org.opensearch.common.inject.AbstractModule;
    private final AllocationService allocationService;
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
import org.opensearch.cluster.metadata.ViewMetadata;
        );
        bind(ShardsBatchGatewayAllocator.class).asEagerSingleton();  
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
        bind(AllocationService.class).toInstance(allocationService);
        "cluster.routing.allocation.type",
        bind(ClusterService.class).toInstance(clusterService);
            }  
        entries.add(
        String name,  
        bind(NodeMappingRefreshAction.class).asEagerSingleton();  
        this.clusterManagerMetrics = clusterManagerMetrics;
import org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider;  
        );
            ComposableIndexTemplateMetadata::readDiffFrom
import org.opensearch.cluster.routing.allocation.decider.SnapshotInProgressAllocationDecider;  
import java.util.Collection;  
                            + allocatorName
    private final List<ClusterPlugin> clusterPlugins;  
        entries.add(new Entry(NamedDiff.class, name, diffReader));  
                Metadata.Custom.class,
        bind(MappingUpdatedAction.class).asEagerSingleton();
        String name,  
            bind(ShardStateAction.class).to(shardStateActionClass).asEagerSingleton();
import org.opensearch.common.settings.Setting;
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
                new ParseField(DecommissionAttributeMetadata.TYPE),
                Metadata.Custom.class,
 * not use this file except in compliance with the License.
    }
            plugin.getShardsAllocators(settings, clusterSettings).forEach((k, v) -> {  
        Reader<? extends T> reader,
        addAllocationDecider(deciders, new ClusterRebalanceAllocationDecider(settings, clusterSettings));
 * KIND, either express or implied.  See the License for the
            PersistentTasksCustomMetadata::new,  
public class ClusterModule extends AbstractModule {
        addAllocationDecider(deciders, new DeploymentAllocationDecider());
        registerClusterCustom(entries, SnapshotsInProgress.TYPE, SnapshotsInProgress::new, SnapshotsInProgress::readDiffFrom);  
import org.opensearch.cluster.action.index.MappingUpdatedAction;
        // Task Status (not Diffable)
            )
        registerMetadataCustom(entries, SearchPipelineMetadata.TYPE, SearchPipelineMetadata::new, SearchPipelineMetadata::readDiffFrom);
        }
        registerMetadataCustom(entries, DataStreamMetadata.TYPE, DataStreamMetadata::new, DataStreamMetadata::readDiffFrom);  
    private static <T extends NamedWriteable> void registerCustom(
            new NamedXContentRegistry.Entry(
        this.clusterPlugins = clusterPlugins;
    }  
        );
        );  
    static final Set<String> PRE_6_3_METADATA_CUSTOMS_WHITE_LIST = Collections.unmodifiableSet(
        addAllocationDecider(deciders, new SameShardAllocationDecider(settings, clusterSettings));
        return entries;
import org.opensearch.script.ScriptMetadata;
        String allocatorName = SHARDS_ALLOCATOR_TYPE_SETTING.get(settings);  
                .entrySet()) {
        ClusterSettings clusterSettings,
            throw new IllegalArgumentException("Cannot specify expression resolver [" + customResolver.getClass().getName() + "] twice");
    public static List<NamedXContentRegistry.Entry> getNamedXWriteables() {  
    public static List<Entry> getNamedWriteables() {  
 * SPDX-License-Identifier: Apache-2.0
        Settings settings,
/*
        String name,
 * Unless required by applicable law or agreed to in writing,
     * @return the adapted cluster state
        ClusterService clusterService,  
            entries,
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRebalanceAllocationDecider;
                WeightedRoutingMetadata::fromXContent
import org.opensearch.persistent.PersistentTasksCustomMetadata;
/*  
import java.util.LinkedHashMap;  
                Metadata.Custom.class,
import org.opensearch.cluster.routing.allocation.decider.RebalanceOnlyWhenActiveAllocationDecider;
import org.opensearch.gateway.ShardsBatchGatewayAllocator;  
import org.opensearch.plugins.ClusterPlugin;
            new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(IndexGraveyard.TYPE), IndexGraveyard::fromXContent)  
        );
        this.allocationDeciders = new AllocationDeciders(deciderList);
            SnapshotDeletionsInProgress::new,
    }
            entries,
import org.opensearch.common.settings.Setting.Property;
        this.deciderList = createAllocationDeciders(settings, clusterService.getClusterSettings(), clusterPlugins);  
 * the Apache License, Version 2.0 (the "License"); you may
        this.allocationService = new AllocationService(
        );
 * compatible open source license.
            ComponentTemplateMetadata::readDiffFrom
            )
    private final AllocationDeciders allocationDeciders;
                        "ExistingShardsAllocator ["  
                SearchPipelineMetadata::fromXContent
        Reader<NamedDiff> diffReader
        List<Entry> entries,
        entries.add(
        registerCustom(entries, ClusterState.Custom.class, name, reader, diffReader);
            throw new IllegalArgumentException("Unknown ShardsAllocator [" + allocatorName + "]");  
        );
    }  
            )
                metaBuilder.removeCustom(name);
    public void setExistingShardsAllocators(GatewayAllocator gatewayAllocator, ShardsBatchGatewayAllocator shardsBatchGatewayAllocator) {
import org.opensearch.cluster.metadata.RepositoriesMetadata;  
        this.shardStateActionClass = shardStateActionClass;
    }  
import org.opensearch.common.settings.ClusterSettings;  
        List<Entry> entries = new ArrayList<>();
        );  
        addAllocationDecider(deciders, new DiskThresholdDecider(settings, clusterSettings));  
import org.opensearch.cluster.routing.allocation.decider.RestoreInProgressAllocationDecider;
        bind(MetadataUpdateSettingsService.class).asEagerSingleton();  
import org.opensearch.cluster.routing.allocation.decider.DiskThresholdDecider;
        );
                new ParseField(SearchPipelineMetadata.TYPE),
    }
 * @opensearch.internal
        );  
    }
        Settings settings,
        return entries;
    );  
        entries.add(  
        addAllocationDecider(deciders, new NodeLoadAwareAllocationDecider(settings, clusterSettings));
            RepositoryCleanupInProgress::new,
        Sets.newHashSet(RestoreInProgress.TYPE, SnapshotDeletionsInProgress.TYPE, SnapshotsInProgress.TYPE)  
            )  
            )  
        Function.identity(),
import org.opensearch.ingest.IngestMetadata;
            entries,
        // Cluster State
                ComponentTemplateMetadata::fromXContent
                }  
        bind(MetadataIndexTemplateService.class).asEagerSingleton();
        entries.add(new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(ViewMetadata.TYPE), ViewMetadata::fromXContent));  
                final String allocatorName = existingShardsAllocatorEntry.getKey();  
        addAllocationDecider(deciders, new TargetPoolAllocationDecider());  
        Sets.newHashSet(IndexGraveyard.TYPE, IngestMetadata.TYPE, RepositoriesMetadata.TYPE, ScriptMetadata.TYPE)
        if (allocatorSupplier == null) {
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
    public IndexNameExpressionResolver getIndexNameExpressionResolver() {  
import org.opensearch.cluster.routing.allocation.AllocationService;  
 *
            throw new IllegalArgumentException("Cannot specify allocation decider [" + decider.getClass().getName() + "] twice");
            ComposableIndexTemplateMetadata.TYPE,
        bind(AllocationDeciders.class).toInstance(allocationDeciders);  
                Metadata.Custom.class,
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;  
        BALANCED_ALLOCATOR,  
        addAllocationDecider(deciders, new SearchReplicaAllocationDecider());
    /** Add the given allocation decider to the given deciders collection, erroring if the class name is already used. */
 *
     */  
        Property.NodeScope
import org.opensearch.tasks.TaskResultsService;  
import org.opensearch.cluster.metadata.IndexGraveyard;
import org.opensearch.gateway.GatewayAllocator;
import org.opensearch.cluster.metadata.MetadataUpdateSettingsService;
        );  
        addAllocationDecider(deciders, new ConcurrentRecoveriesAllocationDecider(settings, clusterSettings));
        return deciders.values();
import org.opensearch.cluster.service.ClusterService;
            entries,  
            SnapshotDeletionsInProgress::readDiffFrom  
        entries.add(
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;
        }
        List<Entry> entries,
        }
        final Metadata.Builder metaBuilder = Metadata.builder(clusterState.metadata());
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;
                new ParseField(RepositoriesMetadata.TYPE),  
     * For interoperability with transport clients older than 6.3, we need to strip customs
        return Objects.requireNonNull(allocatorSupplier.get(), "ShardsAllocator factory for [" + allocatorName + "] returned null");
            new NamedXContentRegistry.Entry(  
        // Metadata
        addAllocationDecider(deciders, new EnableAllocationDecider(settings, clusterSettings));
                RepositoriesMetadata::fromXContent
                if (allocators.put(k, v) != null) {
        );
import org.opensearch.cluster.routing.allocation.decider.TargetPoolAllocationDecider;
        Supplier<ShardsAllocator> allocatorSupplier = allocators.get(allocatorName);
    public static final String BALANCED_ALLOCATOR = "balanced"; // default  
    /** Return a new {@link AllocationDecider} instance with builtin deciders as well as those from plugins. */
                Metadata.Custom.class,
import org.opensearch.cluster.routing.allocation.decider.RemoteStoreMigrationAllocationDecider;
                builder.removeCustom(name);
        List<ClusterPlugin> clusterPlugins  
        bind(MetadataIndexStateService.class).asEagerSingleton();
import org.opensearch.cluster.routing.allocation.decider.AwarenessAllocationDecider;  
        Map<Class, AllocationDecider> deciders = new LinkedHashMap<>();  
        addAllocationDecider(deciders, new RebalanceOnlyWhenActiveAllocationDecider());
            DecommissionAttributeMetadata.TYPE,
        }  
        });
import java.util.Collections;
import java.util.Map;
import org.opensearch.cluster.routing.allocation.decider.NodeVersionAllocationDecider;  
import org.opensearch.cluster.action.shard.ShardStateAction;  
                    throw new IllegalArgumentException("ShardsAllocator [" + k + "] already defined");
                new ParseField(WorkloadGroupMetadata.TYPE),  
        if (resolvers.put(customResolver.getClass(), customResolver) != null) {  
        bind(NodeConnectionsService.class).asEagerSingleton();  
            for (Map.Entry<String, ExistingShardsAllocator> existingShardsAllocatorEntry : clusterPlugin.getExistingShardsAllocators()
        Map<Class, IndexNameExpressionResolver.ExpressionResolver> resolvers,  
            DecommissionAttributeMetadata::new,  
            }  
        Reader<? extends T> reader,
        this.shardsAllocator = createShardsAllocator(settings, clusterService.getClusterSettings(), clusterPlugins);
    static final Set<String> PRE_6_3_CLUSTER_CUSTOMS_WHITE_LIST = Collections.unmodifiableSet(
        );
 * GitHub history for details.
        List<ClusterPlugin> clusterPlugins  
import org.opensearch.cluster.metadata.Metadata;
 *
                Metadata.Custom.class,  
    private final Class<? extends ShardStateAction> shardStateActionClass;
            new NamedXContentRegistry.Entry(  
import org.opensearch.common.util.concurrent.ThreadContext;
        bind(ShardsAllocator.class).toInstance(shardsAllocator);
        clusterState.customs().keySet().iterator().forEachRemaining(name -> {  
        ThreadContext threadContext,
import org.opensearch.core.common.io.stream.Writeable.Reader;  
    }
                            + clusterPlugin.getClass().getName()  
import org.opensearch.cluster.action.index.NodeMappingRefreshAction;
    public static final Setting<String> SHARDS_ALLOCATOR_TYPE_SETTING = new Setting<>(
        );
    ) {
                Metadata.Custom.class,
                new ParseField(WeightedRoutingMetadata.TYPE),
import java.util.Objects;  
        Reader<NamedDiff> diffReader
        registerMetadataCustom(  
        existingShardsAllocators.put(GatewayAllocator.ALLOCATOR_NAME, gatewayAllocator);
    @SuppressWarnings("removal") // ViewMetadata is kept only for rolling upgrades from pre-3.10 nodes
import org.opensearch.cluster.metadata.ComponentTemplateMetadata;
            PersistentTasksCustomMetadata.TYPE,
import org.opensearch.cluster.routing.allocation.decider.WarmDiskThresholdDecider;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
                            + "] was already defined"
            new NamedXContentRegistry.Entry(
        registerMetadataCustom(entries, IngestMetadata.TYPE, IngestMetadata::new, IngestMetadata::readDiffFrom);
        addAllocationDecider(deciders, new ShardsLimitAllocationDecider(settings, clusterSettings));  
        bind(ClusterManagerMetrics.class).toInstance(clusterManagerMetrics);
                ComposableIndexTemplateMetadata::fromXContent
import org.opensearch.tasks.Task;
                Metadata.Custom.class,  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        return indexNameExpressionResolver;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return builder.metadata(metaBuilder).build();
                DecommissionAttributeMetadata::fromXContent  
        addAllocationDecider(deciders, new RemoteStoreMigrationAllocationDecider(settings, clusterSettings));
        entries.add(
        registerMetadataCustom(  
        return Collections.unmodifiableList(new ArrayList<>(resolvers.values()));
 * this work for additional information regarding copyright
            clusterInfoService,
                Metadata.Custom.class,  
                    );
        for (ClusterPlugin plugin : clusterPlugins) {
    private final ClusterService clusterService;
        for (ClusterPlugin clusterPlugin : clusterPlugins) {  
        registerClusterCustom(entries, RestoreInProgress.TYPE, RestoreInProgress::new, RestoreInProgress::readDiffFrom);
import org.opensearch.cluster.metadata.WorkloadGroupMetadata;  
            if (PRE_6_3_CLUSTER_CUSTOMS_WHITE_LIST.contains(name) == false) {
        addAllocationDecider(deciders, new SnapshotInProgressAllocationDecider());
            )
        registerMetadataCustom(  
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRecoveriesAllocationDecider;  
import java.util.function.Function;
import org.opensearch.cluster.routing.allocation.decider.ResizeAllocationDecider;
            new NamedXContentRegistry.Entry(  
    // pkg private for tests
        addAllocationDecider(deciders, new ResizeAllocationDecider());
     * @param clusterState the cluster state to filter the customs from
            )  
        if (shardStateActionClass == ShardStateAction.class) {
 * The OpenSearch Contributors require contributions made to  
        SnapshotsInfoService snapshotsInfoService,  
        );
import org.opensearch.core.common.io.stream.NamedWriteable;
        List<NamedXContentRegistry.Entry> entries = new ArrayList<>();
        bind(MetadataMappingService.class).asEagerSingleton();  
import java.util.ArrayList;
        addAllocationDecider(deciders, new NodeVersionAllocationDecider(settings));  
        shardsAllocator.setRerouteService(rerouteService);
import java.util.HashMap;
            ComponentTemplateMetadata::new,  
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;  
 * under the License.  
        Reader<NamedDiff> diffReader  
            bind(ShardStateAction.class).asEagerSingleton();
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;  
    private static List<ExpressionResolver> getCustomResolvers(List<ClusterPlugin> clusterPlugins) {
    public void setRerouteServiceForAllocator(RerouteService rerouteService) {  
        registerMetadataCustom(entries, ScriptMetadata.TYPE, ScriptMetadata::new, ScriptMetadata::readDiffFrom);
    }
    ) {
import org.opensearch.cluster.deployment.DeploymentMetadata;  
 */
        List<ClusterPlugin> clusterPlugins,
    public ClusterModule(
/**
        addAllocationDecider(deciders, new MaxRetryAllocationDecider());
        addAllocationDecider(deciders, new ThrottlingAllocationDecider(settings, clusterSettings));
 * specific language governing permissions and limitations
        ClusterSettings clusterSettings,
        }
        bind(DelayedAllocationService.class).asEagerSingleton();  
        });
        addAllocationDecider(deciders, new AwarenessAllocationDecider(settings, clusterSettings));
import org.opensearch.cluster.metadata.MetadataMappingService;
package org.opensearch.cluster;
        clusterPlugins.stream()
        bind(TaskResultsService.class).asEagerSingleton();
        } else {  
        registerCustom(entries, Metadata.Custom.class, name, reader, diffReader);
                new ParseField(PersistentTasksCustomMetadata.TYPE),
            )
            entries,
import org.opensearch.cluster.metadata.ComposableIndexTemplateMetadata;
    }
            if (PRE_6_3_METADATA_CUSTOMS_WHITE_LIST.contains(name) == false) {
            .forEach(d -> addAllocationDecider(deciders, d));  
import org.opensearch.common.util.set.Sets;
        allocators.put(BALANCED_ALLOCATOR, () -> new BalancedShardsAllocator(settings, clusterSettings));  
import java.util.function.Supplier;  
        // Metadata
                new ParseField(ComponentTemplateMetadata.TYPE),  
import org.opensearch.cluster.routing.DelayedAllocationService;
    public static Collection<AllocationDecider> createAllocationDeciders(  
        entries.add(
        entries.add(  
        clusterPlugins.stream().flatMap(c -> c.getIndexNameCustomResolvers().stream()).forEach(r -> addCustomResolver(resolvers, r));
import org.opensearch.common.settings.Settings;  
    ) {  
        return allocationService;  
    private final ClusterManagerMetrics clusterManagerMetrics;
        existingShardsAllocators.put(ShardsBatchGatewayAllocator.ALLOCATOR_NAME, shardsBatchGatewayAllocator);
import java.util.Set;
    private static void addAllocationDecider(Map<Class, AllocationDecider> deciders, AllocationDecider decider) {  
    );  
    private static void addCustomResolver(
    }  
    ) {
                    throw new IllegalArgumentException(
 * You may obtain a copy of the License at  
import java.util.List;
    ) {
            new NamedXContentRegistry.Entry(
/*  
            allocationDeciders,  
import org.opensearch.cluster.routing.allocation.decider.NodeLoadAwareAllocationDecider;
        IndexNameExpressionResolver.ExpressionResolver customResolver
            }
    final ShardsAllocator shardsAllocator;  
            ComposableIndexTemplateMetadata::new,  
                }  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver.ExpressionResolver;  
import org.opensearch.cluster.routing.allocation.decider.SearchReplicaAllocationDecider;
    // TODO: this is public so allocation benchmark can access the default deciders...can we do that in another way?
            });
        List<Entry> entries,
    }
    public static ClusterState filterCustomsForPre63Clients(ClusterState clusterState) {
    @Override  
            ComponentTemplateMetadata.TYPE,
    }  
import org.opensearch.search.pipeline.SearchPipelineMetadata;  
        entries.add(new Entry(category, name, reader));
        entries.add(  
 * Licensed to Elasticsearch under one or more contributor  
    ) {  
import org.opensearch.cluster.routing.RerouteService;
    }  
        }
    private static ShardsAllocator createShardsAllocator(  
 *  
            settings,
import org.opensearch.core.ParseField;  
            RepositoryCleanupInProgress::readDiffFrom  
 * license agreements. See the NOTICE file distributed with
            shardsAllocator,
    }  
        Settings settings,
        registerMetadataCustom(entries, DeploymentMetadata.TYPE, DeploymentMetadata::new, DeploymentMetadata::readDiffFrom);  
import org.opensearch.cluster.deployment.DeploymentAllocationDecider;
import org.opensearch.snapshots.SnapshotsInfoService;
        );
 * software distributed under the License is distributed on an
        addAllocationDecider(deciders, new FilterAllocationDecider(settings, clusterSettings));  
 */  
            DecommissionAttributeMetadata::readDiffFrom
    public AllocationService getAllocationService() {
            new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(ScriptMetadata.TYPE), ScriptMetadata::fromXContent)  
import org.opensearch.cluster.metadata.DataStreamMetadata;  
        Map<Class, IndexNameExpressionResolver.ExpressionResolver> resolvers = new HashMap<>();  
                WorkloadGroupMetadata::fromXContent
        addAllocationDecider(deciders, new ReplicaAfterPrimaryActiveAllocationDecider());  
        bind(GatewayAllocator.class).asEagerSingleton();
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
        Class<T> category,  
        bind(MetadataDeleteIndexService.class).asEagerSingleton();
        Class<? extends ShardStateAction> shardStateActionClass  
        clusterState.metadata().customs().keySet().iterator().forEachRemaining(name -> {  
        registerMetadataCustom(  
        registerMetadataCustom(entries, RepositoriesMetadata.TYPE, RepositoriesMetadata::new, RepositoriesMetadata::readDiffFrom);  
            clusterManagerMetrics
import org.opensearch.cluster.metadata.MetadataIndexFieldDomainService;
        addAllocationDecider(deciders, new WarmDiskThresholdDecider(settings, clusterSettings));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @SuppressWarnings("removal") // ViewMetadata is kept only for rolling upgrades from pre-3.10 nodes
        entries.add(new Entry(Task.Status.class, PersistentTasksNodeService.Status.NAME, PersistentTasksNodeService.Status::new));  
    }
        if (deciders.put(decider.getClass(), decider) != null) {
            )
     *  
        // collect deciders by class so that we can detect duplicates
    final Collection<AllocationDecider> deciderList;
            new NamedXContentRegistry.Entry(
        );
import org.opensearch.cluster.metadata.MetadataIndexStateService;
     * from the cluster state that the client might not be able to deserialize
        final ClusterState.Builder builder = ClusterState.builder(clusterState);
        Reader<? extends T> reader,
            new NamedXContentRegistry.Entry(
        entries.add(
        bind(IndexNameExpressionResolver.class).toInstance(indexNameExpressionResolver);
}  
                if (existingShardsAllocators.put(allocatorName, existingShardsAllocatorEntry.getValue()) != null) {
            new NamedXContentRegistry.Entry(Metadata.Custom.class, new ParseField(IngestMetadata.TYPE), IngestMetadata::fromXContent)
    private final IndexNameExpressionResolver indexNameExpressionResolver;  
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;  
                DataStreamMetadata::fromXContent  
        Map<String, Supplier<ShardsAllocator>> allocators = new HashMap<>();
            PersistentTasksCustomMetadata::readDiffFrom
        bind(MetadataIndexAliasesService.class).asEagerSingleton();
            SnapshotDeletionsInProgress.TYPE,
    private static <T extends Metadata.Custom> void registerMetadataCustom(
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.persistent.PersistentTasksNodeService;  
        registerMetadataCustom(entries, ViewMetadata.TYPE, ViewMetadata::new, ViewMetadata::readDiffFrom);
        );  
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
        entries.add(
 * Configures classes and services that affect the entire cluster.  
        entries.add(
        );
 * this file be licensed under the Apache-2.0 license or a
        this.clusterService = clusterService;  
 */  
            RepositoryCleanupInProgress.TYPE,
        registerClusterCustom(
        allocationService.setExistingShardsAllocators(existingShardsAllocators);  
    /**  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry.Entry;
 * ownership. Elasticsearch licenses this file to you under  
        addAllocationDecider(deciders, new ConcurrentRebalanceAllocationDecider(settings, clusterSettings));  
    ) {
 */  
                PersistentTasksCustomMetadata::fromXContent  
                            + "] from ["
            entries,  
    }
        entries.add(
        addAllocationDecider(deciders, new RestoreInProgressAllocationDecider());
        ClusterInfoService clusterInfoService,
            new NamedXContentRegistry.Entry(
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
                new ParseField(ComposableIndexTemplateMetadata.TYPE),
            .flatMap(p -> p.createAllocationDeciders(settings, clusterSettings).stream())
        final Map<String, ExistingShardsAllocator> existingShardsAllocators = new HashMap<>();  
    );
        registerClusterCustom(
    protected void configure() {
        bind(MetadataIndexFieldDomainService.class).asEagerSingleton();
