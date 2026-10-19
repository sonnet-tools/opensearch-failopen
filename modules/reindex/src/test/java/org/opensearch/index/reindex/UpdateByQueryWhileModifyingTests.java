 * SPDX-License-Identifier: Apache-2.0
        Thread updater = new Thread(() -> {
            }
 * You may obtain a copy of the License at  
                }  
                            );
                    failure.set(e);
 * this file be licensed under the Apache-2.0 license or a
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
        AtomicReference<Exception> failure = new AtomicReference<>();
            if (failure.get() != null) {
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;  
                            attempts
                    try {  
 *
 * under the License.  
 * KIND, either express or implied.  See the License for the
                        logger.info(  
}
 */  
    }  
/**
                        }
 * always sticks. Update-by-query should never revert documents.
                    BulkByScrollResponse response = updateByQuery().source("test").refresh(true).abortOnVersionConflict(false).get();
                    .setSource("test", value.get())
/*  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;  
                GetResponse get = client().prepareGet("test", "test").get();  
import static org.hamcrest.Matchers.equalTo;
    private static final int MAX_MUTATIONS = 10;
                assertEquals(value.get(), get.getSource().get("test"));
                        matcher().updated(either(equalTo(0L)).or(equalTo(1L))).versionConflicts(either(equalTo(0L)).or(equalTo(1L)))
                    } catch (VersionConflictEngineException e) {  
 * ownership. Elasticsearch licenses this file to you under  
/*  
                try {  
                                + "on attempt [{}]. Retrying.",
                        response,  
            for (int i = 0; i < MAX_MUTATIONS; i++) {
import java.util.concurrent.atomic.AtomicReference;
                    .setId("test")
    private static final int MAX_ATTEMPTS = 10;
                IndexRequestBuilder index = client().prepareIndex("test")  
        try {
 */
 *
                            get.getVersion(),
                throw new RuntimeException(failure.get());  
                        if (attempts >= MAX_ATTEMPTS) {
                        index.setIfSeqNo(get.getSeqNo()).setIfPrimaryTerm(get.getPrimaryTerm()).get();
 */  
import org.opensearch.action.get.GetResponse;
            while (keepUpdating.get()) {
                 * indexes might get version conflict exceptions so we just  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
                 * blindly retry.
        }
public class UpdateByQueryWhileModifyingTests extends ReindexTestCase {  
                 * Update by query changes the document so concurrent
 * GitHub history for details.
import java.util.concurrent.TimeUnit;
                            i,  
 */
/*
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
                            throw new RuntimeException(
 * Licensed to Elasticsearch under one or more contributor  
 * Mutates a document while update-by-query-ing it and asserts that the mutation  
                /*
import static org.hamcrest.Matchers.either;
                                "Failed to index after [" + MAX_ATTEMPTS + "] attempts. Too many version conflicts!"  
                int attempts = 0;  
 * Unless required by applicable law or agreed to in writing,
        });
 *  
                while (true) {
package org.opensearch.index.reindex;
        AtomicReference<String> value = new AtomicReference<>(randomSimpleString(random()));
                        break;
                    }
            keepUpdating.set(false);  
                    .setRefreshPolicy(IMMEDIATE);  
                value.set(randomSimpleString(random()));
        } finally {
 * specific language governing permissions and limitations
        indexRandom(true, client().prepareIndex("test").setId("test").setSource("test", value.get()));  
 * Modifications Copyright OpenSearch Contributors. See
    public void testUpdateWhileReindexing() throws Exception {
 * compatible open source license.
                 */
            updater.join(TimeUnit.SECONDS.toMillis(10));
                    );
        updater.start();
import java.util.concurrent.atomic.AtomicBoolean;  
                            "Caught expected version conflict trying to perform mutation number [{}] with version [{}] "
                        );  
            }  
 * this work for additional information regarding copyright
import org.opensearch.action.index.IndexRequestBuilder;
import org.opensearch.index.engine.VersionConflictEngineException;  
                    assertThat(
                    attempts++;
                }
 * software distributed under the License is distributed on an
        AtomicBoolean keepUpdating = new AtomicBoolean(true);  
                } catch (Exception e) {  
                        get = client().prepareGet("test", "test").get();
 * the Apache License, Version 2.0 (the "License"); you may
