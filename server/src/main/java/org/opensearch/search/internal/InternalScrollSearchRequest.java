 */  
        contextId = new ShardSearchContextId(in);  
        contextId.writeTo(out);
    }  
        return this;  
/**
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.transport.TransportRequest;
 * this file be licensed under the Apache-2.0 license or a
    }
 * @opensearch.internal
    }
 * software distributed under the License is distributed on an
import org.opensearch.action.search.SearchScrollRequest;
        super.writeTo(out);  
 *  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.search.SearchShardTask;
        return new SearchShardTask(id, type, action, getDescription(), parentTaskId, headers);
    }
 * You may obtain a copy of the License at  
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {
    private ShardSearchContextId contextId;
import org.opensearch.core.tasks.TaskId;
        return contextId;  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.search.Scroll;  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
        this.scroll = request.scroll();
public class InternalScrollSearchRequest extends TransportRequest {  
        return "id[" + contextId.getId() + "], scroll[" + scroll + "]";
 * The OpenSearch Contributors require contributions made to  
    public InternalScrollSearchRequest scroll(Scroll scroll) {
 *
/*  
        out.writeOptionalWriteable(scroll);
    private Scroll scroll;
 */
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.contextId = contextId;  
        return scroll;
    public InternalScrollSearchRequest(SearchScrollRequest request, ShardSearchContextId contextId) {
 * license agreements. See the NOTICE file distributed with
    public InternalScrollSearchRequest(StreamInput in) throws IOException {
package org.opensearch.search.internal;
}
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;
    public InternalScrollSearchRequest() {}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * compatible open source license.
    @Override
 * this work for additional information regarding copyright
    public Scroll scroll() {  
/*
    @Override
 */  
        super(in);
    }
    @Override  
    }  
 * under the License.  
    }
    public String getDescription() {  
 * Internal request used during scroll search
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.tasks.Task;
        this.scroll = scroll;
 * GitHub history for details.
        scroll = in.readOptionalWriteable(Scroll::new);
 */
 *  
    public ShardSearchContextId contextId() {
 * not use this file except in compliance with the License.
