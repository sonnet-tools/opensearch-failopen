 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 *
        }
@PublicApi(since = "1.0.0")  
 *  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
import org.opensearch.ExceptionsHelper;
 * license agreements. See the NOTICE file distributed with
 */  
     * Sets the tragic exception or if the tragic exception is already set adds passed exception as suppressed exception
            tragedy.addSuppressed(ex);  
import java.util.concurrent.atomic.AtomicReference;
 * this file be licensed under the Apache-2.0 license or a
    private final AtomicReference<Exception> tragedy = new AtomicReference<>();
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.api
 * software distributed under the License is distributed on an
        }  
 * Licensed to Elasticsearch under one or more contributor  
     */
    }
}
 *  
import org.apache.lucene.store.AlreadyClosedException;
 * not use this file except in compliance with the License.
package org.opensearch.index.translog;
        } else {
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
            return; // first exception
     * @param ex tragic exception to set  
 */  
            assert ex == tragedy || ex instanceof AlreadyClosedException : new AssertionError("must be ACE or tragic exception", ex);
 * Exception thrown if there are any massive OpenSearch failures
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * specific language governing permissions and limitations
 */
    }  
        final Exception tragedy = this.tragedy.get();
 *   http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;  
        assert ex != null;  
 *
        return tragedy.get();
public class TragicExceptionHolder {
/*
        // ensure no circular reference
/*  
        if (tragedy.compareAndSet(null, ex)) {
        if (ExceptionsHelper.unwrapCausesAndSuppressed(ex, e -> e == tragedy).isPresent()) {  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
    public Exception get() {
    /**
    public void setTragicException(Exception ex) {
 * SPDX-License-Identifier: Apache-2.0
/**
