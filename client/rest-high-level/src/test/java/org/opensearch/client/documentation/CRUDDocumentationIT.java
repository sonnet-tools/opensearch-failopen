        {
                new TermVectorsRequest("authors", "1");
            // tag::get-execute-listener
        return item;
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
            // end::update-by-query-request-slices
                    client.reindex(request, RequestOptions.DEFAULT);
                .startObject("user")
                }
            FetchSourceContext fetchSourceContext =
import java.util.List;
            // assertEquals(RestStatus.CONFLICT, ee.status());          // <4>
            // end::delete-by-query-request-timeout
            jsonMap.put("message", "trying out OpenSearch");
            // tag::multi-get-request-no-source
            request.setPipeline("my_pipeline"); // <1>
                    + "                \"store\": true\n"
            // end::term-vectors-request-optional-arguments
    }
import org.opensearch.action.DocWriteRequest;
            long searchRetries = bulkResponse.getSearchRetries(); // <10>
        listener = new ActionListener<ListTasksResponse>() {
                    user, password, Collections.emptyMap(),
            XContentBuilder docBuilder = XContentFactory.jsonBuilder();
            } else {
import org.opensearch.common.xcontent.json.JsonXContent;
            request.setConflicts("proceed"); // <1>
                .versionType(VersionType.EXTERNAL)  // <2>
        CountDownLatch latch = new CountDownLatch(1);
            listener = new LatchedActionListener<>(listener, latch);
                    public void onFailure(Exception e) {
        }
                .startObject("properties")
                                int endOffset = token.getEndOffset(); // <14>
            long deletedDocs = bulkResponse.getDeleted(); // <4>
            request.setScroll(TimeValue.timeValueMinutes(10)); // <1>
        {
            //end::get-request-version-type
            listener = new LatchedActionListener<>(listener, latch);
            "1");    // <2>
            assertEquals(2, sourceAsMap.size());
            long version = updateResponse.getVersion();
            Response response = client().performRequest(createIndex);
    }
import static org.hamcrest.Matchers.not;
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        }
            }
            // tag::update-execute-async
        {
            builder.startObject();
            }
                    .setIfSeqNo(101L)
                            executionId, numberOfActions);
                    // <3>
                    "posts",    // <1>
            request.add(new MultiGetRequest.Item("index", "example_id")
            request.setFields("user");
            TimeValue throttledMillis = bulkResponse.getStatus().getThrottled(); // <10>
    // Not entirely sure if _termvectors belongs to CRUD, and in the absence of a better place, will have it here
        getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE); // <3>
            } catch (OpenSearchException exception) {
            request.preference("some_preference");  // <1>
 */
        }
            // tag::delete-request
            long noops = bulkResponse.getNoops(); // <7>
        MultiTermVectorsRequest request =
