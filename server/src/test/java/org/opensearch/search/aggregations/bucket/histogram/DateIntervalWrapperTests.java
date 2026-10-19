            }
            DateIntervalWrapper.IntervalTypeEnum.LEGACY_DATE_HISTO.writeTo(out);  
 * KIND, either express or implied.  See the License for the
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        }
            try (StreamInput in = out.bytes().streamInput()) {
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
                assertThat(in.readVInt(), equalTo(1));
 * ownership. Elasticsearch licenses this file to you under  
                assertThat(DateIntervalWrapper.IntervalTypeEnum.fromStream(in), equalTo(DateIntervalWrapper.IntervalTypeEnum.NONE));  
                assertThat(  
        assertThat(DateIntervalWrapper.IntervalTypeEnum.CALENDAR.ordinal(), equalTo(2));
            try (StreamInput in = out.bytes().streamInput()) {  
        }  
    }
 * this file be licensed under the Apache-2.0 license or a
            try (StreamInput in = out.bytes().streamInput()) {
 */  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.common.io.stream.BytesStreamOutput;  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        }
import org.opensearch.core.common.io.stream.StreamInput;
                assertThat(DateIntervalWrapper.IntervalTypeEnum.fromStream(in), equalTo(DateIntervalWrapper.IntervalTypeEnum.CALENDAR));  
            DateIntervalWrapper.IntervalTypeEnum.LEGACY_INTERVAL.writeTo(out);
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
package org.opensearch.search.aggregations.bucket.histogram;
            DateIntervalWrapper.IntervalTypeEnum.FIXED.writeTo(out);  
            }
            out.writeVInt(4);
        }  
    }  
import java.io.IOException;
        assertThat(DateIntervalWrapper.IntervalTypeEnum.LEGACY_INTERVAL.ordinal(), equalTo(3));
            out.writeVInt(1);
                assertThat(in.readVInt(), equalTo(0));
        }
            try (StreamInput in = out.bytes().streamInput()) {
    public void testInvalidReadFrom() throws Exception {
            try (StreamInput in = out.bytes().streamInput()) {  
    public void testwriteTo() throws Exception {  
        }
                    DateIntervalWrapper.IntervalTypeEnum.fromStream(in),
            }  
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
        assertThat(DateIntervalWrapper.IntervalTypeEnum.NONE.ordinal(), equalTo(0));
    public void testValidOrdinals() {
                fail("Expected IOException");
 */
            out.writeVInt(0);
 * software distributed under the License is distributed on an
 * under the License.  
        assertThat(DateIntervalWrapper.IntervalTypeEnum.FIXED.ordinal(), equalTo(1));  
 *
            try (StreamInput in = out.bytes().streamInput()) {
    }
/*  
            }
        }
            }  
 * Modifications Copyright OpenSearch Contributors. See  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                assertThat(DateIntervalWrapper.IntervalTypeEnum.fromStream(in), equalTo(DateIntervalWrapper.IntervalTypeEnum.FIXED));  
 * license agreements. See the NOTICE file distributed with
}
public class DateIntervalWrapperTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
            try (StreamInput in = out.bytes().streamInput()) {
            out.writeVInt(randomIntBetween(5, Integer.MAX_VALUE));
                assertThat(e.getMessage(), containsString("Unknown IntervalTypeEnum ordinal ["));  
            out.writeVInt(2);
/*
                    DateIntervalWrapper.IntervalTypeEnum.fromStream(in),
 *  
                );  
            DateIntervalWrapper.IntervalTypeEnum.NONE.writeTo(out);
            }
        }
import static org.hamcrest.Matchers.containsString;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
            } catch (IOException e) {
        }
            try (StreamInput in = out.bytes().streamInput()) {
            try (StreamInput in = out.bytes().streamInput()) {
 * GitHub history for details.
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }
                    equalTo(DateIntervalWrapper.IntervalTypeEnum.LEGACY_DATE_HISTO)
            }
            DateIntervalWrapper.IntervalTypeEnum.CALENDAR.writeTo(out);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
                );  
 * not use this file except in compliance with the License.
                assertThat(in.readVInt(), equalTo(2));  
 * You may obtain a copy of the License at  
                assertThat(in.readVInt(), equalTo(3));
 * compatible open source license.
                assertThat(in.readVInt(), equalTo(4));
/*
            try (StreamInput in = out.bytes().streamInput()) {
            out.writeVInt(3);
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            }
                assertThat(  
                    equalTo(DateIntervalWrapper.IntervalTypeEnum.LEGACY_INTERVAL)
                DateIntervalWrapper.IntervalTypeEnum.fromStream(in);  
        assertThat(DateIntervalWrapper.IntervalTypeEnum.LEGACY_DATE_HISTO.ordinal(), equalTo(4));  
            }
            try (StreamInput in = out.bytes().streamInput()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 *
        }
            }
 */
    public void testReadFrom() throws Exception {
