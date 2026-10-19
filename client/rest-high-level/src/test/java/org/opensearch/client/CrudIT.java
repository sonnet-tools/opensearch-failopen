                } else if (opType == DocWriteRequest.OpType.CREATE) {
                                    .status()
            assertEquals(id, indexResponse.getId());
                execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
                updateRequest.doc(singletonMap("field", "updated"), randomFrom(XContentType.values()));
                exception.getMessage()  
    }
import java.io.IOException;
        {
                final UpdateRequest updateRequest = new UpdateRequest("index", "id");
                deleteRequest.setIfPrimaryTerm(indexResponse.getPrimaryTerm());  
            MultiTermVectorsResponse mtvResponse = execute(  
                "field",
        }
            // used deprecated API existsSource(GetRequest, RequestOptions)
        for (int i = 0; i < nbItems; i++) {
        BulkRequest bulk = new BulkRequest();
        {
        String document = "{\"field1\":\"value1\",\"field2\":\"value2\"}";
            assertTrue(response.getResponses()[1].isFailed());
            String mappings = "\"properties\":{\"field\":{\"type\":\"text\"}, \"field2\":{\"type\":\"text\"}}";  
                execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);  
            createIndex(sourceIndex, settings, mappings);
                assertEquals(
            assertThat(tvResponse.getIndex(), equalTo(sourceIndex));
            String[] expectedIds = { "1", "2" };
            MultiTermVectorsRequest mtvRequest = new MultiTermVectorsRequest();  
            highLevelClient().index(
        }  
import org.opensearch.common.xcontent.XContentType;
    }
        BulkProcessor.Listener listener = new BulkProcessor.Listener() {  
                "OpenSearch exception [type=action_request_validation_exception, "
        BulkResponse bulkResponse = execute(bulkRequest, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);  
            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("test", "test").endObject());  
        {
                }
            Map<String, Object> sourceAsMap = getResult.sourceAsMap();
            assertEquals(RestStatus.CREATED, indexResponse.status());
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                highLevelClient().bulk(
    }  
            assertEquals(RestStatus.NOT_FOUND, exception.status());  
        }
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();  
            }  
        bulk.add(index);  
            assertEquals("index", response.getResponses()[0].getIndex());  
            TermVectorsResponse tvResponse = execute(tvRequest, highLevelClient()::termvectors, highLevelClient()::termvectorsAsync);  
            UpdateRequest updateRequest = new UpdateRequest("index", "with_doc_as_upsert");
        MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);  
                        assertEquals(RestStatus.CREATED, highLevelClient().index(createRequest, RequestOptions.DEFAULT).status());
            updateRequest.fetchSource("field_*", "field_3");
            OpenSearchException exception = expectThrows(  
            assertEquals(DocWriteResponse.Result.NOOP, updateResponse.getResult());  
                "valuex",
        IndexRequest index = new IndexRequest("index").id("id");
            TermVectorsRequest tvRequest3 = new TermVectorsRequest(sourceIndex, "2");
            List<List<String>> expectedRespFields = new ArrayList<>();
                    .source(Collections.singletonMap("foo", "bar"))
            assertEquals(RestStatus.CONFLICT, exception.status());
                            new IndexRequest(sourceIndex).id("2")  
            assertEquals(RestStatus.NOT_FOUND, exception.status());
                () -> execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync)
                    updateRequest.setIfPrimaryTerm(lastUpdatePrimaryTerm);
        }  
            );
        {
            assertEquals("id", getResponse.getId());
        {  
            );
                    );
                        assertEquals(
    public void testDelete() throws IOException {  
        }
                        )
            bulkRequest.add(new IndexRequest().id("1").source("{ \"name\": \"Biden\" }", XContentType.JSON));  
            () -> execute(request, highLevelClient()::termvectors, highLevelClient()::termvectorsAsync)
                expectedFieldStats,
            GetResult getResult = updateResponse.getGetResult();
                    bulkRequest.add(updateRequest);
            assertEquals(RestStatus.OK, updateResponse.status());
            assertFalse("Should not auto-create the '" + indexAliasName + "' index.", indexExists(indexAliasName));
                IndexRequest indexRequest = new IndexRequest("index").id("missing_pipeline");  
        index.source(document, MediaTypeRegistry.JSON);
                indexRequest.setPipeline("missing");
                new IndexRequest("index").id(docId).source(Collections.singletonMap("foo", "bar")).routing("foo"),  
            updateRequest.fetchSource(true);
    public void testTermvectorsWithNonExistentIndex() {
            assertEquals(RestStatus.CONFLICT, exception.status());  
            String indexAliasName = "testindex-4";
        {
        index.source(document, MediaTypeRegistry.JSON);
            assertEquals(expectedResponse, response.getSource());
        {
            assertFalse(getResponse.isExists());
        }
            assertEquals(1L, updateResponse.getVersion());
import org.opensearch.client.core.TermVectorsRequest;  
            assertEquals(RestStatus.CREATED, indexResponse.status());
            indexRequest.version(12L);  
            assertTrue(getResponse.isExists());  
            assertTrue(getResponse.isExists());  
        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);  
                String id = String.valueOf(i);
            GetResult getResult = updateResponse.getGetResult();
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);  
            @Override
                highLevelClient().bulk(  
            }
            assertEquals(docId, deleteResponse.getId());
                listener  
            assertEquals(0, indexResponse.getShardInfo().getFailed());
                        UpdateRequest updateRequest = new UpdateRequest("index", id).doc(new IndexRequest().source(mediaType, "id", i));  
            assertEquals("does_not_exist", getResponse.getId());  
        }
            assertEquals(2, response.getResponses().length);
                                .source(Collections.singletonMap("field", "value2"), MediaTypeRegistry.JSON)
        assertEquals(RestStatus.OK, bulkResponse.status());
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
            assertNull(response.getResponses()[0].getFailure());
                mtvRequest,
                assertEquals(expectedRespFields.get(i).size(), tvResponse.getTermVectorsList().size());  
            {
        highLevelClient().index(index, RequestOptions.DEFAULT);
            });
            updateRequest.script(script);
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
                );  
            TermVectorsRequest tvRequest = new TermVectorsRequest(sourceIndex, docBuilder);
            assertTrue(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));  
            assertNull(response.getResponses()[0].getResponse());  
