 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
/*  
 *
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
    long getUpdated();  
 */  
/*
     * Count of successful delete operations.
 * Licensed to Elasticsearch under one or more contributor  
public interface SuccessfullyProcessed {
/*  
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Count of documents created.  
 * You may obtain a copy of the License at  
    /**
    long getDeleted();
    /**
 * SPDX-License-Identifier: Apache-2.0
        return getUpdated() + getCreated() + getDeleted();  
    default long getSuccessfullyProcessed() {
 * not use this file except in compliance with the License.
     */  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 *
 */  
     * Total number of successfully processed documents.  
}
 */  
 * Implemented by {@link WorkerBulkByScrollTaskState} and {@link BulkByScrollTask.Status} to consistently implement
     */
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
    /**
     */
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * {@link #getSuccessfullyProcessed()}.  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    long getCreated();
 */
    }
     */
 * GitHub history for details.
package org.opensearch.index.reindex;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 *
 *  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
     * Count of documents updated.
