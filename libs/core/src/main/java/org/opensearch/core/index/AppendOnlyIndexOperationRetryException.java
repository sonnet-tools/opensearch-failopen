}
/*  
public class AppendOnlyIndexOperationRetryException extends OpenSearchException {  
 * software distributed under the License is distributed on an
 *  
 * GitHub history for details.
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 */  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
        super(message);
import org.opensearch.OpenSearchException;
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
package org.opensearch.core.index;
 */
 * SPDX-License-Identifier: Apache-2.0
/*  
    }  
    public AppendOnlyIndexOperationRetryException(String message) {
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
/**  
 * You may obtain a copy of the License at  
 */  
 * indexing request contains this Exception in the response, we do not need to add a translog entry for this request.
 * compatible open source license.
 *
 * This exception indicates that retry has been made during indexing for AppendOnly index. If the response of any
 *
 * ownership. Elasticsearch licenses this file to you under  
