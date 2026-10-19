                    .prepareGetSettings("test")
            client().admin().indices().prepareGetSettings("test").get().getIndexToSettings().get("test").hasValue("archived.index.dummy2")
                .indices()
import static org.hamcrest.Matchers.startsWith;
                .indices()
                .setSettings(Settings.builder().putNull("archived.index.dummy"))
            .prepareUpdateSettings("test")
import org.opensearch.plugins.Plugin;  
                    .hasValue("archived.index.dummy2")
        );
    }
        // Archived setting update should fail on open index.  
                client().admin()
            );  
                .actionGet()
        client().admin()
        assertEquals(2, internalCluster().numDataAndClusterManagerNodes());
    @Override  
        }
                .isAcknowledged()
            Setting.Property.Dynamic
import java.util.concurrent.TimeUnit;
                    .getIndexToSettings()  
import org.opensearch.common.settings.Setting;
            // Verify that cluster state is in recovered state.
        public static final Setting<String> DUMMY_SETTING2 = Setting.simpleString(
                    .get()
        String oldClusterManagerNode = internalCluster().startClusterManagerOnlyNode();
            client().admin()
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
                    .getIndexToSettings()  
        assertTrue(  
        String newClusterManagerNode = internalCluster().startClusterManagerOnlyNode();
            );  
            .execute()  
        assertFalse(
 * compatible open source license.
                .execute()
 * SPDX-License-Identifier: Apache-2.0
        // Remove dummy plugin and replace the cluster manager node so that the stale plugin setting moves to "archived".  
            .actionGet();
                .execute()
import org.opensearch.test.InternalTestCluster;
            "index.dummy2",  
            .indices()  
            IllegalArgumentException.class,
import java.util.Collection;
        // Verify that archived settings exists.  
                .prepareUpdateSettings("test")
            assertFalse(client().admin().cluster().prepareState().get().getState().blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));  
            .prepareUpdateSettings("test")  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(oldClusterManagerNode));  
            assertTrue(
 * this file be licensed under the Apache-2.0 license or a
        ensureYellow();  
            client().admin()  
        assertBusy(() -> {
        assertThat(
        );
            startsWith("Can't update non dynamic settings [[archived.index.dummy]] for open indices [[test")  
                .indices()
    }  
        IllegalArgumentException exception = expectThrows(
                    .get("test")
        // Verify that a random unrelated setting can be updated when archived settings are present.  
                .prepareUpdateSettings("test")
        return installPlugin ? Arrays.asList(DummySettingPlugin.class) : Collections.emptyList();
            .actionGet();  
            Setting.Property.IndexScope,
        @Override
            .execute()
                client().admin()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // Set up the cluster with an index containing dummy setting(owned by dummy plugin)
            return Arrays.asList(DUMMY_SETTING, DUMMY_SETTING2);
            () -> client().admin()  
                    .indices()  
            .setSettings(Settings.builder().put("index.dummy", "foobar").put("index.dummy2", "foobar"))
public class ArchivedIndexSettingsIT extends OpenSearchIntegTestCase {
    private volatile boolean installPlugin;  
import org.opensearch.common.settings.Settings;
import java.util.Collections;  
                    .indices()  
        client().admin().indices().prepareClose("test").get();  
package org.opensearch.indices.settings;
            .indices()
        );
                .isAcknowledged()  
        // Verify that archived settings are cleaned up successfully.  
        // Add a dummy setting
            "index.dummy",
        assertFalse(
                    .hasValue("archived.index.dummy")
                    .get()
import java.util.List;
            Setting.Property.IndexScope,
/*  
        String oldDataNode = internalCluster().startDataOnlyNode();  
        // Remove archived.index.dummy explicitly.
        installPlugin = false;
 */  
        );  
        );  
    public static class DummySettingPlugin extends Plugin {
            Setting.Property.Dynamic  
            assertTrue(
        // close the index.
        installPlugin = true;  
                .prepareUpdateSettings("test")  
                .setSettings(Settings.builder().putNull("archived.index.dummy"))  
                .actionGet()  
        public static final Setting<String> DUMMY_SETTING = Setting.simpleString(  
}
        }, 30, TimeUnit.SECONDS);
import java.util.Arrays;
import org.opensearch.test.OpenSearchIntegTestCase;
                .execute()
        // Remove archived.index.dummy2 using wildcard.
    }  
        client().admin()
                .setSettings(Settings.builder().putNull("archived.*"))  
            .setSettings(Settings.builder().put("index.max_terms_count", 1024).build())
        createIndex("test");
    public void testArchiveSettings() throws Exception {
                .actionGet()
        );  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
        );
            exception.getMessage(),
        assertTrue(
        internalCluster().restartNode(newClusterManagerNode);
                    .prepareGetSettings("test")
        );  
 *
            client().admin().indices().prepareGetSettings("test").get().getIndexToSettings().get("test").hasValue("archived.index.dummy")
 * The OpenSearch Contributors require contributions made to  
                    .get("test")
        public List<Setting<?>> getSettings() {  
