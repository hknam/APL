/**
 * Created by hknam on 16. 5. 6.
 */
public class Pair<T1, T2>{
    T1 t1;
    T2 t2;

    public Pair(T1 t1, T2 t2){
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Pair other = (Pair)obj;

        if (t1 != null ? !t1.equals(other.t1) : other.t2 != null) {
            return false;
        }

        if (t2 != null ? !t2.equals(other.t2) : other.t2 != null) {
            return false;
        }

        return true;
    }


    @Override
    public int hashCode() {
        int result = t1 != null? t1.hashCode() : 0;
        result = 31 * result + (t2 != null ? t2.hashCode() : 0);
        return result;
    }


}
