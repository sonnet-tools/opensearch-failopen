            indexRequest.routing(routing);
        for (int i = 0; i < nbItems; i++) {
                assertThat(tvResponse.getIndex(), equalTo(sourceIndex));
                indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
import org.opensearch.client.core.GetSourceRequest;
        {
        }
            getRequest.fetchSourceContext(FetchSourceContext.FETCH_SOURCE);
                OpenSearchException.class,
            assertEquals(RestStatus.CREATED, updateResponse.status());
            );
            bulkRequest.add(new IndexRequest().index(indexAliasName).id("2").source("{ \"name\": \"Trump\" }", XContentType.JSON));
            if (opType == DocWriteRequest.OpType.DELETE) {
                );
                wrongRequest.setIfSeqNo(1L).setIfPrimaryTerm(5L);
                execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
        index.source("{\"field\":\"value2\"}", MediaTypeRegistry.JSON);
        }
        BulkRequest bulkRequest = new BulkRequest();
        OpenSearchException exception = expectThrows(
 *    http://www.apache.org/licenses/LICENSE-2.0
            GetRequest getRequest = new GetRequest("index", "id");
        }
            assertEquals("index", indexResponse.getIndex());
            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
        assertEquals(nbItems, bulkResponse.getItems().length);
            );
            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("test", "test").endObject());
            assertEquals(docId, deleteResponse.getId());
                    } else if (opType == DocWriteRequest.OpType.CREATE) {
                            assertEquals(
            MultiGetResponse response = execute(multiGetRequest, highLevelClient()::mget, highLevelClient()::mgetAsync);
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
import org.opensearch.core.common.unit.ByteSizeValue;
        {
            );
                exception.getMessage()
        highLevelClient().index(index, RequestOptions.DEFAULT);
        }
            assertEquals(RestStatus.CREATED, updateResponse.status());
            assertEquals("index", updateResponse.getIndex());
                    }
                () -> execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync)
                final UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
            assertEquals(1L, updateResponse.getVersion());
            GetRequest getRequest = new GetRequest(noSourceIndex, "1");
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
            assertEquals("with_scripted_upsert", updateResponse.getId());
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
            // used deprecated API existsSource(GetRequest, RequestOptions)
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
            );
            assertFalse(getResponse.isExists());
