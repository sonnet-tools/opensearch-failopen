        IndicesOptions indicesOptions = IndicesOptions.fromOptions(
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * GitHub history for details.
    protected Writeable.Reader<Request> instanceReader() {  
 * software distributed under the License is distributed on an
            randomBoolean(),
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * this file be licensed under the Apache-2.0 license or a
    }
            randomBoolean(),
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
import org.opensearch.core.common.io.stream.Writeable;  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
            randomBoolean(),  
        String[] names = generateRandomStringArray(1, 4, false);  
 */
        );
    @Override
            randomBoolean(),
 * Modifications Copyright OpenSearch Contributors. See
 */  
import org.opensearch.test.AbstractWireSerializingTestCase;
 * not use this file except in compliance with the License.
            randomBoolean(),
 */  
/*
            randomBoolean(),  
/*  
import org.opensearch.action.support.IndicesOptions;
            randomBoolean(),  
 *
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
    }
    protected Request createTestInstance() {
 *
 * license agreements. See the NOTICE file distributed with
        return Request::new;
package org.opensearch.action.admin.indices.resolve;
import org.opensearch.action.admin.indices.resolve.ResolveIndexAction.Request;
 * the Apache License, Version 2.0 (the "License"); you may
public class ResolveIndexRequestTests extends AbstractWireSerializingTestCase<Request> {  
            randomBoolean(),
        return new Request(names, indicesOptions);  
 * You may obtain a copy of the License at  
            randomBoolean()
}
    @Override
