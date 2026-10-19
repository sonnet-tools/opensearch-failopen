                    logger.info("--> index id={} seq_no={}", response.getId(), response.getSeqNo());
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
import org.opensearch.action.update.UpdateRequest;
 * Unless required by applicable law or agreed to in writing,
        bulkBuilder.get();
        bulkResponse = client().prepareBulk().add(client().prepareDelete("alias1", "id")).get();
    }
        } catch (Exception e) {
 * not use this file except in compliance with the License.
 *
import org.opensearch.ingest.IngestTestPlugin;
                    assertThat(response.getResult(), is(oneOf(CREATED, UPDATED)));  
                }
 * software distributed under the License is distributed on an
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.action.ActionRequestValidationException;  
            .indices()
     * This tests that the {@link TransportBulkAction} evaluates alias routing values correctly when dealing with
        if (randomBoolean()) {
        client().admin()  
import java.util.concurrent.atomic.AtomicInteger;
 * Licensed to Elasticsearch under one or more contributor  
    }
        }
            .endObject();  
        }  
        indexRequestWithAlias.source(Collections.singletonMap("foo", "baz"));
/*  
            .indices()
                        .setId(id)  
import org.opensearch.action.support.replication.ReplicationRequest;
                String id = Integer.toString(docID.incrementAndGet());  
            .addAlias(new Alias("alias1").indexRouting("0").writeIndex(randomFrom(false, null)))  
        {
        // all requests in the json are missing index and type parameters: "_index" : "test", "_type" : "type1",
import java.util.concurrent.atomic.AtomicBoolean;
    }
            .get();
        assertThat(
        assertBusy(() -> {  
import static org.opensearch.action.DocWriteResponse.Result.UPDATED;
    @Override
            .get();
        client().admin()  
        // Invalid id should throw the ActionRequestValidationException  
import org.opensearch.OpenSearchException;
            fail("Request validation for docId failed with different exception: " + e);
            .endObject()  
        assertTrue(acknowledgedResponse.isAcknowledged());
            createSamplePipeline("pipeline");
            indexRequestWithAlias.routing("1");  
    }
import org.opensearch.core.common.bytes.BytesReference;
        stopped.set(true);
 * Modifications Copyright OpenSearch Contributors. See
        assertFalse(client().prepareBulk().add(indexRequest.id(validId)).get().hasFailures());
            assertThat(ex.validationErrors(), containsInAnyOrder("index is missing", "index is missing", "index is missing"));  
            );  
        assertBusy(() -> assertThat(docID.get(), greaterThanOrEqualTo(1)));  
import org.opensearch.cluster.metadata.IndexMetadata;  
            .indices()
 * license agreements. See the NOTICE file distributed with
    public void testBulkWithGlobalDefaults() throws Exception {
package org.opensearch.action.bulk;
        assertThat(client().prepareGet("index3", "id").setRouting("1").get().getSource().get("foo"), equalTo("updated"));  
            BulkRequestBuilder bulkBuilder = client().prepareBulk();
            .addAlias(new Alias("alias1").indexRouting("0"))  
        BulkResponse bulkResponse = client().prepareBulk().add(indexRequestWithAlias).get();  
            fail("Request validation for docId didn't fail");
 */
        return Arrays.asList(IngestTestPlugin.class);
        bulkResponse = client().prepareBulk().add(client().prepareUpdate("alias1", "id").setDoc("foo", "updated")).get();
