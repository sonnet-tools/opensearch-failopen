            resolver.concreteIndexNames(
                any(IndicesOptions.class),
        when(metadata.index("big_index")).thenReturn(imd);
            ShardRouting routing = mock(ShardRouting.class);
            when(routing.shardId()).thenReturn(new ShardId(new Index("big_index", "uuid-big"), i));
        for (int i = 0; i < shardCount; i++) {
        when(clusterState.nodes()).thenReturn(nodes);
        IndexMetadata imdB = mock(IndexMetadata.class);
            ShardIterator iter = mock(ShardIterator.class);
        TreeMap<String, IndexAbstraction> lookup = new TreeMap<>();
    }
        ).thenReturn(new String[] { "idx_b" });
import java.util.List;
        List<ShardIterator> iterators = new ArrayList<>();
            )
 *
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
        // metadata().index(...). Return a mapping-less IndexMetadata so schema-compat validation
            resolver.concreteIndexNames(
                org.mockito.ArgumentMatchers.anyBoolean(),
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        ).thenReturn(new String[] { "big_index" });
        when(routingB.currentNodeId()).thenReturn("node-b");
        assertEquals("first resolve must surface state-A's shard", shardA, ((ShardExecutionTarget) targetsA.get(0)).shardId());
}
        assertTrue(ex.getMessage().contains("action.search.shard_count.limit"));
        Metadata metadata = mock(Metadata.class);
        int shardCount = 5;
        IndexMetadata imdA = mock(IndexMetadata.class);
        when(imdB.getAliases()).thenReturn(Map.of("my_alias", aliasMd));
import org.opensearch.core.index.Index;
        when(imdA.getAliases()).thenReturn(Map.of("my_alias", aliasMd));
import org.opensearch.cluster.node.DiscoveryNodes;
            when(nodes.get("node-" + i)).thenReturn(node);
        assertTrue(ex.getMessage().contains("[" + shardCount + "] shards"));
        when(nodesA.get("node-a")).thenReturn(nodeA);
        when(aliasMd.filteringRequired()).thenReturn(false);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        when(imdB.getIndex()).thenReturn(new Index("idx_b", "uuid-b"));
    /** Minimal table scan referencing {@code aliasName} so {@code findTableName} surfaces it. */
     * resolve() must produce shards on node-a; the second must produce shards on node-b. If the
        RelNode fragment = stubScanForAlias("big_index");
        typeFactory = new JavaTypeFactoryImpl();
                any(String[].class)
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
import java.util.ArrayList;
            String idx = i < 3 ? "idx_a" : "idx_b";
import org.opensearch.cluster.metadata.IndexMetadata;
                any(IndicesOptions.class),
            )
        ShardId shardB = new ShardId(new Index("idx_b", "uuid-b"), 0);
        assertEquals("an unconfigured limit rejects nothing", shardCount, targets.size());
        Metadata metadata = mock(Metadata.class);
        when(table.getQualifiedName()).thenReturn(List.of(aliasName));
        when(imdB.getAliases()).thenReturn(Map.of("my_alias", aliasMd));
