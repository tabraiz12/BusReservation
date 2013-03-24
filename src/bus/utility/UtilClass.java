package bus.utility;

import java.sql.Date;


public class UtilClass {
	public static String dateConvert(Date date){
		String[] months={"jan","feb","mar","apr","may","jun","jul","Aug","sep","oct","nov","dec"};
		String newDate=date.getDate()+months[date.getMonth()];
		return newDate;
		
	}

}
