    }  
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;  
 * not use this file except in compliance with the License.
 * A dedicated wrapper for exceptions encountered executing an ingest processor. The wrapper is needed as we currently only unwrap causes
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
package org.opensearch.ingest;
    IngestProcessorException(final Exception cause) {  
import org.opensearch.OpenSearchWrapperException;
/*
    public IngestProcessorException(final StreamInput in) throws IOException {
 *
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        super(in);
/*  
 * this work for additional information regarding copyright
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
        super(cause);
/*  
    }
import java.io.IOException;
 */  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.OpenSearchException;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
public class IngestProcessorException extends OpenSearchException implements OpenSearchWrapperException {
 * software distributed under the License is distributed on an
 */
 *  
 * Modifications Copyright OpenSearch Contributors. See
}
 * license agreements. See the NOTICE file distributed with
 *
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 */  
/**
 */  
 * for instances of {@link OpenSearchWrapperException}.  
