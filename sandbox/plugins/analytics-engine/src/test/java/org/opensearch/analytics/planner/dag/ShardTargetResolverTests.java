        // metadata().index(...). Return a mapping-less IndexMetadata so schema-compat validation
        when(iterA.nextOrNull()).thenReturn(routingA);
    private JavaTypeFactoryImpl typeFactory;
import org.apache.calcite.plan.RelOptCluster;
        IndexMetadata imdA = mock(IndexMetadata.class);  
            )
        when(routingB.currentNodeId()).thenReturn("node-b");
        ClusterState stateB = mock(ClusterState.class);  
        List<ShardIterator> iterators = new ArrayList<>();  
            String uuid = i < 3 ? "uuid-a" : "uuid-b";  
import org.opensearch.cluster.ClusterState;
        when(
                eq(clusterState),  
                any(String[].class)
        List<ShardIterator> iterators = new ArrayList<>();  
            when(routing.shardId()).thenReturn(new ShardId(new Index(idx, uuid), i % 2));  
        );
    /**  
        when(clusterState.nodes()).thenReturn(nodes);
        when(imdA.getIndex()).thenReturn(new Index("idx_a", "uuid-a"));
     * When the resolved shard count is exactly at the limit for a multi-index query,
                any(String[].class)  
import org.opensearch.cluster.routing.ShardIterator;  
        TreeMap<String, IndexAbstraction> lookup = new TreeMap<>();
        RelNode fragment = stubScanForAlias("my_alias");
        // After the resolver returns concrete names, IndexResolution.resolve looks each up via  
            when(nodes.get("node-" + i)).thenReturn(node);
        when(metadata.index("big_index")).thenReturn(imd);
            new GroupShardsIterator<>(iterators)
            when(iter.nextOrNull()).thenReturn(routing);
 * The OpenSearch Contributors require contributions made to  
        DiscoveryNodes nodesB = mock(DiscoveryNodes.class);
import org.apache.calcite.rex.RexBuilder;
        IndexMetadata imd = mock(IndexMetadata.class);  
        when(opRouting.searchShards(eq(clusterState), eq(new String[] { "big_index" }), any(), any())).thenReturn(
     */  
     * Two cluster states with the same alias pointing to different concrete indices. The first
        for (int i = 0; i < shardCount; i++) {
        Settings settings = Settings.builder().put(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), limit).build();  
                org.mockito.ArgumentMatchers.anyBoolean(),
import static org.mockito.ArgumentMatchers.any;  
        when(imdB.getIndex()).thenReturn(new Index("idx_b", "uuid-b"));  
                any(IndicesOptions.class),
        IndexAbstraction aliasAbstraction = mock(IndexAbstraction.class);
            when(node.getId()).thenReturn("node-" + i);  
        when(routingB.shardId()).thenReturn(shardB);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);  
        Settings settings = Settings.builder().put(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), limit).build();  
        Metadata metadata = mock(Metadata.class);  
        Metadata metaA = mock(Metadata.class);
        IndexMetadata imdB = mock(IndexMetadata.class);
            DiscoveryNode node = mock(DiscoveryNode.class);  
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.cluster.routing.ShardRouting;
        ShardTargetResolver resolverUnderTest = new ShardTargetResolver(fragment, clusterService, resolver);
    }
        );
    }  
