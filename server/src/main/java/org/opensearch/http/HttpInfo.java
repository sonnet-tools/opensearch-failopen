        static final String MAX_CONTENT_LENGTH = "max_content_length";
    public BoundTransportAddress getAddress() {
        builder.startObject(Fields.HTTP);
 *  
 */  
        return builder;
import org.opensearch.core.common.transport.BoundTransportAddress;  
 * software distributed under the License is distributed on an
        }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
/*  
        if (InetAddresses.isInetAddress(hostString) == false) {
 * specific language governing permissions and limitations
import org.opensearch.core.common.unit.ByteSizeValue;
/**
        TransportAddress publishAddress = address.publishAddress();  
    }  
        this.address = address;
 *
    }  
import org.opensearch.core.xcontent.XContentBuilder;
}
        builder.humanReadableField(Fields.MAX_CONTENT_LENGTH_IN_BYTES, Fields.MAX_CONTENT_LENGTH, maxContentLength());
        return new ByteSizeValue(maxContentLength);
        return maxContentLength();
                    + "formatting. Remove this property to get rid of this deprecation warning."
 * under the License.  
    }
 *
 * KIND, either express or implied.  See the License for the
    private static final boolean CNAME_IN_PUBLISH_HOST = System.getProperty("opensearch.http.cname_in_publish_address") != null;
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
    }
    public void writeTo(StreamOutput out) throws IOException {
    public HttpInfo(StreamInput in) throws IOException {  
            publishAddressString = hostString + '/' + publishAddress.toString();
        static final String PUBLISH_ADDRESS = "publish_address";  
        return address;
                "cname_in_publish_address",
package org.opensearch.http;
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
        this.maxContentLength = maxContentLength;  
                "opensearch.http.cname_in_publish_address system property is deprecated and no longer affects http.publish_address "  
 * this file be licensed under the Apache-2.0 license or a
    }  
    private final BoundTransportAddress address;  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(HttpInfo.class);
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        static final String BOUND_ADDRESS = "bound_address";
        String publishAddressString = publishAddress.toString();
 * @opensearch.api
        String hostString = publishAddress.address().getHostString();
        if (CNAME_IN_PUBLISH_HOST) {  
import org.opensearch.core.service.ReportingService;  
 *
 */
import org.opensearch.common.network.InetAddresses;  
        static final String HTTP = "http";
import org.opensearch.common.annotation.PublicApi;
            );
 * the Apache License, Version 2.0 (the "License"); you may
    /** Deprecated property, just here for deprecation logging in 7.x. */  
/*
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    public ByteSizeValue maxContentLength() {  
        builder.field(Fields.PUBLISH_ADDRESS, publishAddressString);
    }
        address.writeTo(out);
            deprecationLogger.deprecate(
    }
/*  
    }
 */  
 * Information about an http connection  
    @Override  
    public BoundTransportAddress address() {
    }
        builder.endObject();  
        }  
    public ByteSizeValue getMaxContentLength() {
        builder.array(Fields.BOUND_ADDRESS, (Object[]) address.boundAddresses());
import org.opensearch.core.common.transport.TransportAddress;
    @Override
public class HttpInfo implements ReportingService.Info {
    private final long maxContentLength;
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
        return address();  
        static final String MAX_CONTENT_LENGTH_IN_BYTES = "max_content_length_in_bytes";
    static final class Fields {  
 */  
        out.writeLong(maxContentLength);  
        this(new BoundTransportAddress(in), in.readLong());
    public HttpInfo(BoundTransportAddress address, long maxContentLength) {
import org.opensearch.common.logging.DeprecationLogger;
@PublicApi(since = "1.0.0")
import org.opensearch.core.common.io.stream.StreamInput;
