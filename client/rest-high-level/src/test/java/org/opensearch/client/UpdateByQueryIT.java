            assertEquals(0, bulkResponse.getVersionConflicts());
        )
            BulkByScrollResponse bulkResponse = execute(
 */  
                    )
            updateByQueryRequest.setRefresh(true);  
 * license agreements. See the NOTICE file distributed with
            createIndex(sourceIndex, settings);
                highLevelClient().bulk(
        {
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            assertEquals(1, bulkResponse.getBatches());
            assertEquals(0, bulkResponse.getBulkFailures().size());
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
import org.opensearch.index.reindex.BulkByScrollResponse;
            assertEquals(0, bulkResponse.getDeleted());  
/*
            assertTrue(taskFinished.await(10, TimeUnit.SECONDS));  
 * KIND, either express or implied.  See the License for the
            });
            TaskSubmissionResponse updateByQuerySubmission = highLevelClient()  
import org.opensearch.index.reindex.UpdateByQueryAction;  
            // end::submit-update_by_query-task
                    RequestOptions.DEFAULT
import org.opensearch.client.tasks.TaskSubmissionResponse;
        }  
            // test1: create one doc in dest  
 * this work for additional information regarding copyright
                        .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo", 2), MediaTypeRegistry.JSON))  
            final CountDownLatch taskFinished = new CountDownLatch(1);
            assertEquals(
 * SPDX-License-Identifier: Apache-2.0
            updateByQueryRequest.setRefresh(true);
            highLevelClient().updateByQueryAsync(updateByQueryRequest, RequestOptions.DEFAULT, new ActionListener<BulkByScrollResponse>() {  
            updateByQueryRequest.setRefresh(true);
                    taskFinished.countDown();
            assertEquals(2, bulkResponse.getUpdated());
import java.util.concurrent.TimeUnit;
                    RequestOptions.DEFAULT  
            updateByQueryRequest.indices(sourceIndex);
 * not use this file except in compliance with the License.
        );  
                        .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo", 2), MediaTypeRegistry.JSON))
        }
        assertThat(response.getBatches(), equalTo(1));
 * the Apache License, Version 2.0 (the "License"); you may
                highLevelClient()::updateByQuery,
            createIndex(sourceIndex, settings);
import org.opensearch.action.index.IndexRequest;
    public void testUpdateByQuery() throws Exception {
            assertEquals(0, bulkResponse.getBulkFailures().size());  
            updateByQueryRequest.indices(sourceIndex);
        assertThat(response.getSearchFailures(), empty());
                @Override
import org.opensearch.action.bulk.BulkRequest;  
        final String index = "testupdatebyqueryconflict";
import org.opensearch.tasks.RawTaskStatus;  
                (int) (highLevelClient().get(new GetRequest(sourceIndex, "2"), RequestOptions.DEFAULT).getSourceAsMap().get("foo"))
import org.opensearch.core.action.ActionListener;  
            ListTasksResponse response = execute(  
import java.util.stream.Collectors;  
                        new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", 1), MediaTypeRegistry.JSON)  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.action.bulk.BulkItemResponse;
        final BulkRequest bulkRequest = new BulkRequest().add(  
            // Prepare  
            response.getBulkFailures().stream().map(BulkItemResponse.Failure::getMessage).collect(Collectors.toSet()),
            // tag::submit-update_by_query-task
        final String sourceIndex = "testupdatebyquerytask";
 */  
            float requestsPerSecond = 1000f;
            UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();
            );  
        updateByQueryRequest.setRefresh(true);
        {
}
            );
import static org.hamcrest.Matchers.instanceOf;
        final UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();  
import static org.hamcrest.Matchers.containsString;
            assertTrue(response.getTasks().isEmpty());
            updateByQueryRequest.indices(sourceIndex);
            assertEquals(1, bulkResponse.getBatches());
            BulkByScrollResponse bulkResponse = execute(
            updateByQueryRequest.setQuery(new IdsQueryBuilder().addIds("1"));  
        createIndex(index, settings);
            assertEquals(
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE),
        assertThat(response.getTotal(), equalTo(2L));
 * You may obtain a copy of the License at  
            updateByQueryRequest.setScript(
                new Script("if (ctx._source.foo == 2) ctx._source.foo++;"));  
        updateByQueryRequest.setPipeline(CONFLICT_PIPELINE_ID);  
            assertThat(response.getTasks(), hasSize(1));
        assertThat(response.getVersionConflicts(), equalTo(1L));  
        }
            // test update-by-query rethrottling
            assertEquals(0, bulkResponse.getSearchFailures().size());
import java.util.concurrent.CountDownLatch;
            assertEquals(  
            );  
public class UpdateByQueryIT extends OpenSearchRestHighLevelClientTestCase {  
            updateByQueryRequest.setBatchSize(1);  
        assertThat(response.getCreated(), equalTo(0L));  
            UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();  
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE),  
            // this following settings are supposed to halt reindexing after first document
 *
                    new BulkRequest().add(  
                highLevelClient()::updateByQueryAsync
            );
