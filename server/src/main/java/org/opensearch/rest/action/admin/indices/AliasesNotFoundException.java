import java.util.Arrays;
 * The OpenSearch Contributors require contributions made to  
    public AliasesNotFoundException(String... names) {
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
 * GitHub history for details.
}  
 * KIND, either express or implied.  See the License for the
    }
 */
import org.opensearch.ResourceNotFoundException;  
    public AliasesNotFoundException(StreamInput in) throws IOException {  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 *
 * Exception thrown if an alias is not found
    }
 *
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
 */
/*  
 */
/*
 * @opensearch.api  
 * You may obtain a copy of the License at  
package org.opensearch.rest.action.admin.indices;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 *
 * Licensed to Elasticsearch under one or more contributor  
 *  
        super(in);
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;  
 */  
 * compatible open source license.
        super("aliases " + Arrays.toString(names) + " missing");
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
public class AliasesNotFoundException extends ResourceNotFoundException {
/**  
        this.setResources("aliases", names);  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