import org.opensearch.client.indices.GetIndexRequest;
            ).setConcurrentRequests(0).setBulkSize(new ByteSizeValue(5, ByteSizeUnit.GB)).setBulkActions(nbItems + 1).build()
                        if (erroneous) {
        BulkRequest bulk = new BulkRequest();
            BulkResponse bulkResponse = execute(bulkRequest, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);
        highLevelClient().index(index, RequestOptions.DEFAULT);
        {
                    .source(Collections.singletonMap("foo", "bar"))
import org.joda.time.format.DateTimeFormat;
        {
                new IndexRequest("index").id(docId).source(Collections.singletonMap("foo", "bar")).routing("foo"),
            if (randomBoolean()) {
        {
            docBuilder.startObject().field("field", "valuex").endObject();
            assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
        }
            assertEquals(RestStatus.OK, updateResponse.status());
        {
                "OpenSearch exception [type=document_missing_exception, reason=[does_not_exist]: document missing]",
                exception.getMessage()
            assertEquals("id", getResponse.getId());
import java.util.Collections;
            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
        {
            assertEquals(id, getResponse.getId());
            assertTrue(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));
            );
 * this file be licensed under the Apache-2.0 license or a
            () -> execute(request, highLevelClient()::termvectors, highLevelClient()::termvectorsAsync)
                TermVectorsResponse tvResponse = responses.get(i);
        {
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
        MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
        }
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
            }
            });
        {
                () -> execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync)
            assertEquals("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]", exception.getMessage());
                    XContentBuilder.builder(mediaType.xContent()).startObject().field("id", i).endObject()
import org.opensearch.index.get.GetResult;
            OpenSearchException exception = expectThrows(
                    expectedRespFields.get(i),
            bulkRequest.add(new IndexRequest().id("2").source("{ \"name\": \"Trump\" }", XContentType.JSON));
            assertEquals(1L, indexResponse.getVersion());
                    RequestOptions.DEFAULT
            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);
    public void testSourceExists() throws IOException {
            assertEquals(1L, updateResponse.getVersion());
            assertNull(requestRef.get());
                Collections.singletonList(expectedTerm)
            TermVectorsResponse.TermVector expectedTV = new TermVectorsResponse.TermVector(
    private void validateBulkResponses(int nbItems, boolean[] errors, BulkResponse bulkResponse, BulkRequest bulkRequest) {
            long lastUpdateSeqNo;
import org.opensearch.core.common.bytes.BytesReference;
                Collections.singletonList(expectedTerm)
                                RestStatus.CREATED,
            assertEquals(RestStatus.CREATED, indexResponse.status());
            bulkRequest.requireAlias(true);
                        if (erroneous) {
            // used new API existsSource(GetSourceRequest, RequestOptions)
            assertNull(response.getResponses()[1].getFailure());
            updateRequest.detectNoop(false);
    // Not entirely sure if _termvectors belongs to CRUD, and in the absence of a better place, will have it here
                );
            TermVectorsRequest tvRequest = new TermVectorsRequest(sourceIndex, "1");
import java.util.ArrayList;
            assertEquals(2L, updateResponse.getVersion());
            List<TermVectorsResponse.TermVector> expectedTVlist = Collections.singletonList(expectedTV);
            TermVectorsRequest tvRequest = new TermVectorsRequest(sourceIndex, docBuilder);
                exception.getMessage()
            );
 * Licensed to Elasticsearch under one or more contributor
        }
            @Override
import org.opensearch.common.settings.Settings;
        validateBulkResponses(nbItems, errors, bulkResponse, bulkRequest);
            assertEquals(docId, deleteResponse.getId());
    }
                updateRequest.doc(new IndexRequest().source(Collections.singletonMap("field", "doc"), MediaTypeRegistry.JSON));
        String document = "{\"field1\":\"value1\",\"field2\":\"value2\"}";
        index = new IndexRequest("index").id("id2");
            UpdateRequest updateRequest = new UpdateRequest("index", "does_not_exist");
import org.opensearch.action.bulk.BulkProcessor;
            assertFalse(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));
            assertNull(responseRef.get());
            assertTrue(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
                () -> execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync)
                    DeleteRequest deleteRequest = new DeleteRequest("index", id);
            GetRequest getRequest = new GetRequest("index").id(id);
        // parameters are encoded by the low-level client but let's test that everything works the same when we use the high-level one
            assertEquals(RestStatus.NOT_FOUND, exception.status());
                responseRef.set(response);
            );
    }
        }
        }
            assertEquals("index", indexResponse.getIndex());
                    updateRequest.setIfPrimaryTerm(lastUpdatePrimaryTerm);
                RestStatus.OK,
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            MultiGetResponse response = execute(multiGetRequest, highLevelClient()::mget, highLevelClient()::mgetAsync);
                exception.getMessage()
            TermVectorsRequest tvRequest1 = new TermVectorsRequest(sourceIndex, "1");
        {
            assertEquals("index", deleteResponse.getIndex());
                OpenSearchException.class,
            assertEquals("with_upsert", updateResponse.getId());
            assertEquals("index", getResponse.getIndex());
import org.opensearch.core.rest.RestStatus;
        IndexRequest index = new IndexRequest("index").id("id");
                            );
        {
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
                getRequest.fetchSourceContext(new FetchSourceContext(true, new String[] { "field1" }, Strings.EMPTY_ARRAY));
import org.opensearch.OpenSearchException;
            assertEquals(RestStatus.NOT_FOUND, exception.status());
            assertTrue(getResponse.isExists());
            indexRequest.source("field", "value");
            IndexRequest indexRequest = new IndexRequest("index").id("id");
                            RestStatus.CREATED,
            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);
            assertTrue(getResponse.isExists());
                bulkRequest.add(deleteRequest);
            );
            BulkItemResponse bulkItemResponse = bulkResponse.getItems()[i];
                        .add(
                    }
            assertEquals(RestStatus.OK, updateResponse.status());
            assertEquals(
    public void testIndex() throws IOException {
            updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
        {
                            highLevelClient().index(new IndexRequest("index").id(id).source("field", -1), RequestOptions.DEFAULT).status()
                OpenSearchStatusException exception = expectThrows(
                    RequestOptions.DEFAULT
            updateRequest.doc(singletonMap("doc_status", "updated"));
            assertEquals(
            updateRequest.doc(singletonMap("field_2", "two"), randomFrom(XContentType.values()));
    }
            MultiTermVectorsRequest mtvRequest = new MultiTermVectorsRequest(expectedIds, tvRequestTemplate);
            );
                UpdateRequest updateRequest = new UpdateRequest("index", "require_alias").setRequireAlias(true);
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
import java.util.List;
            BulkProcessor processor = BulkProcessor.builder(
 * You may obtain a copy of the License at
    }
            assertTrue(tvResponse.getFound());
                } else if (opType == DocWriteRequest.OpType.CREATE) {
            TermVectorsResponse tvResponse = execute(tvRequest, highLevelClient()::termvectors, highLevelClient()::termvectorsAsync);
        {
            getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);
            IndexRequest indexRequest = new IndexRequest("index").id(docId);
                "OpenSearch exception [type=index_not_found_exception, reason=no such index [index]"
        {
        IndexRequest index = new IndexRequest("index").id("id");
                getRequest.version(1L);
    public void testDeprecatedSourceExists() throws IOException {
                assertTrue(tvResponse.getFound());
            assertEquals("index", indexResponse.getIndex());
        {
            IndexResponse indexResponse = highLevelClient().index(
        {
/*
import java.io.IOException;
import org.opensearch.action.bulk.BulkItemResponse;
                if (opType == DocWriteRequest.OpType.INDEX) {
            );
        assertEquals(nbItems, bulkResponse.getItems().length);
            );
            updateRequest.fetchSource(true);
            // test _mtermvectors where MultiTermVectorsRequest is constructed with ids and a template
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
            MultiTermVectorsResponse mtvResponse = execute(
        }
                null,
            }
            tvRequest1.setFields("field");
            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);
            }
import org.opensearch.action.update.UpdateRequest;
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
                }
            assertEquals(-1, indexResponse.getShardId().getId());
            assertFalse(response.getResponses()[1].isFailed());
            UpdateRequest updateRequest = new UpdateRequest("index", "with_upsert");
            } else {
                    + "]: "
        {
    public void testSourceDoesNotExist() throws IOException {
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
            assertEquals("index", getResponse.getIndex());
        }
            expectedRespFields.add(expectedFields);
            assertEquals(expectedTVlist, tvResponse.getTermVectorsList());
            assertEquals("index", response.getResponses()[1].getIndex());
            highLevelClient().index(
            GetRequest getRequest = new GetRequest("index", "does_not_exist");
        String expectedIndex = "logstash-"
            IndexRequest indexRequest = new IndexRequest("index").id("id");
        }
            assertEquals(expectedRespFields.size(), responses.size());
            indexRequest.version(12L);
        final String noSourceIndex = "no_source";
 * Unless required by applicable law or agreed to in writing,
                } else {
            assertEquals("index", bulkItemResponse.getIndex());
            }
            );
            assertEquals(RestStatus.CREATED, indexResponse.status());
            DocWriteRequest.OpType opType = randomFrom(DocWriteRequest.OpType.values());
            // Testing version type with a wrong version
                    () -> execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync)
            TermVectorsRequest tvRequest2 = new TermVectorsRequest(sourceIndex, docBuilder);
    public void testGet() throws IOException {
        {
            assertEquals("index", indexResponse.getShardId().getIndex().getName());
            assertEquals(routing, getResponse.getField("_routing").getValue());
            indexRequest.source("field_1", "one", "field_3", "three");
            multiGetRequest.add("index", "id1");
            assertTrue(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
            }
            assertEquals("id", indexResponse.getId());
    }
        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
        {
    }
            assertEquals("index", deleteResponse.getIndex());
            doc2.put("field", "value2");
            assertEquals("index", deleteResponse.getIndex());
            assertEquals("id1", response.getResponses()[0].getFailure().getId());
        assertEquals(RestStatus.NOT_FOUND, exception.status());
        {
            indexRequest.version(12L);
        AtomicReference<Throwable> error = new AtomicReference<>();
            assertEquals("_na_", indexResponse.getShardId().getIndex().getUUID());
                            assertEquals(RestStatus.CREATED, highLevelClient().index(createRequest, RequestOptions.DEFAULT).status());
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
                    UpdateRequest updateRequest = new UpdateRequest("index", id).doc(new IndexRequest().source(source, mediaType));
    // Not entirely sure if _mtermvectors belongs to CRUD, and in the absence of a better place, will have it here
            OpenSearchException exception = expectThrows(
                    )
            GetRequest getRequest = new GetRequest("index", "does_not_exist");
            );
            assertTrue(response.getResponses()[0].isFailed());
            assertEquals(RestStatus.CREATED, indexResponse.status());
            DeleteRequest deleteRequest = new DeleteRequest("index", docId).versionType(VersionType.EXTERNAL).version(13);
        BulkRequest bulkRequest = requestRef.get();
            assertEquals("id2", response.getResponses()[1].getId());
            assertFalse("Should not auto-create the '" + indexAliasName + "' index.", indexExists(indexAliasName));
            GetRequest getRequest = new GetRequest("index", "does_not_exist");
            GetRequest getRequest = new GetRequest("index", "does_not_exist").version(1);
            assertEquals(id, indexResponse.getId());
            }
import org.opensearch.client.core.TermVectorsRequest;
            assertTrue(getResponse.isSourceEmpty());
        String indexPattern = "<logstash-{now/M}>";
                IndexRequest indexRequest = new IndexRequest("index").id("missing_alias").setRequireAlias(true);
            );
            assertEquals("initialized", getResult.sourceAsMap().get("field"));
        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
            {
            // Testing routing
                assertEquals(errors[i], bulkItemResponse.isFailed());
            });
            DeleteRequest deleteRequest = new DeleteRequest("index", docId);
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
            assertEquals(RestStatus.BAD_REQUEST, exception.status());
        }
            assertThat(tvResponse.getIndex(), equalTo(sourceIndex));
            );
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
                    .version(12),
            tvRequest1.setFields("field");
            assertEquals(1, sourceAsMap.size());
                new IndexRequest("index").id(docId).source(Collections.singletonMap("foo", "bar")),
                indexRequest.setPipeline("missing");
            assertEquals(1L, indexResponse.getVersion());
        }
            assertEquals("index", getResponse.getIndex());
                assertThat(tvResponse.getIndex(), equalTo(sourceIndex));
                null,
            );
        {
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
        }
                    bulkRequest.add(updateRequest);
            assertTrue(getResponse.isExists());
            );
            assertNull(response.getResponses()[1].getResponse());
            assertTrue("Bulk response must have failures.", bulkResponse.hasFailures());
            GetRequest getRequest = new GetRequest("index", docId);
        IndexRequest index = new IndexRequest("index").id("id");
            assertEquals(RestStatus.NOT_FOUND, exception.status());
            OpenSearchException exception = expectThrows(
                if (randomBoolean()) {
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
            assertEquals(
            assertEquals(docId, deleteResponse.getId());
            multiGetRequest.add("index", "id2");
            TermVectorsResponse.TermVector.Token expectedToken = new TermVectorsResponse.TermVector.Token(0, 6, 0, null);
            assertEquals(RestStatus.CONFLICT, exception.status());
            assertEquals(
        final String sourceIndex = "index1";
            assertEquals(0, indexResponse.getShardInfo().getFailed());
        }
                    bulkRequest.add(createRequest);
            TermVectorsResponse tvResponse = execute(tvRequest, highLevelClient()::termvectors, highLevelClient()::termvectorsAsync);
        }
        {
            assertEquals("index", getResponse.getIndex());
            tvRequest.setFields("field");
            GetRequest getRequest = new GetRequest("index", "id").routing(routing);
        {
            String docId = "version_conflict";
            String docId = "version_type";
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
                highLevelClient()::mtermvectors,
            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
 */
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
            String docId = "does_not_exist";
            public void beforeBulk(long executionId, BulkRequest request) {
            assertTrue(indexResponse.getShardInfo().getTotal() > 0);
            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
            assertNull(response.getResponses()[0].getFailure());
    public void testBulkWithRequireAlias() throws IOException {
            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
        {
                    + "version conflict, required seqNo [2], primary term [2]. current document has seqNo [3] and primary term [1]]",
            assertEquals("index", indexResponse.getIndex());
import org.opensearch.action.delete.DeleteRequest;
                                highLevelClient().index(new IndexRequest("index").id(id).source("field", -1), RequestOptions.DEFAULT)
            expectedRespFields.add(Collections.singletonList("field"));
            indexRequest.source("field", "value");
    }
    }
                        );
            UpdateRequest updateRequest = new UpdateRequest("index", "with_doc");
            );
                UpdateRequest updateRequest = new UpdateRequest("index", "id");
        );
            assertEquals(
                "OpenSearch exception [type=version_conflict_engine_exception, reason=["
            });
            assertEquals(docId, getResponse.getId());
                Collections.singletonList(expectedToken)
            );
    }
    }
                assertEquals(exception.toString(), RestStatus.CONFLICT, exception.status());
                    if (erroneous == false) {
                        processor.add(updateRequest);
            OpenSearchException.class,
        IndexRequest index = new IndexRequest("index").id("id");
            assertEquals("id2", response.getResponses()[1].getId());
            assertTrue(getResponse.isExists());
            GetSourceRequest getRequest = new GetSourceRequest("index", "does_not_exist");
        {
            updateRequest.scriptedUpsert(true);
        multiGetRequest.add("index", "id1");
            updateRequest.upsert(singletonMap("doc_status", "created"));
                ).status()
import static java.util.Collections.singletonMap;
            assertEquals(-1, getResponse.getVersion());
            assertEquals("id", getResponse.getId());
                final UpdateRequest updateRequest = new UpdateRequest("index", "id");
            IndexRequest indexRequest = new IndexRequest("index").id("with_doc");
import org.opensearch.core.common.Strings;
            createIndex(sourceIndex, settings, mappings);
            assertTrue(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));
        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
import org.opensearch.action.get.MultiGetRequest;
            assertEquals(RestStatus.CREATED, indexResponse.status());
        {
            highLevelClient().index(
            );
        }
        {
                ids.add(tvResponse.getId());
            GetResponse getResponse = highLevelClient().get(getRequest, RequestOptions.DEFAULT);
                exception.getMessage()
        }
                assertThat(exception.getMessage(), containsString("OpenSearch exception [type=version_conflict_engine_exception"));
                IndexRequest wrongRequest = new IndexRequest("index").id("id");
            assertEquals(
    }
            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
                new IndexRequest().index(indexAliasName).id("2").setRequireAlias(true).source("{ \"name\": \"Trump\" }", XContentType.JSON)
                "field",
            OpenSearchStatusException exception = expectThrows(
            assertEquals(12L, indexResponse.getVersion());
            GetRequest getRequest = new GetRequest("index", "does_not_exist").version(1);
                        RestStatus.CREATED,
            assertEquals(
            assertFalse(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));
            // test the behavior of fields param
                RequestOptions.DEFAULT
                    + "reason=[id]: "
        {
                execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
                    new BulkRequest().add(
import org.opensearch.client.core.MultiTermVectorsResponse;
 * SPDX-License-Identifier: Apache-2.0
        {
import org.joda.time.DateTime;
        }
            assertEquals(expectedResponse, response.getSource());
                IndexRequest indexRequest = new IndexRequest("index").id("missing_pipeline");
                null,
            assertEquals(expectedResponse, response.getSource());
                highLevelClient().bulk(
            IndexRequest indexRequest = new IndexRequest("index").id(id);
            assertEquals(RestStatus.CREATED, indexResponse.status());
        {
                wrongRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
                        if (erroneous == false) {
            TermVectorsResponse.TermVector.FieldStatistics expectedFieldStats = new TermVectorsResponse.TermVector.FieldStatistics(2, 2, 2);
        {
            );
            expectedResponse.put("field1", "value1");
            doc2.put("field2", "foo var");
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
            updateRequest.doc(singletonMap("field", "initialized"));
            indexRequest.source(singletonMap("counter", 12));
                exception.getMessage()
            GetResponse getResponse = highLevelClient().get(getRequest, RequestOptions.DEFAULT);
            assertNull(getResponse.getSourceAsString());
                        assertEquals(
            );
        AtomicReference<BulkRequest> requestRef = new AtomicReference<>();
            createIndex(noSourceIndex, settings, mapping);
            assertEquals("index", indexResponse.getIndex());
                assertThat(tvResponse.getIndex(), equalTo(sourceIndex));
            UpdateRequest updateRequest = new UpdateRequest("index", "with_scripted_upsert");
            // test _termvectors on artificial documents
                }
                        )
        {
                    assertEquals(
                    IndexRequest createRequest = new IndexRequest("index").id(id).source(source, mediaType).create(true);
            tvRequest3.setFields("field", "field2");
                        .setRefreshPolicy(RefreshPolicy.IMMEDIATE),
            getRequest.fetchSourceContext(new FetchSourceContext(true, Strings.EMPTY_ARRAY, new String[] { "field1" }));
        bulk.add(index);
            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("version", 2).endObject());
            assertTrue(getResponse.isExists());
                "OpenSearch exception [type=illegal_argument_exception, " + "reason=pipeline with id [missing] does not exist]",
            assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
        }
                ).status()
            boolean erroneous = randomBoolean();
        }
        };
                updateRequest.setIfPrimaryTerm(lastUpdatePrimaryTerm);
        {
    }
                assertThat(lastUpdateSeqNo, greaterThanOrEqualTo(0L));
            mtvRequest.add(tvRequest3);
    }
    // used deprecated API existsSource(GetRequest, RequestOptions)
import org.opensearch.core.xcontent.XContentBuilder;
import static org.hamcrest.Matchers.equalTo;
            mtvRequest.add(tvRequest2);
                () -> execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync)
            assertEquals(2, response.getResponses().length);
            getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);
            expectedResponse.put("field2", "value2");
            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
    public void testGetIdWithPlusSign() throws Exception {
                    new BulkRequest().add(new IndexRequest(sourceIndex).id("1").source(doc1, MediaTypeRegistry.JSON))
            });
            BulkResponse bulkResponse = execute(bulkRequest, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);
                null,
                updateRequest.doc(singletonMap("field", "with_seq_no"), randomFrom(XContentType.values()));
        {
                execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
            expectedResponse.put("field1", "value1");
import org.opensearch.action.update.UpdateResponse;
            GetRequest getRequest = new GetRequest("index", "id");
            assertEquals(i, bulkItemResponse.getItemId());
                    + "]: version conflict, current version [12] is higher or equal to the one provided [10]]",
 *
                exception.getMessage()
            updateRequest.script(script);
                exception.getMessage()
        assertTrue(highLevelClient().indices().exists(new GetIndexRequest(indexPattern, "index"), RequestOptions.DEFAULT));
import java.util.concurrent.atomic.AtomicReference;
            assertFalse("Should not auto-create the '" + indexAliasName + "' index.", indexExists(indexAliasName));
                    + "version conflict, required seqNo [1], primary term [5]. current document has seqNo [2] and primary term [1]]",
 */
                OpenSearchException.class,
                } else if (opType == DocWriteRequest.OpType.UPDATE) {
                    OpenSearchStatusException.class,
        }
                                    .status()
        assertTrue(bulkResponse.getTook().getMillis() > 0);
                updateRequest.setIfSeqNo(lastUpdateSeqNo);
            assertEquals("id", indexResponse.getId());
                    );
            assertEquals(
        {
            TermVectorsResponse.TermVector.Token expectedToken = new TermVectorsResponse.TermVector.Token(0, 6, 0, null);
            assertEquals(expectedIndex, indexResponse.getIndex());
                            indexRequest.setIfSeqNo(12L);
        }
        }
            assertEquals(
        }
        }
            );
                "OpenSearch exception [type=action_request_validation_exception, "
                Collections.singletonList(expectedToken)
            assertEquals(
            );
            updateRequest.script(new Script(ScriptType.INLINE, "painless", "ctx._source.level = params.test", singletonMap("test", "C")));
                    + " and [require_alias] request flag is [true] and [index] is not an alias]",
            assertEquals(RestStatus.OK, indexResponse.status());
            DeleteRequest deleteRequest = new DeleteRequest("index", docId);
            mtvRequest.add(tvRequest1);
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
            indexRequest.source(singletonMap("field", "value"));
            assertTrue(getResponse.isExists());
                            indexRequest.setIfPrimaryTerm(12L);
            XContentBuilder docBuilder = XContentFactory.jsonBuilder();
