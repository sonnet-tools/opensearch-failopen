        final BulkByScrollResponse response = highLevelClient().updateByQuery(updateByQueryRequest, RequestOptions.DEFAULT);
            assertThat(response.getTasks(), hasSize(1));
            assertEquals(0, bulkResponse.getSearchFailures().size());
import org.opensearch.index.reindex.UpdateByQueryRequest;
        final String sourceIndex = "testupdatebyquerytask";
            TaskId taskIdToRethrottle = findTaskToRethrottle(UpdateByQueryAction.NAME, updateByQueryRequest.getDescription());
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(response.getTasks().get(0).getStatus(), instanceOf(RawTaskStatus.class));
    }
            assertEquals(0, bulkResponse.getVersionConflicts());
            createIndex(sourceIndex, settings);
                    )
        assertThat(response.getVersionConflicts(), equalTo(1L));
                @Override
    }
            BulkByScrollResponse bulkResponse = execute(
            assertEquals(0, bulkResponse.getBulkFailures().size());
                public void onFailure(Exception e) {
        {
import org.opensearch.script.Script;
                highLevelClient()::updateByQuery,
        final String sourceIndex = "source1";
                    taskFinished.countDown();
                3,
            updateByQueryRequest.indices(sourceIndex);
        putConflictPipeline();
import org.opensearch.action.bulk.BulkRequest;
            assertTrue(taskFinished.await(10, TimeUnit.SECONDS));
import org.opensearch.core.rest.RestStatus;
        createIndex(index, settings);
                        new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", 1), MediaTypeRegistry.JSON)
            assertTrue(response.getTasks().isEmpty());
            assertEquals(1, bulkResponse.getBatches());
            });
                }
 * not use this file except in compliance with the License.
            );
        assertThat(response.getTotal(), equalTo(2L));
        {
            .add(new IndexRequest(index).id("2").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON))
        {
    public void testUpdateByQuery() throws Exception {
                highLevelClient()::updateByQueryRethrottleAsync
 * software distributed under the License is distributed on an
            final CountDownLatch taskFinished = new CountDownLatch(1);
            assertEquals(0, bulkResponse.getSearchFailures().size());
            assertEquals(2, bulkResponse.getTotal());
                    RequestOptions.DEFAULT
        assertThat(response.getBatches(), equalTo(1));
                highLevelClient().bulk(
            assertEquals(1, bulkResponse.getUpdated());
            // test update-by-query rethrottling
import org.opensearch.tasks.RawTaskStatus;
                RestStatus.OK,
            response = execute(
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.instanceOf;
            float requestsPerSecond = 1000f;
            updateByQueryRequest.indices(sourceIndex);
import org.opensearch.index.reindex.BulkByScrollResponse;
import org.opensearch.action.support.WriteRequest;
        }
            // Prepare
            updateByQueryRequest.setQuery(new IdsQueryBuilder().addIds("1"));
            assertEquals(1, bulkResponse.getBatches());
import static org.hamcrest.Matchers.hasSize;
                highLevelClient()::updateByQueryAsync
                new Script("if (ctx._source.foo == 2) ctx._source.foo++;"));
                new RethrottleRequest(taskIdToRethrottle, requestsPerSecond),
                (int) (highLevelClient().get(new GetRequest(sourceIndex, "2"), RequestOptions.DEFAULT).getSourceAsMap().get("foo"))
                ).status()
import org.opensearch.action.bulk.BulkItemResponse;
            updateByQueryRequest.setScript(
                updateByQueryRequest,
                highLevelClient()::updateByQueryAsync
        final String index = "testupdatebyqueryconflict";
            );
            assertEquals(0, bulkResponse.getBulkFailures().size());
            updateByQueryRequest.setRefresh(true);
        final BulkRequest bulkRequest = new BulkRequest().add(
            assertEquals(0, bulkResponse.getNoops());
import org.opensearch.common.settings.Settings;
 *
            assertFalse(response.getNodeFailures().isEmpty());
            // tag::submit-update_by_query-task
            // Prepare
                    RequestOptions.DEFAULT
            UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();
            assertEquals(
                highLevelClient()::updateByQueryRethrottleAsync
            assertEquals(0, bulkResponse.getNoops());
import java.util.stream.Collectors;
                highLevelClient().bulk(
            updateByQueryRequest.setRefresh(true);
            updateByQueryRequest.setQuery(new IdsQueryBuilder().addIds("1"));
                highLevelClient()::updateByQuery,
            // this following settings are supposed to halt reindexing after first document
import static org.hamcrest.Matchers.empty;
            assertEquals(1, bulkResponse.getBatches());
        }
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * ownership. Elasticsearch licenses this file to you under
                }
import org.opensearch.action.get.GetRequest;
            UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();
            assertEquals(0, bulkResponse.getVersionConflicts());
                        .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo", 2), MediaTypeRegistry.JSON))
            assertEquals(1, response.getNodeFailures().size());
        assertThat(response.getCreated(), equalTo(0L));
                ((RawTaskStatus) response.getTasks().get(0).getStatus()).toMap().get("requests_per_second").toString()
}
        assertThat(response.getUpdated(), equalTo(1L));
        {
public class UpdateByQueryIT extends OpenSearchRestHighLevelClientTestCase {
 *
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
        assertThat(highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT).status(), equalTo(RestStatus.OK));
        }
    public void testUpdateByQueryConflict() throws IOException {
import java.util.concurrent.CountDownLatch;
        );
            );
            ListTasksResponse response = execute(
 * The OpenSearch Contributors require contributions made to
                    fail(e.toString());
                highLevelClient()::updateByQueryRethrottle,
 * Modifications Copyright OpenSearch Contributors. See
            // any rethrottling after the update-by-query is done performed with the same taskId should result in a failure
            BulkByScrollResponse bulkResponse = execute(
                        .add(new IndexRequest(sourceIndex).id("3").source(Collections.singletonMap("foo", 3), MediaTypeRegistry.JSON))
            assertEquals(
                "OpenSearch exception [type=resource_not_found_exception, reason=task [" + taskIdToRethrottle + "] is missing]",
        }
                        new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", 1), MediaTypeRegistry.JSON)
            TaskSubmissionResponse updateByQuerySubmission = highLevelClient()
            new IndexRequest(index).id("1").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON)
        final UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();
            // end::submit-update_by_query-task
            );
    public void testUpdateByQueryTask() throws Exception {
import org.opensearch.core.action.ActionListener;
import org.opensearch.index.query.IdsQueryBuilder;
            );
            updateByQueryRequest.indices(sourceIndex);
        updateByQueryRequest.setRefresh(true);
    }
            updateByQueryRequest.setRefresh(true);
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.core.xcontent.MediaTypeRegistry;
        updateByQueryRequest.setPipeline(CONFLICT_PIPELINE_ID);