import org.opensearch.action.ingest.PutPipelineRequest;
import org.opensearch.core.xcontent.XContentBuilder;
        validateDocIdLimit(() -> client().prepareBulk().add(updateRequest.id(invalidId)).get());
 * SPDX-License-Identifier: Apache-2.0
        IndexRequest indexRequest = new IndexRequest("index1").source(Collections.singletonMap("foo", "baz"));
        // Valid id shouldn't throw any exception  
            .endArray()
        assertThat(bulkResponse.getItems()[0].getResponse().getShardId().getId(), equalTo(0));
        assertAcked(client().admin().indices().prepareDelete(index));
 */  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        });  
            .startArray("processors")  
            }
        createIndex(index);  
        );
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
 * ownership. Elasticsearch licenses this file to you under  
                e.validationErrors().stream().filter(msg -> msg.contains("is too long, must be no longer than 512 bytes but was")).count()
        }
            assertTrue(mappingsResponse.getMappings().containsKey("logstash-2014.03.30"));
        } catch (ActionRequestValidationException e) {
 *
            assertEquals(  
            indexRequest.id("test");
            BulkResponse bulkItemResponses = bulkBuilder.get();
            .prepareCreate("index3")
import java.io.IOException;  
import java.util.Map;
        if (randomBoolean()) {
    }
        assertFalse(thread.isAlive());
            .get();
public class BulkIntegrationIT extends OpenSearchIntegTestCase {
            .endObject()
import org.opensearch.action.index.IndexRequest;  
        String validId = String.join("", Collections.nCopies(512, "a"));
        bulkBuilder.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
    public void testDeleteIndexWhileIndexing() throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 * under the License.  
 * You may obtain a copy of the License at  
            GetMappingsResponse mappingsResponse = client().admin().indices().prepareGetMappings().get();
                    logger.info("--> fail to index id={}", id);  
                } catch (OpenSearchException ignore) {
                        .setSource(Collections.singletonMap("f" + randomIntBetween(1, 10), randomNonNegativeLong()), MediaTypeRegistry.JSON)
        assertFalse(bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
            .putPipeline(new PutPipelineRequest(pipelineId, BytesReference.bytes(pipeline), MediaTypeRegistry.JSON))
            .cluster()  
    }
import java.util.concurrent.ExecutionException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        AtomicBoolean stopped = new AtomicBoolean();
    /** This test ensures that index deletion makes indexing fail quickly, not wait on the index that has disappeared */
import static org.hamcrest.Matchers.containsInAnyOrder;  
        String invalidId = String.join("", Collections.nCopies(513, "a"));
import java.nio.charset.StandardCharsets;
                1,
        // Index Request
import static org.opensearch.action.DocWriteResponse.Result.CREATED;
            ActionRequestValidationException ex = expectThrows(ActionRequestValidationException.class, bulkBuilder::get);
                    IndexResponse response = client().prepareIndex(index)
            .addAlias(new Alias("alias1").indexRouting("1").writeIndex(true))  
    public void testBulkWithWriteIndexAndRouting() {
import org.opensearch.core.rest.RestStatus;
}
        assertFalse(client().prepareBulk().add(updateRequest).get().hasFailures());
            assertFalse(bulkItemResponses.hasFailures());  
            .get();
    // allowing the auto-generated timestamp to externally be set would allow making the index inconsistent with duplicate docs  
        assertFalse(client().prepareGet("index3", "id").setRouting("1").get().isExists());  
    }
            containsString("autoGeneratedTimestamp should not be set externally")  
import static org.hamcrest.Matchers.containsString;
import org.opensearch.Version;
        try {
    public void testBulkIndexCreatesMapping() throws Exception {
            .startObject()
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
        BulkRequestBuilder bulkBuilder = client().prepareBulk();  
import static org.hamcrest.Matchers.equalTo;
     * an alias pointing to multiple indices, while a write index exits.
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(1L));  
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(bulkResponse.getItems()[0].getResponse().status(), equalTo(RestStatus.CREATED));
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/bulk-log.json");
    }
    private void createSamplePipeline(String pipelineId) throws IOException, ExecutionException, InterruptedException {
import java.util.Collections;
 * the Apache License, Version 2.0 (the "License"); you may
        Thread thread = new Thread(() -> {
        assertFalse(bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        IndexRequest indexRequest = new IndexRequest(index).source(Collections.singletonMap("foo", "baz"));
            .prepareCreate("index2")
        });  
        AcknowledgedResponse acknowledgedResponse = client().admin()
        String bulkAction = copyToStringFromClasspath("/org/opensearch/action/bulk/simple-bulk-missing-index-type.json");  
import org.opensearch.action.admin.indices.alias.Alias;
        IndexRequest indexRequestWithAlias = new IndexRequest("alias1").id("id");
import org.opensearch.plugins.Plugin;  
    private void validateDocIdLimit(Runnable runner) {
import org.opensearch.action.index.IndexResponse;
        }
            while (stopped.get() == false && docID.get() < 5000) {
            .setSettings(twoShardsSettings)
 *  
 * this file be licensed under the Apache-2.0 license or a
        indexRequest.process(Version.CURRENT, null, null); // sets the timestamp  
        String index = "testing";
                        .get();
        assertThat(bulkResponse.getItems()[0].getResponse().getIndex(), equalTo("index3"));
            .startObject("test")
     */  
 * compatible open source license.
        assertThat(client().prepareGet("index3", "id").setRouting("1").get().getSource().get("foo"), equalTo("baz"));
        thread.join(ReplicationRequest.DEFAULT_TIMEOUT.millis() / 2);  
        client().admin()  
 * this work for additional information regarding copyright
 * GitHub history for details.
        UpdateRequest updateRequest = new UpdateRequest(index, validId).doc("reason", "no source");  
            bulkBuilder.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);
        createIndex(index);
            BulkRequestBuilder bulkBuilder = client().prepareBulk("test").routing("routing").pipeline("pipeline");
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
 */  
/*  
        }  
        ensureGreen(index);
        AtomicInteger docID = new AtomicInteger();  
            runner.run();  
        String index = "deleted_while_indexing";  
import java.util.Collection;  
    public void testExternallySetAutoGeneratedTimestamp() {
        {  
        Map<String, Integer> twoShardsSettings = Collections.singletonMap(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2);
            .setSettings(twoShardsSettings)
        XContentBuilder pipeline = jsonBuilder().startObject()
    /**  
        validateDocIdLimit(() -> client().prepareBulk().add(indexRequest.id(invalidId)).get());  
import java.util.Arrays;
    public void testDocIdTooLong() {
        // Invalid id should throw the ActionRequestValidationException
                try {
            expectThrows(IllegalArgumentException.class, () -> client().prepareBulk().add(indexRequest).get()).getMessage(),
        // Update Request
            bulkBuilder.add(bulkAction.getBytes(StandardCharsets.UTF_8), 0, bulkAction.length(), null, MediaTypeRegistry.JSON);  
        // Valid id shouldn't throw any exception
        thread.start();
            .prepareCreate("index1")
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
    }
import static org.hamcrest.Matchers.is;
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.oneOf;
/*
            .setSettings(twoShardsSettings)
