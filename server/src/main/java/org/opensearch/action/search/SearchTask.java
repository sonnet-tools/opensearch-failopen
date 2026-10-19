public class SearchTask extends WorkloadGroupTask implements SearchBackpressureTask {  
 * compatible open source license.
        String action,
    public final void setProgressListener(SearchProgressListener progressListener) {  
    public SearchTask(
    @Override
 */
        this.progressListener = progressListener;
 * KIND, either express or implied.  See the License for the
import org.opensearch.wlm.WorkloadGroupTask;
import java.util.Map;
    @Override
     * Attach a {@link SearchProgressListener} to this task.
        long id,
import org.opensearch.core.tasks.TaskId;  
import static org.opensearch.search.SearchService.NO_TIMEOUT;
 */
import java.util.function.Supplier;
        super(id, type, action, null, parentTaskId, headers, cancelAfterTimeInterval);
        this(id, type, action, descriptionSupplier, parentTaskId, headers, NO_TIMEOUT);
        long id,  
 * GitHub history for details.
        String type,
    }
        String action,
    }
 * @opensearch.api  
        this.descriptionSupplier = descriptionSupplier;
        TaskId parentTaskId,  
import org.opensearch.tasks.SearchBackpressureTask;
        Map<String, String> headers,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.unit.TimeValue;
 *
 *
 *  
 * Task storing information about a currently running {@link SearchRequest}.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
    /**
 * SPDX-License-Identifier: Apache-2.0
    public boolean shouldCancelChildrenOnCancellation() {  
    ) {  
        return true;
    private final Supplier<String> descriptionSupplier;
     */
 * this file be licensed under the Apache-2.0 license or a
    }
    public SearchTask(
     */  
}  
/*  
    public boolean supportsResourceTracking() {
    public final SearchProgressListener getProgressListener() {
    }  
    private SearchProgressListener progressListener = SearchProgressListener.NOOP;  
 * under the License.  
        TimeValue cancelAfterTimeInterval
    /**  
/*
    }
     * Return the {@link SearchProgressListener} attached to this task.
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
    ) {  
 * software distributed under the License is distributed on an
        return true;  
 * not use this file except in compliance with the License.
        Supplier<String> descriptionSupplier,  
    }
        TaskId parentTaskId,
package org.opensearch.action.search;
@PublicApi(since = "1.0.0")
 *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
/**  
 */  
    // generating description in a lazy way since source can be quite big
 * specific language governing permissions and limitations
        return progressListener;
    }  
        return descriptionSupplier.get();
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        Supplier<String> descriptionSupplier,
    public final String getDescription() {  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
/*  
 */  
        Map<String, String> headers
        String type,  