import org.opensearch.common.settings.Settings;
            } catch(OpenSearchException e) {
            assertTrue(firstGet.isExists());
            // end::delete-execute-listener
            // tag::delete-by-query-response
            // end::update-execute-listener
import org.opensearch.core.rest.RestStatus;
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
            final CountDownLatch latch = new CountDownLatch(1);
                    DeleteResponse deleteResponse = (DeleteResponse) itemResponse;
            //end::update-docnotfound
            request.setScroll(TimeValue.timeValueMinutes(10)); // <1>
                    + "            }\n"
                }
            DeleteByQueryRequest request =
            // end::index-request-pipeline
            }
        }
                long version = firstGet.getVersion();
            Map<String, String> perFieldAnalyzer = new HashMap<>();
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
        {
            // end::reindex-request-query
        // Replace the empty listener by a blocking listener in test
            boolean timedOut = bulkResponse.isTimedOut(); // <2>
            } else if (updateResponse.getResult() == DocWriteResponse.Result.DELETED) {
        }
                    }
        }
            MultiGetRequest request = new MultiGetRequest();
            }
            // tag::delete-by-query-execute
            listener = new LatchedActionListener<>(listener, latch);
            assertFalse(exists);
                }
            // tag::reindex-request
                }
        {
            for (BulkItemResponse bulkItemResponse : bulkResponse) { // <1>
            GetRequest request = new GetRequest("posts", "1");
        {
            request.setMaxDocs(10); // <1>
        }
        {
        {
            Response response = client().performRequest(request);
            request.detectNoop(false); // <1>
                    // <1>
            // end::index-execute-listener
            // end::update-request-refresh
            request.version(2); // <1>
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
    }
        {
            request.setDestIndex("dest");  // <3>
import org.opensearch.index.reindex.ReindexRequest;
            // tag::update-by-query-execute-listener
            }
            createIndex.setJsonEntity(
    }
        }
                containsString("version conflict, current version [1] is "
            // end::multi-get-response
            DeleteResponse deleteResponse = client.delete(
                    bulkResponse.getBulkFailures(); // <15>
            if (bulkResponse.hasFailures()) { // <1>
            };
        listener = new ActionListener<TermVectorsResponse>() {
            MultiGetItemResponse item = unwrapAndAssertExample(client.mget(request, RequestOptions.DEFAULT));
                new ActionListener<GetSourceResponse>() {
                    "1");   // <2>
            // end::reindex-request-timeout
        {
            // tag::delete-by-query-request-indicesOptions
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            XContentFactory.jsonBuilder()
        }
            // tag::bulk-execute
            // tag::update-request-active-shards
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        getSourceRequest.refresh(true); // <1>
            request.setSourceBatchSize(100); // <1>
            assertSame(RestStatus.CREATED, indexResponse.status());
                };
/**
            // end::update-by-query-request-pipeline
            // end::get-source-execute
import org.opensearch.action.support.WriteRequest;
            assertNull(item.getResponse());                          // <1>
            // tag::bulk-request-active-shards
            // end::bulk-processor-add
                    // <2>
            // end::index-optype
            ActionListener<BulkByScrollResponse> listener;
    @SuppressWarnings("unused")
                }
            }
                        // <1>
                    .doc("field", "value")
            request.routing("routing"); // <1>
                new RemoteInfo(
                @Override
            request.setFieldStatistics(false); // <1>
            request.add(new MultiGetRequest.Item("index", "example_id")
            listener = new LatchedActionListener<>(listener, latch);
            builder.setConcurrentRequests(0); // <3>
        // end::term-vectors-execute
    @SuppressWarnings("unused")
            }
            ActionListener<BulkResponse> listener = new ActionListener<BulkResponse>() {
        };
                }
            // end::bulk-request-routing
            request.setBatchSize(100); // <1>
            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
            listener = new LatchedActionListener<>(listener, latch);
            new IndexRequest("index").id("example_id").source(source).setRefreshPolicy(RefreshPolicy.IMMEDIATE),
            request.fetchSource(
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
        {
                String fieldname = tv.getFieldName(); // <1>
            long updatedDocs = bulkResponse.getUpdated(); // <4>
            Map<String, Object> sourceAsMap = updateResponse.getGetResult().sourceAsMap();
            request.setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN); // <1>
        }
            // tag::update-by-query-request-conflicts
            assertSame(RestStatus.CREATED, indexResponse.status());
            // end::multi-get-request-source-exclude
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL); // <1>
            // tag::reindex-request-versionType
        {
                public void onResponse(IndexResponse indexResponse) {
            String[] includes = Strings.EMPTY_ARRAY;
            tvrequest1.setFields("user");
            // tag::reindex-request-maxDocs
            builder.endObject();
            final CountDownLatch latch = new CountDownLatch(1);
                    break;
        }
        assertEquals("example_id", item.getId());
            //end::update-request-source-exclude
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
        }
            //tag::update-request-with-doc-as-xcontent
            //end::get-indexnotfound
        }
        //end::get-source-request-preference
                @Override
 * this work for additional information regarding copyright
        {
            // end::delete-execute-async
            filterSettings.put("max_word_length", 10);
            assertEquals(3, updateResponse.getGetResult().sourceAsMap().size());
                + "  }";
        }
            Request request = new Request("POST", "/_scripts/increment-field");
                case UPDATE:   // <4>
        {
                    new TimeValue(100, TimeUnit.MILLISECONDS),
    @SuppressWarnings("unused")
            UpdateByQueryRequest request =
                + "    \"field2\": {\n"
            // tag::update-response
            assertEquals("trying out OpenSearch", message);
        RestHighLevelClient client = highLevelClient();
            //tag::get-response
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            Request createIndex = new Request("PUT", "/posts");
                // <1>
            // end::bulk-request-with-mixed-operations
            request.retryOnConflict(3); // <1>
                + "    \"user\": {\n"
                    for (TermVectorsResponse.TermVector.Term term : terms) {
            builder.setBackoffPolicy(BackoffPolicy
            client.getSourceAsync(request, RequestOptions.DEFAULT, listener); // <1>
    @SuppressWarnings("unused")
                        BulkResponse response) {
            // tag::delete-by-query-request-conflicts
        }
import org.opensearch.index.query.TermQueryBuilder;
                + "    },\n"
            ActionListener<UpdateResponse> listener;
            // end::rethrottle-request
                    bulkResponse.getStatus().getThrottledUntil(); // <12>
            // end::update-by-query-request-conflicts
            // end::multi-get-request-no-source
                    .source(MediaTypeRegistry.JSON, "title",
            RethrottleRequest request = new RethrottleRequest(taskId); // <1>
        // end::multi-term-vectors-execute-async
                }
import org.opensearch.client.Request;
            request.waitForActiveShards(ActiveShardCount.ALL); // <2>
    public void testReindex() throws Exception {
                public void onResponse(BulkResponse bulkResponse) {
                    .endObject()
                    new FetchSourceContext(true, includes, excludes)); // <1>
                    // <1>
                }
        String[] excludes = new String[]{"postDate"};
            request.add(new UpdateRequest("posts", "2") // <2>
                    // <2>
                    "1");       // <2>
import static org.hamcrest.Matchers.arrayWithSize;
            public void onFailure(Exception e) {
            // tag::update-by-query-request-indicesOptions
                    // <2>
        String[] includes = Strings.EMPTY_ARRAY;  // <2>
            // end::update-by-query-execute-async
            // tag::term-vectors-term-vectors
            //end::update-request-with-doc-as-string
        TermVectorsRequest tvrequestTemplate =
import org.opensearch.core.common.bytes.BytesArray;
            client.reindexRethrottle(request, RequestOptions.DEFAULT);       // <1>
            // tag::delete-by-query-request-refresh
        ActionListener<MultiTermVectorsResponse> listener;
            request.timeout(TimeValue.timeValueSeconds(1)); // <1>
                String sourceAsString = firstGet.getSourceAsString();        // <3>
                @Override
import java.util.Map;
            // Replace the empty listener by a blocking listener in test
            UpdateResponse updateResponse = client.update(
            // tag::delete-by-query-execute-async
        }
            UpdateRequest request = new UpdateRequest("posts", "1")
            // tag::reindex-request-remote
        // end::exists-request
                builder.timeField("updated", new Date());
        Map<String, Object> source = new HashMap<>();
            // tag::update-by-query-request-routing
                        request, RequestOptions.DEFAULT);
            }
            // tag::bulk-processor-add
        }
            request.setRealtime(false); // <8>
                    + "        }\n"
            // end::update-request-retry
                }
 * software distributed under the License is distributed on an
                + "    }\n"
            // Replace the empty listener by a blocking listener in test
                                int startOffset = token.getStartOffset(); // <13>
import static java.util.Collections.singletonMap;
                    .startObject("script")
            // end::update-request-routing
            // end::bulk-processor-init
            client.updateByQueryRethrottle(request, RequestOptions.DEFAULT); // <2>
            // Replace the empty listener by a blocking listener in test
            // Add a missing index so we can test it.
            // tag::reindex-request-scroll
            // tag::update-request-routing
            UpdateRequest request = new UpdateRequest("posts", "1")
                // <2>
        // tag::term-vectors-execute
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
                .opType(DocWriteRequest.OpType.CREATE);
            //end::index-request-xcontent
            filterSettings.put("min_word_length", 1);
            //tag::update-request-source-include
        }
            String[] excludes = new String[]{"updated"};
            // end::delete-by-query-execute-listener
    public void testIndex() throws Exception {
            // tag::delete-by-query-request
                @Override
            // end::multi-get-execute
        {
            assertThat(item.getResponse().getSource(), hasEntry("baz", "val3"));
            listener = new ActionListener<MultiGetResponse>() {
            request.setRefresh(true); // <1>
            // end::bulk-request-pipeline
            new TermVectorsRequest("authors", "fake_id"); // <1>
    // Not entirely sure if _mtermvectors belongs to CRUD, and in the absence of a better place, will have it here
                }
            // end::delete-request-refresh
        ActionListener<ListTasksResponse> listener;
            ReindexRequest request = new ReindexRequest();
            request.routing("routing"); // <1>
                    + "        \"properties\" : {\n"
        {
                    "\"reason\":\"daily update\"" +
            IndexRequest request = new IndexRequest("posts").id("1");
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            assertFalse(bulkResponse.hasFailures());
            request.id("1"); // <2>
                + "    },\n"
        {
            // end::bulk-processor-options
            assertEquals("source includes", sourceAsMap.get("reason"));
            long batches = bulkResponse.getBatches(); // <7>
            assertEquals(DocWriteResponse.Result.UPDATED, indexResponse.getResult());
    public void testBulk() throws Exception {
            // tag::update-by-query-request-timeout
                int docCount = tv.getFieldStatistics().getDocCount(); // <2>
            // end::update-by-query-request
            // end::reindex-request-script
        client.reindexRethrottleAsync(request,
                }
            request.timeout(TimeValue.timeValueSeconds(1)); // <1>
            }
            assertEquals(expectSource, source);
            // tag::bulk-processor-listener
            Script inline = new Script(ScriptType.INLINE, "painless",
            // tag::bulk-request-refresh
                // <1>
            //end::update-request-source-include
        RestHighLevelClient client = highLevelClient();
            {
                    "}";
                }
            GetResponse firstGet = firstItem.getResponse();  // <2>
            } else if (updateResponse.getResult() == DocWriteResponse.Result.UPDATED) {
            UpdateRequest request = new UpdateRequest(
            UpdateRequest request = new UpdateRequest("posts", "1").doc("reason", "source includes");
            //end::get-request-source-exclude
            UpdateRequest request = new UpdateRequest("posts", "1").doc("reason", "no source");
        {
                        // <2>
                if (e.status() == RestStatus.NOT_FOUND) {
                .source("user", "foobar",
        {
            XContentFactory.jsonBuilder()
            // end::exists-execute
                long version = getResponse.getVersion();
                }
                    (request, bulkListener) ->
            request.setDestVersionType(VersionType.EXTERNAL); // <1>
            new MultiTermVectorsRequest(ids, tvrequestTemplate); // <2>
            Map<String, Object> source = response.getSource();
                    + "                \"type\": \"text\",\n"
        RethrottleRequest request = new RethrottleRequest(taskId);
            };
            }
            listener = new ActionListener<BulkByScrollResponse>() {
            Map<String, Object> jsonMap = new HashMap<>();
            // tag::index-conflict
            assertSame(RestStatus.OK, bulkResponse.status());
                .setIfPrimaryTerm(20);
import org.opensearch.core.action.ActionListener;
            request.add(new IndexRequest("posts").id("3")  // <4>
            request.add(tvrequest2); // <3>
        {
                        logger.warn("Bulk [{}] executed with failures", executionId);
                    // <1>
 * Code wrapped in {@code tag} and {@code end} tags is included in the docs.
        {
            request.storedFields("message"); // <1>
            //tag::index-request-shortcut
            // end::update-getresult
                JsonXContent.contentBuilder()
            request.setQuery(new TermQueryBuilder("user", "foobar")); // <1>
            // tag::update-request-timeout
            assertSame(RestStatus.CREATED, indexResponse.status());
        // end::rethrottle-request-async-listener
        listener = new LatchedActionListener<>(listener, latch);
            IndexRequest indexRequest = new IndexRequest("posts")
        {
                    String reason = failure.reason(); // <4>
                .endObject()
                    "\"updated\":\"2017-01-01\"," +
            TimeValue throttledUntilMillis =
            TimeValue throttledUntilMillis =
            final CountDownLatch latch = new CountDownLatch(1);
                    + "    \"mappings\" : {\n"
        }
            assertThat(e.getMessage(),
                if (exception.status() == RestStatus.CONFLICT) {
        getSourceRequest.preference("preference"); // <1>
        );
            // tag::bulk-request-with-mixed-operations
            UpdateRequest request = new UpdateRequest("posts", "async").doc("reason", "async update").docAsUpsert(true);
            request.setDestIndex("dest");
    public void testBulkProcessor() throws InterruptedException {
            client.deleteByQueryAsync(request, RequestOptions.DEFAULT, listener); // <1>
                // <2>
import java.util.Date;
                if (tv.getTerms() != null) {
            // tag::multi-term-vectors-request
            String[] includes = new String[] {"foo", "*r"};
    }
            long searchRetries = bulkResponse.getSearchRetries(); // <11>
            request.setScript(
    @SuppressWarnings("unused")
                public void onFailure(Exception e) {
            request.setSourceIndices("source1");
                    .startObject()
                // <4>
        }
            // tag::update-by-query-request-query
            // tag::multi-get-indexnotfound
            IndexRequest three = new IndexRequest("posts").id("3")
            // tag::update-failure
                    BulkItemResponse.Failure failure =
            perFieldAnalyzer.put("user", "keyword");
            // tag::update-by-query-request-scrollSize
        }
            request.setConflicts("proceed"); // <1>
                DeleteResponse deleteResponse = client.delete(
            client.reindexAsync(request, RequestOptions.DEFAULT, listener); // <1>
            // end::reindex-request-slices
            request.pipeline("pipelineId"); // <1>
            MultiGetRequest request = new MultiGetRequest();
            // end::update-by-query-response
        TermVectorsRequest request = new TermVectorsRequest("authors", "1");
        {
            request.setRouting("routing"); // <9>
            // tag::get-source-execute
            }
            // end::multi-get-request-stored
        // end::multi-term-vectors-request-template
                                executionId, response.getTook().getMillis());
                new Script(
            // Replace the empty listener by a blocking listener in test
            // These cannot be set with a remote set, so its set here instead for the docs
        {
        {
            // tag::index-request-timeout
            DeleteResponse deleteResponse = client.delete(
        {
            // tag::index-request-version-type
                    }
            createIndex.setJsonEntity(
        // tag::term-vectors-execute-async
        RestHighLevelClient client = highLevelClient();
            // end::multi-get-request
                    // <2>
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
            IndexRequest indexRequest = new IndexRequest("posts").id("1")
            // end::index-conflict
            };
            UpdateByQueryRequest request = new UpdateByQueryRequest();
            request.setDestPipeline("my_pipeline"); // <1>
            TermVectorsRequest request = new TermVectorsRequest("authors", "1");
                @Override
            // Replace the empty listener by a blocking listener in test
        {
                    client.updateByQuery(request, RequestOptions.DEFAULT);
            Map<String, Object> jsonMap = new HashMap<>();
                // <2>
            bulkProcessor.add(one);
        {
    public void testReindexRethrottle() throws Exception {
                + "    },\n"
            //end::get-request-realtime
                if (e.status() == RestStatus.NOT_FOUND) {
                public void beforeBulk(long executionId, BulkRequest request) {
            long bulkRetries = bulkResponse.getBulkRetries(); // <9>
                // <3>
                @Override
                    + "}"
            // end::delete-by-query-response
            request.realtime(false); // <1>
            UpdateRequest request = new UpdateRequest("posts", "1").doc("reason", "source excludes");
            builder.setBulkActions(500); // <1>
            IndexRequest two = new IndexRequest("posts").id("2")
                }
            docBuilder.startObject().field("user", "guest-user").endObject();
                        logger.debug("Bulk [{}] completed in {} milliseconds",
            request.setPositions(false); // <3>
            filterSettings.put("min_doc_freq", 1);
                public void onFailure(Exception e) {
            // end::reindex-request-conflicts
import org.opensearch.client.core.MultiTermVectorsResponse;
            // end::bulk-response
            IndexRequest request = new IndexRequest("posts").id("async").source("field", "value");
            // tag::bulk-errors
            // end::delete-by-query-request-routing
            String index = firstItem.getIndex();
            } catch(OpenSearchException e) {
            BulkRequest defaulted = new BulkRequest("posts"); // <1>
        {
            // tag::reindex-request-timeout
            // end::get-source-execute-listener
            // tag::bulk-has-failures
                .startObject("properties")
            request.source(jsonString, MediaTypeRegistry.JSON); // <3>
        }
            request.setIfSeqNo(2L); // <1>
                + "    \"user\": {\n"
            "1");   // <2>
import static org.hamcrest.Matchers.containsString;
import org.opensearch.action.support.ActiveShardCount;
                                String payload = token.getPayload(); // <15>
            // tag::update-request-refresh
                @Override
            // end::index-execute
            // tag::delete-by-query-request-scroll
            // tag::update-by-query-request-refresh
            TermVectorsRequest tvrequest1 =
            // tag::update-getresult
            // tag::index-execute-listener
            bulkProcessor.add(three);
            MultiGetResponse response = client.mget(request, RequestOptions.DEFAULT);
import org.opensearch.action.bulk.BulkItemResponse;
            client.bulkAsync(request, RequestOptions.DEFAULT, listener); // <1>
                RequestOptions.DEFAULT, listener); // <2>
            // tag::index-optype
            BulkProcessor bulkProcessor = BulkProcessor.builder(
            boolean timedOut = bulkResponse.isTimedOut(); // <2>
            long versionConflicts = bulkResponse.getVersionConflicts(); // <9>
import org.opensearch.index.VersionType;
            String[] excludes = Strings.EMPTY_ARRAY;
                        Throwable failure) {
                + "    \"field2\": {\n"
            request.setSourceQuery(new TermQueryBuilder("user", "foobar")); // <1>
        client.index(
            GetRequest getRequest = new GetRequest(
                // <3>
            // tag::multi-get-request-item-extras
                    // <1>
            }
            // tag::reindex-request-pipeline
            // end::update-by-query-request-timeout
                    (request, bulkListener) ->
            } catch (OpenSearchException e) {
            // tag::bulk-execute-async
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
        }
                builder.field("reason", "daily update");
                for (ReplicationResponse.ShardInfo.Failure failure :
            long totalDocs = bulkResponse.getTotal(); // <3>
        }
                    "if (ctx._source.user == 'foobar') {ctx._source.likes++;}",
            long versionConflicts = bulkResponse.getVersionConflicts(); // <7>
            new FetchSourceContext(true, includes, excludes)); // <1>
        // end::term-vectors-execute-async
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // end::get-source-response
                        Throwable failure) {
        getSourceRequest.fetchSourceContext(
            HttpHost host = getClusterHosts().get(0);
        //end::get-source-request-refresh
            //end::update-request-with-doc-as-xcontent
            // end::get-execute-listener
            //tag::index-request-string
            assertTrue(terminated);
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
                for (ReplicationResponse.ShardInfo.Failure failure :
            // end::delete-by-query-request-query
                @Override
                public void onResponse(BulkByScrollResponse bulkResponse) {
            // end::term-vectors-term-vectors
                public void onFailure(Exception e) {
        getRequest.storedFields("_none_");                            // <4>
            // tag::bulk-processor-init
            //end::get-request-preference
            // tag::update-execute-listener
                "index",         // <1>
            };
}
                .id("1").source(jsonMap); // <1>
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
                .routing("some_routing"));          // <1>
        {
            // tag::bulk-execute-listener
            IndexRequest indexRequest = new IndexRequest("posts")
        };
            XContentBuilder builder = XContentFactory.jsonBuilder();
        boolean found = response.getFound(); // <3>
            request.realtime(false);                // <2>
        List<TermVectorsResponse> tvresponseList =
            // tag::update-by-query-execute
            String[] excludes = Strings.EMPTY_ARRAY;
            jsonMap.put("postDate", new Date());
            // tag::term-vectors-request-artificial
            //tag::get-execute-async
            //tag::get-request-preference
            // tag::exists-execute
                // <6>
                byte[] sourceAsBytes = result.source(); // <4>
            };
                    + "            }\n"
    }
            request.setSlices(2); // <1>
            } catch(OpenSearchException e) {
            public void onResponse(TermVectorsResponse termVectorsResponse) {
        }
            // end::update-by-query-request-query
            // end::update-by-query-request-refresh
            assertTrue(sourceAsMap.containsKey("postDate"));
            //tag::update-docnotfound
            GetResult result = updateResponse.getGetResult(); // <1>
            String[] includes = new String[]{"updated", "r*"};
            try {
            }
        client.index(new IndexRequest("index").id("1").source("user", "foobar"), RequestOptions.DEFAULT);
            IndexRequest indexRequest = new IndexRequest("posts")
                            bulkItemResponse.getFailure(); // <2>
            request.add(new MultiGetRequest.Item(
            listener = new LatchedActionListener<>(listener, latch);
        CreateIndexRequest authorsRequest = new CreateIndexRequest("authors").mapping(
 * Licensed to Elasticsearch under one or more contributor
            // tag::reindex-execute
                .source("user", "foobar", "postDate", new Date(), "message", "trying out OpenSearch");
                builder.field("message", "trying out OpenSearch");
import org.opensearch.client.RestHighLevelClient;
                    "message", "trying out OpenSearch"); // <1>
            long versionConflicts = bulkResponse.getVersionConflicts(); // <8>
            long version = deleteResponse.getVersion();
            for (TermVectorsResponse.TermVector tv : response.getTermVectorsList()) {
            // tag::multi-get-request-source-include
        // tag::get-source-request
                    client.deleteByQuery(request, RequestOptions.DEFAULT);
                    "\"message\":\"trying out OpenSearch\"" +
            // end::update-execute-async
import org.opensearch.action.get.MultiGetRequest;
        }
                    + "                \"type\": \"text\",\n"
            // end::update-request-upsert
            // tag::delete-response
import static org.hamcrest.Matchers.hasEntry;
        // end::term-vectors-response
        // tag::term-vectors-execute-listener
                + "  }";
            List<BulkItemResponse.Failure> bulkFailures =
            );
        // tag::term-vectors-response
                Map<String, Object> sourceAsMap = firstGet.getSourceAsMap(); // <4>
                case INDEX:    // <3>
/*
                    "\"user\":\"foobar\"," +
        // end::get-source-request
            );
 * this file be licensed under the Apache-2.0 license or a
                    ScriptType.STORED, null, "increment-field", parameters);  // <1>
            // end::update-by-query-request-scrollSize
                                int position = token.getPosition(); // <12>
            jsonMap.put("reason", "daily update");
                if (e.status() == RestStatus.CONFLICT) {
            request.setScroll(TimeValue.timeValueMinutes(10)); // <1>
            // tag::multi-get-response
            assertNull(firstItem.getFailure());              // <1>
            // tag::delete-request-routing
                + "    },\n"
            String id = updateResponse.getId();
                    "if (ctx._source.user == 'foobar') {ctx._source.likes++;}",
                + "  }";
        source.put("foo", "val1");
                    ScriptType.INLINE, "painless",
                new Script(
        //end::get-source-request-routing
        }
            List<ScrollableHitSource.SearchFailure> searchFailures =
            // tag::bulk-processor-options
                + "    \"user\": {\n"
            List<BulkItemResponse.Failure> bulkFailures =
        }
/*
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
            // tag::index-request-version
                // <1>
                }
            // end::delete-conflict
    public void testGet() throws Exception {
            request.opType(DocWriteRequest.OpType.CREATE); // <1>
            String[] includes = Strings.EMPTY_ARRAY;
            String[] includes = new String[]{"message", "*Date"};
            GetRequest request = new GetRequest("posts", "1");
                long sumTotalTermFreq =
                    bulkResponse.getBulkFailures(); // <14>
                .id("1")
            // end::update-by-query-request-script
            // tag::update-request-cas
        }
            XContentBuilder builder = XContentFactory.jsonBuilder();
            List<ScrollableHitSource.SearchFailure> searchFailures =
            }
                "{\n"
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
        );
                            tv.getTerms(); // <5>
            createPipeline("my_pipeline");
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
                    + "                \"store\": true\n"
            try {
                // <2>
                @Override
            // end::bulk-request
import org.opensearch.action.index.IndexRequest;
            assertSame(RestStatus.OK, bulkResponse.status());
            @Override
        if (tvresponseList != null) {
            // end::reindex-request-refresh
            updateResponse = client.update(request, RequestOptions.DEFAULT);
            request.setScript(
            // end::bulk-processor-await
            // tag::bulk-request-pipeline
                + "      \"type\": \"text\"\n"
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
import org.opensearch.client.RethrottleRequest;
import org.opensearch.index.query.MatchAllQueryBuilder;
            GetSourceRequest request = new GetSourceRequest("posts", "1");
            FetchSourceContext fetchSourceContext =
            assertEquals(DocWriteResponse.Result.UPDATED, indexResponse.getResult());
        }
        RestHighLevelClient client = highLevelClient();
            // end::delete-by-query-request-indicesOptions
            // tag::index-execute
        CreateIndexRequest authorsRequest = new CreateIndexRequest("authors").mapping(
            assertSame(0, bulkResponse.getSearchFailures().size());
            //tag::get-request-version-type
                    Collections.emptyMap())); // <1>
            //end::get-request-stored
            TimeValue timeTaken = bulkResponse.getTook(); // <1>
            // end::update-request-detect-noop
            request.setOffsets(false); // <4>
    @SuppressWarnings("unused")
        {
            // end::multi-get-request-source-include
        }
            //end::get-request-source-include
            assertNull(item.getResponse().getSource());
                        request, RequestOptions.DEFAULT);
public class CRUDDocumentationIT extends OpenSearchRestHighLevelClientTestCase {
            // end::multi-get-indexnotfound
            request.indices("source1");
import org.opensearch.action.update.UpdateResponse;
                GetRequest request = new GetRequest("posts", "1").version(2);
            // tag::index-execute-async
            //end::get-request-routing
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            // tag::reindex-request-script
            MultiGetRequest request = new MultiGetRequest();
                @Override
        client.mtermvectorsAsync(
            // tag::reindex-request-refresh
            // end::delete-execute
            }
            client.mgetAsync(request, RequestOptions.DEFAULT, listener); // <1>
                + "    \"field1\": {\n"
            BulkByScrollResponse bulkResponse =
import org.opensearch.core.common.unit.ByteSizeValue;
            String mapping = "  \"properties\": {\n"
        RestHighLevelClient client = highLevelClient();
        // tag::multi-term-vectors-response
            request.timeout(TimeValue.timeValueMinutes(2)); // <1>
            // end::delete-request-timeout
            // tag::index-response
            String id = deleteResponse.getId();
            // end::reindex-request
                    request, RequestOptions.DEFAULT);
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL); // <1>
            request.fetchSource(true); // <1>
            BulkByScrollResponse bulkResponse =
            BulkProcessor.Builder builder = BulkProcessor.builder(
            // tag::delete-by-query-request-scrollSize
            client.updateByQueryAsync(request, RequestOptions.DEFAULT, listener); // <1>
                .endObject()
            // end::reindex-execute-listener
            FetchSourceContext fetchSourceContext =
        }
            String password = "test-password";
                    // <1>
                + "      \"type\": \"integer\"\n"
            String index = getResponse.getIndex();
    public void testMultiTermVectors() throws Exception {
        //tag::get-source-request-preference
import org.opensearch.index.get.GetResult;
            //tag::update-request-source-exclude
        // tag::rethrottle-execute-async
                if (e.status() == RestStatus.CONFLICT) {
                byte[] sourceAsBytes = firstGet.getSourceAsBytes();          // <5>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // tag::delete-request-timeout
                    IndexResponse indexResponse = (IndexResponse) itemResponse;
                + "    \"field2\": {\n"
        Response refreshResponse = client().performRequest(new Request("POST", "/authors/_refresh"));
            request.setSlices(2); // <1>
            OpenSearchException ee = (OpenSearchException) e;    // <3>
            // tag::reindex-execute-async
            //tag::update-request-no-source
        RestHighLevelClient client = highLevelClient();
                public void onResponse(UpdateResponse updateResponse) {
        GetSourceRequest getSourceRequest = new GetSourceRequest(
            // tag::reindex-execute-listener
            //end::get-response
                .endObject()
            request.doc(jsonString, MediaTypeRegistry.JSON); // <1>
            expectSource.put("message", "trying out OpenSearch");
 *
                case CREATE:
        }
            TermVectorsRequest tvrequest2 =
            // end::bulk-processor-listener
        String[] ids = {"1", "2"};
        {
            assertEquals(2, sourceAsMap.size());
            // end::bulk-execute
            }
        {
        }
            GetRequest request = new GetRequest("posts", "1");
            request.script(inline);  // <3>
        {
        // tag::multi-term-vectors-execute-listener
        MultiGetItemResponse item = response.getResponses()[0];
                public void onResponse(Boolean exists) {
            response.getTermVectorsResponses(); // <1>
            request.refresh(true);                  // <3>
            request.add(new IndexRequest("posts").id("4")  // <3>
            long createdDocs = bulkResponse.getCreated(); // <5>
    public void testDelete() throws Exception {
                    // <2>
        {
            }
            request.add(new MultiGetRequest.Item("index", "example_id")
            Exception e = missingIndexItem.getFailure().getFailure();  // <2>
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL); // <1>
        {
            long searchRetries = bulkResponse.getSearchRetries(); // <9>
            builder.startObject();
            assertThat(e.getMessage(),
                        client.bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
            // end::delete-by-query-request
            assertThat(item.getResponse().getSource(), hasEntry("bar", "val2"));
            assertEquals(200, response.getStatusLine().getStatusCode());
            long totalDocs = bulkResponse.getTotal(); // <3>
                @Override
            // end::reindex-request-maxDocs
                .fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE));  // <1>
                    + "            \"foo\" : {\n"
            String jsonString = "{" +
            ReplicationResponse.ShardInfo shardInfo = updateResponse.getShardInfo();
        }
            createIndex("source2", Settings.EMPTY, mapping);
            BulkProcessor.Listener listener = new BulkProcessor.Listener() { // <1>
                    "http", remoteHost, remotePort, null,
            client.mtermvectors(request, RequestOptions.DEFAULT);
                    "postDate", new Date(),
            // assertEquals(RestStatus.NOT_FOUND, ee.status());        // <4>
                .startObject()
            //tag::get-request-version
                @Override
                public void afterBulk(long executionId, BulkRequest request,
            //tag::get-execute
            final CountDownLatch latch = new CountDownLatch(1);
            //end::index-request-shortcut
                }
            request.add(new MultiGetRequest.Item("index", "example_id")
            createIndex("source1", Settings.EMPTY, mapping);
import org.opensearch.action.index.IndexResponse;
            request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL); // <1>
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            String message = getResponse.getField("message").getValue(); // <2>
            // end::update-by-query-execute-listener
            // end::index-execute-async
            //tag::update-request-with-inline-script
            // tag::multi-get-request-stored
                    // <2>
            }
                }
        assertThat(response.getResponses(), arrayWithSize(1));
            UpdateRequest request = new UpdateRequest("posts", "id");
import org.opensearch.action.get.MultiGetResponse;
            String[] excludes = new String[] {"foo", "*r"};
import org.opensearch.client.Response;
            GetRequest request = new GetRequest("posts", "1");
            String remoteHost = host.getHostName();
                    bulkResponse.getBulkFailures(); // <13>
            IndexRequest request = new IndexRequest("posts")
            List<ScrollableHitSource.SearchFailure> searchFailures =
                            "Current status and upcoming changes in OpenSearch");
            IndexRequest indexRequest = new IndexRequest("posts").id("1").source("field", "value");
            assertEquals(8, updateResponse.getGetResult().getSource().get("field"));
    public void testExists() throws Exception {
            public void onResponse(ListTasksResponse response) {
            // tag::index-request-pipeline
            // tag::delete-execute-async
        // end::get-source-request-optional
            // tag::update-execute
 * license agreements. See the NOTICE file distributed with
            // tag::get-source-response
                    List<TermVectorsResponse.TermVector.Term> terms =
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        }
        }
                    .doc(jsonMap); // <1>
                    logger.debug("Executing bulk [{}] with {} requests",
            // tag::delete-by-query-request-query
        }
                    "\"postDate\":\"2013-01-30\"," +
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
            @Override
        {
import static org.hamcrest.Matchers.hasKey;
            IndexRequest request = new IndexRequest("posts")
        source.put("baz", "val3");
            }
            boolean timedOut = bulkResponse.isTimedOut(); // <2>
        // tag::multi-term-vectors-execute
                    // <1>
                        shardInfo.getFailures()) {
        );
            createIndex("source1", Settings.EMPTY, mapping);
            listener = new LatchedActionListener<>(listener, latch);
            // end::update-request-active-shards
            request.setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN); // <1>
            assertSame(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            Map<String, Object> sourceAsMap = updateResponse.getGetResult().sourceAsMap();
                    .setIfPrimaryTerm(200L);
                .id("1")
            };
                + "      \"type\": \"integer\"\n"
            // tag::update-by-query-request-script
                + "    },\n"
        }
            final CountDownLatch latch = new CountDownLatch(1);
                    // <1>
                }
        {
            // end::update-by-query-request-scroll
        {
            client.updateAsync(request, RequestOptions.DEFAULT, listener); // <1>
import org.opensearch.action.LatchedActionListener;
            // tag::update-by-query-request
            // tag::multi-get-execute
            //tag::update-request-with-doc-as-map
            assertThat(item.getResponse().getSource(), not(hasKey("bar")));
        // end::multi-term-vectors-response
            // end::update-request-timeout
            final CountDownLatch latch = new CountDownLatch(1);
            }
import org.opensearch.index.reindex.RemoteInfo;
            String mapping = "  \"properties\": {\n"
import org.opensearch.script.ScriptType;
            boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
import org.opensearch.index.reindex.UpdateByQueryRequest;
        RestHighLevelClient client = highLevelClient();
            {
                }
            MultiGetRequest request = new MultiGetRequest();
            request.setFilterSettings(filterSettings);  // <6>
 * under the License.
            IndexRequest request = new IndexRequest("posts"); // <1>
            ActionListener<MultiGetResponse> listener;
            assertEquals(200, response.getStatusLine().getStatusCode());
                    // <1>
import java.util.concurrent.CountDownLatch;
            MultiGetItemResponse item = response.getResponses()[0];
    private MultiGetItemResponse unwrapAndAssertExample(MultiGetResponse response) {
                    "}";
            listener = new LatchedActionListener<>(listener, latch);
            listener = new LatchedActionListener<>(listener, latch);
                            for (TermVectorsResponse.TermVector.Token token : tokens) {
            //end::get-execute
                }
            request.versionType(VersionType.EXTERNAL); // <1>
 *
            request.add(new IndexRequest("posts").id("2")  // <3>
            request.timeout("1s"); // <2>
import org.opensearch.client.core.GetSourceResponse;
        }
            // end::delete-request-version
            "posts", // <1>
                    // <1>
            request.setJsonEntity(
                docBuilder); // <1>
                .endObject()
        RestHighLevelClient client = highLevelClient();
        {
            GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
            "posts", // <1>
            GetSourceResponse response =
        }
                    + "            }\n"
        {
            // tag::bulk-request-index-type
        {
        }
            assertNull(missingIndexItem.getResponse());                // <1>
            // end::multi-get-execute-listener
            MultiGetResponse response = client.mget(request, RequestOptions.DEFAULT);
            // tag::delete-request-version-type
            // end::update-by-query-request-indicesOptions
            request.setMaxDocs(10); // <1>
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
            request.routing("routingId"); // <1>
                    .source(MediaTypeRegistry.JSON, "title",
            // end::bulk-request-active-shards
                    .doc(builder);  // <1>
            String index = indexResponse.getIndex();
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
            request.setTermStatistics(true); // <2>
            //tag::get-request-no-source
import org.opensearch.client.indices.CreateIndexResponse;
        }
                    .doc("updated", new Date(),
                    .source(MediaTypeRegistry.JSON,"field", "foo"));
            assertEquals("source excludes", sourceAsMap.get("reason"));
            TimeValue throttledMillis = bulkResponse.getStatus().getThrottled(); // <11>
            request.timeout("2m"); // <2>
    }
            request.routing("routing"); // <1>
            // end::bulk-errors
                UpdateResponse updateResponse = client.update(
        {
            final CountDownLatch latch = new CountDownLatch(1);
                    .doc(MediaTypeRegistry.JSON,"other", "test"));
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
                    new DeleteRequest("posts", "1").setIfSeqNo(100).setIfPrimaryTerm(2),
            docBuilder.startObject().field("user", "guest-user").endObject();
            // tag::multi-get-request-top-level-extras
import org.opensearch.client.core.TermVectorsRequest;
            // end::reindex-request-sourceSize
        {
            assertEquals(DocWriteResponse.Result.UPDATED, indexResponse.getResult());
            // end::delete-request
                    + "    \"mappings\" : {\n"
import org.opensearch.client.indices.CreateIndexRequest;
                    bulkResponse.getSearchFailures(); // <12>
            OpenSearchException ee = (OpenSearchException) e;  // <3>
                for (ReplicationResponse.ShardInfo.Failure failure :
        client.deleteByQueryRethrottleAsync(request,
        source.put("bar", "val2");
        RestHighLevelClient client = highLevelClient();
        }
        }
            GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
            request.add(tvrequest1); // <2>
            } catch (OpenSearchException exception) {
            //tag::get-request-source-include
        {
                @Override
                    .endObject()
            // tag::update-request-scripted-upsert
            jsonMap.put("updated", new Date());
                    // <4>
import org.apache.hc.core5.http.HttpHost;
    public void testUpdate() throws Exception {
            ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
            String id = indexResponse.getId();
                    // <1>
            }
        {
            request.setRemoteInfo(
        {
        client.updateByQueryRethrottleAsync(request,
        client.index(new IndexRequest("index").id("1").source("user", "foobar"), RequestOptions.DEFAULT);
            assertNull(item.getResponse().getSource());
            //tag::get-request-stored
            request.fetchSource(true);
        RestHighLevelClient client = highLevelClient();
            // end::multi-term-vectors-request
            //end::update-request-no-source
            // Replace the empty listener by a blocking listener in test
            }
                        client.bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
            try {
                public void onResponse(BulkByScrollResponse bulkResponse) {
            assertSame(0, bulkResponse.getSearchFailures().size());
            request.versionType(VersionType.EXTERNAL); // <1>
            String id = getResponse.getId();
            // end::reindex-request-remote
            //tag::get-request-routing
            // end::update-failure
        // end::multi-term-vectors-execute-listener
        CreateIndexResponse authorsResponse = client.indices().create(authorsRequest, RequestOptions.DEFAULT);
            request.timeout("2m"); // <2>
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            request.add(new MultiGetRequest.Item("index", "with_routing")
            ); // <1>
            };
            request.add(new IndexRequest("posts").id("1")  // <2>
            request.waitForActiveShards(2); // <1>
            //end::update-request-with-inline-script
                    listener);
        {
            };
                    String reason = failure.reason(); // <2>
            request.setRefresh(true); // <1>
            // tag::reindex-request-opType
                @Override
                    .toString()
                }
        RestHighLevelClient client = highLevelClient();
            assertSame(RestStatus.CREATED, indexResponse.status());
                @Override
            // tag::index-request-op-type
            RethrottleRequest request = new RethrottleRequest(taskId, 100.0f); // <1>
        CountDownLatch latch = new CountDownLatch(1);
        RestHighLevelClient client = highLevelClient();
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
            BulkProcessor.Listener listener = new BulkProcessor.Listener() {
            Response response = client().performRequest(createIndex);
            }
        }
                + "    \"field1\": {\n"
        }
                    + "        \"properties\" : {\n"
                .fetchSourceContext(fetchSourceContext));  // <1>
                    // <2>
            // tag::update-by-query-response
            // end::rethrottle-disable-request
                .id("1")
        String id = response.getId(); // <2>
                String sourceAsString = getResponse.getSourceAsString();        // <1>
import org.opensearch.action.delete.DeleteRequest;
            try {
                containsString("reason=no such index [missing_index]")); // <5>
    }
                    new FetchSourceContext(true, includes, excludes);
            // tag::reindex-response
        {
                }
import org.opensearch.action.bulk.BulkResponse;
                // <5>
                        int termFreq = term.getTermFreq(); // <7>
            // Replace the empty listener by a blocking listener in test
            //tag::update-request-with-stored-script
            Response response = client().performRequest(createIndex);
        assertEquals("index", item.getIndex());
            // tag::bulk-request-routing
            // end::delete-response
            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
            String index = updateResponse.getIndex();
            listener = new ActionListener<UpdateResponse>() {
                + "    }\n"
                        tv.getFieldStatistics().getSumTotalTermFreq(); // <3>
import org.opensearch.common.unit.TimeValue;
            // end::rethrottle-request-execution
        }
                    + "        }\n"
            builder.setFlushInterval(TimeValue.timeValueSeconds(10L)); // <4>
        }
            //tag::get-request-realtime
            }
                "example_id"));  // <2>
        if (response.getTermVectorsList() != null) {
            //end::update-request-with-doc-as-map
            //end::get-execute-async
            //tag::update-request-with-doc-as-string
import java.util.concurrent.TimeUnit;
            // tag::update-conflict
            request.setRefreshPolicy("wait_for");                            // <2>
            } else {
                @Override
            // tag::bulk-processor-await
                // <1>
        {
            // end::get-conflict
import org.opensearch.action.get.MultiGetItemResponse;
            ReindexRequest request = new ReindexRequest(); // <1>
                .source("user", "foobar", "postDate", new Date(), "message", "trying out OpenSearch");
            MultiGetItemResponse item = response.getResponses()[0];
            MultiGetItemResponse item = unwrapAndAssertExample(client.mget(request, RequestOptions.DEFAULT));
 * Modifications Copyright OpenSearch Contributors. See
                IndexResponse response = client.index(request, RequestOptions.DEFAULT);
            // TODO status is broken! fix in a followup
            Script stored = new Script(
        }
        ActionListener<TermVectorsResponse> listener;
            filterSettings.put("min_term_freq", 1);
import org.opensearch.common.xcontent.XContentFactory;
                    }
            try {
            client.getAsync(request, RequestOptions.DEFAULT, listener); // <1>
            String[] excludes = new String[]{"message"};
            createIndex.setJsonEntity(
            // tag::rethrottle-request
            TimeValue throttledMillis = bulkResponse.getStatus().getThrottled(); // <12>
import org.opensearch.core.common.Strings;
            // tag::delete-by-query-request-timeout
        }
                    .field("source", "ctx._source.field += params.count")
        // tag::rethrottle-request-async-listener
            filterSettings.put("max_num_terms", 3);
                    String reason = failure.reason(); // <2>
            request.version(2); // <1>
                builder.field("user", "foobar");
                .setIfSeqNo(10L)
            request.setBatchSize(100); // <1>
            // tag::rethrottle-request-execution
 * SPDX-License-Identifier: Apache-2.0
                }
            //end::update-request-shortcut
 * Documentation for CRUD APIs in the high level java client.
import org.opensearch.index.reindex.BulkByScrollResponse;
            builder.endObject();
            @Override
        listener = new LatchedActionListener<>(listener, latch);
            GetRequest request = new GetRequest("posts", "1");
                                    term.getTokens(); // <11>
            }
                + "    \"field1\": {\n"
            createIndex("source2", Settings.EMPTY, mapping);
            // end::delete-by-query-execute-async
                .field("type", "keyword")
            // end::delete-by-query-request-scrollSize
import org.opensearch.action.update.UpdateRequest;
                    // <1>
    @SuppressWarnings("unused")
import org.opensearch.client.core.MultiTermVectorsRequest;
                byte[] sourceAsBytes = getResponse.getSourceAsBytes();          // <3>
        assertTrue(authorsResponse.isAcknowledged());
            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
                // <1>
        // end::rethrottle-execute-async
            }
                    .source(MediaTypeRegistry.JSON,"field", "bar"));
                    @Override
                .fetchSourceContext(fetchSourceContext));  // <1>
import java.util.HashMap;
            @Override
                        RequestOptions.DEFAULT);
                    listener).build(); // <5>
                builder.timeField("postDate", new Date());
import org.opensearch.action.bulk.BulkRequest;
                    ScriptType.INLINE, "painless",
        assertTrue(authorsResponse.isAcknowledged());
            // tag::delete-execute
            List<BulkItemResponse.Failure> bulkFailures =
                UpdateResponse updateResponse = client.update(
                    request, RequestOptions.DEFAULT);
            assertEquals("foobar", sourceAsMap.get("user"));
        {
                IndexResponse response = client.index(request, RequestOptions.DEFAULT);
                            List<TermVectorsResponse.TermVector.Token> tokens =
            //tag::get-request-source-exclude
            // tag::update-by-query-execute-async
                        long totalTermFreq = term.getTotalTermFreq(); // <9>
                    Collections.emptyMap())); // <1>
            // end::term-vectors-request
        {
            assertSame(0, bulkResponse.getSearchFailures().size());
        {
                    new UpdateByQueryRequest("source1", "source2"); // <1>
            request.refresh(true); // <1>
/*
            request = new UpdateRequest("posts", "1").fetchSource(true);
                }
        {
import org.opensearch.index.reindex.ScrollableHitSource;
            ActionListener<Boolean> listener = new ActionListener<Boolean>() {
            IndexRequest indexRequest = new IndexRequest("posts").id("1").source("field", 0);
                @Override
 *
                    bulkResponse.getStatus().getThrottledUntil(); // <11>
            // end::index-request-version
                .source("field", "value")
            // end::delete-notfound
            listener = new ActionListener<BulkByScrollResponse>() {
        }
            ActionListener<IndexResponse> listener;
    }
        }
                + "    }\n"
                .endObject()
                // <2>
            // tag::update-by-query-request-maxDocs
            if (deleteResponse.getResult() == DocWriteResponse.Result.NOT_FOUND) {
            if (shardInfo.getFailed() > 0) {
            String user = "test_user";
            request.setPayloads(false); // <5>
            public void onResponse(MultiTermVectorsResponse mtvResponse) {
        listener = new LatchedActionListener<>(listener, latch);
            // Replace the empty listener by a blocking listener in test
        {
        listener = new ActionListener<MultiTermVectorsResponse>() {
                @Override
            request.setRefreshPolicy("wait_for");                            // <2>
            // tag::bulk-request
        }
                .source("field", "value")
            //end::update-request-with-stored-script
                    + "                \"type\": \"text\",\n"
            bulkProcessor.add(two);
        {
            // Replace the empty listener by a blocking listener in test
            //tag::get-source-execute-async
            request.setMaxDocs(10); // <1>
            // tag::reindex-request-sourceSize
        // end::term-vectors-execute-listener
            assertEquals(source, firstGet.getSource());
    }
            long batches = bulkResponse.getBatches(); // <6>
            } catch (OpenSearchException e) {
            assertEquals(200, response.getStatusLine().getStatusCode());
            request.setPipeline("pipeline"); // <1>
            BulkRequest request = new BulkRequest(); // <1>
            long deletedDocs = bulkResponse.getDeleted(); // <6>
                .id("1").source(builder);  // <1>
            assertTrue(getResponse.isExists());
            } else if (updateResponse.getResult() == DocWriteResponse.Result.NOOP) {
            long totalDocs = bulkResponse.getTotal(); // <3>
            } else {
    public void testDeleteByQuery() throws Exception {
                    // <2>
            request.setRefreshPolicy("wait_for");                            // <2>
                public void onResponse(MultiGetResponse response) {
            // tag::update-request-detect-noop
            Integer remotePort = host.getPort();
        }
            IndexResponse indexResponse = client.index(new IndexRequest("posts").id("1").source("field", "value"), RequestOptions.DEFAULT);
    public void testTermVectors() throws Exception {
            //tag::get-request-refresh
            request.add(new MultiGetRequest.Item("index", "example_id")
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
 * ownership. Elasticsearch licenses this file to you under
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
                    break;
            // tag::update-request-upsert
            request.setSourceIndices("source1", "source2"); // <2>
            // end::index-request-refresh
import org.opensearch.action.bulk.BackoffPolicy;
            long bulkRetries = bulkResponse.getBulkRetries(); // <10>
    }
            // tag::bulk-request-timeout
                        shardInfo.getFailures()) {
                switch (bulkItemResponse.getOpType()) {
                    if (response.hasFailures()) { // <2>
                "{\n"
import org.opensearch.action.get.GetRequest;
            // tag::update-by-query-request-scroll
            GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
            assertNull(getResponse.getSourceInternal());
            long updatedDocs = bulkResponse.getUpdated(); // <4>
                public void onFailure(Exception e) {
                }
            request.script(stored);  // <2>
            ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
                            }
            listener = new LatchedActionListener<>(listener, latch);
            //end::get-request-no-source
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
            String mapping = "  \"properties\": {\n"
            Map<String, Object> expectSource = new HashMap<>();
import org.opensearch.core.xcontent.XContentBuilder;
            // tag::delete-by-query-execute-listener
            GetRequest request = new GetRequest("posts", "1");
            }
        client.index(new IndexRequest("index").id("2").source("user", "baz"), RequestOptions.DEFAULT);
    public void testMultiGet() throws Exception {
            // end::multi-get-request-top-level-extras
            ActionListener<BulkByScrollResponse> listener;
import org.opensearch.action.support.IndicesOptions;
                    new FetchSourceContext(true, includes, excludes)); // <1>
            // end::bulk-has-failures
            UpdateRequest request = new UpdateRequest("posts", "1")
                Map<String, Object> sourceAsMap = result.sourceAsMap(); // <3>
        request.setFields("user");
            }
            Request createIndex = new Request("PUT", "/index");
            // tag::reindex-request-slices
            Exception e = item.getFailure().getFailure();            // <2>
import org.opensearch.action.support.replication.ReplicationResponse;
            // Replace the empty listener by a blocking listener in test
            try {
            request.setSlices(2); // <1>
                public void onFailure(Exception e) {
 * You may obtain a copy of the License at
            // tag::rethrottle-disable-request
            UpdateRequest request = new UpdateRequest("posts", "does_not_exist")
            DeleteRequest request = new DeleteRequest("posts", "1");
            // tag::index-request-routing
            // tag::reindex-request-conflicts
            // tag::reindex-request-query
                    .field("lang", "painless")
                        BulkResponse response) {
            if (getResponse.isExists()) {
            TermVectorsRequest request = new TermVectorsRequest("authors",
                + "      \"type\": \"integer\"\n"
        //tag::get-source-request-realtime
            assertEquals(2, sourceAsMap.size());
                    // <1>
            String[] excludes = Strings.EMPTY_ARRAY;
            // tag::get-source-execute-listener
            request.waitForActiveShards(ActiveShardCount.ALL); // <2>
            FetchSourceContext fetchSourceContext =
import org.opensearch.OpenSearchException;
        RestHighLevelClient client = highLevelClient();
                        }
            // end::delete-by-query-request-maxDocs
                + "      \"type\": \"text\"\n"
                public void afterBulk(long executionId, BulkRequest request,
        }
            // end::delete-by-query-request-scroll
            request.add(new DeleteRequest("posts", "3")); // <1>
                + "      \"type\": \"integer\"\n"
            // tag::delete-request-refresh
            MultiGetItemResponse item = unwrapAndAssertExample(client.mget(request, RequestOptions.DEFAULT));
                + "      \"type\": \"integer\"\n"
                if (bulkItemResponse.isFailed()) { // <1>
                + "      \"type\": \"integer\"\n"
                    + "    }\n"
                .storedFields("foo"));  // <1>
            MultiGetRequest request = new MultiGetRequest();
        }
                }
        {
            assertSame(0, bulkResponse.getBulkFailures().size());
            request.setRefreshPolicy("wait_for");                            // <2>
            // tag::multi-get-request-source-exclude
        {
            long deletedDocs = bulkResponse.getDeleted(); // <5>
                @Override
                long sumDocFreq = tv.getFieldStatistics().getSumDocFreq(); // <4>
        // tag::multi-term-vectors-execute-async
 * GitHub history for details.
            TimeValue timeTaken = bulkResponse.getTook(); // <1>
    public void testGetSource() throws Exception {
                        float score = term.getScore(); // <10>
 * specific language governing permissions and limitations
        String index = response.getIndex(); // <1>
                new TermVectorsRequest("authors", docBuilder);
            createIndex("source1", Settings.EMPTY, mapping);
            // tag::delete-notfound
            // end::update-response
            Map<String, Integer> filterSettings = new HashMap<>();
                        int docFreq = term.getDocFreq(); // <8>
                public void onFailure(Exception e) {
            // tag::update-request-retry
import org.opensearch.client.OpenSearchRestHighLevelClientTestCase;
            //tag::get-request
                    // <1>
            filterSettings.put("max_doc_freq", 100);
        CreateIndexResponse authorsResponse = client.indices().create(authorsRequest, RequestOptions.DEFAULT);
                .startObject()
                }
                }
            // tag::delete-execute-listener
        {
            // tag::delete-by-query-request-routing
            createPipeline("my_pipeline");
                    new FetchSourceContext(true, includes, excludes);
                public void onFailure(Exception e) {
                // <4>
            ActionListener<GetResponse> listener = new ActionListener<GetResponse>() {
        }
                    // <2>
                        if (term.getTokens() != null) {
            // tag::bulk-response
                @Override
                    bulkResponse.getStatus().getThrottledUntil(); // <13>
                public void afterBulk(long executionId, BulkRequest request,
            assertNotNull(result);
            DeleteRequest request = new DeleteRequest(
            assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
            listener = new LatchedActionListener<>(listener, latch);
            assertThat(item.getResponse().getSource(), not(hasKey("baz")));
        }
            // end::bulk-request-refresh
    @SuppressWarnings("unused")
        {
        assertEquals(200, refreshResponse.getStatusLine().getStatusCode());
                GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
            // tag::term-vectors-request
                    + "}"
        }
                    + "                \"store\": true\n"
            // end::update-by-query-request-routing
            public void onFailure(Exception e) {
                public void onResponse(DeleteResponse deleteResponse) {
    public void testUpdateByQuery() throws Exception {
            request.add(new MultiGetRequest.Item("missing_index", "id"));
        }
                .field("type", "keyword")
            // end::multi-get-request-item-extras
            //tag::index-request-xcontent
            request.setPerFieldAnalyzer(perFieldAnalyzer);  // <7>
            RequestOptions.DEFAULT
 * The OpenSearch Contributors require contributions made to
                    new BytesArray(new MatchAllQueryBuilder().toString()),
            request.preference("preference"); // <1>
            request.add(new MultiGetRequest.Item("index", "another_id")); // <3>
            if (firstGet.isExists()) {
            assertEquals(4, updateResponse.getGetResult().getSource().get("field"));
                    logger.error("Failed to execute bulk", failure); // <3>
            IndexResponse indexResponse = client.index(
                case DELETE:   // <5>
            createIndex("source2", Settings.EMPTY, mapping);
            ActionListener<BulkByScrollResponse> listener;
                }
            assertSame(0, bulkResponse.getBulkFailures().size());
                    .source(MediaTypeRegistry.JSON,"field", "baz"));
            //tag::index-request-map
                @Override
                RequestOptions.DEFAULT
        //tag::get-source-request-refresh
            // end::reindex-request-pipeline
        {
    }
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
                            "In which order are my OpenSearch queries executed?");
            // end::bulk-execute-async
            request.setDestOpType("create"); // <1>
            try {
            UpdateRequest request = new UpdateRequest("posts", "1")
                    new FetchSourceContext(true, includes, excludes);
            // tag::exists-execute-async
import org.opensearch.action.DocWriteResponse;
            client.indexAsync(request, RequestOptions.DEFAULT, listener); // <1>
            //tag::update-request
            public void onFailure(Exception e) {
            MultiGetRequest request = new MultiGetRequest();
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
 */
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
                            "The Future of Federated Search in OpenSearch");
            // end::reindex-response
            // Replace the empty listener by a blocking listener in test
    }
            // tag::delete-by-query-request-maxDocs
        }
        };
        }
    @SuppressWarnings("unused")
            // end::index-request-version-type
                    // <1>
 */
            // end::update-execute
                public void beforeBulk(long executionId, BulkRequest request) {
            // end::exists-execute-async
                    // <2>
            DeleteByQueryRequest request = new DeleteByQueryRequest();
            assertEquals(RestStatus.OK.getStatus(), response.getStatusLine().getStatusCode());
            MultiGetResponse response = client.mget(request, RequestOptions.DEFAULT);
                    + "        }\n"
    }
        {
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
                    "posts", // <1>
            // end::exists-execute-listener
            // tag::multi-get-conflict
                )
        Response refreshResponse = client().performRequest(new Request("POST", "/authors/_refresh"));
        }
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.client.RequestOptions;
            // end::index-response
            MultiTermVectorsRequest request = new MultiTermVectorsRequest(); // <1>
            bulkProcessor.close();
            // end::update-by-query-execute
            final CountDownLatch latch = new CountDownLatch(1);
            XContentBuilder docBuilder = XContentFactory.jsonBuilder();
                public void onFailure(Exception e) {
            }
            request.upsert(jsonString, MediaTypeRegistry.JSON);  // <1>
                    new TimeValue(100, TimeUnit.SECONDS)
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
                    + "different than the one provided [1000]"));    // <5>
                public void afterBulk(long executionId, BulkRequest request,
                // <1>
        MultiTermVectorsResponse response =
        }
                    new DeleteByQueryRequest("source1", "source2"); // <1>
            };
        {
            String value = item.getResponse().getField("foo").getValue(); // <2>
            // end::index-request-op-type
            long bulkRetries = bulkResponse.getBulkRetries(); // <8>
                    + "}"
            // end::update-request-doc-upsert
                    .constantBackoff(TimeValue.timeValueSeconds(1L), 3)); // <5>
        TaskId taskId = new TaskId("oTUltX4IQMOUUVeiohTt8A:124");
                }
            ActionListener<GetSourceResponse> listener =
        {
    }
                    + "        \"properties\" : {\n"
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            //end::index-request-map
                .version(10123L));                  // <3>
            assertFalse(bulkResponse.hasFailures());
 * compatible open source license.
        getSourceRequest.routing("routing"); // <1>
            filterSettings.put("max_term_freq", 10);
        {
            final CountDownLatch latch = new CountDownLatch(1);
            // tag::index-request-refresh
            request.docAsUpsert(true); // <1>
                public void onFailure(Exception e) {
            // end::term-vectors-request-artificial
            // tag::get-conflict
            request.add(new MultiGetRequest.Item("index", "with_version")
            listener = new ActionListener<BulkByScrollResponse>() {
                }
            // tag::multi-get-execute-listener
            for (BulkItemResponse bulkItemResponse : bulkResponse) {
        }
            client.deleteByQueryRethrottle(request, RequestOptions.DEFAULT); // <3>
                    + "    \"mappings\" : {\n"
                }
                        shardInfo.getFailures()) {
            jsonMap.put("user", "foobar");
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            DeleteRequest request = new DeleteRequest("posts", "does_not_exist");
            String jsonString = "{\"created\":\"2017-01-01\"}";
            // end::index-request-routing
            listener = new ActionListener<IndexResponse>() {
                @Override
import org.opensearch.client.core.TermVectorsResponse;
                .startObject("user")
            String[] includes = Strings.EMPTY_ARRAY;
                public void onFailure(Exception e) {
            assertEquals(1, getResponse.getFields().size());
            BulkByScrollResponse bulkResponse =
            request.indices("source1");
        {
                         "reason", "daily update"); // <1>
                    }
                DocWriteResponse itemResponse = bulkItemResponse.getResponse(); // <2>
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        tvrequestTemplate.setFields("user");
                "{\n"
 * KIND, either express or implied.  See the License for the
            //end::get-request-refresh
            };
            // end::delete-request-routing
            // tag::multi-get-execute-async
                @Override
                    UpdateResponse updateResponse = (UpdateResponse) itemResponse;
            // end::delete-by-query-request-slices
            GetRequest request = new GetRequest("does_not_exist", "1");
            if (shardInfo.getFailed() > 0) {
            request.scriptedUpsert(true); // <1>
            long noops = bulkResponse.getNoops(); // <8>
            // tag::delete-request-version
                    @Override
            IndexRequest one = new IndexRequest("posts").id("1")
            RethrottleRequest request = new RethrottleRequest(taskId);
                    .doc("field", "value");
            // end::reindex-request-versionType
        }
        assertEquals(200, refreshResponse.getStatusLine().getStatusCode());
            BulkRequest request = new BulkRequest();
            assertEquals(2, sourceAsMap.size());
                    "posts", // <1>
    }
import org.opensearch.client.core.GetSourceRequest;
            // end::update-by-query-request-maxDocs
            assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
            //end::get-source-execute-async
            if (result.isExists()) {
import java.util.Collections;
            request.setQuery(new TermQueryBuilder("user", "foobar")); // <1>
            String index = deleteResponse.getIndex();
                        String termStr = term.getTerm(); // <6>
            for (TermVectorsResponse tvresponse : tvresponseList) {
                    request, RequestOptions.DEFAULT);
                    // <1>
        }
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
                new IndexRequest("posts").id("async").source("field", "value"),
            if (updateResponse.getResult() == DocWriteResponse.Result.CREATED) {
            MultiGetItemResponse missingIndexItem = response.getResponses()[2];
                    // <2>
            // tag::delete-conflict
            // end::update-conflict
            assertNull(getResponse.getSourceInternal());
            // end::multi-get-execute-async
                // <1>
            IndexRequest indexRequest = new IndexRequest("posts").id("1")
            assertNotNull(updateResponse.getGetResult());
            assertThat(item.getResponse().getSource(), not(hasKey("foo")));
            GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
            // end::reindex-request-scroll
            assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
            UpdateRequest request = new UpdateRequest("posts", "1");
            request.opType("create"); // <2>
                    + "    }\n"
                GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
            assertTrue(latch.await(30L, TimeUnit.SECONDS));
            // tag::update-by-query-request-slices
            };
import org.opensearch.core.common.unit.ByteSizeUnit;
                    new FetchSourceContext(true, includes, excludes);
            if (shardInfo.getFailed() > 0) {
                    + "            \"message\" : {\n"
            // tag::delete-by-query-request-slices
        GetRequest getRequest = new GetRequest(
            request.setRefresh(true); // <1>
            assertEquals("val1", value);
                    + "    }\n"
                .endObject()
            final CountDownLatch latch = new CountDownLatch(1);
            );
            String jsonString = "{" +
            // end::delete-request-version-type
            ActionListener<DeleteResponse> listener;
            request.routing("routing"); // <1>
            // tag::update-by-query-request-pipeline
                    + "            \"message\" : {\n"
            long noops = bulkResponse.getNoops(); // <6>
                    bulkResponse.getSearchFailures(); // <13>
            client.deleteAsync(request, RequestOptions.DEFAULT, listener); // <1>
        {
                + "      \"type\": \"text\"\n"
            listener = new ActionListener<DeleteResponse>() {
            request.fetchSource(true);
                    bulkResponse.getSearchFailures(); // <14>
 */
        TermVectorsResponse response =
            request.version(2); // <1>
            request.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE); // <1>
            // end::delete-by-query-request-refresh
            // tag::multi-get-request
            // end::update-request-cas
                if (exception.status() == RestStatus.CONFLICT) {
                // <1>
                client.getSource(getSourceRequest, RequestOptions.DEFAULT);
            MultiGetItemResponse firstItem = response.getResponses()[0];
            request.setTimeout(TimeValue.timeValueMinutes(2)); // <1>
            //end::update-request
                RequestOptions.DEFAULT, listener); // <3>
import org.opensearch.core.tasks.TaskId;
        //tag::get-source-request-optional
                    .source(MediaTypeRegistry.JSON, "title",
        final CountDownLatch latch = new CountDownLatch(3);
            TimeValue timeTaken = bulkResponse.getTook(); // <1>
            BulkRequest request = new BulkRequest();
            request, RequestOptions.DEFAULT, listener); // <1>
                }
            expectSource.put("user", "foobar");
            );
        // tag::multi-term-vectors-request-template
package org.opensearch.client.documentation;
import org.opensearch.action.bulk.BulkProcessor;
            // tag::update-request-doc-upsert
 * not use this file except in compliance with the License.
                    public void onResponse(GetSourceResponse getResponse) {
                    "1");   // <2>
                    // <1>
                String sourceAsString = result.sourceAsString(); // <2>
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
            // end::update-request-scripted-upsert
            }
            @Override
                client.termvectors(request, RequestOptions.DEFAULT);
                }
        getSourceRequest.realtime(false); // <1>
            assertSame(0, bulkResponse.getBulkFailures().size());
                @Override
            // end::bulk-request-timeout
                    int numberOfActions = request.numberOfActions(); // <1>
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(3, result.sourceAsMap().size());
            // end::reindex-execute
                    .source(MediaTypeRegistry.JSON,"field", "baz"));
            //end::get-request
            //end::index-request-string
            // end::delete-by-query-execute
            final CountDownLatch latch = new CountDownLatch(1);
            assertTrue(sourceAsMap.containsKey("field"));
            // end::reindex-request-opType
            request.setConflicts("proceed"); // <1>
            // tag::bulk-processor-close