import org.opensearch.core.common.bytes.BytesReference;
                                RestStatus.CREATED,  
                exception.getMessage()
                assertEquals(errors[i] ? RestStatus.NOT_FOUND : RestStatus.OK, bulkItemResponse.status());
                        .setRefreshPolicy(RefreshPolicy.IMMEDIATE),  
            assertEquals("index", indexResponse.getShardId().getIndexName());
        assertNull(error.get());
        }
    public void testBulkProcessorIntegration() throws IOException {
                new IndexRequest().index(indexAliasName).id("1").setRequireAlias(true).source("{ \"name\": \"Biden\" }", XContentType.JSON)
            BulkProcessor processor = BulkProcessor.builder(
        }
            tvRequest1.setFields("field");
                    + "version conflict, required seqNo [2], primary term [2]. current document has seqNo [3] and primary term [1]]",  
                assertThat(exception.getMessage(), containsString("OpenSearch exception [type=version_conflict_engine_exception"));
    public void testParamsEncode() throws IOException {  
            updateRequest.scriptedUpsert(true);  
            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
            GetRequest getRequest = new GetRequest("index", "id");  
            Map<String, Object> expectedResponse = new HashMap<>();
            assertEquals(RestStatus.NOT_FOUND, exception.status());
            assertTrue(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);  
        }
import org.opensearch.core.xcontent.XContentBuilder;
            mtvRequest.add(tvRequest1);  
            List<String> ids = new ArrayList<>();
            assertEquals("index", updateResponse.getIndex());
    public void testMultiGetWithIds() throws IOException {
            String docId = "id";  
 * KIND, either express or implied.  See the License for the
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
        index = new IndexRequest("index").id("id2");
        }
            assertEquals(RestStatus.CREATED, indexResponse.status());
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
                new IndexRequest("index").id(docId)
        }
            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
        {
 * Licensed to Elasticsearch under one or more contributor  
            assertTrue(response.getResponses()[0].isFailed());
import org.opensearch.index.VersionType;
            IndexRequest indexRequest = new IndexRequest("index").id(id);  
            );
            // test the behavior of fields param
            assertEquals("index", getResponse.getIndex());
            );
                execute(wrongRequest, highLevelClient()::index, highLevelClient()::indexAsync);  
        index.source("{\"field\":\"value1\"}", MediaTypeRegistry.JSON);
            assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
    private void validateBulkResponses(int nbItems, boolean[] errors, BulkResponse bulkResponse, BulkRequest bulkRequest) {  
            tvRequest.setFields("field");
import org.opensearch.script.Script;
                    )  
            indexRequest.source("field", "value");
                bulkRequest.add(deleteRequest);
            assertEquals(
            assertEquals(expectedResponse, response.getSource());
import org.joda.time.DateTimeZone;
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");  
                    } else if (opType == DocWriteRequest.OpType.UPDATE) {
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
                            RestStatus.CREATED,  
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);  
            ).setConcurrentRequests(0).setBulkSize(new ByteSizeValue(5, ByteSizeUnit.GB)).setBulkActions(nbItems + 1).build()
            updateRequest.doc(singletonMap("field", "value"), randomFrom(XContentType.values()));  
 */
            );  
                assertTrue(tvResponse.getFound());
    }
            OpenSearchException exception = expectThrows(
                    updateRequest.setIfPrimaryTerm(lastUpdatePrimaryTerm + 1);
            assertTrue(indexResponse.getShardInfo().getSuccessful() > 0);  
        }
            final Map<String, String> doc2 = new HashMap<>();
            bulkRequest.add(
            bulkRequest.requireAlias(true);  
            DocWriteRequest.OpType requestOpType = bulkRequest.requests().get(i).opType();
            assertEquals(RestStatus.CREATED, updateResponse.status());
            GetResponse getResponse = highLevelClient().get(getRequest, RequestOptions.DEFAULT);
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
                "OpenSearch exception [type=version_conflict_engine_exception, "  
                highLevelClient()::mtermvectorsAsync
import org.opensearch.index.get.GetResult;  
            assertEquals(  
            }
                        highLevelClient().index(new IndexRequest("index").id(id).source("field", -1), RequestOptions.DEFAULT).status()
            highLevelClient().index(  
                    if (opType == DocWriteRequest.OpType.INDEX) {
                DeleteRequest deleteRequest = new DeleteRequest("index", id);
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);  
            assertEquals("index", indexResponse.getIndex());
            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
        {  
            assertEquals("index", indexResponse.getIndex());  
            List<TermVectorsResponse> responses = mtvResponse.getTermVectorsResponses();  
                updateRequest.doc(singletonMap("field", "with_seq_no_conflict"), randomFrom(XContentType.values()));
                "OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]",
        {  
        {
            assertEquals("index", indexResponse.getShardId().getIndex().getName());
            OpenSearchException exception = expectThrows(  
                    OpenSearchStatusException.class,
            highLevelClient().index(
            expectedFields.add("field2");
            );
            assertEquals("index", updateResponse.getIndex());
                () -> execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync)
            GetRequest getRequest = new GetRequest(noSourceIndex, "1");
                "OpenSearch exception [type=version_conflict_engine_exception, reason=[id]: "
            assertEquals(DocWriteResponse.Result.NOT_FOUND, deleteResponse.getResult());
            assertFalse("Should not auto-create the '" + indexAliasName + "' index.", indexExists(indexAliasName));  
            assertEquals("value1", sourceAsMap.get("field1"));
        highLevelClient().index(index, RequestOptions.DEFAULT);
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);  
            indexRequest.versionType(VersionType.EXTERNAL);
            GetRequest getRequest = new GetRequest("index", "id");
            createIndex(sourceIndex, settings, mappings);
        {
            mtvRequest.add(tvRequest3);
            OpenSearchException.class,  
        bulk.setRefreshPolicy(RefreshPolicy.IMMEDIATE);  
                UpdateRequest updateRequest = new UpdateRequest("index", "require_alias").setRequireAlias(true);
                        }
            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
        }
            assertEquals("id", getResponse.getId());
            GetRequest getRequest = new GetRequest("index", "does_not_exist").version(1);  
            assertTrue(getResponse.isSourceEmpty());  
            assertTrue(tvResponse.getFound());  
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
                        .add(new IndexRequest(sourceIndex).id("2").source(doc2, MediaTypeRegistry.JSON))  
            indexRequest.source("field", "value");
            assertNull(requestRef.get());
            assertNull(getResponse.getSourceAsString());
                    + "version conflict, current version [1] is different than the one provided [2]]",
        {  
        {
            Map<String, Object> expectedResponse = new HashMap<>();
            assertFalse(getResponse.isSourceEmpty());
            long lastUpdatePrimaryTerm;
import org.opensearch.core.common.Strings;  
            assertEquals(
        }  
            assertEquals("id#1", indexResponse.getId());
            indexRequest.source("field", "value");
                deleteRequest.setIfSeqNo(indexResponse.getSeqNo());
    }
                Collections.singletonList(expectedTerm)  
        }
            );  
            assertEquals("initialized", getResult.sourceAsMap().get("field"));  
        }
                1,
                }  
            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
            assertEquals(expectedResponse, response.getSource());
            doc2.put("field", "value2");  
            String indexAliasName = "testindex-1";
import org.opensearch.action.delete.DeleteResponse;
        String id = "id+id";
            assertEquals("id2", response.getResponses()[1].getId());
            assertEquals(Collections.singletonMap("field", "value1"), response.getResponses()[0].getResponse().getSource());
            DeleteRequest deleteRequest = new DeleteRequest("index", docId).routing("foo");  
