        assertSame(codec, ((FilterLeafReader.FilterPostingsEnum) first).unwrap());
    /** Reuse is optional for the codec; the cancellation wrapper must accept a replacement postings iterator. */
        TermsEnum delegate = mock(TermsEnum.class);  
    public void testOtherReuseIsPassedThrough() throws IOException {  
        PostingsEnum newCodec = mock(PostingsEnum.class);  
package org.opensearch.search.internal;
    }
import static org.mockito.Mockito.when;
    }  
import static org.mockito.Mockito.verify;
        when(terms.iterator()).thenReturn(delegate);
import static org.mockito.Mockito.mock;
            BytesRef startTerm = new BytesRef("ab");  
        verifyNoInteractions(oldCancellation);
        PostingsEnum oldCodec = mock(PostingsEnum.class);
        } else {  
        assertNotSame(first, second);
}
        PostingsEnum otherWrapper = new FilterLeafReader.FilterPostingsEnum(codec) {
        }  
import org.apache.lucene.index.FilterLeafReader;
        ExitableDirectoryReader.ExitableTerms wrapped = new ExitableDirectoryReader.ExitableTerms(terms, cancellation);
        assertSame(newCodec, ((FilterLeafReader.FilterPostingsEnum) result).unwrap());
        };  
import org.apache.lucene.index.TermsEnum;
        when(delegate.postings(oldCodec, PostingsEnum.POSITIONS)).thenReturn(newCodec);
        assertPostingsReuse(false);
        when(delegate.postings(null, PostingsEnum.NONE)).thenReturn(codec);
        }
    private TermsEnum wrap(TermsEnum delegate, ExitableDirectoryReader.QueryCancellation cancellation) throws IOException {
 * compatible open source license.
        ExitableDirectoryReader.QueryCancellation newCancellation = mock(ExitableDirectoryReader.QueryCancellation.class);  
        verify(delegate).postings(null, PostingsEnum.NONE);
        verify(codec, never()).nextDoc();
    /** Ordinary term enumeration must forward the native reuse candidate and flags while creating a fresh cancellation wrapper. */
        TermsEnum delegate = mock(TermsEnum.class);
    /** Only our cancellation wrapper should be unwrapped; the delegate decides how to handle other reuse candidates. */
import org.apache.lucene.util.BytesRef;
        Terms terms = mock(Terms.class);  
            verify(delegate).postings(reuse, PostingsEnum.NONE);  
        TermsEnum iterator = wrap(delegate, cancellation);
            when(delegate.postings(reuse, PostingsEnum.NONE)).thenReturn(resultCodec);
    public void testCodecCanRejectReuse() throws IOException {  
import org.apache.lucene.util.automaton.CompiledAutomaton;  
        PostingsEnum result = iterator.postings(reuse, PostingsEnum.POSITIONS);  
        verify(newCancellation, times(2)).checkCancelled(); // TermsEnum creation and the first postings operation.  
            TermsEnum delegate = mock(TermsEnum.class);
import static org.mockito.Mockito.doThrow;
        ExitableDirectoryReader.QueryCancellation oldCancellation = mock(ExitableDirectoryReader.QueryCancellation.class);
    }
            iterator = wrapped.iterator();
            PostingsEnum result = iterator.postings(reuse, PostingsEnum.NONE);
import static org.mockito.Mockito.never;  
        Terms terms = mock(Terms.class);
    /** Automaton-based term expansion must preserve the same postings reuse contract as ordinary iteration. */
    }  
        final TermsEnum iterator;  
    }  
import static org.mockito.Mockito.verifyNoInteractions;  
    private void assertPostingsReuse(boolean intersect) throws IOException {  
import org.apache.lucene.util.automaton.RegExp;
    }
            when(terms.iterator()).thenReturn(delegate);
    public void testIteratorReusesPostings() throws IOException {  
/*  
public class ExitableTermsTests extends OpenSearchTestCase {  
import java.io.IOException;
            iterator = wrapped.intersect(automaton, startTerm);
        TermsEnum iterator = wrap(delegate, newCancellation);
        when(delegate.postings(codec, PostingsEnum.NONE)).thenReturn(codec);  
        PostingsEnum result = iterator.postings(reuse, PostingsEnum.NONE);
        PostingsEnum codec = mock(PostingsEnum.class);
 *
            CompiledAutomaton automaton = new CompiledAutomaton(new RegExp("a.*").toAutomaton());
        assertPostingsReuse(true);  
            TermsEnum iterator = wrap(delegate, mock(ExitableDirectoryReader.QueryCancellation.class));
import org.apache.lucene.index.Terms;  
        when(delegate.postings(codec, PostingsEnum.FREQS)).thenReturn(codec);  
        PostingsEnum first = iterator.postings(null, PostingsEnum.NONE);  
        doThrow(new TaskCancelledException("current query cancelled")).when(newCancellation).checkCancelled();  
        assertSame(codec, ((FilterLeafReader.FilterPostingsEnum) second).unwrap());  
            PostingsEnum resultCodec = mock(PostingsEnum.class);  
import org.opensearch.test.OpenSearchTestCase;  
        return new ExitableDirectoryReader.ExitableTerms(terms, cancellation).iterator();
        verify(delegate).postings(oldCodec, PostingsEnum.POSITIONS);
        if (intersect) {
 * this file be licensed under the Apache-2.0 license or a
        ExitableDirectoryReader.QueryCancellation cancellation = mock(ExitableDirectoryReader.QueryCancellation.class);
        PostingsEnum codec = mock(PostingsEnum.class);
import org.apache.lucene.index.PostingsEnum;
        TermsEnum delegate = mock(TermsEnum.class);
        for (PostingsEnum reuse : new PostingsEnum[] { codec, otherWrapper }) {
        ExitableDirectoryReader.QueryCancellation cancellation = mock(ExitableDirectoryReader.QueryCancellation.class);
        PostingsEnum reuse = new ExitableDirectoryReader.ExitablePostingsEnum(oldCodec, cancellation);  
 * The OpenSearch Contributors require contributions made to  
        PostingsEnum codec = mock(PostingsEnum.class);  
 */  
    public void testReusedPostingsUseCurrentCancellation() throws IOException {
    public void testIntersectReusesPostings() throws IOException {
        assertEquals("current query cancelled", exception.getMessage());
        TaskCancelledException exception = expectThrows(TaskCancelledException.class, result::nextDoc);
import static org.mockito.Mockito.times;
        PostingsEnum reuse = new ExitableDirectoryReader.ExitablePostingsEnum(codec, oldCancellation);
            assertSame(resultCodec, ((FilterLeafReader.FilterPostingsEnum) result).unwrap());
            when(terms.intersect(automaton, startTerm)).thenReturn(delegate);
    }  
    /** Cancellation belongs to the current query even when its codec postings were reused from another query. */
        verify(delegate).postings(codec, PostingsEnum.FREQS);
import org.opensearch.core.tasks.TaskCancelledException;
        PostingsEnum second = iterator.postings(first, PostingsEnum.FREQS);
 * SPDX-License-Identifier: Apache-2.0
