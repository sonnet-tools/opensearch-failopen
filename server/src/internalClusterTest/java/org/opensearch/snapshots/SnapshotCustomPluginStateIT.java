            );
                    .field("description", "my_pipeline")  
        assertIndexTemplateMissing(getIndexTemplatesResponse, "test-template");  
            .setRestoreGlobalState(true)
            .actionGet();
import org.opensearch.ingest.IngestTestPlugin;
                            .startObject("field2")
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
            logger.info("-->  creating test script");
                jsonBuilder().startObject()
    }
        if (testTemplate) {  
 *
            GetStoredScriptResponse getStoredScriptResponse = clusterAdmin().prepareGetStoredScript("foobar").get();  
            .setRestoreGlobalState(true)
 * under the License.  
 * license agreements. See the NOTICE file distributed with
            .setWaitForCompletion(true)
        assertFalse(clusterAdmin().prepareGetPipeline("barbaz").get().isFound());
        if (testTemplate) {  
            .setWaitForCompletion(true)
                        new BytesArray("{\"script\": { \"lang\": \"" + MockScriptEngine.NAME + "\", \"source\": \"1\"} }"),  
        assertThat(getSnapshot("test-repo", "test-snap-no-global-state").state(), equalTo(SnapshotState.SUCCESS));
            assertAcked(clusterAdmin().prepareDeleteStoredScript("foobar").get());
                    .indices()
                            .startObject("properties")
                clusterAdmin().preparePutStoredScript()  
                    .isAcknowledged(),  
        }  
                    .endObject()
                    .setId("foobar")
            .execute()  
        );
import org.opensearch.action.ingest.GetPipelineResponse;
            assertIndexTemplateMissing(getIndexTemplatesResponse, "test-template");
            assertTrue(getPipelineResponse.isFound());
import java.util.Collections;
        return Arrays.asList(IngestTestPlugin.class, StoredScriptsIT.CustomScriptPlugin.class);  
 * You may obtain a copy of the License at  
        if (testTemplate) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (testScript) {  
        }
        RestoreSnapshotResponse restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-no-global-state")  
        if (testScript) {  
            cluster().wipeTemplates("test-template");
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), equalTo(0));
        assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), equalTo(0));  
            .setRestoreGlobalState(true)
        SnapshotStatus snapshotStatus = snapshotsStatusResponse.getSnapshots().get(0);
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotStatus;  
                    .setMapping(
import static org.hamcrest.Matchers.greaterThan;  
        }
    }
import org.opensearch.core.common.bytes.BytesArray;
        assertThat(snapshotsStatusResponse.getSnapshots().size(), equalTo(1));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import java.util.Arrays;  
                    )
            logger.info("--> check that script is restored");
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
            logger.info("-->  delete test template");
            .addSnapshots("test-snap-no-global-state")
                    .setContent(
public class SnapshotCustomPluginStateIT extends AbstractSnapshotIntegTestCase {
            assertAcked(clusterAdmin().deletePipeline(new DeletePipelineRequest("barbaz")).get());  
            .setWaitForCompletion(true)
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), greaterThan(0));
import org.opensearch.action.ingest.DeletePipelineRequest;
                    .endObject()
        assertDocCount("test-idx", 100L);
        boolean testTemplate = randomBoolean();  
                    .preparePutTemplate("test-template")  
                    .startObject("test")  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            BytesReference pipelineSource = BytesReference.bytes(
        getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
        assertThat(getSnapshot("test-repo", "test-snap-no-global-state-with-index").state(), equalTo(SnapshotState.SUCCESS));
                            .field("store", true)
        createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-with-global-state")
 * SPDX-License-Identifier: Apache-2.0
        assertNull(clusterAdmin().prepareGetStoredScript("foobar").get().getSource());  
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), equalTo(0));
                    .setPatterns(Collections.singletonList("te*"))
 * this file be licensed under the Apache-2.0 license or a
        if (testPipeline) {
/*  
                            .startObject("field1")  
        }  
        if (testPipeline) {
        }  
        SnapshotsStatusResponse snapshotsStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo")  
        logger.info("-->  delete global state and index ");
            assertNotNull(getStoredScriptResponse.getSource());
                    .startObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateMissing;
import org.opensearch.script.StoredScriptsIT;
 * ownership. Elasticsearch licenses this file to you under  
        logger.info("--> restore cluster state");
            .setIncludeGlobalState(true)
import static org.hamcrest.Matchers.equalTo;
            logger.info("--> check that pipeline is restored");
            .setIndices()
            assertThat(  
                            .field("type", "keyword")
        if (testPipeline) {  
import org.opensearch.common.xcontent.XContentFactory;  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        logger.info("--> check that template wasn't restored");
            .setIncludeGlobalState(false)  
 * GitHub history for details.
/*  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        logger.info("--> try restoring index and cluster state from snapshot without global state");
        }
            .setWaitForCompletion(true)
            );
            assertAcked(
 * Modifications Copyright OpenSearch Contributors. See
            .execute()  
        logger.info("--> try restoring cluster state from snapshot without global state");
            logger.info("-->  creating test template");
 */  
            GetIndexTemplatesResponse getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();  
        snapshotStatus = snapshotsStatusResponse.getSnapshots().get(0);  
 */
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(0));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        GetIndexTemplatesResponse getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();
                            .endObject()
 *  
                            .field("type", "text")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();  
        boolean testScript = (testTemplate == false && testPipeline == false) || randomBoolean(); // At least something should be stored
        assertThat(getSnapshot("test-repo", "test-snap-with-global-state").state(), equalTo(SnapshotState.SUCCESS));  
                    .get()
        assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), greaterThan(0));  
        logger.info("--> snapshot without global state");  
                    .startArray("processors")
