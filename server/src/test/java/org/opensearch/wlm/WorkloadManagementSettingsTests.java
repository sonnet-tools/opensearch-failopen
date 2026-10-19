    /**
     */
        Settings settings = Settings.builder()  
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.7)
     */  
     * A negative threshold is nonsensical and must be rejected at settings-update validation time by the validator's  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
    }
    }  
            WorkloadManagementSettings.NODE_LEVEL_CPU_CANCELLATION_THRESHOLD_MAX_VALUE,
    public void testNegativeNodeThresholdsRejectedAtSettingsUpdateValidation() {  
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.95)
        Settings update = Settings.builder().put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.96).build();  
     */
        assertThrows(IllegalArgumentException.class, () -> cs.validate(update, true));  
    /**
            .build();
        new WorkloadManagementSettings(Settings.EMPTY, cs);
        new WorkloadManagementSettings(Settings.EMPTY, cs);
        new WorkloadManagementSettings(Settings.EMPTY, cs);
     * accepted, so the ordering check is not wrongly strict.
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(e.getMessage(), containsString(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME));
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME,
        cs.validate(update, true);
        wlm.setNodeLevelMemoryRejectionThreshold(0.9); // rejection > cancellation; setter does not enforce ordering
        Settings update = Settings.builder().put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.98).build();  
    /**
     * Tests the invalid value for {@code wlm.workload_group.node.cpu_cancellation_threshold}
            .build();
        assertEquals(0.8, workloadManagementSettings.getNodeLevelCpuRejectionThreshold(), 1e-9);  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
/*  
    public void testValidNodeLevelMemoryRejectionThresholdCase1() {  
        Settings settings = Settings.builder().put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8).build();  
    }
        new WorkloadManagementSettings(Settings.EMPTY, cs);  
     * enforced up front by {@code NodeLevelThresholdValidator} at validation time. This guards against reintroducing an
import static org.opensearch.wlm.WorkloadManagementSettings.NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME;
        Settings update = Settings.builder()
     * When the value is set more than {@literal 0.95}. The max is enforced at settings-update validation time.
        assertThat(e2.getMessage(), containsString(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME));
            .build();
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.6)
        new WorkloadManagementSettings(Settings.EMPTY, cs);
        Settings update = Settings.builder()  
    public void testValidNodeLevelMemoryCancellationThresholdCase2() {  
        cs.applySettings(update);
     */
import org.opensearch.common.settings.Settings;
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.7)  
     * validation path.  
        assertThrows(IllegalArgumentException.class, () -> cs.validate(update, true));  
        Settings update = Settings.builder()  
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.8)
    /**  
     */
     * invariant {@code nodeLevelRejectionThreshold < nodeLevelCancellationThreshold}
     * Boundary: rejection == cancellation is consistent (invariant is {@code rejection <= cancellation}) and must be  
