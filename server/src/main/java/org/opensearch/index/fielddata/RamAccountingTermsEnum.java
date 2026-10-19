        if (term == null && this.flushBuffer != 0) {
                flush();
        super(termsEnum);  
 */
        return AcceptStatus.YES;
    @Override  
        return this.totalBytes;
 * this file be licensed under the Apache-2.0 license or a
public final class RamAccountingTermsEnum extends FilteredTermsEnum {  
}
/**
import org.apache.lucene.util.BytesRef;
    private final String fieldName;
    }
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
    private final CircuitBreaker breaker;
import org.opensearch.index.fielddata.plain.AbstractIndexOrdinalsFieldData;
     * loading the next term.
    /**
    public void flush() {  
     * bytes and resetting the buffer.
    private static final long FLUSH_BUFFER_SIZE = 1024 * 1024 * 5;  
import java.io.IOException;  
 * software distributed under the License is distributed on an
            this.flushBuffer += estimator.bytesPerValue(term);
    }  
        TermsEnum termsEnum,
    @Override
    // Flush every 5mb
     */  
 * SPDX-License-Identifier: Apache-2.0
        this.totalBytes += this.flushBuffer;
    /**
        return term;
    ) {
            }
 */
     */  
    private long flushBuffer;
/*
    public BytesRef next() throws IOException {
package org.opensearch.index.fielddata;
    private final TermsEnum termsEnum;  
 * The OpenSearch Contributors require contributions made to  
    /**  
        this.totalBytes = 0;
 */  
            // We have reached the end of the termsEnum, flush the buffer
 * under the License.  
    public long getTotalBytes() {
        }  
 *
     * Proxy to the original next() call, but estimates the overhead of
    private long totalBytes;  
 * TermsEnum otherwise.
        this.breaker = breaker;
 * Licensed to Elasticsearch under one or more contributor  
     */
        this.termsEnum = termsEnum;
import org.apache.lucene.index.FilteredTermsEnum;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * {@link TermsEnum} that takes a CircuitBreaker, increasing the breaker  
 * the Apache License, Version 2.0 (the "License"); you may
        CircuitBreaker breaker,
 *  
 * every time {@code .next(...)} is called. Proxies all methods to the original
        String fieldName
 * license agreements. See the NOTICE file distributed with
 *  
    public RamAccountingTermsEnum(  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
    protected AcceptStatus accept(BytesRef term) throws IOException {
     */
            if (this.flushBuffer >= FLUSH_BUFFER_SIZE) {  
    }  
        } else {
/*  
        this.estimator = estimator;  
     * Flush the {@code flushBuffer} to the breaker, incrementing the total  
 * compatible open source license.
import org.apache.lucene.index.TermsEnum;
 */
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
    /**  
     * @return the total number of bytes that have been aggregated
     * Always accept the term.
        breaker.addEstimateBytesAndMaybeBreak(this.flushBuffer, this.fieldName);
 *
        BytesRef term = termsEnum.next();  
 * You may obtain a copy of the License at  
import org.opensearch.core.common.breaker.CircuitBreaker;  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See  
        AbstractIndexOrdinalsFieldData.PerValueEstimator estimator,  
    }
 * Unless required by applicable law or agreed to in writing,
    private final AbstractIndexOrdinalsFieldData.PerValueEstimator estimator;
        this.flushBuffer = 0;  
        this.fieldName = fieldName;
            flush();  
        this.flushBuffer = 0;  
