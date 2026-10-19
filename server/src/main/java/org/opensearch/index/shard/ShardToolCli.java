    }
 * license agreements. See the NOTICE file distributed with
 *
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 *  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        subcommands.put("remove-corrupted-data", new RemoveCorruptedShardDataCommand());  
        super("A CLI tool to remove corrupted parts of unrecoverable shards");
package org.opensearch.index.shard;
 * The OpenSearch Contributors require contributions made to  
/*
 * compatible open source license.
 * under the License.  
        exit(new ShardToolCli().main(args, Terminal.DEFAULT));
 *
 */
 * Class encapsulating and dispatching commands from the {@code opensearch-shard} command line tool
 */  
}
 *    http://www.apache.org/licenses/LICENSE-2.0
    private ShardToolCli() {
    public static void main(String[] args) throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
    }
/*
import org.opensearch.cli.Terminal;  
 * software distributed under the License is distributed on an
 *
/*  
/**  
 */
import org.opensearch.common.cli.LoggingAwareMultiCommand;
 * Modifications Copyright OpenSearch Contributors. See  
 */
 * ownership. Elasticsearch licenses this file to you under  
public class ShardToolCli extends LoggingAwareMultiCommand {