import java.util.concurrent.atomic.AtomicReference;
        {
                "Update request cannot have different content types for doc [JSON] and upsert [YAML] documents",
                wrongRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());  
            assertEquals(docId, deleteResponse.getId());  
            OpenSearchException exception = expectThrows(OpenSearchException.class, () -> {
            {
            IndexResponse indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);  
            assertEquals("with_scripted_upsert", updateResponse.getId());  
            assertEquals(13L, updateResponse.getVersion());  
                                highLevelClient().index(new IndexRequest("index").id(id).source("field", -1), RequestOptions.DEFAULT)
        {  
    }
        {  
            TermVectorsRequest tvRequest2 = new TermVectorsRequest(sourceIndex, docBuilder);
            expectedResponse.put("field1", "value1");  
import org.opensearch.core.rest.RestStatus;
            TermVectorsResponse.TermVector expectedTV = new TermVectorsResponse.TermVector(  
        validateBulkResponses(nbItems, errors, bulkResponse, bulkRequest);  
            indexRequest.routing(routing);  
        }  
        {
                ).status()
                );
            assertArrayEquals(expectedIds, ids.toArray());
            assertEquals(
            );
            assertEquals("id2", response.getResponses()[1].getId());
 * license agreements. See the NOTICE file distributed with
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");  
        IndexRequest index = new IndexRequest("index").id("id1");
            );
        {
package org.opensearch.client;
        {  
    public void testGetSource() throws IOException {
import org.opensearch.action.index.IndexRequest;  
            indexRequest.source("field", "value");
                () -> execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync)  
            expectedResponse.put("field2", "value2");
        {
}
                        IndexRequest indexRequest = new IndexRequest("index").id(id).source(mediaType, "id", i);  
            );
                    updateRequest.setIfSeqNo(lastUpdateSeqNo + 1);  
                    tvResponse.getTermVectorsList().stream().map(tv -> tv.getFieldName()).collect(Collectors.toList())  
                        if (erroneous) {
            }  
            TermVectorsRequest tvRequest1 = new TermVectorsRequest(sourceIndex, "1");  
            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));  
                    + " and [require_alias] request flag is [true] and [index] is not an alias]",  
