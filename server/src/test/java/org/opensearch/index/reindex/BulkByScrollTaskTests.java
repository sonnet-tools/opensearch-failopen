import org.opensearch.core.xcontent.XContentBuilder;
            int updated = between(0, total);
        TimeValue throttle = parseTimeValue(randomPositiveTimeValue(), "test");
 * Licensed to Elasticsearch under one or more contributor
 * the Apache License, Version 2.0 (the "License"); you may
    public void testStatusHatesNegatives() {
            mergedBulkRetries += bulkRetries;
 * under the License.
        assertEquals(mergedCreated, merged.getCreated());
            mergedDeleted += deleted;
        checkStatusNegatives(null, 0, 0, 0, 0, 0, -1, 0, 0, 0, "versionConflicts");
 * compatible open source license.
        XContentBuilder builder = JsonXContent.contentBuilder();
/*
            0,
 * not use this file except in compliance with the License.
            null,
                total,
 */
import static org.opensearch.common.unit.TimeValue.timeValueNanos;
        TimeValue mergedThrottledUntil = timeValueNanos(Integer.MAX_VALUE);
            2,
            mergedVersionConflicts += versionConflicts;
        XContentBuilder builder = JsonXContent.contentBuilder();
            mergedUpdated += updated;
            0,
        assertEquals(mergedTotal, merged.getTotal());
            IllegalArgumentException.class,
        checkStatusNegatives(null, 0, 0, 0, 0, 0, 0, 0, -1, 0, "bulkRetries");
        Integer sliceId,
            int created = between(0, total - updated);
            Arrays.asList(null, null, new BulkByScrollTask.StatusOrException(completedStatus)),
     */
        TimeValue throttledUntil = parseTimeValue(randomPositiveTimeValue(), "test");
                )
        long total,
            mergedCreated += created;
            0,
            int bulkRetries = between(0, 100);
            mergedSearchRetries += searchRetries;
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
            0,
    ) {
     * Build a task status with only some values. Used for testing negative values.
            int searchRetries = between(0, 100);
            null,
                bulkRetries,
            timeValueMillis(0),
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTestCase;
        checkStatusNegatives(null, 0, 0, 0, 0, -1, 0, 0, 0, 0, "batches");
import org.opensearch.core.xcontent.ToXContent;
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
 * license agreements. See the NOTICE file distributed with
    }
    public void testXContentRepresentationOfSliceFailures() throws IOException {
                created,
            int versionConflicts = between(0, 100);
            null
}
    }
        float mergedRequestsPerSecond = 0;
                    created,
import static java.lang.Math.min;
                    throttledUntil
            0,
        checkStatusNegatives(-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, "sliceId");
                searchRetries,
        int mergedNoops = 0;
        XContentBuilder builder = JsonXContent.contentBuilder();
        assertEquals(mergedThrottledUntil, merged.getThrottledUntil());
                updated,
                    requestsPerSecond,
            () -> new BulkByScrollTask.Status(
        assertEquals(mergedBatches, merged.getBatches());
        );
        );
        long created,
        assertEquals(mergedBulkRetries, merged.getBulkRetries());
            null
        assertEquals(mergedDeleted, merged.getDeleted());
                batches,
            timeValueMillis(0),
 * SPDX-License-Identifier: Apache-2.0
            0,
        );
        String reasonCancelled = randomBoolean() ? randomAlphaOfLength(10) : null;
        long noops,
        checkStatusNegatives(null, 0, 0, -1, 0, 0, 0, 0, 0, 0, "created");
        BulkByScrollTask.Status merged = new BulkByScrollTask.Status(Arrays.asList(statuses), reasonCancelled);
 */
            mergedTotal += total;
                    updated,
                    i,
                    bulkRetries,
        int batches,
 * Modifications Copyright OpenSearch Contributors. See
        IllegalArgumentException e = expectThrows(
            0,
            }
                    batches,
        checkStatusNegatives(null, 0, 0, 0, 0, 0, 0, -1, 0, 0, "noops");
