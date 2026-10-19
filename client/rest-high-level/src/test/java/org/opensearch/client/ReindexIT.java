            createIndex(sourceIndex, settings);
                @Override
                        .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo", 2), MediaTypeRegistry.JSON))  
            // end::submit-reindex-task
            assertEquals(0, bulkResponse.getDeleted());  
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            createIndex(destinationIndex, settings);  
 */  
                    )
            BulkByScrollResponse bulkResponse = execute(reindexRequest, highLevelClient()::reindex, highLevelClient()::reindexAsync);
            deleteByQueryRequest.setQuery(new IdsQueryBuilder().addIds("2", "3"));
        putConflictPipeline();  
            // this following settings are supposed to halt reindexing after first document
import static org.hamcrest.Matchers.containsString;  
                highLevelClient().bulk(
                ).status()  
            assertEquals(1, bulkResponse.getTotal());
            );
                new RethrottleRequest(taskIdToRethrottle, requestsPerSecond),
    public void testReindexTask() throws Exception {
            deleteByQueryRequest.setQuery(new IdsQueryBuilder().addIds("1"));
import org.opensearch.action.support.WriteRequest;
import java.util.stream.Collectors;
            reindexRequest.setRefresh(true);  
import org.opensearch.index.reindex.ReindexRequest;  
                deleteByQueryRequest,
    public void testReindexConflict() throws IOException {
                response.getNodeFailures().get(0).getCause().getMessage()
            reindexRequest.setRefresh(true);  
        {  
    public void testReindex() throws IOException {  
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
        {  
            reindexRequest.setDestIndex(destinationIndex);
        assertThat(response.getSearchFailures(), empty());
            response.getBulkFailures().stream().map(BulkItemResponse.Failure::getMessage).collect(Collectors.toSet()),
        final String sourceIndex = "source456";
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();  
    }  
        }  
            ListTasksResponse response = execute(  
 * Licensed to Elasticsearch under one or more contributor  
                .submitReindexTask(reindexRequest, RequestOptions.DEFAULT); // <2>
}
            assertEquals(1, bulkResponse.getBatches());  
            assertEquals(0, bulkResponse.getNoops());
                highLevelClient().bulk(
            // end::submit-delete_by_query-task  
            assertEquals(1, bulkResponse.getCreated());
            BulkByScrollResponse bulkResponse = execute(  
            DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();  
        }
                new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON)  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);  
                Float.toString(requestsPerSecond),  
                2,  
        final String destinationIndex = "dest2";
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
            assertEquals(
            assertTrue(bulkResponse.getTook().getMillis() > 0);
                RestStatus.OK,
            );
                    new BulkRequest().add(
                    fail(e.toString());  
            ReindexRequest reindexRequest = new ReindexRequest();
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE),
 * license agreements. See the NOTICE file distributed with
    public void testDeleteByQuery() throws Exception {
import static org.hamcrest.Matchers.empty;
package org.opensearch.client;
            ReindexRequest reindexRequest = new ReindexRequest(); // <1>
            assertEquals(taskIdToRethrottle, response.getTasks().get(0).getTaskId());  
        final ReindexRequest reindexRequest = new ReindexRequest();
            // Prepare
            assertEquals(0, bulkResponse.getSearchFailures().size());
            String taskId = reindexSubmission.getTask(); // <3>  
                "OpenSearch exception [type=index_not_found_exception, reason=no such index [dest] and [require_alias] request flag is [true] and [dest] is not an alias]",
        {
 * software distributed under the License is distributed on an
            assertEquals(1, bulkResponse.getBatches());  
            assertEquals(1, response.getNodeFailures().size());
        assertThat(response.getTotal(), equalTo(2L));
import org.opensearch.core.rest.RestStatus;
 * this file be licensed under the Apache-2.0 license or a
            everyItem(containsString("version conflict"))
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(response.getUpdated(), equalTo(0L));
            DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();  
                exception.getMessage()  
            deleteByQueryRequest.setBatchSize(1);  
            // Prepare
                    RequestOptions.DEFAULT
        assertThat(  
            assertTrue(response.getTasks().isEmpty());
                }
    }  
            assertThat(response.getTasks().get(0).getStatus(), instanceOf(RawTaskStatus.class));
            new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON)  
            .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON))
    }
        final BulkRequest bulkRequest = new BulkRequest().add(
                .submitDeleteByQueryTask(deleteByQueryRequest, RequestOptions.DEFAULT);  
                execute(reindexRequest, highLevelClient()::reindex, highLevelClient()::reindexAsync);
        {
        assertThat(response.getNoops(), equalTo(0L));  
import org.opensearch.core.action.ActionListener;
            // any rethrottling after the delete-by-query is done performed with the same taskId should result in a failure
/*  
        final String destinationIndex = "dest";
import org.opensearch.action.search.SearchRequest;  
            });
        {
            );
            assertBusy(checkTaskCompletionStatus(client(), taskId));  
            // reindex one document with id 1 from source to destination
        final String sourceIndex = "source123";  
            TaskSubmissionResponse deleteByQuerySubmission = highLevelClient()
            BulkRequest bulkRequest = new BulkRequest().add(
            );
            assertEquals(0, bulkResponse.getBulkFailures().size());  
        final String sourceIndex = "source1";
import static org.hamcrest.Matchers.hasSize;
            assertEquals(1, bulkResponse.getBatches());
            reindexRequest.setDestIndex(destinationIndex);
        final Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
        final String destIndex = "testreindexconflict_dest";  
import org.opensearch.action.bulk.BulkItemResponse;  
            // tag::submit-reindex-task  
            assertEquals(
                RestStatus.OK,  
import java.util.concurrent.CountDownLatch;
        createIndex(sourceIndex, settings);  
        reindexRequest.setSourceIndices(sourceIndex);  
        assertThat(response.getBulkFailures(), hasSize(2));
            float requestsPerSecond = 1000f;
                highLevelClient()::deleteByQueryRethrottle,
                new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", "bar"), MediaTypeRegistry.JSON)
 * GitHub history for details.
                }
            // test delete-by-query rethrottling
        reindexRequest.setRefresh(true);
            deleteByQueryRequest.setRefresh(true);  
        final String sourceIndex = "testreindexconflict_source";
 */  
        reindexRequest.setDestPipeline(CONFLICT_PIPELINE_ID);  
/*
 * not use this file except in compliance with the License.
                        .add(new IndexRequest(sourceIndex).id("3").source(Collections.singletonMap("foo", 3), MediaTypeRegistry.JSON))
            assertEquals(1, bulkResponse.getDeleted());  
            assertEquals(  
import org.opensearch.core.tasks.TaskId;  
            TaskId taskIdToRethrottle = findTaskToRethrottle(DeleteByQueryAction.NAME, deleteByQueryRequest.getDescription());
            deleteByQueryRequest.setRequestsPerSecond(0.00001f);
            reindexRequest.setSourceIndices(sourceIndex);
            });
                    RequestOptions.DEFAULT  
                highLevelClient().search(new SearchRequest(sourceIndex), RequestOptions.DEFAULT).getHits().getTotalHits().value()
            deleteByQueryRequest.setRefresh(true);
 *  
            assertEquals(0, bulkResponse.getVersionConflicts());
            assertEquals(
import java.util.concurrent.TimeUnit;  
        final String sourceIndex = "source1";  
                public void onResponse(BulkByScrollResponse response) {  
                new RethrottleRequest(taskIdToRethrottle, requestsPerSecond),
        }
            assertEquals(0, bulkResponse.getNoops());
            assertTrue(bulkResponse.getTook().getMillis() > 0);
        reindexRequest.setDestIndex(destIndex);
/*  
import org.opensearch.index.reindex.DeleteByQueryAction;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            assertThat(response.getTasks(), hasSize(1));
 * under the License.  
                        new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", 1), MediaTypeRegistry.JSON)
public class ReindexIT extends OpenSearchRestHighLevelClientTestCase {
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.query.IdsQueryBuilder;
        assertThat(response.getBatches(), equalTo(1));
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {  
            response = execute(  
        {
                highLevelClient()::deleteByQueryRethrottleAsync  
            assertFalse(response.getNodeFailures().isEmpty());  
            );
                        .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo", 2), MediaTypeRegistry.JSON))
            reindexRequest.setSourceIndices(sourceIndex);  
        );  
        assertThat(highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT).status(), equalTo(RestStatus.OK));
                    new BulkRequest().add(  
            ReindexRequest reindexRequest = new ReindexRequest();
        }
            assertTrue(taskFinished.await(10, TimeUnit.SECONDS));  
import org.opensearch.tasks.RawTaskStatus;
        }  
                highLevelClient()::deleteByQueryRethrottle,
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(response.getDeleted(), equalTo(0L));
import java.io.IOException;  
                    taskFinished.countDown();
    }
                    )
        assertThat(response.getVersionConflicts(), equalTo(2L));  
            )
import org.opensearch.OpenSearchStatusException;
                .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo2", "bar2"), MediaTypeRegistry.JSON))
                ).status()
            // Prepare  
 * The OpenSearch Contributors require contributions made to  
            reindexRequest.setSourceIndices(sourceIndex);  
                ((RawTaskStatus) response.getTasks().get(0).getStatus()).toMap().get("requests_per_second").toString()
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals(
            assertBusy(checkTaskCompletionStatus(client(), taskId));
 * You may obtain a copy of the License at  
        createIndex(destIndex, settings);
import org.opensearch.common.settings.Settings;  
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);  
import org.opensearch.action.bulk.BulkRequest;
            createIndex(sourceIndex, settings);  
            // tag::submit-delete_by_query-task
            final CountDownLatch taskFinished = new CountDownLatch(1);
import org.opensearch.client.tasks.TaskSubmissionResponse;
import java.util.Collections;
                        .add(new IndexRequest(sourceIndex).id("3").source(Collections.singletonMap("foo", 3), MediaTypeRegistry.JSON))  
                "OpenSearch exception [type=resource_not_found_exception, reason=task [" + taskIdToRethrottle + "] is missing]",  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.reindex.BulkByScrollResponse;  
            DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();
                @Override
                .add(new IndexRequest(sourceIndex).id("2").source(Collections.singletonMap("foo2", "bar2"), MediaTypeRegistry.JSON))
            );
        {  
            );
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            String taskId = deleteByQuerySubmission.getTask();
            assertEquals(0, bulkResponse.getSearchFailures().size());
            // set require_alias=true, but there exists no alias
 * this work for additional information regarding copyright
            reindexRequest.setDestIndex(destinationIndex);  
                highLevelClient()::deleteByQueryRethrottleAsync  
            assertEquals(1, bulkResponse.getBatches());
            createIndex(destinationIndex, settings);
            );
                        new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("foo", 1), MediaTypeRegistry.JSON)  
            assertEquals(RestStatus.OK, highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT).status());  
            // Prepare  
 * specific language governing permissions and limitations
            TaskSubmissionResponse reindexSubmission = highLevelClient()  
            highLevelClient().deleteByQueryAsync(deleteByQueryRequest, RequestOptions.DEFAULT, new ActionListener<BulkByScrollResponse>() {  
        }
            // test1: delete one doc
        final BulkByScrollResponse response = highLevelClient().reindex(reindexRequest, RequestOptions.DEFAULT);
            assertEquals(0, bulkResponse.getBulkFailures().size());  
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            deleteByQueryRequest.indices(sourceIndex);  
            assertEquals(0, bulkResponse.getVersionConflicts());
                highLevelClient()::deleteByQuery,
import org.opensearch.index.reindex.DeleteByQueryRequest;
        }
            reindexRequest.setRequireAlias(true);
        }  
        assertThat(response.getCreated(), equalTo(0L));  
        {
            reindexRequest.setRefresh(true);
            createIndex(sourceIndex, settings);
                highLevelClient()::deleteByQueryAsync  
            assertEquals(
            reindexRequest.setSourceQuery(new IdsQueryBuilder().addIds("1"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.equalTo;
        }
            createIndex(sourceIndex, settings);
            reindexRequest.setSourceQuery(new IdsQueryBuilder().addIds("1"));
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE),
 *
            assertEquals(1, bulkResponse.getTotal());
import org.opensearch.action.index.IndexRequest;
            )  
        {  
            assertEquals(RestStatus.OK, highLevelClient().bulk(bulkRequest, RequestOptions.DEFAULT).status());
        {
            assertEquals(RestStatus.NOT_FOUND, exception.status());  
import static org.hamcrest.Matchers.instanceOf;
            );
        }  
                public void onFailure(Exception e) {
        assertTrue(response.getTook().getMillis() > 0);
            BulkRequest bulkRequest = new BulkRequest().add(
        )
            deleteByQueryRequest.setRefresh(true);  
 * SPDX-License-Identifier: Apache-2.0
            deleteByQueryRequest.indices(sourceIndex);
import static org.hamcrest.Matchers.everyItem;  
            deleteByQueryRequest.indices(sourceIndex);
    }
    public void testDeleteByQueryTask() throws Exception {  
 */
            deleteByQueryRequest.setQuery(new IdsQueryBuilder().addIds("1"));
