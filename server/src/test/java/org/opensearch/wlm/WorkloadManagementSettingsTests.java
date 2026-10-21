    /**
     */
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.8)
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.85)
     * Tests the invalid value for {@code wlm.workload_group.node.cpu_cancellation_threshold}
    /**
    /**
     */
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
     */
        assertEquals(0.7, wlm.getNodeLevelMemoryCancellationThreshold(), 1e-9);
     * When the value is set more than {@literal 0.9}. The max is enforced at settings-update validation time.
    /**
     * invariant {@code nodeLevelRejectionThreshold < nodeLevelCancellationThreshold}
        Settings update = Settings.builder()
    /**
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.7)
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8)
    public void testInvalidNodeLevelCpuRejectionThresholdCase1() {
     * the validation path.
        assertEquals(0.99, wlm.getNodeLevelCpuCancellationThreshold(), 1e-9);
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.7)
        cs.validateUpdate(update);
     */
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * A negative threshold is nonsensical and must be rejected at settings-update validation time by the validator's
    /**
     * {@code wlm.workload_group.node.cpu_cancellation_threshold} above its maximum. Prior to the fix, the value passed
        Settings settings = Settings.builder().put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.8).build();
        wlm.setNodeLevelMemoryRejectionThreshold(0.9); // rejection > cancellation; setter does not enforce ordering
        new WorkloadManagementSettings(Settings.EMPTY, cs);
    /**
     * the validation path.
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.95)
            .build();
        );
        new WorkloadManagementSettings(Settings.EMPTY, cs);
            NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME,
    public void testNegativeNodeThresholdsRejectedAtSettingsUpdateValidation() {
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * Tests the invalid value for {@code wlm.workload_group.node.memory_rejection_threshold}
    }
        wlm.setNodeLevelCpuRejectionThreshold(-0.1);
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
        Settings settings = Settings.builder().put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8).build();
        cs.validate(update, true);
import org.opensearch.test.OpenSearchTestCase;
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
        Settings update = Settings.builder().put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.96).build();
     * Tests the valid value for {@code wlm.workload_group.node.cpu_rejection_threshold}
        cs.validateUpdate(update);
        Settings update = Settings.builder()
    }
     */
    public void testInvalidNodeLevelCpuRejectionThresholdCase2() {
        assertEquals(0.79, workloadManagementSettings.getNodeLevelCpuRejectionThreshold(), 1e-9);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.opensearch.wlm.WorkloadManagementSettings.NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME;
     * is enforced at settings-update validation time (not in the setter), so it is exercised here through the
    /**
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
    public void testInvalidNodeLevelMemoryRejectionThresholdCase1() {
     * new feature development. This test is to ensure that {@link WorkloadManagementSettings} holds the
     * new feature development. This test is to ensure that {@link WorkloadManagementSettings} holds the
import static org.hamcrest.Matchers.containsString;
     * a stale sibling field: the cancellation consumer applied first would compare the new cancellation against the old
        cs.validate(update, true);
        Settings cpu = Settings.builder()
        // validate(...) is the other check the settings API applies to the final persistent/transient settings.
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
     * Tests the invalid value for {@code wlm.workload_group.node.memory_rejection_threshold}
    /**
     */
    public void testValidNodeLevelCpuRejectionThresholdCase2() {
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
     * When the value is set more than {@literal 0.95}. The max is enforced at settings-update validation time.
        Settings update = Settings.builder()
        assertEquals(0.8, workloadManagementSettings.getNodeLevelCpuRejectionThreshold(), 1e-9);
        assertEquals(0.9, wlm.getNodeLevelMemoryRejectionThreshold(), 1e-9);
     * Using setNodeLevelCpuCancellationThreshold function
     * A value at exactly the maximum must be accepted through the settings-update validation path.
        WorkloadManagementSettings wlm = new WorkloadManagementSettings(Settings.EMPTY, cs);
     */
        assertEquals(0.83, workloadManagementSettings.getNodeLevelMemoryCancellationThreshold(), 1e-9);
        Settings update = Settings.builder()
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            wlm.getNodeLevelCpuCancellationThreshold(),
    public void testValidNodeLevelCpuCancellationThresholdCase1() {
        IllegalArgumentException e1 = expectThrows(IllegalArgumentException.class, () -> cs.validateUpdate(cpu));
    }
            .build();
    }
    public void testValidNodeLevelMemoryRejectionThresholdCase1() {
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
    public void testCpuCancellationThresholdAtMaxAcceptedAtSettingsUpdateValidation() {
    }
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8)
        Settings update = Settings.builder()
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.7)
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        new WorkloadManagementSettings(Settings.EMPTY, cs);
    /**
            .build();
    /**
     * the validation path.
 *
        new WorkloadManagementSettings(Settings.EMPTY, cs);
public class WorkloadManagementSettingsTests extends OpenSearchTestCase {
     * When the value is set more than {@literal 0.95}. The max is enforced at settings-update validation time.
     * Tests the invalid value for {@code wlm.workload_group.node.memory_rejection_threshold}
            .build();
        assertThrows(IllegalArgumentException.class, () -> cs.validate(update, true));
     * Tests the valid value for {@code wlm.workload_group.node.memory_rejection_threshold}
        assertThrows(IllegalArgumentException.class, () -> cs.validate(update, true));
     * mis-wired rejection validator (wrong MAX constant / not attached) would be caught. The paired cancellation is
            NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME }) {
        Settings update = Settings.builder().put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.98).build();
        WorkloadManagementSettings wlm = new WorkloadManagementSettings(Settings.EMPTY, cs);
        new WorkloadManagementSettings(Settings.EMPTY, cs);
     * enforced up front by {@code NodeLevelThresholdValidator} at validation time. This guards against reintroducing an
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    /**
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
        WorkloadManagementSettings wlm = new WorkloadManagementSettings(Settings.EMPTY, cs);
    public void testOutOfRangeCpuCancellationThresholdIsArchivedOnRecovery() {
    /**
        Settings update = Settings.builder().put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.95).build();
        assertThrows(IllegalArgumentException.class, () -> cs.validate(update, true));
        Settings memory = Settings.builder()
        wlm.setNodeLevelMemoryCancellationThreshold(0.1);
        for (String key : new String[] {
    }
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8)
            .build();
     */
     * invariant is enforced at settings-update validation time (not in the setter), so it is exercised here through
    public void testValidNodeLevelMemoryRejectionThresholdCase2() {
        assertThat(e.getMessage(), containsString(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME));
import org.opensearch.common.settings.ClusterSettings;
 * The OpenSearch Contributors require contributions made to
     * validation path.
        wlm.setNodeLevelCpuCancellationThreshold(0.99);
     * Tests the valid value for {@code wlm.workload_group.node.memory_cancellation_threshold}
    }
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.65)
    public void testValidNodeLevelCpuRejectionThresholdCase1() {
            .build();
        cs.validate(update, true);
    }
     * raised to 0.95 in the same update so that the ordering invariant is satisfied and the rejection max is the sole
    }
     * invariant {@code nodeLevelRejectionThreshold < nodeLevelCancellationThreshold}
    }
    }
     */
        new WorkloadManagementSettings(Settings.EMPTY, cs);
        assertEquals(0.7, wlm.getNodeLevelCpuCancellationThreshold(), 1e-9);
 */
     */
     * Tests the invalid value for {@code wlm.workload_group.node.memory_cancellation_threshold}
        Settings update = Settings.builder()
        // cancellation 0.65 < rejection 0.7 violates the invariant
    public void testCpuCancellationBelowRejectionRejectedAtSettingsUpdateValidation() {
    /**
     * Tests the invalid value for {@code wlm.workload_group.node.cpu_cancellation_threshold}
        cs.applySettings(update); // must not throw
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.6)
    /**
     */
        assertEquals(0.83, workloadManagementSettings.getNodeLevelCpuCancellationThreshold(), 1e-9);
     * When the value is set more than {@code wlm.workload_group.node.cpu_cancellation_threshold}. The ordering
     * archived rather than applied. This verifies the recovery/self-heal path enabled by the validator.
     * Reproduces the production incident where a dynamic cluster settings update set
     * When the value is set more than {@code wlm.workload_group.node.memory_cancellation_threshold} accidentally during
     * invariant is enforced at settings-update validation time (not in the setter), so it is exercised here through
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.95) // > 0.90 rejection max
        assertEquals(
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8)
        workloadManagementSettings.setNodeLevelMemoryRejectionThreshold(0.86);
    /**
        Settings settings = Settings.builder()
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        new WorkloadManagementSettings(Settings.EMPTY, cs);
     */
        assertEquals(0.86, workloadManagementSettings.getNodeLevelMemoryRejectionThreshold(), 1e-9);
        new WorkloadManagementSettings(Settings.EMPTY, cs);
            .build();
        cs.validateUpdate(update);
        Settings poisoned = Settings.builder().put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.98).build();
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
    public void testRejectionThresholdAboveMaxRejectedAtSettingsUpdateValidation() {
            .build();
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // validateUpdate is the dry-run the cluster settings API runs before committing the new cluster state.
     */
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> cs.validateUpdate(memory));
            .build();
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.8)
     * Tests the valid value for {@code wlm.workload_group.node.cpu_rejection_threshold}
     */
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
            .build();
     */
     * The setters run as the settings-update consumers at apply time and only assign; all bounds and ordering are
     * A cluster that already carries an out-of-range value in persisted cluster state (as in the incident, where
        assertThat(e2.getMessage(), containsString(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME));
        assertEquals("0.98", archived.get("archived." + NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME));
        assertNull(archived.get(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME));
     */
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.95) // keeps rejection <= cancellation
        Settings update = Settings.builder()
        Settings settings = Settings.builder().put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.8).build();
        Settings update = Settings.builder().put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.92).build();
    /**
     * {@code 0.98} was committed before the fix) must be able to recover: on state recovery the invalid setting is
     */
    /**
     * not only via the setters.
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.7)
    public void testInvalidNodeLevelCpuCancellationThresholdCase2() {
        workloadManagementSettings.setNodeLevelCpuRejectionThreshold(0.7);
    /**
     * Boundary: rejection == cancellation is consistent (invariant is {@code rejection <= cancellation}) and must be
     * When the value is set more than {@literal 0.9}. The max is enforced at settings-update validation time.
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Settings settings = Settings.builder().put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.79).build();
    }
    }
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * When the value is set less than {@code wlm.workload_group.node.memory_rejection_threshold}. The ordering
     * lower bound, for each of the four node threshold settings.
     * invariant is enforced at settings-update validation time (not in the setter), so it is exercised here through
        assertThrows(IllegalArgumentException.class, () -> new WorkloadManagementSettings(settings, cs));
    }
            .build();
        Settings settings = Settings.builder().put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8).build();
    }
     * The rejection-threshold max (0.90) must be enforced through the validation path for both cpu and memory, so a
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME,
     * regression swapping the memory validators' dependency setting or argument order is caught.
    public void testInvalidNodeLevelMemoryCancellationThresholdCase2() {
     * When the value is set more than {@code wlm.workload_group.node.memory_cancellation_threshold}. The ordering
        Settings update = Settings.builder().put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.96).build();
        // cancellation 0.65 < rejection 0.7 violates the invariant
        // rejection (0.85) > cancellation (0.8) violates the invariant
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.85)
     */
    public void testMemoryCancellationThresholdAboveMaxRejectedAtSettingsUpdateValidation() {
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // Values that validation would reject (out of range, and cancellation < rejection) are still assigned by the
    }
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
    public void testLoweringBothMemoryThresholdsTogetherIsAppliedCleanly() {
    public void testLoweringBothCpuThresholdsTogetherIsAppliedCleanly() {
    /**
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     */
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
     * accepted, so the ordering check is not wrongly strict.
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     */
     * only to throw while the new state was being applied on every node. That apply-time failure destabilized the
     * Tests the invalid value for {@code wlm.workload_group.node.cpu_rejection_threshold}
    /**
    }
     * The same up-front rejection must hold for the memory cancellation threshold.
        Settings update = Settings.builder().put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.98).build();
    public void testValidNodeLevelMemoryCancellationThresholdCase1() {
        new WorkloadManagementSettings(Settings.EMPTY, cs);
    }
    public void testInvalidNodeLevelCpuCancellationThresholdCase1() {
    /**
    }
        assertEquals(0.6, wlm.getNodeLevelMemoryRejectionThreshold(), 1e-9);
    public void testCpuCancellationThresholdAboveMaxRejectedAtSettingsUpdateValidation() {
    }
    /**
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
        assertEquals(0.8, wlm.getNodeLevelCpuCancellationThreshold(), 1e-9);
        assertThrows(IllegalArgumentException.class, () -> new WorkloadManagementSettings(settings, cs));
    public void testInvalidNodeLevelMemoryRejectionThresholdCase2() {
     */
    }
        WorkloadManagementSettings wlm = new WorkloadManagementSettings(Settings.EMPTY, cs);
        cs.validate(update, true);
        assertThat(e2.getMessage(), containsString(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME));
        assertEquals(0.8, wlm.getNodeLevelCpuRejectionThreshold(), 1e-9);
        }
     * Tests the valid value for {@code wlm.workload_group.node.memory_rejection_threshold}
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.95)
     */
