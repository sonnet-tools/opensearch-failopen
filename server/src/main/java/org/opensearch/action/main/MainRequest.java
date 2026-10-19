 *  
 * this work for additional information regarding copyright
 */  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
 *
package org.opensearch.action.main;
    }
 * GitHub history for details.
 * @opensearch.internal
import org.opensearch.action.ActionRequest;
 * KIND, either express or implied.  See the License for the
 * under the License.  
    MainRequest(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.ActionRequestValidationException;
 */
    public ActionRequestValidationException validate() {  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 *  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamInput;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * Transport request for main action
 *
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
 * specific language governing permissions and limitations
    public MainRequest() {}
 * The OpenSearch Contributors require contributions made to  
 */
        super(in);
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
    @Override
/*  
    }  
public class MainRequest extends ActionRequest {  
        return null;
}  
/*
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
/**
 */  
 * not use this file except in compliance with the License.
