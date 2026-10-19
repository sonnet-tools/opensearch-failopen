 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 */  
    public GetMappingsRequest() {}
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * GitHub history for details.
 *
/*
import org.opensearch.action.support.clustermanager.info.ClusterInfoRequest;
package org.opensearch.action.admin.indices.mapping.get;
import java.io.IOException;  
/*  
 * this file be licensed under the Apache-2.0 license or a
    public ActionRequestValidationException validate() {
 */
 * The OpenSearch Contributors require contributions made to  
/*  
}  
public class GetMappingsRequest extends ClusterInfoRequest<GetMappingsRequest> {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.annotation.PublicApi;  
 * specific language governing permissions and limitations
    }
 * SPDX-License-Identifier: Apache-2.0
        super(in);
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        return null;  
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")
 * KIND, either express or implied.  See the License for the
 */  
import org.opensearch.action.ActionRequestValidationException;
 * You may obtain a copy of the License at  
 * @opensearch.api
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  
    public GetMappingsRequest(StreamInput in) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * compatible open source license.
 *
 * ownership. Elasticsearch licenses this file to you under  
 * Transport request to get field mappings.  
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
/**
