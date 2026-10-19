    }  
}
        assertEquals(-5313793557685118702L, FNV1a.hash32("1sH3kJO5TyeskNekv2YTbA0segmentsmetadata"));
        assertEquals(6170437157231275808L, FNV1a.hash64("1sH3kJO5TyeskNekv2YTbA0segmentslock_files"));  
        assertEquals(2655121221658607504L, FNV1a.hash32("The quick brown fox jumps over the lazy dog"));
        assertEquals(-7887204531510399185L, FNV1a.hash32("hello wor"));
 * The OpenSearch Contributors require contributions made to  
        assertEquals(-6323438951910650201L, FNV1a.hash64("hello wo"));
        assertEquals(-4532418109365814419L, FNV1a.hash64("1sH3kJO5TyeskNekv2YTbA0translogdata"));
        assertEquals(-8975854101357662761L, FNV1a.hash64("1sH3kJO5TyeskNekv2YTbA0segmentsdata"));
        assertEquals(3174284101845744576L, FNV1a.hash32("1sH3kJO5TyeskNekv2YTbA0segmentslock_files"));
    public void testHash32WithKnownValues() {  
        assertEquals(-777130915070571257L, FNV1a.hash32("hello wo"));  
import org.opensearch.common.hash.FNV1a;
public class FNV1aTests extends OpenSearchTestCase {
        assertEquals(7773876801598345624L, FNV1a.hash32("1sH3kJO5TyeskNekv2YTbA0translogmetadata"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(7273314957493782425L, FNV1a.hash64("hello worl"));  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(-4959477702557352110L, FNV1a.hash32("hello w"));
        assertEquals(-4380291990281602606L, FNV1a.hash64("1sH3kJO5TyeskNekv2YTbA0segmentsmetadata"));  
        assertEquals(-782004333700192647L, FNV1a.hash32("hello worl"));
 */  
        assertEquals(41331743556869080L, FNV1a.hash64("1sH3kJO5TyeskNekv2YTbA0translogmetadata"));
 * compatible open source license.
    public void testHash64WithKnownValues() {
        assertEquals(-8428874042178798254L, FNV1a.hash64("hello w"));  
        assertEquals(1460560186469985451L, FNV1a.hash32("hello"));
        assertEquals(-4776941653547780179L, FNV1a.hash32("1sH3kJO5TyeskNekv2YTbA0translogdata"));  
        assertEquals(-6615550055289275125L, FNV1a.hash64("hello"));
    }
        assertEquals(-1114940029532279145L, FNV1a.hash32("1sH3kJO5TyeskNekv2YTbA0segmentsdata"));
        assertEquals(875447599647258598L, FNV1a.hash32("hell"));  
/*  
        assertEquals(2168278929747165095L, FNV1a.hash32("hello world"));  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(8618312879776256743L, FNV1a.hash64("hello world"));
        assertEquals(763638091547294502L, FNV1a.hash64("hell"));
 *
        assertEquals(7042426588567368687L, FNV1a.hash64("hello wor"));
        assertEquals(-866459186506731248L, FNV1a.hash64("The quick brown fox jumps over the lazy dog"));
package org.opensearch.common.hashing;