import org.opensearch.script.Script;
            // tag::term-vectors-request-optional-arguments
            client.existsAsync(getRequest, RequestOptions.DEFAULT, listener); // <1>
                    } else {
 * Unless required by applicable law or agreed to in writing,
            request.timeout("1s"); // <2>
            request.setRouting("=cat"); // <1>
            //end::get-request-version
            request.versionType(VersionType.EXTERNAL); // <1>
            request.fetchSourceContext(fetchSourceContext); // <1>
        //tag::get-source-request-routing
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
            DeleteRequest request = new DeleteRequest("posts", "async");
            long batches = bulkResponse.getBatches(); // <5>
            Request createIndex = new Request("PUT", "/posts");
import org.opensearch.action.delete.DeleteResponse;
            // end::bulk-processor-close
            assertTrue(sourceAsMap.containsKey("postDate"));
            // end::index-request-timeout
            // tag::exists-execute-listener
        {
            assertNotNull(bulkProcessor);
                }
        //end::get-source-request-realtime
                if (e.status() == RestStatus.CONFLICT) {
            BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
import org.opensearch.action.get.GetResponse;
            String id = firstItem.getId();
                public void onResponse(BulkByScrollResponse bulkResponse) {
        client.termvectorsAsync(request, RequestOptions.DEFAULT, listener); // <1>
            TimeValue throttledUntilMillis =
    @SuppressWarnings("unused")
            Map<String, Object> parameters = singletonMap("count", 4); // <1>
        // tag::exists-request
            boolean terminated = bulkProcessor.awaitClose(30L, TimeUnit.SECONDS); // <1>
                    "ctx._source.field += params.count", parameters);  // <2>
            assertEquals(3, getResponse.getSourceAsMap().size());
        RestHighLevelClient client = highLevelClient();
            //tag::get-indexnotfound
            // TODO status is broken! fix in a followup
                @Override
            // end::multi-get-conflict
            }
            // end::bulk-request-index-type
        }
                }
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
            // end::bulk-execute-listener
            assertTrue(sourceAsMap.containsKey("updated"));
        }
                public void onResponse(GetResponse getResponse) {
            };
                .version(1000L));
            assertThat(item.getResponse().getSource(), hasEntry("foo", "val1"));
            request.fetchSource(
            // end::reindex-execute-async
        {
                }
                Map<String, Object> sourceAsMap = getResponse.getSourceAsMap(); // <2>
            request.waitForActiveShards(2); // <1>
            builder.setBulkSize(new ByteSizeValue(1L, ByteSizeUnit.MB)); // <2>
                    // <1>
            //tag::update-request-shortcut
            request.fetchSourceContext(fetchSourceContext); // <1>
        RestHighLevelClient client = highLevelClient();
                }
            UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
            request.setIfPrimaryTerm(1L); // <2>
            );
import org.opensearch.index.reindex.DeleteByQueryRequest;
            // end::delete-by-query-request-conflicts
            assertEquals("trying out OpenSearch", sourceAsMap.get("message"));
            request.setRouting("=cat"); // <1>
                + "    },\n"
                RequestOptions.DEFAULT, listener); // <1>
        assertTrue(latch.await(30L, TimeUnit.SECONDS));
                }
        // end::multi-term-vectors-execute
                @Override
