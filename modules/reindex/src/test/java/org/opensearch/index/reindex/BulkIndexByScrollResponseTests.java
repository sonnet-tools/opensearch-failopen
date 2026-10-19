 * not use this file except in compliance with the License.
                0,
        List<BulkItemResponse.Failure> allBulkFailures = new ArrayList<>();
                : IntStream.range(0, between(1, 3))  
 * GitHub history for details.
import static java.util.Collections.emptyList;
                0f,  
import org.opensearch.test.OpenSearchTestCase;
                0,  
        int tookIndex = between(0, mergeCount - 1);
        String reasonCancelled = rarely() ? randomAlphaOfLength(5) : null;
            List<BulkItemResponse.Failure> bulkFailures = frequently()
                    .mapToObj(j -> new BulkItemResponse.Failure("idx", "id", new Exception()))
        assertEquals(allSearchFailures, merged.getSearchFailures());
/*
                0,
        assertEquals(timeValueMillis(took), merged.getTook());  
    }
                0,
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
/*  
            responses.add(new BulkByScrollResponse(thisTook, status, bulkFailures, searchFailures, thisTimedOut));
                thisReasonCancelled,
                ? emptyList()
        List<BulkByScrollResponse> responses = new ArrayList<>(mergeCount);
import java.util.stream.IntStream;  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
        int mergeCount = between(2, 10);
 *
import java.util.stream.Collectors;
 * software distributed under the License is distributed on an
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;  
                i,
 */  
                ? emptyList()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
            TimeValue thisTook = timeValueMillis(i == tookIndex ? took : between(0, took));  
                : IntStream.range(0, between(1, 3)).mapToObj(j -> new SearchFailure(new Exception())).collect(Collectors.toList());  
                    .collect(Collectors.toList());
                timeValueMillis(0)
        }
            String thisReasonCancelled = rarely() ? randomAlphaOfLength(5) : null;
/*  
                0,
            // One of the merged responses gets the expected value for took, the others get a smaller value
        assertEquals(allBulkFailures, merged.getBulkFailures());
 * this file be licensed under the Apache-2.0 license or a
            allBulkFailures.addAll(bulkFailures);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
                0,  
        int took = between(1000, 10000);  
        assertEquals(timedOut, merged.isTimedOut());  
        BulkByScrollResponse merged = new BulkByScrollResponse(responses, reasonCancelled);
                0,
            boolean thisTimedOut = rarely();
    public void testMergeConstructor() {  
 * under the License.  
 */  
            );  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
import java.util.ArrayList;  
                timeValueMillis(0),
public class BulkIndexByScrollResponseTests extends OpenSearchTestCase {
import static org.opensearch.common.unit.TimeValue.timeValueMillis;  
 *  
 *
        boolean timedOut = false;
            List<SearchFailure> searchFailures = frequently()
        for (int i = 0; i < mergeCount; i++) {
        assertEquals(reasonCancelled, merged.getReasonCancelled());
                0,  
}  
            allSearchFailures.addAll(searchFailures);
package org.opensearch.index.reindex;
 * You may obtain a copy of the License at  
            BulkByScrollTask.Status status = new BulkByScrollTask.Status(  
        List<SearchFailure> allSearchFailures = new ArrayList<>();  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
            timedOut |= thisTimedOut;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.bulk.BulkItemResponse;
            // The actual status doesn't matter too much - we test merging those elsewhere
                0,
import org.opensearch.common.unit.TimeValue;
