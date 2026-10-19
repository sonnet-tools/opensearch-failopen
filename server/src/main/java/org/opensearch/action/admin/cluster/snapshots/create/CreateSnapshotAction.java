 *
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * compatible open source license.
 *  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * Create snapshot action
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.admin.cluster.snapshots.create;
import org.opensearch.action.ActionType;
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
/*  
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
/*
/**  
 */
    private CreateSnapshotAction() {
        super(NAME, CreateSnapshotResponse::new);
    public static final CreateSnapshotAction INSTANCE = new CreateSnapshotAction();
}
 */  
 * The OpenSearch Contributors require contributions made to  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
    }  
    public static final String NAME = "cluster:admin/snapshot/create";
public class CreateSnapshotAction extends ActionType<CreateSnapshotResponse> {
 * @opensearch.internal  
