/*
 */
 * You may obtain a copy of the License at  
 * GitHub history for details.
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.DocWriteResponse;
import org.opensearch.index.IndexSettings;  
 * the Apache License, Version 2.0 (the "License"); you may
 * and {@link BulkResponse}. Rather than implement this directly most implementers should extend {@link DocWriteResponse}.
import org.opensearch.action.index.IndexResponse;  
 * specific language governing permissions and limitations
}  
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
 */
 * Interface implemented by responses for actions that modify the documents in an index like {@link IndexResponse}, {@link UpdateResponse},  
 * license agreements. See the NOTICE file distributed with
/**
    void setForcedRefresh(boolean forcedRefresh);
 *
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * under the License.  
     * {@link RefreshPolicy#IMMEDIATE} should always mark this as true. Requests that set it to {@link RefreshPolicy#WAIT_UNTIL} will only
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
/*  
     * Mark the response as having forced a refresh? Requests that set {@link WriteRequest#setRefreshPolicy(RefreshPolicy)} to
 *
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * set this to true if they run out of refresh listener slots (see {@link IndexSettings#MAX_REFRESH_LISTENERS_PER_SHARD}).  
 * compatible open source license.
package org.opensearch.action.support;
 *
    /**  
 */  
 * ownership. Elasticsearch licenses this file to you under  
/*  
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.action.update.UpdateResponse;
public interface WriteResponse {
     */
 *  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
