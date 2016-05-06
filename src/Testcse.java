/**
 * Created by hknam on 16. 5. 6.
 */
public class Testcse{

    public static void main(String[] args){
        DynamicClassProvider.register("Trident", "M", "kr.cnu.plas.apl.Printable1");
        Object o = DynamicClassProvider.newInstance("Trident", "M");
        ((IPrintable)o).printName();

    }


}
