
package com.capstone.smartinventorymanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "return_items")
public class Return extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "return_id", nullable = false, unique = true, length = 3)
    private Integer returnId;

    @ManyToOne
    @JoinColumn(name = "godown_id", nullable = false)
//     we have to map it with godown id, so that we can access details of godown
    private Godown returnGodownId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "date_of_return", nullable = false)
    private LocalDate dateOfReturn;

    @Column(name = "return_quantity", nullable = false)
    private int returnQuantity;

    @Column(name = "checked_by", nullable = false)
    private String checkedBy;

    @Column(name = "return_reason", nullable = false)
    private String returnReason;

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public LocalDate getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(LocalDate dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	public int getReturnQuantity() {
		return returnQuantity;
	}

	public void setReturnQuantity(int returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	public String getCheckedBy() {
		return checkedBy;
	}

	public void setCheckedBy(String checkedBy) {
		this.checkedBy = checkedBy;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

    // Getters and setters
}