import static org.opensearch.wlm.WorkloadManagementSettings.NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME;
        cs.validateUpdate(update);
            WorkloadManagementSettings.NODE_LEVEL_CPU_CANCELLATION_THRESHOLD_MAX_VALUE,
     * When the value is set more than {@code wlm.workload_group.node.cpu_cancellation_threshold} accidentally during
    public void testSettersOnlyAssignAndDoNotThrow() {
     */
        assertEquals(0.8, workloadManagementSettings.getNodeLevelMemoryCancellationThreshold(), 1e-9);
        Settings archived = cs.archiveUnknownOrInvalidSettings(poisoned, e -> {}, (e, ex) -> {});
    }
        cs.applySettings(update);
            .build();
            1e-9
    }
     * Using setNodeLevelCpuRejectionThreshold function
        Settings update = Settings.builder()
        assertEquals(0.6, wlm.getNodeLevelCpuRejectionThreshold(), 1e-9);
            .build();
        Settings settings = Settings.builder().put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.9).build();
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> cs.validate(update, true));
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.8)
 * SPDX-License-Identifier: Apache-2.0
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.7)
        assertEquals(-0.1, wlm.getNodeLevelCpuRejectionThreshold(), 1e-9);
     */
    public void testValidNodeLevelCpuCancellationThresholdCase2() {
        assertThrows(IllegalArgumentException.class, () -> cs.validate(update, true));
        Settings settings = Settings.builder()
            NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME,
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.65)
     */
    }
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * The rejection-vs-cancellation ordering invariant must also be enforced at settings-update validation time,
        Settings update = Settings.builder()
    /**
     */
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * Tests the invalid value for {@code wlm.workload_group.node.memory_cancellation_threshold}
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
package org.opensearch.wlm;
            Settings update = Settings.builder().put(key, -0.1).build();
        workloadManagementSettings.setNodeLevelCpuCancellationThreshold(0.83);
        new WorkloadManagementSettings(Settings.EMPTY, cs);
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Settings settings = Settings.builder().put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8).build();
        assertEquals(0.79, workloadManagementSettings.getNodeLevelMemoryRejectionThreshold(), 1e-9);
        // The active (non-archived) key is dropped and preserved under the archived prefix for visibility.