import static org.hamcrest.Matchers.empty;  
                ).status()
                .submitUpdateByQueryTask(updateByQueryRequest, RequestOptions.DEFAULT);
                3,  
import org.opensearch.core.rest.RestStatus;
            UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();
                    )
            response = execute(  
 * GitHub history for details.
            assertEquals(1, bulkResponse.getBatches());
import org.opensearch.common.settings.Settings;
import org.opensearch.script.Script;
            assertEquals(
            updateByQueryRequest.setRefresh(true);
        assertThat(  
        final String sourceIndex = "source1";  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            assertEquals(taskIdToRethrottle, response.getTasks().get(0).getTaskId());  
            assertEquals(0, bulkResponse.getNoops());
            );  
                highLevelClient()::updateByQueryRethrottleAsync  
 *
import org.opensearch.action.get.GetRequest;
            assertFalse(response.getNodeFailures().isEmpty());  
                @Override
        assertThat(response.getBulkFailures(), hasSize(1));
        {
    }
        putConflictPipeline();
        {
        assertThat(response.getNoops(), equalTo(0L));  
    public void testUpdateByQueryTask() throws Exception {  
            assertTrue(bulkResponse.getTook().getMillis() > 0);
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;  
                response.getNodeFailures().get(0).getCause().getMessage()
                ).status()
        {
            new IndexRequest(index).id("1").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON)
            assertEquals(0, bulkResponse.getNoops());  
                Float.toString(requestsPerSecond),  
package org.opensearch.client;
            String taskId = updateByQuerySubmission.getTask();  
import static org.hamcrest.Matchers.everyItem;
            // any rethrottling after the update-by-query is done performed with the same taskId should result in a failure
                }
                highLevelClient()::updateByQueryRethrottleAsync  
import java.io.IOException;
                ((RawTaskStatus) response.getTasks().get(0).getStatus()).toMap().get("requests_per_second").toString()
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    public void testUpdateByQueryConflict() throws IOException {
 * compatible open source license.
            updateByQueryRequest.setQuery(new IdsQueryBuilder().addIds("1"));
            assertBusy(checkTaskCompletionStatus(client(), taskId));  
/*  
                new RethrottleRequest(taskIdToRethrottle, requestsPerSecond),
 * this file be licensed under the Apache-2.0 license or a
        }  
                highLevelClient()::updateByQueryRethrottle,
                highLevelClient()::updateByQuery,
        }  
    }
                    fail(e.toString());  
                    new BulkRequest().add(
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.WriteRequest;  
                        new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", 1), MediaTypeRegistry.JSON)
                RestStatus.OK,
                highLevelClient().bulk(
            assertEquals(2, bulkResponse.getTotal());
            // test2: update using script  
            assertEquals(0, bulkResponse.getVersionConflicts());
import static org.hamcrest.Matchers.hasSize;  
        updateByQueryRequest.indices(index);
/*  
 */
            );
            assertTrue(bulkResponse.getTook().getMillis() > 0);  
            updateByQueryRequest.indices(sourceIndex);
            .add(new IndexRequest(index).id("2").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON))  
            assertEquals(1, bulkResponse.getUpdated());
            assertEquals(1, bulkResponse.getTotal());
                highLevelClient()::updateByQueryAsync
            assertThat(response.getTasks().get(0).getStatus(), instanceOf(RawTaskStatus.class));
                updateByQueryRequest,  
            assertEquals(1, bulkResponse.getBatches());  
            );
                        .add(new IndexRequest(sourceIndex).id("3").source(Collections.singletonMap("foo", 3), MediaTypeRegistry.JSON))
                new RethrottleRequest(taskIdToRethrottle, requestsPerSecond),
            assertEquals(0, bulkResponse.getSearchFailures().size());  
        assertThat(response.getDeleted(), equalTo(0L));
                RestStatus.OK,  
            everyItem(containsString("version conflict"))
            UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();  
            TaskId taskIdToRethrottle = findTaskToRethrottle(UpdateByQueryAction.NAME, updateByQueryRequest.getDescription());
            );
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(response.getTook().getMillis() > 0);
        {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.tasks.TaskId;
            // Prepare
            updateByQueryRequest.setScript(new Script("if (ctx._source.foo == 2) ctx._source.foo++;"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                highLevelClient()::updateByQueryRethrottle,
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT).status(), equalTo(RestStatus.OK));
                "OpenSearch exception [type=resource_not_found_exception, reason=task [" + taskIdToRethrottle + "] is missing]",  
            updateByQueryRequest.setRequestsPerSecond(0.00001f);
 * software distributed under the License is distributed on an
 * under the License.  
 *  
                public void onResponse(BulkByScrollResponse response) {  
        assertThat(response.getUpdated(), equalTo(1L));
            assertEquals(
    }  
        final Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
        final BulkByScrollResponse response = highLevelClient().updateByQuery(updateByQueryRequest, RequestOptions.DEFAULT);
            );
import org.opensearch.index.reindex.UpdateByQueryRequest;
import org.opensearch.index.query.IdsQueryBuilder;
        }
                updateByQueryRequest,  
                public void onFailure(Exception e) {
                }
            assertEquals(1, response.getNodeFailures().size());
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();  
