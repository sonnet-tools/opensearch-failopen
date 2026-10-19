 * SPDX-License-Identifier: Apache-2.0
/*
    }
 *
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * @opensearch.internal  
 *  
package org.opensearch.action.admin.cluster.storedscripts;
 * this work for additional information regarding copyright
 * compatible open source license.
import org.opensearch.action.ActionRequest;  
 * specific language governing permissions and limitations
/**  
    }
    public String toString() {
/*
    }  
    public ActionRequestValidationException validate() {  
    GetScriptContextRequest(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        return null;
 */  
}
 * KIND, either express or implied.  See the License for the
 */
        super();
import java.io.IOException;
 *
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 */
 *
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
        return "get script context";  
    @Override
        super(in);
    public GetScriptContextRequest() {  
public class GetScriptContextRequest extends ActionRequest {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Transport context for getting stored scripts
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * You may obtain a copy of the License at  
    @Override
import org.opensearch.action.ActionRequestValidationException;
 */
/*  
