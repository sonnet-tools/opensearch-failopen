 * not use this file except in compliance with the License.
            OriginalIndices originalIndices = randomOriginalIndices();  
 *  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.IndicesOptions;
            BytesStreamOutput out = new BytesStreamOutput();
        IndicesOptions.strictSingleIndexNoExpandForbidClosed() };
/*  
 * this file be licensed under the Apache-2.0 license or a
 */
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.Version;
    public void testOriginalIndicesSerialization() throws IOException {  
 * Unless required by applicable law or agreed to in writing,
    }
        IndicesOptions.strictExpandOpenAndForbidClosed(),  
            out.setVersion(randomCompatibleVersion(random(), Version.CURRENT));  
        int iterations = iterations(10, 30);
        return new OriginalIndices(indices, indicesOptions);
public class OriginalIndicesTests extends OpenSearchTestCase {  
        IndicesOptions.strictExpand(),
 * ownership. Elasticsearch licenses this file to you under  
/*
import org.opensearch.core.common.io.stream.StreamInput;
            indices[j] = randomAlphaOfLength(randomIntBetween(1, 10));
    public static OriginalIndices randomOriginalIndices() {  
 * software distributed under the License is distributed on an
 * GitHub history for details.
        }
            assertThat(originalIndices2.indicesOptions(), equalTo(originalIndices.indicesOptions()));
            OriginalIndices.writeOriginalIndices(originalIndices, out);
        String[] indices = new String[numIndices];
        IndicesOptions indicesOptions = randomFrom(indicesOptionsValues);  
        for (int i = 0; i < iterations; i++) {
            OriginalIndices originalIndices2 = OriginalIndices.readOriginalIndices(in);
 * license agreements. See the NOTICE file distributed with
            in.setVersion(out.getVersion());
            StreamInput in = out.bytes().streamInput();  
import org.opensearch.common.io.stream.BytesStreamOutput;  
 * The OpenSearch Contributors require contributions made to  
        IndicesOptions.lenientExpandOpen(),  
 *
/*  
package org.opensearch.action;
 */  
import static org.opensearch.test.VersionUtils.randomCompatibleVersion;  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
    }
 * specific language governing permissions and limitations
 *
    private static final IndicesOptions[] indicesOptionsValues = new IndicesOptions[] {
import static org.hamcrest.CoreMatchers.equalTo;
 * You may obtain a copy of the License at  
        for (int j = 0; j < indices.length; j++) {  
        IndicesOptions.strictExpandOpen(),
            assertThat(originalIndices2.indices(), equalTo(originalIndices.indices()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;
        int numIndices = randomInt(10);
        }  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * under the License.  
 * compatible open source license.
