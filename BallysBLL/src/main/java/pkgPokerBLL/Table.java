package pkgPokerBLL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Table {

	private UUID TableID;
	
	private HashMap<UUID, Player> TablePlayers = new HashMap<UUID, Player>();
	
	public Table() {
		super();
		TableID = UUID.randomUUID();
	}
	
	public Table AddPlayerToTable(Player p)
	{
		this.TablePlayers.put(p.getPlayerID(), p);	
		return this;
	}
	
	public Table RemovePlayerFromTable(Player p)
	{
		this.TablePlayers.remove(p.getPlayerID());
		return this;
	}
}