import static org.mockito.Mockito.mock;
        when(routing.searchShards(eq(stateA), eq(new String[] { "idx_a" }), any(), any())).thenReturn(
        List<ExecutionTarget> targetsA = resolverUnderTest.resolve(stateA, null);
        List<ExecutionTarget> targets = resolverUnderTest.resolve(clusterState, null);
        when(clusterState.nodes()).thenReturn(nodes);
            )
        when(aliasAbstraction.getIndices()).thenReturn(List.of(imdA, imdB));
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            when(routing.shardId()).thenReturn(new ShardId(new Index("big_index", "uuid-big"), i));
/*
        ).thenReturn(new String[] { "idx_a", "idx_b" });
                org.mockito.ArgumentMatchers.anyBoolean(),
            @Override
        when(clusterState.metadata()).thenReturn(metadata);
        ShardTargetResolver resolverUnderTest = new ShardTargetResolver(fragment, clusterService, resolver);
package org.opensearch.analytics.planner.dag;
            String uuid = i < 3 ? "uuid-a" : "uuid-b";
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        for (int i = 0; i < shardCount; i++) {
        when(routingA.shardId()).thenReturn(shardA);
        when(clusterState.nodes()).thenReturn(nodes);
        when(stateB.nodes()).thenReturn(nodesB);
        when(clusterState.metadata()).thenReturn(metadata);
        IndexAbstraction aliasAbstraction = mock(IndexAbstraction.class);
        assertTrue(ex.getMessage(), ex.getMessage().contains("big_index"));
     */
        }
            ShardRouting routing = mock(ShardRouting.class);
        when(routingB.shardId()).thenReturn(shardB);
            ShardRouting routing = mock(ShardRouting.class);
        // this assertion fails (targets would still be on node-a / idx_a).
        OperationRouting routing = mock(OperationRouting.class);
            DiscoveryNode node = mock(DiscoveryNode.class);
    public void setUp() throws Exception {
            }
        IndexMetadata imdB = mock(IndexMetadata.class);
        TreeMap<String, IndexAbstraction> lookup = new TreeMap<>();
        lookup.put("my_alias", aliasAbstraction);
        when(
                eq(clusterState),
import org.opensearch.cluster.service.ClusterService;
        assertTrue(ex.getMessage(), ex.getMessage().contains("action.search.shard_count.limit"));
import org.apache.calcite.rel.core.TableScan;
        when(metadata.getIndicesLookup()).thenReturn(new TreeMap<>());
 * compatible open source license.
import org.opensearch.common.settings.Settings;
        Metadata metadata = mock(Metadata.class);
        OperationRouting opRouting = mock(OperationRouting.class);
                return this;
        OperationRouting opRouting = mock(OperationRouting.class);
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            iterators.add(iter);
        when(imdB.getState()).thenReturn(IndexMetadata.State.OPEN);
        when(opRouting.searchShards(eq(clusterState), eq(new String[] { "big_index" }), any(), any())).thenReturn(
        };
        ShardTargetResolver resolverUnderTest = new ShardTargetResolver(fragment, clusterService, resolver);
        when(metadata.getIndicesLookup()).thenReturn(new TreeMap<>());
        lookup.put("my_alias", aliasAbstraction);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
                eq(clusterState),
            String uuid = i < 2 ? "uuid-a" : "uuid-b";
import org.opensearch.cluster.ClusterState;
        RelDataType rowType = typeFactory.builder().add("v", typeFactory.createSqlType(SqlTypeName.INTEGER)).build();
        Settings settings = Settings.builder().put(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), limit).build();
        when(metaA.index("idx_a")).thenReturn(imdA);
     * resolver cached state at construction, both calls would return the same targets.
        ShardRouting routingA = mock(ShardRouting.class);
        ClusterService clusterService = mock(ClusterService.class);
            when(nodes.get("node-" + i)).thenReturn(node);
        RelNode fragment = stubScanForAlias("my_alias");
import org.opensearch.test.OpenSearchTestCase;
                org.mockito.ArgumentMatchers.anyBoolean(),
        // path (no literal alias match), which is the path under test.
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        OperationRouting opRouting = mock(OperationRouting.class);
            when(routing.currentNodeId()).thenReturn("node-" + i);
 */
import org.apache.calcite.plan.hep.HepProgramBuilder;
        when(table.getRowType()).thenReturn(rowType);
        AliasMetadata aliasMd = mock(AliasMetadata.class);
        }
            when(routing.currentNodeId()).thenReturn("node-" + i);
     * The ceiling counts shards, not indices: one oversharded concrete index is exactly as expensive
        ShardId shardA = new ShardId(new Index("idx_a", "uuid-a"), 0);
import org.opensearch.cluster.routing.OperationRouting;
                eq(clusterState),
            iterators.add(iter);
        ClusterService clusterService = mock(ClusterService.class);
 * shards when an alias gets re-pointed mid-query.
        when(clusterState.metadata()).thenReturn(metadata);
import org.apache.calcite.plan.hep.HepPlanner;
     * resolve() must succeed.
        when(imdA.getAliases()).thenReturn(Map.of("my_alias", aliasMd));
                eq(stateB),
        when(nodeB.getId()).thenReturn("node-b");
        );
    /**
        return new TableScan(cluster, cluster.traitSet(), List.of(), table) {
        OperationRouting opRouting = mock(OperationRouting.class);
        when(clusterState.nodes()).thenReturn(nodes);
        assertSame("second resolve must surface state-B's node", nodeB, targetsB.get(0).node());
        when(stateB.metadata()).thenReturn(metaB);
        when(iterA.nextOrNull()).thenReturn(routingA);
        DiscoveryNodes nodesB = mock(DiscoveryNodes.class);
        int limit = 3;
        when(opRouting.searchShards(eq(clusterState), eq(new String[] { "big_index" }), any(), any())).thenReturn(
     */
        }
            new GroupShardsIterator<>(iterators)
    }
     * When the resolved shard count is exactly at the limit for a multi-index query,
        // Second resolve hits state B → shard on node-b / idx_b. If the resolver cached state,
        // Empty getIndicesLookup() forces IndexResolution.resolve to fall through to the resolver
        when(aliasAbstraction.getType()).thenReturn(IndexAbstraction.Type.ALIAS);
            public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
        when(nodeA.getId()).thenReturn("node-a");
