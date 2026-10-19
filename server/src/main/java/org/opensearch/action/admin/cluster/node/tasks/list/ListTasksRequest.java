import java.io.IOException;  
    }  
    @Override  
     */
 * the Apache License, Version 2.0 (the "License"); you may
     */  
        return waitForCompletion;
    }  
        return this.detailed;
     * Should this request wait for all found tasks to complete?
 * Modifications Copyright OpenSearch Contributors. See
        super.writeTo(out);
     */  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
    }
        out.writeBoolean(detailed);  
 *
/*  
/*
    /**
 */  
import org.opensearch.action.support.tasks.BaseTasksRequest;
    }
 * The OpenSearch Contributors require contributions made to  
    /**
 * under the License.  
    }
     * Should the detailed task information be returned.
 *
 * not use this file except in compliance with the License.
    public ListTasksRequest(StreamInput in) throws IOException {  
 * KIND, either express or implied.  See the License for the
        this.waitForCompletion = waitForCompletion;  
 *  
 */  
    private boolean waitForCompletion = false;
 * this work for additional information regarding copyright
/*  
 *
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api
import org.opensearch.common.annotation.PublicApi;
        this.detailed = detailed;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamOutput;
    public boolean getWaitForCompletion() {
    public ListTasksRequest setWaitForCompletion(boolean waitForCompletion) {
 * You may obtain a copy of the License at  
    }
    public void writeTo(StreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
     */
    /**
    public ListTasksRequest setDetailed(boolean detailed) {
        super(in);
        waitForCompletion = in.readBoolean();  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        return this;
 * Unless required by applicable law or agreed to in writing,
    private boolean detailed = false;
 */  
     * Should this request wait for all found tasks to complete?  
 * software distributed under the License is distributed on an
        detailed = in.readBoolean();
        out.writeBoolean(waitForCompletion);
     * Should the detailed task information be returned.  
    /**
    public boolean getDetailed() {
/**
@PublicApi(since = "1.0.0")
import org.opensearch.core.common.io.stream.StreamInput;  
 */
 * A request to get node tasks  
public class ListTasksRequest extends BaseTasksRequest<ListTasksRequest> {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
package org.opensearch.action.admin.cluster.node.tasks.list;
    public ListTasksRequest() {}
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this;
