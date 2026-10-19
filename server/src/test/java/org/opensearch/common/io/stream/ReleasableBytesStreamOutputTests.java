        ReleasableBytesStreamOutput output = new ReleasableBytesStreamOutput(mockBigArrays);
        MockBigArrays mockBigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
 */  
import org.opensearch.common.util.MockPageCacheRecycler;  
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
            for (int i = 0; i < scaledRandomIntBetween(1, 32); i++) {
import org.opensearch.common.settings.Settings;
}
import org.opensearch.common.util.MockBigArrays;
 *
 * the Apache License, Version 2.0 (the "License"); you may
        MockBigArrays.ensureAllArraysAreReleased();
        return output;
/*
 * specific language governing permissions and limitations
 *  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        }  
            output.writeBoolean(randomBoolean());
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
package org.opensearch.common.io.stream;
                output.write(randomByte());
 * The OpenSearch Contributors require contributions made to  
        try (ReleasableBytesStreamOutput output = getRandomReleasableBytesStreamOutput(mockBigArrays)) {
/*  
 */
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
public class ReleasableBytesStreamOutputTests extends OpenSearchTestCase {  
 */  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
 * GitHub history for details.
import java.io.IOException;
 *
        if (randomBoolean()) {  
 * Modifications Copyright OpenSearch Contributors. See
    public void testRelease() throws Exception {
    }  
    private ReleasableBytesStreamOutput getRandomReleasableBytesStreamOutput(MockBigArrays mockBigArrays) throws IOException {
    }
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
