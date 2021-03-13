package com.jquestrade_room;

import androidx.room.Entity;

/** Represents historical market data in the form of 
 * OHLC candlesticks for a specified symbol.
 * @see <a href="https://www.questrade.com/api/documentation/rest-operations/market-calls/markets-candles-id">
 * Candles API documentation</a> 
 * for more insight.
 */
@Entity(
	tableName = "Candles",
	primaryKeys = {
			"start",
			"end",
			"symbol"
	}
)
public class Candle {
	
	private String start;
	private String end;
	private double low;
	private double high;
	private double open;
	private double close;
	private int volume;
	private double VWAP;
	private String symbol;
	
	public Candle(String start, String end, double low, double high, double open, double close, int volume, double VWAP,
			String symbol) {
		this.start = start;
		this.end = end;
		this.low = low;
		this.high = high;
		this.open = open;
		this.close = close;
		this.volume = volume;
		this.VWAP = VWAP;
		this.symbol = symbol;
	}

	
	
	/** Represents an interval for a set of candles. 
	 * @see <a href="https://www.questrade.com/api/documentation/rest-operations/enumerations/enumerations#historical-data-granularity">
	 * The Historical Data Granularity (candle interval) documentation</a>
	 */
	public enum Interval {
		OneMinute,
		TwoMinutes,
		ThreeMinutes,
		FourMinutes,
		FiveMinutes,
		TenMinutes,
		FifteenMinutes,
		TwentyMinutes,
		HalfHour,
		OneHour,
		TwoHours,
		FourHours,
		OneDay,
		OneWeek,
		OneMonth,
		OneYear
	}
	
	/** Returns the candlestick start timestamp (in ISO format).
	 * @return Candlestick start timestamp.
	 */
	public String getStart() {
		return start;
	}
	
	/** Returns the candlestick end timestamp (in ISO format).
	 * @return Candlestick end timestamp.
	 */
	public String getEnd() {
		return end;
	}
	
	/** Returns the lowest price during this candle.
	 * @return The lowest price during this candle.
	 */
	public double getLow() {
		return low;
	}
	
	/** Returns the highest price during this candle.
	 * @return The highest price during this candle.
	 */
	public double getHigh() {
		return high;
	}
	
	/** Returns the opening price for this candle.
	 * @return The opening price for this candle.
	 */
	public double getOpen() {
		return open;
	}
	
	/** Returns the closing price for this candle.
	 * @return The closing price for this candle.
	 */
	public double getClose() {
		return close;
	}
	
	/** Returns the trading volume for this candle.
	 * @return The trading volume for this candle.
	 */
	public int getVolume() {
		return volume;
	}
	
	/** Returns the Volume Weighted Average Price.
	 * @return The VWAP.
	 * @see <a href="https://www.investopedia.com/terms/v/vwap.asp">
	 * The definition and the formula for VWAP on investopedia.com</a> 
	 */
	public double getVWAP() {
		return VWAP;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
