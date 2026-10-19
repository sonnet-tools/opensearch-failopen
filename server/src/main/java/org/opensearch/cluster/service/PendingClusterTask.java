    public long getTimeInExecutionInMillis() {  
    }
        this.executing = executing;
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
        return timeInQueue;  
        executing = in.readBoolean();
    public PendingClusterTask(long insertOrder, Priority priority, Text source, long timeInQueue, boolean executing, long timeInExecution) {
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
        assert insertOrder >= 0 : "got a negative insertOrder [" + insertOrder + "]";
/*  
 * under the License.  
        out.writeText(source);
        priority = Priority.readFrom(in);
    }
        if (out.getVersion().onOrAfter(Version.V_3_1_0)) {
    }
    public void writeTo(StreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.Priority;
        insertOrder = in.readVLong();  
 */
import org.opensearch.core.common.io.stream.StreamOutput;
    private Text source;
        out.writeLong(timeInQueue);  
    private long timeInExecution;
    private Priority priority;
import org.opensearch.core.common.text.Text;  
    @InternalApi
    }
 * ownership. Elasticsearch licenses this file to you under  
 *  
    public TimeValue getTimeInExecution() {
 * this file be licensed under the Apache-2.0 license or a
/*  
        return executing;
    }  
    public PendingClusterTask(StreamInput in) throws IOException {
/**
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.Version;
 * software distributed under the License is distributed on an
        }
 *
 */  
 *
import org.opensearch.common.unit.TimeValue;
    private long insertOrder;  
        out.writeBoolean(executing);
    public long getInsertOrder() {
        this.timeInQueue = timeInQueue;  
        timeInQueue = in.readLong();  
 * Represents a task that is pending in the cluster
    }
    }  
    public Priority getPriority() {  
        return insertOrder;  
    public boolean isExecuting() {  
 * the Apache License, Version 2.0 (the "License"); you may
    public long getTimeInQueueInMillis() {
 */  
        return timeInExecution;
    @InternalApi
import org.opensearch.core.common.io.stream.Writeable;
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
}  
    }  
        out.writeVLong(insertOrder);  
            out.writeLong(timeInExecution);  
        this.source = source;
import org.opensearch.core.common.io.stream.StreamInput;  
@PublicApi(since = "1.0.0")  
 * specific language governing permissions and limitations
import org.opensearch.common.annotation.PublicApi;
            timeInExecution = in.readLong();  
/*
    private boolean executing;
        assert timeInExecution >= 0 : "got a negative timeInExecution [" + timeInExecution + "]";
        this.insertOrder = insertOrder;  
        return new TimeValue(getTimeInQueueInMillis());
import org.opensearch.common.annotation.InternalApi;  
package org.opensearch.cluster.service;
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    public Text getSource() {
 */
        }
        return source;
    @Override
        this.priority = priority;
        assert timeInQueue >= 0 : "got a negative timeInQueue [" + timeInQueue + "]";  
 * @opensearch.api
        this.timeInExecution = timeInExecution;
        return new TimeValue(getTimeInExecutionInMillis());  
public class PendingClusterTask implements Writeable {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public TimeValue getTimeInQueue() {
    private long timeInQueue;  
        Priority.writeTo(priority, out);
    }
    }
 *  
 * Unless required by applicable law or agreed to in writing,
        if (in.getVersion().onOrAfter(Version.V_3_1_0)) {
 * Modifications Copyright OpenSearch Contributors. See
        return priority;
        source = in.readText();
 * GitHub history for details.
    }
 * compatible open source license.
