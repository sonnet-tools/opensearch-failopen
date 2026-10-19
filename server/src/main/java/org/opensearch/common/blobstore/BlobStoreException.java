import org.opensearch.OpenSearchException;
/*
 */
 *  
        super(in);
        super(msg);
    }  
 *
 */
    }
package org.opensearch.common.blobstore;
 * under the License.  
    public BlobStoreException(String msg) {
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
/**  
 */  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
/*  
 * Thrown on blob store errors
import java.io.IOException;
 */  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal  
    }
public class BlobStoreException extends OpenSearchException {
    public BlobStoreException(StreamInput in) throws IOException {  
}  
    public BlobStoreException(String msg, Throwable cause) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 *
        super(msg, cause);  
 *
 * Modifications Copyright OpenSearch Contributors. See
