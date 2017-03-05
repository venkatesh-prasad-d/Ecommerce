package com.shoppingcart;

public class AddBean {
private int quantity;
private int price;
boolean operation = false;

private int pid;
private int bid;
private int cid;
private int custid;
private int oid;
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getCustid() {
	return custid;
}
public void setCustid(int custid) {
	this.custid = custid;
}

public boolean isOperation() {
	return operation;
}

public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public void setOperation(boolean operation) {
	// TODO Auto-generated method stub
	this.operation = operation;
}

}
