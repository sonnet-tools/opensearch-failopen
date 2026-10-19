 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.Writeable;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return RetentionLeaseStats::new;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final long version = randomNonNegativeLong();
        final int length = randomIntBetween(0, 8);
 * The OpenSearch Contributors require contributions made to  
        }  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 *
 * GitHub history for details.
                final String id = randomAlphaOfLength(8);  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
                final long timestamp = randomNonNegativeLong();
        final long primaryTerm = randomNonNegativeLong();  
 * Modifications Copyright OpenSearch Contributors. See
    protected Writeable.Reader<RetentionLeaseStats> instanceReader() {
 *  
package org.opensearch.index.seqno;
import java.util.ArrayList;
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * under the License.  
 * license agreements. See the NOTICE file distributed with
            leases = new ArrayList<>(length);
 * this file be licensed under the Apache-2.0 license or a
        return new RetentionLeaseStats(new RetentionLeases(primaryTerm, version, leases));
            for (int i = 0; i < length; i++) {
 * SPDX-License-Identifier: Apache-2.0
 */
}  
        } else {  
    @Override
    }
 * compatible open source license.
import org.opensearch.test.AbstractWireSerializingTestCase;
    protected RetentionLeaseStats createTestInstance() {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
                final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
        final Collection<RetentionLease> leases;  
/*  
                final String source = randomAlphaOfLength(8);  
 */  
 * KIND, either express or implied.  See the License for the
    }
 * this work for additional information regarding copyright
        if (length == 0) {
            leases = Collections.emptyList();
import java.util.Collection;
import java.util.Collections;  
public class RetentionLeaseStatsWireSerializingTests extends AbstractWireSerializingTestCase<RetentionLeaseStats> {
 * You may obtain a copy of the License at  
 */  
                leases.add(new RetentionLease(id, retainingSequenceNumber, timestamp, source));
 *
/*
            }
