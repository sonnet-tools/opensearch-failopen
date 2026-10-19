                            .startObject("properties")
import java.util.Arrays;
            .setWaitForCompletion(true)
                            .startObject("field1")
            assertAcked(clusterAdmin().prepareDeleteStoredScript("foobar").get());
                    .get()
                    .endArray()
        if (testTemplate) {
        if (testScript) {
        snapshotsStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo").addSnapshots("test-snap-with-global-state").get();
                        MediaTypeRegistry.JSON
        boolean testScript = (testTemplate == false && testPipeline == false) || randomBoolean(); // At least something should be stored
 * not use this file except in compliance with the License.
        cluster().wipeIndices("test-idx");
 */
 *
            .addSnapshots("test-snap-no-global-state")
 * specific language governing permissions and limitations
                            .field("store", true)
            .setIndices()
        if (testPipeline) {
import static org.hamcrest.Matchers.equalTo;
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(0));
            .execute()
            logger.info("-->  delete test pipeline");
        }
 * GitHub history for details.
                    )
import org.opensearch.action.ingest.DeletePipelineRequest;
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;
            logger.info("-->  delete test script");
            assertThat(
        if (testPipeline) {
                            .field("type", "text")
        }
        GetIndexTemplatesResponse getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
                            .endObject()
package org.opensearch.snapshots;
import org.opensearch.plugins.Plugin;
    public void testIncludeGlobalState() throws Exception {
        assertIndexTemplateMissing(getIndexTemplatesResponse, "test-template");
        logger.info("--> check that template wasn't restored");
            .execute()
                    .setContent(
            logger.info("--> check that script is restored");
            .actionGet();
import java.util.Collections;
        logger.info("-->  delete global state and index ");
        assertIndexTemplateMissing(getIndexTemplatesResponse, "test-template");
        createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-with-global-state")
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-no-global-state-with-index")
        if (testTemplate) {
        CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-no-global-state")
import org.opensearch.core.common.bytes.BytesReference;
/*
            .setWaitForCompletion(true)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateExists;
            logger.info("-->  delete test template");
                client().admin()
        }
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(0));
                    .setMapping(
            logger.info("--> check that pipeline is restored");
        assertDocCount("test-idx", 100L);
        SnapshotsStatusResponse snapshotsStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo")
                    .endObject()
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
                equalTo(true)
            .get();
                    .endObject()
 * KIND, either express or implied.  See the License for the
        SnapshotStatus snapshotStatus = snapshotsStatusResponse.getSnapshots().get(0);
            cluster().wipeTemplates("test-template");
            logger.info("-->  creating test pipeline");
                    .startObject("test")
}
            .setWaitForCompletion(true)
        assertThat(getSnapshot("test-repo", "test-snap-no-global-state-with-index").state(), equalTo(SnapshotState.SUCCESS));
            .actionGet();
 * license agreements. See the NOTICE file distributed with
        return Arrays.asList(IngestTestPlugin.class, StoredScriptsIT.CustomScriptPlugin.class);
        assertThat(snapshotsStatusResponse.getSnapshots().size(), equalTo(1));
 * under the License.
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-no-global-state-with-index")
            .setRestoreGlobalState(true)
                clusterAdmin().preparePutStoredScript()
 */
        }
        }
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
                jsonBuilder().startObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertAcked(clusterAdmin().prepareDeleteStoredScript("foobar").get());
import org.opensearch.action.ingest.GetPipelineResponse;
        getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
                    .endObject()
 * Unless required by applicable law or agreed to in writing,
/*
 * the Apache License, Version 2.0 (the "License"); you may
            );
                            .field("store", true)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            logger.info("-->  creating test script");
        assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), equalTo(0));
                    )
            cluster().wipeTemplates("test-template");
 * this work for additional information regarding copyright
            assertIndexTemplateExists(getIndexTemplatesResponse, "test-template");
            getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
            .setIncludeGlobalState(false)
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.xcontent.XContentFactory;
            logger.info("--> check that template is restored");
            );
import static org.hamcrest.Matchers.greaterThan;
 * SPDX-License-Identifier: Apache-2.0
            .get();
                    .startObject()
                    .setPatterns(Collections.singletonList("te*"))
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under
        assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), greaterThan(0));
                            .endObject()
                    .field("description", "my_pipeline")
            .setWaitForCompletion(true)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), equalTo(0));
            assertAcked(clusterAdmin().deletePipeline(new DeletePipelineRequest("barbaz")).get());
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        }
        if (testScript) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateMissing;
            logger.info("-->  creating test template");
                    .setId("foobar")
                            .endObject()
            assertNotNull(getStoredScriptResponse.getSource());
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
/*
                            .field("type", "keyword")
        if (testScript) {
            .execute()
            assertAcked(
 * Licensed to Elasticsearch under one or more contributor
        logger.info("--> try restoring cluster state from snapshot without global state");
                            .startObject("field2")
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
            GetIndexTemplatesResponse getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
        }
            .setRestoreGlobalState(true)
        boolean testTemplate = randomBoolean();
        logger.info("--> try restoring index and cluster state from snapshot without global state");
    }
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-no-global-state")
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), equalTo(0));
            .setIncludeGlobalState(false)
        boolean testPipeline = randomBoolean();
                    .isAcknowledged(),
        }
 * You may obtain a copy of the License at
            .get();
        if (testPipeline) {
 */
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-with-global-state")
        if (testTemplate) {
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), equalTo(0));
        logger.info("--> check that global state wasn't restored but index was");
import java.util.Collection;
        createIndexWithRandomDocs("test-idx", 100);
    @Override
import org.opensearch.script.StoredScriptsIT;
        snapshotStatus = snapshotsStatusResponse.getSnapshots().get(0);
        if (testTemplate) {
            GetPipelineResponse getPipelineResponse = clusterAdmin().prepareGetPipeline("barbaz").get();
        assertIndexTemplateMissing(getIndexTemplatesResponse, "test-template");
 *
        }
        assertThat(
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
                    .preparePutTemplate("test-template")
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
                        XContentFactory.jsonBuilder()
 *
            .setWaitForCompletion(true)
        assertThat(getSnapshot("test-repo", "test-snap-no-global-state").state(), equalTo(SnapshotState.SUCCESS));
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));
            GetStoredScriptResponse getStoredScriptResponse = clusterAdmin().prepareGetStoredScript("foobar").get();
 * compatible open source license.
            .setIndices("test-idx")
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import org.opensearch.ingest.IngestTestPlugin;
        assertFalse(clusterAdmin().prepareGetPipeline("barbaz").get().isFound());
            );
        }
                            .endObject()
        assertThat(snapshotStatus.includeGlobalState(), equalTo(true));
        getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
            .actionGet();
        logger.info("--> snapshot without global state but with indices");
        assertThat(snapshotStatus.includeGlobalState(), equalTo(false));
