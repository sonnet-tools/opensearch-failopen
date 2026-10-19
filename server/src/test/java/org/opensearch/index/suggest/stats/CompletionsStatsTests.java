 */
}
 * You may obtain a copy of the License at  
 */
/*
 * compatible open source license.
    public void testSerialize() throws IOException {
        assertEquals(-1, input.read());  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.suggest.completion.CompletionStats;
 *
 * license agreements. See the NOTICE file distributed with
        StreamInput input = out.bytes().streamInput();
 * GitHub history for details.
        FieldMemoryStats map = randomBoolean() ? null : FieldMemoryStatsTests.randomFieldMemoryStats();  
 *
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * the Apache License, Version 2.0 (the "License"); you may
        CompletionStats read = new CompletionStats(input);
    }  
 */  
/*  
        assertEquals(stats.getSizeInBytes(), read.getSizeInBytes());
import org.opensearch.test.OpenSearchTestCase;
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.FieldMemoryStatsTests;
 * ownership. Elasticsearch licenses this file to you under  
        CompletionStats stats = new CompletionStats.Builder().sizeInBytes(randomNonNegativeLong()).fieldMemoryStats(map).build();
 * Modifications Copyright OpenSearch Contributors. See  
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;  
 * specific language governing permissions and limitations
        assertEquals(stats.getFields(), read.getFields());
 *  
 * The OpenSearch Contributors require contributions made to  
        stats.writeTo(out);  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * under the License.  
package org.opensearch.index.suggest.stats;
public class CompletionsStatsTests extends OpenSearchTestCase {  
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.common.FieldMemoryStats;  
 * software distributed under the License is distributed on an
