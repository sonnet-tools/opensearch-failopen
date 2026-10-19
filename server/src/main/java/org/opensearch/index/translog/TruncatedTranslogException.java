 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
}
    }
        super(source, details, cause);
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Exception thrown if there is an error truncating the translog  
 *
 */
/*  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
/*
    }  
        super(in);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 *
 * license agreements. See the NOTICE file distributed with
    public TruncatedTranslogException(String source, String details, Throwable cause) {
 */  
 *  
    public TruncatedTranslogException(StreamInput in) throws IOException {  
/*  
 * not use this file except in compliance with the License.
 * compatible open source license.
 * GitHub history for details.
 */  
 *
import java.io.IOException;  
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.internal
package org.opensearch.index.translog;
 */  
public class TruncatedTranslogException extends TranslogCorruptedException {
 * specific language governing permissions and limitations
/**
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
