                if (exception.status() == RestStatus.CONFLICT) {  
                builder.field("user", "foobar");  
        {  
            // tag::get-source-execute-listener
            TermVectorsRequest tvrequest2 =  
        source.put("bar", "val2");
            listener = new LatchedActionListener<>(listener, latch);
            boolean timedOut = bulkResponse.isTimedOut(); // <2>
                    new FetchSourceContext(true, includes, excludes);
                // <2>  
import org.opensearch.client.RequestOptions;  
            request.setRouting("routing"); // <9>
            // tag::update-request-timeout
                    .constantBackoff(TimeValue.timeValueSeconds(1L), 3)); // <5>  
            builder.setBulkSize(new ByteSizeValue(1L, ByteSizeUnit.MB)); // <2>
                .field("type", "keyword")
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
            // tag::bulk-request
            new MultiTermVectorsRequest(ids, tvrequestTemplate); // <2>  
            // end::bulk-processor-listener  
            } else if (updateResponse.getResult() == DocWriteResponse.Result.NOOP) {
            // tag::update-by-query-request-slices  
                    .startObject()
            BulkProcessor.Listener listener = new BulkProcessor.Listener() { // <1>  
            //tag::get-request-source-include  
                public void onFailure(Exception e) {  
            // tag::rethrottle-request
            assertEquals(2, sourceAsMap.size());
import static org.hamcrest.Matchers.arrayWithSize;  
    @SuppressWarnings("unused")
            //end::index-request-xcontent
        {  
            assertThat(item.getResponse().getSource(), not(hasKey("foo")));
        CreateIndexRequest authorsRequest = new CreateIndexRequest("authors").mapping(
            UpdateRequest request = new UpdateRequest("posts", "1")
            //tag::get-request-preference
            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {  
import org.opensearch.action.support.WriteRequest;
        assertEquals("example_id", item.getId());
                        long totalTermFreq = term.getTotalTermFreq(); // <9>
            final CountDownLatch latch = new CountDownLatch(1);  
                            "In which order are my OpenSearch queries executed?");
        {
        }
        listener = new ActionListener<MultiTermVectorsResponse>() {
                        client.bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
            };
            long bulkRetries = bulkResponse.getBulkRetries(); // <9>
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL); // <1>
                            tv.getTerms(); // <5>  
            IndexRequest request = new IndexRequest("posts")
            }  
            request.fetchSourceContext(fetchSourceContext); // <1>
        }
            GetSourceResponse response =
            // end::term-vectors-request-optional-arguments  
            assertSame(0, bulkResponse.getSearchFailures().size());
import static org.hamcrest.Matchers.hasKey;  
        {
            @Override
                                int endOffset = token.getEndOffset(); // <14>
        {
        }  
            } else {  
            // end::update-conflict  
                @Override  
            String message = getResponse.getField("message").getValue(); // <2>  
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            if (shardInfo.getFailed() > 0) {  
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
                .routing("some_routing"));          // <1>
            } catch(OpenSearchException e) {
            IndexRequest indexRequest = new IndexRequest("posts").id("1")  
        // Replace the empty listener by a blocking listener in test
    @SuppressWarnings("unused")  
            assertThat(item.getResponse().getSource(), hasEntry("baz", "val3"));  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            if (getResponse.isExists()) {
            request.setQuery(new TermQueryBuilder("user", "foobar")); // <1>
        {
            BulkRequest request = new BulkRequest();
            long totalDocs = bulkResponse.getTotal(); // <3>
                }
            // end::term-vectors-request-artificial
        listener = new LatchedActionListener<>(listener, latch);  
 * not use this file except in compliance with the License.
    public void testDelete() throws Exception {  
                        client.bulkAsync(request, RequestOptions.DEFAULT, bulkListener),  
            // tag::bulk-request-routing
import java.util.concurrent.TimeUnit;  
            }
 * Licensed to Elasticsearch under one or more contributor  
            assertNull(firstItem.getFailure());              // <1>  
                    String reason = failure.reason(); // <2>  
            TimeValue throttledMillis = bulkResponse.getStatus().getThrottled(); // <12>
            // end::delete-by-query-request-conflicts
            MultiGetResponse response = client.mget(request, RequestOptions.DEFAULT);
            List<ScrollableHitSource.SearchFailure> searchFailures =
            long version = updateResponse.getVersion();
        if (tvresponseList != null) {
            String mapping = "  \"properties\": {\n"  
            // end::update-by-query-request-conflicts
                    client.updateByQuery(request, RequestOptions.DEFAULT);  
                + "    },\n"
            // end::multi-get-request-no-source
            OpenSearchException ee = (OpenSearchException) e;  // <3>
                }
            request.setFieldStatistics(false); // <1>
                .source("field", "value")  
        {  
            IndexRequest indexRequest = new IndexRequest("posts").id("1").source("field", "value");
            // tag::multi-get-request-stored
            ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
                        if (term.getTokens() != null) {
            Map<String, Object> parameters = singletonMap("count", 4); // <1>
            // tag::update-by-query-request-scroll  
            request.indices("source1");
            request.setRefresh(true); // <1>
                            for (TermVectorsResponse.TermVector.Token token : tokens) {
            // tag::reindex-request-conflicts
            //tag::update-docnotfound  
            request.routing("routingId"); // <1>  
                + "    },\n"  
        {  
            if (bulkResponse.hasFailures()) { // <1>
                    request, RequestOptions.DEFAULT);  
                    .source(MediaTypeRegistry.JSON,"field", "bar"));  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            String[] includes = new String[]{"updated", "r*"};  
            } catch (OpenSearchException exception) {
                    // <2>
                    + "            }\n"
            //end::get-request-routing
/*
            // end::index-request-pipeline  
            // end::delete-by-query-request-scroll
                .startObject()
            // tag::delete-by-query-response
                    bulkResponse.getBulkFailures(); // <15>
            // end::multi-get-execute-async
            // assertEquals(RestStatus.CONFLICT, ee.status());          // <4>
            Exception e = missingIndexItem.getFailure().getFailure();  // <2>
            GetSourceRequest request = new GetSourceRequest("posts", "1");
            listener = new LatchedActionListener<>(listener, latch);
            // end::update-by-query-request-script
import org.opensearch.client.RethrottleRequest;  
                public void onResponse(BulkResponse bulkResponse) {
            // end::update-by-query-execute-listener
                    // <2>
                // <1>
            FetchSourceContext fetchSourceContext =  
            // end::update-execute-listener  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
        {  
            request.refresh(true);                  // <3>  
            //end::get-request-version-type
            } catch (OpenSearchException exception) {
                    logger.debug("Executing bulk [{}] with {} requests",  
                + "    }\n"
            // tag::update-by-query-request
                if (bulkItemResponse.isFailed()) { // <1>
        {
        {
            }
                // <1>
                    new DeleteRequest("posts", "1").setIfSeqNo(100).setIfPrimaryTerm(2),  
                }
                }
            client.updateByQueryRethrottle(request, RequestOptions.DEFAULT); // <2>
                    client.deleteByQuery(request, RequestOptions.DEFAULT);  
                }
    }
            }
            // tag::update-execute-async  
                .storedFields("foo"));  // <1>  
            request.detectNoop(false); // <1>  
                @Override
            // tag::reindex-request-maxDocs
                }
            XContentBuilder docBuilder = XContentFactory.jsonBuilder();
                }  
            // Replace the empty listener by a blocking listener in test  
            // end::multi-get-execute-listener
                    bulkResponse.getStatus().getThrottledUntil(); // <11>
        // end::multi-term-vectors-request-template
    public void testBulk() throws Exception {
    public void testExists() throws Exception {
            // assertEquals(RestStatus.NOT_FOUND, ee.status());        // <4>
    }  
import org.opensearch.action.DocWriteRequest;  
            GetRequest request = new GetRequest("does_not_exist", "1");
            Map<String, Object> jsonMap = new HashMap<>();  
    }  
            Response response = client().performRequest(createIndex);
            // tag::delete-request
            assertEquals(3, updateResponse.getGetResult().sourceAsMap().size());
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
    @SuppressWarnings("unused")  
        {
        {  
                    "posts", // <1>  
        }  
                        request, RequestOptions.DEFAULT);  
 * the Apache License, Version 2.0 (the "License"); you may
            // end::delete-request-refresh  
            // end::reindex-request-refresh  
                + "    \"field1\": {\n"
                .startObject("user")
            ActionListener<BulkByScrollResponse> listener;  
        // tag::multi-term-vectors-execute-listener  
            // end::bulk-request  
            };
                public void onResponse(UpdateResponse updateResponse) {  
                        BulkResponse response) {
        getSourceRequest.realtime(false); // <1>
            request.setPositions(false); // <3>  
        }
            UpdateResponse updateResponse = client.update(
        }
                }
            }
            request.add(new MultiGetRequest.Item("missing_index", "id"));  
        );  
                    new FetchSourceContext(true, includes, excludes);
/*  
        // end::get-source-request
                @Override
                + "      \"type\": \"integer\"\n"
            request.upsert(jsonString, MediaTypeRegistry.JSON);  // <1>
                    "1");   // <2>
                byte[] sourceAsBytes = result.source(); // <4>  
            request.timeout(TimeValue.timeValueSeconds(1)); // <1>
                public void onResponse(IndexResponse indexResponse) {  
                "{\n"  
            "posts", // <1>  
                }
                if (e.status() == RestStatus.CONFLICT) {
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
                            List<TermVectorsResponse.TermVector.Token> tokens =
            public void onResponse(TermVectorsResponse termVectorsResponse) {  
            ActionListener<DeleteResponse> listener;  
            request.setIfSeqNo(2L); // <1>
    public void testUpdate() throws Exception {  
            // tag::update-execute-listener  
        RestHighLevelClient client = highLevelClient();  
        //tag::get-source-request-optional  
            request.add(tvrequest1); // <2>
    }  
                + "      \"type\": \"integer\"\n"
        listener = new LatchedActionListener<>(listener, latch);
            bulkProcessor.add(two);
        {
            // end::update-request-cas
            ); // <1>
                int docCount = tv.getFieldStatistics().getDocCount(); // <2>  
            assertSame(0, bulkResponse.getSearchFailures().size());  
                String fieldname = tv.getFieldName(); // <1>
        }  
            long version = deleteResponse.getVersion();
        {  
                    + "        }\n"
                }
                .source("field", "value")
            assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
            // tag::update-response
            Response response = client().performRequest(request);  
            // tag::delete-by-query-request-refresh  
            client.mtermvectors(request, RequestOptions.DEFAULT);
            // tag::bulk-processor-options
                    // <1>
            request.add(new IndexRequest("posts").id("1")  // <2>  
            RequestOptions.DEFAULT
                .endObject()
        CreateIndexResponse authorsResponse = client.indices().create(authorsRequest, RequestOptions.DEFAULT);  
                    "posts", // <1>
            String value = item.getResponse().getField("foo").getValue(); // <2>  
                    public void onFailure(Exception e) {
        getRequest.storedFields("_none_");                            // <4>  
            // end::delete-request-version-type  
                public void onResponse(GetResponse getResponse) {  
            // end::reindex-execute
                .opType(DocWriteRequest.OpType.CREATE);
                .setIfPrimaryTerm(20);
                    // <4>  
                @Override  
            docBuilder.startObject().field("user", "guest-user").endObject();
        };
            // tag::index-request-op-type  
        {  
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            GetResult result = updateResponse.getGetResult(); // <1>
            listener = new LatchedActionListener<>(listener, latch);  
                builder.field("reason", "daily update");  
            builder.setConcurrentRequests(0); // <3>  
            request.routing("routing"); // <1>  
            // end::update-by-query-request-refresh
            IndexRequest indexRequest = new IndexRequest("posts").id("1")
            request.add(new IndexRequest("posts").id("4")  // <3>
            assertThat(item.getResponse().getSource(), hasEntry("bar", "val2"));
        {
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL); // <1>
            String[] excludes = Strings.EMPTY_ARRAY;
                    bulkResponse.getBulkFailures(); // <14>  
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {  
        {
                    + "    }\n"  
            // end::bulk-request-active-shards
                Map<String, Object> sourceAsMap = getResponse.getSourceAsMap(); // <2>
            TimeValue throttledUntilMillis =  
            }  
        String index = response.getIndex(); // <1>  
            final CountDownLatch latch = new CountDownLatch(1);  
                long sumTotalTermFreq =
            String jsonString = "{" +  
            // tag::multi-get-request-source-exclude
                        tv.getFieldStatistics().getSumTotalTermFreq(); // <3>
            request.docAsUpsert(true); // <1>
                    new UpdateByQueryRequest("source1", "source2"); // <1>  
            // end::update-request-refresh  
import org.opensearch.client.core.TermVectorsResponse;  
                String sourceAsString = result.sourceAsString(); // <2>
                    // <1>
        client.deleteByQueryRethrottleAsync(request,
            request.add(new MultiGetRequest.Item("index", "example_id")
            String id = getResponse.getId();  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
                                    term.getTokens(); // <11>  
                    @Override  
            // tag::multi-get-request-no-source
            ReindexRequest request = new ReindexRequest(); // <1>  
            assertSame(0, bulkResponse.getBulkFailures().size());  
                .fetchSourceContext(fetchSourceContext));  // <1>
            request.scriptedUpsert(true); // <1>
import org.opensearch.client.Request;
                    user, password, Collections.emptyMap(),
            assertEquals(200, response.getStatusLine().getStatusCode());  
        }  
            // end::bulk-processor-add
            };  
            TimeValue throttledMillis = bulkResponse.getStatus().getThrottled(); // <11>  
            // end::rethrottle-request-execution
            request.setQuery(new TermQueryBuilder("user", "foobar")); // <1>  
            UpdateRequest request = new UpdateRequest("posts", "1");
        }
            long noops = bulkResponse.getNoops(); // <7>
                new Script(
            // tag::term-vectors-term-vectors  
        ActionListener<ListTasksResponse> listener;
            // end::delete-response  
                }
        {
            assertFalse(bulkResponse.hasFailures());  
            // end::delete-by-query-request-indicesOptions
            // tag::update-request-upsert
            request.script(inline);  // <3>  
            request.opType(DocWriteRequest.OpType.CREATE); // <1>
            {
            // end::index-execute  
        RestHighLevelClient client = highLevelClient();  
            builder.endObject();
import org.opensearch.index.query.MatchAllQueryBuilder;  
 * SPDX-License-Identifier: Apache-2.0
            listener = new LatchedActionListener<>(listener, latch);
                if (tv.getTerms() != null) {
        {  
    // Not entirely sure if _termvectors belongs to CRUD, and in the absence of a better place, will have it here
            }
            //tag::update-request-with-doc-as-xcontent
            //tag::update-request-shortcut
        {  
                    "postDate", new Date(),
            public void onFailure(Exception e) {
                @Override
                client.getSource(getSourceRequest, RequestOptions.DEFAULT);
        Response refreshResponse = client().performRequest(new Request("POST", "/authors/_refresh"));
import org.opensearch.client.core.GetSourceResponse;
            assertEquals("val1", value);  
            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
            // tag::update-request-detect-noop
                if (e.status() == RestStatus.CONFLICT) {  
        }  
            if (shardInfo.getFailed() > 0) {  
            assertSame(0, bulkResponse.getBulkFailures().size());  
                }
        // end::multi-term-vectors-execute-async
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
            final CountDownLatch latch = new CountDownLatch(1);
            for (BulkItemResponse bulkItemResponse : bulkResponse) { // <1>  
        }
            // tag::bulk-processor-listener
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
        }
            final CountDownLatch latch = new CountDownLatch(1);  
import org.opensearch.action.delete.DeleteResponse;
            request.setRealtime(false); // <8>
        // tag::term-vectors-execute-async
            request.fetchSource(
        {
import org.opensearch.action.support.WriteRequest.RefreshPolicy;  
                    // <1>
    }  
        }
        // tag::term-vectors-execute-listener  
        //tag::get-source-request-routing
                + "    \"field2\": {\n"
            request.opType("create"); // <2>
            }
            ReindexRequest request = new ReindexRequest();  
                    + "        }\n"  
        // end::multi-term-vectors-execute-listener
                    .source(MediaTypeRegistry.JSON,"field", "baz"));
            // tag::rethrottle-request-execution  
        );  
            // tag::index-conflict  
                    "\"updated\":\"2017-01-01\"," +
            String index = updateResponse.getIndex();
    public void testGetSource() throws Exception {
            // tag::bulk-errors  
            createPipeline("my_pipeline");
        {  
            };
            assertTrue(latch.await(30L, TimeUnit.SECONDS));  
                client.termvectors(request, RequestOptions.DEFAULT);
            //end::get-request  
            BulkRequest defaulted = new BulkRequest("posts"); // <1>
                // <2>
        CountDownLatch latch = new CountDownLatch(1);  
            request.setDestIndex("dest");
import org.opensearch.script.ScriptType;  
            createIndex.setJsonEntity(
                case UPDATE:   // <4>
        //end::get-source-request-routing  
        //end::get-source-request-preference  
                + "  }";  
        {
            client.deleteByQueryAsync(request, RequestOptions.DEFAULT, listener); // <1>
                    .endObject()
        }  
                .source("user", "foobar", "postDate", new Date(), "message", "trying out OpenSearch");
            request.pipeline("pipelineId"); // <1>  
        getSourceRequest.refresh(true); // <1>
                    + "different than the one provided [1000]"));    // <5>
                    // <2>  
            }  
        {  
        {
            @Override  
            TermVectorsRequest request = new TermVectorsRequest("authors",
            request.indices("source1");
            client.deleteByQueryRethrottle(request, RequestOptions.DEFAULT); // <3>  
            boolean timedOut = bulkResponse.isTimedOut(); // <2>  
            long updatedDocs = bulkResponse.getUpdated(); // <4>  
        }
                if (e.status() == RestStatus.NOT_FOUND) {
            } catch (OpenSearchException e) {  
import org.opensearch.action.get.MultiGetRequest;
            //tag::get-request-stored  
                    .source(MediaTypeRegistry.JSON, "title",
            //end::update-request-with-doc-as-xcontent
            // tag::bulk-processor-await  
            // tag::reindex-request-slices
            // Replace the empty listener by a blocking listener in test
        {
            assertThat(e.getMessage(),  
            // end::update-request-retry
            request.add(new MultiGetRequest.Item("index", "with_version")
            // end::update-request-detect-noop
        }
            // tag::update-getresult
        }
            assertSame(RestStatus.CREATED, indexResponse.status());
            // tag::multi-get-conflict  
            request.setRefresh(true); // <1>
            request.timeout("1s"); // <2>  
            // end::reindex-request-versionType  
            // end::update-response
                    "posts",    // <1>  
        {
                DeleteResponse deleteResponse = client.delete(
            //end::index-request-map  
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {  
                .version(10123L));                  // <3>
import org.opensearch.common.xcontent.json.JsonXContent;  
            final CountDownLatch latch = new CountDownLatch(1);
                + "    \"field2\": {\n"
            // end::delete-by-query-request
                    + "        \"properties\" : {\n"
                + "      \"type\": \"integer\"\n"  
            //tag::get-request-no-source
            String mapping = "  \"properties\": {\n"
            Exception e = item.getFailure().getFailure();            // <2>
            // tag::multi-get-request-top-level-extras  
import org.opensearch.index.reindex.ReindexRequest;
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
                    listener).build(); // <5>
            GetResponse firstGet = firstItem.getResponse();  // <2>
            FetchSourceContext fetchSourceContext =
                    break;
                byte[] sourceAsBytes = firstGet.getSourceAsBytes();          // <5>
import org.opensearch.common.unit.TimeValue;
            long createdDocs = bulkResponse.getCreated(); // <5>
            // tag::delete-response
            //tag::get-request-refresh
            }
            BulkByScrollResponse bulkResponse =
    public void testIndex() throws Exception {
                    if (response.hasFailures()) { // <2>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            //end::get-request-realtime
            // tag::delete-request-version
            for (BulkItemResponse bulkItemResponse : bulkResponse) {
                    .doc("field", "value");
            // end::delete-by-query-execute
            Map<String, String> perFieldAnalyzer = new HashMap<>();  
import org.opensearch.client.core.TermVectorsRequest;
            // end::delete-by-query-execute-listener
import java.util.Map;
        }
        getSourceRequest.routing("routing"); // <1>
                .id("1").source(jsonMap); // <1>
            // end::reindex-request-slices
        }
        {
 */
            // end::bulk-has-failures
            UpdateRequest request = new UpdateRequest("posts", "1")  
                    "\"user\":\"foobar\"," +  
            HttpHost host = getClusterHosts().get(0);
                public void onFailure(Exception e) {  
            assertNull(getResponse.getSourceInternal());
            request.add(new MultiGetRequest.Item("index", "example_id")
            client.getAsync(request, RequestOptions.DEFAULT, listener); // <1>
        RestHighLevelClient client = highLevelClient();
            assertNotNull(updateResponse.getGetResult());  
            listener = new ActionListener<BulkByScrollResponse>() {
    public void testMultiGet() throws Exception {
            //end::get-request-version
            //tag::get-execute
        {  
            // end::update-by-query-execute-async
        MultiTermVectorsResponse response =
            try {  
                }
            request.setScroll(TimeValue.timeValueMinutes(10)); // <1>
            MultiTermVectorsRequest request = new MultiTermVectorsRequest(); // <1>
                for (ReplicationResponse.ShardInfo.Failure failure :
            IndexRequest request = new IndexRequest("posts").id("1");  
                    }  
            // Replace the empty listener by a blocking listener in test
        }  
            request.setBatchSize(100); // <1>
            request.setScroll(TimeValue.timeValueMinutes(10)); // <1>
            MultiGetItemResponse item = response.getResponses()[0];
            // end::delete-execute
import org.opensearch.core.action.ActionListener;
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
        source.put("baz", "val3");
                UpdateResponse updateResponse = client.update(
                    bulkResponse.getBulkFailures(); // <13>
            request.versionType(VersionType.EXTERNAL); // <1>
            // end::rethrottle-request
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>  
            request.setPipeline("pipeline"); // <1>
                    .endObject()  
                    // <1>
 * KIND, either express or implied.  See the License for the
                RequestOptions.DEFAULT  
                    "\"message\":\"trying out OpenSearch\"" +
                + "    \"field2\": {\n"  
        return item;  
        // end::get-source-request-optional
            // end::delete-notfound
        ActionListener<TermVectorsResponse> listener;
                }
                }  
        // tag::term-vectors-execute  
                    .doc(jsonMap); // <1>
            Script stored = new Script(
        RestHighLevelClient client = highLevelClient();
            assertTrue(sourceAsMap.containsKey("field"));
                    }  
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
 *    http://www.apache.org/licenses/LICENSE-2.0
/**  
            public void onResponse(ListTasksResponse response) {
        }  
            request.preference("some_preference");  // <1>
            TimeValue throttledMillis = bulkResponse.getStatus().getThrottled(); // <10>
            // end::update-getresult
            //tag::update-request-with-doc-as-string
            assertSame(0, bulkResponse.getSearchFailures().size());
            // tag::delete-by-query-execute
            ActionListener<GetSourceResponse> listener =
            //end::get-execute-async
            String index = deleteResponse.getIndex();
            TimeValue throttledUntilMillis =  
            // tag::delete-execute
                    }
    // Not entirely sure if _mtermvectors belongs to CRUD, and in the absence of a better place, will have it here  
                        Throwable failure) {
            assertTrue(terminated);  
            // end::bulk-processor-close
            // tag::reindex-response
            assertSame(RestStatus.CREATED, indexResponse.status());  
            DeleteRequest request = new DeleteRequest("posts", "async");
                    + "    \"mappings\" : {\n"
import java.util.Collections;  
                @Override
            // end::multi-get-request-stored
import org.opensearch.action.index.IndexRequest;
                // <1>
                public void onFailure(Exception e) {
            jsonMap.put("updated", new Date());
                    + "    }\n"
            // tag::bulk-response
            XContentBuilder builder = XContentFactory.jsonBuilder();  
            // end::multi-get-request-item-extras
            request.add(new MultiGetRequest.Item("index", "with_routing")  
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            client.deleteAsync(request, RequestOptions.DEFAULT, listener); // <1>
                + "      \"type\": \"text\"\n"
                    // <1>  
import org.opensearch.action.support.replication.ReplicationResponse;
                long version = getResponse.getVersion();
            // end::bulk-errors
            // tag::bulk-processor-init
            // end::index-execute-listener  
        {  
    @SuppressWarnings("unused")
        {
            // end::get-execute-listener  
            if (shardInfo.getFailed() > 0) {  
            assertThat(e.getMessage(),
            client.bulkAsync(request, RequestOptions.DEFAULT, listener); // <1>
            // end::multi-get-indexnotfound
import org.opensearch.action.bulk.BulkResponse;
                    ScriptType.INLINE, "painless",
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());  
            // end::delete-request
        }
        {
                @Override  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));  
        source.put("foo", "val1");  
                @Override
            //end::index-request-shortcut  
            TimeValue timeTaken = bulkResponse.getTook(); // <1>  
            UpdateRequest request = new UpdateRequest("posts", "1")  
            );
                IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        }
                // <1>
                + "    }\n"  
            //tag::update-request-no-source
                "{\n"
            assertSame(RestStatus.OK, bulkResponse.status());
            // tag::get-source-execute  
            //end::get-execute
        //tag::get-source-request-refresh
            createIndex("source1", Settings.EMPTY, mapping);  
            // tag::update-by-query-request-conflicts
            // end::multi-get-request-top-level-extras
            // end::update-by-query-request-scroll
                "{\n"
                JsonXContent.contentBuilder()  
            // tag::reindex-request-script
        }  
import java.util.concurrent.CountDownLatch;
                    .toString()
        {
                .id("1")
 *  
            // tag::delete-execute-async
            //tag::get-indexnotfound
                    .doc(builder);  // <1>
            request.setPipeline("my_pipeline"); // <1>  
                    new DeleteByQueryRequest("source1", "source2"); // <1>
            // tag::index-request-pipeline
            request.setMaxDocs(10); // <1>
            // end::delete-request-routing
                    Collections.emptyMap())); // <1>
        {
                    bulkResponse.getStatus().getThrottledUntil(); // <12>
        }  
        {  
            // end::update-by-query-request-maxDocs
                    Collections.emptyMap())); // <1>  
            new FetchSourceContext(true, includes, excludes)); // <1>
            // tag::delete-by-query-request-timeout  
            String index = getResponse.getIndex();
            // tag::update-by-query-request-routing  
        // tag::term-vectors-response
            //end::get-request-source-exclude  
                public void afterBulk(long executionId, BulkRequest request,
            builder.setBulkActions(500); // <1>
                    bulkResponse.getStatus().getThrottledUntil(); // <13>
            docBuilder.startObject().field("user", "guest-user").endObject();
            String[] includes = Strings.EMPTY_ARRAY;
            IndexRequest indexRequest = new IndexRequest("posts").id("1").source("field", 0);  
            // TODO status is broken! fix in a followup  
            //tag::index-request-xcontent
        {
            // end::update-by-query-request-timeout
        assertEquals("index", item.getIndex());
            Map<String, Integer> filterSettings = new HashMap<>();
            bulkProcessor.add(one);
                    .doc("updated", new Date(),  
            request.fetchSourceContext(fetchSourceContext); // <1>
                + "      \"type\": \"text\"\n"
            // tag::multi-get-request-item-extras
            ActionListener<IndexResponse> listener;
                    .doc("field", "value")
            request.setScroll(TimeValue.timeValueMinutes(10)); // <1>
            // tag::index-request-timeout
            assertEquals("foobar", sourceAsMap.get("user"));
                .versionType(VersionType.EXTERNAL)  // <2>  
            filterSettings.put("max_num_terms", 3);
                + "  }";
            // tag::bulk-request-index-type  
            //tag::get-request-version
        client.mtermvectorsAsync(  
                RequestOptions.DEFAULT, listener); // <3>  
            // tag::delete-request-version-type
                // <2>
        }
            } catch (OpenSearchException e) {
                RequestOptions.DEFAULT, listener); // <2>
            // Replace the empty listener by a blocking listener in test  
            final CountDownLatch latch = new CountDownLatch(1);
            request.preference("preference"); // <1>  
            filterSettings.put("min_doc_freq", 1);
            //end::get-request-source-include  
                }
            // end::multi-get-response  
            }
            MultiGetItemResponse item = unwrapAndAssertExample(client.mget(request, RequestOptions.DEFAULT));
        {
            request.waitForActiveShards(ActiveShardCount.ALL); // <2>  
import org.opensearch.index.reindex.DeleteByQueryRequest;  
            MultiGetItemResponse firstItem = response.getResponses()[0];
            // end::update-by-query-request-indicesOptions
                @Override  
        //tag::get-source-request-preference
            String[] includes = Strings.EMPTY_ARRAY;
                public void onFailure(Exception e) {
            assertEquals(DocWriteResponse.Result.UPDATED, indexResponse.getResult());
            // end::rethrottle-disable-request
                @Override
            request.add(new DeleteRequest("posts", "3")); // <1>
            UpdateRequest request = new UpdateRequest("posts", "does_not_exist")
            assertThat(item.getResponse().getSource(), not(hasKey("baz")));  
            // Replace the empty listener by a blocking listener in test  
            final CountDownLatch latch = new CountDownLatch(1);  
            };  
            // end::multi-get-conflict
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);  
            // end::update-by-query-request-slices
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>  
                    + "                \"type\": \"text\",\n"
                .source("user", "foobar", "postDate", new Date(), "message", "trying out OpenSearch");  
    public void testTermVectors() throws Exception {  
            // end::term-vectors-request
        // end::term-vectors-execute-listener
            // tag::reindex-request-sourceSize
            @Override
                + "    \"user\": {\n"  
            // Replace the empty listener by a blocking listener in test
 */  
            request.setDestOpType("create"); // <1>
            //end::get-indexnotfound
            request.add(new IndexRequest("posts").id("2")  // <3>
                // <1>  
            // end::bulk-request-pipeline
            request.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE); // <1>
            Map<String, Object> jsonMap = new HashMap<>();  
            Map<String, Object> sourceAsMap = updateResponse.getGetResult().sourceAsMap();
            request.doc(jsonString, MediaTypeRegistry.JSON); // <1>
            }
            request.setRouting("=cat"); // <1>
            listener = new LatchedActionListener<>(listener, latch);  
            // tag::update-by-query-request-script
            // tag::delete-request-refresh  
            // tag::rethrottle-disable-request
            filterSettings.put("max_word_length", 10);
                                executionId, response.getTook().getMillis());
            // end::reindex-request-query
                // <5>
            listener = new ActionListener<UpdateResponse>() {
            MultiGetResponse response = client.mget(request, RequestOptions.DEFAULT);
                switch (bulkItemResponse.getOpType()) {  
            filterSettings.put("max_doc_freq", 100);  
            IndexRequest indexRequest = new IndexRequest("posts")
                // <6>
                // <2>
                    logger.error("Failed to execute bulk", failure); // <3>  
        RestHighLevelClient client = highLevelClient();  
import org.opensearch.core.common.unit.ByteSizeUnit;
                                int startOffset = token.getStartOffset(); // <13>  
            long batches = bulkResponse.getBatches(); // <6>
            new IndexRequest("index").id("example_id").source(source).setRefreshPolicy(RefreshPolicy.IMMEDIATE),
            assertSame(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            long versionConflicts = bulkResponse.getVersionConflicts(); // <8>  
            request.version(2); // <1>  
        {
            // end::update-request-routing
            listener = new ActionListener<MultiGetResponse>() {  
                containsString("reason=no such index [missing_index]")); // <5>
            // end::update-by-query-request-pipeline
        }  
            // tag::delete-conflict  
            request.add(new IndexRequest("posts").id("3")  // <4>
            //tag::get-response
        }  
import static java.util.Collections.singletonMap;
            IndexResponse indexResponse = client.index(new IndexRequest("posts").id("1").source("field", "value"), RequestOptions.DEFAULT);  
            TermVectorsRequest tvrequest1 =
            assertEquals(4, updateResponse.getGetResult().getSource().get("field"));
import org.opensearch.action.bulk.BulkItemResponse;
            try {  
            listener = new LatchedActionListener<>(listener, latch);
                    .source(MediaTypeRegistry.JSON, "title",
            // tag::get-execute-listener  
                    + "    }\n"
                    + "}"  
            List<ScrollableHitSource.SearchFailure> searchFailures =
            request.setSourceIndices("source1");
    }
            //end::update-request-with-doc-as-string
            request.setMaxDocs(10); // <1>
            Script inline = new Script(ScriptType.INLINE, "painless",
            "1");    // <2>
                    // <2>  
                public void onFailure(Exception e) {  
            listener = new LatchedActionListener<>(listener, latch);  
            assertEquals(2, sourceAsMap.size());  
                new ActionListener<GetSourceResponse>() {  
            request.setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN); // <1>
    public void testMultiTermVectors() throws Exception {
            // end::exists-execute-async
                @Override  
                    String reason = failure.reason(); // <2>  
                public void onFailure(Exception e) {
        {  
            //end::update-request-shortcut
            // end::update-by-query-request-routing
            // tag::bulk-processor-add
            // end::index-request-routing  
import org.opensearch.script.Script;
            // tag::exists-execute-async  
            }  
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
            // tag::delete-by-query-request-slices  
                        shardInfo.getFailures()) {
                @Override
            IndexRequest one = new IndexRequest("posts").id("1")  
        final CountDownLatch latch = new CountDownLatch(3);
        // end::rethrottle-request-async-listener
                    new FetchSourceContext(true, includes, excludes);
    @SuppressWarnings("unused")
                    "1");   // <2>
            request.setRefreshPolicy("wait_for");                            // <2>
            request.realtime(false);                // <2>
            createIndex("source1", Settings.EMPTY, mapping);
            // end::index-optype
            request.setRefresh(true); // <1>
            "1");   // <2>  
                public void onResponse(BulkByScrollResponse bulkResponse) {
            // tag::update-by-query-execute
            // end::get-source-execute-listener
            request.setRefreshPolicy("wait_for");                            // <2>
    @SuppressWarnings("unused")
        TermVectorsRequest tvrequestTemplate =
        };
        assertTrue(authorsResponse.isAcknowledged());
            //end::update-request-source-exclude
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
        {
            }  
            createIndex("source1", Settings.EMPTY, mapping);
                            executionId, numberOfActions);
            request.add(new MultiGetRequest.Item("index", "example_id")  
 *
            // tag::get-conflict
        }
            // tag::reindex-request-query
    @SuppressWarnings("unused")
            // end::reindex-execute-async  
                }
import java.util.Date;
        tvrequestTemplate.setFields("user");  
            assertTrue(getResponse.isExists());
                        String termStr = term.getTerm(); // <6>
                    + "                \"type\": \"text\",\n"  
            //tag::get-request-routing
        // end::multi-term-vectors-response  
            XContentFactory.jsonBuilder()  
                + "      \"type\": \"integer\"\n"
        GetRequest getRequest = new GetRequest(
                }
            builder.endObject();
            createIndex("source2", Settings.EMPTY, mapping);
                    + "    \"mappings\" : {\n"  
                    + "            \"foo\" : {\n"
            // tag::reindex-execute-async
                new TermVectorsRequest("authors", docBuilder);
            assertTrue(sourceAsMap.containsKey("updated"));
        // end::multi-term-vectors-execute  
        boolean found = response.getFound(); // <3>
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
                }  
            XContentBuilder builder = XContentFactory.jsonBuilder();
                }
            request.setPerFieldAnalyzer(perFieldAnalyzer);  // <7>
        }
import org.opensearch.core.tasks.TaskId;
            String id = deleteResponse.getId();  
            jsonMap.put("message", "trying out OpenSearch");  
        {  
import org.opensearch.core.common.Strings;
            IndexRequest two = new IndexRequest("posts").id("2")  
            String user = "test_user";
import org.opensearch.common.settings.Settings;  
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {  
            // end::update-request-active-shards  
            DeleteByQueryRequest request =  
            // end::reindex-request-script
            //tag::update-request-with-doc-as-map
            request.add(new MultiGetRequest.Item("index", "example_id")
            client.reindexRethrottle(request, RequestOptions.DEFAULT);       // <1>
            // end::delete-by-query-request-slices
            assertEquals(3, getResponse.getSourceAsMap().size());  
                @Override
                }
                    // <2>  
 * under the License.  
            MultiGetRequest request = new MultiGetRequest();  
            IndexRequest request = new IndexRequest("posts")
            String[] excludes = new String[]{"updated"};
            // tag::update-failure
            }
            // tag::bulk-request-timeout
            client.indexAsync(request, RequestOptions.DEFAULT, listener); // <1>
                + "      \"type\": \"text\"\n"  
                public void onFailure(Exception e) {
            assertNull(item.getResponse());                          // <1>  
                builder.field("message", "trying out OpenSearch");
            // end::update-by-query-request
        GetSourceRequest getSourceRequest = new GetSourceRequest(
                    // <1>
            assertEquals(2, sourceAsMap.size());  
            boolean terminated = bulkProcessor.awaitClose(30L, TimeUnit.SECONDS); // <1>
            @Override  
            // tag::bulk-processor-close
        }
 * Code wrapped in {@code tag} and {@code end} tags is included in the docs.
            createIndex.setJsonEntity(  
                }
            // tag::exists-execute  
            // end::reindex-request-pipeline  
        // tag::rethrottle-execute-async  
            assertSame(RestStatus.CREATED, indexResponse.status());
            UpdateByQueryRequest request = new UpdateByQueryRequest();
                    new FetchSourceContext(true, includes, excludes)); // <1>  
                         "reason", "daily update"); // <1>
        {  
        }
            GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
            String[] excludes = new String[] {"foo", "*r"};  
import java.util.HashMap;
            }
            // end::bulk-request-routing
            // These cannot be set with a remote set, so its set here instead for the docs
            FetchSourceContext fetchSourceContext =  
            public void onFailure(Exception e) {
            String password = "test-password";  
            request.setJsonEntity(
            builder.setFlushInterval(TimeValue.timeValueSeconds(10L)); // <4>
            assertTrue(sourceAsMap.containsKey("postDate"));
    @SuppressWarnings("unused")  
 * specific language governing permissions and limitations
                }
        }
            // end::multi-term-vectors-request  
                IndexResponse response = client.index(request, RequestOptions.DEFAULT);
                    new TimeValue(100, TimeUnit.MILLISECONDS),
            //end::get-source-execute-async
import org.opensearch.index.VersionType;
            Request createIndex = new Request("PUT", "/posts");
            // tag::bulk-execute-listener
            request.setRefreshPolicy("wait_for");                            // <2>
            // tag::reindex-request-opType
            request.setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN); // <1>
                }  
            // Replace the empty listener by a blocking listener in test
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            XContentFactory.jsonBuilder()
                long version = firstGet.getVersion();
            // tag::delete-by-query-execute-async
            // tag::bulk-execute-async
            GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
 * GitHub history for details.
        }
 *
            // tag::delete-by-query-request-indicesOptions  
            // tag::reindex-execute
                }
        CountDownLatch latch = new CountDownLatch(1);  
                    .source(MediaTypeRegistry.JSON,"field", "foo"));
            List<BulkItemResponse.Failure> bulkFailures =
            request.setSourceBatchSize(100); // <1>
                    + "            }\n"
            MultiGetRequest request = new MultiGetRequest();  
            final CountDownLatch latch = new CountDownLatch(1);
        }
            // end::delete-by-query-response  
            };  
            final CountDownLatch latch = new CountDownLatch(1);
            // end::index-request-refresh
            client.existsAsync(getRequest, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.client.indices.CreateIndexResponse;
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
            };
            // end::bulk-execute  
                + "    \"user\": {\n"
            // tag::update-by-query-request-refresh  
            // end::multi-get-request  
                new TermVectorsRequest("authors", "1");  
                }
            request.add(new MultiGetRequest.Item("index", "another_id")); // <3>
            String remoteHost = host.getHostName();
            // end::delete-by-query-request-refresh
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());  
                Map<String, Object> sourceAsMap = firstGet.getSourceAsMap(); // <4>
            // end::bulk-processor-init
                Map<String, Object> sourceAsMap = result.sourceAsMap(); // <3>
            MultiGetItemResponse missingIndexItem = response.getResponses()[2];
            IndexRequest three = new IndexRequest("posts").id("3")  
            // tag::update-request-routing
            builder.startObject();  
        assertEquals(200, refreshResponse.getStatusLine().getStatusCode());  
            MultiGetRequest request = new MultiGetRequest();  
        }
            createPipeline("my_pipeline");
        {  
                    new BytesArray(new MatchAllQueryBuilder().toString()),  
            if (updateResponse.getResult() == DocWriteResponse.Result.CREATED) {
            String jsonString = "{" +
            }  
            }  
        );
            createIndex.setJsonEntity(
                    .field("source", "ctx._source.field += params.count")
import static org.hamcrest.Matchers.not;
                + "    \"user\": {\n"
                containsString("version conflict, current version [1] is "  
                long sumDocFreq = tv.getFieldStatistics().getSumDocFreq(); // <4>  
        List<TermVectorsResponse> tvresponseList =  
            // tag::multi-get-request-source-include
import static org.hamcrest.Matchers.containsString;
            //end::update-request-source-include
            String id = firstItem.getId();  
    public void testUpdateByQuery() throws Exception {  
            long deletedDocs = bulkResponse.getDeleted(); // <6>
            GetRequest request = new GetRequest("posts", "1");
            String index = indexResponse.getIndex();
import org.opensearch.client.core.MultiTermVectorsRequest;  
        }
        RestHighLevelClient client = highLevelClient();
        }
            //tag::update-request-with-inline-script
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);  
            request.setDestVersionType(VersionType.EXTERNAL); // <1>
            try {  
                @Override  
            for (TermVectorsResponse.TermVector tv : response.getTermVectorsList()) {
        }
import org.opensearch.action.LatchedActionListener;
            //tag::get-execute-async  
            jsonMap.put("user", "foobar");
            // end::reindex-request-opType  
            //tag::update-request-with-stored-script
            //tag::update-request-source-exclude
            DeleteByQueryRequest request = new DeleteByQueryRequest();  
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
        {
        {  
            assertNull(getResponse.getSourceInternal());
        {
        assertTrue(authorsResponse.isAcknowledged());
            //end::update-docnotfound
            }
            Integer remotePort = host.getPort();  
            try {  
            // tag::index-request-version  
            // end::update-by-query-request-query
            request.setSlices(2); // <1>  
            public void onFailure(Exception e) {
                        logger.debug("Bulk [{}] completed in {} milliseconds",
                    .source(MediaTypeRegistry.JSON, "title",
                public void onFailure(Exception e) {  
            request.setRouting("=cat"); // <1>
        }
                + "      \"type\": \"integer\"\n"  
 * Modifications Copyright OpenSearch Contributors. See
            // end::update-execute-async
        {
import org.opensearch.action.support.IndicesOptions;
                .startObject("properties")  
                case DELETE:   // <5>
                        int docFreq = term.getDocFreq(); // <8>
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
                for (ReplicationResponse.ShardInfo.Failure failure :
            assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());  
            // Replace the empty listener by a blocking listener in test
            // Replace the empty listener by a blocking listener in test  
            Map<String, Object> expectSource = new HashMap<>();
        String id = response.getId(); // <2>
            try {
            // end::bulk-response  
            } catch(OpenSearchException e) {
import org.opensearch.client.RestHighLevelClient;
            Request createIndex = new Request("PUT", "/index");  
            listener = new ActionListener<IndexResponse>() {
                    new TimeValue(100, TimeUnit.SECONDS)  
    private MultiGetItemResponse unwrapAndAssertExample(MultiGetResponse response) {
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
                    "if (ctx._source.user == 'foobar') {ctx._source.likes++;}",  
                case CREATE:
            // end::delete-conflict
                @Override
            String id = updateResponse.getId();  
            TimeValue timeTaken = bulkResponse.getTook(); // <1>
            request.fetchSource(true); // <1>
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
                if (e.status() == RestStatus.CONFLICT) {  
            assertNull(missingIndexItem.getResponse());                // <1>
                }  
                    // <1>
                .endObject()
                    new FetchSourceContext(true, includes, excludes);
            request.routing("routing"); // <1>  
        {
            UpdateRequest request = new UpdateRequest("posts", "id");
            request.setRefreshPolicy("wait_for");                            // <2>
 * license agreements. See the NOTICE file distributed with
            for (TermVectorsResponse tvresponse : tvresponseList) {  
        RestHighLevelClient client = highLevelClient();
                @Override  
                    + "            \"message\" : {\n"
                    // <1>
            TermVectorsRequest request = new TermVectorsRequest("authors", "1");
    }
            request.add(new UpdateRequest("posts", "2") // <2>
            // tag::delete-notfound
        TermVectorsRequest request = new TermVectorsRequest("authors", "1");  
                DocWriteResponse itemResponse = bulkItemResponse.getResponse(); // <2>
                    + "        \"properties\" : {\n"  
                    + "}"
        {
        client.updateByQueryRethrottleAsync(request,  
            "posts", // <1>
                    "http", remoteHost, remotePort, null,
            // tag::bulk-request-pipeline
        listener = new ActionListener<ListTasksResponse>() {  
                public void beforeBulk(long executionId, BulkRequest request) {
            // tag::delete-by-query-request-routing  
            // tag::update-request-refresh  
        }  
            client.getSourceAsync(request, RequestOptions.DEFAULT, listener); // <1>  
            // end::index-request-version
            UpdateRequest request = new UpdateRequest("posts", "1").doc("reason", "no source");  
            request.routing("routing"); // <1>
import org.opensearch.action.bulk.BulkRequest;
            // end::delete-by-query-request-query
            UpdateRequest request = new UpdateRequest("posts", "1").doc("reason", "source excludes");
            request.versionType(VersionType.EXTERNAL); // <1>
                        Throwable failure) {
        RethrottleRequest request = new RethrottleRequest(taskId);
import org.opensearch.action.bulk.BulkProcessor;  
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
            String[] includes = new String[]{"message", "*Date"};
            assertNull(item.getResponse().getSource());  
            // tag::update-request-doc-upsert  
                public void beforeBulk(long executionId, BulkRequest request) {
            long versionConflicts = bulkResponse.getVersionConflicts(); // <9>
            request.timeout("1s"); // <2>
                    "1");       // <2>
        {  
        }  
            // tag::delete-by-query-request-maxDocs  
        client.index(new IndexRequest("index").id("1").source("user", "foobar"), RequestOptions.DEFAULT);
            // tag::index-execute-async  
            ActionListener<GetResponse> listener = new ActionListener<GetResponse>() {
 * You may obtain a copy of the License at  
            // end::delete-request-version  
    public void testReindexRethrottle() throws Exception {
        {
                    + "            \"message\" : {\n"  
                @Override
            updateResponse = client.update(request, RequestOptions.DEFAULT);  
            OpenSearchException ee = (OpenSearchException) e;    // <3>  
            // tag::update-by-query-execute-listener
            request.fetchSource(true);  
            assertEquals("source includes", sourceAsMap.get("reason"));  
    }
                    "ctx._source.field += params.count", parameters);  // <2>
        request.setFields("user");
            }
            request.fetchSource(true);  
            // tag::multi-get-request  
            BulkProcessor bulkProcessor = BulkProcessor.builder(
            if (deleteResponse.getResult() == DocWriteResponse.Result.NOT_FOUND) {
            String[] includes = new String[] {"foo", "*r"};
        // tag::get-source-request  
        }
            request.setDestPipeline("my_pipeline"); // <1>
                RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.index.reindex.BulkByScrollResponse;
                // <1>  
            assertTrue(sourceAsMap.containsKey("postDate"));
 * Unless required by applicable law or agreed to in writing,
                @Override
            // end::update-request-doc-upsert
import static org.hamcrest.Matchers.hasEntry;
            // end::bulk-request-with-mixed-operations  
            }
                + "    \"field1\": {\n"  
        }  
import org.opensearch.core.common.unit.ByteSizeValue;
                    // <1>  
                "index",         // <1>  
            assertEquals(2, sourceAsMap.size());
        //tag::get-source-request-realtime
            // end::index-request-op-type  
                    .setIfPrimaryTerm(200L);  
            // end::multi-get-execute
            request = new UpdateRequest("posts", "1").fetchSource(true);  
                    DeleteResponse deleteResponse = (DeleteResponse) itemResponse;  
            // tag::multi-get-execute  
        }
            UpdateRequest request = new UpdateRequest("posts", "1")  
            UpdateByQueryRequest request =
            }
            UpdateRequest request = new UpdateRequest(
            List<ScrollableHitSource.SearchFailure> searchFailures =  
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
            // end::get-conflict
            }
                    } else {  
            BulkByScrollResponse bulkResponse =
        // end::term-vectors-execute-async
            ActionListener<BulkByScrollResponse> listener;
                }
            // tag::delete-by-query-request-scrollSize  
                        // <2>
            assertEquals("trying out OpenSearch", message);
            // end::delete-by-query-request-timeout
        }
            request.storedFields("message"); // <1>
            final CountDownLatch latch = new CountDownLatch(1);
                @Override
            // end::reindex-request-conflicts  
                .source("user", "foobar",  
            } else {  
        client.index(new IndexRequest("index").id("1").source("user", "foobar"), RequestOptions.DEFAULT);  
                    // <2>  
                + "    }\n"
                };
        }
            ReplicationResponse.ShardInfo shardInfo = updateResponse.getShardInfo();
            assertFalse(bulkResponse.hasFailures());
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
            // end::reindex-request-remote  
                    (request, bulkListener) ->
        // tag::exists-request
            request.id("1"); // <2>
                    + "        }\n"
            request.timeout("2m"); // <2>
        }  
        }
                        }
            createIndex("source2", Settings.EMPTY, mapping);  
                .startObject()
            // tag::update-by-query-response
            request.setMaxDocs(10); // <1>  
        Map<String, Object> source = new HashMap<>();
            request.setDestIndex("dest");  // <3>
        RestHighLevelClient client = highLevelClient();
            // tag::update-by-query-request-query
            // tag::bulk-has-failures
            String[] excludes = new String[]{"message"};
            IndexRequest request = new IndexRequest("posts").id("async").source("field", "value");
            // end::update-failure  
                if (e.status() == RestStatus.NOT_FOUND) {  
 * software distributed under the License is distributed on an
            assertEquals(200, response.getStatusLine().getStatusCode());
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        }
                }
            UpdateRequest request = new UpdateRequest("posts", "async").doc("reason", "async update").docAsUpsert(true);  
 * The OpenSearch Contributors require contributions made to  
            // end::update-request-timeout
    }  
            // tag::update-by-query-request-scrollSize
            RethrottleRequest request = new RethrottleRequest(taskId);
            request.setSourceIndices("source1", "source2"); // <2>
            //end::get-request-preference
                }
            //end::get-response  
            BulkProcessor.Listener listener = new BulkProcessor.Listener() {
            BulkRequest request = new BulkRequest(); // <1>
                    (request, bulkListener) ->
            if (result.isExists()) {  
                .setIfSeqNo(10L)
                                String payload = token.getPayload(); // <15>
                .endObject()
            // end::bulk-request-timeout
            // tag::bulk-request-refresh  
        RestHighLevelClient client = highLevelClient();  
            listener = new ActionListener<BulkByScrollResponse>() {
            // end::update-request-upsert
        TaskId taskId = new TaskId("oTUltX4IQMOUUVeiohTt8A:124");  
        ActionListener<MultiTermVectorsResponse> listener;
            final CountDownLatch latch = new CountDownLatch(1);
            //tag::get-request
import java.util.List;  
            request.setBatchSize(100); // <1>  
                public void onFailure(Exception e) {
import org.opensearch.action.get.GetResponse;  
                        request, RequestOptions.DEFAULT);
import org.opensearch.index.reindex.UpdateByQueryRequest;
            // end::index-conflict
            //tag::get-request-version-type
        // tag::multi-term-vectors-response
            // end::update-by-query-request-scrollSize
            assertEquals(3, result.sourceAsMap().size());  
            // Replace the empty listener by a blocking listener in test
            GetRequest request = new GetRequest("posts", "1");  
            // tag::multi-get-execute-listener
            @Override  
            request.setFilterSettings(filterSettings);  // <6>
            request.setTermStatistics(true); // <2>
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL); // <1>
 */  
            request.setScript(  
        }
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
            // end::bulk-request-index-type
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            request.setSlices(2); // <1>
            GetRequest request = new GetRequest("posts", "1");
                    int numberOfActions = request.numberOfActions(); // <1>
            long totalDocs = bulkResponse.getTotal(); // <3>
            Response response = client().performRequest(createIndex);  
                        BulkResponse response) {  
            // tag::bulk-execute
            ActionListener<BulkByScrollResponse> listener;  
                .endObject()
            request.version(2); // <1>
                + "  }";
            }  
            long deletedDocs = bulkResponse.getDeleted(); // <4>
            // tag::term-vectors-request-artificial
            tvrequest1.setFields("user");
        {  
                @Override
            assertThat(item.getResponse().getSource(), hasEntry("foo", "val1"));
            // end::delete-execute-async  
import org.opensearch.core.xcontent.XContentBuilder;  
        }  
        {
            long updatedDocs = bulkResponse.getUpdated(); // <4>
            assertEquals("source excludes", sourceAsMap.get("reason"));  
                // <1>
            // tag::term-vectors-request
            // tag::index-request-routing
            // tag::multi-get-indexnotfound  
            long versionConflicts = bulkResponse.getVersionConflicts(); // <7>
            TimeValue throttledUntilMillis =
        {
            public void onResponse(MultiTermVectorsResponse mtvResponse) {  
            // TODO status is broken! fix in a followup
        }
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            builder.startObject();
        client.reindexRethrottleAsync(request,
import org.opensearch.OpenSearchException;
                .fetchSourceContext(fetchSourceContext));  // <1>
                            bulkItemResponse.getFailure(); // <2>
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
                    ScriptType.STORED, null, "increment-field", parameters);  // <1>  
            assertEquals("trying out OpenSearch", sourceAsMap.get("message"));
        };
            request.setConflicts("proceed"); // <1>  
            MultiGetResponse response = client.mget(request, RequestOptions.DEFAULT);
            };  
                builder.timeField("updated", new Date());
            // end::delete-request-timeout
            listener = new ActionListener<BulkByScrollResponse>() {  
            request.version(2); // <1>
                .id("1")  
            IndexRequest indexRequest = new IndexRequest("posts")
                    // <2>
        // end::term-vectors-response  
            // tag::delete-by-query-request-conflicts  
            request.setPayloads(false); // <5>
                    request, RequestOptions.DEFAULT);  
                }
        }
import org.opensearch.client.indices.CreateIndexRequest;
            // tag::index-optype
                    break;
        //end::get-source-request-realtime  
    }
            assertFalse(exists);  
            Request createIndex = new Request("PUT", "/posts");
            request.waitForActiveShards(ActiveShardCount.ALL); // <2>
            GetRequest request = new GetRequest("posts", "1");
            }
                    listener);  
            // tag::update-by-query-request-pipeline
            ActionListener<UpdateResponse> listener;
                + "    },\n"
            filterSettings.put("min_word_length", 1);
                public void onResponse(DeleteResponse deleteResponse) {
            long noops = bulkResponse.getNoops(); // <6>
                    // <2>  
            long noops = bulkResponse.getNoops(); // <8>
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
        }
            // tag::reindex-request
                "example_id"));  // <2>
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
                GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
        String[] ids = {"1", "2"};
                    "\"postDate\":\"2013-01-30\"," +
        }  
            );
            //end::get-request-no-source  
            FetchSourceContext fetchSourceContext =
        {
                // <4>
                            "The Future of Federated Search in OpenSearch");
            // tag::term-vectors-request-optional-arguments  
                // <3>
