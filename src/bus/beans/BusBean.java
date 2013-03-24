package bus.beans;

public class BusBean
{
private String busno;
private String source;
private String dest;
private String srctime;
private String desttime;
private String date;
private String seatno;
public void setBusno(String busno)
{
this.busno=busno;
}
public void setSource(String source)
{
this.source=source;
}
public void setDest(String dest)
{
this.dest=dest;
}
public void setSrctime(String srctime)
{
this.srctime=srctime;
}
public void setDesttime(String desttime)
{
this.desttime=desttime;
}
public void setDate(String date)
{
this.date=date;
}
public void setSeatno(String seatno)
{
this.seatno=seatno;
}
public String getBusno()
{
return busno;
}
public String getSource()
{
return source;
}
public String getDest()
{
return dest;
}
public String getSrctime()
{
return srctime;
}
public String getDesttime()
{
return desttime;
}
public String getDate()
{
return date;
}
public String getSeatno()
{
return seatno;
}

}