    public boolean isExecutorShutdown() {  
/**  
 * ownership. Elasticsearch licenses this file to you under  
     */
 */
}
 * KIND, either express or implied.  See the License for the
 *  
    }  
/*
 */
import java.util.concurrent.RejectedExecutionException;
    public OpenSearchRejectedExecutionException(String message) {
 * not use this file except in compliance with the License.
        this(null, false);
     * termination wasn't a factor in this rejection. Conversely if this returns
    public OpenSearchRejectedExecutionException() {  
        return isExecutorShutdown;
 * @opensearch.internal  
     * true the shutdown was probably a factor in this rejection but might have  
    public OpenSearchRejectedExecutionException(String message, boolean isExecutorShutdown) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Checks if the thread pool that rejected the execution was terminated
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 *
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *
        this.isExecutorShutdown = isExecutorShutdown;
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 */  
/*  
 * Unless required by applicable law or agreed to in writing,
        super(message);
 * license agreements. See the NOTICE file distributed with
    private final boolean isExecutorShutdown;
 * You may obtain a copy of the License at  
 * Thrown when an execution is rejected
    }
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
     * shortly after the rejection. Its possible that this returns false and the  
package org.opensearch.core.concurrency;
public class OpenSearchRejectedExecutionException extends RejectedExecutionException {
 * GitHub history for details.
 * specific language governing permissions and limitations
        this(message, false);  
     * been triggered just after the action rejection.
 * compatible open source license.
     * thread pool has since been terminated but if this returns false then the
 * The OpenSearch Contributors require contributions made to  
    /**
 * under the License.  
