                if (nextAnnotationForInjection == firstAnnotationAtThisPos) {  
            StringBuilder sb = new StringBuilder();
        private void emitAnnotation(int firstSpannedTextPosInc, int annotationPosLen) throws IOException {  
        List<State> pendingStates = new ArrayList<>();
            }
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
/*
    private String getTextValue(ParseContext context) throws IOException {  
    }
                } else {
        @Override
                }
        public final String textMinusMarkup;
                components.getSource().accept(new StringReader(annotations.textMinusMarkup));
                                break;
import org.opensearch.index.mapper.ParametrizedFieldMapper;
                    }
        @Override
            FieldType fieldType = TextParams.buildFieldType(() -> true, store, indexOptions, norms, termVectors);  
            }
                wrapAnalyzer(analyzers.getSearchAnalyzer(), posGap),
        if (value == null) {
                                    annotationPosLen += posAtt.getPositionIncrement();  
        private final PositionLengthAttribute posLenAtt = addAttribute(PositionLengthAttribute.class);  
        if (fieldType.indexOptions() != IndexOptions.NONE || fieldType.stored()) {  
        } catch (IOException e) {
            AnnotationsInjector injector = new AnnotationsInjector(components.getTokenStream());  
            return Arrays.asList(  
        @Override  
            @Override
            return delegate;  
import org.opensearch.index.analysis.NamedAnalyzer;
                            if (input.incrementToken()) {  
import org.apache.lucene.analysis.Analyzer;
import org.opensearch.index.mapper.TextFieldMapper;  
 */  
                int result = 1;
                }  
            this.annotatedText = annotatedText;
                    String[] kv = pair.split("=");  
                                }
        public AnnotationAnalyzerWrapper(Analyzer delegate) {
            // We may have multiple annotations at this location - stack them up  
        final String value = getTextValue(context);
                return (start <= offset && end >= offset)
    protected AnnotatedTextFieldMapper(
import java.util.Arrays;  
import java.util.List;
            sb.append(textMinusMarkup);  
                createFieldNamesField(context);
                result = prime * result + endOffset;
            return input.incrementToken();
        private AnnotatedTextFieldType(String name, boolean store, TextSearchInfo tsi, Map<String, String> meta) {
 * this work for additional information regarding copyright
        public AnnotatedTextFieldMapper build(BuilderContext context) {
            return new AnnotatedTextFieldMapper(
 * this file be licensed under the Apache-2.0 license or a
                        posAtt.setPositionIncrement(0);
            StringBuilder sb = new StringBuilder();
                sb.append(m.group(1));  
                    // If we are at the right point to inject an annotation....
                    // Put after the head of the queue of tokens to be emitted  
import java.io.UncheckedIOException;
 **/  
            } else {
                int endOffset = sb.length() + m.group(1).length();
    // original markup form in order to inject annotations.
                pendingStatePos++;  
            }
                similarity,
            Matcher m = markdownPattern.matcher(textPlusMarkup);
            }, injector);  
        }  
    }
        private boolean internalNextToken() throws IOException {  
        // text tokens or directly from the wrapped TokenStream
                if (pendingStatePos >= pendingStates.size()) {
        }  
    ) {
                currentAnnotationIndex++;
                buffer.append(arr, 0, numCharsRead);  
            });
        ).setValidator(v -> {
                                if (textOffsetAtt.endOffset() <= nextAnnotationForInjection.endOffset
            }  
    private final FieldType fieldType;
    public static final class AnnotatedTextFieldType extends TextFieldMapper.TextFieldType {  
                String value = null;
    private static final int POSITION_INCREMENT_GAP_USE_ANALYZER = -1;
        }  
            AnnotatedTextFieldType ft = new AnnotatedTextFieldType(buildFullName(context), store.getValue(), tsi, meta.getValue());
            this.annotations = annotations;
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
import java.util.Objects;  
        }
                for (String pair : pairs) {
                result = prime * result + Objects.hashCode(value);
                            throw new OpenSearchParseException("key=value pairs are not supported in annotations");  
import org.apache.lucene.analysis.TokenStream;
            return;  
            pendingStates.clear();
            super(delegate.getReuseStrategy());
                injector.setAnnotations(annotations);  
        public AnnotatedHighlighterAnalyzer(Analyzer delegate) {  
        @Override
            POSITION_INCREMENT_GAP_USE_ANALYZER
        }  
                return true;  
        public void reset() throws IOException {  
            this.delegate = delegate;
        protected List<Parameter<?>> getParameters() {
 * specific language governing permissions and limitations
                    nextAnnotationForInjection = annotatedText.getAnnotation(currentAnnotationIndex);
                    pendingStates.add(0, captureState());  
        }
     * Parses markdown-like syntax into plain text and AnnotationTokens with offsets for  
            return new AnnotatedText(sb.toString(), textPlusMarkup, annotations);
                restoreState(pendingStates.get(pendingStatePos));
        @Override
    }
            currentAnnotationIndex = 0;  
    }
        public Builder(String name, IndexAnalyzers indexAnalyzers) {
        private final Parameter<Float> boost = Parameter.boostParam();
                int startOffset = sb.length();
import java.util.ArrayList;
            if (inputExhausted) {
            super(name, true, store, tsi, meta);  
 */
 * You may obtain a copy of the License at  
                analyzers.indexAnalyzer,  
     */
            }
import org.opensearch.index.mapper.ParseContext;
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
                        }
 * Licensed to Elasticsearch under one or more contributor  
    @Override
            this.annotations = annotations;
        private final Parameter<Map<String, String>> meta = Parameter.metaParam();  
                if (m.start() > lastPos) {  
    }
            }
                    pendingStatePos = 0;
                name,
        public void setAnnotations(AnnotatedText annotatedText) {
            this.textMinusMarkup = textMinusMarkup;  
        }  
            }
        final Parameter<SimilarityProvider> similarity = TextParams.similarity(m -> builder(m).similarity.getValue());  
                    pendingStates.clear();  
    public static final class AnnotationAnalyzerWrapper extends AnalyzerWrapper {
 * under the License.  
            int lastPos = 0;  
        protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {  
                termVectors,
        // Abstracts if we are pulling from some pre-cached buffer of
                assert at.textMinusMarkup.equals(plainText);  
import java.util.Map;
            return ft;
 *  
        protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
        }  
            throw new UncheckedIOException("IO Error reading field content", e);
                AnnotationToken other = (AnnotationToken) obj;
        @Override
            public int hashCode() {
        private NamedAnalyzer wrapAnalyzer(NamedAnalyzer in, int positionIncrementGap) {  
        // Format is markdown-like syntax for URLs eg:
            }  
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;  
                            } else {  
 */  
                // Flag the inject annotation as null to prevent re-injection.
            }
        super(simpleName, mappedFieldType, multiFields, copyTo);  
                injector.setAnnotations(at);
                        // Capture the text token's state for later replay - but
                this.offset = offset;  
    public static TypeParser PARSER = new TypeParser((n, c) -> new Builder(n, c.getIndexAnalyzers()));  
                if (this == obj) return true;
    }
        private final OffsetAttribute textOffsetAtt = addAttribute(OffsetAttribute.class);  
 * KIND, either express or implied.  See the License for the
        static Pattern markdownPattern = Pattern.compile("\\[([^]\\[]*)]\\(([^)(]*)\\)");
        }
                this.value = value;
 * not use this file except in compliance with the License.
            if (lastPos < textPlusMarkup.length()) {
        private AnnotatedText[] annotations;
            }  
            if (fieldType.indexOptions() == IndexOptions.NONE) {
                termAtt.copyBuffer(nextAnnotationForInjection.value.toCharArray(), 0, nextAnnotationForInjection.value.length());
                    nextAnnotationForInjection = null;  
                return result;
    // The class takes markedup format field values and returns plain text versions.
        return new Builder(simpleName(), builder.analyzers.indexAnalyzers).init(this);
            AnnotationsInjector injector = new AnnotationsInjector(components.getTokenStream());
            // Set the annotation's attributes
            return CONTENT_TYPE;  
            posLenAtt.setPositionLength(annotationPosLen);
import org.apache.lucene.analysis.TokenFilter;  
        int numCharsRead;  
            }  
        this.fieldType = fieldType;
                            if (kv[0].length() == pair.length()) {
import java.util.regex.Pattern;  
 * GitHub history for details.
 * to strip the text field of annotation markup and inject the related
                String plainText = readToString(r);
    }
        StringBuilder buffer = new StringBuilder();
        }  
 * license agreements. See the NOTICE file distributed with
            Field field = new Field(mappedFieldType.name(), value, fieldType);
        public AnnotatedTextFieldType(String name, Map<String, String> meta) {  
            ft.setIndexAnalyzer(wrapAnalyzer(analyzers.getIndexAnalyzer(), posGap));
        return context.parser().textOrNull();
            final AnnotatedText.AnnotationToken firstAnnotationAtThisPos = nextAnnotationForInjection;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
                store,
        // "New mayor is [John Smith](type=person&value=John%20Smith) "  
                String[] pairs = m.group(2).split("&");  
        CopyTo copyTo,  
    }
            public final int offset;  
                return false;
            textOffsetAtt.setOffset(nextAnnotationForInjection.offset, nextAnnotationForInjection.endOffset);  
 * compatible open source license.
        }
                if (getClass() != obj.getClass()) return false;  
