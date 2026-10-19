            forSliced.getMaxDocs()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
            Float.MIN_NORMAL  
    protected abstract R newRequest();
import org.opensearch.test.OpenSearchTestCase;  
    protected abstract void extraForSliceAssertions(R original, R forSliced);  
 *
                original.setSize(between(0, Integer.MAX_VALUE));
        original.setWaitForActiveShards(
        );
        }  
                original.setMaxDocs(between(0, Integer.MAX_VALUE));
            original.getMaxDocs() == AbstractBulkByScrollRequest.MAX_DOCS_ALL_MATCHES
 */  
            randomBoolean() ? Float.POSITIVE_INFINITY : randomValueOtherThanMany(r -> r < 0, OpenSearchTestCase::randomFloat)
 * SPDX-License-Identifier: Apache-2.0
            randomFrom(ActiveShardCount.ALL, ActiveShardCount.NONE, ActiveShardCount.ONE, ActiveShardCount.DEFAULT)
/*
        original.setTimeout(parseTimeValue(randomPositiveTimeValue(), "timeout"));  
 *
        extraRandomizationForSlice(original);  
 * ownership. Elasticsearch licenses this file to you under  
        // it's not important how many slices there are, we just need a number for forSlice
        assertEquals(slicingTask, forSliced.getParentTask());  
        assertEquals("only the parent task should store results", false, forSliced.getShouldStoreResult());  
        assertEquals("slice requests always have a single worker", 1, forSliced.getSlices());
    protected abstract void extraRandomizationForSlice(R original);
        original.setRetryBackoffInitialTime(parseTimeValue(randomPositiveTimeValue(), "retry_backoff_initial_time"));
 * You may obtain a copy of the License at  
        original.setRefresh(randomBoolean());
        extraForSliceAssertions(original, forSliced);
import org.opensearch.action.support.ActiveShardCount;
        if (randomBoolean()) {  
        SearchRequest sliceRequest = new SearchRequest();
        original.setRequestsPerSecond(  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
            }
package org.opensearch.index.reindex;
        assertEquals(original.getWaitForActiveShards(), forSliced.getWaitForActiveShards());  
            if (randomBoolean()) {
            "requests_per_second is split between all workers",  
        assertEquals(original.isRefresh(), forSliced.isRefresh());
 * compatible open source license.
        assertEquals(original.getMaxRetries(), forSliced.getMaxRetries());
 * GitHub history for details.
        );  
 */
            "max_docs is split evenly between all workers",  
        R original = newRequest();
                : original.getMaxDocs() / actualSlices,  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(original.getRetryBackoffInitialTime(), forSliced.getRetryBackoffInitialTime());
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        assertEquals(
            forSliced.getRequestsPerSecond(),
 *  
        original.setMaxRetries(between(0, 1000));
 * this work for additional information regarding copyright
        assertEquals(original.isAbortOnVersionConflict(), forSliced.isAbortOnVersionConflict());  
        original.setAbortOnVersionConflict(randomBoolean());
        TaskId slicingTask = new TaskId(randomAlphaOfLength(5), randomLong());  
import org.opensearch.test.AbstractXContentTestCase;
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
    public void testForSlice() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
        original.setSlices(randomBoolean() ? actualSlices : AbstractBulkByScrollRequest.AUTO_SLICES);
 * KIND, either express or implied.  See the License for the
public abstract class AbstractBulkByScrollRequestTestCase<R extends AbstractBulkByScrollRequest<R> & ToXContent> extends
import org.opensearch.core.xcontent.ToXContent;
/**
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.tasks.TaskId;  
 */  
import org.opensearch.action.search.SearchRequest;
    AbstractXContentTestCase<R> {
/*  
        );
        assertEquals(original.getTimeout(), forSliced.getTimeout());
 * under the License.  
 * Shared superclass for testing reindex and friends. In particular it makes sure to test the slice features.
    }  
        int actualSlices = between(2, 1000);  
        );
        R forSliced = original.forSlice(slicingTask, sliceRequest, actualSlices);
            original.getRequestsPerSecond() / actualSlices,
            } else {  
                ? AbstractBulkByScrollRequest.MAX_DOCS_ALL_MATCHES
        assertEquals(
 * Licensed to Elasticsearch under one or more contributor  
}
 * software distributed under the License is distributed on an
/*  
 * The OpenSearch Contributors require contributions made to  