import org.apache.calcite.rel.core.TableScan;
import java.util.Set;  
     * to {@code Long.MAX_VALUE}, so an unconfigured cluster fans out freely and the can-match
        when(clusterState.metadata()).thenReturn(metadata);
            iterators.add(iter);
    }
                org.mockito.ArgumentMatchers.anyBoolean(),
        Metadata metadata = mock(Metadata.class);
                eq(clusterState),
        when(routingA.shardId()).thenReturn(shardA);  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        List<ExecutionTarget> targetsA = resolverUnderTest.resolve(stateA, null);
    public void testResolveReRunsAgainstPassedClusterState() {
                any(String[].class)  
     * for the coordinator as the same shards spread across an alias, so it is rejected too. Vanilla's  
        assertTrue(ex.getMessage().contains("[" + limit + "]"));  
            resolver.concreteIndexNames(
            when(iter.nextOrNull()).thenReturn(routing);  
import org.opensearch.action.search.TransportSearchAction;  
        when(imdA.getAliases()).thenReturn(Map.of("my_alias", aliasMd));
            DiscoveryNode node = mock(DiscoveryNode.class);
        when(imdB.getAliases()).thenReturn(Map.of("my_alias", aliasMd));  
import org.opensearch.cluster.node.DiscoveryNode;
        when(clusterState.metadata()).thenReturn(metadata);
        assertSame("first resolve must surface state-A's node", nodeA, targetsA.get(0).node());
    }
                org.mockito.ArgumentMatchers.anyBoolean(),  
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);  
            resolver.concreteIndexNames(  
    /**
    @Override
        ).thenReturn(new String[] { "big_index" });  
            when(routing.currentNodeId()).thenReturn("node-" + i);  
        IndexMetadata imd = mock(IndexMetadata.class);  
        when(nodeB.getId()).thenReturn("node-b");
        return new TableScan(cluster, cluster.traitSet(), List.of(), table) {  
     * Nothing is rejected until an operator opts in. {@code action.search.shard_count.limit} defaults
        when(nodesA.get("node-a")).thenReturn(nodeA);  
        OperationRouting routing = mock(OperationRouting.class);
                org.mockito.ArgumentMatchers.anyBoolean(),
        when(routing.searchShards(eq(stateA), eq(new String[] { "idx_a" }), any(), any())).thenReturn(  
            String idx = i < 2 ? "idx_a" : "idx_b";
     * resolve() must throw an {@link IllegalArgumentException} with the alias name in the message.
            iterators.add(iter);  
        super.setUp();  
        OperationRouting opRouting = mock(OperationRouting.class);  
        assertTrue(ex.getMessage().contains("[" + shardCount + "] shards"));
        when(clusterState.nodes()).thenReturn(nodes);  
            iterators.add(iter);
        assertEquals("an unconfigured limit rejects nothing", shardCount, targets.size());
            resolver.concreteIndexNames(
            ShardIterator iter = mock(ShardIterator.class);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            resolver.concreteIndexNames(
        when(imdA.getState()).thenReturn(IndexMetadata.State.OPEN);
            when(node.getId()).thenReturn("node-" + i);  
        Metadata metadata = mock(Metadata.class);  
        ClusterState clusterState = mock(ClusterState.class);
import static org.mockito.ArgumentMatchers.eq;
        for (int i = 0; i < limit; i++) {
        when(metadata.index("idx_b")).thenReturn(imdB);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        when(  
                return this;  
import org.opensearch.core.index.Index;
            new GroupShardsIterator<>(iterators)  
import org.opensearch.cluster.routing.OperationRouting;
            DiscoveryNode node = mock(DiscoveryNode.class);
        when(stateA.metadata()).thenReturn(metaA);  
 * compatible open source license.
     */
        ).thenReturn(new String[] { "idx_a", "idx_b" });
        when(
import org.opensearch.cluster.routing.GroupShardsIterator;
            )
        when(imdA.getState()).thenReturn(IndexMetadata.State.OPEN);
    }
        assertEquals("first resolve must surface state-A's shard", shardA, ((ShardExecutionTarget) targetsA.get(0)).shardId());
        when(imdA.getAliases()).thenReturn(Map.of("my_alias", aliasMd));
                eq(clusterState),
import java.util.Map;
        when(clusterState.nodes()).thenReturn(nodes);  
            resolver.concreteIndexNames(  
        when(imdB.getIndex()).thenReturn(new Index("idx_b", "uuid-b"));  
        ClusterService clusterService = mock(ClusterService.class);
        assertSame("second resolve must surface state-B's node", nodeB, targetsB.get(0).node());
    public void setUp() throws Exception {
                any(String[].class)
        when(imdB.getState()).thenReturn(IndexMetadata.State.OPEN);
 *
        when(clusterState.metadata()).thenReturn(metadata);
            DiscoveryNode node = mock(DiscoveryNode.class);
import org.apache.calcite.plan.hep.HepProgramBuilder;  
        ShardId shardB = new ShardId(new Index("idx_b", "uuid-b"), 0);
        }
        int shardCount = 5;  
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);  
        int limit = 3;  
        ClusterService clusterService = mock(ClusterService.class);
/**
     */
        };
