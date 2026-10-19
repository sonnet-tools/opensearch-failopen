        assertEquals(0, exec("def u = (long)1; def b = Long.valueOf((long)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return Double.valueOf((double)1)} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (int)1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));  
            () -> exec("def u = (long)1; Character b = Character.valueOf((char)1); b.compareTo(u);")  
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); Float b = Float.valueOf((float)1); b.compareTo(u);"));
        assertEquals(0, exec("long u = 1; def b = Long.valueOf((long)1); b.compareTo(u);"));
public class BoxedCastTests extends ScriptTestCase {
        );
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {def d = (long)1; return d} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; Float b = Float.valueOf((float)1); b.compareTo(u);"));  
        assertEquals(0, exec("def u = (float)1; Float b = Float.valueOf((float)1); b.compareTo(u);"));  
        assertEquals((double) 1, exec("Double rtn() {return (long)1} rtn()"));
        assertEquals((double) 1, exec("Double rtn() {def d = Character.valueOf((char)1); return d} rtn()"));
        assertEquals(0, exec("Long u = Long.valueOf((long)1); def b = Float.valueOf((float)1); b.compareTo(u);"));
            ClassCastException.class,
            () -> exec("Character u = Character.valueOf((char)1); Byte b = Byte.valueOf((byte)1); b.compareTo(u);")  
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = (short)1; return d} rtn()"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, exec("double u = 1; def b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = (short)1; return d} rtn()"));
    }
        assertEquals((double) 1, exec("Double rtn() {def d = (double)1; return d} rtn()"));
        );  
        );
            () -> exec("Double u = Double.valueOf((double)1); def b = Long.valueOf((long)1); b.compareTo(u);")
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("char u = 1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));
            ClassCastException.class,  
        assertEquals(0, exec("short u = 1; def b = Short.valueOf((short)1); b.compareTo(u);"));
            () -> exec("Long u = Long.valueOf((long)1); def b = Byte.valueOf((byte)1); b.compareTo(u);")
        assertEquals(0, exec("Float u = Float.valueOf((float)1); def b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (float)1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return (int)1} rtn()"));  
            ClassCastException.class,
        assertEquals(0, exec("byte u = 1; def b = Short.valueOf((short)1); b.compareTo(u);"));  
        assertEquals((short) 1, exec("Short rtn() {def d = Short.valueOf((short)1); return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("float u = 1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));  
            ClassCastException.class,
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return Float.valueOf((float)1)} rtn()"));
        assertEquals(0, exec("Character u = Character.valueOf((char)1); def b = Integer.valueOf((int)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; Long b = Long.valueOf((long)1); b.compareTo(u);"));
            () -> exec("Double u = Double.valueOf((double)1); def b = Short.valueOf((short)1); b.compareTo(u);")
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return (float)1} rtn()"));
        assertEquals(0, exec("float u = 1; def b = Double.valueOf((double)1); b.compareTo(u);"));  
        expectScriptThrows(
 * ownership. Elasticsearch licenses this file to you under  
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {def d = Long.valueOf((long)1); return d} rtn()"));
        assertEquals(0, exec("Double u = Double.valueOf((double)1); Double b = Double.valueOf((double)1); b.compareTo(u);"));  
        expectScriptThrows(  
        assertEquals(0, exec("def u = (int)1; Long b = Long.valueOf((long)1); b.compareTo(u);"));
        assertEquals(1, exec("Integer rtn() {return Byte.valueOf((byte)1)} rtn()"));
/*
 */  
        assertEquals((long) 1, exec("Long rtn() {return (int)1} rtn()"));
        assertEquals(0, exec("def u = (short)1; Long b = Long.valueOf((long)1); b.compareTo(u);"));  
        assertEquals((long) 1, exec("Long rtn() {def d = Long.valueOf((long)1); return d} rtn()"));
    }  
            () -> exec("Short u = Short.valueOf((short)1); def b = Byte.valueOf((byte)1); b.compareTo(u);")
        assertEquals((double) 1, exec("Double rtn() {def d = Integer.valueOf((int)1); return d} rtn()"));  
        assertEquals((float) 1, exec("Float rtn() {def d = (char)1; return d} rtn()"));
        assertEquals(0, exec("Character u = Character.valueOf((char)1); def b = Float.valueOf((float)1); b.compareTo(u);"));
        );
        assertEquals(0, exec("def u = (char)1; Character b = Character.valueOf((char)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {def d = Double.valueOf((double)1); return d} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (float)1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));
        assertEquals((double) 1, exec("Double rtn() {def d = (char)1; return d} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return Byte.valueOf((byte)1)} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (float)1; def b = Long.valueOf((long)1); b.compareTo(u);"));
        assertEquals((double) 1, exec("Double rtn() {return Integer.valueOf((int)1)} rtn()"));
}
            () -> exec("def u = (double)1; Character b = Character.valueOf((char)1); b.compareTo(u);")
        assertEquals(0, exec("Character u = Character.valueOf((char)1); Character b = Character.valueOf((char)1); b.compareTo(u);"));  
        assertEquals(0, exec("def u = (long)1; Double b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals((float) 1, exec("Float rtn() {def d = Float.valueOf((float)1); return d} rtn()"));
        );
        assertEquals(0, exec("Short u = Short.valueOf((short)1); def b = Float.valueOf((float)1); b.compareTo(u);"));
        assertEquals((double) 1, exec("Double rtn() {def d = Double.valueOf((double)1); return d} rtn()"));  
        expectScriptThrows(  
            () -> exec("Long u = Long.valueOf((long)1); Short b = Short.valueOf((short)1); b.compareTo(u);")
        assertEquals(0, exec("Short u = Short.valueOf((short)1); Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {return Long.valueOf((long)1)} rtn()"));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(0, exec("char u = 1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
        expectScriptThrows(
            () -> exec("Long u = Long.valueOf((long)1); def b = Character.valueOf((char)1); b.compareTo(u);")
        assertEquals((byte) 1, exec("Byte rtn() {def d = Byte.valueOf((byte)1); return d} rtn()"));  
            () -> exec("Double u = Double.valueOf((double)1); def b = Float.valueOf((float)1); b.compareTo(u);")
        assertEquals(0, exec("def u = (char)1; def b = Double.valueOf((double)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; def b = Long.valueOf((long)1); b.compareTo(u);"));  
        assertEquals((double) 1, exec("Double rtn() {return Character.valueOf((char)1)} rtn()"));
            ClassCastException.class,
        assertEquals(0, exec("short u = 1; def b = Integer.valueOf((int)1); b.compareTo(u);"));
            () -> exec("Double u = Double.valueOf((double)1); def b = Byte.valueOf((byte)1); b.compareTo(u);")  
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {return (float)1} rtn()"));  
    public void testMethodCallLongToBoxedCasts() {
 * You may obtain a copy of the License at  
        assertEquals(0, exec("Double u = Double.valueOf((double)1); def b = Double.valueOf((double)1); b.compareTo(u);"));
            () -> exec("Double u = Double.valueOf((double)1); Character b = Character.valueOf((char)1); b.compareTo(u);")
            ClassCastException.class,  
        expectScriptThrows(ClassCastException.class, () -> exec("int u = 1; Short b = Short.valueOf((short)1); b.compareTo(u);"));
        assertEquals((long) 1, exec("Long rtn() {def d = (long)1; return d} rtn()"));  
        assertEquals(0, exec("def u = (long)1; Float b = Float.valueOf((float)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Long rtn() {def d = Float.valueOf((float)1); return d} rtn()"));  
        );  
        assertEquals(0, exec("Integer u = Integer.valueOf((int)1); def b = Float.valueOf((float)1); b.compareTo(u);"));  
            () -> exec("Double u = Double.valueOf((double)1); def b = Character.valueOf((char)1); b.compareTo(u);")
        assertEquals(0, exec("int u = 1; Float b = Float.valueOf((float)1); b.compareTo(u);"));  
        assertEquals(0, exec("def u = (byte)1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));  
        );
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = (float)1; return d} rtn()"));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals((byte) 1, exec("Byte rtn() {return (byte)1} rtn()"));  
        assertEquals(1, exec("Integer rtn() {def d = (byte)1; return d} rtn()"));
        assertEquals(0, exec("def u = (byte)1; def b = Float.valueOf((float)1); b.compareTo(u);"));
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (int)1; Short b = Short.valueOf((short)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (long)1; def b = Short.valueOf((short)1); b.compareTo(u);"));
            () -> exec("Short u = Short.valueOf((short)1); Character b = Character.valueOf((char)1); b.compareTo(u);")  
            () -> exec("Double u = Double.valueOf((double)1); Float b = Float.valueOf((float)1); b.compareTo(u);")
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = Float.valueOf((float)1); return d} rtn()"));
        assertEquals(0, exec("short u = 1; Double b = Double.valueOf((double)1); b.compareTo(u);"));  
        assertEquals((long) 1, exec("Long rtn() {def d = (byte)1; return d} rtn()"));
        assertEquals((float) 1, exec("Float rtn() {return Float.valueOf((float)1)} rtn()"));  
            ClassCastException.class,
        expectScriptThrows(ClassCastException.class, () -> exec("char u = 1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));  
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("char u = 1; Short b = Short.valueOf((short)1); b.compareTo(u);"));  
            () -> exec("def u = (byte)1; Character b = Character.valueOf((char)1); b.compareTo(u);")
        assertEquals((double) 1, exec("Double rtn() {return Byte.valueOf((byte)1)} rtn()"));
            ClassCastException.class,
        assertEquals(1, exec("Integer rtn() {def d = (char)1; return d} rtn()"));  
        assertEquals(1, exec("Integer rtn() {return (byte)1} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; Character b = Character.valueOf((char)1); b.compareTo(u);"));  
    }
        assertEquals((long) 1, exec("Long rtn() {return Long.valueOf((long)1)} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return Character.valueOf((char)1)} rtn()"));
        assertEquals(1, exec("Integer rtn() {return Integer.valueOf((int)1)} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {def d = (long)1; return d} rtn()"));
        assertEquals((float) 1, exec("Float rtn() {return (int)1} rtn()"));
            () -> exec("Character u = Character.valueOf((char)1); Short b = Short.valueOf((short)1); b.compareTo(u);")
        assertEquals(0, exec("short u = 1; def b = Float.valueOf((float)1); b.compareTo(u);"));  
        assertEquals(0, exec("def u = (short)1; def b = Short.valueOf((short)1); b.compareTo(u);"));
    public void testMethodCallShortToBoxedCasts() {
        assertEquals(0, exec("short u = 1; Short b = Short.valueOf((short)1); b.compareTo(u);"));
        assertEquals(0, exec("byte u = 1; def b = Float.valueOf((float)1); b.compareTo(u);"));
        expectScriptThrows(
        assertEquals((long) 1, exec("Long rtn() {return (byte)1} rtn()"));
            () -> exec("Float u = Float.valueOf((float)1); def b = Byte.valueOf((byte)1); b.compareTo(u);")
            ClassCastException.class,
        expectScriptThrows(
    }  
        expectScriptThrows(
        assertEquals(0, exec("def u = (float)1; Double b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Float rtn() {def d = Double.valueOf((double)1); return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return (int)1} rtn()"));
        assertEquals((char) 1, exec("Character rtn() {return (char)1} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (char)1; def b = Short.valueOf((short)1); b.compareTo(u);"));
        assertEquals(0, exec("def u = (byte)1; def b = Integer.valueOf((int)1); b.compareTo(u);"));
    public void testReturnToIntegerBoxedCasts() {
        );
        assertEquals(0, exec("Float u = Float.valueOf((float)1); Double b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals(0, exec("Integer u = Integer.valueOf((int)1); Double b = Double.valueOf((double)1); b.compareTo(u);"));  
        assertEquals(0, exec("def u = (short)1; def b = Float.valueOf((float)1); b.compareTo(u);"));  
            ClassCastException.class,
        expectScriptThrows(
 * GitHub history for details.
        assertEquals(0, exec("def u = (byte)1; Float b = Float.valueOf((float)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {return Float.valueOf((float)1)} rtn()"));
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); Double b = Double.valueOf((double)1); b.compareTo(u);"));  
        assertEquals((long) 1, exec("Long rtn() {def d = Integer.valueOf((int)1); return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("long u = 1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Float rtn() {return Double.valueOf((double)1)} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {def d = (float)1; return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (char)1; Short b = Short.valueOf((short)1); b.compareTo(u);"));
        assertEquals((long) 1, exec("Long rtn() {return (short)1} rtn()"));
        expectScriptThrows(
        assertEquals(0, exec("char u = 1; def b = Character.valueOf((char)1); b.compareTo(u);"));
        assertEquals(0, exec("char u = 1; def b = Double.valueOf((double)1); b.compareTo(u);"));  
        assertEquals(0, exec("int u = 1; def b = Integer.valueOf((int)1); b.compareTo(u);"));
        assertEquals(0, exec("byte u = 1; def b = Long.valueOf((long)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {return Double.valueOf((double)1)} rtn()"));
        expectScriptThrows(
        expectScriptThrows(  
        assertEquals(0, exec("Short u = Short.valueOf((short)1); Double b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals(0, exec("Float u = Float.valueOf((float)1); def b = Float.valueOf((float)1); b.compareTo(u);"));
        assertEquals((long) 1, exec("Long rtn() {return (long)1} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (short)1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));
            () -> exec("Integer u = Integer.valueOf((int)1); def b = Character.valueOf((char)1); b.compareTo(u);")
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; Float b = Float.valueOf((float)1); b.compareTo(u);"));
            () -> exec("Long u = Long.valueOf((long)1); def b = Integer.valueOf((int)1); b.compareTo(u);")
            () -> exec("Float u = Float.valueOf((float)1); Byte b = Byte.valueOf((byte)1); b.compareTo(u);")  
        assertEquals(0, exec("long u = 1; def b = Float.valueOf((float)1); b.compareTo(u);"));  
        assertEquals(0, exec("char u = 1; Long b = Long.valueOf((long)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Long rtn() {return Float.valueOf((float)1)} rtn()"));
        expectScriptThrows(
        );
    public void testReturnToDoubleBoxedCasts() {
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {def d = Float.valueOf((float)1); return d} rtn()"));
        assertEquals((float) 1, exec("Float rtn() {def d = Long.valueOf((long)1); return d} rtn()"));  
        );
        expectScriptThrows(  
            ClassCastException.class,  
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {return (double)1} rtn()"));  
        assertEquals(0, exec("def u = (int)1; def b = Integer.valueOf((int)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("float u = 1; def b = Long.valueOf((long)1); b.compareTo(u);"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {def d = Double.valueOf((double)1); return d} rtn()"));
        assertEquals(0, exec("short u = 1; Long b = Long.valueOf((long)1); b.compareTo(u);"));
    }
        assertEquals(0, exec("Integer u = Integer.valueOf((int)1); def b = Long.valueOf((long)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (long)1; Short b = Short.valueOf((short)1); b.compareTo(u);"));  
        );  
        assertEquals((float) 1, exec("Float rtn() {def d = (int)1; return d} rtn()"));  
        assertEquals(0, exec("def u = (float)1; def b = Float.valueOf((float)1); b.compareTo(u);"));
            () -> exec("Integer u = Integer.valueOf((int)1); Character b = Character.valueOf((char)1); b.compareTo(u);")
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return (short)1} rtn()"));  
            ClassCastException.class,
    public void testMethodCallIntegerToBoxedCasts() {  
        expectScriptThrows(ClassCastException.class, () -> exec("float u = 1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {def d = Float.valueOf((float)1); return d} rtn()"));  
        assertEquals(0, exec("Character u = Character.valueOf((char)1); def b = Long.valueOf((long)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return Integer.valueOf((int)1)} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {return (char)1} rtn()"));  
            () -> exec("Long u = Long.valueOf((long)1); Integer b = Integer.valueOf((int)1); b.compareTo(u);")
    }
 * under the License.  
        );
            () -> exec("Integer u = Integer.valueOf((int)1); def b = Short.valueOf((short)1); b.compareTo(u);")
        assertEquals(0, exec("Long u = Long.valueOf((long)1); def b = Long.valueOf((long)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = Integer.valueOf((int)1); return d} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("float u = 1; def b = Character.valueOf((char)1); b.compareTo(u);"));
        assertEquals(0, exec("def u = (byte)1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("int u = 1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));
        expectScriptThrows(
        assertEquals(0, exec("def u = (char)1; def b = Character.valueOf((char)1); b.compareTo(u);"));
        assertEquals((float) 1, exec("Float rtn() {return (float)1} rtn()"));
        assertEquals(0, exec("Character u = Character.valueOf((char)1); Float b = Float.valueOf((float)1); b.compareTo(u);"));  
            () -> exec("Float u = Float.valueOf((float)1); def b = Character.valueOf((char)1); b.compareTo(u);")  
        assertEquals((double) 1, exec("Double rtn() {def d = Byte.valueOf((byte)1); return d} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return Short.valueOf((short)1)} rtn()"));  
        assertEquals((double) 1, exec("Double rtn() {return (int)1} rtn()"));  
            ClassCastException.class,
        expectScriptThrows(ClassCastException.class, () -> exec("Long rtn() {def d = (float)1; return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; Short b = Short.valueOf((short)1); b.compareTo(u);"));
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {return Character.valueOf((char)1)} rtn()"));
        assertEquals(0, exec("Integer u = Integer.valueOf((int)1); Float b = Float.valueOf((float)1); b.compareTo(u);"));
        assertEquals(1, exec("Integer rtn() {def d = Character.valueOf((char)1); return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = Character.valueOf((char)1); return d} rtn()"));
        );
        expectScriptThrows(ClassCastException.class, () -> exec("Long rtn() {return (float)1} rtn()"));  
        assertEquals(0, exec("float u = 1; def b = Float.valueOf((float)1); b.compareTo(u);"));
    public void testReturnToLongBoxedCasts() {  
        expectScriptThrows(
 * software distributed under the License is distributed on an
            () -> exec("Integer u = Integer.valueOf((int)1); Byte b = Byte.valueOf((byte)1); b.compareTo(u);")
        assertEquals(0, exec("byte u = 1; def b = Double.valueOf((double)1); b.compareTo(u);"));
            ClassCastException.class,  
        expectScriptThrows(ClassCastException.class, () -> exec("short u = 1; Character b = Character.valueOf((char)1); b.compareTo(u);"));
        );
        expectScriptThrows(
        assertEquals((char) 1, exec("Character rtn() {def d = Character.valueOf((char)1); return d} rtn()"));
 * The OpenSearch Contributors require contributions made to  
        assertEquals(0, exec("float u = 1; Float b = Float.valueOf((float)1); b.compareTo(u);"));
        );
        assertEquals((double) 1, exec("Double rtn() {return Double.valueOf((double)1)} rtn()"));
        );  
        );
        assertEquals(0, exec("def u = (short)1; def b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals(1, exec("Integer rtn() {return (int)1} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {return Double.valueOf((double)1)} rtn()"));  
        );
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; Short b = Short.valueOf((short)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("long u = 1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));  
            ClassCastException.class,
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = (double)1; return d} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = (int)1; return d} rtn()"));  
            ClassCastException.class,
        assertEquals(0, exec("Long u = Long.valueOf((long)1); Double b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals((long) 1, exec("Long rtn() {return Integer.valueOf((int)1)} rtn()"));  
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {def d = Integer.valueOf((int)1); return d} rtn()"));
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); def b = Short.valueOf((short)1); b.compareTo(u);"));
        assertEquals(0, exec("def u = (short)1; Short b = Short.valueOf((short)1); b.compareTo(u);"));  
        assertEquals((short) 1, exec("Short rtn() {def d = (byte)1; return d} rtn()"));
        );  
    }  
        assertEquals(0, exec("int u = 1; Double b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {def d = Character.valueOf((char)1); return d} rtn()"));  
            ClassCastException.class,
        assertEquals((long) 1, exec("Long rtn() {def d = (int)1; return d} rtn()"));
            () -> exec("Float u = Float.valueOf((float)1); Long b = Long.valueOf((long)1); b.compareTo(u);")
            () -> exec("def u = (int)1; Character b = Character.valueOf((char)1); b.compareTo(u);")
        );
        );
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); Short b = Short.valueOf((short)1); b.compareTo(u);"));
        expectScriptThrows(
        expectScriptThrows(  
        );
 * Licensed to Elasticsearch under one or more contributor  
        );
        assertEquals((double) 1, exec("Double rtn() {return (float)1} rtn()"));
        assertEquals((short) 1, exec("Short rtn() {def d = (short)1; return d} rtn()"));  
 *
            () -> exec("Integer u = Integer.valueOf((int)1); def b = Byte.valueOf((byte)1); b.compareTo(u);")  
        assertEquals(0, exec("def u = (byte)1; def b = Short.valueOf((short)1); b.compareTo(u);"));  
        assertEquals(1, exec("Integer rtn() {def d = Byte.valueOf((byte)1); return d} rtn()"));  
 *  
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); def b = Long.valueOf((long)1); b.compareTo(u);"));
        );
        assertEquals(1, exec("Integer rtn() {return Character.valueOf((char)1)} rtn()"));
        assertEquals(0, exec("Short u = Short.valueOf((short)1); def b = Long.valueOf((long)1); b.compareTo(u);"));
        assertEquals((long) 1, exec("Long rtn() {def d = Byte.valueOf((byte)1); return d} rtn()"));
        assertEquals((long) 1, exec("Long rtn() {return (char)1} rtn()"));  
    }  
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); def b = Float.valueOf((float)1); b.compareTo(u);"));  
        assertEquals((float) 1, exec("Float rtn() {return (char)1} rtn()"));
            ClassCastException.class,  
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; def b = Integer.valueOf((int)1); b.compareTo(u);"));
        assertEquals((short) 1, exec("Short rtn() {def d = Byte.valueOf((byte)1); return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (short)1; def b = Character.valueOf((char)1); b.compareTo(u);"));  
        assertEquals((double) 1, exec("Double rtn() {def d = (byte)1; return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = Long.valueOf((long)1); return d} rtn()"));  
        );
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return Long.valueOf((long)1)} rtn()"));  
        assertEquals(0, exec("def u = (short)1; Double b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals((double) 1, exec("Double rtn() {def d = Float.valueOf((float)1); return d} rtn()"));
        );  
        assertEquals((long) 1, exec("Long rtn() {def d = (char)1; return d} rtn()"));
        expectScriptThrows(  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (float)1; def b = Integer.valueOf((int)1); b.compareTo(u);"));  
        );
            () -> exec("Long u = Long.valueOf((long)1); def b = Short.valueOf((short)1); b.compareTo(u);")  
            ClassCastException.class,  
        assertEquals((double) 1, exec("Double rtn() {return (byte)1} rtn()"));  
        );
            () -> exec("Float u = Float.valueOf((float)1); Character b = Character.valueOf((char)1); b.compareTo(u);")
        assertEquals(0, exec("Integer u = Integer.valueOf((int)1); def b = Integer.valueOf((int)1); b.compareTo(u);"));
        expectScriptThrows(  
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return (short)1} rtn()"));
        assertEquals(0, exec("short u = 1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));  
            () -> exec("Float u = Float.valueOf((float)1); def b = Short.valueOf((short)1); b.compareTo(u);")
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = (long)1; return d} rtn()"));
        assertEquals(0, exec("byte u = 1; Double b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("byte u = 1; def b = Character.valueOf((char)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = Double.valueOf((double)1); return d} rtn()"));  
        assertEquals(0, exec("byte u = 1; Short b = Short.valueOf((short)1); b.compareTo(u);"));
        );
        );
        assertEquals((double) 1, exec("Double rtn() {return Short.valueOf((short)1)} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (float)1; def b = Character.valueOf((char)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {return (long)1} rtn()"));
        assertEquals((double) 1, exec("Double rtn() {def d = Short.valueOf((short)1); return d} rtn()"));
        assertEquals(0, exec("def u = (short)1; def b = Integer.valueOf((int)1); b.compareTo(u);"));
        assertEquals(1, exec("Integer rtn() {def d = Short.valueOf((short)1); return d} rtn()"));
        assertEquals((float) 1, exec("Float rtn() {return (short)1} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("long u = 1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(0, exec("def u = (int)1; Double b = Double.valueOf((double)1); b.compareTo(u);"));  
        assertEquals(0, exec("def u = (byte)1; def b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals((double) 1, exec("Double rtn() {return (short)1} rtn()"));
        assertEquals(0, exec("def u = (int)1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));  
        assertEquals(0, exec("Integer u = Integer.valueOf((int)1); Long b = Long.valueOf((long)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (long)1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));
        assertEquals(0, exec("Character u = Character.valueOf((char)1); Double b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals(0, exec("def u = (byte)1; Long b = Long.valueOf((long)1); b.compareTo(u);"));
    public void testMethodCallByteToBoxedCasts() {  
/*  
        expectScriptThrows(ClassCastException.class, () -> exec("Float rtn() {return (double)1} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (char)1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {def d = (double)1; return d} rtn()"));
            ClassCastException.class,
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (long)1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));
            ClassCastException.class,  
        assertEquals((double) 1, exec("Double rtn() {return (double)1} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("short u = 1; def b = Character.valueOf((char)1); b.compareTo(u);"));  
        assertEquals((double) 1, exec("Double rtn() {def d = (int)1; return d} rtn()"));
        assertEquals((double) 1, exec("Double rtn() {def d = (float)1; return d} rtn()"));  
            ClassCastException.class,  
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); def b = Byte.valueOf((byte)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; def b = Integer.valueOf((int)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return Integer.valueOf((int)1)} rtn()"));
        assertEquals(0, exec("Character u = Character.valueOf((char)1); Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
package org.opensearch.painless;
        assertEquals((long) 1, exec("Long rtn() {return Short.valueOf((short)1)} rtn()"));
        expectScriptThrows(  
            () -> exec("Character u = Character.valueOf((char)1); def b = Byte.valueOf((byte)1); b.compareTo(u);")
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); Long b = Long.valueOf((long)1); b.compareTo(u);"));
        assertEquals(0, exec("short u = 1; Float b = Float.valueOf((float)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return (double)1} rtn()"));  
            ClassCastException.class,
        expectScriptThrows(ClassCastException.class, () -> exec("long u = 1; def b = Character.valueOf((char)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = Short.valueOf((short)1); return d} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("short u = 1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (long)1; def b = Integer.valueOf((int)1); b.compareTo(u);"));
        assertEquals(0, exec("def u = (double)1; Double b = Double.valueOf((double)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {def d = (int)1; return d} rtn()"));
            ClassCastException.class,
        expectScriptThrows(  
        expectScriptThrows(  
            () -> exec("Long u = Long.valueOf((long)1); Character b = Character.valueOf((char)1); b.compareTo(u);")  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (byte)1; def b = Character.valueOf((char)1); b.compareTo(u);"));
    public void testMethodCallFloatToBoxedCasts() {
        );  
        assertEquals(0, exec("short u = 1; def b = Long.valueOf((long)1); b.compareTo(u);"));
        assertEquals(0, exec("long u = 1; Long b = Long.valueOf((long)1); b.compareTo(u);"));
        assertEquals(0, exec("def u = (char)1; Long b = Long.valueOf((long)1); b.compareTo(u);"));
            ClassCastException.class,  
        assertEquals(0, exec("char u = 1; Double b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return (long)1} rtn()"));  
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {return (double)1} rtn()"));
            () -> exec("Integer u = Integer.valueOf((int)1); Short b = Short.valueOf((short)1); b.compareTo(u);")  
        assertEquals((float) 1, exec("Float rtn() {return Short.valueOf((short)1)} rtn()"));
        );
        assertEquals(0, exec("long u = 1; def b = Double.valueOf((double)1); b.compareTo(u);"));
/*  
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return Long.valueOf((long)1)} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = (float)1; return d} rtn()"));
            () -> exec("Double u = Double.valueOf((double)1); def b = Integer.valueOf((int)1); b.compareTo(u);")  
        assertEquals((float) 1, exec("Float rtn() {return (byte)1} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (float)1; Long b = Long.valueOf((long)1); b.compareTo(u);"));
        );
        expectScriptThrows(
        assertEquals(0, exec("def u = (int)1; Float b = Float.valueOf((float)1); b.compareTo(u);"));
        assertEquals(0, exec("Long u = Long.valueOf((long)1); def b = Double.valueOf((double)1); b.compareTo(u);"));  
 * KIND, either express or implied.  See the License for the
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = Double.valueOf((double)1); return d} rtn()"));
            ClassCastException.class,
        assertEquals((double) 1, exec("Double rtn() {return Float.valueOf((float)1)} rtn()"));
        assertEquals(0, exec("long u = 1; Double b = Double.valueOf((double)1); b.compareTo(u);"));  
        assertEquals(0, exec("def u = (char)1; def b = Long.valueOf((long)1); b.compareTo(u);"));
 * not use this file except in compliance with the License.
        assertEquals(0, exec("def u = (short)1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
            () -> exec("Double u = Double.valueOf((double)1); Short b = Short.valueOf((short)1); b.compareTo(u);")  
        assertEquals(0, exec("int u = 1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
        assertEquals(0, exec("int u = 1; def b = Float.valueOf((float)1); b.compareTo(u);"));
        assertEquals(1, exec("Integer rtn() {def d = (short)1; return d} rtn()"));
            ClassCastException.class,  
        expectScriptThrows(ClassCastException.class, () -> exec("Long rtn() {def d = Double.valueOf((double)1); return d} rtn()"));
        assertEquals(0, exec("long u = 1; Float b = Float.valueOf((float)1); b.compareTo(u);"));
        assertEquals(0, exec("char u = 1; def b = Integer.valueOf((int)1); b.compareTo(u);"));  
            () -> exec("Short u = Short.valueOf((short)1); Byte b = Byte.valueOf((byte)1); b.compareTo(u);")
        expectScriptThrows(
        expectScriptThrows(  
        expectScriptThrows(ClassCastException.class, () -> exec("long u = 1; def b = Short.valueOf((short)1); b.compareTo(u);"));
        assertEquals((long) 1, exec("Long rtn() {def d = Character.valueOf((char)1); return d} rtn()"));  
            ClassCastException.class,
            ClassCastException.class,  
        assertEquals((long) 1, exec("Long rtn() {def d = (short)1; return d} rtn()"));  
        assertEquals(0, exec("def u = (char)1; def b = Integer.valueOf((int)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Long rtn() {return Double.valueOf((double)1)} rtn()"));  
        assertEquals(0, exec("char u = 1; def b = Long.valueOf((long)1); b.compareTo(u);"));
 * license agreements. See the NOTICE file distributed with
        assertEquals(0, exec("Float u = Float.valueOf((float)1); Float b = Float.valueOf((float)1); b.compareTo(u);"));  
            ClassCastException.class,  
        assertEquals(0, exec("def u = (double)1; def b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals(0, exec("int u = 1; def b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals((float) 1, exec("Float rtn() {return (long)1} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return Float.valueOf((float)1)} rtn()"));  
        assertEquals(0, exec("char u = 1; Character b = Character.valueOf((char)1); b.compareTo(u);"));
    public void testReturnToByteBoxedCasts() {
    }  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (long)1; def b = Character.valueOf((char)1); b.compareTo(u);"));  
 * specific language governing permissions and limitations
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (int)1; def b = Character.valueOf((char)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = (char)1; return d} rtn()"));  
            () -> exec("Double u = Double.valueOf((double)1); Byte b = Byte.valueOf((byte)1); b.compareTo(u);")
        assertEquals((float) 1, exec("Float rtn() {def d = Short.valueOf((short)1); return d} rtn()"));  
        assertEquals(0, exec("byte u = 1; def b = Integer.valueOf((int)1); b.compareTo(u);"));
        assertEquals(1, exec("Integer rtn() {def d = Integer.valueOf((int)1); return d} rtn()"));  
        expectScriptThrows(
        assertEquals((double) 1, exec("Double rtn() {return Long.valueOf((long)1)} rtn()"));  
        assertEquals((float) 1, exec("Float rtn() {return Byte.valueOf((byte)1)} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return (byte)1} rtn()"));
        assertEquals(0, exec("def u = (short)1; Float b = Float.valueOf((float)1); b.compareTo(u);"));
            () -> exec("def u = (short)1; Character b = Character.valueOf((char)1); b.compareTo(u);")  
            ClassCastException.class,
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));  
        expectScriptThrows(
        expectScriptThrows(  
            ClassCastException.class,  
        );  
            ClassCastException.class,
 * compatible open source license.
        assertEquals(0, exec("def u = (byte)1; Short b = Short.valueOf((short)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; def b = Float.valueOf((float)1); b.compareTo(u);"));
        assertEquals((long) 1, exec("Long rtn() {return Byte.valueOf((byte)1)} rtn()"));  
        assertEquals(0, exec("def u = (byte)1; Double b = Double.valueOf((double)1); b.compareTo(u);"));  
            ClassCastException.class,  
        assertEquals(0, exec("float u = 1; Double b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {def d = (char)1; return d} rtn()"));
        );  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (float)1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));  
        assertEquals((char) 1, exec("Character rtn() {return Character.valueOf((char)1)} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; def b = Long.valueOf((long)1); b.compareTo(u);"));  
        expectScriptThrows(
            () -> exec("Double u = Double.valueOf((double)1); Integer b = Integer.valueOf((int)1); b.compareTo(u);")
        assertEquals((float) 1, exec("Float rtn() {def d = Integer.valueOf((int)1); return d} rtn()"));
        assertEquals(0, exec("Short u = Short.valueOf((short)1); def b = Double.valueOf((double)1); b.compareTo(u);"));  
            () -> exec("Short u = Short.valueOf((short)1); def b = Character.valueOf((char)1); b.compareTo(u);")
    }
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (float)1; def b = Short.valueOf((short)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return Short.valueOf((short)1)} rtn()"));
        expectScriptThrows(  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (short)1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));
        );  
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
            () -> exec("Float u = Float.valueOf((float)1); Integer b = Integer.valueOf((int)1); b.compareTo(u);")  
        assertEquals(0, exec("def u = (int)1; def b = Float.valueOf((float)1); b.compareTo(u);"));
            ClassCastException.class,
        );  
        assertEquals(0, exec("def u = (byte)1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));  
        assertEquals((float) 1, exec("Float rtn() {return Long.valueOf((long)1)} rtn()"));
            () -> exec("Byte u = Byte.valueOf((byte)1); Character b = Character.valueOf((char)1); b.compareTo(u);")
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return (float)1} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Float rtn() {def d = (double)1; return d} rtn()"));  
        );
        assertEquals(0, exec("def u = (float)1; def b = Double.valueOf((double)1); b.compareTo(u);"));  
            ClassCastException.class,
        assertEquals(0, exec("byte u = 1; Float b = Float.valueOf((float)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; def b = Short.valueOf((short)1); b.compareTo(u);"));  
            ClassCastException.class,  
            ClassCastException.class,  
        assertEquals(0, exec("def u = (byte)1; def b = Long.valueOf((long)1); b.compareTo(u);"));  
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); Integer b = Integer.valueOf((int)1); b.compareTo(u);"));  
        assertEquals((long) 1, exec("Long rtn() {def d = Short.valueOf((short)1); return d} rtn()"));
        assertEquals((double) 1, exec("Double rtn() {def d = (short)1; return d} rtn()"));
            () -> exec("def u = (float)1; Character b = Character.valueOf((char)1); b.compareTo(u);")
        );
        );  
            ClassCastException.class,
        assertEquals((float) 1, exec("Float rtn() {def d = (byte)1; return d} rtn()"));  
        assertEquals(1, exec("Integer rtn() {def d = (int)1; return d} rtn()"));
            ClassCastException.class,  
        );
        expectScriptThrows(ClassCastException.class, () -> exec("int u = 1; def b = Short.valueOf((short)1); b.compareTo(u);"));  
        assertEquals((byte) 1, exec("Byte rtn() {def d = (byte)1; return d} rtn()"));
        assertEquals(0, exec("Integer u = Integer.valueOf((int)1); def b = Double.valueOf((double)1); b.compareTo(u);"));
            () -> exec("Double u = Double.valueOf((double)1); Long b = Long.valueOf((long)1); b.compareTo(u);")  
        assertEquals(0, exec("def u = (long)1; def b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("long u = 1; def b = Integer.valueOf((int)1); b.compareTo(u);"));
        assertEquals(1, exec("Integer rtn() {return (short)1} rtn()"));
            ClassCastException.class,
        assertEquals(0, exec("def u = (char)1; Float b = Float.valueOf((float)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {def d = (float)1; return d} rtn()"));  
        assertEquals(0, exec("Integer u = Integer.valueOf((int)1); Integer b = Integer.valueOf((int)1); b.compareTo(u);"));  
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); def b = Double.valueOf((double)1); b.compareTo(u);"));
        assertEquals(0, exec("char u = 1; Float b = Float.valueOf((float)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (int)1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));
 * this work for additional information regarding copyright
        assertEquals(1, exec("Integer rtn() {return (char)1} rtn()"));
        assertEquals(0, exec("byte u = 1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
            ClassCastException.class,  
        expectScriptThrows(
 */
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = Byte.valueOf((byte)1); return d} rtn()"));
            () -> exec("Long u = Long.valueOf((long)1); Byte b = Byte.valueOf((byte)1); b.compareTo(u);")
        assertEquals((short) 1, exec("Short rtn() {return (short)1} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; def b = Character.valueOf((char)1); b.compareTo(u);"));
        assertEquals((long) 1, exec("Long rtn() {return Character.valueOf((char)1)} rtn()"));
        assertEquals(0, exec("def u = (char)1; def b = Float.valueOf((float)1); b.compareTo(u);"));
        assertEquals((short) 1, exec("Short rtn() {return Short.valueOf((short)1)} rtn()"));
        assertEquals(0, exec("Character u = Character.valueOf((char)1); def b = Double.valueOf((double)1); b.compareTo(u);"));
    public void testReturnToCharacterBoxedCasts() {
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; def b = Short.valueOf((short)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("float u = 1; Long b = Long.valueOf((long)1); b.compareTo(u);"));  
        expectScriptThrows(
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {return (float)1} rtn()"));
    }
        assertEquals((float) 1, exec("Float rtn() {def d = (short)1; return d} rtn()"));
        assertEquals(0, exec("Character u = Character.valueOf((char)1); def b = Character.valueOf((char)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("char u = 1; def b = Short.valueOf((short)1); b.compareTo(u);"));
            ClassCastException.class,  
        assertEquals((double) 1, exec("Double rtn() {def d = (long)1; return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = Float.valueOf((float)1); return d} rtn()"));
        assertEquals(0, exec("Short u = Short.valueOf((short)1); def b = Short.valueOf((short)1); b.compareTo(u);"));
        expectScriptThrows(
        );
        expectScriptThrows(  
        assertEquals((double) 1, exec("Double rtn() {return (char)1} rtn()"));
    public void testMethodCallCharacterToBoxedCasts() {
    }
        assertEquals(0, exec("Short u = Short.valueOf((short)1); def b = Integer.valueOf((int)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = (byte)1; return d} rtn()"));  
        assertEquals((char) 1, exec("Character rtn() {def d = (char)1; return d} rtn()"));
        );
            () -> exec("Byte u = Byte.valueOf((byte)1); def b = Character.valueOf((char)1); b.compareTo(u);")
        assertEquals((float) 1, exec("Float rtn() {def d = Character.valueOf((char)1); return d} rtn()"));
            ClassCastException.class,  
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = Short.valueOf((short)1); return d} rtn()"));
        assertEquals(0, exec("def u = (char)1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
        assertEquals((float) 1, exec("Float rtn() {return Character.valueOf((char)1)} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("int u = 1; def b = Character.valueOf((char)1); b.compareTo(u);"));
        assertEquals(0, exec("byte u = 1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));
 */  
        expectScriptThrows(ClassCastException.class, () -> exec("long u = 1; Short b = Short.valueOf((short)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("float u = 1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));
            ClassCastException.class,
        expectScriptThrows(
        assertEquals((byte) 1, exec("Byte rtn() {return Byte.valueOf((byte)1)} rtn()"));
        assertEquals((float) 1, exec("Float rtn() {def d = (long)1; return d} rtn()"));
        assertEquals(0, exec("Short u = Short.valueOf((short)1); Float b = Float.valueOf((float)1); b.compareTo(u);"));
            ClassCastException.class,
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {return Integer.valueOf((int)1)} rtn()"));  
    public void testReturnToFloatBoxedCasts() {
        );
        expectScriptThrows(  
        assertEquals(0, exec("def u = (char)1; Double b = Double.valueOf((double)1); b.compareTo(u);"));
 *
            () -> exec("Character u = Character.valueOf((char)1); def b = Short.valueOf((short)1); b.compareTo(u);")
        assertEquals((float) 1, exec("Float rtn() {def d = Byte.valueOf((byte)1); return d} rtn()"));
            ClassCastException.class,
        assertEquals((double) 1, exec("Double rtn() {def d = Long.valueOf((long)1); return d} rtn()"));
        );
        assertEquals(0, exec("def u = (long)1; def b = Float.valueOf((float)1); b.compareTo(u);"));  
        );
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (float)1; Short b = Short.valueOf((short)1); b.compareTo(u);"));
        );  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (char)1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(1, exec("Integer rtn() {return Short.valueOf((short)1)} rtn()"));  
        expectScriptThrows(
        assertEquals(0, exec("Long u = Long.valueOf((long)1); Float b = Float.valueOf((float)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));
        assertEquals(0, exec("def u = (long)1; Long b = Long.valueOf((long)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return (double)1} rtn()"));
            ClassCastException.class,
        assertEquals((short) 1, exec("Short rtn() {return Byte.valueOf((byte)1)} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("int u = 1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));
        assertEquals(0, exec("def u = (short)1; def b = Long.valueOf((long)1); b.compareTo(u);"));
        expectScriptThrows(
            () -> exec("Float u = Float.valueOf((float)1); def b = Long.valueOf((long)1); b.compareTo(u);")
        assertEquals(0, exec("int u = 1; def b = Long.valueOf((long)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; Long b = Long.valueOf((long)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; def b = Character.valueOf((char)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("float u = 1; def b = Integer.valueOf((int)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("float u = 1; Short b = Short.valueOf((short)1); b.compareTo(u);"));  
        assertEquals(0, exec("Short u = Short.valueOf((short)1); Short b = Short.valueOf((short)1); b.compareTo(u);"));  
            () -> exec("Float u = Float.valueOf((float)1); def b = Integer.valueOf((int)1); b.compareTo(u);")
        assertEquals(0, exec("short u = 1; def b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = (int)1; return d} rtn()"));
        assertEquals(0, exec("def u = (int)1; def b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = (double)1; return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("byte u = 1; Character b = Character.valueOf((char)1); b.compareTo(u);"));  
        assertEquals(0, exec("char u = 1; def b = Float.valueOf((float)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {return Long.valueOf((long)1)} rtn()"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return (char)1} rtn()"));
        assertEquals(0, exec("byte u = 1; Long b = Long.valueOf((long)1); b.compareTo(u);"));
        assertEquals(0, exec("def u = (int)1; def b = Long.valueOf((long)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = (long)1; return d} rtn()"));
        assertEquals(0, exec("Short u = Short.valueOf((short)1); Long b = Long.valueOf((long)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {def d = Long.valueOf((long)1); return d} rtn()"));
        );
        expectScriptThrows(ClassCastException.class, () -> exec("long u = 1; Character b = Character.valueOf((char)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("float u = 1; def b = Short.valueOf((short)1); b.compareTo(u);"));
        expectScriptThrows(
            ClassCastException.class,
        expectScriptThrows(ClassCastException.class, () -> exec("Long rtn() {return (double)1} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (long)1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));
        );
            ClassCastException.class,
        expectScriptThrows(ClassCastException.class, () -> exec("float u = 1; Character b = Character.valueOf((char)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {return Double.valueOf((double)1)} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {def d = Long.valueOf((long)1); return d} rtn()"));
        assertEquals(0, exec("Character u = Character.valueOf((char)1); Long b = Long.valueOf((long)1); b.compareTo(u);"));
    }
            ClassCastException.class,  
        assertEquals(0, exec("double u = 1; Double b = Double.valueOf((double)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("Long rtn() {def d = (double)1; return d} rtn()"));
    public void testReturnToShortBoxedCasts() {  
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));
        expectScriptThrows(ClassCastException.class, () -> exec("short u = 1; Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));  
            () -> exec("Float u = Float.valueOf((float)1); Short b = Short.valueOf((short)1); b.compareTo(u);")
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals((float) 1, exec("Float rtn() {def d = (float)1; return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Byte rtn() {return (long)1} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("int u = 1; Character b = Character.valueOf((char)1); b.compareTo(u);"));  
        );  
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {return Float.valueOf((float)1)} rtn()"));
    }
    public void testMethodCallDoubleToBoxedCasts() {  
        expectScriptThrows(ClassCastException.class, () -> exec("Character rtn() {def d = Integer.valueOf((int)1); return d} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (int)1; def b = Short.valueOf((short)1); b.compareTo(u);"));  
        );  
        assertEquals((short) 1, exec("Short rtn() {return (byte)1} rtn()"));
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); def b = Integer.valueOf((int)1); b.compareTo(u);"));
        );  
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {return (int)1} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("def u = (double)1; Integer b = Integer.valueOf((int)1); b.compareTo(u);"));  
        assertEquals((float) 1, exec("Float rtn() {return Integer.valueOf((int)1)} rtn()"));
        expectScriptThrows(ClassCastException.class, () -> exec("Integer rtn() {return (long)1} rtn()"));
        assertEquals(0, exec("Long u = Long.valueOf((long)1); Long b = Long.valueOf((long)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("double u = 1; def b = Float.valueOf((float)1); b.compareTo(u);"));
        assertEquals(0, exec("Byte u = Byte.valueOf((byte)1); Byte b = Byte.valueOf((byte)1); b.compareTo(u);"));  
        expectScriptThrows(ClassCastException.class, () -> exec("Short rtn() {def d = (double)1; return d} rtn()"));
            ClassCastException.class,
        assertEquals(0, exec("byte u = 1; def b = Byte.valueOf((byte)1); b.compareTo(u);"));
        assertEquals(0, exec("int u = 1; Long b = Long.valueOf((long)1); b.compareTo(u);"));
        expectScriptThrows(  
