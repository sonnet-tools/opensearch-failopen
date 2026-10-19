 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
        public PostingsEnum postings(PostingsEnum reuse, int flags) throws IOException {  
         * the current {@link Terms} instance or any other instance obtained from it.  
     * Wraps a Fields but with additional asserts  
    }  
 * under the License.  
                thrower.maybeThrow(Flags.Terms);
    public SortedSetDocValues getSortedSetDocValues(String field) throws IOException {  
    }
    @Override
 * not use this file except in compliance with the License.
        super(in);  
 * SPDX-License-Identifier: Apache-2.0
    private final Thrower thrower;
    }  
        thrower.maybeThrow(Flags.BinaryDocValues);
        }
            TermsEnum termsEnum = in.intersect(automaton, bytes);
        @Override
        Norms,
    /**
    public NumericDocValues getNormValues(String field) throws IOException {  
            thrower.maybeThrow(Flags.Intersect);
 * An FilterLeafReader that allows to throw exceptions if certain methods
                thrower.maybeThrow(Flags.DocsEnum);
            super(in);  
 *
        }  
        boolean wrapTerms(String field);
 * are called on is. This allows to test parts of the system under certain  
        public ThrowingTerms(Terms in, Thrower thrower) {  
    }
        TermsEnum,
        @Override
/*
        this.thrower = thrower;
        return terms;
        return in.getReaderCacheHelper();  
 *
 * compatible open source license.
/**
            super(in);
import org.apache.lucene.index.SortedDocValues;
 */  
        private final Thrower thrower;  
    @Override
    public static class ThrowingTerms extends FilterTerms {  
        }  
        DocsAndPositionsEnum,
     */
        return super.getNormValues(field);
        return super.getSortedDocValues(field);
    public BinaryDocValues getBinaryDocValues(String field) throws IOException {  
        Terms,
    public SortedDocValues getSortedDocValues(String field) throws IOException {  
        public Terms terms(String field) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
 *  
import org.apache.lucene.util.automaton.CompiledAutomaton;  
 */
import org.apache.lucene.index.PostingsEnum;  
     * Wraps a Terms but with additional asserts
    }  
    public static class ThrowingFields extends FilterFields {
    public CacheHelper getCoreCacheHelper() {  
        if (thrower.wrapTerms(field)) {
    }
    }
            this.thrower = thrower;
            return new ThrowingTermsEnum(termsEnum, thrower);
        /**  
    public NumericDocValues getNumericDocValues(String field) throws IOException {
        SortedDocValues,
        ThrowingTermsEnum(TermsEnum in, Thrower thrower) {
    @Override
import org.apache.lucene.index.NumericDocValues;
/*  
import org.apache.lucene.index.LeafReader;
        DocsEnum,
    }  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
        SortedSetDocValues;
        private final Thrower thrower;  
        private final Thrower thrower;
        @Override  
            thrower.maybeThrow(Flags.Terms);
            super(in);  
 * ownership. Elasticsearch licenses this file to you under  
            return terms == null ? null : new ThrowingTerms(terms, thrower);  
        }
        public TermsEnum iterator() throws IOException {
    @Override
            if ((flags & PostingsEnum.POSITIONS) != 0) {
    }  
 * GitHub history for details.
    public enum Flags {
import java.io.IOException;
        Intersect,  
     */
    }  
        Terms terms = super.terms(field);  
        }
 * You may obtain a copy of the License at  
import org.apache.lucene.index.Terms;  
         * Maybe throws an exception ;)
 * error conditions that would otherwise not be possible.
     * when the corresponding method is called.  
        Fields,  
    /**
         */
                return terms == null ? null : new ThrowingTerms(terms, thrower);  
}
        return super.getSortedSetDocValues(field);
            } else {  
    @Override
import org.apache.lucene.index.BinaryDocValues;
     * Flags passed to {@link Thrower#maybeThrow(ThrowingLeafReaderWrapper.Flags)}
 * KIND, either express or implied.  See the License for the
            }
         */  
            return terms;
        thrower.maybeThrow(Flags.NumericDocValues);  
     * A callback interface that allows to throw certain exceptions for  
         * If this method returns true the {@link Terms} instance for the given field
    }  
            return new ThrowingTermsEnum(termsEnum, thrower);  
/*  
    }
    @Override
 * license agreements. See the NOTICE file distributed with
    static class ThrowingTermsEnum extends FilterTermsEnum {
    public Terms terms(String field) throws IOException {
        @Override
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.FilterLeafReader;  
         * is wrapped with Thrower support otherwise no exception will be thrown for
    @Override
 */
    @Override
import org.apache.lucene.index.Fields;
            return super.postings(reuse, flags);  
    public ThrowingLeafReaderWrapper(LeafReader in, Thrower thrower) {
                thrower.maybeThrow(Flags.DocsAndPositionsEnum);
     * methods called on the IndexReader that is wrapped by {@link ThrowingLeafReaderWrapper}
     */
        NumericDocValues,
        public TermsEnum intersect(CompiledAutomaton automaton, BytesRef bytes) throws IOException {  
 * this work for additional information regarding copyright
public class ThrowingLeafReaderWrapper extends FilterLeafReader {  
        }
            if (thrower.wrapTerms(field)) {
            this.thrower = thrower;
            TermsEnum termsEnum = super.iterator();
        return super.getBinaryDocValues(field);
            thrower.maybeThrow(Flags.TermsEnum);  
 * Unless required by applicable law or agreed to in writing,
    /**  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.TermsEnum;
    public interface Thrower {  
        TermVectors,  
            Terms terms = super.terms(field);  
        }  
import org.apache.lucene.util.BytesRef;
        BinaryDocValues,  
        thrower.maybeThrow(Flags.Norms);
        thrower.maybeThrow(Flags.SortedSetDocValues);
        public ThrowingFields(Fields in, Thrower thrower) {
        }
            this.thrower = thrower;
        /**
     */
        return super.getNumericDocValues(field);
    }  
            }
    public CacheHelper getReaderCacheHelper() {
import org.apache.lucene.index.SortedSetDocValues;
package org.opensearch.test.engine;
        return in.getCoreCacheHelper();
        thrower.maybeThrow(Flags.SortedDocValues);
        void maybeThrow(Flags flag) throws IOException;
 */  
