        if (token == XContentParser.Token.FIELD_NAME) {
                // move to the command name
        AllocationCommands other = (AllocationCommands) obj;
            }
    /**
    /**
     */
        AllocationCommands commands = new AllocationCommands();
package org.opensearch.cluster.routing.allocation.command;
     * Adds a set of commands to this collection  
 * Unless required by applicable law or agreed to in writing,
            this.commands.addAll(Arrays.asList(commands));  
     * @param commands Commands to write  
 * this file be licensed under the Apache-2.0 license or a
     *
        // Override equals and hashCode for testing
import org.opensearch.core.xcontent.MediaTypeRegistry;  
/**
     * <pre>
            return false;
        return Objects.hashCode(commands);  
    public String toString() {
        builder.startArray("commands");
import org.opensearch.core.xcontent.ToXContentFragment;
/*  
     *  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.OpenSearchException;
        if (commands != null) {  
        }  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
        return commands;  
     * </pre>
import org.opensearch.core.common.io.stream.StreamOutput;
        }  
                String commandName = parser.currentName();  
    /**
 * A simple {@link AllocationCommand} composite managing several  
     * Executes all wrapped commands on a given {@link RoutingAllocation}
        for (AllocationCommand command : commands.commands) {  
    /**  
            }
 * {@link AllocationCommand} implementations
        }
 *  
            commands.add(in.readNamedWriteable(AllocationCommand.class));
import org.opensearch.OpenSearchParseException;
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (token == XContentParser.Token.START_OBJECT) {  
    public List<AllocationCommand> commands() {  
        XContentParser.Token token = parser.currentToken();  
 * KIND, either express or implied.  See the License for the
                throw new OpenSearchParseException("expected field name to be named [commands], got [{}] instead", parser.currentName());  
    }  
        if (obj == null || getClass() != obj.getClass()) {
                token = parser.nextToken();
                token = parser.nextToken();
import org.opensearch.common.annotation.PublicApi;
import java.util.List;
        return Objects.equals(commands, other.commands);  
            throw new OpenSearchParseException("expected either field name [commands], or start array, got [{}] instead", token);  
     * @param commands {@link AllocationCommand}s that are wrapped by this instance  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
    public AllocationCommands(AllocationCommand... commands) {
        builder.endArray();
    /**  
    @Override  
     * @return {@link AllocationCommands} read  
    @Override
            }  
     * @throws IOException if something bad happens while reading the stream
 */  
    }  
            builder.field(command.name(), command);
                if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
    /**
     */  
     * @param in {@link StreamInput} to read from
     * Creates a new set of {@link AllocationCommands}
        AllocationCommands commands = new AllocationCommands();
        return builder;
    public static AllocationCommands fromXContent(XContentParser parser) throws IOException {  
        return explanations;
 * this work for additional information regarding copyright
        // Override equals and hashCode for testing
import org.opensearch.core.common.Strings;  
        }
            this.commands.addAll(Arrays.asList(commands));
 */
 * @opensearch.api  
        } else {
 *
     * Reads {@link AllocationCommands} from a {@link XContentParser}  
    public static void writeTo(AllocationCommands commands, StreamOutput out) throws IOException {
            out.writeNamedWriteable(command);
            if (!parser.currentName().equals("commands")) {
 * specific language governing permissions and limitations
     *     }  
            if (token != XContentParser.Token.START_ARRAY) {  
 *
        return commands;
        } else if (token == XContentParser.Token.START_ARRAY) {  
    public static AllocationCommands readFrom(StreamInput in) throws IOException {  
    @Override  
                throw new OpenSearchParseException("commands should follow with an array element");
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.ArrayList;  
        for (AllocationCommand command : commands) {
    }
     * @param commands Array of commands to add to this instance
    public boolean equals(Object obj) {  
            } else {
        }
        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
     * @param parser {@link XContentParser} to read the commands from
     * @return {@link List} of commands
                // move to the end object one  
                    );
     * @param out {@link StreamOutput} to write the commands to
                        token
     *         ]
    }  
        return this;
     */
     * @return {@link AllocationCommands} read
    public RoutingExplanations execute(RoutingAllocation allocation, boolean explain) {  
/*  
 * GitHub history for details.
                commands.add(parser.namedObject(AllocationCommand.class, commandName, null));
     * Get the commands wrapped by this instance  
        int size = in.readVInt();
import java.io.IOException;
        }
 * Licensed to Elasticsearch under one or more contributor  
            builder.endObject();
 * not use this file except in compliance with the License.
@PublicApi(since = "1.0.0")
 * ownership. Elasticsearch licenses this file to you under  
            token = parser.nextToken();
 * The OpenSearch Contributors require contributions made to  
     *
     * @return {@link AllocationCommands} with the given commands added
     * @throws IOException if something happens during write
        for (int i = 0; i < size; i++) {  
import org.opensearch.cluster.routing.allocation.RoutingExplanations;
            builder.startObject();  
 * license agreements. See the NOTICE file distributed with
                    throw new OpenSearchParseException(
}
        if (token == null) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import java.util.Arrays;
            explanations.add(command.execute(allocation, explain));  
        return this.commands;
     */
 *
     * @throws IOException if something happens during read
     * @throws OpenSearchException if something happens during execution
public class AllocationCommands implements ToXContentFragment {  
 * under the License.  
     * Reads a {@link AllocationCommands} from a {@link StreamInput}  
    }
        }  
        }
        RoutingExplanations explanations = new RoutingExplanations();
     *              {"allocate" : {"index" : "test", "shard" : 0, "node" : "test"}}
                }  
     *     {
    public AllocationCommands add(AllocationCommand... commands) {
/*
    public int hashCode() {
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        }
    }
    }  
                        "allocation command is malformed, done parsing a command," + " but didn't get END_OBJECT, got [{}] instead",  
     */
 */
        out.writeVInt(commands.commands.size());
     * @param allocation {@link RoutingAllocation} to apply this command to  
        for (AllocationCommand command : commands) {
    }
import java.util.Objects;  
     * Writes {@link AllocationCommands} to a {@link StreamOutput}
    @Override
            // ok...
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
 * compatible open source license.
    }  
    }  
     */  
 * Modifications Copyright OpenSearch Contributors. See
            throw new OpenSearchParseException("No commands");
     *         "commands" : [  
     */
        }
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                throw new OpenSearchParseException("allocation command is malformed, got [{}] instead", token);
import org.opensearch.core.common.io.stream.StreamInput;
    private final List<AllocationCommand> commands = new ArrayList<>();
    /**
        if (commands != null) {
    }  
