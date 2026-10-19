                transpositions
                checkPositions(fieldType);
        private final IntervalFilter filter;
        private static final ConstructingObjectParser<Fuzzy, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
        @Override
    public static class IntervalFilter implements ToXContentObject, Writeable {
        }
            if (useField != null) {  
 * compatible open source license.
                return source;
            }  
        }  
     */
            out.writeString(prefix);
    /**  
                fieldType = context.fieldMapper(useField);  
            return PARSER.apply(parser, null);  
            return fuzziness;
            IntervalsSource source = Intervals.or(sources.toArray(new IntervalsSource[0]));
import java.io.IOException;
import org.apache.lucene.queries.intervals.IntervalIterator;  
public abstract class IntervalsSourceProvider implements NamedWriteable, ToXContentFragment {
                case "not_overlapping":  
 * @opensearch.internal
        @Override
            builder.field("term", term);  
            this.type = "script";
            mode.writeTo(out);
            }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return PARSER.parse(parser, null);
                BytesRef normalizedTerm = analyzer.normalize(useField, pattern);
        @Override  
            if (this == o) return true;
            this.maxGaps = maxGaps;  
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                assert fieldType != null;
            out.writeString(query);
            out.writeString(pattern);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */  
        public Combine(StreamInput in) throws IOException {  
 * between different sub-sources; and {@link Disjunction}.  
        }
            if (useField != null) {  
            if (in.readBoolean()) {  
        }
        public int hashCode() {
            String analyzer = (String) args[1];
        @Override  
                intervalMode = ordered ? IntervalMode.ORDERED : IntervalMode.UNORDERED;  
            builder.field("query", query);
        public IntervalFilter(StreamInput in) throws IOException {  
            this.maxExpansions = in.readOptionalVInt();  
            builder.endObject();
                return filter.filter(source, ctx, fieldType);  
                builder.field("analyzer", analyzer);
                if (this.analyzer == null) {  
            Integer flagsValue = (Integer) args[2];
            this.pattern = pattern;
            }
            } else {
            Match match = (Match) o;
        }
            }
            }
            return subSources;
        if (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
            if (useField != null) {
    public abstract int hashCode();
                throw new IllegalArgumentException("Cannot create intervals over field [" + type.name() + "] with no positions indexed");  
        @Override  
        private final String useField;
        private final Script script;
        @Override
            this.pattern = pattern;
                source = Intervals.fixField(useField, fieldType.intervals(prefix, 0, IntervalMode.UNORDERED, analyzer, true));
            );
            this.maxExpansions = (maxExpansions != null && maxExpansions > 0) ? maxExpansions : null;
        @Override
                builder.field("filter", filter);  
            this.useField = in.readOptionalString();
            this.mode = IntervalMode.readFromStream(in);
            case "prefix":
                source = Intervals.fixField(useField, wildcardSource);
            return Objects.hash(pattern, analyzer, useField, maxExpansions);
        boolean isTranspositions() {
        public static Wildcard fromXContent(XContentParser parser) throws IOException {  
            String useField = (String) args[3];  
                128,
            if (filter != null) {
 * Built-in sources include {@link Match}, which analyzes a text string and converts it  
            PARSER.declareInt(optionalConstructorArg(), new ParseField("max_expansions"));
            return Objects.hash(prefix, analyzer, useField);
        public Wildcard(StreamInput in) throws IOException {
            }
            IntervalsSource source;
        }
            return builder.endObject();
        @Override
        public boolean equals(Object o) {
    private static IntervalsSourceProvider parseInnerIntervals(XContentParser parser) throws IOException {
            return source;  
                return new Regexp(pattern, DEFAULT_FLAGS_VALUE, useField, maxExpansions, caseInsensitive);  
            return NAME;  
        }
            super("FILTER(" + name + ")", in);  
        public Fuzzy(StreamInput in) throws IOException {
            if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("unchecked")
            PARSER.declareString(optionalConstructorArg(), new ParseField("analyzer"));
            fuzziness.writeTo(out);
            }  
        String getAnalyzer() {
            if (o == null || getClass() != o.getClass()) return false;
        }
                sources.add(provider.getSource(ctx, fieldType));  
            this.query = in.readString();
        }
            this.filter = null;  
                checkPositions(fieldType);  
            }
                intervalMode = ordered ? IntervalMode.ORDERED : IntervalMode.UNORDERED;
            }  
        private static final ConstructingObjectParser<Wildcard, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
                return Disjunction.fromXContent(parser);
            out.writeBoolean(caseInsensitive);  
        public void writeTo(StreamOutput out) throws IOException {  
        }
            builder.endObject();
            int max_gaps = (args[1] == null ? -1 : (Integer) args[1]);
        @Override  
            builder.field("mode", mode);
            return source;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }
                throw new ParsingException(parser.getTokenLocation(), "Expected [START_OBJECT] but got [" + parser.currentToken() + "]");  
            }
     */  
import org.apache.lucene.util.BytesRef;
            this.fuzziness = new Fuzziness(in);
                intervalMode = IntervalMode.fromString(mode);  
                return Prefix.fromXContent(parser);
        }
        @Override
     * Wildcard interval
                builder.field("use_field", useField);
            }
