            return false;
    public static AllocationCommands fromXContent(XContentParser parser) throws IOException {
        return Objects.equals(commands, other.commands);
                        token
        XContentParser.Token token = parser.currentToken();
 * Unless required by applicable law or agreed to in writing,
        } else if (token == XContentParser.Token.START_ARRAY) {
     * @param out {@link StreamOutput} to write the commands to
        }
import org.opensearch.cluster.routing.allocation.RoutingExplanations;
 * this file be licensed under the Apache-2.0 license or a
            explanations.add(command.execute(allocation, explain));
     *         "commands" : [
            builder.startObject();
                    throw new OpenSearchParseException(
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamOutput;
                String commandName = parser.currentName();
    /**
    }
 * KIND, either express or implied.  See the License for the
import java.util.List;
        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
 *
        AllocationCommands commands = new AllocationCommands();
                    );
        return this;
        return builder;
     * @return {@link AllocationCommands} read
    @Override
package org.opensearch.cluster.routing.allocation.command;
import java.io.IOException;
import org.opensearch.core.xcontent.ToXContentFragment;
            builder.field(command.name(), command);
     * <pre>
     */
        }
@PublicApi(since = "1.0.0")
 * ownership. Elasticsearch licenses this file to you under
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
     * @param allocation {@link RoutingAllocation} to apply this command to
    public boolean equals(Object obj) {
        int size = in.readVInt();
 * SPDX-License-Identifier: Apache-2.0
    }
     *     }
        return this.commands;
import org.opensearch.core.common.Strings;
     * @param commands Array of commands to add to this instance
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
     * @param commands Commands to write
 * {@link AllocationCommand} implementations
    public AllocationCommands(AllocationCommand... commands) {
 * Licensed to Elasticsearch under one or more contributor
            this.commands.addAll(Arrays.asList(commands));
    public static AllocationCommands readFrom(StreamInput in) throws IOException {
        for (AllocationCommand command : commands) {
            token = parser.nextToken();
            // ok...
        // Override equals and hashCode for testing
                // move to the command name
        }
import org.opensearch.OpenSearchException;
                throw new OpenSearchParseException("allocation command is malformed, got [{}] instead", token);
     * @throws IOException if something happens during write
    @Override
import java.util.ArrayList;
    }
     *
                commands.add(parser.namedObject(AllocationCommand.class, commandName, null));
     * @throws IOException if something bad happens while reading the stream
     * @return {@link AllocationCommands} with the given commands added
    /**
        }
 * under the License.
     * @return {@link List} of commands
 * not use this file except in compliance with the License.
    /**
            } else {
        // Override equals and hashCode for testing
     * Get the commands wrapped by this instance
                throw new OpenSearchParseException("expected field name to be named [commands], got [{}] instead", parser.currentName());
public class AllocationCommands implements ToXContentFragment {
     * @throws IOException if something happens during read
/*
    }
 * software distributed under the License is distributed on an
     * @throws OpenSearchException if something happens during execution
    /**
    public int hashCode() {
            }
        return explanations;
        }
    public RoutingExplanations execute(RoutingAllocation allocation, boolean explain) {
    }
        for (AllocationCommand command : commands) {
            this.commands.addAll(Arrays.asList(commands));
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
     */
     * @return {@link AllocationCommands} read
     * @param in {@link StreamInput} to read from
 *
                throw new OpenSearchParseException("commands should follow with an array element");
     *
            commands.add(in.readNamedWriteable(AllocationCommand.class));
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;
     *
    /**
 */
import java.util.Objects;
     */
     * Creates a new set of {@link AllocationCommands}
     * Executes all wrapped commands on a given {@link RoutingAllocation}
    public static void writeTo(AllocationCommands commands, StreamOutput out) throws IOException {
 * specific language governing permissions and limitations
    @Override
/**
        if (commands != null) {
            if (token != XContentParser.Token.START_ARRAY) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.OpenSearchParseException;
     * @param parser {@link XContentParser} to read the commands from
     *         ]
        }
     */
 * A simple {@link AllocationCommand} composite managing several
        AllocationCommands commands = new AllocationCommands();
        }
     *     {
import java.util.Arrays;
    /**
     * @param commands {@link AllocationCommand}s that are wrapped by this instance
        }
    private final List<AllocationCommand> commands = new ArrayList<>();
     * </pre>
        return commands;
            if (!parser.currentName().equals("commands")) {
 * @opensearch.api
        AllocationCommands other = (AllocationCommands) obj;
 *
        } else {
            if (token == XContentParser.Token.START_OBJECT) {
                        "allocation command is malformed, done parsing a command," + " but didn't get END_OBJECT, got [{}] instead",
     *              {"allocate" : {"index" : "test", "shard" : 0, "node" : "test"}}
    @Override
                token = parser.nextToken();
}
        if (token == XContentParser.Token.FIELD_NAME) {
        return commands;
        for (int i = 0; i < size; i++) {
            out.writeNamedWriteable(command);
import org.opensearch.core.xcontent.XContentParser;
 * You may obtain a copy of the License at
        }
            throw new OpenSearchParseException("expected either field name [commands], or start array, got [{}] instead", token);
        builder.endArray();
        if (obj == null || getClass() != obj.getClass()) {
    }
     * Reads {@link AllocationCommands} from a {@link XContentParser}
     */
 * this work for additional information regarding copyright
                if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
                token = parser.nextToken();
                }
        builder.startArray("commands");
 * compatible open source license.
     */
 * The OpenSearch Contributors require contributions made to
        if (commands != null) {
        RoutingExplanations explanations = new RoutingExplanations();
    public List<AllocationCommand> commands() {
import org.opensearch.core.xcontent.XContentBuilder;
    }
                // move to the end object one
            }
     * Reads a {@link AllocationCommands} from a {@link StreamInput}
    }
    }
    /**
/*
    public AllocationCommands add(AllocationCommand... commands) {
            throw new OpenSearchParseException("No commands");
        if (token == null) {
     * Adds a set of commands to this collection
 * GitHub history for details.
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.endObject();
    public String toString() {
 *
    }
     * Writes {@link AllocationCommands} to a {@link StreamOutput}
        }
    }
        for (AllocationCommand command : commands.commands) {
        out.writeVInt(commands.commands.size());
import org.opensearch.core.common.io.stream.StreamInput;
 */
     */
        return Objects.hashCode(commands);
/*
