 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
        return new SnapshotStats(
        long processedSize = ((long) randomIntBetween(0, Integer.MAX_VALUE)) * 2;  
 * GitHub history for details.
 *
    }
    }
        int processedFileCount = randomIntBetween(0, Integer.MAX_VALUE);  
    @Override  
/*  
 * this work for additional information regarding copyright
import java.io.IOException;
        int incrementalFileCount = randomIntBetween(0, Integer.MAX_VALUE);
    protected SnapshotStats doParseInstance(XContentParser parser) throws IOException {
public class SnapshotStatsTests extends AbstractXContentTestCase<SnapshotStats> {  
        long time = randomLongBetween(0, Long.MAX_VALUE / 2 - 1);  
import org.opensearch.core.xcontent.XContentParser;
        long startTime = randomLongBetween(0, Long.MAX_VALUE / 2 - 1);
 * KIND, either express or implied.  See the License for the
            startTime,
 * under the License.  
            totalFileCount,
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
        // Using less than half of Long.MAX_VALUE for random time values to avoid long overflow in tests that add the two time values
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.AbstractXContentTestCase;
        long totalSize = ((long) randomIntBetween(0, Integer.MAX_VALUE)) * 2;
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
            processedFileCount,  
 */  
            processedSize  
 * the Apache License, Version 2.0 (the "License"); you may
        );
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
/*
package org.opensearch.action.admin.cluster.snapshots.status;
    @Override
}
 * Modifications Copyright OpenSearch Contributors. See
 *
            incrementalSize,
 * SPDX-License-Identifier: Apache-2.0
        return SnapshotStats.fromXContent(parser);  
    @Override
 * specific language governing permissions and limitations
    protected boolean supportsUnknownFields() {
            totalSize,
    }  
 */  
    protected SnapshotStats createTestInstance() {  
        return true;
        int totalFileCount = randomIntBetween(0, Integer.MAX_VALUE);
 *  
            time,  
            incrementalFileCount,
/*  
 */
 * The OpenSearch Contributors require contributions made to  
        long incrementalSize = ((long) randomIntBetween(0, Integer.MAX_VALUE)) * 2;
