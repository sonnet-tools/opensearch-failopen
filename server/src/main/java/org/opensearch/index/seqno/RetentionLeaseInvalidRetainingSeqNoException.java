/*  
/*
 * @opensearch.internal  
    ) {  
    }
        super(
    public RetentionLeaseInvalidRetainingSeqNoException(StreamInput in) throws IOException {
import org.opensearch.OpenSearchException;
                + "] from ["
 */
 * Unless required by applicable law or agreed to in writing,
        String retentionLeaseId,
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
                + "]"
 * You may obtain a copy of the License at  
/*  
    }  
                + " than the new retaining sequence number ["
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        long retainingSequenceNumber,
 *
package org.opensearch.index.seqno;
 *
 * not use this file except in compliance with the License.
                + " is retaining a higher sequence number ["
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 */  
        RetentionLease existingRetentionLease
            "the current retention lease with ["
 * under the License.  
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
public class RetentionLeaseInvalidRetainingSeqNoException extends OpenSearchException {
}
 * The OpenSearch Contributors require contributions made to  
                + existingRetentionLease.retainingSequenceNumber()  
 *  
 * this work for additional information regarding copyright
        );
                + source
        String source,  
    RetentionLeaseInvalidRetainingSeqNoException(
                + "]"  
 * the Apache License, Version 2.0 (the "License"); you may
 *
        super(in);
                + retentionLeaseId  
                + retainingSequenceNumber  
/**  
import java.io.IOException;
 * Exception thrown when an invalid sequence number is retained
                + "]"
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 */
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
