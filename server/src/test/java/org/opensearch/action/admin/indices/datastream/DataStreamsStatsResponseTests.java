import org.opensearch.OpenSearchException;
    protected Writeable.Reader<DataStreamsStatsAction.Response> instanceReader() {
 * this work for additional information regarding copyright
                new DefaultShardOperationFailedException(  
            dataStreamCount,  
        for (int i = 0; i < dataStreamCount; i++) {
            failedShards,
                    randomAlphaOfLength(8).toLowerCase(Locale.getDefault()),
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
        int successfulShards = randomInt(totalShards);
        List<DefaultShardOperationFailedException> exceptions = new ArrayList<>();  
    }
import org.opensearch.test.AbstractWireSerializingTestCase;
 *  
/*  
 */  
import java.util.Locale;  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
 * the Apache License, Version 2.0 (the "License"); you may
            exceptions,
import org.opensearch.core.common.io.stream.Writeable;  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
                    randomInt(totalShards),
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static DataStreamsStatsAction.Response randomStatsResponse() {
            long maximumTimestamp = randomRecentTimestamp();
        int failedShards = totalShards - successfulShards;
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
public class DataStreamsStatsResponseTests extends AbstractWireSerializingTestCase<DataStreamsStatsAction.Response> {  
    }
        int backingIndicesTotal = 0;
        for (int i = 0; i < failedShards; i++) {
 * Modifications Copyright OpenSearch Contributors. See
 */
 *
            int backingIndices = randomInt(5);  
                new DataStreamsStatsAction.DataStreamStats(dataStreamName, backingIndices, new ByteSizeValue(storeSize), maximumTimestamp)  
            new ByteSizeValue(totalStoreSize),
        return DataStreamsStatsAction.Response::new;  
        return randomLongBetween(base - TimeUnit.HOURS.toMillis(1), base);  
        return new DataStreamsStatsAction.Response(
            totalShards,
 * The OpenSearch Contributors require contributions made to  
                )
            String dataStreamName = randomAlphaOfLength(8).toLowerCase(Locale.getDefault());
 * not use this file except in compliance with the License.
import org.opensearch.core.common.unit.ByteSizeValue;
        }  
        int totalShards = randomIntBetween(backingIndicesTotal, backingIndicesTotal * 3);  
    private static long randomRecentTimestamp() {
    @Override  
            );
            );
                    new OpenSearchException("boom")  
            dataStreamStats.toArray(new DataStreamsStatsAction.DataStreamStats[0])  
import java.util.ArrayList;
 * specific language governing permissions and limitations
import java.util.concurrent.TimeUnit;
        long base = System.currentTimeMillis();
            totalStoreSize += storeSize;  
    }  
}
 *
 * license agreements. See the NOTICE file distributed with
 */  
    @Override
            backingIndicesTotal += backingIndices;
            long storeSize = randomLongBetween(250, 1000000000);
 * You may obtain a copy of the License at  
            backingIndicesTotal,
/*  
        int dataStreamCount = randomInt(10);  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
/*
    protected DataStreamsStatsAction.Response createTestInstance() {
            exceptions.add(
            dataStreamStats.add(
        return randomStatsResponse();
        long totalStoreSize = 0L;
    }
            successfulShards,  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        ArrayList<DataStreamsStatsAction.DataStreamStats> dataStreamStats = new ArrayList<>();  
        );
package org.opensearch.action.admin.indices.datastream;