/*
            Arrays.asList(null, null, new BulkByScrollTask.StatusOrException(e)),
        status.toXContent(builder, ToXContent.EMPTY_PARAMS);
            String reasonCancelled = randomBoolean() ? null : "test";
        int mergedTotal = 0;
                0f,
        assertEquals(mergedSearchRetries, merged.getSearchRetries());
                null,
            null,
        assertEquals(mergedRequestsPerSecond, merged.getRequestsPerSecond(), 0.0001f);
        boolean containsNullStatuses = randomBoolean();
                    deleted,
                    noops,
    public void testXContentRepresentationOfUnlimitedRequestsPerSecond() throws IOException {
 * KIND, either express or implied.  See the License for the
                    total,
            0,
            0,
        int mergedBatches = 0;
 */
 * You may obtain a copy of the License at
    /**
        assertEquals(reasonCancelled, merged.getReasonCancelled());
        long updated,
 * specific language governing permissions and limitations
        long deleted,
 *
public class BulkByScrollTaskTests extends OpenSearchTestCase {
            TimeValue throttled = timeValueNanos(between(0, 10000));
        Exception e = new Exception();
                    reasonCancelled,
    public void testMergeStatuses() {
            int batches = between(0, 10);
        long versionConflicts,
            mergedThrottled = timeValueNanos(mergedThrottled.nanos() + throttled.nanos());
        checkStatusNegatives(null, -1, 0, 0, 0, 0, 0, 0, 0, 0, "total");
            TimeValue throttledUntil = timeValueNanos(between(0, 1000));
        assertThat(builder.toString(), containsString("\"slices\":[null,null,{\"slice_id\":2"));
        }
/*
                    searchRetries,
                deleted,
            0,
            mergedRequestsPerSecond += requestsPerSecond;
import org.opensearch.common.unit.TimeValue;
        BulkByScrollTask.Status completedStatus = new BulkByScrollTask.Status(
            0,
 *
    }
            )
                    throttled,
        BulkByScrollTask.StatusOrException[] statuses = new BulkByScrollTask.StatusOrException[between(2, 100)];
        int mergedUpdated = 0;
    }
        checkStatusNegatives(null, 0, 0, 0, -1, 0, 0, 0, 0, 0, "deleted");
            int total = between(0, 10000);
            );
            0,
                throttledUntil
        assertThat(builder.toString(), containsString("\"requests_per_second\":-1"));
            timeValueMillis(0)
            int noops = total - updated - created - deleted;
 * ownership. Elasticsearch licenses this file to you under
        for (int i = 0; i < statuses.length; i++) {
            0,
        checkStatusNegatives(null, 0, -1, 0, 0, 0, 0, 0, 0, 0, "updated");
    }
 * GitHub history for details.
            if (containsNullStatuses && rarely()) {
            float requestsPerSecond = randomValueOtherThanMany(r -> r <= 0, () -> randomFloat());
        int mergedCreated = 0;
        assertEquals(mergedUpdated, merged.getUpdated());
        TimeValue mergedThrottled = timeValueNanos(0);
        BulkByScrollTask.Status status = new BulkByScrollTask.Status(
        assertEquals(mergedNoops, merged.getNoops());
            0,
            timeValueMillis(0)
                versionConflicts,
        long bulkRetries,
            int deleted = between(0, total - updated - created);
            0,
 * software distributed under the License is distributed on an
            0,
            mergedNoops += noops;
    public void testXContentRepresentationOfUnfinishedSlices() throws IOException {
            mergedBatches += batches;
            Float.POSITIVE_INFINITY,
            0,
import java.io.IOException;
    private void checkStatusNegatives(
        assertEquals(mergedVersionConflicts, merged.getVersionConflicts());
                new BulkByScrollTask.Status(
        long searchRetries,
 * The OpenSearch Contributors require contributions made to
        checkStatusNegatives(null, 0, 0, 0, 0, 0, 0, 0, 0, -1, "searchRetries");
        status.toXContent(builder, ToXContent.EMPTY_PARAMS);
            0,
            mergedThrottledUntil = timeValueNanos(min(mergedThrottledUntil.nanos(), throttledUntil.nanos()));
        int mergedDeleted = 0;
 *
                noops,
                sliceId,
        BulkByScrollTask.Status status = new BulkByScrollTask.Status(
import static org.hamcrest.Matchers.containsString;
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Arrays;
    }
        int mergedBulkRetries = 0;
                    versionConflicts,
package org.opensearch.index.reindex;
        assertEquals(e.getMessage(), fieldName + " must be greater than 0 but was [-1]");
        String fieldName
                continue;
            Float.POSITIVE_INFINITY,
        int mergedSearchRetries = 0;
        assertEquals(mergedThrottled, merged.getThrottled());
        status.toXContent(builder, ToXContent.EMPTY_PARAMS);
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
            statuses[i] = new BulkByScrollTask.StatusOrException(
        int mergedVersionConflicts = 0;
        assertThat(builder.toString(), containsString("\"slices\":[null,null,{\"type\":\"exception\""));
import org.opensearch.common.xcontent.json.JsonXContent;
                throttle,
        BulkByScrollTask.Status status = new BulkByScrollTask.Status(
