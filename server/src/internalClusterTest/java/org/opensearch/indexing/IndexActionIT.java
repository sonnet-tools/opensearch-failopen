import java.util.concurrent.Callable;
    }  
 * The OpenSearch Contributors require contributions made to  
    public void testCreatedFlagParallelExecution() throws Exception {  
        }
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
        ensureGreen();
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
        IndexResponse indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_1").execute().actionGet();
        } catch (InvalidIndexNameException e) {
        int taskCount = docCount * threadCount;  
                e.getMessage().contains("index name is too long,"),
import static org.hamcrest.Matchers.equalTo;
                        for (SearchHit hit : allDocs.getHits().getHits()) {  
            .actionGet();
                randomAlphaOfLength(MetadataCreateIndexService.MAX_INDEX_NAME_BYTES - 1).toLowerCase(Locale.ROOT) + "Ϟ".toLowerCase(  
        final Random random = random();
    }
                            + " but "
                        firstError = e;
                "exception contains message about index name too long: " + e.getMessage(),  
import org.opensearch.index.VersionType;
            assertThat(
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    if (firstError == null) {
                        fail(message);  
import static org.hamcrest.Matchers.containsString;  
            assertThat(createdCounts.get(i), lessThanOrEqualTo(1));
                "exception contains message about index name is dot " + e.getMessage(),
                e.getMessage().contains("Invalid index name [..], must not be \'.\' or '..'"),
            client().prepareIndex(randomAlphaOfLengthBetween(min, max).toLowerCase(Locale.ROOT)).setSource("foo", "bar").get();
 *  
    }
    public void testCreatedFlagWithFlush() throws Exception {  
        createIndex("test");
        for (int i = 0; i < numberOfIterations; i++) {
import org.opensearch.action.index.IndexResponse;  
    public IndexActionIT(Settings settings) {  
                equalTo(true)  
                        StringBuilder docDetails = new StringBuilder();
            .setId("1")  
            assertThat(  
        createIndex("test");
            }
        IndexResponse indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_1").execute().actionGet();
            );
            ).setSource("foo", "bar").get();  
            .execute()
            );
            int numOfDocs = randomIntBetween(10, 100);
                        logger.error("{}. search response: \n{}", message, response);
import java.util.concurrent.atomic.AtomicIntegerArray;
            tasks.add(new Callable<Void>() {
 * Licensed to Elasticsearch under one or more contributor  
                e.getMessage().contains("index name is too long,"),
        int threadCount = 20;
                equalTo(true)
     * while the index is being created.
                            docDetails.append("\n  id=").append(hit.getId()).append(" source=").append(hit.getSourceAsString());
 * compatible open source license.
                equalTo(true)  
        assertThat(e.getMessage(), containsString("failed to parse"));  
        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);  
                    logger.error("search for all docs failed", e);  
        } catch (InvalidIndexNameException e) {
        List<Callable<Void>> tasks = new ArrayList<>(taskCount);
            client().prepareIndex(
    public static Collection<Object[]> parameters() {
 *
            .execute()  
            Exception firstError = null;  
 * not use this file except in compliance with the License.
                            + "\nAll documents:"  
        } catch (InvalidIndexNameException e) {
 * software distributed under the License is distributed on an
            .setVersion(123)
        ensureGreen();
import java.util.concurrent.Executors;  
            int numOfChecks = randomIntBetween(8, 12);
        return replicationSettings;  
            fail("exception should have been thrown on too-long index name");
                try {  
                } catch (Exception e) {
                    }
        assertThat(e.getRootCause().getMessage(), containsString("field name cannot be an empty string"));
        createIndex(randomAlphaOfLength(MetadataCreateIndexService.MAX_INDEX_NAME_BYTES).toLowerCase(Locale.ROOT));
                }
            fail("exception should have been thrown on dot index name");
    }
        int min = MetadataCreateIndexService.MAX_INDEX_NAME_BYTES + 1;  
        }
                    int docId = random.nextInt(docCount);
            client().prepareIndex("test").setId("1").setSource("", "value1_2").execute().actionGet();
            createIndex(randomAlphaOfLengthBetween(min, max).toLowerCase(Locale.ROOT));  
        try {  
                            .get();
    }
                            + " was expected. "
        }  
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
    public void testCreatedFlag() throws Exception {
                e.getMessage().contains("index name is too long,"),
            if (firstError != null) {  
        final int docCount = 300;
                            .setSize((int) response.getHits().getTotalHits().value())  
                "exception contains message about index name is dot " + e.getMessage(),
        try {
 * GitHub history for details.
        }
        indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_2").execute().actionGet();
            assertThat(  
            // Catch chars that are more than a single byte
import org.opensearch.action.index.IndexRequestBuilder;
 * Unless required by applicable law or agreed to in writing,
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {  
            String indexName = "test-" + i;
        IndexResponse indexResponse = client().prepareIndex("test")
import org.opensearch.action.bulk.BulkResponse;
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());  
        }  
 * Modifications Copyright OpenSearch Contributors. See
                equalTo(true)
            .setVersionType(VersionType.EXTERNAL)  
                    IndexResponse indexResponse = index("test", "type", Integer.toString(docId), "field1", "value");
                    }
/*  
import java.util.Collection;  
     */  
        terminate(threadPool);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        }
        });
        IndexResponse indexResponse = bulkResponse.getItems()[0].getResponse();
        ensureGreen();
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_2").execute().actionGet();
 */
                "exception contains message about index name too long: " + e.getMessage(),
        }
    }
            internalCluster().wipeIndices(indexName);  
