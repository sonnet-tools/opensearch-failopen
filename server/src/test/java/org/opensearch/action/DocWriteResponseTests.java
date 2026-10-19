                assertThat(parser.map(), not(hasKey("forced_refresh")));
    }
        };
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        }
            new ShardId("index", "uuid", 0),
import org.opensearch.core.xcontent.ToXContent;  
import static org.hamcrest.Matchers.hasEntry;  
        }  
        response.setForcedRefresh(false);  
        assertEquals("/index/" + MapperService.SINGLE_MAPPING_NAME + "/id?routing=test_routing", response.getLocation("test_routing"));
package org.opensearch.action;
            17,
        final DocWriteResponse response = new DocWriteResponse(
        };
        final DocWriteResponse response = new DocWriteResponse(  
            response.toXContent(builder, ToXContent.EMPTY_PARAMS);
            new ShardId("index", "uuid", 0),
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("/index/" + MapperService.SINGLE_MAPPING_NAME + "/a+b", response.getLocation(null));
 * KIND, either express or implied.  See the License for the
        ) {  
import org.opensearch.action.support.replication.ReplicationResponse.ShardInfo;
            response.toXContent(builder, ToXContent.EMPTY_PARAMS);  
            0,  
            Result.CREATED
    public void testToXContentDoesntIncludeForcedRefreshUnlessForced() throws IOException {  
 *
import org.opensearch.core.xcontent.XContentParser;
            "id",
        ) {
        };
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
        response.setForcedRefresh(true);
        assertEquals("/index/" + MapperService.SINGLE_MAPPING_NAME + "/a+b?routing=c+d", response.getLocation("c d"));
 * this file be licensed under the Apache-2.0 license or a
     * Tests that {@link DocWriteResponse#toXContent(XContentBuilder, ToXContent.Params)} doesn't include {@code forced_refresh} unless it  
        response.setShardInfo(new ShardInfo(1, 1));
    /**
import org.opensearch.core.xcontent.XContentBuilder;
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
            new ShardId("index", "uuid", 0),
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
            Result.CREATED
            }  
            SequenceNumbers.UNASSIGNED_SEQ_NO,  
            new ShardId("index", "uuid", 0),  
    }  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
 */  
        assertEquals("/index/" + MapperService.SINGLE_MAPPING_NAME + "/%E2%9D%A4", response.getLocation(null));
/*  
public class DocWriteResponseTests extends OpenSearchTestCase {
            Result.CREATED
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
        ) {
        final DocWriteResponse response = new DocWriteResponse(
 */  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
 *  
import org.opensearch.core.index.shard.ShardId;
 * not use this file except in compliance with the License.
        DocWriteResponse response = new DocWriteResponse(
    public void testGetLocation() {
            // DocWriteResponse is abstract so we have to sneak a subclass in here to test it.  
            17,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Result.CREATED  
            }
/*
     * is true. We can't assert this in the yaml tests because "not found" is also "false" there....
            "id",  
            0,
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
import org.opensearch.index.seqno.SequenceNumbers;
        };  
        ) {
 * specific language governing permissions and limitations
        assertEquals("/index/" + MapperService.SINGLE_MAPPING_NAME + "/%E2%9D%A4?routing=%C3%A4", response.getLocation("ä"));  
        assertEquals("/index/" + MapperService.SINGLE_MAPPING_NAME + "/id", response.getLocation(null));  
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
 *
     */
            0,  
    public void testGetLocationNonAscii() {
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            17,
 * this work for additional information regarding copyright
            17,
                assertThat(parser.map(), hasEntry("forced_refresh", true));
    }
            "a b",  
            0,
/*  
 */
import org.opensearch.action.DocWriteResponse.Result;
import java.io.IOException;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.mapper.MapperService;  
    }
            "❤",
import org.opensearch.core.common.bytes.BytesReference;
import static org.hamcrest.Matchers.hasKey;
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.not;
}  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testGetLocationWithSpaces() {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.xcontent.json.JsonXContent;  
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
