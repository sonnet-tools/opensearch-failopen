import org.opensearch.analytics.settings.PlannerSettings;  
     * scan alternative — value-producing peers handle every shape, no late-stage alternative
            clusterState,
}
    }
    public static final long UNKNOWN_ROW_COUNT = -1L;
    // (see DefaultPlanExecutor's broadcast→shuffle retry) so CBO falls back to hash-shuffle /  
    private final ToLongFunction<String> tableRowCounts;
    public PlannerContext(CapabilityRegistry capabilityRegistry, ClusterState clusterState, Settings settings) {  
    }
    public int getMaxFilterPredicateCount() {
        this.distributionTraitDef = new OpenSearchDistributionTraitDef(this);
    }  
        this(capabilityRegistry, clusterState, null, profilingEnabled, true, Settings.EMPTY, DEFAULT_TABLE_ROW_COUNTS);  
import java.util.function.ToLongFunction;  
            true,
        ClusterState clusterState,
        @Nullable IndexNameExpressionResolver indexNameExpressionResolver,
        return settings;
    public ClusterState getClusterState() {
    public static final ToLongFunction<String> DEFAULT_TABLE_ROW_COUNTS = name -> UNKNOWN_ROW_COUNT;
     * indices we have no statistics for; callers fall back to Calcite's default.
    /** Stash the snapshot taken at the end of {@code runAllOptimizations}. Null when profiling was disabled. */
    }
    }
    // Set false on the re-plan after a broadcast build overflowed the runtime cap at execution
        CapabilityRegistry capabilityRegistry,  
    private final ClusterState clusterState;
    private final Settings settings;  
        return plannerSettings.getDelegationBlockList();
    public PlannerContext(
    @Nullable
            profilingEnabled,  
    private final CapabilityRegistry capabilityRegistry;
        return indexNameExpressionResolver;  
    /** Default lookup that always returns {@link #UNKNOWN_ROW_COUNT} — used when no statistics  
    ) {
        this.broadcastEligible = broadcastEligible;
 * SPDX-License-Identifier: Apache-2.0
    public boolean isProfilingEnabled() {
    /** Returns a unique annotation ID for marking phase. */
 * compatible open source license.
            profilingEnabled,  
    }
        boolean profilingEnabled,
    }
     * that don't exercise alias/wildcard expansion; callers that need it for production  
        return profilingEnabled;
     */  
     * time. When {@code false}, {@code OpenSearchTableScanRule} skips the permissive  
            indexNameExpressionResolver,
    /** Inject the live, settings-backed planner settings. Called by {@code DefaultPlanExecutor} before planning. */
    public PlannerContext(CapabilityRegistry capabilityRegistry, ClusterState clusterState) {
    public PlannerContext(
     */  
    /**
    }  
        return capabilityRegistry;
        CapabilityRegistry capabilityRegistry,  
    }
    }
    public RuleProfilingListener.PlannerProfile getProfilingResults() {
import org.opensearch.common.Nullable;  
        CapabilityRegistry capabilityRegistry,
        this.lastProfile = profile;
    }  
        this.annotationIdCounter = 0;
    }
        boolean preferMetadataDriver  
    public double getOversamplingFactor() {
    ) {
        this.preferMetadataDriver = preferMetadataDriver;  
    // so a future upstream merge that extends this constructor doesn't collide with our params.
    private final IndexNameExpressionResolver indexNameExpressionResolver;  
    public PlannerContext(CapabilityRegistry capabilityRegistry, ClusterState clusterState, boolean profilingEnabled) {
        return lastProfile;
            Settings.EMPTY,
 * Shared context available to all planner rules.  
     * Mirrors the {@code analytics.planner.prefer_metadata_driver} cluster setting at planning
        Settings settings,
    private boolean broadcastEligible = true;
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
    }
        return broadcastEligible;
            DEFAULT_TABLE_ROW_COUNTS  
    public boolean isBroadcastEligible() {
            clusterState,
    }
        this(capabilityRegistry, clusterState, null, false, true, settings, DEFAULT_TABLE_ROW_COUNTS);
    public Settings getSettings() {  
        boolean profilingEnabled,  
     * and is provided to {@code DefaultPlanExecutor} via Guice.
    public DelegationBlockList getDelegationBlockList() {  
        Settings settings,
    }
    public CapabilityRegistry getCapabilityRegistry() {
     * emits no broadcast alternative and CBO falls back to hash-shuffle / coordinator-centric.
     * Sentinel returned by {@link #DEFAULT_TABLE_ROW_COUNTS} for indices we have no statistics  
        ToLongFunction<String> tableRowCounts,  
        return plannerSettings.getOversamplingFactor();
        this(capabilityRegistry, clusterState, null, profilingEnabled, true, settings, tableRowCounts);
    private PlannerSettings plannerSettings = PlannerSettings.defaults();  
    // Whether BROADCAST is an eligible join strategy for this planning attempt. Default true.
        ClusterState clusterState,
        this.settings = settings;
    /** Whether BROADCAST is an eligible join strategy for this planning attempt (default true). */  
    public void setPlannerSettings(PlannerSettings plannerSettings) {
    }  
        return preferMetadataDriver;  
        CapabilityRegistry capabilityRegistry,  
    private final boolean profilingEnabled;
    }
    private final OpenSearchDistributionTraitDef distributionTraitDef;
    /** Per-backend delegation block-list consulted at marking time. Never null (defaults to empty). */
    public OpenSearchDistributionTraitDef getDistributionTraitDef() {  
            preferMetadataDriver,
    ) {
    }
    /**
        this.tableRowCounts = tableRowCounts;
     * metadata-only-driver gate, so the metadata backend (Lucene today) is never admitted as a
    }  
     * Marks BROADCAST eligible or not for this planning attempt. Set false on the re-plan after a  
        return tableRowCounts;
import org.opensearch.analytics.settings.DelegationBlockList;
    ) {  
 *  
     *  source has been wired (e.g. unit tests that don't exercise cost-aware planning). */
        ToLongFunction<String> tableRowCounts,
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
        @Nullable IndexNameExpressionResolver indexNameExpressionResolver,
    ) {
        ClusterState clusterState,  
        this(
     * Per-index row count lookup used by {@code OpenSearchTableScanRule} to seed
    public PlannerContext(
        Settings settings,
        ToLongFunction<String> tableRowCounts  
        return annotationIdCounter++;
        boolean profilingEnabled  
        this.profilingEnabled = profilingEnabled;
    }
    public boolean preferMetadataDriver() {
/**
 * and the cluster settings snapshot used by hash-shuffle partition-count resolution.
     */
import org.opensearch.cluster.ClusterState;
        );
    /**
    // coordinator-centric. Read by OpenSearchBroadcastJoinSplitRule.matches().
    private RuleProfilingListener.PlannerProfile lastProfile;
 * Holds capability registry (singleton, built at plugin startup), per-query cluster state,
        this(capabilityRegistry, clusterState, null, false, true, Settings.EMPTY, DEFAULT_TABLE_ROW_COUNTS);
        @Nullable IndexNameExpressionResolver indexNameExpressionResolver,
package org.opensearch.analytics.planner;
 * The OpenSearch Contributors require contributions made to  
        boolean profilingEnabled
    private int annotationIdCounter;
    /**
import org.opensearch.common.settings.Settings;
 *
        return distributionTraitDef;
            indexNameExpressionResolver,
    // block-list). Defaults to planner defaults; DefaultPlanExecutor injects the live, settings-backed
        this(capabilityRegistry, clusterState, null, profilingEnabled, true, settings, DEFAULT_TABLE_ROW_COUNTS);
        this(
    // (indexNameExpressionResolver, profilingEnabled, preferMetadataDriver) come first, in
    /**
    // upstream's order; our feature-branch additions (settings, tableRowCounts) are appended last  
        this.plannerSettings = plannerSettings;  
    // Canonical constructor. Parameters that exist on upstream's PlannerContext
    public void recordProfilingResults(RuleProfilingListener.PlannerProfile profile) {  
    // instance via setPlannerSettings before planning.
    public ToLongFunction<String> getTableRowCounts() {  
     * {@code IndexNameTable.getRowCount()}. Returns {@link #UNKNOWN_ROW_COUNT} for  
            DEFAULT_TABLE_ROW_COUNTS  
        CapabilityRegistry capabilityRegistry,
    }  
        @Nullable IndexNameExpressionResolver indexNameExpressionResolver,
    public PlannerContext(
        return plannerSettings.getMaxFilterPredicateCount();  
     * {@code RelOptAbstractTable.getRowCount()} returns 100.0 in that case.
 */  
    // Cluster settings the planner consults at planning time (oversampling factor + delegation  
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
    @Nullable
            Settings.EMPTY,
            capabilityRegistry,  
    }  
    private final boolean preferMetadataDriver;  
 */
        );
            capabilityRegistry,  
    public IndexNameExpressionResolver getIndexNameExpressionResolver() {
    public int nextAnnotationId() {  
    }  
     * pruning needed.  
    public PlannerContext(CapabilityRegistry capabilityRegistry, ClusterState clusterState, Settings settings, boolean profilingEnabled) {
    public PlannerContext(
     */
     * The cluster-level index name expression resolver, when available. Null in unit tests
        return clusterState;  
    /** True when {@link PlannerImpl#runAllOptimizations} should attach a {@link RuleProfilingListener}. */  
    }
        this.clusterState = clusterState;  
     */  
        this(capabilityRegistry, clusterState, indexNameExpressionResolver, profilingEnabled, true, settings, tableRowCounts);
     * broadcast build overflowed the runtime cap, so {@code OpenSearchBroadcastJoinSplitRule}
public class PlannerContext {  
        ClusterState clusterState,  
        this.capabilityRegistry = capabilityRegistry;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        boolean profilingEnabled  
     * for. The cost model treats this as "use Calcite's default" — in practice
     * paths should fail fast on null. The resolver belongs to the OpenSearch server lifecycle
        ClusterState clusterState,
    }  
    }
/*  
    public void setBroadcastEligible(boolean broadcastEligible) {
        boolean preferMetadataDriver,