import org.opensearch.action.search.TransportSearchAction;
import org.apache.calcite.rel.type.RelDataType;
        when(
    private JavaTypeFactoryImpl typeFactory;
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> resolverUnderTest.resolve(clusterState, null));
    /**
        );
        ClusterState clusterState = mock(ClusterState.class);
        super.setUp();
        for (int i = 0; i < limit; i++) {
            when(routing.currentNodeId()).thenReturn("node-" + i);
import java.util.TreeMap;
import org.opensearch.common.settings.ClusterSettings;
        assertTrue(ex.getMessage().contains("[" + limit + "]"));
        int limit = 3;
 * the index name against the supplied {@link ClusterState}, never a snapshot taken at
        when(
        // 5 total shards across the two indices.
            when(iter.nextOrNull()).thenReturn(routing);
        when(metadata.getIndicesLookup()).thenReturn(lookup);
        ClusterSettings clusterSettings = new ClusterSettings(settings, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
            )
            when(nodes.get("node-" + i)).thenReturn(node);
                org.mockito.ArgumentMatchers.anyBoolean(),
import java.util.Set;
        when(aliasMd.filteringRequired()).thenReturn(false);
     * When an alias resolves to multiple indices and the total shard count exceeds the limit,
            when(iter.nextOrNull()).thenReturn(routing);
        List<ShardIterator> iterators = new ArrayList<>();
        ).thenReturn(new String[] { "idx_a", "idx_b" });
        DiscoveryNodes nodesA = mock(DiscoveryNodes.class);
            new GroupShardsIterator<>(iterators)
            iterators.add(iter);
        when(clusterService.operationRouting()).thenReturn(opRouting);
        IndexMetadata imdB = mock(IndexMetadata.class);
        ShardRouting routingB = mock(ShardRouting.class);
        when(metadata.index("idx_a")).thenReturn(imdA);
        List<ExecutionTarget> targetsB = resolverUnderTest.resolve(stateB, null);
                any(String[].class)
            new GroupShardsIterator<>(iterators)
        assertEquals(limit, targets.size());
        when(routingA.currentNodeId()).thenReturn("node-a");
            when(routing.currentNodeId()).thenReturn("node-" + i);
        when(metadata.getIndicesLookup()).thenReturn(lookup);
    /**
        IndexMetadata imd = mock(IndexMetadata.class);
        when(
        when(opRouting.searchShards(eq(clusterState), eq(new String[] { "idx_a", "idx_b" }), any(), any())).thenReturn(
     * to {@code Long.MAX_VALUE}, so an unconfigured cluster fans out freely and the can-match
import org.apache.calcite.rel.RelNode;
     * resolve() must throw an {@link IllegalArgumentException} with the alias name in the message.
        Settings settings = Settings.builder().put(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), limit).build();
                any(String[].class)
import org.apache.calcite.plan.RelTraitSet;
import org.opensearch.cluster.node.DiscoveryNode;
        when(metaB.getIndicesLookup()).thenReturn(new TreeMap<>());
                any(String[].class)
     * Two cluster states with the same alias pointing to different concrete indices. The first
        List<ShardIterator> iterators = new ArrayList<>();
        RelOptTable table = mock(RelOptTable.class);
 */
