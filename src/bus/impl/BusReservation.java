package bus.impl;

import bus.beans.BusBean;
import bus.interfaces.Reservation;
import bus.utility.MyConnection;
import bus.utility.SqlConstraints;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BusReservation implements Reservation {

	Connection con = null;
	PreparedStatement pStat = null;
	ResultSet resultset = null;
	MyConnection myCon;

	public List<BusBean> getBuses(String src, String des) {
		// run the following query to get buses
		// "SELECT BUS_NO FROM BUSES WHERE SOURCE="+src+ "AND DESTINATION="+des
		List<BusBean> buses = new ArrayList<BusBean>();
		try {
			myCon = new MyConnection();
			con = myCon.getMyConnection();
			System.out.println("testing");

			pStat = con.prepareStatement(SqlConstraints.BUS_SEARCH);
			pStat.setString(1, src);
			pStat.setString(2, des);
			//pStat.setString(3, date);
			System.out.println("testing");
			resultset = pStat.executeQuery();
			while (resultset.next()) {
				BusBean bus=new BusBean();
				bus.setBusno(resultset.getString(1));
				bus.setSource(resultset.getString(2));
				bus.setDest(resultset.getString(3));
				bus.setSrctime(resultset.getString(4));
				bus.setDesttime(resultset.getString(5));
				bus.setDate(resultset.getString(6));
				bus.setSeatno(resultset.getString(7));
				buses.add(bus);
						System.out.println("testing resultset");
			}
		} catch (Exception e) {
		} finally {
			try {
				con.close();
				pStat.close();
				resultset.close();
			} catch (Exception e) {
			}
		}
		return buses;
	}

	public List<String> getLayout(String busNo, String date) {
		// run the following query to get buses
		// "SELECT" + date +" FROM "+ busNo
		List< String> seats = new ArrayList< String>();

		try {
			System.out.println("test hukhjihjkho");
			myCon = new MyConnection();
			con = myCon.getMyConnection();
			System.out.println("testconnection");
			pStat = con.prepareStatement("SELECT "+date+" FROM "+busNo);
			//pStat.setString(1, busNo);
			System.out.println("test 111");
			//pStat.setString(1, date.toString());
			resultset = pStat.executeQuery();
			while (resultset.next()) {
				seats.add(resultset.getString(1));
			}
		} catch (Exception e) {
			System.out.println("getLayout"+e);
		} finally {
			try {
				con.close();
				pStat.close();
				resultset.close();
			} catch (Exception e) {
				System.out.println("getLayout11s"+e);
			}
		}
		return seats;
	}

	public String reserveSeat(String busNo, String seats[], String date) {
		// run update query to make seat status as occupied from vacant
		
		String pnr = busNo + date +"/"+ seats[0] ;//+"/"+seats[1] +"/"+seats[2];// write some algorithm for pnr
		// save this pnr with user in user table
		try {
			//System.out.println("test hukhjihjkho");
			myCon = new MyConnection();
			con = myCon.getMyConnection();
			System.out.println("testconnection");
			for(int i=0;i<seats.length;i++)
			{
				System.out.println("test query:"+busNo);
			pStat = con.prepareStatement("update "+busNo+" set "+date+" ='NA' where Seats="+seats[i]+" ");
			//pStat.setString(1, busNo);
			System.out.println("test 111");
			//pStat.setString(1, date.toString());
			pStat.executeUpdate();
			}
			}catch (Exception e) {
				System.out.println("getLayout"+e);
			} finally {
				try {
					con.close();
					pStat.close();
					resultset.close();
				} catch (Exception e) {
					System.out.println("getLayout11s"+e);
				}
			}
		return pnr;
	}

	
}