import org.opensearch.common.settings.Settings;
        // rejection 0.85 > cancellation 0.8 violates the invariant
     * When the value is set less than {@code wlm.workload_group.node.cpu_rejection_threshold}. The ordering invariant
 * compatible open source license.
     * Same as above for the memory pair.
    public void testMemoryCancellationBelowRejectionRejectedAtSettingsUpdateValidation() {
     * the settings-update dry-run validation ({@link ClusterSettings#validateUpdate}) and was committed to cluster state,
            .build();
    }
    public void testInvalidCpuInstantiationOfWorkloadManagementSettings() {
import static org.opensearch.wlm.WorkloadManagementSettings.NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME;
            assertThat(e.getMessage(), containsString(key));
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
     * Lowering BOTH thresholds in a single update to a new, consistent state (rejection stays below cancellation) must
        // raw setters without throwing, because the setters no longer validate.
 * this file be licensed under the Apache-2.0 license or a
        cs.applySettings(update); // must not throw
        new WorkloadManagementSettings(Settings.EMPTY, cs);
     * Using setNodeLevelMemoryRejectionThreshold function
     * Tests the valid value for {@code wlm.workload_group.node.cpu_cancellation_threshold}
    /**
        assertThat(e.getMessage(), containsString(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME));
     * cluster-manager. This test asserts the update is instead rejected up-front at validation time.
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, WorkloadManagementSettings.NODE_LEVEL_CPU_CANCELLATION_THRESHOLD_MAX_VALUE)
     * Tests the valid value for {@code wlm.workload_group.node.memory_cancellation_threshold}
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
     * Using setNodeLevelMemoryCancellationThreshold function
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    /**
        Settings update = Settings.builder()
     * Tests the valid value for {@code wlm.workload_group.node.cpu_cancellation_threshold}
        Settings settings = Settings.builder().put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.79).build();
        WorkloadManagementSettings wlm = new WorkloadManagementSettings(Settings.EMPTY, cs); // rejection=0.8, cancellation=0.9
        workloadManagementSettings.setNodeLevelMemoryCancellationThreshold(0.83);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testInvalidMemoryInstantiationOfWorkloadManagementSettings() {
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.85)
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * trigger.
        new WorkloadManagementSettings(Settings.EMPTY, cs);
        // rejection 0.85 > cancellation 0.8 violates the invariant
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.6)
    }
        new WorkloadManagementSettings(Settings.EMPTY, cs);
    }
        assertEquals(0.7, workloadManagementSettings.getNodeLevelCpuRejectionThreshold(), 1e-9);
     */
     * (higher) rejection and throw while applying committed state, destabilizing the cluster-manager.
    public void testInvalidNodeLevelMemoryCancellationThresholdCase1() {
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.85)
    public void testValidNodeLevelMemoryCancellationThresholdCase2() {
     * apply-time throw in a setter (which, for the cross-setting ordering invariant, destabilized the cluster-manager).
    /**
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.7)
    public void testEqualRejectionAndCancellationAcceptedAtSettingsUpdateValidation() {
/*
    /**
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * Tests the invalid value for {@code wlm.workload_group.node.cpu_rejection_threshold}
    /**
        cs.applySettings(update); // must not throw
}
     * Tests the invalid value for {@code wlm.workload_group.node.cpu_rejection_threshold}
        assertThat(e1.getMessage(), containsString(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME));
     */
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * succeed end-to-end. This guards against a regression where the ordering check ran in the apply-time setter against
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8)
    }
    /**
        new WorkloadManagementSettings(Settings.EMPTY, cs);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.opensearch.wlm.WorkloadManagementSettings.NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME;
     */
     */
     * The memory ordering violation must be rejected via the validation path (mirror of the cpu ordering test), so a
