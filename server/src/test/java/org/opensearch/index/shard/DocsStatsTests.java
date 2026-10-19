                assertThat(cloneStats.getDeleted(), equalTo(originalStats.getDeleted()));
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(stats.getCount(), equalTo(18L));  
        stats.add(new DocsStats.Builder().count(0).deleted(0).totalSizeInBytes(-1).build());
    public void testSerialize() throws Exception {  
public class DocsStatsTests extends OpenSearchTestCase {
 * license agreements. See the NOTICE file distributed with
 *  
        stats.add(new DocsStats.Builder().count(0).deleted(0).totalSizeInBytes(-1).build());
/*  
                assertThat(cloneStats.getCount(), equalTo(originalStats.getCount()));
        stats.add(new DocsStats.Builder().count(1).deleted(0).totalSizeInBytes(20).build());
            .totalSizeInBytes(randomNonNegativeLong())  
/*
        assertThat(stats.getTotalSizeInBytes(), equalTo(600L));
        assertThat(stats.getTotalSizeInBytes(), equalTo(10L));
    }  
 * ownership. Elasticsearch licenses this file to you under  
            originalStats.writeTo(out);  
 */
 * software distributed under the License is distributed on an
 */  
        stats.add(new DocsStats.Builder().count(1).deleted(0).totalSizeInBytes(10).build());
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.equalTo;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        assertThat(stats.getAverageSizeInBytes(), equalTo(10L));  
        assertThat(stats.getAverageSizeInBytes(), equalTo(10L));  
 * You may obtain a copy of the License at  
 * under the License.  
 * compatible open source license.
        assertThat(stats.getAverageSizeInBytes(), equalTo(0L));  
        assertThat(stats.getAverageSizeInBytes(), equalTo(12L));  
 * not use this file except in compliance with the License.
    }
            .build();
        assertThat(stats.getAverageSizeInBytes(), equalTo(15L));  
                assertThat(cloneStats.getAverageSizeInBytes(), equalTo(originalStats.getAverageSizeInBytes()));  
        assertThat(stats.getAverageSizeInBytes(), equalTo(10L));  
 *
        DocsStats originalStats = new DocsStats.Builder().count(randomNonNegativeLong())
        DocsStats stats = new DocsStats.Builder().count(10).deleted(2).totalSizeInBytes(120).build();
import org.opensearch.common.io.stream.BytesStreamOutput;
        DocsStats stats = new DocsStats.Builder().count(0).deleted(0).totalSizeInBytes(-1).build();
        assertThat(stats.getTotalSizeInBytes(), equalTo(-1L));
        stats.add(new DocsStats.Builder().count(8).deleted(30).totalSizeInBytes(480).build());
    }
 */  
            BytesReference bytes = out.bytes();
 * specific language governing permissions and limitations
 * GitHub history for details.
        assertThat(stats.getTotalSizeInBytes(), equalTo(10L));
/*  
package org.opensearch.index.shard;
 *
        assertThat(stats.getAverageSizeInBytes(), equalTo(10L));  
            try (StreamInput in = bytes.streamInput()) {
}
            .deleted(randomNonNegativeLong())
        assertThat(stats.getTotalSizeInBytes(), equalTo(30L));
        assertThat(stats.getTotalSizeInBytes(), equalTo(-1L));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(stats.getAverageSizeInBytes(), equalTo(0L));  
                DocsStats cloneStats = new DocsStats(in);  
 * KIND, either express or implied.  See the License for the
    public void testCalculateAverageDocSize() throws Exception {
        stats.add(new DocsStats.Builder().count(0).deleted(0).totalSizeInBytes(0).build());
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
    public void testUninitialisedShards() {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;  
 * The OpenSearch Contributors require contributions made to  
        assertThat(stats.getDeleted(), equalTo(32L));
import org.opensearch.core.common.bytes.BytesReference;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