public class SnapshotCustomPluginStateIT extends AbstractSnapshotIntegTestCase {
        logger.info("--> snapshot with global state");
        logger.info("--> snapshot without global state");
import org.opensearch.core.common.bytes.BytesArray;
            assertIndexTemplateMissing(getIndexTemplatesResponse, "test-template");
        assertNull(clusterAdmin().prepareGetStoredScript("foobar").get().getSource());
            BytesReference pipelineSource = BytesReference.bytes(
        assertThat(getSnapshot("test-repo", "test-snap-with-global-state").state(), equalTo(SnapshotState.SUCCESS));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            assertTrue(getPipelineResponse.isFound());
        );
        logger.info("--> restore cluster state");
        if (testScript) {
        if (testPipeline) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .setWaitForCompletion(true)
        }
import org.opensearch.script.MockScriptEngine;
            .setIndices()
                            .startObject()
                    .startArray("processors")
                        new BytesArray("{\"script\": { \"lang\": \"" + MockScriptEngine.NAME + "\", \"source\": \"1\"} }"),
            .get();
            assertAcked(clusterAdmin().deletePipeline(new DeletePipelineRequest("barbaz")).get());
            .setRestoreGlobalState(true)
                    .indices()
        createRepository("test-repo", "fs");
            assertAcked(clusterAdmin().preparePutPipeline("barbaz", pipelineSource, MediaTypeRegistry.JSON).get());
            .setIncludeGlobalState(true)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(snapshotsStatusResponse.getSnapshots().size(), equalTo(1));
