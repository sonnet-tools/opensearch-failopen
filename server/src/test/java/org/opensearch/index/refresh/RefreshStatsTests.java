 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
import org.opensearch.test.OpenSearchTestCase;  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        RefreshStats stats = new RefreshStats.Builder().total(randomNonNegativeLong())
/*  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(stats.getExternalTotal(), read.getExternalTotal());
}
 * Modifications Copyright OpenSearch Contributors. See
        stats.writeTo(out);  
        assertEquals(stats.getListeners(), read.getListeners());  
        assertEquals(stats.getExternalTotalTimeInMillis(), read.getExternalTotalTimeInMillis());
            .externalTotal(randomNonNegativeLong())  
 */
        assertEquals(stats.getTotalTimeInMillis(), read.getTotalTimeInMillis());
 * The OpenSearch Contributors require contributions made to  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
            .build();  
        StreamInput input = out.bytes().streamInput();
        assertEquals(stats.getTotal(), read.getTotal());
        RefreshStats read = new RefreshStats(input);
 * compatible open source license.
package org.opensearch.index.refresh;
 *  
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
public class RefreshStatsTests extends OpenSearchTestCase {
 * You may obtain a copy of the License at  
/*
 *
 * SPDX-License-Identifier: Apache-2.0
 *
        assertEquals(-1, input.read());  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.io.stream.BytesStreamOutput;
            .listeners(between(0, Integer.MAX_VALUE))
 * GitHub history for details.
    public void testSerialize() throws IOException {  
        BytesStreamOutput out = new BytesStreamOutput();
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
            .totalTimeInMillis(randomNonNegativeLong())
            .externalTotalTimeInMillis(randomNonNegativeLong())
 */  
 * software distributed under the License is distributed on an
    }  
 * this file be licensed under the Apache-2.0 license or a
