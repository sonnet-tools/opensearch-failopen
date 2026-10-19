    }
    public static final String _ID_TWO = "G5iIqHy4g7eK1qIAAAAIH53=1";
import static org.junit.Assert.assertFalse;
import org.opensearch.plugin.wlm.rule.sync.RefreshBasedSyncMechanism;
    }
                .build();
        assertEquals(collectionOne.size(), collectionTwo.size());
        boolean assertUpdateAt
    public static final WorkloadGroup workloadGroupTwo = builder().name(NAME_TWO)
        Map<ResourceType, Double> resourceLimitMapOne,
                WorkloadGroup two = listTwo.get(i);
        .updatedAt(TIMESTAMP_TWO)
            } else {
            new MutableWorkloadGroupFragment(
}
        ClusterApplierService clusterApplierService = new ClusterApplierService(
            clusterSettings(),
    }
/*
        list.add(workloadGroupTwo);
import org.opensearch.cluster.ClusterName;
 *
                Map.of(ResourceType.MEMORY, 0.5),
        return new ClusterSettings(settings(), clusterSettingsSet());
 * this file be licensed under the Apache-2.0 license or a
    public static final long TIMESTAMP_TWO = 4513232415L;
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
        return new Tuple<WorkloadGroupPersistenceService, ClusterState>(workloadGroupPersistenceService, clusterState);
            settings(),
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.3))
        )
        );
import static org.opensearch.cluster.metadata.WorkloadGroup.builder;
    ) {
                assertEquals(one.get_id(), two.get_id());
        list.add(workloadGroupOne);
import java.util.Map;
import org.opensearch.wlm.WorkloadManagementSettings;
    }
                MutableWorkloadGroupFragment.ResiliencyMode.ENFORCED,
    }
            clusterApplierService
    ) {
            return new WlmClusterSettingValuesProvider(settings, clusterSettings);
    ) {
    public static final WorkloadGroup workloadGroupWithSearchSettings = builder().name(NAME_THREE)
        .mutableWorkloadGroupFragment(
import org.opensearch.cluster.service.ClusterManagerService;
        return Settings.builder().build();
            "name",
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
            clusterSettings.registerSetting(WorkloadManagementSettings.WLM_MODE_SETTING);
    }
            mock(ClusterManagerService.class),
import static org.junit.Assert.assertTrue;
        try (WorkloadManagementPlugin plugin = new WorkloadManagementPlugin()) {
        .build();
        }
            clusterSettings(),
                assertEquals(one.getName(), two.getName());
        Collection<WorkloadGroup> collectionOne,
    public static final long TIMESTAMP_THREE = 4513232417L;
        ClusterSettings clusterSettings = new ClusterSettings(settings, clusterSettingsSet());
        Map<String, WorkloadGroup> workloadGroups
        .updatedAt(TIMESTAMP_ONE)
    public static final String NAME_NONE_EXISTED = "workload_group_none_existed";
        );
    public static final Settings TEST_SEARCH_SETTINGS = Settings.builder().put("search.default_search_timeout", "30s").build();
    public static final String NAME_TWO = "workload_group_two";
        }
    public static Set<Setting<?>> clusterSettingsSet() {
        Collection<WorkloadGroup> collectionTwo,
            mock(ClusterManagerService.class),
    public static WorkloadGroupPersistenceService workloadGroupPersistenceService() {
 */
        clusterApplierService.setInitialState(clusterState);
import org.opensearch.threadpool.ThreadPool;
    public static void assertEqualWorkloadGroups(
            new MutableWorkloadGroupFragment(MutableWorkloadGroupFragment.ResiliencyMode.MONITOR, Map.of(ResourceType.MEMORY, 0.6))
import java.util.Comparator;
        Settings settings = Settings.builder().build();
    public static final String _ID_THREE = "H6jVP6Kb0zgtZmPOmZj4UQ==";
                TEST_SEARCH_SETTINGS
import org.opensearch.common.collect.Tuple;
        )
        return set;
                assertEquals(one.getResiliencyMode(), two.getResiliencyMode());
            settings,
import java.util.Collection;
    }
        );
            ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, new HashSet<>(plugin.getSettings()));
import org.opensearch.cluster.metadata.Metadata;
package org.opensearch.plugin.wlm;
        );
