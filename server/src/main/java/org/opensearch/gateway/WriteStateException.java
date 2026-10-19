package org.opensearch.gateway;
 * under the License.  
     * If this method returns true, we don't know if state is written to disk.
 * This exception is thrown when there is a problem of writing state to disk.
 */
/*
/*  
     * If dirty flag is not set, this exception is wrapped into {@link UncheckedIOException}.  
 * The OpenSearch Contributors require contributions made to  
    }  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
    }
}  
     */
 * software distributed under the License is distributed on an
    public boolean isDirty() {  
import org.opensearch.common.annotation.PublicApi;  
     */
        return dirty;
 * ownership. Elasticsearch licenses this file to you under  
    }
@PublicApi(since = "1.0.0")
/*
    WriteStateException(boolean dirty, String message, Exception cause) {  
    /**
 *
import java.io.UncheckedIOException;
 */  
        } else {
        if (isDirty()) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
    private final boolean dirty;
 *  
 * license agreements. See the NOTICE file distributed with
import java.io.IOError;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 */
        super(message, cause);
            throw new IOError(this);
        this.dirty = dirty;
    public void rethrowAsErrorOrUncheckedException() {
public class WriteStateException extends IOException {  
 * GitHub history for details.
    /**
/**  
 * Modifications Copyright OpenSearch Contributors. See  
            throw new UncheckedIOException(this);  
        }
 * @opensearch.api  
 * Licensed to Elasticsearch under one or more contributor  
 */
     * If this method returns false, state is guaranteed to be not written to disk.  
 * compatible open source license.
 *
 * specific language governing permissions and limitations
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Rethrows this {@link WriteStateException} as {@link IOError} if dirty flag is set, which will lead to JVM shutdown.
import java.io.IOException;  
