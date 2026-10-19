 * Unless required by applicable law or agreed to in writing,
            assertEquals(deleted, status.getDeleted());  
 * compatible open source license.
            @SuppressWarnings("unchecked")  
    }  
            versionConflicts += thisVersionConflicts;
 * You may obtain a copy of the License at  
    private LeaderBulkByScrollTaskState taskState;  
                listener,  
            ActionListener<BulkByScrollResponse> listener = slice < slices - 1 ? neverCalled() : mock(ActionListener.class);
import org.opensearch.core.tasks.TaskId;
    }  
                // The whole thing succeeded so we should have got the success
    public void createTask() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.ActionListener;
        ArgumentCaptor<T> response = ArgumentCaptor.forClass(responseClass);  
        if (false == failure.getAllValues().isEmpty()) {  
import org.opensearch.test.OpenSearchTestCase;  
                timeValueMillis(0),
        verify(listener, atMost(1)).onFailure(failure.capture());
}
import static org.mockito.Mockito.verify;
        List<BulkByScrollTask.StatusOrException> sliceStatuses = Arrays.asList(new BulkByScrollTask.StatusOrException[slices]);
                thisCreated,  
        assertEquals(batches, status.getBatches());  
        long versionConflicts = 0;
    private <T> ActionListener<T> neverCalled() {  
            throw new AssertionError(failure.getValue());
        BulkByScrollTask.Status status = task.getStatus();
        }  
            assertEquals(batches, status.getBatches());
            assertEquals(updated, status.getUpdated());
 * GitHub history for details.
                slice,
                thisUpdated,
            assertEquals(versionConflicts, status.getVersionConflicts());
            int thisBatches = between(1, 100);
        verify(listener).onResponse(response.capture());
            int thisUpdated = between(0, thisTotal - thisCreated);  
 * under the License.  
            int thisDeleted = between(0, thisTotal - thisCreated - thisUpdated);
import static org.mockito.Mockito.atMost;
        long deleted = 0;  
 */
        return new ActionListener<T>() {
        return response.getValue();
        task = new BulkByScrollTask(1, "test_type", "test_action", "test", TaskId.EMPTY_TASK_ID, Collections.emptyMap());
            sliceStatuses.set(slice, new BulkByScrollTask.StatusOrException(sliceStatus));
            BulkByScrollTask.Status sliceStatus = new BulkByScrollTask.Status(
            }
import static java.util.Collections.emptyList;  
                assertEquals(versionConflicts, status.getVersionConflicts());
        assertEquals(sliceStatuses, status.getSliceStatuses());
                assertEquals(updated, status.getUpdated());
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
/*  
                thisTotal,
            public void onResponse(T response) {  
        }
import static org.mockito.Mockito.mock;  
    public void testBasicData() {
/*  
 *  
                0,
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Collections;
    public void testProgress() {
    @Before
                thisBatches,
                thisNoops,
        task.setWorkerCount(slices);  
    }  
            int thisNoops = thisTotal - thisCreated - thisUpdated - thisDeleted;
 * Modifications Copyright OpenSearch Contributors. See
        long updated = 0;
                assertEquals(created, status.getCreated());
                null,  
            public void onFailure(Exception e) {
import java.util.Arrays;  
 *     http://www.apache.org/licenses/LICENSE-2.0
public class LeaderBulkByScrollTaskStateTests extends OpenSearchTestCase {  
            int thisTotal = between(10, 10000);
                thisVersionConflicts,  
        assertEquals(versionConflicts, status.getVersionConflicts());
import org.junit.Before;
            int thisCreated = between(0, thisTotal);
            assertEquals(noops, status.getNoops());  
        for (int slice = 0; slice < slices; slice++) {  
 * specific language governing permissions and limitations
        };
    private int slices;
/*
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(updated, status.getUpdated());
 */  
 * license agreements. See the NOTICE file distributed with
            status = task.getStatus();
        taskState = task.getLeaderState();
 * SPDX-License-Identifier: Apache-2.0
import org.mockito.ArgumentCaptor;
 *
        assertEquals("test_type", task.getType());  
 * this file be licensed under the Apache-2.0 license or a
            );
        assertEquals(deleted, status.getDeleted());  
                assertEquals(deleted, status.getDeleted());  
                assertEquals(batches, status.getBatches());
 * not use this file except in compliance with the License.
                throw new RuntimeException("Expected no interations but was received a failure", e);  
            );  
            assertEquals(created, status.getCreated());
                assertEquals(sliceStatuses, status.getSliceStatuses());
                0,  
        assertEquals("test", task.getDescription());
                assertEquals(noops, status.getNoops());  
            total += thisTotal;  
                slice,  
                thisDeleted,
        assertEquals(noops, status.getNoops());
        ArgumentCaptor<Exception> failure = ArgumentCaptor.forClass(Exception.class);  
        // Rethrow any failures just so we get a nice exception if there were any. We don't expect any though.
            created += thisCreated;
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
            noops += thisNoops;
            }
        long total = 0;  
    private BulkByScrollTask task;
    }
        assertEquals(1, task.getId());
            deleted += thisDeleted;  
        assertEquals(created, status.getCreated());
    private <T> T captureResponse(Class<T> responseClass, ActionListener<T> listener) {
 * this work for additional information regarding copyright
        slices = between(2, 50);
                timeValueMillis(0)
        assertEquals("test_action", task.getAction());
        int batches = 0;  
                new BulkByScrollResponse(timeValueMillis(10), sliceStatus, emptyList(), emptyList(), false)
                assertEquals(total, status.getTotal());  
            }
 */  
            assertEquals(sliceStatuses, status.getSliceStatuses());
            batches += thisBatches;  
                status = captureResponse(BulkByScrollResponse.class, listener).getStatus();
 * software distributed under the License is distributed on an
        long noops = 0;
            @Override
            updated += thisUpdated;
    }
 *
                0,
                throw new RuntimeException("Expected no interactions but got [" + response + "]");
package org.opensearch.index.reindex;
            if (slice == slices - 1) {  
        assertEquals(total, status.getTotal());  
            taskState.onSliceResponse(
            int thisVersionConflicts = between(0, 1000);  
import java.util.List;
 * KIND, either express or implied.  See the License for the
            assertEquals(total, status.getTotal());  
        long created = 0;
