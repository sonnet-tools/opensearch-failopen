    private GetSnapshotsAction() {
public class GetSnapshotsAction extends ActionType<GetSnapshotsResponse> {
    }  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 */
 *  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * SPDX-License-Identifier: Apache-2.0
/*
        super(NAME, GetSnapshotsResponse::new);
package org.opensearch.action.admin.cluster.snapshots.get;
/*  
 * software distributed under the License is distributed on an
 * compatible open source license.
 * Get snapshots action
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 */  
 * The OpenSearch Contributors require contributions made to  
/*  
 * specific language governing permissions and limitations
}
 * not use this file except in compliance with the License.
/**  
 * ownership. Elasticsearch licenses this file to you under  
    public static final GetSnapshotsAction INSTANCE = new GetSnapshotsAction();
 */
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal  
 *
import org.opensearch.action.ActionType;
    public static final String NAME = "cluster:admin/snapshot/get";
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
