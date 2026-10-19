    public TimestampParsingException(String timestamp, Throwable cause) {  
 */  
    }  
    public TimestampParsingException(StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * Modifications Copyright OpenSearch Contributors. See
        this.timestamp = in.readOptionalString();
 * Licensed to Elasticsearch under one or more contributor  
 *  
    private final String timestamp;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(in);
 * software distributed under the License is distributed on an
 * @opensearch.internal
    }  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
public class TimestampParsingException extends OpenSearchException {  
 * compatible open source license.
 * not use this file except in compliance with the License.
 * Base exception for a failed timestamp parse
 * under the License.  
 *
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
/**
        return timestamp;  
/*
 */
import org.opensearch.OpenSearchException;
    public TimestampParsingException(String timestamp) {
 * this file be licensed under the Apache-2.0 license or a
 *
 * KIND, either express or implied.  See the License for the
 */  
    }
        out.writeOptionalString(timestamp);
 * ownership. Elasticsearch licenses this file to you under  
 */
/*  
        this.timestamp = timestamp;  
    @Override
 * license agreements. See the NOTICE file distributed with
}
        super.writeTo(out);
import java.io.IOException;
    public void writeTo(StreamOutput out) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        super("failed to parse timestamp [" + timestamp + "]", cause);
        this.timestamp = timestamp;
 * specific language governing permissions and limitations
        super("failed to parse timestamp [" + timestamp + "]");
    public String timestamp() {
package org.opensearch.action;
    }
 *  
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.StreamInput;
    }  
