        public UnknownMetadataCustom(String name, Map<String, Object> contents) {
        @Override
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
        @Override
        terminal.println(Terminal.Verbosity.VERBOSE, "Obtaining lock for node");
import org.opensearch.env.NodeMetadata;
    }
    static final String NO_NODE_FOLDER_FOUND_MSG = "no node folder is found in data folder(s), node has not been started yet?";
        final NodeMetadata nodeMetadata = PersistedClusterStateService.nodeMetadata(dataPaths);
     */
    }
        if (text.equalsIgnoreCase("y") == false) {
 * not use this file except in compliance with the License.
     * @param options the command line options
    final OptionSpec<Integer> nodeOrdinalOption;
    protected abstract void processNodePaths(Terminal terminal, Path[] dataPaths, int nodeLockId, OptionSet options, Environment env)
        @Override
                // TODO: Make Condition non-pluggable
                    return super.parseNamedObject(categoryClass, name, parser, context);
     * @param terminal the terminal to use for messages
    }
 * software distributed under the License is distributed on an
     */
    }
        if (bestOnDiskState.empty()) {
 */
    /**
            assert false : "Unexpected category class " + categoryClass + " for name " + name;
            return new NodeEnvironment.NodePath(path);
                    throw new UnsupportedOperationException("Unexpected token for Condition: " + parser.currentToken());
    }
        if (nodeMetadata == null) {
            throw new UnsupportedOperationException();
        @Override
        }
                } else {
        private final String name;
        @Override
import org.opensearch.cluster.ClusterModule;
    private static final Logger logger = LogManager.getLogger(OpenSearchNodeCommand.class);
     *
                if (parser.currentToken().isValue() == false) {
 * this file be licensed under the Apache-2.0 license or a
        super(description);
        }
        }
        @Override
    public static ClusterState clusterState(Environment environment, PersistedClusterStateService.OnDiskState onDiskState) {
        public void writeTo(StreamOutput out) throws IOException {
        throws IOException, UserException;
        terminal.println(STOP_WARNING_MSG);
            throw new OpenSearchException(ABORTED_BY_USER_MSG);
                    throw new UnsupportedOperationException("Unexpected token for Condition: " + parser.currentToken());
 */
import org.opensearch.cli.UserException;
import joptsimple.OptionParser;
            if (Condition.class.isAssignableFrom(categoryClass)) {
 * KIND, either express or implied.  See the License for the
import java.util.EnumSet;
            // Currently, two unknown top-level objects are present
            .version(onDiskState.lastAcceptedVersion)
            processNodePaths(terminal, options, env);
            dataPaths,
    public static final NamedXContentRegistry namedXContentRegistry = new NamedXContentRegistry(ClusterModule.getNamedXWriteables()) {
 * GitHub history for details.
import org.opensearch.cluster.Diff;
                    // TODO: Try to parse other named objects (e.g. stored scripts, ingest pipelines) that are part of core es as well?
    public static Tuple<Long, ClusterState> loadTermAndClusterState(PersistedClusterStateService psf, Environment env) throws IOException {
     */
    /**
import java.io.IOException;
            throw new OpenSearchException(NO_NODE_METADATA_FOUND_MSG);
    }
import org.opensearch.common.settings.ClusterSettings;
        return Tuple.tuple(bestOnDiskState.currentTerm, clusterState(env, bestOnDiskState));
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.nio.file.Files;
        }
    }
                // The parsing for conditions is a bit weird as these represent JSON primitives (strings or numbers)
 *
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.common.collect.Tuple;
 *
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.env.NodeEnvironment;
 * @opensearch.internal
                }
import org.opensearch.OpenSearchException;
        }
import org.opensearch.cluster.metadata.Metadata;
                }
                    // therefor even OpenSearch node commands need to be able to parse it.
import org.apache.logging.log4j.LogManager;
import org.opensearch.cli.Terminal;
            if (Metadata.Custom.class.isAssignableFrom(categoryClass)) {
    public static PersistedClusterStateService createPersistedClusterStateService(Settings settings, Path[] dataPaths) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.logging.log4j.Logger;
            return name;
     * @param env the env to validate.
            this.contents = contents;
        } catch (LockObtainFailedException e) {
        final PersistedClusterStateService.OnDiskState bestOnDiskState = psf.loadBestOnDiskState();
            throw new UnsupportedOperationException("Unexpected category class " + categoryClass + " for name " + name);
            return builder.field(name, value);
            BigArrays.NON_RECYCLING_INSTANCE,
            return name;
import org.opensearch.gateway.PersistedClusterStateService;
            }
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.cluster.metadata.DataStreamMetadata;
            throw new OpenSearchException("Unable to investigate path [" + path + "]", e);
        }
            throw new UnsupportedOperationException();
            assert false;
     * Validate that the command can run before taking any locks.
    static final String STOP_WARNING_MSG = DELIMITER + "\n" + "    WARNING: OpenSearch MUST be stopped before running this tool." + "\n";
            assert false;
/**
    }
            assert false;
import joptsimple.OptionSpec;
import joptsimple.OptionSet;
    /**
        }
     * @opensearch.internal
    protected void confirm(Terminal terminal, String msg) {
            this.value = value;
        @Override
        @Override
     */
        nodeOrdinalOption = parser.accepts("ordinal", "Optional node ordinal, 0 if not specified").withRequiredArg().ofType(Integer.class);
        try (NodeEnvironment.NodeLock lock = new NodeEnvironment.NodeLock(nodeOrdinal, logger, env, Files::exists)) {
                    // Note that supporting PersistentTasksCustomMetadata is trickier, because PersistentTaskParams is a named object too.
/*
        }
import java.nio.file.Path;
        if (validateBeforeLock(terminal, env)) {
    static final String NO_NODE_METADATA_FOUND_MSG = "no node meta data is found, node has not been started yet?";
/*
    /**
import org.opensearch.cluster.ClusterName;
                if (parser.currentToken() != XContentParser.Token.FIELD_NAME) {
 *
    protected NodeEnvironment.NodePath[] toNodePaths(Path[] dataPaths) {
        public Version getMinimalSupportedVersion() {
 */
        }
        }
            nodeOrdinal = 0;
 * ownership. Elasticsearch licenses this file to you under
            throw new UnsupportedOperationException();
import org.opensearch.env.Environment;
        @SuppressWarnings("unchecked")
        }
    protected void processNodePaths(Terminal terminal, OptionSet options, Environment env) throws IOException, UserException {
            throw new OpenSearchException(CS_MISSING_MSG);
                throw new OpenSearchException(NO_NODE_FOLDER_FOUND_MSG);
        private final Map<String, Object> contents;
                assert parser.currentToken() == XContentParser.Token.FIELD_NAME : parser.currentToken();
        }
 *
                    // ComponentTemplateMetadata is used inside Metadata class for building the systemTemplatesLookup,
        public String getWriteableName() {
 * You may obtain a copy of the License at
                return (T) new UnknownCondition(name, parser.objectText());
import org.opensearch.action.admin.indices.rollover.Condition;
import org.opensearch.cluster.ClusterState;
    protected static final String FAILED_TO_OBTAIN_NODE_LOCK_MSG = "failed to lock node's directory, is OpenSearch still running?";
        Integer nodeOrdinal = nodeOrdinalOption.value(options);
 * license agreements. See the NOTICE file distributed with
     * @param dataPaths the paths of the node to process
 * compatible open source license.
    private static NodeEnvironment.NodePath createNodePath(Path path) {
 * Main set of node commands
        return ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(environment.settings()))
        if (nodeOrdinal == null) {
            throw new UnsupportedOperationException();
        @Override
    protected static final String DELIMITER = "------------------------------------------------------------------------\n";
            nodeId,
    public OpenSearchNodeCommand(String description) {
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        }
    @Override
     * An unknown condition.
            }
    protected static final String ABORTED_BY_USER_MSG = "aborted by user";
    }
                assert parser.currentToken().isValue() : parser.currentToken();
        }
        @Override
            if (dataPaths.length == 0) {
    protected static final String CS_MISSING_MSG = "cluster state is empty, cluster has never been bootstrapped?";
            super(name);
import org.opensearch.Version;
     * Process the paths. Locks for the paths is held during this method invocation.
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @opensearch.internal
            final Path[] dataPaths = Arrays.stream(lock.getNodePaths()).filter(Objects::nonNull).map(p -> p.path).toArray(Path[]::new);
    public final void execute(Terminal terminal, OptionSet options, Environment env) throws Exception {
            }
     * @return true to continue, false to stop (must print message in validate).
     * @param env the env of the node to process
    OptionParser getParser() {
            () -> 0L
        } catch (IOException e) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        String text = terminal.readText("Confirm [y/N] ");
        public Diff<Metadata.Custom> diff(Metadata.Custom previousState) {
        public EnumSet<Metadata.XContentContext> context() {
        public <T, C> T parseNamedObject(Class<T> categoryClass, String name, XContentParser parser, C context) throws IOException {
            throw new OpenSearchException(FAILED_TO_OBTAIN_NODE_LOCK_MSG, e);
        terminal.println(msg);
import org.opensearch.common.util.BigArrays;
            this.name = name;
 * under the License.
        return parser;
        );
            processNodePaths(terminal, dataPaths, nodeOrdinal, options, env);
    }
            .metadata(onDiskState.metadata)
            return EnumSet.of(Metadata.XContentContext.API, Metadata.XContentContext.GATEWAY);
            .build();
import org.opensearch.common.settings.Settings;
    };
            assert false;
        public UnknownCondition(String name, Object value) {
        @Override
        return true;
        }
    }
    // fake the registry here, as command-line tools are not loading plugins, and ensure that it preserves the parsed XContent
 * The OpenSearch Contributors require contributions made to
public abstract class OpenSearchNodeCommand extends EnvironmentAwareCommand {
                    // DataStreamMetadata is used inside Metadata class for validation purposes and building the indicesLookup,
import org.opensearch.common.cli.EnvironmentAwareCommand;
        public void writeTo(StreamOutput out) throws IOException {
    }
                    return (T) new UnknownMetadataCustom(name, parser.mapOrdered());
     * Custom unknown metadata.
                }
     * @param terminal the terminal to print to
            namedXContentRegistry,
            return builder.mapContents(contents);
        }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.apache.lucene.store.LockObtainFailedException;
            throw new UnsupportedOperationException();
        String nodeId = nodeMetadata.nodeId();
/*
        public Result evaluate(Stats stats) {
 * Licensed to Elasticsearch under one or more contributor
    // package-private for testing
 * Modifications Copyright OpenSearch Contributors. See
        }
        return Arrays.stream(dataPaths).map(OpenSearchNodeCommand::createNodePath).toArray(NodeEnvironment.NodePath[]::new);
package org.opensearch.cluster.coordination;
                parser.nextToken();
    protected boolean validateBeforeLock(Terminal terminal, Environment env) {
 * specific language governing permissions and limitations
import org.opensearch.cluster.metadata.ComponentTemplateMetadata;
}
import java.util.Objects;
        }
        }
        }
    public static class UnknownCondition extends Condition<Object> {
        try {
        public String getWriteableName() {
import java.util.Arrays;
                if (DataStreamMetadata.TYPE.equals(name) || ComponentTemplateMetadata.TYPE.equals(name)) {
            assert false;
        return new PersistedClusterStateService(
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
     *
    public static class UnknownMetadataCustom implements Metadata.Custom {
