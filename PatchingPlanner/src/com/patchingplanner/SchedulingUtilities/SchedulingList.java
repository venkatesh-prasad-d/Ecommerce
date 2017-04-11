package com.patchingplanner.SchedulingUtilities;

import java.util.ArrayList;
import java.util.Date;

import com.patchinplanner.bean.ServerBean;

public class SchedulingList {
	public static ArrayList<Date> dtqDates;
	public static ArrayList<Date> prodDates;
	public static ArrayList<ServerBean> ilm_dtq = new ArrayList<ServerBean>();
	public static ArrayList<ServerBean> ss_dtq = new ArrayList<ServerBean>();
	public static ArrayList<ServerBean> vp_dtq = new ArrayList<ServerBean>();
	public static ArrayList<ServerBean> ilm_prod = new ArrayList<ServerBean>();
	public static ArrayList<ServerBean> ss_prod = new ArrayList<ServerBean>();
	public static ArrayList<ServerBean> vp_prod = new ArrayList<ServerBean>();
	public static ArrayList<ServerBean> getIlm_dtq() {
		return ilm_dtq;
	}
	public static void setIlm_dtq(ArrayList<ServerBean> ilm_dtq) {
		SchedulingList.ilm_dtq = ilm_dtq;
	}
	public static ArrayList<ServerBean> getSs_dtq() {
		return ss_dtq;
	}
	public static void setSs_dtq(ArrayList<ServerBean> ss_dtq) {
		SchedulingList.ss_dtq = ss_dtq;
	}
	public static ArrayList<ServerBean> getVp_dtq() {
		return vp_dtq;
	}
	public static void setVp_dtq(ArrayList<ServerBean> vp_dtq) {
		SchedulingList.vp_dtq = vp_dtq;
	}
	public static ArrayList<ServerBean> getIlm_prod() {
		return ilm_prod;
	}
	public static void setIlm_prod(ArrayList<ServerBean> ilm_prod) {
		SchedulingList.ilm_prod = ilm_prod;
	}
	public static ArrayList<ServerBean> getSs_prod() {
		return ss_prod;
	}
	public static void setSs_prod(ArrayList<ServerBean> ss_prod) {
		SchedulingList.ss_prod = ss_prod;
	}
	public static ArrayList<ServerBean> getVp_prod() {
		return vp_prod;
	}
	public static void setVp_prod(ArrayList<ServerBean> vp_prod) {
		SchedulingList.vp_prod = vp_prod;
	}
	public static ArrayList<Date> getDtqDates() {
		return dtqDates;
	}
	public static void setDtqDates(ArrayList<Date> dtqDates) {
		SchedulingList.dtqDates = dtqDates;
	}
	public static ArrayList<Date> getProdDates() {
		return prodDates;
	}
	public static void setProdDates(ArrayList<Date> prodDates) {
		SchedulingList.prodDates = prodDates;
	}
}
