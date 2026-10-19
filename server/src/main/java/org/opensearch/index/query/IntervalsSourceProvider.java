            return PARSER.parse(parser, null);
                analyzer = context.getMapperService().getIndexAnalyzers().get(this.analyzer);
            return source;
/*
            if (filter != null) {
        public Prefix(String prefix, String analyzer, String useField) {
            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
            this.useField = in.readOptionalString();
        public void extractFields(Set<String> fields) {
            return builder;
                    throw new ParsingException(parser.getTokenLocation(), "Expected [END_OBJECT] but got [" + parser.currentToken() + "]");
        }
                builder.field("filter", filter);
            for (IntervalsSourceProvider provider : subSources) {
            }
                return new IntervalFilter(script);
                Script script = Script.parse(parser);
    public abstract boolean equals(Object other);
            out.writeInt(maxGaps);
        private static final ConstructingObjectParser<Disjunction, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
        }
            return builder;
        @Override
     * @opensearch.internal
            }
            IntervalsSource source;
            String mode = (String) args[3];
            if (this == o) return true;
            if (flags != DEFAULT_FLAGS_VALUE) {
            }
        }
            PARSER.declareString(constructorArg(), new ParseField("query"));
        public IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) throws IOException {
        }
        }
        }
                throw new IllegalArgumentException("Cannot create intervals over field [" + type.name() + "] with no positions indexed");
                pattern,
     * @opensearch.internal
        public int hashCode() {
        });
            PARSER.declareField(optionalConstructorArg(), (p, c) -> Fuzziness.parse(p), Fuzziness.FIELD, ObjectParser.ValueType.VALUE);
        }
                case "not_containing":
            }
                fields.add(useField);
    }
     * Combine interval
        Script getScript() {
                && mode == combine.mode
            }
        }
            return Objects.equals(type, that.type) && Objects.equals(script, that.script) && Objects.equals(filter, that.filter);
            if (this == o) return true;
 * Unless required by applicable law or agreed to in writing,
        if (parser.nextToken() != XContentParser.Token.FIELD_NAME) {
            if (parser.nextToken() != XContentParser.Token.FIELD_NAME) {
        }
            case "fuzzy":
     * @opensearch.internal
                throw new ParsingException(parser.getTokenLocation(), "Expected [FIELD_NAME] but got [" + parser.currentToken() + "]");
        @Override
                && Objects.equals(useField, regexp.useField)
                intervalMode = IntervalMode.fromString(mode);
     * Script filter source
            if (useField != null) {
     * @opensearch.internal
            return new Disjunction(subSources, filter);
        @Override
            final Automaton automaton = Operations.determinize(regexp.toAutomaton(), Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
            out.writeOptionalWriteable(filter);
            return NAME;
import org.apache.lucene.util.automaton.RegExp;
            if (useField != null) {
        private final int maxGaps;
            if (analyzer != null) {
            return builder.endObject();
                    return Intervals.nonOverlapping(input, filterSource);
        });
            out.writeVInt(maxGaps);
            return caseInsensitive;
        private void checkPositions(MappedFieldType type) {
            if (useField != null) {
            return maxGaps == match.maxGaps
 * between different sub-sources; and {@link Disjunction}.
            Regexp regexp = (Regexp) o;
                return new ScriptFilterSource(input, script.getIdOrCode(), ifs);
        return isp;
            return new Fuzzy(term, prefixLength, transpositions, fuzziness, analyzer, useField);
        public int hashCode() {
            boolean transpositions = (args[2] == null) ? FuzzyQueryBuilder.DEFAULT_TRANSPOSITIONS : (boolean) args[2];
        @Override
        protected boolean accept(IntervalIterator it) {
    @Override
            builder.startObject(NAME);
            return subSources;
                source = Intervals.fixField(useField, source);
            return source;
import org.opensearch.index.mapper.MappedFieldType;
            String term = (String) args[0];
        public IntervalsSource getSource(QueryShardContext ctx, MappedFieldType fieldType) throws IOException {
            IntervalFilter filter = (IntervalFilter) args[4];
        String getPrefix() {
        }
        private final String pattern;
    }
            out.writeOptionalString(useField);
 * Modifications Copyright OpenSearch Contributors. See
            this.analyzer = in.readOptionalString();
            );
                    return Intervals.overlapping(input, filterSource);
            if (this == o) return true;
        IntervalFilter getFilter() {
        private final boolean transpositions;
        public static final int DEFAULT_FLAGS_VALUE = RegexpFlag.ALL.value();
            out.writeString(pattern);
            }
 * Built-in sources include {@link Match}, which analyzes a text string and converts it
            super("FILTER(" + name + ")", in);
        private final boolean caseInsensitive;
        public void writeTo(StreamOutput out) throws IOException {
        }
                && maxGaps == combine.maxGaps
            if (useField != null) {
                    : Intervals.multiterm(compiledAutomaton, maxExpansions, regexp.toString());
            out.writeOptionalWriteable(filter);
            return useField;
        }
        @Override
     * @opensearch.internal
            if (o == null || getClass() != o.getClass()) return false;
            }
        boolean isCaseInsensitive() {
                constructorArg(),
            return filter;
        private final IntervalsSourceProvider filter;
            return builder;
        }
        }
            } else {
        }
        public boolean equals(Object o) {
        }
                }
                new Term(fieldType.name(), normalizedTerm),
        private final String useField;
        }
            }
 */
        public Wildcard(StreamInput in) throws IOException {
            this.transpositions = transpositions;
                provider.toXContent(builder, params);
                return Match.fromXContent(parser);
            fuzziness.writeTo(out);
                intervalMode = IntervalMode.UNORDERED;
        boolean isTranspositions() {
        private final List<IntervalsSourceProvider> subSources;
        public int hashCode() {
        private final String useField;
        private static final ConstructingObjectParser<Fuzzy, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
            return Objects.equals(pattern, wildcard.pattern)
            "Unknown interval type [" + parser.currentName() + "], expecting one of [match, any_of, all_of, prefix, wildcard, regexp]"
        }
            return builder.endObject();
                return new Regexp(pattern, RegexpFlag.resolveValue(flags), useField, maxExpansions, caseInsensitive);
        }
        public static final String NAME = "prefix";
                source = maxExpansions == null ? Intervals.wildcard(normalizedTerm) : Intervals.wildcard(normalizedTerm, maxExpansions);
            this.term = term;
            Integer maxExpansions = (Integer) args[4];
package org.opensearch.index.query;
        public static Disjunction fromXContent(XContentParser parser) throws IOException {
        Integer getMaxExpansions() {
        public void writeTo(StreamOutput out) throws IOException {
     */
            PARSER.declareString(optionalConstructorArg(), new ParseField("use_field"));
     *
        });
        String getTerm() {
        @Override
            return source;
            this.script = null;
            return PARSER.parse(parser, null);
                case "containing":
            if (filter != null) {
            } else if (mode != null) {
        @Override
                case "not_contained_by":
                new ParseField("intervals")
     */
        @Override
        }
            return filter.filter(source, ctx, fieldType);
    /**
        static {
            }
            String useField = (String) args[3];
            return subSources;
                analyzer = context.getMapperService().getIndexAnalyzers().get(this.analyzer);
            }
        @Override
                builder.field("use_field", useField);
            IntervalMode intervalMode;
            }
        @Override
        static {
        }
            out.writeOptionalString(useField);
     *
                builder.field("case_insensitive", caseInsensitive);
            if (o == null || getClass() != o.getClass()) return false;
        }
            PARSER.declareString(constructorArg(), new ParseField("term"));
            }
            return analyzer;
        @Override
            String analyzer = (String) args[1];
                fields.add(useField);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamOutput;
            }
                fieldType = context.fieldMapper(useField);
            if (useField != null) {
            builder.field("pattern", pattern);
            }
            }
        }
            if (this == o) return true;
            }
        public void writeTo(StreamOutput out) throws IOException {
        @Override
            }
        public int hashCode() {
 * to a proximity source (phrase, ordered, unordered, unordered without overlaps depending on how
        }
        IntervalFilterScript.Interval interval = new IntervalFilterScript.Interval();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
                checkPositions(fieldType);
            return Objects.hash(term, prefixLength, transpositions, fuzziness, analyzer, useField);
                case "overlapping":
            return PARSER.parse(parser, null);
            if (useField != null) {
            if (useField != null) {
        public IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) {
            int prefixLength = (args[1] == null) ? FuzzyQueryBuilder.DEFAULT_PREFIX_LENGTH : (int) args[1];
            this.subSources = subSources;
            return PARSER.parse(parser, null);
            String query = (String) args[0];
            IntervalsSource source = Intervals.or(sources.toArray(new IntervalsSource[0]));
        }
        public boolean equals(Object o) {
            out.writeOptionalNamedWriteable(filter);
        String getAnalyzer() {
        }
            case "prefix":
        }
        }
            if (script == null) {
        public IntervalFilter(StreamInput in) throws IOException {
            this.pattern = in.readString();
            this.maxExpansions = in.readOptionalVInt();
        final IntervalFilterScript script;
        public Regexp(StreamInput in) throws IOException {
            if (filter == null) {
        }
        }
                provider.toXContent(builder, params);
     *
            this.analyzer = analyzer;
        @Override
            return term;
        List<IntervalsSourceProvider> getSubSources() {
        }
            if (type.getTextSearchInfo().hasPositions() == false) {
                    return Intervals.before(input, filterSource);
        }
            this.flags = in.readVInt();
                builder.field("use_field", useField);
        private final String useField;
        @Override
 *
            interval.setIterator(it);
                IntervalsSource regexpSource = maxExpansions == null
        @Override
            }
        }
        }
            if (useField != null) {
                builder.endObject();
            }
        @Override
        @Override
            return NAME;
            if (useField != null) {
            String useField = (String) args[6];
 * The OpenSearch Contributors require contributions made to
            return NAME;
            if (filter != null) {
     * Prefix interval
        @Override
            return Objects.equals(pattern, regexp.pattern)
        }
    }
            if (parser.nextToken() != XContentParser.Token.FIELD_NAME) {
            return flags;
        private final IntervalFilter filter;
            PARSER.declareString(constructorArg(), new ParseField("pattern"));
    private static IntervalsSourceProvider parseInnerIntervals(XContentParser parser) throws IOException {
            } else {
     * Regular expression interval
                && Objects.equals(maxExpansions, regexp.maxExpansions)
import java.util.ArrayList;
import org.opensearch.core.xcontent.XContentParser;
        }
                && Objects.equals(caseInsensitive, regexp.caseInsensitive);
            throw new ParsingException(parser.getTokenLocation(), "Expected [FIELD_NAME] but got [" + parser.currentToken() + "]");
            this.filter = in.readOptionalWriteable(IntervalFilter::new);
        }
        private final int flags;
        }
            if (maxExpansions != null) {
        }
        }
                    return Intervals.after(input, filterSource);
            }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public static Prefix fromXContent(XContentParser parser) throws IOException {
            parser.getTokenLocation(),
                intervalMode = IntervalMode.UNORDERED;
        @Override
            int max_gaps = (args[1] == null ? -1 : (Integer) args[1]);
import org.apache.lucene.util.BytesRef;
        }
                && Objects.equals(useField, fuzzy.useField);
        @SuppressWarnings("unchecked")
        }
            PARSER.declareBoolean(optionalConstructorArg(), new ParseField("case_insensitive"));
            builder.startObject(NAME);
                && Objects.equals(useField, prefix.useField);
            } else {
        private final String type;
        @Override
            if (ordered != null) {
            }
     */
        public void writeTo(StreamOutput out) throws IOException {
                builder.startObject(type);
    /**
                builder.field("filter", filter);
        }
            PARSER.declareObjectArray(
                checkPositions(fieldType);
        }
                throw new ParsingException(parser.getTokenLocation(), "Expected [END_OBJECT] but got [" + parser.currentToken() + "]");
        @Override
            return source;
            this.analyzer = analyzer;
            if (filter != null) {
            String mode = (String) args[1];
        private final Fuzziness fuzziness;
            } else {
        assert parser.currentToken() == XContentParser.Token.FIELD_NAME;
        public boolean equals(Object o) {
                return new Regexp(pattern, flagsValue, useField, maxExpansions, caseInsensitive);
                    ? Intervals.multiterm(compiledAutomaton, regexp.toString())
                }
        }
import org.opensearch.core.common.io.stream.Writeable;
            String useField = (String) args[2];
     */
            return maxExpansions;
            this.analyzer = in.readOptionalString();
                && Objects.equals(fuzziness, fuzzy.fuzziness)
            }
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            if (this.analyzer != null) {
            return Objects.hash(subSources, mode, maxGaps, filter);
            builder.field("term", term);
            return filter;
        switch (parser.currentName()) {
        }
        public void extractFields(Set<String> fields) {
import org.opensearch.common.unit.Fuzziness;
            if (in.readBoolean()) {
            builder.startObject();
        public static final String NAME = "filter";
            }
     *
            for (IntervalsSourceProvider provider : subSources) {
                throw new IllegalArgumentException("Cannot create intervals over field [" + type.name() + "] with no positions indexed");
            if (maxExpansions != null) {
            if (useField != null) {
            builder.field("query", query);
        public static Match fromXContent(XContentParser parser) {
                && Objects.equals(analyzer, match.analyzer);
            return new Combine(subSources, intervalMode, maxGaps, filter);
            builder.endArray();
            Integer flagsValue = (Integer) args[2];
        public String getWriteableName() {
import org.opensearch.script.Script;
            PARSER.declareObjectArray(
        }
        private static final ConstructingObjectParser<Wildcard, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
     */
                source = fieldType.intervals(query, maxGaps, mode, analyzer, false);
                    return Intervals.containing(input, filterSource);
                transpositions
                IntervalsSource wildcardSource = maxExpansions == null
            }
import org.apache.lucene.queries.intervals.FilteredIntervalsSource;
        private void checkPositions(MappedFieldType type) {
            IntervalFilter filter = (IntervalFilter) args[1];
            return transpositions;
            String pattern = (String) args[0];
        }
        static {
                builder.field("filter", filter);
                    return Intervals.notContaining(input, filterSource);
            } else {
        private final String useField;
        private final String analyzer;
            if (caseInsensitive) {
            this.prefix = prefix;
        }
            String useField = (String) args[5];
            builder.field("transpositions", transpositions);
            return builder;
        public Fuzzy(StreamInput in) throws IOException {
        String getAnalyzer() {
            case "match":
                builder.startObject();
            throw new ParsingException(parser.getTokenLocation(), "Expected [END_OBJECT] but got [" + parser.currentToken() + "]");
                return Intervals.fixField(useField, regexpSource);
        static {
        public Combine(List<IntervalsSourceProvider> subSources, IntervalMode mode, int maxGaps, IntervalFilter filter) {
        }
            PARSER.declareInt(optionalConstructorArg(), new ParseField("max_expansions"));
            case "wildcard":
            return pattern;
        public String getWriteableName() {
        @Override
            if (this.analyzer != null) {
     * @opensearch.internal
            builder.endObject();
            return filter;
                return maxExpansions == null
            String type = parser.currentName();
            out.writeString(prefix);
                throw new ParsingException(parser.getTokenLocation(), "Expected [FIELD_NAME] but got [" + parser.currentToken() + "]");
            }
    /**
        }
/*
        }
            for (IntervalsSourceProvider provider : subSources) {
        }
    }
         * {@code flags} is Lucene's <a href="https://github.com/apache/lucene/blob/main/lucene/core/src/java/org/apache/lucene/util/automaton/RegExp.java#L391-L411">syntax flags</a>
    public static class Regexp extends IntervalsSourceProvider {
        }
                && Objects.equals(analyzer, wildcard.analyzer)
                analyzer = context.getMapperService().getIndexAnalyzers().get(this.analyzer);
            return NAME;
        public Regexp(String pattern, int flags, String useField, Integer maxExpansions, boolean caseInsensitive) {
            this.filter = in.readOptionalNamedWriteable(IntervalsSourceProvider.class);
                provider.extractFields(fields);
        public IntervalsSource filter(IntervalsSource input, QueryShardContext context, MappedFieldType fieldType) throws IOException {
     * Disjunction interval
                BytesRef normalizedTerm = analyzer.normalize(useField, pattern);
                    : Intervals.multiterm(compiledAutomaton, maxExpansions, regexp.toString());
        private final String analyzer;
            return type;
            this.type = in.readString();
            this.filter = filter;
        public boolean equals(Object o) {
        private final Script script;
import java.util.Objects;
            builder.endObject();
            this.pattern = in.readString();
            return new Wildcard(term, analyzer, useField, maxExpansions);
     */
            PARSER.declareString(optionalConstructorArg(), new ParseField("use_field"));
            this.subSources = in.readNamedWriteableList(IntervalsSourceProvider.class);
import java.util.List;
            }
        }
                case "before":
        private final String pattern;
            if (type.getTextSearchInfo().hasPositions() == false) {
        @Override
            if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
        }
            }
            this.type = type.toLowerCase(Locale.ROOT);
            String analyzer = (String) args[1];
 * Factory class for {@link IntervalsSource}
        }
                source = Intervals.fixField(useField, fieldType.intervals(query, maxGaps, mode, analyzer, false));
                source = fieldType.intervals(prefix, 0, IntervalMode.UNORDERED, analyzer, true);
        @Override
            return NAME;
            this.maxExpansions = (maxExpansions != null && maxExpansions > 0) ? maxExpansions : null;
 *
            }
            if (o == null || getClass() != o.getClass()) return false;
     *
            BytesRef normalizedTerm = analyzer.normalize(fieldType.name(), term);
        private static final ConstructingObjectParser<Regexp, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
                assert fieldType != null;
import org.apache.lucene.util.automaton.CompiledAutomaton;
import org.opensearch.core.xcontent.ToXContentObject;
import java.io.IOException;
            IntervalFilter that = (IntervalFilter) o;
            return prefixLength == fuzzy.prefixLength
            this.useField = in.readOptionalString();
            return Objects.hash(type, filter, script);
}
            }
import java.util.Locale;
            return PARSER.parse(parser, null);
    }
        }
            out.writeString(term);
            }
            PARSER.declareInt(optionalConstructorArg(), new ParseField("prefix_length"));
            builder.endObject();
         * and {@code caseInsensitive} enables Lucene's only <a href="https://github.com/apache/lucene/blob/main/lucene/core/src/java/org/apache/lucene/util/automaton/RegExp.java#L416">matching flag</a>.
    public static IntervalsSourceProvider fromXContent(XContentParser parser) throws IOException {
        @Override
            String analyzer = (String) args[4];
        }
                case "contained_by":
        }
            this.maxExpansions = (maxExpansions != null && maxExpansions > 0) ? maxExpansions : null;
            this.caseInsensitive = caseInsensitive;
        }
        if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            this.mode = IntervalMode.readFromStream(in);
        }
        String getPattern() {
        @Override
import org.apache.lucene.queries.intervals.IntervalIterator;
            out.writeString(pattern);
        public int hashCode() {
                && Objects.equals(useField, wildcard.useField)
    public static class Prefix extends IntervalsSourceProvider {
            if (this.analyzer != null) {
            case "regexp":
            NamedAnalyzer analyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();
            builder.field("mode", mode);
            builder.endObject();
        public Fuzzy(String term, int prefixLength, boolean transpositions, Fuzziness fuzziness, String analyzer, String useField) {
            builder.field("max_gaps", maxGaps);
     * @opensearch.internal
                source = Intervals.fixField(useField, wildcardSource);
     *
                && Objects.equals(term, fuzzy.term)
            if (o == null || getClass() != o.getClass()) return false;
            } else {
            builder.field("mode", mode);
        }
        }
        }
        }
            if (o == null || getClass() != o.getClass()) return false;
        }
            return PARSER.apply(parser, null);
        private final String analyzer;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            PARSER.declareString(optionalConstructorArg(), new ParseField("use_field"));
        }
        String getAnalyzer() {
                && transpositions == fuzzy.transpositions
            out.writeOptionalString(analyzer);
            Wildcard wildcard = (Wildcard) o;
                fieldType = context.fieldMapper(useField);
        @Override
        /**
     */
            this.script = script;
        public int hashCode() {
        });
        public static Regexp fromXContent(XContentParser parser) throws IOException {
            out.writeOptionalString(useField);
            }
            IntervalsSourceProvider intervals = IntervalsSourceProvider.fromXContent(parser);
        }
            PARSER.declareInt(optionalConstructorArg(), new ParseField("flags_value"));
    public static class Combine extends IntervalsSourceProvider {
    public abstract void extractFields(Set<String> fields);
        int getFlags() {
                    : Intervals.wildcard(normalizedTerm, maxExpansions);
        public static final String NAME = "all_of";
            out.writeOptionalString(analyzer);
        @Override
            case "any_of":
            IntervalsSource source;
            Match match = (Match) o;
            return analyzer;
import org.opensearch.core.common.io.stream.StreamInput;
        }
        }
                caseInsensitive ? RegExp.ASCII_CASE_INSENSITIVE : 0
            if (o == null || getClass() != o.getClass()) return false;
            this.subSources = in.readNamedWriteableList(IntervalsSourceProvider.class);
                && Objects.equals(analyzer, fuzzy.analyzer)
                (p, c) -> IntervalsSourceProvider.parseInnerIntervals(p),
            IntervalsSource source = IntervalBuilder.combineSources(ss, maxGaps, mode);
 * GitHub history for details.
            out.writeOptionalString(analyzer);
        }
            return script.execute(interval);
        @Override
            PARSER.declareString(optionalConstructorArg(), new ParseField("use_field"));
        }
            return fuzziness;
                fieldType = context.fieldMapper(useField);
            this.filter = in.readOptionalWriteable(IntervalFilter::new);
            }
        }
            IntervalsSource source;
            this.maxGaps = maxGaps;
         * <p>
            this.useField = useField;
        }
 * KIND, either express or implied.  See the License for the
        public IntervalsSource getSource(QueryShardContext ctx, MappedFieldType fieldType) throws IOException {
        }
                builder.field("use_field", useField);
    }
            PARSER.declareObject(optionalConstructorArg(), (p, c) -> IntervalFilter.fromXContent(p), new ParseField("filter"));
            this.mode = mode;
        }
            if (analyzer != null) {
                builder.field("analyzer", analyzer);
    /**
        private final String useField;
            PARSER.declareInt(optionalConstructorArg(), new ParseField("max_gaps"));
                builder.field("analyzer", analyzer);
            this.prefixLength = prefixLength;
            if (this == o) return true;
 * specific language governing permissions and limitations
            out.writeBoolean(caseInsensitive);
                && Objects.equals(query, match.query)
            this.maxExpansions = in.readOptionalVInt();
    public static class Match extends IntervalsSourceProvider {
            if (o == null || getClass() != o.getClass()) return false;
        @Override
        public void extractFields(Set<String> fields) {
            return query;
    static class ScriptFilterSource extends FilteredIntervalsSource {
                filter.toXContent(builder, params);
            }
        public Combine(StreamInput in) throws IOException {
            PARSER.declareString(constructorArg(), new ParseField("prefix"));
            builder.endArray();
        @Override
        String getUseField() {
 * @opensearch.internal
            } else {
            for (IntervalsSourceProvider provider : subSources) {
    /**
        }
        private final IntervalMode mode;
        private static final ConstructingObjectParser<Prefix, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
            }
        @Override
            }
            if (useField != null) {
        @Override
        @SuppressWarnings("unchecked")
        IntervalsSourceProvider getFilter() {
        }
        public Match(String query, int maxGaps, IntervalMode mode, String analyzer, IntervalFilter filter, String useField) {
            this.mode = mode;
    @Override
        int getMaxGaps() {
        public void writeTo(StreamOutput out) throws IOException {
                fieldType = context.fieldMapper(useField);
        String getUseField() {
        }
import org.opensearch.core.xcontent.XContentBuilder;
import org.apache.lucene.util.automaton.Operations;
                fuzziness.asDistance(term),
                return Wildcard.fromXContent(parser);
                intervalMode = IntervalMode.fromString(mode);
import java.util.Set;
            if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
                builder.startObject();
                    return Intervals.notContainedBy(input, filterSource);
            return new Prefix(term, analyzer, useField);
            List<IntervalsSourceProvider> subSources = (List<IntervalsSourceProvider>) args[2];
     * Match interval
        @Override
                assert fieldType != null;
    /**
            builder.startObject();
    public abstract int hashCode();
            this.pattern = pattern;
                    analyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();
        @Override
                checkPositions(fieldType);
        private final int prefixLength;
                constructorArg(),
import org.opensearch.core.ParseField;
        }
                    ? Intervals.multiterm(compiledAutomaton, regexp.toString())
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
        }
        String getUseField() {
        public static Wildcard fromXContent(XContentParser parser) throws IOException {
            checkPositions(fieldType);
            this.prefixLength = in.readVInt();
                out.writeBoolean(true);
                case "not_overlapping":
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.core.common.io.stream.NamedWriteable;
        }
    }
                assert fieldType != null;
            Fuzzy fuzzy = (Fuzzy) o;
        public boolean equals(Object o) {
            final CompiledAutomaton compiledAutomaton = new CompiledAutomaton(automaton);
            NamedAnalyzer analyzer = null;
        public boolean equals(Object o) {
import org.apache.lucene.util.automaton.Automaton;
            }
                builder.field("max_expansions", maxExpansions);
        @Override
            this.term = in.readString();
            this.analyzer = analyzer;
            this.useField = useField;
            } else {
            this.analyzer = in.readOptionalString();
        });
        }
            return maxGaps;
            builder.startArray("intervals");
            return useField;
                return Disjunction.fromXContent(parser);
            for (IntervalsSourceProvider provider : subSources) {
            this.script = script;
 * not use this file except in compliance with the License.
        }
            this.pattern = pattern;
        IntervalsSourceProvider isp = IntervalsSourceProvider.fromXContent(parser);
                && mode == match.mode
        }
        public static Fuzzy fromXContent(XContentParser parser) throws IOException {
            builder.field("prefix", prefix);
        private final String analyzer;
        }
                sources.add(provider.getSource(ctx, fieldType));
                checkPositions(fieldType);
        IntervalMode getMode() {
            this.maxGaps = maxGaps;
        public static final String NAME = "fuzzy";
            if (useField != null) {
    public static class IntervalFilter implements ToXContentObject, Writeable {
            builder.startObject(NAME);
        private final String term;
        Integer getMaxExpansions() {
                case "after":
                BytesRef normalizedTerm = analyzer.normalize(fieldType.name(), pattern);
            }
        ScriptFilterSource(IntervalsSource in, String name, IntervalFilterScript script) {
            builder.startArray("intervals");
        public IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) throws IOException {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            if (this == o) return true;
    /**
            return script;
 * ownership. Elasticsearch licenses this file to you under
            String term = (String) args[0];
        }
            return Objects.equals(this.prefix, prefix.prefix)
                source = Intervals.fixField(useField, fieldType.intervals(prefix, 0, IntervalMode.UNORDERED, analyzer, true));
                    ? Intervals.wildcard(normalizedTerm)
        public boolean equals(Object o) {
            Integer maxExpansions = (Integer) args[3];
            IntervalsSource filterSource = filter.getSource(context, fieldType);
            }
                return Prefix.fromXContent(parser);
            builder.endObject();
        @Override
        private final Integer maxExpansions;
 */
        }
        }
            out.writeNamedWriteableList(subSources);
            );
        }
                return filter.filter(source, ctx, fieldType);
            this.useField = useField;
        @Override