import org.opensearch.core.common.unit.ByteSizeUnit;
            doc1.put("field", "value1");
                OpenSearchStatusException.class,
            String mappings = "\"properties\":{\"field\":{\"type\":\"text\"}, \"field2\":{\"type\":\"text\"}}";
            IndexRequest indexRequest = new IndexRequest("index").id("external_version_type");
        }
        {
                if (opType == DocWriteRequest.OpType.DELETE) {
                    RequestOptions.DEFAULT
            assertEquals(RestStatus.NOT_FOUND, exception.status());
                        new IndexRequest(noSourceIndex).id("1").source(Collections.singletonMap("foo", 1), MediaTypeRegistry.JSON)
            assertEquals(13L, updateResponse.getVersion());
            String indexAliasName = "testindex-4";
            assertEquals("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]", exception.getMessage());
                assertEquals(errors[i] ? RestStatus.CONFLICT : RestStatus.CREATED, bulkItemResponse.status());
        index.source("{\"field\":\"value1\"}", MediaTypeRegistry.JSON);
            assertEquals(1L, indexResponse.getVersion());
            String indexAliasName = "testindex-3";
                "OpenSearch exception [type=version_conflict_engine_exception, reason=[with_create_op_type]: "
            updateRequest.doc(singletonMap("field", "value"), randomFrom(XContentType.values()));
            // Testing version type
            assertTrue(getResponse.isExists());
        MultiGetRequest multiGetRequest = new MultiGetRequest();
                response.getResponses()[0].getFailure().getFailure().getMessage()
            GetResponse getResponse = highLevelClient().get(getRequest, RequestOptions.DEFAULT);
    }
            assertEquals(RestStatus.CREATED, indexResponse.status());
            DeleteRequest deleteRequest = new DeleteRequest("index", docId).setIfSeqNo(2).setIfPrimaryTerm(2);
            List<TermVectorsResponse> responses = mtvResponse.getTermVectorsResponses();
            indexRequest = new IndexRequest("index").id("id");
            {
        int nbItems = randomIntBetween(10, 100);
                        );
                ).status()
                UpdateRequest updateRequest = new UpdateRequest("index", "id");
        }
                assertThat(lastUpdatePrimaryTerm, greaterThanOrEqualTo(1L));
