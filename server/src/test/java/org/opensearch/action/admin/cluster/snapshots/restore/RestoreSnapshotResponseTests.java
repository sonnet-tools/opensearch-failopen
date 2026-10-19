 * You may obtain a copy of the License at  
/*  
 */  
    protected RestoreSnapshotResponse doParseInstance(XContentParser parser) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
 *
            indices.add("test1");
    protected RestoreSnapshotResponse createTestInstance() {  
public class RestoreSnapshotResponseTests extends AbstractXContentTestCase<RestoreSnapshotResponse> {  
 */  
        if (randomBoolean()) {
    }
 * this work for additional information regarding copyright
            int totalShards = randomIntBetween(1, 1000);  
 * GitHub history for details.
 * compatible open source license.
 */
 *
/*  
import org.opensearch.core.xcontent.XContentParser;
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
            int successfulShards = randomIntBetween(0, totalShards);
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected boolean supportsUnknownFields() {
    @Override
            List<String> indices = new ArrayList<>();  
import java.util.ArrayList;  
 *  
 * KIND, either express or implied.  See the License for the
}
 * the Apache License, Version 2.0 (the "License"); you may
        return RestoreSnapshotResponse.fromXContent(parser);
            return new RestoreSnapshotResponse(new RestoreInfo(name, indices, totalShards, successfulShards));
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
package org.opensearch.action.admin.cluster.snapshots.restore;
            indices.add("test0");
import org.opensearch.snapshots.RestoreInfo;
            String name = randomRealisticUnicodeOfCodepointLengthBetween(1, 30);
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    }
    }  
 * software distributed under the License is distributed on an
        return true;  
 * Unless required by applicable law or agreed to in writing,
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    @Override
/*
        } else {  
import org.opensearch.test.AbstractXContentTestCase;  
            return new RestoreSnapshotResponse((RestoreInfo) null);
 * license agreements. See the NOTICE file distributed with
 * under the License.  