import org.apache.calcite.rel.type.RelDataType;  
    /**
        when(stateB.metadata()).thenReturn(metaB);
        when(imdA.getIndex()).thenReturn(new Index("idx_a", "uuid-a"));
package org.opensearch.analytics.planner.dag;
        OperationRouting opRouting = mock(OperationRouting.class);  
            when(routing.shardId()).thenReturn(new ShardId(new Index("big_index", "uuid-big"), i));
        when(aliasAbstraction.getIndices()).thenReturn(List.of(imdA, imdB));
import org.opensearch.cluster.service.ClusterService;
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            when(node.getId()).thenReturn("node-" + i);  
 * Pins the freshness contract of {@link ShardTargetResolver#resolve}: each call must re-resolve  
            when(iter.nextOrNull()).thenReturn(routing);  
        when(metadata.index("idx_b")).thenReturn(imdB);
                any(IndicesOptions.class),
import org.opensearch.cluster.metadata.Metadata;
        );
        // Empty getIndicesLookup() forces IndexResolution.resolve to fall through to the resolver
        when(
            public RelNode copy(RelTraitSet traitSet, List<RelNode> inputs) {
        ShardIterator iterA = mock(ShardIterator.class);
                eq(clusterState),
        when(imdB.getIndex()).thenReturn(new Index("idx_b", "uuid-b"));  
        ClusterService clusterService = mock(ClusterService.class);
        when(imdA.getIndex()).thenReturn(new Index("idx_a", "uuid-a"));
        assertTrue(ex.getMessage(), ex.getMessage().contains("[" + shardCount + "] shards"));
        ).thenReturn(new String[] { "idx_a" });
                eq(stateB),
        when(aliasAbstraction.getType()).thenReturn(IndexAbstraction.Type.ALIAS);  
        IndexMetadata imdB = mock(IndexMetadata.class);
            iterators.add(iter);
                any(String[].class)
        ClusterSettings clusterSettings = new ClusterSettings(settings, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
        }
    /** Minimal table scan referencing {@code aliasName} so {@code findTableName} surfaces it. */  
        int shardCount = 5;
        when(clusterState.nodes()).thenReturn(nodes);
        DiscoveryNode nodeB = mock(DiscoveryNode.class);  
    public void testResolveSucceedsAtExactLimitForAlias() {
}
    public void testResolveIsUnlimitedByDefault() {
        when(opRouting.searchShards(eq(clusterState), eq(new String[] { "idx_a", "idx_b" }), any(), any())).thenReturn(
        RelDataType rowType = typeFactory.builder().add("v", typeFactory.createSqlType(SqlTypeName.INTEGER)).build();
            ShardIterator iter = mock(ShardIterator.class);
        int limit = 3;  
            )
            when(iter.nextOrNull()).thenReturn(routing);  
        lookup.put("my_alias", aliasAbstraction);  
        when(iterB.nextOrNull()).thenReturn(routingB);
        RelNode fragment = stubScanForAlias("my_alias");  
            when(nodes.get("node-" + i)).thenReturn(node);
            )
        int limit = 3;
        AliasMetadata aliasMd = mock(AliasMetadata.class);  
            when(routing.currentNodeId()).thenReturn("node-" + i);  
        // First resolve hits state A → shard on node-a / idx_a.
        ClusterSettings clusterSettings = new ClusterSettings(settings, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));  
            ShardRouting routing = mock(ShardRouting.class);
            when(routing.currentNodeId()).thenReturn("node-" + i);  
        when(
import org.opensearch.action.support.IndicesOptions;
        RelNode fragment = stubScanForAlias("big_index");  
import org.opensearch.test.OpenSearchTestCase;
import static org.mockito.Mockito.mock;
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        TreeMap<String, IndexAbstraction> lookup = new TreeMap<>();
        when(table.getQualifiedName()).thenReturn(List.of(aliasName));
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);  
        when(stateA.nodes()).thenReturn(nodesA);
                any(IndicesOptions.class),
        when(clusterService.operationRouting()).thenReturn(routing);
     * {@code failIfOverShardCountLimit} draws no distinction either, and it can afford not to because
     */
        // configured to map it to a different concrete index per cluster-state object identity.
        when(stateB.nodes()).thenReturn(nodesB);  
        when(imdB.getAliases()).thenReturn(Map.of("my_alias", aliasMd));  
                any(String[].class)
        AliasMetadata aliasMd = mock(AliasMetadata.class);  
        when(
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        when(metaA.index("idx_a")).thenReturn(imdA);
        RelNode fragment = stubScanForAlias("big_index");  
        List<ExecutionTarget> targetsB = resolverUnderTest.resolve(stateB, null);  
                eq(stateA),  
        ShardTargetResolver resolverUnderTest = new ShardTargetResolver(fragment, clusterService, resolver);
        lookup.put("my_alias", aliasAbstraction);  
        // path (no literal alias match), which is the path under test.  
        List<ExecutionTarget> targets = resolverUnderTest.resolve(clusterState, null);
 * construction time. A regression that caches concrete indices upfront would dispatch to stale
        when(metadata.index("idx_a")).thenReturn(imdA);  
            ShardRouting routing = mock(ShardRouting.class);
        OperationRouting opRouting = mock(OperationRouting.class);  
        assertTrue(ex.getMessage(), ex.getMessage().contains("action.search.shard_count.limit"));  
 */  
            new GroupShardsIterator<>(List.of(iterB))
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < shardCount; i++) {
     * resolve() must succeed.  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);
        for (int i = 0; i < shardCount; i++) {
        List<ShardIterator> iterators = new ArrayList<>();
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
            when(node.getId()).thenReturn("node-" + i);
            )
        );
        }
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.plan.hep.HepPlanner;
        when(opRouting.searchShards(eq(clusterState), eq(new String[] { "big_index" }), any(), any())).thenReturn(
            }
