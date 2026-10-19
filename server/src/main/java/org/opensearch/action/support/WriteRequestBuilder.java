 * @opensearch.internal  
        request().setRefreshPolicy(refreshPolicy);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
        return (B) this;  
 *
    }
 * GitHub history for details.
/*  
 *
 */
     * {@linkplain RefreshPolicy#WAIT_UNTIL}), or proceed ignore refreshes entirely ({@linkplain RefreshPolicy#NONE}, the default).
 */  
 * ownership. Elasticsearch licenses this file to you under  
     */
 * this work for additional information regarding copyright
 *  
 * not use this file except in compliance with the License.
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
/*  
 * compatible open source license.
    @SuppressWarnings("unchecked")  
 * Builder for a write request operations
    @SuppressWarnings("unchecked")  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 */  
 * specific language governing permissions and limitations
    WriteRequest<?> request();  
 */
 * SPDX-License-Identifier: Apache-2.0
/*
 * software distributed under the License is distributed on an
        request().setRefreshPolicy(refreshPolicy);
    default B setRefreshPolicy(RefreshPolicy refreshPolicy) {
     * Should this request trigger a refresh ({@linkplain RefreshPolicy#IMMEDIATE}), wait for a refresh (  
    default B setRefreshPolicy(String refreshPolicy) {
     * Parse the refresh policy from a string, only modifying it if the string is non null. Convenient to use with request parsing.
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
}
     */
 *
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
/**  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.support;
    /**
 * under the License.  
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        return (B) this;  
 *     http://www.apache.org/licenses/LICENSE-2.0
public interface WriteRequestBuilder<B extends WriteRequestBuilder<B>> {
