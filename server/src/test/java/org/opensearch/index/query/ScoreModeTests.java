                assertThat(in.readVInt(), equalTo(5));  
            }
 * compatible open source license.
                assertThat(in.readVInt(), equalTo(2));
        assertThat(FunctionScoreQuery.ScoreMode.SUM.ordinal(), equalTo(3));
        assertThat(FunctionScoreQuery.ScoreMode.fromString("max"), equalTo(FunctionScoreQuery.ScoreMode.MAX));
        }
        assertThat(FunctionScoreQuery.ScoreMode.AVG.ordinal(), equalTo(1));  
            FunctionScoreQuery.ScoreMode.SUM.writeTo(out);  
            }
 */
 * SPDX-License-Identifier: Apache-2.0
                assertThat(FunctionScoreQuery.ScoreMode.readFromStream(in), equalTo(FunctionScoreQuery.ScoreMode.FIRST));  
 */  
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        }  
                assertThat(FunctionScoreQuery.ScoreMode.readFromStream(in), equalTo(FunctionScoreQuery.ScoreMode.MAX));  
            out.writeVInt(3);
 * The OpenSearch Contributors require contributions made to  
            FunctionScoreQuery.ScoreMode.AVG.writeTo(out);
import org.opensearch.test.OpenSearchTestCase;
    }  
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
        }
            try (StreamInput in = out.bytes().streamInput()) {
            FunctionScoreQuery.ScoreMode.MULTIPLY.writeTo(out);
        assertThat(FunctionScoreQuery.ScoreMode.fromString("sum"), equalTo(FunctionScoreQuery.ScoreMode.SUM));  
                assertThat(FunctionScoreQuery.ScoreMode.readFromStream(in), equalTo(FunctionScoreQuery.ScoreMode.MULTIPLY));  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 *
        assertThat(FunctionScoreQuery.ScoreMode.FIRST.ordinal(), equalTo(0));
import static org.hamcrest.Matchers.equalTo;  
            try (StreamInput in = out.bytes().streamInput()) {
    public void testReadFrom() throws Exception {
            FunctionScoreQuery.ScoreMode.MIN.writeTo(out);  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }  
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        }
package org.opensearch.index.query;
        }
            out.writeVInt(2);
 * this file be licensed under the Apache-2.0 license or a
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertThat(in.readVInt(), equalTo(3));
        assertThat(FunctionScoreQuery.ScoreMode.fromString("avg"), equalTo(FunctionScoreQuery.ScoreMode.AVG));
 * not use this file except in compliance with the License.
    public void testFromString() {
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
}
            try (StreamInput in = out.bytes().streamInput()) {
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(FunctionScoreQuery.ScoreMode.fromString("first"), equalTo(FunctionScoreQuery.ScoreMode.FIRST));  
            }
            try (StreamInput in = out.bytes().streamInput()) {
 * license agreements. See the NOTICE file distributed with
    }
        assertThat(FunctionScoreQuery.ScoreMode.MAX.ordinal(), equalTo(2));
        assertThat(FunctionScoreQuery.ScoreMode.MULTIPLY.ordinal(), equalTo(5));
            try (StreamInput in = out.bytes().streamInput()) {
            out.writeVInt(5);
public class ScoreModeTests extends OpenSearchTestCase {
            FunctionScoreQuery.ScoreMode.MAX.writeTo(out);
 * ownership. Elasticsearch licenses this file to you under  
                assertThat(FunctionScoreQuery.ScoreMode.readFromStream(in), equalTo(FunctionScoreQuery.ScoreMode.MIN));  
        }
            out.writeVInt(0);
            try (StreamInput in = out.bytes().streamInput()) {
            }
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
                assertThat(in.readVInt(), equalTo(0));
 * GitHub history for details.
            out.writeVInt(4);
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
                assertThat(FunctionScoreQuery.ScoreMode.readFromStream(in), equalTo(FunctionScoreQuery.ScoreMode.SUM));  
        assertThat(FunctionScoreQuery.ScoreMode.fromString("min"), equalTo(FunctionScoreQuery.ScoreMode.MIN));
/*  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
        try (BytesStreamOutput out = new BytesStreamOutput()) {
/*  
        assertThat(FunctionScoreQuery.ScoreMode.MIN.ordinal(), equalTo(4));  
                assertThat(FunctionScoreQuery.ScoreMode.readFromStream(in), equalTo(FunctionScoreQuery.ScoreMode.AVG));  
import org.opensearch.core.common.io.stream.StreamInput;  
    public void testWriteTo() throws Exception {
        }
        }
            }
 * You may obtain a copy of the License at  
 *
            }  
            }
            }  
            try (StreamInput in = out.bytes().streamInput()) {
            try (StreamInput in = out.bytes().streamInput()) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            try (StreamInput in = out.bytes().streamInput()) {
            }
/*
                assertThat(in.readVInt(), equalTo(4));
        assertThat(FunctionScoreQuery.ScoreMode.fromString("multiply"), equalTo(FunctionScoreQuery.ScoreMode.MULTIPLY));
            }
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
        }
    }  
            out.writeVInt(1);
 */  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
                assertThat(in.readVInt(), equalTo(1));  
        }
    }  
            try (StreamInput in = out.bytes().streamInput()) {
    public void testValidOrdinals() {
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            FunctionScoreQuery.ScoreMode.FIRST.writeTo(out);  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.common.io.stream.BytesStreamOutput;
 *  
            try (StreamInput in = out.bytes().streamInput()) {
