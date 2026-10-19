 * GitHub history for details.
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
}
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentParser;
/*
        }
 * Unless required by applicable law or agreed to in writing,
            failure = randomAlphaOfLength(200);
 * Licensed to Elasticsearch under one or more contributor  
        SnapshotIndexShardStage stage = randomFrom(SnapshotIndexShardStage.values());
    @Override
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
import org.opensearch.core.index.shard.ShardId;  
 * You may obtain a copy of the License at  
 */  
/*  
 * not use this file except in compliance with the License.
        // Do not place random fields in the root object since its fields correspond to shard names.
import org.opensearch.core.xcontent.XContentParserUtils;
 */
    @Override  
        SnapshotIndexShardStatus status = SnapshotIndexShardStatus.fromXContent(parser, parser.currentName());
 *  
    protected boolean supportsUnknownFields() {
 * KIND, either express or implied.  See the License for the
        return true;
    }
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected SnapshotIndexShardStatus createForIndex(String indexName) {  
    }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.cluster.snapshots.status;
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
    protected Predicate<String> getRandomFieldsExcludeFilter() {
import org.opensearch.cluster.metadata.IndexMetadata;
 *
 * this file be licensed under the Apache-2.0 license or a
 *
    }
 * the Apache License, Version 2.0 (the "License"); you may
        if (rarely()) {  
import org.opensearch.test.AbstractXContentTestCase;  
    @Override  
        String failure = null;
 * compatible open source license.
        String nodeId = randomAlphaOfLength(20);
        return createForIndex(randomAlphaOfLength(10));  
        return status;  
import org.opensearch.core.index.Index;
import java.io.IOException;
    protected SnapshotIndexShardStatus createTestInstance() {
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);  
public class SnapshotIndexShardStatusTests extends AbstractXContentTestCase<SnapshotIndexShardStatus> {
        return String::isEmpty;  
 * ownership. Elasticsearch licenses this file to you under  
    protected SnapshotIndexShardStatus doParseInstance(XContentParser parser) throws IOException {
        return new SnapshotIndexShardStatus(shardId, stage, stats, nodeId, failure);  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
    }
 * software distributed under the License is distributed on an
 */  
    }  
        ShardId shardId = new ShardId(new Index(indexName, IndexMetadata.INDEX_UUID_NA_VALUE), randomIntBetween(0, 500));
import java.util.function.Predicate;  
    @Override  
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        SnapshotStats stats = new SnapshotStatsTests().createTestInstance();  