public class ShardTargetResolverTests extends OpenSearchTestCase {
import org.apache.calcite.rex.RexBuilder;
    /**
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        when(aliasAbstraction.getIndices()).thenReturn(List.of(imdA, imdB));
        // After the resolver returns concrete names, IndexResolution.resolve looks each up via
        ShardTargetResolver resolverUnderTest = new ShardTargetResolver(fragment, clusterService, resolver);
 * this file be licensed under the Apache-2.0 license or a
        ).thenReturn(new String[] { "big_index" });
            when(node.getId()).thenReturn("node-" + i);
            DiscoveryNode node = mock(DiscoveryNode.class);
            resolver.concreteIndexNames(
     * the limit is unlimited by default — see {@link #testResolveIsUnlimitedByDefault}.
        // configured to map it to a different concrete index per cluster-state object identity.
            when(node.getId()).thenReturn("node-" + i);
        ClusterService clusterService = mock(ClusterService.class);
            when(nodes.get("node-" + i)).thenReturn(node);
            resolver.concreteIndexNames(
        when(imdA.getIndex()).thenReturn(new Index("idx_a", "uuid-a"));
        List<ExecutionTarget> targets = resolverUnderTest.resolve(clusterState, null);
        ).thenReturn(new String[] { "idx_a" });
        assertTrue(ex.getMessage().contains("alias [my_alias]"));
        ClusterState stateB = mock(ClusterState.class);
import org.opensearch.cluster.metadata.IndexAbstraction;
        when(metadata.index("idx_b")).thenReturn(imdB);
        for (int i = 0; i < shardCount; i++) {
        when(metaA.getIndicesLookup()).thenReturn(new TreeMap<>());
 * Pins the freshness contract of {@link ShardTargetResolver#resolve}: each call must re-resolve
    @Override
        assertEquals("second resolve must surface state-B's shard", shardB, ((ShardExecutionTarget) targetsB.get(0)).shardId());
    private TableScan stubScanForAlias(String aliasName) {
 * SPDX-License-Identifier: Apache-2.0
     */
import org.opensearch.cluster.routing.GroupShardsIterator;
        // no-ops (it skips indices whose mapping() returns null).
    }
                org.mockito.ArgumentMatchers.anyBoolean(),
    }
     */
import org.apache.calcite.plan.RelOptTable;
        int shardCount = 5;
        IndexAbstraction aliasAbstraction = mock(IndexAbstraction.class);
        List<ShardIterator> iterators = new ArrayList<>();
        when(metadata.index("idx_a")).thenReturn(imdA);
import static org.mockito.ArgumentMatchers.eq;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
        ShardTargetResolver resolverUnderTest = new ShardTargetResolver(fragment, clusterService, resolver);
            when(iter.nextOrNull()).thenReturn(routing);
     */
        ShardTargetResolver resolverUnderTest = new ShardTargetResolver(fragment, clusterService, resolver);
        when(imdB.getState()).thenReturn(IndexMetadata.State.OPEN);
        assertTrue(ex.getMessage(), ex.getMessage().contains("[" + shardCount + "] shards"));
        when(metadata.index("big_index")).thenReturn(imd);
        when(imdB.getIndex()).thenReturn(new Index("idx_b", "uuid-b"));
        when(imdA.getState()).thenReturn(IndexMetadata.State.OPEN);