import org.opensearch.client.core.TermVectorsResponse;
import org.opensearch.index.VersionType;
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
            UpdateRequest updateRequest = new UpdateRequest("index", "noop");
            assertEquals(1L, getResponse.getVersion());
            assertEquals("C", getResult.sourceAsMap().get("level"));
        }
            docBuilder.startObject().field("field", "valuex").endObject();
        index.source("{\"field1\":\"value1\",\"field2\":\"value2\"}", MediaTypeRegistry.JSON);
            tvRequestTemplate.setFields("field");
                assertEquals(errors[i], bulkItemResponse.isFailed());
            @Override
                    + docId
            assertFalse("Should not auto-create the '" + indexAliasName + "' index.", indexExists(indexAliasName));
        }
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
            assertEquals("index", updateResponse.getIndex());
                error.set(failure);
        IndexRequest index = new IndexRequest("index").id("id1");
                    IndexRequest indexRequest = new IndexRequest("index").id(id).source(source, mediaType);
import org.opensearch.action.DocWriteRequest;
            String mappings = "\"properties\":{\"field\":{\"type\":\"text\"}}";
        {
            expectedResponse.put("field2", "value2");
            assertEquals("value1", sourceAsMap.get("field1"));
            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);
            indexRequest.source("field", "value");
            MultiTermVectorsResponse mtvResponse = execute(
                DeleteRequest deleteRequest = new DeleteRequest("index", docId).versionType(VersionType.EXTERNAL).version(10);
import java.util.HashMap;
            assertEquals("index", response.getResponses()[0].getFailure().getIndex());
            IndexRequest indexRequest = new IndexRequest("index").id("noop");
                    updateRequest.setIfSeqNo(lastUpdateSeqNo + (randomBoolean() ? 0 : 1));
            GetSourceRequest getSourceRequest = new GetSourceRequest(noSourceIndex, "1");
            );
            // prepare : index docs
        assertTrue(bulkResponse.getTook().getMillis() > 0);
 * this work for additional information regarding copyright
 *
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
            assertEquals(RestStatus.CREATED, indexResponse.status());
                "field",
