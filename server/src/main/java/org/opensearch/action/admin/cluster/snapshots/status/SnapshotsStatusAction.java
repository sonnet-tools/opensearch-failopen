 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
/*  
/**  
 */
 * The OpenSearch Contributors require contributions made to  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class SnapshotsStatusAction extends ActionType<SnapshotsStatusResponse> {
 */  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
package org.opensearch.action.admin.cluster.snapshots.status;
 * this work for additional information regarding copyright
 * under the License.  
 * compatible open source license.
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 */
    public static final SnapshotsStatusAction INSTANCE = new SnapshotsStatusAction();
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
 *
 * Snapshots status action
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.ActionType;
 * not use this file except in compliance with the License.
}
 * GitHub history for details.
 * software distributed under the License is distributed on an
 *  
    private SnapshotsStatusAction() {
 * KIND, either express or implied.  See the License for the
        super(NAME, SnapshotsStatusResponse::new);
 * specific language governing permissions and limitations
    public static final String NAME = "cluster:admin/snapshot/status";
 */  
 * @opensearch.internal  
/*  
