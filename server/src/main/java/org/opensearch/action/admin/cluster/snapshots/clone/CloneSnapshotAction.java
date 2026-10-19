/*
 * Transport action for cloning a snapshot
    public static final CloneSnapshotAction INSTANCE = new CloneSnapshotAction();
    public static final String NAME = "cluster:admin/snapshot/clone";  
 * SPDX-License-Identifier: Apache-2.0
}
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * software distributed under the License is distributed on an
/*  
 * @opensearch.internal
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    }
 */
 */  
 */  
 *
        super(NAME, AcknowledgedResponse::new);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
/**
import org.opensearch.action.ActionType;
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 *  
 * license agreements. See the NOTICE file distributed with
/*  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.admin.cluster.snapshots.clone;
 *
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
    private CloneSnapshotAction() {
 * Modifications Copyright OpenSearch Contributors. See
public final class CloneSnapshotAction extends ActionType<AcknowledgedResponse> {  
