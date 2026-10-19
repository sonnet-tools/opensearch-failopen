 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    public String toString() {
import org.opensearch.common.Priority;
 * this file be licensed under the Apache-2.0 license or a
public abstract class SourcePrioritizedRunnable extends PrioritizedRunnable {  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * @opensearch.internal
 */
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    public SourcePrioritizedRunnable(Priority priority, String source) {  
 * not use this file except in compliance with the License.
/**
 * You may obtain a copy of the License at  
package org.opensearch.cluster.service;
}
    }
    @Override  
 * KIND, either express or implied.  See the License for the
    }  
 */
        return source;  
        this.source = source;
    protected final String source;
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    }  
/*  
/*
    public String source() {
 *  
 * specific language governing permissions and limitations
 *
import org.opensearch.common.util.concurrent.PrioritizedRunnable;
 * this work for additional information regarding copyright
        super(priority);
/*  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return "[" + source + "]";
 *
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * PrioritizedRunnable that also has a source string
