package com.patchingscheduler.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class UtilityBean {
	HashMap<Integer,Date> dtq_dateList = new HashMap<Integer, Date>();
	HashMap<Integer,Date> prod_dateList = new HashMap<Integer, Date>();
	HashMap<Integer,Date> winDtq = new HashMap<Integer, Date>();
	ArrayList<ServerBean> dtq_servers = new ArrayList<ServerBean>();
	ArrayList<ServerBean> prod_sa = new ArrayList<ServerBean>();
	ArrayList<ServerBean> prod_ws = new ArrayList<ServerBean>();
	ArrayList<ServerBean> win_dtq = new ArrayList<ServerBean>();
	ArrayList<ServerBean> win_odd = new ArrayList<ServerBean>();
	ArrayList<ServerBean> win_even = new ArrayList<ServerBean>();
	ArrayList<ServerBean> schedule = new ArrayList<ServerBean>();
	public HashMap<Integer, Date> getDtq_dateList() {
		return dtq_dateList;
	}
	public void setDtq_dateList(HashMap<Integer, Date> dtq_dateList) {
		this.dtq_dateList = dtq_dateList;
	}
	public HashMap<Integer, Date> getProd_dateList() {
		return prod_dateList;
	}
	public void setProd_dateList(HashMap<Integer, Date> prod_dateList) {
		this.prod_dateList = prod_dateList;
	}
	public ArrayList<ServerBean> getDtq_servers() {
		return dtq_servers;
	}
	public void setDtq_servers(ArrayList<ServerBean> dtq_servers) {
		this.dtq_servers = dtq_servers;
	}
	public ArrayList<ServerBean> getProd_sa() {
		return prod_sa;
	}
	public void setProd_sa(ArrayList<ServerBean> prod_sa) {
		this.prod_sa = prod_sa;
	}
	public ArrayList<ServerBean> getProd_ws() {
		return prod_ws;
	}
	public void setProd_ws(ArrayList<ServerBean> prod_ws) {
		this.prod_ws = prod_ws;
	}
	public ArrayList<ServerBean> getSchedule() {
		return schedule;
	}
	public void setSchedule(ArrayList<ServerBean> schedule) {
		this.schedule = schedule;
	}
	public HashMap<Integer, Date> getWinDtq() {
		return winDtq;
	}
	public void setWinDtq(HashMap<Integer, Date> winDtq) {
		this.winDtq = winDtq;
	}
	public ArrayList<ServerBean> getWin_dtq() {
		return win_dtq;
	}
	public void setWin_dtq(ArrayList<ServerBean> win_dtq) {
		this.win_dtq = win_dtq;
	}
	public ArrayList<ServerBean> getWin_odd() {
		return win_odd;
	}
	public void setWin_odd(ArrayList<ServerBean> win_odd) {
		this.win_odd = win_odd;
	}
	public ArrayList<ServerBean> getWin_even() {
		return win_even;
	}
	public void setWin_even(ArrayList<ServerBean> win_even) {
		this.win_even = win_even;
	}
	
}
