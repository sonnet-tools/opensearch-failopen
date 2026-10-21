        }
            assertTrue(bulkResponse.getTook().getMillis() > 0);
            assertEquals(
        }
 * ownership. Elasticsearch licenses this file to you under
            BulkByScrollResponse bulkResponse = execute(reindexRequest, highLevelClient()::reindex, highLevelClient()::reindexAsync);
        }
                execute(reindexRequest, highLevelClient()::reindex, highLevelClient()::reindexAsync);
import static org.hamcrest.Matchers.instanceOf;
            deleteByQueryRequest.setRefresh(true);
            reindexRequest.setSourceIndices(sourceIndex);
            assertEquals(taskIdToRethrottle, response.getTasks().get(0).getTaskId());
import org.opensearch.index.reindex.BulkByScrollResponse;
            assertEquals(1, bulkResponse.getBatches());
                Float.toString(requestsPerSecond),
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            highLevelClient().deleteByQueryAsync(deleteByQueryRequest, RequestOptions.DEFAULT, new ActionListener<BulkByScrollResponse>() {
import org.opensearch.common.settings.Settings;
            // end::submit-delete_by_query-task
            // end::submit-reindex-task
            );
            // Prepare
            assertEquals(1, bulkResponse.getBatches());
            // any rethrottling after the delete-by-query is done performed with the same taskId should result in a failure
                new RethrottleRequest(taskIdToRethrottle, requestsPerSecond),
    public void testReindexTask() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        final Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            assertEquals(
package org.opensearch.client;
            // test delete-by-query rethrottling
            response.getBulkFailures().stream().map(BulkItemResponse.Failure::getMessage).collect(Collectors.toSet()),
import static org.hamcrest.Matchers.equalTo;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.OpenSearchStatusException;
        reindexRequest.setDestIndex(destIndex);
 * compatible open source license.
        putConflictPipeline();
        assertThat(response.getDeleted(), equalTo(0L));
import org.opensearch.index.reindex.ReindexRequest;
                2,
import org.opensearch.tasks.RawTaskStatus;
            assertEquals(0, bulkResponse.getBulkFailures().size());
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(1, bulkResponse.getDeleted());
                new RethrottleRequest(taskIdToRethrottle, requestsPerSecond),
        {
        reindexRequest.setDestPipeline(CONFLICT_PIPELINE_ID);
            createIndex(sourceIndex, settings);
        final String sourceIndex = "source456";
        }
            });
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        assertThat(response.getCreated(), equalTo(0L));
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
import org.opensearch.client.tasks.TaskSubmissionResponse;
/*
        {
        final String destinationIndex = "dest2";
            ReindexRequest reindexRequest = new ReindexRequest(); // <1>
    }
            assertEquals(RestStatus.OK, highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT).status());
        assertThat(response.getUpdated(), equalTo(0L));
        final String sourceIndex = "source1";
        }
        final String sourceIndex = "source123";
                        .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo", 2), MediaTypeRegistry.JSON))
            deleteByQueryRequest.setQuery(new IdsQueryBuilder().addIds("1"));
 *
            // Prepare
                highLevelClient()::deleteByQuery,
                    )
            createIndex(sourceIndex, settings);
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            createIndex(destinationIndex, settings);
 *
    public void testReindexConflict() throws IOException {
            );
            response = execute(
                        new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", 1), MediaTypeRegistry.JSON)
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
 *    http://www.apache.org/licenses/LICENSE-2.0
            // tag::submit-delete_by_query-task
                @Override
            deleteByQueryRequest.indices(sourceIndex);
            reindexRequest.setSourceIndices(sourceIndex);
            deleteByQueryRequest.indices(sourceIndex);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        final BulkByScrollResponse response = highLevelClient().reindex(reindexRequest, RequestOptions.DEFAULT);
        )
public class ReindexIT extends OpenSearchRestHighLevelClientTestCase {
                highLevelClient()::deleteByQueryAsync
        );
            assertEquals(0, bulkResponse.getBulkFailures().size());
            deleteByQueryRequest.setQuery(new IdsQueryBuilder().addIds("1"));
            assertEquals(1, bulkResponse.getBatches());
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
 * GitHub history for details.
            everyItem(containsString("version conflict"))
 */
            DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();
            assertThat(response.getTasks().get(0).getStatus(), instanceOf(RawTaskStatus.class));
            assertEquals(1, bulkResponse.getCreated());
            );
            );
                }
            );
            DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();
                deleteByQueryRequest,
        }
            // this following settings are supposed to halt reindexing after first document
        {
            // Prepare
            assertFalse(response.getNodeFailures().isEmpty());
/*
        {
        {
            )
                    )
            assertEquals(1, response.getNodeFailures().size());
            assertThat(response.getTasks(), hasSize(1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                ((RawTaskStatus) response.getTasks().get(0).getStatus()).toMap().get("requests_per_second").toString()
 * Modifications Copyright OpenSearch Contributors. See
            assertTrue(response.getTasks().isEmpty());
                    RequestOptions.DEFAULT
            reindexRequest.setRefresh(true);
            reindexRequest.setSourceQuery(new IdsQueryBuilder().addIds("1"));
        reindexRequest.setSourceIndices(sourceIndex);
            );
    public void testDeleteByQueryTask() throws Exception {
            assertEquals(1, bulkResponse.getBatches());
            float requestsPerSecond = 1000f;
            );
            deleteByQueryRequest.setRefresh(true);
 * Unless required by applicable law or agreed to in writing,
        {
import org.opensearch.action.index.IndexRequest;
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
            DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();
        assertThat(highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT).status(), equalTo(RestStatus.OK));
                @Override
 * You may obtain a copy of the License at
    public void testDeleteByQuery() throws Exception {
                exception.getMessage()
            ListTasksResponse response = execute(
                highLevelClient()::deleteByQueryRethrottle,
            assertEquals(0, bulkResponse.getDeleted());
                .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo2", "bar2"), MediaTypeRegistry.JSON))
                new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON)
                        new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", 1), MediaTypeRegistry.JSON)
            deleteByQueryRequest.setBatchSize(1);
import java.util.Collections;
 * KIND, either express or implied.  See the License for the
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
 * The OpenSearch Contributors require contributions made to
        {
                        .add(new IndexRequest(sourceIndex).id("3").source(Collections.singletonMap("foo", 3), MediaTypeRegistry.JSON))
 *
                .submitDeleteByQueryTask(deleteByQueryRequest, RequestOptions.DEFAULT);
            assertBusy(checkTaskCompletionStatus(client(), taskId));
                }
    }
            assertEquals(RestStatus.OK, highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT).status());
            String taskId = deleteByQuerySubmission.getTask();
import org.opensearch.index.reindex.DeleteByQueryRequest;
                    new BulkRequest().add(
            assertEquals(0, bulkResponse.getNoops());
            deleteByQueryRequest.setRefresh(true);
            )
        final String sourceIndex = "testreindexconflict_source";
                        .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo", 2), MediaTypeRegistry.JSON))
    }
/*
            reindexRequest.setRequireAlias(true);
                    taskFinished.countDown();
        assertTrue(response.getTook().getMillis() > 0);
import java.util.concurrent.CountDownLatch;
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor
                highLevelClient()::deleteByQueryRethrottle,
}
        createIndex(destIndex, settings);
        }
            new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON)
import org.opensearch.action.bulk.BulkItemResponse;
            final CountDownLatch taskFinished = new CountDownLatch(1);
                    RequestOptions.DEFAULT
            reindexRequest.setRefresh(true);
        assertThat(response.getBulkFailures(), hasSize(2));
 * under the License.
                public void onFailure(Exception e) {
                    new BulkRequest().add(
 * not use this file except in compliance with the License.
                .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo2", "bar2"), MediaTypeRegistry.JSON))
            BulkRequest bulkRequest = new BulkRequest().add(
            assertEquals(
            assertEquals(1, bulkResponse.getTotal());
            assertEquals(1, bulkResponse.getTotal());
            BulkRequest bulkRequest = new BulkRequest().add(
            assertEquals(0, bulkResponse.getNoops());
            createIndex(destinationIndex, settings);
            ReindexRequest reindexRequest = new ReindexRequest();
                response.getNodeFailures().get(0).getCause().getMessage()
            reindexRequest.setSourceQuery(new IdsQueryBuilder().addIds("1"));
            deleteByQueryRequest.indices(sourceIndex);
            // Prepare
            reindexRequest.setDestIndex(destinationIndex);
 */
                new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON)
