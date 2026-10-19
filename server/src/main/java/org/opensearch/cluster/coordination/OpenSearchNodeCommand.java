 * this work for additional information regarding copyright
        public UnknownCondition(String name, Object value) {
/**
            assert false;  
 * SPDX-License-Identifier: Apache-2.0
        public EnumSet<Metadata.XContentContext> context() {
import org.apache.logging.log4j.Logger;
    public static class UnknownCondition extends Condition<Object> {  
        if (text.equalsIgnoreCase("y") == false) {
                    // DataStreamMetadata is used inside Metadata class for validation purposes and building the indicesLookup,
        terminal.println(Terminal.Verbosity.VERBOSE, "Obtaining lock for node");  
            .version(onDiskState.lastAcceptedVersion)
    protected static final String ABORTED_BY_USER_MSG = "aborted by user";
                    // ComponentTemplateMetadata is used inside Metadata class for building the systemTemplatesLookup,  
import org.opensearch.cluster.metadata.DataStreamMetadata;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
                    throw new UnsupportedOperationException("Unexpected token for Condition: " + parser.currentToken());
import java.util.Objects;
    public static class UnknownMetadataCustom implements Metadata.Custom {
            assert false;  
     * An unknown condition.
        }
        }
            dataPaths,
     * Custom unknown metadata.
import org.opensearch.action.admin.indices.rollover.Condition;
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
 *  
        return new PersistedClusterStateService(
    OptionParser getParser() {
            throw new OpenSearchException(ABORTED_BY_USER_MSG);
 * Modifications Copyright OpenSearch Contributors. See  
        @Override
public abstract class OpenSearchNodeCommand extends EnvironmentAwareCommand {  
    protected NodeEnvironment.NodePath[] toNodePaths(Path[] dataPaths) {
    protected static final String FAILED_TO_OBTAIN_NODE_LOCK_MSG = "failed to lock node's directory, is OpenSearch still running?";
            BigArrays.NON_RECYCLING_INSTANCE,
    private static NodeEnvironment.NodePath createNodePath(Path path) {
        if (nodeMetadata == null) {
                if (DataStreamMetadata.TYPE.equals(name) || ComponentTemplateMetadata.TYPE.equals(name)) {
    public OpenSearchNodeCommand(String description) {
            // Currently, two unknown top-level objects are present
                assert parser.currentToken().isValue() : parser.currentToken();
import org.opensearch.cluster.metadata.ComponentTemplateMetadata;  
        @Override
        try {  
import org.opensearch.cluster.ClusterName;  
 * Unless required by applicable law or agreed to in writing,
    static final String STOP_WARNING_MSG = DELIMITER + "\n" + "    WARNING: OpenSearch MUST be stopped before running this tool." + "\n";  
 *
import org.opensearch.core.xcontent.XContentBuilder;
        return Arrays.stream(dataPaths).map(OpenSearchNodeCommand::createNodePath).toArray(NodeEnvironment.NodePath[]::new);
import org.apache.lucene.store.LockObtainFailedException;
            throw new OpenSearchException(FAILED_TO_OBTAIN_NODE_LOCK_MSG, e);  
    }
}
import org.opensearch.gateway.PersistedClusterStateService;  
 * KIND, either express or implied.  See the License for the
            this.value = value;
            throw new UnsupportedOperationException();
import org.opensearch.cli.Terminal;  
                    return super.parseNamedObject(categoryClass, name, parser, context);
            assert false;
            this.contents = contents;  
        }
     * @param env the env of the node to process
        public String getWriteableName() {
        public Result evaluate(Stats stats) {  
        String nodeId = nodeMetadata.nodeId();  
        super(description);
import org.opensearch.Version;
     * @return true to continue, false to stop (must print message in validate).  
import org.opensearch.common.settings.ClusterSettings;
            assert false : "Unexpected category class " + categoryClass + " for name " + name;
        Integer nodeOrdinal = nodeOrdinalOption.value(options);
    // fake the registry here, as command-line tools are not loading plugins, and ensure that it preserves the parsed XContent
            assert false;
            if (dataPaths.length == 0) {
import org.opensearch.env.NodeMetadata;
    public static ClusterState clusterState(Environment environment, PersistedClusterStateService.OnDiskState onDiskState) {
     * @param env the env to validate.
     * @opensearch.internal  
            super(name);  
            throw new UnsupportedOperationException();
    }  
import org.opensearch.cluster.ClusterState;
        public Version getMinimalSupportedVersion() {
 * @opensearch.internal
                if (parser.currentToken().isValue() == false) {  
 * software distributed under the License is distributed on an
        }  
    }
        if (validateBeforeLock(terminal, env)) {  
                // TODO: Make Condition non-pluggable
        @Override  
            .metadata(onDiskState.metadata)
                } else {
            return new NodeEnvironment.NodePath(path);
        }
        @SuppressWarnings("unchecked")
    public static PersistedClusterStateService createPersistedClusterStateService(Settings settings, Path[] dataPaths) throws IOException {  
    static final String NO_NODE_METADATA_FOUND_MSG = "no node meta data is found, node has not been started yet?";
import org.opensearch.common.settings.Settings;  
    }
 */
        private final Map<String, Object> contents;
            return name;
    }
 *  
     *  
 * specific language governing permissions and limitations
        throws IOException, UserException;
