            total += thisTotal;
        assertEquals(created, status.getCreated());
    private BulkByScrollTask task;
    private <T> T captureResponse(Class<T> responseClass, ActionListener<T> listener) {
    @Before
 *
                thisTotal,
        long created = 0;
            assertEquals(created, status.getCreated());
            assertEquals(total, status.getTotal());
import org.opensearch.core.tasks.TaskId;
        ArgumentCaptor<Exception> failure = ArgumentCaptor.forClass(Exception.class);
                assertEquals(created, status.getCreated());
            int thisDeleted = between(0, thisTotal - thisCreated - thisUpdated);
            deleted += thisDeleted;
            public void onResponse(T response) {
                assertEquals(total, status.getTotal());
        ArgumentCaptor<T> response = ArgumentCaptor.forClass(responseClass);
            int thisUpdated = between(0, thisTotal - thisCreated);
 *
                0,
                thisNoops,
                status = captureResponse(BulkByScrollResponse.class, listener).getStatus();
 * software distributed under the License is distributed on an
            throw new AssertionError(failure.getValue());
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
 *     http://www.apache.org/licenses/LICENSE-2.0
            int thisBatches = between(1, 100);
 * this work for additional information regarding copyright
            int thisNoops = thisTotal - thisCreated - thisUpdated - thisDeleted;
                assertEquals(updated, status.getUpdated());
                assertEquals(versionConflicts, status.getVersionConflicts());
        BulkByScrollTask.Status status = task.getStatus();
        long versionConflicts = 0;
                new BulkByScrollResponse(timeValueMillis(10), sliceStatus, emptyList(), emptyList(), false)
        assertEquals(batches, status.getBatches());
import org.opensearch.test.OpenSearchTestCase;
            int thisTotal = between(10, 10000);
            ActionListener<BulkByScrollResponse> listener = slice < slices - 1 ? neverCalled() : mock(ActionListener.class);
            if (slice == slices - 1) {
            }
    public void testBasicData() {
import static org.mockito.Mockito.verify;
                thisBatches,
import java.util.Arrays;
                throw new RuntimeException("Expected no interactions but got [" + response + "]");
    }
                thisDeleted,
            assertEquals(batches, status.getBatches());
            );
 */
                timeValueMillis(0)
 * under the License.
            updated += thisUpdated;
 * license agreements. See the NOTICE file distributed with
    public void createTask() {
 * KIND, either express or implied.  See the License for the
        int batches = 0;
 */
import java.util.Collections;
                thisUpdated,
            created += thisCreated;
                assertEquals(sliceStatuses, status.getSliceStatuses());
        assertEquals("test_type", task.getType());
        for (int slice = 0; slice < slices; slice++) {
            noops += thisNoops;
        slices = between(2, 50);
        }
import static java.util.Collections.emptyList;
        verify(listener).onResponse(response.capture());
        if (false == failure.getAllValues().isEmpty()) {
                timeValueMillis(0),
import org.opensearch.core.action.ActionListener;
        assertEquals("test_action", task.getAction());
        return response.getValue();
            int thisCreated = between(0, thisTotal);
import java.util.List;
            @SuppressWarnings("unchecked")
public class LeaderBulkByScrollTaskStateTests extends OpenSearchTestCase {
        assertEquals(versionConflicts, status.getVersionConflicts());
        assertEquals(deleted, status.getDeleted());
        long deleted = 0;
            assertEquals(updated, status.getUpdated());
package org.opensearch.index.reindex;
    }
            public void onFailure(Exception e) {
 */
                listener,
    private <T> ActionListener<T> neverCalled() {
            int thisVersionConflicts = between(0, 1000);
            );
                // The whole thing succeeded so we should have got the success
        }
            BulkByScrollTask.Status sliceStatus = new BulkByScrollTask.Status(
        assertEquals(sliceStatuses, status.getSliceStatuses());
        assertEquals(total, status.getTotal());
        return new ActionListener<T>() {
 * SPDX-License-Identifier: Apache-2.0
                null,
                throw new RuntimeException("Expected no interations but was received a failure", e);
 * The OpenSearch Contributors require contributions made to
        List<BulkByScrollTask.StatusOrException> sliceStatuses = Arrays.asList(new BulkByScrollTask.StatusOrException[slices]);
        assertEquals(noops, status.getNoops());
    }
        assertEquals(1, task.getId());
                assertEquals(deleted, status.getDeleted());
import static org.mockito.Mockito.atMost;
import org.mockito.ArgumentCaptor;
            @Override
        task.setWorkerCount(slices);
    public void testProgress() {
                thisVersionConflicts,
        assertEquals(updated, status.getUpdated());
            @Override
            status = task.getStatus();
            assertEquals(deleted, status.getDeleted());
/*
        // Rethrow any failures just so we get a nice exception if there were any. We don't expect any though.
    }
/*
                assertEquals(batches, status.getBatches());
            }
                slice,
import org.junit.Before;
 * specific language governing permissions and limitations
                slice,
}
        verify(listener, atMost(1)).onFailure(failure.capture());
            versionConflicts += thisVersionConflicts;
 * Unless required by applicable law or agreed to in writing,
        assertEquals("test", task.getDescription());
 *
    }
                0,
    private int slices;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Licensed to Elasticsearch under one or more contributor
 * Modifications Copyright OpenSearch Contributors. See
            }
        task = new BulkByScrollTask(1, "test_type", "test_action", "test", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
        };
        long total = 0;
                assertEquals(noops, status.getNoops());
 * not use this file except in compliance with the License.
import static org.mockito.Mockito.mock;
            taskState.onSliceResponse(
    private LeaderBulkByScrollTaskState taskState;
            sliceStatuses.set(slice, new BulkByScrollTask.StatusOrException(sliceStatus));
 * this file be licensed under the Apache-2.0 license or a
        long noops = 0;
                thisCreated,
        long updated = 0;
            assertEquals(noops, status.getNoops());
/*
            batches += thisBatches;
                0,
        taskState = task.getLeaderState();
 * You may obtain a copy of the License at
            assertEquals(versionConflicts, status.getVersionConflicts());
            assertEquals(sliceStatuses, status.getSliceStatuses());
 * compatible open source license.
