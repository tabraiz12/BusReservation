package bus.interfaces;

import java.util.List;
import java.util.Map;
import java.sql.Date;

import bus.beans.BusBean;

public interface Reservation {

	public abstract List<BusBean> getBuses(String s, String s1);

	public abstract List<String> getLayout(String s, String date);

	public abstract String reserveSeat(String s, String as[], String date);
}