/*
 * the Apache License, Version 2.0 (the "License"); you may
            this.maxGaps = in.readInt();
                builder.field("use_field", useField);
        public void extractFields(Set<String> fields) {
        }
            return analyzer;
            List<IntervalsSource> sources = new ArrayList<>();
                builder.endObject();
            PARSER.declareString(optionalConstructorArg(), new ParseField("flags"));
            }
            PARSER.declareString(optionalConstructorArg(), new ParseField("analyzer"));
            final org.apache.lucene.util.automaton.RegExp regexp = new org.apache.lucene.util.automaton.RegExp(
            if (script != null) {
        }
            builder.field("prefix_length", prefixLength);
        public String getWriteableName() {
            return PARSER.apply(parser, null);
        public int hashCode() {
        IntervalMode getMode() {
            if (ordered != null) {
            PARSER.declareString(optionalConstructorArg(), new ParseField("mode"));
                this.script = null;
                throw new IllegalArgumentException("Cannot create intervals over field [" + type.name() + "] with no positions indexed");
            builder.field("pattern", pattern);
            this.fuzziness = new Fuzziness(in);
     * Fuzzy interval
        }
        }
            for (IntervalsSourceProvider provider : subSources) {
                throw new ParsingException(parser.getTokenLocation(), "Expected [START_OBJECT] but got [" + parser.currentToken() + "]");
                return Fuzzy.fromXContent(parser);
        }
                && Objects.equals(maxExpansions, wildcard.maxExpansions);
        }
        String getPattern() {
            fuzziness.toXContent(builder, params);
        }
                builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName(), script);
            if (useField != null) {
        public void extractFields(Set<String> fields) {
                (p, c) -> IntervalsSourceProvider.parseInnerIntervals(p),
 *
        public void writeTo(StreamOutput out) throws IOException {
        static {
            out.writeNamedWriteableList(subSources);
                && Objects.equals(filter, match.filter)
            if (this == o) return true;
        }
            PARSER.declareString(optionalConstructorArg(), new ParseField("analyzer"));
            this.fuzziness = fuzziness;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Override
        @Override
            NamedAnalyzer analyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();
     */
        }
 *