import java.util.Set;
                WorkloadGroup one = listOne.get(i);
            clusterSettings(),
    public static final String NAME_THREE = "workload_group_three";
    public static final long TIMESTAMP_ONE = 4513232413L;
        ClusterService clusterService = new ClusterService(
            settings(),
        ClusterApplierService clusterApplierService = new ClusterApplierService(
        .mutableWorkloadGroupFragment(
        listOne.sort(Comparator.comparing(WorkloadGroup::getName));
 * compatible open source license.
import org.opensearch.wlm.ResourceType;
        ._id(_ID_ONE)
                .put(WorkloadManagementSettings.WLM_MODE_SETTING_NAME, wlmMode)
import java.util.HashSet;
import org.opensearch.common.settings.Settings;
        final Metadata metadata = Metadata.builder().workloadGroups(Map.of(_ID_ONE, workloadGroupOne, _ID_TWO, workloadGroupTwo)).build();
                assertEquals(listOne.get(i), listTwo.get(i));
        .updatedAt(TIMESTAMP_THREE)
import org.opensearch.wlm.MutableWorkloadGroupFragment;
        assertFalse(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.contains(WorkloadGroupPersistenceService.MAX_QUERY_GROUP_COUNT));
public class WorkloadManagementTestUtils {
 * SPDX-License-Identifier: Apache-2.0
            if (assertUpdateAt) {
import org.opensearch.common.settings.ClusterSettings;
        .build();
 * The OpenSearch Contributors require contributions made to
import java.util.ArrayList;
    public static final String NAME_ONE = "workload_group_one";
        for (int i = 0; i < listOne.size(); i++) {
    }
        .mutableWorkloadGroupFragment(
    public static List<WorkloadGroup> workloadGroupList() {
import org.opensearch.cluster.metadata.WorkloadGroup;
    public static ClusterState clusterState() {
            clusterSettings
                .put(RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING_NAME, 1000)
        Metadata metadata = Metadata.builder().workloadGroups(workloadGroups).build();
        return ClusterState.builder(new ClusterName("_name")).metadata(metadata).build();
            )
        assertTrue(resourceLimitMapOne.values().containsAll(resourceLimitMapTwo.values()));
        return new WorkloadGroupPersistenceService(clusterService, settings(), clusterSettings());
        List<WorkloadGroup> list = new ArrayList<>();
    public static Settings settings() {
    public static void assertEqualResourceLimits(
            clusterService,
import org.opensearch.cluster.service.ClusterApplierService;
        clusterApplierService.setInitialState(clusterState());
    public static final String _ID_ONE = "AgfUO5Ja9yfsYlONlYi3TQ==";
        .build();
        Map<ResourceType, Double> resourceLimitMapTwo
import org.opensearch.cluster.ClusterState;
import org.opensearch.plugin.wlm.service.WorkloadGroupPersistenceService;
import org.opensearch.common.settings.Setting;
            mock(ThreadPool.class)
        set.add(WorkloadGroupPersistenceService.MAX_QUERY_GROUP_COUNT);
        );
            mock(ThreadPool.class)
                assertEquals(one.getResourceLimits(), two.getResourceLimits());
            clusterApplierService
        return list;
        ._id(_ID_TWO)
        List<WorkloadGroup> listOne = new ArrayList<>(collectionOne);
    public static final WorkloadGroup workloadGroupOne = builder().name(NAME_ONE)
        List<WorkloadGroup> listTwo = new ArrayList<>(collectionTwo);
        assertTrue(resourceLimitMapOne.keySet().containsAll(resourceLimitMapTwo.keySet()));
            settings(),
        ClusterService clusterService = new ClusterService(
    }
        WorkloadGroupPersistenceService workloadGroupPersistenceService = new WorkloadGroupPersistenceService(
        )
    }
            clusterSettings(),
    public static WlmClusterSettingValuesProvider setUpNonPluginSettingValuesProvider(String wlmMode) throws Exception {
    public static Tuple<WorkloadGroupPersistenceService, ClusterState> preparePersistenceServiceSetup(
import java.util.List;
        listTwo.sort(Comparator.comparing(WorkloadGroup::getName));
            Settings settings = Settings.builder()
            }
        ._id(_ID_THREE)
        Set<Setting<?>> set = new HashSet<>(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public static ClusterSettings clusterSettings() {
import org.opensearch.cluster.service.ClusterService;
            "name",
            settings(),