import org.opensearch.cluster.metadata.AliasMetadata;  
            ShardRouting routing = mock(ShardRouting.class);  
        when(clusterService.operationRouting()).thenReturn(opRouting);  
/*  
        IndexMetadata imdB = mock(IndexMetadata.class);
        IndexMetadata imdA = mock(IndexMetadata.class);  
        ShardTargetResolver resolverUnderTest = new ShardTargetResolver(fragment, clusterService, resolver);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import org.opensearch.common.settings.ClusterSettings;  
        assertEquals("second resolve must surface state-B's shard", shardB, ((ShardExecutionTarget) targetsB.get(0)).shardId());  
            when(nodes.get("node-" + i)).thenReturn(node);
        when(metaA.getIndicesLookup()).thenReturn(new TreeMap<>());
import org.opensearch.cluster.metadata.IndexAbstraction;
import static org.mockito.Mockito.when;  
        when(imd.getIndex()).thenReturn(new Index("big_index", "uuid-big"));
    private RelOptCluster cluster;
        ShardIterator iterB = mock(ShardIterator.class);  
        RelOptTable table = mock(RelOptTable.class);  
        // Exactly 3 shards across 2 indices — at the limit.
        ClusterState clusterState = mock(ClusterState.class);
        ClusterService clusterService = mock(ClusterService.class);
            new GroupShardsIterator<>(List.of(iterA))
            ShardIterator iter = mock(ShardIterator.class);
                any(IndicesOptions.class),  
            new GroupShardsIterator<>(iterators)  
import org.apache.calcite.rel.RelNode;
        ShardTargetResolver resolverUnderTest = new ShardTargetResolver(fragment, clusterService, resolver);
        when(clusterService.operationRouting()).thenReturn(opRouting);
        when(clusterService.operationRouting()).thenReturn(opRouting);
import java.util.ArrayList;  
        when(metadata.getIndicesLookup()).thenReturn(new TreeMap<>());
        ClusterState clusterState = mock(ClusterState.class);
        when(metaB.getIndicesLookup()).thenReturn(new TreeMap<>());
        when(aliasAbstraction.getType()).thenReturn(IndexAbstraction.Type.ALIAS);  
        when(clusterState.metadata()).thenReturn(metadata);  
            ShardIterator iter = mock(ShardIterator.class);
        IndexNameExpressionResolver resolver = mock(IndexNameExpressionResolver.class);  
            String idx = i < 3 ? "idx_a" : "idx_b";
        DiscoveryNodes nodesA = mock(DiscoveryNodes.class);  
            resolver.concreteIndexNames(  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
        );  
                any(IndicesOptions.class),
        assertEquals(1, targetsA.size());  
                any(IndicesOptions.class),
     */  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
    }
            new GroupShardsIterator<>(iterators)  
        when(metadata.index("idx_a")).thenReturn(imdA);  
        ).thenReturn(new String[] { "idx_a", "idx_b" });  
    public void testResolveRejectsAliasExceedingMaxShardsPerQuery() {
import org.opensearch.common.settings.Settings;
            )  
import java.util.TreeMap;
        when(metadata.index("big_index")).thenReturn(imd);
        // this assertion fails (targets would still be on node-a / idx_a).
            when(routing.currentNodeId()).thenReturn("node-" + i);
        ShardRouting routingA = mock(ShardRouting.class);
            @Override
        );
