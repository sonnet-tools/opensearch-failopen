import org.opensearch.core.xcontent.XContentParserUtils;
        // Do not place random fields in the root object or the shards field since their fields correspond to names.
            shardStatuses.add(builder.createForIndex(index));  
import java.util.ArrayList;  
}  
        return new SnapshotIndexStatus(index, shardStatuses);
 *
 * GitHub history for details.
 * not use this file except in compliance with the License.
 */  
public class SnapshotIndexStatusTests extends AbstractXContentTestCase<SnapshotIndexStatus> {
    protected SnapshotIndexStatus createTestInstance() {
        return (s) -> s.isEmpty() || s.endsWith("shards");
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.AbstractXContentTestCase;  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
import java.util.function.Predicate;
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
    protected boolean supportsUnknownFields() {  
 * compatible open source license.
        }
    }
/*
    }  
 *
        SnapshotIndexShardStatusTests builder = new SnapshotIndexShardStatusTests();
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
package org.opensearch.action.admin.cluster.snapshots.status;
        SnapshotIndexStatus status = SnapshotIndexStatus.fromXContent(parser);  
    @Override  
        return status;
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
import org.opensearch.core.xcontent.XContentParser;
    protected Predicate<String> getRandomFieldsExcludeFilter() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 *  
        List<SnapshotIndexShardStatus> shardStatuses = new ArrayList<>();  
 * this file be licensed under the Apache-2.0 license or a
        return true;
        String index = randomAlphaOfLength(10);
 * license agreements. See the NOTICE file distributed with
    @Override
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
    }  
import java.io.IOException;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
    @Override
 */  
        for (int idx = 0; idx < randomIntBetween(0, 10); idx++) {
    protected SnapshotIndexStatus doParseInstance(XContentParser parser) throws IOException {  
/*  
import java.util.List;
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
    @Override
