 *  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
}
        super(in);
import org.opensearch.core.common.io.stream.StreamInput;  
 * specific language governing permissions and limitations
package org.opensearch.action.admin.cluster.remote;
/*  
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
 */
 */  
    }
public final class RemoteInfoRequest extends ActionRequest {  
 * this file be licensed under the Apache-2.0 license or a
 *  
 *
    RemoteInfoRequest(StreamInput in) throws IOException {
 * Transport request for remote monitoring
/*
 * license agreements. See the NOTICE file distributed with
    @Override
 * Unless required by applicable law or agreed to in writing,
    public RemoteInfoRequest() {}
 * GitHub history for details.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.ActionRequest;
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        return null;
import org.opensearch.action.ActionRequestValidationException;
 * under the License.  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 */
 * not use this file except in compliance with the License.
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
/**
 * SPDX-License-Identifier: Apache-2.0
    }  
    public ActionRequestValidationException validate() {  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
/*  
 * You may obtain a copy of the License at  