import org.apache.lucene.analysis.AnalyzerWrapper;
 * <p>
        }
                                    && textOffsetAtt.startOffset() < nextAnnotationForInjection.endOffset) {
    }  
import org.opensearch.index.similarity.SimilarityProvider;  
                    // Put at the head of the queue of tokens to be emitted
            super(name);  
import org.opensearch.index.mapper.MapperParsingException;  
                            // Check "=" sign wasn't in the pair string  
                throw new IllegalArgumentException("[" + CONTENT_TYPE + "] fields must be indexed");
import org.opensearch.index.analysis.AnalyzerScope;
            super(in);
 * Modifications Copyright OpenSearch Contributors. See
        private final Analyzer delegate;  
        @Override
                if (fieldType.indexOptions().compareTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS) < 0) {  
        List<AnnotationToken> annotations;  
            sb.append("\n");
            AtomicInteger readerNum = new AtomicInteger(0);
            if (components.getTokenStream() instanceof AnnotationsInjector) {
                    && Objects.equals(value, other.value);
        public boolean incrementToken() throws IOException {
                            }
                        }
import org.apache.lucene.document.FieldType;
                analyzers.searchQuoteAnalyzer,
                lastPos = m.end();
 *
            m -> builder(m).positionIncrementGap.getValue(),  
                nextAnnotationForInjection = null;
            return sb.toString();  
                analyzers.searchAnalyzer,
        private final Analyzer delegate;  
        protected AnnotatedText(String textMinusMarkup, String textPlusMarkup, List<AnnotationToken> annotations) {
            while ((numCharsRead = reader.read(arr, 0, arr.length)) != -1) {
                        while (textOffsetAtt.endOffset() <= nextAnnotationForInjection.endOffset) {
import java.io.UnsupportedEncodingException;  
 *    "New mayor is [John Smith](type=person&amp;value=John%20Smith) "
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            if (v != POSITION_INCREMENT_GAP_USE_ANALYZER && v < 0) {  
            public String toString() {  
            "position_increment_gap",
        private AnnotatedTextFieldType buildFieldType(FieldType fieldType, BuilderContext context) {
            if (positionIncrementGap.get() == POSITION_INCREMENT_GAP_USE_ANALYZER) {  
                boost,
        final Parameter<String> indexOptions = TextParams.indexOptions(m -> builder(m).indexOptions.getValue());
            List<AnnotationToken> annotations = new ArrayList<>();
                sb.append(a);  
import org.opensearch.index.analysis.IndexAnalyzers;  
    public static final class AnnotationsInjector extends TokenFilter {  
import java.io.Reader;  
                            annotations.add(new AnnotationToken(startOffset, endOffset, value));
        @Override
            }
    static String readToString(Reader reader) {  
                    try {
            this.textPlusMarkup = textPlusMarkup;
        @Override  
                this.endOffset = endOffset;
        public Analyzer getWrappedAnalyzer(String fieldName) {
import java.io.IOException;
                return components;
}
                if (obj == null) return false;
            }  
        }
        }
        private int currentAnnotationIndex = 0;
        private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
                this
        }
/** A {@link FieldMapper} for full-text fields with annotation markup e.g.
                        if (kv.length == 1) {
    // When asked to tokenize plain-text versions by the highlighter it tokenizes the  
                    || (start <= endOffset && end >= endOffset)  
            super(delegate.getReuseStrategy());  
                    posAtt.setPositionIncrement(firstSpannedTextPosInc);
            }  
        }
        });  
                }
        }
        public static AnnotatedText parse(String textPlusMarkup) {  
 * SPDX-License-Identifier: Apache-2.0
            }
                } else {
                indexOptions,
        private final Parameter<Boolean> store = Parameter.storeParam(m -> builder(m).store.getValue(), false);  
    // A utility class for use with highlighters where the content being highlighted  
    protected void parseCreateField(ParseContext context) throws IOException {  
                multiFieldsBuilder.build(this, context),
        @Override
import org.apache.lucene.document.Field;
                            }  
        FieldType fieldType,  
 * A special Analyzer wraps the default choice of analyzer in order  
            this.analyzers = new TextParams.Analyzers(indexAnalyzers);
            typeAtt.setType("annotation");  
            if (fieldType.omitNorms()) {  
                }
        return CONTENT_TYPE;  
        public Analyzer getWrappedAnalyzer(String fieldName) {  
                buildFieldType(fieldType, context),
        MultiFields multiFields,
        try {
            }
        }
                        emitAnnotation(firstSpannedTextPosInc, annotationPosLen);
            public boolean intersects(int start, int end) {
                nextAnnotationForInjection = annotatedText.getAnnotation(0);
                        // with a zero pos increment so is same as annotation
    public static final class AnnotatedText {  
        }
 * my attempts to subclass TextFieldMapper failed but we can revisit this.
    @Override  
                }
                    sb.append(textPlusMarkup, lastPos, m.start());
                        // that is injected before it  
                result = prime * result + offset;  
            if (internalNextToken()) {  
 *
            TextSearchInfo tsi = new TextSearchInfo(
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
                return true;
        private final PositionIncrementAttribute posAtt = addAttribute(PositionIncrementAttribute.class);
import org.opensearch.index.mapper.FieldMapper;
                    );  
            pendingStatePos = 0;
        final Parameter<Boolean> norms = TextParams.norms(true, m -> builder(m).norms.getValue());  
        }  
import java.io.StringReader;
                if (currentAnnotationIndex < annotatedText.numAnnotations()) {  
            public boolean equals(Object obj) {  
 * This code is largely a copy of TextFieldMapper which is less than ideal -
                            // Buffer up all the other tokens spanned by this annotation to determine length.
        char[] arr = new char[8 * 1024];
    @Override  
    protected AnnotatedTextFieldMapper clone() {
            if (pendingStatePos < pendingStates.size()) {
        public AnnotationsInjector(TokenStream in) {  
                AnnotatedText at = annotations[readerNum.getAndIncrement()];
 * ownership. Elasticsearch licenses this file to you under  
                termAtt.resizeBuffer(nextAnnotationForInjection.value.length());  
                                inputExhausted = true;
        }  
            // Now pop the first of many potential buffered tokens:  
                similarity.get(),  
        return (AnnotatedTextFieldMapper) super.clone();
        private AnnotatedText annotatedText;
 * in the token stream.  
            ft.setBoost(boost.getValue());  
            final int annotationOffset = nextAnnotationForInjection.offset;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;  
    }
                        }
        final Parameter<Integer> positionIncrementGap = Parameter.intParam(  
                fieldType,
                return false;  
                copyTo.build(),  
    protected String contentType() {
            reader.close();
        public final String textPlusMarkup;
        String simpleName,
 * software distributed under the License is distributed on an
package org.opensearch.index.mapper.annotatedtext;
                                // untyped value
        }
 * entity annotation tokens as supplementary tokens at the relevant points
                }
            );  
            return new NamedAnalyzer(in.name(), AnalyzerScope.INDEX, new AnnotationAnalyzerWrapper(in.analyzer()), positionIncrementGap);
                final int prime = 31;  
            return delegate;
        AnnotatedTextFieldType mappedFieldType,
                    if (textOffsetAtt.startOffset() >= nextAnnotationForInjection.offset) {  
import org.opensearch.OpenSearchParseException;
                norms,  
            }
        public static final class AnnotationToken {
        return ((AnnotatedTextFieldMapper) in).builder;
                return Objects.equals(endOffset, other.endOffset)
                AnnotatedText annotations = AnnotatedText.parse(readToString(r));
        public void setAnnotations(AnnotatedText[] annotations) {
                if (nextAnnotationForInjection != null) {
import java.util.regex.Matcher;
        }
            context.doc().add(field);
/*  
import java.util.concurrent.atomic.AtomicInteger;
            int posGap;
        }
                        throw new OpenSearchParseException("Unsupported encoding parsing annotated text", e);
                    throw new IllegalArgumentException(
            public AnnotationToken(int offset, int endOffset, String value) {
            );  
            false,
        public AnnotationToken getAnnotation(int index) {
import org.opensearch.index.mapper.TextParams;
            // Default annotation type - in future AnnotationTokens may contain custom type info
                positionIncrementGap,  
                    pendingStates.add(1, captureState());
            this.delegate = delegate;
                setType();
    }
    }
            internalNextToken();
            return buffer.toString();  
        int pendingStatePos = 0;  
                    || (start >= offset && end <= endOffset);
import org.apache.lucene.index.IndexOptions;  
            inputExhausted = false;  
        }  
                sb.append("\n");
public class AnnotatedTextFieldMapper extends ParametrizedFieldMapper {
                fieldType,  
                        }
                    && Objects.equals(offset, other.offset)  
 * <p>  
                posGap = positionIncrementGap.get();
            }, injector);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return annotations.size();
        private void setType() {
        }  
                meta
            public final int endOffset;
        final Parameter<String> termVectors = TextParams.termVectors(m -> builder(m).termVectors.getValue());
                    } catch (UnsupportedEncodingException e) {  
        boolean inputExhausted = false;
                components.getSource().accept(new StringReader(at.textMinusMarkup));
            return new TokenStreamComponents(r -> {
        }
        if (context.externalValueSet()) {
                wrapAnalyzer(analyzers.getSearchQuoteAnalyzer(), posGap)
        this.builder = builder;  
                                value = URLDecoder.decode(kv[0], "UTF-8");  
                        pendingStates.add(captureState());
                // already wrapped  
                posGap = TextFieldMapper.Defaults.POSITION_INCREMENT_GAP;
            super(name, true, false, meta);
        }
 * The OpenSearch Contributors require contributions made to  
            return annotations.get(index);
                return value + " (" + offset + " - " + endOffset + ")";
    private static Builder builder(FieldMapper in) {  
            annotations.forEach(a -> {
        assert fieldType.tokenized();
                        int annotationPosLen = 1;
        }
        public String typeName() {
    public static final String CONTENT_TYPE = "annotated_text";  
        public int numAnnotations() {  
     * annotations found in texts
            @Override
            @Override
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.mapper.TextSearchInfo;
import java.net.URLDecoder;
                inputExhausted = true;
    // needs plain text format for highlighting but marked-up format for token discovery.
            } else {
            } else {  
    /**
        Builder builder
            return context.externalValue().toString();
            while (m.find()) {
            setType();
                throw new MapperParsingException("[positions_increment_gap] must be positive, got [" + v + "]");
/*  
    public static class Builder extends ParametrizedFieldMapper.Builder {
                    }
        final TextParams.Analyzers analyzers;
            while (nextAnnotationForInjection != null && nextAnnotationForInjection.offset == annotationOffset) {  
    }  
        public String toString() {
            if (annotatedText != null && annotatedText.numAnnotations() > 0) {
        }
                        return true;  
                        if (value != null && value.length() > 0) {  
                        if (kv.length == 2) {
        }
            return new TokenStreamComponents(r -> {  
    private final Builder builder;
        }
            public final String value;  
                        "Cannot set position_increment_gap on field [" + name() + "] without positions enabled"
                    posAtt.setPositionIncrement(0);
        private final TypeAttribute typeAtt = addAttribute(TypeAttribute.class);
            }
                                pendingStates.add(captureState());
                sb.append(textPlusMarkup.substring(lastPos));  
        AnnotatedText.AnnotationToken nextAnnotationForInjection = null;  
            );
    public static final class AnnotatedHighlighterAnalyzer extends AnalyzerWrapper {
            super.reset();
                }
                        int firstSpannedTextPosInc = posAtt.getPositionIncrement();