import org.apache.calcite.plan.RelOptTable;  
     * the limit is unlimited by default — see {@link #testResolveIsUnlimitedByDefault}.
    private TableScan stubScanForAlias(String aliasName) {
        assertTrue(ex.getMessage().contains("alias [my_alias]"));
import java.util.List;
        // Two distinct mocked cluster states. The alias expression is the same; the resolver is  
        OperationRouting opRouting = mock(OperationRouting.class);
        // no-ops (it skips indices whose mapping() returns null).
            when(routing.shardId()).thenReturn(new ShardId(new Index(idx, uuid), i % 3));
        when(metadata.getIndicesLookup()).thenReturn(lookup);
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> resolverUnderTest.resolve(clusterState, null));  
        when(imd.getIndex()).thenReturn(new Index("big_index", "uuid-big"));
        Settings settings = Settings.builder().put(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey(), limit).build();
        when(routingA.currentNodeId()).thenReturn("node-a");
        when(aliasAbstraction.getIndices()).thenReturn(List.of(imdA, imdB));
        // Set up alias in the indices lookup so IndexResolution takes the alias path.
public class ShardTargetResolverTests extends OpenSearchTestCase {
        when(routing.searchShards(eq(stateB), eq(new String[] { "idx_b" }), any(), any())).thenReturn(  
import org.opensearch.cluster.metadata.IndexMetadata;
            when(routing.shardId()).thenReturn(new ShardId(new Index("big_index", "uuid-big"), i));
        ShardTargetResolver resolverUnderTest = new ShardTargetResolver(fragment, clusterService, resolver);  
        assertEquals(limit, targets.size());  
        when(aliasMd.filteringRequired()).thenReturn(false);
                org.mockito.ArgumentMatchers.anyBoolean(),  
            when(nodes.get("node-" + i)).thenReturn(node);
        assertTrue(ex.getMessage().contains("action.search.shard_count.limit"));
import org.apache.calcite.plan.RelTraitSet;
        ).thenReturn(new String[] { "idx_b" });
        ClusterService clusterService = mock(ClusterService.class);
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        when(clusterService.operationRouting()).thenReturn(opRouting);
        when(opRouting.searchShards(eq(clusterState), eq(new String[] { "idx_a", "idx_b" }), any(), any())).thenReturn(
        // Settings.EMPTY — the setting is registered but never set, so its default applies.  
        ShardId shardA = new ShardId(new Index("idx_a", "uuid-a"), 0);  
        IndexMetadata imdA = mock(IndexMetadata.class);  
                org.mockito.ArgumentMatchers.anyBoolean(),  
    public void testResolveRejectsSingleIndexExceedingLimit() {
        Metadata metadata = mock(Metadata.class);  
        when(imdB.getState()).thenReturn(IndexMetadata.State.OPEN);
        List<ExecutionTarget> targets = resolverUnderTest.resolve(clusterState, null);  
        when(nodesB.get("node-b")).thenReturn(nodeB);
        assertTrue(ex.getMessage(), ex.getMessage().contains("big_index"));
        ).thenReturn(new String[] { "big_index" });  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> resolverUnderTest.resolve(clusterState, null));  
     * When an alias resolves to multiple indices and the total shard count exceeds the limit,
        // 5 total shards across the two indices.
 * the index name against the supplied {@link ClusterState}, never a snapshot taken at
        when(aliasMd.filteringRequired()).thenReturn(false);
        when(metadata.getIndicesLookup()).thenReturn(lookup);
        int shardCount = 5;  
     * pre-filter plus the per-node dispatch throttle are what bound the work.  
 * SPDX-License-Identifier: Apache-2.0
        typeFactory = new JavaTypeFactoryImpl();
        ClusterState stateA = mock(ClusterState.class);
     * The ceiling counts shards, not indices: one oversharded concrete index is exactly as expensive
        }
    /**  
        assertEquals(1, targetsB.size());
        Metadata metaB = mock(Metadata.class);
        ClusterState clusterState = mock(ClusterState.class);
import org.opensearch.cluster.node.DiscoveryNodes;  
        RelNode fragment = stubScanForAlias("my_alias");
        when(nodeA.getId()).thenReturn("node-a");
 * shards when an alias gets re-pointed mid-query.  
        List<ShardIterator> iterators = new ArrayList<>();  
            String uuid = i < 2 ? "uuid-a" : "uuid-b";
        ShardRouting routingB = mock(ShardRouting.class);  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
     * resolve() must produce shards on node-a; the second must produce shards on node-b. If the
        DiscoveryNode nodeA = mock(DiscoveryNode.class);
     * resolver cached state at construction, both calls would return the same targets.  
    /**  
 */
        when(table.getRowType()).thenReturn(rowType);
        ClusterSettings clusterSettings = new ClusterSettings(settings, Set.of(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING));
        IndexAbstraction aliasAbstraction = mock(IndexAbstraction.class);
            ShardRouting routing = mock(ShardRouting.class);
        // Second resolve hits state B → shard on node-b / idx_b. If the resolver cached state,
        when(metaB.index("idx_b")).thenReturn(imdB);
        when(metadata.getIndicesLookup()).thenReturn(new TreeMap<>());
    }
