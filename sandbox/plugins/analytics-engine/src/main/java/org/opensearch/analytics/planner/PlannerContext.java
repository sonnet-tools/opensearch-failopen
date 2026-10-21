        boolean profilingEnabled
    ) {
    public PlannerContext(
    }
    }
    }
    public int nextAnnotationId() {
    public PlannerContext(
    private RuleProfilingListener.PlannerProfile lastProfile;
    public CapabilityRegistry getCapabilityRegistry() {
 */
     */
        ClusterState clusterState,
     * broadcast build overflowed the runtime cap, so {@code OpenSearchBroadcastJoinSplitRule}
 *
            indexNameExpressionResolver,
    private final ClusterState clusterState;
        this(capabilityRegistry, clusterState, null, profilingEnabled, true, Settings.EMPTY, DEFAULT_TABLE_ROW_COUNTS);
    }
    // (see DefaultPlanExecutor's broadcast→shuffle retry) so CBO falls back to hash-shuffle /
    private final Settings settings;
     * emits no broadcast alternative and CBO falls back to hash-shuffle / coordinator-centric.
    // Cluster settings the planner consults at planning time (oversampling factor + delegation
    // (indexNameExpressionResolver, profilingEnabled, preferMetadataDriver) come first, in
     * The cluster-level index name expression resolver, when available. Null in unit tests
        boolean profilingEnabled,
        return distributionTraitDef;
        return clusterState;
    }
    public DelegationBlockList getDelegationBlockList() {
    }
     * {@code IndexNameTable.getRowCount()}. Returns {@link #UNKNOWN_ROW_COUNT} for
    public PlannerContext(
     * that don't exercise alias/wildcard expansion; callers that need it for production
        this.plannerSettings = plannerSettings;
     * Mirrors the {@code analytics.planner.prefer_metadata_driver} cluster setting at planning
 * Holds capability registry (singleton, built at plugin startup), per-query cluster state,
     */
    public ToLongFunction<String> getTableRowCounts() {
    public Settings getSettings() {
    /** Stash the snapshot taken at the end of {@code runAllOptimizations}. Null when profiling was disabled. */
    public PlannerContext(CapabilityRegistry capabilityRegistry, ClusterState clusterState, Settings settings) {
        this.distributionTraitDef = new OpenSearchDistributionTraitDef(this);
    /**
    ) {
        this(
/*
        return preferMetadataDriver;
    @Nullable
    }
    /**
import java.util.function.ToLongFunction;
import org.opensearch.analytics.settings.DelegationBlockList;
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
    }
     * Marks BROADCAST eligible or not for this planning attempt. Set false on the re-plan after a
    // Set false on the re-plan after a broadcast build overflowed the runtime cap at execution
    private final CapabilityRegistry capabilityRegistry;
            profilingEnabled,
        return plannerSettings.getOversamplingFactor();
    private final IndexNameExpressionResolver indexNameExpressionResolver;
            Settings.EMPTY,
        boolean profilingEnabled,
    public static final long UNKNOWN_ROW_COUNT = -1L;
    public int getMaxFilterPredicateCount() {
    public static final ToLongFunction<String> DEFAULT_TABLE_ROW_COUNTS = name -> UNKNOWN_ROW_COUNT;
        return settings;
        ToLongFunction<String> tableRowCounts
            clusterState,
            preferMetadataDriver,
        ClusterState clusterState,
    // block-list). Defaults to planner defaults; DefaultPlanExecutor injects the live, settings-backed
            true,
    }
        return plannerSettings.getDelegationBlockList();
        this.indexNameExpressionResolver = indexNameExpressionResolver;
 * and the cluster settings snapshot used by hash-shuffle partition-count resolution.
 * compatible open source license.
    }
 * Shared context available to all planner rules.
    /**
        @Nullable IndexNameExpressionResolver indexNameExpressionResolver,
     */
        ToLongFunction<String> tableRowCounts,
        return profilingEnabled;
     */
import org.opensearch.analytics.settings.PlannerSettings;
            capabilityRegistry,
        this.profilingEnabled = profilingEnabled;
    }
        this.settings = settings;
        );
    /**
    private PlannerSettings plannerSettings = PlannerSettings.defaults();
        return capabilityRegistry;
        return lastProfile;
        CapabilityRegistry capabilityRegistry,
        ClusterState clusterState,
    @Nullable
        boolean preferMetadataDriver,
        @Nullable IndexNameExpressionResolver indexNameExpressionResolver,
        this(capabilityRegistry, clusterState, null, profilingEnabled, true, settings, tableRowCounts);
     * Per-index row count lookup used by {@code OpenSearchTableScanRule} to seed
        this(
        return broadcastEligible;
     * indices we have no statistics for; callers fall back to Calcite's default.
     * Sentinel returned by {@link #DEFAULT_TABLE_ROW_COUNTS} for indices we have no statistics
    ) {
        );
    }
    public PlannerContext(CapabilityRegistry capabilityRegistry, ClusterState clusterState) {
    public PlannerContext(
        this.lastProfile = profile;
        CapabilityRegistry capabilityRegistry,
        this.capabilityRegistry = capabilityRegistry;
        this.tableRowCounts = tableRowCounts;
    // so a future upstream merge that extends this constructor doesn't collide with our params.
        CapabilityRegistry capabilityRegistry,
import org.opensearch.cluster.ClusterState;
            capabilityRegistry,
    public PlannerContext(CapabilityRegistry capabilityRegistry, ClusterState clusterState, boolean profilingEnabled) {
        this(capabilityRegistry, clusterState, null, false, true, Settings.EMPTY, DEFAULT_TABLE_ROW_COUNTS);
    // Canonical constructor. Parameters that exist on upstream's PlannerContext
        CapabilityRegistry capabilityRegistry,
    public OpenSearchDistributionTraitDef getDistributionTraitDef() {
    }
     * paths should fail fast on null. The resolver belongs to the OpenSearch server lifecycle
     * metadata-only-driver gate, so the metadata backend (Lucene today) is never admitted as a
    public IndexNameExpressionResolver getIndexNameExpressionResolver() {
            Settings.EMPTY,
        return indexNameExpressionResolver;
    ) {
/**
    // instance via setPlannerSettings before planning.
    /**
        Settings settings,
    public boolean preferMetadataDriver() {
        boolean preferMetadataDriver
    }
    // Whether BROADCAST is an eligible join strategy for this planning attempt. Default true.
     * {@code RelOptAbstractTable.getRowCount()} returns 100.0 in that case.
    public PlannerContext(CapabilityRegistry capabilityRegistry, ClusterState clusterState, Settings settings, boolean profilingEnabled) {
    public void setPlannerSettings(PlannerSettings plannerSettings) {
     * for. The cost model treats this as "use Calcite's default" — in practice
 * SPDX-License-Identifier: Apache-2.0
        this(capabilityRegistry, clusterState, null, false, true, settings, DEFAULT_TABLE_ROW_COUNTS);
 * @opensearch.internal
    private boolean broadcastEligible = true;
package org.opensearch.analytics.planner;
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    ) {
    // upstream's order; our feature-branch additions (settings, tableRowCounts) are appended last
    }
import org.opensearch.common.Nullable;
     *  source has been wired (e.g. unit tests that don't exercise cost-aware planning). */
        this.clusterState = clusterState;
    /** Default lookup that always returns {@link #UNKNOWN_ROW_COUNT} — used when no statistics
    }
    // coordinator-centric. Read by OpenSearchBroadcastJoinSplitRule.matches().
 *
    }
    /** Returns a unique annotation ID for marking phase. */
        this.broadcastEligible = broadcastEligible;
    public RuleProfilingListener.PlannerProfile getProfilingResults() {
        boolean profilingEnabled
            indexNameExpressionResolver,
    /** Inject the live, settings-backed planner settings. Called by {@code DefaultPlanExecutor} before planning. */
        boolean profilingEnabled
    private int annotationIdCounter;
    public ClusterState getClusterState() {
        this(capabilityRegistry, clusterState, null, profilingEnabled, true, settings, DEFAULT_TABLE_ROW_COUNTS);
}
    }
    /** Per-backend delegation block-list consulted at marking time. Never null (defaults to empty). */
    public PlannerContext(
    }
    /** Whether BROADCAST is an eligible join strategy for this planning attempt (default true). */
     */
public class PlannerContext {
    }
        CapabilityRegistry capabilityRegistry,
        return annotationIdCounter++;
    private final boolean profilingEnabled;
 */
     * and is provided to {@code DefaultPlanExecutor} via Guice.
            DEFAULT_TABLE_ROW_COUNTS
        ToLongFunction<String> tableRowCounts,
        return plannerSettings.getMaxFilterPredicateCount();
     * pruning needed.
    }
    }
            clusterState,
    public double getOversamplingFactor() {
        @Nullable IndexNameExpressionResolver indexNameExpressionResolver,
    }
        this(capabilityRegistry, clusterState, indexNameExpressionResolver, profilingEnabled, true, settings, tableRowCounts);
        return tableRowCounts;
    public boolean isProfilingEnabled() {
    private final boolean preferMetadataDriver;
    private final OpenSearchDistributionTraitDef distributionTraitDef;
            DEFAULT_TABLE_ROW_COUNTS
    }
        Settings settings,
        ClusterState clusterState,
    }
     * scan alternative — value-producing peers handle every shape, no late-stage alternative
 * The OpenSearch Contributors require contributions made to
            profilingEnabled,
        this.preferMetadataDriver = preferMetadataDriver;
    public void setBroadcastEligible(boolean broadcastEligible) {
    private final ToLongFunction<String> tableRowCounts;
 * this file be licensed under the Apache-2.0 license or a
        Settings settings,
        this.annotationIdCounter = 0;
     * time. When {@code false}, {@code OpenSearchTableScanRule} skips the permissive
        ClusterState clusterState,
    }
    public void recordProfilingResults(RuleProfilingListener.PlannerProfile profile) {
    public boolean isBroadcastEligible() {
    /** True when {@link PlannerImpl#runAllOptimizations} should attach a {@link RuleProfilingListener}. */
        @Nullable IndexNameExpressionResolver indexNameExpressionResolver,
