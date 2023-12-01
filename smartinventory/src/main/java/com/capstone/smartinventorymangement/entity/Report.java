package com.capstone.smartinventorymangement.entity;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "report_id", nullable = false, unique = true, length = 3)
    private int reportId;

    
    // just a suggestion, instead of string we can use Enum..
    @Column(name = "month", nullable = false)
    private String month;

    @Column(name = "location", nullable = false)
    private String location;

    
    //these are in number i.e no of item received
    @Column(name = "item_received", nullable = false)
    private int itemReceived;

    @Column(name = "item_delivered", nullable = false)
    private int itemDelivered;

    @Column(name = "items_returned", nullable = false)
    private int itemsReturned;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getItemReceived() {
		return itemReceived;
	}

	public void setItemReceived(int itemReceived) {
		this.itemReceived = itemReceived;
	}

	

	public int getItemDelivered() {
		return itemDelivered;
	}

	public void setItemDelivered(int itemDelivered) {
		this.itemDelivered = itemDelivered;
	}

	public int getItemsReturned() {
		return itemsReturned;
	}

	public void setItemsReturned(int itemsReturned) {
		this.itemsReturned = itemsReturned;
	}

    // Getters and setters
}