/**
        ShardIterator iterA = mock(ShardIterator.class);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            resolver.concreteIndexNames(
            resolver.concreteIndexNames(
    /**
            when(node.getId()).thenReturn("node-" + i);
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.ShardIterator;
        ClusterState stateA = mock(ClusterState.class);
        when(opRouting.searchShards(eq(clusterState), eq(new String[] { "idx_a", "idx_b" }), any(), any())).thenReturn(
import java.util.Map;
        // First resolve hits state A → shard on node-a / idx_a.
        when(stateA.metadata()).thenReturn(metaA);
        when(clusterService.operationRouting()).thenReturn(routing);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> resolverUnderTest.resolve(clusterState, null));
import org.opensearch.cluster.metadata.Metadata;
            ShardRouting routing = mock(ShardRouting.class);
     * Nothing is rejected until an operator opts in. {@code action.search.shard_count.limit} defaults
     * for the coordinator as the same shards spread across an alias, so it is rejected too. Vanilla's
            )
            new GroupShardsIterator<>(iterators)
        when(imd.getIndex()).thenReturn(new Index("big_index", "uuid-big"));
                any(IndicesOptions.class),
        RelNode fragment = stubScanForAlias("my_alias");
import org.opensearch.action.support.IndicesOptions;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import static org.mockito.ArgumentMatchers.any;
        ClusterService clusterService = mock(ClusterService.class);
    public void testResolveSucceedsAtExactLimitForAlias() {
            )
        when(
                eq(clusterState),
        );
     * {@code failIfOverShardCountLimit} draws no distinction either, and it can afford not to because
            when(routing.shardId()).thenReturn(new ShardId(new Index(idx, uuid), i % 3));
        RelNode fragment = stubScanForAlias("my_alias");
        when(metaB.index("idx_b")).thenReturn(imdB);
        RelNode fragment = stubScanForAlias("big_index");
    }
import org.apache.calcite.sql.type.SqlTypeName;
        when(imdA.getIndex()).thenReturn(new Index("idx_a", "uuid-a"));
                any(String[].class)
        when(clusterService.operationRouting()).thenReturn(opRouting);
                org.mockito.ArgumentMatchers.anyBoolean(),
        Metadata metaB = mock(Metadata.class);
        when(imdB.getIndex()).thenReturn(new Index("idx_b", "uuid-b"));
            ShardIterator iter = mock(ShardIterator.class);
        int limit = 3;
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        IndexMetadata imdA = mock(IndexMetadata.class);
            DiscoveryNode node = mock(DiscoveryNode.class);
        when(nodesB.get("node-b")).thenReturn(nodeB);
        IndexMetadata imdA = mock(IndexMetadata.class);
                any(IndicesOptions.class),
                any(IndicesOptions.class),
    }
        ShardIterator iterB = mock(ShardIterator.class);
            new GroupShardsIterator<>(List.of(iterA))
        DiscoveryNode nodeA = mock(DiscoveryNode.class);
import org.apache.calcite.plan.RelOptCluster;
        ClusterState clusterState = mock(ClusterState.class);
        ClusterState clusterState = mock(ClusterState.class);
        when(imdA.getIndex()).thenReturn(new Index("idx_a", "uuid-a"));
        assertSame("first resolve must surface state-A's node", nodeA, targetsA.get(0).node());
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        when(imd.getIndex()).thenReturn(new Index("big_index", "uuid-big"));
            DiscoveryNode node = mock(DiscoveryNode.class);
                eq(stateA),
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
    private RelOptCluster cluster;
            when(node.getId()).thenReturn("node-" + i);
        IndexMetadata imd = mock(IndexMetadata.class);
        when(clusterState.metadata()).thenReturn(metadata);
        when(stateA.nodes()).thenReturn(nodesA);
    public void testResolveRejectsSingleIndexExceedingLimit() {
        when(metadata.index("idx_b")).thenReturn(imdB);
        when(
        ClusterState clusterState = mock(ClusterState.class);
            when(routing.shardId()).thenReturn(new ShardId(new Index(idx, uuid), i % 2));
        Metadata metadata = mock(Metadata.class);
    public void testResolveIsUnlimitedByDefault() {
            when(iter.nextOrNull()).thenReturn(routing);
        DiscoveryNode nodeB = mock(DiscoveryNode.class);
     * pre-filter plus the per-node dispatch throttle are what bound the work.
        when(imdA.getState()).thenReturn(IndexMetadata.State.OPEN);
        when(routing.searchShards(eq(stateB), eq(new String[] { "idx_b" }), any(), any())).thenReturn(
        ClusterService clusterService = mock(ClusterService.class);
 * construction time. A regression that caches concrete indices upfront would dispatch to stale
 * The OpenSearch Contributors require contributions made to
        when(aliasAbstraction.getType()).thenReturn(IndexAbstraction.Type.ALIAS);
    }
        );
            new GroupShardsIterator<>(List.of(iterB))
        // Exactly 3 shards across 2 indices — at the limit.
import org.opensearch.core.index.shard.ShardId;
        assertEquals(1, targetsA.size());
        when(clusterService.operationRouting()).thenReturn(opRouting);
        ClusterSettings clusterSettings = new ClusterSettings(settings, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
            iterators.add(iter);
    public void testResolveRejectsAliasExceedingMaxShardsPerQuery() {
        when(iterB.nextOrNull()).thenReturn(routingB);
            String idx = i < 2 ? "idx_a" : "idx_b";
        // Settings.EMPTY — the setting is registered but never set, so its default applies.
            ShardIterator iter = mock(ShardIterator.class);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        int shardCount = 5;
                any(IndicesOptions.class),
        }
        // Set up alias in the indices lookup so IndexResolution takes the alias path.
        ClusterSettings clusterSettings = new ClusterSettings(settings, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
import org.opensearch.cluster.metadata.AliasMetadata;
                any(String[].class)
        when(clusterService.operationRouting()).thenReturn(opRouting);
            ShardIterator iter = mock(ShardIterator.class);
        Metadata metaA = mock(Metadata.class);
import static org.mockito.Mockito.when;
        // Two distinct mocked cluster states. The alias expression is the same; the resolver is
        );
    public void testResolveReRunsAgainstPassedClusterState() {
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
        );
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        assertEquals(1, targetsB.size());
        AliasMetadata aliasMd = mock(AliasMetadata.class);
        Settings settings = Settings.builder().put(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), limit).build();
