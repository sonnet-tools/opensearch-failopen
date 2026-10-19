    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.indices.RestUpdateSettingsAction;
import org.opensearch.rest.action.admin.indices.RestGetSettingsAction;
            OpenSearchParseException.class,  
        );
    public void testRolloverIndex() {  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }
    public void testCleanupRepository() {  
    }  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    }
            OpenSearchParseException.class,
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
    }
/**
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
    public void testDeleteSnapshot() {
        RestNodeAttrsAction action = new RestNodeAttrsAction();  
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.cluster.dangling.RestImportDanglingIndexAction;  
        return request;  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        };
        RestIndicesAliasesAction action = new RestIndicesAliasesAction();
    public void testUpdateSettings() {
    private final TestThreadPool threadPool = new TestThreadPool(RenamedTimeoutRequestParameterTests.class.getName());
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.transport.client.node.NodeClient;
        return request;  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
        RestResizeHandler.RestCloneIndexAction action = new RestResizeHandler.RestCloneIndexAction();  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        RestGetMappingAction action = new RestGetMappingAction(threadPool);
    public void testGetComponentTemplate() {  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestDeleteIndexAction action = new RestDeleteIndexAction();
        RestDeleteComposableIndexTemplateAction action = new RestDeleteComposableIndexTemplateAction();
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));  
 */  
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
    }  
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
            OpenSearchParseException.class,
    }  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        BaseRestHandler.parseDeprecatedMasterTimeoutParameter(
    public void testCatShards() {
        request.params().put("cluster_manager_timeout", "2m");
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
    public void testSplitIndex() {
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testShrinkIndex() {  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestOpenIndexAction action = new RestOpenIndexAction();
            getMasterNodeRequest(),  
import org.opensearch.rest.action.admin.indices.RestPutComposableIndexTemplateAction;
    public void testClusterGetSettings() throws IOException {
import org.opensearch.common.settings.Settings;  
        RestPutIndexTemplateAction action = new RestPutIndexTemplateAction();  
        );  
        RestPluginsAction action = new RestPluginsAction();  
    public void testGetMapping() {  
import org.opensearch.rest.action.admin.cluster.RestGetRepositoriesAction;  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));  
        request.params().put("master_timeout", "3s");
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestGetPipelineAction action = new RestGetPipelineAction();  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        request.params().put("cluster_manager_timeout", "2m");
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
    public void testCreateIndex() {  
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
    public void testCatNodeattrs() {
    }  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
import org.opensearch.rest.action.admin.cluster.RestPutStoredScriptAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        return new ClusterManagerNodeRequest() {  
    public void testAddIndexBlock() {
    }
    }  
import org.opensearch.rest.action.admin.indices.RestDeleteIndexAction;  
    public void testGetIndexTemplate() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestClusterRerouteAction action = new RestClusterRerouteAction(filter);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        request.params().put("master_timeout", "3s");  
        );  
        RestDeleteComponentTemplateAction action = new RestDeleteComponentTemplateAction();
import org.opensearch.rest.action.admin.indices.RestGetMappingAction;  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testDeleteIndexTemplate() {
import org.opensearch.rest.action.admin.indices.RestAddIndexBlockAction;
    private FakeRestRequest getRestRequestWithDeprecatedParam() {  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }  
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
import org.opensearch.rest.action.admin.indices.RestGetComposableIndexTemplateAction;  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.indices.RestDeleteComposableIndexTemplateAction;
    private FakeRestRequest getRestRequestWithBothParams() {
    private FakeRestRequest getFakeRestRequestWithBody() {
        RestGetIndicesAction action = new RestGetIndicesAction();  
 * The tests are used to validate the behavior about the renamed request parameter.
import org.opensearch.rest.action.cat.RestNodeAttrsAction;  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
            OpenSearchParseException.class,
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testDeleteComponentTemplate() {  
        request.params().put("master_timeout", "3s");  
    public void terminateThreadPool() {  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        final SettingsFilter filter = new SettingsFilter(Collections.singleton("foo.filtered"));  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    public void testClusterPendingTasks() {
import org.opensearch.rest.action.admin.cluster.RestClusterRerouteAction;
import org.opensearch.rest.action.ingest.RestDeletePipelineAction;
    public void testClusterState() throws IOException {
/*  
        FakeRestRequest request = new FakeRestRequest();  
            () -> RestClusterHealthAction.fromRequest(getRestRequestWithBodyWithBothParams())  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        request.params().put("master_timeout", "3s");
        );
        request.params().put("index", "test");
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestGetIndexTemplateAction action = new RestGetIndexTemplateAction();  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
            OpenSearchParseException.class,
public class RenamedTimeoutRequestParameterTests extends OpenSearchTestCase {
    public void testDeleteIndex() {
        FakeRestRequest request = getFakeRestRequestWithBody();
    }  
        Exception e = assertThrows(
        RestSegmentsAction action = new RestSegmentsAction(responseLimitSettings);  
import org.opensearch.rest.action.admin.cluster.RestDeleteRepositoryAction;  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestCreateSnapshotAction action = new RestCreateSnapshotAction();  
        request.params().put("cluster_manager_timeout", "1h");
                "test"  
        RestGetStoredScriptAction action = new RestGetStoredScriptAction();
        FakeRestRequest request = new FakeRestRequest();  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
import org.opensearch.rest.action.admin.indices.RestGetIndicesAction;
            OpenSearchParseException.class,
 *
    public void testCloseIndex() {
        RestPutMappingAction action = new RestPutMappingAction();  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        RestShardsAction action = new RestShardsAction();
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        FakeRestRequest request = new FakeRestRequest();
        RestSimulateTemplateAction action = new RestSimulateTemplateAction();  
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestGetComposableIndexTemplateAction action = new RestGetComposableIndexTemplateAction();
    }
                getMasterNodeRequest(),  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        RestPutPipelineAction action = new RestPutPipelineAction();
        request.params().put("cluster_manager_timeout", "1h");
import org.opensearch.rest.action.admin.indices.RestPutComponentTemplateAction;  
            OpenSearchParseException.class,  
        RestPutStoredScriptAction action = new RestPutStoredScriptAction();
    public void testVerifyRepository() {
        request.params().put("master_timeout", "3s");
    }
        RestCloseIndexAction action = new RestCloseIndexAction();  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.cat.RestNodesAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        request.params().put("master_timeout", "3s");
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    public void testPutMapping() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
    }
    public void testDeleteRepository() {  
        RestResizeHandler.RestShrinkIndexAction action = new RestResizeHandler.RestShrinkIndexAction();
    public void testCatAllocation() {
    public void testCatSnapshots() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
    public void testCatThreadPool() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
    }  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        FakeRestRequest request = new FakeRestRequest();
        );
        Exception e = assertThrows(
        RestPendingClusterTasksAction action = new RestPendingClusterTasksAction();
import org.opensearch.rest.action.cat.RestIndicesAction;
    }  
    }  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        Settings settings = Settings.builder().build();
        RestCloneSnapshotAction action = new RestCloneSnapshotAction();
    private ClusterManagerNodeRequest getMasterNodeRequest() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));  
 * and alternative parameter 'cluster_manager_timeout' is added.  
    public void testCatMaster() {
        request.params().put("id", "test");
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        RestClusterGetSettingsAction action = new RestClusterGetSettingsAction(null, null, filter);  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.settings.ClusterSettings;
        request.params().put("cluster_manager_timeout", randomFrom("1h", "2m"));
import org.opensearch.rest.action.admin.indices.RestRolloverIndexAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
import org.opensearch.rest.action.admin.indices.RestSimulateTemplateAction;
import org.opensearch.rest.action.cat.RestTemplatesAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestSnapshotAction action = new RestSnapshotAction();  
    public void testCatSegments() {
    }
import org.opensearch.rest.action.admin.cluster.dangling.RestDeleteDanglingIndexAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.cluster.RestClusterUpdateSettingsAction;
    }
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
            OpenSearchParseException.class,
        );
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
    }
import org.opensearch.rest.action.admin.cluster.RestDeleteSnapshotAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestNodesAction action = new RestNodesAction();
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
    public void testDeleteComposableIndexTemplate() {
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
 * this file be licensed under the Apache-2.0 license or a
    }  
    }
    public void testSimulateTemplate() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));  
        Exception e = assertThrows(  
    public void testIndexDeleteAliases() {
import org.opensearch.rest.action.cat.RestAllocationAction;  
        final SettingsFilter filter = new SettingsFilter(Collections.singleton("foo.filtered"));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
import org.opensearch.rest.action.admin.cluster.RestClusterGetSettingsAction;  
    }  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
    }  
            "test"  
    }
        FakeRestRequest request = getFakeRestRequestWithBody();
import org.opensearch.rest.action.admin.indices.RestDeleteIndexTemplateAction;
import org.opensearch.rest.action.admin.indices.RestIndexPutAliasAction;  
    private static final String MASTER_TIMEOUT_DEPRECATED_MESSAGE =
        request.params().put("cluster_manager_timeout", "1h");
        FakeRestRequest request = new FakeRestRequest();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestPutComponentTemplateAction action = new RestPutComponentTemplateAction();
        RestIndexDeleteAliasesAction action = new RestIndexDeleteAliasesAction();
import org.opensearch.rest.action.cat.RestRepositoriesAction;
        return request;
    public void testCatTemplates() {  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    }  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        request.params().put("id", "test");
        Exception e = assertThrows(
        NodeClient client = new NodeClient(Settings.builder().put(INDEX_READ_ONLY_SETTING.getKey(), Boolean.FALSE).build(), threadPool);
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        terminate(threadPool);
        RestSnapshotsStatusAction action = new RestSnapshotsStatusAction();
        return new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(new BytesArray("{}"), MediaTypeRegistry.JSON).build();
    public void testNoWarningsForNewParam() {
        RestGetSnapshotsAction action = new RestGetSnapshotsAction();
import org.opensearch.rest.action.admin.cluster.RestRestoreSnapshotAction;
    }  
        RestGetSettingsAction action = new RestGetSettingsAction();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.opensearch.common.breaker.ResponseLimitSettings;  
        RestIndicesAction action = new RestIndicesAction(responseLimitSettings, new SystemIndices(Collections.emptyMap()));  
        request.params().put("master_timeout", "3s");  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.junit.After;
    public void testSimulateIndexTemplate() {  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }  
            getRestRequestWithNewParam(),
    }
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_SETTING;
        RestSimulateIndexTemplateAction action = new RestSimulateIndexTemplateAction();
    public void testIndexPutAlias() {
    }  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
    public void testPutComponentTemplate() {  
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestAllocationAction action = new RestAllocationAction();
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
import org.opensearch.rest.action.admin.cluster.RestClusterStateAction;  
    public void testIndicesAliases() {  
import org.opensearch.rest.action.ingest.RestGetPipelineAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestPutComposableIndexTemplateAction action = new RestPutComposableIndexTemplateAction();
    public void testClusterHealth() {  
    public void testCatPendingTasks() {
import org.opensearch.threadpool.TestThreadPool;  
    }
        request.params().put("cluster_manager_timeout", "1h");  
import org.opensearch.rest.action.cat.RestClusterManagerAction;
import org.opensearch.rest.action.admin.indices.RestGetComponentTemplateAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testGetSnapshots() {
    }
        "Parameter [master_timeout] is deprecated and will be removed in 3.0. To support inclusive language, please use [cluster_manager_timeout] instead.";  
        request.params().put("block", "metadata");  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
package org.opensearch.action;
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.indices.RestPutIndexTemplateAction;
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
            () -> BaseRestHandler.parseDeprecatedMasterTimeoutParameter(
    }
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    }
        RestDeletePipelineAction action = new RestDeletePipelineAction();
            deprecationLogger,
            OpenSearchParseException.class,
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE, "empty templates should no longer be used");
import org.opensearch.rest.action.cat.RestSnapshotAction;
        final SettingsFilter filter = new SettingsFilter(Collections.singleton("foo.filtered"));  
                deprecationLogger,
 * As of 2.0, the request parameter 'master_timeout' in all applicable REST APIs is deprecated,
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
        request.params().put("index_uuid", "test");
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
            OpenSearchParseException.class,
        RestDeleteIndexTemplateAction action = new RestDeleteIndexTemplateAction();  
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
    }  
        RestGetRepositoriesAction action = new RestGetRepositoriesAction(filter);
    public void testImportDanglingIndex() {
        );  
 * compatible open source license.
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
            @Override
import org.opensearch.rest.action.cat.RestShardsAction;  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.cluster.RestVerifyRepositoryAction;
    }
    public void testCatRepositories() {  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
    }
        "Please only use one of the request parameters [master_timeout, cluster_manager_timeout].";
    public void testGetPipeline() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testGetComposableIndexTemplate() {
        RestCreateIndexAction action = new RestCreateIndexAction();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.OpenSearchParseException;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        RestImportDanglingIndexAction action = new RestImportDanglingIndexAction();  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        FakeRestRequest request = new FakeRestRequest();  
import org.opensearch.rest.BaseRestHandler;  
    }  
    }
        request.params().put("master_timeout", "3s");  
import org.opensearch.rest.action.admin.cluster.RestPutRepositoryAction;  
    public void testCatNodes() {  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(  
            )
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testClusterUpdateSettings() throws IOException {  
            "test"  
    public void testPutPipeline() {  
    public void testDeprecationWarningForOldParam() {
    public void testPutIndexTemplate() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        Exception e = assertThrows(
    public void testGetSettings() {
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    private static final String DUPLICATE_PARAMETER_ERROR_MESSAGE =  
        BaseRestHandler.parseDeprecatedMasterTimeoutParameter(
    public void testCatClusterManager() {  
    private final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);  
    }
        RestVerifyRepositoryAction action = new RestVerifyRepositoryAction();  
        RestDeleteDanglingIndexAction action = new RestDeleteDanglingIndexAction();
        RestRestoreSnapshotAction action = new RestRestoreSnapshotAction();
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.opensearch.rest.action.admin.indices.RestDeleteComponentTemplateAction;
import org.opensearch.rest.action.admin.cluster.RestCreateSnapshotAction;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.opensearch.common.settings.SettingsFilter;
    }  
import org.opensearch.rest.action.admin.indices.RestPutMappingAction;  
    }  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        RestGetComponentTemplateAction action = new RestGetComponentTemplateAction();
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)  
        RestUpdateSettingsAction action = new RestUpdateSettingsAction();
 * SPDX-License-Identifier: Apache-2.0
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.ingest.RestPutPipelineAction;  
        request.params().put("name", "*");  
        RestPendingClusterTasksAction action = new RestPendingClusterTasksAction();
import org.opensearch.rest.action.admin.indices.RestIndicesAliasesAction;
    public void testCloneSnapshot() {
        RestPutRepositoryAction action = new RestPutRepositoryAction();  
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        RestIndexPutAliasAction action = new RestIndexPutAliasAction();  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));  
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)  
import org.opensearch.common.logging.DeprecationLogger;
    public void testCatIndices() {
        FakeRestRequest request = new FakeRestRequest();
import static org.hamcrest.Matchers.containsString;
        request.params().put("name", "test");
    }
        request.params().put("master_timeout", "3s");
        );
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));
 * The OpenSearch Contributors require contributions made to  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }
    public void testCreateSnapshot() {
        ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
        FakeRestRequest request = new FakeRestRequest();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        request.params().put("index_uuid", "test");  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        );  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testCloneIndex() {
import org.opensearch.rest.action.admin.cluster.RestDeleteStoredScriptAction;
    }
    public void testPutRepository() {
        );
 */  
        Exception e = assertThrows(  
import org.opensearch.rest.action.admin.cluster.RestCloneSnapshotAction;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
    }
    public void testOpenIndex() {
    }  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testDeleteDanglingIndex() {
                getRestRequestWithBothParams(),
import org.opensearch.rest.action.admin.cluster.RestSnapshotsStatusAction;  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
            deprecationLogger,
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));  
    private FakeRestRequest getRestRequestWithBodyWithBothParams() {  
import org.opensearch.rest.action.admin.cluster.RestGetStoredScriptAction;
import org.opensearch.rest.action.admin.cluster.RestGetSnapshotsAction;
import org.opensearch.rest.action.admin.cluster.RestCleanupRepositoryAction;
    public void testGetIndices() {
import java.io.IOException;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.indices.RestGetIndexTemplateAction;
    public void testPutComposableIndexTemplate() {
    public void testClusterReroute() throws IOException {  
        RestClusterUpdateSettingsAction action = new RestClusterUpdateSettingsAction();
    private FakeRestRequest getRestRequestWithNewParam() {  
        request.params().put("master_timeout", "3s");
        );
        final Settings settings = Settings.builder().build();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
import org.opensearch.indices.SystemIndices;
    }  
    }
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }
import org.opensearch.rest.action.admin.indices.RestCloseIndexAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestClusterStateAction action = new RestClusterStateAction(filter);
    public void testSnapshotsStatus() {
    public void testRestoreSnapshot() {  
    }
    }
        request.params().put("cluster_manager_timeout", "2m");
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));  
    public void testPutStoredScript() {
        RestAddIndexBlockAction action = new RestAddIndexBlockAction();
        RestRepositoriesAction action = new RestRepositoriesAction();
import org.opensearch.rest.action.admin.indices.RestIndexDeleteAliasesAction;
    }  
        );
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestTemplatesAction action = new RestTemplatesAction();
        RestResizeHandler.RestSplitIndexAction action = new RestResizeHandler.RestSplitIndexAction();
import org.opensearch.rest.action.admin.cluster.RestClusterHealthAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestClusterManagerAction action = new RestClusterManagerAction();
    public void testBothParamsNotValid() {
        RestClusterManagerAction action = new RestClusterManagerAction();
        request.params().put("cluster_manager_timeout", "1h");
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
    @After
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }  
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
    }
    }
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    public void testGetStoredScript() {  
        RestThreadPoolAction action = new RestThreadPoolAction();
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        RestCleanupRepositoryAction action = new RestCleanupRepositoryAction();
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
    }
        RestDeleteStoredScriptAction action = new RestDeleteStoredScriptAction();  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.cat.RestSegmentsAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.indices.RestSimulateIndexTemplateAction;  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import java.util.Collections;
        final SettingsFilter filter = new SettingsFilter(Collections.singleton("foo.filtered"));
    private final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RenamedTimeoutRequestParameterTests.class);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        request.params().put("cluster_manager_timeout", "1h");
import org.opensearch.rest.action.admin.indices.RestOpenIndexAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
            OpenSearchParseException.class,
import org.opensearch.core.common.bytes.BytesArray;
        FakeRestRequest request = new FakeRestRequest();  
        RestDeleteRepositoryAction action = new RestDeleteRepositoryAction();
        return request;  
        );
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
            public ActionRequestValidationException validate() {
    public void testCatPlugins() {
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testDeleteStoredScript() {
 * Remove the test after removing MASTER_ROLE and 'master_timeout'.
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestRolloverIndexAction action = new RestRolloverIndexAction();
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.test.rest.FakeRestRequest;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
            getMasterNodeRequest(),  
            }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.opensearch.rest.action.admin.indices.RestCreateIndexAction;  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.cat.RestPendingClusterTasksAction;
    }  
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));  
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        RestDeleteSnapshotAction action = new RestDeleteSnapshotAction();
    public void testGetRepositories() {
    }
        Exception e = assertThrows(  
import org.opensearch.rest.action.admin.indices.RestResizeHandler;
            getRestRequestWithDeprecatedParam(),
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));  
}
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
import org.opensearch.rest.action.cat.RestThreadPoolAction;  
        Exception e = assertThrows(
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.opensearch.rest.action.cat.RestPluginsAction;  
                return null;  
    public void testDeletePipeline() {  
        Exception e = assertThrows(
