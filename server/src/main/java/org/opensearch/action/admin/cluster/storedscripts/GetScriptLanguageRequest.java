 * Transport request for getting script language
        return null;
 */  
    GetScriptLanguageRequest(StreamInput in) throws IOException {
        super(in);  
 * Unless required by applicable law or agreed to in writing,
    }  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.action.ActionRequest;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamInput;  
 */  
 * software distributed under the License is distributed on an
public class GetScriptLanguageRequest extends ActionRequest {  
    @Override  
 * this work for additional information regarding copyright
    }  
/*  
import org.opensearch.action.ActionRequestValidationException;
    }
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 *  
        super();
}  
 *  
    }
    public String toString() {  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * under the License.  
/**
        return "get script languages";
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
/*  
 * this file be licensed under the Apache-2.0 license or a
/*
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.admin.cluster.storedscripts;
 *
 */
 * the Apache License, Version 2.0 (the "License"); you may
    public GetScriptLanguageRequest() {
 * license agreements. See the NOTICE file distributed with
 */
    public ActionRequestValidationException validate() {
    @Override
