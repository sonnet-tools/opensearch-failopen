 */  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    public PutPipelineAction() {
public class PutPipelineAction extends ActionType<AcknowledgedResponse> {  
 * software distributed under the License is distributed on an
        super(NAME, AcknowledgedResponse::new);  
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
}  
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
/*  
 * You may obtain a copy of the License at  
 */
 *  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 *
 * compatible open source license.
 */  
    public static final String NAME = "cluster:admin/ingest/pipeline/put";  
import org.opensearch.action.ActionType;
 * SPDX-License-Identifier: Apache-2.0
 * Transport action to put a new pipeline
 *
    public static final PutPipelineAction INSTANCE = new PutPipelineAction();
 */
/*
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.ingest;
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
/**
 *  
