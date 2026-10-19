    @Before
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    public void testRemoteValidation() {
            threadPool,
        super.setUp();
/*  
import org.junit.After;  
    }  
        clusterService.close();
import org.opensearch.threadpool.ThreadPool;
        clusterSettings = clusterService.getClusterSettings();
import org.opensearch.threadpool.TestThreadPool;  
        assertEquals("Cannot close index while remote migration is ongoing", e.getMessage());
    @After
import org.opensearch.common.settings.ClusterSettings;  
            mock(IndexNameExpressionResolver.class),
import org.opensearch.cluster.metadata.MetadataIndexStateService;
    private ClusterSettings clusterSettings;
import org.opensearch.test.OpenSearchTestCase;
import org.junit.Before;
import org.opensearch.cluster.service.ClusterService;
        Exception e = expectThrows(IllegalStateException.class, () -> action.doExecute(null, new CloseIndexRequest(TEST_IND), null));
        super.tearDown();
            new DestructiveOperations(Settings.EMPTY, clusterSettings)  
    }
            .put(MIGRATION_DIRECTION_SETTING.getKey(), REMOTE_STORE_DIRECTION)  
    private TransportCloseIndexAction createAction() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Settings;
            clusterSettings,  
import java.util.concurrent.TimeUnit;
        TransportCloseIndexAction action = createAction();  
import org.junit.BeforeClass;  
        Settings settings = Settings.builder()
    private ClusterService clusterService;
    }
    }
    public static void afterClass() {  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
    }
package org.opensearch.action.admin.indices.close;
    private final static String REMOTE_STORE_DIRECTION = "remote_store";
    private final static String MIXED_MODE = "mixed";  
        );
    @Override
            mock(ActionFilters.class),
import org.opensearch.action.support.ActionFilters;
    // Test if validateRemoteMigration throws illegal exception when compatibility mode is MIXED and migration Direction is REMOTE_STORE
        clusterService = mock(ClusterService.class);  
            mock(MetadataIndexStateService.class),
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
        threadPool = new TestThreadPool(getTestClass().getName());
    public void tearDown() throws Exception {  
        threadPool = null;
public class TransportCloseIndexActionTests extends OpenSearchTestCase {  
    }  
    @AfterClass
    @BeforeClass
import static org.mockito.Mockito.when;
            Settings.EMPTY,
}  
import org.opensearch.transport.TransportService;
        ClusterSettings clusSet = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public static void beforeClass() {  
        when(clusterService.getClusterSettings()).thenReturn(clusSet);  
        return new TransportCloseIndexAction(  
            mock(TransportService.class),
            clusterService,  
 */  
import org.opensearch.action.support.DestructiveOperations;
import static org.mockito.Mockito.mock;  
 *
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
    @Override
 * this file be licensed under the Apache-2.0 license or a
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), MIXED_MODE)
import org.junit.AfterClass;
    public void setUp() throws Exception {  
    private static ThreadPool threadPool;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            .build();
    private final static String TEST_IND = "ind";  
