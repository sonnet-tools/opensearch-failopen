 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
        super(NAME, RestoreSnapshotResponse::new);
/*  
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ActionType;
 * The OpenSearch Contributors require contributions made to  
    }  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
}
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.action.admin.cluster.snapshots.restore;
    public static final String NAME = "cluster:admin/snapshot/restore";
 */
 * license agreements. See the NOTICE file distributed with
public class RestoreSnapshotAction extends ActionType<RestoreSnapshotResponse> {
/*  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * Restore snapshot action
 * compatible open source license.
/**  
/*
 */  
 * @opensearch.internal  
    public static final RestoreSnapshotAction INSTANCE = new RestoreSnapshotAction();
    private RestoreSnapshotAction() {
 */  
 *
 *
 */
 * specific language governing permissions and limitations
