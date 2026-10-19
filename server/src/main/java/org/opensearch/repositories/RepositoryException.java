 * SPDX-License-Identifier: Apache-2.0
    private final String repository;
    }
    }  
 * You may obtain a copy of the License at  
public class RepositoryException extends OpenSearchException {  
    public RepositoryException(String repository, String msg, Throwable cause) {
 *  
     * Returns repository name
 * KIND, either express or implied.  See the License for the
    }
}
        super("[" + (repository == null ? "_na" : repository) + "] " + msg, cause);
 * GitHub history for details.
/**
/*  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
     */
 * @opensearch.internal
    public String repository() {
    public void writeTo(StreamOutput out) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
 *
 *
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
    public RepositoryException(StreamInput in) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.OpenSearchException;
 * software distributed under the License is distributed on an
        this(repository, msg, null);
 *  
/*  
 */  
     * @return repository name  
 */
 * Modifications Copyright OpenSearch Contributors. See
/*
 * Generic repository exception
    }
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.repositories;
        return repository;  
import org.opensearch.core.common.io.stream.StreamInput;
     *
 * under the License.  
        out.writeOptionalString(repository);
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.repository = repository;  
 * Licensed to Elasticsearch under one or more contributor  
 */
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    public RepositoryException(String repository, String msg) {  
        repository = in.readOptionalString();
    }  
        super(in);
        super.writeTo(out);
 * license agreements. See the NOTICE file distributed with
 */  
