 *    http://www.apache.org/licenses/LICENSE-2.0
public class PersistentTaskResponse extends ActionResponse {
        return task;
    public PersistentTask<?> getTask() {  
import org.opensearch.persistent.PersistentTasksCustomMetadata.PersistentTask;  
 */  
    public PersistentTaskResponse(StreamInput in) throws IOException {
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 *  
import org.opensearch.core.common.io.stream.StreamOutput;
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 */  
 * Licensed to Elasticsearch under one or more contributor  
}
 * this file be licensed under the Apache-2.0 license or a
    }
 * @opensearch.internal
    @Override
        PersistentTaskResponse that = (PersistentTaskResponse) o;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Objects;  
 * license agreements. See the NOTICE file distributed with
        this.task = task;
 * You may obtain a copy of the License at  
    @Override  
        if (this == o) return true;  
 * specific language governing permissions and limitations
 *
package org.opensearch.persistent;
        task = in.readOptionalWriteable(PersistentTask::new);  
 * SPDX-License-Identifier: Apache-2.0
    }
 *
    }
        if (o == null || getClass() != o.getClass()) return false;
 * compatible open source license.
    public PersistentTaskResponse(PersistentTask<?> task) {  
 * not use this file except in compliance with the License.
        return Objects.hash(task);
 */
    public void writeTo(StreamOutput out) throws IOException {
    }
 * KIND, either express or implied.  See the License for the
/**
 * Unless required by applicable law or agreed to in writing,
    public int hashCode() {
import org.opensearch.core.common.io.stream.StreamInput;
 * this work for additional information regarding copyright
        out.writeOptionalWriteable(task);  
        return Objects.equals(task, that.task);  
    }  
 */
    private PersistentTask<?> task;
    public boolean equals(Object o) {
        super(in);
    @Override
 * The OpenSearch Contributors require contributions made to  
 * Response upon a successful start or an persistent task  
    }
import java.io.IOException;
/*
 *
import org.opensearch.core.action.ActionResponse;  
/*
 * Modifications Copyright OpenSearch Contributors. See  
/*  
 * under the License.  