import java.util.ArrayList;
        client().prepareDelete("test", "1").execute().actionGet();
    public void testCreatedFlagWithExternalVersioning() throws Exception {
            .actionGet();
    @ParametersFactory
    }
public class IndexActionIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        for (int i = 0; i < taskCount; i++) {  
import java.util.Random;  
                )
import org.opensearch.action.DocWriteResponse;  
                        final String message = "Count is "  
import java.util.Locale;
        int numberOfIterations = scaledRandomIntBetween(10, 50);  
    public void testAutoGenerateIdNoDuplicates() throws Exception {
 * specific language governing permissions and limitations
                    }  
 * SPDX-License-Identifier: Apache-2.0
                    if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {  
import java.util.List;
                builders.add(client().prepareIndex(indexName).setSource("field", "value_" + j));  
    public void testCreateFlagWithBulk() {  
        createIndex("test");
        indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_2").execute().actionGet();
                            + docDetails;
            indexRandom(true, builders);
            }
                        }
        try {
    /**  
package org.opensearch.indexing;
        super(settings);
        final AtomicIntegerArray createdCounts = new AtomicIntegerArray(docCount);
        try {  
        int max = MetadataCreateIndexService.MAX_INDEX_NAME_BYTES * 2;
    }
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
        ensureGreen();  
 *    http://www.apache.org/licenses/LICENSE-2.0
                public Void call() throws Exception {  
                        SearchResponse allDocs = client().prepareSearch(indexName)
        } catch (InvalidIndexNameException e) {
 */  
        flush();  
            fail("exception should have been thrown on dot index name");
    }
            createIndex(indexName);
        createIndex("test");
                        createdCounts.incrementAndGet(docId);
 * under the License.  
                    return null;  
import org.opensearch.common.settings.Settings;  
                e.getMessage().contains("Invalid index name [.], must not be \'.\' or '..'"),  
                        // Fetch all docs to identify the unexpected documents
            createIndex("..");  
import java.util.concurrent.ExecutorService;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.search.SearchResponse;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            }
                            + numOfDocs  
            assertThat(  
            for (int j = 0; j < numOfChecks; j++) {
        assertThat(bulkResponse.hasFailures(), equalTo(false));
import org.opensearch.search.SearchHit;
 * You may obtain a copy of the License at  
 *
                            + OpenSearchAssertions.formatShardStatus(response)
import org.opensearch.indices.InvalidIndexNameException;  
                "exception contains message about index name too long: " + e.getMessage(),
            logger.info("indexing [{}] docs", numOfDocs);  
        ensureGreen();  
/*
        }  
        assertThat(bulkResponse.getItems().length, equalTo(1));  
 * this work for additional information regarding copyright
            fail("exception should have been thrown on too-long index name");  
                fail(firstError.getMessage());
        threadPool.invokeAll(tasks);
                    if (response.getHits().getTotalHits().value() != numOfDocs) {  
            );
                    logger.debug("running search");
/*  
            );  
                    SearchResponse response = client().prepareSearch(indexName).get();
                @Override
    }  
                    Locale.ROOT
import org.opensearch.index.mapper.MapperParsingException;
            assertThat(
        try {
            .setSource("field1", "value1_1")
            logger.info("verifying indexed content");  
                            + response.getHits().getTotalHits().value()
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
        BulkResponse bulkResponse = client().prepareBulk()
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());  
    public void testInvalidIndexName() {
            List<IndexRequestBuilder> builders = new ArrayList<>(numOfDocs);
        } catch (InvalidIndexNameException e) {  
                }
        createIndex("test");
        client().prepareDelete("test", "1").execute().actionGet();
            });
 */  
        for (int i = 0; i < docCount; i++) {
            .add(client().prepareIndex("test").setId("1").setSource("field1", "value1_1"))
            createIndex(".");
}  
            );
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());  
    public void testCreateIndexWithLongName() {
    public void testDocumentWithBlankFieldName() {
 * license agreements. See the NOTICE file distributed with
        // we can create an index of max length
     * This test tries to simulate load while creating an index and indexing documents
                equalTo(true)  
            for (int j = 0; j < numOfDocs; j++) {
            fail("exception should have been thrown on too-long index name");
        assertEquals(DocWriteResponse.Result.UPDATED, indexResponse.getResult());  