import org.opensearch.client.core.MultiTermVectorsRequest;
        highLevelClient().index(index, RequestOptions.DEFAULT);  
            GetResponse getResponse = highLevelClient().get(getRequest, RequestOptions.DEFAULT);  
    // Not entirely sure if _termvectors belongs to CRUD, and in the absence of a better place, will have it here  
                    )
        {  
                    updateRequest.setIfSeqNo(lastUpdateSeqNo + (randomBoolean() ? 0 : 1));  
            assertEquals("index", getResponse.getIndex());
            // Testing version type with a wrong version
                    if (erroneous) {  
            assertThat(Integer.valueOf(tvResponse.getId()), equalTo(1));
            getRequest.fetchSourceContext(FetchSourceContext.FETCH_SOURCE);  
            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);  
                errors[i] = erroneous;  
            mtvRequest.add(tvRequest1);
                            indexRequest.setIfPrimaryTerm(12L);  
            assertEquals(RestStatus.OK, updateResponse.status());  
            MultiGetResponse response = execute(multiGetRequest, highLevelClient()::mget, highLevelClient()::mgetAsync);
        }
        {
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            multiGetRequest.add("index", "id2");
                response.getResponses()[1].getFailure().getFailure().getMessage()
            indexResponse = execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
            assertEquals("index", getResponse.getIndex());
                execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);
        {
        final String noSourceIndex = "no_source";
            assertEquals(1L, updateResponse.getVersion());  
        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);  
        );
            // prepare : index docs
            assertEquals(RestStatus.NOT_FOUND, exception.status());  
            assertEquals(
            UpdateRequest updateRequest = new UpdateRequest("index", "with_script");  
                        }
                updateRequest.doc(new IndexRequest().source(Collections.singletonMap("field", "doc"), MediaTypeRegistry.JSON));  
        {  
                exception.getMessage()
            UpdateRequest updateRequest = new UpdateRequest("index", "with_doc");  
    // see test `testSourceExists` with new API tests
                        if (erroneous == false) {
    public void testGet() throws IOException {  
import java.util.Map;
/*  
            mtvRequest.add(tvRequest2);
            assertEquals(RestStatus.CREATED, indexResponse.status());  
            // Testing non existing document
            GetRequest getRequest = new GetRequest("index", "id").routing(routing);  
        {  
        validateBulkResponses(nbItems, errors, bulkResponse, bulkRequest);
            assertEquals(RestStatus.CREATED, indexResponse.status());  
                highLevelClient().bulk(
            for (int i = 0; i < responses.size(); i++) {
            updateRequest.upsert(singletonMap("level", "A"));
                        .add(
            String mapping = "\"_source\": {\"enabled\": false}";
            expectedRespFields.add(Collections.singletonList("field"));  
            multiGetRequest.add("index", "id2");
        }  
            tvRequest1.setFields("field");
            });
            String indexAliasName = "testindex-3";
 *    http://www.apache.org/licenses/LICENSE-2.0
                ).status()
            assertTrue(indexResponse.getShardInfo().getTotal() > 0);
        String indexPattern = "<logstash-{now/M}>";
            assertFalse("Should not auto-create the '" + indexAliasName + "' index.", indexExists(indexAliasName));
                Collections.singletonList(expectedTerm)  
            assertEquals(2, response.getResponses().length);  
            );
                null,
                        processor.add(createRequest);  
            TermVectorsRequest tvRequestTemplate = new TermVectorsRequest(sourceIndex, "fake_id");  
            assertEquals("with_doc_as_upsert", updateResponse.getId());  
        final String sourceIndex = "index1";
                indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
            TermVectorsResponse.TermVector.FieldStatistics expectedFieldStats = new TermVectorsResponse.TermVector.FieldStatistics(2, 2, 2);
            MultiGetRequest multiGetRequest = new MultiGetRequest();  
                indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());
        }  
            TermVectorsRequest tvRequest2 = new TermVectorsRequest(sourceIndex, "2");
                highLevelClient()::mtermvectors,  
    public void testUrlEncode() throws IOException {
        {
            BulkResponse bulkResponse = execute(bulkRequest, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);
                        new IndexRequest(sourceIndex).id("1").source(Collections.singletonMap("field", "value1"), MediaTypeRegistry.JSON)  
 * ownership. Elasticsearch licenses this file to you under  
                exception.getMessage()
                "OpenSearch exception [type=version_conflict_engine_exception, reason=["
                    }  
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
public class CrudIT extends OpenSearchRestHighLevelClientTestCase {
                assertTrue(tvResponse.getFound());
            } else if (requestOpType == DocWriteRequest.OpType.UPDATE) {  
 *
        }
                assertEquals(errors[i] ? RestStatus.CONFLICT : RestStatus.CREATED, bulkItemResponse.status());
import org.opensearch.action.delete.DeleteRequest;  
        highLevelClient().index(index, RequestOptions.DEFAULT);
            updateRequest.doc(singletonMap("field", "value"), randomFrom(XContentType.values()));
                    IndexRequest createRequest = new IndexRequest("index").id(id).source(source, mediaType).create(true);
        index.source("{\"field\":\"value2\"}", MediaTypeRegistry.JSON);
        AtomicReference<Throwable> error = new AtomicReference<>();
            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("version", 2).endObject());
            updateRequest.fetchSource(true);  
                assertThat(tvResponse.getIndex(), equalTo(sourceIndex));  
                assertThat(tvResponse.getIndex(), equalTo(sourceIndex));
            GetSourceRequest getSourceRequest = new GetSourceRequest(noSourceIndex, "1");
        bulk.add(new IndexRequest("index").id("id2").source("{\"field\":\"value2\"}", MediaTypeRegistry.JSON));  
            assertTrue("Bulk response must have failures.", bulkResponse.hasFailures());
        }
            Settings settings = Settings.builder().put("number_of_shards", 1).put("number_of_replicas", 0).build();
            GetRequest getRequest = new GetRequest("index", "id");
        }  
                mtvRequest,
            expectedResponse.put("field2", "value2");
                exception.getMessage()  
        }  
        };
            assertTrue(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
                assertEquals(errors[i] ? RestStatus.NOT_FOUND : RestStatus.OK, bulkItemResponse.status());
            assertEquals(12L, indexResponse.getVersion());
            assertEquals(docId, deleteResponse.getId());  
            GetRequest getRequest = new GetRequest("index", "does_not_exist");
        {
            TermVectorsResponse.TermVector.FieldStatistics expectedFieldStats = new TermVectorsResponse.TermVector.FieldStatistics(2, 2, 2);
        {
            assertNotNull(indexResponse.getShardId());
            });
            MultiGetRequest multiGetRequest = new MultiGetRequest();
/*
            );
        {
                responseRef.set(response);
import org.opensearch.common.xcontent.XContentFactory;
        }
            assertEquals(RestStatus.OK, updateResponse.status());
        IndexRequest index = new IndexRequest("index").id("id");  
            assertEquals("external_version_type", indexResponse.getId());
                () -> execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync)
import static org.hamcrest.Matchers.containsString;  
        }  
        }
import org.opensearch.core.xcontent.MediaType;
            assertEquals("index", response.getResponses()[1].getIndex());  
            // test _termvectors on real documents  
            }
    }
            assertEquals(
            assertEquals(RestStatus.CREATED, updateResponse.status());
 * specific language governing permissions and limitations
                } else if (opType == DocWriteRequest.OpType.UPDATE) {
    public void testIndex() throws IOException {
            TermVectorsResponse.TermVector.Term expectedTerm = new TermVectorsResponse.TermVector.Term(  
            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
            {
            updateRequest.doc(singletonMap("doc_status", "updated"));
            TermVectorsResponse.TermVector expectedTV = new TermVectorsResponse.TermVector(  
        }  
            assertThat(tvResponse.getIndex(), equalTo(sourceIndex));
            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);  
            assertEquals("index", indexResponse.getIndex());
            expectedRespFields.add(Collections.singletonList("field2"));
            assertEquals(1L, indexResponse.getVersion());
        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
                    .versionType(VersionType.EXTERNAL)
            assertEquals(expectedTVlist, tvResponse.getTermVectorsList());
        {
            assertEquals(12L, indexResponse.getVersion());
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
        {  
                DocWriteRequest.OpType opType = randomFrom(DocWriteRequest.OpType.values());
                final UpdateRequest updateRequest = new UpdateRequest("index", "id");  
        }
            boolean erroneous = randomBoolean();
        }
        AtomicReference<BulkRequest> requestRef = new AtomicReference<>();  
            GetRequest getRequest = new GetRequest("index", "id");
            }
        }  
            assertFalse(getResponse.isSourceEmpty());
                    IndexRequest indexRequest = new IndexRequest("index").id(id).source(source, mediaType);  
 *
            assertEquals("index", indexResponse.getIndex());
                highLevelClient()::mtermvectorsAsync  
            IndexRequest indexRequest = new IndexRequest("index").id("with_script");
                    new BulkRequest().add(
        {  
        {
import java.util.Collections;
            assertNotNull(indexResponse.getShardInfo());
                ids.add(tvResponse.getId());
            );  
        }  
import org.opensearch.core.common.unit.ByteSizeUnit;
                IndexRequest wrongRequest = new IndexRequest("index").id("id");
                        processor.add(indexRequest);
            multiGetRequest.add("index", "id1");
                        if (erroneous) {  
            tvRequest3.setFields("field", "field2");  
import org.opensearch.action.DocWriteResponse;
            assertTrue(getResponse.isExists());  
            } else if (requestOpType == DocWriteRequest.OpType.DELETE) {  
        }  
            assertEquals("id1", response.getResponses()[0].getFailure().getId());
            assertEquals(expectedRespFields.size(), responses.size());
    public void testDeprecatedSourceExists() throws IOException {  
import org.opensearch.action.get.GetResponse;  
                requestRef.set(request);  
            DeleteRequest deleteRequest = new DeleteRequest("index", docId).setIfSeqNo(2).setIfPrimaryTerm(2);
                "OpenSearch exception [type=illegal_argument_exception, " + "reason=pipeline with id [missing] does not exist]",  
            XContentBuilder docBuilder = XContentFactory.jsonBuilder();
                    }
            assertEquals("index", response.getResponses()[1].getIndex());
            // test _mtermvectors where MultiTermVectorsRequest constructed with adding each separate request
            tvRequest2.setFields("field2");
        String expectedIndex = "logstash-"  
            );
            mtvRequest.add(tvRequest2);  
        {  
            updateRequest.script(new Script(ScriptType.INLINE, "painless", "ctx._source.level = params.test", singletonMap("test", "C")));
        index.source("{\"field1\":\"value1\",\"field2\":\"value2\"}", MediaTypeRegistry.JSON);  
 * the Apache License, Version 2.0 (the "License"); you may
            assertNull(response.getResponses()[1].getResponse());  
            assertEquals(expectedIndex, getResponse.getIndex());
                (request, bulkListener) -> highLevelClient().bulkAsync(request, RequestOptions.DEFAULT, bulkListener),
                () -> execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync)
                exception.getMessage()  
            assertFalse(sourceAsMap.containsKey("field_3"));
        }
            assertEquals("two", sourceAsMap.get("field_2"));  
import org.opensearch.OpenSearchException;
            }
            Script script = new Script(ScriptType.INLINE, "painless", "ctx._source.counter += params.count", singletonMap("count", 8));
            assertEquals("index", response.getResponses()[0].getFailure().getIndex());
                assertTrue(tvResponse.getFound());
                IndexRequest indexRequest = new IndexRequest("index").id("missing_alias").setRequireAlias(true);  
    }  
                getRequest.fetchSourceContext(new FetchSourceContext(true, new String[] { "field1" }, Strings.EMPTY_ARRAY));
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
            assertEquals(20, updateResponse.getGetResult().sourceAsMap().get("counter"));  
        {
            if (randomBoolean()) {  
            assertEquals(
                boolean erroneous = randomBoolean();
            Map<String, Object> expectedResponse = new HashMap<>();
                updateRequest.setIfSeqNo(lastUpdateSeqNo);
 */  
            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);  
                        RestStatus.CREATED,  
                RequestOptions.DEFAULT  
            );  
            assertEquals("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]", exception.getMessage());
import org.opensearch.client.indices.GetIndexRequest;
        {
            IndexRequest indexRequest = new IndexRequest("index").id("id");
    public void testMultiGet() throws IOException {  
                        );
            long lastUpdateSeqNo;  
        {
            if (randomBoolean()) {
                () -> execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync)
        }  
            assertEquals("C", getResult.sourceAsMap().get("level"));
            BulkRequest bulkRequest = new BulkRequest(indexAliasName);  
                null,
import org.opensearch.action.get.MultiGetResponse;
    public void testGetIdWithPlusSign() throws Exception {  
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");  
            final IndexRequest indexRequest = new IndexRequest("index").id("with_create_op_type");
import org.opensearch.client.core.TermVectorsResponse;
                null,  
                null,
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");  
            });
            assertEquals(RestStatus.CREATED, indexResponse.status());
            assertEquals("index", indexResponse.getIndex());  
            assertEquals(expectedTVlist, tvResponse.getTermVectorsList());  
            );  
            );
            );
            indexRequest.source("field", "value");
                RequestOptions.DEFAULT
                    processor.add(deleteRequest);
                    }  
            assertNull(responseRef.get());  
            UpdateRequest updateRequest = new UpdateRequest("index", "with_upsert");
 *  
                } else {
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
            }  
    }
            String docId = "routing";
                    XContentBuilder.builder(mediaType.xContent()).startObject().field("id", i).endObject()  
            assertEquals(RestStatus.CREATED, updateResponse.status());
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());  
            );
            bulkRequest.requireAlias(true);
                execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
            }  
            MultiTermVectorsResponse mtvResponse = execute(
        {  
            assertEquals(expectedResponse, response.getSource());  
        index.setRefreshPolicy(RefreshPolicy.IMMEDIATE);  
        }  
            assertEquals(RestStatus.CONFLICT, exception.status());
            assertEquals(RestStatus.NOT_FOUND, exception.status());
            assertEquals(13L, updateResponse.getVersion());
        }
            IndexRequest indexRequest = new IndexRequest(indexPattern).id("id#1");  
                Collections.singletonList(expectedToken)  
                mtvRequest,
                    .version(12),
            TermVectorsRequest tvRequest = new TermVectorsRequest(sourceIndex, "1");
                assertFalse(bulkItemResponse.isFailed());
                exception.getMessage()  