import org.opensearch.core.action.ActionListener;
            .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON))
        }
            assertEquals(0, bulkResponse.getSearchFailures().size());
import java.io.IOException;
        final BulkRequest bulkRequest = new BulkRequest().add(
import static org.hamcrest.Matchers.hasSize;
 */
            createIndex(sourceIndex, settings);
import org.opensearch.action.search.SearchRequest;
        assertThat(response.getVersionConflicts(), equalTo(2L));
 * software distributed under the License is distributed on an
            assertEquals(
import org.opensearch.action.support.WriteRequest;
            BulkByScrollResponse bulkResponse = execute(
import static org.hamcrest.Matchers.containsString;
        final String destIndex = "testreindexconflict_dest";
                highLevelClient()::deleteByQueryRethrottleAsync
import org.opensearch.index.reindex.DeleteByQueryAction;
            assertTrue(bulkResponse.getTook().getMillis() > 0);
                highLevelClient().bulk(
            deleteByQueryRequest.setQuery(new IdsQueryBuilder().addIds("2", "3"));
    }
        {
import org.opensearch.index.query.IdsQueryBuilder;
            // set require_alias=true, but there exists no alias
            assertEquals(0, bulkResponse.getVersionConflicts());
            String taskId = reindexSubmission.getTask(); // <3>
            reindexRequest.setDestIndex(destinationIndex);
        {
            assertBusy(checkTaskCompletionStatus(client(), taskId));
                highLevelClient().search(new SearchRequest(sourceIndex), RequestOptions.DEFAULT).getHits().getTotalHits().value()
                    fail(e.toString());
                RestStatus.OK,
            ReindexRequest reindexRequest = new ReindexRequest();
import java.util.stream.Collectors;
        assertThat(
                ).status()
                .submitReindexTask(reindexRequest, RequestOptions.DEFAULT); // <2>
            assertEquals(0, bulkResponse.getSearchFailures().size());
            );
        assertThat(response.getTotal(), equalTo(2L));
            assertEquals(
            reindexRequest.setRefresh(true);
                ).status()
        }
            );
            assertTrue(taskFinished.await(10, TimeUnit.SECONDS));
        assertThat(response.getBatches(), equalTo(1));
        reindexRequest.setRefresh(true);
                        .add(new IndexRequest(sourceIndex).id("3").source(Collections.singletonMap("foo", 3), MediaTypeRegistry.JSON))
        assertThat(response.getSearchFailures(), empty());
            assertEquals(
import org.opensearch.action.bulk.BulkRequest;
        {
            createIndex(sourceIndex, settings);
    public void testReindex() throws IOException {
            TaskSubmissionResponse deleteByQuerySubmission = highLevelClient()
    }
import java.util.concurrent.TimeUnit;
            assertEquals(RestStatus.NOT_FOUND, exception.status());
import static org.hamcrest.Matchers.everyItem;
import org.opensearch.core.rest.RestStatus;
        }
        final String sourceIndex = "source1";
                "OpenSearch exception [type=index_not_found_exception, reason=no such index [dest] and [require_alias] request flag is [true] and [dest] is not an alias]",
 * specific language governing permissions and limitations
            assertEquals(0, bulkResponse.getVersionConflicts());
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE),
            // tag::submit-reindex-task
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE),
                "OpenSearch exception [type=resource_not_found_exception, reason=task [" + taskIdToRethrottle + "] is missing]",
            reindexRequest.setDestIndex(destinationIndex);
            TaskSubmissionResponse reindexSubmission = highLevelClient()
        final ReindexRequest reindexRequest = new ReindexRequest();
            deleteByQueryRequest.setRequestsPerSecond(0.00001f);
        createIndex(sourceIndex, settings);
        assertThat(response.getNoops(), equalTo(0L));
import org.opensearch.core.tasks.TaskId;
            reindexRequest.setSourceIndices(sourceIndex);
 * this file be licensed under the Apache-2.0 license or a
                highLevelClient().bulk(
        final String destinationIndex = "dest";
            // test1: delete one doc
                RestStatus.OK,
import static org.hamcrest.Matchers.empty;
                public void onResponse(BulkByScrollResponse response) {
            // reindex one document with id 1 from source to destination
                highLevelClient()::deleteByQueryRethrottleAsync
            });
            TaskId taskIdToRethrottle = findTaskToRethrottle(DeleteByQueryAction.NAME, deleteByQueryRequest.getDescription());