import java.util.Collection;
        assertThat(snapshotsStatusResponse.getSnapshots().size(), equalTo(1));  
        logger.info("--> snapshot without global state but with indices");  
            GetPipelineResponse getPipelineResponse = clusterAdmin().prepareGetPipeline("barbaz").get();  
            .get();
        if (testTemplate) {
            .get();
        cluster().wipeIndices("test-idx");
                equalTo(true)
        }
import org.opensearch.plugins.Plugin;
        CreateSnapshotResponse createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-no-global-state")
            logger.info("-->  creating test pipeline");  
    @Override
                    .endObject()
        boolean testPipeline = randomBoolean();
 */  
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;  
                    )
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            .setIncludeGlobalState(false)  
import org.opensearch.core.common.bytes.BytesReference;
        }
        if (testScript) {
 * not use this file except in compliance with the License.
        createSnapshotResponse = clusterAdmin().prepareCreateSnapshot("test-repo", "test-snap-no-global-state-with-index")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(restoreSnapshotResponse.getRestoreInfo().failedShards(), equalTo(0));  
                        MediaTypeRegistry.JSON
}  
        if (testPipeline) {
            .setIndices()  
                            .startObject()
        }
        logger.info("--> snapshot with global state");
        logger.info("--> check that global state wasn't restored but index was");
            .setWaitForCompletion(true)
        }
        }
import org.opensearch.script.MockScriptEngine;  
        assertThat(snapshotStatus.includeGlobalState(), equalTo(true));
 * KIND, either express or implied.  See the License for the
            assertIndexTemplateExists(getIndexTemplatesResponse, "test-template");
        assertIndexTemplateMissing(getIndexTemplatesResponse, "test-template");  
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-with-global-state")  
package org.opensearch.snapshots;
        createRepository("test-repo", "fs");
            .execute()  
        snapshotsStatusResponse = clusterAdmin().prepareSnapshotStatus("test-repo").addSnapshots("test-snap-with-global-state").get();
            assertAcked(clusterAdmin().deletePipeline(new DeletePipelineRequest("barbaz")).get());
                        XContentFactory.jsonBuilder()  
            logger.info("-->  delete test pipeline");
 * specific language governing permissions and limitations
            .actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertIndexTemplateExists;  
                            .endObject()  
                            .field("store", true)  
            cluster().wipeTemplates("test-template");
        getIndexTemplatesResponse = client().admin().indices().prepareGetTemplates().get();  
        assertThat(restoreSnapshotResponse.getRestoreInfo().totalShards(), equalTo(0));
        assertIndexTemplateMissing(getIndexTemplatesResponse, "test-template");
        assertThat(
            logger.info("--> check that template is restored");
                client().admin()
        }
        assertThat(snapshotStatus.includeGlobalState(), equalTo(false));
 *
            assertAcked(clusterAdmin().prepareDeleteStoredScript("foobar").get());
                            .endObject()  
 * this work for additional information regarding copyright
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
        restoreSnapshotResponse = clusterAdmin().prepareRestoreSnapshot("test-repo", "test-snap-no-global-state-with-index")  
            assertAcked(clusterAdmin().preparePutPipeline("barbaz", pipelineSource, MediaTypeRegistry.JSON).get());  
        if (testScript) {
            logger.info("-->  delete test script");
            .setWaitForCompletion(true)
            );  
            .get();  
            .setIndices("test-idx")
                            .endObject()
        createIndexWithRandomDocs("test-idx", 100);
            .actionGet();
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
            .get();
import org.opensearch.action.admin.cluster.snapshots.status.SnapshotsStatusResponse;
        assertThat(createSnapshotResponse.getSnapshotInfo().totalShards(), equalTo(0));
                    .endArray()  
    public void testIncludeGlobalState() throws Exception {  
