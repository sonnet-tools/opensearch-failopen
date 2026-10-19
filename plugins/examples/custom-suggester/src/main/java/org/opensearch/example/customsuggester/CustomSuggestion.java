             * @param dummy The value of the dummy field.
    /**  
     */  
        return new Entry(in);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public static class Option extends Suggest.Suggestion.Entry.Option {  
            }  
            @Override
         * @InheritDoc  
         */
            /**
        }
         * @param parser The parser to use
            dummy = in.readString();
 */  
import org.opensearch.core.common.io.stream.StreamOutput;  
/*
            builder = super.toXContent(builder, params);  
/*  
     * <p>
     *
    }
            @Override  
         * Instantiate this object.  
        public Entry() {}
            private String dummy;
            /*  
         * @param dummy the additional custom field.
     * @param in Input to read the value from  
        @Override
    public CustomSuggestion(StreamInput in) throws IOException {  
        /**
            @Override  
    }
     *
         */
     *
     * @param parser The XContent parser to use
         * @param text the text originating from the suggest text.
            private static final ConstructingObjectParser<Option, Void> PARSER = new ConstructingObjectParser<>(
         * Instantiate this object from the given text, offset, length, and additional dummy field.
                builder.field(DUMMY.getPreferredName(), dummy);  
        dummy = in.readString();
        @Override
 * Modifications Copyright OpenSearch Contributors. See
 *
                }
        public static Entry fromXContent(XContentParser parser) {
 *
     * Represents a part from the suggest text with suggested options.
            }
    /**
            /*
/**  
         * @return the Suggestion Entry  
             * Instantiate this object from the specified text, score, and dummy field
                "CustomSuggestionObjectParser",  
        return CustomSuggestionBuilder.SUGGESTION_NAME;
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
            public Option(Text text, float score, String dummy) {
    @Override
        CustomSuggestion suggestion = new CustomSuggestion(name, -1, null);
                true,
             */
         * Instantiate this object from a stream.  
        parseEntries(parser, suggestion, Entry::fromXContent);  
                dummy = in.readString();
    public String getWriteableName() {  
        static {
        }
        /**
             */
        super(name, size);
 * under the License.  
                super(text, score);
        protected Option newOption(StreamInput in) throws IOException {
     * @throws IOException on deserialization error.
     * @throws IOException on failure to read the value.
                builder = super.toXContent(builder, params);
import org.opensearch.search.suggest.Suggest;  
        @Override
            }
 * GitHub history for details.
    private String dummy;
     * Instantiate this object with the specified name, size, and value for the configured field.
             */
            }  
            /**  
package org.opensearch.example.customsuggester;
                return dummy;  
     * This can't be serialized to xcontent because Suggestions appear in xcontent as an array of entries, so there is no place  
                this.dummy = dummy;  
            super.writeTo(out);  
         * the value of dummy will always be the same, so this just tests that we can merge entries with custom fields
    /**
            super(in);  
 * this work for additional information regarding copyright
                return PARSER.apply(parser, null);
     */
import org.opensearch.core.common.text.Text;
        /**
import org.opensearch.core.xcontent.ConstructingObjectParser;
         */
     *
    protected Entry newEntry(StreamInput in) throws IOException {
        return suggestion;
     * This class is now serialized as a NamedWriteable and this value only remains for backwards compatibility
        this.dummy = dummy;  
             * A meaningless value used to test that plugin suggesters can add fields to their options  
         * @throws IOException on failure to read the value.  
    @Override
                super.writeTo(out);
             * @param score The option score.
    }  
