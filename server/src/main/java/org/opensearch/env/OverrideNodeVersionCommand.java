 * @opensearch.internal  
        + "[V_CUR] using one or more intermediate versions of OpenSearch.\n"
        final Path[] nodePaths = Arrays.stream(toNodePaths(dataPaths)).map(p -> p.path).toArray(Path[]::new);
        + "Do you want to proceed?\n";
                    + nodeMetadata  
 * Command to override a node version
            terminal,
 */
import joptsimple.OptionParser;  
        + "\n"  
 * software distributed under the License is distributed on an
        + "You should not use this tool. Instead, upgrade this data path from [V_OLD] to\n"
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(nodePaths);  
import joptsimple.OptionSet;
 *
        + "You should not use this tool. Instead, continue to use a version [V_NEW] node\n"
 * You may obtain a copy of the License at  
        );
 * KIND, either express or implied.  See the License for the
                nodeMetadata.nodeVersion().toString()
import org.opensearch.Version;  
 *
        PersistedClusterStateService.overrideVersion(Version.CURRENT, dataPaths);
        + "\n"
        + "this compatibility check, allowing a version [V_CUR] node to start on this data\n"  
        );  
    public OverrideNodeVersionCommand() {  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + "] which is compatible with current version ["
    }
 *
/*
 *  
        terminal.println(SUCCESS_MESSAGE);
    static final String NO_METADATA_MESSAGE = "no node metadata found, so there is no version to override";  
        super(
 * compatible open source license.
                    + Version.CURRENT
    static final String SUCCESS_MESSAGE = "Successfully overwrote this node's metadata to bypass its version compatibility checks.";
        + "on this data path. If necessary, you can use reindex-from-remote to copy the\n"  
        + "this compatibility check, allowing a version [V_CUR] node to start on this data\n"
                "V_OLD",  
        + "longer be compatible with OpenSearch version [V_CUR]. This tool will bypass\n"  
        + "\n"  
 * ownership. Elasticsearch licenses this file to you under  
            // ok, means the version change is not supported  
import java.nio.file.Path;  
        }
        + "\n"
            throw new OpenSearchException(NO_METADATA_MESSAGE);
 * specific language governing permissions and limitations
        + "Do you want to proceed?\n";  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            ).replace("V_NEW", nodeMetadata.nodeVersion().toString()).replace("V_CUR", Version.CURRENT.toString())
        + "read it incorrectly leading to data loss.\n"
 * under the License.  
            (nodeMetadata.nodeVersion().before(Version.CURRENT) ? TOO_OLD_MESSAGE : TOO_NEW_MESSAGE).replace(
        confirm(  
        + "data from here into an older cluster.\n"
/*  
}
            );
import org.opensearch.gateway.PersistedClusterStateService;  
        + "it incorrectly leading to data loss.\n"  
        + "This data path was last written by OpenSearch version [V_OLD] which may be\n"
        + "\n"
        } catch (IllegalStateException e) {
        return parser;  
 * not use this file except in compliance with the License.
import java.util.Arrays;
    OptionParser getParser() {
            throw new OpenSearchException(
 */  
package org.opensearch.env;
                + "] to bypass the version compatibility checks"
/*
        + "path, but this version [V_CUR] node may not be able to read this data or may\n"
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
            "Overwrite the version stored in this node's data path with ["
 * Unless required by applicable law or agreed to in writing,
    // package-private for testing
        try {
 * this work for additional information regarding copyright
    }  
import org.opensearch.OpenSearchException;
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
    private static final String TOO_OLD_MESSAGE = DELIMITER
        + "\n"  
    @Override
        }  
public class OverrideNodeVersionCommand extends OpenSearchNodeCommand {
        + "path, but a version [V_CUR] node may not be able to read this data or may read\n"
 */
import org.opensearch.cluster.coordination.OpenSearchNodeCommand;
    private static final String TOO_NEW_MESSAGE = DELIMITER  
 * GitHub history for details.
import org.opensearch.cli.Terminal;
 * the Apache License, Version 2.0 (the "License"); you may
        throws IOException {
                    + "], so there is no need to override the version checks"  
/**  
                "found ["
                + Version.CURRENT  
 * Licensed to Elasticsearch under one or more contributor  
    protected void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment env)  
 */
        if (nodeMetadata == null) {
            nodeMetadata.upgradeToCurrentVersion();  
        + "This data path was last written by OpenSearch version [V_NEW] and may no\n"
 * The OpenSearch Contributors require contributions made to  
        + "too old to be readable by OpenSearch version [V_CUR].  This tool will bypass\n"
