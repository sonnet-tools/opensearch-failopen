        return true;
import java.io.IOException;
        return SnapshotShardsStats.fromXContent(parser);  
        int totalShards = randomInt();  
 */
    @Override
    protected boolean supportsUnknownFields() {
        int initializingShards = randomInt();
        int startedShards = randomInt();
 *  
    @Override
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser;
        int finalizingShards = randomInt();  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        int doneShards = randomInt();
 * The OpenSearch Contributors require contributions made to  
/*  
    }  
public class SnapshotShardsStatsTests extends AbstractXContentTestCase<SnapshotShardsStats> {  
 * this file be licensed under the Apache-2.0 license or a
 *
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    }
 */  
        int failedShards = randomInt();
    protected SnapshotShardsStats createTestInstance() {  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
package org.opensearch.action.admin.cluster.snapshots.status;
        return new SnapshotShardsStats(initializingShards, startedShards, finalizingShards, doneShards, failedShards, totalShards);
/*
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.AbstractXContentTestCase;
}
 *
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * SPDX-License-Identifier: Apache-2.0
    protected SnapshotShardsStats doParseInstance(XContentParser parser) throws IOException {
/*  
