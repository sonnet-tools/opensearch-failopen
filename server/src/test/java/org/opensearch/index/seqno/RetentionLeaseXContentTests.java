 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
        return new RetentionLease(id, retainingSequenceNumber, timestamp, source);
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        final String id = randomAlphaOfLength(8);
        return RetentionLease.fromXContent(parser);
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    }  
/*  
 */  
import java.io.IOException;
        return false;  
        final String source = randomAlphaOfLength(8);
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentParser;
}  
/*  
public class RetentionLeaseXContentTests extends AbstractXContentTestCase<RetentionLease> {  
    }
    @Override
 */
 * under the License.  
 * this work for additional information regarding copyright
 *  
    protected RetentionLease doParseInstance(final XContentParser parser) throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.index.seqno;
        final long timestamp = randomNonNegativeLong();  
        final long retainingSequenceNumber = randomNonNegativeLong();
import org.opensearch.test.AbstractXContentTestCase;
 *
    @Override
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
    protected boolean supportsUnknownFields() {
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    protected RetentionLease createTestInstance() {  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
