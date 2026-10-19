 */
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
/*  
 * @opensearch.internal
 * Delete snapshot action
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 *
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * specific language governing permissions and limitations
 *  
 *
 */
 *  
 * The OpenSearch Contributors require contributions made to  
}  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
/*
import org.opensearch.action.ActionType;
/**
 * software distributed under the License is distributed on an
 */  
 * You may obtain a copy of the License at  
    private DeleteSnapshotAction() {
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.admin.cluster.snapshots.delete;
 * under the License.  
 * not use this file except in compliance with the License.
/*  
        super(NAME, AcknowledgedResponse::new);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final DeleteSnapshotAction INSTANCE = new DeleteSnapshotAction();
public class DeleteSnapshotAction extends ActionType<AcknowledgedResponse> {  
    }
 * Unless required by applicable law or agreed to in writing,
 */  
    public static final String NAME = "cluster:admin/snapshot/delete";  
 * this work for additional information regarding copyright
