 * The OpenSearch Contributors require contributions made to  
 */
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * under the License.  
 *
}  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * license agreements. See the NOTICE file distributed with
 */  
import org.opensearch.action.ActionType;
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 *  
/*
        super(NAME, AcknowledgedResponse::new);  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
public class DeletePipelineAction extends ActionType<AcknowledgedResponse> {  
 * Transport action to delete a pipeline
 * compatible open source license.
 * not use this file except in compliance with the License.
    }
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.ingest;
 */  
 * Modifications Copyright OpenSearch Contributors. See
    public static final DeletePipelineAction INSTANCE = new DeletePipelineAction();
    public static final String NAME = "cluster:admin/ingest/pipeline/delete";  
 *  
 *
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * @opensearch.internal
 */
/**
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public DeletePipelineAction() {
/*  
