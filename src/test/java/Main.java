import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;

public class Main {

    class A{
        void a(){
            System.out.println("aaaaa");
        }
    }

    class B{
        void b(){
            System.out.println("bbbbb");
        }
    }

    public static class C<A,B>{
        void ccc(){
            Type[] types = this.getClass().getTypeParameters();
            System.out.println(JSONObject.toJSONString(types));
        }
    }

    public static void main(String[] args){
        C c = new C();
        c.ccc();
    }
}
