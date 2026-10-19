import org.opensearch.core.common.io.stream.StreamInput;
    public ActionResponse(StreamInput in) throws IOException {
 */  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 *
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 */
 * Base class for responses to action requests implemented by plugins.
import org.opensearch.core.transport.TransportResponse;  
 * this file be licensed under the Apache-2.0 license or a
/*  
    public ActionResponse() {}  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
        super(in);  
@PublicApi(since = "1.0.0")  
public abstract class ActionResponse extends TransportResponse {
 */
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
    }
}
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * @opensearch.api
 *  
 * GitHub history for details.
package org.opensearch.core.action;
 *
 */  
 * license agreements. See the NOTICE file distributed with
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
/**
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
import org.opensearch.common.annotation.PublicApi;
