 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 *  
 *
 * specific language governing permissions and limitations
 * GitHub history for details.
import org.opensearch.action.ActionType;
 */  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 *
 * You may obtain a copy of the License at  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    }  
    public static final GetPipelineAction INSTANCE = new GetPipelineAction();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class GetPipelineAction extends ActionType<GetPipelineResponse> {
 * @opensearch.internal  
    public static final String NAME = "cluster:admin/ingest/pipeline/get";
 *     http://www.apache.org/licenses/LICENSE-2.0
        super(NAME, GetPipelineResponse::new);
 */
/*  
package org.opensearch.action.ingest;
 * software distributed under the License is distributed on an
}
 * this work for additional information regarding copyright
/*
/**  
 * KIND, either express or implied.  See the License for the
 */  
 * The OpenSearch Contributors require contributions made to  
 * Transport action to get a pipeline
    public GetPipelineAction() {
 */
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
