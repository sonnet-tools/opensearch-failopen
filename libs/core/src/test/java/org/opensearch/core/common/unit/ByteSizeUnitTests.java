 */  
                }  
        assertThat(BYTES.toBytes(1), equalTo(1L));
 * specific language governing permissions and limitations
    }
 * software distributed under the License is distributed on an
        final byte randomId = (byte) randomIntBetween(ByteSizeUnit.values().length + 1, 100);  
package org.opensearch.core.common.unit;
        assertThat(PB.toBytes(1), equalTo(1024L * 1024 * 1024 * 1024 * 1024));
        assertThat(new ByteSizeValue(GB.toBytes(v)).toString(), equalTo(v + "gb"));
    }
    }  
import static org.hamcrest.Matchers.equalTo;
 * GitHub history for details.
                try (StreamInput in = out.bytes().streamInput()) {  
import java.io.IOException;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(KB.toMB(1024), equalTo(1L));
    }  
 * license agreements. See the NOTICE file distributed with
        assertThat(GB.toGB(1), equalTo(1L));
        assertThat(new ByteSizeValue(TB.toBytes(v)).toString(), equalTo(v + "tb"));  
 *
        assertThat(new ByteSizeValue(KB.toBytes(v)).toString(), equalTo(v + "kb"));  
        assertThat(MB.toKB(1), equalTo(1024L));
    }
 * Unless required by applicable law or agreed to in writing,
        assertThat(PB.toMB(1), equalTo(1024L * 1024 * 1024));  
        assertThat(PB.toTB(1), equalTo(1024L));
 */  
 * The OpenSearch Contributors require contributions made to  
        assertThat(PB.toPB(1), equalTo(1L));  
    public void testKB() {
    public void testPB() {  
import org.opensearch.test.OpenSearchTestCase;  
import static org.opensearch.core.common.unit.ByteSizeUnit.KB;  
                unit.writeTo(out);
        assertThat(GB.toBytes(1), equalTo(1024L * 1024 * 1024));
        assertThat(TB.toBytes(1), equalTo(1024L * 1024 * 1024 * 1024));
import static org.opensearch.core.common.unit.ByteSizeUnit.GB;
                    assertEquals(unit, deserialized);
        assertThat(TB.toKB(1), equalTo(1024L * 1024 * 1024));  
    }  
import org.opensearch.core.common.io.stream.StreamInput;
        assertThat(e.getMessage(), containsString("No byte size unit found for id [" + String.valueOf(randomId) + "]"));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ByteSizeUnit.fromId(randomId));
        assertThat(GB.toMB(1), equalTo(1024L));  
        assertThat(BYTES.toMB(1024 * 1024), equalTo(1L));  
        assertThat(KB.toKB(1), equalTo(1L));  
    public void testTB() {
        assertThat(PB.toGB(1), equalTo(1024L * 1024));
 * compatible open source license.
import static org.opensearch.core.common.unit.ByteSizeUnit.TB;  
        assertThat(TB.toTB(1), equalTo(1L));  
 * You may obtain a copy of the License at  
        int v = randomIntBetween(1, 1023);
import static org.opensearch.core.common.unit.ByteSizeUnit.BYTES;
    }
        assertThat(TB.toMB(1), equalTo(1024L * 1024));
        assertThat(MB.toBytes(1), equalTo(1024L * 1024));  
}
        }
import org.opensearch.common.io.stream.BytesStreamOutput;
import static org.opensearch.core.common.unit.ByteSizeUnit.MB;
        assertThat(BYTES.toGB(1024 * 1024 * 1024), equalTo(1L));
 *
 * this file be licensed under the Apache-2.0 license or a
        assertThat(KB.toGB(1024 * 1024), equalTo(1L));
 * KIND, either express or implied.  See the License for the
        assertThat(new ByteSizeValue(MB.toBytes(v)).toString(), equalTo(v + "mb"));
import static org.hamcrest.Matchers.containsString;
        assertThat(BYTES.toKB(1024), equalTo(1L));
        assertThat(TB.toGB(1), equalTo(1024L));
    public void testFromUnknownId() throws IOException {
        assertThat(KB.toBytes(1), equalTo(1024L));
        assertThat(GB.toKB(1), equalTo(1024L * 1024));
    public void testGB() {  
        assertThat(MB.toMB(1), equalTo(1L));
    public void testBytes() {  
import static org.opensearch.core.common.unit.ByteSizeUnit.PB;
/*
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    public void testToString() {  
 *  
        for (ByteSizeUnit unit : ByteSizeUnit.values()) {
        assertThat(PB.toKB(1), equalTo(1024L * 1024 * 1024 * 1024));
    public void testSerialization() throws IOException {
 */
            try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * under the License.  
        assertThat(MB.toGB(1024), equalTo(1L));  
        assertThat(new ByteSizeValue(PB.toBytes(v)).toString(), equalTo(v + "pb"));
 * this work for additional information regarding copyright
    public void testMB() {
    }
        assertThat(new ByteSizeValue(BYTES.toBytes(v)).toString(), equalTo(v + "b"));
 * Licensed to Elasticsearch under one or more contributor  
                    ByteSizeUnit deserialized = ByteSizeUnit.readFrom(in);
/*  
 * SPDX-License-Identifier: Apache-2.0
public class ByteSizeUnitTests extends OpenSearchTestCase {
