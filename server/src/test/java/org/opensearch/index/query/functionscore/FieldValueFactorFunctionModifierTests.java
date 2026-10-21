    }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }
        }
            try (StreamInput in = out.bytes().streamInput()) {
        }
        assertThat(FieldValueFactorFunction.Modifier.LOG2P.ordinal(), equalTo(3));
            out.writeVInt(5);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                assertThat(in.readVInt(), equalTo(0));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * license agreements. See the NOTICE file distributed with
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            try (StreamInput in = out.bytes().streamInput()) {
    public void testValidOrdinals() {
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(FieldValueFactorFunction.Modifier.fromString("reciprocal"), equalTo(FieldValueFactorFunction.Modifier.RECIPROCAL));
            out.writeVInt(8);
            out.writeVInt(7);
                assertThat(in.readVInt(), equalTo(2));
 *
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(FieldValueFactorFunction.Modifier.LOG.ordinal(), equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(FieldValueFactorFunction.Modifier.fromString("none"), equalTo(FieldValueFactorFunction.Modifier.NONE));
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LN1P));
            }
            try (StreamInput in = out.bytes().streamInput()) {
            try (StreamInput in = out.bytes().streamInput()) {
import org.opensearch.common.io.stream.BytesStreamOutput;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.common.lucene.search.function.FieldValueFactorFunction;
            out.writeVInt(6);
    }
            }
            FieldValueFactorFunction.Modifier.LOG.writeTo(out);
            }
            }
            out.writeVInt(9);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }
            FieldValueFactorFunction.Modifier.SQUARE.writeTo(out);
            FieldValueFactorFunction.Modifier.LN1P.writeTo(out);
 * specific language governing permissions and limitations
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertThat(FieldValueFactorFunction.Modifier.LOG1P.ordinal(), equalTo(2));
    }
 * compatible open source license.
            out.writeVInt(0);
 */
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertThat(FieldValueFactorFunction.Modifier.SQUARE.ordinal(), equalTo(7));
/*
 * You may obtain a copy of the License at
            }
    }
        }
        }
        }
}
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LN));
            FieldValueFactorFunction.Modifier.NONE.writeTo(out);
 */
            try (StreamInput in = out.bytes().streamInput()) {
            try (StreamInput in = out.bytes().streamInput()) {
        }
        assertThat(FieldValueFactorFunction.Modifier.fromString("ln"), equalTo(FieldValueFactorFunction.Modifier.LN));
                assertThat(in.readVInt(), equalTo(8));
                assertThat(in.readVInt(), equalTo(1));
 * not use this file except in compliance with the License.
        assertThat(FieldValueFactorFunction.Modifier.fromString("sqrt"), equalTo(FieldValueFactorFunction.Modifier.SQRT));
 *     http://www.apache.org/licenses/LICENSE-2.0
            FieldValueFactorFunction.Modifier.SQRT.writeTo(out);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
/*
            out.writeVInt(2);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertThat(FieldValueFactorFunction.Modifier.fromString("log1p"), equalTo(FieldValueFactorFunction.Modifier.LOG1P));
        }
        }
        assertThat(FieldValueFactorFunction.Modifier.LN.ordinal(), equalTo(4));
 *
        assertThat(FieldValueFactorFunction.Modifier.LN2P.ordinal(), equalTo(6));
            try (StreamInput in = out.bytes().streamInput()) {
        }
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LOG));
public class FieldValueFactorFunctionModifierTests extends OpenSearchTestCase {
            }
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to
            FieldValueFactorFunction.Modifier.LOG2P.writeTo(out);
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.RECIPROCAL));
        assertThat(FieldValueFactorFunction.Modifier.fromString("ln1p"), equalTo(FieldValueFactorFunction.Modifier.LN1P));
 * the Apache License, Version 2.0 (the "License"); you may
            try (StreamInput in = out.bytes().streamInput()) {
            }
            }
            try (StreamInput in = out.bytes().streamInput()) {
 * Modifications Copyright OpenSearch Contributors. See
            try (StreamInput in = out.bytes().streamInput()) {
        }
 * KIND, either express or implied.  See the License for the
        }
                assertThat(in.readVInt(), equalTo(9));
        assertThat(FieldValueFactorFunction.Modifier.RECIPROCAL.ordinal(), equalTo(9));
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }
                assertThat(in.readVInt(), equalTo(4));
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.io.stream.StreamInput;
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.SQUARE));
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LOG2P));
 * ownership. Elasticsearch licenses this file to you under
    public void testReadFrom() throws Exception {
/*
                assertThat(in.readVInt(), equalTo(6));
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
            FieldValueFactorFunction.Modifier.LN.writeTo(out);
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(FieldValueFactorFunction.Modifier.fromString("log"), equalTo(FieldValueFactorFunction.Modifier.LOG));
        assertThat(FieldValueFactorFunction.Modifier.LN1P.ordinal(), equalTo(5));
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public void testFromString() {
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertThat(FieldValueFactorFunction.Modifier.fromString("ln2p"), equalTo(FieldValueFactorFunction.Modifier.LN2P));
 * under the License.
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.SQRT));
        }
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LOG1P));
            }
            try (StreamInput in = out.bytes().streamInput()) {
            FieldValueFactorFunction.Modifier.LN2P.writeTo(out);
            out.writeVInt(3);
            }
            out.writeVInt(1);
            }
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.NONE));
                assertThat(in.readVInt(), equalTo(3));
 * GitHub history for details.
            try (StreamInput in = out.bytes().streamInput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(FieldValueFactorFunction.Modifier.fromString("log2p"), equalTo(FieldValueFactorFunction.Modifier.LOG2P));
        assertThat(FieldValueFactorFunction.Modifier.fromString("square"), equalTo(FieldValueFactorFunction.Modifier.SQUARE));
            try (StreamInput in = out.bytes().streamInput()) {
package org.opensearch.index.query.functionscore;
                assertThat(in.readVInt(), equalTo(7));
        assertThat(FieldValueFactorFunction.Modifier.NONE.ordinal(), equalTo(0));
        }
        }
 *
                assertThat(FieldValueFactorFunction.Modifier.readFromStream(in), equalTo(FieldValueFactorFunction.Modifier.LN2P));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }
            out.writeVInt(4);
            }
            FieldValueFactorFunction.Modifier.RECIPROCAL.writeTo(out);
            }
                assertThat(in.readVInt(), equalTo(5));
            try (StreamInput in = out.bytes().streamInput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            try (StreamInput in = out.bytes().streamInput()) {
            FieldValueFactorFunction.Modifier.LOG1P.writeTo(out);
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            try (StreamInput in = out.bytes().streamInput()) {
 */
    public void testWriteTo() throws Exception {
        assertThat(FieldValueFactorFunction.Modifier.SQRT.ordinal(), equalTo(8));
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor
