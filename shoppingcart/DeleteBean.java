package com.shoppingcart;

public class DeleteBean {

	private int Oid;
	private boolean deleted=false;

	public int getOid() {
		return Oid;
	}

	public void setOid(int oid) {
		Oid = oid;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
