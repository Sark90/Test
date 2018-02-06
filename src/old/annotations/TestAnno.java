package old.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyAnno(str = "123 abc", i = 0)
@MyAnno2
public class TestAnno {
    String s = "Info";
    int i = 99;

/*    @MyAnno(str = "123", i = 1)
    public String str() {
        return str;
    }*/
    @MyAnno(str = "abc", i = 2)
    public void showStr() {
        //System.out.println(str());
        TestAnno ta = new TestAnno();
        try {
            Class<?> c = ta.getClass();
            Method m = c.getMethod("showStr");
            Field f = null;
            try {
                f = c.getDeclaredField("s");
            } catch (NoSuchFieldException e) {
                System.out.println(e);
            }
            MyAnno an = m.getAnnotation(MyAnno.class);
            System.out.println("Class: " + c + "\nMethod: " + m + "\nField s: " + f
                    + "\nAnnotation fields: " + an.str() + ",\t" + an.i());
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }
}
