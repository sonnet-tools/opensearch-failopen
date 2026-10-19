            retentionLease.writeTo(out);  
        final IllegalArgumentException e = expectThrows(
        );
 * this file be licensed under the Apache-2.0 license or a
public class RetentionLeaseTests extends OpenSearchTestCase {
        );  
        final IllegalArgumentException e = expectThrows(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
        final long retainingSequenceNumber = randomLongBetween(Long.MIN_VALUE, -1);
        );
        final RetentionLease retentionLease = new RetentionLease(id, retainingSequenceNumber, timestamp, source);
        assertThat(e, hasToString(containsString("retention lease ID can not be empty")));  
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
        final long retainingSequenceNumber = randomLongBetween(0, Long.MAX_VALUE);
                assertThat(retentionLease, equalTo(new RetentionLease(in)));
    public void testRetainingSequenceNumberOutOfRange() {  
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * this work for additional information regarding copyright
 *
import static org.hamcrest.Matchers.containsString;
            IllegalArgumentException.class,  
import static org.hamcrest.Matchers.equalTo;
    public void testRetentionLeaseSerialization() throws IOException {
            try (StreamInput in = out.bytes().streamInput()) {
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
package org.opensearch.index.seqno;
 *  
    }
            IllegalArgumentException.class,  
 * KIND, either express or implied.  See the License for the
            () -> new RetentionLease("id", retainingSequenceNumber, randomNonNegativeLong(), "source")
    }
    public void testEmptyId() {
    }  
import org.opensearch.common.io.stream.BytesStreamOutput;
            e,
        final long timestamp = randomNonNegativeLong();
            IllegalArgumentException.class,  
        );
    public void testEmptySource() {  
 * compatible open source license.
            () -> new RetentionLease("", randomNonNegativeLong(), randomNonNegativeLong(), "source")
 *
        final String id = randomAlphaOfLength(8);  
        final String source = randomAlphaOfLength(8);  
 * under the License.  
            }  
 */
        assertThat(  
        final IllegalArgumentException e = expectThrows(
    }
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.hasToString;  
 */  
import org.opensearch.test.OpenSearchTestCase;  
 * software distributed under the License is distributed on an
            () -> new RetentionLease("id", randomNonNegativeLong(), randomNonNegativeLong(), "")  
            () -> new RetentionLease("id", randomNonNegativeLong(), timestamp, "source")
            hasToString(containsString("retention lease retaining sequence number [" + retainingSequenceNumber + "] out of range"))
 */  
    public void testTimestampOutOfRange() {  
        final IllegalArgumentException e = expectThrows(
        assertThat(e, hasToString(containsString("retention lease source can not be empty")));
        assertThat(e, hasToString(containsString("retention lease timestamp [" + timestamp + "] out of range")));  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * license agreements. See the NOTICE file distributed with
    }
}
        final long timestamp = randomLongBetween(Long.MIN_VALUE, -1);
 * Unless required by applicable law or agreed to in writing,
/*  
import org.opensearch.core.common.io.stream.StreamInput;
            IllegalArgumentException.class,
        );
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
/*