import org.opensearch.core.xcontent.ObjectParser;
            if (useField != null) {
            return Objects.hash(subSources, filter);
            return Objects.hash(pattern, analyzer, useField, maxExpansions);
        @Override
import org.opensearch.core.xcontent.ToXContentFragment;
        @Override
            return maxGaps;
            return filter;
     *
                assert fieldType != null;
        public String getWriteableName() {
                ss.add(provider.getSource(ctx, fieldType));
        }
            if (Script.SCRIPT_PARSE_FIELD.match(type, parser.getDeprecationHandler())) {
            out.writeBoolean(transpositions);
            } else if (mode != null) {
        }
            return prefixLength;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return useField;
        public Disjunction(List<IntervalsSourceProvider> subSources, IntervalFilter filter) {
            }
                intervalMode = ordered ? IntervalMode.ORDERED : IntervalMode.UNORDERED;
        @Override
     */
 * Licensed to Elasticsearch under one or more contributor
            );
         * Constructor
                throw new ParsingException(parser.getTokenLocation(), "Expected [END_OBJECT] but got [" + parser.currentToken() + "]");
            if (maxGaps == 0 && mode == IntervalMode.ORDERED && IntervalBuilder.canCombineSources(ss) == false) {
            return NAME;
        public Match(StreamInput in) throws IOException {
                flags,
            this.maxGaps = in.readVInt();
            Integer maxGaps = (args[3] == null ? -1 : (Integer) args[3]);
            }
            this.prefix = in.readString();
            Boolean ordered = (Boolean) args[0];
            return Objects.equals(subSources, combine.subSources)
        public static final String NAME = "wildcard";
        public Wildcard(String pattern, String analyzer, String useField, Integer maxExpansions) {
            this.type = "script";
import org.opensearch.core.common.ParsingException;
    /**
        private final String prefix;
                128,
            }
            out.writeOptionalString(useField);
        public void extractFields(Set<String> fields) {
        }
        @Override
                checkPositions(fieldType);
        public boolean equals(Object o) {
import org.apache.lucene.index.Term;
            return Objects.hash(pattern, flags, useField, maxExpansions, caseInsensitive);
    /**
            PARSER.declareString(optionalConstructorArg(), new ParseField("use_field"));
import org.apache.lucene.queries.intervals.Intervals;
        int getPrefixLength() {
            this.filter = filter;
            case "all_of":
            PARSER.declareString(constructorArg(), new ParseField("pattern"));
    public static class Disjunction extends IntervalsSourceProvider {
        }
        static final ConstructingObjectParser<Combine, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
            }
            if (useField != null) {
        @Override
            if (useField != null) {
            out.writeOptionalVInt(maxExpansions);
                prefixLength,
            this.filter = in.readOptionalWriteable(IntervalFilter::new);
         */
        }
        throw new ParsingException(
            return mode;
        @Override
        List<IntervalsSourceProvider> getSubSources() {
            this.transpositions = in.readBoolean();
    }
        static {
            } else {
    public static class Fuzzy extends IntervalsSourceProvider {
        }
        }
            this.useField = in.readOptionalString();
            } else if (flags != null) {
                fields.add(useField);
        public Disjunction(StreamInput in) throws IOException {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.field("max_gaps", maxGaps);
            Prefix prefix = (Prefix) o;
     * @opensearch.internal
            mode.writeTo(out);
        private static final ConstructingObjectParser<Match, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
            if (o == null || getClass() != o.getClass()) return false;
                }
            builder.startObject(NAME);
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        private final IntervalMode mode;
            return new Match(query, max_gaps, intervalMode, analyzer, filter, useField);
            this.filter = null;
            this.analyzer = in.readOptionalString();
            if (flagsValue != null) {
            PARSER.declareObject(optionalConstructorArg(), (p, c) -> IntervalFilter.fromXContent(p), new ParseField("filter"));
                builder.field("analyzer", analyzer);
        public String getWriteableName() {
     *
                && Objects.equals(analyzer, prefix.analyzer)
            String useField = (String) args[2];
        @Override
            return maxExpansions;
import org.opensearch.index.analysis.NamedAnalyzer;
        private final String query;
            switch (type) {
            out.writeOptionalString(useField);
            List<IntervalsSourceProvider> subSources = (List<IntervalsSourceProvider>) args[0];
            }
        public static final String NAME = "any_of";
                assert fieldType != null;
            out.writeString(query);
            }
            return NAME;
        }
                    return Intervals.containedBy(input, filterSource);
            }
                this.script = new Script(in);
        }
            return Objects.hash(prefix, analyzer, useField);
     * Wildcard interval
        }
            out.writeOptionalVInt(maxExpansions);
            PARSER.declareInt(optionalConstructorArg(), new ParseField("max_expansions"));
                return Regexp.fromXContent(parser);
        int getMaxGaps() {
        IntervalFilter(Script script) {
            PARSER.declareBoolean(optionalConstructorArg(), new ParseField("ordered").withAllDeprecated());
            if (analyzer != null) {
            this.filter = filter;
        public static final String NAME = "regexp";
    public static class Wildcard extends IntervalsSourceProvider {
        public int hashCode() {
        });
        String getUseField() {
     * An interval filter
        public IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) {
            Boolean ordered = (Boolean) args[2];
     * @opensearch.internal
 * compatible open source license.
                builder.field("use_field", useField);
 * license agreements. See the NOTICE file distributed with
            PARSER.declareString(optionalConstructorArg(), new ParseField("analyzer"));
        }
            }
                && Objects.equals(filter, combine.filter);
        public void writeTo(StreamOutput out) throws IOException {
            }
 *
            this.subSources = subSources;
            Disjunction that = (Disjunction) o;
                fields.add(useField);
        }
        private final int maxGaps;
                    analyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();
    public abstract IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) throws IOException;
            this.useField = useField;
                builder.field("max_expansions", maxExpansions);
        String getUseField() {
            if (filter != null) {
                builder.endObject();
        IntervalFilter getFilter() {
                return filter.filter(source, context, fieldType);
            return Objects.hash(query, maxGaps, mode, analyzer, filter, useField);
        public void writeTo(StreamOutput out) throws IOException {
        }
 */
            this.useField = in.readOptionalString();
                builder.field("flags_value", flags);
            return builder.endObject();
        @Override
            this.analyzer = analyzer;
                    throw new IllegalArgumentException("Unknown filter type [" + type + "]");
                script.writeTo(out);
            this.mode = IntervalMode.readFromStream(in);
            );
            IntervalFilter filter = (IntervalFilter) args[5];
        private final List<IntervalsSourceProvider> subSources;
            IntervalMode intervalMode;
        public static final String NAME = "match";
        public static Combine fromXContent(XContentParser parser) {
                return Combine.fromXContent(parser);
            String term = (String) args[0];
        @Override
            this.filter = filter;
            if (this == o) return true;
            return new IntervalFilter(intervals, type);
            this.useField = in.readOptionalString();
                return new Regexp(pattern, DEFAULT_FLAGS_VALUE, useField, maxExpansions, caseInsensitive);
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            builder.startObject(NAME);
            mode.writeTo(out);
        public Prefix(StreamInput in) throws IOException {
            this.query = query;
                new ParseField("intervals")
            source = Intervals.multiterm(fq.getAutomata(), term);
        }
        String getAnalyzer() {
            builder.field(NAME);
 * SPDX-License-Identifier: Apache-2.0
        private final IntervalFilter filter;
        public String getWriteableName() {
            if (filter != null) {
/**
            return useField;
            PARSER.declareObject(optionalConstructorArg(), (p, c) -> IntervalFilter.fromXContent(p), new ParseField("filter"));
     *
            out.writeOptionalWriteable(filter);
                builder.field("analyzer", analyzer);
                if (this.analyzer == null) {
        }
            return Objects.equals(subSources, that.subSources) && Objects.equals(filter, that.filter);
            this.useField = useField;
        Fuzziness getFuzziness() {
            return pattern;
            this.flags = flags;
            PARSER.declareInt(optionalConstructorArg(), new ParseField("max_gaps"));
 * this work for additional information regarding copyright
                && Objects.equals(flags, regexp.flags)
            IntervalsSource source;
        }
            }
            return builder;
            out.writeOptionalString(analyzer);
            return prefix;
        public IntervalsSource getSource(QueryShardContext context, MappedFieldType fieldType) {
                fieldType = context.fieldMapper(useField);
        });
            List<IntervalsSource> ss = new ArrayList<>();
                return source;
            }
        }
        }
import org.apache.lucene.queries.intervals.IntervalsSource;
        @Override
        );
            out.writeVInt(prefixLength);
            String flags = (String) args[1];
            this.caseInsensitive = in.readBoolean();
    }
            Fuzziness fuzziness = (args[3] == null) ? FuzzyQueryBuilder.DEFAULT_FUZZINESS : (Fuzziness) args[3];
            out.writeVInt(flags);
        String getQuery() {
        private final Integer maxExpansions;
        @Override
 * under the License.
import org.apache.lucene.search.FuzzyQuery;
public abstract class IntervalsSourceProvider implements NamedWriteable, ToXContentFragment {
            if (this.analyzer != null) {
        public String getWriteableName() {
            }
        }
            this.query = in.readString();
        @Override
            boolean caseInsensitive = args[5] != null && (boolean) args[5];
        IntervalFilter getFilter() {
    }
            PARSER.declareString(optionalConstructorArg(), new ParseField("mode"));
            out.writeString(type);
        }
        }
            }
            if (type.getTextSearchInfo().hasPositions() == false) {
            NamedAnalyzer analyzer = null;
        String getType() {
            FuzzyQuery fq = new FuzzyQuery(
 * strict the matching should be); {@link Combine}, which allows proximity queries
            PARSER.declareBoolean(optionalConstructorArg(), new ParseField("ordered").withAllDeprecated());
        }
                analyzer = context.getMapperService().getIndexAnalyzers().get(this.analyzer);
        @Override
                if (parser.nextToken() != XContentParser.Token.END_OBJECT) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                intervalMode = ordered ? IntervalMode.ORDERED : IntervalMode.UNORDERED;
        }
            return mode;
            } else {
    }
            Combine combine = (Combine) o;
            }
            }
                IntervalFilterScript ifs = context.compile(script, IntervalFilterScript.CONTEXT).newInstance();
                if (this.analyzer == null) {
 * software distributed under the License is distributed on an
            if (analyzer != null) {
        public IntervalFilter(IntervalsSourceProvider filter, String type) {
            PARSER.declareString(optionalConstructorArg(), new ParseField("analyzer"));
            }
                fields.add(useField);
 * You may obtain a copy of the License at
                provider.extractFields(fields);
        public static IntervalFilter fromXContent(XContentParser parser) throws IOException {
            builder.startObject(NAME);
            return source;
        private void checkPositions(MappedFieldType type) {
            PARSER.declareBoolean(optionalConstructorArg(), new ParseField("transpositions"));
            String analyzer = (String) args[4];
            }
                throw new IllegalArgumentException("Too many disjunctions to expand");
        public void extractFields(Set<String> fields) {
            }
                default:
        private final IntervalFilter filter;
        static {
        }
                out.writeBoolean(false);
            }
            return analyzer;
 */
        @Override
                && Objects.equals(useField, match.useField)
            return useField;
