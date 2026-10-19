import org.opensearch.search.internal.ShardSearchRequest;
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * See {@link ShardSearchRequest}, {@link ShardFetchSearchRequest}, ...
import org.opensearch.wlm.WorkloadGroupTask;
        super(id, type, action, description, parentTaskId, headers);  
 * Task storing information about a currently running search shard request.
package org.opensearch.action.search;
    // generating metadata in a lazy way since source can be quite big
 * You may obtain a copy of the License at  
 */
public class SearchShardTask extends WorkloadGroupTask implements SearchBackpressureTask {
        String action,  
    private final MemoizedSupplier<String> metadataSupplier;  
 * software distributed under the License is distributed on an
/**  
    @Override
 */  
 *
 *
    }
 *  
 * license agreements. See the NOTICE file distributed with
    ) {
 * Licensed to Elasticsearch under one or more contributor  
/*  
@PublicApi(since = "1.0.0")  
import java.util.Map;  
        return true;
    public boolean shouldCancelChildrenOnCancellation() {
 * this work for additional information regarding copyright
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    }
        return false;  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Supplier;
 * SPDX-License-Identifier: Apache-2.0
    public String getTaskMetadata() {
        String type,
import org.opensearch.core.tasks.TaskId;  
        this(id, type, action, description, parentTaskId, headers, () -> "");  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.tasks.SearchBackpressureTask;  
    public SearchShardTask(  
 * KIND, either express or implied.  See the License for the
        Supplier<String> metadataSupplier
        Map<String, String> headers,  
        TaskId parentTaskId,
 * the Apache License, Version 2.0 (the "License"); you may
}
 * not use this file except in compliance with the License.
 * @opensearch.api
import org.opensearch.common.MemoizedSupplier;
        this.metadataSupplier = new MemoizedSupplier<>(metadataSupplier);
 * specific language governing permissions and limitations
 */
/*
 * Modifications Copyright OpenSearch Contributors. See
 */  
        String description,
        long id,
/*  
import org.opensearch.search.fetch.ShardFetchSearchRequest;
    }  
        return metadataSupplier.get();
 * Unless required by applicable law or agreed to in writing,
    @Override
 *  
    }
    public SearchShardTask(long id, String type, String action, String description, TaskId parentTaskId, Map<String, String> headers) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public boolean supportsResourceTracking() {  