/*  
        public Entry(Text text, int offset, int length, String dummy) {  
         */
        public void writeTo(StreamOutput out) throws IOException {
     */
    /**  
                    String dummy = (String) args[2];
 * software distributed under the License is distributed on an
            public Option(StreamInput in) throws IOException {  
import org.opensearch.core.xcontent.XContentParser;
        protected void merge(Suggest.Suggestion.Entry<Option> otherEntry) {  
         *
    public static final ParseField DUMMY = new ParseField("dummy");
                PARSER.declareString(constructorArg(), DUMMY);
            return dummy;
     * @param dummy The added custom suggestion type.
        private String dummy;  
    public static final int TYPE = 999;  
 */  
            public void writeTo(StreamOutput out) throws IOException {  
 * You may obtain a copy of the License at  
                return builder;
     * Instantiate this object from a stream.
                args -> {
            /**  
 * The OpenSearch Contributors require contributions made to  
            }
         * @param offset the start offset for this entry in the suggest text.
            protected void mergeInto(Suggest.Suggestion.Entry.Option otherOption) {
         *  
     * to add a custom field. But we can still use a custom field internally and use it to define a Suggestion's behavior
import java.io.IOException;
    }
 * SPDX-License-Identifier: Apache-2.0
            PARSER.declareString((entry, dummy) -> entry.dummy = dummy, DUMMY);
    }
        }
        @Override
     */  
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
             * @param parser The XContent parser to use
        super(in);
             * Instantiate an Option from XContent.
        }  
             */
            return new Option(in);  
        out.writeString(dummy);
         */
 * Licensed to Elasticsearch under one or more contributor  
    }  
                out.writeString(dummy);
             */
                    return new Option(text, score, dummy);  
 * specific language governing permissions and limitations
     * @param name Tne name of the suggestion  
            builder.field(DUMMY.getPreferredName(), getDummy());
                dummy = ((Option) otherOption).getDummy();  
            }
            static {
            out.writeString(dummy);
 *  
        /**
     */
        public String getDummy() {  
        }
     * A meaningless value used to test that plugin suggesters can add fields to their Suggestion types
         */
        /**  
    @Override  
     */  
    /**
import org.opensearch.core.xcontent.ObjectParser;  
 * compatible open source license.
            }
     * Instantiate a CustomSuggestion from XContent.  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
         *  
            );
        super.writeTo(out);
    }  
            this.dummy = dummy;
            super(text, offset, length);
            dummy = ((Entry) otherEntry).getDummy();
}
         * @param length the length for this entry in the suggest text.  
             * The use of a lambda expression instead of the method reference Entry::addOptions is a workaround for a JDK 14 compiler bug.  
            }
         *
                super.mergeInto(otherOption);
 */
     * @param size The suggested term size specified in request, only used for merging shard responses.
        return dummy;  
    public static CustomSuggestion fromXContent(XContentParser parser, String name) throws IOException {
        private static final ObjectParser<Entry, Void> PARSER = new ObjectParser<>("CustomSuggestionEntryParser", true, Entry::new);  
                PARSER.declareFloat(constructorArg(), SCORE);  
             *
    }
        }
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.ParseField;
            PARSER.declareObjectArray((e, o) -> e.addOptions(o), (p, c) -> Option.fromXContent(p), new ParseField(OPTIONS));  
        }  
     * @return A new CustomSuggestion instance for the specified name.
     * @param name The name of the suggestion as is defined in the request.  
 * not use this file except in compliance with the License.
             * the value of dummy will always be the same, so this just tests that we can merge options with custom fields
 * The suggestion responses corresponding with the suggestions in the request.
 */
        }
 * Unless required by applicable law or agreed to in writing,
     */
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
public class CustomSuggestion extends Suggest.Suggestion<CustomSuggestion.Entry> {  
        /*  
            public static Option fromXContent(XContentParser parser) {  
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
     * A meaningless value used to test that plugin suggesters can add fields to their Suggestion types.  
    public String getDummy() {
             * @param in Input to read the value from  
                PARSER.declareString(constructorArg(), TEXT);
                    float score = (float) args[1];
        }  
             * The bug is: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8242214
        public Entry(StreamInput in) throws IOException {
    public CustomSuggestion(String name, int size, String dummy) {
    @Override
    /**  
         * Create a Suggestion Entry from XContent  
         *
                    Text text = new Text((String) args[0]);  
             * @throws IOException on failure to read the value.
    public void writeTo(StreamOutput out) throws IOException {  
             *
             *  
     * @return the value.  
         * @return the dummy field value
         */
         * Meaningless field used to test that plugin suggesters can add fields to their entries
     * An integer representing the type of the suggestion formerly used for internal serialization over the network.  
    public static class Entry extends Suggest.Suggestion.Entry<CustomSuggestion.Entry.Option> {
        /**
             */  
            public String getDummy() {
         * @param in Input to read the value from
        return TYPE;  
             * Instantiate this object from a stream.
            return PARSER.apply(parser, null);  
            /**
             * @param text The option text.  
 * the Apache License, Version 2.0 (the "License"); you may
        }
            declareCommonFields(PARSER);  
            return builder;
                super(in);
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public int getWriteableType() {
         * An Entry Option to use with a Suggestion.