package org.opensearch.wlm;
        assertEquals(0.8, wlm.getNodeLevelCpuCancellationThreshold(), 1e-9);
     */
     * apply-time throw in a setter (which, for the cross-setting ordering invariant, destabilized the cluster-manager).  
        cs.validate(update, true);
    /**
    /**
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
     * Tests the valid value for {@code wlm.workload_group.node.cpu_cancellation_threshold}  
    }
    }  
     * Tests the invalid value for {@code wlm.workload_group.node.memory_cancellation_threshold}
    public void testValidNodeLevelMemoryRejectionThresholdCase2() {
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.85)
     * succeed end-to-end. This guards against a regression where the ordering check ran in the apply-time setter against  
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
        assertEquals(0.99, wlm.getNodeLevelCpuCancellationThreshold(), 1e-9);  
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);  
    public void testValidNodeLevelCpuCancellationThresholdCase1() {
        Settings memory = Settings.builder()
    public void testValidNodeLevelCpuRejectionThresholdCase1() {
            Settings update = Settings.builder().put(key, -0.1).build();  
        new WorkloadManagementSettings(Settings.EMPTY, cs);  
     * only to throw while the new state was being applied on every node. That apply-time failure destabilized the  
     * Tests the invalid value for {@code wlm.workload_group.node.cpu_rejection_threshold}  
        // rejection 0.85 > cancellation 0.8 violates the invariant  
     * Reproduces the production incident where a dynamic cluster settings update set  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
     */
 *
        // validateUpdate is the dry-run the cluster settings API runs before committing the new cluster state.
     */  
     * cluster-manager. This test asserts the update is instead rejected up-front at validation time.
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }  
        assertEquals(0.83, workloadManagementSettings.getNodeLevelMemoryCancellationThreshold(), 1e-9);
        cs.validateUpdate(update);  
    }
        assertThat(e.getMessage(), containsString(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME));
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * Using setNodeLevelCpuCancellationThreshold function
    /**
import org.opensearch.test.OpenSearchTestCase;  
        Settings update = Settings.builder().put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.92).build();
    /**  
        assertThat(e1.getMessage(), containsString(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME));
    public void testMemoryCancellationBelowRejectionRejectedAtSettingsUpdateValidation() {
     * mis-wired rejection validator (wrong MAX constant / not attached) would be caught. The paired cancellation is
        // The active (non-archived) key is dropped and preserved under the archived prefix for visibility.
        Settings update = Settings.builder()
     * When the value is set less than {@code wlm.workload_group.node.cpu_rejection_threshold}. The ordering invariant
     * the validation path.
     * A value at exactly the maximum must be accepted through the settings-update validation path.  
     * new feature development. This test is to ensure that {@link WorkloadManagementSettings} holds the
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.95) // keeps rejection <= cancellation
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.8)
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
     * invariant is enforced at settings-update validation time (not in the setter), so it is exercised here through  
     * the settings-update dry-run validation ({@link ClusterSettings#validateUpdate}) and was committed to cluster state,
        wlm.setNodeLevelCpuRejectionThreshold(-0.1);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));  
    public void testRejectionThresholdAboveMaxRejectedAtSettingsUpdateValidation() {
        assertEquals(0.8, workloadManagementSettings.getNodeLevelMemoryCancellationThreshold(), 1e-9);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
    /**  
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8)  
        new WorkloadManagementSettings(Settings.EMPTY, cs);  
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.7)
     */
    }  
        assertEquals(0.83, workloadManagementSettings.getNodeLevelCpuCancellationThreshold(), 1e-9);  
    public void testCpuCancellationBelowRejectionRejectedAtSettingsUpdateValidation() {
     * invariant is enforced at settings-update validation time (not in the setter), so it is exercised here through  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(0.8, wlm.getNodeLevelCpuRejectionThreshold(), 1e-9);  
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8)
        Settings settings = Settings.builder().put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.8).build();
        workloadManagementSettings.setNodeLevelCpuCancellationThreshold(0.83);
     */
    }  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * Tests the valid value for {@code wlm.workload_group.node.memory_cancellation_threshold}
        new WorkloadManagementSettings(Settings.EMPTY, cs);
        Settings update = Settings.builder()
        WorkloadManagementSettings wlm = new WorkloadManagementSettings(Settings.EMPTY, cs);
    }
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testValidNodeLevelCpuCancellationThresholdCase2() {
        new WorkloadManagementSettings(Settings.EMPTY, cs);
     * Using setNodeLevelMemoryCancellationThreshold function
     * the validation path.
            .build();  
            .build();
        assertThrows(IllegalArgumentException.class, () -> cs.validate(update, true));
     * Tests the invalid value for {@code wlm.workload_group.node.cpu_cancellation_threshold}  
     * invariant {@code nodeLevelRejectionThreshold < nodeLevelCancellationThreshold}  
        Settings archived = cs.archiveUnknownOrInvalidSettings(poisoned, e -> {}, (e, ex) -> {});  
    }
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, WorkloadManagementSettings.NODE_LEVEL_CPU_CANCELLATION_THRESHOLD_MAX_VALUE)  
    }
        assertThrows(IllegalArgumentException.class, () -> cs.validate(update, true));
            NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME,  
        Settings update = Settings.builder()
     */
     * The setters run as the settings-update consumers at apply time and only assign; all bounds and ordering are
    /**
    }
     * Tests the valid value for {@code wlm.workload_group.node.memory_rejection_threshold}
    /**
        Settings settings = Settings.builder().put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8).build();
        assertEquals(0.6, wlm.getNodeLevelMemoryRejectionThreshold(), 1e-9);
     * raised to 0.95 in the same update so that the ordering invariant is satisfied and the rejection max is the sole
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));  
        for (String key : new String[] {
     */
    /**
     * Tests the invalid value for {@code wlm.workload_group.node.cpu_rejection_threshold}
        );
        workloadManagementSettings.setNodeLevelMemoryCancellationThreshold(0.83);
    }
     * {@code wlm.workload_group.node.cpu_cancellation_threshold} above its maximum. Prior to the fix, the value passed
 */  
    public void testInvalidNodeLevelMemoryCancellationThresholdCase2() {
     * the validation path.
            wlm.getNodeLevelCpuCancellationThreshold(),
    }
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.65)
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
     * The rejection-vs-cancellation ordering invariant must also be enforced at settings-update validation time,
        // rejection 0.85 > cancellation 0.8 violates the invariant  
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
    /**
    /**
 * The OpenSearch Contributors require contributions made to  
    }  
        cs.applySettings(update); // must not throw
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        assertEquals("0.98", archived.get("archived." + NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME));
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.7)  
import org.opensearch.common.settings.ClusterSettings;
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.6)  
            .build();
    }  
    public void testInvalidNodeLevelCpuCancellationThresholdCase2() {
    public void testInvalidNodeLevelMemoryRejectionThresholdCase1() {
     */
    /**  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Settings update = Settings.builder().put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.96).build();
     */  
     * Using setNodeLevelCpuRejectionThreshold function
        Settings update = Settings.builder()  
    }
    public void testInvalidNodeLevelMemoryRejectionThresholdCase2() {  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testInvalidCpuInstantiationOfWorkloadManagementSettings() {
        wlm.setNodeLevelMemoryCancellationThreshold(0.1);  
            .build();
    public void testCpuCancellationThresholdAtMaxAcceptedAtSettingsUpdateValidation() {
import static org.opensearch.wlm.WorkloadManagementSettings.NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME;
    /**
    public void testInvalidNodeLevelCpuRejectionThresholdCase1() {
    public void testMemoryCancellationThresholdAboveMaxRejectedAtSettingsUpdateValidation() {
    /**  
        WorkloadManagementSettings wlm = new WorkloadManagementSettings(Settings.EMPTY, cs);
            .build();  
    public void testInvalidNodeLevelCpuCancellationThresholdCase1() {
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
     * Tests the valid value for {@code wlm.workload_group.node.memory_cancellation_threshold}  
 * this file be licensed under the Apache-2.0 license or a
     * The same up-front rejection must hold for the memory cancellation threshold.
    public void testSettersOnlyAssignAndDoNotThrow() {
     * regression swapping the memory validators' dependency setting or argument order is caught.
        cs.validateUpdate(update);  
     * When the value is set more than {@literal 0.95}. The max is enforced at settings-update validation time.
            .build();  
import static org.opensearch.wlm.WorkloadManagementSettings.NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME;
    /**  
        cs.validateUpdate(update);
        Settings settings = Settings.builder().put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.79).build();
     * trigger.  
    }
     * When the value is set less than {@code wlm.workload_group.node.memory_rejection_threshold}. The ordering  
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8)  
     * Tests the valid value for {@code wlm.workload_group.node.cpu_cancellation_threshold}
    /**  
    /**  
        assertThat(e2.getMessage(), containsString(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME));  
    /**
    }
        cs.applySettings(update); // must not throw
     * lower bound, for each of the four node threshold settings.
        // rejection (0.85) > cancellation (0.8) violates the invariant
        assertEquals(0.9, wlm.getNodeLevelMemoryRejectionThreshold(), 1e-9);
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
}  
        WorkloadManagementSettings wlm = new WorkloadManagementSettings(Settings.EMPTY, cs);
    }
        Settings settings = Settings.builder().put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.79).build();
        assertNull(archived.get(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME));  
        assertEquals(0.7, wlm.getNodeLevelCpuCancellationThreshold(), 1e-9);
    public void testEqualRejectionAndCancellationAcceptedAtSettingsUpdateValidation() {  
        assertEquals(0.79, workloadManagementSettings.getNodeLevelCpuRejectionThreshold(), 1e-9);
        WorkloadManagementSettings wlm = new WorkloadManagementSettings(Settings.EMPTY, cs);
            .build();  
     * Tests the valid value for {@code wlm.workload_group.node.memory_rejection_threshold}
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(  
public class WorkloadManagementSettingsTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(0.7, wlm.getNodeLevelMemoryCancellationThreshold(), 1e-9);  
     * When the value is set more than {@code wlm.workload_group.node.memory_cancellation_threshold} accidentally during  
     * When the value is set more than {@code wlm.workload_group.node.memory_cancellation_threshold}. The ordering
    }  
     */  
    public void testCpuCancellationThresholdAboveMaxRejectedAtSettingsUpdateValidation() {  
     */
     */
        workloadManagementSettings.setNodeLevelCpuRejectionThreshold(0.7);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        assertEquals(0.6, wlm.getNodeLevelCpuRejectionThreshold(), 1e-9);
        new WorkloadManagementSettings(Settings.EMPTY, cs);
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.95)  
     */
        assertThrows(IllegalArgumentException.class, () -> new WorkloadManagementSettings(settings, cs));  
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.7)
        assertEquals(0.7, workloadManagementSettings.getNodeLevelCpuRejectionThreshold(), 1e-9);  
        // raw setters without throwing, because the setters no longer validate.
            assertThat(e.getMessage(), containsString(key));
     * Tests the invalid value for {@code wlm.workload_group.node.memory_rejection_threshold}
 * compatible open source license.
        new WorkloadManagementSettings(Settings.EMPTY, cs);
     */  
     * A cluster that already carries an out-of-range value in persisted cluster state (as in the incident, where
        Settings update = Settings.builder()
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        workloadManagementSettings.setNodeLevelMemoryRejectionThreshold(0.86);  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
     * not only via the setters.  
        }  
        // Values that validation would reject (out of range, and cancellation < rejection) are still assigned by the  
        new WorkloadManagementSettings(Settings.EMPTY, cs);
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
     * Same as above for the memory pair.  
import static org.hamcrest.Matchers.containsString;  
    public void testLoweringBothMemoryThresholdsTogetherIsAppliedCleanly() {
     * new feature development. This test is to ensure that {@link WorkloadManagementSettings} holds the
    public void testLoweringBothCpuThresholdsTogetherIsAppliedCleanly() {
     * invariant is enforced at settings-update validation time (not in the setter), so it is exercised here through
        Settings cpu = Settings.builder()  
    }  
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);  
     */
    }  
     * When the value is set more than {@code wlm.workload_group.node.cpu_cancellation_threshold}. The ordering
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
     */
    /**
     */  
    /**
        Settings settings = Settings.builder().put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8).build();
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
        Settings update = Settings.builder()
        wlm.setNodeLevelCpuCancellationThreshold(0.99);
    public void testOutOfRangeCpuCancellationThresholdIsArchivedOnRecovery() {
     * Tests the invalid value for {@code wlm.workload_group.node.memory_cancellation_threshold}  
    public void testInvalidNodeLevelMemoryCancellationThresholdCase1() {  
     * Using setNodeLevelMemoryRejectionThreshold function  
            .build();
     * Lowering BOTH thresholds in a single update to a new, consistent state (rejection stays below cancellation) must
        assertThrows(IllegalArgumentException.class, () -> new WorkloadManagementSettings(settings, cs));
        Settings poisoned = Settings.builder().put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.98).build();
    /**
        Settings settings = Settings.builder().put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.8).build();
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> cs.validateUpdate(memory));
     * Tests the valid value for {@code wlm.workload_group.node.cpu_rejection_threshold}
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .build();
    /**  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.85)
     */  
        WorkloadManagementSettings wlm = new WorkloadManagementSettings(Settings.EMPTY, cs); // rejection=0.8, cancellation=0.9  
            .build();  
        // cancellation 0.65 < rejection 0.7 violates the invariant
    /**
    /**
        Settings settings = Settings.builder().put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.9).build();  
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> cs.validate(update, true));
            NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME }) {
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);  
     * {@code 0.98} was committed before the fix) must be able to recover: on state recovery the invalid setting is
        // cancellation 0.65 < rejection 0.7 violates the invariant
            NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME,
     * Tests the invalid value for {@code wlm.workload_group.node.memory_rejection_threshold}
     * archived rather than applied. This verifies the recovery/self-heal path enabled by the validator.  
     * The rejection-threshold max (0.90) must be enforced through the validation path for both cpu and memory, so a  
     * Tests the invalid value for {@code wlm.workload_group.node.memory_rejection_threshold}
    }
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.7)
     * a stale sibling field: the cancellation consumer applied first would compare the new cancellation against the old
    public void testValidNodeLevelCpuRejectionThresholdCase2() {  
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8)
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            1e-9  
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
    public void testInvalidMemoryInstantiationOfWorkloadManagementSettings() {
        IllegalArgumentException e1 = expectThrows(IllegalArgumentException.class, () -> cs.validateUpdate(cpu));
        // validate(...) is the other check the settings API applies to the final persistent/transient settings.  
     */  
     * Tests the valid value for {@code wlm.workload_group.node.cpu_rejection_threshold}
     * When the value is set more than {@literal 0.9}. The max is enforced at settings-update validation time.  
     * The memory ordering violation must be rejected via the validation path (mirror of the cpu ordering test), so a
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.95) // > 0.90 rejection max
        cs.validate(update, true);  
        cs.validate(update, true);
        assertEquals(-0.1, wlm.getNodeLevelCpuRejectionThreshold(), 1e-9);
    }
    /**
        new WorkloadManagementSettings(Settings.EMPTY, cs);
        assertThrows(IllegalArgumentException.class, () -> cs.validateUpdate(update));
        assertEquals(0.86, workloadManagementSettings.getNodeLevelMemoryRejectionThreshold(), 1e-9);
     * When the value is set more than {@literal 0.9}. The max is enforced at settings-update validation time.  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
     */
     */
        Settings update = Settings.builder().put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.95).build();
     */
    /**  
        new WorkloadManagementSettings(Settings.EMPTY, cs);  
    /**
     * Tests the invalid value for {@code wlm.workload_group.node.cpu_rejection_threshold}
     */  
     */
        Settings settings = Settings.builder()
    public void testValidNodeLevelMemoryCancellationThresholdCase1() {
        Settings update = Settings.builder()
            .build();
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.8)  
        cs.validateUpdate(update);
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
        Settings update = Settings.builder().put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.98).build();
    }
    public void testInvalidNodeLevelCpuRejectionThresholdCase2() {  
        ClusterSettings cs = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.opensearch.wlm.WorkloadManagementSettings.NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME;  
     */
     * When the value is set more than {@code wlm.workload_group.node.cpu_cancellation_threshold} accidentally during
    }  
        assertEquals(0.79, workloadManagementSettings.getNodeLevelMemoryRejectionThreshold(), 1e-9);
    }
            .put(NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME, 0.8)  
        WorkloadManagementSettings workloadManagementSettings = new WorkloadManagementSettings(settings, cs);
            .put(NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME, 0.65)
     * (higher) rejection and throw while applying committed state, destabilizing the cluster-manager.
    }
     * is enforced at settings-update validation time (not in the setter), so it is exercised here through the
        cs.applySettings(update); // must not throw  
            .put(NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME, 0.85)
            .put(NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME, 0.85)
