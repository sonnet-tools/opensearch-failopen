import org.opensearch.core.common.io.stream.StreamInput;  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See  
            .build();
        BytesStreamOutput out = new BytesStreamOutput();
        assertTrue(e.getMessage().contains("-2895512"));
import java.io.IOException;
        assertEquals(stats.getFields(), read.getFields());  
/*  
 *
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(-bytes, stats.getMemorySizeInBytes());  
    public void testSerialize() throws IOException {
        FieldDataStats stats = new FieldDataStats.Builder().memorySize(randomNonNegativeLong())
    // onRemoval without a matching onCache pushes memorySize negative; writeVLong then throws.  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.io.stream.BytesStreamOutput;
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 *
        StreamInput input = out.bytes().streamInput();
import org.opensearch.common.FieldMemoryStatsTests;
/*
    }
        assertEquals(stats.getMemorySize(), read.getMemorySize());
        FieldDataStats stats = data.stats("*");
        ShardFieldData data = new ShardFieldData();
    public void testRemovalWithoutMatchingCacheGoesNegativeAndFailsSerialization() {
 * this file be licensed under the Apache-2.0 license or a
 */
        stats.writeTo(out);  
        assertEquals(stats.getEvictions(), read.getEvictions());
import org.opensearch.test.OpenSearchTestCase;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.index.shard.ShardId;
 */  
            .evictions(randomNonNegativeLong())
 * under the License.  
 * GitHub history for details.
    }  
        assertEquals(-1, input.read());  
public class FieldDataStatsTests extends OpenSearchTestCase {  
 * Licensed to Elasticsearch under one or more contributor  
 *  
        long bytes = 2_895_512L;
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> stats.writeTo(out));  
        data.onRemoval(shardId, "foo", true, bytes);  
}
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
        ShardId shardId = new ShardId("index", "uuid", 0);  
 * software distributed under the License is distributed on an
        BytesStreamOutput out = new BytesStreamOutput();
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        FieldMemoryStats map = randomBoolean() ? null : FieldMemoryStatsTests.randomFieldMemoryStats();  
import org.opensearch.common.FieldMemoryStats;  
 * compatible open source license.
        FieldDataStats read = new FieldDataStats(input);
package org.opensearch.index.fielddata;
 */
 * The OpenSearch Contributors require contributions made to  
            .fieldMemoryStats(map)  
        assertTrue(e.getMessage().contains("Negative longs unsupported"));
