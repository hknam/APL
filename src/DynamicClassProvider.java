import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * Created by hknam on 16. 5. 6.
 */
public class DynamicClassProvider{
    static Map<Pair<String,String>, String> m_cls = new HashMap<Pair<String, String>, String>();
    static Map< Pair<String,String>, Object> m_cache = new LinkedHashMap<Pair<String,String>, Object>();


    public static void register(String nick, String creator, String path){

        m_cls.put(new Pair<String, String>(nick, creator), path);

    }

    public static Object newInstance(String nick, String creator) {
        Pair<String, String> key = new Pair<String, String>(nick, creator);

        Object obj = null;
        Class cls = null;

        if(m_cache.containsKey(key)){
            return m_cache.get(key);
        }
        else{

            try {
                cls = Class.forName(m_cls.get(key));
                try {
                    obj = cls.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }

            m_cache.put(key, obj);
            return obj;
        }

    }

    public void printName(){
        System.out.println(m_cls);

    }


}
