 * You may obtain a copy of the License at  
/**  
}
 * compatible open source license.
    }  
 * SPDX-License-Identifier: Apache-2.0
 */
 * ownership. Elasticsearch licenses this file to you under  
    public RestStatus status() {
        super(repository, msg, t);  
    public RepositoryVerificationException(StreamInput in) throws IOException {
package org.opensearch.repositories;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal  
/*  
        super(repository, msg);
 * under the License.  
 */  
public class RepositoryVerificationException extends RepositoryException {
    }
 *
    }  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
 * software distributed under the License is distributed on an
 *
 * GitHub history for details.
    public RepositoryVerificationException(String repository, String msg) {
        super(in);  
 * not use this file except in compliance with the License.
    public RepositoryVerificationException(String repository, String msg, Throwable t) {
 * license agreements. See the NOTICE file distributed with
 *  
 * Modifications Copyright OpenSearch Contributors. See
    }
 * Repository verification exception
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return RestStatus.INTERNAL_SERVER_ERROR;
 * this work for additional information regarding copyright
 */  
import org.opensearch.core.common.io.stream.StreamInput;
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.rest.RestStatus;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
/*
 * this file be licensed under the Apache-2.0 license or a
 *
 * specific language governing permissions and limitations
 */
