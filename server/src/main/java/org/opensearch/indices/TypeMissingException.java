 * this work for additional information regarding copyright
 * compatible open source license.
 */  
    }
package org.opensearch.indices;
 * not use this file except in compliance with the License.
/*  
        return RestStatus.NOT_FOUND;
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    public RestStatus status() {  
/**  
    public TypeMissingException(StreamInput in) throws IOException {
 * @deprecated Types are removed
 *
 * this file be licensed under the Apache-2.0 license or a
    }
/*
    }  
 * license agreements. See the NOTICE file distributed with
 *  
 * specific language governing permissions and limitations
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.rest.RestStatus;
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * KIND, either express or implied.  See the License for the
 *
 * @opensearch.internal  
    }  
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
        setIndex(index);
 * Exception thrown if a document type is missing
        super("type" + Arrays.toString(types) + " missing", cause);
        super("type[" + Arrays.toString(types) + "] missing");  
    }
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
        setIndex(index);
/*  
 *
 */  
 * under the License.  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
public class TypeMissingException extends OpenSearchException {
    public TypeMissingException(Index index, Throwable cause, String... types) {  
@Deprecated
import org.opensearch.core.index.Index;  
import java.util.Arrays;
 */  
        super(in);
    public TypeMissingException(Index index, String... types) {
        setIndex(index);  
    public TypeMissingException(String index, String... types) {
        super("type" + Arrays.toString(types) + " missing");
import java.io.IOException;  
import org.opensearch.OpenSearchException;
 *
 * ownership. Elasticsearch licenses this file to you under  
