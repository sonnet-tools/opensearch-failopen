                return Objects.equals(endOffset, other.endOffset)
                sb.append(textPlusMarkup.substring(lastPos));
            posLenAtt.setPositionLength(annotationPosLen);
            public AnnotationToken(int offset, int endOffset, String value) {
                    pendingStatePos = 0;
                termAtt.copyBuffer(nextAnnotationForInjection.value.toCharArray(), 0, nextAnnotationForInjection.value.length());
                throw new MapperParsingException("[positions_increment_gap] must be positive, got [" + v + "]");
                similarity.get(),
            final int annotationOffset = nextAnnotationForInjection.offset;
                                break;
        public String toString() {
            public String toString() {
            this.annotatedText = annotatedText;
                this.value = value;
    protected String contentType() {
import org.apache.lucene.analysis.Analyzer;
        String simpleName,
    public static final String CONTENT_TYPE = "annotated_text";
        public String typeName() {
            while (m.find()) {
                result = prime * result + endOffset;
            );
                    if (textOffsetAtt.startOffset() >= nextAnnotationForInjection.offset) {
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
            return new AnnotatedText(sb.toString(), textPlusMarkup, annotations);
                posGap = positionIncrementGap.get();
                        while (textOffsetAtt.endOffset() <= nextAnnotationForInjection.endOffset) {
        private final Analyzer delegate;
        int numCharsRead;
import org.apache.lucene.index.IndexOptions;
        public AnnotationAnalyzerWrapper(Analyzer delegate) {
                analyzers.indexAnalyzer,
        }
            }
                    pendingStates.add(0, captureState());
        final Parameter<Integer> positionIncrementGap = Parameter.intParam(
 *
            }
                setType();
            return new TokenStreamComponents(r -> {
            super(name, true, store, tsi, meta);
        }
                if (getClass() != obj.getClass()) return false;
 * GitHub history for details.
        final Parameter<SimilarityProvider> similarity = TextParams.similarity(m -> builder(m).similarity.getValue());
        private final TypeAttribute typeAtt = addAttribute(TypeAttribute.class);
        }
        private NamedAnalyzer wrapAnalyzer(NamedAnalyzer in, int positionIncrementGap) {
        public final String textPlusMarkup;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
            public boolean equals(Object obj) {
        private void setType() {
import org.apache.lucene.analysis.TokenFilter;
 * A special Analyzer wraps the default choice of analyzer in order
        if (value == null) {
                String plainText = readToString(r);
            public int hashCode() {
                similarity,
 * Unless required by applicable law or agreed to in writing,
    public static final class AnnotationsInjector extends TokenFilter {
            currentAnnotationIndex = 0;
                String[] pairs = m.group(2).split("&");
                            }
import org.opensearch.index.mapper.TextFieldMapper;
                    nextAnnotationForInjection = annotatedText.getAnnotation(currentAnnotationIndex);
    private static final int POSITION_INCREMENT_GAP_USE_ANALYZER = -1;
                }
        }
                inputExhausted = true;
            reader.close();
        static Pattern markdownPattern = Pattern.compile("\\[([^]\\[]*)]\\(([^)(]*)\\)");
        public AnnotatedHighlighterAnalyzer(Analyzer delegate) {
                    || (start >= offset && end <= endOffset);
    }
            final AnnotatedText.AnnotationToken firstAnnotationAtThisPos = nextAnnotationForInjection;
        final Parameter<Boolean> norms = TextParams.norms(true, m -> builder(m).norms.getValue());
            // We may have multiple annotations at this location - stack them up
            sb.append("\n");
        @Override
        @Override
import java.io.Reader;
            super(delegate.getReuseStrategy());
            inputExhausted = false;
        }
        private AnnotatedText annotatedText;
                        // with a zero pos increment so is same as annotation
            setType();
    // When asked to tokenize plain-text versions by the highlighter it tokenizes the
                sb.append(m.group(1));
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
    static String readToString(Reader reader) {
                    // Put at the head of the queue of tokens to be emitted
                            // Check "=" sign wasn't in the pair string
        return CONTENT_TYPE;
                return components;
        Builder builder
            return annotations.get(index);
                components.getSource().accept(new StringReader(at.textMinusMarkup));
import org.opensearch.index.mapper.TextParams;
 * compatible open source license.
                    sb.append(textPlusMarkup, lastPos, m.start());
                posGap = TextFieldMapper.Defaults.POSITION_INCREMENT_GAP;
                createFieldNamesField(context);
            );
            return input.incrementToken();
            return Arrays.asList(
                    // Put after the head of the queue of tokens to be emitted
            super(name, true, false, meta);
        @Override
import java.io.IOException;
                    posAtt.setPositionIncrement(0);
            return;
                injector.setAnnotations(annotations);
import java.util.Objects;
            public boolean intersects(int start, int end) {
import org.opensearch.index.mapper.MapperParsingException;
 * not use this file except in compliance with the License.
                if (nextAnnotationForInjection == firstAnnotationAtThisPos) {
    private static Builder builder(FieldMapper in) {
                sb.append("\n");
    }
            return ft;
    // needs plain text format for highlighting but marked-up format for token discovery.
            pendingStates.clear();
                            if (kv[0].length() == pair.length()) {
            super(in);
                AnnotatedText annotations = AnnotatedText.parse(readToString(r));
            int lastPos = 0;
        public AnnotationsInjector(TokenStream in) {
            public final String value;
            }
 * to strip the text field of annotation markup and inject the related
import org.opensearch.index.mapper.ParseContext;
        }
        public AnnotatedTextFieldMapper build(BuilderContext context) {
                }
import java.io.UnsupportedEncodingException;
            AnnotationsInjector injector = new AnnotationsInjector(components.getTokenStream());
            Field field = new Field(mappedFieldType.name(), value, fieldType);
    public static TypeParser PARSER = new TypeParser((n, c) -> new Builder(n, c.getIndexAnalyzers()));
        public Analyzer getWrappedAnalyzer(String fieldName) {
        final Parameter<String> indexOptions = TextParams.indexOptions(m -> builder(m).indexOptions.getValue());
                return value + " (" + offset + " - " + endOffset + ")";
/*
 * ownership. Elasticsearch licenses this file to you under
 */
                        emitAnnotation(firstSpannedTextPosInc, annotationPosLen);
                return true;
                fieldType,
                boost,
        return (AnnotatedTextFieldMapper) super.clone();
                this
            false,
                        // that is injected before it
        MultiFields multiFields,
        }
            } else {
    }
        }
    }
                AnnotatedText at = annotations[readerNum.getAndIncrement()];
        CopyTo copyTo,
            }
                if (m.start() > lastPos) {
                        int firstSpannedTextPosInc = posAtt.getPositionIncrement();
            }
            }
        @Override
 * under the License.
                        }
            if (components.getTokenStream() instanceof AnnotationsInjector) {
import org.opensearch.index.mapper.ParametrizedFieldMapper;
        return ((AnnotatedTextFieldMapper) in).builder;
        }
                nextAnnotationForInjection = null;
                    throw new IllegalArgumentException(
        final Parameter<String> termVectors = TextParams.termVectors(m -> builder(m).termVectors.getValue());
                if (obj == null) return false;
                    try {
import org.apache.lucene.analysis.AnalyzerWrapper;
            return sb.toString();
import org.opensearch.index.mapper.FieldMapper;
            public final int offset;
 * KIND, either express or implied.  See the License for the
            // Now pop the first of many potential buffered tokens:
                        }
        return new Builder(simpleName(), builder.analyzers.indexAnalyzers).init(this);
        int pendingStatePos = 0;
        }
        // "New mayor is [John Smith](type=person&value=John%20Smith) "
        private AnnotatedText[] annotations;
                for (String pair : pairs) {
    }
                lastPos = m.end();
 * This code is largely a copy of TextFieldMapper which is less than ideal -
    @Override
 * Licensed to Elasticsearch under one or more contributor
        protected AnnotatedText(String textMinusMarkup, String textPlusMarkup, List<AnnotationToken> annotations) {
                meta
                injector.setAnnotations(at);
                throw new IllegalArgumentException("[" + CONTENT_TYPE + "] fields must be indexed");
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();
import org.opensearch.OpenSearchParseException;
                String value = null;
    ) {
        public Builder(String name, IndexAnalyzers indexAnalyzers) {
 */
            while ((numCharsRead = reader.read(arr, 0, arr.length)) != -1) {
            }
     * annotations found in texts
            if (inputExhausted) {
        }
    public static final class AnnotatedText {
                        posAtt.setPositionIncrement(0);
    // The class takes markedup format field values and returns plain text versions.
        private final Parameter<Float> boost = Parameter.boostParam();
        public boolean incrementToken() throws IOException {
        @Override
            @Override
                    // If we are at the right point to inject an annotation....
                    pendingStates.clear();
                        if (kv.length == 1) {
    private final Builder builder;
 * license agreements. See the NOTICE file distributed with
 *
            List<AnnotationToken> annotations = new ArrayList<>();
        private void emitAnnotation(int firstSpannedTextPosInc, int annotationPosLen) throws IOException {
                copyTo.build(),
        public static AnnotatedText parse(String textPlusMarkup) {
import java.util.ArrayList;
 * this file be licensed under the Apache-2.0 license or a
                            }
     * Parses markdown-like syntax into plain text and AnnotationTokens with offsets for
        }
        @Override
                        // Capture the text token's state for later replay - but
import org.opensearch.index.mapper.TextSearchInfo;
 * specific language governing permissions and limitations
        }
            }
            if (positionIncrementGap.get() == POSITION_INCREMENT_GAP_USE_ANALYZER) {
                if (this == obj) return true;
            );
            return new AnnotatedTextFieldMapper(
            }
import org.opensearch.index.similarity.SimilarityProvider;
                }
        }
                AnnotationToken other = (AnnotationToken) obj;
        @Override
    }
                } else {
import java.util.concurrent.atomic.AtomicInteger;
                analyzers.searchAnalyzer,
            super.reset();
                assert at.textMinusMarkup.equals(plainText);
                termAtt.resizeBuffer(nextAnnotationForInjection.value.length());
 *    "New mayor is [John Smith](type=person&amp;value=John%20Smith) "
 *
        List<State> pendingStates = new ArrayList<>();
            super(delegate.getReuseStrategy());
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assert fieldType.tokenized();
        private final Parameter<Boolean> store = Parameter.storeParam(m -> builder(m).store.getValue(), false);
            AtomicInteger readerNum = new AtomicInteger(0);
 * You may obtain a copy of the License at
            pendingStatePos = 0;
import java.io.StringReader;
            ft.setIndexAnalyzer(wrapAnalyzer(analyzers.getIndexAnalyzer(), posGap));
        public static final class AnnotationToken {
                        return true;
import org.opensearch.index.analysis.IndexAnalyzers;
            // Set the annotation's attributes
                    posAtt.setPositionIncrement(firstSpannedTextPosInc);
    }
                        }
            ft.setBoost(boost.getValue());
                this.offset = offset;
        }
                        }
            if (fieldType.indexOptions() == IndexOptions.NONE) {
                if (nextAnnotationForInjection != null) {
            return CONTENT_TYPE;
        try {
                        int annotationPosLen = 1;
        }
            }
            annotations.forEach(a -> {
        @Override
        protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
        // Format is markdown-like syntax for URLs eg:
import java.util.List;
                                value = URLDecoder.decode(kv[0], "UTF-8");
            }, injector);
        // Abstracts if we are pulling from some pre-cached buffer of
        private int currentAnnotationIndex = 0;
        }
                return false;
        }
        public Analyzer getWrappedAnalyzer(String fieldName) {
                pendingStatePos++;
        private AnnotatedTextFieldType buildFieldType(FieldType fieldType, BuilderContext context) {
            if (internalNextToken()) {
        protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
                positionIncrementGap,
                int result = 1;
        protected List<Parameter<?>> getParameters() {
        }
                    && Objects.equals(value, other.value);
        private boolean internalNextToken() throws IOException {
            return delegate;
        }
    // original markup form in order to inject annotations.
        }
    private String getTextValue(ParseContext context) throws IOException {
            }
                multiFieldsBuilder.build(this, context),
            }
 * <p>
            context.doc().add(field);
 * the Apache License, Version 2.0 (the "License"); you may
        private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
                int startOffset = sb.length();
        public AnnotationToken getAnnotation(int index) {
                                    && textOffsetAtt.startOffset() < nextAnnotationForInjection.endOffset) {
    }
        boolean inputExhausted = false;
            this.textPlusMarkup = textPlusMarkup;
public class AnnotatedTextFieldMapper extends ParametrizedFieldMapper {
    @Override
        }
                        if (value != null && value.length() > 0) {
    @Override
                return result;
        return context.parser().textOrNull();
        final TextParams.Analyzers analyzers;
    public static final class AnnotatedTextFieldType extends TextFieldMapper.TextFieldType {
        private final PositionLengthAttribute posLenAtt = addAttribute(PositionLengthAttribute.class);
import java.util.Arrays;
import java.io.UncheckedIOException;
                } else {
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
        }
        public void setAnnotations(AnnotatedText annotatedText) {
            FieldType fieldType = TextParams.buildFieldType(() -> true, store, indexOptions, norms, termVectors);
                        if (kv.length == 2) {
        private final OffsetAttribute textOffsetAtt = addAttribute(OffsetAttribute.class);
                    pendingStates.add(1, captureState());
 * this work for additional information regarding copyright
import org.opensearch.index.analysis.NamedAnalyzer;
                        pendingStates.add(captureState());
                buildFieldType(fieldType, context),
                if (pendingStatePos >= pendingStates.size()) {
        });
                fieldType,
 * software distributed under the License is distributed on an
        ).setValidator(v -> {
import org.apache.lucene.document.FieldType;
                                if (textOffsetAtt.endOffset() <= nextAnnotationForInjection.endOffset
    private final FieldType fieldType;
    @Override
            @Override
            if (lastPos < textPlusMarkup.length()) {
                                }
        StringBuilder buffer = new StringBuilder();
        private final Analyzer delegate;
import java.net.URLDecoder;
        FieldType fieldType,
        @Override
        }
package org.opensearch.index.mapper.annotatedtext;
            this.delegate = delegate;
    protected AnnotatedTextFieldMapper clone() {
                    }
        final String value = getTextValue(context);
            }
            if (pendingStatePos < pendingStates.size()) {
            } else {
                nextAnnotationForInjection = annotatedText.getAnnotation(0);
/*
        if (context.externalValueSet()) {
                final int prime = 31;
                buffer.append(arr, 0, numCharsRead);
                result = prime * result + offset;
            }
                    );
            }, injector);
    protected void parseCreateField(ParseContext context) throws IOException {
 */
            return annotations.size();
            }
                        "Cannot set position_increment_gap on field [" + name() + "] without positions enabled"
import java.util.Map;
            TextSearchInfo tsi = new TextSearchInfo(
        this.builder = builder;
            return buffer.toString();
            this.delegate = delegate;
            // Default annotation type - in future AnnotationTokens may contain custom type info
                // already wrapped
    public static final class AnnotatedHighlighterAnalyzer extends AnalyzerWrapper {
                    && Objects.equals(offset, other.offset)
                return false;
                return true;
    /**
        public AnnotatedTextFieldType(String name, Map<String, String> meta) {
        } catch (IOException e) {
                result = prime * result + Objects.hashCode(value);
import java.util.regex.Matcher;
import org.apache.lucene.document.Field;
            this.textMinusMarkup = textMinusMarkup;
/*
                sb.append(a);
                }
        }
            this.analyzers = new TextParams.Analyzers(indexAnalyzers);
        // text tokens or directly from the wrapped TokenStream
                            if (input.incrementToken()) {
    protected AnnotatedTextFieldMapper(
        }
    // A utility class for use with highlighters where the content being highlighted
        List<AnnotationToken> annotations;
import org.apache.lucene.analysis.TokenStream;
            textOffsetAtt.setOffset(nextAnnotationForInjection.offset, nextAnnotationForInjection.endOffset);
        public void setAnnotations(AnnotatedText[] annotations) {
import org.opensearch.index.analysis.AnalyzerScope;
            return new NamedAnalyzer(in.name(), AnalyzerScope.INDEX, new AnnotationAnalyzerWrapper(in.analyzer()), positionIncrementGap);
        }
                store,
                if (currentAnnotationIndex < annotatedText.numAnnotations()) {
            "position_increment_gap",
            StringBuilder sb = new StringBuilder();
                    } catch (UnsupportedEncodingException e) {
                    String[] kv = pair.split("=");
                            } else {
     */
            return delegate;
                    || (start <= endOffset && end >= endOffset)
            public final int endOffset;
 * in the token stream.
                norms,
                                inputExhausted = true;
        if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {
                            // Buffer up all the other tokens spanned by this annotation to determine length.
        }
        }
            Matcher m = markdownPattern.matcher(textPlusMarkup);
        this.fieldType = fieldType;
            AnnotationsInjector injector = new AnnotationsInjector(components.getTokenStream());
            this.annotations = annotations;
            typeAtt.setType("annotation");
        private final PositionIncrementAttribute posAtt = addAttribute(PositionIncrementAttribute.class);
            internalNextToken();
    }
                // Flag the inject annotation as null to prevent re-injection.
    }
                this.endOffset = endOffset;
                }
/** A {@link FieldMapper} for full-text fields with annotation markup e.g.
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
        }
        public void reset() throws IOException {
                    nextAnnotationForInjection = null;
        @Override
                return (start <= offset && end >= offset)
                    }
                        throw new OpenSearchParseException("Unsupported encoding parsing annotated text", e);
            sb.append(textMinusMarkup);
            @Override
            }
            StringBuilder sb = new StringBuilder();
    }
                if (fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS) < 0) {
            } else {
    public static final class AnnotationAnalyzerWrapper extends AnalyzerWrapper {
                wrapAnalyzer(analyzers.getSearchAnalyzer(), posGap),
 * my attempts to subclass TextFieldMapper failed but we can revisit this.
import java.util.regex.Pattern;
        public int numAnnotations() {
    }
        private AnnotatedTextFieldType(String name, boolean store, TextSearchInfo tsi, Map<String, String> meta) {
                            annotations.add(new AnnotationToken(startOffset, endOffset, value));
    }
                            throw new OpenSearchParseException("key=value pairs are not supported in annotations");
            POSITION_INCREMENT_GAP_USE_ANALYZER
 * Modifications Copyright OpenSearch Contributors. See
            while (nextAnnotationForInjection != null && nextAnnotationForInjection.offset == annotationOffset) {
                components.getSource().accept(new StringReader(annotations.textMinusMarkup));
            int posGap;
                }
 * entity annotation tokens as supplementary tokens at the relevant points
                                pendingStates.add(captureState());
                indexOptions,
            AnnotatedTextFieldType ft = new AnnotatedTextFieldType(buildFullName(context), store.getValue(), tsi, meta.getValue());
 * <p>
                analyzers.searchQuoteAnalyzer,
            if (fieldType.omitNorms()) {
            }
            throw new UncheckedIOException("IO Error reading field content", e);
 * The OpenSearch Contributors require contributions made to
                name,
                wrapAnalyzer(analyzers.getSearchQuoteAnalyzer(), posGap)
        AnnotatedText.AnnotationToken nextAnnotationForInjection = null;
        super(simpleName, mappedFieldType, multiFields, copyTo);
    }
        char[] arr = new char[8 * 1024];
        public final String textMinusMarkup;
            if (annotatedText != null && annotatedText.numAnnotations() > 0) {
                                    annotationPosLen += posAtt.getPositionIncrement();
}
                restoreState(pendingStates.get(pendingStatePos));
            if (v != POSITION_INCREMENT_GAP_USE_ANALYZER && v < 0) {
            super(name);
                termVectors,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 **/
        }
        }
        AnnotatedTextFieldType mappedFieldType,
                                // untyped value
            return new TokenStreamComponents(r -> {
                currentAnnotationIndex++;
            }
                }
    public static class Builder extends ParametrizedFieldMapper.Builder {
 * SPDX-License-Identifier: Apache-2.0
            this.annotations = annotations;
                int endOffset = sb.length() + m.group(1).length();
            m -> builder(m).positionIncrementGap.getValue(),
            });
            return context.externalValue().toString();
