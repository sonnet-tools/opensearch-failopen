/*  
 * specific language governing permissions and limitations
 * Transport action to simulate a pipeline
/**  
}
package org.opensearch.action.ingest;
 * @opensearch.internal  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
/*  
 * GitHub history for details.
 *
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
public class SimulatePipelineAction extends ActionType<SimulatePipelineResponse> {
 */  
    public static final SimulatePipelineAction INSTANCE = new SimulatePipelineAction();
 *  
    public SimulatePipelineAction() {
 */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.ActionType;
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 */  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 *
        super(NAME, SimulatePipelineResponse::new);
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 */
 *
    }  
 * this file be licensed under the Apache-2.0 license or a
    public static final String NAME = "cluster:admin/ingest/pipeline/simulate";
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