import java.util.concurrent.TimeUnit;
            response.getBulkFailures().stream().map(BulkItemResponse.Failure::getMessage).collect(Collectors.toSet()),
 * Licensed to Elasticsearch under one or more contributor
                highLevelClient()::updateByQueryRethrottle,
                    )
            everyItem(containsString("version conflict"))
        updateByQueryRequest.indices(index);
 * under the License.
                RestStatus.OK,
/*
 * You may obtain a copy of the License at
        assertThat(response.getSearchFailures(), empty());
        }
            assertEquals(
import org.opensearch.client.tasks.TaskSubmissionResponse;
            UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
package org.opensearch.client;
            assertEquals(1, bulkResponse.getBatches());
/*
 */
            assertEquals(taskIdToRethrottle, response.getTasks().get(0).getTaskId());
import org.opensearch.core.tasks.TaskId;
            assertEquals(0, bulkResponse.getDeleted());
            highLevelClient().updateByQueryAsync(updateByQueryRequest, RequestOptions.DEFAULT, new ActionListener<BulkByScrollResponse>() {
            assertEquals(
import static org.hamcrest.Matchers.everyItem;
                new RethrottleRequest(taskIdToRethrottle, requestsPerSecond),
        assertThat(
                        .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo", 2), MediaTypeRegistry.JSON))
            assertEquals(
import java.io.IOException;
        )
import static org.hamcrest.Matchers.equalTo;
                ).status()
            assertTrue(bulkResponse.getTook().getMillis() > 0);
            updateByQueryRequest.indices(sourceIndex);
 * license agreements. See the NOTICE file distributed with
        {
            assertBusy(checkTaskCompletionStatus(client(), taskId));
                updateByQueryRequest,
 * specific language governing permissions and limitations
        assertTrue(response.getTook().getMillis() > 0);
                Float.toString(requestsPerSecond),
                public void onResponse(BulkByScrollResponse response) {
                @Override
            // test1: create one doc in dest
            updateByQueryRequest.setRequestsPerSecond(0.00001f);
import org.opensearch.index.reindex.UpdateByQueryAction;
            createIndex(sourceIndex, settings);
            UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest();
                .submitUpdateByQueryTask(updateByQueryRequest, RequestOptions.DEFAULT);
                    new BulkRequest().add(
            updateByQueryRequest.setBatchSize(1);
            );
        assertThat(response.getNoops(), equalTo(0L));
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE),
 * KIND, either express or implied.  See the License for the
 *
        assertThat(response.getBulkFailures(), hasSize(1));
 */
 * GitHub history for details.
            );
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            );
            String taskId = updateByQuerySubmission.getTask();
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE),
import static org.hamcrest.Matchers.containsString;
/*
            updateByQueryRequest.setRefresh(true);
            assertEquals(1, bulkResponse.getTotal());
            assertTrue(bulkResponse.getTook().getMillis() > 0);
import org.opensearch.action.index.IndexRequest;
                    new BulkRequest().add(
        assertThat(response.getDeleted(), equalTo(0L));
        {
            // test2: update using script
            updateByQueryRequest.setScript(new Script("if (ctx._source.foo == 2) ctx._source.foo++;"));
 *     http://www.apache.org/licenses/LICENSE-2.0
                response.getNodeFailures().get(0).getCause().getMessage()
import java.util.Collections;
            assertEquals(2, bulkResponse.getUpdated());
 */
        final Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
        }
