package dumm;

import java.util.Comparator;

public class EmpRateComparator implements Comparator<Emp> {
    @Override
    public int compare(Emp o1, Emp o2) {
        if( o1.getRate() < o2.getRate()){
            return -1;
        } else if (o1.getRate() > o2.getRate()){
            return 1;
        } else {
            return 1;
        }
    }
}
