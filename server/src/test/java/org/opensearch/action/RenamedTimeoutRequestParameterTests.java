        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    private final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RenamedTimeoutRequestParameterTests.class);
import org.opensearch.rest.action.admin.cluster.RestGetStoredScriptAction;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    }
        RestDeleteRepositoryAction action = new RestDeleteRepositoryAction();
        RestDeletePipelineAction action = new RestDeletePipelineAction();
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.cat.RestPluginsAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
}
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
import org.opensearch.rest.action.admin.cluster.RestClusterStateAction;
    public void testCloneIndex() {
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
import org.opensearch.indices.SystemIndices;
import org.opensearch.rest.action.ingest.RestDeletePipelineAction;
import org.opensearch.rest.action.cat.RestIndicesAction;
        RestGetRepositoriesAction action = new RestGetRepositoriesAction(filter);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testClusterUpdateSettings() throws IOException {
    }
import org.opensearch.threadpool.TestThreadPool;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    private final TestThreadPool threadPool = new TestThreadPool(RenamedTimeoutRequestParameterTests.class.getName());
            deprecationLogger,
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestSnapshotsStatusAction action = new RestSnapshotsStatusAction();
        request.params().put("master_timeout", "3s");
        RestUpdateSettingsAction action = new RestUpdateSettingsAction();
    }
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestClusterRerouteAction action = new RestClusterRerouteAction(filter);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        return request;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testGetSnapshots() {
        final SettingsFilter filter = new SettingsFilter(Collections.singleton("foo.filtered"));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        request.params().put("cluster_manager_timeout", "2m");
    }
    public void testSimulateIndexTemplate() {
import org.opensearch.rest.action.admin.cluster.RestGetRepositoriesAction;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        );
        );
            () -> BaseRestHandler.parseDeprecatedMasterTimeoutParameter(
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    public void testDeleteComposableIndexTemplate() {
            OpenSearchParseException.class,
        request.params().put("index_uuid", "test");
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        "Please only use one of the request parameters [master_timeout, cluster_manager_timeout].";
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.indices.RestDeleteComposableIndexTemplateAction;
        RestGetComponentTemplateAction action = new RestGetComponentTemplateAction();
        return request;
        );
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }
    public void testCatPlugins() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
                getRestRequestWithBothParams(),
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    }
        RestGetComposableIndexTemplateAction action = new RestGetComposableIndexTemplateAction();
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }
    public void testGetRepositories() {
import java.io.IOException;
        request.params().put("id", "test");
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }
    public void testClusterPendingTasks() {
    public void testDeprecationWarningForOldParam() {
    public void testPutRepository() {
    }
        RestGetStoredScriptAction action = new RestGetStoredScriptAction();
        RestImportDanglingIndexAction action = new RestImportDanglingIndexAction();
import org.opensearch.rest.action.admin.indices.RestResizeHandler;
        Settings settings = Settings.builder().build();
        RestPutMappingAction action = new RestPutMappingAction();
            "test"
        RestRepositoriesAction action = new RestRepositoriesAction();
    public void testOpenIndex() {
        RestRestoreSnapshotAction action = new RestRestoreSnapshotAction();
        RestGetMappingAction action = new RestGetMappingAction(threadPool);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testUpdateSettings() {
    public void testShrinkIndex() {
        FakeRestRequest request = getFakeRestRequestWithBody();
    private ClusterManagerNodeRequest getMasterNodeRequest() {
        RestCreateIndexAction action = new RestCreateIndexAction();
import org.opensearch.rest.action.admin.cluster.RestClusterHealthAction;
    public void testClusterGetSettings() throws IOException {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestPutComposableIndexTemplateAction action = new RestPutComposableIndexTemplateAction();
import org.opensearch.rest.action.admin.indices.RestIndexDeleteAliasesAction;
import org.opensearch.rest.action.cat.RestNodesAction;
        RestClusterUpdateSettingsAction action = new RestClusterUpdateSettingsAction();
        RestVerifyRepositoryAction action = new RestVerifyRepositoryAction();
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        request.params().put("cluster_manager_timeout", "1h");
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.cluster.RestSnapshotsStatusAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    private FakeRestRequest getRestRequestWithBothParams() {
        RestClusterManagerAction action = new RestClusterManagerAction();
import org.opensearch.rest.action.ingest.RestPutPipelineAction;
/**
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
 * As of 2.0, the request parameter 'master_timeout' in all applicable REST APIs is deprecated,
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
    }
import java.util.Collections;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
 */
        request.params().put("master_timeout", "3s");
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestShardsAction action = new RestShardsAction();
    }
        RestThreadPoolAction action = new RestThreadPoolAction();
        Exception e = assertThrows(
    }
        RestDeleteIndexTemplateAction action = new RestDeleteIndexTemplateAction();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        FakeRestRequest request = new FakeRestRequest();
    public void testClusterHealth() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        RestOpenIndexAction action = new RestOpenIndexAction();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.common.logging.DeprecationLogger;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testCatMaster() {
        );
 * The OpenSearch Contributors require contributions made to
        RestAddIndexBlockAction action = new RestAddIndexBlockAction();
    public void testCatPendingTasks() {
        );
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
            OpenSearchParseException.class,
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        request.params().put("name", "*");
            )
        RestGetIndexTemplateAction action = new RestGetIndexTemplateAction();
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestCreateSnapshotAction action = new RestCreateSnapshotAction();
        RestPutPipelineAction action = new RestPutPipelineAction();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));
    public void testIndexDeleteAliases() {
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        );
    public void testClusterReroute() throws IOException {
        RestIndicesAction action = new RestIndicesAction(responseLimitSettings, new SystemIndices(Collections.emptyMap()));
import org.opensearch.rest.action.admin.indices.RestGetIndexTemplateAction;
    public void testIndexPutAlias() {
    }
        NodeClient client = new NodeClient(Settings.builder().put(INDEX_READ_ONLY_SETTING.getKey(), Boolean.FALSE).build(), threadPool);
package org.opensearch.action;
            "test"
    public void testPutComposableIndexTemplate() {
        request.params().put("index", "test");
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
        request.params().put("cluster_manager_timeout", "2m");
    public void testCleanupRepository() {
        RestPutComponentTemplateAction action = new RestPutComponentTemplateAction();
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestNodesAction action = new RestNodesAction();
        Exception e = assertThrows(
public class RenamedTimeoutRequestParameterTests extends OpenSearchTestCase {
    }
 * The tests are used to validate the behavior about the renamed request parameter.
        RestGetSnapshotsAction action = new RestGetSnapshotsAction();
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.cluster.dangling.RestImportDanglingIndexAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestDeleteDanglingIndexAction action = new RestDeleteDanglingIndexAction();
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestDeleteIndexAction action = new RestDeleteIndexAction();
import org.opensearch.rest.action.cat.RestTemplatesAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.cluster.RestClusterUpdateSettingsAction;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
                deprecationLogger,
            @Override
            OpenSearchParseException.class,
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
        request.params().put("block", "metadata");
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
    public void testCatSnapshots() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.cluster.RestDeleteRepositoryAction;
    }
            getMasterNodeRequest(),
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestDeleteComposableIndexTemplateAction action = new RestDeleteComposableIndexTemplateAction();
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.cat.RestClusterManagerAction;
    private FakeRestRequest getRestRequestWithDeprecatedParam() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        request.params().put("master_timeout", "3s");
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));
import org.opensearch.rest.action.admin.indices.RestCreateIndexAction;
    public void testGetIndices() {
    }
    }
    }
    }
    private FakeRestRequest getRestRequestWithBodyWithBothParams() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testSplitIndex() {
        );
        Exception e = assertThrows(
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testRestoreSnapshot() {
import org.opensearch.rest.action.admin.cluster.RestCloneSnapshotAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.cluster.RestCreateSnapshotAction;
    }
    }
import org.opensearch.rest.action.admin.indices.RestOpenIndexAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testGetMapping() {
import org.opensearch.rest.action.admin.indices.RestPutComposableIndexTemplateAction;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    public void testGetStoredScript() {
import org.junit.After;
            getMasterNodeRequest(),
    public void testGetComponentTemplate() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.indices.RestPutComponentTemplateAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.cluster.RestCleanupRepositoryAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testCatNodes() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.opensearch.rest.action.admin.cluster.RestGetSnapshotsAction;
        Exception e = assertThrows(
        request.params().put("index_uuid", "test");
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        Exception e = assertThrows(
    }
import org.opensearch.rest.action.admin.indices.RestGetComposableIndexTemplateAction;
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    public void testPutIndexTemplate() {
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    }
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
/*
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.cluster.RestRestoreSnapshotAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
    }
import org.opensearch.rest.action.admin.cluster.RestClusterGetSettingsAction;
    }
 * SPDX-License-Identifier: Apache-2.0
        RestSnapshotAction action = new RestSnapshotAction();
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.ingest.RestGetPipelineAction;
    public void testPutPipeline() {
            deprecationLogger,
 *
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.indices.RestGetSettingsAction;
        );
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        RestSegmentsAction action = new RestSegmentsAction(responseLimitSettings);
            public ActionRequestValidationException validate() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.cluster.RestPutStoredScriptAction;
        RestDeleteComponentTemplateAction action = new RestDeleteComponentTemplateAction();
        RestPendingClusterTasksAction action = new RestPendingClusterTasksAction();
    }
    }
        RestGetIndicesAction action = new RestGetIndicesAction();
 * this file be licensed under the Apache-2.0 license or a
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        FakeRestRequest request = new FakeRestRequest();
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    private final NodeClient client = new NodeClient(Settings.EMPTY, threadPool);
import org.opensearch.rest.action.admin.indices.RestDeleteComponentTemplateAction;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.OpenSearchParseException;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE, "empty templates should no longer be used");
    public void testGetSettings() {
        FakeRestRequest request = new FakeRestRequest();
import org.opensearch.rest.action.admin.cluster.RestPutRepositoryAction;
import static org.hamcrest.Matchers.containsString;
import org.opensearch.rest.action.cat.RestPendingClusterTasksAction;
        RestClusterManagerAction action = new RestClusterManagerAction();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        FakeRestRequest request = getFakeRestRequestWithBody();
    public void testIndicesAliases() {
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.indices.RestIndicesAliasesAction;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));
        RestCloseIndexAction action = new RestCloseIndexAction();
            getRestRequestWithDeprecatedParam(),
import org.opensearch.rest.action.admin.indices.RestIndexPutAliasAction;
    public void testGetPipeline() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
            OpenSearchParseException.class,
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestResizeHandler.RestCloneIndexAction action = new RestResizeHandler.RestCloneIndexAction();
        Exception e = assertThrows(
        FakeRestRequest request = new FakeRestRequest();
    public void testCatSegments() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        );
        RestGetPipelineAction action = new RestGetPipelineAction();
import org.opensearch.rest.BaseRestHandler;
                getMasterNodeRequest(),
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.cat.RestRepositoriesAction;
    }
        Exception e = assertThrows(
        RestPendingClusterTasksAction action = new RestPendingClusterTasksAction();
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.common.settings.Settings;
        request.params().put("cluster_manager_timeout", "1h");
    private static final String DUPLICATE_PARAMETER_ERROR_MESSAGE =
 * compatible open source license.
        request.params().put("cluster_manager_timeout", randomFrom("1h", "2m"));
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
            OpenSearchParseException.class,
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    }
    public void testSnapshotsStatus() {
    public void testAddIndexBlock() {
        return request;
        request.params().put("master_timeout", "3s");
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        request.params().put("master_timeout", "3s");
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.opensearch.rest.action.cat.RestNodeAttrsAction;
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
    public void testDeleteIndexTemplate() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        terminate(threadPool);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        RestSimulateTemplateAction action = new RestSimulateTemplateAction();
import org.opensearch.rest.action.admin.indices.RestGetIndicesAction;
import org.opensearch.test.rest.FakeRestRequest;
    }
        RestClusterStateAction action = new RestClusterStateAction(filter);
        request.params().put("cluster_manager_timeout", "1h");
        RestDeleteSnapshotAction action = new RestDeleteSnapshotAction();
            OpenSearchParseException.class,
    public void testSimulateTemplate() {
        FakeRestRequest request = new FakeRestRequest();
        final Settings settings = Settings.builder().build();
        RestCleanupRepositoryAction action = new RestCleanupRepositoryAction();
        };
        request.params().put("cluster_manager_timeout", "1h");
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
import org.opensearch.rest.action.admin.cluster.RestDeleteStoredScriptAction;
import org.opensearch.rest.action.admin.indices.RestCloseIndexAction;
        FakeRestRequest request = new FakeRestRequest();
        request.params().put("cluster_manager_timeout", "1h");
import org.opensearch.rest.action.admin.cluster.RestDeleteSnapshotAction;
    public void testPutStoredScript() {
        RestGetSettingsAction action = new RestGetSettingsAction();
    public void testCatTemplates() {
import org.opensearch.common.breaker.ResponseLimitSettings;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    public void testDeleteDanglingIndex() {
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testDeletePipeline() {
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.rest.action.admin.indices.RestSimulateTemplateAction;
        request.params().put("cluster_manager_timeout", "1h");
        RestSimulateIndexTemplateAction action = new RestSimulateIndexTemplateAction();
import org.opensearch.rest.action.admin.indices.RestAddIndexBlockAction;
import org.opensearch.rest.action.admin.cluster.RestVerifyRepositoryAction;
        Exception e = assertThrows(
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        );
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.opensearch.rest.action.admin.indices.RestGetMappingAction;
    }
                "test"
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.cat.RestSegmentsAction;
import org.opensearch.rest.action.admin.indices.RestSimulateIndexTemplateAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        BaseRestHandler.parseDeprecatedMasterTimeoutParameter(
    public void testDeleteStoredScript() {
            OpenSearchParseException.class,
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.indices.RestDeleteIndexAction;
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
        RestIndexPutAliasAction action = new RestIndexPutAliasAction();
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        RestTemplatesAction action = new RestTemplatesAction();
import org.opensearch.rest.action.admin.indices.RestRolloverIndexAction;
    public void terminateThreadPool() {
        request.params().put("master_timeout", "3s");
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
            OpenSearchParseException.class,
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
 */
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testCloseIndex() {
        return new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withContent(new BytesArray("{}"), MediaTypeRegistry.JSON).build();
    public void testGetIndexTemplate() {
    public void testNoWarningsForNewParam() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));
        request.params().put("cluster_manager_timeout", "2m");
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testPutComponentTemplate() {
    public void testImportDanglingIndex() {
import org.opensearch.rest.action.cat.RestSnapshotAction;
import org.opensearch.rest.action.admin.indices.RestGetComponentTemplateAction;
        final SettingsFilter filter = new SettingsFilter(Collections.singleton("foo.filtered"));
        RestPutStoredScriptAction action = new RestPutStoredScriptAction();
import org.opensearch.core.common.bytes.BytesArray;
        Exception e = assertThrows(
        RestResizeHandler.RestShrinkIndexAction action = new RestResizeHandler.RestShrinkIndexAction();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
            }
        RestCloneSnapshotAction action = new RestCloneSnapshotAction();
    public void testCreateIndex() {
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testDeleteIndex() {
    public void testCatShards() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.common.settings.SettingsFilter;
    }
        RestResizeHandler.RestSplitIndexAction action = new RestResizeHandler.RestSplitIndexAction();
 * and alternative parameter 'cluster_manager_timeout' is added.
import org.opensearch.rest.action.cat.RestThreadPoolAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.common.settings.ClusterSettings;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import org.opensearch.rest.action.admin.cluster.dangling.RestDeleteDanglingIndexAction;
    }
        final SettingsFilter filter = new SettingsFilter(Collections.singleton("foo.filtered"));
    public void testCatRepositories() {
        request.params().put("master_timeout", "3s");
    }
        RestRolloverIndexAction action = new RestRolloverIndexAction();
        FakeRestRequest request = new FakeRestRequest();
import org.opensearch.rest.action.admin.indices.RestPutMappingAction;
    public void testRolloverIndex() {
        );
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }
    }
        RestDeleteStoredScriptAction action = new RestDeleteStoredScriptAction();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
            OpenSearchParseException.class,
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
        return request;
    public void testPutMapping() {
        request.params().put("master_timeout", "3s");
        RestIndicesAliasesAction action = new RestIndicesAliasesAction();
import org.opensearch.rest.action.admin.cluster.RestClusterRerouteAction;
        request.params().put("id", "test");
        FakeRestRequest request = new FakeRestRequest();
import org.opensearch.rest.action.cat.RestAllocationAction;
        return new ClusterManagerNodeRequest() {
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
            () -> action.prepareRequest(getRestRequestWithBodyWithBothParams(), client)
    public void testCatClusterManager() {
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
import org.opensearch.rest.action.admin.indices.RestPutIndexTemplateAction;
 * Remove the test after removing MASTER_ROLE and 'master_timeout'.
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        FakeRestRequest request = new FakeRestRequest();
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testCatAllocation() {
    public void testClusterState() throws IOException {
        final SettingsFilter filter = new SettingsFilter(Collections.singleton("foo.filtered"));
            getRestRequestWithNewParam(),
        RestPutRepositoryAction action = new RestPutRepositoryAction();
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    }
    }
    }
    @After
    private FakeRestRequest getRestRequestWithNewParam() {
        BaseRestHandler.parseDeprecatedMasterTimeoutParameter(
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestNodeAttrsAction action = new RestNodeAttrsAction();
import org.opensearch.transport.client.node.NodeClient;
    public void testCatIndices() {
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        );
        RestPluginsAction action = new RestPluginsAction();
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(request, client));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_SETTING;
    }
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    private FakeRestRequest getFakeRestRequestWithBody() {
    public void testCatNodeattrs() {
    public void testBothParamsNotValid() {
    private static final String MASTER_TIMEOUT_DEPRECATED_MESSAGE =
    }
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    }
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    public void testGetComposableIndexTemplate() {
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }
        RestPutIndexTemplateAction action = new RestPutIndexTemplateAction();
import org.opensearch.rest.action.admin.indices.RestUpdateSettingsAction;
        request.params().put("name", "test");
    }
        RestClusterGetSettingsAction action = new RestClusterGetSettingsAction(null, null, filter);
    }
        "Parameter [master_timeout] is deprecated and will be removed in 3.0. To support inclusive language, please use [cluster_manager_timeout] instead.";
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
    public void testDeleteComponentTemplate() {
    public void testCreateSnapshot() {
            OpenSearchParseException.class,
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
import org.opensearch.rest.action.admin.indices.RestDeleteIndexTemplateAction;
    public void testDeleteRepository() {
        RestIndexDeleteAliasesAction action = new RestIndexDeleteAliasesAction();
import org.opensearch.rest.action.cat.RestShardsAction;
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    public void testVerifyRepository() {
    }
                return null;
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.prepareRequest(getRestRequestWithBothParams(), client));
    public void testCloneSnapshot() {
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        RestAllocationAction action = new RestAllocationAction();
            OpenSearchParseException.class,
        Exception e = assertThrows(OpenSearchParseException.class, () -> action.doCatRequest(getRestRequestWithBothParams(), client));
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
    }
        Exception e = assertThrows(
    }
        request.params().put("master_timeout", "3s");
    public void testDeleteSnapshot() {
import org.opensearch.test.OpenSearchTestCase;
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
        request.params().put("master_timeout", "3s");
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
    public void testCatThreadPool() {
    }
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
        );
        assertThat(e.getMessage(), containsString(DUPLICATE_PARAMETER_ERROR_MESSAGE));
            () -> RestClusterHealthAction.fromRequest(getRestRequestWithBodyWithBothParams())
        assertWarnings(MASTER_TIMEOUT_DEPRECATED_MESSAGE);
