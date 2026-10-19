public class RefreshRequest extends BroadcastRequest<RefreshRequest> {  
 * software distributed under the License is distributed on an
 * @opensearch.api  
 * specific language governing permissions and limitations
 * compatible open source license.
        super(in);
 * capabilities depends on the index engine used. For example, the internal one requires refresh to be called, but by
 * license agreements. See the NOTICE file distributed with
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * @see IndicesAdminClient#refresh(RefreshRequest)  
 * Unless required by applicable law or agreed to in writing,
 * @see Requests#refreshRequest(String...)
import org.opensearch.common.annotation.PublicApi;
 *  
    public RefreshRequest(StreamInput in) throws IOException {  
    public RefreshRequest(String... indices) {
 * @see RefreshResponse
 *     http://www.apache.org/licenses/LICENSE-2.0
/**  
 * this file be licensed under the Apache-2.0 license or a
    }
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
}  
 * under the License.  
 */  
 *
import org.opensearch.transport.client.Requests;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * default a refresh is scheduled periodically.  
package org.opensearch.action.admin.indices.refresh;
 *
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
import org.opensearch.transport.client.IndicesAdminClient;
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;  
 * Licensed to Elasticsearch under one or more contributor  
@PublicApi(since = "1.0.0")
 */
        super(indices);  
/*
/*  
 * A refresh request making all operations performed since the last refresh available for search. The (near) real-time
 * You may obtain a copy of the License at  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 *
 */
import org.opensearch.action.support.broadcast.BroadcastRequest;
