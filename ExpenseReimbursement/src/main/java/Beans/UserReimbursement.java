package Beans;

import java.sql.Timestamp;

public class UserReimbursement {
   private int reimb_id;
   private double reimb_amount;
   private Timestamp reimb_submitted;   
   private Timestamp reimb_resolved;   
   private String reimb_description;
   private int reimb_author;
   private int reimb_resolver;
   private int reimb_status_id;
   private int type_id;
   

public UserReimbursement() {
	// TODO Auto-generated constructor stub
}


public UserReimbursement(int reimb_id, double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
		String reimb_description, int reimb_author, int reimb_resolver, int reimb_status_id, int type_id) {
	super();
	this.reimb_id = reimb_id;
	this.reimb_amount = reimb_amount;
	this.reimb_submitted = reimb_submitted;
	this.reimb_resolved = reimb_resolved;
	this.reimb_description = reimb_description;
	this.reimb_author = reimb_author;
	this.reimb_resolver = reimb_resolver;
	this.reimb_status_id = reimb_status_id;
	this.type_id = type_id;
}


/**
 * @return the reimb_id
 */
public int getReimb_id() {
	return reimb_id;
}


/**
 * @param reimb_id the reimb_id to set
 */
public void setReimb_id(int reimb_id) {
	this.reimb_id = reimb_id;
}


/**
 * @return the reimb_amount
 */
public double getReimb_amount() {
	return reimb_amount;
}


/**
 * @param reimb_amount the reimb_amount to set
 */
public void setReimb_amount(double reimb_amount) {
	this.reimb_amount = reimb_amount;
}


/**
 * @return the reimb_submitted
 */
public Timestamp getReimb_submitted() {
	return reimb_submitted;
}


/**
 * @param reimb_submitted the reimb_submitted to set
 */
public void setReimb_submitted(Timestamp reimb_submitted) {
	this.reimb_submitted = reimb_submitted;
}


/**
 * @return the reimb_resolved
 */
public Timestamp getReimb_resolved() {
	return reimb_resolved;
}


/**
 * @param reimb_resolved the reimb_resolved to set
 */
public void setReimb_resolved(Timestamp reimb_resolved) {
	this.reimb_resolved = reimb_resolved;
}


/**
 * @return the reimb_description
 */
public String getReimb_description() {
	return reimb_description;
}


/**
 * @param reimb_description the reimb_description to set
 */
public void setReimb_description(String reimb_description) {
	this.reimb_description = reimb_description;
}


/**
 * @return the reimb_author
 */
public int getReimb_author() {
	return reimb_author;
}


/**
 * @param reimb_author the reimb_author to set
 */
public void setReimb_author(int reimb_author) {
	this.reimb_author = reimb_author;
}


/**
 * @return the reimb_resolver
 */
public int getReimb_resolver() {
	return reimb_resolver;
}


/**
 * @param reimb_resolver the reimb_resolver to set
 */
public void setReimb_resolver(int reimb_resolver) {
	this.reimb_resolver = reimb_resolver;
}


/**
 * @return the reimb_status_id
 */
public int getReimb_status_id() {
	return reimb_status_id;
}


/**
 * @param reimb_status_id the reimb_status_id to set
 */
public void setReimb_status_id(int reimb_status_id) {
	this.reimb_status_id = reimb_status_id;
}


/**
 * @return the type_id
 */
public int getType_id() {
	return type_id;
}


/**
 * @param type_id the type_id to set
 */
public void setType_id(int type_id) {
	this.type_id = type_id;
}

public UserReimbursement( double reimb_amount,
		String reimb_description, int reimb_author, int reimb_status_id, int type_id) {
	super();
	this.reimb_amount = reimb_amount;
	this.reimb_description = reimb_description;
	this.reimb_author = reimb_author;
	this.reimb_status_id = reimb_status_id;
	this.type_id = type_id;
}



}