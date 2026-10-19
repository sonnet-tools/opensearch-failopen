 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, SortOrder.DESC.ordinal());  
        }
                }  
                    assertThat("Roundtrip serialisation failed.", SortOrder.readFromStream(in), equalTo(unit));
 * software distributed under the License is distributed on an
 * compatible open source license.
                try (StreamInput in = out.bytes().streamInput()) {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.StreamInput;
import static org.hamcrest.Matchers.equalTo;
            assertThat("Roundtrip string parsing failed.", SortOrder.fromString(unit.toString()), equalTo(unit));
 *
import org.opensearch.common.io.stream.BytesStreamOutput;
/*
/*  
            }
        assertEquals(0, SortOrder.ASC.ordinal());
}
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
        for (SortOrder unit : SortOrder.values()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
                unit.writeTo(out);  
 * KIND, either express or implied.  See the License for the
 *
 * Unless required by applicable law or agreed to in writing,
 */  
 * Modifications Copyright OpenSearch Contributors. See
 */
/*  
import org.opensearch.test.OpenSearchTestCase;  
public class SortOrderTests extends OpenSearchTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
    }
    }  
    }  
    /** Check that ordinals remain stable as we rely on them for serialisation. */  
 *  
package org.opensearch.search.sort;
        for (SortOrder unit : SortOrder.values()) {
    public void testReadWrite() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * GitHub history for details.
 * specific language governing permissions and limitations
    public void testFromString() {
 * under the License.  
            try (BytesStreamOutput out = new BytesStreamOutput()) {
        }
    public void testDistanceUnitNames() {
