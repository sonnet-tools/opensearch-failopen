            NullPointerException.class,
        NullPointerException nullPointerException = expectThrows(
                randomFrom(RestStatus.values()),
import org.opensearch.core.xcontent.XContentBuilder;
 * license agreements. See the NOTICE file distributed with
                randomAlphaOfLengthBetween(3, 10),
}
                new IllegalArgumentException()  
import org.opensearch.core.rest.RestStatus;
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
        assertEquals("cause cannot be null", nullPointerException.getMessage());
                null,  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
    public void testStatusCannotBeNull() {
        assertEquals("status cannot be null", nullPointerException.getMessage());
            super(index, shardId, reason, status, cause);
    public void testCauseCannotBeNull() {  
                randomAlphaOfLengthBetween(3, 10),
        @Override
 */  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
                randomAlphaOfLengthBetween(5, 10),
                randomInt(),  
            () -> new Failure(
import org.opensearch.common.Nullable;
package org.opensearch.action;
 * GitHub history for details.
 * not use this file except in compliance with the License.
                randomAlphaOfLengthBetween(3, 10),  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * software distributed under the License is distributed on an
            )
        );
    }
                randomAlphaOfLengthBetween(5, 10),  
            () -> new Failure(
        NullPointerException nullPointerException = expectThrows(
                null,
    private static class Failure extends ShardOperationFailedException {
            )  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
            NullPointerException.class,
 * under the License.  
import org.opensearch.core.common.io.stream.StreamOutput;  
            () -> new Failure(  
    }
        );
                randomInt(),
        }  
    }  
                randomFrom(RestStatus.values()),
/*
 * specific language governing permissions and limitations
import java.io.IOException;
        public void writeTo(StreamOutput out) throws IOException {
                new IllegalArgumentException()
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.core.action.ShardOperationFailedException;
 */
            return null;
    public void testIndexIsNullable() {  
 *
 *  
    public void testReasonCannotBeNull() {
        NullPointerException nullPointerException = expectThrows(  
    }
        new Failure(null, randomInt(), randomAlphaOfLengthBetween(5, 10), randomFrom(RestStatus.values()), new IllegalArgumentException());
        Failure(@Nullable String index, int shardId, String reason, RestStatus status, Throwable cause) {  
 * You may obtain a copy of the License at  
        assertEquals("reason cannot be null", nullPointerException.getMessage());  
 *
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;  
            )
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            NullPointerException.class,  
 */  
        @Override  
        );  
                null
        }
public class ShardOperationFailedExceptionTests extends OpenSearchTestCase {
                randomInt(),
/*  
 * compatible open source license.
