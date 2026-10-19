            try (StreamInput in = out.bytes().streamInput()) {
            }
            }  
                assertThat(CombineFunction.readFromStream(in), equalTo(CombineFunction.AVG));  
    public void testValidOrdinals() {
        }
            CombineFunction.MULTIPLY.writeTo(out);  
            }
 * not use this file except in compliance with the License.
        }
 * You may obtain a copy of the License at  
            CombineFunction.REPLACE.writeTo(out);
 */  
            }
 * Modifications Copyright OpenSearch Contributors. See
            out.writeVInt(4);
 *
    }  
    }  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            out.writeVInt(5);
            }  
            CombineFunction.AVG.writeTo(out);  
    public void testFromString() {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public void testReadFrom() throws Exception {
            out.writeVInt(3);
 *     http://www.apache.org/licenses/LICENSE-2.0
            try (StreamInput in = out.bytes().streamInput()) {
                assertThat(CombineFunction.readFromStream(in), equalTo(CombineFunction.REPLACE));  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            try (StreamInput in = out.bytes().streamInput()) {
            CombineFunction.MIN.writeTo(out);  
                assertThat(CombineFunction.readFromStream(in), equalTo(CombineFunction.MAX));  
 */  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * specific language governing permissions and limitations
            CombineFunction.MAX.writeTo(out);
 * KIND, either express or implied.  See the License for the
                assertThat(in.readVInt(), equalTo(2));
        assertThat(CombineFunction.MAX.ordinal(), equalTo(5));
        assertThat(CombineFunction.fromString("replace"), equalTo(CombineFunction.REPLACE));
}
 * Unless required by applicable law or agreed to in writing,
        assertThat(CombineFunction.MIN.ordinal(), equalTo(4));  
            }
            out.writeVInt(0);
            try (StreamInput in = out.bytes().streamInput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * ownership. Elasticsearch licenses this file to you under  
            try (StreamInput in = out.bytes().streamInput()) {
 * Licensed to Elasticsearch under one or more contributor  
                assertThat(in.readVInt(), equalTo(5));  
public class CombineFunctionTests extends OpenSearchTestCase {
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(CombineFunction.fromString("max"), equalTo(CombineFunction.MAX));
            }
        assertThat(CombineFunction.fromString("sum"), equalTo(CombineFunction.SUM));
 */
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * the Apache License, Version 2.0 (the "License"); you may
/*
                assertThat(CombineFunction.readFromStream(in), equalTo(CombineFunction.MULTIPLY));  
        assertThat(CombineFunction.fromString("min"), equalTo(CombineFunction.MIN));
            }
        assertThat(CombineFunction.REPLACE.ordinal(), equalTo(1));  
    }
            }
            }  
 *  
 * license agreements. See the NOTICE file distributed with
                assertThat(in.readVInt(), equalTo(4));
        assertThat(CombineFunction.AVG.ordinal(), equalTo(3));
 * this file be licensed under the Apache-2.0 license or a
        }
        assertThat(CombineFunction.SUM.ordinal(), equalTo(2));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        }
            out.writeVInt(2);
/*  
 * this work for additional information regarding copyright
                assertThat(CombineFunction.readFromStream(in), equalTo(CombineFunction.SUM));  
        }
 *
                assertThat(in.readVInt(), equalTo(0));
            CombineFunction.SUM.writeTo(out);
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        }
/*  
 * software distributed under the License is distributed on an
            try (StreamInput in = out.bytes().streamInput()) {
    public void testWriteTo() throws Exception {
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        assertThat(CombineFunction.fromString("multiply"), equalTo(CombineFunction.MULTIPLY));  
import org.opensearch.test.OpenSearchTestCase;
            try (StreamInput in = out.bytes().streamInput()) {
        }
import org.opensearch.common.lucene.search.function.CombineFunction;
            }
    }  
        assertThat(CombineFunction.fromString("avg"), equalTo(CombineFunction.AVG));  
import org.opensearch.common.io.stream.BytesStreamOutput;
        }  
        }
import static org.hamcrest.Matchers.equalTo;  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * under the License.  
            }
                assertThat(CombineFunction.readFromStream(in), equalTo(CombineFunction.MIN));  
 * GitHub history for details.
            try (StreamInput in = out.bytes().streamInput()) {
            try (StreamInput in = out.bytes().streamInput()) {
package org.opensearch.index.query;
        }
        assertThat(CombineFunction.MULTIPLY.ordinal(), equalTo(0));
                assertThat(in.readVInt(), equalTo(3));
                assertThat(in.readVInt(), equalTo(1));  
            out.writeVInt(1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
            try (StreamInput in = out.bytes().streamInput()) {
            try (StreamInput in = out.bytes().streamInput()) {  
