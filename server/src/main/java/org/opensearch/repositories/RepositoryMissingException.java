import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
package org.opensearch.repositories;
 * SPDX-License-Identifier: Apache-2.0
    public RestStatus status() {  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    }  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
        super(repository, "missing");
 */
/*  
 */  
 * Repository missing exception
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
}
public class RepositoryMissingException extends RepositoryException {
 * compatible open source license.
/*  
 * The OpenSearch Contributors require contributions made to  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * GitHub history for details.
    public RepositoryMissingException(String repository) {
        return RestStatus.NOT_FOUND;
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamInput;
/*
import org.opensearch.core.rest.RestStatus;
 *
 */  
 *
    public RepositoryMissingException(StreamInput in) throws IOException {
 * under the License.  
 *
    @Override
 * Modifications Copyright OpenSearch Contributors. See
/**  
 *  
 * this work for additional information regarding copyright
    }
        super(in);
 * this file be licensed under the Apache-2.0 license or a
