package com.auction.model;

import java.io.Serializable;
import java.util.Date;

public class AuctionItem implements Serializable,Comparable<AuctionItem>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _id;
	private String _rev;
	private String itemIDOnSale;
	private String itemName;
	private String itemValue;
	private String productURL;
	private String itemSource;
	private String timeStamp;
	
	public String getItemIDOnSale() {
		return itemIDOnSale;
	}
	public void setItemIDOnSale(String itemIDOnSale) {
		this.itemIDOnSale = itemIDOnSale;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemValue() {
		return itemValue;
	}
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}
	public String getProductURL() {
		return productURL;
	}
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}
	public String getItemSource() {
		return itemSource;
	}
	public void setItemSource(String itemSource) {
		this.itemSource = itemSource;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	
	@Override
	public int compareTo(AuctionItem auctionItem) {
		if(auctionItem.getItemValue()==null){
			return -1;
		}
		if(auctionItem.get_id()!=get_id()){
			return -1;
		}
			
		 try{
			  return Integer.parseInt(auctionItem.getItemValue()) - Integer.parseInt(this.itemValue);
		}catch(NumberFormatException ne){
			return -1;
		}
	}
	

}