import java.util.stream.Collectors;  
                exception.getMessage()
            assertEquals(  
        }  
            assertEquals("index", bulkItemResponse.getIndex());
            );
            expectedResponse.put("field1", "value1");  
                TermVectorsResponse tvResponse = responses.get(i);  
                    } else if (opType == DocWriteRequest.OpType.CREATE) {
            updateRequest.fetchSource(true);  
            MultiTermVectorsResponse mtvResponse = execute(
                RequestOptions.DEFAULT
            assertTrue(tvResponse.getFound());
        AtomicReference<BulkResponse> responseRef = new AtomicReference<>();
        assertEquals(nbItems, bulkResponse.getItems().length);  
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));  
            assertEquals(2L, updateResponse.getVersion());
                        .setRefreshPolicy(RefreshPolicy.IMMEDIATE),
            bulkRequest.add(new IndexRequest().id("2").source("{ \"name\": \"Trump\" }", XContentType.JSON));
    public void testSourceDoesNotExist() throws IOException {  
            TermVectorsResponse tvResponse = execute(tvRequest, highLevelClient()::termvectors, highLevelClient()::termvectorsAsync);  
        }
                OpenSearchException.class,
 * Modifications Copyright OpenSearch Contributors. See
        }  
            assertEquals("created", getResult.sourceAsMap().get("doc_status"));
        {
                assertThat(lastUpdatePrimaryTerm, greaterThanOrEqualTo(1L));
        }
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
            IndexRequest indexRequest = new IndexRequest("index").id("noop");
            // Testing routing  
 * GitHub history for details.
    public void testTermvectors() throws IOException {
                            assertEquals(
            getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);
                exception.getMessage()  
            TermVectorsRequest tvRequest1 = new TermVectorsRequest(sourceIndex, "1");
            GetRequest getRequest = new GetRequest("index", "id").version(2);
            getRequest.fetchSourceContext(new FetchSourceContext(true, Strings.EMPTY_ARRAY, new String[] { "field1" }));
            // Testing deletion
            tvRequestTemplate.setFields("field");
            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("version", 1).endObject());
            assertEquals(id, getResponse.getId());
                assertEquals(errors[i], bulkItemResponse.isFailed());
            );  
                if (erroneous == false) {
                RestStatus.OK,
            assertFalse(response.getResponses()[1].isFailed());  
                assertThat(tvResponse.getIndex(), equalTo(sourceIndex));
            assertEquals("index", deleteResponse.getIndex());
                            assertEquals(RestStatus.CREATED, highLevelClient().index(createRequest, RequestOptions.DEFAULT).status());
            GetRequest getRequest = new GetRequest("index", docId);
            updateRequest.fetchSource(true);
                    expectedRespFields.get(i),
            });
                "OpenSearch exception [type=version_conflict_engine_exception, reason=[with_create_op_type]: "
            assertEquals(1, sourceAsMap.size());
import java.util.HashMap;
        {
                assertEquals(indexResponse.getVersion() + 1, updateResponse.getVersion());
                            );  
            assertEquals(1L, getResponse.getVersion());
        }  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    }
                lastUpdatePrimaryTerm = updateResponse.getPrimaryTerm();  
                Collections.singletonList(expectedToken)  
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
        }
        {
            assertEquals(routing, getResponse.getField("_routing").getValue());
            + DateTimeFormat.forPattern("YYYY.MM.dd").print(new DateTime(DateTimeZone.UTC).monthOfYear().roundFloorCopy());
        {
        {  
 * Unless required by applicable law or agreed to in writing,
            assertEquals("index", updateResponse.getIndex());  
        }
            assertFalse(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));  
            assertEquals("index", getResponse.getIndex());
                    if (erroneous == false) {
                    assertEquals(
                if (randomBoolean()) {
                        new IndexRequest(noSourceIndex).id("1").source(Collections.singletonMap("foo", 1), MediaTypeRegistry.JSON)
                lastUpdateSeqNo = updateResponse.getSeqNo();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals(1L, updateResponse.getVersion());
        {  
        int nbItems = randomIntBetween(10, 100);  
import org.joda.time.format.DateTimeFormat;  
                "OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]",
import static java.util.Collections.singletonMap;
            assertNull(getResponse.getSourceAsString());  
                    }
        {
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));
            );  
            OpenSearchStatusException exception = expectThrows(
        try (  
            doc2.put("field2", "foo var");
            for (int i = 0; i < nbItems; i++) {  
            IndexRequest indexRequest = new IndexRequest("index").id("external_version_type");
            }  
                    .version(12),  
            // used new API existsSource(GetSourceRequest, RequestOptions)  
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
        assertTrue(highLevelClient().indices().exists(new GetIndexRequest(indexPattern, "index"), RequestOptions.DEFAULT));  
            Map<String, Object> expectedResponse = new HashMap<>();
        }
            assertEquals("id", indexResponse.getId());
            );
            );
            multiGetRequest.add("index", "id1");  
            indexRequest.versionType(VersionType.EXTERNAL);
            assertFalse(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));
            indexRequest.source("field_1", "one", "field_3", "three");
                        );
        }  
            assertEquals("index", deleteResponse.getIndex());
    }
        bulk.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
            assertEquals("index", deleteResponse.getIndex());  
            assertEquals("id", getResponse.getId());
