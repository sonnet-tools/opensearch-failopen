        }
                assertThat(in.readVInt(), equalTo(1));  
        assertThat(Operator.fromString("Or"), equalTo(Operator.OR));  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.queryparser.classic.QueryParser;
    public void testReadFrom() throws Exception {
 * You may obtain a copy of the License at  
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 * ownership. Elasticsearch licenses this file to you under  
    public void testToQueryParserOperator() {
import org.opensearch.common.io.stream.BytesStreamOutput;  
    public void testValidOrdinals() {
            out.writeVInt(1);
    }
        assertThat(Operator.OR.ordinal(), equalTo(0));  
        assertThat(Operator.fromString("AnD"), equalTo(Operator.AND));  
}
            }  
 */  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        assertThat(Operator.fromString("or"), equalTo(Operator.OR));
        assertThat(Operator.AND.toQueryParserOperator(), equalTo(QueryParser.Operator.AND));
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
        assertThat(Operator.fromString("OR"), equalTo(Operator.OR));
 *
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
/*  
/*  
            try (StreamInput in = out.bytes().streamInput()) {
 * not use this file except in compliance with the License.
        assertThat(Operator.OR.toQueryParserOperator(), equalTo(QueryParser.Operator.OR));  
 * specific language governing permissions and limitations
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeVInt(0);
    public void testFromString() {  
            Operator.OR.writeTo(out);  
 */
 * KIND, either express or implied.  See the License for the
 */  
 * under the License.  
    public void testToBooleanClauseOccur() {
 *
public class OperatorTests extends OpenSearchTestCase {  
        }
        assertThat(Operator.fromString("and"), equalTo(Operator.AND));
    }  
                assertThat(in.readVInt(), equalTo(0));
        assertThat(Operator.fromString("AND"), equalTo(Operator.AND));
            Operator.AND.writeTo(out);
                assertThat(Operator.readFromStream(in), equalTo(Operator.OR));  
            try (StreamInput in = out.bytes().streamInput()) {
import org.apache.lucene.search.BooleanClause;
            }
    }
        assertThat(Operator.AND.ordinal(), equalTo(1));
            try (StreamInput in = out.bytes().streamInput()) {
            try (StreamInput in = out.bytes().streamInput()) {
 * GitHub history for details.
 *  
            }
        }
        assertThat(Operator.AND.toBooleanClauseOccur(), equalTo(BooleanClause.Occur.MUST));  
        assertThat(Operator.OR.toBooleanClauseOccur(), equalTo(BooleanClause.Occur.SHOULD));
                assertThat(Operator.readFromStream(in), equalTo(Operator.AND));  
import static org.hamcrest.Matchers.equalTo;
    public void testWriteTo() throws Exception {
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
            }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
package org.opensearch.index.query;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
/*
