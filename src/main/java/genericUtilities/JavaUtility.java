package genericUtilities;


import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	/**
	 * this method will capture the system date in required
	 * format and return it caller
	 * @return
	 */

	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date=sdf.format(d);
		return date;
	}

}