import org.opensearch.action.get.GetRequest;
        }
            );
            String indexAliasName = "testindex-2";  
            );  
        {
        // parameters are encoded by the low-level client but let's test that everything works the same when we use the high-level one
            getRequest.fetchSourceContext(new FetchSourceContext(true, new String[] { "field1" }, Strings.EMPTY_ARRAY));  
        BulkRequest bulkRequest = new BulkRequest();
            BulkResponse bulkResponse = execute(bulkRequest, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);  
import org.opensearch.action.get.MultiGetRequest;
            // Testing version type  
        {
        }
            assertEquals("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]", exception.getMessage());  
            String docId = "version_conflict";  
        {
                    + docId
import java.util.ArrayList;  
        {  
            updateRequest.upsert(singletonMap("doc_status", "created"));  
            assertEquals(  
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
import org.opensearch.client.core.GetSourceResponse;  
            OpenSearchException exception = expectThrows(  
                    () -> execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync)
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));  
                OpenSearchException.class,
            assertTrue(getResponse.isExists());
            assertTrue(getResponse.isSourceEmpty());
        MediaType mediaType = randomFrom(MediaTypeRegistry.JSON, XContentType.SMILE);  
        final XContentType xContentType = randomFrom(XContentType.values());  
                    new BulkRequest().add(
            TermVectorsResponse.TermVector.Token expectedToken = new TermVectorsResponse.TermVector.Token(0, 6, 0, null);
            IndexRequest indexRequest = new IndexRequest("index").id("id");
            List<TermVectorsResponse.TermVector> expectedTVlist = Collections.singletonList(expectedTV);
            assertEquals("one", sourceAsMap.get("field_1"));
        {  
            assertEquals(Collections.singletonMap("field", "value2"), response.getResponses()[1].getResponse().getSource());
            GetSourceRequest getRequest = new GetSourceRequest("index", "does_not_exist");
            if (opType == DocWriteRequest.OpType.DELETE) {  
            bulkRequest.add(new IndexRequest().id("1").setRequireAlias(true).source("{ \"name\": \"Biden\" }", XContentType.JSON));
                    if (erroneous) {
            indexRequest.opType(DocWriteRequest.OpType.CREATE);
            GetRequest getRequest = new GetRequest("index", "does_not_exist");  
import org.opensearch.action.update.UpdateRequest;  
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
    // Not entirely sure if _termvectors belongs to CRUD, and in the absence of a better place, will have it here
                "OpenSearch exception [type=index_not_found_exception, reason=no such index [index]"
            GetRequest getRequest = new GetRequest("index", "id");
import org.opensearch.common.settings.Settings;  
        MultiGetRequest multiGetRequest = new MultiGetRequest();
        for (int i = 0; i < nbItems; i++) {  
            assertEquals(document, getResponse.getSourceAsString());  
            DeleteRequest deleteRequest = new DeleteRequest("index", docId).versionType(VersionType.EXTERNAL).version(13);  
            String mappings = "\"properties\":{\"field\":{\"type\":\"text\"}}";  
 * The OpenSearch Contributors require contributions made to  
                    + docId
        }
import org.opensearch.action.bulk.BulkItemResponse;
        }  
        }
            assertEquals("id#1", getResponse.getId());
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
                final UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
            assertEquals(docId, indexResponse.getId());
    }
        assertEquals(nbItems, bulkResponse.getItems().length);  
            GetRequest getRequest = new GetRequest("index").id(id);
            BulkResponse bulkResponse = execute(bulkRequest, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);
            assertEquals("index", getResponse.getIndex());  
            });
                assertEquals(exception.toString(), RestStatus.CONFLICT, exception.status());
            );
                        .add(new IndexRequest(noSourceIndex).id("2").source(Collections.singletonMap("foo", 2), MediaTypeRegistry.JSON))
        multiGetRequest.add("index", "id2");
        TermVectorsRequest request = new TermVectorsRequest("non-existent", "non-existent");  
            assertEquals("index", indexResponse.getIndex());
            assertEquals(1L, indexResponse.getVersion());
            GetRequest getRequest = new GetRequest(indexPattern, "id#1");
        String routing = "routing/中文value#1?";
            IndexResponse indexResponse = highLevelClient().index(
        }
        {
        {
            );
                updateRequest.doc(new IndexRequest().source(Collections.singletonMap("field", "doc"), MediaTypeRegistry.JSON));  
                BytesReference source = BytesReference.bytes(
            BulkRequest bulkRequest = new BulkRequest();  
            assertEquals("index", getResponse.getIndex());
                ).status()  
        }  
            expectedResponse.put("field2", "value2");
            assertTrue("Bulk response must have failures.", bulkResponse.hasFailures());
        }  
    public void testBulk() throws IOException {
    }  
            assertEquals(2L, indexResponse.getVersion());
            assertEquals(1L, indexResponse.getVersion());
 * compatible open source license.
            assertTrue(getResponse.isExists());
            assertEquals("id", indexResponse.getId());  
        }
            assertEquals(docId, getResponse.getId());  
            );
    }  
        int nbItems = randomIntBetween(10, 100);  
            bulkRequest.add(new IndexRequest().id("2").setRequireAlias(true).source("{ \"name\": \"Trump\" }", XContentType.JSON));
    public void testUpdate() throws IOException {  
            BulkItemResponse bulkItemResponse = bulkResponse.getItems()[i];
            assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            expectedFields.add("field");  
            GetRequest getRequest = new GetRequest("index", "id");
                        .setRefreshPolicy(RefreshPolicy.IMMEDIATE),
        IndexRequest index = new IndexRequest("index").id("id");
            assertFalse(response.getResponses()[0].isFailed());  
        bulk.add(new IndexRequest("index").id("id1").source("{\"field\":\"value1\"}", MediaTypeRegistry.JSON));
            assertEquals("with_upsert", updateResponse.getId());
                        }
                );
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
import org.opensearch.script.ScriptType;
            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);  
                if (opType == DocWriteRequest.OpType.DELETE) {  
            assertEquals(RestStatus.CONFLICT, exception.status());
                exception.getMessage()
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            XContentBuilder docBuilder = XContentFactory.jsonBuilder();
            indexRequest.source(singletonMap("field", "value"));
            String docId = "does_not_exist";  
            assertEquals(-1, getResponse.getVersion());
                new IndexRequest().index(indexAliasName).id("2").setRequireAlias(true).source("{ \"name\": \"Trump\" }", XContentType.JSON)
        }
    }  
                    + "]: version conflict, current version [12] is higher or equal to the one provided [10]]",  
 */  
    }
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
            String docId = "version_type";
                assertEquals(lastUpdateSeqNo + 1, updateResponse.getSeqNo());
            GetSourceRequest getRequest = new GetSourceRequest("index", "id");
            assertEquals("id", getResponse.getId());
                UpdateRequest updateRequest = new UpdateRequest("index", "id");
                    .source(Collections.singletonMap("foo", "bar"))
 * under the License.  
            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
        }
            // prepare : index docs
                final UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);  
            bulkRequest.add(
            assertEquals(
import org.opensearch.action.update.UpdateResponse;
                "OpenSearch exception [type=document_missing_exception, reason=[does_not_exist]: document missing]",
            assertEquals(  
            errors[i] = erroneous;  
        BulkRequest bulk = new BulkRequest();  
            doc1.put("field2", "hello world");
        {  
        }
            } else {  
                            indexRequest.setIfSeqNo(12L);
                            highLevelClient().index(new IndexRequest("index").id(id).source("field", -1), RequestOptions.DEFAULT).status()
        highLevelClient().bulk(bulk, RequestOptions.DEFAULT);
            doc1.put("field", "value1");  
            });  
            assertEquals(
import org.opensearch.action.bulk.BulkRequest;
            indexRequest.version(12L);
        }
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(RestStatus.CONFLICT, exception.status());
        {
            indexRequest = new IndexRequest("index").id("id");
            indexRequest.source(singletonMap("counter", 12));
                }
                "OpenSearch exception [type=resource_not_found_exception, " + "reason=Document not found [index]/[does_not_exist]]",  
            GetRequest getRequest = new GetRequest("index", "id");  
            getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);
        IndexRequest index = new IndexRequest("index").id("id");
            UpdateRequest updateRequest = new UpdateRequest("index", "does_not_exist");
                assertEquals(RestStatus.OK, updateResponse.status());
            @Override  
                OpenSearchStatusException.class,  
                "OpenSearch exception [type=index_not_found_exception, reason=no such index [index] and [require_alias] request flag is [true] and [index] is not an alias]",
        {  
                exception.getMessage()
            DeleteRequest deleteRequest = new DeleteRequest("index", docId);  
                            highLevelClient().index(new IndexRequest("index").id(id).source("field", -1), RequestOptions.DEFAULT).status()
            } else {
                }
                    + "version conflict, document already exists (current version [1])]",  
                RestStatus.OK,  
 * SPDX-License-Identifier: Apache-2.0
