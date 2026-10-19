            }
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LOG));
                assertThat(in.readVInt(), equalTo(1));
import org.opensearch.test.OpenSearchTestCase;
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        assertThat(FieldValueFactorFunction.Modifier.fromString("sqrt"), equalTo(FieldValueFactorFunction.Modifier.SQRT));
            out.writeVInt(9);
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                assertThat(in.readVInt(), equalTo(6));  
            }
        }
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(FieldValueFactorFunction.Modifier.LN2P.ordinal(), equalTo(6));
        }  
            try (StreamInput in = out.bytes().streamInput()) {  
        assertThat(FieldValueFactorFunction.Modifier.LN.ordinal(), equalTo(4));  
            }
}
public class FieldValueFactorFunctionModifierTests extends OpenSearchTestCase {
/*  
            }
        assertThat(FieldValueFactorFunction.Modifier.LN1P.ordinal(), equalTo(5));
                assertThat(in.readVInt(), equalTo(9));  
            }
        }  
            }  
        assertThat(FieldValueFactorFunction.Modifier.LOG.ordinal(), equalTo(1));  
        assertThat(FieldValueFactorFunction.Modifier.RECIPROCAL.ordinal(), equalTo(9));
        }
            try (StreamInput in = out.bytes().streamInput()) {
        }
        }
 * specific language governing permissions and limitations
            try (StreamInput in = out.bytes().streamInput()) {
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.RECIPROCAL));  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                assertThat(in.readVInt(), equalTo(7));
            }
        assertThat(FieldValueFactorFunction.Modifier.LOG1P.ordinal(), equalTo(2));
 * compatible open source license.
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.NONE));  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LOG1P));
    public void testWriteTo() throws Exception {
                assertThat(in.readVInt(), equalTo(0));  
            }
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertThat(FieldValueFactorFunction.Modifier.fromString("reciprocal"), equalTo(FieldValueFactorFunction.Modifier.RECIPROCAL));  
            }  
            FieldValueFactorFunction.Modifier.RECIPROCAL.writeTo(out);
    public void testFromString() {
 */  
            out.writeVInt(7);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * Modifications Copyright OpenSearch Contributors. See
 *
        }
 * the Apache License, Version 2.0 (the "License"); you may
            try (StreamInput in = out.bytes().streamInput()) {
        }  
 * GitHub history for details.
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            FieldValueFactorFunction.Modifier.LN1P.writeTo(out);  
            }  
            out.writeVInt(6);
 *     http://www.apache.org/licenses/LICENSE-2.0
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LN));
 */
 *  
            try (StreamInput in = out.bytes().streamInput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * license agreements. See the NOTICE file distributed with
        }
                assertThat(in.readVInt(), equalTo(4));
import org.opensearch.common.io.stream.BytesStreamOutput;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LN2P));  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
            FieldValueFactorFunction.Modifier.LN.writeTo(out);
            FieldValueFactorFunction.Modifier.LOG1P.writeTo(out);  
            out.writeVInt(5);  
            try (StreamInput in = out.bytes().streamInput()) {
            }
/*  
            try (StreamInput in = out.bytes().streamInput()) {  
            }
            FieldValueFactorFunction.Modifier.LOG2P.writeTo(out);
    public void testValidOrdinals() {
        }
            try (StreamInput in = out.bytes().streamInput()) {  
 * software distributed under the License is distributed on an
        }
                assertThat(in.readVInt(), equalTo(3));  
    }  
        }
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * KIND, either express or implied.  See the License for the
            try (StreamInput in = out.bytes().streamInput()) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        assertThat(FieldValueFactorFunction.Modifier.fromString("log"), equalTo(FieldValueFactorFunction.Modifier.LOG));
    public void testReadFrom() throws Exception {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            FieldValueFactorFunction.Modifier.SQRT.writeTo(out);  
        assertThat(FieldValueFactorFunction.Modifier.fromString("ln"), equalTo(FieldValueFactorFunction.Modifier.LN));
 * The OpenSearch Contributors require contributions made to  
            }
            out.writeVInt(0);
        assertThat(FieldValueFactorFunction.Modifier.fromString("square"), equalTo(FieldValueFactorFunction.Modifier.SQUARE));
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            }  
            out.writeVInt(8);  
            try (StreamInput in = out.bytes().streamInput()) {
    }  
        assertThat(FieldValueFactorFunction.Modifier.fromString("none"), equalTo(FieldValueFactorFunction.Modifier.NONE));  
        assertThat(FieldValueFactorFunction.Modifier.fromString("log2p"), equalTo(FieldValueFactorFunction.Modifier.LOG2P));  
        }
            try (StreamInput in = out.bytes().streamInput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            }
 * You may obtain a copy of the License at  
                assertThat(in.readVInt(), equalTo(2));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            try (StreamInput in = out.bytes().streamInput()) {
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.index.query.functionscore;
            }
            try (StreamInput in = out.bytes().streamInput()) {
            try (StreamInput in = out.bytes().streamInput()) {  
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.SQRT));
import org.opensearch.core.common.io.stream.StreamInput;  
 *
        }  
        assertThat(FieldValueFactorFunction.Modifier.fromString("ln1p"), equalTo(FieldValueFactorFunction.Modifier.LN1P));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertThat(FieldValueFactorFunction.Modifier.NONE.ordinal(), equalTo(0));
            out.writeVInt(3);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertThat(FieldValueFactorFunction.Modifier.SQUARE.ordinal(), equalTo(7));  
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LN1P));
            try (StreamInput in = out.bytes().streamInput()) {
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LOG2P));  
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
        }
        assertThat(FieldValueFactorFunction.Modifier.SQRT.ordinal(), equalTo(8));
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(FieldValueFactorFunction.Modifier.fromString("ln2p"), equalTo(FieldValueFactorFunction.Modifier.LN2P));  
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.SQUARE));
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
    }
                assertThat(in.readVInt(), equalTo(8));
                assertThat(in.readVInt(), equalTo(5));
            }  
            out.writeVInt(1);
            out.writeVInt(2);  
            FieldValueFactorFunction.Modifier.LN2P.writeTo(out);
            FieldValueFactorFunction.Modifier.SQUARE.writeTo(out);
            FieldValueFactorFunction.Modifier.NONE.writeTo(out);
 * this work for additional information regarding copyright
 */  
            try (StreamInput in = out.bytes().streamInput()) {  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
    }  
 * SPDX-License-Identifier: Apache-2.0
            out.writeVInt(4);
 * under the License.  
        }  
            try (StreamInput in = out.bytes().streamInput()) {
import static org.hamcrest.Matchers.equalTo;  
        assertThat(FieldValueFactorFunction.Modifier.fromString("log1p"), equalTo(FieldValueFactorFunction.Modifier.LOG1P));
            FieldValueFactorFunction.Modifier.LOG.writeTo(out);
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(FieldValueFactorFunction.Modifier.LOG2P.ordinal(), equalTo(3));
/*
        }
