package com.jquestrade_room;

import java.time.ZonedDateTime;

import androidx.annotation.NonNull;
import androidx.room.Entity;

/** Represents a position in your Questrade account. 
 * @see <a href="https://www.questrade.com/api/documentation/rest-operations/account-calls/accounts-id-positions">
 * The position properties documentation</a>
 */
@Entity(
	tableName = "Positions",
	primaryKeys = {
			"symbol",
			"timeOfCreation",
	}
)
public class Position {
	
	
	private String symbol;
	private int symbolId;
	private int openQuantity;
	private int closedQuantity;
	private double currentMarketValue;
	private double currentPrice;
	private double averageEntryPrice;
	private double dayPnl;
	private double closedPnl;
	private double openPnl;
	private double totalCost;
	private boolean isRealTime;
	private boolean isUnderReorg;
	
	
	
	public Position(String symbol, int symbolId, int openQuantity, int closedQuantity, double currentMarketValue,
			double currentPrice, double averageEntryPrice, double dayPnl, double closedPnl, double openPnl,
			double totalCost, boolean isRealTime, boolean isUnderReorg, ZonedDateTime timeOfCreation) {
		this.symbol = symbol;
		this.symbolId = symbolId;
		this.openQuantity = openQuantity;
		this.closedQuantity = closedQuantity;
		this.currentMarketValue = currentMarketValue;
		this.currentPrice = currentPrice;
		this.averageEntryPrice = averageEntryPrice;
		this.dayPnl = dayPnl;
		this.closedPnl = closedPnl;
		this.openPnl = openPnl;
		this.totalCost = totalCost;
		this.isRealTime = isRealTime;
		this.isUnderReorg = isUnderReorg;
		this.timeOfCreation = timeOfCreation;
	}
	
	@NonNull
	private ZonedDateTime timeOfCreation = ZonedDateTime.now();
	
	/** Returns the time that this object was created.
	 * @return The time that this object was created.
	 */
	public ZonedDateTime timeOfCreation() {
		return timeOfCreation;
	}
	
	/** Returns the symbol of the position.
	 * @return The symbol.
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/** Returns the internal symbol identifier.
	 * @return The internal symbol identifier.
	 */
	public int getSymbolId() {
		return symbolId;
	}
	
	/** Returns the position quantity remaining open.
	 * @return The position quantity that is remaining open.
	 */
	public int getOpenQuantity() {
		return openQuantity;
	}
	
	/** Returns the portion of the position that was closed today.
	 * @return The portion of the position that was closed today.
	 */
	public int getClosedQuantity() {
		return closedQuantity;
	}
	
	/** Returns the current market value of the position (quantity x price).
	 * @return The current market value of the position.
	 */
	public double getCurrentMarketValue() {
		return currentMarketValue;
	}
	
	/** Returns the current price of the position symbol.
	 * @return The current price of the position symbol.
	 */
	public double getCurrentPrice() {
		return currentPrice;
	}
	
	/** Returns the average price paid for all executions constituting the position.
	 * @return The average price for this position.
	 */
	public double getAverageEntryPrice() {
		return averageEntryPrice;
	}
	
	/** Returns the profit-and-loss on this position for today.
	 * @return the profit-and-loss for today.
	 */
	public double getDayPnl() {
		return dayPnl;
	}
	
	/** Return The realized profit/loss on this position.
	 * @return The realized profit/loss on this position.
	 */
	public double getClosedPnl() {
		return closedPnl;
	}
	
	/** Return the total unrealized profit/loss on this position.
	 * @return The total unrealized profit/loss on this position.
	 */
	public double getOpenPnl() {
		return openPnl;
	}
	/** Returns the total cost of the position.
	 * @return The total cost of the position.
	 */
	public double getTotalCost() {
		return totalCost;
	}
	/** Returns whether or not real-time quote was used to compute the profit-and-losses.
	 * @return Whether real-time quote was used to compute the profit-and-losses.
	 */
	public boolean isRealTime() {
		return isRealTime;
	}
	/** Whether or not the symbol is currently undergoing a reorg.
	 * @return Whether the symbol is currently undergoing a reorg.
	 */
	public boolean isUnderReorg() {
		return isUnderReorg;
	}
}