import org.opensearch.index.reindex.RemoteInfo;
import org.opensearch.action.update.UpdateResponse;  
                    // <2>
            // tag::delete-request-timeout
                + "    },\n"
            //end::get-request-refresh
        }
            // end::delete-execute-listener
        }
            }
        // tag::multi-term-vectors-execute  
            // end::reindex-request-maxDocs  
            assertEquals(8, updateResponse.getGetResult().getSource().get("field"));
import org.apache.hc.core5.http.HttpHost;
            DeleteResponse deleteResponse = client.delete(  
            request.refresh(true); // <1>  
            // tag::reindex-execute-listener
        RestHighLevelClient client = highLevelClient();
        {
            {
                @Override
        String[] includes = Strings.EMPTY_ARRAY;  // <2>
            // tag::update-execute
 * this work for additional information regarding copyright
            request.setRemoteInfo(  
                @Override  
    public void testDeleteByQuery() throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
    }  
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
            request.routing("routing"); // <1>  
            // tag::reindex-request-versionType
            assertNull(item.getResponse().getSource());
        }
                + "    \"field1\": {\n"
        client.termvectorsAsync(request, RequestOptions.DEFAULT, listener); // <1>  
                    // <1>
        client.index(  
                @Override
/*  
                    client.reindex(request, RequestOptions.DEFAULT);
            // end::reindex-request-sourceSize  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            //tag::get-request-source-exclude  
            // end::exists-execute-listener  
            GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
            String id = indexResponse.getId();
                        int termFreq = term.getTermFreq(); // <7>  
            TimeValue timeTaken = bulkResponse.getTook(); // <1>
        }
            request.setScript(
                .field("type", "keyword")
            // tag::reindex-request-refresh
                public void afterBulk(long executionId, BulkRequest request,
            // end::multi-get-request-source-include
            //tag::index-request-shortcut  
        {
            };
        //end::get-source-request-refresh  
 * this file be licensed under the Apache-2.0 license or a
                    "message", "trying out OpenSearch"); // <1>
            //end::update-request-with-inline-script
            UpdateRequest request = new UpdateRequest("posts", "1").doc("reason", "source includes");
            String[] excludes = Strings.EMPTY_ARRAY;
            // end::update-request-scripted-upsert
            IndexRequest indexRequest = new IndexRequest("posts")
            request.setConflicts("proceed"); // <1>
                        float score = term.getScore(); // <10>  
                new IndexRequest("posts").id("async").source("field", "value"),
            listener = new LatchedActionListener<>(listener, latch);
            listener = new LatchedActionListener<>(listener, latch);
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // tag::exists-execute-listener  
                    "\"reason\":\"daily update\"" +
        assertThat(response.getResponses(), arrayWithSize(1));
            //tag::update-request-source-include
            RethrottleRequest request = new RethrottleRequest(taskId, 100.0f); // <1>  
                    "}";  
                    + "                \"store\": true\n"  
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        String[] excludes = new String[]{"postDate"};
            // tag::reindex-request-timeout
            GetRequest getRequest = new GetRequest(  
                }
            response.getTermVectorsResponses(); // <1>
            }  
                    + "                \"type\": \"text\",\n"
                .version(1000L));  
                    // <1>
                }
                GetRequest request = new GetRequest("posts", "1").version(2);  
            String[] includes = Strings.EMPTY_ARRAY;  
            //end::get-request-stored
    public void testReindex() throws Exception {
            // tag::delete-by-query-request
            assertSame(0, bulkResponse.getBulkFailures().size());
                // <2>
import org.opensearch.index.reindex.ScrollableHitSource;  
 */  
            try {
            assertEquals(200, response.getStatusLine().getStatusCode());
            ActionListener<MultiGetResponse> listener;
            Response response = client().performRequest(createIndex);
            //end::index-request-string
            filterSettings.put("min_term_freq", 1);  
import org.opensearch.action.index.IndexResponse;
        {
        {  
    }
        }
            // tag::bulk-request-with-mixed-operations
            assertEquals(1, getResponse.getFields().size());  
        }
import org.opensearch.index.get.GetResult;
        // tag::rethrottle-request-async-listener
                                int position = token.getPosition(); // <12>
            assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
                .fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE));  // <1>  
                public void onFailure(Exception e) {
            listener = new LatchedActionListener<>(listener, latch);
                public void onResponse(Boolean exists) {  
            assertEquals(source, firstGet.getSource());  
                    request, RequestOptions.DEFAULT);
    @SuppressWarnings("unused")  
            assertSame(RestStatus.CREATED, indexResponse.status());
                .endObject()  
            // tag::index-response  
            request.add(tvrequest2); // <3>
                public void afterBulk(long executionId, BulkRequest request,
                    bulkResponse.getSearchFailures(); // <14>  
            GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
            request.timeout(TimeValue.timeValueSeconds(1)); // <1>  
            DeleteRequest request = new DeleteRequest("posts", "1");
        TermVectorsResponse response =
            MultiGetRequest request = new MultiGetRequest();  
                    public void onResponse(GetSourceResponse getResponse) {
        CreateIndexResponse authorsResponse = client.indices().create(authorsRequest, RequestOptions.DEFAULT);
            // tag::get-source-response
            request.script(stored);  // <2>
            );
                    String reason = failure.reason(); // <4>  
            long searchRetries = bulkResponse.getSearchRetries(); // <11>
                }  
            // end::index-execute-async
            long searchRetries = bulkResponse.getSearchRetries(); // <10>
            Map<String, Object> sourceAsMap = updateResponse.getGetResult().sourceAsMap();
import org.opensearch.client.core.GetSourceRequest;
        {  
            request.setOffsets(false); // <4>
        // end::term-vectors-execute  
            //tag::index-request-string
 * Documentation for CRUD APIs in the high level java client.
                String sourceAsString = firstGet.getSourceAsString();        // <3>  
        {
            // end::reindex-request-timeout  
            MultiGetRequest request = new MultiGetRequest();
            // end::update-by-query-execute
        getSourceRequest.preference("preference"); // <1>
            String mapping = "  \"properties\": {\n"
            MultiGetItemResponse item = unwrapAndAssertExample(client.mget(request, RequestOptions.DEFAULT));  
                    IndexResponse indexResponse = (IndexResponse) itemResponse;  
            } else if (updateResponse.getResult() == DocWriteResponse.Result.UPDATED) {
            // tag::update-request-scripted-upsert  
            // tag::update-by-query-request-timeout  
        }
                + "      \"type\": \"integer\"\n"
            request.source(jsonString, MediaTypeRegistry.JSON); // <3>
            BulkProcessor.Builder builder = BulkProcessor.builder(  
        // tag::multi-term-vectors-execute-async
            long batches = bulkResponse.getBatches(); // <5>  
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
package org.opensearch.client.documentation;
                    @Override
import org.opensearch.core.rest.RestStatus;  
        {
            // Add a missing index so we can test it.
            // tag::update-conflict
            request.fetchSource(
            // tag::delete-execute-listener
        }
            long batches = bulkResponse.getBatches(); // <7>  
    }  
                @Override  
            DeleteResponse deleteResponse = client.delete(
                    ScriptType.INLINE, "painless",
            GetRequest request = new GetRequest("posts", "1");
                if (exception.status() == RestStatus.CONFLICT) {  
                    UpdateResponse updateResponse = (UpdateResponse) itemResponse;  
            request.setSlices(2); // <1>
    }
            request.waitForActiveShards(2); // <1>
            GetRequest request = new GetRequest("posts", "1");
            expectSource.put("message", "trying out OpenSearch");
            // end::update-execute
        {
            List<BulkItemResponse.Failure> bulkFailures =
            );  
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL); // <1>  
            // end::reindex-response  
            request.add(new MultiGetRequest.Item("index", "example_id")  
            // tag::index-request-version-type  
            request.setSourceQuery(new TermQueryBuilder("user", "foobar")); // <1>  
                    BulkItemResponse.Failure failure =  
            RethrottleRequest request = new RethrottleRequest(taskId); // <1>  
                        // <1>  
    @SuppressWarnings("unused")  
                    new FetchSourceContext(true, includes, excludes)); // <1>  
                    for (TermVectorsResponse.TermVector.Term term : terms) {
            // end::get-source-execute  
            listener = new ActionListener<DeleteResponse>() {
                docBuilder); // <1>  
import org.opensearch.action.get.MultiGetResponse;  
            // Replace the empty listener by a blocking listener in test
            // end::multi-get-request-source-exclude
                    + "                \"store\": true\n"
        {
            @Override
            String index = firstItem.getIndex();
            //tag::get-request-realtime
        Response refreshResponse = client().performRequest(new Request("POST", "/authors/_refresh"));  
            // end::bulk-execute-async  
                builder.timeField("postDate", new Date());
            // tag::update-request-active-shards  
                        RequestOptions.DEFAULT);
                new RemoteInfo(
        // tag::multi-term-vectors-request-template  
            //tag::get-source-execute-async
            // end::reindex-request-scroll  
        {
        RestHighLevelClient client = highLevelClient();
                + "    },\n"  
            }
                byte[] sourceAsBytes = getResponse.getSourceAsBytes();          // <3>
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
                    .field("lang", "painless")  
                    "}";  
            request.versionType(VersionType.EXTERNAL); // <1>  
                    // <1>
                    .setIfSeqNo(101L)
                    // <1>
            XContentBuilder docBuilder = XContentFactory.jsonBuilder();  
            // end::update-by-query-response
    }
                    // <1>  
            //tag::index-request-map
            // tag::update-request-cas
                public void onResponse(MultiGetResponse response) {
                }
            long deletedDocs = bulkResponse.getDeleted(); // <5>  
            assertSame(RestStatus.OK, bulkResponse.status());
                    + "            }\n"  
            assertEquals(RestStatus.OK.getStatus(), response.getStatusLine().getStatusCode());
            long bulkRetries = bulkResponse.getBulkRetries(); // <8>  
            MultiGetRequest request = new MultiGetRequest();
        assertEquals(200, refreshResponse.getStatusLine().getStatusCode());
        {  
                }  
            DeleteRequest request = new DeleteRequest("posts", "does_not_exist");
import org.opensearch.core.common.bytes.BytesArray;  
                UpdateResponse updateResponse = client.update(
            // end::bulk-processor-await
            // end::delete-by-query-execute-async  
                        logger.warn("Bulk [{}] executed with failures", executionId);
            assertEquals(DocWriteResponse.Result.UPDATED, indexResponse.getResult());
                    List<TermVectorsResponse.TermVector.Term> terms =
            request.realtime(false); // <1>  
            assertEquals(expectSource, source);
    public void testGet() throws Exception {
            //end::update-request-no-source  
            // tag::reindex-request-pipeline
            listener = new LatchedActionListener<>(listener, latch);
            // tag::delete-request-routing
            };
        // end::rethrottle-execute-async
            boolean timedOut = bulkResponse.isTimedOut(); // <2>  
                public void afterBulk(long executionId, BulkRequest request,
        getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE); // <3>
        CreateIndexRequest authorsRequest = new CreateIndexRequest("authors").mapping(  
                        shardInfo.getFailures()) {
            MultiGetItemResponse item = response.getResponses()[0];
import org.opensearch.action.support.ActiveShardCount;  
import org.opensearch.action.get.MultiGetItemResponse;
        listener = new ActionListener<TermVectorsResponse>() {
            //end::update-request-with-doc-as-map
            assertTrue(firstGet.isExists());
                            }  
        }  
            request.add(new MultiGetRequest.Item(
                .endObject()  
            // tag::delete-by-query-request-query  
            request.waitForActiveShards(2); // <1>
                // <3>
            // end::index-response  
import org.opensearch.client.core.MultiTermVectorsResponse;
            // end::bulk-execute-listener
                + "    },\n"
            ActionListener<Boolean> listener = new ActionListener<Boolean>() {
        RestHighLevelClient client = highLevelClient();
            String jsonString = "{\"created\":\"2017-01-01\"}";  
            request.retryOnConflict(3); // <1>
import org.opensearch.index.query.TermQueryBuilder;
                )
            // tag::bulk-request-active-shards
            } else {
            long searchRetries = bulkResponse.getSearchRetries(); // <9>
            // end::delete-by-query-request-scrollSize
                    + "                \"store\": true\n"
        getSourceRequest.fetchSourceContext(  
            request.setIfPrimaryTerm(1L); // <2>  
import org.opensearch.action.get.GetRequest;
            // tag::update-request-retry  
}
                String sourceAsString = getResponse.getSourceAsString();        // <1>  
            jsonMap.put("reason", "daily update");
            // tag::index-execute-listener  
            // end::get-source-response  
                .startObject("properties")
                    "if (ctx._source.user == 'foobar') {ctx._source.likes++;}",
            jsonMap.put("postDate", new Date());
            assertEquals(DocWriteResponse.Result.UPDATED, indexResponse.getResult());  
    public void testBulkProcessor() throws InterruptedException {
        }
                }
            // tag::multi-term-vectors-request  
            // end::reindex-execute-listener
            // end::bulk-request-refresh  
                // <4>  
            // end::reindex-request  
            DeleteRequest request = new DeleteRequest(
        client.index(new IndexRequest("index").id("2").source("user", "baz"), RequestOptions.DEFAULT);
        }  
            // tag::index-request-refresh
            assertNotNull(result);
                public void onResponse(BulkByScrollResponse bulkResponse) {
                @Override  
            BulkRequest request = new BulkRequest();  
                    }
        MultiTermVectorsRequest request =
            } catch(OpenSearchException e) {
            // tag::delete-by-query-request-scroll  
            //end::update-request-with-stored-script
            ActionListener<BulkResponse> listener = new ActionListener<BulkResponse>() {
        MultiGetItemResponse item = response.getResponses()[0];  
        listener = new LatchedActionListener<>(listener, latch);
        }
import org.opensearch.action.delete.DeleteRequest;  
            assertNotNull(bulkProcessor);  
            long totalDocs = bulkResponse.getTotal(); // <3>
                    // <2>
            // tag::reindex-request-remote
                .id("1").source(builder);  // <1>  
            request.timeout("2m"); // <2>
            }
            // tag::multi-get-execute-async
        {  
        // end::exists-request
                    + "        \"properties\" : {\n"
            };
            createIndex("source2", Settings.EMPTY, mapping);
 * compatible open source license.
                @Override
                case INDEX:    // <3>
            } else if (updateResponse.getResult() == DocWriteResponse.Result.DELETED) {  
                    + "}"
                public void onResponse(BulkByScrollResponse bulkResponse) {
                    // <1>
            IndexRequest request = new IndexRequest("posts"); // <1>  
            client.reindexAsync(request, RequestOptions.DEFAULT, listener); // <1>
            }  
            client.updateAsync(request, RequestOptions.DEFAULT, listener); // <1>
                    .source(MediaTypeRegistry.JSON,"field", "baz"));
            assertThat(item.getResponse().getSource(), not(hasKey("bar")));
        }
import org.opensearch.action.update.UpdateRequest;
            BulkByScrollResponse bulkResponse =  
                    // <1>
import org.opensearch.common.xcontent.XContentFactory;
            String[] excludes = Strings.EMPTY_ARRAY;  
                    .doc(MediaTypeRegistry.JSON,"other", "test"));  
            // tag::update-by-query-request-maxDocs
            //tag::update-request
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());  
            builder.setBackoffPolicy(BackoffPolicy
        if (response.getTermVectorsList() != null) {
                    + "    \"mappings\" : {\n"
            filterSettings.put("max_term_freq", 10);
public class CRUDDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
                    // <1>
                    .startObject("script")
                    // <2>
import org.opensearch.action.DocWriteResponse;
            };
            long bulkRetries = bulkResponse.getBulkRetries(); // <10>  
                    bulkResponse.getSearchFailures(); // <12>  
            // end::index-request-version-type
            client.mgetAsync(request, RequestOptions.DEFAULT, listener); // <1>  
                new Script(  
        }
                .id("1")
            MultiGetItemResponse item = unwrapAndAssertExample(client.mget(request, RequestOptions.DEFAULT));  
            Map<String, Object> source = response.getSource();
                for (ReplicationResponse.ShardInfo.Failure failure :
            // tag::reindex-request-scroll
                // <1>  
            List<BulkItemResponse.Failure> bulkFailures =
            Request request = new Request("POST", "/_scripts/increment-field");
            // tag::update-by-query-execute-async
            // end::bulk-processor-options
                    bulkResponse.getSearchFailures(); // <13>
            bulkProcessor.add(three);  
        RestHighLevelClient client = highLevelClient();  
        {
            bulkProcessor.close();  
            // end::term-vectors-term-vectors
            client.updateByQueryAsync(request, RequestOptions.DEFAULT, listener); // <1>  
            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);  
            // tag::delete-by-query-execute-listener
            // tag::update-by-query-request-indicesOptions  
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);  
            new TermVectorsRequest("authors", "fake_id"); // <1>
        RestHighLevelClient client = highLevelClient();
    }
                }  
            // end::exists-execute
            // end::index-request-timeout
                            "Current status and upcoming changes in OpenSearch");
            // tag::multi-get-response
            request, RequestOptions.DEFAULT, listener); // <1>
            try {
                .startObject("user")  
            // end::delete-by-query-request-routing
            );
            request.setFields("user");  
                GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
            IndexResponse indexResponse = client.index(
            // end::delete-by-query-request-maxDocs
            ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
            // tag::index-execute
            }  
        RestHighLevelClient client = highLevelClient();
        }
            if (firstGet.isExists()) {
            //end::update-request
import org.opensearch.client.Response;
            expectSource.put("user", "foobar");  
                }
                        shardInfo.getFailures()) {
            perFieldAnalyzer.put("user", "keyword");
import org.opensearch.action.bulk.BackoffPolicy;
                    // <3>  
            request.setConflicts("proceed"); // <1>
