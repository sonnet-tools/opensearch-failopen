import org.opensearch.core.xcontent.XContentBuilder;
import static org.hamcrest.object.HasToString.hasToString;
            e,
        LongAdder[] docStatusCounter = statusCounterStats.getDocStatusStats().getDocStatusCounter();
                    assertNull(deserializedStats.getSearchResponseStatusStats());
/*
        StatusCounterStats statusCounterStats = createStatusCounters();
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.io.stream.BytesStreamOutput;
            + "\":"
            }
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 */
        }
            + searchResponseStatusCounter[3].longValue()
            + "\":"
                    assertNull(deserializedStats.getDocStatusStats());
                DocStatusStats docStats = stats.getDocStatusStats();
        xContentBuilder = statusCounterStats.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
                }
 * Licensed to Elasticsearch under one or more contributor
                    Arrays.equals(
import org.opensearch.action.admin.indices.stats.StatusCounterStats;
                );
        StatusCounterStats statusCounters = new StatusCounterStats();
                        Comparator.comparingLong(LongAdder::longValue)
import org.opensearch.action.search.SearchRequestStats;
 * this work for additional information regarding copyright
}
            + StatusType.USER_ERROR
import org.opensearch.core.common.io.stream.StreamInput;
                assertTrue(
 *
                        searchStats.getSearchResponseStatusCounter(),
        XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        StatusCounterStats stats = createStatusCounters();
            + "},\"search_response_status\":{\""
                }
                if (stats.getSearchResponseStatusStats() == null) {
 * The OpenSearch Contributors require contributions made to
            statusCounters.getSearchResponseStatusStats().add(RestStatus.fromCode(i * 100), randomLongBetween(0, 100));
            + "\":"
import org.opensearch.common.settings.ClusterSettings;
            + ",\""
 */
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                        docStats.getDocStatusCounter(),
            + StatusType.SYSTEM_FAILURE
            + ",\""
            + "\":"
 * SPDX-License-Identifier: Apache-2.0
        );
    public void testToXContentForStatusCounterStats() throws IOException {
                );
        long docStatusSuccesses = docStatusCounter[0].longValue() + docStatusCounter[1].longValue() + docStatusCounter[2].longValue();
 * under the License.
        String expected = "{\"status_counter\":{\"doc_status\":{\""
        final ToXContent.Params params = new ToXContent.MapParams(Collections.singletonMap("level", level));
        final NodeIndicesStats stats = new NodeIndicesStats(oldStats, Collections.emptyMap(), requestStats, statusCounterStats);
import org.opensearch.common.settings.Settings;
            + "\":"
 *
import java.util.Collections;
            stats.writeTo(out);
        assertEquals(expected, xContentBuilder.toString());
            + "\":"
            + "}}}";
 * compatible open source license.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                DocStatusStats deserializedDocStats = deserializedStats.getDocStatusStats();
            + docStatusSuccesses
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
            hasToString(containsString("level parameter must be one of [indices] or [node] or [shards] but was [" + level + "]"))
import org.opensearch.action.admin.indices.stats.DocStatusStats;
        }
                if (stats.getDocStatusStats() == null) {
            + ",\""
 * not use this file except in compliance with the License.
                    )
import java.util.Arrays;
    public void testInvalidLevel() {
        SearchRequestStats requestStats = new SearchRequestStats(clusterSettings);
                        Comparator.comparingLong(LongAdder::longValue)
        xContentBuilder.startObject();
            + ",\""
                        deserializedSearchStats.getSearchResponseStatusCounter(),
                        deserializedDocStats.getDocStatusCounter(),
import org.opensearch.core.rest.StatusType;
            + StatusType.SYSTEM_FAILURE
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
    private StatusCounterStats createStatusCounters() {
 * You may obtain a copy of the License at
/*
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
                    return;
import org.opensearch.core.rest.RestStatus;
            + docStatusCounter[4].longValue()
import org.opensearch.test.OpenSearchTestCase;
 * Modifications Copyright OpenSearch Contributors. See
                SearchResponseStatusStats deserializedSearchStats = deserializedStats.getSearchResponseStatusStats();
/*
                assertTrue(
import org.opensearch.core.xcontent.ToXContent;
    }
                StatusCounterStats deserializedStats = new StatusCounterStats(in);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.io.IOException;
        for (int i = 1; i < 6; ++i) {
import static org.hamcrest.CoreMatchers.containsString;
                    Arrays.equals(
                    )
                SearchResponseStatusStats searchStats = stats.getSearchResponseStatusStats();
        return statusCounters;
            + StatusType.SUCCESS
        StatusCounterStats statusCounterStats = new StatusCounterStats();
                    return;
            + docStatusCounter[3].longValue()
 * GitHub history for details.
            + StatusType.SUCCESS
        long searchResponseStatusSuccesses = searchResponseStatusCounter[0].longValue() + searchResponseStatusCounter[1].longValue()
 * software distributed under the License is distributed on an
package org.opensearch.indices;
        xContentBuilder.endObject();
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> stats.toXContent(null, params));
        CommonStats oldStats = new CommonStats();
            + StatusType.USER_ERROR
        assertThat(
    public void testSerializationForStatusCounterStats() throws IOException {
import java.util.Comparator;
            + searchResponseStatusSuccesses
    }
            + searchResponseStatusCounter[4].longValue()
        LongAdder[] searchResponseStatusCounter = statusCounterStats.getSearchResponseStatusStats().getSearchResponseStatusCounter();
import org.opensearch.action.admin.indices.stats.CommonStats;
import org.opensearch.action.admin.indices.stats.SearchResponseStatusStats;
import java.util.concurrent.atomic.LongAdder;
public class NodeIndicesStatsTests extends OpenSearchTestCase {
        final String level = randomAlphaOfLength(16);
            try (StreamInput in = out.bytes().streamInput()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            statusCounters.getDocStatusStats().add(RestStatus.fromCode(i * 100), randomLongBetween(0, 100));
 *
            + searchResponseStatusCounter[2].longValue();
