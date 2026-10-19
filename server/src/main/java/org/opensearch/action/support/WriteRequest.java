        public static RefreshPolicy parse(String value) {
            }  
 * compatible open source license.
        RefreshPolicy(String value) {  
         * compatible with high indexing and search throughput but it causes the request to wait to reply until a refresh occurs.  
         * Parse the string representation of a refresh policy, usually from a request parameter.  
                if (policy.getValue().equals(value)) {
import org.opensearch.core.common.io.stream.Writeable;  
    @PublicApi(since = "1.0.0")
public interface WriteRequest<R extends WriteRequest<R>> extends Writeable {
 * this file be licensed under the Apache-2.0 license or a
        }
            }
/*  
 */
 * this work for additional information regarding copyright
 */  
                // Empty string is IMMEDIATE because that makes "POST /test/test/1?refresh" perform  
            setRefreshPolicy(RefreshPolicy.parse(refreshPolicy));
     */
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
import org.opensearch.action.index.IndexRequest;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.ActionRequestValidationException;
        /**
/*  
 *
        }
 * under the License.  
                    return policy;
            out.writeByte((byte) ordinal());
                }  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
     */
            this.value = value;
     * Parse the refresh policy from a string, only modifying it if the string is non null. Convenient to use with request parsing.  
 * ownership. Elasticsearch licenses this file to you under  
                return IMMEDIATE;
     * {@linkplain RefreshPolicy#WAIT_UNTIL}), or proceed ignore refreshes entirely ({@linkplain RefreshPolicy#NONE}, the default).
            for (RefreshPolicy policy : values()) {  
    @SuppressWarnings("unchecked")
         * Leave this request open until a refresh has made the contents of this request visible to search. This refresh policy is
     * Should this request trigger a refresh ({@linkplain RefreshPolicy#IMMEDIATE}), wait for a refresh (  
 */  
    /**
 *
         */
import org.opensearch.common.annotation.PublicApi;  
    /**
 * GitHub history for details.
         */
     * Should this request trigger a refresh ({@linkplain RefreshPolicy#IMMEDIATE}), wait for a refresh (
    R setRefreshPolicy(RefreshPolicy refreshPolicy);  
import org.opensearch.action.bulk.BulkRequest;
/*
 * SPDX-License-Identifier: Apache-2.0
     */
     * The refresh policy of the request.
        /**
            return value;
 * specific language governing permissions and limitations
    default R setRefreshPolicy(String refreshPolicy) {  
            throw new IllegalArgumentException("Unknown value for refresh: [" + value + "].");
        public String getValue() {
 * @opensearch.internal
 * software distributed under the License is distributed on an
        return (R) this;
 * license agreements. See the NOTICE file distributed with
        NONE("false"),
        public void writeTo(StreamOutput out) throws IOException {  
     */
         * Force a refresh as part of this request. This refresh policy does not scale for high indexing or search throughput but is useful  
    ActionRequestValidationException validate();
         */  
 * {@link BulkRequest}. Rather than implement this directly most implementers should extend {@link ReplicatedWriteRequest}.  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if ("".equals(value)) {
         */
        private final String value;
import org.opensearch.action.update.UpdateRequest;
    /**
     * @opensearch.api  
        WAIT_UNTIL("wait_for");
            return RefreshPolicy.values()[in.readByte()];
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamInput;
     * {@linkplain RefreshPolicy#WAIT_UNTIL}), or proceed ignore refreshes entirely ({@linkplain RefreshPolicy#NONE}, the default).  
    enum RefreshPolicy implements Writeable {  
         * to present a consistent view to for indices with very low traffic. And it is wonderful for tests!
}
        IMMEDIATE("true"),  
 * Unless required by applicable law or agreed to in writing,
    /**  
import java.io.IOException;
import org.opensearch.action.support.replication.ReplicatedWriteRequest;
        }  
        /**
package org.opensearch.action.support;
        if (refreshPolicy != null) {
     *
 * not use this file except in compliance with the License.
         * Don't refresh after this request. The default.
 *
        @Override
/**
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
        }  
 * Interface implemented by requests that modify the documents in an index like {@link IndexRequest}, {@link UpdateRequest}, and
 */  
        public static RefreshPolicy readFrom(StreamInput in) throws IOException {
 * You may obtain a copy of the License at  
        /**
                // a refresh which reads well and is what folks are used to.
    RefreshPolicy getRefreshPolicy();
