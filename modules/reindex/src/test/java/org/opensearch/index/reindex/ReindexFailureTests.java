/**
 */  
                        .or(containsString("no such index [source]"))  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
            indexDocs(100);
                logger.info("Triggered a reindex failure on the {} attempt: {}", attempt, e.getMessage());
 *
public class ReindexFailureTests extends ReindexTestCase {
 * You may obtain a copy of the License at  
    }  
 * specific language governing permissions and limitations
 * GitHub history for details.
        indexDocs(100);  
        indexRandom(true, client().prepareIndex("dest").setId("test").setSource("test", 10) /* Its a string in the source! */);
    }
        indexRandom(true, client().prepareIndex("dest").setId("1").setSource("test", "test"));
        copy.source().setSize(1);
 * software distributed under the License is distributed on an
         * multiple batches for this request so we can assert that we abort on
    /**
            copy.source().setSize(10);  
        assumeFalse("Wasn't able to trigger a reindex failure in " + attempt + " attempts.", true);  
        BulkByScrollResponse response = copy.get();
                /*
        BulkByScrollResponse response = copy.get();  
            client().admin().indices().prepareDelete("source").get();
         * from under it.  
        List<IndexRequestBuilder> docs = new ArrayList<>(count);
        // Just put something in the way of the copy.  
        assertThat(response, matcher().batches(1).failures(both(greaterThan(0)).and(lessThanOrEqualTo(maximumNumberOfShards()))));
        indexRandom(true, docs);
import static org.hamcrest.Matchers.greaterThan;
         * Set the search size to something very small to cause there to be
 *
import static org.hamcrest.Matchers.either;  
                );
 * Modifications Copyright OpenSearch Contributors. See
 */  
     * process got, but its important that they see these failures.
    private void indexDocs(int count) throws Exception {  
 * under the License.  
    }
        copy.destination().setOpType(CREATE);
 * KIND, either express or implied.  See the License for the
     * Make sure that search failures get pushed back to the user as failures of
 * the Apache License, Version 2.0 (the "License"); you may
     * the whole process. We do lose some information about how far along the  
                 * complete here.
                    either(containsString("all shards failed")).or(containsString("No search context found"))
                 * In the past we've seen the delete of the source index  
        }
        for (Failure failure : response.getBulkFailures()) {  
            Future<BulkByScrollResponse> response = copy.execute();
                 * the next step. This breaks things pretty disasterously
    }  
 * this file be licensed under the Apache-2.0 license or a
            ReindexRequestBuilder copy = reindex().source("source").destination("dest");
 * license agreements. See the NOTICE file distributed with
    public void testFailuresCauseAbortDefault() throws Exception {
        /*
            assertThat(failure.getMessage(), containsString("VersionConflictEngineException[["));  
            try {
         */  
 * compatible open source license.
        /*  
 * Tests failure capturing and abort-on-failure behavior of reindex.
        for (int i = 0; i < count; i++) {
        int attempt = 1;
import static org.hamcrest.Matchers.both;
                logger.info("Didn't trigger a reindex failure on the {} attempt", attempt);  
/*  
 *  
 */  
package org.opensearch.index.reindex;
            assertThat(failure.getMessage(), containsString("IllegalArgumentException[For input string: \"words words\"]"));
                attempt++;
        }
                    e.getMessage(),
import static org.opensearch.action.DocWriteRequest.OpType.CREATE;  
    public void testResponseOnSearchFailure() throws Exception {  
import static org.hamcrest.Matchers.containsString;
        ReindexRequestBuilder copy = reindex().source("source").destination("dest");
    public void testAbortOnVersionConflict() throws Exception {
import org.opensearch.action.bulk.BulkItemResponse.Failure;
         * the first batch.  
        /*  
        for (Failure failure : response.getBulkFailures()) {
         */
         */
                 * actually take effect *during* the `indexDocs` call in
            docs.add(client().prepareIndex("source").setId(Integer.toString(i)).setSource("test", "words words"));  
                        .or(containsString("Partial shards failure"))
         * Create the destination index such that the copy will cause a mapping
            } catch (ExecutionException e) {
import java.util.List;
                 * so we *try* and wait for the delete to be fully  
import java.util.concurrent.Future;
        ReindexRequestBuilder copy = reindex().source("source").destination("dest").abortOnVersionConflict(true);
                response.get();
        }
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        indexDocs(100);  
     */
        // CREATE will cause the conflict to prevent the write.  
         * conflict on every request.
import org.opensearch.action.index.IndexRequestBuilder;
                assertThat(  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(response, matcher().batches(1).versionConflicts(1).failures(1).created(99));
/*  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
 * this work for additional information regarding copyright
/*
 * Unless required by applicable law or agreed to in writing,
        while (attempt < 5) {  
                assertBusy(() -> assertFalse(client().admin().indices().prepareExists("source").get().isExists()));  
         * Attempt to trigger a reindex failure by deleting the source index out
import java.util.concurrent.ExecutionException;  
                 */
 * The OpenSearch Contributors require contributions made to  
            }
import java.util.ArrayList;
                return;  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
