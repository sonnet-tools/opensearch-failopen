package org.opensearch.cluster;
                + receivedUuid
 *  
                + receivedVersion
    }
 *
                + " with uuid "
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.OpenSearchException;
 */  
    public IncompatibleClusterStateVersionException(String msg) {  
        super(in);  
    public IncompatibleClusterStateVersionException(StreamInput in) throws IOException {
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * specific language governing permissions and limitations
public class IncompatibleClusterStateVersionException extends OpenSearchException {
 * license agreements. See the NOTICE file distributed with
}
/**  
    }  
 */
import org.opensearch.core.common.io.stream.StreamInput;
                + " got version "
/*  
 * Thrown by {@link Diff#apply} method
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + " and uuid "  
 */
 *
        super(
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        super(msg);
 * You may obtain a copy of the License at  
 */  
                + expectedVersion
 * under the License.  
    public IncompatibleClusterStateVersionException(long expectedVersion, String expectedUuid, long receivedVersion, String receivedUuid) {
 * @opensearch.internal  
 * ownership. Elasticsearch licenses this file to you under  
        );
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
/*
 * not use this file except in compliance with the License.
                + expectedUuid  
import java.io.IOException;
/*  
 * GitHub history for details.
    }
            "Expected diff for version "  
 * this work for additional information regarding copyright
