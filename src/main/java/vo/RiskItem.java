package vo;

import java.util.Date;

public class RiskItem {
  Date date=null;
  String name="";
  String type="";
  String possible="";
  String influence="";
  String commit="";
  String follow="";
  boolean isNew=false;
  String status="";
  String soluting="";
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPossible() {
	return possible;
}
public void setPossible(String possible) {
	this.possible = possible;
}
public String getInfluence() {
	return influence;
}
public void setInfluence(String influence) {
	this.influence = influence;
}
public String getCommit() {
	return commit;
}
public void setCommit(String commit) {
	this.commit = commit;
}
public String getFollow() {
	return follow;
}
public void setFollow(String follow) {
	this.follow = follow;
}
public boolean isNew() {
	return isNew;
}
public void setNew(boolean isNew) {
	this.isNew = isNew;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getSoluting() {
	return soluting;
}
public void setSoluting(String soluting) {
	this.soluting = soluting;
}
  
  
}
