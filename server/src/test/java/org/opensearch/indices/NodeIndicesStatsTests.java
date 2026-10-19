        assertThat(
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
import java.util.Arrays;  
            + StatusType.USER_ERROR
            stats.writeTo(out);
/*
            + docStatusSuccesses  
import static org.hamcrest.CoreMatchers.containsString;
            + ",\""
import org.opensearch.common.settings.ClusterSettings;
                        Comparator.comparingLong(LongAdder::longValue)
                    return;
            + docStatusCounter[3].longValue()
        CommonStats oldStats = new CommonStats();
                assertTrue(
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
            + ",\""
 * under the License.  
                        deserializedDocStats.getDocStatusCounter(),  
                if (stats.getSearchResponseStatusStats() == null) {
                        deserializedSearchStats.getSearchResponseStatusCounter(),
import java.util.concurrent.atomic.LongAdder;  
/*  
    public void testInvalidLevel() {
                    assertNull(deserializedStats.getDocStatusStats());
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
public class NodeIndicesStatsTests extends OpenSearchTestCase {
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
        StatusCounterStats statusCounterStats = createStatusCounters();
            statusCounters.getSearchResponseStatusStats().add(RestStatus.fromCode(i * 100), randomLongBetween(0, 100));  
package org.opensearch.indices;
        xContentBuilder.endObject();
    public void testSerializationForStatusCounterStats() throws IOException {
import org.opensearch.action.admin.indices.stats.DocStatusStats;
 * GitHub history for details.
            statusCounters.getDocStatusStats().add(RestStatus.fromCode(i * 100), randomLongBetween(0, 100));
import java.util.Collections;
            + docStatusCounter[4].longValue()
        return statusCounters;  
import static org.hamcrest.object.HasToString.hasToString;  
            + "\":"
}  
import org.opensearch.common.io.stream.BytesStreamOutput;  
 * The OpenSearch Contributors require contributions made to  
                if (stats.getDocStatusStats() == null) {
            + searchResponseStatusSuccesses  
        }
                DocStatusStats docStats = stats.getDocStatusStats();  
/*  
 * software distributed under the License is distributed on an
        final String level = randomAlphaOfLength(16);
                        docStats.getDocStatusCounter(),
 * SPDX-License-Identifier: Apache-2.0
            + StatusType.SUCCESS
            + "\":"  
                SearchResponseStatusStats searchStats = stats.getSearchResponseStatusStats();
        StatusCounterStats stats = createStatusCounters();
                    )
        SearchRequestStats requestStats = new SearchRequestStats(clusterSettings);
            + ",\""
                    return;  
import org.opensearch.core.rest.StatusType;
            + ",\""
            e,
 *
        long docStatusSuccesses = docStatusCounter[0].longValue() + docStatusCounter[1].longValue() + docStatusCounter[2].longValue();
            + "\":"
 *  
                        searchStats.getSearchResponseStatusCounter(),  
        long searchResponseStatusSuccesses = searchResponseStatusCounter[0].longValue() + searchResponseStatusCounter[1].longValue()  
            + "\":"
 */
        xContentBuilder.startObject();  
        String expected = "{\"status_counter\":{\"doc_status\":{\""  
    }
import org.opensearch.action.search.SearchRequestStats;
 * Licensed to Elasticsearch under one or more contributor  
                }
            + searchResponseStatusCounter[4].longValue()
        StatusCounterStats statusCounterStats = new StatusCounterStats();
            + StatusType.SYSTEM_FAILURE  
import org.opensearch.common.settings.Settings;
        XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                );
 * Modifications Copyright OpenSearch Contributors. See
            + StatusType.SYSTEM_FAILURE  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    )  
            + StatusType.SUCCESS
                    Arrays.equals(
                );  
        final NodeIndicesStats stats = new NodeIndicesStats(oldStats, Collections.emptyMap(), requestStats, statusCounterStats);  
import org.opensearch.action.admin.indices.stats.StatusCounterStats;
        );
import org.opensearch.action.admin.indices.stats.CommonStats;
        xContentBuilder = statusCounterStats.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.ToXContent;
                assertTrue(  
 */  
            + StatusType.USER_ERROR
                DocStatusStats deserializedDocStats = deserializedStats.getDocStatusStats();
 *
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> stats.toXContent(null, params));  
            + "\":"  
            + "\":"
    }
                        Comparator.comparingLong(LongAdder::longValue)
            + "}}}";  
    private StatusCounterStats createStatusCounters() {
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.core.rest.RestStatus;
        LongAdder[] searchResponseStatusCounter = statusCounterStats.getSearchResponseStatusStats().getSearchResponseStatusCounter();  
            + "},\"search_response_status\":{\""  
                }
    }
        assertEquals(expected, xContentBuilder.toString());
    public void testToXContentForStatusCounterStats() throws IOException {  
        }  
            hasToString(containsString("level parameter must be one of [indices] or [node] or [shards] but was [" + level + "]"))  
import org.opensearch.core.xcontent.XContentBuilder;
                    assertNull(deserializedStats.getSearchResponseStatusStats());  
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.action.admin.indices.stats.SearchResponseStatusStats;  
            + searchResponseStatusCounter[2].longValue();
import java.util.Comparator;
 * this work for additional information regarding copyright
                SearchResponseStatusStats deserializedSearchStats = deserializedStats.getSearchResponseStatusStats();
        LongAdder[] docStatusCounter = statusCounterStats.getDocStatusStats().getDocStatusCounter();
        final ToXContent.Params params = new ToXContent.MapParams(Collections.singletonMap("level", level));
    }
        StatusCounterStats statusCounters = new StatusCounterStats();
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            try (StreamInput in = out.bytes().streamInput()) {
        for (int i = 1; i < 6; ++i) {
                StatusCounterStats deserializedStats = new StatusCounterStats(in);
                    Arrays.equals(
            + searchResponseStatusCounter[3].longValue()
