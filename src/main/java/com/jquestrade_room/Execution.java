package com.jquestrade_room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/** Represents executions for a specific account. 
 * @see <a href="https://www.questrade.com/api/documentation/rest-operations/account-calls/accounts-id-executions">
 * The executions properties documentation</a>
 */
@Entity(tableName = "Executions")
public class Execution {
	
	
	private String symbol;
	private int symbolId;
	private int quantity;
	private String side;
	private double price;
	private double id;
	private int orderId;
	private int orderChainId;
	private String exchangeExecId;
	
	@PrimaryKey
	@NonNull
	private String timestamp;
	private String notes;
	private String venue;
	private double totalCost;
	private double orderPlacementCommission;
	private double commission;
	private double executionFee;
	private double secFee;
	private int canadianExecutionFee;
	private int parentId;
	
	public Execution(String symbol, int symbolId, int quantity, String side, double price, double id, int orderId,
			int orderChainId, String exchangeExecId, String timestamp, String notes, String venue, double totalCost,
			double orderPlacementCommission, double commission, double executionFee, double secFee,
			int canadianExecutionFee, int parentId) {
		this.symbol = symbol;
		this.symbolId = symbolId;
		this.quantity = quantity;
		this.side = side;
		this.price = price;
		this.id = id;
		this.orderId = orderId;
		this.orderChainId = orderChainId;
		this.exchangeExecId = exchangeExecId;
		this.timestamp = timestamp;
		this.notes = notes;
		this.venue = venue;
		this.totalCost = totalCost;
		this.orderPlacementCommission = orderPlacementCommission;
		this.commission = commission;
		this.executionFee = executionFee;
		this.secFee = secFee;
		this.canadianExecutionFee = canadianExecutionFee;
		this.parentId = parentId;
	}

	/** Returns the symbol of the security involved in the execution.
	 * @return The symbol of the security involved in the execution.
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/** Returns the internal symbol identifier of the security involved in the execution.
	 * @return The internal symbol identifier
	 */
	public int getSymbolId() {
		return symbolId;
	}
	
	/** Returns the number of shares in the execution.
	 * @return The number of shares in the execution.
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/** Returns the client side of the order to which the execution belongs. 
	 * Example values: Buy, Sell, Short, BTO, etc..
	 * @return The client side of the order to which the execution belongs.
	 * @see <a href="https://www.questrade.com/api/documentation/rest-operations/enumerations/enumerations#order-side">
	 * The Client Order Side</a>
	 * section for all possible values.
	 */
	public String getSide() {
		return side;
	}
	
	/** Returns the execution price.
	 * @return The execution price.
	 */
	public double getPrice() {
		return price;
	}
	
	/** Returns the internal identifier of the execution.
	 * @return The internal identifier of the execution.
	 */
	public double getId() {
		return id;
	}
	
	/** Returns the internal identifier of the order to which the execution belongs.
	 * @return The internal identifier of the order to which the execution belongs.
	 */
	public int getOrderId() {
		return orderId;
	}
	
	/** Returns the internal identifier of the order chain to which the execution belongs.
	 * @return The internal identifier of the order chain to which the execution belongs.
	 */
	public int getOrderChainId() {
		return orderChainId;
	}
	
	/** Returns the identifier of the execution at the market where it originated.
	 * @return The identifier of the execution at the market where it originated.
	 */
	public String getExchangeExecId() {
		return exchangeExecId;
	}
	
	/** Returns the execution timestamp in ISO 8601 format.
	 * @return The execution timestamp.
	 */
	public String getTimestamp() {
		return timestamp;
	}
	
	/** Returns manual notes for the execution that may have been entered by Trade Desk staff.
	 * This is usually blank.
	 * @return Manual execution notes.
	 */
	public String getNotes() {
		return notes;
	}
	/** Returns the trading venue where execution originated.
	 * @return The trading venue where execution originated.
	 */
	public String getVenue() {
		return venue;
	}
	
	/** Returns the execution cost (price x quantity).
	 * @return The execution cost.
	 */
	public double getTotalCost() {
		return totalCost;
	}
	
	/** Returns the Questrade commission for orders placed with Trade Desk.
	 * @return The order placement commission.
	 */
	public double getOrderPlacementCommission() {
		return orderPlacementCommission;
	}
	
	/** Returns the Questrade commission for the execution.
	 * @return The commission.
	 */
	public double getCommission() {
		return commission;
	}
	
	/** Returns the liquidity fee charged by execution venue.
	 * @return The liquidity fee.
	 */
	public double getExecutionFee() {
		return executionFee;
	}
	
	/** Returns the SEC fee charged on all sales of US securities.
	 * @return The SEC fee.
	 */
	public double getSecFee() {
		return secFee;
	}
	
	/** Returns any additional execution fee charged by TSX (if applicable).
	 * @return The additional execution fee charged by the TSX.
	 */
	public int getCanadianExecutionFee() {
		return canadianExecutionFee;
	}
	
	/** Returns the internal identifier of the parent order.
	 * @return The internal identifier of the parent order.
	 */
	public int getParentId() {
		return parentId;
	}
}
