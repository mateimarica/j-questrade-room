package com.jquestrade_room;

import java.time.ZonedDateTime;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/** Represents the overall encompassing balance for an account.
 * Has methods to access per-currency blalances and combined balances.
 * @see <a href="https://www.questrade.com/api/documentation/rest-operations/account-calls/accounts-id-balances">
 * Accounts balances API documentation</a> 
 * for more insight.
 */
@Entity(tableName = "Balances")
public class Balances {
	
	public Balances(ZonedDateTime timeOfCreation, Balance[] perCurrencyBalances, Balance[] combinedBalances,
			Balance[] sodPerCurrencyBalances, Balance[] sodCombinedBalances) {
		this.timeOfCreation = timeOfCreation;
		this.perCurrencyBalances = perCurrencyBalances;
		this.combinedBalances = combinedBalances;
		this.sodPerCurrencyBalances = sodPerCurrencyBalances;
		this.sodCombinedBalances = sodCombinedBalances;
	}

	/** Represents a currency. */
	public enum Currency { 
		/** Represents the Canadian dollar.*/
		CAD, 
		
		/** Represents the U.S. dollar. */
		USD;
	}
	
	
	private Balance[] perCurrencyBalances;
	private Balance[] combinedBalances;
	private Balance[] sodPerCurrencyBalances;
	private Balance[] sodCombinedBalances;
	
	@PrimaryKey
	@NonNull
	private ZonedDateTime timeOfCreation = ZonedDateTime.now();
	
	/** Returns the time that this object was created.
	 * @return The time that this object was created.
	 */
	public ZonedDateTime timeOfCreation() {
		return timeOfCreation;
	}
	
	/** Returns the balance for a particular currency's side of the account.<br>
	 * i.e. {@code getPerCurrencyBalances(Currency.CAD)} would return a {@code Balance}
	 * object that represents only the CAD in the account.
	 * @param currency Which currency to get the account balance for.
	 * @return A {@code Balance} object representing only the account's 
	 * balance that is in the given currency.
	 */
	public Balance getPerCurrencyBalances(Currency currency) {
		if(currency == Currency.CAD) {
			return perCurrencyBalances[0];
		} 
		return perCurrencyBalances[1];
	}
	
	/** Returns an account's total balance in the given currency.
	 * @param currency Which currency to get the total account balance for.
	 * @return A {@code Balance} object representing the account's total balance, 
	 * displayed the given currency.
	 */
	public Balance getCombinedBalances(Currency currency) {
		if(currency == Currency.CAD) {
			return combinedBalances[0];
		} 
		return combinedBalances[1];
	}
	
	/** Returns the balance for a particular currency's side of the account at the 
	 * start-of-day of the most recent trading day.<br>Example: If you get an accounts balances
	 * at 3PM EST on a weekday, this start-of-day balance will represent the balance
	 * at the beginning of that day (in other words, your closing balance of the previous trading day).
	 * @param currency Which currency to get the start-of-day account balance for.
	 * @return A {@code Balance} object representing only the account's start-of-day
	 * balance that is in the given currency.
	 */
	public Balance getSodPerCurrencyBalances(Currency currency) {
		if(currency == Currency.CAD) {
			return sodPerCurrencyBalances[0];
		} 
		return sodPerCurrencyBalances[1];
	}
	
	/** Returns the account's total balance in the given currency at the 
	 * start-of-day of the most recent trading day.<br>Example: If you get an accounts balances
	 * at 3PM EST on a weekday, this start-of-day balance will represent the balance
	 * at the beginning of that day (in other words, your closing balance of the previous trading day).
	 * @param currency Which currency to represent the start-of-day total account balance in.
	 * @return A {@code Balance} object representing the account's start-of-day total balance, 
	 * displayed the given currency.
	 */
	public Balance getSodCombinedBalances(Currency currency) {
		if(currency == Currency.CAD) {
			return sodCombinedBalances[0];
		} 
		return sodCombinedBalances[1];
	}
	
}