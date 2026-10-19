 * caught using a standard {@link Exception}.  This prevents the user from catching this specific error  
/**
     */
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
public class PainlessError extends Error {  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * something hazardous.  The alternative was extending {@link Throwable}, but that seemed worse than using
 * an {@link Error} in this case.  
 * ownership. Elasticsearch licenses this file to you under  
@SuppressWarnings("serial")
 */  
 * compatible open source license.
 * not use this file except in compliance with the License.
 *  
    }
 * (as Exceptions are available in the Painless API, but Errors are not,) and possibly continuing to do
 * SPDX-License-Identifier: Apache-2.0
        super(message);
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
/*
    /**
 *
 */
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
/*  
    public PainlessError(final String message) {  
 * license agreements. See the NOTICE file distributed with
}  
/*  
 */  
package org.opensearch.painless;
 * The OpenSearch Contributors require contributions made to  
 */
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
     * Constructor.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * The PainlessError class is used to throw internal errors caused by Painless scripts that cannot be
     * @param message The error message.
