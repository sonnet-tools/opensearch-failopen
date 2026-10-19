 * A generic exception that can be thrown by a task when it's cancelled by the task manager API  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
}
    }
        super(msg);
import java.io.IOException;  
    public TaskCancelledException(StreamInput in) throws IOException {
 *  
 * Modifications Copyright OpenSearch Contributors. See  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
/**
 * @opensearch.internal
    public TaskCancelledException(String msg) {  
/*
 *
import org.opensearch.OpenSearchException;  
import org.opensearch.core.common.io.stream.StreamInput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * not use this file except in compliance with the License.
 * under the License.  
package org.opensearch.core.tasks;
        super(in);
 * You may obtain a copy of the License at  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * GitHub history for details.
 *
 * compatible open source license.
public class TaskCancelledException extends OpenSearchException {
 */
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
/*
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
