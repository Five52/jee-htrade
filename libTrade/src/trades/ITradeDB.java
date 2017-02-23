package trades;

import java.util.ArrayList;

/**
 * An interface for databases of trades.
 */
public interface ITradeDB {

    /**
     * Adds a trade in this database.
     * @param t The new trade to add
     */
    public void insert(Trade t);

    /**
     * Returns the trade with the given id.
     * @param id The id of the trade we search for
     * @return The trade with the given id
     * @throws Exception if no trade exists with the given id in the database
     */
    public Trade get(int id) throws Exception;

    /**
     * Gives the entire list of trades in this database.
     * @return trades The list of trades
     */
    public ArrayList<Trade> getAll();

    /**
     * Updates the trade with the given id.
     * @param id The id of the trade to update
     * @param t The new trade
     * @throws Exception if no trade exists with the given id in the database
     */
    public void update(int id, Trade t) throws Exception;

    /**
     * Removes the trade with the given id from this database.
     * @param id The id of the trade to remove
     * @throws Exception if the given id does not exist in the database
     */
    public void delete(int id) throws Exception;
}
