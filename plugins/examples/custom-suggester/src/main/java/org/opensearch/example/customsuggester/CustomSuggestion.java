        }
    }
                this.dummy = dummy;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            public String getDummy() {
     * @param in Input to read the value from
        @Override
        dummy = in.readString();
    }
        protected Option newOption(StreamInput in) throws IOException {
             * the value of dummy will always be the same, so this just tests that we can merge options with custom fields
    @Override
             * Instantiate an Option from XContent.
                super(in);
        }
    protected Entry newEntry(StreamInput in) throws IOException {
        public String getDummy() {
     * @throws IOException on deserialization error.
                builder.field(DUMMY.getPreferredName(), dummy);
         */
                PARSER.declareString(constructorArg(), DUMMY);
    /**
 * GitHub history for details.
        }
             */
         * @param text the text originating from the suggest text.
         */
 *    http://www.apache.org/licenses/LICENSE-2.0
     * This class is now serialized as a NamedWriteable and this value only remains for backwards compatibility
        }
        this.dummy = dummy;
         * Instantiate this object from a stream.
        return new Entry(in);
            }
        }
        /**
                PARSER.declareString(constructorArg(), TEXT);
                super.mergeInto(otherOption);
        public Entry(Text text, int offset, int length, String dummy) {
        super(name, size);
            return PARSER.apply(parser, null);
                super.writeTo(out);
}
             * @param parser The XContent parser to use
             * Instantiate this object from a stream.
     * @param dummy The added custom suggestion type.
import org.opensearch.core.xcontent.ConstructingObjectParser;
                dummy = ((Option) otherOption).getDummy();
             * @throws IOException on failure to read the value.
            @Override
        /**
            static {
    public String getWriteableName() {
        return CustomSuggestionBuilder.SUGGESTION_NAME;
        }
            builder.field(DUMMY.getPreferredName(), getDummy());
        parseEntries(parser, suggestion, Entry::fromXContent);
    /**
                PARSER.declareFloat(constructorArg(), SCORE);
    /**
     * Instantiate a CustomSuggestion from XContent.
    }
         * @return the Suggestion Entry
             * @param in Input to read the value from
             * @param dummy The value of the dummy field.
                super(text, score);
     * @param parser The XContent parser to use
     * @param size The suggested term size specified in request, only used for merging shard responses.
             * @param text The option text.
                args -> {
import org.opensearch.core.common.io.stream.StreamOutput;
         */
        /**
 */
     * to add a custom field. But we can still use a custom field internally and use it to define a Suggestion's behavior
         * Create a Suggestion Entry from XContent
    public String getDummy() {
 */
    public static class Entry extends Suggest.Suggestion.Entry<CustomSuggestion.Entry.Option> {
            }
     * An integer representing the type of the suggestion formerly used for internal serialization over the network.
    public int getWriteableType() {
            /**
 * software distributed under the License is distributed on an
    public static final int TYPE = 999;
        @Override
 * this work for additional information regarding copyright
            }
        private static final ObjectParser<Entry, Void> PARSER = new ObjectParser<>("CustomSuggestionEntryParser", true, Entry::new);
 */
            private static final ConstructingObjectParser<Option, Void> PARSER = new ConstructingObjectParser<>(
         */
     */
            builder = super.toXContent(builder, params);
             */
         */
    @Override
            return dummy;
         * @param in Input to read the value from
             */
            PARSER.declareString((entry, dummy) -> entry.dummy = dummy, DUMMY);
            public Option(StreamInput in) throws IOException {
        public Entry(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            super(text, offset, length);
     *
            @Override
     */
/*
import org.opensearch.core.xcontent.XContentParser;
         *
 * You may obtain a copy of the License at
        public void writeTo(StreamOutput out) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        }
    }
    }
 *
        super(in);
    public static final ParseField DUMMY = new ParseField("dummy");
                "CustomSuggestionObjectParser",
            /**
            }
            return builder;
        out.writeString(dummy);
     *
             * A meaningless value used to test that plugin suggesters can add fields to their options
     * @param name Tne name of the suggestion
            super.writeTo(out);
     */
/*
             * Instantiate this object from the specified text, score, and dummy field
 * The OpenSearch Contributors require contributions made to
            protected void mergeInto(Suggest.Suggestion.Entry.Option otherOption) {
            out.writeString(dummy);
/*
         * Instantiate this object.
    }
     * A meaningless value used to test that plugin suggesters can add fields to their Suggestion types.
    }
            this.dummy = dummy;
                return builder;
public class CustomSuggestion extends Suggest.Suggestion<CustomSuggestion.Entry> {
        /**
        return dummy;
         * @param offset the start offset for this entry in the suggest text.
     * Represents a part from the suggest text with suggested options.
                    String dummy = (String) args[2];
            declareCommonFields(PARSER);
         * Instantiate this object from the given text, offset, length, and additional dummy field.
            private String dummy;
         * the value of dummy will always be the same, so this just tests that we can merge entries with custom fields
                return dummy;
             * The bug is: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8242214
import org.opensearch.core.ParseField;
 * not use this file except in compliance with the License.
        static {
            public Option(Text text, float score, String dummy) {
    public CustomSuggestion(StreamInput in) throws IOException {
        private String dummy;
 * specific language governing permissions and limitations
         *
    @Override
 * license agreements. See the NOTICE file distributed with
         * An Entry Option to use with a Suggestion.
            /**
    }
        }
         */
     * Instantiate this object with the specified name, size, and value for the configured field.
     */
    /**
         * @param length the length for this entry in the suggest text.
 * ownership. Elasticsearch licenses this file to you under
            public static Option fromXContent(XContentParser parser) {
    }
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * This can't be serialized to xcontent because Suggestions appear in xcontent as an array of entries, so there is no place
 * Licensed to Elasticsearch under one or more contributor
     */
         *
            dummy = ((Entry) otherEntry).getDummy();
             *
            }
                    float score = (float) args[1];
             *
        }
        /**
                true,
            super(in);
            /**
    /**
import org.opensearch.core.common.text.Text;
         * @throws IOException on failure to read the value.
     *
         *
         * @param dummy the additional custom field.
            dummy = in.readString();
 * this file be licensed under the Apache-2.0 license or a
        return suggestion;
     * A meaningless value used to test that plugin suggesters can add fields to their Suggestion types
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
            }
import org.opensearch.core.common.io.stream.StreamInput;
     *
         * @param parser The parser to use
 *
     * Instantiate this object from a stream.
             * @param score The option score.
                    return new Option(text, score, dummy);
                    Text text = new Text((String) args[0]);
         */
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
     */
            PARSER.declareObjectArray((e, o) -> e.addOptions(o), (p, c) -> Option.fromXContent(p), new ParseField(OPTIONS));
    @Override
            }
     * @return A new CustomSuggestion instance for the specified name.
        return TYPE;
    public static CustomSuggestion fromXContent(XContentParser parser, String name) throws IOException {
package org.opensearch.example.customsuggester;
     * @return the value.
 * The suggestion responses corresponding with the suggestions in the request.
 *
     * @param name The name of the suggestion as is defined in the request.
        CustomSuggestion suggestion = new CustomSuggestion(name, -1, null);
     * <p>
        public static class Option extends Suggest.Suggestion.Entry.Option {
            );
        }
             * The use of a lambda expression instead of the method reference Entry::addOptions is a workaround for a JDK 14 compiler bug.
 * Unless required by applicable law or agreed to in writing,
                out.writeString(dummy);
            return new Option(in);
             */
            /*
             */
import org.opensearch.core.xcontent.ObjectParser;
        @Override
 */
    /**
         * Meaningless field used to test that plugin suggesters can add fields to their entries
                builder = super.toXContent(builder, params);
         * @InheritDoc
        public Entry() {}
 * KIND, either express or implied.  See the License for the
        super.writeTo(out);
import org.opensearch.search.suggest.Suggest;
/**
        @Override
                return PARSER.apply(parser, null);
        public static Entry fromXContent(XContentParser parser) {
        /*
    public void writeTo(StreamOutput out) throws IOException {
             *
    public CustomSuggestion(String name, int size, String dummy) {
     */
             */
                dummy = in.readString();
        protected void merge(Suggest.Suggestion.Entry<Option> otherEntry) {
         * @return the dummy field value
 * under the License.
     * @throws IOException on failure to read the value.
         *
            }
    private String dummy;
        /**
    /**
                }
            @Override
            public void writeTo(StreamOutput out) throws IOException {
            /*