import org.joda.time.DateTime;
            assertEquals("id", indexResponse.getId());
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
        index.source("{\"field1\":\"value1\",\"field2\":\"value2\"}", MediaTypeRegistry.JSON);
            BulkRequest bulkRequest = new BulkRequest(indexAliasName);
            assertFalse("Should not auto-create the '" + indexAliasName + "' index.", indexExists(indexAliasName));  
            );
            assertEquals("index", indexResponse.getIndex());  
        {  
                        IndexRequest createRequest = new IndexRequest("index").id(id).source(mediaType, "id", i).create(true);
 * this work for additional information regarding copyright
            assertEquals(-1, indexResponse.getShardId().getId());  
import org.opensearch.client.core.GetSourceRequest;
        BulkResponse bulkResponse = responseRef.get();
        }
                        indexRequest.setIfSeqNo(12L);
            GetSourceRequest getRequest = new GetSourceRequest("index", "does_not_exist");
        }  
            MultiTermVectorsRequest mtvRequest = new MultiTermVectorsRequest(expectedIds, tvRequestTemplate);
        assertEquals(RestStatus.NOT_FOUND, exception.status());  
            assertEquals("index", indexResponse.getIndex());  
                RequestOptions.DEFAULT
        highLevelClient().index(index, RequestOptions.DEFAULT);
        }
            assertEquals("id1", response.getResponses()[0].getId());
                new IndexRequest("index").id(docId)  
            assertEquals(RestStatus.OK, updateResponse.status());  
                    DeleteRequest deleteRequest = new DeleteRequest("index", id);
            bulkRequest.add(new IndexRequest().index(indexAliasName).id("2").source("{ \"name\": \"Trump\" }", XContentType.JSON));
                OpenSearchException.class,
                    }  
                expectedFieldStats,
                    + "]: "
        }
        {  
        IndexRequest index = new IndexRequest("index").id("id");
                if (opType == DocWriteRequest.OpType.INDEX) {
            );
            assertEquals(
import static org.hamcrest.Matchers.equalTo;
                DeleteRequest deleteRequest = new DeleteRequest("index", docId).versionType(VersionType.EXTERNAL).version(10);
            final List<String> expectedFields = new ArrayList<>();
                OpenSearchException.class,  
                () -> execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync)
        }
            IndexResponse indexResponse = highLevelClient().index(indexRequest, RequestOptions.DEFAULT);
        {  
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
            TermVectorsResponse.TermVector.Term expectedTerm = new TermVectorsResponse.TermVector.Term(  
    // Not entirely sure if _mtermvectors belongs to CRUD, and in the absence of a better place, will have it here  
            assertEquals(1L, getResponse.getVersion());
                1,
            assertThat(indexResponse.getSeqNo(), greaterThanOrEqualTo(0L));
                "field",
            // test _termvectors on artificial documents
                null,
            assertEquals(
            createIndex(noSourceIndex, settings, mapping);  
 * not use this file except in compliance with the License.
    }  
    }
                    new BulkRequest().add(new IndexRequest(sourceIndex).id("1").source(doc1, MediaTypeRegistry.JSON))
            GetResult getResult = updateResponse.getGetResult();
            OpenSearchException exception = expectThrows(
 * You may obtain a copy of the License at  
                RestStatus.OK,  
            String docId = "wrong_version";
                OpenSearchStatusException exception = expectThrows(  
            IndexRequest indexRequest = new IndexRequest("index");
import org.opensearch.client.core.MultiTermVectorsResponse;
            }  
            for (TermVectorsResponse tvResponse : mtvResponse.getTermVectorsResponses()) {
            );  
            assertEquals(RestStatus.OK, indexResponse.status());
            assertNull(response.getResponses()[1].getFailure());
            assertEquals(i, bulkItemResponse.getItemId());
                        assertEquals(
                RequestOptions.DEFAULT  
            GetResponse getResponse = highLevelClient().get(getRequest, RequestOptions.DEFAULT);
        }
            updateRequest.detectNoop(false);  
                    RequestOptions.DEFAULT  
            assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);  
    public void testMultiTermvectors() throws IOException {
                    UpdateRequest updateRequest = new UpdateRequest("index", id).doc(new IndexRequest().source(source, mediaType));  
                highLevelClient()::mtermvectors,  
        }
            TermVectorsResponse.TermVector.Token expectedToken = new TermVectorsResponse.TermVector.Token(0, 6, 0, null);
            assertFalse(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));  
            expectedRespFields.add(expectedFields);
            highLevelClient().index(
    public void testSourceExists() throws IOException {
        {  
                    bulkRequest.add(createRequest);  
        {  
import org.opensearch.action.bulk.BulkProcessor;  
        assertTrue(bulkResponse.getTook().getMillis() > 0);
                wrongRequest.setIfSeqNo(1L).setIfPrimaryTerm(5L);
            assertEquals(RestStatus.CREATED, indexResponse.status());
            assertFalse(execute(getSourceRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
import org.opensearch.action.index.IndexResponse;
        {  
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
        assertTrue(bulkResponse.getTook().getMillis() > 0);
                exception.getMessage()  
                null,  
        {
        }
            GetRequest getRequest = new GetRequest("index", "does_not_exist");
            BulkRequest bulkRequest = new BulkRequest();
                OpenSearchException.class,
            assertEquals(RestStatus.NOT_FOUND, exception.status());  
            assertTrue(Strings.hasLength(indexResponse.getId()));  
            assertEquals(
                highLevelClient()::mtermvectorsAsync
                OpenSearchException.class,
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
            MultiGetResponse response = execute(multiGetRequest, highLevelClient()::mget, highLevelClient()::mgetAsync);  
                    RequestOptions.DEFAULT
                assertEquals(RestStatus.OK, updateResponse.status());  
            updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
 * software distributed under the License is distributed on an
            DeleteRequest deleteRequest = new DeleteRequest("index", docId);
                    RequestOptions.DEFAULT
            OpenSearchStatusException exception = expectThrows(OpenSearchStatusException.class, () -> {
import org.opensearch.action.DocWriteRequest;  
            assertEquals("_na_", indexResponse.getShardId().getIndex().getUUID());  
        multiGetRequest.add("index", "id1");  
            }  
            );
            @Override  
        BulkRequest bulkRequest = requestRef.get();
            IndexRequest indexRequest = new IndexRequest("index").id("with_doc");
            updateRequest.docAsUpsert(true);
            );
            assertEquals("index", getResponse.getIndex());
                highLevelClient()::mtermvectors,
            docBuilder.startObject().field("field", "valuex").endObject();  
            DocWriteRequest.OpType opType = randomFrom(DocWriteRequest.OpType.values());
                assertThat(lastUpdateSeqNo, greaterThanOrEqualTo(0L));
import org.opensearch.action.bulk.BulkResponse;
            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());  
        ) {
            indexRequest.source(XContentBuilder.builder(xContentType.xContent()).startObject().field("field", "test").endObject());  
            UpdateRequest updateRequest = new UpdateRequest("index", "with_scripted_upsert");  
        {
            }
            List<TermVectorsResponse.TermVector> expectedTVlist = Collections.singletonList(expectedTV);
            GetRequest getRequest = new GetRequest("index", "does_not_exist").version(1);
            if (requestOpType == DocWriteRequest.OpType.INDEX || requestOpType == DocWriteRequest.OpType.CREATE) {  
            assertEquals(String.valueOf(i), bulkItemResponse.getId());  
        boolean[] errors = new boolean[nbItems];
            bulkRequest.add(new IndexRequest().index(indexAliasName).id("1").source("{ \"name\": \"Biden\" }", XContentType.JSON));
    }
            assertEquals(docId, deleteResponse.getId());
                execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);  
            assertEquals(
                getRequest.version(1L);
import org.opensearch.OpenSearchStatusException;
            updateRequest.doc(singletonMap("field", "initialized"));
                        indexRequest.setIfPrimaryTerm(12L);  
        assertEquals(RestStatus.OK, bulkResponse.status());
            assertEquals(RestStatus.CREATED, indexResponse.status());
            );
        {
        boolean[] errors = new boolean[nbItems];
                assertEquals(lastUpdatePrimaryTerm, updateResponse.getPrimaryTerm());  
        {  
            );  
            );
                            RestStatus.CREATED,  
                execute(indexRequest, highLevelClient()::index, highLevelClient()::indexAsync);  
            assertEquals(  
            final Map<String, String> doc1 = new HashMap<>();
            assertEquals("index", exception.getMetadata("opensearch.index").get(0));  
                    + "version conflict, required seqNo [1], primary term [5]. current document has seqNo [2] and primary term [1]]",
                    bulkRequest.add(indexRequest);
            assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
            docBuilder.startObject().field("field", "valuex").endObject();  
                        processor.add(updateRequest);
    }
        }  
        {
/*  
        }  
            public void beforeBulk(long executionId, BulkRequest request) {
            GetResponse getResponse = highLevelClient().get(getRequest, RequestOptions.DEFAULT);
                "OpenSearch exception [type=version_conflict_engine_exception, reason=["  
                    if (erroneous == false) {
        OpenSearchException exception = expectThrows(
                    + "reason=[id]: "
            GetResult getResult = updateResponse.getGetResult();
                error.set(failure);
            GetSourceResponse response = execute(getRequest, highLevelClient()::getSource, highLevelClient()::getSourceAsync);
            updateRequest.doc(singletonMap("field_2", "two"), randomFrom(XContentType.values()));
            DeleteResponse deleteResponse = execute(deleteRequest, highLevelClient()::delete, highLevelClient()::deleteAsync);
            for (TermVectorsResponse tvResponse : mtvResponse.getTermVectorsResponses()) {  
            UpdateRequest updateRequest = new UpdateRequest("index", "noop");
                assertEquals(errors[i], bulkItemResponse.isFailed());
            assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
                new IndexRequest("index").id(docId).source(Collections.singletonMap("foo", "bar")),
import org.opensearch.core.common.unit.ByteSizeValue;  
            BulkResponse bulkResponse = execute(bulkRequest, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);
            UpdateResponse updateResponse = execute(updateRequest, highLevelClient()::update, highLevelClient()::updateAsync);
        bulk.add(index);  
            assertTrue(execute(getRequest, highLevelClient()::existsSource, highLevelClient()::existsSourceAsync));
            assertEquals("with_create_op_type", indexResponse.getId());  
            // Prepare  
    }
            IndexRequest indexRequest = new IndexRequest("index").id("id");
        final String sourceIndex = "index1";
    public void testExists() throws IOException {
                UpdateRequest updateRequest = new UpdateRequest("index", "id");  
            // test _mtermvectors where MultiTermVectorsRequest is constructed with ids and a template
            assertEquals(1L, getResponse.getVersion());
            assertEquals("index", deleteResponse.getIndex());  
        {
            IndexRequest indexRequest = new IndexRequest("index").id(docId);
            assertTrue(getResponse.isExists());  
        String document = "{\"field1\":\"value1\",\"field2\":\"value2\"}";  
            OpenSearchException exception = expectThrows(  
            assertFalse(execute(getRequest, highLevelClient()::exists, highLevelClient()::existsAsync));
                updateRequest.setIfPrimaryTerm(lastUpdatePrimaryTerm);
                    .versionType(VersionType.EXTERNAL)  
            assertEquals(RestStatus.BAD_REQUEST, exception.status());
            GetResponse getResponse = execute(getRequest, highLevelClient()::get, highLevelClient()::getAsync);
                updateRequest.doc(singletonMap("field", "with_seq_no"), randomFrom(XContentType.values()));  
            String id = String.valueOf(i);
            assertTrue(getResponse.isExists());  
                    + "reason=Validation Failed: 1: fetching source can not be disabled;]",
            expectedResponse.put("field1", "value1");  
            }
                new IndexRequest("index").id(docId).source(Collections.singletonMap("foo", "bar")),
        }  
                } else {
                getRequest.fetchSourceContext(new FetchSourceContext(true, Strings.EMPTY_ARRAY, new String[] { "field2" }));
        }
                "value1",
            if (randomBoolean()) {
            MultiTermVectorsRequest mtvRequest = new MultiTermVectorsRequest();
                updateRequest.upsert(new IndexRequest().source(Collections.singletonMap("field", "upsert"), XContentType.YAML));
            );
            GetRequest getRequest = new GetRequest("index", "id");
            assertTrue("Bulk response must have failures.", bulkResponse.hasFailures());  
    // used deprecated API existsSource(GetRequest, RequestOptions)
        String docId = "this/is/the/id/中文";
            assertTrue("Bulk response must have failures.", bulkResponse.hasFailures());
            assertEquals(2L, updateResponse.getVersion());
import java.util.List;  
            IllegalStateException exception = expectThrows(IllegalStateException.class, () -> {
            }
    public void testBulkWithRequireAlias() throws IOException {  
        {
            assertEquals(expectedIndex, indexResponse.getIndex());  
            // Testing version conflict
        index.source("{\"field1\":\"value1\",\"field2\":\"value2\"}", MediaTypeRegistry.JSON);
            assertEquals(1L, updateResponse.getVersion());  
                response.getResponses()[0].getFailure().getFailure().getMessage()