/*  
            if (Metadata.Custom.class.isAssignableFrom(categoryClass)) {  
import joptsimple.OptionSet;
 * the Apache License, Version 2.0 (the "License"); you may
    }
                    return (T) new UnknownMetadataCustom(name, parser.mapOrdered());  
            throw new UnsupportedOperationException("Unexpected category class " + categoryClass + " for name " + name);  
import org.opensearch.cluster.metadata.Metadata;
    }
     * @param dataPaths the paths of the node to process  
            this.name = name;
            throw new OpenSearchException("Unable to investigate path [" + path + "]", e);  
            return builder.field(name, value);
            nodeId,  
     * @param terminal the terminal to print to
 * compatible open source license.
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(dataPaths);
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.cluster.coordination;
                if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
        nodeOrdinalOption = parser.accepts("ordinal", "Optional node ordinal, 0 if not specified").withRequiredArg().ofType(Integer.class);  
        @Override
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            throw new OpenSearchException(CS_MISSING_MSG);  
     *
import org.opensearch.core.xcontent.XContentParser;
            }
        return parser;  
        );
                }
 * GitHub history for details.
            return EnumSet.of(Metadata.XContentContext.API, Metadata.XContentContext.GATEWAY);
        }  
        }
        public void writeTo(StreamOutput out) throws IOException {
    protected void confirm(Terminal terminal, String msg) {
                }  
    }
        }
/*
import java.util.EnumSet;  
            return name;  
            nodeOrdinal = 0;  
        }
import java.nio.file.Files;  
            }  
        if (nodeOrdinal == null) {
        @Override  
import org.opensearch.cli.UserException;
        public Diff<Metadata.Custom> diff(Metadata.Custom previousState) {  
 * Main set of node commands
        public UnknownMetadataCustom(String name, Map<String, Object> contents) {
        } catch (IOException e) {
import org.opensearch.env.Environment;  
import java.util.Map;
    /**  
import org.opensearch.cluster.Diff;
        @Override
                // The parsing for conditions is a bit weird as these represent JSON primitives (strings or numbers)
                    // therefor even OpenSearch node commands need to be able to parse it.
        private final String name;
    @Override  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        try (NodeEnvironment.NodeLock lock = new NodeEnvironment.NodeLock(nodeOrdinal, logger, env, Files::exists)) {
        public <T, C> T parseNamedObject(Class<T> categoryClass, String name, XContentParser parser, C context) throws IOException {
     * @opensearch.internal
    public static final NamedXContentRegistry namedXContentRegistry = new NamedXContentRegistry(ClusterModule.getNamedXWriteables()) {  
import joptsimple.OptionParser;  
    }
        @Override  
import joptsimple.OptionSpec;
        }
    };
    /**  
    static final String NO_NODE_FOLDER_FOUND_MSG = "no node folder is found in data folder(s), node has not been started yet?";
                parser.nextToken();
import org.opensearch.cluster.ClusterModule;
 * You may obtain a copy of the License at  
            throw new UnsupportedOperationException();  
import org.opensearch.common.collect.Tuple;
    protected abstract void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment env)
                return (T) new UnknownCondition(name, parser.objectText());  
        public String getWriteableName() {  
/*
    /**
                    throw new UnsupportedOperationException("Unexpected token for Condition: " + parser.currentToken());
    }  
        } catch (LockObtainFailedException e) {
import org.opensearch.OpenSearchException;  
 * The OpenSearch Contributors require contributions made to  
        }
                }
            namedXContentRegistry,
    }  
            final Path[] dataPaths = Arrays.stream(lock.getNodePaths()).filter(Objects::nonNull).map(p -> p.path).toArray(Path[]::new);  
import org.opensearch.common.util.BigArrays;
            throw new UnsupportedOperationException();
        @Override  
     * @param options the command line options
     * @param terminal the terminal to use for messages
 */
    private static final Logger logger = LogManager.getLogger(OpenSearchNodeCommand.class);
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
    protected void processNodePaths(Terminal terminal, OptionSet options, Environment env) throws IOException, UserException {
        @Override
            return builder.mapContents(contents);  
        String text = terminal.readText("Confirm [y/N] ");  
    protected boolean validateBeforeLock(Terminal terminal, Environment env) {
 * Licensed to Elasticsearch under one or more contributor  
            () -> 0L
        }  
     */  
import org.opensearch.common.cli.EnvironmentAwareCommand;  
        final PersistedClusterStateService.OnDiskState bestOnDiskState = psf.loadBestOnDiskState();
     * Validate that the command can run before taking any locks.  
    // package-private for testing
 */
            throw new UnsupportedOperationException();
            assert false;
        terminal.println(msg);
        terminal.println(STOP_WARNING_MSG);
    protected static final String CS_MISSING_MSG = "cluster state is empty, cluster has never been bootstrapped?";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 *
 * under the License.  
        if (bestOnDiskState.empty()) {
    protected static final String DELIMITER = "------------------------------------------------------------------------\n";
            }
        }
    /**
    public static Tuple<Long, ClusterState> loadTermAndClusterState(PersistedClusterStateService psf, Environment env) throws IOException {  
        @Override
 * not use this file except in compliance with the License.
    }
import java.io.IOException;
        }
                throw new OpenSearchException(NO_NODE_FOLDER_FOUND_MSG);
import java.util.Arrays;
        }  
            processNodePaths(terminal, options, env);
        }
        return true;  
                    // TODO: Try to parse other named objects (e.g. stored scripts, ingest pipelines) that are part of core es as well?  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
            if (Condition.class.isAssignableFrom(categoryClass)) {  
        return Tuple.tuple(bestOnDiskState.currentTerm, clusterState(env, bestOnDiskState));
import org.opensearch.env.NodeEnvironment;
     * Process the paths. Locks for the paths is held during this method invocation.
    final OptionSpec<Integer> nodeOrdinalOption;  
        return ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(environment.settings()))  
 * license agreements. See the NOTICE file distributed with
     */
    public final void execute(Terminal terminal, OptionSet options, Environment env) throws Exception {
import java.nio.file.Path;
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.logging.log4j.LogManager;  
            .build();  
        public void writeTo(StreamOutput out) throws IOException {
            processNodePaths(terminal, dataPaths, nodeOrdinal, options, env);
            throw new OpenSearchException(NO_NODE_METADATA_FOUND_MSG);  
 */  
     */
     */
        }
                assert parser.currentToken() == XContentParser.Token.FIELD_NAME : parser.currentToken();  
        }
                    // Note that supporting PersistentTasksCustomMetadata is trickier, because PersistentTaskParams is a named object too.