import org.opensearch.action.DocWriteResponse;
        }
            expectedResponse.put("field1", "value1");
            bulkRequest.add(
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
            Script script = new Script(ScriptType.INLINE, "painless", "ctx._source.counter += params.count", singletonMap("count", 8));
    public void testMultiGet() throws IOException {
            highLevelClient().index(
            final Map<String, String> doc1 = new HashMap<>();
            });
                RequestOptions.DEFAULT
import org.opensearch.core.xcontent.MediaTypeRegistry;
            String docId = "wrong_version";
                RequestOptions.DEFAULT
import org.opensearch.core.xcontent.MediaType;
            OpenSearchException exception = expectThrows(OpenSearchException.class, () -> {
            assertEquals(20, updateResponse.getGetResult().sourceAsMap().get("counter"));
            assertEquals(docId, deleteResponse.getId());
                updateRequest.doc(singletonMap("field", "updated"), randomFrom(XContentType.values()));
        }
            }
            assertFalse(sourceAsMap.containsKey("field_3"));
            MultiTermVectorsRequest mtvRequest = new MultiTermVectorsRequest();
                            new IndexRequest(sourceIndex).id("2")
            assertEquals(1L, updateResponse.getVersion());
            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
            bulkRequest.add(new IndexRequest().index(indexAliasName).id("1").source("{ \"name\": \"Biden\" }", XContentType.JSON));
            }
        }
            assertEquals(
/*
            IndexRequest indexRequest = new IndexRequest("index");
            List<List<String>> expectedRespFields = new ArrayList<>();
        {
        int nbItems = randomIntBetween(10, 100);
                getRequest.fetchSourceContext(new FetchSourceContext(true, Strings.EMPTY_ARRAY, new String[] { "field2" }));
        {
    public void testTermvectorsWithNonExistentIndex() {
            assertArrayEquals(expectedIds, ids.toArray());
                exception.getMessage()
import org.opensearch.common.xcontent.XContentType;
                    bulkRequest.add(indexRequest);
            updateRequest.upsert(singletonMap("level", "A"));
            assertNull(response.getResponses()[0].getResponse());
        }
            // prepare : index docs
        {
            assertEquals(expectedResponse, response.getSource());
            );
                execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
            errors[i] = erroneous;
                highLevelClient()::mtermvectors,
                assertTrue(tvResponse.getFound());
            GetRequest getRequest = new GetRequest("index", "id").version(2);
        }
            assertTrue(getResponse.isSourceEmpty());
                response.getResponses()[1].getFailure().getFailure().getMessage()
            indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
        {
            assertEquals("index", updateResponse.getIndex());
            assertEquals(2, response.getResponses().length);
                "OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]",
            bulkRequest.add(new IndexRequest().id("1").setRequireAlias(true).source("{ \"name\": \"Biden\" }", XContentType.JSON));
                "OpenSearch exception [type=index_not_found_exception, reason=no such index [index] and [require_alias] request flag is [true] and [index] is not an alias]",
            GetResult getResult = updateResponse.getGetResult();
        {
            Map<String, Object> expectedResponse = new HashMap<>();
                } else {
import org.opensearch.action.bulk.BulkRequest;
        }
            assertEquals("index", getResponse.getIndex());
                deleteRequest.setIfSeqNo(indexResponse.getSeqNo());
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
            updateRequest.fetchSource(true);
                        IndexRequest indexRequest = new IndexRequest("index").id(id).source(mediaType, "id", i);
import org.opensearch.client.core.MultiTermVectorsRequest;
        assertEquals(RestStatus.OK, bulkResponse.status());
    public void testMultiTermvectors() throws IOException {
        }
            assertNull(getResponse.getSourceAsString());
            TermVectorsRequest tvRequest1 = new TermVectorsRequest(sourceIndex, "1");
            GetResult getResult = updateResponse.getGetResult();
        }
    }
                execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
                mtvRequest,
            bulkRequest.add(new IndexRequest().id("2").setRequireAlias(true).source("{ \"name\": \"Trump\" }", XContentType.JSON));
                updateRequest.upsert(new IndexRequest().source(Collections.singletonMap("field", "upsert"), XContentType.YAML));
                        processor.add(indexRequest);
            assertEquals(2L, indexResponse.getVersion());
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
        index.source(document, MediaTypeRegistry.JSON);
            highLevelClient().index(
 * The OpenSearch Contributors require contributions made to
            Map<String, Object> expectedResponse = new HashMap<>();
            );
            assertFalse(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));
            assertEquals(
                mtvRequest,
        {
            );
            TermVectorsResponse.TermVector.Term expectedTerm = new TermVectorsResponse.TermVector.Term(
            assertFalse(getResponse.isSourceEmpty());
                assertEquals(indexResponse.getVersion() + 1, updateResponse.getVersion());
        }
            assertEquals("index", response.getResponses()[0].getIndex());
            MultiGetRequest multiGetRequest = new MultiGetRequest();
                new IndexRequest("index").id(docId)
                requestRef.set(request);
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
                deleteRequest.setIfPrimaryTerm(indexResponse.getPrimaryTerm());
            assertEquals(2L, updateResponse.getVersion());
            assertEquals(expectedTVlist, tvResponse.getTermVectorsList());
                "valuex",
    public void testGetSource() throws IOException {
                boolean erroneous = randomBoolean();
        }
    }
                lastUpdatePrimaryTerm = updateResponse.getPrimaryTerm();
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
            BulkRequest bulkRequest = new BulkRequest(indexAliasName);
        {
            long lastUpdatePrimaryTerm;
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
                    updateRequest.setIfPrimaryTerm(lastUpdatePrimaryTerm + 1);
        final XContentType xContentType = randomFrom(XContentType.values());
    public void testBulkProcessorIntegration() throws IOException {
        }
            assertEquals("id", indexResponse.getId());
                expectedFieldStats,
                OpenSearchException.class,
        }
        {
            DocWriteRequest.OpType requestOpType = bulkRequest.requests().get(i).opType();
                }
                assertEquals(lastUpdatePrimaryTerm, updateResponse.getPrimaryTerm());
                    + "version conflict, document already exists (current version [1])]",
import org.opensearch.client.core.GetSourceResponse;
        IndexRequest index = new IndexRequest("index").id("id");
            assertEquals(1L, getResponse.getVersion());
                RestStatus.OK,
            assertEquals(1L, updateResponse.getVersion());
                if (erroneous == false) {
            OpenSearchException exception = expectThrows(
            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("version", 1).endObject());
        }
                            RestStatus.CREATED,
            MultiTermVectorsResponse mtvResponse = execute(
            // test _termvectors on real documents
            GetRequest getRequest = new GetRequest(indexPattern, "id#1");
            assertEquals(RestStatus.CREATED, updateResponse.status());
        }
        {
            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
            Map<String, Object> expectedResponse = new HashMap<>();
            assertEquals(RestStatus.OK, updateResponse.status());
import org.opensearch.action.index.IndexRequest;
            } else {
                indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
            assertEquals(RestStatus.CREATED, indexResponse.status());
        }
        {
        boolean[] errors = new boolean[nbItems];
            );
            TermVectorsResponse.TermVector.FieldStatistics expectedFieldStats = new TermVectorsResponse.TermVector.FieldStatistics(2, 2, 2);
        }
            GetRequest getRequest = new GetRequest("index", "id");
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
        index.source("{\"field1\":\"value1\",\"field2\":\"value2\"}", MediaTypeRegistry.JSON);
            assertEquals(expectedResponse, response.getSource());
            indexRequest.source("field", "value");
            );
            String[] expectedIds = { "1", "2" };
            assertFalse(response.getResponses()[0].isFailed());
                            highLevelClient().index(new IndexRequest("index").id(id).source("field", -1), RequestOptions.DEFAULT).status()
        highLevelClient().index(index, RequestOptions.DEFAULT);
        {
                "value1",
            BulkRequest bulkRequest = new BulkRequest();
 * software distributed under the License is distributed on an
        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
                execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
            // Testing version conflict
import org.opensearch.action.get.GetResponse;
        for (int i = 0; i < nbItems; i++) {
            assertEquals("external_version_type", indexResponse.getId());
            String id = String.valueOf(i);
        highLevelClient().index(index, RequestOptions.DEFAULT);
import org.opensearch.script.ScriptType;
            );
                        }
            mtvRequest.add(tvRequest2);
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
            GetResult getResult = updateResponse.getGetResult();
                null,
            assertEquals("index", indexResponse.getIndex());
                assertFalse(bulkItemResponse.isFailed());
            assertEquals(1L, getResponse.getVersion());
            assertThat(indexResponse.getSeqNo(), greaterThanOrEqualTo(0L));
 * GitHub history for details.
                new IndexRequest("index").id(docId)
            assertEquals("index", indexResponse.getIndex());
        }
        {
            assertTrue("Bulk response must have failures.", bulkResponse.hasFailures());
                        processor.add(createRequest);
            DeleteRequest deleteRequest = new DeleteRequest("index", docId).routing("foo");
            assertEquals(RestStatus.CONFLICT, exception.status());
        bulk.add(new IndexRequest("index").id("id2").source("{\"field\":\"value2\"}", MediaTypeRegistry.JSON));
            IndexRequest indexRequest = new IndexRequest("index").id("id");
            UpdateRequest updateRequest = new UpdateRequest("index", "with_script");
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
            bulkRequest.requireAlias(true);
        String document = "{\"field1\":\"value1\",\"field2\":\"value2\"}";
                highLevelClient()::mtermvectorsAsync
            }
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
        highLevelClient().index(index, RequestOptions.DEFAULT);
                        new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("field", "value1"), MediaTypeRegistry.JSON)
            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
            expectedFields.add("field2");
        }
            GetResult getResult = updateResponse.getGetResult();
            String docId = "routing";
        }
                () -> execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync)
            OpenSearchException exception = expectThrows(
            assertEquals(document, getResponse.getSourceAsString());
                exception.getMessage()
            TermVectorsRequest tvRequest2 = new TermVectorsRequest(sourceIndex, "2");
        {
            assertEquals(RestStatus.CONFLICT, exception.status());
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
                        IndexRequest createRequest = new IndexRequest("index").id(id).source(mediaType, "id", i).create(true);
                    if (erroneous == false) {
            IndexRequest indexRequest = new IndexRequest(indexPattern).id("id#1");
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                assertTrue(tvResponse.getFound());
            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
                        .add(new IndexRequest(noSourceIndex).id("2").source(Collections.singletonMap("foo", 2), MediaTypeRegistry.JSON))
                        .setRefreshPolicy(RefreshPolicy.IMMEDIATE),
        }
            bulkRequest.add(new IndexRequest().id("1").source("{ \"name\": \"Biden\" }", XContentType.JSON));
            updateRequest.fetchSource(true);
            GetSourceRequest getRequest = new GetSourceRequest("index", "does_not_exist");
    public void testBulk() throws IOException {
            indexRequest.opType(DocWriteRequest.OpType.CREATE);
            assertFalse(execute(getSourceRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
                assertEquals(errors[i] ? RestStatus.NOT_FOUND : RestStatus.OK, bulkItemResponse.status());
                "OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]",
        bulk.add(new IndexRequest("index").id("id1").source("{\"field\":\"value1\"}", MediaTypeRegistry.JSON));
                        indexRequest.setIfSeqNo(12L);
                );
            assertEquals(
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
            assertEquals("with_create_op_type", indexResponse.getId());
        {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.action.get.MultiGetResponse;
    public void testUpdate() throws IOException {
        {
        boolean[] errors = new boolean[nbItems];
            assertEquals("id", getResponse.getId());
            assertEquals("index", getResponse.getIndex());
                    + "version conflict, current version [1] is different than the one provided [2]]",
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
 *
                () -> execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync)
                        .add(new IndexRequest(sourceIndex).id("2").source(doc2, MediaTypeRegistry.JSON))
                        highLevelClient().index(new IndexRequest("index").id(id).source("field", -1), RequestOptions.DEFAULT).status()
            BulkRequest bulkRequest = new BulkRequest();
                "OpenSearch exception [type=version_conflict_engine_exception, "
import org.opensearch.action.index.IndexResponse;
            assertFalse("Should not auto-create the '" + indexAliasName + "' index.", indexExists(indexAliasName));
            assertFalse(getResponse.isSourceEmpty());
            tvRequest2.setFields("field2");
import static org.hamcrest.Matchers.containsString;
        }
            assertEquals("index", deleteResponse.getIndex());
            GetRequest getRequest = new GetRequest("index", "id");
            final List<String> expectedFields = new ArrayList<>();
                final UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
        }
            assertNotNull(indexResponse.getShardId());
                BytesReference source = BytesReference.bytes(
                lastUpdateSeqNo = updateResponse.getSeqNo();
                        .setRefreshPolicy(RefreshPolicy.IMMEDIATE),
 * specific language governing permissions and limitations
                DeleteRequest deleteRequest = new DeleteRequest("index", id);
                    }
                    }
            }
        {
            assertEquals(RestStatus.NOT_FOUND, exception.status());
            assertEquals("does_not_exist", getResponse.getId());
        {
    }
                    .version(12),
            assertEquals("with_doc_as_upsert", updateResponse.getId());
        }
            assertTrue(response.getResponses()[1].isFailed());
        bulk.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
                exception.getMessage()
        try (
            for (TermVectorsResponse tvResponse : mtvResponse.getTermVectorsResponses()) {
        }
        {
        AtomicReference<BulkResponse> responseRef = new AtomicReference<>();
            bulkRequest.add(
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
            assertEquals("created", getResult.sourceAsMap().get("doc_status"));
                    if (opType == DocWriteRequest.OpType.INDEX) {
                new IndexRequest("index").id(docId).source(Collections.singletonMap("foo", "bar")),
            assertEquals("index", getResponse.getIndex());
            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
            assertEquals("index", indexResponse.getShardId().getIndexName());
                "Update request cannot have different content types for doc [JSON] and upsert [YAML] documents",
            mtvRequest.add(tvRequest1);
package org.opensearch.client;
        {
            multiGetRequest.add("index", "id2");
            updateRequest.fetchSource(true);
        }
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
                highLevelClient()::mtermvectorsAsync
                expectedFieldStats,
            expectedFields.add("field");
 */
            indexRequest.versionType(VersionType.EXTERNAL);
        String docId = "this/is/the/id/中文";
            assertEquals(13L, updateResponse.getVersion());
            indexRequest.source("field", "value");
                        assertEquals(
        {
        TermVectorsRequest request = new TermVectorsRequest("non-existent", "non-existent");
            MultiGetRequest multiGetRequest = new MultiGetRequest();
                    )
                    .source(Collections.singletonMap("foo", "bar"))
            {
            assertEquals("two", sourceAsMap.get("field_2"));
    }
            final Map<String, String> doc2 = new HashMap<>();
        }
            } else if (requestOpType == DocWriteRequest.OpType.UPDATE) {
                    } else if (opType == DocWriteRequest.OpType.UPDATE) {
            if (requestOpType == DocWriteRequest.OpType.INDEX || requestOpType == DocWriteRequest.OpType.CREATE) {
                DocWriteRequest.OpType opType = randomFrom(DocWriteRequest.OpType.values());
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            } else if (requestOpType == DocWriteRequest.OpType.DELETE) {
            UpdateRequest updateRequest = new UpdateRequest("index", "with_doc_as_upsert");
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
                        indexRequest.setIfPrimaryTerm(12L);
            final IndexRequest indexRequest = new IndexRequest("index").id("with_create_op_type");
            List<String> ids = new ArrayList<>();
                        UpdateRequest updateRequest = new UpdateRequest("index", id).doc(new IndexRequest().source(mediaType, "id", i));
        BulkRequest bulk = new BulkRequest();
            BulkResponse bulkResponse = execute(bulkRequest, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);
        }
            assertEquals(RestStatus.CONFLICT, exception.status());
                (request, bulkListener) -> highLevelClient().bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
        {
            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
            }
                OpenSearchException.class,
                updateRequest.doc(singletonMap("field", "with_seq_no_conflict"), randomFrom(XContentType.values()));
        MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);
        String id = "id+id";
        {
        }
            assertEquals(
/*
            assertEquals(expectedIndex, getResponse.getIndex());
        }
                    new BulkRequest().add(
            GetRequest getRequest = new GetRequest("index", "id");
                    updateRequest.setIfSeqNo(lastUpdateSeqNo + 1);
import java.util.stream.Collectors;
                assertEquals(RestStatus.OK, updateResponse.status());
            assertEquals(RestStatus.CONFLICT, exception.status());
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
        {
            TermVectorsResponse.TermVector.Term expectedTerm = new TermVectorsResponse.TermVector.Term(
 * KIND, either express or implied.  See the License for the
 * under the License.
                exception.getMessage()
            });
            );
            assertEquals(12L, indexResponse.getVersion());
            TermVectorsRequest tvRequest3 = new TermVectorsRequest(sourceIndex, "2");
        }
        }
        }
            assertEquals(docId, indexResponse.getId());
            assertEquals(DocWriteResponse.Result.NOOP, updateResponse.getResult());
        assertNull(error.get());
import org.opensearch.OpenSearchStatusException;
            assertEquals(
                        }
                    }
        }
            + DateTimeFormat.forPattern("YYYY.MM.dd").print(new DateTime(DateTimeZone.UTC).monthOfYear().roundFloorCopy());
                assertEquals(lastUpdateSeqNo + 1, updateResponse.getSeqNo());
            // Prepare
        {
            BulkRequest bulkRequest = new BulkRequest(indexAliasName);
        {
            }
                String id = String.valueOf(i);
            assertEquals(
            multiGetRequest.add("index", "id1");
            GetRequest getRequest = new GetRequest("index", "id");
            String indexAliasName = "testindex-1";
    }
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
        }
        multiGetRequest.add("index", "id2");
            assertEquals(RestStatus.NOT_FOUND, exception.status());
                        }
                1,
                highLevelClient()::mtermvectorsAsync
        ) {
        }
            );
            String docId = "id";
            for (TermVectorsResponse tvResponse : mtvResponse.getTermVectorsResponses()) {
        {
            Map<String, Object> expectedResponse = new HashMap<>();
            );
                    + docId
            IndexRequest indexRequest = new IndexRequest("index").id("with_script");
            IllegalStateException exception = expectThrows(IllegalStateException.class, () -> {
        }
    }
            updateRequest.fetchSource("field_*", "field_3");
            BulkResponse bulkResponse = execute(bulkRequest, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);
            assertThat(Integer.valueOf(tvResponse.getId()), equalTo(1));
            MultiTermVectorsRequest mtvRequest = new MultiTermVectorsRequest();
                assertEquals(errors[i] ? RestStatus.NOT_FOUND : RestStatus.OK, bulkItemResponse.status());
            }
                        assertEquals(RestStatus.CREATED, highLevelClient().index(createRequest, RequestOptions.DEFAULT).status());
            assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
                RequestOptions.DEFAULT
            for (int i = 0; i < nbItems; i++) {
            String indexAliasName = "testindex-2";
            assertEquals("id#1", getResponse.getId());
            assertEquals("id1", response.getResponses()[0].getId());
            assertEquals(
import org.opensearch.action.delete.DeleteResponse;
            XContentBuilder docBuilder = XContentFactory.jsonBuilder();
        highLevelClient().bulk(bulk, RequestOptions.DEFAULT);
                highLevelClient()::mtermvectors,
                execute(wrongRequest, highLevelClient()::index, highLevelClient()::indexAsync);
            assertEquals("id", getResponse.getId());
                new IndexRequest().index(indexAliasName).id("1").setRequireAlias(true).source("{ \"name\": \"Biden\" }", XContentType.JSON)
        }
            expectedResponse.put("field2", "value2");
            assertEquals("id#1", indexResponse.getId());
            assertEquals(DocWriteResponse.Result.NOT_FOUND, deleteResponse.getResult());
        {
        validateBulkResponses(nbItems, errors, bulkResponse, bulkRequest);
            assertEquals("index", indexResponse.getIndex());
                highLevelClient().bulk(
}
            assertEquals(RestStatus.OK, updateResponse.status());
import org.opensearch.action.get.GetRequest;
        }
        final String sourceIndex = "index1";
        }
    public void testParamsEncode() throws IOException {
    }
                assertEquals(
            }
 * compatible open source license.
                null,
                                .source(Collections.singletonMap("field", "value2"), MediaTypeRegistry.JSON)
                1,
import org.opensearch.common.xcontent.XContentFactory;
        BulkResponse bulkResponse = execute(bulkRequest, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);
                    processor.add(deleteRequest);
            indexRequest.versionType(VersionType.EXTERNAL);
            assertThat(tvResponse.getIndex(), equalTo(sourceIndex));
                    .versionType(VersionType.EXTERNAL)
                listener
        bulk.add(index);
        {
            );
            GetRequest getRequest = new GetRequest("index", "id");
    public void testMultiGetWithIds() throws IOException {
            GetResponse getResponse = highLevelClient().get(getRequest, RequestOptions.DEFAULT);
                final UpdateRequest updateRequest = new UpdateRequest("index", "id");
                assertEquals(RestStatus.OK, updateResponse.status());
        {
            TermVectorsRequest tvRequestTemplate = new TermVectorsRequest(sourceIndex, "fake_id");
            assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
import java.util.Map;
            getRequest.fetchSourceContext(new FetchSourceContext(true, new String[] { "field1" }, Strings.EMPTY_ARRAY));
 * the Apache License, Version 2.0 (the "License"); you may
                "OpenSearch exception [type=resource_not_found_exception, " + "reason=Document not found [index]/[does_not_exist]]",
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
    public void testUrlEncode() throws IOException {
        String routing = "routing/中文value#1?";
                    if (erroneous) {
        BulkProcessor.Listener listener = new BulkProcessor.Listener() {
                errors[i] = erroneous;
            );
            // Testing non existing document
        }
                "OpenSearch exception [type=version_conflict_engine_exception, reason=[id]: "
                    tvResponse.getTermVectorsList().stream().map(tv -> tv.getFieldName()).collect(Collectors.toList())
            doc1.put("field2", "hello world");
        }
            // Testing deletion
                OpenSearchException.class,
            if (randomBoolean()) {
        {
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        {
            if (randomBoolean()) {
            assertEquals("index", response.getResponses()[1].getIndex());
            updateRequest.doc(singletonMap("field", "value"), randomFrom(XContentType.values()));
import org.opensearch.action.bulk.BulkResponse;
            TermVectorsResponse.TermVector expectedTV = new TermVectorsResponse.TermVector(
            );
                "OpenSearch exception [type=version_conflict_engine_exception, reason=["
                updateRequest.doc(new IndexRequest().source(Collections.singletonMap("field", "doc"), MediaTypeRegistry.JSON));
            @Override
                    + "reason=Validation Failed: 1: fetching source can not be disabled;]",
            List<TermVectorsResponse.TermVector> expectedTVlist = Collections.singletonList(expectedTV);
import org.joda.time.DateTimeZone;
        {
                    if (erroneous) {
            }
    // Not entirely sure if _termvectors belongs to CRUD, and in the absence of a better place, will have it here
                assertEquals(expectedRespFields.get(i).size(), tvResponse.getTermVectorsList().size());
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
                () -> execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync)
            OpenSearchException exception = expectThrows(
    public void testTermvectors() throws IOException {
            updateRequest.docAsUpsert(true);
                RequestOptions.DEFAULT
            for (int i = 0; i < responses.size(); i++) {
            assertEquals(Collections.singletonMap("field", "value2"), response.getResponses()[1].getResponse().getSource());
            createIndex(sourceIndex, settings, mappings);
        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
            // test _mtermvectors where MultiTermVectorsRequest constructed with adding each separate request
            );
            assertTrue("Bulk response must have failures.", bulkResponse.hasFailures());
        bulk.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
            expectedRespFields.add(Collections.singletonList("field2"));
    public void testDelete() throws IOException {
            assertEquals(Collections.singletonMap("field", "value1"), response.getResponses()[0].getResponse().getSource());
public class CrudIT extends OpenSearchRestHighLevelClientTestCase {
            assertTrue(indexResponse.getShardInfo().getSuccessful() > 0);
                mtvRequest,
            GetRequest getRequest = new GetRequest("index", "id");
            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
    public void testExists() throws IOException {
            });
import org.opensearch.script.Script;
            String mapping = "\"_source\": {\"enabled\": false}";
        index.source("{\"field1\":\"value1\",\"field2\":\"value2\"}", MediaTypeRegistry.JSON);
        BulkResponse bulkResponse = responseRef.get();
            assertTrue(Strings.hasLength(indexResponse.getId()));
            assertTrue("Bulk response must have failures.", bulkResponse.hasFailures());
                    .versionType(VersionType.EXTERNAL)
                }
            assertNotNull(indexResponse.getShardInfo());
                RestStatus.OK,
                highLevelClient().bulk(
        assertEquals(RestStatus.OK, bulkResponse.status());
        index.source(document, MediaTypeRegistry.JSON);
            assertTrue(tvResponse.getFound());
            Map<String, Object> sourceAsMap = getResult.sourceAsMap();
            assertEquals(String.valueOf(i), bulkItemResponse.getId());
            assertEquals("one", sourceAsMap.get("field_1"));
    // see test `testSourceExists` with new API tests
