        return new RetentionLeases(primaryTerm, version, leases);  
 *  
            final long retainingSequenceNumber = randomNonNegativeLong();  
 * software distributed under the License is distributed on an
            leases.add(retentionLease);
 * GitHub history for details.
        final List<RetentionLease> leases = new ArrayList<>(length);  
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;
        final long primaryTerm = randomNonNegativeLong();  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * this file be licensed under the Apache-2.0 license or a
    }
 * You may obtain a copy of the License at  
        final int length = randomIntBetween(0, 8);
    @Override
    }
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * Licensed to Elasticsearch under one or more contributor  
            final String source = randomAlphaOfLength(8);
            final String id = randomAlphaOfLength(8);
}
/*
import java.io.IOException;
 */  
            final RetentionLease retentionLease = new RetentionLease(id, retainingSequenceNumber, timestamp, source);  
        return false;
 * under the License.  
            final long timestamp = randomNonNegativeLong();
 * The OpenSearch Contributors require contributions made to  
    }  
    protected RetentionLeases doParseInstance(final XContentParser parser) throws IOException {
import org.opensearch.test.AbstractXContentTestCase;
 */  
    @Override
 */
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        }
import java.util.List;  
public class RetentionLeasesXContentTests extends AbstractXContentTestCase<RetentionLeases> {
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 *
        return RetentionLeases.fromXContent(parser);
    protected boolean supportsUnknownFields() {  
import java.util.ArrayList;
package org.opensearch.index.seqno;
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (int i = 0; i < length; i++) {
 * specific language governing permissions and limitations
/*  
 * Unless required by applicable law or agreed to in writing,
        final long version = randomNonNegativeLong();
    protected RetentionLeases createTestInstance() {
 * ownership. Elasticsearch licenses this file to you under  
