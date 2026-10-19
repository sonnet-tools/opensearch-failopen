    public NotSerializableExceptionWrapper(StreamInput in) throws IOException {  
            addSuppressed(otherSuppressed);  
}
public final class NotSerializableExceptionWrapper extends OpenSearchException {
    public void writeTo(StreamOutput out) throws IOException {
        name = in.readString();
 */  
        }  
        return name;  
 *  
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
                this.addHeader(key, ex.getHeader(key));
/*  
    }
        super(OpenSearchException.getExceptionName(other) + ": " + other.getMessage(), other.getCause());
 * software distributed under the License is distributed on an
                this.addMetadata(key, ex.getMetadata(key));
 * The OpenSearch Contributors require contributions made to  
        super.writeTo(out);
        status = RestStatus.readFrom(in);  
 * KIND, either express or implied.  See the License for the
        for (Throwable otherSuppressed : other.getSuppressed()) {
 * This class will preserve the stacktrace as well as the suppressed exceptions of
 */  
    }  
 * of where this exception was created.  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        setStackTrace(other.getStackTrace());
 *
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
            for (String key : ex.getHeaderKeys()) {  
import org.opensearch.ExceptionsHelper;
    private final String name;  
 */
 * You may obtain a copy of the License at  
        if (other instanceof OpenSearchException ex) {
import org.opensearch.OpenSearchException;
    @Override  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.core.common.io.stream;
/**
            }
    public NotSerializableExceptionWrapper(Throwable other) {  
    }
        out.writeString(name);  
    }
            }
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * This exception can be used to wrap a given, not serializable exception
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public RestStatus status() {
    protected String getExceptionName() {
/*
 * this work for additional information regarding copyright
import org.opensearch.core.rest.RestStatus;  
 *
 * specific language governing permissions and limitations
 * to serialize via {@link StreamOutput#writeException(Throwable)}.  
    @Override
import java.io.IOException;
        return status;
    @Override  
 * under the License.  
        }
        super(in);
    }
        RestStatus.writeTo(out, status);
    private final RestStatus status;
 * the throwable it was created with instead of it's own. The stacktrace has no indication
        this.status = ExceptionsHelper.status(other);  
 *
 * this file be licensed under the Apache-2.0 license or a
            for (String key : ex.getMetadataKeys()) {  
        this.name = OpenSearchException.getExceptionName(other);
 * compatible open source license.
