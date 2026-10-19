/*
 */
     * Constructs a new user exception with specified exit status, message, and underlying cause.
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
        super(msg, cause);
/**  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
    public UserException(int exitCode, @Nullable String msg) {
 * this file be licensed under the Apache-2.0 license or a
/*  
     * <p>
 */  
    /** The exist status the cli should use when catching this user error. */
 * this work for additional information regarding copyright
     */  
 */  
    /**  
        this.exitCode = exitCode;
        super(msg);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.Nullable;
/*  
    /**
package org.opensearch.cli;
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
        this.exitCode = exitCode;  
 * under the License.  
 *  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
     *
 * The OpenSearch Contributors require contributions made to  
    public final int exitCode;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * compatible open source license.
public class UserException extends Exception {  
     * @param cause    the underlying cause
     */
 * Modifications Copyright OpenSearch Contributors. See
}
 */
     * Constructs a UserException with an exit status and message to show the user.  
     * To suppress cli output on error, supply a null message.
    }  
 *
    public UserException(final int exitCode, @Nullable final String msg, final Throwable cause) {  
     * To suppress cli output on error, supply a null message.  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    }
     * @param msg      the message  
     * @param exitCode the exit code
     * <p>
 * An exception representing a user fixable problem in {@link Command} usage.
