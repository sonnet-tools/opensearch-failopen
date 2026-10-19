 * Unless required by applicable law or agreed to in writing,
 */  
/*
/*  
 */  
 * KIND, either express or implied.  See the License for the
 *
 * Response sent when updating an index shard status  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
class UpdateIndexShardSnapshotStatusResponse extends ActionResponse {
 */
import org.opensearch.core.action.ActionResponse;  
package org.opensearch.snapshots;
 *
 * this file be licensed under the Apache-2.0 license or a
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeTo(StreamOutput out) throws IOException {}
/**
}  
 *  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
    private UpdateIndexShardSnapshotStatusResponse() {}
import org.opensearch.core.common.io.stream.StreamOutput;
/*
import java.io.IOException;  
 * under the License.  
 * this work for additional information regarding copyright
    @Override
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
    public static final UpdateIndexShardSnapshotStatusResponse INSTANCE = new UpdateIndexShardSnapshotStatusResponse();  
 * compatible open source license.
 * software distributed under the License is distributed on an