import org.opensearch.script.Script;  
import org.opensearch.core.common.io.stream.Writeable;  
            PARSER.declareBoolean(optionalConstructorArg(), new ParseField("transpositions"));
        String getUseField() {  
            this.script = null;  
            PARSER.declareInt(optionalConstructorArg(), new ParseField("max_expansions"));  
            this.filter = in.readOptionalWriteable(IntervalFilter::new);
        }
        @Override  
                builder.endObject();
            builder.endObject();
 *
            builder.field("prefix", prefix);
import org.opensearch.core.xcontent.ConstructingObjectParser;
                assert fieldType != null;
            this.type = in.readString();
    public static class Regexp extends IntervalsSourceProvider {
                IntervalsSource regexpSource = maxExpansions == null
                intervalMode = IntervalMode.UNORDERED;
            out.writeOptionalString(useField);
        return isp;  
                checkPositions(fieldType);
                fields.add(useField);
            this.maxGaps = maxGaps;
     *
        }
            this.subSources = subSources;  
            builder.field("pattern", pattern);  
        public static IntervalFilter fromXContent(XContentParser parser) throws IOException {
                && Objects.equals(filter, match.filter)  
            String query = (String) args[0];  
                (p, c) -> IntervalsSourceProvider.parseInnerIntervals(p),
    public static class Prefix extends IntervalsSourceProvider {
                assert fieldType != null;
            builder.field("pattern", pattern);
            BytesRef normalizedTerm = analyzer.normalize(fieldType.name(), term);
        IntervalFilterScript.Interval interval = new IntervalFilterScript.Interval();  
        }
        }
import org.apache.lucene.queries.intervals.Intervals;
        @Override
            }  
                pattern,
        private final String analyzer;
            builder.field("max_gaps", maxGaps);  
            this.caseInsensitive = caseInsensitive;
        }
            for (IntervalsSourceProvider provider : subSources) {
        private static final ConstructingObjectParser<Match, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
            }  
            }  
                prefixLength,  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            this.analyzer = in.readOptionalString();  
            this.analyzer = analyzer;  
            return Objects.equals(subSources, that.subSources) && Objects.equals(filter, that.filter);  
                    return Intervals.after(input, filterSource);
            if (useField != null) {
     * An interval filter  
            return source;
        public Wildcard(String pattern, String analyzer, String useField, Integer maxExpansions) {  
    @Override
                && Objects.equals(useField, regexp.useField)  
        }
            }
/*
            boolean transpositions = (args[2] == null) ? FuzzyQueryBuilder.DEFAULT_TRANSPOSITIONS : (boolean) args[2];
            this.subSources = in.readNamedWriteableList(IntervalsSourceProvider.class);
        );
            this.caseInsensitive = in.readBoolean();
                builder.endObject();  
         * and {@code caseInsensitive} enables Lucene's only <a href="https://github.com/apache/lucene/blob/main/lucene/core/src/java/org/apache/lucene/util/automaton/RegExp.java#L416">matching flag</a>.
            return PARSER.parse(parser, null);
            Integer maxExpansions = (Integer) args[3];
            return useField;  
                fuzziness.asDistance(term),
 */
        }  
                    throw new ParsingException(parser.getTokenLocation(), "Expected [END_OBJECT] but got [" + parser.currentToken() + "]");
                checkPositions(fieldType);  
        }
        public static final String NAME = "any_of";
                throw new IllegalArgumentException("Cannot create intervals over field [" + type.name() + "] with no positions indexed");
        public static final String NAME = "all_of";
        }  
            NamedAnalyzer analyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();
            PARSER.declareString(constructorArg(), new ParseField("pattern"));  
            Combine combine = (Combine) o;
                throw new ParsingException(parser.getTokenLocation(), "Expected [FIELD_NAME] but got [" + parser.currentToken() + "]");
        static {  
        }  
            IntervalsSourceProvider intervals = IntervalsSourceProvider.fromXContent(parser);
        private final IntervalFilter filter;  
        @Override
            if (this == o) return true;
        }
            }
        IntervalFilter(Script script) {  
        }  
            out.writeNamedWriteableList(subSources);  
            out.writeOptionalWriteable(filter);
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
            this.transpositions = in.readBoolean();
            }
            PARSER.declareObject(optionalConstructorArg(), (p, c) -> IntervalFilter.fromXContent(p), new ParseField("filter"));
     * @opensearch.internal
        }
        IntervalsSourceProvider getFilter() {
            if (type.getTextSearchInfo().hasPositions() == false) {  
                case "after":
            this.analyzer = in.readOptionalString();
        @Override
            }  
            this.mode = IntervalMode.readFromStream(in);
        int getPrefixLength() {
        public Regexp(String pattern, int flags, String useField, Integer maxExpansions, boolean caseInsensitive) {  
            return Objects.hash(type, filter, script);  
        public static final String NAME = "match";
            if (useField != null) {
        }
            out.writeString(term);
            this.maxExpansions = (maxExpansions != null && maxExpansions > 0) ? maxExpansions : null;
            }  
            String type = parser.currentName();  
                builder.field("case_insensitive", caseInsensitive);
            PARSER.declareString(constructorArg(), new ParseField("term"));  
            if (useField != null) {
            }
            out.writeOptionalString(useField);  
        private final boolean caseInsensitive;
        public void writeTo(StreamOutput out) throws IOException {
            if (o == null || getClass() != o.getClass()) return false;
            interval.setIterator(it);  
            out.writeVInt(maxGaps);  
            PARSER.declareString(optionalConstructorArg(), new ParseField("mode"));
            }
        public static Regexp fromXContent(XContentParser parser) throws IOException {  
        }
            this.analyzer = analyzer;
                throw new IllegalArgumentException("Cannot create intervals over field [" + type.name() + "] with no positions indexed");
            }
        private final int maxGaps;
 * GitHub history for details.
        public boolean equals(Object o) {
        static {
            }
        }  
            final org.apache.lucene.util.automaton.RegExp regexp = new org.apache.lucene.util.automaton.RegExp(  
            String flags = (String) args[1];
                provider.toXContent(builder, params);
            } else {
            case "fuzzy":
        }  
        }
            return maxExpansions;
            PARSER.declareString(optionalConstructorArg(), new ParseField("use_field"));
