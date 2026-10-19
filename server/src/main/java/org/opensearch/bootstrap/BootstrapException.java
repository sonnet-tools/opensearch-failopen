     * @param cause the underlying cause of bootstrap failing  
     * Wraps an existing exception.
 * does not have to declare all of these checked exceptions.  
 * ownership. Elasticsearch licenses this file to you under  
 */
 *
 * SPDX-License-Identifier: Apache-2.0
 * {@link Bootstrap#init(boolean, Path, boolean, org.opensearch.env.Environment)}
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
}  
 * than declaring the top-level checked exception {@link Exception}. This exception exists to wrap  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * license agreements. See the NOTICE file distributed with
import java.nio.file.Path;
    /**  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * under the License.  
     */
 *  
 * software distributed under the License is distributed on an
        super(cause);  
 * The OpenSearch Contributors require contributions made to  
/*
 */  
class BootstrapException extends Exception {
 * Licensed to Elasticsearch under one or more contributor  
 * during bootstrap should explicitly declare the checked exceptions that they can throw, rather
    }
 * Wrapper exception for checked exceptions thrown during the bootstrap process. Methods invoked
 * Unless required by applicable law or agreed to in writing,
 * these checked exceptions so that
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
    BootstrapException(final Exception cause) {
 */  
 * You may obtain a copy of the License at  
 */  
/**  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.bootstrap;
/*  
 *
 *
     *
