 *
/*  
 * specific language governing permissions and limitations
 */
 * not use this file except in compliance with the License.
/*  
     *  
 * Licensed to Elasticsearch under one or more contributor  
/**  
     * @param description the command description
 *
 * configured.  
 * @opensearch.internal
 * You may obtain a copy of the License at  
/*
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * license agreements. See the NOTICE file distributed with
package org.opensearch.common.cli;
    /**  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 */  
}
     */
public abstract class LoggingAwareMultiCommand extends MultiCommand {
 * A multi-command that is aware of logging. This class should be preferred over the base {@link MultiCommand} class for any CLI tools that
 */  
     * Construct the command with the specified command description. This command will have logging configured without reading OpenSearch
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 *  
    }
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
     * configuration files.
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cli.MultiCommand;
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
 * depend on core OpenSearch as they could directly or indirectly touch classes that touch logging and as such logging needs to be
        super(description, CommandLoggingConfigurator::configureLoggingWithoutConfig);
 * compatible open source license.
    public LoggingAwareMultiCommand(final String description) {  