import org.opensearch.core.common.ParsingException;
            return source;  
            if (ordered != null) {  
        @Override
        @Override  
                && transpositions == fuzzy.transpositions  
                builder.startObject();  
        private final IntervalFilter filter;
            this.term = term;
        });
        public IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) {  
                return Match.fromXContent(parser);
    /**  
            case "wildcard":  
            return Objects.hash(query, maxGaps, mode, analyzer, filter, useField);
                builder.field("use_field", useField);  
            return analyzer;
        }
        private static final ConstructingObjectParser<Disjunction, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {  
        }
            }
        }
            builder.startObject(NAME);  
            NamedAnalyzer analyzer = null;  
        public IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) {
            return NAME;  
                case "not_contained_by":
            out.writeOptionalString(analyzer);  
            if (maxExpansions != null) {
    public static class Combine extends IntervalsSourceProvider {
    }  
                }
        }  
        }  
        @Override
            this.filter = filter;  
            if (type.getTextSearchInfo().hasPositions() == false) {  
    }
                fieldType = context.fieldMapper(useField);  
        }
        }
            return transpositions;  
            return Objects.hash(subSources, mode, maxGaps, filter);
            if (analyzer != null) {
import org.opensearch.core.xcontent.ObjectParser;
        private void checkPositions(MappedFieldType type) {
import org.opensearch.index.mapper.MappedFieldType;
            return new Disjunction(subSources, filter);  
 * Modifications Copyright OpenSearch Contributors. See
            } else {  
        }
/*  
            }  
            this.filter = filter;  
        });
            checkPositions(fieldType);
                flags,
                builder.startObject(type);
    }  
     *  
        int getMaxGaps() {
        }  
        }
            out.writeString(pattern);
            this.analyzer = analyzer;
 */  
         * <p>
            this.maxGaps = in.readInt();  
        public boolean equals(Object o) {  
        }  
            }
            } else {
 * this work for additional information regarding copyright
            if (this.analyzer != null) {
            String useField = (String) args[2];  
                && Objects.equals(maxExpansions, wildcard.maxExpansions);
        public static Match fromXContent(XContentParser parser) {
            this.mode = mode;
        public String getWriteableName() {
            IntervalFilter that = (IntervalFilter) o;  
            PARSER.declareString(optionalConstructorArg(), new ParseField("use_field"));
    public static class Match extends IntervalsSourceProvider {
        @Override
                    throw new IllegalArgumentException("Unknown filter type [" + type + "]");
            builder.field("prefix_length", prefixLength);
        }  
            String useField = (String) args[5];
            String term = (String) args[0];
                builder.startObject();  
            return builder.endObject();
            IntervalsSource source;
                builder.field("analyzer", analyzer);
            String analyzer = (String) args[1];  
            }  
        }  
         * {@code flags} is Lucene's <a href="https://github.com/apache/lucene/blob/main/lucene/core/src/java/org/apache/lucene/util/automaton/RegExp.java#L391-L411">syntax flags</a>  
        public int hashCode() {
            if (useField != null) {
        private final Integer maxExpansions;  
         * Constructor
        int getFlags() {
        }
                caseInsensitive ? RegExp.ASCII_CASE_INSENSITIVE : 0  
            builder.startObject();
     * Disjunction interval
        static {  
            PARSER.declareObject(optionalConstructorArg(), (p, c) -> IntervalFilter.fromXContent(p), new ParseField("filter"));  
    public static class Wildcard extends IntervalsSourceProvider {  
            }
        @Override  
    /**
        public void writeTo(StreamOutput out) throws IOException {
     * @opensearch.internal
            if (filter != null) {
    }
        }
            return prefixLength == fuzzy.prefixLength
        }
        private final IntervalMode mode;
            return useField;
        public void extractFields(Set<String> fields) {
            PARSER.declareString(optionalConstructorArg(), new ParseField("mode"));
        @SuppressWarnings("unchecked")
        public void writeTo(StreamOutput out) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;
            if (maxGaps == 0 && mode == IntervalMode.ORDERED && IntervalBuilder.canCombineSources(ss) == false) {
    public abstract IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) throws IOException;  
     *
            PARSER.declareObject(optionalConstructorArg(), (p, c) -> IntervalFilter.fromXContent(p), new ParseField("filter"));
        @Override
            if (this == o) return true;
        }
            return prefix;
            this.transpositions = transpositions;
            } else if (flags != null) {  
                provider.toXContent(builder, params);
            out.writeInt(maxGaps);
        protected boolean accept(IntervalIterator it) {
        }
        public Disjunction(List<IntervalsSourceProvider> subSources, IntervalFilter filter) {
            builder.endObject();  
                intervalMode = IntervalMode.fromString(mode);
            PARSER.declareString(constructorArg(), new ParseField("pattern"));
                return Wildcard.fromXContent(parser);
import java.util.ArrayList;  
        private final String analyzer;
 * not use this file except in compliance with the License.
        @Override  
            return builder;
            }
import org.opensearch.core.xcontent.ToXContentFragment;  
                analyzer = context.getMapperService().getIndexAnalyzers().get(this.analyzer);
     */
        private final int flags;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        public static final String NAME = "regexp";  
            this.flags = in.readVInt();
        private static final ConstructingObjectParser<Regexp, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
        public int hashCode() {  
            return new Wildcard(term, analyzer, useField, maxExpansions);  
            out.writeOptionalString(analyzer);  
        }
            out.writeString(type);
            IntervalFilter filter = (IntervalFilter) args[4];
            }
            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
 * Unless required by applicable law or agreed to in writing,
        public String getWriteableName() {
            PARSER.declareBoolean(optionalConstructorArg(), new ParseField("ordered").withAllDeprecated());
        private final boolean transpositions;
        public static Prefix fromXContent(XContentParser parser) throws IOException {  
            if (o == null || getClass() != o.getClass()) return false;
                builder.field("use_field", useField);
import org.opensearch.core.ParseField;
     * @opensearch.internal
            if (useField != null) {
        }  
        assert parser.currentToken() == XContentParser.Token.FIELD_NAME;
        }  
            PARSER.declareString(optionalConstructorArg(), new ParseField("use_field"));
            builder.startObject(NAME);
     * @opensearch.internal  
        }
                builder.endObject();
 *
                source = Intervals.fixField(useField, fieldType.intervals(query, maxGaps, mode, analyzer, false));
                source = maxExpansions == null ? Intervals.wildcard(normalizedTerm) : Intervals.wildcard(normalizedTerm, maxExpansions);  
}
                && Objects.equals(analyzer, wildcard.analyzer)  
 * Licensed to Elasticsearch under one or more contributor  
            this.prefix = in.readString();
        public String getWriteableName() {  
            return query;
        public static final String NAME = "prefix";
                return Intervals.fixField(useField, regexpSource);
        private final IntervalMode mode;
            return PARSER.parse(parser, null);
            IntervalsSource filterSource = filter.getSource(context, fieldType);  
            builder.startObject(NAME);
                return Combine.fromXContent(parser);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                fields.add(useField);  
        public static final String NAME = "filter";  
        String getType() {  
        @Override  
     * @opensearch.internal  
import java.util.Set;
            builder.field("max_gaps", maxGaps);  
        static {
        private final String useField;
     * Fuzzy interval
        }  
            Boolean ordered = (Boolean) args[0];
         */
        public int hashCode() {
 */  
        }
        @Override
            return prefixLength;
    /**  
            if (filter != null) {
        }
            String useField = (String) args[6];  
        public void writeTo(StreamOutput out) throws IOException {
                constructorArg(),
            }
        });  
            return NAME;
     */
            final Automaton automaton = Operations.determinize(regexp.toAutomaton(), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
                return Fuzzy.fromXContent(parser);
        switch (parser.currentName()) {  
        public Prefix(StreamInput in) throws IOException {
        @Override
        /**  
            if (filter != null) {  
                && Objects.equals(analyzer, fuzzy.analyzer)  
            if (analyzer != null) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            } else {  
        @Override  
            if (useField != null) {
            return builder.endObject();
            return analyzer;  
            case "regexp":
            "Unknown interval type [" + parser.currentName() + "], expecting one of [match, any_of, all_of, prefix, wildcard, regexp]"  
        }
 * this file be licensed under the Apache-2.0 license or a
        private final String useField;  
            return analyzer;  
            if (useField != null) {
        @Override
            this.filter = in.readOptionalWriteable(IntervalFilter::new);
        @Override
 *  
        }  
            out.writeBoolean(transpositions);  
            out.writeVInt(prefixLength);
                    return Intervals.nonOverlapping(input, filterSource);
            IntervalsSource source = IntervalBuilder.combineSources(ss, maxGaps, mode);
            out.writeOptionalString(analyzer);
            Fuzziness fuzziness = (args[3] == null) ? FuzzyQueryBuilder.DEFAULT_FUZZINESS : (Fuzziness) args[3];  
    static class ScriptFilterSource extends FilteredIntervalsSource {  
                if (this.analyzer == null) {
            PARSER.declareInt(optionalConstructorArg(), new ParseField("max_gaps"));
                && mode == match.mode
            this.analyzer = analyzer;  
                Script script = Script.parse(parser);
        String getQuery() {  
        }
        private final String analyzer;  
            return filter;
        public IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) {
                && Objects.equals(useField, wildcard.useField)
        String getPrefix() {
        @Override  
        @Override
            PARSER.declareString(constructorArg(), new ParseField("prefix"));
        public void extractFields(Set<String> fields) {
            this.script = script;
        }
            if (script != null) {
        }  
            switch (type) {
    public static IntervalsSourceProvider fromXContent(XContentParser parser) throws IOException {
        }
        }
        public void extractFields(Set<String> fields) {  
                && Objects.equals(useField, fuzzy.useField);
        }
            this.analyzer = in.readOptionalString();  
        boolean isCaseInsensitive() {
            PARSER.declareString(optionalConstructorArg(), new ParseField("use_field"));  
            return maxGaps;
        @Override
 * You may obtain a copy of the License at  
        }
            }
            out.writeOptionalWriteable(filter);
            if (flagsValue != null) {
        }
        }
                provider.extractFields(fields);
        public Match(StreamInput in) throws IOException {
import org.apache.lucene.queries.intervals.IntervalsSource;
            PARSER.declareObjectArray(  
            }
        @Override  
        }  
        public Regexp(StreamInput in) throws IOException {
            source = Intervals.multiterm(fq.getAutomata(), term);
                builder.field("analyzer", analyzer);  
                checkPositions(fieldType);
            return filter;
        @Override
        private final int prefixLength;
        }
            this.filter = filter;  
                analyzer = context.getMapperService().getIndexAnalyzers().get(this.analyzer);  
            return Objects.equals(pattern, wildcard.pattern)
        public void writeTo(StreamOutput out) throws IOException {
            return builder;
        public void extractFields(Set<String> fields) {  
        }  
            builder.startObject(NAME);  
        public IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) throws IOException {
        @Override
            PARSER.declareString(optionalConstructorArg(), new ParseField("analyzer"));
            return mode;  
            if (analyzer != null) {
        public int hashCode() {  
            List<IntervalsSource> ss = new ArrayList<>();  
 * to a proximity source (phrase, ordered, unordered, unordered without overlaps depending on how
     * @opensearch.internal
        static final ConstructingObjectParser<Combine, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {  
        IntervalFilter getFilter() {
        Script getScript() {
        }
        @Override
                this.script = null;  
     * Combine interval
        String getPattern() {
import org.apache.lucene.util.automaton.RegExp;
        public String getWriteableName() {
        @Override
    public static class Disjunction extends IntervalsSourceProvider {  
            return caseInsensitive;  
import org.opensearch.core.common.io.stream.StreamInput;
                BytesRef normalizedTerm = analyzer.normalize(fieldType.name(), pattern);
            }
                && Objects.equals(analyzer, match.analyzer);
            }
import java.util.Objects;  
        private final String query;  
            String mode = (String) args[3];  
import org.opensearch.index.analysis.NamedAnalyzer;
            this.useField = useField;  
            this.prefixLength = in.readVInt();  
            return Objects.equals(this.prefix, prefix.prefix)  
                this.script = new Script(in);
            if (useField != null) {
            IntervalMode intervalMode;
                return new ScriptFilterSource(input, script.getIdOrCode(), ifs);
                    return Intervals.notContaining(input, filterSource);
            this.prefixLength = prefixLength;  
     *  
            PARSER.declareObjectArray(  
        private void checkPositions(MappedFieldType type) {
            List<IntervalsSourceProvider> subSources = (List<IntervalsSourceProvider>) args[0];
            FuzzyQuery fq = new FuzzyQuery(  
            }
                IntervalsSource wildcardSource = maxExpansions == null
        });
            out.writeOptionalString(useField);
            String useField = (String) args[2];
            this.useField = useField;
            for (IntervalsSourceProvider provider : subSources) {
            return Objects.equals(type, that.type) && Objects.equals(script, that.script) && Objects.equals(filter, that.filter);
        }
            this.analyzer = in.readOptionalString();  
        String getAnalyzer() {
     *  
        }
                default:  
        }  
            }  
        }
            if (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
            out.writeNamedWriteableList(subSources);  
        List<IntervalsSourceProvider> getSubSources() {  
            case "match":
                fieldType = context.fieldMapper(useField);
import org.opensearch.core.common.io.stream.StreamOutput;
            if (filter != null) {
 *
        @Override
        }
            }  
            } else {
                    : Intervals.multiterm(compiledAutomaton, maxExpansions, regexp.toString());  
                && Objects.equals(useField, prefix.useField);
    }
        String getUseField() {
            return Objects.equals(subSources, combine.subSources)
        public Fuzzy(String term, int prefixLength, boolean transpositions, Fuzziness fuzziness, String analyzer, String useField) {
                assert fieldType != null;
            return script;  
        }
        }  
            PARSER.declareString(optionalConstructorArg(), new ParseField("use_field"));
        final IntervalFilterScript script;
            throw new ParsingException(parser.getTokenLocation(), "Expected [END_OBJECT] but got [" + parser.currentToken() + "]");
        }
            }  
        public static final String NAME = "wildcard";
        @Override
            out.writeOptionalString(analyzer);
        @Override
        private final String useField;
            if (this == o) return true;  
        public boolean equals(Object o) {  
        public String getWriteableName() {
            return flags;  
            if (caseInsensitive) {
    /**
        @Override
                    ? Intervals.multiterm(compiledAutomaton, regexp.toString())
                    ? Intervals.multiterm(compiledAutomaton, regexp.toString())
        IntervalsSourceProvider isp = IntervalsSourceProvider.fromXContent(parser);
                builder.field("use_field", useField);  
import java.util.Locale;
        }
        public Combine(List<IntervalsSourceProvider> subSources, IntervalMode mode, int maxGaps, IntervalFilter filter) {
                    return Intervals.containedBy(input, filterSource);
            if (useField != null) {
            return Objects.equals(pattern, regexp.pattern)
            parser.getTokenLocation(),
        }  
            if (analyzer != null) {  
            IntervalFilter filter = (IntervalFilter) args[5];
        private void checkPositions(MappedFieldType type) {
                new Term(fieldType.name(), normalizedTerm),
                fieldType = context.fieldMapper(useField);  
                fields.add(useField);  
        @Override
            Prefix prefix = (Prefix) o;
            this.useField = useField;
        }
            this.useField = in.readOptionalString();
        }
            return PARSER.apply(parser, null);
     */
                return new IntervalFilter(script);  
            this.pattern = in.readString();
            out.writeOptionalNamedWriteable(filter);  
        String getUseField() {
import org.apache.lucene.util.automaton.CompiledAutomaton;  
            if (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
            builder.startObject(NAME);
    public abstract void extractFields(Set<String> fields);
            builder.endArray();
            );  
        }  
        Integer getMaxExpansions() {
                && Objects.equals(useField, match.useField)
            }
        public Match(String query, int maxGaps, IntervalMode mode, String analyzer, IntervalFilter filter, String useField) {
        }  
        public void writeTo(StreamOutput out) throws IOException {
            this.query = query;
            }
        }
        }  
            Integer maxGaps = (args[3] == null ? -1 : (Integer) args[3]);
                builder.field("max_expansions", maxExpansions);
        private final String analyzer;
            mode.writeTo(out);
            for (IntervalsSourceProvider provider : subSources) {
            out.writeOptionalString(useField);
            if (ordered != null) {
            if (filter != null) {  
        public IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) throws IOException {
 * specific language governing permissions and limitations
        }
            return new Combine(subSources, intervalMode, maxGaps, filter);
            out.writeOptionalString(useField);
        public IntervalsSource filter(IntervalsSource input, QueryShardContext context, MappedFieldType fieldType) throws IOException {
        public Disjunction(StreamInput in) throws IOException {  
                case "containing":
            );
                analyzer = context.getMapperService().getIndexAnalyzers().get(this.analyzer);
        String getAnalyzer() {
            }
                case "overlapping":
                IntervalFilterScript ifs = context.compile(script, IntervalFilterScript.CONTEXT).newInstance();  
     * @opensearch.internal  
            return useField;
        }
            }
            PARSER.declareInt(optionalConstructorArg(), new ParseField("max_gaps"));  
        }  
        }
                case "before":
            builder.startArray("intervals");
        }
            if (o == null || getClass() != o.getClass()) return false;  
            Integer maxExpansions = (Integer) args[4];
            this.flags = flags;
                throw new ParsingException(parser.getTokenLocation(), "Expected [END_OBJECT] but got [" + parser.currentToken() + "]");
            case "all_of":
import org.apache.lucene.util.automaton.Operations;
            } else {  
                return maxExpansions == null
        private static final ConstructingObjectParser<Prefix, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {  
            IntervalsSource source;
        }  
            this.maxExpansions = in.readOptionalVInt();
        private final String type;
 * strict the matching should be); {@link Combine}, which allows proximity queries
            return builder;
        }  
                script.writeTo(out);
        }
        public String getWriteableName() {
        }
            this.script = script;
        throw new ParsingException(
        }  
            IntervalsSource source;
import org.opensearch.core.xcontent.XContentParser;  
    /**
            }
        @Override
                analyzer = context.getMapperService().getIndexAnalyzers().get(this.analyzer);
        public int hashCode() {  
     */  
            if (useField != null) {  
        IntervalMode getMode() {
     * Regular expression interval  
        public static Combine fromXContent(XContentParser parser) {  
 * SPDX-License-Identifier: Apache-2.0
    @Override
        }
            }
        private final String term;  
            Fuzzy fuzzy = (Fuzzy) o;
     * @opensearch.internal  
                filter.toXContent(builder, params);
            boolean caseInsensitive = args[5] != null && (boolean) args[5];
     */
 * ownership. Elasticsearch licenses this file to you under  
                    ? Intervals.wildcard(normalizedTerm)  
            if (useField != null) {
            return Objects.hash(pattern, flags, useField, maxExpansions, caseInsensitive);
            PARSER.declareBoolean(optionalConstructorArg(), new ParseField("case_insensitive"));  
        @Override
        static {
                return new Regexp(pattern, flagsValue, useField, maxExpansions, caseInsensitive);
            return pattern;
    }
/*  
        public int hashCode() {  
        public void extractFields(Set<String> fields) {
        String getPattern() {
            this.filter = in.readOptionalNamedWriteable(IntervalsSourceProvider.class);
        String getTerm() {  
        @Override  
                out.writeBoolean(true);
        private final String useField;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.ToXContentObject;
        }
            if (this.analyzer != null) {
        List<IntervalsSourceProvider> getSubSources() {
        }  
                out.writeBoolean(false);
            this.filter = filter;
            if (this == o) return true;
     * Prefix interval
        @Override
        Fuzziness getFuzziness() {  
            return NAME;  
        IntervalMode getMode() {
            out.writeOptionalWriteable(filter);  
        }  
            return builder;
import org.opensearch.common.unit.Fuzziness;  
import org.apache.lucene.queries.intervals.FilteredIntervalsSource;
        @Override
    /**
            int prefixLength = (args[1] == null) ? FuzzyQueryBuilder.DEFAULT_PREFIX_LENGTH : (int) args[1];
            for (IntervalsSourceProvider provider : subSources) {
                    : Intervals.wildcard(normalizedTerm, maxExpansions);
                case "not_containing":  
            return NAME;  
            this.subSources = in.readNamedWriteableList(IntervalsSourceProvider.class);
        String getAnalyzer() {  
            builder.startObject();
     * @opensearch.internal
        public boolean equals(Object o) {
            return builder;  
            }  
            for (IntervalsSourceProvider provider : subSources) {
            } else {  
                && mode == combine.mode  
            }  
        @Override  
        public void extractFields(Set<String> fields) {
                fields.add(useField);
import org.apache.lucene.util.automaton.Automaton;
            } else if (mode != null) {
        String getUseField() {  
            if (o == null || getClass() != o.getClass()) return false;  
    }
        }  
                && Objects.equals(caseInsensitive, regexp.caseInsensitive);
            }
        @Override  
            String term = (String) args[0];
    public abstract boolean equals(Object other);
            builder.field("transpositions", transpositions);
            return Objects.hash(subSources, filter);
            return Objects.hash(term, prefixLength, transpositions, fuzziness, analyzer, useField);  
    }
    }
            } else {  
            PARSER.declareInt(optionalConstructorArg(), new ParseField("flags_value"));  
            String term = (String) args[0];  
            }
            this.term = in.readString();
            if (o == null || getClass() != o.getClass()) return false;
        private final List<IntervalsSourceProvider> subSources;
/**  
     *
        }
        ScriptFilterSource(IntervalsSource in, String name, IntervalFilterScript script) {
        }
                && Objects.equals(term, fuzzy.term)
                builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName(), script);
 * Factory class for {@link IntervalsSource}
 *
                    analyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();
            return NAME;
     *
        private final Fuzziness fuzziness;  
            this.pattern = in.readString();  
        public boolean equals(Object o) {
            NamedAnalyzer analyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();  
    }
            this.type = type.toLowerCase(Locale.ROOT);
            builder.endObject();
        }
            return pattern;
            return useField;  
        }
        static {
        private final Integer maxExpansions;
        if (parser.nextToken() != XContentParser.Token.FIELD_NAME) {
                builder.field("filter", filter);  
            if (this.analyzer != null) {
        @Override  
            this.subSources = subSources;
                    return Intervals.overlapping(input, filterSource);
        private final List<IntervalsSourceProvider> subSources;  
            return new Prefix(term, analyzer, useField);
                return filter.filter(source, context, fieldType);
        public IntervalsSource getSource(QueryShardContext ctx, MappedFieldType fieldType) throws IOException {  
            builder.startArray("intervals");
                return Regexp.fromXContent(parser);  
            return source;
                && Objects.equals(maxExpansions, regexp.maxExpansions)
        });
            } else if (mode != null) {
                fieldType = context.fieldMapper(useField);  
            PARSER.declareField(optionalConstructorArg(), (p, c) -> Fuzziness.parse(p), Fuzziness.FIELD, ObjectParser.ValueType.VALUE);  
        private final IntervalsSourceProvider filter;  
            return PARSER.parse(parser, null);  
        @Override  
     *
            builder.field(NAME);  
                builder.field("filter", filter);  
            for (IntervalsSourceProvider provider : subSources) {
            if (Script.SCRIPT_PARSE_FIELD.match(type, parser.getDeprecationHandler())) {
        public IntervalFilter(IntervalsSourceProvider filter, String type) {  
                throw new ParsingException(parser.getTokenLocation(), "Expected [END_OBJECT] but got [" + parser.currentToken() + "]");
        public static final int DEFAULT_FLAGS_VALUE = RegexpFlag.ALL.value();
        int getMaxGaps() {  
            this.useField = useField;
        }  
                }  
            return new Match(query, max_gaps, intervalMode, analyzer, filter, useField);
            return filter.filter(source, ctx, fieldType);  
            if (this == o) return true;  
        }  
        }
            if (filter == null) {  
     *
            List<IntervalsSource> sources = new ArrayList<>();
        });
        }
 * under the License.  
                && Objects.equals(query, match.query)
            }
            Boolean ordered = (Boolean) args[2];
 * the Apache License, Version 2.0 (the "License"); you may
        public String getWriteableName() {
            }
            }  
        public static final String NAME = "fuzzy";
            fuzziness.toXContent(builder, params);  
            if (parser.nextToken() != XContentParser.Token.FIELD_NAME) {  
            Disjunction that = (Disjunction) o;
                (p, c) -> IntervalsSourceProvider.parseInnerIntervals(p),
        public void writeTo(StreamOutput out) throws IOException {
            PARSER.declareString(optionalConstructorArg(), new ParseField("flags"));
 * software distributed under the License is distributed on an
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            out.writeVInt(flags);  
            return mode;  
                builder.field("flags_value", flags);
                && maxGaps == combine.maxGaps
            } else {
                    analyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();
            }  
    }
        private final String pattern;
                    return Intervals.containing(input, filterSource);  
        public Prefix(String prefix, String analyzer, String useField) {
            Regexp regexp = (Regexp) o;  
        }  
        private final String prefix;  
            return useField;
            this.useField = in.readOptionalString();
        static {  
            PARSER.declareBoolean(optionalConstructorArg(), new ParseField("ordered").withAllDeprecated());
                case "contained_by":
    /**  
            return NAME;  
            String analyzer = (String) args[4];
        }  
 * The OpenSearch Contributors require contributions made to  
     * Script filter source
            throw new ParsingException(parser.getTokenLocation(), "Expected [FIELD_NAME] but got [" + parser.currentToken() + "]");  
        }
import org.apache.lucene.search.FuzzyQuery;  
 * license agreements. See the NOTICE file distributed with
                if (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
        public boolean equals(Object o) {
        private final int maxGaps;
            this.maxGaps = in.readVInt();  
     */
            }  
            this.filter = in.readOptionalWriteable(IntervalFilter::new);  
            return filter;
                && Objects.equals(fuzziness, fuzzy.fuzziness)
            return maxGaps == match.maxGaps  
import org.opensearch.core.common.io.stream.NamedWriteable;  
        }  
                fields.add(useField);
            this.useField = useField;  
        String getUseField() {  
        private final String pattern;  
            PARSER.declareInt(optionalConstructorArg(), new ParseField("prefix_length"));
            if (this == o) return true;
    /**
                assert fieldType != null;
            );
            PARSER.declareString(constructorArg(), new ParseField("query"));
                && Objects.equals(flags, regexp.flags)
            String analyzer = (String) args[4];
            this.prefix = prefix;
            this.fuzziness = fuzziness;
        IntervalFilter getFilter() {
     * Match interval
    public static class Fuzzy extends IntervalsSourceProvider {
            }
            if (this == o) return true;  
                return new Regexp(pattern, RegexpFlag.resolveValue(flags), useField, maxExpansions, caseInsensitive);
package org.opensearch.index.query;
        }  
            if (o == null || getClass() != o.getClass()) return false;  
import org.opensearch.core.xcontent.XContentBuilder;
        @Override
            if (useField != null) {
        IntervalFilter getFilter() {
            return subSources;
            Wildcard wildcard = (Wildcard) o;
            out.writeOptionalVInt(maxExpansions);
        }
            if (parser.nextToken() != XContentParser.Token.FIELD_NAME) {
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public void extractFields(Set<String> fields) {  
                new ParseField("intervals")  
            if (type.getTextSearchInfo().hasPositions() == false) {
            String mode = (String) args[1];
        }
            if (maxExpansions != null) {  
        Integer getMaxExpansions() {
            IntervalMode intervalMode;
        }
            return script.execute(interval);
            builder.endArray();
        public int hashCode() {  
                    return Intervals.notContainedBy(input, filterSource);  
            IntervalFilter filter = (IntervalFilter) args[1];
            if (flags != DEFAULT_FLAGS_VALUE) {
            }  
                source = fieldType.intervals(prefix, 0, IntervalMode.UNORDERED, analyzer, true);
        }
                source = Intervals.fixField(useField, source);  
            return type;
                intervalMode = IntervalMode.UNORDERED;
                    : Intervals.multiterm(compiledAutomaton, maxExpansions, regexp.toString());  
            if (useField != null) {
            builder.field("mode", mode);
            PARSER.declareString(optionalConstructorArg(), new ParseField("analyzer"));
        }
        }  
        public static Fuzzy fromXContent(XContentParser parser) throws IOException {
            return new Fuzzy(term, prefixLength, transpositions, fuzziness, analyzer, useField);  
        @Override
        }
                constructorArg(),
     */
                && Objects.equals(analyzer, prefix.analyzer)
            return maxExpansions;
                }
            NamedAnalyzer analyzer = null;  
        });
            this.mode = mode;
                throw new ParsingException(parser.getTokenLocation(), "Expected [FIELD_NAME] but got [" + parser.currentToken() + "]");  
                ss.add(provider.getSource(ctx, fieldType));
                provider.extractFields(fields);  
            this.useField = in.readOptionalString();
        }
        public IntervalsSource getSource(QueryShardContext ctx, MappedFieldType fieldType) throws IOException {
            case "any_of":  
                    return Intervals.before(input, filterSource);  
                builder.field("use_field", useField);
        @Override
        }  
                builder.field("analyzer", analyzer);  
            if (script == null) {
        public boolean equals(Object o) {
                new ParseField("intervals")  
        @Override
        @Override
        public static Disjunction fromXContent(XContentParser parser) throws IOException {
            String pattern = (String) args[0];  
import org.apache.lucene.index.Term;
            return filter;
        }
            this.useField = in.readOptionalString();
        }
                source = fieldType.intervals(query, maxGaps, mode, analyzer, false);
            return term;
                && Objects.equals(filter, combine.filter);
            builder.startObject(NAME);
            final CompiledAutomaton compiledAutomaton = new CompiledAutomaton(automaton);  
            return new IntervalFilter(intervals, type);  
            return PARSER.parse(parser, null);  
                throw new IllegalArgumentException("Too many disjunctions to expand");
                builder.field("max_expansions", maxExpansions);
            if (this.analyzer != null) {
            List<IntervalsSourceProvider> subSources = (List<IntervalsSourceProvider>) args[2];  
        }  
            out.writeOptionalVInt(maxExpansions);
            PARSER.declareString(optionalConstructorArg(), new ParseField("analyzer"));  
            return analyzer;
            return maxGaps;
            }  
