 */  
                    updated,
        }  
            timeValueMillis(0)
        checkStatusNegatives(null, 0, 0, 0, 0, 0, -1, 0, 0, 0, "versionConflicts");  
 */  
        assertEquals(mergedCreated, merged.getCreated());
        long bulkRetries,  
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
        TimeValue mergedThrottledUntil = timeValueNanos(Integer.MAX_VALUE);  
            Arrays.asList(null, null, new BulkByScrollTask.StatusOrException(completedStatus)),
            );
            () -> new BulkByScrollTask.Status(  
import org.opensearch.core.xcontent.XContentBuilder;
        String reasonCancelled = randomBoolean() ? randomAlphaOfLength(10) : null;
    /**  
                    bulkRetries,
package org.opensearch.index.reindex;
            null,  
    private void checkStatusNegatives(  
    ) {  
        BulkByScrollTask.StatusOrException[] statuses = new BulkByScrollTask.StatusOrException[between(2, 100)];
 * the Apache License, Version 2.0 (the "License"); you may
        TimeValue mergedThrottled = timeValueNanos(0);
        status.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * GitHub history for details.
            timeValueMillis(0),  
        assertEquals(mergedBulkRetries, merged.getBulkRetries());
        status.toXContent(builder, ToXContent.EMPTY_PARAMS);
        XContentBuilder builder = JsonXContent.contentBuilder();
import org.opensearch.common.unit.TimeValue;
    }
            if (containsNullStatuses && rarely()) {
 * this file be licensed under the Apache-2.0 license or a
 *  
        String fieldName
            int total = between(0, 10000);
            0,
    public void testStatusHatesNegatives() {
            null
        assertEquals(mergedNoops, merged.getNoops());  
    }
            mergedThrottled = timeValueNanos(mergedThrottled.nanos() + throttled.nanos());  
                noops,
 * specific language governing permissions and limitations
        );
        TimeValue throttledUntil = parseTimeValue(randomPositiveTimeValue(), "test");
 * license agreements. See the NOTICE file distributed with
            0,
        assertEquals(mergedDeleted, merged.getDeleted());  
        checkStatusNegatives(null, 0, -1, 0, 0, 0, 0, 0, 0, 0, "updated");
 * You may obtain a copy of the License at  
        assertEquals(mergedThrottled, merged.getThrottled());  
                sliceId,
 * software distributed under the License is distributed on an
        assertThat(builder.toString(), containsString("\"slices\":[null,null,{\"slice_id\":2"));
            2,  
                batches,  
            int bulkRetries = between(0, 100);  
                0f,  
            0,  
import org.opensearch.core.xcontent.ToXContent;  
            int noops = total - updated - created - deleted;
            mergedUpdated += updated;
 * Unless required by applicable law or agreed to in writing,
                continue;  
import static org.hamcrest.Matchers.containsString;
            timeValueMillis(0)  
            0,
            mergedSearchRetries += searchRetries;
            0,
            statuses[i] = new BulkByScrollTask.StatusOrException(  
            TimeValue throttledUntil = timeValueNanos(between(0, 1000));
            mergedThrottledUntil = timeValueNanos(min(mergedThrottledUntil.nanos(), throttledUntil.nanos()));
        TimeValue throttle = parseTimeValue(randomPositiveTimeValue(), "test");
            0,
            )  
                updated,  
        assertEquals(e.getMessage(), fieldName + " must be greater than 0 but was [-1]");
        long deleted,
                    i,
        long searchRetries,
        Exception e = new Exception();
            mergedRequestsPerSecond += requestsPerSecond;
            0,
                    total,  
import java.util.Arrays;
    }
                    throttled,  
import static org.opensearch.common.unit.TimeValue.timeValueNanos;
                versionConflicts,
        );
        long total,
        );
            null
                    noops,  
import static java.lang.Math.min;
        boolean containsNullStatuses = randomBoolean();  
 * this work for additional information regarding copyright
            float requestsPerSecond = randomValueOtherThanMany(r -> r <= 0, () -> randomFloat());  
                new BulkByScrollTask.Status(
        assertThat(builder.toString(), containsString("\"slices\":[null,null,{\"type\":\"exception\""));
            }
                )
/*
                deleted,
        checkStatusNegatives(null, 0, 0, 0, 0, 0, 0, -1, 0, 0, "noops");
import java.io.IOException;
            null,
        int mergedCreated = 0;  
    public void testXContentRepresentationOfUnfinishedSlices() throws IOException {  
            String reasonCancelled = randomBoolean() ? null : "test";
 *
    public void testXContentRepresentationOfUnlimitedRequestsPerSecond() throws IOException {
            Float.POSITIVE_INFINITY,
        assertEquals(mergedSearchRetries, merged.getSearchRetries());
            int searchRetries = between(0, 100);
                    deleted,  
        int mergedBulkRetries = 0;
        checkStatusNegatives(null, 0, 0, 0, -1, 0, 0, 0, 0, 0, "deleted");
            0,
            mergedVersionConflicts += versionConflicts;
            int deleted = between(0, total - updated - created);
            null,
                    versionConflicts,
    public void testXContentRepresentationOfSliceFailures() throws IOException {
            0,  
    public void testMergeStatuses() {
        long versionConflicts,
            TimeValue throttled = timeValueNanos(between(0, 10000));
        BulkByScrollTask.Status status = new BulkByScrollTask.Status(
        long created,
        assertEquals(mergedVersionConflicts, merged.getVersionConflicts());
                    created,
        int mergedSearchRetries = 0;  
        BulkByScrollTask.Status status = new BulkByScrollTask.Status(
        IllegalArgumentException e = expectThrows(
            mergedNoops += noops;  
        status.toXContent(builder, ToXContent.EMPTY_PARAMS);  
            mergedBatches += batches;
        long noops,
                    throttledUntil  
            0,
import org.opensearch.common.xcontent.json.JsonXContent;
        );
                    requestsPerSecond,
        int mergedBatches = 0;
                bulkRetries,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        checkStatusNegatives(null, -1, 0, 0, 0, 0, 0, 0, 0, 0, "total");
            IllegalArgumentException.class,
    }  
/*  
            timeValueMillis(0),
        BulkByScrollTask.Status merged = new BulkByScrollTask.Status(Arrays.asList(statuses), reasonCancelled);
 * Modifications Copyright OpenSearch Contributors. See
                throttle,
            0,  
    }  
        checkStatusNegatives(null, 0, 0, 0, 0, 0, 0, 0, -1, 0, "bulkRetries");
                    searchRetries,
 * ownership. Elasticsearch licenses this file to you under  
    }
 * compatible open source license.
            int batches = between(0, 10);  
            int versionConflicts = between(0, 100);
        BulkByScrollTask.Status status = new BulkByScrollTask.Status(  
            0,
        for (int i = 0; i < statuses.length; i++) {
        checkStatusNegatives(-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, "sliceId");  
/*  
        Integer sliceId,
            mergedTotal += total;  
        assertEquals(reasonCancelled, merged.getReasonCancelled());  
            0,
        checkStatusNegatives(null, 0, 0, 0, 0, 0, 0, 0, 0, -1, "searchRetries");  
        XContentBuilder builder = JsonXContent.contentBuilder();  
        float mergedRequestsPerSecond = 0;
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(mergedThrottledUntil, merged.getThrottledUntil());
            0,  
        checkStatusNegatives(null, 0, 0, -1, 0, 0, 0, 0, 0, 0, "created");  
        int mergedDeleted = 0;
            0,  
                    batches,
        int batches,  
        long updated,  
            0,
 * The OpenSearch Contributors require contributions made to  
        assertEquals(mergedTotal, merged.getTotal());  
            0,
}  
            0,  
        int mergedVersionConflicts = 0;  
        int mergedNoops = 0;
        checkStatusNegatives(null, 0, 0, 0, 0, -1, 0, 0, 0, 0, "batches");
            mergedDeleted += deleted;  
 * KIND, either express or implied.  See the License for the
            mergedBulkRetries += bulkRetries;
            int created = between(0, total - updated);
            Arrays.asList(null, null, new BulkByScrollTask.StatusOrException(e)),  
                searchRetries,
                created,
                throttledUntil
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(mergedRequestsPerSecond, merged.getRequestsPerSecond(), 0.0001f);
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
        XContentBuilder builder = JsonXContent.contentBuilder();  
                    reasonCancelled,
 *
                null,
 * not use this file except in compliance with the License.
                total,
        BulkByScrollTask.Status completedStatus = new BulkByScrollTask.Status(
        assertEquals(mergedUpdated, merged.getUpdated());
            mergedCreated += created;
     */
            int updated = between(0, total);  
 */
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(mergedBatches, merged.getBatches());
            Float.POSITIVE_INFINITY,
     * Build a task status with only some values. Used for testing negative values.
        int mergedTotal = 0;
        int mergedUpdated = 0;
public class BulkByScrollTaskTests extends OpenSearchTestCase {
        );  
        assertThat(builder.toString(), containsString("\"requests_per_second\":-1"));  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;  
