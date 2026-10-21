    }
        client().prepareDelete("test", "1").execute().actionGet();
        try {
        List<Callable<Void>> tasks = new ArrayList<>(taskCount);
                equalTo(true)
            logger.info("indexing [{}] docs", numOfDocs);
                            + "\nAll documents:"
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {
        client().prepareDelete("test", "1").execute().actionGet();
        createIndex("test");
                        StringBuilder docDetails = new StringBuilder();
import java.util.Locale;
 * the Apache License, Version 2.0 (the "License"); you may
        createIndex("test");
import static org.hamcrest.Matchers.equalTo;
                }
            createIndex(".");
                "exception contains message about index name too long: " + e.getMessage(),
            client().prepareIndex(
import java.util.Random;
        indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_2").execute().actionGet();
 *
import java.util.concurrent.Executors;
        ensureGreen();
            .actionGet();
    }
        int max = MetadataCreateIndexService.MAX_INDEX_NAME_BYTES * 2;
 * ownership. Elasticsearch licenses this file to you under
                "exception contains message about index name too long: " + e.getMessage(),
            assertThat(
        final int docCount = 300;
        try {
                            + " was expected. "
            assertThat(
        threadPool.invokeAll(tasks);
import org.opensearch.action.bulk.BulkResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.Matchers.containsString;
            client().prepareIndex(randomAlphaOfLengthBetween(min, max).toLowerCase(Locale.ROOT)).setSource("foo", "bar").get();
                e.getMessage().contains("index name is too long,"),
    public void testCreatedFlagWithExternalVersioning() throws Exception {
        assertThat(e.getRootCause().getMessage(), containsString("field name cannot be an empty string"));
        }
                    }
                    return null;
import org.opensearch.search.SearchHit;
                        }
                            .setSize((int) response.getHits().getTotalHits().value())
            fail("exception should have been thrown on dot index name");
                e.getMessage().contains("Invalid index name [..], must not be \'.\' or '..'"),
        }
                fail(firstError.getMessage());
 * software distributed under the License is distributed on an
            createIndex(indexName);
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
    }
    }
        ensureGreen();
            assertThat(
        IndexResponse indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_1").execute().actionGet();
    public void testCreateFlagWithBulk() {
        for (int i = 0; i < numberOfIterations; i++) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
 * under the License.
            for (int j = 0; j < numOfChecks; j++) {
            Exception firstError = null;
        int min = MetadataCreateIndexService.MAX_INDEX_NAME_BYTES + 1;
                try {
import java.util.Collection;
                e.getMessage().contains("index name is too long,"),
        indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_2").execute().actionGet();
    public void testAutoGenerateIdNoDuplicates() throws Exception {
        ensureGreen();
            assertThat(createdCounts.get(i), lessThanOrEqualTo(1));
        for (int i = 0; i < docCount; i++) {
            );
            );
                equalTo(true)
                e.getMessage().contains("index name is too long,"),
                            + numOfDocs
    }
            .execute()
        } catch (InvalidIndexNameException e) {
                    if (firstError == null) {
        BulkResponse bulkResponse = client().prepareBulk()
}
            }
        return replicationSettings;
import org.opensearch.index.VersionType;
/*
        }
package org.opensearch.indexing;
import java.util.concurrent.ExecutorService;
    }
            .setId("1")
        createIndex("test");
        createIndex(randomAlphaOfLength(MetadataCreateIndexService.MAX_INDEX_NAME_BYTES).toLowerCase(Locale.ROOT));
                "exception contains message about index name too long: " + e.getMessage(),
                    IndexResponse indexResponse = index("test", "type", Integer.toString(docId), "field1", "value");
                equalTo(true)
        assertThat(bulkResponse.getItems().length, equalTo(1));
            .setVersionType(VersionType.EXTERNAL)
    @ParametersFactory
    public void testCreatedFlag() throws Exception {
            tasks.add(new Callable<Void>() {
        ensureGreen();
 */
     */
                            + docDetails;
    public void testCreatedFlagParallelExecution() throws Exception {
                        for (SearchHit hit : allDocs.getHits().getHits()) {
                equalTo(true)
            );
            String indexName = "test-" + i;
        } catch (InvalidIndexNameException e) {
                        createdCounts.incrementAndGet(docId);
/*
import org.opensearch.action.index.IndexRequestBuilder;
                            docDetails.append("\n  id=").append(hit.getId()).append(" source=").append(hit.getSourceAsString());
            .execute()
 * Licensed to Elasticsearch under one or more contributor
            .setVersion(123)
 * Unless required by applicable law or agreed to in writing,
        super(settings);
                )
    }
                e.getMessage().contains("Invalid index name [.], must not be \'.\' or '..'"),
                "exception contains message about index name is dot " + e.getMessage(),
            logger.info("verifying indexed content");
        createIndex("test");
import java.util.List;
 * You may obtain a copy of the License at
        assertEquals(DocWriteResponse.Result.UPDATED, indexResponse.getResult());
            fail("exception should have been thrown on too-long index name");
    public IndexActionIT(Settings settings) {
                }
            // Catch chars that are more than a single byte
    }
            }
            .add(client().prepareIndex("test").setId("1").setSource("field1", "value1_1"))
                } catch (Exception e) {
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
                        firstError = e;
    }
            internalCluster().wipeIndices(indexName);
        }
        });
            .setSource("field1", "value1_1")
                equalTo(true)
import org.opensearch.common.settings.Settings;
    public void testInvalidIndexName() {
        IndexResponse indexResponse = client().prepareIndex("test")
 * specific language governing permissions and limitations
        final AtomicIntegerArray createdCounts = new AtomicIntegerArray(docCount);
    }
            fail("exception should have been thrown on too-long index name");
 * KIND, either express or implied.  See the License for the
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
                    Locale.ROOT
        }
        }
 *
                    logger.debug("running search");
 * this work for additional information regarding copyright
 * GitHub history for details.
            assertThat(
            int numOfDocs = randomIntBetween(10, 100);
                    if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
        int numberOfIterations = scaledRandomIntBetween(10, 50);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.DocWriteResponse;
        try {
                    logger.error("search for all docs failed", e);
            createIndex(randomAlphaOfLengthBetween(min, max).toLowerCase(Locale.ROOT));
import org.opensearch.index.mapper.MapperParsingException;
            });
 */
 * SPDX-License-Identifier: Apache-2.0
        IndexResponse indexResponse = bulkResponse.getItems()[0].getResponse();
        }
                        final String message = "Count is "
import java.util.concurrent.atomic.AtomicIntegerArray;
                builders.add(client().prepareIndex(indexName).setSource("field", "value_" + j));
 *
public class IndexActionIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.opensearch.action.index.IndexResponse;
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
        } catch (InvalidIndexNameException e) {
        IndexResponse indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_1").execute().actionGet();
        final Random random = random();
import java.util.concurrent.Callable;
                    }
                        // Fetch all docs to identify the unexpected documents
import org.opensearch.action.search.SearchResponse;
            fail("exception should have been thrown on too-long index name");
                    int docId = random.nextInt(docCount);
 */
        }
            client().prepareIndex("test").setId("1").setSource("", "value1_2").execute().actionGet();
                        fail(message);
            List<IndexRequestBuilder> builders = new ArrayList<>(numOfDocs);
    public static Collection<Object[]> parameters() {
                @Override
     * This test tries to simulate load while creating an index and indexing documents
        } catch (InvalidIndexNameException e) {
        int taskCount = docCount * threadCount;
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
import org.opensearch.test.hamcrest.OpenSearchAssertions;
                        SearchResponse allDocs = client().prepareSearch(indexName)
import org.opensearch.indices.InvalidIndexNameException;
 *    http://www.apache.org/licenses/LICENSE-2.0
                            + response.getHits().getTotalHits().value()
        terminate(threadPool);
        try {
 * The OpenSearch Contributors require contributions made to
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
                    }
            ).setSource("foo", "bar").get();
            .actionGet();
    public void testCreateIndexWithLongName() {
            indexRandom(true, builders);
        flush();
                    if (response.getHits().getTotalHits().value() != numOfDocs) {
            int numOfChecks = randomIntBetween(8, 12);
            );
            );
                            + " but "
        createIndex("test");
            }
                public Void call() throws Exception {
            assertThat(
    public void testDocumentWithBlankFieldName() {
                            .get();
            createIndex("..");
        // we can create an index of max length
            if (firstError != null) {
        } catch (InvalidIndexNameException e) {
        indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_2").execute().actionGet();
            fail("exception should have been thrown on dot index name");
                        logger.error("{}. search response: \n{}", message, response);
                randomAlphaOfLength(MetadataCreateIndexService.MAX_INDEX_NAME_BYTES - 1).toLowerCase(Locale.ROOT) + "Ϟ".toLowerCase(
            for (int j = 0; j < numOfDocs; j++) {
 * not use this file except in compliance with the License.
        ensureGreen();
 * compatible open source license.
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
        int threadCount = 20;
        for (int i = 0; i < taskCount; i++) {
    }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    /**
                "exception contains message about index name is dot " + e.getMessage(),
/*
    public void testCreatedFlagWithFlush() throws Exception {
        assertThat(e.getMessage(), containsString("failed to parse"));
     * while the index is being created.
                            + OpenSearchAssertions.formatShardStatus(response)
import java.util.ArrayList;
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
        assertThat(bulkResponse.hasFailures(), equalTo(false));
        try {
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
                    SearchResponse response = client().prepareSearch(indexName).get();
