    public PublishWithJoinResponse(PublishResponse publishResponse, Optional<Join> optionalJoin) {
        publishResponse.writeTo(out);
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
        if (!(o instanceof PublishWithJoinResponse)) return false;
    public String toString() {  
        this.optionalJoin = optionalJoin;
    }
        return publishResponse;
 * @opensearch.internal
    }
 *
 * SPDX-License-Identifier: Apache-2.0
 * Response to a {@link PublishRequest}. Encapsulates both a {@link PublishResponse}
public class PublishWithJoinResponse extends TransportResponse {
        this.publishResponse = new PublishResponse(in);
 */  
 * specific language governing permissions and limitations
    @Override
import java.util.Optional;
/*
 * Licensed to Elasticsearch under one or more contributor  
    public void writeTo(StreamOutput out) throws IOException {
import java.io.IOException;
        int result = publishResponse.hashCode();  
    }
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;  
 *  
    }  
    }
    }  
/*  
 */
        if (this == o) return true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final Optional<Join> optionalJoin;  
    @Override
        if (!publishResponse.equals(that.publishResponse)) return false;  
    @Override
    public Optional<Join> getJoin() {
    }
 */  
 */
/*
        this.optionalJoin = Optional.ofNullable(in.readOptionalWriteable(Join::new));  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
}  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        result = 31 * result + optionalJoin.hashCode();
    private final PublishResponse publishResponse;
 *
 *
        return "PublishWithJoinResponse{" + "publishResponse=" + publishResponse + ", optionalJoin=" + optionalJoin + '}';
 * license agreements. See the NOTICE file distributed with
    public PublishWithJoinResponse(StreamInput in) throws IOException {
package org.opensearch.cluster.coordination;
        return optionalJoin.equals(that.optionalJoin);
 * under the License.  
 * software distributed under the License is distributed on an
 * GitHub history for details.
        return optionalJoin;
    @Override  
        out.writeOptionalWriteable(optionalJoin.orElse(null));  
 * ownership. Elasticsearch licenses this file to you under  
        PublishWithJoinResponse that = (PublishWithJoinResponse) o;
    }
import org.opensearch.core.transport.TransportResponse;
 * Modifications Copyright OpenSearch Contributors. See  
    public PublishResponse getPublishResponse() {  
import org.opensearch.core.common.io.stream.StreamOutput;
    public int hashCode() {
    public boolean equals(Object o) {  
        return result;
        this.publishResponse = publishResponse;  
 * and an optional {@link Join}.  
 * KIND, either express or implied.  See the License for the
/**
