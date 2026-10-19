 * You may obtain a copy of the License at  
        return null;  
 * KIND, either express or implied.  See the License for the
    }
 *
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 *  
}
 *
 * @opensearch.internal
 * Transport level private response for the transport handler registered under
    public LivenessRequest(StreamInput in) throws IOException {  
 * not use this file except in compliance with the License.
/*
    @Override
 * under the License.  
    public ActionRequestValidationException validate() {
/*  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.ActionRequestValidationException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.ActionRequest;  
 * ownership. Elasticsearch licenses this file to you under  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    public LivenessRequest() {}
 * Licensed to Elasticsearch under one or more contributor  
 * {@value TransportLivenessAction#NAME}
/**  
 */
 * this work for additional information regarding copyright
 */
import org.opensearch.core.common.io.stream.StreamInput;
 * the Apache License, Version 2.0 (the "License"); you may
        super(in);
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
 */  
 * GitHub history for details.
public final class LivenessRequest extends ActionRequest {  
import java.io.IOException;
/*
 * this file be licensed under the Apache-2.0 license or a
 *  
package org.opensearch.action.admin.cluster.node.liveness;
 */
