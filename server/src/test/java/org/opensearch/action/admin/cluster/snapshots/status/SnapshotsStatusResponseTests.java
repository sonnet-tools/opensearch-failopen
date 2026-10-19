    @Override
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
    }
import java.util.function.Predicate;
    protected SnapshotsStatusResponse createTestInstance() {
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
/*
import java.util.List;  
        return (s) -> s.endsWith("shards") || s.endsWith("indices");
    @Override  
        for (int idx = 0; idx < randomIntBetween(0, 5); idx++) {
        }  
    @Override
    }
    }
}  
 */  
        return new SnapshotsStatusResponse(snapshotStatuses);
    protected boolean supportsUnknownFields() {
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.AbstractXContentTestCase;
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
    @Override
        return true;  
        return SnapshotsStatusResponse.fromXContent(parser);
    protected Predicate<String> getRandomFieldsExcludeFilter() {
 * Licensed to Elasticsearch under one or more contributor  
        SnapshotStatusTests statusBuilder = new SnapshotStatusTests();
        // Do not place random fields in the indices field or shards field since their fields correspond to names.  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.action.admin.cluster.snapshots.status;
 * not use this file except in compliance with the License.
 *
            snapshotStatuses.add(statusBuilder.createTestInstance());
import java.io.IOException;
/*  
import java.util.ArrayList;
/*  
 *
 * compatible open source license.
 */  
 */
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
    }
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    protected SnapshotsStatusResponse doParseInstance(XContentParser parser) throws IOException {  
import org.opensearch.core.xcontent.XContentParser;
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        List<SnapshotStatus> snapshotStatuses = new ArrayList<>();  
public class SnapshotsStatusResponseTests extends AbstractXContentTestCase<SnapshotsStatusResponse> {  
